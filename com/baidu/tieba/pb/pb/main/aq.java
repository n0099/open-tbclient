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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
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
    private EditorTools TT;
    private TextView ajd;
    private View cAh;
    private h.c cbC;
    private com.baidu.tieba.pb.a.c cmw;
    private List<CustomBlueCheckRadioButton> eGH;
    private NoNetworkView eYL;
    private int eju;
    private RelativeLayout ewL;
    private View ewO;
    private PbListView fCE;
    private NavigationBarCoverTip fUZ;
    private com.baidu.tieba.NEGFeedBack.e fXS;
    private View.OnClickListener fyk;
    private View fyx;
    private TextView goY;
    PbActivity.d hOz;
    private View.OnClickListener hPT;
    private PbActivity hPu;
    private UserIconBox hQH;
    private UserIconBox hQI;
    private PbFakeFloorModel hRI;
    private com.baidu.tieba.pb.data.d hSQ;
    private RelativeLayout hWB;
    private ImageView hWC;
    private ImageView hWD;
    private e hWE;
    private ColumnLayout hWF;
    private ThreadSkinView hWG;
    private TextView hWH;
    private TextView hWI;
    private ImageView hWJ;
    private HeadPendantView hWK;
    private FrameLayout hWL;
    private HeadImageView hWM;
    private View hWN;
    private LinearLayout hWO;
    private PbFirstFloorUserLikeButton hWR;
    private ao hWS;
    private TextView hWT;
    private TextView hWU;
    private TextView hWV;
    private TextView hWW;
    private View hWX;
    private View hWY;
    private LinearLayout hWZ;
    public int hWg;
    public com.baidu.tieba.pb.video.i hWh;
    private long hWi;
    private com.baidu.tieba.pb.video.h hWj;
    private com.baidu.tieba.c.d hWk;
    public final com.baidu.tieba.pb.pb.main.view.c hWn;
    public com.baidu.tieba.pb.pb.main.view.b hWo;
    private ViewStub hWp;
    private ViewStub hWq;
    private PbLandscapeListView hWr;
    private PbThreadPostView hWs;
    private View hWt;
    private RelativeLayout hWu;
    private HeadImageView hWv;
    private TextView hWw;
    private TextView hWx;
    private ImageView hWy;
    private View hXE;
    private View hXF;
    private ImageView hXG;
    private ImageView hXH;
    private ImageView hXI;
    private TextView hXJ;
    private int hXL;
    private int hXM;
    private PostData hXN;
    private View hXP;
    private TextView hXQ;
    private ViewStub hXR;
    private PbInterviewStatusView hXS;
    private ViewGroup hXT;
    private TextView hXU;
    private FrameLayout hXV;
    private View hXW;
    private View hXX;
    private al hXY;
    private TextView hXa;
    private TextView hXb;
    private View hXc;
    private View hXd;
    private ObservedChangeLinearLayout hXf;
    private f hXg;
    private View hXm;
    private com.baidu.tieba.pb.pb.main.emotion.c hYA;
    private com.baidu.tieba.pb.pb.godreply.a hYB;
    private PbLandscapeListView.b hYC;
    private ac hYE;
    private String hYF;
    private boolean hYI;
    private com.baidu.tbadk.core.view.userLike.c hYJ;
    private com.baidu.tbadk.core.view.userLike.c hYK;
    private Runnable hYP;
    private PbActivity.b hYR;
    public int hYW;
    private PbEmotionBar hYd;
    private Runnable hYl;
    private s hYm;
    private an hYn;
    private int hYt;
    private PbTopTipView hYv;
    private PopupWindow hYw;
    private TextView hYx;
    private com.baidu.tbadk.core.dialog.a hYy;
    private List<String> hYz;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    private int mType;
    private static final int hXZ = UtilHelper.getLightStatusBarHeight();
    public static int hYf = 3;
    public static int hYg = 0;
    public static int hYh = 3;
    public static int hYi = 4;
    public static int hYj = 5;
    public static int hYk = 6;
    private static a.InterfaceC0423a hYH = new a.InterfaceC0423a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0423a
        public void onRefresh() {
        }
    };
    private boolean hWl = false;
    private int hWm = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hWz = null;
    private TextView hWA = null;
    public FrsPraiseView hWP = null;
    private ClickableHeaderImageView hWQ = null;
    private View hXe = null;
    private com.baidu.tbadk.core.dialog.a hXh = null;
    private com.baidu.tbadk.core.dialog.b fyj = null;
    private View hXi = null;
    private EditText hXj = null;
    private com.baidu.tieba.pb.view.c hXk = null;
    private com.baidu.tieba.pb.view.a hXl = null;
    private com.baidu.tbadk.core.dialog.a hXn = null;
    private b.a gMD = null;
    private TbRichTextView.h cLe = null;
    private NoNetworkView.a ftG = null;
    private com.baidu.tbadk.core.dialog.i hXo = null;
    private View hXp = null;
    private com.baidu.tbadk.core.dialog.a hXq = null;
    private Dialog hXr = null;
    private Dialog hXs = null;
    private View hXt = null;
    private LinearLayout hXu = null;
    private CompoundButton.OnCheckedChangeListener eGI = null;
    private TextView hXv = null;
    private TextView hXw = null;
    private String hXx = null;
    private com.baidu.tbadk.core.dialog.i hNz = null;
    private com.baidu.tbadk.core.dialog.i hXy = null;
    private boolean hXz = false;
    private boolean hXA = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hXB = null;
    private boolean hXC = false;
    private Button hXD = null;
    private boolean hXK = true;
    private com.baidu.tbadk.core.view.b eOg = null;
    private boolean hPL = false;
    private int mSkinType = 3;
    private boolean hXO = false;
    private int hYa = 0;
    private boolean hYb = true;
    public a hYc = new a();
    private int hYe = 0;
    private boolean hYo = false;
    private int hYp = 0;
    private boolean hYq = false;
    private boolean hYr = false;
    private boolean hYs = false;
    private int hYu = 0;
    private boolean hYD = false;
    private int hYG = R.drawable.bg_user_identity_btn;
    private String hYL = null;
    private CustomMessageListener hYM = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hYL = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hXg != null) {
                aq.this.hXg.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hYN = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hWA != null) {
                aq.this.hWA.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hYO = new Handler();
    private CustomMessageListener hYQ = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hXK = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hYS = true;
    View.OnClickListener hYT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hYq) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").P(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hYq && aq.this.hSQ != null && aq.this.hSQ.bTy() != null && aq.this.hSQ.bTy().aeC() != null && aq.this.hSQ.bTy().aeC().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").P("obj_locate", 1));
            }
            aq.this.hPu.hNu.fYB.onClick(view);
        }
    };
    private boolean hYU = false;
    String userId = null;
    private final List<TbImageView> hYV = new ArrayList();
    private boolean hYX = false;

    /* loaded from: classes4.dex */
    public static class a {
        public int hFz;
        public al hZm;
        public int headerCount;
    }

    public void oR(boolean z) {
        this.hYo = z;
        if (this.hWr != null) {
            this.hYp = this.hWr.getHeaderViewsCount();
        }
    }

    public void bXT() {
        if (this.hWr != null) {
            int headerViewsCount = this.hWr.getHeaderViewsCount() - this.hYp;
            final int firstVisiblePosition = (this.hWr.getFirstVisiblePosition() == 0 || this.hWr.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hWr.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hWr.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hYc.hZm = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hYc));
            final al alVar = this.hYc.hZm;
            final int h = h(alVar);
            final int y = ((int) this.hXf.getY()) + this.hXf.getMeasuredHeight();
            final boolean z = this.hXW.getVisibility() == 0;
            boolean z2 = this.hXf.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hXg.bWc() + this.hWr.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hVL.getMeasuredHeight() : 0;
                if (z2) {
                    this.hWr.setSelectionFromTop(this.hXg.bWc() + this.hWr.getHeaderViewsCount(), hXZ - measuredHeight);
                } else {
                    this.hWr.setSelectionFromTop(this.hXg.bWc() + this.hWr.getHeaderViewsCount(), this.hWn.bZF().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hWr.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hYq) {
                this.hWr.setSelectionFromTop(this.hXg.bWc() + this.hWr.getHeaderViewsCount(), this.hWh.aJY().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hWr.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bWu() {
                        if (h >= 0 && h <= aq.this.ewL.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.ewO.getLayoutParams();
                            if (i == 0 || i > aq.this.ewL.getMeasuredHeight() || h2 >= aq.this.ewL.getMeasuredHeight()) {
                                layoutParams.height = aq.this.eju;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.ewL.getMeasuredHeight()) {
                                layoutParams.height = aq.this.eju;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hWr.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.ewO.setLayoutParams(layoutParams);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (aq.this.ewO != null && aq.this.ewO.getLayoutParams() != null) {
                                        ViewGroup.LayoutParams layoutParams2 = aq.this.ewO.getLayoutParams();
                                        layoutParams2.height = aq.this.eju;
                                        aq.this.ewO.setLayoutParams(layoutParams2);
                                    }
                                }
                            });
                        }
                        aq.this.hWr.setOnLayoutListener(null);
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

    public NoNetworkView bXU() {
        return this.eYL;
    }

    public void bXV() {
        if (this.TT != null) {
            this.TT.hide();
            if (this.hYA != null) {
                this.hYA.aIQ();
            }
        }
    }

    public PbFakeFloorModel bXW() {
        return this.hRI;
    }

    public s bXX() {
        return this.hYm;
    }

    public void bXY() {
        reset();
        bXV();
        this.hYm.bWl();
        pc(false);
    }

    private void reset() {
        if (this.hPu != null && this.hPu.bUR() != null && this.TT != null) {
            com.baidu.tbadk.editortools.pb.a.asJ().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bUR = this.hPu.bUR();
            bUR.atc();
            bUR.asx();
            if (bUR.getWriteImagesInfo() != null) {
                bUR.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bUR.kz(SendView.ALL);
            bUR.kA(SendView.ALL);
            com.baidu.tbadk.editortools.g kq = this.TT.kq(23);
            com.baidu.tbadk.editortools.g kq2 = this.TT.kq(2);
            com.baidu.tbadk.editortools.g kq3 = this.TT.kq(5);
            if (kq2 != null) {
                kq2.ql();
            }
            if (kq3 != null) {
                kq3.ql();
            }
            if (kq != null) {
                kq.hide();
            }
            this.TT.invalidate();
        }
    }

    public boolean bXZ() {
        return this.hXK;
    }

    public void oS(boolean z) {
        if (this.hXF != null && this.goY != null) {
            this.goY.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hXF.startAnimation(alphaAnimation);
            }
            this.hXE.setVisibility(0);
            this.hXF.setVisibility(0);
            this.hXK = true;
            if (this.hYd != null && !this.hYB.isActive()) {
                this.hYd.setVisibility(0);
                oW(true);
            }
        }
    }

    public void oT(boolean z) {
        if (this.hXF != null && this.goY != null) {
            this.goY.setText(bYa());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hXF.startAnimation(alphaAnimation);
            }
            this.hXE.setVisibility(0);
            this.hXF.setVisibility(0);
            this.hXK = true;
            if (this.hYd != null && !this.hYB.isActive()) {
                this.hYd.setVisibility(0);
                oW(true);
            }
        }
    }

    public String bYa() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.hYF)) {
            return this.hYF;
        }
        if (this.hPu != null) {
            this.hYF = this.hPu.getResources().getString(ap.bXS());
        }
        return this.hYF;
    }

    public PostData bYb() {
        int i = 0;
        if (this.hWr == null) {
            return null;
        }
        int bYc = bYc() - this.hWr.getHeaderViewsCount();
        if (bYc < 0) {
            bYc = 0;
        }
        if (this.hXg.xS(bYc) != null && this.hXg.xS(bYc) != PostData.jiz) {
            i = bYc + 1;
        }
        return this.hXg.getItem(i) instanceof PostData ? (PostData) this.hXg.getItem(i) : null;
    }

    public int bYc() {
        int i;
        View childAt;
        if (this.hWr == null) {
            return 0;
        }
        int firstVisiblePosition = this.hWr.getFirstVisiblePosition();
        int lastVisiblePosition = this.hWr.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hWr.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hWr.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bYd() {
        return this.hWr.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hSQ != null && this.hSQ.bTA() != null && !this.hSQ.bTA().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hSQ.bTA().size() && (postData = this.hSQ.bTA().get(i)) != null && postData.aeC() != null && !StringUtils.isNull(postData.aeC().getUserId()); i++) {
                if (this.hSQ.bTA().get(i).aeC().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hYB != null && this.hYB.isActive()) {
                        pc(false);
                    }
                    if (this.hYd != null) {
                        this.hYd.pk(true);
                    }
                    this.hYL = postData.aeC().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hPu = null;
        this.ewL = null;
        this.fyx = null;
        this.hWi = 0L;
        this.hWr = null;
        this.hWt = null;
        this.hWB = null;
        this.hWF = null;
        this.hWH = null;
        this.hWI = null;
        this.hWL = null;
        this.hWM = null;
        this.hWN = null;
        this.hWR = null;
        this.hWT = null;
        this.hWU = null;
        this.hWV = null;
        this.hWW = null;
        this.hXc = null;
        this.hXd = null;
        this.hXg = null;
        this.fCE = null;
        this.cAh = null;
        this.fyk = null;
        this.hPT = null;
        this.hXF = null;
        this.goY = null;
        this.hXP = null;
        this.hXQ = null;
        this.hXR = null;
        this.hYt = 0;
        this.hWi = System.currentTimeMillis();
        this.hPu = pbActivity;
        this.fyk = onClickListener;
        this.cmw = cVar;
        this.hYt = com.baidu.adp.lib.util.l.af(this.hPu) / 2;
        this.ewL = (RelativeLayout) LayoutInflater.from(this.hPu.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.hPu.addContentView(this.ewL, new FrameLayout.LayoutParams(-1, -1));
        this.fUZ = (NavigationBarCoverTip) this.hPu.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.fyx = this.hPu.findViewById(R.id.statebar_view);
        this.hXf = (ObservedChangeLinearLayout) this.hPu.findViewById(R.id.title_wrapper);
        this.eYL = (NoNetworkView) this.hPu.findViewById(R.id.view_no_network);
        this.hWr = (PbLandscapeListView) this.hPu.findViewById(R.id.new_pb_list);
        this.hXV = (FrameLayout) this.hPu.findViewById(R.id.root_float_header);
        this.ajd = new TextView(this.hPu.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.hPu.getActivity(), R.dimen.ds88));
        this.hWr.addHeaderView(this.ajd, 0);
        this.eju = this.hPu.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.ewO = new View(this.hPu.getPageContext().getPageActivity());
        this.ewO.setLayoutParams(new AbsListView.LayoutParams(-1, this.eju));
        this.ewO.setVisibility(4);
        this.hWr.addFooterView(this.ewO);
        this.hWr.setOnTouchListener(this.hPu.cnr);
        this.hWn = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.hPu.bVv()) {
            this.hWp = (ViewStub) this.hPu.findViewById(R.id.manga_view_stub);
            this.hWp.setVisibility(0);
            this.hWo = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.hWo.show();
            this.hWn.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hPu.getActivity(), R.dimen.ds120);
        }
        this.ajd.setLayoutParams(layoutParams);
        this.hWn.bZF().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0383a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0383a
            public void bUo() {
                if (aq.this.hWr != null) {
                    if (aq.this.hWh != null) {
                        aq.this.hWh.cba();
                    }
                    aq.this.hWr.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0383a
            public void bUp() {
                aq.this.hPu.bnf();
            }
        }));
        this.hXE = this.hPu.findViewById(R.id.view_comment_top_line);
        this.hXF = this.hPu.findViewById(R.id.pb_editor_tool_comment);
        this.hXL = com.baidu.adp.lib.util.l.g(this.hPu.getPageContext().getPageActivity(), R.dimen.tbds120);
        this.hXM = com.baidu.adp.lib.util.l.g(this.hPu.getPageContext().getPageActivity(), R.dimen.ds242);
        this.goY = (TextView) this.hPu.getPageContext().getPageActivity().findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.goY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hPu.bVb();
                if (aq.this.hPu != null && aq.this.hPu.bUE() != null && aq.this.hPu.bUE().getPbData() != null && aq.this.hPu.bUE().getPbData().bTy() != null && aq.this.hPu.bUE().getPbData().bTy().aeC() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bT("tid", aq.this.hPu.bUE().hSu).bT("fid", aq.this.hPu.bUE().getPbData().getForumId()).P("obj_locate", 1).bT("uid", aq.this.hPu.bUE().getPbData().bTy().aeC().getUserId()));
                }
            }
        });
        this.hXG = (ImageView) this.hPu.findViewById(R.id.pb_editor_tool_comment_icon);
        this.hXG.setOnClickListener(this.fyk);
        this.hXH = (ImageView) this.hPu.findViewById(R.id.pb_editor_tool_collection);
        this.hXH.setOnClickListener(this.fyk);
        this.hXI = (ImageView) this.hPu.findViewById(R.id.pb_editor_tool_share);
        this.hXI.setOnClickListener(this.fyk);
        this.hXJ = (TextView) this.hPu.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.hWt = LayoutInflater.from(this.hPu.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.hWB = (RelativeLayout) LayoutInflater.from(this.hPu.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.hWC = (ImageView) this.hWB.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.hWE = new e(this.hPu, this.hWB);
        this.hWE.init();
        this.hWE.a(this.hWE.bUQ(), this.fyk);
        this.hWF = (ColumnLayout) this.hWB.findViewById(R.id.pb_head_owner_root);
        this.hWG = (ThreadSkinView) this.hWB.findViewById(R.id.pb_thread_skin);
        this.hWF.setOnLongClickListener(this.onLongClickListener);
        this.hWF.setOnTouchListener(this.cmw);
        this.hWF.setVisibility(8);
        this.hWt.setOnTouchListener(this.cmw);
        this.hXP = this.hWt.findViewById(R.id.pb_head_activity_join_number_container);
        this.hXP.setVisibility(8);
        this.hXQ = (TextView) this.hWt.findViewById(R.id.pb_head_activity_join_number);
        this.hWH = (TextView) this.hWF.findViewById(R.id.pb_head_owner_info_user_name);
        this.hWH.getPaint().setFakeBoldText(true);
        this.hWI = (TextView) this.hWF.findViewById(R.id.floor_owner);
        this.hWJ = (ImageView) this.hWF.findViewById(R.id.icon_forum_level);
        this.hWL = (FrameLayout) this.hWF.findViewById(R.id.pb_head_headImage_container);
        this.hWM = (HeadImageView) this.hWF.findViewById(R.id.pb_head_owner_photo);
        this.hWK = (HeadPendantView) this.hWF.findViewById(R.id.pb_pendant_head_owner_photo);
        this.hWK.setHasPendantStyle();
        if (this.hWK.getHeadView() != null) {
            this.hWK.getHeadView().setIsRound(true);
            this.hWK.getHeadView().setDrawBorder(false);
        }
        this.hQH = (UserIconBox) this.hWF.findViewById(R.id.show_icon_vip);
        this.hQI = (UserIconBox) this.hWF.findViewById(R.id.show_icon_yinji);
        this.hWO = (LinearLayout) this.hWB.findViewById(R.id.pb_head_owner_info_root);
        this.hWR = (PbFirstFloorUserLikeButton) this.hWF.findViewById(R.id.pb_like_button);
        this.hWT = (TextView) this.hWF.findViewById(R.id.pb_views);
        this.hWU = (TextView) this.hWF.findViewById(R.id.pb_item_first_floor_reply_time);
        this.hWV = (TextView) this.hWF.findViewById(R.id.pb_item_first_floor_location_address);
        this.hWW = (TextView) this.hWF.findViewById(R.id.point_between_time_and_locate);
        this.hYJ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hYK = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hXc = this.hWt.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.hXd = this.hWt.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.hWt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hXR = (ViewStub) this.ewL.findViewById(R.id.interview_status_stub);
        this.hWX = this.hWB.findViewById(R.id.blank_view_align_user_item_top);
        this.hWY = this.hWB.findViewById(R.id.blank_view_align_user_item_bottom);
        this.hXg = new f(this.hPu, this.hWr);
        this.hXg.B(this.fyk);
        this.hXg.setTbGestureDetector(this.cmw);
        this.hXg.setOnImageClickListener(this.cLe);
        this.hPT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hPu.c(sparseArray);
                            return;
                        }
                        aq.this.cE(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.hPu.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hXg.N(this.hPT);
        bYi();
        bYj();
        this.hWr.addHeaderView(this.hWB);
        this.hWr.addHeaderView(this.hWz);
        this.hWr.addHeaderView(this.hWt);
        this.fCE = new PbListView(this.hPu.getPageContext().getPageActivity());
        this.cAh = this.fCE.getView().findViewById(R.id.pb_more_view);
        if (this.cAh != null) {
            this.cAh.setOnClickListener(this.fyk);
            com.baidu.tbadk.core.util.am.k(this.cAh, R.drawable.pb_foot_more_trans_selector);
        }
        this.fCE.akN();
        this.fCE.iV(R.drawable.pb_foot_more_trans_selector);
        this.fCE.iX(R.drawable.pb_foot_more_trans_selector);
        this.hXm = this.hPu.findViewById(R.id.viewstub_progress);
        this.hPu.registerListener(this.hYQ);
        this.hWN = com.baidu.tbadk.ala.b.aao().n(this.hPu.getActivity(), 2);
        if (this.hWN != null) {
            this.hWN.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            if (this.hWN.getParent() == null) {
                this.hWO.addView(this.hWN, aVar);
            }
        }
        this.hRI = new PbFakeFloorModel(this.hPu.getPageContext());
        this.hYm = new s(this.hPu.getPageContext(), this.hRI, this.ewL);
        this.hYm.a(this.hPu.hOu);
        this.hRI.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hRI.o(postData);
                aq.this.hXg.notifyDataSetChanged();
                aq.this.hYm.bWl();
                aq.this.TT.aqI();
                aq.this.pc(false);
            }
        });
        if (this.hPu.bUE() != null && !StringUtils.isNull(this.hPu.bUE().bXg())) {
            this.hPu.showToast(this.hPu.bUE().bXg());
        }
        this.hXW = this.hPu.findViewById(R.id.pb_expand_blank_view);
        this.hXX = this.hPu.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hXX.getLayoutParams();
        if (this.hPu.bUE() != null && this.hPu.bUE().bWB()) {
            this.hXW.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hXX.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hXZ;
            this.hXX.setLayoutParams(layoutParams2);
        }
        this.hXY = new al(this.hPu.getPageContext(), this.hPu.findViewById(R.id.pb_reply_expand_view));
        this.hXY.hVL.setVisibility(8);
        this.hXY.P(this.fyk);
        this.hPu.registerListener(this.mAccountChangedListener);
        this.hPu.registerListener(this.hYM);
        this.hPu.registerListener(this.hYN);
        bYe();
        oW(false);
    }

    public void byv() {
        if (!this.hPu.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").P("obj_locate", 2).bT("fid", this.mForumId));
        } else if (this.hPu.bVd()) {
            com.baidu.tbadk.editortools.pb.d bUR = this.hPu.bUR();
            if (bUR != null && (bUR.asZ() || bUR.ata())) {
                this.hPu.bUR().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.TT != null) {
                bYo();
            }
            if (this.TT != null) {
                this.hXK = false;
                if (this.TT.kt(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hPu, (View) this.TT.kt(2).csV, false, hYH);
                }
            }
            bYU();
        }
    }

    private void bYe() {
        this.hYB = new com.baidu.tieba.pb.pb.godreply.a(this.hPu, this, (ViewStub) this.ewL.findViewById(R.id.more_god_reply_popup));
        this.hYB.v(this.fyk);
        this.hYB.N(this.hPT);
        this.hYB.setOnImageClickListener(this.cLe);
        this.hYB.v(this.fyk);
        this.hYB.setTbGestureDetector(this.cmw);
    }

    public com.baidu.tieba.pb.pb.godreply.a bYf() {
        return this.hYB;
    }

    public View bYg() {
        return this.hXW;
    }

    public void bYh() {
        if (this.hWr != null) {
            this.hWr.removeHeaderView(this.hWz);
            this.hWr.removeHeaderView(this.hWB);
            this.hWr.removeHeaderView(this.hWu);
            this.hWr.removeHeaderView(this.hWt);
        }
    }

    private void bYi() {
        if (this.hWu == null) {
            this.hWu = (RelativeLayout) LayoutInflater.from(this.hPu).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.hWv = (HeadImageView) this.hWu.findViewById(R.id.iv_pb_video_smart_app_head);
            this.hWv.setIsRound(true);
            this.hWw = (TextView) this.hWu.findViewById(R.id.tv_pb_video_smart_app_title);
            this.hWx = (TextView) this.hWu.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.hWy = (ImageView) this.hWu.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.hWu.setOnClickListener(this.fyk);
        }
    }

    private void bYj() {
        if (this.hWz == null) {
            this.hWz = (RelativeLayout) LayoutInflater.from(this.hPu).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.hWD = (ImageView) this.hWz.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.hWD.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
            this.hWD.setImageMatrix(matrix);
            this.hWA = (TextView) this.hWz.findViewById(R.id.tv_pb_title);
            this.hWA.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.hWA.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hWA.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.j(this.hWA, R.color.cp_cont_b);
            this.hWA.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hWA.setVisibility(8);
            if (this.hWA.getParent() == null) {
                this.hWz.addView(this.hWA);
            }
            this.hWz.setOnTouchListener(this.cmw);
            this.hWz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYk() {
        if (this.hPu.bVv()) {
            this.hWq = (ViewStub) this.hPu.findViewById(R.id.manga_mention_controller_view_stub);
            this.hWq.setVisibility(0);
            if (this.hWZ == null) {
                this.hWZ = (LinearLayout) this.hPu.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.s.a.a(this.hPu.getPageContext(), this.hWZ);
            }
            if (this.hXa == null) {
                this.hXa = (TextView) this.hWZ.findViewById(R.id.manga_prev_btn);
            }
            if (this.hXb == null) {
                this.hXb = (TextView) this.hWZ.findViewById(R.id.manga_next_btn);
            }
            this.hXa.setOnClickListener(this.fyk);
            this.hXb.setOnClickListener(this.fyk);
        }
    }

    private void bYl() {
        if (this.hPu.bVv()) {
            if (this.hPu.bVy() == -1) {
                com.baidu.tbadk.core.util.am.f(this.hXa, R.color.cp_cont_e, 1);
            }
            if (this.hPu.bVz() == -1) {
                com.baidu.tbadk.core.util.am.f(this.hXb, R.color.cp_cont_e, 1);
            }
        }
    }

    public void bYm() {
        if (this.hWZ == null) {
            bYk();
        }
        this.hWq.setVisibility(8);
        if (this.hYO != null && this.hYP != null) {
            this.hYO.removeCallbacks(this.hYP);
        }
    }

    public void bYn() {
        if (this.hYO != null) {
            if (this.hYP != null) {
                this.hYO.removeCallbacks(this.hYP);
            }
            this.hYP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hWZ == null) {
                        aq.this.bYk();
                    }
                    aq.this.hWq.setVisibility(0);
                }
            };
            this.hYO.postDelayed(this.hYP, 2000L);
        }
    }

    public void oU(boolean z) {
        this.hWn.oU(z);
        if (z && this.hXO) {
            this.fCE.setText(this.hPu.getResources().getString(R.string.click_load_more));
            this.hWr.setNextPage(this.fCE);
            this.hWm = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
        this.TT.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.TT.getParent() == null) {
            this.ewL.addView(this.TT, layoutParams);
        }
        this.TT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.TT.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).amI() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).amI() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
                        }
                        aq.this.mPermissionJudgePolicy.ake();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hPu, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.ad(aq.this.hPu)) {
                            aq.this.hPu.bUR().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hPu.bUR().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bXV();
        this.hPu.bUR().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.TT != null && aq.this.TT.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hYA == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.TT.getId());
                            aq.this.hYA = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hPu.getPageContext(), aq.this.ewL, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.aa(aq.this.hYz)) {
                                aq.this.hYA.setData(aq.this.hYz);
                            }
                            aq.this.hYA.b(aq.this.TT);
                        }
                        aq.this.hYA.CH(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hPu.hNy != null && aq.this.hPu.hNy.bZl() != null) {
                    if (!aq.this.hPu.hNy.bZl().cAq()) {
                        aq.this.hPu.hNy.ph(false);
                    }
                    aq.this.hPu.hNy.bZl().se(false);
                }
            }
        });
    }

    public void bYo() {
        if (this.hPu != null && this.TT != null) {
            this.TT.ql();
            if (this.hPu.bUR() != null) {
                this.hPu.bUR().asQ();
            }
            bYU();
        }
    }

    public void oV(boolean z) {
        if (this.hWr != null && this.ajd != null && this.fyx != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fyx.setVisibility(0);
                } else {
                    this.fyx.setVisibility(8);
                    this.hWr.removeHeaderView(this.ajd);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ajd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hXZ;
                    this.ajd.setLayoutParams(layoutParams);
                }
                bYC();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ajd.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + pe(true);
                this.ajd.setLayoutParams(layoutParams2);
            }
            bYC();
            bZc();
        }
    }

    public f bYp() {
        return this.hXg;
    }

    public void a(PbActivity.d dVar) {
        this.hOz = dVar;
    }

    public void cE(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hPu);
        kVar.setTitleText(this.hPu.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hXo.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hYR != null) {
                                aq.this.hYR.m(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hPu.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hPu.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hPu.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !bZb()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.hPu.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hPu.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hPu.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.W(arrayList);
        if (this.hXo == null) {
            this.hXo = new com.baidu.tbadk.core.dialog.i(this.hPu.getPageContext(), kVar);
        } else {
            this.hXo.a(kVar);
        }
        this.hXo.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hYR = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hPu != null && aVar != null) {
            if (this.fXS == null) {
                this.fXS = new com.baidu.tieba.NEGFeedBack.e(this.hPu.getPageContext(), this.hWt);
            }
            AntiData blT = this.hPu.blT();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (blT != null && blT.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = blT.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.b(sparseArray);
            this.fXS.setDefaultReasonArray(new String[]{this.hPu.getString(R.string.delete_thread_reason_1), this.hPu.getString(R.string.delete_thread_reason_2), this.hPu.getString(R.string.delete_thread_reason_3), this.hPu.getString(R.string.delete_thread_reason_4), this.hPu.getString(R.string.delete_thread_reason_5)});
            this.fXS.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fXS.rU(str);
            this.fXS.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    aq.this.hPu.a(aVar, jSONArray);
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
        sparseArray.put(hYg, Integer.valueOf(hYh));
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
        this.hXq = new com.baidu.tbadk.core.dialog.a(this.hPu.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hXq.hv(i3);
        } else {
            this.hXq.dV(false);
            this.hXq.mQ(str2);
        }
        this.hXq.ab(sparseArray);
        this.hXq.a(R.string.dialog_ok, this.hPu);
        this.hXq.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hXq.dQ(true);
        this.hXq.b(this.hPu.getPageContext());
        if (z) {
            this.hXq.agO();
        } else {
            a(this.hXq, i);
        }
    }

    public void ax(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hXt == null) {
            this.hXt = LayoutInflater.from(this.hPu.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.hPu.getLayoutMode().onModeChanged(this.hXt);
        if (this.hXs == null) {
            this.hXs = new Dialog(this.hPu.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hXs.setCanceledOnTouchOutside(true);
            this.hXs.setCancelable(true);
            this.hXB = (ScrollView) this.hXt.findViewById(R.id.good_scroll);
            this.hXs.setContentView(this.hXt);
            WindowManager.LayoutParams attributes = this.hXs.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.hPu.getPageContext().getPageActivity(), R.dimen.ds540);
            this.hXs.getWindow().setAttributes(attributes);
            this.eGI = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hXx = (String) compoundButton.getTag();
                        if (aq.this.eGH != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.eGH) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hXx != null && !str.equals(aq.this.hXx)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hXu = (LinearLayout) this.hXt.findViewById(R.id.good_class_group);
            this.hXw = (TextView) this.hXt.findViewById(R.id.dialog_button_cancel);
            this.hXw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hXs instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hXs, aq.this.hPu.getPageContext());
                    }
                }
            });
            this.hXv = (TextView) this.hXt.findViewById(R.id.dialog_button_ok);
            this.hXv.setOnClickListener(this.fyk);
        }
        this.hXu.removeAllViews();
        this.eGH = new ArrayList();
        CustomBlueCheckRadioButton dP = dP("0", this.hPu.getPageContext().getString(R.string.thread_good_class));
        this.eGH.add(dP);
        dP.setChecked(true);
        this.hXu.addView(dP);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.adc()) && acVar.add() > 0) {
                    CustomBlueCheckRadioButton dP2 = dP(String.valueOf(acVar.add()), acVar.adc());
                    this.eGH.add(dP2);
                    View view = new View(this.hPu.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.hPu.getPageContext().getPageActivity(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.l(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.hXu.addView(view);
                    this.hXu.addView(dP2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hXB.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hPu.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hPu.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hPu.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hXB.setLayoutParams(layoutParams2);
            this.hXB.removeAllViews();
            if (this.hXu != null && this.hXu.getParent() == null) {
                this.hXB.addView(this.hXu);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hXs, this.hPu.getPageContext());
    }

    private CustomBlueCheckRadioButton dP(String str, String str2) {
        Activity pageActivity = this.hPu.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.eGI);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bYq() {
        this.hPu.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hPu.hideProgressBar();
        if (z && z2) {
            this.hPu.showToast(this.hPu.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.hPu.showToast(str);
        }
    }

    public void bFK() {
        this.hXm.setVisibility(0);
    }

    public void bFJ() {
        this.hXm.setVisibility(8);
    }

    public View bYr() {
        if (this.hXt != null) {
            return this.hXt.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String bYs() {
        return this.hXx;
    }

    public View getView() {
        return this.ewL;
    }

    public void bYt() {
        com.baidu.adp.lib.util.l.b(this.hPu.getPageContext().getPageActivity(), this.hPu.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hPu.hideProgressBar();
        if (z) {
            bYL();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bYM();
        } else {
            bYL();
        }
    }

    public void bYu() {
        this.fCE.akN();
        this.fCE.akR();
    }

    public void bYv() {
        this.hPu.hideProgressBar();
        akS();
        this.hWr.completePullRefreshPostDelayed(0L);
        bYG();
    }

    public void bYw() {
        this.hWr.completePullRefreshPostDelayed(0L);
        bYG();
    }

    private void oW(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hXg.setOnLongClickListener(onLongClickListener);
        if (this.hYB != null) {
            this.hYB.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.hNz != null) {
            this.hNz.dismiss();
            this.hNz = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hPu);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hPu.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hPu.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hPu.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hPu.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hXy.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hXy = new com.baidu.tbadk.core.dialog.i(this.hPu.getPageContext(), kVar);
        this.hXy.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.hXy != null) {
            this.hXy.dismiss();
            this.hXy = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hPu);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hPu.getPageContext().getString(R.string.save_to_emotion), kVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hPu.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hXy.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hXy = new com.baidu.tbadk.core.dialog.i(this.hPu.getPageContext(), kVar);
        this.hXy.showDialog();
    }

    public int bYx() {
        return yj(this.hWr.getFirstVisiblePosition());
    }

    private int yj(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hWr.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int oe = (this.hWr.getAdapter() == null || !(this.hWr.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hWr.getAdapter().oe();
            return i > oe ? i - oe : 0;
        }
        return i;
    }

    public int bYy() {
        int lastVisiblePosition = this.hWr.getLastVisiblePosition();
        if (this.hWh != null) {
            if (lastVisiblePosition == this.hWr.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return yj(lastVisiblePosition);
    }

    public void yk(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.hWr != null) {
            if (this.hWn == null || this.hWn.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hWn.mNavigationBar.getFixedNavHeight();
                if (!(this.hPu.bVj() != -1)) {
                    if (this.hXX != null && (layoutParams = (LinearLayout.LayoutParams) this.hXX.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hXX.setLayoutParams(layoutParams);
                    }
                    i--;
                    bZg();
                }
                i2 = fixedNavHeight;
            }
            this.hWr.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hWr.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hWr.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hXj.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hXg.a(dVar, false);
        this.hXg.notifyDataSetChanged();
        bYG();
        if (this.hYB != null) {
            this.hYB.bUA();
        }
        ArrayList<PostData> bTA = dVar.bTA();
        if (dVar.getPage().adw() == 0 || bTA == null || bTA.size() < dVar.getPage().adv()) {
            if (com.baidu.tbadk.core.util.v.Z(bTA) == 0 || (com.baidu.tbadk.core.util.v.Z(bTA) == 1 && bTA.get(0) != null && bTA.get(0).cqz() == 1)) {
                if (this.hYc == null || this.hYc.hZm == null || this.hYc.hZm.getView() == null) {
                    i = 0;
                } else {
                    i = this.hYc.hZm.getView().getTop() < 0 ? this.hYc.hZm.getView().getHeight() : this.hYc.hZm.getView().getBottom();
                }
                if (this.hPu.bVH()) {
                    this.fCE.W(this.hPu.getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.fCE.W(this.hPu.getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().adw() == 0) {
                    this.fCE.setText(this.hPu.getResources().getString(R.string.list_has_no_more));
                } else {
                    this.fCE.setText(this.hPu.getResources().getString(R.string.load_more));
                }
                this.fCE.akW();
            }
        }
        o(dVar);
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        if (this.hWP == null) {
            this.hPu.getLayoutMode().onModeChanged(((ViewStub) this.hWt.findViewById(R.id.praise_layout)).inflate());
            this.hWP = (FrsPraiseView) this.hWt.findViewById(R.id.pb_head_praise_view);
            this.hWP.setIsFromPb(true);
            this.hXe = this.hWt.findViewById(R.id.new_pb_header_item_line_above_praise);
            this.hWP.jg(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hWP != null) {
            boolean bYG = bYG();
            this.hWP.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().adx() == 0 && this.hPL) {
                if (bYG) {
                    this.hXd.setVisibility(0);
                    return;
                } else {
                    this.hXd.setVisibility(8);
                    return;
                }
            }
            this.hXd.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bTI() != null) {
            return dVar.bTI();
        }
        if (!com.baidu.tbadk.core.util.v.aa(dVar.bTA())) {
            Iterator<PostData> it = dVar.bTA().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cqz() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bTF();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.aeC() != null && postData.aeC().getUserTbVipInfoData() != null && postData.aeC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aeC().getGodUserData().setIntro(postData.aeC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bTy() == null || dVar.bTy().aeC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aeC = dVar.bTy().aeC();
        String userId = aeC.getUserId();
        HashMap<String, MetaData> userMap = dVar.bTy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aeC;
        }
        postData.Bk(1);
        postData.setId(dVar.bTy().aeS());
        postData.setTitle(dVar.bTy().getTitle());
        postData.setTime(dVar.bTy().getCreateTime());
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
        com.baidu.tbadk.data.f cqC;
        String portrait;
        String charSequence;
        if (dVar != null && dVar.bTy() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hWF.setVisibility(8);
            if (dVar.bTy() != null && dVar.bTy().afw() && dVar.bTy().aeT() != null) {
                this.hYq = true;
                this.hWn.pr(this.hYq);
                this.hWn.mNavigationBar.hideBottomLine();
                if (this.hWh == null) {
                    this.hWh = new com.baidu.tieba.pb.video.i(this.hPu, this.hWn, dVar.bTy().aeT(), this.hWi);
                    this.hWh.a(dVar.bTy().aeT(), dVar.bTy(), dVar.getForumId());
                    this.hWh.startPlay();
                } else if (this.hWl) {
                    this.hWh.a(dVar.bTy().aeT(), dVar.bTy(), dVar.getForumId());
                    this.hWh.startPlay();
                } else {
                    this.hWh.CT(dVar.getForumId());
                }
                com.baidu.tieba.pb.c.a.a(this.hPu.getUniqueId(), dVar, c, 1, 1);
                if (dVar.bTz() != null && dVar.bTz().size() >= 1) {
                    bh bhVar = dVar.bTz().get(0);
                    this.hWh.aD(bhVar);
                    this.hWh.CU(bhVar.getTitle());
                }
                this.hWh.b(c, dVar.bTy(), dVar.bTV());
                this.hWl = false;
                this.hWr.removeHeaderView(this.hWh.cbc());
                this.hWr.addHeaderView(this.hWh.cbc(), 0);
                if (this.hWh.aJY() != null && this.hWh.aJY().getParent() == null) {
                    this.hXV.addView(this.hWh.aJY());
                }
                if (this.hWj == null) {
                    this.hWj = new com.baidu.tieba.pb.video.h(this.hPu);
                }
                this.hWj.a(dVar.bTy().afM(), dVar.bTy(), dVar.bTS());
                this.hWr.removeHeaderView(this.hWj.caP());
                this.hWr.addHeaderView(this.hWj.caP(), 1);
                if (dVar.bTy().afM() != null) {
                    this.hWr.removeHeaderView(this.hWj.caQ());
                    this.hWr.removeHeaderView(this.hWB);
                    this.hWr.addHeaderView(this.hWj.caQ(), 2);
                } else {
                    if (this.hWj.caQ() != null) {
                        this.hWr.removeHeaderView(this.hWj.caQ());
                    }
                    this.hWr.removeHeaderView(this.hWB);
                    this.hWr.addHeaderView(this.hWB, 2);
                }
                if (this.hWh != null) {
                    this.hWn.pn(false);
                    this.hWh.yr(TbadkCoreApplication.getInst().getSkinType());
                }
                bYC();
            } else {
                this.hYq = false;
                this.hWn.pr(this.hYq);
                if (this.hWh != null) {
                    this.hWr.removeHeaderView(this.hWh.cbc());
                }
                if (this.hWj != null) {
                    this.hWj.b(this.hWr);
                }
            }
            if (this.hPu.bUU() != null) {
                this.hPu.bUU().pl(this.hYq);
            }
            if (this.hWh != null) {
                this.hWh.R(this.hYT);
                bZg();
            }
            if (c != null) {
                this.hXN = c;
                this.hWF.setVisibility(0);
                if (this.hPu.bUu()) {
                    if (dVar.bTx() != null) {
                        this.mForumName = dVar.bTx().getForumName();
                        this.mForumId = dVar.bTx().getForumId();
                    }
                    if (this.mForumName == null && this.hPu.bUE() != null && this.hPu.bUE().bUv() != null) {
                        this.mForumName = this.hPu.bUE().bUv();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hWF.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hWF.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_clip_board, c);
                sparseArray.put(R.id.tag_is_subpb, false);
                if (dVar.bTy().afw() && dVar.bTy().afo() != null) {
                    SmartApp afo = dVar.bTy().afo();
                    this.hWu.setVisibility(0);
                    this.hWr.removeHeaderView(this.hWu);
                    this.hWr.addHeaderView(this.hWu, 1);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afo.avatar)) {
                        this.hWv.startLoad(afo.avatar, 10, false, false);
                    }
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afo.name)) {
                        charSequence = afo.name + " " + ((Object) this.hPu.getText(R.string.smart_app_suffix));
                    } else {
                        charSequence = this.hPu.getText(R.string.intelligent_smart_app).toString();
                    }
                    this.hWw.setText(charSequence);
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(afo._abstract)) {
                        this.hWx.setText(afo._abstract);
                    } else {
                        this.hWx.setText(this.hPu.getText(R.string.smart_app_default_abstract));
                    }
                    this.hWu.setTag(afo);
                } else {
                    this.hWu.setVisibility(8);
                    this.hWr.removeHeaderView(this.hWu);
                }
                if (!this.hYI) {
                    this.hWz.setVisibility(0);
                }
                if (!dVar.bTy().afw() && this.hWA.getText() != null && this.hWA.getText().length() > 0) {
                    this.hWA.setVisibility(0);
                } else {
                    this.hWA.setVisibility(8);
                }
                n(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> aeN = dVar.bTy().aeN();
                if (aeN != null && aeN.size() > 0 && !this.hYI) {
                    this.hXQ.setText(String.valueOf(aeN.get(0).acJ()));
                    this.hXP.setVisibility(0);
                } else {
                    this.hXP.setVisibility(8);
                }
                com.baidu.tbadk.core.util.am.k(this.hXP, R.drawable.activity_join_num_bg);
                com.baidu.tbadk.core.util.am.f(this.hXQ, R.color.cp_link_tip_d, 1);
                if (c.aeC() != null) {
                    String string = c.aeC().getName_show() == null ? StringUtils.string(c.aeC().getUserName()) : StringUtils.string(c.aeC().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(c.aeC().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bk(c.aeC().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bk(string) > 12) {
                            j = com.baidu.tbadk.core.util.aq.j(string, 12, "...");
                            ArrayList<IconData> iconInfo = c.aeC().getIconInfo();
                            tShowInfoNew = c.aeC().getTShowInfoNew();
                            if (this.hQI != null) {
                                this.hQI.setTag(R.id.tag_user_id, c.aeC().getUserId());
                                this.hQI.setOnClickListener(this.hPu.hNu.iaM);
                                this.hQI.a(iconInfo, 4, this.hPu.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hPu.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hPu.getResources().getDimensionPixelSize(R.dimen.tbds12));
                            }
                            if (this.hQH != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hQH.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hQH.setOnClickListener(this.hPu.hNu.iaN);
                                this.hQH.a(tShowInfoNew, 3, this.hPu.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hPu.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hPu.getResources().getDimensionPixelSize(R.dimen.ds12), true);
                            }
                            this.hWH.setText(bY(c.aeC().getSealPrefix(), j));
                            this.hWH.setTag(R.id.tag_user_id, c.aeC().getUserId());
                            this.hWH.setTag(R.id.tag_user_name, c.aeC().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || c.aeC().isBigV()) {
                                com.baidu.tbadk.core.util.am.f(this.hWH, R.color.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.am.f(this.hWH, R.color.cp_cont_b, 1);
                            }
                            if (c.aeC() == null) {
                                MetaData aeC = c.aeC();
                                if (aeC.getIs_bawu() == 1 && "manager".equals(aeC.getBawu_type())) {
                                    this.hWI.setText(R.string.bawu_member_bazhu_tip);
                                    this.hWI.setVisibility(0);
                                    this.hYG = R.drawable.author_bazhu_bg;
                                    com.baidu.tbadk.core.util.am.k(this.hWI, this.hYG);
                                } else if (aeC.getIs_bawu() == 1 && "assist".equals(aeC.getBawu_type())) {
                                    this.hWI.setText(R.string.bawu_member_xbazhu_tip);
                                    this.hWI.setVisibility(0);
                                    this.hYG = R.drawable.author_small_bazhu;
                                    com.baidu.tbadk.core.util.am.k(this.hWI, this.hYG);
                                } else {
                                    this.hWI.setVisibility(8);
                                }
                            } else {
                                this.hWI.setVisibility(8);
                            }
                            if (dVar.bTy().aeC() != null && dVar.bTy().aeC().getAlaUserData() != null && this.hWN != null) {
                                if (dVar.bTy().aeC().getAlaUserData().anchor_live != 0) {
                                    this.hWN.setVisibility(8);
                                } else {
                                    this.hWN.setVisibility(0);
                                    if (this.hWk == null) {
                                        this.hWk = new com.baidu.tieba.c.d(this.hPu.getPageContext(), this.hWN);
                                        this.hWk.qh(1);
                                    }
                                    this.hWk.cJ(this.hPu.getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bBl = dVar.bTy().aeC().getAlaUserData();
                                    aVar.type = 2;
                                    this.hWN.setTag(aVar);
                                }
                            }
                            this.hWM.setUserId(c.aeC().getUserId());
                            this.hWM.setUserName(c.aeC().getUserName());
                            this.hWM.setTid(c.getId());
                            this.hWM.setFid(this.hSQ == null ? this.hSQ.getForumId() : "");
                            this.hWM.setImageDrawable(null);
                            this.hWM.setRadius(com.baidu.adp.lib.util.l.g(this.hPu.getActivity(), R.dimen.ds40));
                            this.hWM.setTag(c.aeC().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hWU.setText(com.baidu.tbadk.core.util.aq.aF(c.getTime()));
                            } else {
                                this.hWU.setText(com.baidu.tbadk.core.util.aq.aD(c.getTime()));
                            }
                            cqC = c.cqC();
                            if (cqC == null && !TextUtils.isEmpty(cqC.getName()) && !TextUtils.isEmpty(cqC.getName().trim())) {
                                this.hWV.setVisibility(0);
                                this.hWW.setVisibility(0);
                                this.hWV.setText(cqC.getName());
                            } else {
                                this.hWV.setVisibility(8);
                                this.hWW.setVisibility(8);
                            }
                            portrait = c.aeC().getPortrait();
                            if (c.aeC().getPendantData() == null && !StringUtils.isNull(c.aeC().getPendantData().acZ())) {
                                this.hWK.b(c.aeC());
                                this.hWM.setVisibility(8);
                                this.hWK.setVisibility(0);
                                if (this.hWQ != null) {
                                    this.hWQ.setVisibility(8);
                                }
                                this.hWH.setOnClickListener(this.hYT);
                                this.hWK.getHeadView().startLoad(portrait, 28, false);
                                this.hWK.getHeadView().setUserId(c.aeC().getUserId());
                                this.hWK.getHeadView().setUserName(c.aeC().getUserName());
                                this.hWK.getHeadView().setTid(c.getId());
                                this.hWK.getHeadView().setFid(this.hSQ != null ? this.hSQ.getForumId() : "");
                                this.hWK.getHeadView().setOnClickListener(this.hYT);
                                this.hWK.oV(c.aeC().getPendantData().acZ());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hWM, c.aeC());
                                this.hWM.setVisibility(0);
                                this.hWF.setOnClickListener(this.hYT);
                                this.hWH.setOnClickListener(this.hYT);
                                this.hWM.setOnClickListener(this.hYT);
                                this.hWK.setVisibility(8);
                                this.hWM.startLoad(portrait, 28, false);
                            }
                            String name_show = c.aeC().getName_show();
                            String userName = c.aeC().getUserName();
                            if (com.baidu.tbadk.t.as.iN() && name_show != null && !name_show.equals(userName)) {
                                this.hWH.setText(com.baidu.tieba.pb.c.aL(this.hPu.getPageContext().getPageActivity(), this.hWH.getText().toString()));
                                this.hWH.setGravity(16);
                                this.hWH.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bTh());
                                com.baidu.tbadk.core.util.am.f(this.hWH, R.color.cp_other_e, 1);
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo2 = c.aeC().getIconInfo();
                        tShowInfoNew = c.aeC().getTShowInfoNew();
                        if (this.hQI != null) {
                        }
                        if (this.hQH != null) {
                        }
                        this.hWH.setText(bY(c.aeC().getSealPrefix(), j));
                        this.hWH.setTag(R.id.tag_user_id, c.aeC().getUserId());
                        this.hWH.setTag(R.id.tag_user_name, c.aeC().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.f(this.hWH, R.color.cp_cont_h, 1);
                        if (c.aeC() == null) {
                        }
                        if (dVar.bTy().aeC() != null) {
                            if (dVar.bTy().aeC().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hWM.setUserId(c.aeC().getUserId());
                        this.hWM.setUserName(c.aeC().getUserName());
                        this.hWM.setTid(c.getId());
                        this.hWM.setFid(this.hSQ == null ? this.hSQ.getForumId() : "");
                        this.hWM.setImageDrawable(null);
                        this.hWM.setRadius(com.baidu.adp.lib.util.l.g(this.hPu.getActivity(), R.dimen.ds40));
                        this.hWM.setTag(c.aeC().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cqC = c.cqC();
                        if (cqC == null) {
                        }
                        this.hWV.setVisibility(8);
                        this.hWW.setVisibility(8);
                        portrait = c.aeC().getPortrait();
                        if (c.aeC().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hWM, c.aeC());
                        this.hWM.setVisibility(0);
                        this.hWF.setOnClickListener(this.hYT);
                        this.hWH.setOnClickListener(this.hYT);
                        this.hWM.setOnClickListener(this.hYT);
                        this.hWK.setVisibility(8);
                        this.hWM.startLoad(portrait, 28, false);
                        String name_show2 = c.aeC().getName_show();
                        String userName2 = c.aeC().getUserName();
                        if (com.baidu.tbadk.t.as.iN()) {
                            this.hWH.setText(com.baidu.tieba.pb.c.aL(this.hPu.getPageContext().getPageActivity(), this.hWH.getText().toString()));
                            this.hWH.setGravity(16);
                            this.hWH.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bTh());
                            com.baidu.tbadk.core.util.am.f(this.hWH, R.color.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bk(string) > 14) {
                            j = com.baidu.tbadk.core.util.aq.j(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.aeC().getIconInfo();
                            tShowInfoNew = c.aeC().getTShowInfoNew();
                            if (this.hQI != null) {
                            }
                            if (this.hQH != null) {
                            }
                            this.hWH.setText(bY(c.aeC().getSealPrefix(), j));
                            this.hWH.setTag(R.id.tag_user_id, c.aeC().getUserId());
                            this.hWH.setTag(R.id.tag_user_name, c.aeC().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.am.f(this.hWH, R.color.cp_cont_h, 1);
                            if (c.aeC() == null) {
                            }
                            if (dVar.bTy().aeC() != null) {
                            }
                            this.hWM.setUserId(c.aeC().getUserId());
                            this.hWM.setUserName(c.aeC().getUserName());
                            this.hWM.setTid(c.getId());
                            this.hWM.setFid(this.hSQ == null ? this.hSQ.getForumId() : "");
                            this.hWM.setImageDrawable(null);
                            this.hWM.setRadius(com.baidu.adp.lib.util.l.g(this.hPu.getActivity(), R.dimen.ds40));
                            this.hWM.setTag(c.aeC().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cqC = c.cqC();
                            if (cqC == null) {
                            }
                            this.hWV.setVisibility(8);
                            this.hWW.setVisibility(8);
                            portrait = c.aeC().getPortrait();
                            if (c.aeC().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hWM, c.aeC());
                            this.hWM.setVisibility(0);
                            this.hWF.setOnClickListener(this.hYT);
                            this.hWH.setOnClickListener(this.hYT);
                            this.hWM.setOnClickListener(this.hYT);
                            this.hWK.setVisibility(8);
                            this.hWM.startLoad(portrait, 28, false);
                            String name_show22 = c.aeC().getName_show();
                            String userName22 = c.aeC().getUserName();
                            if (com.baidu.tbadk.t.as.iN()) {
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo222 = c.aeC().getIconInfo();
                        tShowInfoNew = c.aeC().getTShowInfoNew();
                        if (this.hQI != null) {
                        }
                        if (this.hQH != null) {
                        }
                        this.hWH.setText(bY(c.aeC().getSealPrefix(), j));
                        this.hWH.setTag(R.id.tag_user_id, c.aeC().getUserId());
                        this.hWH.setTag(R.id.tag_user_name, c.aeC().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.f(this.hWH, R.color.cp_cont_h, 1);
                        if (c.aeC() == null) {
                        }
                        if (dVar.bTy().aeC() != null) {
                        }
                        this.hWM.setUserId(c.aeC().getUserId());
                        this.hWM.setUserName(c.aeC().getUserName());
                        this.hWM.setTid(c.getId());
                        this.hWM.setFid(this.hSQ == null ? this.hSQ.getForumId() : "");
                        this.hWM.setImageDrawable(null);
                        this.hWM.setRadius(com.baidu.adp.lib.util.l.g(this.hPu.getActivity(), R.dimen.ds40));
                        this.hWM.setTag(c.aeC().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cqC = c.cqC();
                        if (cqC == null) {
                        }
                        this.hWV.setVisibility(8);
                        this.hWW.setVisibility(8);
                        portrait = c.aeC().getPortrait();
                        if (c.aeC().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hWM, c.aeC());
                        this.hWM.setVisibility(0);
                        this.hWF.setOnClickListener(this.hYT);
                        this.hWH.setOnClickListener(this.hYT);
                        this.hWM.setOnClickListener(this.hYT);
                        this.hWK.setVisibility(8);
                        this.hWM.startLoad(portrait, 28, false);
                        String name_show222 = c.aeC().getName_show();
                        String userName222 = c.aeC().getUserName();
                        if (com.baidu.tbadk.t.as.iN()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hWE.av(dVar.bTy());
                }
                if (this.hXY != null) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hLb);
                    if (dVar != null && dVar.bTy() != null) {
                        iVar.hLd = dVar.bTy().aet();
                    }
                    iVar.isNew = !this.hPL;
                    iVar.sortType = dVar.hKI;
                    if (dVar.hKH != null && dVar.hKH.size() > dVar.hKI) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hKH.size()) {
                                break;
                            } else if (dVar.hKH.get(i4).sort_type.intValue() != dVar.hKI) {
                                i3 = i4 + 1;
                            } else {
                                iVar.hLf = dVar.hKH.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    iVar.hLg = this.hPu.bVH();
                    this.hXY.a(iVar);
                }
                if (dVar != null && dVar.bTy() != null) {
                    ac(dVar.bTy().aey() == 1, dVar.bTy().aex() == 1);
                }
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hXg != null && aq.this.hWn != null && aq.this.hWn.ibM != null && aq.this.hSQ != null && aq.this.hSQ.bTy() != null && !aq.this.hSQ.bTy().afw() && !aq.this.bYF() && aq.this.hSQ.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(aq.this.hSQ.getForum().getName())) {
                            if (aq.this.hXg.bWg() == null || !aq.this.hXg.bWg().isShown()) {
                                aq.this.hWn.ibM.setVisibility(0);
                                if (aq.this.hPu != null && aq.this.hPu.bUE() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.bT("tid", aq.this.hPu.bUE().bWy());
                                    anVar.bT("fid", aq.this.hPu.bUE().getForumId());
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

    public void oX(boolean z) {
        if (z) {
            bYz();
        } else {
            bgP();
        }
        this.hYc.hZm = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hYc));
        a(this.hYc.hZm, false);
    }

    public void bYz() {
        if (this.hWn != null && !this.hYs) {
            this.hWn.ps(!StringUtils.isNull(this.hPu.bVg()));
            this.hYs = true;
        }
    }

    public void bgP() {
        if (this.hWn != null) {
            this.hWn.bZN();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.aeX() != null) {
            this.hWG.setData(this.hPu.getPageContext(), dVar.bTA().get(0).aeX(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bTy().getId(), this.hPu.bVE() ? "FRS" : null));
            this.hWF.setPadding(this.hWF.getPaddingLeft(), (int) this.hPu.getResources().getDimension(R.dimen.ds20), this.hWF.getPaddingRight(), this.hWF.getPaddingBottom());
            return;
        }
        this.hWG.setData(null, null, null);
    }

    public void bYA() {
        if (this.hWh != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11997").P("obj_type", 1));
            this.hWh.cba();
            this.hWr.smoothScrollToPosition(0);
        }
    }

    public boolean bYB() {
        return this.hYU;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean ax(bh bhVar) {
        if (bhVar == null || bhVar.aeC() == null || bhVar.aeC().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.aeC().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.hWn.bZL();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hWn.As(cVar.forumName);
            }
            String string = this.hPu.getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.f(cVar.source, 0)) {
                case 100:
                    str = this.hPu.getResources().getString(R.string.self);
                    break;
                case 300:
                    str = this.hPu.getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = this.hPu.getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hKb;
            this.hPu.showNetRefreshView(this.ewL, format, null, this.hPu.getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.kt()) {
                        ba.ajK().c(aq.this.hPu.getPageContext(), new String[]{str2});
                        aq.this.hPu.finish();
                        return;
                    }
                    aq.this.hPu.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bXJ;
        Parcelable bXJ2;
        if (dVar != null) {
            this.hSQ = dVar;
            this.mType = i;
            if (dVar.bTy() != null) {
                this.hYe = dVar.bTy().aek();
                if (dVar.bTy().getAnchorLevel() != 0) {
                    this.hYU = true;
                }
                this.hXA = ax(dVar.bTy());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.hXO = false;
            this.hPL = z;
            bYv();
            if (dVar.hKJ != null && dVar.hKJ.bTZ()) {
                if (this.hWs == null) {
                    this.hWs = new PbThreadPostView(this.hPu);
                    this.hWr.addHeaderView(this.hWs, 1);
                    this.hWs.setData(dVar);
                    this.hWs.setChildOnClickLinstener(this.fyk);
                }
            } else if (this.hWs != null && this.hWr != null) {
                this.hWr.removeHeaderView(this.hWs);
            }
            b(dVar, z, i);
            p(dVar);
            if (this.hYE == null) {
                this.hYE = new ac(this.hPu.getPageContext(), this.fUZ);
            }
            this.hYE.Cy(dVar.bTD());
            if (this.hPu.bVv()) {
                if (this.hXk == null) {
                    this.hXk = new com.baidu.tieba.pb.view.c(this.hPu.getPageContext());
                    this.hXk.nZ();
                    this.hXk.setListPullRefreshListener(this.cbC);
                }
                this.hWr.setPullRefresh(this.hXk);
                bYC();
                if (this.hXk != null) {
                    this.hXk.iY(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().adx() == 0 && z) {
                this.hWr.setPullRefresh(null);
            } else {
                if (this.hXk == null) {
                    this.hXk = new com.baidu.tieba.pb.view.c(this.hPu.getPageContext());
                    this.hXk.nZ();
                    this.hXk.setListPullRefreshListener(this.cbC);
                }
                this.hWr.setPullRefresh(this.hXk);
                bYC();
                if (this.hXk != null) {
                    this.hXk.iY(TbadkCoreApplication.getInst().getSkinType());
                }
                aVf();
            }
            bYG();
            this.hXg.ol(this.hPL);
            this.hXg.om(false);
            this.hXg.ox(i == 5);
            this.hXg.oy(i == 6);
            this.hXg.oz(z2 && this.hYS);
            this.hXg.a(dVar, false);
            this.hXg.notifyDataSetChanged();
            if (this.hPu.bUu()) {
                this.hYu = 0;
                PostData c = c(dVar, z);
                if (c != null && c.aeC() != null) {
                    this.hYu = c.aeC().getLevel_id();
                }
                if (this.hYu > 0) {
                    this.hWJ.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(this.hWJ, BitmapHelper.getGradeResourceIdInEnterForum(this.hYu));
                } else {
                    this.hWJ.setVisibility(8);
                }
            } else {
                this.hWJ.setVisibility(8);
            }
            if (dVar.bTy() != null && dVar.bTy().aeo() != null) {
                if (dVar.bTy().aeo().getNum() < 1) {
                    this.hPu.getResources().getString(R.string.zan);
                } else {
                    String str = dVar.bTy().aeo().getNum() + "";
                }
                if (this.hWg != -1) {
                    dVar.bTy().aeo().setIsLike(this.hWg);
                }
            }
            if (this.hPu.isLogin()) {
                this.hWr.setNextPage(this.fCE);
                this.hWm = 2;
                aVf();
            } else {
                this.hXO = true;
                if (dVar.getPage().adw() == 1) {
                    if (this.hXl == null) {
                        this.hXl = new com.baidu.tieba.pb.view.a(this.hPu.getPageContext());
                    }
                    this.hWr.setNextPage(this.hXl);
                } else {
                    this.hWr.setNextPage(this.fCE);
                }
                this.hWm = 3;
            }
            ArrayList<PostData> bTA = dVar.bTA();
            if (dVar.getPage().adw() == 0 || bTA == null || bTA.size() < dVar.getPage().adv()) {
                if (com.baidu.tbadk.core.util.v.Z(bTA) == 0 || (com.baidu.tbadk.core.util.v.Z(bTA) == 1 && bTA.get(0) != null && bTA.get(0).cqz() == 1)) {
                    if (this.hYc == null || this.hYc.hZm == null || this.hYc.hZm.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hYc.hZm.getView().getTop() < 0 ? this.hYc.hZm.getView().getHeight() : this.hYc.hZm.getView().getBottom();
                    }
                    if (this.hPu.bVH()) {
                        this.fCE.W(this.hPu.getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.fCE.W(this.hPu.getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.hPu.bUU() != null && !this.hPu.bUU().bZz()) {
                        this.hPu.bUU().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().adw() == 0) {
                        this.fCE.setText(this.hPu.getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.fCE.setText(this.hPu.getResources().getString(R.string.load_more));
                    }
                    this.fCE.akW();
                }
                bYP();
            } else {
                if (z2) {
                    if (this.hYS) {
                        akS();
                        if (dVar.getPage().adw() != 0) {
                            this.fCE.setText(this.hPu.getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.fCE.akN();
                        this.fCE.showLoading();
                    }
                } else {
                    this.fCE.akN();
                    this.fCE.showLoading();
                }
                this.fCE.akW();
            }
            switch (i) {
                case 2:
                    this.hWr.setSelection(i2 > 1 ? (((this.hWr.getData() == null && dVar.bTA() == null) ? 0 : (this.hWr.getData().size() - dVar.bTA().size()) + this.hWr.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bXJ2 = aj.bXI().bXJ()) != null) {
                        this.hWr.onRestoreInstanceState(bXJ2);
                        if (com.baidu.tbadk.core.util.v.Z(bTA) > 1 && dVar.getPage().adw() > 0) {
                            this.fCE.akS();
                            this.fCE.setText(this.hPu.getString(R.string.pb_load_more_without_point));
                            this.fCE.akO();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hYS = false;
                    break;
                case 5:
                    this.hWr.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bXJ = aj.bXI().bXJ()) != null) {
                        this.hWr.onRestoreInstanceState(bXJ);
                        break;
                    } else {
                        this.hWr.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.hWh != null && this.hWh.aJY() != null) {
                            if (this.hPu.isUseStyleImmersiveSticky()) {
                                this.hWr.setSelectionFromTop((this.hXg.bWb() + this.hWr.getHeaderViewsCount()) - 1, this.hWh.aJY().getHeight() - com.baidu.adp.lib.util.l.u(this.hPu.getPageContext().getPageActivity()));
                            } else {
                                this.hWr.setSelectionFromTop((this.hXg.bWb() + this.hWr.getHeaderViewsCount()) - 1, this.hWh.aJY().getHeight());
                            }
                        } else {
                            this.hWr.setSelection(this.hXg.bWb() + this.hWr.getHeaderViewsCount());
                        }
                    } else {
                        this.hWr.setSelection(i2 > 0 ? ((this.hWr.getData() == null && dVar.bTA() == null) ? 0 : (this.hWr.getData().size() - dVar.bTA().size()) + this.hWr.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fCE.akS();
                    this.fCE.setText(this.hPu.getString(R.string.pb_load_more_without_point));
                    this.fCE.akO();
                    break;
            }
            if (this.hYe == hYf && isHost()) {
                bYX();
            }
            if (this.hYo) {
                bXT();
                this.hYo = false;
                if (i3 == 0) {
                    oR(true);
                }
            }
            if (this.hWj != null) {
                this.hWj.aC(dVar.bTy());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hKF == 1 || dVar.hKG == 1) {
                if (this.hYv == null) {
                    this.hYv = new PbTopTipView(this.hPu);
                }
                if (dVar.hKG == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hPu.getStType())) {
                    this.hYv.setText(this.hPu.getString(R.string.pb_read_strategy_add_experience));
                    this.hYv.show(this.ewL, this.mSkinType);
                } else if (dVar.hKF == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hPu.getStType())) {
                    this.hYv.setText(this.hPu.getString(R.string.pb_read_news_add_experience));
                    this.hYv.show(this.ewL, this.mSkinType);
                }
            }
            o(dVar);
        }
    }

    private void o(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bTy() != null) {
            if (dVar.aaF()) {
                SvgManager.ajv().a(this.hXH, R.drawable.icon_mask_pb_bottom_collect_h_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.ajv().a(this.hXH, R.drawable.icon_pure_pb_bottom_collect_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.hXJ.setText(yl(dVar.bTy().aet()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, dVar.bTy()));
        }
    }

    private String yl(int i) {
        if (i == 0) {
            return this.hPu.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void bYC() {
        if (this.hWh != null && this.hWh.aJY() != null) {
            this.hWr.removeHeaderView(this.ajd);
            if (this.mType != 1) {
                this.hWr.removeHeaderView(this.hWh.cbc());
                this.hWr.addHeaderView(this.hWh.cbc(), 0);
                return;
            }
            return;
        }
        if (this.hWh != null) {
            this.hWr.removeHeaderView(this.hWh.cbc());
        }
        this.hWr.removeHeaderView(this.ajd);
        this.hWr.addHeaderView(this.ajd, 0);
    }

    public void oY(boolean z) {
        this.hXz = z;
    }

    public void akS() {
        if (this.fCE != null) {
            this.fCE.akO();
            this.fCE.akS();
        }
        aVf();
    }

    public void aWv() {
        this.hWr.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hXN != null && this.hXN.aeC() != null && this.hWn != null) {
            this.hYr = !this.hYq;
            this.hWn.pn(this.hYr);
            if (this.hPu.bUU() != null) {
                this.hPu.bUU().pm(this.hYr);
            }
            bYD();
            if (this.hPu != null && !this.hPu.bUu() && !com.baidu.tbadk.core.util.v.aa(dVar.bTT())) {
                bd bdVar = dVar.bTT().get(0);
                if (bdVar != null) {
                    this.hWn.dQ(bdVar.getForumName(), bdVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hWn.dQ(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hYr) {
                if (this.hXA) {
                    this.hWR.setVisibility(8);
                    this.hWT.setVisibility(0);
                    this.hWT.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.aJ(dVar.bTU())));
                }
                if (this.hXX != null) {
                    this.hXX.setVisibility(8);
                }
                if (this.hYC == null) {
                    this.hYC = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hYt) {
                                aq.this.bYW();
                            }
                            aq.this.bYw();
                        }
                    };
                }
                this.hWr.setListViewDragListener(this.hYC);
            } else {
                if (this.hXX != null) {
                    this.hXX.setVisibility(0);
                }
                if (this.hXA) {
                    this.hWR.setVisibility(8);
                    this.hWT.setVisibility(0);
                    this.hWT.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.aq.aJ(dVar.bTU())));
                } else if (!com.baidu.tbadk.t.au.awf() || (this.hXN.aeC().hadConcerned() && this.hXN.aeC().getGodUserData() != null && this.hXN.aeC().getGodUserData().getIsFromNetWork())) {
                    this.hWR.setVisibility(8);
                    this.hWT.setVisibility(8);
                } else {
                    this.hWT.setVisibility(8);
                }
                this.hYC = null;
                this.hWr.setListViewDragListener(null);
            }
            if (dVar.hKO) {
                this.hWR.setVisibility(8);
            }
        }
    }

    private void bYD() {
        String threadId = this.hSQ != null ? this.hSQ.getThreadId() : "";
        int bYE = bYE();
        if (this.hYr && this.hXN != null && this.hXN.aeC() != null) {
            this.hXN.aeC().setIsLike(this.hXN.aeC().hadConcerned());
        }
        if (this.hWS == null) {
            this.hWS = new ao(this.hPu.getPageContext(), this.hWR, 1);
            this.hWS.j(this.hPu.getUniqueId());
            this.hWS.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void ez(boolean z) {
                    if (aq.this.hPu != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hPu, (int) R.string.attention_success);
                    }
                }
            });
        }
        if (this.hXN != null && this.hXN.aeC() != null) {
            this.hXN.aeC().setIsLike(this.hXN.aeC().hadConcerned());
            this.hWS.a(this.hXN.aeC());
            this.hWS.setTid(threadId);
        }
        this.hWS.hWc = this.hYq;
        this.hWS.yi(bYE);
    }

    public int bYE() {
        if (this.hSQ == null || this.hSQ.bTy() == null) {
            return 0;
        }
        if (this.hSQ.bTy().afU()) {
            return (com.baidu.tbadk.core.util.v.aa(this.hSQ.bTT()) && (this.hSQ.bTx() == null || StringUtils.isNull(this.hSQ.bTx().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bYF() {
        return this.hSQ == null || this.hSQ.getForum() == null || "0".equals(this.hSQ.getForum().getId()) || "me0407".equals(this.hSQ.getForum().getName());
    }

    private boolean bYG() {
        boolean z;
        if (this.hXD != null && this.hXD.getVisibility() == 0) {
            if (this.hXc != null) {
                this.hXc.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hXc != null) {
                this.hXc.setVisibility(8);
            }
            z = false;
        }
        if ((this.hXe == null || this.hXe.getVisibility() == 8) && z && this.hPL) {
            this.hXd.setVisibility(0);
        } else {
            this.hXd.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bTy() == null) {
            return false;
        }
        if (dVar.bTy().aez() == 1 || dVar.bTy().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bTy().aeB() == null || dVar.bTy().aeB().agD() == 0) || dVar.bTy().aex() == 1 || dVar.bTy().aey() == 1 || dVar.bTy().afn() || dVar.bTy().afC() || dVar.bTy().afv() || dVar.bTy().aeO() != null || !com.baidu.tbadk.core.util.aq.isEmpty(dVar.bTy().getCategory()) || dVar.bTy().aeF() || dVar.bTy().aeE();
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hPu.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hWz != null) {
                if (dVar.bTy() != null && dVar.bTy().aeR() == 0 && !dVar.bTy().afw() && !this.hYI) {
                    this.hWz.setVisibility(0);
                    if (dVar.bTy() != null) {
                        bh bTy = dVar.bTy();
                        bTy.m(true, q(dVar));
                        bTy.hi(3);
                        bTy.mA("2");
                    }
                    SpannableStringBuilder afi = dVar.bTy().afi();
                    this.hWA.setOnTouchListener(new com.baidu.tieba.view.k(afi));
                    this.hWA.setText(afi);
                    this.hWA.setVisibility(0);
                } else if (dVar.bTy().aeR() == 1) {
                    if (dVar.bTy() != null) {
                        this.hWz.setVisibility(8);
                        this.hWr.removeHeaderView(this.hWz);
                    }
                } else {
                    this.hWz.setVisibility(8);
                    this.hWr.removeHeaderView(this.hWz);
                    if (dVar.bTy() != null && dVar.bTy().afw()) {
                        this.hWF.setPadding(this.hWF.getPaddingLeft(), 0, this.hWF.getPaddingRight(), this.hWF.getPaddingBottom());
                        if (this.hWX != null) {
                            ((RelativeLayout.LayoutParams) this.hWX.getLayoutParams()).height = (int) this.hPu.getResources().getDimension(R.dimen.tbds36);
                            this.hWX.requestLayout();
                        }
                        if (this.hWY != null) {
                            ((RelativeLayout.LayoutParams) this.hWY.getLayoutParams()).height = (int) this.hPu.getResources().getDimension(R.dimen.tbds0);
                            this.hWY.requestLayout();
                        }
                    } else {
                        this.hWF.setPadding(this.hWF.getPaddingLeft(), com.baidu.adp.lib.util.l.g(this.hPu.getPageContext().getPageActivity(), R.dimen.ds48), this.hWF.getPaddingRight(), this.hWF.getPaddingBottom());
                    }
                }
            }
            if (dVar.bTy() != null) {
                ab(dVar.bTy().aey() == 1, dVar.bTy().aex() == 1);
            }
            this.hPL = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bYG();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData c;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (dVar != null && (c = c(dVar, z)) != null) {
            String userId = c.aeC().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bTK()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (c.aeC() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, c.aeC().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, c.aeC().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, c.aeC().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, c.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bTK()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bd> bTT = dVar.bTT();
                if (com.baidu.tbadk.core.util.v.Z(bTT) > 0) {
                    sb = new StringBuilder();
                    for (bd bdVar : bTT) {
                        if (bdVar != null && !StringUtils.isNull(bdVar.getForumName()) && (vVar = bdVar.bJu) != null && vVar.bHj && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.i(bdVar.getForumName(), 12)).append(this.hPu.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.hPu.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View bYH() {
        return this.cAh;
    }

    public boolean bYI() {
        if (this.ewO == null || this.ewO.getParent() == null || this.fCE.pQ()) {
            return false;
        }
        int bottom = this.ewO.getBottom();
        Rect rect = new Rect();
        this.ewO.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Cz(String str) {
        if (this.fCE != null) {
            this.fCE.setText(str);
        }
    }

    public void CA(String str) {
        if (this.fCE != null) {
            int i = 0;
            if (this.hYc != null && this.hYc.hZm != null && this.hYc.hZm.getView() != null) {
                i = this.hYc.hZm.getView().getTop() < 0 ? this.hYc.hZm.getView().getHeight() : this.hYc.hZm.getView().getBottom();
            }
            this.fCE.W(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hWr;
    }

    public int bYJ() {
        return R.id.richText;
    }

    public TextView bUQ() {
        return this.hWE.bUQ();
    }

    public void e(BdListView.e eVar) {
        this.hWr.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.cbC = cVar;
        if (this.hXk != null) {
            this.hXk.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int adu = anVar.adu();
            int adr = anVar.adr();
            if (this.hXh != null) {
                this.hXh.agO();
            } else {
                this.hXh = new com.baidu.tbadk.core.dialog.a(this.hPu.getPageContext().getPageActivity());
                this.hXi = LayoutInflater.from(this.hPu.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.hXh.aH(this.hXi);
                this.hXh.a(R.string.dialog_ok, bVar);
                this.hXh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bYL();
                        aVar.dismiss();
                    }
                });
                this.hXh.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hYl == null) {
                            aq.this.hYl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hPu.HidenSoftKeyPad((InputMethodManager) aq.this.hPu.getSystemService("input_method"), aq.this.ewL);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.iK().postDelayed(aq.this.hYl, 150L);
                    }
                });
                this.hXh.b(this.hPu.getPageContext()).agO();
            }
            this.hXj = (EditText) this.hXi.findViewById(R.id.input_page_number);
            this.hXj.setText("");
            TextView textView = (TextView) this.hXi.findViewById(R.id.current_page_number);
            if (adu <= 0) {
                adu = 1;
            }
            if (adr <= 0) {
                adr = 1;
            }
            textView.setText(MessageFormat.format(this.hPu.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(adu), Integer.valueOf(adr)));
            this.hPu.ShowSoftKeyPadDelay(this.hXj, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hWr.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hPu.showToast(str);
    }

    public boolean oZ(boolean z) {
        if (this.TT == null || !this.TT.asp()) {
            return false;
        }
        this.TT.aqI();
        return true;
    }

    public void bYK() {
        if (this.hYV != null) {
            while (this.hYV.size() > 0) {
                TbImageView remove = this.hYV.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bYK();
        this.hXg.xT(1);
        if (this.hWh != null) {
            this.hWh.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hXg.xT(2);
        if (this.hWh != null) {
            this.hWh.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.hPu) && !TbSingleton.getInstance().isCutoutScreen(this.hPu)) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hYn != null) {
            this.hYn.destroy();
        }
        if (this.hYE != null) {
            this.hYE.onDestory();
        }
        if (this.hYv != null) {
            this.hYv.hide();
        }
        if (this.hWk != null) {
            this.hWk.bcf();
        }
        if (this.hWj != null) {
            this.hWj.onDestroy();
        }
        this.hPu.hideProgressBar();
        if (this.eYL != null && this.ftG != null) {
            this.eYL.b(this.ftG);
        }
        bYL();
        akS();
        if (this.hYl != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hYl);
        }
        if (this.hWF != null && this.hWQ != null) {
            this.hWF.removeView(this.hWL);
            this.hWQ = null;
        }
        if (this.hXS != null) {
            this.hXS.clearStatus();
        }
        this.hYO = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hXg.xT(3);
        if (this.fyx != null) {
            this.fyx.setBackgroundDrawable(null);
        }
        if (this.hWh != null) {
            this.hWh.destroy();
        }
        if (this.hXg != null) {
            this.hXg.onDestroy();
        }
        this.hWr.setOnLayoutListener(null);
        if (this.hYA != null) {
            this.hYA.bpq();
        }
        if (this.hYd != null) {
            this.hYd.onDestroy();
        }
    }

    public boolean ym(int i) {
        if (this.hWh != null) {
            return this.hWh.rW(i);
        }
        return false;
    }

    public void bYL() {
        this.hWn.UQ();
        if (this.hWk != null) {
            this.hWk.bcf();
        }
        com.baidu.adp.lib.util.l.b(this.hPu.getPageContext().getPageActivity(), this.hXj);
        bXV();
        if (this.hNz != null) {
            this.hNz.dismiss();
        }
        bYN();
        if (this.hWj != null) {
            this.hWj.caR();
        }
        if (this.hXh != null) {
            this.hXh.dismiss();
        }
        if (this.fyj != null) {
            this.fyj.dismiss();
        }
    }

    public void bYM() {
        this.hWn.UQ();
        if (this.hWk != null) {
            this.hWk.bcf();
        }
        if (this.hNz != null) {
            this.hNz.dismiss();
        }
        bYN();
        if (this.hWj != null) {
            this.hWj.caR();
        }
        if (this.hXh != null) {
            this.hXh.dismiss();
        }
        if (this.fyj != null) {
            this.fyj.dismiss();
        }
    }

    public void dJ(List<String> list) {
        this.hYz = list;
        if (this.hYA != null) {
            this.hYA.setData(list);
        }
    }

    public void ok(boolean z) {
        this.hXg.ok(z);
    }

    public void pa(boolean z) {
        this.hXC = z;
    }

    public void bYN() {
        if (this.hXq != null) {
            this.hXq.dismiss();
        }
        if (this.hXr != null) {
            com.baidu.adp.lib.g.g.b(this.hXr, this.hPu.getPageContext());
        }
        if (this.hXs != null) {
            com.baidu.adp.lib.g.g.b(this.hXs, this.hPu.getPageContext());
        }
        if (this.hXo != null) {
            this.hXo.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hSQ, this.hPL);
            d(this.hSQ, this.hPL, this.mType);
            this.hPu.getLayoutMode().setNightMode(i == 1);
            this.hPu.getLayoutMode().onModeChanged(this.ewL);
            this.hPu.getLayoutMode().onModeChanged(this.hWt);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.am.l(this.ewL, R.color.cp_bg_line_d);
            }
            if (this.hWj != null) {
                this.hWj.onChangeSkinType(i);
            }
            if (this.hWu != null) {
                com.baidu.tbadk.core.util.am.l(this.hWu, R.color.cp_bg_line_c);
            }
            if (this.hWv != null) {
                this.hWv.setIsNight(this.mSkinType == 1);
            }
            if (this.hWw != null) {
                com.baidu.tbadk.core.util.am.j(this.hWw, R.color.cp_cont_b);
            }
            if (this.hWx != null) {
                com.baidu.tbadk.core.util.am.j(this.hWx, R.color.cp_cont_j);
            }
            if (this.hWy != null) {
                com.baidu.tbadk.core.util.am.k(this.hWy, R.drawable.icon_common_arrow16_right_n);
            }
            if (this.hWA != null) {
                com.baidu.tbadk.core.util.am.j(this.hWA, R.color.cp_cont_b);
                this.hWA.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            }
            if (this.fCE != null) {
                this.fCE.iY(i);
                if (this.cAh != null) {
                    this.hPu.getLayoutMode().onModeChanged(this.cAh);
                    com.baidu.tbadk.core.util.am.k(this.cAh, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.hXh != null) {
                this.hXh.c(this.hPu.getPageContext());
            }
            oY(this.hXz);
            this.hXg.notifyDataSetChanged();
            if (this.hXk != null) {
                this.hXk.iY(i);
            }
            if (this.TT != null) {
                this.TT.onChangeSkinType(i);
            }
            if (this.hWP != null) {
                this.hWP.jg(i);
            }
            if (this.hXl != null) {
                this.hXl.iY(i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.eGH)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.eGH) {
                    customBlueCheckRadioButton.akv();
                }
            }
            bYl();
            UtilHelper.setStatusBarBackground(this.fyx, i);
            UtilHelper.setStatusBarBackground(this.hXX, i);
            if (this.hWR != null) {
                this.hWR.onChangeSkinType(i);
            }
            if (this.hWV != null) {
                com.baidu.tbadk.core.util.am.j(this.hWV, R.color.cp_cont_d);
            }
            if (this.hWU != null) {
                com.baidu.tbadk.core.util.am.j(this.hWU, R.color.cp_cont_d);
            }
            if (this.hWW != null) {
                com.baidu.tbadk.core.util.am.j(this.hWW, R.color.cp_cont_d);
            }
            if (this.hWT != null) {
                com.baidu.tbadk.core.util.am.j(this.hWT, R.color.cp_cont_d);
            }
            if (this.hWZ != null) {
                com.baidu.tbadk.s.a.a(this.hPu.getPageContext(), this.hWZ);
            }
            if (this.hYm != null) {
                this.hYm.onChangeSkinType(i);
            }
            if (this.hWn != null) {
                if (this.hWh != null) {
                    this.hWh.yr(i);
                } else {
                    this.hWn.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.goY != null) {
                com.baidu.tbadk.core.util.am.j(this.goY, R.color.cp_cont_d);
                this.goY.setBackgroundDrawable(com.baidu.tbadk.core.util.am.X(com.baidu.adp.lib.util.l.g(this.hPu, R.dimen.tbds16), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.hXH != null && this.hSQ != null) {
                if (this.hSQ.aaF()) {
                    SvgManager.ajv().a(this.hXH, R.drawable.icon_mask_pb_bottom_collect_h_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.ajv().a(this.hXH, R.drawable.icon_pure_pb_bottom_collect_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            if (this.hXI != null) {
                SvgManager.ajv().a(this.hXI, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hXG != null) {
                SvgManager.ajv().a(this.hXG, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            com.baidu.tbadk.core.util.am.j(this.hXJ, R.color.cp_cont_b);
            if (this.hWJ != null) {
                com.baidu.tbadk.core.util.am.c(this.hWJ, BitmapHelper.getGradeResourceIdInEnterForum(this.hYu));
            }
            if (this.hYB != null) {
                this.hYB.onChangeSkinType(i);
            }
            if (this.hYd != null) {
                this.hYd.onChangeSkinType();
            }
            if (this.hYx != null) {
                com.baidu.tbadk.core.util.am.j(this.hYx, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.l(this.hXF, R.color.cp_bg_line_h);
            if (this.hWI != null) {
                com.baidu.tbadk.core.util.am.k(this.hWI, this.hYG);
                com.baidu.tbadk.core.util.am.j(this.hWI, R.color.cp_cont_a);
            }
            if (this.hWs != null) {
                this.hWs.nE(i);
            }
            this.hPu.getLayoutMode().onModeChanged(this.hXt);
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cLe = hVar;
        this.hXg.setOnImageClickListener(this.cLe);
        this.hYB.setOnImageClickListener(this.cLe);
    }

    public void h(NoNetworkView.a aVar) {
        this.ftG = aVar;
        if (this.eYL != null) {
            this.eYL.a(this.ftG);
        }
    }

    public void pb(boolean z) {
        this.hXg.setIsFromCDN(z);
    }

    public Button bYO() {
        return this.hXD;
    }

    public void bYP() {
        if (this.hWm != 2) {
            this.hWr.setNextPage(this.fCE);
            this.hWm = 2;
        }
    }

    public void bYQ() {
        if (com.baidu.tbadk.p.m.avH().avI()) {
            int lastVisiblePosition = this.hWr.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hWr.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog = tbImageView.getPerfLog();
                                perfLog.kU(1001);
                                perfLog.cAP = true;
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
                        perfLog2.kU(1001);
                        perfLog2.cAP = true;
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

    public boolean bYR() {
        return this.TT != null && this.TT.getVisibility() == 0;
    }

    public boolean bYS() {
        return this.TT != null && this.TT.asp();
    }

    public void bYT() {
        if (this.TT != null) {
            this.TT.aqI();
        }
    }

    public void pc(boolean z) {
        if (this.hXF != null) {
            pa(this.hPu.bUR().asT());
            if (this.hXC) {
                oS(z);
            } else {
                oT(z);
            }
        }
    }

    public void bYU() {
        if (this.hXF != null) {
            this.hXE.setVisibility(8);
            this.hXF.setVisibility(8);
            this.hXK = false;
            if (this.hYd != null) {
                this.hYd.setVisibility(8);
                oW(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.eOg == null) {
            this.eOg = new com.baidu.tbadk.core.view.b(this.hPu.getPageContext());
        }
        this.eOg.em(true);
    }

    public void aVf() {
        if (this.eOg != null) {
            this.eOg.em(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hWr.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hWr.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hWh != null) {
            this.hWh.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hYW = getScrollY();
            this.hYc.hZm = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hYc));
            a(this.hYc.hZm, true);
        }
    }

    public void pd(boolean z) {
        this.hWh.pd(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hWh != null) {
            this.hWh.b(absListView, i);
        }
        if (this.hWn != null && this.hXg != null) {
            this.hWn.cG(this.hXg.bWg());
        }
        this.hYc.hFz = i;
        this.hYc.headerCount = this.hWr.getHeaderViewsCount();
        this.hYc.hZm = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hYc));
        a(this.hYc.hZm, false);
        if (this.fCE.akY() && !this.fCE.cbr) {
            if (this.hYc != null && this.hYc.hZm != null && this.hYc.hZm.getView() != null) {
                i4 = this.hYc.hZm.getView().getTop() < 0 ? this.hYc.hZm.getView().getHeight() : this.hYc.hZm.getView().getBottom();
            }
            this.fCE.jb(i4);
            this.fCE.cbr = true;
        }
    }

    public void bYV() {
        if (this.hPu.isLogin() && this.hSQ != null && this.hYr && !this.hYq && !this.hXA && this.hXN != null && this.hXN.aeC() != null && !this.hXN.aeC().getIsLike() && !this.hXN.aeC().hadConcerned() && this.hYn == null) {
            this.hYn = new an(this.hPu);
        }
    }

    public void bYW() {
        if (this.hYr && !this.hYq && this.hXN != null && this.hXN.aeC() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").P("obj_locate", this.hPu.bUu() ? 2 : 1).P("obj_type", this.hYq ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hPu.getPageContext().getPageActivity(), this.hXN.aeC().getUserId(), this.hXN.aeC().getUserName(), this.hPu.bUE().bUv(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hYq && this.hXW != null && this.hWn.bZF() != null) {
            int bWc = this.hXg.bWc();
            if (bWc > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bWc > this.hWr.getFirstVisiblePosition() - this.hWr.getHeaderViewsCount()) {
                    this.hXW.setVisibility(8);
                    return;
                }
                this.hXW.setVisibility(0);
                bZg();
                this.hWn.mNavigationBar.hideBottomLine();
                if (this.hXW.getParent() != null && ((ViewGroup) this.hXW.getParent()).getHeight() <= this.hXW.getTop()) {
                    this.hXW.getParent().requestLayout();
                }
            } else if (alVar == null || alVar.getView() == null || alVar.hVL == null) {
                if (this.hWr.getFirstVisiblePosition() == 0) {
                    this.hXW.setVisibility(8);
                    this.hWn.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hYb) {
                        this.hYa = top;
                        this.hYb = false;
                    }
                    this.hYa = top < this.hYa ? top : this.hYa;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hXf.getY() < 0.0f) {
                        measuredHeight = hXZ - alVar.hVL.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hWn.bZF().getMeasuredHeight() - alVar.hVL.getMeasuredHeight();
                        this.hWn.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hYa) {
                        this.hXW.setVisibility(0);
                        bZg();
                    } else if (top < measuredHeight) {
                        this.hXW.setVisibility(0);
                        bZg();
                    } else {
                        this.hXW.setVisibility(8);
                        this.hWn.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.hYb = true;
                    }
                }
            }
        }
    }

    public void bYX() {
        if (!this.hYX) {
            TiebaStatic.log("c10490");
            this.hYX = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hPu.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hYg, Integer.valueOf(hYi));
            aVar.hu(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hPu.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aH(inflate);
            aVar.ab(sparseArray);
            aVar.a(R.string.grade_button_tips, this.hPu);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hPu.getPageContext()).agO();
        }
    }

    public void CB(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hPu.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hPu.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aH(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hYg, Integer.valueOf(hYj));
        aVar.ab(sparseArray);
        aVar.a(R.string.view, this.hPu);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hPu.getPageContext()).agO();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(dVar, z)) != null && c.aeC() != null) {
            MetaData aeC = c.aeC();
            aeC.setGiftNum(aeC.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bYY() {
        return this.hXS;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bTy() != null && dVar.bTy().afC() && this.hXS == null) {
            this.hXS = (PbInterviewStatusView) this.hXR.inflate();
            this.hXS.setOnClickListener(this.fyk);
            this.hXS.setCallback(this.hPu.bVD());
            this.hXS.setData(this.hPu, dVar);
        }
    }

    public LinearLayout bYZ() {
        return this.hXf;
    }

    public View bZa() {
        return this.fyx;
    }

    public boolean bZb() {
        return this.hYI;
    }

    public void op(boolean z) {
        this.hWE.op(z);
    }

    public void CC(String str) {
        if (this.hWo != null) {
            this.hWo.setTitle(str);
        }
    }

    private int pe(boolean z) {
        if (this.hXS == null || this.hXS.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.g(this.hPu.getPageContext().getPageActivity(), R.dimen.ds72);
    }

    private void bZc() {
        if (this.hXS != null && this.hXS.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hXS.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hXS.setLayoutParams(layoutParams);
        }
    }

    public boolean bUX() {
        return false;
    }

    public void CD(String str) {
        this.goY.performClick();
        if (!StringUtils.isNull(str) && this.hPu.bUR() != null && this.hPu.bUR().asM() != null && this.hPu.bUR().asM().getInputView() != null) {
            EditText inputView = this.hPu.bUR().asM().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bYL();
            if (configuration.orientation == 2) {
                bYU();
                bXV();
            } else {
                bXY();
            }
            if (this.hYm != null) {
                this.hYm.bWl();
            }
            this.hPu.bnf();
            this.hXf.setVisibility(8);
            this.hWn.po(false);
            this.hPu.ov(false);
            if (this.hWh != null) {
                if (configuration.orientation == 1) {
                    bYZ().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hWr.setIsLandscape(true);
                    this.hWr.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hWr.setIsLandscape(false);
                    if (this.hYW > 0) {
                        this.hWr.smoothScrollBy(this.hYW, 0);
                    }
                }
                this.hWh.onConfigurationChanged(configuration);
                this.hXV.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void pf(boolean z) {
        this.hWl = z;
    }

    public boolean bZd() {
        return this.hWh != null && this.hWh.bZd();
    }

    public void bZe() {
        if (this.hWh != null) {
            this.hWh.onPause();
        }
    }

    public void q(long j, int i) {
        if (this.hWj != null) {
            this.hWj.q(j, i);
        }
        if (this.hWh != null) {
            this.hWh.q(j, i);
        }
    }

    public void oA(boolean z) {
        this.hXg.oA(z);
    }

    public void bZf() {
        if (this.hXT == null) {
            LayoutInflater.from(this.hPu.getActivity()).inflate(R.layout.add_experienced_text, (ViewGroup) this.ewL, true);
            this.hXT = (ViewGroup) this.ewL.findViewById(R.id.add_experienced_layout);
            this.hXU = (TextView) this.ewL.findViewById(R.id.add_experienced);
            com.baidu.tbadk.core.util.am.j(this.hXU, R.color.cp_cont_a);
            String string = this.hPu.getResources().getString(R.string.experienced_add_success);
            String string2 = this.hPu.getResources().getString(R.string.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_h)));
            this.hXU.setText(spannableString);
        }
        this.hXT.setVisibility(0);
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
                        aq.this.hXT.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hXU.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hXU.startAnimation(scaleAnimation);
    }

    public void cF(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hXF.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hPu);
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.hYx = new TextView(this.hPu);
            this.hYx.setText(R.string.connection_tips);
            this.hYx.setGravity(17);
            this.hYx.setPadding(com.baidu.adp.lib.util.l.g(this.hPu, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(this.hPu, R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hPu, R.dimen.ds60);
            if (this.hYx.getParent() == null) {
                frameLayout.addView(this.hYx, layoutParams);
            }
            this.hYw = new PopupWindow(this.hPu);
            this.hYw.setContentView(frameLayout);
            this.hYw.setHeight(-2);
            this.hYw.setWidth(-2);
            this.hYw.setFocusable(true);
            this.hYw.setOutsideTouchable(false);
            this.hYw.setBackgroundDrawable(new ColorDrawable(this.hPu.getResources().getColor(R.color.transparent)));
            this.hWr.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hYw.showAsDropDown(aq.this.hXF, view.getLeft(), -aq.this.hXF.getHeight());
                    } else {
                        aq.this.hYw.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bZg() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("show_long_press_tips", false) && this.hYy == null) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_long_press_tips", true);
            this.hYy = new com.baidu.tbadk.core.dialog.a(this.hPu);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hPu);
            this.hYy.hy(1);
            this.hYy.aH(pbLongPressTipView);
            this.hYy.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hYy.dR(false);
            this.hYy.b(this.hPu.getPageContext()).agO();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hYy != null && aq.this.hYy.isShowing()) {
                        aq.this.hYy.dismiss();
                    }
                }
            }, 5000L);
            if (this.hWh != null) {
                this.hWh.cbb();
            }
        }
    }

    public void pg(boolean z) {
        this.hYD = z;
    }

    public boolean bZh() {
        return this.hYD;
    }

    public PbThreadPostView bZi() {
        return this.hWs;
    }

    private void ab(boolean z, boolean z2) {
        ac(z, z2);
        ad(z, z2);
        if (this.hXg != null && this.hXg.bWh() != null) {
            this.hXg.bWh().a(this.hSQ, z, z2);
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.hSQ != null && this.hSQ.hKP) {
            this.hWC.setImageResource(R.drawable.pic_frs_headlines_n);
            this.hWC.setVisibility(0);
        } else if (z && z2) {
            this.hWC.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hWC.setVisibility(0);
        } else if (z) {
            this.hWC.setImageResource(R.drawable.pic_pb_refined_n);
            this.hWC.setVisibility(0);
        } else if (z2) {
            this.hWC.setImageResource(R.drawable.pic_pb_stick_n);
            this.hWC.setVisibility(0);
        } else {
            this.hWC.setVisibility(8);
        }
    }

    private void ad(boolean z, boolean z2) {
        if (this.hWz != null && this.hSQ != null && this.hSQ.bTy() != null && this.hSQ.bTy().aeR() == 0 && !this.hSQ.bTy().afw()) {
            if (this.hSQ != null && this.hSQ.hKP) {
                this.hWC.setImageResource(R.drawable.pic_frs_headlines_n);
                this.hWC.setVisibility(0);
            } else if (z && z2) {
                this.hWD.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.hWD.setVisibility(0);
            } else if (z) {
                this.hWD.setImageResource(R.drawable.pic_pb_refined_n);
                this.hWD.setVisibility(0);
            } else if (z2) {
                this.hWD.setImageResource(R.drawable.pic_pb_stick_n);
                this.hWD.setVisibility(0);
            } else {
                this.hWD.setVisibility(8);
            }
        }
    }
}
