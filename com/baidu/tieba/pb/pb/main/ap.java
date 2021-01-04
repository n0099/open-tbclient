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
    private EditorTools acZ;
    private View bMl;
    private View bNO;
    private RelativeLayout bNf;
    private View fKX;
    private f.c flR;
    private com.baidu.tieba.pb.a.c fyb;
    private NoNetworkView gzT;
    private boolean isLandscape;
    private List<CustomBlueCheckRadioButton> iyq;
    private NavigationBarCoverTip jLi;
    private com.baidu.tieba.NEGFeedBack.f jOD;
    private boolean jeW;
    private View.OnClickListener jhV;
    private PbListView jnf;
    private TextView klE;
    private PbFragment lIO;
    private View.OnClickListener lJS;
    private com.baidu.tieba.pb.data.f lKf;
    private PbFakeFloorModel lMz;
    PbFragment.c lOq;
    private com.baidu.tieba.pb.pb.main.a.b lUA;
    private LinearLayout lUB;
    private TextView lUC;
    private TextView lUD;
    private ObservedChangeRelativeLayout lUE;
    private g lUF;
    private View lUL;
    public int lUo;
    public final com.baidu.tieba.pb.pb.main.view.c lUq;
    public com.baidu.tieba.pb.pb.main.view.b lUr;
    private ViewStub lUs;
    private ViewStub lUt;
    private PbLandscapeListView lUu;
    private PbThreadPostView lUv;
    private com.baidu.tieba.pb.pb.main.a.e lUw;
    private com.baidu.tieba.pb.pb.main.a.a lUx;
    private com.baidu.tieba.pb.pb.main.a.c lUy;
    private com.baidu.tieba.pb.pb.main.a.d lUz;
    private PbEmotionBar lVC;
    private int lVK;
    private Runnable lVL;
    private r lVM;
    private al lVN;
    private int lVT;
    private PbTopTipView lVU;
    private PopupWindow lVV;
    private TextView lVW;
    private List<String> lVX;
    private com.baidu.tieba.pb.pb.main.emotion.c lVY;
    private com.baidu.tieba.pb.pb.godreply.a lVZ;
    private View lVb;
    private View lVd;
    private View lVe;
    private LinearLayout lVf;
    private HeadImageView lVg;
    private ImageView lVh;
    private ImageView lVi;
    private ImageView lVj;
    private com.baidu.tieba.pb.view.d lVk;
    private TextView lVl;
    private TextView lVm;
    private int lVo;
    private int lVp;
    private PostData lVq;
    private ViewStub lVs;
    private PbInterviewStatusView lVt;
    private FrameLayout lVu;
    private View lVv;
    private View lVw;
    private PbReplyTitleViewHolder lVx;
    private PbLandscapeListView.b lWa;
    private ae lWc;
    private com.baidu.tieba.NEGFeedBack.i lWd;
    private String lWe;
    private long lWf;
    private int lWg;
    private com.baidu.tieba.pb.view.c lWj;
    private boolean lWl;
    private Runnable lWp;
    private PbFragment.b lWr;
    public int mLastScrollY;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int lVy = UtilHelper.getLightStatusBarHeight();
    public static int lVE = 3;
    public static int lVF = 0;
    public static int lVG = 3;
    public static int lVH = 4;
    public static int lVI = 5;
    public static int lVJ = 6;
    private static final int lWh = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    private static a.InterfaceC0851a lWk = new a.InterfaceC0851a() { // from class: com.baidu.tieba.pb.pb.main.ap.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0851a
        public void onRefresh() {
        }
    };
    private int lUp = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lUG = null;
    private com.baidu.tbadk.core.dialog.b jhU = null;
    private View lUH = null;
    private EditText lUI = null;
    private com.baidu.tieba.pb.view.e lUJ = null;
    private com.baidu.tieba.pb.view.a lUK = null;
    private b.InterfaceC0578b lUM = null;
    private TbRichTextView.i fWO = null;
    private NoNetworkView.a jct = null;
    private com.baidu.tbadk.core.dialog.i lUN = null;
    private com.baidu.tbadk.core.dialog.a lUO = null;
    private Dialog lUP = null;
    private Dialog lUQ = null;
    private View lUR = null;
    private LinearLayout lUS = null;
    private CompoundButton.OnCheckedChangeListener iyr = null;
    private TextView lUT = null;
    private TextView lUU = null;
    private String lUV = null;
    private com.baidu.tbadk.core.dialog.i lNp = null;
    private com.baidu.tbadk.core.dialog.i lUW = null;
    private boolean lUX = false;
    private boolean lUY = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lUZ = null;
    private boolean lVa = false;
    private Button lVc = null;
    private boolean lVn = true;
    private com.baidu.tbadk.core.view.a iCD = null;
    private boolean lJK = false;
    private int mSkinType = 3;
    private boolean lVr = false;
    private int lVz = 0;
    private boolean lVA = true;
    public a lVB = new a();
    private int lVD = 0;
    private boolean lVO = false;
    private int lVP = 0;
    private boolean lVQ = false;
    private boolean lVR = false;
    private boolean lVS = false;
    private boolean lWb = false;
    private int lWi = 0;
    private String lWm = null;
    private CustomMessageListener lWn = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ap.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ap.this.lWm = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ap.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ap.this.lUF != null) {
                ap.this.lUF.notifyDataSetChanged();
            }
        }
    };
    private Handler lWo = new Handler();
    private CustomMessageListener lWq = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ap.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ap.this.lVn = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lWs = true;
    View.OnClickListener lWt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || ap.this.lKf == null || ap.this.lKf.dmE() == null || ap.this.lKf.dmE().brq() == null || ap.this.lKf.dmE().brq().getAlaInfo() == null || ap.this.lKf.dmE().brq().getAlaInfo().live_status != 1) {
                if (ap.this.lVQ) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").an("obj_id", 2));
                }
                if (!ap.this.lVQ && ap.this.lKf != null && ap.this.lKf.dmE() != null && ap.this.lKf.dmE().brq() != null && ap.this.lKf.dmE().brq().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").an("obj_locate", 1));
                }
                if (ap.this.lIO.dpD() != null) {
                    ap.this.lIO.dpD().lJa.iOE.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (ap.this.lKf.dmE().brq().getAlaInfo() == null || !ap.this.lKf.dmE().brq().getAlaInfo().isChushou) {
                if (ap.this.lKf.dmE().brq().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = ap.this.lKf.dmE().brq().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ap.this.lIO.dpD(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            be.bwu().b(ap.this.lIO.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + ap.this.lKf.dmE().brq().getAlaInfo().thirdRoomId + "&livetype=" + ap.this.lKf.dmE().brq().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bkL = false;
    String userId = null;
    private final List<TbImageView> lWu = new ArrayList();
    private boolean lWv = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int headerCount;
        public PbReplyTitleViewHolder lWJ;
        public int lzC;
    }

    public void vn(boolean z) {
        this.lVO = z;
        if (this.lUu != null) {
            this.lVP = this.lUu.getHeaderViewsCount();
        }
    }

    public void drI() {
        if (this.lUu != null) {
            int headerViewsCount = this.lUu.getHeaderViewsCount() - this.lVP;
            final int firstVisiblePosition = (this.lUu.getFirstVisiblePosition() == 0 || this.lUu.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lUu.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lUu.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lVB.lWJ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lVB));
            final PbReplyTitleViewHolder pbReplyTitleViewHolder = this.lVB.lWJ;
            final int g = g(pbReplyTitleViewHolder);
            final int y = ((int) this.lUE.getY()) + this.lUE.getMeasuredHeight();
            final boolean z = this.lVv.getVisibility() == 0;
            boolean z2 = this.lUE.getY() < 0.0f;
            if ((z && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.lUF.dov() + this.lUu.getHeaderViewsCount()) {
                int measuredHeight = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.lTQ.getMeasuredHeight() : 0;
                if (z2) {
                    this.lUu.setSelectionFromTop(this.lUF.dov() + this.lUu.getHeaderViewsCount(), lVy - measuredHeight);
                } else {
                    this.lUu.setSelectionFromTop(this.lUF.dov() + this.lUu.getHeaderViewsCount(), this.lUq.dtL().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lUu.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.lVQ && this.lUw != null) {
                this.lUu.setSelectionFromTop(this.lUF.dov() + this.lUu.getHeaderViewsCount(), this.lUw.dtx());
            } else if (this.mType == 6) {
                this.lUu.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= ap.this.bNf.getMeasuredHeight()) {
                            int g2 = ap.this.g(pbReplyTitleViewHolder);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (ap.this.bNO != null && (layoutParams = ap.this.bNO.getLayoutParams()) != null) {
                                if (i == 0 || i > ap.this.bNf.getMeasuredHeight() || g2 >= ap.this.bNf.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.lVK;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ap.this.bNf.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.lVK;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    ap.this.lUu.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                ap.this.bNO.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ap.this.bNO != null && ap.this.bNO.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = ap.this.bNO.getLayoutParams();
                                            layoutParams2.height = ap.this.lVK;
                                            ap.this.bNO.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        ap.this.lUu.setOnLayoutListener(null);
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

    public NoNetworkView drJ() {
        return this.gzT;
    }

    public void drK() {
        if (this.acZ != null) {
            this.acZ.hide();
            if (this.lVY != null) {
                this.lVY.dtz();
            }
        }
    }

    public PbFakeFloorModel drL() {
        return this.lMz;
    }

    public r drM() {
        return this.lVM;
    }

    public com.baidu.tieba.pb.pb.main.a.e drN() {
        return this.lUw;
    }

    public void drO() {
        reset();
        drK();
        this.lVM.doE();
        vz(false);
    }

    private void reset() {
        if (this.lIO != null && this.lIO.doJ() != null && this.acZ != null) {
            com.baidu.tbadk.editortools.pb.a.bFl().setStatus(0);
            com.baidu.tbadk.editortools.pb.e doJ = this.lIO.doJ();
            doJ.bFG();
            doJ.bEV();
            if (doJ.getWriteImagesInfo() != null) {
                doJ.getWriteImagesInfo().setMaxImagesAllowed(doJ.isBJH ? 1 : 9);
            }
            doJ.sF(SendView.ALL);
            doJ.sG(SendView.ALL);
            com.baidu.tbadk.editortools.h ss = this.acZ.ss(23);
            com.baidu.tbadk.editortools.h ss2 = this.acZ.ss(2);
            com.baidu.tbadk.editortools.h ss3 = this.acZ.ss(5);
            if (ss2 != null) {
                ss2.rV();
            }
            if (ss3 != null) {
                ss3.rV();
            }
            if (ss != null) {
                ss.hide();
            }
            this.acZ.invalidate();
        }
    }

    public boolean drP() {
        return this.lVn;
    }

    public void vo(boolean z) {
        if (this.lVe != null && this.klE != null) {
            this.klE.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lVe.startAnimation(alphaAnimation);
            }
            this.lVd.setVisibility(0);
            this.lVe.setVisibility(0);
            this.lVn = true;
            if (this.lVC != null && !this.lVZ.isActive()) {
                this.lVC.setVisibility(0);
                vt(true);
            }
        }
    }

    public void vp(boolean z) {
        if (this.lVe != null && this.klE != null) {
            this.klE.setText(drQ());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lVe.startAnimation(alphaAnimation);
            }
            this.lVd.setVisibility(0);
            this.lVe.setVisibility(0);
            this.lVn = true;
            if (this.lVC != null && !this.lVZ.isActive()) {
                this.lVC.setVisibility(0);
                vt(true);
            }
        }
    }

    public String drQ() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.lWe)) {
            return this.lWe;
        }
        if (this.lIO != null) {
            this.lWe = TbadkCoreApplication.getInst().getResources().getString(ao.drG());
        }
        return this.lWe;
    }

    public PostData drR() {
        int i = 0;
        if (this.lUu == null) {
            return null;
        }
        int drS = drS() - this.lUu.getHeaderViewsCount();
        if (drS < 0) {
            drS = 0;
        }
        if (this.lUF.GN(drS) != null && this.lUF.GN(drS) != PostData.nru) {
            i = drS + 1;
        }
        return this.lUF.getItem(i) instanceof PostData ? (PostData) this.lUF.getItem(i) : null;
    }

    public int drS() {
        int i;
        View childAt;
        if (this.lUu == null) {
            return 0;
        }
        int firstVisiblePosition = this.lUu.getFirstVisiblePosition();
        int lastVisiblePosition = this.lUu.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lUu.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lUu.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int drT() {
        return this.lUu.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lKf != null && this.lKf.dmG() != null && !this.lKf.dmG().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lKf.dmG().size() && (postData = this.lKf.dmG().get(i)) != null && postData.brq() != null && !StringUtils.isNull(postData.brq().getUserId()); i++) {
                if (this.lKf.dmG().get(i).brq().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lVZ != null && this.lVZ.isActive()) {
                        vz(false);
                    }
                    if (this.lVC != null) {
                        this.lVC.vJ(true);
                    }
                    this.lWm = postData.brq().getName_show();
                    return;
                }
            }
        }
    }

    public ap(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lIO = null;
        this.bNf = null;
        this.bMl = null;
        this.lUu = null;
        this.lUF = null;
        this.jnf = null;
        this.fKX = null;
        this.jhV = null;
        this.lJS = null;
        this.lVe = null;
        this.klE = null;
        this.lVs = null;
        this.lVT = 0;
        this.lWf = 0L;
        this.lWf = System.currentTimeMillis();
        this.lIO = pbFragment;
        this.jhV = onClickListener;
        this.fyb = cVar;
        this.lVT = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lIO.getContext()) / 8;
        this.bNf = (RelativeLayout) LayoutInflater.from(this.lIO.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bNf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lVb = this.bNf.findViewById(R.id.bottom_shadow);
        this.jLi = (NavigationBarCoverTip) this.bNf.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bMl = this.bNf.findViewById(R.id.statebar_view);
        this.lUE = (ObservedChangeRelativeLayout) this.bNf.findViewById(R.id.title_wrapper);
        this.gzT = (NoNetworkView) this.bNf.findViewById(R.id.view_no_network);
        this.lUu = (PbLandscapeListView) this.bNf.findViewById(R.id.new_pb_list);
        this.lVu = (FrameLayout) this.bNf.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lIO.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lIO.getActivity(), R.dimen.ds88));
        this.lUu.addHeaderView(this.textView, 0);
        this.lUu.setTextViewAdded(true);
        this.lVK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bNO = new View(this.lIO.getPageContext().getPageActivity());
        this.bNO.setLayoutParams(new AbsListView.LayoutParams(-1, this.lVK));
        this.bNO.setVisibility(4);
        this.lUu.addFooterView(this.bNO);
        this.lUu.setOnTouchListener(this.lIO.bTP);
        this.lUq = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bNf);
        if (this.lIO.dpm()) {
            this.lUs = (ViewStub) this.bNf.findViewById(R.id.manga_view_stub);
            this.lUs.setVisibility(0);
            this.lUr = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lUr.show();
            this.lUq.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lIO.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lUq.dtL().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0807a() { // from class: com.baidu.tieba.pb.pb.main.ap.27
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0807a
            public void dnH() {
                if (ap.this.lUu != null) {
                    if (ap.this.lUw != null) {
                        ap.this.lUw.dtw();
                    }
                    ap.this.lUu.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0807a
            public void dnI() {
                ap.this.lIO.cFA();
            }
        }));
        this.lVd = this.bNf.findViewById(R.id.view_comment_top_line);
        this.lVe = this.bNf.findViewById(R.id.pb_editor_tool_comment);
        this.lVo = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lVp = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lVg = (HeadImageView) this.bNf.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lVg.setVisibility(0);
        this.lVg.setIsRound(true);
        this.lVg.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lIO.getContext(), R.dimen.L_X01));
        this.lVg.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0401));
        this.lVg.setPlaceHolder(0);
        drU();
        this.klE = (TextView) this.bNf.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lVf = (LinearLayout) this.bNf.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lVf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.lIO.doU();
                if (ap.this.lIO != null && ap.this.lIO.dnV() != null && ap.this.lIO.dnV().getPbData() != null && ap.this.lIO.dnV().getPbData().dmE() != null && ap.this.lIO.dnV().getPbData().dmE().brq() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dX("tid", ap.this.lIO.dnV().dpX()).dX("fid", ap.this.lIO.dnV().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", ap.this.lIO.dnV().lQw).dX("fid", ap.this.lIO.dnV().getPbData().getForumId()).an("obj_locate", 1).dX("uid", ap.this.lIO.dnV().getPbData().dmE().brq().getUserId()));
                }
            }
        });
        this.lVh = (ImageView) this.bNf.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lVh.setOnClickListener(this.jhV);
        boolean booleanExtra = this.lIO.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lVi = (ImageView) this.bNf.findViewById(R.id.pb_editor_tool_collection);
        this.lVi.setOnClickListener(this.jhV);
        if (booleanExtra) {
            this.lVi.setVisibility(8);
        } else {
            this.lVi.setVisibility(0);
        }
        this.lVj = (ImageView) this.bNf.findViewById(R.id.pb_editor_tool_share);
        this.lVj.setOnClickListener(this.jhV);
        this.lVk = new com.baidu.tieba.pb.view.d(this.lVj);
        this.lVk.dxf();
        this.lVl = (TextView) this.bNf.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lVl.setVisibility(0);
        this.lVs = (ViewStub) this.bNf.findViewById(R.id.interview_status_stub);
        this.lUx = new com.baidu.tieba.pb.pb.main.a.a(this.lIO, cVar);
        this.lUz = new com.baidu.tieba.pb.pb.main.a.d(this.lIO, cVar, this.jhV);
        this.lUF = new g(this.lIO, this.lUu);
        this.lUF.H(this.jhV);
        this.lUF.setTbGestureDetector(this.fyb);
        this.lUF.setOnImageClickListener(this.fWO);
        this.lUF.setOnSwitchChangeListener(this.lIO.lOj);
        this.lJS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.29
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
                            ap.this.lIO.f(sparseArray);
                            return;
                        }
                        ap.this.dN(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        ap.this.lIO.f(sparseArray);
                    } else if (booleanValue3) {
                        ap.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lUF.U(this.lJS);
        drZ();
        dsa();
        this.lUy.b(this.lUu);
        this.lUz.b(this.lUu);
        this.lUx.b(this.lUu);
        this.jnf = new PbListView(this.lIO.getPageContext().getPageActivity());
        this.fKX = this.jnf.getView().findViewById(R.id.pb_more_view);
        if (this.fKX != null) {
            this.fKX.setOnClickListener(this.jhV);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.fKX, R.drawable.pb_foot_more_trans_selector);
        }
        this.jnf.setLineVisible();
        this.jnf.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jnf.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lUL = this.bNf.findViewById(R.id.viewstub_progress);
        this.lIO.registerListener(this.lWq);
        this.lMz = new PbFakeFloorModel(this.lIO.getPageContext());
        this.lVM = new r(this.lIO.getPageContext(), this.lMz, this.bNf);
        this.lVM.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.drO();
            }
        });
        this.lVM.a(this.lIO.lOl);
        this.lMz.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ap.31
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                ap.this.lMz.u(postData);
                ap.this.lUF.notifyDataSetChanged();
                ap.this.lVM.doE();
                ap.this.acZ.bDe();
                ap.this.vz(false);
            }
        });
        if (this.lIO.dnV() != null && !StringUtils.isNull(this.lIO.dnV().dqG())) {
            this.lIO.showToast(this.lIO.dnV().dqG());
        }
        this.lVv = this.bNf.findViewById(R.id.pb_expand_blank_view);
        this.lVw = this.bNf.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lVw.getLayoutParams();
        if (this.lIO.dnV() != null && this.lIO.dnV().dqa()) {
            this.lVv.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lVw.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lVy;
            this.lVw.setLayoutParams(layoutParams2);
        }
        this.lVx = new PbReplyTitleViewHolder(this.lIO.getPageContext(), this.bNf.findViewById(R.id.pb_reply_expand_view));
        this.lVx.v(pbFragment.lNe);
        this.lVx.lTQ.setVisibility(8);
        this.lVx.W(this.jhV);
        this.lVx.setOnSwitchChangeListener(this.lIO.lOj);
        this.lIO.registerListener(this.mAccountChangedListener);
        this.lIO.registerListener(this.lWn);
        drV();
        vt(false);
        this.lWj = new com.baidu.tieba.pb.view.c(this.lIO.getPageContext());
    }

    private void drU() {
        if (this.lVg != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lVg.setImageResource(0);
            this.lVg.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lVg.setImageResource(R.drawable.transparent_bg);
    }

    public void vq(boolean z) {
        this.lVb.setVisibility(z ? 0 : 8);
    }

    public void cUe() {
        if (!this.lIO.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").an("obj_locate", 2).dX("fid", this.mForumId));
        } else if (this.lIO.doW()) {
            com.baidu.tbadk.editortools.pb.e doJ = this.lIO.doJ();
            if (doJ != null && (doJ.bFD() || doJ.bFE())) {
                this.lIO.doJ().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acZ != null) {
                dsf();
            }
            if (this.acZ != null) {
                this.lVn = false;
                if (this.acZ.sv(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lIO.getPageContext(), (View) this.acZ.sv(2).fDH, false, lWk);
                }
            }
            dsP();
        }
    }

    private void drV() {
        this.lVZ = new com.baidu.tieba.pb.pb.godreply.a(this.lIO, this, (ViewStub) this.bNf.findViewById(R.id.more_god_reply_popup));
        this.lVZ.C(this.jhV);
        this.lVZ.U(this.lJS);
        this.lVZ.setOnImageClickListener(this.fWO);
        this.lVZ.C(this.jhV);
        this.lVZ.setTbGestureDetector(this.fyb);
    }

    public com.baidu.tieba.pb.pb.godreply.a drW() {
        return this.lVZ;
    }

    public View drX() {
        return this.lVv;
    }

    public void drY() {
        if (this.lUu != null) {
            this.lUy.c(this.lUu);
            this.lUz.c(this.lUu);
            this.lUA.c(this.lUu);
            this.lUx.c(this.lUu);
        }
    }

    private void drZ() {
        if (this.lUA == null) {
            this.lUA = new com.baidu.tieba.pb.pb.main.a.b(this.lIO, this.jhV);
        }
    }

    private void dsa() {
        if (this.lUy == null) {
            this.lUy = new com.baidu.tieba.pb.pb.main.a.c(this.lIO, this.fyb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsb() {
        if (this.lIO.dpm()) {
            this.lUt = (ViewStub) this.bNf.findViewById(R.id.manga_mention_controller_view_stub);
            this.lUt.setVisibility(0);
            if (this.lUB == null) {
                this.lUB = (LinearLayout) this.bNf.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lIO.getPageContext(), this.lUB);
            }
            if (this.lUC == null) {
                this.lUC = (TextView) this.lUB.findViewById(R.id.manga_prev_btn);
            }
            if (this.lUD == null) {
                this.lUD = (TextView) this.lUB.findViewById(R.id.manga_next_btn);
            }
            this.lUC.setOnClickListener(this.jhV);
            this.lUD.setOnClickListener(this.jhV);
        }
    }

    private void dsc() {
        if (this.lIO.dpm()) {
            if (this.lIO.dpp() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lUC, R.color.CAM_X0110, 1);
            }
            if (this.lIO.dpq() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lUD, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dsd() {
        if (this.lUB == null) {
            dsb();
        }
        this.lUt.setVisibility(8);
        if (this.lWo != null && this.lWp != null) {
            this.lWo.removeCallbacks(this.lWp);
        }
    }

    public void dse() {
        if (this.lWo != null) {
            if (this.lWp != null) {
                this.lWo.removeCallbacks(this.lWp);
            }
            this.lWp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ap.this.lUB == null) {
                        ap.this.dsb();
                    }
                    ap.this.lUt.setVisibility(0);
                }
            };
            this.lWo.postDelayed(this.lWp, 2000L);
        }
    }

    public void vr(boolean z) {
        this.lUq.vr(z);
        if (z && this.lVr) {
            this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lUu.setNextPage(this.jnf);
            this.lUp = 2;
        }
        drU();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
        this.acZ.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.drO();
            }
        });
        this.acZ.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acZ.getParent() == null) {
            this.bNf.addView(this.acZ, layoutParams);
        }
        this.acZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acZ.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.ap.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bzW() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bzW() == EmotionGroupType.USER_COLLECT) {
                        if (ap.this.mPermissionJudgePolicy == null) {
                            ap.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        ap.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        ap.this.mPermissionJudgePolicy.appendRequestPermission(ap.this.lIO.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ap.this.mPermissionJudgePolicy.startRequestPermission(ap.this.lIO.getBaseFragmentActivity())) {
                            ap.this.lIO.doJ().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            ap.this.lIO.doJ().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        drK();
        this.lIO.doJ().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ap.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ap.this.acZ != null && ap.this.acZ.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ap.this.lVY == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ap.this.acZ.getId());
                            ap.this.lVY = new com.baidu.tieba.pb.pb.main.emotion.c(ap.this.lIO.getPageContext(), ap.this.bNf, layoutParams2);
                            if (!com.baidu.tbadk.core.util.x.isEmpty(ap.this.lVX)) {
                                ap.this.lVY.setData(ap.this.lVX);
                            }
                            ap.this.lVY.c(ap.this.acZ);
                        }
                        ap.this.lVY.Qf(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ap.this.lIO.kSQ != null && ap.this.lIO.kSQ.dti() != null) {
                    if (!ap.this.lIO.kSQ.dti().dXT()) {
                        ap.this.lIO.kSQ.vF(false);
                    }
                    ap.this.lIO.kSQ.dti().zc(false);
                }
            }
        });
    }

    public void dsf() {
        if (this.lIO != null && this.acZ != null) {
            this.acZ.rV();
            if (this.lIO.doJ() != null) {
                this.lIO.doJ().bFt();
            }
            dsP();
        }
    }

    public void vs(boolean z) {
        if (this.lUu != null && this.textView != null && this.bMl != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bMl.setVisibility(0);
                } else {
                    this.bMl.setVisibility(8);
                    this.lUu.removeHeaderView(this.textView);
                    this.lUu.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lVy;
                    this.textView.setLayoutParams(layoutParams);
                }
                dsw();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + vB(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dsw();
            dsX();
        }
    }

    public g dsg() {
        return this.lUF;
    }

    public void a(PbFragment.c cVar) {
        this.lOq = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lIO.getContext());
        kVar.setTitleText(this.lIO.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lUN.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            ap.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (ap.this.lWr != null) {
                                ap.this.lWr.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            ap.this.lIO.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lIO.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lIO.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eXH.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dsW()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.lIO.getString(R.string.forbidden_person), kVar);
            gVar3.eXH.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lIO.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lIO.getString(R.string.mute), kVar);
            }
            gVar.eXH.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.k(com.baidu.tieba.pb.pb.main.d.a.fs(arrayList), true);
        this.lUN = new com.baidu.tbadk.core.dialog.i(this.lIO.getPageContext(), kVar);
        this.lUN.SY();
    }

    public void a(PbFragment.b bVar) {
        this.lWr = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lIO != null && aVar != null) {
            if (this.jOD == null && this.lUx != null) {
                this.jOD = new com.baidu.tieba.NEGFeedBack.f(this.lIO.getPageContext(), this.lUx.dts());
            }
            AntiData cDY = this.lIO.cDY();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDY != null && cDY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDY.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jOD.setDefaultReasonArray(new String[]{this.lIO.getString(R.string.delete_thread_reason_1), this.lIO.getString(R.string.delete_thread_reason_2), this.lIO.getString(R.string.delete_thread_reason_3), this.lIO.getString(R.string.delete_thread_reason_4), this.lIO.getString(R.string.delete_thread_reason_5)});
            this.jOD.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jOD.Fh(str);
            this.jOD.a(new f.b() { // from class: com.baidu.tieba.pb.pb.main.ap.9
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    ap.this.lIO.a(aVar, jSONArray);
                }
            });
        }
    }

    private boolean dsh() {
        if (this.lIO == null || this.lIO.dnV().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.lIO.dnV().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        String str;
        if (this.lIO != null && aVar != null) {
            if (this.lWd == null && this.lUx != null) {
                this.lWd = new com.baidu.tieba.NEGFeedBack.i(this.lIO.getPageContext(), this.lUx.dts(), hVar, userData);
            }
            AntiData cDY = this.lIO.cDY();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDY != null && cDY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDY.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lWd.setDefaultReasonArray(new String[]{this.lIO.getString(R.string.delete_thread_reason_1), this.lIO.getString(R.string.delete_thread_reason_2), this.lIO.getString(R.string.delete_thread_reason_3), this.lIO.getString(R.string.delete_thread_reason_4), this.lIO.getString(R.string.delete_thread_reason_5)});
            this.lWd.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lWd.Fh(str);
            this.lWd.a(new i.b() { // from class: com.baidu.tieba.pb.pb.main.ap.10
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    ap.this.lIO.a(aVar, jSONArray);
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
        sparseArray.put(lVF, Integer.valueOf(lVG));
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
        this.lUO = new com.baidu.tbadk.core.dialog.a(this.lIO.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lUO.pa(i3);
        } else {
            this.lUO.setOnlyMessageShowCenter(false);
            this.lUO.Bp(str2);
        }
        this.lUO.setYesButtonTag(sparseArray);
        this.lUO.a(R.string.dialog_ok, this.lIO);
        this.lUO.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lUO.jH(true);
        this.lUO.b(this.lIO.getPageContext());
        if (z) {
            this.lUO.btX();
        } else if (dsh()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lIO.dnV().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.lIO.dnV().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.lIO.dnV().getPbData().dnn().has_forum_rule.intValue());
            hVar.ej(this.lIO.dnV().getPbData().getForum().getId(), this.lIO.dnV().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.lIO.dnV().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.lIO.dnV().getPbData().getForum().getUser_level());
            a(this.lUO, i, hVar, this.lIO.dnV().getPbData().getUserData());
        } else {
            a(this.lUO, i);
        }
    }

    public void bf(ArrayList<com.baidu.tbadk.core.data.ak> arrayList) {
        if (this.lUR == null) {
            this.lUR = LayoutInflater.from(this.lIO.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lIO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lUR);
        if (this.lUQ == null) {
            this.lUQ = new Dialog(this.lIO.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lUQ.setCanceledOnTouchOutside(true);
            this.lUQ.setCancelable(true);
            this.lUZ = (ScrollView) this.lUR.findViewById(R.id.good_scroll);
            this.lUQ.setContentView(this.lUR);
            WindowManager.LayoutParams attributes = this.lUQ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lUQ.getWindow().setAttributes(attributes);
            this.iyr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ap.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.this.lUV = (String) compoundButton.getTag();
                        if (ap.this.iyq != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ap.this.iyq) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ap.this.lUV != null && !str.equals(ap.this.lUV)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lUS = (LinearLayout) this.lUR.findViewById(R.id.good_class_group);
            this.lUU = (TextView) this.lUR.findViewById(R.id.dialog_button_cancel);
            this.lUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.lUQ instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(ap.this.lUQ, ap.this.lIO.getPageContext());
                    }
                }
            });
            this.lUT = (TextView) this.lUR.findViewById(R.id.dialog_button_ok);
            this.lUT.setOnClickListener(this.jhV);
        }
        this.lUS.removeAllViews();
        this.iyq = new ArrayList();
        CustomBlueCheckRadioButton fV = fV("0", this.lIO.getPageContext().getString(R.string.thread_good_class));
        this.iyq.add(fV);
        fV.setChecked(true);
        this.lUS.addView(fV);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.bpC()) && akVar.bpD() > 0) {
                    CustomBlueCheckRadioButton fV2 = fV(String.valueOf(akVar.bpD()), akVar.bpC());
                    this.iyq.add(fV2);
                    View view = new View(this.lIO.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ao.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lUS.addView(view);
                    this.lUS.addView(fV2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lUZ.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lIO.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lIO.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lIO.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lUZ.setLayoutParams(layoutParams2);
            this.lUZ.removeAllViews();
            if (this.lUS != null && this.lUS.getParent() == null) {
                this.lUZ.addView(this.lUS);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lUQ, this.lIO.getPageContext());
    }

    private CustomBlueCheckRadioButton fV(String str, String str2) {
        Activity pageActivity = this.lIO.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iyr);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dsi() {
        this.lIO.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lIO.hideProgressBar();
        if (z && z2) {
            this.lIO.showToast(this.lIO.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lIO.showToast(str);
        }
    }

    public void dsj() {
        this.lUL.setVisibility(0);
    }

    public void dsk() {
        this.lUL.setVisibility(8);
    }

    public View dsl() {
        if (this.lUR != null) {
            return this.lUR.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dsm() {
        return this.lUV;
    }

    public View getView() {
        return this.bNf;
    }

    public void dsn() {
        if (this.lIO != null && this.lIO.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lIO.getPageContext().getPageActivity(), this.lIO.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lIO.hideProgressBar();
        if (z) {
            dsG();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dsH();
        } else {
            dsG();
        }
    }

    public void dso() {
        this.jnf.setLineVisible();
        this.jnf.startLoadData();
    }

    public void dsp() {
        this.lIO.hideProgressBar();
        endLoadData();
        this.lUu.completePullRefreshPostDelayed(0L);
        dsB();
    }

    public void dsq() {
        this.lUu.completePullRefreshPostDelayed(0L);
        dsB();
    }

    private void vt(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lUz.b(onLongClickListener);
        this.lUF.setOnLongClickListener(onLongClickListener);
        if (this.lVZ != null) {
            this.lVZ.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0578b interfaceC0578b, boolean z, boolean z2) {
        if (this.lNp != null) {
            this.lNp.dismiss();
            this.lNp = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lIO.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lIO.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lIO.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lIO.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lIO.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lUW.dismiss();
                interfaceC0578b.a(null, i, view);
            }
        });
        this.lUW = new com.baidu.tbadk.core.dialog.i(this.lIO.getPageContext(), kVar);
        this.lUW.SY();
    }

    public void a(final b.InterfaceC0578b interfaceC0578b, boolean z) {
        if (this.lUW != null) {
            this.lUW.dismiss();
            this.lUW = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lIO.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lKf != null && this.lKf.dmE() != null && !this.lKf.dmE().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lIO.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lIO.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lUW.dismiss();
                interfaceC0578b.a(null, i, view);
            }
        });
        this.lUW = new com.baidu.tbadk.core.dialog.i(this.lIO.getPageContext(), kVar);
        this.lUW.SY();
    }

    public int dsr() {
        return Ho(this.lUu.getFirstVisiblePosition());
    }

    private int Ho(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.lUu.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lUu.getAdapter() == null || !(this.lUu.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.lUu.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dss() {
        int lastVisiblePosition = this.lUu.getLastVisiblePosition();
        if (this.lUw != null) {
            if (lastVisiblePosition == this.lUu.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Ho(lastVisiblePosition);
    }

    public void Hp(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.lUu != null) {
            if (this.lUq == null || this.lUq.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lUq.mNavigationBar.getFixedNavHeight();
                if (this.lIO.dpc() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lVw != null && (layoutParams = (LinearLayout.LayoutParams) this.lVw.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lVw.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lUu.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lUu.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lUu.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lUI.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lUF.a(fVar, false);
        this.lUF.notifyDataSetChanged();
        dsB();
        if (this.lVZ != null) {
            this.lVZ.bSg();
        }
        ArrayList<PostData> dmG = fVar.dmG();
        if (fVar.getPage().bqf() == 0 || dmG == null || dmG.size() < fVar.getPage().bqe()) {
            if (com.baidu.tbadk.core.util.x.getCount(dmG) == 0 || (com.baidu.tbadk.core.util.x.getCount(dmG) == 1 && dmG.get(0) != null && dmG.get(0).dPd() == 1)) {
                if (this.lVB == null || this.lVB.lWJ == null || this.lVB.lWJ.getView() == null) {
                    i = 0;
                } else {
                    i = this.lVB.lWJ.getView().getTop() < 0 ? this.lVB.lWJ.getView().getHeight() : this.lVB.lWJ.getView().getBottom();
                }
                if (this.lIO.dpw()) {
                    this.jnf.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.jnf.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bqf() == 0) {
                    this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jnf.bxD();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lUx != null) {
            this.lUx.e(fVar, this.lJK);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dmR() != null) {
            return fVar.dmR();
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.dmG())) {
            Iterator<PostData> it = fVar.dmG().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPd() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dmN();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.brq() != null && postData.brq().getUserTbVipInfoData() != null && postData.brq().getUserTbVipInfoData().getvipIntro() != null) {
            postData.brq().getGodUserData().setIntro(postData.brq().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.brq() == null) {
            return false;
        }
        MetaData brq = postData.brq();
        return (TextUtils.isEmpty(brq.getUserId()) && TextUtils.isEmpty(brq.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmE() == null || fVar.dmE().brq() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData brq = fVar.dmE().brq();
        String userId = brq.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmE().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = brq;
        }
        postData.KR(1);
        postData.setId(fVar.dmE().brG());
        postData.setTitle(fVar.dmE().getTitle());
        postData.setTime(fVar.dmE().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dmE() != null) {
            if (this.lIO.dnN()) {
                if (fVar.dmD() != null) {
                    this.mForumName = fVar.dmD().getForumName();
                    this.mForumId = fVar.dmD().getForumId();
                }
                if (this.mForumName == null && this.lIO.dnV() != null && this.lIO.dnV().dnO() != null) {
                    this.mForumName = this.lIO.dnV().dnO();
                }
            }
            PostData b2 = b(fVar, z);
            a(b2, fVar);
            this.lUz.setVisibility(8);
            if (fVar.dne()) {
                this.lVQ = true;
                this.lUq.vQ(true);
                this.lUq.mNavigationBar.hideBottomLine();
                if (this.lUw == null) {
                    this.lUw = new com.baidu.tieba.pb.pb.main.a.e(this.lIO);
                }
                this.lUw.a(fVar, b2, this.lUu, this.lUz, this.lVu, this.lUq, this.mForumName, this.lWf);
                this.lUw.X(this.lWt);
                dsw();
            } else {
                this.lVQ = false;
                this.lUq.vQ(this.lVQ);
                if (this.lUw != null) {
                    this.lUw.c(this.lUu);
                }
            }
            if (this.lIO.doM() != null) {
                this.lIO.doM().vK(this.lVQ);
            }
            if (b2 != null) {
                this.lVq = b2;
                this.lUz.setVisibility(0);
                SparseArray<Object> dtv = this.lUz.dtv();
                dtv.put(R.id.tag_clip_board, b2);
                dtv.put(R.id.tag_is_subpb, false);
                this.lUA.a(fVar, this.lUu);
                this.lUy.C(fVar);
                this.lUx.e(fVar, this.lJK);
                this.lUx.B(fVar);
                this.lUz.a(this.mSkinType, this.lKf, b2, this.lWt);
                if (this.lVx != null) {
                    if (fVar.dnh()) {
                        this.lVx.getView().setVisibility(8);
                    } else {
                        this.lVx.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lHi);
                        if (fVar.dmE() != null) {
                            nVar.lHk = fVar.dmE().brh();
                        }
                        nVar.isNew = !this.lJK;
                        nVar.sortType = fVar.lFS;
                        nVar.lHm = fVar.dni();
                        nVar.lHn = this.lIO.dpw();
                        nVar.lHo = fVar.lFR;
                        this.lVx.a(nVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ap.this.lUF != null && ap.this.lUq != null && ap.this.lUq.maS != null && ap.this.lKf != null && ap.this.lKf.dmE() != null && !ap.this.lKf.dmE().bpV() && !ap.this.dsA() && ap.this.lKf.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(ap.this.lKf.getForum().getName())) {
                            if ((ap.this.lUF.doz() == null || !ap.this.lUF.doz().isShown()) && ap.this.lUq.maS != null) {
                                ap.this.lUq.maS.setVisibility(0);
                                if (ap.this.lIO != null && ap.this.lIO.dnV() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dX("tid", ap.this.lIO.dnV().dpW());
                                    aqVar.dX("fid", ap.this.lIO.dnV().getForumId());
                                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void vu(boolean z) {
        if (z) {
            dst();
        } else {
            cyX();
        }
        this.lVB.lWJ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lVB));
        a(this.lVB.lWJ, false);
    }

    public void dst() {
        if (this.lUq != null && !this.lVS) {
            this.lUq.dst();
            this.lVS = true;
        }
    }

    public void cyX() {
        if (this.lUq != null) {
            this.lUq.dtU();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lUz.a(postData, fVar);
    }

    public void dsu() {
        if (this.lUw != null) {
            this.lUw.d(this.lUu);
        }
    }

    public boolean dsv() {
        return this.bkL;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aN(bz bzVar) {
        if (bzVar == null || bzVar.brq() == null) {
            return false;
        }
        PostData b2 = b(this.lKf, false);
        String str = "";
        if (b2 != null && b2.brq() != null) {
            str = b2.brq().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lUq.dtR();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lUq.Lf(dVar.forumName);
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
            final String str2 = dVar.lFJ;
            this.lIO.showNetRefreshView(this.bNf, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        be.bwu().b(ap.this.lIO.getPageContext(), new String[]{str2});
                        ap.this.lIO.finish();
                        return;
                    }
                    ap.this.lIO.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable drw;
        Parcelable drw2;
        if (fVar != null && this.lUu != null) {
            this.lKf = fVar;
            this.mType = i;
            if (fVar.dmE() != null) {
                this.lVD = fVar.dmE().bqX();
                if (fVar.dmE().getAnchorLevel() != 0) {
                    this.bkL = true;
                }
                this.lUY = aN(fVar.dmE());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lVr = false;
            this.lJK = z;
            dsp();
            if (fVar.lFT != null && fVar.lFT.dnp()) {
                if (this.lUv == null) {
                    this.lUv = new PbThreadPostView(this.lIO.getContext());
                    this.lUu.addHeaderView(this.lUv, 1);
                    this.lUv.setData(fVar);
                    this.lUv.setChildOnClickLinstener(this.jhV);
                }
            } else if (this.lUv != null && this.lUu != null) {
                this.lUu.removeHeaderView(this.lUv);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lWc == null) {
                this.lWc = new ae(this.lIO.getPageContext(), this.jLi);
            }
            this.lWc.PV(fVar.dmL());
            if (this.lIO.dpm()) {
                if (this.lUJ == null) {
                    this.lUJ = new com.baidu.tieba.pb.view.e(this.lIO.getPageContext());
                    this.lUJ.createView();
                    this.lUJ.setListPullRefreshListener(this.flR);
                }
                this.lUu.setPullRefresh(this.lUJ);
                dsw();
                if (this.lUJ != null) {
                    this.lUJ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bqg() == 0 && z) {
                this.lUu.setPullRefresh(null);
            } else {
                if (this.lUJ == null) {
                    this.lUJ = new com.baidu.tieba.pb.view.e(this.lIO.getPageContext());
                    this.lUJ.createView();
                    this.lUJ.setListPullRefreshListener(this.flR);
                }
                this.lUu.setPullRefresh(this.lUJ);
                dsw();
                if (this.lUJ != null) {
                    this.lUJ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                cni();
            }
            dsB();
            this.lUF.uA(this.lJK);
            this.lUF.uB(false);
            this.lUF.uF(i == 5);
            this.lUF.uG(i == 6);
            this.lUF.uH(z2 && this.lWs && i != 2);
            this.lUF.a(fVar, false);
            this.lUF.notifyDataSetChanged();
            this.lUz.b(b(fVar, z), fVar.dnh());
            if (fVar.dmE() != null && fVar.dmE().brb() != null && this.lUo != -1) {
                fVar.dmE().brb().setIsLike(this.lUo);
            }
            this.lUu.removeFooterView(this.bNO);
            this.lUu.addFooterView(this.bNO);
            if (TbadkCoreApplication.isLogin()) {
                this.lUu.setNextPage(this.jnf);
                this.lUp = 2;
                cni();
            } else {
                this.lVr = true;
                if (fVar.getPage().bqf() == 1) {
                    if (this.lUK == null) {
                        this.lUK = new com.baidu.tieba.pb.view.a(this.lIO, this.lIO);
                    }
                    this.lUu.setNextPage(this.lUK);
                } else {
                    this.lUu.setNextPage(this.jnf);
                }
                this.lUp = 3;
            }
            ArrayList<PostData> dmG = fVar.dmG();
            if (fVar.getPage().bqf() == 0 || dmG == null || dmG.size() < fVar.getPage().bqe()) {
                if (com.baidu.tbadk.core.util.x.getCount(dmG) == 0 || (com.baidu.tbadk.core.util.x.getCount(dmG) == 1 && dmG.get(0) != null && dmG.get(0).dPd() == 1)) {
                    if (this.lVB == null || this.lVB.lWJ == null || this.lVB.lWJ.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lVB.lWJ.getView().getTop() < 0 ? this.lVB.lWJ.getView().getHeight() : this.lVB.lWJ.getView().getBottom();
                    }
                    if (this.lIO.dpw()) {
                        this.jnf.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.jnf.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lIO.doM() != null && !this.lIO.doM().dtF()) {
                        this.lIO.doM().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bqf() == 0) {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jnf.bxD();
                }
                if (fVar.getPage().bqf() == 0 || dmG == null) {
                    dsL();
                }
            } else {
                if (z2) {
                    if (this.lWs) {
                        endLoadData();
                        if (fVar.getPage().bqf() != 0) {
                            this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jnf.setLineVisible();
                        this.jnf.showLoading();
                    }
                } else {
                    this.jnf.setLineVisible();
                    this.jnf.showLoading();
                }
                this.jnf.bxD();
            }
            switch (i) {
                case 2:
                    this.lUu.setSelection(i2 > 1 ? (((this.lUu.getData() == null && fVar.dmG() == null) ? 0 : (this.lUu.getData().size() - fVar.dmG().size()) + this.lUu.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (drw2 = aj.drv().drw()) != null && !(drw2 instanceof RecyclerView.SavedState)) {
                        this.lUu.onRestoreInstanceState(drw2);
                        if (com.baidu.tbadk.core.util.x.getCount(dmG) > 1 && fVar.getPage().bqf() > 0) {
                            this.jnf.endLoadData();
                            this.jnf.setText(this.lIO.getString(R.string.pb_load_more_without_point));
                            this.jnf.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lWs = false;
                    break;
                case 5:
                    this.lUu.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (drw = aj.drv().drw()) != null && !(drw instanceof RecyclerView.SavedState)) {
                        this.lUu.onRestoreInstanceState(drw);
                        break;
                    } else {
                        this.lUu.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lUw != null && this.lUw.bUV() != null) {
                            if (this.lIO.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lUu.setSelectionFromTop((this.lUF.dou() + this.lUu.getHeaderViewsCount()) - 1, this.lUw.dtx() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lIO.getPageContext().getPageActivity()));
                            } else {
                                this.lUu.setSelectionFromTop((this.lUF.dou() + this.lUu.getHeaderViewsCount()) - 1, this.lUw.dtx());
                            }
                        } else {
                            this.lUu.setSelection(this.lUF.dou() + this.lUu.getHeaderViewsCount());
                        }
                    } else {
                        this.lUu.setSelection(i2 > 0 ? ((this.lUu.getData() == null && fVar.dmG() == null) ? 0 : (this.lUu.getData().size() - fVar.dmG().size()) + this.lUu.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.jnf.endLoadData();
                    this.jnf.setText(this.lIO.getString(R.string.pb_load_more_without_point));
                    this.jnf.setLineGone();
                    break;
            }
            if (this.lVD == lVE && isHost()) {
                dsS();
            }
            if (this.lVO) {
                drI();
                this.lVO = false;
                if (i3 == 0) {
                    vn(true);
                }
            }
            if (fVar.lFP == 1 || fVar.lFQ == 1) {
                if (this.lVU == null) {
                    this.lVU = new PbTopTipView(this.lIO.getContext());
                }
                if (fVar.lFQ == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lIO.getStType())) {
                    this.lVU.setText(this.lIO.getString(R.string.pb_read_strategy_add_experience));
                    this.lVU.a(this.bNf, this.mSkinType);
                } else if (fVar.lFP == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lIO.getStType())) {
                    this.lVU.setText(this.lIO.getString(R.string.pb_read_news_add_experience));
                    this.lVU.a(this.bNf, this.mSkinType);
                }
            }
            this.lUu.removeFooterView(this.lWj.getView());
            if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.dnm()) && fVar.getPage().bqf() == 0) {
                this.lUu.removeFooterView(this.bNO);
                this.lWj.HP(Math.max(this.lVe.getMeasuredHeight(), this.lVp / 2));
                this.lUu.addFooterView(this.lWj.getView());
                this.lWj.H(fVar);
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null) {
            x(fVar);
            if (fVar.bnx()) {
                WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Hq = Hq(fVar.dmE().brh());
            if (this.lVl != null) {
                this.lVl.setText(Hq);
            }
            if (this.lVm != null) {
                this.lVm.setText(Hq);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dmE()));
        }
    }

    private String Hq(int i) {
        if (i == 0) {
            return this.lIO.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dsw() {
        if (this.lUw != null) {
            this.lUw.a(this.lUu, this.textView, this.mType);
        }
    }

    public void vv(boolean z) {
        this.lUX = z;
    }

    public void endLoadData() {
        if (this.jnf != null) {
            this.jnf.setLineGone();
            this.jnf.endLoadData();
        }
        cni();
    }

    public void caY() {
        this.lUu.setVisibility(0);
    }

    public void dsx() {
        if (this.lUu != null) {
            this.lUu.setVisibility(8);
        }
        if (this.lUu != null) {
            this.lVu.setVisibility(8);
        }
        if (this.lUq != null && this.lUq.jvO != null) {
            this.lUq.jvO.setVisibility(8);
        }
    }

    public void dsy() {
        if (this.lUu != null) {
            this.lUu.setVisibility(0);
        }
        if (this.lVu != null) {
            this.lVu.setVisibility(0);
        }
        if (this.lUq != null && this.lUq.jvO != null) {
            this.lUq.jvO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lVq != null && this.lVq.brq() != null && this.lUq != null) {
            this.lVR = !this.lVQ;
            this.lUq.vM(this.lVR);
            if (this.lIO.doM() != null) {
                this.lIO.doM().vL(this.lVR);
            }
            dsz();
            if (this.lIO != null && !this.lIO.dnN() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.dnb())) {
                bv bvVar = fVar.dnb().get(0);
                if (bvVar != null) {
                    this.lUq.fW(bvVar.getForumName(), bvVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lUq.fW(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.lVR) {
                this.lUz.a(fVar, this.lVq, this.lUY);
                if (this.lVw != null) {
                    this.lVw.setVisibility(8);
                }
                if (this.lWa == null) {
                    this.lWa = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ap.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (ap.this.lIO != null && ap.this.lIO.isAdded()) {
                                if (i < 0 && f > ap.this.lVT) {
                                    ap.this.dsG();
                                    ap.this.dsR();
                                }
                                ap.this.dsq();
                            }
                        }
                    };
                }
                this.lUu.setListViewDragListener(this.lWa);
                return;
            }
            if (this.lVw != null) {
                this.lVw.setVisibility(0);
            }
            this.lUz.a(fVar, this.lVq, this.lUY);
            this.lWa = null;
            this.lUu.setListViewDragListener(null);
        }
    }

    private void dsz() {
        this.lUz.a(this.lKf, this.lVq, this.lVR, this.lVQ);
    }

    public boolean dsA() {
        return this.lKf == null || this.lKf.getForum() == null || "0".equals(this.lKf.getForum().getId()) || "me0407".equals(this.lKf.getForum().getName());
    }

    private boolean dsB() {
        return this.lUx.vH(this.lJK);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmE() == null) {
            return false;
        }
        if (fVar.dmE().brn() == 1 || fVar.dmE().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dmE().brp() == null || fVar.dmE().brp().btK() == 0) || fVar.dmE().brl() == 1 || fVar.dmE().brm() == 1 || fVar.dmE().bse() || fVar.dmE().bsA() || fVar.dmE().bst() || fVar.dmE().brB() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.dmE().getCategory()) || fVar.dmE().brt() || fVar.dmE().brs();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lUy != null) {
                if (fVar.dmE() != null && fVar.dmE().brE() == 0 && !fVar.dmE().bpV() && !this.lWl) {
                    if (fVar.dmE() != null) {
                        bz dmE = fVar.dmE();
                        dmE.z(true, w(fVar));
                        dmE.oM(3);
                        dmE.Bc("2");
                    }
                    if (fVar.dmE().bpX()) {
                        this.lUz.c(this.lUu);
                        this.lUy.c(this.lUu);
                        this.lUy.b(this.lUu);
                        this.lUz.b(this.lUu);
                        this.lUz.G(this.lKf);
                        if (A(fVar)) {
                            this.lUy.c(this.lUu);
                        } else {
                            this.lUy.D(fVar);
                        }
                    } else {
                        this.lUz.G(this.lKf);
                        if (A(fVar)) {
                            this.lUy.c(this.lUu);
                        } else {
                            this.lUy.F(fVar);
                        }
                    }
                } else if (fVar.dmE().brE() == 1) {
                    if (fVar.dmE() != null) {
                        this.lUy.c(this.lUu);
                        this.lUz.G(this.lKf);
                    }
                } else {
                    this.lUy.c(this.lUu);
                    this.lUz.G(this.lKf);
                }
            }
            z(fVar);
            this.lJK = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dsB();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b2;
        com.baidu.tbadk.core.data.ac acVar;
        StringBuilder sb = null;
        if (fVar != null && (b2 = b(fVar, z)) != null) {
            String userId = b2.brq().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b2.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dmT()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b2.brq() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b2.brq().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b2.brq().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b2.brq().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b2.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b2.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dmT()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bv> dnb = fVar.dnb();
                if (com.baidu.tbadk.core.util.x.getCount(dnb) > 0) {
                    sb = new StringBuilder();
                    for (bv bvVar : dnb) {
                        if (bvVar != null && !StringUtils.isNull(bvVar.getForumName()) && (acVar = bvVar.eSl) != null && acVar.ePV && !acVar.ePW && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bvVar.getForumName(), 12)).append(this.lIO.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lIO.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dsC() {
        return this.fKX;
    }

    public boolean dsD() {
        if (this.bNO == null || this.bNO.getParent() == null || this.jnf.isLoading()) {
            return false;
        }
        int bottom = this.bNO.getBottom();
        Rect rect = new Rect();
        this.bNO.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void PX(String str) {
        if (this.jnf != null) {
            this.jnf.setText(str);
        }
    }

    public void PY(String str) {
        if (this.jnf != null) {
            int i = 0;
            if (this.lVB != null && this.lVB.lWJ != null && this.lVB.lWJ.getView() != null) {
                i = this.lVB.lWJ.getView().getTop() < 0 ? this.lVB.lWJ.getView().getHeight() : this.lVB.lWJ.getView().getBottom();
            }
            this.jnf.ar(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lUu;
    }

    public int dsE() {
        return R.id.richText;
    }

    public TextView dof() {
        return this.lUz.dof();
    }

    public void d(BdListView.e eVar) {
        this.lUu.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.flR = cVar;
        if (this.lUJ != null) {
            this.lUJ.setListPullRefreshListener(cVar);
        }
    }

    public void a(ax axVar, a.b bVar) {
        if (axVar != null) {
            int bqd = axVar.bqd();
            int bqa = axVar.bqa();
            if (this.lUG != null) {
                this.lUG.btX();
            } else {
                this.lUG = new com.baidu.tbadk.core.dialog.a(this.lIO.getPageContext().getPageActivity());
                this.lUH = LayoutInflater.from(this.lIO.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lUG.br(this.lUH);
                this.lUG.a(R.string.dialog_ok, bVar);
                this.lUG.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ap.this.dsG();
                        aVar.dismiss();
                    }
                });
                this.lUG.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ap.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ap.this.lVL == null) {
                            ap.this.lVL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.23.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ap.this.lIO.HidenSoftKeyPad((InputMethodManager) ap.this.lIO.getBaseFragmentActivity().getSystemService("input_method"), ap.this.bNf);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mB().postDelayed(ap.this.lVL, 150L);
                    }
                });
                this.lUG.b(this.lIO.getPageContext()).btX();
            }
            this.lUI = (EditText) this.lUH.findViewById(R.id.input_page_number);
            this.lUI.setText("");
            TextView textView = (TextView) this.lUH.findViewById(R.id.current_page_number);
            if (bqd <= 0) {
                bqd = 1;
            }
            if (bqa <= 0) {
                bqa = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bqd), Integer.valueOf(bqa)));
            this.lIO.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lUI, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lUu.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lIO.showToast(str);
    }

    public boolean vw(boolean z) {
        if (this.acZ == null || !this.acZ.bEM()) {
            return false;
        }
        this.acZ.bDe();
        return true;
    }

    public void dsF() {
        if (this.lWu != null) {
            while (this.lWu.size() > 0) {
                TbImageView remove = this.lWu.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        dsF();
        this.lUF.GO(1);
        if (this.lUw != null) {
            this.lUw.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lUF.GO(2);
        if (this.lUw != null) {
            this.lUw.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lIO.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lIO.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lVk != null) {
            this.lVk.onDestroy();
        }
        if (this.lVN != null) {
            this.lVN.destroy();
        }
        if (this.lWc != null) {
            this.lWc.onDestory();
        }
        if (this.lVU != null) {
            this.lVU.hide();
        }
        this.lIO.hideProgressBar();
        if (this.gzT != null && this.jct != null) {
            this.gzT.b(this.jct);
        }
        dsG();
        endLoadData();
        if (this.lVL != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lVL);
        }
        if (this.lVt != null) {
            this.lVt.clearStatus();
        }
        this.lWo = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lUF.GO(3);
        if (this.bMl != null) {
            this.bMl.setBackgroundDrawable(null);
        }
        if (this.lUw != null) {
            this.lUw.destroy();
        }
        if (this.lUF != null) {
            this.lUF.onDestroy();
        }
        this.lUu.setOnLayoutListener(null);
        if (this.lVY != null) {
            this.lVY.cIb();
        }
        if (this.lVC != null) {
            this.lVC.onDestroy();
        }
        if (this.lUz != null) {
            this.lUz.onDestroy();
        }
    }

    public boolean Hr(int i) {
        if (this.lUw != null) {
            return this.lUw.Hr(i);
        }
        return false;
    }

    public void dsG() {
        this.lUq.bes();
        if (this.lUz != null) {
            this.lUz.dsG();
        }
        if (this.lIO != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lIO.getContext(), this.lUI);
        }
        drK();
        if (this.lNp != null) {
            this.lNp.dismiss();
        }
        dsI();
        if (this.lUG != null) {
            this.lUG.dismiss();
        }
        if (this.jhU != null) {
            this.jhU.dismiss();
        }
    }

    public void dsH() {
        this.lUq.bes();
        if (this.lUz != null) {
            this.lUz.dsG();
        }
        if (this.lNp != null) {
            this.lNp.dismiss();
        }
        dsI();
        if (this.lUG != null) {
            this.lUG.dismiss();
        }
        if (this.jhU != null) {
            this.jhU.dismiss();
        }
    }

    public void fp(List<String> list) {
        this.lVX = list;
        if (this.lVY != null) {
            this.lVY.setData(list);
        }
    }

    public void uz(boolean z) {
        this.lUF.uz(z);
    }

    public void vx(boolean z) {
        this.lVa = z;
    }

    public void dsI() {
        if (this.lUO != null) {
            this.lUO.dismiss();
        }
        if (this.lUP != null) {
            com.baidu.adp.lib.f.g.b(this.lUP, this.lIO.getPageContext());
        }
        if (this.lUQ != null) {
            com.baidu.adp.lib.f.g.b(this.lUQ, this.lIO.getPageContext());
        }
        if (this.lUN != null) {
            this.lUN.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lKf, this.lJK);
            b(this.lKf, this.lJK, this.mType, i);
            this.lIO.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lIO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bNf);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.bNf, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lVb, R.color.CAM_X0203);
            if (this.lUw != null) {
                this.lUw.onChangeSkinType(i);
            }
            if (this.lUA != null) {
                this.lUA.onChangeSkinType(i);
            }
            if (this.lUx != null) {
                this.lUx.onChangeSkinType(i);
            }
            if (this.lUy != null) {
                this.lUy.onChangeSkinType(i);
            }
            if (this.lUz != null) {
                this.lUz.onChangeSkinType(i);
            }
            if (this.jnf != null) {
                this.jnf.changeSkin(i);
            }
            if (this.fKX != null) {
                this.lIO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fKX);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.fKX, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.lUG != null) {
                this.lUG.c(this.lIO.getPageContext());
            }
            vv(this.lUX);
            this.lUF.notifyDataSetChanged();
            if (this.lUJ != null) {
                this.lUJ.changeSkin(i);
            }
            if (this.acZ != null) {
                this.acZ.onChangeSkinType(i);
            }
            if (this.lUK != null) {
                this.lUK.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.iyq)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.iyq) {
                    customBlueCheckRadioButton.bxn();
                }
            }
            dsc();
            UtilHelper.setStatusBarBackground(this.bMl, i);
            UtilHelper.setStatusBarBackground(this.lVw, i);
            if (this.lUB != null) {
                com.baidu.tbadk.r.a.a(this.lIO.getPageContext(), this.lUB);
            }
            if (this.lVM != null) {
                this.lVM.onChangeSkinType(i);
            }
            if (this.lUq != null) {
                if (this.lUw != null) {
                    this.lUw.Hs(i);
                } else {
                    this.lUq.onChangeSkinType(i);
                }
            }
            if (this.lVg != null) {
                this.lVg.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0401));
            }
            if (this.lVf != null) {
                this.lVf.setBackgroundDrawable(com.baidu.tbadk.core.util.ao.aO(com.baidu.adp.lib.util.l.getDimens(this.lIO.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0209)));
            }
            if (this.lKf != null && this.lKf.bnx()) {
                WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lKf);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lVe, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lVd, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lVW, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.klE, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lVm, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lVl, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ao.d(this.lVl, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.lVZ != null) {
                this.lVZ.onChangeSkinType(i);
            }
            if (this.lVC != null) {
                this.lVC.onChangeSkinType();
            }
            if (this.lUv != null) {
                this.lUv.vU(i);
            }
            if (this.lVk != null) {
                this.lVk.onChangeSkinType();
            }
            if (this.lWj != null) {
                this.lWj.onChangeSkinType();
            }
        }
    }

    public void dsJ() {
        if (this.lVk != null) {
            this.lVk.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bc(fVar.dmE())) {
            if (this.lVk != null) {
                this.lVk.setEnable(false);
                this.lVk.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lVj.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lVj.setLayoutParams(layoutParams);
            WebPManager.a(this.lVj, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lVk == null || !this.lVk.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lVj.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lVj.setLayoutParams(layoutParams2);
            WebPManager.a(this.lVj, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
        this.lUF.setOnImageClickListener(this.fWO);
        this.lVZ.setOnImageClickListener(this.fWO);
    }

    public void g(NoNetworkView.a aVar) {
        this.jct = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jct);
        }
    }

    public void vy(boolean z) {
        this.lUF.setIsFromCDN(z);
    }

    public Button dsK() {
        return this.lVc;
    }

    public void dsL() {
        if (this.lUp != 2) {
            this.lUu.setNextPage(this.jnf);
            this.lUp = 2;
        }
    }

    public boolean dsM() {
        return this.acZ != null && this.acZ.getVisibility() == 0;
    }

    public boolean dsN() {
        return this.acZ != null && this.acZ.bEM();
    }

    public void dsO() {
        if (this.acZ != null) {
            this.acZ.bDe();
        }
    }

    public void vz(boolean z) {
        if (this.lVe != null) {
            vx(this.lIO.doJ().bFw());
            if (this.lVa) {
                vo(z);
            } else {
                vp(z);
            }
        }
    }

    public void dsP() {
        if (this.lVe != null) {
            this.lVd.setVisibility(8);
            this.lVe.setVisibility(8);
            this.lVn = false;
            if (this.lVC != null) {
                this.lVC.setVisibility(8);
                vt(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.iCD == null) {
            this.iCD = new com.baidu.tbadk.core.view.a(this.lIO.getPageContext());
        }
        this.iCD.setDialogVisiable(true);
    }

    public void cni() {
        if (this.iCD != null) {
            this.iCD.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lUu.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lUu.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lUw != null) {
            this.lUw.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.mLastScrollY = getScrollY();
            this.lVB.lWJ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lVB));
            a(this.lVB.lWJ, true);
            dte();
        }
    }

    public void vA(boolean z) {
        if (this.lUw != null) {
            this.lUw.vA(z);
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
        if (this.lUw != null) {
            this.lUw.onScroll(absListView, i, i2, i3);
        }
        if (this.lUq != null && this.lUz != null) {
            this.lUq.dP(this.lUz.dtt());
        }
        this.lVB.lzC = i;
        this.lVB.headerCount = this.lUu.getHeaderViewsCount();
        this.lVB.lWJ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lVB));
        vq(b(absListView, i));
        a(this.lVB.lWJ, false);
        dte();
        if (this.jnf.bxE() && !this.jnf.fkQ) {
            if (this.lVB != null && this.lVB.lWJ != null && this.lVB.lWJ.getView() != null) {
                i4 = this.lVB.lWJ.getView().getTop() < 0 ? this.lVB.lWJ.getView().getHeight() : this.lVB.lWJ.getView().getBottom();
            }
            this.jnf.re(i4);
            this.jnf.fkQ = true;
        }
    }

    public void dsQ() {
        if (TbadkCoreApplication.isLogin() && this.lKf != null && this.lVR && !this.lVQ && !this.lUY && this.lVq != null && this.lVq.brq() != null && !this.lVq.brq().getIsLike() && !this.lVq.brq().hadConcerned() && this.lVN == null) {
            this.lVN = new al(this.lIO);
        }
    }

    public void dsR() {
        if (this.lIO != null) {
            if ((this.jeW || this.lWg == 17) && com.baidu.tbadk.a.d.bmI()) {
                if (this.lKf != null && this.lKf.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lKf.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lIO.getContext()).createNormalCfg(this.lKf.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dX("post_id", this.lKf.getThreadId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("fid", this.lKf.getForum().getId()));
                }
            } else if (this.lVR && !this.lVQ && this.lVq != null && this.lVq.brq() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").an("obj_locate", this.lIO.dnN() ? 2 : 1).an("obj_type", this.lVQ ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lIO.getPageContext().getPageActivity(), this.lVq.brq().getUserId(), this.lVq.brq().getUserName(), this.lIO.dnV().dnO(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z) {
        int measuredHeight;
        if (!this.lVQ && this.lVv != null && this.lUq.dtL() != null) {
            int dov = this.lUF.dov();
            if (dov > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                if (dov > this.lUu.getFirstVisiblePosition() - this.lUu.getHeaderViewsCount()) {
                    this.lVv.setVisibility(4);
                    return;
                }
                this.lVv.setVisibility(0);
                vq(false);
                this.lUq.mNavigationBar.hideBottomLine();
                if (this.lVv.getParent() != null && ((ViewGroup) this.lVv.getParent()).getHeight() <= this.lVv.getTop()) {
                    this.lVv.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null || pbReplyTitleViewHolder.lTQ == null) {
                if (this.lUu.getFirstVisiblePosition() == 0) {
                    this.lVv.setVisibility(4);
                    this.lUq.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.lVA) {
                        this.lVz = top;
                        this.lVA = false;
                    }
                    this.lVz = top < this.lVz ? top : this.lVz;
                }
                if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                    if (this.lUE.getY() < 0.0f) {
                        measuredHeight = lVy - pbReplyTitleViewHolder.lTQ.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lUq.dtL().getMeasuredHeight() - pbReplyTitleViewHolder.lTQ.getMeasuredHeight();
                        this.lUq.mNavigationBar.hideBottomLine();
                    }
                    if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.lVz) {
                        this.lVv.setVisibility(0);
                        vq(false);
                    } else if (top < measuredHeight) {
                        this.lVv.setVisibility(0);
                        vq(false);
                    } else {
                        this.lVv.setVisibility(4);
                        this.lUq.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lVA = true;
                    }
                }
            }
        }
    }

    public void dsS() {
        if (!this.lWv) {
            TiebaStatic.log("c10490");
            this.lWv = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIO.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lVF, Integer.valueOf(lVH));
            aVar.oZ(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lIO.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.br(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lIO);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.24
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lIO.getPageContext()).btX();
        }
    }

    public void PZ(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIO.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lIO.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.br(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lVF, Integer.valueOf(lVI));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lIO);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lIO.getPageContext()).btX();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b2;
        if (i > 0 && (b2 = b(fVar, z)) != null && b2.brq() != null) {
            MetaData brq = b2.brq();
            brq.setGiftNum(brq.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.lUz.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dsT() {
        return this.lVt;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null && fVar.dmE().bsA() && this.lVt == null) {
            this.lVt = (PbInterviewStatusView) this.lVs.inflate();
            this.lVt.setOnClickListener(this.jhV);
            this.lVt.setCallback(this.lIO.dpu());
            this.lVt.setData(this.lIO, fVar);
        }
    }

    public RelativeLayout dsU() {
        return this.lUE;
    }

    public View dsV() {
        return this.bMl;
    }

    public boolean dsW() {
        return this.lWl;
    }

    public void uE(boolean z) {
        this.lUz.uE(z);
    }

    public void Qa(String str) {
        if (this.lUr != null) {
            this.lUr.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int vB(boolean z) {
        if (this.lVt == null || this.lVt.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dsX() {
        if (this.lVt != null && this.lVt.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lVt.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lVt.setLayoutParams(layoutParams);
        }
    }

    public boolean doP() {
        return false;
    }

    public void Qb(String str) {
        this.klE.performClick();
        if (!StringUtils.isNull(str) && this.lIO.doJ() != null && this.lIO.doJ().bFo() != null && this.lIO.doJ().bFo().getInputView() != null) {
            EditText inputView = this.lIO.doJ().bFo().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dsG();
            if (configuration.orientation == 2) {
                dsP();
                drK();
            } else {
                drO();
            }
            if (this.lVM != null) {
                this.lVM.doE();
            }
            this.lIO.cFA();
            this.lUE.setVisibility(8);
            this.lUq.vN(false);
            this.lIO.uT(false);
            if (this.lUw != null) {
                if (configuration.orientation == 1) {
                    dsU().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lUu.setIsLandscape(true);
                    this.lUu.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lUu.setIsLandscape(false);
                    if (this.mLastScrollY > 0) {
                        this.lUu.smoothScrollBy(this.mLastScrollY, 0);
                    }
                }
                this.lUw.onConfigurationChanged(configuration);
                this.lVu.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void vC(boolean z) {
        if (this.lUw != null) {
            this.lUw.vC(z);
        }
    }

    public boolean dsY() {
        return this.lUw != null && this.lUw.dsY();
    }

    public void dsZ() {
        if (this.lUw != null) {
            this.lUw.dsZ();
        }
    }

    public void uI(boolean z) {
        this.lUF.uI(z);
    }

    public void dO(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lVe.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lIO.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lVW = new TextView(this.lIO.getContext());
            this.lVW.setText(R.string.connection_tips);
            this.lVW.setGravity(17);
            this.lVW.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lIO.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lIO.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lIO.getContext(), R.dimen.ds60);
            if (this.lVW.getParent() == null) {
                frameLayout.addView(this.lVW, layoutParams);
            }
            this.lVV = new PopupWindow(this.lIO.getContext());
            this.lVV.setContentView(frameLayout);
            this.lVV.setHeight(-2);
            this.lVV.setWidth(-2);
            this.lVV.setFocusable(true);
            this.lVV.setOutsideTouchable(false);
            this.lVV.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lUu.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.26
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ap.this.lVV.showAsDropDown(ap.this.lVe, view.getLeft(), -ap.this.lVe.getHeight());
                    } else {
                        ap.this.lVV.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void vD(boolean z) {
        this.lWb = z;
    }

    public boolean dta() {
        return this.lWb;
    }

    public PbThreadPostView dtb() {
        return this.lUv;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null && !fVar.dmE().bpV()) {
            boolean z = fVar.dmE().brm() == 1;
            boolean z2 = fVar.dmE().brl() == 1;
            if (this.lUz != null) {
                this.lUz.c(fVar, z, z2);
            }
            if (this.lUF != null && this.lUF.doA() != null) {
                this.lUF.doA().b(fVar, z, z2);
            }
        }
    }

    public void vE(boolean z) {
        this.jeW = z;
    }

    public void Hj(int i) {
        this.lWg = i;
    }

    public void dtc() {
        if (this.lUu != null) {
            this.lUu.setForbidDragListener(true);
        }
    }

    public boolean dpO() {
        if (this.lUu == null) {
            return false;
        }
        return this.lUu.dpO();
    }

    public boolean dtd() {
        if (this.jnf == null || TextUtils.isEmpty(this.jnf.getEndText())) {
            return false;
        }
        return this.jnf.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmE() == null) {
            return false;
        }
        SpannableStringBuilder brZ = fVar.dmE().brZ();
        if (brZ != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(brZ.toString());
        }
        return true;
    }

    public void dte() {
        boolean z;
        if (this.lWj != null) {
            if (((this.lWj.getView() == null || this.lWj.getView().getParent() == null) ? -1 : this.lUu.getPositionForView(this.lWj.getView())) != -1) {
                if (this.lWj.getView().getTop() + lWh <= this.lVv.getBottom()) {
                    this.lWi = 1;
                    z = true;
                } else {
                    this.lWi = 0;
                    z = false;
                }
            } else {
                z = this.lWi == 1;
            }
            this.lVx.vm(this.lWi == 1);
            this.lWj.setScrollable(z);
        }
    }

    public LinearLayout dtf() {
        return this.lVf;
    }
}
