package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbLongPressTipView;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
import tbclient.SmartApp;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class aq {
    private EditorTools TU;
    private h.c caD;
    private com.baidu.tieba.pb.a.c clt;
    private View cze;
    private List<CustomBlueCheckRadioButton> eER;
    private NoNetworkView eWV;
    private int ehD;
    private RelativeLayout euU;
    private View euX;
    private PbListView fAd;
    private NavigationBarCoverTip fSs;
    private com.baidu.tieba.NEGFeedBack.e fVl;
    private View.OnClickListener fvY;
    private View fwl;
    private TextView gmp;
    PbActivity.d hLI;
    private PbActivity hMD;
    private UserIconBox hNQ;
    private UserIconBox hNR;
    private View.OnClickListener hNc;
    private PbFakeFloorModel hOQ;
    private com.baidu.tieba.pb.data.d hPY;
    private View hTA;
    private RelativeLayout hTB;
    private HeadImageView hTC;
    private TextView hTD;
    private TextView hTE;
    private ImageView hTF;
    private RelativeLayout hTI;
    private ImageView hTJ;
    private ImageView hTK;
    private e hTL;
    private ColumnLayout hTM;
    private ThreadSkinView hTN;
    private TextView hTO;
    private TextView hTP;
    private ImageView hTQ;
    private HeadPendantView hTR;
    private FrameLayout hTS;
    private HeadImageView hTT;
    private View hTU;
    private LinearLayout hTV;
    private PbFirstFloorUserLikeButton hTY;
    private ao hTZ;
    public int hTn;
    public com.baidu.tieba.pb.video.i hTo;
    private long hTp;
    private com.baidu.tieba.pb.video.h hTq;
    private com.baidu.tieba.c.d hTr;
    public final com.baidu.tieba.pb.pb.main.view.c hTu;
    public com.baidu.tieba.pb.pb.main.view.b hTv;
    private ViewStub hTw;
    private ViewStub hTx;
    private PbLandscapeListView hTy;
    private PbThreadPostView hTz;
    private View hUL;
    private View hUM;
    private ImageView hUN;
    private ImageView hUO;
    private ImageView hUP;
    private TextView hUQ;
    private int hUS;
    private int hUT;
    private PostData hUU;
    private View hUW;
    private TextView hUX;
    private ViewStub hUY;
    private PbInterviewStatusView hUZ;
    private TextView hUa;
    private TextView hUb;
    private TextView hUc;
    private TextView hUd;
    private View hUe;
    private View hUf;
    private LinearLayout hUg;
    private TextView hUh;
    private TextView hUi;
    private View hUj;
    private View hUk;
    private ObservedChangeLinearLayout hUm;
    private f hUn;
    private View hUt;
    private int hVA;
    private PbTopTipView hVC;
    private PopupWindow hVD;
    private TextView hVE;
    private com.baidu.tbadk.core.dialog.a hVF;
    private List<String> hVG;
    private com.baidu.tieba.pb.pb.main.emotion.c hVH;
    private com.baidu.tieba.pb.pb.godreply.a hVI;
    private PbLandscapeListView.b hVJ;
    private ac hVL;
    private String hVM;
    private boolean hVP;
    private com.baidu.tbadk.core.view.userLike.c hVQ;
    private com.baidu.tbadk.core.view.userLike.c hVR;
    private Runnable hVW;
    private PbActivity.b hVY;
    private ViewGroup hVa;
    private TextView hVb;
    private FrameLayout hVc;
    private View hVd;
    private View hVe;
    private al hVf;
    private PbEmotionBar hVk;
    private Runnable hVs;
    private s hVt;
    private an hVu;
    public int hWd;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int hVg = UtilHelper.getLightStatusBarHeight();
    public static int hVm = 3;
    public static int hVn = 0;
    public static int hVo = 3;
    public static int hVp = 4;
    public static int hVq = 5;
    public static int hVr = 6;
    private static a.InterfaceC0406a hVO = new a.InterfaceC0406a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0406a
        public void onRefresh() {
        }
    };
    private boolean hTs = false;
    private int hTt = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hTG = null;
    private TextView hTH = null;
    public FrsPraiseView hTW = null;
    private ClickableHeaderImageView hTX = null;
    private View hUl = null;
    private com.baidu.tbadk.core.dialog.a hUo = null;
    private com.baidu.tbadk.core.dialog.b fvX = null;
    private View hUp = null;
    private EditText hUq = null;
    private com.baidu.tieba.pb.view.c hUr = null;
    private com.baidu.tieba.pb.view.a hUs = null;
    private com.baidu.tbadk.core.dialog.a hUu = null;
    private b.a gJT = null;
    private TbRichTextView.h cKh = null;
    private NoNetworkView.a fru = null;
    private com.baidu.tbadk.core.dialog.i hUv = null;
    private View hUw = null;
    private com.baidu.tbadk.core.dialog.a hUx = null;
    private Dialog hUy = null;
    private Dialog hUz = null;
    private View hUA = null;
    private LinearLayout hUB = null;
    private CompoundButton.OnCheckedChangeListener eES = null;
    private TextView hUC = null;
    private TextView hUD = null;
    private String hUE = null;
    private com.baidu.tbadk.core.dialog.i hKI = null;
    private com.baidu.tbadk.core.dialog.i hUF = null;
    private boolean hUG = false;
    private boolean hUH = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hUI = null;
    private boolean hUJ = false;
    private Button hUK = null;
    private boolean hUR = true;
    private com.baidu.tbadk.core.view.b eMs = null;
    private boolean hMU = false;
    private int mSkinType = 3;
    private boolean hUV = false;
    private int hVh = 0;
    private boolean hVi = true;
    public a hVj = new a();
    private int hVl = 0;
    private boolean hVv = false;
    private int hVw = 0;
    private boolean hVx = false;
    private boolean hVy = false;
    private boolean hVz = false;
    private int hVB = 0;
    private boolean hVK = false;
    private int hVN = R.drawable.bg_user_identity_btn;
    private String hVS = null;
    private CustomMessageListener hVT = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hVS = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hUn != null) {
                aq.this.hUn.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hVU = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hTH != null) {
                aq.this.hTH.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hVV = new Handler();
    private CustomMessageListener hVX = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hUR = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hVZ = true;
    View.OnClickListener hWa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hVx) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").P(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hVx && aq.this.hPY != null && aq.this.hPY.bSx() != null && aq.this.hPY.bSx().aex() != null && aq.this.hPY.bSx().aex().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").P("obj_locate", 1));
            }
            aq.this.hMD.hKD.fVU.onClick(view);
        }
    };
    private boolean hWb = false;
    String userId = null;
    private final List<TbImageView> hWc = new ArrayList();
    private boolean hWe = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int hCL;
        public al hWt;
        public int headerCount;
    }

    public void oN(boolean z) {
        this.hVv = z;
        if (this.hTy != null) {
            this.hVw = this.hTy.getHeaderViewsCount();
        }
    }

    public void bWP() {
        if (this.hTy != null) {
            int headerViewsCount = this.hTy.getHeaderViewsCount() - this.hVw;
            final int firstVisiblePosition = (this.hTy.getFirstVisiblePosition() == 0 || this.hTy.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hTy.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hTy.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hVj.hWt = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hVj));
            final al alVar = this.hVj.hWt;
            final int h = h(alVar);
            final int y = ((int) this.hUm.getY()) + this.hUm.getMeasuredHeight();
            final boolean z = this.hVd.getVisibility() == 0;
            boolean z2 = this.hUm.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hUn.bUZ() + this.hTy.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hSS.getMeasuredHeight() : 0;
                if (z2) {
                    this.hTy.setSelectionFromTop(this.hUn.bUZ() + this.hTy.getHeaderViewsCount(), hVg - measuredHeight);
                } else {
                    this.hTy.setSelectionFromTop(this.hUn.bUZ() + this.hTy.getHeaderViewsCount(), this.hTu.bYB().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hTy.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hVx) {
                this.hTy.setSelectionFromTop(this.hUn.bUZ() + this.hTy.getHeaderViewsCount(), this.hTo.aJs().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hTy.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bVr() {
                        if (h >= 0 && h <= aq.this.euU.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.euX.getLayoutParams();
                            if (i == 0 || i > aq.this.euU.getMeasuredHeight() || h2 >= aq.this.euU.getMeasuredHeight()) {
                                layoutParams.height = aq.this.ehD;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.euU.getMeasuredHeight()) {
                                layoutParams.height = aq.this.ehD;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hTy.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.euX.setLayoutParams(layoutParams);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (aq.this.euX != null && aq.this.euX.getLayoutParams() != null) {
                                        ViewGroup.LayoutParams layoutParams2 = aq.this.euX.getLayoutParams();
                                        layoutParams2.height = aq.this.ehD;
                                        aq.this.euX.setLayoutParams(layoutParams2);
                                    }
                                }
                            });
                        }
                        aq.this.hTy.setOnLayoutListener(null);
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

    public NoNetworkView bWQ() {
        return this.eWV;
    }

    public void bWR() {
        if (this.TU != null) {
            this.TU.hide();
            if (this.hVH != null) {
                this.hVH.aIk();
            }
        }
    }

    public PbFakeFloorModel bWS() {
        return this.hOQ;
    }

    public s bWT() {
        return this.hVt;
    }

    public void bWU() {
        reset();
        bWR();
        this.hVt.bVi();
        oY(false);
    }

    private void reset() {
        if (this.hMD != null && this.hMD.bTQ() != null && this.TU != null) {
            com.baidu.tbadk.editortools.pb.a.asv().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bTQ = this.hMD.bTQ();
            bTQ.asO();
            bTQ.asj();
            if (bTQ.getWriteImagesInfo() != null) {
                bTQ.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bTQ.kv(SendView.ALL);
            bTQ.kw(SendView.ALL);
            com.baidu.tbadk.editortools.g km = this.TU.km(23);
            com.baidu.tbadk.editortools.g km2 = this.TU.km(2);
            com.baidu.tbadk.editortools.g km3 = this.TU.km(5);
            if (km2 != null) {
                km2.qk();
            }
            if (km3 != null) {
                km3.qk();
            }
            if (km != null) {
                km.hide();
            }
            this.TU.invalidate();
        }
    }

    public boolean bWV() {
        return this.hUR;
    }

    public void oO(boolean z) {
        if (this.hUM != null && this.gmp != null) {
            this.gmp.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hUM.startAnimation(alphaAnimation);
            }
            this.hUL.setVisibility(0);
            this.hUM.setVisibility(0);
            this.hUR = true;
            if (this.hVk != null && !this.hVI.isActive()) {
                this.hVk.setVisibility(0);
                oS(true);
            }
        }
    }

    public void oP(boolean z) {
        if (this.hUM != null && this.gmp != null) {
            this.gmp.setText(bWW());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hUM.startAnimation(alphaAnimation);
            }
            this.hUL.setVisibility(0);
            this.hUM.setVisibility(0);
            this.hUR = true;
            if (this.hVk != null && !this.hVI.isActive()) {
                this.hVk.setVisibility(0);
                oS(true);
            }
        }
    }

    public String bWW() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.hVM)) {
            return this.hVM;
        }
        if (this.hMD != null) {
            this.hVM = this.hMD.getResources().getString(ap.bWO());
        }
        return this.hVM;
    }

    public PostData bWX() {
        int i = 0;
        if (this.hTy == null) {
            return null;
        }
        int bWY = bWY() - this.hTy.getHeaderViewsCount();
        if (bWY < 0) {
            bWY = 0;
        }
        if (this.hUn.xN(bWY) != null && this.hUn.xN(bWY) != PostData.jeW) {
            i = bWY + 1;
        }
        return this.hUn.getItem(i) instanceof PostData ? (PostData) this.hUn.getItem(i) : null;
    }

    public int bWY() {
        int i;
        View childAt;
        if (this.hTy == null) {
            return 0;
        }
        int firstVisiblePosition = this.hTy.getFirstVisiblePosition();
        int lastVisiblePosition = this.hTy.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hTy.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hTy.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bWZ() {
        return this.hTy.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hPY != null && this.hPY.bSz() != null && !this.hPY.bSz().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hPY.bSz().size() && (postData = this.hPY.bSz().get(i)) != null && postData.aex() != null && !StringUtils.isNull(postData.aex().getUserId()); i++) {
                if (this.hPY.bSz().get(i).aex().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hVI != null && this.hVI.isActive()) {
                        oY(false);
                    }
                    if (this.hVk != null) {
                        this.hVk.pg(true);
                    }
                    this.hVS = postData.aex().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hMD = null;
        this.euU = null;
        this.fwl = null;
        this.hTp = 0L;
        this.hTy = null;
        this.hTA = null;
        this.hTI = null;
        this.hTM = null;
        this.hTO = null;
        this.hTP = null;
        this.hTS = null;
        this.hTT = null;
        this.hTU = null;
        this.hTY = null;
        this.hUa = null;
        this.hUb = null;
        this.hUc = null;
        this.hUd = null;
        this.hUj = null;
        this.hUk = null;
        this.hUn = null;
        this.fAd = null;
        this.cze = null;
        this.fvY = null;
        this.hNc = null;
        this.hUM = null;
        this.gmp = null;
        this.hUW = null;
        this.hUX = null;
        this.hUY = null;
        this.hVA = 0;
        this.hTp = System.currentTimeMillis();
        this.hMD = pbActivity;
        this.fvY = onClickListener;
        this.clt = cVar;
        this.hVA = com.baidu.adp.lib.util.l.af(this.hMD) / 2;
        this.euU = (RelativeLayout) LayoutInflater.from(this.hMD.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.hMD.addContentView(this.euU, new FrameLayout.LayoutParams(-1, -1));
        this.fSs = (NavigationBarCoverTip) this.hMD.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.fwl = this.hMD.findViewById(R.id.statebar_view);
        this.hUm = (ObservedChangeLinearLayout) this.hMD.findViewById(R.id.title_wrapper);
        this.eWV = (NoNetworkView) this.hMD.findViewById(R.id.view_no_network);
        this.hTy = (PbLandscapeListView) this.hMD.findViewById(R.id.new_pb_list);
        this.hVc = (FrameLayout) this.hMD.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.hMD.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.hMD.getActivity(), R.dimen.ds88));
        this.hTy.addHeaderView(this.textView, 0);
        this.ehD = this.hMD.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.euX = new View(this.hMD.getPageContext().getPageActivity());
        this.euX.setLayoutParams(new AbsListView.LayoutParams(-1, this.ehD));
        this.euX.setVisibility(4);
        this.hTy.addFooterView(this.euX);
        this.hTy.setOnTouchListener(this.hMD.cmp);
        this.hTu = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.hMD.bUt()) {
            this.hTw = (ViewStub) this.hMD.findViewById(R.id.manga_view_stub);
            this.hTw.setVisibility(0);
            this.hTv = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.hTv.show();
            this.hTu.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hMD.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.hTu.bYB().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0366a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0366a
            public void bTn() {
                if (aq.this.hTy != null) {
                    if (aq.this.hTo != null) {
                        aq.this.hTo.bZV();
                    }
                    aq.this.hTy.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0366a
            public void bTo() {
                aq.this.hMD.bmk();
            }
        }));
        this.hUL = this.hMD.findViewById(R.id.view_comment_top_line);
        this.hUM = this.hMD.findViewById(R.id.pb_editor_tool_comment);
        this.hUS = com.baidu.adp.lib.util.l.g(this.hMD.getPageContext().getPageActivity(), R.dimen.tbds120);
        this.hUT = com.baidu.adp.lib.util.l.g(this.hMD.getPageContext().getPageActivity(), R.dimen.ds242);
        this.gmp = (TextView) this.hMD.getPageContext().getPageActivity().findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.gmp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hMD.bTZ();
                if (aq.this.hMD != null && aq.this.hMD.bTD() != null && aq.this.hMD.bTD().getPbData() != null && aq.this.hMD.bTD().getPbData().bSx() != null && aq.this.hMD.bTD().getPbData().bSx().aex() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", aq.this.hMD.bTD().hPC).bT("fid", aq.this.hMD.bTD().getPbData().getForumId()).P("obj_locate", 1).bT("uid", aq.this.hMD.bTD().getPbData().bSx().aex().getUserId()));
                }
            }
        });
        this.hUN = (ImageView) this.hMD.findViewById(R.id.pb_editor_tool_comment_icon);
        this.hUN.setOnClickListener(this.fvY);
        this.hUO = (ImageView) this.hMD.findViewById(R.id.pb_editor_tool_collection);
        this.hUO.setOnClickListener(this.fvY);
        this.hUP = (ImageView) this.hMD.findViewById(R.id.pb_editor_tool_share);
        this.hUP.setOnClickListener(this.fvY);
        this.hUQ = (TextView) this.hMD.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.hTA = LayoutInflater.from(this.hMD.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.hTI = (RelativeLayout) LayoutInflater.from(this.hMD.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.hTJ = (ImageView) this.hTI.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.hTL = new e(this.hMD, this.hTI);
        this.hTL.init();
        this.hTL.a(this.hTL.bTP(), this.fvY);
        this.hTM = (ColumnLayout) this.hTI.findViewById(R.id.pb_head_owner_root);
        this.hTN = (ThreadSkinView) this.hTI.findViewById(R.id.pb_thread_skin);
        this.hTM.setOnLongClickListener(this.onLongClickListener);
        this.hTM.setOnTouchListener(this.clt);
        this.hTM.setVisibility(8);
        this.hTA.setOnTouchListener(this.clt);
        this.hUW = this.hTA.findViewById(R.id.pb_head_activity_join_number_container);
        this.hUW.setVisibility(8);
        this.hUX = (TextView) this.hTA.findViewById(R.id.pb_head_activity_join_number);
        this.hTO = (TextView) this.hTM.findViewById(R.id.pb_head_owner_info_user_name);
        this.hTO.getPaint().setFakeBoldText(true);
        this.hTP = (TextView) this.hTM.findViewById(R.id.floor_owner);
        this.hTQ = (ImageView) this.hTM.findViewById(R.id.icon_forum_level);
        this.hTS = (FrameLayout) this.hTM.findViewById(R.id.pb_head_headImage_container);
        this.hTT = (HeadImageView) this.hTM.findViewById(R.id.pb_head_owner_photo);
        this.hTR = (HeadPendantView) this.hTM.findViewById(R.id.pb_pendant_head_owner_photo);
        this.hTR.setHasPendantStyle();
        if (this.hTR.getHeadView() != null) {
            this.hTR.getHeadView().setIsRound(true);
            this.hTR.getHeadView().setDrawBorder(false);
        }
        this.hNQ = (UserIconBox) this.hTM.findViewById(R.id.show_icon_vip);
        this.hNR = (UserIconBox) this.hTM.findViewById(R.id.show_icon_yinji);
        this.hTV = (LinearLayout) this.hTI.findViewById(R.id.pb_head_owner_info_root);
        this.hTY = (PbFirstFloorUserLikeButton) this.hTM.findViewById(R.id.pb_like_button);
        this.hUa = (TextView) this.hTM.findViewById(R.id.pb_views);
        this.hUb = (TextView) this.hTM.findViewById(R.id.pb_item_first_floor_reply_time);
        this.hUc = (TextView) this.hTM.findViewById(R.id.pb_item_first_floor_location_address);
        this.hUd = (TextView) this.hTM.findViewById(R.id.point_between_time_and_locate);
        this.hVQ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hVR = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hUj = this.hTA.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.hUk = this.hTA.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.hTA.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hUY = (ViewStub) this.euU.findViewById(R.id.interview_status_stub);
        this.hUe = this.hTI.findViewById(R.id.blank_view_align_user_item_top);
        this.hUf = this.hTI.findViewById(R.id.blank_view_align_user_item_bottom);
        this.hUn = new f(this.hMD, this.hTy);
        this.hUn.B(this.fvY);
        this.hUn.setTbGestureDetector(this.clt);
        this.hUn.setOnImageClickListener(this.cKh);
        this.hNc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hMD.c(sparseArray);
                            return;
                        }
                        aq.this.cD(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.hMD.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hUn.N(this.hNc);
        bXe();
        bXf();
        this.hTy.addHeaderView(this.hTI);
        this.hTy.addHeaderView(this.hTG);
        this.hTy.addHeaderView(this.hTA);
        this.fAd = new PbListView(this.hMD.getPageContext().getPageActivity());
        this.cze = this.fAd.getView().findViewById(R.id.pb_more_view);
        if (this.cze != null) {
            this.cze.setOnClickListener(this.fvY);
            com.baidu.tbadk.core.util.am.k(this.cze, R.drawable.pb_foot_more_trans_selector);
        }
        this.fAd.akz();
        this.fAd.iS(R.drawable.pb_foot_more_trans_selector);
        this.fAd.iU(R.drawable.pb_foot_more_trans_selector);
        this.hUt = this.hMD.findViewById(R.id.viewstub_progress);
        this.hMD.registerListener(this.hVX);
        this.hTU = com.baidu.tbadk.ala.b.aak().n(this.hMD.getActivity(), 2);
        if (this.hTU != null) {
            this.hTU.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hMD.getResources().getDimensionPixelSize(R.dimen.ds10);
            if (this.hTU.getParent() == null) {
                this.hTV.addView(this.hTU, aVar);
            }
        }
        this.hOQ = new PbFakeFloorModel(this.hMD.getPageContext());
        this.hVt = new s(this.hMD.getPageContext(), this.hOQ, this.euU);
        this.hVt.a(this.hMD.hLD);
        this.hOQ.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hOQ.o(postData);
                aq.this.hUn.notifyDataSetChanged();
                aq.this.hVt.bVi();
                aq.this.TU.aqu();
                aq.this.oY(false);
            }
        });
        if (this.hMD.bTD() != null && !StringUtils.isNull(this.hMD.bTD().bWd())) {
            this.hMD.showToast(this.hMD.bTD().bWd());
        }
        this.hVd = this.hMD.findViewById(R.id.pb_expand_blank_view);
        this.hVe = this.hMD.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hVe.getLayoutParams();
        if (this.hMD.bTD() != null && this.hMD.bTD().bVy()) {
            this.hVd.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hVe.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hVg;
            this.hVe.setLayoutParams(layoutParams2);
        }
        this.hVf = new al(this.hMD.getPageContext(), this.hMD.findViewById(R.id.pb_reply_expand_view));
        this.hVf.hSS.setVisibility(8);
        this.hVf.P(this.fvY);
        this.hMD.registerListener(this.mAccountChangedListener);
        this.hMD.registerListener(this.hVT);
        this.hMD.registerListener(this.hVU);
        bXa();
        oS(false);
    }

    public void bxt() {
        if (!this.hMD.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").P("obj_locate", 2).bT("fid", this.mForumId));
        } else if (this.hMD.bUb()) {
            com.baidu.tbadk.editortools.pb.d bTQ = this.hMD.bTQ();
            if (bTQ != null && (bTQ.asL() || bTQ.asM())) {
                this.hMD.bTQ().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.TU != null) {
                bXk();
            }
            if (this.TU != null) {
                this.hUR = false;
                if (this.TU.kp(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hMD, (View) this.TU.kp(2).crT, false, hVO);
                }
            }
            bXQ();
        }
    }

    private void bXa() {
        this.hVI = new com.baidu.tieba.pb.pb.godreply.a(this.hMD, this, (ViewStub) this.euU.findViewById(R.id.more_god_reply_popup));
        this.hVI.v(this.fvY);
        this.hVI.N(this.hNc);
        this.hVI.setOnImageClickListener(this.cKh);
        this.hVI.v(this.fvY);
        this.hVI.setTbGestureDetector(this.clt);
    }

    public com.baidu.tieba.pb.pb.godreply.a bXb() {
        return this.hVI;
    }

    public View bXc() {
        return this.hVd;
    }

    public void bXd() {
        if (this.hTy != null) {
            this.hTy.removeHeaderView(this.hTG);
            this.hTy.removeHeaderView(this.hTI);
            this.hTy.removeHeaderView(this.hTB);
            this.hTy.removeHeaderView(this.hTA);
        }
    }

    private void bXe() {
        if (this.hTB == null) {
            this.hTB = (RelativeLayout) LayoutInflater.from(this.hMD).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.hTC = (HeadImageView) this.hTB.findViewById(R.id.iv_pb_video_smart_app_head);
            this.hTC.setIsRound(true);
            this.hTD = (TextView) this.hTB.findViewById(R.id.tv_pb_video_smart_app_title);
            this.hTE = (TextView) this.hTB.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.hTF = (ImageView) this.hTB.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.hTB.setOnClickListener(this.fvY);
        }
    }

    private void bXf() {
        if (this.hTG == null) {
            this.hTG = (RelativeLayout) LayoutInflater.from(this.hMD).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.hTK = (ImageView) this.hTG.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.hTK.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
            this.hTK.setImageMatrix(matrix);
            this.hTH = (TextView) this.hTG.findViewById(R.id.tv_pb_title);
            this.hTH.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.hTH.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hTH.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.j(this.hTH, R.color.cp_cont_b);
            this.hTH.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hTH.setVisibility(8);
            if (this.hTH.getParent() == null) {
                this.hTG.addView(this.hTH);
            }
            this.hTG.setOnTouchListener(this.clt);
            this.hTG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXg() {
        if (this.hMD.bUt()) {
            this.hTx = (ViewStub) this.hMD.findViewById(R.id.manga_mention_controller_view_stub);
            this.hTx.setVisibility(0);
            if (this.hUg == null) {
                this.hUg = (LinearLayout) this.hMD.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.s.a.a(this.hMD.getPageContext(), this.hUg);
            }
            if (this.hUh == null) {
                this.hUh = (TextView) this.hUg.findViewById(R.id.manga_prev_btn);
            }
            if (this.hUi == null) {
                this.hUi = (TextView) this.hUg.findViewById(R.id.manga_next_btn);
            }
            this.hUh.setOnClickListener(this.fvY);
            this.hUi.setOnClickListener(this.fvY);
        }
    }

    private void bXh() {
        if (this.hMD.bUt()) {
            if (this.hMD.bUw() == -1) {
                com.baidu.tbadk.core.util.am.f(this.hUh, R.color.cp_cont_e, 1);
            }
            if (this.hMD.bUx() == -1) {
                com.baidu.tbadk.core.util.am.f(this.hUi, R.color.cp_cont_e, 1);
            }
        }
    }

    public void bXi() {
        if (this.hUg == null) {
            bXg();
        }
        this.hTx.setVisibility(8);
        if (this.hVV != null && this.hVW != null) {
            this.hVV.removeCallbacks(this.hVW);
        }
    }

    public void bXj() {
        if (this.hVV != null) {
            if (this.hVW != null) {
                this.hVV.removeCallbacks(this.hVW);
            }
            this.hVW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hUg == null) {
                        aq.this.bXg();
                    }
                    aq.this.hTx.setVisibility(0);
                }
            };
            this.hVV.postDelayed(this.hVW, 2000L);
        }
    }

    public void oQ(boolean z) {
        this.hTu.oQ(z);
        if (z && this.hUV) {
            this.fAd.setText(this.hMD.getResources().getString(R.string.click_load_more));
            this.hTy.setNextPage(this.fAd);
            this.hTt = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
        this.TU.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.TU.getParent() == null) {
            this.euU.addView(this.TU, layoutParams);
        }
        this.TU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.TU.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).amu() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).amu() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.ajQ();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hMD, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.ad(aq.this.hMD)) {
                            aq.this.hMD.bTQ().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hMD.bTQ().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bWR();
        this.hMD.bTQ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.TU != null && aq.this.TU.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hVH == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.TU.getId());
                            aq.this.hVH = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hMD.getPageContext(), aq.this.euU, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.aa(aq.this.hVG)) {
                                aq.this.hVH.setData(aq.this.hVG);
                            }
                            aq.this.hVH.b(aq.this.TU);
                        }
                        aq.this.hVH.Ch(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hMD.hKH != null && aq.this.hMD.hKH.bYh() != null) {
                    if (!aq.this.hMD.hKH.bYh().czh()) {
                        aq.this.hMD.hKH.pd(false);
                    }
                    aq.this.hMD.hKH.bYh().sa(false);
                }
            }
        });
    }

    public void bXk() {
        if (this.hMD != null && this.TU != null) {
            this.TU.qk();
            if (this.hMD.bTQ() != null) {
                this.hMD.bTQ().asC();
            }
            bXQ();
        }
    }

    public void oR(boolean z) {
        if (this.hTy != null && this.textView != null && this.fwl != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fwl.setVisibility(0);
                } else {
                    this.fwl.setVisibility(8);
                    this.hTy.removeHeaderView(this.textView);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hVg;
                    this.textView.setLayoutParams(layoutParams);
                }
                bXy();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + pa(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            bXy();
            bXY();
        }
    }

    public f bXl() {
        return this.hUn;
    }

    public void a(PbActivity.d dVar) {
        this.hLI = dVar;
    }

    public void cD(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hMD);
        kVar.setTitleText(this.hMD.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hUv.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hVY != null) {
                                aq.this.hVY.m(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hMD.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hMD.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hMD.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !bXX()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.hMD.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hMD.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hMD.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.W(arrayList);
        if (this.hUv == null) {
            this.hUv = new com.baidu.tbadk.core.dialog.i(this.hMD.getPageContext(), kVar.ahb());
        } else {
            this.hUv.setContentView(kVar.ahb());
        }
        this.hUv.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hVY = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hMD != null && aVar != null) {
            if (this.fVl == null) {
                this.fVl = new com.baidu.tieba.NEGFeedBack.e(this.hMD.getPageContext(), this.hTA);
            }
            AntiData blb = this.hMD.blb();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (blb != null && blb.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = blb.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.b(sparseArray);
            this.fVl.setDefaultReasonArray(new String[]{this.hMD.getString(R.string.delete_thread_reason_1), this.hMD.getString(R.string.delete_thread_reason_2), this.hMD.getString(R.string.delete_thread_reason_3), this.hMD.getString(R.string.delete_thread_reason_4), this.hMD.getString(R.string.delete_thread_reason_5)});
            this.fVl.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fVl.rJ(str);
            this.fVl.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    aq.this.hMD.a(aVar, jSONArray);
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
        sparseArray.put(hVn, Integer.valueOf(hVo));
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
        this.hUx = new com.baidu.tbadk.core.dialog.a(this.hMD.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hUx.hu(i3);
        } else {
            this.hUx.dV(false);
            this.hUx.mO(str2);
        }
        this.hUx.ab(sparseArray);
        this.hUx.a(R.string.dialog_ok, this.hMD);
        this.hUx.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hUx.dQ(true);
        this.hUx.b(this.hMD.getPageContext());
        if (z) {
            this.hUx.agI();
        } else {
            a(this.hUx, i);
        }
    }

    public void ax(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hUA == null) {
            this.hUA = LayoutInflater.from(this.hMD.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.hMD.getLayoutMode().onModeChanged(this.hUA);
        if (this.hUz == null) {
            this.hUz = new Dialog(this.hMD.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hUz.setCanceledOnTouchOutside(true);
            this.hUz.setCancelable(true);
            this.hUI = (ScrollView) this.hUA.findViewById(R.id.good_scroll);
            this.hUz.setContentView(this.hUA);
            WindowManager.LayoutParams attributes = this.hUz.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.hMD.getPageContext().getPageActivity(), R.dimen.ds540);
            this.hUz.getWindow().setAttributes(attributes);
            this.eES = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hUE = (String) compoundButton.getTag();
                        if (aq.this.eER != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.eER) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hUE != null && !str.equals(aq.this.hUE)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hUB = (LinearLayout) this.hUA.findViewById(R.id.good_class_group);
            this.hUD = (TextView) this.hUA.findViewById(R.id.dialog_button_cancel);
            this.hUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hUz instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hUz, aq.this.hMD.getPageContext());
                    }
                }
            });
            this.hUC = (TextView) this.hUA.findViewById(R.id.dialog_button_ok);
            this.hUC.setOnClickListener(this.fvY);
        }
        this.hUB.removeAllViews();
        this.eER = new ArrayList();
        CustomBlueCheckRadioButton dN = dN("0", this.hMD.getPageContext().getString(R.string.thread_good_class));
        this.eER.add(dN);
        dN.setChecked(true);
        this.hUB.addView(dN);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.acX()) && acVar.acY() > 0) {
                    CustomBlueCheckRadioButton dN2 = dN(String.valueOf(acVar.acY()), acVar.acX());
                    this.eER.add(dN2);
                    View view = new View(this.hMD.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.hMD.getPageContext().getPageActivity(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.l(view, R.color.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hUB.addView(view);
                    this.hUB.addView(dN2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hUI.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hMD.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hMD.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hMD.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hUI.setLayoutParams(layoutParams2);
            this.hUI.removeAllViews();
            if (this.hUB != null && this.hUB.getParent() == null) {
                this.hUI.addView(this.hUB);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hUz, this.hMD.getPageContext());
    }

    private CustomBlueCheckRadioButton dN(String str, String str2) {
        Activity pageActivity = this.hMD.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.eES);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bXm() {
        this.hMD.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hMD.hideProgressBar();
        if (z && z2) {
            this.hMD.showToast(this.hMD.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.hMD.showToast(str);
        }
    }

    public void bEI() {
        this.hUt.setVisibility(0);
    }

    public void bEH() {
        this.hUt.setVisibility(8);
    }

    public View bXn() {
        if (this.hUA != null) {
            return this.hUA.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String bXo() {
        return this.hUE;
    }

    public View getView() {
        return this.euU;
    }

    public void bXp() {
        com.baidu.adp.lib.util.l.b(this.hMD.getPageContext().getPageActivity(), this.hMD.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hMD.hideProgressBar();
        if (z) {
            bXH();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bXI();
        } else {
            bXH();
        }
    }

    public void bXq() {
        this.fAd.akz();
        this.fAd.akD();
    }

    public void bXr() {
        this.hMD.hideProgressBar();
        akE();
        this.hTy.completePullRefreshPostDelayed(0L);
        bXC();
    }

    public void bXs() {
        this.hTy.completePullRefreshPostDelayed(0L);
        bXC();
    }

    private void oS(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hUn.setOnLongClickListener(onLongClickListener);
        if (this.hVI != null) {
            this.hVI.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.hKI != null) {
            this.hKI.dismiss();
            this.hKI = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hMD);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hMD.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hMD.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hMD.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hMD.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hUF.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hUF = new com.baidu.tbadk.core.dialog.i(this.hMD.getPageContext(), kVar.ahb());
        this.hUF.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.hUF != null) {
            this.hUF.dismiss();
            this.hUF = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hMD);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hMD.getPageContext().getString(R.string.save_to_emotion), kVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hMD.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hUF.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hUF = new com.baidu.tbadk.core.dialog.i(this.hMD.getPageContext(), kVar.ahb());
        this.hUF.showDialog();
    }

    public int bXt() {
        return ye(this.hTy.getFirstVisiblePosition());
    }

    private int ye(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hTy.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int od = (this.hTy.getAdapter() == null || !(this.hTy.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hTy.getAdapter().od();
            return i > od ? i - od : 0;
        }
        return i;
    }

    public int bXu() {
        int lastVisiblePosition = this.hTy.getLastVisiblePosition();
        if (this.hTo != null) {
            if (lastVisiblePosition == this.hTy.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return ye(lastVisiblePosition);
    }

    public void yf(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.hTy != null) {
            if (this.hTu == null || this.hTu.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hTu.mNavigationBar.getFixedNavHeight();
                if (!(this.hMD.bUh() != -1)) {
                    if (this.hVe != null && (layoutParams = (LinearLayout.LayoutParams) this.hVe.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hVe.setLayoutParams(layoutParams);
                    }
                    i--;
                    bYc();
                }
                i2 = fixedNavHeight;
            }
            this.hTy.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hTy.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hTy.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hUq.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hUn.a(dVar, false);
        this.hUn.notifyDataSetChanged();
        bXC();
        if (this.hVI != null) {
            this.hVI.bTz();
        }
        ArrayList<PostData> bSz = dVar.bSz();
        if (dVar.getPage().adr() == 0 || bSz == null || bSz.size() < dVar.getPage().adq()) {
            if (com.baidu.tbadk.core.util.v.Z(bSz) == 0 || (com.baidu.tbadk.core.util.v.Z(bSz) == 1 && bSz.get(0) != null && bSz.get(0).cpp() == 1)) {
                if (this.hVj == null || this.hVj.hWt == null || this.hVj.hWt.getView() == null) {
                    i = 0;
                } else {
                    i = this.hVj.hWt.getView().getTop() < 0 ? this.hVj.hWt.getView().getHeight() : this.hVj.hWt.getView().getBottom();
                }
                if (this.hMD.bUF()) {
                    this.fAd.W(this.hMD.getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.fAd.W(this.hMD.getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().adr() == 0) {
                    this.fAd.setText(this.hMD.getResources().getString(R.string.list_has_no_more));
                } else {
                    this.fAd.setText(this.hMD.getResources().getString(R.string.load_more));
                }
                this.fAd.akI();
            }
        }
        o(dVar);
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        if (this.hTW == null) {
            this.hMD.getLayoutMode().onModeChanged(((ViewStub) this.hTA.findViewById(R.id.praise_layout)).inflate());
            this.hTW = (FrsPraiseView) this.hTA.findViewById(R.id.pb_head_praise_view);
            this.hTW.setIsFromPb(true);
            this.hUl = this.hTA.findViewById(R.id.new_pb_header_item_line_above_praise);
            this.hTW.jc(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hTW != null) {
            boolean bXC = bXC();
            this.hTW.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().ads() == 0 && this.hMU) {
                if (bXC) {
                    this.hUk.setVisibility(0);
                    return;
                } else {
                    this.hUk.setVisibility(8);
                    return;
                }
            }
            this.hUk.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bSH() != null) {
            return dVar.bSH();
        }
        if (!com.baidu.tbadk.core.util.v.aa(dVar.bSz())) {
            Iterator<PostData> it = dVar.bSz().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cpp() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bSE();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aex() != null && postData.aex().getUserTbVipInfoData() != null && postData.aex().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aex().getGodUserData().setIntro(postData.aex().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bSx() == null || dVar.bSx().aex() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aex = dVar.bSx().aex();
        String userId = aex.getUserId();
        HashMap<String, MetaData> userMap = dVar.bSx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aex;
        }
        postData.Be(1);
        postData.setId(dVar.bSx().aeN());
        postData.setTitle(dVar.bSx().getTitle());
        postData.setTime(dVar.bSx().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0643 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x084e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0857  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x08b1  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String j;
        ArrayList<IconData> tShowInfoNew;
        com.baidu.tbadk.data.f cps;
        String portrait;
        String charSequence;
        if (dVar != null && dVar.bSx() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hTM.setVisibility(8);
            if (dVar.bSx() != null && dVar.bSx().afr() && dVar.bSx().aeO() != null) {
                this.hVx = true;
                this.hTu.pn(this.hVx);
                this.hTu.mNavigationBar.hideBottomLine();
                if (this.hTo == null) {
                    this.hTo = new com.baidu.tieba.pb.video.i(this.hMD, this.hTu, dVar.bSx().aeO(), this.hTp);
                    this.hTo.a(dVar.bSx().aeO(), dVar.bSx(), dVar.getForumId());
                    this.hTo.startPlay();
                } else if (this.hTs) {
                    this.hTo.a(dVar.bSx().aeO(), dVar.bSx(), dVar.getForumId());
                    this.hTo.startPlay();
                } else {
                    this.hTo.Ct(dVar.getForumId());
                }
                com.baidu.tieba.pb.c.a.a(this.hMD.getUniqueId(), dVar, c, 1, 1);
                if (dVar.bSy() != null && dVar.bSy().size() >= 1) {
                    bg bgVar = dVar.bSy().get(0);
                    this.hTo.aB(bgVar);
                    this.hTo.Cu(bgVar.getTitle());
                }
                this.hTo.b(c, dVar.bSx(), dVar.bSU());
                this.hTs = false;
                this.hTy.removeHeaderView(this.hTo.bZX());
                this.hTy.addHeaderView(this.hTo.bZX(), 0);
                if (this.hTo.aJs() != null && this.hTo.aJs().getParent() == null) {
                    this.hVc.addView(this.hTo.aJs());
                }
                if (this.hTq == null) {
                    this.hTq = new com.baidu.tieba.pb.video.h(this.hMD);
                }
                this.hTq.a(dVar.bSx().afH(), dVar.bSx(), dVar.bSR());
                this.hTy.removeHeaderView(this.hTq.bZK());
                this.hTy.addHeaderView(this.hTq.bZK(), 1);
                if (dVar.bSx().afH() != null) {
                    this.hTy.removeHeaderView(this.hTq.bZL());
                    this.hTy.removeHeaderView(this.hTI);
                    this.hTy.addHeaderView(this.hTq.bZL(), 2);
                } else {
                    if (this.hTq.bZL() != null) {
                        this.hTy.removeHeaderView(this.hTq.bZL());
                    }
                    this.hTy.removeHeaderView(this.hTI);
                    this.hTy.addHeaderView(this.hTI, 2);
                }
                if (this.hTo != null) {
                    this.hTu.pj(false);
                    this.hTo.ym(TbadkCoreApplication.getInst().getSkinType());
                }
                bXy();
            } else {
                this.hVx = false;
                this.hTu.pn(this.hVx);
                if (this.hTo != null) {
                    this.hTy.removeHeaderView(this.hTo.bZX());
                }
                if (this.hTq != null) {
                    this.hTq.b(this.hTy);
                }
            }
            if (this.hMD.bTT() != null) {
                this.hMD.bTT().ph(this.hVx);
            }
            if (this.hTo != null) {
                this.hTo.R(this.hWa);
                bYc();
            }
            if (c != null) {
                this.hUU = c;
                this.hTM.setVisibility(0);
                if (this.hMD.bTt()) {
                    if (dVar.bSw() != null) {
                        this.mForumName = dVar.bSw().getForumName();
                        this.mForumId = dVar.bSw().getForumId();
                    }
                    if (this.mForumName == null && this.hMD.bTD() != null && this.hMD.bTD().bTu() != null) {
                        this.mForumName = this.hMD.bTD().bTu();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hTM.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hTM.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_clip_board, c);
                sparseArray.put(R.id.tag_is_subpb, false);
                if (dVar.bSx().afr() && dVar.bSx().afj() != null) {
                    SmartApp afj = dVar.bSx().afj();
                    this.hTB.setVisibility(0);
                    this.hTy.removeHeaderView(this.hTB);
                    this.hTy.addHeaderView(this.hTB, 1);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afj.avatar)) {
                        this.hTC.startLoad(afj.avatar, 10, false, false);
                    }
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afj.name)) {
                        charSequence = afj.name + " " + ((Object) this.hMD.getText(R.string.smart_app_suffix));
                    } else {
                        charSequence = this.hMD.getText(R.string.intelligent_smart_app).toString();
                    }
                    this.hTD.setText(charSequence);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afj._abstract)) {
                        this.hTE.setText(afj._abstract);
                    } else {
                        this.hTE.setText(this.hMD.getText(R.string.smart_app_default_abstract));
                    }
                    this.hTB.setTag(afj);
                } else {
                    this.hTB.setVisibility(8);
                    this.hTy.removeHeaderView(this.hTB);
                }
                if (!this.hVP) {
                    this.hTG.setVisibility(0);
                }
                if (!dVar.bSx().afr() && this.hTH.getText() != null && this.hTH.getText().length() > 0) {
                    this.hTH.setVisibility(0);
                } else {
                    this.hTH.setVisibility(8);
                }
                n(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> aeI = dVar.bSx().aeI();
                if (aeI != null && aeI.size() > 0 && !this.hVP) {
                    this.hUX.setText(String.valueOf(aeI.get(0).acE()));
                    this.hUW.setVisibility(0);
                } else {
                    this.hUW.setVisibility(8);
                }
                com.baidu.tbadk.core.util.am.k(this.hUW, R.drawable.activity_join_num_bg);
                com.baidu.tbadk.core.util.am.f(this.hUX, R.color.cp_link_tip_d, 1);
                if (c.aex() != null) {
                    String string = c.aex().getName_show() == null ? StringUtils.string(c.aex().getUserName()) : StringUtils.string(c.aex().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(c.aex().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bk(c.aex().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bk(string) > 12) {
                            j = com.baidu.tbadk.core.util.aq.j(string, 12, "...");
                            ArrayList<IconData> iconInfo = c.aex().getIconInfo();
                            tShowInfoNew = c.aex().getTShowInfoNew();
                            if (this.hNR != null) {
                                this.hNR.setTag(R.id.tag_user_id, c.aex().getUserId());
                                this.hNR.setOnClickListener(this.hMD.hKD.hXT);
                                this.hNR.a(iconInfo, 4, this.hMD.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hMD.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hMD.getResources().getDimensionPixelSize(R.dimen.tbds12));
                            }
                            if (this.hNQ != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hNQ.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hNQ.setOnClickListener(this.hMD.hKD.hXU);
                                this.hNQ.a(tShowInfoNew, 3, this.hMD.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hMD.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hMD.getResources().getDimensionPixelSize(R.dimen.ds12), true);
                            }
                            this.hTO.setText(bY(c.aex().getSealPrefix(), j));
                            this.hTO.setTag(R.id.tag_user_id, c.aex().getUserId());
                            this.hTO.setTag(R.id.tag_user_name, c.aex().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || c.aex().isBigV()) {
                                com.baidu.tbadk.core.util.am.f(this.hTO, R.color.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.am.f(this.hTO, R.color.cp_cont_b, 1);
                            }
                            if (c.aex() == null) {
                                MetaData aex = c.aex();
                                if (aex.getIs_bawu() == 1 && "manager".equals(aex.getBawu_type())) {
                                    this.hTP.setText(R.string.bawu_member_bazhu_tip);
                                    this.hTP.setVisibility(0);
                                    this.hVN = R.drawable.author_bazhu_bg;
                                    com.baidu.tbadk.core.util.am.k(this.hTP, this.hVN);
                                } else if (aex.getIs_bawu() == 1 && "assist".equals(aex.getBawu_type())) {
                                    this.hTP.setText(R.string.bawu_member_xbazhu_tip);
                                    this.hTP.setVisibility(0);
                                    this.hVN = R.drawable.author_small_bazhu;
                                    com.baidu.tbadk.core.util.am.k(this.hTP, this.hVN);
                                } else {
                                    this.hTP.setVisibility(8);
                                }
                            } else {
                                this.hTP.setVisibility(8);
                            }
                            if (dVar.bSx().aex() != null && dVar.bSx().aex().getAlaUserData() != null && this.hTU != null) {
                                if (dVar.bSx().aex().getAlaUserData().anchor_live != 0) {
                                    this.hTU.setVisibility(8);
                                } else {
                                    this.hTU.setVisibility(0);
                                    if (this.hTr == null) {
                                        this.hTr = new com.baidu.tieba.c.d(this.hMD.getPageContext(), this.hTU);
                                        this.hTr.qd(1);
                                    }
                                    this.hTr.cI(this.hMD.getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bAN = dVar.bSx().aex().getAlaUserData();
                                    aVar.type = 2;
                                    this.hTU.setTag(aVar);
                                }
                            }
                            this.hTT.setUserId(c.aex().getUserId());
                            this.hTT.setUserName(c.aex().getUserName());
                            this.hTT.setTid(c.getId());
                            this.hTT.setFid(this.hPY == null ? this.hPY.getForumId() : "");
                            this.hTT.setImageDrawable(null);
                            this.hTT.setRadius(com.baidu.adp.lib.util.l.g(this.hMD.getActivity(), R.dimen.ds40));
                            this.hTT.setTag(c.aex().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hUb.setText(com.baidu.tbadk.core.util.aq.aF(c.getTime()));
                            } else {
                                this.hUb.setText(com.baidu.tbadk.core.util.aq.aD(c.getTime()));
                            }
                            cps = c.cps();
                            if (cps == null && !TextUtils.isEmpty(cps.getName()) && !TextUtils.isEmpty(cps.getName().trim())) {
                                this.hUc.setVisibility(0);
                                this.hUd.setVisibility(0);
                                this.hUc.setText(cps.getName());
                            } else {
                                this.hUc.setVisibility(8);
                                this.hUd.setVisibility(8);
                            }
                            portrait = c.aex().getPortrait();
                            if (c.aex().getPendantData() == null && !StringUtils.isNull(c.aex().getPendantData().acU())) {
                                this.hTR.b(c.aex());
                                this.hTT.setVisibility(8);
                                this.hTR.setVisibility(0);
                                if (this.hTX != null) {
                                    this.hTX.setVisibility(8);
                                }
                                this.hTO.setOnClickListener(this.hWa);
                                this.hTR.getHeadView().startLoad(portrait, 28, false);
                                this.hTR.getHeadView().setUserId(c.aex().getUserId());
                                this.hTR.getHeadView().setUserName(c.aex().getUserName());
                                this.hTR.getHeadView().setTid(c.getId());
                                this.hTR.getHeadView().setFid(this.hPY != null ? this.hPY.getForumId() : "");
                                this.hTR.getHeadView().setOnClickListener(this.hWa);
                                this.hTR.oN(c.aex().getPendantData().acU());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hTT, c.aex());
                                this.hTT.setVisibility(0);
                                this.hTM.setOnClickListener(this.hWa);
                                this.hTO.setOnClickListener(this.hWa);
                                this.hTT.setOnClickListener(this.hWa);
                                this.hTR.setVisibility(8);
                                this.hTT.startLoad(portrait, 28, false);
                            }
                            String name_show = c.aex().getName_show();
                            String userName = c.aex().getUserName();
                            if (com.baidu.tbadk.t.as.iN() && name_show != null && !name_show.equals(userName)) {
                                this.hTO.setText(com.baidu.tieba.pb.c.aE(this.hMD.getPageContext().getPageActivity(), this.hTO.getText().toString()));
                                this.hTO.setGravity(16);
                                this.hTO.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bSg());
                                com.baidu.tbadk.core.util.am.f(this.hTO, R.color.cp_other_e, 1);
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo2 = c.aex().getIconInfo();
                        tShowInfoNew = c.aex().getTShowInfoNew();
                        if (this.hNR != null) {
                        }
                        if (this.hNQ != null) {
                        }
                        this.hTO.setText(bY(c.aex().getSealPrefix(), j));
                        this.hTO.setTag(R.id.tag_user_id, c.aex().getUserId());
                        this.hTO.setTag(R.id.tag_user_name, c.aex().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.f(this.hTO, R.color.cp_cont_h, 1);
                        if (c.aex() == null) {
                        }
                        if (dVar.bSx().aex() != null) {
                            if (dVar.bSx().aex().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hTT.setUserId(c.aex().getUserId());
                        this.hTT.setUserName(c.aex().getUserName());
                        this.hTT.setTid(c.getId());
                        this.hTT.setFid(this.hPY == null ? this.hPY.getForumId() : "");
                        this.hTT.setImageDrawable(null);
                        this.hTT.setRadius(com.baidu.adp.lib.util.l.g(this.hMD.getActivity(), R.dimen.ds40));
                        this.hTT.setTag(c.aex().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cps = c.cps();
                        if (cps == null) {
                        }
                        this.hUc.setVisibility(8);
                        this.hUd.setVisibility(8);
                        portrait = c.aex().getPortrait();
                        if (c.aex().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hTT, c.aex());
                        this.hTT.setVisibility(0);
                        this.hTM.setOnClickListener(this.hWa);
                        this.hTO.setOnClickListener(this.hWa);
                        this.hTT.setOnClickListener(this.hWa);
                        this.hTR.setVisibility(8);
                        this.hTT.startLoad(portrait, 28, false);
                        String name_show2 = c.aex().getName_show();
                        String userName2 = c.aex().getUserName();
                        if (com.baidu.tbadk.t.as.iN()) {
                            this.hTO.setText(com.baidu.tieba.pb.c.aE(this.hMD.getPageContext().getPageActivity(), this.hTO.getText().toString()));
                            this.hTO.setGravity(16);
                            this.hTO.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bSg());
                            com.baidu.tbadk.core.util.am.f(this.hTO, R.color.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bk(string) > 14) {
                            j = com.baidu.tbadk.core.util.aq.j(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.aex().getIconInfo();
                            tShowInfoNew = c.aex().getTShowInfoNew();
                            if (this.hNR != null) {
                            }
                            if (this.hNQ != null) {
                            }
                            this.hTO.setText(bY(c.aex().getSealPrefix(), j));
                            this.hTO.setTag(R.id.tag_user_id, c.aex().getUserId());
                            this.hTO.setTag(R.id.tag_user_name, c.aex().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.am.f(this.hTO, R.color.cp_cont_h, 1);
                            if (c.aex() == null) {
                            }
                            if (dVar.bSx().aex() != null) {
                            }
                            this.hTT.setUserId(c.aex().getUserId());
                            this.hTT.setUserName(c.aex().getUserName());
                            this.hTT.setTid(c.getId());
                            this.hTT.setFid(this.hPY == null ? this.hPY.getForumId() : "");
                            this.hTT.setImageDrawable(null);
                            this.hTT.setRadius(com.baidu.adp.lib.util.l.g(this.hMD.getActivity(), R.dimen.ds40));
                            this.hTT.setTag(c.aex().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cps = c.cps();
                            if (cps == null) {
                            }
                            this.hUc.setVisibility(8);
                            this.hUd.setVisibility(8);
                            portrait = c.aex().getPortrait();
                            if (c.aex().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hTT, c.aex());
                            this.hTT.setVisibility(0);
                            this.hTM.setOnClickListener(this.hWa);
                            this.hTO.setOnClickListener(this.hWa);
                            this.hTT.setOnClickListener(this.hWa);
                            this.hTR.setVisibility(8);
                            this.hTT.startLoad(portrait, 28, false);
                            String name_show22 = c.aex().getName_show();
                            String userName22 = c.aex().getUserName();
                            if (com.baidu.tbadk.t.as.iN()) {
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo222 = c.aex().getIconInfo();
                        tShowInfoNew = c.aex().getTShowInfoNew();
                        if (this.hNR != null) {
                        }
                        if (this.hNQ != null) {
                        }
                        this.hTO.setText(bY(c.aex().getSealPrefix(), j));
                        this.hTO.setTag(R.id.tag_user_id, c.aex().getUserId());
                        this.hTO.setTag(R.id.tag_user_name, c.aex().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.f(this.hTO, R.color.cp_cont_h, 1);
                        if (c.aex() == null) {
                        }
                        if (dVar.bSx().aex() != null) {
                        }
                        this.hTT.setUserId(c.aex().getUserId());
                        this.hTT.setUserName(c.aex().getUserName());
                        this.hTT.setTid(c.getId());
                        this.hTT.setFid(this.hPY == null ? this.hPY.getForumId() : "");
                        this.hTT.setImageDrawable(null);
                        this.hTT.setRadius(com.baidu.adp.lib.util.l.g(this.hMD.getActivity(), R.dimen.ds40));
                        this.hTT.setTag(c.aex().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cps = c.cps();
                        if (cps == null) {
                        }
                        this.hUc.setVisibility(8);
                        this.hUd.setVisibility(8);
                        portrait = c.aex().getPortrait();
                        if (c.aex().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hTT, c.aex());
                        this.hTT.setVisibility(0);
                        this.hTM.setOnClickListener(this.hWa);
                        this.hTO.setOnClickListener(this.hWa);
                        this.hTT.setOnClickListener(this.hWa);
                        this.hTR.setVisibility(8);
                        this.hTT.startLoad(portrait, 28, false);
                        String name_show222 = c.aex().getName_show();
                        String userName222 = c.aex().getUserName();
                        if (com.baidu.tbadk.t.as.iN()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hTL.at(dVar.bSx());
                }
                if (this.hVf != null) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hIl);
                    if (dVar != null && dVar.bSx() != null) {
                        iVar.hIn = dVar.bSx().aeo();
                    }
                    iVar.isNew = !this.hMU;
                    iVar.sortType = dVar.hHU;
                    if (dVar.hHT != null && dVar.hHT.size() > dVar.hHU) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hHT.size()) {
                                break;
                            } else if (dVar.hHT.get(i4).sort_type.intValue() != dVar.hHU) {
                                i3 = i4 + 1;
                            } else {
                                iVar.hIp = dVar.hHT.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    iVar.hIq = this.hMD.bUF();
                    this.hVf.a(iVar);
                }
                if (dVar != null && dVar.bSx() != null) {
                    ad(dVar.bSx().aet() == 1, dVar.bSx().aes() == 1);
                }
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hUn != null && aq.this.hTu != null && aq.this.hTu.hYT != null && aq.this.hPY != null && aq.this.hPY.bSx() != null && !aq.this.hPY.bSx().afr() && !aq.this.bXB() && aq.this.hPY.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(aq.this.hPY.getForum().getName())) {
                            if (aq.this.hUn.bVd() == null || !aq.this.hUn.bVd().isShown()) {
                                aq.this.hTu.hYT.setVisibility(0);
                                if (aq.this.hMD != null && aq.this.hMD.bTD() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.bT("tid", aq.this.hMD.bTD().bVv());
                                    anVar.bT("fid", aq.this.hMD.bTD().getForumId());
                                    anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void oT(boolean z) {
        if (z) {
            bXv();
        } else {
            bgg();
        }
        this.hVj.hWt = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hVj));
        a(this.hVj.hWt, false);
    }

    public void bXv() {
        if (this.hTu != null && !this.hVz) {
            this.hTu.po(!StringUtils.isNull(this.hMD.bUe()));
            this.hVz = true;
        }
    }

    public void bgg() {
        if (this.hTu != null) {
            this.hTu.bYI();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.aeS() != null) {
            this.hTN.setData(this.hMD.getPageContext(), dVar.bSz().get(0).aeS(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bSx().getId(), this.hMD.bUC() ? "FRS" : null));
            this.hTM.setPadding(this.hTM.getPaddingLeft(), (int) this.hMD.getResources().getDimension(R.dimen.ds20), this.hTM.getPaddingRight(), this.hTM.getPaddingBottom());
            return;
        }
        this.hTN.setData(null, null, null);
    }

    public void bXw() {
        if (this.hTo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11997").P("obj_type", 1));
            this.hTo.bZV();
            this.hTy.smoothScrollToPosition(0);
        }
    }

    public boolean bXx() {
        return this.hWb;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean av(bg bgVar) {
        if (bgVar == null || bgVar.aex() == null || bgVar.aex().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.aex().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.hTu.bYG();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hTu.zS(cVar.forumName);
            }
            String string = this.hMD.getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.f(cVar.source, 0)) {
                case 100:
                    str = this.hMD.getResources().getString(R.string.self);
                    break;
                case 300:
                    str = this.hMD.getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = this.hMD.getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hHn;
            this.hMD.showNetRefreshView(this.euU, format, null, this.hMD.getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.kt()) {
                        bb.ajC().c(aq.this.hMD.getPageContext(), new String[]{str2});
                        aq.this.hMD.finish();
                        return;
                    }
                    aq.this.hMD.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bWG;
        Parcelable bWG2;
        if (dVar != null) {
            this.hPY = dVar;
            this.mType = i;
            if (dVar.bSx() != null) {
                this.hVl = dVar.bSx().aef();
                if (dVar.bSx().getAnchorLevel() != 0) {
                    this.hWb = true;
                }
                this.hUH = av(dVar.bSx());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.hUV = false;
            this.hMU = z;
            bXr();
            if (dVar.hHV != null && dVar.hHV.bSY()) {
                if (this.hTz == null) {
                    this.hTz = new PbThreadPostView(this.hMD);
                    this.hTy.addHeaderView(this.hTz, 1);
                    this.hTz.setData(dVar);
                    this.hTz.setChildOnClickLinstener(this.fvY);
                }
            } else if (this.hTz != null && this.hTy != null) {
                this.hTy.removeHeaderView(this.hTz);
            }
            b(dVar, z, i);
            p(dVar);
            if (this.hVL == null) {
                this.hVL = new ac(this.hMD.getPageContext(), this.fSs);
            }
            this.hVL.BY(dVar.bSC());
            if (this.hMD.bUt()) {
                if (this.hUr == null) {
                    this.hUr = new com.baidu.tieba.pb.view.c(this.hMD.getPageContext());
                    this.hUr.nZ();
                    this.hUr.setListPullRefreshListener(this.caD);
                }
                this.hTy.setPullRefresh(this.hUr);
                bXy();
                if (this.hUr != null) {
                    this.hUr.iV(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().ads() == 0 && z) {
                this.hTy.setPullRefresh(null);
            } else {
                if (this.hUr == null) {
                    this.hUr = new com.baidu.tieba.pb.view.c(this.hMD.getPageContext());
                    this.hUr.nZ();
                    this.hUr.setListPullRefreshListener(this.caD);
                }
                this.hTy.setPullRefresh(this.hUr);
                bXy();
                if (this.hUr != null) {
                    this.hUr.iV(TbadkCoreApplication.getInst().getSkinType());
                }
                aUz();
            }
            bXC();
            this.hUn.oh(this.hMU);
            this.hUn.oi(false);
            this.hUn.ot(i == 5);
            this.hUn.ou(i == 6);
            this.hUn.ov(z2 && this.hVZ);
            this.hUn.a(dVar, false);
            this.hUn.notifyDataSetChanged();
            if (this.hMD.bTt()) {
                this.hVB = 0;
                PostData c = c(dVar, z);
                if (c != null && c.aex() != null) {
                    this.hVB = c.aex().getLevel_id();
                }
                if (this.hVB > 0) {
                    this.hTQ.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(this.hTQ, BitmapHelper.getGradeResourceIdInEnterForum(this.hVB));
                } else {
                    this.hTQ.setVisibility(8);
                }
            } else {
                this.hTQ.setVisibility(8);
            }
            if (dVar.bSx() != null && dVar.bSx().aej() != null) {
                if (dVar.bSx().aej().getNum() < 1) {
                    this.hMD.getResources().getString(R.string.zan);
                } else {
                    String str = dVar.bSx().aej().getNum() + "";
                }
                if (this.hTn != -1) {
                    dVar.bSx().aej().setIsLike(this.hTn);
                }
            }
            if (this.hMD.isLogin()) {
                this.hTy.setNextPage(this.fAd);
                this.hTt = 2;
                aUz();
            } else {
                this.hUV = true;
                if (dVar.getPage().adr() == 1) {
                    if (this.hUs == null) {
                        this.hUs = new com.baidu.tieba.pb.view.a(this.hMD.getPageContext());
                    }
                    this.hTy.setNextPage(this.hUs);
                } else {
                    this.hTy.setNextPage(this.fAd);
                }
                this.hTt = 3;
            }
            ArrayList<PostData> bSz = dVar.bSz();
            if (dVar.getPage().adr() == 0 || bSz == null || bSz.size() < dVar.getPage().adq()) {
                if (com.baidu.tbadk.core.util.v.Z(bSz) == 0 || (com.baidu.tbadk.core.util.v.Z(bSz) == 1 && bSz.get(0) != null && bSz.get(0).cpp() == 1)) {
                    if (this.hVj == null || this.hVj.hWt == null || this.hVj.hWt.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hVj.hWt.getView().getTop() < 0 ? this.hVj.hWt.getView().getHeight() : this.hVj.hWt.getView().getBottom();
                    }
                    if (this.hMD.bUF()) {
                        this.fAd.W(this.hMD.getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.fAd.W(this.hMD.getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.hMD.bTT() != null && !this.hMD.bTT().bYv()) {
                        this.hMD.bTT().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().adr() == 0) {
                        this.fAd.setText(this.hMD.getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.fAd.setText(this.hMD.getResources().getString(R.string.load_more));
                    }
                    this.fAd.akI();
                }
                bXL();
            } else {
                if (z2) {
                    if (this.hVZ) {
                        akE();
                        if (dVar.getPage().adr() != 0) {
                            this.fAd.setText(this.hMD.getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.fAd.akz();
                        this.fAd.showLoading();
                    }
                } else {
                    this.fAd.akz();
                    this.fAd.showLoading();
                }
                this.fAd.akI();
            }
            switch (i) {
                case 2:
                    this.hTy.setSelection(i2 > 1 ? (((this.hTy.getData() == null && dVar.bSz() == null) ? 0 : (this.hTy.getData().size() - dVar.bSz().size()) + this.hTy.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bWG2 = aj.bWF().bWG()) != null) {
                        this.hTy.onRestoreInstanceState(bWG2);
                        if (com.baidu.tbadk.core.util.v.Z(bSz) > 1 && dVar.getPage().adr() > 0) {
                            this.fAd.akE();
                            this.fAd.setText(this.hMD.getString(R.string.pb_load_more_without_point));
                            this.fAd.akA();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hVZ = false;
                    break;
                case 5:
                    this.hTy.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bWG = aj.bWF().bWG()) != null) {
                        this.hTy.onRestoreInstanceState(bWG);
                        break;
                    } else {
                        this.hTy.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.hTo != null && this.hTo.aJs() != null) {
                            if (this.hMD.isUseStyleImmersiveSticky()) {
                                this.hTy.setSelectionFromTop((this.hUn.bUY() + this.hTy.getHeaderViewsCount()) - 1, this.hTo.aJs().getHeight() - com.baidu.adp.lib.util.l.u(this.hMD.getPageContext().getPageActivity()));
                            } else {
                                this.hTy.setSelectionFromTop((this.hUn.bUY() + this.hTy.getHeaderViewsCount()) - 1, this.hTo.aJs().getHeight());
                            }
                        } else {
                            this.hTy.setSelection(this.hUn.bUY() + this.hTy.getHeaderViewsCount());
                        }
                    } else {
                        this.hTy.setSelection(i2 > 0 ? ((this.hTy.getData() == null && dVar.bSz() == null) ? 0 : (this.hTy.getData().size() - dVar.bSz().size()) + this.hTy.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fAd.akE();
                    this.fAd.setText(this.hMD.getString(R.string.pb_load_more_without_point));
                    this.fAd.akA();
                    break;
            }
            if (this.hVl == hVm && isHost()) {
                bXT();
            }
            if (this.hVv) {
                bWP();
                this.hVv = false;
                if (i3 == 0) {
                    oN(true);
                }
            }
            if (this.hTq != null) {
                this.hTq.aA(dVar.bSx());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hHR == 1 || dVar.hHS == 1) {
                if (this.hVC == null) {
                    this.hVC = new PbTopTipView(this.hMD);
                }
                if (dVar.hHS == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hMD.getStType())) {
                    this.hVC.setText(this.hMD.getString(R.string.pb_read_strategy_add_experience));
                    this.hVC.show(this.euU, this.mSkinType);
                } else if (dVar.hHR == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hMD.getStType())) {
                    this.hVC.setText(this.hMD.getString(R.string.pb_read_news_add_experience));
                    this.hVC.show(this.euU, this.mSkinType);
                }
            }
            o(dVar);
        }
    }

    private void o(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSx() != null) {
            if (dVar.aaB()) {
                com.baidu.tbadk.core.util.am.c(this.hUO, (int) R.drawable.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.am.c(this.hUO, (int) R.drawable.icon_pb_bottom_collect_n);
            }
            this.hUQ.setText(yg(dVar.bSx().aeo()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, dVar.bSx()));
        }
    }

    private String yg(int i) {
        if (i == 0) {
            return this.hMD.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void bXy() {
        if (this.hTo != null && this.hTo.aJs() != null) {
            this.hTy.removeHeaderView(this.textView);
            if (this.mType != 1) {
                this.hTy.removeHeaderView(this.hTo.bZX());
                this.hTy.addHeaderView(this.hTo.bZX(), 0);
                return;
            }
            return;
        }
        if (this.hTo != null) {
            this.hTy.removeHeaderView(this.hTo.bZX());
        }
        this.hTy.removeHeaderView(this.textView);
        this.hTy.addHeaderView(this.textView, 0);
    }

    public void oU(boolean z) {
        this.hUG = z;
    }

    public void akE() {
        if (this.fAd != null) {
            this.fAd.akA();
            this.fAd.akE();
        }
        aUz();
    }

    public void aVP() {
        this.hTy.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hUU != null && this.hUU.aex() != null && this.hTu != null) {
            this.hVy = !this.hVx;
            this.hTu.pj(this.hVy);
            if (this.hMD.bTT() != null) {
                this.hMD.bTT().pi(this.hVy);
            }
            bXz();
            if (this.hMD != null && !this.hMD.bTt() && !com.baidu.tbadk.core.util.v.aa(dVar.bSS())) {
                bc bcVar = dVar.bSS().get(0);
                if (bcVar != null) {
                    this.hTu.dO(bcVar.getForumName(), bcVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hTu.dO(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hVy) {
                if (this.hUH) {
                    this.hTY.setVisibility(8);
                    this.hUa.setVisibility(0);
                    this.hUa.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.aJ(dVar.bST())));
                }
                if (this.hVe != null) {
                    this.hVe.setVisibility(8);
                }
                if (this.hVJ == null) {
                    this.hVJ = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hVA) {
                                aq.this.bXS();
                            }
                            aq.this.bXs();
                        }
                    };
                }
                this.hTy.setListViewDragListener(this.hVJ);
                return;
            }
            if (this.hVe != null) {
                this.hVe.setVisibility(0);
            }
            if (this.hUH) {
                this.hTY.setVisibility(8);
                this.hUa.setVisibility(0);
                this.hUa.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.aJ(dVar.bST())));
            } else if (!com.baidu.tbadk.t.au.avR() || (this.hUU.aex().hadConcerned() && this.hUU.aex().getGodUserData() != null && this.hUU.aex().getGodUserData().getIsFromNetWork())) {
                this.hTY.setVisibility(8);
                this.hUa.setVisibility(8);
            } else {
                this.hUa.setVisibility(8);
            }
            this.hVJ = null;
            this.hTy.setListViewDragListener(null);
        }
    }

    private void bXz() {
        String threadId = this.hPY != null ? this.hPY.getThreadId() : "";
        int bXA = bXA();
        if (this.hVy && this.hUU != null && this.hUU.aex() != null) {
            this.hUU.aex().setIsLike(this.hUU.aex().hadConcerned());
        }
        if (this.hTZ == null) {
            this.hTZ = new ao(this.hMD.getPageContext(), this.hTY, 1);
            this.hTZ.j(this.hMD.getUniqueId());
            this.hTZ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void ew(boolean z) {
                    if (aq.this.hMD != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hMD, (int) R.string.attention_success);
                    }
                }
            });
        }
        if (this.hUU != null && this.hUU.aex() != null) {
            this.hUU.aex().setIsLike(this.hUU.aex().hadConcerned());
            this.hTZ.a(this.hUU.aex());
            this.hTZ.setTid(threadId);
        }
        this.hTZ.hTj = this.hVx;
        this.hTZ.yd(bXA);
    }

    public int bXA() {
        if (this.hPY == null || this.hPY.bSx() == null) {
            return 0;
        }
        if (this.hPY.bSx().afP()) {
            return (com.baidu.tbadk.core.util.v.aa(this.hPY.bSS()) && (this.hPY.bSw() == null || StringUtils.isNull(this.hPY.bSw().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bXB() {
        return this.hPY == null || this.hPY.getForum() == null || "0".equals(this.hPY.getForum().getId()) || "me0407".equals(this.hPY.getForum().getName());
    }

    private boolean bXC() {
        boolean z;
        if (this.hUK != null && this.hUK.getVisibility() == 0) {
            if (this.hUj != null) {
                this.hUj.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hUj != null) {
                this.hUj.setVisibility(8);
            }
            z = false;
        }
        if ((this.hUl == null || this.hUl.getVisibility() == 8) && z && this.hMU) {
            this.hUk.setVisibility(0);
        } else {
            this.hUk.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bSx() == null) {
            return false;
        }
        if (dVar.bSx().aeu() == 1 || dVar.bSx().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bSx().aew() == null || dVar.bSx().aew().agx() == 0) || dVar.bSx().aes() == 1 || dVar.bSx().aet() == 1 || dVar.bSx().afi() || dVar.bSx().afx() || dVar.bSx().afq() || dVar.bSx().aeJ() != null || !com.baidu.tbadk.core.util.aq.isEmpty(dVar.bSx().getCategory()) || dVar.bSx().aeA() || dVar.bSx().aez();
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hMD.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hTG != null) {
                if (dVar.bSx() != null && dVar.bSx().aeM() == 0 && !dVar.bSx().afr() && !this.hVP) {
                    this.hTG.setVisibility(0);
                    if (dVar.bSx() != null) {
                        bg bSx = dVar.bSx();
                        bSx.m(true, q(dVar));
                        bSx.hh(3);
                        bSx.my("2");
                    }
                    SpannableStringBuilder afd = dVar.bSx().afd();
                    this.hTH.setOnTouchListener(new com.baidu.tieba.view.k(afd));
                    this.hTH.setText(afd);
                    this.hTH.setVisibility(0);
                } else if (dVar.bSx().aeM() == 1) {
                    if (dVar.bSx() != null) {
                        this.hTG.setVisibility(8);
                        this.hTy.removeHeaderView(this.hTG);
                    }
                } else {
                    this.hTG.setVisibility(8);
                    this.hTy.removeHeaderView(this.hTG);
                    if (dVar.bSx() != null && dVar.bSx().afr()) {
                        this.hTM.setPadding(this.hTM.getPaddingLeft(), 0, this.hTM.getPaddingRight(), this.hTM.getPaddingBottom());
                        if (this.hUe != null) {
                            ((RelativeLayout.LayoutParams) this.hUe.getLayoutParams()).height = (int) this.hMD.getResources().getDimension(R.dimen.tbds36);
                            this.hUe.requestLayout();
                        }
                        if (this.hUf != null) {
                            ((RelativeLayout.LayoutParams) this.hUf.getLayoutParams()).height = (int) this.hMD.getResources().getDimension(R.dimen.tbds0);
                            this.hUf.requestLayout();
                        }
                    } else {
                        this.hTM.setPadding(this.hTM.getPaddingLeft(), com.baidu.adp.lib.util.l.g(this.hMD.getPageContext().getPageActivity(), R.dimen.ds48), this.hTM.getPaddingRight(), this.hTM.getPaddingBottom());
                    }
                }
            }
            if (dVar.bSx() != null) {
                ac(dVar.bSx().aet() == 1, dVar.bSx().aes() == 1);
            }
            this.hMU = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bXC();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData c;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (dVar != null && (c = c(dVar, z)) != null) {
            String userId = c.aex().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bSJ()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (c.aex() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, c.aex().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, c.aex().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, c.aex().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, c.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bSJ()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bc> bSS = dVar.bSS();
                if (com.baidu.tbadk.core.util.v.Z(bSS) > 0) {
                    sb = new StringBuilder();
                    for (bc bcVar : bSS) {
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bIR) != null && vVar.bGK && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.i(bcVar.getForumName(), 12)).append(this.hMD.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.hMD.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View bXD() {
        return this.cze;
    }

    public boolean bXE() {
        if (this.euX == null || this.euX.getParent() == null || this.fAd.pP()) {
            return false;
        }
        int bottom = this.euX.getBottom();
        Rect rect = new Rect();
        this.euX.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void BZ(String str) {
        if (this.fAd != null) {
            this.fAd.setText(str);
        }
    }

    public void Ca(String str) {
        if (this.fAd != null) {
            int i = 0;
            if (this.hVj != null && this.hVj.hWt != null && this.hVj.hWt.getView() != null) {
                i = this.hVj.hWt.getView().getTop() < 0 ? this.hVj.hWt.getView().getHeight() : this.hVj.hWt.getView().getBottom();
            }
            this.fAd.W(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hTy;
    }

    public int bXF() {
        return R.id.richText;
    }

    public TextView bTP() {
        return this.hTL.bTP();
    }

    public void e(BdListView.e eVar) {
        this.hTy.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.caD = cVar;
        if (this.hUr != null) {
            this.hUr.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int adp = anVar.adp();
            int adm = anVar.adm();
            if (this.hUo != null) {
                this.hUo.agI();
            } else {
                this.hUo = new com.baidu.tbadk.core.dialog.a(this.hMD.getPageContext().getPageActivity());
                this.hUp = LayoutInflater.from(this.hMD.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.hUo.aH(this.hUp);
                this.hUo.a(R.string.dialog_ok, bVar);
                this.hUo.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bXH();
                        aVar.dismiss();
                    }
                });
                this.hUo.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hVs == null) {
                            aq.this.hVs = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hMD.HidenSoftKeyPad((InputMethodManager) aq.this.hMD.getSystemService("input_method"), aq.this.euU);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.iK().postDelayed(aq.this.hVs, 150L);
                    }
                });
                this.hUo.b(this.hMD.getPageContext()).agI();
            }
            this.hUq = (EditText) this.hUp.findViewById(R.id.input_page_number);
            this.hUq.setText("");
            TextView textView = (TextView) this.hUp.findViewById(R.id.current_page_number);
            if (adp <= 0) {
                adp = 1;
            }
            if (adm <= 0) {
                adm = 1;
            }
            textView.setText(MessageFormat.format(this.hMD.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(adp), Integer.valueOf(adm)));
            this.hMD.ShowSoftKeyPadDelay(this.hUq, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hTy.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hMD.showToast(str);
    }

    public boolean oV(boolean z) {
        if (this.TU == null || !this.TU.asb()) {
            return false;
        }
        this.TU.aqu();
        return true;
    }

    public void bXG() {
        if (this.hWc != null) {
            while (this.hWc.size() > 0) {
                TbImageView remove = this.hWc.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bXG();
        this.hUn.xO(1);
        if (this.hTo != null) {
            this.hTo.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hUn.xO(2);
        if (this.hTo != null) {
            this.hTo.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.hMD) && !TbSingleton.getInstance().isCutoutScreen(this.hMD)) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hVu != null) {
            this.hVu.destroy();
        }
        if (this.hVL != null) {
            this.hVL.onDestory();
        }
        if (this.hVC != null) {
            this.hVC.hide();
        }
        if (this.hTr != null) {
            this.hTr.bbz();
        }
        if (this.hTq != null) {
            this.hTq.onDestroy();
        }
        this.hMD.hideProgressBar();
        if (this.eWV != null && this.fru != null) {
            this.eWV.b(this.fru);
        }
        bXH();
        akE();
        if (this.hVs != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hVs);
        }
        if (this.hTM != null && this.hTX != null) {
            this.hTM.removeView(this.hTS);
            this.hTX = null;
        }
        if (this.hUZ != null) {
            this.hUZ.clearStatus();
        }
        this.hVV = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hUn.xO(3);
        if (this.fwl != null) {
            this.fwl.setBackgroundDrawable(null);
        }
        if (this.hTo != null) {
            this.hTo.destroy();
        }
        if (this.hUn != null) {
            this.hUn.onDestroy();
        }
        this.hTy.setOnLayoutListener(null);
        if (this.hVH != null) {
            this.hVH.bos();
        }
        if (this.hVk != null) {
            this.hVk.onDestroy();
        }
    }

    public boolean yh(int i) {
        if (this.hTo != null) {
            return this.hTo.rR(i);
        }
        return false;
    }

    public void bXH() {
        this.hTu.UM();
        if (this.hTr != null) {
            this.hTr.bbz();
        }
        com.baidu.adp.lib.util.l.b(this.hMD.getPageContext().getPageActivity(), this.hUq);
        bWR();
        if (this.hKI != null) {
            this.hKI.dismiss();
        }
        bXJ();
        if (this.hTq != null) {
            this.hTq.bZM();
        }
        if (this.hUo != null) {
            this.hUo.dismiss();
        }
        if (this.fvX != null) {
            this.fvX.dismiss();
        }
    }

    public void bXI() {
        this.hTu.UM();
        if (this.hTr != null) {
            this.hTr.bbz();
        }
        if (this.hKI != null) {
            this.hKI.dismiss();
        }
        bXJ();
        if (this.hTq != null) {
            this.hTq.bZM();
        }
        if (this.hUo != null) {
            this.hUo.dismiss();
        }
        if (this.fvX != null) {
            this.fvX.dismiss();
        }
    }

    public void dK(List<String> list) {
        this.hVG = list;
        if (this.hVH != null) {
            this.hVH.setData(list);
        }
    }

    public void og(boolean z) {
        this.hUn.og(z);
    }

    public void oW(boolean z) {
        this.hUJ = z;
    }

    public void bXJ() {
        if (this.hUx != null) {
            this.hUx.dismiss();
        }
        if (this.hUy != null) {
            com.baidu.adp.lib.g.g.b(this.hUy, this.hMD.getPageContext());
        }
        if (this.hUz != null) {
            com.baidu.adp.lib.g.g.b(this.hUz, this.hMD.getPageContext());
        }
        if (this.hUv != null) {
            this.hUv.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hPY, this.hMU);
            d(this.hPY, this.hMU, this.mType);
            this.hMD.getLayoutMode().setNightMode(i == 1);
            this.hMD.getLayoutMode().onModeChanged(this.euU);
            this.hMD.getLayoutMode().onModeChanged(this.hTA);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.am.l(this.euU, R.color.cp_bg_line_d);
            }
            if (this.hTq != null) {
                this.hTq.onChangeSkinType(i);
            }
            if (this.hTB != null) {
                com.baidu.tbadk.core.util.am.l(this.hTB, R.color.cp_bg_line_c);
            }
            if (this.hTC != null) {
                this.hTC.setIsNight(this.mSkinType == 1);
            }
            if (this.hTD != null) {
                com.baidu.tbadk.core.util.am.j(this.hTD, R.color.cp_cont_b);
            }
            if (this.hTE != null) {
                com.baidu.tbadk.core.util.am.j(this.hTE, R.color.cp_cont_j);
            }
            if (this.hTF != null) {
                com.baidu.tbadk.core.util.am.k(this.hTF, R.drawable.icon_common_arrow16_right_n);
            }
            if (this.hTH != null) {
                com.baidu.tbadk.core.util.am.j(this.hTH, R.color.cp_cont_b);
                this.hTH.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            }
            if (this.fAd != null) {
                this.fAd.iV(i);
                if (this.cze != null) {
                    this.hMD.getLayoutMode().onModeChanged(this.cze);
                    com.baidu.tbadk.core.util.am.k(this.cze, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.hUo != null) {
                this.hUo.c(this.hMD.getPageContext());
            }
            oU(this.hUG);
            this.hUn.notifyDataSetChanged();
            if (this.hUr != null) {
                this.hUr.iV(i);
            }
            if (this.TU != null) {
                this.TU.onChangeSkinType(i);
            }
            if (this.hTW != null) {
                this.hTW.jc(i);
            }
            if (this.hUs != null) {
                this.hUs.iV(i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.eER)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.eER) {
                    customBlueCheckRadioButton.akh();
                }
            }
            bXh();
            UtilHelper.setStatusBarBackground(this.fwl, i);
            UtilHelper.setStatusBarBackground(this.hVe, i);
            if (this.hTY != null) {
                this.hTY.onChangeSkinType(i);
            }
            if (this.hUc != null) {
                com.baidu.tbadk.core.util.am.j(this.hUc, R.color.cp_cont_d);
            }
            if (this.hUb != null) {
                com.baidu.tbadk.core.util.am.j(this.hUb, R.color.cp_cont_d);
            }
            if (this.hUd != null) {
                com.baidu.tbadk.core.util.am.j(this.hUd, R.color.cp_cont_d);
            }
            if (this.hUa != null) {
                com.baidu.tbadk.core.util.am.j(this.hUa, R.color.cp_cont_d);
            }
            if (this.hUg != null) {
                com.baidu.tbadk.s.a.a(this.hMD.getPageContext(), this.hUg);
            }
            if (this.hVt != null) {
                this.hVt.onChangeSkinType(i);
            }
            if (this.hTu != null) {
                if (this.hTo != null) {
                    this.hTo.ym(i);
                } else {
                    this.hTu.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.gmp != null) {
                com.baidu.tbadk.core.util.am.j(this.gmp, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.am.k(this.gmp, R.drawable.bg_comment_input);
            }
            if (this.hUO != null && this.hPY != null) {
                if (this.hPY.aaB()) {
                    com.baidu.tbadk.core.util.am.c(this.hUO, (int) R.drawable.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.am.c(this.hUO, (int) R.drawable.icon_pb_bottom_collect_n);
                }
            }
            if (this.hUP != null) {
                com.baidu.tbadk.core.util.am.c(this.hUP, (int) R.drawable.icon_pb_bottom_share_n);
            }
            if (this.hUN != null) {
                com.baidu.tbadk.core.util.am.c(this.hUN, (int) R.drawable.icon_pb_bottom_comment_n);
            }
            com.baidu.tbadk.core.util.am.j(this.hUQ, R.color.cp_cont_b);
            if (this.hTQ != null) {
                com.baidu.tbadk.core.util.am.c(this.hTQ, BitmapHelper.getGradeResourceIdInEnterForum(this.hVB));
            }
            if (this.hVI != null) {
                this.hVI.onChangeSkinType(i);
            }
            if (this.hVk != null) {
                this.hVk.onChangeSkinType();
            }
            if (this.hVE != null) {
                com.baidu.tbadk.core.util.am.j(this.hVE, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.l(this.hUM, R.color.cp_bg_line_d);
            if (this.hTP != null) {
                com.baidu.tbadk.core.util.am.k(this.hTP, this.hVN);
                com.baidu.tbadk.core.util.am.j(this.hTP, R.color.cp_btn_a);
            }
            if (this.hTz != null) {
                this.hTz.nz(i);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKh = hVar;
        this.hUn.setOnImageClickListener(this.cKh);
        this.hVI.setOnImageClickListener(this.cKh);
    }

    public void h(NoNetworkView.a aVar) {
        this.fru = aVar;
        if (this.eWV != null) {
            this.eWV.a(this.fru);
        }
    }

    public void oX(boolean z) {
        this.hUn.setIsFromCDN(z);
    }

    public Button bXK() {
        return this.hUK;
    }

    public void bXL() {
        if (this.hTt != 2) {
            this.hTy.setNextPage(this.fAd);
            this.hTt = 2;
        }
    }

    public void bXM() {
        if (com.baidu.tbadk.p.m.avt().avu()) {
            int lastVisiblePosition = this.hTy.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hTy.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog = tbImageView.getPerfLog();
                                perfLog.kQ(1001);
                                perfLog.czM = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(R.id.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.p.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.kQ(1001);
                        perfLog2.czM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bXN() {
        return this.TU != null && this.TU.getVisibility() == 0;
    }

    public boolean bXO() {
        return this.TU != null && this.TU.asb();
    }

    public void bXP() {
        if (this.TU != null) {
            this.TU.aqu();
        }
    }

    public void oY(boolean z) {
        if (this.hUM != null) {
            oW(this.hMD.bTQ().asF());
            if (this.hUJ) {
                oO(z);
            } else {
                oP(z);
            }
        }
    }

    public void bXQ() {
        if (this.hUM != null) {
            this.hUL.setVisibility(8);
            this.hUM.setVisibility(8);
            this.hUR = false;
            if (this.hVk != null) {
                this.hVk.setVisibility(8);
                oS(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.eMs == null) {
            this.eMs = new com.baidu.tbadk.core.view.b(this.hMD.getPageContext());
        }
        this.eMs.ej(true);
    }

    public void aUz() {
        if (this.eMs != null) {
            this.eMs.ej(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hTy.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hTy.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hTo != null) {
            this.hTo.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hWd = getScrollY();
            this.hVj.hWt = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hVj));
            a(this.hVj.hWt, true);
        }
    }

    public void oZ(boolean z) {
        this.hTo.oZ(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hTo != null) {
            this.hTo.b(absListView, i);
        }
        if (this.hTu != null && this.hUn != null) {
            this.hTu.a(this.hUn.bVd());
        }
        this.hVj.hCL = i;
        this.hVj.headerCount = this.hTy.getHeaderViewsCount();
        this.hVj.hWt = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hVj));
        a(this.hVj.hWt, false);
        if (this.fAd.akK() && !this.fAd.cas) {
            if (this.hVj != null && this.hVj.hWt != null && this.hVj.hWt.getView() != null) {
                i4 = this.hVj.hWt.getView().getTop() < 0 ? this.hVj.hWt.getView().getHeight() : this.hVj.hWt.getView().getBottom();
            }
            this.fAd.iY(i4);
            this.fAd.cas = true;
        }
    }

    public void bXR() {
        if (this.hMD.isLogin() && this.hPY != null && this.hVy && !this.hVx && !this.hUH && this.hUU != null && this.hUU.aex() != null && !this.hUU.aex().getIsLike() && !this.hUU.aex().hadConcerned() && this.hVu == null) {
            this.hVu = new an(this.hMD);
        }
    }

    public void bXS() {
        if (this.hVy && !this.hVx && this.hUU != null && this.hUU.aex() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").P("obj_locate", this.hMD.bTt() ? 2 : 1).P("obj_type", this.hVx ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hMD.getPageContext().getPageActivity(), this.hUU.aex().getUserId(), this.hUU.aex().getUserName(), this.hMD.bTD().bTu(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hVx && this.hVd != null && this.hTu.bYB() != null) {
            int bUZ = this.hUn.bUZ();
            if (bUZ > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bUZ > this.hTy.getFirstVisiblePosition() - this.hTy.getHeaderViewsCount()) {
                    this.hVd.setVisibility(8);
                    return;
                }
                this.hVd.setVisibility(0);
                bYc();
                this.hTu.mNavigationBar.hideBottomLine();
                if (this.hVd.getParent() != null && ((ViewGroup) this.hVd.getParent()).getHeight() <= this.hVd.getTop()) {
                    this.hVd.getParent().requestLayout();
                }
            } else if (alVar == null || alVar.getView() == null || alVar.hSS == null) {
                if (this.hTy.getFirstVisiblePosition() == 0) {
                    this.hVd.setVisibility(8);
                    this.hTu.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hVi) {
                        this.hVh = top;
                        this.hVi = false;
                    }
                    this.hVh = top < this.hVh ? top : this.hVh;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hUm.getY() < 0.0f) {
                        measuredHeight = hVg - alVar.hSS.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hTu.bYB().getMeasuredHeight() - alVar.hSS.getMeasuredHeight();
                        this.hTu.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hVh) {
                        this.hVd.setVisibility(0);
                        bYc();
                    } else if (top < measuredHeight) {
                        this.hVd.setVisibility(0);
                        bYc();
                    } else {
                        this.hVd.setVisibility(8);
                        this.hTu.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hVi = true;
                    }
                }
            }
        }
    }

    public void bXT() {
        if (!this.hWe) {
            TiebaStatic.log("c10490");
            this.hWe = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hMD.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hVn, Integer.valueOf(hVp));
            aVar.ht(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hMD.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aH(inflate);
            aVar.ab(sparseArray);
            aVar.a(R.string.grade_button_tips, this.hMD);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hMD.getPageContext()).agI();
        }
    }

    public void Cb(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hMD.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hMD.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aH(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hVn, Integer.valueOf(hVq));
        aVar.ab(sparseArray);
        aVar.a(R.string.view, this.hMD);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hMD.getPageContext()).agI();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(dVar, z)) != null && c.aex() != null) {
            MetaData aex = c.aex();
            aex.setGiftNum(aex.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bXU() {
        return this.hUZ;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSx() != null && dVar.bSx().afx() && this.hUZ == null) {
            this.hUZ = (PbInterviewStatusView) this.hUY.inflate();
            this.hUZ.setOnClickListener(this.fvY);
            this.hUZ.setCallback(this.hMD.bUB());
            this.hUZ.setData(this.hMD, dVar);
        }
    }

    public LinearLayout bXV() {
        return this.hUm;
    }

    public View bXW() {
        return this.fwl;
    }

    public boolean bXX() {
        return this.hVP;
    }

    public void ol(boolean z) {
        this.hTL.ol(z);
    }

    public void Cc(String str) {
        if (this.hTv != null) {
            this.hTv.setTitle(str);
        }
    }

    private int pa(boolean z) {
        if (this.hUZ == null || this.hUZ.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.g(this.hMD.getPageContext().getPageActivity(), R.dimen.ds72);
    }

    private void bXY() {
        if (this.hUZ != null && this.hUZ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hUZ.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hUZ.setLayoutParams(layoutParams);
        }
    }

    public boolean bTV() {
        return false;
    }

    public void Cd(String str) {
        this.gmp.performClick();
        if (!StringUtils.isNull(str) && this.hMD.bTQ() != null && this.hMD.bTQ().asy() != null && this.hMD.bTQ().asy().getInputView() != null) {
            EditText inputView = this.hMD.bTQ().asy().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bXH();
            if (configuration.orientation == 2) {
                bXQ();
                bWR();
            } else {
                bWU();
            }
            if (this.hVt != null) {
                this.hVt.bVi();
            }
            this.hMD.bmk();
            this.hUm.setVisibility(8);
            this.hTu.pk(false);
            this.hMD.or(false);
            if (this.hTo != null) {
                if (configuration.orientation == 1) {
                    bXV().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hTy.setIsLandscape(true);
                    this.hTy.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hTy.setIsLandscape(false);
                    if (this.hWd > 0) {
                        this.hTy.smoothScrollBy(this.hWd, 0);
                    }
                }
                this.hTo.onConfigurationChanged(configuration);
                this.hVc.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void pb(boolean z) {
        this.hTs = z;
    }

    public boolean bXZ() {
        return this.hTo != null && this.hTo.bXZ();
    }

    public void bYa() {
        if (this.hTo != null) {
            this.hTo.onPause();
        }
    }

    public void q(long j, int i) {
        if (this.hTq != null) {
            this.hTq.q(j, i);
        }
        if (this.hTo != null) {
            this.hTo.q(j, i);
        }
    }

    public void ow(boolean z) {
        this.hUn.ow(z);
    }

    public void bYb() {
        if (this.hVa == null) {
            LayoutInflater.from(this.hMD.getActivity()).inflate(R.layout.add_experienced_text, (ViewGroup) this.euU, true);
            this.hVa = (ViewGroup) this.euU.findViewById(R.id.add_experienced_layout);
            this.hVb = (TextView) this.euU.findViewById(R.id.add_experienced);
            com.baidu.tbadk.core.util.am.j(this.hVb, R.color.cp_btn_a);
            String string = this.hMD.getResources().getString(R.string.experienced_add_success);
            String string2 = this.hMD.getResources().getString(R.string.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_h)));
            this.hVb.setText(spannableString);
        }
        this.hVa.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.27
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.aq.27.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        aq.this.hVa.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hVb.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hVb.startAnimation(scaleAnimation);
    }

    public void cE(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hUM.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hMD);
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.hVE = new TextView(this.hMD);
            this.hVE.setText(R.string.connection_tips);
            this.hVE.setGravity(17);
            this.hVE.setPadding(com.baidu.adp.lib.util.l.g(this.hMD, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(this.hMD, R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hMD, R.dimen.ds60);
            if (this.hVE.getParent() == null) {
                frameLayout.addView(this.hVE, layoutParams);
            }
            this.hVD = new PopupWindow(this.hMD);
            this.hVD.setContentView(frameLayout);
            this.hVD.setHeight(-2);
            this.hVD.setWidth(-2);
            this.hVD.setFocusable(true);
            this.hVD.setOutsideTouchable(false);
            this.hVD.setBackgroundDrawable(new ColorDrawable(this.hMD.getResources().getColor(R.color.transparent)));
            this.hTy.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hVD.showAsDropDown(aq.this.hUM, view.getLeft(), -aq.this.hUM.getHeight());
                    } else {
                        aq.this.hVD.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bYc() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_long_press_tips", false) && this.hVF == null) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_long_press_tips", true);
            this.hVF = new com.baidu.tbadk.core.dialog.a(this.hMD);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hMD);
            this.hVF.hx(1);
            this.hVF.aH(pbLongPressTipView);
            this.hVF.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hVF.dR(false);
            this.hVF.b(this.hMD.getPageContext()).agI();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hVF != null && aq.this.hVF.isShowing()) {
                        aq.this.hVF.dismiss();
                    }
                }
            }, 5000L);
            if (this.hTo != null) {
                this.hTo.bZW();
            }
        }
    }

    public void pc(boolean z) {
        this.hVK = z;
    }

    public boolean bYd() {
        return this.hVK;
    }

    public PbThreadPostView bYe() {
        return this.hTz;
    }

    private void ac(boolean z, boolean z2) {
        ad(z, z2);
        ae(z, z2);
        if (this.hUn != null && this.hUn.bVe() != null) {
            this.hUn.bVe().W(z, z2);
        }
    }

    private void ad(boolean z, boolean z2) {
        if (z && z2) {
            this.hTJ.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hTJ.setVisibility(0);
        } else if (z) {
            this.hTJ.setImageResource(R.drawable.pic_pb_refined_n);
            this.hTJ.setVisibility(0);
        } else if (z2) {
            this.hTJ.setImageResource(R.drawable.pic_pb_stick_n);
            this.hTJ.setVisibility(0);
        } else {
            this.hTJ.setVisibility(8);
        }
    }

    private void ae(boolean z, boolean z2) {
        if (this.hTG != null && this.hPY != null && this.hPY.bSx() != null && this.hPY.bSx().aeM() == 0 && !this.hPY.bSx().afr()) {
            if (z && z2) {
                this.hTK.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.hTK.setVisibility(0);
            } else if (z) {
                this.hTK.setImageResource(R.drawable.pic_pb_refined_n);
                this.hTK.setVisibility(0);
            } else if (z2) {
                this.hTK.setImageResource(R.drawable.pic_pb_stick_n);
                this.hTK.setVisibility(0);
            } else {
                this.hTK.setVisibility(8);
            }
        }
    }
}
