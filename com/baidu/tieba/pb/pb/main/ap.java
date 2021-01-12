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
import android.text.Editable;
import android.text.SpannableStringBuilder;
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
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.be;
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
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
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
/* loaded from: classes2.dex */
public class ap {
    private EditorTools acX;
    private View bHz;
    private RelativeLayout bIt;
    private View bJc;
    private View fGq;
    private f.c fhg;
    private com.baidu.tieba.pb.a.c ftt;
    private NoNetworkView gvm;
    private boolean isLandscape;
    private List<CustomBlueCheckRadioButton> itJ;
    private NavigationBarCoverTip jGC;
    private com.baidu.tieba.NEGFeedBack.f jJX;
    private boolean jap;
    private View.OnClickListener jdo;
    private PbListView jiy;
    private TextView kgY;
    private PbFragment lEi;
    private com.baidu.tieba.pb.data.f lFA;
    private View.OnClickListener lFn;
    private PbFakeFloorModel lHU;
    PbFragment.c lJL;
    public int lPJ;
    public final com.baidu.tieba.pb.pb.main.view.c lPL;
    public com.baidu.tieba.pb.pb.main.view.b lPM;
    private ViewStub lPN;
    private ViewStub lPO;
    private PbLandscapeListView lPP;
    private PbThreadPostView lPQ;
    private com.baidu.tieba.pb.pb.main.a.e lPR;
    private com.baidu.tieba.pb.pb.main.a.a lPS;
    private com.baidu.tieba.pb.pb.main.a.c lPT;
    private com.baidu.tieba.pb.pb.main.a.d lPU;
    private com.baidu.tieba.pb.pb.main.a.b lPV;
    private LinearLayout lPW;
    private TextView lPX;
    private TextView lPY;
    private ObservedChangeRelativeLayout lPZ;
    private LinearLayout lQA;
    private HeadImageView lQB;
    private ImageView lQC;
    private ImageView lQD;
    private ImageView lQE;
    private com.baidu.tieba.pb.view.d lQF;
    private TextView lQG;
    private TextView lQH;
    private int lQJ;
    private int lQK;
    private PostData lQL;
    private ViewStub lQN;
    private PbInterviewStatusView lQO;
    private FrameLayout lQP;
    private View lQQ;
    private View lQR;
    private PbReplyTitleViewHolder lQS;
    private PbEmotionBar lQX;
    private g lQa;
    private View lQg;
    private View lQw;
    private View lQy;
    private View lQz;
    private long lRA;
    private int lRB;
    private com.baidu.tieba.pb.view.c lRE;
    private boolean lRG;
    private Runnable lRK;
    private PbFragment.b lRM;
    private int lRf;
    private Runnable lRg;
    private r lRh;
    private al lRi;
    private int lRo;
    private PbTopTipView lRp;
    private PopupWindow lRq;
    private TextView lRr;
    private List<String> lRs;
    private com.baidu.tieba.pb.pb.main.emotion.c lRt;
    private com.baidu.tieba.pb.pb.godreply.a lRu;
    private PbLandscapeListView.b lRv;
    private ae lRx;
    private com.baidu.tieba.NEGFeedBack.i lRy;
    private String lRz;
    public int mLastScrollY;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int lQT = UtilHelper.getLightStatusBarHeight();
    public static int lQZ = 3;
    public static int lRa = 0;
    public static int lRb = 3;
    public static int lRc = 4;
    public static int lRd = 5;
    public static int lRe = 6;
    private static final int lRC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    private static a.InterfaceC0867a lRF = new a.InterfaceC0867a() { // from class: com.baidu.tieba.pb.pb.main.ap.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0867a
        public void onRefresh() {
        }
    };
    private int lPK = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lQb = null;
    private com.baidu.tbadk.core.dialog.b jdn = null;
    private View lQc = null;
    private EditText lQd = null;
    private com.baidu.tieba.pb.view.e lQe = null;
    private com.baidu.tieba.pb.view.a lQf = null;
    private b.InterfaceC0561b lQh = null;
    private TbRichTextView.i fSh = null;
    private NoNetworkView.a iXM = null;
    private com.baidu.tbadk.core.dialog.i lQi = null;
    private com.baidu.tbadk.core.dialog.a lQj = null;
    private Dialog lQk = null;
    private Dialog lQl = null;
    private View lQm = null;
    private LinearLayout lQn = null;
    private CompoundButton.OnCheckedChangeListener itK = null;
    private TextView lQo = null;
    private TextView lQp = null;
    private String lQq = null;
    private com.baidu.tbadk.core.dialog.i lIK = null;
    private com.baidu.tbadk.core.dialog.i lQr = null;
    private boolean lQs = false;
    private boolean lQt = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lQu = null;
    private boolean lQv = false;
    private Button lQx = null;
    private boolean lQI = true;
    private com.baidu.tbadk.core.view.a ixW = null;
    private boolean lFf = false;
    private int mSkinType = 3;
    private boolean lQM = false;
    private int lQU = 0;
    private boolean lQV = true;
    public a lQW = new a();
    private int lQY = 0;
    private boolean lRj = false;
    private int lRk = 0;
    private boolean lRl = false;
    private boolean lRm = false;
    private boolean lRn = false;
    private boolean lRw = false;
    private int lRD = 0;
    private String lRH = null;
    private CustomMessageListener lRI = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ap.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ap.this.lRH = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ap.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ap.this.lQa != null) {
                ap.this.lQa.notifyDataSetChanged();
            }
        }
    };
    private Handler lRJ = new Handler();
    private CustomMessageListener lRL = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ap.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ap.this.lQI = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lRN = true;
    View.OnClickListener lRO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || ap.this.lFA == null || ap.this.lFA.diN() == null || ap.this.lFA.diN().bnx() == null || ap.this.lFA.diN().bnx().getAlaInfo() == null || ap.this.lFA.diN().bnx().getAlaInfo().live_status != 1) {
                if (ap.this.lRl) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").an("obj_id", 2));
                }
                if (!ap.this.lRl && ap.this.lFA != null && ap.this.lFA.diN() != null && ap.this.lFA.diN().bnx() != null && ap.this.lFA.diN().bnx().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").an("obj_locate", 1));
                }
                if (ap.this.lEi.dlL() != null) {
                    ap.this.lEi.dlL().lEu.iJX.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (ap.this.lFA.diN().bnx().getAlaInfo() == null || !ap.this.lFA.diN().bnx().getAlaInfo().isChushou) {
                if (ap.this.lFA.diN().bnx().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = ap.this.lFA.diN().bnx().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ap.this.lEi.dlL(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            be.bsB().b(ap.this.lEi.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + ap.this.lFA.diN().bnx().getAlaInfo().thirdRoomId + "&livetype=" + ap.this.lFA.diN().bnx().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bfV = false;
    String userId = null;
    private final List<TbImageView> lRP = new ArrayList();
    private boolean lRQ = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int headerCount;
        public PbReplyTitleViewHolder lSe;
        public int luW;
    }

    public void vj(boolean z) {
        this.lRj = z;
        if (this.lPP != null) {
            this.lRk = this.lPP.getHeaderViewsCount();
        }
    }

    public void dnR() {
        if (this.lPP != null) {
            int headerViewsCount = this.lPP.getHeaderViewsCount() - this.lRk;
            final int firstVisiblePosition = (this.lPP.getFirstVisiblePosition() == 0 || this.lPP.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lPP.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lPP.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lQW.lSe = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQW));
            final PbReplyTitleViewHolder pbReplyTitleViewHolder = this.lQW.lSe;
            final int g = g(pbReplyTitleViewHolder);
            final int y = ((int) this.lPZ.getY()) + this.lPZ.getMeasuredHeight();
            final boolean z = this.lQQ.getVisibility() == 0;
            boolean z2 = this.lPZ.getY() < 0.0f;
            if ((z && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.lQa.dkD() + this.lPP.getHeaderViewsCount()) {
                int measuredHeight = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.lPl.getMeasuredHeight() : 0;
                if (z2) {
                    this.lPP.setSelectionFromTop(this.lQa.dkD() + this.lPP.getHeaderViewsCount(), lQT - measuredHeight);
                } else {
                    this.lPP.setSelectionFromTop(this.lQa.dkD() + this.lPP.getHeaderViewsCount(), this.lPL.dpU().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lPP.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.lRl && this.lPR != null) {
                this.lPP.setSelectionFromTop(this.lQa.dkD() + this.lPP.getHeaderViewsCount(), this.lPR.dpG());
            } else if (this.mType == 6) {
                this.lPP.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= ap.this.bIt.getMeasuredHeight()) {
                            int g2 = ap.this.g(pbReplyTitleViewHolder);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (ap.this.bJc != null && (layoutParams = ap.this.bJc.getLayoutParams()) != null) {
                                if (i == 0 || i > ap.this.bIt.getMeasuredHeight() || g2 >= ap.this.bIt.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.lRf;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ap.this.bIt.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.lRf;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    ap.this.lPP.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                ap.this.bJc.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ap.this.bJc != null && ap.this.bJc.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = ap.this.bJc.getLayoutParams();
                                            layoutParams2.height = ap.this.lRf;
                                            ap.this.bJc.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        ap.this.lPP.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null) {
            return 0;
        }
        if (pbReplyTitleViewHolder.getView().getTop() != 0 || pbReplyTitleViewHolder.getView().isShown()) {
            return pbReplyTitleViewHolder.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView dnS() {
        return this.gvm;
    }

    public void dnT() {
        if (this.acX != null) {
            this.acX.hide();
            if (this.lRt != null) {
                this.lRt.dpI();
            }
        }
    }

    public PbFakeFloorModel dnU() {
        return this.lHU;
    }

    public r dnV() {
        return this.lRh;
    }

    public com.baidu.tieba.pb.pb.main.a.e dnW() {
        return this.lPR;
    }

    public void dnX() {
        reset();
        dnT();
        this.lRh.dkM();
        vv(false);
    }

    private void reset() {
        if (this.lEi != null && this.lEi.dkR() != null && this.acX != null) {
            com.baidu.tbadk.editortools.pb.a.bBs().setStatus(0);
            com.baidu.tbadk.editortools.pb.e dkR = this.lEi.dkR();
            dkR.bBN();
            dkR.bBc();
            if (dkR.getWriteImagesInfo() != null) {
                dkR.getWriteImagesInfo().setMaxImagesAllowed(dkR.isBJH ? 1 : 9);
            }
            dkR.qZ(SendView.ALL);
            dkR.ra(SendView.ALL);
            com.baidu.tbadk.editortools.h qM = this.acX.qM(23);
            com.baidu.tbadk.editortools.h qM2 = this.acX.qM(2);
            com.baidu.tbadk.editortools.h qM3 = this.acX.qM(5);
            if (qM2 != null) {
                qM2.rV();
            }
            if (qM3 != null) {
                qM3.rV();
            }
            if (qM != null) {
                qM.hide();
            }
            this.acX.invalidate();
        }
    }

    public boolean dnY() {
        return this.lQI;
    }

    public void vk(boolean z) {
        if (this.lQz != null && this.kgY != null) {
            this.kgY.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lQz.startAnimation(alphaAnimation);
            }
            this.lQy.setVisibility(0);
            this.lQz.setVisibility(0);
            this.lQI = true;
            if (this.lQX != null && !this.lRu.isActive()) {
                this.lQX.setVisibility(0);
                vp(true);
            }
        }
    }

    public void vl(boolean z) {
        if (this.lQz != null && this.kgY != null) {
            this.kgY.setText(dnZ());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lQz.startAnimation(alphaAnimation);
            }
            this.lQy.setVisibility(0);
            this.lQz.setVisibility(0);
            this.lQI = true;
            if (this.lQX != null && !this.lRu.isActive()) {
                this.lQX.setVisibility(0);
                vp(true);
            }
        }
    }

    public String dnZ() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.lRz)) {
            return this.lRz;
        }
        if (this.lEi != null) {
            this.lRz = TbadkCoreApplication.getInst().getResources().getString(ao.dnP());
        }
        return this.lRz;
    }

    public PostData doa() {
        int i = 0;
        if (this.lPP == null) {
            return null;
        }
        int dob = dob() - this.lPP.getHeaderViewsCount();
        if (dob < 0) {
            dob = 0;
        }
        if (this.lQa.Fh(dob) != null && this.lQa.Fh(dob) != PostData.nmM) {
            i = dob + 1;
        }
        return this.lQa.getItem(i) instanceof PostData ? (PostData) this.lQa.getItem(i) : null;
    }

    public int dob() {
        int i;
        View childAt;
        if (this.lPP == null) {
            return 0;
        }
        int firstVisiblePosition = this.lPP.getFirstVisiblePosition();
        int lastVisiblePosition = this.lPP.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lPP.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lPP.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int doc() {
        return this.lPP.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lFA != null && this.lFA.diP() != null && !this.lFA.diP().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lFA.diP().size() && (postData = this.lFA.diP().get(i)) != null && postData.bnx() != null && !StringUtils.isNull(postData.bnx().getUserId()); i++) {
                if (this.lFA.diP().get(i).bnx().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lRu != null && this.lRu.isActive()) {
                        vv(false);
                    }
                    if (this.lQX != null) {
                        this.lQX.vF(true);
                    }
                    this.lRH = postData.bnx().getName_show();
                    return;
                }
            }
        }
    }

    public ap(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lEi = null;
        this.bIt = null;
        this.bHz = null;
        this.lPP = null;
        this.lQa = null;
        this.jiy = null;
        this.fGq = null;
        this.jdo = null;
        this.lFn = null;
        this.lQz = null;
        this.kgY = null;
        this.lQN = null;
        this.lRo = 0;
        this.lRA = 0L;
        this.lRA = System.currentTimeMillis();
        this.lEi = pbFragment;
        this.jdo = onClickListener;
        this.ftt = cVar;
        this.lRo = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lEi.getContext()) / 8;
        this.bIt = (RelativeLayout) LayoutInflater.from(this.lEi.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bIt.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lQw = this.bIt.findViewById(R.id.bottom_shadow);
        this.jGC = (NavigationBarCoverTip) this.bIt.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bHz = this.bIt.findViewById(R.id.statebar_view);
        this.lPZ = (ObservedChangeRelativeLayout) this.bIt.findViewById(R.id.title_wrapper);
        this.gvm = (NoNetworkView) this.bIt.findViewById(R.id.view_no_network);
        this.lPP = (PbLandscapeListView) this.bIt.findViewById(R.id.new_pb_list);
        this.lQP = (FrameLayout) this.bIt.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lEi.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lEi.getActivity(), R.dimen.ds88));
        this.lPP.addHeaderView(this.textView, 0);
        this.lPP.setTextViewAdded(true);
        this.lRf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bJc = new View(this.lEi.getPageContext().getPageActivity());
        this.bJc.setLayoutParams(new AbsListView.LayoutParams(-1, this.lRf));
        this.bJc.setVisibility(4);
        this.lPP.addFooterView(this.bJc);
        this.lPP.setOnTouchListener(this.lEi.bPd);
        this.lPL = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bIt);
        if (this.lEi.dlu()) {
            this.lPN = (ViewStub) this.bIt.findViewById(R.id.manga_view_stub);
            this.lPN.setVisibility(0);
            this.lPM = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lPM.show();
            this.lPL.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lEi.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lPL.dpU().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0823a() { // from class: com.baidu.tieba.pb.pb.main.ap.27
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0823a
            public void djP() {
                if (ap.this.lPP != null) {
                    if (ap.this.lPR != null) {
                        ap.this.lPR.dpF();
                    }
                    ap.this.lPP.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0823a
            public void djQ() {
                ap.this.lEi.cBJ();
            }
        }));
        this.lQy = this.bIt.findViewById(R.id.view_comment_top_line);
        this.lQz = this.bIt.findViewById(R.id.pb_editor_tool_comment);
        this.lQJ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lQK = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lQB = (HeadImageView) this.bIt.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lQB.setVisibility(0);
        this.lQB.setIsRound(true);
        this.lQB.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lEi.getContext(), R.dimen.L_X01));
        this.lQB.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0401));
        this.lQB.setPlaceHolder(0);
        dod();
        this.kgY = (TextView) this.bIt.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lQA = (LinearLayout) this.bIt.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lQA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.lEi.dlc();
                if (ap.this.lEi != null && ap.this.lEi.dkd() != null && ap.this.lEi.dkd().getPbData() != null && ap.this.lEi.dkd().getPbData().diN() != null && ap.this.lEi.dkd().getPbData().diN().bnx() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dW("tid", ap.this.lEi.dkd().dmf()).dW("fid", ap.this.lEi.dkd().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dW("tid", ap.this.lEi.dkd().lLR).dW("fid", ap.this.lEi.dkd().getPbData().getForumId()).an("obj_locate", 1).dW("uid", ap.this.lEi.dkd().getPbData().diN().bnx().getUserId()));
                }
            }
        });
        this.lQC = (ImageView) this.bIt.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lQC.setOnClickListener(this.jdo);
        boolean booleanExtra = this.lEi.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lQD = (ImageView) this.bIt.findViewById(R.id.pb_editor_tool_collection);
        this.lQD.setOnClickListener(this.jdo);
        if (booleanExtra) {
            this.lQD.setVisibility(8);
        } else {
            this.lQD.setVisibility(0);
        }
        this.lQE = (ImageView) this.bIt.findViewById(R.id.pb_editor_tool_share);
        this.lQE.setOnClickListener(this.jdo);
        this.lQF = new com.baidu.tieba.pb.view.d(this.lQE);
        this.lQF.dto();
        this.lQG = (TextView) this.bIt.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lQG.setVisibility(0);
        this.lQN = (ViewStub) this.bIt.findViewById(R.id.interview_status_stub);
        this.lPS = new com.baidu.tieba.pb.pb.main.a.a(this.lEi, cVar);
        this.lPU = new com.baidu.tieba.pb.pb.main.a.d(this.lEi, cVar, this.jdo);
        this.lQa = new g(this.lEi, this.lPP);
        this.lQa.H(this.jdo);
        this.lQa.setTbGestureDetector(this.ftt);
        this.lQa.setOnImageClickListener(this.fSh);
        this.lQa.setOnSwitchChangeListener(this.lEi.lJE);
        this.lFn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.29
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
                            ap.this.lEi.f(sparseArray);
                            return;
                        }
                        ap.this.dN(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        ap.this.lEi.f(sparseArray);
                    } else if (booleanValue3) {
                        ap.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lQa.U(this.lFn);
        doi();
        doj();
        this.lPT.b(this.lPP);
        this.lPU.b(this.lPP);
        this.lPS.b(this.lPP);
        this.jiy = new PbListView(this.lEi.getPageContext().getPageActivity());
        this.fGq = this.jiy.getView().findViewById(R.id.pb_more_view);
        if (this.fGq != null) {
            this.fGq.setOnClickListener(this.jdo);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.fGq, R.drawable.pb_foot_more_trans_selector);
        }
        this.jiy.setLineVisible();
        this.jiy.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jiy.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lQg = this.bIt.findViewById(R.id.viewstub_progress);
        this.lEi.registerListener(this.lRL);
        this.lHU = new PbFakeFloorModel(this.lEi.getPageContext());
        this.lRh = new r(this.lEi.getPageContext(), this.lHU, this.bIt);
        this.lRh.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.dnX();
            }
        });
        this.lRh.a(this.lEi.lJG);
        this.lHU.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ap.31
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                ap.this.lHU.u(postData);
                ap.this.lQa.notifyDataSetChanged();
                ap.this.lRh.dkM();
                ap.this.acX.bzl();
                ap.this.vv(false);
            }
        });
        if (this.lEi.dkd() != null && !StringUtils.isNull(this.lEi.dkd().dmO())) {
            this.lEi.showToast(this.lEi.dkd().dmO());
        }
        this.lQQ = this.bIt.findViewById(R.id.pb_expand_blank_view);
        this.lQR = this.bIt.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lQR.getLayoutParams();
        if (this.lEi.dkd() != null && this.lEi.dkd().dmi()) {
            this.lQQ.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lQR.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lQT;
            this.lQR.setLayoutParams(layoutParams2);
        }
        this.lQS = new PbReplyTitleViewHolder(this.lEi.getPageContext(), this.bIt.findViewById(R.id.pb_reply_expand_view));
        this.lQS.v(pbFragment.lIz);
        this.lQS.lPl.setVisibility(8);
        this.lQS.W(this.jdo);
        this.lQS.setOnSwitchChangeListener(this.lEi.lJE);
        this.lEi.registerListener(this.mAccountChangedListener);
        this.lEi.registerListener(this.lRI);
        doe();
        vp(false);
        this.lRE = new com.baidu.tieba.pb.view.c(this.lEi.getPageContext());
    }

    private void dod() {
        if (this.lQB != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lQB.setImageResource(0);
            this.lQB.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lQB.setImageResource(R.drawable.transparent_bg);
    }

    public void vm(boolean z) {
        this.lQw.setVisibility(z ? 0 : 8);
    }

    public void cQn() {
        if (!this.lEi.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").an("obj_locate", 2).dW("fid", this.mForumId));
        } else if (this.lEi.dle()) {
            com.baidu.tbadk.editortools.pb.e dkR = this.lEi.dkR();
            if (dkR != null && (dkR.bBK() || dkR.bBL())) {
                this.lEi.dkR().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acX != null) {
                doo();
            }
            if (this.acX != null) {
                this.lQI = false;
                if (this.acX.qP(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lEi.getPageContext(), (View) this.acX.qP(2).fyZ, false, lRF);
                }
            }
            doY();
        }
    }

    private void doe() {
        this.lRu = new com.baidu.tieba.pb.pb.godreply.a(this.lEi, this, (ViewStub) this.bIt.findViewById(R.id.more_god_reply_popup));
        this.lRu.C(this.jdo);
        this.lRu.U(this.lFn);
        this.lRu.setOnImageClickListener(this.fSh);
        this.lRu.C(this.jdo);
        this.lRu.setTbGestureDetector(this.ftt);
    }

    public com.baidu.tieba.pb.pb.godreply.a dof() {
        return this.lRu;
    }

    public View dog() {
        return this.lQQ;
    }

    public void doh() {
        if (this.lPP != null) {
            this.lPT.c(this.lPP);
            this.lPU.c(this.lPP);
            this.lPV.c(this.lPP);
            this.lPS.c(this.lPP);
        }
    }

    private void doi() {
        if (this.lPV == null) {
            this.lPV = new com.baidu.tieba.pb.pb.main.a.b(this.lEi, this.jdo);
        }
    }

    private void doj() {
        if (this.lPT == null) {
            this.lPT = new com.baidu.tieba.pb.pb.main.a.c(this.lEi, this.ftt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dok() {
        if (this.lEi.dlu()) {
            this.lPO = (ViewStub) this.bIt.findViewById(R.id.manga_mention_controller_view_stub);
            this.lPO.setVisibility(0);
            if (this.lPW == null) {
                this.lPW = (LinearLayout) this.bIt.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lEi.getPageContext(), this.lPW);
            }
            if (this.lPX == null) {
                this.lPX = (TextView) this.lPW.findViewById(R.id.manga_prev_btn);
            }
            if (this.lPY == null) {
                this.lPY = (TextView) this.lPW.findViewById(R.id.manga_next_btn);
            }
            this.lPX.setOnClickListener(this.jdo);
            this.lPY.setOnClickListener(this.jdo);
        }
    }

    private void dol() {
        if (this.lEi.dlu()) {
            if (this.lEi.dlx() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPX, R.color.CAM_X0110, 1);
            }
            if (this.lEi.dly() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPY, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dom() {
        if (this.lPW == null) {
            dok();
        }
        this.lPO.setVisibility(8);
        if (this.lRJ != null && this.lRK != null) {
            this.lRJ.removeCallbacks(this.lRK);
        }
    }

    public void don() {
        if (this.lRJ != null) {
            if (this.lRK != null) {
                this.lRJ.removeCallbacks(this.lRK);
            }
            this.lRK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ap.this.lPW == null) {
                        ap.this.dok();
                    }
                    ap.this.lPO.setVisibility(0);
                }
            };
            this.lRJ.postDelayed(this.lRK, 2000L);
        }
    }

    public void vn(boolean z) {
        this.lPL.vn(z);
        if (z && this.lQM) {
            this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lPP.setNextPage(this.jiy);
            this.lPK = 2;
        }
        dod();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
        this.acX.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.dnX();
            }
        });
        this.acX.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acX.getParent() == null) {
            this.bIt.addView(this.acX, layoutParams);
        }
        this.acX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acX.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.ap.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bwd() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bwd() == EmotionGroupType.USER_COLLECT) {
                        if (ap.this.mPermissionJudgePolicy == null) {
                            ap.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        ap.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        ap.this.mPermissionJudgePolicy.appendRequestPermission(ap.this.lEi.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ap.this.mPermissionJudgePolicy.startRequestPermission(ap.this.lEi.getBaseFragmentActivity())) {
                            ap.this.lEi.dkR().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            ap.this.lEi.dkR().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dnT();
        this.lEi.dkR().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ap.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ap.this.acX != null && ap.this.acX.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ap.this.lRt == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ap.this.acX.getId());
                            ap.this.lRt = new com.baidu.tieba.pb.pb.main.emotion.c(ap.this.lEi.getPageContext(), ap.this.bIt, layoutParams2);
                            if (!com.baidu.tbadk.core.util.x.isEmpty(ap.this.lRs)) {
                                ap.this.lRt.setData(ap.this.lRs);
                            }
                            ap.this.lRt.c(ap.this.acX);
                        }
                        ap.this.lRt.OW(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ap.this.lEi.kOl != null && ap.this.lEi.kOl.dpr() != null) {
                    if (!ap.this.lEi.kOl.dpr().dUc()) {
                        ap.this.lEi.kOl.vB(false);
                    }
                    ap.this.lEi.kOl.dpr().yY(false);
                }
            }
        });
    }

    public void doo() {
        if (this.lEi != null && this.acX != null) {
            this.acX.rV();
            if (this.lEi.dkR() != null) {
                this.lEi.dkR().bBA();
            }
            doY();
        }
    }

    public void vo(boolean z) {
        if (this.lPP != null && this.textView != null && this.bHz != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bHz.setVisibility(0);
                } else {
                    this.bHz.setVisibility(8);
                    this.lPP.removeHeaderView(this.textView);
                    this.lPP.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lQT;
                    this.textView.setLayoutParams(layoutParams);
                }
                doF();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + vx(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            doF();
            dpg();
        }
    }

    public g dop() {
        return this.lQa;
    }

    public void a(PbFragment.c cVar) {
        this.lJL = cVar;
    }

    public void dN(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lEi.getContext());
        kVar.setTitleText(this.lEi.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lQi.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            ap.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (ap.this.lRM != null) {
                                ap.this.lRM.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            ap.this.lEi.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lEi.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lEi.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eSW.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dpf()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.lEi.getString(R.string.forbidden_person), kVar);
            gVar3.eSW.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lEi.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lEi.getString(R.string.mute), kVar);
            }
            gVar.eSW.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.k(com.baidu.tieba.pb.pb.main.d.a.fs(arrayList), true);
        this.lQi = new com.baidu.tbadk.core.dialog.i(this.lEi.getPageContext(), kVar);
        this.lQi.Pd();
    }

    public void a(PbFragment.b bVar) {
        this.lRM = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lEi != null && aVar != null) {
            if (this.jJX == null && this.lPS != null) {
                this.jJX = new com.baidu.tieba.NEGFeedBack.f(this.lEi.getPageContext(), this.lPS.dpB());
            }
            AntiData cAh = this.lEi.cAh();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cAh != null && cAh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cAh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jJX.setDefaultReasonArray(new String[]{this.lEi.getString(R.string.delete_thread_reason_1), this.lEi.getString(R.string.delete_thread_reason_2), this.lEi.getString(R.string.delete_thread_reason_3), this.lEi.getString(R.string.delete_thread_reason_4), this.lEi.getString(R.string.delete_thread_reason_5)});
            this.jJX.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jJX.DV(str);
            this.jJX.a(new f.b() { // from class: com.baidu.tieba.pb.pb.main.ap.9
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    ap.this.lEi.a(aVar, jSONArray);
                }
            });
        }
    }

    private boolean doq() {
        if (this.lEi == null || this.lEi.dkd().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.lEi.dkd().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        String str;
        if (this.lEi != null && aVar != null) {
            if (this.lRy == null && this.lPS != null) {
                this.lRy = new com.baidu.tieba.NEGFeedBack.i(this.lEi.getPageContext(), this.lPS.dpB(), hVar, userData);
            }
            AntiData cAh = this.lEi.cAh();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cAh != null && cAh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cAh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lRy.setDefaultReasonArray(new String[]{this.lEi.getString(R.string.delete_thread_reason_1), this.lEi.getString(R.string.delete_thread_reason_2), this.lEi.getString(R.string.delete_thread_reason_3), this.lEi.getString(R.string.delete_thread_reason_4), this.lEi.getString(R.string.delete_thread_reason_5)});
            this.lRy.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lRy.DV(str);
            this.lRy.a(new i.b() { // from class: com.baidu.tieba.pb.pb.main.ap.10
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    ap.this.lEi.a(aVar, jSONArray);
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
        sparseArray.put(lRa, Integer.valueOf(lRb));
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
        this.lQj = new com.baidu.tbadk.core.dialog.a(this.lEi.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lQj.nu(i3);
        } else {
            this.lQj.setOnlyMessageShowCenter(false);
            this.lQj.Ad(str2);
        }
        this.lQj.setYesButtonTag(sparseArray);
        this.lQj.a(R.string.dialog_ok, this.lEi);
        this.lQj.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lQj.jD(true);
        this.lQj.b(this.lEi.getPageContext());
        if (z) {
            this.lQj.bqe();
        } else if (doq()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lEi.dkd().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.lEi.dkd().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.lEi.dkd().getPbData().djw().has_forum_rule.intValue());
            hVar.ei(this.lEi.dkd().getPbData().getForum().getId(), this.lEi.dkd().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.lEi.dkd().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.lEi.dkd().getPbData().getForum().getUser_level());
            a(this.lQj, i, hVar, this.lEi.dkd().getPbData().getUserData());
        } else {
            a(this.lQj, i);
        }
    }

    public void ba(ArrayList<com.baidu.tbadk.core.data.ak> arrayList) {
        if (this.lQm == null) {
            this.lQm = LayoutInflater.from(this.lEi.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lEi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lQm);
        if (this.lQl == null) {
            this.lQl = new Dialog(this.lEi.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lQl.setCanceledOnTouchOutside(true);
            this.lQl.setCancelable(true);
            this.lQu = (ScrollView) this.lQm.findViewById(R.id.good_scroll);
            this.lQl.setContentView(this.lQm);
            WindowManager.LayoutParams attributes = this.lQl.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lQl.getWindow().setAttributes(attributes);
            this.itK = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ap.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.this.lQq = (String) compoundButton.getTag();
                        if (ap.this.itJ != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ap.this.itJ) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ap.this.lQq != null && !str.equals(ap.this.lQq)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lQn = (LinearLayout) this.lQm.findViewById(R.id.good_class_group);
            this.lQp = (TextView) this.lQm.findViewById(R.id.dialog_button_cancel);
            this.lQp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.lQl instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(ap.this.lQl, ap.this.lEi.getPageContext());
                    }
                }
            });
            this.lQo = (TextView) this.lQm.findViewById(R.id.dialog_button_ok);
            this.lQo.setOnClickListener(this.jdo);
        }
        this.lQn.removeAllViews();
        this.itJ = new ArrayList();
        CustomBlueCheckRadioButton fU = fU("0", this.lEi.getPageContext().getString(R.string.thread_good_class));
        this.itJ.add(fU);
        fU.setChecked(true);
        this.lQn.addView(fU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.blJ()) && akVar.blK() > 0) {
                    CustomBlueCheckRadioButton fU2 = fU(String.valueOf(akVar.blK()), akVar.blJ());
                    this.itJ.add(fU2);
                    View view = new View(this.lEi.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ao.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lQn.addView(view);
                    this.lQn.addView(fU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lQu.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lEi.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lEi.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lEi.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lQu.setLayoutParams(layoutParams2);
            this.lQu.removeAllViews();
            if (this.lQn != null && this.lQn.getParent() == null) {
                this.lQu.addView(this.lQn);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lQl, this.lEi.getPageContext());
    }

    private CustomBlueCheckRadioButton fU(String str, String str2) {
        Activity pageActivity = this.lEi.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.itK);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dor() {
        this.lEi.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lEi.hideProgressBar();
        if (z && z2) {
            this.lEi.showToast(this.lEi.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lEi.showToast(str);
        }
    }

    public void dos() {
        this.lQg.setVisibility(0);
    }

    public void dot() {
        this.lQg.setVisibility(8);
    }

    public View dou() {
        if (this.lQm != null) {
            return this.lQm.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dov() {
        return this.lQq;
    }

    public View getView() {
        return this.bIt;
    }

    public void dow() {
        if (this.lEi != null && this.lEi.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lEi.getPageContext().getPageActivity(), this.lEi.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lEi.hideProgressBar();
        if (z) {
            doP();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            doQ();
        } else {
            doP();
        }
    }

    public void dox() {
        this.jiy.setLineVisible();
        this.jiy.startLoadData();
    }

    public void doy() {
        this.lEi.hideProgressBar();
        endLoadData();
        this.lPP.completePullRefreshPostDelayed(0L);
        doK();
    }

    public void doz() {
        this.lPP.completePullRefreshPostDelayed(0L);
        doK();
    }

    private void vp(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lPU.b(onLongClickListener);
        this.lQa.setOnLongClickListener(onLongClickListener);
        if (this.lRu != null) {
            this.lRu.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0561b interfaceC0561b, boolean z, boolean z2) {
        if (this.lIK != null) {
            this.lIK.dismiss();
            this.lIK = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lEi.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lEi.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lEi.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lEi.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lEi.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lQr.dismiss();
                interfaceC0561b.a(null, i, view);
            }
        });
        this.lQr = new com.baidu.tbadk.core.dialog.i(this.lEi.getPageContext(), kVar);
        this.lQr.Pd();
    }

    public void a(final b.InterfaceC0561b interfaceC0561b, boolean z) {
        if (this.lQr != null) {
            this.lQr.dismiss();
            this.lQr = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lEi.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lFA != null && this.lFA.diN() != null && !this.lFA.diN().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lEi.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lEi.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lQr.dismiss();
                interfaceC0561b.a(null, i, view);
            }
        });
        this.lQr = new com.baidu.tbadk.core.dialog.i(this.lEi.getPageContext(), kVar);
        this.lQr.Pd();
    }

    public int doA() {
        return FI(this.lPP.getFirstVisiblePosition());
    }

    private int FI(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.lPP.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lPP.getAdapter() == null || !(this.lPP.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.lPP.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int doB() {
        int lastVisiblePosition = this.lPP.getLastVisiblePosition();
        if (this.lPR != null) {
            if (lastVisiblePosition == this.lPP.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return FI(lastVisiblePosition);
    }

    public void FJ(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.lPP != null) {
            if (this.lPL == null || this.lPL.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lPL.mNavigationBar.getFixedNavHeight();
                if (this.lEi.dlk() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lQR != null && (layoutParams = (LinearLayout.LayoutParams) this.lQR.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lQR.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lPP.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lPP.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lPP.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lQd.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lQa.a(fVar, false);
        this.lQa.notifyDataSetChanged();
        doK();
        if (this.lRu != null) {
            this.lRu.bOp();
        }
        ArrayList<PostData> diP = fVar.diP();
        if (fVar.getPage().bmm() == 0 || diP == null || diP.size() < fVar.getPage().bml()) {
            if (com.baidu.tbadk.core.util.x.getCount(diP) == 0 || (com.baidu.tbadk.core.util.x.getCount(diP) == 1 && diP.get(0) != null && diP.get(0).dLm() == 1)) {
                if (this.lQW == null || this.lQW.lSe == null || this.lQW.lSe.getView() == null) {
                    i = 0;
                } else {
                    i = this.lQW.lSe.getView().getTop() < 0 ? this.lQW.lSe.getView().getHeight() : this.lQW.lSe.getView().getBottom();
                }
                if (this.lEi.dlE()) {
                    this.jiy.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.jiy.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bmm() == 0) {
                    this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jiy.btK();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lPS != null) {
            this.lPS.e(fVar, this.lFf);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dja() != null) {
            return fVar.dja();
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.diP())) {
            Iterator<PostData> it = fVar.diP().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dLm() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.diW();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnx() != null && postData.bnx().getUserTbVipInfoData() != null && postData.bnx().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnx().getGodUserData().setIntro(postData.bnx().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.bnx() == null) {
            return false;
        }
        MetaData bnx = postData.bnx();
        return (TextUtils.isEmpty(bnx.getUserId()) && TextUtils.isEmpty(bnx.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.diN() == null || fVar.diN().bnx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnx = fVar.diN().bnx();
        String userId = bnx.getUserId();
        HashMap<String, MetaData> userMap = fVar.diN().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnx;
        }
        postData.Jk(1);
        postData.setId(fVar.diN().bnN());
        postData.setTitle(fVar.diN().getTitle());
        postData.setTime(fVar.diN().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.diN() != null) {
            if (this.lEi.djV()) {
                if (fVar.diM() != null) {
                    this.mForumName = fVar.diM().getForumName();
                    this.mForumId = fVar.diM().getForumId();
                }
                if (this.mForumName == null && this.lEi.dkd() != null && this.lEi.dkd().djW() != null) {
                    this.mForumName = this.lEi.dkd().djW();
                }
            }
            PostData b2 = b(fVar, z);
            a(b2, fVar);
            this.lPU.setVisibility(8);
            if (fVar.djn()) {
                this.lRl = true;
                this.lPL.vM(true);
                this.lPL.mNavigationBar.hideBottomLine();
                if (this.lPR == null) {
                    this.lPR = new com.baidu.tieba.pb.pb.main.a.e(this.lEi);
                }
                this.lPR.a(fVar, b2, this.lPP, this.lPU, this.lQP, this.lPL, this.mForumName, this.lRA);
                this.lPR.X(this.lRO);
                doF();
            } else {
                this.lRl = false;
                this.lPL.vM(this.lRl);
                if (this.lPR != null) {
                    this.lPR.c(this.lPP);
                }
            }
            if (this.lEi.dkU() != null) {
                this.lEi.dkU().vG(this.lRl);
            }
            if (b2 != null) {
                this.lQL = b2;
                this.lPU.setVisibility(0);
                SparseArray<Object> dpE = this.lPU.dpE();
                dpE.put(R.id.tag_clip_board, b2);
                dpE.put(R.id.tag_is_subpb, false);
                this.lPV.a(fVar, this.lPP);
                this.lPT.C(fVar);
                this.lPS.e(fVar, this.lFf);
                this.lPS.B(fVar);
                this.lPU.a(this.mSkinType, this.lFA, b2, this.lRO);
                if (this.lQS != null) {
                    if (fVar.djq()) {
                        this.lQS.getView().setVisibility(8);
                    } else {
                        this.lQS.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCC);
                        if (fVar.diN() != null) {
                            nVar.lCE = fVar.diN().bno();
                        }
                        nVar.isNew = !this.lFf;
                        nVar.sortType = fVar.lBm;
                        nVar.lCG = fVar.djr();
                        nVar.lCH = this.lEi.dlE();
                        nVar.lCI = fVar.lBl;
                        this.lQS.a(nVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ap.this.lQa != null && ap.this.lPL != null && ap.this.lPL.lWk != null && ap.this.lFA != null && ap.this.lFA.diN() != null && !ap.this.lFA.diN().bmc() && !ap.this.doJ() && ap.this.lFA.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(ap.this.lFA.getForum().getName())) {
                            if ((ap.this.lQa.dkH() == null || !ap.this.lQa.dkH().isShown()) && ap.this.lPL.lWk != null) {
                                ap.this.lPL.lWk.setVisibility(0);
                                if (ap.this.lEi != null && ap.this.lEi.dkd() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dW("tid", ap.this.lEi.dkd().dme());
                                    aqVar.dW("fid", ap.this.lEi.dkd().getForumId());
                                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void vq(boolean z) {
        if (z) {
            doC();
        } else {
            cvg();
        }
        this.lQW.lSe = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQW));
        a(this.lQW.lSe, false);
    }

    public void doC() {
        if (this.lPL != null && !this.lRn) {
            this.lPL.doC();
            this.lRn = true;
        }
    }

    public void cvg() {
        if (this.lPL != null) {
            this.lPL.dqd();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lPU.a(postData, fVar);
    }

    public void doD() {
        if (this.lPR != null) {
            this.lPR.d(this.lPP);
        }
    }

    public boolean doE() {
        return this.bfV;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aN(bz bzVar) {
        if (bzVar == null || bzVar.bnx() == null) {
            return false;
        }
        PostData b2 = b(this.lFA, false);
        String str = "";
        if (b2 != null && b2.bnx() != null) {
            str = b2.bnx().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lPL.dqa();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lPL.JU(dVar.forumName);
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
            final String str2 = dVar.lBd;
            this.lEi.showNetRefreshView(this.bIt, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        be.bsB().b(ap.this.lEi.getPageContext(), new String[]{str2});
                        ap.this.lEi.finish();
                        return;
                    }
                    ap.this.lEi.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable dnF;
        Parcelable dnF2;
        if (fVar != null && this.lPP != null) {
            this.lFA = fVar;
            this.mType = i;
            if (fVar.diN() != null) {
                this.lQY = fVar.diN().bne();
                if (fVar.diN().getAnchorLevel() != 0) {
                    this.bfV = true;
                }
                this.lQt = aN(fVar.diN());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lQM = false;
            this.lFf = z;
            doy();
            if (fVar.lBn != null && fVar.lBn.djy()) {
                if (this.lPQ == null) {
                    this.lPQ = new PbThreadPostView(this.lEi.getContext());
                    this.lPP.addHeaderView(this.lPQ, 1);
                    this.lPQ.setData(fVar);
                    this.lPQ.setChildOnClickLinstener(this.jdo);
                }
            } else if (this.lPQ != null && this.lPP != null) {
                this.lPP.removeHeaderView(this.lPQ);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lRx == null) {
                this.lRx = new ae(this.lEi.getPageContext(), this.jGC);
            }
            this.lRx.OM(fVar.diU());
            if (this.lEi.dlu()) {
                if (this.lQe == null) {
                    this.lQe = new com.baidu.tieba.pb.view.e(this.lEi.getPageContext());
                    this.lQe.createView();
                    this.lQe.setListPullRefreshListener(this.fhg);
                }
                this.lPP.setPullRefresh(this.lQe);
                doF();
                if (this.lQe != null) {
                    this.lQe.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bmn() == 0 && z) {
                this.lPP.setPullRefresh(null);
            } else {
                if (this.lQe == null) {
                    this.lQe = new com.baidu.tieba.pb.view.e(this.lEi.getPageContext());
                    this.lQe.createView();
                    this.lQe.setListPullRefreshListener(this.fhg);
                }
                this.lPP.setPullRefresh(this.lQe);
                doF();
                if (this.lQe != null) {
                    this.lQe.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                cjr();
            }
            doK();
            this.lQa.uw(this.lFf);
            this.lQa.ux(false);
            this.lQa.uB(i == 5);
            this.lQa.uC(i == 6);
            this.lQa.uD(z2 && this.lRN && i != 2);
            this.lQa.a(fVar, false);
            this.lQa.notifyDataSetChanged();
            this.lPU.b(b(fVar, z), fVar.djq());
            if (fVar.diN() != null && fVar.diN().bni() != null && this.lPJ != -1) {
                fVar.diN().bni().setIsLike(this.lPJ);
            }
            this.lPP.removeFooterView(this.bJc);
            this.lPP.addFooterView(this.bJc);
            if (TbadkCoreApplication.isLogin()) {
                this.lPP.setNextPage(this.jiy);
                this.lPK = 2;
                cjr();
            } else {
                this.lQM = true;
                if (fVar.getPage().bmm() == 1) {
                    if (this.lQf == null) {
                        this.lQf = new com.baidu.tieba.pb.view.a(this.lEi, this.lEi);
                    }
                    this.lPP.setNextPage(this.lQf);
                } else {
                    this.lPP.setNextPage(this.jiy);
                }
                this.lPK = 3;
            }
            ArrayList<PostData> diP = fVar.diP();
            if (fVar.getPage().bmm() == 0 || diP == null || diP.size() < fVar.getPage().bml()) {
                if (com.baidu.tbadk.core.util.x.getCount(diP) == 0 || (com.baidu.tbadk.core.util.x.getCount(diP) == 1 && diP.get(0) != null && diP.get(0).dLm() == 1)) {
                    if (this.lQW == null || this.lQW.lSe == null || this.lQW.lSe.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lQW.lSe.getView().getTop() < 0 ? this.lQW.lSe.getView().getHeight() : this.lQW.lSe.getView().getBottom();
                    }
                    if (this.lEi.dlE()) {
                        this.jiy.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.jiy.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lEi.dkU() != null && !this.lEi.dkU().dpO()) {
                        this.lEi.dkU().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bmm() == 0) {
                        this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jiy.btK();
                }
                if (fVar.getPage().bmm() == 0 || diP == null) {
                    doU();
                }
            } else {
                if (z2) {
                    if (this.lRN) {
                        endLoadData();
                        if (fVar.getPage().bmm() != 0) {
                            this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jiy.setLineVisible();
                        this.jiy.showLoading();
                    }
                } else {
                    this.jiy.setLineVisible();
                    this.jiy.showLoading();
                }
                this.jiy.btK();
            }
            switch (i) {
                case 2:
                    this.lPP.setSelection(i2 > 1 ? (((this.lPP.getData() == null && fVar.diP() == null) ? 0 : (this.lPP.getData().size() - fVar.diP().size()) + this.lPP.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (dnF2 = aj.dnE().dnF()) != null && !(dnF2 instanceof RecyclerView.SavedState)) {
                        this.lPP.onRestoreInstanceState(dnF2);
                        if (com.baidu.tbadk.core.util.x.getCount(diP) > 1 && fVar.getPage().bmm() > 0) {
                            this.jiy.endLoadData();
                            this.jiy.setText(this.lEi.getString(R.string.pb_load_more_without_point));
                            this.jiy.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lRN = false;
                    break;
                case 5:
                    this.lPP.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (dnF = aj.dnE().dnF()) != null && !(dnF instanceof RecyclerView.SavedState)) {
                        this.lPP.onRestoreInstanceState(dnF);
                        break;
                    } else {
                        this.lPP.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lPR != null && this.lPR.bRe() != null) {
                            if (this.lEi.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lPP.setSelectionFromTop((this.lQa.dkC() + this.lPP.getHeaderViewsCount()) - 1, this.lPR.dpG() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lEi.getPageContext().getPageActivity()));
                            } else {
                                this.lPP.setSelectionFromTop((this.lQa.dkC() + this.lPP.getHeaderViewsCount()) - 1, this.lPR.dpG());
                            }
                        } else {
                            this.lPP.setSelection(this.lQa.dkC() + this.lPP.getHeaderViewsCount());
                        }
                    } else {
                        this.lPP.setSelection(i2 > 0 ? ((this.lPP.getData() == null && fVar.diP() == null) ? 0 : (this.lPP.getData().size() - fVar.diP().size()) + this.lPP.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.jiy.endLoadData();
                    this.jiy.setText(this.lEi.getString(R.string.pb_load_more_without_point));
                    this.jiy.setLineGone();
                    break;
            }
            if (this.lQY == lQZ && isHost()) {
                dpb();
            }
            if (this.lRj) {
                dnR();
                this.lRj = false;
                if (i3 == 0) {
                    vj(true);
                }
            }
            if (fVar.lBj == 1 || fVar.lBk == 1) {
                if (this.lRp == null) {
                    this.lRp = new PbTopTipView(this.lEi.getContext());
                }
                if (fVar.lBk == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lEi.getStType())) {
                    this.lRp.setText(this.lEi.getString(R.string.pb_read_strategy_add_experience));
                    this.lRp.a(this.bIt, this.mSkinType);
                } else if (fVar.lBj == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lEi.getStType())) {
                    this.lRp.setText(this.lEi.getString(R.string.pb_read_news_add_experience));
                    this.lRp.a(this.bIt, this.mSkinType);
                }
            }
            this.lPP.removeFooterView(this.lRE.getView());
            if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.djv()) && fVar.getPage().bmm() == 0) {
                this.lPP.removeFooterView(this.bJc);
                this.lRE.Gj(Math.max(this.lQz.getMeasuredHeight(), this.lQK / 2));
                this.lPP.addFooterView(this.lRE.getView());
                this.lRE.H(fVar);
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null) {
            x(fVar);
            if (fVar.bjE()) {
                WebPManager.a(this.lQD, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lQD, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String FK = FK(fVar.diN().bno());
            if (this.lQG != null) {
                this.lQG.setText(FK);
            }
            if (this.lQH != null) {
                this.lQH.setText(FK);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.diN()));
        }
    }

    private String FK(int i) {
        if (i == 0) {
            return this.lEi.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + "W";
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + "W";
        } else {
            return "" + i;
        }
    }

    private void doF() {
        if (this.lPR != null) {
            this.lPR.a(this.lPP, this.textView, this.mType);
        }
    }

    public void vr(boolean z) {
        this.lQs = z;
    }

    public void endLoadData() {
        if (this.jiy != null) {
            this.jiy.setLineGone();
            this.jiy.endLoadData();
        }
        cjr();
    }

    public void bXh() {
        this.lPP.setVisibility(0);
    }

    public void doG() {
        if (this.lPP != null) {
            this.lPP.setVisibility(8);
        }
        if (this.lPP != null) {
            this.lQP.setVisibility(8);
        }
        if (this.lPL != null && this.lPL.jri != null) {
            this.lPL.jri.setVisibility(8);
        }
    }

    public void doH() {
        if (this.lPP != null) {
            this.lPP.setVisibility(0);
        }
        if (this.lQP != null) {
            this.lQP.setVisibility(0);
        }
        if (this.lPL != null && this.lPL.jri != null) {
            this.lPL.jri.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lQL != null && this.lQL.bnx() != null && this.lPL != null) {
            this.lRm = !this.lRl;
            this.lPL.vI(this.lRm);
            if (this.lEi.dkU() != null) {
                this.lEi.dkU().vH(this.lRm);
            }
            doI();
            if (this.lEi != null && !this.lEi.djV() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.djk())) {
                bv bvVar = fVar.djk().get(0);
                if (bvVar != null) {
                    this.lPL.fV(bvVar.getForumName(), bvVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lPL.fV(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.lRm) {
                this.lPU.a(fVar, this.lQL, this.lQt);
                if (this.lQR != null) {
                    this.lQR.setVisibility(8);
                }
                if (this.lRv == null) {
                    this.lRv = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ap.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (ap.this.lEi != null && ap.this.lEi.isAdded()) {
                                if (i < 0 && f > ap.this.lRo) {
                                    ap.this.doP();
                                    ap.this.dpa();
                                }
                                ap.this.doz();
                            }
                        }
                    };
                }
                this.lPP.setListViewDragListener(this.lRv);
                return;
            }
            if (this.lQR != null) {
                this.lQR.setVisibility(0);
            }
            this.lPU.a(fVar, this.lQL, this.lQt);
            this.lRv = null;
            this.lPP.setListViewDragListener(null);
        }
    }

    private void doI() {
        this.lPU.a(this.lFA, this.lQL, this.lRm, this.lRl);
    }

    public boolean doJ() {
        return this.lFA == null || this.lFA.getForum() == null || "0".equals(this.lFA.getForum().getId()) || "me0407".equals(this.lFA.getForum().getName());
    }

    private boolean doK() {
        return this.lPS.vD(this.lFf);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.diN() == null) {
            return false;
        }
        if (fVar.diN().bnu() == 1 || fVar.diN().getThreadType() == 33) {
            return true;
        }
        return !(fVar.diN().bnw() == null || fVar.diN().bnw().bpR() == 0) || fVar.diN().bns() == 1 || fVar.diN().bnt() == 1 || fVar.diN().bol() || fVar.diN().boH() || fVar.diN().boA() || fVar.diN().bnI() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.diN().getCategory()) || fVar.diN().bnA() || fVar.diN().bnz();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lPT != null) {
                if (fVar.diN() != null && fVar.diN().bnL() == 0 && !fVar.diN().bmc() && !this.lRG) {
                    if (fVar.diN() != null) {
                        bz diN = fVar.diN();
                        diN.z(true, w(fVar));
                        diN.ng(3);
                        diN.zQ("2");
                    }
                    if (fVar.diN().bme()) {
                        this.lPU.c(this.lPP);
                        this.lPT.c(this.lPP);
                        this.lPT.b(this.lPP);
                        this.lPU.b(this.lPP);
                        this.lPU.G(this.lFA);
                        if (A(fVar)) {
                            this.lPT.c(this.lPP);
                        } else {
                            this.lPT.D(fVar);
                        }
                    } else {
                        this.lPU.G(this.lFA);
                        if (A(fVar)) {
                            this.lPT.c(this.lPP);
                        } else {
                            this.lPT.F(fVar);
                        }
                    }
                } else if (fVar.diN().bnL() == 1) {
                    if (fVar.diN() != null) {
                        this.lPT.c(this.lPP);
                        this.lPU.G(this.lFA);
                    }
                } else {
                    this.lPT.c(this.lPP);
                    this.lPU.G(this.lFA);
                }
            }
            z(fVar);
            this.lFf = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            doK();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b2;
        com.baidu.tbadk.core.data.ac acVar;
        StringBuilder sb = null;
        if (fVar != null && (b2 = b(fVar, z)) != null) {
            String userId = b2.bnx().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b2.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.djc()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b2.bnx() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b2.bnx().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b2.bnx().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b2.bnx().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b2.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b2.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.djc()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bv> djk = fVar.djk();
                if (com.baidu.tbadk.core.util.x.getCount(djk) > 0) {
                    sb = new StringBuilder();
                    for (bv bvVar : djk) {
                        if (bvVar != null && !StringUtils.isNull(bvVar.getForumName()) && (acVar = bvVar.eNA) != null && acVar.eLk && !acVar.eLl && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bvVar.getForumName(), 12)).append(this.lEi.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lEi.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View doL() {
        return this.fGq;
    }

    public boolean doM() {
        if (this.bJc == null || this.bJc.getParent() == null || this.jiy.isLoading()) {
            return false;
        }
        int bottom = this.bJc.getBottom();
        Rect rect = new Rect();
        this.bJc.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void OO(String str) {
        if (this.jiy != null) {
            this.jiy.setText(str);
        }
    }

    public void OP(String str) {
        if (this.jiy != null) {
            int i = 0;
            if (this.lQW != null && this.lQW.lSe != null && this.lQW.lSe.getView() != null) {
                i = this.lQW.lSe.getView().getTop() < 0 ? this.lQW.lSe.getView().getHeight() : this.lQW.lSe.getView().getBottom();
            }
            this.jiy.ar(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lPP;
    }

    public int doN() {
        return R.id.richText;
    }

    public TextView dkn() {
        return this.lPU.dkn();
    }

    public void d(BdListView.e eVar) {
        this.lPP.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fhg = cVar;
        if (this.lQe != null) {
            this.lQe.setListPullRefreshListener(cVar);
        }
    }

    public void a(ax axVar, a.b bVar) {
        if (axVar != null) {
            int bmk = axVar.bmk();
            int bmh = axVar.bmh();
            if (this.lQb != null) {
                this.lQb.bqe();
            } else {
                this.lQb = new com.baidu.tbadk.core.dialog.a(this.lEi.getPageContext().getPageActivity());
                this.lQc = LayoutInflater.from(this.lEi.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lQb.br(this.lQc);
                this.lQb.a(R.string.dialog_ok, bVar);
                this.lQb.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ap.this.doP();
                        aVar.dismiss();
                    }
                });
                this.lQb.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ap.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ap.this.lRg == null) {
                            ap.this.lRg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.23.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ap.this.lEi.HidenSoftKeyPad((InputMethodManager) ap.this.lEi.getBaseFragmentActivity().getSystemService("input_method"), ap.this.bIt);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mB().postDelayed(ap.this.lRg, 150L);
                    }
                });
                this.lQb.b(this.lEi.getPageContext()).bqe();
            }
            this.lQd = (EditText) this.lQc.findViewById(R.id.input_page_number);
            this.lQd.setText("");
            TextView textView = (TextView) this.lQc.findViewById(R.id.current_page_number);
            if (bmk <= 0) {
                bmk = 1;
            }
            if (bmh <= 0) {
                bmh = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bmk), Integer.valueOf(bmh)));
            this.lEi.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lQd, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lPP.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lEi.showToast(str);
    }

    public boolean vs(boolean z) {
        if (this.acX == null || !this.acX.bAT()) {
            return false;
        }
        this.acX.bzl();
        return true;
    }

    public void doO() {
        if (this.lRP != null) {
            while (this.lRP.size() > 0) {
                TbImageView remove = this.lRP.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        doO();
        this.lQa.Fi(1);
        if (this.lPR != null) {
            this.lPR.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lQa.Fi(2);
        if (this.lPR != null) {
            this.lPR.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lEi.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lEi.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lQF != null) {
            this.lQF.onDestroy();
        }
        if (this.lRi != null) {
            this.lRi.destroy();
        }
        if (this.lRx != null) {
            this.lRx.onDestory();
        }
        if (this.lRp != null) {
            this.lRp.hide();
        }
        this.lEi.hideProgressBar();
        if (this.gvm != null && this.iXM != null) {
            this.gvm.b(this.iXM);
        }
        doP();
        endLoadData();
        if (this.lRg != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lRg);
        }
        if (this.lQO != null) {
            this.lQO.clearStatus();
        }
        this.lRJ = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lQa.Fi(3);
        if (this.bHz != null) {
            this.bHz.setBackgroundDrawable(null);
        }
        if (this.lPR != null) {
            this.lPR.destroy();
        }
        if (this.lQa != null) {
            this.lQa.onDestroy();
        }
        this.lPP.setOnLayoutListener(null);
        if (this.lRt != null) {
            this.lRt.cEk();
        }
        if (this.lQX != null) {
            this.lQX.onDestroy();
        }
        if (this.lPU != null) {
            this.lPU.onDestroy();
        }
    }

    public boolean FL(int i) {
        if (this.lPR != null) {
            return this.lPR.FL(i);
        }
        return false;
    }

    public void doP() {
        this.lPL.baz();
        if (this.lPU != null) {
            this.lPU.doP();
        }
        if (this.lEi != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lEi.getContext(), this.lQd);
        }
        dnT();
        if (this.lIK != null) {
            this.lIK.dismiss();
        }
        doR();
        if (this.lQb != null) {
            this.lQb.dismiss();
        }
        if (this.jdn != null) {
            this.jdn.dismiss();
        }
    }

    public void doQ() {
        this.lPL.baz();
        if (this.lPU != null) {
            this.lPU.doP();
        }
        if (this.lIK != null) {
            this.lIK.dismiss();
        }
        doR();
        if (this.lQb != null) {
            this.lQb.dismiss();
        }
        if (this.jdn != null) {
            this.jdn.dismiss();
        }
    }

    public void fp(List<String> list) {
        this.lRs = list;
        if (this.lRt != null) {
            this.lRt.setData(list);
        }
    }

    public void uv(boolean z) {
        this.lQa.uv(z);
    }

    public void vt(boolean z) {
        this.lQv = z;
    }

    public void doR() {
        if (this.lQj != null) {
            this.lQj.dismiss();
        }
        if (this.lQk != null) {
            com.baidu.adp.lib.f.g.b(this.lQk, this.lEi.getPageContext());
        }
        if (this.lQl != null) {
            com.baidu.adp.lib.f.g.b(this.lQl, this.lEi.getPageContext());
        }
        if (this.lQi != null) {
            this.lQi.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lFA, this.lFf);
            b(this.lFA, this.lFf, this.mType, i);
            this.lEi.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lEi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bIt);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.bIt, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lQw, R.color.CAM_X0203);
            if (this.lPR != null) {
                this.lPR.onChangeSkinType(i);
            }
            if (this.lPV != null) {
                this.lPV.onChangeSkinType(i);
            }
            if (this.lPS != null) {
                this.lPS.onChangeSkinType(i);
            }
            if (this.lPT != null) {
                this.lPT.onChangeSkinType(i);
            }
            if (this.lPU != null) {
                this.lPU.onChangeSkinType(i);
            }
            if (this.jiy != null) {
                this.jiy.changeSkin(i);
            }
            if (this.fGq != null) {
                this.lEi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fGq);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.fGq, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.lQb != null) {
                this.lQb.c(this.lEi.getPageContext());
            }
            vr(this.lQs);
            this.lQa.notifyDataSetChanged();
            if (this.lQe != null) {
                this.lQe.changeSkin(i);
            }
            if (this.acX != null) {
                this.acX.onChangeSkinType(i);
            }
            if (this.lQf != null) {
                this.lQf.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.itJ)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.itJ) {
                    customBlueCheckRadioButton.btu();
                }
            }
            dol();
            UtilHelper.setStatusBarBackground(this.bHz, i);
            UtilHelper.setStatusBarBackground(this.lQR, i);
            if (this.lPW != null) {
                com.baidu.tbadk.r.a.a(this.lEi.getPageContext(), this.lPW);
            }
            if (this.lRh != null) {
                this.lRh.onChangeSkinType(i);
            }
            if (this.lPL != null) {
                if (this.lPR != null) {
                    this.lPR.FM(i);
                } else {
                    this.lPL.onChangeSkinType(i);
                }
            }
            if (this.lQB != null) {
                this.lQB.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0401));
            }
            if (this.lQA != null) {
                this.lQA.setBackgroundDrawable(com.baidu.tbadk.core.util.ao.aO(com.baidu.adp.lib.util.l.getDimens(this.lEi.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0209)));
            }
            if (this.lFA != null && this.lFA.bjE()) {
                WebPManager.a(this.lQD, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lQD, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.lQC, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lFA);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lQz, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lQy, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lRr, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kgY, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lQH, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lQG, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ao.d(this.lQG, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.lRu != null) {
                this.lRu.onChangeSkinType(i);
            }
            if (this.lQX != null) {
                this.lQX.onChangeSkinType();
            }
            if (this.lPQ != null) {
                this.lPQ.uo(i);
            }
            if (this.lQF != null) {
                this.lQF.onChangeSkinType();
            }
            if (this.lRE != null) {
                this.lRE.onChangeSkinType();
            }
        }
    }

    public void doS() {
        if (this.lQF != null) {
            this.lQF.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bc(fVar.diN())) {
            if (this.lQF != null) {
                this.lQF.setEnable(false);
                this.lQF.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lQE.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lQE.setLayoutParams(layoutParams);
            WebPManager.a(this.lQE, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lQF == null || !this.lQF.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lQE.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lQE.setLayoutParams(layoutParams2);
            WebPManager.a(this.lQE, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fSh = iVar;
        this.lQa.setOnImageClickListener(this.fSh);
        this.lRu.setOnImageClickListener(this.fSh);
    }

    public void g(NoNetworkView.a aVar) {
        this.iXM = aVar;
        if (this.gvm != null) {
            this.gvm.a(this.iXM);
        }
    }

    public void vu(boolean z) {
        this.lQa.setIsFromCDN(z);
    }

    public Button doT() {
        return this.lQx;
    }

    public void doU() {
        if (this.lPK != 2) {
            this.lPP.setNextPage(this.jiy);
            this.lPK = 2;
        }
    }

    public boolean doV() {
        return this.acX != null && this.acX.getVisibility() == 0;
    }

    public boolean doW() {
        return this.acX != null && this.acX.bAT();
    }

    public void doX() {
        if (this.acX != null) {
            this.acX.bzl();
        }
    }

    public void vv(boolean z) {
        if (this.lQz != null) {
            vt(this.lEi.dkR().bBD());
            if (this.lQv) {
                vk(z);
            } else {
                vl(z);
            }
        }
    }

    public void doY() {
        if (this.lQz != null) {
            this.lQy.setVisibility(8);
            this.lQz.setVisibility(8);
            this.lQI = false;
            if (this.lQX != null) {
                this.lQX.setVisibility(8);
                vp(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.ixW == null) {
            this.ixW = new com.baidu.tbadk.core.view.a(this.lEi.getPageContext());
        }
        this.ixW.setDialogVisiable(true);
    }

    public void cjr() {
        if (this.ixW != null) {
            this.ixW.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lPP.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lPP.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lPR != null) {
            this.lPR.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.mLastScrollY = getScrollY();
            this.lQW.lSe = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQW));
            a(this.lQW.lSe, true);
            dpn();
        }
    }

    public void vw(boolean z) {
        if (this.lPR != null) {
            this.lPR.vw(z);
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
        if (this.lPR != null) {
            this.lPR.onScroll(absListView, i, i2, i3);
        }
        if (this.lPL != null && this.lPU != null) {
            this.lPL.dP(this.lPU.dpC());
        }
        this.lQW.luW = i;
        this.lQW.headerCount = this.lPP.getHeaderViewsCount();
        this.lQW.lSe = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQW));
        vm(b(absListView, i));
        a(this.lQW.lSe, false);
        dpn();
        if (this.jiy.btL() && !this.jiy.fgf) {
            if (this.lQW != null && this.lQW.lSe != null && this.lQW.lSe.getView() != null) {
                i4 = this.lQW.lSe.getView().getTop() < 0 ? this.lQW.lSe.getView().getHeight() : this.lQW.lSe.getView().getBottom();
            }
            this.jiy.py(i4);
            this.jiy.fgf = true;
        }
    }

    public void doZ() {
        if (TbadkCoreApplication.isLogin() && this.lFA != null && this.lRm && !this.lRl && !this.lQt && this.lQL != null && this.lQL.bnx() != null && !this.lQL.bnx().getIsLike() && !this.lQL.bnx().hadConcerned() && this.lRi == null) {
            this.lRi = new al(this.lEi);
        }
    }

    public void dpa() {
        if (this.lEi != null) {
            if ((this.jap || this.lRB == 17) && com.baidu.tbadk.a.d.biP()) {
                if (this.lFA != null && this.lFA.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lFA.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lEi.getContext()).createNormalCfg(this.lFA.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dW("post_id", this.lFA.getThreadId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("fid", this.lFA.getForum().getId()));
                }
            } else if (this.lRm && !this.lRl && this.lQL != null && this.lQL.bnx() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").an("obj_locate", this.lEi.djV() ? 2 : 1).an("obj_type", this.lRl ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lEi.getPageContext().getPageActivity(), this.lQL.bnx().getUserId(), this.lQL.bnx().getUserName(), this.lEi.dkd().djW(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z) {
        int measuredHeight;
        if (!this.lRl && this.lQQ != null && this.lPL.dpU() != null) {
            int dkD = this.lQa.dkD();
            if (dkD > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                if (dkD > this.lPP.getFirstVisiblePosition() - this.lPP.getHeaderViewsCount()) {
                    this.lQQ.setVisibility(4);
                    return;
                }
                this.lQQ.setVisibility(0);
                vm(false);
                this.lPL.mNavigationBar.hideBottomLine();
                if (this.lQQ.getParent() != null && ((ViewGroup) this.lQQ.getParent()).getHeight() <= this.lQQ.getTop()) {
                    this.lQQ.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null || pbReplyTitleViewHolder.lPl == null) {
                if (this.lPP.getFirstVisiblePosition() == 0) {
                    this.lQQ.setVisibility(4);
                    this.lPL.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.lQV) {
                        this.lQU = top;
                        this.lQV = false;
                    }
                    this.lQU = top < this.lQU ? top : this.lQU;
                }
                if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                    if (this.lPZ.getY() < 0.0f) {
                        measuredHeight = lQT - pbReplyTitleViewHolder.lPl.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lPL.dpU().getMeasuredHeight() - pbReplyTitleViewHolder.lPl.getMeasuredHeight();
                        this.lPL.mNavigationBar.hideBottomLine();
                    }
                    if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.lQU) {
                        this.lQQ.setVisibility(0);
                        vm(false);
                    } else if (top < measuredHeight) {
                        this.lQQ.setVisibility(0);
                        vm(false);
                    } else {
                        this.lQQ.setVisibility(4);
                        this.lPL.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lQV = true;
                    }
                }
            }
        }
    }

    public void dpb() {
        if (!this.lRQ) {
            TiebaStatic.log("c10490");
            this.lRQ = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lEi.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lRa, Integer.valueOf(lRc));
            aVar.nt(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lEi.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.br(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lEi);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.24
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lEi.getPageContext()).bqe();
        }
    }

    public void OQ(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lEi.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lEi.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.br(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lRa, Integer.valueOf(lRd));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lEi);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lEi.getPageContext()).bqe();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b2;
        if (i > 0 && (b2 = b(fVar, z)) != null && b2.bnx() != null) {
            MetaData bnx = b2.bnx();
            bnx.setGiftNum(bnx.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.lPU.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dpc() {
        return this.lQO;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null && fVar.diN().boH() && this.lQO == null) {
            this.lQO = (PbInterviewStatusView) this.lQN.inflate();
            this.lQO.setOnClickListener(this.jdo);
            this.lQO.setCallback(this.lEi.dlC());
            this.lQO.setData(this.lEi, fVar);
        }
    }

    public RelativeLayout dpd() {
        return this.lPZ;
    }

    public View dpe() {
        return this.bHz;
    }

    public boolean dpf() {
        return this.lRG;
    }

    public void uA(boolean z) {
        this.lPU.uA(z);
    }

    public void OR(String str) {
        if (this.lPM != null) {
            this.lPM.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int vx(boolean z) {
        if (this.lQO == null || this.lQO.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dpg() {
        if (this.lQO != null && this.lQO.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lQO.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lQO.setLayoutParams(layoutParams);
        }
    }

    public boolean dkX() {
        return false;
    }

    public void OS(String str) {
        this.kgY.performClick();
        if (!StringUtils.isNull(str) && this.lEi.dkR() != null && this.lEi.dkR().bBv() != null && this.lEi.dkR().bBv().getInputView() != null) {
            EditText inputView = this.lEi.dkR().bBv().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            doP();
            if (configuration.orientation == 2) {
                doY();
                dnT();
            } else {
                dnX();
            }
            if (this.lRh != null) {
                this.lRh.dkM();
            }
            this.lEi.cBJ();
            this.lPZ.setVisibility(8);
            this.lPL.vJ(false);
            this.lEi.uP(false);
            if (this.lPR != null) {
                if (configuration.orientation == 1) {
                    dpd().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lPP.setIsLandscape(true);
                    this.lPP.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lPP.setIsLandscape(false);
                    if (this.mLastScrollY > 0) {
                        this.lPP.smoothScrollBy(this.mLastScrollY, 0);
                    }
                }
                this.lPR.onConfigurationChanged(configuration);
                this.lQP.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void vy(boolean z) {
        if (this.lPR != null) {
            this.lPR.vy(z);
        }
    }

    public boolean dph() {
        return this.lPR != null && this.lPR.dph();
    }

    public void dpi() {
        if (this.lPR != null) {
            this.lPR.dpi();
        }
    }

    public void uE(boolean z) {
        this.lQa.uE(z);
    }

    public void dO(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lQz.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lEi.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lRr = new TextView(this.lEi.getContext());
            this.lRr.setText(R.string.connection_tips);
            this.lRr.setGravity(17);
            this.lRr.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lEi.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lEi.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lEi.getContext(), R.dimen.ds60);
            if (this.lRr.getParent() == null) {
                frameLayout.addView(this.lRr, layoutParams);
            }
            this.lRq = new PopupWindow(this.lEi.getContext());
            this.lRq.setContentView(frameLayout);
            this.lRq.setHeight(-2);
            this.lRq.setWidth(-2);
            this.lRq.setFocusable(true);
            this.lRq.setOutsideTouchable(false);
            this.lRq.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lPP.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.26
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ap.this.lRq.showAsDropDown(ap.this.lQz, view.getLeft(), -ap.this.lQz.getHeight());
                    } else {
                        ap.this.lRq.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void vz(boolean z) {
        this.lRw = z;
    }

    public boolean dpj() {
        return this.lRw;
    }

    public PbThreadPostView dpk() {
        return this.lPQ;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null && !fVar.diN().bmc()) {
            boolean z = fVar.diN().bnt() == 1;
            boolean z2 = fVar.diN().bns() == 1;
            if (this.lPU != null) {
                this.lPU.c(fVar, z, z2);
            }
            if (this.lQa != null && this.lQa.dkI() != null) {
                this.lQa.dkI().b(fVar, z, z2);
            }
        }
    }

    public void vA(boolean z) {
        this.jap = z;
    }

    public void FD(int i) {
        this.lRB = i;
    }

    public void dpl() {
        if (this.lPP != null) {
            this.lPP.setForbidDragListener(true);
        }
    }

    public boolean dlW() {
        if (this.lPP == null) {
            return false;
        }
        return this.lPP.dlW();
    }

    public boolean dpm() {
        if (this.jiy == null || TextUtils.isEmpty(this.jiy.getEndText())) {
            return false;
        }
        return this.jiy.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.diN() == null) {
            return false;
        }
        SpannableStringBuilder bog = fVar.diN().bog();
        if (bog != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(bog.toString());
        }
        return true;
    }

    public void dpn() {
        boolean z;
        if (this.lRE != null) {
            if (((this.lRE.getView() == null || this.lRE.getView().getParent() == null) ? -1 : this.lPP.getPositionForView(this.lRE.getView())) != -1) {
                if (this.lRE.getView().getTop() + lRC <= this.lQQ.getBottom()) {
                    this.lRD = 1;
                    z = true;
                } else {
                    this.lRD = 0;
                    z = false;
                }
            } else {
                z = this.lRD == 1;
            }
            this.lQS.vi(this.lRD == 1);
            this.lRE.setScrollable(z);
        }
    }

    public LinearLayout dpo() {
        return this.lQA;
    }
}
