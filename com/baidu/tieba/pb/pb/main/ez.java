package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ez {
    public static int epp = 2;
    public static int epq = 3;
    public static int epr = 0;
    public static int eps = 3;
    public static int ept = 4;
    public static int epu = 5;
    public static int epv = 6;
    private com.baidu.tbadk.editortools.j DX;
    private ViewStub aUU;
    private TbImageView aUV;
    private boolean adc;
    private aa.b afI;
    private TextView apT;
    private View azE;
    private View bAe;
    private View.OnClickListener bHz;
    private NoNetworkView bxs;
    private RelativeLayout dTs;
    private View.OnClickListener egm;
    private com.baidu.tieba.pb.a.d egn;
    private PbActivity ehi;
    PbActivity.c eiG;
    private PbFakeFloorModel ejW;
    private FrameLayout enB;
    private com.baidu.tieba.pb.video.d enC;
    private c.InterfaceC0072c enE;
    private com.baidu.tieba.pb.video.a enF;
    private com.baidu.tieba.play.c enG;
    private com.baidu.tieba.pb.video.b enH;
    private TextView enI;
    public final com.baidu.tieba.pb.pb.main.view.f enK;
    public com.baidu.tieba.pb.pb.main.view.d enL;
    private ViewStub enM;
    private ViewStub enN;
    private List<com.baidu.tieba.pb.pb.main.view.a> enO;
    private View enP;
    private LinearLayout enT;
    private g enU;
    private dj enV;
    private ColumnLayout enW;
    private ThreadSkinView enX;
    private TextView enY;
    private FrameLayout enZ;
    public int enz;
    private PbListView eoA;
    private View eoC;
    private HeadPendantView eoa;
    private HeadImageView eob;
    private ImageView eoc;
    private ImageView eod;
    private UserIconBox eoe;
    private UserIconBox eog;
    private View eoh;
    private FloatingLayout eoi;
    private EntelechyUserLikeButton eom;
    private ex eon;
    private LinearLayout eoo;
    private TextView eop;
    private TextView eoq;
    private View eor;
    private View eos;
    private ObservedChangeLinearLayout eou;
    private cq eov;
    private com.baidu.tieba.d.a epA;
    private com.baidu.tieba.d.a epB;
    private View epJ;
    private EntelechyUserLikeButton epK;
    private ClickableHeaderImageView epL;
    private TbImageView epM;
    private FrameLayout epN;
    private TextView epO;
    private LinearLayout epP;
    private boolean epQ;
    private f epR;
    private com.baidu.tbadk.core.view.userLike.c epS;
    private com.baidu.tbadk.core.view.userLike.c epT;
    private Runnable epW;
    private PbActivity.a epY;
    private View epb;
    private TextView epc;
    private TextView epd;
    private ViewGroup epe;
    private TextView epf;
    private boolean eph;
    private View epk;
    private TextView epl;
    private ViewStub epm;
    private PbInterviewStatusView epn;
    private Runnable epw;
    private Runnable epx;
    private FloatingLayout epy;
    private dd epz;
    private boolean eqa;
    private boolean eqb;
    private BdTypeListView mListView;
    private int enA = 1;
    private boolean enD = false;
    private int enJ = 0;
    private final Handler mHandler = new Handler();
    private View enQ = null;
    private LinearLayout enR = null;
    private TextView enS = null;
    private TextView eoj = null;
    private TextView eok = null;
    public FrsPraiseView eol = null;
    private ClickableHeaderImageView emp = null;
    private View eot = null;
    private com.baidu.tbadk.core.dialog.a eow = null;
    private com.baidu.tbadk.core.dialog.c bHq = null;
    private View eox = null;
    private EditText eoy = null;
    private com.baidu.tieba.pb.view.m eoz = null;
    private com.baidu.tieba.pb.view.b eoB = null;
    private c.b cXu = null;
    private TbRichTextView.e aHX = null;
    private NoNetworkView.a bEW = null;
    private Dialog eoD = null;
    private View eoE = null;
    private com.baidu.tbadk.core.dialog.a eoF = null;
    private Dialog eoG = null;
    private View eoH = null;
    private int eoI = 0;
    private RadioGroup GF = null;
    private RadioButton eoJ = null;
    private RadioButton eoK = null;
    private RadioButton eoL = null;
    private Button eoM = null;
    private Button eoN = null;
    private TextView eoO = null;
    private Dialog eoP = null;
    private View eoQ = null;
    private LinearLayout eoR = null;
    private CompoundButton.OnCheckedChangeListener eoS = null;
    private TextView eoT = null;
    private TextView eoU = null;
    private String eoV = null;
    private com.baidu.tbadk.core.dialog.c eoW = null;
    private boolean eoX = false;
    private boolean eoY = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eoZ = null;
    private boolean doq = false;
    private Button epa = null;
    private boolean epg = true;
    private com.baidu.tbadk.core.view.a epi = null;
    private boolean egi = false;
    private boolean epj = false;
    private boolean mIsFromCDN = true;
    private int epo = 0;
    private a.InterfaceC0074a epC = new fa(this);
    private boolean epD = false;
    private boolean ehO = false;
    private boolean epE = false;
    private LinearLayout epF = null;
    private TextView epG = null;
    private int epH = 0;
    private boolean epI = false;
    private boolean epU = false;
    private int rank = 0;
    private Animation.AnimationListener dvW = new fk(this);
    private Handler epV = new Handler();
    private CustomMessageListener epX = new ft(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean epZ = true;
    private boolean eqc = false;
    private boolean TF = false;
    String userId = null;
    private final List<TbImageView> eqd = new ArrayList();
    private boolean eqe = false;
    private Runnable bJK = new gf(this);

    public f aNm() {
        return this.epR;
    }

    public NoNetworkView aNn() {
        return this.bxs;
    }

    public boolean isFullScreen() {
        return this.ehO;
    }

    public void aNo() {
        if (this.DX != null) {
            this.DX.hide();
        }
    }

    public PbFakeFloorModel aNp() {
        return this.ejW;
    }

    public dd aNq() {
        return this.epz;
    }

    public void aNr() {
        reset();
        this.epg = true;
        if (this.DX != null) {
            this.DX.hide();
        }
        this.epz.aLG();
        if (this.epb != null) {
            if (this.doq) {
                gM(false);
            } else {
                gN(false);
            }
        }
        aLT();
    }

    private void reset() {
        if (this.ehi != null && this.ehi.aKK() != null && this.DX != null) {
            com.baidu.tbadk.editortools.pb.a.CT().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aKK = this.ehi.aKK();
            aKK.Dn();
            if (aKK.getWriteImagesInfo() != null) {
                aKK.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aKK.eM(10);
            aKK.eK(SendView.ALL);
            aKK.eL(SendView.ALL);
            com.baidu.tbadk.editortools.p eB = this.DX.eB(23);
            com.baidu.tbadk.editortools.p eB2 = this.DX.eB(2);
            com.baidu.tbadk.editortools.p eB3 = this.DX.eB(5);
            if (eB2 != null) {
                eB2.lr();
            }
            if (eB3 != null) {
                eB3.lr();
            }
            if (eB != null) {
                eB.hide();
            }
            this.DX.invalidate();
        }
    }

    public boolean aNs() {
        return this.epg;
    }

    public void gM(boolean z) {
        if (this.epb != null && this.epc != null && this.epd != null) {
            this.epc.setText(r.l.draft_to_send);
            this.epd.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.epb.startAnimation(alphaAnimation);
            }
            this.epb.setVisibility(0);
        }
    }

    public void gN(boolean z) {
        if (this.epb != null && this.epc != null && this.epd != null) {
            this.epc.setText(r.l.reply_floor_host);
            this.epd.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.epb.startAnimation(alphaAnimation);
            }
            this.epb.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.p aNt() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.mListView == null) {
            return null;
        }
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.mListView.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.mListView.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.mListView.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.eov.os(headerViewsCount) != null && this.eov.os(headerViewsCount) != com.baidu.tieba.tbadkCore.data.p.fpL) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.p) this.eov.getItem(i2);
    }

    public ez(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.ehi = null;
        this.dTs = null;
        this.bAe = null;
        this.mListView = null;
        this.enP = null;
        this.enT = null;
        this.enW = null;
        this.enY = null;
        this.enZ = null;
        this.eoa = null;
        this.eob = null;
        this.eoc = null;
        this.eod = null;
        this.eoe = null;
        this.eog = null;
        this.eoh = null;
        this.eom = null;
        this.eor = null;
        this.eos = null;
        this.eov = null;
        this.eoA = null;
        this.azE = null;
        this.bHz = null;
        this.egm = null;
        this.epb = null;
        this.epc = null;
        this.epe = null;
        this.epf = null;
        this.epk = null;
        this.epl = null;
        this.epm = null;
        this.ehi = pbActivity;
        this.bHz = onClickListener;
        this.egn = dVar;
        this.dTs = (RelativeLayout) LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.new_pb_activity, (ViewGroup) null);
        this.ehi.addContentView(this.dTs, new FrameLayout.LayoutParams(-1, -1));
        this.bAe = this.ehi.findViewById(r.h.statebar_view);
        this.eou = (ObservedChangeLinearLayout) this.ehi.findViewById(r.h.title_wrapper);
        this.bxs = (NoNetworkView) this.ehi.findViewById(r.h.view_no_network);
        this.mListView = (BdTypeListView) this.ehi.findViewById(r.h.new_pb_list);
        this.apT = new TextView(this.ehi.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.ehi.getActivity(), r.f.ds98));
        this.mListView.addHeaderView(this.apT, 0);
        View view = new View(this.ehi.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.ehi.getResources().getDimensionPixelSize(r.f.ds100)));
        view.setVisibility(4);
        this.mListView.addFooterView(view);
        this.mListView.setOnTouchListener(this.ehi.aIu);
        this.enK = new com.baidu.tieba.pb.pb.main.view.f(pbActivity);
        this.epA = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.enK.eqT);
        this.epA.gZ(3);
        this.enV = new dj(this.ehi, this.dTs);
        this.enV.init();
        this.enV.a(this.enV.aLU(), this.bHz);
        if (this.ehi.aLh()) {
            this.enM = (ViewStub) this.ehi.findViewById(r.h.manga_view_stub);
            this.enM.setVisibility(0);
            this.enL = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
            this.enL.show();
            this.enK.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.apT.setLayoutParams(layoutParams);
        this.enK.aOw().setOnTouchListener(new com.baidu.tieba.pb.a.a(new gg(this)));
        this.epb = this.ehi.findViewById(r.h.pb_editor_tool_comment);
        this.epc = (TextView) this.ehi.findViewById(r.h.pb_editor_tool_comment_reply_text);
        this.epe = (ViewGroup) this.ehi.findViewById(r.h.pb_editor_tool_comment_reply_layout);
        this.epf = (TextView) this.ehi.findViewById(r.h.pb_editor_tool_comment_praise_icon);
        boolean ap = com.baidu.tieba.graffiti.c.ap(this.epf);
        if (ap) {
            iS(ap);
            this.epf.setVisibility(0);
        }
        this.epd = (TextView) this.ehi.findViewById(r.h.pb_editor_tool_comment_reply_count_text);
        this.epe.setOnClickListener(new gh(this));
        this.epf.setOnClickListener(this.bHz);
        this.epf.setOnTouchListener(this.ehi);
        this.enP = LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.new_pb_header_item, (ViewGroup) null);
        this.enT = (LinearLayout) LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.new_pb_header_user_item, (ViewGroup) null);
        this.enU = new g(this.ehi, this.enT);
        this.enU.init();
        this.enU.a(this.enU.aKJ(), this.bHz);
        this.enW = (ColumnLayout) this.enT.findViewById(r.h.pb_head_owner_root);
        this.epy = (FloatingLayout) this.enT.findViewById(r.h.pb_head_owner_info_root);
        this.enX = (ThreadSkinView) this.enT.findViewById(r.h.pb_thread_skin);
        this.enW.setOnLongClickListener(this.onLongClickListener);
        this.enW.setOnTouchListener(this.egn);
        this.enW.setVisibility(8);
        this.enP.setOnTouchListener(this.egn);
        this.epk = this.enP.findViewById(r.h.pb_head_activity_join_number_container);
        this.epk.setVisibility(8);
        this.epl = (TextView) this.enP.findViewById(r.h.pb_head_activity_join_number);
        this.enY = (TextView) this.enW.findViewById(r.h.pb_head_owner_info_user_name);
        this.enZ = (FrameLayout) this.enW.findViewById(r.h.pb_head_headImage_container);
        this.eob = (HeadImageView) this.enW.findViewById(r.h.pb_head_owner_photo);
        this.eoa = (HeadPendantView) this.enW.findViewById(r.h.pb_pendant_head_owner_photo);
        this.aUU = (ViewStub) this.enW.findViewById(r.h.viewstub_headimage_mask);
        this.eoa.vS();
        if (this.eoa.getHeadView() != null) {
            this.eoa.getHeadView().setIsRound(true);
            this.eoa.getHeadView().setDrawBorder(false);
        }
        if (this.eoa.getPendantView() != null) {
            this.eoa.getPendantView().setIsRound(true);
            this.eoa.getPendantView().setDrawBorder(false);
        }
        this.eoc = (ImageView) this.enW.findViewById(r.h.pb_head_owner_info_user_rank);
        this.eod = (ImageView) this.enW.findViewById(r.h.pb_head_owner_info_user_bawu);
        this.eoe = (UserIconBox) this.enW.findViewById(r.h.pb_head_owner_info_user_icon);
        this.eog = (UserIconBox) this.enW.findViewById(r.h.pb_head_owner_info_tshow_icon);
        this.eoi = (FloatingLayout) this.enT.findViewById(r.h.pb_head_owner_info_root);
        this.eom = (EntelechyUserLikeButton) this.enW.findViewById(r.h.pb_like_button);
        this.eon = new ex(pbActivity.getPageContext(), this.eom);
        this.epS = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.epT = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eor = this.enP.findViewById(r.h.new_pb_header_item_line_above_livepost);
        this.eos = this.enP.findViewById(r.h.new_pb_header_item_line_below_livepost);
        this.enP.setOnLongClickListener(new gi(this));
        this.epm = (ViewStub) this.dTs.findViewById(r.h.interview_status_stub);
        this.eov = new cq(this.ehi, this.mListView);
        this.eov.w(this.bHz);
        this.eov.a(this.egn);
        this.eov.setOnImageClickListener(this.aHX);
        this.egm = new gj(this);
        this.eov.I(this.egm);
        aNv();
        this.mListView.addHeaderView(this.enR);
        this.mListView.addHeaderView(this.enT);
        this.mListView.addHeaderView(this.enP);
        this.eoA = new PbListView(this.ehi.getPageContext().getPageActivity());
        this.azE = this.eoA.getView().findViewById(r.h.pb_more_view);
        if (this.azE != null) {
            this.azE.setOnClickListener(this.bHz);
            com.baidu.tbadk.core.util.ap.j(this.azE, r.g.pb_foot_more_trans_selector);
        }
        this.eoA.wd();
        this.eoA.dj(r.g.pb_foot_more_trans_selector);
        this.eoA.dk(r.g.pb_foot_more_trans_selector);
        this.eoC = this.ehi.findViewById(r.h.viewstub_progress);
        this.ehi.registerListener(this.epX);
        this.eoh = com.baidu.tbadk.ala.c.np().f(this.ehi.getActivity(), 2);
        if (this.eoh != null) {
            this.eoh.setVisibility(8);
            this.eoi.addView(this.eoh, 2);
        }
        this.ejW = new PbFakeFloorModel(this.ehi.getPageContext());
        this.epz = new dd(this.ehi.getPageContext(), this.ejW, this.dTs);
        this.ejW.a(new gk(this));
    }

    public void aNu() {
        if (this.mListView != null) {
            this.mListView.removeHeaderView(this.enR);
            this.mListView.removeHeaderView(this.enT);
            this.mListView.removeHeaderView(this.enP);
        }
    }

    private void aNv() {
        if (this.enR == null) {
            int e = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds32);
            int e2 = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds40);
            this.enR = new LinearLayout(this.ehi.getPageContext().getPageActivity());
            this.enR.setOrientation(1);
            this.enR.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.enR.setPadding(0, e2, 0, e2);
            this.enR.setGravity(17);
            this.enS = new TextView(this.ehi.getPageContext().getPageActivity());
            this.enS.setGravity(3);
            this.enS.setMaxLines(2);
            this.enS.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_c));
            this.enS.setPadding(e, 0, e, 0);
            com.baidu.tbadk.core.util.ap.i((View) this.enS, r.e.cp_cont_b);
            this.enS.setTextSize(0, e2);
            this.enS.setVisibility(8);
            this.enR.addView(this.enS);
            this.enR.setOnTouchListener(this.egn);
            this.enR.setOnLongClickListener(new fb(this));
        }
    }

    private void aNw() {
        this.enB = (FrameLayout) this.ehi.findViewById(r.h.root_float_header);
        int I = com.baidu.adp.lib.util.k.I(this.ehi.getActivity());
        int i = (int) (I * 0.5625d);
        this.enB.setLayoutParams(new RelativeLayout.LayoutParams(I, i));
        this.enG = new com.baidu.tieba.play.c(this.ehi.getPageContext(), this.enB);
        this.enC = new com.baidu.tieba.pb.video.d(this.ehi, this.enG);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ehi.getActivity(), r.a.anim_alpha_1_to_0_duration_2000);
        if (this.enE == null) {
            this.enE = new fc(this, loadAnimation);
        }
        this.enC.a(this.enE);
        if (this.mListView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mListView.getLayoutParams();
            layoutParams.topMargin = i;
            this.mListView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNx() {
        if (this.ehi.aLh()) {
            this.enN = (ViewStub) this.ehi.findViewById(r.h.manga_mention_controller_view_stub);
            this.enN.setVisibility(0);
            if (this.eoo == null) {
                this.eoo = (LinearLayout) this.ehi.findViewById(r.h.manga_controller_layout);
                com.baidu.tbadk.i.a.a(this.ehi.getPageContext(), this.eoo);
            }
            if (this.eop == null) {
                this.eop = (TextView) this.eoo.findViewById(r.h.manga_prev_btn);
            }
            if (this.eoq == null) {
                this.eoq = (TextView) this.eoo.findViewById(r.h.manga_next_btn);
            }
            this.eop.setOnClickListener(this.bHz);
            this.eoq.setOnClickListener(this.bHz);
        }
    }

    private void aNy() {
        if (this.ehi.aLh()) {
            if (this.ehi.aLk() == -1) {
                com.baidu.tbadk.core.util.ap.c(this.eop, r.e.cp_cont_e, 1);
            }
            if (this.ehi.aLl() == -1) {
                com.baidu.tbadk.core.util.ap.c(this.eoq, r.e.cp_cont_e, 1);
            }
        }
    }

    public void aNz() {
        if (this.eoo == null) {
            aNx();
        }
        this.enN.setVisibility(8);
        if (this.epV != null && this.epW != null) {
            this.epV.removeCallbacks(this.epW);
        }
    }

    public void aNA() {
        if (this.epV != null) {
            if (this.epW != null) {
                this.epV.removeCallbacks(this.epW);
            }
            this.epW = new fd(this);
            this.epV.postDelayed(this.epW, 2000L);
        }
    }

    public void iM(boolean z) {
        this.enK.iM(z);
        if (z && this.epj) {
            this.eoA.setText(this.ehi.getResources().getString(r.l.click_load_more));
            this.mListView.setNextPage(this.eoA);
            this.enJ = 2;
        }
    }

    public void aNB() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.dTs.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.DX = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dTs.addView(this.DX, layoutParams);
        this.DX.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.DX.hide();
    }

    public void aNC() {
        if (this.ehi != null && this.DX != null) {
            this.DX.lr();
        }
    }

    public void or(String str) {
        if (this.epd != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.epd.setText(this.ehi.getPageContext().getResources().getString(r.l.pb_reply_count_text, str));
        }
    }

    public void O(String str, boolean z) {
        this.eph = z;
        iN(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void iN(boolean z) {
        if (this.epf != null) {
            if (this.eph) {
                com.baidu.tbadk.core.util.ap.j((View) this.epf, r.g.pb_praise_already_click_selector);
                this.epf.setContentDescription(this.ehi.getResources().getString(r.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ap.j((View) this.epf, r.g.pb_praise_normal_click_selector);
            this.epf.setContentDescription(this.ehi.getResources().getString(r.l.frs_item_praise_text));
        }
    }

    public TextView aND() {
        return this.epf;
    }

    public void iO(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
                return;
            }
            if (this.epx == null) {
                this.epx = new fe(this, z);
            }
            com.baidu.adp.lib.g.h.eE().postDelayed(this.epx, 10L);
        }
    }

    public void iP(boolean z) {
        if (this.mListView != null && this.apT != null && this.bAe != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bAe.setVisibility(0);
                    aNQ();
                } else {
                    this.bAe.setVisibility(8);
                    this.mListView.removeHeaderView(this.apT);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.apT.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.apT.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.apT.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + iX(true);
                this.apT.setLayoutParams(layoutParams2);
            }
            aNQ();
            aOn();
        }
    }

    public void bc(View view) {
        boolean z;
        View view2;
        if (this.eou != null && view != null) {
            if (this.epg) {
                z = this.epb.getVisibility() == 0;
            } else {
                z = this.DX != null && this.DX.getVisibility() == 0;
            }
            boolean z2 = this.eou.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.ehO = true;
                View findViewById = this.ehi.findViewById(r.h.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.eou.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.ehi, this.eou, r.a.top_fold_up, new ff(this, findViewById));
            } else {
                this.ehO = false;
                com.baidu.tieba.tbadkCore.a.a(this.ehi, this.eou, r.a.top_fold_down, new fg(this));
            }
            if (this.epg) {
                view2 = this.epb;
            } else {
                view2 = this.DX;
            }
            if (z) {
                if (z2) {
                    if (this.DX != null) {
                        this.DX.AK();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.ehi, view2, r.a.bottom_fold_down, new fh(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.ehi, view2, r.a.bottom_fold_up, new fi(this));
            }
            aLT();
        }
    }

    public cq aNE() {
        return this.eov;
    }

    public void aNF() {
        if (this.eov != null) {
            this.eov.aLy();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eiG = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bm bmVar) {
        if (bmVar == null || bmVar.sI() == 0) {
            if (this.epa != null) {
                this.epa.setVisibility(8);
            }
            if (this.eor != null) {
                this.eor.setVisibility(8);
                return;
            }
            return;
        }
        if (this.epa == null) {
            this.ehi.getLayoutMode().v(((ViewStub) this.enP.findViewById(r.h.live_talk_layout)).inflate());
            this.epa = (Button) this.enP.findViewById(r.h.pb_head_function_manage_go_to_live_post);
            this.eor = this.enP.findViewById(r.h.new_pb_header_item_line_above_livepost);
        }
        int sJ = bmVar.sJ();
        String string = this.ehi.getPageContext().getString(r.l.go_to_live_post_prefix);
        if (sJ == 0) {
            string = String.valueOf(string) + this.ehi.getPageContext().getString(r.l.go_to_interview_post);
        } else if (sJ == 1) {
            string = String.valueOf(string) + this.ehi.getPageContext().getString(r.l.go_to_discuss_post);
        }
        this.epa.setText(string);
        this.epa.setVisibility(0);
        this.epa.setOnClickListener(this.bHz);
        this.eqb = true;
        aNS();
    }

    public void bd(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.eoE == null) {
            this.eoE = LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.ehi.getLayoutMode().v(this.eoE);
        if (this.eoD == null) {
            this.eoD = new Dialog(this.ehi.getPageContext().getPageActivity(), r.m.common_alert_dialog);
            this.eoD.setCanceledOnTouchOutside(true);
            this.eoD.setCancelable(true);
            this.eoD.setContentView(this.eoE);
            WindowManager.LayoutParams attributes = this.eoD.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.I(this.ehi.getPageContext().getPageActivity()) * 0.9d);
            this.eoD.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eoD.findViewById(r.h.del_post_btn);
        TextView textView2 = (TextView) this.eoD.findViewById(r.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eoD.findViewById(r.h.disable_reply_btn);
        int intValue = sparseArray.get(r.h.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(r.h.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(r.h.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(r.h.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(r.h.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(r.l.delete);
            } else {
                textView.setText(r.l.delete_post);
            }
            sparseArray2.put(r.h.tag_del_post_id, sparseArray.get(r.h.tag_del_post_id));
            sparseArray2.put(r.h.tag_del_post_type, sparseArray.get(r.h.tag_del_post_type));
            sparseArray2.put(r.h.tag_del_post_is_self, sparseArray.get(r.h.tag_del_post_is_self));
            sparseArray2.put(r.h.tag_manage_user_identity, sparseArray.get(r.h.tag_manage_user_identity));
            textView.setOnClickListener(new fj(this));
        }
        if ("".equals(sparseArray.get(r.h.tag_forbid_user_name)) || aOj()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(r.h.tag_forbid_user_name, sparseArray.get(r.h.tag_forbid_user_name));
            sparseArray5.put(r.h.tag_manage_user_identity, sparseArray.get(r.h.tag_manage_user_identity));
            sparseArray5.put(r.h.tag_forbid_user_post_id, sparseArray.get(r.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new fl(this));
        }
        if (!((sparseArray.get(r.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(r.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(r.l.un_mute);
            } else {
                textView3.setText(r.l.mute);
            }
            sparseArray6.put(r.h.tag_is_mem, sparseArray.get(r.h.tag_is_mem));
            sparseArray6.put(r.h.tag_user_mute_mute_userid, sparseArray.get(r.h.tag_user_mute_mute_userid));
            sparseArray6.put(r.h.tag_user_mute_mute_username, sparseArray.get(r.h.tag_user_mute_mute_username));
            sparseArray6.put(r.h.tag_user_mute_post_id, sparseArray.get(r.h.tag_user_mute_post_id));
            sparseArray6.put(r.h.tag_user_mute_thread_id, sparseArray.get(r.h.tag_user_mute_thread_id));
            sparseArray6.put(r.h.tag_user_mute_msg, sparseArray.get(r.h.tag_user_mute_msg));
            textView3.setOnClickListener(new fm(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.eoD, this.ehi.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.epY = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.h.tag_del_post_id, str);
        sparseArray.put(r.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(r.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(r.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(epr, Integer.valueOf(eps));
        int i3 = r.l.del_post_confirm;
        if (i == 0) {
            i3 = r.l.del_thread_confirm;
        }
        this.eoF = new com.baidu.tbadk.core.dialog.a(this.ehi.getActivity());
        this.eoF.ca(i3);
        this.eoF.A(sparseArray);
        this.eoF.a(r.l.dialog_ok, this.ehi);
        this.eoF.b(r.l.dialog_cancel, new fn(this));
        this.eoF.au(true);
        this.eoF.b(this.ehi.getPageContext());
        this.eoF.sV();
    }

    public void al(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eoQ == null) {
            this.eoQ = LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.commit_good, (ViewGroup) null);
        }
        this.ehi.getLayoutMode().v(this.eoQ);
        if (this.eoP == null) {
            this.eoP = new Dialog(this.ehi.getPageContext().getPageActivity(), r.m.common_alert_dialog);
            this.eoP.setCanceledOnTouchOutside(true);
            this.eoP.setCancelable(true);
            this.eoZ = (ScrollView) this.eoQ.findViewById(r.h.good_scroll);
            this.eoP.setContentView(this.eoQ);
            WindowManager.LayoutParams attributes = this.eoP.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds540);
            this.eoP.getWindow().setAttributes(attributes);
            this.eoS = new fo(this);
            this.eoR = (LinearLayout) this.eoQ.findViewById(r.h.good_class_group);
            this.eoU = (TextView) this.eoQ.findViewById(r.h.dialog_button_cancel);
            this.eoU.setOnClickListener(new fp(this));
            this.eoT = (TextView) this.eoQ.findViewById(r.h.dialog_button_ok);
            this.eoT.setOnClickListener(this.bHz);
        }
        this.eoR.removeAllViews();
        this.enO = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bU = bU("0", this.ehi.getPageContext().getString(r.l.def_good_class));
        this.enO.add(bU);
        bU.setChecked(true);
        this.eoR.addView(bU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bU2 = bU(String.valueOf(arrayList.get(i2).pW()), arrayList.get(i2).pV());
                this.enO.add(bU2);
                View view = new View(this.ehi.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds1));
                com.baidu.tbadk.core.util.ap.k(view, r.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eoR.addView(view);
                this.eoR.addView(bU2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eoZ.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ehi.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ehi.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ehi.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eoZ.setLayoutParams(layoutParams2);
            this.eoZ.removeAllViews();
            this.eoZ.addView(this.eoR);
        }
        com.baidu.adp.lib.g.j.a(this.eoP, this.ehi.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bU(String str, String str2) {
        Activity pageActivity = this.ehi.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.e(pageActivity, r.f.ds100));
        aVar.setOnCheckedChangeListener(this.eoS);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aNG() {
        this.ehi.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.ehi.hideProgressBar();
        if (z && z2) {
            this.ehi.showToast(this.ehi.getPageContext().getString(r.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(r.l.neterror);
            }
            this.ehi.showToast(str);
        }
    }

    public void ase() {
        this.eoC.setVisibility(0);
    }

    public void asd() {
        this.eoC.setVisibility(8);
    }

    public View aNH() {
        if (this.eoQ != null) {
            return this.eoQ.findViewById(r.h.dialog_button_ok);
        }
        return null;
    }

    public String aNI() {
        return this.eoV;
    }

    public View getView() {
        return this.dTs;
    }

    public void aNJ() {
        com.baidu.adp.lib.util.k.b(this.ehi.getPageContext().getPageActivity(), this.ehi.getCurrentFocus());
    }

    public void iQ(boolean z) {
        this.ehi.hideProgressBar();
        axs();
    }

    public void aNK() {
        this.eoA.wk();
    }

    public void aNL() {
        this.ehi.hideProgressBar();
        this.eoA.wl();
        aIO();
        this.mListView.completePullRefreshPostDelayed(2000L);
        aNS();
    }

    public void aNM() {
        this.mListView.completePullRefreshPostDelayed(2000L);
        aNS();
    }

    public void iR(boolean z) {
        this.enV.f(this.enV.aLU(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.epe.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.ehi.getResources().getDimensionPixelSize(r.f.ds84) : 0;
        this.epe.setLayoutParams(marginLayoutParams);
    }

    private void iS(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds14);
        if (z) {
            i = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds16);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.epe.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.epe.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tbadk.core.data.af afVar) {
        this.enV.b(afVar);
    }

    public boolean aLR() {
        return this.enV.aLR();
    }

    public void aLS() {
        this.enV.aLS();
    }

    public void aLT() {
        this.enV.aLT();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eov.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.eoW != null) {
            this.eoW.dismiss();
            this.eoW = null;
        }
        this.eoW = new com.baidu.tbadk.core.dialog.c(this.ehi.getPageContext().getPageActivity());
        this.eoW.cd(r.l.operation);
        if (z2) {
            this.eoW.a(new String[]{this.ehi.getPageContext().getString(r.l.copy)}, bVar);
        } else if (!z) {
            this.eoW.a(new String[]{this.ehi.getPageContext().getString(r.l.copy), this.ehi.getPageContext().getString(r.l.mark)}, bVar);
        } else {
            this.eoW.a(new String[]{this.ehi.getPageContext().getString(r.l.copy), this.ehi.getPageContext().getString(r.l.remove_mark)}, bVar);
        }
        this.eoW.d(this.ehi.getPageContext());
        this.eoW.sY();
    }

    public int aNN() {
        return oG(this.mListView.getFirstVisiblePosition());
    }

    private int oG(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.mListView.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.km()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.mListView.getAdapter() == null || !(this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aNO() {
        return oG(this.mListView.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.mListView.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eoy.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.f fVar) {
        this.eov.b(fVar);
        this.eov.notifyDataSetChanged();
        if (fVar == null) {
            or("");
        } else {
            or(com.baidu.tbadk.core.util.at.w(fVar.aJZ().rp()));
        }
        aNS();
    }

    public void k(com.baidu.tieba.pb.data.f fVar) {
        PraiseData rn;
        if (this.eol == null) {
            this.ehi.getLayoutMode().v(((ViewStub) this.enP.findViewById(r.h.praise_layout)).inflate());
            this.eol = (FrsPraiseView) this.enP.findViewById(r.h.pb_head_praise_view);
            this.eol.setIsFromPb(true);
            this.eot = this.enP.findViewById(r.h.new_pb_header_item_line_above_praise);
            this.eol.dp(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.eol != null) {
            boolean aNS = aNS();
            if (fVar != null && fVar.aKb() != null && fVar.aKb().size() > 0) {
                com.baidu.tieba.tbadkCore.data.p pVar = fVar.aKb().get(0);
                if ((!this.egi || pVar.bhQ() != 1) && (rn = fVar.aJZ().rn()) != null && rn.getUser() != null && rn.getUser().size() > 0) {
                    this.eol.setVisibility(0);
                    this.eol.setIsFromPb(true);
                    this.eol.a(rn, fVar.aJZ().getId(), rn.getPostId(), true);
                    this.eol.getVisibility();
                    com.baidu.tieba.graffiti.c.ap(this.eol);
                    return;
                }
            }
            this.eol.setVisibility(8);
            if (fVar != null && fVar.getPage() != null && fVar.getPage().qy() == 0 && this.egi) {
                if (aNS) {
                    this.eos.setVisibility(0);
                } else {
                    this.eos.setVisibility(8);
                }
            } else {
                this.eos.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.ap(this.eos);
        }
    }

    private com.baidu.tieba.tbadkCore.data.p a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aKi() != null) {
            return fVar.aKi();
        }
        if (z) {
            if (fVar == null || fVar.aKb() == null || fVar.aKb().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.p pVar = fVar.aKb().get(0);
            if (pVar.bhQ() != 1) {
                pVar = a(fVar);
            }
            if (pVar.getAuthor() != null && pVar.getAuthor().getUserTbVipInfoData() != null && pVar.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                pVar.getAuthor().getGodUserData().setIntro(pVar.getAuthor().getUserTbVipInfoData().getvipIntro());
                return pVar;
            }
            return pVar;
        }
        return a(fVar);
    }

    private com.baidu.tieba.tbadkCore.data.p a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aJZ() == null || fVar.aJZ().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.p pVar = new com.baidu.tieba.tbadkCore.data.p();
        MetaData author = fVar.aJZ().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aJZ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        pVar.rV(1);
        pVar.setId(fVar.aJZ().rM());
        pVar.setTitle(fVar.aJZ().getTitle());
        pVar.setTime(fVar.aJZ().getCreateTime());
        pVar.setAuthor(metaData);
        return pVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v306, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        boolean z2;
        int i2;
        if (fVar != null && fVar.aJZ() != null) {
            this.epy.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds30), 0, 0);
            com.baidu.tieba.tbadkCore.data.p a2 = a(fVar, z);
            if (a2 != null && a2.rR() != null) {
                String str = null;
                if (this.ehi.aLr()) {
                    str = "FRS";
                }
                this.enX.a(this.ehi.getPageContext(), fVar.aKb().get(0).rR(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aJY().getId(), fVar.aJY().getName(), fVar.aJZ().getId(), str));
                this.enW.setPadding(this.enW.getPaddingLeft(), (int) this.ehi.getResources().getDimension(r.f.ds20), this.enW.getPaddingRight(), this.enW.getPaddingBottom());
            } else {
                this.enX.a(null, null, null);
            }
            aOk();
            this.enW.setVisibility(8);
            if (fVar.aJZ() != null && fVar.aJZ().si() && fVar.aJZ().rN() != null) {
                if (this.enC == null || this.enG == null) {
                    aNw();
                    this.enC.a(fVar.aJZ().rN(), fVar.aJZ(), fVar.getForumId());
                    this.enC.startPlay();
                } else if (this.enD) {
                    this.enC.a(fVar.aJZ().rN(), fVar.aJZ(), fVar.getForumId());
                    this.enC.startPlay();
                }
                if (fVar.aKa() != null && fVar.aKa().size() >= 1) {
                    com.baidu.tbadk.core.data.bh bhVar = fVar.aKa().get(0);
                    this.enC.I(bhVar);
                    this.enC.oG(bhVar.getTitle());
                }
                this.enD = false;
                if (this.enF == null) {
                    this.enF = new com.baidu.tieba.pb.video.a(LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.pb_header_video_abstract_layout, (ViewGroup) null));
                }
                this.enF.H(fVar.aJZ());
                this.mListView.removeHeaderView(this.enF.mRootView);
                this.mListView.addHeaderView(this.enF.mRootView, 0);
                if (fVar.aJZ().sz() != null) {
                    if (this.enH == null) {
                        this.enH = new com.baidu.tieba.pb.video.b(this.ehi, LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.video_pb_video_channel_info_layout, (ViewGroup) null));
                    }
                    com.baidu.tbadk.core.data.bo sz = fVar.aJZ().sz();
                    if (fVar.getUserData() != null) {
                        sz.Uu = fVar.aKr();
                    }
                    this.enH.b(sz);
                    fVar.aJZ().a(sz);
                    this.mListView.removeHeaderView(this.enH.mRootView);
                    this.mListView.removeHeaderView(this.enT);
                    this.mListView.addHeaderView(this.enH.mRootView, 1);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enF.etj.getLayoutParams();
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds26);
                    this.enF.etj.setLayoutParams(layoutParams);
                } else {
                    if (this.enH != null && this.enH.mRootView != null) {
                        this.mListView.removeHeaderView(this.enH.mRootView);
                    }
                    if (com.baidu.adp.lib.b.e.dL().ac("video_channel_pb_portrait_switch") == 0) {
                        if (this.enI == null) {
                            this.enI = new TextView(this.ehi.getActivity());
                            this.enI.setClickable(true);
                            this.enI.setTextSize(0, this.ehi.getResources().getDimensionPixelSize(r.f.fontsize24));
                            AbsListView.LayoutParams layoutParams2 = new AbsListView.LayoutParams(-1, -2);
                            this.enI.setSingleLine(true);
                            this.enI.setEllipsize(TextUtils.TruncateAt.END);
                            this.enI.setLayoutParams(layoutParams2);
                            this.enI.setGravity(16);
                            int e = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds32);
                            this.enI.setPadding(e, 0, e, com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds40));
                            com.baidu.tbadk.core.util.ap.c(this.enI, r.e.cp_cont_j, 1);
                        }
                        this.mListView.removeHeaderView(this.enT);
                        this.mListView.removeHeaderView(this.enI);
                        String string = this.ehi.getResources().getString(r.l.video_public_owner);
                        StringBuilder sb = new StringBuilder();
                        sb.append(string);
                        if (a2 != null && a2.getAuthor() != null) {
                            String name_show = a2.getAuthor().getName_show();
                            this.enI.setTag(r.h.tag_user_id, String.valueOf(a2.getAuthor().getUserId()));
                            this.enI.setTag(r.h.tag_user_name, name_show);
                            sb.append(" " + name_show);
                            SpannableString spannableString = new SpannableString(sb);
                            spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_a)), string.length(), sb.length(), 33);
                            this.enI.setText(spannableString);
                        } else {
                            this.enI.setText(string);
                        }
                        this.mListView.addHeaderView(this.enI, 1);
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.enF.etj.getLayoutParams();
                        layoutParams3.bottomMargin = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds30);
                        this.enF.etj.setLayoutParams(layoutParams3);
                    } else {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.enF.etj.getLayoutParams();
                        layoutParams4.bottomMargin = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds26);
                        this.enF.etj.setLayoutParams(layoutParams4);
                        if (this.enI != null) {
                            this.mListView.removeHeaderView(this.enI);
                        }
                        this.mListView.removeHeaderView(this.enT);
                        this.enW.setPadding(this.enW.getPaddingLeft(), this.enW.getPaddingTop(), this.enW.getPaddingRight(), com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds34));
                        if (this.eom.getLayoutParams() instanceof ColumnLayout.a) {
                            ColumnLayout.a aVar = (ColumnLayout.a) this.eom.getLayoutParams();
                            aVar.bottomMargin = com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds20);
                            this.eom.setLayoutParams(aVar);
                        }
                        this.mListView.addHeaderView(this.enT, 1);
                    }
                }
                this.enK.aOB();
                aNQ();
                z2 = true;
            } else {
                if (this.enB != null) {
                    this.enB.setVisibility(8);
                }
                if (this.enF != null) {
                    this.mListView.removeHeaderView(this.enF.mRootView);
                }
                if (this.enH != null) {
                    this.mListView.removeHeaderView(this.enH.mRootView);
                }
                z2 = false;
            }
            if (this.ehi.aKN() != null) {
                this.ehi.aKN().jb(z2);
            }
            fq fqVar = new fq(this, z2);
            if (this.enI != null) {
                this.enI.setOnClickListener(fqVar);
            }
            if (a2 != null) {
                String str2 = null;
                boolean z3 = false;
                if (fVar != null && fVar.aJZ() != null && fVar.aJZ().getAuthor() != null) {
                    str2 = fVar.aJZ().getAuthor().getUserId();
                    if (fVar.getPage() != null) {
                        this.epH = fVar.getPage().qu();
                        z3 = fVar.getPage().qx() == 1;
                    }
                }
                boolean sh = fVar.aJZ().sh();
                if (a2.getAuthor() != null && a2.getAuthor().getUserTbVipInfoData() != null) {
                    this.adc = !StringUtils.isNull(a2.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.epD = !sh && a(fVar, a2, fVar.aJZ().getId(), str2, z3, z);
                this.enW.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.enW.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.enW.setTag(sparseArray);
                }
                sparseArray.put(r.h.tag_clip_board, a2);
                sparseArray.put(r.h.tag_is_subpb, false);
                fVar.aJZ().se();
                if (!this.epQ) {
                    this.enR.setVisibility(0);
                }
                if (!fVar.aJZ().si() && this.enS.getText() != null && this.enS.getText().length() > 0) {
                    this.enS.setVisibility(0);
                } else {
                    this.enS.setVisibility(8);
                }
                k(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rH = fVar.aJZ().rH();
                if (rH != null && rH.size() > 0 && !this.epQ) {
                    this.epl.setText(String.valueOf(rH.get(0).oW()));
                    this.epk.setVisibility(0);
                    this.eqa = true;
                } else {
                    this.epk.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ap.j(this.epk, r.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.ap.c(this.epl, r.e.cp_link_tip_d, 1);
                if (a2.getAuthor() != null) {
                    this.rank = a2.getAuthor().getLevel_id();
                    int is_bawu = a2.getAuthor().getIs_bawu();
                    String bawu_type = a2.getAuthor().getBawu_type();
                    int i3 = 3;
                    if (this.rank != 0) {
                        this.eoc.setVisibility(0);
                        com.baidu.tbadk.core.util.ap.c(this.eoc, BitmapHelper.getGradeResourceIdNew(this.rank));
                        this.eoc.setAlpha(179);
                        this.eoc.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.l.degree_in_forum), Integer.valueOf(this.rank)));
                        this.eoc.setOnClickListener(null);
                    } else {
                        this.eoc.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.eod.setAlpha(179);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ap.c(this.eod, r.g.pb_manager);
                            this.eoc.setVisibility(8);
                            this.eod.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ap.c(this.eod, r.g.pb_assist);
                            this.eoc.setVisibility(8);
                            this.eod.setVisibility(0);
                        }
                    }
                    String string2 = a2.getAuthor().getName_show() == null ? StringUtils.string(a2.getAuthor().getUserName()) : StringUtils.string(a2.getAuthor().getName_show());
                    if (StringUtils.isNull(a2.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aQ(a2.getAuthor().getSealPrefix()) + 2;
                    }
                    if (!StringUtils.isNull(string2)) {
                        int aQ = com.baidu.adp.lib.util.j.aQ(a2.getAuthor().getName_show());
                        if (aQ + i2 > 14) {
                            i3 = 0;
                        } else if (aQ + i2 >= 12) {
                            i3 = 1;
                        } else if (aQ + i2 >= 10) {
                            i3 = 2;
                            if (is_bawu == 0) {
                                i3 = 1;
                            }
                        }
                    }
                    ArrayList<IconData> iconInfo = a2.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = a2.getAuthor().getTShowInfoNew();
                    if (this.eoe != null) {
                        this.eoe.setTag(r.h.tag_user_id, a2.getAuthor().getUserId());
                        this.eoe.setOnClickListener(this.ehi.ehW.bPI);
                        this.eoe.wy();
                        this.eoe.a(iconInfo, i3, this.ehi.getResources().getDimensionPixelSize(r.f.ds30), this.ehi.getResources().getDimensionPixelSize(r.f.ds30), this.ehi.getResources().getDimensionPixelSize(r.f.ds10));
                    }
                    if (this.eog != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.eog.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.eog.setOnClickListener(this.ehi.ehW.eqz);
                        this.eog.a(tShowInfoNew, 3, this.ehi.getResources().getDimensionPixelSize(r.f.ds32), this.ehi.getResources().getDimensionPixelSize(r.f.ds32), this.ehi.getResources().getDimensionPixelSize(r.f.ds8), true);
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aQ(string2) > 12) {
                            string2 = com.baidu.tbadk.core.util.at.d(string2, 12, "...");
                        }
                    } else if (com.baidu.adp.lib.util.j.aQ(string2) > 14) {
                        string2 = com.baidu.tbadk.core.util.at.d(string2, 14, "...");
                    }
                    this.enY.setText(ag(a2.getAuthor().getSealPrefix(), string2));
                    this.enY.setTag(r.h.tag_user_id, a2.getAuthor().getUserId());
                    this.enY.setTag(r.h.tag_user_name, a2.getAuthor().getName_show());
                    if (!com.baidu.tbadk.core.util.w.s(tShowInfoNew)) {
                        com.baidu.tbadk.core.util.ap.c(this.enY, r.e.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ap.c(this.enY, r.e.cp_cont_f, 1);
                    }
                    if (fVar.aJZ().getAuthor() != null && fVar.aJZ().getAuthor().getAlaUserData() != null && this.eoh != null) {
                        if (fVar.aJZ().getAuthor().getAlaUserData().anchor_live == 0 && fVar.aJZ().getAuthor().getAlaUserData().enter_live == 0) {
                            this.eoh.setVisibility(8);
                        } else {
                            this.eoh.setVisibility(0);
                            com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                            bVar.Lv = fVar.aJZ().getAuthor().getAlaUserData();
                            bVar.type = 2;
                            this.eoh.setTag(bVar);
                        }
                    }
                    this.eob.setUserId(a2.getAuthor().getUserId());
                    this.eob.setUserName(a2.getAuthor().getUserName());
                    this.eob.setImageDrawable(null);
                    this.eob.setRadius(com.baidu.adp.lib.util.k.e(this.ehi.getActivity(), r.f.ds40));
                    this.eob.setTag(a2.getAuthor().getUserId());
                    this.eon.a(a2.getAuthor());
                    this.eon.eny = z2;
                    if (!PbNormalLikeButtonSwitchStatic.Gc() || this.eoY || (a2.getAuthor().hadConcerned() && a2.getAuthor().getGodUserData() != null && a2.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.eom.setVisibility(8);
                    } else {
                        this.eom.setVisibility(0);
                    }
                    String portrait = a2.getAuthor().getPortrait();
                    if (a2.getAuthor() != null && a2.getAuthor().getPendantData() != null && !StringUtils.isNull(a2.getAuthor().getPendantData().pL())) {
                        this.eob.setVisibility(8);
                        this.eoa.setVisibility(0);
                        if (this.emp != null) {
                            this.emp.setVisibility(8);
                        }
                        this.enY.setOnClickListener(fqVar);
                        this.eoa.getHeadView().c(portrait, 28, false);
                        this.eoa.getHeadView().setUserId(a2.getAuthor().getUserId());
                        this.eoa.getHeadView().setUserName(a2.getAuthor().getUserName());
                        this.eoa.getHeadView().setOnClickListener(fqVar);
                        this.eoa.dU(a2.getAuthor().getPendantData().pL());
                    } else if (this.adc) {
                        this.eob.setVisibility(0);
                        UserTbVipInfoData userTbVipInfoData = a2.getAuthor().getUserTbVipInfoData();
                        if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.aUU != null) {
                            if (this.aUV == null) {
                                this.aUU.inflate();
                                this.aUV = (TbImageView) this.enT.findViewById(r.h.user_head_mask);
                            }
                            this.aUV.c(userTbVipInfoData.getvipV_url(), 10, false);
                        }
                        this.enY.setOnClickListener(fqVar);
                        this.eob.setOnClickListener(fqVar);
                        this.eoa.setVisibility(8);
                    } else {
                        if (this.epD) {
                            fr frVar = new fr(this, a2, z2);
                            if (this.enI != null) {
                                this.enI.setOnClickListener(frVar);
                            }
                            this.enY.setOnClickListener(frVar);
                            this.eob.setOnClickListener(frVar);
                            this.enW.setOnClickListener(frVar);
                            this.eob.setVisibility(8);
                            this.eoa.setVisibility(8);
                        } else {
                            this.eob.setVisibility(0);
                            this.enW.setOnClickListener(fqVar);
                            this.enY.setOnClickListener(fqVar);
                            this.eob.setOnClickListener(fqVar);
                        }
                        this.eoa.setVisibility(8);
                    }
                    this.eob.c(portrait, 28, false);
                }
                if (fVar != null) {
                    this.enU.F(fVar.aJZ());
                }
            }
        }
    }

    public boolean aNP() {
        return this.eqc;
    }

    private boolean Mw() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean C(com.baidu.tbadk.core.data.bh bhVar) {
        if (bhVar == null || bhVar.getAuthor() == null || bhVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.enK.aOA();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.enK.lH(eVar.forumName);
            }
            String string = this.ehi.getResources().getString(r.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.ehi.getResources().getString(r.l.self);
                    break;
                case 300:
                    str = this.ehi.getResources().getString(r.l.bawu);
                    break;
                case 400:
                    str = this.ehi.getResources().getString(r.l.system);
                    break;
            }
            this.ehi.showNetRefreshView(this.dTs, String.format(string, str), null, this.ehi.getResources().getString(r.l.appeal_restore), true, new fs(this, eVar.efo));
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aNj;
        String sb;
        if (fVar != null) {
            if (fVar.aJZ() != null) {
                this.epo = fVar.aJZ().rl();
                this.TF = fVar.aJZ().ri();
                if (fVar.aJZ().getAnchorLevel() != 0) {
                    this.eqc = true;
                }
                this.eoY = C(fVar.aJZ());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            m(fVar);
            this.epj = false;
            this.egi = z;
            aNL();
            b(fVar, z, i);
            if (this.ehi.aLh()) {
                if (this.eoz == null) {
                    this.eoz = new com.baidu.tieba.pb.view.m(this.ehi.getPageContext());
                    this.eoz.kg();
                    this.eoz.a(this.afI);
                }
                this.mListView.setPullRefresh(this.eoz);
                aNQ();
                if (this.eoz != null) {
                    this.eoz.dl(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (fVar.getPage().qy() == 0 && z) {
                this.mListView.setPullRefresh(null);
                this.enA = 1;
            } else {
                if (this.eoz == null) {
                    this.eoz = new com.baidu.tieba.pb.view.m(this.ehi.getPageContext());
                    this.eoz.kg();
                    this.eoz.a(this.afI);
                }
                this.mListView.setPullRefresh(this.eoz);
                aNQ();
                this.enA = 2;
                if (this.eoz != null) {
                    this.eoz.dl(TbadkCoreApplication.m9getInst().getSkinType());
                }
                aIO();
            }
            aNS();
            this.eov.ij(this.egi);
            this.eov.ik(false);
            this.eov.b(fVar);
            this.eov.notifyDataSetChanged();
            if (fVar.aJY() != null) {
                this.mForumName = fVar.aJY().getName();
                this.mForumId = fVar.getForumId();
            }
            this.enK.lH(this.mForumName);
            if (fVar.aJZ() != null) {
                or(com.baidu.tbadk.core.util.at.w(fVar.aJZ().rp()));
                if (fVar.aJZ().rn() != null) {
                    if (fVar.aJZ().rn().getNum() < 1) {
                        sb = this.ehi.getResources().getString(r.l.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(fVar.aJZ().rn().getNum())).toString();
                    }
                    if (this.enz != -1) {
                        fVar.aJZ().rn().setIsLike(this.enz);
                    }
                    O(sb, fVar.aJZ().rn().getIsLike() == 1);
                }
            }
            if (fVar.getPage().qx() == 0 && !z) {
                this.mListView.setNextPage(null);
                this.enJ = 1;
            } else if (this.ehi.isLogin()) {
                this.mListView.setNextPage(this.eoA);
                this.enJ = 2;
                aIO();
            } else if (fVar.getPage().qx() == 1) {
                this.epj = true;
                if (this.eoB == null) {
                    this.eoB = new com.baidu.tieba.pb.view.b(this.ehi.getPageContext());
                }
                this.mListView.setNextPage(this.eoB);
                this.enJ = 3;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = fVar.aKb();
            if (fVar.getPage().qx() == 0 || aKb == null || aKb.size() < fVar.getPage().qw()) {
                this.eoA.setText(this.ehi.getResources().getString(r.l.list_no_more));
                if (this.ehi.aLh() && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() == 1 && (this.mListView.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.eoA.setText("");
                }
                aNY();
            } else if (z2) {
                if (this.epZ) {
                    wl();
                    if (fVar.getPage().qx() != 0) {
                        this.eoA.setText(this.ehi.getResources().getString(r.l.pb_load_more));
                    }
                } else {
                    this.eoA.wn();
                }
            } else {
                this.eoA.wn();
            }
            if (fVar.aJZ() != null && fVar.aJZ().getAuthor() != null && fVar.aJZ().getAuthor().getType() == 0) {
                this.enK.aOx();
            }
            switch (i) {
                case 2:
                    this.mListView.setSelection(i2 > 1 ? i2 - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aNj = eq.aNi().aNj()) != null) {
                        this.epU = true;
                        this.mListView.onRestoreInstanceState(aNj);
                        break;
                    } else {
                        this.mListView.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.epZ = false;
                    this.mListView.setSelection(0);
                    break;
                case 5:
                    this.mListView.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aNj2 = eq.aNi().aNj();
                        this.epU = true;
                        if (aNj2 != null) {
                            this.mListView.onRestoreInstanceState(aNj2);
                            break;
                        }
                    }
                    this.mListView.setSelection(0);
                    break;
            }
            if (this.epo == epq && Mw()) {
                aOe();
            }
            if (!this.epU && fVar.aKi() == null && !fVar.aJZ().si()) {
                this.epA.aC(this.ehi.getResources().getString(r.l.pb_more_tools_guide_tip), String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips");
                this.epU = true;
            }
            G(fVar.aJZ());
        }
    }

    private void aNQ() {
        if (this.enB != null) {
            this.mListView.removeHeaderView(this.apT);
            return;
        }
        this.mListView.removeHeaderView(this.apT);
        this.mListView.addHeaderView(this.apT, 0);
    }

    public boolean aNR() {
        return this.enB != null;
    }

    public void iT(boolean z) {
        this.eoX = z;
        this.enK.iT(z);
    }

    public void wl() {
        if (this.eoA != null) {
            this.eoA.wl();
        }
        aIO();
    }

    public void JU() {
        this.mListView.setVisibility(0);
    }

    private boolean aNS() {
        boolean z;
        if (this.epa != null && this.epa.getVisibility() == 0) {
            z = true;
            if (this.eor != null) {
                this.eor.setVisibility(0);
            }
        } else {
            if (this.eor != null) {
                this.eor.setVisibility(8);
            }
            z = false;
        }
        if ((this.eot == null || this.eot.getVisibility() == 8) && z && this.egi) {
            this.eos.setVisibility(0);
        } else {
            this.eos.setVisibility(8);
        }
        com.baidu.tieba.graffiti.c.ap(this.eos);
        return z;
    }

    private boolean l(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aJZ() == null) {
            return false;
        }
        if (fVar.aJZ().ru() == 1 || fVar.aJZ().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aJZ().rw() == null || fVar.aJZ().rw().sI() == 0) || fVar.aJZ().rs() == 1 || fVar.aJZ().rt() == 1 || fVar.aJZ().sa() || fVar.aJZ().sn() || fVar.aJZ().sh() || fVar.aJZ().rI() != null || fVar.aJZ().so() || fVar.aJZ().so() || !com.baidu.tbadk.core.util.at.isEmpty(fVar.aJZ().ro()) || fVar.aJZ().rz();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return com.baidu.tieba.card.at.a((Context) this.ehi.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean a(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null) {
            if (this.enR != null) {
                if (fVar.aJZ() != null && fVar.aJZ().rL() == 0 && !fVar.aJZ().si() && !this.epQ) {
                    this.enR.setVisibility(0);
                    fVar.aJZ().se();
                    if (fVar.aJZ() != null) {
                        fVar.aJZ().e(true, l(fVar));
                    }
                    SpannableStringBuilder rV = fVar.aJZ().rV();
                    this.enS.setOnTouchListener(new com.baidu.tieba.view.x(rV));
                    if (rV == null || rV.length() == 0) {
                        this.enS.setVisibility(8);
                    } else {
                        this.enS.setText(rV);
                        this.enS.setVisibility(0);
                    }
                    this.enW.setPadding(this.enW.getPaddingLeft(), this.enW.getPaddingTop(), com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds32), this.enW.getPaddingBottom());
                } else {
                    this.enR.setVisibility(8);
                    this.mListView.removeHeaderView(this.enR);
                    if (fVar.aJZ() != null && fVar.aJZ().si()) {
                        this.enW.setPadding(this.enW.getPaddingLeft(), 0, this.enW.getPaddingRight(), this.enW.getPaddingBottom());
                    } else {
                        this.enW.setPadding(this.enW.getPaddingLeft(), com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds48), this.enW.getPaddingRight(), this.enW.getPaddingBottom());
                    }
                }
            }
            this.egi = z;
            com.baidu.tbadk.core.data.bh aJZ = fVar.aJZ();
            if (aJZ != null) {
                a(aJZ.rw());
            }
        }
        return false;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2, int i) {
        if (fVar != null) {
            a(fVar, z, z2);
            aNS();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.p a2;
        if (fVar == null || (a2 = a(fVar, z)) == null) {
            return null;
        }
        String userId = a2.getAuthor().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(r.h.tag_del_post_id, a2.getId());
            sparseArray.put(r.h.tag_del_post_type, 0);
            sparseArray.put(r.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(r.h.tag_manage_user_identity, Integer.valueOf(fVar.aKj()));
            sparseArray.put(r.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (a2.getAuthor() != null) {
                sparseArray.put(r.h.tag_forbid_user_name, a2.getAuthor().getUserName());
                sparseArray.put(r.h.tag_forbid_user_post_id, a2.getId());
            }
            sparseArray.put(r.h.tag_del_post_id, a2.getId());
            sparseArray.put(r.h.tag_del_post_type, 0);
            sparseArray.put(r.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(r.h.tag_manage_user_identity, Integer.valueOf(fVar.aKj()));
            sparseArray.put(r.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.azE;
    }

    public void os(String str) {
        if (this.eoA != null && !StringUtils.isNull(str)) {
            this.eoA.setText(str);
        }
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public int aNT() {
        return r.h.richText;
    }

    public TextView aKJ() {
        return this.enU.aKJ();
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(aa.b bVar) {
        this.afI = bVar;
        if (this.eoz != null) {
            this.eoz.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, a.b bVar) {
        if (aoVar != null) {
            int qv = aoVar.qv();
            int qs = aoVar.qs();
            if (this.eow != null) {
                this.eow.sV();
            } else {
                this.eow = new com.baidu.tbadk.core.dialog.a(this.ehi.getPageContext().getPageActivity());
                this.eox = LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.dialog_direct_pager, (ViewGroup) null);
                this.eow.x(this.eox);
                this.eow.a(r.l.dialog_ok, bVar);
                this.eow.b(r.l.dialog_cancel, new fu(this));
                this.eow.a(new fv(this));
                this.eow.b(this.ehi.getPageContext()).sV();
            }
            this.eoy = (EditText) this.eox.findViewById(r.h.input_page_number);
            this.eoy.setText("");
            TextView textView = (TextView) this.eox.findViewById(r.h.current_page_number);
            if (qv <= 0) {
                qv = 1;
            }
            if (qs <= 0) {
                qs = 1;
            }
            textView.setText(MessageFormat.format(this.ehi.getApplicationContext().getResources().getString(r.l.current_page), Integer.valueOf(qv), Integer.valueOf(qs)));
            this.ehi.ShowSoftKeyPadDelay(this.eoy, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.ehi.showToast(str);
    }

    public boolean iU(boolean z) {
        if (this.DX == null || !this.DX.Cz()) {
            return false;
        }
        this.DX.AK();
        return true;
    }

    public void aNU() {
        if (this.eqd != null) {
            while (this.eqd.size() > 0) {
                TbImageView remove = this.eqd.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aNU();
        this.eov.ot(1);
        if (this.enC != null) {
            this.enC.onPause();
        }
    }

    public void onResume() {
        this.eov.ot(2);
        if (this.enC != null) {
            this.enC.onResume();
        }
    }

    public void onDestroy() {
        this.epA.Tg();
        if (this.epB != null) {
            this.epB.Tg();
        }
        this.ehi.hideProgressBar();
        if (this.bxs != null && this.bEW != null) {
            this.bxs.b(this.bEW);
        }
        axs();
        this.eoA.wl();
        if (this.epw != null) {
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.epw);
        }
        if (this.epx != null) {
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.epx);
        }
        aOb();
        if (this.epP != null) {
            this.epP.removeAllViews();
        }
        if (this.enW != null && this.emp != null) {
            this.enW.removeView(this.enZ);
            this.emp = null;
        }
        if (this.epn != null) {
            this.epn.clearStatus();
        }
        this.epV = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eov.ot(3);
        if (this.bAe != null) {
            this.bAe.setBackgroundDrawable(null);
        }
        if (this.enC != null) {
            this.enC.destroy();
        }
    }

    public boolean aNV() {
        if (this.enC != null) {
            return this.enC.aNV();
        }
        return false;
    }

    public void axs() {
        this.enK.nX();
        this.epA.Tg();
        com.baidu.adp.lib.util.k.b(this.ehi.getPageContext().getPageActivity(), this.eoy);
        if (this.eoW != null) {
            this.eoW.dismiss();
        }
        aNW();
        if (this.epB != null) {
            this.epB.Tg();
        }
        if (this.eow != null) {
            this.eow.dismiss();
        }
        if (this.bHq != null) {
            this.bHq.dismiss();
        }
    }

    public void ii(boolean z) {
        this.eov.ii(z);
    }

    public void gK(boolean z) {
        this.doq = z;
    }

    public void aNW() {
        if (this.eoF != null) {
            this.eoF.dismiss();
        }
        if (this.eoG != null) {
            com.baidu.adp.lib.g.j.b(this.eoG, this.ehi.getPageContext());
        }
        if (this.eoP != null) {
            com.baidu.adp.lib.g.j.b(this.eoP, this.ehi.getPageContext());
        }
        if (this.eoD != null) {
            com.baidu.adp.lib.g.j.b(this.eoD, this.ehi.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.ehi.getLayoutMode().ai(i == 1);
        this.ehi.getLayoutMode().v(this.dTs);
        this.ehi.getLayoutMode().v(this.enS);
        this.ehi.getLayoutMode().v(this.enT);
        this.ehi.getLayoutMode().v(this.enP);
        if (this.eok != null) {
            com.baidu.tbadk.core.util.ap.c(this.eok, r.e.cp_cont_d, 1);
        }
        if (this.eoj != null) {
            com.baidu.tbadk.core.util.ap.c(this.eoj, r.e.cp_cont_d, 1);
        }
        if (this.rank > 0) {
            com.baidu.tbadk.core.util.ap.c(this.eoc, BitmapHelper.getGradeResourceIdNew(this.rank));
        }
        if (this.enF != null) {
            this.enF.lJ();
        }
        if (this.enH != null) {
            this.enH.lJ();
        }
        if (this.enI != null) {
            com.baidu.tbadk.core.util.ap.c(this.enI, r.e.cp_cont_j, 1);
            String string = this.ehi.getResources().getString(r.l.video_public_owner);
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            if (this.enI.getTag(r.h.tag_user_name) instanceof String) {
                sb.append((String) this.enI.getTag(r.h.tag_user_name));
                SpannableString spannableString = new SpannableString(sb);
                spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_a)), string.length(), sb.length(), 33);
                this.enI.setText(spannableString);
            } else {
                this.enI.setText(string);
            }
        }
        this.ehi.getLayoutMode().v(this.enP);
        com.baidu.tbadk.core.util.ap.i((View) this.enS, r.e.cp_cont_b);
        this.enS.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_c));
        this.ehi.getLayoutMode().v(this.azE);
        if (this.eox != null) {
            this.ehi.getLayoutMode().v(this.eox);
        }
        iT(this.eoX);
        this.eov.notifyDataSetChanged();
        if (this.eoz != null) {
            this.eoz.dl(i);
        }
        if (this.eoA != null) {
            this.eoA.dl(i);
            com.baidu.tbadk.core.util.ap.j(this.azE, r.g.pb_foot_more_trans_selector);
            this.eoA.dj(r.g.pb_foot_more_trans_selector);
        }
        if (this.DX != null) {
            this.DX.onChangeSkinType(i);
        }
        if (this.eol != null) {
            this.eol.dp(i);
        }
        if (this.eoB != null) {
            this.eoB.dl(i);
        }
        if (this.enO != null && this.enO.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.view.a aVar : this.enO) {
                aVar.aOt();
            }
        }
        if (this.epP != null) {
            com.baidu.tbadk.core.util.ap.k(this.epP, r.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.k(this.epJ, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.c(this.epO, r.e.cp_cont_c, 1);
        }
        iN(i == 1);
        this.enV.changeSkinType(i);
        aNy();
        UtilHelper.setStatusBarBackground(this.bAe, i);
        if (this.eom != null) {
            this.eom.onChangeSkinType(i);
        }
        if (this.eoo != null) {
            com.baidu.tbadk.i.a.a(this.ehi.getPageContext(), this.eoo);
        }
        if (this.epz != null) {
            this.epz.onChangeSkinType(i);
        }
        if (this.enK != null) {
            if (this.enG != null) {
                this.enK.aOB();
            } else {
                this.enK.onChangeSkinType(i);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aHX = eVar;
        this.eov.setOnImageClickListener(this.aHX);
    }

    public void h(NoNetworkView.a aVar) {
        this.bEW = aVar;
        if (this.bxs != null) {
            this.bxs.a(this.bEW);
        }
    }

    public void iV(boolean z) {
        this.eov.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aNX() {
        return this.epa;
    }

    public void aNY() {
        if (this.enJ != 2) {
            this.mListView.setNextPage(this.eoA);
            this.enJ = 2;
        }
    }

    public void aNZ() {
        if (com.baidu.tbadk.performanceLog.aa.FO().FP()) {
            int lastVisiblePosition = this.mListView.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.mListView.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(r.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.fh(1001);
                                perfLog.aAO = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.vQ();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(r.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fh(1001);
                        perfLog2.aAO = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.vQ();
                    }
                }
            }
        }
    }

    public void gL(boolean z) {
        if (this.epb != null && this.epb != null) {
            if (this.doq) {
                gM(z);
            } else {
                gN(z);
            }
        }
    }

    public void aOa() {
        if (this.epb != null) {
            this.epb.setVisibility(8);
        }
    }

    public void avh() {
        if (this.epi == null) {
            this.epi = new com.baidu.tbadk.core.view.a(this.ehi.getPageContext());
        }
        this.epi.aJ(true);
    }

    public void aIO() {
        if (this.epi != null) {
            this.epi.aJ(false);
        }
    }

    private void a(com.baidu.tieba.pb.data.f fVar, com.baidu.tieba.tbadkCore.data.p pVar) {
        if (fVar != null && pVar != null && pVar.getAuthor() != null && pVar.getAuthor().getGodUserData() != null) {
            GodUserData godUserData = pVar.getAuthor().getGodUserData();
            if (2 == godUserData.getType()) {
                MetaData author = pVar.getAuthor();
                long userIdLong = pVar.getAuthor().getUserIdLong();
                String userName = pVar.getAuthor().getUserName();
                int fansNum = pVar.getAuthor().getFansNum();
                pVar.getId();
                pVar.getAuthor().getPortrait();
                fx fxVar = new fx(this, pVar);
                if (this.epF == null) {
                    this.epF = (LinearLayout) LayoutInflater.from(this.ehi.getActivity()).inflate(r.j.god_floating_view, (ViewGroup) null);
                    this.epF.setOnClickListener(fxVar);
                    this.epF.setTag(r.h.tag_user_id, String.valueOf(userIdLong));
                    this.epF.setTag(r.h.tag_user_name, userName);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.epF.findViewById(r.h.god_floating_owner_photo);
                    if (this.adc) {
                        ViewStub viewStub = (ViewStub) this.epF.findViewById(r.h.viewstub_headimage_mask);
                        if (viewStub != null && 0 == 0) {
                            viewStub.inflate();
                            TbImageView tbImageView = (TbImageView) this.epF.findViewById(r.h.user_head_mask);
                            if (tbImageView != null && author != null && author.getUserTbVipInfoData() != null && !StringUtils.isNull(author.getUserTbVipInfoData().getvipV_url())) {
                                tbImageView.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                                clickableHeaderImageView.setIsBigV(true);
                            }
                        }
                    } else {
                        clickableHeaderImageView.setGodIconMargin(0);
                    }
                    clickableHeaderImageView.setOnClickListener(fxVar);
                    clickableHeaderImageView.setTag(pVar.getAuthor().getUserId());
                    clickableHeaderImageView.c(pVar.getAuthor().getPortrait(), 28, false);
                    ImageView imageView = (ImageView) this.epF.findViewById(r.h.god_floating_owner_info_user_rank);
                    int level_id = pVar.getAuthor().getLevel_id();
                    int is_bawu = pVar.getAuthor().getIs_bawu();
                    String bawu_type = pVar.getAuthor().getBawu_type();
                    int i = 3;
                    if (level_id != 0) {
                        imageView.setVisibility(0);
                        com.baidu.tbadk.core.util.ap.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                        imageView.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.l.degree_in_forum), Integer.valueOf(level_id)));
                        imageView.setOnClickListener(null);
                    } else {
                        imageView.setVisibility(8);
                    }
                    ImageView imageView2 = (ImageView) this.epF.findViewById(r.h.god_floating_owner_info_user_bawu);
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.ap.c(imageView2, r.g.pb_manager);
                            imageView.setVisibility(8);
                            imageView2.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.ap.c(imageView2, r.g.pb_assist);
                            imageView.setVisibility(8);
                            imageView2.setVisibility(0);
                        }
                    }
                    if (!StringUtils.isNull(pVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aQ(pVar.getAuthor().getName_show()) > 14) {
                        i = 0;
                    }
                    ArrayList<IconData> iconInfo = pVar.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = pVar.getAuthor().getTShowInfoNew();
                    UserIconBox userIconBox = (UserIconBox) this.epF.findViewById(r.h.god_floating_owner_info_user_icon);
                    UserIconBox userIconBox2 = (UserIconBox) this.epF.findViewById(r.h.god_floating_owner_info_tshow_icon);
                    if (userIconBox != null) {
                        userIconBox.setTag(r.h.tag_user_id, pVar.getAuthor().getUserId());
                        userIconBox.setOnClickListener(this.ehi.ehW.bPI);
                        userIconBox.a(iconInfo, i, this.ehi.getResources().getDimensionPixelSize(r.f.ds30), this.ehi.getResources().getDimensionPixelSize(r.f.ds30), this.ehi.getResources().getDimensionPixelSize(r.f.ds10));
                    }
                    if (userIconBox2 != null) {
                        userIconBox2.setOnClickListener(this.ehi.ehW.eqz);
                        userIconBox2.a(tShowInfoNew, 3, this.ehi.getResources().getDimensionPixelSize(r.f.ds32), this.ehi.getResources().getDimensionPixelSize(r.f.ds32), this.ehi.getResources().getDimensionPixelSize(r.f.ds8), true);
                    }
                    TextView textView = (TextView) this.epF.findViewById(r.h.god_floating_owner_info_user_name);
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_f, 1);
                    }
                    textView.setText(pVar.getAuthor().getName_show());
                    if (aOh() != null) {
                        aOh().addView(this.epF);
                    }
                    this.ehi.getLayoutMode().v(this.epF);
                }
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) this.epF.findViewById(r.h.god_floating_gift);
                this.epS.a(entelechyUserLikeButton);
                this.epS.a(pVar.getAuthor());
                ImageView imageView3 = (ImageView) this.epF.findViewById(r.h.god_floating_arrow);
                com.baidu.tbadk.core.util.ap.c(imageView3, r.g.icon_arrow_tab);
                if (this.eoY || (godUserData.getIsLike() && godUserData.getIsFromNetWork())) {
                    entelechyUserLikeButton.setVisibility(8);
                    imageView3.setVisibility(0);
                } else {
                    entelechyUserLikeButton.setVisibility(0);
                    imageView3.setVisibility(8);
                }
                String format = String.format(this.ehi.getResources().getString(r.l.fans_default_name_god_user), com.baidu.tbadk.core.util.at.u(fansNum));
                TextView textView2 = (TextView) this.epF.findViewById(r.h.god_floating_intro);
                if (textView2 != null) {
                    textView2.setText(format);
                }
            }
        }
    }

    private boolean a(com.baidu.tieba.pb.data.f fVar, com.baidu.tieba.tbadkCore.data.p pVar, String str, String str2, boolean z, boolean z2) {
        boolean z3;
        FrameLayout.LayoutParams layoutParams;
        if (fVar == null || pVar == null || pVar.getAuthor() == null || pVar.getAuthor().getGodUserData() == null) {
            return false;
        }
        GodUserData godUserData = pVar.getAuthor().getGodUserData();
        if (2 != godUserData.getType()) {
            return false;
        }
        if (fVar.aJZ() == null || !fVar.aJZ().si() || fVar.aJZ().rN() == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        MetaData author = pVar.getAuthor();
        long userIdLong = pVar.getAuthor().getUserIdLong();
        String userName = pVar.getAuthor().getUserName();
        int fansNum = pVar.getAuthor().getFansNum();
        pVar.getId();
        String portrait = pVar.getAuthor().getPortrait();
        if (this.eom.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.eom.getLayoutParams();
            aVar.gravity = 48;
            this.eom.setLayoutParams(aVar);
        }
        this.enW.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds32), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds32), 0);
        this.epy.setPadding(0, com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds8), 0, 0);
        if (pVar.getType() == null || pVar.getType().getId() != com.baidu.tieba.tbadkCore.data.p.Sz.getId()) {
            this.enP.setPadding(0, 0, 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds76);
        if (this.eob.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eob.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.eob.setLayoutParams(layoutParams);
        this.eob.setVisibility(8);
        View findViewWithTag = this.enW.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.emp = new ClickableHeaderImageView(this.ehi.getApplicationContext());
            this.emp.setGodIconMargin(0);
            this.emp.setTag("pb_god_head_image_view_tag");
            this.emp.setUserId(String.valueOf(userIdLong));
            this.emp.setUserName(userName);
            layoutParams.leftMargin = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds0);
            this.enZ.addView(this.emp, 0, layoutParams);
        } else {
            this.emp = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.adc) {
            this.emp.setIsBigV(true);
        }
        fy fyVar = new fy(this, pVar, fVar);
        this.enW.setTag(r.h.tag_user_id, String.valueOf(userIdLong));
        this.enW.setTag(r.h.tag_user_name, userName);
        this.enT.setTag(r.h.tag_user_id, String.valueOf(userIdLong));
        this.enT.setTag(r.h.tag_user_name, userName);
        this.emp.setVisibility(0);
        this.emp.setOnClickListener(fyVar);
        this.emp.c(portrait, 28, false);
        if (this.eok == null) {
            this.eok = new TextView(this.ehi.getActivity());
            this.eok.setClickable(true);
            this.eok.setTextSize(0, this.ehi.getResources().getDimensionPixelSize(r.f.fontsize24));
            ColumnLayout.a aVar2 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar2.topMargin = this.ehi.getResources().getDimensionPixelSize(r.f.ds10);
            this.eok.setSingleLine(true);
            this.eok.setEllipsize(TextUtils.TruncateAt.END);
            this.eok.setTag(r.h.tag_user_id, String.valueOf(userIdLong));
            this.eok.setTag(r.h.tag_user_name, userName);
            com.baidu.tbadk.core.util.ap.c(this.eok, r.e.cp_cont_d, 1);
            this.eok.setOnTouchListener(this.egn);
            this.enW.addView(this.eok, -1, aVar2);
        }
        String string = this.ehi.getResources().getString(r.l.tieba_certification);
        this.eok.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.ehi.getResources().getString(r.l.god_intro_default)) : String.format(string, godUserData.getIntro()));
        if (this.eoj == null) {
            this.eoj = new TextView(this.ehi.getActivity());
            this.eoj.setClickable(false);
            this.eoj.setIncludeFontPadding(false);
            this.eoj.setGravity(16);
            this.eoj.setTextSize(0, this.ehi.getResources().getDimensionPixelSize(r.f.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.ehi.getResources().getDimensionPixelSize(r.f.ds5);
            aVar3.bottomMargin = this.ehi.getResources().getDimensionPixelSize(r.f.ds10);
            this.eoj.setSingleLine(true);
            com.baidu.tbadk.core.util.ap.c(this.eoj, r.e.cp_cont_d, 1);
            this.enW.addView(this.eoj, -1, aVar3);
        }
        this.eoj.setText(String.format(this.ehi.getResources().getString(r.l.fans_default_name_god_user), com.baidu.tbadk.core.util.at.u(fansNum)));
        this.eoj.setTag(r.h.tag_user_id, String.valueOf(userIdLong));
        this.eoj.setTag(r.h.tag_user_name, userName);
        this.eoj.setOnClickListener(fyVar);
        if (z3) {
            this.eoj.setVisibility(4);
        } else {
            this.eoj.setVisibility(0);
        }
        if (this.epG == null) {
            this.epG = new TextView(this.ehi.getApplicationContext());
            this.epG.setId(r.h.pb_god_user_tip_content);
            this.epG.setEllipsize(TextUtils.TruncateAt.END);
            this.epG.setGravity(17);
            this.epG.setSingleLine(true);
            this.epG.setHeight(this.ehi.getResources().getDimensionPixelSize(r.f.ds56));
            this.epG.setTextSize(0, this.ehi.getResources().getDimensionPixelSize(r.f.fontsize24));
            this.epG.setVisibility(8);
            if (aOh() != null) {
                aOh().addView(this.epG);
            }
            this.ehi.getLayoutMode().v(this.epG);
        }
        com.baidu.tbadk.core.util.ap.j((View) this.epG, r.e.common_color_10260);
        com.baidu.tbadk.core.util.ap.i((View) this.epG, r.e.cp_cont_g);
        this.epG.setOnClickListener(new fz(this));
        this.epG.setText(String.format(this.ehi.getResources().getString(r.l.god_user_floor_owner_tip), com.baidu.tbadk.core.util.at.u(this.epH)));
        oH(this.epH);
        if (!z3) {
            a(fVar, pVar);
        }
        this.epP = this.eoA.wh();
        if (this.epP != null && !this.eoY && !z && z2 && (!godUserData.getIsLike() || !godUserData.getIsFromNetWork())) {
            this.eoA.wi();
            this.eoA.we();
            this.epJ = this.epP.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.epJ == null) {
                this.epJ = new View(this.ehi.getApplicationContext());
                this.epJ.setTag("pb_god_bottom_extra_line_view_tag");
                this.epP.addView(this.epJ, new LinearLayout.LayoutParams(-1, this.ehi.getResources().getDimensionPixelSize(r.f.ds20)));
                this.epN = new FrameLayout(this.ehi.getApplicationContext());
                this.epN.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.epL = new ClickableHeaderImageView(this.ehi.getApplicationContext());
                this.epL.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.epL.c(portrait, 28, false);
                this.epL.setUserId(String.valueOf(userIdLong));
                this.epL.setUserName(userName);
                this.epL.setOnClickListener(fyVar);
                this.epN.addView(this.epL, new FrameLayout.LayoutParams(this.ehi.getResources().getDimensionPixelSize(r.f.ds130), this.ehi.getResources().getDimensionPixelSize(r.f.ds130)));
                if (this.adc) {
                    this.epM = new TbImageView(this.ehi.getApplicationContext());
                    this.epM.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.epM.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.ehi.getResources().getDimensionPixelSize(r.f.ds45), this.ehi.getResources().getDimensionPixelSize(r.f.ds45));
                    layoutParams3.gravity = 85;
                    this.epN.addView(this.epM, layoutParams3);
                } else {
                    this.epL.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(this.ehi.getResources().getDimensionPixelSize(r.f.ds130), this.ehi.getResources().getDimensionPixelSize(r.f.ds130));
                layoutParams4.gravity = 17;
                layoutParams4.topMargin = this.ehi.getResources().getDimensionPixelSize(r.f.ds40);
                this.epP.addView(this.epN, layoutParams4);
                this.epO = new TextView(this.ehi.getApplicationContext());
                this.epO.setTag("pb_god_bottom_extra_text_view_tag");
                this.epO.setSingleLine(true);
                this.epO.setTextSize(0, this.ehi.getResources().getDimensionPixelSize(r.f.fontsize24));
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.topMargin = this.ehi.getResources().getDimensionPixelSize(r.f.ds36);
                layoutParams5.gravity = 1;
                this.epO.setText(this.ehi.getResources().getString(r.l.god_user_attention_tip));
                this.epP.addView(this.epO, layoutParams5);
                if (this.epK == null) {
                    this.epK = new EntelechyUserLikeButton(this.ehi.getApplicationContext());
                    this.epT.a(this.epK);
                }
                this.epK.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.epK.setTextSize(0, this.ehi.getResources().getDimensionPixelSize(r.f.fontsize24));
                this.epK.setGravity(17);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, this.ehi.getResources().getDimensionPixelSize(r.f.ds54));
                layoutParams6.topMargin = this.ehi.getResources().getDimensionPixelSize(r.f.ds30);
                layoutParams6.bottomMargin = this.ehi.getResources().getDimensionPixelSize(r.f.ds40);
                layoutParams6.gravity = 1;
                this.epP.addView(this.epK, layoutParams6);
            } else {
                this.epK = (EntelechyUserLikeButton) this.epP.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.epL = (ClickableHeaderImageView) this.epP.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.epO = (TextView) this.epP.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.epJ = this.epP.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            this.epT.a(pVar.getAuthor());
            com.baidu.tbadk.core.util.ap.k(this.epP, r.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.k(this.epJ, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.c(this.epO, r.e.cp_cont_c, 1);
            this.epP.setOnTouchListener(new ga(this));
        } else {
            this.eoA.wj();
            this.eoA.wd();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.epD && !this.ehO && i > this.enA) {
            this.epE = true;
        } else {
            this.epE = false;
            aOc();
        }
        a aVar = new a();
        aVar.eqo = i;
        aVar.eqp = this.mListView.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
    }

    /* loaded from: classes.dex */
    public class a {
        public int eqo;
        public int eqp;

        public a() {
        }
    }

    private void oH(int i) {
        boolean z;
        if (this.epG != null && this.epG.getVisibility() != 0 && i >= 2 && !this.eoY) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.epI = true;
                this.epG.setVisibility(0);
            }
            com.baidu.adp.lib.g.h.eE().postDelayed(this.bJK, 3000L);
        }
    }

    public void aOb() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bJK);
        if (this.epG != null && 8 != this.epG.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.ehi, this.epG, r.a.fade_out, new gb(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aOc() {
        if (this.epF != null) {
            this.epF.clearAnimation();
            if (this.epF.getVisibility() != 8) {
                this.epF.setVisibility(8);
            }
        }
    }

    public void aOd() {
        if (this.epD && this.epE && this.epF != null && this.epF.getVisibility() != 0 && !this.epI) {
            this.epF.clearAnimation();
            this.epF.setVisibility(0);
        }
    }

    public void aOe() {
        if (!this.eqe) {
            TiebaStatic.log("c10490");
            this.eqe = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehi.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(epr, Integer.valueOf(ept));
            aVar.bZ(r.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(r.h.function_description_view)).setText(r.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(r.h.title_view)).setText(r.l.grade_thread_tips);
            aVar.x(inflate);
            aVar.A(sparseArray);
            aVar.a(r.l.grade_button_tips, this.ehi);
            aVar.b(r.l.look_again, new gc(this));
            aVar.b(this.ehi.getPageContext()).sV();
        }
    }

    public void aOf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehi.getPageContext().getPageActivity());
        aVar.cE(this.ehi.getResources().getString(r.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(epr, Integer.valueOf(epv));
        aVar.A(sparseArray);
        aVar.a(r.l.upgrade_to_new, this.ehi);
        aVar.b(r.l.cancel, new gd(this));
        aVar.b(this.ehi.getPageContext()).sV();
    }

    public int rl() {
        return this.epo;
    }

    public void ot(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehi.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.ehi.getPageContext().getPageActivity()).inflate(r.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(r.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(r.h.function_description_view)).setVisibility(8);
        aVar.x(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(epr, Integer.valueOf(epu));
        aVar.A(sparseArray);
        aVar.a(r.l.view, this.ehi);
        aVar.b(r.l.cancel, new ge(this));
        aVar.b(this.ehi.getPageContext()).sV();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.p a2;
        if (i > 0 && (a2 = a(fVar, z)) != null && a2.getAuthor() != null) {
            MetaData author = a2.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
    }

    public PbInterviewStatusView aOg() {
        return this.epn;
    }

    private void m(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aJZ() != null && fVar.aJZ().sn() && this.epn == null) {
            this.epn = (PbInterviewStatusView) this.epm.inflate();
            this.epn.setOnClickListener(this.bHz);
            this.epn.setCallback(this.ehi.aLq());
            this.epn.a(this.ehi, fVar);
        }
    }

    public LinearLayout aOh() {
        return this.eou;
    }

    public View aOi() {
        return this.bAe;
    }

    public boolean aOj() {
        return this.epQ;
    }

    public void il(boolean z) {
        this.enU.il(z);
    }

    private void aOk() {
        if (this.epQ) {
            if (this.epR == null) {
                f.a aVar = f.ehl.get();
                if (aVar != null) {
                    this.epR = aVar.a(this.ehi);
                    ListAdapter adapter = this.mListView.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.apT) {
                            this.mListView.addHeaderView(this.epR.aKH(), 1);
                        } else {
                            this.mListView.addHeaderView(this.epR.aKH(), 0);
                        }
                    }
                } else {
                    this.enT.setVisibility(0);
                    return;
                }
            }
            this.enT.setVisibility(8);
            this.mListView.removeHeaderView(this.enT);
            return;
        }
        this.enT.setVisibility(0);
    }

    public void iW(boolean z) {
        this.epQ = z;
    }

    public View aLU() {
        return this.enV.aLU();
    }

    public void aOl() {
        this.ehi.showNetRefreshView(getView(), "");
        View Ei = this.ehi.getRefreshView().Ei();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Ei.getLayoutParams();
        layoutParams.addRule(3, aOh().getId());
        Ei.setLayoutParams(layoutParams);
        this.ehi.hideLoadingView(getView());
        if (this.epR != null) {
            this.mListView.removeHeaderView(this.epR.aKH());
            this.epR = null;
        }
    }

    public void ou(String str) {
        if (this.enL != null) {
            this.enL.setTitle(str);
        }
    }

    public void aOm() {
        if (this.eov != null) {
            if (this.eov.aLC() != null) {
                this.eov.aLC().ayL();
            }
            if (this.eov.aLD() != null) {
                this.eov.aLD().ayL();
            }
        }
    }

    private int iX(boolean z) {
        if (this.epn == null || this.epn.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.e(this.ehi.getPageContext().getPageActivity(), r.f.ds72);
    }

    private void aOn() {
        if (this.epn != null && this.epn.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epn.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.epn.setLayoutParams(layoutParams);
        }
    }

    public boolean aKQ() {
        return this.epD;
    }

    public TextView aOo() {
        return this.eok;
    }

    public void aOp() {
        this.epe.performClick();
    }

    public boolean aOq() {
        return (this.enC == null || this.enG == null) ? false : true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            axs();
            aOa();
            aNo();
            if (this.epz != null) {
                this.epz.aLG();
            }
            this.ehi.XV();
            aOc();
            this.eou.setVisibility(8);
            this.enK.setTitleVisibility(true);
            this.ehi.is(false);
            if (this.enG != null && this.enB != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.enB.getLayoutParams();
                if (configuration.orientation == 2) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                } else {
                    int I = com.baidu.adp.lib.util.k.I(this.ehi.getActivity());
                    layoutParams.width = I;
                    layoutParams.height = (int) (I * 0.5625d);
                    this.enK.aOD();
                    this.eou.setVisibility(0);
                }
                this.enB.setLayoutParams(layoutParams);
                this.enG.a(this.ehi, configuration);
            }
        }
    }

    public void x(long j, int i) {
        if (this.enH != null && j > 0) {
            this.enH.k(i, j);
        }
    }

    public void iY(boolean z) {
        this.enD = z;
    }

    private void G(com.baidu.tbadk.core.data.bh bhVar) {
        if (this.enH != null && bhVar != null && bhVar.sz() != null && bhVar.sz().Uu == 2) {
            if (this.epB == null) {
                this.epB = new com.baidu.tieba.d.a(this.ehi.getPageContext(), this.enH.etq);
                this.epB.gY(5000);
            }
            this.epB.e(this.ehi.getResources().getString(r.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }
}
