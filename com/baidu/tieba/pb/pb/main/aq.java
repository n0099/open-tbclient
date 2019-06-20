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
    private EditorTools TA;
    private TextView aif;
    private h.c bZB;
    private com.baidu.tieba.pb.a.c ckh;
    private View cxP;
    private NoNetworkView eRV;
    private int edh;
    private RelativeLayout epW;
    private View epZ;
    private List<CustomBlueCheckRadioButton> ezV;
    private NavigationBarCoverTip fNv;
    private com.baidu.tieba.NEGFeedBack.e fQo;
    private View.OnClickListener fra;
    private View frn;
    private PbListView fvh;
    private TextView ggc;
    PbActivity.d hFv;
    private View.OnClickListener hGP;
    private PbActivity hGq;
    private UserIconBox hHD;
    private UserIconBox hHE;
    private PbFakeFloorModel hID;
    private com.baidu.tieba.pb.data.d hJL;
    private ThreadSkinView hNA;
    private TextView hNB;
    private TextView hNC;
    private ImageView hND;
    private HeadPendantView hNE;
    private FrameLayout hNF;
    private HeadImageView hNG;
    private View hNH;
    private LinearLayout hNI;
    private PbFirstFloorUserLikeButton hNL;
    private ao hNM;
    private TextView hNN;
    private TextView hNO;
    private TextView hNP;
    private TextView hNQ;
    private View hNR;
    private View hNS;
    private LinearLayout hNT;
    private TextView hNU;
    private TextView hNV;
    private View hNW;
    private View hNX;
    private ObservedChangeLinearLayout hNZ;
    public int hNa;
    public com.baidu.tieba.pb.video.i hNb;
    private long hNc;
    private com.baidu.tieba.pb.video.h hNd;
    private com.baidu.tieba.c.d hNe;
    public final com.baidu.tieba.pb.pb.main.view.c hNh;
    public com.baidu.tieba.pb.pb.main.view.b hNi;
    private ViewStub hNj;
    private ViewStub hNk;
    private PbLandscapeListView hNl;
    private PbThreadPostView hNm;
    private View hNn;
    private RelativeLayout hNo;
    private HeadImageView hNp;
    private TextView hNq;
    private TextView hNr;
    private ImageView hNs;
    private RelativeLayout hNv;
    private ImageView hNw;
    private ImageView hNx;
    private e hNy;
    private ColumnLayout hNz;
    private ImageView hOA;
    private ImageView hOB;
    private ImageView hOC;
    private TextView hOD;
    private int hOF;
    private int hOG;
    private PostData hOH;
    private View hOJ;
    private TextView hOK;
    private ViewStub hOL;
    private PbInterviewStatusView hOM;
    private ViewGroup hON;
    private TextView hOO;
    private FrameLayout hOP;
    private View hOQ;
    private View hOR;
    private al hOS;
    private PbEmotionBar hOX;
    private f hOa;
    private View hOg;
    private View hOy;
    private View hOz;
    private boolean hPC;
    private com.baidu.tbadk.core.view.userLike.c hPD;
    private com.baidu.tbadk.core.view.userLike.c hPE;
    private Runnable hPJ;
    private PbActivity.b hPL;
    public int hPQ;
    private Runnable hPf;
    private s hPg;
    private an hPh;
    private int hPn;
    private PbTopTipView hPp;
    private PopupWindow hPq;
    private TextView hPr;
    private com.baidu.tbadk.core.dialog.a hPs;
    private List<String> hPt;
    private com.baidu.tieba.pb.pb.main.emotion.c hPu;
    private com.baidu.tieba.pb.pb.godreply.a hPv;
    private PbLandscapeListView.b hPw;
    private ac hPy;
    private String hPz;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private static final int hOT = UtilHelper.getLightStatusBarHeight();
    public static int hOZ = 3;
    public static int hPa = 0;
    public static int hPb = 3;
    public static int hPc = 4;
    public static int hPd = 5;
    public static int hPe = 6;
    private static a.InterfaceC0407a hPB = new a.InterfaceC0407a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0407a
        public void onRefresh() {
        }
    };
    private boolean hNf = false;
    private int hNg = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hNt = null;
    private TextView hNu = null;
    public FrsPraiseView hNJ = null;
    private ClickableHeaderImageView hNK = null;
    private View hNY = null;
    private com.baidu.tbadk.core.dialog.a hOb = null;
    private com.baidu.tbadk.core.dialog.b fqZ = null;
    private View hOc = null;
    private EditText hOd = null;
    private com.baidu.tieba.pb.view.c hOe = null;
    private com.baidu.tieba.pb.view.a hOf = null;
    private com.baidu.tbadk.core.dialog.a hOh = null;
    private b.a gDJ = null;
    private TbRichTextView.h cIN = null;
    private NoNetworkView.a fmv = null;
    private com.baidu.tbadk.core.dialog.i hOi = null;
    private View hOj = null;
    private com.baidu.tbadk.core.dialog.a hOk = null;
    private Dialog hOl = null;
    private Dialog hOm = null;
    private View hOn = null;
    private LinearLayout hOo = null;
    private CompoundButton.OnCheckedChangeListener ezW = null;
    private TextView hOp = null;
    private TextView hOq = null;
    private String hOr = null;
    private com.baidu.tbadk.core.dialog.i hEv = null;
    private com.baidu.tbadk.core.dialog.i hOs = null;
    private boolean hOt = false;
    private boolean hOu = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hOv = null;
    private boolean hOw = false;
    private Button hOx = null;
    private boolean hOE = true;
    private com.baidu.tbadk.core.view.b eHw = null;
    private boolean hGH = false;
    private int mSkinType = 3;
    private boolean hOI = false;
    private int hOU = 0;
    private boolean hOV = true;
    public a hOW = new a();
    private int hOY = 0;
    private boolean hPi = false;
    private int hPj = 0;
    private boolean hPk = false;
    private boolean hPl = false;
    private boolean hPm = false;
    private int hPo = 0;
    private boolean hPx = false;
    private int hPA = R.drawable.bg_user_identity_btn;
    private String hPF = null;
    private CustomMessageListener hPG = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hPF = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hOa != null) {
                aq.this.hOa.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hPH = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hNu != null) {
                aq.this.hNu.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hPI = new Handler();
    private CustomMessageListener hPK = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hOE = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hPM = true;
    View.OnClickListener hPN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hPk) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").P(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hPk && aq.this.hJL != null && aq.this.hJL.bPM() != null && aq.this.hJL.bPM().adv() != null && aq.this.hJL.bPM().adv().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").P("obj_locate", 1));
            }
            aq.this.hGq.hEq.fQX.onClick(view);
        }
    };
    private boolean hPO = false;
    String userId = null;
    private final List<TbImageView> hPP = new ArrayList();
    private boolean hPR = false;

    /* loaded from: classes4.dex */
    public static class a {
        public al hQg;
        public int headerCount;
        public int hwz;
    }

    public void oz(boolean z) {
        this.hPi = z;
        if (this.hNl != null) {
            this.hPj = this.hNl.getHeaderViewsCount();
        }
    }

    public void bUc() {
        if (this.hNl != null) {
            int headerViewsCount = this.hNl.getHeaderViewsCount() - this.hPj;
            final int firstVisiblePosition = (this.hNl.getFirstVisiblePosition() == 0 || this.hNl.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hNl.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hNl.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hOW.hQg = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOW));
            final al alVar = this.hOW.hQg;
            final int h = h(alVar);
            final int y = ((int) this.hNZ.getY()) + this.hNZ.getMeasuredHeight();
            final boolean z = this.hOQ.getVisibility() == 0;
            boolean z2 = this.hNZ.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hOa.bSn() + this.hNl.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hMF.getMeasuredHeight() : 0;
                if (z2) {
                    this.hNl.setSelectionFromTop(this.hOa.bSn() + this.hNl.getHeaderViewsCount(), hOT - measuredHeight);
                } else {
                    this.hNl.setSelectionFromTop(this.hOa.bSn() + this.hNl.getHeaderViewsCount(), this.hNh.bVN().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hNl.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hPk) {
                this.hNl.setSelectionFromTop(this.hOa.bSn() + this.hNl.getHeaderViewsCount(), this.hNb.aHS().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hNl.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bSF() {
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
                                aq.this.hNl.setSelectionFromTop(firstVisiblePosition, top);
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
                        aq.this.hNl.setOnLayoutListener(null);
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

    public NoNetworkView bUd() {
        return this.eRV;
    }

    public void bUe() {
        if (this.TA != null) {
            this.TA.hide();
            if (this.hPu != null) {
                this.hPu.aGN();
            }
        }
    }

    public PbFakeFloorModel bUf() {
        return this.hID;
    }

    public s bUg() {
        return this.hPg;
    }

    public void bUh() {
        reset();
        bUe();
        this.hPg.bSw();
        oK(false);
    }

    private void reset() {
        if (this.hGq != null && this.hGq.bRe() != null && this.TA != null) {
            com.baidu.tbadk.editortools.pb.a.arp().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bRe = this.hGq.bRe();
            bRe.arI();
            bRe.ard();
            if (bRe.getWriteImagesInfo() != null) {
                bRe.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bRe.kp(SendView.ALL);
            bRe.kq(SendView.ALL);
            com.baidu.tbadk.editortools.g kg = this.TA.kg(23);
            com.baidu.tbadk.editortools.g kg2 = this.TA.kg(2);
            com.baidu.tbadk.editortools.g kg3 = this.TA.kg(5);
            if (kg2 != null) {
                kg2.pO();
            }
            if (kg3 != null) {
                kg3.pO();
            }
            if (kg != null) {
                kg.hide();
            }
            this.TA.invalidate();
        }
    }

    public boolean bUi() {
        return this.hOE;
    }

    public void oA(boolean z) {
        if (this.hOz != null && this.ggc != null) {
            this.ggc.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hOz.startAnimation(alphaAnimation);
            }
            this.hOy.setVisibility(0);
            this.hOz.setVisibility(0);
            this.hOE = true;
            if (this.hOX != null && !this.hPv.isActive()) {
                this.hOX.setVisibility(0);
                oE(true);
            }
        }
    }

    public void oB(boolean z) {
        if (this.hOz != null && this.ggc != null) {
            this.ggc.setText(bUj());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hOz.startAnimation(alphaAnimation);
            }
            this.hOy.setVisibility(0);
            this.hOz.setVisibility(0);
            this.hOE = true;
            if (this.hOX != null && !this.hPv.isActive()) {
                this.hOX.setVisibility(0);
                oE(true);
            }
        }
    }

    public String bUj() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.hPz)) {
            return this.hPz;
        }
        if (this.hGq != null) {
            this.hPz = this.hGq.getResources().getString(ap.bUb());
        }
        return this.hPz;
    }

    public PostData bUk() {
        int i = 0;
        if (this.hNl == null) {
            return null;
        }
        int bUl = bUl() - this.hNl.getHeaderViewsCount();
        if (bUl < 0) {
            bUl = 0;
        }
        if (this.hOa.xj(bUl) != null && this.hOa.xj(bUl) != PostData.iYF) {
            i = bUl + 1;
        }
        return this.hOa.getItem(i) instanceof PostData ? (PostData) this.hOa.getItem(i) : null;
    }

    public int bUl() {
        int i;
        View childAt;
        if (this.hNl == null) {
            return 0;
        }
        int firstVisiblePosition = this.hNl.getFirstVisiblePosition();
        int lastVisiblePosition = this.hNl.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hNl.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hNl.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bUm() {
        return this.hNl.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hJL != null && this.hJL.bPO() != null && !this.hJL.bPO().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hJL.bPO().size() && (postData = this.hJL.bPO().get(i)) != null && postData.adv() != null && !StringUtils.isNull(postData.adv().getUserId()); i++) {
                if (this.hJL.bPO().get(i).adv().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hPv != null && this.hPv.isActive()) {
                        oK(false);
                    }
                    if (this.hOX != null) {
                        this.hOX.oS(true);
                    }
                    this.hPF = postData.adv().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hGq = null;
        this.epW = null;
        this.frn = null;
        this.hNc = 0L;
        this.hNl = null;
        this.hNn = null;
        this.hNv = null;
        this.hNz = null;
        this.hNB = null;
        this.hNC = null;
        this.hNF = null;
        this.hNG = null;
        this.hNH = null;
        this.hNL = null;
        this.hNN = null;
        this.hNO = null;
        this.hNP = null;
        this.hNQ = null;
        this.hNW = null;
        this.hNX = null;
        this.hOa = null;
        this.fvh = null;
        this.cxP = null;
        this.fra = null;
        this.hGP = null;
        this.hOz = null;
        this.ggc = null;
        this.hOJ = null;
        this.hOK = null;
        this.hOL = null;
        this.hPn = 0;
        this.hNc = System.currentTimeMillis();
        this.hGq = pbActivity;
        this.fra = onClickListener;
        this.ckh = cVar;
        this.hPn = com.baidu.adp.lib.util.l.af(this.hGq) / 2;
        this.epW = (RelativeLayout) LayoutInflater.from(this.hGq.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.hGq.addContentView(this.epW, new FrameLayout.LayoutParams(-1, -1));
        this.fNv = (NavigationBarCoverTip) this.hGq.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.frn = this.hGq.findViewById(R.id.statebar_view);
        this.hNZ = (ObservedChangeLinearLayout) this.hGq.findViewById(R.id.title_wrapper);
        this.eRV = (NoNetworkView) this.hGq.findViewById(R.id.view_no_network);
        this.hNl = (PbLandscapeListView) this.hGq.findViewById(R.id.new_pb_list);
        this.hOP = (FrameLayout) this.hGq.findViewById(R.id.root_float_header);
        this.aif = new TextView(this.hGq.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.hGq.getActivity(), R.dimen.ds88));
        this.hNl.addHeaderView(this.aif, 0);
        this.edh = this.hGq.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.epZ = new View(this.hGq.getPageContext().getPageActivity());
        this.epZ.setLayoutParams(new AbsListView.LayoutParams(-1, this.edh));
        this.epZ.setVisibility(4);
        this.hNl.addFooterView(this.epZ);
        this.hNl.setOnTouchListener(this.hGq.clc);
        this.hNh = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.hGq.bRH()) {
            this.hNj = (ViewStub) this.hGq.findViewById(R.id.manga_view_stub);
            this.hNj.setVisibility(0);
            this.hNi = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.hNi.show();
            this.hNh.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hGq.getActivity(), R.dimen.ds120);
        }
        this.aif.setLayoutParams(layoutParams);
        this.hNh.bVN().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0367a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0367a
            public void bQC() {
                if (aq.this.hNl != null) {
                    if (aq.this.hNb != null) {
                        aq.this.hNb.bXg();
                    }
                    aq.this.hNl.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0367a
            public void bQD() {
                aq.this.hGq.bki();
            }
        }));
        this.hOy = this.hGq.findViewById(R.id.view_comment_top_line);
        this.hOz = this.hGq.findViewById(R.id.pb_editor_tool_comment);
        this.hOF = com.baidu.adp.lib.util.l.g(this.hGq.getPageContext().getPageActivity(), R.dimen.tbds120);
        this.hOG = com.baidu.adp.lib.util.l.g(this.hGq.getPageContext().getPageActivity(), R.dimen.ds242);
        this.ggc = (TextView) this.hGq.getPageContext().getPageActivity().findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.ggc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hGq.bRn();
                if (aq.this.hGq != null && aq.this.hGq.bQS() != null && aq.this.hGq.bQS().getPbData() != null && aq.this.hGq.bQS().getPbData().bPM() != null && aq.this.hGq.bQS().getPbData().bPM().adv() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", aq.this.hGq.bQS().hJp).bT("fid", aq.this.hGq.bQS().getPbData().getForumId()).P("obj_locate", 1).bT("uid", aq.this.hGq.bQS().getPbData().bPM().adv().getUserId()));
                }
            }
        });
        this.hOA = (ImageView) this.hGq.findViewById(R.id.pb_editor_tool_comment_icon);
        this.hOA.setOnClickListener(this.fra);
        this.hOB = (ImageView) this.hGq.findViewById(R.id.pb_editor_tool_collection);
        this.hOB.setOnClickListener(this.fra);
        this.hOC = (ImageView) this.hGq.findViewById(R.id.pb_editor_tool_share);
        this.hOC.setOnClickListener(this.fra);
        this.hOD = (TextView) this.hGq.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.hNn = LayoutInflater.from(this.hGq.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.hNv = (RelativeLayout) LayoutInflater.from(this.hGq.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.hNw = (ImageView) this.hNv.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.hNy = new e(this.hGq, this.hNv);
        this.hNy.init();
        this.hNy.a(this.hNy.bRd(), this.fra);
        this.hNz = (ColumnLayout) this.hNv.findViewById(R.id.pb_head_owner_root);
        this.hNA = (ThreadSkinView) this.hNv.findViewById(R.id.pb_thread_skin);
        this.hNz.setOnLongClickListener(this.onLongClickListener);
        this.hNz.setOnTouchListener(this.ckh);
        this.hNz.setVisibility(8);
        this.hNn.setOnTouchListener(this.ckh);
        this.hOJ = this.hNn.findViewById(R.id.pb_head_activity_join_number_container);
        this.hOJ.setVisibility(8);
        this.hOK = (TextView) this.hNn.findViewById(R.id.pb_head_activity_join_number);
        this.hNB = (TextView) this.hNz.findViewById(R.id.pb_head_owner_info_user_name);
        this.hNB.getPaint().setFakeBoldText(true);
        this.hNC = (TextView) this.hNz.findViewById(R.id.floor_owner);
        this.hND = (ImageView) this.hNz.findViewById(R.id.icon_forum_level);
        this.hNF = (FrameLayout) this.hNz.findViewById(R.id.pb_head_headImage_container);
        this.hNG = (HeadImageView) this.hNz.findViewById(R.id.pb_head_owner_photo);
        this.hNE = (HeadPendantView) this.hNz.findViewById(R.id.pb_pendant_head_owner_photo);
        this.hNE.setHasPendantStyle();
        if (this.hNE.getHeadView() != null) {
            this.hNE.getHeadView().setIsRound(true);
            this.hNE.getHeadView().setDrawBorder(false);
        }
        this.hHD = (UserIconBox) this.hNz.findViewById(R.id.show_icon_vip);
        this.hHE = (UserIconBox) this.hNz.findViewById(R.id.show_icon_yinji);
        this.hNI = (LinearLayout) this.hNv.findViewById(R.id.pb_head_owner_info_root);
        this.hNL = (PbFirstFloorUserLikeButton) this.hNz.findViewById(R.id.pb_like_button);
        this.hNN = (TextView) this.hNz.findViewById(R.id.pb_views);
        this.hNO = (TextView) this.hNz.findViewById(R.id.pb_item_first_floor_reply_time);
        this.hNP = (TextView) this.hNz.findViewById(R.id.pb_item_first_floor_location_address);
        this.hNQ = (TextView) this.hNz.findViewById(R.id.point_between_time_and_locate);
        this.hPD = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hPE = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hNW = this.hNn.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.hNX = this.hNn.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.hNn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hOL = (ViewStub) this.epW.findViewById(R.id.interview_status_stub);
        this.hNR = this.hNv.findViewById(R.id.blank_view_align_user_item_top);
        this.hNS = this.hNv.findViewById(R.id.blank_view_align_user_item_bottom);
        this.hOa = new f(this.hGq, this.hNl);
        this.hOa.z(this.fra);
        this.hOa.setTbGestureDetector(this.ckh);
        this.hOa.setOnImageClickListener(this.cIN);
        this.hGP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hGq.c(sparseArray);
                            return;
                        }
                        aq.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.hGq.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hOa.L(this.hGP);
        bUr();
        bUs();
        this.hNl.addHeaderView(this.hNv);
        this.hNl.addHeaderView(this.hNt);
        this.hNl.addHeaderView(this.hNn);
        this.fvh = new PbListView(this.hGq.getPageContext().getPageActivity());
        this.cxP = this.fvh.getView().findViewById(R.id.pb_more_view);
        if (this.cxP != null) {
            this.cxP.setOnClickListener(this.fra);
            com.baidu.tbadk.core.util.al.k(this.cxP, R.drawable.pb_foot_more_trans_selector);
        }
        this.fvh.aju();
        this.fvh.iM(R.drawable.pb_foot_more_trans_selector);
        this.fvh.iO(R.drawable.pb_foot_more_trans_selector);
        this.hOg = this.hGq.findViewById(R.id.viewstub_progress);
        this.hGq.registerListener(this.hPK);
        this.hNH = com.baidu.tbadk.ala.b.Zl().n(this.hGq.getActivity(), 2);
        if (this.hNH != null) {
            this.hNH.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hGq.getResources().getDimensionPixelSize(R.dimen.ds10);
            if (this.hNH.getParent() == null) {
                this.hNI.addView(this.hNH, aVar);
            }
        }
        this.hID = new PbFakeFloorModel(this.hGq.getPageContext());
        this.hPg = new s(this.hGq.getPageContext(), this.hID, this.epW);
        this.hPg.a(this.hGq.hFq);
        this.hID.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hID.o(postData);
                aq.this.hOa.notifyDataSetChanged();
                aq.this.hPg.bSw();
                aq.this.TA.app();
                aq.this.oK(false);
            }
        });
        if (this.hGq.bQS() != null && !StringUtils.isNull(this.hGq.bQS().bTq())) {
            this.hGq.showToast(this.hGq.bQS().bTq());
        }
        this.hOQ = this.hGq.findViewById(R.id.pb_expand_blank_view);
        this.hOR = this.hGq.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hOR.getLayoutParams();
        if (this.hGq.bQS() != null && this.hGq.bQS().bSM()) {
            this.hOQ.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hOR.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hOT;
            this.hOR.setLayoutParams(layoutParams2);
        }
        this.hOS = new al(this.hGq.getPageContext(), this.hGq.findViewById(R.id.pb_reply_expand_view));
        this.hOS.hMF.setVisibility(8);
        this.hOS.N(this.fra);
        this.hGq.registerListener(this.mAccountChangedListener);
        this.hGq.registerListener(this.hPG);
        this.hGq.registerListener(this.hPH);
        bUn();
        oE(false);
    }

    public void buP() {
        if (!this.hGq.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").P("obj_locate", 2).bT("fid", this.mForumId));
        } else if (this.hGq.bRp()) {
            com.baidu.tbadk.editortools.pb.d bRe = this.hGq.bRe();
            if (bRe != null && (bRe.arF() || bRe.arG())) {
                this.hGq.bRe().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.TA != null) {
                bUx();
            }
            if (this.TA != null) {
                this.hOE = false;
                if (this.TA.kj(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hGq, (View) this.TA.kj(2).cqF, false, hPB);
                }
            }
            bVc();
        }
    }

    private void bUn() {
        this.hPv = new com.baidu.tieba.pb.pb.godreply.a(this.hGq, this, (ViewStub) this.epW.findViewById(R.id.more_god_reply_popup));
        this.hPv.v(this.fra);
        this.hPv.L(this.hGP);
        this.hPv.setOnImageClickListener(this.cIN);
        this.hPv.v(this.fra);
        this.hPv.setTbGestureDetector(this.ckh);
    }

    public com.baidu.tieba.pb.pb.godreply.a bUo() {
        return this.hPv;
    }

    public View bUp() {
        return this.hOQ;
    }

    public void bUq() {
        if (this.hNl != null) {
            this.hNl.removeHeaderView(this.hNt);
            this.hNl.removeHeaderView(this.hNv);
            this.hNl.removeHeaderView(this.hNo);
            this.hNl.removeHeaderView(this.hNn);
        }
    }

    private void bUr() {
        if (this.hNo == null) {
            this.hNo = (RelativeLayout) LayoutInflater.from(this.hGq).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.hNp = (HeadImageView) this.hNo.findViewById(R.id.iv_pb_video_smart_app_head);
            this.hNp.setIsRound(true);
            this.hNq = (TextView) this.hNo.findViewById(R.id.tv_pb_video_smart_app_title);
            this.hNr = (TextView) this.hNo.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.hNs = (ImageView) this.hNo.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.hNo.setOnClickListener(this.fra);
        }
    }

    private void bUs() {
        if (this.hNt == null) {
            this.hNt = (RelativeLayout) LayoutInflater.from(this.hGq).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.hNx = (ImageView) this.hNt.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.hNx.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
            this.hNx.setImageMatrix(matrix);
            this.hNu = (TextView) this.hNt.findViewById(R.id.tv_pb_title);
            this.hNu.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            this.hNu.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hNu.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.al.j(this.hNu, R.color.cp_cont_b);
            this.hNu.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hNu.setVisibility(8);
            if (this.hNu.getParent() == null) {
                this.hNt.addView(this.hNu);
            }
            this.hNt.setOnTouchListener(this.ckh);
            this.hNt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUt() {
        if (this.hGq.bRH()) {
            this.hNk = (ViewStub) this.hGq.findViewById(R.id.manga_mention_controller_view_stub);
            this.hNk.setVisibility(0);
            if (this.hNT == null) {
                this.hNT = (LinearLayout) this.hGq.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.s.a.a(this.hGq.getPageContext(), this.hNT);
            }
            if (this.hNU == null) {
                this.hNU = (TextView) this.hNT.findViewById(R.id.manga_prev_btn);
            }
            if (this.hNV == null) {
                this.hNV = (TextView) this.hNT.findViewById(R.id.manga_next_btn);
            }
            this.hNU.setOnClickListener(this.fra);
            this.hNV.setOnClickListener(this.fra);
        }
    }

    private void bUu() {
        if (this.hGq.bRH()) {
            if (this.hGq.bRK() == -1) {
                com.baidu.tbadk.core.util.al.f(this.hNU, R.color.cp_cont_e, 1);
            }
            if (this.hGq.bRL() == -1) {
                com.baidu.tbadk.core.util.al.f(this.hNV, R.color.cp_cont_e, 1);
            }
        }
    }

    public void bUv() {
        if (this.hNT == null) {
            bUt();
        }
        this.hNk.setVisibility(8);
        if (this.hPI != null && this.hPJ != null) {
            this.hPI.removeCallbacks(this.hPJ);
        }
    }

    public void bUw() {
        if (this.hPI != null) {
            if (this.hPJ != null) {
                this.hPI.removeCallbacks(this.hPJ);
            }
            this.hPJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hNT == null) {
                        aq.this.bUt();
                    }
                    aq.this.hNk.setVisibility(0);
                }
            };
            this.hPI.postDelayed(this.hPJ, 2000L);
        }
    }

    public void oC(boolean z) {
        this.hNh.oC(z);
        if (z && this.hOI) {
            this.fvh.setText(this.hGq.getResources().getString(R.string.click_load_more));
            this.hNl.setNextPage(this.fvh);
            this.hNg = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
        this.TA.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.TA.getParent() == null) {
            this.epW.addView(this.TA, layoutParams);
        }
        this.TA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.TA.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).alp() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).alp() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.aiM();
                        aq.this.mPermissionJudgePolicy.e(aq.this.hGq, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.aa(aq.this.hGq)) {
                            aq.this.hGq.bRe().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hGq.bRe().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bUe();
        this.hGq.bRe().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.TA != null && aq.this.TA.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hPu == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.TA.getId());
                            aq.this.hPu = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hGq.getPageContext(), aq.this.epW, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.aa(aq.this.hPt)) {
                                aq.this.hPu.setData(aq.this.hPt);
                            }
                            aq.this.hPu.b(aq.this.TA);
                        }
                        aq.this.hPu.Bv(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hGq.hEu != null && aq.this.hGq.hEu.bVt() != null) {
                    if (!aq.this.hGq.hEu.bVt().cwg()) {
                        aq.this.hGq.hEu.oP(false);
                    }
                    aq.this.hGq.hEu.bVt().rL(false);
                }
            }
        });
    }

    public void bUx() {
        if (this.hGq != null && this.TA != null) {
            this.TA.pO();
            if (this.hGq.bRe() != null) {
                this.hGq.bRe().arw();
            }
            bVc();
        }
    }

    public void oD(boolean z) {
        if (this.hNl != null && this.aif != null && this.frn != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.frn.setVisibility(0);
                } else {
                    this.frn.setVisibility(8);
                    this.hNl.removeHeaderView(this.aif);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aif.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hOT;
                    this.aif.setLayoutParams(layoutParams);
                }
                bUL();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aif.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + oM(true);
                this.aif.setLayoutParams(layoutParams2);
            }
            bUL();
            bVk();
        }
    }

    public f bUy() {
        return this.hOa;
    }

    public void a(PbActivity.d dVar) {
        this.hFv = dVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGq);
        kVar.setTitleText(this.hGq.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOi.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hPL != null) {
                                aq.this.hPL.m(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hGq.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hGq.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hGq.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !bVj()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.hGq.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hGq.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hGq.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.W(arrayList);
        if (this.hOi == null) {
            this.hOi = new com.baidu.tbadk.core.dialog.i(this.hGq.getPageContext(), kVar.afZ());
        } else {
            this.hOi.setContentView(kVar.afZ());
        }
        this.hOi.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hPL = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hGq != null && aVar != null) {
            if (this.fQo == null) {
                this.fQo = new com.baidu.tieba.NEGFeedBack.e(this.hGq.getPageContext(), this.hNn);
            }
            AntiData biZ = this.hGq.biZ();
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
            this.fQo.setDefaultReasonArray(new String[]{this.hGq.getString(R.string.delete_thread_reason_1), this.hGq.getString(R.string.delete_thread_reason_2), this.hGq.getString(R.string.delete_thread_reason_3), this.hGq.getString(R.string.delete_thread_reason_4), this.hGq.getString(R.string.delete_thread_reason_5)});
            this.fQo.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fQo.rr(str);
            this.fQo.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    aq.this.hGq.a(aVar, jSONArray);
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
        sparseArray.put(hPa, Integer.valueOf(hPb));
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
        this.hOk = new com.baidu.tbadk.core.dialog.a(this.hGq.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hOk.ho(i3);
        } else {
            this.hOk.dR(false);
            this.hOk.mD(str2);
        }
        this.hOk.ab(sparseArray);
        this.hOk.a(R.string.dialog_ok, this.hGq);
        this.hOk.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hOk.dM(true);
        this.hOk.b(this.hGq.getPageContext());
        if (z) {
            this.hOk.afG();
        } else {
            a(this.hOk, i);
        }
    }

    public void ax(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hOn == null) {
            this.hOn = LayoutInflater.from(this.hGq.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.hGq.getLayoutMode().onModeChanged(this.hOn);
        if (this.hOm == null) {
            this.hOm = new Dialog(this.hGq.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hOm.setCanceledOnTouchOutside(true);
            this.hOm.setCancelable(true);
            this.hOv = (ScrollView) this.hOn.findViewById(R.id.good_scroll);
            this.hOm.setContentView(this.hOn);
            WindowManager.LayoutParams attributes = this.hOm.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.hGq.getPageContext().getPageActivity(), R.dimen.ds540);
            this.hOm.getWindow().setAttributes(attributes);
            this.ezW = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hOr = (String) compoundButton.getTag();
                        if (aq.this.ezV != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ezV) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hOr != null && !str.equals(aq.this.hOr)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hOo = (LinearLayout) this.hOn.findViewById(R.id.good_class_group);
            this.hOq = (TextView) this.hOn.findViewById(R.id.dialog_button_cancel);
            this.hOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hOm instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hOm, aq.this.hGq.getPageContext());
                    }
                }
            });
            this.hOp = (TextView) this.hOn.findViewById(R.id.dialog_button_ok);
            this.hOp.setOnClickListener(this.fra);
        }
        this.hOo.removeAllViews();
        this.ezV = new ArrayList();
        CustomBlueCheckRadioButton dM = dM("0", this.hGq.getPageContext().getString(R.string.thread_good_class));
        this.ezV.add(dM);
        dM.setChecked(true);
        this.hOo.addView(dM);
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
                    View view = new View(this.hGq.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.hGq.getPageContext().getPageActivity(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.al.l(view, R.color.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hOo.addView(view);
                    this.hOo.addView(dM2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hOv.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGq.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGq.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGq.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hOv.setLayoutParams(layoutParams2);
            this.hOv.removeAllViews();
            if (this.hOo != null && this.hOo.getParent() == null) {
                this.hOv.addView(this.hOo);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hOm, this.hGq.getPageContext());
    }

    private CustomBlueCheckRadioButton dM(String str, String str2) {
        Activity pageActivity = this.hGq.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ezW);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bUz() {
        this.hGq.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hGq.hideProgressBar();
        if (z && z2) {
            this.hGq.showToast(this.hGq.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.hGq.showToast(str);
        }
    }

    public void bCb() {
        this.hOg.setVisibility(0);
    }

    public void bCa() {
        this.hOg.setVisibility(8);
    }

    public View bUA() {
        if (this.hOn != null) {
            return this.hOn.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String bUB() {
        return this.hOr;
    }

    public View getView() {
        return this.epW;
    }

    public void bUC() {
        com.baidu.adp.lib.util.l.b(this.hGq.getPageContext().getPageActivity(), this.hGq.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hGq.hideProgressBar();
        if (z) {
            bUT();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bUU();
        } else {
            bUT();
        }
    }

    public void bUD() {
        this.fvh.aju();
        this.fvh.ajy();
    }

    public void bUE() {
        this.hGq.hideProgressBar();
        ajz();
        this.hNl.completePullRefreshPostDelayed(0L);
        bUP();
    }

    public void bUF() {
        this.hNl.completePullRefreshPostDelayed(0L);
        bUP();
    }

    private void oE(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hOa.setOnLongClickListener(onLongClickListener);
        if (this.hPv != null) {
            this.hPv.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.hEv != null) {
            this.hEv.dismiss();
            this.hEv = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGq);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hGq.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGq.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGq.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGq.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOs.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hOs = new com.baidu.tbadk.core.dialog.i(this.hGq.getPageContext(), kVar.afZ());
        this.hOs.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.hOs != null) {
            this.hOs.dismiss();
            this.hOs = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGq);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hGq.getPageContext().getString(R.string.save_to_emotion), kVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGq.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOs.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hOs = new com.baidu.tbadk.core.dialog.i(this.hGq.getPageContext(), kVar.afZ());
        this.hOs.showDialog();
    }

    public int bUG() {
        return xA(this.hNl.getFirstVisiblePosition());
    }

    private int xA(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hNl.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hNl.getAdapter() == null || !(this.hNl.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hNl.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bUH() {
        int lastVisiblePosition = this.hNl.getLastVisiblePosition();
        if (this.hNb != null) {
            if (lastVisiblePosition == this.hNl.getCount() - 1) {
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
        if (this.hNl != null) {
            if (this.hNh == null || this.hNh.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hNh.mNavigationBar.getFixedNavHeight();
                if (!(this.hGq.bRv() != -1)) {
                    if (this.hOR != null && (layoutParams = (LinearLayout.LayoutParams) this.hOR.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hOR.setLayoutParams(layoutParams);
                    }
                    i--;
                    bVo();
                }
                i2 = fixedNavHeight;
            }
            this.hNl.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hNl.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hNl.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hOd.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hOa.a(dVar, false);
        this.hOa.notifyDataSetChanged();
        bUP();
        if (this.hPv != null) {
            this.hPv.bQO();
        }
        ArrayList<PostData> bPO = dVar.bPO();
        if (dVar.getPage().acp() == 0 || bPO == null || bPO.size() < dVar.getPage().aco()) {
            if (com.baidu.tbadk.core.util.v.Z(bPO) == 0 || (com.baidu.tbadk.core.util.v.Z(bPO) == 1 && bPO.get(0) != null && bPO.get(0).cmx() == 1)) {
                if (this.hOW == null || this.hOW.hQg == null || this.hOW.hQg.getView() == null) {
                    i = 0;
                } else {
                    i = this.hOW.hQg.getView().getTop() < 0 ? this.hOW.hQg.getView().getHeight() : this.hOW.hQg.getView().getBottom();
                }
                if (this.hGq.bRT()) {
                    this.fvh.W(this.hGq.getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.fvh.W(this.hGq.getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().acp() == 0) {
                    this.fvh.setText(this.hGq.getResources().getString(R.string.list_has_no_more));
                } else {
                    this.fvh.setText(this.hGq.getResources().getString(R.string.load_more));
                }
                this.fvh.ajD();
            }
        }
        o(dVar);
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        if (this.hNJ == null) {
            this.hGq.getLayoutMode().onModeChanged(((ViewStub) this.hNn.findViewById(R.id.praise_layout)).inflate());
            this.hNJ = (FrsPraiseView) this.hNn.findViewById(R.id.pb_head_praise_view);
            this.hNJ.setIsFromPb(true);
            this.hNY = this.hNn.findViewById(R.id.new_pb_header_item_line_above_praise);
            this.hNJ.iW(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hNJ != null) {
            boolean bUP = bUP();
            this.hNJ.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().acq() == 0 && this.hGH) {
                if (bUP) {
                    this.hNX.setVisibility(0);
                    return;
                } else {
                    this.hNX.setVisibility(8);
                    return;
                }
            }
            this.hNX.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bPW() != null) {
            return dVar.bPW();
        }
        if (!com.baidu.tbadk.core.util.v.aa(dVar.bPO())) {
            Iterator<PostData> it = dVar.bPO().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cmx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bPT();
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
        if (dVar == null || dVar.bPM() == null || dVar.bPM().adv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData adv = dVar.bPM().adv();
        String userId = adv.getUserId();
        HashMap<String, MetaData> userMap = dVar.bPM().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = adv;
        }
        postData.Ay(1);
        postData.setId(dVar.bPM().adL());
        postData.setTitle(dVar.bPM().getTitle());
        postData.setTime(dVar.bPM().getCreateTime());
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
        com.baidu.tbadk.data.f cmA;
        String portrait;
        String charSequence;
        if (dVar != null && dVar.bPM() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hNz.setVisibility(8);
            if (dVar.bPM() != null && dVar.bPM().aep() && dVar.bPM().adM() != null) {
                this.hPk = true;
                this.hNh.oZ(this.hPk);
                this.hNh.mNavigationBar.hideBottomLine();
                if (this.hNb == null) {
                    this.hNb = new com.baidu.tieba.pb.video.i(this.hGq, this.hNh, dVar.bPM().adM(), this.hNc);
                    this.hNb.a(dVar.bPM().adM(), dVar.bPM(), dVar.getForumId());
                    this.hNb.startPlay();
                } else if (this.hNf) {
                    this.hNb.a(dVar.bPM().adM(), dVar.bPM(), dVar.getForumId());
                    this.hNb.startPlay();
                } else {
                    this.hNb.BH(dVar.getForumId());
                }
                com.baidu.tieba.pb.c.a.a(this.hGq.getUniqueId(), dVar, c, 1, 1);
                if (dVar.bPN() != null && dVar.bPN().size() >= 1) {
                    bg bgVar = dVar.bPN().get(0);
                    this.hNb.aB(bgVar);
                    this.hNb.BI(bgVar.getTitle());
                }
                this.hNb.b(c, dVar.bPM(), dVar.bQj());
                this.hNf = false;
                this.hNl.removeHeaderView(this.hNb.bXi());
                this.hNl.addHeaderView(this.hNb.bXi(), 0);
                if (this.hNb.aHS() != null && this.hNb.aHS().getParent() == null) {
                    this.hOP.addView(this.hNb.aHS());
                }
                if (this.hNd == null) {
                    this.hNd = new com.baidu.tieba.pb.video.h(this.hGq);
                }
                this.hNd.a(dVar.bPM().aeF(), dVar.bPM(), dVar.bQg());
                this.hNl.removeHeaderView(this.hNd.bWV());
                this.hNl.addHeaderView(this.hNd.bWV(), 1);
                if (dVar.bPM().aeF() != null) {
                    this.hNl.removeHeaderView(this.hNd.bWW());
                    this.hNl.removeHeaderView(this.hNv);
                    this.hNl.addHeaderView(this.hNd.bWW(), 2);
                } else {
                    if (this.hNd.bWW() != null) {
                        this.hNl.removeHeaderView(this.hNd.bWW());
                    }
                    this.hNl.removeHeaderView(this.hNv);
                    this.hNl.addHeaderView(this.hNv, 2);
                }
                if (this.hNb != null) {
                    this.hNh.oV(false);
                    this.hNb.xI(TbadkCoreApplication.getInst().getSkinType());
                }
                bUL();
            } else {
                this.hPk = false;
                this.hNh.oZ(this.hPk);
                if (this.hNb != null) {
                    this.hNl.removeHeaderView(this.hNb.bXi());
                }
                if (this.hNd != null) {
                    this.hNd.b(this.hNl);
                }
            }
            if (this.hGq.bRh() != null) {
                this.hGq.bRh().oT(this.hPk);
            }
            if (this.hNb != null) {
                this.hNb.P(this.hPN);
                bVo();
            }
            if (c != null) {
                this.hOH = c;
                this.hNz.setVisibility(0);
                if (this.hGq.bQI()) {
                    if (dVar.bPL() != null) {
                        this.mForumName = dVar.bPL().getForumName();
                        this.mForumId = dVar.bPL().getForumId();
                    }
                    if (this.mForumName == null && this.hGq.bQS() != null && this.hGq.bQS().bQJ() != null) {
                        this.mForumName = this.hGq.bQS().bQJ();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hNz.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hNz.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_clip_board, c);
                sparseArray.put(R.id.tag_is_subpb, false);
                if (dVar.bPM().aep() && dVar.bPM().aeh() != null) {
                    SmartApp aeh = dVar.bPM().aeh();
                    this.hNo.setVisibility(0);
                    this.hNl.removeHeaderView(this.hNo);
                    this.hNl.addHeaderView(this.hNo, 1);
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh.avatar)) {
                        this.hNp.startLoad(aeh.avatar, 10, false, false);
                    }
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh.name)) {
                        charSequence = aeh.name + " " + ((Object) this.hGq.getText(R.string.smart_app_suffix));
                    } else {
                        charSequence = this.hGq.getText(R.string.intelligent_smart_app).toString();
                    }
                    this.hNq.setText(charSequence);
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh._abstract)) {
                        this.hNr.setText(aeh._abstract);
                    } else {
                        this.hNr.setText(this.hGq.getText(R.string.smart_app_default_abstract));
                    }
                    this.hNo.setTag(aeh);
                } else {
                    this.hNo.setVisibility(8);
                    this.hNl.removeHeaderView(this.hNo);
                }
                if (!this.hPC) {
                    this.hNt.setVisibility(0);
                }
                if (!dVar.bPM().aep() && this.hNu.getText() != null && this.hNu.getText().length() > 0) {
                    this.hNu.setVisibility(0);
                } else {
                    this.hNu.setVisibility(8);
                }
                n(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> adG = dVar.bPM().adG();
                if (adG != null && adG.size() > 0 && !this.hPC) {
                    this.hOK.setText(String.valueOf(adG.get(0).abC()));
                    this.hOJ.setVisibility(0);
                } else {
                    this.hOJ.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.k(this.hOJ, R.drawable.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.f(this.hOK, R.color.cp_link_tip_d, 1);
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
                            if (this.hHE != null) {
                                this.hHE.setTag(R.id.tag_user_id, c.adv().getUserId());
                                this.hHE.setOnClickListener(this.hGq.hEq.hRG);
                                this.hHE.a(iconInfo, 4, this.hGq.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGq.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGq.getResources().getDimensionPixelSize(R.dimen.tbds12));
                            }
                            if (this.hHD != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hHD.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hHD.setOnClickListener(this.hGq.hEq.hRH);
                                this.hHD.a(tShowInfoNew, 3, this.hGq.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGq.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGq.getResources().getDimensionPixelSize(R.dimen.ds12), true);
                            }
                            this.hNB.setText(bX(c.adv().getSealPrefix(), j));
                            this.hNB.setTag(R.id.tag_user_id, c.adv().getUserId());
                            this.hNB.setTag(R.id.tag_user_name, c.adv().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || c.adv().isBigV()) {
                                com.baidu.tbadk.core.util.al.f(this.hNB, R.color.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.f(this.hNB, R.color.cp_cont_b, 1);
                            }
                            if (c.adv() == null) {
                                MetaData adv = c.adv();
                                if (adv.getIs_bawu() == 1 && "manager".equals(adv.getBawu_type())) {
                                    this.hNC.setText(R.string.bawu_member_bazhu_tip);
                                    this.hNC.setVisibility(0);
                                    this.hPA = R.drawable.author_bazhu_bg;
                                    com.baidu.tbadk.core.util.al.k(this.hNC, this.hPA);
                                } else if (adv.getIs_bawu() == 1 && "assist".equals(adv.getBawu_type())) {
                                    this.hNC.setText(R.string.bawu_member_xbazhu_tip);
                                    this.hNC.setVisibility(0);
                                    this.hPA = R.drawable.author_small_bazhu;
                                    com.baidu.tbadk.core.util.al.k(this.hNC, this.hPA);
                                } else {
                                    this.hNC.setVisibility(8);
                                }
                            } else {
                                this.hNC.setVisibility(8);
                            }
                            if (dVar.bPM().adv() != null && dVar.bPM().adv().getAlaUserData() != null && this.hNH != null) {
                                if (dVar.bPM().adv().getAlaUserData().anchor_live != 0) {
                                    this.hNH.setVisibility(8);
                                } else {
                                    this.hNH.setVisibility(0);
                                    if (this.hNe == null) {
                                        this.hNe = new com.baidu.tieba.c.d(this.hGq.getPageContext(), this.hNH);
                                        this.hNe.pM(1);
                                    }
                                    this.hNe.cH(this.hGq.getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bzQ = dVar.bPM().adv().getAlaUserData();
                                    aVar.type = 2;
                                    this.hNH.setTag(aVar);
                                }
                            }
                            this.hNG.setUserId(c.adv().getUserId());
                            this.hNG.setUserName(c.adv().getUserName());
                            this.hNG.setTid(c.getId());
                            this.hNG.setFid(this.hJL == null ? this.hJL.getForumId() : "");
                            this.hNG.setImageDrawable(null);
                            this.hNG.setRadius(com.baidu.adp.lib.util.l.g(this.hGq.getActivity(), R.dimen.ds40));
                            this.hNG.setTag(c.adv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hNO.setText(com.baidu.tbadk.core.util.ap.aE(c.getTime()));
                            } else {
                                this.hNO.setText(com.baidu.tbadk.core.util.ap.aC(c.getTime()));
                            }
                            cmA = c.cmA();
                            if (cmA == null && !TextUtils.isEmpty(cmA.getName()) && !TextUtils.isEmpty(cmA.getName().trim())) {
                                this.hNP.setVisibility(0);
                                this.hNQ.setVisibility(0);
                                this.hNP.setText(cmA.getName());
                            } else {
                                this.hNP.setVisibility(8);
                                this.hNQ.setVisibility(8);
                            }
                            portrait = c.adv().getPortrait();
                            if (c.adv().getPendantData() == null && !StringUtils.isNull(c.adv().getPendantData().abS())) {
                                this.hNE.b(c.adv());
                                this.hNG.setVisibility(8);
                                this.hNE.setVisibility(0);
                                if (this.hNK != null) {
                                    this.hNK.setVisibility(8);
                                }
                                this.hNB.setOnClickListener(this.hPN);
                                this.hNE.getHeadView().startLoad(portrait, 28, false);
                                this.hNE.getHeadView().setUserId(c.adv().getUserId());
                                this.hNE.getHeadView().setUserName(c.adv().getUserName());
                                this.hNE.getHeadView().setTid(c.getId());
                                this.hNE.getHeadView().setFid(this.hJL != null ? this.hJL.getForumId() : "");
                                this.hNE.getHeadView().setOnClickListener(this.hPN);
                                this.hNE.ow(c.adv().getPendantData().abS());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hNG, c.adv());
                                this.hNG.setVisibility(0);
                                this.hNz.setOnClickListener(this.hPN);
                                this.hNB.setOnClickListener(this.hPN);
                                this.hNG.setOnClickListener(this.hPN);
                                this.hNE.setVisibility(8);
                                this.hNG.startLoad(portrait, 28, false);
                            }
                            String name_show = c.adv().getName_show();
                            String userName = c.adv().getUserName();
                            if (com.baidu.tbadk.t.as.iE() && name_show != null && !name_show.equals(userName)) {
                                this.hNB.setText(com.baidu.tieba.pb.c.aD(this.hGq.getPageContext().getPageActivity(), this.hNB.getText().toString()));
                                this.hNB.setGravity(16);
                                this.hNB.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPv());
                                com.baidu.tbadk.core.util.al.f(this.hNB, R.color.cp_other_e, 1);
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo2 = c.adv().getIconInfo();
                        tShowInfoNew = c.adv().getTShowInfoNew();
                        if (this.hHE != null) {
                        }
                        if (this.hHD != null) {
                        }
                        this.hNB.setText(bX(c.adv().getSealPrefix(), j));
                        this.hNB.setTag(R.id.tag_user_id, c.adv().getUserId());
                        this.hNB.setTag(R.id.tag_user_name, c.adv().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.f(this.hNB, R.color.cp_cont_h, 1);
                        if (c.adv() == null) {
                        }
                        if (dVar.bPM().adv() != null) {
                            if (dVar.bPM().adv().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hNG.setUserId(c.adv().getUserId());
                        this.hNG.setUserName(c.adv().getUserName());
                        this.hNG.setTid(c.getId());
                        this.hNG.setFid(this.hJL == null ? this.hJL.getForumId() : "");
                        this.hNG.setImageDrawable(null);
                        this.hNG.setRadius(com.baidu.adp.lib.util.l.g(this.hGq.getActivity(), R.dimen.ds40));
                        this.hNG.setTag(c.adv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cmA = c.cmA();
                        if (cmA == null) {
                        }
                        this.hNP.setVisibility(8);
                        this.hNQ.setVisibility(8);
                        portrait = c.adv().getPortrait();
                        if (c.adv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hNG, c.adv());
                        this.hNG.setVisibility(0);
                        this.hNz.setOnClickListener(this.hPN);
                        this.hNB.setOnClickListener(this.hPN);
                        this.hNG.setOnClickListener(this.hPN);
                        this.hNE.setVisibility(8);
                        this.hNG.startLoad(portrait, 28, false);
                        String name_show2 = c.adv().getName_show();
                        String userName2 = c.adv().getUserName();
                        if (com.baidu.tbadk.t.as.iE()) {
                            this.hNB.setText(com.baidu.tieba.pb.c.aD(this.hGq.getPageContext().getPageActivity(), this.hNB.getText().toString()));
                            this.hNB.setGravity(16);
                            this.hNB.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPv());
                            com.baidu.tbadk.core.util.al.f(this.hNB, R.color.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bj(string) > 14) {
                            j = com.baidu.tbadk.core.util.ap.j(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.adv().getIconInfo();
                            tShowInfoNew = c.adv().getTShowInfoNew();
                            if (this.hHE != null) {
                            }
                            if (this.hHD != null) {
                            }
                            this.hNB.setText(bX(c.adv().getSealPrefix(), j));
                            this.hNB.setTag(R.id.tag_user_id, c.adv().getUserId());
                            this.hNB.setTag(R.id.tag_user_name, c.adv().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.f(this.hNB, R.color.cp_cont_h, 1);
                            if (c.adv() == null) {
                            }
                            if (dVar.bPM().adv() != null) {
                            }
                            this.hNG.setUserId(c.adv().getUserId());
                            this.hNG.setUserName(c.adv().getUserName());
                            this.hNG.setTid(c.getId());
                            this.hNG.setFid(this.hJL == null ? this.hJL.getForumId() : "");
                            this.hNG.setImageDrawable(null);
                            this.hNG.setRadius(com.baidu.adp.lib.util.l.g(this.hGq.getActivity(), R.dimen.ds40));
                            this.hNG.setTag(c.adv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cmA = c.cmA();
                            if (cmA == null) {
                            }
                            this.hNP.setVisibility(8);
                            this.hNQ.setVisibility(8);
                            portrait = c.adv().getPortrait();
                            if (c.adv().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hNG, c.adv());
                            this.hNG.setVisibility(0);
                            this.hNz.setOnClickListener(this.hPN);
                            this.hNB.setOnClickListener(this.hPN);
                            this.hNG.setOnClickListener(this.hPN);
                            this.hNE.setVisibility(8);
                            this.hNG.startLoad(portrait, 28, false);
                            String name_show22 = c.adv().getName_show();
                            String userName22 = c.adv().getUserName();
                            if (com.baidu.tbadk.t.as.iE()) {
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo222 = c.adv().getIconInfo();
                        tShowInfoNew = c.adv().getTShowInfoNew();
                        if (this.hHE != null) {
                        }
                        if (this.hHD != null) {
                        }
                        this.hNB.setText(bX(c.adv().getSealPrefix(), j));
                        this.hNB.setTag(R.id.tag_user_id, c.adv().getUserId());
                        this.hNB.setTag(R.id.tag_user_name, c.adv().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.f(this.hNB, R.color.cp_cont_h, 1);
                        if (c.adv() == null) {
                        }
                        if (dVar.bPM().adv() != null) {
                        }
                        this.hNG.setUserId(c.adv().getUserId());
                        this.hNG.setUserName(c.adv().getUserName());
                        this.hNG.setTid(c.getId());
                        this.hNG.setFid(this.hJL == null ? this.hJL.getForumId() : "");
                        this.hNG.setImageDrawable(null);
                        this.hNG.setRadius(com.baidu.adp.lib.util.l.g(this.hGq.getActivity(), R.dimen.ds40));
                        this.hNG.setTag(c.adv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cmA = c.cmA();
                        if (cmA == null) {
                        }
                        this.hNP.setVisibility(8);
                        this.hNQ.setVisibility(8);
                        portrait = c.adv().getPortrait();
                        if (c.adv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hNG, c.adv());
                        this.hNG.setVisibility(0);
                        this.hNz.setOnClickListener(this.hPN);
                        this.hNB.setOnClickListener(this.hPN);
                        this.hNG.setOnClickListener(this.hPN);
                        this.hNE.setVisibility(8);
                        this.hNG.startLoad(portrait, 28, false);
                        String name_show222 = c.adv().getName_show();
                        String userName222 = c.adv().getUserName();
                        if (com.baidu.tbadk.t.as.iE()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hNy.at(dVar.bPM());
                }
                if (this.hOS != null) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBY);
                    if (dVar != null && dVar.bPM() != null) {
                        iVar.hCa = dVar.bPM().adm();
                    }
                    iVar.isNew = !this.hGH;
                    iVar.sortType = dVar.hBG;
                    if (dVar.hBF != null && dVar.hBF.size() > dVar.hBG) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hBF.size()) {
                                break;
                            } else if (dVar.hBF.get(i4).sort_type.intValue() != dVar.hBG) {
                                i3 = i4 + 1;
                            } else {
                                iVar.hCc = dVar.hBF.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    iVar.hCd = this.hGq.bRT();
                    this.hOS.a(iVar);
                }
                if (dVar != null && dVar.bPM() != null) {
                    aa(dVar.bPM().adr() == 1, dVar.bPM().adq() == 1);
                }
                com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hOa != null && aq.this.hNh != null && aq.this.hNh.hSG != null && aq.this.hJL != null && aq.this.hJL.bPM() != null && !aq.this.hJL.bPM().aep() && !aq.this.bUO() && aq.this.hJL.getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(aq.this.hJL.getForum().getName())) {
                            if (aq.this.hOa.bSr() == null || !aq.this.hOa.bSr().isShown()) {
                                aq.this.hNh.hSG.setVisibility(0);
                                if (aq.this.hGq != null && aq.this.hGq.bQS() != null) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13400");
                                    amVar.bT("tid", aq.this.hGq.bQS().bSJ());
                                    amVar.bT("fid", aq.this.hGq.bQS().getForumId());
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

    public void oF(boolean z) {
        if (z) {
            bUI();
        } else {
            bed();
        }
        this.hOW.hQg = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOW));
        a(this.hOW.hQg, false);
    }

    public void bUI() {
        if (this.hNh != null && !this.hPm) {
            this.hNh.pa(!StringUtils.isNull(this.hGq.bRs()));
            this.hPm = true;
        }
    }

    public void bed() {
        if (this.hNh != null) {
            this.hNh.bVU();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.adQ() != null) {
            this.hNA.setData(this.hGq.getPageContext(), dVar.bPO().get(0).adQ(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bPM().getId(), this.hGq.bRQ() ? "FRS" : null));
            this.hNz.setPadding(this.hNz.getPaddingLeft(), (int) this.hGq.getResources().getDimension(R.dimen.ds20), this.hNz.getPaddingRight(), this.hNz.getPaddingBottom());
            return;
        }
        this.hNA.setData(null, null, null);
    }

    public void bUJ() {
        if (this.hNb != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").P("obj_type", 1));
            this.hNb.bXg();
            this.hNl.smoothScrollToPosition(0);
        }
    }

    public boolean bUK() {
        return this.hPO;
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
            this.hNh.bVS();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hNh.zh(cVar.forumName);
            }
            String string = this.hGq.getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.f(cVar.source, 0)) {
                case 100:
                    str = this.hGq.getResources().getString(R.string.self);
                    break;
                case 300:
                    str = this.hGq.getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = this.hGq.getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hAZ;
            this.hGq.showNetRefreshView(this.epW, format, null, this.hGq.getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.ki()) {
                        ba.aiz().c(aq.this.hGq.getPageContext(), new String[]{str2});
                        aq.this.hGq.finish();
                        return;
                    }
                    aq.this.hGq.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bTT;
        Parcelable bTT2;
        if (dVar != null) {
            this.hJL = dVar;
            this.mType = i;
            if (dVar.bPM() != null) {
                this.hOY = dVar.bPM().add();
                if (dVar.bPM().getAnchorLevel() != 0) {
                    this.hPO = true;
                }
                this.hOu = av(dVar.bPM());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.hOI = false;
            this.hGH = z;
            bUE();
            if (dVar.hBH != null && dVar.hBH.bQn()) {
                if (this.hNm == null) {
                    this.hNm = new PbThreadPostView(this.hGq);
                    this.hNl.addHeaderView(this.hNm, 1);
                    this.hNm.setData(dVar);
                    this.hNm.setChildOnClickLinstener(this.fra);
                }
            } else if (this.hNm != null && this.hNl != null) {
                this.hNl.removeHeaderView(this.hNm);
            }
            b(dVar, z, i);
            p(dVar);
            if (this.hPy == null) {
                this.hPy = new ac(this.hGq.getPageContext(), this.fNv);
            }
            this.hPy.Bm(dVar.bPR());
            if (this.hGq.bRH()) {
                if (this.hOe == null) {
                    this.hOe = new com.baidu.tieba.pb.view.c(this.hGq.getPageContext());
                    this.hOe.nG();
                    this.hOe.setListPullRefreshListener(this.bZB);
                }
                this.hNl.setPullRefresh(this.hOe);
                bUL();
                if (this.hOe != null) {
                    this.hOe.iP(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().acq() == 0 && z) {
                this.hNl.setPullRefresh(null);
            } else {
                if (this.hOe == null) {
                    this.hOe = new com.baidu.tieba.pb.view.c(this.hGq.getPageContext());
                    this.hOe.nG();
                    this.hOe.setListPullRefreshListener(this.bZB);
                }
                this.hNl.setPullRefresh(this.hOe);
                bUL();
                if (this.hOe != null) {
                    this.hOe.iP(TbadkCoreApplication.getInst().getSkinType());
                }
                aSG();
            }
            bUP();
            this.hOa.nT(this.hGH);
            this.hOa.nU(false);
            this.hOa.of(i == 5);
            this.hOa.og(i == 6);
            this.hOa.oh(z2 && this.hPM);
            this.hOa.a(dVar, false);
            this.hOa.notifyDataSetChanged();
            if (this.hGq.bQI()) {
                this.hPo = 0;
                PostData c = c(dVar, z);
                if (c != null && c.adv() != null) {
                    this.hPo = c.adv().getLevel_id();
                }
                if (this.hPo > 0) {
                    this.hND.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.hND, BitmapHelper.getGradeResourceIdInEnterForum(this.hPo));
                } else {
                    this.hND.setVisibility(8);
                }
            } else {
                this.hND.setVisibility(8);
            }
            if (dVar.bPM() != null && dVar.bPM().adh() != null) {
                if (dVar.bPM().adh().getNum() < 1) {
                    this.hGq.getResources().getString(R.string.zan);
                } else {
                    String str = dVar.bPM().adh().getNum() + "";
                }
                if (this.hNa != -1) {
                    dVar.bPM().adh().setIsLike(this.hNa);
                }
            }
            if (this.hGq.isLogin()) {
                this.hNl.setNextPage(this.fvh);
                this.hNg = 2;
                aSG();
            } else {
                this.hOI = true;
                if (dVar.getPage().acp() == 1) {
                    if (this.hOf == null) {
                        this.hOf = new com.baidu.tieba.pb.view.a(this.hGq.getPageContext());
                    }
                    this.hNl.setNextPage(this.hOf);
                } else {
                    this.hNl.setNextPage(this.fvh);
                }
                this.hNg = 3;
            }
            ArrayList<PostData> bPO = dVar.bPO();
            if (dVar.getPage().acp() == 0 || bPO == null || bPO.size() < dVar.getPage().aco()) {
                if (com.baidu.tbadk.core.util.v.Z(bPO) == 0 || (com.baidu.tbadk.core.util.v.Z(bPO) == 1 && bPO.get(0) != null && bPO.get(0).cmx() == 1)) {
                    if (this.hOW == null || this.hOW.hQg == null || this.hOW.hQg.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hOW.hQg.getView().getTop() < 0 ? this.hOW.hQg.getView().getHeight() : this.hOW.hQg.getView().getBottom();
                    }
                    if (this.hGq.bRT()) {
                        this.fvh.W(this.hGq.getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.fvh.W(this.hGq.getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.hGq.bRh() != null && !this.hGq.bRh().bVH()) {
                        this.hGq.bRh().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().acp() == 0) {
                        this.fvh.setText(this.hGq.getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.fvh.setText(this.hGq.getResources().getString(R.string.load_more));
                    }
                    this.fvh.ajD();
                }
                bUX();
            } else {
                if (z2) {
                    if (this.hPM) {
                        ajz();
                        if (dVar.getPage().acp() != 0) {
                            this.fvh.setText(this.hGq.getResources().getString(R.string.pb_load_more));
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
                    this.hNl.setSelection(i2 > 1 ? (((this.hNl.getData() == null && dVar.bPO() == null) ? 0 : (this.hNl.getData().size() - dVar.bPO().size()) + this.hNl.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bTT2 = aj.bTS().bTT()) != null) {
                        this.hNl.onRestoreInstanceState(bTT2);
                        if (com.baidu.tbadk.core.util.v.Z(bPO) > 1 && dVar.getPage().acp() > 0) {
                            this.fvh.ajz();
                            this.fvh.setText(this.hGq.getString(R.string.pb_load_more_without_point));
                            this.fvh.ajv();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hPM = false;
                    break;
                case 5:
                    this.hNl.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bTT = aj.bTS().bTT()) != null) {
                        this.hNl.onRestoreInstanceState(bTT);
                        break;
                    } else {
                        this.hNl.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.hNb != null && this.hNb.aHS() != null) {
                            if (this.hGq.isUseStyleImmersiveSticky()) {
                                this.hNl.setSelectionFromTop((this.hOa.bSm() + this.hNl.getHeaderViewsCount()) - 1, this.hNb.aHS().getHeight() - com.baidu.adp.lib.util.l.r(this.hGq.getPageContext().getPageActivity()));
                            } else {
                                this.hNl.setSelectionFromTop((this.hOa.bSm() + this.hNl.getHeaderViewsCount()) - 1, this.hNb.aHS().getHeight());
                            }
                        } else {
                            this.hNl.setSelection(this.hOa.bSm() + this.hNl.getHeaderViewsCount());
                        }
                    } else {
                        this.hNl.setSelection(i2 > 0 ? ((this.hNl.getData() == null && dVar.bPO() == null) ? 0 : (this.hNl.getData().size() - dVar.bPO().size()) + this.hNl.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fvh.ajz();
                    this.fvh.setText(this.hGq.getString(R.string.pb_load_more_without_point));
                    this.fvh.ajv();
                    break;
            }
            if (this.hOY == hOZ && isHost()) {
                bVf();
            }
            if (this.hPi) {
                bUc();
                this.hPi = false;
                if (i3 == 0) {
                    oz(true);
                }
            }
            if (this.hNd != null) {
                this.hNd.aA(dVar.bPM());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hBD == 1 || dVar.hBE == 1) {
                if (this.hPp == null) {
                    this.hPp = new PbTopTipView(this.hGq);
                }
                if (dVar.hBE == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hGq.getStType())) {
                    this.hPp.setText(this.hGq.getString(R.string.pb_read_strategy_add_experience));
                    this.hPp.show(this.epW, this.mSkinType);
                } else if (dVar.hBD == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hGq.getStType())) {
                    this.hPp.setText(this.hGq.getString(R.string.pb_read_news_add_experience));
                    this.hPp.show(this.epW, this.mSkinType);
                }
            }
            o(dVar);
        }
    }

    private void o(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPM() != null) {
            if (dVar.ZC()) {
                com.baidu.tbadk.core.util.al.c(this.hOB, (int) R.drawable.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.al.c(this.hOB, (int) R.drawable.icon_pb_bottom_collect_n);
            }
            this.hOD.setText(xC(dVar.bPM().adm()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, dVar.bPM()));
        }
    }

    private String xC(int i) {
        if (i == 0) {
            return this.hGq.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void bUL() {
        if (this.hNb != null && this.hNb.aHS() != null) {
            this.hNl.removeHeaderView(this.aif);
            if (this.mType != 1) {
                this.hNl.removeHeaderView(this.hNb.bXi());
                this.hNl.addHeaderView(this.hNb.bXi(), 0);
                return;
            }
            return;
        }
        if (this.hNb != null) {
            this.hNl.removeHeaderView(this.hNb.bXi());
        }
        this.hNl.removeHeaderView(this.aif);
        this.hNl.addHeaderView(this.aif, 0);
    }

    public void oG(boolean z) {
        this.hOt = z;
    }

    public void ajz() {
        if (this.fvh != null) {
            this.fvh.ajv();
            this.fvh.ajz();
        }
        aSG();
    }

    public void aUH() {
        this.hNl.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hOH != null && this.hOH.adv() != null && this.hNh != null) {
            this.hPl = !this.hPk;
            this.hNh.oV(this.hPl);
            if (this.hGq.bRh() != null) {
                this.hGq.bRh().oU(this.hPl);
            }
            bUM();
            if (this.hGq != null && !this.hGq.bQI() && !com.baidu.tbadk.core.util.v.aa(dVar.bQh())) {
                bc bcVar = dVar.bQh().get(0);
                if (bcVar != null) {
                    this.hNh.dN(bcVar.getForumName(), bcVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hNh.dN(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hPl) {
                if (this.hOu) {
                    this.hNL.setVisibility(8);
                    this.hNN.setVisibility(0);
                    this.hNN.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.ap.aI(dVar.bQi())));
                }
                if (this.hOR != null) {
                    this.hOR.setVisibility(8);
                }
                if (this.hPw == null) {
                    this.hPw = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hPn) {
                                aq.this.bVe();
                            }
                            aq.this.bUF();
                        }
                    };
                }
                this.hNl.setListViewDragListener(this.hPw);
                return;
            }
            if (this.hOR != null) {
                this.hOR.setVisibility(0);
            }
            if (this.hOu) {
                this.hNL.setVisibility(8);
                this.hNN.setVisibility(0);
                this.hNN.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.ap.aI(dVar.bQi())));
            } else if (!com.baidu.tbadk.t.au.auI() || (this.hOH.adv().hadConcerned() && this.hOH.adv().getGodUserData() != null && this.hOH.adv().getGodUserData().getIsFromNetWork())) {
                this.hNL.setVisibility(8);
                this.hNN.setVisibility(8);
            } else {
                this.hNN.setVisibility(8);
            }
            this.hPw = null;
            this.hNl.setListViewDragListener(null);
        }
    }

    private void bUM() {
        String threadId = this.hJL != null ? this.hJL.getThreadId() : "";
        int bUN = bUN();
        if (this.hPl && this.hOH != null && this.hOH.adv() != null) {
            this.hOH.adv().setIsLike(this.hOH.adv().hadConcerned());
        }
        if (this.hNM == null) {
            this.hNM = new ao(this.hGq.getPageContext(), this.hNL, 1);
            this.hNM.i(this.hGq.getUniqueId());
            this.hNM.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void es(boolean z) {
                    if (aq.this.hGq != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hGq, (int) R.string.attention_success);
                    }
                }
            });
        }
        if (this.hOH != null && this.hOH.adv() != null) {
            this.hOH.adv().setIsLike(this.hOH.adv().hadConcerned());
            this.hNM.a(this.hOH.adv());
            this.hNM.setTid(threadId);
        }
        this.hNM.hMW = this.hPk;
        this.hNM.xz(bUN);
    }

    public int bUN() {
        if (this.hJL == null || this.hJL.bPM() == null) {
            return 0;
        }
        if (this.hJL.bPM().aeN()) {
            return (com.baidu.tbadk.core.util.v.aa(this.hJL.bQh()) && (this.hJL.bPL() == null || StringUtils.isNull(this.hJL.bPL().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bUO() {
        return this.hJL == null || this.hJL.getForum() == null || "0".equals(this.hJL.getForum().getId()) || "me0407".equals(this.hJL.getForum().getName());
    }

    private boolean bUP() {
        boolean z;
        if (this.hOx != null && this.hOx.getVisibility() == 0) {
            if (this.hNW != null) {
                this.hNW.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hNW != null) {
                this.hNW.setVisibility(8);
            }
            z = false;
        }
        if ((this.hNY == null || this.hNY.getVisibility() == 8) && z && this.hGH) {
            this.hNX.setVisibility(0);
        } else {
            this.hNX.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bPM() == null) {
            return false;
        }
        if (dVar.bPM().ads() == 1 || dVar.bPM().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bPM().adu() == null || dVar.bPM().adu().afv() == 0) || dVar.bPM().adq() == 1 || dVar.bPM().adr() == 1 || dVar.bPM().aeg() || dVar.bPM().aev() || dVar.bPM().aeo() || dVar.bPM().adH() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.bPM().getCategory()) || dVar.bPM().ady() || dVar.bPM().adx();
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hGq.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hNt != null) {
                if (dVar.bPM() != null && dVar.bPM().adK() == 0 && !dVar.bPM().aep() && !this.hPC) {
                    this.hNt.setVisibility(0);
                    if (dVar.bPM() != null) {
                        bg bPM = dVar.bPM();
                        bPM.k(true, q(dVar));
                        bPM.setResource(3);
                        bPM.mn("2");
                    }
                    SpannableStringBuilder aeb = dVar.bPM().aeb();
                    this.hNu.setOnTouchListener(new com.baidu.tieba.view.k(aeb));
                    this.hNu.setText(aeb);
                    this.hNu.setVisibility(0);
                } else if (dVar.bPM().adK() == 1) {
                    if (dVar.bPM() != null) {
                        this.hNt.setVisibility(8);
                        this.hNl.removeHeaderView(this.hNt);
                    }
                } else {
                    this.hNt.setVisibility(8);
                    this.hNl.removeHeaderView(this.hNt);
                    if (dVar.bPM() != null && dVar.bPM().aep()) {
                        this.hNz.setPadding(this.hNz.getPaddingLeft(), 0, this.hNz.getPaddingRight(), this.hNz.getPaddingBottom());
                        if (this.hNR != null) {
                            ((RelativeLayout.LayoutParams) this.hNR.getLayoutParams()).height = (int) this.hGq.getResources().getDimension(R.dimen.tbds36);
                            this.hNR.requestLayout();
                        }
                        if (this.hNS != null) {
                            ((RelativeLayout.LayoutParams) this.hNS.getLayoutParams()).height = (int) this.hGq.getResources().getDimension(R.dimen.tbds0);
                            this.hNS.requestLayout();
                        }
                    } else {
                        this.hNz.setPadding(this.hNz.getPaddingLeft(), com.baidu.adp.lib.util.l.g(this.hGq.getPageContext().getPageActivity(), R.dimen.ds48), this.hNz.getPaddingRight(), this.hNz.getPaddingBottom());
                    }
                }
            }
            if (dVar.bPM() != null) {
                Z(dVar.bPM().adr() == 1, dVar.bPM().adq() == 1);
            }
            this.hGH = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bUP();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bPY()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bPY()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bc> bQh = dVar.bQh();
                if (com.baidu.tbadk.core.util.v.Z(bQh) > 0) {
                    sb = new StringBuilder();
                    for (bc bcVar : bQh) {
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bHR) != null && vVar.bFJ && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.i(bcVar.getForumName(), 12)).append(this.hGq.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.hGq.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.cxP;
    }

    public boolean bUQ() {
        if (this.epZ == null || this.epZ.getParent() == null || this.fvh.pu()) {
            return false;
        }
        int bottom = this.epZ.getBottom();
        Rect rect = new Rect();
        this.epZ.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Bn(String str) {
        if (this.fvh != null) {
            this.fvh.setText(str);
        }
    }

    public void Bo(String str) {
        if (this.fvh != null) {
            int i = 0;
            if (this.hOW != null && this.hOW.hQg != null && this.hOW.hQg.getView() != null) {
                i = this.hOW.hQg.getView().getTop() < 0 ? this.hOW.hQg.getView().getHeight() : this.hOW.hQg.getView().getBottom();
            }
            this.fvh.W(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hNl;
    }

    public int bUR() {
        return R.id.richText;
    }

    public TextView bRd() {
        return this.hNy.bRd();
    }

    public void e(BdListView.e eVar) {
        this.hNl.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.bZB = cVar;
        if (this.hOe != null) {
            this.hOe.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int acn = anVar.acn();
            int ack = anVar.ack();
            if (this.hOb != null) {
                this.hOb.afG();
            } else {
                this.hOb = new com.baidu.tbadk.core.dialog.a(this.hGq.getPageContext().getPageActivity());
                this.hOc = LayoutInflater.from(this.hGq.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.hOb.aF(this.hOc);
                this.hOb.a(R.string.dialog_ok, bVar);
                this.hOb.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bUT();
                        aVar.dismiss();
                    }
                });
                this.hOb.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hPf == null) {
                            aq.this.hPf = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hGq.HidenSoftKeyPad((InputMethodManager) aq.this.hGq.getSystemService("input_method"), aq.this.epW);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.iB().postDelayed(aq.this.hPf, 150L);
                    }
                });
                this.hOb.b(this.hGq.getPageContext()).afG();
            }
            this.hOd = (EditText) this.hOc.findViewById(R.id.input_page_number);
            this.hOd.setText("");
            TextView textView = (TextView) this.hOc.findViewById(R.id.current_page_number);
            if (acn <= 0) {
                acn = 1;
            }
            if (ack <= 0) {
                ack = 1;
            }
            textView.setText(MessageFormat.format(this.hGq.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(acn), Integer.valueOf(ack)));
            this.hGq.ShowSoftKeyPadDelay(this.hOd, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hNl.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hGq.showToast(str);
    }

    public boolean oH(boolean z) {
        if (this.TA == null || !this.TA.aqV()) {
            return false;
        }
        this.TA.app();
        return true;
    }

    public void bUS() {
        if (this.hPP != null) {
            while (this.hPP.size() > 0) {
                TbImageView remove = this.hPP.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bUS();
        this.hOa.xk(1);
        if (this.hNb != null) {
            this.hNb.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hOa.xk(2);
        if (this.hNb != null) {
            this.hNb.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.hGq) && !TbSingleton.getInstance().isCutoutScreen(this.hGq)) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hPh != null) {
            this.hPh.destroy();
        }
        if (this.hPy != null) {
            this.hPy.onDestory();
        }
        if (this.hPp != null) {
            this.hPp.hide();
        }
        if (this.hNe != null) {
            this.hNe.aZA();
        }
        if (this.hNd != null) {
            this.hNd.onDestroy();
        }
        this.hGq.hideProgressBar();
        if (this.eRV != null && this.fmv != null) {
            this.eRV.b(this.fmv);
        }
        bUT();
        ajz();
        if (this.hPf != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hPf);
        }
        if (this.hNz != null && this.hNK != null) {
            this.hNz.removeView(this.hNF);
            this.hNK = null;
        }
        if (this.hOM != null) {
            this.hOM.clearStatus();
        }
        this.hPI = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hOa.xk(3);
        if (this.frn != null) {
            this.frn.setBackgroundDrawable(null);
        }
        if (this.hNb != null) {
            this.hNb.destroy();
        }
        if (this.hOa != null) {
            this.hOa.onDestroy();
        }
        this.hNl.setOnLayoutListener(null);
        if (this.hPu != null) {
            this.hPu.bmr();
        }
        if (this.hOX != null) {
            this.hOX.onDestroy();
        }
    }

    public boolean xD(int i) {
        if (this.hNb != null) {
            return this.hNb.rz(i);
        }
        return false;
    }

    public void bUT() {
        this.hNh.TU();
        if (this.hNe != null) {
            this.hNe.aZA();
        }
        com.baidu.adp.lib.util.l.b(this.hGq.getPageContext().getPageActivity(), this.hOd);
        bUe();
        if (this.hEv != null) {
            this.hEv.dismiss();
        }
        bUV();
        if (this.hNd != null) {
            this.hNd.bWX();
        }
        if (this.hOb != null) {
            this.hOb.dismiss();
        }
        if (this.fqZ != null) {
            this.fqZ.dismiss();
        }
    }

    public void bUU() {
        this.hNh.TU();
        if (this.hNe != null) {
            this.hNe.aZA();
        }
        if (this.hEv != null) {
            this.hEv.dismiss();
        }
        bUV();
        if (this.hNd != null) {
            this.hNd.bWX();
        }
        if (this.hOb != null) {
            this.hOb.dismiss();
        }
        if (this.fqZ != null) {
            this.fqZ.dismiss();
        }
    }

    public void dI(List<String> list) {
        this.hPt = list;
        if (this.hPu != null) {
            this.hPu.setData(list);
        }
    }

    public void nS(boolean z) {
        this.hOa.nS(z);
    }

    public void oI(boolean z) {
        this.hOw = z;
    }

    public void bUV() {
        if (this.hOk != null) {
            this.hOk.dismiss();
        }
        if (this.hOl != null) {
            com.baidu.adp.lib.g.g.b(this.hOl, this.hGq.getPageContext());
        }
        if (this.hOm != null) {
            com.baidu.adp.lib.g.g.b(this.hOm, this.hGq.getPageContext());
        }
        if (this.hOi != null) {
            this.hOi.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hJL, this.hGH);
            d(this.hJL, this.hGH, this.mType);
            this.hGq.getLayoutMode().setNightMode(i == 1);
            this.hGq.getLayoutMode().onModeChanged(this.epW);
            this.hGq.getLayoutMode().onModeChanged(this.hNn);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.al.l(this.epW, R.color.cp_bg_line_d);
            }
            if (this.hNd != null) {
                this.hNd.onChangeSkinType(i);
            }
            if (this.hNo != null) {
                com.baidu.tbadk.core.util.al.l(this.hNo, R.color.cp_bg_line_c);
            }
            if (this.hNp != null) {
                this.hNp.setIsNight(this.mSkinType == 1);
            }
            if (this.hNq != null) {
                com.baidu.tbadk.core.util.al.j(this.hNq, R.color.cp_cont_b);
            }
            if (this.hNr != null) {
                com.baidu.tbadk.core.util.al.j(this.hNr, R.color.cp_cont_j);
            }
            if (this.hNs != null) {
                com.baidu.tbadk.core.util.al.k(this.hNs, R.drawable.icon_common_arrow16_right_n);
            }
            if (this.hNu != null) {
                com.baidu.tbadk.core.util.al.j(this.hNu, R.color.cp_cont_b);
                this.hNu.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            }
            if (this.fvh != null) {
                this.fvh.iP(i);
                if (this.cxP != null) {
                    this.hGq.getLayoutMode().onModeChanged(this.cxP);
                    com.baidu.tbadk.core.util.al.k(this.cxP, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.hOb != null) {
                this.hOb.c(this.hGq.getPageContext());
            }
            oG(this.hOt);
            this.hOa.notifyDataSetChanged();
            if (this.hOe != null) {
                this.hOe.iP(i);
            }
            if (this.TA != null) {
                this.TA.onChangeSkinType(i);
            }
            if (this.hNJ != null) {
                this.hNJ.iW(i);
            }
            if (this.hOf != null) {
                this.hOf.iP(i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.ezV)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ezV) {
                    customBlueCheckRadioButton.ajd();
                }
            }
            bUu();
            UtilHelper.setStatusBarBackground(this.frn, i);
            UtilHelper.setStatusBarBackground(this.hOR, i);
            if (this.hNL != null) {
                this.hNL.onChangeSkinType(i);
            }
            if (this.hNP != null) {
                com.baidu.tbadk.core.util.al.j(this.hNP, R.color.cp_cont_d);
            }
            if (this.hNO != null) {
                com.baidu.tbadk.core.util.al.j(this.hNO, R.color.cp_cont_d);
            }
            if (this.hNQ != null) {
                com.baidu.tbadk.core.util.al.j(this.hNQ, R.color.cp_cont_d);
            }
            if (this.hNN != null) {
                com.baidu.tbadk.core.util.al.j(this.hNN, R.color.cp_cont_d);
            }
            if (this.hNT != null) {
                com.baidu.tbadk.s.a.a(this.hGq.getPageContext(), this.hNT);
            }
            if (this.hPg != null) {
                this.hPg.onChangeSkinType(i);
            }
            if (this.hNh != null) {
                if (this.hNb != null) {
                    this.hNb.xI(i);
                } else {
                    this.hNh.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.ggc != null) {
                com.baidu.tbadk.core.util.al.j(this.ggc, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.k(this.ggc, R.drawable.bg_comment_input);
            }
            if (this.hOB != null && this.hJL != null) {
                if (this.hJL.ZC()) {
                    com.baidu.tbadk.core.util.al.c(this.hOB, (int) R.drawable.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.hOB, (int) R.drawable.icon_pb_bottom_collect_n);
                }
            }
            if (this.hOC != null) {
                com.baidu.tbadk.core.util.al.c(this.hOC, (int) R.drawable.icon_pb_bottom_share_n);
            }
            if (this.hOA != null) {
                com.baidu.tbadk.core.util.al.c(this.hOA, (int) R.drawable.icon_pb_bottom_comment_n);
            }
            com.baidu.tbadk.core.util.al.j(this.hOD, R.color.cp_cont_b);
            if (this.hND != null) {
                com.baidu.tbadk.core.util.al.c(this.hND, BitmapHelper.getGradeResourceIdInEnterForum(this.hPo));
            }
            if (this.hPv != null) {
                this.hPv.onChangeSkinType(i);
            }
            if (this.hOX != null) {
                this.hOX.onChangeSkinType();
            }
            if (this.hPr != null) {
                com.baidu.tbadk.core.util.al.j(this.hPr, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.al.l(this.hOz, R.color.cp_bg_line_d);
            if (this.hNC != null) {
                com.baidu.tbadk.core.util.al.k(this.hNC, this.hPA);
                com.baidu.tbadk.core.util.al.j(this.hNC, R.color.cp_btn_a);
            }
            if (this.hNm != null) {
                this.hNm.nq(i);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIN = hVar;
        this.hOa.setOnImageClickListener(this.cIN);
        this.hPv.setOnImageClickListener(this.cIN);
    }

    public void h(NoNetworkView.a aVar) {
        this.fmv = aVar;
        if (this.eRV != null) {
            this.eRV.a(this.fmv);
        }
    }

    public void oJ(boolean z) {
        this.hOa.setIsFromCDN(z);
    }

    public Button bUW() {
        return this.hOx;
    }

    public void bUX() {
        if (this.hNg != 2) {
            this.hNl.setNextPage(this.fvh);
            this.hNg = 2;
        }
    }

    public void bUY() {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            int lastVisiblePosition = this.hNl.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hNl.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog = tbImageView.getPerfLog();
                                perfLog.kK(1001);
                                perfLog.cyw = true;
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
                        perfLog2.cyw = true;
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

    public boolean bUZ() {
        return this.TA != null && this.TA.getVisibility() == 0;
    }

    public boolean bVa() {
        return this.TA != null && this.TA.aqV();
    }

    public void bVb() {
        if (this.TA != null) {
            this.TA.app();
        }
    }

    public void oK(boolean z) {
        if (this.hOz != null) {
            oI(this.hGq.bRe().arz());
            if (this.hOw) {
                oA(z);
            } else {
                oB(z);
            }
        }
    }

    public void bVc() {
        if (this.hOz != null) {
            this.hOy.setVisibility(8);
            this.hOz.setVisibility(8);
            this.hOE = false;
            if (this.hOX != null) {
                this.hOX.setVisibility(8);
                oE(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.eHw == null) {
            this.eHw = new com.baidu.tbadk.core.view.b(this.hGq.getPageContext());
        }
        this.eHw.ef(true);
    }

    public void aSG() {
        if (this.eHw != null) {
            this.eHw.ef(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hNl.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hNl.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hNb != null) {
            this.hNb.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hPQ = getScrollY();
            this.hOW.hQg = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOW));
            a(this.hOW.hQg, true);
        }
    }

    public void oL(boolean z) {
        this.hNb.oL(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hNb != null) {
            this.hNb.b(absListView, i);
        }
        if (this.hNh != null && this.hOa != null) {
            this.hNh.a(this.hOa.bSr());
        }
        this.hOW.hwz = i;
        this.hOW.headerCount = this.hNl.getHeaderViewsCount();
        this.hOW.hQg = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOW));
        a(this.hOW.hQg, false);
        if (this.fvh.ajF() && !this.fvh.bZq) {
            if (this.hOW != null && this.hOW.hQg != null && this.hOW.hQg.getView() != null) {
                i4 = this.hOW.hQg.getView().getTop() < 0 ? this.hOW.hQg.getView().getHeight() : this.hOW.hQg.getView().getBottom();
            }
            this.fvh.iS(i4);
            this.fvh.bZq = true;
        }
    }

    public void bVd() {
        if (this.hGq.isLogin() && this.hJL != null && this.hPl && !this.hPk && !this.hOu && this.hOH != null && this.hOH.adv() != null && !this.hOH.adv().getIsLike() && !this.hOH.adv().hadConcerned() && this.hPh == null) {
            this.hPh = new an(this.hGq);
        }
    }

    public void bVe() {
        if (this.hPl && !this.hPk && this.hOH != null && this.hOH.adv() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").P("obj_locate", this.hGq.bQI() ? 2 : 1).P("obj_type", this.hPk ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hGq.getPageContext().getPageActivity(), this.hOH.adv().getUserId(), this.hOH.adv().getUserName(), this.hGq.bQS().bQJ(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hPk && this.hOQ != null && this.hNh.bVN() != null) {
            int bSn = this.hOa.bSn();
            if (bSn > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bSn > this.hNl.getFirstVisiblePosition() - this.hNl.getHeaderViewsCount()) {
                    this.hOQ.setVisibility(8);
                    return;
                }
                this.hOQ.setVisibility(0);
                bVo();
                this.hNh.mNavigationBar.hideBottomLine();
                if (this.hOQ.getParent() != null && ((ViewGroup) this.hOQ.getParent()).getHeight() <= this.hOQ.getTop()) {
                    this.hOQ.getParent().requestLayout();
                }
            } else if (alVar == null || alVar.getView() == null || alVar.hMF == null) {
                if (this.hNl.getFirstVisiblePosition() == 0) {
                    this.hOQ.setVisibility(8);
                    this.hNh.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hOV) {
                        this.hOU = top;
                        this.hOV = false;
                    }
                    this.hOU = top < this.hOU ? top : this.hOU;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hNZ.getY() < 0.0f) {
                        measuredHeight = hOT - alVar.hMF.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hNh.bVN().getMeasuredHeight() - alVar.hMF.getMeasuredHeight();
                        this.hNh.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hOU) {
                        this.hOQ.setVisibility(0);
                        bVo();
                    } else if (top < measuredHeight) {
                        this.hOQ.setVisibility(0);
                        bVo();
                    } else {
                        this.hOQ.setVisibility(8);
                        this.hNh.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hOV = true;
                    }
                }
            }
        }
    }

    public void bVf() {
        if (!this.hPR) {
            TiebaStatic.log("c10490");
            this.hPR = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGq.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hPa, Integer.valueOf(hPc));
            aVar.hn(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hGq.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aF(inflate);
            aVar.ab(sparseArray);
            aVar.a(R.string.grade_button_tips, this.hGq);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hGq.getPageContext()).afG();
        }
    }

    public void Bp(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGq.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hGq.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aF(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hPa, Integer.valueOf(hPd));
        aVar.ab(sparseArray);
        aVar.a(R.string.view, this.hGq);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hGq.getPageContext()).afG();
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

    public PbInterviewStatusView bVg() {
        return this.hOM;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPM() != null && dVar.bPM().aev() && this.hOM == null) {
            this.hOM = (PbInterviewStatusView) this.hOL.inflate();
            this.hOM.setOnClickListener(this.fra);
            this.hOM.setCallback(this.hGq.bRP());
            this.hOM.setData(this.hGq, dVar);
        }
    }

    public LinearLayout bVh() {
        return this.hNZ;
    }

    public View bVi() {
        return this.frn;
    }

    public boolean bVj() {
        return this.hPC;
    }

    public void nX(boolean z) {
        this.hNy.nX(z);
    }

    public void Bq(String str) {
        if (this.hNi != null) {
            this.hNi.setTitle(str);
        }
    }

    private int oM(boolean z) {
        if (this.hOM == null || this.hOM.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.g(this.hGq.getPageContext().getPageActivity(), R.dimen.ds72);
    }

    private void bVk() {
        if (this.hOM != null && this.hOM.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hOM.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hOM.setLayoutParams(layoutParams);
        }
    }

    public boolean bRj() {
        return false;
    }

    public void Br(String str) {
        this.ggc.performClick();
        if (!StringUtils.isNull(str) && this.hGq.bRe() != null && this.hGq.bRe().ars() != null && this.hGq.bRe().ars().getInputView() != null) {
            EditText inputView = this.hGq.bRe().ars().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bUT();
            if (configuration.orientation == 2) {
                bVc();
                bUe();
            } else {
                bUh();
            }
            if (this.hPg != null) {
                this.hPg.bSw();
            }
            this.hGq.bki();
            this.hNZ.setVisibility(8);
            this.hNh.oW(false);
            this.hGq.od(false);
            if (this.hNb != null) {
                if (configuration.orientation == 1) {
                    bVh().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hNl.setIsLandscape(true);
                    this.hNl.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hNl.setIsLandscape(false);
                    if (this.hPQ > 0) {
                        this.hNl.smoothScrollBy(this.hPQ, 0);
                    }
                }
                this.hNb.onConfigurationChanged(configuration);
                this.hOP.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void oN(boolean z) {
        this.hNf = z;
    }

    public boolean bVl() {
        return this.hNb != null && this.hNb.bVl();
    }

    public void bVm() {
        if (this.hNb != null) {
            this.hNb.onPause();
        }
    }

    public void q(long j, int i) {
        if (this.hNd != null) {
            this.hNd.q(j, i);
        }
        if (this.hNb != null) {
            this.hNb.q(j, i);
        }
    }

    public void oi(boolean z) {
        this.hOa.oi(z);
    }

    public void bVn() {
        if (this.hON == null) {
            LayoutInflater.from(this.hGq.getActivity()).inflate(R.layout.add_experienced_text, (ViewGroup) this.epW, true);
            this.hON = (ViewGroup) this.epW.findViewById(R.id.add_experienced_layout);
            this.hOO = (TextView) this.epW.findViewById(R.id.add_experienced);
            com.baidu.tbadk.core.util.al.j(this.hOO, R.color.cp_btn_a);
            String string = this.hGq.getResources().getString(R.string.experienced_add_success);
            String string2 = this.hGq.getResources().getString(R.string.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_h)));
            this.hOO.setText(spannableString);
        }
        this.hON.setVisibility(0);
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
                        aq.this.hON.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hOO.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hOO.startAnimation(scaleAnimation);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hOz.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hGq);
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.hPr = new TextView(this.hGq);
            this.hPr.setText(R.string.connection_tips);
            this.hPr.setGravity(17);
            this.hPr.setPadding(com.baidu.adp.lib.util.l.g(this.hGq, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(this.hGq, R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hGq, R.dimen.ds60);
            if (this.hPr.getParent() == null) {
                frameLayout.addView(this.hPr, layoutParams);
            }
            this.hPq = new PopupWindow(this.hGq);
            this.hPq.setContentView(frameLayout);
            this.hPq.setHeight(-2);
            this.hPq.setWidth(-2);
            this.hPq.setFocusable(true);
            this.hPq.setOutsideTouchable(false);
            this.hPq.setBackgroundDrawable(new ColorDrawable(this.hGq.getResources().getColor(R.color.transparent)));
            this.hNl.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hPq.showAsDropDown(aq.this.hOz, view.getLeft(), -aq.this.hOz.getHeight());
                    } else {
                        aq.this.hPq.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bVo() {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_long_press_tips", false) && this.hPs == null) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_long_press_tips", true);
            this.hPs = new com.baidu.tbadk.core.dialog.a(this.hGq);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hGq);
            this.hPs.hr(1);
            this.hPs.aF(pbLongPressTipView);
            this.hPs.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hPs.dN(false);
            this.hPs.b(this.hGq.getPageContext()).afG();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hPs != null && aq.this.hPs.isShowing()) {
                        aq.this.hPs.dismiss();
                    }
                }
            }, 5000L);
            if (this.hNb != null) {
                this.hNb.bXh();
            }
        }
    }

    public void oO(boolean z) {
        this.hPx = z;
    }

    public boolean bVp() {
        return this.hPx;
    }

    public PbThreadPostView bVq() {
        return this.hNm;
    }

    private void Z(boolean z, boolean z2) {
        aa(z, z2);
        ab(z, z2);
        if (this.hOa != null && this.hOa.bSs() != null) {
            this.hOa.bSs().T(z, z2);
        }
    }

    private void aa(boolean z, boolean z2) {
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

    private void ab(boolean z, boolean z2) {
        if (this.hNt != null && this.hJL != null && this.hJL.bPM() != null && this.hJL.bPM().adK() == 0 && !this.hJL.bPM().aep()) {
            if (z && z2) {
                this.hNx.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.hNx.setVisibility(0);
            } else if (z) {
                this.hNx.setImageResource(R.drawable.pic_pb_refined_n);
                this.hNx.setVisibility(0);
            } else if (z2) {
                this.hNx.setImageResource(R.drawable.pic_pb_stick_n);
                this.hNx.setVisibility(0);
            } else {
                this.hNx.setVisibility(8);
            }
        }
    }
}
