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
    public static int eRX = 2;
    public static int eRY = 3;
    public static int eRZ = 0;
    public static int eSa = 3;
    public static int eSb = 4;
    public static int eSc = 5;
    public static int eSd = 6;
    private com.baidu.tbadk.editortools.i Lt;
    private View aIT;
    private com.baidu.tieba.pb.a.c aRP;
    private int aRq;
    private k.b anN;
    private TextView ayH;
    private TextView bEv;
    private NoNetworkView bFC;
    private RelativeLayout bZd;
    private View cbq;
    private View.OnClickListener clm;
    private View.OnClickListener eHv;
    private PbActivity eIw;
    PbActivity.c eKj;
    private PbFakeFloorModel eMC;
    private com.baidu.tieba.pb.data.f eMZ;
    private UserIconBox eMe;
    private UserIconBox eMf;
    public int ePX;
    private int ePY;
    private int ePZ;
    private ImageView eQA;
    private HeadPendantView eQB;
    private FrameLayout eQC;
    private HeadImageView eQD;
    private View eQE;
    private FloatingLayout eQF;
    private PbFirstFloorUserLikeButton eQK;
    private ao eQL;
    private TextView eQM;
    private TextView eQN;
    private LinearLayout eQO;
    private TextView eQP;
    private TextView eQQ;
    private View eQR;
    private View eQS;
    private ObservedChangeLinearLayout eQU;
    private g eQV;
    private int eQa;
    private com.baidu.tieba.pb.video.i eQc;
    private com.baidu.tieba.pb.video.h eQd;
    private com.baidu.tieba.d.b eQe;
    public final com.baidu.tieba.pb.pb.main.view.d eQh;
    public com.baidu.tieba.pb.pb.main.view.c eQi;
    private ViewStub eQj;
    private ViewStub eQk;
    private PbLandscapeListView eQl;
    private List<com.baidu.tieba.pb.pb.main.view.a> eQm;
    private View eQn;
    private LinearLayout eQr;
    private TextView eQs;
    private View eQt;
    private e eQu;
    private ColumnLayout eQv;
    private ThreadSkinView eQw;
    private TextView eQx;
    private TextView eQy;
    private TextView eQz;
    private View eRD;
    private TextView eRE;
    private ViewGroup eRF;
    private TextView eRH;
    private boolean eRJ;
    private int eRK;
    private int eRL;
    private int eRM;
    private PostData eRN;
    private View eRP;
    private TextView eRQ;
    private ViewStub eRR;
    private PbInterviewStatusView eRS;
    private ViewGroup eRT;
    private TextView eRU;
    private com.baidu.tieba.pb.pb.main.emotion.view.c eRV;
    private PbListView eRa;
    private View eRc;
    private Runnable eSA;
    private PbActivity.a eSC;
    private boolean eSE;
    private boolean eSF;
    private int eSJ;
    private Runnable eSe;
    private Runnable eSf;
    private q eSg;
    private com.baidu.tieba.d.b eSh;
    private View eSr;
    private TextView eSs;
    private LinearLayout eSt;
    private boolean eSu;
    private d eSv;
    private com.baidu.tbadk.core.view.userLike.c eSw;
    private com.baidu.tbadk.core.view.userLike.c eSx;
    private boolean isLandscape;
    private int mType;
    private int eQb = 1;
    private boolean eQf = false;
    private int eQg = 0;
    private final Handler mHandler = new Handler();
    private View eQo = null;
    private LinearLayout eQp = null;
    private TextView eQq = null;
    private TextView eQG = null;
    private TextView eQH = null;
    public FrsPraiseView eQI = null;
    private ClickableHeaderImageView eQJ = null;
    private View eQT = null;
    private com.baidu.tbadk.core.dialog.a eQW = null;
    private com.baidu.tbadk.core.dialog.b cll = null;
    private View eQX = null;
    private EditText eQY = null;
    private com.baidu.tieba.pb.view.j eQZ = null;
    private com.baidu.tieba.pb.view.b eRb = null;
    private b.InterfaceC0043b dtT = null;
    private TbRichTextView.e aRO = null;
    private NoNetworkView.a bFF = null;
    private Dialog eRd = null;
    private View eRe = null;
    private com.baidu.tbadk.core.dialog.a eRf = null;
    private Dialog eRg = null;
    private View eRh = null;
    private int eRi = 0;
    private RadioGroup eRj = null;
    private RadioButton eRk = null;
    private RadioButton eRl = null;
    private RadioButton eRm = null;
    private Button eRn = null;
    private Button eRo = null;
    private TextView eRp = null;
    private Dialog eRq = null;
    private View eRr = null;
    private LinearLayout eRs = null;
    private CompoundButton.OnCheckedChangeListener eRt = null;
    private TextView eRu = null;
    private TextView eRv = null;
    private String eRw = null;
    private com.baidu.tbadk.core.dialog.b eRx = null;
    private com.baidu.tbadk.core.dialog.b eRy = null;
    private boolean eRz = false;
    private boolean eRA = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView eRB = null;
    private boolean dLA = false;
    private Button eRC = null;
    public ImageView eRG = null;
    private boolean eRI = true;
    private com.baidu.tbadk.core.view.a boz = null;
    private boolean eHr = false;
    private int mSkinType = 3;
    private boolean eRO = false;
    private boolean mIsFromCDN = true;
    private int eRW = 0;
    private float eSi = -1.0f;
    private int eSj = -1;
    private boolean eSk = false;
    private a.InterfaceC0119a eSl = new a.InterfaceC0119a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0119a
        public void li() {
        }
    };
    private boolean eJe = false;
    private boolean eSm = false;
    private LinearLayout eSn = null;
    private TextView eSo = null;
    private int eSp = 0;
    private boolean eSq = false;
    private boolean eSy = false;
    private int rank = 0;
    private CustomMessageListener dGk = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aq.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.eQV != null) {
                aq.this.eQV.notifyDataSetChanged();
            }
        }
    };
    private Handler eSz = new Handler();
    private CustomMessageListener eSB = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.aq.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.eRI = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eSD = true;
    private boolean eSG = false;
    private boolean aam = false;
    String userId = null;
    private final List<TbImageView> eSH = new ArrayList();
    private ViewTreeObserver.OnGlobalLayoutListener eSI = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.pb.main.aq.18
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            aq.this.aTy();
        }
    };
    private boolean eSK = false;

    public void h(int i, float f) {
        this.eSj = i;
        this.eSi = f;
    }

    public d aTq() {
        return this.eSv;
    }

    public NoNetworkView aTr() {
        return this.bFC;
    }

    public void aTs() {
        if (this.Lt != null) {
            this.Lt.hide();
        }
    }

    public PbFakeFloorModel aTt() {
        return this.eMC;
    }

    public q aTu() {
        return this.eSg;
    }

    public void aTv() {
        reset();
        aTs();
        this.eSg.aRR();
        hl(false);
    }

    private void reset() {
        if (this.eIw != null && this.eIw.aQK() != null && this.Lt != null) {
            com.baidu.tbadk.editortools.pb.a.Dw().setStatus(0);
            com.baidu.tbadk.editortools.pb.c aQK = this.eIw.aQK();
            aQK.DQ();
            if (aQK.getWriteImagesInfo() != null) {
                aQK.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aQK.eN(10);
            aQK.eL(SendView.ALL);
            aQK.eM(SendView.ALL);
            com.baidu.tbadk.editortools.l eC = this.Lt.eC(23);
            com.baidu.tbadk.editortools.l eC2 = this.Lt.eC(2);
            com.baidu.tbadk.editortools.l eC3 = this.Lt.eC(5);
            if (eC2 != null) {
                eC2.lS();
            }
            if (eC3 != null) {
                eC3.lS();
            }
            if (eC != null) {
                eC.hide();
            }
            this.Lt.invalidate();
        }
    }

    public boolean aTw() {
        return this.eRI;
    }

    public void hm(boolean z) {
        if (this.eRD != null && this.eRE != null) {
            this.eRE.setText(d.l.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eRD.startAnimation(alphaAnimation);
            }
            this.eRD.setVisibility(0);
            this.eRI = true;
            if (this.eRV != null) {
                this.eRV.setVisibility(0);
            }
        }
    }

    public void hn(boolean z) {
        if (this.eRD != null && this.eRE != null) {
            this.eRE.setText(d.l.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eRD.startAnimation(alphaAnimation);
            }
            this.eRD.setVisibility(0);
            this.eRI = true;
            if (this.eRV != null) {
                this.eRV.setVisibility(0);
            }
        }
    }

    public PostData aTx() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.eQl == null) {
            return null;
        }
        int firstVisiblePosition = this.eQl.getFirstVisiblePosition();
        int lastVisiblePosition = this.eQl.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.eQl.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.eQl.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.eQl.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.eQV.pe(headerViewsCount) != null && this.eQV.pe(headerViewsCount) != PostData.gjG) {
            i2 = headerViewsCount + 1;
        }
        return this.eQV.getItem(i2) instanceof PostData ? (PostData) this.eQV.getItem(i2) : null;
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.aRq = 0;
        this.ePY = 0;
        this.ePZ = 0;
        this.eQa = 0;
        this.eIw = null;
        this.bZd = null;
        this.cbq = null;
        this.eQl = null;
        this.eQn = null;
        this.eQr = null;
        this.eQs = null;
        this.eQt = null;
        this.eQv = null;
        this.eQx = null;
        this.eQz = null;
        this.eQC = null;
        this.eQD = null;
        this.eQE = null;
        this.eQK = null;
        this.eQM = null;
        this.eQN = null;
        this.bEv = null;
        this.eQR = null;
        this.eQS = null;
        this.eQV = null;
        this.eRa = null;
        this.aIT = null;
        this.clm = null;
        this.eHv = null;
        this.eRD = null;
        this.eRE = null;
        this.eRF = null;
        this.eRH = null;
        this.eRP = null;
        this.eRQ = null;
        this.eRR = null;
        this.eIw = pbActivity;
        this.clm = onClickListener;
        this.aRP = cVar;
        this.bZd = (RelativeLayout) LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.new_pb_activity, (ViewGroup) null);
        this.bZd.getViewTreeObserver().addOnGlobalLayoutListener(this.eSI);
        this.eIw.addContentView(this.bZd, new FrameLayout.LayoutParams(-1, -1));
        this.cbq = this.eIw.findViewById(d.h.statebar_view);
        this.eQU = (ObservedChangeLinearLayout) this.eIw.findViewById(d.h.title_wrapper);
        this.bFC = (NoNetworkView) this.eIw.findViewById(d.h.view_no_network);
        this.eQl = (PbLandscapeListView) this.eIw.findViewById(d.h.new_pb_list);
        this.ayH = new TextView(this.eIw.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eIw.getActivity(), d.f.ds98));
        this.eQl.addHeaderView(this.ayH, 0);
        View view = new View(this.eIw.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eIw.getResources().getDimensionPixelSize(d.f.ds100)));
        view.setVisibility(4);
        this.eQl.addFooterView(view);
        this.eQl.setOnTouchListener(this.eIw.aMU);
        this.eQh = new com.baidu.tieba.pb.pb.main.view.d(pbActivity);
        this.eSh = new com.baidu.tieba.d.b(pbActivity.getPageContext(), this.eQh.eWr);
        this.eSh.hM(1);
        if (this.eIw.aRl()) {
            this.eQj = (ViewStub) this.eIw.findViewById(d.h.manga_view_stub);
            this.eQj.setVisibility(0);
            this.eQi = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
            this.eQi.show();
            this.eQh.mNavigationBar.setVisibility(8);
            layoutParams.height -= UtilHelper.getLightStatusBarHeight();
        }
        this.ayH.setLayoutParams(layoutParams);
        this.eQh.aVh().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0108a() { // from class: com.baidu.tieba.pb.pb.main.aq.6
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0108a
            public void agp() {
                if (aq.this.eQl != null) {
                    if (aq.this.eQc != null) {
                        aq.this.eQc.aWH();
                    }
                    aq.this.eQl.smoothScrollToPosition(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0108a
            public void ago() {
                aq.this.eIw.afF();
            }
        }));
        this.eRD = this.eIw.findViewById(d.h.pb_editor_tool_comment);
        this.eRK = com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds110);
        this.eRL = com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds156);
        this.eRM = this.eRK;
        this.eRE = (TextView) this.eIw.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_text);
        this.eRF = (ViewGroup) this.eIw.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_reply_layout);
        this.eRH = (TextView) this.eIw.getPageContext().getPageActivity().findViewById(d.h.pb_editor_tool_comment_praise_icon);
        this.eRH.setVisibility(8);
        this.eRF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!aq.this.eIw.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10517").r("obj_locate", 2).aa("fid", aq.this.mForumId));
                } else if (aq.this.eMZ == null || !com.baidu.tieba.pb.f.T(aq.this.eMZ.aPL())) {
                    if (aq.this.Lt != null) {
                        aq.this.aTH();
                    }
                    if (aq.this.Lt != null) {
                        aq.this.eRI = false;
                        com.baidu.tieba.tbadkCore.b.a.a(aq.this.eIw, (View) aq.this.Lt.eE(2).aCe, false, aq.this.eSl);
                    }
                    aq.this.aUe();
                }
            }
        });
        this.eRH.setOnClickListener(this.clm);
        this.eRH.setOnTouchListener(this.eIw);
        this.eQn = LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_item, (ViewGroup) null);
        this.eQr = (LinearLayout) LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.new_pb_header_user_item, (ViewGroup) null);
        this.eQu = new e(this.eIw, this.eQr);
        this.eQu.init();
        this.eQu.b(this.eQu.aQJ(), this.clm);
        this.eQv = (ColumnLayout) this.eQr.findViewById(d.h.pb_head_owner_root);
        this.eQw = (ThreadSkinView) this.eQr.findViewById(d.h.pb_thread_skin);
        this.eQv.setOnLongClickListener(this.onLongClickListener);
        this.eQv.setOnTouchListener(this.aRP);
        this.eQv.setVisibility(8);
        this.eQn.setOnTouchListener(this.aRP);
        this.eRP = this.eQn.findViewById(d.h.pb_head_activity_join_number_container);
        this.eRP.setVisibility(8);
        this.eRQ = (TextView) this.eQn.findViewById(d.h.pb_head_activity_join_number);
        this.eQx = (TextView) this.eQv.findViewById(d.h.pb_head_owner_info_user_name);
        this.eQy = (TextView) this.eQr.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eQz = (TextView) this.eQv.findViewById(d.h.floor_owner);
        this.eQA = (ImageView) this.eQv.findViewById(d.h.icon_forum_level);
        this.eQC = (FrameLayout) this.eQv.findViewById(d.h.pb_head_headImage_container);
        this.eQD = (HeadImageView) this.eQv.findViewById(d.h.pb_head_owner_photo);
        this.eQB = (HeadPendantView) this.eQv.findViewById(d.h.pb_pendant_head_owner_photo);
        this.eQB.wE();
        if (this.eQB.getHeadView() != null) {
            this.eQB.getHeadView().setIsRound(true);
            this.eQB.getHeadView().setDrawBorder(false);
        }
        if (this.eQB.getPendantView() != null) {
            this.eQB.getPendantView().setIsRound(true);
            this.eQB.getPendantView().setDrawBorder(false);
        }
        this.eMe = (UserIconBox) this.eQv.findViewById(d.h.show_icon_vip);
        this.eMf = (UserIconBox) this.eQv.findViewById(d.h.show_icon_yinji);
        this.eQF = (FloatingLayout) this.eQr.findViewById(d.h.pb_head_owner_info_root);
        this.eQK = (PbFirstFloorUserLikeButton) this.eQv.findViewById(d.h.pb_like_button);
        this.eQL = new ao(pbActivity.getPageContext(), this.eQK, 1);
        this.eQM = (TextView) this.eQv.findViewById(d.h.pb_views);
        this.eQN = (TextView) this.eQv.findViewById(d.h.pb_item_first_floor_reply_time);
        this.bEv = (TextView) this.eQv.findViewById(d.h.pb_item_first_floor_location_address);
        this.eSw = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eSx = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.eQR = this.eQn.findViewById(d.h.new_pb_header_item_line_above_livepost);
        this.eQt = LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.layout_read_thread, (ViewGroup) null);
        this.eQs = (TextView) this.eQt.findViewById(d.h.pb_head_read_button);
        this.eQr.addView(this.eQt);
        this.eQs.setOnClickListener(this.clm);
        this.eQa = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds2);
        this.ePZ = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds18);
        this.ePY = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds20);
        this.aRq = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds32);
        this.eQS = this.eQn.findViewById(d.h.new_pb_header_item_line_below_livepost);
        this.eQn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.23
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return false;
            }
        });
        this.eRR = (ViewStub) this.bZd.findViewById(d.h.interview_status_stub);
        this.eQV = new g(this.eIw, this.eQl);
        this.eQV.p(this.clm);
        this.eQV.setTbGestureDetector(this.aRP);
        this.eQV.setOnImageClickListener(this.aRO);
        this.eHv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.VF() || !com.baidu.tieba.c.a.a(aq.this.eIw.getBaseContext(), aq.this.eIw.aQP().getThreadID(), (String) sparseArray.get(d.h.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.h.tag_from, 1);
                                aq.this.eIw.d(sparseArray);
                                return;
                            }
                            aq.this.bg(view2);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.h.tag_from, 0);
                        sparseArray.put(d.h.tag_check_mute_from, 1);
                        aq.this.eIw.d(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.eQV.C(this.eHv);
        aTB();
        this.eQl.addHeaderView(this.eQp);
        this.eQl.addHeaderView(this.eQr);
        this.eQl.addHeaderView(this.eQn);
        this.eRa = new PbListView(this.eIw.getPageContext().getPageActivity());
        this.aIT = this.eRa.getView().findViewById(d.h.pb_more_view);
        if (this.aIT != null) {
            this.aIT.setOnClickListener(this.clm);
            com.baidu.tbadk.core.util.ai.j(this.aIT, d.g.pb_foot_more_trans_selector);
        }
        this.eRa.wT();
        this.eRa.dn(d.g.pb_foot_more_trans_selector);
        this.eRa.m10do(d.g.pb_foot_more_trans_selector);
        this.eRc = this.eIw.findViewById(d.h.viewstub_progress);
        this.eIw.registerListener(this.eSB);
        this.eQE = com.baidu.tbadk.ala.b.nD().h(this.eIw.getActivity(), 2);
        if (this.eQE != null) {
            this.eQE.setVisibility(8);
            this.eQF.addView(this.eQE);
        }
        this.eMC = new PbFakeFloorModel(this.eIw.getPageContext());
        this.eSg = new q(this.eIw.getPageContext(), this.eMC, this.bZd);
        this.eMC.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.25
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                aq.this.eMC.m(postData);
                aq.this.eQV.notifyDataSetChanged();
                aq.this.eSg.aRR();
            }
        });
        if (this.eIw.aQP() != null && !StringUtils.isNull(this.eIw.aQP().aSF())) {
            this.eIw.showToast(this.eIw.aQP().aSF());
        }
        this.eIw.registerListener(this.dGk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTy() {
        if (this.eRV != null) {
            int[] iArr = new int[2];
            this.eRD.getLocationOnScreen(iArr);
            this.eRV.setBottomMargin((((ViewGroup) this.eIw.getPageContext().getPageActivity().getWindow().getDecorView()).getHeight() - this.eRM) - iArr[1]);
        }
    }

    public void aTz() {
        if (this.eQl != null) {
            this.eQl.removeHeaderView(this.eQp);
            this.eQl.removeHeaderView(this.eQr);
            this.eQl.removeHeaderView(this.eQn);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.eRV == null) {
            this.eRV = new com.baidu.tieba.pb.pb.main.emotion.view.c(this.eIw.getPageContext().getPageActivity());
            ViewGroup viewGroup = (ViewGroup) this.eIw.getPageContext().getPageActivity().getWindow().getDecorView();
            int[] iArr = new int[2];
            this.eRD.getLocationOnScreen(iArr);
            this.eRV.a(viewGroup, (viewGroup.getHeight() - this.eRK) - iArr[1], aVar);
            this.eRV.setOnEmotionClickListener(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.26
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.a
                public void cG(List<String> list) {
                    aq.this.eIw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(aq.this.eIw.getPageContext().getPageActivity(), 25016, (ArrayList) list)));
                }
            });
            this.eRV.setOnMoveListener(new c.b() { // from class: com.baidu.tieba.pb.pb.main.aq.27
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.c.b
                public void ag(float f) {
                    if (aq.this.eRD != null) {
                        ViewGroup.LayoutParams layoutParams = aq.this.eRD.getLayoutParams();
                        layoutParams.height = (int) (((aq.this.eRL - aq.this.eRK) * f) + aq.this.eRK);
                        aq.this.eRF.setAlpha(1.0f - f);
                        aq.this.eRD.setLayoutParams(layoutParams);
                        aq.this.eRM = layoutParams.height;
                    }
                }
            });
        }
    }

    private boolean l(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPL() == null || !fVar.aQf() || !TbadkCoreApplication.getInst().isTTSCanUse() || fVar.aPL().rD() == 1 || fVar.aPL().getThreadType() == 33) {
            return false;
        }
        if ((fVar.aPL().rF() == null || fVar.aPL().rF().tf() == 0) && !fVar.aPL().sy()) {
            BdUniqueId type = fVar.aPL().getType();
            return type == bl.Zd || type == bl.Zf || type == bl.Zc;
        }
        return false;
    }

    private void b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (this.eQt != null) {
            if (!z) {
                this.eQt.setVisibility(8);
            } else if (!l(fVar)) {
                this.eQt.setVisibility(8);
            } else if (fVar != null) {
                PostData postData = null;
                if (z && fVar != null && fVar.aPN() != null && fVar.aPN().size() > 0) {
                    postData = fVar.aPN().get(0);
                }
                if (postData != null && postData.bsZ() == 1) {
                    u(this.aRq, this.ePZ, this.aRq, this.eQa);
                } else {
                    u(this.aRq, this.ePZ, this.aRq, this.ePY);
                }
                this.eQt.setVisibility(0);
            }
        }
    }

    private void u(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQs.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.eQs.setLayoutParams(layoutParams);
    }

    public TextView aTA() {
        return this.eQs;
    }

    private void aTB() {
        if (this.eQp == null) {
            int g = com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds34);
            this.eQp = new LinearLayout(this.eIw.getPageContext().getPageActivity());
            this.eQp.setOrientation(1);
            this.eQp.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eQp.setPadding(g, com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds40), g, com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds46));
            this.eQp.setGravity(17);
            this.eQq = new TextView(this.eIw.getPageContext().getPageActivity());
            this.eQq.setGravity(3);
            this.eQq.setMaxLines(2);
            this.eQq.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            this.eQq.setPadding(0, 0, 0, 0);
            this.eQq.setLineSpacing(com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds12), 1.0f);
            com.baidu.tbadk.core.util.ai.i(this.eQq, d.e.cp_cont_b);
            this.eQq.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds48));
            this.eQq.setVisibility(8);
            this.eQp.addView(this.eQq);
            this.eQp.setOnTouchListener(this.aRP);
            this.eQp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTC() {
        if (this.eIw.aRl()) {
            this.eQk = (ViewStub) this.eIw.findViewById(d.h.manga_mention_controller_view_stub);
            this.eQk.setVisibility(0);
            if (this.eQO == null) {
                this.eQO = (LinearLayout) this.eIw.findViewById(d.h.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.eIw.getPageContext(), this.eQO);
            }
            if (this.eQP == null) {
                this.eQP = (TextView) this.eQO.findViewById(d.h.manga_prev_btn);
            }
            if (this.eQQ == null) {
                this.eQQ = (TextView) this.eQO.findViewById(d.h.manga_next_btn);
            }
            this.eQP.setOnClickListener(this.clm);
            this.eQQ.setOnClickListener(this.clm);
        }
    }

    private void aTD() {
        if (this.eIw.aRl()) {
            if (this.eIw.aRo() == -1) {
                com.baidu.tbadk.core.util.ai.c(this.eQP, d.e.cp_cont_e, 1);
            }
            if (this.eIw.aRp() == -1) {
                com.baidu.tbadk.core.util.ai.c(this.eQQ, d.e.cp_cont_e, 1);
            }
        }
    }

    public void aTE() {
        if (this.eQO == null) {
            aTC();
        }
        this.eQk.setVisibility(8);
        if (this.eSz != null && this.eSA != null) {
            this.eSz.removeCallbacks(this.eSA);
        }
    }

    public void aTF() {
        if (this.eSz != null) {
            if (this.eSA != null) {
                this.eSz.removeCallbacks(this.eSA);
            }
            this.eSA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.eQO == null) {
                        aq.this.aTC();
                    }
                    aq.this.eQk.setVisibility(0);
                }
            };
            this.eSz.postDelayed(this.eSA, 2000L);
        }
    }

    public void jG(boolean z) {
        this.eQh.jG(z);
        if (z && this.eRO) {
            this.eRa.setText(this.eIw.getResources().getString(d.l.click_load_more));
            this.eQl.setNextPage(this.eRa);
            this.eQg = 2;
        }
    }

    public void aTG() {
        TbadkCoreApplication.getInst().setReadThreadPlayerScreenMaxHeight(this.bZd.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.Lt = iVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.bZd.addView(this.Lt, layoutParams);
        this.Lt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aTs();
    }

    public void aTH() {
        if (this.eIw != null && this.Lt != null) {
            this.Lt.lS();
            aUe();
        }
    }

    public void T(String str, boolean z) {
        this.eRJ = z;
        aO(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void aO(boolean z) {
        if (this.eRH != null) {
            if (this.eRJ) {
                com.baidu.tbadk.core.util.ai.j(this.eRH, d.g.pb_praise_already_click_selector);
                this.eRH.setContentDescription(this.eIw.getResources().getString(d.l.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ai.j(this.eRH, d.g.pb_praise_normal_click_selector);
            this.eRH.setContentDescription(this.eIw.getResources().getString(d.l.frs_item_praise_text));
        }
    }

    public TextView aTI() {
        return this.eRH;
    }

    public void jH(boolean z) {
        if (this.eQl != null && this.ayH != null && this.cbq != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cbq.setVisibility(0);
                } else {
                    this.cbq.setVisibility(8);
                    this.eQl.removeHeaderView(this.ayH);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ayH.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.ayH.setLayoutParams(layoutParams);
                }
                aTW();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ayH.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jO(true);
                this.ayH.setLayoutParams(layoutParams2);
            }
            aTW();
            aUn();
        }
    }

    public g aTJ() {
        return this.eQV;
    }

    public void aTK() {
        if (this.eQV != null) {
            this.eQV.aRI();
        }
    }

    public void a(PbActivity.c cVar) {
        this.eKj = cVar;
    }

    private void a(bo boVar) {
        if (boVar == null || boVar.tf() == 0) {
            if (this.eRC != null) {
                this.eRC.setVisibility(8);
            }
            if (this.eQR != null) {
                this.eQR.setVisibility(8);
                return;
            }
            return;
        }
        if (this.eRC == null) {
            this.eIw.getLayoutMode().t(((ViewStub) this.eQn.findViewById(d.h.live_talk_layout)).inflate());
            this.eRC = (Button) this.eQn.findViewById(d.h.pb_head_function_manage_go_to_live_post);
            this.eQR = this.eQn.findViewById(d.h.new_pb_header_item_line_above_livepost);
        }
        int tg = boVar.tg();
        String string = this.eIw.getPageContext().getString(d.l.go_to_live_post_prefix);
        if (tg == 0) {
            string = string + this.eIw.getPageContext().getString(d.l.go_to_interview_post);
        } else if (tg == 1) {
            string = string + this.eIw.getPageContext().getString(d.l.go_to_discuss_post);
        }
        this.eRC.setText(string);
        this.eRC.setVisibility(0);
        this.eRC.setOnClickListener(this.clm);
        this.eSF = true;
        aTX();
    }

    public void bg(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.eRe == null) {
            this.eRe = LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
        }
        this.eIw.getLayoutMode().t(this.eRe);
        if (this.eRd == null) {
            this.eRd = new Dialog(this.eIw.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eRd.setCanceledOnTouchOutside(true);
            this.eRd.setCancelable(true);
            this.eRd.setContentView(this.eRe);
            WindowManager.LayoutParams attributes = this.eRd.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.ag(this.eIw.getPageContext().getPageActivity()) * 0.9d);
            this.eRd.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eRd.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eRd.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eRd.findViewById(d.h.disable_reply_btn);
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
                    if (aq.this.eRd != null && (aq.this.eRd instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eRd, aq.this.eIw.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        aq.this.a(((Integer) sparseArray5.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.h.tag_del_post_id), ((Integer) sparseArray5.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name)) || aUk()) {
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
                    if (aq.this.eRd != null && (aq.this.eRd instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eRd, aq.this.eIw.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && aq.this.eSC != null) {
                        aq.this.eSC.g(new Object[]{sparseArray6.get(d.h.tag_manage_user_identity), sparseArray6.get(d.h.tag_forbid_user_name), sparseArray6.get(d.h.tag_forbid_user_post_id)});
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
                    if (aq.this.eRd != null && (aq.this.eRd instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(aq.this.eRd, aq.this.eIw.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        aq.this.eIw.a(z, (String) sparseArray7.get(d.h.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.eRd, this.eIw.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.eSC = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(eRZ, Integer.valueOf(eSa));
        int i3 = d.l.del_post_confirm;
        if (i == 0) {
            i3 = d.l.del_thread_confirm;
        }
        this.eRf = new com.baidu.tbadk.core.dialog.a(this.eIw.getActivity());
        this.eRf.cc(i3);
        this.eRf.A(sparseArray);
        this.eRf.a(d.l.dialog_ok, this.eIw);
        this.eRf.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eRf.ar(true);
        this.eRf.b(this.eIw.getPageContext());
        this.eRf.ts();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.eRr == null) {
            this.eRr = LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.commit_good, (ViewGroup) null);
        }
        this.eIw.getLayoutMode().t(this.eRr);
        if (this.eRq == null) {
            this.eRq = new Dialog(this.eIw.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eRq.setCanceledOnTouchOutside(true);
            this.eRq.setCancelable(true);
            this.eRB = (ScrollView) this.eRr.findViewById(d.h.good_scroll);
            this.eRq.setContentView(this.eRr);
            WindowManager.LayoutParams attributes = this.eRq.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds540);
            this.eRq.getWindow().setAttributes(attributes);
            this.eRt = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.eRw = (String) compoundButton.getTag();
                        if (aq.this.eQm != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : aq.this.eQm) {
                                String str = (String) aVar.getTag();
                                if (str != null && aq.this.eRw != null && !str.equals(aq.this.eRw)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.eRs = (LinearLayout) this.eRr.findViewById(d.h.good_class_group);
            this.eRv = (TextView) this.eRr.findViewById(d.h.dialog_button_cancel);
            this.eRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eRq instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.eRq, aq.this.eIw.getPageContext());
                    }
                }
            });
            this.eRu = (TextView) this.eRr.findViewById(d.h.dialog_button_ok);
            this.eRu.setOnClickListener(this.clm);
        }
        this.eRs.removeAllViews();
        this.eQm = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bO = bO("0", this.eIw.getPageContext().getString(d.l.def_good_class));
        this.eQm.add(bO);
        bO.setChecked(true);
        this.eRs.addView(bO);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.view.a bO2 = bO(String.valueOf(arrayList.get(i2).qb()), arrayList.get(i2).qa());
                this.eQm.add(bO2);
                View view = new View(this.eIw.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds1));
                com.baidu.tbadk.core.util.ai.k(view, d.e.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.eRs.addView(view);
                this.eRs.addView(bO2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.eRB.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eIw.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eIw.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eIw.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.eRB.setLayoutParams(layoutParams2);
            this.eRB.removeAllViews();
            this.eRB.addView(this.eRs);
        }
        com.baidu.adp.lib.g.g.a(this.eRq, this.eIw.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bO(String str, String str2) {
        Activity pageActivity = this.eIw.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.g(pageActivity, d.f.ds100));
        aVar.setOnCheckedChangeListener(this.eRt);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aTL() {
        this.eIw.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eIw.hideProgressBar();
        if (z && z2) {
            this.eIw.showToast(this.eIw.getPageContext().getString(d.l.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.al.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.l.neterror);
            }
            this.eIw.showToast(str);
        }
    }

    public void awq() {
        this.eRc.setVisibility(0);
    }

    public void awp() {
        this.eRc.setVisibility(8);
    }

    public View aTM() {
        if (this.eRr != null) {
            return this.eRr.findViewById(d.h.dialog_button_ok);
        }
        return null;
    }

    public String aTN() {
        return this.eRw;
    }

    public View getView() {
        return this.bZd;
    }

    public void aTO() {
        com.baidu.adp.lib.util.k.b(this.eIw.getPageContext().getPageActivity(), this.eIw.getCurrentFocus());
    }

    public void jI(boolean z) {
        this.eIw.hideProgressBar();
        aBM();
    }

    public void aTP() {
        this.eRa.wT();
        this.eRa.wX();
    }

    public void aTQ() {
        this.eIw.hideProgressBar();
        wY();
        this.eQl.completePullRefreshPostDelayed(2000L);
        aTX();
    }

    public void aTR() {
        this.eQl.completePullRefreshPostDelayed(2000L);
        aTX();
    }

    public void jJ(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eRF.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eIw.getResources().getDimensionPixelSize(d.f.ds84) : 0;
        this.eRF.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.eQV.setOnLongClickListener(onLongClickListener);
    }

    public void a(b.InterfaceC0043b interfaceC0043b, boolean z, boolean z2) {
        if (this.eRx != null) {
            this.eRx.dismiss();
            this.eRx = null;
        }
        this.eRx = new com.baidu.tbadk.core.dialog.b(this.eIw.getPageContext().getPageActivity());
        this.eRx.cf(d.l.operation);
        if (z2) {
            this.eRx.a(new String[]{this.eIw.getPageContext().getString(d.l.copy)}, interfaceC0043b);
        } else if (!z) {
            this.eRx.a(new String[]{this.eIw.getPageContext().getString(d.l.copy), this.eIw.getPageContext().getString(d.l.mark)}, interfaceC0043b);
        } else {
            this.eRx.a(new String[]{this.eIw.getPageContext().getString(d.l.copy), this.eIw.getPageContext().getString(d.l.remove_mark)}, interfaceC0043b);
        }
        this.eRx.d(this.eIw.getPageContext());
        this.eRx.tv();
    }

    public void a(b.InterfaceC0043b interfaceC0043b, boolean z) {
        if (this.eRy != null) {
            this.eRy.dismiss();
            this.eRy = null;
        }
        this.eRy = new com.baidu.tbadk.core.dialog.b(this.eIw.getPageContext().getPageActivity());
        this.eRy.cf(d.l.operation);
        if (z) {
            this.eRy.a(new String[]{this.eIw.getPageContext().getString(d.l.save_to_emotion)}, interfaceC0043b);
        } else {
            this.eRy.a(new String[]{this.eIw.getPageContext().getString(d.l.save_to_emotion), this.eIw.getPageContext().getString(d.l.pb_save_image)}, interfaceC0043b);
        }
        this.eRy.d(this.eIw.getPageContext());
        this.eRy.tv();
    }

    public int aTS() {
        return pt(this.eQl.getFirstVisiblePosition());
    }

    private int pt(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.eQl.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.eQl.getAdapter() == null || !(this.eQl.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.eQl.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aTT() {
        int lastVisiblePosition = this.eQl.getLastVisiblePosition();
        if (this.eQc != null) {
            if (lastVisiblePosition == this.eQl.getCount() - 1) {
                lastVisiblePosition--;
            }
            lastVisiblePosition -= this.eQV.aRJ();
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return pt(lastVisiblePosition);
    }

    public void setSelection(int i) {
        this.eQl.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eQY.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.f fVar) {
        this.eQV.a(fVar, false);
        this.eQV.notifyDataSetChanged();
        aTX();
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        if (this.eQI == null) {
            this.eIw.getLayoutMode().t(((ViewStub) this.eQn.findViewById(d.h.praise_layout)).inflate());
            this.eQI = (FrsPraiseView) this.eQn.findViewById(d.h.pb_head_praise_view);
            this.eQI.setIsFromPb(true);
            this.eQT = this.eQn.findViewById(d.h.new_pb_header_item_line_above_praise);
            this.eQI.dt(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eQI != null) {
            boolean aTX = aTX();
            this.eQI.setVisibility(8);
            if (fVar != null && fVar.qI() != null && fVar.qI().qF() == 0 && this.eHr) {
                if (aTX) {
                    this.eQS.setVisibility(0);
                } else {
                    this.eQS.setVisibility(8);
                }
            } else {
                this.eQS.setVisibility(8);
            }
            com.baidu.tieba.graffiti.b.ar(this.eQS);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null && fVar.aPU() != null) {
            return fVar.aPU();
        }
        if (z) {
            if (fVar == null || fVar.aPN() == null || fVar.aPN().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPN().get(0);
            if (postData.bsZ() != 1) {
                postData = a(fVar);
            }
            if (postData.getAuthor() != null && postData.getAuthor().getUserTbVipInfoData() != null && postData.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                postData.getAuthor().getGodUserData().setIntro(postData.getAuthor().getUserTbVipInfoData().getvipIntro());
                return postData;
            }
            return postData;
        }
        PostData aPS = fVar.aPS();
        if (aPS == null) {
            return a(fVar);
        }
        return aPS;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPL() == null || fVar.aPL().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aPL().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.ts(1);
        postData.setId(fVar.aPL().rW());
        postData.setTitle(fVar.aPL().getTitle());
        postData.setTime(fVar.aPL().getCreateTime());
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
        String e;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.h btc;
        String portrait;
        if (fVar != null && fVar.aPL() != null) {
            PostData c = c(fVar, z);
            a(c, fVar);
            aUl();
            this.eQv.setVisibility(8);
            if (fVar.aPL() != null && fVar.aPL().st() && fVar.aPL().rX() != null) {
                this.eSk = true;
                this.eQh.jY(this.eSk);
                if (this.eQc == null) {
                    this.eQc = new com.baidu.tieba.pb.video.i(this.eIw, this.eQh, fVar.aPL().rX());
                    this.eQc.a(fVar.aPL().rX(), fVar.aPL(), fVar.getForumId());
                    this.eQc.startPlay();
                } else if (this.eQf) {
                    this.eQc.a(fVar.aPL().rX(), fVar.aPL(), fVar.getForumId());
                    this.eQc.startPlay();
                }
                if (fVar.aPM() != null && fVar.aPM().size() >= 1) {
                    bl blVar = fVar.aPM().get(0);
                    this.eQc.ab(blVar);
                    this.eQc.pU(blVar.getTitle());
                }
                this.eQc.b(c, fVar.aPL(), fVar.aQi());
                this.eQf = false;
                this.eQl.removeHeaderView(this.eQc.aWG());
                this.eQl.addHeaderView(this.eQc.aWG(), 0);
                if (this.eQd == null) {
                    this.eQd = new com.baidu.tieba.pb.video.h(this.eIw);
                }
                this.eQd.a(fVar.aPL().sK(), fVar.aPL(), fVar.aQe());
                this.eQl.removeHeaderView(this.eQd.aWx());
                this.eQl.addHeaderView(this.eQd.aWx(), 1);
                if (fVar.aPL().sK() != null) {
                    this.eQl.removeHeaderView(this.eQd.aWy());
                    this.eQl.removeHeaderView(this.eQr);
                    this.eQl.addHeaderView(this.eQd.aWy(), 2);
                } else {
                    if (this.eQd.aWy() != null) {
                        this.eQl.removeHeaderView(this.eQd.aWy());
                    }
                    this.eQl.removeHeaderView(this.eQr);
                    this.eQl.addHeaderView(this.eQr, 2);
                }
                if (this.eQc != null) {
                    this.eQc.pH(0);
                }
                aTW();
            } else {
                this.eSk = false;
                this.eQh.jY(this.eSk);
                this.eQh.eWq.setVisibility(0);
                if (this.eQc != null) {
                    this.eQl.removeHeaderView(this.eQc.aWG());
                }
                if (this.eQd != null) {
                    this.eQd.e(this.eQl);
                }
            }
            if (this.eIw.aQN() != null) {
                this.eIw.aQN().jU(this.eSk);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.eSk) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11923").r("obj_id", 2));
                    }
                    if (aq.this.eIw.eJm.eVG != null) {
                        if (!aq.this.eSk && aq.this.eMZ != null && aq.this.eMZ.aPL() != null && aq.this.eMZ.aPL().getAuthor() != null && aq.this.eMZ.aPL().getAuthor().isBigV()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12151").r("obj_locate", 1));
                        }
                        aq.this.eIw.eJm.eVG.onClick(view);
                    }
                }
            };
            if (this.eQc != null) {
                this.eQc.F(onClickListener);
            }
            b(fVar, z);
            if (c != null) {
                this.eRN = c;
                if (fVar != null && fVar.aPL() != null && fVar.aPL().getAuthor() != null) {
                    fVar.aPL().getAuthor().getUserId();
                    if (fVar.qI() != null) {
                        this.eSp = fVar.qI().qB();
                        if (fVar.qI().qE() == 1) {
                        }
                    }
                }
                this.eQv.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.eQv.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eQv.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_clip_board, c);
                sparseArray.put(d.h.tag_is_subpb, false);
                if (!this.eSu) {
                    this.eQp.setVisibility(0);
                }
                if (!fVar.aPL().st() && this.eQq.getText() != null && this.eQq.getText().length() > 0) {
                    this.eQq.setVisibility(0);
                } else {
                    this.eQq.setVisibility(8);
                }
                n(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rR = fVar.aPL().rR();
                if (rR != null && rR.size() > 0 && !this.eSu) {
                    this.eRQ.setText(String.valueOf(rR.get(0).ps()));
                    this.eRP.setVisibility(0);
                    this.eSE = true;
                } else {
                    this.eRP.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ai.j(this.eRP, d.g.activity_join_num_bg);
                com.baidu.tbadk.core.util.ai.c(this.eRQ, d.e.cp_link_tip_d, 1);
                if (c.getAuthor() != null) {
                    this.rank = c.getAuthor().getLevel_id();
                    String string = c.getAuthor().getName_show() == null ? StringUtils.string(c.getAuthor().getUserName()) : StringUtils.string(c.getAuthor().getName_show());
                    if (StringUtils.isNull(c.getAuthor().getSealPrefix())) {
                        i2 = 0;
                    } else {
                        i2 = com.baidu.adp.lib.util.j.aT(c.getAuthor().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.j.aT(string) > 12) {
                            e = com.baidu.tbadk.core.util.al.e(string, 12, "...");
                            int i3 = 3;
                            if (!StringUtils.isNull(string)) {
                                int aT = com.baidu.adp.lib.util.j.aT(c.getAuthor().getName_show());
                                if (aT + i2 > 14) {
                                    i3 = 0;
                                } else if (aT + i2 >= 12) {
                                    i3 = 1;
                                } else if (aT + i2 >= 10) {
                                    i3 = 2;
                                }
                            }
                            ArrayList<IconData> iconInfo = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eMf != null) {
                                this.eMf.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                                this.eMf.setOnClickListener(this.eIw.eJm.cta);
                                this.eMf.a(iconInfo, i3, this.eIw.getResources().getDimensionPixelSize(d.f.ds26), this.eIw.getResources().getDimensionPixelSize(d.f.ds26), this.eIw.getResources().getDimensionPixelSize(d.f.ds8));
                            }
                            if (this.eMe != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eMe.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eMe.setOnClickListener(this.eIw.eJm.eVH);
                                this.eMe.a(tShowInfoNew, 3, this.eIw.getResources().getDimensionPixelSize(d.f.ds36), this.eIw.getResources().getDimensionPixelSize(d.f.ds36), this.eIw.getResources().getDimensionPixelSize(d.f.ds8), true);
                            }
                            this.eQx.setText(ae(c.getAuthor().getSealPrefix(), e));
                            this.eQx.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                            this.eQx.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.u.v(tShowInfoNew) || c.getAuthor().isBigV()) {
                                com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_cont_f, 1);
                            }
                            if (c == null && !TextUtils.isEmpty(c.getAuthor().getGodIntro())) {
                                this.eQy.setVisibility(0);
                                this.eQy.setText(ap.a(c.getAuthor()));
                            } else {
                                this.eQy.setVisibility(8);
                            }
                            com.baidu.tbadk.core.util.ai.c(this.eQz, d.e.cp_link_tip_a, 1);
                            this.eQz.setVisibility(0);
                            if (fVar.aPL().getAuthor() != null && fVar.aPL().getAuthor().getAlaUserData() != null && this.eQE != null) {
                                if (fVar.aPL().getAuthor().getAlaUserData().anchor_live != 0) {
                                    this.eQE.setVisibility(8);
                                } else {
                                    this.eQE.setVisibility(0);
                                    if (this.eQe == null) {
                                        this.eQe = new com.baidu.tieba.d.b(this.eIw.getPageContext(), this.eQE);
                                        this.eQe.hM(1);
                                    }
                                    this.eQe.aI(this.eIw.getResources().getString(d.l.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Rq = fVar.aPL().getAuthor().getAlaUserData();
                                    aVar.type = 2;
                                    this.eQE.setTag(aVar);
                                }
                            }
                            this.eQD.setUserId(c.getAuthor().getUserId());
                            this.eQD.setUserName(c.getAuthor().getUserName());
                            this.eQD.setImageDrawable(null);
                            this.eQD.setRadius(com.baidu.adp.lib.util.k.g(this.eIw.getActivity(), d.f.ds40));
                            this.eQD.setTag(c.getAuthor().getUserId());
                            this.eQN.setText(c.btb());
                            btc = c.btc();
                            if (btc == null && !TextUtils.isEmpty(btc.getName()) && !TextUtils.isEmpty(btc.getName().trim())) {
                                final String name = btc.getName();
                                final String lat = btc.getLat();
                                final String lng = btc.getLng();
                                this.bEv.setVisibility(0);
                                this.bEv.setText(btc.getName());
                                this.bEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.i.hr()) {
                                                aq.this.eIw.showToast(d.l.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.T(aq.this.eIw.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, aq.this.eIw.getPageContext().getString(d.l.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.bEv.setVisibility(8);
                            }
                            this.eQL.a(c.getAuthor());
                            this.eQL.ePV = this.eSk;
                            if (!this.eRA) {
                                this.eQK.setVisibility(8);
                                this.eQM.setVisibility(0);
                                this.eQM.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_thread_views), com.baidu.tbadk.core.util.al.x(fVar.aQh())));
                            } else if (!PbNormalLikeButtonSwitchStatic.GS() || (c.getAuthor().hadConcerned() && c.getAuthor().getGodUserData() != null && c.getAuthor().getGodUserData().getIsFromNetWork())) {
                                this.eQK.setVisibility(8);
                                this.eQM.setVisibility(8);
                            } else {
                                this.eQK.setVisibility(0);
                                this.eQK.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eIw.getActivity(), d.f.ds24));
                                this.eQM.setVisibility(8);
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null && !StringUtils.isNull(c.getAuthor().getPendantData().pW())) {
                                UtilHelper.showHeadImageViewBigV(this.eQB.getHeadView(), c.getAuthor());
                                this.eQD.setVisibility(8);
                                this.eQB.setVisibility(0);
                                if (this.eQJ != null) {
                                    this.eQJ.setVisibility(8);
                                }
                                this.eQx.setOnClickListener(onClickListener);
                                this.eQB.getHeadView().c(portrait, 28, false);
                                this.eQB.getHeadView().setUserId(c.getAuthor().getUserId());
                                this.eQB.getHeadView().setUserName(c.getAuthor().getUserName());
                                this.eQB.getHeadView().setOnClickListener(onClickListener);
                                this.eQB.ex(c.getAuthor().getPendantData().pW());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.eQD, c.getAuthor());
                                this.eQD.setVisibility(0);
                                this.eQv.setOnClickListener(onClickListener);
                                this.eQx.setOnClickListener(onClickListener);
                                this.eQD.setOnClickListener(onClickListener);
                                this.eQB.setVisibility(8);
                                this.eQD.c(portrait, 28, false);
                            }
                            String name_show = c.getAuthor().getName_show();
                            String userName = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ab.ge() && name_show != null && !name_show.equals(userName)) {
                                this.eQx.setText(com.baidu.tieba.pb.d.ao(this.eIw.getPageContext().getPageActivity(), this.eQx.getText().toString()));
                                this.eQx.setGravity(16);
                                this.eQx.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aPm());
                                com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_other_e, 1);
                            }
                        }
                        e = string;
                        int i32 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo2 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eMf != null) {
                        }
                        if (this.eMe != null) {
                        }
                        this.eQx.setText(ae(c.getAuthor().getSealPrefix(), e));
                        this.eQx.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                        this.eQx.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eQy.setVisibility(8);
                        com.baidu.tbadk.core.util.ai.c(this.eQz, d.e.cp_link_tip_a, 1);
                        this.eQz.setVisibility(0);
                        if (fVar.aPL().getAuthor() != null) {
                            if (fVar.aPL().getAuthor().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.eQD.setUserId(c.getAuthor().getUserId());
                        this.eQD.setUserName(c.getAuthor().getUserName());
                        this.eQD.setImageDrawable(null);
                        this.eQD.setRadius(com.baidu.adp.lib.util.k.g(this.eIw.getActivity(), d.f.ds40));
                        this.eQD.setTag(c.getAuthor().getUserId());
                        this.eQN.setText(c.btb());
                        btc = c.btc();
                        if (btc == null) {
                        }
                        this.bEv.setVisibility(8);
                        this.eQL.a(c.getAuthor());
                        this.eQL.ePV = this.eSk;
                        if (!this.eRA) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eQD, c.getAuthor());
                        this.eQD.setVisibility(0);
                        this.eQv.setOnClickListener(onClickListener);
                        this.eQx.setOnClickListener(onClickListener);
                        this.eQD.setOnClickListener(onClickListener);
                        this.eQB.setVisibility(8);
                        this.eQD.c(portrait, 28, false);
                        String name_show2 = c.getAuthor().getName_show();
                        String userName2 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ab.ge()) {
                            this.eQx.setText(com.baidu.tieba.pb.d.ao(this.eIw.getPageContext().getPageActivity(), this.eQx.getText().toString()));
                            this.eQx.setGravity(16);
                            this.eQx.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aPm());
                            com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.j.aT(string) > 14) {
                            e = com.baidu.tbadk.core.util.al.e(string, 14, "...");
                            int i322 = 3;
                            if (!StringUtils.isNull(string)) {
                            }
                            ArrayList<IconData> iconInfo22 = c.getAuthor().getIconInfo();
                            tShowInfoNew = c.getAuthor().getTShowInfoNew();
                            if (this.eMf != null) {
                            }
                            if (this.eMe != null) {
                            }
                            this.eQx.setText(ae(c.getAuthor().getSealPrefix(), e));
                            this.eQx.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                            this.eQx.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                            if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_cont_h, 1);
                            if (c == null) {
                            }
                            this.eQy.setVisibility(8);
                            com.baidu.tbadk.core.util.ai.c(this.eQz, d.e.cp_link_tip_a, 1);
                            this.eQz.setVisibility(0);
                            if (fVar.aPL().getAuthor() != null) {
                            }
                            this.eQD.setUserId(c.getAuthor().getUserId());
                            this.eQD.setUserName(c.getAuthor().getUserName());
                            this.eQD.setImageDrawable(null);
                            this.eQD.setRadius(com.baidu.adp.lib.util.k.g(this.eIw.getActivity(), d.f.ds40));
                            this.eQD.setTag(c.getAuthor().getUserId());
                            this.eQN.setText(c.btb());
                            btc = c.btc();
                            if (btc == null) {
                            }
                            this.bEv.setVisibility(8);
                            this.eQL.a(c.getAuthor());
                            this.eQL.ePV = this.eSk;
                            if (!this.eRA) {
                            }
                            portrait = c.getAuthor().getPortrait();
                            if (c.getAuthor().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.eQD, c.getAuthor());
                            this.eQD.setVisibility(0);
                            this.eQv.setOnClickListener(onClickListener);
                            this.eQx.setOnClickListener(onClickListener);
                            this.eQD.setOnClickListener(onClickListener);
                            this.eQB.setVisibility(8);
                            this.eQD.c(portrait, 28, false);
                            String name_show22 = c.getAuthor().getName_show();
                            String userName22 = c.getAuthor().getUserName();
                            if (com.baidu.tbadk.p.ab.ge()) {
                            }
                        }
                        e = string;
                        int i3222 = 3;
                        if (!StringUtils.isNull(string)) {
                        }
                        ArrayList<IconData> iconInfo222 = c.getAuthor().getIconInfo();
                        tShowInfoNew = c.getAuthor().getTShowInfoNew();
                        if (this.eMf != null) {
                        }
                        if (this.eMe != null) {
                        }
                        this.eQx.setText(ae(c.getAuthor().getSealPrefix(), e));
                        this.eQx.setTag(d.h.tag_user_id, c.getAuthor().getUserId());
                        this.eQx.setTag(d.h.tag_user_name, c.getAuthor().getName_show());
                        if (com.baidu.tbadk.core.util.u.v(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ai.c(this.eQx, d.e.cp_cont_h, 1);
                        if (c == null) {
                        }
                        this.eQy.setVisibility(8);
                        com.baidu.tbadk.core.util.ai.c(this.eQz, d.e.cp_link_tip_a, 1);
                        this.eQz.setVisibility(0);
                        if (fVar.aPL().getAuthor() != null) {
                        }
                        this.eQD.setUserId(c.getAuthor().getUserId());
                        this.eQD.setUserName(c.getAuthor().getUserName());
                        this.eQD.setImageDrawable(null);
                        this.eQD.setRadius(com.baidu.adp.lib.util.k.g(this.eIw.getActivity(), d.f.ds40));
                        this.eQD.setTag(c.getAuthor().getUserId());
                        this.eQN.setText(c.btb());
                        btc = c.btc();
                        if (btc == null) {
                        }
                        this.bEv.setVisibility(8);
                        this.eQL.a(c.getAuthor());
                        this.eQL.ePV = this.eSk;
                        if (!this.eRA) {
                        }
                        portrait = c.getAuthor().getPortrait();
                        if (c.getAuthor().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.eQD, c.getAuthor());
                        this.eQD.setVisibility(0);
                        this.eQv.setOnClickListener(onClickListener);
                        this.eQx.setOnClickListener(onClickListener);
                        this.eQD.setOnClickListener(onClickListener);
                        this.eQB.setVisibility(8);
                        this.eQD.c(portrait, 28, false);
                        String name_show222 = c.getAuthor().getName_show();
                        String userName222 = c.getAuthor().getUserName();
                        if (com.baidu.tbadk.p.ab.ge()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.eQu.V(fVar.aPL());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.sb() != null) {
            this.eQw.a(this.eIw.getPageContext(), fVar.aPN().get(0).sb(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aPJ().getId(), fVar.aPJ().getName(), fVar.aPL().getId(), this.eIw.aRv() ? "FRS" : null));
            this.eQv.setPadding(this.eQv.getPaddingLeft(), (int) this.eIw.getResources().getDimension(d.f.ds20), this.eQv.getPaddingRight(), this.eQv.getPaddingBottom());
            return;
        }
        this.eQw.a(null, null, null);
    }

    public void aTU() {
        if (this.eQc != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11997").r("obj_type", 1));
            this.eQc.aWH();
            this.eQl.smoothScrollToPosition(0);
        }
    }

    public boolean aTV() {
        return this.eSG;
    }

    private boolean OR() {
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
            this.eQh.aVl();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.eQh.nd(eVar.forumName);
            }
            String string = this.eIw.getResources().getString(d.l.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eIw.getResources().getString(d.l.self);
                    break;
                case 300:
                    str = this.eIw.getResources().getString(d.l.bawu);
                    break;
                case 400:
                    str = this.eIw.getResources().getString(d.l.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.eFG;
            this.eIw.showNetRefreshView(this.bZd, format, null, this.eIw.getResources().getString(d.l.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.k.hI()) {
                        com.baidu.tbadk.core.util.at.wg().c(aq.this.eIw.getPageContext(), new String[]{str2});
                        aq.this.eIw.finish();
                        return;
                    }
                    aq.this.eIw.showToast(d.l.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aTm;
        String str;
        if (fVar != null) {
            this.eMZ = fVar;
            this.mType = i;
            if (fVar.aPL() != null) {
                this.eRW = fVar.aPL().rt();
                this.aam = fVar.aPL().rq();
                if (fVar.aPL().getAnchorLevel() != 0) {
                    this.eSG = true;
                }
                this.eRA = O(fVar.aPL());
                if (this.eQL != null && fVar.aPL().getAuthor() != null) {
                    this.eQL.isBigV = fVar.aPL().getAuthor().isBigV();
                }
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            p(fVar);
            this.eRO = false;
            this.eHr = z;
            aTQ();
            b(fVar, z, i);
            if (this.eIw.aRl()) {
                if (this.eQZ == null) {
                    this.eQZ = new com.baidu.tieba.pb.view.j(this.eIw.getPageContext());
                    this.eQZ.lj();
                    this.eQZ.a(this.anN);
                }
                this.eQl.setPullRefresh(this.eQZ);
                aTW();
                if (this.eQZ != null) {
                    this.eQZ.dp(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qI().qF() == 0 && z) {
                this.eQl.setPullRefresh(null);
                this.eQb = 1;
            } else {
                if (this.eQZ == null) {
                    this.eQZ = new com.baidu.tieba.pb.view.j(this.eIw.getPageContext());
                    this.eQZ.lj();
                    this.eQZ.a(this.anN);
                }
                this.eQl.setPullRefresh(this.eQZ);
                aTW();
                this.eQb = 2;
                if (this.eQZ != null) {
                    this.eQZ.dp(TbadkCoreApplication.getInst().getSkinType());
                }
                Rq();
            }
            aTX();
            this.eQV.iT(this.eHr);
            this.eQV.iU(false);
            this.eQV.jf(i == 5);
            this.eQV.jg(i == 6);
            this.eQV.a(fVar, false);
            this.eQV.notifyDataSetChanged();
            if (this.eIw.aRz()) {
                if (fVar.aPK() != null) {
                    this.mForumName = fVar.aPK().getForumName();
                    this.mForumId = fVar.aPK().getForumId();
                }
                if (this.mForumName == null && this.eIw.aQP() != null && this.eIw.aQP().aRZ() != null) {
                    this.mForumName = this.eIw.aQP().aRZ();
                }
                this.eQh.nd(this.mForumName);
            } else {
                this.eQh.nd(null);
            }
            if (this.eIw.aRz()) {
                int i4 = 0;
                PostData c = c(fVar, z);
                if (c != null && c.getAuthor() != null) {
                    i4 = c.getAuthor().getLevel_id();
                }
                if (i4 > 0) {
                    this.eQA.setVisibility(0);
                    com.baidu.tbadk.core.util.ai.c(this.eQA, BitmapHelper.getGradeResourceIdInEnterForum(i4));
                } else {
                    this.eQA.setVisibility(8);
                }
            } else {
                this.eQA.setVisibility(8);
            }
            if (fVar.aPL() != null && fVar.aPL().rw() != null) {
                if (fVar.aPL().rw().getNum() < 1) {
                    str = this.eIw.getResources().getString(d.l.frs_item_praise_text);
                } else {
                    str = fVar.aPL().rw().getNum() + "";
                }
                if (this.ePX != -1) {
                    fVar.aPL().rw().setIsLike(this.ePX);
                }
                T(str, fVar.aPL().rw().getIsLike() == 1);
            }
            if (fVar.qI().qE() == 0 && !z) {
                this.eQl.setNextPage(null);
                this.eQg = 1;
            } else if (this.eIw.isLogin()) {
                this.eQl.setNextPage(this.eRa);
                this.eQg = 2;
                Rq();
            } else if (fVar.qI().qE() == 1) {
                this.eRO = true;
                if (this.eRb == null) {
                    this.eRb = new com.baidu.tieba.pb.view.b(this.eIw.getPageContext());
                }
                this.eQl.setNextPage(this.eRb);
                this.eQg = 3;
            }
            ArrayList<PostData> aPN = fVar.aPN();
            if (fVar.qI().qE() == 0 || aPN == null || aPN.size() < fVar.qI().qD()) {
                if (com.baidu.tbadk.core.util.u.u(aPN) == 0 || (com.baidu.tbadk.core.util.u.u(aPN) == 1 && aPN.get(0) != null && aPN.get(0).bsZ() == 1)) {
                    this.eRa.setText(this.eIw.getResources().getString(d.l.list_no_more_new));
                } else {
                    this.eRa.setText("");
                }
                if (this.eIw.aRl() && this.eQl != null && this.eQl.getData() != null && this.eQl.getData().size() == 1 && (this.eQl.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.eRa.setText("");
                }
                aUc();
            } else if (z2) {
                if (this.eSD) {
                    wY();
                    if (fVar.qI().qE() != 0) {
                        this.eRa.setText(this.eIw.getResources().getString(d.l.pb_load_more));
                    }
                } else {
                    this.eRa.wT();
                    this.eRa.showLoading();
                }
            } else {
                this.eRa.wT();
                this.eRa.showLoading();
            }
            if (fVar.aPL() != null && fVar.aPL().getAuthor() != null && fVar.aPL().getAuthor().getType() == 0) {
                this.eQh.aVi();
            }
            switch (i) {
                case 2:
                    int i5 = 0;
                    if (this.eQl.getData() != null || fVar.aPN() != null) {
                        i5 = (this.eQl.getData().size() - fVar.aPN().size()) + this.eQl.getHeaderViewsCount();
                    }
                    this.eQl.setSelection(i2 > 1 ? (i5 + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aTm = ai.aTl().aTm()) != null) {
                        this.eSy = true;
                        this.eQl.onRestoreInstanceState(aTm);
                        break;
                    } else {
                        this.eQl.setSelection(0);
                        break;
                    }
                case 4:
                    this.eSD = false;
                    break;
                case 5:
                    this.eQl.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1) {
                        Parcelable aTm2 = ai.aTl().aTm();
                        this.eSy = true;
                        if (aTm2 != null) {
                            this.eQl.onRestoreInstanceState(aTm2);
                            break;
                        }
                    }
                    this.eQl.setSelection(0);
                    break;
            }
            if (this.eSj >= 0) {
                this.eQl.setSelectionFromTop(this.eSj, (int) this.eSi);
                this.eSj = -1;
            }
            if (this.eRW == eRY && OR()) {
                aUf();
            }
            if (this.eQd != null) {
                this.eQd.aa(fVar.aPL());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aTW() {
        if (this.eQc != null && this.eQc.aWG() != null) {
            this.eQl.removeHeaderView(this.ayH);
            if (this.mType != 1) {
                this.eQl.removeHeaderView(this.eQc.aWG());
                this.eQl.addHeaderView(this.eQc.aWG(), 0);
                this.eQl.setSelection(0);
                return;
            }
            return;
        }
        if (this.eQc != null) {
            this.eQl.removeHeaderView(this.eQc.aWG());
        }
        this.eQl.removeHeaderView(this.ayH);
        this.eQl.addHeaderView(this.ayH, 0);
    }

    public void jK(boolean z) {
        this.eRz = z;
        this.eQh.jK(z);
    }

    public void wY() {
        if (this.eRa != null) {
            this.eRa.wU();
            this.eRa.wY();
        }
        Rq();
    }

    public void Nr() {
        this.eQl.setVisibility(0);
    }

    private boolean aTX() {
        boolean z;
        if (this.eRC != null && this.eRC.getVisibility() == 0) {
            if (this.eQR != null) {
                this.eQR.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.eQR != null) {
                this.eQR.setVisibility(8);
            }
            z = false;
        }
        if ((this.eQT == null || this.eQT.getVisibility() == 8) && z && this.eHr) {
            this.eQS.setVisibility(0);
        } else {
            this.eQS.setVisibility(8);
        }
        com.baidu.tieba.graffiti.b.ar(this.eQS);
        return z;
    }

    private boolean o(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPL() == null) {
            return false;
        }
        if (fVar.aPL().rD() == 1 || fVar.aPL().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aPL().rF() == null || fVar.aPL().rF().tf() == 0) || fVar.aPL().rB() == 1 || fVar.aPL().rC() == 1 || fVar.aPL().sl() || fVar.aPL().sy() || fVar.aPL().ss() || fVar.aPL().rS() != null || fVar.aPL().sz() || fVar.aPL().sz() || !com.baidu.tbadk.core.util.al.isEmpty(fVar.aPL().getCategory()) || fVar.aPL().rJ() || fVar.aPL().rI();
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return com.baidu.tieba.card.m.a((Context) this.eIw.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.eQp != null) {
                if (fVar.aPL() != null && fVar.aPL().rV() == 0 && !fVar.aPL().st() && !this.eSu) {
                    this.eQp.setVisibility(0);
                    if (fVar.aPL() != null) {
                        fVar.aPL().e(true, o(fVar));
                    }
                    SpannableStringBuilder sg = fVar.aPL().sg();
                    this.eQq.setOnTouchListener(new com.baidu.tieba.view.l(sg));
                    this.eQq.setText(sg);
                    this.eQq.setVisibility(0);
                } else if (fVar.aPL().rV() == 1) {
                    if (fVar.aPL() != null) {
                        fVar.aPL().e(true, o(fVar));
                        SpannableStringBuilder sg2 = fVar.aPL().sg();
                        if (sg2 == null || sg2.length() == 0) {
                            this.eQp.setVisibility(8);
                            this.eQl.removeHeaderView(this.eQp);
                            if (fVar.aPL() != null && !fVar.aPL().st()) {
                                this.eQv.setPadding(this.eQv.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds48), this.eQv.getPaddingRight(), this.eQv.getPaddingBottom());
                            }
                        } else {
                            this.eQp.setVisibility(0);
                            this.eQq.setOnTouchListener(new com.baidu.tieba.view.l(sg2));
                            this.eQq.setText(sg2);
                            this.eQq.setVisibility(0);
                        }
                    }
                } else {
                    this.eQp.setVisibility(8);
                    this.eQl.removeHeaderView(this.eQp);
                    if (fVar.aPL() != null && fVar.aPL().st()) {
                        this.eQv.setPadding(this.eQv.getPaddingLeft(), 0, this.eQv.getPaddingRight(), this.eQv.getPaddingBottom());
                    } else {
                        this.eQv.setPadding(this.eQv.getPaddingLeft(), com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds48), this.eQv.getPaddingRight(), this.eQv.getPaddingBottom());
                    }
                }
            }
            this.eHr = z;
            bl aPL = fVar.aPL();
            if (aPL != null) {
                a(aPL.rF());
            }
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            d(fVar, z);
            aTX();
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
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPW()));
            sparseArray.put(d.h.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (c.getAuthor() != null) {
                sparseArray.put(d.h.tag_forbid_user_name, c.getAuthor().getUserName());
                sparseArray.put(d.h.tag_forbid_user_post_id, c.getId());
            }
            sparseArray.put(d.h.tag_del_post_id, c.getId());
            sparseArray.put(d.h.tag_del_post_type, 0);
            sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(fVar.aPW()));
            sparseArray.put(d.h.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aIT;
    }

    public void pD(String str) {
        if (this.eRa != null) {
            this.eRa.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.eQl;
    }

    public int aTY() {
        return d.h.richText;
    }

    public TextView aQJ() {
        return this.eQu.aQJ();
    }

    public void d(BdListView.e eVar) {
        this.eQl.setOnSrollToBottomListener(eVar);
    }

    public void a(k.b bVar) {
        this.anN = bVar;
        if (this.eQZ != null) {
            this.eQZ.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ar arVar, a.b bVar) {
        if (arVar != null) {
            int qC = arVar.qC();
            int qz = arVar.qz();
            if (this.eQW != null) {
                this.eQW.ts();
            } else {
                this.eQW = new com.baidu.tbadk.core.dialog.a(this.eIw.getPageContext().getPageActivity());
                this.eQX = LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.dialog_direct_pager, (ViewGroup) null);
                this.eQW.v(this.eQX);
                this.eQW.a(d.l.dialog_ok, bVar);
                this.eQW.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.aBM();
                        aVar.dismiss();
                    }
                });
                this.eQW.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.eSe == null) {
                            aq.this.eSe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.eIw.HidenSoftKeyPad((InputMethodManager) aq.this.eIw.getSystemService("input_method"), aq.this.bZd);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.ga().postDelayed(aq.this.eSe, 150L);
                    }
                });
                this.eQW.b(this.eIw.getPageContext()).ts();
            }
            this.eQY = (EditText) this.eQX.findViewById(d.h.input_page_number);
            this.eQY.setText("");
            TextView textView = (TextView) this.eQX.findViewById(d.h.current_page_number);
            if (qC <= 0) {
                qC = 1;
            }
            if (qz <= 0) {
                qz = 1;
            }
            textView.setText(MessageFormat.format(this.eIw.getApplicationContext().getResources().getString(d.l.current_page), Integer.valueOf(qC), Integer.valueOf(qz)));
            this.eIw.ShowSoftKeyPadDelay(this.eQY, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eQl.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eIw.showToast(str);
    }

    public boolean jL(boolean z) {
        if (this.Lt == null || !this.Lt.Dd()) {
            return false;
        }
        this.Lt.Bu();
        return true;
    }

    public void aTZ() {
        if (this.eSH != null) {
            while (this.eSH.size() > 0) {
                TbImageView remove = this.eSH.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aTZ();
        this.eQV.pf(1);
        if (this.eQc != null) {
            this.eQc.onPause();
        }
    }

    public void onResume() {
        this.eQV.pf(2);
        if (this.eQc != null) {
            this.eQc.onResume();
        }
        if (this.eRV != null) {
            this.eRV.onResume();
        }
    }

    public void onDestroy() {
        this.eSh.YA();
        if (this.eQe != null) {
            this.eQe.YA();
        }
        if (this.eQd != null) {
            this.eQd.onDestroy();
        }
        this.eIw.hideProgressBar();
        if (this.bFC != null && this.bFF != null) {
            this.bFC.b(this.bFF);
        }
        aBM();
        wY();
        if (this.eSe != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eSe);
        }
        if (this.eSf != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eSf);
        }
        if (this.eSt != null) {
            this.eSt.removeAllViews();
        }
        if (this.eQv != null && this.eQJ != null) {
            this.eQv.removeView(this.eQC);
            this.eQJ = null;
        }
        if (this.eRS != null) {
            this.eRS.clearStatus();
        }
        this.eSz = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eQV.pf(3);
        if (this.cbq != null) {
            this.cbq.setBackgroundDrawable(null);
        }
        if (this.eQc != null) {
            this.eQc.destroy();
        }
        if (this.eQV != null) {
            this.eQV.onDestory();
        }
        this.bZd.getViewTreeObserver().removeGlobalOnLayoutListener(this.eSI);
    }

    public boolean pu(int i) {
        if (this.eQc != null) {
            return this.eQc.pN(i);
        }
        return false;
    }

    public void aBM() {
        this.eQh.or();
        this.eSh.YA();
        if (this.eQe != null) {
            this.eQe.YA();
        }
        com.baidu.adp.lib.util.k.b(this.eIw.getPageContext().getPageActivity(), this.eQY);
        if (this.eRx != null) {
            this.eRx.dismiss();
        }
        aUa();
        if (this.eQd != null) {
            this.eQd.aWz();
        }
        if (this.eQW != null) {
            this.eQW.dismiss();
        }
        if (this.cll != null) {
            this.cll.dismiss();
        }
    }

    public void iS(boolean z) {
        this.eQV.iS(z);
    }

    public void hk(boolean z) {
        this.dLA = z;
    }

    public void aUa() {
        if (this.eRf != null) {
            this.eRf.dismiss();
        }
        if (this.eRg != null) {
            com.baidu.adp.lib.g.g.b(this.eRg, this.eIw.getPageContext());
        }
        if (this.eRq != null) {
            com.baidu.adp.lib.g.g.b(this.eRq, this.eIw.getPageContext());
        }
        if (this.eRd != null) {
            com.baidu.adp.lib.g.g.b(this.eRd, this.eIw.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.eMZ, this.eHr);
            d(this.eMZ, this.eHr, this.mType);
            this.eIw.getLayoutMode().ah(i == 1);
            this.eIw.getLayoutMode().t(this.bZd);
            this.eIw.getLayoutMode().t(this.eQq);
            this.eIw.getLayoutMode().t(this.eQr);
            this.eIw.getLayoutMode().t(this.eQn);
            if (this.eQH != null) {
                com.baidu.tbadk.core.util.ai.c(this.eQH, d.e.cp_cont_d, 1);
            }
            if (this.eQG != null) {
                com.baidu.tbadk.core.util.ai.c(this.eQG, d.e.cp_cont_d, 1);
            }
            if (this.eQd != null) {
                this.eQd.onChangeSkinType(i);
            }
            this.eIw.getLayoutMode().t(this.eQn);
            com.baidu.tbadk.core.util.ai.i(this.eQq, d.e.cp_cont_b);
            this.eQq.setLinkTextColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_link_tip_c));
            this.eIw.getLayoutMode().t(this.aIT);
            if (this.eQX != null) {
                this.eIw.getLayoutMode().t(this.eQX);
            }
            jK(this.eRz);
            this.eQV.notifyDataSetChanged();
            if (this.eQZ != null) {
                this.eQZ.dp(i);
            }
            if (this.eRa != null) {
                this.eRa.dp(i);
                com.baidu.tbadk.core.util.ai.j(this.aIT, d.g.pb_foot_more_trans_selector);
                this.eRa.dn(d.g.pb_foot_more_trans_selector);
            }
            if (this.Lt != null) {
                this.Lt.onChangeSkinType(i);
            }
            if (this.eQI != null) {
                this.eQI.dt(i);
            }
            if (this.eRb != null) {
                this.eRb.dp(i);
            }
            if (this.eQm != null && this.eQm.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.eQm) {
                    aVar.aVc();
                }
            }
            if (this.eSt != null) {
                com.baidu.tbadk.core.util.ai.k(this.eSt, d.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ai.k(this.eSr, d.e.cp_bg_line_c);
                com.baidu.tbadk.core.util.ai.c(this.eSs, d.e.cp_cont_c, 1);
            }
            aO(i == 1);
            aTD();
            UtilHelper.setStatusBarBackground(this.cbq, i);
            if (this.eQK != null) {
                this.eQK.onChangeSkinType(i);
            }
            if (this.bEv != null) {
                com.baidu.tbadk.core.util.ai.i(this.bEv, d.e.cp_cont_d);
            }
            if (this.eQN != null) {
                com.baidu.tbadk.core.util.ai.i(this.eQN, d.e.cp_cont_f);
            }
            if (this.eQz != null) {
                com.baidu.tbadk.core.util.ai.i(this.eQz, d.e.cp_link_tip_a);
            }
            if (this.eQM != null) {
                com.baidu.tbadk.core.util.ai.i(this.eQM, d.e.cp_cont_f);
            }
            if (this.eQO != null) {
                com.baidu.tbadk.o.a.a(this.eIw.getPageContext(), this.eQO);
            }
            if (this.eSg != null) {
                this.eSg.onChangeSkinType(i);
            }
            if (this.eQh != null) {
                if (this.eQc != null) {
                    this.eQc.pH(i);
                } else {
                    this.eQh.onChangeSkinType(i);
                }
            }
            com.baidu.tbadk.core.util.ai.i(this.eQy, d.e.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRO = eVar;
        this.eQV.setOnImageClickListener(this.aRO);
    }

    public void c(NoNetworkView.a aVar) {
        this.bFF = aVar;
        if (this.bFC != null) {
            this.bFC.a(this.bFF);
        }
    }

    public void jM(boolean z) {
        this.eQV.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aUb() {
        return this.eRC;
    }

    public void aUc() {
        if (this.eQg != 2) {
            this.eQl.setNextPage(this.eRa);
            this.eQg = 2;
        }
    }

    public void aUd() {
        if (com.baidu.tbadk.l.r.Gz().GA()) {
            int lastVisiblePosition = this.eQl.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.eQl.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.h.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.l perfLog = tbImageView.getPerfLog();
                                perfLog.fi(1001);
                                perfLog.aKb = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.wB();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.h.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.l.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.fi(1001);
                        perfLog2.aKb = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.wB();
                    }
                }
            }
        }
    }

    public void hl(boolean z) {
        if (this.eRD != null) {
            if (this.dLA) {
                hm(z);
            } else {
                hn(z);
            }
        }
    }

    public void aUe() {
        if (this.eRD != null) {
            this.eRD.setVisibility(8);
            this.eRI = false;
            if (this.eRV != null) {
                this.eRV.setVisibility(8);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.boz == null) {
            this.boz = new com.baidu.tbadk.core.view.a(this.eIw.getPageContext());
        }
        this.boz.aH(true);
    }

    public void Rq() {
        if (this.boz != null) {
            this.boz.aH(false);
        }
    }

    private int getScrollY() {
        View childAt = this.eQl.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.eQl.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eQc != null) {
            this.eQc.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eSJ = getScrollY();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z = false;
        this.eSm = false;
        if (this.eQc != null) {
            this.eQc.b(absListView, i);
        }
        a aVar = new a();
        aVar.eSP = i;
        aVar.eSQ = this.eQl.getHeaderViewsCount();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, aVar));
        int headerViewsCount = (i - this.eQl.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                break;
            } else if (this.eQV.pe(headerViewsCount) != com.baidu.tieba.pb.data.m.eGy) {
                headerViewsCount++;
            } else {
                z = true;
                break;
            }
        }
        this.eQV.aRN().jF(z);
    }

    /* loaded from: classes.dex */
    public class a {
        public int eSP;
        public int eSQ;

        public a() {
        }
    }

    public void aUf() {
        if (!this.eSK) {
            TiebaStatic.log("c10490");
            this.eSK = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIw.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(eRZ, Integer.valueOf(eSb));
            aVar.cb(d.l.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.h.function_description_view)).setText(d.l.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.h.title_view)).setText(d.l.grade_thread_tips);
            aVar.v(inflate);
            aVar.A(sparseArray);
            aVar.a(d.l.grade_button_tips, this.eIw);
            aVar.b(d.l.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eIw.getPageContext()).ts();
        }
    }

    public void aUg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIw.getPageContext().getPageActivity());
        aVar.cW(this.eIw.getResources().getString(d.l.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eRZ, Integer.valueOf(eSd));
        aVar.A(sparseArray);
        aVar.a(d.l.upgrade_to_new, this.eIw);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eIw.getPageContext()).ts();
    }

    public int rt() {
        return this.eRW;
    }

    public void pE(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIw.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eIw.getPageContext().getPageActivity()).inflate(d.j.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.h.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(eRZ, Integer.valueOf(eSc));
        aVar.A(sparseArray);
        aVar.a(d.l.view, this.eIw);
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eIw.getPageContext()).ts();
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

    public PbInterviewStatusView aUh() {
        return this.eRS;
    }

    private void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aPL() != null && fVar.aPL().sy() && this.eRS == null) {
            this.eRS = (PbInterviewStatusView) this.eRR.inflate();
            this.eRS.setOnClickListener(this.clm);
            this.eRS.setCallback(this.eIw.aRu());
            this.eRS.a(this.eIw, fVar);
        }
    }

    public LinearLayout aUi() {
        return this.eQU;
    }

    public View aUj() {
        return this.cbq;
    }

    public boolean aUk() {
        return this.eSu;
    }

    public void iX(boolean z) {
        this.eQu.iX(z);
    }

    private void aUl() {
        if (this.eSu) {
            if (this.eSv == null) {
                d.a aVar = d.eIz.get();
                if (aVar != null) {
                    this.eSv = aVar.a(this.eIw);
                    ListAdapter adapter = this.eQl.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.ayH) {
                            this.eQl.addHeaderView(this.eSv.aQH(), 1);
                        } else {
                            this.eQl.addHeaderView(this.eSv.aQH(), 0);
                        }
                    }
                } else {
                    this.eQr.setVisibility(0);
                    return;
                }
            }
            this.eQr.setVisibility(8);
            this.eQl.removeHeaderView(this.eQr);
            return;
        }
        this.eQr.setVisibility(0);
    }

    public void jN(boolean z) {
        this.eSu = z;
    }

    public void aUm() {
        this.eIw.showNetRefreshView(getView(), "");
        View EQ = this.eIw.getRefreshView().EQ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EQ.getLayoutParams();
        layoutParams.addRule(3, aUi().getId());
        EQ.setLayoutParams(layoutParams);
        this.eIw.hideLoadingView(getView());
        if (this.eSv != null) {
            this.eQl.removeHeaderView(this.eSv.aQH());
            this.eSv = null;
        }
    }

    public void pF(String str) {
        if (this.eQi != null) {
            this.eQi.setTitle(str);
        }
    }

    private int jO(boolean z) {
        if (this.eRS == null || this.eRS.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.g(this.eIw.getPageContext().getPageActivity(), d.f.ds72);
    }

    private void aUn() {
        if (this.eRS != null && this.eRS.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eRS.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.eRS.setLayoutParams(layoutParams);
        }
    }

    public boolean aQQ() {
        return false;
    }

    public boolean aUo() {
        return this.eSk;
    }

    public TextView aUp() {
        return this.eQH;
    }

    public void pG(String str) {
        this.eRF.performClick();
        if (!StringUtils.isNull(str) && this.eIw.aQK() != null && this.eIw.aQK().DA() != null && this.eIw.aQK().DA().Dt() != null) {
            EditText Dt = this.eIw.aQK().DA().Dt();
            Dt.setText(str);
            Dt.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aBM();
            aUe();
            aTs();
            if (this.eSg != null) {
                this.eSg.aRR();
            }
            this.eIw.afF();
            this.eQU.setVisibility(8);
            this.eQh.setTitleVisibility(false);
            this.eIw.jd(false);
            if (this.eQc != null) {
                if (configuration.orientation == 1) {
                    aUi().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.eQl.setIsLandscape(true);
                    this.eQl.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.eQl.setIsLandscape(false);
                    if (this.eSJ > 0) {
                        this.eQl.smoothScrollBy(this.eSJ, 0);
                    }
                }
                this.eQc.onConfigurationChanged(configuration);
            }
        }
    }

    public void jP(boolean z) {
        this.eQf = z;
    }

    public boolean aUq() {
        return this.eQc != null && this.eQc.aUq();
    }

    public void aUr() {
        if (this.eQc != null) {
            this.eQc.onPause();
        }
    }

    public void w(long j, int i) {
        if (this.eQd != null) {
            this.eQd.w(j, i);
        }
        if (this.eQc != null) {
            this.eQc.w(j, i);
        }
    }

    public void aUs() {
        if (this.eRV != null) {
            this.eRV.aVb();
        }
    }

    public void aUt() {
        if (this.eRV != null) {
            this.eRV.setVisibility(8);
        }
    }

    public void jh(boolean z) {
        this.eQV.jh(z);
    }

    public void aUu() {
        if (this.eRT == null) {
            LayoutInflater.from(this.eIw.getActivity()).inflate(d.j.add_experienced_text, (ViewGroup) this.bZd, true);
            this.eRT = (ViewGroup) this.bZd.findViewById(d.h.add_experienced_layout);
            this.eRU = (TextView) this.bZd.findViewById(d.h.add_experienced);
            com.baidu.tbadk.core.util.ai.i(this.eRU, d.e.cp_cont_i);
            String string = this.eIw.getResources().getString(d.l.experienced_add_success);
            String string2 = this.eIw.getResources().getString(d.l.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_cont_h)));
            this.eRU.setText(spannableString);
        }
        this.eRT.setVisibility(0);
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
                        aq.this.eRT.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.eRU.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.eRU.startAnimation(scaleAnimation);
    }
}
