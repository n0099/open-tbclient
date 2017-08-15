package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
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
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.d;
import com.baidu.tieba.pb.pb.main.emotion.view.c;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class aq {
    public static int eRV = 2;
    public static int eRW = 3;
    public static int eRX = 0;
    public static int eRY = 3;
    public static int eRZ = 4;
    public static int eSa = 5;
    public static int eSb = 6;
    private com.baidu.tbadk.editortools.i Lt;
    private View aIS;
    private com.baidu.tieba.pb.a.c aRO;
    private int aRp;
    private k.b anN;
    private TextView ayG;
    private TextView bEu;
    private NoNetworkView bFB;
    private RelativeLayout bZc;
    private View cbp;
    private View.OnClickListener cll;
    private View.OnClickListener eHt;
    private PbActivity eIu;
    PbActivity.c eKh;
    private PbFakeFloorModel eMA;
    private com.baidu.tieba.pb.data.f eMX;
    private UserIconBox eMc;
    private UserIconBox eMd;
    public int ePV;
    private int ePW;
    private int ePX;
    private int ePY;
    private FrameLayout eQA;
    private HeadImageView eQB;
    private View eQC;
    private FloatingLayout eQD;
    private PbFirstFloorUserLikeButton eQI;
    private ao eQJ;
    private TextView eQK;
    private TextView eQL;
    private LinearLayout eQM;
    private TextView eQN;
    private TextView eQO;
    private View eQP;
    private View eQQ;
    private ObservedChangeLinearLayout eQS;
    private g eQT;
    private PbListView eQY;
    private com.baidu.tieba.pb.video.i eQa;
    private com.baidu.tieba.pb.video.h eQb;
    private com.baidu.tieba.d.b eQc;
    public final com.baidu.tieba.pb.pb.main.view.d eQf;
    public com.baidu.tieba.pb.pb.main.view.c eQg;
    private ViewStub eQh;
    private ViewStub eQi;
    private PbLandscapeListView eQj;
    private List<com.baidu.tieba.pb.pb.main.view.a> eQk;
    private View eQl;
    private LinearLayout eQp;
    private TextView eQq;
    private View eQr;
    private e eQs;
    private ColumnLayout eQt;
    private ThreadSkinView eQu;
    private TextView eQv;
    private TextView eQw;
    private TextView eQx;
    private ImageView eQy;
    private HeadPendantView eQz;
    private View eRB;
    private TextView eRC;
    private ViewGroup eRD;
    private TextView eRF;
    private boolean eRH;
    private int eRI;
    private int eRJ;
    private int eRK;
    private PostData eRL;
    private View eRN;
    private TextView eRO;
    private ViewStub eRP;
    private PbInterviewStatusView eRQ;
    private ViewGroup eRR;
    private TextView eRS;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eRT;
    private View eRa;
    private PbActivity.a eSA;
    private boolean eSC;
    private boolean eSD;
    private int eSH;
    private Runnable eSc;
    private Runnable eSd;
    private q eSe;
    private com.baidu.tieba.d.b eSf;
    private View eSp;
    private TextView eSq;
    private LinearLayout eSr;
    private boolean eSs;
    private d eSt;
    private com.baidu.tbadk.core.view.userLike.c eSu;
    private com.baidu.tbadk.core.view.userLike.c eSv;
    private Runnable eSy;
    private boolean isLandscape;
    private int mType;
    private int ePZ = 1;
    private boolean eQd = false;
    private int eQe = 0;
    private final Handler mHandler = new Handler();
    private View eQm = null;
    private LinearLayout eQn = null;
    private TextView eQo = null;
    private TextView eQE = null;
    private TextView eQF = null;
    public FrsPraiseView eQG = null;
    private ClickableHeaderImageView eQH = null;
    private View eQR = null;
    private com.baidu.tbadk.core.dialog.a eQU = null;
    private com.baidu.tbadk.core.dialog.b clk = null;
    private View eQV = null;
    private EditText eQW = null;
    private com.baidu.tieba.pb.view.j eQX = null;
    private com.baidu.tieba.pb.view.b eQZ = null;
    private b.InterfaceC0043b dtT = null;
    private TbRichTextView.e aRN = null;
    private NoNetworkView.a bFE = null;
    private Dialog eRb = null;
    private View eRc = null;
    private com.baidu.tbadk.core.dialog.a eRd = null;
    private Dialog eRe = null;
    private View eRf = null;
    private int eRg = 0;
    private RadioGroup eRh = null;
    private RadioButton eRi = null;
    private RadioButton eRj = null;
    private RadioButton eRk = null;
    private Button eRl = null;
    private Button eRm = null;
    private TextView eRn = null;
    private Dialog eRo = null;
    private View eRp = null;
    private LinearLayout eRq = null;
    private CompoundButton.OnCheckedChangeListener eRr = null;
    private TextView eRs = null;
    private TextView eRt = null;
    private String eRu = null;
    private com.baidu.tbadk.core.dialog.b eRv = null;
    private com.baidu.tbadk.core.dialog.b eRw = null;
    private boolean eRx = false;
    private boolean eRy = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eRz = null;
    private boolean dLA = false;
    private Button eRA = null;
    public ImageView eRE = null;
    private boolean eRG = true;
    private com.baidu.tbadk.core.view.a box = null;
    private boolean eHp = false;
    private int mSkinType = 3;
    private boolean eRM = false;
    private boolean mIsFromCDN = true;
    private int eRU = 0;
    private float eSg = -1.0f;
    private int eSh = -1;
    private boolean eSi = false;
    private a.InterfaceC0119a eSj = new a.InterfaceC0119a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0119a
        public void lj() {
        }
    };
    private boolean eJc = false;
    private boolean eSk = false;
    private LinearLayout eSl = null;
    private TextView eSm = null;
    private int eSn = 0;
    private boolean eSo = false;
    private boolean eSw = false;
    private int rank = 0;
    private CustomMessageListener dGk = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aq.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.eQT != null) {
                aq.this.eQT.notifyDataSetChanged();
            }
        }
    };
    private Handler eSx = new Handler();
    private CustomMessageListener eSz = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.aq.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.eRG = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eSB = true;
    private boolean eSE = false;
    private boolean aam = false;
    String userId = null;
    private final List<TbImageView> eSF = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener eSG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.pb.main.aq.18
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            aq.this.aTD();
        }
    };
    private boolean eSI = false;

    public void i(int i, float f) {
        this.eSh = i;
        this.eSg = f;
    }

    public d aTv() {
        return this.eSt;
    }

    public NoNetworkView aTw() {
        return this.bFB;
    }

    public void aTx() {
        if (this.Lt != null) {
            this.Lt.hide();
        }
    }

    public PbFakeFloorModel aTy() {
        return this.eMA;
    }

    public q aTz() {
        return this.eSe;
    }

    public void aTA() {
        reset();
        aTx();
        this.eSe.aRW();
        hl(false);
    }

    private void reset() {
        if (this.eIu != null && this.eIu.aQP() != null && this.Lt != null) {
            com.baidu.tbadk.editortools.pb.a.Dw().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aQP = this.eIu.aQP();
            aQP.DQ();
            if (aQP.getWriteImagesInfo() != null) {
                aQP.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aQP.eN(10);
            aQP.eL(SendView.ALL);
            aQP.eM(SendView.ALL);
            com.baidu.tbadk.editortools.l eC = this.Lt.eC(23);
            com.baidu.tbadk.editortools.l eC2 = this.Lt.eC(2);
            com.baidu.tbadk.editortools.l eC3 = this.Lt.eC(5);
            if (eC2 != null) {
                eC2.lT();
            }
            if (eC3 != null) {
                eC3.lT();
            }
            if (eC != null) {
                eC.hide();
            }
            this.Lt.invalidate();
        }
    }

    public boolean aTB() {
        return this.eRG;
    }

    public void hm(boolean z) {
        if (this.eRB != null && this.eRC != null) {
            this.eRC.setText(d.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eRB.startAnimation(alphaAnimation);
            }
            this.eRB.setVisibility(0);
            this.eRG = true;
            if (this.eRT != null) {
                this.eRT.setVisibility(0);
            }
        }
    }

    public void hn(boolean z) {
        if (this.eRB != null && this.eRC != null) {
            this.eRC.setText(d.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eRB.startAnimation(alphaAnimation);
            }
            this.eRB.setVisibility(0);
            this.eRG = true;
            if (this.eRT != null) {
                this.eRT.setVisibility(0);
            }
        }
    }

    public PostData aTC() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.eQj == null) {
            return null;
        }
        int firstVisiblePosition = this.eQj.getFirstVisiblePosition();
        int lastVisiblePosition = this.eQj.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eQj.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.eQj.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.eQj.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.eQT.pe(headerViewsCount) != null && this.eQT.pe(headerViewsCount) != PostData.gjG) {
            i2 = headerViewsCount + 1;
        }
        return this.eQT.getItem(i2) instanceof PostData ? (PostData) this.eQT.getItem(i2) : null;
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.aRp = 0;
        this.ePW = 0;
        this.ePX = 0;
        this.ePY = 0;
        this.eIu = null;
        this.bZc = null;
        this.cbp = null;
        this.eQj = null;
        this.eQl = null;
        this.eQp = null;
        this.eQq = null;
        this.eQr = null;
        this.eQt = null;
        this.eQv = null;
        this.eQx = null;
        this.eQA = null;
        this.eQB = null;
        this.eQC = null;
        this.eQI = null;
        this.eQK = null;
        this.eQL = null;
        this.bEu = null;
        this.eQP = null;
        this.eQQ = null;
        this.eQT = null;
        this.eQY = null;
        this.aIS = null;
        this.cll = null;
        this.eHt = null;
        this.eRB = null;
        this.eRC = null;
        this.eRD = null;
        this.eRF = null;
        this.eRN = null;
        this.eRO = null;
        this.eRP = null;
        this.eIu = pbActivity;
        this.cll = onClickListener;
        this.aRO = cVar;
        this.bZc = (RelativeLayout) LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.new_pb_activity, (ViewGroup) null);
        this.bZc.getViewTreeObserver().addOnGlobalLayoutListener(this.eSG);
        this.eIu.addContentView(this.bZc, new FrameLayout.LayoutParams(-1, -1));
        this.cbp = this.eIu.findViewById(d.h.statebar_view);
        this.eQS = (ObservedChangeLinearLayout) this.eIu.findViewById(d.h.title_wrapper);
        this.bFB = (NoNetworkView) this.eIu.findViewById(d.h.view_no_network);
        this.eQj = (PbLandscapeListView) this.eIu.findViewById(d.h.new_pb_list);
        this.ayG = new TextView(this.eIu.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eIu.getActivity(), d.f.ds98));
        this.eQj.addHeaderView(this.ayG, 0);
        View view = new View(this.eIu.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eIu.getResources().getDimensionPixelSize(d.f.ds100)));
        view.setVisibility(4);
        this.eQj.addFooterView(view);
        this.eQj.setOnTouchListener(this.eIu.aMT);
        this.eQf = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
        this.eSf = new com.baidu.tieba.d.b(pbActivity.getPageContext(), this.eQf.eWp);
        this.eSf.hM(1);
        if (this.eIu.aRq()) {
            this.eQh = (ViewStub) this.eIu.findViewById(d.h.manga_view_stub);
            this.eQh.setVisibility(0);
            this.eQg = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
            this.eQg.show();
            this.eQf.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.ayG.setLayoutParams(layoutParams);
        this.eQf.aVm().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0108a() { // from class: com.baidu.tieba.pb.pb.main.aq.6
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0108a
            public void agv() {
                if (aq.this.eQj != null) {
                    if (aq.this.eQa != null) {
                        aq.this.eQa.aWM();
                    }
                    aq.this.eQj.smoothScrollToPosition(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0108a
            public void agu() {
                aq.this.eIu.afL();
            }
        }));
        this.eRB = this.eIu.findViewById(d.h.pb_editor_tool_comment);
        this.eRI = com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds110);
        this.eRJ = com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds156);
        this.eRK = this.eRI;
        this.eRC = (TextView) this.eIu.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_text);
        this.eRD = (ViewGroup) this.eIu.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_layout);
        this.eRF = (TextView) this.eIu.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_praise_icon);
        this.eRF.setVisibility(8);
        this.eRD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!aq.this.eIu.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", aq.this.mForumId));
                } else if (aq.this.eMX == null || !com.baidu.tieba.pb.f.T(aq.this.eMX.aPQ())) {
                    if (aq.this.Lt != null) {
                        aq.this.aTM();
                    }
                    if (aq.this.Lt != null) {
                        aq.this.eRG = false;
                        com.baidu.tieba.tbadkCore.b.a.a(aq.this.eIu, (View) aq.this.Lt.eE(2).aCd, false, aq.this.eSj);
                    }
                    aq.this.aUj();
                }
            }
        });
        this.eRF.setOnClickListener(this.cll);
        this.eRF.setOnTouchListener(this.eIu);
        this.eQl = LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_item, (ViewGroup) null);
        this.eQp = (LinearLayout) LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_user_item, (ViewGroup) null);
        this.eQs = new e(this.eIu, this.eQp);
        this.eQs.init();
        this.eQs.b(this.eQs.aQO(), this.cll);
        this.eQt = (ColumnLayout) this.eQp.findViewById(d.h.pb_head_owner_root);
        this.eQu = (ThreadSkinView) this.eQp.findViewById(d.h.pb_thread_skin);
        this.eQt.setOnLongClickListener(this.onLongClickListener);
        this.eQt.setOnTouchListener(this.aRO);
        this.eQt.setVisibility(8);
        this.eQl.setOnTouchListener(this.aRO);
        this.eRN = this.eQl.findViewById(d.h.pb_head_activity_join_number_container);
        this.eRN.setVisibility(8);
        this.eRO = (TextView) this.eQl.findViewById(d.h.pb_head_activity_join_number);
        this.eQv = (TextView) this.eQt.findViewById(d.h.pb_head_owner_info_user_name);
        this.eQw = (TextView) this.eQp.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eQx = (TextView) this.eQt.findViewById(d.h.floor_owner);
        this.eQy = (ImageView) this.eQt.findViewById(d.h.icon_forum_level);
        this.eQA = (FrameLayout) this.eQt.findViewById(d.h.pb_head_headImage_container);
        this.eQB = (HeadImageView) this.eQt.findViewById(d.h.pb_head_owner_photo);
        this.eQz = (HeadPendantView) this.eQt.findViewById(d.h.pb_pendant_head_owner_photo);
        this.eQz.wD();
        if (this.eQz.getHeadView() != null) {
            this.eQz.getHeadView().setIsRound(true);
            this.eQz.getHeadView().setDrawBorder(false);
        }
        if (this.eQz.getPendantView() != null) {
            this.eQz.getPendantView().setIsRound(true);
            this.eQz.getPendantView().setDrawBorder(false);
        }
        this.eMc = (UserIconBox) this.eQt.findViewById(d.h.show_icon_vip);
        this.eMd = (UserIconBox) this.eQt.findViewById(d.h.show_icon_yinji);
        this.eQD = (FloatingLayout) this.eQp.findViewById(d.h.pb_head_owner_info_root);
        this.eQI = (PbFirstFloorUserLikeButton) this.eQt.findViewById(d.h.pb_like_button);
        this.eQJ = new ao(pbActivity.getPageContext(), this.eQI, 1);
        this.eQK = (TextView) this.eQt.findViewById(d.h.pb_views);
        this.eQL = (TextView) this.eQt.findViewById(d.h.pb_item_first_floor_reply_time);
        this.bEu = (TextView) this.eQt.findViewById(d.h.pb_item_first_floor_location_address);
        this.eSu = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eSv = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eQP = this.eQl.findViewById(d.h.new_pb_header_item_line_above_livepost);
        this.eQr = LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.layout_read_thread, (ViewGroup) null);
        this.eQq = (TextView) this.eQr.findViewById(d.h.pb_head_read_button);
        this.eQp.addView(this.eQr);
        this.eQq.setOnClickListener(this.cll);
        this.ePY = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds2);
        this.ePX = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds18);
        this.ePW = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds20);
        this.aRp = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds32);
        this.eQQ = this.eQl.findViewById(d.h.new_pb_header_item_line_below_livepost);
        this.eQl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.23
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return false;
            }
        });
        this.eRP = (ViewStub) this.bZc.findViewById(d.h.interview_status_stub);
        this.eQT = new g(this.eIu, this.eQj);
        this.eQT.t(this.cll);
        this.eQT.setTbGestureDetector(this.aRO);
        this.eQT.setOnImageClickListener(this.aRN);
        this.eHt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.VI() || !com.baidu.tieba.c.a.a(aq.this.eIu.getBaseContext(), aq.this.eIu.aQU().getThreadID(), (String) sparseArray.get(d.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.h.tag_from, 1);
                                aq.this.eIu.d(sparseArray);
                                return;
                            }
                            aq.this.bh(view2);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.h.tag_from, 0);
                        sparseArray.put(d.h.tag_check_mute_from, 1);
                        aq.this.eIu.d(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.eQT.G(this.eHt);
        aTG();
        this.eQj.addHeaderView(this.eQn);
        this.eQj.addHeaderView(this.eQp);
        this.eQj.addHeaderView(this.eQl);
        this.eQY = new PbListView(this.eIu.getPageContext().getPageActivity());
        this.aIS = this.eQY.getView().findViewById(d.h.pb_more_view);
        if (this.aIS != null) {
            this.aIS.setOnClickListener(this.cll);
            com.baidu.tbadk.core.util.ai.j(this.aIS, d.g.pb_foot_more_trans_selector);
        }
        this.eQY.wS();
        this.eQY.dn(d.g.pb_foot_more_trans_selector);
        this.eQY.m10do(d.g.pb_foot_more_trans_selector);
        this.eRa = this.eIu.findViewById(d.h.viewstub_progress);
        this.eIu.registerListener(this.eSz);
        this.eQC = com.baidu.tbadk.ala.b.nC().h(this.eIu.getActivity(), 2);
        if (this.eQC != null) {
            this.eQC.setVisibility(8);
            this.eQD.addView(this.eQC);
        }
        this.eMA = new PbFakeFloorModel(this.eIu.getPageContext());
        this.eSe = new q(this.eIu.getPageContext(), this.eMA, this.bZc);
        this.eMA.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.25
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                aq.this.eMA.m(postData);
                aq.this.eQT.notifyDataSetChanged();
                aq.this.eSe.aRW();
            }
        });
        if (this.eIu.aQU() != null && !StringUtils.isNull(this.eIu.aQU().aSK())) {
            this.eIu.showToast(this.eIu.aQU().aSK());
        }
        this.eIu.registerListener(this.dGk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTD() {
        if (this.eRT != null) {
            int[] iArr = new int[2];
            this.eRB.getLocationOnScreen(iArr);
            this.eRT.setBottomMargin((((ViewGroup) this.eIu.getPageContext().getPageActivity().getWindow().getDecorView()).getHeight() - this.eRK) - iArr[1]);
        }
    }

    public void aTE() {
        if (this.eQj != null) {
            this.eQj.removeHeaderView(this.eQn);
            this.eQj.removeHeaderView(this.eQp);
            this.eQj.removeHeaderView(this.eQl);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eRT == null) {
            this.eRT = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eIu.getPageContext().getPageActivity());
            ViewGroup viewGroup = (ViewGroup) this.eIu.getPageContext().getPageActivity().getWindow().getDecorView();
            int[] iArr = new int[2];
            this.eRB.getLocationOnScreen(iArr);
            this.eRT.a(viewGroup, (viewGroup.getHeight() - this.eRI) - iArr[1], aVar);
            this.eRT.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.26
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void cG(List<String> list) {
                    aq.this.eIu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(aq.this.eIu.getPageContext().getPageActivity(), 25016, (ArrayList) list)));
                }
            });
            this.eRT.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.aq.27
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void ag(float f) {
                    if (aq.this.eRB != null) {
                        ViewGroup.LayoutParams layoutParams = aq.this.eRB.getLayoutParams();
                        layoutParams.height = (int) (((aq.this.eRJ - aq.this.eRI) * f) + aq.this.eRI);
                        aq.this.eRD.setAlpha(1.0f - f);
                        aq.this.eRB.setLayoutParams(layoutParams);
                        aq.this.eRK = layoutParams.height;
                    }
                }
            });
        }
    }

    private boolean l(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPQ() == null || !fVar.aQk() || !TbadkCoreApplication.getInst().isTTSCanUse() || fVar.aPQ().rC() == 1 || fVar.aPQ().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aPQ().rE() == null || fVar.aPQ().rE().te() == 0) && !fVar.aPQ().sx()) {
            BdUniqueId type = fVar.aPQ().getType();
            return type == bl.Zc || type == bl.Ze || type == bl.Zb;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.eQr != null) {
            if (!z) {
                this.eQr.setVisibility(8);
            } else if (!l(fVar)) {
                this.eQr.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aPS() != null && fVar.aPS().size() > 0) {
                    postData = fVar.aPS().get(0);
                }
                if (postData != null && postData.btg() == 1) {
                    u(this.aRp, this.ePX, this.aRp, this.ePY);
                } else {
                    u(this.aRp, this.ePX, this.aRp, this.ePW);
                }
                this.eQr.setVisibility(0);
            }
        }
    }

    private void u(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQq.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.eQq.setLayoutParams(layoutParams);
    }

    public TextView aTF() {
        return this.eQq;
    }

    private void aTG() {
        if (this.eQn == null) {
            int g = com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds34);
            this.eQn = new LinearLayout(this.eIu.getPageContext().getPageActivity());
            this.eQn.setOrientation(1);
            this.eQn.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eQn.setPadding(g, com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds40), g, com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds46));
            this.eQn.setGravity(17);
            this.eQo = new TextView(this.eIu.getPageContext().getPageActivity());
            this.eQo.setGravity(3);
            this.eQo.setMaxLines(2);
            this.eQo.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            this.eQo.setPadding(0, 0, 0, 0);
            this.eQo.setLineSpacing(com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.ai.i(this.eQo, d.e.cp_cont_b);
            this.eQo.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds48));
            this.eQo.setVisibility(8);
            this.eQn.addView(this.eQo);
            this.eQn.setOnTouchListener(this.aRO);
            this.eQn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTH() {
        if (this.eIu.aRq()) {
            this.eQi = (ViewStub) this.eIu.findViewById(d.h.manga_mention_controller_view_stub);
            this.eQi.setVisibility(0);
            if (this.eQM == null) {
                this.eQM = (LinearLayout) this.eIu.findViewById(d.h.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.eIu.getPageContext(), this.eQM);
            }
            if (this.eQN == null) {
                this.eQN = (TextView) this.eQM.findViewById(d.h.manga_prev_btn);
            }
            if (this.eQO == null) {
                this.eQO = (TextView) this.eQM.findViewById(d.h.manga_next_btn);
            }
            this.eQN.setOnClickListener(this.cll);
            this.eQO.setOnClickListener(this.cll);
        }
    }

    private void aTI() {
        if (this.eIu.aRq()) {
            if (this.eIu.aRt() == -1) {
                com.baidu.tbadk.core.util.ai.c(this.eQN, d.e.cp_cont_e, 1);
            }
            if (this.eIu.aRu() == -1) {
                com.baidu.tbadk.core.util.ai.c(this.eQO, d.e.cp_cont_e, 1);
            }
        }
    }

    public void aTJ() {
        if (this.eQM == null) {
            aTH();
        }
        this.eQi.setVisibility(8);
        if (this.eSx != null && this.eSy != null) {
            this.eSx.removeCallbacks(this.eSy);
        }
    }

    public void aTK() {
        if (this.eSx != null) {
            if (this.eSy != null) {
                this.eSx.removeCallbacks(this.eSy);
            }
            this.eSy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.eQM == null) {
                        aq.this.aTH();
                    }
                    aq.this.eQi.setVisibility(0);
                }
            };
            this.eSx.postDelayed(this.eSy, 2000L);
        }
    }

    public void jG(boolean z) {
        this.eQf.jG(z);
        if (z && this.eRM) {
            this.eQY.setText(this.eIu.getResources().getString(d.l.click_load_more));
            this.eQj.setNextPage(this.eQY);
            this.eQe = 2;
        }
    }

    public void aTL() {
        TbadkCoreApplication.getInst().setReadThreadPlayerScreenMaxHeight(this.bZc.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.Lt = iVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.bZc.addView(this.Lt, layoutParams);
        this.Lt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aTx();
    }

    public void aTM() {
        if (this.eIu != null && this.Lt != null) {
            this.Lt.lT();
            aUj();
        }
    }

    public void T(String str, boolean z) {
        this.eRH = z;
        aO(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void aO(boolean z) {
        if (this.eRF != null) {
            if (this.eRH) {
                com.baidu.tbadk.core.util.ai.j(this.eRF, d.g.pb_praise_already_click_selector);
                this.eRF.setContentDescription(this.eIu.getResources().getString(d.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ai.j(this.eRF, d.g.pb_praise_normal_click_selector);
            this.eRF.setContentDescription(this.eIu.getResources().getString(d.l.frs_item_praise_text));
        }
    }

    public TextView aTN() {
        return this.eRF;
    }

    public void jH(boolean z) {
        if (this.eQj != null && this.ayG != null && this.cbp != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cbp.setVisibility(0);
                } else {
                    this.cbp.setVisibility(8);
                    this.eQj.removeHeaderView(this.ayG);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ayG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.ayG.setLayoutParams(layoutParams);
                }
                aUb();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ayG.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jO(true);
                this.ayG.setLayoutParams(layoutParams2);
            }
            aUb();
            aUs();
        }
    }

    public g aTO() {
        return this.eQT;
    }

    public void aTP() {
        if (this.eQT != null) {
            this.eQT.aRN();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eKh = cVar;
    }

    private void a(bo boVar) {
        if (boVar == null || boVar.te() == 0) {
            if (this.eRA != null) {
                this.eRA.setVisibility(8);
            }
            if (this.eQP != null) {
                this.eQP.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eRA == null) {
            this.eIu.getLayoutMode().t(((ViewStub) this.eQl.findViewById(d.h.live_talk_layout)).inflate());
            this.eRA = (Button) this.eQl.findViewById(d.h.pb_head_function_manage_go_to_live_post);
            this.eQP = this.eQl.findViewById(d.h.new_pb_header_item_line_above_livepost);
        }
        int tf = boVar.tf();
        String string = this.eIu.getPageContext().getString(d.l.go_to_live_post_prefix);
        if (tf == 0) {
            string = string + this.eIu.getPageContext().getString(d.l.go_to_interview_post);
        } else if (tf == 1) {
            string = string + this.eIu.getPageContext().getString(d.l.go_to_discuss_post);
        }
        this.eRA.setText(string);
        this.eRA.setVisibility(0);
        this.eRA.setOnClickListener(this.cll);
        this.eSD = true;
        aUc();
    }

    public void bh(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.eRc == null) {
            this.eRc = LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eIu.getLayoutMode().t(this.eRc);
        if (this.eRb == null) {
            this.eRb = new Dialog(this.eIu.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eRb.setCanceledOnTouchOutside(true);
            this.eRb.setCancelable(true);
            this.eRb.setContentView(this.eRc);
            WindowManager.LayoutParams attributes = this.eRb.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.ag(this.eIu.getPageContext().getPageActivity()) * 0.9d);
            this.eRb.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eRb.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eRb.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eRb.findViewById(d.h.disable_reply_btn);
        int intValue = sparseArray.get(d.h.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(d.h.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(d.h.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(d.l.delete);
            } else {
                textView.setText(d.l.delete_post);
            }
            sparseArray2.put(d.h.tag_del_post_id, sparseArray.get(d.h.tag_del_post_id));
            sparseArray2.put(d.h.tag_del_post_type, sparseArray.get(d.h.tag_del_post_type));
            sparseArray2.put(d.h.tag_del_post_is_self, sparseArray.get(d.h.tag_del_post_is_self));
            sparseArray2.put(d.h.tag_manage_user_identity, sparseArray.get(d.h.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eRb != null && (aq.this.eRb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eRb, aq.this.eIu.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        aq.this.a(((Integer) sparseArray5.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.h.tag_del_post_id), ((Integer) sparseArray5.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name)) || aUp()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(d.h.tag_forbid_user_name, sparseArray.get(d.h.tag_forbid_user_name));
            sparseArray5.put(d.h.tag_manage_user_identity, sparseArray.get(d.h.tag_manage_user_identity));
            sparseArray5.put(d.h.tag_forbid_user_post_id, sparseArray.get(d.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eRb != null && (aq.this.eRb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eRb, aq.this.eIu.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && aq.this.eSA != null) {
                        aq.this.eSA.g(new Object[]{sparseArray6.get(d.h.tag_manage_user_identity), sparseArray6.get(d.h.tag_forbid_user_name), sparseArray6.get(d.h.tag_forbid_user_post_id)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.l.un_mute);
            } else {
                textView3.setText(d.l.mute);
            }
            sparseArray6.put(d.h.tag_is_mem, sparseArray.get(d.h.tag_is_mem));
            sparseArray6.put(d.h.tag_user_mute_mute_userid, sparseArray.get(d.h.tag_user_mute_mute_userid));
            sparseArray6.put(d.h.tag_user_mute_mute_username, sparseArray.get(d.h.tag_user_mute_mute_username));
            sparseArray6.put(d.h.tag_user_mute_post_id, sparseArray.get(d.h.tag_user_mute_post_id));
            sparseArray6.put(d.h.tag_user_mute_thread_id, sparseArray.get(d.h.tag_user_mute_thread_id));
            sparseArray6.put(d.h.tag_user_mute_msg, sparseArray.get(d.h.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eRb != null && (aq.this.eRb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eRb, aq.this.eIu.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        aq.this.eIu.a(z, (String) sparseArray7.get(d.h.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.eRb, this.eIu.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eSA = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eRX, Integer.valueOf(eRY));
        int i3 = d.l.del_post_confirm;
        if (i == 0) {
            i3 = d.l.del_thread_confirm;
        }
        this.eRd = new com.baidu.tbadk.core.dialog.a(this.eIu.getActivity());
        this.eRd.cc(i3);
        this.eRd.A(sparseArray);
        this.eRd.a(d.l.dialog_ok, this.eIu);
        this.eRd.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eRd.ar(true);
        this.eRd.b(this.eIu.getPageContext());
        this.eRd.tr();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eRp == null) {
            this.eRp = LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.commit_good, (ViewGroup) null);
        }
        this.eIu.getLayoutMode().t(this.eRp);
        if (this.eRo == null) {
            this.eRo = new Dialog(this.eIu.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eRo.setCanceledOnTouchOutside(true);
            this.eRo.setCancelable(true);
            this.eRz = (ScrollView) this.eRp.findViewById(d.h.good_scroll);
            this.eRo.setContentView(this.eRp);
            WindowManager.LayoutParams attributes = this.eRo.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds540);
            this.eRo.getWindow().setAttributes(attributes);
            this.eRr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.eRu = (String) compoundButton.getTag();
                        if (aq.this.eQk != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : aq.this.eQk) {
                                String str = (String) aVar.getTag();
                                if (str != null && aq.this.eRu != null && !str.equals(aq.this.eRu)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.eRq = (LinearLayout) this.eRp.findViewById(d.h.good_class_group);
            this.eRt = (TextView) this.eRp.findViewById(d.h.dialog_button_cancel);
            this.eRt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eRo instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.eRo, aq.this.eIu.getPageContext());
                    }
                }
            });
            this.eRs = (TextView) this.eRp.findViewById(d.h.dialog_button_ok);
            this.eRs.setOnClickListener(this.cll);
        }
        this.eRq.removeAllViews();
        this.eQk = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bN = bN("0", this.eIu.getPageContext().getString(d.l.def_good_class));
        this.eQk.add(bN);
        bN.setChecked(true);
        this.eRq.addView(bN);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bN2 = bN(String.valueOf(arrayList.get(i2).qa()), arrayList.get(i2).pZ());
                this.eQk.add(bN2);
                View view = new View(this.eIu.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds1));
                com.baidu.tbadk.core.util.ai.k(view, d.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eRq.addView(view);
                this.eRq.addView(bN2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eRz.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eIu.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eIu.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eIu.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eRz.setLayoutParams(layoutParams2);
            this.eRz.removeAllViews();
            this.eRz.addView(this.eRq);
        }
        com.baidu.adp.lib.g.g.a(this.eRo, this.eIu.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bN(String str, String str2) {
        Activity pageActivity = this.eIu.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, d.f.ds100));
        aVar.setOnCheckedChangeListener(this.eRr);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aTQ() {
        this.eIu.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eIu.hideProgressBar();
        if (z && z2) {
            this.eIu.showToast(this.eIu.getPageContext().getString(d.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.l.neterror);
            }
            this.eIu.showToast(str);
        }
    }

    public void awv() {
        this.eRa.setVisibility(0);
    }

    public void awu() {
        this.eRa.setVisibility(8);
    }

    public View aTR() {
        if (this.eRp != null) {
            return this.eRp.findViewById(d.h.dialog_button_ok);
        }
        return null;
    }

    public String aTS() {
        return this.eRu;
    }

    public View getView() {
        return this.bZc;
    }

    public void aTT() {
        com.baidu.adp.lib.util.k.b(this.eIu.getPageContext().getPageActivity(), this.eIu.getCurrentFocus());
    }

    public void jI(boolean z) {
        this.eIu.hideProgressBar();
        aBR();
    }

    public void aTU() {
        this.eQY.wS();
        this.eQY.wW();
    }

    public void aTV() {
        this.eIu.hideProgressBar();
        wX();
        this.eQj.completePullRefreshPostDelayed(2000L);
        aUc();
    }

    public void aTW() {
        this.eQj.completePullRefreshPostDelayed(2000L);
        aUc();
    }

    public void jJ(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eRD.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eIu.getResources().getDimensionPixelSize(d.f.ds84) : 0;
        this.eRD.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eQT.setOnLongClickListener(onLongClickListener);
    }

    public void a(b.InterfaceC0043b interfaceC0043b, boolean z, boolean z2) {
        if (this.eRv != null) {
            this.eRv.dismiss();
            this.eRv = null;
        }
        this.eRv = new com.baidu.tbadk.core.dialog.b(this.eIu.getPageContext().getPageActivity());
        this.eRv.cf(d.l.operation);
        if (z2) {
            this.eRv.a(new String[]{this.eIu.getPageContext().getString(d.l.copy)}, interfaceC0043b);
        } else if (!z) {
            this.eRv.a(new String[]{this.eIu.getPageContext().getString(d.l.copy), this.eIu.getPageContext().getString(d.l.mark)}, interfaceC0043b);
        } else {
            this.eRv.a(new String[]{this.eIu.getPageContext().getString(d.l.copy), this.eIu.getPageContext().getString(d.l.remove_mark)}, interfaceC0043b);
        }
        this.eRv.d(this.eIu.getPageContext());
        this.eRv.tu();
    }

    public void a(b.InterfaceC0043b interfaceC0043b, boolean z) {
        if (this.eRw != null) {
            this.eRw.dismiss();
            this.eRw = null;
        }
        this.eRw = new com.baidu.tbadk.core.dialog.b(this.eIu.getPageContext().getPageActivity());
        this.eRw.cf(d.l.operation);
        if (z) {
            this.eRw.a(new String[]{this.eIu.getPageContext().getString(d.l.save_to_emotion)}, interfaceC0043b);
        } else {
            this.eRw.a(new String[]{this.eIu.getPageContext().getString(d.l.save_to_emotion), this.eIu.getPageContext().getString(d.l.pb_save_image)}, interfaceC0043b);
        }
        this.eRw.d(this.eIu.getPageContext());
        this.eRw.tu();
    }

    public int aTX() {
        return pt(this.eQj.getFirstVisiblePosition());
    }

    private int pt(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eQj.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eQj.getAdapter() == null || !(this.eQj.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eQj.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aTY() {
        int lastVisiblePosition = this.eQj.getLastVisiblePosition();
        if (this.eQa != null) {
            if (lastVisiblePosition == this.eQj.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.eQT.aRO();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pt(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.eQj.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eQW.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        this.eQT.a(fVar, false);
        this.eQT.notifyDataSetChanged();
        aUc();
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        if (this.eQG == null) {
            this.eIu.getLayoutMode().t(((ViewStub) this.eQl.findViewById(d.h.praise_layout)).inflate());
            this.eQG = (FrsPraiseView) this.eQl.findViewById(d.h.pb_head_praise_view);
            this.eQG.setIsFromPb(true);
            this.eQR = this.eQl.findViewById(d.h.new_pb_header_item_line_above_praise);
            this.eQG.dt(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eQG != null) {
            boolean aUc = aUc();
            this.eQG.setVisibility(8);
            if (fVar != null && fVar.qH() != null && fVar.qH().qE() == 0 && this.eHp) {
                if (aUc) {
                    this.eQQ.setVisibility(0);
                } else {
                    this.eQQ.setVisibility(8);
                }
            } else {
                this.eQQ.setVisibility(8);
            }
            com.baidu.tieba.graffiti.b.as(this.eQQ);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aPZ() != null) {
            return fVar.aPZ();
        }
        if (z) {
            if (fVar == null || fVar.aPS() == null || fVar.aPS().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPS().get(0);
            if (postData.btg() != 1) {
                postData = a(fVar);
            }
            if (postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
                return postData;
            }
            return postData;
        }
        PostData aPX = fVar.aPX();
        if (aPX == null) {
            return a(fVar);
        }
        return aPX;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPQ() == null || fVar.aPQ().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aPQ().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPQ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.ts(1);
        postData.setId(fVar.aPQ().rV());
        postData.setTitle(fVar.aPQ().getTitle());
        postData.setTime(fVar.aPQ().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0577 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0386  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        int i2;
        String d;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.h btj;
        String portrait;
        if (fVar != null && fVar.aPQ() != null) {
            PostData c = c(fVar, z);
            a(c, fVar);
            aUq();
            this.eQt.setVisibility(8);
            if (fVar.aPQ() != null && fVar.aPQ().ss() && fVar.aPQ().rW() != null) {
                this.eSi = true;
                this.eQf.jY(this.eSi);
                if (this.eQa == null) {
                    this.eQa = new com.baidu.tieba.pb.video.i(this.eIu, this.eQf, fVar.aPQ().rW());
                    this.eQa.a(fVar.aPQ().rW(), fVar.aPQ(), fVar.getForumId());
                    this.eQa.startPlay();
                } else if (this.eQd) {
                    this.eQa.a(fVar.aPQ().rW(), fVar.aPQ(), fVar.getForumId());
                    this.eQa.startPlay();
                }
                if (fVar.aPR() != null && fVar.aPR().size() >= 1) {
                    bl blVar = fVar.aPR().get(0);
                    this.eQa.ab(blVar);
                    this.eQa.pP(blVar.getTitle());
                }
                this.eQa.b(c, fVar.aPQ(), fVar.aQn());
                this.eQd = false;
                this.eQj.removeHeaderView(this.eQa.aWL());
                this.eQj.addHeaderView(this.eQa.aWL(), 0);
                if (this.eQb == null) {
                    this.eQb = new com.baidu.tieba.pb.video.h(this.eIu);
                }
                this.eQb.a(fVar.aPQ().sJ(), fVar.aPQ(), fVar.aQj());
                this.eQj.removeHeaderView(this.eQb.aWC());
                this.eQj.addHeaderView(this.eQb.aWC(), 1);
                if (fVar.aPQ().sJ() != null) {
                    this.eQj.removeHeaderView(this.eQb.aWD());
                    this.eQj.removeHeaderView(this.eQp);
                    this.eQj.addHeaderView(this.eQb.aWD(), 2);
                } else {
                    if (this.eQb.aWD() != null) {
                        this.eQj.removeHeaderView(this.eQb.aWD());
                    }
                    this.eQj.removeHeaderView(this.eQp);
                    this.eQj.addHeaderView(this.eQp, 2);
                }
                if (this.eQa != null) {
                    this.eQa.pH(0);
                }
                aUb();
            } else {
                this.eSi = false;
                this.eQf.jY(this.eSi);
                this.eQf.eWo.setVisibility(0);
                if (this.eQa != null) {
                    this.eQj.removeHeaderView(this.eQa.aWL());
                }
                if (this.eQb != null) {
                    this.eQb.e(this.eQj);
                }
            }
            if (this.eIu.aQS() != null) {
                this.eIu.aQS().jU(this.eSi);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eSi) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11923").r("obj_id", 2));
                    }
                    if (aq.this.eIu.eJk.eVE != null) {
                        if (!aq.this.eSi && aq.this.eMX != null && aq.this.eMX.aPQ() != null && aq.this.eMX.aPQ().getAuthor() != null && aq.this.eMX.aPQ().getAuthor().isBigV()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12151").r("obj_locate", 1));
                        }
                        aq.this.eIu.eJk.eVE.onClick(view);
                    }
                }
            };
            if (this.eQa != null) {
                this.eQa.J(onClickListener);
            }
            b(fVar, z);
            if (c != null) {
                this.eRL = c;
                if (fVar != null && fVar.aPQ() != null && fVar.aPQ().getAuthor() != null) {
                    fVar.aPQ().getAuthor().getUserId();
                    if (fVar.qH() != null) {
                        this.eSn = fVar.qH().qA();
                        if (fVar.qH().qD() == 1) {
                        }
                    }
                }
                this.eQt.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eQt.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eQt.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_clip_board, c);
                sparseArray.put(d.h.tag_is_subpb, false);
                if (!this.eSs) {
                    this.eQn.setVisibility(0);
                }
                if (!fVar.aPQ().ss() && this.eQo.getText() != null && this.eQo.getText().length() > 0) {
                    this.eQo.setVisibility(0);
                } else {
                    this.eQo.setVisibility(8);
                }
                n(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rQ = fVar.aPQ().rQ();
                if (rQ != null && rQ.size() > 0 && !this.eSs) {
                    this.eRO.setText(String.valueOf(rQ.get(0).pr()));
                    this.eRN.setVisibility(0);
                    this.eSC = true;
                } else {
                    this.eRN.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ai.j(this.eRN, d.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.ai.c(this.eRO, d.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    String string = c.getAuthor().getName_show() == null ? StringUtils.string(c.getAuthor().getUserName()) : StringUtils.string(c.getAuthor().getName_show());
                    if (StringUtils.isNull(c.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aS(c.getAuthor().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aS(string) > 12) {
                            d = com.baidu.tbadk.core.util.al.d(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aS = com.baidu.adp.lib.util.j.aS(c.getAuthor().getName_show());
                                if (aS + i2 > 14) {
                                    i3 = 0;
                                } else if (aS + i2 >= 12) {
                                    i3 = 1;
                                } else if (aS + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eMd != null) {
                                this.eMd.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                                this.eMd.setOnClickListener(this.eIu.eJk.cta);
                                this.eMd.a(iconInfo, i3, this.eIu.getResources().getDimensionPixelSize(d.f.ds26), this.eIu.getResources().getDimensionPixelSize(d.f.ds26), this.eIu.getResources().getDimensionPixelSize(d.f.ds8));
                            }
                            if (this.eMc != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eMc.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eMc.setOnClickListener(this.eIu.eJk.eVF);
                                this.eMc.a(tShowInfoNew, 3, this.eIu.getResources().getDimensionPixelSize(d.f.ds36), this.eIu.getResources().getDimensionPixelSize(d.f.ds36), this.eIu.getResources().getDimensionPixelSize(d.f.ds8), true);
                            }
                            this.eQv.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.eQv.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                            this.eQv.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.u.v(tShowInfoNew) || c.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.ai.c(this.eQv, d.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.ai.c(this.eQv, d.e.cp_cont_f, 1);
                            }
                            if (c == null && !TextUtils.isEmpty(c.getAuthor().getGodIntro())) {
                                this.eQw.setVisibility(0);
                                this.eQw.setText(ap.a(c.getAuthor()));
                            } else {
                                this.eQw.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_link_tip_a, 1);
                            this.eQx.setVisibility(0);
                            if (fVar.aPQ().getAuthor() != null && fVar.aPQ().getAuthor().getAlaUserData() != null && this.eQC != null) {
                                if (fVar.aPQ().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.eQC.setVisibility(8);
                                } else {
                                    this.eQC.setVisibility(0);
                                    if (this.eQc == null) {
                                        this.eQc = new com.baidu.tieba.d.b(this.eIu.getPageContext(), this.eQC);
                                        this.eQc.hM(1);
                                    }
                                    this.eQc.aH(this.eIu.getResources().getString(d.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Rq = fVar.aPQ().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.eQC.setTag(aVar);
                                }
                            }
                            this.eQB.setUserId(c.getAuthor().getUserId());
                            this.eQB.setUserName(c.getAuthor().getUserName());
                            this.eQB.setImageDrawable(null);
                            this.eQB.setRadius(com.baidu.adp.lib.util.k.g(this.eIu.getActivity(), d.f.ds40));
                            this.eQB.setTag(c.getAuthor().getUserId());
                            this.eQL.setText(c.bti());
                            btj = c.btj();
                            if (btj == null && !TextUtils.isEmpty(btj.getName()) && !TextUtils.isEmpty(btj.getName().trim())) {
                                final String name = btj.getName();
                                final String lat = btj.getLat();
                                final String lng = btj.getLng();
                                this.bEu.setVisibility(0);
                                this.bEu.setText(btj.getName());
                                this.bEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.i.hr()) {
                                                aq.this.eIu.showToast(d.l.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.T(aq.this.eIu.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, aq.this.eIu.getPageContext().getString(d.l.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.bEu.setVisibility(8);
                            }
                            this.eQJ.a(c.getAuthor());
                            this.eQJ.ePT = this.eSi;
                            if (!this.eRy) {
                                this.eQI.setVisibility(8);
                                this.eQK.setVisibility(0);
                                this.eQK.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_thread_views), com.baidu.tbadk.core.util.al.x(fVar.aQm())));
                            } else if (!PbNormalLikeButtonSwitchStatic.GS() || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.eQI.setVisibility(8);
                                this.eQK.setVisibility(8);
                            } else {
                                this.eQI.setVisibility(0);
                                this.eQI.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eIu.getActivity(), d.f.ds24));
                                this.eQK.setVisibility(8);
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null && !StringUtils.isNull(c.getAuthor().getPendantData().pV())) {
                                UtilHelper.showHeadImageViewBigV(this.eQz.getHeadView(), c.getAuthor());
                                this.eQB.setVisibility(8);
                                this.eQz.setVisibility(0);
                                if (this.eQH != null) {
                                    this.eQH.setVisibility(8);
                                }
                                this.eQv.setOnClickListener(onClickListener);
                                this.eQz.getHeadView().c(portrait, 28, false);
                                this.eQz.getHeadView().setUserId(c.getAuthor().getUserId());
                                this.eQz.getHeadView().setUserName(c.getAuthor().getUserName());
                                this.eQz.getHeadView().setOnClickListener(onClickListener);
                                this.eQz.et(c.getAuthor().getPendantData().pV());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eQB, c.getAuthor());
                                this.eQB.setVisibility(0);
                                this.eQt.setOnClickListener(onClickListener);
                                this.eQv.setOnClickListener(onClickListener);
                                this.eQB.setOnClickListener(onClickListener);
                                this.eQz.setVisibility(8);
                                this.eQB.c(portrait, 28, false);
                            }
                            String name_show = c.getAuthor().getName_show();
                            String userName = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ab.ge() && name_show != null && !name_show.equals(userName)) {
                                this.eQv.setText(com.baidu.tieba.pb.d.ao(this.eIu.getPageContext().getPageActivity(), this.eQv.getText().toString()));
                                this.eQv.setGravity(16);
                                this.eQv.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aPr());
                                com.baidu.tbadk.core.util.ai.c(this.eQv, d.e.cp_other_e, 1);
                            }
                        }
                        d = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eMd != null) {
                        }
                        if (this.eMc != null) {
                        }
                        this.eQv.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.eQv.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                        this.eQv.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ai.c(this.eQv, d.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eQw.setVisibility(8);
                        com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_link_tip_a, 1);
                        this.eQx.setVisibility(0);
                        if (fVar.aPQ().getAuthor() != null) {
                            if (fVar.aPQ().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eQB.setUserId(c.getAuthor().getUserId());
                        this.eQB.setUserName(c.getAuthor().getUserName());
                        this.eQB.setImageDrawable(null);
                        this.eQB.setRadius(com.baidu.adp.lib.util.k.g(this.eIu.getActivity(), d.f.ds40));
                        this.eQB.setTag(c.getAuthor().getUserId());
                        this.eQL.setText(c.bti());
                        btj = c.btj();
                        if (btj == null) {
                        }
                        this.bEu.setVisibility(8);
                        this.eQJ.a(c.getAuthor());
                        this.eQJ.ePT = this.eSi;
                        if (!this.eRy) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eQB, c.getAuthor());
                        this.eQB.setVisibility(0);
                        this.eQt.setOnClickListener(onClickListener);
                        this.eQv.setOnClickListener(onClickListener);
                        this.eQB.setOnClickListener(onClickListener);
                        this.eQz.setVisibility(8);
                        this.eQB.c(portrait, 28, false);
                        String name_show2 = c.getAuthor().getName_show();
                        String userName2 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ab.ge()) {
                            this.eQv.setText(com.baidu.tieba.pb.d.ao(this.eIu.getPageContext().getPageActivity(), this.eQv.getText().toString()));
                            this.eQv.setGravity(16);
                            this.eQv.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aPr());
                            com.baidu.tbadk.core.util.ai.c(this.eQv, d.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.j.aS(string) > 14) {
                            d = com.baidu.tbadk.core.util.al.d(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eMd != null) {
                            }
                            if (this.eMc != null) {
                            }
                            this.eQv.setText(ae(c.getAuthor().getSealPrefix(), d));
                            this.eQv.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                            this.eQv.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.ai.c(this.eQv, d.e.cp_cont_h, 1);
                            if (c == null) {
                            }
                            this.eQw.setVisibility(8);
                            com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_link_tip_a, 1);
                            this.eQx.setVisibility(0);
                            if (fVar.aPQ().getAuthor() != null) {
                            }
                            this.eQB.setUserId(c.getAuthor().getUserId());
                            this.eQB.setUserName(c.getAuthor().getUserName());
                            this.eQB.setImageDrawable(null);
                            this.eQB.setRadius(com.baidu.adp.lib.util.k.g(this.eIu.getActivity(), d.f.ds40));
                            this.eQB.setTag(c.getAuthor().getUserId());
                            this.eQL.setText(c.bti());
                            btj = c.btj();
                            if (btj == null) {
                            }
                            this.bEu.setVisibility(8);
                            this.eQJ.a(c.getAuthor());
                            this.eQJ.ePT = this.eSi;
                            if (!this.eRy) {
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eQB, c.getAuthor());
                            this.eQB.setVisibility(0);
                            this.eQt.setOnClickListener(onClickListener);
                            this.eQv.setOnClickListener(onClickListener);
                            this.eQB.setOnClickListener(onClickListener);
                            this.eQz.setVisibility(8);
                            this.eQB.c(portrait, 28, false);
                            String name_show22 = c.getAuthor().getName_show();
                            String userName22 = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ab.ge()) {
                            }
                        }
                        d = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eMd != null) {
                        }
                        if (this.eMc != null) {
                        }
                        this.eQv.setText(ae(c.getAuthor().getSealPrefix(), d));
                        this.eQv.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                        this.eQv.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ai.c(this.eQv, d.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eQw.setVisibility(8);
                        com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_link_tip_a, 1);
                        this.eQx.setVisibility(0);
                        if (fVar.aPQ().getAuthor() != null) {
                        }
                        this.eQB.setUserId(c.getAuthor().getUserId());
                        this.eQB.setUserName(c.getAuthor().getUserName());
                        this.eQB.setImageDrawable(null);
                        this.eQB.setRadius(com.baidu.adp.lib.util.k.g(this.eIu.getActivity(), d.f.ds40));
                        this.eQB.setTag(c.getAuthor().getUserId());
                        this.eQL.setText(c.bti());
                        btj = c.btj();
                        if (btj == null) {
                        }
                        this.bEu.setVisibility(8);
                        this.eQJ.a(c.getAuthor());
                        this.eQJ.ePT = this.eSi;
                        if (!this.eRy) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eQB, c.getAuthor());
                        this.eQB.setVisibility(0);
                        this.eQt.setOnClickListener(onClickListener);
                        this.eQv.setOnClickListener(onClickListener);
                        this.eQB.setOnClickListener(onClickListener);
                        this.eQz.setVisibility(8);
                        this.eQB.c(portrait, 28, false);
                        String name_show222 = c.getAuthor().getName_show();
                        String userName222 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ab.ge()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eQs.V(fVar.aPQ());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.sa() != null) {
            this.eQu.a(this.eIu.getPageContext(), fVar.aPS().get(0).sa(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aPO().getId(), fVar.aPO().getName(), fVar.aPQ().getId(), this.eIu.aRA() ? "FRS" : null));
            this.eQt.setPadding(this.eQt.getPaddingLeft(), (int) this.eIu.getResources().getDimension(d.f.ds20), this.eQt.getPaddingRight(), this.eQt.getPaddingBottom());
            return;
        }
        this.eQu.a(null, null, null);
    }

    public void aTZ() {
        if (this.eQa != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11997").r("obj_type", 1));
            this.eQa.aWM();
            this.eQj.smoothScrollToPosition(0);
        }
    }

    public boolean aUa() {
        return this.eSE;
    }

    private boolean OS() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean O(bl blVar) {
        if (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), blVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.eQf.aVq();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eQf.mY(eVar.forumName);
            }
            String string = this.eIu.getResources().getString(d.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eIu.getResources().getString(d.l.self);
                    break;
                case 300:
                    str = this.eIu.getResources().getString(d.l.bawu);
                    break;
                case 400:
                    str = this.eIu.getResources().getString(d.l.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eFE;
            this.eIu.showNetRefreshView(this.bZc, format, null, this.eIu.getResources().getString(d.l.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.k.hI()) {
                        com.baidu.tbadk.core.util.at.wf().c(aq.this.eIu.getPageContext(), new String[]{str2});
                        aq.this.eIu.finish();
                        return;
                    }
                    aq.this.eIu.showToast(d.l.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aTr;
        String str;
        if (fVar != null) {
            this.eMX = fVar;
            this.mType = i;
            if (fVar.aPQ() != null) {
                this.eRU = fVar.aPQ().rs();
                this.aam = fVar.aPQ().rp();
                if (fVar.aPQ().getAnchorLevel() != 0) {
                    this.eSE = true;
                }
                this.eRy = O(fVar.aPQ());
                if (this.eQJ != null && fVar.aPQ().getAuthor() != null) {
                    this.eQJ.isBigV = fVar.aPQ().getAuthor().isBigV();
                }
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            p(fVar);
            this.eRM = false;
            this.eHp = z;
            aTV();
            b(fVar, z, i);
            if (this.eIu.aRq()) {
                if (this.eQX == null) {
                    this.eQX = new com.baidu.tieba.pb.view.j(this.eIu.getPageContext());
                    this.eQX.lk();
                    this.eQX.a(this.anN);
                }
                this.eQj.setPullRefresh(this.eQX);
                aUb();
                if (this.eQX != null) {
                    this.eQX.dp(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qH().qE() == 0 && z) {
                this.eQj.setPullRefresh(null);
                this.ePZ = 1;
            } else {
                if (this.eQX == null) {
                    this.eQX = new com.baidu.tieba.pb.view.j(this.eIu.getPageContext());
                    this.eQX.lk();
                    this.eQX.a(this.anN);
                }
                this.eQj.setPullRefresh(this.eQX);
                aUb();
                this.ePZ = 2;
                if (this.eQX != null) {
                    this.eQX.dp(TbadkCoreApplication.getInst().getSkinType());
                }
                Rs();
            }
            aUc();
            this.eQT.iT(this.eHp);
            this.eQT.iU(false);
            this.eQT.jf(i == 5);
            this.eQT.jg(i == 6);
            this.eQT.a(fVar, false);
            this.eQT.notifyDataSetChanged();
            if (this.eIu.aRE()) {
                if (fVar.aPP() != null) {
                    this.mForumName = fVar.aPP().getForumName();
                    this.mForumId = fVar.aPP().getForumId();
                }
                if (this.mForumName == null && this.eIu.aQU() != null && this.eIu.aQU().aSe() != null) {
                    this.mForumName = this.eIu.aQU().aSe();
                }
                this.eQf.mY(this.mForumName);
            } else {
                this.eQf.mY(null);
            }
            if (this.eIu.aRE()) {
                int i4 = 0;
                PostData c = c(fVar, z);
                if (c != null && c.getAuthor() != null) {
                    i4 = c.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.eQy.setVisibility(0);
                    com.baidu.tbadk.core.util.ai.c(this.eQy, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.eQy.setVisibility(8);
                }
            } else {
                this.eQy.setVisibility(8);
            }
            if (fVar.aPQ() != null && fVar.aPQ().rv() != null) {
                if (fVar.aPQ().rv().getNum() < 1) {
                    str = this.eIu.getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = fVar.aPQ().rv().getNum() + "";
                }
                if (this.ePV != -1) {
                    fVar.aPQ().rv().setIsLike(this.ePV);
                }
                T(str, fVar.aPQ().rv().getIsLike() == 1);
            }
            if (fVar.qH().qD() == 0 && !z) {
                this.eQj.setNextPage(null);
                this.eQe = 1;
            } else if (this.eIu.isLogin()) {
                this.eQj.setNextPage(this.eQY);
                this.eQe = 2;
                Rs();
            } else if (fVar.qH().qD() == 1) {
                this.eRM = true;
                if (this.eQZ == null) {
                    this.eQZ = new com.baidu.tieba.pb.view.b(this.eIu.getPageContext());
                }
                this.eQj.setNextPage(this.eQZ);
                this.eQe = 3;
            }
            ArrayList<PostData> aPS = fVar.aPS();
            if (fVar.qH().qD() == 0 || aPS == null || aPS.size() < fVar.qH().qC()) {
                if (com.baidu.tbadk.core.util.u.u(aPS) == 0 || (com.baidu.tbadk.core.util.u.u(aPS) == 1 && aPS.get(0) != null && aPS.get(0).btg() == 1)) {
                    this.eQY.setText(this.eIu.getResources().getString(d.l.list_no_more_new));
                } else {
                    this.eQY.setText("");
                }
                if (this.eIu.aRq() && this.eQj != null && this.eQj.getData() != null && this.eQj.getData().size() == 1 && (this.eQj.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.eQY.setText("");
                }
                aUh();
            } else if (z2) {
                if (this.eSB) {
                    wX();
                    if (fVar.qH().qD() != 0) {
                        this.eQY.setText(this.eIu.getResources().getString(d.l.pb_load_more));
                    }
                } else {
                    this.eQY.wS();
                    this.eQY.wZ();
                }
            } else {
                this.eQY.wS();
                this.eQY.wZ();
            }
            if (fVar.aPQ() != null && fVar.aPQ().getAuthor() != null && fVar.aPQ().getAuthor().getType() == 0) {
                this.eQf.aVn();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.eQj.getData() != null || fVar.aPS() != null) {
                        i5 = (this.eQj.getData().size() - fVar.aPS().size()) + this.eQj.getHeaderViewsCount();
                    }
                    this.eQj.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aTr = ai.aTq().aTr()) != null) {
                        this.eSw = true;
                        this.eQj.onRestoreInstanceState(aTr);
                        break;
                    } else {
                        this.eQj.setSelection(0);
                        break;
                    }
                case 4:
                    this.eSB = false;
                    break;
                case 5:
                    this.eQj.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aTr2 = ai.aTq().aTr();
                        this.eSw = true;
                        if (aTr2 != null) {
                            this.eQj.onRestoreInstanceState(aTr2);
                            break;
                        }
                    }
                    this.eQj.setSelection(0);
                    break;
            }
            if (this.eSh >= 0) {
                this.eQj.setSelectionFromTop(this.eSh, (int) this.eSg);
                this.eSh = -1;
            }
            if (this.eRU == eRW && OS()) {
                aUk();
            }
            if (this.eQb != null) {
                this.eQb.aa(fVar.aPQ());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aUb() {
        if (this.eQa != null && this.eQa.aWL() != null) {
            this.eQj.removeHeaderView(this.ayG);
            if (this.mType != 1) {
                this.eQj.removeHeaderView(this.eQa.aWL());
                this.eQj.addHeaderView(this.eQa.aWL(), 0);
                this.eQj.setSelection(0);
                return;
            }
            return;
        }
        if (this.eQa != null) {
            this.eQj.removeHeaderView(this.eQa.aWL());
        }
        this.eQj.removeHeaderView(this.ayG);
        this.eQj.addHeaderView(this.ayG, 0);
    }

    public void jK(boolean z) {
        this.eRx = z;
        this.eQf.jK(z);
    }

    public void wX() {
        if (this.eQY != null) {
            this.eQY.wT();
            this.eQY.wX();
        }
        Rs();
    }

    public void Nr() {
        this.eQj.setVisibility(0);
    }

    private boolean aUc() {
        boolean z;
        if (this.eRA != null && this.eRA.getVisibility() == 0) {
            if (this.eQP != null) {
                this.eQP.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.eQP != null) {
                this.eQP.setVisibility(8);
            }
            z = false;
        }
        if ((this.eQR == null || this.eQR.getVisibility() == 8) && z && this.eHp) {
            this.eQQ.setVisibility(0);
        } else {
            this.eQQ.setVisibility(8);
        }
        com.baidu.tieba.graffiti.b.as(this.eQQ);
        return z;
    }

    private boolean o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPQ() == null) {
            return false;
        }
        if (fVar.aPQ().rC() == 1 || fVar.aPQ().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aPQ().rE() == null || fVar.aPQ().rE().te() == 0) || fVar.aPQ().rA() == 1 || fVar.aPQ().rB() == 1 || fVar.aPQ().sk() || fVar.aPQ().sx() || fVar.aPQ().sr() || fVar.aPQ().rR() != null || fVar.aPQ().sy() || fVar.aPQ().sy() || !com.baidu.tbadk.core.util.al.isEmpty(fVar.aPQ().getCategory()) || fVar.aPQ().rI() || fVar.aPQ().rH();
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eIu.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eQn != null) {
                if (fVar.aPQ() != null && fVar.aPQ().rU() == 0 && !fVar.aPQ().ss() && !this.eSs) {
                    this.eQn.setVisibility(0);
                    if (fVar.aPQ() != null) {
                        fVar.aPQ().e(true, o(fVar));
                    }
                    SpannableStringBuilder sf = fVar.aPQ().sf();
                    this.eQo.setOnTouchListener(new com.baidu.tieba.view.l(sf));
                    this.eQo.setText(sf);
                    this.eQo.setVisibility(0);
                } else if (fVar.aPQ().rU() == 1) {
                    if (fVar.aPQ() != null) {
                        fVar.aPQ().e(true, o(fVar));
                        SpannableStringBuilder sf2 = fVar.aPQ().sf();
                        if (sf2 == null || sf2.length() == 0) {
                            this.eQn.setVisibility(8);
                            this.eQj.removeHeaderView(this.eQn);
                            if (fVar.aPQ() != null && !fVar.aPQ().ss()) {
                                this.eQt.setPadding(this.eQt.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds48), this.eQt.getPaddingRight(), this.eQt.getPaddingBottom());
                            }
                        } else {
                            this.eQn.setVisibility(0);
                            this.eQo.setOnTouchListener(new com.baidu.tieba.view.l(sf2));
                            this.eQo.setText(sf2);
                            this.eQo.setVisibility(0);
                        }
                    }
                } else {
                    this.eQn.setVisibility(8);
                    this.eQj.removeHeaderView(this.eQn);
                    if (fVar.aPQ() != null && fVar.aPQ().ss()) {
                        this.eQt.setPadding(this.eQt.getPaddingLeft(), 0, this.eQt.getPaddingRight(), this.eQt.getPaddingBottom());
                    } else {
                        this.eQt.setPadding(this.eQt.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds48), this.eQt.getPaddingRight(), this.eQt.getPaddingBottom());
                    }
                }
            }
            this.eHp = z;
            bl aPQ = fVar.aPQ();
            if (aPQ != null) {
                a(aPQ.rE());
            }
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aUc();
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
            sparseArray.put(d.h.tag_del_post_id, c.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aQb()));
            sparseArray.put(d.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(d.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(d.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(d.h.tag_del_post_id, c.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aQb()));
            sparseArray.put(d.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aIS;
    }

    public void py(String str) {
        if (this.eQY != null) {
            this.eQY.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eQj;
    }

    public int aUd() {
        return d.h.richText;
    }

    public TextView aQO() {
        return this.eQs.aQO();
    }

    public void d(BdListView.e eVar) {
        this.eQj.setOnSrollToBottomListener(eVar);
    }

    public void a(k.b bVar) {
        this.anN = bVar;
        if (this.eQX != null) {
            this.eQX.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, a.b bVar) {
        if (arVar != null) {
            int qB = arVar.qB();
            int qy = arVar.qy();
            if (this.eQU != null) {
                this.eQU.tr();
            } else {
                this.eQU = new com.baidu.tbadk.core.dialog.a(this.eIu.getPageContext().getPageActivity());
                this.eQV = LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.dialog_direct_pager, (ViewGroup) null);
                this.eQU.v(this.eQV);
                this.eQU.a(d.l.dialog_ok, bVar);
                this.eQU.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.aBR();
                        aVar.dismiss();
                    }
                });
                this.eQU.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.eSc == null) {
                            aq.this.eSc = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.eIu.HidenSoftKeyPad((InputMethodManager) aq.this.eIu.getSystemService("input_method"), aq.this.bZc);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.ga().postDelayed(aq.this.eSc, 150L);
                    }
                });
                this.eQU.b(this.eIu.getPageContext()).tr();
            }
            this.eQW = (EditText) this.eQV.findViewById(d.h.input_page_number);
            this.eQW.setText("");
            TextView textView = (TextView) this.eQV.findViewById(d.h.current_page_number);
            if (qB <= 0) {
                qB = 1;
            }
            if (qy <= 0) {
                qy = 1;
            }
            textView.setText(MessageFormat.format(this.eIu.getApplicationContext().getResources().getString(d.l.current_page), Integer.valueOf(qB), Integer.valueOf(qy)));
            this.eIu.ShowSoftKeyPadDelay(this.eQW, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eQj.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eIu.showToast(str);
    }

    public boolean jL(boolean z) {
        if (this.Lt == null || !this.Lt.Dd()) {
            return false;
        }
        this.Lt.Bu();
        return true;
    }

    public void aUe() {
        if (this.eSF != null) {
            while (this.eSF.size() > 0) {
                TbImageView remove = this.eSF.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aUe();
        this.eQT.pf(1);
        if (this.eQa != null) {
            this.eQa.onPause();
        }
    }

    public void onResume() {
        this.eQT.pf(2);
        if (this.eQa != null) {
            this.eQa.onResume();
        }
        if (this.eRT != null) {
            this.eRT.onResume();
        }
    }

    public void onDestroy() {
        this.eSf.YD();
        if (this.eQc != null) {
            this.eQc.YD();
        }
        if (this.eQb != null) {
            this.eQb.onDestroy();
        }
        this.eIu.hideProgressBar();
        if (this.bFB != null && this.bFE != null) {
            this.bFB.b(this.bFE);
        }
        aBR();
        wX();
        if (this.eSc != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eSc);
        }
        if (this.eSd != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eSd);
        }
        if (this.eSr != null) {
            this.eSr.removeAllViews();
        }
        if (this.eQt != null && this.eQH != null) {
            this.eQt.removeView(this.eQA);
            this.eQH = null;
        }
        if (this.eRQ != null) {
            this.eRQ.clearStatus();
        }
        this.eSx = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eQT.pf(3);
        if (this.cbp != null) {
            this.cbp.setBackgroundDrawable(null);
        }
        if (this.eQa != null) {
            this.eQa.destroy();
        }
        if (this.eQT != null) {
            this.eQT.onDestory();
        }
        this.bZc.getViewTreeObserver().removeGlobalOnLayoutListener(this.eSG);
    }

    public boolean pu(int i) {
        if (this.eQa != null) {
            return this.eQa.pN(i);
        }
        return false;
    }

    public void aBR() {
        this.eQf.oq();
        this.eSf.YD();
        if (this.eQc != null) {
            this.eQc.YD();
        }
        com.baidu.adp.lib.util.k.b(this.eIu.getPageContext().getPageActivity(), this.eQW);
        if (this.eRv != null) {
            this.eRv.dismiss();
        }
        aUf();
        if (this.eQb != null) {
            this.eQb.aWE();
        }
        if (this.eQU != null) {
            this.eQU.dismiss();
        }
        if (this.clk != null) {
            this.clk.dismiss();
        }
    }

    public void iS(boolean z) {
        this.eQT.iS(z);
    }

    public void hk(boolean z) {
        this.dLA = z;
    }

    public void aUf() {
        if (this.eRd != null) {
            this.eRd.dismiss();
        }
        if (this.eRe != null) {
            com.baidu.adp.lib.g.g.b(this.eRe, this.eIu.getPageContext());
        }
        if (this.eRo != null) {
            com.baidu.adp.lib.g.g.b(this.eRo, this.eIu.getPageContext());
        }
        if (this.eRb != null) {
            com.baidu.adp.lib.g.g.b(this.eRb, this.eIu.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.eMX, this.eHp);
            d(this.eMX, this.eHp, this.mType);
            this.eIu.getLayoutMode().ah(i == 1);
            this.eIu.getLayoutMode().t(this.bZc);
            this.eIu.getLayoutMode().t(this.eQo);
            this.eIu.getLayoutMode().t(this.eQp);
            this.eIu.getLayoutMode().t(this.eQl);
            if (this.eQF != null) {
                com.baidu.tbadk.core.util.ai.c(this.eQF, d.e.cp_cont_d, 1);
            }
            if (this.eQE != null) {
                com.baidu.tbadk.core.util.ai.c(this.eQE, d.e.cp_cont_d, 1);
            }
            if (this.eQb != null) {
                this.eQb.onChangeSkinType(i);
            }
            this.eIu.getLayoutMode().t(this.eQl);
            com.baidu.tbadk.core.util.ai.i(this.eQo, d.e.cp_cont_b);
            this.eQo.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            this.eIu.getLayoutMode().t(this.aIS);
            if (this.eQV != null) {
                this.eIu.getLayoutMode().t(this.eQV);
            }
            jK(this.eRx);
            this.eQT.notifyDataSetChanged();
            if (this.eQX != null) {
                this.eQX.dp(i);
            }
            if (this.eQY != null) {
                this.eQY.dp(i);
                com.baidu.tbadk.core.util.ai.j(this.aIS, d.g.pb_foot_more_trans_selector);
                this.eQY.dn(d.g.pb_foot_more_trans_selector);
            }
            if (this.Lt != null) {
                this.Lt.onChangeSkinType(i);
            }
            if (this.eQG != null) {
                this.eQG.dt(i);
            }
            if (this.eQZ != null) {
                this.eQZ.dp(i);
            }
            if (this.eQk != null && this.eQk.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eQk) {
                    aVar.aVh();
                }
            }
            if (this.eSr != null) {
                com.baidu.tbadk.core.util.ai.k(this.eSr, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ai.k(this.eSp, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.ai.c(this.eSq, d.e.cp_cont_c, 1);
            }
            aO(i == 1);
            aTI();
            UtilHelper.setStatusBarBackground(this.cbp, i);
            if (this.eQI != null) {
                this.eQI.onChangeSkinType(i);
            }
            if (this.bEu != null) {
                com.baidu.tbadk.core.util.ai.i(this.bEu, d.e.cp_cont_d);
            }
            if (this.eQL != null) {
                com.baidu.tbadk.core.util.ai.i(this.eQL, d.e.cp_cont_f);
            }
            if (this.eQx != null) {
                com.baidu.tbadk.core.util.ai.i(this.eQx, d.e.cp_link_tip_a);
            }
            if (this.eQK != null) {
                com.baidu.tbadk.core.util.ai.i(this.eQK, d.e.cp_cont_f);
            }
            if (this.eQM != null) {
                com.baidu.tbadk.o.a.a(this.eIu.getPageContext(), this.eQM);
            }
            if (this.eSe != null) {
                this.eSe.onChangeSkinType(i);
            }
            if (this.eQf != null) {
                if (this.eQa != null) {
                    this.eQa.pH(i);
                } else {
                    this.eQf.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.ai.i(this.eQw, d.e.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRN = eVar;
        this.eQT.setOnImageClickListener(this.aRN);
    }

    public void c(NoNetworkView.a aVar) {
        this.bFE = aVar;
        if (this.bFB != null) {
            this.bFB.a(this.bFE);
        }
    }

    public void jM(boolean z) {
        this.eQT.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aUg() {
        return this.eRA;
    }

    public void aUh() {
        if (this.eQe != 2) {
            this.eQj.setNextPage(this.eQY);
            this.eQe = 2;
        }
    }

    public void aUi() {
        if (com.baidu.tbadk.l.r.Gz().GA()) {
            int lastVisiblePosition = this.eQj.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eQj.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog = tbImageView.getPerfLog();
                                perfLog.fi(1001);
                                perfLog.aKa = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wA();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.l.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.fi(1001);
                        perfLog2.aKa = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.wA();
                    }
                }
            }
        }
    }

    public void hl(boolean z) {
        if (this.eRB != null) {
            if (this.dLA) {
                hm(z);
            } else {
                hn(z);
            }
        }
    }

    public void aUj() {
        if (this.eRB != null) {
            this.eRB.setVisibility(8);
            this.eRG = false;
            if (this.eRT != null) {
                this.eRT.setVisibility(8);
            }
        }
    }

    public void Rr() {
        if (this.box == null) {
            this.box = new com.baidu.tbadk.core.view.a(this.eIu.getPageContext());
        }
        this.box.aH(true);
    }

    public void Rs() {
        if (this.box != null) {
            this.box.aH(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eQj.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eQj.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eQa != null) {
            this.eQa.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eSH = getScrollY();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z = false;
        this.eSk = false;
        if (this.eQa != null) {
            this.eQa.b(absListView, i);
        }
        a aVar = new a();
        aVar.eSN = i;
        aVar.eSO = this.eQj.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
        int headerViewsCount = (i - this.eQj.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                break;
            } else if (this.eQT.pe(headerViewsCount) != com.baidu.tieba.pb.data.m.eGw) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.eQT.aRS().jF(z);
    }

    /* loaded from: classes.dex */
    public class a {
        public int eSN;
        public int eSO;

        public a() {
        }
    }

    public void aUk() {
        if (!this.eSI) {
            TiebaStatic.log("c10490");
            this.eSI = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIu.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eRX, Integer.valueOf(eRZ));
            aVar.cb(d.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.h.function_description_view)).setText(d.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.h.title_view)).setText(d.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(d.l.grade_button_tips, this.eIu);
            aVar.b(d.l.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eIu.getPageContext()).tr();
        }
    }

    public void aUl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIu.getPageContext().getPageActivity());
        aVar.cT(this.eIu.getResources().getString(d.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eRX, Integer.valueOf(eSb));
        aVar.A(sparseArray);
        aVar.a(d.l.upgrade_to_new, this.eIu);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eIu.getPageContext()).tr();
    }

    public int rs() {
        return this.eRU;
    }

    public void pz(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIu.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eIu.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eRX, Integer.valueOf(eSa));
        aVar.A(sparseArray);
        aVar.a(d.l.view, this.eIu);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eIu.getPageContext()).tr();
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

    public PbInterviewStatusView aUm() {
        return this.eRQ;
    }

    private void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPQ() != null && fVar.aPQ().sx() && this.eRQ == null) {
            this.eRQ = (PbInterviewStatusView) this.eRP.inflate();
            this.eRQ.setOnClickListener(this.cll);
            this.eRQ.setCallback(this.eIu.aRz());
            this.eRQ.a(this.eIu, fVar);
        }
    }

    public LinearLayout aUn() {
        return this.eQS;
    }

    public View aUo() {
        return this.cbp;
    }

    public boolean aUp() {
        return this.eSs;
    }

    public void iX(boolean z) {
        this.eQs.iX(z);
    }

    private void aUq() {
        if (this.eSs) {
            if (this.eSt == null) {
                d.a aVar = d.eIx.get();
                if (aVar != null) {
                    this.eSt = aVar.a(this.eIu);
                    ListAdapter adapter = this.eQj.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.ayG) {
                            this.eQj.addHeaderView(this.eSt.aQM(), 1);
                        } else {
                            this.eQj.addHeaderView(this.eSt.aQM(), 0);
                        }
                    }
                } else {
                    this.eQp.setVisibility(0);
                    return;
                }
            }
            this.eQp.setVisibility(8);
            this.eQj.removeHeaderView(this.eQp);
            return;
        }
        this.eQp.setVisibility(0);
    }

    public void jN(boolean z) {
        this.eSs = z;
    }

    public void aUr() {
        this.eIu.showNetRefreshView(getView(), "");
        View EQ = this.eIu.getRefreshView().EQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EQ.getLayoutParams();
        layoutParams.addRule(3, aUn().getId());
        EQ.setLayoutParams(layoutParams);
        this.eIu.hideLoadingView(getView());
        if (this.eSt != null) {
            this.eQj.removeHeaderView(this.eSt.aQM());
            this.eSt = null;
        }
    }

    public void pA(String str) {
        if (this.eQg != null) {
            this.eQg.setTitle(str);
        }
    }

    private int jO(boolean z) {
        if (this.eRQ == null || this.eRQ.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.eIu.getPageContext().getPageActivity(), d.f.ds72);
    }

    private void aUs() {
        if (this.eRQ != null && this.eRQ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eRQ.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eRQ.setLayoutParams(layoutParams);
        }
    }

    public boolean aQV() {
        return false;
    }

    public boolean aUt() {
        return this.eSi;
    }

    public TextView aUu() {
        return this.eQF;
    }

    public void pB(String str) {
        this.eRD.performClick();
        if (!StringUtils.isNull(str) && this.eIu.aQP() != null && this.eIu.aQP().DA() != null && this.eIu.aQP().DA().Dt() != null) {
            EditText Dt = this.eIu.aQP().DA().Dt();
            Dt.setText(str);
            Dt.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aBR();
            aUj();
            aTx();
            if (this.eSe != null) {
                this.eSe.aRW();
            }
            this.eIu.afL();
            this.eQS.setVisibility(8);
            this.eQf.setTitleVisibility(false);
            this.eIu.jd(false);
            if (this.eQa != null) {
                if (configuration.orientation == 1) {
                    aUn().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eQj.setIsLandscape(true);
                    this.eQj.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eQj.setIsLandscape(false);
                    if (this.eSH > 0) {
                        this.eQj.smoothScrollBy(this.eSH, 0);
                    }
                }
                this.eQa.onConfigurationChanged(configuration);
            }
        }
    }

    public void jP(boolean z) {
        this.eQd = z;
    }

    public boolean aUv() {
        return this.eQa != null && this.eQa.aUv();
    }

    public void aUw() {
        if (this.eQa != null) {
            this.eQa.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.eQb != null) {
            this.eQb.w(j, i);
        }
        if (this.eQa != null) {
            this.eQa.w(j, i);
        }
    }

    public void aUx() {
        if (this.eRT != null) {
            this.eRT.aVg();
        }
    }

    public void aUy() {
        if (this.eRT != null) {
            this.eRT.setVisibility(8);
        }
    }

    public void jh(boolean z) {
        this.eQT.jh(z);
    }

    public void aUz() {
        if (this.eRR == null) {
            LayoutInflater.from(this.eIu.getActivity()).inflate(d.j.add_experienced_text, (ViewGroup) this.bZc, true);
            this.eRR = (ViewGroup) this.bZc.findViewById(d.h.add_experienced_layout);
            this.eRS = (TextView) this.bZc.findViewById(d.h.add_experienced);
            com.baidu.tbadk.core.util.ai.i(this.eRS, d.e.cp_cont_i);
            String string = this.eIu.getResources().getString(d.l.experienced_add_success);
            String string2 = this.eIu.getResources().getString(d.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_h)));
            this.eRS.setText(spannableString);
        }
        this.eRR.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.22
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.22.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        aq.this.eRR.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.eRS.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eRS.startAnimation(scaleAnimation);
    }
}
