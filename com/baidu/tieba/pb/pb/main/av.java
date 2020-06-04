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
    private NoNetworkView fay;
    private List<CustomBlueCheckRadioButton> gGC;
    private NavigationBarCoverTip hOn;
    private com.baidu.tieba.NEGFeedBack.e hRk;
    private View.OnClickListener hpF;
    private PbListView htT;
    private TextView ihL;
    private boolean isLandscape;
    private PbFragment jHL;
    private View.OnClickListener jIK;
    private com.baidu.tieba.pb.data.e jIU;
    private PbFakeFloorModel jKZ;
    PbFragment.c jMI;
    private View jSE;
    private View jST;
    private View jSV;
    private View jSW;
    private LinearLayout jSX;
    private HeadImageView jSY;
    private ImageView jSZ;
    public int jSh;
    public final com.baidu.tieba.pb.pb.main.view.c jSj;
    public com.baidu.tieba.pb.pb.main.view.b jSk;
    private ViewStub jSl;
    private ViewStub jSm;
    private PbLandscapeListView jSn;
    private PbThreadPostView jSo;
    private com.baidu.tieba.pb.pb.main.a.e jSp;
    private com.baidu.tieba.pb.pb.main.a.a jSq;
    private com.baidu.tieba.pb.pb.main.a.c jSr;
    private com.baidu.tieba.pb.pb.main.a.d jSs;
    private com.baidu.tieba.pb.pb.main.a.b jSt;
    private LinearLayout jSu;
    private TextView jSv;
    private TextView jSw;
    private ObservedChangeRelativeLayout jSx;
    private g jSy;
    private int jTC;
    private Runnable jTD;
    private t jTE;
    private ar jTF;
    private int jTL;
    private PbTopTipView jTM;
    private PopupWindow jTN;
    private TextView jTO;
    private List<String> jTP;
    private com.baidu.tieba.pb.pb.main.emotion.c jTQ;
    private com.baidu.tieba.pb.pb.godreply.a jTR;
    private PbLandscapeListView.b jTS;
    private ah jTU;
    private String jTV;
    private long jTW;
    private boolean jTY;
    private ImageView jTa;
    private ImageView jTb;
    private com.baidu.tieba.pb.view.c jTc;
    private TextView jTd;
    private TextView jTe;
    private int jTg;
    private int jTh;
    private PostData jTi;
    private ViewStub jTk;
    private PbInterviewStatusView jTl;
    private FrameLayout jTm;
    private View jTn;
    private View jTo;
    private aq jTp;
    private PbEmotionBar jTu;
    private Runnable jUc;
    private PbFragment.b jUe;
    public int jUi;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int jTq = UtilHelper.getLightStatusBarHeight();
    public static int jTw = 3;
    public static int jTx = 0;
    public static int jTy = 3;
    public static int jTz = 4;
    public static int jTA = 5;
    public static int jTB = 6;
    private static a.InterfaceC0727a jTX = new a.InterfaceC0727a() { // from class: com.baidu.tieba.pb.pb.main.av.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0727a
        public void onRefresh() {
        }
    };
    private int jSi = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a jSz = null;
    private com.baidu.tbadk.core.dialog.b hpE = null;
    private View jSA = null;
    private EditText jSB = null;
    private com.baidu.tieba.pb.view.d jSC = null;
    private com.baidu.tieba.pb.view.a jSD = null;
    private b.a iEv = null;
    private TbRichTextView.i eBN = null;
    private NoNetworkView.a hkP = null;
    private com.baidu.tbadk.core.dialog.i jSF = null;
    private com.baidu.tbadk.core.dialog.a jSG = null;
    private Dialog jSH = null;
    private Dialog jSI = null;
    private View jSJ = null;
    private LinearLayout jSK = null;
    private CompoundButton.OnCheckedChangeListener gGD = null;
    private TextView jSL = null;
    private TextView jSM = null;
    private String jSN = null;
    private com.baidu.tbadk.core.dialog.i jLK = null;
    private com.baidu.tbadk.core.dialog.i jSO = null;
    private boolean jSP = false;
    private boolean jSQ = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView jSR = null;
    private boolean jSS = false;
    private Button jSU = null;
    private boolean jTf = true;
    private com.baidu.tbadk.core.view.a gKA = null;
    private boolean jIC = false;
    private int mSkinType = 3;
    private boolean jTj = false;
    private int jTr = 0;
    private boolean jTs = true;
    public a jTt = new a();
    private int jTv = 0;
    private boolean jTG = false;
    private int jTH = 0;
    private boolean jTI = false;
    private boolean jTJ = false;
    private boolean jTK = false;
    private boolean jTT = false;
    private String jTZ = null;
    private CustomMessageListener jUa = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.av.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                av.this.jTZ = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.av.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && av.this.jSy != null) {
                av.this.jSy.notifyDataSetChanged();
            }
        }
    };
    private Handler jUb = new Handler();
    private CustomMessageListener jUd = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.av.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                av.this.jTf = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean jUf = true;
    View.OnClickListener jUg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || av.this.jIU == null || av.this.jIU.cCy() == null || av.this.jIU.cCy().aQx() == null || av.this.jIU.cCy().aQx().getAlaInfo() == null || av.this.jIU.cCy().aQx().getAlaInfo().live_status != 1) {
                if (av.this.jTI) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").ag("obj_id", 2));
                }
                if (!av.this.jTI && av.this.jIU != null && av.this.jIU.cCy() != null && av.this.jIU.cCy().aQx() != null && av.this.jIU.cCy().aQx().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").ag("obj_locate", 1));
                }
                if (av.this.jHL.cFs() != null) {
                    av.this.jHL.cFs().jHX.gWU.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            if (av.this.jIU.cCy().aQx().getAlaInfo() == null || !av.this.jIU.cCy().aQx().getAlaInfo().isChushou) {
                if (av.this.jIU.cCy().aQx().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = av.this.jIU.cCy().aQx().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(av.this.jHL.cFs(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ba.aVa().b(av.this.jHL.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + av.this.jIU.cCy().aQx().getAlaInfo().thirdRoomId + "&livetype=" + av.this.jIU.cCy().aQx().getAlaInfo().thirdLiveType});
        }
    };
    private boolean aOK = false;
    String userId = null;
    private final List<TbImageView> jUh = new ArrayList();
    private boolean jUj = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public aq jUx;
        public int jyZ;
    }

    public void rO(boolean z) {
        this.jTG = z;
        if (this.jSn != null) {
            this.jTH = this.jSn.getHeaderViewsCount();
        }
    }

    public void cHq() {
        if (this.jSn != null) {
            int headerViewsCount = this.jSn.getHeaderViewsCount() - this.jTH;
            final int firstVisiblePosition = (this.jSn.getFirstVisiblePosition() == 0 || this.jSn.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.jSn.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.jSn.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.jTt.jUx = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jTt));
            final aq aqVar = this.jTt.jUx;
            final int g = g(aqVar);
            final int y = ((int) this.jSx.getY()) + this.jSx.getMeasuredHeight();
            final boolean z = this.jTn.getVisibility() == 0;
            boolean z2 = this.jSx.getY() < 0.0f;
            if ((z && aqVar != null) || firstVisiblePosition >= this.jSy.cEm() + this.jSn.getHeaderViewsCount()) {
                int measuredHeight = aqVar != null ? aqVar.jRH.getMeasuredHeight() : 0;
                if (z2) {
                    this.jSn.setSelectionFromTop(this.jSy.cEm() + this.jSn.getHeaderViewsCount(), jTq - measuredHeight);
                } else {
                    this.jSn.setSelectionFromTop(this.jSy.cEm() + this.jSn.getHeaderViewsCount(), this.jSj.cJm().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.jSn.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.jTI && this.jSp != null) {
                this.jSn.setSelectionFromTop(this.jSy.cEm() + this.jSn.getHeaderViewsCount(), this.jSp.cIY());
            } else if (this.mType == 6) {
                this.jSn.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.av.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cFD() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= av.this.bej.getMeasuredHeight()) {
                            int g2 = av.this.g(aqVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (av.this.beU != null && (layoutParams = av.this.beU.getLayoutParams()) != null) {
                                if (i == 0 || i > av.this.bej.getMeasuredHeight() || g2 >= av.this.bej.getMeasuredHeight()) {
                                    layoutParams.height = av.this.jTC;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > av.this.bej.getMeasuredHeight()) {
                                    layoutParams.height = av.this.jTC;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    av.this.jSn.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                av.this.beU.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (av.this.beU != null && av.this.beU.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = av.this.beU.getLayoutParams();
                                            layoutParams2.height = av.this.jTC;
                                            av.this.beU.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        av.this.jSn.setOnLayoutListener(null);
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

    public NoNetworkView cHr() {
        return this.fay;
    }

    public void cHs() {
        if (this.Zt != null) {
            this.Zt.hide();
            if (this.jTQ != null) {
                this.jTQ.cJa();
            }
        }
    }

    public PbFakeFloorModel cHt() {
        return this.jKZ;
    }

    public t cHu() {
        return this.jTE;
    }

    public com.baidu.tieba.pb.pb.main.a.e cHv() {
        return this.jSp;
    }

    public void cHw() {
        reset();
        cHs();
        this.jTE.cEu();
        sa(false);
    }

    private void reset() {
        if (this.jHL != null && this.jHL.cEz() != null && this.Zt != null) {
            com.baidu.tbadk.editortools.pb.a.bdt().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cEz = this.jHL.cEz();
            cEz.bdN();
            cEz.bdh();
            if (cEz.getWriteImagesInfo() != null) {
                cEz.getWriteImagesInfo().setMaxImagesAllowed(cEz.isBJH ? 1 : 9);
            }
            cEz.nn(SendView.ALL);
            cEz.no(SendView.ALL);
            com.baidu.tbadk.editortools.g ne = this.Zt.ne(23);
            com.baidu.tbadk.editortools.g ne2 = this.Zt.ne(2);
            com.baidu.tbadk.editortools.g ne3 = this.Zt.ne(5);
            if (ne2 != null) {
                ne2.display();
            }
            if (ne3 != null) {
                ne3.display();
            }
            if (ne != null) {
                ne.hide();
            }
            this.Zt.invalidate();
        }
    }

    public boolean cHx() {
        return this.jTf;
    }

    public void rP(boolean z) {
        if (this.jSW != null && this.ihL != null) {
            this.ihL.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jSW.startAnimation(alphaAnimation);
            }
            this.jSV.setVisibility(0);
            this.jSW.setVisibility(0);
            this.jTf = true;
            if (this.jTu != null && !this.jTR.isActive()) {
                this.jTu.setVisibility(0);
                rU(true);
            }
        }
    }

    public void rQ(boolean z) {
        if (this.jSW != null && this.ihL != null) {
            this.ihL.setText(cHy());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jSW.startAnimation(alphaAnimation);
            }
            this.jSV.setVisibility(0);
            this.jSW.setVisibility(0);
            this.jTf = true;
            if (this.jTu != null && !this.jTR.isActive()) {
                this.jTu.setVisibility(0);
                rU(true);
            }
        }
    }

    public String cHy() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.jTV)) {
            return this.jTV;
        }
        if (this.jHL != null) {
            this.jTV = TbadkCoreApplication.getInst().getResources().getString(au.cHn());
        }
        return this.jTV;
    }

    public PostData cHz() {
        int i = 0;
        if (this.jSn == null) {
            return null;
        }
        int cHA = cHA() - this.jSn.getHeaderViewsCount();
        if (cHA < 0) {
            cHA = 0;
        }
        if (this.jSy.Ab(cHA) != null && this.jSy.Ab(cHA) != PostData.llR) {
            i = cHA + 1;
        }
        return this.jSy.getItem(i) instanceof PostData ? (PostData) this.jSy.getItem(i) : null;
    }

    public int cHA() {
        int i;
        View childAt;
        if (this.jSn == null) {
            return 0;
        }
        int firstVisiblePosition = this.jSn.getFirstVisiblePosition();
        int lastVisiblePosition = this.jSn.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.jSn.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.jSn.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cHB() {
        return this.jSn.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.jIU != null && this.jIU.cCA() != null && !this.jIU.cCA().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.jIU.cCA().size() && (postData = this.jIU.cCA().get(i)) != null && postData.aQx() != null && !StringUtils.isNull(postData.aQx().getUserId()); i++) {
                if (this.jIU.cCA().get(i).aQx().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.jTR != null && this.jTR.isActive()) {
                        sa(false);
                    }
                    if (this.jTu != null) {
                        this.jTu.sj(true);
                    }
                    this.jTZ = postData.aQx().getName_show();
                    return;
                }
            }
        }
    }

    public av(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.jHL = null;
        this.bej = null;
        this.bdq = null;
        this.jSn = null;
        this.jSy = null;
        this.htT = null;
        this.erl = null;
        this.hpF = null;
        this.jIK = null;
        this.jSW = null;
        this.ihL = null;
        this.jTk = null;
        this.jTL = 0;
        this.jTW = 0L;
        this.jTW = System.currentTimeMillis();
        this.jHL = pbFragment;
        this.hpF = onClickListener;
        this.efF = cVar;
        this.jTL = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jHL.getContext()) / 2;
        this.bej = (RelativeLayout) LayoutInflater.from(this.jHL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bej.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.jST = this.bej.findViewById(R.id.bottom_shadow);
        this.hOn = (NavigationBarCoverTip) this.bej.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bdq = this.bej.findViewById(R.id.statebar_view);
        this.jSx = (ObservedChangeRelativeLayout) this.bej.findViewById(R.id.title_wrapper);
        this.fay = (NoNetworkView) this.bej.findViewById(R.id.view_no_network);
        this.jSn = (PbLandscapeListView) this.bej.findViewById(R.id.new_pb_list);
        this.jTm = (FrameLayout) this.bej.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.jHL.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.jHL.getActivity(), R.dimen.ds88));
        this.jSn.addHeaderView(this.textView, 0);
        this.jSn.setTextViewAdded(true);
        this.jTC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.beU = new View(this.jHL.getPageContext().getPageActivity());
        this.beU.setLayoutParams(new AbsListView.LayoutParams(-1, this.jTC));
        this.beU.setVisibility(4);
        this.jSn.addFooterView(this.beU);
        this.jSn.setOnTouchListener(this.jHL.evw);
        this.jSj = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bej);
        if (this.jHL.cFc()) {
            this.jSl = (ViewStub) this.bej.findViewById(R.id.manga_view_stub);
            this.jSl.setVisibility(0);
            this.jSk = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.jSk.show();
            this.jSj.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.jHL.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.jSj.cJm().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0682a() { // from class: com.baidu.tieba.pb.pb.main.av.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0682a
            public void cDy() {
                if (av.this.jSn != null) {
                    if (av.this.jSp != null) {
                        av.this.jSp.cIX();
                    }
                    av.this.jSn.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0682a
            public void cDz() {
                av.this.jHL.bVq();
            }
        }));
        this.jSV = this.bej.findViewById(R.id.view_comment_top_line);
        this.jSW = this.bej.findViewById(R.id.pb_editor_tool_comment);
        this.jTg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jTh = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.jSY = (HeadImageView) this.bej.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.jSY.setVisibility(com.baidu.tbadk.a.d.aMt() ? 0 : 8);
        if (com.baidu.tbadk.a.d.aMt()) {
            this.jSY.setIsRound(true);
            this.jSY.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.jHL.getContext(), R.dimen.tbds1));
            this.jSY.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_border_a));
            this.jSY.setPlaceHolder(1);
            this.jSY.setDefaultResource(R.color.cp_bg_line_e);
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.jSY.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            }
        }
        this.ihL = (TextView) this.bej.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.jSX = (LinearLayout) this.bej.findViewById(R.id.pb_editer_tool_comment_layout);
        this.jSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                av.this.jHL.cEK();
                if (av.this.jHL != null && av.this.jHL.cDO() != null && av.this.jHL.cDO().getPbData() != null && av.this.jHL.cDO().getPbData().cCy() != null && av.this.jHL.cDO().getPbData().cCy().aQx() != null) {
                    if (com.baidu.tbadk.a.d.aMt()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13701").dh("tid", av.this.jHL.cDO().cFK()).dh("fid", av.this.jHL.cDO().getPbData().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").dh("tid", av.this.jHL.cDO().jOs).dh("fid", av.this.jHL.cDO().getPbData().getForumId()).ag("obj_locate", 1).dh("uid", av.this.jHL.cDO().getPbData().cCy().aQx().getUserId()));
                }
            }
        });
        this.jSZ = (ImageView) this.bej.findViewById(R.id.pb_editor_tool_comment_icon);
        this.jSZ.setOnClickListener(this.hpF);
        boolean booleanExtra = this.jHL.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.jTa = (ImageView) this.bej.findViewById(R.id.pb_editor_tool_collection);
        this.jTa.setOnClickListener(this.hpF);
        if (booleanExtra) {
            this.jTa.setVisibility(8);
        } else {
            this.jTa.setVisibility(0);
        }
        this.jTb = (ImageView) this.bej.findViewById(R.id.pb_editor_tool_share);
        this.jTb.setOnClickListener(this.hpF);
        this.jTc = new com.baidu.tieba.pb.view.c(this.jTb);
        this.jTc.cMv();
        if (com.baidu.tbadk.a.d.aMt()) {
            this.jTd = (TextView) this.bej.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.jTd.setVisibility(0);
        } else {
            this.jTe = (TextView) this.bej.findViewById(R.id.pb_editor_tool_comment_number);
            this.jTe.setVisibility(0);
        }
        this.jTk = (ViewStub) this.bej.findViewById(R.id.interview_status_stub);
        this.jSq = new com.baidu.tieba.pb.pb.main.a.a(this.jHL, cVar);
        this.jSs = new com.baidu.tieba.pb.pb.main.a.d(this.jHL, cVar, this.hpF);
        this.jSy = new g(this.jHL, this.jSn);
        this.jSy.D(this.hpF);
        this.jSy.setTbGestureDetector(this.efF);
        this.jSy.setOnImageClickListener(this.eBN);
        this.jSy.setOnSwitchChangeListener(this.jHL.jMC);
        this.jIK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.27
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
                            av.this.jHL.c(sparseArray);
                            return;
                        }
                        av.this.cI(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        av.this.jHL.c(sparseArray);
                    } else if (booleanValue3) {
                        av.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.jSy.Q(this.jIK);
        cHG();
        cHH();
        this.jSs.b(this.jSn);
        this.jSr.b(this.jSn);
        this.jSq.b(this.jSn);
        this.htT = new PbListView(this.jHL.getPageContext().getPageActivity());
        this.erl = this.htT.getView().findViewById(R.id.pb_more_view);
        if (this.erl != null) {
            this.erl.setOnClickListener(this.hpF);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.erl, R.drawable.pb_foot_more_trans_selector);
        }
        this.htT.setLineVisible();
        this.htT.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.htT.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jSE = this.bej.findViewById(R.id.viewstub_progress);
        this.jHL.registerListener(this.jUd);
        this.jKZ = new PbFakeFloorModel(this.jHL.getPageContext());
        this.jTE = new t(this.jHL.getPageContext(), this.jKZ, this.bej);
        this.jTE.a(this.jHL.jMD);
        this.jKZ.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.av.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                av.this.jKZ.t(postData);
                av.this.jSy.notifyDataSetChanged();
                av.this.jTE.cEu();
                av.this.Zt.bbA();
                av.this.sa(false);
            }
        });
        if (this.jHL.cDO() != null && !StringUtils.isNull(this.jHL.cDO().cGs())) {
            this.jHL.showToast(this.jHL.cDO().cGs());
        }
        this.jTn = this.bej.findViewById(R.id.pb_expand_blank_view);
        this.jTo = this.bej.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jTo.getLayoutParams();
        if (this.jHL.cDO() != null && this.jHL.cDO().cFN()) {
            this.jTn.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.jTo.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = jTq;
            this.jTo.setLayoutParams(layoutParams2);
        }
        this.jTp = new aq(this.jHL.getPageContext(), this.bej.findViewById(R.id.pb_reply_expand_view));
        this.jTp.v(pbFragment.jLA);
        this.jTp.jRH.setVisibility(8);
        this.jTp.R(this.hpF);
        this.jTp.setOnSwitchChangeListener(this.jHL.jMC);
        this.jHL.registerListener(this.mAccountChangedListener);
        this.jHL.registerListener(this.jUa);
        cHC();
        rU(false);
    }

    public void rR(boolean z) {
        this.jST.setVisibility(z ? 0 : 8);
    }

    public void cgX() {
        if (!this.jHL.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").ag("obj_locate", 2).dh("fid", this.mForumId));
        } else if (this.jHL.cEM()) {
            com.baidu.tbadk.editortools.pb.e cEz = this.jHL.cEz();
            if (cEz != null && (cEz.bdK() || cEz.bdL())) {
                this.jHL.cEz().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Zt != null) {
                cHM();
            }
            if (this.Zt != null) {
                this.jTf = false;
                if (this.Zt.nh(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.jHL.getPageContext(), (View) this.Zt.nh(2).ekV, false, jTX);
                }
            }
            cIu();
        }
    }

    private void cHC() {
        this.jTR = new com.baidu.tieba.pb.pb.godreply.a(this.jHL, this, (ViewStub) this.bej.findViewById(R.id.more_god_reply_popup));
        this.jTR.y(this.hpF);
        this.jTR.Q(this.jIK);
        this.jTR.setOnImageClickListener(this.eBN);
        this.jTR.y(this.hpF);
        this.jTR.setTbGestureDetector(this.efF);
    }

    public com.baidu.tieba.pb.pb.godreply.a cHD() {
        return this.jTR;
    }

    public View cHE() {
        return this.jTn;
    }

    public void cHF() {
        if (this.jSn != null) {
            this.jSr.c(this.jSn);
            this.jSs.c(this.jSn);
            this.jSt.c(this.jSn);
            this.jSq.c(this.jSn);
        }
    }

    private void cHG() {
        if (this.jSt == null) {
            this.jSt = new com.baidu.tieba.pb.pb.main.a.b(this.jHL, this.hpF);
        }
    }

    private void cHH() {
        if (this.jSr == null) {
            this.jSr = new com.baidu.tieba.pb.pb.main.a.c(this.jHL, this.efF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHI() {
        if (this.jHL.cFc()) {
            this.jSm = (ViewStub) this.bej.findViewById(R.id.manga_mention_controller_view_stub);
            this.jSm.setVisibility(0);
            if (this.jSu == null) {
                this.jSu = (LinearLayout) this.bej.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.jHL.getPageContext(), this.jSu);
            }
            if (this.jSv == null) {
                this.jSv = (TextView) this.jSu.findViewById(R.id.manga_prev_btn);
            }
            if (this.jSw == null) {
                this.jSw = (TextView) this.jSu.findViewById(R.id.manga_next_btn);
            }
            this.jSv.setOnClickListener(this.hpF);
            this.jSw.setOnClickListener(this.hpF);
        }
    }

    private void cHJ() {
        if (this.jHL.cFc()) {
            if (this.jHL.cFf() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jSv, R.color.cp_cont_e, 1);
            }
            if (this.jHL.cFg() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jSw, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cHK() {
        if (this.jSu == null) {
            cHI();
        }
        this.jSm.setVisibility(8);
        if (this.jUb != null && this.jUc != null) {
            this.jUb.removeCallbacks(this.jUc);
        }
    }

    public void cHL() {
        if (this.jUb != null) {
            if (this.jUc != null) {
                this.jUb.removeCallbacks(this.jUc);
            }
            this.jUc = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.3
                @Override // java.lang.Runnable
                public void run() {
                    if (av.this.jSu == null) {
                        av.this.cHI();
                    }
                    av.this.jSm.setVisibility(0);
                }
            };
            this.jUb.postDelayed(this.jUc, 2000L);
        }
    }

    public void rS(boolean z) {
        this.jSj.rS(z);
        if (z && this.jTj) {
            this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jSn.setNextPage(this.htT);
            this.jSi = 2;
        }
        if (com.baidu.tbadk.a.d.aMt() && this.jSY != null) {
            this.jSY.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
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
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aYd() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aYd() == EmotionGroupType.USER_COLLECT) {
                        if (av.this.mPermissionJudgePolicy == null) {
                            av.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        av.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        av.this.mPermissionJudgePolicy.appendRequestPermission(av.this.jHL.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!av.this.mPermissionJudgePolicy.startRequestPermission(av.this.jHL.getBaseFragmentActivity())) {
                            av.this.jHL.cEz().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            av.this.jHL.cEz().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cHs();
        this.jHL.cEz().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.av.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (av.this.Zt != null && av.this.Zt.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (av.this.jTQ == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, av.this.Zt.getId());
                            av.this.jTQ = new com.baidu.tieba.pb.pb.main.emotion.c(av.this.jHL.getPageContext(), av.this.bej, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(av.this.jTP)) {
                                av.this.jTQ.setData(av.this.jTP);
                            }
                            av.this.jTQ.b(av.this.Zt);
                        }
                        av.this.jTQ.JH(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (av.this.jHL.jLJ != null && av.this.jHL.jLJ.cIJ() != null) {
                    if (!av.this.jHL.jLJ.cIJ().dmy()) {
                        av.this.jHL.jLJ.sf(false);
                    }
                    av.this.jHL.jLJ.cIJ().vn(false);
                }
            }
        });
    }

    public void cHM() {
        if (this.jHL != null && this.Zt != null) {
            this.Zt.display();
            if (this.jHL.cEz() != null) {
                this.jHL.cEz().bdA();
            }
            cIu();
        }
    }

    public void rT(boolean z) {
        if (this.jSn != null && this.textView != null && this.bdq != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bdq.setVisibility(0);
                } else {
                    this.bdq.setVisibility(8);
                    this.jSn.removeHeaderView(this.textView);
                    this.jSn.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = jTq;
                    this.textView.setLayoutParams(layoutParams);
                }
                cIa();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + sc(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cIa();
            cIC();
        }
    }

    public g cHN() {
        return this.jSy;
    }

    public void a(PbFragment.c cVar) {
        this.jMI = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jHL.getContext());
        kVar.setTitleText(this.jHL.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.jSF.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            av.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (av.this.jUe != null) {
                                av.this.jUe.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            av.this.jHL.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.jHL.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.jHL.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cIB()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.jHL.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.jHL.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.jHL.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aD(arrayList);
        if (this.jSF == null) {
            this.jSF = new com.baidu.tbadk.core.dialog.i(this.jHL.getPageContext(), kVar);
        } else {
            this.jSF.a(kVar);
        }
        this.jSF.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.jUe = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.jHL != null && aVar != null) {
            if (this.hRk == null && this.jSq != null) {
                this.hRk = new com.baidu.tieba.NEGFeedBack.e(this.jHL.getPageContext(), this.jSq.cIT());
            }
            AntiData bUc = this.jHL.bUc();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bUc != null && bUc.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUc.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.setFeedBackReasonMap(sparseArray);
            this.hRk.setDefaultReasonArray(new String[]{this.jHL.getString(R.string.delete_thread_reason_1), this.jHL.getString(R.string.delete_thread_reason_2), this.jHL.getString(R.string.delete_thread_reason_3), this.jHL.getString(R.string.delete_thread_reason_4), this.jHL.getString(R.string.delete_thread_reason_5)});
            this.hRk.setData(akVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.hRk.zj(str);
            this.hRk.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.av.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    av.this.jHL.a(aVar, jSONArray);
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
        sparseArray.put(jTx, Integer.valueOf(jTy));
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
        this.jSG = new com.baidu.tbadk.core.dialog.a(this.jHL.getActivity());
        if (StringUtils.isNull(str2)) {
            this.jSG.kF(i3);
        } else {
            this.jSG.setOnlyMessageShowCenter(false);
            this.jSG.vO(str2);
        }
        this.jSG.setYesButtonTag(sparseArray);
        this.jSG.a(R.string.dialog_ok, this.jHL);
        this.jSG.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jSG.gW(true);
        this.jSG.b(this.jHL.getPageContext());
        if (z) {
            this.jSG.aST();
        } else {
            a(this.jSG, i);
        }
    }

    public void aP(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.jSJ == null) {
            this.jSJ = LayoutInflater.from(this.jHL.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.jHL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jSJ);
        if (this.jSI == null) {
            this.jSI = new Dialog(this.jHL.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jSI.setCanceledOnTouchOutside(true);
            this.jSI.setCancelable(true);
            this.jSR = (ScrollView) this.jSJ.findViewById(R.id.good_scroll);
            this.jSI.setContentView(this.jSJ);
            WindowManager.LayoutParams attributes = this.jSI.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.jSI.getWindow().setAttributes(attributes);
            this.gGD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.av.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        av.this.jSN = (String) compoundButton.getTag();
                        if (av.this.gGC != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : av.this.gGC) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && av.this.jSN != null && !str.equals(av.this.jSN)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.jSK = (LinearLayout) this.jSJ.findViewById(R.id.good_class_group);
            this.jSM = (TextView) this.jSJ.findViewById(R.id.dialog_button_cancel);
            this.jSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (av.this.jSI instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(av.this.jSI, av.this.jHL.getPageContext());
                    }
                }
            });
            this.jSL = (TextView) this.jSJ.findViewById(R.id.dialog_button_ok);
            this.jSL.setOnClickListener(this.hpF);
        }
        this.jSK.removeAllViews();
        this.gGC = new ArrayList();
        CustomBlueCheckRadioButton eT = eT("0", this.jHL.getPageContext().getString(R.string.thread_good_class));
        this.gGC.add(eT);
        eT.setChecked(true);
        this.jSK.addView(eT);
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
                    this.gGC.add(eT2);
                    View view = new View(this.jHL.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.jSK.addView(view);
                    this.jSK.addView(eT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.jSR.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jHL.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jHL.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.jHL.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.jSR.setLayoutParams(layoutParams2);
            this.jSR.removeAllViews();
            if (this.jSK != null && this.jSK.getParent() == null) {
                this.jSR.addView(this.jSK);
            }
        }
        com.baidu.adp.lib.f.g.a(this.jSI, this.jHL.getPageContext());
    }

    private CustomBlueCheckRadioButton eT(String str, String str2) {
        Activity pageActivity = this.jHL.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gGD);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cHO() {
        this.jHL.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.jHL.hideProgressBar();
        if (z && z2) {
            this.jHL.showToast(this.jHL.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.jHL.showToast(str);
        }
    }

    public void cnR() {
        this.jSE.setVisibility(0);
    }

    public void cnQ() {
        this.jSE.setVisibility(8);
    }

    public View cHP() {
        if (this.jSJ != null) {
            return this.jSJ.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cHQ() {
        return this.jSN;
    }

    public View getView() {
        return this.bej;
    }

    public void cHR() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.jHL.getPageContext().getPageActivity(), this.jHL.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.jHL.hideProgressBar();
        if (z) {
            cIk();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cIl();
        } else {
            cIk();
        }
    }

    public void cHS() {
        this.htT.setLineVisible();
        this.htT.startLoadData();
    }

    public void cHT() {
        this.jHL.hideProgressBar();
        endLoadData();
        this.jSn.completePullRefreshPostDelayed(0L);
        cIf();
    }

    public void cHU() {
        this.jSn.completePullRefreshPostDelayed(0L);
        cIf();
    }

    private void rU(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.jSs.b(onLongClickListener);
        this.jSy.setOnLongClickListener(onLongClickListener);
        if (this.jTR != null) {
            this.jTR.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.jLK != null) {
            this.jLK.dismiss();
            this.jLK = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jHL.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.jHL.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jHL.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jHL.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jHL.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aD(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.jSO.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jSO = new com.baidu.tbadk.core.dialog.i(this.jHL.getPageContext(), kVar);
        this.jSO.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.jSO != null) {
            this.jSO.dismiss();
            this.jSO = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.jHL.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.jIU != null && this.jIU.cCy() != null && !this.jIU.cCy().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.jHL.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.jHL.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aD(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.jSO.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jSO = new com.baidu.tbadk.core.dialog.i(this.jHL.getPageContext(), kVar);
        this.jSO.showDialog();
    }

    public int cHV() {
        return Az(this.jSn.getFirstVisiblePosition());
    }

    private int Az(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.jSn.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.jSn.getAdapter() == null || !(this.jSn.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.jSn.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cHW() {
        int lastVisiblePosition = this.jSn.getLastVisiblePosition();
        if (this.jSp != null) {
            if (lastVisiblePosition == this.jSn.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Az(lastVisiblePosition);
    }

    public void AA(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.jSn != null) {
            if (this.jSj == null || this.jSj.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.jSj.mNavigationBar.getFixedNavHeight();
                if (this.jHL.cES() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.jTo != null && (layoutParams = (LinearLayout.LayoutParams) this.jTo.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.jTo.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.jSn.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.jSn.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.jSn.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.jSB.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void r(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.jSy.a(eVar, false);
        this.jSy.notifyDataSetChanged();
        cIf();
        if (this.jTR != null) {
            this.jTR.cDK();
        }
        ArrayList<PostData> cCA = eVar.cCA();
        if (eVar.getPage().aPt() == 0 || cCA == null || cCA.size() < eVar.getPage().aPs()) {
            if (com.baidu.tbadk.core.util.v.getCount(cCA) == 0 || (com.baidu.tbadk.core.util.v.getCount(cCA) == 1 && cCA.get(0) != null && cCA.get(0).ddJ() == 1)) {
                if (this.jTt == null || this.jTt.jUx == null || this.jTt.jUx.getView() == null) {
                    i = 0;
                } else {
                    i = this.jTt.jUx.getView().getTop() < 0 ? this.jTt.jUx.getView().getHeight() : this.jTt.jUx.getView().getBottom();
                }
                if (this.jHL.cFm()) {
                    this.htT.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.htT.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aPt() == 0) {
                    this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.htT.aWg();
            }
        }
        t(eVar);
    }

    public void s(com.baidu.tieba.pb.data.e eVar) {
        if (this.jSq != null) {
            this.jSq.e(eVar, this.jIC);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cCL() != null) {
            return eVar.cCL();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cCA())) {
            Iterator<PostData> it = eVar.cCA().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.ddJ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cCH();
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
        if (eVar == null || eVar.cCy() == null || eVar.cCy().aQx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aQx = eVar.cCy().aQx();
        String userId = aQx.getUserId();
        HashMap<String, MetaData> userMap = eVar.cCy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aQx;
        }
        postData.DU(1);
        postData.setId(eVar.cCy().aQP());
        postData.setTitle(eVar.cCy().getTitle());
        postData.setTime(eVar.cCy().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.cCy() != null) {
            if (this.jHL.cDE()) {
                if (eVar.cCx() != null) {
                    this.mForumName = eVar.cCx().getForumName();
                    this.mForumId = eVar.cCx().getForumId();
                }
                if (this.mForumName == null && this.jHL.cDO() != null && this.jHL.cDO().cDF() != null) {
                    this.mForumName = this.jHL.cDO().cDF();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.jSs.setVisibility(8);
            if (eVar.aWj()) {
                this.jTI = true;
                this.jSj.rc(true);
                this.jSj.mNavigationBar.hideBottomLine();
                if (this.jSp == null) {
                    this.jSp = new com.baidu.tieba.pb.pb.main.a.e(this.jHL);
                }
                this.jSp.a(eVar, b, this.jSn, this.jSs, this.jTm, this.jSj, this.mForumName, this.jTW);
                this.jSp.S(this.jUg);
                cIa();
            } else {
                this.jTI = false;
                this.jSj.rc(this.jTI);
                if (this.jSp != null) {
                    this.jSp.c(this.jSn);
                }
            }
            if (this.jHL.cEC() != null) {
                this.jHL.cEC().sk(this.jTI);
            }
            if (b != null) {
                this.jTi = b;
                this.jSs.setVisibility(0);
                SparseArray<Object> cIW = this.jSs.cIW();
                cIW.put(R.id.tag_clip_board, b);
                cIW.put(R.id.tag_is_subpb, false);
                this.jSt.a(eVar, this.jSn);
                this.jSr.z(eVar);
                this.jSq.e(eVar, this.jIC);
                this.jSq.y(eVar);
                this.jSs.a(this.mSkinType, this.jIU, b, this.jUg);
                if (this.jTp != null) {
                    if (eVar.cCZ()) {
                        this.jTp.getView().setVisibility(8);
                    } else {
                        this.jTp.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jGo);
                        if (eVar.cCy() != null) {
                            lVar.jGq = eVar.cCy().aQo();
                        }
                        lVar.isNew = !this.jIC;
                        lVar.sortType = eVar.jFc;
                        lVar.jGs = eVar.cDa();
                        lVar.jGt = this.jHL.cFm();
                        lVar.jGu = eVar.jFb;
                        this.jTp.a(lVar);
                    }
                }
                if (eVar != null && eVar.cCy() != null) {
                    aj(eVar.cCy().aQt() == 1, eVar.cCy().aQs() == 1);
                }
                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (av.this.jSy != null && av.this.jSj != null && av.this.jSj.jYF != null && av.this.jIU != null && av.this.jIU.cCy() != null && !av.this.jIU.cCy().aPk() && !av.this.cIe() && av.this.jIU.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(av.this.jIU.getForum().getName())) {
                            if ((av.this.jSy.cEq() == null || !av.this.jSy.cEq().isShown()) && av.this.jSj.jYF != null) {
                                av.this.jSj.jYF.setVisibility(0);
                                if (av.this.jHL != null && av.this.jHL.cDO() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.dh("tid", av.this.jHL.cDO().cFJ());
                                    anVar.dh("fid", av.this.jHL.cDO().getForumId());
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
            cHX();
        } else {
            bPh();
        }
        this.jTt.jUx = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jTt));
        a(this.jTt.jUx, false);
    }

    public void cHX() {
        if (this.jSj != null && !this.jTK) {
            this.jSj.cHX();
            this.jTK = true;
        }
    }

    public void bPh() {
        if (this.jSj != null) {
            this.jSj.cJu();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.jSs.a(postData, eVar);
    }

    public void cHY() {
        if (this.jSp != null) {
            this.jSp.d(this.jSn);
        }
    }

    public boolean cHZ() {
        return this.aOK;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aK(bk bkVar) {
        if (bkVar == null || bkVar.aQx() == null) {
            return false;
        }
        PostData b = b(this.jIU, false);
        String str = "";
        if (b != null && b.aQx() != null) {
            str = b.aQx().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.jSj.cJs();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.jSj.Hp(dVar.forumName);
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
            final String str2 = dVar.jEU;
            this.jHL.showNetRefreshView(this.bej, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.ba.aVa().b(av.this.jHL.getPageContext(), new String[]{str2});
                        av.this.jHL.finish();
                        return;
                    }
                    av.this.jHL.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cHd;
        Parcelable cHd2;
        if (eVar != null && this.jSn != null) {
            this.jIU = eVar;
            this.mType = i;
            if (eVar.cCy() != null) {
                this.jTv = eVar.cCy().aQe();
                if (eVar.cCy().getAnchorLevel() != 0) {
                    this.aOK = true;
                }
                this.jSQ = aK(eVar.cCy());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            x(eVar);
            this.jTj = false;
            this.jIC = z;
            cHT();
            if (eVar.jFd != null && eVar.jFd.cDf()) {
                if (this.jSo == null) {
                    this.jSo = new PbThreadPostView(this.jHL.getContext());
                    this.jSn.addHeaderView(this.jSo, 1);
                    this.jSo.setData(eVar);
                    this.jSo.setChildOnClickLinstener(this.hpF);
                }
            } else if (this.jSo != null && this.jSn != null) {
                this.jSn.removeHeaderView(this.jSo);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            u(eVar);
            if (this.jTU == null) {
                this.jTU = new ah(this.jHL.getPageContext(), this.hOn);
            }
            this.jTU.Jx(eVar.cCF());
            if (this.jHL.cFc()) {
                if (this.jSC == null) {
                    this.jSC = new com.baidu.tieba.pb.view.d(this.jHL.getPageContext());
                    this.jSC.createView();
                    this.jSC.setListPullRefreshListener(this.dVt);
                }
                this.jSn.setPullRefresh(this.jSC);
                cIa();
                if (this.jSC != null) {
                    this.jSC.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aPu() == 0 && z) {
                this.jSn.setPullRefresh(null);
            } else {
                if (this.jSC == null) {
                    this.jSC = new com.baidu.tieba.pb.view.d(this.jHL.getPageContext());
                    this.jSC.createView();
                    this.jSC.setListPullRefreshListener(this.dVt);
                }
                this.jSn.setPullRefresh(this.jSC);
                cIa();
                if (this.jSC != null) {
                    this.jSC.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bGh();
            }
            cIf();
            this.jSy.rf(this.jIC);
            this.jSy.rg(false);
            this.jSy.rk(i == 5);
            this.jSy.rl(i == 6);
            this.jSy.rm(z2 && this.jUf && i != 2);
            this.jSy.a(eVar, false);
            this.jSy.notifyDataSetChanged();
            this.jSs.a(b(eVar, z), eVar.cCZ());
            if (eVar.cCy() != null && eVar.cCy().aQi() != null && this.jSh != -1) {
                eVar.cCy().aQi().setIsLike(this.jSh);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.jSn.setNextPage(this.htT);
                this.jSi = 2;
                bGh();
            } else {
                this.jTj = true;
                if (eVar.getPage().aPt() == 1) {
                    if (this.jSD == null) {
                        this.jSD = new com.baidu.tieba.pb.view.a(this.jHL, this.jHL);
                    }
                    this.jSn.setNextPage(this.jSD);
                } else {
                    this.jSn.setNextPage(this.htT);
                }
                this.jSi = 3;
            }
            ArrayList<PostData> cCA = eVar.cCA();
            if (eVar.getPage().aPt() == 0 || cCA == null || cCA.size() < eVar.getPage().aPs()) {
                if (com.baidu.tbadk.core.util.v.getCount(cCA) == 0 || (com.baidu.tbadk.core.util.v.getCount(cCA) == 1 && cCA.get(0) != null && cCA.get(0).ddJ() == 1)) {
                    if (this.jTt == null || this.jTt.jUx == null || this.jTt.jUx.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.jTt.jUx.getView().getTop() < 0 ? this.jTt.jUx.getView().getHeight() : this.jTt.jUx.getView().getBottom();
                    }
                    if (this.jHL.cFm()) {
                        this.htT.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.htT.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.jHL.cEC() != null && !this.jHL.cEC().cJg()) {
                        this.jHL.cEC().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aPt() == 0) {
                        this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.htT.aWg();
                }
                if (eVar.getPage().aPt() == 0 || cCA == null) {
                    cIp();
                }
            } else {
                if (z2) {
                    if (this.jUf) {
                        endLoadData();
                        if (eVar.getPage().aPt() != 0) {
                            this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.htT.setLineVisible();
                        this.htT.showLoading();
                    }
                } else {
                    this.htT.setLineVisible();
                    this.htT.showLoading();
                }
                this.htT.aWg();
            }
            switch (i) {
                case 2:
                    this.jSn.setSelection(i2 > 1 ? (((this.jSn.getData() == null && eVar.cCA() == null) ? 0 : (this.jSn.getData().size() - eVar.cCA().size()) + this.jSn.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cHd2 = ao.cHc().cHd()) != null && !(cHd2 instanceof RecyclerView.SavedState)) {
                        this.jSn.onRestoreInstanceState(cHd2);
                        if (com.baidu.tbadk.core.util.v.getCount(cCA) > 1 && eVar.getPage().aPt() > 0) {
                            this.htT.endLoadData();
                            this.htT.setText(this.jHL.getString(R.string.pb_load_more_without_point));
                            this.htT.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.jUf = false;
                    break;
                case 5:
                    this.jSn.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cHd = ao.cHc().cHd()) != null && !(cHd instanceof RecyclerView.SavedState)) {
                        this.jSn.onRestoreInstanceState(cHd);
                        break;
                    } else {
                        this.jSn.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.jSp != null && this.jSp.bre() != null) {
                            if (this.jHL.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.jSn.setSelectionFromTop((this.jSy.cEl() + this.jSn.getHeaderViewsCount()) - 1, this.jSp.cIY() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.jHL.getPageContext().getPageActivity()));
                            } else {
                                this.jSn.setSelectionFromTop((this.jSy.cEl() + this.jSn.getHeaderViewsCount()) - 1, this.jSp.cIY());
                            }
                        } else {
                            this.jSn.setSelection(this.jSy.cEl() + this.jSn.getHeaderViewsCount());
                        }
                    } else {
                        this.jSn.setSelection(i2 > 0 ? ((this.jSn.getData() == null && eVar.cCA() == null) ? 0 : (this.jSn.getData().size() - eVar.cCA().size()) + this.jSn.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.htT.endLoadData();
                    this.htT.setText(this.jHL.getString(R.string.pb_load_more_without_point));
                    this.htT.setLineGone();
                    break;
            }
            if (this.jTv == jTw && isHost()) {
                cIx();
            }
            if (this.jTG) {
                cHq();
                this.jTG = false;
                if (i3 == 0) {
                    rO(true);
                }
            }
            if (eVar.jEZ == 1 || eVar.jFa == 1) {
                if (this.jTM == null) {
                    this.jTM = new PbTopTipView(this.jHL.getContext());
                }
                if (eVar.jFa == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.jHL.getStType())) {
                    this.jTM.setText(this.jHL.getString(R.string.pb_read_strategy_add_experience));
                    this.jTM.a(this.bej, this.mSkinType);
                } else if (eVar.jEZ == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.jHL.getStType())) {
                    this.jTM.setText(this.jHL.getString(R.string.pb_read_news_add_experience));
                    this.jTM.a(this.bej, this.mSkinType);
                }
            }
            t(eVar);
        }
    }

    private void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCy() != null) {
            w(eVar);
            if (eVar.aML()) {
                SvgManager.aUW().a(this.jTa, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aUW().a(this.jTa, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String AB = AB(eVar.cCy().aQo());
            if (this.jTd != null) {
                this.jTd.setText(AB);
            }
            if (this.jTe != null) {
                this.jTe.setText(AB);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cCy()));
        }
    }

    private String AB(int i) {
        if (i == 0) {
            return this.jHL.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cIa() {
        if (this.jSp != null) {
            this.jSp.a(this.jSn, this.textView, this.mType);
        }
    }

    public void rW(boolean z) {
        this.jSP = z;
    }

    public void endLoadData() {
        if (this.htT != null) {
            this.htT.setLineGone();
            this.htT.endLoadData();
        }
        bGh();
    }

    public void bvO() {
        this.jSn.setVisibility(0);
    }

    public void cIb() {
        if (this.jSn != null) {
            this.jSn.setVisibility(8);
        }
        if (this.jSn != null) {
            this.jTm.setVisibility(8);
        }
        if (this.jSj != null && this.jSj.jYC != null) {
            this.jSj.jYC.setVisibility(8);
        }
    }

    public void cIc() {
        if (this.jSn != null) {
            this.jSn.setVisibility(0);
        }
        if (this.jTm != null) {
            this.jTm.setVisibility(0);
        }
        if (this.jSj != null && this.jSj.jYC != null) {
            this.jSj.jYC.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.jTi != null && this.jTi.aQx() != null && this.jSj != null) {
            this.jTJ = !this.jTI;
            this.jSj.sm(this.jTJ);
            if (this.jHL.cEC() != null) {
                this.jHL.cEC().sl(this.jTJ);
            }
            cId();
            if (this.jHL != null && !this.jHL.cDE() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cCU())) {
                bg bgVar = eVar.cCU().get(0);
                if (bgVar != null) {
                    this.jSj.eU(bgVar.getForumName(), bgVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.jSj.eU(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            this.jSj.b(eVar, this.jTi, this.jSQ);
            if (this.jTJ) {
                this.jSs.a(eVar, this.jTi, this.jSQ);
                if (this.jTo != null) {
                    this.jTo.setVisibility(8);
                }
                if (this.jTS == null) {
                    this.jTS = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.av.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (av.this.jHL != null && av.this.jHL.isAdded()) {
                                if (i < 0 && f > av.this.jTL) {
                                    av.this.cIw();
                                }
                                av.this.cHU();
                            }
                        }
                    };
                }
                this.jSn.setListViewDragListener(this.jTS);
                return;
            }
            if (this.jTo != null) {
                this.jTo.setVisibility(0);
            }
            this.jSs.a(eVar, this.jTi, this.jSQ);
            this.jTS = null;
            this.jSn.setListViewDragListener(null);
        }
    }

    private void cId() {
        this.jSs.a(this.jIU, this.jTi, this.jTJ, this.jTI);
    }

    public boolean cIe() {
        return this.jIU == null || this.jIU.getForum() == null || "0".equals(this.jIU.getForum().getId()) || "me0407".equals(this.jIU.getForum().getName());
    }

    private boolean cIf() {
        return this.jSq.sh(this.jIC);
    }

    private boolean v(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cCy() == null) {
            return false;
        }
        if (eVar.cCy().aQu() == 1 || eVar.cCy().getThreadType() == 33) {
            return true;
        }
        return !(eVar.cCy().aQw() == null || eVar.cCy().aQw().aSK() == 0) || eVar.cCy().aQs() == 1 || eVar.cCy().aQt() == 1 || eVar.cCy().aRm() || eVar.cCy().aRG() || eVar.cCy().aRz() || eVar.cCy().aQJ() != null || !com.baidu.tbadk.core.util.aq.isEmpty(eVar.cCy().getCategory()) || eVar.cCy().aQA() || eVar.cCy().aQz();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.jSr != null) {
                if (eVar.cCy() != null && eVar.cCy().aQM() == 0 && !eVar.cCy().aPk() && !this.jTY) {
                    if (eVar.cCy() != null) {
                        bk cCy = eVar.cCy();
                        cCy.v(true, v(eVar));
                        cCy.kr(3);
                        cCy.vB("2");
                    }
                    if (eVar.cCy().aPm()) {
                        this.jSs.c(this.jSn);
                        this.jSr.c(this.jSn);
                        this.jSr.b(this.jSn);
                        this.jSs.b(this.jSn);
                        this.jSs.D(this.jIU);
                        this.jSr.A(eVar);
                    } else {
                        this.jSs.D(this.jIU);
                        this.jSr.C(eVar);
                    }
                } else if (eVar.cCy().aQM() == 1) {
                    if (eVar.cCy() != null) {
                        this.jSr.c(this.jSn);
                        this.jSs.D(this.jIU);
                    }
                } else {
                    this.jSr.c(this.jSn);
                    this.jSs.D(this.jIU);
                }
            }
            if (eVar.cCy() != null) {
                ai(eVar.cCy().aQt() == 1, eVar.cCy().aQs() == 1);
            }
            this.jIC = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cIf();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cCN()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cCN()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bg> cCU = eVar.cCU();
                if (com.baidu.tbadk.core.util.v.getCount(cCU) > 0) {
                    sb = new StringBuilder();
                    for (bg bgVar : cCU) {
                        if (bgVar != null && !StringUtils.isNull(bgVar.getForumName()) && (vVar = bgVar.dEk) != null && vVar.dCh && !vVar.dCi && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bgVar.getForumName(), 12)).append(this.jHL.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.jHL.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cIg() {
        return this.erl;
    }

    public boolean cIh() {
        if (this.beU == null || this.beU.getParent() == null || this.htT.isLoading()) {
            return false;
        }
        int bottom = this.beU.getBottom();
        Rect rect = new Rect();
        this.beU.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Jz(String str) {
        if (this.htT != null) {
            this.htT.setText(str);
        }
    }

    public void JA(String str) {
        if (this.htT != null) {
            int i = 0;
            if (this.jTt != null && this.jTt.jUx != null && this.jTt.jUx.getView() != null) {
                i = this.jTt.jUx.getView().getTop() < 0 ? this.jTt.jUx.getView().getHeight() : this.jTt.jUx.getView().getBottom();
            }
            this.htT.ak(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.jSn;
    }

    public int cIi() {
        return R.id.richText;
    }

    public TextView cDY() {
        return this.jSs.cDY();
    }

    public void d(BdListView.e eVar) {
        this.jSn.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.dVt = cVar;
        if (this.jSC != null) {
            this.jSC.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar, a.b bVar) {
        if (aoVar != null) {
            int aPr = aoVar.aPr();
            int aPo = aoVar.aPo();
            if (this.jSz != null) {
                this.jSz.aST();
            } else {
                this.jSz = new com.baidu.tbadk.core.dialog.a(this.jHL.getPageContext().getPageActivity());
                this.jSA = LayoutInflater.from(this.jHL.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.jSz.aP(this.jSA);
                this.jSz.a(R.string.dialog_ok, bVar);
                this.jSz.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        av.this.cIk();
                        aVar.dismiss();
                    }
                });
                this.jSz.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.av.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (av.this.jTD == null) {
                            av.this.jTD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    av.this.jHL.HidenSoftKeyPad((InputMethodManager) av.this.jHL.getBaseFragmentActivity().getSystemService("input_method"), av.this.bej);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.ld().postDelayed(av.this.jTD, 150L);
                    }
                });
                this.jSz.b(this.jHL.getPageContext()).aST();
            }
            this.jSB = (EditText) this.jSA.findViewById(R.id.input_page_number);
            this.jSB.setText("");
            TextView textView = (TextView) this.jSA.findViewById(R.id.current_page_number);
            if (aPr <= 0) {
                aPr = 1;
            }
            if (aPo <= 0) {
                aPo = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aPr), Integer.valueOf(aPo)));
            this.jHL.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.jSB, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jSn.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.jHL.showToast(str);
    }

    public boolean rX(boolean z) {
        if (this.Zt == null || !this.Zt.bcZ()) {
            return false;
        }
        this.Zt.bbA();
        return true;
    }

    public void cIj() {
        if (this.jUh != null) {
            while (this.jUh.size() > 0) {
                TbImageView remove = this.jUh.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cIj();
        this.jSy.Ac(1);
        if (this.jSp != null) {
            this.jSp.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.jSy.Ac(2);
        if (this.jSp != null) {
            this.jSp.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.jHL.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.jHL.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.jTc != null) {
            this.jTc.onDestroy();
        }
        if (this.jTF != null) {
            this.jTF.destroy();
        }
        if (this.jTU != null) {
            this.jTU.onDestory();
        }
        if (this.jTM != null) {
            this.jTM.hide();
        }
        this.jHL.hideProgressBar();
        if (this.fay != null && this.hkP != null) {
            this.fay.b(this.hkP);
        }
        cIk();
        endLoadData();
        if (this.jTD != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jTD);
        }
        if (this.jTl != null) {
            this.jTl.clearStatus();
        }
        this.jUb = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.jSy.Ac(3);
        if (this.bdq != null) {
            this.bdq.setBackgroundDrawable(null);
        }
        if (this.jSp != null) {
            this.jSp.destroy();
        }
        if (this.jSy != null) {
            this.jSy.onDestroy();
        }
        this.jSn.setOnLayoutListener(null);
        if (this.jTQ != null) {
            this.jTQ.bXG();
        }
        if (this.jTu != null) {
            this.jTu.onDestroy();
        }
        if (this.jSs != null) {
            this.jSs.onDestroy();
        }
    }

    public boolean AC(int i) {
        if (this.jSp != null) {
            return this.jSp.AC(i);
        }
        return false;
    }

    public void cIk() {
        this.jSj.aEa();
        if (this.jSs != null) {
            this.jSs.cIk();
        }
        if (this.jHL != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.jHL.getContext(), this.jSB);
        }
        cHs();
        if (this.jLK != null) {
            this.jLK.dismiss();
        }
        cIm();
        if (this.jSz != null) {
            this.jSz.dismiss();
        }
        if (this.hpE != null) {
            this.hpE.dismiss();
        }
    }

    public void cIl() {
        this.jSj.aEa();
        if (this.jSs != null) {
            this.jSs.cIk();
        }
        if (this.jLK != null) {
            this.jLK.dismiss();
        }
        cIm();
        if (this.jSz != null) {
            this.jSz.dismiss();
        }
        if (this.hpE != null) {
            this.hpE.dismiss();
        }
    }

    public void ea(List<String> list) {
        this.jTP = list;
        if (this.jTQ != null) {
            this.jTQ.setData(list);
        }
    }

    public void re(boolean z) {
        this.jSy.re(z);
    }

    public void rY(boolean z) {
        this.jSS = z;
    }

    public void cIm() {
        if (this.jSG != null) {
            this.jSG.dismiss();
        }
        if (this.jSH != null) {
            com.baidu.adp.lib.f.g.b(this.jSH, this.jHL.getPageContext());
        }
        if (this.jSI != null) {
            com.baidu.adp.lib.f.g.b(this.jSI, this.jHL.getPageContext());
        }
        if (this.jSF != null) {
            this.jSF.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.jIU, this.jIC);
            b(this.jIU, this.jIC, this.mType, i);
            this.jHL.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.jHL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bej);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.bej, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.jST, R.drawable.personalize_tab_shadow);
            if (this.jSp != null) {
                this.jSp.onChangeSkinType(i);
            }
            if (this.jSt != null) {
                this.jSt.onChangeSkinType(i);
            }
            if (this.jSq != null) {
                this.jSq.onChangeSkinType(i);
            }
            if (this.jSr != null) {
                this.jSr.onChangeSkinType(i);
            }
            if (this.jSs != null) {
                this.jSs.onChangeSkinType(i);
            }
            if (this.htT != null) {
                this.htT.changeSkin(i);
                if (this.erl != null) {
                    this.jHL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.erl);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.erl, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.jSz != null) {
                this.jSz.c(this.jHL.getPageContext());
            }
            rW(this.jSP);
            this.jSy.notifyDataSetChanged();
            if (this.jSC != null) {
                this.jSC.changeSkin(i);
            }
            if (this.Zt != null) {
                this.Zt.onChangeSkinType(i);
            }
            if (this.jSD != null) {
                this.jSD.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.gGC)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.gGC) {
                    customBlueCheckRadioButton.aVT();
                }
            }
            cHJ();
            UtilHelper.setStatusBarBackground(this.bdq, i);
            UtilHelper.setStatusBarBackground(this.jTo, i);
            if (this.jSu != null) {
                com.baidu.tbadk.q.a.a(this.jHL.getPageContext(), this.jSu);
            }
            if (this.jTE != null) {
                this.jTE.onChangeSkinType(i);
            }
            if (this.jSj != null) {
                if (this.jSp != null) {
                    this.jSp.AD(i);
                } else {
                    this.jSj.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.ihL != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.ihL, (int) R.color.cp_cont_d);
            }
            if (this.jSY != null) {
                this.jSY.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_border_a));
            }
            if (this.jSX != null) {
                this.jSX.setBackgroundDrawable(com.baidu.tbadk.core.util.am.aE(com.baidu.adp.lib.util.l.getDimens(this.jHL.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.jTa != null && this.jIU != null) {
                if (this.jIU.aML()) {
                    SvgManager.aUW().a(this.jTa, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aUW().a(this.jTa, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            w(this.jIU);
            if (this.jSZ != null) {
                SvgManager.aUW().a(this.jSZ, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jSV != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jSV, R.drawable.bottom_shadow);
            }
            if (this.jTd != null) {
                com.baidu.tbadk.core.util.am.c(this.jTd, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jTd, (int) R.color.cp_cont_a);
            }
            if (this.jTe != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jTe, (int) R.color.cp_cont_b);
            }
            if (this.jTR != null) {
                this.jTR.onChangeSkinType(i);
            }
            if (this.jTu != null) {
                this.jTu.onChangeSkinType();
            }
            if (this.jTO != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jTO, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.jSW, R.color.cp_bg_line_h);
            if (this.jSo != null) {
                this.jSo.qk(i);
            }
            if (this.jTc != null) {
                this.jTc.onChangeSkinType();
            }
        }
    }

    public void cIn() {
        if (this.jTc != null) {
            this.jTc.setEnable(false);
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aZ(eVar.cCy())) {
            if (this.jTc != null) {
                this.jTc.setEnable(false);
                this.jTc.onDestroy();
            }
            SvgManager.aUW().a(this.jTb, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.jTc == null || !this.jTc.isEnable()) {
            SvgManager.aUW().a(this.jTb, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBN = iVar;
        this.jSy.setOnImageClickListener(this.eBN);
        this.jTR.setOnImageClickListener(this.eBN);
    }

    public void g(NoNetworkView.a aVar) {
        this.hkP = aVar;
        if (this.fay != null) {
            this.fay.a(this.hkP);
        }
    }

    public void rZ(boolean z) {
        this.jSy.setIsFromCDN(z);
    }

    public Button cIo() {
        return this.jSU;
    }

    public void cIp() {
        if (this.jSi != 2) {
            this.jSn.setNextPage(this.htT);
            this.jSi = 2;
        }
    }

    public void cIq() {
        if (com.baidu.tbadk.n.m.bfJ().bfK()) {
            int lastVisiblePosition = this.jSn.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.jSn.getChildAt(i);
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

    public boolean cIr() {
        return this.Zt != null && this.Zt.getVisibility() == 0;
    }

    public boolean cIs() {
        return this.Zt != null && this.Zt.bcZ();
    }

    public void cIt() {
        if (this.Zt != null) {
            this.Zt.bbA();
        }
    }

    public void sa(boolean z) {
        if (this.jSW != null) {
            rY(this.jHL.cEz().bdD());
            if (this.jSS) {
                rP(z);
            } else {
                rQ(z);
            }
        }
    }

    public void cIu() {
        if (this.jSW != null) {
            this.jSV.setVisibility(8);
            this.jSW.setVisibility(8);
            this.jTf = false;
            if (this.jTu != null) {
                this.jTu.setVisibility(8);
                rU(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.gKA == null) {
            this.gKA = new com.baidu.tbadk.core.view.a(this.jHL.getPageContext());
        }
        this.gKA.setDialogVisiable(true);
    }

    public void bGh() {
        if (this.gKA != null) {
            this.gKA.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.jSn.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.jSn.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.jSp != null) {
            this.jSp.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.jUi = getScrollY();
            this.jTt.jUx = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jTt));
            a(this.jTt.jUx, true);
        }
    }

    public void sb(boolean z) {
        if (this.jSp != null) {
            this.jSp.sb(z);
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
        if (this.jSp != null) {
            this.jSp.onScroll(absListView, i, i2, i3);
        }
        if (this.jSj != null && this.jSs != null) {
            this.jSj.cL(this.jSs.cIU());
        }
        this.jTt.jyZ = i;
        this.jTt.headerCount = this.jSn.getHeaderViewsCount();
        this.jTt.jUx = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.jTt));
        rR(b(absListView, i));
        a(this.jTt.jUx, false);
        if (this.htT.aWh() && !this.htT.dUN) {
            if (this.jTt != null && this.jTt.jUx != null && this.jTt.jUx.getView() != null) {
                i4 = this.jTt.jUx.getView().getTop() < 0 ? this.jTt.jUx.getView().getHeight() : this.jTt.jUx.getView().getBottom();
            }
            this.htT.lZ(i4);
            this.htT.dUN = true;
        }
    }

    public void cIv() {
        if (TbadkCoreApplication.isLogin() && this.jIU != null && this.jTJ && !this.jTI && !this.jSQ && this.jTi != null && this.jTi.aQx() != null && !this.jTi.aQx().getIsLike() && !this.jTi.aQx().hadConcerned() && this.jTF == null) {
            this.jTF = new ar(this.jHL);
        }
    }

    public void cIw() {
        if (this.jTJ && !this.jTI && this.jTi != null && this.jTi.aQx() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").ag("obj_locate", this.jHL.cDE() ? 2 : 1).ag("obj_type", this.jTI ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.jHL.getPageContext().getPageActivity(), this.jTi.aQx().getUserId(), this.jTi.aQx().getUserName(), this.jHL.cDO().cDF(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aq aqVar, boolean z) {
        int measuredHeight;
        if (!this.jTI && this.jTn != null && this.jSj.cJm() != null) {
            int cEm = this.jSy.cEm();
            if (cEm > 0 && (aqVar == null || aqVar.getView().getParent() == null)) {
                if (cEm > this.jSn.getFirstVisiblePosition() - this.jSn.getHeaderViewsCount()) {
                    this.jTn.setVisibility(4);
                    return;
                }
                this.jTn.setVisibility(0);
                rR(false);
                this.jSj.mNavigationBar.hideBottomLine();
                if (this.jTn.getParent() != null && ((ViewGroup) this.jTn.getParent()).getHeight() <= this.jTn.getTop()) {
                    this.jTn.getParent().requestLayout();
                }
            } else if (aqVar == null || aqVar.getView() == null || aqVar.jRH == null) {
                if (this.jSn.getFirstVisiblePosition() == 0) {
                    this.jTn.setVisibility(4);
                    this.jSj.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = aqVar.getView().getTop();
                if (aqVar.getView().getParent() != null) {
                    if (this.jTs) {
                        this.jTr = top2;
                        this.jTs = false;
                    }
                    this.jTr = top2 < this.jTr ? top2 : this.jTr;
                }
                if (top2 != 0 || aqVar.getView().isShown()) {
                    if (this.jSx.getY() < 0.0f) {
                        measuredHeight = jTq - aqVar.jRH.getMeasuredHeight();
                    } else {
                        measuredHeight = this.jSj.cJm().getMeasuredHeight() - aqVar.jRH.getMeasuredHeight();
                        this.jSj.mNavigationBar.hideBottomLine();
                    }
                    if (aqVar.getView().getParent() == null && top2 <= this.jTr) {
                        this.jTn.setVisibility(0);
                        rR(false);
                    } else if (top2 < measuredHeight) {
                        this.jTn.setVisibility(0);
                        rR(false);
                    } else {
                        this.jTn.setVisibility(4);
                        this.jSj.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.jTs = true;
                    }
                }
            }
        }
    }

    public void cIx() {
        if (!this.jUj) {
            TiebaStatic.log("c10490");
            this.jUj = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jHL.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(jTx, Integer.valueOf(jTz));
            aVar.kE(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.jHL.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aP(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.jHL);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jHL.getPageContext()).aST();
        }
    }

    public void JB(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jHL.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.jHL.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aP(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(jTx, Integer.valueOf(jTA));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.jHL);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.jHL.getPageContext()).aST();
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
        this.jSs.onChangeSkinType(i2);
    }

    public PbInterviewStatusView cIy() {
        return this.jTl;
    }

    private void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCy() != null && eVar.cCy().aRG() && this.jTl == null) {
            this.jTl = (PbInterviewStatusView) this.jTk.inflate();
            this.jTl.setOnClickListener(this.hpF);
            this.jTl.setCallback(this.jHL.cFk());
            this.jTl.setData(this.jHL, eVar);
        }
    }

    public RelativeLayout cIz() {
        return this.jSx;
    }

    public View cIA() {
        return this.bdq;
    }

    public boolean cIB() {
        return this.jTY;
    }

    public void rj(boolean z) {
        this.jSs.rj(z);
    }

    public void JC(String str) {
        if (this.jSk != null) {
            this.jSk.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int sc(boolean z) {
        if (this.jTl == null || this.jTl.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cIC() {
        if (this.jTl != null && this.jTl.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jTl.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.jTl.setLayoutParams(layoutParams);
        }
    }

    public boolean cEF() {
        return false;
    }

    public void JD(String str) {
        this.ihL.performClick();
        if (!StringUtils.isNull(str) && this.jHL.cEz() != null && this.jHL.cEz().bdw() != null && this.jHL.cEz().bdw().getInputView() != null) {
            EditText inputView = this.jHL.cEz().bdw().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cIk();
            if (configuration.orientation == 2) {
                cIu();
                cHs();
            } else {
                cHw();
            }
            if (this.jTE != null) {
                this.jTE.cEu();
            }
            this.jHL.bVq();
            this.jSx.setVisibility(8);
            this.jSj.sn(false);
            this.jHL.ry(false);
            if (this.jSp != null) {
                if (configuration.orientation == 1) {
                    cIz().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.jSn.setIsLandscape(true);
                    this.jSn.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.jSn.setIsLandscape(false);
                    if (this.jUi > 0) {
                        this.jSn.smoothScrollBy(this.jUi, 0);
                    }
                }
                this.jSp.onConfigurationChanged(configuration);
                this.jTm.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void sd(boolean z) {
        if (this.jSp != null) {
            this.jSp.sd(z);
        }
    }

    public boolean cID() {
        return this.jSp != null && this.jSp.cID();
    }

    public void cIE() {
        if (this.jSp != null) {
            this.jSp.cIE();
        }
    }

    public void rn(boolean z) {
        this.jSy.rn(z);
    }

    public void cJ(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.jSW.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.jHL.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.jTO = new TextView(this.jHL.getContext());
            this.jTO.setText(R.string.connection_tips);
            this.jTO.setGravity(17);
            this.jTO.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jHL.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.jHL.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.jHL.getContext(), R.dimen.ds60);
            if (this.jTO.getParent() == null) {
                frameLayout.addView(this.jTO, layoutParams);
            }
            this.jTN = new PopupWindow(this.jHL.getContext());
            this.jTN.setContentView(frameLayout);
            this.jTN.setHeight(-2);
            this.jTN.setWidth(-2);
            this.jTN.setFocusable(true);
            this.jTN.setOutsideTouchable(false);
            this.jTN.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.jSn.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        av.this.jTN.showAsDropDown(av.this.jSW, view.getLeft(), -av.this.jSW.getHeight());
                    } else {
                        av.this.jTN.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void se(boolean z) {
        this.jTT = z;
    }

    public boolean cIF() {
        return this.jTT;
    }

    public PbThreadPostView cIG() {
        return this.jSo;
    }

    private void ai(boolean z, boolean z2) {
        aj(z, z2);
        if (this.jIU != null && this.jIU.cCy() != null && this.jIU.cCy().aQM() == 0 && !this.jIU.cCy().aPk()) {
            ak(z, z2);
        } else if (this.jSy != null && this.jSy.cEr() != null) {
            this.jSy.cEr().b(this.jIU, z, z2);
        }
    }

    private void aj(boolean z, boolean z2) {
        this.jSs.d(this.jIU, z, z2);
    }

    private void ak(boolean z, boolean z2) {
        this.jSr.c(this.jIU, z, z2);
    }
}
