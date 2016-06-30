package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcelable;
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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.u;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class es {
    private com.baidu.tbadk.editortools.l BW;
    private t.b acD;
    private TextView amM;
    private View axc;
    private View.OnClickListener bFi;
    private View bFz;
    private NoNetworkView bkT;
    private BdTypeListView bou;
    private RelativeLayout dHM;
    private com.baidu.tieba.pb.a.d dME;
    private View.OnClickListener dNh;
    private PbActivity dOg;
    PbActivity.c dPr;
    private dc dTA;
    private ColumnLayout dTB;
    private ThreadSkinView dTC;
    private TextView dTD;
    private TextView dTE;
    private HeadImageView dTF;
    private ImageView dTG;
    private ImageView dTH;
    private ImageView dTI;
    private UserIconBox dTJ;
    private UserIconBox dTK;
    private ImageView dTL;
    private TextView dTM;
    private TextView dTN;
    private LinearLayout dTO;
    private TextView dTP;
    private TextView dTQ;
    private TextView dTU;
    private UserLikeButton dTX;
    private LinearLayout dTY;
    private TextView dTZ;
    public int dTn;
    public final com.baidu.tieba.pb.pb.main.b.e dTq;
    public com.baidu.tieba.pb.pb.main.b.c dTr;
    private ViewStub dTs;
    private ViewStub dTt;
    private List<com.baidu.tieba.pb.pb.main.b.a> dTu;
    private View dTv;
    private LinearLayout dTx;
    private com.baidu.tieba.pb.data.b dTy;
    private g dTz;
    private View dUN;
    private TextView dUO;
    private TextView dUP;
    private ViewGroup dUQ;
    private TextView dUR;
    private boolean dUT;
    private HeadImageView dUU;
    private ImageView dUV;
    private TextView dUa;
    private View dUc;
    private View dUd;
    private ObservedChangeLinearLayout dUg;
    private ch dUh;
    private PbListView dUm;
    private View dUo;
    private TextView dVA;
    private ClickableHeaderImageView dVB;
    private TextView dVC;
    private LinearLayout dVD;
    private boolean dVE;
    private f dVF;
    private Runnable dVH;
    private PbActivity.a dVK;
    private boolean dVM;
    private boolean dVN;
    private View dVb;
    private TextView dVc;
    private ViewStub dVd;
    private PbInterviewStatusView dVe;
    private Runnable dVn;
    private Runnable dVo;
    private View dVz;
    public static int dVg = 2;
    public static int dVh = 3;
    public static int dVi = 0;
    public static int dVj = 3;
    public static int dVk = 4;
    public static int dVl = 5;
    public static int dVm = 6;
    private static HashMap<Point, Integer> QP = new HashMap<>();
    private static SparseArray<at.a> dVp = new SparseArray<>(3);
    private int dTo = 0;
    private int dTp = 0;
    private final Handler mHandler = new Handler();
    private View dTw = null;
    private TextView dTR = null;
    private TextView dTS = null;
    private TextView dTT = null;
    public FrsPraiseView dTV = null;
    private ClickableHeaderImageView dSp = null;
    private ClickableHeaderImageView dTW = null;
    private View dUb = null;
    private View dUe = null;
    private boolean dUf = false;
    private com.baidu.tbadk.core.dialog.a dUi = null;
    private com.baidu.tbadk.core.dialog.c bFc = null;
    private View dUj = null;
    private EditText dUk = null;
    private com.baidu.tieba.pb.view.w dUl = null;
    private com.baidu.tieba.pb.view.d dUn = null;
    private c.b cPF = null;
    private TbRichTextView.d aFF = null;
    private NoNetworkView.a bAH = null;
    private Dialog dUp = null;
    private View dUq = null;
    private com.baidu.tbadk.core.dialog.a dUr = null;
    private Dialog dUs = null;
    private View dUt = null;
    private int dUu = 0;
    private RadioGroup EH = null;
    private RadioButton dUv = null;
    private RadioButton dUw = null;
    private RadioButton dUx = null;
    private Button dUy = null;
    private Button dUz = null;
    private TextView dUA = null;
    private Dialog dUB = null;
    private View dUC = null;
    private LinearLayout dUD = null;
    private CompoundButton.OnCheckedChangeListener dUE = null;
    private TextView dUF = null;
    private TextView dUG = null;
    private String dUH = null;
    private com.baidu.tbadk.core.dialog.c dUI = null;
    private boolean dUJ = false;
    private boolean dUK = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView dUL = null;
    private boolean diC = false;
    private Button dUM = null;
    private boolean dUS = true;
    private LinearLayout dUW = null;
    private TextView dUX = null;
    private TextView dUY = null;
    private View aIa = null;
    private com.baidu.tbadk.core.view.b dUZ = null;
    private boolean dNd = false;
    private boolean dVa = false;
    private boolean mIsFromCDN = true;
    private int dVf = 0;
    private boolean dVq = true;
    private a.InterfaceC0075a dVr = new et(this);
    private boolean dVs = false;
    private boolean dVt = false;
    private boolean dVu = false;
    private LinearLayout dVv = null;
    private TextView dVw = null;
    private int dVx = 0;
    private boolean dVy = false;
    private Handler dVG = new Handler();
    private CustomMessageListener dVI = new fe(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener dVJ = new fo(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean dVL = true;
    private boolean dVO = false;
    private boolean Rb = false;
    String userId = null;
    private final List<TbImageView> dVP = new ArrayList();
    private boolean dNc = true;
    private boolean dVQ = false;
    private Runnable cqF = new fv(this);

    static {
        QP.put(new Point(1, 1), Integer.valueOf(u.j.lottery_status_ing));
        QP.put(new Point(1, 2), Integer.valueOf(u.j.lottery_status_over));
        QP.put(new Point(1, 3), Integer.valueOf(u.j.lottery_status_off));
        QP.put(new Point(1, 4), Integer.valueOf(u.j.lottery_status_not_start));
        QP.put(new Point(2, 1), Integer.valueOf(u.j.share_picture_status_ing));
        QP.put(new Point(2, 2), Integer.valueOf(u.j.share_picture_status_over));
        QP.put(new Point(2, 3), Integer.valueOf(u.j.share_picture_status_off));
        QP.put(new Point(2, 4), Integer.valueOf(u.j.share_picture_status_not_start));
        dVp.put(1, new at.a(u.j.interview_live_status_not_start, u.d.cp_other_b, u.f.pic_dot_title_red));
        dVp.put(2, new at.a(u.j.interview_live_status_ing, u.d.cp_other_c, u.f.pic_dot_title_green));
        dVp.put(3, new at.a(u.j.interview_live_status_over, u.d.cp_other_d, u.f.pic_dot_title_blue));
    }

    public f aGQ() {
        return this.dVF;
    }

    public NoNetworkView aGR() {
        return this.bkT;
    }

    public boolean isFullScreen() {
        return this.dVt;
    }

    public void aGS() {
        if (this.BW != null) {
            this.BW.hide();
        }
    }

    public void aGT() {
        reset();
        this.dUS = true;
        if (this.BW != null) {
            this.BW.hide();
        }
        if (this.dUN != null) {
            if (this.diC && !aHZ()) {
                gd(false);
            } else {
                ge(false);
            }
        }
        aFG();
    }

    private void reset() {
        if (this.dOg != null && this.dOg.aEz() != null && this.BW != null) {
            com.baidu.tbadk.editortools.d.b.BM().setStatus(0);
            com.baidu.tbadk.editortools.d.e aEz = this.dOg.aEz();
            aEz.Cl();
            if (aEz.getWriteImagesInfo() != null) {
                aEz.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aEz.eu(10);
            aEz.es(SendView.ALL);
            aEz.et(SendView.ALL);
            aEz.fA(this.dOg.getActivity().getString(u.j.pb_reply_hint));
            com.baidu.tbadk.editortools.s ej = this.BW.ej(23);
            com.baidu.tbadk.editortools.s ej2 = this.BW.ej(2);
            com.baidu.tbadk.editortools.s ej3 = this.BW.ej(5);
            if (ej2 != null) {
                ej2.kF();
            }
            if (ej3 != null) {
                ej3.kF();
            }
            if (ej != null) {
                ej.hide();
            }
            this.BW.invalidate();
        }
    }

    public boolean aGU() {
        return this.dUS;
    }

    public void gd(boolean z) {
        if (this.dUN != null && this.dUO != null && this.dUP != null) {
            this.dUO.setText(u.j.draft_to_send);
            this.dUP.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.dUN.startAnimation(alphaAnimation);
            }
            this.dUN.setVisibility(0);
        }
    }

    public void ge(boolean z) {
        if (this.dUN != null && this.dUO != null && this.dUP != null) {
            this.dUO.setText(u.j.reply_floor_host);
            this.dUP.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.dUN.startAnimation(alphaAnimation);
            }
            this.dUN.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.s aGV() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.bou == null) {
            return null;
        }
        int firstVisiblePosition = this.bou.getFirstVisiblePosition();
        int lastVisiblePosition = this.bou.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.bou.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.bou.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.bou.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.dUh.nj(headerViewsCount) != null && this.dUh.nj(headerViewsCount) != com.baidu.tieba.tbadkCore.data.s.eXE) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.s) this.dUh.at(i2);
    }

    public es(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.dOg = null;
        this.dHM = null;
        this.bFz = null;
        this.bou = null;
        this.dTv = null;
        this.dTx = null;
        this.dTB = null;
        this.dTD = null;
        this.dTE = null;
        this.dTF = null;
        this.dTG = null;
        this.dTH = null;
        this.dTI = null;
        this.dTJ = null;
        this.dTK = null;
        this.dTL = null;
        this.dTM = null;
        this.dTN = null;
        this.dTO = null;
        this.dTP = null;
        this.dTQ = null;
        this.dTU = null;
        this.dTX = null;
        this.dUc = null;
        this.dUd = null;
        this.dUh = null;
        this.dUm = null;
        this.axc = null;
        this.bFi = null;
        this.dNh = null;
        this.dUN = null;
        this.dUO = null;
        this.dUQ = null;
        this.dUR = null;
        this.dUU = null;
        this.dUV = null;
        this.dVb = null;
        this.dVc = null;
        this.dVd = null;
        this.dOg = pbActivity;
        this.bFi = onClickListener;
        this.dME = dVar;
        this.dHM = (RelativeLayout) LayoutInflater.from(this.dOg.getPageContext().getPageActivity()).inflate(u.h.new_pb_activity, (ViewGroup) null);
        this.dOg.addContentView(this.dHM, new FrameLayout.LayoutParams(-1, -1));
        this.bFz = this.dOg.findViewById(u.g.statebar_view);
        this.dUg = (ObservedChangeLinearLayout) this.dOg.findViewById(u.g.title_wrapper);
        this.bkT = (NoNetworkView) this.dOg.findViewById(u.g.view_no_network);
        this.bou = (BdTypeListView) this.dOg.findViewById(u.g.new_pb_list);
        this.amM = new TextView(this.dOg.getActivity());
        this.amM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(this.dOg.getActivity(), u.e.ds98)));
        this.bou.f(this.amM, 0);
        View view = new View(this.dOg.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.dOg.getResources().getDimensionPixelSize(u.e.ds100)));
        view.setVisibility(4);
        this.bou.addFooterView(view);
        this.bou.setOnTouchListener(this.dOg.aGb);
        this.dTq = new com.baidu.tieba.pb.pb.main.b.e(pbActivity);
        if (this.dOg.aEV()) {
            this.dTs = (ViewStub) this.dOg.findViewById(u.g.manga_view_stub);
            this.dTs.setVisibility(0);
            this.dTr = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
            this.dTr.show();
            this.dTq.mNavigationBar.setVisibility(8);
        }
        this.dTq.aIc().setOnTouchListener(new com.baidu.tieba.pb.a.a(new fw(this)));
        this.dUN = this.dOg.findViewById(u.g.pb_editor_tool_comment);
        this.dUO = (TextView) this.dOg.findViewById(u.g.pb_editor_tool_comment_reply_text);
        this.dUQ = (ViewGroup) this.dOg.findViewById(u.g.pb_editor_tool_comment_reply_layout);
        this.dUR = (TextView) this.dOg.findViewById(u.g.pb_editor_tool_comment_praise_icon);
        this.dUU = (HeadImageView) this.dOg.findViewById(u.g.pb_editor_tool_comment_avatar);
        aHf();
        this.dUV = (ImageView) this.dOg.findViewById(u.g.pb_editor_tool_comment_share_icon);
        this.dUV.setOnClickListener(this.bFi);
        boolean an = com.baidu.tieba.graffiti.d.an(this.dUR);
        if (an) {
            hP(an);
            this.dUR.setVisibility(0);
        }
        this.dUP = (TextView) this.dOg.findViewById(u.g.pb_editor_tool_comment_reply_count_text);
        this.dTA = new dc(this.dOg, this.dHM);
        this.dTA.init();
        this.dTA.a(this.dTA.aFH(), this.bFi);
        this.dUQ.setOnClickListener(new fx(this));
        this.dUR.setOnClickListener(this.bFi);
        this.dUR.setOnTouchListener(this.dOg);
        this.dTv = LayoutInflater.from(this.dOg.getPageContext().getPageActivity()).inflate(u.h.new_pb_header_item, (ViewGroup) null);
        this.dTx = (LinearLayout) LayoutInflater.from(this.dOg.getPageContext().getPageActivity()).inflate(u.h.new_pb_header_user_item, (ViewGroup) null);
        this.dTz = new g(this.dOg, this.dTx);
        this.dTz.init();
        this.dTz.a(this.dTz.aEy(), this.bFi);
        this.dTB = (ColumnLayout) this.dTx.findViewById(u.g.pb_head_owner_root);
        this.dTC = (ThreadSkinView) this.dTx.findViewById(u.g.pb_thread_skin);
        this.dTB.setOnLongClickListener(this.onLongClickListener);
        this.dTB.setOnTouchListener(this.dME);
        this.dTB.setVisibility(8);
        this.dTv.setOnTouchListener(this.dME);
        this.dTD = (TextView) this.dTv.findViewById(u.g.pb_head_post_title);
        this.dTD.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.dTD.setVisibility(8);
        this.dVb = this.dTv.findViewById(u.g.pb_head_activity_join_number_container);
        this.dVb.setVisibility(8);
        this.dVc = (TextView) this.dTv.findViewById(u.g.pb_head_activity_join_number);
        this.dTE = (TextView) this.dTB.findViewById(u.g.pb_head_owner_info_user_name);
        this.dTF = (HeadImageView) this.dTB.findViewById(u.g.pb_head_owner_photo);
        if (!this.dNc) {
            this.dTF.setVisibility(8);
        }
        this.dTG = (ImageView) this.dTB.findViewById(u.g.pb_head_owner_info_user_rank);
        this.dTH = (ImageView) this.dTB.findViewById(u.g.pb_head_owner_info_user_gender);
        this.dTI = (ImageView) this.dTB.findViewById(u.g.pb_head_owner_info_user_bawu);
        this.dTJ = (UserIconBox) this.dTB.findViewById(u.g.pb_head_owner_info_user_icon);
        this.dTK = (UserIconBox) this.dTB.findViewById(u.g.pb_head_owner_info_tshow_icon);
        this.dTL = (ImageView) this.dTB.findViewById(u.g.pb_head_owner_info_floor_owner);
        this.dTN = (TextView) this.dTB.findViewById(u.g.pb_head_owner_info_floor);
        this.dTM = (TextView) this.dTB.findViewById(u.g.pb_head_owner_info_time);
        this.dTO = (LinearLayout) this.dTv.findViewById(u.g.read_thread_view);
        this.dTP = (TextView) this.dTv.findViewById(u.g.pb_head_read_button);
        this.dTQ = (TextView) this.dTv.findViewById(u.g.pb_head_read_tip);
        this.dTO.setOnClickListener(this.bFi);
        this.dTU = (TextView) this.dTv.findViewById(u.g.pb_head_reverse_hint);
        this.dTU.setOnClickListener(this.bFi);
        this.dTU.setVisibility(8);
        this.dTX = (UserLikeButton) this.dTB.findViewById(u.g.pb_like_button);
        aHb();
        this.dUc = this.dTv.findViewById(u.g.new_pb_header_item_line_above_livepost);
        this.dUd = this.dTv.findViewById(u.g.new_pb_header_item_line_below_livepost);
        this.dTv.setOnLongClickListener(new fy(this));
        aHi();
        this.dVd = (ViewStub) this.dHM.findViewById(u.g.interview_status_stub);
        this.dUh = new ch(this.dOg, this.bou);
        this.dUh.I(this.bFi);
        this.dUh.a(this.dME);
        this.dUh.setOnImageClickListener(this.aFF);
        this.dNh = new fz(this);
        this.dUh.H(this.dNh);
        this.bou.addHeaderView(this.dTx);
        this.bou.addHeaderView(this.dTv);
        this.dUm = new PbListView(this.dOg.getPageContext().getPageActivity());
        this.axc = this.dUm.getView().findViewById(u.g.pb_more_view);
        if (this.axc != null) {
            this.axc.setOnClickListener(this.bFi);
            com.baidu.tbadk.core.util.av.k(this.axc, u.f.pb_foot_more_trans_selector);
        }
        this.dUm.va();
        this.dUm.cR(u.f.pb_foot_more_trans_selector);
        this.dUm.cS(u.f.pb_foot_more_trans_selector);
        this.dUo = this.dOg.findViewById(u.g.viewstub_progress);
        this.dOg.registerListener(this.dVI);
        this.dTX.i(this.dOg.getUniqueId());
    }

    public void aGW() {
        if (this.bou != null) {
            this.bou.removeHeaderView(this.dTx);
            this.bou.removeHeaderView(this.dTv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGX() {
        if (this.dOg.aEV()) {
            this.dTt = (ViewStub) this.dOg.findViewById(u.g.manga_mention_controller_view_stub);
            this.dTt.setVisibility(0);
            if (this.dTY == null) {
                this.dTY = (LinearLayout) this.dOg.findViewById(u.g.manga_controller_layout);
                com.baidu.tbadk.j.a.a(this.dOg.getPageContext(), this.dTY);
            }
            if (this.dTZ == null) {
                this.dTZ = (TextView) this.dTY.findViewById(u.g.manga_prev_btn);
            }
            if (this.dUa == null) {
                this.dUa = (TextView) this.dTY.findViewById(u.g.manga_next_btn);
            }
            this.dTZ.setOnClickListener(this.bFi);
            this.dUa.setOnClickListener(this.bFi);
        }
    }

    private void aGY() {
        if (this.dOg.aEV()) {
            if (this.dOg.aEY() == -1) {
                com.baidu.tbadk.core.util.av.c(this.dTZ, u.d.cp_cont_e, 1);
            }
            if (this.dOg.aEZ() == -1) {
                com.baidu.tbadk.core.util.av.c(this.dUa, u.d.cp_cont_e, 1);
            }
        }
    }

    public void aGZ() {
        if (this.dTY == null) {
            aGX();
        }
        this.dTt.setVisibility(8);
        if (this.dVG != null && this.dVH != null) {
            this.dVG.removeCallbacks(this.dVH);
        }
    }

    private void a(DealInfoData dealInfoData, boolean z) {
        if (this.dVs) {
            View findViewWithTag = this.dTx.findViewWithTag("pb_god_bottom_line_view_tag");
            if (findViewWithTag != null) {
                this.dTx.removeView(findViewWithTag);
            }
            this.dTS.setPadding(this.dTS.getPaddingLeft(), this.dTS.getCompoundPaddingTop(), this.dTS.getPaddingRight(), this.dOg.getResources().getDimensionPixelSize(u.e.ds10));
            this.dTB.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds30), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds20), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds32), 0);
        } else {
            this.dTN.setVisibility(8);
            this.dTB.setPadding(this.dOg.getResources().getDimensionPixelSize(u.e.ds30), this.dOg.getResources().getDimensionPixelSize(u.e.ds18), this.dOg.getResources().getDimensionPixelSize(u.e.ds30), this.dOg.getResources().getDimensionPixelSize(u.e.ds10));
            ((FloatingLayout) this.dTx.findViewById(u.g.pb_head_owner_info_root)).setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds16), 0, 0);
        }
        this.bou.setOverScrollMode(2);
        this.dUN.setPadding(this.dUN.getPaddingLeft(), 0, 0, 0);
        com.baidu.tbadk.core.util.av.k(this.dUN, u.f.pb_ecomm_comment_bg);
        this.dUQ.setBackgroundResource(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dUQ.getLayoutParams();
        marginLayoutParams.rightMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds234);
        this.dUQ.setLayoutParams(marginLayoutParams);
        TextView textView = (TextView) this.dOg.findViewById(u.g.pb_editor_tool_comment_ecomm_buy_layout);
        textView.setVisibility(0);
        View findViewById = this.dHM.findViewById(u.g.pb_editor_tool_comment_layout);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
        if (z || !appResponseToIntentClass) {
            textView.setVisibility(8);
        } else if (dealInfoData.status != 1) {
            textView.setText(u.j.pb_ecomm_status_off_shelf_text);
            com.baidu.tbadk.core.util.av.l(textView, u.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else if (dealInfoData.stock == 0) {
            textView.setText(u.j.pb_ecomm_buy_button_none_text);
            com.baidu.tbadk.core.util.av.l(textView, u.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            textView.setText(u.j.pb_ecomm_buy_button_text);
            com.baidu.tbadk.core.util.av.l(textView, u.d.cp_other_e);
            if (this.bFi != null) {
                textView.setOnClickListener(this.bFi);
            }
        }
    }

    public void aHa() {
        if (this.dVG != null) {
            if (this.dVH != null) {
                this.dVG.removeCallbacks(this.dVH);
            }
            this.dVH = new eu(this);
            this.dVG.postDelayed(this.dVH, 2000L);
        }
    }

    public void hI(boolean z) {
        this.dTq.hI(z);
        if (z && this.dVa) {
            this.dUm.setText(this.dOg.getResources().getString(u.j.click_load_more));
            this.bou.setNextPage(this.dUm);
            this.dTp = 2;
        }
    }

    private void aHb() {
        if (com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("should_show_pb_read_text", true)) {
            this.dTQ.setVisibility(0);
        }
    }

    public void aHc() {
        this.dTQ.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("should_show_pb_read_text", false);
    }

    public void aHd() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.dHM.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BW = lVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dHM.addView(this.BW, layoutParams);
        this.BW.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.BW.hide();
    }

    public void aHe() {
        if (this.dOg != null && this.BW != null) {
            this.BW.kF();
        }
    }

    public void nB(String str) {
        if (this.dUP != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.dUP.setText(this.dOg.getPageContext().getResources().getString(u.j.pb_reply_count_text, str));
        }
    }

    private void aHf() {
        if (this.dUU != null) {
            this.dUU.setIsRound(true);
            this.dUU.setDrawBorder(false);
            this.dUU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (!StringUtils.isNull(currentPortrait)) {
                String di = com.baidu.tbadk.core.util.q.di(currentPortrait);
                this.dUU.setUrl(di);
                this.dUU.c(di, 12, false);
            }
        }
    }

    public void I(String str, boolean z) {
        this.dUT = z;
        hJ(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void hJ(boolean z) {
        if (this.dUR != null) {
            if (this.dUT) {
                com.baidu.tbadk.core.util.av.k(this.dUR, u.f.pb_praise_already_click_selector);
                this.dUR.setContentDescription(this.dOg.getResources().getString(u.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.av.k(this.dUR, u.f.pb_praise_normal_click_selector);
            this.dUR.setContentDescription(this.dOg.getResources().getString(u.j.frs_item_praise_text));
        }
    }

    public TextView aHg() {
        return this.dUR;
    }

    public void hK(boolean z) {
        if (this.bou != null) {
            if (!z) {
                this.bou.setEnabled(z);
                return;
            }
            if (this.dVo == null) {
                this.dVo = new ev(this, z);
            }
            com.baidu.adp.lib.h.h.dM().postDelayed(this.dVo, 10L);
        }
    }

    public void hL(boolean z) {
        if (this.bou != null && this.amM != null && this.bFz != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bFz.setVisibility(0);
                    this.bou.removeHeaderView(this.amM);
                    this.bou.f(this.amM, 0);
                } else {
                    this.bFz.setVisibility(8);
                    this.bou.removeHeaderView(this.amM);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.amM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.amM.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.amM.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + hU(true);
                this.amM.setLayoutParams(layoutParams2);
            }
            this.bou.removeHeaderView(this.amM);
            this.bou.f(this.amM, 0);
            aHY();
        }
    }

    public void aY(View view) {
        boolean z;
        View view2;
        if (this.dUg != null && view != null) {
            if (this.dUS) {
                z = this.dUN.getVisibility() == 0;
            } else {
                z = this.BW != null && this.BW.getVisibility() == 0;
            }
            boolean z2 = this.dUg.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.dVt = true;
                View findViewById = this.dOg.findViewById(u.g.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.dUg.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.dOg, this.dUg, u.a.top_fold_up, new ew(this, findViewById));
            } else {
                this.dVt = false;
                com.baidu.tieba.tbadkCore.a.a(this.dOg, this.dUg, u.a.top_fold_down, new ex(this));
            }
            if (this.dUS) {
                view2 = this.dUN;
            } else {
                view2 = this.BW;
            }
            if (z) {
                if (z2) {
                    if (this.BW != null) {
                        this.BW.zD();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.dOg, view2, u.a.bottom_fold_down, new ey(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.dOg, view2, u.a.bottom_fold_up, new ez(this));
            }
            aFG();
        }
    }

    public ch aHh() {
        return this.dUh;
    }

    public void a(PbActivity.c cVar) {
        this.dPr = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bd bdVar) {
        if (bdVar == null || bdVar.rG() == 0) {
            if (this.dUM != null) {
                this.dUM.setVisibility(8);
            }
            if (this.dUc != null) {
                this.dUc.setVisibility(8);
                return;
            }
            return;
        }
        if (this.dUM == null) {
            this.dOg.getLayoutMode().w(((ViewStub) this.dTv.findViewById(u.g.live_talk_layout)).inflate());
            this.dUM = (Button) this.dTv.findViewById(u.g.pb_head_function_manage_go_to_live_post);
            this.dUc = this.dTv.findViewById(u.g.new_pb_header_item_line_above_livepost);
        }
        int rH = bdVar.rH();
        String string = this.dOg.getPageContext().getString(u.j.go_to_live_post_prefix);
        if (rH == 0) {
            string = String.valueOf(string) + this.dOg.getPageContext().getString(u.j.go_to_interview_post);
        } else if (rH == 1) {
            string = String.valueOf(string) + this.dOg.getPageContext().getString(u.j.go_to_discuss_post);
        }
        this.dUM.setText(string);
        this.dUM.setVisibility(0);
        this.dUM.setOnClickListener(this.bFi);
        this.dVN = true;
        aHv();
        aHy();
    }

    private void aHi() {
        this.dUW = (LinearLayout) this.dTv.findViewById(u.g.btn_show_passed_pb);
        this.dUY = (TextView) this.dTv.findViewById(u.g.show_pre_page_view);
        this.dUX = (TextView) this.dTv.findViewById(u.g.go_back_top_view);
        this.aIa = this.dTv.findViewById(u.g.show_passed_divider);
        this.dUY.setOnClickListener(this.dVJ);
        this.dUX.setOnClickListener(this.bFi);
        aHy();
    }

    public LinearLayout aHj() {
        return this.dTO;
    }

    public void hM(boolean z) {
        if (this.dTO != null) {
            if (z && TbadkCoreApplication.m9getInst().isTTSCanUse() && !this.dVE) {
                this.dTO.setVisibility(0);
                if (this.dUW != null && this.dUW.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUW.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.dOg.getApplicationContext(), u.e.ds10);
                    this.dUW.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            this.dTO.setVisibility(8);
        }
    }

    public void aZ(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.dUq == null) {
            this.dUq = LayoutInflater.from(this.dOg.getPageContext().getPageActivity()).inflate(u.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.dOg.getLayoutMode().w(this.dUq);
        if (this.dUp == null) {
            this.dUp = new Dialog(this.dOg.getPageContext().getPageActivity(), u.k.common_alert_dialog);
            this.dUp.setCanceledOnTouchOutside(true);
            this.dUp.setCancelable(true);
            this.dUp.setContentView(this.dUq);
            WindowManager.LayoutParams attributes = this.dUp.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.A(this.dOg.getPageContext().getPageActivity()) * 0.9d);
            this.dUp.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.dUp.findViewById(u.g.del_post_btn);
        TextView textView2 = (TextView) this.dUp.findViewById(u.g.forbid_user_btn);
        TextView textView3 = (TextView) this.dUp.findViewById(u.g.disable_reply_btn);
        int intValue = sparseArray.get(u.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(u.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(u.g.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(u.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(u.j.delete);
            } else {
                textView.setText(u.j.delete_post);
            }
            sparseArray2.put(u.g.tag_del_post_id, sparseArray.get(u.g.tag_del_post_id));
            sparseArray2.put(u.g.tag_del_post_type, sparseArray.get(u.g.tag_del_post_type));
            sparseArray2.put(u.g.tag_del_post_is_self, sparseArray.get(u.g.tag_del_post_is_self));
            sparseArray2.put(u.g.tag_manage_user_identity, sparseArray.get(u.g.tag_manage_user_identity));
            textView.setOnClickListener(new fa(this));
        }
        if ("".equals(sparseArray.get(u.g.tag_forbid_user_name)) || aHV()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(u.g.tag_forbid_user_name, sparseArray.get(u.g.tag_forbid_user_name));
            sparseArray5.put(u.g.tag_manage_user_identity, sparseArray.get(u.g.tag_manage_user_identity));
            sparseArray5.put(u.g.tag_forbid_user_post_id, sparseArray.get(u.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new fb(this));
        }
        if (!((sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(u.j.un_mute);
            } else {
                textView3.setText(u.j.mute);
            }
            sparseArray6.put(u.g.tag_is_mem, sparseArray.get(u.g.tag_is_mem));
            sparseArray6.put(u.g.tag_user_mute_mute_userid, sparseArray.get(u.g.tag_user_mute_mute_userid));
            sparseArray6.put(u.g.tag_user_mute_mute_username, sparseArray.get(u.g.tag_user_mute_mute_username));
            sparseArray6.put(u.g.tag_user_mute_post_id, sparseArray.get(u.g.tag_user_mute_post_id));
            sparseArray6.put(u.g.tag_user_mute_thread_id, sparseArray.get(u.g.tag_user_mute_thread_id));
            sparseArray6.put(u.g.tag_user_mute_msg, sparseArray.get(u.g.tag_user_mute_msg));
            textView3.setOnClickListener(new fc(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.dUp, this.dOg.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.dVK = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(u.g.tag_del_post_id, str);
        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(dVi, Integer.valueOf(dVj));
        int i3 = u.j.del_post_confirm;
        if (i == 0) {
            i3 = u.j.del_thread_confirm;
        }
        this.dUr = new com.baidu.tbadk.core.dialog.a(this.dOg.getActivity());
        this.dUr.bM(i3);
        this.dUr.x(sparseArray);
        this.dUr.a(u.j.dialog_ok, this.dOg);
        this.dUr.b(u.j.dialog_cancel, new fd(this));
        this.dUr.an(true);
        this.dUr.b(this.dOg.getPageContext());
        this.dUr.rT();
    }

    public void ak(ArrayList<com.baidu.tbadk.core.data.v> arrayList) {
        if (this.dUC == null) {
            this.dUC = LayoutInflater.from(this.dOg.getPageContext().getPageActivity()).inflate(u.h.commit_good, (ViewGroup) null);
        }
        this.dOg.getLayoutMode().w(this.dUC);
        if (this.dUB == null) {
            this.dUB = new Dialog(this.dOg.getPageContext().getPageActivity(), u.k.common_alert_dialog);
            this.dUB.setCanceledOnTouchOutside(true);
            this.dUB.setCancelable(true);
            this.dUL = (ScrollView) this.dUC.findViewById(u.g.good_scroll);
            this.dUB.setContentView(this.dUC);
            WindowManager.LayoutParams attributes = this.dUB.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.c(this.dOg.getPageContext().getPageActivity(), u.e.ds540);
            this.dUB.getWindow().setAttributes(attributes);
            this.dUE = new ff(this);
            this.dUD = (LinearLayout) this.dUC.findViewById(u.g.good_class_group);
            this.dUG = (TextView) this.dUC.findViewById(u.g.dialog_button_cancel);
            this.dUG.setOnClickListener(new fg(this));
            this.dUF = (TextView) this.dUC.findViewById(u.g.dialog_button_ok);
            this.dUF.setOnClickListener(this.bFi);
        }
        this.dUD.removeAllViews();
        this.dTu = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a by = by("0", this.dOg.getPageContext().getString(u.j.def_good_class));
        this.dTu.add(by);
        by.setChecked(true);
        this.dUD.addView(by);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a by2 = by(String.valueOf(arrayList.get(i2).pc()), arrayList.get(i2).pb());
                this.dTu.add(by2);
                View view = new View(this.dOg.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.dOg.getPageContext().getPageActivity(), u.e.ds1));
                com.baidu.tbadk.core.util.av.l(view, u.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.dUD.addView(view);
                this.dUD.addView(by2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.dUL.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dOg.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dOg.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dOg.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.dUL.setLayoutParams(layoutParams2);
            this.dUL.removeAllViews();
            this.dUL.addView(this.dUD);
        }
        com.baidu.adp.lib.h.j.a(this.dUB, this.dOg.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a by(String str, String str2) {
        Activity pageActivity = this.dOg.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds100));
        aVar.setOnCheckedChangeListener(this.dUE);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aHk() {
        this.dOg.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.dOg.hideProgressBar();
        if (z && z2) {
            this.dOg.showToast(this.dOg.getPageContext().getString(u.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(u.j.neterror);
            }
            this.dOg.showToast(str);
        }
    }

    public void aoD() {
        this.dUo.setVisibility(0);
    }

    public void aoC() {
        this.dUo.setVisibility(8);
    }

    public View aHl() {
        if (this.dUC != null) {
            return this.dUC.findViewById(u.g.dialog_button_ok);
        }
        return null;
    }

    public String aHm() {
        return this.dUH;
    }

    public View getView() {
        return this.dHM;
    }

    public void aHn() {
        com.baidu.adp.lib.util.k.a(this.dOg.getPageContext().getPageActivity(), this.dOg.getCurrentFocus());
    }

    public void ave() {
        this.dOg.showProgressBar();
    }

    public void hN(boolean z) {
        this.dOg.hideProgressBar();
        avf();
    }

    public void aHo() {
        this.dUm.vh();
    }

    public void aHp() {
    }

    public void aHq() {
        this.dOg.hideProgressBar();
        this.dUm.vi();
        aHL();
        this.bou.k(2000L);
        aHy();
    }

    public void aHr() {
        this.bou.k(2000L);
        this.dUW.setVisibility(8);
        aHy();
    }

    public void hO(boolean z) {
        this.dTA.g(this.dTA.aFH(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dUQ.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.dOg.getResources().getDimensionPixelSize(u.e.ds84) : 0;
        this.dUQ.setLayoutParams(marginLayoutParams);
    }

    private void hP(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds14);
        if (z) {
            i = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds16);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUQ.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.dUQ.setLayoutParams(layoutParams);
    }

    public void c(com.baidu.tbadk.core.data.x xVar) {
        this.dTA.c(xVar);
    }

    public boolean aFE() {
        return this.dTA.aFE();
    }

    public void aFF() {
        this.dTA.aFF();
    }

    public void aFG() {
        this.dTA.aFG();
    }

    public ImageView aHs() {
        return this.dUV;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.dUh.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.dUI != null) {
            this.dUI.dismiss();
            this.dUI = null;
        }
        this.dUI = new com.baidu.tbadk.core.dialog.c(this.dOg.getPageContext().getPageActivity());
        this.dUI.bP(u.j.operation);
        if (z2) {
            this.dUI.a(new String[]{this.dOg.getPageContext().getString(u.j.copy)}, bVar);
        } else if (!z) {
            this.dUI.a(new String[]{this.dOg.getPageContext().getString(u.j.copy), this.dOg.getPageContext().getString(u.j.mark)}, bVar);
        } else {
            this.dUI.a(new String[]{this.dOg.getPageContext().getString(u.j.copy), this.dOg.getPageContext().getString(u.j.remove_mark)}, bVar);
        }
        this.dUI.d(this.dOg.getPageContext());
        this.dUI.rW();
    }

    public int aHt() {
        return nw(this.bou.getFirstVisiblePosition());
    }

    private int nw(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.bou.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.f)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.jw()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.bou.getAdapter() == null || !(this.bou.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.bou.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aHu() {
        return nw(this.bou.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.bou.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.dUk.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.h hVar) {
        this.dUh.b(hVar);
        this.dUh.notifyDataSetChanged();
        if (hVar == null) {
            nB("");
        } else {
            nB(com.baidu.tbadk.core.util.ba.D(hVar.aDO().getReply_num()));
        }
        aHy();
    }

    public void k(com.baidu.tieba.pb.data.h hVar) {
        PraiseData praise;
        if (this.dTV == null) {
            this.dOg.getLayoutMode().w(((ViewStub) this.dTv.findViewById(u.g.praise_layout)).inflate());
            this.dTV = (FrsPraiseView) this.dTv.findViewById(u.g.pb_head_praise_view);
            this.dTV.setIsFromPb(true);
            this.dUe = this.dTv.findViewById(u.g.new_pb_header_item_line_above_praise);
            this.dTV.cX(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.dTV != null) {
            boolean aHy = aHy();
            if (hVar != null && hVar.aDP() != null && hVar.aDP().size() > 0) {
                com.baidu.tieba.tbadkCore.data.s sVar = hVar.aDP().get(0);
                if ((!this.dNd || sVar.bcm() != 1) && (praise = hVar.aDO().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.dTV.setVisibility(0);
                    this.dTV.setIsFromPb(true);
                    this.dTV.a(praise, hVar.aDO().getId(), praise.getPostId(), true);
                    this.dTV.getVisibility();
                    com.baidu.tieba.graffiti.d.an(this.dTV);
                    return;
                }
            }
            this.dTV.setVisibility(8);
            if (hVar != null && hVar.getPage() != null && hVar.getPage().pF() == 0 && this.dNd) {
                if (aHy) {
                    this.dUd.setVisibility(0);
                } else {
                    this.dUd.setVisibility(8);
                }
            } else {
                this.dUd.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.an(this.dUd);
        }
    }

    private com.baidu.tieba.tbadkCore.data.s a(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        if (z) {
            if (hVar == null || hVar.aDP() == null || hVar.aDP().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.s sVar = hVar.aDP().get(0);
            if (sVar.bcm() != 1) {
                return a(hVar);
            }
            return sVar;
        }
        return a(hVar);
    }

    private com.baidu.tieba.tbadkCore.data.s a(com.baidu.tieba.pb.data.h hVar) {
        MetaData metaData;
        if (hVar == null || hVar.aDO() == null || hVar.aDO().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = new com.baidu.tieba.tbadkCore.data.s();
        MetaData author = hVar.aDO().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = hVar.aDO().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        sVar.qD(1);
        sVar.setId(hVar.aDO().qV());
        sVar.setTitle(hVar.aDO().getTitle());
        sVar.setTime(hVar.aDO().getCreateTime());
        sVar.setAuthor(metaData);
        return sVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v224, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        if (hVar != null && hVar.aDO() != null) {
            if (hVar.aDP() != null && hVar.aDP().size() > 0 && hVar.aDP().get(0) != null) {
                String str = null;
                if (this.dOg.aFf()) {
                    str = "FRS";
                }
                if (hVar.aDP().get(0).bcm() == 1 && hVar.aDP().get(0).qZ() != null) {
                    this.dTC.a(this.dOg.getPageContext(), hVar.aDP().get(0).qZ(), com.baidu.tieba.tbadkCore.d.a.a("PB", "c0132", hVar.aDN().getId(), hVar.aDN().getName(), hVar.aDO().getId(), str));
                    this.dTB.setPadding(this.dTB.getPaddingLeft(), (int) this.dOg.getResources().getDimension(u.e.ds20), this.dTB.getPaddingRight(), this.dTB.getPaddingBottom());
                } else {
                    this.dTC.a(null, null, null);
                }
            }
            aHW();
            this.dTB.setVisibility(8);
            com.baidu.tieba.tbadkCore.data.s a = a(hVar, z, i);
            if (a != null) {
                String str2 = null;
                boolean z2 = false;
                if (hVar != null && hVar.aDO() != null && hVar.aDO().getAuthor() != null) {
                    str2 = hVar.aDO().getAuthor().getUserId();
                    if (hVar.getPage() != null) {
                        this.dVx = hVar.getPage().pB();
                        z2 = hVar.getPage().pE() == 1;
                    }
                }
                this.dVs = !hVar.aDO().ri() && b(a, hVar.aDO().getId(), str2, z2, z);
                if (z) {
                    this.dTU.setVisibility(8);
                } else if (!this.dVE) {
                    this.dTU.setVisibility(0);
                }
                this.dTB.setVisibility(0);
                if (hVar.aDO() != null && hVar.aDO().Rl != null) {
                    this.dTy = new com.baidu.tieba.pb.data.b(0);
                    this.dTy.dLv = this.dOg;
                    this.dTy.aDA();
                    if (this.dTy != null) {
                        com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(3);
                        bVar.dLz = this.dTy.dLz;
                        bVar.dLA = this.dTy.dLA;
                        bVar.aeK = TbadkCoreApplication.m9getInst().getSkinType();
                        bVar.dLv = this.dOg;
                        bVar.aDA();
                    }
                    this.dUf = true;
                    DealInfoData rt = hVar.aDO().rt();
                    String userId = hVar.aDO().getAuthor().getUserId();
                    boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
                    com.baidu.tieba.pb.data.b bVar2 = new com.baidu.tieba.pb.data.b(1);
                    bVar2.dLz = this.dTy.dLz;
                    bVar2.dLA = this.dTy.dLA;
                    bVar2.dLw = rt;
                    bVar2.aDA();
                    a(a, hVar.aDO().getId(), str2, z2, z);
                    a(rt, z3);
                    if (this.dTx != null) {
                        this.bou.removeHeaderView(this.dTx);
                    }
                    if (this.dTv != null) {
                        this.bou.removeHeaderView(this.dTv);
                    }
                    com.baidu.tieba.pb.data.b bVar3 = new com.baidu.tieba.pb.data.b(2);
                    bVar3.dLz = this.dTy.dLz;
                    bVar3.dLA = this.dTy.dLA;
                    bVar3.aIO = this.dTx;
                    bVar3.bou = this.bou;
                    bVar3.aDA();
                    this.bou.addHeaderView(this.dTv);
                    aHM();
                    if (this.dOg.aEC() != null) {
                        this.dOg.aEC().hW(true);
                    }
                }
                SparseArray sparseArray = (SparseArray) this.dTB.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.dTB.setTag(sparseArray);
                }
                sparseArray.put(u.g.tag_clip_board, a);
                sparseArray.put(u.g.tag_is_subpb, false);
                this.dTM.setText(com.baidu.tbadk.core.util.ba.y(a.getTime()));
                this.dTN.setText(String.format(this.dOg.getPageContext().getString(u.j.is_floor), Integer.valueOf(a.bcm())));
                hVar.aDO().rh();
                if (!this.dVE) {
                    this.dTD.setVisibility(0);
                }
                if (!hVar.aDO().rj() && this.dTD.getText() != null && this.dTD.getText().length() > 0) {
                    this.dTD.setVisibility(0);
                } else {
                    this.dTD.setVisibility(8);
                }
                k(hVar);
                ArrayList<com.baidu.tbadk.core.data.a> qQ = hVar.aDO().qQ();
                if (qQ != null && qQ.size() > 0 && !this.dVE) {
                    this.dVc.setText(String.valueOf(qQ.get(0).op()));
                    this.dVb.setVisibility(0);
                    this.dVM = true;
                } else {
                    this.dVb.setVisibility(8);
                }
                com.baidu.tbadk.core.util.av.k(this.dVb, u.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.av.c(this.dVc, u.d.cp_link_tip_d, 1);
                if (hVar != null && hVar.aDO() != null && hVar.aDO().getAuthor() != null) {
                    String userId2 = hVar.aDO().getAuthor().getUserId();
                    if (userId2 != null && !userId2.equals("0") && userId2.equals(a.getAuthor().getUserId())) {
                        this.dTL.setVisibility(0);
                        this.dTL.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    } else {
                        this.dTL.setVisibility(8);
                    }
                }
                if (a.getAuthor() != null) {
                    int level_id = a.getAuthor().getLevel_id();
                    int is_bawu = a.getAuthor().getIs_bawu();
                    String bawu_type = a.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        this.dTG.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(this.dTG, BitmapHelper.getGradeResourceIdNew(level_id));
                        this.dTG.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        this.dTG.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id)));
                        this.dTG.setOnClickListener(null);
                    } else {
                        this.dTG.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.dTI.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(this.dTI, u.f.pb_manager);
                            this.dTG.setVisibility(8);
                            this.dTI.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(this.dTI, u.f.pb_assist);
                            this.dTG.setVisibility(8);
                            this.dTI.setVisibility(0);
                        }
                    }
                    this.dTH.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    if (a.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(this.dTH, u.f.icon_pb_pop_girl);
                        this.dTH.setVisibility(0);
                    } else if (a.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(this.dTH, u.f.icon_pb_pop_boy);
                        this.dTH.setVisibility(0);
                    } else {
                        this.dTH.setVisibility(8);
                    }
                    String string = a.getAuthor().getName_show() == null ? StringUtils.string(a.getAuthor().getUserName()) : StringUtils.string(a.getAuthor().getName_show());
                    if (!StringUtils.isNull(string)) {
                        int aP = com.baidu.adp.lib.util.j.aP(a.getAuthor().getName_show());
                        if (aP > 14) {
                            i2 = 0;
                        } else if (aP >= 12) {
                            i2 = 1;
                        } else if (aP >= 10) {
                            i2 = 2;
                            if (is_bawu == 0) {
                                i2 = 1;
                            }
                        }
                    }
                    ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = a.getAuthor().getTShowInfoNew();
                    if (this.dTJ != null) {
                        this.dTJ.setTag(u.g.tag_user_id, a.getAuthor().getUserId());
                        this.dTJ.setOnClickListener(this.dOg.dOP.bHY);
                        this.dTJ.vy();
                        this.dTJ.a(iconInfo, i2, this.dOg.getResources().getDimensionPixelSize(u.e.ds30), this.dOg.getResources().getDimensionPixelSize(u.e.ds30), this.dOg.getResources().getDimensionPixelSize(u.e.ds10));
                    }
                    if (this.dTK != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.dTK.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.dTK.setOnClickListener(this.dOg.dOP.dWh);
                        this.dTK.a(tShowInfoNew, 3, this.dOg.getResources().getDimensionPixelSize(u.e.ds32), this.dOg.getResources().getDimensionPixelSize(u.e.ds32), this.dOg.getResources().getDimensionPixelSize(u.e.ds8), true);
                    }
                    if (com.baidu.adp.lib.util.j.aP(string) > 14) {
                        this.dTE.setText(com.baidu.tbadk.core.util.ba.d(a.getAuthor().getName_show(), 14, "..."));
                    } else {
                        this.dTE.setText(a.getAuthor().getName_show());
                    }
                    this.dTE.setTag(u.g.tag_user_id, a.getAuthor().getUserId());
                    this.dTE.setTag(u.g.tag_user_name, a.getAuthor().getName_show());
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.av.c(this.dTE, u.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(this.dTE, u.d.cp_cont_f, 1);
                    }
                    this.dTF.setUserId(a.getAuthor().getUserId());
                    this.dTF.setUserName(a.getAuthor().getUserName());
                    this.dTF.setImageDrawable(null);
                    this.dTF.setRadius(com.baidu.adp.lib.util.k.c(this.dOg.getActivity(), u.e.ds35));
                    this.dTF.setTag(a.getAuthor().getUserId());
                    if (!PbNormalLikeButtonSwitchStatic.Fq() || this.dUK || this.dVs || (a.getAuthor().hadConcerned() && a.getAuthor().getGodUserData() != null && a.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.dTX.setVisibility(8);
                    } else {
                        this.dTX.setVisibility(0);
                        this.dTX.setMode(2);
                        this.dTX.setData(a.getAuthor());
                    }
                    if (this.dVs) {
                        fh fhVar = new fh(this, a);
                        this.dTE.setOnClickListener(fhVar);
                        this.dTF.setOnClickListener(fhVar);
                        this.dTF.setVisibility(8);
                        this.dTM.setVisibility(8);
                        this.dTN.setVisibility(8);
                        this.dTH.setVisibility(8);
                    } else {
                        if (!this.dNc) {
                            this.dTF.setVisibility(8);
                        } else {
                            this.dTF.setVisibility(0);
                        }
                        this.dTE.setOnClickListener(this.dOg.dOP.dWg);
                        this.dTF.setOnClickListener(this.dOg.dOP.dWg);
                        this.dTH.setVisibility(0);
                    }
                    this.dTF.c(a.getAuthor().getPortrait(), 28, false);
                }
                aHv();
                if (hVar != null) {
                    this.dTz.q(hVar.aDO());
                }
            }
        }
    }

    private void aHv() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTO.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, this.dVM ? com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds20) : 0, layoutParams.rightMargin, this.dVN ? com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst(), u.e.ds20) : 0);
        this.dTO.setLayoutParams(layoutParams);
    }

    public boolean aHw() {
        return this.dVO;
    }

    private boolean aHx() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean g(com.baidu.tbadk.core.data.az azVar) {
        if (azVar == null || azVar.getAuthor() == null || azVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), azVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.g gVar) {
        if (gVar != null) {
            this.dTq.aIg();
            if (!StringUtils.isNull(gVar.forumName)) {
                this.dTq.lS(gVar.forumName);
            }
            String string = this.dOg.getResources().getString(u.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.h.b.g(gVar.source, 0)) {
                case 100:
                    str = this.dOg.getResources().getString(u.j.self);
                    break;
                case 300:
                    str = this.dOg.getResources().getString(u.j.bawu);
                    break;
                case 400:
                    str = this.dOg.getResources().getString(u.j.system);
                    break;
            }
            this.dOg.showNetRefreshView(this.dHM, String.format(string, str), null, this.dOg.getResources().getString(u.j.appeal_restore), true, new fi(this, gVar.dLL));
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aGN;
        Parcelable aGN2;
        String sb;
        if (hVar != null) {
            if (hVar.aDO() != null) {
                this.dVf = hVar.aDO().qE();
                this.Rb = hVar.aDO().qB();
                if (hVar.aDO().getAnchorLevel() != 0) {
                    this.dVO = true;
                }
                this.dUK = g(hVar.aDO());
            }
            if (hVar.getUserData() != null) {
                this.userId = hVar.getUserData().getUserId();
            }
            n(hVar);
            this.dVa = false;
            this.dNd = z;
            aHq();
            b(hVar, z, i);
            if (this.dOg.aEV()) {
                if (this.dUl == null) {
                    this.dUl = new com.baidu.tieba.pb.view.w(this.dOg.getPageContext());
                    this.dUl.jq();
                    this.dUl.a(this.acD);
                }
                this.bou.setPullRefresh(this.dUl);
                this.bou.removeHeaderView(this.amM);
                this.bou.f(this.amM, 0);
                if (this.dUl != null) {
                    this.dUl.cT(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (hVar.getPage().pF() == 0 && z) {
                this.bou.setPullRefresh(null);
                this.dTo = 0;
                this.dUW.setVisibility(8);
            } else {
                if (this.dUl == null) {
                    this.dUl = new com.baidu.tieba.pb.view.w(this.dOg.getPageContext());
                    this.dUl.jq();
                    this.dUl.a(this.acD);
                }
                this.bou.setPullRefresh(this.dUl);
                this.bou.removeHeaderView(this.amM);
                this.bou.f(this.amM, 0);
                this.dTo = 1;
                if (this.dUl != null) {
                    this.dUl.cT(TbadkCoreApplication.m9getInst().getSkinType());
                }
                this.dUW.setVisibility(0);
                aHL();
            }
            aHy();
            boolean z3 = this.dUW.getVisibility() == 0;
            this.dUh.hi(this.dNd);
            this.dUh.hj(z3);
            this.dUh.b(hVar);
            this.dUh.notifyDataSetChanged();
            if (hVar.aDN() != null) {
                this.mForumName = hVar.aDN().getName();
                this.mForumId = hVar.getForumId();
            }
            this.dTq.lS(this.mForumName);
            if (hVar.aDO() != null) {
                nB(com.baidu.tbadk.core.util.ba.D(hVar.aDO().getReply_num()));
                if (hVar.aDO().getPraise() != null) {
                    if (hVar.aDO().getPraise().getNum() < 1) {
                        sb = this.dOg.getResources().getString(u.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(hVar.aDO().getPraise().getNum())).toString();
                    }
                    if (this.dTn != -1) {
                        hVar.aDO().getPraise().setIsLike(this.dTn);
                    }
                    I(sb, hVar.aDO().getPraise().getIsLike() == 1);
                }
            }
            if (hVar.getPage().pE() == 0 && !z) {
                this.bou.setNextPage(null);
                this.dTp = 1;
            } else if (this.dOg.isLogin()) {
                this.bou.setNextPage(this.dUm);
                this.dTp = 2;
                aHL();
            } else if (hVar.getPage().pE() == 1) {
                this.dVa = true;
                if (this.dUn == null) {
                    this.dUn = new com.baidu.tieba.pb.view.d(this.dOg.getPageContext());
                }
                this.bou.setNextPage(this.dUn);
                this.dTp = 3;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = hVar.aDP();
            if (hVar.getPage().pE() == 0 || aDP == null || aDP.size() < hVar.getPage().pD()) {
                this.dUm.setText(this.dOg.getResources().getString(u.j.list_no_more));
                if (this.dOg.aEV() && this.bou != null && this.bou.getData() != null && this.bou.getData().size() == 1 && (this.bou.getData().get(0) instanceof com.baidu.tieba.pb.data.l)) {
                    this.dUm.setText("");
                }
                m(hVar);
            } else if (z2) {
                if (this.dVL) {
                    vi();
                    if (hVar.getPage().pE() != 0) {
                        this.dUm.setText(this.dOg.getResources().getString(u.j.pb_load_more));
                    }
                } else {
                    this.dUm.vj();
                }
            } else {
                this.dUm.vj();
            }
            if (z) {
                this.dUX.setVisibility(0);
                this.aIa.setVisibility(0);
                this.dUY.setText(this.dOg.getResources().getString(u.j.btn_show_passed_pb));
            } else {
                this.dUX.setVisibility(8);
                this.aIa.setVisibility(8);
                this.dUY.setText(this.dOg.getResources().getString(u.j.btn_show_passed_pb_aftre));
            }
            if (hVar.aDO() != null && hVar.aDO().getAuthor() != null && hVar.aDO().getAuthor().getType() == 0) {
                this.dTq.aId();
            }
            switch (i) {
                case 2:
                    this.bou.setSelection(i2 > 1 ? i2 - 2 : 0);
                    if (this.dTw != null) {
                        CompatibleUtile.scrollListViewBy(this.bou, -this.dTw.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (aGN2 = el.aGM().aGN()) != null) {
                        this.bou.onRestoreInstanceState(aGN2);
                        break;
                    } else {
                        this.bou.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.dVL = false;
                    this.bou.setSelection(0);
                    break;
                case 5:
                    this.bou.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aGN = el.aGM().aGN()) != null) {
                        this.bou.onRestoreInstanceState(aGN);
                        break;
                    } else {
                        this.bou.setSelection(0);
                        break;
                    }
            }
            if (this.dVf == dVh && aHx()) {
                aHQ();
            }
        }
    }

    public void hQ(boolean z) {
        this.dUJ = z;
        this.dTq.hQ(z);
    }

    public void vi() {
        if (this.dUm != null) {
            this.dUm.vi();
        }
        aHL();
    }

    public void Mc() {
        this.bou.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHy() {
        boolean z;
        boolean z2 = true;
        if (this.dTw != null && this.dTw.getVisibility() == 0) {
            if (this.dUb != null) {
                this.dUb.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.dUb != null) {
                this.dUb.setVisibility(8);
            }
            z = false;
        }
        if (this.dUM != null && this.dUM.getVisibility() == 0) {
            if (this.dUc != null) {
                this.dUc.setVisibility(0);
            }
        } else {
            if (this.dUc != null) {
                this.dUc.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.dUe == null || this.dUe.getVisibility() == 8) && z2 && this.dNd) {
            this.dUd.setVisibility(0);
        } else {
            this.dUd.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.an(this.dUd);
        return z2;
    }

    private boolean l(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null || hVar.aDO() == null) {
            return false;
        }
        if (hVar.aDO().qH() == 1 || hVar.aDO().getThreadType() == 33) {
            return true;
        }
        return !(hVar.aDO().qI() == null || hVar.aDO().qI().rG() == 0) || hVar.aDO().getIs_top() == 1 || hVar.aDO().getIs_good() == 1 || hVar.aDO().re() || hVar.aDO().rp() || hVar.aDO().ri() || hVar.aDO().qR() != null || !com.baidu.tbadk.core.util.ba.isEmpty(hVar.aDO().qG());
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2) {
        if (hVar == null) {
            return false;
        }
        if (this.dTD != null) {
            if (hVar.aDO().qU() == 0 && !hVar.aDO().rj() && !this.dVE) {
                this.dTD.setVisibility(0);
                hVar.aDO().rh();
                if (l(hVar)) {
                    ArrayList arrayList = new ArrayList();
                    if (hVar.aDO().qH() == 1 || hVar.aDO().getThreadType() == 33 || (hVar.aDO().qI() != null && hVar.aDO().qI().rG() != 0)) {
                        if (hVar.aDO().qy() != null && hVar.aDO().rp()) {
                            if (hVar.aDO().rb() == 2) {
                                arrayList.add(new at.a(u.j.interview_live));
                            }
                        } else {
                            arrayList.add(new at.a(u.j.kn_zhibo));
                        }
                    }
                    if (hVar.aDO().getIs_top() == 1) {
                        arrayList.add(new at.a(u.j.commit_top));
                    }
                    if (hVar.aDO().getIs_good() == 1) {
                        arrayList.add(new at.a(u.j.good));
                    }
                    if (hVar.aDO().rp()) {
                        arrayList.add(dVp.get(hVar.aDO().rb()));
                    }
                    if (hVar.aDO().re()) {
                        Integer num = QP.get(new Point(hVar.aDO().rd(), hVar.aDO().rc()));
                        if (num != null) {
                            arrayList.add(new at.a(num.intValue(), u.d.cp_other_b, u.f.pic_dot_title_red));
                        } else {
                            arrayList.add(new at.a(u.j.card_promotion_text));
                        }
                    }
                    if (hVar.aDO().ri()) {
                        arrayList.add(new at.a(u.j.vote));
                    }
                    if (hVar.aDO().qR() != null) {
                        arrayList.add(new at.a(u.j.card_promotion_text, u.d.cp_other_b, u.f.pic_dot_title_red));
                    }
                    if (!com.baidu.tbadk.core.util.ba.isEmpty(hVar.aDO().qG())) {
                        arrayList.add(new at.a(hVar.aDO().qG()));
                    }
                    this.dTD.setText(com.baidu.tieba.card.at.a(this.dOg.getPageContext().getPageActivity(), hVar.aDO().getTitle(), arrayList));
                } else {
                    this.dTD.setText(hVar.aDO().getSpan_str());
                }
            } else {
                this.dTD.setVisibility(8);
                this.dVM = true;
                aHv();
            }
        }
        this.dNd = z;
        com.baidu.tbadk.core.data.az aDO = hVar.aDO();
        if (aDO != null) {
            a(aDO.qI());
        }
        if (hVar.aDU() != 1 || r(aDO)) {
            return false;
        }
        aHz();
        Button button = (Button) this.dTv.findViewById(u.g.pb_head_function_manage_commit_top);
        Button button2 = (Button) this.dTv.findViewById(u.g.pb_head_function_manage_cancel_top);
        Button button3 = (Button) this.dTv.findViewById(u.g.pb_head_function_manage_commit_good);
        Button button4 = (Button) this.dTv.findViewById(u.g.pb_head_function_manage_cancel_good);
        button.setOnClickListener(this.bFi);
        button2.setOnClickListener(this.bFi);
        button3.setOnClickListener(this.bFi);
        button4.setOnClickListener(this.bFi);
        if (hVar.aDO().getIs_good() == 1) {
            button3.setVisibility(8);
            button4.setVisibility(0);
        } else {
            button3.setVisibility(0);
            button4.setVisibility(8);
        }
        if (hVar.aDO().getIs_top() == 1) {
            button.setVisibility(8);
            button2.setVisibility(0);
        } else {
            button.setVisibility(0);
            button2.setVisibility(8);
        }
        if (hVar.aDO().rp() && hVar.aDO().rb() == 2) {
            button.setEnabled(false);
            com.baidu.tbadk.core.util.av.j((View) button, u.d.cp_cont_d);
        }
        return true;
    }

    private boolean r(com.baidu.tbadk.core.data.az azVar) {
        if (azVar == null) {
            return false;
        }
        return azVar.isDeal && azVar.Rl != null;
    }

    private void aHz() {
        if (this.dTw == null) {
            this.dTw = ((ViewStub) this.dTv.findViewById(u.g.pb_header_function_manage)).inflate();
            this.dOg.getLayoutMode().w(this.dTw);
            this.dUb = this.dTv.findViewById(u.g.new_pb_header_item_line_above_manage);
            return;
        }
        this.dTw.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (hVar != null) {
            a(hVar, z, z2);
            com.baidu.tieba.tbadkCore.data.s a = a(hVar, z, i);
            if (a != null) {
                if (hVar.aDU() != 0 && a.getAuthor() != null && !r(hVar.aDO())) {
                    String userId2 = a.getAuthor().getUserId();
                    boolean z6 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else {
                        z4 = true;
                        z5 = z6;
                        z3 = false;
                    }
                } else {
                    String userId3 = hVar.aDO().getAuthor().getUserId();
                    if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else if (a.getAuthor() == null || (userId = a.getAuthor().getUserId()) == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = false;
                        z5 = false;
                    } else {
                        z3 = true;
                        z4 = true;
                        z5 = false;
                    }
                }
                if (z4 && z5) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    if (a.getAuthor() != null) {
                        sparseArray.put(u.g.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(u.g.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(u.g.tag_del_post_id, a.getId());
                    sparseArray.put(u.g.tag_del_post_type, 0);
                    sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(hVar.aDU()));
                    sparseArray.put(u.g.tag_should_manage_visible, true);
                    a(u.j.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(u.g.tag_del_post_id, a.getId());
                    sparseArray2.put(u.g.tag_del_post_type, 0);
                    sparseArray2.put(u.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(u.g.tag_manage_user_identity, Integer.valueOf(hVar.aDU()));
                    sparseArray2.put(u.g.tag_should_manage_visible, false);
                    a(u.j.delete, sparseArray2);
                }
            }
            aHy();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        aHz();
        Button button = (Button) this.dTv.findViewById(u.g.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.bFi);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.axc;
    }

    public void nC(String str) {
        if (this.dUm != null && !StringUtils.isNull(str)) {
            this.dUm.setText(str);
        }
    }

    public BdListView LO() {
        return this.bou;
    }

    public int aHA() {
        return u.g.richText;
    }

    public int Ws() {
        return u.g.user_icon_box;
    }

    public Button aHB() {
        return (Button) this.dTv.findViewById(u.g.pb_head_function_manage_commit_good);
    }

    public Button aHC() {
        return (Button) this.dTv.findViewById(u.g.pb_head_function_manage_cancel_good);
    }

    public Button aHD() {
        return (Button) this.dTv.findViewById(u.g.pb_head_function_manage_commit_top);
    }

    public Button aHE() {
        return (Button) this.dTv.findViewById(u.g.pb_head_function_manage_cancel_top);
    }

    public TextView aEy() {
        return this.dTz.aEy();
    }

    public void c(BdListView.e eVar) {
        this.bou.setOnSrollToBottomListener(eVar);
    }

    public void a(t.b bVar) {
        this.acD = bVar;
        if (this.dUl != null) {
            this.dUl.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.af afVar, a.b bVar) {
        if (afVar != null) {
            int pC = afVar.pC();
            int pz = afVar.pz();
            if (this.dUi != null) {
                this.dUi.rT();
            } else {
                this.dUi = new com.baidu.tbadk.core.dialog.a(this.dOg.getPageContext().getPageActivity());
                this.dUj = LayoutInflater.from(this.dOg.getPageContext().getPageActivity()).inflate(u.h.dialog_direct_pager, (ViewGroup) null);
                this.dUi.y(this.dUj);
                this.dUi.a(u.j.dialog_ok, bVar);
                this.dUi.b(u.j.dialog_cancel, new fj(this));
                this.dUi.a(new fk(this));
                this.dUi.b(this.dOg.getPageContext()).rT();
            }
            this.dUk = (EditText) this.dUj.findViewById(u.g.input_page_number);
            this.dUk.setText("");
            TextView textView = (TextView) this.dUj.findViewById(u.g.current_page_number);
            if (pC <= 0) {
                pC = 1;
            }
            if (pz <= 0) {
                pz = 1;
            }
            textView.setText(MessageFormat.format(this.dOg.getApplicationContext().getResources().getString(u.j.current_page), Integer.valueOf(pC), Integer.valueOf(pz)));
            this.dOg.ShowSoftKeyPadDelay(this.dUk, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bou.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.dOg.showToast(str);
    }

    public boolean hR(boolean z) {
        if (this.BW == null || !this.BW.Bo()) {
            return false;
        }
        this.BW.zD();
        return true;
    }

    public void aHF() {
        if (this.dVP != null) {
            while (this.dVP.size() > 0) {
                TbImageView remove = this.dVP.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aHF();
        if (this.dUh.aFr() != null) {
            this.dUh.aFr().pause();
        }
    }

    public void onResume() {
        if (this.dUh.aFr() != null) {
            this.dUh.aFr().resume();
        }
    }

    public void onDestroy() {
        this.dOg.hideProgressBar();
        if (this.bkT != null && this.bAH != null) {
            this.bkT.b(this.bAH);
        }
        avf();
        this.dUm.vi();
        if (this.dVn != null) {
            com.baidu.adp.lib.h.h.dM().removeCallbacks(this.dVn);
        }
        if (this.dVo != null) {
            com.baidu.adp.lib.h.h.dM().removeCallbacks(this.dVo);
        }
        aHN();
        if (this.dVD != null) {
            this.dVD.removeAllViews();
        }
        if (this.dTB != null && this.dSp != null) {
            this.dTB.removeView(this.dSp);
            this.dSp = null;
        }
        if (this.dVe != null) {
            this.dVe.clearStatus();
        }
        this.dVG = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dUh.aFr() != null) {
            this.dUh.aFr().release();
        }
        if (this.bFz != null) {
            this.bFz.setBackgroundDrawable(null);
        }
    }

    public void avf() {
        this.dTq.nq();
        com.baidu.adp.lib.util.k.a(this.dOg.getPageContext().getPageActivity(), this.dUk);
        if (this.dUI != null) {
            this.dUI.dismiss();
        }
        aHG();
    }

    public void hg(boolean z) {
        this.dUh.hg(z);
    }

    public void hh(boolean z) {
        this.dNc = z;
        this.dUh.hh(z);
    }

    public void gb(boolean z) {
        this.diC = z;
    }

    public void aHG() {
        if (this.dUr != null) {
            this.dUr.dismiss();
        }
        if (this.dUs != null) {
            com.baidu.adp.lib.h.j.b(this.dUs, this.dOg.getPageContext());
        }
        if (this.dUB != null) {
            com.baidu.adp.lib.h.j.b(this.dUB, this.dOg.getPageContext());
        }
        if (this.dUp != null) {
            com.baidu.adp.lib.h.j.b(this.dUp, this.dOg.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.dOg.getLayoutMode().ad(i == 1);
        this.dOg.getLayoutMode().w(this.dHM);
        this.dOg.getLayoutMode().w(this.dTx);
        this.dOg.getLayoutMode().w(this.dTv);
        if (this.dTy != null) {
            com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(3);
            bVar.dLz = this.dTy.dLz;
            bVar.dLA = this.dTy.dLA;
            bVar.aeK = i;
            bVar.dLv = this.dOg;
            bVar.aDA();
        }
        this.dOg.getLayoutMode().w(this.axc);
        com.baidu.tbadk.core.util.av.c(this.dTQ, u.d.cp_cont_g, 1);
        this.dTq.mNavigationBar.onChangeSkinType(this.dOg.getPageContext(), i);
        com.baidu.tbadk.core.util.av.a(this.dTq.dWu, u.f.btn_more_selector_s, u.f.btn_more_selector);
        com.baidu.tbadk.core.util.av.a(this.dTq.dWv, u.f.icon_floor_addition_selector_s, u.f.icon_floor_addition_selector);
        if (this.dUj != null) {
            this.dOg.getLayoutMode().w(this.dUj);
        }
        hQ(this.dUJ);
        this.dUh.notifyDataSetChanged();
        if (this.dUl != null) {
            this.dUl.cT(i);
        }
        if (this.dUm != null) {
            this.dUm.cT(i);
            com.baidu.tbadk.core.util.av.k(this.axc, u.f.pb_foot_more_trans_selector);
            this.dUm.cR(u.f.pb_foot_more_trans_selector);
        }
        if (this.BW != null) {
            this.BW.onChangeSkinType(i);
        }
        if (this.dTV != null) {
            this.dTV.cX(i);
        }
        if (this.dUn != null) {
            this.dUn.cT(i);
        }
        if (this.dTu != null && this.dTu.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.dTu) {
                aVar.aIb();
            }
        }
        if (this.dVD != null) {
            com.baidu.tbadk.core.util.av.l(this.dVD, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(this.dVz, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.dVC, u.d.cp_cont_c, 1);
        }
        hJ(i == 1);
        this.dTA.changeSkinType(i);
        aGY();
        UtilHelper.setStatusBarBackground(this.bFz, i);
        if (this.dTX != null) {
            this.dTX.aG(true);
        }
        if (this.dTY != null) {
            com.baidu.tbadk.j.a.a(this.dOg.getPageContext(), this.dTY);
        }
        com.baidu.tbadk.core.util.av.b(this.dTq.dWs, u.d.cp_cont_b, u.d.s_navbar_title_color);
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFF = dVar;
        this.dUh.setOnImageClickListener(this.aFF);
    }

    public void g(NoNetworkView.a aVar) {
        this.bAH = aVar;
        if (this.bkT != null) {
            this.bkT.a(this.bAH);
        }
    }

    public void hS(boolean z) {
        this.dUh.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aHH() {
        return this.dUM;
    }

    public void m(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = hVar.aDP();
            if (aDP.size() == 1) {
                com.baidu.tieba.tbadkCore.data.s sVar = aDP.get(0);
                if (sVar.bcs() < sVar.bcl().size()) {
                    if (this.dTp != 1) {
                        this.bou.setNextPage(null);
                        this.dTp = 1;
                    }
                } else if (this.dTp != 2) {
                    this.bou.setNextPage(this.dUm);
                    this.dTp = 2;
                }
            } else if (this.dTp != 2) {
                this.bou.setNextPage(this.dUm);
                this.dTp = 2;
            }
        }
    }

    public void aHI() {
        if (com.baidu.tbadk.performanceLog.aa.EW().EX()) {
            int lastVisiblePosition = this.bou.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bou.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(u.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.eQ(1001);
                                perfLog.ayl = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.uS();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(u.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.eQ(1001);
                        perfLog2.ayl = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.uS();
                    }
                }
            }
        }
    }

    public void gc(boolean z) {
        if (this.dUN != null && this.dUN != null) {
            if (this.diC && !aHZ()) {
                gd(z);
            } else {
                ge(z);
            }
        }
    }

    public void aHJ() {
        if (this.dUN != null) {
            this.dUN.setVisibility(8);
        }
    }

    public TextView aHK() {
        return this.dUX;
    }

    public void asK() {
        if (this.dUZ == null) {
            this.dUZ = new com.baidu.tbadk.core.view.b(this.dOg.getPageContext());
        }
        this.dUZ.aB(true);
    }

    public void aHL() {
        if (this.dUZ != null) {
            this.dUZ.aB(false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.s sVar, String str, String str2, boolean z, boolean z2) {
        this.dTM.setVisibility(8);
        this.dTF.setIsRound(true);
        if (this.dTq != null) {
            this.dTq.mNavigationBar.setBackgroundResource(0);
            ((ViewGroup.MarginLayoutParams) this.dTq.dWs.getLayoutParams()).leftMargin = this.dOg.getResources().getDimensionPixelOffset(u.e.ds6);
            this.bou.removeHeaderView(this.amM);
        }
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.s sVar, String str, String str2, boolean z, boolean z2) {
        ColumnLayout.a aVar;
        if (sVar == null || sVar.getAuthor() == null || sVar.getAuthor().getGodUserData() == null) {
            return false;
        }
        GodUserData godUserData = sVar.getAuthor().getGodUserData();
        if (2 != godUserData.getType()) {
            return false;
        }
        MetaData author = sVar.getAuthor();
        long userIdLong = sVar.getAuthor().getUserIdLong();
        String userName = sVar.getAuthor().getUserName();
        int fansNum = sVar.getAuthor().getFansNum();
        sVar.getId();
        String portrait = sVar.getAuthor().getPortrait();
        fm fmVar = new fm(this, str, new com.baidu.tbadk.coreExtra.d.a(null), author);
        this.dTB.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds32), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds20), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds32), 0);
        if (sVar.getType() == null || sVar.getType().getId() != com.baidu.tieba.tbadkCore.data.s.Qh.getId()) {
            this.dTv.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds34), 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds76);
        if (this.dTF.getLayoutParams() == null) {
            aVar = new ColumnLayout.a(dimensionPixelSize, dimensionPixelSize);
        } else {
            ColumnLayout.a aVar2 = (ColumnLayout.a) this.dTF.getLayoutParams();
            aVar2.width = dimensionPixelSize;
            aVar2.height = dimensionPixelSize;
            aVar = aVar2;
        }
        this.dTF.setLayoutParams(aVar);
        this.dTF.setVisibility(8);
        View findViewWithTag = this.dTB.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.dSp = new ClickableHeaderImageView(this.dOg.getApplicationContext());
            this.dSp.setGodIconMargin(0);
            this.dSp.setTag("pb_god_head_image_view_tag");
            this.dSp.setUserId(String.valueOf(userIdLong));
            this.dSp.setUserName(userName);
            this.dTB.addView(this.dSp, 0, aVar);
        } else {
            this.dSp = (ClickableHeaderImageView) findViewWithTag;
        }
        fn fnVar = new fn(this, sVar);
        this.dTB.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
        this.dTB.setTag(u.g.tag_user_name, userName);
        this.dTB.setOnClickListener(fnVar);
        this.dTx.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
        this.dTx.setTag(u.g.tag_user_name, userName);
        this.dTx.setOnClickListener(fnVar);
        if (this.dNc) {
            this.dSp.setVisibility(0);
            this.dSp.setOnClickListener(fnVar);
            this.dSp.c(portrait, 28, false);
        } else {
            this.dSp.setVisibility(8);
        }
        if (this.dTR == null) {
            this.dTR = new TextView(this.dOg.getActivity());
            this.dTR.setClickable(false);
            this.dTR.setIncludeFontPadding(false);
            this.dTR.setGravity(16);
            this.dTR.setTextSize(0, this.dOg.getResources().getDimensionPixelSize(u.e.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds8);
            aVar3.bottomMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds10);
            this.dTR.setSingleLine(true);
            com.baidu.tbadk.core.util.av.c(this.dTR, u.d.cp_cont_d, 1);
            this.dTB.addView(this.dTR, -1, aVar3);
        }
        String format = String.format(this.dOg.getResources().getString(u.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.B(fansNum));
        this.dTR.setText(format);
        this.dTR.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
        this.dTR.setTag(u.g.tag_user_name, userName);
        this.dTR.setOnClickListener(fnVar);
        if (this.dTS == null) {
            this.dTS = new TextView(this.dOg.getActivity());
            this.dTS.setClickable(false);
            this.dTS.setTextSize(0, this.dOg.getResources().getDimensionPixelSize(u.e.fontsize24));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.dTS.setSingleLine(true);
            this.dTS.setPadding(this.dOg.getResources().getDimensionPixelSize(u.e.ds32), 0, this.dOg.getResources().getDimensionPixelSize(u.e.ds128), 0);
            this.dTS.setEllipsize(TextUtils.TruncateAt.END);
            this.dTS.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
            this.dTS.setTag(u.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.av.c(this.dTS, u.d.cp_cont_d, 1);
            this.dTx.addView(this.dTS, layoutParams);
        }
        String string = this.dOg.getResources().getString(u.j.tieba_certification);
        String format2 = StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.dOg.getResources().getString(u.j.god_intro_default)) : String.format(string, godUserData.getIntro());
        this.dTS.setOnClickListener(fnVar);
        this.dTS.setText(format2);
        this.dTM.setVisibility(8);
        if (this.dTT == null) {
            this.dTT = new TextView(this.dOg.getActivity());
            this.dTT.setTextSize(0, this.dOg.getResources().getDimensionPixelSize(u.e.fontsize24));
            this.dTT.setGravity(17);
            this.dTT.setOnClickListener(fmVar);
            ColumnLayout.a aVar4 = new ColumnLayout.a(this.dOg.getResources().getDimensionPixelSize(u.e.ds110), this.dOg.getResources().getDimensionPixelSize(u.e.ds50), 80, 3);
            aVar4.bottomMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds22);
            this.dTB.addView(this.dTT, -1, aVar4);
        }
        b(this.dTT, godUserData.getFollowed() == 1);
        if (this.dUK || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            this.dTT.setVisibility(8);
        } else {
            this.dTT.setVisibility(0);
        }
        if (this.dTx.findViewWithTag("pb_god_bottom_line_view_tag") == null) {
            View view = new View(this.dOg.getApplicationContext());
            view.setTag("pb_god_bottom_line_view_tag");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.dOg.getResources().getDimensionPixelSize(u.e.ds1));
            layoutParams2.topMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds18);
            layoutParams2.bottomMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds1);
            com.baidu.tbadk.core.util.av.l(view, u.d.cp_bg_line_a);
            this.dTx.addView(view, layoutParams2);
        }
        if (this.dVw == null) {
            this.dVw = new TextView(this.dOg.getApplicationContext());
            this.dVw.setId(u.g.pb_god_user_tip_content);
            this.dVw.setEllipsize(TextUtils.TruncateAt.END);
            this.dVw.setGravity(17);
            this.dVw.setSingleLine(true);
            this.dVw.setHeight(this.dOg.getResources().getDimensionPixelSize(u.e.ds56));
            this.dVw.setTextSize(0, this.dOg.getResources().getDimensionPixelSize(u.e.fontsize24));
            this.dVw.setVisibility(8);
            if (aHT() != null) {
                aHT().addView(this.dVw);
            }
            this.dOg.getLayoutMode().w(this.dVw);
        }
        com.baidu.tbadk.core.util.av.k(this.dVw, u.d.common_color_10260);
        com.baidu.tbadk.core.util.av.j((View) this.dVw, u.d.cp_cont_g);
        this.dVw.setOnClickListener(new fp(this));
        this.dVw.setText(String.format(this.dOg.getResources().getString(u.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.ba.B(this.dVx)));
        nx(this.dVx);
        if (this.dVv == null) {
            this.dVv = (LinearLayout) LayoutInflater.from(this.dOg.getActivity()).inflate(u.h.god_floating_view, (ViewGroup) null);
            this.dVv.setOnClickListener(fnVar);
            this.dVv.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
            this.dVv.setTag(u.g.tag_user_name, userName);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.dVv.findViewById(u.g.god_floating_owner_photo);
            clickableHeaderImageView.setGodIconMargin(0);
            clickableHeaderImageView.setOnClickListener(fnVar);
            if (!this.dNc) {
                clickableHeaderImageView.setVisibility(8);
            }
            clickableHeaderImageView.setTag(sVar.getAuthor().getUserId());
            clickableHeaderImageView.c(sVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.dVv.findViewById(u.g.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(sVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.dVv.findViewById(u.g.god_floating_owner_info_user_rank);
            int level_id = sVar.getAuthor().getLevel_id();
            int is_bawu = sVar.getAuthor().getIs_bawu();
            String bawu_type = sVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.av.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id)));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.dVv.findViewById(u.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.av.c(imageView2, u.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.av.c(imageView2, u.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            if (!StringUtils.isNull(sVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aP(sVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = sVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.dVv.findViewById(u.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.dVv.findViewById(u.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.dOg.dOP.bHY);
                userIconBox.a(iconInfo, i, this.dOg.getResources().getDimensionPixelSize(u.e.ds30), this.dOg.getResources().getDimensionPixelSize(u.e.ds30), this.dOg.getResources().getDimensionPixelSize(u.e.ds10));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.dOg.dOP.dWh);
                userIconBox2.a(tShowInfoNew, 3, this.dOg.getResources().getDimensionPixelSize(u.e.ds32), this.dOg.getResources().getDimensionPixelSize(u.e.ds32), this.dOg.getResources().getDimensionPixelSize(u.e.ds8), true);
            }
            TextView textView = (TextView) this.dVv.findViewById(u.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_f, 1);
            }
            textView.setText(sVar.getAuthor().getName_show());
            if (aHT() != null) {
                aHT().addView(this.dVv);
            }
            this.dOg.getLayoutMode().w(this.dVv);
        }
        TextView textView2 = (TextView) this.dVv.findViewById(u.g.god_floating_gift);
        textView2.setOnClickListener(fmVar);
        b(textView2, godUserData.getFollowed() == 1);
        ImageView imageView3 = (ImageView) this.dVv.findViewById(u.g.god_floating_arrow);
        com.baidu.tbadk.core.util.av.c(imageView3, u.f.icon_arrow_tab);
        if (this.dUK || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            textView2.setVisibility(8);
            imageView3.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            imageView3.setVisibility(8);
        }
        TextView textView3 = (TextView) this.dVv.findViewById(u.g.god_floating_intro);
        if (textView3 != null) {
            textView3.setText(format);
        }
        this.dVD = this.dUm.ve();
        if (this.dVD != null && !this.dUK && !z && z2 && (godUserData.getFollowed() != 1 || !godUserData.getIsFromNetWork())) {
            this.dUm.vf();
            this.dUm.vb();
            this.dVz = this.dVD.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.dVz == null) {
                this.dVz = new View(this.dOg.getApplicationContext());
                this.dVz.setTag("pb_god_bottom_extra_line_view_tag");
                this.dVD.addView(this.dVz, new LinearLayout.LayoutParams(-1, this.dOg.getResources().getDimensionPixelSize(u.e.ds20)));
                this.dVB = new ClickableHeaderImageView(this.dOg.getApplicationContext());
                this.dVB.setGodIconMargin(0);
                this.dVB.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.dVB.c(portrait, 28, false);
                this.dVB.setUserId(String.valueOf(userIdLong));
                this.dVB.setUserName(userName);
                this.dVB.setOnClickListener(fnVar);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.dOg.getResources().getDimensionPixelSize(u.e.ds130), this.dOg.getResources().getDimensionPixelSize(u.e.ds130));
                layoutParams3.topMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds40);
                layoutParams3.gravity = 1;
                this.dVD.addView(this.dVB, layoutParams3);
                this.dVC = new TextView(this.dOg.getApplicationContext());
                this.dVC.setTag("pb_god_bottom_extra_text_view_tag");
                this.dVC.setSingleLine(true);
                this.dVC.setTextSize(0, this.dOg.getResources().getDimensionPixelSize(u.e.fontsize24));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.topMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds36);
                layoutParams4.gravity = 1;
                this.dVC.setText(this.dOg.getResources().getString(u.j.god_user_attention_tip));
                this.dVD.addView(this.dVC, layoutParams4);
                this.dVA = new TextView(this.dOg.getApplicationContext());
                this.dVA.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.dVA.setSingleLine(true);
                this.dVA.setGravity(17);
                this.dVA.setTextSize(0, this.dOg.getResources().getDimensionPixelSize(u.e.fontsize24));
                this.dVA.setOnClickListener(fmVar);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(this.dOg.getResources().getDimensionPixelSize(u.e.ds212), this.dOg.getResources().getDimensionPixelSize(u.e.ds54));
                layoutParams5.topMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds30);
                layoutParams5.bottomMargin = this.dOg.getResources().getDimensionPixelSize(u.e.ds40);
                layoutParams5.gravity = 1;
                this.dVD.addView(this.dVA, layoutParams5);
            } else {
                this.dVA = (TextView) this.dVD.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.dVB = (ClickableHeaderImageView) this.dVD.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.dVC = (TextView) this.dVD.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.dVz = this.dVD.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            com.baidu.tbadk.core.util.av.l(this.dVD, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(this.dVz, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.dVC, u.d.cp_cont_c, 1);
            this.dVD.setOnTouchListener(new fq(this));
            boolean z3 = godUserData.getFollowed() == 1;
            b(this.dVA, z3);
            if (!z3) {
                this.dVA.setPadding(this.dOg.getResources().getDimensionPixelSize(u.e.ds68), 0, this.dOg.getResources().getDimensionPixelSize(u.e.ds52), 0);
            }
        } else {
            this.dUm.vg();
            this.dUm.va();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dVs && !this.dVt && i > this.dTo) {
            this.dVu = true;
        } else {
            this.dVu = false;
            aHO();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL));
        aHM();
    }

    public void aHM() {
        float f = 1.0f;
        if (this.dTy != null && this.dTy.dLz != null && this.dUf) {
            int dimension = (int) this.dOg.getResources().getDimension(u.e.ds98);
            int dimension2 = ((int) this.dOg.getResources().getDimension(u.e.ds450)) - (-this.dTy.dLz.getTop());
            if (this.bou.getChildAt(0) == this.dTy.dLz && dimension2 >= dimension) {
                if (dimension2 < dimension || dimension2 > dimension * 2) {
                    f = dimension2 > dimension * 2 ? 0.0f : 0.0f;
                } else {
                    f = 1.0f - (((dimension2 - dimension) * 1.0f) / dimension);
                }
            }
            this.dTq.L(f);
        }
    }

    private void nx(int i) {
        boolean z;
        if (this.dVw != null && this.dVw.getVisibility() != 0 && i >= 2 && !this.dUK) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.dVy = true;
                this.dVw.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.dM().postDelayed(this.cqF, 3000L);
        }
    }

    public void aHN() {
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.cqF);
        if (this.dVw != null && 8 != this.dVw.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.dOg, this.dVw, u.a.fade_out, new fr(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aHO() {
        if (this.dVv != null) {
            this.dVv.clearAnimation();
            if (this.dVv.getVisibility() != 8) {
                this.dVv.setVisibility(8);
            }
        }
    }

    public void aHP() {
        if (this.dVs && this.dVu && this.dVv != null && this.dVv.getVisibility() != 0 && !this.dVy) {
            this.dVv.clearAnimation();
            this.dVv.setVisibility(0);
        }
    }

    public void aHQ() {
        if (!this.dVQ) {
            TiebaStatic.log("c10490");
            this.dVQ = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dOg.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(dVi, Integer.valueOf(dVk));
            aVar.bL(u.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.dOg.getPageContext().getPageActivity()).inflate(u.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(u.g.function_description_view)).setText(u.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(u.g.title_view)).setText(u.j.grade_thread_tips);
            aVar.y(inflate);
            aVar.x(sparseArray);
            aVar.a(u.j.grade_button_tips, this.dOg);
            aVar.b(u.j.look_again, new fs(this));
            aVar.b(this.dOg.getPageContext()).rT();
        }
    }

    public void aHR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dOg.getPageContext().getPageActivity());
        aVar.cz(this.dOg.getResources().getString(u.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(dVi, Integer.valueOf(dVm));
        aVar.x(sparseArray);
        aVar.a(u.j.upgrade_to_new, this.dOg);
        aVar.b(u.j.cancel, new ft(this));
        aVar.b(this.dOg.getPageContext()).rT();
    }

    public int qE() {
        return this.dVf;
    }

    public void nD(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dOg.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.dOg.getPageContext().getPageActivity()).inflate(u.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(u.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(u.g.function_description_view)).setVisibility(8);
        aVar.y(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(dVi, Integer.valueOf(dVl));
        aVar.x(sparseArray);
        aVar.a(u.j.view, this.dOg);
        aVar.b(u.j.cancel, new fu(this));
        aVar.b(this.dOg.getPageContext()).rT();
    }

    public void a(int i, com.baidu.tieba.pb.data.h hVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.s a;
        if (i > 0 && (a = a(hVar, z, i2)) != null && a.getAuthor() != null) {
            MetaData author = a.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void c(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        b(hVar, z, i);
    }

    private void b(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m9getInst().getString(u.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, u.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m9getInst().getString(u.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.av.k(textView, u.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds10), 0);
    }

    public PbInterviewStatusView aHS() {
        return this.dVe;
    }

    private void n(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aDO() != null && hVar.aDO().rp() && this.dVe == null) {
            this.dVe = (PbInterviewStatusView) this.dVd.inflate();
            this.dVe.setOnClickListener(this.bFi);
            this.dVe.setCallback(this.dOg.aFe());
            this.dVe.a(this.dOg, hVar);
        }
    }

    public LinearLayout aHT() {
        return this.dUg;
    }

    public View aHU() {
        return this.bFz;
    }

    public boolean aHV() {
        return this.dVE;
    }

    public void aFD() {
        this.dTA.aFD();
    }

    public void hm(boolean z) {
        this.dTz.hm(z);
    }

    private void aHW() {
        if (this.dVE) {
            if (this.dVF == null) {
                f.a aVar = f.dOi.get();
                if (aVar != null) {
                    this.dVF = aVar.a(this.dOg);
                    ListAdapter adapter = this.bou.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.amM) {
                            this.bou.f(this.dVF.aEw(), 1);
                        } else {
                            this.bou.f(this.dVF.aEw(), 0);
                        }
                    }
                } else {
                    this.dTx.setVisibility(0);
                    return;
                }
            }
            this.dTx.setVisibility(8);
            this.bou.removeHeaderView(this.dTx);
            return;
        }
        this.dTx.setVisibility(0);
    }

    public void hT(boolean z) {
        this.dVE = z;
    }

    public View aFH() {
        return this.dTA.aFH();
    }

    public void aHX() {
        this.dOg.showNetRefreshView(getView(), "");
        View Dh = this.dOg.getRefreshView().Dh();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Dh.getLayoutParams();
        layoutParams.addRule(3, aHT().getId());
        Dh.setLayoutParams(layoutParams);
        this.dOg.hideLoadingView(getView());
        if (this.dVF != null) {
            this.bou.removeHeaderView(this.dVF.aEw());
            this.dVF = null;
        }
    }

    public void nE(String str) {
        if (this.dTr != null) {
            this.dTr.setTitle(str);
        }
    }

    public void Bx() {
        this.dTA.Bx();
    }

    public void aEu() {
        if (this.dTD != null) {
            this.dTD.setTextSize(TbConfig.getContentSizeOfPostTitle());
        }
        if (this.dUh != null && this.dUh.aFo() != null) {
            this.dUh.aFo().aEu();
        }
        if (this.dUh != null) {
            if (this.dUh.aFp() != null) {
                this.dUh.aFp().updateFontSize();
            }
            if (this.dUh.aFq() != null) {
                this.dUh.aFq().updateFontSize();
            }
        }
    }

    private int hU(boolean z) {
        if (this.dVe == null || this.dVe.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.c(this.dOg.getPageContext().getPageActivity(), u.e.ds72);
    }

    private void aHY() {
        if (this.dVe != null && this.dVe.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVe.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.dVe.setLayoutParams(layoutParams);
        }
    }

    public boolean aHZ() {
        return this.dUf;
    }
}
