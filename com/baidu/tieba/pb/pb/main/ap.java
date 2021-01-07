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
    private PbFragment lIN;
    private View.OnClickListener lJR;
    private com.baidu.tieba.pb.data.f lKe;
    private PbFakeFloorModel lMy;
    PbFragment.c lOp;
    private LinearLayout lUA;
    private TextView lUB;
    private TextView lUC;
    private ObservedChangeRelativeLayout lUD;
    private g lUE;
    private View lUK;
    public int lUn;
    public final com.baidu.tieba.pb.pb.main.view.c lUp;
    public com.baidu.tieba.pb.pb.main.view.b lUq;
    private ViewStub lUr;
    private ViewStub lUs;
    private PbLandscapeListView lUt;
    private PbThreadPostView lUu;
    private com.baidu.tieba.pb.pb.main.a.e lUv;
    private com.baidu.tieba.pb.pb.main.a.a lUw;
    private com.baidu.tieba.pb.pb.main.a.c lUx;
    private com.baidu.tieba.pb.pb.main.a.d lUy;
    private com.baidu.tieba.pb.pb.main.a.b lUz;
    private PbEmotionBar lVB;
    private int lVJ;
    private Runnable lVK;
    private r lVL;
    private al lVM;
    private int lVS;
    private PbTopTipView lVT;
    private PopupWindow lVU;
    private TextView lVV;
    private List<String> lVW;
    private com.baidu.tieba.pb.pb.main.emotion.c lVX;
    private com.baidu.tieba.pb.pb.godreply.a lVY;
    private PbLandscapeListView.b lVZ;
    private View lVa;
    private View lVc;
    private View lVd;
    private LinearLayout lVe;
    private HeadImageView lVf;
    private ImageView lVg;
    private ImageView lVh;
    private ImageView lVi;
    private com.baidu.tieba.pb.view.d lVj;
    private TextView lVk;
    private TextView lVl;
    private int lVn;
    private int lVo;
    private PostData lVp;
    private ViewStub lVr;
    private PbInterviewStatusView lVs;
    private FrameLayout lVt;
    private View lVu;
    private View lVv;
    private PbReplyTitleViewHolder lVw;
    private ae lWb;
    private com.baidu.tieba.NEGFeedBack.i lWc;
    private String lWd;
    private long lWe;
    private int lWf;
    private com.baidu.tieba.pb.view.c lWi;
    private boolean lWk;
    private Runnable lWo;
    private PbFragment.b lWq;
    public int mLastScrollY;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int lVx = UtilHelper.getLightStatusBarHeight();
    public static int lVD = 3;
    public static int lVE = 0;
    public static int lVF = 3;
    public static int lVG = 4;
    public static int lVH = 5;
    public static int lVI = 6;
    private static final int lWg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    private static a.InterfaceC0884a lWj = new a.InterfaceC0884a() { // from class: com.baidu.tieba.pb.pb.main.ap.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0884a
        public void onRefresh() {
        }
    };
    private int lUo = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lUF = null;
    private com.baidu.tbadk.core.dialog.b jhU = null;
    private View lUG = null;
    private EditText lUH = null;
    private com.baidu.tieba.pb.view.e lUI = null;
    private com.baidu.tieba.pb.view.a lUJ = null;
    private b.InterfaceC0578b lUL = null;
    private TbRichTextView.i fWO = null;
    private NoNetworkView.a jct = null;
    private com.baidu.tbadk.core.dialog.i lUM = null;
    private com.baidu.tbadk.core.dialog.a lUN = null;
    private Dialog lUO = null;
    private Dialog lUP = null;
    private View lUQ = null;
    private LinearLayout lUR = null;
    private CompoundButton.OnCheckedChangeListener iyr = null;
    private TextView lUS = null;
    private TextView lUT = null;
    private String lUU = null;
    private com.baidu.tbadk.core.dialog.i lNo = null;
    private com.baidu.tbadk.core.dialog.i lUV = null;
    private boolean lUW = false;
    private boolean lUX = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lUY = null;
    private boolean lUZ = false;
    private Button lVb = null;
    private boolean lVm = true;
    private com.baidu.tbadk.core.view.a iCD = null;
    private boolean lJJ = false;
    private int mSkinType = 3;
    private boolean lVq = false;
    private int lVy = 0;
    private boolean lVz = true;
    public a lVA = new a();
    private int lVC = 0;
    private boolean lVN = false;
    private int lVO = 0;
    private boolean lVP = false;
    private boolean lVQ = false;
    private boolean lVR = false;
    private boolean lWa = false;
    private int lWh = 0;
    private String lWl = null;
    private CustomMessageListener lWm = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ap.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ap.this.lWl = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ap.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ap.this.lUE != null) {
                ap.this.lUE.notifyDataSetChanged();
            }
        }
    };
    private Handler lWn = new Handler();
    private CustomMessageListener lWp = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ap.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ap.this.lVm = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lWr = true;
    View.OnClickListener lWs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || ap.this.lKe == null || ap.this.lKe.dmF() == null || ap.this.lKe.dmF().brr() == null || ap.this.lKe.dmF().brr().getAlaInfo() == null || ap.this.lKe.dmF().brr().getAlaInfo().live_status != 1) {
                if (ap.this.lVP) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").an("obj_id", 2));
                }
                if (!ap.this.lVP && ap.this.lKe != null && ap.this.lKe.dmF() != null && ap.this.lKe.dmF().brr() != null && ap.this.lKe.dmF().brr().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").an("obj_locate", 1));
                }
                if (ap.this.lIN.dpE() != null) {
                    ap.this.lIN.dpE().lIZ.iOE.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (ap.this.lKe.dmF().brr().getAlaInfo() == null || !ap.this.lKe.dmF().brr().getAlaInfo().isChushou) {
                if (ap.this.lKe.dmF().brr().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = ap.this.lKe.dmF().brr().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ap.this.lIN.dpE(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            be.bwv().b(ap.this.lIN.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + ap.this.lKe.dmF().brr().getAlaInfo().thirdRoomId + "&livetype=" + ap.this.lKe.dmF().brr().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bkL = false;
    String userId = null;
    private final List<TbImageView> lWt = new ArrayList();
    private boolean lWu = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int headerCount;
        public PbReplyTitleViewHolder lWI;
        public int lzC;
    }

    public void vn(boolean z) {
        this.lVN = z;
        if (this.lUt != null) {
            this.lVO = this.lUt.getHeaderViewsCount();
        }
    }

    public void drJ() {
        if (this.lUt != null) {
            int headerViewsCount = this.lUt.getHeaderViewsCount() - this.lVO;
            final int firstVisiblePosition = (this.lUt.getFirstVisiblePosition() == 0 || this.lUt.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lUt.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lUt.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lVA.lWI = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lVA));
            final PbReplyTitleViewHolder pbReplyTitleViewHolder = this.lVA.lWI;
            final int g = g(pbReplyTitleViewHolder);
            final int y = ((int) this.lUD.getY()) + this.lUD.getMeasuredHeight();
            final boolean z = this.lVu.getVisibility() == 0;
            boolean z2 = this.lUD.getY() < 0.0f;
            if ((z && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.lUE.dow() + this.lUt.getHeaderViewsCount()) {
                int measuredHeight = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.lTP.getMeasuredHeight() : 0;
                if (z2) {
                    this.lUt.setSelectionFromTop(this.lUE.dow() + this.lUt.getHeaderViewsCount(), lVx - measuredHeight);
                } else {
                    this.lUt.setSelectionFromTop(this.lUE.dow() + this.lUt.getHeaderViewsCount(), this.lUp.dtM().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lUt.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.lVP && this.lUv != null) {
                this.lUt.setSelectionFromTop(this.lUE.dow() + this.lUt.getHeaderViewsCount(), this.lUv.dty());
            } else if (this.mType == 6) {
                this.lUt.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
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
                                    layoutParams.height = ap.this.lVJ;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ap.this.bNf.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.lVJ;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    ap.this.lUt.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                ap.this.bNO.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ap.this.bNO != null && ap.this.bNO.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = ap.this.bNO.getLayoutParams();
                                            layoutParams2.height = ap.this.lVJ;
                                            ap.this.bNO.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        ap.this.lUt.setOnLayoutListener(null);
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

    public NoNetworkView drK() {
        return this.gzT;
    }

    public void drL() {
        if (this.acZ != null) {
            this.acZ.hide();
            if (this.lVX != null) {
                this.lVX.dtA();
            }
        }
    }

    public PbFakeFloorModel drM() {
        return this.lMy;
    }

    public r drN() {
        return this.lVL;
    }

    public com.baidu.tieba.pb.pb.main.a.e drO() {
        return this.lUv;
    }

    public void drP() {
        reset();
        drL();
        this.lVL.doF();
        vz(false);
    }

    private void reset() {
        if (this.lIN != null && this.lIN.doK() != null && this.acZ != null) {
            com.baidu.tbadk.editortools.pb.a.bFm().setStatus(0);
            com.baidu.tbadk.editortools.pb.e doK = this.lIN.doK();
            doK.bFH();
            doK.bEW();
            if (doK.getWriteImagesInfo() != null) {
                doK.getWriteImagesInfo().setMaxImagesAllowed(doK.isBJH ? 1 : 9);
            }
            doK.sF(SendView.ALL);
            doK.sG(SendView.ALL);
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

    public boolean drQ() {
        return this.lVm;
    }

    public void vo(boolean z) {
        if (this.lVd != null && this.klE != null) {
            this.klE.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lVd.startAnimation(alphaAnimation);
            }
            this.lVc.setVisibility(0);
            this.lVd.setVisibility(0);
            this.lVm = true;
            if (this.lVB != null && !this.lVY.isActive()) {
                this.lVB.setVisibility(0);
                vt(true);
            }
        }
    }

    public void vp(boolean z) {
        if (this.lVd != null && this.klE != null) {
            this.klE.setText(drR());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lVd.startAnimation(alphaAnimation);
            }
            this.lVc.setVisibility(0);
            this.lVd.setVisibility(0);
            this.lVm = true;
            if (this.lVB != null && !this.lVY.isActive()) {
                this.lVB.setVisibility(0);
                vt(true);
            }
        }
    }

    public String drR() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.lWd)) {
            return this.lWd;
        }
        if (this.lIN != null) {
            this.lWd = TbadkCoreApplication.getInst().getResources().getString(ao.drH());
        }
        return this.lWd;
    }

    public PostData drS() {
        int i = 0;
        if (this.lUt == null) {
            return null;
        }
        int drT = drT() - this.lUt.getHeaderViewsCount();
        if (drT < 0) {
            drT = 0;
        }
        if (this.lUE.GN(drT) != null && this.lUE.GN(drT) != PostData.nrt) {
            i = drT + 1;
        }
        return this.lUE.getItem(i) instanceof PostData ? (PostData) this.lUE.getItem(i) : null;
    }

    public int drT() {
        int i;
        View childAt;
        if (this.lUt == null) {
            return 0;
        }
        int firstVisiblePosition = this.lUt.getFirstVisiblePosition();
        int lastVisiblePosition = this.lUt.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lUt.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lUt.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int drU() {
        return this.lUt.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lKe != null && this.lKe.dmH() != null && !this.lKe.dmH().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lKe.dmH().size() && (postData = this.lKe.dmH().get(i)) != null && postData.brr() != null && !StringUtils.isNull(postData.brr().getUserId()); i++) {
                if (this.lKe.dmH().get(i).brr().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lVY != null && this.lVY.isActive()) {
                        vz(false);
                    }
                    if (this.lVB != null) {
                        this.lVB.vJ(true);
                    }
                    this.lWl = postData.brr().getName_show();
                    return;
                }
            }
        }
    }

    public ap(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lIN = null;
        this.bNf = null;
        this.bMl = null;
        this.lUt = null;
        this.lUE = null;
        this.jnf = null;
        this.fKX = null;
        this.jhV = null;
        this.lJR = null;
        this.lVd = null;
        this.klE = null;
        this.lVr = null;
        this.lVS = 0;
        this.lWe = 0L;
        this.lWe = System.currentTimeMillis();
        this.lIN = pbFragment;
        this.jhV = onClickListener;
        this.fyb = cVar;
        this.lVS = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lIN.getContext()) / 8;
        this.bNf = (RelativeLayout) LayoutInflater.from(this.lIN.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bNf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lVa = this.bNf.findViewById(R.id.bottom_shadow);
        this.jLi = (NavigationBarCoverTip) this.bNf.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bMl = this.bNf.findViewById(R.id.statebar_view);
        this.lUD = (ObservedChangeRelativeLayout) this.bNf.findViewById(R.id.title_wrapper);
        this.gzT = (NoNetworkView) this.bNf.findViewById(R.id.view_no_network);
        this.lUt = (PbLandscapeListView) this.bNf.findViewById(R.id.new_pb_list);
        this.lVt = (FrameLayout) this.bNf.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lIN.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lIN.getActivity(), R.dimen.ds88));
        this.lUt.addHeaderView(this.textView, 0);
        this.lUt.setTextViewAdded(true);
        this.lVJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bNO = new View(this.lIN.getPageContext().getPageActivity());
        this.bNO.setLayoutParams(new AbsListView.LayoutParams(-1, this.lVJ));
        this.bNO.setVisibility(4);
        this.lUt.addFooterView(this.bNO);
        this.lUt.setOnTouchListener(this.lIN.bTP);
        this.lUp = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bNf);
        if (this.lIN.dpn()) {
            this.lUr = (ViewStub) this.bNf.findViewById(R.id.manga_view_stub);
            this.lUr.setVisibility(0);
            this.lUq = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lUq.show();
            this.lUp.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lIN.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lUp.dtM().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0840a() { // from class: com.baidu.tieba.pb.pb.main.ap.27
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0840a
            public void dnI() {
                if (ap.this.lUt != null) {
                    if (ap.this.lUv != null) {
                        ap.this.lUv.dtx();
                    }
                    ap.this.lUt.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0840a
            public void dnJ() {
                ap.this.lIN.cFB();
            }
        }));
        this.lVc = this.bNf.findViewById(R.id.view_comment_top_line);
        this.lVd = this.bNf.findViewById(R.id.pb_editor_tool_comment);
        this.lVn = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lVo = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lVf = (HeadImageView) this.bNf.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lVf.setVisibility(0);
        this.lVf.setIsRound(true);
        this.lVf.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lIN.getContext(), R.dimen.L_X01));
        this.lVf.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0401));
        this.lVf.setPlaceHolder(0);
        drV();
        this.klE = (TextView) this.bNf.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lVe = (LinearLayout) this.bNf.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.lIN.doV();
                if (ap.this.lIN != null && ap.this.lIN.dnW() != null && ap.this.lIN.dnW().getPbData() != null && ap.this.lIN.dnW().getPbData().dmF() != null && ap.this.lIN.dnW().getPbData().dmF().brr() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dX("tid", ap.this.lIN.dnW().dpY()).dX("fid", ap.this.lIN.dnW().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", ap.this.lIN.dnW().lQv).dX("fid", ap.this.lIN.dnW().getPbData().getForumId()).an("obj_locate", 1).dX("uid", ap.this.lIN.dnW().getPbData().dmF().brr().getUserId()));
                }
            }
        });
        this.lVg = (ImageView) this.bNf.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lVg.setOnClickListener(this.jhV);
        boolean booleanExtra = this.lIN.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lVh = (ImageView) this.bNf.findViewById(R.id.pb_editor_tool_collection);
        this.lVh.setOnClickListener(this.jhV);
        if (booleanExtra) {
            this.lVh.setVisibility(8);
        } else {
            this.lVh.setVisibility(0);
        }
        this.lVi = (ImageView) this.bNf.findViewById(R.id.pb_editor_tool_share);
        this.lVi.setOnClickListener(this.jhV);
        this.lVj = new com.baidu.tieba.pb.view.d(this.lVi);
        this.lVj.dxg();
        this.lVk = (TextView) this.bNf.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lVk.setVisibility(0);
        this.lVr = (ViewStub) this.bNf.findViewById(R.id.interview_status_stub);
        this.lUw = new com.baidu.tieba.pb.pb.main.a.a(this.lIN, cVar);
        this.lUy = new com.baidu.tieba.pb.pb.main.a.d(this.lIN, cVar, this.jhV);
        this.lUE = new g(this.lIN, this.lUt);
        this.lUE.H(this.jhV);
        this.lUE.setTbGestureDetector(this.fyb);
        this.lUE.setOnImageClickListener(this.fWO);
        this.lUE.setOnSwitchChangeListener(this.lIN.lOi);
        this.lJR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.29
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
                            ap.this.lIN.f(sparseArray);
                            return;
                        }
                        ap.this.dN(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        ap.this.lIN.f(sparseArray);
                    } else if (booleanValue3) {
                        ap.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lUE.U(this.lJR);
        dsa();
        dsb();
        this.lUx.b(this.lUt);
        this.lUy.b(this.lUt);
        this.lUw.b(this.lUt);
        this.jnf = new PbListView(this.lIN.getPageContext().getPageActivity());
        this.fKX = this.jnf.getView().findViewById(R.id.pb_more_view);
        if (this.fKX != null) {
            this.fKX.setOnClickListener(this.jhV);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.fKX, R.drawable.pb_foot_more_trans_selector);
        }
        this.jnf.setLineVisible();
        this.jnf.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jnf.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lUK = this.bNf.findViewById(R.id.viewstub_progress);
        this.lIN.registerListener(this.lWp);
        this.lMy = new PbFakeFloorModel(this.lIN.getPageContext());
        this.lVL = new r(this.lIN.getPageContext(), this.lMy, this.bNf);
        this.lVL.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.drP();
            }
        });
        this.lVL.a(this.lIN.lOk);
        this.lMy.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ap.31
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                ap.this.lMy.u(postData);
                ap.this.lUE.notifyDataSetChanged();
                ap.this.lVL.doF();
                ap.this.acZ.bDf();
                ap.this.vz(false);
            }
        });
        if (this.lIN.dnW() != null && !StringUtils.isNull(this.lIN.dnW().dqH())) {
            this.lIN.showToast(this.lIN.dnW().dqH());
        }
        this.lVu = this.bNf.findViewById(R.id.pb_expand_blank_view);
        this.lVv = this.bNf.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lVv.getLayoutParams();
        if (this.lIN.dnW() != null && this.lIN.dnW().dqb()) {
            this.lVu.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lVv.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lVx;
            this.lVv.setLayoutParams(layoutParams2);
        }
        this.lVw = new PbReplyTitleViewHolder(this.lIN.getPageContext(), this.bNf.findViewById(R.id.pb_reply_expand_view));
        this.lVw.v(pbFragment.lNd);
        this.lVw.lTP.setVisibility(8);
        this.lVw.W(this.jhV);
        this.lVw.setOnSwitchChangeListener(this.lIN.lOi);
        this.lIN.registerListener(this.mAccountChangedListener);
        this.lIN.registerListener(this.lWm);
        drW();
        vt(false);
        this.lWi = new com.baidu.tieba.pb.view.c(this.lIN.getPageContext());
    }

    private void drV() {
        if (this.lVf != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lVf.setImageResource(0);
            this.lVf.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lVf.setImageResource(R.drawable.transparent_bg);
    }

    public void vq(boolean z) {
        this.lVa.setVisibility(z ? 0 : 8);
    }

    public void cUf() {
        if (!this.lIN.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").an("obj_locate", 2).dX("fid", this.mForumId));
        } else if (this.lIN.doX()) {
            com.baidu.tbadk.editortools.pb.e doK = this.lIN.doK();
            if (doK != null && (doK.bFE() || doK.bFF())) {
                this.lIN.doK().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acZ != null) {
                dsg();
            }
            if (this.acZ != null) {
                this.lVm = false;
                if (this.acZ.sv(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lIN.getPageContext(), (View) this.acZ.sv(2).fDH, false, lWj);
                }
            }
            dsQ();
        }
    }

    private void drW() {
        this.lVY = new com.baidu.tieba.pb.pb.godreply.a(this.lIN, this, (ViewStub) this.bNf.findViewById(R.id.more_god_reply_popup));
        this.lVY.C(this.jhV);
        this.lVY.U(this.lJR);
        this.lVY.setOnImageClickListener(this.fWO);
        this.lVY.C(this.jhV);
        this.lVY.setTbGestureDetector(this.fyb);
    }

    public com.baidu.tieba.pb.pb.godreply.a drX() {
        return this.lVY;
    }

    public View drY() {
        return this.lVu;
    }

    public void drZ() {
        if (this.lUt != null) {
            this.lUx.c(this.lUt);
            this.lUy.c(this.lUt);
            this.lUz.c(this.lUt);
            this.lUw.c(this.lUt);
        }
    }

    private void dsa() {
        if (this.lUz == null) {
            this.lUz = new com.baidu.tieba.pb.pb.main.a.b(this.lIN, this.jhV);
        }
    }

    private void dsb() {
        if (this.lUx == null) {
            this.lUx = new com.baidu.tieba.pb.pb.main.a.c(this.lIN, this.fyb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsc() {
        if (this.lIN.dpn()) {
            this.lUs = (ViewStub) this.bNf.findViewById(R.id.manga_mention_controller_view_stub);
            this.lUs.setVisibility(0);
            if (this.lUA == null) {
                this.lUA = (LinearLayout) this.bNf.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lIN.getPageContext(), this.lUA);
            }
            if (this.lUB == null) {
                this.lUB = (TextView) this.lUA.findViewById(R.id.manga_prev_btn);
            }
            if (this.lUC == null) {
                this.lUC = (TextView) this.lUA.findViewById(R.id.manga_next_btn);
            }
            this.lUB.setOnClickListener(this.jhV);
            this.lUC.setOnClickListener(this.jhV);
        }
    }

    private void dsd() {
        if (this.lIN.dpn()) {
            if (this.lIN.dpq() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lUB, R.color.CAM_X0110, 1);
            }
            if (this.lIN.dpr() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lUC, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dse() {
        if (this.lUA == null) {
            dsc();
        }
        this.lUs.setVisibility(8);
        if (this.lWn != null && this.lWo != null) {
            this.lWn.removeCallbacks(this.lWo);
        }
    }

    public void dsf() {
        if (this.lWn != null) {
            if (this.lWo != null) {
                this.lWn.removeCallbacks(this.lWo);
            }
            this.lWo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ap.this.lUA == null) {
                        ap.this.dsc();
                    }
                    ap.this.lUs.setVisibility(0);
                }
            };
            this.lWn.postDelayed(this.lWo, 2000L);
        }
    }

    public void vr(boolean z) {
        this.lUp.vr(z);
        if (z && this.lVq) {
            this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lUt.setNextPage(this.jnf);
            this.lUo = 2;
        }
        drV();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
        this.acZ.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.drP();
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
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bzX() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bzX() == EmotionGroupType.USER_COLLECT) {
                        if (ap.this.mPermissionJudgePolicy == null) {
                            ap.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        ap.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        ap.this.mPermissionJudgePolicy.appendRequestPermission(ap.this.lIN.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ap.this.mPermissionJudgePolicy.startRequestPermission(ap.this.lIN.getBaseFragmentActivity())) {
                            ap.this.lIN.doK().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            ap.this.lIN.doK().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        drL();
        this.lIN.doK().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ap.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ap.this.acZ != null && ap.this.acZ.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ap.this.lVX == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ap.this.acZ.getId());
                            ap.this.lVX = new com.baidu.tieba.pb.pb.main.emotion.c(ap.this.lIN.getPageContext(), ap.this.bNf, layoutParams2);
                            if (!com.baidu.tbadk.core.util.x.isEmpty(ap.this.lVW)) {
                                ap.this.lVX.setData(ap.this.lVW);
                            }
                            ap.this.lVX.c(ap.this.acZ);
                        }
                        ap.this.lVX.Qe(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ap.this.lIN.kSQ != null && ap.this.lIN.kSQ.dtj() != null) {
                    if (!ap.this.lIN.kSQ.dtj().dXU()) {
                        ap.this.lIN.kSQ.vF(false);
                    }
                    ap.this.lIN.kSQ.dtj().zc(false);
                }
            }
        });
    }

    public void dsg() {
        if (this.lIN != null && this.acZ != null) {
            this.acZ.rV();
            if (this.lIN.doK() != null) {
                this.lIN.doK().bFu();
            }
            dsQ();
        }
    }

    public void vs(boolean z) {
        if (this.lUt != null && this.textView != null && this.bMl != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bMl.setVisibility(0);
                } else {
                    this.bMl.setVisibility(8);
                    this.lUt.removeHeaderView(this.textView);
                    this.lUt.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lVx;
                    this.textView.setLayoutParams(layoutParams);
                }
                dsx();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + vB(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dsx();
            dsY();
        }
    }

    public g dsh() {
        return this.lUE;
    }

    public void a(PbFragment.c cVar) {
        this.lOp = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lIN.getContext());
        kVar.setTitleText(this.lIN.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lUM.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            ap.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (ap.this.lWq != null) {
                                ap.this.lWq.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            ap.this.lIN.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lIN.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lIN.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eXH.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dsX()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.lIN.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lIN.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lIN.getString(R.string.mute), kVar);
            }
            gVar.eXH.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.k(com.baidu.tieba.pb.pb.main.d.a.fs(arrayList), true);
        this.lUM = new com.baidu.tbadk.core.dialog.i(this.lIN.getPageContext(), kVar);
        this.lUM.SY();
    }

    public void a(PbFragment.b bVar) {
        this.lWq = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lIN != null && aVar != null) {
            if (this.jOD == null && this.lUw != null) {
                this.jOD = new com.baidu.tieba.NEGFeedBack.f(this.lIN.getPageContext(), this.lUw.dtt());
            }
            AntiData cDZ = this.lIN.cDZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDZ != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jOD.setDefaultReasonArray(new String[]{this.lIN.getString(R.string.delete_thread_reason_1), this.lIN.getString(R.string.delete_thread_reason_2), this.lIN.getString(R.string.delete_thread_reason_3), this.lIN.getString(R.string.delete_thread_reason_4), this.lIN.getString(R.string.delete_thread_reason_5)});
            this.jOD.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jOD.Fg(str);
            this.jOD.a(new f.b() { // from class: com.baidu.tieba.pb.pb.main.ap.9
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    ap.this.lIN.a(aVar, jSONArray);
                }
            });
        }
    }

    private boolean dsi() {
        if (this.lIN == null || this.lIN.dnW().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.lIN.dnW().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        String str;
        if (this.lIN != null && aVar != null) {
            if (this.lWc == null && this.lUw != null) {
                this.lWc = new com.baidu.tieba.NEGFeedBack.i(this.lIN.getPageContext(), this.lUw.dtt(), hVar, userData);
            }
            AntiData cDZ = this.lIN.cDZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDZ != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lWc.setDefaultReasonArray(new String[]{this.lIN.getString(R.string.delete_thread_reason_1), this.lIN.getString(R.string.delete_thread_reason_2), this.lIN.getString(R.string.delete_thread_reason_3), this.lIN.getString(R.string.delete_thread_reason_4), this.lIN.getString(R.string.delete_thread_reason_5)});
            this.lWc.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lWc.Fg(str);
            this.lWc.a(new i.b() { // from class: com.baidu.tieba.pb.pb.main.ap.10
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    ap.this.lIN.a(aVar, jSONArray);
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
        sparseArray.put(lVE, Integer.valueOf(lVF));
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
        this.lUN = new com.baidu.tbadk.core.dialog.a(this.lIN.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lUN.pa(i3);
        } else {
            this.lUN.setOnlyMessageShowCenter(false);
            this.lUN.Bo(str2);
        }
        this.lUN.setYesButtonTag(sparseArray);
        this.lUN.a(R.string.dialog_ok, this.lIN);
        this.lUN.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lUN.jH(true);
        this.lUN.b(this.lIN.getPageContext());
        if (z) {
            this.lUN.btY();
        } else if (dsi()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lIN.dnW().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.lIN.dnW().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.lIN.dnW().getPbData().dno().has_forum_rule.intValue());
            hVar.ej(this.lIN.dnW().getPbData().getForum().getId(), this.lIN.dnW().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.lIN.dnW().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.lIN.dnW().getPbData().getForum().getUser_level());
            a(this.lUN, i, hVar, this.lIN.dnW().getPbData().getUserData());
        } else {
            a(this.lUN, i);
        }
    }

    public void bf(ArrayList<com.baidu.tbadk.core.data.ak> arrayList) {
        if (this.lUQ == null) {
            this.lUQ = LayoutInflater.from(this.lIN.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lIN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lUQ);
        if (this.lUP == null) {
            this.lUP = new Dialog(this.lIN.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lUP.setCanceledOnTouchOutside(true);
            this.lUP.setCancelable(true);
            this.lUY = (ScrollView) this.lUQ.findViewById(R.id.good_scroll);
            this.lUP.setContentView(this.lUQ);
            WindowManager.LayoutParams attributes = this.lUP.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lUP.getWindow().setAttributes(attributes);
            this.iyr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ap.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.this.lUU = (String) compoundButton.getTag();
                        if (ap.this.iyq != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ap.this.iyq) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ap.this.lUU != null && !str.equals(ap.this.lUU)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lUR = (LinearLayout) this.lUQ.findViewById(R.id.good_class_group);
            this.lUT = (TextView) this.lUQ.findViewById(R.id.dialog_button_cancel);
            this.lUT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.lUP instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(ap.this.lUP, ap.this.lIN.getPageContext());
                    }
                }
            });
            this.lUS = (TextView) this.lUQ.findViewById(R.id.dialog_button_ok);
            this.lUS.setOnClickListener(this.jhV);
        }
        this.lUR.removeAllViews();
        this.iyq = new ArrayList();
        CustomBlueCheckRadioButton fV = fV("0", this.lIN.getPageContext().getString(R.string.thread_good_class));
        this.iyq.add(fV);
        fV.setChecked(true);
        this.lUR.addView(fV);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.bpD()) && akVar.bpE() > 0) {
                    CustomBlueCheckRadioButton fV2 = fV(String.valueOf(akVar.bpE()), akVar.bpD());
                    this.iyq.add(fV2);
                    View view = new View(this.lIN.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ao.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lUR.addView(view);
                    this.lUR.addView(fV2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lUY.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lIN.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lIN.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lIN.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lUY.setLayoutParams(layoutParams2);
            this.lUY.removeAllViews();
            if (this.lUR != null && this.lUR.getParent() == null) {
                this.lUY.addView(this.lUR);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lUP, this.lIN.getPageContext());
    }

    private CustomBlueCheckRadioButton fV(String str, String str2) {
        Activity pageActivity = this.lIN.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iyr);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dsj() {
        this.lIN.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lIN.hideProgressBar();
        if (z && z2) {
            this.lIN.showToast(this.lIN.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lIN.showToast(str);
        }
    }

    public void dsk() {
        this.lUK.setVisibility(0);
    }

    public void dsl() {
        this.lUK.setVisibility(8);
    }

    public View dsm() {
        if (this.lUQ != null) {
            return this.lUQ.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dsn() {
        return this.lUU;
    }

    public View getView() {
        return this.bNf;
    }

    public void dso() {
        if (this.lIN != null && this.lIN.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lIN.getPageContext().getPageActivity(), this.lIN.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lIN.hideProgressBar();
        if (z) {
            dsH();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dsI();
        } else {
            dsH();
        }
    }

    public void dsp() {
        this.jnf.setLineVisible();
        this.jnf.startLoadData();
    }

    public void dsq() {
        this.lIN.hideProgressBar();
        endLoadData();
        this.lUt.completePullRefreshPostDelayed(0L);
        dsC();
    }

    public void dsr() {
        this.lUt.completePullRefreshPostDelayed(0L);
        dsC();
    }

    private void vt(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lUy.b(onLongClickListener);
        this.lUE.setOnLongClickListener(onLongClickListener);
        if (this.lVY != null) {
            this.lVY.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0578b interfaceC0578b, boolean z, boolean z2) {
        if (this.lNo != null) {
            this.lNo.dismiss();
            this.lNo = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lIN.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lIN.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lIN.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lIN.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lIN.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lUV.dismiss();
                interfaceC0578b.a(null, i, view);
            }
        });
        this.lUV = new com.baidu.tbadk.core.dialog.i(this.lIN.getPageContext(), kVar);
        this.lUV.SY();
    }

    public void a(final b.InterfaceC0578b interfaceC0578b, boolean z) {
        if (this.lUV != null) {
            this.lUV.dismiss();
            this.lUV = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lIN.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lKe != null && this.lKe.dmF() != null && !this.lKe.dmF().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lIN.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lIN.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lUV.dismiss();
                interfaceC0578b.a(null, i, view);
            }
        });
        this.lUV = new com.baidu.tbadk.core.dialog.i(this.lIN.getPageContext(), kVar);
        this.lUV.SY();
    }

    public int dss() {
        return Ho(this.lUt.getFirstVisiblePosition());
    }

    private int Ho(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.lUt.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lUt.getAdapter() == null || !(this.lUt.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.lUt.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dst() {
        int lastVisiblePosition = this.lUt.getLastVisiblePosition();
        if (this.lUv != null) {
            if (lastVisiblePosition == this.lUt.getCount() - 1) {
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
        if (this.lUt != null) {
            if (this.lUp == null || this.lUp.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lUp.mNavigationBar.getFixedNavHeight();
                if (this.lIN.dpd() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lVv != null && (layoutParams = (LinearLayout.LayoutParams) this.lVv.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lVv.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lUt.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lUt.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lUt.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lUH.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lUE.a(fVar, false);
        this.lUE.notifyDataSetChanged();
        dsC();
        if (this.lVY != null) {
            this.lVY.bSh();
        }
        ArrayList<PostData> dmH = fVar.dmH();
        if (fVar.getPage().bqg() == 0 || dmH == null || dmH.size() < fVar.getPage().bqf()) {
            if (com.baidu.tbadk.core.util.x.getCount(dmH) == 0 || (com.baidu.tbadk.core.util.x.getCount(dmH) == 1 && dmH.get(0) != null && dmH.get(0).dPe() == 1)) {
                if (this.lVA == null || this.lVA.lWI == null || this.lVA.lWI.getView() == null) {
                    i = 0;
                } else {
                    i = this.lVA.lWI.getView().getTop() < 0 ? this.lVA.lWI.getView().getHeight() : this.lVA.lWI.getView().getBottom();
                }
                if (this.lIN.dpx()) {
                    this.jnf.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.jnf.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bqg() == 0) {
                    this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jnf.bxE();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lUw != null) {
            this.lUw.e(fVar, this.lJJ);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dmS() != null) {
            return fVar.dmS();
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.dmH())) {
            Iterator<PostData> it = fVar.dmH().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPe() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dmO();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.brr() != null && postData.brr().getUserTbVipInfoData() != null && postData.brr().getUserTbVipInfoData().getvipIntro() != null) {
            postData.brr().getGodUserData().setIntro(postData.brr().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.brr() == null) {
            return false;
        }
        MetaData brr = postData.brr();
        return (TextUtils.isEmpty(brr.getUserId()) && TextUtils.isEmpty(brr.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmF() == null || fVar.dmF().brr() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData brr = fVar.dmF().brr();
        String userId = brr.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmF().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = brr;
        }
        postData.KR(1);
        postData.setId(fVar.dmF().brH());
        postData.setTitle(fVar.dmF().getTitle());
        postData.setTime(fVar.dmF().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dmF() != null) {
            if (this.lIN.dnO()) {
                if (fVar.dmE() != null) {
                    this.mForumName = fVar.dmE().getForumName();
                    this.mForumId = fVar.dmE().getForumId();
                }
                if (this.mForumName == null && this.lIN.dnW() != null && this.lIN.dnW().dnP() != null) {
                    this.mForumName = this.lIN.dnW().dnP();
                }
            }
            PostData b2 = b(fVar, z);
            a(b2, fVar);
            this.lUy.setVisibility(8);
            if (fVar.dnf()) {
                this.lVP = true;
                this.lUp.vQ(true);
                this.lUp.mNavigationBar.hideBottomLine();
                if (this.lUv == null) {
                    this.lUv = new com.baidu.tieba.pb.pb.main.a.e(this.lIN);
                }
                this.lUv.a(fVar, b2, this.lUt, this.lUy, this.lVt, this.lUp, this.mForumName, this.lWe);
                this.lUv.X(this.lWs);
                dsx();
            } else {
                this.lVP = false;
                this.lUp.vQ(this.lVP);
                if (this.lUv != null) {
                    this.lUv.c(this.lUt);
                }
            }
            if (this.lIN.doN() != null) {
                this.lIN.doN().vK(this.lVP);
            }
            if (b2 != null) {
                this.lVp = b2;
                this.lUy.setVisibility(0);
                SparseArray<Object> dtw = this.lUy.dtw();
                dtw.put(R.id.tag_clip_board, b2);
                dtw.put(R.id.tag_is_subpb, false);
                this.lUz.a(fVar, this.lUt);
                this.lUx.C(fVar);
                this.lUw.e(fVar, this.lJJ);
                this.lUw.B(fVar);
                this.lUy.a(this.mSkinType, this.lKe, b2, this.lWs);
                if (this.lVw != null) {
                    if (fVar.dni()) {
                        this.lVw.getView().setVisibility(8);
                    } else {
                        this.lVw.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lHh);
                        if (fVar.dmF() != null) {
                            nVar.lHj = fVar.dmF().bri();
                        }
                        nVar.isNew = !this.lJJ;
                        nVar.sortType = fVar.lFR;
                        nVar.lHl = fVar.dnj();
                        nVar.lHm = this.lIN.dpx();
                        nVar.lHn = fVar.lFQ;
                        this.lVw.a(nVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ap.this.lUE != null && ap.this.lUp != null && ap.this.lUp.maR != null && ap.this.lKe != null && ap.this.lKe.dmF() != null && !ap.this.lKe.dmF().bpW() && !ap.this.dsB() && ap.this.lKe.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(ap.this.lKe.getForum().getName())) {
                            if ((ap.this.lUE.doA() == null || !ap.this.lUE.doA().isShown()) && ap.this.lUp.maR != null) {
                                ap.this.lUp.maR.setVisibility(0);
                                if (ap.this.lIN != null && ap.this.lIN.dnW() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dX("tid", ap.this.lIN.dnW().dpX());
                                    aqVar.dX("fid", ap.this.lIN.dnW().getForumId());
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
            dsu();
        } else {
            cyY();
        }
        this.lVA.lWI = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lVA));
        a(this.lVA.lWI, false);
    }

    public void dsu() {
        if (this.lUp != null && !this.lVR) {
            this.lUp.dsu();
            this.lVR = true;
        }
    }

    public void cyY() {
        if (this.lUp != null) {
            this.lUp.dtV();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lUy.a(postData, fVar);
    }

    public void dsv() {
        if (this.lUv != null) {
            this.lUv.d(this.lUt);
        }
    }

    public boolean dsw() {
        return this.bkL;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aN(bz bzVar) {
        if (bzVar == null || bzVar.brr() == null) {
            return false;
        }
        PostData b2 = b(this.lKe, false);
        String str = "";
        if (b2 != null && b2.brr() != null) {
            str = b2.brr().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lUp.dtS();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lUp.Le(dVar.forumName);
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
            final String str2 = dVar.lFI;
            this.lIN.showNetRefreshView(this.bNf, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        be.bwv().b(ap.this.lIN.getPageContext(), new String[]{str2});
                        ap.this.lIN.finish();
                        return;
                    }
                    ap.this.lIN.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable drx;
        Parcelable drx2;
        if (fVar != null && this.lUt != null) {
            this.lKe = fVar;
            this.mType = i;
            if (fVar.dmF() != null) {
                this.lVC = fVar.dmF().bqY();
                if (fVar.dmF().getAnchorLevel() != 0) {
                    this.bkL = true;
                }
                this.lUX = aN(fVar.dmF());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lVq = false;
            this.lJJ = z;
            dsq();
            if (fVar.lFS != null && fVar.lFS.dnq()) {
                if (this.lUu == null) {
                    this.lUu = new PbThreadPostView(this.lIN.getContext());
                    this.lUt.addHeaderView(this.lUu, 1);
                    this.lUu.setData(fVar);
                    this.lUu.setChildOnClickLinstener(this.jhV);
                }
            } else if (this.lUu != null && this.lUt != null) {
                this.lUt.removeHeaderView(this.lUu);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lWb == null) {
                this.lWb = new ae(this.lIN.getPageContext(), this.jLi);
            }
            this.lWb.PU(fVar.dmM());
            if (this.lIN.dpn()) {
                if (this.lUI == null) {
                    this.lUI = new com.baidu.tieba.pb.view.e(this.lIN.getPageContext());
                    this.lUI.createView();
                    this.lUI.setListPullRefreshListener(this.flR);
                }
                this.lUt.setPullRefresh(this.lUI);
                dsx();
                if (this.lUI != null) {
                    this.lUI.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bqh() == 0 && z) {
                this.lUt.setPullRefresh(null);
            } else {
                if (this.lUI == null) {
                    this.lUI = new com.baidu.tieba.pb.view.e(this.lIN.getPageContext());
                    this.lUI.createView();
                    this.lUI.setListPullRefreshListener(this.flR);
                }
                this.lUt.setPullRefresh(this.lUI);
                dsx();
                if (this.lUI != null) {
                    this.lUI.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                cnj();
            }
            dsC();
            this.lUE.uA(this.lJJ);
            this.lUE.uB(false);
            this.lUE.uF(i == 5);
            this.lUE.uG(i == 6);
            this.lUE.uH(z2 && this.lWr && i != 2);
            this.lUE.a(fVar, false);
            this.lUE.notifyDataSetChanged();
            this.lUy.b(b(fVar, z), fVar.dni());
            if (fVar.dmF() != null && fVar.dmF().brc() != null && this.lUn != -1) {
                fVar.dmF().brc().setIsLike(this.lUn);
            }
            this.lUt.removeFooterView(this.bNO);
            this.lUt.addFooterView(this.bNO);
            if (TbadkCoreApplication.isLogin()) {
                this.lUt.setNextPage(this.jnf);
                this.lUo = 2;
                cnj();
            } else {
                this.lVq = true;
                if (fVar.getPage().bqg() == 1) {
                    if (this.lUJ == null) {
                        this.lUJ = new com.baidu.tieba.pb.view.a(this.lIN, this.lIN);
                    }
                    this.lUt.setNextPage(this.lUJ);
                } else {
                    this.lUt.setNextPage(this.jnf);
                }
                this.lUo = 3;
            }
            ArrayList<PostData> dmH = fVar.dmH();
            if (fVar.getPage().bqg() == 0 || dmH == null || dmH.size() < fVar.getPage().bqf()) {
                if (com.baidu.tbadk.core.util.x.getCount(dmH) == 0 || (com.baidu.tbadk.core.util.x.getCount(dmH) == 1 && dmH.get(0) != null && dmH.get(0).dPe() == 1)) {
                    if (this.lVA == null || this.lVA.lWI == null || this.lVA.lWI.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lVA.lWI.getView().getTop() < 0 ? this.lVA.lWI.getView().getHeight() : this.lVA.lWI.getView().getBottom();
                    }
                    if (this.lIN.dpx()) {
                        this.jnf.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.jnf.ar(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lIN.doN() != null && !this.lIN.doN().dtG()) {
                        this.lIN.doN().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bqg() == 0) {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jnf.bxE();
                }
                if (fVar.getPage().bqg() == 0 || dmH == null) {
                    dsM();
                }
            } else {
                if (z2) {
                    if (this.lWr) {
                        endLoadData();
                        if (fVar.getPage().bqg() != 0) {
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
                this.jnf.bxE();
            }
            switch (i) {
                case 2:
                    this.lUt.setSelection(i2 > 1 ? (((this.lUt.getData() == null && fVar.dmH() == null) ? 0 : (this.lUt.getData().size() - fVar.dmH().size()) + this.lUt.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (drx2 = aj.drw().drx()) != null && !(drx2 instanceof RecyclerView.SavedState)) {
                        this.lUt.onRestoreInstanceState(drx2);
                        if (com.baidu.tbadk.core.util.x.getCount(dmH) > 1 && fVar.getPage().bqg() > 0) {
                            this.jnf.endLoadData();
                            this.jnf.setText(this.lIN.getString(R.string.pb_load_more_without_point));
                            this.jnf.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lWr = false;
                    break;
                case 5:
                    this.lUt.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (drx = aj.drw().drx()) != null && !(drx instanceof RecyclerView.SavedState)) {
                        this.lUt.onRestoreInstanceState(drx);
                        break;
                    } else {
                        this.lUt.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lUv != null && this.lUv.bUW() != null) {
                            if (this.lIN.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lUt.setSelectionFromTop((this.lUE.dov() + this.lUt.getHeaderViewsCount()) - 1, this.lUv.dty() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lIN.getPageContext().getPageActivity()));
                            } else {
                                this.lUt.setSelectionFromTop((this.lUE.dov() + this.lUt.getHeaderViewsCount()) - 1, this.lUv.dty());
                            }
                        } else {
                            this.lUt.setSelection(this.lUE.dov() + this.lUt.getHeaderViewsCount());
                        }
                    } else {
                        this.lUt.setSelection(i2 > 0 ? ((this.lUt.getData() == null && fVar.dmH() == null) ? 0 : (this.lUt.getData().size() - fVar.dmH().size()) + this.lUt.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.jnf.endLoadData();
                    this.jnf.setText(this.lIN.getString(R.string.pb_load_more_without_point));
                    this.jnf.setLineGone();
                    break;
            }
            if (this.lVC == lVD && isHost()) {
                dsT();
            }
            if (this.lVN) {
                drJ();
                this.lVN = false;
                if (i3 == 0) {
                    vn(true);
                }
            }
            if (fVar.lFO == 1 || fVar.lFP == 1) {
                if (this.lVT == null) {
                    this.lVT = new PbTopTipView(this.lIN.getContext());
                }
                if (fVar.lFP == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lIN.getStType())) {
                    this.lVT.setText(this.lIN.getString(R.string.pb_read_strategy_add_experience));
                    this.lVT.a(this.bNf, this.mSkinType);
                } else if (fVar.lFO == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lIN.getStType())) {
                    this.lVT.setText(this.lIN.getString(R.string.pb_read_news_add_experience));
                    this.lVT.a(this.bNf, this.mSkinType);
                }
            }
            this.lUt.removeFooterView(this.lWi.getView());
            if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.dnn()) && fVar.getPage().bqg() == 0) {
                this.lUt.removeFooterView(this.bNO);
                this.lWi.HP(Math.max(this.lVd.getMeasuredHeight(), this.lVo / 2));
                this.lUt.addFooterView(this.lWi.getView());
                this.lWi.H(fVar);
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmF() != null) {
            x(fVar);
            if (fVar.bny()) {
                WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Hq = Hq(fVar.dmF().bri());
            if (this.lVk != null) {
                this.lVk.setText(Hq);
            }
            if (this.lVl != null) {
                this.lVl.setText(Hq);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dmF()));
        }
    }

    private String Hq(int i) {
        if (i == 0) {
            return this.lIN.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dsx() {
        if (this.lUv != null) {
            this.lUv.a(this.lUt, this.textView, this.mType);
        }
    }

    public void vv(boolean z) {
        this.lUW = z;
    }

    public void endLoadData() {
        if (this.jnf != null) {
            this.jnf.setLineGone();
            this.jnf.endLoadData();
        }
        cnj();
    }

    public void caZ() {
        this.lUt.setVisibility(0);
    }

    public void dsy() {
        if (this.lUt != null) {
            this.lUt.setVisibility(8);
        }
        if (this.lUt != null) {
            this.lVt.setVisibility(8);
        }
        if (this.lUp != null && this.lUp.jvO != null) {
            this.lUp.jvO.setVisibility(8);
        }
    }

    public void dsz() {
        if (this.lUt != null) {
            this.lUt.setVisibility(0);
        }
        if (this.lVt != null) {
            this.lVt.setVisibility(0);
        }
        if (this.lUp != null && this.lUp.jvO != null) {
            this.lUp.jvO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lVp != null && this.lVp.brr() != null && this.lUp != null) {
            this.lVQ = !this.lVP;
            this.lUp.vM(this.lVQ);
            if (this.lIN.doN() != null) {
                this.lIN.doN().vL(this.lVQ);
            }
            dsA();
            if (this.lIN != null && !this.lIN.dnO() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.dnc())) {
                bv bvVar = fVar.dnc().get(0);
                if (bvVar != null) {
                    this.lUp.fW(bvVar.getForumName(), bvVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lUp.fW(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.lVQ) {
                this.lUy.a(fVar, this.lVp, this.lUX);
                if (this.lVv != null) {
                    this.lVv.setVisibility(8);
                }
                if (this.lVZ == null) {
                    this.lVZ = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ap.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (ap.this.lIN != null && ap.this.lIN.isAdded()) {
                                if (i < 0 && f > ap.this.lVS) {
                                    ap.this.dsH();
                                    ap.this.dsS();
                                }
                                ap.this.dsr();
                            }
                        }
                    };
                }
                this.lUt.setListViewDragListener(this.lVZ);
                return;
            }
            if (this.lVv != null) {
                this.lVv.setVisibility(0);
            }
            this.lUy.a(fVar, this.lVp, this.lUX);
            this.lVZ = null;
            this.lUt.setListViewDragListener(null);
        }
    }

    private void dsA() {
        this.lUy.a(this.lKe, this.lVp, this.lVQ, this.lVP);
    }

    public boolean dsB() {
        return this.lKe == null || this.lKe.getForum() == null || "0".equals(this.lKe.getForum().getId()) || "me0407".equals(this.lKe.getForum().getName());
    }

    private boolean dsC() {
        return this.lUw.vH(this.lJJ);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmF() == null) {
            return false;
        }
        if (fVar.dmF().bro() == 1 || fVar.dmF().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dmF().brq() == null || fVar.dmF().brq().btL() == 0) || fVar.dmF().brm() == 1 || fVar.dmF().brn() == 1 || fVar.dmF().bsf() || fVar.dmF().bsB() || fVar.dmF().bsu() || fVar.dmF().brC() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.dmF().getCategory()) || fVar.dmF().bru() || fVar.dmF().brt();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lUx != null) {
                if (fVar.dmF() != null && fVar.dmF().brF() == 0 && !fVar.dmF().bpW() && !this.lWk) {
                    if (fVar.dmF() != null) {
                        bz dmF = fVar.dmF();
                        dmF.z(true, w(fVar));
                        dmF.oM(3);
                        dmF.Bb("2");
                    }
                    if (fVar.dmF().bpY()) {
                        this.lUy.c(this.lUt);
                        this.lUx.c(this.lUt);
                        this.lUx.b(this.lUt);
                        this.lUy.b(this.lUt);
                        this.lUy.G(this.lKe);
                        if (A(fVar)) {
                            this.lUx.c(this.lUt);
                        } else {
                            this.lUx.D(fVar);
                        }
                    } else {
                        this.lUy.G(this.lKe);
                        if (A(fVar)) {
                            this.lUx.c(this.lUt);
                        } else {
                            this.lUx.F(fVar);
                        }
                    }
                } else if (fVar.dmF().brF() == 1) {
                    if (fVar.dmF() != null) {
                        this.lUx.c(this.lUt);
                        this.lUy.G(this.lKe);
                    }
                } else {
                    this.lUx.c(this.lUt);
                    this.lUy.G(this.lKe);
                }
            }
            z(fVar);
            this.lJJ = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dsC();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b2;
        com.baidu.tbadk.core.data.ac acVar;
        StringBuilder sb = null;
        if (fVar != null && (b2 = b(fVar, z)) != null) {
            String userId = b2.brr().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b2.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dmU()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b2.brr() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b2.brr().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b2.brr().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b2.brr().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b2.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b2.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dmU()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bv> dnc = fVar.dnc();
                if (com.baidu.tbadk.core.util.x.getCount(dnc) > 0) {
                    sb = new StringBuilder();
                    for (bv bvVar : dnc) {
                        if (bvVar != null && !StringUtils.isNull(bvVar.getForumName()) && (acVar = bvVar.eSl) != null && acVar.ePV && !acVar.ePW && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bvVar.getForumName(), 12)).append(this.lIN.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lIN.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dsD() {
        return this.fKX;
    }

    public boolean dsE() {
        if (this.bNO == null || this.bNO.getParent() == null || this.jnf.isLoading()) {
            return false;
        }
        int bottom = this.bNO.getBottom();
        Rect rect = new Rect();
        this.bNO.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void PW(String str) {
        if (this.jnf != null) {
            this.jnf.setText(str);
        }
    }

    public void PX(String str) {
        if (this.jnf != null) {
            int i = 0;
            if (this.lVA != null && this.lVA.lWI != null && this.lVA.lWI.getView() != null) {
                i = this.lVA.lWI.getView().getTop() < 0 ? this.lVA.lWI.getView().getHeight() : this.lVA.lWI.getView().getBottom();
            }
            this.jnf.ar(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lUt;
    }

    public int dsF() {
        return R.id.richText;
    }

    public TextView dog() {
        return this.lUy.dog();
    }

    public void d(BdListView.e eVar) {
        this.lUt.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.flR = cVar;
        if (this.lUI != null) {
            this.lUI.setListPullRefreshListener(cVar);
        }
    }

    public void a(ax axVar, a.b bVar) {
        if (axVar != null) {
            int bqe = axVar.bqe();
            int bqb = axVar.bqb();
            if (this.lUF != null) {
                this.lUF.btY();
            } else {
                this.lUF = new com.baidu.tbadk.core.dialog.a(this.lIN.getPageContext().getPageActivity());
                this.lUG = LayoutInflater.from(this.lIN.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lUF.br(this.lUG);
                this.lUF.a(R.string.dialog_ok, bVar);
                this.lUF.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ap.this.dsH();
                        aVar.dismiss();
                    }
                });
                this.lUF.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ap.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ap.this.lVK == null) {
                            ap.this.lVK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.23.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ap.this.lIN.HidenSoftKeyPad((InputMethodManager) ap.this.lIN.getBaseFragmentActivity().getSystemService("input_method"), ap.this.bNf);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mB().postDelayed(ap.this.lVK, 150L);
                    }
                });
                this.lUF.b(this.lIN.getPageContext()).btY();
            }
            this.lUH = (EditText) this.lUG.findViewById(R.id.input_page_number);
            this.lUH.setText("");
            TextView textView = (TextView) this.lUG.findViewById(R.id.current_page_number);
            if (bqe <= 0) {
                bqe = 1;
            }
            if (bqb <= 0) {
                bqb = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bqe), Integer.valueOf(bqb)));
            this.lIN.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lUH, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lUt.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lIN.showToast(str);
    }

    public boolean vw(boolean z) {
        if (this.acZ == null || !this.acZ.bEN()) {
            return false;
        }
        this.acZ.bDf();
        return true;
    }

    public void dsG() {
        if (this.lWt != null) {
            while (this.lWt.size() > 0) {
                TbImageView remove = this.lWt.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        dsG();
        this.lUE.GO(1);
        if (this.lUv != null) {
            this.lUv.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lUE.GO(2);
        if (this.lUv != null) {
            this.lUv.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lIN.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lIN.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lVj != null) {
            this.lVj.onDestroy();
        }
        if (this.lVM != null) {
            this.lVM.destroy();
        }
        if (this.lWb != null) {
            this.lWb.onDestory();
        }
        if (this.lVT != null) {
            this.lVT.hide();
        }
        this.lIN.hideProgressBar();
        if (this.gzT != null && this.jct != null) {
            this.gzT.b(this.jct);
        }
        dsH();
        endLoadData();
        if (this.lVK != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lVK);
        }
        if (this.lVs != null) {
            this.lVs.clearStatus();
        }
        this.lWn = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lUE.GO(3);
        if (this.bMl != null) {
            this.bMl.setBackgroundDrawable(null);
        }
        if (this.lUv != null) {
            this.lUv.destroy();
        }
        if (this.lUE != null) {
            this.lUE.onDestroy();
        }
        this.lUt.setOnLayoutListener(null);
        if (this.lVX != null) {
            this.lVX.cIc();
        }
        if (this.lVB != null) {
            this.lVB.onDestroy();
        }
        if (this.lUy != null) {
            this.lUy.onDestroy();
        }
    }

    public boolean Hr(int i) {
        if (this.lUv != null) {
            return this.lUv.Hr(i);
        }
        return false;
    }

    public void dsH() {
        this.lUp.bet();
        if (this.lUy != null) {
            this.lUy.dsH();
        }
        if (this.lIN != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lIN.getContext(), this.lUH);
        }
        drL();
        if (this.lNo != null) {
            this.lNo.dismiss();
        }
        dsJ();
        if (this.lUF != null) {
            this.lUF.dismiss();
        }
        if (this.jhU != null) {
            this.jhU.dismiss();
        }
    }

    public void dsI() {
        this.lUp.bet();
        if (this.lUy != null) {
            this.lUy.dsH();
        }
        if (this.lNo != null) {
            this.lNo.dismiss();
        }
        dsJ();
        if (this.lUF != null) {
            this.lUF.dismiss();
        }
        if (this.jhU != null) {
            this.jhU.dismiss();
        }
    }

    public void fp(List<String> list) {
        this.lVW = list;
        if (this.lVX != null) {
            this.lVX.setData(list);
        }
    }

    public void uz(boolean z) {
        this.lUE.uz(z);
    }

    public void vx(boolean z) {
        this.lUZ = z;
    }

    public void dsJ() {
        if (this.lUN != null) {
            this.lUN.dismiss();
        }
        if (this.lUO != null) {
            com.baidu.adp.lib.f.g.b(this.lUO, this.lIN.getPageContext());
        }
        if (this.lUP != null) {
            com.baidu.adp.lib.f.g.b(this.lUP, this.lIN.getPageContext());
        }
        if (this.lUM != null) {
            this.lUM.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lKe, this.lJJ);
            b(this.lKe, this.lJJ, this.mType, i);
            this.lIN.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lIN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bNf);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.bNf, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lVa, R.color.CAM_X0203);
            if (this.lUv != null) {
                this.lUv.onChangeSkinType(i);
            }
            if (this.lUz != null) {
                this.lUz.onChangeSkinType(i);
            }
            if (this.lUw != null) {
                this.lUw.onChangeSkinType(i);
            }
            if (this.lUx != null) {
                this.lUx.onChangeSkinType(i);
            }
            if (this.lUy != null) {
                this.lUy.onChangeSkinType(i);
            }
            if (this.jnf != null) {
                this.jnf.changeSkin(i);
            }
            if (this.fKX != null) {
                this.lIN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fKX);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.fKX, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.lUF != null) {
                this.lUF.c(this.lIN.getPageContext());
            }
            vv(this.lUW);
            this.lUE.notifyDataSetChanged();
            if (this.lUI != null) {
                this.lUI.changeSkin(i);
            }
            if (this.acZ != null) {
                this.acZ.onChangeSkinType(i);
            }
            if (this.lUJ != null) {
                this.lUJ.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.iyq)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.iyq) {
                    customBlueCheckRadioButton.bxo();
                }
            }
            dsd();
            UtilHelper.setStatusBarBackground(this.bMl, i);
            UtilHelper.setStatusBarBackground(this.lVv, i);
            if (this.lUA != null) {
                com.baidu.tbadk.r.a.a(this.lIN.getPageContext(), this.lUA);
            }
            if (this.lVL != null) {
                this.lVL.onChangeSkinType(i);
            }
            if (this.lUp != null) {
                if (this.lUv != null) {
                    this.lUv.Hs(i);
                } else {
                    this.lUp.onChangeSkinType(i);
                }
            }
            if (this.lVf != null) {
                this.lVf.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0401));
            }
            if (this.lVe != null) {
                this.lVe.setBackgroundDrawable(com.baidu.tbadk.core.util.ao.aO(com.baidu.adp.lib.util.l.getDimens(this.lIN.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0209)));
            }
            if (this.lKe != null && this.lKe.bny()) {
                WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.lVg, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lKe);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lVd, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lVc, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lVV, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.klE, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lVl, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lVk, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ao.d(this.lVk, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.lVY != null) {
                this.lVY.onChangeSkinType(i);
            }
            if (this.lVB != null) {
                this.lVB.onChangeSkinType();
            }
            if (this.lUu != null) {
                this.lUu.vU(i);
            }
            if (this.lVj != null) {
                this.lVj.onChangeSkinType();
            }
            if (this.lWi != null) {
                this.lWi.onChangeSkinType();
            }
        }
    }

    public void dsK() {
        if (this.lVj != null) {
            this.lVj.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bc(fVar.dmF())) {
            if (this.lVj != null) {
                this.lVj.setEnable(false);
                this.lVj.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lVi.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lVi.setLayoutParams(layoutParams);
            WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lVj == null || !this.lVj.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lVi.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lVi.setLayoutParams(layoutParams2);
            WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
        this.lUE.setOnImageClickListener(this.fWO);
        this.lVY.setOnImageClickListener(this.fWO);
    }

    public void g(NoNetworkView.a aVar) {
        this.jct = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jct);
        }
    }

    public void vy(boolean z) {
        this.lUE.setIsFromCDN(z);
    }

    public Button dsL() {
        return this.lVb;
    }

    public void dsM() {
        if (this.lUo != 2) {
            this.lUt.setNextPage(this.jnf);
            this.lUo = 2;
        }
    }

    public boolean dsN() {
        return this.acZ != null && this.acZ.getVisibility() == 0;
    }

    public boolean dsO() {
        return this.acZ != null && this.acZ.bEN();
    }

    public void dsP() {
        if (this.acZ != null) {
            this.acZ.bDf();
        }
    }

    public void vz(boolean z) {
        if (this.lVd != null) {
            vx(this.lIN.doK().bFx());
            if (this.lUZ) {
                vo(z);
            } else {
                vp(z);
            }
        }
    }

    public void dsQ() {
        if (this.lVd != null) {
            this.lVc.setVisibility(8);
            this.lVd.setVisibility(8);
            this.lVm = false;
            if (this.lVB != null) {
                this.lVB.setVisibility(8);
                vt(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.iCD == null) {
            this.iCD = new com.baidu.tbadk.core.view.a(this.lIN.getPageContext());
        }
        this.iCD.setDialogVisiable(true);
    }

    public void cnj() {
        if (this.iCD != null) {
            this.iCD.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lUt.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lUt.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lUv != null) {
            this.lUv.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.mLastScrollY = getScrollY();
            this.lVA.lWI = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lVA));
            a(this.lVA.lWI, true);
            dtf();
        }
    }

    public void vA(boolean z) {
        if (this.lUv != null) {
            this.lUv.vA(z);
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
        if (this.lUv != null) {
            this.lUv.onScroll(absListView, i, i2, i3);
        }
        if (this.lUp != null && this.lUy != null) {
            this.lUp.dP(this.lUy.dtu());
        }
        this.lVA.lzC = i;
        this.lVA.headerCount = this.lUt.getHeaderViewsCount();
        this.lVA.lWI = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lVA));
        vq(b(absListView, i));
        a(this.lVA.lWI, false);
        dtf();
        if (this.jnf.bxF() && !this.jnf.fkQ) {
            if (this.lVA != null && this.lVA.lWI != null && this.lVA.lWI.getView() != null) {
                i4 = this.lVA.lWI.getView().getTop() < 0 ? this.lVA.lWI.getView().getHeight() : this.lVA.lWI.getView().getBottom();
            }
            this.jnf.re(i4);
            this.jnf.fkQ = true;
        }
    }

    public void dsR() {
        if (TbadkCoreApplication.isLogin() && this.lKe != null && this.lVQ && !this.lVP && !this.lUX && this.lVp != null && this.lVp.brr() != null && !this.lVp.brr().getIsLike() && !this.lVp.brr().hadConcerned() && this.lVM == null) {
            this.lVM = new al(this.lIN);
        }
    }

    public void dsS() {
        if (this.lIN != null) {
            if ((this.jeW || this.lWf == 17) && com.baidu.tbadk.a.d.bmJ()) {
                if (this.lKe != null && this.lKe.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lKe.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lIN.getContext()).createNormalCfg(this.lKe.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dX("post_id", this.lKe.getThreadId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("fid", this.lKe.getForum().getId()));
                }
            } else if (this.lVQ && !this.lVP && this.lVp != null && this.lVp.brr() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").an("obj_locate", this.lIN.dnO() ? 2 : 1).an("obj_type", this.lVP ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lIN.getPageContext().getPageActivity(), this.lVp.brr().getUserId(), this.lVp.brr().getUserName(), this.lIN.dnW().dnP(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z) {
        int measuredHeight;
        if (!this.lVP && this.lVu != null && this.lUp.dtM() != null) {
            int dow = this.lUE.dow();
            if (dow > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                if (dow > this.lUt.getFirstVisiblePosition() - this.lUt.getHeaderViewsCount()) {
                    this.lVu.setVisibility(4);
                    return;
                }
                this.lVu.setVisibility(0);
                vq(false);
                this.lUp.mNavigationBar.hideBottomLine();
                if (this.lVu.getParent() != null && ((ViewGroup) this.lVu.getParent()).getHeight() <= this.lVu.getTop()) {
                    this.lVu.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null || pbReplyTitleViewHolder.lTP == null) {
                if (this.lUt.getFirstVisiblePosition() == 0) {
                    this.lVu.setVisibility(4);
                    this.lUp.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.lVz) {
                        this.lVy = top;
                        this.lVz = false;
                    }
                    this.lVy = top < this.lVy ? top : this.lVy;
                }
                if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                    if (this.lUD.getY() < 0.0f) {
                        measuredHeight = lVx - pbReplyTitleViewHolder.lTP.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lUp.dtM().getMeasuredHeight() - pbReplyTitleViewHolder.lTP.getMeasuredHeight();
                        this.lUp.mNavigationBar.hideBottomLine();
                    }
                    if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.lVy) {
                        this.lVu.setVisibility(0);
                        vq(false);
                    } else if (top < measuredHeight) {
                        this.lVu.setVisibility(0);
                        vq(false);
                    } else {
                        this.lVu.setVisibility(4);
                        this.lUp.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lVz = true;
                    }
                }
            }
        }
    }

    public void dsT() {
        if (!this.lWu) {
            TiebaStatic.log("c10490");
            this.lWu = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIN.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lVE, Integer.valueOf(lVG));
            aVar.oZ(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lIN.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.br(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lIN);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.24
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lIN.getPageContext()).btY();
        }
    }

    public void PY(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIN.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lIN.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.br(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lVE, Integer.valueOf(lVH));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lIN);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lIN.getPageContext()).btY();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b2;
        if (i > 0 && (b2 = b(fVar, z)) != null && b2.brr() != null) {
            MetaData brr = b2.brr();
            brr.setGiftNum(brr.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.lUy.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dsU() {
        return this.lVs;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmF() != null && fVar.dmF().bsB() && this.lVs == null) {
            this.lVs = (PbInterviewStatusView) this.lVr.inflate();
            this.lVs.setOnClickListener(this.jhV);
            this.lVs.setCallback(this.lIN.dpv());
            this.lVs.setData(this.lIN, fVar);
        }
    }

    public RelativeLayout dsV() {
        return this.lUD;
    }

    public View dsW() {
        return this.bMl;
    }

    public boolean dsX() {
        return this.lWk;
    }

    public void uE(boolean z) {
        this.lUy.uE(z);
    }

    public void PZ(String str) {
        if (this.lUq != null) {
            this.lUq.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int vB(boolean z) {
        if (this.lVs == null || this.lVs.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dsY() {
        if (this.lVs != null && this.lVs.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lVs.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lVs.setLayoutParams(layoutParams);
        }
    }

    public boolean doQ() {
        return false;
    }

    public void Qa(String str) {
        this.klE.performClick();
        if (!StringUtils.isNull(str) && this.lIN.doK() != null && this.lIN.doK().bFp() != null && this.lIN.doK().bFp().getInputView() != null) {
            EditText inputView = this.lIN.doK().bFp().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dsH();
            if (configuration.orientation == 2) {
                dsQ();
                drL();
            } else {
                drP();
            }
            if (this.lVL != null) {
                this.lVL.doF();
            }
            this.lIN.cFB();
            this.lUD.setVisibility(8);
            this.lUp.vN(false);
            this.lIN.uT(false);
            if (this.lUv != null) {
                if (configuration.orientation == 1) {
                    dsV().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lUt.setIsLandscape(true);
                    this.lUt.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lUt.setIsLandscape(false);
                    if (this.mLastScrollY > 0) {
                        this.lUt.smoothScrollBy(this.mLastScrollY, 0);
                    }
                }
                this.lUv.onConfigurationChanged(configuration);
                this.lVt.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void vC(boolean z) {
        if (this.lUv != null) {
            this.lUv.vC(z);
        }
    }

    public boolean dsZ() {
        return this.lUv != null && this.lUv.dsZ();
    }

    public void dta() {
        if (this.lUv != null) {
            this.lUv.dta();
        }
    }

    public void uI(boolean z) {
        this.lUE.uI(z);
    }

    public void dO(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lVd.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lIN.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lVV = new TextView(this.lIN.getContext());
            this.lVV.setText(R.string.connection_tips);
            this.lVV.setGravity(17);
            this.lVV.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lIN.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lIN.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lIN.getContext(), R.dimen.ds60);
            if (this.lVV.getParent() == null) {
                frameLayout.addView(this.lVV, layoutParams);
            }
            this.lVU = new PopupWindow(this.lIN.getContext());
            this.lVU.setContentView(frameLayout);
            this.lVU.setHeight(-2);
            this.lVU.setWidth(-2);
            this.lVU.setFocusable(true);
            this.lVU.setOutsideTouchable(false);
            this.lVU.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lUt.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.26
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ap.this.lVU.showAsDropDown(ap.this.lVd, view.getLeft(), -ap.this.lVd.getHeight());
                    } else {
                        ap.this.lVU.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void vD(boolean z) {
        this.lWa = z;
    }

    public boolean dtb() {
        return this.lWa;
    }

    public PbThreadPostView dtc() {
        return this.lUu;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmF() != null && !fVar.dmF().bpW()) {
            boolean z = fVar.dmF().brn() == 1;
            boolean z2 = fVar.dmF().brm() == 1;
            if (this.lUy != null) {
                this.lUy.c(fVar, z, z2);
            }
            if (this.lUE != null && this.lUE.doB() != null) {
                this.lUE.doB().b(fVar, z, z2);
            }
        }
    }

    public void vE(boolean z) {
        this.jeW = z;
    }

    public void Hj(int i) {
        this.lWf = i;
    }

    public void dtd() {
        if (this.lUt != null) {
            this.lUt.setForbidDragListener(true);
        }
    }

    public boolean dpP() {
        if (this.lUt == null) {
            return false;
        }
        return this.lUt.dpP();
    }

    public boolean dte() {
        if (this.jnf == null || TextUtils.isEmpty(this.jnf.getEndText())) {
            return false;
        }
        return this.jnf.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmF() == null) {
            return false;
        }
        SpannableStringBuilder bsa = fVar.dmF().bsa();
        if (bsa != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(bsa.toString());
        }
        return true;
    }

    public void dtf() {
        boolean z;
        if (this.lWi != null) {
            if (((this.lWi.getView() == null || this.lWi.getView().getParent() == null) ? -1 : this.lUt.getPositionForView(this.lWi.getView())) != -1) {
                if (this.lWi.getView().getTop() + lWg <= this.lVu.getBottom()) {
                    this.lWh = 1;
                    z = true;
                } else {
                    this.lWh = 0;
                    z = false;
                }
            } else {
                z = this.lWh == 1;
            }
            this.lVw.vm(this.lWh == 1);
            this.lWi.setScrollable(z);
        }
    }

    public LinearLayout dtg() {
        return this.lVe;
    }
}
