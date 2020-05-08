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
    private static final int jAO = UtilHelper.getLightStatusBarHeight();
    public static int jAU = 3;
    public static int jAV = 0;
    public static int jAW = 3;
    public static int jAX = 4;
    public static int jAY = 5;
    public static int jAZ = 6;
    private static a.InterfaceC0673a jBv = new a.InterfaceC0673a() { // from class: com.baidu.tieba.pb.pb.main.an.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0673a
        public void onRefresh() {
        }
    };
    private EditorTools Zd;
    private RelativeLayout aWR;
    private View aWc;
    private View aXA;
    private g.c dHh;
    private com.baidu.tieba.pb.a.c dRm;
    private View ecZ;
    private NoNetworkView gAM;
    private List<CustomBlueCheckRadioButton> grC;
    private com.baidu.tieba.NEGFeedBack.e hBK;
    private TextView hSo;
    private View.OnClickListener haG;
    private PbListView heU;
    private NavigationBarCoverTip hyN;
    private boolean isLandscape;
    private ImageView jAA;
    private com.baidu.tieba.pb.view.c jAB;
    private TextView jAC;
    private int jAE;
    private int jAF;
    private PostData jAG;
    private ViewStub jAI;
    private PbInterviewStatusView jAJ;
    private FrameLayout jAK;
    private View jAL;
    private View jAM;
    private aj jAN;
    private PbEmotionBar jAS;
    private View jAf;
    private View jAu;
    private View jAw;
    private View jAx;
    private ImageView jAy;
    private ImageView jAz;
    private Runnable jBA;
    private PbFragment.b jBC;
    public int jBG;
    private int jBa;
    private Runnable jBb;
    private s jBc;
    private ak jBd;
    private int jBj;
    private PbTopTipView jBk;
    private PopupWindow jBl;
    private TextView jBm;
    private List<String> jBn;
    private com.baidu.tieba.pb.pb.main.emotion.c jBo;
    private com.baidu.tieba.pb.pb.godreply.a jBp;
    private PbLandscapeListView.b jBq;
    private aa jBs;
    private String jBt;
    private long jBu;
    private boolean jBw;
    private PbFragment jpW;
    private View.OnClickListener jqQ;
    private com.baidu.tieba.pb.data.e jqZ;
    private PbFakeFloorModel jsW;
    PbFragment.c juD;
    public int jzI;
    public final com.baidu.tieba.pb.pb.main.view.c jzK;
    public com.baidu.tieba.pb.pb.main.view.b jzL;
    private ViewStub jzM;
    private ViewStub jzN;
    private PbLandscapeListView jzO;
    private PbThreadPostView jzP;
    private com.baidu.tieba.pb.pb.main.a.e jzQ;
    private com.baidu.tieba.pb.pb.main.a.a jzR;
    private com.baidu.tieba.pb.pb.main.a.c jzS;
    private com.baidu.tieba.pb.pb.main.a.d jzT;
    private com.baidu.tieba.pb.pb.main.a.b jzU;
    private LinearLayout jzV;
    private TextView jzW;
    private TextView jzX;
    private ObservedChangeRelativeLayout jzY;
    private f jzZ;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int jzJ = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a jAa = null;
    private com.baidu.tbadk.core.dialog.b haF = null;
    private View jAb = null;
    private EditText jAc = null;
    private com.baidu.tieba.pb.view.d jAd = null;
    private com.baidu.tieba.pb.view.a jAe = null;
    private b.a ipc = null;
    private TbRichTextView.i emX = null;
    private NoNetworkView.a gVS = null;
    private com.baidu.tbadk.core.dialog.i jAg = null;
    private com.baidu.tbadk.core.dialog.a jAh = null;
    private Dialog jAi = null;
    private Dialog jAj = null;
    private View jAk = null;
    private LinearLayout jAl = null;
    private CompoundButton.OnCheckedChangeListener grD = null;
    private TextView jAm = null;
    private TextView jAn = null;
    private String jAo = null;
    private com.baidu.tbadk.core.dialog.i jtG = null;
    private com.baidu.tbadk.core.dialog.i jAp = null;
    private boolean jAq = false;
    private boolean jAr = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView jAs = null;
    private boolean jAt = false;
    private Button jAv = null;
    private boolean jAD = true;
    private com.baidu.tbadk.core.view.a gvE = null;
    private boolean jqI = false;
    private int mSkinType = 3;
    private boolean jAH = false;
    private int jAP = 0;
    private boolean jAQ = true;
    public a jAR = new a();
    private int jAT = 0;
    private boolean jBe = false;
    private int jBf = 0;
    private boolean jBg = false;
    private boolean jBh = false;
    private boolean jBi = false;
    private boolean jBr = false;
    private String jBx = null;
    private CustomMessageListener jBy = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.an.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                an.this.jBx = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.jzZ != null) {
                an.this.jzZ.notifyDataSetChanged();
            }
        }
    };
    private Handler jBz = new Handler();
    private CustomMessageListener jBB = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.jAD = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean jBD = true;
    View.OnClickListener jBE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || an.this.jqZ == null || an.this.jqZ.cvr() == null || an.this.jqZ.cvr().aKC() == null || an.this.jqZ.cvr().aKC().getAlaUserData() == null || an.this.jqZ.cvr().aKC().getAlaUserData().live_status != 1 || an.this.jqZ.cvr().aKC().getAlaUserData().live_id <= 0) {
                if (an.this.jBg) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").af("obj_id", 2));
                }
                if (!an.this.jBg && an.this.jqZ != null && an.this.jqZ.cvr() != null && an.this.jqZ.cvr().aKC() != null && an.this.jqZ.cvr().aKC().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").af("obj_locate", 1));
                }
                if (an.this.jpW.cyh() != null) {
                    an.this.jpW.cyh().jqi.gHY.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = an.this.jqZ.cvr().aKC().getAlaUserData().live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(an.this.jpW.cyh(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
        }
    };
    private boolean aJb = false;
    String userId = null;
    private final List<TbImageView> jBF = new ArrayList();
    private boolean jBH = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public aj jBV;
        public int jiR;
    }

    public void rp(boolean z) {
        this.jBe = z;
        if (this.jzO != null) {
            this.jBf = this.jzO.getHeaderViewsCount();
        }
    }

    public void cAd() {
        if (this.jzO != null) {
            int headerViewsCount = this.jzO.getHeaderViewsCount() - this.jBf;
            final int firstVisiblePosition = (this.jzO.getFirstVisiblePosition() == 0 || this.jzO.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.jzO.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.jzO.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.jAR.jBV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jAR));
            final aj ajVar = this.jAR.jBV;
            final int f = f(ajVar);
            final int y = ((int) this.jzY.getY()) + this.jzY.getMeasuredHeight();
            final boolean z = this.jAL.getVisibility() == 0;
            boolean z2 = this.jzY.getY() < 0.0f;
            if ((z && ajVar != null) || firstVisiblePosition >= this.jzZ.cxa() + this.jzO.getHeaderViewsCount()) {
                int measuredHeight = ajVar != null ? ajVar.jzl.getMeasuredHeight() : 0;
                if (z2) {
                    this.jzO.setSelectionFromTop(this.jzZ.cxa() + this.jzO.getHeaderViewsCount(), jAO - measuredHeight);
                } else {
                    this.jzO.setSelectionFromTop(this.jzZ.cxa() + this.jzO.getHeaderViewsCount(), this.jzK.cBY().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.jzO.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.jBg && this.jzQ != null) {
                this.jzO.setSelectionFromTop(this.jzZ.cxa() + this.jzO.getHeaderViewsCount(), this.jzQ.cBK());
            } else if (this.mType == 6) {
                this.jzO.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cyr() {
                        ViewGroup.LayoutParams layoutParams;
                        if (f >= 0 && f <= an.this.aWR.getMeasuredHeight()) {
                            int f2 = an.this.f(ajVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            if (an.this.aXA != null && (layoutParams = an.this.aXA.getLayoutParams()) != null) {
                                if (i == 0 || i > an.this.aWR.getMeasuredHeight() || f2 >= an.this.aWR.getMeasuredHeight()) {
                                    layoutParams.height = an.this.jBa;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.aWR.getMeasuredHeight()) {
                                    layoutParams.height = an.this.jBa;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    an.this.jzO.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                an.this.aXA.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (an.this.aXA != null && an.this.aXA.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = an.this.aXA.getLayoutParams();
                                            layoutParams2.height = an.this.jBa;
                                            an.this.aXA.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        an.this.jzO.setOnLayoutListener(null);
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

    public NoNetworkView cAe() {
        return this.gAM;
    }

    public void cAf() {
        if (this.Zd != null) {
            this.Zd.hide();
            if (this.jBo != null) {
                this.jBo.cBM();
            }
        }
    }

    public PbFakeFloorModel cAg() {
        return this.jsW;
    }

    public s cAh() {
        return this.jBc;
    }

    public com.baidu.tieba.pb.pb.main.a.e cAi() {
        return this.jzQ;
    }

    public void cAj() {
        reset();
        cAf();
        this.jBc.cxi();
        rB(false);
    }

    private void reset() {
        if (this.jpW != null && this.jpW.cxn() != null && this.Zd != null) {
            com.baidu.tbadk.editortools.pb.a.aXj().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cxn = this.jpW.cxn();
            cxn.aXD();
            cxn.aWX();
            if (cxn.getWriteImagesInfo() != null) {
                cxn.getWriteImagesInfo().setMaxImagesAllowed(cxn.isBJH ? 1 : 9);
            }
            cxn.mJ(SendView.ALL);
            cxn.mK(SendView.ALL);
            com.baidu.tbadk.editortools.g mA = this.Zd.mA(23);
            com.baidu.tbadk.editortools.g mA2 = this.Zd.mA(2);
            com.baidu.tbadk.editortools.g mA3 = this.Zd.mA(5);
            if (mA2 != null) {
                mA2.display();
            }
            if (mA3 != null) {
                mA3.display();
            }
            if (mA != null) {
                mA.hide();
            }
            this.Zd.invalidate();
        }
    }

    public boolean cAk() {
        return this.jAD;
    }

    public void rq(boolean z) {
        if (this.jAx != null && this.hSo != null) {
            this.hSo.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jAx.startAnimation(alphaAnimation);
            }
            this.jAw.setVisibility(0);
            this.jAx.setVisibility(0);
            this.jAD = true;
            if (this.jAS != null && !this.jBp.isActive()) {
                this.jAS.setVisibility(0);
                rv(true);
            }
        }
    }

    public void rr(boolean z) {
        if (this.jAx != null && this.hSo != null) {
            this.hSo.setText(cAl());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jAx.startAnimation(alphaAnimation);
            }
            this.jAw.setVisibility(0);
            this.jAx.setVisibility(0);
            this.jAD = true;
            if (this.jAS != null && !this.jBp.isActive()) {
                this.jAS.setVisibility(0);
                rv(true);
            }
        }
    }

    public String cAl() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.jBt)) {
            return this.jBt;
        }
        if (this.jpW != null) {
            this.jBt = TbadkCoreApplication.getInst().getResources().getString(am.cAa());
        }
        return this.jBt;
    }

    public PostData cAm() {
        int i = 0;
        if (this.jzO == null) {
            return null;
        }
        int cAn = cAn() - this.jzO.getHeaderViewsCount();
        if (cAn < 0) {
            cAn = 0;
        }
        if (this.jzZ.zp(cAn) != null && this.jzZ.zp(cAn) != PostData.kSr) {
            i = cAn + 1;
        }
        return this.jzZ.getItem(i) instanceof PostData ? (PostData) this.jzZ.getItem(i) : null;
    }

    public int cAn() {
        int i;
        View childAt;
        if (this.jzO == null) {
            return 0;
        }
        int firstVisiblePosition = this.jzO.getFirstVisiblePosition();
        int lastVisiblePosition = this.jzO.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.jzO.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.jzO.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cAo() {
        return this.jzO.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.jqZ != null && this.jqZ.cvt() != null && !this.jqZ.cvt().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.jqZ.cvt().size() && (postData = this.jqZ.cvt().get(i)) != null && postData.aKC() != null && !StringUtils.isNull(postData.aKC().getUserId()); i++) {
                if (this.jqZ.cvt().get(i).aKC().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.jBp != null && this.jBp.isActive()) {
                        rB(false);
                    }
                    if (this.jAS != null) {
                        this.jAS.rK(true);
                    }
                    this.jBx = postData.aKC().getName_show();
                    return;
                }
            }
        }
    }

    public an(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.jpW = null;
        this.aWR = null;
        this.aWc = null;
        this.jzO = null;
        this.jzZ = null;
        this.heU = null;
        this.ecZ = null;
        this.haG = null;
        this.jqQ = null;
        this.jAx = null;
        this.hSo = null;
        this.jAI = null;
        this.jBj = 0;
        this.jBu = 0L;
        this.jBu = System.currentTimeMillis();
        this.jpW = pbFragment;
        this.haG = onClickListener;
        this.dRm = cVar;
        this.jBj = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jpW.getContext()) / 2;
        this.aWR = (RelativeLayout) LayoutInflater.from(this.jpW.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.aWR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.jAu = this.aWR.findViewById(R.id.bottom_shadow);
        this.hyN = (NavigationBarCoverTip) this.aWR.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.aWc = this.aWR.findViewById(R.id.statebar_view);
        this.jzY = (ObservedChangeRelativeLayout) this.aWR.findViewById(R.id.title_wrapper);
        this.gAM = (NoNetworkView) this.aWR.findViewById(R.id.view_no_network);
        this.jzO = (PbLandscapeListView) this.aWR.findViewById(R.id.new_pb_list);
        this.jAK = (FrameLayout) this.aWR.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.jpW.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.jpW.getActivity(), R.dimen.ds88));
        this.jzO.addHeaderView(this.textView, 0);
        this.jzO.setTextViewAdded(true);
        this.jBa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aXA = new View(this.jpW.getPageContext().getPageActivity());
        this.aXA.setLayoutParams(new AbsListView.LayoutParams(-1, this.jBa));
        this.aXA.setVisibility(4);
        this.jzO.addFooterView(this.aXA);
        this.jzO.setOnTouchListener(this.jpW.dSb);
        this.jzK = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.aWR);
        if (this.jpW.cxR()) {
            this.jzM = (ViewStub) this.aWR.findViewById(R.id.manga_view_stub);
            this.jzM.setVisibility(0);
            this.jzL = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.jzL.show();
            this.jzK.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.jpW.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.jzK.cBY().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0628a() { // from class: com.baidu.tieba.pb.pb.main.an.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0628a
            public void cwk() {
                if (an.this.jzO != null) {
                    if (an.this.jzQ != null) {
                        an.this.jzQ.cBJ();
                    }
                    an.this.jzO.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0628a
            public void cwl() {
                an.this.jpW.bOS();
            }
        }));
        this.jAw = this.aWR.findViewById(R.id.view_comment_top_line);
        this.jAx = this.aWR.findViewById(R.id.pb_editor_tool_comment);
        this.jAE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jAF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hSo = (TextView) this.aWR.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.jpW.cxy();
                if (an.this.jpW != null && an.this.jpW.cwA() != null && an.this.jpW.cwA().getPbData() != null && an.this.jpW.cwA().getPbData().cvr() != null && an.this.jpW.cwA().getPbData().cvr().aKC() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cI("tid", an.this.jpW.cwA().jvW).cI("fid", an.this.jpW.cwA().getPbData().getForumId()).af("obj_locate", 1).cI("uid", an.this.jpW.cwA().getPbData().cvr().aKC().getUserId()));
                }
            }
        });
        this.jAy = (ImageView) this.aWR.findViewById(R.id.pb_editor_tool_comment_icon);
        this.jAy.setOnClickListener(this.haG);
        boolean booleanExtra = this.jpW.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.jAz = (ImageView) this.aWR.findViewById(R.id.pb_editor_tool_collection);
        this.jAz.setOnClickListener(this.haG);
        if (booleanExtra) {
            this.jAz.setVisibility(8);
        } else {
            this.jAz.setVisibility(0);
        }
        this.jAA = (ImageView) this.aWR.findViewById(R.id.pb_editor_tool_share);
        this.jAA.setOnClickListener(this.haG);
        this.jAB = new com.baidu.tieba.pb.view.c(this.jAA);
        this.jAB.cFg();
        this.jAC = (TextView) this.aWR.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.jAI = (ViewStub) this.aWR.findViewById(R.id.interview_status_stub);
        this.jzR = new com.baidu.tieba.pb.pb.main.a.a(this.jpW, cVar);
        this.jzT = new com.baidu.tieba.pb.pb.main.a.d(this.jpW, cVar, this.haG);
        this.jzZ = new f(this.jpW, this.jzO);
        this.jzZ.E(this.haG);
        this.jzZ.setTbGestureDetector(this.dRm);
        this.jzZ.setOnImageClickListener(this.emX);
        this.jqQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.27
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
                            an.this.jpW.b(sparseArray);
                            return;
                        }
                        an.this.cI(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        an.this.jpW.b(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.jzZ.Q(this.jqQ);
        cAt();
        cAu();
        this.jzT.b(this.jzO);
        this.jzS.b(this.jzO);
        this.jzR.b(this.jzO);
        this.heU = new PbListView(this.jpW.getPageContext().getPageActivity());
        this.ecZ = this.heU.getView().findViewById(R.id.pb_more_view);
        if (this.ecZ != null) {
            this.ecZ.setOnClickListener(this.haG);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.ecZ, R.drawable.pb_foot_more_trans_selector);
        }
        this.heU.setLineVisible();
        this.heU.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.heU.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jAf = this.aWR.findViewById(R.id.viewstub_progress);
        this.jpW.registerListener(this.jBB);
        this.jsW = new PbFakeFloorModel(this.jpW.getPageContext());
        this.jBc = new s(this.jpW.getPageContext(), this.jsW, this.aWR);
        this.jBc.a(this.jpW.juy);
        this.jsW.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                an.this.jsW.q(postData);
                an.this.jzZ.notifyDataSetChanged();
                an.this.jBc.cxi();
                an.this.Zd.aVq();
                an.this.rB(false);
            }
        });
        if (this.jpW.cwA() != null && !StringUtils.isNull(this.jpW.cwA().czf())) {
            this.jpW.showToast(this.jpW.cwA().czf());
        }
        this.jAL = this.aWR.findViewById(R.id.pb_expand_blank_view);
        this.jAM = this.aWR.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jAM.getLayoutParams();
        if (this.jpW.cwA() != null && this.jpW.cwA().cyA()) {
            this.jAL.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.jAM.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = jAO;
            this.jAM.setLayoutParams(layoutParams2);
        }
        this.jAN = new aj(this.jpW.getPageContext(), this.aWR.findViewById(R.id.pb_reply_expand_view));
        this.jAN.jzl.setVisibility(8);
        this.jAN.R(this.haG);
        this.jpW.registerListener(this.mAccountChangedListener);
        this.jpW.registerListener(this.jBy);
        cAp();
        rv(false);
    }

    public void rs(boolean z) {
        this.jAu.setVisibility(z ? 0 : 8);
    }

    public void cao() {
        if (!this.jpW.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").af("obj_locate", 2).cI("fid", this.mForumId));
        } else if (this.jpW.cxA()) {
            com.baidu.tbadk.editortools.pb.e cxn = this.jpW.cxn();
            if (cxn != null && (cxn.aXA() || cxn.aXB())) {
                this.jpW.cxn().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Zd != null) {
                cAz();
            }
            if (this.Zd != null) {
                this.jAD = false;
                if (this.Zd.mD(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.jpW.getPageContext(), (View) this.Zd.mD(2).dWM, false, jBv);
                }
            }
            cBh();
        }
    }

    private void cAp() {
        this.jBp = new com.baidu.tieba.pb.pb.godreply.a(this.jpW, this, (ViewStub) this.aWR.findViewById(R.id.more_god_reply_popup));
        this.jBp.z(this.haG);
        this.jBp.Q(this.jqQ);
        this.jBp.setOnImageClickListener(this.emX);
        this.jBp.z(this.haG);
        this.jBp.setTbGestureDetector(this.dRm);
    }

    public com.baidu.tieba.pb.pb.godreply.a cAq() {
        return this.jBp;
    }

    public View cAr() {
        return this.jAL;
    }

    public void cAs() {
        if (this.jzO != null) {
            this.jzS.c(this.jzO);
            this.jzT.c(this.jzO);
            this.jzU.c(this.jzO);
            this.jzR.c(this.jzO);
        }
    }

    private void cAt() {
        if (this.jzU == null) {
            this.jzU = new com.baidu.tieba.pb.pb.main.a.b(this.jpW, this.haG);
        }
    }

    private void cAu() {
        if (this.jzS == null) {
            this.jzS = new com.baidu.tieba.pb.pb.main.a.c(this.jpW, this.dRm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAv() {
        if (this.jpW.cxR()) {
            this.jzN = (ViewStub) this.aWR.findViewById(R.id.manga_mention_controller_view_stub);
            this.jzN.setVisibility(0);
            if (this.jzV == null) {
                this.jzV = (LinearLayout) this.aWR.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.jpW.getPageContext(), this.jzV);
            }
            if (this.jzW == null) {
                this.jzW = (TextView) this.jzV.findViewById(R.id.manga_prev_btn);
            }
            if (this.jzX == null) {
                this.jzX = (TextView) this.jzV.findViewById(R.id.manga_next_btn);
            }
            this.jzW.setOnClickListener(this.haG);
            this.jzX.setOnClickListener(this.haG);
        }
    }

    private void cAw() {
        if (this.jpW.cxR()) {
            if (this.jpW.cxU() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jzW, R.color.cp_cont_e, 1);
            }
            if (this.jpW.cxV() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jzX, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cAx() {
        if (this.jzV == null) {
            cAv();
        }
        this.jzN.setVisibility(8);
        if (this.jBz != null && this.jBA != null) {
            this.jBz.removeCallbacks(this.jBA);
        }
    }

    public void cAy() {
        if (this.jBz != null) {
            if (this.jBA != null) {
                this.jBz.removeCallbacks(this.jBA);
            }
            this.jBA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.3
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.jzV == null) {
                        an.this.cAv();
                    }
                    an.this.jzN.setVisibility(0);
                }
            };
            this.jBz.postDelayed(this.jBA, 2000L);
        }
    }

    public void rt(boolean z) {
        this.jzK.rt(z);
        if (z && this.jAH) {
            this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jzO.setNextPage(this.heU);
            this.jzJ = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
        this.Zd.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Zd.getParent() == null) {
            this.aWR.addView(this.Zd, layoutParams);
        }
        this.Zd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Zd.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.an.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aRV() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aRV() == EmotionGroupType.USER_COLLECT) {
                        if (an.this.mPermissionJudgePolicy == null) {
                            an.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        an.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        an.this.mPermissionJudgePolicy.appendRequestPermission(an.this.jpW.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!an.this.mPermissionJudgePolicy.startRequestPermission(an.this.jpW.getBaseFragmentActivity())) {
                            an.this.jpW.cxn().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            an.this.jpW.cxn().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cAf();
        this.jpW.cxn().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.an.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (an.this.Zd != null && an.this.Zd.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (an.this.jBo == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, an.this.Zd.getId());
                            an.this.jBo = new com.baidu.tieba.pb.pb.main.emotion.c(an.this.jpW.getPageContext(), an.this.aWR, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(an.this.jBn)) {
                                an.this.jBo.setData(an.this.jBn);
                            }
                            an.this.jBo.b(an.this.Zd);
                        }
                        an.this.jBo.HV(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (an.this.jpW.jtF != null && an.this.jpW.jtF.cBw() != null) {
                    if (!an.this.jpW.jtF.cBw().deS()) {
                        an.this.jpW.jtF.rG(false);
                    }
                    an.this.jpW.jtF.cBw().uO(false);
                }
            }
        });
    }

    public void cAz() {
        if (this.jpW != null && this.Zd != null) {
            this.Zd.display();
            if (this.jpW.cxn() != null) {
                this.jpW.cxn().aXq();
            }
            cBh();
        }
    }

    public void ru(boolean z) {
        if (this.jzO != null && this.textView != null && this.aWc != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aWc.setVisibility(0);
                } else {
                    this.aWc.setVisibility(8);
                    this.jzO.removeHeaderView(this.textView);
                    this.jzO.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = jAO;
                    this.textView.setLayoutParams(layoutParams);
                }
                cAN();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + rD(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cAN();
            cBp();
        }
    }

    public f cAA() {
        return this.jzZ;
    }

    public void a(PbFragment.c cVar) {
        this.juD = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jpW.getContext());
        kVar.setTitleText(this.jpW.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.jAg.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            an.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (an.this.jBC != null) {
                                an.this.jBC.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            an.this.jpW.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.jpW.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.jpW.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cBo()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.jpW.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.jpW.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.jpW.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aI(arrayList);
        if (this.jAg == null) {
            this.jAg = new com.baidu.tbadk.core.dialog.i(this.jpW.getPageContext(), kVar);
        } else {
            this.jAg.a(kVar);
        }
        this.jAg.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.jBC = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.jpW != null && aVar != null) {
            if (this.hBK == null && this.jzR != null) {
                this.hBK = new com.baidu.tieba.NEGFeedBack.e(this.jpW.getPageContext(), this.jzR.cBG());
            }
            AntiData bNE = this.jpW.bNE();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bNE != null && bNE.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNE.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.hBK.setDefaultReasonArray(new String[]{this.jpW.getString(R.string.delete_thread_reason_1), this.jpW.getString(R.string.delete_thread_reason_2), this.jpW.getString(R.string.delete_thread_reason_3), this.jpW.getString(R.string.delete_thread_reason_4), this.jpW.getString(R.string.delete_thread_reason_5)});
            this.hBK.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.hBK.xD(str);
            this.hBK.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.an.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    an.this.jpW.a(aVar, jSONArray);
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
        sparseArray.put(jAV, Integer.valueOf(jAW));
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
        this.jAh = new com.baidu.tbadk.core.dialog.a(this.jpW.getActivity());
        if (StringUtils.isNull(str2)) {
            this.jAh.kd(i3);
        } else {
            this.jAh.setOnlyMessageShowCenter(false);
            this.jAh.ui(str2);
        }
        this.jAh.setYesButtonTag(sparseArray);
        this.jAh.a(R.string.dialog_ok, this.jpW);
        this.jAh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jAh.gE(true);
        this.jAh.b(this.jpW.getPageContext());
        if (z) {
            this.jAh.aMS();
        } else {
            a(this.jAh, i);
        }
    }

    public void aO(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.jAk == null) {
            this.jAk = LayoutInflater.from(this.jpW.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.jpW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jAk);
        if (this.jAj == null) {
            this.jAj = new Dialog(this.jpW.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jAj.setCanceledOnTouchOutside(true);
            this.jAj.setCancelable(true);
            this.jAs = (ScrollView) this.jAk.findViewById(R.id.good_scroll);
            this.jAj.setContentView(this.jAk);
            WindowManager.LayoutParams attributes = this.jAj.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.jAj.getWindow().setAttributes(attributes);
            this.grD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.jAo = (String) compoundButton.getTag();
                        if (an.this.grC != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : an.this.grC) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && an.this.jAo != null && !str.equals(an.this.jAo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.jAl = (LinearLayout) this.jAk.findViewById(R.id.good_class_group);
            this.jAn = (TextView) this.jAk.findViewById(R.id.dialog_button_cancel);
            this.jAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.jAj instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(an.this.jAj, an.this.jpW.getPageContext());
                    }
                }
            });
            this.jAm = (TextView) this.jAk.findViewById(R.id.dialog_button_ok);
            this.jAm.setOnClickListener(this.haG);
        }
        this.jAl.removeAllViews();
        this.grC = new ArrayList();
        CustomBlueCheckRadioButton es = es("0", this.jpW.getPageContext().getString(R.string.thread_good_class));
        this.grC.add(es);
        es.setChecked(true);
        this.jAl.addView(es);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aIX()) && adVar.aIY() > 0) {
                    CustomBlueCheckRadioButton es2 = es(String.valueOf(adVar.aIY()), adVar.aIX());
                    this.grC.add(es2);
                    View view = new View(this.jpW.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.jAl.addView(view);
                    this.jAl.addView(es2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.jAs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jpW.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jpW.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jpW.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.jAs.setLayoutParams(layoutParams2);
            this.jAs.removeAllViews();
            if (this.jAl != null && this.jAl.getParent() == null) {
                this.jAs.addView(this.jAl);
            }
        }
        com.baidu.adp.lib.f.g.a(this.jAj, this.jpW.getPageContext());
    }

    private CustomBlueCheckRadioButton es(String str, String str2) {
        Activity pageActivity = this.jpW.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.grD);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cAB() {
        this.jpW.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.jpW.hideProgressBar();
        if (z && z2) {
            this.jpW.showToast(this.jpW.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.jpW.showToast(str);
        }
    }

    public void chk() {
        this.jAf.setVisibility(0);
    }

    public void chj() {
        this.jAf.setVisibility(8);
    }

    public View cAC() {
        if (this.jAk != null) {
            return this.jAk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cAD() {
        return this.jAo;
    }

    public View getView() {
        return this.aWR;
    }

    public void cAE() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.jpW.getPageContext().getPageActivity(), this.jpW.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.jpW.hideProgressBar();
        if (z) {
            cAX();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cAY();
        } else {
            cAX();
        }
    }

    public void cAF() {
        this.heU.setLineVisible();
        this.heU.startLoadData();
    }

    public void cAG() {
        this.jpW.hideProgressBar();
        endLoadData();
        this.jzO.completePullRefreshPostDelayed(0L);
        cAS();
    }

    public void cAH() {
        this.jzO.completePullRefreshPostDelayed(0L);
        cAS();
    }

    private void rv(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.jzT.b(onLongClickListener);
        this.jzZ.setOnLongClickListener(onLongClickListener);
        if (this.jBp != null) {
            this.jBp.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.jtG != null) {
            this.jtG.dismiss();
            this.jtG = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jpW.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.jpW.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jpW.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jpW.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jpW.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aI(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.jAp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jAp = new com.baidu.tbadk.core.dialog.i(this.jpW.getPageContext(), kVar);
        this.jAp.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.jAp != null) {
            this.jAp.dismiss();
            this.jAp = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jpW.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.jqZ != null && this.jqZ.cvr() != null && !this.jqZ.cvr().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.jpW.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jpW.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aI(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.jAp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jAp = new com.baidu.tbadk.core.dialog.i(this.jpW.getPageContext(), kVar);
        this.jAp.showDialog();
    }

    public int cAI() {
        return zM(this.jzO.getFirstVisiblePosition());
    }

    private int zM(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.jzO.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.jzO.getAdapter() == null || !(this.jzO.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.jzO.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cAJ() {
        int lastVisiblePosition = this.jzO.getLastVisiblePosition();
        if (this.jzQ != null) {
            if (lastVisiblePosition == this.jzO.getCount() - 1) {
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
        if (this.jzO != null) {
            if (this.jzK == null || this.jzK.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.jzK.mNavigationBar.getFixedNavHeight();
                if (this.jpW.cxH() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.jAM != null && (layoutParams = (LinearLayout.LayoutParams) this.jAM.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.jAM.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.jzO.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.jzO.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.jzO.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.jAc.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.jzZ.a(eVar, false);
        this.jzZ.notifyDataSetChanged();
        cAS();
        if (this.jBp != null) {
            this.jBp.cww();
        }
        ArrayList<PostData> cvt = eVar.cvt();
        if (eVar.getPage().aJy() == 0 || cvt == null || cvt.size() < eVar.getPage().aJx()) {
            if (com.baidu.tbadk.core.util.v.getCount(cvt) == 0 || (com.baidu.tbadk.core.util.v.getCount(cvt) == 1 && cvt.get(0) != null && cvt.get(0).cWo() == 1)) {
                if (this.jAR == null || this.jAR.jBV == null || this.jAR.jBV.getView() == null) {
                    i = 0;
                } else {
                    i = this.jAR.jBV.getView().getTop() < 0 ? this.jAR.jBV.getView().getHeight() : this.jAR.jBV.getView().getBottom();
                }
                if (this.jpW.cyb()) {
                    this.heU.aj(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.heU.aj(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aJy() == 0) {
                    this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.heU.aQb();
            }
        }
        q(eVar);
    }

    public void p(com.baidu.tieba.pb.data.e eVar) {
        if (this.jzR != null) {
            this.jzR.e(eVar, this.jqI);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cvB() != null) {
            return eVar.cvB();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cvt())) {
            Iterator<PostData> it = eVar.cvt().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cWo() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cvy();
        }
        if (!o(postData)) {
            postData = a(eVar);
        }
        if (postData != null && postData.aKC() != null && postData.aKC().getUserTbVipInfoData() != null && postData.aKC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aKC().getGodUserData().setIntro(postData.aKC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean o(PostData postData) {
        if (postData == null || postData.aKC() == null) {
            return false;
        }
        MetaData aKC = postData.aKC();
        return (TextUtils.isEmpty(aKC.getUserId()) && TextUtils.isEmpty(aKC.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cvr() == null || eVar.cvr().aKC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aKC = eVar.cvr().aKC();
        String userId = aKC.getUserId();
        HashMap<String, MetaData> userMap = eVar.cvr().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aKC;
        }
        postData.Di(1);
        postData.setId(eVar.cvr().aKS());
        postData.setTitle(eVar.cvr().getTitle());
        postData.setTime(eVar.cvr().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.cvr() != null) {
            if (this.jpW.cwq()) {
                if (eVar.cvq() != null) {
                    this.mForumName = eVar.cvq().getForumName();
                    this.mForumId = eVar.cvq().getForumId();
                }
                if (this.mForumName == null && this.jpW.cwA() != null && this.jpW.cwA().cwr() != null) {
                    this.mForumName = this.jpW.cwA().cwr();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.jzT.setVisibility(8);
            if (eVar.aQe()) {
                this.jBg = true;
                this.jzK.rR(true);
                this.jzK.mNavigationBar.hideBottomLine();
                if (this.jzQ == null) {
                    this.jzQ = new com.baidu.tieba.pb.pb.main.a.e(this.jpW);
                }
                this.jzQ.a(eVar, b, this.jzO, this.jzT, this.jAK, this.jzK, this.mForumName, this.jBu);
                this.jzQ.S(this.jBE);
                cAN();
            } else {
                this.jBg = false;
                this.jzK.rR(this.jBg);
                if (this.jzQ != null) {
                    this.jzQ.c(this.jzO);
                }
            }
            if (this.jpW.cxq() != null) {
                this.jpW.cxq().rL(this.jBg);
            }
            if (b != null) {
                this.jAG = b;
                this.jzT.setVisibility(0);
                SparseArray<Object> cBI = this.jzT.cBI();
                cBI.put(R.id.tag_clip_board, b);
                cBI.put(R.id.tag_is_subpb, false);
                this.jzU.a(eVar, this.jzO);
                this.jzS.w(eVar);
                this.jzR.e(eVar, this.jqI);
                this.jzR.v(eVar);
                this.jzT.a(this.mSkinType, this.jqZ, b, this.jBE);
                if (this.jAN != null) {
                    if (eVar.cvP()) {
                        this.jAN.getView().setVisibility(8);
                    } else {
                        this.jAN.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.joA);
                        if (eVar.cvr() != null) {
                            jVar.joC = eVar.cvr().aKt();
                        }
                        jVar.isNew = !this.jqI;
                        jVar.sortType = eVar.jnA;
                        jVar.joE = eVar.cvQ();
                        jVar.joF = this.jpW.cyb();
                        this.jAN.a(jVar);
                    }
                }
                if (eVar != null && eVar.cvr() != null) {
                    ag(eVar.cvr().aKy() == 1, eVar.cvr().aKx() == 1);
                }
                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (an.this.jzZ != null && an.this.jzK != null && an.this.jzK.jFS != null && an.this.jqZ != null && an.this.jqZ.cvr() != null && !an.this.jqZ.cvr().aJp() && !an.this.cAR() && an.this.jqZ.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(an.this.jqZ.getForum().getName())) {
                            if (an.this.jzZ.cxe() == null || !an.this.jzZ.cxe().isShown()) {
                                an.this.jzK.jFS.setVisibility(0);
                                if (an.this.jpW != null && an.this.jpW.cwA() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.cI("tid", an.this.jpW.cwA().cyx());
                                    anVar.cI("fid", an.this.jpW.cwA().getForumId());
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
            cAK();
        } else {
            bIL();
        }
        this.jAR.jBV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jAR));
        a(this.jAR.jBV, false);
    }

    public void cAK() {
        if (this.jzK != null && !this.jBi) {
            this.jzK.cAK();
            this.jBi = true;
        }
    }

    public void bIL() {
        if (this.jzK != null) {
            this.jzK.cCg();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.jzT.a(postData, eVar);
    }

    public void cAL() {
        if (this.jzQ != null) {
            this.jzQ.d(this.jzO);
        }
    }

    public boolean cAM() {
        return this.aJb;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aK(bj bjVar) {
        if (bjVar == null || bjVar.aKC() == null) {
            return false;
        }
        PostData b = b(this.jqZ, false);
        String str = "";
        if (b != null && b.aKC() != null) {
            str = b.aKC().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.jzK.cCe();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.jzK.FF(dVar.forumName);
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
            final String str2 = dVar.jns;
            this.jpW.showNetRefreshView(this.aWR, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.aOV().b(an.this.jpW.getPageContext(), new String[]{str2});
                        an.this.jpW.finish();
                        return;
                    }
                    an.this.jpW.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable czQ;
        Parcelable czQ2;
        if (eVar != null && this.jzO != null) {
            this.jqZ = eVar;
            this.mType = i;
            if (eVar.cvr() != null) {
                this.jAT = eVar.cvr().aKj();
                if (eVar.cvr().getAnchorLevel() != 0) {
                    this.aJb = true;
                }
                this.jAr = aK(eVar.cvr());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            u(eVar);
            this.jAH = false;
            this.jqI = z;
            cAG();
            if (eVar.jnB != null && eVar.jnB.cvV()) {
                if (this.jzP == null) {
                    this.jzP = new PbThreadPostView(this.jpW.getContext());
                    this.jzO.addHeaderView(this.jzP, 1);
                    this.jzP.setData(eVar);
                    this.jzP.setChildOnClickLinstener(this.haG);
                }
            } else if (this.jzP != null && this.jzO != null) {
                this.jzO.removeHeaderView(this.jzP);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            r(eVar);
            if (this.jBs == null) {
                this.jBs = new aa(this.jpW.getPageContext(), this.hyN);
            }
            this.jBs.HL(eVar.cvw());
            if (this.jpW.cxR()) {
                if (this.jAd == null) {
                    this.jAd = new com.baidu.tieba.pb.view.d(this.jpW.getPageContext());
                    this.jAd.createView();
                    this.jAd.setListPullRefreshListener(this.dHh);
                }
                this.jzO.setPullRefresh(this.jAd);
                cAN();
                if (this.jAd != null) {
                    this.jAd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aJz() == 0 && z) {
                this.jzO.setPullRefresh(null);
            } else {
                if (this.jAd == null) {
                    this.jAd = new com.baidu.tieba.pb.view.d(this.jpW.getPageContext());
                    this.jAd.createView();
                    this.jAd.setListPullRefreshListener(this.dHh);
                }
                this.jzO.setPullRefresh(this.jAd);
                cAN();
                if (this.jAd != null) {
                    this.jAd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bzS();
            }
            cAS();
            this.jzZ.qH(this.jqI);
            this.jzZ.qI(false);
            this.jzZ.qM(i == 5);
            this.jzZ.qN(i == 6);
            this.jzZ.qO(z2 && this.jBD);
            this.jzZ.a(eVar, false);
            this.jzZ.notifyDataSetChanged();
            this.jzT.a(b(eVar, z), eVar.cvP());
            if (eVar.cvr() != null && eVar.cvr().aKn() != null && this.jzI != -1) {
                eVar.cvr().aKn().setIsLike(this.jzI);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.jzO.setNextPage(this.heU);
                this.jzJ = 2;
                bzS();
            } else {
                this.jAH = true;
                if (eVar.getPage().aJy() == 1) {
                    if (this.jAe == null) {
                        this.jAe = new com.baidu.tieba.pb.view.a(this.jpW, this.jpW);
                    }
                    this.jzO.setNextPage(this.jAe);
                } else {
                    this.jzO.setNextPage(this.heU);
                }
                this.jzJ = 3;
            }
            ArrayList<PostData> cvt = eVar.cvt();
            if (eVar.getPage().aJy() == 0 || cvt == null || cvt.size() < eVar.getPage().aJx()) {
                if (com.baidu.tbadk.core.util.v.getCount(cvt) == 0 || (com.baidu.tbadk.core.util.v.getCount(cvt) == 1 && cvt.get(0) != null && cvt.get(0).cWo() == 1)) {
                    if (this.jAR == null || this.jAR.jBV == null || this.jAR.jBV.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.jAR.jBV.getView().getTop() < 0 ? this.jAR.jBV.getView().getHeight() : this.jAR.jBV.getView().getBottom();
                    }
                    if (this.jpW.cyb()) {
                        this.heU.aj(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.heU.aj(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.jpW.cxq() != null && !this.jpW.cxq().cBS()) {
                        this.jpW.cxq().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aJy() == 0) {
                        this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.heU.aQb();
                }
                if (eVar.getPage().aJy() == 0 || cvt == null) {
                    cBc();
                }
            } else {
                if (z2) {
                    if (this.jBD) {
                        endLoadData();
                        if (eVar.getPage().aJy() != 0) {
                            this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.heU.setLineVisible();
                        this.heU.showLoading();
                    }
                } else {
                    this.heU.setLineVisible();
                    this.heU.showLoading();
                }
                this.heU.aQb();
            }
            switch (i) {
                case 2:
                    this.jzO.setSelection(i2 > 1 ? (((this.jzO.getData() == null && eVar.cvt() == null) ? 0 : (this.jzO.getData().size() - eVar.cvt().size()) + this.jzO.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (czQ2 = ah.czP().czQ()) != null && !(czQ2 instanceof RecyclerView.SavedState)) {
                        this.jzO.onRestoreInstanceState(czQ2);
                        if (com.baidu.tbadk.core.util.v.getCount(cvt) > 1 && eVar.getPage().aJy() > 0) {
                            this.heU.endLoadData();
                            this.heU.setText(this.jpW.getString(R.string.pb_load_more_without_point));
                            this.heU.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.jBD = false;
                    break;
                case 5:
                    this.jzO.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (czQ = ah.czP().czQ()) != null && !(czQ instanceof RecyclerView.SavedState)) {
                        this.jzO.onRestoreInstanceState(czQ);
                        break;
                    } else {
                        this.jzO.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.jzQ != null && this.jzQ.blE() != null) {
                            if (this.jpW.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.jzO.setSelectionFromTop((this.jzZ.cwZ() + this.jzO.getHeaderViewsCount()) - 1, this.jzQ.cBK() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.jpW.getPageContext().getPageActivity()));
                            } else {
                                this.jzO.setSelectionFromTop((this.jzZ.cwZ() + this.jzO.getHeaderViewsCount()) - 1, this.jzQ.cBK());
                            }
                        } else {
                            this.jzO.setSelection(this.jzZ.cwZ() + this.jzO.getHeaderViewsCount());
                        }
                    } else {
                        this.jzO.setSelection(i2 > 0 ? ((this.jzO.getData() == null && eVar.cvt() == null) ? 0 : (this.jzO.getData().size() - eVar.cvt().size()) + this.jzO.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.heU.endLoadData();
                    this.heU.setText(this.jpW.getString(R.string.pb_load_more_without_point));
                    this.heU.setLineGone();
                    break;
            }
            if (this.jAT == jAU && isHost()) {
                cBk();
            }
            if (this.jBe) {
                cAd();
                this.jBe = false;
                if (i3 == 0) {
                    rp(true);
                }
            }
            if (eVar.jnx == 1 || eVar.jny == 1) {
                if (this.jBk == null) {
                    this.jBk = new PbTopTipView(this.jpW.getContext());
                }
                if (eVar.jny == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.jpW.getStType())) {
                    this.jBk.setText(this.jpW.getString(R.string.pb_read_strategy_add_experience));
                    this.jBk.a(this.aWR, this.mSkinType);
                } else if (eVar.jnx == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.jpW.getStType())) {
                    this.jBk.setText(this.jpW.getString(R.string.pb_read_news_add_experience));
                    this.jBk.a(this.aWR, this.mSkinType);
                }
            }
            q(eVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvr() != null) {
            t(eVar);
            if (eVar.aGX()) {
                SvgManager.aOR().a(this.jAz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aOR().a(this.jAz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.jAC.setText(zO(eVar.cvr().aKt()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cvr()));
        }
    }

    private String zO(int i) {
        if (i == 0) {
            return this.jpW.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cAN() {
        if (this.jzQ != null) {
            this.jzQ.a(this.jzO, this.textView, this.mType);
        }
    }

    public void rx(boolean z) {
        this.jAq = z;
    }

    public void endLoadData() {
        if (this.heU != null) {
            this.heU.setLineGone();
            this.heU.endLoadData();
        }
        bzS();
    }

    public void bpT() {
        this.jzO.setVisibility(0);
    }

    public void cAO() {
        if (this.jzO != null) {
            this.jzO.setVisibility(8);
        }
        if (this.jzO != null) {
            this.jAK.setVisibility(8);
        }
        if (this.jzK != null && this.jzK.jFP != null) {
            this.jzK.jFP.setVisibility(8);
        }
    }

    public void cAP() {
        if (this.jzO != null) {
            this.jzO.setVisibility(0);
        }
        if (this.jAK != null) {
            this.jAK.setVisibility(0);
        }
        if (this.jzK != null && this.jzK.jFP != null) {
            this.jzK.jFP.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void r(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.jAG != null && this.jAG.aKC() != null && this.jzK != null) {
            this.jBh = !this.jBg;
            this.jzK.rN(this.jBh);
            if (this.jpW.cxq() != null) {
                this.jpW.cxq().rM(this.jBh);
            }
            cAQ();
            if (this.jpW != null && !this.jpW.cwq() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cvK())) {
                bf bfVar = eVar.cvK().get(0);
                if (bfVar != null) {
                    this.jzK.et(bfVar.getForumName(), bfVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.jzK.et(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            if (this.jBh) {
                this.jzT.a(eVar, this.jAG, this.jAr);
                if (this.jAM != null) {
                    this.jAM.setVisibility(8);
                }
                if (this.jBq == null) {
                    this.jBq = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.an.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (an.this.jpW != null && an.this.jpW.isAdded()) {
                                if (i < 0 && f > an.this.jBj) {
                                    an.this.cBj();
                                }
                                an.this.cAH();
                            }
                        }
                    };
                }
                this.jzO.setListViewDragListener(this.jBq);
                return;
            }
            if (this.jAM != null) {
                this.jAM.setVisibility(0);
            }
            this.jzT.a(eVar, this.jAG, this.jAr);
            this.jBq = null;
            this.jzO.setListViewDragListener(null);
        }
    }

    private void cAQ() {
        this.jzT.a(this.jqZ, this.jAG, this.jBh, this.jBg);
    }

    public boolean cAR() {
        return this.jqZ == null || this.jqZ.getForum() == null || "0".equals(this.jqZ.getForum().getId()) || "me0407".equals(this.jqZ.getForum().getName());
    }

    private boolean cAS() {
        return this.jzR.rI(this.jqI);
    }

    private boolean s(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cvr() == null) {
            return false;
        }
        if (eVar.cvr().aKz() == 1 || eVar.cvr().getThreadType() == 33) {
            return true;
        }
        return !(eVar.cvr().aKB() == null || eVar.cvr().aKB().aMJ() == 0) || eVar.cvr().aKx() == 1 || eVar.cvr().aKy() == 1 || eVar.cvr().aLn() || eVar.cvr().aLH() || eVar.cvr().aLA() || eVar.cvr().aKO() != null || !com.baidu.tbadk.core.util.aq.isEmpty(eVar.cvr().getCategory()) || eVar.cvr().aKF() || eVar.cvr().aKE();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.jzS != null) {
                if (eVar.cvr() != null && eVar.cvr().aKR() == 0 && !eVar.cvr().aJp() && !this.jBw) {
                    if (eVar.cvr() != null) {
                        bj cvr = eVar.cvr();
                        cvr.s(true, s(eVar));
                        cvr.jP(3);
                        cvr.tV("2");
                    }
                    if (eVar.cvr().aJr()) {
                        this.jzT.c(this.jzO);
                        this.jzS.c(this.jzO);
                        this.jzS.b(this.jzO);
                        this.jzT.b(this.jzO);
                        this.jzT.B(this.jqZ);
                        this.jzS.x(eVar);
                    } else {
                        this.jzT.B(this.jqZ);
                        this.jzS.z(eVar);
                    }
                } else if (eVar.cvr().aKR() == 1) {
                    if (eVar.cvr() != null) {
                        this.jzS.c(this.jzO);
                        this.jzT.B(this.jqZ);
                    }
                } else {
                    this.jzS.c(this.jzO);
                    this.jzT.B(this.jqZ);
                }
            }
            if (eVar.cvr() != null) {
                af(eVar.cvr().aKy() == 1, eVar.cvr().aKx() == 1);
            }
            this.jqI = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cAS();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.w wVar;
        StringBuilder sb = null;
        if (eVar != null && (b = b(eVar, z)) != null) {
            String userId = b.aKC().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cvD()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.aKC() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.aKC().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.aKC().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.aKC().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cvD()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cvK = eVar.cvK();
                if (com.baidu.tbadk.core.util.v.getCount(cvK) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cvK) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.dqn) != null && wVar.doh && !wVar.doi && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(this.jpW.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.jpW.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cAT() {
        return this.ecZ;
    }

    public boolean cAU() {
        if (this.aXA == null || this.aXA.getParent() == null || this.heU.isLoading()) {
            return false;
        }
        int bottom = this.aXA.getBottom();
        Rect rect = new Rect();
        this.aXA.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void HN(String str) {
        if (this.heU != null) {
            this.heU.setText(str);
        }
    }

    public void HO(String str) {
        if (this.heU != null) {
            int i = 0;
            if (this.jAR != null && this.jAR.jBV != null && this.jAR.jBV.getView() != null) {
                i = this.jAR.jBV.getView().getTop() < 0 ? this.jAR.jBV.getView().getHeight() : this.jAR.jBV.getView().getBottom();
            }
            this.heU.aj(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.jzO;
    }

    public int cAV() {
        return R.id.richText;
    }

    public TextView cwK() {
        return this.jzT.cwK();
    }

    public void d(BdListView.e eVar) {
        this.jzO.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.dHh = cVar;
        if (this.jAd != null) {
            this.jAd.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int aJw = apVar.aJw();
            int aJt = apVar.aJt();
            if (this.jAa != null) {
                this.jAa.aMS();
            } else {
                this.jAa = new com.baidu.tbadk.core.dialog.a(this.jpW.getPageContext().getPageActivity());
                this.jAb = LayoutInflater.from(this.jpW.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.jAa.aP(this.jAb);
                this.jAa.a(R.string.dialog_ok, bVar);
                this.jAa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.cAX();
                        aVar.dismiss();
                    }
                });
                this.jAa.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.jBb == null) {
                            an.this.jBb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.jpW.HidenSoftKeyPad((InputMethodManager) an.this.jpW.getBaseFragmentActivity().getSystemService("input_method"), an.this.aWR);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.lb().postDelayed(an.this.jBb, 150L);
                    }
                });
                this.jAa.b(this.jpW.getPageContext()).aMS();
            }
            this.jAc = (EditText) this.jAb.findViewById(R.id.input_page_number);
            this.jAc.setText("");
            TextView textView = (TextView) this.jAb.findViewById(R.id.current_page_number);
            if (aJw <= 0) {
                aJw = 1;
            }
            if (aJt <= 0) {
                aJt = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aJw), Integer.valueOf(aJt)));
            this.jpW.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.jAc, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jzO.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.jpW.showToast(str);
    }

    public boolean ry(boolean z) {
        if (this.Zd == null || !this.Zd.aWP()) {
            return false;
        }
        this.Zd.aVq();
        return true;
    }

    public void cAW() {
        if (this.jBF != null) {
            while (this.jBF.size() > 0) {
                TbImageView remove = this.jBF.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cAW();
        this.jzZ.zq(1);
        if (this.jzQ != null) {
            this.jzQ.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.jzZ.zq(2);
        if (this.jzQ != null) {
            this.jzQ.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.jpW.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.jpW.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.jAB != null) {
            this.jAB.onDestroy();
        }
        if (this.jBd != null) {
            this.jBd.destroy();
        }
        if (this.jBs != null) {
            this.jBs.onDestory();
        }
        if (this.jBk != null) {
            this.jBk.hide();
        }
        this.jpW.hideProgressBar();
        if (this.gAM != null && this.gVS != null) {
            this.gAM.b(this.gVS);
        }
        cAX();
        endLoadData();
        if (this.jBb != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jBb);
        }
        if (this.jAJ != null) {
            this.jAJ.clearStatus();
        }
        this.jBz = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.jzZ.zq(3);
        if (this.aWc != null) {
            this.aWc.setBackgroundDrawable(null);
        }
        if (this.jzQ != null) {
            this.jzQ.destroy();
        }
        if (this.jzZ != null) {
            this.jzZ.onDestroy();
        }
        this.jzO.setOnLayoutListener(null);
        if (this.jBo != null) {
            this.jBo.bRh();
        }
        if (this.jAS != null) {
            this.jAS.onDestroy();
        }
        if (this.jzT != null) {
            this.jzT.onDestroy();
        }
    }

    public boolean zP(int i) {
        if (this.jzQ != null) {
            return this.jzQ.zP(i);
        }
        return false;
    }

    public void cAX() {
        this.jzK.aAi();
        if (this.jzT != null) {
            this.jzT.cAX();
        }
        if (this.jpW != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.jpW.getContext(), this.jAc);
        }
        cAf();
        if (this.jtG != null) {
            this.jtG.dismiss();
        }
        cAZ();
        if (this.jAa != null) {
            this.jAa.dismiss();
        }
        if (this.haF != null) {
            this.haF.dismiss();
        }
    }

    public void cAY() {
        this.jzK.aAi();
        if (this.jzT != null) {
            this.jzT.cAX();
        }
        if (this.jtG != null) {
            this.jtG.dismiss();
        }
        cAZ();
        if (this.jAa != null) {
            this.jAa.dismiss();
        }
        if (this.haF != null) {
            this.haF.dismiss();
        }
    }

    public void dS(List<String> list) {
        this.jBn = list;
        if (this.jBo != null) {
            this.jBo.setData(list);
        }
    }

    public void qG(boolean z) {
        this.jzZ.qG(z);
    }

    public void rz(boolean z) {
        this.jAt = z;
    }

    public void cAZ() {
        if (this.jAh != null) {
            this.jAh.dismiss();
        }
        if (this.jAi != null) {
            com.baidu.adp.lib.f.g.b(this.jAi, this.jpW.getPageContext());
        }
        if (this.jAj != null) {
            com.baidu.adp.lib.f.g.b(this.jAj, this.jpW.getPageContext());
        }
        if (this.jAg != null) {
            this.jAg.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.jqZ, this.jqI);
            b(this.jqZ, this.jqI, this.mType, i);
            this.jpW.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.jpW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.aWR);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.aWR, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.jAu, R.drawable.personalize_tab_shadow);
            if (this.jzQ != null) {
                this.jzQ.onChangeSkinType(i);
            }
            if (this.jzU != null) {
                this.jzU.onChangeSkinType(i);
            }
            if (this.jzR != null) {
                this.jzR.onChangeSkinType(i);
            }
            if (this.jzS != null) {
                this.jzS.onChangeSkinType(i);
            }
            if (this.jzT != null) {
                this.jzT.onChangeSkinType(i);
            }
            if (this.heU != null) {
                this.heU.changeSkin(i);
                if (this.ecZ != null) {
                    this.jpW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.ecZ);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.ecZ, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.jAa != null) {
                this.jAa.c(this.jpW.getPageContext());
            }
            rx(this.jAq);
            this.jzZ.notifyDataSetChanged();
            if (this.jAd != null) {
                this.jAd.changeSkin(i);
            }
            if (this.Zd != null) {
                this.Zd.onChangeSkinType(i);
            }
            if (this.jAe != null) {
                this.jAe.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.grC)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.grC) {
                    customBlueCheckRadioButton.aPO();
                }
            }
            cAw();
            UtilHelper.setStatusBarBackground(this.aWc, i);
            UtilHelper.setStatusBarBackground(this.jAM, i);
            if (this.jzV != null) {
                com.baidu.tbadk.q.a.a(this.jpW.getPageContext(), this.jzV);
            }
            if (this.jBc != null) {
                this.jBc.onChangeSkinType(i);
            }
            if (this.jzK != null) {
                if (this.jzQ != null) {
                    this.jzQ.zQ(i);
                } else {
                    this.jzK.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.hSo != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hSo, (int) R.color.cp_cont_d);
                this.hSo.setBackgroundDrawable(com.baidu.tbadk.core.util.am.aB(com.baidu.adp.lib.util.l.getDimens(this.jpW.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.jAz != null && this.jqZ != null) {
                if (this.jqZ.aGX()) {
                    SvgManager.aOR().a(this.jAz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aOR().a(this.jAz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            t(this.jqZ);
            if (this.jAy != null) {
                SvgManager.aOR().a(this.jAy, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jAw != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jAw, R.drawable.bottom_shadow);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jAC, (int) R.color.cp_cont_b);
            if (this.jBp != null) {
                this.jBp.onChangeSkinType(i);
            }
            if (this.jAS != null) {
                this.jAS.onChangeSkinType();
            }
            if (this.jBm != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jBm, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jAx, R.color.cp_bg_line_h);
            if (this.jzP != null) {
                this.jzP.pH(i);
            }
        }
    }

    public void cBa() {
        if (this.jAB != null) {
            this.jAB.setEnable(false);
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.ba(eVar.cvr())) {
            if (this.jAB != null) {
                this.jAB.setEnable(false);
                this.jAB.onDestroy();
            }
            SvgManager.aOR().a(this.jAA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.jAB == null || !this.jAB.isEnable()) {
            SvgManager.aOR().a(this.jAA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emX = iVar;
        this.jzZ.setOnImageClickListener(this.emX);
        this.jBp.setOnImageClickListener(this.emX);
    }

    public void g(NoNetworkView.a aVar) {
        this.gVS = aVar;
        if (this.gAM != null) {
            this.gAM.a(this.gVS);
        }
    }

    public void rA(boolean z) {
        this.jzZ.setIsFromCDN(z);
    }

    public Button cBb() {
        return this.jAv;
    }

    public void cBc() {
        if (this.jzJ != 2) {
            this.jzO.setNextPage(this.heU);
            this.jzJ = 2;
        }
    }

    public void cBd() {
        if (com.baidu.tbadk.n.m.aZy().aZz()) {
            int lastVisiblePosition = this.jzO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.jzO.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.edI = true;
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
                        perfLog2.edI = true;
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

    public boolean cBe() {
        return this.Zd != null && this.Zd.getVisibility() == 0;
    }

    public boolean cBf() {
        return this.Zd != null && this.Zd.aWP();
    }

    public void cBg() {
        if (this.Zd != null) {
            this.Zd.aVq();
        }
    }

    public void rB(boolean z) {
        if (this.jAx != null) {
            rz(this.jpW.cxn().aXt());
            if (this.jAt) {
                rq(z);
            } else {
                rr(z);
            }
        }
    }

    public void cBh() {
        if (this.jAx != null) {
            this.jAw.setVisibility(8);
            this.jAx.setVisibility(8);
            this.jAD = false;
            if (this.jAS != null) {
                this.jAS.setVisibility(8);
                rv(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.gvE == null) {
            this.gvE = new com.baidu.tbadk.core.view.a(this.jpW.getPageContext());
        }
        this.gvE.setDialogVisiable(true);
    }

    public void bzS() {
        if (this.gvE != null) {
            this.gvE.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.jzO.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.jzO.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.jzQ != null) {
            this.jzQ.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.jBG = getScrollY();
            this.jAR.jBV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jAR));
            a(this.jAR.jBV, true);
        }
    }

    public void rC(boolean z) {
        if (this.jzQ != null) {
            this.jzQ.rC(z);
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
        if (this.jzQ != null) {
            this.jzQ.onScroll(absListView, i, i2, i3);
        }
        if (this.jzK != null && this.jzZ != null) {
            this.jzK.cK(this.jzZ.cxe());
        }
        this.jAR.jiR = i;
        this.jAR.headerCount = this.jzO.getHeaderViewsCount();
        this.jAR.jBV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jAR));
        rs(b(absListView, i));
        a(this.jAR.jBV, false);
        if (this.heU.aQc() && !this.heU.dGB) {
            if (this.jAR != null && this.jAR.jBV != null && this.jAR.jBV.getView() != null) {
                i4 = this.jAR.jBV.getView().getTop() < 0 ? this.jAR.jBV.getView().getHeight() : this.jAR.jBV.getView().getBottom();
            }
            this.heU.lv(i4);
            this.heU.dGB = true;
        }
    }

    public void cBi() {
        if (TbadkCoreApplication.isLogin() && this.jqZ != null && this.jBh && !this.jBg && !this.jAr && this.jAG != null && this.jAG.aKC() != null && !this.jAG.aKC().getIsLike() && !this.jAG.aKC().hadConcerned() && this.jBd == null) {
            this.jBd = new ak(this.jpW);
        }
    }

    public void cBj() {
        if (this.jBh && !this.jBg && this.jAG != null && this.jAG.aKC() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").af("obj_locate", this.jpW.cwq() ? 2 : 1).af("obj_type", this.jBg ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.jpW.getPageContext().getPageActivity(), this.jAG.aKC().getUserId(), this.jAG.aKC().getUserName(), this.jpW.cwA().cwr(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aj ajVar, boolean z) {
        int measuredHeight;
        if (!this.jBg && this.jAL != null && this.jzK.cBY() != null) {
            int cxa = this.jzZ.cxa();
            if (cxa > 0 && (ajVar == null || ajVar.getView().getParent() == null)) {
                if (cxa > this.jzO.getFirstVisiblePosition() - this.jzO.getHeaderViewsCount()) {
                    this.jAL.setVisibility(8);
                    return;
                }
                this.jAL.setVisibility(0);
                rs(false);
                this.jzK.mNavigationBar.hideBottomLine();
                if (this.jAL.getParent() != null && ((ViewGroup) this.jAL.getParent()).getHeight() <= this.jAL.getTop()) {
                    this.jAL.getParent().requestLayout();
                }
            } else if (ajVar == null || ajVar.getView() == null || ajVar.jzl == null) {
                if (this.jzO.getFirstVisiblePosition() == 0) {
                    this.jAL.setVisibility(8);
                    this.jzK.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = ajVar.getView().getTop();
                if (ajVar.getView().getParent() != null) {
                    if (this.jAQ) {
                        this.jAP = top2;
                        this.jAQ = false;
                    }
                    this.jAP = top2 < this.jAP ? top2 : this.jAP;
                }
                if (top2 != 0 || ajVar.getView().isShown()) {
                    if (this.jzY.getY() < 0.0f) {
                        measuredHeight = jAO - ajVar.jzl.getMeasuredHeight();
                    } else {
                        measuredHeight = this.jzK.cBY().getMeasuredHeight() - ajVar.jzl.getMeasuredHeight();
                        this.jzK.mNavigationBar.hideBottomLine();
                    }
                    if (ajVar.getView().getParent() == null && top2 <= this.jAP) {
                        this.jAL.setVisibility(0);
                        rs(false);
                    } else if (top2 < measuredHeight) {
                        this.jAL.setVisibility(0);
                        rs(false);
                    } else {
                        this.jAL.setVisibility(8);
                        this.jzK.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.jAQ = true;
                    }
                }
            }
        }
    }

    public void cBk() {
        if (!this.jBH) {
            TiebaStatic.log("c10490");
            this.jBH = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jpW.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(jAV, Integer.valueOf(jAX));
            aVar.kc(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.jpW.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aP(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.jpW);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jpW.getPageContext()).aMS();
        }
    }

    public void HP(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jpW.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.jpW.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aP(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(jAV, Integer.valueOf(jAY));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.jpW);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jpW.getPageContext()).aMS();
    }

    public void a(int i, com.baidu.tieba.pb.data.e eVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(eVar, z)) != null && b.aKC() != null) {
            MetaData aKC = b.aKC();
            aKC.setGiftNum(aKC.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        a(eVar, z, i, i2);
        r(eVar);
    }

    public PbInterviewStatusView cBl() {
        return this.jAJ;
    }

    private void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvr() != null && eVar.cvr().aLH() && this.jAJ == null) {
            this.jAJ = (PbInterviewStatusView) this.jAI.inflate();
            this.jAJ.setOnClickListener(this.haG);
            this.jAJ.setCallback(this.jpW.cxZ());
            this.jAJ.setData(this.jpW, eVar);
        }
    }

    public RelativeLayout cBm() {
        return this.jzY;
    }

    public View cBn() {
        return this.aWc;
    }

    public boolean cBo() {
        return this.jBw;
    }

    public void qL(boolean z) {
        this.jzT.qL(z);
    }

    public void HQ(String str) {
        if (this.jzL != null) {
            this.jzL.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int rD(boolean z) {
        if (this.jAJ == null || this.jAJ.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cBp() {
        if (this.jAJ != null && this.jAJ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jAJ.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.jAJ.setLayoutParams(layoutParams);
        }
    }

    public boolean cxt() {
        return false;
    }

    public void HR(String str) {
        this.hSo.performClick();
        if (!StringUtils.isNull(str) && this.jpW.cxn() != null && this.jpW.cxn().aXm() != null && this.jpW.cxn().aXm().getInputView() != null) {
            EditText inputView = this.jpW.cxn().aXm().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cAX();
            if (configuration.orientation == 2) {
                cBh();
                cAf();
            } else {
                cAj();
            }
            if (this.jBc != null) {
                this.jBc.cxi();
            }
            this.jpW.bOS();
            this.jzY.setVisibility(8);
            this.jzK.rO(false);
            this.jpW.qZ(false);
            if (this.jzQ != null) {
                if (configuration.orientation == 1) {
                    cBm().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.jzO.setIsLandscape(true);
                    this.jzO.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.jzO.setIsLandscape(false);
                    if (this.jBG > 0) {
                        this.jzO.smoothScrollBy(this.jBG, 0);
                    }
                }
                this.jzQ.onConfigurationChanged(configuration);
                this.jAK.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void rE(boolean z) {
        if (this.jzQ != null) {
            this.jzQ.rE(z);
        }
    }

    public boolean cBq() {
        return this.jzQ != null && this.jzQ.cBq();
    }

    public void cBr() {
        if (this.jzQ != null) {
            this.jzQ.cBr();
        }
    }

    public void qP(boolean z) {
        this.jzZ.qP(z);
    }

    public void cJ(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.jAx.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.jpW.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.jBm = new TextView(this.jpW.getContext());
            this.jBm.setText(R.string.connection_tips);
            this.jBm.setGravity(17);
            this.jBm.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jpW.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.jpW.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.jpW.getContext(), R.dimen.ds60);
            if (this.jBm.getParent() == null) {
                frameLayout.addView(this.jBm, layoutParams);
            }
            this.jBl = new PopupWindow(this.jpW.getContext());
            this.jBl.setContentView(frameLayout);
            this.jBl.setHeight(-2);
            this.jBl.setWidth(-2);
            this.jBl.setFocusable(true);
            this.jBl.setOutsideTouchable(false);
            this.jBl.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.jzO.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        an.this.jBl.showAsDropDown(an.this.jAx, view.getLeft(), -an.this.jAx.getHeight());
                    } else {
                        an.this.jBl.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void rF(boolean z) {
        this.jBr = z;
    }

    public boolean cBs() {
        return this.jBr;
    }

    public PbThreadPostView cBt() {
        return this.jzP;
    }

    private void af(boolean z, boolean z2) {
        ag(z, z2);
        if (this.jqZ != null && this.jqZ.cvr() != null && this.jqZ.cvr().aKR() == 0 && !this.jqZ.cvr().aJp()) {
            ah(z, z2);
        } else if (this.jzZ != null && this.jzZ.cxf() != null) {
            this.jzZ.cxf().b(this.jqZ, z, z2);
        }
    }

    private void ag(boolean z, boolean z2) {
        this.jzT.d(this.jqZ, z, z2);
    }

    private void ah(boolean z, boolean z2) {
        this.jzS.c(this.jqZ, z, z2);
    }
}
