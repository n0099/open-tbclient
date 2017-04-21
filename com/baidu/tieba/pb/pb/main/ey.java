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
    public static int esV = 2;
    public static int esW = 3;
    public static int esX = 0;
    public static int esY = 3;
    public static int esZ = 4;
    public static int eta = 5;
    public static int etb = 6;
    private com.baidu.tbadk.editortools.j KO;
    private View aFp;
    private int aNo;
    private boolean aiH;
    private ab.b alq;
    private TextView avF;
    private NoNetworkView bGI;
    private View bJu;
    private View.OnClickListener bQO;
    private ViewStub bbW;
    private TbImageView bbX;
    private RelativeLayout dVV;
    private View.OnClickListener ejA;
    private com.baidu.tieba.pb.a.d ejB;
    private PbActivity ekw;
    PbActivity.c elV;
    private com.baidu.tieba.pb.data.f enR;
    private PbFakeFloorModel ens;
    public int eqY;
    private int eqZ;
    private ColumnLayout erA;
    private ThreadSkinView erB;
    private TextView erC;
    private FrameLayout erD;
    private HeadPendantView erE;
    private HeadImageView erF;
    private ImageView erG;
    private ImageView erH;
    private UserIconBox erI;
    private UserIconBox erJ;
    private View erK;
    private FloatingLayout erL;
    private EntelechyUserLikeButton erP;
    private ew erQ;
    private LinearLayout erR;
    private TextView erS;
    private TextView erT;
    private View erU;
    private View erV;
    private ObservedChangeLinearLayout erX;
    private cn erY;
    private int era;
    private int erb;
    private FrameLayout erd;
    private int ere;
    private com.baidu.tieba.pb.video.d erf;
    private com.baidu.tieba.pb.video.a erh;
    private com.baidu.tieba.play.c eri;
    private com.baidu.tieba.pb.video.b erj;
    private TextView erk;
    public final com.baidu.tieba.pb.pb.main.view.f erm;
    public com.baidu.tieba.pb.pb.main.view.d ern;
    private ViewStub ero;
    private ViewStub erp;
    private List<com.baidu.tieba.pb.pb.main.view.a> erq;
    private View err;
    private LinearLayout erv;
    private TextView erw;
    private View erx;
    private g ery;
    private di erz;
    private View esF;
    private TextView esG;
    private TextView esH;
    private ViewGroup esI;
    private TextView esJ;
    private boolean esL;
    private PostData esN;
    private View esP;
    private TextView esQ;
    private ViewStub esR;
    private PbInterviewStatusView esS;
    private TextView esT;
    private PbListView esd;
    private View esf;
    private com.baidu.tbadk.core.view.userLike.c etA;
    private Runnable etE;
    private PbActivity.a etG;
    private boolean etI;
    private boolean etJ;
    private Runnable etd;
    private Runnable ete;
    private FloatingLayout etf;
    private dc etg;
    private com.baidu.tieba.d.a eth;
    private com.baidu.tieba.d.a eti;
    private View etq;
    private EntelechyUserLikeButton etr;
    private ClickableHeaderImageView ets;
    private TbImageView ett;
    private FrameLayout etu;
    private TextView etv;
    private LinearLayout etw;
    private boolean etx;
    private f ety;
    private com.baidu.tbadk.core.view.userLike.c etz;
    private BdTypeListView mListView;
    private int mType;
    private int erc = 1;
    private boolean erg = false;
    private int erl = 0;
    private final Handler mHandler = new Handler();
    private View ers = null;
    private LinearLayout ert = null;
    private TextView eru = null;
    private TextView erM = null;
    private TextView erN = null;
    public FrsPraiseView erO = null;
    private ClickableHeaderImageView epP = null;
    private View erW = null;
    private com.baidu.tbadk.core.dialog.a erZ = null;
    private com.baidu.tbadk.core.dialog.c bQF = null;
    private View esa = null;
    private EditText esb = null;
    private com.baidu.tieba.pb.view.m esc = null;
    private com.baidu.tieba.pb.view.b ese = null;
    private c.b daC = null;
    private TbRichTextView.e aNM = null;
    private NoNetworkView.a bOn = null;
    private Dialog esg = null;
    private View esh = null;
    private com.baidu.tbadk.core.dialog.a esi = null;
    private Dialog esj = null;
    private View esk = null;
    private int esl = 0;
    private RadioGroup esm = null;
    private RadioButton esn = null;
    private RadioButton eso = null;
    private RadioButton esp = null;
    private Button esq = null;
    private Button esr = null;
    private TextView ess = null;
    private Dialog est = null;
    private View esu = null;
    private LinearLayout esv = null;
    private CompoundButton.OnCheckedChangeListener esw = null;
    private TextView esx = null;
    private TextView esy = null;
    private String esz = null;
    private com.baidu.tbadk.core.dialog.c esA = null;
    private boolean esB = false;
    private boolean esC = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView esD = null;
    private boolean drA = false;
    private Button esE = null;
    private boolean esK = true;
    private com.baidu.tbadk.core.view.a esM = null;
    private boolean ejw = false;
    private int mSkinType = 3;
    private boolean esO = false;
    private boolean mIsFromCDN = true;
    private int esU = 0;
    private a.InterfaceC0072a etj = new ez(this);
    private boolean etk = false;
    private boolean elc = false;
    private boolean etl = false;
    private LinearLayout etm = null;
    private TextView etn = null;
    private int eto = 0;
    private boolean etp = false;
    private boolean etB = false;
    private int rank = 0;
    private boolean etC = false;
    private Animation.AnimationListener dxh = new fj(this);
    private Handler etD = new Handler();
    private CustomMessageListener etF = new fs(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean etH = true;
    private boolean etK = false;
    private boolean Zi = false;
    String userId = null;
    private final List<TbImageView> etL = new ArrayList();
    private boolean etM = false;
    private Runnable bSW = new gd(this);

    public f aNP() {
        return this.ety;
    }

    public NoNetworkView aNQ() {
        return this.bGI;
    }

    public boolean isFullScreen() {
        return this.elc;
    }

    public void aNR() {
        if (this.KO != null) {
            this.KO.hide();
        }
    }

    public PbFakeFloorModel aNS() {
        return this.ens;
    }

    public dc aNT() {
        return this.etg;
    }

    public void aNU() {
        reset();
        this.esK = true;
        if (this.KO != null) {
            this.KO.hide();
        }
        this.etg.aMl();
        if (this.esF != null) {
            if (this.drA) {
                gN(false);
            } else {
                gO(false);
            }
        }
        aMy();
    }

    private void reset() {
        if (this.ekw != null && this.ekw.aLn() != null && this.KO != null) {
            com.baidu.tbadk.editortools.pb.a.DK().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aLn = this.ekw.aLn();
            aLn.Ee();
            if (aLn.getWriteImagesInfo() != null) {
                aLn.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aLn.eK(10);
            aLn.eI(SendView.ALL);
            aLn.eJ(SendView.ALL);
            com.baidu.tbadk.editortools.p ez = this.KO.ez(23);
            com.baidu.tbadk.editortools.p ez2 = this.KO.ez(2);
            com.baidu.tbadk.editortools.p ez3 = this.KO.ez(5);
            if (ez2 != null) {
                ez2.mp();
            }
            if (ez3 != null) {
                ez3.mp();
            }
            if (ez != null) {
                ez.hide();
            }
            this.KO.invalidate();
        }
    }

    public boolean aNV() {
        return this.esK;
    }

    public void gN(boolean z) {
        if (this.esF != null && this.esG != null && this.esH != null) {
            this.esG.setText(w.l.draft_to_send);
            this.esH.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.esF.startAnimation(alphaAnimation);
            }
            this.esF.setVisibility(0);
        }
    }

    public void gO(boolean z) {
        if (this.esF != null && this.esG != null && this.esH != null) {
            this.esG.setText(w.l.reply_floor_host);
            this.esH.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.esF.startAnimation(alphaAnimation);
            }
            this.esF.setVisibility(0);
        }
    }

    public PostData aNW() {
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
        if (this.erY.ok(headerViewsCount) != null && this.erY.ok(headerViewsCount) != PostData.fyg) {
            i2 = headerViewsCount + 1;
        }
        return (PostData) this.erY.getItem(i2);
    }

    public ey(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.aNo = 0;
        this.eqZ = 0;
        this.era = 0;
        this.erb = 0;
        this.ekw = null;
        this.dVV = null;
        this.bJu = null;
        this.mListView = null;
        this.err = null;
        this.erv = null;
        this.erw = null;
        this.erx = null;
        this.erA = null;
        this.erC = null;
        this.erD = null;
        this.erE = null;
        this.erF = null;
        this.erG = null;
        this.erH = null;
        this.erI = null;
        this.erJ = null;
        this.erK = null;
        this.erP = null;
        this.erU = null;
        this.erV = null;
        this.erY = null;
        this.esd = null;
        this.aFp = null;
        this.bQO = null;
        this.ejA = null;
        this.esF = null;
        this.esG = null;
        this.esI = null;
        this.esJ = null;
        this.esP = null;
        this.esQ = null;
        this.esR = null;
        this.ekw = pbActivity;
        this.bQO = onClickListener;
        this.ejB = dVar;
        this.dVV = (RelativeLayout) LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.new_pb_activity, (ViewGroup) null);
        this.ekw.addContentView(this.dVV, new FrameLayout.LayoutParams(-1, -1));
        this.bJu = this.ekw.findViewById(w.h.statebar_view);
        this.erX = (ObservedChangeLinearLayout) this.ekw.findViewById(w.h.title_wrapper);
        this.bGI = (NoNetworkView) this.ekw.findViewById(w.h.view_no_network);
        this.mListView = (BdTypeListView) this.ekw.findViewById(w.h.new_pb_list);
        this.avF = new TextView(this.ekw.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.ekw.getActivity(), w.f.ds98));
        this.mListView.addHeaderView(this.avF, 0);
        View view = new View(this.ekw.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.ekw.getResources().getDimensionPixelSize(w.f.ds100)));
        view.setVisibility(4);
        this.mListView.addFooterView(view);
        this.mListView.setOnTouchListener(this.ekw.aOj);
        this.erm = new com.baidu.tieba.pb.pb.main.view.f(pbActivity);
        this.eth = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.erm.euz);
        this.eth.hf(3);
        this.erz = new di(this.ekw, this.dVV);
        this.erz.init();
        this.erz.a(this.erz.aMz(), this.bQO);
        if (this.ekw.aLI()) {
            this.ero = (ViewStub) this.ekw.findViewById(w.h.manga_view_stub);
            this.ero.setVisibility(0);
            this.ern = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
            this.ern.show();
            this.erm.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.avF.setLayoutParams(layoutParams);
        this.erm.aOY().setOnTouchListener(new com.baidu.tieba.pb.a.a(new ge(this)));
        this.esF = this.ekw.findViewById(w.h.pb_editor_tool_comment);
        this.esG = (TextView) this.ekw.findViewById(w.h.pb_editor_tool_comment_reply_text);
        this.esI = (ViewGroup) this.ekw.findViewById(w.h.pb_editor_tool_comment_reply_layout);
        this.esJ = (TextView) this.ekw.findViewById(w.h.pb_editor_tool_comment_praise_icon);
        boolean al = com.baidu.tieba.graffiti.c.al(this.esJ);
        if (al) {
            iW(al);
            this.esJ.setVisibility(0);
        }
        this.esH = (TextView) this.ekw.findViewById(w.h.pb_editor_tool_comment_reply_count_text);
        this.esI.setOnClickListener(new gf(this));
        this.esJ.setOnClickListener(this.bQO);
        this.esJ.setOnTouchListener(this.ekw);
        this.err = LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_item, (ViewGroup) null);
        this.erv = (LinearLayout) LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_user_item, (ViewGroup) null);
        this.ery = new g(this.ekw, this.erv);
        this.ery.init();
        this.ery.a(this.ery.aLm(), this.bQO);
        this.erA = (ColumnLayout) this.erv.findViewById(w.h.pb_head_owner_root);
        this.etf = (FloatingLayout) this.erv.findViewById(w.h.pb_head_owner_info_root);
        this.erB = (ThreadSkinView) this.erv.findViewById(w.h.pb_thread_skin);
        this.erA.setOnLongClickListener(this.onLongClickListener);
        this.erA.setOnTouchListener(this.ejB);
        this.erA.setVisibility(8);
        this.err.setOnTouchListener(this.ejB);
        this.esP = this.err.findViewById(w.h.pb_head_activity_join_number_container);
        this.esP.setVisibility(8);
        this.esQ = (TextView) this.err.findViewById(w.h.pb_head_activity_join_number);
        this.erC = (TextView) this.erA.findViewById(w.h.pb_head_owner_info_user_name);
        this.erD = (FrameLayout) this.erA.findViewById(w.h.pb_head_headImage_container);
        this.erF = (HeadImageView) this.erA.findViewById(w.h.pb_head_owner_photo);
        this.erE = (HeadPendantView) this.erA.findViewById(w.h.pb_pendant_head_owner_photo);
        this.bbW = (ViewStub) this.erA.findViewById(w.h.viewstub_headimage_mask);
        this.erE.wL();
        if (this.erE.getHeadView() != null) {
            this.erE.getHeadView().setIsRound(true);
            this.erE.getHeadView().setDrawBorder(false);
        }
        if (this.erE.getPendantView() != null) {
            this.erE.getPendantView().setIsRound(true);
            this.erE.getPendantView().setDrawBorder(false);
        }
        this.erG = (ImageView) this.erA.findViewById(w.h.pb_head_owner_info_user_rank);
        this.erH = (ImageView) this.erA.findViewById(w.h.pb_head_owner_info_user_bawu);
        this.erI = (UserIconBox) this.erA.findViewById(w.h.pb_head_owner_info_user_icon);
        this.erJ = (UserIconBox) this.erA.findViewById(w.h.pb_head_owner_info_tshow_icon);
        this.erL = (FloatingLayout) this.erv.findViewById(w.h.pb_head_owner_info_root);
        this.erP = (EntelechyUserLikeButton) this.erA.findViewById(w.h.pb_like_button);
        this.erQ = new ew(pbActivity.getPageContext(), this.erP);
        this.etz = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.etA = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.erU = this.err.findViewById(w.h.new_pb_header_item_line_above_livepost);
        this.erx = LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.layout_read_thread, (ViewGroup) null);
        this.erw = (TextView) this.erx.findViewById(w.h.pb_head_read_button);
        this.erv.addView(this.erx);
        this.erw.setOnClickListener(this.bQO);
        this.erb = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds2);
        this.era = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds18);
        this.eqZ = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);
        this.aNo = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds32);
        this.erV = this.err.findViewById(w.h.new_pb_header_item_line_below_livepost);
        this.err.setOnLongClickListener(new gg(this));
        this.esR = (ViewStub) this.dVV.findViewById(w.h.interview_status_stub);
        this.erY = new cn(this.ekw, this.mListView);
        this.erY.u(this.bQO);
        this.erY.a(this.ejB);
        this.erY.setOnImageClickListener(this.aNM);
        this.ejA = new gh(this);
        this.erY.H(this.ejA);
        aNZ();
        this.mListView.addHeaderView(this.ert);
        this.mListView.addHeaderView(this.erv);
        this.mListView.addHeaderView(this.err);
        this.esd = new PbListView(this.ekw.getPageContext().getPageActivity());
        this.aFp = this.esd.getView().findViewById(w.h.pb_more_view);
        if (this.aFp != null) {
            this.aFp.setOnClickListener(this.bQO);
            com.baidu.tbadk.core.util.aq.j(this.aFp, w.g.pb_foot_more_trans_selector);
        }
        this.esd.wW();
        this.esd.di(w.g.pb_foot_more_trans_selector);
        this.esd.dj(w.g.pb_foot_more_trans_selector);
        this.esf = this.ekw.findViewById(w.h.viewstub_progress);
        this.ekw.registerListener(this.etF);
        this.erK = com.baidu.tbadk.ala.c.oa().h(this.ekw.getActivity(), 2);
        if (this.erK != null) {
            this.erK.setVisibility(8);
            this.erL.addView(this.erK, 2);
        }
        this.ens = new PbFakeFloorModel(this.ekw.getPageContext());
        this.etg = new dc(this.ekw.getPageContext(), this.ens, this.dVV);
        this.ens.a(new gi(this));
    }

    public void aNX() {
        if (this.mListView != null) {
            this.mListView.removeHeaderView(this.ert);
            this.mListView.removeHeaderView(this.erv);
            this.mListView.removeHeaderView(this.err);
        }
    }

    private boolean j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aKy() == null || !fVar.aKR() || !TbadkCoreApplication.m9getInst().isTTSCanUse() || fVar.aKy().sm() == 1 || fVar.aKy().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aKy().so() == null || fVar.aKy().so().tD() == 0) && !fVar.aKy().tg()) {
            BdUniqueId type = fVar.aKy().getType();
            return type == com.baidu.tbadk.core.data.bi.Yb || type == com.baidu.tbadk.core.data.bi.Yc || type == com.baidu.tbadk.core.data.bi.Ya;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.erx != null) {
            if (!z) {
                this.erx.setVisibility(8);
            } else if (!j(fVar)) {
                this.erx.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aKA() != null && fVar.aKA().size() > 0) {
                    postData = fVar.aKA().get(0);
                }
                if (postData != null && postData.bjp() == 1) {
                    q(this.aNo, this.era, this.aNo, this.erb);
                } else {
                    q(this.aNo, this.era, this.aNo, this.eqZ);
                }
                this.erx.setVisibility(0);
            }
        }
    }

    private void q(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erw.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.erw.setLayoutParams(layoutParams);
    }

    public TextView aNY() {
        return this.erw;
    }

    private void aNZ() {
        if (this.ert == null) {
            int g = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds32);
            int g2 = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds40);
            this.ert = new LinearLayout(this.ekw.getPageContext().getPageActivity());
            this.ert.setOrientation(1);
            this.ert.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.ert.setPadding(0, g2, 0, g2);
            this.ert.setGravity(17);
            this.eru = new TextView(this.ekw.getPageContext().getPageActivity());
            this.eru.setGravity(3);
            this.eru.setMaxLines(2);
            this.eru.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.eru.setPadding(g, 0, g, 0);
            com.baidu.tbadk.core.util.aq.i(this.eru, w.e.cp_cont_b);
            this.eru.setTextSize(0, g2);
            this.eru.setVisibility(8);
            this.ert.addView(this.eru);
            this.ert.setOnTouchListener(this.ejB);
            this.ert.setOnLongClickListener(new fa(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOa() {
        if (this.ekw.aLI()) {
            this.erp = (ViewStub) this.ekw.findViewById(w.h.manga_mention_controller_view_stub);
            this.erp.setVisibility(0);
            if (this.erR == null) {
                this.erR = (LinearLayout) this.ekw.findViewById(w.h.manga_controller_layout);
                com.baidu.tbadk.m.a.a(this.ekw.getPageContext(), this.erR);
            }
            if (this.erS == null) {
                this.erS = (TextView) this.erR.findViewById(w.h.manga_prev_btn);
            }
            if (this.erT == null) {
                this.erT = (TextView) this.erR.findViewById(w.h.manga_next_btn);
            }
            this.erS.setOnClickListener(this.bQO);
            this.erT.setOnClickListener(this.bQO);
        }
    }

    private void aOb() {
        if (this.ekw.aLI()) {
            if (this.ekw.aLL() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.erS, w.e.cp_cont_e, 1);
            }
            if (this.ekw.aLM() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.erT, w.e.cp_cont_e, 1);
            }
        }
    }

    public void aOc() {
        if (this.erR == null) {
            aOa();
        }
        this.erp.setVisibility(8);
        if (this.etD != null && this.etE != null) {
            this.etD.removeCallbacks(this.etE);
        }
    }

    public void aOd() {
        if (this.etD != null) {
            if (this.etE != null) {
                this.etD.removeCallbacks(this.etE);
            }
            this.etE = new fb(this);
            this.etD.postDelayed(this.etE, 2000L);
        }
    }

    public void iQ(boolean z) {
        this.erm.iQ(z);
        if (z && this.esO) {
            this.esd.setText(this.ekw.getResources().getString(w.l.click_load_more));
            this.mListView.setNextPage(this.esd);
            this.erl = 2;
        }
    }

    public void aOe() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.dVV.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KO = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dVV.addView(this.KO, layoutParams);
        this.KO.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.KO.hide();
    }

    public void aOf() {
        if (this.ekw != null && this.KO != null) {
            this.KO.mp();
        }
    }

    public void nF(String str) {
        if (this.esH != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.esH.setText(this.ekw.getPageContext().getResources().getString(w.l.pb_reply_count_text, str));
        }
    }

    public void P(String str, boolean z) {
        this.esL = z;
        iR(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void iR(boolean z) {
        if (this.esJ != null) {
            if (this.esL) {
                com.baidu.tbadk.core.util.aq.j(this.esJ, w.g.pb_praise_already_click_selector);
                this.esJ.setContentDescription(this.ekw.getResources().getString(w.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aq.j(this.esJ, w.g.pb_praise_normal_click_selector);
            this.esJ.setContentDescription(this.ekw.getResources().getString(w.l.frs_item_praise_text));
        }
    }

    public TextView aOg() {
        return this.esJ;
    }

    public void iS(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
                return;
            }
            if (this.ete == null) {
                this.ete = new fc(this, z);
            }
            com.baidu.adp.lib.g.h.fS().postDelayed(this.ete, 10L);
        }
    }

    public void iT(boolean z) {
        if (this.mListView != null && this.avF != null && this.bJu != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bJu.setVisibility(0);
                    aOw();
                } else {
                    this.bJu.setVisibility(8);
                    this.mListView.removeHeaderView(this.avF);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.avF.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.avF.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.avF.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jb(true);
                this.avF.setLayoutParams(layoutParams2);
            }
            aOw();
            aOR();
        }
    }

    public void aZ(View view) {
        boolean z;
        View view2;
        if (this.erX != null && view != null) {
            if (this.esK) {
                z = this.esF.getVisibility() == 0;
            } else {
                z = this.KO != null && this.KO.getVisibility() == 0;
            }
            boolean z2 = this.erX.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.elc = true;
                View findViewById = this.ekw.findViewById(w.h.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.erX.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.ekw, this.erX, w.a.top_fold_up, new fd(this, findViewById));
            } else {
                this.elc = false;
                com.baidu.tieba.tbadkCore.a.a(this.ekw, this.erX, w.a.top_fold_down, new fe(this));
            }
            if (this.esK) {
                view2 = this.esF;
            } else {
                view2 = this.KO;
            }
            if (z) {
                if (z2) {
                    if (this.KO != null) {
                        this.KO.BC();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.ekw, view2, w.a.bottom_fold_down, new ff(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.ekw, view2, w.a.bottom_fold_up, new fg(this));
            }
            aMy();
        }
    }

    public cn aOh() {
        return this.erY;
    }

    public void aOi() {
        if (this.erY != null) {
            this.erY.aMb();
        }
    }

    public void a(PbActivity.c cVar) {
        this.elV = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bn bnVar) {
        if (bnVar == null || bnVar.tD() == 0) {
            if (this.esE != null) {
                this.esE.setVisibility(8);
            }
            if (this.erU != null) {
                this.erU.setVisibility(8);
                return;
            }
            return;
        }
        if (this.esE == null) {
            this.ekw.getLayoutMode().t(((ViewStub) this.err.findViewById(w.h.live_talk_layout)).inflate());
            this.esE = (Button) this.err.findViewById(w.h.pb_head_function_manage_go_to_live_post);
            this.erU = this.err.findViewById(w.h.new_pb_header_item_line_above_livepost);
        }
        int tE = bnVar.tE();
        String string = this.ekw.getPageContext().getString(w.l.go_to_live_post_prefix);
        if (tE == 0) {
            string = String.valueOf(string) + this.ekw.getPageContext().getString(w.l.go_to_interview_post);
        } else if (tE == 1) {
            string = String.valueOf(string) + this.ekw.getPageContext().getString(w.l.go_to_discuss_post);
        }
        this.esE.setText(string);
        this.esE.setVisibility(0);
        this.esE.setOnClickListener(this.bQO);
        this.etJ = true;
        aOx();
    }

    public void ba(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.esh == null) {
            this.esh = LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.ekw.getLayoutMode().t(this.esh);
        if (this.esg == null) {
            this.esg = new Dialog(this.ekw.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.esg.setCanceledOnTouchOutside(true);
            this.esg.setCancelable(true);
            this.esg.setContentView(this.esh);
            WindowManager.LayoutParams attributes = this.esg.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.ekw.getPageContext().getPageActivity()) * 0.9d);
            this.esg.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.esg.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.esg.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.esg.findViewById(w.h.disable_reply_btn);
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
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name)) || aON()) {
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
        com.baidu.adp.lib.g.j.a(this.esg, this.ekw.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.etG = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(esX, Integer.valueOf(esY));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.esi = new com.baidu.tbadk.core.dialog.a(this.ekw.getActivity());
        this.esi.bZ(i3);
        this.esi.A(sparseArray);
        this.esi.a(w.l.dialog_ok, this.ekw);
        this.esi.b(w.l.dialog_cancel, new fl(this));
        this.esi.av(true);
        this.esi.b(this.ekw.getPageContext());
        this.esi.tQ();
    }

    public void al(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.esu == null) {
            this.esu = LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.commit_good, (ViewGroup) null);
        }
        this.ekw.getLayoutMode().t(this.esu);
        if (this.est == null) {
            this.est = new Dialog(this.ekw.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.est.setCanceledOnTouchOutside(true);
            this.est.setCancelable(true);
            this.esD = (ScrollView) this.esu.findViewById(w.h.good_scroll);
            this.est.setContentView(this.esu);
            WindowManager.LayoutParams attributes = this.est.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds540);
            this.est.getWindow().setAttributes(attributes);
            this.esw = new fm(this);
            this.esv = (LinearLayout) this.esu.findViewById(w.h.good_class_group);
            this.esy = (TextView) this.esu.findViewById(w.h.dialog_button_cancel);
            this.esy.setOnClickListener(new fn(this));
            this.esx = (TextView) this.esu.findViewById(w.h.dialog_button_ok);
            this.esx.setOnClickListener(this.bQO);
        }
        this.esv.removeAllViews();
        this.erq = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bL = bL("0", this.ekw.getPageContext().getString(w.l.def_good_class));
        this.erq.add(bL);
        bL.setChecked(true);
        this.esv.addView(bL);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bL2 = bL(String.valueOf(arrayList.get(i2).qL()), arrayList.get(i2).qK());
                this.erq.add(bL2);
                View view = new View(this.ekw.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds1));
                com.baidu.tbadk.core.util.aq.k(view, w.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.esv.addView(view);
                this.esv.addView(bL2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.esD.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ekw.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ekw.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ekw.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.esD.setLayoutParams(layoutParams2);
            this.esD.removeAllViews();
            this.esD.addView(this.esv);
        }
        com.baidu.adp.lib.g.j.a(this.est, this.ekw.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bL(String str, String str2) {
        Activity pageActivity = this.ekw.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds100));
        aVar.setOnCheckedChangeListener(this.esw);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aOj() {
        this.ekw.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.ekw.hideProgressBar();
        if (z && z2) {
            this.ekw.showToast(this.ekw.getPageContext().getString(w.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(w.l.neterror);
            }
            this.ekw.showToast(str);
        }
    }

    public void ast() {
        this.esf.setVisibility(0);
    }

    public void ass() {
        this.esf.setVisibility(8);
    }

    public View aOk() {
        if (this.esu != null) {
            return this.esu.findViewById(w.h.dialog_button_ok);
        }
        return null;
    }

    public String aOl() {
        return this.esz;
    }

    public View getView() {
        return this.dVV;
    }

    public void aOm() {
        com.baidu.adp.lib.util.k.b(this.ekw.getPageContext().getPageActivity(), this.ekw.getCurrentFocus());
    }

    public void iU(boolean z) {
        this.ekw.hideProgressBar();
        axI();
    }

    public void aOn() {
        this.esd.xd();
    }

    public void aOo() {
        this.ekw.hideProgressBar();
        this.esd.xe();
        aJt();
        this.mListView.completePullRefreshPostDelayed(2000L);
        aOx();
    }

    public void aOp() {
        this.mListView.completePullRefreshPostDelayed(2000L);
        aOx();
    }

    public void iV(boolean z) {
        this.erz.f(this.erz.aMz(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.esI.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.ekw.getResources().getDimensionPixelSize(w.f.ds84) : 0;
        this.esI.setLayoutParams(marginLayoutParams);
    }

    private void iW(boolean z) {
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.esI.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.esI.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tbadk.core.data.af afVar) {
        this.erz.b(afVar);
    }

    public boolean aMw() {
        return this.erz.aMw();
    }

    public void aMx() {
        this.erz.aMx();
    }

    public void aMy() {
        this.erz.aMy();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.erY.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.esA != null) {
            this.esA.dismiss();
            this.esA = null;
        }
        this.esA = new com.baidu.tbadk.core.dialog.c(this.ekw.getPageContext().getPageActivity());
        this.esA.cc(w.l.operation);
        if (z2) {
            this.esA.a(new String[]{this.ekw.getPageContext().getString(w.l.copy)}, bVar);
        } else if (!z) {
            this.esA.a(new String[]{this.ekw.getPageContext().getString(w.l.copy), this.ekw.getPageContext().getString(w.l.mark)}, bVar);
        } else {
            this.esA.a(new String[]{this.ekw.getPageContext().getString(w.l.copy), this.ekw.getPageContext().getString(w.l.remove_mark)}, bVar);
        }
        this.esA.d(this.ekw.getPageContext());
        this.esA.tT();
    }

    public int aOq() {
        return oy(this.mListView.getFirstVisiblePosition());
    }

    private int oy(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.mListView.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.ll()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.mListView.getAdapter() == null || !(this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aOr() {
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        if (this.erf != null) {
            if (lastVisiblePosition == this.mListView.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.erY.aMc();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return oy(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.mListView.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.esb.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void k(com.baidu.tieba.pb.data.f fVar) {
        this.erY.b(fVar);
        this.erY.notifyDataSetChanged();
        if (fVar == null) {
            nF("");
        } else {
            nF(com.baidu.tbadk.core.util.au.w(fVar.aKy().sh()));
        }
        aOx();
    }

    public void l(com.baidu.tieba.pb.data.f fVar) {
        PraiseData se;
        if (this.erO == null) {
            this.ekw.getLayoutMode().t(((ViewStub) this.err.findViewById(w.h.praise_layout)).inflate());
            this.erO = (FrsPraiseView) this.err.findViewById(w.h.pb_head_praise_view);
            this.erO.setIsFromPb(true);
            this.erW = this.err.findViewById(w.h.new_pb_header_item_line_above_praise);
            this.erO.m24do(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.erO != null) {
            boolean aOx = aOx();
            if (fVar != null && fVar.aKA() != null && fVar.aKA().size() > 0) {
                PostData postData = fVar.aKA().get(0);
                if ((!this.ejw || postData.bjp() != 1) && (se = fVar.aKy().se()) != null && se.getUser() != null && se.getUser().size() > 0) {
                    this.erO.setVisibility(0);
                    this.erO.setIsFromPb(true);
                    this.erO.a(se, fVar.aKy().getId(), se.getPostId(), true);
                    this.erO.getVisibility();
                    com.baidu.tieba.graffiti.c.al(this.erO);
                    return;
                }
            }
            this.erO.setVisibility(8);
            if (fVar != null && fVar.rr() != null && fVar.rr().ro() == 0 && this.ejw) {
                if (aOx) {
                    this.erV.setVisibility(0);
                } else {
                    this.erV.setVisibility(8);
                }
            } else {
                this.erV.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.al(this.erV);
        }
    }

    private PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aKH() != null) {
            return fVar.aKH();
        }
        if (z) {
            if (fVar == null || fVar.aKA() == null || fVar.aKA().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aKA().get(0);
            if (postData.bjp() != 1) {
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
        if (fVar == null || fVar.aKy() == null || fVar.aKy().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aKy().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aKy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.rY(1);
        postData.setId(fVar.aKy().sE());
        postData.setTitle(fVar.aKy().getTitle());
        postData.setTime(fVar.aKy().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        boolean z2;
        int i2;
        if (fVar != null && fVar.aKy() != null) {
            this.etf.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds30), 0, 0);
            PostData c = c(fVar, z);
            a(c, fVar);
            aOO();
            this.erA.setVisibility(8);
            if (fVar.aKy() != null && fVar.aKy().tb() && fVar.aKy().sF() != null) {
                this.erm.jg(true);
                if (this.erf == null || this.eri == null) {
                    aOs();
                    this.erf.a(fVar.aKy().sF(), fVar.aKy(), fVar.getForumId());
                    this.erf.startPlay();
                } else if (this.erg) {
                    this.erf.a(fVar.aKy().sF(), fVar.aKy(), fVar.getForumId());
                    this.erf.startPlay();
                }
                if (fVar.aKz() != null && fVar.aKz().size() >= 1) {
                    com.baidu.tbadk.core.data.bi biVar = fVar.aKz().get(0);
                    this.erf.G(biVar);
                    this.erf.nT(biVar.getTitle());
                }
                this.erg = false;
                if (this.esT == null) {
                    this.esT = new TextView(this.ekw.getActivity());
                    this.esT.setLayoutParams(new AbsListView.LayoutParams(-1, this.ere));
                }
                this.mListView.removeHeaderView(this.esT);
                this.mListView.addHeaderView(this.esT, 0);
                if (this.erh == null) {
                    this.erh = new com.baidu.tieba.pb.video.a(LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.pb_header_video_abstract_layout, (ViewGroup) null));
                }
                this.erh.F(fVar.aKy());
                this.mListView.removeHeaderView(this.erh.mRootView);
                this.mListView.addHeaderView(this.erh.mRootView, 1);
                if (fVar.aKy().ts() != null) {
                    m(fVar);
                    this.mListView.removeHeaderView(this.erj.mRootView);
                    this.mListView.removeHeaderView(this.erv);
                    this.mListView.addHeaderView(this.erj.mRootView, 2);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erh.ewR.getLayoutParams();
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds26);
                    this.erh.ewR.setLayoutParams(layoutParams);
                } else {
                    if (this.erj != null && this.erj.mRootView != null) {
                        this.mListView.removeHeaderView(this.erj.mRootView);
                    }
                    if (com.baidu.adp.lib.b.e.eZ().Y("video_channel_pb_portrait_switch") == 0) {
                        h(c);
                        this.mListView.removeHeaderView(this.erv);
                        this.mListView.removeHeaderView(this.erk);
                        this.mListView.addHeaderView(this.erk, 2);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.erh.ewR.getLayoutParams();
                        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds30);
                        this.erh.ewR.setLayoutParams(layoutParams2);
                    } else {
                        aOt();
                        if (this.erk != null) {
                            this.mListView.removeHeaderView(this.erk);
                        }
                        this.mListView.removeHeaderView(this.erv);
                        this.mListView.addHeaderView(this.erv, 2);
                    }
                }
                if (this.erf != null) {
                    this.erf.oB(0);
                }
                aOw();
                z2 = true;
            } else {
                this.erm.jg(false);
                if (this.erd != null) {
                    this.erd.setVisibility(8);
                }
                if (this.esT != null) {
                    this.mListView.removeHeaderView(this.esT);
                }
                if (this.erh != null) {
                    this.mListView.removeHeaderView(this.erh.mRootView);
                }
                if (this.erj != null) {
                    this.mListView.removeHeaderView(this.erj.mRootView);
                }
                z2 = false;
            }
            if (this.ekw.aLq() != null) {
                this.ekw.aLq().je(z2);
            }
            fo foVar = new fo(this, z2);
            if (this.erk != null) {
                this.erk.setOnClickListener(foVar);
            }
            b(fVar, z);
            if (c != null) {
                this.esN = c;
                String str = null;
                boolean z3 = false;
                if (fVar != null && fVar.aKy() != null && fVar.aKy().getAuthor() != null) {
                    str = fVar.aKy().getAuthor().getUserId();
                    if (fVar.rr() != null) {
                        this.eto = fVar.rr().rk();
                        z3 = fVar.rr().rn() == 1;
                    }
                }
                boolean ta = fVar.aKy().ta();
                if (c.getAuthor() != null && c.getAuthor().getUserTbVipInfoData() != null) {
                    this.aiH = !StringUtils.isNull(c.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.etk = !ta && a(fVar, c, fVar.aKy().getId(), str, z3, z);
                this.erA.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.erA.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.erA.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_clip_board, c);
                sparseArray.put(w.h.tag_is_subpb, false);
                fVar.aKy().sX();
                if (!this.etx) {
                    this.ert.setVisibility(0);
                }
                if (!fVar.aKy().tb() && this.eru.getText() != null && this.eru.getText().length() > 0) {
                    this.eru.setVisibility(0);
                } else {
                    this.eru.setVisibility(8);
                }
                l(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> sz = fVar.aKy().sz();
                if (sz != null && sz.size() > 0 && !this.etx) {
                    this.esQ.setText(String.valueOf(sz.get(0).pI()));
                    this.esP.setVisibility(0);
                    this.etI = true;
                } else {
                    this.esP.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.j(this.esP, w.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aq.c(this.esQ, w.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    int is_bawu = c.getAuthor().getIs_bawu();
                    String bawu_type = c.getAuthor().getBawu_type();
                    int i3 = 3;
                    if (this.rank != 0) {
                        this.erG.setVisibility(0);
                        com.baidu.tbadk.core.util.aq.c(this.erG, BitmapHelper.getGradeResourceIdNew(this.rank));
                        this.erG.setAlpha(179);
                        this.erG.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.rank)));
                        this.erG.setOnClickListener(null);
                    } else {
                        this.erG.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.erH.setAlpha(179);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.aq.c(this.erH, w.g.pb_manager);
                            this.erG.setVisibility(8);
                            this.erH.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.aq.c(this.erH, w.g.pb_assist);
                            this.erG.setVisibility(8);
                            this.erH.setVisibility(0);
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
                    if (this.erI != null) {
                        this.erI.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.erI.setOnClickListener(this.ekw.elj.bYW);
                        this.erI.xr();
                        this.erI.a(iconInfo, i3, this.ekw.getResources().getDimensionPixelSize(w.f.ds30), this.ekw.getResources().getDimensionPixelSize(w.f.ds30), this.ekw.getResources().getDimensionPixelSize(w.f.ds10));
                    }
                    if (this.erJ != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.erJ.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.erJ.setOnClickListener(this.ekw.elj.eub);
                        this.erJ.a(tShowInfoNew, 3, this.ekw.getResources().getDimensionPixelSize(w.f.ds32), this.ekw.getResources().getDimensionPixelSize(w.f.ds32), this.ekw.getResources().getDimensionPixelSize(w.f.ds8), true);
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aF(string) > 12) {
                            string = com.baidu.tbadk.core.util.au.d(string, 12, "...");
                        }
                    } else if (com.baidu.adp.lib.util.j.aF(string) > 14) {
                        string = com.baidu.tbadk.core.util.au.d(string, 14, "...");
                    }
                    this.erC.setText(af(c.getAuthor().getSealPrefix(), string));
                    this.erC.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                    this.erC.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                    if (!com.baidu.tbadk.core.util.x.q(tShowInfoNew)) {
                        com.baidu.tbadk.core.util.aq.c(this.erC, w.e.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.aq.c(this.erC, w.e.cp_cont_f, 1);
                    }
                    if (fVar.aKy().getAuthor() != null && fVar.aKy().getAuthor().getAlaUserData() != null && this.erK != null) {
                        if (fVar.aKy().getAuthor().getAlaUserData().anchor_live == 0 && fVar.aKy().getAuthor().getAlaUserData().enter_live == 0) {
                            this.erK.setVisibility(8);
                        } else {
                            this.erK.setVisibility(0);
                            com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                            bVar.QS = fVar.aKy().getAuthor().getAlaUserData();
                            bVar.type = 2;
                            this.erK.setTag(bVar);
                        }
                    }
                    this.erF.setUserId(c.getAuthor().getUserId());
                    this.erF.setUserName(c.getAuthor().getUserName());
                    this.erF.setImageDrawable(null);
                    this.erF.setRadius(com.baidu.adp.lib.util.k.g(this.ekw.getActivity(), w.f.ds40));
                    this.erF.setTag(c.getAuthor().getUserId());
                    this.erQ.a(c.getAuthor());
                    this.erQ.eqX = z2;
                    if (!PbNormalLikeButtonSwitchStatic.GZ() || this.esC || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.erP.setVisibility(8);
                    } else {
                        this.erP.setVisibility(0);
                    }
                    String portrait = c.getAuthor().getPortrait();
                    if (c.getAuthor() != null && c.getAuthor().getPendantData() != null && !StringUtils.isNull(c.getAuthor().getPendantData().qB())) {
                        this.erF.setVisibility(8);
                        this.erE.setVisibility(0);
                        if (this.epP != null) {
                            this.epP.setVisibility(8);
                        }
                        this.erC.setOnClickListener(foVar);
                        this.erE.getHeadView().c(portrait, 28, false);
                        this.erE.getHeadView().setUserId(c.getAuthor().getUserId());
                        this.erE.getHeadView().setUserName(c.getAuthor().getUserName());
                        this.erE.getHeadView().setOnClickListener(foVar);
                        this.erE.dU(c.getAuthor().getPendantData().qB());
                    } else if (this.aiH) {
                        this.erF.setVisibility(0);
                        UserTbVipInfoData userTbVipInfoData = c.getAuthor().getUserTbVipInfoData();
                        if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.bbW != null) {
                            if (this.bbX == null) {
                                this.bbW.inflate();
                                this.bbX = (TbImageView) this.erv.findViewById(w.h.user_head_mask);
                            }
                            this.bbX.c(userTbVipInfoData.getvipV_url(), 10, false);
                        }
                        this.erC.setOnClickListener(foVar);
                        this.erF.setOnClickListener(foVar);
                        this.erE.setVisibility(8);
                    } else {
                        if (this.etk) {
                            fp fpVar = new fp(this, c, z2);
                            if (this.erk != null) {
                                this.erk.setOnClickListener(fpVar);
                            }
                            this.erC.setOnClickListener(fpVar);
                            this.erF.setOnClickListener(fpVar);
                            this.erA.setOnClickListener(fpVar);
                            this.erF.setVisibility(8);
                            this.erE.setVisibility(8);
                        } else {
                            this.erF.setVisibility(0);
                            this.erA.setOnClickListener(foVar);
                            this.erC.setOnClickListener(foVar);
                            this.erF.setOnClickListener(foVar);
                        }
                        this.erE.setVisibility(8);
                    }
                    this.erF.c(portrait, 28, false);
                }
                if (fVar != null) {
                    this.ery.D(fVar.aKy());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.sJ() != null) {
            this.erB.a(this.ekw.getPageContext(), fVar.aKA().get(0).sJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aKx().getId(), fVar.aKx().getName(), fVar.aKy().getId(), this.ekw.aLS() ? "FRS" : null));
            this.erA.setPadding(this.erA.getPaddingLeft(), (int) this.ekw.getResources().getDimension(w.f.ds20), this.erA.getPaddingRight(), this.erA.getPaddingBottom());
            return;
        }
        this.erB.a(null, null, null);
    }

    private void aOs() {
        this.erd = (FrameLayout) this.ekw.findViewById(w.h.root_float_header);
        int af = com.baidu.adp.lib.util.k.af(this.ekw.getActivity());
        int i = (int) (af * 0.5625d);
        this.ere = i;
        this.erd.setLayoutParams(new RelativeLayout.LayoutParams(af, i));
        this.eri = new com.baidu.tieba.play.c(this.ekw.getPageContext(), this.erd);
        this.erf = new com.baidu.tieba.pb.video.d(this.ekw, this.eri, this.erd, this.erm, this.ere);
    }

    private void m(com.baidu.tieba.pb.data.f fVar) {
        if (this.erj == null) {
            this.erj = new com.baidu.tieba.pb.video.b(this.ekw, LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.video_pb_video_channel_info_layout, (ViewGroup) null));
        }
        com.baidu.tbadk.core.data.bp ts = fVar.aKy().ts();
        if (fVar.getUserData() != null) {
            ts.ZY = fVar.aKQ();
        }
        this.erj.b(ts);
        fVar.aKy().a(ts);
    }

    private void h(PostData postData) {
        if (this.erk == null) {
            this.erk = new TextView(this.ekw.getActivity());
            this.erk.setClickable(true);
            this.erk.setTextSize(0, this.ekw.getResources().getDimensionPixelSize(w.f.fontsize24));
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            this.erk.setSingleLine(true);
            this.erk.setEllipsize(TextUtils.TruncateAt.END);
            this.erk.setLayoutParams(layoutParams);
            this.erk.setGravity(16);
            int g = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds32);
            this.erk.setPadding(g, 0, g, com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds40));
            com.baidu.tbadk.core.util.aq.c(this.erk, w.e.cp_cont_j, 1);
        }
        String string = this.ekw.getResources().getString(w.l.video_public_owner);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        if (postData != null && postData.getAuthor() != null) {
            String name_show = postData.getAuthor().getName_show();
            this.erk.setTag(w.h.tag_user_id, String.valueOf(postData.getAuthor().getUserId()));
            this.erk.setTag(w.h.tag_user_name, name_show);
            sb.append(" " + name_show);
            SpannableString spannableString = new SpannableString(sb);
            spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), string.length(), sb.length(), 33);
            this.erk.setText(spannableString);
            return;
        }
        this.erk.setText(string);
    }

    private void aOt() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.erh.ewR.getLayoutParams();
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds26);
        this.erh.ewR.setLayoutParams(layoutParams);
        this.erA.setPadding(this.erA.getPaddingLeft(), this.erA.getPaddingTop(), this.erA.getPaddingRight(), com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds34));
        if (this.erP.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.erP.getLayoutParams();
            aVar.bottomMargin = com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds20);
            this.erP.setLayoutParams(aVar);
        }
    }

    public void aOu() {
        if (this.erf != null) {
            this.erf.aQr();
        }
    }

    public boolean aOv() {
        return this.etK;
    }

    private boolean NP() {
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
            this.erm.aPc();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.erm.lp(eVar.forumName);
                if (this.erf != null) {
                    this.erf.aQl();
                }
            }
            String string = this.ekw.getResources().getString(w.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.ekw.getResources().getString(w.l.self);
                    break;
                case 300:
                    str = this.ekw.getResources().getString(w.l.bawu);
                    break;
                case 400:
                    str = this.ekw.getResources().getString(w.l.system);
                    break;
            }
            this.ekw.showNetRefreshView(this.dVV, String.format(string, str), null, this.ekw.getResources().getString(w.l.appeal_restore), true, new fq(this, eVar.eig));
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aNM;
        String sb;
        if (fVar != null) {
            this.enR = fVar;
            this.mType = i;
            if (fVar.aKy() != null) {
                this.esU = fVar.aKy().sc();
                this.Zi = fVar.aKy().rZ();
                if (fVar.aKy().getAnchorLevel() != 0) {
                    this.etK = true;
                }
                this.esC = z(fVar.aKy());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            o(fVar);
            this.esO = false;
            this.ejw = z;
            aOo();
            b(fVar, z, i);
            if (this.ekw.aLI()) {
                if (this.esc == null) {
                    this.esc = new com.baidu.tieba.pb.view.m(this.ekw.getPageContext());
                    this.esc.lf();
                    this.esc.a(this.alq);
                }
                this.mListView.setPullRefresh(this.esc);
                aOw();
                if (this.esc != null) {
                    this.esc.dk(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (fVar.rr().ro() == 0 && z) {
                this.mListView.setPullRefresh(null);
                this.erc = 1;
            } else {
                if (this.esc == null) {
                    this.esc = new com.baidu.tieba.pb.view.m(this.ekw.getPageContext());
                    this.esc.lf();
                    this.esc.a(this.alq);
                }
                this.mListView.setPullRefresh(this.esc);
                aOw();
                this.erc = 2;
                if (this.esc != null) {
                    this.esc.dk(TbadkCoreApplication.m9getInst().getSkinType());
                }
                aJt();
            }
            aOx();
            this.erY.il(this.ejw);
            this.erY.im(false);
            this.erY.b(fVar);
            this.erY.notifyDataSetChanged();
            if (fVar.aKx() != null) {
                this.mForumName = fVar.aKx().getName();
                this.mForumId = fVar.getForumId();
            }
            this.erm.lp(this.mForumName);
            if (this.erf != null) {
                this.erf.aQl();
            }
            if (fVar.aKy() != null) {
                nF(com.baidu.tbadk.core.util.au.w(fVar.aKy().sh()));
                if (fVar.aKy().se() != null) {
                    if (fVar.aKy().se().getNum() < 1) {
                        sb = this.ekw.getResources().getString(w.l.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(fVar.aKy().se().getNum())).toString();
                    }
                    if (this.eqY != -1) {
                        fVar.aKy().se().setIsLike(this.eqY);
                    }
                    P(sb, fVar.aKy().se().getIsLike() == 1);
                }
            }
            if (fVar.rr().rn() == 0 && !z) {
                this.mListView.setNextPage(null);
                this.erl = 1;
            } else if (this.ekw.isLogin()) {
                this.mListView.setNextPage(this.esd);
                this.erl = 2;
                aJt();
            } else if (fVar.rr().rn() == 1) {
                this.esO = true;
                if (this.ese == null) {
                    this.ese = new com.baidu.tieba.pb.view.b(this.ekw.getPageContext());
                }
                this.mListView.setNextPage(this.ese);
                this.erl = 3;
            }
            ArrayList<PostData> aKA = fVar.aKA();
            if (fVar.rr().rn() == 0 || aKA == null || aKA.size() < fVar.rr().rm()) {
                this.esd.setText(this.ekw.getResources().getString(w.l.list_no_more));
                if (this.ekw.aLI() && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() == 1 && (this.mListView.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.esd.setText("");
                }
                aOC();
            } else if (z2) {
                if (this.etH) {
                    xe();
                    if (fVar.rr().rn() != 0) {
                        this.esd.setText(this.ekw.getResources().getString(w.l.pb_load_more));
                    }
                } else {
                    this.esd.xg();
                }
            } else {
                this.esd.xg();
            }
            if (fVar.aKy() != null && fVar.aKy().getAuthor() != null && fVar.aKy().getAuthor().getType() == 0) {
                this.erm.aOZ();
            }
            switch (i) {
                case 2:
                    this.mListView.setSelection(i2 > 1 ? i2 - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aNM = ep.aNL().aNM()) != null) {
                        this.etB = true;
                        this.mListView.onRestoreInstanceState(aNM);
                        break;
                    } else {
                        this.mListView.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.etH = false;
                    this.mListView.setSelection(0);
                    break;
                case 5:
                    this.mListView.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aNM2 = ep.aNL().aNM();
                        this.etB = true;
                        if (aNM2 != null) {
                            this.mListView.onRestoreInstanceState(aNM2);
                            break;
                        }
                    }
                    this.mListView.setSelection(0);
                    break;
            }
            if (this.esU == esW && NP()) {
                aOI();
            }
            if (!this.etB && fVar.aKH() == null && !fVar.aKy().tb()) {
                this.eth.aD(this.ekw.getResources().getString(w.l.pb_more_tools_guide_tip), String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips");
                this.etB = true;
            }
            E(fVar.aKy());
            this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void aOw() {
        if (this.erd != null) {
            this.mListView.removeHeaderView(this.avF);
            this.mListView.removeHeaderView(this.esT);
            this.mListView.addHeaderView(this.esT, 0);
            if (this.mType != 1 && this.erf != null) {
                this.erf.aQo();
                return;
            }
            return;
        }
        this.mListView.removeHeaderView(this.esT);
        this.mListView.removeHeaderView(this.avF);
        this.mListView.addHeaderView(this.avF, 0);
    }

    public void iX(boolean z) {
        this.esB = z;
        this.erm.iX(z);
    }

    public void xe() {
        if (this.esd != null) {
            this.esd.xe();
        }
        aJt();
    }

    public void KZ() {
        this.mListView.setVisibility(0);
    }

    private boolean aOx() {
        boolean z;
        if (this.esE != null && this.esE.getVisibility() == 0) {
            z = true;
            if (this.erU != null) {
                this.erU.setVisibility(0);
            }
        } else {
            if (this.erU != null) {
                this.erU.setVisibility(8);
            }
            z = false;
        }
        if ((this.erW == null || this.erW.getVisibility() == 8) && z && this.ejw) {
            this.erV.setVisibility(0);
        } else {
            this.erV.setVisibility(8);
        }
        com.baidu.tieba.graffiti.c.al(this.erV);
        return z;
    }

    private boolean n(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aKy() == null) {
            return false;
        }
        if (fVar.aKy().sm() == 1 || fVar.aKy().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aKy().so() == null || fVar.aKy().so().tD() == 0) || fVar.aKy().sk() == 1 || fVar.aKy().sl() == 1 || fVar.aKy().sT() || fVar.aKy().tg() || fVar.aKy().ta() || fVar.aKy().sA() != null || fVar.aKy().th() || fVar.aKy().th() || !com.baidu.tbadk.core.util.au.isEmpty(fVar.aKy().sg()) || fVar.aKy().sr();
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return com.baidu.tieba.card.at.a((Context) this.ekw.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.ert != null) {
                if (fVar.aKy() != null && fVar.aKy().sD() == 0 && !fVar.aKy().tb() && !this.etx) {
                    this.ert.setVisibility(0);
                    fVar.aKy().sX();
                    if (fVar.aKy() != null) {
                        fVar.aKy().e(true, n(fVar));
                    }
                    SpannableStringBuilder sO = fVar.aKy().sO();
                    this.eru.setOnTouchListener(new com.baidu.tieba.view.x(sO));
                    if (sO == null || sO.length() == 0) {
                        this.eru.setVisibility(8);
                    } else {
                        this.eru.setText(sO);
                        this.eru.setVisibility(0);
                    }
                    this.erA.setPadding(this.erA.getPaddingLeft(), this.erA.getPaddingTop(), com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds32), this.erA.getPaddingBottom());
                } else {
                    this.ert.setVisibility(8);
                    this.mListView.removeHeaderView(this.ert);
                    if (fVar.aKy() != null && fVar.aKy().tb()) {
                        this.erA.setPadding(this.erA.getPaddingLeft(), 0, this.erA.getPaddingRight(), this.erA.getPaddingBottom());
                    } else {
                        this.erA.setPadding(this.erA.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds48), this.erA.getPaddingRight(), this.erA.getPaddingBottom());
                    }
                }
            }
            this.ejw = z;
            com.baidu.tbadk.core.data.bi aKy = fVar.aKy();
            if (aKy != null) {
                a(aKy.so());
            }
        }
        return false;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aOx();
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
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aKI()));
            sparseArray.put(w.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(w.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(w.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(w.h.tag_del_post_id, c.getId());
            sparseArray.put(w.h.tag_del_post_type, 0);
            sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aKI()));
            sparseArray.put(w.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aFp;
    }

    public void nG(String str) {
        if (this.esd != null && !StringUtils.isNull(str)) {
            this.esd.setText(str);
        }
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public int aOy() {
        return w.h.richText;
    }

    public TextView aLm() {
        return this.ery.aLm();
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(ab.b bVar) {
        this.alq = bVar;
        if (this.esc != null) {
            this.esc.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int rl = apVar.rl();
            int ri = apVar.ri();
            if (this.erZ != null) {
                this.erZ.tQ();
            } else {
                this.erZ = new com.baidu.tbadk.core.dialog.a(this.ekw.getPageContext().getPageActivity());
                this.esa = LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.dialog_direct_pager, (ViewGroup) null);
                this.erZ.v(this.esa);
                this.erZ.a(w.l.dialog_ok, bVar);
                this.erZ.b(w.l.dialog_cancel, new fr(this));
                this.erZ.a(new ft(this));
                this.erZ.b(this.ekw.getPageContext()).tQ();
            }
            this.esb = (EditText) this.esa.findViewById(w.h.input_page_number);
            this.esb.setText("");
            TextView textView = (TextView) this.esa.findViewById(w.h.current_page_number);
            if (rl <= 0) {
                rl = 1;
            }
            if (ri <= 0) {
                ri = 1;
            }
            textView.setText(MessageFormat.format(this.ekw.getApplicationContext().getResources().getString(w.l.current_page), Integer.valueOf(rl), Integer.valueOf(ri)));
            this.ekw.ShowSoftKeyPadDelay(this.esb, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.ekw.showToast(str);
    }

    public boolean iY(boolean z) {
        if (this.KO == null || !this.KO.Dq()) {
            return false;
        }
        this.KO.BC();
        return true;
    }

    public void aOz() {
        if (this.etL != null) {
            while (this.etL.size() > 0) {
                TbImageView remove = this.etL.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aOz();
        this.erY.ol(1);
        if (this.erf != null) {
            this.erf.onPause();
        }
    }

    public void onResume() {
        this.erY.ol(2);
        if (this.erf != null) {
            this.erf.onResume();
        }
    }

    public void onDestroy() {
        this.eth.VI();
        if (this.eti != null) {
            this.eti.VI();
        }
        this.ekw.hideProgressBar();
        if (this.bGI != null && this.bOn != null) {
            this.bGI.b(this.bOn);
        }
        axI();
        this.esd.xe();
        if (this.etd != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.etd);
        }
        if (this.ete != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.ete);
        }
        aOF();
        if (this.etw != null) {
            this.etw.removeAllViews();
        }
        if (this.erA != null && this.epP != null) {
            this.erA.removeView(this.erD);
            this.epP = null;
        }
        if (this.esS != null) {
            this.esS.clearStatus();
        }
        this.etD = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.erY.ol(3);
        if (this.bJu != null) {
            this.bJu.setBackgroundDrawable(null);
        }
        if (this.erf != null) {
            this.erf.destroy();
        }
    }

    public boolean oz(int i) {
        if (this.erf != null) {
            return this.erf.oz(i);
        }
        return false;
    }

    public void axI() {
        this.erm.oI();
        this.eth.VI();
        com.baidu.adp.lib.util.k.b(this.ekw.getPageContext().getPageActivity(), this.esb);
        if (this.esA != null) {
            this.esA.dismiss();
        }
        aOA();
        if (this.eti != null) {
            this.eti.VI();
        }
        if (this.erZ != null) {
            this.erZ.dismiss();
        }
        if (this.bQF != null) {
            this.bQF.dismiss();
        }
    }

    public void ik(boolean z) {
        this.erY.ik(z);
    }

    public void gL(boolean z) {
        this.drA = z;
    }

    public void aOA() {
        if (this.esi != null) {
            this.esi.dismiss();
        }
        if (this.esj != null) {
            com.baidu.adp.lib.g.j.b(this.esj, this.ekw.getPageContext());
        }
        if (this.est != null) {
            com.baidu.adp.lib.g.j.b(this.est, this.ekw.getPageContext());
        }
        if (this.esg != null) {
            com.baidu.adp.lib.g.j.b(this.esg, this.ekw.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.enR, this.ejw);
            d(this.enR, this.ejw, this.mType);
            a(this.enR, this.esN, i);
            this.ekw.getLayoutMode().aj(i == 1);
            this.ekw.getLayoutMode().t(this.dVV);
            this.ekw.getLayoutMode().t(this.eru);
            this.ekw.getLayoutMode().t(this.erv);
            this.ekw.getLayoutMode().t(this.err);
            if (this.erN != null) {
                com.baidu.tbadk.core.util.aq.c(this.erN, w.e.cp_cont_d, 1);
            }
            if (this.erM != null) {
                com.baidu.tbadk.core.util.aq.c(this.erM, w.e.cp_cont_d, 1);
            }
            if (this.rank > 0) {
                com.baidu.tbadk.core.util.aq.c(this.erG, BitmapHelper.getGradeResourceIdNew(this.rank));
            }
            if (this.erh != null) {
                this.erh.Bn();
            }
            if (this.erj != null) {
                this.erj.Bn();
            }
            if (this.erk != null) {
                com.baidu.tbadk.core.util.aq.c(this.erk, w.e.cp_cont_j, 1);
                String string = this.ekw.getResources().getString(w.l.video_public_owner);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (this.erk.getTag(w.h.tag_user_name) instanceof String) {
                    sb.append((String) this.erk.getTag(w.h.tag_user_name));
                    SpannableString spannableString = new SpannableString(sb);
                    spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_a)), string.length(), sb.length(), 33);
                    this.erk.setText(spannableString);
                } else {
                    this.erk.setText(string);
                }
            }
            this.ekw.getLayoutMode().t(this.err);
            com.baidu.tbadk.core.util.aq.i(this.eru, w.e.cp_cont_b);
            this.eru.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.ekw.getLayoutMode().t(this.aFp);
            if (this.esa != null) {
                this.ekw.getLayoutMode().t(this.esa);
            }
            iX(this.esB);
            this.erY.notifyDataSetChanged();
            if (this.esc != null) {
                this.esc.dk(i);
            }
            if (this.esd != null) {
                this.esd.dk(i);
                com.baidu.tbadk.core.util.aq.j(this.aFp, w.g.pb_foot_more_trans_selector);
                this.esd.di(w.g.pb_foot_more_trans_selector);
            }
            if (this.KO != null) {
                this.KO.onChangeSkinType(i);
            }
            if (this.erO != null) {
                this.erO.m24do(i);
            }
            if (this.ese != null) {
                this.ese.dk(i);
            }
            if (this.erq != null && this.erq.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.erq) {
                    aVar.aOV();
                }
            }
            if (this.etw != null) {
                com.baidu.tbadk.core.util.aq.k(this.etw, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.k(this.etq, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aq.c(this.etv, w.e.cp_cont_c, 1);
            }
            iR(i == 1);
            this.erz.changeSkinType(i);
            aOb();
            UtilHelper.setStatusBarBackground(this.bJu, i);
            if (this.erP != null) {
                this.erP.onChangeSkinType(i);
            }
            if (this.erR != null) {
                com.baidu.tbadk.m.a.a(this.ekw.getPageContext(), this.erR);
            }
            if (this.etg != null) {
                this.etg.onChangeSkinType(i);
            }
            if (this.erm != null) {
                if (this.erf != null) {
                    this.erf.oB(i);
                } else {
                    this.erm.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNM = eVar;
        this.erY.setOnImageClickListener(this.aNM);
    }

    public void h(NoNetworkView.a aVar) {
        this.bOn = aVar;
        if (this.bGI != null) {
            this.bGI.a(this.bOn);
        }
    }

    public void iZ(boolean z) {
        this.erY.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aOB() {
        return this.esE;
    }

    public void aOC() {
        if (this.erl != 2) {
            this.mListView.setNextPage(this.esd);
            this.erl = 2;
        }
    }

    public void aOD() {
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
                                perfLog.aGx = true;
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
                        perfLog2.aGx = true;
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

    public void gM(boolean z) {
        if (this.esF != null && this.esF != null) {
            if (this.drA) {
                gN(z);
            } else {
                gO(z);
            }
        }
    }

    public void aOE() {
        if (this.esF != null) {
            this.esF.setVisibility(8);
        }
    }

    public void avw() {
        if (this.esM == null) {
            this.esM = new com.baidu.tbadk.core.view.a(this.ekw.getPageContext());
        }
        this.esM.aK(true);
    }

    public void aJt() {
        if (this.esM != null) {
            this.esM.aK(false);
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
                if (this.etm == null || this.mSkinType != i) {
                    if (this.etm == null) {
                        this.etm = (LinearLayout) LayoutInflater.from(this.ekw.getActivity()).inflate(w.j.god_floating_view, (ViewGroup) null);
                    }
                    this.etm.setOnClickListener(fvVar);
                    this.etm.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
                    this.etm.setTag(w.h.tag_user_name, userName);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.etm.findViewById(w.h.god_floating_owner_photo);
                    if (this.aiH) {
                        ViewStub viewStub = (ViewStub) this.etm.findViewById(w.h.viewstub_headimage_mask);
                        if (viewStub != null && 0 == 0) {
                            viewStub.inflate();
                            TbImageView tbImageView = (TbImageView) this.etm.findViewById(w.h.user_head_mask);
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
                    ImageView imageView = (ImageView) this.etm.findViewById(w.h.god_floating_owner_info_user_rank);
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
                    ImageView imageView2 = (ImageView) this.etm.findViewById(w.h.god_floating_owner_info_user_bawu);
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
                    UserIconBox userIconBox = (UserIconBox) this.etm.findViewById(w.h.god_floating_owner_info_user_icon);
                    UserIconBox userIconBox2 = (UserIconBox) this.etm.findViewById(w.h.god_floating_owner_info_tshow_icon);
                    if (userIconBox != null) {
                        userIconBox.setTag(w.h.tag_user_id, postData.getAuthor().getUserId());
                        userIconBox.setOnClickListener(this.ekw.elj.bYW);
                        userIconBox.a(iconInfo, i2, this.ekw.getResources().getDimensionPixelSize(w.f.ds30), this.ekw.getResources().getDimensionPixelSize(w.f.ds30), this.ekw.getResources().getDimensionPixelSize(w.f.ds10));
                    }
                    if (userIconBox2 != null) {
                        userIconBox2.setOnClickListener(this.ekw.elj.eub);
                        userIconBox2.a(tShowInfoNew, 3, this.ekw.getResources().getDimensionPixelSize(w.f.ds32), this.ekw.getResources().getDimensionPixelSize(w.f.ds32), this.ekw.getResources().getDimensionPixelSize(w.f.ds8), true);
                    }
                    TextView textView = (TextView) this.etm.findViewById(w.h.god_floating_owner_info_user_name);
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_f, 1);
                    }
                    textView.setText(postData.getAuthor().getName_show());
                    if (aOL() != null && this.etm.getParent() == null) {
                        aOL().addView(this.etm);
                    }
                    this.ekw.getLayoutMode().t(this.etm);
                }
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) this.etm.findViewById(w.h.god_floating_gift);
                this.etz.a(entelechyUserLikeButton);
                this.etz.a(postData.getAuthor());
                ImageView imageView3 = (ImageView) this.etm.findViewById(w.h.god_floating_arrow);
                com.baidu.tbadk.core.util.aq.c(imageView3, w.g.icon_arrow_tab);
                if (this.esC || (godUserData.getIsLike() && godUserData.getIsFromNetWork())) {
                    entelechyUserLikeButton.setVisibility(8);
                    imageView3.setVisibility(0);
                } else {
                    entelechyUserLikeButton.setVisibility(0);
                    imageView3.setVisibility(8);
                }
                String format = String.format(this.ekw.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(fansNum));
                TextView textView2 = (TextView) this.etm.findViewById(w.h.god_floating_intro);
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
        if (fVar.aKy() == null || !fVar.aKy().tb() || fVar.aKy().sF() == null) {
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
        if (this.erP.getLayoutParams() instanceof ColumnLayout.a) {
            ColumnLayout.a aVar = (ColumnLayout.a) this.erP.getLayoutParams();
            aVar.gravity = 48;
            this.erP.setLayoutParams(aVar);
        }
        this.erA.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32), 0);
        this.etf.setPadding(0, com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds8), 0, 0);
        if (postData.getType() == null || postData.getType().getId() != PostData.Yd.getId()) {
            this.err.setPadding(0, 0, 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds76);
        if (this.erF.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.erF.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.erF.setLayoutParams(layoutParams);
        this.erF.setVisibility(8);
        View findViewWithTag = this.erA.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.epP = new ClickableHeaderImageView(this.ekw.getApplicationContext());
            this.epP.setGodIconMargin(0);
            this.epP.setTag("pb_god_head_image_view_tag");
            this.epP.setUserId(String.valueOf(userIdLong));
            this.epP.setUserName(userName);
            layoutParams.leftMargin = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds0);
            this.erD.addView(this.epP, 0, layoutParams);
        } else {
            this.epP = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.aiH) {
            this.epP.setIsBigV(true);
        }
        fw fwVar = new fw(this, postData, fVar);
        this.erA.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.erA.setTag(w.h.tag_user_name, userName);
        this.erv.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.erv.setTag(w.h.tag_user_name, userName);
        this.epP.setVisibility(0);
        this.epP.setOnClickListener(fwVar);
        this.epP.c(portrait, 28, false);
        if (this.erN == null) {
            this.erN = new TextView(this.ekw.getActivity());
            this.erN.setClickable(true);
            this.erN.setTextSize(0, this.ekw.getResources().getDimensionPixelSize(w.f.fontsize24));
            ColumnLayout.a aVar2 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar2.topMargin = this.ekw.getResources().getDimensionPixelSize(w.f.ds10);
            this.erN.setSingleLine(true);
            this.erN.setEllipsize(TextUtils.TruncateAt.END);
            this.erN.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
            this.erN.setTag(w.h.tag_user_name, userName);
            com.baidu.tbadk.core.util.aq.c(this.erN, w.e.cp_cont_d, 1);
            this.erN.setOnTouchListener(this.ejB);
            this.erA.addView(this.erN, -1, aVar2);
        }
        String string = this.ekw.getResources().getString(w.l.tieba_certification);
        this.erN.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.ekw.getResources().getString(w.l.god_intro_default)) : String.format(string, godUserData.getIntro()));
        if (this.erM == null) {
            this.erM = new TextView(this.ekw.getActivity());
            this.erM.setClickable(false);
            this.erM.setIncludeFontPadding(false);
            this.erM.setGravity(16);
            this.erM.setTextSize(0, this.ekw.getResources().getDimensionPixelSize(w.f.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.ekw.getResources().getDimensionPixelSize(w.f.ds5);
            aVar3.bottomMargin = this.ekw.getResources().getDimensionPixelSize(w.f.ds10);
            this.erM.setSingleLine(true);
            com.baidu.tbadk.core.util.aq.c(this.erM, w.e.cp_cont_d, 1);
            this.erA.addView(this.erM, -1, aVar3);
        }
        this.erM.setText(String.format(this.ekw.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(fansNum)));
        this.erM.setTag(w.h.tag_user_id, String.valueOf(userIdLong));
        this.erM.setTag(w.h.tag_user_name, userName);
        this.erM.setOnClickListener(fwVar);
        if (z3) {
            this.erM.setVisibility(4);
        } else {
            this.erM.setVisibility(0);
        }
        if (this.etn == null) {
            this.etn = new TextView(this.ekw.getApplicationContext());
            this.etn.setId(w.h.pb_god_user_tip_content);
            this.etn.setEllipsize(TextUtils.TruncateAt.END);
            this.etn.setGravity(17);
            this.etn.setSingleLine(true);
            this.etn.setHeight(this.ekw.getResources().getDimensionPixelSize(w.f.ds56));
            this.etn.setTextSize(0, this.ekw.getResources().getDimensionPixelSize(w.f.fontsize24));
            this.etn.setVisibility(8);
            if (aOL() != null) {
                aOL().addView(this.etn);
            }
            this.ekw.getLayoutMode().t(this.etn);
        }
        com.baidu.tbadk.core.util.aq.j(this.etn, w.e.common_color_10260);
        com.baidu.tbadk.core.util.aq.i(this.etn, w.e.cp_cont_g);
        this.etn.setOnClickListener(new fx(this));
        this.etn.setText(String.format(this.ekw.getResources().getString(w.l.god_user_floor_owner_tip), com.baidu.tbadk.core.util.au.t(this.eto)));
        oA(this.eto);
        if (!z3) {
            a(fVar, postData, this.mSkinType);
        }
        this.etw = this.esd.xa();
        if (this.etw != null && !this.esC && !z && z2 && (!godUserData.getIsLike() || !godUserData.getIsFromNetWork())) {
            this.esd.xb();
            this.esd.wX();
            this.etq = this.etw.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.etq == null) {
                this.etq = new View(this.ekw.getApplicationContext());
                this.etq.setTag("pb_god_bottom_extra_line_view_tag");
                this.etw.addView(this.etq, new LinearLayout.LayoutParams(-1, this.ekw.getResources().getDimensionPixelSize(w.f.ds20)));
                this.etu = new FrameLayout(this.ekw.getApplicationContext());
                this.etu.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.ets = new ClickableHeaderImageView(this.ekw.getApplicationContext());
                this.ets.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.ets.c(portrait, 28, false);
                this.ets.setUserId(String.valueOf(userIdLong));
                this.ets.setUserName(userName);
                this.ets.setOnClickListener(fwVar);
                this.etu.addView(this.ets, new FrameLayout.LayoutParams(this.ekw.getResources().getDimensionPixelSize(w.f.ds130), this.ekw.getResources().getDimensionPixelSize(w.f.ds130)));
                if (this.aiH) {
                    this.ett = new TbImageView(this.ekw.getApplicationContext());
                    this.ett.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.ett.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.ekw.getResources().getDimensionPixelSize(w.f.ds45), this.ekw.getResources().getDimensionPixelSize(w.f.ds45));
                    layoutParams3.gravity = 85;
                    this.etu.addView(this.ett, layoutParams3);
                } else {
                    this.ets.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(this.ekw.getResources().getDimensionPixelSize(w.f.ds130), this.ekw.getResources().getDimensionPixelSize(w.f.ds130));
                layoutParams4.gravity = 17;
                layoutParams4.topMargin = this.ekw.getResources().getDimensionPixelSize(w.f.ds40);
                this.etw.addView(this.etu, layoutParams4);
                this.etv = new TextView(this.ekw.getApplicationContext());
                this.etv.setTag("pb_god_bottom_extra_text_view_tag");
                this.etv.setSingleLine(true);
                this.etv.setTextSize(0, this.ekw.getResources().getDimensionPixelSize(w.f.fontsize24));
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.topMargin = this.ekw.getResources().getDimensionPixelSize(w.f.ds36);
                layoutParams5.gravity = 1;
                this.etv.setText(this.ekw.getResources().getString(w.l.god_user_attention_tip));
                this.etw.addView(this.etv, layoutParams5);
                if (this.etr == null) {
                    this.etr = new EntelechyUserLikeButton(this.ekw.getApplicationContext());
                    this.etA.a(this.etr);
                }
                this.etr.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.etr.setTextSize(0, this.ekw.getResources().getDimensionPixelSize(w.f.fontsize24));
                this.etr.setGravity(17);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, this.ekw.getResources().getDimensionPixelSize(w.f.ds54));
                layoutParams6.topMargin = this.ekw.getResources().getDimensionPixelSize(w.f.ds30);
                layoutParams6.bottomMargin = this.ekw.getResources().getDimensionPixelSize(w.f.ds40);
                layoutParams6.gravity = 1;
                this.etw.addView(this.etr, layoutParams6);
            } else {
                this.etr = (EntelechyUserLikeButton) this.etw.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.ets = (ClickableHeaderImageView) this.etw.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.etv = (TextView) this.etw.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.etq = this.etw.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            this.etA.a(postData.getAuthor());
            com.baidu.tbadk.core.util.aq.k(this.etw, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.k(this.etq, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.c(this.etv, w.e.cp_cont_c, 1);
            this.etw.setOnTouchListener(new fy(this));
        } else {
            this.esd.xc();
            this.esd.wW();
        }
        return true;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!this.etC && aOT()) {
            c(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.etk && !this.elc && i > this.erc) {
            this.etl = true;
        } else {
            this.etl = false;
            aOG();
        }
        if (!this.etC && aOT()) {
            b(absListView, i, i2, i3);
        }
        a aVar = new a();
        aVar.etV = i;
        aVar.etW = this.mListView.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
    }

    private void c(AbsListView absListView, int i) {
        if (this.erf != null) {
            this.erf.a(absListView, i, this.esT);
        }
    }

    private void b(AbsListView absListView, int i, int i2, int i3) {
        if (this.erf != null) {
            this.erf.b(absListView, i, this.esT);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int etV;
        public int etW;

        public a() {
        }
    }

    private void oA(int i) {
        boolean z;
        if (this.etn != null && this.etn.getVisibility() != 0 && i >= 2 && !this.esC) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.etp = true;
                this.etn.setVisibility(0);
            }
            com.baidu.adp.lib.g.h.fS().postDelayed(this.bSW, 3000L);
        }
    }

    public void aOF() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bSW);
        if (this.etn != null && 8 != this.etn.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.ekw, this.etn, w.a.fade_out, new fz(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aOG() {
        if (this.etm != null) {
            this.etm.clearAnimation();
            if (this.etm.getVisibility() != 8) {
                this.etm.setVisibility(8);
            }
        }
    }

    public void aOH() {
        if (this.etk && this.etl && this.etm != null && this.etm.getVisibility() != 0 && !this.etp) {
            this.etm.clearAnimation();
            this.etm.setVisibility(0);
        }
    }

    public void aOI() {
        if (!this.etM) {
            TiebaStatic.log("c10490");
            this.etM = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ekw.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(esX, Integer.valueOf(esZ));
            aVar.bY(w.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(w.h.function_description_view)).setText(w.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(w.h.title_view)).setText(w.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(w.l.grade_button_tips, this.ekw);
            aVar.b(w.l.look_again, new ga(this));
            aVar.b(this.ekw.getPageContext()).tQ();
        }
    }

    public void aOJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ekw.getPageContext().getPageActivity());
        aVar.cE(this.ekw.getResources().getString(w.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(esX, Integer.valueOf(etb));
        aVar.A(sparseArray);
        aVar.a(w.l.upgrade_to_new, this.ekw);
        aVar.b(w.l.cancel, new gb(this));
        aVar.b(this.ekw.getPageContext()).tQ();
    }

    public int sc() {
        return this.esU;
    }

    public void nH(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ekw.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.ekw.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(w.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(w.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(esX, Integer.valueOf(eta));
        aVar.A(sparseArray);
        aVar.a(w.l.view, this.ekw);
        aVar.b(w.l.cancel, new gc(this));
        aVar.b(this.ekw.getPageContext()).tQ();
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

    public PbInterviewStatusView aOK() {
        return this.esS;
    }

    private void o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aKy() != null && fVar.aKy().tg() && this.esS == null) {
            this.esS = (PbInterviewStatusView) this.esR.inflate();
            this.esS.setOnClickListener(this.bQO);
            this.esS.setCallback(this.ekw.aLR());
            this.esS.a(this.ekw, fVar);
        }
    }

    public LinearLayout aOL() {
        return this.erX;
    }

    public View aOM() {
        return this.bJu;
    }

    public boolean aON() {
        return this.etx;
    }

    public void ip(boolean z) {
        this.ery.ip(z);
    }

    private void aOO() {
        if (this.etx) {
            if (this.ety == null) {
                f.a aVar = f.ekz.get();
                if (aVar != null) {
                    this.ety = aVar.a(this.ekw);
                    ListAdapter adapter = this.mListView.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.avF) {
                            this.mListView.addHeaderView(this.ety.aLk(), 1);
                        } else {
                            this.mListView.addHeaderView(this.ety.aLk(), 0);
                        }
                    }
                } else {
                    this.erv.setVisibility(0);
                    return;
                }
            }
            this.erv.setVisibility(8);
            this.mListView.removeHeaderView(this.erv);
            return;
        }
        this.erv.setVisibility(0);
    }

    public void ja(boolean z) {
        this.etx = z;
    }

    public View aMz() {
        return this.erz.aMz();
    }

    public void aOP() {
        this.ekw.showNetRefreshView(getView(), "");
        View EZ = this.ekw.getRefreshView().EZ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EZ.getLayoutParams();
        layoutParams.addRule(3, aOL().getId());
        EZ.setLayoutParams(layoutParams);
        this.ekw.hideLoadingView(getView());
        if (this.ety != null) {
            this.mListView.removeHeaderView(this.ety.aLk());
            this.ety = null;
        }
    }

    public void nI(String str) {
        if (this.ern != null) {
            this.ern.setTitle(str);
        }
    }

    public void aOQ() {
        if (this.erY != null) {
            if (this.erY.aMg() != null) {
                this.erY.aMg().aza();
            }
            if (this.erY.aMh() != null) {
                this.erY.aMh().aza();
            }
        }
    }

    private int jb(boolean z) {
        if (this.esS == null || this.esS.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.ekw.getPageContext().getPageActivity(), w.f.ds72);
    }

    private void aOR() {
        if (this.esS != null && this.esS.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.esS.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.esS.setLayoutParams(layoutParams);
        }
    }

    public boolean aLt() {
        return this.etk;
    }

    public TextView aOS() {
        return this.erN;
    }

    public void nJ(String str) {
        this.esI.performClick();
        if (!StringUtils.isNull(str) && this.ekw.aLn() != null && this.ekw.aLn().DO() != null && this.ekw.aLn().DO().DG() != null) {
            EditText DG = this.ekw.aLn().DO().DG();
            DG.setText(str);
            DG.setSelection(str.length());
        }
    }

    public boolean aOT() {
        return (this.erf == null || this.eri == null) ? false : true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            axI();
            if (this.erz != null) {
                aMy();
            }
            aOE();
            aNR();
            if (this.etg != null) {
                this.etg.aMl();
            }
            this.ekw.aar();
            aOG();
            this.erX.setVisibility(8);
            this.erm.setTitleVisibility(true);
            this.ekw.iw(false);
            this.etC = false;
            if (this.eri != null && this.erd != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.erd.getLayoutParams();
                layoutParams.topMargin = 0;
                this.erd.setLayoutParams(layoutParams);
                if (configuration.orientation == 2) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.etC = true;
                } else {
                    int af = com.baidu.adp.lib.util.k.af(this.ekw.getActivity());
                    layoutParams.width = af;
                    layoutParams.height = (int) (af * 0.5625d);
                    if (this.erf != null) {
                        this.erf.aPe();
                    }
                    this.erX.setVisibility(0);
                    this.etC = false;
                }
                this.erd.setLayoutParams(layoutParams);
                this.eri.a(this.ekw, configuration);
            }
        }
    }

    public void x(long j, int i) {
        if (this.erj != null && j > 0) {
            this.erj.j(i, j);
        }
    }

    public void jc(boolean z) {
        this.erg = z;
    }

    private void E(com.baidu.tbadk.core.data.bi biVar) {
        if (this.erj != null && biVar != null && biVar.ts() != null && biVar.ts().ZY == 2) {
            if (this.eti == null) {
                this.eti = new com.baidu.tieba.d.a(this.ekw.getPageContext(), this.erj.ewY);
                this.eti.he(5000);
            }
            this.eti.f(this.ekw.getResources().getString(w.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }
}
