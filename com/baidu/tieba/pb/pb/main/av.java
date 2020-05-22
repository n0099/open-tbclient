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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
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
public class av {
    private EditorTools Zt;
    private View bdq;
    private View beU;
    private RelativeLayout bej;
    private f.c dVt;
    private com.baidu.tieba.pb.a.c efF;
    private View erl;
    private NoNetworkView fan;
    private List<CustomBlueCheckRadioButton> gGr;
    private NavigationBarCoverTip hNA;
    private com.baidu.tieba.NEGFeedBack.e hQx;
    private View.OnClickListener hpu;
    private PbListView htI;
    private TextView igY;
    private boolean isLandscape;
    private PbFragment jGF;
    private View.OnClickListener jHE;
    private com.baidu.tieba.pb.data.e jHO;
    private PbFakeFloorModel jJT;
    PbFragment.c jLC;
    private View jRN;
    private View jRP;
    private View jRQ;
    private LinearLayout jRR;
    private HeadImageView jRS;
    private ImageView jRT;
    private ImageView jRU;
    private ImageView jRV;
    private com.baidu.tieba.pb.view.c jRW;
    private TextView jRX;
    private TextView jRY;
    public int jRb;
    public final com.baidu.tieba.pb.pb.main.view.c jRd;
    public com.baidu.tieba.pb.pb.main.view.b jRe;
    private ViewStub jRf;
    private ViewStub jRg;
    private PbLandscapeListView jRh;
    private PbThreadPostView jRi;
    private com.baidu.tieba.pb.pb.main.a.e jRj;
    private com.baidu.tieba.pb.pb.main.a.a jRk;
    private com.baidu.tieba.pb.pb.main.a.c jRl;
    private com.baidu.tieba.pb.pb.main.a.d jRm;
    private com.baidu.tieba.pb.pb.main.a.b jRn;
    private LinearLayout jRo;
    private TextView jRp;
    private TextView jRq;
    private ObservedChangeRelativeLayout jRr;
    private g jRs;
    private View jRy;
    private int jSF;
    private PbTopTipView jSG;
    private PopupWindow jSH;
    private TextView jSI;
    private List<String> jSJ;
    private com.baidu.tieba.pb.pb.main.emotion.c jSK;
    private com.baidu.tieba.pb.pb.godreply.a jSL;
    private PbLandscapeListView.b jSM;
    private ah jSO;
    private String jSP;
    private long jSQ;
    private boolean jSS;
    private Runnable jSW;
    private PbFragment.b jSY;
    private int jSa;
    private int jSb;
    private PostData jSc;
    private ViewStub jSe;
    private PbInterviewStatusView jSf;
    private FrameLayout jSg;
    private View jSh;
    private View jSi;
    private aq jSj;
    private PbEmotionBar jSo;
    private int jSw;
    private Runnable jSx;
    private t jSy;
    private ar jSz;
    public int jTc;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int jSk = UtilHelper.getLightStatusBarHeight();
    public static int jSq = 3;
    public static int jSr = 0;
    public static int jSs = 3;
    public static int jSt = 4;
    public static int jSu = 5;
    public static int jSv = 6;
    private static a.InterfaceC0726a jSR = new a.InterfaceC0726a() { // from class: com.baidu.tieba.pb.pb.main.av.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0726a
        public void onRefresh() {
        }
    };
    private int jRc = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a jRt = null;
    private com.baidu.tbadk.core.dialog.b hpt = null;
    private View jRu = null;
    private EditText jRv = null;
    private com.baidu.tieba.pb.view.d jRw = null;
    private com.baidu.tieba.pb.view.a jRx = null;
    private b.a iDI = null;
    private TbRichTextView.i eBC = null;
    private NoNetworkView.a hkE = null;
    private com.baidu.tbadk.core.dialog.i jRz = null;
    private com.baidu.tbadk.core.dialog.a jRA = null;
    private Dialog jRB = null;
    private Dialog jRC = null;
    private View jRD = null;
    private LinearLayout jRE = null;
    private CompoundButton.OnCheckedChangeListener gGs = null;
    private TextView jRF = null;
    private TextView jRG = null;
    private String jRH = null;
    private com.baidu.tbadk.core.dialog.i jKE = null;
    private com.baidu.tbadk.core.dialog.i jRI = null;
    private boolean jRJ = false;
    private boolean jRK = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView jRL = null;
    private boolean jRM = false;
    private Button jRO = null;
    private boolean jRZ = true;
    private com.baidu.tbadk.core.view.a gKp = null;
    private boolean jHw = false;
    private int mSkinType = 3;
    private boolean jSd = false;
    private int jSl = 0;
    private boolean jSm = true;
    public a jSn = new a();
    private int jSp = 0;
    private boolean jSA = false;
    private int jSB = 0;
    private boolean jSC = false;
    private boolean jSD = false;
    private boolean jSE = false;
    private boolean jSN = false;
    private String jST = null;
    private CustomMessageListener jSU = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.av.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                av.this.jST = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.av.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && av.this.jRs != null) {
                av.this.jRs.notifyDataSetChanged();
            }
        }
    };
    private Handler jSV = new Handler();
    private CustomMessageListener jSX = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.av.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                av.this.jRZ = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean jSZ = true;
    View.OnClickListener jTa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || av.this.jHO == null || av.this.jHO.cCi() == null || av.this.jHO.cCi().aQx() == null || av.this.jHO.cCi().aQx().getAlaInfo() == null || av.this.jHO.cCi().aQx().getAlaInfo().live_status != 1) {
                if (av.this.jSC) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").ag("obj_id", 2));
                }
                if (!av.this.jSC && av.this.jHO != null && av.this.jHO.cCi() != null && av.this.jHO.cCi().aQx() != null && av.this.jHO.cCi().aQx().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").ag("obj_locate", 1));
                }
                if (av.this.jGF.cFc() != null) {
                    av.this.jGF.cFc().jGR.gWJ.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            if (av.this.jHO.cCi().aQx().getAlaInfo() == null || !av.this.jHO.cCi().aQx().getAlaInfo().isChushou) {
                if (av.this.jHO.cCi().aQx().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = av.this.jHO.cCi().aQx().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(av.this.jGF.cFc(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ba.aUZ().b(av.this.jGF.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + av.this.jHO.cCi().aQx().getAlaInfo().thirdRoomId + "&livetype=" + av.this.jHO.cCi().aQx().getAlaInfo().thirdLiveType});
        }
    };
    private boolean aOK = false;
    String userId = null;
    private final List<TbImageView> jTb = new ArrayList();
    private boolean jTd = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public aq jTr;
        public int jxT;
    }

    public void rO(boolean z) {
        this.jSA = z;
        if (this.jRh != null) {
            this.jSB = this.jRh.getHeaderViewsCount();
        }
    }

    public void cHa() {
        if (this.jRh != null) {
            int headerViewsCount = this.jRh.getHeaderViewsCount() - this.jSB;
            final int firstVisiblePosition = (this.jRh.getFirstVisiblePosition() == 0 || this.jRh.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.jRh.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.jRh.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.jSn.jTr = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jSn));
            final aq aqVar = this.jSn.jTr;
            final int g = g(aqVar);
            final int y = ((int) this.jRr.getY()) + this.jRr.getMeasuredHeight();
            final boolean z = this.jSh.getVisibility() == 0;
            boolean z2 = this.jRr.getY() < 0.0f;
            if ((z && aqVar != null) || firstVisiblePosition >= this.jRs.cDW() + this.jRh.getHeaderViewsCount()) {
                int measuredHeight = aqVar != null ? aqVar.jQB.getMeasuredHeight() : 0;
                if (z2) {
                    this.jRh.setSelectionFromTop(this.jRs.cDW() + this.jRh.getHeaderViewsCount(), jSk - measuredHeight);
                } else {
                    this.jRh.setSelectionFromTop(this.jRs.cDW() + this.jRh.getHeaderViewsCount(), this.jRd.cIW().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.jRh.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.jSC && this.jRj != null) {
                this.jRh.setSelectionFromTop(this.jRs.cDW() + this.jRh.getHeaderViewsCount(), this.jRj.cII());
            } else if (this.mType == 6) {
                this.jRh.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.av.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cFn() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= av.this.bej.getMeasuredHeight()) {
                            int g2 = av.this.g(aqVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (av.this.beU != null && (layoutParams = av.this.beU.getLayoutParams()) != null) {
                                if (i == 0 || i > av.this.bej.getMeasuredHeight() || g2 >= av.this.bej.getMeasuredHeight()) {
                                    layoutParams.height = av.this.jSw;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > av.this.bej.getMeasuredHeight()) {
                                    layoutParams.height = av.this.jSw;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    av.this.jRh.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                av.this.beU.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (av.this.beU != null && av.this.beU.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = av.this.beU.getLayoutParams();
                                            layoutParams2.height = av.this.jSw;
                                            av.this.beU.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        av.this.jRh.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(aq aqVar) {
        if (aqVar == null || aqVar.getView() == null) {
            return 0;
        }
        if (aqVar.getView().getTop() != 0 || aqVar.getView().isShown()) {
            return aqVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView cHb() {
        return this.fan;
    }

    public void cHc() {
        if (this.Zt != null) {
            this.Zt.hide();
            if (this.jSK != null) {
                this.jSK.cIK();
            }
        }
    }

    public PbFakeFloorModel cHd() {
        return this.jJT;
    }

    public t cHe() {
        return this.jSy;
    }

    public com.baidu.tieba.pb.pb.main.a.e cHf() {
        return this.jRj;
    }

    public void cHg() {
        reset();
        cHc();
        this.jSy.cEe();
        sa(false);
    }

    private void reset() {
        if (this.jGF != null && this.jGF.cEj() != null && this.Zt != null) {
            com.baidu.tbadk.editortools.pb.a.bds().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cEj = this.jGF.cEj();
            cEj.bdM();
            cEj.bdg();
            if (cEj.getWriteImagesInfo() != null) {
                cEj.getWriteImagesInfo().setMaxImagesAllowed(cEj.isBJH ? 1 : 9);
            }
            cEj.nl(SendView.ALL);
            cEj.nm(SendView.ALL);
            com.baidu.tbadk.editortools.g nc = this.Zt.nc(23);
            com.baidu.tbadk.editortools.g nc2 = this.Zt.nc(2);
            com.baidu.tbadk.editortools.g nc3 = this.Zt.nc(5);
            if (nc2 != null) {
                nc2.display();
            }
            if (nc3 != null) {
                nc3.display();
            }
            if (nc != null) {
                nc.hide();
            }
            this.Zt.invalidate();
        }
    }

    public boolean cHh() {
        return this.jRZ;
    }

    public void rP(boolean z) {
        if (this.jRQ != null && this.igY != null) {
            this.igY.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jRQ.startAnimation(alphaAnimation);
            }
            this.jRP.setVisibility(0);
            this.jRQ.setVisibility(0);
            this.jRZ = true;
            if (this.jSo != null && !this.jSL.isActive()) {
                this.jSo.setVisibility(0);
                rU(true);
            }
        }
    }

    public void rQ(boolean z) {
        if (this.jRQ != null && this.igY != null) {
            this.igY.setText(cHi());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jRQ.startAnimation(alphaAnimation);
            }
            this.jRP.setVisibility(0);
            this.jRQ.setVisibility(0);
            this.jRZ = true;
            if (this.jSo != null && !this.jSL.isActive()) {
                this.jSo.setVisibility(0);
                rU(true);
            }
        }
    }

    public String cHi() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.jSP)) {
            return this.jSP;
        }
        if (this.jGF != null) {
            this.jSP = TbadkCoreApplication.getInst().getResources().getString(au.cGX());
        }
        return this.jSP;
    }

    public PostData cHj() {
        int i = 0;
        if (this.jRh == null) {
            return null;
        }
        int cHk = cHk() - this.jRh.getHeaderViewsCount();
        if (cHk < 0) {
            cHk = 0;
        }
        if (this.jRs.zZ(cHk) != null && this.jRs.zZ(cHk) != PostData.lkI) {
            i = cHk + 1;
        }
        return this.jRs.getItem(i) instanceof PostData ? (PostData) this.jRs.getItem(i) : null;
    }

    public int cHk() {
        int i;
        View childAt;
        if (this.jRh == null) {
            return 0;
        }
        int firstVisiblePosition = this.jRh.getFirstVisiblePosition();
        int lastVisiblePosition = this.jRh.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.jRh.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.jRh.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cHl() {
        return this.jRh.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.jHO != null && this.jHO.cCk() != null && !this.jHO.cCk().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.jHO.cCk().size() && (postData = this.jHO.cCk().get(i)) != null && postData.aQx() != null && !StringUtils.isNull(postData.aQx().getUserId()); i++) {
                if (this.jHO.cCk().get(i).aQx().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.jSL != null && this.jSL.isActive()) {
                        sa(false);
                    }
                    if (this.jSo != null) {
                        this.jSo.sj(true);
                    }
                    this.jST = postData.aQx().getName_show();
                    return;
                }
            }
        }
    }

    public av(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.jGF = null;
        this.bej = null;
        this.bdq = null;
        this.jRh = null;
        this.jRs = null;
        this.htI = null;
        this.erl = null;
        this.hpu = null;
        this.jHE = null;
        this.jRQ = null;
        this.igY = null;
        this.jSe = null;
        this.jSF = 0;
        this.jSQ = 0L;
        this.jSQ = System.currentTimeMillis();
        this.jGF = pbFragment;
        this.hpu = onClickListener;
        this.efF = cVar;
        this.jSF = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jGF.getContext()) / 2;
        this.bej = (RelativeLayout) LayoutInflater.from(this.jGF.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bej.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.jRN = this.bej.findViewById(R.id.bottom_shadow);
        this.hNA = (NavigationBarCoverTip) this.bej.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bdq = this.bej.findViewById(R.id.statebar_view);
        this.jRr = (ObservedChangeRelativeLayout) this.bej.findViewById(R.id.title_wrapper);
        this.fan = (NoNetworkView) this.bej.findViewById(R.id.view_no_network);
        this.jRh = (PbLandscapeListView) this.bej.findViewById(R.id.new_pb_list);
        this.jSg = (FrameLayout) this.bej.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.jGF.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.jGF.getActivity(), R.dimen.ds88));
        this.jRh.addHeaderView(this.textView, 0);
        this.jRh.setTextViewAdded(true);
        this.jSw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.beU = new View(this.jGF.getPageContext().getPageActivity());
        this.beU.setLayoutParams(new AbsListView.LayoutParams(-1, this.jSw));
        this.beU.setVisibility(4);
        this.jRh.addFooterView(this.beU);
        this.jRh.setOnTouchListener(this.jGF.evw);
        this.jRd = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bej);
        if (this.jGF.cEM()) {
            this.jRf = (ViewStub) this.bej.findViewById(R.id.manga_view_stub);
            this.jRf.setVisibility(0);
            this.jRe = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.jRe.show();
            this.jRd.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.jGF.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.jRd.cIW().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.pb.pb.main.av.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0681a
            public void cDi() {
                if (av.this.jRh != null) {
                    if (av.this.jRj != null) {
                        av.this.jRj.cIH();
                    }
                    av.this.jRh.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0681a
            public void cDj() {
                av.this.jGF.bVo();
            }
        }));
        this.jRP = this.bej.findViewById(R.id.view_comment_top_line);
        this.jRQ = this.bej.findViewById(R.id.pb_editor_tool_comment);
        this.jSa = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jSb = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.jRS = (HeadImageView) this.bej.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.jRS.setVisibility(com.baidu.tbadk.a.d.aMt() ? 0 : 8);
        if (com.baidu.tbadk.a.d.aMt()) {
            this.jRS.setIsRound(true);
            this.jRS.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.jGF.getContext(), R.dimen.tbds1));
            this.jRS.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_border_a));
            this.jRS.setPlaceHolder(1);
            this.jRS.setDefaultResource(R.color.cp_bg_line_e);
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.jRS.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            }
        }
        this.igY = (TextView) this.bej.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.jRR = (LinearLayout) this.bej.findViewById(R.id.pb_editer_tool_comment_layout);
        this.jRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                av.this.jGF.cEu();
                if (av.this.jGF != null && av.this.jGF.cDy() != null && av.this.jGF.cDy().getPbData() != null && av.this.jGF.cDy().getPbData().cCi() != null && av.this.jGF.cDy().getPbData().cCi().aQx() != null) {
                    if (com.baidu.tbadk.a.d.aMt()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13701").dh("tid", av.this.jGF.cDy().cFu()).dh("fid", av.this.jGF.cDy().getPbData().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", av.this.jGF.cDy().jNm).dh("fid", av.this.jGF.cDy().getPbData().getForumId()).ag("obj_locate", 1).dh("uid", av.this.jGF.cDy().getPbData().cCi().aQx().getUserId()));
                }
            }
        });
        this.jRT = (ImageView) this.bej.findViewById(R.id.pb_editor_tool_comment_icon);
        this.jRT.setOnClickListener(this.hpu);
        boolean booleanExtra = this.jGF.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.jRU = (ImageView) this.bej.findViewById(R.id.pb_editor_tool_collection);
        this.jRU.setOnClickListener(this.hpu);
        if (booleanExtra) {
            this.jRU.setVisibility(8);
        } else {
            this.jRU.setVisibility(0);
        }
        this.jRV = (ImageView) this.bej.findViewById(R.id.pb_editor_tool_share);
        this.jRV.setOnClickListener(this.hpu);
        this.jRW = new com.baidu.tieba.pb.view.c(this.jRV);
        this.jRW.cMf();
        if (com.baidu.tbadk.a.d.aMt()) {
            this.jRX = (TextView) this.bej.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.jRX.setVisibility(0);
        } else {
            this.jRY = (TextView) this.bej.findViewById(R.id.pb_editor_tool_comment_number);
            this.jRY.setVisibility(0);
        }
        this.jSe = (ViewStub) this.bej.findViewById(R.id.interview_status_stub);
        this.jRk = new com.baidu.tieba.pb.pb.main.a.a(this.jGF, cVar);
        this.jRm = new com.baidu.tieba.pb.pb.main.a.d(this.jGF, cVar, this.hpu);
        this.jRs = new g(this.jGF, this.jRh);
        this.jRs.D(this.hpu);
        this.jRs.setTbGestureDetector(this.efF);
        this.jRs.setOnImageClickListener(this.eBC);
        this.jRs.setOnSwitchChangeListener(this.jGF.jLw);
        this.jHE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.27
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
                            av.this.jGF.c(sparseArray);
                            return;
                        }
                        av.this.cI(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        av.this.jGF.c(sparseArray);
                    } else if (booleanValue3) {
                        av.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.jRs.Q(this.jHE);
        cHq();
        cHr();
        this.jRm.b(this.jRh);
        this.jRl.b(this.jRh);
        this.jRk.b(this.jRh);
        this.htI = new PbListView(this.jGF.getPageContext().getPageActivity());
        this.erl = this.htI.getView().findViewById(R.id.pb_more_view);
        if (this.erl != null) {
            this.erl.setOnClickListener(this.hpu);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.erl, R.drawable.pb_foot_more_trans_selector);
        }
        this.htI.setLineVisible();
        this.htI.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.htI.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jRy = this.bej.findViewById(R.id.viewstub_progress);
        this.jGF.registerListener(this.jSX);
        this.jJT = new PbFakeFloorModel(this.jGF.getPageContext());
        this.jSy = new t(this.jGF.getPageContext(), this.jJT, this.bej);
        this.jSy.a(this.jGF.jLx);
        this.jJT.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.av.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                av.this.jJT.t(postData);
                av.this.jRs.notifyDataSetChanged();
                av.this.jSy.cEe();
                av.this.Zt.bbz();
                av.this.sa(false);
            }
        });
        if (this.jGF.cDy() != null && !StringUtils.isNull(this.jGF.cDy().cGc())) {
            this.jGF.showToast(this.jGF.cDy().cGc());
        }
        this.jSh = this.bej.findViewById(R.id.pb_expand_blank_view);
        this.jSi = this.bej.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jSi.getLayoutParams();
        if (this.jGF.cDy() != null && this.jGF.cDy().cFx()) {
            this.jSh.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.jSi.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = jSk;
            this.jSi.setLayoutParams(layoutParams2);
        }
        this.jSj = new aq(this.jGF.getPageContext(), this.bej.findViewById(R.id.pb_reply_expand_view));
        this.jSj.v(pbFragment.jKu);
        this.jSj.jQB.setVisibility(8);
        this.jSj.R(this.hpu);
        this.jSj.setOnSwitchChangeListener(this.jGF.jLw);
        this.jGF.registerListener(this.mAccountChangedListener);
        this.jGF.registerListener(this.jSU);
        cHm();
        rU(false);
    }

    public void rR(boolean z) {
        this.jRN.setVisibility(z ? 0 : 8);
    }

    public void cgO() {
        if (!this.jGF.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").ag("obj_locate", 2).dh("fid", this.mForumId));
        } else if (this.jGF.cEw()) {
            com.baidu.tbadk.editortools.pb.e cEj = this.jGF.cEj();
            if (cEj != null && (cEj.bdJ() || cEj.bdK())) {
                this.jGF.cEj().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Zt != null) {
                cHw();
            }
            if (this.Zt != null) {
                this.jRZ = false;
                if (this.Zt.nf(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.jGF.getPageContext(), (View) this.Zt.nf(2).ekV, false, jSR);
                }
            }
            cIe();
        }
    }

    private void cHm() {
        this.jSL = new com.baidu.tieba.pb.pb.godreply.a(this.jGF, this, (ViewStub) this.bej.findViewById(R.id.more_god_reply_popup));
        this.jSL.y(this.hpu);
        this.jSL.Q(this.jHE);
        this.jSL.setOnImageClickListener(this.eBC);
        this.jSL.y(this.hpu);
        this.jSL.setTbGestureDetector(this.efF);
    }

    public com.baidu.tieba.pb.pb.godreply.a cHn() {
        return this.jSL;
    }

    public View cHo() {
        return this.jSh;
    }

    public void cHp() {
        if (this.jRh != null) {
            this.jRl.c(this.jRh);
            this.jRm.c(this.jRh);
            this.jRn.c(this.jRh);
            this.jRk.c(this.jRh);
        }
    }

    private void cHq() {
        if (this.jRn == null) {
            this.jRn = new com.baidu.tieba.pb.pb.main.a.b(this.jGF, this.hpu);
        }
    }

    private void cHr() {
        if (this.jRl == null) {
            this.jRl = new com.baidu.tieba.pb.pb.main.a.c(this.jGF, this.efF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHs() {
        if (this.jGF.cEM()) {
            this.jRg = (ViewStub) this.bej.findViewById(R.id.manga_mention_controller_view_stub);
            this.jRg.setVisibility(0);
            if (this.jRo == null) {
                this.jRo = (LinearLayout) this.bej.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.jGF.getPageContext(), this.jRo);
            }
            if (this.jRp == null) {
                this.jRp = (TextView) this.jRo.findViewById(R.id.manga_prev_btn);
            }
            if (this.jRq == null) {
                this.jRq = (TextView) this.jRo.findViewById(R.id.manga_next_btn);
            }
            this.jRp.setOnClickListener(this.hpu);
            this.jRq.setOnClickListener(this.hpu);
        }
    }

    private void cHt() {
        if (this.jGF.cEM()) {
            if (this.jGF.cEP() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jRp, R.color.cp_cont_e, 1);
            }
            if (this.jGF.cEQ() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jRq, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cHu() {
        if (this.jRo == null) {
            cHs();
        }
        this.jRg.setVisibility(8);
        if (this.jSV != null && this.jSW != null) {
            this.jSV.removeCallbacks(this.jSW);
        }
    }

    public void cHv() {
        if (this.jSV != null) {
            if (this.jSW != null) {
                this.jSV.removeCallbacks(this.jSW);
            }
            this.jSW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.3
                @Override // java.lang.Runnable
                public void run() {
                    if (av.this.jRo == null) {
                        av.this.cHs();
                    }
                    av.this.jRg.setVisibility(0);
                }
            };
            this.jSV.postDelayed(this.jSW, 2000L);
        }
    }

    public void rS(boolean z) {
        this.jRd.rS(z);
        if (z && this.jSd) {
            this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jRh.setNextPage(this.htI);
            this.jRc = 2;
        }
        if (com.baidu.tbadk.a.d.aMt() && this.jRS != null) {
            this.jRS.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
        this.Zt.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Zt.getParent() == null) {
            this.bej.addView(this.Zt, layoutParams);
        }
        this.Zt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Zt.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.av.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aYc() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aYc() == EmotionGroupType.USER_COLLECT) {
                        if (av.this.mPermissionJudgePolicy == null) {
                            av.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        av.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        av.this.mPermissionJudgePolicy.appendRequestPermission(av.this.jGF.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!av.this.mPermissionJudgePolicy.startRequestPermission(av.this.jGF.getBaseFragmentActivity())) {
                            av.this.jGF.cEj().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            av.this.jGF.cEj().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cHc();
        this.jGF.cEj().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.av.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (av.this.Zt != null && av.this.Zt.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (av.this.jSK == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, av.this.Zt.getId());
                            av.this.jSK = new com.baidu.tieba.pb.pb.main.emotion.c(av.this.jGF.getPageContext(), av.this.bej, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(av.this.jSJ)) {
                                av.this.jSK.setData(av.this.jSJ);
                            }
                            av.this.jSK.b(av.this.Zt);
                        }
                        av.this.jSK.JG(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (av.this.jGF.jKD != null && av.this.jGF.jKD.cIt() != null) {
                    if (!av.this.jGF.jKD.cIt().dmj()) {
                        av.this.jGF.jKD.sf(false);
                    }
                    av.this.jGF.jKD.cIt().vm(false);
                }
            }
        });
    }

    public void cHw() {
        if (this.jGF != null && this.Zt != null) {
            this.Zt.display();
            if (this.jGF.cEj() != null) {
                this.jGF.cEj().bdz();
            }
            cIe();
        }
    }

    public void rT(boolean z) {
        if (this.jRh != null && this.textView != null && this.bdq != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bdq.setVisibility(0);
                } else {
                    this.bdq.setVisibility(8);
                    this.jRh.removeHeaderView(this.textView);
                    this.jRh.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = jSk;
                    this.textView.setLayoutParams(layoutParams);
                }
                cHK();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + sc(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cHK();
            cIm();
        }
    }

    public g cHx() {
        return this.jRs;
    }

    public void a(PbFragment.c cVar) {
        this.jLC = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jGF.getContext());
        kVar.setTitleText(this.jGF.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.jRz.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            av.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (av.this.jSY != null) {
                                av.this.jSY.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            av.this.jGF.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.jGF.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.jGF.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cIl()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.jGF.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.jGF.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.jGF.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aD(arrayList);
        if (this.jRz == null) {
            this.jRz = new com.baidu.tbadk.core.dialog.i(this.jGF.getPageContext(), kVar);
        } else {
            this.jRz.a(kVar);
        }
        this.jRz.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.jSY = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.jGF != null && aVar != null) {
            if (this.hQx == null && this.jRk != null) {
                this.hQx = new com.baidu.tieba.NEGFeedBack.e(this.jGF.getPageContext(), this.jRk.cID());
            }
            AntiData bUa = this.jGF.bUa();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bUa != null && bUa.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUa.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.setFeedBackReasonMap(sparseArray);
            this.hQx.setDefaultReasonArray(new String[]{this.jGF.getString(R.string.delete_thread_reason_1), this.jGF.getString(R.string.delete_thread_reason_2), this.jGF.getString(R.string.delete_thread_reason_3), this.jGF.getString(R.string.delete_thread_reason_4), this.jGF.getString(R.string.delete_thread_reason_5)});
            this.hQx.setData(akVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.hQx.zj(str);
            this.hQx.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.av.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    av.this.jGF.a(aVar, jSONArray);
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
        sparseArray.put(jSr, Integer.valueOf(jSs));
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
        this.jRA = new com.baidu.tbadk.core.dialog.a(this.jGF.getActivity());
        if (StringUtils.isNull(str2)) {
            this.jRA.kD(i3);
        } else {
            this.jRA.setOnlyMessageShowCenter(false);
            this.jRA.vO(str2);
        }
        this.jRA.setYesButtonTag(sparseArray);
        this.jRA.a(R.string.dialog_ok, this.jGF);
        this.jRA.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jRA.gW(true);
        this.jRA.b(this.jGF.getPageContext());
        if (z) {
            this.jRA.aST();
        } else {
            a(this.jRA, i);
        }
    }

    public void aP(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.jRD == null) {
            this.jRD = LayoutInflater.from(this.jGF.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.jGF.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jRD);
        if (this.jRC == null) {
            this.jRC = new Dialog(this.jGF.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jRC.setCanceledOnTouchOutside(true);
            this.jRC.setCancelable(true);
            this.jRL = (ScrollView) this.jRD.findViewById(R.id.good_scroll);
            this.jRC.setContentView(this.jRD);
            WindowManager.LayoutParams attributes = this.jRC.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.jRC.getWindow().setAttributes(attributes);
            this.gGs = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.av.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        av.this.jRH = (String) compoundButton.getTag();
                        if (av.this.gGr != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : av.this.gGr) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && av.this.jRH != null && !str.equals(av.this.jRH)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.jRE = (LinearLayout) this.jRD.findViewById(R.id.good_class_group);
            this.jRG = (TextView) this.jRD.findViewById(R.id.dialog_button_cancel);
            this.jRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (av.this.jRC instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(av.this.jRC, av.this.jGF.getPageContext());
                    }
                }
            });
            this.jRF = (TextView) this.jRD.findViewById(R.id.dialog_button_ok);
            this.jRF.setOnClickListener(this.hpu);
        }
        this.jRE.removeAllViews();
        this.gGr = new ArrayList();
        CustomBlueCheckRadioButton eT = eT("0", this.jGF.getPageContext().getString(R.string.thread_good_class));
        this.gGr.add(eT);
        eT.setChecked(true);
        this.jRE.addView(eT);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.aOS()) && acVar.aOT() > 0) {
                    CustomBlueCheckRadioButton eT2 = eT(String.valueOf(acVar.aOT()), acVar.aOS());
                    this.gGr.add(eT2);
                    View view = new View(this.jGF.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.jRE.addView(view);
                    this.jRE.addView(eT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.jRL.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jGF.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jGF.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jGF.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.jRL.setLayoutParams(layoutParams2);
            this.jRL.removeAllViews();
            if (this.jRE != null && this.jRE.getParent() == null) {
                this.jRL.addView(this.jRE);
            }
        }
        com.baidu.adp.lib.f.g.a(this.jRC, this.jGF.getPageContext());
    }

    private CustomBlueCheckRadioButton eT(String str, String str2) {
        Activity pageActivity = this.jGF.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gGs);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cHy() {
        this.jGF.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.jGF.hideProgressBar();
        if (z && z2) {
            this.jGF.showToast(this.jGF.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.jGF.showToast(str);
        }
    }

    public void cnI() {
        this.jRy.setVisibility(0);
    }

    public void cnH() {
        this.jRy.setVisibility(8);
    }

    public View cHz() {
        if (this.jRD != null) {
            return this.jRD.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cHA() {
        return this.jRH;
    }

    public View getView() {
        return this.bej;
    }

    public void cHB() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.jGF.getPageContext().getPageActivity(), this.jGF.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.jGF.hideProgressBar();
        if (z) {
            cHU();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cHV();
        } else {
            cHU();
        }
    }

    public void cHC() {
        this.htI.setLineVisible();
        this.htI.startLoadData();
    }

    public void cHD() {
        this.jGF.hideProgressBar();
        endLoadData();
        this.jRh.completePullRefreshPostDelayed(0L);
        cHP();
    }

    public void cHE() {
        this.jRh.completePullRefreshPostDelayed(0L);
        cHP();
    }

    private void rU(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.jRm.b(onLongClickListener);
        this.jRs.setOnLongClickListener(onLongClickListener);
        if (this.jSL != null) {
            this.jSL.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.jKE != null) {
            this.jKE.dismiss();
            this.jKE = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jGF.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.jGF.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jGF.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jGF.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jGF.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aD(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.jRI.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jRI = new com.baidu.tbadk.core.dialog.i(this.jGF.getPageContext(), kVar);
        this.jRI.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.jRI != null) {
            this.jRI.dismiss();
            this.jRI = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jGF.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.jHO != null && this.jHO.cCi() != null && !this.jHO.cCi().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.jGF.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jGF.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aD(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.jRI.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jRI = new com.baidu.tbadk.core.dialog.i(this.jGF.getPageContext(), kVar);
        this.jRI.showDialog();
    }

    public int cHF() {
        return Ax(this.jRh.getFirstVisiblePosition());
    }

    private int Ax(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.jRh.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.jRh.getAdapter() == null || !(this.jRh.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.jRh.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cHG() {
        int lastVisiblePosition = this.jRh.getLastVisiblePosition();
        if (this.jRj != null) {
            if (lastVisiblePosition == this.jRh.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Ax(lastVisiblePosition);
    }

    public void Ay(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.jRh != null) {
            if (this.jRd == null || this.jRd.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.jRd.mNavigationBar.getFixedNavHeight();
                if (this.jGF.cEC() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.jSi != null && (layoutParams = (LinearLayout.LayoutParams) this.jSi.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.jSi.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.jRh.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.jRh.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.jRh.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.jRv.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void r(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.jRs.a(eVar, false);
        this.jRs.notifyDataSetChanged();
        cHP();
        if (this.jSL != null) {
            this.jSL.cDu();
        }
        ArrayList<PostData> cCk = eVar.cCk();
        if (eVar.getPage().aPt() == 0 || cCk == null || cCk.size() < eVar.getPage().aPs()) {
            if (com.baidu.tbadk.core.util.v.getCount(cCk) == 0 || (com.baidu.tbadk.core.util.v.getCount(cCk) == 1 && cCk.get(0) != null && cCk.get(0).ddu() == 1)) {
                if (this.jSn == null || this.jSn.jTr == null || this.jSn.jTr.getView() == null) {
                    i = 0;
                } else {
                    i = this.jSn.jTr.getView().getTop() < 0 ? this.jSn.jTr.getView().getHeight() : this.jSn.jTr.getView().getBottom();
                }
                if (this.jGF.cEW()) {
                    this.htI.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.htI.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aPt() == 0) {
                    this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.htI.aWf();
            }
        }
        t(eVar);
    }

    public void s(com.baidu.tieba.pb.data.e eVar) {
        if (this.jRk != null) {
            this.jRk.e(eVar, this.jHw);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cCv() != null) {
            return eVar.cCv();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cCk())) {
            Iterator<PostData> it = eVar.cCk().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.ddu() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cCr();
        }
        if (!r(postData)) {
            postData = a(eVar);
        }
        if (postData != null && postData.aQx() != null && postData.aQx().getUserTbVipInfoData() != null && postData.aQx().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aQx().getGodUserData().setIntro(postData.aQx().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.aQx() == null) {
            return false;
        }
        MetaData aQx = postData.aQx();
        return (TextUtils.isEmpty(aQx.getUserId()) && TextUtils.isEmpty(aQx.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cCi() == null || eVar.cCi().aQx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aQx = eVar.cCi().aQx();
        String userId = aQx.getUserId();
        HashMap<String, MetaData> userMap = eVar.cCi().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aQx;
        }
        postData.DS(1);
        postData.setId(eVar.cCi().aQP());
        postData.setTitle(eVar.cCi().getTitle());
        postData.setTime(eVar.cCi().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.cCi() != null) {
            if (this.jGF.cDo()) {
                if (eVar.cCh() != null) {
                    this.mForumName = eVar.cCh().getForumName();
                    this.mForumId = eVar.cCh().getForumId();
                }
                if (this.mForumName == null && this.jGF.cDy() != null && this.jGF.cDy().cDp() != null) {
                    this.mForumName = this.jGF.cDy().cDp();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.jRm.setVisibility(8);
            if (eVar.aWi()) {
                this.jSC = true;
                this.jRd.rc(true);
                this.jRd.mNavigationBar.hideBottomLine();
                if (this.jRj == null) {
                    this.jRj = new com.baidu.tieba.pb.pb.main.a.e(this.jGF);
                }
                this.jRj.a(eVar, b, this.jRh, this.jRm, this.jSg, this.jRd, this.mForumName, this.jSQ);
                this.jRj.S(this.jTa);
                cHK();
            } else {
                this.jSC = false;
                this.jRd.rc(this.jSC);
                if (this.jRj != null) {
                    this.jRj.c(this.jRh);
                }
            }
            if (this.jGF.cEm() != null) {
                this.jGF.cEm().sk(this.jSC);
            }
            if (b != null) {
                this.jSc = b;
                this.jRm.setVisibility(0);
                SparseArray<Object> cIG = this.jRm.cIG();
                cIG.put(R.id.tag_clip_board, b);
                cIG.put(R.id.tag_is_subpb, false);
                this.jRn.a(eVar, this.jRh);
                this.jRl.z(eVar);
                this.jRk.e(eVar, this.jHw);
                this.jRk.y(eVar);
                this.jRm.a(this.mSkinType, this.jHO, b, this.jTa);
                if (this.jSj != null) {
                    if (eVar.cCJ()) {
                        this.jSj.getView().setVisibility(8);
                    } else {
                        this.jSj.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jFi);
                        if (eVar.cCi() != null) {
                            lVar.jFk = eVar.cCi().aQo();
                        }
                        lVar.isNew = !this.jHw;
                        lVar.sortType = eVar.jDW;
                        lVar.jFm = eVar.cCK();
                        lVar.jFn = this.jGF.cEW();
                        lVar.jFo = eVar.jDV;
                        this.jSj.a(lVar);
                    }
                }
                if (eVar != null && eVar.cCi() != null) {
                    aj(eVar.cCi().aQt() == 1, eVar.cCi().aQs() == 1);
                }
                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (av.this.jRs != null && av.this.jRd != null && av.this.jRd.jXz != null && av.this.jHO != null && av.this.jHO.cCi() != null && !av.this.jHO.cCi().aPk() && !av.this.cHO() && av.this.jHO.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(av.this.jHO.getForum().getName())) {
                            if ((av.this.jRs.cEa() == null || !av.this.jRs.cEa().isShown()) && av.this.jRd.jXz != null) {
                                av.this.jRd.jXz.setVisibility(0);
                                if (av.this.jGF != null && av.this.jGF.cDy() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.dh("tid", av.this.jGF.cDy().cFt());
                                    anVar.dh("fid", av.this.jGF.cDy().getForumId());
                                    anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void rV(boolean z) {
        if (z) {
            cHH();
        } else {
            bPf();
        }
        this.jSn.jTr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jSn));
        a(this.jSn.jTr, false);
    }

    public void cHH() {
        if (this.jRd != null && !this.jSE) {
            this.jRd.cHH();
            this.jSE = true;
        }
    }

    public void bPf() {
        if (this.jRd != null) {
            this.jRd.cJe();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.jRm.a(postData, eVar);
    }

    public void cHI() {
        if (this.jRj != null) {
            this.jRj.d(this.jRh);
        }
    }

    public boolean cHJ() {
        return this.aOK;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aK(bk bkVar) {
        if (bkVar == null || bkVar.aQx() == null) {
            return false;
        }
        PostData b = b(this.jHO, false);
        String str = "";
        if (b != null && b.aQx() != null) {
            str = b.aQx().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.jRd.cJc();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.jRd.Hp(dVar.forumName);
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
            final String str2 = dVar.jDO;
            this.jGF.showNetRefreshView(this.bej, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.ba.aUZ().b(av.this.jGF.getPageContext(), new String[]{str2});
                        av.this.jGF.finish();
                        return;
                    }
                    av.this.jGF.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cGN;
        Parcelable cGN2;
        if (eVar != null && this.jRh != null) {
            this.jHO = eVar;
            this.mType = i;
            if (eVar.cCi() != null) {
                this.jSp = eVar.cCi().aQe();
                if (eVar.cCi().getAnchorLevel() != 0) {
                    this.aOK = true;
                }
                this.jRK = aK(eVar.cCi());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            x(eVar);
            this.jSd = false;
            this.jHw = z;
            cHD();
            if (eVar.jDX != null && eVar.jDX.cCP()) {
                if (this.jRi == null) {
                    this.jRi = new PbThreadPostView(this.jGF.getContext());
                    this.jRh.addHeaderView(this.jRi, 1);
                    this.jRi.setData(eVar);
                    this.jRi.setChildOnClickLinstener(this.hpu);
                }
            } else if (this.jRi != null && this.jRh != null) {
                this.jRh.removeHeaderView(this.jRi);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            u(eVar);
            if (this.jSO == null) {
                this.jSO = new ah(this.jGF.getPageContext(), this.hNA);
            }
            this.jSO.Jw(eVar.cCp());
            if (this.jGF.cEM()) {
                if (this.jRw == null) {
                    this.jRw = new com.baidu.tieba.pb.view.d(this.jGF.getPageContext());
                    this.jRw.createView();
                    this.jRw.setListPullRefreshListener(this.dVt);
                }
                this.jRh.setPullRefresh(this.jRw);
                cHK();
                if (this.jRw != null) {
                    this.jRw.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aPu() == 0 && z) {
                this.jRh.setPullRefresh(null);
            } else {
                if (this.jRw == null) {
                    this.jRw = new com.baidu.tieba.pb.view.d(this.jGF.getPageContext());
                    this.jRw.createView();
                    this.jRw.setListPullRefreshListener(this.dVt);
                }
                this.jRh.setPullRefresh(this.jRw);
                cHK();
                if (this.jRw != null) {
                    this.jRw.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bGf();
            }
            cHP();
            this.jRs.rf(this.jHw);
            this.jRs.rg(false);
            this.jRs.rk(i == 5);
            this.jRs.rl(i == 6);
            this.jRs.rm(z2 && this.jSZ && i != 2);
            this.jRs.a(eVar, false);
            this.jRs.notifyDataSetChanged();
            this.jRm.a(b(eVar, z), eVar.cCJ());
            if (eVar.cCi() != null && eVar.cCi().aQi() != null && this.jRb != -1) {
                eVar.cCi().aQi().setIsLike(this.jRb);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.jRh.setNextPage(this.htI);
                this.jRc = 2;
                bGf();
            } else {
                this.jSd = true;
                if (eVar.getPage().aPt() == 1) {
                    if (this.jRx == null) {
                        this.jRx = new com.baidu.tieba.pb.view.a(this.jGF, this.jGF);
                    }
                    this.jRh.setNextPage(this.jRx);
                } else {
                    this.jRh.setNextPage(this.htI);
                }
                this.jRc = 3;
            }
            ArrayList<PostData> cCk = eVar.cCk();
            if (eVar.getPage().aPt() == 0 || cCk == null || cCk.size() < eVar.getPage().aPs()) {
                if (com.baidu.tbadk.core.util.v.getCount(cCk) == 0 || (com.baidu.tbadk.core.util.v.getCount(cCk) == 1 && cCk.get(0) != null && cCk.get(0).ddu() == 1)) {
                    if (this.jSn == null || this.jSn.jTr == null || this.jSn.jTr.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.jSn.jTr.getView().getTop() < 0 ? this.jSn.jTr.getView().getHeight() : this.jSn.jTr.getView().getBottom();
                    }
                    if (this.jGF.cEW()) {
                        this.htI.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.htI.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.jGF.cEm() != null && !this.jGF.cEm().cIQ()) {
                        this.jGF.cEm().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aPt() == 0) {
                        this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.htI.aWf();
                }
                if (eVar.getPage().aPt() == 0 || cCk == null) {
                    cHZ();
                }
            } else {
                if (z2) {
                    if (this.jSZ) {
                        endLoadData();
                        if (eVar.getPage().aPt() != 0) {
                            this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.htI.setLineVisible();
                        this.htI.showLoading();
                    }
                } else {
                    this.htI.setLineVisible();
                    this.htI.showLoading();
                }
                this.htI.aWf();
            }
            switch (i) {
                case 2:
                    this.jRh.setSelection(i2 > 1 ? (((this.jRh.getData() == null && eVar.cCk() == null) ? 0 : (this.jRh.getData().size() - eVar.cCk().size()) + this.jRh.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cGN2 = ao.cGM().cGN()) != null && !(cGN2 instanceof RecyclerView.SavedState)) {
                        this.jRh.onRestoreInstanceState(cGN2);
                        if (com.baidu.tbadk.core.util.v.getCount(cCk) > 1 && eVar.getPage().aPt() > 0) {
                            this.htI.endLoadData();
                            this.htI.setText(this.jGF.getString(R.string.pb_load_more_without_point));
                            this.htI.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.jSZ = false;
                    break;
                case 5:
                    this.jRh.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cGN = ao.cGM().cGN()) != null && !(cGN instanceof RecyclerView.SavedState)) {
                        this.jRh.onRestoreInstanceState(cGN);
                        break;
                    } else {
                        this.jRh.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.jRj != null && this.jRj.brc() != null) {
                            if (this.jGF.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.jRh.setSelectionFromTop((this.jRs.cDV() + this.jRh.getHeaderViewsCount()) - 1, this.jRj.cII() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.jGF.getPageContext().getPageActivity()));
                            } else {
                                this.jRh.setSelectionFromTop((this.jRs.cDV() + this.jRh.getHeaderViewsCount()) - 1, this.jRj.cII());
                            }
                        } else {
                            this.jRh.setSelection(this.jRs.cDV() + this.jRh.getHeaderViewsCount());
                        }
                    } else {
                        this.jRh.setSelection(i2 > 0 ? ((this.jRh.getData() == null && eVar.cCk() == null) ? 0 : (this.jRh.getData().size() - eVar.cCk().size()) + this.jRh.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.htI.endLoadData();
                    this.htI.setText(this.jGF.getString(R.string.pb_load_more_without_point));
                    this.htI.setLineGone();
                    break;
            }
            if (this.jSp == jSq && isHost()) {
                cIh();
            }
            if (this.jSA) {
                cHa();
                this.jSA = false;
                if (i3 == 0) {
                    rO(true);
                }
            }
            if (eVar.jDT == 1 || eVar.jDU == 1) {
                if (this.jSG == null) {
                    this.jSG = new PbTopTipView(this.jGF.getContext());
                }
                if (eVar.jDU == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.jGF.getStType())) {
                    this.jSG.setText(this.jGF.getString(R.string.pb_read_strategy_add_experience));
                    this.jSG.a(this.bej, this.mSkinType);
                } else if (eVar.jDT == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.jGF.getStType())) {
                    this.jSG.setText(this.jGF.getString(R.string.pb_read_news_add_experience));
                    this.jSG.a(this.bej, this.mSkinType);
                }
            }
            t(eVar);
        }
    }

    private void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCi() != null) {
            w(eVar);
            if (eVar.aML()) {
                SvgManager.aUV().a(this.jRU, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aUV().a(this.jRU, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Az = Az(eVar.cCi().aQo());
            if (this.jRX != null) {
                this.jRX.setText(Az);
            }
            if (this.jRY != null) {
                this.jRY.setText(Az);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cCi()));
        }
    }

    private String Az(int i) {
        if (i == 0) {
            return this.jGF.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cHK() {
        if (this.jRj != null) {
            this.jRj.a(this.jRh, this.textView, this.mType);
        }
    }

    public void rW(boolean z) {
        this.jRJ = z;
    }

    public void endLoadData() {
        if (this.htI != null) {
            this.htI.setLineGone();
            this.htI.endLoadData();
        }
        bGf();
    }

    public void bvM() {
        this.jRh.setVisibility(0);
    }

    public void cHL() {
        if (this.jRh != null) {
            this.jRh.setVisibility(8);
        }
        if (this.jRh != null) {
            this.jSg.setVisibility(8);
        }
        if (this.jRd != null && this.jRd.jXw != null) {
            this.jRd.jXw.setVisibility(8);
        }
    }

    public void cHM() {
        if (this.jRh != null) {
            this.jRh.setVisibility(0);
        }
        if (this.jSg != null) {
            this.jSg.setVisibility(0);
        }
        if (this.jRd != null && this.jRd.jXw != null) {
            this.jRd.jXw.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.jSc != null && this.jSc.aQx() != null && this.jRd != null) {
            this.jSD = !this.jSC;
            this.jRd.sm(this.jSD);
            if (this.jGF.cEm() != null) {
                this.jGF.cEm().sl(this.jSD);
            }
            cHN();
            if (this.jGF != null && !this.jGF.cDo() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cCE())) {
                bg bgVar = eVar.cCE().get(0);
                if (bgVar != null) {
                    this.jRd.eU(bgVar.getForumName(), bgVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.jRd.eU(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            this.jRd.b(eVar, this.jSc, this.jRK);
            if (this.jSD) {
                this.jRm.a(eVar, this.jSc, this.jRK);
                if (this.jSi != null) {
                    this.jSi.setVisibility(8);
                }
                if (this.jSM == null) {
                    this.jSM = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.av.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (av.this.jGF != null && av.this.jGF.isAdded()) {
                                if (i < 0 && f > av.this.jSF) {
                                    av.this.cIg();
                                }
                                av.this.cHE();
                            }
                        }
                    };
                }
                this.jRh.setListViewDragListener(this.jSM);
                return;
            }
            if (this.jSi != null) {
                this.jSi.setVisibility(0);
            }
            this.jRm.a(eVar, this.jSc, this.jRK);
            this.jSM = null;
            this.jRh.setListViewDragListener(null);
        }
    }

    private void cHN() {
        this.jRm.a(this.jHO, this.jSc, this.jSD, this.jSC);
    }

    public boolean cHO() {
        return this.jHO == null || this.jHO.getForum() == null || "0".equals(this.jHO.getForum().getId()) || "me0407".equals(this.jHO.getForum().getName());
    }

    private boolean cHP() {
        return this.jRk.sh(this.jHw);
    }

    private boolean v(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cCi() == null) {
            return false;
        }
        if (eVar.cCi().aQu() == 1 || eVar.cCi().getThreadType() == 33) {
            return true;
        }
        return !(eVar.cCi().aQw() == null || eVar.cCi().aQw().aSK() == 0) || eVar.cCi().aQs() == 1 || eVar.cCi().aQt() == 1 || eVar.cCi().aRm() || eVar.cCi().aRG() || eVar.cCi().aRz() || eVar.cCi().aQJ() != null || !com.baidu.tbadk.core.util.aq.isEmpty(eVar.cCi().getCategory()) || eVar.cCi().aQA() || eVar.cCi().aQz();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.jRl != null) {
                if (eVar.cCi() != null && eVar.cCi().aQM() == 0 && !eVar.cCi().aPk() && !this.jSS) {
                    if (eVar.cCi() != null) {
                        bk cCi = eVar.cCi();
                        cCi.v(true, v(eVar));
                        cCi.kp(3);
                        cCi.vB("2");
                    }
                    if (eVar.cCi().aPm()) {
                        this.jRm.c(this.jRh);
                        this.jRl.c(this.jRh);
                        this.jRl.b(this.jRh);
                        this.jRm.b(this.jRh);
                        this.jRm.D(this.jHO);
                        this.jRl.A(eVar);
                    } else {
                        this.jRm.D(this.jHO);
                        this.jRl.C(eVar);
                    }
                } else if (eVar.cCi().aQM() == 1) {
                    if (eVar.cCi() != null) {
                        this.jRl.c(this.jRh);
                        this.jRm.D(this.jHO);
                    }
                } else {
                    this.jRl.c(this.jRh);
                    this.jRm.D(this.jHO);
                }
            }
            if (eVar.cCi() != null) {
                ai(eVar.cCi().aQt() == 1, eVar.cCi().aQs() == 1);
            }
            this.jHw = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cHP();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (eVar != null && (b = b(eVar, z)) != null) {
            String userId = b.aQx().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cCx()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.aQx() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.aQx().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.aQx().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.aQx().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cCx()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bg> cCE = eVar.cCE();
                if (com.baidu.tbadk.core.util.v.getCount(cCE) > 0) {
                    sb = new StringBuilder();
                    for (bg bgVar : cCE) {
                        if (bgVar != null && !StringUtils.isNull(bgVar.getForumName()) && (vVar = bgVar.dEk) != null && vVar.dCh && !vVar.dCi && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bgVar.getForumName(), 12)).append(this.jGF.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.jGF.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cHQ() {
        return this.erl;
    }

    public boolean cHR() {
        if (this.beU == null || this.beU.getParent() == null || this.htI.isLoading()) {
            return false;
        }
        int bottom = this.beU.getBottom();
        Rect rect = new Rect();
        this.beU.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Jy(String str) {
        if (this.htI != null) {
            this.htI.setText(str);
        }
    }

    public void Jz(String str) {
        if (this.htI != null) {
            int i = 0;
            if (this.jSn != null && this.jSn.jTr != null && this.jSn.jTr.getView() != null) {
                i = this.jSn.jTr.getView().getTop() < 0 ? this.jSn.jTr.getView().getHeight() : this.jSn.jTr.getView().getBottom();
            }
            this.htI.ak(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.jRh;
    }

    public int cHS() {
        return R.id.richText;
    }

    public TextView cDI() {
        return this.jRm.cDI();
    }

    public void d(BdListView.e eVar) {
        this.jRh.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.dVt = cVar;
        if (this.jRw != null) {
            this.jRw.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, a.b bVar) {
        if (aoVar != null) {
            int aPr = aoVar.aPr();
            int aPo = aoVar.aPo();
            if (this.jRt != null) {
                this.jRt.aST();
            } else {
                this.jRt = new com.baidu.tbadk.core.dialog.a(this.jGF.getPageContext().getPageActivity());
                this.jRu = LayoutInflater.from(this.jGF.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.jRt.aP(this.jRu);
                this.jRt.a(R.string.dialog_ok, bVar);
                this.jRt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        av.this.cHU();
                        aVar.dismiss();
                    }
                });
                this.jRt.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.av.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (av.this.jSx == null) {
                            av.this.jSx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    av.this.jGF.HidenSoftKeyPad((InputMethodManager) av.this.jGF.getBaseFragmentActivity().getSystemService("input_method"), av.this.bej);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.ld().postDelayed(av.this.jSx, 150L);
                    }
                });
                this.jRt.b(this.jGF.getPageContext()).aST();
            }
            this.jRv = (EditText) this.jRu.findViewById(R.id.input_page_number);
            this.jRv.setText("");
            TextView textView = (TextView) this.jRu.findViewById(R.id.current_page_number);
            if (aPr <= 0) {
                aPr = 1;
            }
            if (aPo <= 0) {
                aPo = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aPr), Integer.valueOf(aPo)));
            this.jGF.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.jRv, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jRh.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.jGF.showToast(str);
    }

    public boolean rX(boolean z) {
        if (this.Zt == null || !this.Zt.bcY()) {
            return false;
        }
        this.Zt.bbz();
        return true;
    }

    public void cHT() {
        if (this.jTb != null) {
            while (this.jTb.size() > 0) {
                TbImageView remove = this.jTb.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cHT();
        this.jRs.Aa(1);
        if (this.jRj != null) {
            this.jRj.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.jRs.Aa(2);
        if (this.jRj != null) {
            this.jRj.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.jGF.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.jGF.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.jRW != null) {
            this.jRW.onDestroy();
        }
        if (this.jSz != null) {
            this.jSz.destroy();
        }
        if (this.jSO != null) {
            this.jSO.onDestory();
        }
        if (this.jSG != null) {
            this.jSG.hide();
        }
        this.jGF.hideProgressBar();
        if (this.fan != null && this.hkE != null) {
            this.fan.b(this.hkE);
        }
        cHU();
        endLoadData();
        if (this.jSx != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jSx);
        }
        if (this.jSf != null) {
            this.jSf.clearStatus();
        }
        this.jSV = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.jRs.Aa(3);
        if (this.bdq != null) {
            this.bdq.setBackgroundDrawable(null);
        }
        if (this.jRj != null) {
            this.jRj.destroy();
        }
        if (this.jRs != null) {
            this.jRs.onDestroy();
        }
        this.jRh.setOnLayoutListener(null);
        if (this.jSK != null) {
            this.jSK.bXE();
        }
        if (this.jSo != null) {
            this.jSo.onDestroy();
        }
        if (this.jRm != null) {
            this.jRm.onDestroy();
        }
    }

    public boolean AA(int i) {
        if (this.jRj != null) {
            return this.jRj.AA(i);
        }
        return false;
    }

    public void cHU() {
        this.jRd.aEa();
        if (this.jRm != null) {
            this.jRm.cHU();
        }
        if (this.jGF != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.jGF.getContext(), this.jRv);
        }
        cHc();
        if (this.jKE != null) {
            this.jKE.dismiss();
        }
        cHW();
        if (this.jRt != null) {
            this.jRt.dismiss();
        }
        if (this.hpt != null) {
            this.hpt.dismiss();
        }
    }

    public void cHV() {
        this.jRd.aEa();
        if (this.jRm != null) {
            this.jRm.cHU();
        }
        if (this.jKE != null) {
            this.jKE.dismiss();
        }
        cHW();
        if (this.jRt != null) {
            this.jRt.dismiss();
        }
        if (this.hpt != null) {
            this.hpt.dismiss();
        }
    }

    public void dY(List<String> list) {
        this.jSJ = list;
        if (this.jSK != null) {
            this.jSK.setData(list);
        }
    }

    public void re(boolean z) {
        this.jRs.re(z);
    }

    public void rY(boolean z) {
        this.jRM = z;
    }

    public void cHW() {
        if (this.jRA != null) {
            this.jRA.dismiss();
        }
        if (this.jRB != null) {
            com.baidu.adp.lib.f.g.b(this.jRB, this.jGF.getPageContext());
        }
        if (this.jRC != null) {
            com.baidu.adp.lib.f.g.b(this.jRC, this.jGF.getPageContext());
        }
        if (this.jRz != null) {
            this.jRz.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.jHO, this.jHw);
            b(this.jHO, this.jHw, this.mType, i);
            this.jGF.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.jGF.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bej);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.bej, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.jRN, R.drawable.personalize_tab_shadow);
            if (this.jRj != null) {
                this.jRj.onChangeSkinType(i);
            }
            if (this.jRn != null) {
                this.jRn.onChangeSkinType(i);
            }
            if (this.jRk != null) {
                this.jRk.onChangeSkinType(i);
            }
            if (this.jRl != null) {
                this.jRl.onChangeSkinType(i);
            }
            if (this.jRm != null) {
                this.jRm.onChangeSkinType(i);
            }
            if (this.htI != null) {
                this.htI.changeSkin(i);
                if (this.erl != null) {
                    this.jGF.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.erl);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.erl, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.jRt != null) {
                this.jRt.c(this.jGF.getPageContext());
            }
            rW(this.jRJ);
            this.jRs.notifyDataSetChanged();
            if (this.jRw != null) {
                this.jRw.changeSkin(i);
            }
            if (this.Zt != null) {
                this.Zt.onChangeSkinType(i);
            }
            if (this.jRx != null) {
                this.jRx.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.gGr)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.gGr) {
                    customBlueCheckRadioButton.aVS();
                }
            }
            cHt();
            UtilHelper.setStatusBarBackground(this.bdq, i);
            UtilHelper.setStatusBarBackground(this.jSi, i);
            if (this.jRo != null) {
                com.baidu.tbadk.q.a.a(this.jGF.getPageContext(), this.jRo);
            }
            if (this.jSy != null) {
                this.jSy.onChangeSkinType(i);
            }
            if (this.jRd != null) {
                if (this.jRj != null) {
                    this.jRj.AB(i);
                } else {
                    this.jRd.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.igY != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.igY, (int) R.color.cp_cont_d);
            }
            if (this.jRS != null) {
                this.jRS.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_border_a));
            }
            if (this.jRR != null) {
                this.jRR.setBackgroundDrawable(com.baidu.tbadk.core.util.am.aE(com.baidu.adp.lib.util.l.getDimens(this.jGF.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.jRU != null && this.jHO != null) {
                if (this.jHO.aML()) {
                    SvgManager.aUV().a(this.jRU, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aUV().a(this.jRU, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            w(this.jHO);
            if (this.jRT != null) {
                SvgManager.aUV().a(this.jRT, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jRP != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jRP, R.drawable.bottom_shadow);
            }
            if (this.jRX != null) {
                com.baidu.tbadk.core.util.am.c(this.jRX, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jRX, (int) R.color.cp_cont_a);
            }
            if (this.jRY != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jRY, (int) R.color.cp_cont_b);
            }
            if (this.jSL != null) {
                this.jSL.onChangeSkinType(i);
            }
            if (this.jSo != null) {
                this.jSo.onChangeSkinType();
            }
            if (this.jSI != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jSI, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jRQ, R.color.cp_bg_line_h);
            if (this.jRi != null) {
                this.jRi.qi(i);
            }
            if (this.jRW != null) {
                this.jRW.onChangeSkinType();
            }
        }
    }

    public void cHX() {
        if (this.jRW != null) {
            this.jRW.setEnable(false);
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aZ(eVar.cCi())) {
            if (this.jRW != null) {
                this.jRW.setEnable(false);
                this.jRW.onDestroy();
            }
            SvgManager.aUV().a(this.jRV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.jRW == null || !this.jRW.isEnable()) {
            SvgManager.aUV().a(this.jRV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBC = iVar;
        this.jRs.setOnImageClickListener(this.eBC);
        this.jSL.setOnImageClickListener(this.eBC);
    }

    public void g(NoNetworkView.a aVar) {
        this.hkE = aVar;
        if (this.fan != null) {
            this.fan.a(this.hkE);
        }
    }

    public void rZ(boolean z) {
        this.jRs.setIsFromCDN(z);
    }

    public Button cHY() {
        return this.jRO;
    }

    public void cHZ() {
        if (this.jRc != 2) {
            this.jRh.setNextPage(this.htI);
            this.jRc = 2;
        }
    }

    public void cIa() {
        if (com.baidu.tbadk.n.m.bfI().bfJ()) {
            int lastVisiblePosition = this.jRh.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.jRh.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.erV = true;
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
                        perfLog2.erV = true;
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

    public boolean cIb() {
        return this.Zt != null && this.Zt.getVisibility() == 0;
    }

    public boolean cIc() {
        return this.Zt != null && this.Zt.bcY();
    }

    public void cId() {
        if (this.Zt != null) {
            this.Zt.bbz();
        }
    }

    public void sa(boolean z) {
        if (this.jRQ != null) {
            rY(this.jGF.cEj().bdC());
            if (this.jRM) {
                rP(z);
            } else {
                rQ(z);
            }
        }
    }

    public void cIe() {
        if (this.jRQ != null) {
            this.jRP.setVisibility(8);
            this.jRQ.setVisibility(8);
            this.jRZ = false;
            if (this.jSo != null) {
                this.jSo.setVisibility(8);
                rU(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.gKp == null) {
            this.gKp = new com.baidu.tbadk.core.view.a(this.jGF.getPageContext());
        }
        this.gKp.setDialogVisiable(true);
    }

    public void bGf() {
        if (this.gKp != null) {
            this.gKp.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.jRh.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.jRh.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.jRj != null) {
            this.jRj.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.jTc = getScrollY();
            this.jSn.jTr = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jSn));
            a(this.jSn.jTr, true);
        }
    }

    public void sb(boolean z) {
        if (this.jRj != null) {
            this.jRj.sb(z);
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
        if (this.jRj != null) {
            this.jRj.onScroll(absListView, i, i2, i3);
        }
        if (this.jRd != null && this.jRm != null) {
            this.jRd.cL(this.jRm.cIE());
        }
        this.jSn.jxT = i;
        this.jSn.headerCount = this.jRh.getHeaderViewsCount();
        this.jSn.jTr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jSn));
        rR(b(absListView, i));
        a(this.jSn.jTr, false);
        if (this.htI.aWg() && !this.htI.dUN) {
            if (this.jSn != null && this.jSn.jTr != null && this.jSn.jTr.getView() != null) {
                i4 = this.jSn.jTr.getView().getTop() < 0 ? this.jSn.jTr.getView().getHeight() : this.jSn.jTr.getView().getBottom();
            }
            this.htI.lX(i4);
            this.htI.dUN = true;
        }
    }

    public void cIf() {
        if (TbadkCoreApplication.isLogin() && this.jHO != null && this.jSD && !this.jSC && !this.jRK && this.jSc != null && this.jSc.aQx() != null && !this.jSc.aQx().getIsLike() && !this.jSc.aQx().hadConcerned() && this.jSz == null) {
            this.jSz = new ar(this.jGF);
        }
    }

    public void cIg() {
        if (this.jSD && !this.jSC && this.jSc != null && this.jSc.aQx() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").ag("obj_locate", this.jGF.cDo() ? 2 : 1).ag("obj_type", this.jSC ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.jGF.getPageContext().getPageActivity(), this.jSc.aQx().getUserId(), this.jSc.aQx().getUserName(), this.jGF.cDy().cDp(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aq aqVar, boolean z) {
        int measuredHeight;
        if (!this.jSC && this.jSh != null && this.jRd.cIW() != null) {
            int cDW = this.jRs.cDW();
            if (cDW > 0 && (aqVar == null || aqVar.getView().getParent() == null)) {
                if (cDW > this.jRh.getFirstVisiblePosition() - this.jRh.getHeaderViewsCount()) {
                    this.jSh.setVisibility(4);
                    return;
                }
                this.jSh.setVisibility(0);
                rR(false);
                this.jRd.mNavigationBar.hideBottomLine();
                if (this.jSh.getParent() != null && ((ViewGroup) this.jSh.getParent()).getHeight() <= this.jSh.getTop()) {
                    this.jSh.getParent().requestLayout();
                }
            } else if (aqVar == null || aqVar.getView() == null || aqVar.jQB == null) {
                if (this.jRh.getFirstVisiblePosition() == 0) {
                    this.jSh.setVisibility(4);
                    this.jRd.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = aqVar.getView().getTop();
                if (aqVar.getView().getParent() != null) {
                    if (this.jSm) {
                        this.jSl = top2;
                        this.jSm = false;
                    }
                    this.jSl = top2 < this.jSl ? top2 : this.jSl;
                }
                if (top2 != 0 || aqVar.getView().isShown()) {
                    if (this.jRr.getY() < 0.0f) {
                        measuredHeight = jSk - aqVar.jQB.getMeasuredHeight();
                    } else {
                        measuredHeight = this.jRd.cIW().getMeasuredHeight() - aqVar.jQB.getMeasuredHeight();
                        this.jRd.mNavigationBar.hideBottomLine();
                    }
                    if (aqVar.getView().getParent() == null && top2 <= this.jSl) {
                        this.jSh.setVisibility(0);
                        rR(false);
                    } else if (top2 < measuredHeight) {
                        this.jSh.setVisibility(0);
                        rR(false);
                    } else {
                        this.jSh.setVisibility(4);
                        this.jRd.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.jSm = true;
                    }
                }
            }
        }
    }

    public void cIh() {
        if (!this.jTd) {
            TiebaStatic.log("c10490");
            this.jTd = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jGF.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(jSr, Integer.valueOf(jSt));
            aVar.kC(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.jGF.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aP(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.jGF);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jGF.getPageContext()).aST();
        }
    }

    public void JA(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jGF.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.jGF.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aP(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(jSr, Integer.valueOf(jSu));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.jGF);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jGF.getPageContext()).aST();
    }

    public void a(int i, com.baidu.tieba.pb.data.e eVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(eVar, z)) != null && b.aQx() != null) {
            MetaData aQx = b.aQx();
            aQx.setGiftNum(aQx.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        a(eVar, z, i, i2);
        this.jRm.onChangeSkinType(i2);
    }

    public PbInterviewStatusView cIi() {
        return this.jSf;
    }

    private void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCi() != null && eVar.cCi().aRG() && this.jSf == null) {
            this.jSf = (PbInterviewStatusView) this.jSe.inflate();
            this.jSf.setOnClickListener(this.hpu);
            this.jSf.setCallback(this.jGF.cEU());
            this.jSf.setData(this.jGF, eVar);
        }
    }

    public RelativeLayout cIj() {
        return this.jRr;
    }

    public View cIk() {
        return this.bdq;
    }

    public boolean cIl() {
        return this.jSS;
    }

    public void rj(boolean z) {
        this.jRm.rj(z);
    }

    public void JB(String str) {
        if (this.jRe != null) {
            this.jRe.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int sc(boolean z) {
        if (this.jSf == null || this.jSf.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cIm() {
        if (this.jSf != null && this.jSf.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jSf.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.jSf.setLayoutParams(layoutParams);
        }
    }

    public boolean cEp() {
        return false;
    }

    public void JC(String str) {
        this.igY.performClick();
        if (!StringUtils.isNull(str) && this.jGF.cEj() != null && this.jGF.cEj().bdv() != null && this.jGF.cEj().bdv().getInputView() != null) {
            EditText inputView = this.jGF.cEj().bdv().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cHU();
            if (configuration.orientation == 2) {
                cIe();
                cHc();
            } else {
                cHg();
            }
            if (this.jSy != null) {
                this.jSy.cEe();
            }
            this.jGF.bVo();
            this.jRr.setVisibility(8);
            this.jRd.sn(false);
            this.jGF.ry(false);
            if (this.jRj != null) {
                if (configuration.orientation == 1) {
                    cIj().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.jRh.setIsLandscape(true);
                    this.jRh.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.jRh.setIsLandscape(false);
                    if (this.jTc > 0) {
                        this.jRh.smoothScrollBy(this.jTc, 0);
                    }
                }
                this.jRj.onConfigurationChanged(configuration);
                this.jSg.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void sd(boolean z) {
        if (this.jRj != null) {
            this.jRj.sd(z);
        }
    }

    public boolean cIn() {
        return this.jRj != null && this.jRj.cIn();
    }

    public void cIo() {
        if (this.jRj != null) {
            this.jRj.cIo();
        }
    }

    public void rn(boolean z) {
        this.jRs.rn(z);
    }

    public void cJ(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.jRQ.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.jGF.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.jSI = new TextView(this.jGF.getContext());
            this.jSI.setText(R.string.connection_tips);
            this.jSI.setGravity(17);
            this.jSI.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jGF.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.jGF.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.jGF.getContext(), R.dimen.ds60);
            if (this.jSI.getParent() == null) {
                frameLayout.addView(this.jSI, layoutParams);
            }
            this.jSH = new PopupWindow(this.jGF.getContext());
            this.jSH.setContentView(frameLayout);
            this.jSH.setHeight(-2);
            this.jSH.setWidth(-2);
            this.jSH.setFocusable(true);
            this.jSH.setOutsideTouchable(false);
            this.jSH.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.jRh.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        av.this.jSH.showAsDropDown(av.this.jRQ, view.getLeft(), -av.this.jRQ.getHeight());
                    } else {
                        av.this.jSH.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void se(boolean z) {
        this.jSN = z;
    }

    public boolean cIp() {
        return this.jSN;
    }

    public PbThreadPostView cIq() {
        return this.jRi;
    }

    private void ai(boolean z, boolean z2) {
        aj(z, z2);
        if (this.jHO != null && this.jHO.cCi() != null && this.jHO.cCi().aQM() == 0 && !this.jHO.cCi().aPk()) {
            ak(z, z2);
        } else if (this.jRs != null && this.jRs.cEb() != null) {
            this.jRs.cEb().b(this.jHO, z, z2);
        }
    }

    private void aj(boolean z, boolean z2) {
        this.jRm.d(this.jHO, z, z2);
    }

    private void ak(boolean z, boolean z2) {
        this.jRl.c(this.jHO, z, z2);
    }
}
