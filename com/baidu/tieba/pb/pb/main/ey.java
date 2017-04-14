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
import com.baidu.tbadk.core.view.ab;
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
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ey {
    public static int eqE = 2;
    public static int eqF = 3;
    public static int eqG = 0;
    public static int eqH = 3;
    public static int eqI = 4;
    public static int eqJ = 5;
    public static int eqK = 6;
    private com.baidu.tbadk.editortools.j KM;
    private View aFn;
    private int aNm;
    private boolean aiG;
    private ab.b alp;
    private TextView avD;
    private NoNetworkView bEr;
    private View bHd;
    private View.OnClickListener bOx;
    private ViewStub bba;
    private TbImageView bbb;
    private RelativeLayout dTF;
    private View.OnClickListener ehk;
    private com.baidu.tieba.pb.a.d ehl;
    private PbActivity eig;
    PbActivity.c ejF;
    private PbFakeFloorModel ela;
    private com.baidu.tieba.pb.data.f elz;
    public int eoH;
    private int eoI;
    private int eoJ;
    private int eoK;
    private FrameLayout eoM;
    private int eoN;
    private com.baidu.tieba.pb.video.d eoO;
    private com.baidu.tieba.pb.video.a eoQ;
    private com.baidu.tieba.play.c eoR;
    private com.baidu.tieba.pb.video.b eoS;
    private TextView eoT;
    public final com.baidu.tieba.pb.pb.main.view.f eoV;
    public com.baidu.tieba.pb.pb.main.view.d eoW;
    private ViewStub eoX;
    private ViewStub eoY;
    private List<com.baidu.tieba.pb.pb.main.view.a> eoZ;
    private LinearLayout epA;
    private TextView epB;
    private TextView epC;
    private View epD;
    private View epE;
    private ObservedChangeLinearLayout epG;
    private cn epH;
    private PbListView epM;
    private View epO;
    private View epa;
    private LinearLayout epe;
    private TextView epf;
    private View epg;
    private g eph;
    private di epi;
    private ColumnLayout epj;
    private ThreadSkinView epk;
    private TextView epl;
    private FrameLayout epm;
    private HeadPendantView epn;
    private HeadImageView epo;
    private ImageView epp;
    private ImageView epq;
    private UserIconBox epr;
    private UserIconBox eps;
    private View ept;
    private FloatingLayout epu;
    private EntelechyUserLikeButton epy;
    private ew epz;
    private ViewStub eqA;
    private PbInterviewStatusView eqB;
    private TextView eqC;
    private Runnable eqL;
    private Runnable eqM;
    private FloatingLayout eqN;
    private dc eqO;
    private com.baidu.tieba.d.a eqP;
    private com.baidu.tieba.d.a eqQ;
    private View eqY;
    private EntelechyUserLikeButton eqZ;
    private View eqo;
    private TextView eqp;
    private TextView eqq;
    private ViewGroup eqr;
    private TextView eqs;
    private boolean equ;
    private PostData eqw;
    private View eqy;
    private TextView eqz;
    private ClickableHeaderImageView era;
    private TbImageView erb;
    private FrameLayout erc;
    private TextView erd;
    private LinearLayout ere;
    private boolean erf;
    private f erg;
    private com.baidu.tbadk.core.view.userLike.c erh;
    private com.baidu.tbadk.core.view.userLike.c eri;
    private Runnable erm;
    private PbActivity.a ero;
    private boolean erq;
    private boolean err;
    private BdTypeListView mListView;
    private int mType;
    private int eoL = 1;
    private boolean eoP = false;
    private int eoU = 0;
    private final Handler mHandler = new Handler();
    private View epb = null;
    private LinearLayout epc = null;
    private TextView epd = null;
    private TextView epv = null;
    private TextView epw = null;
    public FrsPraiseView epx = null;
    private ClickableHeaderImageView enx = null;
    private View epF = null;
    private com.baidu.tbadk.core.dialog.a epI = null;
    private com.baidu.tbadk.core.dialog.c bOo = null;
    private View epJ = null;
    private EditText epK = null;
    private com.baidu.tieba.pb.view.m epL = null;
    private com.baidu.tieba.pb.view.b epN = null;
    private c.b cYj = null;
    private TbRichTextView.e aNK = null;
    private NoNetworkView.a bLW = null;
    private Dialog epP = null;
    private View epQ = null;
    private com.baidu.tbadk.core.dialog.a epR = null;
    private Dialog epS = null;
    private View epT = null;
    private int epU = 0;
    private RadioGroup epV = null;
    private RadioButton epW = null;
    private RadioButton epX = null;
    private RadioButton epY = null;
    private Button epZ = null;
    private Button eqa = null;
    private TextView eqb = null;
    private Dialog eqc = null;
    private View eqd = null;
    private LinearLayout eqe = null;
    private CompoundButton.OnCheckedChangeListener eqf = null;
    private TextView eqg = null;
    private TextView eqh = null;
    private String eqi = null;
    private com.baidu.tbadk.core.dialog.c eqj = null;
    private boolean eqk = false;
    private boolean eql = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eqm = null;
    private boolean dpj = false;
    private Button eqn = null;
    private boolean eqt = true;
    private com.baidu.tbadk.core.view.a eqv = null;
    private boolean ehg = false;
    private int mSkinType = 3;
    private boolean eqx = false;
    private boolean mIsFromCDN = true;
    private int eqD = 0;
    private a.InterfaceC0072a eqR = new ez(this);
    private boolean eqS = false;
    private boolean eiM = false;
    private boolean eqT = false;
    private LinearLayout eqU = null;
    private TextView eqV = null;
    private int eqW = 0;
    private boolean eqX = false;
    private boolean erj = false;
    private int rank = 0;
    private boolean erk = false;
    private Animation.AnimationListener duR = new fj(this);
    private Handler erl = new Handler();
    private CustomMessageListener ern = new fs(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean erp = true;
    private boolean ers = false;
    private boolean Zh = false;
    String userId = null;
    private final List<TbImageView> ert = new ArrayList();
    private boolean eru = false;
    private Runnable bQF = new gd(this);

    public f aMO() {
        return this.erg;
    }

    public NoNetworkView aMP() {
        return this.bEr;
    }

    public boolean isFullScreen() {
        return this.eiM;
    }

    public void aMQ() {
        if (this.KM != null) {
            this.KM.hide();
        }
    }

    public PbFakeFloorModel aMR() {
        return this.ela;
    }

    public dc aMS() {
        return this.eqO;
    }

    public void aMT() {
        reset();
        this.eqt = true;
        if (this.KM != null) {
            this.KM.hide();
        }
        this.eqO.aLk();
        if (this.eqo != null) {
            if (this.dpj) {
                gD(false);
            } else {
                gE(false);
            }
        }
        aLx();
    }

    private void reset() {
        if (this.eig != null && this.eig.aKm() != null && this.KM != null) {
            com.baidu.tbadk.editortools.pb.a.DK().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aKm = this.eig.aKm();
            aKm.Ee();
            if (aKm.getWriteImagesInfo() != null) {
                aKm.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aKm.eK(10);
            aKm.eI(SendView.ALL);
            aKm.eJ(SendView.ALL);
            com.baidu.tbadk.editortools.p ez = this.KM.ez(23);
            com.baidu.tbadk.editortools.p ez2 = this.KM.ez(2);
            com.baidu.tbadk.editortools.p ez3 = this.KM.ez(5);
            if (ez2 != null) {
                ez2.mp();
            }
            if (ez3 != null) {
                ez3.mp();
            }
            if (ez != null) {
                ez.hide();
            }
            this.KM.invalidate();
        }
    }

    public boolean aMU() {
        return this.eqt;
    }

    public void gD(boolean z) {
        if (this.eqo != null && this.eqp != null && this.eqq != null) {
            this.eqp.setText(w.l.draft_to_send);
            this.eqq.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eqo.startAnimation(alphaAnimation);
            }
            this.eqo.setVisibility(0);
        }
    }

    public void gE(boolean z) {
        if (this.eqo != null && this.eqp != null && this.eqq != null) {
            this.eqp.setText(w.l.reply_floor_host);
            this.eqq.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eqo.startAnimation(alphaAnimation);
            }
            this.eqo.setVisibility(0);
        }
    }

    public PostData aMV() {
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
        if (this.epH.oe(headerViewsCount) != null && this.epH.oe(headerViewsCount) != PostData.fvP) {
            i2 = headerViewsCount + 1;
        }
        return (PostData) this.epH.getItem(i2);
    }

    public ey(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.aNm = 0;
        this.eoI = 0;
        this.eoJ = 0;
        this.eoK = 0;
        this.eig = null;
        this.dTF = null;
        this.bHd = null;
        this.mListView = null;
        this.epa = null;
        this.epe = null;
        this.epf = null;
        this.epg = null;
        this.epj = null;
        this.epl = null;
        this.epm = null;
        this.epn = null;
        this.epo = null;
        this.epp = null;
        this.epq = null;
        this.epr = null;
        this.eps = null;
        this.ept = null;
        this.epy = null;
        this.epD = null;
        this.epE = null;
        this.epH = null;
        this.epM = null;
        this.aFn = null;
        this.bOx = null;
        this.ehk = null;
        this.eqo = null;
        this.eqp = null;
        this.eqr = null;
        this.eqs = null;
        this.eqy = null;
        this.eqz = null;
        this.eqA = null;
        this.eig = pbActivity;
        this.bOx = onClickListener;
        this.ehl = dVar;
        this.dTF = (RelativeLayout) LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.new_pb_activity, (ViewGroup) null);
        this.eig.addContentView(this.dTF, new FrameLayout.LayoutParams(-1, -1));
        this.bHd = this.eig.findViewById(w.h.statebar_view);
        this.epG = (ObservedChangeLinearLayout) this.eig.findViewById(w.h.title_wrapper);
        this.bEr = (NoNetworkView) this.eig.findViewById(w.h.view_no_network);
        this.mListView = (BdTypeListView) this.eig.findViewById(w.h.new_pb_list);
        this.avD = new TextView(this.eig.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eig.getActivity(), w.f.ds98));
        this.mListView.addHeaderView(this.avD, 0);
        View view = new View(this.eig.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eig.getResources().getDimensionPixelSize(w.f.ds100)));
        view.setVisibility(4);
        this.mListView.addFooterView(view);
        this.mListView.setOnTouchListener(this.eig.aOh);
        this.eoV = new com.baidu.tieba.pb.pb.main.view.f(pbActivity);
        this.eqP = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.eoV.esh);
        this.eqP.gZ(3);
        this.epi = new di(this.eig, this.dTF);
        this.epi.init();
        this.epi.a(this.epi.aLy(), this.bOx);
        if (this.eig.aKI()) {
            this.eoX = (ViewStub) this.eig.findViewById(w.h.manga_view_stub);
            this.eoX.setVisibility(0);
            this.eoW = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
            this.eoW.show();
            this.eoV.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.avD.setLayoutParams(layoutParams);
        this.eoV.aNX().setOnTouchListener(new com.baidu.tieba.pb.a.a(new ge(this)));
        this.eqo = this.eig.findViewById(w.h.pb_editor_tool_comment);
        this.eqp = (TextView) this.eig.findViewById(w.h.pb_editor_tool_comment_reply_text);
        this.eqr = (ViewGroup) this.eig.findViewById(w.h.pb_editor_tool_comment_reply_layout);
        this.eqs = (TextView) this.eig.findViewById(w.h.pb_editor_tool_comment_praise_icon);
        boolean al = com.baidu.tieba.graffiti.c.al(this.eqs);
        if (al) {
            iM(al);
            this.eqs.setVisibility(0);
        }
        this.eqq = (TextView) this.eig.findViewById(w.h.pb_editor_tool_comment_reply_count_text);
        this.eqr.setOnClickListener(new gf(this));
        this.eqs.setOnClickListener(this.bOx);
        this.eqs.setOnTouchListener(this.eig);
        this.epa = LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_item, (ViewGroup) null);
        this.epe = (LinearLayout) LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_user_item, (ViewGroup) null);
        this.eph = new g(this.eig, this.epe);
        this.eph.init();
        this.eph.a(this.eph.aKl(), this.bOx);
        this.epj = (ColumnLayout) this.epe.findViewById(w.h.pb_head_owner_root);
        this.eqN = (FloatingLayout) this.epe.findViewById(w.h.pb_head_owner_info_root);
        this.epk = (ThreadSkinView) this.epe.findViewById(w.h.pb_thread_skin);
        this.epj.setOnLongClickListener(this.onLongClickListener);
        this.epj.setOnTouchListener(this.ehl);
        this.epj.setVisibility(8);
        this.epa.setOnTouchListener(this.ehl);
        this.eqy = this.epa.findViewById(w.h.pb_head_activity_join_number_container);
        this.eqy.setVisibility(8);
        this.eqz = (TextView) this.epa.findViewById(w.h.pb_head_activity_join_number);
        this.epl = (TextView) this.epj.findViewById(w.h.pb_head_owner_info_user_name);
        this.epm = (FrameLayout) this.epj.findViewById(w.h.pb_head_headImage_container);
        this.epo = (HeadImageView) this.epj.findViewById(w.h.pb_head_owner_photo);
        this.epn = (HeadPendantView) this.epj.findViewById(w.h.pb_pendant_head_owner_photo);
        this.bba = (ViewStub) this.epj.findViewById(w.h.viewstub_headimage_mask);
        this.epn.wL();
        if (this.epn.getHeadView() != null) {
            this.epn.getHeadView().setIsRound(true);
            this.epn.getHeadView().setDrawBorder(false);
        }
        if (this.epn.getPendantView() != null) {
            this.epn.getPendantView().setIsRound(true);
            this.epn.getPendantView().setDrawBorder(false);
        }
        this.epp = (ImageView) this.epj.findViewById(w.h.pb_head_owner_info_user_rank);
        this.epq = (ImageView) this.epj.findViewById(w.h.pb_head_owner_info_user_bawu);
        this.epr = (UserIconBox) this.epj.findViewById(w.h.pb_head_owner_info_user_icon);
        this.eps = (UserIconBox) this.epj.findViewById(w.h.pb_head_owner_info_tshow_icon);
        this.epu = (FloatingLayout) this.epe.findViewById(w.h.pb_head_owner_info_root);
        this.epy = (EntelechyUserLikeButton) this.epj.findViewById(w.h.pb_like_button);
        this.epz = new ew(pbActivity.getPageContext(), this.epy);
        this.erh = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eri = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.epD = this.epa.findViewById(w.h.new_pb_header_item_line_above_livepost);
        this.epg = LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.layout_read_thread, (ViewGroup) null);
        this.epf = (TextView) this.epg.findViewById(w.h.pb_head_read_button);
        this.epe.addView(this.epg);
        this.epf.setOnClickListener(this.bOx);
        this.eoK = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds2);
        this.eoJ = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds18);
        this.eoI = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);
        this.aNm = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds32);
        this.epE = this.epa.findViewById(w.h.new_pb_header_item_line_below_livepost);
        this.epa.setOnLongClickListener(new gg(this));
        this.eqA = (ViewStub) this.dTF.findViewById(w.h.interview_status_stub);
        this.epH = new cn(this.eig, this.mListView);
        this.epH.u(this.bOx);
        this.epH.a(this.ehl);
        this.epH.setOnImageClickListener(this.aNK);
        this.ehk = new gh(this);
        this.epH.H(this.ehk);
        aMY();
        this.mListView.addHeaderView(this.epc);
        this.mListView.addHeaderView(this.epe);
        this.mListView.addHeaderView(this.epa);
        this.epM = new PbListView(this.eig.getPageContext().getPageActivity());
        this.aFn = this.epM.getView().findViewById(w.h.pb_more_view);
        if (this.aFn != null) {
            this.aFn.setOnClickListener(this.bOx);
            com.baidu.tbadk.core.util.aq.j(this.aFn, w.g.pb_foot_more_trans_selector);
        }
        this.epM.wW();
        this.epM.di(w.g.pb_foot_more_trans_selector);
        this.epM.dj(w.g.pb_foot_more_trans_selector);
        this.epO = this.eig.findViewById(w.h.viewstub_progress);
        this.eig.registerListener(this.ern);
        this.ept = com.baidu.tbadk.ala.c.oa().h(this.eig.getActivity(), 2);
        if (this.ept != null) {
            this.ept.setVisibility(8);
            this.epu.addView(this.ept, 2);
        }
        this.ela = new PbFakeFloorModel(this.eig.getPageContext());
        this.eqO = new dc(this.eig.getPageContext(), this.ela, this.dTF);
        this.ela.a(new gi(this));
    }

    public void aMW() {
        if (this.mListView != null) {
            this.mListView.removeHeaderView(this.epc);
            this.mListView.removeHeaderView(this.epe);
            this.mListView.removeHeaderView(this.epa);
        }
    }

    private boolean j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aJx() == null || !fVar.aJQ() || !TbadkCoreApplication.m9getInst().isTTSCanUse() || fVar.aJx().sm() == 1 || fVar.aJx().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aJx().so() == null || fVar.aJx().so().tD() == 0) && !fVar.aJx().tg()) {
            BdUniqueId type = fVar.aJx().getType();
            return type == com.baidu.tbadk.core.data.bi.Ya || type == com.baidu.tbadk.core.data.bi.Yb || type == com.baidu.tbadk.core.data.bi.XZ;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.epg != null) {
            if (!z) {
                this.epg.setVisibility(8);
            } else if (!j(fVar)) {
                this.epg.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aJz() != null && fVar.aJz().size() > 0) {
                    postData = fVar.aJz().get(0);
                }
                if (postData != null && postData.bio() == 1) {
                    q(this.aNm, this.eoJ, this.aNm, this.eoK);
                } else {
                    q(this.aNm, this.eoJ, this.aNm, this.eoI);
                }
                this.epg.setVisibility(0);
            }
        }
    }

    private void q(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epf.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.epf.setLayoutParams(layoutParams);
    }

    public TextView aMX() {
        return this.epf;
    }

    private void aMY() {
        if (this.epc == null) {
            int g = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds32);
            int g2 = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds40);
            this.epc = new LinearLayout(this.eig.getPageContext().getPageActivity());
            this.epc.setOrientation(1);
            this.epc.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.epc.setPadding(0, g2, 0, g2);
            this.epc.setGravity(17);
            this.epd = new TextView(this.eig.getPageContext().getPageActivity());
            this.epd.setGravity(3);
            this.epd.setMaxLines(2);
            this.epd.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.epd.setPadding(g, 0, g, 0);
            com.baidu.tbadk.core.util.aq.i(this.epd, w.e.cp_cont_b);
            this.epd.setTextSize(0, g2);
            this.epd.setVisibility(8);
            this.epc.addView(this.epd);
            this.epc.setOnTouchListener(this.ehl);
            this.epc.setOnLongClickListener(new fa(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMZ() {
        if (this.eig.aKI()) {
            this.eoY = (ViewStub) this.eig.findViewById(w.h.manga_mention_controller_view_stub);
            this.eoY.setVisibility(0);
            if (this.epA == null) {
                this.epA = (LinearLayout) this.eig.findViewById(w.h.manga_controller_layout);
                com.baidu.tbadk.m.a.a(this.eig.getPageContext(), this.epA);
            }
            if (this.epB == null) {
                this.epB = (TextView) this.epA.findViewById(w.h.manga_prev_btn);
            }
            if (this.epC == null) {
                this.epC = (TextView) this.epA.findViewById(w.h.manga_next_btn);
            }
            this.epB.setOnClickListener(this.bOx);
            this.epC.setOnClickListener(this.bOx);
        }
    }

    private void aNa() {
        if (this.eig.aKI()) {
            if (this.eig.aKL() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.epB, w.e.cp_cont_e, 1);
            }
            if (this.eig.aKM() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.epC, w.e.cp_cont_e, 1);
            }
        }
    }

    public void aNb() {
        if (this.epA == null) {
            aMZ();
        }
        this.eoY.setVisibility(8);
        if (this.erl != null && this.erm != null) {
            this.erl.removeCallbacks(this.erm);
        }
    }

    public void aNc() {
        if (this.erl != null) {
            if (this.erm != null) {
                this.erl.removeCallbacks(this.erm);
            }
            this.erm = new fb(this);
            this.erl.postDelayed(this.erm, 2000L);
        }
    }

    public void iG(boolean z) {
        this.eoV.iG(z);
        if (z && this.eqx) {
            this.epM.setText(this.eig.getResources().getString(w.l.click_load_more));
            this.mListView.setNextPage(this.epM);
            this.eoU = 2;
        }
    }

    public void aNd() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.dTF.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KM = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dTF.addView(this.KM, layoutParams);
        this.KM.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.KM.hide();
    }

    public void aNe() {
        if (this.eig != null && this.KM != null) {
            this.KM.mp();
        }
    }

    public void nE(String str) {
        if (this.eqq != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.eqq.setText(this.eig.getPageContext().getResources().getString(w.l.pb_reply_count_text, str));
        }
    }

    public void P(String str, boolean z) {
        this.equ = z;
        iH(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void iH(boolean z) {
        if (this.eqs != null) {
            if (this.equ) {
                com.baidu.tbadk.core.util.aq.j(this.eqs, w.g.pb_praise_already_click_selector);
                this.eqs.setContentDescription(this.eig.getResources().getString(w.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aq.j(this.eqs, w.g.pb_praise_normal_click_selector);
            this.eqs.setContentDescription(this.eig.getResources().getString(w.l.frs_item_praise_text));
        }
    }

    public TextView aNf() {
        return this.eqs;
    }

    public void iI(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
                return;
            }
            if (this.eqM == null) {
                this.eqM = new fc(this, z);
            }
            com.baidu.adp.lib.g.h.fR().postDelayed(this.eqM, 10L);
        }
    }

    public void iJ(boolean z) {
        if (this.mListView != null && this.avD != null && this.bHd != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bHd.setVisibility(0);
                    aNv();
                } else {
                    this.bHd.setVisibility(8);
                    this.mListView.removeHeaderView(this.avD);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.avD.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.avD.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.avD.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + iR(true);
                this.avD.setLayoutParams(layoutParams2);
            }
            aNv();
            aNQ();
        }
    }

    public void aZ(View view) {
        boolean z;
        View view2;
        if (this.epG != null && view != null) {
            if (this.eqt) {
                z = this.eqo.getVisibility() == 0;
            } else {
                z = this.KM != null && this.KM.getVisibility() == 0;
            }
            boolean z2 = this.epG.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.eiM = true;
                View findViewById = this.eig.findViewById(w.h.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.epG.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.eig, this.epG, w.a.top_fold_up, new fd(this, findViewById));
            } else {
                this.eiM = false;
                com.baidu.tieba.tbadkCore.a.a(this.eig, this.epG, w.a.top_fold_down, new fe(this));
            }
            if (this.eqt) {
                view2 = this.eqo;
            } else {
                view2 = this.KM;
            }
            if (z) {
                if (z2) {
                    if (this.KM != null) {
                        this.KM.BC();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.eig, view2, w.a.bottom_fold_down, new ff(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.eig, view2, w.a.bottom_fold_up, new fg(this));
            }
            aLx();
        }
    }

    public cn aNg() {
        return this.epH;
    }

    public void aNh() {
        if (this.epH != null) {
            this.epH.aLb();
        }
    }

    public void a(PbActivity.c cVar) {
        this.ejF = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bn bnVar) {
        if (bnVar == null || bnVar.tD() == 0) {
            if (this.eqn != null) {
                this.eqn.setVisibility(8);
            }
            if (this.epD != null) {
                this.epD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eqn == null) {
            this.eig.getLayoutMode().t(((ViewStub) this.epa.findViewById(w.h.live_talk_layout)).inflate());
            this.eqn = (Button) this.epa.findViewById(w.h.pb_head_function_manage_go_to_live_post);
            this.epD = this.epa.findViewById(w.h.new_pb_header_item_line_above_livepost);
        }
        int tE = bnVar.tE();
        String string = this.eig.getPageContext().getString(w.l.go_to_live_post_prefix);
        if (tE == 0) {
            string = String.valueOf(string) + this.eig.getPageContext().getString(w.l.go_to_interview_post);
        } else if (tE == 1) {
            string = String.valueOf(string) + this.eig.getPageContext().getString(w.l.go_to_discuss_post);
        }
        this.eqn.setText(string);
        this.eqn.setVisibility(0);
        this.eqn.setOnClickListener(this.bOx);
        this.err = true;
        aNw();
    }

    public void ba(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.epQ == null) {
            this.epQ = LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eig.getLayoutMode().t(this.epQ);
        if (this.epP == null) {
            this.epP = new Dialog(this.eig.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.epP.setCanceledOnTouchOutside(true);
            this.epP.setCancelable(true);
            this.epP.setContentView(this.epQ);
            WindowManager.LayoutParams attributes = this.epP.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.eig.getPageContext().getPageActivity()) * 0.9d);
            this.epP.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.epP.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.epP.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.epP.findViewById(w.h.disable_reply_btn);
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
            textView.setOnClickListener(new fh(this));
        }
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name)) || aNM()) {
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
            textView2.setOnClickListener(new fi(this));
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
            textView3.setOnClickListener(new fk(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.epP, this.eig.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.ero = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eqG, Integer.valueOf(eqH));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.epR = new com.baidu.tbadk.core.dialog.a(this.eig.getActivity());
        this.epR.bZ(i3);
        this.epR.A(sparseArray);
        this.epR.a(w.l.dialog_ok, this.eig);
        this.epR.b(w.l.dialog_cancel, new fl(this));
        this.epR.av(true);
        this.epR.b(this.eig.getPageContext());
        this.epR.tQ();
    }

    public void al(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eqd == null) {
            this.eqd = LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.commit_good, (ViewGroup) null);
        }
        this.eig.getLayoutMode().t(this.eqd);
        if (this.eqc == null) {
            this.eqc = new Dialog(this.eig.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.eqc.setCanceledOnTouchOutside(true);
            this.eqc.setCancelable(true);
            this.eqm = (ScrollView) this.eqd.findViewById(w.h.good_scroll);
            this.eqc.setContentView(this.eqd);
            WindowManager.LayoutParams attributes = this.eqc.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds540);
            this.eqc.getWindow().setAttributes(attributes);
            this.eqf = new fm(this);
            this.eqe = (LinearLayout) this.eqd.findViewById(w.h.good_class_group);
            this.eqh = (TextView) this.eqd.findViewById(w.h.dialog_button_cancel);
            this.eqh.setOnClickListener(new fn(this));
            this.eqg = (TextView) this.eqd.findViewById(w.h.dialog_button_ok);
            this.eqg.setOnClickListener(this.bOx);
        }
        this.eqe.removeAllViews();
        this.eoZ = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bM = bM("0", this.eig.getPageContext().getString(w.l.def_good_class));
        this.eoZ.add(bM);
        bM.setChecked(true);
        this.eqe.addView(bM);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bM2 = bM(String.valueOf(arrayList.get(i2).qL()), arrayList.get(i2).qK());
                this.eoZ.add(bM2);
                View view = new View(this.eig.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds1));
                com.baidu.tbadk.core.util.aq.k(view, w.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eqe.addView(view);
                this.eqe.addView(bM2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eqm.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eig.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eig.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eig.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eqm.setLayoutParams(layoutParams2);
            this.eqm.removeAllViews();
            this.eqm.addView(this.eqe);
        }
        com.baidu.adp.lib.g.j.a(this.eqc, this.eig.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bM(String str, String str2) {
        Activity pageActivity = this.eig.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds100));
        aVar.setOnCheckedChangeListener(this.eqf);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aNi() {
        this.eig.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eig.hideProgressBar();
        if (z && z2) {
            this.eig.showToast(this.eig.getPageContext().getString(w.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(w.l.neterror);
            }
            this.eig.showToast(str);
        }
    }

    public void ars() {
        this.epO.setVisibility(0);
    }

    public void arr() {
        this.epO.setVisibility(8);
    }

    public View aNj() {
        if (this.eqd != null) {
            return this.eqd.findViewById(w.h.dialog_button_ok);
        }
        return null;
    }

    public String aNk() {
        return this.eqi;
    }

    public View getView() {
        return this.dTF;
    }

    public void aNl() {
        com.baidu.adp.lib.util.k.b(this.eig.getPageContext().getPageActivity(), this.eig.getCurrentFocus());
    }

    public void iK(boolean z) {
        this.eig.hideProgressBar();
        awH();
    }

    public void aNm() {
        this.epM.xd();
    }

    public void aNn() {
        this.eig.hideProgressBar();
        this.epM.xe();
        aIs();
        this.mListView.completePullRefreshPostDelayed(2000L);
        aNw();
    }

    public void aNo() {
        this.mListView.completePullRefreshPostDelayed(2000L);
        aNw();
    }

    public void iL(boolean z) {
        this.epi.f(this.epi.aLy(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eqr.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eig.getResources().getDimensionPixelSize(w.f.ds84) : 0;
        this.eqr.setLayoutParams(marginLayoutParams);
    }

    private void iM(boolean z) {
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eqr.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.eqr.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tbadk.core.data.af afVar) {
        this.epi.b(afVar);
    }

    public boolean aLv() {
        return this.epi.aLv();
    }

    public void aLw() {
        this.epi.aLw();
    }

    public void aLx() {
        this.epi.aLx();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.epH.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.eqj != null) {
            this.eqj.dismiss();
            this.eqj = null;
        }
        this.eqj = new com.baidu.tbadk.core.dialog.c(this.eig.getPageContext().getPageActivity());
        this.eqj.cc(w.l.operation);
        if (z2) {
            this.eqj.a(new String[]{this.eig.getPageContext().getString(w.l.copy)}, bVar);
        } else if (!z) {
            this.eqj.a(new String[]{this.eig.getPageContext().getString(w.l.copy), this.eig.getPageContext().getString(w.l.mark)}, bVar);
        } else {
            this.eqj.a(new String[]{this.eig.getPageContext().getString(w.l.copy), this.eig.getPageContext().getString(w.l.remove_mark)}, bVar);
        }
        this.eqj.d(this.eig.getPageContext());
        this.eqj.tT();
    }

    public int aNp() {
        return os(this.mListView.getFirstVisiblePosition());
    }

    private int os(int i) {
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

    public int aNq() {
        return os(this.mListView.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.mListView.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.epK.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void k(com.baidu.tieba.pb.data.f fVar) {
        this.epH.b(fVar);
        this.epH.notifyDataSetChanged();
        if (fVar == null) {
            nE("");
        } else {
            nE(com.baidu.tbadk.core.util.au.w(fVar.aJx().sh()));
        }
        aNw();
    }

    public void l(com.baidu.tieba.pb.data.f fVar) {
        PraiseData se;
        if (this.epx == null) {
            this.eig.getLayoutMode().t(((ViewStub) this.epa.findViewById(w.h.praise_layout)).inflate());
            this.epx = (FrsPraiseView) this.epa.findViewById(w.h.pb_head_praise_view);
            this.epx.setIsFromPb(true);
            this.epF = this.epa.findViewById(w.h.new_pb_header_item_line_above_praise);
            this.epx.m26do(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.epx != null) {
            boolean aNw = aNw();
            if (fVar != null && fVar.aJz() != null && fVar.aJz().size() > 0) {
                PostData postData = fVar.aJz().get(0);
                if ((!this.ehg || postData.bio() != 1) && (se = fVar.aJx().se()) != null && se.getUser() != null && se.getUser().size() > 0) {
                    this.epx.setVisibility(0);
                    this.epx.setIsFromPb(true);
                    this.epx.a(se, fVar.aJx().getId(), se.getPostId(), true);
                    this.epx.getVisibility();
                    com.baidu.tieba.graffiti.c.al(this.epx);
                    return;
                }
            }
            this.epx.setVisibility(8);
            if (fVar != null && fVar.rr() != null && fVar.rr().ro() == 0 && this.ehg) {
                if (aNw) {
                    this.epE.setVisibility(0);
                } else {
                    this.epE.setVisibility(8);
                }
            } else {
                this.epE.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.al(this.epE);
        }
    }

    private PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aJG() != null) {
            return fVar.aJG();
        }
        if (z) {
            if (fVar == null || fVar.aJz() == null || fVar.aJz().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aJz().get(0);
            if (postData.bio() != 1) {
                postData = a(fVar);
            }
            if (postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
                return postData;
            }
            return postData;
        }
        return a(fVar);
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aJx() == null || fVar.aJx().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aJx().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aJx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.rS(1);
        postData.setId(fVar.aJx().sE());
        postData.setTitle(fVar.aJx().getTitle());
        postData.setTime(fVar.aJx().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        boolean z2;
        int i2;
        if (fVar != null && fVar.aJx() != null) {
            this.eqN.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds30), 0, 0);
            PostData c = c(fVar, z);
            a(c, fVar);
            aNN();
            this.epj.setVisibility(8);
            if (fVar.aJx() != null && fVar.aJx().tb() && fVar.aJx().sF() != null) {
                this.eoV.iW(true);
                if (this.eoO == null || this.eoR == null) {
                    aNr();
                    this.eoO.a(fVar.aJx().sF(), fVar.aJx(), fVar.getForumId());
                    this.eoO.startPlay();
                } else if (this.eoP) {
                    this.eoO.a(fVar.aJx().sF(), fVar.aJx(), fVar.getForumId());
                    this.eoO.startPlay();
                }
                if (fVar.aJy() != null && fVar.aJy().size() >= 1) {
                    com.baidu.tbadk.core.data.bi biVar = fVar.aJy().get(0);
                    this.eoO.G(biVar);
                    this.eoO.nS(biVar.getTitle());
                }
                this.eoP = false;
                if (this.eqC == null) {
                    this.eqC = new TextView(this.eig.getActivity());
                    this.eqC.setLayoutParams(new AbsListView.LayoutParams(-1, this.eoN));
                }
                this.mListView.removeHeaderView(this.eqC);
                this.mListView.addHeaderView(this.eqC, 0);
                if (this.eoQ == null) {
                    this.eoQ = new com.baidu.tieba.pb.video.a(LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.pb_header_video_abstract_layout, (ViewGroup) null));
                }
                this.eoQ.F(fVar.aJx());
                this.mListView.removeHeaderView(this.eoQ.mRootView);
                this.mListView.addHeaderView(this.eoQ.mRootView, 1);
                if (fVar.aJx().ts() != null) {
                    m(fVar);
                    this.mListView.removeHeaderView(this.eoS.mRootView);
                    this.mListView.removeHeaderView(this.epe);
                    this.mListView.addHeaderView(this.eoS.mRootView, 2);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoQ.euB.getLayoutParams();
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds26);
                    this.eoQ.euB.setLayoutParams(layoutParams);
                } else {
                    if (this.eoS != null && this.eoS.mRootView != null) {
                        this.mListView.removeHeaderView(this.eoS.mRootView);
                    }
                    if (com.baidu.adp.lib.b.e.eY().Y("video_channel_pb_portrait_switch") == 0) {
                        h(c);
                        this.mListView.removeHeaderView(this.epe);
                        this.mListView.removeHeaderView(this.eoT);
                        this.mListView.addHeaderView(this.eoT, 2);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eoQ.euB.getLayoutParams();
                        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds30);
                        this.eoQ.euB.setLayoutParams(layoutParams2);
                    } else {
                        aNs();
                        if (this.eoT != null) {
                            this.mListView.removeHeaderView(this.eoT);
                        }
                        this.mListView.removeHeaderView(this.epe);
                        this.mListView.addHeaderView(this.epe, 2);
                    }
                }
                if (this.eoO != null) {
                    this.eoO.ov(0);
                }
                aNv();
                z2 = true;
            } else {
                this.eoV.iW(false);
                if (this.eoM != null) {
                    this.eoM.setVisibility(8);
                }
                if (this.eqC != null) {
                    this.mListView.removeHeaderView(this.eqC);
                }
                if (this.eoQ != null) {
                    this.mListView.removeHeaderView(this.eoQ.mRootView);
                }
                if (this.eoS != null) {
                    this.mListView.removeHeaderView(this.eoS.mRootView);
                }
                z2 = false;
            }
            if (this.eig.aKp() != null) {
                this.eig.aKp().iU(z2);
            }
            fo foVar = new fo(this, z2);
            if (this.eoT != null) {
                this.eoT.setOnClickListener(foVar);
            }
            b(fVar, z);
            if (c != null) {
                this.eqw = c;
                String str = null;
                boolean z3 = false;
                if (fVar != null && fVar.aJx() != null && fVar.aJx().getAuthor() != null) {
                    str = fVar.aJx().getAuthor().getUserId();
                    if (fVar.rr() != null) {
                        this.eqW = fVar.rr().rk();
                        z3 = fVar.rr().rn() == 1;
                    }
                }
                boolean ta = fVar.aJx().ta();
                if (c.getAuthor() != null && c.getAuthor().getUserTbVipInfoData() != null) {
                    this.aiG = !StringUtils.isNull(c.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.eqS = !ta && a(fVar, c, fVar.aJx().getId(), str, z3, z);
                this.epj.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.epj.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.epj.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_clip_board, c);
                sparseArray.put(w.h.tag_is_subpb, false);
                fVar.aJx().sX();
                if (!this.erf) {
                    this.epc.setVisibility(0);
                }
                if (!fVar.aJx().tb() && this.epd.getText() != null && this.epd.getText().length() > 0) {
                    this.epd.setVisibility(0);
                } else {
                    this.epd.setVisibility(8);
                }
                l(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> sz = fVar.aJx().sz();
                if (sz != null && sz.size() > 0 && !this.erf) {
                    this.eqz.setText(String.valueOf(sz.get(0).pI()));
                    this.eqy.setVisibility(0);
                    this.erq = true;
                } else {
                    this.eqy.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.j(this.eqy, w.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aq.c(this.eqz, w.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    int is_bawu = c.getAuthor().getIs_bawu();
                    String bawu_type = c.getAuthor().getBawu_type();
                    int i3 = 3;
                    if (this.rank != 0) {
                        this.epp.setVisibility(0);
                        com.baidu.tbadk.core.util.aq.c(this.epp, BitmapHelper.getGradeResourceIdNew(this.rank));
                        this.epp.setAlpha(179);
                        this.epp.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.rank)));
                        this.epp.setOnClickListener(null);
                    } else {
                        this.epp.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.epq.setAlpha(179);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.aq.c(this.epq, w.g.pb_manager);
                            this.epp.setVisibility(8);
                            this.epq.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.aq.c(this.epq, w.g.pb_assist);
                            this.epp.setVisibility(8);
                            this.epq.setVisibility(0);
                        }
                    }
                    String string = c.getAuthor().getName_show() == null ? StringUtils.string(c.getAuthor().getUserName()) : StringUtils.string(c.getAuthor().getName_show());
                    if (StringUtils.isNull(c.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aF(c.getAuthor().getSealPrefix()) + 2;
                    }
                    if (!StringUtils.isNull(string)) {
                        int aF = com.baidu.adp.lib.util.j.aF(c.getAuthor().getName_show());
                        if (aF + i2 > 14) {
                            i3 = 0;
                        } else if (aF + i2 >= 12) {
                            i3 = 1;
                        } else if (aF + i2 >= 10) {
                            i3 = 2;
                            if (is_bawu == 0) {
                                i3 = 1;
                            }
                        }
                    }
                    ArrayList<IconData> iconInfo = c.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = c.getAuthor().getTShowInfoNew();
                    if (this.epr != null) {
                        this.epr.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.epr.setOnClickListener(this.eig.eiT.bWF);
                        this.epr.xr();
                        this.epr.a(iconInfo, i3, this.eig.getResources().getDimensionPixelSize(w.f.ds30), this.eig.getResources().getDimensionPixelSize(w.f.ds30), this.eig.getResources().getDimensionPixelSize(w.f.ds10));
                    }
                    if (this.eps != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.eps.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.eps.setOnClickListener(this.eig.eiT.erJ);
                        this.eps.a(tShowInfoNew, 3, this.eig.getResources().getDimensionPixelSize(w.f.ds32), this.eig.getResources().getDimensionPixelSize(w.f.ds32), this.eig.getResources().getDimensionPixelSize(w.f.ds8), true);
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aF(string) > 12) {
                            string = com.baidu.tbadk.core.util.au.d(string, 12, "...");
                        }
                    } else if (com.baidu.adp.lib.util.j.aF(string) > 14) {
                        string = com.baidu.tbadk.core.util.au.d(string, 14, "...");
                    }
                    this.epl.setText(af(c.getAuthor().getSealPrefix(), string));
                    this.epl.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                    this.epl.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                    if (!com.baidu.tbadk.core.util.x.q(tShowInfoNew)) {
                        com.baidu.tbadk.core.util.aq.c(this.epl, w.e.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.aq.c(this.epl, w.e.cp_cont_f, 1);
                    }
                    if (fVar.aJx().getAuthor() != null && fVar.aJx().getAuthor().getAlaUserData() != null && this.ept != null) {
                        if (fVar.aJx().getAuthor().getAlaUserData().anchor_live == 0 && fVar.aJx().getAuthor().getAlaUserData().enter_live == 0) {
                            this.ept.setVisibility(8);
                        } else {
                            this.ept.setVisibility(0);
                            com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                            bVar.QP = fVar.aJx().getAuthor().getAlaUserData();
                            bVar.type = 2;
                            this.ept.setTag(bVar);
                        }
                    }
                    this.epo.setUserId(c.getAuthor().getUserId());
                    this.epo.setUserName(c.getAuthor().getUserName());
                    this.epo.setImageDrawable(null);
                    this.epo.setRadius(com.baidu.adp.lib.util.k.g(this.eig.getActivity(), w.f.ds40));
                    this.epo.setTag(c.getAuthor().getUserId());
                    this.epz.a(c.getAuthor());
                    this.epz.eoG = z2;
                    if (!PbNormalLikeButtonSwitchStatic.GZ() || this.eql || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.epy.setVisibility(8);
                    } else {
                        this.epy.setVisibility(0);
                    }
                    String portrait = c.getAuthor().getPortrait();
                    if (c.getAuthor() != null && c.getAuthor().getPendantData() != null && !StringUtils.isNull(c.getAuthor().getPendantData().qB())) {
                        this.epo.setVisibility(8);
                        this.epn.setVisibility(0);
                        if (this.enx != null) {
                            this.enx.setVisibility(8);
                        }
                        this.epl.setOnClickListener(foVar);
                        this.epn.getHeadView().c(portrait, 28, false);
                        this.epn.getHeadView().setUserId(c.getAuthor().getUserId());
                        this.epn.getHeadView().setUserName(c.getAuthor().getUserName());
                        this.epn.getHeadView().setOnClickListener(foVar);
                        this.epn.dU(c.getAuthor().getPendantData().qB());
                    } else if (this.aiG) {
                        this.epo.setVisibility(0);
                        UserTbVipInfoData userTbVipInfoData = c.getAuthor().getUserTbVipInfoData();
                        if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.bba != null) {
                            if (this.bbb == null) {
                                this.bba.inflate();
                                this.bbb = (TbImageView) this.epe.findViewById(w.h.user_head_mask);
                            }
                            this.bbb.c(userTbVipInfoData.getvipV_url(), 10, false);
                        }
                        this.epl.setOnClickListener(foVar);
                        this.epo.setOnClickListener(foVar);
                        this.epn.setVisibility(8);
                    } else {
                        if (this.eqS) {
                            fp fpVar = new fp(this, c, z2);
                            if (this.eoT != null) {
                                this.eoT.setOnClickListener(fpVar);
                            }
                            this.epl.setOnClickListener(fpVar);
                            this.epo.setOnClickListener(fpVar);
                            this.epj.setOnClickListener(fpVar);
                            this.epo.setVisibility(8);
                            this.epn.setVisibility(8);
                        } else {
                            this.epo.setVisibility(0);
                            this.epj.setOnClickListener(foVar);
                            this.epl.setOnClickListener(foVar);
                            this.epo.setOnClickListener(foVar);
                        }
                        this.epn.setVisibility(8);
                    }
                    this.epo.c(portrait, 28, false);
                }
                if (fVar != null) {
                    this.eph.D(fVar.aJx());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.sJ() != null) {
            this.epk.a(this.eig.getPageContext(), fVar.aJz().get(0).sJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aJw().getId(), fVar.aJw().getName(), fVar.aJx().getId(), this.eig.aKS() ? "FRS" : null));
            this.epj.setPadding(this.epj.getPaddingLeft(), (int) this.eig.getResources().getDimension(w.f.ds20), this.epj.getPaddingRight(), this.epj.getPaddingBottom());
            return;
        }
        this.epk.a(null, null, null);
    }

    private void aNr() {
        this.eoM = (FrameLayout) this.eig.findViewById(w.h.root_float_header);
        int af = com.baidu.adp.lib.util.k.af(this.eig.getActivity());
        int i = (int) (af * 0.5625d);
        this.eoN = i;
        this.eoM.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        this.eoR = new com.baidu.tieba.play.c(this.eig.getPageContext(), this.eoM);
        this.eoO = new com.baidu.tieba.pb.video.d(this.eig, this.eoR, this.eoM, this.eoV, this.eoN);
    }

    private void m(com.baidu.tieba.pb.data.f fVar) {
        if (this.eoS == null) {
            this.eoS = new com.baidu.tieba.pb.video.b(this.eig, LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.video_pb_video_channel_info_layout, (ViewGroup) null));
        }
        com.baidu.tbadk.core.data.bp ts = fVar.aJx().ts();
        if (fVar.getUserData() != null) {
            ts.ZX = fVar.aJP();
        }
        this.eoS.b(ts);
        fVar.aJx().a(ts);
    }

    private void h(PostData postData) {
        if (this.eoT == null) {
            this.eoT = new TextView(this.eig.getActivity());
            this.eoT.setClickable(true);
            this.eoT.setTextSize(0, this.eig.getResources().getDimensionPixelSize(w.f.fontsize24));
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            this.eoT.setSingleLine(true);
            this.eoT.setEllipsize(TextUtils.TruncateAt.END);
            this.eoT.setLayoutParams(layoutParams);
            this.eoT.setGravity(16);
            int g = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds32);
            this.eoT.setPadding(g, 0, g, com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds40));
            com.baidu.tbadk.core.util.aq.c(this.eoT, w.e.cp_cont_j, 1);
        }
        String string = this.eig.getResources().getString(w.l.video_public_owner);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        if (postData != null && postData.getAuthor() != null) {
            String name_show = postData.getAuthor().getName_show();
            this.eoT.setTag(w.h.tag_user_id, String.valueOf(postData.getAuthor().getUserId()));
            this.eoT.setTag(w.h.tag_user_name, name_show);
            sb.append(" " + name_show);
            SpannableString spannableString = new SpannableString(sb);
            spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), string.length(), sb.length(), 33);
            this.eoT.setText(spannableString);
            return;
        }
        this.eoT.setText(string);
    }

    private void aNs() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoQ.euB.getLayoutParams();
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds26);
        this.eoQ.euB.setLayoutParams(layoutParams);
        this.epj.setPadding(this.epj.getPaddingLeft(), this.epj.getPaddingTop(), this.epj.getPaddingRight(), com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds34));
        if (this.epy.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.epy.getLayoutParams();
            aVar.bottomMargin = com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds20);
            this.epy.setLayoutParams(aVar);
        }
    }

    public void aNt() {
        if (this.eoO != null) {
            this.eoO.aPq();
        }
    }

    public boolean aNu() {
        return this.ers;
    }

    private boolean NH() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean z(com.baidu.tbadk.core.data.bi biVar) {
        if (biVar == null || biVar.getAuthor() == null || biVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), biVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.eoV.aOb();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eoV.lo(eVar.forumName);
                if (this.eoO != null) {
                    this.eoO.aPk();
                }
            }
            String string = this.eig.getResources().getString(w.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eig.getResources().getString(w.l.self);
                    break;
                case 300:
                    str = this.eig.getResources().getString(w.l.bawu);
                    break;
                case 400:
                    str = this.eig.getResources().getString(w.l.system);
                    break;
            }
            this.eig.showNetRefreshView(this.dTF, String.format(string, str), null, this.eig.getResources().getString(w.l.appeal_restore), true, new fq(this, eVar.efQ));
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aML;
        String sb;
        if (fVar != null) {
            this.elz = fVar;
            this.mType = i;
            if (fVar.aJx() != null) {
                this.eqD = fVar.aJx().sc();
                this.Zh = fVar.aJx().rZ();
                if (fVar.aJx().getAnchorLevel() != 0) {
                    this.ers = true;
                }
                this.eql = z(fVar.aJx());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            o(fVar);
            this.eqx = false;
            this.ehg = z;
            aNn();
            b(fVar, z, i);
            if (this.eig.aKI()) {
                if (this.epL == null) {
                    this.epL = new com.baidu.tieba.pb.view.m(this.eig.getPageContext());
                    this.epL.le();
                    this.epL.a(this.alp);
                }
                this.mListView.setPullRefresh(this.epL);
                aNv();
                if (this.epL != null) {
                    this.epL.dk(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (fVar.rr().ro() == 0 && z) {
                this.mListView.setPullRefresh(null);
                this.eoL = 1;
            } else {
                if (this.epL == null) {
                    this.epL = new com.baidu.tieba.pb.view.m(this.eig.getPageContext());
                    this.epL.le();
                    this.epL.a(this.alp);
                }
                this.mListView.setPullRefresh(this.epL);
                aNv();
                this.eoL = 2;
                if (this.epL != null) {
                    this.epL.dk(TbadkCoreApplication.m9getInst().getSkinType());
                }
                aIs();
            }
            aNw();
            this.epH.ib(this.ehg);
            this.epH.ic(false);
            this.epH.b(fVar);
            this.epH.notifyDataSetChanged();
            if (fVar.aJw() != null) {
                this.mForumName = fVar.aJw().getName();
                this.mForumId = fVar.getForumId();
            }
            this.eoV.lo(this.mForumName);
            if (this.eoO != null) {
                this.eoO.aPk();
            }
            if (fVar.aJx() != null) {
                nE(com.baidu.tbadk.core.util.au.w(fVar.aJx().sh()));
                if (fVar.aJx().se() != null) {
                    if (fVar.aJx().se().getNum() < 1) {
                        sb = this.eig.getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(fVar.aJx().se().getNum())).toString();
                    }
                    if (this.eoH != -1) {
                        fVar.aJx().se().setIsLike(this.eoH);
                    }
                    P(sb, fVar.aJx().se().getIsLike() == 1);
                }
            }
            if (fVar.rr().rn() == 0 && !z) {
                this.mListView.setNextPage(null);
                this.eoU = 1;
            } else if (this.eig.isLogin()) {
                this.mListView.setNextPage(this.epM);
                this.eoU = 2;
                aIs();
            } else if (fVar.rr().rn() == 1) {
                this.eqx = true;
                if (this.epN == null) {
                    this.epN = new com.baidu.tieba.pb.view.b(this.eig.getPageContext());
                }
                this.mListView.setNextPage(this.epN);
                this.eoU = 3;
            }
            ArrayList<PostData> aJz = fVar.aJz();
            if (fVar.rr().rn() == 0 || aJz == null || aJz.size() < fVar.rr().rm()) {
                this.epM.setText(this.eig.getResources().getString(w.l.list_no_more));
                if (this.eig.aKI() && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() == 1 && (this.mListView.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.epM.setText("");
                }
                aNB();
            } else if (z2) {
                if (this.erp) {
                    xe();
                    if (fVar.rr().rn() != 0) {
                        this.epM.setText(this.eig.getResources().getString(w.l.pb_load_more));
                    }
                } else {
                    this.epM.xg();
                }
            } else {
                this.epM.xg();
            }
            if (fVar.aJx() != null && fVar.aJx().getAuthor() != null && fVar.aJx().getAuthor().getType() == 0) {
                this.eoV.aNY();
            }
            switch (i) {
                case 2:
                    this.mListView.setSelection(i2 > 1 ? i2 - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aML = ep.aMK().aML()) != null) {
                        this.erj = true;
                        this.mListView.onRestoreInstanceState(aML);
                        break;
                    } else {
                        this.mListView.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.erp = false;
                    this.mListView.setSelection(0);
                    break;
                case 5:
                    this.mListView.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aML2 = ep.aMK().aML();
                        this.erj = true;
                        if (aML2 != null) {
                            this.mListView.onRestoreInstanceState(aML2);
                            break;
                        }
                    }
                    this.mListView.setSelection(0);
                    break;
            }
            if (this.eqD == eqF && NH()) {
                aNH();
            }
            if (!this.erj && fVar.aJG() == null && !fVar.aJx().tb()) {
                this.eqP.aE(this.eig.getResources().getString(w.l.pb_more_tools_guide_tip), String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips");
                this.erj = true;
            }
            E(fVar.aJx());
            this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void aNv() {
        if (this.eoM != null) {
            this.mListView.removeHeaderView(this.avD);
            this.mListView.removeHeaderView(this.eqC);
            this.mListView.addHeaderView(this.eqC, 0);
            if (this.mType != 1 && this.eoO != null) {
                this.eoO.aPn();
                return;
            }
            return;
        }
        this.mListView.removeHeaderView(this.eqC);
        this.mListView.removeHeaderView(this.avD);
        this.mListView.addHeaderView(this.avD, 0);
    }

    public void iN(boolean z) {
        this.eqk = z;
        this.eoV.iN(z);
    }

    public void xe() {
        if (this.epM != null) {
            this.epM.xe();
        }
        aIs();
    }

    public void KZ() {
        this.mListView.setVisibility(0);
    }

    private boolean aNw() {
        boolean z;
        if (this.eqn != null && this.eqn.getVisibility() == 0) {
            z = true;
            if (this.epD != null) {
                this.epD.setVisibility(0);
            }
        } else {
            if (this.epD != null) {
                this.epD.setVisibility(8);
            }
            z = false;
        }
        if ((this.epF == null || this.epF.getVisibility() == 8) && z && this.ehg) {
            this.epE.setVisibility(0);
        } else {
            this.epE.setVisibility(8);
        }
        com.baidu.tieba.graffiti.c.al(this.epE);
        return z;
    }

    private boolean n(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aJx() == null) {
            return false;
        }
        if (fVar.aJx().sm() == 1 || fVar.aJx().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aJx().so() == null || fVar.aJx().so().tD() == 0) || fVar.aJx().sk() == 1 || fVar.aJx().sl() == 1 || fVar.aJx().sT() || fVar.aJx().tg() || fVar.aJx().ta() || fVar.aJx().sA() != null || fVar.aJx().th() || fVar.aJx().th() || !com.baidu.tbadk.core.util.au.isEmpty(fVar.aJx().sg()) || fVar.aJx().sr();
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return com.baidu.tieba.card.at.a((Context) this.eig.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.epc != null) {
                if (fVar.aJx() != null && fVar.aJx().sD() == 0 && !fVar.aJx().tb() && !this.erf) {
                    this.epc.setVisibility(0);
                    fVar.aJx().sX();
                    if (fVar.aJx() != null) {
                        fVar.aJx().e(true, n(fVar));
                    }
                    SpannableStringBuilder sO = fVar.aJx().sO();
                    this.epd.setOnTouchListener(new com.baidu.tieba.view.x(sO));
                    if (sO == null || sO.length() == 0) {
                        this.epd.setVisibility(8);
                    } else {
                        this.epd.setText(sO);
                        this.epd.setVisibility(0);
                    }
                    this.epj.setPadding(this.epj.getPaddingLeft(), this.epj.getPaddingTop(), com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds32), this.epj.getPaddingBottom());
                } else {
                    this.epc.setVisibility(8);
                    this.mListView.removeHeaderView(this.epc);
                    if (fVar.aJx() != null && fVar.aJx().tb()) {
                        this.epj.setPadding(this.epj.getPaddingLeft(), 0, this.epj.getPaddingRight(), this.epj.getPaddingBottom());
                    } else {
                        this.epj.setPadding(this.epj.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds48), this.epj.getPaddingRight(), this.epj.getPaddingBottom());
                    }
                }
            }
            this.ehg = z;
            com.baidu.tbadk.core.data.bi aJx = fVar.aJx();
            if (aJx != null) {
                a(aJx.so());
            }
        }
        return false;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aNw();
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
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aJH()));
            sparseArray.put(w.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(w.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(w.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(w.h.tag_del_post_id, c.getId());
            sparseArray.put(w.h.tag_del_post_type, 0);
            sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aJH()));
            sparseArray.put(w.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aFn;
    }

    public void nF(String str) {
        if (this.epM != null && !StringUtils.isNull(str)) {
            this.epM.setText(str);
        }
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public int aNx() {
        return w.h.richText;
    }

    public TextView aKl() {
        return this.eph.aKl();
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(ab.b bVar) {
        this.alp = bVar;
        if (this.epL != null) {
            this.epL.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int rl = apVar.rl();
            int ri = apVar.ri();
            if (this.epI != null) {
                this.epI.tQ();
            } else {
                this.epI = new com.baidu.tbadk.core.dialog.a(this.eig.getPageContext().getPageActivity());
                this.epJ = LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.dialog_direct_pager, (ViewGroup) null);
                this.epI.v(this.epJ);
                this.epI.a(w.l.dialog_ok, bVar);
                this.epI.b(w.l.dialog_cancel, new fr(this));
                this.epI.a(new ft(this));
                this.epI.b(this.eig.getPageContext()).tQ();
            }
            this.epK = (EditText) this.epJ.findViewById(w.h.input_page_number);
            this.epK.setText("");
            TextView textView = (TextView) this.epJ.findViewById(w.h.current_page_number);
            if (rl <= 0) {
                rl = 1;
            }
            if (ri <= 0) {
                ri = 1;
            }
            textView.setText(MessageFormat.format(this.eig.getApplicationContext().getResources().getString(w.l.current_page), Integer.valueOf(rl), Integer.valueOf(ri)));
            this.eig.ShowSoftKeyPadDelay(this.epK, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eig.showToast(str);
    }

    public boolean iO(boolean z) {
        if (this.KM == null || !this.KM.Dq()) {
            return false;
        }
        this.KM.BC();
        return true;
    }

    public void aNy() {
        if (this.ert != null) {
            while (this.ert.size() > 0) {
                TbImageView remove = this.ert.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aNy();
        this.epH.of(1);
        if (this.eoO != null) {
            this.eoO.onPause();
        }
    }

    public void onResume() {
        this.epH.of(2);
        if (this.eoO != null) {
            this.eoO.onResume();
        }
    }

    public void onDestroy() {
        this.eqP.UH();
        if (this.eqQ != null) {
            this.eqQ.UH();
        }
        this.eig.hideProgressBar();
        if (this.bEr != null && this.bLW != null) {
            this.bEr.b(this.bLW);
        }
        awH();
        this.epM.xe();
        if (this.eqL != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eqL);
        }
        if (this.eqM != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eqM);
        }
        aNE();
        if (this.ere != null) {
            this.ere.removeAllViews();
        }
        if (this.epj != null && this.enx != null) {
            this.epj.removeView(this.epm);
            this.enx = null;
        }
        if (this.eqB != null) {
            this.eqB.clearStatus();
        }
        this.erl = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.epH.of(3);
        if (this.bHd != null) {
            this.bHd.setBackgroundDrawable(null);
        }
        if (this.eoO != null) {
            this.eoO.destroy();
        }
    }

    public boolean ot(int i) {
        if (this.eoO != null) {
            return this.eoO.ot(i);
        }
        return false;
    }

    public void awH() {
        this.eoV.oI();
        this.eqP.UH();
        com.baidu.adp.lib.util.k.b(this.eig.getPageContext().getPageActivity(), this.epK);
        if (this.eqj != null) {
            this.eqj.dismiss();
        }
        aNz();
        if (this.eqQ != null) {
            this.eqQ.UH();
        }
        if (this.epI != null) {
            this.epI.dismiss();
        }
        if (this.bOo != null) {
            this.bOo.dismiss();
        }
    }

    public void ia(boolean z) {
        this.epH.ia(z);
    }

    public void gB(boolean z) {
        this.dpj = z;
    }

    public void aNz() {
        if (this.epR != null) {
            this.epR.dismiss();
        }
        if (this.epS != null) {
            com.baidu.adp.lib.g.j.b(this.epS, this.eig.getPageContext());
        }
        if (this.eqc != null) {
            com.baidu.adp.lib.g.j.b(this.eqc, this.eig.getPageContext());
        }
        if (this.epP != null) {
            com.baidu.adp.lib.g.j.b(this.epP, this.eig.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.elz, this.ehg);
            d(this.elz, this.ehg, this.mType);
            a(this.elz, this.eqw, i);
            this.eig.getLayoutMode().aj(i == 1);
            this.eig.getLayoutMode().t(this.dTF);
            this.eig.getLayoutMode().t(this.epd);
            this.eig.getLayoutMode().t(this.epe);
            this.eig.getLayoutMode().t(this.epa);
            if (this.epw != null) {
                com.baidu.tbadk.core.util.aq.c(this.epw, w.e.cp_cont_d, 1);
            }
            if (this.epv != null) {
                com.baidu.tbadk.core.util.aq.c(this.epv, w.e.cp_cont_d, 1);
            }
            if (this.rank > 0) {
                com.baidu.tbadk.core.util.aq.c(this.epp, BitmapHelper.getGradeResourceIdNew(this.rank));
            }
            if (this.eoQ != null) {
                this.eoQ.Bn();
            }
            if (this.eoS != null) {
                this.eoS.Bn();
            }
            if (this.eoT != null) {
                com.baidu.tbadk.core.util.aq.c(this.eoT, w.e.cp_cont_j, 1);
                String string = this.eig.getResources().getString(w.l.video_public_owner);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (this.eoT.getTag(w.h.tag_user_name) instanceof String) {
                    sb.append((String) this.eoT.getTag(w.h.tag_user_name));
                    SpannableString spannableString = new SpannableString(sb);
                    spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), string.length(), sb.length(), 33);
                    this.eoT.setText(spannableString);
                } else {
                    this.eoT.setText(string);
                }
            }
            this.eig.getLayoutMode().t(this.epa);
            com.baidu.tbadk.core.util.aq.i(this.epd, w.e.cp_cont_b);
            this.epd.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.eig.getLayoutMode().t(this.aFn);
            if (this.epJ != null) {
                this.eig.getLayoutMode().t(this.epJ);
            }
            iN(this.eqk);
            this.epH.notifyDataSetChanged();
            if (this.epL != null) {
                this.epL.dk(i);
            }
            if (this.epM != null) {
                this.epM.dk(i);
                com.baidu.tbadk.core.util.aq.j(this.aFn, w.g.pb_foot_more_trans_selector);
                this.epM.di(w.g.pb_foot_more_trans_selector);
            }
            if (this.KM != null) {
                this.KM.onChangeSkinType(i);
            }
            if (this.epx != null) {
                this.epx.m26do(i);
            }
            if (this.epN != null) {
                this.epN.dk(i);
            }
            if (this.eoZ != null && this.eoZ.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eoZ) {
                    aVar.aNU();
                }
            }
            if (this.ere != null) {
                com.baidu.tbadk.core.util.aq.k(this.ere, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.k(this.eqY, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aq.c(this.erd, w.e.cp_cont_c, 1);
            }
            iH(i == 1);
            this.epi.changeSkinType(i);
            aNa();
            UtilHelper.setStatusBarBackground(this.bHd, i);
            if (this.epy != null) {
                this.epy.onChangeSkinType(i);
            }
            if (this.epA != null) {
                com.baidu.tbadk.m.a.a(this.eig.getPageContext(), this.epA);
            }
            if (this.eqO != null) {
                this.eqO.onChangeSkinType(i);
            }
            if (this.eoV != null) {
                if (this.eoO != null) {
                    this.eoO.ov(i);
                } else {
                    this.eoV.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNK = eVar;
        this.epH.setOnImageClickListener(this.aNK);
    }

    public void h(NoNetworkView.a aVar) {
        this.bLW = aVar;
        if (this.bEr != null) {
            this.bEr.a(this.bLW);
        }
    }

    public void iP(boolean z) {
        this.epH.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aNA() {
        return this.eqn;
    }

    public void aNB() {
        if (this.eoU != 2) {
            this.mListView.setNextPage(this.epM);
            this.eoU = 2;
        }
    }

    public void aNC() {
        if (com.baidu.tbadk.j.aa.GG().GH()) {
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
                                perfLog.fe(1001);
                                perfLog.aGv = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.wJ();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.j.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fe(1001);
                        perfLog2.aGv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.wJ();
                    }
                }
            }
        }
    }

    public void gC(boolean z) {
        if (this.eqo != null && this.eqo != null) {
            if (this.dpj) {
                gD(z);
            } else {
                gE(z);
            }
        }
    }

    public void aND() {
        if (this.eqo != null) {
            this.eqo.setVisibility(8);
        }
    }

    public void auv() {
        if (this.eqv == null) {
            this.eqv = new com.baidu.tbadk.core.view.a(this.eig.getPageContext());
        }
        this.eqv.aK(true);
    }

    public void aIs() {
        if (this.eqv != null) {
            this.eqv.aK(false);
        }
    }

    private void a(com.baidu.tieba.pb.data.f fVar, PostData postData, int i) {
        if (fVar != null && postData != null && postData.getAuthor() != null && postData.getAuthor().getGodUserData() != null) {
            GodUserData godUserData = postData.getAuthor().getGodUserData();
            if (2 == godUserData.getType()) {
                MetaData author = postData.getAuthor();
                long userIdLong = postData.getAuthor().getUserIdLong();
                String userName = postData.getAuthor().getUserName();
                int fansNum = postData.getAuthor().getFansNum();
                postData.getId();
                postData.getAuthor().getPortrait();
                fv fvVar = new fv(this, postData);
                if (this.eqU == null || this.mSkinType != i) {
                    if (this.eqU == null) {
                        this.eqU = (LinearLayout) LayoutInflater.from(this.eig.getActivity()).inflate(w.j.god_floating_view, (ViewGroup) null);
                    }
                    this.eqU.setOnClickListener(fvVar);
                    this.eqU.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
                    this.eqU.setTag(w.h.tag_user_name, userName);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.eqU.findViewById(w.h.god_floating_owner_photo);
                    if (this.aiG) {
                        ViewStub viewStub = (ViewStub) this.eqU.findViewById(w.h.viewstub_headimage_mask);
                        if (viewStub != null && 0 == 0) {
                            viewStub.inflate();
                            TbImageView tbImageView = (TbImageView) this.eqU.findViewById(w.h.user_head_mask);
                            if (tbImageView != null && author != null && author.getUserTbVipInfoData() != null && !StringUtils.isNull(author.getUserTbVipInfoData().getvipV_url())) {
                                tbImageView.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                                clickableHeaderImageView.setIsBigV(true);
                            }
                        }
                    } else {
                        clickableHeaderImageView.setGodIconMargin(0);
                    }
                    clickableHeaderImageView.setOnClickListener(fvVar);
                    clickableHeaderImageView.setTag(postData.getAuthor().getUserId());
                    clickableHeaderImageView.c(postData.getAuthor().getPortrait(), 28, false);
                    ImageView imageView = (ImageView) this.eqU.findViewById(w.h.god_floating_owner_info_user_rank);
                    int level_id = postData.getAuthor().getLevel_id();
                    int is_bawu = postData.getAuthor().getIs_bawu();
                    String bawu_type = postData.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        imageView.setVisibility(0);
                        com.baidu.tbadk.core.util.aq.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                        imageView.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(level_id)));
                        imageView.setOnClickListener(null);
                    } else {
                        imageView.setVisibility(8);
                    }
                    ImageView imageView2 = (ImageView) this.eqU.findViewById(w.h.god_floating_owner_info_user_bawu);
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.aq.c(imageView2, w.g.pb_manager);
                            imageView.setVisibility(8);
                            imageView2.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.aq.c(imageView2, w.g.pb_assist);
                            imageView.setVisibility(8);
                            imageView2.setVisibility(0);
                        }
                    }
                    if (!StringUtils.isNull(postData.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aF(postData.getAuthor().getName_show()) > 14) {
                        i2 = 0;
                    }
                    ArrayList<IconData> iconInfo = postData.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                    UserIconBox userIconBox = (UserIconBox) this.eqU.findViewById(w.h.god_floating_owner_info_user_icon);
                    UserIconBox userIconBox2 = (UserIconBox) this.eqU.findViewById(w.h.god_floating_owner_info_tshow_icon);
                    if (userIconBox != null) {
                        userIconBox.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                        userIconBox.setOnClickListener(this.eig.eiT.bWF);
                        userIconBox.a(iconInfo, i2, this.eig.getResources().getDimensionPixelSize(w.f.ds30), this.eig.getResources().getDimensionPixelSize(w.f.ds30), this.eig.getResources().getDimensionPixelSize(w.f.ds10));
                    }
                    if (userIconBox2 != null) {
                        userIconBox2.setOnClickListener(this.eig.eiT.erJ);
                        userIconBox2.a(tShowInfoNew, 3, this.eig.getResources().getDimensionPixelSize(w.f.ds32), this.eig.getResources().getDimensionPixelSize(w.f.ds32), this.eig.getResources().getDimensionPixelSize(w.f.ds8), true);
                    }
                    TextView textView = (TextView) this.eqU.findViewById(w.h.god_floating_owner_info_user_name);
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_f, 1);
                    }
                    textView.setText(postData.getAuthor().getName_show());
                    if (aNK() != null && this.eqU.getParent() == null) {
                        aNK().addView(this.eqU);
                    }
                    this.eig.getLayoutMode().t(this.eqU);
                }
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) this.eqU.findViewById(w.h.god_floating_gift);
                this.erh.a(entelechyUserLikeButton);
                this.erh.a(postData.getAuthor());
                ImageView imageView3 = (ImageView) this.eqU.findViewById(w.h.god_floating_arrow);
                com.baidu.tbadk.core.util.aq.c(imageView3, w.g.icon_arrow_tab);
                if (this.eql || (godUserData.getIsLike() && godUserData.getIsFromNetWork())) {
                    entelechyUserLikeButton.setVisibility(8);
                    imageView3.setVisibility(0);
                } else {
                    entelechyUserLikeButton.setVisibility(0);
                    imageView3.setVisibility(8);
                }
                String format = String.format(this.eig.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(fansNum));
                TextView textView2 = (TextView) this.eqU.findViewById(w.h.god_floating_intro);
                if (textView2 != null) {
                    textView2.setText(format);
                }
            }
        }
    }

    private boolean a(com.baidu.tieba.pb.data.f fVar, PostData postData, String str, String str2, boolean z, boolean z2) {
        boolean z3;
        FrameLayout.LayoutParams layoutParams;
        if (fVar == null || postData == null || postData.getAuthor() == null || postData.getAuthor().getGodUserData() == null) {
            return false;
        }
        GodUserData godUserData = postData.getAuthor().getGodUserData();
        if (2 != godUserData.getType()) {
            return false;
        }
        if (fVar.aJx() == null || !fVar.aJx().tb() || fVar.aJx().sF() == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        MetaData author = postData.getAuthor();
        long userIdLong = postData.getAuthor().getUserIdLong();
        String userName = postData.getAuthor().getUserName();
        int fansNum = postData.getAuthor().getFansNum();
        postData.getId();
        String portrait = postData.getAuthor().getPortrait();
        if (this.epy.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.epy.getLayoutParams();
            aVar.gravity = 48;
            this.epy.setLayoutParams(aVar);
        }
        this.epj.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32), 0);
        this.eqN.setPadding(0, com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds8), 0, 0);
        if (postData.getType() == null || postData.getType().getId() != PostData.Yc.getId()) {
            this.epa.setPadding(0, 0, 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds76);
        if (this.epo.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.epo.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.epo.setLayoutParams(layoutParams);
        this.epo.setVisibility(8);
        View findViewWithTag = this.epj.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.enx = new ClickableHeaderImageView(this.eig.getApplicationContext());
            this.enx.setGodIconMargin(0);
            this.enx.setTag("pb_god_head_image_view_tag");
            this.enx.setUserId(String.valueOf(userIdLong));
            this.enx.setUserName(userName);
            layoutParams.leftMargin = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds0);
            this.epm.addView(this.enx, 0, layoutParams);
        } else {
            this.enx = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.aiG) {
            this.enx.setIsBigV(true);
        }
        fw fwVar = new fw(this, postData, fVar);
        this.epj.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.epj.setTag(w.h.tag_user_name, userName);
        this.epe.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.epe.setTag(w.h.tag_user_name, userName);
        this.enx.setVisibility(0);
        this.enx.setOnClickListener(fwVar);
        this.enx.c(portrait, 28, false);
        if (this.epw == null) {
            this.epw = new TextView(this.eig.getActivity());
            this.epw.setClickable(true);
            this.epw.setTextSize(0, this.eig.getResources().getDimensionPixelSize(w.f.fontsize24));
            ColumnLayout.a aVar2 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar2.topMargin = this.eig.getResources().getDimensionPixelSize(w.f.ds10);
            this.epw.setSingleLine(true);
            this.epw.setEllipsize(TextUtils.TruncateAt.END);
            this.epw.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
            this.epw.setTag(w.h.tag_user_name, userName);
            com.baidu.tbadk.core.util.aq.c(this.epw, w.e.cp_cont_d, 1);
            this.epw.setOnTouchListener(this.ehl);
            this.epj.addView(this.epw, -1, aVar2);
        }
        String string = this.eig.getResources().getString(w.l.tieba_certification);
        this.epw.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.eig.getResources().getString(w.l.god_intro_default)) : String.format(string, godUserData.getIntro()));
        if (this.epv == null) {
            this.epv = new TextView(this.eig.getActivity());
            this.epv.setClickable(false);
            this.epv.setIncludeFontPadding(false);
            this.epv.setGravity(16);
            this.epv.setTextSize(0, this.eig.getResources().getDimensionPixelSize(w.f.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.eig.getResources().getDimensionPixelSize(w.f.ds5);
            aVar3.bottomMargin = this.eig.getResources().getDimensionPixelSize(w.f.ds10);
            this.epv.setSingleLine(true);
            com.baidu.tbadk.core.util.aq.c(this.epv, w.e.cp_cont_d, 1);
            this.epj.addView(this.epv, -1, aVar3);
        }
        this.epv.setText(String.format(this.eig.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(fansNum)));
        this.epv.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.epv.setTag(w.h.tag_user_name, userName);
        this.epv.setOnClickListener(fwVar);
        if (z3) {
            this.epv.setVisibility(4);
        } else {
            this.epv.setVisibility(0);
        }
        if (this.eqV == null) {
            this.eqV = new TextView(this.eig.getApplicationContext());
            this.eqV.setId(w.h.pb_god_user_tip_content);
            this.eqV.setEllipsize(TextUtils.TruncateAt.END);
            this.eqV.setGravity(17);
            this.eqV.setSingleLine(true);
            this.eqV.setHeight(this.eig.getResources().getDimensionPixelSize(w.f.ds56));
            this.eqV.setTextSize(0, this.eig.getResources().getDimensionPixelSize(w.f.fontsize24));
            this.eqV.setVisibility(8);
            if (aNK() != null) {
                aNK().addView(this.eqV);
            }
            this.eig.getLayoutMode().t(this.eqV);
        }
        com.baidu.tbadk.core.util.aq.j(this.eqV, w.e.common_color_10260);
        com.baidu.tbadk.core.util.aq.i(this.eqV, w.e.cp_cont_g);
        this.eqV.setOnClickListener(new fx(this));
        this.eqV.setText(String.format(this.eig.getResources().getString(w.l.god_user_floor_owner_tip), com.baidu.tbadk.core.util.au.t(this.eqW)));
        ou(this.eqW);
        if (!z3) {
            a(fVar, postData, this.mSkinType);
        }
        this.ere = this.epM.xa();
        if (this.ere != null && !this.eql && !z && z2 && (!godUserData.getIsLike() || !godUserData.getIsFromNetWork())) {
            this.epM.xb();
            this.epM.wX();
            this.eqY = this.ere.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.eqY == null) {
                this.eqY = new View(this.eig.getApplicationContext());
                this.eqY.setTag("pb_god_bottom_extra_line_view_tag");
                this.ere.addView(this.eqY, new LinearLayout.LayoutParams(-1, this.eig.getResources().getDimensionPixelSize(w.f.ds20)));
                this.erc = new FrameLayout(this.eig.getApplicationContext());
                this.erc.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.era = new ClickableHeaderImageView(this.eig.getApplicationContext());
                this.era.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.era.c(portrait, 28, false);
                this.era.setUserId(String.valueOf(userIdLong));
                this.era.setUserName(userName);
                this.era.setOnClickListener(fwVar);
                this.erc.addView(this.era, new FrameLayout.LayoutParams(this.eig.getResources().getDimensionPixelSize(w.f.ds130), this.eig.getResources().getDimensionPixelSize(w.f.ds130)));
                if (this.aiG) {
                    this.erb = new TbImageView(this.eig.getApplicationContext());
                    this.erb.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.erb.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.eig.getResources().getDimensionPixelSize(w.f.ds45), this.eig.getResources().getDimensionPixelSize(w.f.ds45));
                    layoutParams3.gravity = 85;
                    this.erc.addView(this.erb, layoutParams3);
                } else {
                    this.era.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(this.eig.getResources().getDimensionPixelSize(w.f.ds130), this.eig.getResources().getDimensionPixelSize(w.f.ds130));
                layoutParams4.gravity = 17;
                layoutParams4.topMargin = this.eig.getResources().getDimensionPixelSize(w.f.ds40);
                this.ere.addView(this.erc, layoutParams4);
                this.erd = new TextView(this.eig.getApplicationContext());
                this.erd.setTag("pb_god_bottom_extra_text_view_tag");
                this.erd.setSingleLine(true);
                this.erd.setTextSize(0, this.eig.getResources().getDimensionPixelSize(w.f.fontsize24));
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.topMargin = this.eig.getResources().getDimensionPixelSize(w.f.ds36);
                layoutParams5.gravity = 1;
                this.erd.setText(this.eig.getResources().getString(w.l.god_user_attention_tip));
                this.ere.addView(this.erd, layoutParams5);
                if (this.eqZ == null) {
                    this.eqZ = new EntelechyUserLikeButton(this.eig.getApplicationContext());
                    this.eri.a(this.eqZ);
                }
                this.eqZ.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.eqZ.setTextSize(0, this.eig.getResources().getDimensionPixelSize(w.f.fontsize24));
                this.eqZ.setGravity(17);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, this.eig.getResources().getDimensionPixelSize(w.f.ds54));
                layoutParams6.topMargin = this.eig.getResources().getDimensionPixelSize(w.f.ds30);
                layoutParams6.bottomMargin = this.eig.getResources().getDimensionPixelSize(w.f.ds40);
                layoutParams6.gravity = 1;
                this.ere.addView(this.eqZ, layoutParams6);
            } else {
                this.eqZ = (EntelechyUserLikeButton) this.ere.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.era = (ClickableHeaderImageView) this.ere.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.erd = (TextView) this.ere.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.eqY = this.ere.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            this.eri.a(postData.getAuthor());
            com.baidu.tbadk.core.util.aq.k(this.ere, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.k(this.eqY, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.c(this.erd, w.e.cp_cont_c, 1);
            this.ere.setOnTouchListener(new fy(this));
        } else {
            this.epM.xc();
            this.epM.wW();
        }
        return true;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!this.erk && aNS()) {
            c(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.eqS && !this.eiM && i > this.eoL) {
            this.eqT = true;
        } else {
            this.eqT = false;
            aNF();
        }
        if (!this.erk && aNS()) {
            b(absListView, i, i2, i3);
        }
        a aVar = new a();
        aVar.erD = i;
        aVar.erE = this.mListView.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
    }

    private void c(AbsListView absListView, int i) {
        if (this.eoO != null) {
            this.eoO.a(absListView, i, this.eqC);
        }
    }

    private void b(AbsListView absListView, int i, int i2, int i3) {
        if (this.eoO != null) {
            this.eoO.b(absListView, i, this.eqC);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int erD;
        public int erE;

        public a() {
        }
    }

    private void ou(int i) {
        boolean z;
        if (this.eqV != null && this.eqV.getVisibility() != 0 && i >= 2 && !this.eql) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.eqX = true;
                this.eqV.setVisibility(0);
            }
            com.baidu.adp.lib.g.h.fR().postDelayed(this.bQF, 3000L);
        }
    }

    public void aNE() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bQF);
        if (this.eqV != null && 8 != this.eqV.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.eig, this.eqV, w.a.fade_out, new fz(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aNF() {
        if (this.eqU != null) {
            this.eqU.clearAnimation();
            if (this.eqU.getVisibility() != 8) {
                this.eqU.setVisibility(8);
            }
        }
    }

    public void aNG() {
        if (this.eqS && this.eqT && this.eqU != null && this.eqU.getVisibility() != 0 && !this.eqX) {
            this.eqU.clearAnimation();
            this.eqU.setVisibility(0);
        }
    }

    public void aNH() {
        if (!this.eru) {
            TiebaStatic.log("c10490");
            this.eru = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eig.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eqG, Integer.valueOf(eqI));
            aVar.bY(w.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(w.h.function_description_view)).setText(w.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(w.h.title_view)).setText(w.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(w.l.grade_button_tips, this.eig);
            aVar.b(w.l.look_again, new ga(this));
            aVar.b(this.eig.getPageContext()).tQ();
        }
    }

    public void aNI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eig.getPageContext().getPageActivity());
        aVar.cE(this.eig.getResources().getString(w.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eqG, Integer.valueOf(eqK));
        aVar.A(sparseArray);
        aVar.a(w.l.upgrade_to_new, this.eig);
        aVar.b(w.l.cancel, new gb(this));
        aVar.b(this.eig.getPageContext()).tQ();
    }

    public int sc() {
        return this.eqD;
    }

    public void nG(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eig.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eig.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(w.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(w.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eqG, Integer.valueOf(eqJ));
        aVar.A(sparseArray);
        aVar.a(w.l.view, this.eig);
        aVar.b(w.l.cancel, new gc(this));
        aVar.b(this.eig.getPageContext()).tQ();
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

    public PbInterviewStatusView aNJ() {
        return this.eqB;
    }

    private void o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aJx() != null && fVar.aJx().tg() && this.eqB == null) {
            this.eqB = (PbInterviewStatusView) this.eqA.inflate();
            this.eqB.setOnClickListener(this.bOx);
            this.eqB.setCallback(this.eig.aKR());
            this.eqB.a(this.eig, fVar);
        }
    }

    public LinearLayout aNK() {
        return this.epG;
    }

    public View aNL() {
        return this.bHd;
    }

    public boolean aNM() {
        return this.erf;
    }

    /* renamed from: if  reason: not valid java name */
    public void m24if(boolean z) {
        this.eph.m25if(z);
    }

    private void aNN() {
        if (this.erf) {
            if (this.erg == null) {
                f.a aVar = f.eij.get();
                if (aVar != null) {
                    this.erg = aVar.a(this.eig);
                    ListAdapter adapter = this.mListView.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.avD) {
                            this.mListView.addHeaderView(this.erg.aKj(), 1);
                        } else {
                            this.mListView.addHeaderView(this.erg.aKj(), 0);
                        }
                    }
                } else {
                    this.epe.setVisibility(0);
                    return;
                }
            }
            this.epe.setVisibility(8);
            this.mListView.removeHeaderView(this.epe);
            return;
        }
        this.epe.setVisibility(0);
    }

    public void iQ(boolean z) {
        this.erf = z;
    }

    public View aLy() {
        return this.epi.aLy();
    }

    public void aNO() {
        this.eig.showNetRefreshView(getView(), "");
        View EZ = this.eig.getRefreshView().EZ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EZ.getLayoutParams();
        layoutParams.addRule(3, aNK().getId());
        EZ.setLayoutParams(layoutParams);
        this.eig.hideLoadingView(getView());
        if (this.erg != null) {
            this.mListView.removeHeaderView(this.erg.aKj());
            this.erg = null;
        }
    }

    public void nH(String str) {
        if (this.eoW != null) {
            this.eoW.setTitle(str);
        }
    }

    public void aNP() {
        if (this.epH != null) {
            if (this.epH.aLf() != null) {
                this.epH.aLf().axZ();
            }
            if (this.epH.aLg() != null) {
                this.epH.aLg().axZ();
            }
        }
    }

    private int iR(boolean z) {
        if (this.eqB == null || this.eqB.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.eig.getPageContext().getPageActivity(), w.f.ds72);
    }

    private void aNQ() {
        if (this.eqB != null && this.eqB.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eqB.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eqB.setLayoutParams(layoutParams);
        }
    }

    public boolean aKs() {
        return this.eqS;
    }

    public TextView aNR() {
        return this.epw;
    }

    public void nI(String str) {
        this.eqr.performClick();
        if (!StringUtils.isNull(str) && this.eig.aKm() != null && this.eig.aKm().DO() != null && this.eig.aKm().DO().DG() != null) {
            EditText DG = this.eig.aKm().DO().DG();
            DG.setText(str);
            DG.setSelection(str.length());
        }
    }

    public boolean aNS() {
        return (this.eoO == null || this.eoR == null) ? false : true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            awH();
            aND();
            aMQ();
            if (this.eqO != null) {
                this.eqO.aLk();
            }
            this.eig.Zq();
            aNF();
            this.epG.setVisibility(8);
            this.eoV.setTitleVisibility(true);
            this.eig.im(false);
            this.erk = false;
            if (this.eoR != null && this.eoM != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eoM.getLayoutParams();
                layoutParams.topMargin = 0;
                this.eoM.setLayoutParams(layoutParams);
                if (configuration.orientation == 2) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.erk = true;
                } else {
                    int af = com.baidu.adp.lib.util.k.af(this.eig.getActivity());
                    layoutParams.width = af;
                    layoutParams.height = (int) (af * 0.5625d);
                    if (this.eoO != null) {
                        this.eoO.aOd();
                    }
                    this.epG.setVisibility(0);
                    this.erk = false;
                }
                this.eoM.setLayoutParams(layoutParams);
                this.eoR.a(this.eig, configuration);
            }
        }
    }

    public void x(long j, int i) {
        if (this.eoS != null && j > 0) {
            this.eoS.j(i, j);
        }
    }

    public void iS(boolean z) {
        this.eoP = z;
    }

    private void E(com.baidu.tbadk.core.data.bi biVar) {
        if (this.eoS != null && biVar != null && biVar.ts() != null && biVar.ts().ZX == 2) {
            if (this.eqQ == null) {
                this.eqQ = new com.baidu.tieba.d.a(this.eig.getPageContext(), this.eoS.euI);
                this.eqQ.gY(5000);
            }
            this.eqQ.f(this.eig.getResources().getString(w.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }
}
