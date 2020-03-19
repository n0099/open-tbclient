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
import android.support.v7.widget.RecyclerView;
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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
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
/* loaded from: classes9.dex */
public class an {
    private static final int iQB = UtilHelper.getLightStatusBarHeight();
    public static int iQH = 3;
    public static int iQI = 0;
    public static int iQJ = 3;
    public static int iQK = 4;
    public static int iQL = 5;
    public static int iQM = 6;
    private static a.InterfaceC0611a iRi = new a.InterfaceC0611a() { // from class: com.baidu.tieba.pb.pb.main.an.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0611a
        public void onRefresh() {
        }
    };
    private EditorTools FO;
    private View aCq;
    private View aDM;
    private RelativeLayout aDf;
    private View dDn;
    private g.c dhi;
    private com.baidu.tieba.pb.a.c drk;
    private List<CustomBlueCheckRadioButton> fMP;
    private NoNetworkView fVM;
    private NavigationBarCoverTip gOI;
    private com.baidu.tieba.NEGFeedBack.e gRC;
    private View.OnClickListener grn;
    private PbListView gvD;
    private TextView hiz;
    private PbFragment iFL;
    private View.OnClickListener iGF;
    private com.baidu.tieba.pb.data.e iGO;
    private PbFakeFloorModel iIL;
    PbFragment.c iKs;
    private ViewStub iPA;
    private PbLandscapeListView iPB;
    private PbThreadPostView iPC;
    private com.baidu.tieba.pb.pb.main.a.e iPD;
    private com.baidu.tieba.pb.pb.main.a.a iPE;
    private com.baidu.tieba.pb.pb.main.a.c iPF;
    private com.baidu.tieba.pb.pb.main.a.d iPG;
    private com.baidu.tieba.pb.pb.main.a.b iPH;
    private LinearLayout iPI;
    private TextView iPJ;
    private TextView iPK;
    private ObservedChangeRelativeLayout iPL;
    private f iPM;
    private View iPS;
    public int iPv;
    public final com.baidu.tieba.pb.pb.main.view.c iPx;
    public com.baidu.tieba.pb.pb.main.view.b iPy;
    private ViewStub iPz;
    private aj iQA;
    private PbEmotionBar iQF;
    private int iQN;
    private Runnable iQO;
    private s iQP;
    private ak iQQ;
    private int iQW;
    private PbTopTipView iQX;
    private PopupWindow iQY;
    private TextView iQZ;
    private View iQh;
    private View iQj;
    private View iQk;
    private ImageView iQl;
    private ImageView iQm;
    private ImageView iQn;
    private com.baidu.tieba.pb.view.c iQo;
    private TextView iQp;
    private int iQr;
    private int iQs;
    private PostData iQt;
    private ViewStub iQv;
    private PbInterviewStatusView iQw;
    private FrameLayout iQx;
    private View iQy;
    private View iQz;
    private List<String> iRa;
    private com.baidu.tieba.pb.pb.main.emotion.c iRb;
    private com.baidu.tieba.pb.pb.godreply.a iRc;
    private PbLandscapeListView.b iRd;
    private aa iRf;
    private String iRg;
    private long iRh;
    private boolean iRj;
    private Runnable iRn;
    private PbFragment.b iRp;
    public int iRt;
    private boolean isLandscape;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int iPw = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a iPN = null;
    private com.baidu.tbadk.core.dialog.b grm = null;
    private View iPO = null;
    private EditText iPP = null;
    private com.baidu.tieba.pb.view.d iPQ = null;
    private com.baidu.tieba.pb.view.a iPR = null;
    private b.a hFg = null;
    private TbRichTextView.i dNb = null;
    private NoNetworkView.a gmG = null;
    private com.baidu.tbadk.core.dialog.i iPT = null;
    private com.baidu.tbadk.core.dialog.a iPU = null;
    private Dialog iPV = null;
    private Dialog iPW = null;
    private View iPX = null;
    private LinearLayout iPY = null;
    private CompoundButton.OnCheckedChangeListener fMQ = null;
    private TextView iPZ = null;
    private TextView iQa = null;
    private String iQb = null;
    private com.baidu.tbadk.core.dialog.i iJv = null;
    private com.baidu.tbadk.core.dialog.i iQc = null;
    private boolean iQd = false;
    private boolean iQe = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView iQf = null;
    private boolean iQg = false;
    private Button iQi = null;
    private boolean iQq = true;
    private com.baidu.tbadk.core.view.a fQQ = null;
    private boolean iGx = false;
    private int mSkinType = 3;
    private boolean iQu = false;
    private int iQC = 0;
    private boolean iQD = true;
    public a iQE = new a();
    private int iQG = 0;
    private boolean iQR = false;
    private int iQS = 0;
    private boolean iQT = false;
    private boolean iQU = false;
    private boolean iQV = false;
    private boolean iRe = false;
    private String iRk = null;
    private CustomMessageListener iRl = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.an.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                an.this.iRk = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.iPM != null) {
                an.this.iPM.notifyDataSetChanged();
            }
        }
    };
    private Handler iRm = new Handler();
    private CustomMessageListener iRo = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.iQq = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean iRq = true;
    View.OnClickListener iRr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || an.this.iGO == null || an.this.iGO.ckP() == null || an.this.iGO.ckP().aCr() == null || an.this.iGO.ckP().aCr().getAlaUserData() == null || an.this.iGO.ckP().aCr().getAlaUserData().live_status != 1 || an.this.iGO.ckP().aCr().getAlaUserData().live_id <= 0) {
                if (an.this.iQT) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").X("obj_id", 2));
                }
                if (!an.this.iQT && an.this.iGO != null && an.this.iGO.ckP() != null && an.this.iGO.ckP().aCr() != null && an.this.iGO.ckP().aCr().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").X("obj_locate", 1));
                }
                if (an.this.iFL.cnE() != null) {
                    an.this.iFL.cnE().iFX.gSp.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = an.this.iGO.ckP().aCr().getAlaUserData().live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(an.this.iFL.cnE(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
        }
    };
    private boolean aqm = false;
    String userId = null;
    private final List<TbImageView> iRs = new ArrayList();
    private boolean iRu = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public aj iRI;
        public int iyG;
    }

    public void ql(boolean z) {
        this.iQR = z;
        if (this.iPB != null) {
            this.iQS = this.iPB.getHeaderViewsCount();
        }
    }

    public void cpA() {
        if (this.iPB != null) {
            int headerViewsCount = this.iPB.getHeaderViewsCount() - this.iQS;
            final int firstVisiblePosition = (this.iPB.getFirstVisiblePosition() == 0 || this.iPB.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.iPB.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.iPB.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.iQE.iRI = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iQE));
            final aj ajVar = this.iQE.iRI;
            final int f = f(ajVar);
            final int y = ((int) this.iPL.getY()) + this.iPL.getMeasuredHeight();
            final boolean z = this.iQy.getVisibility() == 0;
            boolean z2 = this.iPL.getY() < 0.0f;
            if ((z && ajVar != null) || firstVisiblePosition >= this.iPM.cmx() + this.iPB.getHeaderViewsCount()) {
                int measuredHeight = ajVar != null ? ajVar.iOY.getMeasuredHeight() : 0;
                if (z2) {
                    this.iPB.setSelectionFromTop(this.iPM.cmx() + this.iPB.getHeaderViewsCount(), iQB - measuredHeight);
                } else {
                    this.iPB.setSelectionFromTop(this.iPM.cmx() + this.iPB.getHeaderViewsCount(), this.iPx.crv().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.iPB.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.iQT && this.iPD != null) {
                this.iPB.setSelectionFromTop(this.iPM.cmx() + this.iPB.getHeaderViewsCount(), this.iPD.crh());
            } else if (this.mType == 6) {
                this.iPB.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cnO() {
                        ViewGroup.LayoutParams layoutParams;
                        if (f >= 0 && f <= an.this.aDf.getMeasuredHeight()) {
                            int f2 = an.this.f(ajVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            if (an.this.aDM != null && (layoutParams = an.this.aDM.getLayoutParams()) != null) {
                                if (i == 0 || i > an.this.aDf.getMeasuredHeight() || f2 >= an.this.aDf.getMeasuredHeight()) {
                                    layoutParams.height = an.this.iQN;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.aDf.getMeasuredHeight()) {
                                    layoutParams.height = an.this.iQN;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    an.this.iPB.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                an.this.aDM.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (an.this.aDM != null && an.this.aDM.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = an.this.aDM.getLayoutParams();
                                            layoutParams2.height = an.this.iQN;
                                            an.this.aDM.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        an.this.iPB.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(aj ajVar) {
        if (ajVar == null || ajVar.getView() == null) {
            return 0;
        }
        if (ajVar.getView().getTop() != 0 || ajVar.getView().isShown()) {
            return ajVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView cpB() {
        return this.fVM;
    }

    public void cpC() {
        if (this.FO != null) {
            this.FO.hide();
            if (this.iRb != null) {
                this.iRb.crj();
            }
        }
    }

    public PbFakeFloorModel cpD() {
        return this.iIL;
    }

    public s cpE() {
        return this.iQP;
    }

    public com.baidu.tieba.pb.pb.main.a.e cpF() {
        return this.iPD;
    }

    public void cpG() {
        reset();
        cpC();
        this.iQP.cmF();
        qx(false);
    }

    private void reset() {
        if (this.iFL != null && this.iFL.cmK() != null && this.FO != null) {
            com.baidu.tbadk.editortools.pb.a.aOU().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cmK = this.iFL.cmK();
            cmK.aPo();
            cmK.aOI();
            if (cmK.getWriteImagesInfo() != null) {
                cmK.getWriteImagesInfo().setMaxImagesAllowed(cmK.isBJH ? 1 : 9);
            }
            cmK.mx(SendView.ALL);
            cmK.my(SendView.ALL);
            com.baidu.tbadk.editortools.g mo = this.FO.mo(23);
            com.baidu.tbadk.editortools.g mo2 = this.FO.mo(2);
            com.baidu.tbadk.editortools.g mo3 = this.FO.mo(5);
            if (mo2 != null) {
                mo2.display();
            }
            if (mo3 != null) {
                mo3.display();
            }
            if (mo != null) {
                mo.hide();
            }
            this.FO.invalidate();
        }
    }

    public boolean cpH() {
        return this.iQq;
    }

    public void qm(boolean z) {
        if (this.iQk != null && this.hiz != null) {
            this.hiz.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iQk.startAnimation(alphaAnimation);
            }
            this.iQj.setVisibility(0);
            this.iQk.setVisibility(0);
            this.iQq = true;
            if (this.iQF != null && !this.iRc.isActive()) {
                this.iQF.setVisibility(0);
                qr(true);
            }
        }
    }

    public void qn(boolean z) {
        if (this.iQk != null && this.hiz != null) {
            this.hiz.setText(cpI());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iQk.startAnimation(alphaAnimation);
            }
            this.iQj.setVisibility(0);
            this.iQk.setVisibility(0);
            this.iQq = true;
            if (this.iQF != null && !this.iRc.isActive()) {
                this.iQF.setVisibility(0);
                qr(true);
            }
        }
    }

    public String cpI() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.iRg)) {
            return this.iRg;
        }
        if (this.iFL != null) {
            this.iRg = TbadkCoreApplication.getInst().getResources().getString(am.cpx());
        }
        return this.iRg;
    }

    public PostData cpJ() {
        int i = 0;
        if (this.iPB == null) {
            return null;
        }
        int cpK = cpK() - this.iPB.getHeaderViewsCount();
        if (cpK < 0) {
            cpK = 0;
        }
        if (this.iPM.yO(cpK) != null && this.iPM.yO(cpK) != PostData.kih) {
            i = cpK + 1;
        }
        return this.iPM.getItem(i) instanceof PostData ? (PostData) this.iPM.getItem(i) : null;
    }

    public int cpK() {
        int i;
        View childAt;
        if (this.iPB == null) {
            return 0;
        }
        int firstVisiblePosition = this.iPB.getFirstVisiblePosition();
        int lastVisiblePosition = this.iPB.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.iPB.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.iPB.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cpL() {
        return this.iPB.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.iGO != null && this.iGO.ckR() != null && !this.iGO.ckR().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.iGO.ckR().size() && (postData = this.iGO.ckR().get(i)) != null && postData.aCr() != null && !StringUtils.isNull(postData.aCr().getUserId()); i++) {
                if (this.iGO.ckR().get(i).aCr().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.iRc != null && this.iRc.isActive()) {
                        qx(false);
                    }
                    if (this.iQF != null) {
                        this.iQF.qG(true);
                    }
                    this.iRk = postData.aCr().getName_show();
                    return;
                }
            }
        }
    }

    public an(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.iFL = null;
        this.aDf = null;
        this.aCq = null;
        this.iPB = null;
        this.iPM = null;
        this.gvD = null;
        this.dDn = null;
        this.grn = null;
        this.iGF = null;
        this.iQk = null;
        this.hiz = null;
        this.iQv = null;
        this.iQW = 0;
        this.iRh = 0L;
        this.iRh = System.currentTimeMillis();
        this.iFL = pbFragment;
        this.grn = onClickListener;
        this.drk = cVar;
        this.iQW = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iFL.getContext()) / 2;
        this.aDf = (RelativeLayout) LayoutInflater.from(this.iFL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.aDf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iQh = this.aDf.findViewById(R.id.bottom_shadow);
        this.gOI = (NavigationBarCoverTip) this.aDf.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.aCq = this.aDf.findViewById(R.id.statebar_view);
        this.iPL = (ObservedChangeRelativeLayout) this.aDf.findViewById(R.id.title_wrapper);
        this.fVM = (NoNetworkView) this.aDf.findViewById(R.id.view_no_network);
        this.iPB = (PbLandscapeListView) this.aDf.findViewById(R.id.new_pb_list);
        this.iQx = (FrameLayout) this.aDf.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.iFL.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iFL.getActivity(), R.dimen.ds88));
        this.iPB.addHeaderView(this.textView, 0);
        this.iPB.setTextViewAdded(true);
        this.iQN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aDM = new View(this.iFL.getPageContext().getPageActivity());
        this.aDM.setLayoutParams(new AbsListView.LayoutParams(-1, this.iQN));
        this.aDM.setVisibility(4);
        this.iPB.addFooterView(this.aDM);
        this.iPB.setOnTouchListener(this.iFL.dsa);
        this.iPx = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.aDf);
        if (this.iFL.cno()) {
            this.iPz = (ViewStub) this.aDf.findViewById(R.id.manga_view_stub);
            this.iPz.setVisibility(0);
            this.iPy = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.iPy.show();
            this.iPx.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iFL.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.iPx.crv().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0569a() { // from class: com.baidu.tieba.pb.pb.main.an.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0569a
            public void clH() {
                if (an.this.iPB != null) {
                    if (an.this.iPD != null) {
                        an.this.iPD.crg();
                    }
                    an.this.iPB.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0569a
            public void clI() {
                an.this.iFL.bEv();
            }
        }));
        this.iQj = this.aDf.findViewById(R.id.view_comment_top_line);
        this.iQk = this.aDf.findViewById(R.id.pb_editor_tool_comment);
        this.iQr = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iQs = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hiz = (TextView) this.aDf.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hiz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.iFL.cmV();
                if (an.this.iFL != null && an.this.iFL.clX() != null && an.this.iFL.clX().getPbData() != null && an.this.iFL.clX().getPbData().ckP() != null && an.this.iFL.clX().getPbData().ckP().aCr() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cx("tid", an.this.iFL.clX().iLJ).cx("fid", an.this.iFL.clX().getPbData().getForumId()).X("obj_locate", 1).cx("uid", an.this.iFL.clX().getPbData().ckP().aCr().getUserId()));
                }
            }
        });
        this.iQl = (ImageView) this.aDf.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iQl.setOnClickListener(this.grn);
        boolean booleanExtra = this.iFL.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iQm = (ImageView) this.aDf.findViewById(R.id.pb_editor_tool_collection);
        this.iQm.setOnClickListener(this.grn);
        if (booleanExtra) {
            this.iQm.setVisibility(8);
        } else {
            this.iQm.setVisibility(0);
        }
        this.iQn = (ImageView) this.aDf.findViewById(R.id.pb_editor_tool_share);
        this.iQn.setOnClickListener(this.grn);
        this.iQo = new com.baidu.tieba.pb.view.c(this.iQn);
        this.iQo.cuD();
        this.iQp = (TextView) this.aDf.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.iQv = (ViewStub) this.aDf.findViewById(R.id.interview_status_stub);
        this.iPE = new com.baidu.tieba.pb.pb.main.a.a(this.iFL, cVar);
        this.iPG = new com.baidu.tieba.pb.pb.main.a.d(this.iFL, cVar, this.grn);
        this.iPM = new f(this.iFL, this.iPB);
        this.iPM.D(this.grn);
        this.iPM.setTbGestureDetector(this.drk);
        this.iPM.setOnImageClickListener(this.dNb);
        this.iGF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.27
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
                            an.this.iFL.b(sparseArray);
                            return;
                        }
                        an.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        an.this.iFL.b(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.iPM.P(this.iGF);
        cpQ();
        cpR();
        this.iPG.b(this.iPB);
        this.iPF.b(this.iPB);
        this.iPE.b(this.iPB);
        this.gvD = new PbListView(this.iFL.getPageContext().getPageActivity());
        this.dDn = this.gvD.getView().findViewById(R.id.pb_more_view);
        if (this.dDn != null) {
            this.dDn.setOnClickListener(this.grn);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.dDn, R.drawable.pb_foot_more_trans_selector);
        }
        this.gvD.setLineVisible();
        this.gvD.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.gvD.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iPS = this.aDf.findViewById(R.id.viewstub_progress);
        this.iFL.registerListener(this.iRo);
        this.iIL = new PbFakeFloorModel(this.iFL.getPageContext());
        this.iQP = new s(this.iFL.getPageContext(), this.iIL, this.aDf);
        this.iQP.a(this.iFL.iKn);
        this.iIL.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                an.this.iIL.q(postData);
                an.this.iPM.notifyDataSetChanged();
                an.this.iQP.cmF();
                an.this.FO.aMV();
                an.this.qx(false);
            }
        });
        if (this.iFL.clX() != null && !StringUtils.isNull(this.iFL.clX().coC())) {
            this.iFL.showToast(this.iFL.clX().coC());
        }
        this.iQy = this.aDf.findViewById(R.id.pb_expand_blank_view);
        this.iQz = this.aDf.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iQz.getLayoutParams();
        if (this.iFL.clX() != null && this.iFL.clX().cnX()) {
            this.iQy.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.iQz.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = iQB;
            this.iQz.setLayoutParams(layoutParams2);
        }
        this.iQA = new aj(this.iFL.getPageContext(), this.aDf.findViewById(R.id.pb_reply_expand_view));
        this.iQA.iOY.setVisibility(8);
        this.iQA.Q(this.grn);
        this.iFL.registerListener(this.mAccountChangedListener);
        this.iFL.registerListener(this.iRl);
        cpM();
        qr(false);
    }

    public void qo(boolean z) {
        this.iQh.setVisibility(z ? 0 : 8);
    }

    public void bPQ() {
        if (!this.iFL.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").X("obj_locate", 2).cx("fid", this.mForumId));
        } else if (this.iFL.cmX()) {
            com.baidu.tbadk.editortools.pb.e cmK = this.iFL.cmK();
            if (cmK != null && (cmK.aPl() || cmK.aPm())) {
                this.iFL.cmK().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.FO != null) {
                cpW();
            }
            if (this.FO != null) {
                this.iQq = false;
                if (this.FO.mr(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.iFL.getPageContext(), (View) this.FO.mr(2).dxa, false, iRi);
                }
            }
            cqE();
        }
    }

    private void cpM() {
        this.iRc = new com.baidu.tieba.pb.pb.godreply.a(this.iFL, this, (ViewStub) this.aDf.findViewById(R.id.more_god_reply_popup));
        this.iRc.y(this.grn);
        this.iRc.P(this.iGF);
        this.iRc.setOnImageClickListener(this.dNb);
        this.iRc.y(this.grn);
        this.iRc.setTbGestureDetector(this.drk);
    }

    public com.baidu.tieba.pb.pb.godreply.a cpN() {
        return this.iRc;
    }

    public View cpO() {
        return this.iQy;
    }

    public void cpP() {
        if (this.iPB != null) {
            this.iPF.c(this.iPB);
            this.iPG.c(this.iPB);
            this.iPH.c(this.iPB);
            this.iPE.c(this.iPB);
        }
    }

    private void cpQ() {
        if (this.iPH == null) {
            this.iPH = new com.baidu.tieba.pb.pb.main.a.b(this.iFL, this.grn);
        }
    }

    private void cpR() {
        if (this.iPF == null) {
            this.iPF = new com.baidu.tieba.pb.pb.main.a.c(this.iFL, this.drk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpS() {
        if (this.iFL.cno()) {
            this.iPA = (ViewStub) this.aDf.findViewById(R.id.manga_mention_controller_view_stub);
            this.iPA.setVisibility(0);
            if (this.iPI == null) {
                this.iPI = (LinearLayout) this.aDf.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.iFL.getPageContext(), this.iPI);
            }
            if (this.iPJ == null) {
                this.iPJ = (TextView) this.iPI.findViewById(R.id.manga_prev_btn);
            }
            if (this.iPK == null) {
                this.iPK = (TextView) this.iPI.findViewById(R.id.manga_next_btn);
            }
            this.iPJ.setOnClickListener(this.grn);
            this.iPK.setOnClickListener(this.grn);
        }
    }

    private void cpT() {
        if (this.iFL.cno()) {
            if (this.iFL.cnr() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iPJ, R.color.cp_cont_e, 1);
            }
            if (this.iFL.cns() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iPK, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cpU() {
        if (this.iPI == null) {
            cpS();
        }
        this.iPA.setVisibility(8);
        if (this.iRm != null && this.iRn != null) {
            this.iRm.removeCallbacks(this.iRn);
        }
    }

    public void cpV() {
        if (this.iRm != null) {
            if (this.iRn != null) {
                this.iRm.removeCallbacks(this.iRn);
            }
            this.iRn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.3
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.iPI == null) {
                        an.this.cpS();
                    }
                    an.this.iPA.setVisibility(0);
                }
            };
            this.iRm.postDelayed(this.iRn, 2000L);
        }
    }

    public void qp(boolean z) {
        this.iPx.qp(z);
        if (z && this.iQu) {
            this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iPB.setNextPage(this.gvD);
            this.iPw = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        this.FO.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.FO.getParent() == null) {
            this.aDf.addView(this.FO, layoutParams);
        }
        this.FO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.FO.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.an.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJB() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJB() == EmotionGroupType.USER_COLLECT) {
                        if (an.this.mPermissionJudgePolicy == null) {
                            an.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        an.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        an.this.mPermissionJudgePolicy.appendRequestPermission(an.this.iFL.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!an.this.mPermissionJudgePolicy.startRequestPermission(an.this.iFL.getBaseFragmentActivity())) {
                            an.this.iFL.cmK().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            an.this.iFL.cmK().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cpC();
        this.iFL.cmK().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.an.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (an.this.FO != null && an.this.FO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (an.this.iRb == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, an.this.FO.getId());
                            an.this.iRb = new com.baidu.tieba.pb.pb.main.emotion.c(an.this.iFL.getPageContext(), an.this.aDf, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(an.this.iRa)) {
                                an.this.iRb.setData(an.this.iRa);
                            }
                            an.this.iRb.b(an.this.FO);
                        }
                        an.this.iRb.Gl(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (an.this.iFL.iJu != null && an.this.iFL.iJu.cqT() != null) {
                    if (!an.this.iFL.iJu.cqT().cUA()) {
                        an.this.iFL.iJu.qC(false);
                    }
                    an.this.iFL.iJu.cqT().tO(false);
                }
            }
        });
    }

    public void cpW() {
        if (this.iFL != null && this.FO != null) {
            this.FO.display();
            if (this.iFL.cmK() != null) {
                this.iFL.cmK().aPb();
            }
            cqE();
        }
    }

    public void qq(boolean z) {
        if (this.iPB != null && this.textView != null && this.aCq != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aCq.setVisibility(0);
                } else {
                    this.aCq.setVisibility(8);
                    this.iPB.removeHeaderView(this.textView);
                    this.iPB.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = iQB;
                    this.textView.setLayoutParams(layoutParams);
                }
                cqk();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + qz(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cqk();
            cqM();
        }
    }

    public f cpX() {
        return this.iPM;
    }

    public void a(PbFragment.c cVar) {
        this.iKs = cVar;
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iFL.getContext());
        kVar.setTitleText(this.iFL.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iPT.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            an.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (an.this.iRp != null) {
                                an.this.iRp.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            an.this.iFL.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iFL.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iFL.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cqL()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.iFL.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iFL.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iFL.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iPT == null) {
            this.iPT = new com.baidu.tbadk.core.dialog.i(this.iFL.getPageContext(), kVar);
        } else {
            this.iPT.a(kVar);
        }
        this.iPT.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.iRp = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iFL != null && aVar != null) {
            if (this.gRC == null && this.iPE != null) {
                this.gRC = new com.baidu.tieba.NEGFeedBack.e(this.iFL.getPageContext(), this.iPE.crd());
            }
            AntiData bDg = this.iFL.bDg();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bDg != null && bDg.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bDg.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gRC.setDefaultReasonArray(new String[]{this.iFL.getString(R.string.delete_thread_reason_1), this.iFL.getString(R.string.delete_thread_reason_2), this.iFL.getString(R.string.delete_thread_reason_3), this.iFL.getString(R.string.delete_thread_reason_4), this.iFL.getString(R.string.delete_thread_reason_5)});
            this.gRC.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gRC.wo(str);
            this.gRC.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.an.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    an.this.iFL.a(aVar, jSONArray);
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
        sparseArray.put(iQI, Integer.valueOf(iQJ));
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
        this.iPU = new com.baidu.tbadk.core.dialog.a(this.iFL.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iPU.jW(i3);
        } else {
            this.iPU.setOnlyMessageShowCenter(false);
            this.iPU.sS(str2);
        }
        this.iPU.setYesButtonTag(sparseArray);
        this.iPU.a(R.string.dialog_ok, this.iFL);
        this.iPU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iPU.fH(true);
        this.iPU.b(this.iFL.getPageContext());
        if (z) {
            this.iPU.aEG();
        } else {
            a(this.iPU, i);
        }
    }

    public void aM(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.iPX == null) {
            this.iPX = LayoutInflater.from(this.iFL.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iFL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iPX);
        if (this.iPW == null) {
            this.iPW = new Dialog(this.iFL.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iPW.setCanceledOnTouchOutside(true);
            this.iPW.setCancelable(true);
            this.iQf = (ScrollView) this.iPX.findViewById(R.id.good_scroll);
            this.iPW.setContentView(this.iPX);
            WindowManager.LayoutParams attributes = this.iPW.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iPW.getWindow().setAttributes(attributes);
            this.fMQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.iQb = (String) compoundButton.getTag();
                        if (an.this.fMP != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : an.this.fMP) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && an.this.iQb != null && !str.equals(an.this.iQb)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iPY = (LinearLayout) this.iPX.findViewById(R.id.good_class_group);
            this.iQa = (TextView) this.iPX.findViewById(R.id.dialog_button_cancel);
            this.iQa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.iPW instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(an.this.iPW, an.this.iFL.getPageContext());
                    }
                }
            });
            this.iPZ = (TextView) this.iPX.findViewById(R.id.dialog_button_ok);
            this.iPZ.setOnClickListener(this.grn);
        }
        this.iPY.removeAllViews();
        this.fMP = new ArrayList();
        CustomBlueCheckRadioButton ed = ed("0", this.iFL.getPageContext().getString(R.string.thread_good_class));
        this.fMP.add(ed);
        ed.setChecked(true);
        this.iPY.addView(ed);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAM()) && adVar.aAN() > 0) {
                    CustomBlueCheckRadioButton ed2 = ed(String.valueOf(adVar.aAN()), adVar.aAM());
                    this.fMP.add(ed2);
                    View view = new View(this.iFL.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iPY.addView(view);
                    this.iPY.addView(ed2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iQf.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iFL.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iFL.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iFL.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iQf.setLayoutParams(layoutParams2);
            this.iQf.removeAllViews();
            if (this.iPY != null && this.iPY.getParent() == null) {
                this.iQf.addView(this.iPY);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iPW, this.iFL.getPageContext());
    }

    private CustomBlueCheckRadioButton ed(String str, String str2) {
        Activity pageActivity = this.iFL.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fMQ);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cpY() {
        this.iFL.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.iFL.hideProgressBar();
        if (z && z2) {
            this.iFL.showToast(this.iFL.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.iFL.showToast(str);
        }
    }

    public void bWL() {
        this.iPS.setVisibility(0);
    }

    public void bWK() {
        this.iPS.setVisibility(8);
    }

    public View cpZ() {
        if (this.iPX != null) {
            return this.iPX.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cqa() {
        return this.iQb;
    }

    public View getView() {
        return this.aDf;
    }

    public void cqb() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iFL.getPageContext().getPageActivity(), this.iFL.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.iFL.hideProgressBar();
        if (z) {
            cqu();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cqv();
        } else {
            cqu();
        }
    }

    public void cqc() {
        this.gvD.setLineVisible();
        this.gvD.startLoadData();
    }

    public void cqd() {
        this.iFL.hideProgressBar();
        endLoadData();
        this.iPB.completePullRefreshPostDelayed(0L);
        cqp();
    }

    public void cqe() {
        this.iPB.completePullRefreshPostDelayed(0L);
        cqp();
    }

    private void qr(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.iPG.b(onLongClickListener);
        this.iPM.setOnLongClickListener(onLongClickListener);
        if (this.iRc != null) {
            this.iRc.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.iJv != null) {
            this.iJv.dismiss();
            this.iJv = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iFL.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iFL.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iFL.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iFL.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iFL.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iQc.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iQc = new com.baidu.tbadk.core.dialog.i(this.iFL.getPageContext(), kVar);
        this.iQc.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iQc != null) {
            this.iQc.dismiss();
            this.iQc = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iFL.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.iGO != null && this.iGO.ckP() != null && !this.iGO.ckP().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iFL.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iFL.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iQc.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iQc = new com.baidu.tbadk.core.dialog.i(this.iFL.getPageContext(), kVar);
        this.iQc.showDialog();
    }

    public int cqf() {
        return zl(this.iPB.getFirstVisiblePosition());
    }

    private int zl(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.iPB.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.iPB.getAdapter() == null || !(this.iPB.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.iPB.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cqg() {
        int lastVisiblePosition = this.iPB.getLastVisiblePosition();
        if (this.iPD != null) {
            if (lastVisiblePosition == this.iPB.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return zl(lastVisiblePosition);
    }

    public void zm(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.iPB != null) {
            if (this.iPx == null || this.iPx.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.iPx.mNavigationBar.getFixedNavHeight();
                if (this.iFL.cne() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.iQz != null && (layoutParams = (LinearLayout.LayoutParams) this.iQz.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.iQz.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.iPB.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.iPB.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.iPB.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.iPP.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.iPM.a(eVar, false);
        this.iPM.notifyDataSetChanged();
        cqp();
        if (this.iRc != null) {
            this.iRc.clT();
        }
        ArrayList<PostData> ckR = eVar.ckR();
        if (eVar.getPage().aBn() == 0 || ckR == null || ckR.size() < eVar.getPage().aBm()) {
            if (com.baidu.tbadk.core.util.v.getCount(ckR) == 0 || (com.baidu.tbadk.core.util.v.getCount(ckR) == 1 && ckR.get(0) != null && ckR.get(0).cLv() == 1)) {
                if (this.iQE == null || this.iQE.iRI == null || this.iQE.iRI.getView() == null) {
                    i = 0;
                } else {
                    i = this.iQE.iRI.getView().getTop() < 0 ? this.iQE.iRI.getView().getHeight() : this.iQE.iRI.getView().getBottom();
                }
                if (this.iFL.cny()) {
                    this.gvD.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.gvD.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aBn() == 0) {
                    this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.gvD.aHM();
            }
        }
        q(eVar);
    }

    public void p(com.baidu.tieba.pb.data.e eVar) {
        if (this.iPE != null) {
            this.iPE.e(eVar, this.iGx);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckZ() != null) {
            return eVar.ckZ();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckR())) {
            Iterator<PostData> it = eVar.ckR().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLv() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckW();
        }
        if (!o(postData)) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCr() != null && postData.aCr().getUserTbVipInfoData() != null && postData.aCr().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCr().getGodUserData().setIntro(postData.aCr().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean o(PostData postData) {
        if (postData == null || postData.aCr() == null) {
            return false;
        }
        MetaData aCr = postData.aCr();
        return (TextUtils.isEmpty(aCr.getUserId()) && TextUtils.isEmpty(aCr.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.ckP() == null || eVar.ckP().aCr() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCr = eVar.ckP().aCr();
        String userId = aCr.getUserId();
        HashMap<String, MetaData> userMap = eVar.ckP().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCr;
        }
        postData.CE(1);
        postData.setId(eVar.ckP().aCH());
        postData.setTitle(eVar.ckP().getTitle());
        postData.setTime(eVar.ckP().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.ckP() != null) {
            if (this.iFL.clN()) {
                if (eVar.ckO() != null) {
                    this.mForumName = eVar.ckO().getForumName();
                    this.mForumId = eVar.ckO().getForumId();
                }
                if (this.mForumName == null && this.iFL.clX() != null && this.iFL.clX().clO() != null) {
                    this.mForumName = this.iFL.clX().clO();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.iPG.setVisibility(8);
            if (eVar.aHP()) {
                this.iQT = true;
                this.iPx.qN(true);
                this.iPx.mNavigationBar.hideBottomLine();
                if (this.iPD == null) {
                    this.iPD = new com.baidu.tieba.pb.pb.main.a.e(this.iFL);
                }
                this.iPD.a(eVar, b, this.iPB, this.iPG, this.iQx, this.iPx, this.mForumName, this.iRh);
                this.iPD.R(this.iRr);
                cqk();
            } else {
                this.iQT = false;
                this.iPx.qN(this.iQT);
                if (this.iPD != null) {
                    this.iPD.c(this.iPB);
                }
            }
            if (this.iFL.cmN() != null) {
                this.iFL.cmN().qH(this.iQT);
            }
            if (b != null) {
                this.iQt = b;
                this.iPG.setVisibility(0);
                SparseArray<Object> crf = this.iPG.crf();
                crf.put(R.id.tag_clip_board, b);
                crf.put(R.id.tag_is_subpb, false);
                this.iPH.a(eVar, this.iPB);
                this.iPF.w(eVar);
                this.iPE.e(eVar, this.iGx);
                this.iPE.v(eVar);
                this.iPG.a(this.mSkinType, this.iGO, b, this.iRr);
                if (this.iQA != null) {
                    if (eVar.cln()) {
                        this.iQA.getView().setVisibility(8);
                    } else {
                        this.iQA.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iEq);
                        if (eVar.ckP() != null) {
                            jVar.iEs = eVar.ckP().aCi();
                        }
                        jVar.isNew = !this.iGx;
                        jVar.sortType = eVar.iDq;
                        jVar.iEu = eVar.clo();
                        jVar.iEv = this.iFL.cny();
                        this.iQA.a(jVar);
                    }
                }
                if (eVar != null && eVar.ckP() != null) {
                    af(eVar.ckP().aCn() == 1, eVar.ckP().aCm() == 1);
                }
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (an.this.iPM != null && an.this.iPx != null && an.this.iPx.iVE != null && an.this.iGO != null && an.this.iGO.ckP() != null && !an.this.iGO.ckP().aBe() && !an.this.cqo() && an.this.iGO.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(an.this.iGO.getForum().getName())) {
                            if (an.this.iPM.cmB() == null || !an.this.iPM.cmB().isShown()) {
                                an.this.iPx.iVE.setVisibility(0);
                                if (an.this.iFL != null && an.this.iFL.clX() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.cx("tid", an.this.iFL.clX().cnU());
                                    anVar.cx("fid", an.this.iFL.clX().getForumId());
                                    anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void qs(boolean z) {
        if (z) {
            cqh();
        } else {
            byQ();
        }
        this.iQE.iRI = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iQE));
        a(this.iQE.iRI, false);
    }

    public void cqh() {
        if (this.iPx != null && !this.iQV) {
            this.iPx.cqh();
            this.iQV = true;
        }
    }

    public void byQ() {
        if (this.iPx != null) {
            this.iPx.crD();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.iPG.a(postData, eVar);
    }

    public void cqi() {
        if (this.iPD != null) {
            this.iPD.d(this.iPB);
        }
    }

    public boolean cqj() {
        return this.aqm;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aJ(bj bjVar) {
        if (bjVar == null || bjVar.aCr() == null) {
            return false;
        }
        PostData b = b(this.iGO, false);
        String str = "";
        if (b != null && b.aCr() != null) {
            str = b.aCr().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.iPx.crB();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.iPx.DU(dVar.forumName);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.f.b.toInt(dVar.source, 0)) {
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
            final String str2 = dVar.iDi;
            this.iFL.showNetRefreshView(this.aDf, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.aGK().b(an.this.iFL.getPageContext(), new String[]{str2});
                        an.this.iFL.finish();
                        return;
                    }
                    an.this.iFL.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cpn;
        Parcelable cpn2;
        if (eVar != null && this.iPB != null) {
            this.iGO = eVar;
            this.mType = i;
            if (eVar.ckP() != null) {
                this.iQG = eVar.ckP().aBY();
                if (eVar.ckP().getAnchorLevel() != 0) {
                    this.aqm = true;
                }
                this.iQe = aJ(eVar.ckP());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            u(eVar);
            this.iQu = false;
            this.iGx = z;
            cqd();
            if (eVar.iDr != null && eVar.iDr.clt()) {
                if (this.iPC == null) {
                    this.iPC = new PbThreadPostView(this.iFL.getContext());
                    this.iPB.addHeaderView(this.iPC, 1);
                    this.iPC.setData(eVar);
                    this.iPC.setChildOnClickLinstener(this.grn);
                }
            } else if (this.iPC != null && this.iPB != null) {
                this.iPB.removeHeaderView(this.iPC);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            r(eVar);
            if (this.iRf == null) {
                this.iRf = new aa(this.iFL.getPageContext(), this.gOI);
            }
            this.iRf.Gb(eVar.ckU());
            if (this.iFL.cno()) {
                if (this.iPQ == null) {
                    this.iPQ = new com.baidu.tieba.pb.view.d(this.iFL.getPageContext());
                    this.iPQ.createView();
                    this.iPQ.setListPullRefreshListener(this.dhi);
                }
                this.iPB.setPullRefresh(this.iPQ);
                cqk();
                if (this.iPQ != null) {
                    this.iPQ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aBo() == 0 && z) {
                this.iPB.setPullRefresh(null);
            } else {
                if (this.iPQ == null) {
                    this.iPQ = new com.baidu.tieba.pb.view.d(this.iFL.getPageContext());
                    this.iPQ.createView();
                    this.iPQ.setListPullRefreshListener(this.dhi);
                }
                this.iPB.setPullRefresh(this.iPQ);
                cqk();
                if (this.iPQ != null) {
                    this.iPQ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bqx();
            }
            cqp();
            this.iPM.pD(this.iGx);
            this.iPM.pE(false);
            this.iPM.pI(i == 5);
            this.iPM.pJ(i == 6);
            this.iPM.pK(z2 && this.iRq);
            this.iPM.a(eVar, false);
            this.iPM.notifyDataSetChanged();
            this.iPG.a(b(eVar, z), eVar.cln());
            if (eVar.ckP() != null && eVar.ckP().aCc() != null && this.iPv != -1) {
                eVar.ckP().aCc().setIsLike(this.iPv);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.iPB.setNextPage(this.gvD);
                this.iPw = 2;
                bqx();
            } else {
                this.iQu = true;
                if (eVar.getPage().aBn() == 1) {
                    if (this.iPR == null) {
                        this.iPR = new com.baidu.tieba.pb.view.a(this.iFL, this.iFL);
                    }
                    this.iPB.setNextPage(this.iPR);
                } else {
                    this.iPB.setNextPage(this.gvD);
                }
                this.iPw = 3;
            }
            ArrayList<PostData> ckR = eVar.ckR();
            if (eVar.getPage().aBn() == 0 || ckR == null || ckR.size() < eVar.getPage().aBm()) {
                if (com.baidu.tbadk.core.util.v.getCount(ckR) == 0 || (com.baidu.tbadk.core.util.v.getCount(ckR) == 1 && ckR.get(0) != null && ckR.get(0).cLv() == 1)) {
                    if (this.iQE == null || this.iQE.iRI == null || this.iQE.iRI.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.iQE.iRI.getView().getTop() < 0 ? this.iQE.iRI.getView().getHeight() : this.iQE.iRI.getView().getBottom();
                    }
                    if (this.iFL.cny()) {
                        this.gvD.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.gvD.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.iFL.cmN() != null && !this.iFL.cmN().crp()) {
                        this.iFL.cmN().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aBn() == 0) {
                        this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gvD.aHM();
                }
                if (eVar.getPage().aBn() == 0 || ckR == null) {
                    cqz();
                }
            } else {
                if (z2) {
                    if (this.iRq) {
                        endLoadData();
                        if (eVar.getPage().aBn() != 0) {
                            this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.gvD.setLineVisible();
                        this.gvD.showLoading();
                    }
                } else {
                    this.gvD.setLineVisible();
                    this.gvD.showLoading();
                }
                this.gvD.aHM();
            }
            switch (i) {
                case 2:
                    this.iPB.setSelection(i2 > 1 ? (((this.iPB.getData() == null && eVar.ckR() == null) ? 0 : (this.iPB.getData().size() - eVar.ckR().size()) + this.iPB.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cpn2 = ah.cpm().cpn()) != null && !(cpn2 instanceof RecyclerView.SavedState)) {
                        this.iPB.onRestoreInstanceState(cpn2);
                        if (com.baidu.tbadk.core.util.v.getCount(ckR) > 1 && eVar.getPage().aBn() > 0) {
                            this.gvD.endLoadData();
                            this.gvD.setText(this.iFL.getString(R.string.pb_load_more_without_point));
                            this.gvD.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.iRq = false;
                    break;
                case 5:
                    this.iPB.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cpn = ah.cpm().cpn()) != null && !(cpn instanceof RecyclerView.SavedState)) {
                        this.iPB.onRestoreInstanceState(cpn);
                        break;
                    } else {
                        this.iPB.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.iPD != null && this.iPD.bcP() != null) {
                            if (this.iFL.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.iPB.setSelectionFromTop((this.iPM.cmw() + this.iPB.getHeaderViewsCount()) - 1, this.iPD.crh() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.iFL.getPageContext().getPageActivity()));
                            } else {
                                this.iPB.setSelectionFromTop((this.iPM.cmw() + this.iPB.getHeaderViewsCount()) - 1, this.iPD.crh());
                            }
                        } else {
                            this.iPB.setSelection(this.iPM.cmw() + this.iPB.getHeaderViewsCount());
                        }
                    } else {
                        this.iPB.setSelection(i2 > 0 ? ((this.iPB.getData() == null && eVar.ckR() == null) ? 0 : (this.iPB.getData().size() - eVar.ckR().size()) + this.iPB.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.gvD.endLoadData();
                    this.gvD.setText(this.iFL.getString(R.string.pb_load_more_without_point));
                    this.gvD.setLineGone();
                    break;
            }
            if (this.iQG == iQH && isHost()) {
                cqH();
            }
            if (this.iQR) {
                cpA();
                this.iQR = false;
                if (i3 == 0) {
                    ql(true);
                }
            }
            if (eVar.iDn == 1 || eVar.iDo == 1) {
                if (this.iQX == null) {
                    this.iQX = new PbTopTipView(this.iFL.getContext());
                }
                if (eVar.iDo == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.iFL.getStType())) {
                    this.iQX.setText(this.iFL.getString(R.string.pb_read_strategy_add_experience));
                    this.iQX.a(this.aDf, this.mSkinType);
                } else if (eVar.iDn == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.iFL.getStType())) {
                    this.iQX.setText(this.iFL.getString(R.string.pb_read_news_add_experience));
                    this.iQX.a(this.aDf, this.mSkinType);
                }
            }
            q(eVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckP() != null) {
            t(eVar);
            if (eVar.ayO()) {
                SvgManager.aGG().a(this.iQm, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGG().a(this.iQm, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iQp.setText(zn(eVar.ckP().aCi()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.ckP()));
        }
    }

    private String zn(int i) {
        if (i == 0) {
            return this.iFL.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cqk() {
        if (this.iPD != null) {
            this.iPD.a(this.iPB, this.textView, this.mType);
        }
    }

    public void qt(boolean z) {
        this.iQd = z;
    }

    public void endLoadData() {
        if (this.gvD != null) {
            this.gvD.setLineGone();
            this.gvD.endLoadData();
        }
        bqx();
    }

    public void bgE() {
        this.iPB.setVisibility(0);
    }

    public void cql() {
        if (this.iPB != null) {
            this.iPB.setVisibility(8);
        }
        if (this.iPB != null) {
            this.iQx.setVisibility(8);
        }
        if (this.iPx != null && this.iPx.iVB != null) {
            this.iPx.iVB.setVisibility(8);
        }
    }

    public void cqm() {
        if (this.iPB != null) {
            this.iPB.setVisibility(0);
        }
        if (this.iQx != null) {
            this.iQx.setVisibility(0);
        }
        if (this.iPx != null && this.iPx.iVB != null) {
            this.iPx.iVB.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void r(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.iQt != null && this.iQt.aCr() != null && this.iPx != null) {
            this.iQU = !this.iQT;
            this.iPx.qJ(this.iQU);
            if (this.iFL.cmN() != null) {
                this.iFL.cmN().qI(this.iQU);
            }
            cqn();
            if (this.iFL != null && !this.iFL.clN() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cli())) {
                bf bfVar = eVar.cli().get(0);
                if (bfVar != null) {
                    this.iPx.ee(bfVar.getForumName(), bfVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.iPx.ee(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            if (this.iQU) {
                this.iPG.a(eVar, this.iQt, this.iQe);
                if (this.iQz != null) {
                    this.iQz.setVisibility(8);
                }
                if (this.iRd == null) {
                    this.iRd = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.an.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (an.this.iFL != null && an.this.iFL.isAdded()) {
                                if (i < 0 && f > an.this.iQW) {
                                    an.this.cqG();
                                }
                                an.this.cqe();
                            }
                        }
                    };
                }
                this.iPB.setListViewDragListener(this.iRd);
                return;
            }
            if (this.iQz != null) {
                this.iQz.setVisibility(0);
            }
            this.iPG.a(eVar, this.iQt, this.iQe);
            this.iRd = null;
            this.iPB.setListViewDragListener(null);
        }
    }

    private void cqn() {
        this.iPG.a(this.iGO, this.iQt, this.iQU, this.iQT);
    }

    public boolean cqo() {
        return this.iGO == null || this.iGO.getForum() == null || "0".equals(this.iGO.getForum().getId()) || "me0407".equals(this.iGO.getForum().getName());
    }

    private boolean cqp() {
        return this.iPE.qE(this.iGx);
    }

    private boolean s(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.ckP() == null) {
            return false;
        }
        if (eVar.ckP().aCo() == 1 || eVar.ckP().getThreadType() == 33) {
            return true;
        }
        return !(eVar.ckP().aCq() == null || eVar.ckP().aCq().aEx() == 0) || eVar.ckP().aCm() == 1 || eVar.ckP().aCn() == 1 || eVar.ckP().aDc() || eVar.ckP().aDw() || eVar.ckP().aDp() || eVar.ckP().aCD() != null || !com.baidu.tbadk.core.util.aq.isEmpty(eVar.ckP().getCategory()) || eVar.ckP().aCu() || eVar.ckP().aCt();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.iPF != null) {
                if (eVar.ckP() != null && eVar.ckP().aCG() == 0 && !eVar.ckP().aBe() && !this.iRj) {
                    if (eVar.ckP() != null) {
                        bj ckP = eVar.ckP();
                        ckP.t(true, s(eVar));
                        ckP.jI(3);
                        ckP.sF("2");
                    }
                    if (eVar.ckP().aBg()) {
                        this.iPG.c(this.iPB);
                        this.iPF.c(this.iPB);
                        this.iPF.b(this.iPB);
                        this.iPG.b(this.iPB);
                        this.iPG.B(this.iGO);
                        this.iPF.x(eVar);
                    } else {
                        this.iPG.B(this.iGO);
                        this.iPF.z(eVar);
                    }
                } else if (eVar.ckP().aCG() == 1) {
                    if (eVar.ckP() != null) {
                        this.iPF.c(this.iPB);
                        this.iPG.B(this.iGO);
                    }
                } else {
                    this.iPF.c(this.iPB);
                    this.iPG.B(this.iGO);
                }
            }
            if (eVar.ckP() != null) {
                ae(eVar.ckP().aCn() == 1, eVar.ckP().aCm() == 1);
            }
            this.iGx = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cqp();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.w wVar;
        StringBuilder sb = null;
        if (eVar != null && (b = b(eVar, z)) != null) {
            String userId = b.aCr().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.clb()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.aCr() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.aCr().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.aCr().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.aCr().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.clb()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cli = eVar.cli();
                if (com.baidu.tbadk.core.util.v.getCount(cli) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cli) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cRd) != null && wVar.cOX && !wVar.cOY && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(this.iFL.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.iFL.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cqq() {
        return this.dDn;
    }

    public boolean cqr() {
        if (this.aDM == null || this.aDM.getParent() == null || this.gvD.isLoading()) {
            return false;
        }
        int bottom = this.aDM.getBottom();
        Rect rect = new Rect();
        this.aDM.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Gd(String str) {
        if (this.gvD != null) {
            this.gvD.setText(str);
        }
    }

    public void Ge(String str) {
        if (this.gvD != null) {
            int i = 0;
            if (this.iQE != null && this.iQE.iRI != null && this.iQE.iRI.getView() != null) {
                i = this.iQE.iRI.getView().getTop() < 0 ? this.iQE.iRI.getView().getHeight() : this.iQE.iRI.getView().getBottom();
            }
            this.gvD.ab(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.iPB;
    }

    public int cqs() {
        return R.id.richText;
    }

    public TextView cmh() {
        return this.iPG.cmh();
    }

    public void d(BdListView.e eVar) {
        this.iPB.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.dhi = cVar;
        if (this.iPQ != null) {
            this.iPQ.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int aBl = apVar.aBl();
            int aBi = apVar.aBi();
            if (this.iPN != null) {
                this.iPN.aEG();
            } else {
                this.iPN = new com.baidu.tbadk.core.dialog.a(this.iFL.getPageContext().getPageActivity());
                this.iPO = LayoutInflater.from(this.iFL.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.iPN.aO(this.iPO);
                this.iPN.a(R.string.dialog_ok, bVar);
                this.iPN.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.cqu();
                        aVar.dismiss();
                    }
                });
                this.iPN.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.iQO == null) {
                            an.this.iQO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.iFL.HidenSoftKeyPad((InputMethodManager) an.this.iFL.getBaseFragmentActivity().getSystemService("input_method"), an.this.aDf);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.gx().postDelayed(an.this.iQO, 150L);
                    }
                });
                this.iPN.b(this.iFL.getPageContext()).aEG();
            }
            this.iPP = (EditText) this.iPO.findViewById(R.id.input_page_number);
            this.iPP.setText("");
            TextView textView = (TextView) this.iPO.findViewById(R.id.current_page_number);
            if (aBl <= 0) {
                aBl = 1;
            }
            if (aBi <= 0) {
                aBi = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aBl), Integer.valueOf(aBi)));
            this.iFL.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.iPP, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.iPB.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.iFL.showToast(str);
    }

    public boolean qu(boolean z) {
        if (this.FO == null || !this.FO.aOA()) {
            return false;
        }
        this.FO.aMV();
        return true;
    }

    public void cqt() {
        if (this.iRs != null) {
            while (this.iRs.size() > 0) {
                TbImageView remove = this.iRs.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cqt();
        this.iPM.yP(1);
        if (this.iPD != null) {
            this.iPD.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.iPM.yP(2);
        if (this.iPD != null) {
            this.iPD.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.iFL.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iFL.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.iQo != null) {
            this.iQo.onDestroy();
        }
        if (this.iQQ != null) {
            this.iQQ.destroy();
        }
        if (this.iRf != null) {
            this.iRf.onDestory();
        }
        if (this.iQX != null) {
            this.iQX.hide();
        }
        this.iFL.hideProgressBar();
        if (this.fVM != null && this.gmG != null) {
            this.fVM.b(this.gmG);
        }
        cqu();
        endLoadData();
        if (this.iQO != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iQO);
        }
        if (this.iQw != null) {
            this.iQw.clearStatus();
        }
        this.iRm = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.iPM.yP(3);
        if (this.aCq != null) {
            this.aCq.setBackgroundDrawable(null);
        }
        if (this.iPD != null) {
            this.iPD.destroy();
        }
        if (this.iPM != null) {
            this.iPM.onDestroy();
        }
        this.iPB.setOnLayoutListener(null);
        if (this.iRb != null) {
            this.iRb.bGI();
        }
        if (this.iQF != null) {
            this.iQF.onDestroy();
        }
        if (this.iPG != null) {
            this.iPG.onDestroy();
        }
    }

    public boolean zo(int i) {
        if (this.iPD != null) {
            return this.iPD.zo(i);
        }
        return false;
    }

    public void cqu() {
        this.iPx.arX();
        if (this.iPG != null) {
            this.iPG.cqu();
        }
        if (this.iFL != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iFL.getContext(), this.iPP);
        }
        cpC();
        if (this.iJv != null) {
            this.iJv.dismiss();
        }
        cqw();
        if (this.iPN != null) {
            this.iPN.dismiss();
        }
        if (this.grm != null) {
            this.grm.dismiss();
        }
    }

    public void cqv() {
        this.iPx.arX();
        if (this.iPG != null) {
            this.iPG.cqu();
        }
        if (this.iJv != null) {
            this.iJv.dismiss();
        }
        cqw();
        if (this.iPN != null) {
            this.iPN.dismiss();
        }
        if (this.grm != null) {
            this.grm.dismiss();
        }
    }

    public void dH(List<String> list) {
        this.iRa = list;
        if (this.iRb != null) {
            this.iRb.setData(list);
        }
    }

    public void pC(boolean z) {
        this.iPM.pC(z);
    }

    public void qv(boolean z) {
        this.iQg = z;
    }

    public void cqw() {
        if (this.iPU != null) {
            this.iPU.dismiss();
        }
        if (this.iPV != null) {
            com.baidu.adp.lib.f.g.b(this.iPV, this.iFL.getPageContext());
        }
        if (this.iPW != null) {
            com.baidu.adp.lib.f.g.b(this.iPW, this.iFL.getPageContext());
        }
        if (this.iPT != null) {
            this.iPT.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.iGO, this.iGx);
            b(this.iGO, this.iGx, this.mType, i);
            this.iFL.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.iFL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.aDf);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.aDf, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iQh, R.drawable.personalize_tab_shadow);
            if (this.iPD != null) {
                this.iPD.onChangeSkinType(i);
            }
            if (this.iPH != null) {
                this.iPH.onChangeSkinType(i);
            }
            if (this.iPE != null) {
                this.iPE.onChangeSkinType(i);
            }
            if (this.iPF != null) {
                this.iPF.onChangeSkinType(i);
            }
            if (this.iPG != null) {
                this.iPG.onChangeSkinType(i);
            }
            if (this.gvD != null) {
                this.gvD.changeSkin(i);
                if (this.dDn != null) {
                    this.iFL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dDn);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.dDn, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.iPN != null) {
                this.iPN.c(this.iFL.getPageContext());
            }
            qt(this.iQd);
            this.iPM.notifyDataSetChanged();
            if (this.iPQ != null) {
                this.iPQ.changeSkin(i);
            }
            if (this.FO != null) {
                this.FO.onChangeSkinType(i);
            }
            if (this.iPR != null) {
                this.iPR.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.fMP)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.fMP) {
                    customBlueCheckRadioButton.aHz();
                }
            }
            cpT();
            UtilHelper.setStatusBarBackground(this.aCq, i);
            UtilHelper.setStatusBarBackground(this.iQz, i);
            if (this.iPI != null) {
                com.baidu.tbadk.q.a.a(this.iFL.getPageContext(), this.iPI);
            }
            if (this.iQP != null) {
                this.iQP.onChangeSkinType(i);
            }
            if (this.iPx != null) {
                if (this.iPD != null) {
                    this.iPD.zp(i);
                } else {
                    this.iPx.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.hiz != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hiz, (int) R.color.cp_cont_d);
                this.hiz.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ay(com.baidu.adp.lib.util.l.getDimens(this.iFL.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.iQm != null && this.iGO != null) {
                if (this.iGO.ayO()) {
                    SvgManager.aGG().a(this.iQm, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aGG().a(this.iQm, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            t(this.iGO);
            if (this.iQl != null) {
                SvgManager.aGG().a(this.iQl, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iQj != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iQj, R.drawable.bottom_shadow);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iQp, (int) R.color.cp_cont_b);
            if (this.iRc != null) {
                this.iRc.onChangeSkinType(i);
            }
            if (this.iQF != null) {
                this.iQF.onChangeSkinType();
            }
            if (this.iQZ != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iQZ, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iQk, R.color.cp_bg_line_h);
            if (this.iPC != null) {
                this.iPC.pm(i);
            }
        }
    }

    public void cqx() {
        if (this.iQo != null) {
            this.iQo.setEnable(false);
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aZ(eVar.ckP())) {
            if (this.iQo != null) {
                this.iQo.setEnable(false);
                this.iQo.onDestroy();
            }
            SvgManager.aGG().a(this.iQn, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.iQo == null || !this.iQo.isEnable()) {
            SvgManager.aGG().a(this.iQn, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dNb = iVar;
        this.iPM.setOnImageClickListener(this.dNb);
        this.iRc.setOnImageClickListener(this.dNb);
    }

    public void g(NoNetworkView.a aVar) {
        this.gmG = aVar;
        if (this.fVM != null) {
            this.fVM.a(this.gmG);
        }
    }

    public void qw(boolean z) {
        this.iPM.setIsFromCDN(z);
    }

    public Button cqy() {
        return this.iQi;
    }

    public void cqz() {
        if (this.iPw != 2) {
            this.iPB.setNextPage(this.gvD);
            this.iPw = 2;
        }
    }

    public void cqA() {
        if (com.baidu.tbadk.n.m.aRq().aRr()) {
            int lastVisiblePosition = this.iPB.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iPB.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.dDW = true;
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
                        perfLog2.dDW = true;
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

    public boolean cqB() {
        return this.FO != null && this.FO.getVisibility() == 0;
    }

    public boolean cqC() {
        return this.FO != null && this.FO.aOA();
    }

    public void cqD() {
        if (this.FO != null) {
            this.FO.aMV();
        }
    }

    public void qx(boolean z) {
        if (this.iQk != null) {
            qv(this.iFL.cmK().aPe());
            if (this.iQg) {
                qm(z);
            } else {
                qn(z);
            }
        }
    }

    public void cqE() {
        if (this.iQk != null) {
            this.iQj.setVisibility(8);
            this.iQk.setVisibility(8);
            this.iQq = false;
            if (this.iQF != null) {
                this.iQF.setVisibility(8);
                qr(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.fQQ == null) {
            this.fQQ = new com.baidu.tbadk.core.view.a(this.iFL.getPageContext());
        }
        this.fQQ.setDialogVisiable(true);
    }

    public void bqx() {
        if (this.fQQ != null) {
            this.fQQ.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.iPB.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.iPB.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iPD != null) {
            this.iPD.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.iRt = getScrollY();
            this.iQE.iRI = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iQE));
            a(this.iQE.iRI, true);
        }
    }

    public void qy(boolean z) {
        if (this.iPD != null) {
            this.iPD.qy(z);
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
        if (this.iPD != null) {
            this.iPD.onScroll(absListView, i, i2, i3);
        }
        if (this.iPx != null && this.iPM != null) {
            this.iPx.cC(this.iPM.cmB());
        }
        this.iQE.iyG = i;
        this.iQE.headerCount = this.iPB.getHeaderViewsCount();
        this.iQE.iRI = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iQE));
        qo(b(absListView, i));
        a(this.iQE.iRI, false);
        if (this.gvD.aHN() && !this.gvD.dha) {
            if (this.iQE != null && this.iQE.iRI != null && this.iQE.iRI.getView() != null) {
                i4 = this.iQE.iRI.getView().getTop() < 0 ? this.iQE.iRI.getView().getHeight() : this.iQE.iRI.getView().getBottom();
            }
            this.gvD.lk(i4);
            this.gvD.dha = true;
        }
    }

    public void cqF() {
        if (TbadkCoreApplication.isLogin() && this.iGO != null && this.iQU && !this.iQT && !this.iQe && this.iQt != null && this.iQt.aCr() != null && !this.iQt.aCr().getIsLike() && !this.iQt.aCr().hadConcerned() && this.iQQ == null) {
            this.iQQ = new ak(this.iFL);
        }
    }

    public void cqG() {
        if (this.iQU && !this.iQT && this.iQt != null && this.iQt.aCr() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").X("obj_locate", this.iFL.clN() ? 2 : 1).X("obj_type", this.iQT ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.iFL.getPageContext().getPageActivity(), this.iQt.aCr().getUserId(), this.iQt.aCr().getUserName(), this.iFL.clX().clO(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aj ajVar, boolean z) {
        int measuredHeight;
        if (!this.iQT && this.iQy != null && this.iPx.crv() != null) {
            int cmx = this.iPM.cmx();
            if (cmx > 0 && (ajVar == null || ajVar.getView().getParent() == null)) {
                if (cmx > this.iPB.getFirstVisiblePosition() - this.iPB.getHeaderViewsCount()) {
                    this.iQy.setVisibility(8);
                    return;
                }
                this.iQy.setVisibility(0);
                qo(false);
                this.iPx.mNavigationBar.hideBottomLine();
                if (this.iQy.getParent() != null && ((ViewGroup) this.iQy.getParent()).getHeight() <= this.iQy.getTop()) {
                    this.iQy.getParent().requestLayout();
                }
            } else if (ajVar == null || ajVar.getView() == null || ajVar.iOY == null) {
                if (this.iPB.getFirstVisiblePosition() == 0) {
                    this.iQy.setVisibility(8);
                    this.iPx.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = ajVar.getView().getTop();
                if (ajVar.getView().getParent() != null) {
                    if (this.iQD) {
                        this.iQC = top2;
                        this.iQD = false;
                    }
                    this.iQC = top2 < this.iQC ? top2 : this.iQC;
                }
                if (top2 != 0 || ajVar.getView().isShown()) {
                    if (this.iPL.getY() < 0.0f) {
                        measuredHeight = iQB - ajVar.iOY.getMeasuredHeight();
                    } else {
                        measuredHeight = this.iPx.crv().getMeasuredHeight() - ajVar.iOY.getMeasuredHeight();
                        this.iPx.mNavigationBar.hideBottomLine();
                    }
                    if (ajVar.getView().getParent() == null && top2 <= this.iQC) {
                        this.iQy.setVisibility(0);
                        qo(false);
                    } else if (top2 < measuredHeight) {
                        this.iQy.setVisibility(0);
                        qo(false);
                    } else {
                        this.iQy.setVisibility(8);
                        this.iPx.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.iQD = true;
                    }
                }
            }
        }
    }

    public void cqH() {
        if (!this.iRu) {
            TiebaStatic.log("c10490");
            this.iRu = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iFL.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(iQI, Integer.valueOf(iQK));
            aVar.jV(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.iFL.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aO(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.iFL);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iFL.getPageContext()).aEG();
        }
    }

    public void Gf(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iFL.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.iFL.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(iQI, Integer.valueOf(iQL));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.iFL);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iFL.getPageContext()).aEG();
    }

    public void a(int i, com.baidu.tieba.pb.data.e eVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(eVar, z)) != null && b.aCr() != null) {
            MetaData aCr = b.aCr();
            aCr.setGiftNum(aCr.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        a(eVar, z, i, i2);
        r(eVar);
    }

    public PbInterviewStatusView cqI() {
        return this.iQw;
    }

    private void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckP() != null && eVar.ckP().aDw() && this.iQw == null) {
            this.iQw = (PbInterviewStatusView) this.iQv.inflate();
            this.iQw.setOnClickListener(this.grn);
            this.iQw.setCallback(this.iFL.cnw());
            this.iQw.setData(this.iFL, eVar);
        }
    }

    public RelativeLayout cqJ() {
        return this.iPL;
    }

    public View cqK() {
        return this.aCq;
    }

    public boolean cqL() {
        return this.iRj;
    }

    public void pH(boolean z) {
        this.iPG.pH(z);
    }

    public void Gg(String str) {
        if (this.iPy != null) {
            this.iPy.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int qz(boolean z) {
        if (this.iQw == null || this.iQw.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cqM() {
        if (this.iQw != null && this.iQw.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iQw.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.iQw.setLayoutParams(layoutParams);
        }
    }

    public boolean cmQ() {
        return false;
    }

    public void Gh(String str) {
        this.hiz.performClick();
        if (!StringUtils.isNull(str) && this.iFL.cmK() != null && this.iFL.cmK().aOX() != null && this.iFL.cmK().aOX().getInputView() != null) {
            EditText inputView = this.iFL.cmK().aOX().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cqu();
            if (configuration.orientation == 2) {
                cqE();
                cpC();
            } else {
                cpG();
            }
            if (this.iQP != null) {
                this.iQP.cmF();
            }
            this.iFL.bEv();
            this.iPL.setVisibility(8);
            this.iPx.qK(false);
            this.iFL.pV(false);
            if (this.iPD != null) {
                if (configuration.orientation == 1) {
                    cqJ().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.iPB.setIsLandscape(true);
                    this.iPB.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.iPB.setIsLandscape(false);
                    if (this.iRt > 0) {
                        this.iPB.smoothScrollBy(this.iRt, 0);
                    }
                }
                this.iPD.onConfigurationChanged(configuration);
                this.iQx.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void qA(boolean z) {
        if (this.iPD != null) {
            this.iPD.qA(z);
        }
    }

    public boolean cqN() {
        return this.iPD != null && this.iPD.cqN();
    }

    public void cqO() {
        if (this.iPD != null) {
            this.iPD.cqO();
        }
    }

    public void pL(boolean z) {
        this.iPM.pL(z);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.iQk.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.iFL.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.iQZ = new TextView(this.iFL.getContext());
            this.iQZ.setText(R.string.connection_tips);
            this.iQZ.setGravity(17);
            this.iQZ.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iFL.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.iFL.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iFL.getContext(), R.dimen.ds60);
            if (this.iQZ.getParent() == null) {
                frameLayout.addView(this.iQZ, layoutParams);
            }
            this.iQY = new PopupWindow(this.iFL.getContext());
            this.iQY.setContentView(frameLayout);
            this.iQY.setHeight(-2);
            this.iQY.setWidth(-2);
            this.iQY.setFocusable(true);
            this.iQY.setOutsideTouchable(false);
            this.iQY.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.iPB.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        an.this.iQY.showAsDropDown(an.this.iQk, view.getLeft(), -an.this.iQk.getHeight());
                    } else {
                        an.this.iQY.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void qB(boolean z) {
        this.iRe = z;
    }

    public boolean cqP() {
        return this.iRe;
    }

    public PbThreadPostView cqQ() {
        return this.iPC;
    }

    private void ae(boolean z, boolean z2) {
        af(z, z2);
        if (this.iGO != null && this.iGO.ckP() != null && this.iGO.ckP().aCG() == 0 && !this.iGO.ckP().aBe()) {
            ag(z, z2);
        } else if (this.iPM != null && this.iPM.cmC() != null) {
            this.iPM.cmC().b(this.iGO, z, z2);
        }
    }

    private void af(boolean z, boolean z2) {
        this.iPG.d(this.iGO, z, z2);
    }

    private void ag(boolean z, boolean z2) {
        this.iPF.c(this.iGO, z, z2);
    }
}
