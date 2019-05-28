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
    private EditorTools TB;
    private TextView aif;
    private h.c bZA;
    private com.baidu.tieba.pb.a.c ckg;
    private View cxO;
    private NoNetworkView eRV;
    private int edh;
    private RelativeLayout epW;
    private View epZ;
    private List<CustomBlueCheckRadioButton> ezV;
    private NavigationBarCoverTip fNt;
    private com.baidu.tieba.NEGFeedBack.e fQm;
    private View.OnClickListener fra;
    private View frn;
    private PbListView fvh;
    private TextView gga;
    PbActivity.d hFu;
    private View.OnClickListener hGO;
    private PbActivity hGp;
    private UserIconBox hHC;
    private UserIconBox hHD;
    private PbFakeFloorModel hIC;
    private com.baidu.tieba.pb.data.d hJK;
    public int hMZ;
    private TextView hNA;
    private TextView hNB;
    private ImageView hNC;
    private HeadPendantView hND;
    private FrameLayout hNE;
    private HeadImageView hNF;
    private View hNG;
    private LinearLayout hNH;
    private PbFirstFloorUserLikeButton hNK;
    private ao hNL;
    private TextView hNM;
    private TextView hNN;
    private TextView hNO;
    private TextView hNP;
    private View hNQ;
    private View hNR;
    private LinearLayout hNS;
    private TextView hNT;
    private TextView hNU;
    private View hNV;
    private View hNW;
    private ObservedChangeLinearLayout hNY;
    private f hNZ;
    public com.baidu.tieba.pb.video.i hNa;
    private long hNb;
    private com.baidu.tieba.pb.video.h hNc;
    private com.baidu.tieba.c.d hNd;
    public final com.baidu.tieba.pb.pb.main.view.c hNg;
    public com.baidu.tieba.pb.pb.main.view.b hNh;
    private ViewStub hNi;
    private ViewStub hNj;
    private PbLandscapeListView hNk;
    private PbThreadPostView hNl;
    private View hNm;
    private RelativeLayout hNn;
    private HeadImageView hNo;
    private TextView hNp;
    private TextView hNq;
    private ImageView hNr;
    private RelativeLayout hNu;
    private ImageView hNv;
    private ImageView hNw;
    private e hNx;
    private ColumnLayout hNy;
    private ThreadSkinView hNz;
    private ImageView hOA;
    private ImageView hOB;
    private TextView hOC;
    private int hOE;
    private int hOF;
    private PostData hOG;
    private View hOI;
    private TextView hOJ;
    private ViewStub hOK;
    private PbInterviewStatusView hOL;
    private ViewGroup hOM;
    private TextView hON;
    private FrameLayout hOO;
    private View hOP;
    private View hOQ;
    private al hOR;
    private PbEmotionBar hOW;
    private View hOf;
    private View hOx;
    private View hOy;
    private ImageView hOz;
    private boolean hPB;
    private com.baidu.tbadk.core.view.userLike.c hPC;
    private com.baidu.tbadk.core.view.userLike.c hPD;
    private Runnable hPI;
    private PbActivity.b hPK;
    public int hPP;
    private Runnable hPe;
    private s hPf;
    private an hPg;
    private int hPm;
    private PbTopTipView hPo;
    private PopupWindow hPp;
    private TextView hPq;
    private com.baidu.tbadk.core.dialog.a hPr;
    private List<String> hPs;
    private com.baidu.tieba.pb.pb.main.emotion.c hPt;
    private com.baidu.tieba.pb.pb.godreply.a hPu;
    private PbLandscapeListView.b hPv;
    private ac hPx;
    private String hPy;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private static final int hOS = UtilHelper.getLightStatusBarHeight();
    public static int hOY = 3;
    public static int hOZ = 0;
    public static int hPa = 3;
    public static int hPb = 4;
    public static int hPc = 5;
    public static int hPd = 6;
    private static a.InterfaceC0407a hPA = new a.InterfaceC0407a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0407a
        public void onRefresh() {
        }
    };
    private boolean hNe = false;
    private int hNf = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hNs = null;
    private TextView hNt = null;
    public FrsPraiseView hNI = null;
    private ClickableHeaderImageView hNJ = null;
    private View hNX = null;
    private com.baidu.tbadk.core.dialog.a hOa = null;
    private com.baidu.tbadk.core.dialog.b fqZ = null;
    private View hOb = null;
    private EditText hOc = null;
    private com.baidu.tieba.pb.view.c hOd = null;
    private com.baidu.tieba.pb.view.a hOe = null;
    private com.baidu.tbadk.core.dialog.a hOg = null;
    private b.a gDH = null;
    private TbRichTextView.h cIM = null;
    private NoNetworkView.a fmv = null;
    private com.baidu.tbadk.core.dialog.i hOh = null;
    private View hOi = null;
    private com.baidu.tbadk.core.dialog.a hOj = null;
    private Dialog hOk = null;
    private Dialog hOl = null;
    private View hOm = null;
    private LinearLayout hOn = null;
    private CompoundButton.OnCheckedChangeListener ezW = null;
    private TextView hOo = null;
    private TextView hOp = null;
    private String hOq = null;
    private com.baidu.tbadk.core.dialog.i hEu = null;
    private com.baidu.tbadk.core.dialog.i hOr = null;
    private boolean hOs = false;
    private boolean hOt = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hOu = null;
    private boolean hOv = false;
    private Button hOw = null;
    private boolean hOD = true;
    private com.baidu.tbadk.core.view.b eHw = null;
    private boolean hGG = false;
    private int mSkinType = 3;
    private boolean hOH = false;
    private int hOT = 0;
    private boolean hOU = true;
    public a hOV = new a();
    private int hOX = 0;
    private boolean hPh = false;
    private int hPi = 0;
    private boolean hPj = false;
    private boolean hPk = false;
    private boolean hPl = false;
    private int hPn = 0;
    private boolean hPw = false;
    private int hPz = R.drawable.bg_user_identity_btn;
    private String hPE = null;
    private CustomMessageListener hPF = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hPE = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hNZ != null) {
                aq.this.hNZ.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hPG = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hNt != null) {
                aq.this.hNt.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hPH = new Handler();
    private CustomMessageListener hPJ = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hOD = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hPL = true;
    View.OnClickListener hPM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hPj) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").P(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hPj && aq.this.hJK != null && aq.this.hJK.bPL() != null && aq.this.hJK.bPL().adv() != null && aq.this.hJK.bPL().adv().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").P("obj_locate", 1));
            }
            aq.this.hGp.hEp.fQV.onClick(view);
        }
    };
    private boolean hPN = false;
    String userId = null;
    private final List<TbImageView> hPO = new ArrayList();
    private boolean hPQ = false;

    /* loaded from: classes4.dex */
    public static class a {
        public al hQf;
        public int headerCount;
        public int hwy;
    }

    public void oy(boolean z) {
        this.hPh = z;
        if (this.hNk != null) {
            this.hPi = this.hNk.getHeaderViewsCount();
        }
    }

    public void bUb() {
        if (this.hNk != null) {
            int headerViewsCount = this.hNk.getHeaderViewsCount() - this.hPi;
            final int firstVisiblePosition = (this.hNk.getFirstVisiblePosition() == 0 || this.hNk.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hNk.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hNk.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hOV.hQf = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOV));
            final al alVar = this.hOV.hQf;
            final int h = h(alVar);
            final int y = ((int) this.hNY.getY()) + this.hNY.getMeasuredHeight();
            final boolean z = this.hOP.getVisibility() == 0;
            boolean z2 = this.hNY.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hNZ.bSm() + this.hNk.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hME.getMeasuredHeight() : 0;
                if (z2) {
                    this.hNk.setSelectionFromTop(this.hNZ.bSm() + this.hNk.getHeaderViewsCount(), hOS - measuredHeight);
                } else {
                    this.hNk.setSelectionFromTop(this.hNZ.bSm() + this.hNk.getHeaderViewsCount(), this.hNg.bVM().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hNk.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hPj) {
                this.hNk.setSelectionFromTop(this.hNZ.bSm() + this.hNk.getHeaderViewsCount(), this.hNa.aHS().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hNk.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bSE() {
                        if (h >= 0 && h <= aq.this.epW.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.epZ.getLayoutParams();
                            if (i == 0 || i > aq.this.epW.getMeasuredHeight() || h2 >= aq.this.epW.getMeasuredHeight()) {
                                layoutParams.height = aq.this.edh;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.epW.getMeasuredHeight()) {
                                layoutParams.height = aq.this.edh;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hNk.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.epZ.setLayoutParams(layoutParams);
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (aq.this.epZ != null && aq.this.epZ.getLayoutParams() != null) {
                                        ViewGroup.LayoutParams layoutParams2 = aq.this.epZ.getLayoutParams();
                                        layoutParams2.height = aq.this.edh;
                                        aq.this.epZ.setLayoutParams(layoutParams2);
                                    }
                                }
                            });
                        }
                        aq.this.hNk.setOnLayoutListener(null);
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

    public NoNetworkView bUc() {
        return this.eRV;
    }

    public void bUd() {
        if (this.TB != null) {
            this.TB.hide();
            if (this.hPt != null) {
                this.hPt.aGN();
            }
        }
    }

    public PbFakeFloorModel bUe() {
        return this.hIC;
    }

    public s bUf() {
        return this.hPf;
    }

    public void bUg() {
        reset();
        bUd();
        this.hPf.bSv();
        oJ(false);
    }

    private void reset() {
        if (this.hGp != null && this.hGp.bRd() != null && this.TB != null) {
            com.baidu.tbadk.editortools.pb.a.arp().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bRd = this.hGp.bRd();
            bRd.arI();
            bRd.ard();
            if (bRd.getWriteImagesInfo() != null) {
                bRd.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bRd.kp(SendView.ALL);
            bRd.kq(SendView.ALL);
            com.baidu.tbadk.editortools.g kg = this.TB.kg(23);
            com.baidu.tbadk.editortools.g kg2 = this.TB.kg(2);
            com.baidu.tbadk.editortools.g kg3 = this.TB.kg(5);
            if (kg2 != null) {
                kg2.pO();
            }
            if (kg3 != null) {
                kg3.pO();
            }
            if (kg != null) {
                kg.hide();
            }
            this.TB.invalidate();
        }
    }

    public boolean bUh() {
        return this.hOD;
    }

    public void oz(boolean z) {
        if (this.hOy != null && this.gga != null) {
            this.gga.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hOy.startAnimation(alphaAnimation);
            }
            this.hOx.setVisibility(0);
            this.hOy.setVisibility(0);
            this.hOD = true;
            if (this.hOW != null && !this.hPu.isActive()) {
                this.hOW.setVisibility(0);
                oD(true);
            }
        }
    }

    public void oA(boolean z) {
        if (this.hOy != null && this.gga != null) {
            this.gga.setText(bUi());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hOy.startAnimation(alphaAnimation);
            }
            this.hOx.setVisibility(0);
            this.hOy.setVisibility(0);
            this.hOD = true;
            if (this.hOW != null && !this.hPu.isActive()) {
                this.hOW.setVisibility(0);
                oD(true);
            }
        }
    }

    public String bUi() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.hPy)) {
            return this.hPy;
        }
        if (this.hGp != null) {
            this.hPy = this.hGp.getResources().getString(ap.bUa());
        }
        return this.hPy;
    }

    public PostData bUj() {
        int i = 0;
        if (this.hNk == null) {
            return null;
        }
        int bUk = bUk() - this.hNk.getHeaderViewsCount();
        if (bUk < 0) {
            bUk = 0;
        }
        if (this.hNZ.xj(bUk) != null && this.hNZ.xj(bUk) != PostData.iYB) {
            i = bUk + 1;
        }
        return this.hNZ.getItem(i) instanceof PostData ? (PostData) this.hNZ.getItem(i) : null;
    }

    public int bUk() {
        int i;
        View childAt;
        if (this.hNk == null) {
            return 0;
        }
        int firstVisiblePosition = this.hNk.getFirstVisiblePosition();
        int lastVisiblePosition = this.hNk.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hNk.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hNk.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bUl() {
        return this.hNk.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hJK != null && this.hJK.bPN() != null && !this.hJK.bPN().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hJK.bPN().size() && (postData = this.hJK.bPN().get(i)) != null && postData.adv() != null && !StringUtils.isNull(postData.adv().getUserId()); i++) {
                if (this.hJK.bPN().get(i).adv().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hPu != null && this.hPu.isActive()) {
                        oJ(false);
                    }
                    if (this.hOW != null) {
                        this.hOW.oR(true);
                    }
                    this.hPE = postData.adv().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hGp = null;
        this.epW = null;
        this.frn = null;
        this.hNb = 0L;
        this.hNk = null;
        this.hNm = null;
        this.hNu = null;
        this.hNy = null;
        this.hNA = null;
        this.hNB = null;
        this.hNE = null;
        this.hNF = null;
        this.hNG = null;
        this.hNK = null;
        this.hNM = null;
        this.hNN = null;
        this.hNO = null;
        this.hNP = null;
        this.hNV = null;
        this.hNW = null;
        this.hNZ = null;
        this.fvh = null;
        this.cxO = null;
        this.fra = null;
        this.hGO = null;
        this.hOy = null;
        this.gga = null;
        this.hOI = null;
        this.hOJ = null;
        this.hOK = null;
        this.hPm = 0;
        this.hNb = System.currentTimeMillis();
        this.hGp = pbActivity;
        this.fra = onClickListener;
        this.ckg = cVar;
        this.hPm = com.baidu.adp.lib.util.l.af(this.hGp) / 2;
        this.epW = (RelativeLayout) LayoutInflater.from(this.hGp.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.hGp.addContentView(this.epW, new FrameLayout.LayoutParams(-1, -1));
        this.fNt = (NavigationBarCoverTip) this.hGp.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.frn = this.hGp.findViewById(R.id.statebar_view);
        this.hNY = (ObservedChangeLinearLayout) this.hGp.findViewById(R.id.title_wrapper);
        this.eRV = (NoNetworkView) this.hGp.findViewById(R.id.view_no_network);
        this.hNk = (PbLandscapeListView) this.hGp.findViewById(R.id.new_pb_list);
        this.hOO = (FrameLayout) this.hGp.findViewById(R.id.root_float_header);
        this.aif = new TextView(this.hGp.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.hGp.getActivity(), R.dimen.ds88));
        this.hNk.addHeaderView(this.aif, 0);
        this.edh = this.hGp.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.epZ = new View(this.hGp.getPageContext().getPageActivity());
        this.epZ.setLayoutParams(new AbsListView.LayoutParams(-1, this.edh));
        this.epZ.setVisibility(4);
        this.hNk.addFooterView(this.epZ);
        this.hNk.setOnTouchListener(this.hGp.clb);
        this.hNg = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.hGp.bRG()) {
            this.hNi = (ViewStub) this.hGp.findViewById(R.id.manga_view_stub);
            this.hNi.setVisibility(0);
            this.hNh = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.hNh.show();
            this.hNg.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hGp.getActivity(), R.dimen.ds120);
        }
        this.aif.setLayoutParams(layoutParams);
        this.hNg.bVM().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0367a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0367a
            public void bQB() {
                if (aq.this.hNk != null) {
                    if (aq.this.hNa != null) {
                        aq.this.hNa.bXf();
                    }
                    aq.this.hNk.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0367a
            public void bQC() {
                aq.this.hGp.bki();
            }
        }));
        this.hOx = this.hGp.findViewById(R.id.view_comment_top_line);
        this.hOy = this.hGp.findViewById(R.id.pb_editor_tool_comment);
        this.hOE = com.baidu.adp.lib.util.l.g(this.hGp.getPageContext().getPageActivity(), R.dimen.tbds120);
        this.hOF = com.baidu.adp.lib.util.l.g(this.hGp.getPageContext().getPageActivity(), R.dimen.ds242);
        this.gga = (TextView) this.hGp.getPageContext().getPageActivity().findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.gga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hGp.bRm();
                if (aq.this.hGp != null && aq.this.hGp.bQR() != null && aq.this.hGp.bQR().getPbData() != null && aq.this.hGp.bQR().getPbData().bPL() != null && aq.this.hGp.bQR().getPbData().bPL().adv() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", aq.this.hGp.bQR().hJo).bT("fid", aq.this.hGp.bQR().getPbData().getForumId()).P("obj_locate", 1).bT("uid", aq.this.hGp.bQR().getPbData().bPL().adv().getUserId()));
                }
            }
        });
        this.hOz = (ImageView) this.hGp.findViewById(R.id.pb_editor_tool_comment_icon);
        this.hOz.setOnClickListener(this.fra);
        this.hOA = (ImageView) this.hGp.findViewById(R.id.pb_editor_tool_collection);
        this.hOA.setOnClickListener(this.fra);
        this.hOB = (ImageView) this.hGp.findViewById(R.id.pb_editor_tool_share);
        this.hOB.setOnClickListener(this.fra);
        this.hOC = (TextView) this.hGp.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.hNm = LayoutInflater.from(this.hGp.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.hNu = (RelativeLayout) LayoutInflater.from(this.hGp.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.hNv = (ImageView) this.hNu.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.hNx = new e(this.hGp, this.hNu);
        this.hNx.init();
        this.hNx.a(this.hNx.bRc(), this.fra);
        this.hNy = (ColumnLayout) this.hNu.findViewById(R.id.pb_head_owner_root);
        this.hNz = (ThreadSkinView) this.hNu.findViewById(R.id.pb_thread_skin);
        this.hNy.setOnLongClickListener(this.onLongClickListener);
        this.hNy.setOnTouchListener(this.ckg);
        this.hNy.setVisibility(8);
        this.hNm.setOnTouchListener(this.ckg);
        this.hOI = this.hNm.findViewById(R.id.pb_head_activity_join_number_container);
        this.hOI.setVisibility(8);
        this.hOJ = (TextView) this.hNm.findViewById(R.id.pb_head_activity_join_number);
        this.hNA = (TextView) this.hNy.findViewById(R.id.pb_head_owner_info_user_name);
        this.hNA.getPaint().setFakeBoldText(true);
        this.hNB = (TextView) this.hNy.findViewById(R.id.floor_owner);
        this.hNC = (ImageView) this.hNy.findViewById(R.id.icon_forum_level);
        this.hNE = (FrameLayout) this.hNy.findViewById(R.id.pb_head_headImage_container);
        this.hNF = (HeadImageView) this.hNy.findViewById(R.id.pb_head_owner_photo);
        this.hND = (HeadPendantView) this.hNy.findViewById(R.id.pb_pendant_head_owner_photo);
        this.hND.setHasPendantStyle();
        if (this.hND.getHeadView() != null) {
            this.hND.getHeadView().setIsRound(true);
            this.hND.getHeadView().setDrawBorder(false);
        }
        this.hHC = (UserIconBox) this.hNy.findViewById(R.id.show_icon_vip);
        this.hHD = (UserIconBox) this.hNy.findViewById(R.id.show_icon_yinji);
        this.hNH = (LinearLayout) this.hNu.findViewById(R.id.pb_head_owner_info_root);
        this.hNK = (PbFirstFloorUserLikeButton) this.hNy.findViewById(R.id.pb_like_button);
        this.hNM = (TextView) this.hNy.findViewById(R.id.pb_views);
        this.hNN = (TextView) this.hNy.findViewById(R.id.pb_item_first_floor_reply_time);
        this.hNO = (TextView) this.hNy.findViewById(R.id.pb_item_first_floor_location_address);
        this.hNP = (TextView) this.hNy.findViewById(R.id.point_between_time_and_locate);
        this.hPC = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hPD = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hNV = this.hNm.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.hNW = this.hNm.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.hNm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hOK = (ViewStub) this.epW.findViewById(R.id.interview_status_stub);
        this.hNQ = this.hNu.findViewById(R.id.blank_view_align_user_item_top);
        this.hNR = this.hNu.findViewById(R.id.blank_view_align_user_item_bottom);
        this.hNZ = new f(this.hGp, this.hNk);
        this.hNZ.z(this.fra);
        this.hNZ.setTbGestureDetector(this.ckg);
        this.hNZ.setOnImageClickListener(this.cIM);
        this.hGO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hGp.c(sparseArray);
                            return;
                        }
                        aq.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.hGp.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hNZ.L(this.hGO);
        bUq();
        bUr();
        this.hNk.addHeaderView(this.hNu);
        this.hNk.addHeaderView(this.hNs);
        this.hNk.addHeaderView(this.hNm);
        this.fvh = new PbListView(this.hGp.getPageContext().getPageActivity());
        this.cxO = this.fvh.getView().findViewById(R.id.pb_more_view);
        if (this.cxO != null) {
            this.cxO.setOnClickListener(this.fra);
            com.baidu.tbadk.core.util.al.k(this.cxO, R.drawable.pb_foot_more_trans_selector);
        }
        this.fvh.aju();
        this.fvh.iM(R.drawable.pb_foot_more_trans_selector);
        this.fvh.iO(R.drawable.pb_foot_more_trans_selector);
        this.hOf = this.hGp.findViewById(R.id.viewstub_progress);
        this.hGp.registerListener(this.hPJ);
        this.hNG = com.baidu.tbadk.ala.b.Zl().n(this.hGp.getActivity(), 2);
        if (this.hNG != null) {
            this.hNG.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hGp.getResources().getDimensionPixelSize(R.dimen.ds10);
            if (this.hNG.getParent() == null) {
                this.hNH.addView(this.hNG, aVar);
            }
        }
        this.hIC = new PbFakeFloorModel(this.hGp.getPageContext());
        this.hPf = new s(this.hGp.getPageContext(), this.hIC, this.epW);
        this.hPf.a(this.hGp.hFp);
        this.hIC.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hIC.o(postData);
                aq.this.hNZ.notifyDataSetChanged();
                aq.this.hPf.bSv();
                aq.this.TB.app();
                aq.this.oJ(false);
            }
        });
        if (this.hGp.bQR() != null && !StringUtils.isNull(this.hGp.bQR().bTp())) {
            this.hGp.showToast(this.hGp.bQR().bTp());
        }
        this.hOP = this.hGp.findViewById(R.id.pb_expand_blank_view);
        this.hOQ = this.hGp.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hOQ.getLayoutParams();
        if (this.hGp.bQR() != null && this.hGp.bQR().bSL()) {
            this.hOP.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hOQ.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hOS;
            this.hOQ.setLayoutParams(layoutParams2);
        }
        this.hOR = new al(this.hGp.getPageContext(), this.hGp.findViewById(R.id.pb_reply_expand_view));
        this.hOR.hME.setVisibility(8);
        this.hOR.N(this.fra);
        this.hGp.registerListener(this.mAccountChangedListener);
        this.hGp.registerListener(this.hPF);
        this.hGp.registerListener(this.hPG);
        bUm();
        oD(false);
    }

    public void buO() {
        if (!this.hGp.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").P("obj_locate", 2).bT("fid", this.mForumId));
        } else if (this.hGp.bRo()) {
            com.baidu.tbadk.editortools.pb.d bRd = this.hGp.bRd();
            if (bRd != null && (bRd.arF() || bRd.arG())) {
                this.hGp.bRd().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.TB != null) {
                bUw();
            }
            if (this.TB != null) {
                this.hOD = false;
                if (this.TB.kj(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hGp, (View) this.TB.kj(2).cqE, false, hPA);
                }
            }
            bVb();
        }
    }

    private void bUm() {
        this.hPu = new com.baidu.tieba.pb.pb.godreply.a(this.hGp, this, (ViewStub) this.epW.findViewById(R.id.more_god_reply_popup));
        this.hPu.v(this.fra);
        this.hPu.L(this.hGO);
        this.hPu.setOnImageClickListener(this.cIM);
        this.hPu.v(this.fra);
        this.hPu.setTbGestureDetector(this.ckg);
    }

    public com.baidu.tieba.pb.pb.godreply.a bUn() {
        return this.hPu;
    }

    public View bUo() {
        return this.hOP;
    }

    public void bUp() {
        if (this.hNk != null) {
            this.hNk.removeHeaderView(this.hNs);
            this.hNk.removeHeaderView(this.hNu);
            this.hNk.removeHeaderView(this.hNn);
            this.hNk.removeHeaderView(this.hNm);
        }
    }

    private void bUq() {
        if (this.hNn == null) {
            this.hNn = (RelativeLayout) LayoutInflater.from(this.hGp).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.hNo = (HeadImageView) this.hNn.findViewById(R.id.iv_pb_video_smart_app_head);
            this.hNo.setIsRound(true);
            this.hNp = (TextView) this.hNn.findViewById(R.id.tv_pb_video_smart_app_title);
            this.hNq = (TextView) this.hNn.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.hNr = (ImageView) this.hNn.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.hNn.setOnClickListener(this.fra);
        }
    }

    private void bUr() {
        if (this.hNs == null) {
            this.hNs = (RelativeLayout) LayoutInflater.from(this.hGp).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.hNw = (ImageView) this.hNs.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.hNw.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
            this.hNw.setImageMatrix(matrix);
            this.hNt = (TextView) this.hNs.findViewById(R.id.tv_pb_title);
            this.hNt.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            this.hNt.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hNt.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.al.j(this.hNt, R.color.cp_cont_b);
            this.hNt.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hNt.setVisibility(8);
            if (this.hNt.getParent() == null) {
                this.hNs.addView(this.hNt);
            }
            this.hNs.setOnTouchListener(this.ckg);
            this.hNs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUs() {
        if (this.hGp.bRG()) {
            this.hNj = (ViewStub) this.hGp.findViewById(R.id.manga_mention_controller_view_stub);
            this.hNj.setVisibility(0);
            if (this.hNS == null) {
                this.hNS = (LinearLayout) this.hGp.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.s.a.a(this.hGp.getPageContext(), this.hNS);
            }
            if (this.hNT == null) {
                this.hNT = (TextView) this.hNS.findViewById(R.id.manga_prev_btn);
            }
            if (this.hNU == null) {
                this.hNU = (TextView) this.hNS.findViewById(R.id.manga_next_btn);
            }
            this.hNT.setOnClickListener(this.fra);
            this.hNU.setOnClickListener(this.fra);
        }
    }

    private void bUt() {
        if (this.hGp.bRG()) {
            if (this.hGp.bRJ() == -1) {
                com.baidu.tbadk.core.util.al.f(this.hNT, R.color.cp_cont_e, 1);
            }
            if (this.hGp.bRK() == -1) {
                com.baidu.tbadk.core.util.al.f(this.hNU, R.color.cp_cont_e, 1);
            }
        }
    }

    public void bUu() {
        if (this.hNS == null) {
            bUs();
        }
        this.hNj.setVisibility(8);
        if (this.hPH != null && this.hPI != null) {
            this.hPH.removeCallbacks(this.hPI);
        }
    }

    public void bUv() {
        if (this.hPH != null) {
            if (this.hPI != null) {
                this.hPH.removeCallbacks(this.hPI);
            }
            this.hPI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hNS == null) {
                        aq.this.bUs();
                    }
                    aq.this.hNj.setVisibility(0);
                }
            };
            this.hPH.postDelayed(this.hPI, 2000L);
        }
    }

    public void oB(boolean z) {
        this.hNg.oB(z);
        if (z && this.hOH) {
            this.fvh.setText(this.hGp.getResources().getString(R.string.click_load_more));
            this.hNk.setNextPage(this.fvh);
            this.hNf = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
        this.TB.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.TB.getParent() == null) {
            this.epW.addView(this.TB, layoutParams);
        }
        this.TB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.TB.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).alp() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).alp() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.aiM();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hGp, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.aa(aq.this.hGp)) {
                            aq.this.hGp.bRd().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hGp.bRd().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bUd();
        this.hGp.bRd().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.TB != null && aq.this.TB.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hPt == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.TB.getId());
                            aq.this.hPt = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hGp.getPageContext(), aq.this.epW, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.aa(aq.this.hPs)) {
                                aq.this.hPt.setData(aq.this.hPs);
                            }
                            aq.this.hPt.b(aq.this.TB);
                        }
                        aq.this.hPt.Bt(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hGp.hEt != null && aq.this.hGp.hEt.bVs() != null) {
                    if (!aq.this.hGp.hEt.bVs().cwh()) {
                        aq.this.hGp.hEt.oO(false);
                    }
                    aq.this.hGp.hEt.bVs().rK(false);
                }
            }
        });
    }

    public void bUw() {
        if (this.hGp != null && this.TB != null) {
            this.TB.pO();
            if (this.hGp.bRd() != null) {
                this.hGp.bRd().arw();
            }
            bVb();
        }
    }

    public void oC(boolean z) {
        if (this.hNk != null && this.aif != null && this.frn != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.frn.setVisibility(0);
                } else {
                    this.frn.setVisibility(8);
                    this.hNk.removeHeaderView(this.aif);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aif.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hOS;
                    this.aif.setLayoutParams(layoutParams);
                }
                bUK();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aif.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + oL(true);
                this.aif.setLayoutParams(layoutParams2);
            }
            bUK();
            bVj();
        }
    }

    public f bUx() {
        return this.hNZ;
    }

    public void a(PbActivity.d dVar) {
        this.hFu = dVar;
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGp);
        kVar.setTitleText(this.hGp.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOh.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hPK != null) {
                                aq.this.hPK.m(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hGp.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hGp.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hGp.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !bVi()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.hGp.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hGp.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hGp.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.W(arrayList);
        if (this.hOh == null) {
            this.hOh = new com.baidu.tbadk.core.dialog.i(this.hGp.getPageContext(), kVar.afZ());
        } else {
            this.hOh.setContentView(kVar.afZ());
        }
        this.hOh.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hPK = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hGp != null && aVar != null) {
            if (this.fQm == null) {
                this.fQm = new com.baidu.tieba.NEGFeedBack.e(this.hGp.getPageContext(), this.hNm);
            }
            AntiData biZ = this.hGp.biZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (biZ != null && biZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.b(sparseArray);
            this.fQm.setDefaultReasonArray(new String[]{this.hGp.getString(R.string.delete_thread_reason_1), this.hGp.getString(R.string.delete_thread_reason_2), this.hGp.getString(R.string.delete_thread_reason_3), this.hGp.getString(R.string.delete_thread_reason_4), this.hGp.getString(R.string.delete_thread_reason_5)});
            this.fQm.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fQm.rs(str);
            this.fQm.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    aq.this.hGp.a(aVar, jSONArray);
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
        sparseArray.put(hOZ, Integer.valueOf(hPa));
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
        this.hOj = new com.baidu.tbadk.core.dialog.a(this.hGp.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hOj.ho(i3);
        } else {
            this.hOj.dR(false);
            this.hOj.mE(str2);
        }
        this.hOj.ab(sparseArray);
        this.hOj.a(R.string.dialog_ok, this.hGp);
        this.hOj.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hOj.dM(true);
        this.hOj.b(this.hGp.getPageContext());
        if (z) {
            this.hOj.afG();
        } else {
            a(this.hOj, i);
        }
    }

    public void ax(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hOm == null) {
            this.hOm = LayoutInflater.from(this.hGp.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.hGp.getLayoutMode().onModeChanged(this.hOm);
        if (this.hOl == null) {
            this.hOl = new Dialog(this.hGp.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hOl.setCanceledOnTouchOutside(true);
            this.hOl.setCancelable(true);
            this.hOu = (ScrollView) this.hOm.findViewById(R.id.good_scroll);
            this.hOl.setContentView(this.hOm);
            WindowManager.LayoutParams attributes = this.hOl.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.hGp.getPageContext().getPageActivity(), R.dimen.ds540);
            this.hOl.getWindow().setAttributes(attributes);
            this.ezW = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hOq = (String) compoundButton.getTag();
                        if (aq.this.ezV != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ezV) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hOq != null && !str.equals(aq.this.hOq)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hOn = (LinearLayout) this.hOm.findViewById(R.id.good_class_group);
            this.hOp = (TextView) this.hOm.findViewById(R.id.dialog_button_cancel);
            this.hOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hOl instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hOl, aq.this.hGp.getPageContext());
                    }
                }
            });
            this.hOo = (TextView) this.hOm.findViewById(R.id.dialog_button_ok);
            this.hOo.setOnClickListener(this.fra);
        }
        this.hOn.removeAllViews();
        this.ezV = new ArrayList();
        CustomBlueCheckRadioButton dM = dM("0", this.hGp.getPageContext().getString(R.string.thread_good_class));
        this.ezV.add(dM);
        dM.setChecked(true);
        this.hOn.addView(dM);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.abV()) && acVar.abW() > 0) {
                    CustomBlueCheckRadioButton dM2 = dM(String.valueOf(acVar.abW()), acVar.abV());
                    this.ezV.add(dM2);
                    View view = new View(this.hGp.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.hGp.getPageContext().getPageActivity(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.al.l(view, R.color.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hOn.addView(view);
                    this.hOn.addView(dM2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hOu.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGp.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGp.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGp.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hOu.setLayoutParams(layoutParams2);
            this.hOu.removeAllViews();
            if (this.hOn != null && this.hOn.getParent() == null) {
                this.hOu.addView(this.hOn);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hOl, this.hGp.getPageContext());
    }

    private CustomBlueCheckRadioButton dM(String str, String str2) {
        Activity pageActivity = this.hGp.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ezW);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bUy() {
        this.hGp.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hGp.hideProgressBar();
        if (z && z2) {
            this.hGp.showToast(this.hGp.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.hGp.showToast(str);
        }
    }

    public void bCa() {
        this.hOf.setVisibility(0);
    }

    public void bBZ() {
        this.hOf.setVisibility(8);
    }

    public View bUz() {
        if (this.hOm != null) {
            return this.hOm.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String bUA() {
        return this.hOq;
    }

    public View getView() {
        return this.epW;
    }

    public void bUB() {
        com.baidu.adp.lib.util.l.b(this.hGp.getPageContext().getPageActivity(), this.hGp.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hGp.hideProgressBar();
        if (z) {
            bUS();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bUT();
        } else {
            bUS();
        }
    }

    public void bUC() {
        this.fvh.aju();
        this.fvh.ajy();
    }

    public void bUD() {
        this.hGp.hideProgressBar();
        ajz();
        this.hNk.completePullRefreshPostDelayed(0L);
        bUO();
    }

    public void bUE() {
        this.hNk.completePullRefreshPostDelayed(0L);
        bUO();
    }

    private void oD(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hNZ.setOnLongClickListener(onLongClickListener);
        if (this.hPu != null) {
            this.hPu.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.hEu != null) {
            this.hEu.dismiss();
            this.hEu = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGp);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hGp.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGp.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGp.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGp.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOr.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hOr = new com.baidu.tbadk.core.dialog.i(this.hGp.getPageContext(), kVar.afZ());
        this.hOr.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.hOr != null) {
            this.hOr.dismiss();
            this.hOr = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGp);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hGp.getPageContext().getString(R.string.save_to_emotion), kVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGp.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOr.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hOr = new com.baidu.tbadk.core.dialog.i(this.hGp.getPageContext(), kVar.afZ());
        this.hOr.showDialog();
    }

    public int bUF() {
        return xA(this.hNk.getFirstVisiblePosition());
    }

    private int xA(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hNk.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hNk.getAdapter() == null || !(this.hNk.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hNk.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bUG() {
        int lastVisiblePosition = this.hNk.getLastVisiblePosition();
        if (this.hNa != null) {
            if (lastVisiblePosition == this.hNk.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return xA(lastVisiblePosition);
    }

    public void xB(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.hNk != null) {
            if (this.hNg == null || this.hNg.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hNg.mNavigationBar.getFixedNavHeight();
                if (!(this.hGp.bRu() != -1)) {
                    if (this.hOQ != null && (layoutParams = (LinearLayout.LayoutParams) this.hOQ.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hOQ.setLayoutParams(layoutParams);
                    }
                    i--;
                    bVn();
                }
                i2 = fixedNavHeight;
            }
            this.hNk.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hNk.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hNk.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hOc.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hNZ.a(dVar, false);
        this.hNZ.notifyDataSetChanged();
        bUO();
        if (this.hPu != null) {
            this.hPu.bQN();
        }
        ArrayList<PostData> bPN = dVar.bPN();
        if (dVar.getPage().acp() == 0 || bPN == null || bPN.size() < dVar.getPage().aco()) {
            if (com.baidu.tbadk.core.util.v.Z(bPN) == 0 || (com.baidu.tbadk.core.util.v.Z(bPN) == 1 && bPN.get(0) != null && bPN.get(0).cmw() == 1)) {
                if (this.hOV == null || this.hOV.hQf == null || this.hOV.hQf.getView() == null) {
                    i = 0;
                } else {
                    i = this.hOV.hQf.getView().getTop() < 0 ? this.hOV.hQf.getView().getHeight() : this.hOV.hQf.getView().getBottom();
                }
                if (this.hGp.bRS()) {
                    this.fvh.W(this.hGp.getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.fvh.W(this.hGp.getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().acp() == 0) {
                    this.fvh.setText(this.hGp.getResources().getString(R.string.list_has_no_more));
                } else {
                    this.fvh.setText(this.hGp.getResources().getString(R.string.load_more));
                }
                this.fvh.ajD();
            }
        }
        o(dVar);
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        if (this.hNI == null) {
            this.hGp.getLayoutMode().onModeChanged(((ViewStub) this.hNm.findViewById(R.id.praise_layout)).inflate());
            this.hNI = (FrsPraiseView) this.hNm.findViewById(R.id.pb_head_praise_view);
            this.hNI.setIsFromPb(true);
            this.hNX = this.hNm.findViewById(R.id.new_pb_header_item_line_above_praise);
            this.hNI.iW(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hNI != null) {
            boolean bUO = bUO();
            this.hNI.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().acq() == 0 && this.hGG) {
                if (bUO) {
                    this.hNW.setVisibility(0);
                    return;
                } else {
                    this.hNW.setVisibility(8);
                    return;
                }
            }
            this.hNW.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bPV() != null) {
            return dVar.bPV();
        }
        if (!com.baidu.tbadk.core.util.v.aa(dVar.bPN())) {
            Iterator<PostData> it = dVar.bPN().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cmw() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bPS();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.adv() != null && postData.adv().getUserTbVipInfoData() != null && postData.adv().getUserTbVipInfoData().getvipIntro() != null) {
            postData.adv().getGodUserData().setIntro(postData.adv().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bPL() == null || dVar.bPL().adv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData adv = dVar.bPL().adv();
        String userId = adv.getUserId();
        HashMap<String, MetaData> userMap = dVar.bPL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = adv;
        }
        postData.Ay(1);
        postData.setId(dVar.bPL().adL());
        postData.setTitle(dVar.bPL().getTitle());
        postData.setTime(dVar.bPL().getCreateTime());
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
        com.baidu.tbadk.data.f cmz;
        String portrait;
        String charSequence;
        if (dVar != null && dVar.bPL() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hNy.setVisibility(8);
            if (dVar.bPL() != null && dVar.bPL().aep() && dVar.bPL().adM() != null) {
                this.hPj = true;
                this.hNg.oY(this.hPj);
                this.hNg.mNavigationBar.hideBottomLine();
                if (this.hNa == null) {
                    this.hNa = new com.baidu.tieba.pb.video.i(this.hGp, this.hNg, dVar.bPL().adM(), this.hNb);
                    this.hNa.a(dVar.bPL().adM(), dVar.bPL(), dVar.getForumId());
                    this.hNa.startPlay();
                } else if (this.hNe) {
                    this.hNa.a(dVar.bPL().adM(), dVar.bPL(), dVar.getForumId());
                    this.hNa.startPlay();
                } else {
                    this.hNa.BF(dVar.getForumId());
                }
                com.baidu.tieba.pb.c.a.a(this.hGp.getUniqueId(), dVar, c, 1, 1);
                if (dVar.bPM() != null && dVar.bPM().size() >= 1) {
                    bg bgVar = dVar.bPM().get(0);
                    this.hNa.aB(bgVar);
                    this.hNa.BG(bgVar.getTitle());
                }
                this.hNa.b(c, dVar.bPL(), dVar.bQi());
                this.hNe = false;
                this.hNk.removeHeaderView(this.hNa.bXh());
                this.hNk.addHeaderView(this.hNa.bXh(), 0);
                if (this.hNa.aHS() != null && this.hNa.aHS().getParent() == null) {
                    this.hOO.addView(this.hNa.aHS());
                }
                if (this.hNc == null) {
                    this.hNc = new com.baidu.tieba.pb.video.h(this.hGp);
                }
                this.hNc.a(dVar.bPL().aeF(), dVar.bPL(), dVar.bQf());
                this.hNk.removeHeaderView(this.hNc.bWU());
                this.hNk.addHeaderView(this.hNc.bWU(), 1);
                if (dVar.bPL().aeF() != null) {
                    this.hNk.removeHeaderView(this.hNc.bWV());
                    this.hNk.removeHeaderView(this.hNu);
                    this.hNk.addHeaderView(this.hNc.bWV(), 2);
                } else {
                    if (this.hNc.bWV() != null) {
                        this.hNk.removeHeaderView(this.hNc.bWV());
                    }
                    this.hNk.removeHeaderView(this.hNu);
                    this.hNk.addHeaderView(this.hNu, 2);
                }
                if (this.hNa != null) {
                    this.hNg.oU(false);
                    this.hNa.xI(TbadkCoreApplication.getInst().getSkinType());
                }
                bUK();
            } else {
                this.hPj = false;
                this.hNg.oY(this.hPj);
                if (this.hNa != null) {
                    this.hNk.removeHeaderView(this.hNa.bXh());
                }
                if (this.hNc != null) {
                    this.hNc.b(this.hNk);
                }
            }
            if (this.hGp.bRg() != null) {
                this.hGp.bRg().oS(this.hPj);
            }
            if (this.hNa != null) {
                this.hNa.P(this.hPM);
                bVn();
            }
            if (c != null) {
                this.hOG = c;
                this.hNy.setVisibility(0);
                if (this.hGp.bQH()) {
                    if (dVar.bPK() != null) {
                        this.mForumName = dVar.bPK().getForumName();
                        this.mForumId = dVar.bPK().getForumId();
                    }
                    if (this.mForumName == null && this.hGp.bQR() != null && this.hGp.bQR().bQI() != null) {
                        this.mForumName = this.hGp.bQR().bQI();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hNy.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hNy.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_clip_board, c);
                sparseArray.put(R.id.tag_is_subpb, false);
                if (dVar.bPL().aep() && dVar.bPL().aeh() != null) {
                    SmartApp aeh = dVar.bPL().aeh();
                    this.hNn.setVisibility(0);
                    this.hNk.removeHeaderView(this.hNn);
                    this.hNk.addHeaderView(this.hNn, 1);
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh.avatar)) {
                        this.hNo.startLoad(aeh.avatar, 10, false, false);
                    }
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh.name)) {
                        charSequence = aeh.name + " " + ((Object) this.hGp.getText(R.string.smart_app_suffix));
                    } else {
                        charSequence = this.hGp.getText(R.string.intelligent_smart_app).toString();
                    }
                    this.hNp.setText(charSequence);
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh._abstract)) {
                        this.hNq.setText(aeh._abstract);
                    } else {
                        this.hNq.setText(this.hGp.getText(R.string.smart_app_default_abstract));
                    }
                    this.hNn.setTag(aeh);
                } else {
                    this.hNn.setVisibility(8);
                    this.hNk.removeHeaderView(this.hNn);
                }
                if (!this.hPB) {
                    this.hNs.setVisibility(0);
                }
                if (!dVar.bPL().aep() && this.hNt.getText() != null && this.hNt.getText().length() > 0) {
                    this.hNt.setVisibility(0);
                } else {
                    this.hNt.setVisibility(8);
                }
                n(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> adG = dVar.bPL().adG();
                if (adG != null && adG.size() > 0 && !this.hPB) {
                    this.hOJ.setText(String.valueOf(adG.get(0).abC()));
                    this.hOI.setVisibility(0);
                } else {
                    this.hOI.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.k(this.hOI, R.drawable.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.f(this.hOJ, R.color.cp_link_tip_d, 1);
                if (c.adv() != null) {
                    String string = c.adv().getName_show() == null ? StringUtils.string(c.adv().getUserName()) : StringUtils.string(c.adv().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(c.adv().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bj(c.adv().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bj(string) > 12) {
                            j = com.baidu.tbadk.core.util.ap.j(string, 12, "...");
                            ArrayList<IconData> iconInfo = c.adv().getIconInfo();
                            tShowInfoNew = c.adv().getTShowInfoNew();
                            if (this.hHD != null) {
                                this.hHD.setTag(R.id.tag_user_id, c.adv().getUserId());
                                this.hHD.setOnClickListener(this.hGp.hEp.hRF);
                                this.hHD.a(iconInfo, 4, this.hGp.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGp.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGp.getResources().getDimensionPixelSize(R.dimen.tbds12));
                            }
                            if (this.hHC != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hHC.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hHC.setOnClickListener(this.hGp.hEp.hRG);
                                this.hHC.a(tShowInfoNew, 3, this.hGp.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGp.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGp.getResources().getDimensionPixelSize(R.dimen.ds12), true);
                            }
                            this.hNA.setText(bX(c.adv().getSealPrefix(), j));
                            this.hNA.setTag(R.id.tag_user_id, c.adv().getUserId());
                            this.hNA.setTag(R.id.tag_user_name, c.adv().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || c.adv().isBigV()) {
                                com.baidu.tbadk.core.util.al.f(this.hNA, R.color.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.f(this.hNA, R.color.cp_cont_b, 1);
                            }
                            if (c.adv() == null) {
                                MetaData adv = c.adv();
                                if (adv.getIs_bawu() == 1 && "manager".equals(adv.getBawu_type())) {
                                    this.hNB.setText(R.string.bawu_member_bazhu_tip);
                                    this.hNB.setVisibility(0);
                                    this.hPz = R.drawable.author_bazhu_bg;
                                    com.baidu.tbadk.core.util.al.k(this.hNB, this.hPz);
                                } else if (adv.getIs_bawu() == 1 && "assist".equals(adv.getBawu_type())) {
                                    this.hNB.setText(R.string.bawu_member_xbazhu_tip);
                                    this.hNB.setVisibility(0);
                                    this.hPz = R.drawable.author_small_bazhu;
                                    com.baidu.tbadk.core.util.al.k(this.hNB, this.hPz);
                                } else {
                                    this.hNB.setVisibility(8);
                                }
                            } else {
                                this.hNB.setVisibility(8);
                            }
                            if (dVar.bPL().adv() != null && dVar.bPL().adv().getAlaUserData() != null && this.hNG != null) {
                                if (dVar.bPL().adv().getAlaUserData().anchor_live != 0) {
                                    this.hNG.setVisibility(8);
                                } else {
                                    this.hNG.setVisibility(0);
                                    if (this.hNd == null) {
                                        this.hNd = new com.baidu.tieba.c.d(this.hGp.getPageContext(), this.hNG);
                                        this.hNd.pM(1);
                                    }
                                    this.hNd.cH(this.hGp.getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bzQ = dVar.bPL().adv().getAlaUserData();
                                    aVar.type = 2;
                                    this.hNG.setTag(aVar);
                                }
                            }
                            this.hNF.setUserId(c.adv().getUserId());
                            this.hNF.setUserName(c.adv().getUserName());
                            this.hNF.setTid(c.getId());
                            this.hNF.setFid(this.hJK == null ? this.hJK.getForumId() : "");
                            this.hNF.setImageDrawable(null);
                            this.hNF.setRadius(com.baidu.adp.lib.util.l.g(this.hGp.getActivity(), R.dimen.ds40));
                            this.hNF.setTag(c.adv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hNN.setText(com.baidu.tbadk.core.util.ap.aE(c.getTime()));
                            } else {
                                this.hNN.setText(com.baidu.tbadk.core.util.ap.aC(c.getTime()));
                            }
                            cmz = c.cmz();
                            if (cmz == null && !TextUtils.isEmpty(cmz.getName()) && !TextUtils.isEmpty(cmz.getName().trim())) {
                                this.hNO.setVisibility(0);
                                this.hNP.setVisibility(0);
                                this.hNO.setText(cmz.getName());
                            } else {
                                this.hNO.setVisibility(8);
                                this.hNP.setVisibility(8);
                            }
                            portrait = c.adv().getPortrait();
                            if (c.adv().getPendantData() == null && !StringUtils.isNull(c.adv().getPendantData().abS())) {
                                this.hND.b(c.adv());
                                this.hNF.setVisibility(8);
                                this.hND.setVisibility(0);
                                if (this.hNJ != null) {
                                    this.hNJ.setVisibility(8);
                                }
                                this.hNA.setOnClickListener(this.hPM);
                                this.hND.getHeadView().startLoad(portrait, 28, false);
                                this.hND.getHeadView().setUserId(c.adv().getUserId());
                                this.hND.getHeadView().setUserName(c.adv().getUserName());
                                this.hND.getHeadView().setTid(c.getId());
                                this.hND.getHeadView().setFid(this.hJK != null ? this.hJK.getForumId() : "");
                                this.hND.getHeadView().setOnClickListener(this.hPM);
                                this.hND.ox(c.adv().getPendantData().abS());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hNF, c.adv());
                                this.hNF.setVisibility(0);
                                this.hNy.setOnClickListener(this.hPM);
                                this.hNA.setOnClickListener(this.hPM);
                                this.hNF.setOnClickListener(this.hPM);
                                this.hND.setVisibility(8);
                                this.hNF.startLoad(portrait, 28, false);
                            }
                            String name_show = c.adv().getName_show();
                            String userName = c.adv().getUserName();
                            if (com.baidu.tbadk.t.as.iE() && name_show != null && !name_show.equals(userName)) {
                                this.hNA.setText(com.baidu.tieba.pb.c.aD(this.hGp.getPageContext().getPageActivity(), this.hNA.getText().toString()));
                                this.hNA.setGravity(16);
                                this.hNA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPu());
                                com.baidu.tbadk.core.util.al.f(this.hNA, R.color.cp_other_e, 1);
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo2 = c.adv().getIconInfo();
                        tShowInfoNew = c.adv().getTShowInfoNew();
                        if (this.hHD != null) {
                        }
                        if (this.hHC != null) {
                        }
                        this.hNA.setText(bX(c.adv().getSealPrefix(), j));
                        this.hNA.setTag(R.id.tag_user_id, c.adv().getUserId());
                        this.hNA.setTag(R.id.tag_user_name, c.adv().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.f(this.hNA, R.color.cp_cont_h, 1);
                        if (c.adv() == null) {
                        }
                        if (dVar.bPL().adv() != null) {
                            if (dVar.bPL().adv().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hNF.setUserId(c.adv().getUserId());
                        this.hNF.setUserName(c.adv().getUserName());
                        this.hNF.setTid(c.getId());
                        this.hNF.setFid(this.hJK == null ? this.hJK.getForumId() : "");
                        this.hNF.setImageDrawable(null);
                        this.hNF.setRadius(com.baidu.adp.lib.util.l.g(this.hGp.getActivity(), R.dimen.ds40));
                        this.hNF.setTag(c.adv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cmz = c.cmz();
                        if (cmz == null) {
                        }
                        this.hNO.setVisibility(8);
                        this.hNP.setVisibility(8);
                        portrait = c.adv().getPortrait();
                        if (c.adv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hNF, c.adv());
                        this.hNF.setVisibility(0);
                        this.hNy.setOnClickListener(this.hPM);
                        this.hNA.setOnClickListener(this.hPM);
                        this.hNF.setOnClickListener(this.hPM);
                        this.hND.setVisibility(8);
                        this.hNF.startLoad(portrait, 28, false);
                        String name_show2 = c.adv().getName_show();
                        String userName2 = c.adv().getUserName();
                        if (com.baidu.tbadk.t.as.iE()) {
                            this.hNA.setText(com.baidu.tieba.pb.c.aD(this.hGp.getPageContext().getPageActivity(), this.hNA.getText().toString()));
                            this.hNA.setGravity(16);
                            this.hNA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPu());
                            com.baidu.tbadk.core.util.al.f(this.hNA, R.color.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bj(string) > 14) {
                            j = com.baidu.tbadk.core.util.ap.j(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.adv().getIconInfo();
                            tShowInfoNew = c.adv().getTShowInfoNew();
                            if (this.hHD != null) {
                            }
                            if (this.hHC != null) {
                            }
                            this.hNA.setText(bX(c.adv().getSealPrefix(), j));
                            this.hNA.setTag(R.id.tag_user_id, c.adv().getUserId());
                            this.hNA.setTag(R.id.tag_user_name, c.adv().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.f(this.hNA, R.color.cp_cont_h, 1);
                            if (c.adv() == null) {
                            }
                            if (dVar.bPL().adv() != null) {
                            }
                            this.hNF.setUserId(c.adv().getUserId());
                            this.hNF.setUserName(c.adv().getUserName());
                            this.hNF.setTid(c.getId());
                            this.hNF.setFid(this.hJK == null ? this.hJK.getForumId() : "");
                            this.hNF.setImageDrawable(null);
                            this.hNF.setRadius(com.baidu.adp.lib.util.l.g(this.hGp.getActivity(), R.dimen.ds40));
                            this.hNF.setTag(c.adv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cmz = c.cmz();
                            if (cmz == null) {
                            }
                            this.hNO.setVisibility(8);
                            this.hNP.setVisibility(8);
                            portrait = c.adv().getPortrait();
                            if (c.adv().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hNF, c.adv());
                            this.hNF.setVisibility(0);
                            this.hNy.setOnClickListener(this.hPM);
                            this.hNA.setOnClickListener(this.hPM);
                            this.hNF.setOnClickListener(this.hPM);
                            this.hND.setVisibility(8);
                            this.hNF.startLoad(portrait, 28, false);
                            String name_show22 = c.adv().getName_show();
                            String userName22 = c.adv().getUserName();
                            if (com.baidu.tbadk.t.as.iE()) {
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo222 = c.adv().getIconInfo();
                        tShowInfoNew = c.adv().getTShowInfoNew();
                        if (this.hHD != null) {
                        }
                        if (this.hHC != null) {
                        }
                        this.hNA.setText(bX(c.adv().getSealPrefix(), j));
                        this.hNA.setTag(R.id.tag_user_id, c.adv().getUserId());
                        this.hNA.setTag(R.id.tag_user_name, c.adv().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.f(this.hNA, R.color.cp_cont_h, 1);
                        if (c.adv() == null) {
                        }
                        if (dVar.bPL().adv() != null) {
                        }
                        this.hNF.setUserId(c.adv().getUserId());
                        this.hNF.setUserName(c.adv().getUserName());
                        this.hNF.setTid(c.getId());
                        this.hNF.setFid(this.hJK == null ? this.hJK.getForumId() : "");
                        this.hNF.setImageDrawable(null);
                        this.hNF.setRadius(com.baidu.adp.lib.util.l.g(this.hGp.getActivity(), R.dimen.ds40));
                        this.hNF.setTag(c.adv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cmz = c.cmz();
                        if (cmz == null) {
                        }
                        this.hNO.setVisibility(8);
                        this.hNP.setVisibility(8);
                        portrait = c.adv().getPortrait();
                        if (c.adv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hNF, c.adv());
                        this.hNF.setVisibility(0);
                        this.hNy.setOnClickListener(this.hPM);
                        this.hNA.setOnClickListener(this.hPM);
                        this.hNF.setOnClickListener(this.hPM);
                        this.hND.setVisibility(8);
                        this.hNF.startLoad(portrait, 28, false);
                        String name_show222 = c.adv().getName_show();
                        String userName222 = c.adv().getUserName();
                        if (com.baidu.tbadk.t.as.iE()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hNx.at(dVar.bPL());
                }
                if (this.hOR != null) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBX);
                    if (dVar != null && dVar.bPL() != null) {
                        iVar.hBZ = dVar.bPL().adm();
                    }
                    iVar.isNew = !this.hGG;
                    iVar.sortType = dVar.hBF;
                    if (dVar.hBE != null && dVar.hBE.size() > dVar.hBF) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hBE.size()) {
                                break;
                            } else if (dVar.hBE.get(i4).sort_type.intValue() != dVar.hBF) {
                                i3 = i4 + 1;
                            } else {
                                iVar.hCb = dVar.hBE.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    iVar.hCc = this.hGp.bRS();
                    this.hOR.a(iVar);
                }
                if (dVar != null && dVar.bPL() != null) {
                    aa(dVar.bPL().adr() == 1, dVar.bPL().adq() == 1);
                }
                com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hNZ != null && aq.this.hNg != null && aq.this.hNg.hSF != null && aq.this.hJK != null && aq.this.hJK.bPL() != null && !aq.this.hJK.bPL().aep() && !aq.this.bUN() && aq.this.hJK.getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(aq.this.hJK.getForum().getName())) {
                            if (aq.this.hNZ.bSq() == null || !aq.this.hNZ.bSq().isShown()) {
                                aq.this.hNg.hSF.setVisibility(0);
                                if (aq.this.hGp != null && aq.this.hGp.bQR() != null) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13400");
                                    amVar.bT("tid", aq.this.hGp.bQR().bSI());
                                    amVar.bT("fid", aq.this.hGp.bQR().getForumId());
                                    amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(amVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void oE(boolean z) {
        if (z) {
            bUH();
        } else {
            bed();
        }
        this.hOV.hQf = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOV));
        a(this.hOV.hQf, false);
    }

    public void bUH() {
        if (this.hNg != null && !this.hPl) {
            this.hNg.oZ(!StringUtils.isNull(this.hGp.bRr()));
            this.hPl = true;
        }
    }

    public void bed() {
        if (this.hNg != null) {
            this.hNg.bVT();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.adQ() != null) {
            this.hNz.setData(this.hGp.getPageContext(), dVar.bPN().get(0).adQ(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bPL().getId(), this.hGp.bRP() ? "FRS" : null));
            this.hNy.setPadding(this.hNy.getPaddingLeft(), (int) this.hGp.getResources().getDimension(R.dimen.ds20), this.hNy.getPaddingRight(), this.hNy.getPaddingBottom());
            return;
        }
        this.hNz.setData(null, null, null);
    }

    public void bUI() {
        if (this.hNa != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").P("obj_type", 1));
            this.hNa.bXf();
            this.hNk.smoothScrollToPosition(0);
        }
    }

    public boolean bUJ() {
        return this.hPN;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean av(bg bgVar) {
        if (bgVar == null || bgVar.adv() == null || bgVar.adv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.adv().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.hNg.bVR();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hNg.zf(cVar.forumName);
            }
            String string = this.hGp.getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.f(cVar.source, 0)) {
                case 100:
                    str = this.hGp.getResources().getString(R.string.self);
                    break;
                case 300:
                    str = this.hGp.getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = this.hGp.getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hAY;
            this.hGp.showNetRefreshView(this.epW, format, null, this.hGp.getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.ki()) {
                        ba.aiz().c(aq.this.hGp.getPageContext(), new String[]{str2});
                        aq.this.hGp.finish();
                        return;
                    }
                    aq.this.hGp.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bTS;
        Parcelable bTS2;
        if (dVar != null) {
            this.hJK = dVar;
            this.mType = i;
            if (dVar.bPL() != null) {
                this.hOX = dVar.bPL().add();
                if (dVar.bPL().getAnchorLevel() != 0) {
                    this.hPN = true;
                }
                this.hOt = av(dVar.bPL());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.hOH = false;
            this.hGG = z;
            bUD();
            if (dVar.hBG != null && dVar.hBG.bQm()) {
                if (this.hNl == null) {
                    this.hNl = new PbThreadPostView(this.hGp);
                    this.hNk.addHeaderView(this.hNl, 1);
                    this.hNl.setData(dVar);
                    this.hNl.setChildOnClickLinstener(this.fra);
                }
            } else if (this.hNl != null && this.hNk != null) {
                this.hNk.removeHeaderView(this.hNl);
            }
            b(dVar, z, i);
            p(dVar);
            if (this.hPx == null) {
                this.hPx = new ac(this.hGp.getPageContext(), this.fNt);
            }
            this.hPx.Bk(dVar.bPQ());
            if (this.hGp.bRG()) {
                if (this.hOd == null) {
                    this.hOd = new com.baidu.tieba.pb.view.c(this.hGp.getPageContext());
                    this.hOd.nG();
                    this.hOd.setListPullRefreshListener(this.bZA);
                }
                this.hNk.setPullRefresh(this.hOd);
                bUK();
                if (this.hOd != null) {
                    this.hOd.iP(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().acq() == 0 && z) {
                this.hNk.setPullRefresh(null);
            } else {
                if (this.hOd == null) {
                    this.hOd = new com.baidu.tieba.pb.view.c(this.hGp.getPageContext());
                    this.hOd.nG();
                    this.hOd.setListPullRefreshListener(this.bZA);
                }
                this.hNk.setPullRefresh(this.hOd);
                bUK();
                if (this.hOd != null) {
                    this.hOd.iP(TbadkCoreApplication.getInst().getSkinType());
                }
                aSG();
            }
            bUO();
            this.hNZ.nS(this.hGG);
            this.hNZ.nT(false);
            this.hNZ.oe(i == 5);
            this.hNZ.of(i == 6);
            this.hNZ.og(z2 && this.hPL);
            this.hNZ.a(dVar, false);
            this.hNZ.notifyDataSetChanged();
            if (this.hGp.bQH()) {
                this.hPn = 0;
                PostData c = c(dVar, z);
                if (c != null && c.adv() != null) {
                    this.hPn = c.adv().getLevel_id();
                }
                if (this.hPn > 0) {
                    this.hNC.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.hNC, BitmapHelper.getGradeResourceIdInEnterForum(this.hPn));
                } else {
                    this.hNC.setVisibility(8);
                }
            } else {
                this.hNC.setVisibility(8);
            }
            if (dVar.bPL() != null && dVar.bPL().adh() != null) {
                if (dVar.bPL().adh().getNum() < 1) {
                    this.hGp.getResources().getString(R.string.zan);
                } else {
                    String str = dVar.bPL().adh().getNum() + "";
                }
                if (this.hMZ != -1) {
                    dVar.bPL().adh().setIsLike(this.hMZ);
                }
            }
            if (this.hGp.isLogin()) {
                this.hNk.setNextPage(this.fvh);
                this.hNf = 2;
                aSG();
            } else {
                this.hOH = true;
                if (dVar.getPage().acp() == 1) {
                    if (this.hOe == null) {
                        this.hOe = new com.baidu.tieba.pb.view.a(this.hGp.getPageContext());
                    }
                    this.hNk.setNextPage(this.hOe);
                } else {
                    this.hNk.setNextPage(this.fvh);
                }
                this.hNf = 3;
            }
            ArrayList<PostData> bPN = dVar.bPN();
            if (dVar.getPage().acp() == 0 || bPN == null || bPN.size() < dVar.getPage().aco()) {
                if (com.baidu.tbadk.core.util.v.Z(bPN) == 0 || (com.baidu.tbadk.core.util.v.Z(bPN) == 1 && bPN.get(0) != null && bPN.get(0).cmw() == 1)) {
                    if (this.hOV == null || this.hOV.hQf == null || this.hOV.hQf.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hOV.hQf.getView().getTop() < 0 ? this.hOV.hQf.getView().getHeight() : this.hOV.hQf.getView().getBottom();
                    }
                    if (this.hGp.bRS()) {
                        this.fvh.W(this.hGp.getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.fvh.W(this.hGp.getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.hGp.bRg() != null && !this.hGp.bRg().bVG()) {
                        this.hGp.bRg().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().acp() == 0) {
                        this.fvh.setText(this.hGp.getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.fvh.setText(this.hGp.getResources().getString(R.string.load_more));
                    }
                    this.fvh.ajD();
                }
                bUW();
            } else {
                if (z2) {
                    if (this.hPL) {
                        ajz();
                        if (dVar.getPage().acp() != 0) {
                            this.fvh.setText(this.hGp.getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.fvh.aju();
                        this.fvh.showLoading();
                    }
                } else {
                    this.fvh.aju();
                    this.fvh.showLoading();
                }
                this.fvh.ajD();
            }
            switch (i) {
                case 2:
                    this.hNk.setSelection(i2 > 1 ? (((this.hNk.getData() == null && dVar.bPN() == null) ? 0 : (this.hNk.getData().size() - dVar.bPN().size()) + this.hNk.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bTS2 = aj.bTR().bTS()) != null) {
                        this.hNk.onRestoreInstanceState(bTS2);
                        if (com.baidu.tbadk.core.util.v.Z(bPN) > 1 && dVar.getPage().acp() > 0) {
                            this.fvh.ajz();
                            this.fvh.setText(this.hGp.getString(R.string.pb_load_more_without_point));
                            this.fvh.ajv();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hPL = false;
                    break;
                case 5:
                    this.hNk.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bTS = aj.bTR().bTS()) != null) {
                        this.hNk.onRestoreInstanceState(bTS);
                        break;
                    } else {
                        this.hNk.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.hNa != null && this.hNa.aHS() != null) {
                            if (this.hGp.isUseStyleImmersiveSticky()) {
                                this.hNk.setSelectionFromTop((this.hNZ.bSl() + this.hNk.getHeaderViewsCount()) - 1, this.hNa.aHS().getHeight() - com.baidu.adp.lib.util.l.r(this.hGp.getPageContext().getPageActivity()));
                            } else {
                                this.hNk.setSelectionFromTop((this.hNZ.bSl() + this.hNk.getHeaderViewsCount()) - 1, this.hNa.aHS().getHeight());
                            }
                        } else {
                            this.hNk.setSelection(this.hNZ.bSl() + this.hNk.getHeaderViewsCount());
                        }
                    } else {
                        this.hNk.setSelection(i2 > 0 ? ((this.hNk.getData() == null && dVar.bPN() == null) ? 0 : (this.hNk.getData().size() - dVar.bPN().size()) + this.hNk.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fvh.ajz();
                    this.fvh.setText(this.hGp.getString(R.string.pb_load_more_without_point));
                    this.fvh.ajv();
                    break;
            }
            if (this.hOX == hOY && isHost()) {
                bVe();
            }
            if (this.hPh) {
                bUb();
                this.hPh = false;
                if (i3 == 0) {
                    oy(true);
                }
            }
            if (this.hNc != null) {
                this.hNc.aA(dVar.bPL());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hBC == 1 || dVar.hBD == 1) {
                if (this.hPo == null) {
                    this.hPo = new PbTopTipView(this.hGp);
                }
                if (dVar.hBD == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hGp.getStType())) {
                    this.hPo.setText(this.hGp.getString(R.string.pb_read_strategy_add_experience));
                    this.hPo.show(this.epW, this.mSkinType);
                } else if (dVar.hBC == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hGp.getStType())) {
                    this.hPo.setText(this.hGp.getString(R.string.pb_read_news_add_experience));
                    this.hPo.show(this.epW, this.mSkinType);
                }
            }
            o(dVar);
        }
    }

    private void o(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPL() != null) {
            if (dVar.ZC()) {
                com.baidu.tbadk.core.util.al.c(this.hOA, (int) R.drawable.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.al.c(this.hOA, (int) R.drawable.icon_pb_bottom_collect_n);
            }
            this.hOC.setText(xC(dVar.bPL().adm()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, dVar.bPL()));
        }
    }

    private String xC(int i) {
        if (i == 0) {
            return this.hGp.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void bUK() {
        if (this.hNa != null && this.hNa.aHS() != null) {
            this.hNk.removeHeaderView(this.aif);
            if (this.mType != 1) {
                this.hNk.removeHeaderView(this.hNa.bXh());
                this.hNk.addHeaderView(this.hNa.bXh(), 0);
                return;
            }
            return;
        }
        if (this.hNa != null) {
            this.hNk.removeHeaderView(this.hNa.bXh());
        }
        this.hNk.removeHeaderView(this.aif);
        this.hNk.addHeaderView(this.aif, 0);
    }

    public void oF(boolean z) {
        this.hOs = z;
    }

    public void ajz() {
        if (this.fvh != null) {
            this.fvh.ajv();
            this.fvh.ajz();
        }
        aSG();
    }

    public void aUH() {
        this.hNk.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hOG != null && this.hOG.adv() != null && this.hNg != null) {
            this.hPk = !this.hPj;
            this.hNg.oU(this.hPk);
            if (this.hGp.bRg() != null) {
                this.hGp.bRg().oT(this.hPk);
            }
            bUL();
            if (this.hGp != null && !this.hGp.bQH() && !com.baidu.tbadk.core.util.v.aa(dVar.bQg())) {
                bc bcVar = dVar.bQg().get(0);
                if (bcVar != null) {
                    this.hNg.dN(bcVar.getForumName(), bcVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hNg.dN(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hPk) {
                if (this.hOt) {
                    this.hNK.setVisibility(8);
                    this.hNM.setVisibility(0);
                    this.hNM.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.ap.aI(dVar.bQh())));
                }
                if (this.hOQ != null) {
                    this.hOQ.setVisibility(8);
                }
                if (this.hPv == null) {
                    this.hPv = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hPm) {
                                aq.this.bVd();
                            }
                            aq.this.bUE();
                        }
                    };
                }
                this.hNk.setListViewDragListener(this.hPv);
                return;
            }
            if (this.hOQ != null) {
                this.hOQ.setVisibility(0);
            }
            if (this.hOt) {
                this.hNK.setVisibility(8);
                this.hNM.setVisibility(0);
                this.hNM.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.ap.aI(dVar.bQh())));
            } else if (!com.baidu.tbadk.t.au.auI() || (this.hOG.adv().hadConcerned() && this.hOG.adv().getGodUserData() != null && this.hOG.adv().getGodUserData().getIsFromNetWork())) {
                this.hNK.setVisibility(8);
                this.hNM.setVisibility(8);
            } else {
                this.hNM.setVisibility(8);
            }
            this.hPv = null;
            this.hNk.setListViewDragListener(null);
        }
    }

    private void bUL() {
        String threadId = this.hJK != null ? this.hJK.getThreadId() : "";
        int bUM = bUM();
        if (this.hPk && this.hOG != null && this.hOG.adv() != null) {
            this.hOG.adv().setIsLike(this.hOG.adv().hadConcerned());
        }
        if (this.hNL == null) {
            this.hNL = new ao(this.hGp.getPageContext(), this.hNK, 1);
            this.hNL.i(this.hGp.getUniqueId());
            this.hNL.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void es(boolean z) {
                    if (aq.this.hGp != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hGp, (int) R.string.attention_success);
                    }
                }
            });
        }
        if (this.hOG != null && this.hOG.adv() != null) {
            this.hOG.adv().setIsLike(this.hOG.adv().hadConcerned());
            this.hNL.a(this.hOG.adv());
            this.hNL.setTid(threadId);
        }
        this.hNL.hMV = this.hPj;
        this.hNL.xz(bUM);
    }

    public int bUM() {
        if (this.hJK == null || this.hJK.bPL() == null) {
            return 0;
        }
        if (this.hJK.bPL().aeN()) {
            return (com.baidu.tbadk.core.util.v.aa(this.hJK.bQg()) && (this.hJK.bPK() == null || StringUtils.isNull(this.hJK.bPK().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bUN() {
        return this.hJK == null || this.hJK.getForum() == null || "0".equals(this.hJK.getForum().getId()) || "me0407".equals(this.hJK.getForum().getName());
    }

    private boolean bUO() {
        boolean z;
        if (this.hOw != null && this.hOw.getVisibility() == 0) {
            if (this.hNV != null) {
                this.hNV.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hNV != null) {
                this.hNV.setVisibility(8);
            }
            z = false;
        }
        if ((this.hNX == null || this.hNX.getVisibility() == 8) && z && this.hGG) {
            this.hNW.setVisibility(0);
        } else {
            this.hNW.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bPL() == null) {
            return false;
        }
        if (dVar.bPL().ads() == 1 || dVar.bPL().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bPL().adu() == null || dVar.bPL().adu().afv() == 0) || dVar.bPL().adq() == 1 || dVar.bPL().adr() == 1 || dVar.bPL().aeg() || dVar.bPL().aev() || dVar.bPL().aeo() || dVar.bPL().adH() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.bPL().getCategory()) || dVar.bPL().ady() || dVar.bPL().adx();
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hGp.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hNs != null) {
                if (dVar.bPL() != null && dVar.bPL().adK() == 0 && !dVar.bPL().aep() && !this.hPB) {
                    this.hNs.setVisibility(0);
                    if (dVar.bPL() != null) {
                        bg bPL = dVar.bPL();
                        bPL.k(true, q(dVar));
                        bPL.setResource(3);
                        bPL.mo("2");
                    }
                    SpannableStringBuilder aeb = dVar.bPL().aeb();
                    this.hNt.setOnTouchListener(new com.baidu.tieba.view.k(aeb));
                    this.hNt.setText(aeb);
                    this.hNt.setVisibility(0);
                } else if (dVar.bPL().adK() == 1) {
                    if (dVar.bPL() != null) {
                        this.hNs.setVisibility(8);
                        this.hNk.removeHeaderView(this.hNs);
                    }
                } else {
                    this.hNs.setVisibility(8);
                    this.hNk.removeHeaderView(this.hNs);
                    if (dVar.bPL() != null && dVar.bPL().aep()) {
                        this.hNy.setPadding(this.hNy.getPaddingLeft(), 0, this.hNy.getPaddingRight(), this.hNy.getPaddingBottom());
                        if (this.hNQ != null) {
                            ((RelativeLayout.LayoutParams) this.hNQ.getLayoutParams()).height = (int) this.hGp.getResources().getDimension(R.dimen.tbds36);
                            this.hNQ.requestLayout();
                        }
                        if (this.hNR != null) {
                            ((RelativeLayout.LayoutParams) this.hNR.getLayoutParams()).height = (int) this.hGp.getResources().getDimension(R.dimen.tbds0);
                            this.hNR.requestLayout();
                        }
                    } else {
                        this.hNy.setPadding(this.hNy.getPaddingLeft(), com.baidu.adp.lib.util.l.g(this.hGp.getPageContext().getPageActivity(), R.dimen.ds48), this.hNy.getPaddingRight(), this.hNy.getPaddingBottom());
                    }
                }
            }
            if (dVar.bPL() != null) {
                Z(dVar.bPL().adr() == 1, dVar.bPL().adq() == 1);
            }
            this.hGG = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bUO();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData c;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (dVar != null && (c = c(dVar, z)) != null) {
            String userId = c.adv().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bPX()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (c.adv() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, c.adv().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, c.adv().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, c.adv().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, c.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, c.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bPX()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bc> bQg = dVar.bQg();
                if (com.baidu.tbadk.core.util.v.Z(bQg) > 0) {
                    sb = new StringBuilder();
                    for (bc bcVar : bQg) {
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bHQ) != null && vVar.bFI && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.i(bcVar.getForumName(), 12)).append(this.hGp.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.hGp.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.cxO;
    }

    public boolean bUP() {
        if (this.epZ == null || this.epZ.getParent() == null || this.fvh.pu()) {
            return false;
        }
        int bottom = this.epZ.getBottom();
        Rect rect = new Rect();
        this.epZ.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Bl(String str) {
        if (this.fvh != null) {
            this.fvh.setText(str);
        }
    }

    public void Bm(String str) {
        if (this.fvh != null) {
            int i = 0;
            if (this.hOV != null && this.hOV.hQf != null && this.hOV.hQf.getView() != null) {
                i = this.hOV.hQf.getView().getTop() < 0 ? this.hOV.hQf.getView().getHeight() : this.hOV.hQf.getView().getBottom();
            }
            this.fvh.W(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hNk;
    }

    public int bUQ() {
        return R.id.richText;
    }

    public TextView bRc() {
        return this.hNx.bRc();
    }

    public void e(BdListView.e eVar) {
        this.hNk.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.bZA = cVar;
        if (this.hOd != null) {
            this.hOd.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int acn = anVar.acn();
            int ack = anVar.ack();
            if (this.hOa != null) {
                this.hOa.afG();
            } else {
                this.hOa = new com.baidu.tbadk.core.dialog.a(this.hGp.getPageContext().getPageActivity());
                this.hOb = LayoutInflater.from(this.hGp.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.hOa.aF(this.hOb);
                this.hOa.a(R.string.dialog_ok, bVar);
                this.hOa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bUS();
                        aVar.dismiss();
                    }
                });
                this.hOa.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hPe == null) {
                            aq.this.hPe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hGp.HidenSoftKeyPad((InputMethodManager) aq.this.hGp.getSystemService("input_method"), aq.this.epW);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.iB().postDelayed(aq.this.hPe, 150L);
                    }
                });
                this.hOa.b(this.hGp.getPageContext()).afG();
            }
            this.hOc = (EditText) this.hOb.findViewById(R.id.input_page_number);
            this.hOc.setText("");
            TextView textView = (TextView) this.hOb.findViewById(R.id.current_page_number);
            if (acn <= 0) {
                acn = 1;
            }
            if (ack <= 0) {
                ack = 1;
            }
            textView.setText(MessageFormat.format(this.hGp.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(acn), Integer.valueOf(ack)));
            this.hGp.ShowSoftKeyPadDelay(this.hOc, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hNk.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hGp.showToast(str);
    }

    public boolean oG(boolean z) {
        if (this.TB == null || !this.TB.aqV()) {
            return false;
        }
        this.TB.app();
        return true;
    }

    public void bUR() {
        if (this.hPO != null) {
            while (this.hPO.size() > 0) {
                TbImageView remove = this.hPO.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bUR();
        this.hNZ.xk(1);
        if (this.hNa != null) {
            this.hNa.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hNZ.xk(2);
        if (this.hNa != null) {
            this.hNa.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.hGp) && !TbSingleton.getInstance().isCutoutScreen(this.hGp)) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hPg != null) {
            this.hPg.destroy();
        }
        if (this.hPx != null) {
            this.hPx.onDestory();
        }
        if (this.hPo != null) {
            this.hPo.hide();
        }
        if (this.hNd != null) {
            this.hNd.aZA();
        }
        if (this.hNc != null) {
            this.hNc.onDestroy();
        }
        this.hGp.hideProgressBar();
        if (this.eRV != null && this.fmv != null) {
            this.eRV.b(this.fmv);
        }
        bUS();
        ajz();
        if (this.hPe != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hPe);
        }
        if (this.hNy != null && this.hNJ != null) {
            this.hNy.removeView(this.hNE);
            this.hNJ = null;
        }
        if (this.hOL != null) {
            this.hOL.clearStatus();
        }
        this.hPH = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hNZ.xk(3);
        if (this.frn != null) {
            this.frn.setBackgroundDrawable(null);
        }
        if (this.hNa != null) {
            this.hNa.destroy();
        }
        if (this.hNZ != null) {
            this.hNZ.onDestroy();
        }
        this.hNk.setOnLayoutListener(null);
        if (this.hPt != null) {
            this.hPt.bmr();
        }
        if (this.hOW != null) {
            this.hOW.onDestroy();
        }
    }

    public boolean xD(int i) {
        if (this.hNa != null) {
            return this.hNa.rz(i);
        }
        return false;
    }

    public void bUS() {
        this.hNg.TU();
        if (this.hNd != null) {
            this.hNd.aZA();
        }
        com.baidu.adp.lib.util.l.b(this.hGp.getPageContext().getPageActivity(), this.hOc);
        bUd();
        if (this.hEu != null) {
            this.hEu.dismiss();
        }
        bUU();
        if (this.hNc != null) {
            this.hNc.bWW();
        }
        if (this.hOa != null) {
            this.hOa.dismiss();
        }
        if (this.fqZ != null) {
            this.fqZ.dismiss();
        }
    }

    public void bUT() {
        this.hNg.TU();
        if (this.hNd != null) {
            this.hNd.aZA();
        }
        if (this.hEu != null) {
            this.hEu.dismiss();
        }
        bUU();
        if (this.hNc != null) {
            this.hNc.bWW();
        }
        if (this.hOa != null) {
            this.hOa.dismiss();
        }
        if (this.fqZ != null) {
            this.fqZ.dismiss();
        }
    }

    public void dI(List<String> list) {
        this.hPs = list;
        if (this.hPt != null) {
            this.hPt.setData(list);
        }
    }

    public void nR(boolean z) {
        this.hNZ.nR(z);
    }

    public void oH(boolean z) {
        this.hOv = z;
    }

    public void bUU() {
        if (this.hOj != null) {
            this.hOj.dismiss();
        }
        if (this.hOk != null) {
            com.baidu.adp.lib.g.g.b(this.hOk, this.hGp.getPageContext());
        }
        if (this.hOl != null) {
            com.baidu.adp.lib.g.g.b(this.hOl, this.hGp.getPageContext());
        }
        if (this.hOh != null) {
            this.hOh.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hJK, this.hGG);
            d(this.hJK, this.hGG, this.mType);
            this.hGp.getLayoutMode().setNightMode(i == 1);
            this.hGp.getLayoutMode().onModeChanged(this.epW);
            this.hGp.getLayoutMode().onModeChanged(this.hNm);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.al.l(this.epW, R.color.cp_bg_line_d);
            }
            if (this.hNc != null) {
                this.hNc.onChangeSkinType(i);
            }
            if (this.hNn != null) {
                com.baidu.tbadk.core.util.al.l(this.hNn, R.color.cp_bg_line_c);
            }
            if (this.hNo != null) {
                this.hNo.setIsNight(this.mSkinType == 1);
            }
            if (this.hNp != null) {
                com.baidu.tbadk.core.util.al.j(this.hNp, R.color.cp_cont_b);
            }
            if (this.hNq != null) {
                com.baidu.tbadk.core.util.al.j(this.hNq, R.color.cp_cont_j);
            }
            if (this.hNr != null) {
                com.baidu.tbadk.core.util.al.k(this.hNr, R.drawable.icon_common_arrow16_right_n);
            }
            if (this.hNt != null) {
                com.baidu.tbadk.core.util.al.j(this.hNt, R.color.cp_cont_b);
                this.hNt.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            }
            if (this.fvh != null) {
                this.fvh.iP(i);
                if (this.cxO != null) {
                    this.hGp.getLayoutMode().onModeChanged(this.cxO);
                    com.baidu.tbadk.core.util.al.k(this.cxO, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.hOa != null) {
                this.hOa.c(this.hGp.getPageContext());
            }
            oF(this.hOs);
            this.hNZ.notifyDataSetChanged();
            if (this.hOd != null) {
                this.hOd.iP(i);
            }
            if (this.TB != null) {
                this.TB.onChangeSkinType(i);
            }
            if (this.hNI != null) {
                this.hNI.iW(i);
            }
            if (this.hOe != null) {
                this.hOe.iP(i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.ezV)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ezV) {
                    customBlueCheckRadioButton.ajd();
                }
            }
            bUt();
            UtilHelper.setStatusBarBackground(this.frn, i);
            UtilHelper.setStatusBarBackground(this.hOQ, i);
            if (this.hNK != null) {
                this.hNK.onChangeSkinType(i);
            }
            if (this.hNO != null) {
                com.baidu.tbadk.core.util.al.j(this.hNO, R.color.cp_cont_d);
            }
            if (this.hNN != null) {
                com.baidu.tbadk.core.util.al.j(this.hNN, R.color.cp_cont_d);
            }
            if (this.hNP != null) {
                com.baidu.tbadk.core.util.al.j(this.hNP, R.color.cp_cont_d);
            }
            if (this.hNM != null) {
                com.baidu.tbadk.core.util.al.j(this.hNM, R.color.cp_cont_d);
            }
            if (this.hNS != null) {
                com.baidu.tbadk.s.a.a(this.hGp.getPageContext(), this.hNS);
            }
            if (this.hPf != null) {
                this.hPf.onChangeSkinType(i);
            }
            if (this.hNg != null) {
                if (this.hNa != null) {
                    this.hNa.xI(i);
                } else {
                    this.hNg.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.gga != null) {
                com.baidu.tbadk.core.util.al.j(this.gga, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.k(this.gga, R.drawable.bg_comment_input);
            }
            if (this.hOA != null && this.hJK != null) {
                if (this.hJK.ZC()) {
                    com.baidu.tbadk.core.util.al.c(this.hOA, (int) R.drawable.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.hOA, (int) R.drawable.icon_pb_bottom_collect_n);
                }
            }
            if (this.hOB != null) {
                com.baidu.tbadk.core.util.al.c(this.hOB, (int) R.drawable.icon_pb_bottom_share_n);
            }
            if (this.hOz != null) {
                com.baidu.tbadk.core.util.al.c(this.hOz, (int) R.drawable.icon_pb_bottom_comment_n);
            }
            com.baidu.tbadk.core.util.al.j(this.hOC, R.color.cp_cont_b);
            if (this.hNC != null) {
                com.baidu.tbadk.core.util.al.c(this.hNC, BitmapHelper.getGradeResourceIdInEnterForum(this.hPn));
            }
            if (this.hPu != null) {
                this.hPu.onChangeSkinType(i);
            }
            if (this.hOW != null) {
                this.hOW.onChangeSkinType();
            }
            if (this.hPq != null) {
                com.baidu.tbadk.core.util.al.j(this.hPq, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.al.l(this.hOy, R.color.cp_bg_line_d);
            if (this.hNB != null) {
                com.baidu.tbadk.core.util.al.k(this.hNB, this.hPz);
                com.baidu.tbadk.core.util.al.j(this.hNB, R.color.cp_btn_a);
            }
            if (this.hNl != null) {
                this.hNl.nq(i);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIM = hVar;
        this.hNZ.setOnImageClickListener(this.cIM);
        this.hPu.setOnImageClickListener(this.cIM);
    }

    public void h(NoNetworkView.a aVar) {
        this.fmv = aVar;
        if (this.eRV != null) {
            this.eRV.a(this.fmv);
        }
    }

    public void oI(boolean z) {
        this.hNZ.setIsFromCDN(z);
    }

    public Button bUV() {
        return this.hOw;
    }

    public void bUW() {
        if (this.hNf != 2) {
            this.hNk.setNextPage(this.fvh);
            this.hNf = 2;
        }
    }

    public void bUX() {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            int lastVisiblePosition = this.hNk.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hNk.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog = tbImageView.getPerfLog();
                                perfLog.kK(1001);
                                perfLog.cyv = true;
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
                        perfLog2.kK(1001);
                        perfLog2.cyv = true;
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

    public boolean bUY() {
        return this.TB != null && this.TB.getVisibility() == 0;
    }

    public boolean bUZ() {
        return this.TB != null && this.TB.aqV();
    }

    public void bVa() {
        if (this.TB != null) {
            this.TB.app();
        }
    }

    public void oJ(boolean z) {
        if (this.hOy != null) {
            oH(this.hGp.bRd().arz());
            if (this.hOv) {
                oz(z);
            } else {
                oA(z);
            }
        }
    }

    public void bVb() {
        if (this.hOy != null) {
            this.hOx.setVisibility(8);
            this.hOy.setVisibility(8);
            this.hOD = false;
            if (this.hOW != null) {
                this.hOW.setVisibility(8);
                oD(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.eHw == null) {
            this.eHw = new com.baidu.tbadk.core.view.b(this.hGp.getPageContext());
        }
        this.eHw.ef(true);
    }

    public void aSG() {
        if (this.eHw != null) {
            this.eHw.ef(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hNk.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hNk.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hNa != null) {
            this.hNa.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hPP = getScrollY();
            this.hOV.hQf = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOV));
            a(this.hOV.hQf, true);
        }
    }

    public void oK(boolean z) {
        this.hNa.oK(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hNa != null) {
            this.hNa.b(absListView, i);
        }
        if (this.hNg != null && this.hNZ != null) {
            this.hNg.a(this.hNZ.bSq());
        }
        this.hOV.hwy = i;
        this.hOV.headerCount = this.hNk.getHeaderViewsCount();
        this.hOV.hQf = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOV));
        a(this.hOV.hQf, false);
        if (this.fvh.ajF() && !this.fvh.bZp) {
            if (this.hOV != null && this.hOV.hQf != null && this.hOV.hQf.getView() != null) {
                i4 = this.hOV.hQf.getView().getTop() < 0 ? this.hOV.hQf.getView().getHeight() : this.hOV.hQf.getView().getBottom();
            }
            this.fvh.iS(i4);
            this.fvh.bZp = true;
        }
    }

    public void bVc() {
        if (this.hGp.isLogin() && this.hJK != null && this.hPk && !this.hPj && !this.hOt && this.hOG != null && this.hOG.adv() != null && !this.hOG.adv().getIsLike() && !this.hOG.adv().hadConcerned() && this.hPg == null) {
            this.hPg = new an(this.hGp);
        }
    }

    public void bVd() {
        if (this.hPk && !this.hPj && this.hOG != null && this.hOG.adv() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").P("obj_locate", this.hGp.bQH() ? 2 : 1).P("obj_type", this.hPj ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hGp.getPageContext().getPageActivity(), this.hOG.adv().getUserId(), this.hOG.adv().getUserName(), this.hGp.bQR().bQI(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hPj && this.hOP != null && this.hNg.bVM() != null) {
            int bSm = this.hNZ.bSm();
            if (bSm > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bSm > this.hNk.getFirstVisiblePosition() - this.hNk.getHeaderViewsCount()) {
                    this.hOP.setVisibility(8);
                    return;
                }
                this.hOP.setVisibility(0);
                bVn();
                this.hNg.mNavigationBar.hideBottomLine();
                if (this.hOP.getParent() != null && ((ViewGroup) this.hOP.getParent()).getHeight() <= this.hOP.getTop()) {
                    this.hOP.getParent().requestLayout();
                }
            } else if (alVar == null || alVar.getView() == null || alVar.hME == null) {
                if (this.hNk.getFirstVisiblePosition() == 0) {
                    this.hOP.setVisibility(8);
                    this.hNg.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hOU) {
                        this.hOT = top;
                        this.hOU = false;
                    }
                    this.hOT = top < this.hOT ? top : this.hOT;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hNY.getY() < 0.0f) {
                        measuredHeight = hOS - alVar.hME.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hNg.bVM().getMeasuredHeight() - alVar.hME.getMeasuredHeight();
                        this.hNg.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hOT) {
                        this.hOP.setVisibility(0);
                        bVn();
                    } else if (top < measuredHeight) {
                        this.hOP.setVisibility(0);
                        bVn();
                    } else {
                        this.hOP.setVisibility(8);
                        this.hNg.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hOU = true;
                    }
                }
            }
        }
    }

    public void bVe() {
        if (!this.hPQ) {
            TiebaStatic.log("c10490");
            this.hPQ = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGp.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hOZ, Integer.valueOf(hPb));
            aVar.hn(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hGp.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aF(inflate);
            aVar.ab(sparseArray);
            aVar.a(R.string.grade_button_tips, this.hGp);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hGp.getPageContext()).afG();
        }
    }

    public void Bn(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGp.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hGp.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aF(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hOZ, Integer.valueOf(hPc));
        aVar.ab(sparseArray);
        aVar.a(R.string.view, this.hGp);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hGp.getPageContext()).afG();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData c;
        if (i > 0 && (c = c(dVar, z)) != null && c.adv() != null) {
            MetaData adv = c.adv();
            adv.setGiftNum(adv.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bVf() {
        return this.hOL;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPL() != null && dVar.bPL().aev() && this.hOL == null) {
            this.hOL = (PbInterviewStatusView) this.hOK.inflate();
            this.hOL.setOnClickListener(this.fra);
            this.hOL.setCallback(this.hGp.bRO());
            this.hOL.setData(this.hGp, dVar);
        }
    }

    public LinearLayout bVg() {
        return this.hNY;
    }

    public View bVh() {
        return this.frn;
    }

    public boolean bVi() {
        return this.hPB;
    }

    public void nW(boolean z) {
        this.hNx.nW(z);
    }

    public void Bo(String str) {
        if (this.hNh != null) {
            this.hNh.setTitle(str);
        }
    }

    private int oL(boolean z) {
        if (this.hOL == null || this.hOL.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.g(this.hGp.getPageContext().getPageActivity(), R.dimen.ds72);
    }

    private void bVj() {
        if (this.hOL != null && this.hOL.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hOL.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hOL.setLayoutParams(layoutParams);
        }
    }

    public boolean bRi() {
        return false;
    }

    public void Bp(String str) {
        this.gga.performClick();
        if (!StringUtils.isNull(str) && this.hGp.bRd() != null && this.hGp.bRd().ars() != null && this.hGp.bRd().ars().getInputView() != null) {
            EditText inputView = this.hGp.bRd().ars().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bUS();
            if (configuration.orientation == 2) {
                bVb();
                bUd();
            } else {
                bUg();
            }
            if (this.hPf != null) {
                this.hPf.bSv();
            }
            this.hGp.bki();
            this.hNY.setVisibility(8);
            this.hNg.oV(false);
            this.hGp.oc(false);
            if (this.hNa != null) {
                if (configuration.orientation == 1) {
                    bVg().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hNk.setIsLandscape(true);
                    this.hNk.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hNk.setIsLandscape(false);
                    if (this.hPP > 0) {
                        this.hNk.smoothScrollBy(this.hPP, 0);
                    }
                }
                this.hNa.onConfigurationChanged(configuration);
                this.hOO.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void oM(boolean z) {
        this.hNe = z;
    }

    public boolean bVk() {
        return this.hNa != null && this.hNa.bVk();
    }

    public void bVl() {
        if (this.hNa != null) {
            this.hNa.onPause();
        }
    }

    public void q(long j, int i) {
        if (this.hNc != null) {
            this.hNc.q(j, i);
        }
        if (this.hNa != null) {
            this.hNa.q(j, i);
        }
    }

    public void oh(boolean z) {
        this.hNZ.oh(z);
    }

    public void bVm() {
        if (this.hOM == null) {
            LayoutInflater.from(this.hGp.getActivity()).inflate(R.layout.add_experienced_text, (ViewGroup) this.epW, true);
            this.hOM = (ViewGroup) this.epW.findViewById(R.id.add_experienced_layout);
            this.hON = (TextView) this.epW.findViewById(R.id.add_experienced);
            com.baidu.tbadk.core.util.al.j(this.hON, R.color.cp_btn_a);
            String string = this.hGp.getResources().getString(R.string.experienced_add_success);
            String string2 = this.hGp.getResources().getString(R.string.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_h)));
            this.hON.setText(spannableString);
        }
        this.hOM.setVisibility(0);
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
                        aq.this.hOM.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hON.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hON.startAnimation(scaleAnimation);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hOy.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hGp);
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.hPq = new TextView(this.hGp);
            this.hPq.setText(R.string.connection_tips);
            this.hPq.setGravity(17);
            this.hPq.setPadding(com.baidu.adp.lib.util.l.g(this.hGp, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(this.hGp, R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hGp, R.dimen.ds60);
            if (this.hPq.getParent() == null) {
                frameLayout.addView(this.hPq, layoutParams);
            }
            this.hPp = new PopupWindow(this.hGp);
            this.hPp.setContentView(frameLayout);
            this.hPp.setHeight(-2);
            this.hPp.setWidth(-2);
            this.hPp.setFocusable(true);
            this.hPp.setOutsideTouchable(false);
            this.hPp.setBackgroundDrawable(new ColorDrawable(this.hGp.getResources().getColor(R.color.transparent)));
            this.hNk.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hPp.showAsDropDown(aq.this.hOy, view.getLeft(), -aq.this.hOy.getHeight());
                    } else {
                        aq.this.hPp.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bVn() {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_long_press_tips", false) && this.hPr == null) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_long_press_tips", true);
            this.hPr = new com.baidu.tbadk.core.dialog.a(this.hGp);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hGp);
            this.hPr.hr(1);
            this.hPr.aF(pbLongPressTipView);
            this.hPr.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hPr.dN(false);
            this.hPr.b(this.hGp.getPageContext()).afG();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hPr != null && aq.this.hPr.isShowing()) {
                        aq.this.hPr.dismiss();
                    }
                }
            }, 5000L);
            if (this.hNa != null) {
                this.hNa.bXg();
            }
        }
    }

    public void oN(boolean z) {
        this.hPw = z;
    }

    public boolean bVo() {
        return this.hPw;
    }

    public PbThreadPostView bVp() {
        return this.hNl;
    }

    private void Z(boolean z, boolean z2) {
        aa(z, z2);
        ab(z, z2);
        if (this.hNZ != null && this.hNZ.bSr() != null) {
            this.hNZ.bSr().T(z, z2);
        }
    }

    private void aa(boolean z, boolean z2) {
        if (z && z2) {
            this.hNv.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hNv.setVisibility(0);
        } else if (z) {
            this.hNv.setImageResource(R.drawable.pic_pb_refined_n);
            this.hNv.setVisibility(0);
        } else if (z2) {
            this.hNv.setImageResource(R.drawable.pic_pb_stick_n);
            this.hNv.setVisibility(0);
        } else {
            this.hNv.setVisibility(8);
        }
    }

    private void ab(boolean z, boolean z2) {
        if (this.hNs != null && this.hJK != null && this.hJK.bPL() != null && this.hJK.bPL().adK() == 0 && !this.hJK.bPL().aep()) {
            if (z && z2) {
                this.hNw.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.hNw.setVisibility(0);
            } else if (z) {
                this.hNw.setImageResource(R.drawable.pic_pb_refined_n);
                this.hNw.setVisibility(0);
            } else if (z2) {
                this.hNw.setImageResource(R.drawable.pic_pb_stick_n);
                this.hNw.setVisibility(0);
            } else {
                this.hNw.setVisibility(8);
            }
        }
    }
}
