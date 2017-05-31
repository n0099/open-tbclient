package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
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
import android.view.ViewTreeObserver;
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
import com.baidu.tieba.card.at;
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
public class fx {
    private com.baidu.tbadk.editortools.j JU;
    private View aFg;
    private int aNC;
    private com.baidu.tieba.pb.a.d aOc;
    private ae.b alb;
    private TextView avt;
    private RelativeLayout bMv;
    private View bOo;
    private View.OnClickListener bVy;
    private TextView bvK;
    private NoNetworkView byr;
    private View.OnClickListener ekf;
    private PbActivity elf;
    PbActivity.c emN;
    private UserIconBox eoF;
    private UserIconBox eoG;
    private PbFakeFloorModel epa;
    private com.baidu.tieba.pb.data.f epx;
    private com.baidu.tieba.pb.video.l esB;
    private com.baidu.tieba.pb.video.k esC;
    private com.baidu.tieba.d.a esD;
    public final com.baidu.tieba.pb.pb.main.view.h esG;
    public com.baidu.tieba.pb.pb.main.view.f esH;
    private ViewStub esI;
    private ViewStub esJ;
    private PbLandscapeListView esK;
    private List<com.baidu.tieba.pb.pb.main.view.a> esL;
    private View esM;
    private LinearLayout esQ;
    private TextView esR;
    private View esS;
    private g esT;
    private ColumnLayout esU;
    private ThreadSkinView esV;
    private TextView esW;
    private TextView esX;
    private TextView esY;
    private ImageView esZ;
    public int esw;
    private int esx;
    private int esy;
    private int esz;
    private PbListView etA;
    private View etC;
    private HeadPendantView eta;
    private FrameLayout etb;
    private HeadImageView etd;
    private View ete;
    private FloatingLayout etf;
    private PbFirstFloorUserLikeButton etk;
    private fv etl;
    private TextView etm;
    private TextView etn;
    private LinearLayout eto;
    private TextView etp;
    private TextView etq;
    private View etr;
    private View ets;
    private ObservedChangeLinearLayout etu;
    private cv etv;
    private Runnable euB;
    private Runnable euC;
    private dz euD;
    private com.baidu.tieba.d.a euE;
    private View euO;
    private TextView euP;
    private LinearLayout euQ;
    private boolean euR;
    private f euS;
    private com.baidu.tbadk.core.view.userLike.c euT;
    private com.baidu.tbadk.core.view.userLike.c euU;
    private Runnable euX;
    private PbActivity.a euZ;
    private View euc;
    private TextView eud;
    private ViewGroup eue;
    private TextView eug;
    private boolean eui;
    private int euj;
    private int euk;
    private int eul;
    private PostData eum;
    private View euo;
    private TextView eup;
    private ViewStub euq;
    private PbInterviewStatusView eur;
    private com.baidu.tieba.pb.pb.main.emotion.view.a eus;
    private boolean evb;
    private boolean evc;
    private int evg;
    private boolean isLandscape;
    private int mType;
    public static int euu = 2;
    public static int euv = 3;
    public static int euw = 0;
    public static int eux = 3;
    public static int euy = 4;
    public static int euz = 5;
    public static int euA = 6;
    private int esA = 1;
    private boolean esE = false;
    private int esF = 0;
    private final Handler mHandler = new Handler();
    private View esN = null;
    private LinearLayout esO = null;
    private TextView esP = null;
    private TextView etg = null;
    private TextView eth = null;
    public FrsPraiseView eti = null;
    private ClickableHeaderImageView etj = null;
    private View ett = null;
    private com.baidu.tbadk.core.dialog.a etw = null;
    private com.baidu.tbadk.core.dialog.c bVx = null;
    private View etx = null;
    private EditText ety = null;
    private com.baidu.tieba.pb.view.ac etz = null;
    private com.baidu.tieba.pb.view.b etB = null;
    private c.b dab = null;
    private TbRichTextView.e aOb = null;
    private NoNetworkView.a byu = null;
    private Dialog etD = null;
    private View etE = null;
    private com.baidu.tbadk.core.dialog.a etF = null;
    private Dialog etG = null;
    private View etH = null;
    private int etI = 0;
    private RadioGroup etJ = null;
    private RadioButton etK = null;
    private RadioButton etL = null;
    private RadioButton etM = null;
    private Button etN = null;
    private Button etO = null;
    private TextView etP = null;
    private Dialog etQ = null;
    private View etR = null;
    private LinearLayout etS = null;
    private CompoundButton.OnCheckedChangeListener etT = null;
    private TextView etU = null;
    private TextView etV = null;
    private String etW = null;
    private com.baidu.tbadk.core.dialog.c etX = null;
    private boolean etY = false;
    private boolean etZ = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eua = null;
    private boolean dqY = false;
    private Button eub = null;
    public ImageView euf = null;
    private boolean euh = true;
    private com.baidu.tbadk.core.view.a bgw = null;
    private boolean ekb = false;
    private int mSkinType = 3;
    private boolean eun = false;
    private boolean mIsFromCDN = true;
    private int eut = 0;
    private float euF = -1.0f;
    private int euG = -1;
    private boolean euH = false;
    private a.InterfaceC0080a euI = new fy(this);
    private boolean elN = false;
    private boolean euJ = false;
    private LinearLayout euK = null;
    private TextView euL = null;
    private int euM = 0;
    private boolean euN = false;
    private boolean euV = false;
    private int rank = 0;
    private CustomMessageListener dmy = new gd(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler euW = new Handler();
    private CustomMessageListener euY = new gm(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eva = true;
    private boolean evd = false;
    private boolean Yw = false;
    String userId = null;
    private final List<TbImageView> eve = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener evf = new gu(this);
    private boolean evh = false;

    public void i(int i, float f) {
        this.euG = i;
        this.euF = f;
    }

    public f aMc() {
        return this.euS;
    }

    public NoNetworkView aMd() {
        return this.byr;
    }

    public void aMe() {
        if (this.JU != null) {
            this.JU.hide();
        }
    }

    public PbFakeFloorModel aMf() {
        return this.epa;
    }

    public dz aMg() {
        return this.euD;
    }

    public void aKn() {
        reset();
        aMe();
        this.euD.aKE();
        gA(false);
    }

    private void reset() {
        if (this.elf != null && this.elf.aJA() != null && this.JU != null) {
            com.baidu.tbadk.editortools.pb.a.CI().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aJA = this.elf.aJA();
            aJA.Dc();
            if (aJA.getWriteImagesInfo() != null) {
                aJA.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aJA.eH(10);
            aJA.eF(SendView.ALL);
            aJA.eG(SendView.ALL);
            com.baidu.tbadk.editortools.p ew = this.JU.ew(23);
            com.baidu.tbadk.editortools.p ew2 = this.JU.ew(2);
            com.baidu.tbadk.editortools.p ew3 = this.JU.ew(5);
            if (ew2 != null) {
                ew2.lO();
            }
            if (ew3 != null) {
                ew3.lO();
            }
            if (ew != null) {
                ew.hide();
            }
            this.JU.invalidate();
        }
    }

    public boolean aMh() {
        return this.euh;
    }

    public void gB(boolean z) {
        if (this.euc != null && this.eud != null) {
            this.eud.setText(w.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.euc.startAnimation(alphaAnimation);
            }
            this.euc.setVisibility(0);
            this.euh = true;
            if (this.eus != null) {
                this.eus.setVisibility(0);
            }
        }
    }

    public void gC(boolean z) {
        if (this.euc != null && this.eud != null) {
            this.eud.setText(w.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.euc.startAnimation(alphaAnimation);
            }
            this.euc.setVisibility(0);
            this.euh = true;
            if (this.eus != null) {
                this.eus.setVisibility(0);
            }
        }
    }

    public PostData aMi() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.esK == null) {
            return null;
        }
        int firstVisiblePosition = this.esK.getFirstVisiblePosition();
        int lastVisiblePosition = this.esK.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.esK.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.esK.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.esK.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.etv.ou(headerViewsCount) != null && this.etv.ou(headerViewsCount) != PostData.fCb) {
            i2 = headerViewsCount + 1;
        }
        return this.etv.getItem(i2) instanceof PostData ? (PostData) this.etv.getItem(i2) : null;
    }

    public fx(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.aNC = 0;
        this.esx = 0;
        this.esy = 0;
        this.esz = 0;
        this.elf = null;
        this.bMv = null;
        this.bOo = null;
        this.esK = null;
        this.esM = null;
        this.esQ = null;
        this.esR = null;
        this.esS = null;
        this.esU = null;
        this.esW = null;
        this.esY = null;
        this.etb = null;
        this.etd = null;
        this.ete = null;
        this.etk = null;
        this.etm = null;
        this.etn = null;
        this.bvK = null;
        this.etr = null;
        this.ets = null;
        this.etv = null;
        this.etA = null;
        this.aFg = null;
        this.bVy = null;
        this.ekf = null;
        this.euc = null;
        this.eud = null;
        this.eue = null;
        this.eug = null;
        this.euo = null;
        this.eup = null;
        this.euq = null;
        this.elf = pbActivity;
        this.bVy = onClickListener;
        this.aOc = dVar;
        this.bMv = (RelativeLayout) LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.new_pb_activity, (ViewGroup) null);
        this.bMv.getViewTreeObserver().addOnGlobalLayoutListener(this.evf);
        this.elf.addContentView(this.bMv, new FrameLayout.LayoutParams(-1, -1));
        this.bOo = this.elf.findViewById(w.h.statebar_view);
        this.etu = (ObservedChangeLinearLayout) this.elf.findViewById(w.h.title_wrapper);
        this.byr = (NoNetworkView) this.elf.findViewById(w.h.view_no_network);
        this.esK = (PbLandscapeListView) this.elf.findViewById(w.h.new_pb_list);
        this.avt = new TextView(this.elf.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.elf.getActivity(), w.f.ds98));
        this.esK.addHeaderView(this.avt, 0);
        View view = new View(this.elf.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.elf.getResources().getDimensionPixelSize(w.f.ds100)));
        view.setVisibility(4);
        this.esK.addFooterView(view);
        this.esK.setOnTouchListener(this.elf.aJg);
        this.esG = new com.baidu.tieba.pb.pb.main.view.h(pbActivity);
        this.euE = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.esG.exk);
        this.euE.hz(3);
        if (this.elf.aJX()) {
            this.esI = (ViewStub) this.elf.findViewById(w.h.manga_view_stub);
            this.esI.setVisibility(0);
            this.esH = new com.baidu.tieba.pb.pb.main.view.f(pbActivity);
            this.esH.show();
            this.esG.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.avt.setLayoutParams(layoutParams);
        this.esG.aNx().setOnTouchListener(new com.baidu.tieba.pb.a.a(new gv(this)));
        this.euc = this.elf.findViewById(w.h.pb_editor_tool_comment);
        this.euj = com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds110);
        this.euk = com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds156);
        this.eul = this.euj;
        this.eud = (TextView) this.elf.getPageContext().getPageActivity().findViewById(w.h.pb_editor_tool_comment_reply_text);
        this.eue = (ViewGroup) this.elf.getPageContext().getPageActivity().findViewById(w.h.pb_editor_tool_comment_reply_layout);
        this.eug = (TextView) this.elf.getPageContext().getPageActivity().findViewById(w.h.pb_editor_tool_comment_praise_icon);
        this.eug.setVisibility(8);
        this.eue.setOnClickListener(new gw(this));
        this.eug.setOnClickListener(this.bVy);
        this.eug.setOnTouchListener(this.elf);
        this.esM = LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_item, (ViewGroup) null);
        this.esQ = (LinearLayout) LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_user_item, (ViewGroup) null);
        this.esT = new g(this.elf, this.esQ);
        this.esT.init();
        this.esT.a(this.esT.aJz(), this.bVy);
        this.esU = (ColumnLayout) this.esQ.findViewById(w.h.pb_head_owner_root);
        this.esV = (ThreadSkinView) this.esQ.findViewById(w.h.pb_thread_skin);
        this.esU.setOnLongClickListener(this.onLongClickListener);
        this.esU.setOnTouchListener(this.aOc);
        this.esU.setVisibility(8);
        this.esM.setOnTouchListener(this.aOc);
        this.euo = this.esM.findViewById(w.h.pb_head_activity_join_number_container);
        this.euo.setVisibility(8);
        this.eup = (TextView) this.esM.findViewById(w.h.pb_head_activity_join_number);
        this.esW = (TextView) this.esU.findViewById(w.h.pb_head_owner_info_user_name);
        this.esX = (TextView) this.esQ.findViewById(w.h.pb_head_owner_info_user_intro);
        this.esY = (TextView) this.esU.findViewById(w.h.floor_owner);
        this.esZ = (ImageView) this.esU.findViewById(w.h.icon_forum_level);
        this.etb = (FrameLayout) this.esU.findViewById(w.h.pb_head_headImage_container);
        this.etd = (HeadImageView) this.esU.findViewById(w.h.pb_head_owner_photo);
        this.eta = (HeadPendantView) this.esU.findViewById(w.h.pb_pendant_head_owner_photo);
        this.eta.vV();
        if (this.eta.getHeadView() != null) {
            this.eta.getHeadView().setIsRound(true);
            this.eta.getHeadView().setDrawBorder(false);
        }
        if (this.eta.getPendantView() != null) {
            this.eta.getPendantView().setIsRound(true);
            this.eta.getPendantView().setDrawBorder(false);
        }
        this.eoF = (UserIconBox) this.esU.findViewById(w.h.show_icon_vip);
        this.eoG = (UserIconBox) this.esU.findViewById(w.h.show_icon_yinji);
        this.etf = (FloatingLayout) this.esQ.findViewById(w.h.pb_head_owner_info_root);
        this.etk = (PbFirstFloorUserLikeButton) this.esU.findViewById(w.h.pb_like_button);
        this.etl = new fv(pbActivity.getPageContext(), this.etk, 1);
        this.etm = (TextView) this.esU.findViewById(w.h.pb_views);
        this.etn = (TextView) this.esU.findViewById(w.h.pb_item_first_floor_reply_time);
        this.bvK = (TextView) this.esU.findViewById(w.h.pb_item_first_floor_location_address);
        this.euT = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.euU = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.etr = this.esM.findViewById(w.h.new_pb_header_item_line_above_livepost);
        this.esS = LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.layout_read_thread, (ViewGroup) null);
        this.esR = (TextView) this.esS.findViewById(w.h.pb_head_read_button);
        this.esQ.addView(this.esS);
        this.esR.setOnClickListener(this.bVy);
        this.esz = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds2);
        this.esy = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds18);
        this.esx = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);
        this.aNC = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds32);
        this.ets = this.esM.findViewById(w.h.new_pb_header_item_line_below_livepost);
        this.esM.setOnLongClickListener(new gx(this));
        this.euq = (ViewStub) this.bMv.findViewById(w.h.interview_status_stub);
        this.etv = new cv(this.elf, this.esK);
        this.etv.u(this.bVy);
        this.etv.setTbGestureDetector(this.aOc);
        this.etv.setOnImageClickListener(this.aOb);
        this.ekf = new gy(this);
        this.etv.H(this.ekf);
        aMm();
        this.esK.addHeaderView(this.esO);
        this.esK.addHeaderView(this.esQ);
        this.esK.addHeaderView(this.esM);
        this.etA = new PbListView(this.elf.getPageContext().getPageActivity());
        this.aFg = this.etA.getView().findViewById(w.h.pb_more_view);
        if (this.aFg != null) {
            this.aFg.setOnClickListener(this.bVy);
            com.baidu.tbadk.core.util.aq.j(this.aFg, w.g.pb_foot_more_trans_selector);
        }
        this.etA.wh();
        this.etA.dh(w.g.pb_foot_more_trans_selector);
        this.etA.di(w.g.pb_foot_more_trans_selector);
        this.etC = this.elf.findViewById(w.h.viewstub_progress);
        this.elf.registerListener(this.euY);
        this.ete = com.baidu.tbadk.ala.b.nz().h(this.elf.getActivity(), 2);
        if (this.ete != null) {
            this.ete.setVisibility(8);
            this.etf.addView(this.ete);
        }
        this.epa = new PbFakeFloorModel(this.elf.getPageContext());
        this.euD = new dz(this.elf.getPageContext(), this.epa, this.bMv);
        this.epa.a(new gz(this));
        if (this.elf.aJF() != null && !StringUtils.isNull(this.elf.aJF().aLr())) {
            this.elf.showToast(this.elf.aJF().aLr());
        }
        this.elf.registerListener(this.dmy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMj() {
        if (this.eus != null) {
            int[] iArr = new int[2];
            this.euc.getLocationOnScreen(iArr);
            this.eus.setBottomMargin((((ViewGroup) this.elf.getPageContext().getPageActivity().getWindow().getDecorView()).getHeight() - this.eul) - iArr[1]);
        }
    }

    public void aMk() {
        if (this.esK != null) {
            this.esK.removeHeaderView(this.esO);
            this.esK.removeHeaderView(this.esQ);
            this.esK.removeHeaderView(this.esM);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.data.b bVar, com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        if (this.eus == null) {
            this.eus = new com.baidu.tieba.pb.pb.main.emotion.view.a(this.elf.getPageContext().getPageActivity());
            ViewGroup viewGroup = (ViewGroup) this.elf.getPageContext().getPageActivity().getWindow().getDecorView();
            int[] iArr = new int[2];
            this.euc.getLocationOnScreen(iArr);
            this.eus.a(viewGroup, (viewGroup.getHeight() - this.euj) - iArr[1], bVar);
            this.eus.setOnEmotionClickListener(new fz(this, aVar));
            this.eus.setOnMoveListener(new ga(this));
        }
    }

    private boolean k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aIB() == null || !fVar.aIV() || !TbadkCoreApplication.m9getInst().isTTSCanUse() || fVar.aIB().rs() == 1 || fVar.aIB().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aIB().ru() == null || fVar.aIB().ru().sP() == 0) && !fVar.aIB().sm()) {
            BdUniqueId type = fVar.aIB().getType();
            return type == com.baidu.tbadk.core.data.bl.Xo || type == com.baidu.tbadk.core.data.bl.Xq || type == com.baidu.tbadk.core.data.bl.Xn;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.esS != null) {
            if (!z) {
                this.esS.setVisibility(8);
            } else if (!k(fVar)) {
                this.esS.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aID() != null && fVar.aID().size() > 0) {
                    postData = fVar.aID().get(0);
                }
                if (postData != null && postData.big() == 1) {
                    o(this.aNC, this.esy, this.aNC, this.esz);
                } else {
                    o(this.aNC, this.esy, this.aNC, this.esx);
                }
                this.esS.setVisibility(0);
            }
        }
    }

    private void o(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.esR.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.esR.setLayoutParams(layoutParams);
    }

    public TextView aMl() {
        return this.esR;
    }

    private void aMm() {
        if (this.esO == null) {
            int g = com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds40);
            com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds40);
            this.esO = new LinearLayout(this.elf.getPageContext().getPageActivity());
            this.esO.setOrientation(1);
            this.esO.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.esO.setPadding(g, com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds40), g, com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds46));
            this.esO.setGravity(17);
            this.esP = new TextView(this.elf.getPageContext().getPageActivity());
            this.esP.setGravity(3);
            this.esP.setMaxLines(2);
            this.esP.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.esP.setPadding(0, 0, 0, 0);
            this.esP.setLineSpacing(com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.aq.i(this.esP, w.e.cp_cont_b);
            this.esP.setTextSize(0, com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds48));
            this.esP.setVisibility(8);
            this.esO.addView(this.esP);
            this.esO.setOnTouchListener(this.aOc);
            this.esO.setOnLongClickListener(new gb(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMn() {
        if (this.elf.aJX()) {
            this.esJ = (ViewStub) this.elf.findViewById(w.h.manga_mention_controller_view_stub);
            this.esJ.setVisibility(0);
            if (this.eto == null) {
                this.eto = (LinearLayout) this.elf.findViewById(w.h.manga_controller_layout);
                com.baidu.tbadk.m.a.a(this.elf.getPageContext(), this.eto);
            }
            if (this.etp == null) {
                this.etp = (TextView) this.eto.findViewById(w.h.manga_prev_btn);
            }
            if (this.etq == null) {
                this.etq = (TextView) this.eto.findViewById(w.h.manga_next_btn);
            }
            this.etp.setOnClickListener(this.bVy);
            this.etq.setOnClickListener(this.bVy);
        }
    }

    private void aMo() {
        if (this.elf.aJX()) {
            if (this.elf.aKa() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.etp, w.e.cp_cont_e, 1);
            }
            if (this.elf.aKb() == -1) {
                com.baidu.tbadk.core.util.aq.c(this.etq, w.e.cp_cont_e, 1);
            }
        }
    }

    public void aMp() {
        if (this.eto == null) {
            aMn();
        }
        this.esJ.setVisibility(8);
        if (this.euW != null && this.euX != null) {
            this.euW.removeCallbacks(this.euX);
        }
    }

    public void aMq() {
        if (this.euW != null) {
            if (this.euX != null) {
                this.euW.removeCallbacks(this.euX);
            }
            this.euX = new gc(this);
            this.euW.postDelayed(this.euX, 2000L);
        }
    }

    public void iN(boolean z) {
        this.esG.iN(z);
        if (z && this.eun) {
            this.etA.setText(this.elf.getResources().getString(w.l.click_load_more));
            this.esK.setNextPage(this.etA);
            this.esF = 2;
        }
    }

    public void aMr() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.bMv.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JU = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.bMv.addView(this.JU, layoutParams);
        this.JU.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aMe();
    }

    public void aMs() {
        if (this.elf != null && this.JU != null) {
            this.JU.lO();
            aMP();
        }
    }

    public void M(String str, boolean z) {
        this.eui = z;
        aM(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void aM(boolean z) {
        if (this.eug != null) {
            if (this.eui) {
                com.baidu.tbadk.core.util.aq.j(this.eug, w.g.pb_praise_already_click_selector);
                this.eug.setContentDescription(this.elf.getResources().getString(w.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aq.j(this.eug, w.g.pb_praise_normal_click_selector);
            this.eug.setContentDescription(this.elf.getResources().getString(w.l.frs_item_praise_text));
        }
    }

    public TextView aMt() {
        return this.eug;
    }

    public void iO(boolean z) {
        if (this.esK != null && this.avt != null && this.bOo != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bOo.setVisibility(0);
                } else {
                    this.bOo.setVisibility(8);
                    this.esK.removeHeaderView(this.avt);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.avt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.avt.setLayoutParams(layoutParams);
                }
                aMH();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.avt.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + iV(true);
                this.avt.setLayoutParams(layoutParams2);
            }
            aMH();
            aMY();
        }
    }

    public cv aMu() {
        return this.etv;
    }

    public void aMv() {
        if (this.etv != null) {
            this.etv.aKv();
        }
    }

    public void a(PbActivity.c cVar) {
        this.emN = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bq bqVar) {
        if (bqVar == null || bqVar.sP() == 0) {
            if (this.eub != null) {
                this.eub.setVisibility(8);
            }
            if (this.etr != null) {
                this.etr.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eub == null) {
            this.elf.getLayoutMode().t(((ViewStub) this.esM.findViewById(w.h.live_talk_layout)).inflate());
            this.eub = (Button) this.esM.findViewById(w.h.pb_head_function_manage_go_to_live_post);
            this.etr = this.esM.findViewById(w.h.new_pb_header_item_line_above_livepost);
        }
        int sQ = bqVar.sQ();
        String string = this.elf.getPageContext().getString(w.l.go_to_live_post_prefix);
        if (sQ == 0) {
            string = String.valueOf(string) + this.elf.getPageContext().getString(w.l.go_to_interview_post);
        } else if (sQ == 1) {
            string = String.valueOf(string) + this.elf.getPageContext().getString(w.l.go_to_discuss_post);
        }
        this.eub.setText(string);
        this.eub.setVisibility(0);
        this.eub.setOnClickListener(this.bVy);
        this.evc = true;
        aMI();
    }

    public void aX(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.etE == null) {
            this.etE = LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.elf.getLayoutMode().t(this.etE);
        if (this.etD == null) {
            this.etD = new Dialog(this.elf.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.etD.setCanceledOnTouchOutside(true);
            this.etD.setCancelable(true);
            this.etD.setContentView(this.etE);
            WindowManager.LayoutParams attributes = this.etD.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.elf.getPageContext().getPageActivity()) * 0.9d);
            this.etD.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.etD.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.etD.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.etD.findViewById(w.h.disable_reply_btn);
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
            textView.setOnClickListener(new ge(this));
        }
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name)) || aMV()) {
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
            textView2.setOnClickListener(new gf(this));
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
            textView3.setOnClickListener(new gg(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.etD, this.elf.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.euZ = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(euw, Integer.valueOf(eux));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.etF = new com.baidu.tbadk.core.dialog.a(this.elf.getActivity());
        this.etF.bY(i3);
        this.etF.A(sparseArray);
        this.etF.a(w.l.dialog_ok, this.elf);
        this.etF.b(w.l.dialog_cancel, new gh(this));
        this.etF.ar(true);
        this.etF.b(this.elf.getPageContext());
        this.etF.tc();
    }

    public void ak(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.etR == null) {
            this.etR = LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.commit_good, (ViewGroup) null);
        }
        this.elf.getLayoutMode().t(this.etR);
        if (this.etQ == null) {
            this.etQ = new Dialog(this.elf.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.etQ.setCanceledOnTouchOutside(true);
            this.etQ.setCancelable(true);
            this.eua = (ScrollView) this.etR.findViewById(w.h.good_scroll);
            this.etQ.setContentView(this.etR);
            WindowManager.LayoutParams attributes = this.etQ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds540);
            this.etQ.getWindow().setAttributes(attributes);
            this.etT = new gi(this);
            this.etS = (LinearLayout) this.etR.findViewById(w.h.good_class_group);
            this.etV = (TextView) this.etR.findViewById(w.h.dialog_button_cancel);
            this.etV.setOnClickListener(new gj(this));
            this.etU = (TextView) this.etR.findViewById(w.h.dialog_button_ok);
            this.etU.setOnClickListener(this.bVy);
        }
        this.etS.removeAllViews();
        this.esL = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bI = bI("0", this.elf.getPageContext().getString(w.l.def_good_class));
        this.esL.add(bI);
        bI.setChecked(true);
        this.etS.addView(bI);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bI2 = bI(String.valueOf(arrayList.get(i2).pQ()), arrayList.get(i2).pP());
                this.esL.add(bI2);
                View view = new View(this.elf.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds1));
                com.baidu.tbadk.core.util.aq.k(view, w.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.etS.addView(view);
                this.etS.addView(bI2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eua.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.elf.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.elf.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.elf.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eua.setLayoutParams(layoutParams2);
            this.eua.removeAllViews();
            this.eua.addView(this.etS);
        }
        com.baidu.adp.lib.g.j.a(this.etQ, this.elf.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bI(String str, String str2) {
        Activity pageActivity = this.elf.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds100));
        aVar.setOnCheckedChangeListener(this.etT);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aMw() {
        this.elf.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.elf.hideProgressBar();
        if (z && z2) {
            this.elf.showToast(this.elf.getPageContext().getString(w.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(w.l.neterror);
            }
            this.elf.showToast(str);
        }
    }

    public void aqn() {
        this.etC.setVisibility(0);
    }

    public void aqm() {
        this.etC.setVisibility(8);
    }

    public View aMx() {
        if (this.etR != null) {
            return this.etR.findViewById(w.h.dialog_button_ok);
        }
        return null;
    }

    public String aMy() {
        return this.etW;
    }

    public View getView() {
        return this.bMv;
    }

    public void aMz() {
        com.baidu.adp.lib.util.k.b(this.elf.getPageContext().getPageActivity(), this.elf.getCurrentFocus());
    }

    public void iP(boolean z) {
        this.elf.hideProgressBar();
        avy();
    }

    public void aMA() {
        this.etA.wh();
        this.etA.wl();
    }

    public void aMB() {
        this.elf.hideProgressBar();
        wm();
        this.esK.completePullRefreshPostDelayed(2000L);
        aMI();
    }

    public void aMC() {
        this.esK.completePullRefreshPostDelayed(2000L);
        aMI();
    }

    public void iQ(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eue.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.elf.getResources().getDimensionPixelSize(w.f.ds84) : 0;
        this.eue.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.etv.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.etX != null) {
            this.etX.dismiss();
            this.etX = null;
        }
        this.etX = new com.baidu.tbadk.core.dialog.c(this.elf.getPageContext().getPageActivity());
        this.etX.cb(w.l.operation);
        if (z2) {
            this.etX.a(new String[]{this.elf.getPageContext().getString(w.l.copy)}, bVar);
        } else if (!z) {
            this.etX.a(new String[]{this.elf.getPageContext().getString(w.l.copy), this.elf.getPageContext().getString(w.l.mark)}, bVar);
        } else {
            this.etX.a(new String[]{this.elf.getPageContext().getString(w.l.copy), this.elf.getPageContext().getString(w.l.remove_mark)}, bVar);
        }
        this.etX.d(this.elf.getPageContext());
        this.etX.tf();
    }

    public int aMD() {
        return oJ(this.esK.getFirstVisiblePosition());
    }

    private int oJ(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.esK.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.esK.getAdapter() == null || !(this.esK.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.esK.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aME() {
        int lastVisiblePosition = this.esK.getLastVisiblePosition();
        if (this.esB != null) {
            if (lastVisiblePosition == this.esK.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.etv.aKw();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return oJ(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.esK.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.ety.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void l(com.baidu.tieba.pb.data.f fVar) {
        this.etv.a(fVar, false);
        this.etv.notifyDataSetChanged();
        aMI();
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        if (this.eti == null) {
            this.elf.getLayoutMode().t(((ViewStub) this.esM.findViewById(w.h.praise_layout)).inflate());
            this.eti = (FrsPraiseView) this.esM.findViewById(w.h.pb_head_praise_view);
            this.eti.setIsFromPb(true);
            this.ett = this.esM.findViewById(w.h.new_pb_header_item_line_above_praise);
            this.eti.dn(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.eti != null) {
            boolean aMI = aMI();
            this.eti.setVisibility(8);
            if (fVar != null && fVar.qx() != null && fVar.qx().qu() == 0 && this.ekb) {
                if (aMI) {
                    this.ets.setVisibility(0);
                } else {
                    this.ets.setVisibility(8);
                }
            } else {
                this.ets.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.aj(this.ets);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aIK() != null) {
            return fVar.aIK();
        }
        if (z) {
            if (fVar == null || fVar.aID() == null || fVar.aID().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aID().get(0);
            if (postData.big() != 1) {
                postData = a(fVar);
            }
            if (postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
                return postData;
            }
            return postData;
        }
        PostData aII = fVar.aII();
        if (aII == null) {
            return a(fVar);
        }
        return aII;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aIB() == null || fVar.aIB().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aIB().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aIB().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.sm(1);
        postData.setId(fVar.aIB().rK());
        postData.setTitle(fVar.aIB().getTitle());
        postData.setTime(fVar.aIB().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x038c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        String d;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.g bij;
        String portrait;
        if (fVar != null && fVar.aIB() != null) {
            PostData c = c(fVar, z);
            a(c, fVar);
            aMW();
            this.esU.setVisibility(8);
            if (fVar.aIB() != null && fVar.aIB().sh() && fVar.aIB().rL() != null) {
                this.euH = true;
                this.esG.jc(this.euH);
                if (this.esB == null) {
                    this.esB = new com.baidu.tieba.pb.video.l(this.elf, this.esG, fVar.aIB().rL());
                    this.esB.a(fVar.aIB().rL(), fVar.aIB(), fVar.getForumId());
                    this.esB.startPlay();
                } else if (this.esE) {
                    this.esB.a(fVar.aIB().rL(), fVar.aIB(), fVar.getForumId());
                    this.esB.startPlay();
                }
                if (fVar.aIC() != null && fVar.aIC().size() >= 1) {
                    com.baidu.tbadk.core.data.bl blVar = fVar.aIC().get(0);
                    this.esB.U(blVar);
                    this.esB.oo(blVar.getTitle());
                }
                this.esB.b(c, fVar.aIB(), fVar.aIY());
                this.esE = false;
                this.esK.removeHeaderView(this.esB.aOX());
                this.esK.addHeaderView(this.esB.aOX(), 0);
                if (this.esC == null) {
                    this.esC = new com.baidu.tieba.pb.video.k(this.elf);
                }
                this.esC.a(fVar.aIB().sx(), fVar.aIB(), fVar.aIU());
                this.esK.removeHeaderView(this.esC.aOO());
                this.esK.addHeaderView(this.esC.aOO(), 1);
                if (fVar.aIB().sx() != null) {
                    this.esK.removeHeaderView(this.esC.aOP());
                    this.esK.removeHeaderView(this.esQ);
                    this.esK.addHeaderView(this.esC.aOP(), 2);
                } else {
                    if (this.esC.aOP() != null) {
                        this.esK.removeHeaderView(this.esC.aOP());
                    }
                    this.esK.removeHeaderView(this.esQ);
                    this.esK.addHeaderView(this.esQ, 2);
                }
                if (this.esB != null) {
                    this.esB.oP(0);
                }
                aMH();
            } else {
                this.euH = false;
                this.esG.jc(this.euH);
                this.esG.exj.setVisibility(0);
                if (this.esB != null) {
                    this.esK.removeHeaderView(this.esB.aOX());
                }
                if (this.esC != null) {
                    this.esC.e(this.esK);
                }
            }
            if (this.elf.aJD() != null) {
                this.elf.aJD().iY(this.euH);
            }
            gk gkVar = new gk(this);
            if (this.esB != null) {
                this.esB.K(gkVar);
            }
            b(fVar, z);
            if (c != null) {
                this.eum = c;
                if (fVar != null && fVar.aIB() != null && fVar.aIB().getAuthor() != null) {
                    fVar.aIB().getAuthor().getUserId();
                    if (fVar.qx() != null) {
                        this.euM = fVar.qx().qq();
                        if (fVar.qx().qt() == 1) {
                        }
                    }
                }
                this.esU.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.esU.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.esU.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_clip_board, c);
                sparseArray.put(w.h.tag_is_subpb, false);
                fVar.aIB().sd();
                if (!this.euR) {
                    this.esO.setVisibility(0);
                }
                if (!fVar.aIB().sh() && this.esP.getText() != null && this.esP.getText().length() > 0) {
                    this.esP.setVisibility(0);
                } else {
                    this.esP.setVisibility(8);
                }
                m(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rF = fVar.aIB().rF();
                if (rF != null && rF.size() > 0 && !this.euR) {
                    this.eup.setText(String.valueOf(rF.get(0).ph()));
                    this.euo.setVisibility(0);
                    this.evb = true;
                } else {
                    this.euo.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.j(this.euo, w.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.aq.c(this.eup, w.e.cp_link_tip_d, 1);
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
                            if (this.eoG != null) {
                                this.eoG.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                                this.eoG.setOnClickListener(this.elf.elV.ccV);
                                this.eoG.a(iconInfo, i3, this.elf.getResources().getDimensionPixelSize(w.f.ds26), this.elf.getResources().getDimensionPixelSize(w.f.ds26), this.elf.getResources().getDimensionPixelSize(w.f.ds8));
                            }
                            if (this.eoF != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eoF.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eoF.setOnClickListener(this.elf.elV.ewB);
                                this.eoF.a(tShowInfoNew, 3, this.elf.getResources().getDimensionPixelSize(w.f.ds36), this.elf.getResources().getDimensionPixelSize(w.f.ds36), this.elf.getResources().getDimensionPixelSize(w.f.ds8), true);
                            }
                            this.esW.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.esW.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                            this.esW.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                                com.baidu.tbadk.core.util.aq.c(this.esW, w.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aq.c(this.esW, w.e.cp_cont_f, 1);
                            }
                            if (c == null && !TextUtils.isEmpty(c.getAuthor().getGodIntro())) {
                                this.esX.setVisibility(0);
                                this.esX.setText(fw.a(c.getAuthor()));
                            } else {
                                this.esX.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.aq.c(this.esY, w.e.cp_link_tip_a, 1);
                            this.esY.setVisibility(0);
                            if (fVar.aIB().getAuthor() != null && fVar.aIB().getAuthor().getAlaUserData() != null && this.ete != null) {
                                if (fVar.aIB().getAuthor().getAlaUserData().anchor_live != 0 && fVar.aIB().getAuthor().getAlaUserData().enter_live == 0) {
                                    this.ete.setVisibility(8);
                                } else {
                                    this.ete.setVisibility(0);
                                    if (this.esD == null) {
                                        this.esD = new com.baidu.tieba.d.a(this.elf.getPageContext(), this.ete);
                                        this.esD.hz(1);
                                    }
                                    this.esD.aB(this.elf.getResources().getString(w.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.PW = fVar.aIB().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.ete.setTag(aVar);
                                }
                            }
                            this.etd.setUserId(c.getAuthor().getUserId());
                            this.etd.setUserName(c.getAuthor().getUserName());
                            this.etd.setImageDrawable(null);
                            this.etd.setRadius(com.baidu.adp.lib.util.k.g(this.elf.getActivity(), w.f.ds40));
                            this.etd.setTag(c.getAuthor().getUserId());
                            this.etn.setText(c.bii());
                            bij = c.bij();
                            if (bij == null && !TextUtils.isEmpty(bij.getName()) && !TextUtils.isEmpty(bij.getName().trim())) {
                                String name = bij.getName();
                                String lat = bij.getLat();
                                String lng = bij.getLng();
                                this.bvK.setVisibility(0);
                                this.bvK.setText(bij.getName());
                                this.bvK.setOnClickListener(new gl(this, lat, lng, name));
                            } else {
                                this.bvK.setVisibility(8);
                            }
                            this.etl.a(c.getAuthor());
                            this.etl.esu = this.euH;
                            if (!this.etZ) {
                                this.etk.setVisibility(8);
                                this.etm.setVisibility(0);
                                this.etm.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.pb_thread_views), com.baidu.tbadk.core.util.au.v(fVar.aIX())));
                            } else if (!PbNormalLikeButtonSwitchStatic.FX() || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.etk.setVisibility(8);
                                this.etm.setVisibility(8);
                            } else {
                                this.etk.setVisibility(0);
                                this.etk.setTextSize(0, com.baidu.adp.lib.util.k.g(this.elf.getActivity(), w.f.ds24));
                                this.etm.setVisibility(8);
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null && !StringUtils.isNull(c.getAuthor().getPendantData().pL())) {
                                UtilHelper.showHeadImageViewBigV(this.eta.getHeadView(), c.getAuthor());
                                this.etd.setVisibility(8);
                                this.eta.setVisibility(0);
                                if (this.etj != null) {
                                    this.etj.setVisibility(8);
                                }
                                this.esW.setOnClickListener(gkVar);
                                this.eta.getHeadView().c(portrait, 28, false);
                                this.eta.getHeadView().setUserId(c.getAuthor().getUserId());
                                this.eta.getHeadView().setUserName(c.getAuthor().getUserName());
                                this.eta.getHeadView().setOnClickListener(gkVar);
                                this.eta.dP(c.getAuthor().getPendantData().pL());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.etd, c.getAuthor());
                                this.etd.setVisibility(0);
                                this.esU.setOnClickListener(gkVar);
                                this.esW.setOnClickListener(gkVar);
                                this.etd.setOnClickListener(gkVar);
                                this.eta.setVisibility(8);
                                this.etd.c(portrait, 28, false);
                            }
                        }
                        d = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eoG != null) {
                        }
                        if (this.eoF != null) {
                        }
                        this.esW.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.esW.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.esW.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                        }
                        if (c == null) {
                        }
                        this.esX.setVisibility(8);
                        com.baidu.tbadk.core.util.aq.c(this.esY, w.e.cp_link_tip_a, 1);
                        this.esY.setVisibility(0);
                        if (fVar.aIB().getAuthor() != null) {
                            if (fVar.aIB().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                            this.ete.setVisibility(0);
                            if (this.esD == null) {
                            }
                            this.esD.aB(this.elf.getResources().getString(w.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                            com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                            aVar2.PW = fVar.aIB().getAuthor().getAlaUserData();
                            aVar2.type = 2;
                            this.ete.setTag(aVar2);
                        }
                        this.etd.setUserId(c.getAuthor().getUserId());
                        this.etd.setUserName(c.getAuthor().getUserName());
                        this.etd.setImageDrawable(null);
                        this.etd.setRadius(com.baidu.adp.lib.util.k.g(this.elf.getActivity(), w.f.ds40));
                        this.etd.setTag(c.getAuthor().getUserId());
                        this.etn.setText(c.bii());
                        bij = c.bij();
                        if (bij == null) {
                        }
                        this.bvK.setVisibility(8);
                        this.etl.a(c.getAuthor());
                        this.etl.esu = this.euH;
                        if (!this.etZ) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.etd, c.getAuthor());
                        this.etd.setVisibility(0);
                        this.esU.setOnClickListener(gkVar);
                        this.esW.setOnClickListener(gkVar);
                        this.etd.setOnClickListener(gkVar);
                        this.eta.setVisibility(8);
                        this.etd.c(portrait, 28, false);
                    } else {
                        if (com.baidu.adp.lib.util.j.aF(string) > 14) {
                            d = com.baidu.tbadk.core.util.au.d(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eoG != null) {
                            }
                            if (this.eoF != null) {
                            }
                            this.esW.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.esW.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                            this.esW.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                            }
                            if (c == null) {
                            }
                            this.esX.setVisibility(8);
                            com.baidu.tbadk.core.util.aq.c(this.esY, w.e.cp_link_tip_a, 1);
                            this.esY.setVisibility(0);
                            if (fVar.aIB().getAuthor() != null) {
                            }
                            this.etd.setUserId(c.getAuthor().getUserId());
                            this.etd.setUserName(c.getAuthor().getUserName());
                            this.etd.setImageDrawable(null);
                            this.etd.setRadius(com.baidu.adp.lib.util.k.g(this.elf.getActivity(), w.f.ds40));
                            this.etd.setTag(c.getAuthor().getUserId());
                            this.etn.setText(c.bii());
                            bij = c.bij();
                            if (bij == null) {
                            }
                            this.bvK.setVisibility(8);
                            this.etl.a(c.getAuthor());
                            this.etl.esu = this.euH;
                            if (!this.etZ) {
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.etd, c.getAuthor());
                            this.etd.setVisibility(0);
                            this.esU.setOnClickListener(gkVar);
                            this.esW.setOnClickListener(gkVar);
                            this.etd.setOnClickListener(gkVar);
                            this.eta.setVisibility(8);
                            this.etd.c(portrait, 28, false);
                        }
                        d = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eoG != null) {
                        }
                        if (this.eoF != null) {
                        }
                        this.esW.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.esW.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.esW.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.x.r(tShowInfoNew)) {
                        }
                        if (c == null) {
                        }
                        this.esX.setVisibility(8);
                        com.baidu.tbadk.core.util.aq.c(this.esY, w.e.cp_link_tip_a, 1);
                        this.esY.setVisibility(0);
                        if (fVar.aIB().getAuthor() != null) {
                        }
                        this.etd.setUserId(c.getAuthor().getUserId());
                        this.etd.setUserName(c.getAuthor().getUserName());
                        this.etd.setImageDrawable(null);
                        this.etd.setRadius(com.baidu.adp.lib.util.k.g(this.elf.getActivity(), w.f.ds40));
                        this.etd.setTag(c.getAuthor().getUserId());
                        this.etn.setText(c.bii());
                        bij = c.bij();
                        if (bij == null) {
                        }
                        this.bvK.setVisibility(8);
                        this.etl.a(c.getAuthor());
                        this.etl.esu = this.euH;
                        if (!this.etZ) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.etd, c.getAuthor());
                        this.etd.setVisibility(0);
                        this.esU.setOnClickListener(gkVar);
                        this.esW.setOnClickListener(gkVar);
                        this.etd.setOnClickListener(gkVar);
                        this.eta.setVisibility(8);
                        this.etd.c(portrait, 28, false);
                    }
                }
                if (fVar != null) {
                    this.esT.O(fVar.aIB());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rP() != null) {
            this.esV.a(this.elf.getPageContext(), fVar.aID().get(0).rP(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aIz().getId(), fVar.aIz().getName(), fVar.aIB().getId(), this.elf.aKh() ? "FRS" : null));
            this.esU.setPadding(this.esU.getPaddingLeft(), (int) this.elf.getResources().getDimension(w.f.ds20), this.esU.getPaddingRight(), this.esU.getPaddingBottom());
            return;
        }
        this.esV.a(null, null, null);
    }

    public void aMF() {
        if (this.esB != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11997").r("obj_type", 1));
            this.esB.aOY();
            this.esK.smoothScrollToPosition(0);
        }
    }

    public boolean aMG() {
        return this.evd;
    }

    private boolean Nm() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean J(com.baidu.tbadk.core.data.bl blVar) {
        if (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), blVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.esG.aNB();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.esG.lD(eVar.forumName);
            }
            String string = this.elf.getResources().getString(w.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.elf.getResources().getString(w.l.self);
                    break;
                case 300:
                    str = this.elf.getResources().getString(w.l.bawu);
                    break;
                case 400:
                    str = this.elf.getResources().getString(w.l.system);
                    break;
            }
            this.elf.showNetRefreshView(this.bMv, String.format(string, str), null, this.elf.getResources().getString(w.l.appeal_restore), true, new gn(this, eVar.eir));
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aLY;
        String sb;
        if (fVar != null) {
            this.epx = fVar;
            this.mType = i;
            if (fVar.aIB() != null) {
                this.eut = fVar.aIB().ri();
                this.Yw = fVar.aIB().rf();
                if (fVar.aIB().getAnchorLevel() != 0) {
                    this.evd = true;
                }
                this.etZ = J(fVar.aIB());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
                if (this.etl != null) {
                    this.etl.isBigV = fVar.getUserData().isBigV();
                }
            }
            o(fVar);
            this.eun = false;
            this.ekb = z;
            aMB();
            b(fVar, z, i);
            if (this.elf.aJX()) {
                if (this.etz == null) {
                    this.etz = new com.baidu.tieba.pb.view.ac(this.elf.getPageContext());
                    this.etz.le();
                    this.etz.a(this.alb);
                }
                this.esK.setPullRefresh(this.etz);
                aMH();
                if (this.etz != null) {
                    this.etz.dj(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (fVar.qx().qu() == 0 && z) {
                this.esK.setPullRefresh(null);
                this.esA = 1;
            } else {
                if (this.etz == null) {
                    this.etz = new com.baidu.tieba.pb.view.ac(this.elf.getPageContext());
                    this.etz.le();
                    this.etz.a(this.alb);
                }
                this.esK.setPullRefresh(this.etz);
                aMH();
                this.esA = 2;
                if (this.etz != null) {
                    this.etz.dj(TbadkCoreApplication.m9getInst().getSkinType());
                }
                Pe();
            }
            aMI();
            this.etv.ia(this.ekb);
            this.etv.ib(false);
            this.etv.im(i == 5);
            this.etv.in(i == 6);
            this.etv.a(fVar, false);
            this.etv.notifyDataSetChanged();
            if (this.elf.aKl()) {
                if (fVar.aIA() != null) {
                    this.mForumName = fVar.aIA().getForumName();
                    this.mForumId = fVar.aIA().getForumId();
                }
                if (this.mForumName == null && this.elf.aJF() != null && this.elf.aJF().aKM() != null) {
                    this.mForumName = this.elf.aJF().aKM();
                }
                this.esG.lD(this.mForumName);
            } else {
                this.esG.lD(null);
            }
            if (this.elf.aKl()) {
                int i4 = 0;
                PostData c = c(fVar, z);
                if (c != null && c.getAuthor() != null) {
                    i4 = c.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.esZ.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.c(this.esZ, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.esZ.setVisibility(8);
                }
            } else {
                this.esZ.setVisibility(8);
            }
            if (fVar.aIB() != null && fVar.aIB().rk() != null) {
                if (fVar.aIB().rk().getNum() < 1) {
                    sb = this.elf.getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(fVar.aIB().rk().getNum())).toString();
                }
                if (this.esw != -1) {
                    fVar.aIB().rk().setIsLike(this.esw);
                }
                M(sb, fVar.aIB().rk().getIsLike() == 1);
            }
            if (fVar.qx().qt() == 0 && !z) {
                this.esK.setNextPage(null);
                this.esF = 1;
            } else if (this.elf.isLogin()) {
                this.esK.setNextPage(this.etA);
                this.esF = 2;
                Pe();
            } else if (fVar.qx().qt() == 1) {
                this.eun = true;
                if (this.etB == null) {
                    this.etB = new com.baidu.tieba.pb.view.b(this.elf.getPageContext());
                }
                this.esK.setNextPage(this.etB);
                this.esF = 3;
            }
            ArrayList<PostData> aID = fVar.aID();
            if (fVar.qx().qt() == 0 || aID == null || aID.size() < fVar.qx().qs()) {
                if (com.baidu.tbadk.core.util.x.q(aID) == 0 || (com.baidu.tbadk.core.util.x.q(aID) == 1 && aID.get(0) != null && aID.get(0).big() == 1)) {
                    this.etA.setText(this.elf.getResources().getString(w.l.list_no_more_new));
                } else {
                    this.etA.setText("");
                }
                if (this.elf.aJX() && this.esK != null && this.esK.getData() != null && this.esK.getData().size() == 1 && (this.esK.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.etA.setText("");
                }
                aMN();
            } else if (z2) {
                if (this.eva) {
                    wm();
                    if (fVar.qx().qt() != 0) {
                        this.etA.setText(this.elf.getResources().getString(w.l.pb_load_more));
                    }
                } else {
                    this.etA.wh();
                    this.etA.wn();
                }
            } else {
                this.etA.wh();
                this.etA.wn();
            }
            if (fVar.aIB() != null && fVar.aIB().getAuthor() != null && fVar.aIB().getAuthor().getType() == 0) {
                this.esG.aNy();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.esK.getData() != null || fVar.aID() != null) {
                        i5 = (this.esK.getData().size() - fVar.aID().size()) + this.esK.getHeaderViewsCount();
                    }
                    this.esK.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aLY = fg.aLX().aLY()) != null) {
                        this.euV = true;
                        this.esK.onRestoreInstanceState(aLY);
                        break;
                    } else {
                        this.esK.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.eva = false;
                    break;
                case 5:
                    this.esK.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aLY2 = fg.aLX().aLY();
                        this.euV = true;
                        if (aLY2 != null) {
                            this.esK.onRestoreInstanceState(aLY2);
                            break;
                        }
                    }
                    this.esK.setSelection(0);
                    break;
            }
            if (this.euG >= 0) {
                this.esK.setSelectionFromTop(this.euG, (int) this.euF);
                this.euG = -1;
            }
            if (this.eut == euv && Nm()) {
                aMQ();
            }
            if (!this.euV && fVar.aIK() == null && !fVar.aIB().sh()) {
                this.euE.aB(this.elf.getResources().getString(w.l.pb_more_tools_guide_tip), String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips");
                this.euV = true;
            }
            if (this.esC != null) {
                this.esC.T(fVar.aIB());
            }
            this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void aMH() {
        if (this.esB != null && this.esB.aOX() != null) {
            this.esK.removeHeaderView(this.avt);
            if (this.mType != 1) {
                this.esK.removeHeaderView(this.esB.aOX());
                this.esK.addHeaderView(this.esB.aOX(), 0);
                this.esK.setSelection(0);
                return;
            }
            return;
        }
        if (this.esB != null) {
            this.esK.removeHeaderView(this.esB.aOX());
        }
        this.esK.removeHeaderView(this.avt);
        this.esK.addHeaderView(this.avt, 0);
    }

    public void iR(boolean z) {
        this.etY = z;
        this.esG.iR(z);
    }

    public void wm() {
        if (this.etA != null) {
            this.etA.wi();
            this.etA.wm();
        }
        Pe();
    }

    public void My() {
        this.esK.setVisibility(0);
    }

    private boolean aMI() {
        boolean z;
        if (this.eub != null && this.eub.getVisibility() == 0) {
            z = true;
            if (this.etr != null) {
                this.etr.setVisibility(0);
            }
        } else {
            if (this.etr != null) {
                this.etr.setVisibility(8);
            }
            z = false;
        }
        if ((this.ett == null || this.ett.getVisibility() == 8) && z && this.ekb) {
            this.ets.setVisibility(0);
        } else {
            this.ets.setVisibility(8);
        }
        com.baidu.tieba.graffiti.c.aj(this.ets);
        return z;
    }

    private boolean n(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aIB() == null) {
            return false;
        }
        if (fVar.aIB().rs() == 1 || fVar.aIB().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aIB().ru() == null || fVar.aIB().ru().sP() == 0) || fVar.aIB().rq() == 1 || fVar.aIB().rr() == 1 || fVar.aIB().rZ() || fVar.aIB().sm() || fVar.aIB().sg() || fVar.aIB().rG() != null || fVar.aIB().sn() || fVar.aIB().sn() || !com.baidu.tbadk.core.util.au.isEmpty(fVar.aIB().rm()) || fVar.aIB().rx();
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return com.baidu.tieba.card.at.a((Context) this.elf.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.esO != null) {
                if (fVar.aIB() != null && fVar.aIB().rJ() == 0 && !fVar.aIB().sh() && !this.euR) {
                    this.esO.setVisibility(0);
                    fVar.aIB().sd();
                    if (fVar.aIB() != null) {
                        fVar.aIB().e(true, n(fVar));
                    }
                    SpannableStringBuilder rU = fVar.aIB().rU();
                    this.esP.setOnTouchListener(new com.baidu.tieba.view.aa(rU));
                    if (rU == null || rU.length() == 0) {
                        this.esP.setVisibility(8);
                        this.esU.setPadding(this.esU.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds48), this.esU.getPaddingRight(), this.esU.getPaddingBottom());
                    } else {
                        this.esP.setText(rU);
                        this.esP.setVisibility(0);
                    }
                } else {
                    this.esO.setVisibility(8);
                    this.esK.removeHeaderView(this.esO);
                    if (fVar.aIB() != null && fVar.aIB().sh()) {
                        this.esU.setPadding(this.esU.getPaddingLeft(), 0, this.esU.getPaddingRight(), this.esU.getPaddingBottom());
                    } else {
                        this.esU.setPadding(this.esU.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds48), this.esU.getPaddingRight(), this.esU.getPaddingBottom());
                    }
                }
            }
            this.ekb = z;
            com.baidu.tbadk.core.data.bl aIB = fVar.aIB();
            if (aIB != null) {
                a(aIB.ru());
            }
        }
        return false;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aMI();
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
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aIM()));
            sparseArray.put(w.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(w.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(w.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(w.h.tag_del_post_id, c.getId());
            sparseArray.put(w.h.tag_del_post_type, 0);
            sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aIM()));
            sparseArray.put(w.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aFg;
    }

    public void nY(String str) {
        if (this.etA != null) {
            this.etA.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.esK;
    }

    public int aMJ() {
        return w.h.richText;
    }

    public TextView aJz() {
        return this.esT.aJz();
    }

    public void d(BdListView.e eVar) {
        this.esK.setOnSrollToBottomListener(eVar);
    }

    public void a(ae.b bVar) {
        this.alb = bVar;
        if (this.etz != null) {
            this.etz.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, a.b bVar) {
        if (arVar != null) {
            int qr = arVar.qr();
            int qo = arVar.qo();
            if (this.etw != null) {
                this.etw.tc();
            } else {
                this.etw = new com.baidu.tbadk.core.dialog.a(this.elf.getPageContext().getPageActivity());
                this.etx = LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.dialog_direct_pager, (ViewGroup) null);
                this.etw.v(this.etx);
                this.etw.a(w.l.dialog_ok, bVar);
                this.etw.b(w.l.dialog_cancel, new go(this));
                this.etw.a(new gp(this));
                this.etw.b(this.elf.getPageContext()).tc();
            }
            this.ety = (EditText) this.etx.findViewById(w.h.input_page_number);
            this.ety.setText("");
            TextView textView = (TextView) this.etx.findViewById(w.h.current_page_number);
            if (qr <= 0) {
                qr = 1;
            }
            if (qo <= 0) {
                qo = 1;
            }
            textView.setText(MessageFormat.format(this.elf.getApplicationContext().getResources().getString(w.l.current_page), Integer.valueOf(qr), Integer.valueOf(qo)));
            this.elf.ShowSoftKeyPadDelay(this.ety, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.esK.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.elf.showToast(str);
    }

    public boolean iS(boolean z) {
        if (this.JU == null || !this.JU.Cp()) {
            return false;
        }
        this.JU.AG();
        return true;
    }

    public void aMK() {
        if (this.eve != null) {
            while (this.eve.size() > 0) {
                TbImageView remove = this.eve.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aMK();
        this.etv.ov(1);
        if (this.esB != null) {
            this.esB.onPause();
        }
    }

    public void onResume() {
        this.etv.ov(2);
        if (this.esB != null) {
            this.esB.onResume();
        }
        if (this.eus != null) {
            this.eus.onResume();
        }
    }

    public void onDestroy() {
        this.euE.We();
        if (this.esD != null) {
            this.esD.We();
        }
        if (this.esC != null) {
            this.esC.onDestroy();
        }
        this.elf.hideProgressBar();
        if (this.byr != null && this.byu != null) {
            this.byr.b(this.byu);
        }
        avy();
        wm();
        if (this.euB != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.euB);
        }
        if (this.euC != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.euC);
        }
        if (this.euQ != null) {
            this.euQ.removeAllViews();
        }
        if (this.esU != null && this.etj != null) {
            this.esU.removeView(this.etb);
            this.etj = null;
        }
        if (this.eur != null) {
            this.eur.clearStatus();
        }
        this.euW = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.etv.ov(3);
        if (this.bOo != null) {
            this.bOo.setBackgroundDrawable(null);
        }
        if (this.esB != null) {
            this.esB.destroy();
        }
        if (this.etv != null) {
            this.etv.onDestory();
        }
        this.bMv.getViewTreeObserver().removeGlobalOnLayoutListener(this.evf);
    }

    public boolean oK(int i) {
        if (this.esB != null) {
            return this.esB.oV(i);
        }
        return false;
    }

    public void avy() {
        this.esG.oh();
        this.euE.We();
        if (this.esD != null) {
            this.esD.We();
        }
        com.baidu.adp.lib.util.k.b(this.elf.getPageContext().getPageActivity(), this.ety);
        if (this.etX != null) {
            this.etX.dismiss();
        }
        aML();
        if (this.esC != null) {
            this.esC.aOQ();
        }
        if (this.etw != null) {
            this.etw.dismiss();
        }
        if (this.bVx != null) {
            this.bVx.dismiss();
        }
    }

    public void hZ(boolean z) {
        this.etv.hZ(z);
    }

    public void gz(boolean z) {
        this.dqY = z;
    }

    public void aML() {
        if (this.etF != null) {
            this.etF.dismiss();
        }
        if (this.etG != null) {
            com.baidu.adp.lib.g.j.b(this.etG, this.elf.getPageContext());
        }
        if (this.etQ != null) {
            com.baidu.adp.lib.g.j.b(this.etQ, this.elf.getPageContext());
        }
        if (this.etD != null) {
            com.baidu.adp.lib.g.j.b(this.etD, this.elf.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.epx, this.ekb);
            d(this.epx, this.ekb, this.mType);
            this.elf.getLayoutMode().ah(i == 1);
            this.elf.getLayoutMode().t(this.bMv);
            this.elf.getLayoutMode().t(this.esP);
            this.elf.getLayoutMode().t(this.esQ);
            this.elf.getLayoutMode().t(this.esM);
            if (this.eth != null) {
                com.baidu.tbadk.core.util.aq.c(this.eth, w.e.cp_cont_d, 1);
            }
            if (this.etg != null) {
                com.baidu.tbadk.core.util.aq.c(this.etg, w.e.cp_cont_d, 1);
            }
            if (this.esC != null) {
                this.esC.onChangeSkinType(i);
            }
            if (this.ete != null) {
                com.baidu.tbadk.core.util.aq.i(this.ete, w.e.cp_cont_f);
            }
            this.elf.getLayoutMode().t(this.esM);
            com.baidu.tbadk.core.util.aq.i(this.esP, w.e.cp_cont_b);
            this.esP.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            this.elf.getLayoutMode().t(this.aFg);
            if (this.etx != null) {
                this.elf.getLayoutMode().t(this.etx);
            }
            iR(this.etY);
            this.etv.notifyDataSetChanged();
            if (this.etz != null) {
                this.etz.dj(i);
            }
            if (this.etA != null) {
                this.etA.dj(i);
                com.baidu.tbadk.core.util.aq.j(this.aFg, w.g.pb_foot_more_trans_selector);
                this.etA.dh(w.g.pb_foot_more_trans_selector);
            }
            if (this.JU != null) {
                this.JU.onChangeSkinType(i);
            }
            if (this.eti != null) {
                this.eti.dn(i);
            }
            if (this.etB != null) {
                this.etB.dj(i);
            }
            if (this.esL != null && this.esL.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.esL) {
                    aVar.aNs();
                }
            }
            if (this.euQ != null) {
                com.baidu.tbadk.core.util.aq.k(this.euQ, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.k(this.euO, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.aq.c(this.euP, w.e.cp_cont_c, 1);
            }
            aM(i == 1);
            aMo();
            UtilHelper.setStatusBarBackground(this.bOo, i);
            if (this.etk != null) {
                this.etk.onChangeSkinType(i);
            }
            if (this.bvK != null) {
                com.baidu.tbadk.core.util.aq.i(this.bvK, w.e.cp_cont_d);
            }
            if (this.etn != null) {
                com.baidu.tbadk.core.util.aq.i(this.etn, w.e.cp_cont_f);
            }
            if (this.esY != null) {
                com.baidu.tbadk.core.util.aq.i(this.esY, w.e.cp_link_tip_a);
            }
            if (this.etm != null) {
                com.baidu.tbadk.core.util.aq.i(this.etm, w.e.cp_cont_f);
            }
            if (this.eto != null) {
                com.baidu.tbadk.m.a.a(this.elf.getPageContext(), this.eto);
            }
            if (this.euD != null) {
                this.euD.onChangeSkinType(i);
            }
            if (this.esG != null) {
                if (this.esB != null) {
                    this.esB.oP(i);
                } else {
                    this.esG.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.aq.i(this.esX, w.e.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aOb = eVar;
        this.etv.setOnImageClickListener(this.aOb);
    }

    public void c(NoNetworkView.a aVar) {
        this.byu = aVar;
        if (this.byr != null) {
            this.byr.a(this.byu);
        }
    }

    public void iT(boolean z) {
        this.etv.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aMM() {
        return this.eub;
    }

    public void aMN() {
        if (this.esF != 2) {
            this.esK.setNextPage(this.etA);
            this.esF = 2;
        }
    }

    public void aMO() {
        if (com.baidu.tbadk.j.aa.FE().FF()) {
            int lastVisiblePosition = this.esK.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.esK.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(w.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.j.u perfLog = tbImageView.getPerfLog();
                                perfLog.fb(1001);
                                perfLog.aGo = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.vT();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.j.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fb(1001);
                        perfLog2.aGo = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.vT();
                    }
                }
            }
        }
    }

    public void gA(boolean z) {
        if (this.euc != null) {
            if (this.dqY) {
                gB(z);
            } else {
                gC(z);
            }
        }
    }

    public void aMP() {
        if (this.euc != null) {
            this.euc.setVisibility(8);
            this.euh = false;
            if (this.eus != null) {
                this.eus.setVisibility(8);
            }
        }
    }

    public void Pd() {
        if (this.bgw == null) {
            this.bgw = new com.baidu.tbadk.core.view.a(this.elf.getPageContext());
        }
        this.bgw.aH(true);
    }

    public void Pe() {
        if (this.bgw != null) {
            this.bgw.aH(false);
        }
    }

    private int getScrollY() {
        View childAt = this.esK.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.esK.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.esB != null) {
            this.esB.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.evg = getScrollY();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z = false;
        this.euJ = false;
        if (this.esB != null) {
            this.esB.b(absListView, i);
        }
        a aVar = new a();
        aVar.evl = i;
        aVar.evm = this.esK.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
        int headerViewsCount = (i - this.esK.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                break;
            } else if (this.etv.ou(headerViewsCount) != com.baidu.tieba.pb.data.m.eji) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.etv.aKA().iM(z);
    }

    /* loaded from: classes.dex */
    public class a {
        public int evl;
        public int evm;

        public a() {
        }
    }

    public void aMQ() {
        if (!this.evh) {
            TiebaStatic.log("c10490");
            this.evh = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elf.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(euw, Integer.valueOf(euy));
            aVar.bX(w.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(w.h.function_description_view)).setText(w.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(w.h.title_view)).setText(w.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(w.l.grade_button_tips, this.elf);
            aVar.b(w.l.look_again, new gr(this));
            aVar.b(this.elf.getPageContext()).tc();
        }
    }

    public void aMR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elf.getPageContext().getPageActivity());
        aVar.cB(this.elf.getResources().getString(w.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(euw, Integer.valueOf(euA));
        aVar.A(sparseArray);
        aVar.a(w.l.upgrade_to_new, this.elf);
        aVar.b(w.l.cancel, new gs(this));
        aVar.b(this.elf.getPageContext()).tc();
    }

    public int ri() {
        return this.eut;
    }

    public void nZ(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elf.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.elf.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(w.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(w.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(euw, Integer.valueOf(euz));
        aVar.A(sparseArray);
        aVar.a(w.l.view, this.elf);
        aVar.b(w.l.cancel, new gt(this));
        aVar.b(this.elf.getPageContext()).tc();
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

    public PbInterviewStatusView aMS() {
        return this.eur;
    }

    private void o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aIB() != null && fVar.aIB().sm() && this.eur == null) {
            this.eur = (PbInterviewStatusView) this.euq.inflate();
            this.eur.setOnClickListener(this.bVy);
            this.eur.setCallback(this.elf.aKg());
            this.eur.a(this.elf, fVar);
        }
    }

    public LinearLayout aMT() {
        return this.etu;
    }

    public View aMU() {
        return this.bOo;
    }

    public boolean aMV() {
        return this.euR;
    }

    public void ie(boolean z) {
        this.esT.ie(z);
    }

    private void aMW() {
        if (this.euR) {
            if (this.euS == null) {
                f.a aVar = f.eli.get();
                if (aVar != null) {
                    this.euS = aVar.a(this.elf);
                    ListAdapter adapter = this.esK.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.avt) {
                            this.esK.addHeaderView(this.euS.aJx(), 1);
                        } else {
                            this.esK.addHeaderView(this.euS.aJx(), 0);
                        }
                    }
                } else {
                    this.esQ.setVisibility(0);
                    return;
                }
            }
            this.esQ.setVisibility(8);
            this.esK.removeHeaderView(this.esQ);
            return;
        }
        this.esQ.setVisibility(0);
    }

    public void iU(boolean z) {
        this.euR = z;
    }

    public void aMX() {
        this.elf.showNetRefreshView(getView(), "");
        View DX = this.elf.getRefreshView().DX();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) DX.getLayoutParams();
        layoutParams.addRule(3, aMT().getId());
        DX.setLayoutParams(layoutParams);
        this.elf.hideLoadingView(getView());
        if (this.euS != null) {
            this.esK.removeHeaderView(this.euS.aJx());
            this.euS = null;
        }
    }

    public void oa(String str) {
        if (this.esH != null) {
            this.esH.setTitle(str);
        }
    }

    private int iV(boolean z) {
        if (this.eur == null || this.eur.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.elf.getPageContext().getPageActivity(), w.f.ds72);
    }

    private void aMY() {
        if (this.eur != null && this.eur.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eur.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eur.setLayoutParams(layoutParams);
        }
    }

    public boolean aJG() {
        return false;
    }

    public boolean aMZ() {
        return this.euH;
    }

    public TextView aNa() {
        return this.eth;
    }

    public void ob(String str) {
        this.eue.performClick();
        if (!StringUtils.isNull(str) && this.elf.aJA() != null && this.elf.aJA().CM() != null && this.elf.aJA().CM().CE() != null) {
            EditText CE = this.elf.aJA().CM().CE();
            CE.setText(str);
            CE.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            avy();
            aMP();
            aMe();
            if (this.euD != null) {
                this.euD.aKE();
            }
            this.elf.aat();
            this.etu.setVisibility(8);
            this.esG.setTitleVisibility(false);
            this.elf.ik(false);
            if (this.esB != null) {
                if (configuration.orientation == 1) {
                    aMT().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.esK.setIsLandscape(true);
                    this.esK.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.esK.setIsLandscape(false);
                    if (this.evg > 0) {
                        this.esK.smoothScrollBy(this.evg, 0);
                    }
                }
                this.esB.onConfigurationChanged(configuration);
            }
        }
    }

    public void iW(boolean z) {
        this.esE = z;
    }

    public boolean aNb() {
        return this.esB != null && this.esB.aNb();
    }

    public void aNc() {
        if (this.esB != null) {
            this.esB.onPause();
        }
    }

    public void v(long j, int i) {
        if (this.esC != null) {
            this.esC.v(j, i);
        }
        if (this.esB != null) {
            this.esB.v(j, i);
        }
    }

    public void aNd() {
        if (this.eus != null) {
            this.eus.iX(true);
        }
    }

    public void aNe() {
        if (this.eus != null) {
            this.eus.setVisibility(8);
        }
    }

    public void io(boolean z) {
        this.etv.io(z);
    }
}
