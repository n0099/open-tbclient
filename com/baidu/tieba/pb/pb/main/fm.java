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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
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
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class fm {
    public static int eoE = 2;
    public static int eoF = 3;
    public static int eoG = 0;
    public static int eoH = 3;
    public static int eoI = 4;
    public static int eoJ = 5;
    public static int eoK = 6;
    private com.baidu.tbadk.editortools.j Kg;
    private View aFt;
    private int aNF;
    private ae.b alm;
    private TextView avJ;
    private NoNetworkView bGF;
    private RelativeLayout bGH;
    private View bIA;
    private View.OnClickListener bPI;
    private View.OnClickListener eeE;
    private com.baidu.tieba.pb.a.d eeF;
    private PbActivity efF;
    PbActivity.c ehj;
    private UserIconBox eiW;
    private UserIconBox eiX;
    private com.baidu.tieba.pb.data.f ejL;
    private PbFakeFloorModel ejo;
    public int emE;
    private int emF;
    private int emG;
    private int emH;
    private FrameLayout emJ;
    private int emK;
    private com.baidu.tieba.pb.video.g emL;
    private com.baidu.tieba.pb.video.d emN;
    private com.baidu.tieba.play.c emO;
    private com.baidu.tieba.pb.video.e emP;
    private TextView emQ;
    public final com.baidu.tieba.pb.pb.main.view.f emS;
    public com.baidu.tieba.pb.pb.main.view.d emT;
    private ViewStub emU;
    private ViewStub emV;
    private List<com.baidu.tieba.pb.pb.main.view.a> emW;
    private View emX;
    private TextView enA;
    private TextView enB;
    private View enC;
    private View enD;
    private ObservedChangeLinearLayout enF;
    private cq enG;
    private PbListView enL;
    private View enN;
    private LinearLayout enb;
    private TextView enc;
    private View ene;
    private g enf;
    private ColumnLayout eng;
    private ThreadSkinView enh;
    private TextView eni;
    private TextView enj;
    private ImageView enk;
    private HeadPendantView enl;
    private FrameLayout enm;
    private HeadImageView enn;
    private View eno;
    private FloatingLayout enp;
    private PbFirstFloorUserLikeButton enu;
    private fk env;
    private TextView enw;
    private TextView enx;
    private TextView eny;
    private LinearLayout enz;
    private ViewStub eoA;
    private PbInterviewStatusView eoB;
    private TextView eoC;
    private Runnable eoL;
    private Runnable eoM;
    private dq eoN;
    private com.baidu.tieba.d.a eoO;
    private com.baidu.tieba.d.a eoP;
    private View eoY;
    private TextView eoZ;
    private View eoo;
    private TextView eop;
    private ViewGroup eoq;
    public ImageView eor;
    private TextView eos;
    private boolean eou;
    private PostData eow;
    private View eoy;
    private TextView eoz;
    private LinearLayout epa;
    private boolean epb;
    private f epc;
    private com.baidu.tbadk.core.view.userLike.c epd;
    private com.baidu.tbadk.core.view.userLike.c epe;
    private Runnable epi;
    private PbActivity.a epk;
    private boolean epm;
    private boolean epn;
    private BdTypeListView mListView;
    private int mType;
    private int emI = 1;
    private boolean emM = false;
    private int emR = 0;
    private final Handler mHandler = new Handler();
    private View emY = null;
    private LinearLayout emZ = null;
    private TextView ena = null;
    private TextView enq = null;
    private TextView enr = null;
    public FrsPraiseView ens = null;
    private ClickableHeaderImageView ent = null;
    private View enE = null;
    private com.baidu.tbadk.core.dialog.a enH = null;
    private com.baidu.tbadk.core.dialog.c bPH = null;
    private View enI = null;
    private EditText enJ = null;
    private com.baidu.tieba.pb.view.m enK = null;
    private com.baidu.tieba.pb.view.b enM = null;
    private c.b cUE = null;
    private TbRichTextView.e aOe = null;
    private NoNetworkView.a bNr = null;
    private Dialog enO = null;
    private View enP = null;
    private com.baidu.tbadk.core.dialog.a enQ = null;
    private Dialog enR = null;
    private View enS = null;
    private int enT = 0;
    private RadioGroup enU = null;
    private RadioButton enV = null;
    private RadioButton enW = null;
    private RadioButton enX = null;
    private Button enY = null;
    private Button enZ = null;
    private TextView eoa = null;
    private Dialog eob = null;
    private View eoc = null;
    private LinearLayout eod = null;
    private CompoundButton.OnCheckedChangeListener eoe = null;
    private TextView eog = null;
    private TextView eoh = null;
    private String eoi = null;
    private com.baidu.tbadk.core.dialog.c eoj = null;
    private boolean eok = false;
    private boolean eol = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eom = null;
    private boolean dlE = false;
    private Button eon = null;
    private boolean eot = true;
    private com.baidu.tbadk.core.view.a eov = null;
    private boolean eeA = false;
    private int mSkinType = 3;
    private boolean eox = false;
    private boolean mIsFromCDN = true;
    private int eoD = 0;
    private float eoQ = -1.0f;
    private int eoR = -1;
    private a.InterfaceC0078a eoS = new fn(this);
    private boolean egn = false;
    private boolean eoT = false;
    private LinearLayout eoU = null;
    private TextView eoV = null;
    private int eoW = 0;
    private boolean eoX = false;
    private boolean epf = false;
    private int rank = 0;
    private boolean epg = false;
    private CustomMessageListener dhc = new fx(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Animation.AnimationListener drq = new gg(this);
    private Handler eph = new Handler();
    private CustomMessageListener epj = new gm(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean epl = true;
    private boolean epo = false;
    private boolean YA = false;
    String userId = null;
    private final List<TbImageView> epp = new ArrayList();
    private boolean epq = false;

    public void i(int i, float f) {
        this.eoR = i;
        this.eoQ = f;
    }

    public f aLg() {
        return this.epc;
    }

    public NoNetworkView aLh() {
        return this.bGF;
    }

    public boolean isFullScreen() {
        return this.egn;
    }

    public void aLi() {
        if (this.Kg != null) {
            this.Kg.hide();
        }
    }

    public PbFakeFloorModel aLj() {
        return this.ejo;
    }

    public dq aLk() {
        return this.eoN;
    }

    public void aLl() {
        reset();
        this.eot = true;
        if (this.Kg != null) {
            this.Kg.hide();
        }
        this.eoN.aJK();
        if (this.eoo != null) {
            if (this.dlE) {
                go(false);
            } else {
                gp(false);
            }
        }
    }

    private void reset() {
        if (this.efF != null && this.efF.aII() != null && this.Kg != null) {
            com.baidu.tbadk.editortools.pb.a.CO().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aII = this.efF.aII();
            aII.Di();
            if (aII.getWriteImagesInfo() != null) {
                aII.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aII.eG(10);
            aII.eE(SendView.ALL);
            aII.eF(SendView.ALL);
            com.baidu.tbadk.editortools.p ev = this.Kg.ev(23);
            com.baidu.tbadk.editortools.p ev2 = this.Kg.ev(2);
            com.baidu.tbadk.editortools.p ev3 = this.Kg.ev(5);
            if (ev2 != null) {
                ev2.lW();
            }
            if (ev3 != null) {
                ev3.lW();
            }
            if (ev != null) {
                ev.hide();
            }
            this.Kg.invalidate();
        }
    }

    public boolean aLm() {
        return this.eot;
    }

    public void go(boolean z) {
        if (this.eoo != null && this.eop != null) {
            this.eop.setText(w.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eoo.startAnimation(alphaAnimation);
            }
            this.eoo.setVisibility(0);
        }
    }

    public void gp(boolean z) {
        if (this.eoo != null && this.eop != null) {
            this.eop.setText(w.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eoo.startAnimation(alphaAnimation);
            }
            this.eoo.setVisibility(0);
        }
    }

    public PostData aLn() {
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
        if (this.enG.ob(headerViewsCount) != null && this.enG.ob(headerViewsCount) != PostData.fuk) {
            i2 = headerViewsCount + 1;
        }
        return this.enG.getItem(i2) instanceof PostData ? (PostData) this.enG.getItem(i2) : null;
    }

    public fm(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.aNF = 0;
        this.emF = 0;
        this.emG = 0;
        this.emH = 0;
        this.efF = null;
        this.bGH = null;
        this.bIA = null;
        this.mListView = null;
        this.emX = null;
        this.enb = null;
        this.enc = null;
        this.ene = null;
        this.eng = null;
        this.eni = null;
        this.enj = null;
        this.enm = null;
        this.enn = null;
        this.eno = null;
        this.enu = null;
        this.enw = null;
        this.enx = null;
        this.eny = null;
        this.enC = null;
        this.enD = null;
        this.enG = null;
        this.enL = null;
        this.aFt = null;
        this.bPI = null;
        this.eeE = null;
        this.eoo = null;
        this.eop = null;
        this.eoq = null;
        this.eor = null;
        this.eos = null;
        this.eoy = null;
        this.eoz = null;
        this.eoA = null;
        this.efF = pbActivity;
        this.bPI = onClickListener;
        this.eeF = dVar;
        this.bGH = (RelativeLayout) LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.new_pb_activity, (ViewGroup) null);
        this.efF.addContentView(this.bGH, new FrameLayout.LayoutParams(-1, -1));
        this.bIA = this.efF.findViewById(w.h.statebar_view);
        this.enF = (ObservedChangeLinearLayout) this.efF.findViewById(w.h.title_wrapper);
        this.bGF = (NoNetworkView) this.efF.findViewById(w.h.view_no_network);
        this.mListView = (BdTypeListView) this.efF.findViewById(w.h.new_pb_list);
        this.avJ = new TextView(this.efF.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.efF.getActivity(), w.f.ds98));
        this.mListView.addHeaderView(this.avJ, 0);
        View view = new View(this.efF.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.efF.getResources().getDimensionPixelSize(w.f.ds100)));
        view.setVisibility(4);
        this.mListView.addFooterView(view);
        this.mListView.setOnTouchListener(this.efF.aJt);
        this.emS = new com.baidu.tieba.pb.pb.main.view.f(pbActivity);
        this.eoO = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.emS.eqc);
        this.eoO.hb(3);
        if (this.efF.aJf()) {
            this.emU = (ViewStub) this.efF.findViewById(w.h.manga_view_stub);
            this.emU.setVisibility(0);
            this.emT = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
            this.emT.show();
            this.emS.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.avJ.setLayoutParams(layoutParams);
        this.emS.aMn().setOnTouchListener(new com.baidu.tieba.pb.a.a(new gn(this)));
        this.eoo = this.efF.findViewById(w.h.pb_editor_tool_comment);
        this.eop = (TextView) this.efF.findViewById(w.h.pb_editor_tool_comment_reply_text);
        this.eoq = (ViewGroup) this.efF.findViewById(w.h.pb_editor_tool_comment_reply_layout);
        this.eor = (ImageView) this.efF.findViewById(w.h.pb_editor_tool_comment_share_icon);
        this.eos = (TextView) this.efF.findViewById(w.h.pb_editor_tool_comment_praise_icon);
        boolean aj = com.baidu.tieba.graffiti.c.aj(this.eos);
        if (aj) {
            iB(aj);
            this.eos.setVisibility(0);
        }
        this.eor.setOnClickListener(this.bPI);
        this.eoq.setOnClickListener(new go(this));
        this.eos.setOnClickListener(this.bPI);
        this.eos.setOnTouchListener(this.efF);
        this.emX = LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_item, (ViewGroup) null);
        this.enb = (LinearLayout) LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_user_item, (ViewGroup) null);
        this.enf = new g(this.efF, this.enb);
        this.enf.init();
        this.enf.a(this.enf.aIH(), this.bPI);
        this.eng = (ColumnLayout) this.enb.findViewById(w.h.pb_head_owner_root);
        this.enh = (ThreadSkinView) this.enb.findViewById(w.h.pb_thread_skin);
        this.eng.setOnLongClickListener(this.onLongClickListener);
        this.eng.setOnTouchListener(this.eeF);
        this.eng.setVisibility(8);
        this.emX.setOnTouchListener(this.eeF);
        this.eoy = this.emX.findViewById(w.h.pb_head_activity_join_number_container);
        this.eoy.setVisibility(8);
        this.eoz = (TextView) this.emX.findViewById(w.h.pb_head_activity_join_number);
        this.eni = (TextView) this.eng.findViewById(w.h.pb_head_owner_info_user_name);
        this.enj = (TextView) this.eng.findViewById(w.h.floor_owner);
        this.enk = (ImageView) this.eng.findViewById(w.h.icon_forum_level);
        this.enm = (FrameLayout) this.eng.findViewById(w.h.pb_head_headImage_container);
        this.enn = (HeadImageView) this.eng.findViewById(w.h.pb_head_owner_photo);
        this.enl = (HeadPendantView) this.eng.findViewById(w.h.pb_pendant_head_owner_photo);
        this.enl.vY();
        if (this.enl.getHeadView() != null) {
            this.enl.getHeadView().setIsRound(true);
            this.enl.getHeadView().setDrawBorder(false);
        }
        if (this.enl.getPendantView() != null) {
            this.enl.getPendantView().setIsRound(true);
            this.enl.getPendantView().setDrawBorder(false);
        }
        this.eiW = (UserIconBox) this.eng.findViewById(w.h.show_icon_vip);
        this.eiX = (UserIconBox) this.eng.findViewById(w.h.show_icon_yinji);
        this.enp = (FloatingLayout) this.enb.findViewById(w.h.pb_head_owner_info_root);
        this.enu = (PbFirstFloorUserLikeButton) this.eng.findViewById(w.h.pb_like_button);
        this.env = new fk(pbActivity.getPageContext(), this.enu);
        this.enw = (TextView) this.eng.findViewById(w.h.pb_views);
        this.enx = (TextView) this.eng.findViewById(w.h.pb_item_first_floor_reply_time);
        this.eny = (TextView) this.eng.findViewById(w.h.pb_item_first_floor_location_address);
        this.epd = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.epe = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.enC = this.emX.findViewById(w.h.new_pb_header_item_line_above_livepost);
        this.ene = LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.layout_read_thread, (ViewGroup) null);
        this.enc = (TextView) this.ene.findViewById(w.h.pb_head_read_button);
        this.enb.addView(this.ene);
        this.enc.setOnClickListener(this.bPI);
        this.emH = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds2);
        this.emG = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds18);
        this.emF = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);
        this.aNF = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds32);
        this.enD = this.emX.findViewById(w.h.new_pb_header_item_line_below_livepost);
        this.emX.setOnLongClickListener(new gp(this));
        this.eoA = (ViewStub) this.bGH.findViewById(w.h.interview_status_stub);
        this.enG = new cq(this.efF, this.mListView);
        this.enG.u(this.bPI);
        this.enG.a(this.eeF);
        this.enG.setOnImageClickListener(this.aOe);
        this.eeE = new gq(this);
        this.enG.H(this.eeE);
        aLq();
        this.mListView.addHeaderView(this.emZ);
        this.mListView.addHeaderView(this.enb);
        this.mListView.addHeaderView(this.emX);
        this.enL = new PbListView(this.efF.getPageContext().getPageActivity());
        this.aFt = this.enL.getView().findViewById(w.h.pb_more_view);
        if (this.aFt != null) {
            this.aFt.setOnClickListener(this.bPI);
            com.baidu.tbadk.core.util.aq.j(this.aFt, w.g.pb_foot_more_trans_selector);
        }
        this.enL.wk();
        this.enL.dg(w.g.pb_foot_more_trans_selector);
        this.enL.dh(w.g.pb_foot_more_trans_selector);
        this.enN = this.efF.findViewById(w.h.viewstub_progress);
        this.efF.registerListener(this.epj);
        this.eno = com.baidu.tbadk.ala.c.nH().h(this.efF.getActivity(), 2);
        if (this.eno != null) {
            this.eno.setVisibility(8);
            this.enp.addView(this.eno, 2);
        }
        this.ejo = new PbFakeFloorModel(this.efF.getPageContext());
        this.eoN = new dq(this.efF.getPageContext(), this.ejo, this.bGH);
        this.ejo.a(new gr(this));
        if (this.efF.aIN() != null && !StringUtils.isNull(this.efF.aIN().aKw())) {
            this.efF.showToast(this.efF.aIN().aKw());
        }
        this.efF.registerListener(this.dhc);
    }

    public void aLo() {
        if (this.mListView != null) {
            this.mListView.removeHeaderView(this.emZ);
            this.mListView.removeHeaderView(this.enb);
            this.mListView.removeHeaderView(this.emX);
        }
    }

    private boolean k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aHG() == null || !fVar.aIa() || !TbadkCoreApplication.m9getInst().isTTSCanUse() || fVar.aHG().rw() == 1 || fVar.aHG().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aHG().ry() == null || fVar.aHG().ry().sQ() == 0) && !fVar.aHG().sq()) {
            BdUniqueId type = fVar.aHG().getType();
            return type == com.baidu.tbadk.core.data.bk.Xt || type == com.baidu.tbadk.core.data.bk.Xu || type == com.baidu.tbadk.core.data.bk.Xs;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.ene != null) {
            if (!z) {
                this.ene.setVisibility(8);
            } else if (!k(fVar)) {
                this.ene.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aHI() != null && fVar.aHI().size() > 0) {
                    postData = fVar.aHI().get(0);
                }
                if (postData != null && postData.bgM() == 1) {
                    p(this.aNF, this.emG, this.aNF, this.emH);
                } else {
                    p(this.aNF, this.emG, this.aNF, this.emF);
                }
                this.ene.setVisibility(0);
            }
        }
    }

    private void p(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enc.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.enc.setLayoutParams(layoutParams);
    }

    public TextView aLp() {
        return this.enc;
    }

    private void aLq() {
        if (this.emZ == null) {
            int g = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds40);
            com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds40);
            this.emZ = new LinearLayout(this.efF.getPageContext().getPageActivity());
            this.emZ.setOrientation(1);
            this.emZ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.emZ.setPadding(g, com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds40), g, com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds46));
            this.emZ.setGravity(17);
            this.ena = new TextView(this.efF.getPageContext().getPageActivity());
            this.ena.setGravity(3);
            this.ena.setMaxLines(2);
            this.ena.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.ena.setPadding(0, 0, 0, 0);
            this.ena.setLineSpacing(com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.aq.i(this.ena, w.e.cp_cont_b);
            this.ena.setTextSize(0, com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds48));
            this.ena.setVisibility(8);
            this.emZ.addView(this.ena);
            this.emZ.setOnTouchListener(this.eeF);
            this.emZ.setOnLongClickListener(new fo(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLr() {
        if (this.efF.aJf()) {
            this.emV = (ViewStub) this.efF.findViewById(w.h.manga_mention_controller_view_stub);
            this.emV.setVisibility(0);
            if (this.enz == null) {
                this.enz = (LinearLayout) this.efF.findViewById(w.h.manga_controller_layout);
                com.baidu.tbadk.m.a.a(this.efF.getPageContext(), this.enz);
            }
            if (this.enA == null) {
                this.enA = (TextView) this.enz.findViewById(w.h.manga_prev_btn);
            }
            if (this.enB == null) {
                this.enB = (TextView) this.enz.findViewById(w.h.manga_next_btn);
            }
            this.enA.setOnClickListener(this.bPI);
            this.enB.setOnClickListener(this.bPI);
        }
    }

    private void aLs() {
        if (this.efF.aJf()) {
            if (this.efF.aJi() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.enA, w.e.cp_cont_e, 1);
            }
            if (this.efF.aJj() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.enB, w.e.cp_cont_e, 1);
            }
        }
    }

    public void aLt() {
        if (this.enz == null) {
            aLr();
        }
        this.emV.setVisibility(8);
        if (this.eph != null && this.epi != null) {
            this.eph.removeCallbacks(this.epi);
        }
    }

    public void aLu() {
        if (this.eph != null) {
            if (this.epi != null) {
                this.eph.removeCallbacks(this.epi);
            }
            this.epi = new fp(this);
            this.eph.postDelayed(this.epi, 2000L);
        }
    }

    public void iw(boolean z) {
        this.emS.iw(z);
        if (z && this.eox) {
            this.enL.setText(this.efF.getResources().getString(w.l.click_load_more));
            this.mListView.setNextPage(this.enL);
            this.emR = 2;
        }
    }

    public void aLv() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.bGH.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kg = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.bGH.addView(this.Kg, layoutParams);
        this.Kg.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.Kg.hide();
    }

    public void aLw() {
        if (this.efF != null && this.Kg != null) {
            this.Kg.lW();
        }
    }

    public void P(String str, boolean z) {
        this.eou = z;
        aO(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void aO(boolean z) {
        if (this.eos != null) {
            if (this.eou) {
                com.baidu.tbadk.core.util.aq.j(this.eos, w.g.pb_praise_already_click_selector);
                this.eos.setContentDescription(this.efF.getResources().getString(w.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aq.j(this.eos, w.g.pb_praise_normal_click_selector);
            this.eos.setContentDescription(this.efF.getResources().getString(w.l.frs_item_praise_text));
        }
    }

    public TextView aLx() {
        return this.eos;
    }

    public void ix(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
                return;
            }
            if (this.eoM == null) {
                this.eoM = new fq(this, z);
            }
            com.baidu.adp.lib.g.h.fS().postDelayed(this.eoM, 10L);
        }
    }

    public void iy(boolean z) {
        if (this.mListView != null && this.avJ != null && this.bIA != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bIA.setVisibility(0);
                } else {
                    this.bIA.setVisibility(8);
                    this.mListView.removeHeaderView(this.avJ);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.avJ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.avJ.setLayoutParams(layoutParams);
                }
                aLN();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.avJ.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + iG(true);
                this.avJ.setLayoutParams(layoutParams2);
            }
            aLN();
            aMf();
        }
    }

    public void aV(View view) {
        boolean z;
        View view2;
        if (this.enF != null && view != null) {
            if (this.eot) {
                z = this.eoo.getVisibility() == 0;
            } else {
                z = this.Kg != null && this.Kg.getVisibility() == 0;
            }
            boolean z2 = this.enF.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.egn = true;
                View findViewById = this.efF.findViewById(w.h.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.enF.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.efF, this.enF, w.a.top_fold_up, new fr(this, findViewById));
            } else {
                this.egn = false;
                com.baidu.tieba.tbadkCore.a.a(this.efF, this.enF, w.a.top_fold_down, new fs(this));
            }
            if (this.eot) {
                view2 = this.eoo;
            } else {
                view2 = this.Kg;
            }
            if (z) {
                if (z2) {
                    if (this.Kg != null) {
                        this.Kg.AN();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.efF, view2, w.a.bottom_fold_down, new ft(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.efF, view2, w.a.bottom_fold_up, new fu(this));
            }
        }
    }

    public cq aLy() {
        return this.enG;
    }

    public void aLz() {
        if (this.enG != null) {
            this.enG.aJA();
        }
    }

    public void a(PbActivity.c cVar) {
        this.ehj = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bp bpVar) {
        if (bpVar == null || bpVar.sQ() == 0) {
            if (this.eon != null) {
                this.eon.setVisibility(8);
            }
            if (this.enC != null) {
                this.enC.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eon == null) {
            this.efF.getLayoutMode().t(((ViewStub) this.emX.findViewById(w.h.live_talk_layout)).inflate());
            this.eon = (Button) this.emX.findViewById(w.h.pb_head_function_manage_go_to_live_post);
            this.enC = this.emX.findViewById(w.h.new_pb_header_item_line_above_livepost);
        }
        int sR = bpVar.sR();
        String string = this.efF.getPageContext().getString(w.l.go_to_live_post_prefix);
        if (sR == 0) {
            string = String.valueOf(string) + this.efF.getPageContext().getString(w.l.go_to_interview_post);
        } else if (sR == 1) {
            string = String.valueOf(string) + this.efF.getPageContext().getString(w.l.go_to_discuss_post);
        }
        this.eon.setText(string);
        this.eon.setVisibility(0);
        this.eon.setOnClickListener(this.bPI);
        this.epn = true;
        aLO();
    }

    public void aW(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.enP == null) {
            this.enP = LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.efF.getLayoutMode().t(this.enP);
        if (this.enO == null) {
            this.enO = new Dialog(this.efF.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.enO.setCanceledOnTouchOutside(true);
            this.enO.setCancelable(true);
            this.enO.setContentView(this.enP);
            WindowManager.LayoutParams attributes = this.enO.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.efF.getPageContext().getPageActivity()) * 0.9d);
            this.enO.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.enO.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.enO.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.enO.findViewById(w.h.disable_reply_btn);
        int intValue = sparseArray.get(w.h.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(w.h.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(w.h.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(w.h.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(w.l.delete);
            } else {
                textView.setText(w.l.delete_post);
            }
            sparseArray2.put(w.h.tag_del_post_id, sparseArray.get(w.h.tag_del_post_id));
            sparseArray2.put(w.h.tag_del_post_type, sparseArray.get(w.h.tag_del_post_type));
            sparseArray2.put(w.h.tag_del_post_is_self, sparseArray.get(w.h.tag_del_post_is_self));
            sparseArray2.put(w.h.tag_manage_user_identity, sparseArray.get(w.h.tag_manage_user_identity));
            textView.setOnClickListener(new fv(this));
        }
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name)) || aMb()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(w.h.tag_forbid_user_name, sparseArray.get(w.h.tag_forbid_user_name));
            sparseArray5.put(w.h.tag_manage_user_identity, sparseArray.get(w.h.tag_manage_user_identity));
            sparseArray5.put(w.h.tag_forbid_user_post_id, sparseArray.get(w.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new fw(this));
        }
        if (!((sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(w.l.un_mute);
            } else {
                textView3.setText(w.l.mute);
            }
            sparseArray6.put(w.h.tag_is_mem, sparseArray.get(w.h.tag_is_mem));
            sparseArray6.put(w.h.tag_user_mute_mute_userid, sparseArray.get(w.h.tag_user_mute_mute_userid));
            sparseArray6.put(w.h.tag_user_mute_mute_username, sparseArray.get(w.h.tag_user_mute_mute_username));
            sparseArray6.put(w.h.tag_user_mute_post_id, sparseArray.get(w.h.tag_user_mute_post_id));
            sparseArray6.put(w.h.tag_user_mute_thread_id, sparseArray.get(w.h.tag_user_mute_thread_id));
            sparseArray6.put(w.h.tag_user_mute_msg, sparseArray.get(w.h.tag_user_mute_msg));
            textView3.setOnClickListener(new fy(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.enO, this.efF.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.epk = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eoG, Integer.valueOf(eoH));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.enQ = new com.baidu.tbadk.core.dialog.a(this.efF.getActivity());
        this.enQ.bX(i3);
        this.enQ.A(sparseArray);
        this.enQ.a(w.l.dialog_ok, this.efF);
        this.enQ.b(w.l.dialog_cancel, new fz(this));
        this.enQ.as(true);
        this.enQ.b(this.efF.getPageContext());
        this.enQ.td();
    }

    public void ak(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eoc == null) {
            this.eoc = LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.commit_good, (ViewGroup) null);
        }
        this.efF.getLayoutMode().t(this.eoc);
        if (this.eob == null) {
            this.eob = new Dialog(this.efF.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.eob.setCanceledOnTouchOutside(true);
            this.eob.setCancelable(true);
            this.eom = (ScrollView) this.eoc.findViewById(w.h.good_scroll);
            this.eob.setContentView(this.eoc);
            WindowManager.LayoutParams attributes = this.eob.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds540);
            this.eob.getWindow().setAttributes(attributes);
            this.eoe = new ga(this);
            this.eod = (LinearLayout) this.eoc.findViewById(w.h.good_class_group);
            this.eoh = (TextView) this.eoc.findViewById(w.h.dialog_button_cancel);
            this.eoh.setOnClickListener(new gb(this));
            this.eog = (TextView) this.eoc.findViewById(w.h.dialog_button_ok);
            this.eog.setOnClickListener(this.bPI);
        }
        this.eod.removeAllViews();
        this.emW = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bK = bK("0", this.efF.getPageContext().getString(w.l.def_good_class));
        this.emW.add(bK);
        bK.setChecked(true);
        this.eod.addView(bK);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bK2 = bK(String.valueOf(arrayList.get(i2).pY()), arrayList.get(i2).pX());
                this.emW.add(bK2);
                View view = new View(this.efF.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds1));
                com.baidu.tbadk.core.util.aq.k(view, w.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eod.addView(view);
                this.eod.addView(bK2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eom.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.efF.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.efF.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.efF.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eom.setLayoutParams(layoutParams2);
            this.eom.removeAllViews();
            this.eom.addView(this.eod);
        }
        com.baidu.adp.lib.g.j.a(this.eob, this.efF.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bK(String str, String str2) {
        Activity pageActivity = this.efF.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds100));
        aVar.setOnCheckedChangeListener(this.eoe);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aLA() {
        this.efF.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.efF.hideProgressBar();
        if (z && z2) {
            this.efF.showToast(this.efF.getPageContext().getString(w.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(w.l.neterror);
            }
            this.efF.showToast(str);
        }
    }

    public void apn() {
        this.enN.setVisibility(0);
    }

    public void apm() {
        this.enN.setVisibility(8);
    }

    public View aLB() {
        if (this.eoc != null) {
            return this.eoc.findViewById(w.h.dialog_button_ok);
        }
        return null;
    }

    public String aLC() {
        return this.eoi;
    }

    public View getView() {
        return this.bGH;
    }

    public void aLD() {
        com.baidu.adp.lib.util.k.b(this.efF.getPageContext().getPageActivity(), this.efF.getCurrentFocus());
    }

    public void iz(boolean z) {
        this.efF.hideProgressBar();
        auE();
    }

    public void aLE() {
        this.enL.wk();
        this.enL.wo();
    }

    public void aLF() {
        this.efF.hideProgressBar();
        wp();
        this.mListView.completePullRefreshPostDelayed(2000L);
        aLO();
    }

    public void aLG() {
        this.mListView.completePullRefreshPostDelayed(2000L);
        aLO();
    }

    public void iA(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eoq.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.efF.getResources().getDimensionPixelSize(w.f.ds84) : 0;
        this.eoq.setLayoutParams(marginLayoutParams);
    }

    private void iB(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds14);
        if (z) {
            i = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds16);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eoq.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.eoq.setLayoutParams(layoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.enG.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.eoj != null) {
            this.eoj.dismiss();
            this.eoj = null;
        }
        this.eoj = new com.baidu.tbadk.core.dialog.c(this.efF.getPageContext().getPageActivity());
        this.eoj.ca(w.l.operation);
        if (z2) {
            this.eoj.a(new String[]{this.efF.getPageContext().getString(w.l.copy)}, bVar);
        } else if (!z) {
            this.eoj.a(new String[]{this.efF.getPageContext().getString(w.l.copy), this.efF.getPageContext().getString(w.l.mark)}, bVar);
        } else {
            this.eoj.a(new String[]{this.efF.getPageContext().getString(w.l.copy), this.efF.getPageContext().getString(w.l.remove_mark)}, bVar);
        }
        this.eoj.d(this.efF.getPageContext());
        this.eoj.tg();
    }

    public int aLH() {
        return op(this.mListView.getFirstVisiblePosition());
    }

    private int op(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.mListView.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.lk()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.mListView.getAdapter() == null || !(this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aLI() {
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        if (this.emL != null) {
            if (lastVisiblePosition == this.mListView.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.enG.aJB();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return op(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.mListView.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.enJ.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void l(com.baidu.tieba.pb.data.f fVar) {
        this.enG.a(fVar, false);
        this.enG.notifyDataSetChanged();
        aLO();
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        PraiseData ro;
        if (this.ens == null) {
            this.efF.getLayoutMode().t(((ViewStub) this.emX.findViewById(w.h.praise_layout)).inflate());
            this.ens = (FrsPraiseView) this.emX.findViewById(w.h.pb_head_praise_view);
            this.ens.setIsFromPb(true);
            this.enE = this.emX.findViewById(w.h.new_pb_header_item_line_above_praise);
            this.ens.dm(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.ens != null) {
            boolean aLO = aLO();
            if (fVar != null && fVar.aHI() != null && fVar.aHI().size() > 0) {
                PostData postData = fVar.aHI().get(0);
                if ((!this.eeA || postData.bgM() != 1) && (ro = fVar.aHG().ro()) != null && ro.getUser() != null && ro.getUser().size() > 0) {
                    this.ens.setVisibility(0);
                    this.ens.setIsFromPb(true);
                    this.ens.a(ro, fVar.aHG().getId(), ro.getPostId(), true);
                    this.ens.getVisibility();
                    com.baidu.tieba.graffiti.c.aj(this.ens);
                    return;
                }
            }
            this.ens.setVisibility(8);
            if (fVar != null && fVar.qB() != null && fVar.qB().qy() == 0 && this.eeA) {
                if (aLO) {
                    this.enD.setVisibility(0);
                } else {
                    this.enD.setVisibility(8);
                }
            } else {
                this.enD.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.aj(this.enD);
        }
    }

    private PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aHP() != null) {
            return fVar.aHP();
        }
        if (z) {
            if (fVar == null || fVar.aHI() == null || fVar.aHI().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aHI().get(0);
            if (postData.bgM() != 1) {
                postData = a(fVar);
            }
            if (postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
                return postData;
            }
            return postData;
        }
        PostData aHN = fVar.aHN();
        if (aHN == null) {
            return a(fVar);
        }
        return aHN;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aHG() == null || fVar.aHG().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aHG().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aHG().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.rQ(1);
        postData.setId(fVar.aHG().rO());
        postData.setTitle(fVar.aHG().getTitle());
        postData.setTime(fVar.aHG().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x031e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        boolean z2;
        int i2;
        String d;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.f bgP;
        String portrait;
        if (fVar != null && fVar.aHG() != null) {
            PostData c = c(fVar, z);
            a(c, fVar);
            aMc();
            this.eng.setVisibility(8);
            if (fVar.aHG() != null && fVar.aHG().sl() && fVar.aHG().rP() != null) {
                this.emS.iL(true);
                if (this.emL == null || this.emO == null) {
                    aLJ();
                    this.emL.a(fVar.aHG().rP(), fVar.aHG(), fVar.getForumId());
                    this.emL.startPlay();
                } else if (this.emM) {
                    this.emL.a(fVar.aHG().rP(), fVar.aHG(), fVar.getForumId());
                    this.emL.startPlay();
                }
                if (fVar.aHH() != null && fVar.aHH().size() >= 1) {
                    com.baidu.tbadk.core.data.bk bkVar = fVar.aHH().get(0);
                    this.emL.K(bkVar);
                    this.emL.nZ(bkVar.getTitle());
                }
                this.emM = false;
                if (this.eoC == null) {
                    this.eoC = new TextView(this.efF.getActivity());
                    this.eoC.setLayoutParams(new AbsListView.LayoutParams(-1, this.emK));
                }
                this.mListView.removeHeaderView(this.eoC);
                this.mListView.addHeaderView(this.eoC, 0);
                if (this.emN == null) {
                    this.emN = new com.baidu.tieba.pb.video.d(LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.pb_header_video_abstract_layout, (ViewGroup) null));
                }
                this.emN.J(fVar.aHG());
                this.mListView.removeHeaderView(this.emN.mRootView);
                this.mListView.addHeaderView(this.emN.mRootView, 1);
                if (fVar.aHG().sC() != null) {
                    n(fVar);
                    this.mListView.removeHeaderView(this.emP.mRootView);
                    this.mListView.removeHeaderView(this.enb);
                    this.mListView.addHeaderView(this.emP.mRootView, 2);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.emN.esB.getLayoutParams();
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds26);
                    this.emN.esB.setLayoutParams(layoutParams);
                } else {
                    if (this.emP != null && this.emP.mRootView != null) {
                        this.mListView.removeHeaderView(this.emP.mRootView);
                    }
                    if (com.baidu.adp.lib.b.e.eZ().Y("video_channel_pb_portrait_switch") == 0) {
                        i(c);
                        this.mListView.removeHeaderView(this.enb);
                        this.mListView.removeHeaderView(this.emQ);
                        this.mListView.addHeaderView(this.emQ, 2);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.emN.esB.getLayoutParams();
                        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds30);
                        this.emN.esB.setLayoutParams(layoutParams2);
                    } else {
                        aLK();
                        if (this.emQ != null) {
                            this.mListView.removeHeaderView(this.emQ);
                        }
                        this.mListView.removeHeaderView(this.enb);
                        this.mListView.addHeaderView(this.enb, 2);
                    }
                }
                if (this.emL != null) {
                    this.emL.or(0);
                }
                aLN();
                z2 = true;
            } else {
                this.emS.iL(false);
                if (this.emJ != null) {
                    this.emJ.setVisibility(8);
                }
                if (this.eoC != null) {
                    this.mListView.removeHeaderView(this.eoC);
                }
                if (this.emN != null) {
                    this.mListView.removeHeaderView(this.emN.mRootView);
                }
                if (this.emP != null) {
                    this.mListView.removeHeaderView(this.emP.mRootView);
                }
                z2 = false;
            }
            if (this.efF.aIL() != null) {
                this.efF.aIL().iJ(z2);
            }
            gc gcVar = new gc(this, z2);
            if (this.emQ != null) {
                this.emQ.setOnClickListener(gcVar);
            }
            b(fVar, z);
            if (c != null) {
                this.eow = c;
                if (fVar != null && fVar.aHG() != null && fVar.aHG().getAuthor() != null) {
                    fVar.aHG().getAuthor().getUserId();
                    if (fVar.qB() != null) {
                        this.eoW = fVar.qB().qu();
                        if (fVar.qB().qx() == 1) {
                        }
                    }
                }
                this.eng.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eng.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eng.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_clip_board, c);
                sparseArray.put(w.h.tag_is_subpb, false);
                fVar.aHG().sh();
                if (!this.epb) {
                    this.emZ.setVisibility(0);
                }
                if (!fVar.aHG().sl() && this.ena.getText() != null && this.ena.getText().length() > 0) {
                    this.ena.setVisibility(0);
                } else {
                    this.ena.setVisibility(8);
                }
                m(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rJ = fVar.aHG().rJ();
                if (rJ != null && rJ.size() > 0 && !this.epb) {
                    this.eoz.setText(String.valueOf(rJ.get(0).pp()));
                    this.eoy.setVisibility(0);
                    this.epm = true;
                } else {
                    this.eoy.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.j(this.eoy, w.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aq.c(this.eoz, w.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    String string = c.getAuthor().getName_show() == null ? StringUtils.string(c.getAuthor().getUserName()) : StringUtils.string(c.getAuthor().getName_show());
                    if (StringUtils.isNull(c.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aF(c.getAuthor().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aF(string) > 12) {
                            d = com.baidu.tbadk.core.util.au.d(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aF = com.baidu.adp.lib.util.j.aF(c.getAuthor().getName_show());
                                if (aF + i2 > 14) {
                                    i3 = 0;
                                } else if (aF + i2 >= 12) {
                                    i3 = 1;
                                } else if (aF + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eiX != null) {
                                this.eiX.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                                this.eiX.setOnClickListener(this.efF.egu.bWW);
                                this.eiX.a(iconInfo, i3, this.efF.getResources().getDimensionPixelSize(w.f.ds26), this.efF.getResources().getDimensionPixelSize(w.f.ds26), this.efF.getResources().getDimensionPixelSize(w.f.ds8));
                            }
                            if (this.eiW != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eiW.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eiW.setOnClickListener(this.efF.egu.epC);
                                this.eiW.a(tShowInfoNew, 3, this.efF.getResources().getDimensionPixelSize(w.f.ds36), this.efF.getResources().getDimensionPixelSize(w.f.ds36), this.efF.getResources().getDimensionPixelSize(w.f.ds8), true);
                            }
                            this.eni.setText(af(c.getAuthor().getSealPrefix(), d));
                            this.eni.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                            this.eni.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                                com.baidu.tbadk.core.util.aq.c(this.eni, w.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aq.c(this.eni, w.e.cp_cont_f, 1);
                            }
                            com.baidu.tbadk.core.util.aq.c(this.enj, w.e.cp_link_tip_a, 1);
                            this.enj.setVisibility(0);
                            if (fVar.aHG().getAuthor() != null && fVar.aHG().getAuthor().getAlaUserData() != null && this.eno != null) {
                                if (fVar.aHG().getAuthor().getAlaUserData().anchor_live != 0 && fVar.aHG().getAuthor().getAlaUserData().enter_live == 0) {
                                    this.eno.setVisibility(8);
                                } else {
                                    this.eno.setVisibility(0);
                                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                                    bVar.Qj = fVar.aHG().getAuthor().getAlaUserData();
                                    bVar.type = 2;
                                    this.eno.setTag(bVar);
                                }
                            }
                            this.enn.setUserId(c.getAuthor().getUserId());
                            this.enn.setUserName(c.getAuthor().getUserName());
                            this.enn.setImageDrawable(null);
                            this.enn.setRadius(com.baidu.adp.lib.util.k.g(this.efF.getActivity(), w.f.ds40));
                            this.enn.setTag(c.getAuthor().getUserId());
                            this.enx.setText(c.bgO());
                            bgP = c.bgP();
                            if (bgP == null && !TextUtils.isEmpty(bgP.getName()) && !TextUtils.isEmpty(bgP.getName().trim())) {
                                String name = bgP.getName();
                                String lat = bgP.getLat();
                                String lng = bgP.getLng();
                                this.eny.setVisibility(0);
                                this.eny.setText(bgP.getName());
                                this.eny.setOnClickListener(new gd(this, lat, lng, name));
                            } else {
                                this.eny.setVisibility(8);
                            }
                            this.env.a(c.getAuthor());
                            this.env.emD = z2;
                            if (!this.eol) {
                                this.enu.setVisibility(8);
                                this.enw.setVisibility(0);
                                this.enw.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.pb_thread_views), com.baidu.tbadk.core.util.au.v(fVar.aIc())));
                            } else if (!PbNormalLikeButtonSwitchStatic.Gd() || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.enu.setVisibility(8);
                                this.enw.setVisibility(8);
                            } else {
                                this.enu.setVisibility(0);
                                this.enu.setTextSize(0, com.baidu.adp.lib.util.k.g(this.efF.getActivity(), w.f.ds24));
                                this.enw.setVisibility(8);
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null && !StringUtils.isNull(c.getAuthor().getPendantData().pT())) {
                                this.enn.setVisibility(8);
                                this.enl.setVisibility(0);
                                if (this.ent != null) {
                                    this.ent.setVisibility(8);
                                }
                                this.eni.setOnClickListener(gcVar);
                                this.enl.getHeadView().c(portrait, 28, false);
                                this.enl.getHeadView().setUserId(c.getAuthor().getUserId());
                                this.enl.getHeadView().setUserName(c.getAuthor().getUserName());
                                this.enl.getHeadView().setOnClickListener(gcVar);
                                this.enl.dS(c.getAuthor().getPendantData().pT());
                            } else {
                                this.enn.setVisibility(0);
                                this.eng.setOnClickListener(gcVar);
                                this.eni.setOnClickListener(gcVar);
                                this.enn.setOnClickListener(gcVar);
                                this.enl.setVisibility(8);
                                this.enn.c(portrait, 28, false);
                            }
                        }
                        d = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eiX != null) {
                        }
                        if (this.eiW != null) {
                        }
                        this.eni.setText(af(c.getAuthor().getSealPrefix(), d));
                        this.eni.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.eni.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aq.c(this.enj, w.e.cp_link_tip_a, 1);
                        this.enj.setVisibility(0);
                        if (fVar.aHG().getAuthor() != null) {
                            if (fVar.aHG().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                            this.eno.setVisibility(0);
                            com.baidu.tbadk.ala.b bVar2 = new com.baidu.tbadk.ala.b();
                            bVar2.Qj = fVar.aHG().getAuthor().getAlaUserData();
                            bVar2.type = 2;
                            this.eno.setTag(bVar2);
                        }
                        this.enn.setUserId(c.getAuthor().getUserId());
                        this.enn.setUserName(c.getAuthor().getUserName());
                        this.enn.setImageDrawable(null);
                        this.enn.setRadius(com.baidu.adp.lib.util.k.g(this.efF.getActivity(), w.f.ds40));
                        this.enn.setTag(c.getAuthor().getUserId());
                        this.enx.setText(c.bgO());
                        bgP = c.bgP();
                        if (bgP == null) {
                        }
                        this.eny.setVisibility(8);
                        this.env.a(c.getAuthor());
                        this.env.emD = z2;
                        if (!this.eol) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        this.enn.setVisibility(0);
                        this.eng.setOnClickListener(gcVar);
                        this.eni.setOnClickListener(gcVar);
                        this.enn.setOnClickListener(gcVar);
                        this.enl.setVisibility(8);
                        this.enn.c(portrait, 28, false);
                    } else {
                        if (com.baidu.adp.lib.util.j.aF(string) > 14) {
                            d = com.baidu.tbadk.core.util.au.d(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eiX != null) {
                            }
                            if (this.eiW != null) {
                            }
                            this.eni.setText(af(c.getAuthor().getSealPrefix(), d));
                            this.eni.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                            this.eni.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aq.c(this.enj, w.e.cp_link_tip_a, 1);
                            this.enj.setVisibility(0);
                            if (fVar.aHG().getAuthor() != null) {
                            }
                            this.enn.setUserId(c.getAuthor().getUserId());
                            this.enn.setUserName(c.getAuthor().getUserName());
                            this.enn.setImageDrawable(null);
                            this.enn.setRadius(com.baidu.adp.lib.util.k.g(this.efF.getActivity(), w.f.ds40));
                            this.enn.setTag(c.getAuthor().getUserId());
                            this.enx.setText(c.bgO());
                            bgP = c.bgP();
                            if (bgP == null) {
                            }
                            this.eny.setVisibility(8);
                            this.env.a(c.getAuthor());
                            this.env.emD = z2;
                            if (!this.eol) {
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null) {
                            }
                            this.enn.setVisibility(0);
                            this.eng.setOnClickListener(gcVar);
                            this.eni.setOnClickListener(gcVar);
                            this.enn.setOnClickListener(gcVar);
                            this.enl.setVisibility(8);
                            this.enn.c(portrait, 28, false);
                        }
                        d = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eiX != null) {
                        }
                        if (this.eiW != null) {
                        }
                        this.eni.setText(af(c.getAuthor().getSealPrefix(), d));
                        this.eni.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.eni.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aq.c(this.enj, w.e.cp_link_tip_a, 1);
                        this.enj.setVisibility(0);
                        if (fVar.aHG().getAuthor() != null) {
                        }
                        this.enn.setUserId(c.getAuthor().getUserId());
                        this.enn.setUserName(c.getAuthor().getUserName());
                        this.enn.setImageDrawable(null);
                        this.enn.setRadius(com.baidu.adp.lib.util.k.g(this.efF.getActivity(), w.f.ds40));
                        this.enn.setTag(c.getAuthor().getUserId());
                        this.enx.setText(c.bgO());
                        bgP = c.bgP();
                        if (bgP == null) {
                        }
                        this.eny.setVisibility(8);
                        this.env.a(c.getAuthor());
                        this.env.emD = z2;
                        if (!this.eol) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        this.enn.setVisibility(0);
                        this.eng.setOnClickListener(gcVar);
                        this.eni.setOnClickListener(gcVar);
                        this.enn.setOnClickListener(gcVar);
                        this.enl.setVisibility(8);
                        this.enn.c(portrait, 28, false);
                    }
                }
                if (fVar != null) {
                    this.enf.H(fVar.aHG());
                }
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.eng.getLayoutParams();
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getContext(), w.f.ds52);
                this.eng.setLayoutParams(layoutParams3);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rT() != null) {
            this.enh.a(this.efF.getPageContext(), fVar.aHI().get(0).rT(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aHE().getId(), fVar.aHE().getName(), fVar.aHG().getId(), this.efF.aJp() ? "FRS" : null));
            this.eng.setPadding(this.eng.getPaddingLeft(), (int) this.efF.getResources().getDimension(w.f.ds20), this.eng.getPaddingRight(), this.eng.getPaddingBottom());
            return;
        }
        this.enh.a(null, null, null);
    }

    private void aLJ() {
        this.emJ = (FrameLayout) this.efF.findViewById(w.h.root_float_header);
        int af = com.baidu.adp.lib.util.k.af(this.efF.getActivity());
        int i = (int) (af * 0.5625d);
        this.emK = i;
        this.emJ.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        this.emO = new com.baidu.tieba.play.c(this.efF.getPageContext(), this.emJ);
        this.emL = new com.baidu.tieba.pb.video.g(this.efF, this.emO, this.emJ, this.emS, this.emK);
    }

    private void n(com.baidu.tieba.pb.data.f fVar) {
        if (this.emP == null) {
            this.emP = new com.baidu.tieba.pb.video.e(this.efF, LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.video_pb_video_channel_info_layout, (ViewGroup) null));
        }
        com.baidu.tbadk.core.data.br sC = fVar.aHG().sC();
        if (fVar.getUserData() != null) {
            sC.Zt = fVar.aHZ();
        }
        this.emP.b(sC);
        fVar.aHG().a(sC);
    }

    private void i(PostData postData) {
        if (this.emQ == null) {
            this.emQ = new TextView(this.efF.getActivity());
            this.emQ.setClickable(true);
            this.emQ.setTextSize(0, this.efF.getResources().getDimensionPixelSize(w.f.fontsize24));
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            this.emQ.setSingleLine(true);
            this.emQ.setEllipsize(TextUtils.TruncateAt.END);
            this.emQ.setLayoutParams(layoutParams);
            this.emQ.setGravity(16);
            int g = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds32);
            this.emQ.setPadding(g, 0, g, com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds40));
            com.baidu.tbadk.core.util.aq.c(this.emQ, w.e.cp_cont_j, 1);
        }
        String string = this.efF.getResources().getString(w.l.video_public_owner);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        if (postData != null && postData.getAuthor() != null) {
            String name_show = postData.getAuthor().getName_show();
            this.emQ.setTag(w.h.tag_user_id, String.valueOf(postData.getAuthor().getUserId()));
            this.emQ.setTag(w.h.tag_user_name, name_show);
            sb.append(" " + name_show);
            SpannableString spannableString = new SpannableString(sb);
            spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), string.length(), sb.length(), 33);
            this.emQ.setText(spannableString);
            return;
        }
        this.emQ.setText(string);
    }

    private void aLK() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.emN.esB.getLayoutParams();
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds26);
        this.emN.esB.setLayoutParams(layoutParams);
        this.eng.setPadding(this.eng.getPaddingLeft(), this.eng.getPaddingTop(), this.eng.getPaddingRight(), com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds34));
        if (this.enu.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.enu.getLayoutParams();
            aVar.bottomMargin = com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds20);
            this.enu.setLayoutParams(aVar);
        }
    }

    public void aLL() {
        if (this.emL != null) {
            this.emL.aNI();
        }
    }

    public boolean aLM() {
        return this.epo;
    }

    private boolean Nd() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean E(com.baidu.tbadk.core.data.bk bkVar) {
        if (bkVar == null || bkVar.getAuthor() == null || bkVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bkVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.emS.aMr();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.emS.lt(eVar.forumName);
                if (this.emL != null) {
                    this.emL.aNC();
                }
            }
            String string = this.efF.getResources().getString(w.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.efF.getResources().getString(w.l.self);
                    break;
                case 300:
                    str = this.efF.getResources().getString(w.l.bawu);
                    break;
                case 400:
                    str = this.efF.getResources().getString(w.l.system);
                    break;
            }
            this.efF.showNetRefreshView(this.bGH, String.format(string, str), null, this.efF.getResources().getString(w.l.appeal_restore), true, new ge(this, eVar.ecU));
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aLc;
        String sb;
        if (fVar != null) {
            this.ejL = fVar;
            this.mType = i;
            if (fVar.aHG() != null) {
                this.eoD = fVar.aHG().rm();
                this.YA = fVar.aHG().rj();
                if (fVar.aHG().getAnchorLevel() != 0) {
                    this.epo = true;
                }
                this.eol = E(fVar.aHG());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            p(fVar);
            this.eox = false;
            this.eeA = z;
            aLF();
            b(fVar, z, i);
            if (this.efF.aJf()) {
                if (this.enK == null) {
                    this.enK = new com.baidu.tieba.pb.view.m(this.efF.getPageContext());
                    this.enK.le();
                    this.enK.a(this.alm);
                }
                this.mListView.setPullRefresh(this.enK);
                aLN();
                if (this.enK != null) {
                    this.enK.di(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (fVar.qB().qy() == 0 && z) {
                this.mListView.setPullRefresh(null);
                this.emI = 1;
            } else {
                if (this.enK == null) {
                    this.enK = new com.baidu.tieba.pb.view.m(this.efF.getPageContext());
                    this.enK.le();
                    this.enK.a(this.alm);
                }
                this.mListView.setPullRefresh(this.enK);
                aLN();
                this.emI = 2;
                if (this.enK != null) {
                    this.enK.di(TbadkCoreApplication.m9getInst().getSkinType());
                }
                aGA();
            }
            aLO();
            this.enG.hM(this.eeA);
            this.enG.hN(false);
            this.enG.hY(i == 5);
            this.enG.hZ(i == 6);
            this.enG.a(fVar, false);
            this.enG.notifyDataSetChanged();
            if (this.efF.aJt()) {
                if (fVar.aHF() != null) {
                    this.mForumName = fVar.aHF().getForumName();
                    this.mForumId = fVar.aHF().getForumId();
                }
                if (this.mForumName == null && this.efF.aIN() != null && this.efF.aIN().aJS() != null) {
                    this.mForumName = this.efF.aIN().aJS();
                }
                this.emS.lt(this.mForumName);
            } else {
                this.emS.lt(null);
            }
            if (this.efF.aJt()) {
                int i4 = 0;
                PostData c = c(fVar, z);
                if (c != null && c.getAuthor() != null) {
                    i4 = c.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.enk.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.c(this.enk, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.enk.setVisibility(8);
                }
            } else {
                this.enk.setVisibility(8);
            }
            if (this.emL != null) {
                this.emL.aNC();
            }
            if (fVar.aHG() != null && fVar.aHG().ro() != null) {
                if (fVar.aHG().ro().getNum() < 1) {
                    sb = this.efF.getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(fVar.aHG().ro().getNum())).toString();
                }
                if (this.emE != -1) {
                    fVar.aHG().ro().setIsLike(this.emE);
                }
                P(sb, fVar.aHG().ro().getIsLike() == 1);
            }
            if (fVar.qB().qx() == 0 && !z) {
                this.mListView.setNextPage(null);
                this.emR = 1;
            } else if (this.efF.isLogin()) {
                this.mListView.setNextPage(this.enL);
                this.emR = 2;
                aGA();
            } else if (fVar.qB().qx() == 1) {
                this.eox = true;
                if (this.enM == null) {
                    this.enM = new com.baidu.tieba.pb.view.b(this.efF.getPageContext());
                }
                this.mListView.setNextPage(this.enM);
                this.emR = 3;
            }
            ArrayList<PostData> aHI = fVar.aHI();
            if (fVar.qB().qx() == 0 || aHI == null || aHI.size() < fVar.qB().qw()) {
                if (com.baidu.tbadk.core.util.x.q(aHI) == 0 || (com.baidu.tbadk.core.util.x.q(aHI) == 1 && aHI.get(0) != null && aHI.get(0).bgM() == 1)) {
                    this.enL.setText(this.efF.getResources().getString(w.l.list_no_more_new));
                } else {
                    this.enL.setText("");
                }
                if (this.efF.aJf() && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() == 1 && (this.mListView.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.enL.setText("");
                }
                aLT();
            } else if (z2) {
                if (this.epl) {
                    wp();
                    if (fVar.qB().qx() != 0) {
                        this.enL.setText(this.efF.getResources().getString(w.l.pb_load_more));
                    }
                } else {
                    this.enL.wk();
                    this.enL.wr();
                }
            } else {
                this.enL.wk();
                this.enL.wr();
            }
            if (fVar.aHG() != null && fVar.aHG().getAuthor() != null && fVar.aHG().getAuthor().getType() == 0) {
                this.emS.aMo();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.mListView.getData() != null || fVar.aHI() != null) {
                        i5 = (this.mListView.getData().size() - fVar.aHI().size()) + this.mListView.getHeaderViewsCount();
                    }
                    this.mListView.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aLc = ex.aLb().aLc()) != null) {
                        this.epf = true;
                        this.mListView.onRestoreInstanceState(aLc);
                        break;
                    } else {
                        this.mListView.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.epl = false;
                    break;
                case 5:
                    this.mListView.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aLc2 = ex.aLb().aLc();
                        this.epf = true;
                        if (aLc2 != null) {
                            this.mListView.onRestoreInstanceState(aLc2);
                            break;
                        }
                    }
                    this.mListView.setSelection(0);
                    break;
            }
            if (this.eoR >= 0) {
                this.mListView.setSelectionFromTop(this.eoR, (int) this.eoQ);
                this.eoR = -1;
            }
            if (this.eoD == eoF && Nd()) {
                aLW();
            }
            if (!this.epf && fVar.aHP() == null && !fVar.aHG().sl()) {
                this.eoO.aD(this.efF.getResources().getString(w.l.pb_more_tools_guide_tip), String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips");
                this.epf = true;
            }
            I(fVar.aHG());
            this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void aLN() {
        if (this.emJ != null) {
            this.mListView.removeHeaderView(this.avJ);
            this.mListView.removeHeaderView(this.eoC);
            this.mListView.addHeaderView(this.eoC, 0);
            if (this.mType != 1 && this.emL != null) {
                this.emL.aNF();
                return;
            }
            return;
        }
        this.mListView.removeHeaderView(this.eoC);
        this.mListView.removeHeaderView(this.avJ);
        this.mListView.addHeaderView(this.avJ, 0);
    }

    public void iC(boolean z) {
        this.eok = z;
        this.emS.iC(z);
    }

    public void wp() {
        if (this.enL != null) {
            this.enL.wl();
            this.enL.wp();
        }
        aGA();
    }

    public void Kn() {
        this.mListView.setVisibility(0);
    }

    private boolean aLO() {
        boolean z;
        if (this.eon != null && this.eon.getVisibility() == 0) {
            z = true;
            if (this.enC != null) {
                this.enC.setVisibility(0);
            }
        } else {
            if (this.enC != null) {
                this.enC.setVisibility(8);
            }
            z = false;
        }
        if ((this.enE == null || this.enE.getVisibility() == 8) && z && this.eeA) {
            this.enD.setVisibility(0);
        } else {
            this.enD.setVisibility(8);
        }
        com.baidu.tieba.graffiti.c.aj(this.enD);
        return z;
    }

    private boolean o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aHG() == null) {
            return false;
        }
        if (fVar.aHG().rw() == 1 || fVar.aHG().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aHG().ry() == null || fVar.aHG().ry().sQ() == 0) || fVar.aHG().ru() == 1 || fVar.aHG().rv() == 1 || fVar.aHG().sd() || fVar.aHG().sq() || fVar.aHG().sk() || fVar.aHG().rK() != null || fVar.aHG().sr() || fVar.aHG().sr() || !com.baidu.tbadk.core.util.au.isEmpty(fVar.aHG().rq()) || fVar.aHG().rB();
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str));
            return com.baidu.tieba.card.ap.a((Context) this.efF.getActivity(), str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.emZ != null) {
                if (fVar.aHG() != null && fVar.aHG().rN() == 0 && !fVar.aHG().sl() && !this.epb) {
                    this.emZ.setVisibility(0);
                    fVar.aHG().sh();
                    if (fVar.aHG() != null) {
                        fVar.aHG().e(true, o(fVar));
                    }
                    SpannableStringBuilder rY = fVar.aHG().rY();
                    this.ena.setOnTouchListener(new com.baidu.tieba.view.aa(rY));
                    if (rY == null || rY.length() == 0) {
                        this.ena.setVisibility(8);
                        this.eng.setPadding(this.eng.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds48), this.eng.getPaddingRight(), this.eng.getPaddingBottom());
                    } else {
                        this.ena.setText(rY);
                        this.ena.setVisibility(0);
                    }
                } else {
                    this.emZ.setVisibility(8);
                    this.mListView.removeHeaderView(this.emZ);
                    if (fVar.aHG() != null && fVar.aHG().sl()) {
                        this.eng.setPadding(this.eng.getPaddingLeft(), 0, this.eng.getPaddingRight(), this.eng.getPaddingBottom());
                    } else {
                        this.eng.setPadding(this.eng.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds48), this.eng.getPaddingRight(), this.eng.getPaddingBottom());
                    }
                }
            }
            this.eeA = z;
            com.baidu.tbadk.core.data.bk aHG = fVar.aHG();
            if (aHG != null) {
                a(aHG.ry());
            }
        }
        return false;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aLO();
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
            sparseArray.put(w.h.tag_del_post_id, c.getId());
            sparseArray.put(w.h.tag_del_post_type, 0);
            sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aHR()));
            sparseArray.put(w.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(w.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(w.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(w.h.tag_del_post_id, c.getId());
            sparseArray.put(w.h.tag_del_post_type, 0);
            sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aHR()));
            sparseArray.put(w.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aFt;
    }

    public void nM(String str) {
        if (this.enL != null) {
            this.enL.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public int aLP() {
        return w.h.richText;
    }

    public TextView aIH() {
        return this.enf.aIH();
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(ae.b bVar) {
        this.alm = bVar;
        if (this.enK != null) {
            this.enK.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.aq aqVar, a.b bVar) {
        if (aqVar != null) {
            int qv = aqVar.qv();
            int qs = aqVar.qs();
            if (this.enH != null) {
                this.enH.td();
            } else {
                this.enH = new com.baidu.tbadk.core.dialog.a(this.efF.getPageContext().getPageActivity());
                this.enI = LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.dialog_direct_pager, (ViewGroup) null);
                this.enH.v(this.enI);
                this.enH.a(w.l.dialog_ok, bVar);
                this.enH.b(w.l.dialog_cancel, new gf(this));
                this.enH.a(new gh(this));
                this.enH.b(this.efF.getPageContext()).td();
            }
            this.enJ = (EditText) this.enI.findViewById(w.h.input_page_number);
            this.enJ.setText("");
            TextView textView = (TextView) this.enI.findViewById(w.h.current_page_number);
            if (qv <= 0) {
                qv = 1;
            }
            if (qs <= 0) {
                qs = 1;
            }
            textView.setText(MessageFormat.format(this.efF.getApplicationContext().getResources().getString(w.l.current_page), Integer.valueOf(qv), Integer.valueOf(qs)));
            this.efF.ShowSoftKeyPadDelay(this.enJ, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.efF.showToast(str);
    }

    public boolean iD(boolean z) {
        if (this.Kg == null || !this.Kg.Cv()) {
            return false;
        }
        this.Kg.AN();
        return true;
    }

    public void aLQ() {
        if (this.epp != null) {
            while (this.epp.size() > 0) {
                TbImageView remove = this.epp.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aLQ();
        this.enG.oc(1);
        if (this.emL != null) {
            this.emL.onPause();
        }
    }

    public void onResume() {
        this.enG.oc(2);
        if (this.emL != null) {
            this.emL.onResume();
        }
    }

    public void onDestroy() {
        this.eoO.Vb();
        if (this.eoP != null) {
            this.eoP.Vb();
        }
        this.efF.hideProgressBar();
        if (this.bGF != null && this.bNr != null) {
            this.bGF.b(this.bNr);
        }
        auE();
        wp();
        if (this.eoL != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eoL);
        }
        if (this.eoM != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eoM);
        }
        if (this.epa != null) {
            this.epa.removeAllViews();
        }
        if (this.eng != null && this.ent != null) {
            this.eng.removeView(this.enm);
            this.ent = null;
        }
        if (this.eoB != null) {
            this.eoB.clearStatus();
        }
        this.eph = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.enG.oc(3);
        if (this.bIA != null) {
            this.bIA.setBackgroundDrawable(null);
        }
        if (this.emL != null) {
            this.emL.destroy();
        }
        if (this.enG != null) {
            this.enG.onDestory();
        }
    }

    public boolean oq(int i) {
        if (this.emL != null) {
            return this.emL.oq(i);
        }
        return false;
    }

    public void auE() {
        this.emS.op();
        this.eoO.Vb();
        com.baidu.adp.lib.util.k.b(this.efF.getPageContext().getPageActivity(), this.enJ);
        if (this.eoj != null) {
            this.eoj.dismiss();
        }
        aLR();
        if (this.eoP != null) {
            this.eoP.Vb();
        }
        if (this.enH != null) {
            this.enH.dismiss();
        }
        if (this.bPH != null) {
            this.bPH.dismiss();
        }
    }

    public void hL(boolean z) {
        this.enG.hL(z);
    }

    public void gm(boolean z) {
        this.dlE = z;
    }

    public void aLR() {
        if (this.enQ != null) {
            this.enQ.dismiss();
        }
        if (this.enR != null) {
            com.baidu.adp.lib.g.j.b(this.enR, this.efF.getPageContext());
        }
        if (this.eob != null) {
            com.baidu.adp.lib.g.j.b(this.eob, this.efF.getPageContext());
        }
        if (this.enO != null) {
            com.baidu.adp.lib.g.j.b(this.enO, this.efF.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.ejL, this.eeA);
            d(this.ejL, this.eeA, this.mType);
            this.efF.getLayoutMode().ai(i == 1);
            this.efF.getLayoutMode().t(this.bGH);
            this.efF.getLayoutMode().t(this.ena);
            this.efF.getLayoutMode().t(this.enb);
            this.efF.getLayoutMode().t(this.emX);
            if (this.enr != null) {
                com.baidu.tbadk.core.util.aq.c(this.enr, w.e.cp_cont_d, 1);
            }
            if (this.enq != null) {
                com.baidu.tbadk.core.util.aq.c(this.enq, w.e.cp_cont_d, 1);
            }
            if (this.emN != null) {
                this.emN.Ay();
            }
            if (this.emP != null) {
                this.emP.Ay();
            }
            if (this.emQ != null) {
                com.baidu.tbadk.core.util.aq.c(this.emQ, w.e.cp_cont_j, 1);
                String string = this.efF.getResources().getString(w.l.video_public_owner);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (this.emQ.getTag(w.h.tag_user_name) instanceof String) {
                    sb.append((String) this.emQ.getTag(w.h.tag_user_name));
                    SpannableString spannableString = new SpannableString(sb);
                    spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), string.length(), sb.length(), 33);
                    this.emQ.setText(spannableString);
                } else {
                    this.emQ.setText(string);
                }
            }
            this.efF.getLayoutMode().t(this.emX);
            com.baidu.tbadk.core.util.aq.i(this.ena, w.e.cp_cont_b);
            this.ena.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.efF.getLayoutMode().t(this.aFt);
            if (this.enI != null) {
                this.efF.getLayoutMode().t(this.enI);
            }
            iC(this.eok);
            this.enG.notifyDataSetChanged();
            if (this.enK != null) {
                this.enK.di(i);
            }
            if (this.enL != null) {
                this.enL.di(i);
                com.baidu.tbadk.core.util.aq.j(this.aFt, w.g.pb_foot_more_trans_selector);
                this.enL.dg(w.g.pb_foot_more_trans_selector);
            }
            if (this.Kg != null) {
                this.Kg.onChangeSkinType(i);
            }
            if (this.ens != null) {
                this.ens.dm(i);
            }
            if (this.enM != null) {
                this.enM.di(i);
            }
            if (this.emW != null && this.emW.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.emW) {
                    aVar.aMk();
                }
            }
            if (this.epa != null) {
                com.baidu.tbadk.core.util.aq.k(this.epa, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.k(this.eoY, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aq.c(this.eoZ, w.e.cp_cont_c, 1);
            }
            aO(i == 1);
            aLs();
            UtilHelper.setStatusBarBackground(this.bIA, i);
            if (this.enu != null) {
                this.enu.onChangeSkinType(i);
            }
            if (this.eny != null) {
                com.baidu.tbadk.core.util.aq.i(this.eny, w.e.cp_cont_d);
            }
            if (this.enx != null) {
                com.baidu.tbadk.core.util.aq.i(this.enx, w.e.cp_cont_f);
            }
            if (this.enj != null) {
                com.baidu.tbadk.core.util.aq.i(this.enj, w.e.cp_link_tip_a);
            }
            if (this.enw != null) {
                com.baidu.tbadk.core.util.aq.i(this.enw, w.e.cp_cont_f);
            }
            if (this.enz != null) {
                com.baidu.tbadk.m.a.a(this.efF.getPageContext(), this.enz);
            }
            if (this.eoN != null) {
                this.eoN.onChangeSkinType(i);
            }
            if (this.emS != null) {
                if (this.emL != null) {
                    this.emL.or(i);
                } else {
                    this.emS.onChangeSkinType(i);
                }
            }
            if (this.eor != null) {
                com.baidu.tbadk.core.util.aq.c(this.eor, w.g.pb_share_icon_selector);
            }
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aOe = eVar;
        this.enG.setOnImageClickListener(this.aOe);
    }

    public void h(NoNetworkView.a aVar) {
        this.bNr = aVar;
        if (this.bGF != null) {
            this.bGF.a(this.bNr);
        }
    }

    public void iE(boolean z) {
        this.enG.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aLS() {
        return this.eon;
    }

    public void aLT() {
        if (this.emR != 2) {
            this.mListView.setNextPage(this.enL);
            this.emR = 2;
        }
    }

    public void aLU() {
        if (com.baidu.tbadk.j.aa.FK().FL()) {
            int lastVisiblePosition = this.mListView.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.mListView.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(w.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.j.u perfLog = tbImageView.getPerfLog();
                                perfLog.fa(1001);
                                perfLog.aGB = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.vW();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.j.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fa(1001);
                        perfLog2.aGB = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.vW();
                    }
                }
            }
        }
    }

    public void gn(boolean z) {
        if (this.eoo != null && this.eoo != null) {
            if (this.dlE) {
                go(z);
            } else {
                gp(z);
            }
        }
    }

    public void aLV() {
        if (this.eoo != null) {
            this.eoo.setVisibility(8);
        }
    }

    public void asr() {
        if (this.eov == null) {
            this.eov = new com.baidu.tbadk.core.view.a(this.efF.getPageContext());
        }
        this.eov.aI(true);
    }

    public void aGA() {
        if (this.eov != null) {
            this.eov.aI(false);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!this.epg && aMh()) {
            b(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.eoT = false;
        if (!this.epg && aMh()) {
            b(absListView, i, i2, i3);
        }
        a aVar = new a();
        aVar.epw = i;
        aVar.epx = this.mListView.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
    }

    private void b(AbsListView absListView, int i) {
        if (this.emL != null) {
            this.emL.a(absListView, i, this.eoC);
        }
    }

    private void b(AbsListView absListView, int i, int i2, int i3) {
        if (this.emL != null) {
            this.emL.b(absListView, i, this.eoC);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int epw;
        public int epx;

        public a() {
        }
    }

    public void aLW() {
        if (!this.epq) {
            TiebaStatic.log("c10490");
            this.epq = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efF.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eoG, Integer.valueOf(eoI));
            aVar.bW(w.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(w.h.function_description_view)).setText(w.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(w.h.title_view)).setText(w.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(w.l.grade_button_tips, this.efF);
            aVar.b(w.l.look_again, new gj(this));
            aVar.b(this.efF.getPageContext()).td();
        }
    }

    public void aLX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efF.getPageContext().getPageActivity());
        aVar.cC(this.efF.getResources().getString(w.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eoG, Integer.valueOf(eoK));
        aVar.A(sparseArray);
        aVar.a(w.l.upgrade_to_new, this.efF);
        aVar.b(w.l.cancel, new gk(this));
        aVar.b(this.efF.getPageContext()).td();
    }

    public int rm() {
        return this.eoD;
    }

    public void nN(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efF.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.efF.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(w.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(w.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eoG, Integer.valueOf(eoJ));
        aVar.A(sparseArray);
        aVar.a(w.l.view, this.efF);
        aVar.b(w.l.cancel, new gl(this));
        aVar.b(this.efF.getPageContext()).td();
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

    public PbInterviewStatusView aLY() {
        return this.eoB;
    }

    private void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aHG() != null && fVar.aHG().sq() && this.eoB == null) {
            this.eoB = (PbInterviewStatusView) this.eoA.inflate();
            this.eoB.setOnClickListener(this.bPI);
            this.eoB.setCallback(this.efF.aJo());
            this.eoB.a(this.efF, fVar);
        }
    }

    public LinearLayout aLZ() {
        return this.enF;
    }

    public View aMa() {
        return this.bIA;
    }

    public boolean aMb() {
        return this.epb;
    }

    public void hQ(boolean z) {
        this.enf.hQ(z);
    }

    private void aMc() {
        if (this.epb) {
            if (this.epc == null) {
                f.a aVar = f.efI.get();
                if (aVar != null) {
                    this.epc = aVar.a(this.efF);
                    ListAdapter adapter = this.mListView.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.avJ) {
                            this.mListView.addHeaderView(this.epc.aIF(), 1);
                        } else {
                            this.mListView.addHeaderView(this.epc.aIF(), 0);
                        }
                    }
                } else {
                    this.enb.setVisibility(0);
                    return;
                }
            }
            this.enb.setVisibility(8);
            this.mListView.removeHeaderView(this.enb);
            return;
        }
        this.enb.setVisibility(0);
    }

    public void iF(boolean z) {
        this.epb = z;
    }

    public void aMd() {
        this.efF.showNetRefreshView(getView(), "");
        View Ed = this.efF.getRefreshView().Ed();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Ed.getLayoutParams();
        layoutParams.addRule(3, aLZ().getId());
        Ed.setLayoutParams(layoutParams);
        this.efF.hideLoadingView(getView());
        if (this.epc != null) {
            this.mListView.removeHeaderView(this.epc.aIF());
            this.epc = null;
        }
    }

    public void nO(String str) {
        if (this.emT != null) {
            this.emT.setTitle(str);
        }
    }

    public void aMe() {
        if (this.enG != null) {
            if (this.enG.aJF() != null) {
                this.enG.aJF().avX();
            }
            if (this.enG.aJG() != null) {
                this.enG.aJG().avX();
            }
        }
    }

    private int iG(boolean z) {
        if (this.eoB == null || this.eoB.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.efF.getPageContext().getPageActivity(), w.f.ds72);
    }

    private void aMf() {
        if (this.eoB != null && this.eoB.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoB.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eoB.setLayoutParams(layoutParams);
        }
    }

    public boolean aIO() {
        return false;
    }

    public TextView aMg() {
        return this.enr;
    }

    public void nP(String str) {
        this.eoq.performClick();
        if (!StringUtils.isNull(str) && this.efF.aII() != null && this.efF.aII().CS() != null && this.efF.aII().CS().CK() != null) {
            EditText CK = this.efF.aII().CS().CK();
            CK.setText(str);
            CK.setSelection(str.length());
        }
    }

    public boolean aMh() {
        return (this.emL == null || this.emO == null) ? false : true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            auE();
            aLV();
            aLi();
            if (this.eoN != null) {
                this.eoN.aJK();
            }
            this.efF.Zp();
            this.enF.setVisibility(8);
            this.emS.setTitleVisibility(false);
            this.efF.hW(false);
            this.epg = false;
            if (this.emO != null && this.emJ != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.emJ.getLayoutParams();
                layoutParams.topMargin = 0;
                this.emJ.setLayoutParams(layoutParams);
                if (configuration.orientation == 2) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.epg = true;
                } else {
                    int af = com.baidu.adp.lib.util.k.af(this.efF.getActivity());
                    layoutParams.width = af;
                    layoutParams.height = (int) (af * 0.5625d);
                    if (this.emL != null) {
                        this.emL.aMt();
                    }
                    this.enF.setVisibility(0);
                    this.epg = false;
                    this.emS.setTitleVisibility(true);
                }
                this.emJ.setLayoutParams(layoutParams);
                this.emO.a(this.efF, configuration);
            }
        }
    }

    public void v(long j, int i) {
        if (this.emP != null && j > 0) {
            this.emP.j(i, j);
        }
    }

    public void iH(boolean z) {
        this.emM = z;
    }

    private void I(com.baidu.tbadk.core.data.bk bkVar) {
        if (this.emP != null && bkVar != null && bkVar.sC() != null && bkVar.sC().Zt == 2) {
            if (this.eoP == null) {
                this.eoP = new com.baidu.tieba.d.a(this.efF.getPageContext(), this.emP.esI);
                this.eoP.ha(5000);
            }
            this.eoP.f(this.efF.getResources().getString(w.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void aMi() {
        if (this.emL != null) {
            this.emL.onPause();
        }
    }
}
