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
    private static final int hOP = UtilHelper.getLightStatusBarHeight();
    public static int hOV = 3;
    public static int hOW = 0;
    public static int hOX = 3;
    public static int hOY = 4;
    public static int hOZ = 5;
    public static int hPa = 6;
    private static a.InterfaceC0407a hPx = new a.InterfaceC0407a() { // from class: com.baidu.tieba.pb.pb.main.aq.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0407a
        public void onRefresh() {
        }
    };
    private EditorTools TB;
    private TextView aif;
    private h.c bZA;
    private com.baidu.tieba.pb.a.c ckg;
    private View cxO;
    private NoNetworkView eRU;
    private int edg;
    private RelativeLayout epV;
    private View epY;
    private List<CustomBlueCheckRadioButton> ezU;
    private NavigationBarCoverTip fNs;
    private com.baidu.tieba.NEGFeedBack.e fQl;
    private View.OnClickListener fqZ;
    private View frm;
    private PbListView fvg;
    private TextView gfZ;
    PbActivity.d hFr;
    private View.OnClickListener hGL;
    private PbActivity hGm;
    private UserIconBox hHA;
    private UserIconBox hHz;
    private PbFakeFloorModel hIz;
    private com.baidu.tieba.pb.data.d hJH;
    public int hMW;
    public com.baidu.tieba.pb.video.i hMX;
    private long hMY;
    private com.baidu.tieba.pb.video.h hMZ;
    private HeadPendantView hNA;
    private FrameLayout hNB;
    private HeadImageView hNC;
    private View hND;
    private LinearLayout hNE;
    private PbFirstFloorUserLikeButton hNH;
    private ao hNI;
    private TextView hNJ;
    private TextView hNK;
    private TextView hNL;
    private TextView hNM;
    private View hNN;
    private View hNO;
    private LinearLayout hNP;
    private TextView hNQ;
    private TextView hNR;
    private View hNS;
    private View hNT;
    private ObservedChangeLinearLayout hNV;
    private f hNW;
    private com.baidu.tieba.c.d hNa;
    public final com.baidu.tieba.pb.pb.main.view.c hNd;
    public com.baidu.tieba.pb.pb.main.view.b hNe;
    private ViewStub hNf;
    private ViewStub hNg;
    private PbLandscapeListView hNh;
    private PbThreadPostView hNi;
    private View hNj;
    private RelativeLayout hNk;
    private HeadImageView hNl;
    private TextView hNm;
    private TextView hNn;
    private ImageView hNo;
    private RelativeLayout hNr;
    private ImageView hNs;
    private ImageView hNt;
    private e hNu;
    private ColumnLayout hNv;
    private ThreadSkinView hNw;
    private TextView hNx;
    private TextView hNy;
    private ImageView hNz;
    private int hOB;
    private int hOC;
    private PostData hOD;
    private View hOF;
    private TextView hOG;
    private ViewStub hOH;
    private PbInterviewStatusView hOI;
    private ViewGroup hOJ;
    private TextView hOK;
    private FrameLayout hOL;
    private View hOM;
    private View hON;
    private al hOO;
    private PbEmotionBar hOT;
    private View hOc;
    private View hOu;
    private View hOv;
    private ImageView hOw;
    private ImageView hOx;
    private ImageView hOy;
    private TextView hOz;
    private com.baidu.tbadk.core.view.userLike.c hPA;
    private Runnable hPF;
    private PbActivity.b hPH;
    public int hPM;
    private Runnable hPb;
    private s hPc;
    private an hPd;
    private int hPj;
    private PbTopTipView hPl;
    private PopupWindow hPm;
    private TextView hPn;
    private com.baidu.tbadk.core.dialog.a hPo;
    private List<String> hPp;
    private com.baidu.tieba.pb.pb.main.emotion.c hPq;
    private com.baidu.tieba.pb.pb.godreply.a hPr;
    private PbLandscapeListView.b hPs;
    private ac hPu;
    private String hPv;
    private boolean hPy;
    private com.baidu.tbadk.core.view.userLike.c hPz;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private boolean hNb = false;
    private int hNc = 0;
    private final Handler mHandler = new Handler();
    private RelativeLayout hNp = null;
    private TextView hNq = null;
    public FrsPraiseView hNF = null;
    private ClickableHeaderImageView hNG = null;
    private View hNU = null;
    private com.baidu.tbadk.core.dialog.a hNX = null;
    private com.baidu.tbadk.core.dialog.b fqY = null;
    private View hNY = null;
    private EditText hNZ = null;
    private com.baidu.tieba.pb.view.c hOa = null;
    private com.baidu.tieba.pb.view.a hOb = null;
    private com.baidu.tbadk.core.dialog.a hOd = null;
    private b.a gDG = null;
    private TbRichTextView.h cIM = null;
    private NoNetworkView.a fmu = null;
    private com.baidu.tbadk.core.dialog.i hOe = null;
    private View hOf = null;
    private com.baidu.tbadk.core.dialog.a hOg = null;
    private Dialog hOh = null;
    private Dialog hOi = null;
    private View hOj = null;
    private LinearLayout hOk = null;
    private CompoundButton.OnCheckedChangeListener ezV = null;
    private TextView hOl = null;
    private TextView hOm = null;
    private String hOn = null;
    private com.baidu.tbadk.core.dialog.i hEr = null;
    private com.baidu.tbadk.core.dialog.i hOo = null;
    private boolean hOp = false;
    private boolean hOq = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView hOr = null;
    private boolean hOs = false;
    private Button hOt = null;
    private boolean hOA = true;
    private com.baidu.tbadk.core.view.b eHv = null;
    private boolean hGD = false;
    private int mSkinType = 3;
    private boolean hOE = false;
    private int hOQ = 0;
    private boolean hOR = true;
    public a hOS = new a();
    private int hOU = 0;
    private boolean hPe = false;
    private int hPf = 0;
    private boolean hPg = false;
    private boolean hPh = false;
    private boolean hPi = false;
    private int hPk = 0;
    private boolean hPt = false;
    private int hPw = R.drawable.bg_user_identity_btn;
    private String hPB = null;
    private CustomMessageListener hPC = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.aq.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.hPB = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.hNW != null) {
                aq.this.hNW.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hPD = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.aq.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (aq.this.hNq != null) {
                aq.this.hNq.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler hPE = new Handler();
    private CustomMessageListener hPG = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.aq.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.hOA = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean hPI = true;
    View.OnClickListener hPJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.this.hPg) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").P(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (!aq.this.hPg && aq.this.hJH != null && aq.this.hJH.bPI() != null && aq.this.hJH.bPI().adv() != null && aq.this.hJH.bPI().adv().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").P("obj_locate", 1));
            }
            aq.this.hGm.hEm.fQU.onClick(view);
        }
    };
    private boolean hPK = false;
    String userId = null;
    private final List<TbImageView> hPL = new ArrayList();
    private boolean hPN = false;

    /* loaded from: classes4.dex */
    public static class a {
        public al hQc;
        public int headerCount;
        public int hwv;
    }

    public void oy(boolean z) {
        this.hPe = z;
        if (this.hNh != null) {
            this.hPf = this.hNh.getHeaderViewsCount();
        }
    }

    public void bTY() {
        if (this.hNh != null) {
            int headerViewsCount = this.hNh.getHeaderViewsCount() - this.hPf;
            final int firstVisiblePosition = (this.hNh.getFirstVisiblePosition() == 0 || this.hNh.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.hNh.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.hNh.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.hOS.hQc = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOS));
            final al alVar = this.hOS.hQc;
            final int h = h(alVar);
            final int y = ((int) this.hNV.getY()) + this.hNV.getMeasuredHeight();
            final boolean z = this.hOM.getVisibility() == 0;
            boolean z2 = this.hNV.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.hNW.bSj() + this.hNh.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.hMB.getMeasuredHeight() : 0;
                if (z2) {
                    this.hNh.setSelectionFromTop(this.hNW.bSj() + this.hNh.getHeaderViewsCount(), hOP - measuredHeight);
                } else {
                    this.hNh.setSelectionFromTop(this.hNW.bSj() + this.hNh.getHeaderViewsCount(), this.hNd.bVJ().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.hNh.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.hPg) {
                this.hNh.setSelectionFromTop(this.hNW.bSj() + this.hNh.getHeaderViewsCount(), this.hMX.aHP().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.hNh.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bSB() {
                        if (h >= 0 && h <= aq.this.epV.getMeasuredHeight()) {
                            int h2 = aq.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = aq.this.epY.getLayoutParams();
                            if (i == 0 || i > aq.this.epV.getMeasuredHeight() || h2 >= aq.this.epV.getMeasuredHeight()) {
                                layoutParams.height = aq.this.edg;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.epV.getMeasuredHeight()) {
                                layoutParams.height = aq.this.edg;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                aq.this.hNh.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            aq.this.epY.setLayoutParams(layoutParams);
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (aq.this.epY != null && aq.this.epY.getLayoutParams() != null) {
                                        ViewGroup.LayoutParams layoutParams2 = aq.this.epY.getLayoutParams();
                                        layoutParams2.height = aq.this.edg;
                                        aq.this.epY.setLayoutParams(layoutParams2);
                                    }
                                }
                            });
                        }
                        aq.this.hNh.setOnLayoutListener(null);
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

    public NoNetworkView bTZ() {
        return this.eRU;
    }

    public void bUa() {
        if (this.TB != null) {
            this.TB.hide();
            if (this.hPq != null) {
                this.hPq.aGK();
            }
        }
    }

    public PbFakeFloorModel bUb() {
        return this.hIz;
    }

    public s bUc() {
        return this.hPc;
    }

    public void bUd() {
        reset();
        bUa();
        this.hPc.bSs();
        oJ(false);
    }

    private void reset() {
        if (this.hGm != null && this.hGm.bRa() != null && this.TB != null) {
            com.baidu.tbadk.editortools.pb.a.arp().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bRa = this.hGm.bRa();
            bRa.arI();
            bRa.ard();
            if (bRa.getWriteImagesInfo() != null) {
                bRa.getWriteImagesInfo().setMaxImagesAllowed(9);
            }
            bRa.kp(SendView.ALL);
            bRa.kq(SendView.ALL);
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

    public boolean bUe() {
        return this.hOA;
    }

    public void oz(boolean z) {
        if (this.hOv != null && this.gfZ != null) {
            this.gfZ.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hOv.startAnimation(alphaAnimation);
            }
            this.hOu.setVisibility(0);
            this.hOv.setVisibility(0);
            this.hOA = true;
            if (this.hOT != null && !this.hPr.isActive()) {
                this.hOT.setVisibility(0);
                oD(true);
            }
        }
    }

    public void oA(boolean z) {
        if (this.hOv != null && this.gfZ != null) {
            this.gfZ.setText(bUf());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.hOv.startAnimation(alphaAnimation);
            }
            this.hOu.setVisibility(0);
            this.hOv.setVisibility(0);
            this.hOA = true;
            if (this.hOT != null && !this.hPr.isActive()) {
                this.hOT.setVisibility(0);
                oD(true);
            }
        }
    }

    public String bUf() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.hPv)) {
            return this.hPv;
        }
        if (this.hGm != null) {
            this.hPv = this.hGm.getResources().getString(ap.bTX());
        }
        return this.hPv;
    }

    public PostData bUg() {
        int i = 0;
        if (this.hNh == null) {
            return null;
        }
        int bUh = bUh() - this.hNh.getHeaderViewsCount();
        if (bUh < 0) {
            bUh = 0;
        }
        if (this.hNW.xj(bUh) != null && this.hNW.xj(bUh) != PostData.iYz) {
            i = bUh + 1;
        }
        return this.hNW.getItem(i) instanceof PostData ? (PostData) this.hNW.getItem(i) : null;
    }

    public int bUh() {
        int i;
        View childAt;
        if (this.hNh == null) {
            return 0;
        }
        int firstVisiblePosition = this.hNh.getFirstVisiblePosition();
        int lastVisiblePosition = this.hNh.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.hNh.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.hNh.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bUi() {
        return this.hNh.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.hJH != null && this.hJH.bPK() != null && !this.hJH.bPK().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.hJH.bPK().size() && (postData = this.hJH.bPK().get(i)) != null && postData.adv() != null && !StringUtils.isNull(postData.adv().getUserId()); i++) {
                if (this.hJH.bPK().get(i).adv().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.hPr != null && this.hPr.isActive()) {
                        oJ(false);
                    }
                    if (this.hOT != null) {
                        this.hOT.oR(true);
                    }
                    this.hPB = postData.adv().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.hGm = null;
        this.epV = null;
        this.frm = null;
        this.hMY = 0L;
        this.hNh = null;
        this.hNj = null;
        this.hNr = null;
        this.hNv = null;
        this.hNx = null;
        this.hNy = null;
        this.hNB = null;
        this.hNC = null;
        this.hND = null;
        this.hNH = null;
        this.hNJ = null;
        this.hNK = null;
        this.hNL = null;
        this.hNM = null;
        this.hNS = null;
        this.hNT = null;
        this.hNW = null;
        this.fvg = null;
        this.cxO = null;
        this.fqZ = null;
        this.hGL = null;
        this.hOv = null;
        this.gfZ = null;
        this.hOF = null;
        this.hOG = null;
        this.hOH = null;
        this.hPj = 0;
        this.hMY = System.currentTimeMillis();
        this.hGm = pbActivity;
        this.fqZ = onClickListener;
        this.ckg = cVar;
        this.hPj = com.baidu.adp.lib.util.l.af(this.hGm) / 2;
        this.epV = (RelativeLayout) LayoutInflater.from(this.hGm.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.hGm.addContentView(this.epV, new FrameLayout.LayoutParams(-1, -1));
        this.fNs = (NavigationBarCoverTip) this.hGm.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.frm = this.hGm.findViewById(R.id.statebar_view);
        this.hNV = (ObservedChangeLinearLayout) this.hGm.findViewById(R.id.title_wrapper);
        this.eRU = (NoNetworkView) this.hGm.findViewById(R.id.view_no_network);
        this.hNh = (PbLandscapeListView) this.hGm.findViewById(R.id.new_pb_list);
        this.hOL = (FrameLayout) this.hGm.findViewById(R.id.root_float_header);
        this.aif = new TextView(this.hGm.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.hGm.getActivity(), R.dimen.ds88));
        this.hNh.addHeaderView(this.aif, 0);
        this.edg = this.hGm.getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.epY = new View(this.hGm.getPageContext().getPageActivity());
        this.epY.setLayoutParams(new AbsListView.LayoutParams(-1, this.edg));
        this.epY.setVisibility(4);
        this.hNh.addFooterView(this.epY);
        this.hNh.setOnTouchListener(this.hGm.clb);
        this.hNd = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.hGm.bRD()) {
            this.hNf = (ViewStub) this.hGm.findViewById(R.id.manga_view_stub);
            this.hNf.setVisibility(0);
            this.hNe = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.hNe.show();
            this.hNd.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hGm.getActivity(), R.dimen.ds120);
        }
        this.aif.setLayoutParams(layoutParams);
        this.hNd.bVJ().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0367a() { // from class: com.baidu.tieba.pb.pb.main.aq.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0367a
            public void bQy() {
                if (aq.this.hNh != null) {
                    if (aq.this.hMX != null) {
                        aq.this.hMX.bXc();
                    }
                    aq.this.hNh.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0367a
            public void bQz() {
                aq.this.hGm.bkf();
            }
        }));
        this.hOu = this.hGm.findViewById(R.id.view_comment_top_line);
        this.hOv = this.hGm.findViewById(R.id.pb_editor_tool_comment);
        this.hOB = com.baidu.adp.lib.util.l.g(this.hGm.getPageContext().getPageActivity(), R.dimen.tbds120);
        this.hOC = com.baidu.adp.lib.util.l.g(this.hGm.getPageContext().getPageActivity(), R.dimen.ds242);
        this.gfZ = (TextView) this.hGm.getPageContext().getPageActivity().findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.gfZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.hGm.bRj();
                if (aq.this.hGm != null && aq.this.hGm.bQO() != null && aq.this.hGm.bQO().getPbData() != null && aq.this.hGm.bQO().getPbData().bPI() != null && aq.this.hGm.bQO().getPbData().bPI().adv() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", aq.this.hGm.bQO().hJl).bT("fid", aq.this.hGm.bQO().getPbData().getForumId()).P("obj_locate", 1).bT("uid", aq.this.hGm.bQO().getPbData().bPI().adv().getUserId()));
                }
            }
        });
        this.hOw = (ImageView) this.hGm.findViewById(R.id.pb_editor_tool_comment_icon);
        this.hOw.setOnClickListener(this.fqZ);
        this.hOx = (ImageView) this.hGm.findViewById(R.id.pb_editor_tool_collection);
        this.hOx.setOnClickListener(this.fqZ);
        this.hOy = (ImageView) this.hGm.findViewById(R.id.pb_editor_tool_share);
        this.hOy.setOnClickListener(this.fqZ);
        this.hOz = (TextView) this.hGm.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.hNj = LayoutInflater.from(this.hGm.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.hNr = (RelativeLayout) LayoutInflater.from(this.hGm.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.hNs = (ImageView) this.hNr.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.hNu = new e(this.hGm, this.hNr);
        this.hNu.init();
        this.hNu.a(this.hNu.bQZ(), this.fqZ);
        this.hNv = (ColumnLayout) this.hNr.findViewById(R.id.pb_head_owner_root);
        this.hNw = (ThreadSkinView) this.hNr.findViewById(R.id.pb_thread_skin);
        this.hNv.setOnLongClickListener(this.onLongClickListener);
        this.hNv.setOnTouchListener(this.ckg);
        this.hNv.setVisibility(8);
        this.hNj.setOnTouchListener(this.ckg);
        this.hOF = this.hNj.findViewById(R.id.pb_head_activity_join_number_container);
        this.hOF.setVisibility(8);
        this.hOG = (TextView) this.hNj.findViewById(R.id.pb_head_activity_join_number);
        this.hNx = (TextView) this.hNv.findViewById(R.id.pb_head_owner_info_user_name);
        this.hNx.getPaint().setFakeBoldText(true);
        this.hNy = (TextView) this.hNv.findViewById(R.id.floor_owner);
        this.hNz = (ImageView) this.hNv.findViewById(R.id.icon_forum_level);
        this.hNB = (FrameLayout) this.hNv.findViewById(R.id.pb_head_headImage_container);
        this.hNC = (HeadImageView) this.hNv.findViewById(R.id.pb_head_owner_photo);
        this.hNA = (HeadPendantView) this.hNv.findViewById(R.id.pb_pendant_head_owner_photo);
        this.hNA.setHasPendantStyle();
        if (this.hNA.getHeadView() != null) {
            this.hNA.getHeadView().setIsRound(true);
            this.hNA.getHeadView().setDrawBorder(false);
        }
        this.hHz = (UserIconBox) this.hNv.findViewById(R.id.show_icon_vip);
        this.hHA = (UserIconBox) this.hNv.findViewById(R.id.show_icon_yinji);
        this.hNE = (LinearLayout) this.hNr.findViewById(R.id.pb_head_owner_info_root);
        this.hNH = (PbFirstFloorUserLikeButton) this.hNv.findViewById(R.id.pb_like_button);
        this.hNJ = (TextView) this.hNv.findViewById(R.id.pb_views);
        this.hNK = (TextView) this.hNv.findViewById(R.id.pb_item_first_floor_reply_time);
        this.hNL = (TextView) this.hNv.findViewById(R.id.pb_item_first_floor_location_address);
        this.hNM = (TextView) this.hNv.findViewById(R.id.point_between_time_and_locate);
        this.hPz = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hPA = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.hNS = this.hNj.findViewById(R.id.new_pb_header_item_line_above_livepost);
        this.hNT = this.hNj.findViewById(R.id.new_pb_header_item_line_below_livepost);
        this.hNj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.33
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.hOH = (ViewStub) this.epV.findViewById(R.id.interview_status_stub);
        this.hNN = this.hNr.findViewById(R.id.blank_view_align_user_item_top);
        this.hNO = this.hNr.findViewById(R.id.blank_view_align_user_item_bottom);
        this.hNW = new f(this.hGm, this.hNh);
        this.hNW.z(this.fqZ);
        this.hNW.setTbGestureDetector(this.ckg);
        this.hNW.setOnImageClickListener(this.cIM);
        this.hGL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.34
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
                            aq.this.hGm.c(sparseArray);
                            return;
                        }
                        aq.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.hGm.c(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.hNW.L(this.hGL);
        bUn();
        bUo();
        this.hNh.addHeaderView(this.hNr);
        this.hNh.addHeaderView(this.hNp);
        this.hNh.addHeaderView(this.hNj);
        this.fvg = new PbListView(this.hGm.getPageContext().getPageActivity());
        this.cxO = this.fvg.getView().findViewById(R.id.pb_more_view);
        if (this.cxO != null) {
            this.cxO.setOnClickListener(this.fqZ);
            com.baidu.tbadk.core.util.al.k(this.cxO, R.drawable.pb_foot_more_trans_selector);
        }
        this.fvg.aju();
        this.fvg.iM(R.drawable.pb_foot_more_trans_selector);
        this.fvg.iO(R.drawable.pb_foot_more_trans_selector);
        this.hOc = this.hGm.findViewById(R.id.viewstub_progress);
        this.hGm.registerListener(this.hPG);
        this.hND = com.baidu.tbadk.ala.b.Zl().n(this.hGm.getActivity(), 2);
        if (this.hND != null) {
            this.hND.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.hGm.getResources().getDimensionPixelSize(R.dimen.ds10);
            if (this.hND.getParent() == null) {
                this.hNE.addView(this.hND, aVar);
            }
        }
        this.hIz = new PbFakeFloorModel(this.hGm.getPageContext());
        this.hPc = new s(this.hGm.getPageContext(), this.hIz, this.epV);
        this.hPc.a(this.hGm.hFm);
        this.hIz.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.35
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                aq.this.hIz.o(postData);
                aq.this.hNW.notifyDataSetChanged();
                aq.this.hPc.bSs();
                aq.this.TB.app();
                aq.this.oJ(false);
            }
        });
        if (this.hGm.bQO() != null && !StringUtils.isNull(this.hGm.bQO().bTm())) {
            this.hGm.showToast(this.hGm.bQO().bTm());
        }
        this.hOM = this.hGm.findViewById(R.id.pb_expand_blank_view);
        this.hON = this.hGm.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hON.getLayoutParams();
        if (this.hGm.bQO() != null && this.hGm.bQO().bSI()) {
            this.hOM.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.hON.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = hOP;
            this.hON.setLayoutParams(layoutParams2);
        }
        this.hOO = new al(this.hGm.getPageContext(), this.hGm.findViewById(R.id.pb_reply_expand_view));
        this.hOO.hMB.setVisibility(8);
        this.hOO.N(this.fqZ);
        this.hGm.registerListener(this.mAccountChangedListener);
        this.hGm.registerListener(this.hPC);
        this.hGm.registerListener(this.hPD);
        bUj();
        oD(false);
    }

    public void buL() {
        if (!this.hGm.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").P("obj_locate", 2).bT("fid", this.mForumId));
        } else if (this.hGm.bRl()) {
            com.baidu.tbadk.editortools.pb.d bRa = this.hGm.bRa();
            if (bRa != null && (bRa.arF() || bRa.arG())) {
                this.hGm.bRa().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.TB != null) {
                bUt();
            }
            if (this.TB != null) {
                this.hOA = false;
                if (this.TB.kj(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.hGm, (View) this.TB.kj(2).cqE, false, hPx);
                }
            }
            bUY();
        }
    }

    private void bUj() {
        this.hPr = new com.baidu.tieba.pb.pb.godreply.a(this.hGm, this, (ViewStub) this.epV.findViewById(R.id.more_god_reply_popup));
        this.hPr.v(this.fqZ);
        this.hPr.L(this.hGL);
        this.hPr.setOnImageClickListener(this.cIM);
        this.hPr.v(this.fqZ);
        this.hPr.setTbGestureDetector(this.ckg);
    }

    public com.baidu.tieba.pb.pb.godreply.a bUk() {
        return this.hPr;
    }

    public View bUl() {
        return this.hOM;
    }

    public void bUm() {
        if (this.hNh != null) {
            this.hNh.removeHeaderView(this.hNp);
            this.hNh.removeHeaderView(this.hNr);
            this.hNh.removeHeaderView(this.hNk);
            this.hNh.removeHeaderView(this.hNj);
        }
    }

    private void bUn() {
        if (this.hNk == null) {
            this.hNk = (RelativeLayout) LayoutInflater.from(this.hGm).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.hNl = (HeadImageView) this.hNk.findViewById(R.id.iv_pb_video_smart_app_head);
            this.hNl.setIsRound(true);
            this.hNm = (TextView) this.hNk.findViewById(R.id.tv_pb_video_smart_app_title);
            this.hNn = (TextView) this.hNk.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.hNo = (ImageView) this.hNk.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.hNk.setOnClickListener(this.fqZ);
        }
    }

    private void bUo() {
        if (this.hNp == null) {
            this.hNp = (RelativeLayout) LayoutInflater.from(this.hGm).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.hNt = (ImageView) this.hNp.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.hNt.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
            this.hNt.setImageMatrix(matrix);
            this.hNq = (TextView) this.hNp.findViewById(R.id.tv_pb_title);
            this.hNq.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            this.hNq.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.hNq.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.al.j(this.hNq, R.color.cp_cont_b);
            this.hNq.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.hNq.setVisibility(8);
            if (this.hNq.getParent() == null) {
                this.hNp.addView(this.hNq);
            }
            this.hNp.setOnTouchListener(this.ckg);
            this.hNp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUp() {
        if (this.hGm.bRD()) {
            this.hNg = (ViewStub) this.hGm.findViewById(R.id.manga_mention_controller_view_stub);
            this.hNg.setVisibility(0);
            if (this.hNP == null) {
                this.hNP = (LinearLayout) this.hGm.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.s.a.a(this.hGm.getPageContext(), this.hNP);
            }
            if (this.hNQ == null) {
                this.hNQ = (TextView) this.hNP.findViewById(R.id.manga_prev_btn);
            }
            if (this.hNR == null) {
                this.hNR = (TextView) this.hNP.findViewById(R.id.manga_next_btn);
            }
            this.hNQ.setOnClickListener(this.fqZ);
            this.hNR.setOnClickListener(this.fqZ);
        }
    }

    private void bUq() {
        if (this.hGm.bRD()) {
            if (this.hGm.bRG() == -1) {
                com.baidu.tbadk.core.util.al.f(this.hNQ, R.color.cp_cont_e, 1);
            }
            if (this.hGm.bRH() == -1) {
                com.baidu.tbadk.core.util.al.f(this.hNR, R.color.cp_cont_e, 1);
            }
        }
    }

    public void bUr() {
        if (this.hNP == null) {
            bUp();
        }
        this.hNg.setVisibility(8);
        if (this.hPE != null && this.hPF != null) {
            this.hPE.removeCallbacks(this.hPF);
        }
    }

    public void bUs() {
        if (this.hPE != null) {
            if (this.hPF != null) {
                this.hPE.removeCallbacks(this.hPF);
            }
            this.hPF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hNP == null) {
                        aq.this.bUp();
                    }
                    aq.this.hNg.setVisibility(0);
                }
            };
            this.hPE.postDelayed(this.hPF, 2000L);
        }
    }

    public void oB(boolean z) {
        this.hNd.oB(z);
        if (z && this.hOE) {
            this.fvg.setText(this.hGm.getResources().getString(R.string.click_load_more));
            this.hNh.setNextPage(this.fvg);
            this.hNc = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
        this.TB.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.TB.getParent() == null) {
            this.epV.addView(this.TB, layoutParams);
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
                        aq.this.mPermissionJudgePolicy.e(aq.this.hGm, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.aa(aq.this.hGm)) {
                            aq.this.hGm.bRa().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.hGm.bRa().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        bUa();
        this.hGm.bRa().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.TB != null && aq.this.TB.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.hPq == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.TB.getId());
                            aq.this.hPq = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.hGm.getPageContext(), aq.this.epV, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.aa(aq.this.hPp)) {
                                aq.this.hPq.setData(aq.this.hPp);
                            }
                            aq.this.hPq.b(aq.this.TB);
                        }
                        aq.this.hPq.Bt(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.hGm.hEq != null && aq.this.hGm.hEq.bVp() != null) {
                    if (!aq.this.hGm.hEq.bVp().cwf()) {
                        aq.this.hGm.hEq.oO(false);
                    }
                    aq.this.hGm.hEq.bVp().rK(false);
                }
            }
        });
    }

    public void bUt() {
        if (this.hGm != null && this.TB != null) {
            this.TB.pO();
            if (this.hGm.bRa() != null) {
                this.hGm.bRa().arw();
            }
            bUY();
        }
    }

    public void oC(boolean z) {
        if (this.hNh != null && this.aif != null && this.frm != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.frm.setVisibility(0);
                } else {
                    this.frm.setVisibility(8);
                    this.hNh.removeHeaderView(this.aif);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aif.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = hOP;
                    this.aif.setLayoutParams(layoutParams);
                }
                bUH();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aif.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + oL(true);
                this.aif.setLayoutParams(layoutParams2);
            }
            bUH();
            bVg();
        }
    }

    public f bUu() {
        return this.hNW;
    }

    public void a(PbActivity.d dVar) {
        this.hFr = dVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGm);
        kVar.setTitleText(this.hGm.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOe.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.hPH != null) {
                                aq.this.hPH.m(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.hGm.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hGm.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.hGm.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !bVf()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.hGm.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hGm.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.hGm.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.W(arrayList);
        if (this.hOe == null) {
            this.hOe = new com.baidu.tbadk.core.dialog.i(this.hGm.getPageContext(), kVar.afZ());
        } else {
            this.hOe.setContentView(kVar.afZ());
        }
        this.hOe.showDialog();
    }

    public void a(PbActivity.b bVar) {
        this.hPH = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.hGm != null && aVar != null) {
            if (this.fQl == null) {
                this.fQl = new com.baidu.tieba.NEGFeedBack.e(this.hGm.getPageContext(), this.hNj);
            }
            AntiData biW = this.hGm.biW();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (biW != null && biW.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biW.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            ajVar.b(sparseArray);
            this.fQl.setDefaultReasonArray(new String[]{this.hGm.getString(R.string.delete_thread_reason_1), this.hGm.getString(R.string.delete_thread_reason_2), this.hGm.getString(R.string.delete_thread_reason_3), this.hGm.getString(R.string.delete_thread_reason_4), this.hGm.getString(R.string.delete_thread_reason_5)});
            this.fQl.setData(ajVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.fQl.rs(str);
            this.fQl.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    aq.this.hGm.a(aVar, jSONArray);
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
        sparseArray.put(hOW, Integer.valueOf(hOX));
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
        this.hOg = new com.baidu.tbadk.core.dialog.a(this.hGm.getActivity());
        if (StringUtils.isNull(str2)) {
            this.hOg.ho(i3);
        } else {
            this.hOg.dR(false);
            this.hOg.mE(str2);
        }
        this.hOg.ab(sparseArray);
        this.hOg.a(R.string.dialog_ok, this.hGm);
        this.hOg.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hOg.dM(true);
        this.hOg.b(this.hGm.getPageContext());
        if (z) {
            this.hOg.afG();
        } else {
            a(this.hOg, i);
        }
    }

    public void ax(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.hOj == null) {
            this.hOj = LayoutInflater.from(this.hGm.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.hGm.getLayoutMode().onModeChanged(this.hOj);
        if (this.hOi == null) {
            this.hOi = new Dialog(this.hGm.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hOi.setCanceledOnTouchOutside(true);
            this.hOi.setCancelable(true);
            this.hOr = (ScrollView) this.hOj.findViewById(R.id.good_scroll);
            this.hOi.setContentView(this.hOj);
            WindowManager.LayoutParams attributes = this.hOi.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.hGm.getPageContext().getPageActivity(), R.dimen.ds540);
            this.hOi.getWindow().setAttributes(attributes);
            this.ezV = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.hOn = (String) compoundButton.getTag();
                        if (aq.this.ezU != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.ezU) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.hOn != null && !str.equals(aq.this.hOn)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.hOk = (LinearLayout) this.hOj.findViewById(R.id.good_class_group);
            this.hOm = (TextView) this.hOj.findViewById(R.id.dialog_button_cancel);
            this.hOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.hOi instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(aq.this.hOi, aq.this.hGm.getPageContext());
                    }
                }
            });
            this.hOl = (TextView) this.hOj.findViewById(R.id.dialog_button_ok);
            this.hOl.setOnClickListener(this.fqZ);
        }
        this.hOk.removeAllViews();
        this.ezU = new ArrayList();
        CustomBlueCheckRadioButton dM = dM("0", this.hGm.getPageContext().getString(R.string.thread_good_class));
        this.ezU.add(dM);
        dM.setChecked(true);
        this.hOk.addView(dM);
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
                    this.ezU.add(dM2);
                    View view = new View(this.hGm.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.hGm.getPageContext().getPageActivity(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.al.l(view, R.color.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.hOk.addView(view);
                    this.hOk.addView(dM2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.hOr.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGm.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGm.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.hGm.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.hOr.setLayoutParams(layoutParams2);
            this.hOr.removeAllViews();
            if (this.hOk != null && this.hOk.getParent() == null) {
                this.hOr.addView(this.hOk);
            }
        }
        com.baidu.adp.lib.g.g.a(this.hOi, this.hGm.getPageContext());
    }

    private CustomBlueCheckRadioButton dM(String str, String str2) {
        Activity pageActivity = this.hGm.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ezV);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bUv() {
        this.hGm.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.hGm.hideProgressBar();
        if (z && z2) {
            this.hGm.showToast(this.hGm.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.hGm.showToast(str);
        }
    }

    public void bBX() {
        this.hOc.setVisibility(0);
    }

    public void bBW() {
        this.hOc.setVisibility(8);
    }

    public View bUw() {
        if (this.hOj != null) {
            return this.hOj.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String bUx() {
        return this.hOn;
    }

    public View getView() {
        return this.epV;
    }

    public void bUy() {
        com.baidu.adp.lib.util.l.b(this.hGm.getPageContext().getPageActivity(), this.hGm.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.hGm.hideProgressBar();
        if (z) {
            bUP();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bUQ();
        } else {
            bUP();
        }
    }

    public void bUz() {
        this.fvg.aju();
        this.fvg.ajy();
    }

    public void bUA() {
        this.hGm.hideProgressBar();
        ajz();
        this.hNh.completePullRefreshPostDelayed(0L);
        bUL();
    }

    public void bUB() {
        this.hNh.completePullRefreshPostDelayed(0L);
        bUL();
    }

    private void oD(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.hNW.setOnLongClickListener(onLongClickListener);
        if (this.hPr != null) {
            this.hPr.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.hEr != null) {
            this.hEr.dismiss();
            this.hEr = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGm);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hGm.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGm.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGm.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGm.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOo.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hOo = new com.baidu.tbadk.core.dialog.i(this.hGm.getPageContext(), kVar.afZ());
        this.hOo.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.hOo != null) {
            this.hOo.dismiss();
            this.hOo = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.hGm);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.hGm.getPageContext().getString(R.string.save_to_emotion), kVar));
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.hGm.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.W(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.hOo.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.hOo = new com.baidu.tbadk.core.dialog.i(this.hGm.getPageContext(), kVar.afZ());
        this.hOo.showDialog();
    }

    public int bUC() {
        return xA(this.hNh.getFirstVisiblePosition());
    }

    private int xA(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.hNh.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.hNh.getAdapter() == null || !(this.hNh.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.hNh.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bUD() {
        int lastVisiblePosition = this.hNh.getLastVisiblePosition();
        if (this.hMX != null) {
            if (lastVisiblePosition == this.hNh.getCount() - 1) {
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
        if (this.hNh != null) {
            if (this.hNd == null || this.hNd.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.hNd.mNavigationBar.getFixedNavHeight();
                if (!(this.hGm.bRr() != -1)) {
                    if (this.hON != null && (layoutParams = (LinearLayout.LayoutParams) this.hON.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.hON.setLayoutParams(layoutParams);
                    }
                    i--;
                    bVk();
                }
                i2 = fixedNavHeight;
            }
            this.hNh.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.hNh.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.hNh.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.hNZ.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void m(com.baidu.tieba.pb.data.d dVar) {
        int i;
        this.hNW.a(dVar, false);
        this.hNW.notifyDataSetChanged();
        bUL();
        if (this.hPr != null) {
            this.hPr.bQK();
        }
        ArrayList<PostData> bPK = dVar.bPK();
        if (dVar.getPage().acp() == 0 || bPK == null || bPK.size() < dVar.getPage().aco()) {
            if (com.baidu.tbadk.core.util.v.Z(bPK) == 0 || (com.baidu.tbadk.core.util.v.Z(bPK) == 1 && bPK.get(0) != null && bPK.get(0).cmu() == 1)) {
                if (this.hOS == null || this.hOS.hQc == null || this.hOS.hQc.getView() == null) {
                    i = 0;
                } else {
                    i = this.hOS.hQc.getView().getTop() < 0 ? this.hOS.hQc.getView().getHeight() : this.hOS.hQc.getView().getBottom();
                }
                if (this.hGm.bRP()) {
                    this.fvg.W(this.hGm.getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.fvg.W(this.hGm.getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (dVar.getPage().acp() == 0) {
                    this.fvg.setText(this.hGm.getResources().getString(R.string.list_has_no_more));
                } else {
                    this.fvg.setText(this.hGm.getResources().getString(R.string.load_more));
                }
                this.fvg.ajD();
            }
        }
        o(dVar);
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        if (this.hNF == null) {
            this.hGm.getLayoutMode().onModeChanged(((ViewStub) this.hNj.findViewById(R.id.praise_layout)).inflate());
            this.hNF = (FrsPraiseView) this.hNj.findViewById(R.id.pb_head_praise_view);
            this.hNF.setIsFromPb(true);
            this.hNU = this.hNj.findViewById(R.id.new_pb_header_item_line_above_praise);
            this.hNF.iW(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hNF != null) {
            boolean bUL = bUL();
            this.hNF.setVisibility(8);
            if (dVar != null && dVar.getPage() != null && dVar.getPage().acq() == 0 && this.hGD) {
                if (bUL) {
                    this.hNT.setVisibility(0);
                    return;
                } else {
                    this.hNT.setVisibility(8);
                    return;
                }
            }
            this.hNT.setVisibility(8);
        }
    }

    public PostData c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bPS() != null) {
            return dVar.bPS();
        }
        if (!com.baidu.tbadk.core.util.v.aa(dVar.bPK())) {
            Iterator<PostData> it = dVar.bPK().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cmu() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bPP();
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
        if (dVar == null || dVar.bPI() == null || dVar.bPI().adv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData adv = dVar.bPI().adv();
        String userId = adv.getUserId();
        HashMap<String, MetaData> userMap = dVar.bPI().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = adv;
        }
        postData.Ay(1);
        postData.setId(dVar.bPI().adL());
        postData.setTitle(dVar.bPI().getTitle());
        postData.setTime(dVar.bPI().getCreateTime());
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
        com.baidu.tbadk.data.f cmx;
        String portrait;
        String charSequence;
        if (dVar != null && dVar.bPI() != null) {
            PostData c = c(dVar, z);
            a(c, dVar);
            this.hNv.setVisibility(8);
            if (dVar.bPI() != null && dVar.bPI().aep() && dVar.bPI().adM() != null) {
                this.hPg = true;
                this.hNd.oY(this.hPg);
                this.hNd.mNavigationBar.hideBottomLine();
                if (this.hMX == null) {
                    this.hMX = new com.baidu.tieba.pb.video.i(this.hGm, this.hNd, dVar.bPI().adM(), this.hMY);
                    this.hMX.a(dVar.bPI().adM(), dVar.bPI(), dVar.getForumId());
                    this.hMX.startPlay();
                } else if (this.hNb) {
                    this.hMX.a(dVar.bPI().adM(), dVar.bPI(), dVar.getForumId());
                    this.hMX.startPlay();
                } else {
                    this.hMX.BF(dVar.getForumId());
                }
                com.baidu.tieba.pb.c.a.a(this.hGm.getUniqueId(), dVar, c, 1, 1);
                if (dVar.bPJ() != null && dVar.bPJ().size() >= 1) {
                    bg bgVar = dVar.bPJ().get(0);
                    this.hMX.aB(bgVar);
                    this.hMX.BG(bgVar.getTitle());
                }
                this.hMX.b(c, dVar.bPI(), dVar.bQf());
                this.hNb = false;
                this.hNh.removeHeaderView(this.hMX.bXe());
                this.hNh.addHeaderView(this.hMX.bXe(), 0);
                if (this.hMX.aHP() != null && this.hMX.aHP().getParent() == null) {
                    this.hOL.addView(this.hMX.aHP());
                }
                if (this.hMZ == null) {
                    this.hMZ = new com.baidu.tieba.pb.video.h(this.hGm);
                }
                this.hMZ.a(dVar.bPI().aeF(), dVar.bPI(), dVar.bQc());
                this.hNh.removeHeaderView(this.hMZ.bWR());
                this.hNh.addHeaderView(this.hMZ.bWR(), 1);
                if (dVar.bPI().aeF() != null) {
                    this.hNh.removeHeaderView(this.hMZ.bWS());
                    this.hNh.removeHeaderView(this.hNr);
                    this.hNh.addHeaderView(this.hMZ.bWS(), 2);
                } else {
                    if (this.hMZ.bWS() != null) {
                        this.hNh.removeHeaderView(this.hMZ.bWS());
                    }
                    this.hNh.removeHeaderView(this.hNr);
                    this.hNh.addHeaderView(this.hNr, 2);
                }
                if (this.hMX != null) {
                    this.hNd.oU(false);
                    this.hMX.xI(TbadkCoreApplication.getInst().getSkinType());
                }
                bUH();
            } else {
                this.hPg = false;
                this.hNd.oY(this.hPg);
                if (this.hMX != null) {
                    this.hNh.removeHeaderView(this.hMX.bXe());
                }
                if (this.hMZ != null) {
                    this.hMZ.b(this.hNh);
                }
            }
            if (this.hGm.bRd() != null) {
                this.hGm.bRd().oS(this.hPg);
            }
            if (this.hMX != null) {
                this.hMX.P(this.hPJ);
                bVk();
            }
            if (c != null) {
                this.hOD = c;
                this.hNv.setVisibility(0);
                if (this.hGm.bQE()) {
                    if (dVar.bPH() != null) {
                        this.mForumName = dVar.bPH().getForumName();
                        this.mForumId = dVar.bPH().getForumId();
                    }
                    if (this.mForumName == null && this.hGm.bQO() != null && this.hGm.bQO().bQF() != null) {
                        this.mForumName = this.hGm.bQO().bQF();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.hNv.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.hNv.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_clip_board, c);
                sparseArray.put(R.id.tag_is_subpb, false);
                if (dVar.bPI().aep() && dVar.bPI().aeh() != null) {
                    SmartApp aeh = dVar.bPI().aeh();
                    this.hNk.setVisibility(0);
                    this.hNh.removeHeaderView(this.hNk);
                    this.hNh.addHeaderView(this.hNk, 1);
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh.avatar)) {
                        this.hNl.startLoad(aeh.avatar, 10, false, false);
                    }
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh.name)) {
                        charSequence = aeh.name + " " + ((Object) this.hGm.getText(R.string.smart_app_suffix));
                    } else {
                        charSequence = this.hGm.getText(R.string.intelligent_smart_app).toString();
                    }
                    this.hNm.setText(charSequence);
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(aeh._abstract)) {
                        this.hNn.setText(aeh._abstract);
                    } else {
                        this.hNn.setText(this.hGm.getText(R.string.smart_app_default_abstract));
                    }
                    this.hNk.setTag(aeh);
                } else {
                    this.hNk.setVisibility(8);
                    this.hNh.removeHeaderView(this.hNk);
                }
                if (!this.hPy) {
                    this.hNp.setVisibility(0);
                }
                if (!dVar.bPI().aep() && this.hNq.getText() != null && this.hNq.getText().length() > 0) {
                    this.hNq.setVisibility(0);
                } else {
                    this.hNq.setVisibility(8);
                }
                n(dVar);
                ArrayList<com.baidu.tbadk.core.data.b> adG = dVar.bPI().adG();
                if (adG != null && adG.size() > 0 && !this.hPy) {
                    this.hOG.setText(String.valueOf(adG.get(0).abC()));
                    this.hOF.setVisibility(0);
                } else {
                    this.hOF.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.k(this.hOF, R.drawable.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.f(this.hOG, R.color.cp_link_tip_d, 1);
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
                            if (this.hHA != null) {
                                this.hHA.setTag(R.id.tag_user_id, c.adv().getUserId());
                                this.hHA.setOnClickListener(this.hGm.hEm.hRC);
                                this.hHA.a(iconInfo, 4, this.hGm.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGm.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGm.getResources().getDimensionPixelSize(R.dimen.tbds12));
                            }
                            if (this.hHz != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.hHz.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.hHz.setOnClickListener(this.hGm.hEm.hRD);
                                this.hHz.a(tShowInfoNew, 3, this.hGm.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGm.getResources().getDimensionPixelSize(R.dimen.tbds36), this.hGm.getResources().getDimensionPixelSize(R.dimen.ds12), true);
                            }
                            this.hNx.setText(bX(c.adv().getSealPrefix(), j));
                            this.hNx.setTag(R.id.tag_user_id, c.adv().getUserId());
                            this.hNx.setTag(R.id.tag_user_name, c.adv().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew) || c.adv().isBigV()) {
                                com.baidu.tbadk.core.util.al.f(this.hNx, R.color.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.f(this.hNx, R.color.cp_cont_b, 1);
                            }
                            if (c.adv() == null) {
                                MetaData adv = c.adv();
                                if (adv.getIs_bawu() == 1 && "manager".equals(adv.getBawu_type())) {
                                    this.hNy.setText(R.string.bawu_member_bazhu_tip);
                                    this.hNy.setVisibility(0);
                                    this.hPw = R.drawable.author_bazhu_bg;
                                    com.baidu.tbadk.core.util.al.k(this.hNy, this.hPw);
                                } else if (adv.getIs_bawu() == 1 && "assist".equals(adv.getBawu_type())) {
                                    this.hNy.setText(R.string.bawu_member_xbazhu_tip);
                                    this.hNy.setVisibility(0);
                                    this.hPw = R.drawable.author_small_bazhu;
                                    com.baidu.tbadk.core.util.al.k(this.hNy, this.hPw);
                                } else {
                                    this.hNy.setVisibility(8);
                                }
                            } else {
                                this.hNy.setVisibility(8);
                            }
                            if (dVar.bPI().adv() != null && dVar.bPI().adv().getAlaUserData() != null && this.hND != null) {
                                if (dVar.bPI().adv().getAlaUserData().anchor_live != 0) {
                                    this.hND.setVisibility(8);
                                } else {
                                    this.hND.setVisibility(0);
                                    if (this.hNa == null) {
                                        this.hNa = new com.baidu.tieba.c.d(this.hGm.getPageContext(), this.hND);
                                        this.hNa.pM(1);
                                    }
                                    this.hNa.cH(this.hGm.getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.bzQ = dVar.bPI().adv().getAlaUserData();
                                    aVar.type = 2;
                                    this.hND.setTag(aVar);
                                }
                            }
                            this.hNC.setUserId(c.adv().getUserId());
                            this.hNC.setUserName(c.adv().getUserName());
                            this.hNC.setTid(c.getId());
                            this.hNC.setFid(this.hJH == null ? this.hJH.getForumId() : "");
                            this.hNC.setImageDrawable(null);
                            this.hNC.setRadius(com.baidu.adp.lib.util.l.g(this.hGm.getActivity(), R.dimen.ds40));
                            this.hNC.setTag(c.adv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                                this.hNK.setText(com.baidu.tbadk.core.util.ap.aE(c.getTime()));
                            } else {
                                this.hNK.setText(com.baidu.tbadk.core.util.ap.aC(c.getTime()));
                            }
                            cmx = c.cmx();
                            if (cmx == null && !TextUtils.isEmpty(cmx.getName()) && !TextUtils.isEmpty(cmx.getName().trim())) {
                                this.hNL.setVisibility(0);
                                this.hNM.setVisibility(0);
                                this.hNL.setText(cmx.getName());
                            } else {
                                this.hNL.setVisibility(8);
                                this.hNM.setVisibility(8);
                            }
                            portrait = c.adv().getPortrait();
                            if (c.adv().getPendantData() == null && !StringUtils.isNull(c.adv().getPendantData().abS())) {
                                this.hNA.b(c.adv());
                                this.hNC.setVisibility(8);
                                this.hNA.setVisibility(0);
                                if (this.hNG != null) {
                                    this.hNG.setVisibility(8);
                                }
                                this.hNx.setOnClickListener(this.hPJ);
                                this.hNA.getHeadView().startLoad(portrait, 28, false);
                                this.hNA.getHeadView().setUserId(c.adv().getUserId());
                                this.hNA.getHeadView().setUserName(c.adv().getUserName());
                                this.hNA.getHeadView().setTid(c.getId());
                                this.hNA.getHeadView().setFid(this.hJH != null ? this.hJH.getForumId() : "");
                                this.hNA.getHeadView().setOnClickListener(this.hPJ);
                                this.hNA.ox(c.adv().getPendantData().abS());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.hNC, c.adv());
                                this.hNC.setVisibility(0);
                                this.hNv.setOnClickListener(this.hPJ);
                                this.hNx.setOnClickListener(this.hPJ);
                                this.hNC.setOnClickListener(this.hPJ);
                                this.hNA.setVisibility(8);
                                this.hNC.startLoad(portrait, 28, false);
                            }
                            String name_show = c.adv().getName_show();
                            String userName = c.adv().getUserName();
                            if (com.baidu.tbadk.t.as.iE() && name_show != null && !name_show.equals(userName)) {
                                this.hNx.setText(com.baidu.tieba.pb.c.aD(this.hGm.getPageContext().getPageActivity(), this.hNx.getText().toString()));
                                this.hNx.setGravity(16);
                                this.hNx.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPr());
                                com.baidu.tbadk.core.util.al.f(this.hNx, R.color.cp_other_e, 1);
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo2 = c.adv().getIconInfo();
                        tShowInfoNew = c.adv().getTShowInfoNew();
                        if (this.hHA != null) {
                        }
                        if (this.hHz != null) {
                        }
                        this.hNx.setText(bX(c.adv().getSealPrefix(), j));
                        this.hNx.setTag(R.id.tag_user_id, c.adv().getUserId());
                        this.hNx.setTag(R.id.tag_user_name, c.adv().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.f(this.hNx, R.color.cp_cont_h, 1);
                        if (c.adv() == null) {
                        }
                        if (dVar.bPI().adv() != null) {
                            if (dVar.bPI().adv().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.hNC.setUserId(c.adv().getUserId());
                        this.hNC.setUserName(c.adv().getUserName());
                        this.hNC.setTid(c.getId());
                        this.hNC.setFid(this.hJH == null ? this.hJH.getForumId() : "");
                        this.hNC.setImageDrawable(null);
                        this.hNC.setRadius(com.baidu.adp.lib.util.l.g(this.hGm.getActivity(), R.dimen.ds40));
                        this.hNC.setTag(c.adv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cmx = c.cmx();
                        if (cmx == null) {
                        }
                        this.hNL.setVisibility(8);
                        this.hNM.setVisibility(8);
                        portrait = c.adv().getPortrait();
                        if (c.adv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hNC, c.adv());
                        this.hNC.setVisibility(0);
                        this.hNv.setOnClickListener(this.hPJ);
                        this.hNx.setOnClickListener(this.hPJ);
                        this.hNC.setOnClickListener(this.hPJ);
                        this.hNA.setVisibility(8);
                        this.hNC.startLoad(portrait, 28, false);
                        String name_show2 = c.adv().getName_show();
                        String userName2 = c.adv().getUserName();
                        if (com.baidu.tbadk.t.as.iE()) {
                            this.hNx.setText(com.baidu.tieba.pb.c.aD(this.hGm.getPageContext().getPageActivity(), this.hNx.getText().toString()));
                            this.hNx.setGravity(16);
                            this.hNx.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPr());
                            com.baidu.tbadk.core.util.al.f(this.hNx, R.color.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bj(string) > 14) {
                            j = com.baidu.tbadk.core.util.ap.j(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = c.adv().getIconInfo();
                            tShowInfoNew = c.adv().getTShowInfoNew();
                            if (this.hHA != null) {
                            }
                            if (this.hHz != null) {
                            }
                            this.hNx.setText(bX(c.adv().getSealPrefix(), j));
                            this.hNx.setTag(R.id.tag_user_id, c.adv().getUserId());
                            this.hNx.setTag(R.id.tag_user_name, c.adv().getName_show());
                            if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.f(this.hNx, R.color.cp_cont_h, 1);
                            if (c.adv() == null) {
                            }
                            if (dVar.bPI().adv() != null) {
                            }
                            this.hNC.setUserId(c.adv().getUserId());
                            this.hNC.setUserName(c.adv().getUserName());
                            this.hNC.setTid(c.getId());
                            this.hNC.setFid(this.hJH == null ? this.hJH.getForumId() : "");
                            this.hNC.setImageDrawable(null);
                            this.hNC.setRadius(com.baidu.adp.lib.util.l.g(this.hGm.getActivity(), R.dimen.ds40));
                            this.hNC.setTag(c.adv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                            }
                            cmx = c.cmx();
                            if (cmx == null) {
                            }
                            this.hNL.setVisibility(8);
                            this.hNM.setVisibility(8);
                            portrait = c.adv().getPortrait();
                            if (c.adv().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.hNC, c.adv());
                            this.hNC.setVisibility(0);
                            this.hNv.setOnClickListener(this.hPJ);
                            this.hNx.setOnClickListener(this.hPJ);
                            this.hNC.setOnClickListener(this.hPJ);
                            this.hNA.setVisibility(8);
                            this.hNC.startLoad(portrait, 28, false);
                            String name_show22 = c.adv().getName_show();
                            String userName22 = c.adv().getUserName();
                            if (com.baidu.tbadk.t.as.iE()) {
                            }
                        }
                        j = string;
                        ArrayList<IconData> iconInfo222 = c.adv().getIconInfo();
                        tShowInfoNew = c.adv().getTShowInfoNew();
                        if (this.hHA != null) {
                        }
                        if (this.hHz != null) {
                        }
                        this.hNx.setText(bX(c.adv().getSealPrefix(), j));
                        this.hNx.setTag(R.id.tag_user_id, c.adv().getUserId());
                        this.hNx.setTag(R.id.tag_user_name, c.adv().getName_show());
                        if (com.baidu.tbadk.core.util.v.aa(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.f(this.hNx, R.color.cp_cont_h, 1);
                        if (c.adv() == null) {
                        }
                        if (dVar.bPI().adv() != null) {
                        }
                        this.hNC.setUserId(c.adv().getUserId());
                        this.hNC.setUserName(c.adv().getUserName());
                        this.hNC.setTid(c.getId());
                        this.hNC.setFid(this.hJH == null ? this.hJH.getForumId() : "");
                        this.hNC.setImageDrawable(null);
                        this.hNC.setRadius(com.baidu.adp.lib.util.l.g(this.hGm.getActivity(), R.dimen.ds40));
                        this.hNC.setTag(c.adv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(c.getTime()), "yyyy"))) {
                        }
                        cmx = c.cmx();
                        if (cmx == null) {
                        }
                        this.hNL.setVisibility(8);
                        this.hNM.setVisibility(8);
                        portrait = c.adv().getPortrait();
                        if (c.adv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.hNC, c.adv());
                        this.hNC.setVisibility(0);
                        this.hNv.setOnClickListener(this.hPJ);
                        this.hNx.setOnClickListener(this.hPJ);
                        this.hNC.setOnClickListener(this.hPJ);
                        this.hNA.setVisibility(8);
                        this.hNC.startLoad(portrait, 28, false);
                        String name_show222 = c.adv().getName_show();
                        String userName222 = c.adv().getUserName();
                        if (com.baidu.tbadk.t.as.iE()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.hNu.at(dVar.bPI());
                }
                if (this.hOO != null) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBU);
                    if (dVar != null && dVar.bPI() != null) {
                        iVar.hBW = dVar.bPI().adm();
                    }
                    iVar.isNew = !this.hGD;
                    iVar.sortType = dVar.hBC;
                    if (dVar.hBB != null && dVar.hBB.size() > dVar.hBC) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.hBB.size()) {
                                break;
                            } else if (dVar.hBB.get(i4).sort_type.intValue() != dVar.hBC) {
                                i3 = i4 + 1;
                            } else {
                                iVar.hBY = dVar.hBB.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    iVar.hBZ = this.hGm.bRP();
                    this.hOO.a(iVar);
                }
                if (dVar != null && dVar.bPI() != null) {
                    aa(dVar.bPI().adr() == 1, dVar.bPI().adq() == 1);
                }
                com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.hNW != null && aq.this.hNd != null && aq.this.hNd.hSC != null && aq.this.hJH != null && aq.this.hJH.bPI() != null && !aq.this.hJH.bPI().aep() && !aq.this.bUK() && aq.this.hJH.getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(aq.this.hJH.getForum().getName())) {
                            if (aq.this.hNW.bSn() == null || !aq.this.hNW.bSn().isShown()) {
                                aq.this.hNd.hSC.setVisibility(0);
                                if (aq.this.hGm != null && aq.this.hGm.bQO() != null) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13400");
                                    amVar.bT("tid", aq.this.hGm.bQO().bSF());
                                    amVar.bT("fid", aq.this.hGm.bQO().getForumId());
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
            bUE();
        } else {
            bea();
        }
        this.hOS.hQc = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOS));
        a(this.hOS.hQc, false);
    }

    public void bUE() {
        if (this.hNd != null && !this.hPi) {
            this.hNd.oZ(!StringUtils.isNull(this.hGm.bRo()));
            this.hPi = true;
        }
    }

    public void bea() {
        if (this.hNd != null) {
            this.hNd.bVQ();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.adQ() != null) {
            this.hNw.setData(this.hGm.getPageContext(), dVar.bPK().get(0).adQ(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.getForum().getId(), dVar.getForum().getName(), dVar.bPI().getId(), this.hGm.bRM() ? "FRS" : null));
            this.hNv.setPadding(this.hNv.getPaddingLeft(), (int) this.hGm.getResources().getDimension(R.dimen.ds20), this.hNv.getPaddingRight(), this.hNv.getPaddingBottom());
            return;
        }
        this.hNw.setData(null, null, null);
    }

    public void bUF() {
        if (this.hMX != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").P("obj_type", 1));
            this.hMX.bXc();
            this.hNh.smoothScrollToPosition(0);
        }
    }

    public boolean bUG() {
        return this.hPK;
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
            this.hNd.bVO();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.hNd.zf(cVar.forumName);
            }
            String string = this.hGm.getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.f(cVar.source, 0)) {
                case 100:
                    str = this.hGm.getResources().getString(R.string.self);
                    break;
                case 300:
                    str = this.hGm.getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = this.hGm.getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.hAV;
            this.hGm.showNetRefreshView(this.epV, format, null, this.hGm.getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.ki()) {
                        ba.aiz().c(aq.this.hGm.getPageContext(), new String[]{str2});
                        aq.this.hGm.finish();
                        return;
                    }
                    aq.this.hGm.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable bTP;
        Parcelable bTP2;
        if (dVar != null) {
            this.hJH = dVar;
            this.mType = i;
            if (dVar.bPI() != null) {
                this.hOU = dVar.bPI().add();
                if (dVar.bPI().getAnchorLevel() != 0) {
                    this.hPK = true;
                }
                this.hOq = av(dVar.bPI());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.hOE = false;
            this.hGD = z;
            bUA();
            if (dVar.hBD != null && dVar.hBD.bQj()) {
                if (this.hNi == null) {
                    this.hNi = new PbThreadPostView(this.hGm);
                    this.hNh.addHeaderView(this.hNi, 1);
                    this.hNi.setData(dVar);
                    this.hNi.setChildOnClickLinstener(this.fqZ);
                }
            } else if (this.hNi != null && this.hNh != null) {
                this.hNh.removeHeaderView(this.hNi);
            }
            b(dVar, z, i);
            p(dVar);
            if (this.hPu == null) {
                this.hPu = new ac(this.hGm.getPageContext(), this.fNs);
            }
            this.hPu.Bk(dVar.bPN());
            if (this.hGm.bRD()) {
                if (this.hOa == null) {
                    this.hOa = new com.baidu.tieba.pb.view.c(this.hGm.getPageContext());
                    this.hOa.nG();
                    this.hOa.setListPullRefreshListener(this.bZA);
                }
                this.hNh.setPullRefresh(this.hOa);
                bUH();
                if (this.hOa != null) {
                    this.hOa.iP(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.getPage().acq() == 0 && z) {
                this.hNh.setPullRefresh(null);
            } else {
                if (this.hOa == null) {
                    this.hOa = new com.baidu.tieba.pb.view.c(this.hGm.getPageContext());
                    this.hOa.nG();
                    this.hOa.setListPullRefreshListener(this.bZA);
                }
                this.hNh.setPullRefresh(this.hOa);
                bUH();
                if (this.hOa != null) {
                    this.hOa.iP(TbadkCoreApplication.getInst().getSkinType());
                }
                aSD();
            }
            bUL();
            this.hNW.nS(this.hGD);
            this.hNW.nT(false);
            this.hNW.oe(i == 5);
            this.hNW.of(i == 6);
            this.hNW.og(z2 && this.hPI);
            this.hNW.a(dVar, false);
            this.hNW.notifyDataSetChanged();
            if (this.hGm.bQE()) {
                this.hPk = 0;
                PostData c = c(dVar, z);
                if (c != null && c.adv() != null) {
                    this.hPk = c.adv().getLevel_id();
                }
                if (this.hPk > 0) {
                    this.hNz.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.hNz, BitmapHelper.getGradeResourceIdInEnterForum(this.hPk));
                } else {
                    this.hNz.setVisibility(8);
                }
            } else {
                this.hNz.setVisibility(8);
            }
            if (dVar.bPI() != null && dVar.bPI().adh() != null) {
                if (dVar.bPI().adh().getNum() < 1) {
                    this.hGm.getResources().getString(R.string.zan);
                } else {
                    String str = dVar.bPI().adh().getNum() + "";
                }
                if (this.hMW != -1) {
                    dVar.bPI().adh().setIsLike(this.hMW);
                }
            }
            if (this.hGm.isLogin()) {
                this.hNh.setNextPage(this.fvg);
                this.hNc = 2;
                aSD();
            } else {
                this.hOE = true;
                if (dVar.getPage().acp() == 1) {
                    if (this.hOb == null) {
                        this.hOb = new com.baidu.tieba.pb.view.a(this.hGm.getPageContext());
                    }
                    this.hNh.setNextPage(this.hOb);
                } else {
                    this.hNh.setNextPage(this.fvg);
                }
                this.hNc = 3;
            }
            ArrayList<PostData> bPK = dVar.bPK();
            if (dVar.getPage().acp() == 0 || bPK == null || bPK.size() < dVar.getPage().aco()) {
                if (com.baidu.tbadk.core.util.v.Z(bPK) == 0 || (com.baidu.tbadk.core.util.v.Z(bPK) == 1 && bPK.get(0) != null && bPK.get(0).cmu() == 1)) {
                    if (this.hOS == null || this.hOS.hQc == null || this.hOS.hQc.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.hOS.hQc.getView().getTop() < 0 ? this.hOS.hQc.getView().getHeight() : this.hOS.hQc.getView().getBottom();
                    }
                    if (this.hGm.bRP()) {
                        this.fvg.W(this.hGm.getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.fvg.W(this.hGm.getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.hGm.bRd() != null && !this.hGm.bRd().bVD()) {
                        this.hGm.bRd().showFloatingView();
                    }
                } else {
                    if (dVar.getPage().acp() == 0) {
                        this.fvg.setText(this.hGm.getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.fvg.setText(this.hGm.getResources().getString(R.string.load_more));
                    }
                    this.fvg.ajD();
                }
                bUT();
            } else {
                if (z2) {
                    if (this.hPI) {
                        ajz();
                        if (dVar.getPage().acp() != 0) {
                            this.fvg.setText(this.hGm.getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.fvg.aju();
                        this.fvg.showLoading();
                    }
                } else {
                    this.fvg.aju();
                    this.fvg.showLoading();
                }
                this.fvg.ajD();
            }
            switch (i) {
                case 2:
                    this.hNh.setSelection(i2 > 1 ? (((this.hNh.getData() == null && dVar.bPK() == null) ? 0 : (this.hNh.getData().size() - dVar.bPK().size()) + this.hNh.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bTP2 = aj.bTO().bTP()) != null) {
                        this.hNh.onRestoreInstanceState(bTP2);
                        if (com.baidu.tbadk.core.util.v.Z(bPK) > 1 && dVar.getPage().acp() > 0) {
                            this.fvg.ajz();
                            this.fvg.setText(this.hGm.getString(R.string.pb_load_more_without_point));
                            this.fvg.ajv();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.hPI = false;
                    break;
                case 5:
                    this.hNh.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bTP = aj.bTO().bTP()) != null) {
                        this.hNh.onRestoreInstanceState(bTP);
                        break;
                    } else {
                        this.hNh.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.hMX != null && this.hMX.aHP() != null) {
                            if (this.hGm.isUseStyleImmersiveSticky()) {
                                this.hNh.setSelectionFromTop((this.hNW.bSi() + this.hNh.getHeaderViewsCount()) - 1, this.hMX.aHP().getHeight() - com.baidu.adp.lib.util.l.r(this.hGm.getPageContext().getPageActivity()));
                            } else {
                                this.hNh.setSelectionFromTop((this.hNW.bSi() + this.hNh.getHeaderViewsCount()) - 1, this.hMX.aHP().getHeight());
                            }
                        } else {
                            this.hNh.setSelection(this.hNW.bSi() + this.hNh.getHeaderViewsCount());
                        }
                    } else {
                        this.hNh.setSelection(i2 > 0 ? ((this.hNh.getData() == null && dVar.bPK() == null) ? 0 : (this.hNh.getData().size() - dVar.bPK().size()) + this.hNh.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.fvg.ajz();
                    this.fvg.setText(this.hGm.getString(R.string.pb_load_more_without_point));
                    this.fvg.ajv();
                    break;
            }
            if (this.hOU == hOV && isHost()) {
                bVb();
            }
            if (this.hPe) {
                bTY();
                this.hPe = false;
                if (i3 == 0) {
                    oy(true);
                }
            }
            if (this.hMZ != null) {
                this.hMZ.aA(dVar.bPI());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.hBz == 1 || dVar.hBA == 1) {
                if (this.hPl == null) {
                    this.hPl = new PbTopTipView(this.hGm);
                }
                if (dVar.hBA == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.hGm.getStType())) {
                    this.hPl.setText(this.hGm.getString(R.string.pb_read_strategy_add_experience));
                    this.hPl.show(this.epV, this.mSkinType);
                } else if (dVar.hBz == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.hGm.getStType())) {
                    this.hPl.setText(this.hGm.getString(R.string.pb_read_news_add_experience));
                    this.hPl.show(this.epV, this.mSkinType);
                }
            }
            o(dVar);
        }
    }

    private void o(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPI() != null) {
            if (dVar.ZC()) {
                com.baidu.tbadk.core.util.al.c(this.hOx, (int) R.drawable.icon_pb_bottom_collect_h);
            } else {
                com.baidu.tbadk.core.util.al.c(this.hOx, (int) R.drawable.icon_pb_bottom_collect_n);
            }
            this.hOz.setText(xC(dVar.bPI().adm()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, dVar.bPI()));
        }
    }

    private String xC(int i) {
        if (i == 0) {
            return this.hGm.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void bUH() {
        if (this.hMX != null && this.hMX.aHP() != null) {
            this.hNh.removeHeaderView(this.aif);
            if (this.mType != 1) {
                this.hNh.removeHeaderView(this.hMX.bXe());
                this.hNh.addHeaderView(this.hMX.bXe(), 0);
                return;
            }
            return;
        }
        if (this.hMX != null) {
            this.hNh.removeHeaderView(this.hMX.bXe());
        }
        this.hNh.removeHeaderView(this.aif);
        this.hNh.addHeaderView(this.aif, 0);
    }

    public void oF(boolean z) {
        this.hOp = z;
    }

    public void ajz() {
        if (this.fvg != null) {
            this.fvg.ajv();
            this.fvg.ajz();
        }
        aSD();
    }

    public void aUE() {
        this.hNh.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.hOD != null && this.hOD.adv() != null && this.hNd != null) {
            this.hPh = !this.hPg;
            this.hNd.oU(this.hPh);
            if (this.hGm.bRd() != null) {
                this.hGm.bRd().oT(this.hPh);
            }
            bUI();
            if (this.hGm != null && !this.hGm.bQE() && !com.baidu.tbadk.core.util.v.aa(dVar.bQd())) {
                bc bcVar = dVar.bQd().get(0);
                if (bcVar != null) {
                    this.hNd.dN(bcVar.getForumName(), bcVar.getAvatar());
                }
            } else if (dVar.getForum() != null) {
                this.hNd.dN(dVar.getForum().getName(), dVar.getForum().getImage_url());
            }
            if (this.hPh) {
                if (this.hOq) {
                    this.hNH.setVisibility(8);
                    this.hNJ.setVisibility(0);
                    this.hNJ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.ap.aI(dVar.bQe())));
                }
                if (this.hON != null) {
                    this.hON.setVisibility(8);
                }
                if (this.hPs == null) {
                    this.hPs = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > aq.this.hPj) {
                                aq.this.bVa();
                            }
                            aq.this.bUB();
                        }
                    };
                }
                this.hNh.setListViewDragListener(this.hPs);
                return;
            }
            if (this.hON != null) {
                this.hON.setVisibility(0);
            }
            if (this.hOq) {
                this.hNH.setVisibility(8);
                this.hNJ.setVisibility(0);
                this.hNJ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), com.baidu.tbadk.core.util.ap.aI(dVar.bQe())));
            } else if (!com.baidu.tbadk.t.au.auI() || (this.hOD.adv().hadConcerned() && this.hOD.adv().getGodUserData() != null && this.hOD.adv().getGodUserData().getIsFromNetWork())) {
                this.hNH.setVisibility(8);
                this.hNJ.setVisibility(8);
            } else {
                this.hNJ.setVisibility(8);
            }
            this.hPs = null;
            this.hNh.setListViewDragListener(null);
        }
    }

    private void bUI() {
        String threadId = this.hJH != null ? this.hJH.getThreadId() : "";
        int bUJ = bUJ();
        if (this.hPh && this.hOD != null && this.hOD.adv() != null) {
            this.hOD.adv().setIsLike(this.hOD.adv().hadConcerned());
        }
        if (this.hNI == null) {
            this.hNI = new ao(this.hGm.getPageContext(), this.hNH, 1);
            this.hNI.i(this.hGm.getUniqueId());
            this.hNI.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void es(boolean z) {
                    if (aq.this.hGm != null && z) {
                        com.baidu.adp.lib.util.l.showToast(aq.this.hGm, (int) R.string.attention_success);
                    }
                }
            });
        }
        if (this.hOD != null && this.hOD.adv() != null) {
            this.hOD.adv().setIsLike(this.hOD.adv().hadConcerned());
            this.hNI.a(this.hOD.adv());
            this.hNI.setTid(threadId);
        }
        this.hNI.hMS = this.hPg;
        this.hNI.xz(bUJ);
    }

    public int bUJ() {
        if (this.hJH == null || this.hJH.bPI() == null) {
            return 0;
        }
        if (this.hJH.bPI().aeN()) {
            return (com.baidu.tbadk.core.util.v.aa(this.hJH.bQd()) && (this.hJH.bPH() == null || StringUtils.isNull(this.hJH.bPH().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public boolean bUK() {
        return this.hJH == null || this.hJH.getForum() == null || "0".equals(this.hJH.getForum().getId()) || "me0407".equals(this.hJH.getForum().getName());
    }

    private boolean bUL() {
        boolean z;
        if (this.hOt != null && this.hOt.getVisibility() == 0) {
            if (this.hNS != null) {
                this.hNS.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.hNS != null) {
                this.hNS.setVisibility(8);
            }
            z = false;
        }
        if ((this.hNU == null || this.hNU.getVisibility() == 8) && z && this.hGD) {
            this.hNT.setVisibility(0);
        } else {
            this.hNT.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bPI() == null) {
            return false;
        }
        if (dVar.bPI().ads() == 1 || dVar.bPI().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bPI().adu() == null || dVar.bPI().adu().afv() == 0) || dVar.bPI().adq() == 1 || dVar.bPI().adr() == 1 || dVar.bPI().aeg() || dVar.bPI().aev() || dVar.bPI().aeo() || dVar.bPI().adH() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.bPI().getCategory()) || dVar.bPI().ady() || dVar.bPI().adx();
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return com.baidu.tieba.card.n.a((Context) this.hGm.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.hNp != null) {
                if (dVar.bPI() != null && dVar.bPI().adK() == 0 && !dVar.bPI().aep() && !this.hPy) {
                    this.hNp.setVisibility(0);
                    if (dVar.bPI() != null) {
                        bg bPI = dVar.bPI();
                        bPI.k(true, q(dVar));
                        bPI.setResource(3);
                        bPI.mo("2");
                    }
                    SpannableStringBuilder aeb = dVar.bPI().aeb();
                    this.hNq.setOnTouchListener(new com.baidu.tieba.view.k(aeb));
                    this.hNq.setText(aeb);
                    this.hNq.setVisibility(0);
                } else if (dVar.bPI().adK() == 1) {
                    if (dVar.bPI() != null) {
                        this.hNp.setVisibility(8);
                        this.hNh.removeHeaderView(this.hNp);
                    }
                } else {
                    this.hNp.setVisibility(8);
                    this.hNh.removeHeaderView(this.hNp);
                    if (dVar.bPI() != null && dVar.bPI().aep()) {
                        this.hNv.setPadding(this.hNv.getPaddingLeft(), 0, this.hNv.getPaddingRight(), this.hNv.getPaddingBottom());
                        if (this.hNN != null) {
                            ((RelativeLayout.LayoutParams) this.hNN.getLayoutParams()).height = (int) this.hGm.getResources().getDimension(R.dimen.tbds36);
                            this.hNN.requestLayout();
                        }
                        if (this.hNO != null) {
                            ((RelativeLayout.LayoutParams) this.hNO.getLayoutParams()).height = (int) this.hGm.getResources().getDimension(R.dimen.tbds0);
                            this.hNO.requestLayout();
                        }
                    } else {
                        this.hNv.setPadding(this.hNv.getPaddingLeft(), com.baidu.adp.lib.util.l.g(this.hGm.getPageContext().getPageActivity(), R.dimen.ds48), this.hNv.getPaddingRight(), this.hNv.getPaddingBottom());
                    }
                }
            }
            if (dVar.bPI() != null) {
                Z(dVar.bPI().adr() == 1, dVar.bPI().adq() == 1);
            }
            this.hGD = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void e(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            d(dVar, z);
            bUL();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bPU()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(dVar.bPU()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bc> bQd = dVar.bQd();
                if (com.baidu.tbadk.core.util.v.Z(bQd) > 0) {
                    sb = new StringBuilder();
                    for (bc bcVar : bQd) {
                        if (bcVar != null && !StringUtils.isNull(bcVar.getForumName()) && (vVar = bcVar.bHQ) != null && vVar.bFI && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.i(bcVar.getForumName(), 12)).append(this.hGm.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.hGm.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.cxO;
    }

    public boolean bUM() {
        if (this.epY == null || this.epY.getParent() == null || this.fvg.pu()) {
            return false;
        }
        int bottom = this.epY.getBottom();
        Rect rect = new Rect();
        this.epY.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Bl(String str) {
        if (this.fvg != null) {
            this.fvg.setText(str);
        }
    }

    public void Bm(String str) {
        if (this.fvg != null) {
            int i = 0;
            if (this.hOS != null && this.hOS.hQc != null && this.hOS.hQc.getView() != null) {
                i = this.hOS.hQc.getView().getTop() < 0 ? this.hOS.hQc.getView().getHeight() : this.hOS.hQc.getView().getBottom();
            }
            this.fvg.W(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.hNh;
    }

    public int bUN() {
        return R.id.richText;
    }

    public TextView bQZ() {
        return this.hNu.bQZ();
    }

    public void e(BdListView.e eVar) {
        this.hNh.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.bZA = cVar;
        if (this.hOa != null) {
            this.hOa.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.an anVar, a.b bVar) {
        if (anVar != null) {
            int acn = anVar.acn();
            int ack = anVar.ack();
            if (this.hNX != null) {
                this.hNX.afG();
            } else {
                this.hNX = new com.baidu.tbadk.core.dialog.a(this.hGm.getPageContext().getPageActivity());
                this.hNY = LayoutInflater.from(this.hGm.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.hNX.aF(this.hNY);
                this.hNX.a(R.string.dialog_ok, bVar);
                this.hNX.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.23
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.bUP();
                        aVar.dismiss();
                    }
                });
                this.hNX.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.hPb == null) {
                            aq.this.hPb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.hGm.HidenSoftKeyPad((InputMethodManager) aq.this.hGm.getSystemService("input_method"), aq.this.epV);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.iB().postDelayed(aq.this.hPb, 150L);
                    }
                });
                this.hNX.b(this.hGm.getPageContext()).afG();
            }
            this.hNZ = (EditText) this.hNY.findViewById(R.id.input_page_number);
            this.hNZ.setText("");
            TextView textView = (TextView) this.hNY.findViewById(R.id.current_page_number);
            if (acn <= 0) {
                acn = 1;
            }
            if (ack <= 0) {
                ack = 1;
            }
            textView.setText(MessageFormat.format(this.hGm.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(acn), Integer.valueOf(ack)));
            this.hGm.ShowSoftKeyPadDelay(this.hNZ, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hNh.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.hGm.showToast(str);
    }

    public boolean oG(boolean z) {
        if (this.TB == null || !this.TB.aqV()) {
            return false;
        }
        this.TB.app();
        return true;
    }

    public void bUO() {
        if (this.hPL != null) {
            while (this.hPL.size() > 0) {
                TbImageView remove = this.hPL.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bUO();
        this.hNW.xk(1);
        if (this.hMX != null) {
            this.hMX.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.hNW.xk(2);
        if (this.hMX != null) {
            this.hMX.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.hGm) && !TbSingleton.getInstance().isCutoutScreen(this.hGm)) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.hPd != null) {
            this.hPd.destroy();
        }
        if (this.hPu != null) {
            this.hPu.onDestory();
        }
        if (this.hPl != null) {
            this.hPl.hide();
        }
        if (this.hNa != null) {
            this.hNa.aZx();
        }
        if (this.hMZ != null) {
            this.hMZ.onDestroy();
        }
        this.hGm.hideProgressBar();
        if (this.eRU != null && this.fmu != null) {
            this.eRU.b(this.fmu);
        }
        bUP();
        ajz();
        if (this.hPb != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hPb);
        }
        if (this.hNv != null && this.hNG != null) {
            this.hNv.removeView(this.hNB);
            this.hNG = null;
        }
        if (this.hOI != null) {
            this.hOI.clearStatus();
        }
        this.hPE = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hNW.xk(3);
        if (this.frm != null) {
            this.frm.setBackgroundDrawable(null);
        }
        if (this.hMX != null) {
            this.hMX.destroy();
        }
        if (this.hNW != null) {
            this.hNW.onDestroy();
        }
        this.hNh.setOnLayoutListener(null);
        if (this.hPq != null) {
            this.hPq.bmo();
        }
        if (this.hOT != null) {
            this.hOT.onDestroy();
        }
    }

    public boolean xD(int i) {
        if (this.hMX != null) {
            return this.hMX.rz(i);
        }
        return false;
    }

    public void bUP() {
        this.hNd.TU();
        if (this.hNa != null) {
            this.hNa.aZx();
        }
        com.baidu.adp.lib.util.l.b(this.hGm.getPageContext().getPageActivity(), this.hNZ);
        bUa();
        if (this.hEr != null) {
            this.hEr.dismiss();
        }
        bUR();
        if (this.hMZ != null) {
            this.hMZ.bWT();
        }
        if (this.hNX != null) {
            this.hNX.dismiss();
        }
        if (this.fqY != null) {
            this.fqY.dismiss();
        }
    }

    public void bUQ() {
        this.hNd.TU();
        if (this.hNa != null) {
            this.hNa.aZx();
        }
        if (this.hEr != null) {
            this.hEr.dismiss();
        }
        bUR();
        if (this.hMZ != null) {
            this.hMZ.bWT();
        }
        if (this.hNX != null) {
            this.hNX.dismiss();
        }
        if (this.fqY != null) {
            this.fqY.dismiss();
        }
    }

    public void dI(List<String> list) {
        this.hPp = list;
        if (this.hPq != null) {
            this.hPq.setData(list);
        }
    }

    public void nR(boolean z) {
        this.hNW.nR(z);
    }

    public void oH(boolean z) {
        this.hOs = z;
    }

    public void bUR() {
        if (this.hOg != null) {
            this.hOg.dismiss();
        }
        if (this.hOh != null) {
            com.baidu.adp.lib.g.g.b(this.hOh, this.hGm.getPageContext());
        }
        if (this.hOi != null) {
            com.baidu.adp.lib.g.g.b(this.hOi, this.hGm.getPageContext());
        }
        if (this.hOe != null) {
            this.hOe.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            e(this.hJH, this.hGD);
            d(this.hJH, this.hGD, this.mType);
            this.hGm.getLayoutMode().setNightMode(i == 1);
            this.hGm.getLayoutMode().onModeChanged(this.epV);
            this.hGm.getLayoutMode().onModeChanged(this.hNj);
            if (Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 21) {
                com.baidu.tbadk.core.util.al.l(this.epV, R.color.cp_bg_line_d);
            }
            if (this.hMZ != null) {
                this.hMZ.onChangeSkinType(i);
            }
            if (this.hNk != null) {
                com.baidu.tbadk.core.util.al.l(this.hNk, R.color.cp_bg_line_c);
            }
            if (this.hNl != null) {
                this.hNl.setIsNight(this.mSkinType == 1);
            }
            if (this.hNm != null) {
                com.baidu.tbadk.core.util.al.j(this.hNm, R.color.cp_cont_b);
            }
            if (this.hNn != null) {
                com.baidu.tbadk.core.util.al.j(this.hNn, R.color.cp_cont_j);
            }
            if (this.hNo != null) {
                com.baidu.tbadk.core.util.al.k(this.hNo, R.drawable.icon_common_arrow16_right_n);
            }
            if (this.hNq != null) {
                com.baidu.tbadk.core.util.al.j(this.hNq, R.color.cp_cont_b);
                this.hNq.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_link_tip_c));
            }
            if (this.fvg != null) {
                this.fvg.iP(i);
                if (this.cxO != null) {
                    this.hGm.getLayoutMode().onModeChanged(this.cxO);
                    com.baidu.tbadk.core.util.al.k(this.cxO, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.hNX != null) {
                this.hNX.c(this.hGm.getPageContext());
            }
            oF(this.hOp);
            this.hNW.notifyDataSetChanged();
            if (this.hOa != null) {
                this.hOa.iP(i);
            }
            if (this.TB != null) {
                this.TB.onChangeSkinType(i);
            }
            if (this.hNF != null) {
                this.hNF.iW(i);
            }
            if (this.hOb != null) {
                this.hOb.iP(i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.ezU)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ezU) {
                    customBlueCheckRadioButton.ajd();
                }
            }
            bUq();
            UtilHelper.setStatusBarBackground(this.frm, i);
            UtilHelper.setStatusBarBackground(this.hON, i);
            if (this.hNH != null) {
                this.hNH.onChangeSkinType(i);
            }
            if (this.hNL != null) {
                com.baidu.tbadk.core.util.al.j(this.hNL, R.color.cp_cont_d);
            }
            if (this.hNK != null) {
                com.baidu.tbadk.core.util.al.j(this.hNK, R.color.cp_cont_d);
            }
            if (this.hNM != null) {
                com.baidu.tbadk.core.util.al.j(this.hNM, R.color.cp_cont_d);
            }
            if (this.hNJ != null) {
                com.baidu.tbadk.core.util.al.j(this.hNJ, R.color.cp_cont_d);
            }
            if (this.hNP != null) {
                com.baidu.tbadk.s.a.a(this.hGm.getPageContext(), this.hNP);
            }
            if (this.hPc != null) {
                this.hPc.onChangeSkinType(i);
            }
            if (this.hNd != null) {
                if (this.hMX != null) {
                    this.hMX.xI(i);
                } else {
                    this.hNd.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.gfZ != null) {
                com.baidu.tbadk.core.util.al.j(this.gfZ, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.al.k(this.gfZ, R.drawable.bg_comment_input);
            }
            if (this.hOx != null && this.hJH != null) {
                if (this.hJH.ZC()) {
                    com.baidu.tbadk.core.util.al.c(this.hOx, (int) R.drawable.icon_pb_bottom_collect_h);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.hOx, (int) R.drawable.icon_pb_bottom_collect_n);
                }
            }
            if (this.hOy != null) {
                com.baidu.tbadk.core.util.al.c(this.hOy, (int) R.drawable.icon_pb_bottom_share_n);
            }
            if (this.hOw != null) {
                com.baidu.tbadk.core.util.al.c(this.hOw, (int) R.drawable.icon_pb_bottom_comment_n);
            }
            com.baidu.tbadk.core.util.al.j(this.hOz, R.color.cp_cont_b);
            if (this.hNz != null) {
                com.baidu.tbadk.core.util.al.c(this.hNz, BitmapHelper.getGradeResourceIdInEnterForum(this.hPk));
            }
            if (this.hPr != null) {
                this.hPr.onChangeSkinType(i);
            }
            if (this.hOT != null) {
                this.hOT.onChangeSkinType();
            }
            if (this.hPn != null) {
                com.baidu.tbadk.core.util.al.j(this.hPn, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.al.l(this.hOv, R.color.cp_bg_line_d);
            if (this.hNy != null) {
                com.baidu.tbadk.core.util.al.k(this.hNy, this.hPw);
                com.baidu.tbadk.core.util.al.j(this.hNy, R.color.cp_btn_a);
            }
            if (this.hNi != null) {
                this.hNi.nq(i);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIM = hVar;
        this.hNW.setOnImageClickListener(this.cIM);
        this.hPr.setOnImageClickListener(this.cIM);
    }

    public void h(NoNetworkView.a aVar) {
        this.fmu = aVar;
        if (this.eRU != null) {
            this.eRU.a(this.fmu);
        }
    }

    public void oI(boolean z) {
        this.hNW.setIsFromCDN(z);
    }

    public Button bUS() {
        return this.hOt;
    }

    public void bUT() {
        if (this.hNc != 2) {
            this.hNh.setNextPage(this.fvg);
            this.hNc = 2;
        }
    }

    public void bUU() {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            int lastVisiblePosition = this.hNh.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hNh.getChildAt(i);
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

    public boolean bUV() {
        return this.TB != null && this.TB.getVisibility() == 0;
    }

    public boolean bUW() {
        return this.TB != null && this.TB.aqV();
    }

    public void bUX() {
        if (this.TB != null) {
            this.TB.app();
        }
    }

    public void oJ(boolean z) {
        if (this.hOv != null) {
            oH(this.hGm.bRa().arz());
            if (this.hOs) {
                oz(z);
            } else {
                oA(z);
            }
        }
    }

    public void bUY() {
        if (this.hOv != null) {
            this.hOu.setVisibility(8);
            this.hOv.setVisibility(8);
            this.hOA = false;
            if (this.hOT != null) {
                this.hOT.setVisibility(8);
                oD(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.eHv == null) {
            this.eHv = new com.baidu.tbadk.core.view.b(this.hGm.getPageContext());
        }
        this.eHv.ef(true);
    }

    public void aSD() {
        if (this.eHv != null) {
            this.eHv.ef(false);
        }
    }

    private int getScrollY() {
        View childAt = this.hNh.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.hNh.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hMX != null) {
            this.hMX.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.hPM = getScrollY();
            this.hOS.hQc = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOS));
            a(this.hOS.hQc, true);
        }
    }

    public void oK(boolean z) {
        this.hMX.oK(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.hMX != null) {
            this.hMX.b(absListView, i);
        }
        if (this.hNd != null && this.hNW != null) {
            this.hNd.a(this.hNW.bSn());
        }
        this.hOS.hwv = i;
        this.hOS.headerCount = this.hNh.getHeaderViewsCount();
        this.hOS.hQc = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.hOS));
        a(this.hOS.hQc, false);
        if (this.fvg.ajF() && !this.fvg.bZp) {
            if (this.hOS != null && this.hOS.hQc != null && this.hOS.hQc.getView() != null) {
                i4 = this.hOS.hQc.getView().getTop() < 0 ? this.hOS.hQc.getView().getHeight() : this.hOS.hQc.getView().getBottom();
            }
            this.fvg.iS(i4);
            this.fvg.bZp = true;
        }
    }

    public void bUZ() {
        if (this.hGm.isLogin() && this.hJH != null && this.hPh && !this.hPg && !this.hOq && this.hOD != null && this.hOD.adv() != null && !this.hOD.adv().getIsLike() && !this.hOD.adv().hadConcerned() && this.hPd == null) {
            this.hPd = new an(this.hGm);
        }
    }

    public void bVa() {
        if (this.hPh && !this.hPg && this.hOD != null && this.hOD.adv() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").P("obj_locate", this.hGm.bQE() ? 2 : 1).P("obj_type", this.hPg ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hGm.getPageContext().getPageActivity(), this.hOD.adv().getUserId(), this.hOD.adv().getUserName(), this.hGm.bQO().bQF(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.hPg && this.hOM != null && this.hNd.bVJ() != null) {
            int bSj = this.hNW.bSj();
            if (bSj > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bSj > this.hNh.getFirstVisiblePosition() - this.hNh.getHeaderViewsCount()) {
                    this.hOM.setVisibility(8);
                    return;
                }
                this.hOM.setVisibility(0);
                bVk();
                this.hNd.mNavigationBar.hideBottomLine();
                if (this.hOM.getParent() != null && ((ViewGroup) this.hOM.getParent()).getHeight() <= this.hOM.getTop()) {
                    this.hOM.getParent().requestLayout();
                }
            } else if (alVar == null || alVar.getView() == null || alVar.hMB == null) {
                if (this.hNh.getFirstVisiblePosition() == 0) {
                    this.hOM.setVisibility(8);
                    this.hNd.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.hOR) {
                        this.hOQ = top;
                        this.hOR = false;
                    }
                    this.hOQ = top < this.hOQ ? top : this.hOQ;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.hNV.getY() < 0.0f) {
                        measuredHeight = hOP - alVar.hMB.getMeasuredHeight();
                    } else {
                        measuredHeight = this.hNd.bVJ().getMeasuredHeight() - alVar.hMB.getMeasuredHeight();
                        this.hNd.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.hOQ) {
                        this.hOM.setVisibility(0);
                        bVk();
                    } else if (top < measuredHeight) {
                        this.hOM.setVisibility(0);
                        bVk();
                    } else {
                        this.hOM.setVisibility(8);
                        this.hNd.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.hOR = true;
                    }
                }
            }
        }
    }

    public void bVb() {
        if (!this.hPN) {
            TiebaStatic.log("c10490");
            this.hPN = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGm.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(hOW, Integer.valueOf(hOY));
            aVar.hn(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.hGm.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aF(inflate);
            aVar.ab(sparseArray);
            aVar.a(R.string.grade_button_tips, this.hGm);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hGm.getPageContext()).afG();
        }
    }

    public void Bn(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGm.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.hGm.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aF(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(hOW, Integer.valueOf(hOZ));
        aVar.ab(sparseArray);
        aVar.a(R.string.view, this.hGm);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hGm.getPageContext()).afG();
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

    public PbInterviewStatusView bVc() {
        return this.hOI;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPI() != null && dVar.bPI().aev() && this.hOI == null) {
            this.hOI = (PbInterviewStatusView) this.hOH.inflate();
            this.hOI.setOnClickListener(this.fqZ);
            this.hOI.setCallback(this.hGm.bRL());
            this.hOI.setData(this.hGm, dVar);
        }
    }

    public LinearLayout bVd() {
        return this.hNV;
    }

    public View bVe() {
        return this.frm;
    }

    public boolean bVf() {
        return this.hPy;
    }

    public void nW(boolean z) {
        this.hNu.nW(z);
    }

    public void Bo(String str) {
        if (this.hNe != null) {
            this.hNe.setTitle(str);
        }
    }

    private int oL(boolean z) {
        if (this.hOI == null || this.hOI.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.g(this.hGm.getPageContext().getPageActivity(), R.dimen.ds72);
    }

    private void bVg() {
        if (this.hOI != null && this.hOI.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hOI.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.hOI.setLayoutParams(layoutParams);
        }
    }

    public boolean bRf() {
        return false;
    }

    public void Bp(String str) {
        this.gfZ.performClick();
        if (!StringUtils.isNull(str) && this.hGm.bRa() != null && this.hGm.bRa().ars() != null && this.hGm.bRa().ars().getInputView() != null) {
            EditText inputView = this.hGm.bRa().ars().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bUP();
            if (configuration.orientation == 2) {
                bUY();
                bUa();
            } else {
                bUd();
            }
            if (this.hPc != null) {
                this.hPc.bSs();
            }
            this.hGm.bkf();
            this.hNV.setVisibility(8);
            this.hNd.oV(false);
            this.hGm.oc(false);
            if (this.hMX != null) {
                if (configuration.orientation == 1) {
                    bVd().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.hNh.setIsLandscape(true);
                    this.hNh.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.hNh.setIsLandscape(false);
                    if (this.hPM > 0) {
                        this.hNh.smoothScrollBy(this.hPM, 0);
                    }
                }
                this.hMX.onConfigurationChanged(configuration);
                this.hOL.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void oM(boolean z) {
        this.hNb = z;
    }

    public boolean bVh() {
        return this.hMX != null && this.hMX.bVh();
    }

    public void bVi() {
        if (this.hMX != null) {
            this.hMX.onPause();
        }
    }

    public void q(long j, int i) {
        if (this.hMZ != null) {
            this.hMZ.q(j, i);
        }
        if (this.hMX != null) {
            this.hMX.q(j, i);
        }
    }

    public void oh(boolean z) {
        this.hNW.oh(z);
    }

    public void bVj() {
        if (this.hOJ == null) {
            LayoutInflater.from(this.hGm.getActivity()).inflate(R.layout.add_experienced_text, (ViewGroup) this.epV, true);
            this.hOJ = (ViewGroup) this.epV.findViewById(R.id.add_experienced_layout);
            this.hOK = (TextView) this.epV.findViewById(R.id.add_experienced);
            com.baidu.tbadk.core.util.al.j(this.hOK, R.color.cp_btn_a);
            String string = this.hGm.getResources().getString(R.string.experienced_add_success);
            String string2 = this.hGm.getResources().getString(R.string.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_h)));
            this.hOK.setText(spannableString);
        }
        this.hOJ.setVisibility(0);
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
                        aq.this.hOJ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                aq.this.hOK.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hOK.startAnimation(scaleAnimation);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.hOv.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.hGm);
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.hPn = new TextView(this.hGm);
            this.hPn.setText(R.string.connection_tips);
            this.hPn.setGravity(17);
            this.hPn.setPadding(com.baidu.adp.lib.util.l.g(this.hGm, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(this.hGm, R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.g(this.hGm, R.dimen.ds60);
            if (this.hPn.getParent() == null) {
                frameLayout.addView(this.hPn, layoutParams);
            }
            this.hPm = new PopupWindow(this.hGm);
            this.hPm.setContentView(frameLayout);
            this.hPm.setHeight(-2);
            this.hPm.setWidth(-2);
            this.hPm.setFocusable(true);
            this.hPm.setOutsideTouchable(false);
            this.hPm.setBackgroundDrawable(new ColorDrawable(this.hGm.getResources().getColor(R.color.transparent)));
            this.hNh.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.28
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.hPm.showAsDropDown(aq.this.hOv, view.getLeft(), -aq.this.hOv.getHeight());
                    } else {
                        aq.this.hPm.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bVk() {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("show_long_press_tips", false) && this.hPo == null) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_long_press_tips", true);
            this.hPo = new com.baidu.tbadk.core.dialog.a(this.hGm);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.hGm);
            this.hPo.hr(1);
            this.hPo.aF(pbLongPressTipView);
            this.hPo.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.29
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hPo.dN(false);
            this.hPo.b(this.hGm.getPageContext()).afG();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.30
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.hPo != null && aq.this.hPo.isShowing()) {
                        aq.this.hPo.dismiss();
                    }
                }
            }, 5000L);
            if (this.hMX != null) {
                this.hMX.bXd();
            }
        }
    }

    public void oN(boolean z) {
        this.hPt = z;
    }

    public boolean bVl() {
        return this.hPt;
    }

    public PbThreadPostView bVm() {
        return this.hNi;
    }

    private void Z(boolean z, boolean z2) {
        aa(z, z2);
        ab(z, z2);
        if (this.hNW != null && this.hNW.bSo() != null) {
            this.hNW.bSo().T(z, z2);
        }
    }

    private void aa(boolean z, boolean z2) {
        if (z && z2) {
            this.hNs.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hNs.setVisibility(0);
        } else if (z) {
            this.hNs.setImageResource(R.drawable.pic_pb_refined_n);
            this.hNs.setVisibility(0);
        } else if (z2) {
            this.hNs.setImageResource(R.drawable.pic_pb_stick_n);
            this.hNs.setVisibility(0);
        } else {
            this.hNs.setVisibility(8);
        }
    }

    private void ab(boolean z, boolean z2) {
        if (this.hNp != null && this.hJH != null && this.hJH.bPI() != null && this.hJH.bPI().adK() == 0 && !this.hJH.bPI().aep()) {
            if (z && z2) {
                this.hNt.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.hNt.setVisibility(0);
            } else if (z) {
                this.hNt.setImageResource(R.drawable.pic_pb_refined_n);
                this.hNt.setVisibility(0);
            } else if (z2) {
                this.hNt.setImageResource(R.drawable.pic_pb_stick_n);
                this.hNt.setVisibility(0);
            } else {
                this.hNt.setVisibility(8);
            }
        }
    }
}
