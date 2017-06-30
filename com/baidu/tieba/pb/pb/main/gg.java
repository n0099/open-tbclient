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
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
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
public class gg {
    public static int eDH = 2;
    public static int eDI = 3;
    public static int eDJ = 0;
    public static int eDK = 3;
    public static int eDL = 4;
    public static int eDM = 5;
    public static int eDN = 6;
    private com.baidu.tbadk.editortools.j JT;
    private View aGu;
    private int aOS;
    private com.baidu.tieba.pb.a.d aPs;
    private ae.b alP;
    private TextView aww;
    private RelativeLayout bSW;
    private View bVj;
    private TextView byv;
    private NoNetworkView bzB;
    private View.OnClickListener cdH;
    public int eBH;
    private int eBI;
    private int eBJ;
    private int eBK;
    private com.baidu.tieba.pb.video.l eBM;
    private com.baidu.tieba.pb.video.k eBN;
    private com.baidu.tieba.d.a eBO;
    public final com.baidu.tieba.pb.pb.main.view.j eBR;
    public com.baidu.tieba.pb.pb.main.view.h eBS;
    private ViewStub eBT;
    private ViewStub eBU;
    private PbLandscapeListView eBV;
    private List<com.baidu.tieba.pb.pb.main.view.a> eBW;
    private View eBX;
    private TextView eCA;
    private View eCB;
    private View eCC;
    private ObservedChangeLinearLayout eCE;
    private dc eCF;
    private PbListView eCK;
    private View eCM;
    private LinearLayout eCb;
    private TextView eCc;
    private View eCd;
    private g eCe;
    private ColumnLayout eCf;
    private ThreadSkinView eCg;
    private TextView eCh;
    private TextView eCi;
    private TextView eCj;
    private ImageView eCk;
    private HeadPendantView eCl;
    private FrameLayout eCm;
    private HeadImageView eCn;
    private View eCo;
    private FloatingLayout eCp;
    private PbFirstFloorUserLikeButton eCu;
    private ge eCv;
    private TextView eCw;
    private TextView eCx;
    private LinearLayout eCy;
    private TextView eCz;
    private TextView eDA;
    private ViewStub eDB;
    private PbInterviewStatusView eDC;
    private ViewGroup eDD;
    private TextView eDE;
    private com.baidu.tieba.pb.pb.main.emotion.view.a eDF;
    private Runnable eDO;
    private Runnable eDP;
    private ei eDQ;
    private com.baidu.tieba.d.a eDR;
    private View eDn;
    private TextView eDo;
    private ViewGroup eDp;
    private TextView eDr;
    private boolean eDt;
    private int eDu;
    private int eDv;
    private int eDw;
    private PostData eDx;
    private View eDz;
    private View eEb;
    private TextView eEc;
    private LinearLayout eEd;
    private boolean eEe;
    private f eEf;
    private com.baidu.tbadk.core.view.userLike.c eEg;
    private com.baidu.tbadk.core.view.userLike.c eEh;
    private Runnable eEk;
    private PbActivity.a eEm;
    private boolean eEo;
    private boolean eEp;
    private int eEt;
    private View.OnClickListener ete;
    private PbActivity euf;
    PbActivity.c evR;
    private UserIconBox exL;
    private UserIconBox exM;
    private com.baidu.tieba.pb.data.f eyH;
    private PbFakeFloorModel eyj;
    private boolean isLandscape;
    private int mType;
    private int eBL = 1;
    private boolean eBP = false;
    private int eBQ = 0;
    private final Handler mHandler = new Handler();
    private View eBY = null;
    private LinearLayout eBZ = null;
    private TextView eCa = null;
    private TextView eCq = null;
    private TextView eCr = null;
    public FrsPraiseView eCs = null;
    private ClickableHeaderImageView eCt = null;
    private View eCD = null;
    private com.baidu.tbadk.core.dialog.a eCG = null;
    private com.baidu.tbadk.core.dialog.c cdG = null;
    private View eCH = null;
    private EditText eCI = null;
    private com.baidu.tieba.pb.view.ac eCJ = null;
    private com.baidu.tieba.pb.view.b eCL = null;
    private c.b dia = null;
    private TbRichTextView.e aPr = null;
    private NoNetworkView.a bzE = null;
    private Dialog eCN = null;
    private View eCO = null;
    private com.baidu.tbadk.core.dialog.a eCP = null;
    private Dialog eCQ = null;
    private View eCR = null;
    private int eCS = 0;
    private RadioGroup eCT = null;
    private RadioButton eCU = null;
    private RadioButton eCV = null;
    private RadioButton eCW = null;
    private Button eCX = null;
    private Button eCY = null;
    private TextView eCZ = null;
    private Dialog eDa = null;
    private View eDb = null;
    private LinearLayout eDc = null;
    private CompoundButton.OnCheckedChangeListener eDd = null;
    private TextView eDe = null;
    private TextView eDf = null;
    private String eDg = null;
    private com.baidu.tbadk.core.dialog.c eDh = null;
    private com.baidu.tbadk.core.dialog.c eDi = null;
    private boolean eDj = false;
    private boolean eDk = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eDl = null;
    private boolean dzL = false;
    private Button eDm = null;
    public ImageView eDq = null;
    private boolean eDs = true;
    private com.baidu.tbadk.core.view.a bjx = null;
    private boolean esZ = false;
    private int mSkinType = 3;
    private boolean eDy = false;
    private boolean mIsFromCDN = true;
    private int eDG = 0;
    private float eDS = -1.0f;
    private int eDT = -1;
    private boolean eDU = false;
    private a.InterfaceC0083a eDV = new gh(this);
    private boolean euN = false;
    private boolean eDW = false;
    private LinearLayout eDX = null;
    private TextView eDY = null;
    private int eDZ = 0;
    private boolean eEa = false;
    private boolean eEi = false;
    private int rank = 0;
    private CustomMessageListener duu = new gm(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private Handler eEj = new Handler();
    private CustomMessageListener eEl = new gv(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eEn = true;
    private boolean eEq = false;
    private boolean Yx = false;
    String userId = null;
    private final List<TbImageView> eEr = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener eEs = new hf(this);
    private boolean eEu = false;

    public void i(int i, float f) {
        this.eDT = i;
        this.eDS = f;
    }

    public f aQa() {
        return this.eEf;
    }

    public NoNetworkView aQb() {
        return this.bzB;
    }

    public void aQc() {
        if (this.JT != null) {
            this.JT.hide();
        }
    }

    public PbFakeFloorModel aQd() {
        return this.eyj;
    }

    public ei aQe() {
        return this.eDQ;
    }

    public void aOk() {
        reset();
        aQc();
        this.eDQ.aOB();
        gU(false);
    }

    private void reset() {
        if (this.euf != null && this.euf.aNu() != null && this.JT != null) {
            com.baidu.tbadk.editortools.pb.a.Dc().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aNu = this.euf.aNu();
            aNu.Dw();
            if (aNu.getWriteImagesInfo() != null) {
                aNu.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aNu.eJ(10);
            aNu.eH(SendView.ALL);
            aNu.eI(SendView.ALL);
            com.baidu.tbadk.editortools.p ey = this.JT.ey(23);
            com.baidu.tbadk.editortools.p ey2 = this.JT.ey(2);
            com.baidu.tbadk.editortools.p ey3 = this.JT.ey(5);
            if (ey2 != null) {
                ey2.lM();
            }
            if (ey3 != null) {
                ey3.lM();
            }
            if (ey != null) {
                ey.hide();
            }
            this.JT.invalidate();
        }
    }

    public boolean aQf() {
        return this.eDs;
    }

    public void gV(boolean z) {
        if (this.eDn != null && this.eDo != null) {
            this.eDo.setText(w.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eDn.startAnimation(alphaAnimation);
            }
            this.eDn.setVisibility(0);
            this.eDs = true;
            if (this.eDF != null) {
                this.eDF.setVisibility(0);
            }
        }
    }

    public void gW(boolean z) {
        if (this.eDn != null && this.eDo != null) {
            this.eDo.setText(w.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eDn.startAnimation(alphaAnimation);
            }
            this.eDn.setVisibility(0);
            this.eDs = true;
            if (this.eDF != null) {
                this.eDF.setVisibility(0);
            }
        }
    }

    public PostData aQg() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.eBV == null) {
            return null;
        }
        int firstVisiblePosition = this.eBV.getFirstVisiblePosition();
        int lastVisiblePosition = this.eBV.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eBV.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.eBV.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.eBV.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.eCF.oL(headerViewsCount) != null && this.eCF.oL(headerViewsCount) != PostData.fMf) {
            i2 = headerViewsCount + 1;
        }
        return this.eCF.getItem(i2) instanceof PostData ? (PostData) this.eCF.getItem(i2) : null;
    }

    public gg(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.aOS = 0;
        this.eBI = 0;
        this.eBJ = 0;
        this.eBK = 0;
        this.euf = null;
        this.bSW = null;
        this.bVj = null;
        this.eBV = null;
        this.eBX = null;
        this.eCb = null;
        this.eCc = null;
        this.eCd = null;
        this.eCf = null;
        this.eCh = null;
        this.eCj = null;
        this.eCm = null;
        this.eCn = null;
        this.eCo = null;
        this.eCu = null;
        this.eCw = null;
        this.eCx = null;
        this.byv = null;
        this.eCB = null;
        this.eCC = null;
        this.eCF = null;
        this.eCK = null;
        this.aGu = null;
        this.cdH = null;
        this.ete = null;
        this.eDn = null;
        this.eDo = null;
        this.eDp = null;
        this.eDr = null;
        this.eDz = null;
        this.eDA = null;
        this.eDB = null;
        this.euf = pbActivity;
        this.cdH = onClickListener;
        this.aPs = dVar;
        this.bSW = (RelativeLayout) LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.new_pb_activity, (ViewGroup) null);
        this.bSW.getViewTreeObserver().addOnGlobalLayoutListener(this.eEs);
        this.euf.addContentView(this.bSW, new FrameLayout.LayoutParams(-1, -1));
        this.bVj = this.euf.findViewById(w.h.statebar_view);
        this.eCE = (ObservedChangeLinearLayout) this.euf.findViewById(w.h.title_wrapper);
        this.bzB = (NoNetworkView) this.euf.findViewById(w.h.view_no_network);
        this.eBV = (PbLandscapeListView) this.euf.findViewById(w.h.new_pb_list);
        this.aww = new TextView(this.euf.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.euf.getActivity(), w.f.ds98));
        this.eBV.addHeaderView(this.aww, 0);
        View view = new View(this.euf.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.euf.getResources().getDimensionPixelSize(w.f.ds100)));
        view.setVisibility(4);
        this.eBV.addFooterView(view);
        this.eBV.setOnTouchListener(this.euf.aKv);
        this.eBR = new com.baidu.tieba.pb.pb.main.view.j(pbActivity);
        this.eDR = new com.baidu.tieba.d.a(pbActivity.getPageContext(), this.eBR.eGJ);
        this.eDR.hD(1);
        if (this.euf.aNU()) {
            this.eBT = (ViewStub) this.euf.findViewById(w.h.manga_view_stub);
            this.eBT.setVisibility(0);
            this.eBS = new com.baidu.tieba.pb.pb.main.view.h(pbActivity);
            this.eBS.show();
            this.eBR.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.aww.setLayoutParams(layoutParams);
        this.eBR.aRx().setOnTouchListener(new com.baidu.tieba.pb.a.a(new hg(this)));
        this.eDn = this.euf.findViewById(w.h.pb_editor_tool_comment);
        this.eDu = com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds110);
        this.eDv = com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds156);
        this.eDw = this.eDu;
        this.eDo = (TextView) this.euf.getPageContext().getPageActivity().findViewById(w.h.pb_editor_tool_comment_reply_text);
        this.eDp = (ViewGroup) this.euf.getPageContext().getPageActivity().findViewById(w.h.pb_editor_tool_comment_reply_layout);
        this.eDr = (TextView) this.euf.getPageContext().getPageActivity().findViewById(w.h.pb_editor_tool_comment_praise_icon);
        this.eDr.setVisibility(8);
        this.eDp.setOnClickListener(new hh(this));
        this.eDr.setOnClickListener(this.cdH);
        this.eDr.setOnTouchListener(this.euf);
        this.eBX = LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_item, (ViewGroup) null);
        this.eCb = (LinearLayout) LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.new_pb_header_user_item, (ViewGroup) null);
        this.eCe = new g(this.euf, this.eCb);
        this.eCe.init();
        this.eCe.a(this.eCe.aNt(), this.cdH);
        this.eCf = (ColumnLayout) this.eCb.findViewById(w.h.pb_head_owner_root);
        this.eCg = (ThreadSkinView) this.eCb.findViewById(w.h.pb_thread_skin);
        this.eCf.setOnLongClickListener(this.onLongClickListener);
        this.eCf.setOnTouchListener(this.aPs);
        this.eCf.setVisibility(8);
        this.eBX.setOnTouchListener(this.aPs);
        this.eDz = this.eBX.findViewById(w.h.pb_head_activity_join_number_container);
        this.eDz.setVisibility(8);
        this.eDA = (TextView) this.eBX.findViewById(w.h.pb_head_activity_join_number);
        this.eCh = (TextView) this.eCf.findViewById(w.h.pb_head_owner_info_user_name);
        this.eCi = (TextView) this.eCb.findViewById(w.h.pb_head_owner_info_user_intro);
        this.eCj = (TextView) this.eCf.findViewById(w.h.floor_owner);
        this.eCk = (ImageView) this.eCf.findViewById(w.h.icon_forum_level);
        this.eCm = (FrameLayout) this.eCf.findViewById(w.h.pb_head_headImage_container);
        this.eCn = (HeadImageView) this.eCf.findViewById(w.h.pb_head_owner_photo);
        this.eCl = (HeadPendantView) this.eCf.findViewById(w.h.pb_pendant_head_owner_photo);
        this.eCl.wm();
        if (this.eCl.getHeadView() != null) {
            this.eCl.getHeadView().setIsRound(true);
            this.eCl.getHeadView().setDrawBorder(false);
        }
        if (this.eCl.getPendantView() != null) {
            this.eCl.getPendantView().setIsRound(true);
            this.eCl.getPendantView().setDrawBorder(false);
        }
        this.exL = (UserIconBox) this.eCf.findViewById(w.h.show_icon_vip);
        this.exM = (UserIconBox) this.eCf.findViewById(w.h.show_icon_yinji);
        this.eCp = (FloatingLayout) this.eCb.findViewById(w.h.pb_head_owner_info_root);
        this.eCu = (PbFirstFloorUserLikeButton) this.eCf.findViewById(w.h.pb_like_button);
        this.eCv = new ge(pbActivity.getPageContext(), this.eCu, 1);
        this.eCw = (TextView) this.eCf.findViewById(w.h.pb_views);
        this.eCx = (TextView) this.eCf.findViewById(w.h.pb_item_first_floor_reply_time);
        this.byv = (TextView) this.eCf.findViewById(w.h.pb_item_first_floor_location_address);
        this.eEg = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eEh = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eCB = this.eBX.findViewById(w.h.new_pb_header_item_line_above_livepost);
        this.eCd = LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.layout_read_thread, (ViewGroup) null);
        this.eCc = (TextView) this.eCd.findViewById(w.h.pb_head_read_button);
        this.eCb.addView(this.eCd);
        this.eCc.setOnClickListener(this.cdH);
        this.eBK = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds2);
        this.eBJ = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds18);
        this.eBI = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);
        this.aOS = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds32);
        this.eCC = this.eBX.findViewById(w.h.new_pb_header_item_line_below_livepost);
        this.eBX.setOnLongClickListener(new hi(this));
        this.eDB = (ViewStub) this.bSW.findViewById(w.h.interview_status_stub);
        this.eCF = new dc(this.euf, this.eBV);
        this.eCF.v(this.cdH);
        this.eCF.setTbGestureDetector(this.aPs);
        this.eCF.setOnImageClickListener(this.aPr);
        this.ete = new hj(this);
        this.eCF.I(this.ete);
        aQk();
        this.eBV.addHeaderView(this.eBZ);
        this.eBV.addHeaderView(this.eCb);
        this.eBV.addHeaderView(this.eBX);
        this.eCK = new PbListView(this.euf.getPageContext().getPageActivity());
        this.aGu = this.eCK.getView().findViewById(w.h.pb_more_view);
        if (this.aGu != null) {
            this.aGu.setOnClickListener(this.cdH);
            com.baidu.tbadk.core.util.as.j(this.aGu, w.g.pb_foot_more_trans_selector);
        }
        this.eCK.wz();
        this.eCK.dj(w.g.pb_foot_more_trans_selector);
        this.eCK.dk(w.g.pb_foot_more_trans_selector);
        this.eCM = this.euf.findViewById(w.h.viewstub_progress);
        this.euf.registerListener(this.eEl);
        this.eCo = com.baidu.tbadk.ala.b.nv().h(this.euf.getActivity(), 2);
        if (this.eCo != null) {
            this.eCo.setVisibility(8);
            this.eCp.addView(this.eCo);
        }
        this.eyj = new PbFakeFloorModel(this.euf.getPageContext());
        this.eDQ = new ei(this.euf.getPageContext(), this.eyj, this.bSW);
        this.eyj.a(new hk(this));
        if (this.euf.aNz() != null && !StringUtils.isNull(this.euf.aNz().aPp())) {
            this.euf.showToast(this.euf.aNz().aPp());
        }
        this.euf.registerListener(this.duu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQh() {
        if (this.eDF != null) {
            int[] iArr = new int[2];
            this.eDn.getLocationOnScreen(iArr);
            this.eDF.setBottomMargin((((ViewGroup) this.euf.getPageContext().getPageActivity().getWindow().getDecorView()).getHeight() - this.eDw) - iArr[1]);
        }
    }

    public void aQi() {
        if (this.eBV != null) {
            this.eBV.removeHeaderView(this.eBZ);
            this.eBV.removeHeaderView(this.eCb);
            this.eBV.removeHeaderView(this.eBX);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.data.b bVar, com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        if (this.eDF == null) {
            this.eDF = new com.baidu.tieba.pb.pb.main.emotion.view.a(this.euf.getPageContext().getPageActivity());
            ViewGroup viewGroup = (ViewGroup) this.euf.getPageContext().getPageActivity().getWindow().getDecorView();
            int[] iArr = new int[2];
            this.eDn.getLocationOnScreen(iArr);
            this.eDF.a(viewGroup, (viewGroup.getHeight() - this.eDu) - iArr[1], bVar);
            this.eDF.setOnEmotionClickListener(new gi(this, aVar));
            this.eDF.setOnMoveListener(new gj(this));
        }
    }

    private boolean k(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aMv() == null || !fVar.aMP() || !TbadkCoreApplication.m9getInst().isTTSCanUse() || fVar.aMv().ro() == 1 || fVar.aMv().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aMv().rq() == null || fVar.aMv().rq().sN() == 0) && !fVar.aMv().sj()) {
            BdUniqueId type = fVar.aMv().getType();
            return type == com.baidu.tbadk.core.data.bm.Xo || type == com.baidu.tbadk.core.data.bm.Xq || type == com.baidu.tbadk.core.data.bm.Xn;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.eCd != null) {
            if (!z) {
                this.eCd.setVisibility(8);
            } else if (!k(fVar)) {
                this.eCd.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aMx() != null && fVar.aMx().size() > 0) {
                    postData = fVar.aMx().get(0);
                }
                if (postData != null && postData.bmu() == 1) {
                    q(this.aOS, this.eBJ, this.aOS, this.eBK);
                } else {
                    q(this.aOS, this.eBJ, this.aOS, this.eBI);
                }
                this.eCd.setVisibility(0);
            }
        }
    }

    private void q(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCc.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.eCc.setLayoutParams(layoutParams);
    }

    public TextView aQj() {
        return this.eCc;
    }

    private void aQk() {
        if (this.eBZ == null) {
            int g = com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds40);
            com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds40);
            this.eBZ = new LinearLayout(this.euf.getPageContext().getPageActivity());
            this.eBZ.setOrientation(1);
            this.eBZ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eBZ.setPadding(g, com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds40), g, com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds46));
            this.eBZ.setGravity(17);
            this.eCa = new TextView(this.euf.getPageContext().getPageActivity());
            this.eCa.setGravity(3);
            this.eCa.setMaxLines(2);
            this.eCa.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c));
            this.eCa.setPadding(0, 0, 0, 0);
            this.eCa.setLineSpacing(com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.as.i(this.eCa, w.e.cp_cont_b);
            this.eCa.setTextSize(0, com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds48));
            this.eCa.setVisibility(8);
            this.eBZ.addView(this.eCa);
            this.eBZ.setOnTouchListener(this.aPs);
            this.eBZ.setOnLongClickListener(new gk(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        if (this.euf.aNU()) {
            this.eBU = (ViewStub) this.euf.findViewById(w.h.manga_mention_controller_view_stub);
            this.eBU.setVisibility(0);
            if (this.eCy == null) {
                this.eCy = (LinearLayout) this.euf.findViewById(w.h.manga_controller_layout);
                com.baidu.tbadk.m.a.a(this.euf.getPageContext(), this.eCy);
            }
            if (this.eCz == null) {
                this.eCz = (TextView) this.eCy.findViewById(w.h.manga_prev_btn);
            }
            if (this.eCA == null) {
                this.eCA = (TextView) this.eCy.findViewById(w.h.manga_next_btn);
            }
            this.eCz.setOnClickListener(this.cdH);
            this.eCA.setOnClickListener(this.cdH);
        }
    }

    private void aQm() {
        if (this.euf.aNU()) {
            if (this.euf.aNX() == -1) {
                com.baidu.tbadk.core.util.as.c(this.eCz, w.e.cp_cont_e, 1);
            }
            if (this.euf.aNY() == -1) {
                com.baidu.tbadk.core.util.as.c(this.eCA, w.e.cp_cont_e, 1);
            }
        }
    }

    public void aQn() {
        if (this.eCy == null) {
            aQl();
        }
        this.eBU.setVisibility(8);
        if (this.eEj != null && this.eEk != null) {
            this.eEj.removeCallbacks(this.eEk);
        }
    }

    public void aQo() {
        if (this.eEj != null) {
            if (this.eEk != null) {
                this.eEj.removeCallbacks(this.eEk);
            }
            this.eEk = new gl(this);
            this.eEj.postDelayed(this.eEk, 2000L);
        }
    }

    public void jj(boolean z) {
        this.eBR.jj(z);
        if (z && this.eDy) {
            this.eCK.setText(this.euf.getResources().getString(w.l.click_load_more));
            this.eBV.setNextPage(this.eCK);
            this.eBQ = 2;
        }
    }

    public void aQp() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.bSW.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JT = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.bSW.addView(this.JT, layoutParams);
        this.JT.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        aQc();
    }

    public void aQq() {
        if (this.euf != null && this.JT != null) {
            this.JT.lM();
            aQN();
        }
    }

    public void R(String str, boolean z) {
        this.eDt = z;
        aN(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void aN(boolean z) {
        if (this.eDr != null) {
            if (this.eDt) {
                com.baidu.tbadk.core.util.as.j(this.eDr, w.g.pb_praise_already_click_selector);
                this.eDr.setContentDescription(this.euf.getResources().getString(w.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.as.j(this.eDr, w.g.pb_praise_normal_click_selector);
            this.eDr.setContentDescription(this.euf.getResources().getString(w.l.frs_item_praise_text));
        }
    }

    public TextView aQr() {
        return this.eDr;
    }

    public void jk(boolean z) {
        if (this.eBV != null && this.aww != null && this.bVj != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bVj.setVisibility(0);
                } else {
                    this.bVj.setVisibility(8);
                    this.eBV.removeHeaderView(this.aww);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aww.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.aww.setLayoutParams(layoutParams);
                }
                aQF();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aww.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jr(true);
                this.aww.setLayoutParams(layoutParams2);
            }
            aQF();
            aQW();
        }
    }

    public dc aQs() {
        return this.eCF;
    }

    public void aQt() {
        if (this.eCF != null) {
            this.eCF.aOs();
        }
    }

    public void a(PbActivity.c cVar) {
        this.evR = cVar;
    }

    private void a(com.baidu.tbadk.core.data.br brVar) {
        if (brVar == null || brVar.sN() == 0) {
            if (this.eDm != null) {
                this.eDm.setVisibility(8);
            }
            if (this.eCB != null) {
                this.eCB.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eDm == null) {
            this.euf.getLayoutMode().t(((ViewStub) this.eBX.findViewById(w.h.live_talk_layout)).inflate());
            this.eDm = (Button) this.eBX.findViewById(w.h.pb_head_function_manage_go_to_live_post);
            this.eCB = this.eBX.findViewById(w.h.new_pb_header_item_line_above_livepost);
        }
        int sO = brVar.sO();
        String string = this.euf.getPageContext().getString(w.l.go_to_live_post_prefix);
        if (sO == 0) {
            string = String.valueOf(string) + this.euf.getPageContext().getString(w.l.go_to_interview_post);
        } else if (sO == 1) {
            string = String.valueOf(string) + this.euf.getPageContext().getString(w.l.go_to_discuss_post);
        }
        this.eDm.setText(string);
        this.eDm.setVisibility(0);
        this.eDm.setOnClickListener(this.cdH);
        this.eEp = true;
        aQG();
    }

    public void ba(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.eCO == null) {
            this.eCO = LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.euf.getLayoutMode().t(this.eCO);
        if (this.eCN == null) {
            this.eCN = new Dialog(this.euf.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.eCN.setCanceledOnTouchOutside(true);
            this.eCN.setCancelable(true);
            this.eCN.setContentView(this.eCO);
            WindowManager.LayoutParams attributes = this.eCN.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.euf.getPageContext().getPageActivity()) * 0.9d);
            this.eCN.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eCN.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.eCN.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eCN.findViewById(w.h.disable_reply_btn);
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
            textView.setOnClickListener(new gn(this));
        }
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name)) || aQT()) {
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
            textView2.setOnClickListener(new go(this));
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
            textView3.setOnClickListener(new gp(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.eCN, this.euf.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eEm = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eDJ, Integer.valueOf(eDK));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.eCP = new com.baidu.tbadk.core.dialog.a(this.euf.getActivity());
        this.eCP.bY(i3);
        this.eCP.A(sparseArray);
        this.eCP.a(w.l.dialog_ok, this.euf);
        this.eCP.b(w.l.dialog_cancel, new gq(this));
        this.eCP.as(true);
        this.eCP.b(this.euf.getPageContext());
        this.eCP.ta();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.ae> arrayList) {
        if (this.eDb == null) {
            this.eDb = LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.commit_good, (ViewGroup) null);
        }
        this.euf.getLayoutMode().t(this.eDb);
        if (this.eDa == null) {
            this.eDa = new Dialog(this.euf.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.eDa.setCanceledOnTouchOutside(true);
            this.eDa.setCancelable(true);
            this.eDl = (ScrollView) this.eDb.findViewById(w.h.good_scroll);
            this.eDa.setContentView(this.eDb);
            WindowManager.LayoutParams attributes = this.eDa.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds540);
            this.eDa.getWindow().setAttributes(attributes);
            this.eDd = new gr(this);
            this.eDc = (LinearLayout) this.eDb.findViewById(w.h.good_class_group);
            this.eDf = (TextView) this.eDb.findViewById(w.h.dialog_button_cancel);
            this.eDf.setOnClickListener(new gs(this));
            this.eDe = (TextView) this.eDb.findViewById(w.h.dialog_button_ok);
            this.eDe.setOnClickListener(this.cdH);
        }
        this.eDc.removeAllViews();
        this.eBW = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bL = bL("0", this.euf.getPageContext().getString(w.l.def_good_class));
        this.eBW.add(bL);
        bL.setChecked(true);
        this.eDc.addView(bL);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bL2 = bL(String.valueOf(arrayList.get(i2).pN()), arrayList.get(i2).pM());
                this.eBW.add(bL2);
                View view = new View(this.euf.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds1));
                com.baidu.tbadk.core.util.as.k(view, w.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eDc.addView(view);
                this.eDc.addView(bL2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eDl.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.euf.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.euf.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.euf.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eDl.setLayoutParams(layoutParams2);
            this.eDl.removeAllViews();
            this.eDl.addView(this.eDc);
        }
        com.baidu.adp.lib.g.j.a(this.eDa, this.euf.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bL(String str, String str2) {
        Activity pageActivity = this.euf.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds100));
        aVar.setOnCheckedChangeListener(this.eDd);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aQu() {
        this.euf.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.euf.hideProgressBar();
        if (z && z2) {
            this.euf.showToast(this.euf.getPageContext().getString(w.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aw.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(w.l.neterror);
            }
            this.euf.showToast(str);
        }
    }

    public void atY() {
        this.eCM.setVisibility(0);
    }

    public void atX() {
        this.eCM.setVisibility(8);
    }

    public View aQv() {
        if (this.eDb != null) {
            return this.eDb.findViewById(w.h.dialog_button_ok);
        }
        return null;
    }

    public String aQw() {
        return this.eDg;
    }

    public View getView() {
        return this.bSW;
    }

    public void aQx() {
        com.baidu.adp.lib.util.k.b(this.euf.getPageContext().getPageActivity(), this.euf.getCurrentFocus());
    }

    public void jl(boolean z) {
        this.euf.hideProgressBar();
        azw();
    }

    public void aQy() {
        this.eCK.wz();
        this.eCK.wD();
    }

    public void aQz() {
        this.euf.hideProgressBar();
        wE();
        this.eBV.completePullRefreshPostDelayed(2000L);
        aQG();
    }

    public void aQA() {
        this.eBV.completePullRefreshPostDelayed(2000L);
        aQG();
    }

    public void jm(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eDp.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.euf.getResources().getDimensionPixelSize(w.f.ds84) : 0;
        this.eDp.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eCF.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.eDh != null) {
            this.eDh.dismiss();
            this.eDh = null;
        }
        this.eDh = new com.baidu.tbadk.core.dialog.c(this.euf.getPageContext().getPageActivity());
        this.eDh.cb(w.l.operation);
        if (z2) {
            this.eDh.a(new String[]{this.euf.getPageContext().getString(w.l.copy)}, bVar);
        } else if (!z) {
            this.eDh.a(new String[]{this.euf.getPageContext().getString(w.l.copy), this.euf.getPageContext().getString(w.l.mark)}, bVar);
        } else {
            this.eDh.a(new String[]{this.euf.getPageContext().getString(w.l.copy), this.euf.getPageContext().getString(w.l.remove_mark)}, bVar);
        }
        this.eDh.d(this.euf.getPageContext());
        this.eDh.td();
    }

    public void a(c.b bVar, boolean z) {
        if (this.eDi != null) {
            this.eDi.dismiss();
            this.eDi = null;
        }
        this.eDi = new com.baidu.tbadk.core.dialog.c(this.euf.getPageContext().getPageActivity());
        this.eDi.cb(w.l.operation);
        if (z) {
            this.eDi.a(new String[]{this.euf.getPageContext().getString(w.l.save_to_emotion)}, bVar);
        } else {
            this.eDi.a(new String[]{this.euf.getPageContext().getString(w.l.save_to_emotion), this.euf.getPageContext().getString(w.l.pb_save_image)}, bVar);
        }
        this.eDi.d(this.euf.getPageContext());
        this.eDi.td();
    }

    public int aQB() {
        return pa(this.eBV.getFirstVisiblePosition());
    }

    private int pa(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.eBV.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eBV.getAdapter() == null || !(this.eBV.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.eBV.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aQC() {
        int lastVisiblePosition = this.eBV.getLastVisiblePosition();
        if (this.eBM != null) {
            if (lastVisiblePosition == this.eBV.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.eCF.aOt();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pa(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.eBV.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eCI.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void l(com.baidu.tieba.pb.data.f fVar) {
        this.eCF.a(fVar, false);
        this.eCF.notifyDataSetChanged();
        aQG();
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        if (this.eCs == null) {
            this.euf.getLayoutMode().t(((ViewStub) this.eBX.findViewById(w.h.praise_layout)).inflate());
            this.eCs = (FrsPraiseView) this.eBX.findViewById(w.h.pb_head_praise_view);
            this.eCs.setIsFromPb(true);
            this.eCD = this.eBX.findViewById(w.h.new_pb_header_item_line_above_praise);
            this.eCs.dp(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.eCs != null) {
            boolean aQG = aQG();
            this.eCs.setVisibility(8);
            if (fVar != null && fVar.qu() != null && fVar.qu().qr() == 0 && this.esZ) {
                if (aQG) {
                    this.eCC.setVisibility(0);
                } else {
                    this.eCC.setVisibility(8);
                }
            } else {
                this.eCC.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.al(this.eCC);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aME() != null) {
            return fVar.aME();
        }
        if (z) {
            if (fVar == null || fVar.aMx() == null || fVar.aMx().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aMx().get(0);
            if (postData.bmu() != 1) {
                postData = a(fVar);
            }
            if (postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
                return postData;
            }
            return postData;
        }
        PostData aMC = fVar.aMC();
        if (aMC == null) {
            return a(fVar);
        }
        return aMC;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aMv() == null || fVar.aMv().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aMv().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aMv().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.sF(1);
        postData.setId(fVar.aMv().rH());
        postData.setTitle(fVar.aMv().getTitle());
        postData.setTime(fVar.aMv().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0576 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0385  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        String d;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.g bmx;
        String portrait;
        if (fVar != null && fVar.aMv() != null) {
            PostData c = c(fVar, z);
            a(c, fVar);
            aQU();
            this.eCf.setVisibility(8);
            if (fVar.aMv() != null && fVar.aMv().se() && fVar.aMv().rI() != null) {
                this.eDU = true;
                this.eBR.jA(this.eDU);
                if (this.eBM == null) {
                    this.eBM = new com.baidu.tieba.pb.video.l(this.euf, this.eBR, fVar.aMv().rI());
                    this.eBM.a(fVar.aMv().rI(), fVar.aMv(), fVar.getForumId());
                    this.eBM.startPlay();
                } else if (this.eBP) {
                    this.eBM.a(fVar.aMv().rI(), fVar.aMv(), fVar.getForumId());
                    this.eBM.startPlay();
                }
                if (fVar.aMw() != null && fVar.aMw().size() >= 1) {
                    com.baidu.tbadk.core.data.bm bmVar = fVar.aMw().get(0);
                    this.eBM.V(bmVar);
                    this.eBM.pj(bmVar.getTitle());
                }
                this.eBM.b(c, fVar.aMv(), fVar.aMS());
                this.eBP = false;
                this.eBV.removeHeaderView(this.eBM.aSW());
                this.eBV.addHeaderView(this.eBM.aSW(), 0);
                if (this.eBN == null) {
                    this.eBN = new com.baidu.tieba.pb.video.k(this.euf);
                }
                this.eBN.a(fVar.aMv().sv(), fVar.aMv(), fVar.aMO());
                this.eBV.removeHeaderView(this.eBN.aSN());
                this.eBV.addHeaderView(this.eBN.aSN(), 1);
                if (fVar.aMv().sv() != null) {
                    this.eBV.removeHeaderView(this.eBN.aSO());
                    this.eBV.removeHeaderView(this.eCb);
                    this.eBV.addHeaderView(this.eBN.aSO(), 2);
                } else {
                    if (this.eBN.aSO() != null) {
                        this.eBV.removeHeaderView(this.eBN.aSO());
                    }
                    this.eBV.removeHeaderView(this.eCb);
                    this.eBV.addHeaderView(this.eCb, 2);
                }
                if (this.eBM != null) {
                    this.eBM.pi(0);
                }
                aQF();
            } else {
                this.eDU = false;
                this.eBR.jA(this.eDU);
                this.eBR.eGI.setVisibility(0);
                if (this.eBM != null) {
                    this.eBV.removeHeaderView(this.eBM.aSW());
                }
                if (this.eBN != null) {
                    this.eBN.e(this.eBV);
                }
            }
            if (this.euf.aNx() != null) {
                this.euf.aNx().jw(this.eDU);
            }
            gt gtVar = new gt(this);
            if (this.eBM != null) {
                this.eBM.L(gtVar);
            }
            b(fVar, z);
            if (c != null) {
                this.eDx = c;
                if (fVar != null && fVar.aMv() != null && fVar.aMv().getAuthor() != null) {
                    fVar.aMv().getAuthor().getUserId();
                    if (fVar.qu() != null) {
                        this.eDZ = fVar.qu().qn();
                        if (fVar.qu().qq() == 1) {
                        }
                    }
                }
                this.eCf.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eCf.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eCf.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_clip_board, c);
                sparseArray.put(w.h.tag_is_subpb, false);
                if (!this.eEe) {
                    this.eBZ.setVisibility(0);
                }
                if (!fVar.aMv().se() && this.eCa.getText() != null && this.eCa.getText().length() > 0) {
                    this.eCa.setVisibility(0);
                } else {
                    this.eCa.setVisibility(8);
                }
                m(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rC = fVar.aMv().rC();
                if (rC != null && rC.size() > 0 && !this.eEe) {
                    this.eDA.setText(String.valueOf(rC.get(0).pe()));
                    this.eDz.setVisibility(0);
                    this.eEo = true;
                } else {
                    this.eDz.setVisibility(8);
                }
                com.baidu.tbadk.core.util.as.j(this.eDz, w.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.as.c(this.eDA, w.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    String string = c.getAuthor().getName_show() == null ? StringUtils.string(c.getAuthor().getUserName()) : StringUtils.string(c.getAuthor().getName_show());
                    if (StringUtils.isNull(c.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aK(c.getAuthor().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aK(string) > 12) {
                            d = com.baidu.tbadk.core.util.aw.d(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aK = com.baidu.adp.lib.util.j.aK(c.getAuthor().getName_show());
                                if (aK + i2 > 14) {
                                    i3 = 0;
                                } else if (aK + i2 >= 12) {
                                    i3 = 1;
                                } else if (aK + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.exM != null) {
                                this.exM.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                                this.exM.setOnClickListener(this.euf.euV.clh);
                                this.exM.a(iconInfo, i3, this.euf.getResources().getDimensionPixelSize(w.f.ds26), this.euf.getResources().getDimensionPixelSize(w.f.ds26), this.euf.getResources().getDimensionPixelSize(w.f.ds8));
                            }
                            if (this.exL != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.exL.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.exL.setOnClickListener(this.euf.euV.eFX);
                                this.exL.a(tShowInfoNew, 3, this.euf.getResources().getDimensionPixelSize(w.f.ds36), this.euf.getResources().getDimensionPixelSize(w.f.ds36), this.euf.getResources().getDimensionPixelSize(w.f.ds8), true);
                            }
                            this.eCh.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.eCh.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                            this.eCh.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.z.t(tShowInfoNew) || c.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.as.c(this.eCh, w.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.as.c(this.eCh, w.e.cp_cont_f, 1);
                            }
                            if (c == null && !TextUtils.isEmpty(c.getAuthor().getGodIntro())) {
                                this.eCi.setVisibility(0);
                                this.eCi.setText(gf.a(c.getAuthor()));
                            } else {
                                this.eCi.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.as.c(this.eCj, w.e.cp_link_tip_a, 1);
                            this.eCj.setVisibility(0);
                            if (fVar.aMv().getAuthor() != null && fVar.aMv().getAuthor().getAlaUserData() != null && this.eCo != null) {
                                if (fVar.aMv().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.eCo.setVisibility(8);
                                } else {
                                    this.eCo.setVisibility(0);
                                    if (this.eBO == null) {
                                        this.eBO = new com.baidu.tieba.d.a(this.euf.getPageContext(), this.eCo);
                                        this.eBO.hD(1);
                                    }
                                    this.eBO.aG(this.euf.getResources().getString(w.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.PQ = fVar.aMv().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.eCo.setTag(aVar);
                                }
                            }
                            this.eCn.setUserId(c.getAuthor().getUserId());
                            this.eCn.setUserName(c.getAuthor().getUserName());
                            this.eCn.setImageDrawable(null);
                            this.eCn.setRadius(com.baidu.adp.lib.util.k.g(this.euf.getActivity(), w.f.ds40));
                            this.eCn.setTag(c.getAuthor().getUserId());
                            this.eCx.setText(c.bmw());
                            bmx = c.bmx();
                            if (bmx == null && !TextUtils.isEmpty(bmx.getName()) && !TextUtils.isEmpty(bmx.getName().trim())) {
                                String name = bmx.getName();
                                String lat = bmx.getLat();
                                String lng = bmx.getLng();
                                this.byv.setVisibility(0);
                                this.byv.setText(bmx.getName());
                                this.byv.setOnClickListener(new gu(this, lat, lng, name));
                            } else {
                                this.byv.setVisibility(8);
                            }
                            this.eCv.a(c.getAuthor());
                            this.eCv.eBF = this.eDU;
                            if (!this.eDk) {
                                this.eCu.setVisibility(8);
                                this.eCw.setVisibility(0);
                                this.eCw.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.pb_thread_views), com.baidu.tbadk.core.util.aw.w(fVar.aMR())));
                            } else if (!PbNormalLikeButtonSwitchStatic.Gu() || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.eCu.setVisibility(8);
                                this.eCw.setVisibility(8);
                            } else {
                                this.eCu.setVisibility(0);
                                this.eCu.setTextSize(0, com.baidu.adp.lib.util.k.g(this.euf.getActivity(), w.f.ds24));
                                this.eCw.setVisibility(8);
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null && !StringUtils.isNull(c.getAuthor().getPendantData().pI())) {
                                UtilHelper.showHeadImageViewBigV(this.eCl.getHeadView(), c.getAuthor());
                                this.eCn.setVisibility(8);
                                this.eCl.setVisibility(0);
                                if (this.eCt != null) {
                                    this.eCt.setVisibility(8);
                                }
                                this.eCh.setOnClickListener(gtVar);
                                this.eCl.getHeadView().c(portrait, 28, false);
                                this.eCl.getHeadView().setUserId(c.getAuthor().getUserId());
                                this.eCl.getHeadView().setUserName(c.getAuthor().getUserName());
                                this.eCl.getHeadView().setOnClickListener(gtVar);
                                this.eCl.ek(c.getAuthor().getPendantData().pI());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eCn, c.getAuthor());
                                this.eCn.setVisibility(0);
                                this.eCf.setOnClickListener(gtVar);
                                this.eCh.setOnClickListener(gtVar);
                                this.eCn.setOnClickListener(gtVar);
                                this.eCl.setVisibility(8);
                                this.eCn.c(portrait, 28, false);
                            }
                            String name_show = c.getAuthor().getName_show();
                            String userName = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.n.ab.fU() && name_show != null && !name_show.equals(userName)) {
                                this.eCh.setText(com.baidu.tieba.pb.d.ao(this.euf.getPageContext().getPageActivity(), this.eCh.getText().toString()));
                                this.eCh.setGravity(16);
                                this.eCh.setTag(w.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aLW());
                                com.baidu.tbadk.core.util.as.c(this.eCh, w.e.cp_other_e, 1);
                            }
                        }
                        d = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.exM != null) {
                        }
                        if (this.exL != null) {
                        }
                        this.eCh.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.eCh.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.eCh.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.z.t(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.as.c(this.eCh, w.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eCi.setVisibility(8);
                        com.baidu.tbadk.core.util.as.c(this.eCj, w.e.cp_link_tip_a, 1);
                        this.eCj.setVisibility(0);
                        if (fVar.aMv().getAuthor() != null) {
                            if (fVar.aMv().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eCn.setUserId(c.getAuthor().getUserId());
                        this.eCn.setUserName(c.getAuthor().getUserName());
                        this.eCn.setImageDrawable(null);
                        this.eCn.setRadius(com.baidu.adp.lib.util.k.g(this.euf.getActivity(), w.f.ds40));
                        this.eCn.setTag(c.getAuthor().getUserId());
                        this.eCx.setText(c.bmw());
                        bmx = c.bmx();
                        if (bmx == null) {
                        }
                        this.byv.setVisibility(8);
                        this.eCv.a(c.getAuthor());
                        this.eCv.eBF = this.eDU;
                        if (!this.eDk) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eCn, c.getAuthor());
                        this.eCn.setVisibility(0);
                        this.eCf.setOnClickListener(gtVar);
                        this.eCh.setOnClickListener(gtVar);
                        this.eCn.setOnClickListener(gtVar);
                        this.eCl.setVisibility(8);
                        this.eCn.c(portrait, 28, false);
                        String name_show2 = c.getAuthor().getName_show();
                        String userName2 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.n.ab.fU()) {
                            this.eCh.setText(com.baidu.tieba.pb.d.ao(this.euf.getPageContext().getPageActivity(), this.eCh.getText().toString()));
                            this.eCh.setGravity(16);
                            this.eCh.setTag(w.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aLW());
                            com.baidu.tbadk.core.util.as.c(this.eCh, w.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.j.aK(string) > 14) {
                            d = com.baidu.tbadk.core.util.aw.d(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.exM != null) {
                            }
                            if (this.exL != null) {
                            }
                            this.eCh.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.eCh.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                            this.eCh.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.z.t(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.as.c(this.eCh, w.e.cp_cont_h, 1);
                            if (c == null) {
                            }
                            this.eCi.setVisibility(8);
                            com.baidu.tbadk.core.util.as.c(this.eCj, w.e.cp_link_tip_a, 1);
                            this.eCj.setVisibility(0);
                            if (fVar.aMv().getAuthor() != null) {
                            }
                            this.eCn.setUserId(c.getAuthor().getUserId());
                            this.eCn.setUserName(c.getAuthor().getUserName());
                            this.eCn.setImageDrawable(null);
                            this.eCn.setRadius(com.baidu.adp.lib.util.k.g(this.euf.getActivity(), w.f.ds40));
                            this.eCn.setTag(c.getAuthor().getUserId());
                            this.eCx.setText(c.bmw());
                            bmx = c.bmx();
                            if (bmx == null) {
                            }
                            this.byv.setVisibility(8);
                            this.eCv.a(c.getAuthor());
                            this.eCv.eBF = this.eDU;
                            if (!this.eDk) {
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eCn, c.getAuthor());
                            this.eCn.setVisibility(0);
                            this.eCf.setOnClickListener(gtVar);
                            this.eCh.setOnClickListener(gtVar);
                            this.eCn.setOnClickListener(gtVar);
                            this.eCl.setVisibility(8);
                            this.eCn.c(portrait, 28, false);
                            String name_show22 = c.getAuthor().getName_show();
                            String userName22 = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.n.ab.fU()) {
                            }
                        }
                        d = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.exM != null) {
                        }
                        if (this.exL != null) {
                        }
                        this.eCh.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.eCh.setTag(w.h.tag_user_id, c.getAuthor().getUserId());
                        this.eCh.setTag(w.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.z.t(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.as.c(this.eCh, w.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eCi.setVisibility(8);
                        com.baidu.tbadk.core.util.as.c(this.eCj, w.e.cp_link_tip_a, 1);
                        this.eCj.setVisibility(0);
                        if (fVar.aMv().getAuthor() != null) {
                        }
                        this.eCn.setUserId(c.getAuthor().getUserId());
                        this.eCn.setUserName(c.getAuthor().getUserName());
                        this.eCn.setImageDrawable(null);
                        this.eCn.setRadius(com.baidu.adp.lib.util.k.g(this.euf.getActivity(), w.f.ds40));
                        this.eCn.setTag(c.getAuthor().getUserId());
                        this.eCx.setText(c.bmw());
                        bmx = c.bmx();
                        if (bmx == null) {
                        }
                        this.byv.setVisibility(8);
                        this.eCv.a(c.getAuthor());
                        this.eCv.eBF = this.eDU;
                        if (!this.eDk) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eCn, c.getAuthor());
                        this.eCn.setVisibility(0);
                        this.eCf.setOnClickListener(gtVar);
                        this.eCh.setOnClickListener(gtVar);
                        this.eCn.setOnClickListener(gtVar);
                        this.eCl.setVisibility(8);
                        this.eCn.c(portrait, 28, false);
                        String name_show222 = c.getAuthor().getName_show();
                        String userName222 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.n.ab.fU()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eCe.P(fVar.aMv());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rM() != null) {
            this.eCg.a(this.euf.getPageContext(), fVar.aMx().get(0).rM(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aMt().getId(), fVar.aMt().getName(), fVar.aMv().getId(), this.euf.aOe() ? "FRS" : null));
            this.eCf.setPadding(this.eCf.getPaddingLeft(), (int) this.euf.getResources().getDimension(w.f.ds20), this.eCf.getPaddingRight(), this.eCf.getPaddingBottom());
            return;
        }
        this.eCg.a(null, null, null);
    }

    public void aQD() {
        if (this.eBM != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11997").r("obj_type", 1));
            this.eBM.aSX();
            this.eBV.smoothScrollToPosition(0);
        }
    }

    public boolean aQE() {
        return this.eEq;
    }

    private boolean Oy() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean K(com.baidu.tbadk.core.data.bm bmVar) {
        if (bmVar == null || bmVar.getAuthor() == null || bmVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bmVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.eBR.aRB();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eBR.mA(eVar.forumName);
            }
            String string = this.euf.getResources().getString(w.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.euf.getResources().getString(w.l.self);
                    break;
                case 300:
                    str = this.euf.getResources().getString(w.l.bawu);
                    break;
                case 400:
                    str = this.euf.getResources().getString(w.l.system);
                    break;
            }
            this.euf.showNetRefreshView(this.bSW, String.format(string, str), null, this.euf.getResources().getString(w.l.appeal_restore), true, new gw(this, eVar.ero));
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aPW;
        String sb;
        if (fVar != null) {
            this.eyH = fVar;
            this.mType = i;
            if (fVar.aMv() != null) {
                this.eDG = fVar.aMv().rf();
                this.Yx = fVar.aMv().rc();
                if (fVar.aMv().getAnchorLevel() != 0) {
                    this.eEq = true;
                }
                this.eDk = K(fVar.aMv());
                if (this.eCv != null && fVar.aMv().getAuthor() != null) {
                    this.eCv.isBigV = fVar.aMv().getAuthor().isBigV();
                }
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            o(fVar);
            this.eDy = false;
            this.esZ = z;
            aQz();
            b(fVar, z, i);
            if (this.euf.aNU()) {
                if (this.eCJ == null) {
                    this.eCJ = new com.baidu.tieba.pb.view.ac(this.euf.getPageContext());
                    this.eCJ.lc();
                    this.eCJ.a(this.alP);
                }
                this.eBV.setPullRefresh(this.eCJ);
                aQF();
                if (this.eCJ != null) {
                    this.eCJ.dl(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (fVar.qu().qr() == 0 && z) {
                this.eBV.setPullRefresh(null);
                this.eBL = 1;
            } else {
                if (this.eCJ == null) {
                    this.eCJ = new com.baidu.tieba.pb.view.ac(this.euf.getPageContext());
                    this.eCJ.lc();
                    this.eCJ.a(this.alP);
                }
                this.eBV.setPullRefresh(this.eCJ);
                aQF();
                this.eBL = 2;
                if (this.eCJ != null) {
                    this.eCJ.dl(TbadkCoreApplication.m9getInst().getSkinType());
                }
                Qy();
            }
            aQG();
            this.eCF.iw(this.esZ);
            this.eCF.ix(false);
            this.eCF.iI(i == 5);
            this.eCF.iJ(i == 6);
            this.eCF.a(fVar, false);
            this.eCF.notifyDataSetChanged();
            if (this.euf.aOi()) {
                if (fVar.aMu() != null) {
                    this.mForumName = fVar.aMu().getForumName();
                    this.mForumId = fVar.aMu().getForumId();
                }
                if (this.mForumName == null && this.euf.aNz() != null && this.euf.aNz().aOJ() != null) {
                    this.mForumName = this.euf.aNz().aOJ();
                }
                this.eBR.mA(this.mForumName);
            } else {
                this.eBR.mA(null);
            }
            if (this.euf.aOi()) {
                int i4 = 0;
                PostData c = c(fVar, z);
                if (c != null && c.getAuthor() != null) {
                    i4 = c.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.eCk.setVisibility(0);
                    com.baidu.tbadk.core.util.as.c(this.eCk, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.eCk.setVisibility(8);
                }
            } else {
                this.eCk.setVisibility(8);
            }
            if (fVar.aMv() != null && fVar.aMv().rh() != null) {
                if (fVar.aMv().rh().getNum() < 1) {
                    sb = this.euf.getResources().getString(w.l.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(fVar.aMv().rh().getNum())).toString();
                }
                if (this.eBH != -1) {
                    fVar.aMv().rh().setIsLike(this.eBH);
                }
                R(sb, fVar.aMv().rh().getIsLike() == 1);
            }
            if (fVar.qu().qq() == 0 && !z) {
                this.eBV.setNextPage(null);
                this.eBQ = 1;
            } else if (this.euf.isLogin()) {
                this.eBV.setNextPage(this.eCK);
                this.eBQ = 2;
                Qy();
            } else if (fVar.qu().qq() == 1) {
                this.eDy = true;
                if (this.eCL == null) {
                    this.eCL = new com.baidu.tieba.pb.view.b(this.euf.getPageContext());
                }
                this.eBV.setNextPage(this.eCL);
                this.eBQ = 3;
            }
            ArrayList<PostData> aMx = fVar.aMx();
            if (fVar.qu().qq() == 0 || aMx == null || aMx.size() < fVar.qu().qp()) {
                if (com.baidu.tbadk.core.util.z.s(aMx) == 0 || (com.baidu.tbadk.core.util.z.s(aMx) == 1 && aMx.get(0) != null && aMx.get(0).bmu() == 1)) {
                    this.eCK.setText(this.euf.getResources().getString(w.l.list_no_more_new));
                } else {
                    this.eCK.setText("");
                }
                if (this.euf.aNU() && this.eBV != null && this.eBV.getData() != null && this.eBV.getData().size() == 1 && (this.eBV.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.eCK.setText("");
                }
                aQL();
            } else if (z2) {
                if (this.eEn) {
                    wE();
                    if (fVar.qu().qq() != 0) {
                        this.eCK.setText(this.euf.getResources().getString(w.l.pb_load_more));
                    }
                } else {
                    this.eCK.wz();
                    this.eCK.wF();
                }
            } else {
                this.eCK.wz();
                this.eCK.wF();
            }
            if (fVar.aMv() != null && fVar.aMv().getAuthor() != null && fVar.aMv().getAuthor().getType() == 0) {
                this.eBR.aRy();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.eBV.getData() != null || fVar.aMx() != null) {
                        i5 = (this.eBV.getData().size() - fVar.aMx().size()) + this.eBV.getHeaderViewsCount();
                    }
                    this.eBV.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aPW = fp.aPV().aPW()) != null) {
                        this.eEi = true;
                        this.eBV.onRestoreInstanceState(aPW);
                        break;
                    } else {
                        this.eBV.setSelection(0);
                        break;
                    }
                case 4:
                    this.eEn = false;
                    break;
                case 5:
                    this.eBV.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aPW2 = fp.aPV().aPW();
                        this.eEi = true;
                        if (aPW2 != null) {
                            this.eBV.onRestoreInstanceState(aPW2);
                            break;
                        }
                    }
                    this.eBV.setSelection(0);
                    break;
            }
            if (this.eDT >= 0) {
                this.eBV.setSelectionFromTop(this.eDT, (int) this.eDS);
                this.eDT = -1;
            }
            if (this.eDG == eDI && Oy()) {
                aQO();
            }
            if (!this.eEi && fVar.aME() == null && !fVar.aMv().se()) {
                this.eDR.aG(this.euf.getResources().getString(w.l.pb_more_tools_guide_tip), String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "pb_show_tools_guide_tips");
                this.eEi = true;
            }
            if (this.eBN != null) {
                this.eBN.U(fVar.aMv());
            }
            this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    private void aQF() {
        if (this.eBM != null && this.eBM.aSW() != null) {
            this.eBV.removeHeaderView(this.aww);
            if (this.mType != 1) {
                this.eBV.removeHeaderView(this.eBM.aSW());
                this.eBV.addHeaderView(this.eBM.aSW(), 0);
                this.eBV.setSelection(0);
                return;
            }
            return;
        }
        if (this.eBM != null) {
            this.eBV.removeHeaderView(this.eBM.aSW());
        }
        this.eBV.removeHeaderView(this.aww);
        this.eBV.addHeaderView(this.aww, 0);
    }

    public void jn(boolean z) {
        this.eDj = z;
        this.eBR.jn(z);
    }

    public void wE() {
        if (this.eCK != null) {
            this.eCK.wA();
            this.eCK.wE();
        }
        Qy();
    }

    public void Nq() {
        this.eBV.setVisibility(0);
    }

    private boolean aQG() {
        boolean z;
        if (this.eDm != null && this.eDm.getVisibility() == 0) {
            z = true;
            if (this.eCB != null) {
                this.eCB.setVisibility(0);
            }
        } else {
            if (this.eCB != null) {
                this.eCB.setVisibility(8);
            }
            z = false;
        }
        if ((this.eCD == null || this.eCD.getVisibility() == 8) && z && this.esZ) {
            this.eCC.setVisibility(0);
        } else {
            this.eCC.setVisibility(8);
        }
        com.baidu.tieba.graffiti.c.al(this.eCC);
        return z;
    }

    private boolean n(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aMv() == null) {
            return false;
        }
        if (fVar.aMv().ro() == 1 || fVar.aMv().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aMv().rq() == null || fVar.aMv().rq().sN() == 0) || fVar.aMv().rm() == 1 || fVar.aMv().rn() == 1 || fVar.aMv().rW() || fVar.aMv().sj() || fVar.aMv().sd() || fVar.aMv().rD() != null || fVar.aMv().sk() || fVar.aMv().sk() || !com.baidu.tbadk.core.util.aw.isEmpty(fVar.aMv().getCategory()) || fVar.aMv().ru() || fVar.aMv().rt();
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str));
            return com.baidu.tieba.card.at.a((Context) this.euf.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eBZ != null) {
                if (fVar.aMv() != null && fVar.aMv().rG() == 0 && !fVar.aMv().se() && !this.eEe) {
                    this.eBZ.setVisibility(0);
                    if (fVar.aMv() != null) {
                        fVar.aMv().e(true, n(fVar));
                    }
                    SpannableStringBuilder rR = fVar.aMv().rR();
                    this.eCa.setOnTouchListener(new com.baidu.tieba.view.aa(rR));
                    this.eCa.setText(rR);
                    this.eCa.setVisibility(0);
                } else if (fVar.aMv().rG() == 1) {
                    if (fVar.aMv() != null) {
                        fVar.aMv().e(true, n(fVar));
                        SpannableStringBuilder rR2 = fVar.aMv().rR();
                        if (rR2 == null || rR2.length() == 0) {
                            this.eBZ.setVisibility(8);
                            this.eBV.removeHeaderView(this.eBZ);
                            if (fVar.aMv() != null && !fVar.aMv().se()) {
                                this.eCf.setPadding(this.eCf.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds48), this.eCf.getPaddingRight(), this.eCf.getPaddingBottom());
                            }
                        } else {
                            this.eBZ.setVisibility(0);
                            this.eCa.setOnTouchListener(new com.baidu.tieba.view.aa(rR2));
                            this.eCa.setText(rR2);
                            this.eCa.setVisibility(0);
                        }
                    }
                } else {
                    this.eBZ.setVisibility(8);
                    this.eBV.removeHeaderView(this.eBZ);
                    if (fVar.aMv() != null && fVar.aMv().se()) {
                        this.eCf.setPadding(this.eCf.getPaddingLeft(), 0, this.eCf.getPaddingRight(), this.eCf.getPaddingBottom());
                    } else {
                        this.eCf.setPadding(this.eCf.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds48), this.eCf.getPaddingRight(), this.eCf.getPaddingBottom());
                    }
                }
            }
            this.esZ = z;
            com.baidu.tbadk.core.data.bm aMv = fVar.aMv();
            if (aMv != null) {
                a(aMv.rq());
            }
        }
        return false;
    }

    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aQG();
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
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aMG()));
            sparseArray.put(w.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(w.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(w.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(w.h.tag_del_post_id, c.getId());
            sparseArray.put(w.h.tag_del_post_type, 0);
            sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(fVar.aMG()));
            sparseArray.put(w.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aGu;
    }

    public void oT(String str) {
        if (this.eCK != null) {
            this.eCK.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eBV;
    }

    public int aQH() {
        return w.h.richText;
    }

    public TextView aNt() {
        return this.eCe.aNt();
    }

    public void d(BdListView.e eVar) {
        this.eBV.setOnSrollToBottomListener(eVar);
    }

    public void a(ae.b bVar) {
        this.alP = bVar;
        if (this.eCJ != null) {
            this.eCJ.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.as asVar, a.b bVar) {
        if (asVar != null) {
            int qo = asVar.qo();
            int ql = asVar.ql();
            if (this.eCG != null) {
                this.eCG.ta();
            } else {
                this.eCG = new com.baidu.tbadk.core.dialog.a(this.euf.getPageContext().getPageActivity());
                this.eCH = LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.dialog_direct_pager, (ViewGroup) null);
                this.eCG.v(this.eCH);
                this.eCG.a(w.l.dialog_ok, bVar);
                this.eCG.b(w.l.dialog_cancel, new gx(this));
                this.eCG.a(new gy(this));
                this.eCG.b(this.euf.getPageContext()).ta();
            }
            this.eCI = (EditText) this.eCH.findViewById(w.h.input_page_number);
            this.eCI.setText("");
            TextView textView = (TextView) this.eCH.findViewById(w.h.current_page_number);
            if (qo <= 0) {
                qo = 1;
            }
            if (ql <= 0) {
                ql = 1;
            }
            textView.setText(MessageFormat.format(this.euf.getApplicationContext().getResources().getString(w.l.current_page), Integer.valueOf(qo), Integer.valueOf(ql)));
            this.euf.ShowSoftKeyPadDelay(this.eCI, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eBV.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.euf.showToast(str);
    }

    public boolean jo(boolean z) {
        if (this.JT == null || !this.JT.CJ()) {
            return false;
        }
        this.JT.Bb();
        return true;
    }

    public void aQI() {
        if (this.eEr != null) {
            while (this.eEr.size() > 0) {
                TbImageView remove = this.eEr.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aQI();
        this.eCF.oM(1);
        if (this.eBM != null) {
            this.eBM.onPause();
        }
    }

    public void onResume() {
        this.eCF.oM(2);
        if (this.eBM != null) {
            this.eBM.onResume();
        }
        if (this.eDF != null) {
            this.eDF.onResume();
        }
    }

    public void onDestroy() {
        this.eDR.Xv();
        if (this.eBO != null) {
            this.eBO.Xv();
        }
        if (this.eBN != null) {
            this.eBN.onDestroy();
        }
        this.euf.hideProgressBar();
        if (this.bzB != null && this.bzE != null) {
            this.bzB.b(this.bzE);
        }
        azw();
        wE();
        if (this.eDO != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eDO);
        }
        if (this.eDP != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eDP);
        }
        if (this.eEd != null) {
            this.eEd.removeAllViews();
        }
        if (this.eCf != null && this.eCt != null) {
            this.eCf.removeView(this.eCm);
            this.eCt = null;
        }
        if (this.eDC != null) {
            this.eDC.clearStatus();
        }
        this.eEj = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eCF.oM(3);
        if (this.bVj != null) {
            this.bVj.setBackgroundDrawable(null);
        }
        if (this.eBM != null) {
            this.eBM.destroy();
        }
        if (this.eCF != null) {
            this.eCF.onDestory();
        }
        this.bSW.getViewTreeObserver().removeGlobalOnLayoutListener(this.eEs);
    }

    public boolean pb(int i) {
        if (this.eBM != null) {
            return this.eBM.po(i);
        }
        return false;
    }

    public void azw() {
        this.eBR.od();
        this.eDR.Xv();
        if (this.eBO != null) {
            this.eBO.Xv();
        }
        com.baidu.adp.lib.util.k.b(this.euf.getPageContext().getPageActivity(), this.eCI);
        if (this.eDh != null) {
            this.eDh.dismiss();
        }
        aQJ();
        if (this.eBN != null) {
            this.eBN.aSP();
        }
        if (this.eCG != null) {
            this.eCG.dismiss();
        }
        if (this.cdG != null) {
            this.cdG.dismiss();
        }
    }

    public void iv(boolean z) {
        this.eCF.iv(z);
    }

    public void gT(boolean z) {
        this.dzL = z;
    }

    public void aQJ() {
        if (this.eCP != null) {
            this.eCP.dismiss();
        }
        if (this.eCQ != null) {
            com.baidu.adp.lib.g.j.b(this.eCQ, this.euf.getPageContext());
        }
        if (this.eDa != null) {
            com.baidu.adp.lib.g.j.b(this.eDa, this.euf.getPageContext());
        }
        if (this.eCN != null) {
            com.baidu.adp.lib.g.j.b(this.eCN, this.euf.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.eyH, this.esZ);
            d(this.eyH, this.esZ, this.mType);
            this.euf.getLayoutMode().ah(i == 1);
            this.euf.getLayoutMode().t(this.bSW);
            this.euf.getLayoutMode().t(this.eCa);
            this.euf.getLayoutMode().t(this.eCb);
            this.euf.getLayoutMode().t(this.eBX);
            if (this.eCr != null) {
                com.baidu.tbadk.core.util.as.c(this.eCr, w.e.cp_cont_d, 1);
            }
            if (this.eCq != null) {
                com.baidu.tbadk.core.util.as.c(this.eCq, w.e.cp_cont_d, 1);
            }
            if (this.eBN != null) {
                this.eBN.onChangeSkinType(i);
            }
            if (this.eCo != null) {
                com.baidu.tbadk.core.util.as.i(this.eCo, w.e.cp_cont_f);
            }
            this.euf.getLayoutMode().t(this.eBX);
            com.baidu.tbadk.core.util.as.i(this.eCa, w.e.cp_cont_b);
            this.eCa.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c));
            this.euf.getLayoutMode().t(this.aGu);
            if (this.eCH != null) {
                this.euf.getLayoutMode().t(this.eCH);
            }
            jn(this.eDj);
            this.eCF.notifyDataSetChanged();
            if (this.eCJ != null) {
                this.eCJ.dl(i);
            }
            if (this.eCK != null) {
                this.eCK.dl(i);
                com.baidu.tbadk.core.util.as.j(this.aGu, w.g.pb_foot_more_trans_selector);
                this.eCK.dj(w.g.pb_foot_more_trans_selector);
            }
            if (this.JT != null) {
                this.JT.onChangeSkinType(i);
            }
            if (this.eCs != null) {
                this.eCs.dp(i);
            }
            if (this.eCL != null) {
                this.eCL.dl(i);
            }
            if (this.eBW != null && this.eBW.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eBW) {
                    aVar.aRs();
                }
            }
            if (this.eEd != null) {
                com.baidu.tbadk.core.util.as.k(this.eEd, w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.as.k(this.eEb, w.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.as.c(this.eEc, w.e.cp_cont_c, 1);
            }
            aN(i == 1);
            aQm();
            UtilHelper.setStatusBarBackground(this.bVj, i);
            if (this.eCu != null) {
                this.eCu.onChangeSkinType(i);
            }
            if (this.byv != null) {
                com.baidu.tbadk.core.util.as.i(this.byv, w.e.cp_cont_d);
            }
            if (this.eCx != null) {
                com.baidu.tbadk.core.util.as.i(this.eCx, w.e.cp_cont_f);
            }
            if (this.eCj != null) {
                com.baidu.tbadk.core.util.as.i(this.eCj, w.e.cp_link_tip_a);
            }
            if (this.eCw != null) {
                com.baidu.tbadk.core.util.as.i(this.eCw, w.e.cp_cont_f);
            }
            if (this.eCy != null) {
                com.baidu.tbadk.m.a.a(this.euf.getPageContext(), this.eCy);
            }
            if (this.eDQ != null) {
                this.eDQ.onChangeSkinType(i);
            }
            if (this.eBR != null) {
                if (this.eBM != null) {
                    this.eBM.pi(i);
                } else {
                    this.eBR.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.as.i(this.eCi, w.e.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aPr = eVar;
        this.eCF.setOnImageClickListener(this.aPr);
    }

    public void c(NoNetworkView.a aVar) {
        this.bzE = aVar;
        if (this.bzB != null) {
            this.bzB.a(this.bzE);
        }
    }

    public void jp(boolean z) {
        this.eCF.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aQK() {
        return this.eDm;
    }

    public void aQL() {
        if (this.eBQ != 2) {
            this.eBV.setNextPage(this.eCK);
            this.eBQ = 2;
        }
    }

    public void aQM() {
        if (com.baidu.tbadk.j.aa.Gb().Gc()) {
            int lastVisiblePosition = this.eBV.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eBV.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(w.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.j.u perfLog = tbImageView.getPerfLog();
                                perfLog.fd(1001);
                                perfLog.aHC = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.wk();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(w.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.j.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fd(1001);
                        perfLog2.aHC = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.wk();
                    }
                }
            }
        }
    }

    public void gU(boolean z) {
        if (this.eDn != null) {
            if (this.dzL) {
                gV(z);
            } else {
                gW(z);
            }
        }
    }

    public void aQN() {
        if (this.eDn != null) {
            this.eDn.setVisibility(8);
            this.eDs = false;
            if (this.eDF != null) {
                this.eDF.setVisibility(8);
            }
        }
    }

    public void Qx() {
        if (this.bjx == null) {
            this.bjx = new com.baidu.tbadk.core.view.a(this.euf.getPageContext());
        }
        this.bjx.aI(true);
    }

    public void Qy() {
        if (this.bjx != null) {
            this.bjx.aI(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eBV.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eBV.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eBM != null) {
            this.eBM.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eEt = getScrollY();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z = false;
        this.eDW = false;
        if (this.eBM != null) {
            this.eBM.b(absListView, i);
        }
        a aVar = new a();
        aVar.eEz = i;
        aVar.eEA = this.eBV.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
        int headerViewsCount = (i - this.eBV.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                break;
            } else if (this.eCF.oL(headerViewsCount) != com.baidu.tieba.pb.data.m.esg) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.eCF.aOx().ji(z);
    }

    /* loaded from: classes.dex */
    public class a {
        public int eEA;
        public int eEz;

        public a() {
        }
    }

    public void aQO() {
        if (!this.eEu) {
            TiebaStatic.log("c10490");
            this.eEu = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.euf.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eDJ, Integer.valueOf(eDL));
            aVar.bX(w.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(w.h.function_description_view)).setText(w.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(w.h.title_view)).setText(w.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(w.l.grade_button_tips, this.euf);
            aVar.b(w.l.look_again, new ha(this));
            aVar.b(this.euf.getPageContext()).ta();
        }
    }

    public void aQP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.euf.getPageContext().getPageActivity());
        aVar.cI(this.euf.getResources().getString(w.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eDJ, Integer.valueOf(eDN));
        aVar.A(sparseArray);
        aVar.a(w.l.upgrade_to_new, this.euf);
        aVar.b(w.l.cancel, new hb(this));
        aVar.b(this.euf.getPageContext()).ta();
    }

    public int rf() {
        return this.eDG;
    }

    public void oU(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.euf.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.euf.getPageContext().getPageActivity()).inflate(w.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(w.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(w.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eDJ, Integer.valueOf(eDM));
        aVar.A(sparseArray);
        aVar.a(w.l.view, this.euf);
        aVar.b(w.l.cancel, new hc(this));
        aVar.b(this.euf.getPageContext()).ta();
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

    public PbInterviewStatusView aQQ() {
        return this.eDC;
    }

    private void o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aMv() != null && fVar.aMv().sj() && this.eDC == null) {
            this.eDC = (PbInterviewStatusView) this.eDB.inflate();
            this.eDC.setOnClickListener(this.cdH);
            this.eDC.setCallback(this.euf.aOd());
            this.eDC.a(this.euf, fVar);
        }
    }

    public LinearLayout aQR() {
        return this.eCE;
    }

    public View aQS() {
        return this.bVj;
    }

    public boolean aQT() {
        return this.eEe;
    }

    public void iA(boolean z) {
        this.eCe.iA(z);
    }

    private void aQU() {
        if (this.eEe) {
            if (this.eEf == null) {
                f.a aVar = f.eui.get();
                if (aVar != null) {
                    this.eEf = aVar.a(this.euf);
                    ListAdapter adapter = this.eBV.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.aww) {
                            this.eBV.addHeaderView(this.eEf.aNr(), 1);
                        } else {
                            this.eBV.addHeaderView(this.eEf.aNr(), 0);
                        }
                    }
                } else {
                    this.eCb.setVisibility(0);
                    return;
                }
            }
            this.eCb.setVisibility(8);
            this.eBV.removeHeaderView(this.eCb);
            return;
        }
        this.eCb.setVisibility(0);
    }

    public void jq(boolean z) {
        this.eEe = z;
    }

    public void aQV() {
        this.euf.showNetRefreshView(getView(), "");
        View Eu = this.euf.getRefreshView().Eu();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Eu.getLayoutParams();
        layoutParams.addRule(3, aQR().getId());
        Eu.setLayoutParams(layoutParams);
        this.euf.hideLoadingView(getView());
        if (this.eEf != null) {
            this.eBV.removeHeaderView(this.eEf.aNr());
            this.eEf = null;
        }
    }

    public void oV(String str) {
        if (this.eBS != null) {
            this.eBS.setTitle(str);
        }
    }

    private int jr(boolean z) {
        if (this.eDC == null || this.eDC.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.euf.getPageContext().getPageActivity(), w.f.ds72);
    }

    private void aQW() {
        if (this.eDC != null && this.eDC.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eDC.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eDC.setLayoutParams(layoutParams);
        }
    }

    public boolean aNA() {
        return false;
    }

    public boolean aQX() {
        return this.eDU;
    }

    public TextView aQY() {
        return this.eCr;
    }

    public void oW(String str) {
        this.eDp.performClick();
        if (!StringUtils.isNull(str) && this.euf.aNu() != null && this.euf.aNu().Dg() != null && this.euf.aNu().Dg().CZ() != null) {
            EditText CZ = this.euf.aNu().Dg().CZ();
            CZ.setText(str);
            CZ.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            azw();
            aQN();
            aQc();
            if (this.eDQ != null) {
                this.eDQ.aOB();
            }
            this.euf.aej();
            this.eCE.setVisibility(8);
            this.eBR.setTitleVisibility(false);
            this.euf.iG(false);
            if (this.eBM != null) {
                if (configuration.orientation == 1) {
                    aQR().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eBV.setIsLandscape(true);
                    this.eBV.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eBV.setIsLandscape(false);
                    if (this.eEt > 0) {
                        this.eBV.smoothScrollBy(this.eEt, 0);
                    }
                }
                this.eBM.onConfigurationChanged(configuration);
            }
        }
    }

    public void js(boolean z) {
        this.eBP = z;
    }

    public boolean aQZ() {
        return this.eBM != null && this.eBM.aQZ();
    }

    public void aRa() {
        if (this.eBM != null) {
            this.eBM.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.eBN != null) {
            this.eBN.w(j, i);
        }
        if (this.eBM != null) {
            this.eBM.w(j, i);
        }
    }

    public void aRb() {
        if (this.eDF != null) {
            this.eDF.aRo();
        }
    }

    public void aRc() {
        if (this.eDF != null) {
            this.eDF.setVisibility(8);
        }
    }

    public void iK(boolean z) {
        this.eCF.iK(z);
    }

    public void aRd() {
        if (this.eDD == null) {
            LayoutInflater.from(this.euf.getActivity()).inflate(w.j.add_experienced_text, (ViewGroup) this.bSW, true);
            this.eDD = (ViewGroup) this.bSW.findViewById(w.h.add_experienced_layout);
            this.eDE = (TextView) this.bSW.findViewById(w.h.add_experienced);
            com.baidu.tbadk.core.util.as.i(this.eDE, w.e.cp_cont_i);
            String string = this.euf.getResources().getString(w.l.experienced_add_success);
            String string2 = this.euf.getResources().getString(w.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_h)));
            this.eDE.setText(spannableString);
        }
        this.eDD.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new hd(this));
        this.eDE.startAnimation(scaleAnimation);
    }
}
