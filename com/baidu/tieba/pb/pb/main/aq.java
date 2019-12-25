package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.support.media.ExifInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class aq {
    private static final int iJN = UtilHelper.getLightStatusBarHeight();
    public static int iJT = 3;
    public static int iJU = 0;
    public static int iJV = 3;
    public static int iJW = 4;
    public static int iJX = 5;
    public static int iJY = 6;
    private static a.InterfaceC0597a iKu = new a.InterfaceC0597a() { // from class: com.baidu.tieba.pb.pb.main.aq.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0597a
        public void onRefresh() {
        }
    };
    private EditorTools Fq;
    private RelativeLayout axQ;
    private View axb;
    private View ayx;
    private g.c dcr;
    private com.baidu.tieba.pb.a.c dmm;
    private View dyE;
    private List<CustomBlueCheckRadioButton> fGl;
    private NoNetworkView fPl;
    private NavigationBarCoverTip gIb;
    private com.baidu.tieba.NEGFeedBack.e gKU;
    private View.OnClickListener gle;
    private PbListView gpB;
    private TextView hbh;
    private PbFakeFloorModel iBO;
    PbFragment.c iDw;
    public int iII;
    public final com.baidu.tieba.pb.pb.main.view.c iIK;
    public com.baidu.tieba.pb.pb.main.view.b iIL;
    private ViewStub iIM;
    private ViewStub iIN;
    private PbLandscapeListView iIO;
    private PbThreadPostView iIP;
    private com.baidu.tieba.pb.pb.main.a.e iIQ;
    private com.baidu.tieba.pb.pb.main.a.a iIR;
    private com.baidu.tieba.pb.pb.main.a.c iIS;
    private com.baidu.tieba.pb.pb.main.a.d iIT;
    private com.baidu.tieba.pb.pb.main.a.b iIU;
    private LinearLayout iIV;
    private TextView iIW;
    private TextView iIX;
    private ObservedChangeRelativeLayout iIY;
    private f iIZ;
    private ImageView iJA;
    private TextView iJB;
    private int iJD;
    private int iJE;
    private PostData iJF;
    private ViewStub iJH;
    private PbInterviewStatusView iJI;
    private FrameLayout iJJ;
    private View iJK;
    private View iJL;
    private am iJM;
    private PbEmotionBar iJR;
    private int iJZ;
    private View iJf;
    private View iJu;
    private View iJw;
    private View iJx;
    private ImageView iJy;
    private ImageView iJz;
    private PbFragment.b iKB;
    public int iKF;
    private Runnable iKa;
    private t iKb;
    private an iKc;
    private int iKi;
    private PbTopTipView iKj;
    private PopupWindow iKk;
    private TextView iKl;
    private List<String> iKm;
    private com.baidu.tieba.pb.pb.main.emotion.c iKn;
    private com.baidu.tieba.pb.pb.godreply.a iKo;
    private PbLandscapeListView.b iKp;
    private ad iKr;
    private String iKs;
    private long iKt;
    private boolean iKv;
    private Runnable iKz;
    private boolean isLandscape;
    private PbFragment iyA;
    private View.OnClickListener izF;
    private com.baidu.tieba.pb.data.f izO;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int iIJ = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a iJa = null;
    private com.baidu.tbadk.core.dialog.b gld = null;
    private View iJb = null;
    private EditText iJc = null;
    private com.baidu.tieba.pb.view.c iJd = null;
    private com.baidu.tieba.pb.view.a iJe = null;
    private b.a hxQ = null;
    private TbRichTextView.i dIi = null;
    private NoNetworkView.a ggy = null;
    private com.baidu.tbadk.core.dialog.i iJg = null;
    private com.baidu.tbadk.core.dialog.a iJh = null;
    private Dialog iJi = null;
    private Dialog iJj = null;
    private View iJk = null;
    private LinearLayout iJl = null;
    private CompoundButton.OnCheckedChangeListener fGm = null;
    private TextView iJm = null;
    private TextView iJn = null;
    private String iJo = null;
    private com.baidu.tbadk.core.dialog.i iCy = null;
    private com.baidu.tbadk.core.dialog.i iJp = null;
    private boolean iJq = false;
    private boolean iJr = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView iJs = null;
    private boolean iJt = false;
    private Button iJv = null;
    private boolean iJC = true;
    private com.baidu.tbadk.core.view.a fKp = null;
    private boolean izx = false;
    private int mSkinType = 3;
    private boolean iJG = false;
    private int iJO = 0;
    private boolean iJP = true;
    public a iJQ = new a();
    private int iJS = 0;
    private boolean iKd = false;
    private int iKe = 0;
    private boolean iKf = false;
    private boolean iKg = false;
    private boolean iKh = false;
    private boolean iKq = false;
    private String iKw = null;
    private CustomMessageListener iKx = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.aq.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.iKw = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.iIZ != null) {
                aq.this.iIZ.notifyDataSetChanged();
            }
        }
    };
    private Handler iKy = new Handler();
    private CustomMessageListener iKA = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.aq.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.iJC = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean iKC = true;
    View.OnClickListener iKD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.iKf) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").Z("obj_id", 2));
            }
            if (!aq.this.iKf && aq.this.izO != null && aq.this.izO.chK() != null && aq.this.izO.chK().azE() != null && aq.this.izO.chK().azE().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").Z("obj_locate", 1));
            }
            if (aq.this.iyA.ckE() != null) {
                aq.this.iyA.ckE().iyV.gLG.onClick(view);
            }
        }
    };
    private boolean eBB = false;
    String userId = null;
    private final List<TbImageView> iKE = new ArrayList();
    private boolean iKG = false;

    /* loaded from: classes6.dex */
    public static class a {
        public int headerCount;
        public am iKU;
        public int irt;
    }

    public void pQ(boolean z) {
        this.iKd = z;
        if (this.iIO != null) {
            this.iKe = this.iIO.getHeaderViewsCount();
        }
    }

    public void cmE() {
        if (this.iIO != null) {
            int headerViewsCount = this.iIO.getHeaderViewsCount() - this.iKe;
            final int firstVisiblePosition = (this.iIO.getFirstVisiblePosition() == 0 || this.iIO.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.iIO.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.iIO.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.iJQ.iKU = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iJQ));
            final am amVar = this.iJQ.iKU;
            final int h = h(amVar);
            final int y = ((int) this.iIY.getY()) + this.iIY.getMeasuredHeight();
            final boolean z = this.iJK.getVisibility() == 0;
            boolean z2 = this.iIY.getY() < 0.0f;
            if ((z && amVar != null) || firstVisiblePosition >= this.iIZ.cjw() + this.iIO.getHeaderViewsCount()) {
                int measuredHeight = amVar != null ? amVar.iIk.getMeasuredHeight() : 0;
                if (z2) {
                    this.iIO.setSelectionFromTop(this.iIZ.cjw() + this.iIO.getHeaderViewsCount(), iJN - measuredHeight);
                } else {
                    this.iIO.setSelectionFromTop(this.iIZ.cjw() + this.iIO.getHeaderViewsCount(), this.iIK.cox().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.iIO.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.iKf && this.iIQ != null) {
                this.iIO.setSelectionFromTop(this.iIZ.cjw() + this.iIO.getHeaderViewsCount(), this.iIQ.cok());
            } else if (this.mType == 6) {
                this.iIO.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void ckO() {
                        ViewGroup.LayoutParams layoutParams;
                        if (h >= 0 && h <= aq.this.axQ.getMeasuredHeight()) {
                            int h2 = aq.this.h(amVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            if (aq.this.ayx != null && (layoutParams = aq.this.ayx.getLayoutParams()) != null) {
                                if (i == 0 || i > aq.this.axQ.getMeasuredHeight() || h2 >= aq.this.axQ.getMeasuredHeight()) {
                                    layoutParams.height = aq.this.iJZ;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.axQ.getMeasuredHeight()) {
                                    layoutParams.height = aq.this.iJZ;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    aq.this.iIO.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                aq.this.ayx.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (aq.this.ayx != null && aq.this.ayx.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = aq.this.ayx.getLayoutParams();
                                            layoutParams2.height = aq.this.iJZ;
                                            aq.this.ayx.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        aq.this.iIO.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(am amVar) {
        if (amVar == null || amVar.getView() == null) {
            return 0;
        }
        if (amVar.getView().getTop() != 0 || amVar.getView().isShown()) {
            return amVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView cmF() {
        return this.fPl;
    }

    public void cmG() {
        if (this.Fq != null) {
            this.Fq.hide();
            if (this.iKn != null) {
                this.iKn.bwn();
            }
        }
    }

    public PbFakeFloorModel cmH() {
        return this.iBO;
    }

    public t cmI() {
        return this.iKb;
    }

    public com.baidu.tieba.pb.pb.main.a.e cmJ() {
        return this.iIQ;
    }

    public void cmK() {
        reset();
        cmG();
        this.iKb.cjF();
        qc(false);
    }

    private void reset() {
        if (this.iyA != null && this.iyA.cjK() != null && this.Fq != null) {
            com.baidu.tbadk.editortools.pb.a.aLY().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cjK = this.iyA.cjK();
            cjK.aMs();
            cjK.aLM();
            if (cjK.getWriteImagesInfo() != null) {
                cjK.getWriteImagesInfo().setMaxImagesAllowed(cjK.isBJH ? 1 : 9);
            }
            cjK.md(SendView.ALL);
            cjK.me(SendView.ALL);
            com.baidu.tbadk.editortools.g lU = this.Fq.lU(23);
            com.baidu.tbadk.editortools.g lU2 = this.Fq.lU(2);
            com.baidu.tbadk.editortools.g lU3 = this.Fq.lU(5);
            if (lU2 != null) {
                lU2.lw();
            }
            if (lU3 != null) {
                lU3.lw();
            }
            if (lU != null) {
                lU.hide();
            }
            this.Fq.invalidate();
        }
    }

    public boolean cmL() {
        return this.iJC;
    }

    public void pR(boolean z) {
        if (this.iJx != null && this.hbh != null) {
            this.hbh.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iJx.startAnimation(alphaAnimation);
            }
            this.iJw.setVisibility(0);
            this.iJx.setVisibility(0);
            this.iJC = true;
            if (this.iJR != null && !this.iKo.isActive()) {
                this.iJR.setVisibility(0);
                pW(true);
            }
        }
    }

    public void pS(boolean z) {
        if (this.iJx != null && this.hbh != null) {
            this.hbh.setText(cmM());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iJx.startAnimation(alphaAnimation);
            }
            this.iJw.setVisibility(0);
            this.iJx.setVisibility(0);
            this.iJC = true;
            if (this.iJR != null && !this.iKo.isActive()) {
                this.iJR.setVisibility(0);
                pW(true);
            }
        }
    }

    public String cmM() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.iKs)) {
            return this.iKs;
        }
        if (this.iyA != null) {
            this.iKs = TbadkCoreApplication.getInst().getResources().getString(ap.cmB());
        }
        return this.iKs;
    }

    public PostData cmN() {
        int i = 0;
        if (this.iIO == null) {
            return null;
        }
        int cmO = cmO() - this.iIO.getHeaderViewsCount();
        if (cmO < 0) {
            cmO = 0;
        }
        if (this.iIZ.yu(cmO) != null && this.iIZ.yu(cmO) != PostData.kbI) {
            i = cmO + 1;
        }
        return this.iIZ.getItem(i) instanceof PostData ? (PostData) this.iIZ.getItem(i) : null;
    }

    public int cmO() {
        int i;
        View childAt;
        if (this.iIO == null) {
            return 0;
        }
        int firstVisiblePosition = this.iIO.getFirstVisiblePosition();
        int lastVisiblePosition = this.iIO.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.iIO.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.iIO.getChildAt(i3 - firstVisiblePosition)) != null) {
                    childAt.getGlobalVisibleRect(rect);
                    iArr[i3 - firstVisiblePosition] = rect.height();
                }
                i2 += iArr[i3 - firstVisiblePosition];
            }
            int i4 = i2 / 2;
            int i5 = 0;
            for (int i6 = 0; i6 < iArr.length; i6++) {
                i5 += iArr[i6];
                if (i5 > i4) {
                    i = i6 + firstVisiblePosition;
                    break;
                }
            }
        }
        i = firstVisiblePosition;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public int cmP() {
        return this.iIO.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.izO != null && this.izO.chM() != null && !this.izO.chM().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.izO.chM().size() && (postData = this.izO.chM().get(i)) != null && postData.azE() != null && !StringUtils.isNull(postData.azE().getUserId()); i++) {
                if (this.izO.chM().get(i).azE().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.iKo != null && this.iKo.isActive()) {
                        qc(false);
                    }
                    if (this.iJR != null) {
                        this.iJR.ql(true);
                    }
                    this.iKw = postData.azE().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.iyA = null;
        this.axQ = null;
        this.axb = null;
        this.iIO = null;
        this.iIZ = null;
        this.gpB = null;
        this.dyE = null;
        this.gle = null;
        this.izF = null;
        this.iJx = null;
        this.hbh = null;
        this.iJH = null;
        this.iKi = 0;
        this.iKt = 0L;
        this.iKt = System.currentTimeMillis();
        this.iyA = pbFragment;
        this.gle = onClickListener;
        this.dmm = cVar;
        this.iKi = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iyA.getContext()) / 2;
        this.axQ = (RelativeLayout) LayoutInflater.from(this.iyA.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.axQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iJu = this.axQ.findViewById(R.id.bottom_shadow);
        this.gIb = (NavigationBarCoverTip) this.axQ.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.axb = this.axQ.findViewById(R.id.statebar_view);
        this.iIY = (ObservedChangeRelativeLayout) this.axQ.findViewById(R.id.title_wrapper);
        this.fPl = (NoNetworkView) this.axQ.findViewById(R.id.view_no_network);
        this.iIO = (PbLandscapeListView) this.axQ.findViewById(R.id.new_pb_list);
        this.iJJ = (FrameLayout) this.axQ.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.iyA.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iyA.getActivity(), R.dimen.ds88));
        this.iIO.addHeaderView(this.textView, 0);
        this.iIO.setTextViewAdded(true);
        this.iJZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.ayx = new View(this.iyA.getPageContext().getPageActivity());
        this.ayx.setLayoutParams(new AbsListView.LayoutParams(-1, this.iJZ));
        this.ayx.setVisibility(4);
        this.iIO.addFooterView(this.ayx);
        this.iIO.setOnTouchListener(this.iyA.dne);
        this.iIK = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.axQ);
        if (this.iyA.cko()) {
            this.iIM = (ViewStub) this.axQ.findViewById(R.id.manga_view_stub);
            this.iIM.setVisibility(0);
            this.iIL = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.iIL.show();
            this.iIK.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iyA.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.iIK.cox().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0556a() { // from class: com.baidu.tieba.pb.pb.main.aq.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0556a
            public void ciD() {
                if (aq.this.iIO != null) {
                    if (aq.this.iIQ != null) {
                        aq.this.iIQ.coj();
                    }
                    aq.this.iIO.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0556a
            public void ciE() {
                aq.this.iyA.bBE();
            }
        }));
        this.iJw = this.axQ.findViewById(R.id.view_comment_top_line);
        this.iJx = this.axQ.findViewById(R.id.pb_editor_tool_comment);
        this.iJD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iJE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hbh = (TextView) this.axQ.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.iyA.cjU();
                if (aq.this.iyA != null && aq.this.iyA.ciU() != null && aq.this.iyA.ciU().getPbData() != null && aq.this.iyA.ciU().getPbData().chK() != null && aq.this.iyA.ciU().getPbData().chK().azE() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", aq.this.iyA.ciU().iET).cp("fid", aq.this.iyA.ciU().getPbData().getForumId()).Z("obj_locate", 1).cp("uid", aq.this.iyA.ciU().getPbData().chK().azE().getUserId()));
                }
            }
        });
        this.iJy = (ImageView) this.axQ.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iJy.setOnClickListener(this.gle);
        boolean booleanExtra = this.iyA.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iJz = (ImageView) this.axQ.findViewById(R.id.pb_editor_tool_collection);
        this.iJz.setOnClickListener(this.gle);
        if (booleanExtra) {
            this.iJz.setVisibility(8);
        } else {
            this.iJz.setVisibility(0);
        }
        this.iJA = (ImageView) this.axQ.findViewById(R.id.pb_editor_tool_share);
        this.iJA.setOnClickListener(this.gle);
        this.iJB = (TextView) this.axQ.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.iJH = (ViewStub) this.axQ.findViewById(R.id.interview_status_stub);
        this.iIR = new com.baidu.tieba.pb.pb.main.a.a(this.iyA, cVar);
        this.iIT = new com.baidu.tieba.pb.pb.main.a.d(this.iyA, cVar, this.gle);
        this.iIZ = new f(this.iyA, this.iIO);
        this.iIZ.D(this.gle);
        this.iIZ.setTbGestureDetector(this.dmm);
        this.iIZ.setOnImageClickListener(this.dIi);
        this.izF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            aq.this.iyA.b(sparseArray);
                            return;
                        }
                        aq.this.cw(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.iyA.b(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.iIZ.P(this.izF);
        cmU();
        cmV();
        this.iIT.b(this.iIO);
        this.iIS.b(this.iIO);
        this.iIR.b(this.iIO);
        this.gpB = new PbListView(this.iyA.getPageContext().getPageActivity());
        this.dyE = this.gpB.getView().findViewById(R.id.pb_more_view);
        if (this.dyE != null) {
            this.dyE.setOnClickListener(this.gle);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.dyE, R.drawable.pb_foot_more_trans_selector);
        }
        this.gpB.setLineVisible();
        this.gpB.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.gpB.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iJf = this.axQ.findViewById(R.id.viewstub_progress);
        this.iyA.registerListener(this.iKA);
        this.iIT.coh();
        this.iBO = new PbFakeFloorModel(this.iyA.getPageContext());
        this.iKb = new t(this.iyA.getPageContext(), this.iBO, this.axQ);
        this.iKb.a(this.iyA.iDr);
        this.iBO.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void q(PostData postData) {
                aq.this.iBO.r(postData);
                aq.this.iIZ.notifyDataSetChanged();
                aq.this.iKb.cjF();
                aq.this.Fq.aJZ();
                aq.this.qc(false);
            }
        });
        if (this.iyA.ciU() != null && !StringUtils.isNull(this.iyA.ciU().clF())) {
            this.iyA.showToast(this.iyA.ciU().clF());
        }
        this.iJK = this.axQ.findViewById(R.id.pb_expand_blank_view);
        this.iJL = this.axQ.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iJL.getLayoutParams();
        if (this.iyA.ciU() != null && this.iyA.ciU().ckX()) {
            this.iJK.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.iJL.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = iJN;
            this.iJL.setLayoutParams(layoutParams2);
        }
        this.iJM = new am(this.iyA.getPageContext(), this.axQ.findViewById(R.id.pb_reply_expand_view));
        this.iJM.iIk.setVisibility(8);
        this.iJM.R(this.gle);
        this.iyA.registerListener(this.mAccountChangedListener);
        this.iyA.registerListener(this.iKx);
        cmQ();
        pW(false);
    }

    public void pT(boolean z) {
        this.iJu.setVisibility(z ? 0 : 8);
    }

    public void bML() {
        if (!this.iyA.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").Z("obj_locate", 2).cp("fid", this.mForumId));
        } else if (this.iyA.cjW()) {
            com.baidu.tbadk.editortools.pb.e cjK = this.iyA.cjK();
            if (cjK != null && (cjK.aMp() || cjK.aMq())) {
                this.iyA.cjK().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Fq != null) {
                cna();
            }
            if (this.Fq != null) {
                this.iJC = false;
                if (this.Fq.lX(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.iyA.getPageContext(), (View) this.Fq.lX(2).dsh, false, iKu);
                }
            }
            cnH();
        }
    }

    private void cmQ() {
        this.iKo = new com.baidu.tieba.pb.pb.godreply.a(this.iyA, this, (ViewStub) this.axQ.findViewById(R.id.more_god_reply_popup));
        this.iKo.y(this.gle);
        this.iKo.P(this.izF);
        this.iKo.setOnImageClickListener(this.dIi);
        this.iKo.y(this.gle);
        this.iKo.setTbGestureDetector(this.dmm);
    }

    public com.baidu.tieba.pb.pb.godreply.a cmR() {
        return this.iKo;
    }

    public View cmS() {
        return this.iJK;
    }

    public void cmT() {
        if (this.iIO != null) {
            this.iIS.c(this.iIO);
            this.iIT.c(this.iIO);
            this.iIU.c(this.iIO);
            this.iIR.c(this.iIO);
        }
    }

    private void cmU() {
        if (this.iIU == null) {
            this.iIU = new com.baidu.tieba.pb.pb.main.a.b(this.iyA, this.gle);
        }
    }

    private void cmV() {
        if (this.iIS == null) {
            this.iIS = new com.baidu.tieba.pb.pb.main.a.c(this.iyA, this.dmm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmW() {
        if (this.iyA.cko()) {
            this.iIN = (ViewStub) this.axQ.findViewById(R.id.manga_mention_controller_view_stub);
            this.iIN.setVisibility(0);
            if (this.iIV == null) {
                this.iIV = (LinearLayout) this.axQ.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.iyA.getPageContext(), this.iIV);
            }
            if (this.iIW == null) {
                this.iIW = (TextView) this.iIV.findViewById(R.id.manga_prev_btn);
            }
            if (this.iIX == null) {
                this.iIX = (TextView) this.iIV.findViewById(R.id.manga_next_btn);
            }
            this.iIW.setOnClickListener(this.gle);
            this.iIX.setOnClickListener(this.gle);
        }
    }

    private void cmX() {
        if (this.iyA.cko()) {
            if (this.iyA.ckr() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iIW, R.color.cp_cont_e, 1);
            }
            if (this.iyA.cks() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iIX, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cmY() {
        if (this.iIV == null) {
            cmW();
        }
        this.iIN.setVisibility(8);
        if (this.iKy != null && this.iKz != null) {
            this.iKy.removeCallbacks(this.iKz);
        }
    }

    public void cmZ() {
        if (this.iKy != null) {
            if (this.iKz != null) {
                this.iKy.removeCallbacks(this.iKz);
            }
            this.iKz = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.iIV == null) {
                        aq.this.cmW();
                    }
                    aq.this.iIN.setVisibility(0);
                }
            };
            this.iKy.postDelayed(this.iKz, 2000L);
        }
    }

    public void pU(boolean z) {
        this.iIK.pU(z);
        if (z && this.iJG) {
            this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iIO.setNextPage(this.gpB);
            this.iIJ = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Fq = editorTools;
        this.Fq.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Fq.getParent() == null) {
            this.axQ.addView(this.Fq, layoutParams);
        }
        this.Fq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Fq.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).aGJ() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).aGJ() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        aq.this.mPermissionJudgePolicy.appendRequestPermission(aq.this.iyA.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.startRequestPermission(aq.this.iyA.getBaseFragmentActivity())) {
                            aq.this.iyA.cjK().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.iyA.cjK().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cmG();
        this.iyA.cjK().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.Fq != null && aq.this.Fq.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.iKn == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.Fq.getId());
                            aq.this.iKn = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.iyA.getPageContext(), aq.this.axQ, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(aq.this.iKm)) {
                                aq.this.iKn.setData(aq.this.iKm);
                            }
                            aq.this.iKn.b(aq.this.Fq);
                        }
                        aq.this.iKn.FL(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.iyA.iCx != null && aq.this.iyA.iCx.cnW() != null) {
                    if (!aq.this.iyA.iCx.cnW().cRK()) {
                        aq.this.iyA.iCx.qh(false);
                    }
                    aq.this.iyA.iCx.cnW().tr(false);
                }
            }
        });
    }

    public void cna() {
        if (this.iyA != null && this.Fq != null) {
            this.Fq.lw();
            if (this.iyA.cjK() != null) {
                this.iyA.cjK().aMf();
            }
            cnH();
        }
    }

    public void pV(boolean z) {
        if (this.iIO != null && this.textView != null && this.axb != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.axb.setVisibility(0);
                } else {
                    this.axb.setVisibility(8);
                    this.iIO.removeHeaderView(this.textView);
                    this.iIO.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = iJN;
                    this.textView.setLayoutParams(layoutParams);
                }
                cno();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + qe(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cno();
            cnP();
        }
    }

    public f cnb() {
        return this.iIZ;
    }

    public void a(PbFragment.c cVar) {
        this.iDw = cVar;
    }

    public void cw(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iyA.getContext());
        kVar.setTitleText(this.iyA.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.iJg.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.iKB != null) {
                                aq.this.iKB.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.iyA.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i != 2) {
            int i2 = -1;
            if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            }
            if (i2 == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iyA.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iyA.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cnO()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.iyA.getString(R.string.forbidden_person), kVar);
            gVar3.mTextView.setTag(sparseArray3);
            arrayList.add(gVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
            if (z) {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iyA.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iyA.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aA(arrayList);
        if (this.iJg == null) {
            this.iJg = new com.baidu.tbadk.core.dialog.i(this.iyA.getPageContext(), kVar);
        } else {
            this.iJg.a(kVar);
        }
        this.iJg.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.iKB = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iyA != null && aVar != null) {
            if (this.gKU == null && this.iIR != null) {
                this.gKU = new com.baidu.tieba.NEGFeedBack.e(this.iyA.getPageContext(), this.iIR.cog());
            }
            AntiData bAs = this.iyA.bAs();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bAs != null && bAs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bAs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gKU.setDefaultReasonArray(new String[]{this.iyA.getString(R.string.delete_thread_reason_1), this.iyA.getString(R.string.delete_thread_reason_2), this.iyA.getString(R.string.delete_thread_reason_3), this.iyA.getString(R.string.delete_thread_reason_4), this.iyA.getString(R.string.delete_thread_reason_5)});
            this.gKU.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gKU.vO(str);
            this.gKU.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void R(JSONArray jSONArray) {
                    aq.this.iyA.a(aVar, jSONArray);
                }
            });
        }
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(iJU, Integer.valueOf(iJV));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.iJh = new com.baidu.tbadk.core.dialog.a(this.iyA.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iJh.jF(i3);
        } else {
            this.iJh.setOnlyMessageShowCenter(false);
            this.iJh.sz(str2);
        }
        this.iJh.setYesButtonTag(sparseArray);
        this.iJh.a(R.string.dialog_ok, this.iyA);
        this.iJh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iJh.fu(true);
        this.iJh.b(this.iyA.getPageContext());
        if (z) {
            this.iJh.aBW();
        } else {
            a(this.iJh, i);
        }
    }

    public void aM(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.iJk == null) {
            this.iJk = LayoutInflater.from(this.iyA.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iyA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iJk);
        if (this.iJj == null) {
            this.iJj = new Dialog(this.iyA.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iJj.setCanceledOnTouchOutside(true);
            this.iJj.setCancelable(true);
            this.iJs = (ScrollView) this.iJk.findViewById(R.id.good_scroll);
            this.iJj.setContentView(this.iJk);
            WindowManager.LayoutParams attributes = this.iJj.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iJj.getWindow().setAttributes(attributes);
            this.fGm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.iJo = (String) compoundButton.getTag();
                        if (aq.this.fGl != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.fGl) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.iJo != null && !str.equals(aq.this.iJo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iJl = (LinearLayout) this.iJk.findViewById(R.id.good_class_group);
            this.iJn = (TextView) this.iJk.findViewById(R.id.dialog_button_cancel);
            this.iJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.iJj instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(aq.this.iJj, aq.this.iyA.getPageContext());
                    }
                }
            });
            this.iJm = (TextView) this.iJk.findViewById(R.id.dialog_button_ok);
            this.iJm.setOnClickListener(this.gle);
        }
        this.iJl.removeAllViews();
        this.fGl = new ArrayList();
        CustomBlueCheckRadioButton dU = dU("0", this.iyA.getPageContext().getString(R.string.thread_good_class));
        this.fGl.add(dU);
        dU.setChecked(true);
        this.iJl.addView(dU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aya()) && adVar.ayb() > 0) {
                    CustomBlueCheckRadioButton dU2 = dU(String.valueOf(adVar.ayb()), adVar.aya());
                    this.fGl.add(dU2);
                    View view = new View(this.iyA.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iJl.addView(view);
                    this.iJl.addView(dU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iJs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iyA.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iyA.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iyA.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iJs.setLayoutParams(layoutParams2);
            this.iJs.removeAllViews();
            if (this.iJl != null && this.iJl.getParent() == null) {
                this.iJs.addView(this.iJl);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iJj, this.iyA.getPageContext());
    }

    private CustomBlueCheckRadioButton dU(String str, String str2) {
        Activity pageActivity = this.iyA.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fGm);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cnc() {
        this.iyA.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.iyA.hideProgressBar();
        if (z && z2) {
            this.iyA.showToast(this.iyA.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.iyA.showToast(str);
        }
    }

    public void bTG() {
        this.iJf.setVisibility(0);
    }

    public void bTF() {
        this.iJf.setVisibility(8);
    }

    public View cnd() {
        if (this.iJk != null) {
            return this.iJk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cne() {
        return this.iJo;
    }

    public View getView() {
        return this.axQ;
    }

    public void cnf() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iyA.getPageContext().getPageActivity(), this.iyA.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.iyA.hideProgressBar();
        if (z) {
            cny();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cnz();
        } else {
            cny();
        }
    }

    public void cng() {
        this.gpB.setLineVisible();
        this.gpB.startLoadData();
    }

    public void cnh() {
        this.iyA.hideProgressBar();
        endLoadData();
        this.iIO.completePullRefreshPostDelayed(0L);
        cnt();
    }

    public void cni() {
        this.iIO.completePullRefreshPostDelayed(0L);
        cnt();
    }

    private void pW(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.iIT.b(onLongClickListener);
        this.iIZ.setOnLongClickListener(onLongClickListener);
        if (this.iKo != null) {
            this.iKo.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.iCy != null) {
            this.iCy.dismiss();
            this.iCy = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iyA.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iyA.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iyA.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iyA.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iyA.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aA(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.iJp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iJp = new com.baidu.tbadk.core.dialog.i(this.iyA.getPageContext(), kVar);
        this.iJp.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iJp != null) {
            this.iJp.dismiss();
            this.iJp = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iyA.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.izO != null && this.izO.chK() != null && !this.izO.chK().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iyA.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iyA.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aA(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.iJp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iJp = new com.baidu.tbadk.core.dialog.i(this.iyA.getPageContext(), kVar);
        this.iJp.showDialog();
    }

    public int cnj() {
        return yS(this.iIO.getFirstVisiblePosition());
    }

    private int yS(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.iIO.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.iIO.getAdapter() == null || !(this.iIO.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.iIO.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cnk() {
        int lastVisiblePosition = this.iIO.getLastVisiblePosition();
        if (this.iIQ != null) {
            if (lastVisiblePosition == this.iIO.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return yS(lastVisiblePosition);
    }

    public void yT(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.iIO != null) {
            if (this.iIK == null || this.iIK.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.iIK.mNavigationBar.getFixedNavHeight();
                if (this.iyA.cke() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.iJL != null && (layoutParams = (LinearLayout.LayoutParams) this.iJL.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.iJL.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.iIO.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.iIO.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.iIO.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.iJc.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.iIZ.a(fVar, false);
        this.iIZ.notifyDataSetChanged();
        cnt();
        if (this.iKo != null) {
            this.iKo.ciQ();
        }
        ArrayList<PostData> chM = fVar.chM();
        if (fVar.getPage().ayy() == 0 || chM == null || chM.size() < fVar.getPage().ayx()) {
            if (com.baidu.tbadk.core.util.v.getCount(chM) == 0 || (com.baidu.tbadk.core.util.v.getCount(chM) == 1 && chM.get(0) != null && chM.get(0).cIt() == 1)) {
                if (this.iJQ == null || this.iJQ.iKU == null || this.iJQ.iKU.getView() == null) {
                    i = 0;
                } else {
                    i = this.iJQ.iKU.getView().getTop() < 0 ? this.iJQ.iKU.getView().getHeight() : this.iJQ.iKU.getView().getBottom();
                }
                if (this.iyA.cky()) {
                    this.gpB.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.gpB.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().ayy() == 0) {
                    this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.gpB.aFa();
            }
        }
        q(fVar);
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        if (this.iIR != null) {
            this.iIR.e(fVar, this.izx);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.chU() != null) {
            return fVar.chU();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(fVar.chM())) {
            Iterator<PostData> it = fVar.chM().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cIt() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.chR();
        }
        if (!p(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.azE() != null && postData.azE().getUserTbVipInfoData() != null && postData.azE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.azE().getGodUserData().setIntro(postData.azE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean p(PostData postData) {
        if (postData == null || postData.azE() == null) {
            return false;
        }
        MetaData azE = postData.azE();
        return (TextUtils.isEmpty(azE.getUserId()) && TextUtils.isEmpty(azE.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.chK() == null || fVar.chK().azE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData azE = fVar.chK().azE();
        String userId = azE.getUserId();
        HashMap<String, MetaData> userMap = fVar.chK().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = azE;
        }
        postData.Cl(1);
        postData.setId(fVar.chK().azU());
        postData.setTitle(fVar.chK().getTitle());
        postData.setTime(fVar.chK().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.chK() != null) {
            if (this.iyA.ciJ()) {
                if (fVar.chJ() != null) {
                    this.mForumName = fVar.chJ().getForumName();
                    this.mForumId = fVar.chJ().getForumId();
                }
                if (this.mForumName == null && this.iyA.ciU() != null && this.iyA.ciU().ciK() != null) {
                    this.mForumName = this.iyA.ciU().ciK();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.iIT.setVisibility(8);
            if (fVar.cih()) {
                this.iKf = true;
                this.iIK.qs(true);
                this.iIK.mNavigationBar.hideBottomLine();
                if (this.iIQ == null) {
                    this.iIQ = new com.baidu.tieba.pb.pb.main.a.e(this.iyA);
                }
                this.iIQ.a(fVar, b, this.iIO, this.iIT, this.iJJ, this.iIK, this.mForumName, this.iKt);
                this.iIQ.S(this.iKD);
                cno();
            } else {
                this.iKf = false;
                this.iIK.qs(this.iKf);
                if (this.iIQ != null) {
                    this.iIQ.c(this.iIO);
                }
            }
            if (this.iyA.cjN() != null) {
                this.iyA.cjN().qm(this.iKf);
            }
            if (b != null) {
                this.iJF = b;
                this.iIT.setVisibility(0);
                SparseArray<Object> coi = this.iIT.coi();
                coi.put(R.id.tag_clip_board, b);
                coi.put(R.id.tag_is_subpb, false);
                this.iIU.a(fVar, this.iIO);
                this.iIS.v(fVar);
                this.iIR.e(fVar, this.izx);
                this.iIR.u(fVar);
                this.iIT.a(this.mSkinType, this.izO, b, this.iKD);
                if (this.iJM != null) {
                    if (fVar.cik()) {
                        this.iJM.getView().setVisibility(8);
                    } else {
                        this.iJM.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k(com.baidu.tieba.pb.data.k.ixe);
                        if (fVar.chK() != null) {
                            kVar.ixg = fVar.chK().azv();
                        }
                        kVar.isNew = !this.izx;
                        kVar.sortType = fVar.iwg;
                        kVar.ixi = fVar.cil();
                        kVar.ixj = this.iyA.cky();
                        this.iJM.a(kVar);
                    }
                }
                if (fVar != null && fVar.chK() != null) {
                    ad(fVar.chK().azA() == 1, fVar.chK().azz() == 1);
                }
                com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.iIZ != null && aq.this.iIK != null && aq.this.iIK.iOQ != null && aq.this.izO != null && aq.this.izO.chK() != null && !aq.this.izO.chK().aAE() && !aq.this.cns() && aq.this.izO.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(aq.this.izO.getForum().getName())) {
                            if (aq.this.iIZ.cjA() == null || !aq.this.iIZ.cjA().isShown()) {
                                aq.this.iIK.iOQ.setVisibility(0);
                                if (aq.this.iyA != null && aq.this.iyA.ciU() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.cp("tid", aq.this.iyA.ciU().ckU());
                                    anVar.cp("fid", aq.this.iyA.ciU().getForumId());
                                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void pX(boolean z) {
        if (z) {
            cnl();
        } else {
            bwa();
        }
        this.iJQ.iKU = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iJQ));
        a(this.iJQ.iKU, false);
    }

    public void cnl() {
        if (this.iIK != null && !this.iKh) {
            this.iIK.qt(!StringUtils.isNull(this.iyA.cka()));
            this.iKh = true;
        }
    }

    public void bwa() {
        if (this.iIK != null) {
            this.iIK.coG();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.iIT.a(postData, fVar);
    }

    public void cnm() {
        if (this.iIQ != null) {
            this.iIQ.d(this.iIO);
        }
    }

    public boolean cnn() {
        return this.eBB;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aE(bj bjVar) {
        if (bjVar == null || bjVar.azE() == null) {
            return false;
        }
        PostData b = b(this.izO, false);
        String str = "";
        if (b != null && b.azE() != null) {
            str = b.azE().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.iIK.coE();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.iIK.Dt(eVar.forumName);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.f.b.toInt(eVar.source, 0)) {
                case 100:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
                    break;
                case 300:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.ivY;
            this.iyA.showNetRefreshView(this.axQ, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.aEa().b(aq.this.iyA.getPageContext(), new String[]{str2});
                        aq.this.iyA.finish();
                        return;
                    }
                    aq.this.iyA.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cmr;
        Parcelable cmr2;
        if (fVar != null && this.iIO != null) {
            this.izO = fVar;
            this.mType = i;
            if (fVar.chK() != null) {
                this.iJS = fVar.chK().azl();
                if (fVar.chK().getAnchorLevel() != 0) {
                    this.eBB = true;
                }
                this.iJr = aE(fVar.chK());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            t(fVar);
            this.iJG = false;
            this.izx = z;
            cnh();
            if (fVar.iwh != null && fVar.iwh.cip()) {
                if (this.iIP == null) {
                    this.iIP = new PbThreadPostView(this.iyA.getContext());
                    this.iIO.addHeaderView(this.iIP, 1);
                    this.iIP.setData(fVar);
                    this.iIP.setChildOnClickLinstener(this.gle);
                }
            } else if (this.iIP != null && this.iIO != null) {
                this.iIO.removeHeaderView(this.iIP);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            r(fVar);
            if (this.iKr == null) {
                this.iKr = new ad(this.iyA.getPageContext(), this.gIb);
            }
            this.iKr.FB(fVar.chP());
            if (this.iyA.cko()) {
                if (this.iJd == null) {
                    this.iJd = new com.baidu.tieba.pb.view.c(this.iyA.getPageContext());
                    this.iJd.createView();
                    this.iJd.setListPullRefreshListener(this.dcr);
                }
                this.iIO.setPullRefresh(this.iJd);
                cno();
                if (this.iJd != null) {
                    this.iJd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().ayz() == 0 && z) {
                this.iIO.setPullRefresh(null);
            } else {
                if (this.iJd == null) {
                    this.iJd = new com.baidu.tieba.pb.view.c(this.iyA.getPageContext());
                    this.iJd.createView();
                    this.iJd.setListPullRefreshListener(this.dcr);
                }
                this.iIO.setPullRefresh(this.iJd);
                cno();
                if (this.iJd != null) {
                    this.iJd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bnJ();
            }
            cnt();
            this.iIZ.pi(this.izx);
            this.iIZ.pj(false);
            this.iIZ.pn(i == 5);
            this.iIZ.po(i == 6);
            this.iIZ.pp(z2 && this.iKC);
            this.iIZ.a(fVar, false);
            this.iIZ.notifyDataSetChanged();
            this.iIT.a(b(fVar, z), fVar.cik());
            if (fVar.chK() != null && fVar.chK().azp() != null && this.iII != -1) {
                fVar.chK().azp().setIsLike(this.iII);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.iIO.setNextPage(this.gpB);
                this.iIJ = 2;
                bnJ();
            } else {
                this.iJG = true;
                if (fVar.getPage().ayy() == 1) {
                    if (this.iJe == null) {
                        this.iJe = new com.baidu.tieba.pb.view.a(this.iyA, this.iyA);
                    }
                    this.iIO.setNextPage(this.iJe);
                } else {
                    this.iIO.setNextPage(this.gpB);
                }
                this.iIJ = 3;
            }
            ArrayList<PostData> chM = fVar.chM();
            if (fVar.getPage().ayy() == 0 || chM == null || chM.size() < fVar.getPage().ayx()) {
                if (com.baidu.tbadk.core.util.v.getCount(chM) == 0 || (com.baidu.tbadk.core.util.v.getCount(chM) == 1 && chM.get(0) != null && chM.get(0).cIt() == 1)) {
                    if (this.iJQ == null || this.iJQ.iKU == null || this.iJQ.iKU.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.iJQ.iKU.getView().getTop() < 0 ? this.iJQ.iKU.getView().getHeight() : this.iJQ.iKU.getView().getBottom();
                    }
                    if (this.iyA.cky()) {
                        this.gpB.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.gpB.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.iyA.cjN() != null && !this.iyA.cjN().cor()) {
                        this.iyA.cjN().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().ayy() == 0) {
                        this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gpB.aFa();
                }
                if (fVar.getPage().ayy() == 0 || chM == null) {
                    cnC();
                }
            } else {
                if (z2) {
                    if (this.iKC) {
                        endLoadData();
                        if (fVar.getPage().ayy() != 0) {
                            this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.gpB.setLineVisible();
                        this.gpB.showLoading();
                    }
                } else {
                    this.gpB.setLineVisible();
                    this.gpB.showLoading();
                }
                this.gpB.aFa();
            }
            switch (i) {
                case 2:
                    this.iIO.setSelection(i2 > 1 ? (((this.iIO.getData() == null && fVar.chM() == null) ? 0 : (this.iIO.getData().size() - fVar.chM().size()) + this.iIO.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cmr2 = ak.cmq().cmr()) != null) {
                        this.iIO.onRestoreInstanceState(cmr2);
                        if (com.baidu.tbadk.core.util.v.getCount(chM) > 1 && fVar.getPage().ayy() > 0) {
                            this.gpB.endLoadData();
                            this.gpB.setText(this.iyA.getString(R.string.pb_load_more_without_point));
                            this.gpB.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.iKC = false;
                    break;
                case 5:
                    this.iIO.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cmr = ak.cmq().cmr()) != null) {
                        this.iIO.onRestoreInstanceState(cmr);
                        break;
                    } else {
                        this.iIO.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.iIQ != null && this.iIQ.aZU() != null) {
                            if (this.iyA.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.iIO.setSelectionFromTop((this.iIZ.cjv() + this.iIO.getHeaderViewsCount()) - 1, this.iIQ.cok() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.iyA.getPageContext().getPageActivity()));
                            } else {
                                this.iIO.setSelectionFromTop((this.iIZ.cjv() + this.iIO.getHeaderViewsCount()) - 1, this.iIQ.cok());
                            }
                        } else {
                            this.iIO.setSelection(this.iIZ.cjv() + this.iIO.getHeaderViewsCount());
                        }
                    } else {
                        this.iIO.setSelection(i2 > 0 ? ((this.iIO.getData() == null && fVar.chM() == null) ? 0 : (this.iIO.getData().size() - fVar.chM().size()) + this.iIO.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.gpB.endLoadData();
                    this.gpB.setText(this.iyA.getString(R.string.pb_load_more_without_point));
                    this.gpB.setLineGone();
                    break;
            }
            if (this.iJS == iJT && isHost()) {
                cnK();
            }
            if (this.iKd) {
                cmE();
                this.iKd = false;
                if (i3 == 0) {
                    pQ(true);
                }
            }
            if (fVar.iwd == 1 || fVar.iwe == 1) {
                if (this.iKj == null) {
                    this.iKj = new PbTopTipView(this.iyA.getContext());
                }
                if (fVar.iwe == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.iyA.getStType())) {
                    this.iKj.setText(this.iyA.getString(R.string.pb_read_strategy_add_experience));
                    this.iKj.a(this.axQ, this.mSkinType);
                } else if (fVar.iwd == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.iyA.getStType())) {
                    this.iKj.setText(this.iyA.getString(R.string.pb_read_news_add_experience));
                    this.iKj.a(this.axQ, this.mSkinType);
                }
            }
            q(fVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.chK() != null) {
            if (fVar.awd()) {
                SvgManager.aDW().a(this.iJz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aDW().a(this.iJz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iJB.setText(yU(fVar.chK().azv()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.chK()));
        }
    }

    private String yU(int i) {
        if (i == 0) {
            return this.iyA.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i;
        }
    }

    private void cno() {
        if (this.iIQ != null) {
            this.iIQ.a(this.iIO, this.textView, this.mType);
        }
    }

    public void pY(boolean z) {
        this.iJq = z;
    }

    public void endLoadData() {
        if (this.gpB != null) {
            this.gpB.setLineGone();
            this.gpB.endLoadData();
        }
        bnJ();
    }

    public void bdR() {
        this.iIO.setVisibility(0);
    }

    public void cnp() {
        if (this.iIO != null) {
            this.iIO.setVisibility(8);
        }
        if (this.iIO != null) {
            this.iJJ.setVisibility(8);
        }
        if (this.iIK != null && this.iIK.iON != null) {
            this.iIK.iON.setVisibility(8);
        }
    }

    public void cnq() {
        if (this.iIO != null) {
            this.iIO.setVisibility(0);
        }
        if (this.iJJ != null) {
            this.iJJ.setVisibility(0);
        }
        if (this.iIK != null && this.iIK.iON != null) {
            this.iIK.iON.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.iJF != null && this.iJF.azE() != null && this.iIK != null) {
            this.iKg = !this.iKf;
            this.iIK.qo(this.iKg);
            if (this.iyA.cjN() != null) {
                this.iyA.cjN().qn(this.iKg);
            }
            cnr();
            if (this.iyA != null && !this.iyA.ciJ() && !com.baidu.tbadk.core.util.v.isEmpty(fVar.cie())) {
                bf bfVar = fVar.cie().get(0);
                if (bfVar != null) {
                    this.iIK.dV(bfVar.getForumName(), bfVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.iIK.dV(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.iKg) {
                this.iIT.a(fVar, this.iJF, this.iJr);
                if (this.iJL != null) {
                    this.iJL.setVisibility(8);
                }
                if (this.iKp == null) {
                    this.iKp = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (aq.this.iyA != null && aq.this.iyA.isAdded()) {
                                if (i < 0 && f > aq.this.iKi) {
                                    aq.this.cnJ();
                                }
                                aq.this.cni();
                            }
                        }
                    };
                }
                this.iIO.setListViewDragListener(this.iKp);
                return;
            }
            if (this.iJL != null) {
                this.iJL.setVisibility(0);
            }
            this.iIT.a(fVar, this.iJF, this.iJr);
            this.iKp = null;
            this.iIO.setListViewDragListener(null);
        }
    }

    private void cnr() {
        this.iIT.a(this.izO, this.iJF, this.iKg, this.iKf);
    }

    public boolean cns() {
        return this.izO == null || this.izO.getForum() == null || "0".equals(this.izO.getForum().getId()) || "me0407".equals(this.izO.getForum().getName());
    }

    private boolean cnt() {
        return this.iIR.qj(this.izx);
    }

    private boolean s(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.chK() == null) {
            return false;
        }
        if (fVar.chK().azB() == 1 || fVar.chK().getThreadType() == 33) {
            return true;
        }
        return !(fVar.chK().azD() == null || fVar.chK().azD().aBN() == 0) || fVar.chK().azz() == 1 || fVar.chK().azA() == 1 || fVar.chK().aAp() || fVar.chK().aAK() || fVar.chK().aAD() || fVar.chK().azQ() != null || !com.baidu.tbadk.core.util.aq.isEmpty(fVar.chK().getCategory()) || fVar.chK().azH() || fVar.chK().azG();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.iIS != null) {
                if (fVar.chK() != null && fVar.chK().azT() == 0 && !fVar.chK().aAE() && !this.iKv) {
                    if (fVar.chK() != null) {
                        bj chK = fVar.chK();
                        chK.q(true, s(fVar));
                        chK.jr(3);
                        chK.sl("2");
                    }
                    if (fVar.chK().ays()) {
                        this.iIT.c(this.iIO);
                        this.iIS.c(this.iIO);
                        this.iIS.b(this.iIO);
                        this.iIT.b(this.iIO);
                        this.iIT.A(this.izO);
                        this.iIS.w(fVar);
                    } else {
                        this.iIT.A(this.izO);
                        this.iIS.y(fVar);
                    }
                } else if (fVar.chK().azT() == 1) {
                    if (fVar.chK() != null) {
                        this.iIS.c(this.iIO);
                        this.iIT.A(this.izO);
                    }
                } else {
                    this.iIS.c(this.iIO);
                    this.iIT.A(this.izO);
                }
            }
            if (fVar.chK() != null) {
                ac(fVar.chK().azA() == 1, fVar.chK().azz() == 1);
            }
            this.izx = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            cnt();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.w wVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.azE().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.chW()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.azE() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.azE().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.azE().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.azE().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.chW()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cie = fVar.cie();
                if (com.baidu.tbadk.core.util.v.getCount(cie) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cie) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cMB) != null && wVar.cKu && !wVar.cKv && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(this.iyA.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.iyA.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cnu() {
        return this.dyE;
    }

    public boolean cnv() {
        if (this.ayx == null || this.ayx.getParent() == null || this.gpB.isLoading()) {
            return false;
        }
        int bottom = this.ayx.getBottom();
        Rect rect = new Rect();
        this.ayx.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void FD(String str) {
        if (this.gpB != null) {
            this.gpB.setText(str);
        }
    }

    public void FE(String str) {
        if (this.gpB != null) {
            int i = 0;
            if (this.iJQ != null && this.iJQ.iKU != null && this.iJQ.iKU.getView() != null) {
                i = this.iJQ.iKU.getView().getTop() < 0 ? this.iJQ.iKU.getView().getHeight() : this.iJQ.iKU.getView().getBottom();
            }
            this.gpB.ac(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.iIO;
    }

    public int cnw() {
        return R.id.richText;
    }

    public TextView cjf() {
        return this.iIT.cjf();
    }

    public void d(BdListView.e eVar) {
        this.iIO.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.dcr = cVar;
        if (this.iJd != null) {
            this.iJd.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int ayw = apVar.ayw();
            int ayt = apVar.ayt();
            if (this.iJa != null) {
                this.iJa.aBW();
            } else {
                this.iJa = new com.baidu.tbadk.core.dialog.a(this.iyA.getPageContext().getPageActivity());
                this.iJb = LayoutInflater.from(this.iyA.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.iJa.aK(this.iJb);
                this.iJa.a(R.string.dialog_ok, bVar);
                this.iJa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.cny();
                        aVar.dismiss();
                    }
                });
                this.iJa.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.iKa == null) {
                            aq.this.iKa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.iyA.HidenSoftKeyPad((InputMethodManager) aq.this.iyA.getBaseFragmentActivity().getSystemService("input_method"), aq.this.axQ);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.gy().postDelayed(aq.this.iKa, 150L);
                    }
                });
                this.iJa.b(this.iyA.getPageContext()).aBW();
            }
            this.iJc = (EditText) this.iJb.findViewById(R.id.input_page_number);
            this.iJc.setText("");
            TextView textView = (TextView) this.iJb.findViewById(R.id.current_page_number);
            if (ayw <= 0) {
                ayw = 1;
            }
            if (ayt <= 0) {
                ayt = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(ayw), Integer.valueOf(ayt)));
            this.iyA.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.iJc, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.iIO.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.iyA.showToast(str);
    }

    public boolean pZ(boolean z) {
        if (this.Fq == null || !this.Fq.aLE()) {
            return false;
        }
        this.Fq.aJZ();
        return true;
    }

    public void cnx() {
        if (this.iKE != null) {
            while (this.iKE.size() > 0) {
                TbImageView remove = this.iKE.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cnx();
        this.iIZ.yv(1);
        if (this.iIQ != null) {
            this.iIQ.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.iIZ.yv(2);
        if (this.iIQ != null) {
            this.iIQ.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.iyA.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iyA.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.iKc != null) {
            this.iKc.destroy();
        }
        if (this.iKr != null) {
            this.iKr.onDestory();
        }
        if (this.iKj != null) {
            this.iKj.hide();
        }
        this.iyA.hideProgressBar();
        if (this.fPl != null && this.ggy != null) {
            this.fPl.b(this.ggy);
        }
        cny();
        endLoadData();
        if (this.iKa != null) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iKa);
        }
        if (this.iJI != null) {
            this.iJI.clearStatus();
        }
        this.iKy = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.iIZ.yv(3);
        if (this.axb != null) {
            this.axb.setBackgroundDrawable(null);
        }
        if (this.iIQ != null) {
            this.iIQ.destroy();
        }
        if (this.iIZ != null) {
            this.iIZ.onDestroy();
        }
        this.iIO.setOnLayoutListener(null);
        if (this.iKn != null) {
            this.iKn.bDP();
        }
        if (this.iJR != null) {
            this.iJR.onDestroy();
        }
        if (this.iIT != null) {
            this.iIT.onDestroy();
        }
    }

    public boolean yV(int i) {
        if (this.iIQ != null) {
            return this.iIQ.yV(i);
        }
        return false;
    }

    public void cny() {
        this.iIK.apm();
        if (this.iIT != null) {
            this.iIT.cny();
        }
        if (this.iyA != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iyA.getContext(), this.iJc);
        }
        cmG();
        if (this.iCy != null) {
            this.iCy.dismiss();
        }
        cnA();
        if (this.iJa != null) {
            this.iJa.dismiss();
        }
        if (this.gld != null) {
            this.gld.dismiss();
        }
    }

    public void cnz() {
        this.iIK.apm();
        if (this.iIT != null) {
            this.iIT.cny();
        }
        if (this.iCy != null) {
            this.iCy.dismiss();
        }
        cnA();
        if (this.iJa != null) {
            this.iJa.dismiss();
        }
        if (this.gld != null) {
            this.gld.dismiss();
        }
    }

    public void dL(List<String> list) {
        this.iKm = list;
        if (this.iKn != null) {
            this.iKn.setData(list);
        }
    }

    public void ph(boolean z) {
        this.iIZ.ph(z);
    }

    public void qa(boolean z) {
        this.iJt = z;
    }

    public void cnA() {
        if (this.iJh != null) {
            this.iJh.dismiss();
        }
        if (this.iJi != null) {
            com.baidu.adp.lib.f.g.b(this.iJi, this.iyA.getPageContext());
        }
        if (this.iJj != null) {
            com.baidu.adp.lib.f.g.b(this.iJj, this.iyA.getPageContext());
        }
        if (this.iJg != null) {
            this.iJg.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.izO, this.izx);
            b(this.izO, this.izx, this.mType, i);
            this.iyA.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.iyA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.axQ);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.axQ, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iJu, R.drawable.personalize_tab_shadow);
            if (this.iIQ != null) {
                this.iIQ.onChangeSkinType(i);
            }
            if (this.iIU != null) {
                this.iIU.onChangeSkinType(i);
            }
            if (this.iIR != null) {
                this.iIR.onChangeSkinType(i);
            }
            if (this.iIS != null) {
                this.iIS.onChangeSkinType(i);
            }
            if (this.iIT != null) {
                this.iIT.onChangeSkinType(i);
            }
            if (this.gpB != null) {
                this.gpB.changeSkin(i);
                if (this.dyE != null) {
                    this.iyA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dyE);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.dyE, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.iJa != null) {
                this.iJa.c(this.iyA.getPageContext());
            }
            pY(this.iJq);
            this.iIZ.notifyDataSetChanged();
            if (this.iJd != null) {
                this.iJd.changeSkin(i);
            }
            if (this.Fq != null) {
                this.Fq.onChangeSkinType(i);
            }
            if (this.iJe != null) {
                this.iJe.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.fGl)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.fGl) {
                    customBlueCheckRadioButton.aEN();
                }
            }
            cmX();
            UtilHelper.setStatusBarBackground(this.axb, i);
            UtilHelper.setStatusBarBackground(this.iJL, i);
            if (this.iIV != null) {
                com.baidu.tbadk.q.a.a(this.iyA.getPageContext(), this.iIV);
            }
            if (this.iKb != null) {
                this.iKb.onChangeSkinType(i);
            }
            if (this.iIK != null) {
                if (this.iIQ != null) {
                    this.iIQ.yW(i);
                } else {
                    this.iIK.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.hbh != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hbh, (int) R.color.cp_cont_d);
                this.hbh.setBackgroundDrawable(com.baidu.tbadk.core.util.am.au(com.baidu.adp.lib.util.l.getDimens(this.iyA.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.iJz != null && this.izO != null) {
                if (this.izO.awd()) {
                    SvgManager.aDW().a(this.iJz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aDW().a(this.iJz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            if (this.iJA != null) {
                SvgManager.aDW().a(this.iJA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iJy != null) {
                SvgManager.aDW().a(this.iJy, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iJw != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iJw, R.drawable.bottom_shadow);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iJB, (int) R.color.cp_cont_b);
            if (this.iKo != null) {
                this.iKo.onChangeSkinType(i);
            }
            if (this.iJR != null) {
                this.iJR.onChangeSkinType();
            }
            if (this.iKl != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iKl, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iJx, R.color.cp_bg_line_h);
            if (this.iIP != null) {
                this.iIP.oT(i);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIi = iVar;
        this.iIZ.setOnImageClickListener(this.dIi);
        this.iKo.setOnImageClickListener(this.dIi);
    }

    public void g(NoNetworkView.a aVar) {
        this.ggy = aVar;
        if (this.fPl != null) {
            this.fPl.a(this.ggy);
        }
    }

    public void qb(boolean z) {
        this.iIZ.setIsFromCDN(z);
    }

    public Button cnB() {
        return this.iJv;
    }

    public void cnC() {
        if (this.iIJ != 2) {
            this.iIO.setNextPage(this.gpB);
            this.iIJ = 2;
        }
    }

    public void cnD() {
        if (com.baidu.tbadk.n.m.aOA().aOB()) {
            int lastVisiblePosition = this.iIO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iIO.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.dzk = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(R.id.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.n.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.setSubType(1001);
                        perfLog2.dzk = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean cnE() {
        return this.Fq != null && this.Fq.getVisibility() == 0;
    }

    public boolean cnF() {
        return this.Fq != null && this.Fq.aLE();
    }

    public void cnG() {
        if (this.Fq != null) {
            this.Fq.aJZ();
        }
    }

    public void qc(boolean z) {
        if (this.iJx != null) {
            qa(this.iyA.cjK().aMi());
            if (this.iJt) {
                pR(z);
            } else {
                pS(z);
            }
        }
    }

    public void cnH() {
        if (this.iJx != null) {
            this.iJw.setVisibility(8);
            this.iJx.setVisibility(8);
            this.iJC = false;
            if (this.iJR != null) {
                this.iJR.setVisibility(8);
                pW(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.fKp == null) {
            this.fKp = new com.baidu.tbadk.core.view.a(this.iyA.getPageContext());
        }
        this.fKp.setDialogVisiable(true);
    }

    public void bnJ() {
        if (this.fKp != null) {
            this.fKp.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.iIO.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.iIO.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iIQ != null) {
            this.iIQ.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.iKF = getScrollY();
            this.iJQ.iKU = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iJQ));
            a(this.iJQ.iKU, true);
        }
    }

    public void qd(boolean z) {
        if (this.iIQ != null) {
            this.iIQ.qd(z);
        }
    }

    private boolean b(AbsListView absListView, int i) {
        boolean z = true;
        if (absListView == null) {
            return false;
        }
        boolean z2 = i > 0;
        if (z2 || absListView.getChildCount() <= 0) {
            z = z2;
        } else if (absListView.getChildAt(0).getTop() >= absListView.getListPaddingTop()) {
            z = false;
        }
        return z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.iIQ != null) {
            this.iIQ.onScroll(absListView, i, i2, i3);
        }
        if (this.iIK != null && this.iIZ != null) {
            this.iIK.cy(this.iIZ.cjA());
        }
        this.iJQ.irt = i;
        this.iJQ.headerCount = this.iIO.getHeaderViewsCount();
        this.iJQ.iKU = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iJQ));
        pT(b(absListView, i));
        a(this.iJQ.iKU, false);
        if (this.gpB.aFb() && !this.gpB.dck) {
            if (this.iJQ != null && this.iJQ.iKU != null && this.iJQ.iKU.getView() != null) {
                i4 = this.iJQ.iKU.getView().getTop() < 0 ? this.iJQ.iKU.getView().getHeight() : this.iJQ.iKU.getView().getBottom();
            }
            this.gpB.kT(i4);
            this.gpB.dck = true;
        }
    }

    public void cnI() {
        if (TbadkCoreApplication.isLogin() && this.izO != null && this.iKg && !this.iKf && !this.iJr && this.iJF != null && this.iJF.azE() != null && !this.iJF.azE().getIsLike() && !this.iJF.azE().hadConcerned() && this.iKc == null) {
            this.iKc = new an(this.iyA);
        }
    }

    public void cnJ() {
        if (this.iKg && !this.iKf && this.iJF != null && this.iJF.azE() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").Z("obj_locate", this.iyA.ciJ() ? 2 : 1).Z("obj_type", this.iKf ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.iyA.getPageContext().getPageActivity(), this.iJF.azE().getUserId(), this.iJF.azE().getUserName(), this.iyA.ciU().ciK(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(am amVar, boolean z) {
        int measuredHeight;
        if (!this.iKf && this.iJK != null && this.iIK.cox() != null) {
            int cjw = this.iIZ.cjw();
            if (cjw > 0 && (amVar == null || amVar.getView().getParent() == null)) {
                if (cjw > this.iIO.getFirstVisiblePosition() - this.iIO.getHeaderViewsCount()) {
                    this.iJK.setVisibility(8);
                    return;
                }
                this.iJK.setVisibility(0);
                pT(false);
                this.iIK.mNavigationBar.hideBottomLine();
                if (this.iJK.getParent() != null && ((ViewGroup) this.iJK.getParent()).getHeight() <= this.iJK.getTop()) {
                    this.iJK.getParent().requestLayout();
                }
            } else if (amVar == null || amVar.getView() == null || amVar.iIk == null) {
                if (this.iIO.getFirstVisiblePosition() == 0) {
                    this.iJK.setVisibility(8);
                    this.iIK.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = amVar.getView().getTop();
                if (amVar.getView().getParent() != null) {
                    if (this.iJP) {
                        this.iJO = top;
                        this.iJP = false;
                    }
                    this.iJO = top < this.iJO ? top : this.iJO;
                }
                if (top != 0 || amVar.getView().isShown()) {
                    if (this.iIY.getY() < 0.0f) {
                        measuredHeight = iJN - amVar.iIk.getMeasuredHeight();
                    } else {
                        measuredHeight = this.iIK.cox().getMeasuredHeight() - amVar.iIk.getMeasuredHeight();
                        this.iIK.mNavigationBar.hideBottomLine();
                    }
                    if (amVar.getView().getParent() == null && top <= this.iJO) {
                        this.iJK.setVisibility(0);
                        pT(false);
                    } else if (top < measuredHeight) {
                        this.iJK.setVisibility(0);
                        pT(false);
                    } else {
                        this.iJK.setVisibility(8);
                        this.iIK.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.iJP = true;
                    }
                }
            }
        }
    }

    public void cnK() {
        if (!this.iKG) {
            TiebaStatic.log("c10490");
            this.iKG = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iyA.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(iJU, Integer.valueOf(iJW));
            aVar.jE(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.iyA.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aK(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.iyA);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iyA.getPageContext()).aBW();
        }
    }

    public void FF(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iyA.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.iyA.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aK(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(iJU, Integer.valueOf(iJX));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.iyA);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iyA.getPageContext()).aBW();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.azE() != null) {
            MetaData azE = b.azE();
            azE.setGiftNum(azE.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        r(fVar);
    }

    public PbInterviewStatusView cnL() {
        return this.iJI;
    }

    private void t(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.chK() != null && fVar.chK().aAK() && this.iJI == null) {
            this.iJI = (PbInterviewStatusView) this.iJH.inflate();
            this.iJI.setOnClickListener(this.gle);
            this.iJI.setCallback(this.iyA.ckw());
            this.iJI.setData(this.iyA, fVar);
        }
    }

    public RelativeLayout cnM() {
        return this.iIY;
    }

    public View cnN() {
        return this.axb;
    }

    public boolean cnO() {
        return this.iKv;
    }

    public void pm(boolean z) {
        this.iIT.pm(z);
    }

    public void FG(String str) {
        if (this.iIL != null) {
            this.iIL.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int qe(boolean z) {
        if (this.iJI == null || this.iJI.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cnP() {
        if (this.iJI != null && this.iJI.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iJI.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.iJI.setLayoutParams(layoutParams);
        }
    }

    public boolean cjQ() {
        return false;
    }

    public void FH(String str) {
        this.hbh.performClick();
        if (!StringUtils.isNull(str) && this.iyA.cjK() != null && this.iyA.cjK().aMb() != null && this.iyA.cjK().aMb().getInputView() != null) {
            EditText inputView = this.iyA.cjK().aMb().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cny();
            if (configuration.orientation == 2) {
                cnH();
                cmG();
            } else {
                cmK();
            }
            if (this.iKb != null) {
                this.iKb.cjF();
            }
            this.iyA.bBE();
            this.iIY.setVisibility(8);
            this.iIK.qp(false);
            this.iyA.pA(false);
            if (this.iIQ != null) {
                if (configuration.orientation == 1) {
                    cnM().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.iIO.setIsLandscape(true);
                    this.iIO.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.iIO.setIsLandscape(false);
                    if (this.iKF > 0) {
                        this.iIO.smoothScrollBy(this.iKF, 0);
                    }
                }
                this.iIQ.onConfigurationChanged(configuration);
                this.iJJ.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void qf(boolean z) {
        if (this.iIQ != null) {
            this.iIQ.qf(z);
        }
    }

    public boolean cnQ() {
        return this.iIQ != null && this.iIQ.cnQ();
    }

    public void cnR() {
        if (this.iIQ != null) {
            this.iIQ.cnR();
        }
    }

    public void pq(boolean z) {
        this.iIZ.pq(z);
    }

    public void cx(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.iJx.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.iyA.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.iKl = new TextView(this.iyA.getContext());
            this.iKl.setText(R.string.connection_tips);
            this.iKl.setGravity(17);
            this.iKl.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iyA.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.iyA.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iyA.getContext(), R.dimen.ds60);
            if (this.iKl.getParent() == null) {
                frameLayout.addView(this.iKl, layoutParams);
            }
            this.iKk = new PopupWindow(this.iyA.getContext());
            this.iKk.setContentView(frameLayout);
            this.iKk.setHeight(-2);
            this.iKk.setWidth(-2);
            this.iKk.setFocusable(true);
            this.iKk.setOutsideTouchable(false);
            this.iKk.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.iIO.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.iKk.showAsDropDown(aq.this.iJx, view.getLeft(), -aq.this.iJx.getHeight());
                    } else {
                        aq.this.iKk.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void qg(boolean z) {
        this.iKq = z;
    }

    public boolean cnS() {
        return this.iKq;
    }

    public PbThreadPostView cnT() {
        return this.iIP;
    }

    private void ac(boolean z, boolean z2) {
        ad(z, z2);
        if (this.izO != null && this.izO.chK() != null && this.izO.chK().azT() == 0 && !this.izO.chK().aAE()) {
            ae(z, z2);
        } else if (this.iIZ != null && this.iIZ.cjB() != null) {
            this.iIZ.cjB().b(this.izO, z, z2);
        }
    }

    private void ad(boolean z, boolean z2) {
        this.iIT.d(this.izO, z, z2);
    }

    private void ae(boolean z, boolean z2) {
        this.iIS.c(this.izO, z, z2);
    }
}
