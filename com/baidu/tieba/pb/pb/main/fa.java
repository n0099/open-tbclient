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
public class fa {
    private com.baidu.tbadk.editortools.j Ll;
    private View aEX;
    private int aMW;
    private boolean ais;
    private ab.b ala;
    private TextView avn;
    private NoNetworkView bEy;
    private View bHk;
    private View.OnClickListener bOI;
    private ViewStub bbh;
    private TbImageView bbi;
    private RelativeLayout dWm;
    private View.OnClickListener eje;
    private com.baidu.tieba.pb.a.d ejf;
    private PbActivity eka;
    PbActivity.c elz;
    private PbFakeFloorModel emS;
    private com.baidu.tieba.pb.data.f ens;
    private int eqA;
    private int eqB;
    private FrameLayout eqD;
    private int eqE;
    private com.baidu.tieba.pb.video.d eqF;
    private com.baidu.tieba.pb.video.a eqH;
    private com.baidu.tieba.play.c eqI;
    private com.baidu.tieba.pb.video.b eqJ;
    private TextView eqK;
    public final com.baidu.tieba.pb.pb.main.view.f eqM;
    public com.baidu.tieba.pb.pb.main.view.d eqN;
    private ViewStub eqO;
    private ViewStub eqP;
    private List<com.baidu.tieba.pb.pb.main.view.a> eqQ;
    private View eqR;
    private LinearLayout eqV;
    private TextView eqW;
    private View eqX;
    private g eqY;
    private dk eqZ;
    public int eqy;
    private int eqz;
    private PbListView erD;
    private View erF;
    private ColumnLayout era;
    private ThreadSkinView erb;
    private TextView erc;
    private FrameLayout erd;
    private HeadPendantView ere;
    private HeadImageView erf;
    private ImageView erg;
    private ImageView erh;
    private UserIconBox eri;
    private UserIconBox erj;
    private View erk;
    private FloatingLayout erl;
    private EntelechyUserLikeButton erp;
    private ey erq;
    private LinearLayout err;
    private TextView ers;
    private TextView ert;
    private View eru;
    private View erv;
    private ObservedChangeLinearLayout erx;
    private cp ery;
    private Runnable esC;
    private Runnable esD;
    private FloatingLayout esE;
    private de esF;
    private com.baidu.tieba.d.a esG;
    private com.baidu.tieba.d.a esH;
    private View esP;
    private EntelechyUserLikeButton esQ;
    private ClickableHeaderImageView esR;
    private TbImageView esS;
    private FrameLayout esT;
    private TextView esU;
    private LinearLayout esV;
    private boolean esW;
    private f esX;
    private com.baidu.tbadk.core.view.userLike.c esY;
    private com.baidu.tbadk.core.view.userLike.c esZ;
    private View esf;
    private TextView esg;
    private TextView esh;
    private ViewGroup esi;
    private TextView esj;
    private boolean esl;
    private PostData esn;
    private View esp;
    private TextView esq;
    private ViewStub esr;
    private PbInterviewStatusView ess;
    private TextView est;
    private Runnable ete;
    private PbActivity.a etg;
    private boolean eti;
    private boolean etj;
    private BdTypeListView mListView;
    private int mType;
    public static int esv = 2;
    public static int esw = 3;
    public static int esx = 0;
    public static int esy = 3;
    public static int esz = 4;
    public static int esA = 5;
    public static int esB = 6;
    private int eqC = 1;
    private boolean eqG = false;
    private int eqL = 0;
    private final Handler mHandler = new Handler();
    private View eqS = null;
    private LinearLayout eqT = null;
    private TextView eqU = null;
    private TextView erm = null;
    private TextView ern = null;
    public FrsPraiseView ero = null;
    private ClickableHeaderImageView epp = null;
    private View erw = null;
    private com.baidu.tbadk.core.dialog.a erz = null;
    private com.baidu.tbadk.core.dialog.c bOz = null;
    private View erA = null;
    private EditText erB = null;
    private com.baidu.tieba.pb.view.m erC = null;
    private com.baidu.tieba.pb.view.b erE = null;
    private c.b cZM = null;
    private TbRichTextView.e aNu = null;
    private NoNetworkView.a bMe = null;
    private Dialog erG = null;
    private View erH = null;
    private com.baidu.tbadk.core.dialog.a erI = null;
    private Dialog erJ = null;
    private View erK = null;
    private int erL = 0;
    private RadioGroup erM = null;
    private RadioButton erN = null;
    private RadioButton erO = null;
    private RadioButton erP = null;
    private Button erQ = null;
    private Button erR = null;
    private TextView erS = null;
    private Dialog erT = null;
    private View erU = null;
    private LinearLayout erV = null;
    private CompoundButton.OnCheckedChangeListener erW = null;
    private TextView erX = null;
    private TextView erY = null;
    private String erZ = null;
    private com.baidu.tbadk.core.dialog.c esa = null;
    private boolean esb = false;
    private boolean esc = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView esd = null;
    private boolean dqK = false;
    private Button ese = null;
    private boolean esk = true;
    private com.baidu.tbadk.core.view.a esm = null;
    private boolean eja = false;
    private int mSkinType = 3;
    private boolean eso = false;
    private boolean mIsFromCDN = true;
    private int esu = 0;
    private a.InterfaceC0073a esI = new fb(this);
    private boolean esJ = false;
    private boolean ekG = false;
    private boolean esK = false;
    private LinearLayout esL = null;
    private TextView esM = null;
    private int esN = 0;
    private boolean esO = false;
    private boolean eta = false;
    private int rank = 0;
    private boolean etb = false;
    private Animation.AnimationListener dyu = new fl(this);
    private Handler etd = new Handler();
    private CustomMessageListener etf = new fu(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eth = true;
    private boolean etk = false;
    private boolean YR = false;
    String userId = null;
    private final List<TbImageView> etl = new ArrayList();
    private boolean etm = false;
    private Runnable bQQ = new gf(this);

    public f aMF() {
        return this.esX;
    }

    public NoNetworkView aMG() {
        return this.bEy;
    }

    public boolean isFullScreen() {
        return this.ekG;
    }

    public void aMH() {
        if (this.Ll != null) {
            this.Ll.hide();
        }
    }

    public PbFakeFloorModel aMI() {
        return this.emS;
    }

    public de aMJ() {
        return this.esF;
    }

    public void aMK() {
        reset();
        this.esk = true;
        if (this.Ll != null) {
            this.Ll.hide();
        }
        this.esF.aLc();
        if (this.esf != null) {
            if (this.dqK) {
                gD(false);
            } else {
                gE(false);
            }
        }
        aLp();
    }

    private void reset() {
        if (this.eka != null && this.eka.aKf() != null && this.Ll != null) {
            com.baidu.tbadk.editortools.pb.a.Dm().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aKf = this.eka.aKf();
            aKf.DG();
            if (aKf.getWriteImagesInfo() != null) {
                aKf.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aKf.eH(10);
            aKf.eF(SendView.ALL);
            aKf.eG(SendView.ALL);
            com.baidu.tbadk.editortools.p ew = this.Ll.ew(23);
            com.baidu.tbadk.editortools.p ew2 = this.Ll.ew(2);
            com.baidu.tbadk.editortools.p ew3 = this.Ll.ew(5);
            if (ew2 != null) {
                ew2.ml();
            }
            if (ew3 != null) {
                ew3.ml();
            }
            if (ew != null) {
                ew.hide();
            }
            this.Ll.invalidate();
        }
    }

    public boolean aML() {
        return this.esk;
    }

    public void gD(boolean z) {
        if (this.esf != null && this.esg != null && this.esh != null) {
            this.esg.setText(w.l.draft_to_send);
            this.esh.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.esf.startAnimation(alphaAnimation);
            }
            this.esf.setVisibility(0);
        }
    }

    public void gE(boolean z) {
        if (this.esf != null && this.esg != null && this.esh != null) {
            this.esg.setText(w.l.reply_floor_host);
            this.esh.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.esf.startAnimation(alphaAnimation);
            }
            this.esf.setVisibility(0);
        }
    }

    public PostData aMM() {
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
        if (this.ery.og(headerViewsCount) != null && this.ery.og(headerViewsCount) != PostData.fug) {
            i2 = headerViewsCount + 1;
        }
        return (PostData) this.ery.getItem(i2);
    }

    public fa(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.aMW = 0;
        this.eqz = 0;
        this.eqA = 0;
        this.eqB = 0;
        this.eka = null;
        this.dWm = null;
        this.bHk = null;
        this.mListView = null;
        this.eqR = null;
        this.eqV = null;
        this.eqW = null;
        this.eqX = null;
        this.era = null;
        this.erc = null;
        this.erd = null;
        this.ere = null;
        this.erf = null;
        this.erg = null;
        this.erh = null;
        this.eri = null;
        this.erj = null;
        this.erk = null;
        this.erp = null;
        this.eru = null;
        this.erv = null;
        this.ery = null;
        this.erD = null;
        this.aEX = null;
        this.bOI = null;
        this.eje = null;
        this.esf = null;
        this.esg = null;
        this.esi = null;
        this.esj = null;
        this.esp = null;
        this.esq = null;
        this.esr = null;
        this.eka = pbActivity;
        this.bOI = onClickListener;
        this.ejf = dVar;
        this.dWm = (RelativeLayout) LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.new_pb_activity, (ViewGroup) null);
        this.eka.addContentView(this.dWm, new FrameLayout.LayoutParams(-1, -1));
        this.bHk = this.eka.findViewById(w.h.statebar_view);
        this.erx = (ObservedChangeLinearLayout) this.eka.findViewById(w.h.title_wrapper);
        this.bEy = (NoNetworkView) this.eka.findViewById(w.h.view_no_network);
        this.mListView = (BdTypeListView) this.eka.findViewById(w.h.new_pb_list);
        this.avn = new TextView(this.eka.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eka.getActivity(), w.f.ds98));
        this.mListView.addHeaderView(this.avn, 0);
        View view = new View(this.eka.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eka.getResources().getDimensionPixelSize(w.f.ds100)));
        view.setVisibility(4);
        this.mListView.addFooterView(view);
        this.mListView.setOnTouchListener(this.eka.aNR);
        this.eqM = new com.baidu.tieba.pb.pb.main.view.f(pbActivity);
        this.esG = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.eqM.eue);
        this.esG.gW(3);
        this.eqZ = new dk(this.eka, this.dWm);
        this.eqZ.init();
        this.eqZ.a(this.eqZ.aLq(), this.bOI);
        if (this.eka.aKC()) {
            this.eqO = (ViewStub) this.eka.findViewById(w.h.manga_view_stub);
            this.eqO.setVisibility(0);
            this.eqN = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
            this.eqN.show();
            this.eqM.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.avn.setLayoutParams(layoutParams);
        this.eqM.aNO().setOnTouchListener(new com.baidu.tieba.pb.a.a(new gg(this)));
        this.esf = this.eka.findViewById(w.h.pb_editor_tool_comment);
        this.esg = (TextView) this.eka.findViewById(w.h.pb_editor_tool_comment_reply_text);
        this.esi = (ViewGroup) this.eka.findViewById(w.h.pb_editor_tool_comment_reply_layout);
        this.esj = (TextView) this.eka.findViewById(w.h.pb_editor_tool_comment_praise_icon);
        boolean an = com.baidu.tieba.graffiti.c.an(this.esj);
        if (an) {
            iN(an);
            this.esj.setVisibility(0);
        }
        this.esh = (TextView) this.eka.findViewById(w.h.pb_editor_tool_comment_reply_count_text);
        this.esi.setOnClickListener(new gh(this));
        this.esj.setOnClickListener(this.bOI);
        this.esj.setOnTouchListener(this.eka);
        this.eqR = LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_item, (ViewGroup) null);
        this.eqV = (LinearLayout) LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_user_item, (ViewGroup) null);
        this.eqY = new g(this.eka, this.eqV);
        this.eqY.init();
        this.eqY.a(this.eqY.aKe(), this.bOI);
        this.era = (ColumnLayout) this.eqV.findViewById(w.h.pb_head_owner_root);
        this.esE = (FloatingLayout) this.eqV.findViewById(w.h.pb_head_owner_info_root);
        this.erb = (ThreadSkinView) this.eqV.findViewById(w.h.pb_thread_skin);
        this.era.setOnLongClickListener(this.onLongClickListener);
        this.era.setOnTouchListener(this.ejf);
        this.era.setVisibility(8);
        this.eqR.setOnTouchListener(this.ejf);
        this.esp = this.eqR.findViewById(w.h.pb_head_activity_join_number_container);
        this.esp.setVisibility(8);
        this.esq = (TextView) this.eqR.findViewById(w.h.pb_head_activity_join_number);
        this.erc = (TextView) this.era.findViewById(w.h.pb_head_owner_info_user_name);
        this.erd = (FrameLayout) this.era.findViewById(w.h.pb_head_headImage_container);
        this.erf = (HeadImageView) this.era.findViewById(w.h.pb_head_owner_photo);
        this.ere = (HeadPendantView) this.era.findViewById(w.h.pb_pendant_head_owner_photo);
        this.bbh = (ViewStub) this.era.findViewById(w.h.viewstub_headimage_mask);
        this.ere.wp();
        if (this.ere.getHeadView() != null) {
            this.ere.getHeadView().setIsRound(true);
            this.ere.getHeadView().setDrawBorder(false);
        }
        if (this.ere.getPendantView() != null) {
            this.ere.getPendantView().setIsRound(true);
            this.ere.getPendantView().setDrawBorder(false);
        }
        this.erg = (ImageView) this.era.findViewById(w.h.pb_head_owner_info_user_rank);
        this.erh = (ImageView) this.era.findViewById(w.h.pb_head_owner_info_user_bawu);
        this.eri = (UserIconBox) this.era.findViewById(w.h.pb_head_owner_info_user_icon);
        this.erj = (UserIconBox) this.era.findViewById(w.h.pb_head_owner_info_tshow_icon);
        this.erl = (FloatingLayout) this.eqV.findViewById(w.h.pb_head_owner_info_root);
        this.erp = (EntelechyUserLikeButton) this.era.findViewById(w.h.pb_like_button);
        this.erq = new ey(pbActivity.getPageContext(), this.erp);
        this.esY = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.esZ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eru = this.eqR.findViewById(w.h.new_pb_header_item_line_above_livepost);
        this.eqX = LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.layout_read_thread, (ViewGroup) null);
        this.eqW = (TextView) this.eqX.findViewById(w.h.pb_head_read_button);
        this.eqV.addView(this.eqX);
        this.eqW.setOnClickListener(this.bOI);
        this.eqB = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds2);
        this.eqA = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds18);
        this.eqz = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);
        this.aMW = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds32);
        this.erv = this.eqR.findViewById(w.h.new_pb_header_item_line_below_livepost);
        this.eqR.setOnLongClickListener(new gi(this));
        this.esr = (ViewStub) this.dWm.findViewById(w.h.interview_status_stub);
        this.ery = new cp(this.eka, this.mListView);
        this.ery.u(this.bOI);
        this.ery.a(this.ejf);
        this.ery.setOnImageClickListener(this.aNu);
        this.eje = new gj(this);
        this.ery.G(this.eje);
        aMP();
        this.mListView.addHeaderView(this.eqT);
        this.mListView.addHeaderView(this.eqV);
        this.mListView.addHeaderView(this.eqR);
        this.erD = new PbListView(this.eka.getPageContext().getPageActivity());
        this.aEX = this.erD.getView().findViewById(w.h.pb_more_view);
        if (this.aEX != null) {
            this.aEX.setOnClickListener(this.bOI);
            com.baidu.tbadk.core.util.aq.j(this.aEX, w.g.pb_foot_more_trans_selector);
        }
        this.erD.wA();
        this.erD.df(w.g.pb_foot_more_trans_selector);
        this.erD.dg(w.g.pb_foot_more_trans_selector);
        this.erF = this.eka.findViewById(w.h.viewstub_progress);
        this.eka.registerListener(this.etf);
        this.erk = com.baidu.tbadk.ala.c.nD().h(this.eka.getActivity(), 2);
        if (this.erk != null) {
            this.erk.setVisibility(8);
            this.erl.addView(this.erk, 2);
        }
        this.emS = new PbFakeFloorModel(this.eka.getPageContext());
        this.esF = new de(this.eka.getPageContext(), this.emS, this.dWm);
        this.emS.a(new gk(this));
    }

    public void aMN() {
        if (this.mListView != null) {
            this.mListView.removeHeaderView(this.eqT);
            this.mListView.removeHeaderView(this.eqV);
            this.mListView.removeHeaderView(this.eqR);
        }
    }

    private boolean j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aJq() == null || !fVar.aJJ() || !TbadkCoreApplication.m9getInst().isTTSCanUse() || fVar.aJq().rO() == 1 || fVar.aJq().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aJq().rQ() == null || fVar.aJq().rQ().tf() == 0) && !fVar.aJq().sI()) {
            BdUniqueId type = fVar.aJq().getType();
            return type == com.baidu.tbadk.core.data.bj.XK || type == com.baidu.tbadk.core.data.bj.XL || type == com.baidu.tbadk.core.data.bj.XJ;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.eqX != null) {
            if (!z) {
                this.eqX.setVisibility(8);
            } else if (!j(fVar)) {
                this.eqX.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aJs() != null && fVar.aJs().size() > 0) {
                    postData = fVar.aJs().get(0);
                }
                if (postData != null && postData.bhD() == 1) {
                    q(this.aMW, this.eqA, this.aMW, this.eqB);
                } else {
                    q(this.aMW, this.eqA, this.aMW, this.eqz);
                }
                this.eqX.setVisibility(0);
            }
        }
    }

    private void q(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eqW.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.eqW.setLayoutParams(layoutParams);
    }

    public TextView aMO() {
        return this.eqW;
    }

    private void aMP() {
        if (this.eqT == null) {
            int g = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds32);
            int g2 = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds40);
            this.eqT = new LinearLayout(this.eka.getPageContext().getPageActivity());
            this.eqT.setOrientation(1);
            this.eqT.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eqT.setPadding(0, g2, 0, g2);
            this.eqT.setGravity(17);
            this.eqU = new TextView(this.eka.getPageContext().getPageActivity());
            this.eqU.setGravity(3);
            this.eqU.setMaxLines(2);
            this.eqU.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.eqU.setPadding(g, 0, g, 0);
            com.baidu.tbadk.core.util.aq.i((View) this.eqU, w.e.cp_cont_b);
            this.eqU.setTextSize(0, g2);
            this.eqU.setVisibility(8);
            this.eqT.addView(this.eqU);
            this.eqT.setOnTouchListener(this.ejf);
            this.eqT.setOnLongClickListener(new fc(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMQ() {
        if (this.eka.aKC()) {
            this.eqP = (ViewStub) this.eka.findViewById(w.h.manga_mention_controller_view_stub);
            this.eqP.setVisibility(0);
            if (this.err == null) {
                this.err = (LinearLayout) this.eka.findViewById(w.h.manga_controller_layout);
                com.baidu.tbadk.i.a.a(this.eka.getPageContext(), this.err);
            }
            if (this.ers == null) {
                this.ers = (TextView) this.err.findViewById(w.h.manga_prev_btn);
            }
            if (this.ert == null) {
                this.ert = (TextView) this.err.findViewById(w.h.manga_next_btn);
            }
            this.ers.setOnClickListener(this.bOI);
            this.ert.setOnClickListener(this.bOI);
        }
    }

    private void aMR() {
        if (this.eka.aKC()) {
            if (this.eka.aKF() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.ers, w.e.cp_cont_e, 1);
            }
            if (this.eka.aKG() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.ert, w.e.cp_cont_e, 1);
            }
        }
    }

    public void aMS() {
        if (this.err == null) {
            aMQ();
        }
        this.eqP.setVisibility(8);
        if (this.etd != null && this.ete != null) {
            this.etd.removeCallbacks(this.ete);
        }
    }

    public void aMT() {
        if (this.etd != null) {
            if (this.ete != null) {
                this.etd.removeCallbacks(this.ete);
            }
            this.ete = new fd(this);
            this.etd.postDelayed(this.ete, 2000L);
        }
    }

    public void iH(boolean z) {
        this.eqM.iH(z);
        if (z && this.eso) {
            this.erD.setText(this.eka.getResources().getString(w.l.click_load_more));
            this.mListView.setNextPage(this.erD);
            this.eqL = 2;
        }
    }

    public void aMU() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.dWm.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Ll = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dWm.addView(this.Ll, layoutParams);
        this.Ll.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.Ll.hide();
    }

    public void aMV() {
        if (this.eka != null && this.Ll != null) {
            this.Ll.ml();
        }
    }

    public void ny(String str) {
        if (this.esh != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.esh.setText(this.eka.getPageContext().getResources().getString(w.l.pb_reply_count_text, str));
        }
    }

    public void P(String str, boolean z) {
        this.esl = z;
        iI(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void iI(boolean z) {
        if (this.esj != null) {
            if (this.esl) {
                com.baidu.tbadk.core.util.aq.j(this.esj, w.g.pb_praise_already_click_selector);
                this.esj.setContentDescription(this.eka.getResources().getString(w.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aq.j(this.esj, w.g.pb_praise_normal_click_selector);
            this.esj.setContentDescription(this.eka.getResources().getString(w.l.frs_item_praise_text));
        }
    }

    public TextView aMW() {
        return this.esj;
    }

    public void iJ(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
                return;
            }
            if (this.esD == null) {
                this.esD = new fe(this, z);
            }
            com.baidu.adp.lib.g.h.fM().postDelayed(this.esD, 10L);
        }
    }

    public void iK(boolean z) {
        if (this.mListView != null && this.avn != null && this.bHk != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bHk.setVisibility(0);
                    aNm();
                } else {
                    this.bHk.setVisibility(8);
                    this.mListView.removeHeaderView(this.avn);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.avn.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.avn.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.avn.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + iS(true);
                this.avn.setLayoutParams(layoutParams2);
            }
            aNm();
            aNH();
        }
    }

    public void bb(View view) {
        boolean z;
        View view2;
        if (this.erx != null && view != null) {
            if (this.esk) {
                z = this.esf.getVisibility() == 0;
            } else {
                z = this.Ll != null && this.Ll.getVisibility() == 0;
            }
            boolean z2 = this.erx.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.ekG = true;
                View findViewById = this.eka.findViewById(w.h.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.erx.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.eka, this.erx, w.a.top_fold_up, new ff(this, findViewById));
            } else {
                this.ekG = false;
                com.baidu.tieba.tbadkCore.a.a(this.eka, this.erx, w.a.top_fold_down, new fg(this));
            }
            if (this.esk) {
                view2 = this.esf;
            } else {
                view2 = this.Ll;
            }
            if (z) {
                if (z2) {
                    if (this.Ll != null) {
                        this.Ll.Bd();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.eka, view2, w.a.bottom_fold_down, new fh(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.eka, view2, w.a.bottom_fold_up, new fi(this));
            }
            aLp();
        }
    }

    public cp aMX() {
        return this.ery;
    }

    public void aMY() {
        if (this.ery != null) {
            this.ery.aKT();
        }
    }

    public void a(PbActivity.c cVar) {
        this.elz = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bo boVar) {
        if (boVar == null || boVar.tf() == 0) {
            if (this.ese != null) {
                this.ese.setVisibility(8);
            }
            if (this.eru != null) {
                this.eru.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ese == null) {
            this.eka.getLayoutMode().t(((ViewStub) this.eqR.findViewById(w.h.live_talk_layout)).inflate());
            this.ese = (Button) this.eqR.findViewById(w.h.pb_head_function_manage_go_to_live_post);
            this.eru = this.eqR.findViewById(w.h.new_pb_header_item_line_above_livepost);
        }
        int tg = boVar.tg();
        String string = this.eka.getPageContext().getString(w.l.go_to_live_post_prefix);
        if (tg == 0) {
            string = String.valueOf(string) + this.eka.getPageContext().getString(w.l.go_to_interview_post);
        } else if (tg == 1) {
            string = String.valueOf(string) + this.eka.getPageContext().getString(w.l.go_to_discuss_post);
        }
        this.ese.setText(string);
        this.ese.setVisibility(0);
        this.ese.setOnClickListener(this.bOI);
        this.etj = true;
        aNn();
    }

    public void bc(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.erH == null) {
            this.erH = LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eka.getLayoutMode().t(this.erH);
        if (this.erG == null) {
            this.erG = new Dialog(this.eka.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.erG.setCanceledOnTouchOutside(true);
            this.erG.setCancelable(true);
            this.erG.setContentView(this.erH);
            WindowManager.LayoutParams attributes = this.erG.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.ag(this.eka.getPageContext().getPageActivity()) * 0.9d);
            this.erG.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.erG.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.erG.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.erG.findViewById(w.h.disable_reply_btn);
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
            textView.setOnClickListener(new fj(this));
        }
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name)) || aND()) {
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
            textView2.setOnClickListener(new fk(this));
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
            textView3.setOnClickListener(new fm(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.erG, this.eka.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.etg = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(esx, Integer.valueOf(esy));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.erI = new com.baidu.tbadk.core.dialog.a(this.eka.getActivity());
        this.erI.bW(i3);
        this.erI.A(sparseArray);
        this.erI.a(w.l.dialog_ok, this.eka);
        this.erI.b(w.l.dialog_cancel, new fn(this));
        this.erI.at(true);
        this.erI.b(this.eka.getPageContext());
        this.erI.ts();
    }

    public void al(ArrayList<com.baidu.tbadk.core.data.ae> arrayList) {
        if (this.erU == null) {
            this.erU = LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.commit_good, (ViewGroup) null);
        }
        this.eka.getLayoutMode().t(this.erU);
        if (this.erT == null) {
            this.erT = new Dialog(this.eka.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.erT.setCanceledOnTouchOutside(true);
            this.erT.setCancelable(true);
            this.esd = (ScrollView) this.erU.findViewById(w.h.good_scroll);
            this.erT.setContentView(this.erU);
            WindowManager.LayoutParams attributes = this.erT.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds540);
            this.erT.getWindow().setAttributes(attributes);
            this.erW = new fo(this);
            this.erV = (LinearLayout) this.erU.findViewById(w.h.good_class_group);
            this.erY = (TextView) this.erU.findViewById(w.h.dialog_button_cancel);
            this.erY.setOnClickListener(new fp(this));
            this.erX = (TextView) this.erU.findViewById(w.h.dialog_button_ok);
            this.erX.setOnClickListener(this.bOI);
        }
        this.erV.removeAllViews();
        this.eqQ = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bN = bN("0", this.eka.getPageContext().getString(w.l.def_good_class));
        this.eqQ.add(bN);
        bN.setChecked(true);
        this.erV.addView(bN);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bN2 = bN(String.valueOf(arrayList.get(i2).qo()), arrayList.get(i2).qn());
                this.eqQ.add(bN2);
                View view = new View(this.eka.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds1));
                com.baidu.tbadk.core.util.aq.k(view, w.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.erV.addView(view);
                this.erV.addView(bN2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.esd.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eka.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eka.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eka.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.esd.setLayoutParams(layoutParams2);
            this.esd.removeAllViews();
            this.esd.addView(this.erV);
        }
        com.baidu.adp.lib.g.j.a(this.erT, this.eka.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bN(String str, String str2) {
        Activity pageActivity = this.eka.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds100));
        aVar.setOnCheckedChangeListener(this.erW);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aMZ() {
        this.eka.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eka.hideProgressBar();
        if (z && z2) {
            this.eka.showToast(this.eka.getPageContext().getString(w.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(w.l.neterror);
            }
            this.eka.showToast(str);
        }
    }

    public void arz() {
        this.erF.setVisibility(0);
    }

    public void ary() {
        this.erF.setVisibility(8);
    }

    public View aNa() {
        if (this.erU != null) {
            return this.erU.findViewById(w.h.dialog_button_ok);
        }
        return null;
    }

    public String aNb() {
        return this.erZ;
    }

    public View getView() {
        return this.dWm;
    }

    public void aNc() {
        com.baidu.adp.lib.util.k.b(this.eka.getPageContext().getPageActivity(), this.eka.getCurrentFocus());
    }

    public void iL(boolean z) {
        this.eka.hideProgressBar();
        awO();
    }

    public void aNd() {
        this.erD.wH();
    }

    public void aNe() {
        this.eka.hideProgressBar();
        this.erD.wI();
        aIn();
        this.mListView.completePullRefreshPostDelayed(2000L);
        aNn();
    }

    public void aNf() {
        this.mListView.completePullRefreshPostDelayed(2000L);
        aNn();
    }

    public void iM(boolean z) {
        this.eqZ.f(this.eqZ.aLq(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.esi.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eka.getResources().getDimensionPixelSize(w.f.ds84) : 0;
        this.esi.setLayoutParams(marginLayoutParams);
    }

    private void iN(boolean z) {
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.esi.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.esi.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tbadk.core.data.ag agVar) {
        this.eqZ.b(agVar);
    }

    public boolean aLn() {
        return this.eqZ.aLn();
    }

    public void aLo() {
        this.eqZ.aLo();
    }

    public void aLp() {
        this.eqZ.aLp();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.ery.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.esa != null) {
            this.esa.dismiss();
            this.esa = null;
        }
        this.esa = new com.baidu.tbadk.core.dialog.c(this.eka.getPageContext().getPageActivity());
        this.esa.bZ(w.l.operation);
        if (z2) {
            this.esa.a(new String[]{this.eka.getPageContext().getString(w.l.copy)}, bVar);
        } else if (!z) {
            this.esa.a(new String[]{this.eka.getPageContext().getString(w.l.copy), this.eka.getPageContext().getString(w.l.mark)}, bVar);
        } else {
            this.esa.a(new String[]{this.eka.getPageContext().getString(w.l.copy), this.eka.getPageContext().getString(w.l.remove_mark)}, bVar);
        }
        this.esa.d(this.eka.getPageContext());
        this.esa.tv();
    }

    public int aNg() {
        return ou(this.mListView.getFirstVisiblePosition());
    }

    private int ou(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.mListView.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.lg()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.mListView.getAdapter() == null || !(this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aNh() {
        return ou(this.mListView.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.mListView.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.erB.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void k(com.baidu.tieba.pb.data.f fVar) {
        this.ery.b(fVar);
        this.ery.notifyDataSetChanged();
        if (fVar == null) {
            ny("");
        } else {
            ny(com.baidu.tbadk.core.util.au.w(fVar.aJq().rJ()));
        }
        aNn();
    }

    public void l(com.baidu.tieba.pb.data.f fVar) {
        PraiseData rG;
        if (this.ero == null) {
            this.eka.getLayoutMode().t(((ViewStub) this.eqR.findViewById(w.h.praise_layout)).inflate());
            this.ero = (FrsPraiseView) this.eqR.findViewById(w.h.pb_head_praise_view);
            this.ero.setIsFromPb(true);
            this.erw = this.eqR.findViewById(w.h.new_pb_header_item_line_above_praise);
            this.ero.dl(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.ero != null) {
            boolean aNn = aNn();
            if (fVar != null && fVar.aJs() != null && fVar.aJs().size() > 0) {
                PostData postData = fVar.aJs().get(0);
                if ((!this.eja || postData.bhD() != 1) && (rG = fVar.aJq().rG()) != null && rG.getUser() != null && rG.getUser().size() > 0) {
                    this.ero.setVisibility(0);
                    this.ero.setIsFromPb(true);
                    this.ero.a(rG, fVar.aJq().getId(), rG.getPostId(), true);
                    this.ero.getVisibility();
                    com.baidu.tieba.graffiti.c.an(this.ero);
                    return;
                }
            }
            this.ero.setVisibility(8);
            if (fVar != null && fVar.getPage() != null && fVar.getPage().qR() == 0 && this.eja) {
                if (aNn) {
                    this.erv.setVisibility(0);
                } else {
                    this.erv.setVisibility(8);
                }
            } else {
                this.erv.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.an(this.erv);
        }
    }

    private PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aJz() != null) {
            return fVar.aJz();
        }
        if (z) {
            if (fVar == null || fVar.aJs() == null || fVar.aJs().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aJs().get(0);
            if (postData.bhD() != 1) {
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
        if (fVar == null || fVar.aJq() == null || fVar.aJq().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aJq().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aJq().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.rU(1);
        postData.setId(fVar.aJq().sg());
        postData.setTitle(fVar.aJq().getTitle());
        postData.setTime(fVar.aJq().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        boolean z2;
        int i2;
        if (fVar != null && fVar.aJq() != null) {
            this.esE.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds30), 0, 0);
            PostData c = c(fVar, z);
            a(c, fVar);
            aNE();
            this.era.setVisibility(8);
            if (fVar.aJq() != null && fVar.aJq().sD() && fVar.aJq().sh() != null) {
                this.eqM.iX(true);
                if (this.eqF == null || this.eqI == null) {
                    aNi();
                    this.eqF.a(fVar.aJq().sh(), fVar.aJq(), fVar.getForumId());
                    this.eqF.startPlay();
                } else if (this.eqG) {
                    this.eqF.a(fVar.aJq().sh(), fVar.aJq(), fVar.getForumId());
                    this.eqF.startPlay();
                }
                if (fVar.aJr() != null && fVar.aJr().size() >= 1) {
                    com.baidu.tbadk.core.data.bj bjVar = fVar.aJr().get(0);
                    this.eqF.J(bjVar);
                    this.eqF.nO(bjVar.getTitle());
                }
                this.eqG = false;
                if (this.est == null) {
                    this.est = new TextView(this.eka.getActivity());
                    this.est.setLayoutParams(new AbsListView.LayoutParams(-1, this.eqE));
                }
                this.mListView.removeHeaderView(this.est);
                this.mListView.addHeaderView(this.est, 0);
                if (this.eqH == null) {
                    this.eqH = new com.baidu.tieba.pb.video.a(LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.pb_header_video_abstract_layout, (ViewGroup) null));
                }
                this.eqH.I(fVar.aJq());
                this.mListView.removeHeaderView(this.eqH.mRootView);
                this.mListView.addHeaderView(this.eqH.mRootView, 1);
                if (fVar.aJq().sU() != null) {
                    m(fVar);
                    this.mListView.removeHeaderView(this.eqJ.mRootView);
                    this.mListView.removeHeaderView(this.eqV);
                    this.mListView.addHeaderView(this.eqJ.mRootView, 2);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eqH.eww.getLayoutParams();
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds26);
                    this.eqH.eww.setLayoutParams(layoutParams);
                } else {
                    if (this.eqJ != null && this.eqJ.mRootView != null) {
                        this.mListView.removeHeaderView(this.eqJ.mRootView);
                    }
                    if (com.baidu.adp.lib.b.e.eT().ab("video_channel_pb_portrait_switch") == 0) {
                        h(c);
                        this.mListView.removeHeaderView(this.eqV);
                        this.mListView.removeHeaderView(this.eqK);
                        this.mListView.addHeaderView(this.eqK, 2);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eqH.eww.getLayoutParams();
                        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds30);
                        this.eqH.eww.setLayoutParams(layoutParams2);
                    } else {
                        aNj();
                        if (this.eqK != null) {
                            this.mListView.removeHeaderView(this.eqK);
                        }
                        this.mListView.removeHeaderView(this.eqV);
                        this.mListView.addHeaderView(this.eqV, 2);
                    }
                }
                if (this.eqF != null) {
                    this.eqF.ox(0);
                }
                aNm();
                z2 = true;
            } else {
                this.eqM.iX(false);
                if (this.eqD != null) {
                    this.eqD.setVisibility(8);
                }
                if (this.est != null) {
                    this.mListView.removeHeaderView(this.est);
                }
                if (this.eqH != null) {
                    this.mListView.removeHeaderView(this.eqH.mRootView);
                }
                if (this.eqJ != null) {
                    this.mListView.removeHeaderView(this.eqJ.mRootView);
                }
                z2 = false;
            }
            if (this.eka.aKi() != null) {
                this.eka.aKi().iV(z2);
            }
            fq fqVar = new fq(this, z2);
            if (this.eqK != null) {
                this.eqK.setOnClickListener(fqVar);
            }
            b(fVar, z);
            if (c != null) {
                this.esn = c;
                String str = null;
                boolean z3 = false;
                if (fVar != null && fVar.aJq() != null && fVar.aJq().getAuthor() != null) {
                    str = fVar.aJq().getAuthor().getUserId();
                    if (fVar.getPage() != null) {
                        this.esN = fVar.getPage().qN();
                        z3 = fVar.getPage().qQ() == 1;
                    }
                }
                boolean sC = fVar.aJq().sC();
                if (c.getAuthor() != null && c.getAuthor().getUserTbVipInfoData() != null) {
                    this.ais = !StringUtils.isNull(c.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.esJ = !sC && a(fVar, c, fVar.aJq().getId(), str, z3, z);
                this.era.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.era.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.era.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_clip_board, c);
                sparseArray.put(w.h.tag_is_subpb, false);
                fVar.aJq().sz();
                if (!this.esW) {
                    this.eqT.setVisibility(0);
                }
                if (!fVar.aJq().sD() && this.eqU.getText() != null && this.eqU.getText().length() > 0) {
                    this.eqU.setVisibility(0);
                } else {
                    this.eqU.setVisibility(8);
                }
                l(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> sb = fVar.aJq().sb();
                if (sb != null && sb.size() > 0 && !this.esW) {
                    this.esq.setText(String.valueOf(sb.get(0).pk()));
                    this.esp.setVisibility(0);
                    this.eti = true;
                } else {
                    this.esp.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.j(this.esp, w.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aq.c(this.esq, w.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    int is_bawu = c.getAuthor().getIs_bawu();
                    String bawu_type = c.getAuthor().getBawu_type();
                    int i3 = 3;
                    if (this.rank != 0) {
                        this.erg.setVisibility(0);
                        com.baidu.tbadk.core.util.aq.c(this.erg, BitmapHelper.getGradeResourceIdNew(this.rank));
                        this.erg.setAlpha(179);
                        this.erg.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.rank)));
                        this.erg.setOnClickListener(null);
                    } else {
                        this.erg.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.erh.setAlpha(179);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.aq.c(this.erh, w.g.pb_manager);
                            this.erg.setVisibility(8);
                            this.erh.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.aq.c(this.erh, w.g.pb_assist);
                            this.erg.setVisibility(8);
                            this.erh.setVisibility(0);
                        }
                    }
                    String string = c.getAuthor().getName_show() == null ? StringUtils.string(c.getAuthor().getUserName()) : StringUtils.string(c.getAuthor().getName_show());
                    if (StringUtils.isNull(c.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aK(c.getAuthor().getSealPrefix()) + 2;
                    }
                    if (!StringUtils.isNull(string)) {
                        int aK = com.baidu.adp.lib.util.j.aK(c.getAuthor().getName_show());
                        if (aK + i2 > 14) {
                            i3 = 0;
                        } else if (aK + i2 >= 12) {
                            i3 = 1;
                        } else if (aK + i2 >= 10) {
                            i3 = 2;
                            if (is_bawu == 0) {
                                i3 = 1;
                            }
                        }
                    }
                    ArrayList<IconData> iconInfo = c.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = c.getAuthor().getTShowInfoNew();
                    if (this.eri != null) {
                        this.eri.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.eri.setOnClickListener(this.eka.ekN.bWQ);
                        this.eri.wV();
                        this.eri.a(iconInfo, i3, this.eka.getResources().getDimensionPixelSize(w.f.ds30), this.eka.getResources().getDimensionPixelSize(w.f.ds30), this.eka.getResources().getDimensionPixelSize(w.f.ds10));
                    }
                    if (this.erj != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.erj.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.erj.setOnClickListener(this.eka.ekN.etG);
                        this.erj.a(tShowInfoNew, 3, this.eka.getResources().getDimensionPixelSize(w.f.ds32), this.eka.getResources().getDimensionPixelSize(w.f.ds32), this.eka.getResources().getDimensionPixelSize(w.f.ds8), true);
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aK(string) > 12) {
                            string = com.baidu.tbadk.core.util.au.d(string, 12, "...");
                        }
                    } else if (com.baidu.adp.lib.util.j.aK(string) > 14) {
                        string = com.baidu.tbadk.core.util.au.d(string, 14, "...");
                    }
                    this.erc.setText(ae(c.getAuthor().getSealPrefix(), string));
                    this.erc.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                    this.erc.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                    if (!com.baidu.tbadk.core.util.x.q(tShowInfoNew)) {
                        com.baidu.tbadk.core.util.aq.c(this.erc, w.e.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.aq.c(this.erc, w.e.cp_cont_f, 1);
                    }
                    if (fVar.aJq().getAuthor() != null && fVar.aJq().getAuthor().getAlaUserData() != null && this.erk != null) {
                        if (fVar.aJq().getAuthor().getAlaUserData().anchor_live == 0 && fVar.aJq().getAuthor().getAlaUserData().enter_live == 0) {
                            this.erk.setVisibility(8);
                        } else {
                            this.erk.setVisibility(0);
                            com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                            bVar.Qx = fVar.aJq().getAuthor().getAlaUserData();
                            bVar.type = 2;
                            this.erk.setTag(bVar);
                        }
                    }
                    this.erf.setUserId(c.getAuthor().getUserId());
                    this.erf.setUserName(c.getAuthor().getUserName());
                    this.erf.setImageDrawable(null);
                    this.erf.setRadius(com.baidu.adp.lib.util.k.g(this.eka.getActivity(), w.f.ds40));
                    this.erf.setTag(c.getAuthor().getUserId());
                    this.erq.a(c.getAuthor());
                    this.erq.eqx = z2;
                    if (!PbNormalLikeButtonSwitchStatic.GB() || this.esc || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.erp.setVisibility(8);
                    } else {
                        this.erp.setVisibility(0);
                    }
                    String portrait = c.getAuthor().getPortrait();
                    if (c.getAuthor() != null && c.getAuthor().getPendantData() != null && !StringUtils.isNull(c.getAuthor().getPendantData().qd())) {
                        this.erf.setVisibility(8);
                        this.ere.setVisibility(0);
                        if (this.epp != null) {
                            this.epp.setVisibility(8);
                        }
                        this.erc.setOnClickListener(fqVar);
                        this.ere.getHeadView().c(portrait, 28, false);
                        this.ere.getHeadView().setUserId(c.getAuthor().getUserId());
                        this.ere.getHeadView().setUserName(c.getAuthor().getUserName());
                        this.ere.getHeadView().setOnClickListener(fqVar);
                        this.ere.dO(c.getAuthor().getPendantData().qd());
                    } else if (this.ais) {
                        this.erf.setVisibility(0);
                        UserTbVipInfoData userTbVipInfoData = c.getAuthor().getUserTbVipInfoData();
                        if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.bbh != null) {
                            if (this.bbi == null) {
                                this.bbh.inflate();
                                this.bbi = (TbImageView) this.eqV.findViewById(w.h.user_head_mask);
                            }
                            this.bbi.c(userTbVipInfoData.getvipV_url(), 10, false);
                        }
                        this.erc.setOnClickListener(fqVar);
                        this.erf.setOnClickListener(fqVar);
                        this.ere.setVisibility(8);
                    } else {
                        if (this.esJ) {
                            fr frVar = new fr(this, c, z2);
                            if (this.eqK != null) {
                                this.eqK.setOnClickListener(frVar);
                            }
                            this.erc.setOnClickListener(frVar);
                            this.erf.setOnClickListener(frVar);
                            this.era.setOnClickListener(frVar);
                            this.erf.setVisibility(8);
                            this.ere.setVisibility(8);
                        } else {
                            this.erf.setVisibility(0);
                            this.era.setOnClickListener(fqVar);
                            this.erc.setOnClickListener(fqVar);
                            this.erf.setOnClickListener(fqVar);
                        }
                        this.ere.setVisibility(8);
                    }
                    this.erf.c(portrait, 28, false);
                }
                if (fVar != null) {
                    this.eqY.G(fVar.aJq());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.sl() != null) {
            this.erb.a(this.eka.getPageContext(), fVar.aJs().get(0).sl(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aJp().getId(), fVar.aJp().getName(), fVar.aJq().getId(), this.eka.aKM() ? "FRS" : null));
            this.era.setPadding(this.era.getPaddingLeft(), (int) this.eka.getResources().getDimension(w.f.ds20), this.era.getPaddingRight(), this.era.getPaddingBottom());
            return;
        }
        this.erb.a(null, null, null);
    }

    private void aNi() {
        this.eqD = (FrameLayout) this.eka.findViewById(w.h.root_float_header);
        int ag = com.baidu.adp.lib.util.k.ag(this.eka.getActivity());
        int i = (int) (ag * 0.5625d);
        this.eqE = i;
        this.eqD.setLayoutParams(new RelativeLayout.LayoutParams(ag, i));
        this.eqI = new com.baidu.tieba.play.c(this.eka.getPageContext(), this.eqD);
        this.eqF = new com.baidu.tieba.pb.video.d(this.eka, this.eqI, this.eqD, this.eqM, this.eqE);
    }

    private void m(com.baidu.tieba.pb.data.f fVar) {
        if (this.eqJ == null) {
            this.eqJ = new com.baidu.tieba.pb.video.b(this.eka, LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.video_pb_video_channel_info_layout, (ViewGroup) null));
        }
        com.baidu.tbadk.core.data.bq sU = fVar.aJq().sU();
        if (fVar.getUserData() != null) {
            sU.ZH = fVar.aJI();
        }
        this.eqJ.b(sU);
        fVar.aJq().a(sU);
    }

    private void h(PostData postData) {
        if (this.eqK == null) {
            this.eqK = new TextView(this.eka.getActivity());
            this.eqK.setClickable(true);
            this.eqK.setTextSize(0, this.eka.getResources().getDimensionPixelSize(w.f.fontsize24));
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            this.eqK.setSingleLine(true);
            this.eqK.setEllipsize(TextUtils.TruncateAt.END);
            this.eqK.setLayoutParams(layoutParams);
            this.eqK.setGravity(16);
            int g = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds32);
            this.eqK.setPadding(g, 0, g, com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds40));
            com.baidu.tbadk.core.util.aq.c(this.eqK, w.e.cp_cont_j, 1);
        }
        String string = this.eka.getResources().getString(w.l.video_public_owner);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        if (postData != null && postData.getAuthor() != null) {
            String name_show = postData.getAuthor().getName_show();
            this.eqK.setTag(w.h.tag_user_id, String.valueOf(postData.getAuthor().getUserId()));
            this.eqK.setTag(w.h.tag_user_name, name_show);
            sb.append(" " + name_show);
            SpannableString spannableString = new SpannableString(sb);
            spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), string.length(), sb.length(), 33);
            this.eqK.setText(spannableString);
            return;
        }
        this.eqK.setText(string);
    }

    private void aNj() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eqH.eww.getLayoutParams();
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds26);
        this.eqH.eww.setLayoutParams(layoutParams);
        this.era.setPadding(this.era.getPaddingLeft(), this.era.getPaddingTop(), this.era.getPaddingRight(), com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds34));
        if (this.erp.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.erp.getLayoutParams();
            aVar.bottomMargin = com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds20);
            this.erp.setLayoutParams(aVar);
        }
    }

    public void aNk() {
        if (this.eqF != null) {
            this.eqF.aPh();
        }
    }

    public boolean aNl() {
        return this.etk;
    }

    private boolean Nj() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean C(com.baidu.tbadk.core.data.bj bjVar) {
        if (bjVar == null || bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.eqM.aNS();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eqM.li(eVar.forumName);
                if (this.eqF != null) {
                    this.eqF.aPb();
                }
            }
            String string = this.eka.getResources().getString(w.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eka.getResources().getString(w.l.self);
                    break;
                case 300:
                    str = this.eka.getResources().getString(w.l.bawu);
                    break;
                case 400:
                    str = this.eka.getResources().getString(w.l.system);
                    break;
            }
            this.eka.showNetRefreshView(this.dWm, String.format(string, str), null, this.eka.getResources().getString(w.l.appeal_restore), true, new fs(this, eVar.ehJ));
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aMC;
        String sb;
        if (fVar != null) {
            this.ens = fVar;
            this.mType = i;
            if (fVar.aJq() != null) {
                this.esu = fVar.aJq().rE();
                this.YR = fVar.aJq().rB();
                if (fVar.aJq().getAnchorLevel() != 0) {
                    this.etk = true;
                }
                this.esc = C(fVar.aJq());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            o(fVar);
            this.eso = false;
            this.eja = z;
            aNe();
            b(fVar, z, i);
            if (this.eka.aKC()) {
                if (this.erC == null) {
                    this.erC = new com.baidu.tieba.pb.view.m(this.eka.getPageContext());
                    this.erC.la();
                    this.erC.a(this.ala);
                }
                this.mListView.setPullRefresh(this.erC);
                aNm();
                if (this.erC != null) {
                    this.erC.dh(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (fVar.getPage().qR() == 0 && z) {
                this.mListView.setPullRefresh(null);
                this.eqC = 1;
            } else {
                if (this.erC == null) {
                    this.erC = new com.baidu.tieba.pb.view.m(this.eka.getPageContext());
                    this.erC.la();
                    this.erC.a(this.ala);
                }
                this.mListView.setPullRefresh(this.erC);
                aNm();
                this.eqC = 2;
                if (this.erC != null) {
                    this.erC.dh(TbadkCoreApplication.m9getInst().getSkinType());
                }
                aIn();
            }
            aNn();
            this.ery.ic(this.eja);
            this.ery.id(false);
            this.ery.b(fVar);
            this.ery.notifyDataSetChanged();
            if (fVar.aJp() != null) {
                this.mForumName = fVar.aJp().getName();
                this.mForumId = fVar.getForumId();
            }
            this.eqM.li(this.mForumName);
            if (this.eqF != null) {
                this.eqF.aPb();
            }
            if (fVar.aJq() != null) {
                ny(com.baidu.tbadk.core.util.au.w(fVar.aJq().rJ()));
                if (fVar.aJq().rG() != null) {
                    if (fVar.aJq().rG().getNum() < 1) {
                        sb = this.eka.getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(fVar.aJq().rG().getNum())).toString();
                    }
                    if (this.eqy != -1) {
                        fVar.aJq().rG().setIsLike(this.eqy);
                    }
                    P(sb, fVar.aJq().rG().getIsLike() == 1);
                }
            }
            if (fVar.getPage().qQ() == 0 && !z) {
                this.mListView.setNextPage(null);
                this.eqL = 1;
            } else if (this.eka.isLogin()) {
                this.mListView.setNextPage(this.erD);
                this.eqL = 2;
                aIn();
            } else if (fVar.getPage().qQ() == 1) {
                this.eso = true;
                if (this.erE == null) {
                    this.erE = new com.baidu.tieba.pb.view.b(this.eka.getPageContext());
                }
                this.mListView.setNextPage(this.erE);
                this.eqL = 3;
            }
            ArrayList<PostData> aJs = fVar.aJs();
            if (fVar.getPage().qQ() == 0 || aJs == null || aJs.size() < fVar.getPage().qP()) {
                this.erD.setText(this.eka.getResources().getString(w.l.list_no_more));
                if (this.eka.aKC() && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() == 1 && (this.mListView.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.erD.setText("");
                }
                aNs();
            } else if (z2) {
                if (this.eth) {
                    wI();
                    if (fVar.getPage().qQ() != 0) {
                        this.erD.setText(this.eka.getResources().getString(w.l.pb_load_more));
                    }
                } else {
                    this.erD.wK();
                }
            } else {
                this.erD.wK();
            }
            if (fVar.aJq() != null && fVar.aJq().getAuthor() != null && fVar.aJq().getAuthor().getType() == 0) {
                this.eqM.aNP();
            }
            switch (i) {
                case 2:
                    this.mListView.setSelection(i2 > 1 ? i2 - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aMC = er.aMB().aMC()) != null) {
                        this.eta = true;
                        this.mListView.onRestoreInstanceState(aMC);
                        break;
                    } else {
                        this.mListView.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.eth = false;
                    this.mListView.setSelection(0);
                    break;
                case 5:
                    this.mListView.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aMC2 = er.aMB().aMC();
                        this.eta = true;
                        if (aMC2 != null) {
                            this.mListView.onRestoreInstanceState(aMC2);
                            break;
                        }
                    }
                    this.mListView.setSelection(0);
                    break;
            }
            if (this.esu == esw && Nj()) {
                aNy();
            }
            if (!this.eta && fVar.aJz() == null && !fVar.aJq().sD()) {
                this.esG.aA(this.eka.getResources().getString(w.l.pb_more_tools_guide_tip), String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips");
                this.eta = true;
            }
            H(fVar.aJq());
            this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void aNm() {
        if (this.eqD != null) {
            this.mListView.removeHeaderView(this.avn);
            this.mListView.removeHeaderView(this.est);
            this.mListView.addHeaderView(this.est, 0);
            if (this.mType != 1 && this.eqF != null) {
                this.eqF.aPe();
                return;
            }
            return;
        }
        this.mListView.removeHeaderView(this.est);
        this.mListView.removeHeaderView(this.avn);
        this.mListView.addHeaderView(this.avn, 0);
    }

    public void iO(boolean z) {
        this.esb = z;
        this.eqM.iO(z);
    }

    public void wI() {
        if (this.erD != null) {
            this.erD.wI();
        }
        aIn();
    }

    public void Kz() {
        this.mListView.setVisibility(0);
    }

    private boolean aNn() {
        boolean z;
        if (this.ese != null && this.ese.getVisibility() == 0) {
            z = true;
            if (this.eru != null) {
                this.eru.setVisibility(0);
            }
        } else {
            if (this.eru != null) {
                this.eru.setVisibility(8);
            }
            z = false;
        }
        if ((this.erw == null || this.erw.getVisibility() == 8) && z && this.eja) {
            this.erv.setVisibility(0);
        } else {
            this.erv.setVisibility(8);
        }
        com.baidu.tieba.graffiti.c.an(this.erv);
        return z;
    }

    private boolean n(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aJq() == null) {
            return false;
        }
        if (fVar.aJq().rO() == 1 || fVar.aJq().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aJq().rQ() == null || fVar.aJq().rQ().tf() == 0) || fVar.aJq().rM() == 1 || fVar.aJq().rN() == 1 || fVar.aJq().sv() || fVar.aJq().sI() || fVar.aJq().sC() || fVar.aJq().sc() != null || fVar.aJq().sJ() || fVar.aJq().sJ() || !com.baidu.tbadk.core.util.au.isEmpty(fVar.aJq().rI()) || fVar.aJq().rT();
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return com.baidu.tieba.card.at.a((Context) this.eka.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eqT != null) {
                if (fVar.aJq() != null && fVar.aJq().sf() == 0 && !fVar.aJq().sD() && !this.esW) {
                    this.eqT.setVisibility(0);
                    fVar.aJq().sz();
                    if (fVar.aJq() != null) {
                        fVar.aJq().e(true, n(fVar));
                    }
                    SpannableStringBuilder sq = fVar.aJq().sq();
                    this.eqU.setOnTouchListener(new com.baidu.tieba.view.x(sq));
                    if (sq == null || sq.length() == 0) {
                        this.eqU.setVisibility(8);
                    } else {
                        this.eqU.setText(sq);
                        this.eqU.setVisibility(0);
                    }
                    this.era.setPadding(this.era.getPaddingLeft(), this.era.getPaddingTop(), com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds32), this.era.getPaddingBottom());
                } else {
                    this.eqT.setVisibility(8);
                    this.mListView.removeHeaderView(this.eqT);
                    if (fVar.aJq() != null && fVar.aJq().sD()) {
                        this.era.setPadding(this.era.getPaddingLeft(), 0, this.era.getPaddingRight(), this.era.getPaddingBottom());
                    } else {
                        this.era.setPadding(this.era.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds48), this.era.getPaddingRight(), this.era.getPaddingBottom());
                    }
                }
            }
            this.eja = z;
            com.baidu.tbadk.core.data.bj aJq = fVar.aJq();
            if (aJq != null) {
                a(aJq.rQ());
            }
        }
        return false;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aNn();
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
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aJA()));
            sparseArray.put(w.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(w.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(w.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(w.h.tag_del_post_id, c.getId());
            sparseArray.put(w.h.tag_del_post_type, 0);
            sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aJA()));
            sparseArray.put(w.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aEX;
    }

    public void nz(String str) {
        if (this.erD != null && !StringUtils.isNull(str)) {
            this.erD.setText(str);
        }
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public int aNo() {
        return w.h.richText;
    }

    public TextView aKe() {
        return this.eqY.aKe();
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(ab.b bVar) {
        this.ala = bVar;
        if (this.erC != null) {
            this.erC.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.aq aqVar, a.b bVar) {
        if (aqVar != null) {
            int qO = aqVar.qO();
            int qL = aqVar.qL();
            if (this.erz != null) {
                this.erz.ts();
            } else {
                this.erz = new com.baidu.tbadk.core.dialog.a(this.eka.getPageContext().getPageActivity());
                this.erA = LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.dialog_direct_pager, (ViewGroup) null);
                this.erz.v(this.erA);
                this.erz.a(w.l.dialog_ok, bVar);
                this.erz.b(w.l.dialog_cancel, new ft(this));
                this.erz.a(new fv(this));
                this.erz.b(this.eka.getPageContext()).ts();
            }
            this.erB = (EditText) this.erA.findViewById(w.h.input_page_number);
            this.erB.setText("");
            TextView textView = (TextView) this.erA.findViewById(w.h.current_page_number);
            if (qO <= 0) {
                qO = 1;
            }
            if (qL <= 0) {
                qL = 1;
            }
            textView.setText(MessageFormat.format(this.eka.getApplicationContext().getResources().getString(w.l.current_page), Integer.valueOf(qO), Integer.valueOf(qL)));
            this.eka.ShowSoftKeyPadDelay(this.erB, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eka.showToast(str);
    }

    public boolean iP(boolean z) {
        if (this.Ll == null || !this.Ll.CS()) {
            return false;
        }
        this.Ll.Bd();
        return true;
    }

    public void aNp() {
        if (this.etl != null) {
            while (this.etl.size() > 0) {
                TbImageView remove = this.etl.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aNp();
        this.ery.oh(1);
        if (this.eqF != null) {
            this.eqF.onPause();
        }
    }

    public void onResume() {
        this.ery.oh(2);
        if (this.eqF != null) {
            this.eqF.onResume();
        }
    }

    public void onDestroy() {
        this.esG.Uj();
        if (this.esH != null) {
            this.esH.Uj();
        }
        this.eka.hideProgressBar();
        if (this.bEy != null && this.bMe != null) {
            this.bEy.b(this.bMe);
        }
        awO();
        this.erD.wI();
        if (this.esC != null) {
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.esC);
        }
        if (this.esD != null) {
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.esD);
        }
        aNv();
        if (this.esV != null) {
            this.esV.removeAllViews();
        }
        if (this.era != null && this.epp != null) {
            this.era.removeView(this.erd);
            this.epp = null;
        }
        if (this.ess != null) {
            this.ess.clearStatus();
        }
        this.etd = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.ery.oh(3);
        if (this.bHk != null) {
            this.bHk.setBackgroundDrawable(null);
        }
        if (this.eqF != null) {
            this.eqF.destroy();
        }
    }

    public boolean ov(int i) {
        if (this.eqF != null) {
            return this.eqF.ov(i);
        }
        return false;
    }

    public void awO() {
        this.eqM.ol();
        this.esG.Uj();
        com.baidu.adp.lib.util.k.b(this.eka.getPageContext().getPageActivity(), this.erB);
        if (this.esa != null) {
            this.esa.dismiss();
        }
        aNq();
        if (this.esH != null) {
            this.esH.Uj();
        }
        if (this.erz != null) {
            this.erz.dismiss();
        }
        if (this.bOz != null) {
            this.bOz.dismiss();
        }
    }

    public void ib(boolean z) {
        this.ery.ib(z);
    }

    public void gB(boolean z) {
        this.dqK = z;
    }

    public void aNq() {
        if (this.erI != null) {
            this.erI.dismiss();
        }
        if (this.erJ != null) {
            com.baidu.adp.lib.g.j.b(this.erJ, this.eka.getPageContext());
        }
        if (this.erT != null) {
            com.baidu.adp.lib.g.j.b(this.erT, this.eka.getPageContext());
        }
        if (this.erG != null) {
            com.baidu.adp.lib.g.j.b(this.erG, this.eka.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.ens, this.eja);
            d(this.ens, this.eja, this.mType);
            a(this.ens, this.esn, i);
            this.eka.getLayoutMode().ah(i == 1);
            this.eka.getLayoutMode().t(this.dWm);
            this.eka.getLayoutMode().t(this.eqU);
            this.eka.getLayoutMode().t(this.eqV);
            this.eka.getLayoutMode().t(this.eqR);
            if (this.ern != null) {
                com.baidu.tbadk.core.util.aq.c(this.ern, w.e.cp_cont_d, 1);
            }
            if (this.erm != null) {
                com.baidu.tbadk.core.util.aq.c(this.erm, w.e.cp_cont_d, 1);
            }
            if (this.rank > 0) {
                com.baidu.tbadk.core.util.aq.c(this.erg, BitmapHelper.getGradeResourceIdNew(this.rank));
            }
            if (this.eqH != null) {
                this.eqH.AO();
            }
            if (this.eqJ != null) {
                this.eqJ.AO();
            }
            if (this.eqK != null) {
                com.baidu.tbadk.core.util.aq.c(this.eqK, w.e.cp_cont_j, 1);
                String string = this.eka.getResources().getString(w.l.video_public_owner);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (this.eqK.getTag(w.h.tag_user_name) instanceof String) {
                    sb.append((String) this.eqK.getTag(w.h.tag_user_name));
                    SpannableString spannableString = new SpannableString(sb);
                    spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), string.length(), sb.length(), 33);
                    this.eqK.setText(spannableString);
                } else {
                    this.eqK.setText(string);
                }
            }
            this.eka.getLayoutMode().t(this.eqR);
            com.baidu.tbadk.core.util.aq.i((View) this.eqU, w.e.cp_cont_b);
            this.eqU.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.eka.getLayoutMode().t(this.aEX);
            if (this.erA != null) {
                this.eka.getLayoutMode().t(this.erA);
            }
            iO(this.esb);
            this.ery.notifyDataSetChanged();
            if (this.erC != null) {
                this.erC.dh(i);
            }
            if (this.erD != null) {
                this.erD.dh(i);
                com.baidu.tbadk.core.util.aq.j(this.aEX, w.g.pb_foot_more_trans_selector);
                this.erD.df(w.g.pb_foot_more_trans_selector);
            }
            if (this.Ll != null) {
                this.Ll.onChangeSkinType(i);
            }
            if (this.ero != null) {
                this.ero.dl(i);
            }
            if (this.erE != null) {
                this.erE.dh(i);
            }
            if (this.eqQ != null && this.eqQ.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eqQ) {
                    aVar.aNL();
                }
            }
            if (this.esV != null) {
                com.baidu.tbadk.core.util.aq.k(this.esV, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.k(this.esP, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aq.c(this.esU, w.e.cp_cont_c, 1);
            }
            iI(i == 1);
            this.eqZ.changeSkinType(i);
            aMR();
            UtilHelper.setStatusBarBackground(this.bHk, i);
            if (this.erp != null) {
                this.erp.onChangeSkinType(i);
            }
            if (this.err != null) {
                com.baidu.tbadk.i.a.a(this.eka.getPageContext(), this.err);
            }
            if (this.esF != null) {
                this.esF.onChangeSkinType(i);
            }
            if (this.eqM != null) {
                if (this.eqF != null) {
                    this.eqF.ox(i);
                } else {
                    this.eqM.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNu = eVar;
        this.ery.setOnImageClickListener(this.aNu);
    }

    public void h(NoNetworkView.a aVar) {
        this.bMe = aVar;
        if (this.bEy != null) {
            this.bEy.a(this.bMe);
        }
    }

    public void iQ(boolean z) {
        this.ery.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aNr() {
        return this.ese;
    }

    public void aNs() {
        if (this.eqL != 2) {
            this.mListView.setNextPage(this.erD);
            this.eqL = 2;
        }
    }

    public void aNt() {
        if (com.baidu.tbadk.performanceLog.aa.Gi().Gj()) {
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
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.fb(1001);
                                perfLog.aGg = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.wn();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fb(1001);
                        perfLog2.aGg = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.wn();
                    }
                }
            }
        }
    }

    public void gC(boolean z) {
        if (this.esf != null && this.esf != null) {
            if (this.dqK) {
                gD(z);
            } else {
                gE(z);
            }
        }
    }

    public void aNu() {
        if (this.esf != null) {
            this.esf.setVisibility(8);
        }
    }

    public void auC() {
        if (this.esm == null) {
            this.esm = new com.baidu.tbadk.core.view.a(this.eka.getPageContext());
        }
        this.esm.aI(true);
    }

    public void aIn() {
        if (this.esm != null) {
            this.esm.aI(false);
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
                fx fxVar = new fx(this, postData);
                if (this.esL == null || this.mSkinType != i) {
                    if (this.esL == null) {
                        this.esL = (LinearLayout) LayoutInflater.from(this.eka.getActivity()).inflate(w.j.god_floating_view, (ViewGroup) null);
                    }
                    this.esL.setOnClickListener(fxVar);
                    this.esL.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
                    this.esL.setTag(w.h.tag_user_name, userName);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.esL.findViewById(w.h.god_floating_owner_photo);
                    if (this.ais) {
                        ViewStub viewStub = (ViewStub) this.esL.findViewById(w.h.viewstub_headimage_mask);
                        if (viewStub != null && 0 == 0) {
                            viewStub.inflate();
                            TbImageView tbImageView = (TbImageView) this.esL.findViewById(w.h.user_head_mask);
                            if (tbImageView != null && author != null && author.getUserTbVipInfoData() != null && !StringUtils.isNull(author.getUserTbVipInfoData().getvipV_url())) {
                                tbImageView.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                                clickableHeaderImageView.setIsBigV(true);
                            }
                        }
                    } else {
                        clickableHeaderImageView.setGodIconMargin(0);
                    }
                    clickableHeaderImageView.setOnClickListener(fxVar);
                    clickableHeaderImageView.setTag(postData.getAuthor().getUserId());
                    clickableHeaderImageView.c(postData.getAuthor().getPortrait(), 28, false);
                    ImageView imageView = (ImageView) this.esL.findViewById(w.h.god_floating_owner_info_user_rank);
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
                    ImageView imageView2 = (ImageView) this.esL.findViewById(w.h.god_floating_owner_info_user_bawu);
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
                    if (!StringUtils.isNull(postData.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aK(postData.getAuthor().getName_show()) > 14) {
                        i2 = 0;
                    }
                    ArrayList<IconData> iconInfo = postData.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = postData.getAuthor().getTShowInfoNew();
                    UserIconBox userIconBox = (UserIconBox) this.esL.findViewById(w.h.god_floating_owner_info_user_icon);
                    UserIconBox userIconBox2 = (UserIconBox) this.esL.findViewById(w.h.god_floating_owner_info_tshow_icon);
                    if (userIconBox != null) {
                        userIconBox.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                        userIconBox.setOnClickListener(this.eka.ekN.bWQ);
                        userIconBox.a(iconInfo, i2, this.eka.getResources().getDimensionPixelSize(w.f.ds30), this.eka.getResources().getDimensionPixelSize(w.f.ds30), this.eka.getResources().getDimensionPixelSize(w.f.ds10));
                    }
                    if (userIconBox2 != null) {
                        userIconBox2.setOnClickListener(this.eka.ekN.etG);
                        userIconBox2.a(tShowInfoNew, 3, this.eka.getResources().getDimensionPixelSize(w.f.ds32), this.eka.getResources().getDimensionPixelSize(w.f.ds32), this.eka.getResources().getDimensionPixelSize(w.f.ds8), true);
                    }
                    TextView textView = (TextView) this.esL.findViewById(w.h.god_floating_owner_info_user_name);
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_f, 1);
                    }
                    textView.setText(postData.getAuthor().getName_show());
                    if (aNB() != null && this.esL.getParent() == null) {
                        aNB().addView(this.esL);
                    }
                    this.eka.getLayoutMode().t(this.esL);
                }
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) this.esL.findViewById(w.h.god_floating_gift);
                this.esY.a(entelechyUserLikeButton);
                this.esY.a(postData.getAuthor());
                ImageView imageView3 = (ImageView) this.esL.findViewById(w.h.god_floating_arrow);
                com.baidu.tbadk.core.util.aq.c(imageView3, w.g.icon_arrow_tab);
                if (this.esc || (godUserData.getIsLike() && godUserData.getIsFromNetWork())) {
                    entelechyUserLikeButton.setVisibility(8);
                    imageView3.setVisibility(0);
                } else {
                    entelechyUserLikeButton.setVisibility(0);
                    imageView3.setVisibility(8);
                }
                String format = String.format(this.eka.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(fansNum));
                TextView textView2 = (TextView) this.esL.findViewById(w.h.god_floating_intro);
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
        if (fVar.aJq() == null || !fVar.aJq().sD() || fVar.aJq().sh() == null) {
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
        if (this.erp.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.erp.getLayoutParams();
            aVar.gravity = 48;
            this.erp.setLayoutParams(aVar);
        }
        this.era.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32), 0);
        this.esE.setPadding(0, com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds8), 0, 0);
        if (postData.getType() == null || postData.getType().getId() != PostData.XM.getId()) {
            this.eqR.setPadding(0, 0, 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds76);
        if (this.erf.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.erf.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.erf.setLayoutParams(layoutParams);
        this.erf.setVisibility(8);
        View findViewWithTag = this.era.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.epp = new ClickableHeaderImageView(this.eka.getApplicationContext());
            this.epp.setGodIconMargin(0);
            this.epp.setTag("pb_god_head_image_view_tag");
            this.epp.setUserId(String.valueOf(userIdLong));
            this.epp.setUserName(userName);
            layoutParams.leftMargin = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds0);
            this.erd.addView(this.epp, 0, layoutParams);
        } else {
            this.epp = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.ais) {
            this.epp.setIsBigV(true);
        }
        fy fyVar = new fy(this, postData, fVar);
        this.era.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.era.setTag(w.h.tag_user_name, userName);
        this.eqV.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.eqV.setTag(w.h.tag_user_name, userName);
        this.epp.setVisibility(0);
        this.epp.setOnClickListener(fyVar);
        this.epp.c(portrait, 28, false);
        if (this.ern == null) {
            this.ern = new TextView(this.eka.getActivity());
            this.ern.setClickable(true);
            this.ern.setTextSize(0, this.eka.getResources().getDimensionPixelSize(w.f.fontsize24));
            ColumnLayout.a aVar2 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar2.topMargin = this.eka.getResources().getDimensionPixelSize(w.f.ds10);
            this.ern.setSingleLine(true);
            this.ern.setEllipsize(TextUtils.TruncateAt.END);
            this.ern.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
            this.ern.setTag(w.h.tag_user_name, userName);
            com.baidu.tbadk.core.util.aq.c(this.ern, w.e.cp_cont_d, 1);
            this.ern.setOnTouchListener(this.ejf);
            this.era.addView(this.ern, -1, aVar2);
        }
        String string = this.eka.getResources().getString(w.l.tieba_certification);
        this.ern.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.eka.getResources().getString(w.l.god_intro_default)) : String.format(string, godUserData.getIntro()));
        if (this.erm == null) {
            this.erm = new TextView(this.eka.getActivity());
            this.erm.setClickable(false);
            this.erm.setIncludeFontPadding(false);
            this.erm.setGravity(16);
            this.erm.setTextSize(0, this.eka.getResources().getDimensionPixelSize(w.f.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.eka.getResources().getDimensionPixelSize(w.f.ds5);
            aVar3.bottomMargin = this.eka.getResources().getDimensionPixelSize(w.f.ds10);
            this.erm.setSingleLine(true);
            com.baidu.tbadk.core.util.aq.c(this.erm, w.e.cp_cont_d, 1);
            this.era.addView(this.erm, -1, aVar3);
        }
        this.erm.setText(String.format(this.eka.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(fansNum)));
        this.erm.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.erm.setTag(w.h.tag_user_name, userName);
        this.erm.setOnClickListener(fyVar);
        if (z3) {
            this.erm.setVisibility(4);
        } else {
            this.erm.setVisibility(0);
        }
        if (this.esM == null) {
            this.esM = new TextView(this.eka.getApplicationContext());
            this.esM.setId(w.h.pb_god_user_tip_content);
            this.esM.setEllipsize(TextUtils.TruncateAt.END);
            this.esM.setGravity(17);
            this.esM.setSingleLine(true);
            this.esM.setHeight(this.eka.getResources().getDimensionPixelSize(w.f.ds56));
            this.esM.setTextSize(0, this.eka.getResources().getDimensionPixelSize(w.f.fontsize24));
            this.esM.setVisibility(8);
            if (aNB() != null) {
                aNB().addView(this.esM);
            }
            this.eka.getLayoutMode().t(this.esM);
        }
        com.baidu.tbadk.core.util.aq.j(this.esM, w.e.common_color_10260);
        com.baidu.tbadk.core.util.aq.i((View) this.esM, w.e.cp_cont_g);
        this.esM.setOnClickListener(new fz(this));
        this.esM.setText(String.format(this.eka.getResources().getString(w.l.god_user_floor_owner_tip), com.baidu.tbadk.core.util.au.t(this.esN)));
        ow(this.esN);
        if (!z3) {
            a(fVar, postData, this.mSkinType);
        }
        this.esV = this.erD.wE();
        if (this.esV != null && !this.esc && !z && z2 && (!godUserData.getIsLike() || !godUserData.getIsFromNetWork())) {
            this.erD.wF();
            this.erD.wB();
            this.esP = this.esV.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.esP == null) {
                this.esP = new View(this.eka.getApplicationContext());
                this.esP.setTag("pb_god_bottom_extra_line_view_tag");
                this.esV.addView(this.esP, new LinearLayout.LayoutParams(-1, this.eka.getResources().getDimensionPixelSize(w.f.ds20)));
                this.esT = new FrameLayout(this.eka.getApplicationContext());
                this.esT.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.esR = new ClickableHeaderImageView(this.eka.getApplicationContext());
                this.esR.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.esR.c(portrait, 28, false);
                this.esR.setUserId(String.valueOf(userIdLong));
                this.esR.setUserName(userName);
                this.esR.setOnClickListener(fyVar);
                this.esT.addView(this.esR, new FrameLayout.LayoutParams(this.eka.getResources().getDimensionPixelSize(w.f.ds130), this.eka.getResources().getDimensionPixelSize(w.f.ds130)));
                if (this.ais) {
                    this.esS = new TbImageView(this.eka.getApplicationContext());
                    this.esS.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.esS.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.eka.getResources().getDimensionPixelSize(w.f.ds45), this.eka.getResources().getDimensionPixelSize(w.f.ds45));
                    layoutParams3.gravity = 85;
                    this.esT.addView(this.esS, layoutParams3);
                } else {
                    this.esR.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(this.eka.getResources().getDimensionPixelSize(w.f.ds130), this.eka.getResources().getDimensionPixelSize(w.f.ds130));
                layoutParams4.gravity = 17;
                layoutParams4.topMargin = this.eka.getResources().getDimensionPixelSize(w.f.ds40);
                this.esV.addView(this.esT, layoutParams4);
                this.esU = new TextView(this.eka.getApplicationContext());
                this.esU.setTag("pb_god_bottom_extra_text_view_tag");
                this.esU.setSingleLine(true);
                this.esU.setTextSize(0, this.eka.getResources().getDimensionPixelSize(w.f.fontsize24));
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.topMargin = this.eka.getResources().getDimensionPixelSize(w.f.ds36);
                layoutParams5.gravity = 1;
                this.esU.setText(this.eka.getResources().getString(w.l.god_user_attention_tip));
                this.esV.addView(this.esU, layoutParams5);
                if (this.esQ == null) {
                    this.esQ = new EntelechyUserLikeButton(this.eka.getApplicationContext());
                    this.esZ.a(this.esQ);
                }
                this.esQ.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.esQ.setTextSize(0, this.eka.getResources().getDimensionPixelSize(w.f.fontsize24));
                this.esQ.setGravity(17);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, this.eka.getResources().getDimensionPixelSize(w.f.ds54));
                layoutParams6.topMargin = this.eka.getResources().getDimensionPixelSize(w.f.ds30);
                layoutParams6.bottomMargin = this.eka.getResources().getDimensionPixelSize(w.f.ds40);
                layoutParams6.gravity = 1;
                this.esV.addView(this.esQ, layoutParams6);
            } else {
                this.esQ = (EntelechyUserLikeButton) this.esV.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.esR = (ClickableHeaderImageView) this.esV.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.esU = (TextView) this.esV.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.esP = this.esV.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            this.esZ.a(postData.getAuthor());
            com.baidu.tbadk.core.util.aq.k(this.esV, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.k(this.esP, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.c(this.esU, w.e.cp_cont_c, 1);
            this.esV.setOnTouchListener(new ga(this));
        } else {
            this.erD.wG();
            this.erD.wA();
        }
        return true;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!this.etb && aNJ()) {
            c(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.esJ && !this.ekG && i > this.eqC) {
            this.esK = true;
        } else {
            this.esK = false;
            aNw();
        }
        if (!this.etb && aNJ()) {
            b(absListView, i, i2, i3);
        }
        a aVar = new a();
        aVar.etv = i;
        aVar.etw = this.mListView.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
    }

    private void c(AbsListView absListView, int i) {
        if (this.eqF != null) {
            this.eqF.a(absListView, i, this.est);
        }
    }

    private void b(AbsListView absListView, int i, int i2, int i3) {
        if (this.eqF != null) {
            this.eqF.b(absListView, i, this.est);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int etv;
        public int etw;

        public a() {
        }
    }

    private void ow(int i) {
        boolean z;
        if (this.esM != null && this.esM.getVisibility() != 0 && i >= 2 && !this.esc) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.esO = true;
                this.esM.setVisibility(0);
            }
            com.baidu.adp.lib.g.h.fM().postDelayed(this.bQQ, 3000L);
        }
    }

    public void aNv() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.bQQ);
        if (this.esM != null && 8 != this.esM.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.eka, this.esM, w.a.fade_out, new gb(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aNw() {
        if (this.esL != null) {
            this.esL.clearAnimation();
            if (this.esL.getVisibility() != 8) {
                this.esL.setVisibility(8);
            }
        }
    }

    public void aNx() {
        if (this.esJ && this.esK && this.esL != null && this.esL.getVisibility() != 0 && !this.esO) {
            this.esL.clearAnimation();
            this.esL.setVisibility(0);
        }
    }

    public void aNy() {
        if (!this.etm) {
            TiebaStatic.log("c10490");
            this.etm = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eka.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(esx, Integer.valueOf(esz));
            aVar.bV(w.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(w.h.function_description_view)).setText(w.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(w.h.title_view)).setText(w.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(w.l.grade_button_tips, this.eka);
            aVar.b(w.l.look_again, new gc(this));
            aVar.b(this.eka.getPageContext()).ts();
        }
    }

    public void aNz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eka.getPageContext().getPageActivity());
        aVar.cx(this.eka.getResources().getString(w.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(esx, Integer.valueOf(esB));
        aVar.A(sparseArray);
        aVar.a(w.l.upgrade_to_new, this.eka);
        aVar.b(w.l.cancel, new gd(this));
        aVar.b(this.eka.getPageContext()).ts();
    }

    public int rE() {
        return this.esu;
    }

    public void nA(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eka.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eka.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(w.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(w.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(esx, Integer.valueOf(esA));
        aVar.A(sparseArray);
        aVar.a(w.l.view, this.eka);
        aVar.b(w.l.cancel, new ge(this));
        aVar.b(this.eka.getPageContext()).ts();
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

    public PbInterviewStatusView aNA() {
        return this.ess;
    }

    private void o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aJq() != null && fVar.aJq().sI() && this.ess == null) {
            this.ess = (PbInterviewStatusView) this.esr.inflate();
            this.ess.setOnClickListener(this.bOI);
            this.ess.setCallback(this.eka.aKL());
            this.ess.a(this.eka, fVar);
        }
    }

    public LinearLayout aNB() {
        return this.erx;
    }

    public View aNC() {
        return this.bHk;
    }

    public boolean aND() {
        return this.esW;
    }

    public void ig(boolean z) {
        this.eqY.ig(z);
    }

    private void aNE() {
        if (this.esW) {
            if (this.esX == null) {
                f.a aVar = f.ekd.get();
                if (aVar != null) {
                    this.esX = aVar.a(this.eka);
                    ListAdapter adapter = this.mListView.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.avn) {
                            this.mListView.addHeaderView(this.esX.aKc(), 1);
                        } else {
                            this.mListView.addHeaderView(this.esX.aKc(), 0);
                        }
                    }
                } else {
                    this.eqV.setVisibility(0);
                    return;
                }
            }
            this.eqV.setVisibility(8);
            this.mListView.removeHeaderView(this.eqV);
            return;
        }
        this.eqV.setVisibility(0);
    }

    public void iR(boolean z) {
        this.esW = z;
    }

    public View aLq() {
        return this.eqZ.aLq();
    }

    public void aNF() {
        this.eka.showNetRefreshView(getView(), "");
        View EB = this.eka.getRefreshView().EB();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EB.getLayoutParams();
        layoutParams.addRule(3, aNB().getId());
        EB.setLayoutParams(layoutParams);
        this.eka.hideLoadingView(getView());
        if (this.esX != null) {
            this.mListView.removeHeaderView(this.esX.aKc());
            this.esX = null;
        }
    }

    public void nB(String str) {
        if (this.eqN != null) {
            this.eqN.setTitle(str);
        }
    }

    public void aNG() {
        if (this.ery != null) {
            if (this.ery.aKX() != null) {
                this.ery.aKX().ayh();
            }
            if (this.ery.aKY() != null) {
                this.ery.aKY().ayh();
            }
        }
    }

    private int iS(boolean z) {
        if (this.ess == null || this.ess.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.eka.getPageContext().getPageActivity(), w.f.ds72);
    }

    private void aNH() {
        if (this.ess != null && this.ess.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ess.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.ess.setLayoutParams(layoutParams);
        }
    }

    public boolean aKl() {
        return this.esJ;
    }

    public TextView aNI() {
        return this.ern;
    }

    public void nC(String str) {
        this.esi.performClick();
        if (!StringUtils.isNull(str) && this.eka.aKf() != null && this.eka.aKf().Dq() != null && this.eka.aKf().Dq().Di() != null) {
            EditText Di = this.eka.aKf().Dq().Di();
            Di.setText(str);
            Di.setSelection(str.length());
        }
    }

    public boolean aNJ() {
        return (this.eqF == null || this.eqI == null) ? false : true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            awO();
            aNu();
            aMH();
            if (this.esF != null) {
                this.esF.aLc();
            }
            this.eka.YU();
            aNw();
            this.erx.setVisibility(8);
            this.eqM.setTitleVisibility(true);
            this.eka.in(false);
            this.etb = false;
            if (this.eqI != null && this.eqD != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eqD.getLayoutParams();
                layoutParams.topMargin = 0;
                this.eqD.setLayoutParams(layoutParams);
                if (configuration.orientation == 2) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.etb = true;
                } else {
                    int ag = com.baidu.adp.lib.util.k.ag(this.eka.getActivity());
                    layoutParams.width = ag;
                    layoutParams.height = (int) (ag * 0.5625d);
                    if (this.eqF != null) {
                        this.eqF.aNU();
                    }
                    this.erx.setVisibility(0);
                    this.etb = false;
                }
                this.eqD.setLayoutParams(layoutParams);
                this.eqI.a(this.eka, configuration);
            }
        }
    }

    public void x(long j, int i) {
        if (this.eqJ != null && j > 0) {
            this.eqJ.k(i, j);
        }
    }

    public void iT(boolean z) {
        this.eqG = z;
    }

    private void H(com.baidu.tbadk.core.data.bj bjVar) {
        if (this.eqJ != null && bjVar != null && bjVar.sU() != null && bjVar.sU().ZH == 2) {
            if (this.esH == null) {
                this.esH = new com.baidu.tieba.d.a(this.eka.getPageContext(), this.eqJ.ewD);
                this.esH.gV(5000);
            }
            this.esH.e(this.eka.getResources().getString(w.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }
}
