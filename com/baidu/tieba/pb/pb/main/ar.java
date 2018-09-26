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
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class ar {
    private static final int fNI = UtilHelper.getLightStatusBarHeight();
    public static int fNO = 3;
    public static int fNP = 0;
    public static int fNQ = 3;
    public static int fNR = 4;
    public static int fNS = 5;
    public static int fNT = 6;
    private static a.InterfaceC0240a fOq = new a.InterfaceC0240a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0240a
        public void onRefresh() {
        }
    };
    private EditorTools SG;
    private TextView aBk;
    private TextView aLH;
    private View aWu;
    private j.b azG;
    private com.baidu.tieba.pb.a.c bjA;
    private List<CustomBlueCheckRadioButton> cGZ;
    private View cLf;
    private NoNetworkView cYm;
    private RelativeLayout cYo;
    private NavigationBarCoverTip dOy;
    private com.baidu.tieba.NEGFeedBack.e dRu;
    private View.OnClickListener dud;
    private View dus;
    private PbListView dxP;
    PbActivity.d fEj;
    private View.OnClickListener fFB;
    private PbActivity fFd;
    private UserIconBox fGn;
    private UserIconBox fGo;
    private PbFakeFloorModel fHw;
    private com.baidu.tieba.pb.data.d fID;
    public int fLV;
    private com.baidu.tieba.pb.video.i fLW;
    private long fLX;
    private com.baidu.tieba.pb.video.h fLY;
    private com.baidu.tieba.c.d fLZ;
    private ap fMA;
    private TextView fMB;
    private TextView fMC;
    private TextView fMD;
    private View fME;
    private View fMF;
    private LinearLayout fMG;
    private TextView fMH;
    private TextView fMI;
    private View fMJ;
    private View fMK;
    private ObservedChangeLinearLayout fMM;
    private f fMN;
    private View fMT;
    public final com.baidu.tieba.pb.pb.main.view.b fMc;
    public com.baidu.tieba.pb.pb.main.view.a fMd;
    private ViewStub fMe;
    private ViewStub fMf;
    private PbLandscapeListView fMg;
    private View fMh;
    private LinearLayout fMk;
    private e fMl;
    private ColumnLayout fMm;
    private ThreadSkinView fMn;
    private TextView fMo;
    private TextView fMp;
    private ImageView fMq;
    private HeadPendantView fMr;
    private FrameLayout fMs;
    private HeadImageView fMt;
    private View fMu;
    private FloatingLayout fMv;
    private PbFirstFloorUserLikeButton fMy;
    private ap fMz;
    private ViewStub fNA;
    private PbInterviewStatusView fNB;
    private ViewGroup fNC;
    private TextView fND;
    private FrameLayout fNE;
    private View fNF;
    private View fNG;
    private al fNH;
    private PbEmotionBar fNM;
    private int fNU;
    private Runnable fNV;
    private s fNW;
    private an fNX;
    private View fNn;
    private TextView fNo;
    private ImageView fNp;
    private ImageView fNq;
    private TextView fNr;
    private boolean fNt;
    private int fNu;
    private int fNv;
    private PostData fNw;
    private View fNy;
    private TextView fNz;
    private PbActivity.b fOA;
    private int fOF;
    private int fOd;
    private PbTopTipView fOf;
    private PopupWindow fOg;
    private PopupWindow fOh;
    private TextView fOi;
    private com.baidu.tbadk.core.dialog.a fOj;
    private List<String> fOk;
    private com.baidu.tieba.pb.pb.main.emotion.c fOl;
    private com.baidu.tieba.pb.pb.godreply.a fOm;
    private PbLandscapeListView.b fOn;
    private ac fOp;
    private boolean fOr;
    private com.baidu.tbadk.core.view.userLike.c fOs;
    private com.baidu.tbadk.core.view.userLike.c fOt;
    private Runnable fOy;
    private boolean isLandscape;
    private int mType;
    private boolean fMa = false;
    private int fMb = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fMi = null;
    private TextView fMj = null;
    public FrsPraiseView fMw = null;
    private ClickableHeaderImageView fMx = null;
    private View fML = null;
    private com.baidu.tbadk.core.dialog.a fMO = null;
    private com.baidu.tbadk.core.dialog.b duc = null;
    private View fMP = null;
    private EditText fMQ = null;
    private com.baidu.tieba.pb.view.d fMR = null;
    private com.baidu.tieba.pb.view.a fMS = null;
    private com.baidu.tbadk.core.dialog.a fMU = null;
    private b.InterfaceC0100b eDd = null;
    private TbRichTextView.h bjz = null;
    private NoNetworkView.a dpW = null;
    private Dialog fMV = null;
    private View fMW = null;
    private com.baidu.tbadk.core.dialog.a fMX = null;
    private Dialog fMY = null;
    private Dialog fMZ = null;
    private View fNa = null;
    private LinearLayout fNb = null;
    private CompoundButton.OnCheckedChangeListener cHa = null;
    private TextView fNc = null;
    private TextView fNd = null;
    private View fNe = null;
    private String fNf = null;
    private com.baidu.tbadk.core.dialog.b fNg = null;
    private com.baidu.tbadk.core.dialog.b fNh = null;
    private boolean fNi = false;
    private boolean fNj = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fNk = null;
    private boolean fNl = false;
    private Button fNm = null;
    private boolean fNs = true;
    private com.baidu.tbadk.core.view.d cOv = null;
    private boolean fFu = false;
    private int mSkinType = 3;
    private boolean fNx = false;
    private int fNJ = 0;
    private boolean fNK = true;
    private a fNL = new a();
    private int fNN = 0;
    private boolean fNY = false;
    private int fNZ = 0;
    private boolean fOa = false;
    private boolean fOb = false;
    private boolean fOc = false;
    private int fOe = 0;
    private boolean fOo = false;
    private String fOu = null;
    private CustomMessageListener fOv = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.fOu = null;
            }
        }
    };
    private CustomMessageListener bDp = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fMN != null) {
                ar.this.fMN.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fOw = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fMj != null) {
                ar.this.fMj.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fOx = new Handler();
    private CustomMessageListener fOz = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fNs = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fOB = true;
    View.OnClickListener fOC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fOa) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").w(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (ar.this.fMc != null && ar.this.fMc.fRk != null && view == ar.this.fMc.fRk.getHeadView()) {
                if (ar.this.fMc.fRi == null || ar.this.fMc.fRi.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").w("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!ar.this.fOa && ar.this.fID != null && ar.this.fID.bbJ() != null && ar.this.fID.bbJ().wm() != null && ar.this.fID.bbJ().wm().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").w("obj_locate", 1));
            }
            ar.this.fFd.fDh.dSp.onClick(view);
        }
    };
    private boolean fOD = false;
    String userId = null;
    private final List<TbImageView> fOE = new ArrayList();
    private boolean fOG = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fOU;
        public al fOV;
        public int fvA;
    }

    public void kB(boolean z) {
        this.fNY = z;
        if (this.fMg != null) {
            this.fNZ = this.fMg.getHeaderViewsCount();
        }
    }

    public void bfV() {
        if (this.fMg != null) {
            int headerViewsCount = this.fMg.getHeaderViewsCount() - this.fNZ;
            final int firstVisiblePosition = (this.fMg.getFirstVisiblePosition() == 0 || this.fMg.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fMg.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fMg.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fNL.fOV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fNL));
            final al alVar = this.fNL.fOV;
            final int h = h(alVar);
            final int y = ((int) this.fMM.getY()) + this.fMM.getMeasuredHeight();
            final boolean z = this.fNF.getVisibility() == 0;
            boolean z2 = this.fMM.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fMN.bej() + this.fMg.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fLv.getMeasuredHeight() : 0;
                if (z2) {
                    this.fMg.setSelectionFromTop(this.fMN.bej() + this.fMg.getHeaderViewsCount(), fNI - measuredHeight);
                } else {
                    this.fMg.setSelectionFromTop(this.fMN.bej() + this.fMg.getHeaderViewsCount(), this.fMc.bhE().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fMg.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fOa) {
                this.fMg.setSelectionFromTop(this.fMN.bej() + this.fMg.getHeaderViewsCount(), this.fLW.biT().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fMg.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void beA() {
                        if (h >= 0 && h <= ar.this.cYo.getMeasuredHeight()) {
                            int h2 = ar.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.cLf.getLayoutParams();
                            if (i == 0 || i > ar.this.cYo.getMeasuredHeight() || h2 >= ar.this.cYo.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fNU;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.cYo.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fNU;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fMg.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.cLf.setLayoutParams(layoutParams);
                        }
                        ar.this.fMg.setOnLayoutListener(null);
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

    public NoNetworkView bfW() {
        return this.cYm;
    }

    public void bfX() {
        if (this.SG != null) {
            this.SG.hide();
            if (this.fOl != null) {
                this.fOl.UC();
            }
        }
    }

    public PbFakeFloorModel bfY() {
        return this.fHw;
    }

    public s bfZ() {
        return this.fNW;
    }

    public void bga() {
        reset();
        bfX();
        this.fNW.beq();
        kN(false);
    }

    private void reset() {
        if (this.fFd != null && this.fFd.bda() != null && this.SG != null) {
            com.baidu.tbadk.editortools.pb.a.Jf().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bda = this.fFd.bda();
            bda.Jy();
            bda.IT();
            if (bda.getWriteImagesInfo() != null) {
                bda.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bda.ff(SendView.ALL);
            bda.fg(SendView.ALL);
            com.baidu.tbadk.editortools.g eW = this.SG.eW(23);
            com.baidu.tbadk.editortools.g eW2 = this.SG.eW(2);
            com.baidu.tbadk.editortools.g eW3 = this.SG.eW(5);
            if (eW2 != null) {
                eW2.pI();
            }
            if (eW3 != null) {
                eW3.pI();
            }
            if (eW != null) {
                eW.hide();
            }
            this.SG.invalidate();
        }
    }

    public boolean bgb() {
        return this.fNs;
    }

    public void kC(boolean z) {
        if (this.fNn != null && this.fNo != null) {
            this.fNo.setText(e.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fNn.startAnimation(alphaAnimation);
            }
            this.fNn.setVisibility(0);
            this.fNs = true;
            if (this.fNM != null && !this.fOm.isActive()) {
                this.fNM.setVisibility(0);
                kH(true);
            }
        }
    }

    public void kD(boolean z) {
        if (this.fNn != null && this.fNo != null) {
            this.fNo.setText(e.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fNn.startAnimation(alphaAnimation);
            }
            this.fNn.setVisibility(0);
            this.fNs = true;
            if (this.fNM != null && !this.fOm.isActive()) {
                this.fNM.setVisibility(0);
                kH(true);
            }
        }
    }

    public PostData bgc() {
        int i = 0;
        if (this.fMg == null) {
            return null;
        }
        int bgd = bgd() - this.fMg.getHeaderViewsCount();
        if (bgd < 0) {
            bgd = 0;
        }
        if (this.fMN.qX(bgd) != null && this.fMN.qX(bgd) != PostData.gVz) {
            i = bgd + 1;
        }
        return this.fMN.getItem(i) instanceof PostData ? (PostData) this.fMN.getItem(i) : null;
    }

    public int bgd() {
        int i;
        View childAt;
        if (this.fMg == null) {
            return 0;
        }
        int firstVisiblePosition = this.fMg.getFirstVisiblePosition();
        int lastVisiblePosition = this.fMg.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fMg.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fMg.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bge() {
        return this.fMg.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fID != null && this.fID.bbL() != null && !this.fID.bbL().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fID.bbL().size() && (postData = this.fID.bbL().get(i)) != null && postData.wm() != null && !StringUtils.isNull(postData.wm().getUserId()); i++) {
                if (this.fID.bbL().get(i).wm().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fOm != null && this.fOm.isActive()) {
                        kN(false);
                    }
                    if (this.fNM != null) {
                        this.fNM.kV(true);
                    }
                    this.fOu = postData.wm().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fFd = null;
        this.cYo = null;
        this.dus = null;
        this.fLX = 0L;
        this.fMg = null;
        this.fMh = null;
        this.fMk = null;
        this.fMm = null;
        this.fMo = null;
        this.fMp = null;
        this.fMs = null;
        this.fMt = null;
        this.fMu = null;
        this.fMy = null;
        this.fMB = null;
        this.fMC = null;
        this.fMD = null;
        this.fME = null;
        this.fMJ = null;
        this.fMK = null;
        this.fMN = null;
        this.dxP = null;
        this.aWu = null;
        this.dud = null;
        this.fFB = null;
        this.fNn = null;
        this.fNo = null;
        this.fNp = null;
        this.fNq = null;
        this.fNr = null;
        this.fNy = null;
        this.fNz = null;
        this.fNA = null;
        this.fOd = 0;
        this.fLX = System.currentTimeMillis();
        this.fFd = pbActivity;
        this.dud = onClickListener;
        this.bjA = cVar;
        this.fOd = com.baidu.adp.lib.util.l.aO(this.fFd) / 2;
        this.cYo = (RelativeLayout) LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.new_pb_activity, (ViewGroup) null);
        this.fFd.addContentView(this.cYo, new FrameLayout.LayoutParams(-1, -1));
        this.dOy = (NavigationBarCoverTip) this.fFd.findViewById(e.g.pb_multi_forum_del_tip_view);
        this.dus = this.fFd.findViewById(e.g.statebar_view);
        this.fMM = (ObservedChangeLinearLayout) this.fFd.findViewById(e.g.title_wrapper);
        this.cYm = (NoNetworkView) this.fFd.findViewById(e.g.view_no_network);
        this.fMg = (PbLandscapeListView) this.fFd.findViewById(e.g.new_pb_list);
        this.fNE = (FrameLayout) this.fFd.findViewById(e.g.root_float_header);
        this.aLH = new TextView(this.fFd.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds88));
        this.fMg.addHeaderView(this.aLH, 0);
        this.fNU = this.fFd.getResources().getDimensionPixelSize(e.C0141e.tbds134);
        this.cLf = new View(this.fFd.getPageContext().getPageActivity());
        this.cLf.setLayoutParams(new AbsListView.LayoutParams(-1, this.fNU));
        this.cLf.setVisibility(4);
        this.fMg.addFooterView(this.cLf);
        this.fMg.setOnTouchListener(this.fFd.aZX);
        this.fMc = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fFd.bdE()) {
            this.fMe = (ViewStub) this.fFd.findViewById(e.g.manga_view_stub);
            this.fMe.setVisibility(0);
            this.fMd = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fMd.show();
            this.fMc.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds120);
        }
        this.aLH.setLayoutParams(layoutParams);
        this.fMc.bhE().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0207a() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0207a
            public void bcy() {
                if (ar.this.fMg != null) {
                    if (ar.this.fLW != null) {
                        ar.this.fLW.biU();
                    }
                    ar.this.fMg.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0207a
            public void bcz() {
                ar.this.fFd.awu();
            }
        }));
        this.fNn = this.fFd.findViewById(e.g.pb_editor_tool_comment);
        this.fNu = com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds90);
        this.fNv = com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds242);
        this.fNo = (TextView) this.fFd.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_reply_text);
        this.fNq = (ImageView) this.fFd.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_more_img);
        this.fNp = (ImageView) this.fFd.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_emotion_img);
        this.fNr = (TextView) this.fFd.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_praise_icon);
        this.fNr.setVisibility(8);
        this.fNo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bgf();
            }
        });
        this.fNp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bhg();
                if (ar.this.fFd.checkUpIsLogin()) {
                    if (ar.this.SG != null) {
                        ar.this.bgp();
                        ar.this.SG.aa((View) ar.this.SG.eW(5));
                    }
                    if (ar.this.SG != null) {
                        ar.this.fNs = false;
                        if (ar.this.SG.eZ(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fFd, (View) ar.this.SG.eZ(2).aPu, false, ar.fOq);
                        }
                    }
                    ar.this.bgT();
                }
            }
        });
        this.fNq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bhg();
                if (ar.this.fFd.checkUpIsLogin()) {
                    if (ar.this.SG != null) {
                        ar.this.bgp();
                        ar.this.SG.aa((View) ar.this.SG.eW(2));
                    }
                    if (ar.this.SG != null) {
                        ar.this.fNs = false;
                        if (ar.this.SG.eZ(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fFd, (View) ar.this.SG.eZ(2).aPu, false, ar.fOq);
                        }
                    }
                    ar.this.bgT();
                }
            }
        });
        this.fNr.setOnClickListener(this.dud);
        this.fNr.setOnTouchListener(this.fFd);
        this.fMh = LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_item, (ViewGroup) null);
        this.fMk = (LinearLayout) LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_user_item, (ViewGroup) null);
        this.fMl = new e(this.fFd, this.fMk);
        this.fMl.init();
        this.fMl.a(this.fMl.bcZ(), this.dud);
        this.fMm = (ColumnLayout) this.fMk.findViewById(e.g.pb_head_owner_root);
        this.fMn = (ThreadSkinView) this.fMk.findViewById(e.g.pb_thread_skin);
        this.fMm.setOnLongClickListener(this.onLongClickListener);
        this.fMm.setOnTouchListener(this.bjA);
        this.fMm.setVisibility(8);
        this.fMh.setOnTouchListener(this.bjA);
        this.fNy = this.fMh.findViewById(e.g.pb_head_activity_join_number_container);
        this.fNy.setVisibility(8);
        this.fNz = (TextView) this.fMh.findViewById(e.g.pb_head_activity_join_number);
        this.fMo = (TextView) this.fMm.findViewById(e.g.pb_head_owner_info_user_name);
        this.fMp = (TextView) this.fMm.findViewById(e.g.floor_owner);
        this.fMq = (ImageView) this.fMm.findViewById(e.g.icon_forum_level);
        this.fMs = (FrameLayout) this.fMm.findViewById(e.g.pb_head_headImage_container);
        this.fMt = (HeadImageView) this.fMm.findViewById(e.g.pb_head_owner_photo);
        this.fMr = (HeadPendantView) this.fMm.findViewById(e.g.pb_pendant_head_owner_photo);
        this.fMr.setHasPendantStyle();
        if (this.fMr.getHeadView() != null) {
            this.fMr.getHeadView().setIsRound(true);
            this.fMr.getHeadView().setDrawBorder(false);
        }
        this.fGn = (UserIconBox) this.fMm.findViewById(e.g.show_icon_vip);
        this.fGo = (UserIconBox) this.fMm.findViewById(e.g.show_icon_yinji);
        this.fMv = (FloatingLayout) this.fMk.findViewById(e.g.pb_head_owner_info_root);
        this.fMy = (PbFirstFloorUserLikeButton) this.fMm.findViewById(e.g.pb_like_button);
        this.fMB = (TextView) this.fMm.findViewById(e.g.pb_views);
        this.aBk = (TextView) this.fMm.findViewById(e.g.view_forum_name);
        this.fMF = this.fMm.findViewById(e.g.line_right_forum_name);
        this.fMC = (TextView) this.fMm.findViewById(e.g.pb_item_first_floor_reply_time);
        this.fMD = (TextView) this.fMm.findViewById(e.g.pb_item_first_floor_location_address);
        this.fME = this.fMm.findViewById(e.g.line_between_time_and_locate);
        this.fOs = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fOt = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fMJ = this.fMh.findViewById(e.g.new_pb_header_item_line_above_livepost);
        this.fMK = this.fMh.findViewById(e.g.new_pb_header_item_line_below_livepost);
        this.fMh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.37
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fNA = (ViewStub) this.cYo.findViewById(e.g.interview_status_stub);
        this.fMN = new f(this.fFd, this.fMg);
        this.fMN.u(this.dud);
        this.fMN.setTbGestureDetector(this.bjA);
        this.fMN.setOnImageClickListener(this.bjz);
        this.fFB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.38
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
                            ar.this.fFd.b(sparseArray);
                            return;
                        }
                        ar.this.bA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 0);
                        sparseArray.put(e.g.tag_check_mute_from, 1);
                        ar.this.fFd.b(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fMN.G(this.fFB);
        bgk();
        this.fMg.addHeaderView(this.fMi);
        this.fMg.addHeaderView(this.fMk);
        this.fMg.addHeaderView(this.fMh);
        this.dxP = new PbListView(this.fFd.getPageContext().getPageActivity());
        this.aWu = this.dxP.getView().findViewById(e.g.pb_more_view);
        if (this.aWu != null) {
            this.aWu.setOnClickListener(this.dud);
            com.baidu.tbadk.core.util.al.i(this.aWu, e.f.pb_foot_more_trans_selector);
        }
        this.dxP.BE();
        this.dxP.dJ(e.f.pb_foot_more_trans_selector);
        this.dxP.dL(e.f.pb_foot_more_trans_selector);
        this.fMT = this.fFd.findViewById(e.g.viewstub_progress);
        this.fFd.registerListener(this.fOz);
        this.fMu = com.baidu.tbadk.ala.b.sB().i(this.fFd.getActivity(), 2);
        if (this.fMu != null) {
            this.fMu.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fFd.getResources().getDimensionPixelSize(e.C0141e.ds10);
            if (this.fMu.getParent() == null) {
                this.fMv.addView(this.fMu, aVar);
            }
        }
        this.fHw = new PbFakeFloorModel(this.fFd.getPageContext());
        this.fNW = new s(this.fFd.getPageContext(), this.fHw, this.cYo);
        this.fNW.a(this.fFd.fEf);
        this.fHw.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.fHw.m(postData);
                ar.this.fMN.notifyDataSetChanged();
                ar.this.fNW.beq();
                ar.this.SG.Hf();
                ar.this.kN(false);
            }
        });
        if (this.fFd.bcO() != null && !StringUtils.isNull(this.fFd.bcO().bfh())) {
            this.fFd.showToast(this.fFd.bcO().bfh());
        }
        this.fNF = this.fFd.findViewById(e.g.pb_expand_blank_view);
        this.fNG = this.fFd.findViewById(e.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fNG.getLayoutParams();
        if (this.fFd.bcO() != null && this.fFd.bcO().beG()) {
            this.fNF.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fNG.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fNI;
            this.fNG.setLayoutParams(layoutParams2);
        }
        this.fNH = new al(this.fFd.getPageContext(), this.fFd.findViewById(e.g.pb_reply_expand_view));
        this.fNH.fLv.setVisibility(8);
        this.fNH.J(this.dud);
        this.fFd.registerListener(this.bDp);
        this.fFd.registerListener(this.fOv);
        this.fFd.registerListener(this.fOw);
        bgg();
        kH(false);
    }

    public void bgf() {
        bhg();
        if (!this.fFd.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").w("obj_locate", 2).al(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.fFd.bdm()) {
            com.baidu.tbadk.editortools.pb.d bda = this.fFd.bda();
            if (bda != null && (bda.Jv() || bda.Jw())) {
                this.fFd.bda().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.SG != null) {
                bgp();
            }
            if (this.SG != null) {
                this.fNs = false;
                if (this.SG.eZ(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.fFd, (View) this.SG.eZ(2).aPu, false, fOq);
                }
            }
            bgT();
        }
    }

    private void bgg() {
        this.fOm = new com.baidu.tieba.pb.pb.godreply.a(this.fFd, this, (ViewStub) this.cYo.findViewById(e.g.more_god_reply_popup));
        this.fOm.q(this.dud);
        this.fOm.G(this.fFB);
        this.fOm.setOnImageClickListener(this.bjz);
        this.fOm.q(this.dud);
        this.fOm.setTbGestureDetector(this.bjA);
    }

    public com.baidu.tieba.pb.pb.godreply.a bgh() {
        return this.fOm;
    }

    public View bgi() {
        return this.fNF;
    }

    public void bgj() {
        if (this.fMg != null) {
            this.fMg.removeHeaderView(this.fMi);
            this.fMg.removeHeaderView(this.fMk);
            this.fMg.removeHeaderView(this.fMh);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fNM == null) {
            this.fNM = new PbEmotionBar(this.fFd.getPageContext().getPageActivity());
            kH(true);
            this.fNM.a(this.cYo, aVar, this.fNn.getVisibility() == 0);
            this.fNM.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (ar.this.fFd.bdm()) {
                        if (!StringUtils.isNull(ar.this.fOu)) {
                            emotionImageData.setAuthorNameShow(ar.this.fOu);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fFd.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fFd.getPageContext().getPageActivity(), 25016, str, list, ar.this.fOu, list2)));
                }
            });
            this.fNM.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    ar.this.bhg();
                    if (ar.this.fNn != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fNn.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fNv - ar.this.fNu) * f) + ar.this.fNu);
                        ar.this.fNo.setAlpha(1.0f - f);
                        ar.this.fNq.setAlpha(1.0f - f);
                        ar.this.fNp.setAlpha(1.0f - f);
                        ar.this.fNn.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bgk() {
        if (this.fMi == null) {
            int h = com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.tbds44);
            this.fMi = new LinearLayout(this.fFd.getPageContext().getPageActivity());
            this.fMi.setOrientation(1);
            this.fMi.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fMi.setPadding(h, com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.tbds30), h, com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.tbds40));
            this.fMi.setGravity(17);
            this.fMj = new TextView(this.fFd.getPageContext().getPageActivity());
            this.fMj.setGravity(3);
            this.fMj.setMaxLines(2);
            this.fMj.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            this.fMj.setPadding(0, 0, 0, 0);
            this.fMj.setLineSpacing(com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.fMj, e.d.cp_cont_b);
            this.fMj.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fMj.setVisibility(8);
            if (this.fMj.getParent() == null) {
                this.fMi.addView(this.fMj);
            }
            this.fMi.setOnTouchListener(this.bjA);
            this.fMi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgl() {
        if (this.fFd.bdE()) {
            this.fMf = (ViewStub) this.fFd.findViewById(e.g.manga_mention_controller_view_stub);
            this.fMf.setVisibility(0);
            if (this.fMG == null) {
                this.fMG = (LinearLayout) this.fFd.findViewById(e.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fFd.getPageContext(), this.fMG);
            }
            if (this.fMH == null) {
                this.fMH = (TextView) this.fMG.findViewById(e.g.manga_prev_btn);
            }
            if (this.fMI == null) {
                this.fMI = (TextView) this.fMG.findViewById(e.g.manga_next_btn);
            }
            this.fMH.setOnClickListener(this.dud);
            this.fMI.setOnClickListener(this.dud);
        }
    }

    private void bgm() {
        if (this.fFd.bdE()) {
            if (this.fFd.bdH() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fMH, e.d.cp_cont_e, 1);
            }
            if (this.fFd.bdI() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fMI, e.d.cp_cont_e, 1);
            }
        }
    }

    public void bgn() {
        if (this.fMG == null) {
            bgl();
        }
        this.fMf.setVisibility(8);
        if (this.fOx != null && this.fOy != null) {
            this.fOx.removeCallbacks(this.fOy);
        }
    }

    public void bgo() {
        if (this.fOx != null) {
            if (this.fOy != null) {
                this.fOx.removeCallbacks(this.fOy);
            }
            this.fOy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fMG == null) {
                        ar.this.bgl();
                    }
                    ar.this.fMf.setVisibility(0);
                }
            };
            this.fOx.postDelayed(this.fOy, 2000L);
        }
    }

    public void kE(boolean z) {
        this.fMc.kE(z);
        if (z && this.fNx) {
            this.dxP.setText(this.fFd.getResources().getString(e.j.click_load_more));
            this.fMg.setNextPage(this.dxP);
            this.fMb = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
        this.SG.setId(e.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.SG.getParent() == null) {
            this.cYo.addView(this.SG, layoutParams);
        }
        this.SG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bfX();
        this.fFd.bda().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.SG != null && ar.this.SG.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fOl == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.SG.getId());
                            ar.this.fOl = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fFd.getPageContext(), ar.this.cYo, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.z(ar.this.fOk)) {
                                ar.this.fOl.setData(ar.this.fOk);
                            }
                            ar.this.fOl.b(ar.this.SG);
                        }
                        ar.this.fOl.sd(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fFd.fDl != null && ar.this.fFd.fDl.bhl() != null) {
                    if (!ar.this.fFd.fDl.bhl().bIh()) {
                        ar.this.fFd.fDl.kS(false);
                    }
                    ar.this.fFd.fDl.bhl().nL(false);
                }
            }
        });
    }

    public void bgp() {
        if (this.fFd != null && this.SG != null) {
            this.SG.pI();
            if (this.fFd.bda() != null) {
                this.fFd.bda().Jm();
            }
            bgT();
        }
    }

    public void N(String str, boolean z) {
        this.fNt = z;
        kF(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kF(boolean z) {
        if (this.fNr != null) {
            if (this.fNt) {
                com.baidu.tbadk.core.util.al.i(this.fNr, e.f.pb_praise_already_click_selector);
                this.fNr.setContentDescription(this.fFd.getResources().getString(e.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.fNr, e.f.pb_praise_normal_click_selector);
            this.fNr.setContentDescription(this.fFd.getResources().getString(e.j.zan));
        }
    }

    public TextView bgq() {
        return this.fNr;
    }

    public void kG(boolean z) {
        if (this.fMg != null && this.aLH != null && this.dus != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dus.setVisibility(0);
                } else {
                    this.dus.setVisibility(8);
                    this.fMg.removeHeaderView(this.aLH);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aLH.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fNI;
                    this.aLH.setLayoutParams(layoutParams);
                }
                bgE();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aLH.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kP(true);
                this.aLH.setLayoutParams(layoutParams2);
            }
            bgE();
            bhb();
        }
    }

    public f bgr() {
        return this.fMN;
    }

    public void a(PbActivity.d dVar) {
        this.fEj = dVar;
    }

    public void bA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fMW == null) {
            this.fMW = LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fFd.getLayoutMode().onModeChanged(this.fMW);
        if (this.fMV == null) {
            this.fMV = new Dialog(this.fFd.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fMV.setCanceledOnTouchOutside(true);
            this.fMV.setCancelable(true);
            this.fMV.setContentView(this.fMW);
            WindowManager.LayoutParams attributes = this.fMV.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.aO(this.fFd.getPageContext().getPageActivity()) * 0.9d);
            this.fMV.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fMV.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.fMV.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fMV.findViewById(e.g.disable_reply_btn);
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
                    if (ar.this.fMV != null && (ar.this.fMV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fMV, ar.this.fFd.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(e.g.tag_del_post_id), ((Integer) sparseArray5.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(e.g.tag_forbid_user_name)) && "".equals(sparseArray.get(e.g.tag_forbid_user_name_show))) || bha()) {
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
                    if (ar.this.fMV != null && (ar.this.fMV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fMV, ar.this.fFd.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fOA != null) {
                        ar.this.fOA.j(new Object[]{sparseArray6.get(e.g.tag_manage_user_identity), sparseArray6.get(e.g.tag_forbid_user_name), sparseArray6.get(e.g.tag_forbid_user_post_id), sparseArray6.get(e.g.tag_forbid_user_name_show), sparseArray6.get(e.g.tag_forbid_user_portrait)});
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
                    if (ar.this.fMV != null && (ar.this.fMV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fMV, ar.this.fFd.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fFd.a(z, (String) sparseArray7.get(e.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fMV, this.fFd.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fOA = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fFd != null && aVar != null) {
            if (this.dRu == null) {
                this.dRu = new com.baidu.tieba.NEGFeedBack.e(this.fFd.getPageContext(), this.fMh);
            }
            AntiData avt = this.fFd.avt();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (avt != null && avt.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = avt.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.dRu.setDefaultReasonArray(new String[]{this.fFd.getString(e.j.delete_thread_reason_1), this.fFd.getString(e.j.delete_thread_reason_2), this.fFd.getString(e.j.delete_thread_reason_3), this.fFd.getString(e.j.delete_thread_reason_4), this.fFd.getString(e.j.delete_thread_reason_5)});
            this.dRu.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.dRu.iA(str);
            this.dRu.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void j(JSONArray jSONArray) {
                    ar.this.fFd.a(aVar, jSONArray);
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
        sparseArray.put(fNP, Integer.valueOf(fNQ));
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
        this.fMX = new com.baidu.tbadk.core.dialog.a(this.fFd.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fMX.cp(i3);
        } else {
            this.fMX.aJ(false);
            this.fMX.dT(str2);
        }
        this.fMX.D(sparseArray);
        this.fMX.a(e.j.dialog_ok, this.fFd);
        this.fMX.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fMX.aE(true);
        this.fMX.b(this.fFd.getPageContext());
        if (z) {
            this.fMX.yl();
        } else {
            a(this.fMX, i);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fNa == null) {
            this.fNa = LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.commit_good, (ViewGroup) null);
        }
        this.fFd.getLayoutMode().onModeChanged(this.fNa);
        if (this.fMZ == null) {
            this.fMZ = new Dialog(this.fFd.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fMZ.setCanceledOnTouchOutside(true);
            this.fMZ.setCancelable(true);
            this.fNk = (ScrollView) this.fNa.findViewById(e.g.good_scroll);
            this.fMZ.setContentView(this.fNa);
            WindowManager.LayoutParams attributes = this.fMZ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds540);
            this.fMZ.getWindow().setAttributes(attributes);
            this.cHa = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fNf = (String) compoundButton.getTag();
                        if (ar.this.cGZ != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ar.this.cGZ) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ar.this.fNf != null && !str.equals(ar.this.fNf)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fNb = (LinearLayout) this.fNa.findViewById(e.g.good_class_group);
            this.fNd = (TextView) this.fNa.findViewById(e.g.dialog_button_cancel);
            this.fNd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fMZ instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fMZ, ar.this.fFd.getPageContext());
                    }
                }
            });
            this.fNc = (TextView) this.fNa.findViewById(e.g.dialog_button_ok);
            this.fNc.setOnClickListener(this.dud);
        }
        this.fNb.removeAllViews();
        this.cGZ = new ArrayList();
        CustomBlueCheckRadioButton bY = bY("0", this.fFd.getPageContext().getString(e.j.thread_good_class));
        this.cGZ.add(bY);
        bY.setChecked(true);
        this.fNb.addView(bY);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.va()) && aaVar.vb() > 0) {
                    CustomBlueCheckRadioButton bY2 = bY(String.valueOf(aaVar.vb()), aaVar.va());
                    this.cGZ.add(bY2);
                    View view = new View(this.fFd.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, e.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fNb.addView(view);
                    this.fNb.addView(bY2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fNk.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fFd.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fFd.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fFd.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fNk.setLayoutParams(layoutParams2);
            this.fNk.removeAllViews();
            if (this.fNb != null && this.fNb.getParent() == null) {
                this.fNk.addView(this.fNb);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fMZ, this.fFd.getPageContext());
    }

    private CustomBlueCheckRadioButton bY(String str, String str2) {
        Activity pageActivity = this.fFd.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, e.C0141e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cHa);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bgs() {
        this.fFd.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fFd.hideProgressBar();
        if (z && z2) {
            this.fFd.showToast(this.fFd.getPageContext().getString(e.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.neterror);
            }
            this.fFd.showToast(str);
        }
    }

    public void aNS() {
        this.fMT.setVisibility(0);
    }

    public void aNR() {
        this.fMT.setVisibility(8);
    }

    public View bgt() {
        if (this.fNa != null) {
            return this.fNa.findViewById(e.g.dialog_button_ok);
        }
        return null;
    }

    public String bgu() {
        return this.fNf;
    }

    public View getView() {
        return this.cYo;
    }

    public void bgv() {
        com.baidu.adp.lib.util.l.a(this.fFd.getPageContext().getPageActivity(), this.fFd.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fFd.hideProgressBar();
        if (z) {
            bgK();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bgL();
        } else {
            bgK();
        }
    }

    public void bgw() {
        this.dxP.BE();
        this.dxP.BI();
    }

    public void bgx() {
        this.fFd.hideProgressBar();
        BJ();
        this.fMg.completePullRefreshPostDelayed(2000L);
        bgH();
    }

    public void bgy() {
        this.fMg.completePullRefreshPostDelayed(2000L);
        bgH();
    }

    private void kH(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fNo.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fFd.getResources().getDimensionPixelSize(e.C0141e.ds130) : this.fFd.getResources().getDimensionPixelSize(e.C0141e.ds34);
        this.fNo.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fMN.setOnLongClickListener(onLongClickListener);
        if (this.fOm != null) {
            this.fOm.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0100b interfaceC0100b, boolean z, boolean z2) {
        if (this.fNg != null) {
            this.fNg.dismiss();
            this.fNg = null;
        }
        this.fNg = new com.baidu.tbadk.core.dialog.b(this.fFd.getPageContext().getPageActivity());
        this.fNg.cs(e.j.operation);
        if (z2) {
            this.fNg.a(new String[]{this.fFd.getPageContext().getString(e.j.copy), this.fFd.getPageContext().getString(e.j.report_text)}, interfaceC0100b);
        } else if (!z) {
            this.fNg.a(new String[]{this.fFd.getPageContext().getString(e.j.copy), this.fFd.getPageContext().getString(e.j.mark)}, interfaceC0100b);
        } else {
            this.fNg.a(new String[]{this.fFd.getPageContext().getString(e.j.copy), this.fFd.getPageContext().getString(e.j.remove_mark)}, interfaceC0100b);
        }
        this.fNg.d(this.fFd.getPageContext());
        this.fNg.yo();
    }

    public void a(b.InterfaceC0100b interfaceC0100b, boolean z) {
        if (this.fNh != null) {
            this.fNh.dismiss();
            this.fNh = null;
        }
        this.fNh = new com.baidu.tbadk.core.dialog.b(this.fFd.getPageContext().getPageActivity());
        if (z) {
            this.fNh.a(new String[]{this.fFd.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0100b);
        } else {
            this.fNh.a(new String[]{this.fFd.getPageContext().getString(e.j.save_to_emotion), this.fFd.getPageContext().getString(e.j.save_to_local)}, interfaceC0100b);
        }
        this.fNh.d(this.fFd.getPageContext());
        this.fNh.yo();
    }

    public int bgz() {
        return ro(this.fMg.getFirstVisiblePosition());
    }

    private int ro(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fMg.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fMg.getAdapter() == null || !(this.fMg.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fMg.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bgA() {
        int lastVisiblePosition = this.fMg.getLastVisiblePosition();
        if (this.fLW != null) {
            if (lastVisiblePosition == this.fMg.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return ro(lastVisiblePosition);
    }

    public void rp(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fMg != null) {
            if (this.fMc == null || this.fMc.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fMc.mNavigationBar.getFixedNavHeight();
                if (!(this.fFd.bds() != -1)) {
                    if (this.fNG != null && (layoutParams = (LinearLayout.LayoutParams) this.fNG.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fNG.setLayoutParams(layoutParams);
                    }
                    i--;
                    bhf();
                }
                i2 = fixedNavHeight;
            }
            this.fMg.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fMg.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fMQ.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fMN.a(dVar, false);
        this.fMN.notifyDataSetChanged();
        bgH();
        if (this.fOm != null) {
            this.fOm.bcK();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fMw == null) {
            this.fFd.getLayoutMode().onModeChanged(((ViewStub) this.fMh.findViewById(e.g.praise_layout)).inflate());
            this.fMw = (FrsPraiseView) this.fMh.findViewById(e.g.pb_head_praise_view);
            this.fMw.setIsFromPb(true);
            this.fML = this.fMh.findViewById(e.g.new_pb_header_item_line_above_praise);
            this.fMw.dQ(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fMw != null) {
            boolean bgH = bgH();
            this.fMw.setVisibility(8);
            if (dVar != null && dVar.vy() != null && dVar.vy().vv() == 0 && this.fFu) {
                if (bgH) {
                    this.fMK.setVisibility(0);
                    return;
                } else {
                    this.fMK.setVisibility(8);
                    return;
                }
            }
            this.fMK.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bbT() != null) {
            return dVar.bbT();
        }
        if (!com.baidu.tbadk.core.util.v.z(dVar.bbL())) {
            Iterator<PostData> it = dVar.bbL().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.byM() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bbQ();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.wm() != null && postData.wm().getUserTbVipInfoData() != null && postData.wm().getUserTbVipInfoData().getvipIntro() != null) {
            postData.wm().getGodUserData().setIntro(postData.wm().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bbJ() == null || dVar.bbJ().wm() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData wm = dVar.bbJ().wm();
        String userId = wm.getUserId();
        HashMap<String, MetaData> userMap = dVar.bbJ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = wm;
        }
        postData.uj(1);
        postData.setId(dVar.bbJ().wD());
        postData.setTitle(dVar.bbJ().getTitle());
        postData.setTime(dVar.bbJ().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x031a  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String d;
        ArrayList<IconData> tShowInfoNew;
        int h;
        com.baidu.tbadk.data.f byP;
        String portrait;
        if (dVar != null && dVar.bbJ() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fMm.setVisibility(8);
            if (dVar.bbJ() != null && dVar.bbJ().xa() && dVar.bbJ().wE() != null) {
                this.fOa = true;
                this.fMc.le(this.fOa);
                this.fMc.mNavigationBar.hideBottomLine();
                if (this.fLW == null) {
                    this.fLW = new com.baidu.tieba.pb.video.i(this.fFd, this.fMc, dVar.bbJ().wE(), this.fLX);
                    this.fLW.a(dVar.bbJ().wE(), dVar.bbJ(), dVar.getForumId());
                    this.fLW.startPlay();
                } else if (this.fMa) {
                    this.fLW.a(dVar.bbJ().wE(), dVar.bbJ(), dVar.getForumId());
                    this.fLW.startPlay();
                } else {
                    this.fLW.so(dVar.getForumId());
                }
                if (dVar.bbK() != null && dVar.bbK().size() >= 1) {
                    bb bbVar = dVar.bbK().get(0);
                    this.fLW.as(bbVar);
                    this.fLW.sp(bbVar.getTitle());
                }
                this.fLW.b(b, dVar.bbJ(), dVar.bch());
                this.fMa = false;
                this.fMg.removeHeaderView(this.fLW.biW());
                this.fMg.addHeaderView(this.fLW.biW(), 0);
                if (this.fLW.biT() != null && this.fLW.biT().getParent() == null) {
                    this.fNE.addView(this.fLW.biT());
                }
                if (this.fLY == null) {
                    this.fLY = new com.baidu.tieba.pb.video.h(this.fFd);
                }
                this.fLY.a(dVar.bbJ().xp(), dVar.bbJ(), dVar.bce());
                this.fMg.removeHeaderView(this.fLY.biK());
                this.fMg.addHeaderView(this.fLY.biK(), 1);
                if (dVar.bbJ().xp() != null) {
                    this.fMg.removeHeaderView(this.fLY.biL());
                    this.fMg.removeHeaderView(this.fMk);
                    this.fMg.addHeaderView(this.fLY.biL(), 2);
                } else {
                    if (this.fLY.biL() != null) {
                        this.fMg.removeHeaderView(this.fLY.biL());
                    }
                    this.fMg.removeHeaderView(this.fMk);
                    this.fMk.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fFd, e.C0141e.tbds26));
                    this.fMg.addHeaderView(this.fMk, 2);
                }
                if (this.fLW != null) {
                    this.fMc.kY(false);
                    this.fMc.la(TbadkCoreApplication.isLogin());
                    this.fLW.rv(TbadkCoreApplication.getInst().getSkinType());
                }
                bgE();
            } else {
                this.fOa = false;
                this.fMc.le(this.fOa);
                if (this.fLW != null) {
                    this.fMg.removeHeaderView(this.fLW.biW());
                }
                if (this.fLY != null) {
                    this.fLY.b(this.fMg);
                }
                if (b == null || (b != null && (b.byO() == null || com.baidu.tbadk.core.util.v.z(b.byO().OP())))) {
                    this.fMk.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fFd, e.C0141e.tbds52));
                } else {
                    this.fMk.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fFd.bde() != null) {
                this.fFd.bde().kW(this.fOa);
            }
            if (this.fLW != null) {
                this.fLW.L(this.fOC);
                bhf();
            }
            if (b != null) {
                this.fNw = b;
                this.fMm.setVisibility(0);
                if (this.fFd.bcE()) {
                    if (dVar.bbI() != null) {
                        this.mForumName = dVar.bbI().getForumName();
                        this.mForumId = dVar.bbI().getForumId();
                    }
                    if (this.mForumName == null && this.fFd.bcO() != null && this.fFd.bcO().bcF() != null) {
                        this.mForumName = this.fFd.bcO().bcF();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fMm.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fMm.setTag(sparseArray);
                }
                sparseArray.put(e.g.tag_clip_board, b);
                sparseArray.put(e.g.tag_is_subpb, false);
                if (!this.fOr) {
                    this.fMi.setVisibility(0);
                }
                if (!dVar.bbJ().xa() && this.fMj.getText() != null && this.fMj.getText().length() > 0) {
                    this.fMj.setVisibility(0);
                } else {
                    this.fMj.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> wy = dVar.bbJ().wy();
                if (wy != null && wy.size() > 0 && !this.fOr) {
                    this.fNz.setText(String.valueOf(wy.get(0).uF()));
                    this.fNy.setVisibility(0);
                } else {
                    this.fNy.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.fNy, e.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.fNz, e.d.cp_link_tip_d, 1);
                if (b.wm() != null) {
                    String string = b.wm().getName_show() == null ? StringUtils.string(b.wm().getUserName()) : StringUtils.string(b.wm().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.wm().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bA(b.wm().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bA(string) > 12) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.wm().getIconInfo();
                            tShowInfoNew = b.wm().getTShowInfoNew();
                            if (this.fGo != null) {
                                this.fGo.setTag(e.g.tag_user_id, b.wm().getUserId());
                                this.fGo.setOnClickListener(this.fFd.fDh.fQv);
                                this.fGo.a(iconInfo, 4, this.fFd.getResources().getDimensionPixelSize(e.C0141e.tbds36), this.fFd.getResources().getDimensionPixelSize(e.C0141e.tbds36), this.fFd.getResources().getDimensionPixelSize(e.C0141e.tbds12));
                            }
                            if (this.fGn != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fGn.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fGn.setOnClickListener(this.fFd.fDh.fQw);
                                this.fGn.a(tShowInfoNew, 3, this.fFd.getResources().getDimensionPixelSize(e.C0141e.tbds36), this.fFd.getResources().getDimensionPixelSize(e.C0141e.tbds36), this.fFd.getResources().getDimensionPixelSize(e.C0141e.ds12), true);
                            }
                            this.fMo.setText(ap(b.wm().getSealPrefix(), d));
                            this.fMo.setTag(e.g.tag_user_id, b.wm().getUserId());
                            this.fMo.setTag(e.g.tag_user_name, b.wm().getName_show());
                            if (com.baidu.tbadk.core.util.v.z(tShowInfoNew) || b.wm().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.fMo, e.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.fMo, e.d.cp_cont_f, 1);
                            }
                            this.fMp.setVisibility(8);
                            if (dVar.bbJ().wm() != null && dVar.bbJ().wm().getAlaUserData() != null && this.fMu != null) {
                                if (dVar.bbJ().wm().getAlaUserData().anchor_live != 0) {
                                    this.fMu.setVisibility(8);
                                } else {
                                    this.fMu.setVisibility(0);
                                    if (this.fLZ == null) {
                                        this.fLZ = new com.baidu.tieba.c.d(this.fFd.getPageContext(), this.fMu);
                                        this.fLZ.jP(1);
                                    }
                                    this.fLZ.aW(this.fFd.getResources().getString(e.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.acu = dVar.bbJ().wm().getAlaUserData();
                                    aVar.type = 2;
                                    this.fMu.setTag(aVar);
                                }
                            }
                            this.fMt.setUserId(b.wm().getUserId());
                            this.fMt.setUserName(b.wm().getUserName());
                            this.fMt.setTid(b.getId());
                            this.fMt.setFid(this.fID == null ? this.fID.getForumId() : "");
                            this.fMt.setImageDrawable(null);
                            this.fMt.setRadius(com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds40));
                            this.fMt.setTag(b.wm().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fMC.setText(com.baidu.tbadk.core.util.ao.C(b.getTime()));
                            } else {
                                this.fMC.setText(com.baidu.tbadk.core.util.ao.A(b.getTime()));
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds16);
                            if (!this.fFd.bcE() && !StringUtils.isNull(this.mForumName)) {
                                this.aBk.setText(this.fFd.getString(e.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.aBk.setVisibility(0);
                                this.fMF.setVisibility(0);
                                this.fMC.setPadding(h, 0, h, 0);
                            } else {
                                this.aBk.setVisibility(8);
                                this.fMF.setVisibility(8);
                                this.fMC.setPadding(0, 0, h, 0);
                            }
                            byP = b.byP();
                            if (byP == null && !TextUtils.isEmpty(byP.getName()) && !TextUtils.isEmpty(byP.getName().trim())) {
                                final String name = byP.getName();
                                final String lat = byP.getLat();
                                final String lng = byP.getLng();
                                this.fMD.setVisibility(0);
                                this.fME.setVisibility(0);
                                this.fMD.setText(byP.getName());
                                this.fMD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kK()) {
                                                ar.this.fFd.showToast(e.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ae(ar.this.fFd.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, ar.this.fFd.getPageContext().getString(e.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fMD.setVisibility(8);
                                this.fME.setVisibility(8);
                            }
                            portrait = b.wm().getPortrait();
                            if (b.wm().getPendantData() == null && !StringUtils.isNull(b.wm().getPendantData().uW())) {
                                UtilHelper.showHeadImageViewBigV(this.fMr.getHeadView(), b.wm());
                                this.fMt.setVisibility(8);
                                this.fMr.setVisibility(0);
                                if (this.fMx != null) {
                                    this.fMx.setVisibility(8);
                                }
                                this.fMo.setOnClickListener(this.fOC);
                                this.fMr.getHeadView().startLoad(portrait, 28, false);
                                this.fMr.getHeadView().setUserId(b.wm().getUserId());
                                this.fMr.getHeadView().setUserName(b.wm().getUserName());
                                this.fMr.getHeadView().setTid(b.getId());
                                this.fMr.getHeadView().setFid(this.fID != null ? this.fID.getForumId() : "");
                                this.fMr.getHeadView().setOnClickListener(this.fOC);
                                this.fMr.fF(b.wm().getPendantData().uW());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fMt, b.wm());
                                this.fMt.setVisibility(0);
                                this.fMm.setOnClickListener(this.fOC);
                                this.fMo.setOnClickListener(this.fOC);
                                this.fMt.setOnClickListener(this.fOC);
                                this.fMr.setVisibility(8);
                                this.fMt.startLoad(portrait, 28, false);
                            }
                            String name_show = b.wm().getName_show();
                            String userName = b.wm().getUserName();
                            if (com.baidu.tbadk.p.am.jw() && name_show != null && !name_show.equals(userName)) {
                                this.fMo.setText(com.baidu.tieba.pb.c.aB(this.fFd.getPageContext().getPageActivity(), this.fMo.getText().toString()));
                                this.fMo.setGravity(16);
                                this.fMo.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bbr());
                                com.baidu.tbadk.core.util.al.c(this.fMo, e.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.wm().getIconInfo();
                        tShowInfoNew = b.wm().getTShowInfoNew();
                        if (this.fGo != null) {
                        }
                        if (this.fGn != null) {
                        }
                        this.fMo.setText(ap(b.wm().getSealPrefix(), d));
                        this.fMo.setTag(e.g.tag_user_id, b.wm().getUserId());
                        this.fMo.setTag(e.g.tag_user_name, b.wm().getName_show());
                        if (com.baidu.tbadk.core.util.v.z(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fMo, e.d.cp_cont_h, 1);
                        this.fMp.setVisibility(8);
                        if (dVar.bbJ().wm() != null) {
                            if (dVar.bbJ().wm().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fMt.setUserId(b.wm().getUserId());
                        this.fMt.setUserName(b.wm().getUserName());
                        this.fMt.setTid(b.getId());
                        this.fMt.setFid(this.fID == null ? this.fID.getForumId() : "");
                        this.fMt.setImageDrawable(null);
                        this.fMt.setRadius(com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds40));
                        this.fMt.setTag(b.wm().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds16);
                        if (!this.fFd.bcE()) {
                        }
                        this.aBk.setVisibility(8);
                        this.fMF.setVisibility(8);
                        this.fMC.setPadding(0, 0, h, 0);
                        byP = b.byP();
                        if (byP == null) {
                        }
                        this.fMD.setVisibility(8);
                        this.fME.setVisibility(8);
                        portrait = b.wm().getPortrait();
                        if (b.wm().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fMt, b.wm());
                        this.fMt.setVisibility(0);
                        this.fMm.setOnClickListener(this.fOC);
                        this.fMo.setOnClickListener(this.fOC);
                        this.fMt.setOnClickListener(this.fOC);
                        this.fMr.setVisibility(8);
                        this.fMt.startLoad(portrait, 28, false);
                        String name_show2 = b.wm().getName_show();
                        String userName2 = b.wm().getUserName();
                        if (com.baidu.tbadk.p.am.jw()) {
                            this.fMo.setText(com.baidu.tieba.pb.c.aB(this.fFd.getPageContext().getPageActivity(), this.fMo.getText().toString()));
                            this.fMo.setGravity(16);
                            this.fMo.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bbr());
                            com.baidu.tbadk.core.util.al.c(this.fMo, e.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bA(string) > 14) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.wm().getIconInfo();
                            tShowInfoNew = b.wm().getTShowInfoNew();
                            if (this.fGo != null) {
                            }
                            if (this.fGn != null) {
                            }
                            this.fMo.setText(ap(b.wm().getSealPrefix(), d));
                            this.fMo.setTag(e.g.tag_user_id, b.wm().getUserId());
                            this.fMo.setTag(e.g.tag_user_name, b.wm().getName_show());
                            if (com.baidu.tbadk.core.util.v.z(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.fMo, e.d.cp_cont_h, 1);
                            this.fMp.setVisibility(8);
                            if (dVar.bbJ().wm() != null) {
                            }
                            this.fMt.setUserId(b.wm().getUserId());
                            this.fMt.setUserName(b.wm().getUserName());
                            this.fMt.setTid(b.getId());
                            this.fMt.setFid(this.fID == null ? this.fID.getForumId() : "");
                            this.fMt.setImageDrawable(null);
                            this.fMt.setRadius(com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds40));
                            this.fMt.setTag(b.wm().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds16);
                            if (!this.fFd.bcE()) {
                            }
                            this.aBk.setVisibility(8);
                            this.fMF.setVisibility(8);
                            this.fMC.setPadding(0, 0, h, 0);
                            byP = b.byP();
                            if (byP == null) {
                            }
                            this.fMD.setVisibility(8);
                            this.fME.setVisibility(8);
                            portrait = b.wm().getPortrait();
                            if (b.wm().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fMt, b.wm());
                            this.fMt.setVisibility(0);
                            this.fMm.setOnClickListener(this.fOC);
                            this.fMo.setOnClickListener(this.fOC);
                            this.fMt.setOnClickListener(this.fOC);
                            this.fMr.setVisibility(8);
                            this.fMt.startLoad(portrait, 28, false);
                            String name_show22 = b.wm().getName_show();
                            String userName22 = b.wm().getUserName();
                            if (com.baidu.tbadk.p.am.jw()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.wm().getIconInfo();
                        tShowInfoNew = b.wm().getTShowInfoNew();
                        if (this.fGo != null) {
                        }
                        if (this.fGn != null) {
                        }
                        this.fMo.setText(ap(b.wm().getSealPrefix(), d));
                        this.fMo.setTag(e.g.tag_user_id, b.wm().getUserId());
                        this.fMo.setTag(e.g.tag_user_name, b.wm().getName_show());
                        if (com.baidu.tbadk.core.util.v.z(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fMo, e.d.cp_cont_h, 1);
                        this.fMp.setVisibility(8);
                        if (dVar.bbJ().wm() != null) {
                        }
                        this.fMt.setUserId(b.wm().getUserId());
                        this.fMt.setUserName(b.wm().getUserName());
                        this.fMt.setTid(b.getId());
                        this.fMt.setFid(this.fID == null ? this.fID.getForumId() : "");
                        this.fMt.setImageDrawable(null);
                        this.fMt.setRadius(com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds40));
                        this.fMt.setTag(b.wm().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fFd.getActivity(), e.C0141e.ds16);
                        if (!this.fFd.bcE()) {
                        }
                        this.aBk.setVisibility(8);
                        this.fMF.setVisibility(8);
                        this.fMC.setPadding(0, 0, h, 0);
                        byP = b.byP();
                        if (byP == null) {
                        }
                        this.fMD.setVisibility(8);
                        this.fME.setVisibility(8);
                        portrait = b.wm().getPortrait();
                        if (b.wm().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fMt, b.wm());
                        this.fMt.setVisibility(0);
                        this.fMm.setOnClickListener(this.fOC);
                        this.fMo.setOnClickListener(this.fOC);
                        this.fMt.setOnClickListener(this.fOC);
                        this.fMr.setVisibility(8);
                        this.fMt.startLoad(portrait, 28, false);
                        String name_show222 = b.wm().getName_show();
                        String userName222 = b.wm().getUserName();
                        if (com.baidu.tbadk.p.am.jw()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fMl.ak(dVar.bbJ());
                }
                if (this.fNH != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fAN);
                    if (dVar != null && dVar.bbJ() != null) {
                        hVar.fAP = dVar.bbJ().wd();
                    }
                    hVar.isNew = !this.fFu;
                    hVar.sortType = dVar.fAE;
                    if (dVar.fAD != null && dVar.fAD.size() > dVar.fAE) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.fAD.size()) {
                                break;
                            } else if (dVar.fAD.get(i4).sort_type.intValue() != dVar.fAE) {
                                i3 = i4 + 1;
                            } else {
                                hVar.fAR = dVar.fAD.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.fAS = this.fFd.bdQ();
                    this.fNH.a(hVar);
                }
            }
        }
    }

    public void kI(boolean z) {
        if (z) {
            bgB();
        } else {
            aqM();
        }
        this.fNL.fOV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fNL));
        a(this.fNL.fOV, false);
    }

    public void bgB() {
        if (this.fMc != null && !this.fOc) {
            this.fMc.lf(!StringUtils.isNull(this.fFd.bdp()));
            this.fOc = true;
        }
    }

    public void aqM() {
        if (this.fMc != null) {
            this.fMc.bhL();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.wI() != null) {
            this.fMn.setData(this.fFd.getPageContext(), dVar.bbL().get(0).wI(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.bbH().getId(), dVar.bbH().getName(), dVar.bbJ().getId(), this.fFd.bdN() ? "FRS" : null));
            this.fMm.setPadding(this.fMm.getPaddingLeft(), (int) this.fFd.getResources().getDimension(e.C0141e.ds20), this.fMm.getPaddingRight(), this.fMm.getPaddingBottom());
            return;
        }
        this.fMn.setData(null, null, null);
    }

    public void bgC() {
        if (this.fLW != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").w("obj_type", 1));
            this.fLW.biU();
            this.fMg.smoothScrollToPosition(0);
        }
    }

    public boolean bgD() {
        return this.fOD;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.wm() == null || bbVar.wm().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.wm().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fMc.bhJ();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fMc.pP(cVar.forumName);
            }
            String string = this.fFd.getResources().getString(e.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.fFd.getResources().getString(e.j.self);
                    break;
                case 300:
                    str = this.fFd.getResources().getString(e.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fFd.getResources().getString(e.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fzV;
            this.fFd.showNetRefreshView(this.cYo, format, null, this.fFd.getResources().getString(e.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lb()) {
                        ay.AN().c(ar.this.fFd.getPageContext(), new String[]{str2});
                        ar.this.fFd.finish();
                        return;
                    }
                    ar.this.fFd.showToast(e.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bfM;
        Parcelable bfM2;
        String str;
        if (dVar != null) {
            this.fID = dVar;
            this.mType = i;
            if (dVar.bbJ() != null) {
                this.fNN = dVar.bbJ().vV();
                if (dVar.bbJ().getAnchorLevel() != 0) {
                    this.fOD = true;
                }
                this.fNj = am(dVar.bbJ());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fNx = false;
            this.fFu = z;
            bgx();
            b(dVar, z, i);
            p(dVar);
            if (this.fOp == null) {
                this.fOp = new ac(this.fFd.getPageContext(), this.dOy);
            }
            this.fOp.rV(dVar.bbO());
            if (this.fFd.bdE()) {
                if (this.fMR == null) {
                    this.fMR = new com.baidu.tieba.pb.view.d(this.fFd.getPageContext());
                    this.fMR.ov();
                    this.fMR.a(this.azG);
                }
                this.fMg.setPullRefresh(this.fMR);
                bgE();
                if (this.fMR != null) {
                    this.fMR.dM(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.vy().vv() == 0 && z) {
                this.fMg.setPullRefresh(null);
            } else {
                if (this.fMR == null) {
                    this.fMR = new com.baidu.tieba.pb.view.d(this.fFd.getPageContext());
                    this.fMR.ov();
                    this.fMR.a(this.azG);
                }
                this.fMg.setPullRefresh(this.fMR);
                bgE();
                if (this.fMR != null) {
                    this.fMR.dM(TbadkCoreApplication.getInst().getSkinType());
                }
                agD();
            }
            bgH();
            this.fMN.jV(this.fFu);
            this.fMN.jW(false);
            this.fMN.kh(i == 5);
            this.fMN.ki(i == 6);
            this.fMN.kj(z2 && this.fOB);
            this.fMN.a(dVar, false);
            this.fMN.notifyDataSetChanged();
            if (this.fFd.bcE()) {
                this.fOe = 0;
                PostData b = b(dVar, z);
                if (b != null && b.wm() != null) {
                    this.fOe = b.wm().getLevel_id();
                }
                if (this.fOe > 0) {
                    this.fMq.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.fMq, BitmapHelper.getGradeResourceIdInEnterForum(this.fOe));
                } else {
                    this.fMq.setVisibility(8);
                }
            } else {
                this.fMq.setVisibility(8);
            }
            if (dVar.bbJ() != null) {
                if (dVar.bbJ().vZ() != null) {
                    if (dVar.bbJ().vZ().getNum() < 1) {
                        str = this.fFd.getResources().getString(e.j.zan);
                    } else {
                        str = dVar.bbJ().vZ().getNum() + "";
                    }
                    if (this.fLV != -1) {
                        dVar.bbJ().vZ().setIsLike(this.fLV);
                    }
                    N(str, dVar.bbJ().vZ().getIsLike() == 1);
                }
                if (dVar.bbJ().aml != null && dVar.bbJ().aml.isDeleted) {
                    this.fMc.kZ(true);
                } else {
                    this.fMc.kZ(false);
                }
            }
            if (this.fFd.isLogin()) {
                this.fMg.setNextPage(this.dxP);
                this.fMb = 2;
                agD();
            } else {
                this.fNx = true;
                if (dVar.vy().vu() == 1) {
                    if (this.fMS == null) {
                        this.fMS = new com.baidu.tieba.pb.view.a(this.fFd.getPageContext());
                    }
                    this.fMg.setNextPage(this.fMS);
                } else {
                    this.fMg.setNextPage(this.dxP);
                }
                this.fMb = 3;
            }
            ArrayList<PostData> bbL = dVar.bbL();
            if (dVar.vy().vu() == 0 || bbL == null || bbL.size() < dVar.vy().vt()) {
                if (com.baidu.tbadk.core.util.v.y(bbL) == 0 || (com.baidu.tbadk.core.util.v.y(bbL) == 1 && bbL.get(0) != null && bbL.get(0).byM() == 1)) {
                    this.dxP.setText(this.fFd.getResources().getString(e.j.list_no_more_new));
                    if (this.fFd.bde() != null && !this.fFd.bde().bhz()) {
                        this.fFd.bde().showFloatingView();
                    }
                } else if (dVar.vy().vu() == 0) {
                    this.dxP.setText(this.fFd.getResources().getString(e.j.list_has_no_more));
                } else {
                    this.dxP.setText(this.fFd.getResources().getString(e.j.load_more));
                }
                if (this.fFd.bdE() && this.fMg != null && this.fMg.getData() != null && this.fMg.getData().size() == 1 && (this.fMg.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dxP.setText("");
                }
                bgO();
            } else if (z2) {
                if (this.fOB) {
                    BJ();
                    if (dVar.vy().vu() != 0) {
                        this.dxP.setText(this.fFd.getResources().getString(e.j.pb_load_more));
                    }
                } else {
                    this.dxP.BE();
                    this.dxP.showLoading();
                }
            } else {
                this.dxP.BE();
                this.dxP.showLoading();
            }
            switch (i) {
                case 2:
                    this.fMg.setSelection(i2 > 1 ? (((this.fMg.getData() == null && dVar.bbL() == null) ? 0 : (this.fMg.getData().size() - dVar.bbL().size()) + this.fMg.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bfM2 = aj.bfL().bfM()) != null) {
                        this.fMg.onRestoreInstanceState(bfM2);
                        if (com.baidu.tbadk.core.util.v.y(bbL) > 1 && dVar.vy().vu() > 0) {
                            this.dxP.BJ();
                            this.dxP.setText(this.fFd.getString(e.j.pb_load_more_without_point));
                            this.dxP.BF();
                            break;
                        }
                    } else {
                        this.fMg.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fOB = false;
                    break;
                case 5:
                    this.fMg.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bfM = aj.bfL().bfM()) != null) {
                        this.fMg.onRestoreInstanceState(bfM);
                        break;
                    } else {
                        this.fMg.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.fLW != null && this.fLW.biT() != null) {
                            if (this.fFd.isUseStyleImmersiveSticky()) {
                                this.fMg.setSelectionFromTop((this.fMN.bei() + this.fMg.getHeaderViewsCount()) - 1, this.fLW.biT().getHeight() - com.baidu.adp.lib.util.l.r(this.fFd.getPageContext().getPageActivity()));
                            } else {
                                this.fMg.setSelectionFromTop((this.fMN.bei() + this.fMg.getHeaderViewsCount()) - 1, this.fLW.biT().getHeight());
                            }
                        } else {
                            this.fMg.setSelection(this.fMN.bei() + this.fMg.getHeaderViewsCount());
                        }
                    } else {
                        this.fMg.setSelection(i2 > 0 ? ((this.fMg.getData() == null && dVar.bbL() == null) ? 0 : (this.fMg.getData().size() - dVar.bbL().size()) + this.fMg.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dxP.BJ();
                    this.dxP.setText(this.fFd.getString(e.j.pb_load_more_without_point));
                    this.dxP.BF();
                    break;
            }
            if (this.fNN == fNO && isHost()) {
                bgW();
            }
            if (this.fNY) {
                bfV();
                this.fNY = false;
                if (i3 == 0) {
                    kB(true);
                }
            }
            if (this.fLY != null) {
                this.fLY.ar(dVar.bbJ());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fAB == 1 || dVar.fAC == 1) {
                if (this.fOf == null) {
                    this.fOf = new PbTopTipView(this.fFd);
                }
                if (dVar.fAC == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fFd.getStType())) {
                    this.fOf.setText(this.fFd.getString(e.j.pb_read_strategy_add_experience));
                    this.fOf.show(this.cYo, this.mSkinType);
                } else if (dVar.fAB == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fFd.getStType())) {
                    this.fOf.setText(this.fFd.getString(e.j.pb_read_news_add_experience));
                    this.fOf.show(this.cYo, this.mSkinType);
                }
            }
        }
    }

    private void bgE() {
        if (this.fLW != null && this.fLW.biT() != null) {
            this.fMg.removeHeaderView(this.aLH);
            if (this.mType != 1) {
                this.fMg.removeHeaderView(this.fLW.biW());
                this.fMg.addHeaderView(this.fLW.biW(), 0);
                return;
            }
            return;
        }
        if (this.fLW != null) {
            this.fMg.removeHeaderView(this.fLW.biW());
        }
        this.fMg.removeHeaderView(this.aLH);
        this.fMg.addHeaderView(this.aLH, 0);
    }

    public void kJ(boolean z) {
        this.fNi = z;
    }

    public void BJ() {
        if (this.dxP != null) {
            this.dxP.BF();
            this.dxP.BJ();
        }
        agD();
    }

    public void aiB() {
        this.fMg.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fNw != null && this.fNw.wm() != null && this.fMc != null) {
            this.fOb = !this.fOa;
            this.fMc.kY(this.fOb);
            if (this.fFd.bde() != null) {
                this.fFd.bde().kX(this.fOb);
            }
            bgF();
            if (this.fOb) {
                this.fMc.fRi.setVisibility(0);
                if (this.fNj) {
                    this.fMc.fRj.setVisibility(8);
                    this.fMy.setVisibility(8);
                    this.fMB.setVisibility(0);
                    this.fMB.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.H(dVar.bcg())));
                } else if (!PbNormalLikeButtonSwitchStatic.Mr() || (this.fNw.wm().hadConcerned() && this.fNw.wm().getGodUserData() != null && this.fNw.wm().getGodUserData().getIsFromNetWork())) {
                    this.fMc.fRj.setVisibility(8);
                }
                if (this.fNG != null) {
                    this.fNG.setVisibility(8);
                }
                this.fMc.a(this.fNw.wm(), this.fOC);
                if (this.fOn == null) {
                    this.fOn = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fOd) {
                                ar.this.bgV();
                            }
                            ar.this.bgy();
                        }
                    };
                }
                this.fMg.setListViewDragListener(this.fOn);
                return;
            }
            if (this.fMc.fRi != null) {
                this.fMc.fRi.setVisibility(8);
            }
            if (this.fNG != null) {
                this.fNG.setVisibility(0);
            }
            if (this.fNj) {
                this.fMy.setVisibility(8);
                this.fMB.setVisibility(0);
                this.fMB.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.H(dVar.bcg())));
            } else if (!PbNormalLikeButtonSwitchStatic.Mr() || (this.fNw.wm().hadConcerned() && this.fNw.wm().getGodUserData() != null && this.fNw.wm().getGodUserData().getIsFromNetWork())) {
                this.fMy.setVisibility(8);
                this.fMB.setVisibility(8);
            } else {
                this.fMB.setVisibility(8);
            }
            this.fOn = null;
            this.fMg.setListViewDragListener(null);
        }
    }

    private void bgF() {
        String threadId = this.fID != null ? this.fID.getThreadId() : "";
        int bgG = bgG();
        if (this.fOb) {
            if (this.fMA == null) {
                this.fMA = new ap(this.fFd.getPageContext(), this.fMc.fRj, 3);
                this.fMA.h(this.fFd.getUniqueId());
            }
            if (this.fNw != null && this.fNw.wm() != null) {
                this.fNw.wm().setIsLike(this.fNw.wm().hadConcerned());
                this.fMA.a(this.fNw.wm());
            }
            this.fMA.setTid(threadId);
            this.fMA.rn(bgG);
            this.fMA.fLR = this.fOa;
        }
        if (this.fMz == null) {
            this.fMz = new ap(this.fFd.getPageContext(), this.fMy, 1);
            this.fMz.h(this.fFd.getUniqueId());
            this.fMz.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bj(boolean z) {
                    if (ar.this.fFd != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fFd, e.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fFd.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fNw != null && this.fNw.wm() != null) {
            this.fNw.wm().setIsLike(this.fNw.wm().hadConcerned());
            this.fMz.a(this.fNw.wm());
            this.fMz.setTid(threadId);
        }
        this.fMz.fLR = this.fOa;
        this.fMz.rn(bgG);
    }

    public int bgG() {
        if (this.fID == null || this.fID.bbJ() == null) {
            return 0;
        }
        if (this.fID.bbJ().xx()) {
            return (com.baidu.tbadk.core.util.v.z(this.fID.bcf()) && (this.fID.bbI() == null || StringUtils.isNull(this.fID.bbI().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bgH() {
        boolean z;
        if (this.fNm != null && this.fNm.getVisibility() == 0) {
            if (this.fMJ != null) {
                this.fMJ.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fMJ != null) {
                this.fMJ.setVisibility(8);
            }
            z = false;
        }
        if ((this.fML == null || this.fML.getVisibility() == 8) && z && this.fFu) {
            this.fMK.setVisibility(0);
        } else {
            this.fMK.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bbJ() == null) {
            return false;
        }
        if (dVar.bbJ().wj() == 1 || dVar.bbJ().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bbJ().wl() == null || dVar.bbJ().wl().xZ() == 0) || dVar.bbJ().wh() == 1 || dVar.bbJ().wi() == 1 || dVar.bbJ().wR() || dVar.bbJ().xe() || dVar.bbJ().wZ() || dVar.bbJ().wz() != null || !com.baidu.tbadk.core.util.ao.isEmpty(dVar.bbJ().getCategory()) || dVar.bbJ().wp() || dVar.bbJ().wo();
    }

    private SpannableStringBuilder ap(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fFd.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fMi != null) {
                if (dVar.bbJ() != null && dVar.bbJ().wC() == 0 && !dVar.bbJ().xa() && !this.fOr) {
                    this.fMi.setVisibility(0);
                    if (dVar.bbJ() != null) {
                        bb bbJ = dVar.bbJ();
                        bbJ.g(true, q(dVar));
                        bbJ.setResource(3);
                        bbJ.dD("2");
                    }
                    SpannableStringBuilder wM = dVar.bbJ().wM();
                    this.fMj.setOnTouchListener(new com.baidu.tieba.view.k(wM));
                    this.fMj.setText(wM);
                    this.fMj.setVisibility(0);
                } else if (dVar.bbJ().wC() == 1) {
                    if (dVar.bbJ() != null) {
                        this.fMi.setVisibility(8);
                        this.fMg.removeHeaderView(this.fMi);
                        if (dVar.bbJ() != null && !dVar.bbJ().xa()) {
                            this.fMm.setPadding(this.fMm.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.tbds36), this.fMm.getPaddingRight(), this.fMm.getPaddingBottom());
                        }
                    }
                } else {
                    this.fMi.setVisibility(8);
                    this.fMg.removeHeaderView(this.fMi);
                    if (dVar.bbJ() != null && dVar.bbJ().xa()) {
                        this.fMm.setPadding(this.fMm.getPaddingLeft(), 0, this.fMm.getPaddingRight(), this.fMm.getPaddingBottom());
                    } else {
                        this.fMm.setPadding(this.fMm.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds48), this.fMm.getPaddingRight(), this.fMm.getPaddingBottom());
                    }
                }
            }
            this.fFu = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bgH();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.wm().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bbV()));
                sparseArray.put(e.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.wm() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, b.wm().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, b.wm().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, b.wm().getPortrait());
                    sparseArray.put(e.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bbV()));
                sparseArray.put(e.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.ay> bcf = dVar.bcf();
                if (com.baidu.tbadk.core.util.v.y(bcf) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.ay ayVar : bcf) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ajR) != null && tVar.ahQ && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(this.fFd.getString(e.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(e.g.tag_del_multi_forum, String.format(this.fFd.getString(e.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.aWu;
    }

    public void rW(String str) {
        if (this.dxP != null) {
            this.dxP.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fMg;
    }

    public int bgI() {
        return e.g.richText;
    }

    public TextView bcZ() {
        return this.fMl.bcZ();
    }

    public void e(BdListView.e eVar) {
        this.fMg.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.azG = bVar;
        if (this.fMR != null) {
            this.fMR.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int vs = alVar.vs();
            int vp = alVar.vp();
            if (this.fMO != null) {
                this.fMO.yl();
            } else {
                this.fMO = new com.baidu.tbadk.core.dialog.a(this.fFd.getPageContext().getPageActivity());
                this.fMP = LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.dialog_direct_pager, (ViewGroup) null);
                this.fMO.G(this.fMP);
                this.fMO.a(e.j.dialog_ok, bVar);
                this.fMO.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bgK();
                        aVar.dismiss();
                    }
                });
                this.fMO.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fNV == null) {
                            ar.this.fNV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fFd.HidenSoftKeyPad((InputMethodManager) ar.this.fFd.getSystemService("input_method"), ar.this.cYo);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jt().postDelayed(ar.this.fNV, 150L);
                    }
                });
                this.fMO.b(this.fFd.getPageContext()).yl();
            }
            this.fMQ = (EditText) this.fMP.findViewById(e.g.input_page_number);
            this.fMQ.setText("");
            TextView textView = (TextView) this.fMP.findViewById(e.g.current_page_number);
            if (vs <= 0) {
                vs = 1;
            }
            if (vp <= 0) {
                vp = 1;
            }
            textView.setText(MessageFormat.format(this.fFd.getApplicationContext().getResources().getString(e.j.current_page), Integer.valueOf(vs), Integer.valueOf(vp)));
            this.fFd.ShowSoftKeyPadDelay(this.fMQ, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fMg.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fFd.showToast(str);
    }

    public boolean kK(boolean z) {
        if (this.SG == null || !this.SG.IM()) {
            return false;
        }
        this.SG.Hf();
        return true;
    }

    public void bgJ() {
        if (this.fOE != null) {
            while (this.fOE.size() > 0) {
                TbImageView remove = this.fOE.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bgJ();
        this.fMN.qY(1);
        if (this.fLW != null) {
            this.fLW.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.fMN.qY(2);
        if (this.fLW != null) {
            this.fLW.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fNX != null) {
            this.fNX.destroy();
        }
        if (this.fOp != null) {
            this.fOp.onDestory();
        }
        if (this.fOf != null) {
            this.fOf.hide();
        }
        if (this.fLZ != null) {
            this.fLZ.amz();
        }
        if (this.fLY != null) {
            this.fLY.onDestroy();
        }
        this.fFd.hideProgressBar();
        if (this.cYm != null && this.dpW != null) {
            this.cYm.b(this.dpW);
        }
        bgK();
        BJ();
        if (this.fNV != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fNV);
        }
        if (this.fMm != null && this.fMx != null) {
            this.fMm.removeView(this.fMs);
            this.fMx = null;
        }
        if (this.fNB != null) {
            this.fNB.clearStatus();
        }
        this.fOx = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fMN.qY(3);
        if (this.dus != null) {
            this.dus.setBackgroundDrawable(null);
        }
        if (this.fLW != null) {
            this.fLW.destroy();
        }
        if (this.fMN != null) {
            this.fMN.onDestroy();
        }
        this.fMg.setOnLayoutListener(null);
        if (this.fOl != null) {
            this.fOl.ayC();
        }
        if (this.fNM != null) {
            this.fNM.onDestroy();
        }
        bhg();
    }

    public boolean rq(int i) {
        if (this.fLW != null) {
            return this.fLW.lo(i);
        }
        return false;
    }

    public void bgK() {
        this.fMc.tF();
        if (this.fLZ != null) {
            this.fLZ.amz();
        }
        com.baidu.adp.lib.util.l.a(this.fFd.getPageContext().getPageActivity(), this.fMQ);
        bfX();
        if (this.fNg != null) {
            this.fNg.dismiss();
        }
        bgM();
        if (this.fLY != null) {
            this.fLY.biM();
        }
        if (this.fMO != null) {
            this.fMO.dismiss();
        }
        if (this.duc != null) {
            this.duc.dismiss();
        }
    }

    public void bgL() {
        this.fMc.tF();
        if (this.fLZ != null) {
            this.fLZ.amz();
        }
        if (this.fNg != null) {
            this.fNg.dismiss();
        }
        bgM();
        if (this.fLY != null) {
            this.fLY.biM();
        }
        if (this.fMO != null) {
            this.fMO.dismiss();
        }
        if (this.duc != null) {
            this.duc.dismiss();
        }
    }

    public void cX(List<String> list) {
        this.fOk = list;
        if (this.fOl != null) {
            this.fOl.setData(list);
        }
    }

    public void jU(boolean z) {
        this.fMN.jU(z);
    }

    public void kL(boolean z) {
        this.fNl = z;
    }

    public void bgM() {
        if (this.fMX != null) {
            this.fMX.dismiss();
        }
        if (this.fMY != null) {
            com.baidu.adp.lib.g.g.b(this.fMY, this.fFd.getPageContext());
        }
        if (this.fMZ != null) {
            com.baidu.adp.lib.g.g.b(this.fMZ, this.fFd.getPageContext());
        }
        if (this.fMV != null) {
            com.baidu.adp.lib.g.g.b(this.fMV, this.fFd.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fID, this.fFu);
            d(this.fID, this.fFu, this.mType);
            this.fFd.getLayoutMode().setNightMode(i == 1);
            this.fFd.getLayoutMode().onModeChanged(this.cYo);
            this.fFd.getLayoutMode().onModeChanged(this.fMh);
            if (this.fLY != null) {
                this.fLY.onChangeSkinType(i);
            }
            if (this.fMj != null) {
                com.baidu.tbadk.core.util.al.h(this.fMj, e.d.cp_cont_b);
                this.fMj.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            }
            if (this.dxP != null) {
                this.dxP.dM(i);
                if (this.aWu != null) {
                    this.fFd.getLayoutMode().onModeChanged(this.aWu);
                    com.baidu.tbadk.core.util.al.i(this.aWu, e.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fMO != null) {
                this.fMO.c(this.fFd.getPageContext());
            }
            kJ(this.fNi);
            this.fMN.notifyDataSetChanged();
            if (this.fMR != null) {
                this.fMR.dM(i);
            }
            if (this.SG != null) {
                this.SG.onChangeSkinType(i);
            }
            if (this.fMw != null) {
                this.fMw.dQ(i);
            }
            if (this.fMS != null) {
                this.fMS.dM(i);
            }
            if (!com.baidu.tbadk.core.util.v.z(this.cGZ)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cGZ) {
                    customBlueCheckRadioButton.Br();
                }
            }
            kF(i == 1);
            bgm();
            UtilHelper.setStatusBarBackground(this.dus, i);
            UtilHelper.setStatusBarBackground(this.fNG, i);
            if (this.fMy != null) {
                this.fMy.onChangeSkinType(i);
            }
            if (this.fMD != null) {
                com.baidu.tbadk.core.util.al.h(this.fMD, e.d.cp_cont_d);
            }
            if (this.fMC != null) {
                com.baidu.tbadk.core.util.al.h(this.fMC, e.d.cp_cont_d);
            }
            if (this.fME != null) {
                com.baidu.tbadk.core.util.al.i(this.fME, e.d.cp_cont_e);
            }
            if (this.aBk != null) {
                com.baidu.tbadk.core.util.al.h(this.aBk, e.d.cp_cont_d);
            }
            if (this.fMF != null) {
                com.baidu.tbadk.core.util.al.i(this.fMF, e.d.cp_cont_e);
            }
            if (this.fMp != null) {
                com.baidu.tbadk.core.util.al.h(this.fMp, e.d.cp_link_tip_a);
            }
            if (this.fMB != null) {
                com.baidu.tbadk.core.util.al.h(this.fMB, e.d.cp_cont_d);
            }
            if (this.fMG != null) {
                com.baidu.tbadk.o.a.a(this.fFd.getPageContext(), this.fMG);
            }
            if (this.fNe != null) {
                com.baidu.tbadk.o.a.a(this.fFd.getPageContext(), this.fNe);
            }
            if (this.fNW != null) {
                this.fNW.onChangeSkinType(i);
            }
            if (this.fMc != null) {
                if (this.fLW != null) {
                    this.fLW.rv(i);
                } else {
                    this.fMc.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fNo != null) {
                com.baidu.tbadk.core.util.al.h(this.fNo, e.d.cp_cont_e);
            }
            if (this.fMq != null) {
                com.baidu.tbadk.core.util.al.c(this.fMq, BitmapHelper.getGradeResourceIdInEnterForum(this.fOe));
            }
            if (this.fOm != null) {
                this.fOm.onChangeSkinType(i);
            }
            if (this.fNM != null) {
                this.fNM.onChangeSkinType();
            }
            if (this.fOi != null) {
                com.baidu.tbadk.core.util.al.h(this.fOi, e.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bjz = hVar;
        this.fMN.setOnImageClickListener(this.bjz);
        this.fOm.setOnImageClickListener(this.bjz);
    }

    public void h(NoNetworkView.a aVar) {
        this.dpW = aVar;
        if (this.cYm != null) {
            this.cYm.a(this.dpW);
        }
    }

    public void kM(boolean z) {
        this.fMN.setIsFromCDN(z);
    }

    public Button bgN() {
        return this.fNm;
    }

    public void bgO() {
        if (this.fMb != 2) {
            this.fMg.setNextPage(this.dxP);
            this.fMb = 2;
        }
    }

    public void bgP() {
        if (com.baidu.tbadk.l.m.LZ().Ma()) {
            int lastVisiblePosition = this.fMg.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fMg.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(e.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.fx(1001);
                                perfLog.aWZ = true;
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
                        perfLog2.fx(1001);
                        perfLog2.aWZ = true;
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

    public boolean bgQ() {
        return this.SG != null && this.SG.getVisibility() == 0;
    }

    public boolean bgR() {
        return this.SG != null && this.SG.IM();
    }

    public void bgS() {
        if (this.SG != null) {
            this.SG.Hf();
        }
    }

    public void kN(boolean z) {
        if (this.fNn != null) {
            kL(this.fFd.bda().Jp());
            if (this.fNl) {
                kC(z);
            } else {
                kD(z);
            }
        }
    }

    public void bgT() {
        if (this.fNn != null) {
            this.fNn.setVisibility(8);
            this.fNs = false;
            if (this.fNM != null) {
                this.fNM.setVisibility(8);
                kH(false);
            }
            bhg();
        }
    }

    public void showLoadingDialog() {
        if (this.cOv == null) {
            this.cOv = new com.baidu.tbadk.core.view.d(this.fFd.getPageContext());
        }
        this.cOv.aZ(true);
    }

    public void agD() {
        if (this.cOv != null) {
            this.cOv.aZ(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fMg.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fMg.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fLW != null) {
            this.fLW.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.fOF = getScrollY();
            this.fNL.fOV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fNL));
            a(this.fNL.fOV, true);
        }
    }

    public void kO(boolean z) {
        this.fLW.kO(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fLW != null) {
            this.fLW.b(absListView, i);
        }
        int headerViewsCount = (i - this.fMg.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (headerViewsCount <= i2 && this.fMN.qX(headerViewsCount) != com.baidu.tieba.pb.data.i.fAT) {
            headerViewsCount++;
        }
        boolean z = i < this.fMg.getHeaderViewsCount();
        if (this.fMk != null && this.fMc != null) {
            this.fMc.g(this.fMk.getBottom(), this.fMk.getMeasuredHeight(), z);
        }
        this.fNL.fvA = i;
        this.fNL.fOU = this.fMg.getHeaderViewsCount();
        this.fNL.fOV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fNL));
        a(this.fNL.fOV, false);
    }

    public void bgU() {
        if (this.fFd.isLogin() && this.fID != null && this.fOb && !this.fOa && !this.fNj && this.fNw != null && this.fNw.wm() != null && !this.fNw.wm().getIsLike() && !this.fNw.wm().hadConcerned()) {
            if (this.fNX == null) {
                this.fNX = new an(this.fFd);
            }
            this.fNX.a(this.fMc.fRi, this.fID.bcj(), this.fNw.wm().getUserId(), this.fID.getThreadId());
        }
    }

    public void bgV() {
        if (this.fOb && !this.fOa && this.fNw != null && this.fNw.wm() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").w("obj_locate", this.fFd.bcE() ? 2 : 1).w("obj_type", this.fOa ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fFd.getPageContext().getPageActivity(), this.fNw.wm().getUserId(), this.fNw.wm().getUserName(), this.fFd.bcO().bcF(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fOa && this.fNF != null && this.fMc.bhE() != null) {
            int bej = this.fMN.bej();
            if (bej > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bej > this.fMg.getFirstVisiblePosition() - this.fMg.getHeaderViewsCount()) {
                    this.fNF.setVisibility(8);
                    return;
                }
                this.fNF.setVisibility(0);
                bhf();
                this.fMc.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fLv == null) {
                if (this.fMg.getFirstVisiblePosition() == 0) {
                    this.fNF.setVisibility(8);
                    this.fMc.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fNK) {
                        this.fNJ = top;
                        this.fNK = false;
                    }
                    this.fNJ = top < this.fNJ ? top : this.fNJ;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fMM.getY() < 0.0f) {
                        measuredHeight = fNI - alVar.fLv.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fMc.bhE().getMeasuredHeight() - alVar.fLv.getMeasuredHeight();
                        this.fMc.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fNJ) {
                        this.fNF.setVisibility(0);
                        bhf();
                    } else if (top < measuredHeight) {
                        this.fNF.setVisibility(0);
                        bhf();
                    } else {
                        this.fNF.setVisibility(8);
                        this.fMc.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fNK = true;
                    }
                }
            }
        }
    }

    public void bgW() {
        if (!this.fOG) {
            TiebaStatic.log("c10490");
            this.fOG = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fFd.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fNP, Integer.valueOf(fNR));
            aVar.co(e.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.function_description_view)).setText(e.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(e.g.title_view)).setText(e.j.grade_thread_tips);
            aVar.G(inflate);
            aVar.D(sparseArray);
            aVar.a(e.j.grade_button_tips, this.fFd);
            aVar.b(e.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fFd.getPageContext()).yl();
        }
    }

    public void rX(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fFd.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(e.g.function_description_view)).setVisibility(8);
        aVar.G(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fNP, Integer.valueOf(fNS));
        aVar.D(sparseArray);
        aVar.a(e.j.view, this.fFd);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fFd.getPageContext()).yl();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.wm() != null) {
            MetaData wm = b.wm();
            wm.setGiftNum(wm.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bgX() {
        return this.fNB;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bbJ() != null && dVar.bbJ().xe() && this.fNB == null) {
            this.fNB = (PbInterviewStatusView) this.fNA.inflate();
            this.fNB.setOnClickListener(this.dud);
            this.fNB.setCallback(this.fFd.bdM());
            this.fNB.setData(this.fFd, dVar);
        }
    }

    public LinearLayout bgY() {
        return this.fMM;
    }

    public View bgZ() {
        return this.dus;
    }

    public boolean bha() {
        return this.fOr;
    }

    public void jZ(boolean z) {
        this.fMl.jZ(z);
    }

    public void rY(String str) {
        if (this.fMd != null) {
            this.fMd.setTitle(str);
        }
    }

    private int kP(boolean z) {
        if (this.fNB == null || this.fNB.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds72);
    }

    private void bhb() {
        if (this.fNB != null && this.fNB.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fNB.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fNB.setLayoutParams(layoutParams);
        }
    }

    public boolean bdg() {
        return false;
    }

    public void rZ(String str) {
        this.fNo.performClick();
        if (!StringUtils.isNull(str) && this.fFd.bda() != null && this.fFd.bda().Ji() != null && this.fFd.bda().Ji().getInputView() != null) {
            EditText inputView = this.fFd.bda().Ji().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bgK();
            if (configuration.orientation == 2) {
                bgT();
                bfX();
            } else {
                bga();
            }
            if (this.fNW != null) {
                this.fNW.beq();
            }
            this.fFd.awu();
            this.fMM.setVisibility(8);
            this.fMc.lb(false);
            this.fFd.kf(false);
            if (this.fLW != null) {
                if (configuration.orientation == 1) {
                    bgY().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fMg.setIsLandscape(true);
                    this.fMg.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fMg.setIsLandscape(false);
                    if (this.fOF > 0) {
                        this.fMg.smoothScrollBy(this.fOF, 0);
                    }
                }
                this.fLW.onConfigurationChanged(configuration);
                this.fNE.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void kQ(boolean z) {
        this.fMa = z;
    }

    public boolean bhc() {
        return this.fLW != null && this.fLW.bhc();
    }

    public void bhd() {
        if (this.fLW != null) {
            this.fLW.onPause();
        }
    }

    public void n(long j, int i) {
        if (this.fLY != null) {
            this.fLY.n(j, i);
        }
        if (this.fLW != null) {
            this.fLW.n(j, i);
        }
    }

    public void kk(boolean z) {
        this.fMN.kk(z);
    }

    public void bhe() {
        if (this.fNC == null) {
            LayoutInflater.from(this.fFd.getActivity()).inflate(e.h.add_experienced_text, (ViewGroup) this.cYo, true);
            this.fNC = (ViewGroup) this.cYo.findViewById(e.g.add_experienced_layout);
            this.fND = (TextView) this.cYo.findViewById(e.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.fND, e.d.cp_cont_i);
            String string = this.fFd.getResources().getString(e.j.experienced_add_success);
            String string2 = this.fFd.getResources().getString(e.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_h)));
            this.fND.setText(spannableString);
        }
        this.fNC.setVisibility(0);
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
                        ar.this.fNC.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fND.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fND.startAnimation(scaleAnimation);
    }

    public void bB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fNn.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fFd);
            frameLayout.setBackgroundResource(e.f.pic_sign_tip);
            this.fOi = new TextView(this.fFd);
            this.fOi.setText(e.j.connection_tips);
            this.fOi.setGravity(17);
            this.fOi.setPadding(com.baidu.adp.lib.util.l.h(this.fFd, e.C0141e.ds24), 0, com.baidu.adp.lib.util.l.h(this.fFd, e.C0141e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fFd, e.C0141e.ds60);
            if (this.fOi.getParent() == null) {
                frameLayout.addView(this.fOi, layoutParams);
            }
            this.fOh = new PopupWindow(this.fFd);
            this.fOh.setContentView(frameLayout);
            this.fOh.setHeight(-2);
            this.fOh.setWidth(-2);
            this.fOh.setFocusable(true);
            this.fOh.setOutsideTouchable(false);
            this.fOh.setBackgroundDrawable(new ColorDrawable(this.fFd.getResources().getColor(e.d.transparent)));
            this.fMg.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fOh.showAsDropDown(ar.this.fNn, view.getLeft(), -ar.this.fNn.getHeight());
                    } else {
                        ar.this.fOh.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bhf() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.fOj == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.fOj = new com.baidu.tbadk.core.dialog.a(this.fFd);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.fFd);
            this.fOj.cr(1);
            this.fOj.G(pbLongPressTipView);
            this.fOj.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.31
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fOj.aF(false);
            this.fOj.b(this.fFd.getPageContext()).yl();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.32
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fOj != null && ar.this.fOj.isShowing()) {
                        ar.this.fOj.dismiss();
                    }
                }
            }, 5000L);
            if (this.fLW != null) {
                this.fLW.biV();
            }
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bhv() != null && !StringUtils.isNull(aVar.bhv().pkg_id) && !StringUtils.isNull(aVar.bhv().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fNp != null && this.fNp.getVisibility() == 0) {
            if (this.fOg == null) {
                View inflate = LayoutInflater.from(this.fFd.getPageContext().getPageActivity()).inflate(e.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(e.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(e.g.single_bar_tips);
                textView.setText(e.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dud);
                this.fOg = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fNp.getLocationInWindow(iArr);
            this.fOg.showAtLocation(this.fNp, 0, iArr[0] - com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds54), (iArr[1] - this.fNp.getHeight()) - com.baidu.adp.lib.util.l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bhg() {
        com.baidu.adp.lib.g.g.a(this.fOg);
    }

    public void kR(boolean z) {
        this.fOo = z;
    }

    public boolean bhh() {
        return this.fOo;
    }

    public void bC(View view) {
        this.fNe = view;
    }
}
