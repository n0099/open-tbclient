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
    private static final int jAK = UtilHelper.getLightStatusBarHeight();
    public static int jAQ = 3;
    public static int jAR = 0;
    public static int jAS = 3;
    public static int jAT = 4;
    public static int jAU = 5;
    public static int jAV = 6;
    private static a.InterfaceC0652a jBr = new a.InterfaceC0652a() { // from class: com.baidu.tieba.pb.pb.main.an.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0652a
        public void onRefresh() {
        }
    };
    private EditorTools Za;
    private View aVX;
    private RelativeLayout aWM;
    private View aXv;
    private g.c dHd;
    private com.baidu.tieba.pb.a.c dRh;
    private View ecU;
    private NoNetworkView gAG;
    private List<CustomBlueCheckRadioButton> grw;
    private com.baidu.tieba.NEGFeedBack.e hBE;
    private TextView hSi;
    private View.OnClickListener haA;
    private PbListView heO;
    private NavigationBarCoverTip hyH;
    private boolean isLandscape;
    private int jAA;
    private int jAB;
    private PostData jAC;
    private ViewStub jAE;
    private PbInterviewStatusView jAF;
    private FrameLayout jAG;
    private View jAH;
    private View jAI;
    private aj jAJ;
    private PbEmotionBar jAO;
    private int jAW;
    private Runnable jAX;
    private s jAY;
    private ak jAZ;
    private View jAb;
    private View jAq;
    private View jAs;
    private View jAt;
    private ImageView jAu;
    private ImageView jAv;
    private ImageView jAw;
    private com.baidu.tieba.pb.view.c jAx;
    private TextView jAy;
    public int jBC;
    private int jBf;
    private PbTopTipView jBg;
    private PopupWindow jBh;
    private TextView jBi;
    private List<String> jBj;
    private com.baidu.tieba.pb.pb.main.emotion.c jBk;
    private com.baidu.tieba.pb.pb.godreply.a jBl;
    private PbLandscapeListView.b jBm;
    private aa jBo;
    private String jBp;
    private long jBq;
    private boolean jBs;
    private Runnable jBw;
    private PbFragment.b jBy;
    private PbFragment jpS;
    private View.OnClickListener jqM;
    private com.baidu.tieba.pb.data.e jqV;
    private PbFakeFloorModel jsS;
    PbFragment.c juz;
    public int jzE;
    public final com.baidu.tieba.pb.pb.main.view.c jzG;
    public com.baidu.tieba.pb.pb.main.view.b jzH;
    private ViewStub jzI;
    private ViewStub jzJ;
    private PbLandscapeListView jzK;
    private PbThreadPostView jzL;
    private com.baidu.tieba.pb.pb.main.a.e jzM;
    private com.baidu.tieba.pb.pb.main.a.a jzN;
    private com.baidu.tieba.pb.pb.main.a.c jzO;
    private com.baidu.tieba.pb.pb.main.a.d jzP;
    private com.baidu.tieba.pb.pb.main.a.b jzQ;
    private LinearLayout jzR;
    private TextView jzS;
    private TextView jzT;
    private ObservedChangeRelativeLayout jzU;
    private f jzV;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int jzF = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a jzW = null;
    private com.baidu.tbadk.core.dialog.b haz = null;
    private View jzX = null;
    private EditText jzY = null;
    private com.baidu.tieba.pb.view.d jzZ = null;
    private com.baidu.tieba.pb.view.a jAa = null;
    private b.a ioW = null;
    private TbRichTextView.i emS = null;
    private NoNetworkView.a gVM = null;
    private com.baidu.tbadk.core.dialog.i jAc = null;
    private com.baidu.tbadk.core.dialog.a jAd = null;
    private Dialog jAe = null;
    private Dialog jAf = null;
    private View jAg = null;
    private LinearLayout jAh = null;
    private CompoundButton.OnCheckedChangeListener grx = null;
    private TextView jAi = null;
    private TextView jAj = null;
    private String jAk = null;
    private com.baidu.tbadk.core.dialog.i jtC = null;
    private com.baidu.tbadk.core.dialog.i jAl = null;
    private boolean jAm = false;
    private boolean jAn = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView jAo = null;
    private boolean jAp = false;
    private Button jAr = null;
    private boolean jAz = true;
    private com.baidu.tbadk.core.view.a gvy = null;
    private boolean jqE = false;
    private int mSkinType = 3;
    private boolean jAD = false;
    private int jAL = 0;
    private boolean jAM = true;
    public a jAN = new a();
    private int jAP = 0;
    private boolean jBa = false;
    private int jBb = 0;
    private boolean jBc = false;
    private boolean jBd = false;
    private boolean jBe = false;
    private boolean jBn = false;
    private String jBt = null;
    private CustomMessageListener jBu = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.an.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                an.this.jBt = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.jzV != null) {
                an.this.jzV.notifyDataSetChanged();
            }
        }
    };
    private Handler jBv = new Handler();
    private CustomMessageListener jBx = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.jAz = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean jBz = true;
    View.OnClickListener jBA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || an.this.jqV == null || an.this.jqV.cvu() == null || an.this.jqV.cvu().aKE() == null || an.this.jqV.cvu().aKE().getAlaUserData() == null || an.this.jqV.cvu().aKE().getAlaUserData().live_status != 1 || an.this.jqV.cvu().aKE().getAlaUserData().live_id <= 0) {
                if (an.this.jBc) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").af("obj_id", 2));
                }
                if (!an.this.jBc && an.this.jqV != null && an.this.jqV.cvu() != null && an.this.jqV.cvu().aKE() != null && an.this.jqV.cvu().aKE().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").af("obj_locate", 1));
                }
                if (an.this.jpS.cyk() != null) {
                    an.this.jpS.cyk().jqe.gHS.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = an.this.jqV.cvu().aKE().getAlaUserData().live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(an.this.jpS.cyk(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
        }
    };
    private boolean aIV = false;
    String userId = null;
    private final List<TbImageView> jBB = new ArrayList();
    private boolean jBD = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public aj jBR;
        public int jiN;
    }

    public void rp(boolean z) {
        this.jBa = z;
        if (this.jzK != null) {
            this.jBb = this.jzK.getHeaderViewsCount();
        }
    }

    public void cAg() {
        if (this.jzK != null) {
            int headerViewsCount = this.jzK.getHeaderViewsCount() - this.jBb;
            final int firstVisiblePosition = (this.jzK.getFirstVisiblePosition() == 0 || this.jzK.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.jzK.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.jzK.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.jAN.jBR = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jAN));
            final aj ajVar = this.jAN.jBR;
            final int f = f(ajVar);
            final int y = ((int) this.jzU.getY()) + this.jzU.getMeasuredHeight();
            final boolean z = this.jAH.getVisibility() == 0;
            boolean z2 = this.jzU.getY() < 0.0f;
            if ((z && ajVar != null) || firstVisiblePosition >= this.jzV.cxd() + this.jzK.getHeaderViewsCount()) {
                int measuredHeight = ajVar != null ? ajVar.jzh.getMeasuredHeight() : 0;
                if (z2) {
                    this.jzK.setSelectionFromTop(this.jzV.cxd() + this.jzK.getHeaderViewsCount(), jAK - measuredHeight);
                } else {
                    this.jzK.setSelectionFromTop(this.jzV.cxd() + this.jzK.getHeaderViewsCount(), this.jzG.cCb().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.jzK.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.jBc && this.jzM != null) {
                this.jzK.setSelectionFromTop(this.jzV.cxd() + this.jzK.getHeaderViewsCount(), this.jzM.cBN());
            } else if (this.mType == 6) {
                this.jzK.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cyu() {
                        ViewGroup.LayoutParams layoutParams;
                        if (f >= 0 && f <= an.this.aWM.getMeasuredHeight()) {
                            int f2 = an.this.f(ajVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            if (an.this.aXv != null && (layoutParams = an.this.aXv.getLayoutParams()) != null) {
                                if (i == 0 || i > an.this.aWM.getMeasuredHeight() || f2 >= an.this.aWM.getMeasuredHeight()) {
                                    layoutParams.height = an.this.jAW;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.aWM.getMeasuredHeight()) {
                                    layoutParams.height = an.this.jAW;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    an.this.jzK.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                an.this.aXv.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (an.this.aXv != null && an.this.aXv.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = an.this.aXv.getLayoutParams();
                                            layoutParams2.height = an.this.jAW;
                                            an.this.aXv.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        an.this.jzK.setOnLayoutListener(null);
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

    public NoNetworkView cAh() {
        return this.gAG;
    }

    public void cAi() {
        if (this.Za != null) {
            this.Za.hide();
            if (this.jBk != null) {
                this.jBk.cBP();
            }
        }
    }

    public PbFakeFloorModel cAj() {
        return this.jsS;
    }

    public s cAk() {
        return this.jAY;
    }

    public com.baidu.tieba.pb.pb.main.a.e cAl() {
        return this.jzM;
    }

    public void cAm() {
        reset();
        cAi();
        this.jAY.cxl();
        rB(false);
    }

    private void reset() {
        if (this.jpS != null && this.jpS.cxq() != null && this.Za != null) {
            com.baidu.tbadk.editortools.pb.a.aXl().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cxq = this.jpS.cxq();
            cxq.aXF();
            cxq.aWZ();
            if (cxq.getWriteImagesInfo() != null) {
                cxq.getWriteImagesInfo().setMaxImagesAllowed(cxq.isBJH ? 1 : 9);
            }
            cxq.mJ(SendView.ALL);
            cxq.mK(SendView.ALL);
            com.baidu.tbadk.editortools.g mA = this.Za.mA(23);
            com.baidu.tbadk.editortools.g mA2 = this.Za.mA(2);
            com.baidu.tbadk.editortools.g mA3 = this.Za.mA(5);
            if (mA2 != null) {
                mA2.display();
            }
            if (mA3 != null) {
                mA3.display();
            }
            if (mA != null) {
                mA.hide();
            }
            this.Za.invalidate();
        }
    }

    public boolean cAn() {
        return this.jAz;
    }

    public void rq(boolean z) {
        if (this.jAt != null && this.hSi != null) {
            this.hSi.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jAt.startAnimation(alphaAnimation);
            }
            this.jAs.setVisibility(0);
            this.jAt.setVisibility(0);
            this.jAz = true;
            if (this.jAO != null && !this.jBl.isActive()) {
                this.jAO.setVisibility(0);
                rv(true);
            }
        }
    }

    public void rr(boolean z) {
        if (this.jAt != null && this.hSi != null) {
            this.hSi.setText(cAo());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jAt.startAnimation(alphaAnimation);
            }
            this.jAs.setVisibility(0);
            this.jAt.setVisibility(0);
            this.jAz = true;
            if (this.jAO != null && !this.jBl.isActive()) {
                this.jAO.setVisibility(0);
                rv(true);
            }
        }
    }

    public String cAo() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.jBp)) {
            return this.jBp;
        }
        if (this.jpS != null) {
            this.jBp = TbadkCoreApplication.getInst().getResources().getString(am.cAd());
        }
        return this.jBp;
    }

    public PostData cAp() {
        int i = 0;
        if (this.jzK == null) {
            return null;
        }
        int cAq = cAq() - this.jzK.getHeaderViewsCount();
        if (cAq < 0) {
            cAq = 0;
        }
        if (this.jzV.zp(cAq) != null && this.jzV.zp(cAq) != PostData.kSn) {
            i = cAq + 1;
        }
        return this.jzV.getItem(i) instanceof PostData ? (PostData) this.jzV.getItem(i) : null;
    }

    public int cAq() {
        int i;
        View childAt;
        if (this.jzK == null) {
            return 0;
        }
        int firstVisiblePosition = this.jzK.getFirstVisiblePosition();
        int lastVisiblePosition = this.jzK.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.jzK.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.jzK.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cAr() {
        return this.jzK.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.jqV != null && this.jqV.cvw() != null && !this.jqV.cvw().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.jqV.cvw().size() && (postData = this.jqV.cvw().get(i)) != null && postData.aKE() != null && !StringUtils.isNull(postData.aKE().getUserId()); i++) {
                if (this.jqV.cvw().get(i).aKE().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.jBl != null && this.jBl.isActive()) {
                        rB(false);
                    }
                    if (this.jAO != null) {
                        this.jAO.rK(true);
                    }
                    this.jBt = postData.aKE().getName_show();
                    return;
                }
            }
        }
    }

    public an(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.jpS = null;
        this.aWM = null;
        this.aVX = null;
        this.jzK = null;
        this.jzV = null;
        this.heO = null;
        this.ecU = null;
        this.haA = null;
        this.jqM = null;
        this.jAt = null;
        this.hSi = null;
        this.jAE = null;
        this.jBf = 0;
        this.jBq = 0L;
        this.jBq = System.currentTimeMillis();
        this.jpS = pbFragment;
        this.haA = onClickListener;
        this.dRh = cVar;
        this.jBf = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jpS.getContext()) / 2;
        this.aWM = (RelativeLayout) LayoutInflater.from(this.jpS.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.aWM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.jAq = this.aWM.findViewById(R.id.bottom_shadow);
        this.hyH = (NavigationBarCoverTip) this.aWM.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.aVX = this.aWM.findViewById(R.id.statebar_view);
        this.jzU = (ObservedChangeRelativeLayout) this.aWM.findViewById(R.id.title_wrapper);
        this.gAG = (NoNetworkView) this.aWM.findViewById(R.id.view_no_network);
        this.jzK = (PbLandscapeListView) this.aWM.findViewById(R.id.new_pb_list);
        this.jAG = (FrameLayout) this.aWM.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.jpS.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.jpS.getActivity(), R.dimen.ds88));
        this.jzK.addHeaderView(this.textView, 0);
        this.jzK.setTextViewAdded(true);
        this.jAW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aXv = new View(this.jpS.getPageContext().getPageActivity());
        this.aXv.setLayoutParams(new AbsListView.LayoutParams(-1, this.jAW));
        this.aXv.setVisibility(4);
        this.jzK.addFooterView(this.aXv);
        this.jzK.setOnTouchListener(this.jpS.dRW);
        this.jzG = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.aWM);
        if (this.jpS.cxU()) {
            this.jzI = (ViewStub) this.aWM.findViewById(R.id.manga_view_stub);
            this.jzI.setVisibility(0);
            this.jzH = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.jzH.show();
            this.jzG.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.jpS.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.jzG.cCb().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0607a() { // from class: com.baidu.tieba.pb.pb.main.an.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0607a
            public void cwn() {
                if (an.this.jzK != null) {
                    if (an.this.jzM != null) {
                        an.this.jzM.cBM();
                    }
                    an.this.jzK.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0607a
            public void cwo() {
                an.this.jpS.bOU();
            }
        }));
        this.jAs = this.aWM.findViewById(R.id.view_comment_top_line);
        this.jAt = this.aWM.findViewById(R.id.pb_editor_tool_comment);
        this.jAA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jAB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hSi = (TextView) this.aWM.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hSi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.jpS.cxB();
                if (an.this.jpS != null && an.this.jpS.cwD() != null && an.this.jpS.cwD().getPbData() != null && an.this.jpS.cwD().getPbData().cvu() != null && an.this.jpS.cwD().getPbData().cvu().aKE() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", an.this.jpS.cwD().jvS).cI("fid", an.this.jpS.cwD().getPbData().getForumId()).af("obj_locate", 1).cI("uid", an.this.jpS.cwD().getPbData().cvu().aKE().getUserId()));
                }
            }
        });
        this.jAu = (ImageView) this.aWM.findViewById(R.id.pb_editor_tool_comment_icon);
        this.jAu.setOnClickListener(this.haA);
        boolean booleanExtra = this.jpS.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.jAv = (ImageView) this.aWM.findViewById(R.id.pb_editor_tool_collection);
        this.jAv.setOnClickListener(this.haA);
        if (booleanExtra) {
            this.jAv.setVisibility(8);
        } else {
            this.jAv.setVisibility(0);
        }
        this.jAw = (ImageView) this.aWM.findViewById(R.id.pb_editor_tool_share);
        this.jAw.setOnClickListener(this.haA);
        this.jAx = new com.baidu.tieba.pb.view.c(this.jAw);
        this.jAx.cFj();
        this.jAy = (TextView) this.aWM.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.jAE = (ViewStub) this.aWM.findViewById(R.id.interview_status_stub);
        this.jzN = new com.baidu.tieba.pb.pb.main.a.a(this.jpS, cVar);
        this.jzP = new com.baidu.tieba.pb.pb.main.a.d(this.jpS, cVar, this.haA);
        this.jzV = new f(this.jpS, this.jzK);
        this.jzV.E(this.haA);
        this.jzV.setTbGestureDetector(this.dRh);
        this.jzV.setOnImageClickListener(this.emS);
        this.jqM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.27
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
                            an.this.jpS.b(sparseArray);
                            return;
                        }
                        an.this.cI(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        an.this.jpS.b(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.jzV.Q(this.jqM);
        cAw();
        cAx();
        this.jzP.b(this.jzK);
        this.jzO.b(this.jzK);
        this.jzN.b(this.jzK);
        this.heO = new PbListView(this.jpS.getPageContext().getPageActivity());
        this.ecU = this.heO.getView().findViewById(R.id.pb_more_view);
        if (this.ecU != null) {
            this.ecU.setOnClickListener(this.haA);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.ecU, R.drawable.pb_foot_more_trans_selector);
        }
        this.heO.setLineVisible();
        this.heO.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.heO.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jAb = this.aWM.findViewById(R.id.viewstub_progress);
        this.jpS.registerListener(this.jBx);
        this.jsS = new PbFakeFloorModel(this.jpS.getPageContext());
        this.jAY = new s(this.jpS.getPageContext(), this.jsS, this.aWM);
        this.jAY.a(this.jpS.juu);
        this.jsS.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                an.this.jsS.q(postData);
                an.this.jzV.notifyDataSetChanged();
                an.this.jAY.cxl();
                an.this.Za.aVs();
                an.this.rB(false);
            }
        });
        if (this.jpS.cwD() != null && !StringUtils.isNull(this.jpS.cwD().czi())) {
            this.jpS.showToast(this.jpS.cwD().czi());
        }
        this.jAH = this.aWM.findViewById(R.id.pb_expand_blank_view);
        this.jAI = this.aWM.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jAI.getLayoutParams();
        if (this.jpS.cwD() != null && this.jpS.cwD().cyD()) {
            this.jAH.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.jAI.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = jAK;
            this.jAI.setLayoutParams(layoutParams2);
        }
        this.jAJ = new aj(this.jpS.getPageContext(), this.aWM.findViewById(R.id.pb_reply_expand_view));
        this.jAJ.jzh.setVisibility(8);
        this.jAJ.R(this.haA);
        this.jpS.registerListener(this.mAccountChangedListener);
        this.jpS.registerListener(this.jBu);
        cAs();
        rv(false);
    }

    public void rs(boolean z) {
        this.jAq.setVisibility(z ? 0 : 8);
    }

    public void caq() {
        if (!this.jpS.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").af("obj_locate", 2).cI("fid", this.mForumId));
        } else if (this.jpS.cxD()) {
            com.baidu.tbadk.editortools.pb.e cxq = this.jpS.cxq();
            if (cxq != null && (cxq.aXC() || cxq.aXD())) {
                this.jpS.cxq().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Za != null) {
                cAC();
            }
            if (this.Za != null) {
                this.jAz = false;
                if (this.Za.mD(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.jpS.getPageContext(), (View) this.Za.mD(2).dWH, false, jBr);
                }
            }
            cBk();
        }
    }

    private void cAs() {
        this.jBl = new com.baidu.tieba.pb.pb.godreply.a(this.jpS, this, (ViewStub) this.aWM.findViewById(R.id.more_god_reply_popup));
        this.jBl.z(this.haA);
        this.jBl.Q(this.jqM);
        this.jBl.setOnImageClickListener(this.emS);
        this.jBl.z(this.haA);
        this.jBl.setTbGestureDetector(this.dRh);
    }

    public com.baidu.tieba.pb.pb.godreply.a cAt() {
        return this.jBl;
    }

    public View cAu() {
        return this.jAH;
    }

    public void cAv() {
        if (this.jzK != null) {
            this.jzO.c(this.jzK);
            this.jzP.c(this.jzK);
            this.jzQ.c(this.jzK);
            this.jzN.c(this.jzK);
        }
    }

    private void cAw() {
        if (this.jzQ == null) {
            this.jzQ = new com.baidu.tieba.pb.pb.main.a.b(this.jpS, this.haA);
        }
    }

    private void cAx() {
        if (this.jzO == null) {
            this.jzO = new com.baidu.tieba.pb.pb.main.a.c(this.jpS, this.dRh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAy() {
        if (this.jpS.cxU()) {
            this.jzJ = (ViewStub) this.aWM.findViewById(R.id.manga_mention_controller_view_stub);
            this.jzJ.setVisibility(0);
            if (this.jzR == null) {
                this.jzR = (LinearLayout) this.aWM.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.jpS.getPageContext(), this.jzR);
            }
            if (this.jzS == null) {
                this.jzS = (TextView) this.jzR.findViewById(R.id.manga_prev_btn);
            }
            if (this.jzT == null) {
                this.jzT = (TextView) this.jzR.findViewById(R.id.manga_next_btn);
            }
            this.jzS.setOnClickListener(this.haA);
            this.jzT.setOnClickListener(this.haA);
        }
    }

    private void cAz() {
        if (this.jpS.cxU()) {
            if (this.jpS.cxX() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jzS, R.color.cp_cont_e, 1);
            }
            if (this.jpS.cxY() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jzT, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cAA() {
        if (this.jzR == null) {
            cAy();
        }
        this.jzJ.setVisibility(8);
        if (this.jBv != null && this.jBw != null) {
            this.jBv.removeCallbacks(this.jBw);
        }
    }

    public void cAB() {
        if (this.jBv != null) {
            if (this.jBw != null) {
                this.jBv.removeCallbacks(this.jBw);
            }
            this.jBw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.3
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.jzR == null) {
                        an.this.cAy();
                    }
                    an.this.jzJ.setVisibility(0);
                }
            };
            this.jBv.postDelayed(this.jBw, 2000L);
        }
    }

    public void rt(boolean z) {
        this.jzG.rt(z);
        if (z && this.jAD) {
            this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jzK.setNextPage(this.heO);
            this.jzF = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
        this.Za.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Za.getParent() == null) {
            this.aWM.addView(this.Za, layoutParams);
        }
        this.Za.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Za.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.an.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aRY() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aRY() == EmotionGroupType.USER_COLLECT) {
                        if (an.this.mPermissionJudgePolicy == null) {
                            an.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        an.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        an.this.mPermissionJudgePolicy.appendRequestPermission(an.this.jpS.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!an.this.mPermissionJudgePolicy.startRequestPermission(an.this.jpS.getBaseFragmentActivity())) {
                            an.this.jpS.cxq().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            an.this.jpS.cxq().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cAi();
        this.jpS.cxq().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.an.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (an.this.Za != null && an.this.Za.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (an.this.jBk == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, an.this.Za.getId());
                            an.this.jBk = new com.baidu.tieba.pb.pb.main.emotion.c(an.this.jpS.getPageContext(), an.this.aWM, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(an.this.jBj)) {
                                an.this.jBk.setData(an.this.jBj);
                            }
                            an.this.jBk.b(an.this.Za);
                        }
                        an.this.jBk.HS(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (an.this.jpS.jtB != null && an.this.jpS.jtB.cBz() != null) {
                    if (!an.this.jpS.jtB.cBz().deV()) {
                        an.this.jpS.jtB.rG(false);
                    }
                    an.this.jpS.jtB.cBz().uO(false);
                }
            }
        });
    }

    public void cAC() {
        if (this.jpS != null && this.Za != null) {
            this.Za.display();
            if (this.jpS.cxq() != null) {
                this.jpS.cxq().aXs();
            }
            cBk();
        }
    }

    public void ru(boolean z) {
        if (this.jzK != null && this.textView != null && this.aVX != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aVX.setVisibility(0);
                } else {
                    this.aVX.setVisibility(8);
                    this.jzK.removeHeaderView(this.textView);
                    this.jzK.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = jAK;
                    this.textView.setLayoutParams(layoutParams);
                }
                cAQ();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + rD(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cAQ();
            cBs();
        }
    }

    public f cAD() {
        return this.jzV;
    }

    public void a(PbFragment.c cVar) {
        this.juz = cVar;
    }

    public void cI(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jpS.getContext());
        kVar.setTitleText(this.jpS.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.jAc.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            an.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (an.this.jBy != null) {
                                an.this.jBy.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            an.this.jpS.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.jpS.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.jpS.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cBr()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.jpS.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.jpS.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.jpS.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aI(arrayList);
        if (this.jAc == null) {
            this.jAc = new com.baidu.tbadk.core.dialog.i(this.jpS.getPageContext(), kVar);
        } else {
            this.jAc.a(kVar);
        }
        this.jAc.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.jBy = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.jpS != null && aVar != null) {
            if (this.hBE == null && this.jzN != null) {
                this.hBE = new com.baidu.tieba.NEGFeedBack.e(this.jpS.getPageContext(), this.jzN.cBJ());
            }
            AntiData bNG = this.jpS.bNG();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bNG != null && bNG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNG.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.hBE.setDefaultReasonArray(new String[]{this.jpS.getString(R.string.delete_thread_reason_1), this.jpS.getString(R.string.delete_thread_reason_2), this.jpS.getString(R.string.delete_thread_reason_3), this.jpS.getString(R.string.delete_thread_reason_4), this.jpS.getString(R.string.delete_thread_reason_5)});
            this.hBE.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.hBE.xA(str);
            this.hBE.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.an.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    an.this.jpS.a(aVar, jSONArray);
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
        sparseArray.put(jAR, Integer.valueOf(jAS));
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
        this.jAd = new com.baidu.tbadk.core.dialog.a(this.jpS.getActivity());
        if (StringUtils.isNull(str2)) {
            this.jAd.kd(i3);
        } else {
            this.jAd.setOnlyMessageShowCenter(false);
            this.jAd.uf(str2);
        }
        this.jAd.setYesButtonTag(sparseArray);
        this.jAd.a(R.string.dialog_ok, this.jpS);
        this.jAd.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jAd.gE(true);
        this.jAd.b(this.jpS.getPageContext());
        if (z) {
            this.jAd.aMU();
        } else {
            a(this.jAd, i);
        }
    }

    public void aO(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.jAg == null) {
            this.jAg = LayoutInflater.from(this.jpS.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.jpS.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jAg);
        if (this.jAf == null) {
            this.jAf = new Dialog(this.jpS.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jAf.setCanceledOnTouchOutside(true);
            this.jAf.setCancelable(true);
            this.jAo = (ScrollView) this.jAg.findViewById(R.id.good_scroll);
            this.jAf.setContentView(this.jAg);
            WindowManager.LayoutParams attributes = this.jAf.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.jAf.getWindow().setAttributes(attributes);
            this.grx = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.jAk = (String) compoundButton.getTag();
                        if (an.this.grw != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : an.this.grw) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && an.this.jAk != null && !str.equals(an.this.jAk)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.jAh = (LinearLayout) this.jAg.findViewById(R.id.good_class_group);
            this.jAj = (TextView) this.jAg.findViewById(R.id.dialog_button_cancel);
            this.jAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.jAf instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(an.this.jAf, an.this.jpS.getPageContext());
                    }
                }
            });
            this.jAi = (TextView) this.jAg.findViewById(R.id.dialog_button_ok);
            this.jAi.setOnClickListener(this.haA);
        }
        this.jAh.removeAllViews();
        this.grw = new ArrayList();
        CustomBlueCheckRadioButton es = es("0", this.jpS.getPageContext().getString(R.string.thread_good_class));
        this.grw.add(es);
        es.setChecked(true);
        this.jAh.addView(es);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aIZ()) && adVar.aJa() > 0) {
                    CustomBlueCheckRadioButton es2 = es(String.valueOf(adVar.aJa()), adVar.aIZ());
                    this.grw.add(es2);
                    View view = new View(this.jpS.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.jAh.addView(view);
                    this.jAh.addView(es2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.jAo.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jpS.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jpS.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jpS.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.jAo.setLayoutParams(layoutParams2);
            this.jAo.removeAllViews();
            if (this.jAh != null && this.jAh.getParent() == null) {
                this.jAo.addView(this.jAh);
            }
        }
        com.baidu.adp.lib.f.g.a(this.jAf, this.jpS.getPageContext());
    }

    private CustomBlueCheckRadioButton es(String str, String str2) {
        Activity pageActivity = this.jpS.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.grx);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cAE() {
        this.jpS.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.jpS.hideProgressBar();
        if (z && z2) {
            this.jpS.showToast(this.jpS.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.jpS.showToast(str);
        }
    }

    public void chm() {
        this.jAb.setVisibility(0);
    }

    public void chl() {
        this.jAb.setVisibility(8);
    }

    public View cAF() {
        if (this.jAg != null) {
            return this.jAg.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cAG() {
        return this.jAk;
    }

    public View getView() {
        return this.aWM;
    }

    public void cAH() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.jpS.getPageContext().getPageActivity(), this.jpS.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.jpS.hideProgressBar();
        if (z) {
            cBa();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cBb();
        } else {
            cBa();
        }
    }

    public void cAI() {
        this.heO.setLineVisible();
        this.heO.startLoadData();
    }

    public void cAJ() {
        this.jpS.hideProgressBar();
        endLoadData();
        this.jzK.completePullRefreshPostDelayed(0L);
        cAV();
    }

    public void cAK() {
        this.jzK.completePullRefreshPostDelayed(0L);
        cAV();
    }

    private void rv(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.jzP.b(onLongClickListener);
        this.jzV.setOnLongClickListener(onLongClickListener);
        if (this.jBl != null) {
            this.jBl.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.jtC != null) {
            this.jtC.dismiss();
            this.jtC = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jpS.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.jpS.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jpS.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jpS.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jpS.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aI(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.jAl.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jAl = new com.baidu.tbadk.core.dialog.i(this.jpS.getPageContext(), kVar);
        this.jAl.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.jAl != null) {
            this.jAl.dismiss();
            this.jAl = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jpS.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.jqV != null && this.jqV.cvu() != null && !this.jqV.cvu().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.jpS.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jpS.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aI(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.jAl.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jAl = new com.baidu.tbadk.core.dialog.i(this.jpS.getPageContext(), kVar);
        this.jAl.showDialog();
    }

    public int cAL() {
        return zM(this.jzK.getFirstVisiblePosition());
    }

    private int zM(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.jzK.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.jzK.getAdapter() == null || !(this.jzK.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.jzK.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cAM() {
        int lastVisiblePosition = this.jzK.getLastVisiblePosition();
        if (this.jzM != null) {
            if (lastVisiblePosition == this.jzK.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return zM(lastVisiblePosition);
    }

    public void zN(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.jzK != null) {
            if (this.jzG == null || this.jzG.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.jzG.mNavigationBar.getFixedNavHeight();
                if (this.jpS.cxK() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.jAI != null && (layoutParams = (LinearLayout.LayoutParams) this.jAI.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.jAI.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.jzK.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.jzK.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.jzK.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.jzY.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.jzV.a(eVar, false);
        this.jzV.notifyDataSetChanged();
        cAV();
        if (this.jBl != null) {
            this.jBl.cwz();
        }
        ArrayList<PostData> cvw = eVar.cvw();
        if (eVar.getPage().aJA() == 0 || cvw == null || cvw.size() < eVar.getPage().aJz()) {
            if (com.baidu.tbadk.core.util.v.getCount(cvw) == 0 || (com.baidu.tbadk.core.util.v.getCount(cvw) == 1 && cvw.get(0) != null && cvw.get(0).cWr() == 1)) {
                if (this.jAN == null || this.jAN.jBR == null || this.jAN.jBR.getView() == null) {
                    i = 0;
                } else {
                    i = this.jAN.jBR.getView().getTop() < 0 ? this.jAN.jBR.getView().getHeight() : this.jAN.jBR.getView().getBottom();
                }
                if (this.jpS.cye()) {
                    this.heO.aj(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.heO.aj(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aJA() == 0) {
                    this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.heO.aQe();
            }
        }
        q(eVar);
    }

    public void p(com.baidu.tieba.pb.data.e eVar) {
        if (this.jzN != null) {
            this.jzN.e(eVar, this.jqE);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cvE() != null) {
            return eVar.cvE();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cvw())) {
            Iterator<PostData> it = eVar.cvw().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cWr() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cvB();
        }
        if (!o(postData)) {
            postData = a(eVar);
        }
        if (postData != null && postData.aKE() != null && postData.aKE().getUserTbVipInfoData() != null && postData.aKE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aKE().getGodUserData().setIntro(postData.aKE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean o(PostData postData) {
        if (postData == null || postData.aKE() == null) {
            return false;
        }
        MetaData aKE = postData.aKE();
        return (TextUtils.isEmpty(aKE.getUserId()) && TextUtils.isEmpty(aKE.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cvu() == null || eVar.cvu().aKE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aKE = eVar.cvu().aKE();
        String userId = aKE.getUserId();
        HashMap<String, MetaData> userMap = eVar.cvu().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aKE;
        }
        postData.Di(1);
        postData.setId(eVar.cvu().aKU());
        postData.setTitle(eVar.cvu().getTitle());
        postData.setTime(eVar.cvu().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.cvu() != null) {
            if (this.jpS.cwt()) {
                if (eVar.cvt() != null) {
                    this.mForumName = eVar.cvt().getForumName();
                    this.mForumId = eVar.cvt().getForumId();
                }
                if (this.mForumName == null && this.jpS.cwD() != null && this.jpS.cwD().cwu() != null) {
                    this.mForumName = this.jpS.cwD().cwu();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.jzP.setVisibility(8);
            if (eVar.aQh()) {
                this.jBc = true;
                this.jzG.rR(true);
                this.jzG.mNavigationBar.hideBottomLine();
                if (this.jzM == null) {
                    this.jzM = new com.baidu.tieba.pb.pb.main.a.e(this.jpS);
                }
                this.jzM.a(eVar, b, this.jzK, this.jzP, this.jAG, this.jzG, this.mForumName, this.jBq);
                this.jzM.S(this.jBA);
                cAQ();
            } else {
                this.jBc = false;
                this.jzG.rR(this.jBc);
                if (this.jzM != null) {
                    this.jzM.c(this.jzK);
                }
            }
            if (this.jpS.cxt() != null) {
                this.jpS.cxt().rL(this.jBc);
            }
            if (b != null) {
                this.jAC = b;
                this.jzP.setVisibility(0);
                SparseArray<Object> cBL = this.jzP.cBL();
                cBL.put(R.id.tag_clip_board, b);
                cBL.put(R.id.tag_is_subpb, false);
                this.jzQ.a(eVar, this.jzK);
                this.jzO.w(eVar);
                this.jzN.e(eVar, this.jqE);
                this.jzN.v(eVar);
                this.jzP.a(this.mSkinType, this.jqV, b, this.jBA);
                if (this.jAJ != null) {
                    if (eVar.cvS()) {
                        this.jAJ.getView().setVisibility(8);
                    } else {
                        this.jAJ.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.jow);
                        if (eVar.cvu() != null) {
                            jVar.joy = eVar.cvu().aKv();
                        }
                        jVar.isNew = !this.jqE;
                        jVar.sortType = eVar.jnw;
                        jVar.joA = eVar.cvT();
                        jVar.joB = this.jpS.cye();
                        this.jAJ.a(jVar);
                    }
                }
                if (eVar != null && eVar.cvu() != null) {
                    ag(eVar.cvu().aKA() == 1, eVar.cvu().aKz() == 1);
                }
                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (an.this.jzV != null && an.this.jzG != null && an.this.jzG.jFO != null && an.this.jqV != null && an.this.jqV.cvu() != null && !an.this.jqV.cvu().aJr() && !an.this.cAU() && an.this.jqV.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(an.this.jqV.getForum().getName())) {
                            if (an.this.jzV.cxh() == null || !an.this.jzV.cxh().isShown()) {
                                an.this.jzG.jFO.setVisibility(0);
                                if (an.this.jpS != null && an.this.jpS.cwD() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.cI("tid", an.this.jpS.cwD().cyA());
                                    anVar.cI("fid", an.this.jpS.cwD().getForumId());
                                    anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void rw(boolean z) {
        if (z) {
            cAN();
        } else {
            bIN();
        }
        this.jAN.jBR = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jAN));
        a(this.jAN.jBR, false);
    }

    public void cAN() {
        if (this.jzG != null && !this.jBe) {
            this.jzG.cAN();
            this.jBe = true;
        }
    }

    public void bIN() {
        if (this.jzG != null) {
            this.jzG.cCj();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.jzP.a(postData, eVar);
    }

    public void cAO() {
        if (this.jzM != null) {
            this.jzM.d(this.jzK);
        }
    }

    public boolean cAP() {
        return this.aIV;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aK(bj bjVar) {
        if (bjVar == null || bjVar.aKE() == null) {
            return false;
        }
        PostData b = b(this.jqV, false);
        String str = "";
        if (b != null && b.aKE() != null) {
            str = b.aKE().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.jzG.cCh();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.jzG.FC(dVar.forumName);
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
            final String str2 = dVar.jno;
            this.jpS.showNetRefreshView(this.aWM, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.aOY().b(an.this.jpS.getPageContext(), new String[]{str2});
                        an.this.jpS.finish();
                        return;
                    }
                    an.this.jpS.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable czT;
        Parcelable czT2;
        if (eVar != null && this.jzK != null) {
            this.jqV = eVar;
            this.mType = i;
            if (eVar.cvu() != null) {
                this.jAP = eVar.cvu().aKl();
                if (eVar.cvu().getAnchorLevel() != 0) {
                    this.aIV = true;
                }
                this.jAn = aK(eVar.cvu());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            u(eVar);
            this.jAD = false;
            this.jqE = z;
            cAJ();
            if (eVar.jnx != null && eVar.jnx.cvY()) {
                if (this.jzL == null) {
                    this.jzL = new PbThreadPostView(this.jpS.getContext());
                    this.jzK.addHeaderView(this.jzL, 1);
                    this.jzL.setData(eVar);
                    this.jzL.setChildOnClickLinstener(this.haA);
                }
            } else if (this.jzL != null && this.jzK != null) {
                this.jzK.removeHeaderView(this.jzL);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            r(eVar);
            if (this.jBo == null) {
                this.jBo = new aa(this.jpS.getPageContext(), this.hyH);
            }
            this.jBo.HI(eVar.cvz());
            if (this.jpS.cxU()) {
                if (this.jzZ == null) {
                    this.jzZ = new com.baidu.tieba.pb.view.d(this.jpS.getPageContext());
                    this.jzZ.createView();
                    this.jzZ.setListPullRefreshListener(this.dHd);
                }
                this.jzK.setPullRefresh(this.jzZ);
                cAQ();
                if (this.jzZ != null) {
                    this.jzZ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aJB() == 0 && z) {
                this.jzK.setPullRefresh(null);
            } else {
                if (this.jzZ == null) {
                    this.jzZ = new com.baidu.tieba.pb.view.d(this.jpS.getPageContext());
                    this.jzZ.createView();
                    this.jzZ.setListPullRefreshListener(this.dHd);
                }
                this.jzK.setPullRefresh(this.jzZ);
                cAQ();
                if (this.jzZ != null) {
                    this.jzZ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bzU();
            }
            cAV();
            this.jzV.qH(this.jqE);
            this.jzV.qI(false);
            this.jzV.qM(i == 5);
            this.jzV.qN(i == 6);
            this.jzV.qO(z2 && this.jBz);
            this.jzV.a(eVar, false);
            this.jzV.notifyDataSetChanged();
            this.jzP.a(b(eVar, z), eVar.cvS());
            if (eVar.cvu() != null && eVar.cvu().aKp() != null && this.jzE != -1) {
                eVar.cvu().aKp().setIsLike(this.jzE);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.jzK.setNextPage(this.heO);
                this.jzF = 2;
                bzU();
            } else {
                this.jAD = true;
                if (eVar.getPage().aJA() == 1) {
                    if (this.jAa == null) {
                        this.jAa = new com.baidu.tieba.pb.view.a(this.jpS, this.jpS);
                    }
                    this.jzK.setNextPage(this.jAa);
                } else {
                    this.jzK.setNextPage(this.heO);
                }
                this.jzF = 3;
            }
            ArrayList<PostData> cvw = eVar.cvw();
            if (eVar.getPage().aJA() == 0 || cvw == null || cvw.size() < eVar.getPage().aJz()) {
                if (com.baidu.tbadk.core.util.v.getCount(cvw) == 0 || (com.baidu.tbadk.core.util.v.getCount(cvw) == 1 && cvw.get(0) != null && cvw.get(0).cWr() == 1)) {
                    if (this.jAN == null || this.jAN.jBR == null || this.jAN.jBR.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.jAN.jBR.getView().getTop() < 0 ? this.jAN.jBR.getView().getHeight() : this.jAN.jBR.getView().getBottom();
                    }
                    if (this.jpS.cye()) {
                        this.heO.aj(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.heO.aj(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.jpS.cxt() != null && !this.jpS.cxt().cBV()) {
                        this.jpS.cxt().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aJA() == 0) {
                        this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.heO.aQe();
                }
                if (eVar.getPage().aJA() == 0 || cvw == null) {
                    cBf();
                }
            } else {
                if (z2) {
                    if (this.jBz) {
                        endLoadData();
                        if (eVar.getPage().aJA() != 0) {
                            this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.heO.setLineVisible();
                        this.heO.showLoading();
                    }
                } else {
                    this.heO.setLineVisible();
                    this.heO.showLoading();
                }
                this.heO.aQe();
            }
            switch (i) {
                case 2:
                    this.jzK.setSelection(i2 > 1 ? (((this.jzK.getData() == null && eVar.cvw() == null) ? 0 : (this.jzK.getData().size() - eVar.cvw().size()) + this.jzK.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (czT2 = ah.czS().czT()) != null && !(czT2 instanceof RecyclerView.SavedState)) {
                        this.jzK.onRestoreInstanceState(czT2);
                        if (com.baidu.tbadk.core.util.v.getCount(cvw) > 1 && eVar.getPage().aJA() > 0) {
                            this.heO.endLoadData();
                            this.heO.setText(this.jpS.getString(R.string.pb_load_more_without_point));
                            this.heO.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.jBz = false;
                    break;
                case 5:
                    this.jzK.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (czT = ah.czS().czT()) != null && !(czT instanceof RecyclerView.SavedState)) {
                        this.jzK.onRestoreInstanceState(czT);
                        break;
                    } else {
                        this.jzK.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.jzM != null && this.jzM.blG() != null) {
                            if (this.jpS.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.jzK.setSelectionFromTop((this.jzV.cxc() + this.jzK.getHeaderViewsCount()) - 1, this.jzM.cBN() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.jpS.getPageContext().getPageActivity()));
                            } else {
                                this.jzK.setSelectionFromTop((this.jzV.cxc() + this.jzK.getHeaderViewsCount()) - 1, this.jzM.cBN());
                            }
                        } else {
                            this.jzK.setSelection(this.jzV.cxc() + this.jzK.getHeaderViewsCount());
                        }
                    } else {
                        this.jzK.setSelection(i2 > 0 ? ((this.jzK.getData() == null && eVar.cvw() == null) ? 0 : (this.jzK.getData().size() - eVar.cvw().size()) + this.jzK.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.heO.endLoadData();
                    this.heO.setText(this.jpS.getString(R.string.pb_load_more_without_point));
                    this.heO.setLineGone();
                    break;
            }
            if (this.jAP == jAQ && isHost()) {
                cBn();
            }
            if (this.jBa) {
                cAg();
                this.jBa = false;
                if (i3 == 0) {
                    rp(true);
                }
            }
            if (eVar.jnt == 1 || eVar.jnu == 1) {
                if (this.jBg == null) {
                    this.jBg = new PbTopTipView(this.jpS.getContext());
                }
                if (eVar.jnu == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.jpS.getStType())) {
                    this.jBg.setText(this.jpS.getString(R.string.pb_read_strategy_add_experience));
                    this.jBg.a(this.aWM, this.mSkinType);
                } else if (eVar.jnt == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.jpS.getStType())) {
                    this.jBg.setText(this.jpS.getString(R.string.pb_read_news_add_experience));
                    this.jBg.a(this.aWM, this.mSkinType);
                }
            }
            q(eVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvu() != null) {
            t(eVar);
            if (eVar.aGZ()) {
                SvgManager.aOU().a(this.jAv, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aOU().a(this.jAv, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.jAy.setText(zO(eVar.cvu().aKv()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cvu()));
        }
    }

    private String zO(int i) {
        if (i == 0) {
            return this.jpS.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cAQ() {
        if (this.jzM != null) {
            this.jzM.a(this.jzK, this.textView, this.mType);
        }
    }

    public void rx(boolean z) {
        this.jAm = z;
    }

    public void endLoadData() {
        if (this.heO != null) {
            this.heO.setLineGone();
            this.heO.endLoadData();
        }
        bzU();
    }

    public void bpV() {
        this.jzK.setVisibility(0);
    }

    public void cAR() {
        if (this.jzK != null) {
            this.jzK.setVisibility(8);
        }
        if (this.jzK != null) {
            this.jAG.setVisibility(8);
        }
        if (this.jzG != null && this.jzG.jFL != null) {
            this.jzG.jFL.setVisibility(8);
        }
    }

    public void cAS() {
        if (this.jzK != null) {
            this.jzK.setVisibility(0);
        }
        if (this.jAG != null) {
            this.jAG.setVisibility(0);
        }
        if (this.jzG != null && this.jzG.jFL != null) {
            this.jzG.jFL.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void r(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.jAC != null && this.jAC.aKE() != null && this.jzG != null) {
            this.jBd = !this.jBc;
            this.jzG.rN(this.jBd);
            if (this.jpS.cxt() != null) {
                this.jpS.cxt().rM(this.jBd);
            }
            cAT();
            if (this.jpS != null && !this.jpS.cwt() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cvN())) {
                bf bfVar = eVar.cvN().get(0);
                if (bfVar != null) {
                    this.jzG.et(bfVar.getForumName(), bfVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.jzG.et(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            if (this.jBd) {
                this.jzP.a(eVar, this.jAC, this.jAn);
                if (this.jAI != null) {
                    this.jAI.setVisibility(8);
                }
                if (this.jBm == null) {
                    this.jBm = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.an.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (an.this.jpS != null && an.this.jpS.isAdded()) {
                                if (i < 0 && f > an.this.jBf) {
                                    an.this.cBm();
                                }
                                an.this.cAK();
                            }
                        }
                    };
                }
                this.jzK.setListViewDragListener(this.jBm);
                return;
            }
            if (this.jAI != null) {
                this.jAI.setVisibility(0);
            }
            this.jzP.a(eVar, this.jAC, this.jAn);
            this.jBm = null;
            this.jzK.setListViewDragListener(null);
        }
    }

    private void cAT() {
        this.jzP.a(this.jqV, this.jAC, this.jBd, this.jBc);
    }

    public boolean cAU() {
        return this.jqV == null || this.jqV.getForum() == null || "0".equals(this.jqV.getForum().getId()) || "me0407".equals(this.jqV.getForum().getName());
    }

    private boolean cAV() {
        return this.jzN.rI(this.jqE);
    }

    private boolean s(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cvu() == null) {
            return false;
        }
        if (eVar.cvu().aKB() == 1 || eVar.cvu().getThreadType() == 33) {
            return true;
        }
        return !(eVar.cvu().aKD() == null || eVar.cvu().aKD().aML() == 0) || eVar.cvu().aKz() == 1 || eVar.cvu().aKA() == 1 || eVar.cvu().aLp() || eVar.cvu().aLJ() || eVar.cvu().aLC() || eVar.cvu().aKQ() != null || !com.baidu.tbadk.core.util.aq.isEmpty(eVar.cvu().getCategory()) || eVar.cvu().aKH() || eVar.cvu().aKG();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.jzO != null) {
                if (eVar.cvu() != null && eVar.cvu().aKT() == 0 && !eVar.cvu().aJr() && !this.jBs) {
                    if (eVar.cvu() != null) {
                        bj cvu = eVar.cvu();
                        cvu.s(true, s(eVar));
                        cvu.jP(3);
                        cvu.tS("2");
                    }
                    if (eVar.cvu().aJt()) {
                        this.jzP.c(this.jzK);
                        this.jzO.c(this.jzK);
                        this.jzO.b(this.jzK);
                        this.jzP.b(this.jzK);
                        this.jzP.B(this.jqV);
                        this.jzO.x(eVar);
                    } else {
                        this.jzP.B(this.jqV);
                        this.jzO.z(eVar);
                    }
                } else if (eVar.cvu().aKT() == 1) {
                    if (eVar.cvu() != null) {
                        this.jzO.c(this.jzK);
                        this.jzP.B(this.jqV);
                    }
                } else {
                    this.jzO.c(this.jzK);
                    this.jzP.B(this.jqV);
                }
            }
            if (eVar.cvu() != null) {
                af(eVar.cvu().aKA() == 1, eVar.cvu().aKz() == 1);
            }
            this.jqE = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cAV();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.w wVar;
        StringBuilder sb = null;
        if (eVar != null && (b = b(eVar, z)) != null) {
            String userId = b.aKE().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cvG()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.aKE() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.aKE().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.aKE().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.aKE().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cvG()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cvN = eVar.cvN();
                if (com.baidu.tbadk.core.util.v.getCount(cvN) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cvN) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.dqj) != null && wVar.dod && !wVar.doe && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(this.jpS.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.jpS.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cAW() {
        return this.ecU;
    }

    public boolean cAX() {
        if (this.aXv == null || this.aXv.getParent() == null || this.heO.isLoading()) {
            return false;
        }
        int bottom = this.aXv.getBottom();
        Rect rect = new Rect();
        this.aXv.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void HK(String str) {
        if (this.heO != null) {
            this.heO.setText(str);
        }
    }

    public void HL(String str) {
        if (this.heO != null) {
            int i = 0;
            if (this.jAN != null && this.jAN.jBR != null && this.jAN.jBR.getView() != null) {
                i = this.jAN.jBR.getView().getTop() < 0 ? this.jAN.jBR.getView().getHeight() : this.jAN.jBR.getView().getBottom();
            }
            this.heO.aj(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.jzK;
    }

    public int cAY() {
        return R.id.richText;
    }

    public TextView cwN() {
        return this.jzP.cwN();
    }

    public void d(BdListView.e eVar) {
        this.jzK.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.dHd = cVar;
        if (this.jzZ != null) {
            this.jzZ.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int aJy = apVar.aJy();
            int aJv = apVar.aJv();
            if (this.jzW != null) {
                this.jzW.aMU();
            } else {
                this.jzW = new com.baidu.tbadk.core.dialog.a(this.jpS.getPageContext().getPageActivity());
                this.jzX = LayoutInflater.from(this.jpS.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.jzW.aP(this.jzX);
                this.jzW.a(R.string.dialog_ok, bVar);
                this.jzW.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.cBa();
                        aVar.dismiss();
                    }
                });
                this.jzW.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.jAX == null) {
                            an.this.jAX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.jpS.HidenSoftKeyPad((InputMethodManager) an.this.jpS.getBaseFragmentActivity().getSystemService("input_method"), an.this.aWM);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.lb().postDelayed(an.this.jAX, 150L);
                    }
                });
                this.jzW.b(this.jpS.getPageContext()).aMU();
            }
            this.jzY = (EditText) this.jzX.findViewById(R.id.input_page_number);
            this.jzY.setText("");
            TextView textView = (TextView) this.jzX.findViewById(R.id.current_page_number);
            if (aJy <= 0) {
                aJy = 1;
            }
            if (aJv <= 0) {
                aJv = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aJy), Integer.valueOf(aJv)));
            this.jpS.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.jzY, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jzK.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.jpS.showToast(str);
    }

    public boolean ry(boolean z) {
        if (this.Za == null || !this.Za.aWR()) {
            return false;
        }
        this.Za.aVs();
        return true;
    }

    public void cAZ() {
        if (this.jBB != null) {
            while (this.jBB.size() > 0) {
                TbImageView remove = this.jBB.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cAZ();
        this.jzV.zq(1);
        if (this.jzM != null) {
            this.jzM.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.jzV.zq(2);
        if (this.jzM != null) {
            this.jzM.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.jpS.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.jpS.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.jAx != null) {
            this.jAx.onDestroy();
        }
        if (this.jAZ != null) {
            this.jAZ.destroy();
        }
        if (this.jBo != null) {
            this.jBo.onDestory();
        }
        if (this.jBg != null) {
            this.jBg.hide();
        }
        this.jpS.hideProgressBar();
        if (this.gAG != null && this.gVM != null) {
            this.gAG.b(this.gVM);
        }
        cBa();
        endLoadData();
        if (this.jAX != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jAX);
        }
        if (this.jAF != null) {
            this.jAF.clearStatus();
        }
        this.jBv = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.jzV.zq(3);
        if (this.aVX != null) {
            this.aVX.setBackgroundDrawable(null);
        }
        if (this.jzM != null) {
            this.jzM.destroy();
        }
        if (this.jzV != null) {
            this.jzV.onDestroy();
        }
        this.jzK.setOnLayoutListener(null);
        if (this.jBk != null) {
            this.jBk.bRj();
        }
        if (this.jAO != null) {
            this.jAO.onDestroy();
        }
        if (this.jzP != null) {
            this.jzP.onDestroy();
        }
    }

    public boolean zP(int i) {
        if (this.jzM != null) {
            return this.jzM.zP(i);
        }
        return false;
    }

    public void cBa() {
        this.jzG.aAi();
        if (this.jzP != null) {
            this.jzP.cBa();
        }
        if (this.jpS != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.jpS.getContext(), this.jzY);
        }
        cAi();
        if (this.jtC != null) {
            this.jtC.dismiss();
        }
        cBc();
        if (this.jzW != null) {
            this.jzW.dismiss();
        }
        if (this.haz != null) {
            this.haz.dismiss();
        }
    }

    public void cBb() {
        this.jzG.aAi();
        if (this.jzP != null) {
            this.jzP.cBa();
        }
        if (this.jtC != null) {
            this.jtC.dismiss();
        }
        cBc();
        if (this.jzW != null) {
            this.jzW.dismiss();
        }
        if (this.haz != null) {
            this.haz.dismiss();
        }
    }

    public void dS(List<String> list) {
        this.jBj = list;
        if (this.jBk != null) {
            this.jBk.setData(list);
        }
    }

    public void qG(boolean z) {
        this.jzV.qG(z);
    }

    public void rz(boolean z) {
        this.jAp = z;
    }

    public void cBc() {
        if (this.jAd != null) {
            this.jAd.dismiss();
        }
        if (this.jAe != null) {
            com.baidu.adp.lib.f.g.b(this.jAe, this.jpS.getPageContext());
        }
        if (this.jAf != null) {
            com.baidu.adp.lib.f.g.b(this.jAf, this.jpS.getPageContext());
        }
        if (this.jAc != null) {
            this.jAc.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.jqV, this.jqE);
            b(this.jqV, this.jqE, this.mType, i);
            this.jpS.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.jpS.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.aWM);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.aWM, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.jAq, R.drawable.personalize_tab_shadow);
            if (this.jzM != null) {
                this.jzM.onChangeSkinType(i);
            }
            if (this.jzQ != null) {
                this.jzQ.onChangeSkinType(i);
            }
            if (this.jzN != null) {
                this.jzN.onChangeSkinType(i);
            }
            if (this.jzO != null) {
                this.jzO.onChangeSkinType(i);
            }
            if (this.jzP != null) {
                this.jzP.onChangeSkinType(i);
            }
            if (this.heO != null) {
                this.heO.changeSkin(i);
                if (this.ecU != null) {
                    this.jpS.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.ecU);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.ecU, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.jzW != null) {
                this.jzW.c(this.jpS.getPageContext());
            }
            rx(this.jAm);
            this.jzV.notifyDataSetChanged();
            if (this.jzZ != null) {
                this.jzZ.changeSkin(i);
            }
            if (this.Za != null) {
                this.Za.onChangeSkinType(i);
            }
            if (this.jAa != null) {
                this.jAa.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.grw)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.grw) {
                    customBlueCheckRadioButton.aPR();
                }
            }
            cAz();
            UtilHelper.setStatusBarBackground(this.aVX, i);
            UtilHelper.setStatusBarBackground(this.jAI, i);
            if (this.jzR != null) {
                com.baidu.tbadk.q.a.a(this.jpS.getPageContext(), this.jzR);
            }
            if (this.jAY != null) {
                this.jAY.onChangeSkinType(i);
            }
            if (this.jzG != null) {
                if (this.jzM != null) {
                    this.jzM.zQ(i);
                } else {
                    this.jzG.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.hSi != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hSi, (int) R.color.cp_cont_d);
                this.hSi.setBackgroundDrawable(com.baidu.tbadk.core.util.am.aB(com.baidu.adp.lib.util.l.getDimens(this.jpS.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.jAv != null && this.jqV != null) {
                if (this.jqV.aGZ()) {
                    SvgManager.aOU().a(this.jAv, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aOU().a(this.jAv, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            t(this.jqV);
            if (this.jAu != null) {
                SvgManager.aOU().a(this.jAu, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jAs != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jAs, R.drawable.bottom_shadow);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jAy, (int) R.color.cp_cont_b);
            if (this.jBl != null) {
                this.jBl.onChangeSkinType(i);
            }
            if (this.jAO != null) {
                this.jAO.onChangeSkinType();
            }
            if (this.jBi != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jBi, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jAt, R.color.cp_bg_line_h);
            if (this.jzL != null) {
                this.jzL.pH(i);
            }
        }
    }

    public void cBd() {
        if (this.jAx != null) {
            this.jAx.setEnable(false);
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.ba(eVar.cvu())) {
            if (this.jAx != null) {
                this.jAx.setEnable(false);
                this.jAx.onDestroy();
            }
            SvgManager.aOU().a(this.jAw, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.jAx == null || !this.jAx.isEnable()) {
            SvgManager.aOU().a(this.jAw, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emS = iVar;
        this.jzV.setOnImageClickListener(this.emS);
        this.jBl.setOnImageClickListener(this.emS);
    }

    public void g(NoNetworkView.a aVar) {
        this.gVM = aVar;
        if (this.gAG != null) {
            this.gAG.a(this.gVM);
        }
    }

    public void rA(boolean z) {
        this.jzV.setIsFromCDN(z);
    }

    public Button cBe() {
        return this.jAr;
    }

    public void cBf() {
        if (this.jzF != 2) {
            this.jzK.setNextPage(this.heO);
            this.jzF = 2;
        }
    }

    public void cBg() {
        if (com.baidu.tbadk.n.m.aZA().aZB()) {
            int lastVisiblePosition = this.jzK.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.jzK.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.edD = true;
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
                        perfLog2.edD = true;
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

    public boolean cBh() {
        return this.Za != null && this.Za.getVisibility() == 0;
    }

    public boolean cBi() {
        return this.Za != null && this.Za.aWR();
    }

    public void cBj() {
        if (this.Za != null) {
            this.Za.aVs();
        }
    }

    public void rB(boolean z) {
        if (this.jAt != null) {
            rz(this.jpS.cxq().aXv());
            if (this.jAp) {
                rq(z);
            } else {
                rr(z);
            }
        }
    }

    public void cBk() {
        if (this.jAt != null) {
            this.jAs.setVisibility(8);
            this.jAt.setVisibility(8);
            this.jAz = false;
            if (this.jAO != null) {
                this.jAO.setVisibility(8);
                rv(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.gvy == null) {
            this.gvy = new com.baidu.tbadk.core.view.a(this.jpS.getPageContext());
        }
        this.gvy.setDialogVisiable(true);
    }

    public void bzU() {
        if (this.gvy != null) {
            this.gvy.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.jzK.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.jzK.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.jzM != null) {
            this.jzM.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.jBC = getScrollY();
            this.jAN.jBR = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jAN));
            a(this.jAN.jBR, true);
        }
    }

    public void rC(boolean z) {
        if (this.jzM != null) {
            this.jzM.rC(z);
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
        if (this.jzM != null) {
            this.jzM.onScroll(absListView, i, i2, i3);
        }
        if (this.jzG != null && this.jzV != null) {
            this.jzG.cK(this.jzV.cxh());
        }
        this.jAN.jiN = i;
        this.jAN.headerCount = this.jzK.getHeaderViewsCount();
        this.jAN.jBR = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jAN));
        rs(b(absListView, i));
        a(this.jAN.jBR, false);
        if (this.heO.aQf() && !this.heO.dGx) {
            if (this.jAN != null && this.jAN.jBR != null && this.jAN.jBR.getView() != null) {
                i4 = this.jAN.jBR.getView().getTop() < 0 ? this.jAN.jBR.getView().getHeight() : this.jAN.jBR.getView().getBottom();
            }
            this.heO.lv(i4);
            this.heO.dGx = true;
        }
    }

    public void cBl() {
        if (TbadkCoreApplication.isLogin() && this.jqV != null && this.jBd && !this.jBc && !this.jAn && this.jAC != null && this.jAC.aKE() != null && !this.jAC.aKE().getIsLike() && !this.jAC.aKE().hadConcerned() && this.jAZ == null) {
            this.jAZ = new ak(this.jpS);
        }
    }

    public void cBm() {
        if (this.jBd && !this.jBc && this.jAC != null && this.jAC.aKE() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").af("obj_locate", this.jpS.cwt() ? 2 : 1).af("obj_type", this.jBc ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.jpS.getPageContext().getPageActivity(), this.jAC.aKE().getUserId(), this.jAC.aKE().getUserName(), this.jpS.cwD().cwu(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aj ajVar, boolean z) {
        int measuredHeight;
        if (!this.jBc && this.jAH != null && this.jzG.cCb() != null) {
            int cxd = this.jzV.cxd();
            if (cxd > 0 && (ajVar == null || ajVar.getView().getParent() == null)) {
                if (cxd > this.jzK.getFirstVisiblePosition() - this.jzK.getHeaderViewsCount()) {
                    this.jAH.setVisibility(8);
                    return;
                }
                this.jAH.setVisibility(0);
                rs(false);
                this.jzG.mNavigationBar.hideBottomLine();
                if (this.jAH.getParent() != null && ((ViewGroup) this.jAH.getParent()).getHeight() <= this.jAH.getTop()) {
                    this.jAH.getParent().requestLayout();
                }
            } else if (ajVar == null || ajVar.getView() == null || ajVar.jzh == null) {
                if (this.jzK.getFirstVisiblePosition() == 0) {
                    this.jAH.setVisibility(8);
                    this.jzG.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = ajVar.getView().getTop();
                if (ajVar.getView().getParent() != null) {
                    if (this.jAM) {
                        this.jAL = top2;
                        this.jAM = false;
                    }
                    this.jAL = top2 < this.jAL ? top2 : this.jAL;
                }
                if (top2 != 0 || ajVar.getView().isShown()) {
                    if (this.jzU.getY() < 0.0f) {
                        measuredHeight = jAK - ajVar.jzh.getMeasuredHeight();
                    } else {
                        measuredHeight = this.jzG.cCb().getMeasuredHeight() - ajVar.jzh.getMeasuredHeight();
                        this.jzG.mNavigationBar.hideBottomLine();
                    }
                    if (ajVar.getView().getParent() == null && top2 <= this.jAL) {
                        this.jAH.setVisibility(0);
                        rs(false);
                    } else if (top2 < measuredHeight) {
                        this.jAH.setVisibility(0);
                        rs(false);
                    } else {
                        this.jAH.setVisibility(8);
                        this.jzG.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.jAM = true;
                    }
                }
            }
        }
    }

    public void cBn() {
        if (!this.jBD) {
            TiebaStatic.log("c10490");
            this.jBD = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jpS.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(jAR, Integer.valueOf(jAT));
            aVar.kc(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.jpS.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aP(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.jpS);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jpS.getPageContext()).aMU();
        }
    }

    public void HM(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jpS.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.jpS.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aP(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(jAR, Integer.valueOf(jAU));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.jpS);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jpS.getPageContext()).aMU();
    }

    public void a(int i, com.baidu.tieba.pb.data.e eVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(eVar, z)) != null && b.aKE() != null) {
            MetaData aKE = b.aKE();
            aKE.setGiftNum(aKE.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        a(eVar, z, i, i2);
        r(eVar);
    }

    public PbInterviewStatusView cBo() {
        return this.jAF;
    }

    private void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvu() != null && eVar.cvu().aLJ() && this.jAF == null) {
            this.jAF = (PbInterviewStatusView) this.jAE.inflate();
            this.jAF.setOnClickListener(this.haA);
            this.jAF.setCallback(this.jpS.cyc());
            this.jAF.setData(this.jpS, eVar);
        }
    }

    public RelativeLayout cBp() {
        return this.jzU;
    }

    public View cBq() {
        return this.aVX;
    }

    public boolean cBr() {
        return this.jBs;
    }

    public void qL(boolean z) {
        this.jzP.qL(z);
    }

    public void HN(String str) {
        if (this.jzH != null) {
            this.jzH.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int rD(boolean z) {
        if (this.jAF == null || this.jAF.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cBs() {
        if (this.jAF != null && this.jAF.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jAF.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.jAF.setLayoutParams(layoutParams);
        }
    }

    public boolean cxw() {
        return false;
    }

    public void HO(String str) {
        this.hSi.performClick();
        if (!StringUtils.isNull(str) && this.jpS.cxq() != null && this.jpS.cxq().aXo() != null && this.jpS.cxq().aXo().getInputView() != null) {
            EditText inputView = this.jpS.cxq().aXo().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cBa();
            if (configuration.orientation == 2) {
                cBk();
                cAi();
            } else {
                cAm();
            }
            if (this.jAY != null) {
                this.jAY.cxl();
            }
            this.jpS.bOU();
            this.jzU.setVisibility(8);
            this.jzG.rO(false);
            this.jpS.qZ(false);
            if (this.jzM != null) {
                if (configuration.orientation == 1) {
                    cBp().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.jzK.setIsLandscape(true);
                    this.jzK.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.jzK.setIsLandscape(false);
                    if (this.jBC > 0) {
                        this.jzK.smoothScrollBy(this.jBC, 0);
                    }
                }
                this.jzM.onConfigurationChanged(configuration);
                this.jAG.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void rE(boolean z) {
        if (this.jzM != null) {
            this.jzM.rE(z);
        }
    }

    public boolean cBt() {
        return this.jzM != null && this.jzM.cBt();
    }

    public void cBu() {
        if (this.jzM != null) {
            this.jzM.cBu();
        }
    }

    public void qP(boolean z) {
        this.jzV.qP(z);
    }

    public void cJ(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.jAt.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.jpS.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.jBi = new TextView(this.jpS.getContext());
            this.jBi.setText(R.string.connection_tips);
            this.jBi.setGravity(17);
            this.jBi.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jpS.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.jpS.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.jpS.getContext(), R.dimen.ds60);
            if (this.jBi.getParent() == null) {
                frameLayout.addView(this.jBi, layoutParams);
            }
            this.jBh = new PopupWindow(this.jpS.getContext());
            this.jBh.setContentView(frameLayout);
            this.jBh.setHeight(-2);
            this.jBh.setWidth(-2);
            this.jBh.setFocusable(true);
            this.jBh.setOutsideTouchable(false);
            this.jBh.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.jzK.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        an.this.jBh.showAsDropDown(an.this.jAt, view.getLeft(), -an.this.jAt.getHeight());
                    } else {
                        an.this.jBh.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void rF(boolean z) {
        this.jBn = z;
    }

    public boolean cBv() {
        return this.jBn;
    }

    public PbThreadPostView cBw() {
        return this.jzL;
    }

    private void af(boolean z, boolean z2) {
        ag(z, z2);
        if (this.jqV != null && this.jqV.cvu() != null && this.jqV.cvu().aKT() == 0 && !this.jqV.cvu().aJr()) {
            ah(z, z2);
        } else if (this.jzV != null && this.jzV.cxi() != null) {
            this.jzV.cxi().b(this.jqV, z, z2);
        }
    }

    private void ag(boolean z, boolean z2) {
        this.jzP.d(this.jqV, z, z2);
    }

    private void ah(boolean z, boolean z2) {
        this.jzO.c(this.jqV, z, z2);
    }
}
