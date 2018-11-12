package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbLongPressTipView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class ar {
    private static final int fWJ = UtilHelper.getLightStatusBarHeight();
    public static int fWP = 3;
    public static int fWQ = 0;
    public static int fWR = 3;
    public static int fWS = 4;
    public static int fWT = 5;
    public static int fWU = 6;
    private static a.InterfaceC0303a fXr = new a.InterfaceC0303a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0303a
        public void onRefresh() {
        }
    };
    private EditorTools Ta;
    private j.b aFe;
    private TextView aGH;
    private TextView aQZ;
    private View bbH;
    private com.baidu.tieba.pb.a.c boq;
    private List<CustomBlueCheckRadioButton> cQz;
    private View cUE;
    private View dDK;
    private View.OnClickListener dDv;
    private PbListView dHf;
    private NavigationBarCoverTip dXG;
    private NoNetworkView dhH;
    private RelativeLayout dhJ;
    private com.baidu.tieba.NEGFeedBack.e eaJ;
    PbActivity.d fNk;
    private View.OnClickListener fOC;
    private PbActivity fOe;
    private UserIconBox fPo;
    private UserIconBox fPp;
    private PbFakeFloorModel fQx;
    private com.baidu.tieba.pb.data.d fRE;
    public int fUW;
    private com.baidu.tieba.pb.video.i fUX;
    private long fUY;
    private com.baidu.tieba.pb.video.h fUZ;
    private ap fVA;
    private ap fVB;
    private TextView fVC;
    private TextView fVD;
    private TextView fVE;
    private View fVF;
    private View fVG;
    private LinearLayout fVH;
    private TextView fVI;
    private TextView fVJ;
    private View fVK;
    private View fVL;
    private ObservedChangeLinearLayout fVN;
    private f fVO;
    private View fVU;
    private com.baidu.tieba.c.d fVa;
    public final com.baidu.tieba.pb.pb.main.view.b fVd;
    public com.baidu.tieba.pb.pb.main.view.a fVe;
    private ViewStub fVf;
    private ViewStub fVg;
    private PbLandscapeListView fVh;
    private View fVi;
    private LinearLayout fVl;
    private e fVm;
    private ColumnLayout fVn;
    private ThreadSkinView fVo;
    private TextView fVp;
    private TextView fVq;
    private ImageView fVr;
    private HeadPendantView fVs;
    private FrameLayout fVt;
    private HeadImageView fVu;
    private View fVv;
    private FloatingLayout fVw;
    private PbFirstFloorUserLikeButton fVz;
    private TextView fWA;
    private ViewStub fWB;
    private PbInterviewStatusView fWC;
    private ViewGroup fWD;
    private TextView fWE;
    private FrameLayout fWF;
    private View fWG;
    private View fWH;
    private al fWI;
    private PbEmotionBar fWN;
    private int fWV;
    private Runnable fWW;
    private s fWX;
    private an fWY;
    private View fWo;
    private TextView fWp;
    private ImageView fWq;
    private ImageView fWr;
    private TextView fWs;
    private boolean fWu;
    private int fWv;
    private int fWw;
    private PostData fWx;
    private View fWz;
    private PbActivity.b fXB;
    private int fXG;
    private int fXe;
    private PbTopTipView fXg;
    private PopupWindow fXh;
    private PopupWindow fXi;
    private TextView fXj;
    private com.baidu.tbadk.core.dialog.a fXk;
    private List<String> fXl;
    private com.baidu.tieba.pb.pb.main.emotion.c fXm;
    private com.baidu.tieba.pb.pb.godreply.a fXn;
    private PbLandscapeListView.b fXo;
    private ac fXq;
    private boolean fXs;
    private com.baidu.tbadk.core.view.userLike.c fXt;
    private com.baidu.tbadk.core.view.userLike.c fXu;
    private Runnable fXz;
    private boolean isLandscape;
    private int mType;
    private boolean fVb = false;
    private int fVc = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fVj = null;
    private TextView fVk = null;
    public FrsPraiseView fVx = null;
    private ClickableHeaderImageView fVy = null;
    private View fVM = null;
    private com.baidu.tbadk.core.dialog.a fVP = null;
    private com.baidu.tbadk.core.dialog.b dDu = null;
    private View fVQ = null;
    private EditText fVR = null;
    private com.baidu.tieba.pb.view.d fVS = null;
    private com.baidu.tieba.pb.view.a fVT = null;
    private com.baidu.tbadk.core.dialog.a fVV = null;
    private b.InterfaceC0148b eMf = null;
    private TbRichTextView.h bop = null;
    private NoNetworkView.a dzq = null;
    private Dialog fVW = null;
    private View fVX = null;
    private com.baidu.tbadk.core.dialog.a fVY = null;
    private Dialog fVZ = null;
    private Dialog fWa = null;
    private View fWb = null;
    private LinearLayout fWc = null;
    private CompoundButton.OnCheckedChangeListener cQA = null;
    private TextView fWd = null;
    private TextView fWe = null;
    private View fWf = null;
    private String fWg = null;
    private com.baidu.tbadk.core.dialog.b fWh = null;
    private com.baidu.tbadk.core.dialog.b fWi = null;
    private boolean fWj = false;
    private boolean fWk = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fWl = null;
    private boolean fWm = false;
    private Button fWn = null;
    private boolean fWt = true;
    private com.baidu.tbadk.core.view.d cXS = null;
    private boolean fOv = false;
    private int mSkinType = 3;
    private boolean fWy = false;
    private int fWK = 0;
    private boolean fWL = true;
    private a fWM = new a();
    private int fWO = 0;
    private boolean fWZ = false;
    private int fXa = 0;
    private boolean fXb = false;
    private boolean fXc = false;
    private boolean fXd = false;
    private int fXf = 0;
    private boolean fXp = false;
    private String fXv = null;
    private CustomMessageListener fXw = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.fXv = null;
            }
        }
    };
    private CustomMessageListener bMF = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fVO != null) {
                ar.this.fVO.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fXx = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fVk != null) {
                ar.this.fVk.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fXy = new Handler();
    private CustomMessageListener fXA = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fWt = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fXC = true;
    View.OnClickListener fXD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fXb) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (ar.this.fVd != null && ar.this.fVd.gak != null && view == ar.this.fVd.gak.getHeadView()) {
                if (ar.this.fVd.gai == null || ar.this.fVd.gai.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").x("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!ar.this.fXb && ar.this.fRE != null && ar.this.fRE.bet() != null && ar.this.fRE.bet().yC() != null && ar.this.fRE.bet().yC().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").x("obj_locate", 1));
            }
            ar.this.fOe.fMi.ebD.onClick(view);
        }
    };
    private boolean fXE = false;
    String userId = null;
    private final List<TbImageView> fXF = new ArrayList();
    private boolean fXH = false;

    /* loaded from: classes6.dex */
    public static class a {
        public int fEB;
        public al fXV;
        public int headerCount;
    }

    public void ld(boolean z) {
        this.fWZ = z;
        if (this.fVh != null) {
            this.fXa = this.fVh.getHeaderViewsCount();
        }
    }

    public void biE() {
        if (this.fVh != null) {
            int headerViewsCount = this.fVh.getHeaderViewsCount() - this.fXa;
            final int firstVisiblePosition = (this.fVh.getFirstVisiblePosition() == 0 || this.fVh.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fVh.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fVh.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fWM.fXV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fWM));
            final al alVar = this.fWM.fXV;
            final int h = h(alVar);
            final int y = ((int) this.fVN.getY()) + this.fVN.getMeasuredHeight();
            final boolean z = this.fWG.getVisibility() == 0;
            boolean z2 = this.fVN.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fVO.bgS() + this.fVh.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fUw.getMeasuredHeight() : 0;
                if (z2) {
                    this.fVh.setSelectionFromTop(this.fVO.bgS() + this.fVh.getHeaderViewsCount(), fWJ - measuredHeight);
                } else {
                    this.fVh.setSelectionFromTop(this.fVO.bgS() + this.fVh.getHeaderViewsCount(), this.fVd.bkn().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fVh.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fXb) {
                this.fVh.setSelectionFromTop(this.fVO.bgS() + this.fVh.getHeaderViewsCount(), this.fUX.blB().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fVh.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bhj() {
                        if (h >= 0 && h <= ar.this.dhJ.getMeasuredHeight()) {
                            int h2 = ar.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.cUE.getLayoutParams();
                            if (i == 0 || i > ar.this.dhJ.getMeasuredHeight() || h2 >= ar.this.dhJ.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fWV;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.dhJ.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fWV;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fVh.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.cUE.setLayoutParams(layoutParams);
                        }
                        ar.this.fVh.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(al alVar) {
        if (alVar == null || alVar.getView() == null) {
            return 0;
        }
        if (alVar.getView().getTop() != 0 || alVar.getView().isShown()) {
            return alVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView biF() {
        return this.dhH;
    }

    public void biG() {
        if (this.Ta != null) {
            this.Ta.hide();
            if (this.fXm != null) {
                this.fXm.Yu();
            }
        }
    }

    public PbFakeFloorModel biH() {
        return this.fQx;
    }

    public s biI() {
        return this.fWX;
    }

    public void biJ() {
        reset();
        biG();
        this.fWX.bgZ();
        lp(false);
    }

    private void reset() {
        if (this.fOe != null && this.fOe.bfJ() != null && this.Ta != null) {
            com.baidu.tbadk.editortools.pb.a.Lp().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bfJ = this.fOe.bfJ();
            bfJ.LI();
            bfJ.Ld();
            if (bfJ.getWriteImagesInfo() != null) {
                bfJ.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bfJ.fC(SendView.ALL);
            bfJ.fD(SendView.ALL);
            com.baidu.tbadk.editortools.g ft = this.Ta.ft(23);
            com.baidu.tbadk.editortools.g ft2 = this.Ta.ft(2);
            com.baidu.tbadk.editortools.g ft3 = this.Ta.ft(5);
            if (ft2 != null) {
                ft2.pO();
            }
            if (ft3 != null) {
                ft3.pO();
            }
            if (ft != null) {
                ft.hide();
            }
            this.Ta.invalidate();
        }
    }

    public boolean biK() {
        return this.fWt;
    }

    public void le(boolean z) {
        if (this.fWo != null && this.fWp != null) {
            this.fWp.setText(e.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fWo.startAnimation(alphaAnimation);
            }
            this.fWo.setVisibility(0);
            this.fWt = true;
            if (this.fWN != null && !this.fXn.isActive()) {
                this.fWN.setVisibility(0);
                lj(true);
            }
        }
    }

    public void lf(boolean z) {
        if (this.fWo != null && this.fWp != null) {
            this.fWp.setText(e.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fWo.startAnimation(alphaAnimation);
            }
            this.fWo.setVisibility(0);
            this.fWt = true;
            if (this.fWN != null && !this.fXn.isActive()) {
                this.fWN.setVisibility(0);
                lj(true);
            }
        }
    }

    public PostData biL() {
        int i = 0;
        if (this.fVh == null) {
            return null;
        }
        int biM = biM() - this.fVh.getHeaderViewsCount();
        if (biM < 0) {
            biM = 0;
        }
        if (this.fVO.rN(biM) != null && this.fVO.rN(biM) != PostData.hes) {
            i = biM + 1;
        }
        return this.fVO.getItem(i) instanceof PostData ? (PostData) this.fVO.getItem(i) : null;
    }

    public int biM() {
        int i;
        View childAt;
        if (this.fVh == null) {
            return 0;
        }
        int firstVisiblePosition = this.fVh.getFirstVisiblePosition();
        int lastVisiblePosition = this.fVh.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fVh.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fVh.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int biN() {
        return this.fVh.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fRE != null && this.fRE.bev() != null && !this.fRE.bev().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fRE.bev().size() && (postData = this.fRE.bev().get(i)) != null && postData.yC() != null && !StringUtils.isNull(postData.yC().getUserId()); i++) {
                if (this.fRE.bev().get(i).yC().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fXn != null && this.fXn.isActive()) {
                        lp(false);
                    }
                    if (this.fWN != null) {
                        this.fWN.lx(true);
                    }
                    this.fXv = postData.yC().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fOe = null;
        this.dhJ = null;
        this.dDK = null;
        this.fUY = 0L;
        this.fVh = null;
        this.fVi = null;
        this.fVl = null;
        this.fVn = null;
        this.fVp = null;
        this.fVq = null;
        this.fVt = null;
        this.fVu = null;
        this.fVv = null;
        this.fVz = null;
        this.fVC = null;
        this.fVD = null;
        this.fVE = null;
        this.fVF = null;
        this.fVK = null;
        this.fVL = null;
        this.fVO = null;
        this.dHf = null;
        this.bbH = null;
        this.dDv = null;
        this.fOC = null;
        this.fWo = null;
        this.fWp = null;
        this.fWq = null;
        this.fWr = null;
        this.fWs = null;
        this.fWz = null;
        this.fWA = null;
        this.fWB = null;
        this.fXe = 0;
        this.fUY = System.currentTimeMillis();
        this.fOe = pbActivity;
        this.dDv = onClickListener;
        this.boq = cVar;
        this.fXe = com.baidu.adp.lib.util.l.aO(this.fOe) / 2;
        this.dhJ = (RelativeLayout) LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.new_pb_activity, (ViewGroup) null);
        this.fOe.addContentView(this.dhJ, new FrameLayout.LayoutParams(-1, -1));
        this.dXG = (NavigationBarCoverTip) this.fOe.findViewById(e.g.pb_multi_forum_del_tip_view);
        this.dDK = this.fOe.findViewById(e.g.statebar_view);
        this.fVN = (ObservedChangeLinearLayout) this.fOe.findViewById(e.g.title_wrapper);
        this.dhH = (NoNetworkView) this.fOe.findViewById(e.g.view_no_network);
        this.fVh = (PbLandscapeListView) this.fOe.findViewById(e.g.new_pb_list);
        this.fWF = (FrameLayout) this.fOe.findViewById(e.g.root_float_header);
        this.aQZ = new TextView(this.fOe.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds88));
        this.fVh.addHeaderView(this.aQZ, 0);
        this.fWV = this.fOe.getResources().getDimensionPixelSize(e.C0200e.tbds134);
        this.cUE = new View(this.fOe.getPageContext().getPageActivity());
        this.cUE.setLayoutParams(new AbsListView.LayoutParams(-1, this.fWV));
        this.cUE.setVisibility(4);
        this.fVh.addFooterView(this.cUE);
        this.fVh.setOnTouchListener(this.fOe.bfm);
        this.fVd = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fOe.bgn()) {
            this.fVf = (ViewStub) this.fOe.findViewById(e.g.manga_view_stub);
            this.fVf.setVisibility(0);
            this.fVe = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fVe.show();
            this.fVd.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds120);
        }
        this.aQZ.setLayoutParams(layoutParams);
        this.fVd.bkn().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0268a() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0268a
            public void bfh() {
                if (ar.this.fVh != null) {
                    if (ar.this.fUX != null) {
                        ar.this.fUX.blC();
                    }
                    ar.this.fVh.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0268a
            public void bfi() {
                ar.this.fOe.azo();
            }
        }));
        this.fWo = this.fOe.findViewById(e.g.pb_editor_tool_comment);
        this.fWv = com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds90);
        this.fWw = com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds242);
        this.fWp = (TextView) this.fOe.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_reply_text);
        this.fWr = (ImageView) this.fOe.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_more_img);
        this.fWq = (ImageView) this.fOe.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_emotion_img);
        this.fWs = (TextView) this.fOe.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_praise_icon);
        this.fWs.setVisibility(8);
        this.fWp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.biO();
            }
        });
        this.fWq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bjP();
                if (ar.this.fOe.checkUpIsLogin()) {
                    if (ar.this.Ta != null) {
                        ar.this.biY();
                        ar.this.Ta.aa((View) ar.this.Ta.ft(5));
                    }
                    if (ar.this.Ta != null) {
                        ar.this.fWt = false;
                        if (ar.this.Ta.fw(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fOe, (View) ar.this.Ta.fw(2).aUL, false, ar.fXr);
                        }
                    }
                    ar.this.bjC();
                }
            }
        });
        this.fWr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bjP();
                if (ar.this.fOe.checkUpIsLogin()) {
                    if (ar.this.Ta != null) {
                        ar.this.biY();
                        ar.this.Ta.aa((View) ar.this.Ta.ft(2));
                    }
                    if (ar.this.Ta != null) {
                        ar.this.fWt = false;
                        if (ar.this.Ta.fw(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fOe, (View) ar.this.Ta.fw(2).aUL, false, ar.fXr);
                        }
                    }
                    ar.this.bjC();
                }
            }
        });
        this.fWs.setOnClickListener(this.dDv);
        this.fWs.setOnTouchListener(this.fOe);
        this.fVi = LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_item, (ViewGroup) null);
        this.fVl = (LinearLayout) LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_user_item, (ViewGroup) null);
        this.fVm = new e(this.fOe, this.fVl);
        this.fVm.init();
        this.fVm.a(this.fVm.bfI(), this.dDv);
        this.fVn = (ColumnLayout) this.fVl.findViewById(e.g.pb_head_owner_root);
        this.fVo = (ThreadSkinView) this.fVl.findViewById(e.g.pb_thread_skin);
        this.fVn.setOnLongClickListener(this.onLongClickListener);
        this.fVn.setOnTouchListener(this.boq);
        this.fVn.setVisibility(8);
        this.fVi.setOnTouchListener(this.boq);
        this.fWz = this.fVi.findViewById(e.g.pb_head_activity_join_number_container);
        this.fWz.setVisibility(8);
        this.fWA = (TextView) this.fVi.findViewById(e.g.pb_head_activity_join_number);
        this.fVp = (TextView) this.fVn.findViewById(e.g.pb_head_owner_info_user_name);
        this.fVq = (TextView) this.fVn.findViewById(e.g.floor_owner);
        this.fVr = (ImageView) this.fVn.findViewById(e.g.icon_forum_level);
        this.fVt = (FrameLayout) this.fVn.findViewById(e.g.pb_head_headImage_container);
        this.fVu = (HeadImageView) this.fVn.findViewById(e.g.pb_head_owner_photo);
        this.fVs = (HeadPendantView) this.fVn.findViewById(e.g.pb_pendant_head_owner_photo);
        this.fVs.setHasPendantStyle();
        if (this.fVs.getHeadView() != null) {
            this.fVs.getHeadView().setIsRound(true);
            this.fVs.getHeadView().setDrawBorder(false);
        }
        this.fPo = (UserIconBox) this.fVn.findViewById(e.g.show_icon_vip);
        this.fPp = (UserIconBox) this.fVn.findViewById(e.g.show_icon_yinji);
        this.fVw = (FloatingLayout) this.fVl.findViewById(e.g.pb_head_owner_info_root);
        this.fVz = (PbFirstFloorUserLikeButton) this.fVn.findViewById(e.g.pb_like_button);
        this.fVC = (TextView) this.fVn.findViewById(e.g.pb_views);
        this.aGH = (TextView) this.fVn.findViewById(e.g.view_forum_name);
        this.fVG = this.fVn.findViewById(e.g.line_right_forum_name);
        this.fVD = (TextView) this.fVn.findViewById(e.g.pb_item_first_floor_reply_time);
        this.fVE = (TextView) this.fVn.findViewById(e.g.pb_item_first_floor_location_address);
        this.fVF = this.fVn.findViewById(e.g.line_between_time_and_locate);
        this.fXt = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fXu = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fVK = this.fVi.findViewById(e.g.new_pb_header_item_line_above_livepost);
        this.fVL = this.fVi.findViewById(e.g.new_pb_header_item_line_below_livepost);
        this.fVi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.37
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fWB = (ViewStub) this.dhJ.findViewById(e.g.interview_status_stub);
        this.fVO = new f(this.fOe, this.fVh);
        this.fVO.w(this.dDv);
        this.fVO.setTbGestureDetector(this.boq);
        this.fVO.setOnImageClickListener(this.bop);
        this.fOC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(e.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(e.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(e.g.tag_from, 1);
                            ar.this.fOe.b(sparseArray);
                            return;
                        }
                        ar.this.bC(view);
                    } else if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 0);
                        sparseArray.put(e.g.tag_check_mute_from, 1);
                        ar.this.fOe.b(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fVO.I(this.fOC);
        biT();
        this.fVh.addHeaderView(this.fVj);
        this.fVh.addHeaderView(this.fVl);
        this.fVh.addHeaderView(this.fVi);
        this.dHf = new PbListView(this.fOe.getPageContext().getPageActivity());
        this.bbH = this.dHf.getView().findViewById(e.g.pb_more_view);
        if (this.bbH != null) {
            this.bbH.setOnClickListener(this.dDv);
            com.baidu.tbadk.core.util.al.i(this.bbH, e.f.pb_foot_more_trans_selector);
        }
        this.dHf.DU();
        this.dHf.eh(e.f.pb_foot_more_trans_selector);
        this.dHf.ej(e.f.pb_foot_more_trans_selector);
        this.fVU = this.fOe.findViewById(e.g.viewstub_progress);
        this.fOe.registerListener(this.fXA);
        this.fVv = com.baidu.tbadk.ala.b.uV().j(this.fOe.getActivity(), 2);
        if (this.fVv != null) {
            this.fVv.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fOe.getResources().getDimensionPixelSize(e.C0200e.ds10);
            if (this.fVv.getParent() == null) {
                this.fVw.addView(this.fVv, aVar);
            }
        }
        this.fQx = new PbFakeFloorModel(this.fOe.getPageContext());
        this.fWX = new s(this.fOe.getPageContext(), this.fQx, this.dhJ);
        this.fWX.a(this.fOe.fNg);
        this.fQx.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.fQx.m(postData);
                ar.this.fVO.notifyDataSetChanged();
                ar.this.fWX.bgZ();
                ar.this.Ta.Js();
                ar.this.lp(false);
            }
        });
        if (this.fOe.bfx() != null && !StringUtils.isNull(this.fOe.bfx().bhQ())) {
            this.fOe.showToast(this.fOe.bfx().bhQ());
        }
        this.fWG = this.fOe.findViewById(e.g.pb_expand_blank_view);
        this.fWH = this.fOe.findViewById(e.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fWH.getLayoutParams();
        if (this.fOe.bfx() != null && this.fOe.bfx().bhp()) {
            this.fWG.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fWH.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fWJ;
            this.fWH.setLayoutParams(layoutParams2);
        }
        this.fWI = new al(this.fOe.getPageContext(), this.fOe.findViewById(e.g.pb_reply_expand_view));
        this.fWI.fUw.setVisibility(8);
        this.fWI.L(this.dDv);
        this.fOe.registerListener(this.bMF);
        this.fOe.registerListener(this.fXw);
        this.fOe.registerListener(this.fXx);
        biP();
        lj(false);
    }

    public void biO() {
        bjP();
        if (!this.fOe.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.fOe.bfV()) {
            com.baidu.tbadk.editortools.pb.d bfJ = this.fOe.bfJ();
            if (bfJ != null && (bfJ.LF() || bfJ.LG())) {
                this.fOe.bfJ().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Ta != null) {
                biY();
            }
            if (this.Ta != null) {
                this.fWt = false;
                if (this.Ta.fw(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.fOe, (View) this.Ta.fw(2).aUL, false, fXr);
                }
            }
            bjC();
        }
    }

    private void biP() {
        this.fXn = new com.baidu.tieba.pb.pb.godreply.a(this.fOe, this, (ViewStub) this.dhJ.findViewById(e.g.more_god_reply_popup));
        this.fXn.s(this.dDv);
        this.fXn.I(this.fOC);
        this.fXn.setOnImageClickListener(this.bop);
        this.fXn.s(this.dDv);
        this.fXn.setTbGestureDetector(this.boq);
    }

    public com.baidu.tieba.pb.pb.godreply.a biQ() {
        return this.fXn;
    }

    public View biR() {
        return this.fWG;
    }

    public void biS() {
        if (this.fVh != null) {
            this.fVh.removeHeaderView(this.fVj);
            this.fVh.removeHeaderView(this.fVl);
            this.fVh.removeHeaderView(this.fVi);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fWN == null) {
            this.fWN = new PbEmotionBar(this.fOe.getPageContext().getPageActivity());
            lj(true);
            this.fWN.a(this.dhJ, aVar, this.fWo.getVisibility() == 0);
            this.fWN.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (ar.this.fOe.bfV()) {
                        if (!StringUtils.isNull(ar.this.fXv)) {
                            emotionImageData.setAuthorNameShow(ar.this.fXv);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fOe.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fOe.getPageContext().getPageActivity(), 25016, str, list, ar.this.fXv, list2)));
                }
            });
            this.fWN.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    ar.this.bjP();
                    if (ar.this.fWo != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fWo.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fWw - ar.this.fWv) * f) + ar.this.fWv);
                        ar.this.fWp.setAlpha(1.0f - f);
                        ar.this.fWr.setAlpha(1.0f - f);
                        ar.this.fWq.setAlpha(1.0f - f);
                        ar.this.fWo.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void biT() {
        if (this.fVj == null) {
            int h = com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.tbds44);
            this.fVj = new LinearLayout(this.fOe.getPageContext().getPageActivity());
            this.fVj.setOrientation(1);
            this.fVj.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fVj.setPadding(h, com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.tbds30), h, com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.tbds40));
            this.fVj.setGravity(17);
            this.fVk = new TextView(this.fOe.getPageContext().getPageActivity());
            this.fVk.setGravity(3);
            this.fVk.setMaxLines(2);
            this.fVk.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            this.fVk.setPadding(0, 0, 0, 0);
            this.fVk.setLineSpacing(com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.fVk, e.d.cp_cont_b);
            this.fVk.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fVk.setVisibility(8);
            if (this.fVk.getParent() == null) {
                this.fVj.addView(this.fVk);
            }
            this.fVj.setOnTouchListener(this.boq);
            this.fVj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biU() {
        if (this.fOe.bgn()) {
            this.fVg = (ViewStub) this.fOe.findViewById(e.g.manga_mention_controller_view_stub);
            this.fVg.setVisibility(0);
            if (this.fVH == null) {
                this.fVH = (LinearLayout) this.fOe.findViewById(e.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fOe.getPageContext(), this.fVH);
            }
            if (this.fVI == null) {
                this.fVI = (TextView) this.fVH.findViewById(e.g.manga_prev_btn);
            }
            if (this.fVJ == null) {
                this.fVJ = (TextView) this.fVH.findViewById(e.g.manga_next_btn);
            }
            this.fVI.setOnClickListener(this.dDv);
            this.fVJ.setOnClickListener(this.dDv);
        }
    }

    private void biV() {
        if (this.fOe.bgn()) {
            if (this.fOe.bgq() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fVI, e.d.cp_cont_e, 1);
            }
            if (this.fOe.bgr() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fVJ, e.d.cp_cont_e, 1);
            }
        }
    }

    public void biW() {
        if (this.fVH == null) {
            biU();
        }
        this.fVg.setVisibility(8);
        if (this.fXy != null && this.fXz != null) {
            this.fXy.removeCallbacks(this.fXz);
        }
    }

    public void biX() {
        if (this.fXy != null) {
            if (this.fXz != null) {
                this.fXy.removeCallbacks(this.fXz);
            }
            this.fXz = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fVH == null) {
                        ar.this.biU();
                    }
                    ar.this.fVg.setVisibility(0);
                }
            };
            this.fXy.postDelayed(this.fXz, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void lg(boolean z) {
        this.fVd.lg(z);
        if (z && this.fWy) {
            this.dHf.setText(this.fOe.getResources().getString(e.j.click_load_more));
            this.fVh.setNextPage(this.dHf);
            this.fVc = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
        this.Ta.setId(e.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Ta.getParent() == null) {
            this.dhJ.addView(this.Ta, layoutParams);
        }
        this.Ta.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        biG();
        this.fOe.bfJ().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.Ta != null && ar.this.Ta.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fXm == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.Ta.getId());
                            ar.this.fXm = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fOe.getPageContext(), ar.this.dhJ, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.I(ar.this.fXl)) {
                                ar.this.fXm.setData(ar.this.fXl);
                            }
                            ar.this.fXm.b(ar.this.Ta);
                        }
                        ar.this.fXm.sF(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fOe.fMm != null && ar.this.fOe.fMm.bjU() != null) {
                    if (!ar.this.fOe.fMm.bjU().bKS()) {
                        ar.this.fOe.fMm.lu(false);
                    }
                    ar.this.fOe.fMm.bjU().op(false);
                }
            }
        });
    }

    public void biY() {
        if (this.fOe != null && this.Ta != null) {
            this.Ta.pO();
            if (this.fOe.bfJ() != null) {
                this.fOe.bfJ().Lw();
            }
            bjC();
        }
    }

    public void U(String str, boolean z) {
        this.fWu = z;
        lh(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void lh(boolean z) {
        if (this.fWs != null) {
            if (this.fWu) {
                com.baidu.tbadk.core.util.al.i(this.fWs, e.f.pb_praise_already_click_selector);
                this.fWs.setContentDescription(this.fOe.getResources().getString(e.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.fWs, e.f.pb_praise_normal_click_selector);
            this.fWs.setContentDescription(this.fOe.getResources().getString(e.j.zan));
        }
    }

    public TextView biZ() {
        return this.fWs;
    }

    public void li(boolean z) {
        if (this.fVh != null && this.aQZ != null && this.dDK != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dDK.setVisibility(0);
                } else {
                    this.dDK.setVisibility(8);
                    this.fVh.removeHeaderView(this.aQZ);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aQZ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fWJ;
                    this.aQZ.setLayoutParams(layoutParams);
                }
                bjn();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aQZ.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + lr(true);
                this.aQZ.setLayoutParams(layoutParams2);
            }
            bjn();
            bjK();
        }
    }

    public f bja() {
        return this.fVO;
    }

    public void a(PbActivity.d dVar) {
        this.fNk = dVar;
    }

    public void bC(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fVX == null) {
            this.fVX = LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fOe.getLayoutMode().onModeChanged(this.fVX);
        if (this.fVW == null) {
            this.fVW = new Dialog(this.fOe.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fVW.setCanceledOnTouchOutside(true);
            this.fVW.setCancelable(true);
            this.fVW.setContentView(this.fVX);
            WindowManager.LayoutParams attributes = this.fVW.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.aO(this.fOe.getPageContext().getPageActivity()) * 0.9d);
            this.fVW.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fVW.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.fVW.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fVW.findViewById(e.g.disable_reply_btn);
        int intValue = sparseArray.get(e.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(e.g.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(e.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(e.j.delete);
            } else {
                textView.setText(e.j.delete_post);
            }
            sparseArray2.put(e.g.tag_del_post_id, sparseArray.get(e.g.tag_del_post_id));
            sparseArray2.put(e.g.tag_del_post_type, sparseArray.get(e.g.tag_del_post_type));
            sparseArray2.put(e.g.tag_del_post_is_self, sparseArray.get(e.g.tag_del_post_is_self));
            sparseArray2.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fVW != null && (ar.this.fVW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fVW, ar.this.fOe.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(e.g.tag_del_post_id), ((Integer) sparseArray5.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(e.g.tag_forbid_user_name)) && "".equals(sparseArray.get(e.g.tag_forbid_user_name_show))) || bjJ()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(e.g.tag_forbid_user_name, sparseArray.get(e.g.tag_forbid_user_name));
            sparseArray5.put(e.g.tag_forbid_user_name_show, sparseArray.get(e.g.tag_forbid_user_name_show));
            sparseArray5.put(e.g.tag_forbid_user_portrait, sparseArray.get(e.g.tag_forbid_user_portrait));
            sparseArray5.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
            sparseArray5.put(e.g.tag_forbid_user_post_id, sparseArray.get(e.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fVW != null && (ar.this.fVW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fVW, ar.this.fOe.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fXB != null) {
                        ar.this.fXB.m(new Object[]{sparseArray6.get(e.g.tag_manage_user_identity), sparseArray6.get(e.g.tag_forbid_user_name), sparseArray6.get(e.g.tag_forbid_user_post_id), sparseArray6.get(e.g.tag_forbid_user_name_show), sparseArray6.get(e.g.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(e.j.un_mute);
            } else {
                textView3.setText(e.j.mute);
            }
            sparseArray6.put(e.g.tag_is_mem, sparseArray.get(e.g.tag_is_mem));
            sparseArray6.put(e.g.tag_user_mute_mute_userid, sparseArray.get(e.g.tag_user_mute_mute_userid));
            sparseArray6.put(e.g.tag_user_mute_mute_username, sparseArray.get(e.g.tag_user_mute_mute_username));
            sparseArray6.put(e.g.tag_user_mute_mute_nameshow, sparseArray.get(e.g.tag_user_mute_mute_nameshow));
            sparseArray6.put(e.g.tag_user_mute_post_id, sparseArray.get(e.g.tag_user_mute_post_id));
            sparseArray6.put(e.g.tag_user_mute_thread_id, sparseArray.get(e.g.tag_user_mute_thread_id));
            sparseArray6.put(e.g.tag_user_mute_msg, sparseArray.get(e.g.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fVW != null && (ar.this.fVW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fVW, ar.this.fOe.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fOe.a(z, (String) sparseArray7.get(e.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fVW, this.fOe.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fXB = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fOe != null && aVar != null) {
            if (this.eaJ == null) {
                this.eaJ = new com.baidu.tieba.NEGFeedBack.e(this.fOe.getPageContext(), this.fVi);
            }
            AntiData ayn = this.fOe.ayn();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ayn != null && ayn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayn.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.eaJ.setDefaultReasonArray(new String[]{this.fOe.getString(e.j.delete_thread_reason_1), this.fOe.getString(e.j.delete_thread_reason_2), this.fOe.getString(e.j.delete_thread_reason_3), this.fOe.getString(e.j.delete_thread_reason_4), this.fOe.getString(e.j.delete_thread_reason_5)});
            this.eaJ.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.eaJ.iP(str);
            this.eaJ.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    ar.this.fOe.a(aVar, jSONArray);
                }
            });
        }
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(e.g.tag_del_post_id, str);
        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(fWQ, Integer.valueOf(fWR));
        int i3 = e.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = e.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = e.j.report_thread_confirm;
            } else {
                i3 = e.j.del_thread_confirm;
            }
        }
        this.fVY = new com.baidu.tbadk.core.dialog.a(this.fOe.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fVY.cN(i3);
        } else {
            this.fVY.bj(false);
            this.fVY.ej(str2);
        }
        this.fVY.H(sparseArray);
        this.fVY.a(e.j.dialog_ok, this.fOe);
        this.fVY.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fVY.be(true);
        this.fVY.b(this.fOe.getPageContext());
        if (z) {
            this.fVY.AB();
        } else {
            a(this.fVY, i);
        }
    }

    public void ap(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fWb == null) {
            this.fWb = LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.commit_good, (ViewGroup) null);
        }
        this.fOe.getLayoutMode().onModeChanged(this.fWb);
        if (this.fWa == null) {
            this.fWa = new Dialog(this.fOe.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fWa.setCanceledOnTouchOutside(true);
            this.fWa.setCancelable(true);
            this.fWl = (ScrollView) this.fWb.findViewById(e.g.good_scroll);
            this.fWa.setContentView(this.fWb);
            WindowManager.LayoutParams attributes = this.fWa.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds540);
            this.fWa.getWindow().setAttributes(attributes);
            this.cQA = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fWg = (String) compoundButton.getTag();
                        if (ar.this.cQz != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ar.this.cQz) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ar.this.fWg != null && !str.equals(ar.this.fWg)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fWc = (LinearLayout) this.fWb.findViewById(e.g.good_class_group);
            this.fWe = (TextView) this.fWb.findViewById(e.g.dialog_button_cancel);
            this.fWe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fWa instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fWa, ar.this.fOe.getPageContext());
                    }
                }
            });
            this.fWd = (TextView) this.fWb.findViewById(e.g.dialog_button_ok);
            this.fWd.setOnClickListener(this.dDv);
        }
        this.fWc.removeAllViews();
        this.cQz = new ArrayList();
        CustomBlueCheckRadioButton ck = ck("0", this.fOe.getPageContext().getString(e.j.thread_good_class));
        this.cQz.add(ck);
        ck.setChecked(true);
        this.fWc.addView(ck);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xr()) && aaVar.xs() > 0) {
                    CustomBlueCheckRadioButton ck2 = ck(String.valueOf(aaVar.xs()), aaVar.xr());
                    this.cQz.add(ck2);
                    View view = new View(this.fOe.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, e.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fWc.addView(view);
                    this.fWc.addView(ck2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fWl.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fOe.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fOe.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fOe.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fWl.setLayoutParams(layoutParams2);
            this.fWl.removeAllViews();
            if (this.fWc != null && this.fWc.getParent() == null) {
                this.fWl.addView(this.fWc);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fWa, this.fOe.getPageContext());
    }

    private CustomBlueCheckRadioButton ck(String str, String str2) {
        Activity pageActivity = this.fOe.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, e.C0200e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cQA);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bjb() {
        this.fOe.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fOe.hideProgressBar();
        if (z && z2) {
            this.fOe.showToast(this.fOe.getPageContext().getString(e.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.neterror);
            }
            this.fOe.showToast(str);
        }
    }

    public void aQE() {
        this.fVU.setVisibility(0);
    }

    public void aQD() {
        this.fVU.setVisibility(8);
    }

    public View bjc() {
        if (this.fWb != null) {
            return this.fWb.findViewById(e.g.dialog_button_ok);
        }
        return null;
    }

    public String bjd() {
        return this.fWg;
    }

    public View getView() {
        return this.dhJ;
    }

    public void bje() {
        com.baidu.adp.lib.util.l.b(this.fOe.getPageContext().getPageActivity(), this.fOe.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fOe.hideProgressBar();
        if (z) {
            bjt();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bju();
        } else {
            bjt();
        }
    }

    public void bjf() {
        this.dHf.DU();
        this.dHf.DY();
    }

    public void bjg() {
        this.fOe.hideProgressBar();
        DZ();
        this.fVh.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bjq();
    }

    public void bjh() {
        this.fVh.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bjq();
    }

    private void lj(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fWp.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fOe.getResources().getDimensionPixelSize(e.C0200e.ds130) : this.fOe.getResources().getDimensionPixelSize(e.C0200e.ds34);
        this.fWp.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fVO.setOnLongClickListener(onLongClickListener);
        if (this.fXn != null) {
            this.fXn.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0148b interfaceC0148b, boolean z, boolean z2) {
        if (this.fWh != null) {
            this.fWh.dismiss();
            this.fWh = null;
        }
        this.fWh = new com.baidu.tbadk.core.dialog.b(this.fOe.getPageContext().getPageActivity());
        this.fWh.cQ(e.j.operation);
        if (z2) {
            this.fWh.a(new String[]{this.fOe.getPageContext().getString(e.j.copy), this.fOe.getPageContext().getString(e.j.report_text)}, interfaceC0148b);
        } else if (!z) {
            this.fWh.a(new String[]{this.fOe.getPageContext().getString(e.j.copy), this.fOe.getPageContext().getString(e.j.mark)}, interfaceC0148b);
        } else {
            this.fWh.a(new String[]{this.fOe.getPageContext().getString(e.j.copy), this.fOe.getPageContext().getString(e.j.remove_mark)}, interfaceC0148b);
        }
        this.fWh.d(this.fOe.getPageContext());
        this.fWh.AE();
    }

    public void a(b.InterfaceC0148b interfaceC0148b, boolean z) {
        if (this.fWi != null) {
            this.fWi.dismiss();
            this.fWi = null;
        }
        this.fWi = new com.baidu.tbadk.core.dialog.b(this.fOe.getPageContext().getPageActivity());
        if (z) {
            this.fWi.a(new String[]{this.fOe.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0148b);
        } else {
            this.fWi.a(new String[]{this.fOe.getPageContext().getString(e.j.save_to_emotion), this.fOe.getPageContext().getString(e.j.save_to_local)}, interfaceC0148b);
        }
        this.fWi.d(this.fOe.getPageContext());
        this.fWi.AE();
    }

    public int bji() {
        return se(this.fVh.getFirstVisiblePosition());
    }

    private int se(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fVh.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fVh.getAdapter() == null || !(this.fVh.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fVh.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bjj() {
        int lastVisiblePosition = this.fVh.getLastVisiblePosition();
        if (this.fUX != null) {
            if (lastVisiblePosition == this.fVh.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return se(lastVisiblePosition);
    }

    public void sf(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fVh != null) {
            if (this.fVd == null || this.fVd.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fVd.mNavigationBar.getFixedNavHeight();
                if (!(this.fOe.bgb() != -1)) {
                    if (this.fWH != null && (layoutParams = (LinearLayout.LayoutParams) this.fWH.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fWH.setLayoutParams(layoutParams);
                    }
                    i--;
                    bjO();
                }
                i2 = fixedNavHeight;
            }
            this.fVh.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fVh.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fVR.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fVO.a(dVar, false);
        this.fVO.notifyDataSetChanged();
        bjq();
        if (this.fXn != null) {
            this.fXn.bft();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fVx == null) {
            this.fOe.getLayoutMode().onModeChanged(((ViewStub) this.fVi.findViewById(e.g.praise_layout)).inflate());
            this.fVx = (FrsPraiseView) this.fVi.findViewById(e.g.pb_head_praise_view);
            this.fVx.setIsFromPb(true);
            this.fVM = this.fVi.findViewById(e.g.new_pb_header_item_line_above_praise);
            this.fVx.eo(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fVx != null) {
            boolean bjq = bjq();
            this.fVx.setVisibility(8);
            if (dVar != null && dVar.xO() != null && dVar.xO().xM() == 0 && this.fOv) {
                if (bjq) {
                    this.fVL.setVisibility(0);
                    return;
                } else {
                    this.fVL.setVisibility(8);
                    return;
                }
            }
            this.fVL.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.beD() != null) {
            return dVar.beD();
        }
        if (!com.baidu.tbadk.core.util.v.I(dVar.bev())) {
            Iterator<PostData> it = dVar.bev().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bBx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.beA();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.yC() != null && postData.yC().getUserTbVipInfoData() != null && postData.yC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.yC().getGodUserData().setIntro(postData.yC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bet() == null || dVar.bet().yC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yC = dVar.bet().yC();
        String userId = yC.getUserId();
        HashMap<String, MetaData> userMap = dVar.bet().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yC;
        }
        postData.uZ(1);
        postData.setId(dVar.bet().yT());
        postData.setTitle(dVar.bet().getTitle());
        postData.setTime(dVar.bet().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0607 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x07bb  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0814  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0347  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String d;
        ArrayList<IconData> tShowInfoNew;
        int h;
        com.baidu.tbadk.data.f bBA;
        String portrait;
        if (dVar != null && dVar.bet() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fVn.setVisibility(8);
            if (dVar.bet() != null && dVar.bet().zq() && dVar.bet().yU() != null) {
                this.fXb = true;
                this.fVd.lG(this.fXb);
                this.fVd.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1")) {
                    LinearLayout linearLayout = (LinearLayout) this.fOe.findViewById(e.g.pb_comment_container);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.bottomMargin = fWJ;
                    linearLayout.setLayoutParams(layoutParams);
                }
                if (this.fUX == null) {
                    this.fUX = new com.baidu.tieba.pb.video.i(this.fOe, this.fVd, dVar.bet().yU(), this.fUY);
                    this.fUX.a(dVar.bet().yU(), dVar.bet(), dVar.getForumId());
                    this.fUX.startPlay();
                } else if (this.fVb) {
                    this.fUX.a(dVar.bet().yU(), dVar.bet(), dVar.getForumId());
                    this.fUX.startPlay();
                } else {
                    this.fUX.sQ(dVar.getForumId());
                }
                if (dVar.beu() != null && dVar.beu().size() >= 1) {
                    bb bbVar = dVar.beu().get(0);
                    this.fUX.as(bbVar);
                    this.fUX.sR(bbVar.getTitle());
                }
                this.fUX.b(b, dVar.bet(), dVar.beR());
                this.fVb = false;
                this.fVh.removeHeaderView(this.fUX.blE());
                this.fVh.addHeaderView(this.fUX.blE(), 0);
                if (this.fUX.blB() != null && this.fUX.blB().getParent() == null) {
                    this.fWF.addView(this.fUX.blB());
                }
                if (this.fUZ == null) {
                    this.fUZ = new com.baidu.tieba.pb.video.h(this.fOe);
                }
                this.fUZ.a(dVar.bet().zF(), dVar.bet(), dVar.beO());
                this.fVh.removeHeaderView(this.fUZ.bls());
                this.fVh.addHeaderView(this.fUZ.bls(), 1);
                if (dVar.bet().zF() != null) {
                    this.fVh.removeHeaderView(this.fUZ.blt());
                    this.fVh.removeHeaderView(this.fVl);
                    this.fVh.addHeaderView(this.fUZ.blt(), 2);
                } else {
                    if (this.fUZ.blt() != null) {
                        this.fVh.removeHeaderView(this.fUZ.blt());
                    }
                    this.fVh.removeHeaderView(this.fVl);
                    this.fVl.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fOe, e.C0200e.tbds26));
                    this.fVh.addHeaderView(this.fVl, 2);
                }
                if (this.fUX != null) {
                    this.fVd.lA(false);
                    this.fVd.lC(TbadkCoreApplication.isLogin());
                    this.fUX.sl(TbadkCoreApplication.getInst().getSkinType());
                }
                bjn();
            } else {
                this.fXb = false;
                this.fVd.lG(this.fXb);
                if (this.fUX != null) {
                    this.fVh.removeHeaderView(this.fUX.blE());
                }
                if (this.fUZ != null) {
                    this.fUZ.b(this.fVh);
                }
                if (b == null || (b != null && (b.bBz() == null || com.baidu.tbadk.core.util.v.I(b.bBz().QT())))) {
                    this.fVl.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fOe, e.C0200e.tbds52));
                } else {
                    this.fVl.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fOe.bfN() != null) {
                this.fOe.bfN().ly(this.fXb);
            }
            if (this.fUX != null) {
                this.fUX.N(this.fXD);
                bjO();
            }
            if (b != null) {
                this.fWx = b;
                this.fVn.setVisibility(0);
                if (this.fOe.bfn()) {
                    if (dVar.bes() != null) {
                        this.mForumName = dVar.bes().getForumName();
                        this.mForumId = dVar.bes().getForumId();
                    }
                    if (this.mForumName == null && this.fOe.bfx() != null && this.fOe.bfx().bfo() != null) {
                        this.mForumName = this.fOe.bfx().bfo();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fVn.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fVn.setTag(sparseArray);
                }
                sparseArray.put(e.g.tag_clip_board, b);
                sparseArray.put(e.g.tag_is_subpb, false);
                if (!this.fXs) {
                    this.fVj.setVisibility(0);
                }
                if (!dVar.bet().zq() && this.fVk.getText() != null && this.fVk.getText().length() > 0) {
                    this.fVk.setVisibility(0);
                } else {
                    this.fVk.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> yO = dVar.bet().yO();
                if (yO != null && yO.size() > 0 && !this.fXs) {
                    this.fWA.setText(String.valueOf(yO.get(0).wW()));
                    this.fWz.setVisibility(0);
                } else {
                    this.fWz.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.fWz, e.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.fWA, e.d.cp_link_tip_d, 1);
                if (b.yC() != null) {
                    String string = b.yC().getName_show() == null ? StringUtils.string(b.yC().getUserName()) : StringUtils.string(b.yC().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.yC().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bz(b.yC().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bz(string) > 12) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.yC().getIconInfo();
                            tShowInfoNew = b.yC().getTShowInfoNew();
                            if (this.fPp != null) {
                                this.fPp.setTag(e.g.tag_user_id, b.yC().getUserId());
                                this.fPp.setOnClickListener(this.fOe.fMi.fZv);
                                this.fPp.a(iconInfo, 4, this.fOe.getResources().getDimensionPixelSize(e.C0200e.tbds36), this.fOe.getResources().getDimensionPixelSize(e.C0200e.tbds36), this.fOe.getResources().getDimensionPixelSize(e.C0200e.tbds12));
                            }
                            if (this.fPo != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fPo.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fPo.setOnClickListener(this.fOe.fMi.fZw);
                                this.fPo.a(tShowInfoNew, 3, this.fOe.getResources().getDimensionPixelSize(e.C0200e.tbds36), this.fOe.getResources().getDimensionPixelSize(e.C0200e.tbds36), this.fOe.getResources().getDimensionPixelSize(e.C0200e.ds12), true);
                            }
                            this.fVp.setText(aB(b.yC().getSealPrefix(), d));
                            this.fVp.setTag(e.g.tag_user_id, b.yC().getUserId());
                            this.fVp.setTag(e.g.tag_user_name, b.yC().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew) || b.yC().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.fVp, e.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.fVp, e.d.cp_cont_f, 1);
                            }
                            this.fVq.setVisibility(8);
                            if (dVar.bet().yC() != null && dVar.bet().yC().getAlaUserData() != null && this.fVv != null) {
                                if (dVar.bet().yC().getAlaUserData().anchor_live != 0) {
                                    this.fVv.setVisibility(8);
                                } else {
                                    this.fVv.setVisibility(0);
                                    if (this.fVa == null) {
                                        this.fVa = new com.baidu.tieba.c.d(this.fOe.getPageContext(), this.fVv);
                                        this.fVa.kG(1);
                                    }
                                    this.fVa.bj(this.fOe.getResources().getString(e.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aig = dVar.bet().yC().getAlaUserData();
                                    aVar.type = 2;
                                    this.fVv.setTag(aVar);
                                }
                            }
                            this.fVu.setUserId(b.yC().getUserId());
                            this.fVu.setUserName(b.yC().getUserName());
                            this.fVu.setTid(b.getId());
                            this.fVu.setFid(this.fRE == null ? this.fRE.getForumId() : "");
                            this.fVu.setImageDrawable(null);
                            this.fVu.setRadius(com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds40));
                            this.fVu.setTag(b.yC().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                                this.fVD.setText(com.baidu.tbadk.core.util.ao.G(b.getTime()));
                            } else {
                                this.fVD.setText(com.baidu.tbadk.core.util.ao.E(b.getTime()));
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds16);
                            if (!this.fOe.bfn() && !StringUtils.isNull(this.mForumName)) {
                                this.aGH.setText(this.fOe.getString(e.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.aGH.setVisibility(0);
                                this.fVG.setVisibility(0);
                                this.fVD.setPadding(h, 0, h, 0);
                            } else {
                                this.aGH.setVisibility(8);
                                this.fVG.setVisibility(8);
                                this.fVD.setPadding(0, 0, h, 0);
                            }
                            bBA = b.bBA();
                            if (bBA == null && !TextUtils.isEmpty(bBA.getName()) && !TextUtils.isEmpty(bBA.getName().trim())) {
                                final String name = bBA.getName();
                                final String lat = bBA.getLat();
                                final String lng = bBA.getLng();
                                this.fVE.setVisibility(0);
                                this.fVF.setVisibility(0);
                                this.fVE.setText(bBA.getName());
                                this.fVE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                ar.this.fOe.showToast(e.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ac(ar.this.fOe.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, ar.this.fOe.getPageContext().getString(e.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fVE.setVisibility(8);
                                this.fVF.setVisibility(8);
                            }
                            portrait = b.yC().getPortrait();
                            if (b.yC().getPendantData() == null && !StringUtils.isNull(b.yC().getPendantData().xn())) {
                                this.fVs.b(b.yC());
                                this.fVu.setVisibility(8);
                                this.fVs.setVisibility(0);
                                if (this.fVy != null) {
                                    this.fVy.setVisibility(8);
                                }
                                this.fVp.setOnClickListener(this.fXD);
                                this.fVs.getHeadView().startLoad(portrait, 28, false);
                                this.fVs.getHeadView().setUserId(b.yC().getUserId());
                                this.fVs.getHeadView().setUserName(b.yC().getUserName());
                                this.fVs.getHeadView().setTid(b.getId());
                                this.fVs.getHeadView().setFid(this.fRE != null ? this.fRE.getForumId() : "");
                                this.fVs.getHeadView().setOnClickListener(this.fXD);
                                this.fVs.fT(b.yC().getPendantData().xn());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fVu, b.yC());
                                this.fVu.setVisibility(0);
                                this.fVn.setOnClickListener(this.fXD);
                                this.fVp.setOnClickListener(this.fXD);
                                this.fVu.setOnClickListener(this.fXD);
                                this.fVs.setVisibility(8);
                                this.fVu.startLoad(portrait, 28, false);
                            }
                            String name_show = b.yC().getName_show();
                            String userName = b.yC().getUserName();
                            if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                                this.fVp.setText(com.baidu.tieba.pb.c.aB(this.fOe.getPageContext().getPageActivity(), this.fVp.getText().toString()));
                                this.fVp.setGravity(16);
                                this.fVp.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bec());
                                com.baidu.tbadk.core.util.al.c(this.fVp, e.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.yC().getIconInfo();
                        tShowInfoNew = b.yC().getTShowInfoNew();
                        if (this.fPp != null) {
                        }
                        if (this.fPo != null) {
                        }
                        this.fVp.setText(aB(b.yC().getSealPrefix(), d));
                        this.fVp.setTag(e.g.tag_user_id, b.yC().getUserId());
                        this.fVp.setTag(e.g.tag_user_name, b.yC().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fVp, e.d.cp_cont_h, 1);
                        this.fVq.setVisibility(8);
                        if (dVar.bet().yC() != null) {
                            if (dVar.bet().yC().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fVu.setUserId(b.yC().getUserId());
                        this.fVu.setUserName(b.yC().getUserName());
                        this.fVu.setTid(b.getId());
                        this.fVu.setFid(this.fRE == null ? this.fRE.getForumId() : "");
                        this.fVu.setImageDrawable(null);
                        this.fVu.setRadius(com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds40));
                        this.fVu.setTag(b.yC().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds16);
                        if (!this.fOe.bfn()) {
                        }
                        this.aGH.setVisibility(8);
                        this.fVG.setVisibility(8);
                        this.fVD.setPadding(0, 0, h, 0);
                        bBA = b.bBA();
                        if (bBA == null) {
                        }
                        this.fVE.setVisibility(8);
                        this.fVF.setVisibility(8);
                        portrait = b.yC().getPortrait();
                        if (b.yC().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fVu, b.yC());
                        this.fVu.setVisibility(0);
                        this.fVn.setOnClickListener(this.fXD);
                        this.fVp.setOnClickListener(this.fXD);
                        this.fVu.setOnClickListener(this.fXD);
                        this.fVs.setVisibility(8);
                        this.fVu.startLoad(portrait, 28, false);
                        String name_show2 = b.yC().getName_show();
                        String userName2 = b.yC().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                            this.fVp.setText(com.baidu.tieba.pb.c.aB(this.fOe.getPageContext().getPageActivity(), this.fVp.getText().toString()));
                            this.fVp.setGravity(16);
                            this.fVp.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bec());
                            com.baidu.tbadk.core.util.al.c(this.fVp, e.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.yC().getIconInfo();
                            tShowInfoNew = b.yC().getTShowInfoNew();
                            if (this.fPp != null) {
                            }
                            if (this.fPo != null) {
                            }
                            this.fVp.setText(aB(b.yC().getSealPrefix(), d));
                            this.fVp.setTag(e.g.tag_user_id, b.yC().getUserId());
                            this.fVp.setTag(e.g.tag_user_name, b.yC().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.fVp, e.d.cp_cont_h, 1);
                            this.fVq.setVisibility(8);
                            if (dVar.bet().yC() != null) {
                            }
                            this.fVu.setUserId(b.yC().getUserId());
                            this.fVu.setUserName(b.yC().getUserName());
                            this.fVu.setTid(b.getId());
                            this.fVu.setFid(this.fRE == null ? this.fRE.getForumId() : "");
                            this.fVu.setImageDrawable(null);
                            this.fVu.setRadius(com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds40));
                            this.fVu.setTag(b.yC().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds16);
                            if (!this.fOe.bfn()) {
                            }
                            this.aGH.setVisibility(8);
                            this.fVG.setVisibility(8);
                            this.fVD.setPadding(0, 0, h, 0);
                            bBA = b.bBA();
                            if (bBA == null) {
                            }
                            this.fVE.setVisibility(8);
                            this.fVF.setVisibility(8);
                            portrait = b.yC().getPortrait();
                            if (b.yC().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fVu, b.yC());
                            this.fVu.setVisibility(0);
                            this.fVn.setOnClickListener(this.fXD);
                            this.fVp.setOnClickListener(this.fXD);
                            this.fVu.setOnClickListener(this.fXD);
                            this.fVs.setVisibility(8);
                            this.fVu.startLoad(portrait, 28, false);
                            String name_show22 = b.yC().getName_show();
                            String userName22 = b.yC().getUserName();
                            if (com.baidu.tbadk.p.an.jJ()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.yC().getIconInfo();
                        tShowInfoNew = b.yC().getTShowInfoNew();
                        if (this.fPp != null) {
                        }
                        if (this.fPo != null) {
                        }
                        this.fVp.setText(aB(b.yC().getSealPrefix(), d));
                        this.fVp.setTag(e.g.tag_user_id, b.yC().getUserId());
                        this.fVp.setTag(e.g.tag_user_name, b.yC().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fVp, e.d.cp_cont_h, 1);
                        this.fVq.setVisibility(8);
                        if (dVar.bet().yC() != null) {
                        }
                        this.fVu.setUserId(b.yC().getUserId());
                        this.fVu.setUserName(b.yC().getUserName());
                        this.fVu.setTid(b.getId());
                        this.fVu.setFid(this.fRE == null ? this.fRE.getForumId() : "");
                        this.fVu.setImageDrawable(null);
                        this.fVu.setRadius(com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds40));
                        this.fVu.setTag(b.yC().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fOe.getActivity(), e.C0200e.ds16);
                        if (!this.fOe.bfn()) {
                        }
                        this.aGH.setVisibility(8);
                        this.fVG.setVisibility(8);
                        this.fVD.setPadding(0, 0, h, 0);
                        bBA = b.bBA();
                        if (bBA == null) {
                        }
                        this.fVE.setVisibility(8);
                        this.fVF.setVisibility(8);
                        portrait = b.yC().getPortrait();
                        if (b.yC().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fVu, b.yC());
                        this.fVu.setVisibility(0);
                        this.fVn.setOnClickListener(this.fXD);
                        this.fVp.setOnClickListener(this.fXD);
                        this.fVu.setOnClickListener(this.fXD);
                        this.fVs.setVisibility(8);
                        this.fVu.startLoad(portrait, 28, false);
                        String name_show222 = b.yC().getName_show();
                        String userName222 = b.yC().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fVm.ak(dVar.bet());
                }
                if (this.fWI != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fJO);
                    if (dVar != null && dVar.bet() != null) {
                        hVar.fJQ = dVar.bet().yt();
                    }
                    hVar.isNew = !this.fOv;
                    hVar.sortType = dVar.fJF;
                    if (dVar.fJE != null && dVar.fJE.size() > dVar.fJF) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.fJE.size()) {
                                break;
                            } else if (dVar.fJE.get(i4).sort_type.intValue() != dVar.fJF) {
                                i3 = i4 + 1;
                            } else {
                                hVar.fJS = dVar.fJE.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.fJT = this.fOe.bgz();
                    this.fWI.a(hVar);
                }
            }
        }
    }

    public void lk(boolean z) {
        if (z) {
            bjk();
        } else {
            atH();
        }
        this.fWM.fXV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fWM));
        a(this.fWM.fXV, false);
    }

    public void bjk() {
        if (this.fVd != null && !this.fXd) {
            this.fVd.lH(!StringUtils.isNull(this.fOe.bfY()));
            this.fXd = true;
        }
    }

    public void atH() {
        if (this.fVd != null) {
            this.fVd.bku();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.yY() != null) {
            this.fVo.setData(this.fOe.getPageContext(), dVar.bev().get(0).yY(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.ber().getId(), dVar.ber().getName(), dVar.bet().getId(), this.fOe.bgw() ? "FRS" : null));
            this.fVn.setPadding(this.fVn.getPaddingLeft(), (int) this.fOe.getResources().getDimension(e.C0200e.ds20), this.fVn.getPaddingRight(), this.fVn.getPaddingBottom());
            return;
        }
        this.fVo.setData(null, null, null);
    }

    public void bjl() {
        if (this.fUX != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").x("obj_type", 1));
            this.fUX.blC();
            this.fVh.smoothScrollToPosition(0);
        }
    }

    public boolean bjm() {
        return this.fXE;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.yC() == null || bbVar.yC().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.yC().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fVd.bks();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fVd.qs(cVar.forumName);
            }
            String string = this.fOe.getResources().getString(e.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.fOe.getResources().getString(e.j.self);
                    break;
                case 300:
                    str = this.fOe.getResources().getString(e.j.bawu);
                    break;
                case 400:
                    str = this.fOe.getResources().getString(e.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fIW;
            this.fOe.showNetRefreshView(this.dhJ, format, null, this.fOe.getResources().getString(e.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lm()) {
                        ay.Db().c(ar.this.fOe.getPageContext(), new String[]{str2});
                        ar.this.fOe.finish();
                        return;
                    }
                    ar.this.fOe.showToast(e.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable biv;
        Parcelable biv2;
        String str;
        if (dVar != null) {
            this.fRE = dVar;
            this.mType = i;
            if (dVar.bet() != null) {
                this.fWO = dVar.bet().yl();
                if (dVar.bet().getAnchorLevel() != 0) {
                    this.fXE = true;
                }
                this.fWk = am(dVar.bet());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fWy = false;
            this.fOv = z;
            bjg();
            b(dVar, z, i);
            p(dVar);
            if (this.fXq == null) {
                this.fXq = new ac(this.fOe.getPageContext(), this.dXG);
            }
            this.fXq.sx(dVar.bey());
            if (this.fOe.bgn()) {
                if (this.fVS == null) {
                    this.fVS = new com.baidu.tieba.pb.view.d(this.fOe.getPageContext());
                    this.fVS.oE();
                    this.fVS.a(this.aFe);
                }
                this.fVh.setPullRefresh(this.fVS);
                bjn();
                if (this.fVS != null) {
                    this.fVS.ek(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.xO().xM() == 0 && z) {
                this.fVh.setPullRefresh(null);
            } else {
                if (this.fVS == null) {
                    this.fVS = new com.baidu.tieba.pb.view.d(this.fOe.getPageContext());
                    this.fVS.oE();
                    this.fVS.a(this.aFe);
                }
                this.fVh.setPullRefresh(this.fVS);
                bjn();
                if (this.fVS != null) {
                    this.fVS.ek(TbadkCoreApplication.getInst().getSkinType());
                }
                ajH();
            }
            bjq();
            this.fVO.kx(this.fOv);
            this.fVO.ky(false);
            this.fVO.kJ(i == 5);
            this.fVO.kK(i == 6);
            this.fVO.kL(z2 && this.fXC);
            this.fVO.a(dVar, false);
            this.fVO.notifyDataSetChanged();
            if (this.fOe.bfn()) {
                this.fXf = 0;
                PostData b = b(dVar, z);
                if (b != null && b.yC() != null) {
                    this.fXf = b.yC().getLevel_id();
                }
                if (this.fXf > 0) {
                    this.fVr.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.fVr, BitmapHelper.getGradeResourceIdInEnterForum(this.fXf));
                } else {
                    this.fVr.setVisibility(8);
                }
            } else {
                this.fVr.setVisibility(8);
            }
            if (dVar.bet() != null) {
                if (dVar.bet().yp() != null) {
                    if (dVar.bet().yp().getNum() < 1) {
                        str = this.fOe.getResources().getString(e.j.zan);
                    } else {
                        str = dVar.bet().yp().getNum() + "";
                    }
                    if (this.fUW != -1) {
                        dVar.bet().yp().setIsLike(this.fUW);
                    }
                    U(str, dVar.bet().yp().getIsLike() == 1);
                }
                if (dVar.bet().arT != null && dVar.bet().arT.isDeleted) {
                    this.fVd.lB(true);
                } else {
                    this.fVd.lB(false);
                }
            }
            if (this.fOe.isLogin()) {
                this.fVh.setNextPage(this.dHf);
                this.fVc = 2;
                ajH();
            } else {
                this.fWy = true;
                if (dVar.xO().xL() == 1) {
                    if (this.fVT == null) {
                        this.fVT = new com.baidu.tieba.pb.view.a(this.fOe.getPageContext());
                    }
                    this.fVh.setNextPage(this.fVT);
                } else {
                    this.fVh.setNextPage(this.dHf);
                }
                this.fVc = 3;
            }
            ArrayList<PostData> bev = dVar.bev();
            if (dVar.xO().xL() == 0 || bev == null || bev.size() < dVar.xO().xK()) {
                if (com.baidu.tbadk.core.util.v.H(bev) == 0 || (com.baidu.tbadk.core.util.v.H(bev) == 1 && bev.get(0) != null && bev.get(0).bBx() == 1)) {
                    this.dHf.setText(this.fOe.getResources().getString(e.j.list_no_more_new));
                    if (this.fOe.bfN() != null && !this.fOe.bfN().bki()) {
                        this.fOe.bfN().showFloatingView();
                    }
                } else if (dVar.xO().xL() == 0) {
                    this.dHf.setText(this.fOe.getResources().getString(e.j.list_has_no_more));
                } else {
                    this.dHf.setText(this.fOe.getResources().getString(e.j.load_more));
                }
                if (this.fOe.bgn() && this.fVh != null && this.fVh.getData() != null && this.fVh.getData().size() == 1 && (this.fVh.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dHf.setText("");
                }
                bjx();
            } else if (z2) {
                if (this.fXC) {
                    DZ();
                    if (dVar.xO().xL() != 0) {
                        this.dHf.setText(this.fOe.getResources().getString(e.j.pb_load_more));
                    }
                } else {
                    this.dHf.DU();
                    this.dHf.showLoading();
                }
            } else {
                this.dHf.DU();
                this.dHf.showLoading();
            }
            switch (i) {
                case 2:
                    this.fVh.setSelection(i2 > 1 ? (((this.fVh.getData() == null && dVar.bev() == null) ? 0 : (this.fVh.getData().size() - dVar.bev().size()) + this.fVh.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (biv2 = aj.biu().biv()) != null) {
                        this.fVh.onRestoreInstanceState(biv2);
                        if (com.baidu.tbadk.core.util.v.H(bev) > 1 && dVar.xO().xL() > 0) {
                            this.dHf.DZ();
                            this.dHf.setText(this.fOe.getString(e.j.pb_load_more_without_point));
                            this.dHf.DV();
                            break;
                        }
                    } else {
                        this.fVh.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fXC = false;
                    break;
                case 5:
                    this.fVh.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (biv = aj.biu().biv()) != null) {
                        this.fVh.onRestoreInstanceState(biv);
                        break;
                    } else {
                        this.fVh.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.fUX != null && this.fUX.blB() != null) {
                            if (this.fOe.isUseStyleImmersiveSticky()) {
                                this.fVh.setSelectionFromTop((this.fVO.bgR() + this.fVh.getHeaderViewsCount()) - 1, this.fUX.blB().getHeight() - com.baidu.adp.lib.util.l.r(this.fOe.getPageContext().getPageActivity()));
                            } else {
                                this.fVh.setSelectionFromTop((this.fVO.bgR() + this.fVh.getHeaderViewsCount()) - 1, this.fUX.blB().getHeight());
                            }
                        } else {
                            this.fVh.setSelection(this.fVO.bgR() + this.fVh.getHeaderViewsCount());
                        }
                    } else {
                        this.fVh.setSelection(i2 > 0 ? ((this.fVh.getData() == null && dVar.bev() == null) ? 0 : (this.fVh.getData().size() - dVar.bev().size()) + this.fVh.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dHf.DZ();
                    this.dHf.setText(this.fOe.getString(e.j.pb_load_more_without_point));
                    this.dHf.DV();
                    break;
            }
            if (this.fWO == fWP && isHost()) {
                bjF();
            }
            if (this.fWZ) {
                biE();
                this.fWZ = false;
                if (i3 == 0) {
                    ld(true);
                }
            }
            if (this.fUZ != null) {
                this.fUZ.ar(dVar.bet());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fJC == 1 || dVar.fJD == 1) {
                if (this.fXg == null) {
                    this.fXg = new PbTopTipView(this.fOe);
                }
                if (dVar.fJD == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fOe.getStType())) {
                    this.fXg.setText(this.fOe.getString(e.j.pb_read_strategy_add_experience));
                    this.fXg.show(this.dhJ, this.mSkinType);
                } else if (dVar.fJC == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fOe.getStType())) {
                    this.fXg.setText(this.fOe.getString(e.j.pb_read_news_add_experience));
                    this.fXg.show(this.dhJ, this.mSkinType);
                }
            }
        }
    }

    private void bjn() {
        if (this.fUX != null && this.fUX.blB() != null) {
            this.fVh.removeHeaderView(this.aQZ);
            if (this.mType != 1) {
                this.fVh.removeHeaderView(this.fUX.blE());
                this.fVh.addHeaderView(this.fUX.blE(), 0);
                return;
            }
            return;
        }
        if (this.fUX != null) {
            this.fVh.removeHeaderView(this.fUX.blE());
        }
        this.fVh.removeHeaderView(this.aQZ);
        this.fVh.addHeaderView(this.aQZ, 0);
    }

    public void ll(boolean z) {
        this.fWj = z;
    }

    public void DZ() {
        if (this.dHf != null) {
            this.dHf.DV();
            this.dHf.DZ();
        }
        ajH();
    }

    public void alG() {
        this.fVh.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fWx != null && this.fWx.yC() != null && this.fVd != null) {
            this.fXc = !this.fXb;
            this.fVd.lA(this.fXc);
            if (this.fOe.bfN() != null) {
                this.fOe.bfN().lz(this.fXc);
            }
            bjo();
            if (this.fXc) {
                this.fVd.gai.setVisibility(0);
                if (this.fWk) {
                    this.fVd.gaj.setVisibility(8);
                    this.fVz.setVisibility(8);
                    this.fVC.setVisibility(0);
                    this.fVC.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.L(dVar.beQ())));
                } else if (!PbNormalLikeButtonSwitchStatic.Oy() || (this.fWx.yC().hadConcerned() && this.fWx.yC().getGodUserData() != null && this.fWx.yC().getGodUserData().getIsFromNetWork())) {
                    this.fVd.gaj.setVisibility(8);
                }
                if (this.fWH != null) {
                    this.fWH.setVisibility(8);
                }
                this.fVd.a(this.fWx.yC(), this.fXD);
                if (this.fXo == null) {
                    this.fXo = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fXe) {
                                ar.this.bjE();
                            }
                            ar.this.bjh();
                        }
                    };
                }
                this.fVh.setListViewDragListener(this.fXo);
                return;
            }
            if (this.fVd.gai != null) {
                this.fVd.gai.setVisibility(8);
            }
            if (this.fWH != null) {
                this.fWH.setVisibility(0);
            }
            if (this.fWk) {
                this.fVz.setVisibility(8);
                this.fVC.setVisibility(0);
                this.fVC.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.L(dVar.beQ())));
            } else if (!PbNormalLikeButtonSwitchStatic.Oy() || (this.fWx.yC().hadConcerned() && this.fWx.yC().getGodUserData() != null && this.fWx.yC().getGodUserData().getIsFromNetWork())) {
                this.fVz.setVisibility(8);
                this.fVC.setVisibility(8);
            } else {
                this.fVC.setVisibility(8);
            }
            this.fXo = null;
            this.fVh.setListViewDragListener(null);
        }
    }

    private void bjo() {
        String threadId = this.fRE != null ? this.fRE.getThreadId() : "";
        int bjp = bjp();
        if (this.fXc) {
            if (this.fVB == null) {
                this.fVB = new ap(this.fOe.getPageContext(), this.fVd.gaj, 3);
                this.fVB.h(this.fOe.getUniqueId());
            }
            if (this.fWx != null && this.fWx.yC() != null) {
                this.fWx.yC().setIsLike(this.fWx.yC().hadConcerned());
                this.fVB.a(this.fWx.yC());
            }
            this.fVB.setTid(threadId);
            this.fVB.sd(bjp);
            this.fVB.fUS = this.fXb;
        }
        if (this.fVA == null) {
            this.fVA = new ap(this.fOe.getPageContext(), this.fVz, 1);
            this.fVA.h(this.fOe.getUniqueId());
            this.fVA.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bK(boolean z) {
                    if (ar.this.fOe != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fOe, e.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fOe.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fWx != null && this.fWx.yC() != null) {
            this.fWx.yC().setIsLike(this.fWx.yC().hadConcerned());
            this.fVA.a(this.fWx.yC());
            this.fVA.setTid(threadId);
        }
        this.fVA.fUS = this.fXb;
        this.fVA.sd(bjp);
    }

    public int bjp() {
        if (this.fRE == null || this.fRE.bet() == null) {
            return 0;
        }
        if (this.fRE.bet().zN()) {
            return (com.baidu.tbadk.core.util.v.I(this.fRE.beP()) && (this.fRE.bes() == null || StringUtils.isNull(this.fRE.bes().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bjq() {
        boolean z;
        if (this.fWn != null && this.fWn.getVisibility() == 0) {
            if (this.fVK != null) {
                this.fVK.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fVK != null) {
                this.fVK.setVisibility(8);
            }
            z = false;
        }
        if ((this.fVM == null || this.fVM.getVisibility() == 8) && z && this.fOv) {
            this.fVL.setVisibility(0);
        } else {
            this.fVL.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bet() == null) {
            return false;
        }
        if (dVar.bet().yz() == 1 || dVar.bet().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bet().yB() == null || dVar.bet().yB().Ap() == 0) || dVar.bet().yx() == 1 || dVar.bet().yy() == 1 || dVar.bet().zh() || dVar.bet().zu() || dVar.bet().zp() || dVar.bet().yP() != null || !com.baidu.tbadk.core.util.ao.isEmpty(dVar.bet().getCategory()) || dVar.bet().yF() || dVar.bet().yE();
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fOe.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fVj != null) {
                if (dVar.bet() != null && dVar.bet().yS() == 0 && !dVar.bet().zq() && !this.fXs) {
                    this.fVj.setVisibility(0);
                    if (dVar.bet() != null) {
                        bb bet = dVar.bet();
                        bet.g(true, q(dVar));
                        bet.setResource(3);
                        bet.dT("2");
                    }
                    SpannableStringBuilder zc = dVar.bet().zc();
                    this.fVk.setOnTouchListener(new com.baidu.tieba.view.k(zc));
                    this.fVk.setText(zc);
                    this.fVk.setVisibility(0);
                } else if (dVar.bet().yS() == 1) {
                    if (dVar.bet() != null) {
                        this.fVj.setVisibility(8);
                        this.fVh.removeHeaderView(this.fVj);
                        if (dVar.bet() != null && !dVar.bet().zq()) {
                            this.fVn.setPadding(this.fVn.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.tbds36), this.fVn.getPaddingRight(), this.fVn.getPaddingBottom());
                        }
                    }
                } else {
                    this.fVj.setVisibility(8);
                    this.fVh.removeHeaderView(this.fVj);
                    if (dVar.bet() != null && dVar.bet().zq()) {
                        this.fVn.setPadding(this.fVn.getPaddingLeft(), 0, this.fVn.getPaddingRight(), this.fVn.getPaddingBottom());
                    } else {
                        this.fVn.setPadding(this.fVn.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds48), this.fVn.getPaddingRight(), this.fVn.getPaddingBottom());
                    }
                }
            }
            this.fOv = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bjq();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.yC().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.beF()));
                sparseArray.put(e.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.yC() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, b.yC().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, b.yC().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, b.yC().getPortrait());
                    sparseArray.put(e.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.beF()));
                sparseArray.put(e.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.ay> beP = dVar.beP();
                if (com.baidu.tbadk.core.util.v.H(beP) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.ay ayVar : beP) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.apA) != null && tVar.anz && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(this.fOe.getString(e.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(e.g.tag_del_multi_forum, String.format(this.fOe.getString(e.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bbH;
    }

    public void sy(String str) {
        if (this.dHf != null) {
            this.dHf.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fVh;
    }

    public int bjr() {
        return e.g.richText;
    }

    public TextView bfI() {
        return this.fVm.bfI();
    }

    public void e(BdListView.e eVar) {
        this.fVh.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.aFe = bVar;
        if (this.fVS != null) {
            this.fVS.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int xJ = alVar.xJ();
            int xG = alVar.xG();
            if (this.fVP != null) {
                this.fVP.AB();
            } else {
                this.fVP = new com.baidu.tbadk.core.dialog.a(this.fOe.getPageContext().getPageActivity());
                this.fVQ = LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.dialog_direct_pager, (ViewGroup) null);
                this.fVP.G(this.fVQ);
                this.fVP.a(e.j.dialog_ok, bVar);
                this.fVP.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bjt();
                        aVar.dismiss();
                    }
                });
                this.fVP.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fWW == null) {
                            ar.this.fWW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fOe.HidenSoftKeyPad((InputMethodManager) ar.this.fOe.getSystemService("input_method"), ar.this.dhJ);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jG().postDelayed(ar.this.fWW, 150L);
                    }
                });
                this.fVP.b(this.fOe.getPageContext()).AB();
            }
            this.fVR = (EditText) this.fVQ.findViewById(e.g.input_page_number);
            this.fVR.setText("");
            TextView textView = (TextView) this.fVQ.findViewById(e.g.current_page_number);
            if (xJ <= 0) {
                xJ = 1;
            }
            if (xG <= 0) {
                xG = 1;
            }
            textView.setText(MessageFormat.format(this.fOe.getApplicationContext().getResources().getString(e.j.current_page), Integer.valueOf(xJ), Integer.valueOf(xG)));
            this.fOe.ShowSoftKeyPadDelay(this.fVR, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fVh.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fOe.showToast(str);
    }

    public boolean lm(boolean z) {
        if (this.Ta == null || !this.Ta.KW()) {
            return false;
        }
        this.Ta.Js();
        return true;
    }

    public void bjs() {
        if (this.fXF != null) {
            while (this.fXF.size() > 0) {
                TbImageView remove = this.fXF.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bjs();
        this.fVO.rO(1);
        if (this.fUX != null) {
            this.fUX.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.fVO.rO(2);
        if (this.fUX != null) {
            this.fUX.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fWY != null) {
            this.fWY.destroy();
        }
        if (this.fXq != null) {
            this.fXq.onDestory();
        }
        if (this.fXg != null) {
            this.fXg.hide();
        }
        if (this.fVa != null) {
            this.fVa.apA();
        }
        if (this.fUZ != null) {
            this.fUZ.onDestroy();
        }
        this.fOe.hideProgressBar();
        if (this.dhH != null && this.dzq != null) {
            this.dhH.b(this.dzq);
        }
        bjt();
        DZ();
        if (this.fWW != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fWW);
        }
        if (this.fVn != null && this.fVy != null) {
            this.fVn.removeView(this.fVt);
            this.fVy = null;
        }
        if (this.fWC != null) {
            this.fWC.clearStatus();
        }
        this.fXy = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fVO.rO(3);
        if (this.dDK != null) {
            this.dDK.setBackgroundDrawable(null);
        }
        if (this.fUX != null) {
            this.fUX.destroy();
        }
        if (this.fVO != null) {
            this.fVO.onDestroy();
        }
        this.fVh.setOnLayoutListener(null);
        if (this.fXm != null) {
            this.fXm.aBt();
        }
        if (this.fWN != null) {
            this.fWN.onDestroy();
        }
        bjP();
    }

    public boolean sg(int i) {
        if (this.fUX != null) {
            return this.fUX.me(i);
        }
        return false;
    }

    public void bjt() {
        this.fVd.dismissPopMenu();
        if (this.fVa != null) {
            this.fVa.apA();
        }
        com.baidu.adp.lib.util.l.b(this.fOe.getPageContext().getPageActivity(), this.fVR);
        biG();
        if (this.fWh != null) {
            this.fWh.dismiss();
        }
        bjv();
        if (this.fUZ != null) {
            this.fUZ.blu();
        }
        if (this.fVP != null) {
            this.fVP.dismiss();
        }
        if (this.dDu != null) {
            this.dDu.dismiss();
        }
    }

    public void bju() {
        this.fVd.dismissPopMenu();
        if (this.fVa != null) {
            this.fVa.apA();
        }
        if (this.fWh != null) {
            this.fWh.dismiss();
        }
        bjv();
        if (this.fUZ != null) {
            this.fUZ.blu();
        }
        if (this.fVP != null) {
            this.fVP.dismiss();
        }
        if (this.dDu != null) {
            this.dDu.dismiss();
        }
    }

    public void dj(List<String> list) {
        this.fXl = list;
        if (this.fXm != null) {
            this.fXm.setData(list);
        }
    }

    public void kw(boolean z) {
        this.fVO.kw(z);
    }

    public void ln(boolean z) {
        this.fWm = z;
    }

    public void bjv() {
        if (this.fVY != null) {
            this.fVY.dismiss();
        }
        if (this.fVZ != null) {
            com.baidu.adp.lib.g.g.b(this.fVZ, this.fOe.getPageContext());
        }
        if (this.fWa != null) {
            com.baidu.adp.lib.g.g.b(this.fWa, this.fOe.getPageContext());
        }
        if (this.fVW != null) {
            com.baidu.adp.lib.g.g.b(this.fVW, this.fOe.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fRE, this.fOv);
            d(this.fRE, this.fOv, this.mType);
            this.fOe.getLayoutMode().setNightMode(i == 1);
            this.fOe.getLayoutMode().onModeChanged(this.dhJ);
            this.fOe.getLayoutMode().onModeChanged(this.fVi);
            if (this.fUZ != null) {
                this.fUZ.onChangeSkinType(i);
            }
            if (this.fVk != null) {
                com.baidu.tbadk.core.util.al.h(this.fVk, e.d.cp_cont_b);
                this.fVk.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            }
            if (this.dHf != null) {
                this.dHf.ek(i);
                if (this.bbH != null) {
                    this.fOe.getLayoutMode().onModeChanged(this.bbH);
                    com.baidu.tbadk.core.util.al.i(this.bbH, e.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fVP != null) {
                this.fVP.c(this.fOe.getPageContext());
            }
            ll(this.fWj);
            this.fVO.notifyDataSetChanged();
            if (this.fVS != null) {
                this.fVS.ek(i);
            }
            if (this.Ta != null) {
                this.Ta.onChangeSkinType(i);
            }
            if (this.fVx != null) {
                this.fVx.eo(i);
            }
            if (this.fVT != null) {
                this.fVT.ek(i);
            }
            if (!com.baidu.tbadk.core.util.v.I(this.cQz)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cQz) {
                    customBlueCheckRadioButton.DE();
                }
            }
            lh(i == 1);
            biV();
            UtilHelper.setStatusBarBackground(this.dDK, i);
            UtilHelper.setStatusBarBackground(this.fWH, i);
            if (this.fVz != null) {
                this.fVz.onChangeSkinType(i);
            }
            if (this.fVE != null) {
                com.baidu.tbadk.core.util.al.h(this.fVE, e.d.cp_cont_d);
            }
            if (this.fVD != null) {
                com.baidu.tbadk.core.util.al.h(this.fVD, e.d.cp_cont_d);
            }
            if (this.fVF != null) {
                com.baidu.tbadk.core.util.al.i(this.fVF, e.d.cp_cont_e);
            }
            if (this.aGH != null) {
                com.baidu.tbadk.core.util.al.h(this.aGH, e.d.cp_cont_d);
            }
            if (this.fVG != null) {
                com.baidu.tbadk.core.util.al.i(this.fVG, e.d.cp_cont_e);
            }
            if (this.fVq != null) {
                com.baidu.tbadk.core.util.al.h(this.fVq, e.d.cp_link_tip_a);
            }
            if (this.fVC != null) {
                com.baidu.tbadk.core.util.al.h(this.fVC, e.d.cp_cont_d);
            }
            if (this.fVH != null) {
                com.baidu.tbadk.o.a.a(this.fOe.getPageContext(), this.fVH);
            }
            if (this.fWf != null) {
                com.baidu.tbadk.o.a.a(this.fOe.getPageContext(), this.fWf);
            }
            if (this.fWX != null) {
                this.fWX.onChangeSkinType(i);
            }
            if (this.fVd != null) {
                if (this.fUX != null) {
                    this.fUX.sl(i);
                } else {
                    this.fVd.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fWp != null) {
                com.baidu.tbadk.core.util.al.h(this.fWp, e.d.cp_cont_e);
            }
            if (this.fVr != null) {
                com.baidu.tbadk.core.util.al.c(this.fVr, BitmapHelper.getGradeResourceIdInEnterForum(this.fXf));
            }
            if (this.fXn != null) {
                this.fXn.onChangeSkinType(i);
            }
            if (this.fWN != null) {
                this.fWN.onChangeSkinType();
            }
            if (this.fXj != null) {
                com.baidu.tbadk.core.util.al.h(this.fXj, e.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bop = hVar;
        this.fVO.setOnImageClickListener(this.bop);
        this.fXn.setOnImageClickListener(this.bop);
    }

    public void h(NoNetworkView.a aVar) {
        this.dzq = aVar;
        if (this.dhH != null) {
            this.dhH.a(this.dzq);
        }
    }

    public void lo(boolean z) {
        this.fVO.setIsFromCDN(z);
    }

    public Button bjw() {
        return this.fWn;
    }

    public void bjx() {
        if (this.fVc != 2) {
            this.fVh.setNextPage(this.dHf);
            this.fVc = 2;
        }
    }

    public void bjy() {
        if (com.baidu.tbadk.l.m.Og().Oh()) {
            int lastVisiblePosition = this.fVh.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fVh.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(e.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.fU(1001);
                                perfLog.bcm = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(e.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.l.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.fU(1001);
                        perfLog2.bcm = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bjz() {
        return this.Ta != null && this.Ta.getVisibility() == 0;
    }

    public boolean bjA() {
        return this.Ta != null && this.Ta.KW();
    }

    public void bjB() {
        if (this.Ta != null) {
            this.Ta.Js();
        }
    }

    public void lp(boolean z) {
        if (this.fWo != null) {
            ln(this.fOe.bfJ().Lz());
            if (this.fWm) {
                le(z);
            } else {
                lf(z);
            }
        }
    }

    public void bjC() {
        if (this.fWo != null) {
            this.fWo.setVisibility(8);
            this.fWt = false;
            if (this.fWN != null) {
                this.fWN.setVisibility(8);
                lj(false);
            }
            bjP();
        }
    }

    public void showLoadingDialog() {
        if (this.cXS == null) {
            this.cXS = new com.baidu.tbadk.core.view.d(this.fOe.getPageContext());
        }
        this.cXS.bz(true);
    }

    public void ajH() {
        if (this.cXS != null) {
            this.cXS.bz(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fVh.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fVh.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fUX != null) {
            this.fUX.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.fXG = getScrollY();
            this.fWM.fXV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fWM));
            a(this.fWM.fXV, true);
        }
    }

    public void lq(boolean z) {
        this.fUX.lq(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fUX != null) {
            this.fUX.b(absListView, i);
        }
        int headerViewsCount = (i - this.fVh.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (headerViewsCount <= i2 && this.fVO.rN(headerViewsCount) != com.baidu.tieba.pb.data.i.fJU) {
            headerViewsCount++;
        }
        boolean z = i < this.fVh.getHeaderViewsCount();
        if (this.fVl != null && this.fVd != null) {
            this.fVd.h(this.fVl.getBottom(), this.fVl.getMeasuredHeight(), z);
        }
        this.fWM.fEB = i;
        this.fWM.headerCount = this.fVh.getHeaderViewsCount();
        this.fWM.fXV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fWM));
        a(this.fWM.fXV, false);
    }

    public void bjD() {
        if (this.fOe.isLogin() && this.fRE != null && this.fXc && !this.fXb && !this.fWk && this.fWx != null && this.fWx.yC() != null && !this.fWx.yC().getIsLike() && !this.fWx.yC().hadConcerned()) {
            if (this.fWY == null) {
                this.fWY = new an(this.fOe);
            }
            this.fWY.a(this.fVd.gai, this.fRE.beT(), this.fWx.yC().getUserId(), this.fRE.getThreadId());
        }
    }

    public void bjE() {
        if (this.fXc && !this.fXb && this.fWx != null && this.fWx.yC() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").x("obj_locate", this.fOe.bfn() ? 2 : 1).x("obj_type", this.fXb ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fOe.getPageContext().getPageActivity(), this.fWx.yC().getUserId(), this.fWx.yC().getUserName(), this.fOe.bfx().bfo(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fXb && this.fWG != null && this.fVd.bkn() != null) {
            int bgS = this.fVO.bgS();
            if (bgS > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bgS > this.fVh.getFirstVisiblePosition() - this.fVh.getHeaderViewsCount()) {
                    this.fWG.setVisibility(8);
                    return;
                }
                this.fWG.setVisibility(0);
                bjO();
                this.fVd.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fUw == null) {
                if (this.fVh.getFirstVisiblePosition() == 0) {
                    this.fWG.setVisibility(8);
                    this.fVd.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fWL) {
                        this.fWK = top;
                        this.fWL = false;
                    }
                    this.fWK = top < this.fWK ? top : this.fWK;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fVN.getY() < 0.0f) {
                        measuredHeight = fWJ - alVar.fUw.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fVd.bkn().getMeasuredHeight() - alVar.fUw.getMeasuredHeight();
                        this.fVd.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fWK) {
                        this.fWG.setVisibility(0);
                        bjO();
                    } else if (top < measuredHeight) {
                        this.fWG.setVisibility(0);
                        bjO();
                    } else {
                        this.fWG.setVisibility(8);
                        this.fVd.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fWL = true;
                    }
                }
            }
        }
    }

    public void bjF() {
        if (!this.fXH) {
            TiebaStatic.log("c10490");
            this.fXH = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fOe.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fWQ, Integer.valueOf(fWS));
            aVar.cM(e.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.function_description_view)).setText(e.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(e.g.title_view)).setText(e.j.grade_thread_tips);
            aVar.G(inflate);
            aVar.H(sparseArray);
            aVar.a(e.j.grade_button_tips, this.fOe);
            aVar.b(e.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fOe.getPageContext()).AB();
        }
    }

    public void sz(String str) {
        if (str.contains(BaseRequestAction.SPLITE)) {
            str = str.replace(BaseRequestAction.SPLITE, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fOe.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(e.g.function_description_view)).setVisibility(8);
        aVar.G(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fWQ, Integer.valueOf(fWT));
        aVar.H(sparseArray);
        aVar.a(e.j.view, this.fOe);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fOe.getPageContext()).AB();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.yC() != null) {
            MetaData yC = b.yC();
            yC.setGiftNum(yC.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bjG() {
        return this.fWC;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bet() != null && dVar.bet().zu() && this.fWC == null) {
            this.fWC = (PbInterviewStatusView) this.fWB.inflate();
            this.fWC.setOnClickListener(this.dDv);
            this.fWC.setCallback(this.fOe.bgv());
            this.fWC.setData(this.fOe, dVar);
        }
    }

    public LinearLayout bjH() {
        return this.fVN;
    }

    public View bjI() {
        return this.dDK;
    }

    public boolean bjJ() {
        return this.fXs;
    }

    public void kB(boolean z) {
        this.fVm.kB(z);
    }

    public void sA(String str) {
        if (this.fVe != null) {
            this.fVe.setTitle(str);
        }
    }

    private int lr(boolean z) {
        if (this.fWC == null || this.fWC.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds72);
    }

    private void bjK() {
        if (this.fWC != null && this.fWC.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fWC.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fWC.setLayoutParams(layoutParams);
        }
    }

    public boolean bfP() {
        return false;
    }

    public void sB(String str) {
        this.fWp.performClick();
        if (!StringUtils.isNull(str) && this.fOe.bfJ() != null && this.fOe.bfJ().Ls() != null && this.fOe.bfJ().Ls().getInputView() != null) {
            EditText inputView = this.fOe.bfJ().Ls().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bjt();
            if (configuration.orientation == 2) {
                bjC();
                biG();
            } else {
                biJ();
            }
            if (this.fWX != null) {
                this.fWX.bgZ();
            }
            this.fOe.azo();
            this.fVN.setVisibility(8);
            this.fVd.lD(false);
            this.fOe.kH(false);
            if (this.fUX != null) {
                if (configuration.orientation == 1) {
                    bjH().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fVh.setIsLandscape(true);
                    this.fVh.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fVh.setIsLandscape(false);
                    if (this.fXG > 0) {
                        this.fVh.smoothScrollBy(this.fXG, 0);
                    }
                }
                this.fUX.onConfigurationChanged(configuration);
                this.fWF.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void ls(boolean z) {
        this.fVb = z;
    }

    public boolean bjL() {
        return this.fUX != null && this.fUX.bjL();
    }

    public void bjM() {
        if (this.fUX != null) {
            this.fUX.onPause();
        }
    }

    public void n(long j, int i) {
        if (this.fUZ != null) {
            this.fUZ.n(j, i);
        }
        if (this.fUX != null) {
            this.fUX.n(j, i);
        }
    }

    public void kM(boolean z) {
        this.fVO.kM(z);
    }

    public void bjN() {
        if (this.fWD == null) {
            LayoutInflater.from(this.fOe.getActivity()).inflate(e.h.add_experienced_text, (ViewGroup) this.dhJ, true);
            this.fWD = (ViewGroup) this.dhJ.findViewById(e.g.add_experienced_layout);
            this.fWE = (TextView) this.dhJ.findViewById(e.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.fWE, e.d.cp_cont_i);
            String string = this.fOe.getResources().getString(e.j.experienced_add_success);
            String string2 = this.fOe.getResources().getString(e.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_h)));
            this.fWE.setText(spannableString);
        }
        this.fWD.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.ar.29
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.ar.29.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        ar.this.fWD.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fWE.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fWE.startAnimation(scaleAnimation);
    }

    public void bD(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fWo.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fOe);
            frameLayout.setBackgroundResource(e.f.pic_sign_tip);
            this.fXj = new TextView(this.fOe);
            this.fXj.setText(e.j.connection_tips);
            this.fXj.setGravity(17);
            this.fXj.setPadding(com.baidu.adp.lib.util.l.h(this.fOe, e.C0200e.ds24), 0, com.baidu.adp.lib.util.l.h(this.fOe, e.C0200e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fOe, e.C0200e.ds60);
            if (this.fXj.getParent() == null) {
                frameLayout.addView(this.fXj, layoutParams);
            }
            this.fXi = new PopupWindow(this.fOe);
            this.fXi.setContentView(frameLayout);
            this.fXi.setHeight(-2);
            this.fXi.setWidth(-2);
            this.fXi.setFocusable(true);
            this.fXi.setOutsideTouchable(false);
            this.fXi.setBackgroundDrawable(new ColorDrawable(this.fOe.getResources().getColor(e.d.transparent)));
            this.fVh.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fXi.showAsDropDown(ar.this.fWo, view.getLeft(), -ar.this.fWo.getHeight());
                    } else {
                        ar.this.fXi.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bjO() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.fXk == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.fXk = new com.baidu.tbadk.core.dialog.a(this.fOe);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.fOe);
            this.fXk.cP(1);
            this.fXk.G(pbLongPressTipView);
            this.fXk.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.31
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fXk.bf(false);
            this.fXk.b(this.fOe.getPageContext()).AB();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.32
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fXk != null && ar.this.fXk.isShowing()) {
                        ar.this.fXk.dismiss();
                    }
                }
            }, 5000L);
            if (this.fUX != null) {
                this.fUX.blD();
            }
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bke() != null && !StringUtils.isNull(aVar.bke().pkg_id) && !StringUtils.isNull(aVar.bke().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fWq != null && this.fWq.getVisibility() == 0) {
            if (this.fXh == null) {
                View inflate = LayoutInflater.from(this.fOe.getPageContext().getPageActivity()).inflate(e.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(e.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(e.g.single_bar_tips);
                textView.setText(e.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dDv);
                this.fXh = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fWq.getLocationInWindow(iArr);
            this.fXh.showAtLocation(this.fWq, 0, iArr[0] - com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds54), (iArr[1] - this.fWq.getHeight()) - com.baidu.adp.lib.util.l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bjP() {
        com.baidu.adp.lib.g.g.a(this.fXh);
    }

    public void lt(boolean z) {
        this.fXp = z;
    }

    public boolean bjQ() {
        return this.fXp;
    }

    public void bE(View view) {
        this.fWf = view;
    }
}
