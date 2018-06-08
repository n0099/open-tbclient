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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bd;
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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
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
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class as {
    private EditorTools Qh;
    private TextView aHw;
    private View aSj;
    private f.b awh;
    private TextView axM;
    private com.baidu.tieba.pb.a.c beE;
    private List<CustomBlueCheckRadioButton> cAM;
    private NoNetworkView cRO;
    private RelativeLayout cRQ;
    private NavigationBarCoverTip dBp;
    private View djC;
    private View.OnClickListener djp;
    private PbListView dlW;
    private int eSF;
    private PbLandscapeListView fAA;
    private View fAB;
    private LinearLayout fAE;
    private e fAF;
    private ColumnLayout fAG;
    private ThreadSkinView fAH;
    private TextView fAI;
    private TextView fAJ;
    private ImageView fAK;
    private HeadPendantView fAL;
    private FrameLayout fAM;
    private HeadImageView fAN;
    private View fAO;
    private FloatingLayout fAP;
    private PbFirstFloorUserLikeButton fAS;
    private aq fAT;
    private aq fAU;
    private TextView fAV;
    private TextView fAW;
    private TextView fAX;
    private View fAY;
    private View fAZ;
    public int fAp;
    private com.baidu.tieba.pb.video.i fAq;
    private long fAr;
    private com.baidu.tieba.pb.video.h fAs;
    private com.baidu.tieba.c.d fAt;
    public final com.baidu.tieba.pb.pb.main.view.b fAw;
    public com.baidu.tieba.pb.pb.main.view.a fAx;
    private ViewStub fAy;
    private ViewStub fAz;
    private View fBH;
    private TextView fBI;
    private ImageView fBJ;
    private ImageView fBK;
    private TextView fBL;
    private boolean fBN;
    private int fBO;
    private int fBP;
    private PostData fBQ;
    private View fBS;
    private TextView fBT;
    private ViewStub fBU;
    private PbInterviewStatusView fBV;
    private ViewGroup fBW;
    private TextView fBX;
    private FrameLayout fBY;
    private View fBZ;
    private LinearLayout fBa;
    private TextView fBb;
    private TextView fBc;
    private View fBd;
    private View fBe;
    private ObservedChangeLinearLayout fBg;
    private f fBh;
    private View fBn;
    private PopupWindow fCA;
    private PopupWindow fCB;
    private TextView fCC;
    private List<String> fCD;
    private com.baidu.tieba.pb.pb.main.emotion.c fCE;
    private com.baidu.tieba.pb.pb.godreply.a fCF;
    private PbLandscapeListView.b fCG;
    private ab fCI;
    private boolean fCK;
    private com.baidu.tbadk.core.view.userLike.c fCL;
    private com.baidu.tbadk.core.view.userLike.c fCM;
    private Runnable fCR;
    private PbActivity.b fCT;
    private View fCa;
    private ak fCb;
    private PbEmotionBar fCg;
    private int fCo;
    private Runnable fCp;
    private r fCq;
    private am fCr;
    private int fCx;
    private PbTopTipView fCz;
    PbActivity.d fsu;
    private View.OnClickListener ftN;
    private PbActivity ftp;
    private UserIconBox fuE;
    private UserIconBox fuF;
    private PbFakeFloorModel fvH;
    private com.baidu.tieba.pb.data.d fwM;
    private boolean isLandscape;
    private View mFooterView;
    private int mType;
    private static final int fCc = UtilHelper.getLightStatusBarHeight();
    public static int fCi = 3;
    public static int fCj = 0;
    public static int fCk = 3;
    public static int fCl = 4;
    public static int fCm = 5;
    public static int fCn = 6;
    private static a.InterfaceC0232a fCJ = new a.InterfaceC0232a() { // from class: com.baidu.tieba.pb.pb.main.as.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0232a
        public void onRefresh() {
        }
    };
    private boolean fAu = false;
    private int fAv = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fAC = null;
    private TextView fAD = null;
    public FrsPraiseView fAQ = null;
    private ClickableHeaderImageView fAR = null;
    private View fBf = null;
    private com.baidu.tbadk.core.dialog.a fBi = null;
    private com.baidu.tbadk.core.dialog.b djo = null;
    private View fBj = null;
    private EditText fBk = null;
    private com.baidu.tieba.pb.view.e fBl = null;
    private com.baidu.tieba.pb.view.a fBm = null;
    private com.baidu.tbadk.core.dialog.a fBo = null;
    private b.InterfaceC0103b eob = null;
    private TbRichTextView.h beD = null;
    private NoNetworkView.a dfy = null;
    private Dialog fBp = null;
    private View fBq = null;
    private com.baidu.tbadk.core.dialog.a fBr = null;
    private Dialog fBs = null;
    private Dialog fBt = null;
    private View fBu = null;
    private LinearLayout fBv = null;
    private CompoundButton.OnCheckedChangeListener cAN = null;
    private TextView fBw = null;
    private TextView fBx = null;
    private View fBy = null;
    private String fBz = null;
    private com.baidu.tbadk.core.dialog.b fBA = null;
    private com.baidu.tbadk.core.dialog.b fBB = null;
    private boolean fBC = false;
    private boolean fBD = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fBE = null;
    private boolean fBF = false;
    private Button fBG = null;
    private boolean fBM = true;
    private com.baidu.tbadk.core.view.a cIg = null;
    private boolean ftG = false;
    private int mSkinType = 3;
    private boolean fBR = false;
    private int fCd = 0;
    private boolean fCe = true;
    private a fCf = new a();
    private int fCh = 0;
    private boolean fCs = false;
    private int fCt = 0;
    private boolean fCu = false;
    private boolean fCv = false;
    private boolean fCw = false;
    private int fCy = 0;
    private boolean fCH = false;
    private String fCN = null;
    private CustomMessageListener fCO = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.as.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                as.this.fCN = null;
            }
        }
    };
    private CustomMessageListener bvy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.as.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && as.this.fBh != null) {
                as.this.fBh.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fCP = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.as.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (as.this.fAD != null) {
                as.this.fAD.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fCQ = new Handler();
    private CustomMessageListener fCS = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.as.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                as.this.fBM = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fCU = true;
    View.OnClickListener fCV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (as.this.fCu) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").r(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (as.this.fAw != null && as.this.fAw.fFw != null && view == as.this.fAw.fFw.getHeadView()) {
                if (as.this.fAw.fFu == null || as.this.fAw.fFu.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").r("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!as.this.fCu && as.this.fwM != null && as.this.fwM.bao() != null && as.this.fwM.bao().vm() != null && as.this.fwM.bao().vm().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").r("obj_locate", 1));
            }
            as.this.ftp.frr.fEF.onClick(view);
        }
    };
    private boolean fCW = false;
    String userId = null;
    private final List<TbImageView> fCX = new ArrayList();
    private boolean fCY = false;

    /* loaded from: classes2.dex */
    public static class a {
        public ak fDm;
        public int fkd;
        public int headerCount;
    }

    public void ki(boolean z) {
        this.fCs = z;
        if (this.fAA != null) {
            this.fCt = this.fAA.getHeaderViewsCount();
        }
    }

    public void beB() {
        if (this.fAA != null) {
            int headerViewsCount = this.fAA.getHeaderViewsCount() - this.fCt;
            final int firstVisiblePosition = (this.fAA.getFirstVisiblePosition() == 0 || this.fAA.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fAA.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fAA.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fCf.fDm = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fCf));
            final ak akVar = this.fCf.fDm;
            final int h = h(akVar);
            final int y = ((int) this.fBg.getY()) + this.fBg.getMeasuredHeight();
            final boolean z = this.fBZ.getVisibility() == 0;
            boolean z2 = this.fBg.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.fBh.bcM() + this.fAA.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fzE.getMeasuredHeight() : 0;
                if (z2) {
                    this.fAA.setSelectionFromTop(this.fBh.bcM() + this.fAA.getHeaderViewsCount(), fCc - measuredHeight);
                } else {
                    this.fAA.setSelectionFromTop(this.fBh.bcM() + this.fAA.getHeaderViewsCount(), this.fAw.bge().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fAA.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fCu) {
                this.fAA.setSelectionFromTop(this.fBh.bcM() + this.fAA.getHeaderViewsCount(), this.fAq.bhw().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fAA.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.as.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bdd() {
                        if (h >= 0 && h <= as.this.cRQ.getMeasuredHeight()) {
                            int h2 = as.this.h(akVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = as.this.mFooterView.getLayoutParams();
                            if (i == 0 || i > as.this.cRQ.getMeasuredHeight() || h2 >= as.this.cRQ.getMeasuredHeight()) {
                                layoutParams.height = as.this.fCo;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > as.this.cRQ.getMeasuredHeight()) {
                                layoutParams.height = as.this.fCo;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                as.this.fAA.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            as.this.mFooterView.setLayoutParams(layoutParams);
                        }
                        as.this.fAA.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(ak akVar) {
        if (akVar == null || akVar.getView() == null) {
            return 0;
        }
        if (akVar.getView().getTop() != 0 || akVar.getView().isShown()) {
            return akVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView beC() {
        return this.cRO;
    }

    public void beD() {
        if (this.Qh != null) {
            this.Qh.hide();
            if (this.fCE != null) {
                this.fCE.Sg();
            }
        }
    }

    public PbFakeFloorModel beE() {
        return this.fvH;
    }

    public r beF() {
        return this.fCq;
    }

    public void beG() {
        reset();
        beD();
        this.fCq.bcT();
        ku(false);
    }

    private void reset() {
        if (this.ftp != null && this.ftp.bbF() != null && this.Qh != null) {
            com.baidu.tbadk.editortools.pb.a.HC().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bbF = this.ftp.bbF();
            bbF.HV();
            bbF.Hq();
            if (bbF.getWriteImagesInfo() != null) {
                bbF.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bbF.eS(SendView.ALL);
            bbF.eT(SendView.ALL);
            com.baidu.tbadk.editortools.g eJ = this.Qh.eJ(23);
            com.baidu.tbadk.editortools.g eJ2 = this.Qh.eJ(2);
            com.baidu.tbadk.editortools.g eJ3 = this.Qh.eJ(5);
            if (eJ2 != null) {
                eJ2.oD();
            }
            if (eJ3 != null) {
                eJ3.oD();
            }
            if (eJ != null) {
                eJ.hide();
            }
            this.Qh.invalidate();
        }
    }

    public boolean beH() {
        return this.fBM;
    }

    public void kj(boolean z) {
        if (this.fBH != null && this.fBI != null) {
            this.fBI.setText(d.k.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fBH.startAnimation(alphaAnimation);
            }
            this.fBH.setVisibility(0);
            this.fBM = true;
            if (this.fCg != null && !this.fCF.isActive()) {
                this.fCg.setVisibility(0);
                ko(true);
            }
        }
    }

    public void kk(boolean z) {
        if (this.fBH != null && this.fBI != null) {
            this.fBI.setText(d.k.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fBH.startAnimation(alphaAnimation);
            }
            this.fBH.setVisibility(0);
            this.fBM = true;
            if (this.fCg != null && !this.fCF.isActive()) {
                this.fCg.setVisibility(0);
                ko(true);
            }
        }
    }

    public PostData beI() {
        int i = 0;
        if (this.fAA == null) {
            return null;
        }
        int beJ = beJ() - this.fAA.getHeaderViewsCount();
        if (beJ < 0) {
            beJ = 0;
        }
        if (this.fBh.qt(beJ) != null && this.fBh.qt(beJ) != PostData.gIU) {
            i = beJ + 1;
        }
        return this.fBh.getItem(i) instanceof PostData ? (PostData) this.fBh.getItem(i) : null;
    }

    public int beJ() {
        int i;
        View childAt;
        if (this.fAA == null) {
            return 0;
        }
        int firstVisiblePosition = this.fAA.getFirstVisiblePosition();
        int lastVisiblePosition = this.fAA.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fAA.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fAA.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int beK() {
        return this.fAA.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fwM != null && this.fwM.baq() != null && !this.fwM.baq().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fwM.baq().size() && (postData = this.fwM.baq().get(i)) != null && postData.vm() != null && !StringUtils.isNull(postData.vm().getUserId()); i++) {
                if (this.fwM.baq().get(i).vm().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fCF != null && this.fCF.isActive()) {
                        ku(false);
                    }
                    if (this.fCg != null) {
                        this.fCg.kB(true);
                    }
                    this.fCN = postData.vm().getName_show();
                    return;
                }
            }
        }
    }

    public as(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.ftp = null;
        this.cRQ = null;
        this.djC = null;
        this.fAr = 0L;
        this.fAA = null;
        this.fAB = null;
        this.fAE = null;
        this.fAG = null;
        this.fAI = null;
        this.fAJ = null;
        this.fAM = null;
        this.fAN = null;
        this.fAO = null;
        this.fAS = null;
        this.fAV = null;
        this.fAW = null;
        this.fAX = null;
        this.fAY = null;
        this.fBd = null;
        this.fBe = null;
        this.fBh = null;
        this.dlW = null;
        this.aSj = null;
        this.djp = null;
        this.ftN = null;
        this.fBH = null;
        this.fBI = null;
        this.fBJ = null;
        this.fBK = null;
        this.fBL = null;
        this.fBS = null;
        this.fBT = null;
        this.fBU = null;
        this.fCx = 0;
        this.fAr = System.currentTimeMillis();
        this.ftp = pbActivity;
        this.djp = onClickListener;
        this.beE = cVar;
        this.fCx = com.baidu.adp.lib.util.l.ah(this.ftp) / 2;
        this.cRQ = (RelativeLayout) LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.new_pb_activity, (ViewGroup) null);
        this.ftp.addContentView(this.cRQ, new FrameLayout.LayoutParams(-1, -1));
        this.dBp = (NavigationBarCoverTip) this.ftp.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.djC = this.ftp.findViewById(d.g.statebar_view);
        this.fBg = (ObservedChangeLinearLayout) this.ftp.findViewById(d.g.title_wrapper);
        this.cRO = (NoNetworkView) this.ftp.findViewById(d.g.view_no_network);
        this.fAA = (PbLandscapeListView) this.ftp.findViewById(d.g.new_pb_list);
        this.fBY = (FrameLayout) this.ftp.findViewById(d.g.root_float_header);
        this.aHw = new TextView(this.ftp.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds88));
        this.fAA.addHeaderView(this.aHw, 0);
        this.fCo = this.ftp.getResources().getDimensionPixelSize(d.e.tbds134);
        this.mFooterView = new View(this.ftp.getPageContext().getPageActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fCo));
        this.mFooterView.setVisibility(4);
        this.fAA.addFooterView(this.mFooterView);
        this.fAA.setOnTouchListener(this.ftp.aVI);
        this.fAw = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.ftp.bch()) {
            this.fAy = (ViewStub) this.ftp.findViewById(d.g.manga_view_stub);
            this.fAy.setVisibility(0);
            this.fAx = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fAx.show();
            this.fAw.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds120);
        }
        this.aHw.setLayoutParams(layoutParams);
        this.fAw.bge().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0203a() { // from class: com.baidu.tieba.pb.pb.main.as.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0203a
            public void bbh() {
                if (as.this.fAA != null) {
                    if (as.this.fAq != null) {
                        as.this.fAq.bhx();
                    }
                    as.this.fAA.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0203a
            public void bbi() {
                as.this.ftp.atH();
            }
        }));
        this.fBH = this.ftp.findViewById(d.g.pb_editor_tool_comment);
        this.fBO = com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds90);
        this.fBP = com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds242);
        this.fBI = (TextView) this.ftp.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fBK = (ImageView) this.ftp.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fBJ = (ImageView) this.ftp.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fBL = (TextView) this.ftp.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fBL.setVisibility(8);
        this.fBI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.bfK();
                if (!as.this.ftp.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").r("obj_locate", 2).ah(ImageViewerConfig.FORUM_ID, as.this.mForumId));
                } else if (as.this.ftp.bbP()) {
                    com.baidu.tbadk.editortools.pb.d bbF = as.this.ftp.bbF();
                    if (bbF == null || (!bbF.HS() && !bbF.HT())) {
                        if (as.this.Qh != null) {
                            as.this.beU();
                        }
                        if (as.this.Qh != null) {
                            as.this.fBM = false;
                            if (as.this.Qh.eM(2) != null) {
                                com.baidu.tieba.tbadkCore.b.a.a(as.this.ftp, (View) as.this.Qh.eM(2).aLj, false, as.fCJ);
                            }
                        }
                        as.this.bfy();
                        return;
                    }
                    as.this.ftp.bbF().a(false, (PostWriteCallBackData) null);
                }
            }
        });
        this.fBJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.bfK();
                if (as.this.ftp.checkUpIsLogin()) {
                    if (as.this.Qh != null) {
                        as.this.beU();
                        as.this.Qh.M((View) as.this.Qh.eJ(5));
                    }
                    if (as.this.Qh != null) {
                        as.this.fBM = false;
                        if (as.this.Qh.eM(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.ftp, (View) as.this.Qh.eM(2).aLj, false, as.fCJ);
                        }
                    }
                    as.this.bfy();
                }
            }
        });
        this.fBK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.bfK();
                if (as.this.ftp.checkUpIsLogin()) {
                    if (as.this.Qh != null) {
                        as.this.beU();
                        as.this.Qh.M((View) as.this.Qh.eJ(2));
                    }
                    if (as.this.Qh != null) {
                        as.this.fBM = false;
                        if (as.this.Qh.eM(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.ftp, (View) as.this.Qh.eM(2).aLj, false, as.fCJ);
                        }
                    }
                    as.this.bfy();
                }
            }
        });
        this.fBL.setOnClickListener(this.djp);
        this.fBL.setOnTouchListener(this.ftp);
        this.fAB = LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_item, (ViewGroup) null);
        this.fAE = (LinearLayout) LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.al.i(this.fAE, d.C0141d.cp_bg_line_d);
        this.fAF = new e(this.ftp, this.fAE);
        this.fAF.init();
        this.fAF.a(this.fAF.bbE(), this.djp);
        this.fAG = (ColumnLayout) this.fAE.findViewById(d.g.pb_head_owner_root);
        this.fAH = (ThreadSkinView) this.fAE.findViewById(d.g.pb_thread_skin);
        this.fAG.setOnLongClickListener(this.onLongClickListener);
        this.fAG.setOnTouchListener(this.beE);
        this.fAG.setVisibility(8);
        this.fAB.setOnTouchListener(this.beE);
        this.fBS = this.fAB.findViewById(d.g.pb_head_activity_join_number_container);
        this.fBS.setVisibility(8);
        this.fBT = (TextView) this.fAB.findViewById(d.g.pb_head_activity_join_number);
        this.fAI = (TextView) this.fAG.findViewById(d.g.pb_head_owner_info_user_name);
        this.fAJ = (TextView) this.fAG.findViewById(d.g.floor_owner);
        this.fAK = (ImageView) this.fAG.findViewById(d.g.icon_forum_level);
        this.fAM = (FrameLayout) this.fAG.findViewById(d.g.pb_head_headImage_container);
        this.fAN = (HeadImageView) this.fAG.findViewById(d.g.pb_head_owner_photo);
        this.fAL = (HeadPendantView) this.fAG.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fAL.setHasPendantStyle();
        if (this.fAL.getHeadView() != null) {
            this.fAL.getHeadView().setIsRound(true);
            this.fAL.getHeadView().setDrawBorder(false);
        }
        this.fuE = (UserIconBox) this.fAG.findViewById(d.g.show_icon_vip);
        this.fuF = (UserIconBox) this.fAG.findViewById(d.g.show_icon_yinji);
        this.fAP = (FloatingLayout) this.fAE.findViewById(d.g.pb_head_owner_info_root);
        this.fAS = (PbFirstFloorUserLikeButton) this.fAG.findViewById(d.g.pb_like_button);
        this.fAV = (TextView) this.fAG.findViewById(d.g.pb_views);
        this.axM = (TextView) this.fAG.findViewById(d.g.view_forum_name);
        this.fAZ = this.fAG.findViewById(d.g.line_right_forum_name);
        this.fAW = (TextView) this.fAG.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fAX = (TextView) this.fAG.findViewById(d.g.pb_item_first_floor_location_address);
        this.fAY = this.fAG.findViewById(d.g.line_between_time_and_locate);
        this.fCL = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fCM = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fBd = this.fAB.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fBe = this.fAB.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fAB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fBU = (ViewStub) this.cRQ.findViewById(d.g.interview_status_stub);
        this.fBh = new f(this.ftp, this.fAA);
        this.fBh.t(this.djp);
        this.fBh.setTbGestureDetector(this.beE);
        this.fBh.setOnImageClickListener(this.beD);
        this.ftN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            as.this.ftp.b(sparseArray);
                            return;
                        }
                        as.this.bh(view);
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        as.this.ftp.b(sparseArray);
                    } else if (booleanValue3) {
                        as.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fBh.F(this.ftN);
        beP();
        this.fAA.addHeaderView(this.fAC);
        this.fAA.addHeaderView(this.fAE);
        this.fAA.addHeaderView(this.fAB);
        this.dlW = new PbListView(this.ftp.getPageContext().getPageActivity());
        this.aSj = this.dlW.getView().findViewById(d.g.pb_more_view);
        if (this.aSj != null) {
            this.aSj.setOnClickListener(this.djp);
            com.baidu.tbadk.core.util.al.i(this.aSj, d.f.pb_foot_more_trans_selector);
        }
        this.dlW.An();
        this.dlW.setBackground(d.f.pb_foot_more_trans_selector);
        this.dlW.dx(d.f.pb_foot_more_trans_selector);
        this.fBn = this.ftp.findViewById(d.g.viewstub_progress);
        this.ftp.registerListener(this.fCS);
        this.fAO = com.baidu.tbadk.ala.b.rM().f(this.ftp.getActivity(), 2);
        if (this.fAO != null) {
            this.fAO.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.ftp.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fAO.getParent() == null) {
                this.fAP.addView(this.fAO, aVar);
            }
        }
        this.fvH = new PbFakeFloorModel(this.ftp.getPageContext());
        this.fCq = new r(this.ftp.getPageContext(), this.fvH, this.cRQ);
        this.fCq.a(this.ftp.fsq);
        this.fvH.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.as.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                as.this.fvH.l(postData);
                as.this.fBh.notifyDataSetChanged();
                as.this.fCq.bcT();
                as.this.Qh.FB();
                as.this.ku(false);
            }
        });
        if (this.ftp.bbt() != null && !StringUtils.isNull(this.ftp.bbt().bdM())) {
            this.ftp.showToast(this.ftp.bbt().bdM());
        }
        this.fBZ = this.ftp.findViewById(d.g.pb_expand_blank_view);
        this.fCa = this.ftp.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fCa.getLayoutParams();
        if (this.ftp.bbt() != null && this.ftp.bbt().bdk()) {
            this.fBZ.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fCa.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fCc;
            this.fCa.setLayoutParams(layoutParams2);
        }
        this.fCb = new ak(this.ftp.getPageContext(), this.ftp.findViewById(d.g.pb_reply_expand_view));
        this.fCb.fzE.setVisibility(8);
        this.fCb.H(this.djp);
        this.ftp.registerListener(this.bvy);
        this.ftp.registerListener(this.fCO);
        this.ftp.registerListener(this.fCP);
        beL();
        ko(false);
    }

    private void beL() {
        this.fCF = new com.baidu.tieba.pb.pb.godreply.a(this.ftp, this, (ViewStub) this.cRQ.findViewById(d.g.more_god_reply_popup));
        this.fCF.n(this.djp);
        this.fCF.F(this.ftN);
        this.fCF.setOnImageClickListener(this.beD);
        this.fCF.n(this.djp);
        this.fCF.setTbGestureDetector(this.beE);
    }

    public com.baidu.tieba.pb.pb.godreply.a beM() {
        return this.fCF;
    }

    public View beN() {
        return this.fBZ;
    }

    public void beO() {
        if (this.fAA != null) {
            this.fAA.removeHeaderView(this.fAC);
            this.fAA.removeHeaderView(this.fAE);
            this.fAA.removeHeaderView(this.fAB);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fCg == null) {
            this.fCg = new PbEmotionBar(this.ftp.getPageContext().getPageActivity());
            ko(true);
            this.fCg.a(this.cRQ, aVar, this.fBH.getVisibility() == 0);
            this.fCg.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.as.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (as.this.ftp.bbP()) {
                        if (!StringUtils.isNull(as.this.fCN)) {
                            emotionImageData.setAuthorNameShow(as.this.fCN);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    as.this.ftp.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(as.this.ftp.getPageContext().getPageActivity(), 25016, str, list, as.this.fCN, list2)));
                }
            });
            this.fCg.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.as.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    as.this.bfK();
                    if (as.this.fBH != null) {
                        ViewGroup.LayoutParams layoutParams = as.this.fBH.getLayoutParams();
                        layoutParams.height = (int) (((as.this.fBP - as.this.fBO) * f) + as.this.fBO);
                        as.this.fBI.setAlpha(1.0f - f);
                        as.this.fBK.setAlpha(1.0f - f);
                        as.this.fBJ.setAlpha(1.0f - f);
                        as.this.fBH.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void beP() {
        if (this.fAC == null) {
            int e = com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.tbds44);
            this.fAC = new LinearLayout(this.ftp.getPageContext().getPageActivity());
            this.fAC.setOrientation(1);
            this.fAC.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fAC.setPadding(e, com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.tbds30), e, com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.tbds40));
            this.fAC.setGravity(17);
            this.fAD = new TextView(this.ftp.getPageContext().getPageActivity());
            this.fAD.setGravity(3);
            this.fAD.setMaxLines(2);
            this.fAD.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_link_tip_c));
            this.fAD.setPadding(0, 0, 0, 0);
            this.fAD.setLineSpacing(com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.fAD, d.C0141d.cp_cont_b);
            this.fAD.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fAD.setVisibility(8);
            if (this.fAD.getParent() == null) {
                this.fAC.addView(this.fAD);
            }
            this.fAC.setOnTouchListener(this.beE);
            this.fAC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beQ() {
        if (this.ftp.bch()) {
            this.fAz = (ViewStub) this.ftp.findViewById(d.g.manga_mention_controller_view_stub);
            this.fAz.setVisibility(0);
            if (this.fBa == null) {
                this.fBa = (LinearLayout) this.ftp.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.ftp.getPageContext(), this.fBa);
            }
            if (this.fBb == null) {
                this.fBb = (TextView) this.fBa.findViewById(d.g.manga_prev_btn);
            }
            if (this.fBc == null) {
                this.fBc = (TextView) this.fBa.findViewById(d.g.manga_next_btn);
            }
            this.fBb.setOnClickListener(this.djp);
            this.fBc.setOnClickListener(this.djp);
        }
    }

    private void beR() {
        if (this.ftp.bch()) {
            if (this.ftp.bck() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fBb, d.C0141d.cp_cont_e, 1);
            }
            if (this.ftp.bcl() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fBc, d.C0141d.cp_cont_e, 1);
            }
        }
    }

    public void beS() {
        if (this.fBa == null) {
            beQ();
        }
        this.fAz.setVisibility(8);
        if (this.fCQ != null && this.fCR != null) {
            this.fCQ.removeCallbacks(this.fCR);
        }
    }

    public void beT() {
        if (this.fCQ != null) {
            if (this.fCR != null) {
                this.fCQ.removeCallbacks(this.fCR);
            }
            this.fCR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.this.fBa == null) {
                        as.this.beQ();
                    }
                    as.this.fAz.setVisibility(0);
                }
            };
            this.fCQ.postDelayed(this.fCR, 2000L);
        }
    }

    public void kl(boolean z) {
        this.fAw.kl(z);
        if (z && this.fBR) {
            this.dlW.setText(this.ftp.getResources().getString(d.k.click_load_more));
            this.fAA.setNextPage(this.dlW);
            this.fAv = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
        this.Qh.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Qh.getParent() == null) {
            this.cRQ.addView(this.Qh, layoutParams);
        }
        this.Qh.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        beD();
        this.ftp.bbF().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.as.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (as.this.Qh != null && as.this.Qh.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (as.this.fCE == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, as.this.Qh.getId());
                            as.this.fCE = new com.baidu.tieba.pb.pb.main.emotion.c(as.this.ftp.getPageContext(), as.this.cRQ, layoutParams2);
                            if (!com.baidu.tbadk.core.util.w.z(as.this.fCD)) {
                                as.this.fCE.setData(as.this.fCD);
                            }
                            as.this.fCE.b(as.this.Qh);
                        }
                        as.this.fCE.rA(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (as.this.ftp.frw != null && as.this.ftp.frw.bfP() != null) {
                    if (!as.this.ftp.frw.bfP().bGb()) {
                        as.this.ftp.frw.ky(false);
                    }
                    as.this.ftp.frw.bfP().ns(false);
                }
            }
        });
    }

    public void beU() {
        if (this.ftp != null && this.Qh != null) {
            this.Qh.oD();
            if (this.ftp.bbF() != null) {
                this.ftp.bbF().HJ();
            }
            bfy();
        }
    }

    public void M(String str, boolean z) {
        this.fBN = z;
        km(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void km(boolean z) {
        if (this.fBL != null) {
            if (this.fBN) {
                com.baidu.tbadk.core.util.al.i(this.fBL, d.f.pb_praise_already_click_selector);
                this.fBL.setContentDescription(this.ftp.getResources().getString(d.k.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.fBL, d.f.pb_praise_normal_click_selector);
            this.fBL.setContentDescription(this.ftp.getResources().getString(d.k.zan));
        }
    }

    public TextView beV() {
        return this.fBL;
    }

    public void kn(boolean z) {
        if (this.fAA != null && this.aHw != null && this.djC != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.djC.setVisibility(0);
                } else {
                    this.djC.setVisibility(8);
                    this.fAA.removeHeaderView(this.aHw);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aHw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fCc;
                    this.aHw.setLayoutParams(layoutParams);
                }
                bfj();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aHw.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kv(true);
                this.aHw.setLayoutParams(layoutParams2);
            }
            bfj();
            bfG();
        }
    }

    public f beW() {
        return this.fBh;
    }

    public void a(PbActivity.d dVar) {
        this.fsu = dVar;
    }

    public void bh(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fBq == null) {
            this.fBq = LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
        }
        this.ftp.getLayoutMode().onModeChanged(this.fBq);
        if (this.fBp == null) {
            this.fBp = new Dialog(this.ftp.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fBp.setCanceledOnTouchOutside(true);
            this.fBp.setCancelable(true);
            this.fBp.setContentView(this.fBq);
            WindowManager.LayoutParams attributes = this.fBp.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ah(this.ftp.getPageContext().getPageActivity()) * 0.9d);
            this.fBp.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fBp.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fBp.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fBp.findViewById(d.g.disable_reply_btn);
        int intValue = sparseArray.get(d.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(d.g.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(d.k.delete);
            } else {
                textView.setText(d.k.delete_post);
            }
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fBp != null && (as.this.fBp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fBp, as.this.ftp.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        as.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(d.g.tag_forbid_user_name)) && "".equals(sparseArray.get(d.g.tag_forbid_user_name_show))) || bfF()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray5.put(d.g.tag_forbid_user_name_show, sparseArray.get(d.g.tag_forbid_user_name_show));
            sparseArray5.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray5.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fBp != null && (as.this.fBp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fBp, as.this.ftp.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && as.this.fCT != null) {
                        as.this.fCT.i(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id), sparseArray6.get(d.g.tag_forbid_user_name_show)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.k.un_mute);
            } else {
                textView3.setText(d.k.mute);
            }
            sparseArray6.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
            sparseArray6.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
            sparseArray6.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
            sparseArray6.put(d.g.tag_user_mute_mute_nameshow, sparseArray.get(d.g.tag_user_mute_mute_nameshow));
            sparseArray6.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray6.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray6.put(d.g.tag_user_mute_msg, sparseArray.get(d.g.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fBp != null && (as.this.fBp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fBp, as.this.ftp.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        as.this.ftp.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fBp, this.ftp.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fCT = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(fCj, Integer.valueOf(fCk));
        int i3 = d.k.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.k.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.k.report_thread_confirm;
            } else {
                i3 = d.k.del_thread_confirm;
            }
        }
        this.fBr = new com.baidu.tbadk.core.dialog.a(this.ftp.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fBr.cc(i3);
        } else {
            this.fBr.az(false);
            this.fBr.dB(str2);
        }
        this.fBr.C(sparseArray);
        this.fBr.a(d.k.dialog_ok, this.ftp);
        this.fBr.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fBr.au(true);
        this.fBr.b(this.ftp.getPageContext());
        this.fBr.xa();
    }

    public void ao(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.fBu == null) {
            this.fBu = LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.commit_good, (ViewGroup) null);
        }
        this.ftp.getLayoutMode().onModeChanged(this.fBu);
        if (this.fBt == null) {
            this.fBt = new Dialog(this.ftp.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fBt.setCanceledOnTouchOutside(true);
            this.fBt.setCancelable(true);
            this.fBE = (ScrollView) this.fBu.findViewById(d.g.good_scroll);
            this.fBt.setContentView(this.fBu);
            WindowManager.LayoutParams attributes = this.fBt.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds540);
            this.fBt.getWindow().setAttributes(attributes);
            this.cAN = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.as.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        as.this.fBz = (String) compoundButton.getTag();
                        if (as.this.cAM != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : as.this.cAM) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && as.this.fBz != null && !str.equals(as.this.fBz)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fBv = (LinearLayout) this.fBu.findViewById(d.g.good_class_group);
            this.fBx = (TextView) this.fBu.findViewById(d.g.dialog_button_cancel);
            this.fBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fBt instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(as.this.fBt, as.this.ftp.getPageContext());
                    }
                }
            });
            this.fBw = (TextView) this.fBu.findViewById(d.g.dialog_button_ok);
            this.fBw.setOnClickListener(this.djp);
        }
        this.fBv.removeAllViews();
        this.cAM = new ArrayList();
        CustomBlueCheckRadioButton bQ = bQ("0", this.ftp.getPageContext().getString(d.k.thread_good_class));
        this.cAM.add(bQ);
        bQ.setChecked(true);
        this.fBv.addView(bQ);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i2);
                if (abVar != null && !TextUtils.isEmpty(abVar.uf()) && abVar.ug() > 0) {
                    CustomBlueCheckRadioButton bQ2 = bQ(String.valueOf(abVar.ug()), abVar.uf());
                    this.cAM.add(bQ2);
                    View view = new View(this.ftp.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, d.C0141d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fBv.addView(view);
                    this.fBv.addView(bQ2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fBE.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.ftp.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.ftp.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.ftp.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fBE.setLayoutParams(layoutParams2);
            this.fBE.removeAllViews();
            if (this.fBv != null && this.fBv.getParent() == null) {
                this.fBE.addView(this.fBv);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fBt, this.ftp.getPageContext());
    }

    private CustomBlueCheckRadioButton bQ(String str, String str2) {
        Activity pageActivity = this.ftp.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cAN);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void beX() {
        this.ftp.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.ftp.hideProgressBar();
        if (z && z2) {
            this.ftp.showToast(this.ftp.getPageContext().getString(d.k.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.k.neterror);
            }
            this.ftp.showToast(str);
        }
    }

    public void aJY() {
        this.fBn.setVisibility(0);
    }

    public void aJX() {
        this.fBn.setVisibility(8);
    }

    public View beY() {
        if (this.fBu != null) {
            return this.fBu.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String beZ() {
        return this.fBz;
    }

    public View getView() {
        return this.cRQ;
    }

    public void bfa() {
        com.baidu.adp.lib.util.l.b(this.ftp.getPageContext().getPageActivity(), this.ftp.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.ftp.hideProgressBar();
        if (z) {
            bfp();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bfq();
        } else {
            bfp();
        }
    }

    public void bfb() {
        this.dlW.An();
        this.dlW.Ar();
    }

    public void bfc() {
        this.ftp.hideProgressBar();
        As();
        this.fAA.completePullRefreshPostDelayed(2000L);
        bfm();
    }

    public void bfd() {
        this.fAA.completePullRefreshPostDelayed(2000L);
        bfm();
    }

    private void ko(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fBI.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.ftp.getResources().getDimensionPixelSize(d.e.ds130) : this.ftp.getResources().getDimensionPixelSize(d.e.ds34);
        this.fBI.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fBh.setOnLongClickListener(onLongClickListener);
        if (this.fCF != null) {
            this.fCF.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0103b interfaceC0103b, boolean z, boolean z2) {
        if (this.fBA != null) {
            this.fBA.dismiss();
            this.fBA = null;
        }
        this.fBA = new com.baidu.tbadk.core.dialog.b(this.ftp.getPageContext().getPageActivity());
        this.fBA.cf(d.k.operation);
        if (z2) {
            this.fBA.a(new String[]{this.ftp.getPageContext().getString(d.k.copy)}, interfaceC0103b);
        } else if (!z) {
            this.fBA.a(new String[]{this.ftp.getPageContext().getString(d.k.copy), this.ftp.getPageContext().getString(d.k.mark)}, interfaceC0103b);
        } else {
            this.fBA.a(new String[]{this.ftp.getPageContext().getString(d.k.copy), this.ftp.getPageContext().getString(d.k.remove_mark)}, interfaceC0103b);
        }
        this.fBA.d(this.ftp.getPageContext());
        this.fBA.xd();
    }

    public void a(b.InterfaceC0103b interfaceC0103b, boolean z) {
        if (this.fBB != null) {
            this.fBB.dismiss();
            this.fBB = null;
        }
        this.fBB = new com.baidu.tbadk.core.dialog.b(this.ftp.getPageContext().getPageActivity());
        this.fBB.cf(d.k.operation);
        if (z) {
            this.fBB.a(new String[]{this.ftp.getPageContext().getString(d.k.save_to_emotion)}, interfaceC0103b);
        } else {
            this.fBB.a(new String[]{this.ftp.getPageContext().getString(d.k.save_to_emotion), this.ftp.getPageContext().getString(d.k.save_to_local)}, interfaceC0103b);
        }
        this.fBB.d(this.ftp.getPageContext());
        this.fBB.xd();
    }

    public int bfe() {
        return qI(this.fAA.getFirstVisiblePosition());
    }

    private int qI(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fAA.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fAA.getAdapter() == null || !(this.fAA.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fAA.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bff() {
        int lastVisiblePosition = this.fAA.getLastVisiblePosition();
        if (this.fAq != null) {
            if (lastVisiblePosition == this.fAA.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return qI(lastVisiblePosition);
    }

    public void qJ(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fAA != null) {
            if (this.fAw == null || this.fAw.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fAw.mNavigationBar.getFixedNavHeight();
                if (this.ftp.bbV() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fCa != null && (layoutParams = (LinearLayout.LayoutParams) this.fCa.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fCa.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fAA.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fAA.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fBk.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fBh.a(dVar, false);
        this.fBh.notifyDataSetChanged();
        bfm();
        if (this.fCF != null) {
            this.fCF.bbp();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fAQ == null) {
            this.ftp.getLayoutMode().onModeChanged(((ViewStub) this.fAB.findViewById(d.g.praise_layout)).inflate());
            this.fAQ = (FrsPraiseView) this.fAB.findViewById(d.g.pb_head_praise_view);
            this.fAQ.setIsFromPb(true);
            this.fBf = this.fAB.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fAQ.dC(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fAQ != null) {
            boolean bfm = bfm();
            this.fAQ.setVisibility(8);
            if (dVar != null && dVar.uB() != null && dVar.uB().uy() == 0 && this.ftG) {
                if (bfm) {
                    this.fBe.setVisibility(0);
                    return;
                } else {
                    this.fBe.setVisibility(8);
                    return;
                }
            }
            this.fBe.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bay() != null) {
            return dVar.bay();
        }
        if (!com.baidu.tbadk.core.util.w.z(dVar.baq())) {
            Iterator<PostData> it = dVar.baq().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bwZ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bav();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.vm() != null && postData.vm().getUserTbVipInfoData() != null && postData.vm().getUserTbVipInfoData().getvipIntro() != null) {
            postData.vm().getGodUserData().setIntro(postData.vm().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bao() == null || dVar.bao().vm() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData vm = dVar.bao().vm();
        String userId = vm.getUserId();
        HashMap<String, MetaData> userMap = dVar.bao().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = vm;
        }
        postData.tz(1);
        postData.setId(dVar.bao().vC());
        postData.setTitle(dVar.bao().getTitle());
        postData.setTime(dVar.bao().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0317  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String e;
        ArrayList<IconData> tShowInfoNew;
        int e2;
        com.baidu.tbadk.data.f bxc;
        String portrait;
        if (dVar != null && dVar.bao() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fAG.setVisibility(8);
            if (dVar.bao() != null && dVar.bao().vX() && dVar.bao().vD() != null) {
                this.fCu = true;
                this.fAw.kK(this.fCu);
                this.fAw.mNavigationBar.hideBottomLine();
                if (this.fAq == null) {
                    this.fAq = new com.baidu.tieba.pb.video.i(this.ftp, this.fAw, dVar.bao().vD(), this.fAr);
                    this.fAq.a(dVar.bao().vD(), dVar.bao(), dVar.getForumId());
                    this.fAq.startPlay();
                } else if (this.fAu) {
                    this.fAq.a(dVar.bao().vD(), dVar.bao(), dVar.getForumId());
                    this.fAq.startPlay();
                } else {
                    this.fAq.rM(dVar.getForumId());
                }
                if (dVar.bap() != null && dVar.bap().size() >= 1) {
                    bd bdVar = dVar.bap().get(0);
                    this.fAq.al(bdVar);
                    this.fAq.rN(bdVar.getTitle());
                }
                this.fAq.b(b, dVar.bao(), dVar.baK());
                this.fAu = false;
                this.fAA.removeHeaderView(this.fAq.bhy());
                this.fAA.addHeaderView(this.fAq.bhy(), 0);
                if (this.fAq.bhw() != null && this.fAq.bhw().getParent() == null) {
                    this.fBY.addView(this.fAq.bhw());
                }
                if (this.fAs == null) {
                    this.fAs = new com.baidu.tieba.pb.video.h(this.ftp);
                }
                this.fAs.a(dVar.bao().wm(), dVar.bao(), dVar.baH());
                this.fAA.removeHeaderView(this.fAs.bhn());
                this.fAA.addHeaderView(this.fAs.bhn(), 1);
                if (dVar.bao().wm() != null) {
                    this.fAA.removeHeaderView(this.fAs.bho());
                    this.fAA.removeHeaderView(this.fAE);
                    this.fAA.addHeaderView(this.fAs.bho(), 2);
                } else {
                    if (this.fAs.bho() != null) {
                        this.fAA.removeHeaderView(this.fAs.bho());
                    }
                    this.fAA.removeHeaderView(this.fAE);
                    this.fAE.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.ftp, d.e.tbds56));
                    this.fAA.addHeaderView(this.fAE, 2);
                }
                if (this.fAq != null) {
                    this.fAw.kE(false);
                    this.fAw.kG(TbadkCoreApplication.isLogin());
                    this.fAq.qQ(TbadkCoreApplication.getInst().getSkinType());
                }
                bfj();
            } else {
                this.fCu = false;
                this.fAw.kK(this.fCu);
                if (this.fAq != null) {
                    this.fAA.removeHeaderView(this.fAq.bhy());
                }
                if (this.fAs != null) {
                    this.fAs.b(this.fAA);
                }
                if (b == null || (b != null && (b.bxb() == null || com.baidu.tbadk.core.util.w.z(b.bxb().Ng())))) {
                    this.fAE.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.ftp, d.e.tbds80));
                } else {
                    this.fAE.setPadding(0, 0, 0, 0);
                }
            }
            if (this.ftp.bbJ() != null) {
                this.ftp.bbJ().kC(this.fCu);
            }
            if (this.fAq != null) {
                this.fAq.J(this.fCV);
            }
            if (b != null) {
                this.fBQ = b;
                this.fAG.setVisibility(0);
                if (this.ftp.bcu()) {
                    if (dVar.ban() != null) {
                        this.mForumName = dVar.ban().getForumName();
                        this.mForumId = dVar.ban().getForumId();
                    }
                    if (this.mForumName == null && this.ftp.bbt() != null && this.ftp.bbt().bdg() != null) {
                        this.mForumName = this.ftp.bbt().bdg();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fAG.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fAG.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fCK) {
                    this.fAC.setVisibility(0);
                }
                if (!dVar.bao().vX() && this.fAD.getText() != null && this.fAD.getText().length() > 0) {
                    this.fAD.setVisibility(0);
                } else {
                    this.fAD.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> vx = dVar.bao().vx();
                if (vx != null && vx.size() > 0 && !this.fCK) {
                    this.fBT.setText(String.valueOf(vx.get(0).tL()));
                    this.fBS.setVisibility(0);
                } else {
                    this.fBS.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.fBS, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.fBT, d.C0141d.cp_link_tip_d, 1);
                if (b.vm() != null) {
                    String string = b.vm().getName_show() == null ? StringUtils.string(b.vm().getUserName()) : StringUtils.string(b.vm().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.vm().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bg(b.vm().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bg(string) > 12) {
                            e = com.baidu.tbadk.core.util.ao.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.vm().getIconInfo();
                            tShowInfoNew = b.vm().getTShowInfoNew();
                            if (this.fuF != null) {
                                this.fuF.setTag(d.g.tag_user_id, b.vm().getUserId());
                                this.fuF.setOnClickListener(this.ftp.frr.fEG);
                                this.fuF.a(iconInfo, 4, this.ftp.getResources().getDimensionPixelSize(d.e.tbds36), this.ftp.getResources().getDimensionPixelSize(d.e.tbds36), this.ftp.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fuE != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fuE.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fuE.setOnClickListener(this.ftp.frr.fEH);
                                this.fuE.a(tShowInfoNew, 3, this.ftp.getResources().getDimensionPixelSize(d.e.tbds36), this.ftp.getResources().getDimensionPixelSize(d.e.tbds36), this.ftp.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fAI.setText(ak(b.vm().getSealPrefix(), e));
                            this.fAI.setTag(d.g.tag_user_id, b.vm().getUserId());
                            this.fAI.setTag(d.g.tag_user_name, b.vm().getName_show());
                            if (com.baidu.tbadk.core.util.w.z(tShowInfoNew) || b.vm().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.fAI, d.C0141d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.fAI, d.C0141d.cp_cont_f, 1);
                            }
                            this.fAJ.setVisibility(8);
                            if (dVar.bao().vm() != null && dVar.bao().vm().getAlaUserData() != null && this.fAO != null) {
                                if (dVar.bao().vm().getAlaUserData().anchor_live != 0) {
                                    this.fAO.setVisibility(8);
                                } else {
                                    this.fAO.setVisibility(0);
                                    if (this.fAt == null) {
                                        this.fAt = new com.baidu.tieba.c.d(this.ftp.getPageContext(), this.fAO);
                                        this.fAt.jh(1);
                                    }
                                    this.fAt.aQ(this.ftp.getResources().getString(d.k.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aak = dVar.bao().vm().getAlaUserData();
                                    aVar.type = 2;
                                    this.fAO.setTag(aVar);
                                }
                            }
                            this.fAN.setUserId(b.vm().getUserId());
                            this.fAN.setUserName(b.vm().getUserName());
                            this.fAN.setImageDrawable(null);
                            this.fAN.setRadius(com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds40));
                            this.fAN.setTag(b.vm().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fAW.setText(com.baidu.tbadk.core.util.ao.w(b.getTime()));
                            } else {
                                this.fAW.setText(com.baidu.tbadk.core.util.ao.v(b.getTime()));
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds16);
                            if (!this.ftp.bcu() && !StringUtils.isNull(this.mForumName)) {
                                this.axM.setText(this.ftp.getString(d.k.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.axM.setVisibility(0);
                                this.fAZ.setVisibility(0);
                                this.fAW.setPadding(e2, 0, e2, 0);
                            } else {
                                this.axM.setVisibility(8);
                                this.fAZ.setVisibility(8);
                                this.fAW.setPadding(0, 0, e2, 0);
                            }
                            bxc = b.bxc();
                            if (bxc == null && !TextUtils.isEmpty(bxc.getName()) && !TextUtils.isEmpty(bxc.getName().trim())) {
                                final String name = bxc.getName();
                                final String lat = bxc.getLat();
                                final String lng = bxc.getLng();
                                this.fAX.setVisibility(0);
                                this.fAY.setVisibility(0);
                                this.fAX.setText(bxc.getName());
                                this.fAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.jD()) {
                                                as.this.ftp.showToast(d.k.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.O(as.this.ftp.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, as.this.ftp.getPageContext().getString(d.k.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fAX.setVisibility(8);
                                this.fAY.setVisibility(8);
                            }
                            portrait = b.vm().getPortrait();
                            if (b.vm().getPendantData() == null && !StringUtils.isNull(b.vm().getPendantData().ub())) {
                                UtilHelper.showHeadImageViewBigV(this.fAL.getHeadView(), b.vm());
                                this.fAN.setVisibility(8);
                                this.fAL.setVisibility(0);
                                if (this.fAR != null) {
                                    this.fAR.setVisibility(8);
                                }
                                this.fAI.setOnClickListener(this.fCV);
                                this.fAL.getHeadView().startLoad(portrait, 28, false);
                                this.fAL.getHeadView().setUserId(b.vm().getUserId());
                                this.fAL.getHeadView().setUserName(b.vm().getUserName());
                                this.fAL.getHeadView().setOnClickListener(this.fCV);
                                this.fAL.fj(b.vm().getPendantData().ub());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fAN, b.vm());
                                this.fAN.setVisibility(0);
                                this.fAG.setOnClickListener(this.fCV);
                                this.fAI.setOnClickListener(this.fCV);
                                this.fAN.setOnClickListener(this.fCV);
                                this.fAL.setVisibility(8);
                                this.fAN.startLoad(portrait, 28, false);
                            }
                            String name_show = b.vm().getName_show();
                            String userName = b.vm().getUserName();
                            if (com.baidu.tbadk.o.ah.ip() && name_show != null && !name_show.equals(userName)) {
                                this.fAI.setText(com.baidu.tieba.pb.c.aj(this.ftp.getPageContext().getPageActivity(), this.fAI.getText().toString()));
                                this.fAI.setGravity(16);
                                this.fAI.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aZW());
                                com.baidu.tbadk.core.util.al.c(this.fAI, d.C0141d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.vm().getIconInfo();
                        tShowInfoNew = b.vm().getTShowInfoNew();
                        if (this.fuF != null) {
                        }
                        if (this.fuE != null) {
                        }
                        this.fAI.setText(ak(b.vm().getSealPrefix(), e));
                        this.fAI.setTag(d.g.tag_user_id, b.vm().getUserId());
                        this.fAI.setTag(d.g.tag_user_name, b.vm().getName_show());
                        if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fAI, d.C0141d.cp_cont_h, 1);
                        this.fAJ.setVisibility(8);
                        if (dVar.bao().vm() != null) {
                            if (dVar.bao().vm().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fAN.setUserId(b.vm().getUserId());
                        this.fAN.setUserName(b.vm().getUserName());
                        this.fAN.setImageDrawable(null);
                        this.fAN.setRadius(com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds40));
                        this.fAN.setTag(b.vm().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds16);
                        if (!this.ftp.bcu()) {
                        }
                        this.axM.setVisibility(8);
                        this.fAZ.setVisibility(8);
                        this.fAW.setPadding(0, 0, e2, 0);
                        bxc = b.bxc();
                        if (bxc == null) {
                        }
                        this.fAX.setVisibility(8);
                        this.fAY.setVisibility(8);
                        portrait = b.vm().getPortrait();
                        if (b.vm().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fAN, b.vm());
                        this.fAN.setVisibility(0);
                        this.fAG.setOnClickListener(this.fCV);
                        this.fAI.setOnClickListener(this.fCV);
                        this.fAN.setOnClickListener(this.fCV);
                        this.fAL.setVisibility(8);
                        this.fAN.startLoad(portrait, 28, false);
                        String name_show2 = b.vm().getName_show();
                        String userName2 = b.vm().getUserName();
                        if (com.baidu.tbadk.o.ah.ip()) {
                            this.fAI.setText(com.baidu.tieba.pb.c.aj(this.ftp.getPageContext().getPageActivity(), this.fAI.getText().toString()));
                            this.fAI.setGravity(16);
                            this.fAI.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aZW());
                            com.baidu.tbadk.core.util.al.c(this.fAI, d.C0141d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bg(string) > 14) {
                            e = com.baidu.tbadk.core.util.ao.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.vm().getIconInfo();
                            tShowInfoNew = b.vm().getTShowInfoNew();
                            if (this.fuF != null) {
                            }
                            if (this.fuE != null) {
                            }
                            this.fAI.setText(ak(b.vm().getSealPrefix(), e));
                            this.fAI.setTag(d.g.tag_user_id, b.vm().getUserId());
                            this.fAI.setTag(d.g.tag_user_name, b.vm().getName_show());
                            if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.fAI, d.C0141d.cp_cont_h, 1);
                            this.fAJ.setVisibility(8);
                            if (dVar.bao().vm() != null) {
                            }
                            this.fAN.setUserId(b.vm().getUserId());
                            this.fAN.setUserName(b.vm().getUserName());
                            this.fAN.setImageDrawable(null);
                            this.fAN.setRadius(com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds40));
                            this.fAN.setTag(b.vm().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds16);
                            if (!this.ftp.bcu()) {
                            }
                            this.axM.setVisibility(8);
                            this.fAZ.setVisibility(8);
                            this.fAW.setPadding(0, 0, e2, 0);
                            bxc = b.bxc();
                            if (bxc == null) {
                            }
                            this.fAX.setVisibility(8);
                            this.fAY.setVisibility(8);
                            portrait = b.vm().getPortrait();
                            if (b.vm().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fAN, b.vm());
                            this.fAN.setVisibility(0);
                            this.fAG.setOnClickListener(this.fCV);
                            this.fAI.setOnClickListener(this.fCV);
                            this.fAN.setOnClickListener(this.fCV);
                            this.fAL.setVisibility(8);
                            this.fAN.startLoad(portrait, 28, false);
                            String name_show22 = b.vm().getName_show();
                            String userName22 = b.vm().getUserName();
                            if (com.baidu.tbadk.o.ah.ip()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.vm().getIconInfo();
                        tShowInfoNew = b.vm().getTShowInfoNew();
                        if (this.fuF != null) {
                        }
                        if (this.fuE != null) {
                        }
                        this.fAI.setText(ak(b.vm().getSealPrefix(), e));
                        this.fAI.setTag(d.g.tag_user_id, b.vm().getUserId());
                        this.fAI.setTag(d.g.tag_user_name, b.vm().getName_show());
                        if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fAI, d.C0141d.cp_cont_h, 1);
                        this.fAJ.setVisibility(8);
                        if (dVar.bao().vm() != null) {
                        }
                        this.fAN.setUserId(b.vm().getUserId());
                        this.fAN.setUserName(b.vm().getUserName());
                        this.fAN.setImageDrawable(null);
                        this.fAN.setRadius(com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds40));
                        this.fAN.setTag(b.vm().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.ftp.getActivity(), d.e.ds16);
                        if (!this.ftp.bcu()) {
                        }
                        this.axM.setVisibility(8);
                        this.fAZ.setVisibility(8);
                        this.fAW.setPadding(0, 0, e2, 0);
                        bxc = b.bxc();
                        if (bxc == null) {
                        }
                        this.fAX.setVisibility(8);
                        this.fAY.setVisibility(8);
                        portrait = b.vm().getPortrait();
                        if (b.vm().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fAN, b.vm());
                        this.fAN.setVisibility(0);
                        this.fAG.setOnClickListener(this.fCV);
                        this.fAI.setOnClickListener(this.fCV);
                        this.fAN.setOnClickListener(this.fCV);
                        this.fAL.setVisibility(8);
                        this.fAN.startLoad(portrait, 28, false);
                        String name_show222 = b.vm().getName_show();
                        String userName222 = b.vm().getUserName();
                        if (com.baidu.tbadk.o.ah.ip()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fAF.ad(dVar.bao());
                }
                if (this.fCb != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fpb);
                    if (dVar != null && dVar.bao() != null) {
                        hVar.fpd = dVar.bao().ve();
                    }
                    hVar.isNew = !this.ftG;
                    hVar.fpf = this.ftp.bct();
                    this.fCb.a(hVar);
                }
            }
        }
    }

    public void kp(boolean z) {
        if (z) {
            bfg();
        } else {
            apc();
        }
        this.fCf.fDm = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fCf));
        a(this.fCf.fDm, false);
    }

    public void bfg() {
        if (this.fAw != null && !this.fCw) {
            this.fAw.kL(!StringUtils.isNull(this.ftp.bbS()));
            this.fCw = true;
        }
    }

    public void apc() {
        if (this.fAw != null) {
            this.fAw.bgl();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.vG() != null) {
            this.fAH.setData(this.ftp.getPageContext(), dVar.baq().get(0).vG(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.bam().getId(), dVar.bam().getName(), dVar.bao().getId(), this.ftp.bcq() ? "FRS" : null));
            this.fAG.setPadding(this.fAG.getPaddingLeft(), (int) this.ftp.getResources().getDimension(d.e.ds20), this.fAG.getPaddingRight(), this.fAG.getPaddingBottom());
            return;
        }
        this.fAH.setData(null, null, null);
    }

    public void bfh() {
        if (this.fAq != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").r("obj_type", 1));
            this.fAq.bhx();
            this.fAA.smoothScrollToPosition(0);
        }
    }

    public boolean bfi() {
        return this.fCW;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean af(bd bdVar) {
        if (bdVar == null || bdVar.vm() == null || bdVar.vm().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.vm().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fAw.bgj();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fAw.pf(cVar.forumName);
            }
            String string = this.ftp.getResources().getString(d.k.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(cVar.source, 0)) {
                case 100:
                    str = this.ftp.getResources().getString(d.k.self);
                    break;
                case 300:
                    str = this.ftp.getResources().getString(d.k.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.ftp.getResources().getString(d.k.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fom;
            this.ftp.showNetRefreshView(this.cRQ, format, null, this.ftp.getResources().getString(d.k.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.jU()) {
                        ay.zG().c(as.this.ftp.getPageContext(), new String[]{str2});
                        as.this.ftp.finish();
                        return;
                    }
                    as.this.ftp.showToast(d.k.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable beq;
        Parcelable beq2;
        String str;
        if (dVar != null) {
            this.fwM = dVar;
            this.mType = i;
            if (dVar.bao() != null) {
                this.fCh = dVar.bao().uX();
                if (dVar.bao().getAnchorLevel() != 0) {
                    this.fCW = true;
                }
                this.fBD = af(dVar.bao());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fBR = false;
            this.ftG = z;
            bfc();
            b(dVar, z, i);
            p(dVar);
            if (this.fCI == null) {
                this.fCI = new ab(this.ftp.getPageContext(), this.dBp);
            }
            this.fCI.rs(dVar.bat());
            if (this.ftp.bch()) {
                if (this.fBl == null) {
                    this.fBl = new com.baidu.tieba.pb.view.e(this.ftp.getPageContext());
                    this.fBl.nn();
                    this.fBl.a(this.awh);
                }
                this.fAA.setPullRefresh(this.fBl);
                bfj();
                if (this.fBl != null) {
                    this.fBl.dy(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.uB().uy() == 0 && z) {
                this.fAA.setPullRefresh(null);
            } else {
                if (this.fBl == null) {
                    this.fBl = new com.baidu.tieba.pb.view.e(this.ftp.getPageContext());
                    this.fBl.nn();
                    this.fBl.a(this.awh);
                }
                this.fAA.setPullRefresh(this.fBl);
                bfj();
                if (this.fBl != null) {
                    this.fBl.dy(TbadkCoreApplication.getInst().getSkinType());
                }
                adT();
            }
            bfm();
            this.fBh.jy(this.ftG);
            this.fBh.jz(false);
            this.fBh.jK(i == 5);
            this.fBh.jL(i == 6);
            this.fBh.jM(z2 && this.fCU);
            this.fBh.a(dVar, false);
            this.fBh.notifyDataSetChanged();
            if (this.ftp.bcu()) {
                this.fCy = 0;
                PostData b = b(dVar, z);
                if (b != null && b.vm() != null) {
                    this.fCy = b.vm().getLevel_id();
                }
                if (this.fCy > 0) {
                    this.fAK.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.fAK, BitmapHelper.getGradeResourceIdInEnterForum(this.fCy));
                } else {
                    this.fAK.setVisibility(8);
                }
            } else {
                this.fAK.setVisibility(8);
            }
            if (dVar.bao() != null) {
                if (dVar.bao().va() != null) {
                    if (dVar.bao().va().getNum() < 1) {
                        str = this.ftp.getResources().getString(d.k.zan);
                    } else {
                        str = dVar.bao().va().getNum() + "";
                    }
                    if (this.fAp != -1) {
                        dVar.bao().va().setIsLike(this.fAp);
                    }
                    M(str, dVar.bao().va().getIsLike() == 1);
                }
                if (dVar.bao().ajP != null && dVar.bao().ajP.isDeleted) {
                    this.fAw.kF(true);
                } else {
                    this.fAw.kF(false);
                }
            }
            if (this.ftp.isLogin()) {
                this.fAA.setNextPage(this.dlW);
                this.fAv = 2;
                adT();
            } else {
                this.fBR = true;
                if (dVar.uB().ux() == 1) {
                    if (this.fBm == null) {
                        this.fBm = new com.baidu.tieba.pb.view.a(this.ftp.getPageContext());
                    }
                    this.fAA.setNextPage(this.fBm);
                } else {
                    this.fAA.setNextPage(this.dlW);
                }
                this.fAv = 3;
            }
            ArrayList<PostData> baq = dVar.baq();
            if (dVar.uB().ux() == 0 || baq == null || baq.size() < dVar.uB().uw()) {
                if (com.baidu.tbadk.core.util.w.y(baq) == 0 || (com.baidu.tbadk.core.util.w.y(baq) == 1 && baq.get(0) != null && baq.get(0).bwZ() == 1)) {
                    this.dlW.setText(this.ftp.getResources().getString(d.k.list_no_more_new));
                    if (this.ftp.bbJ() != null && !this.ftp.bbJ().bfZ()) {
                        this.ftp.bbJ().showFloatingView();
                    }
                } else if (dVar.uB().ux() == 0) {
                    this.dlW.setText(this.ftp.getResources().getString(d.k.list_has_no_more));
                } else {
                    this.dlW.setText(this.ftp.getResources().getString(d.k.load_more));
                }
                if (this.ftp.bch() && this.fAA != null && this.fAA.getData() != null && this.fAA.getData().size() == 1 && (this.fAA.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dlW.setText("");
                }
                bft();
            } else if (z2) {
                if (this.fCU) {
                    As();
                    if (dVar.uB().ux() != 0) {
                        this.dlW.setText(this.ftp.getResources().getString(d.k.pb_load_more));
                    }
                } else {
                    this.dlW.An();
                    this.dlW.showLoading();
                }
            } else {
                this.dlW.An();
                this.dlW.showLoading();
            }
            switch (i) {
                case 2:
                    this.fAA.setSelection(i2 > 1 ? (((this.fAA.getData() == null && dVar.baq() == null) ? 0 : (this.fAA.getData().size() - dVar.baq().size()) + this.fAA.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (beq2 = ai.bep().beq()) != null) {
                        this.fAA.onRestoreInstanceState(beq2);
                        if (com.baidu.tbadk.core.util.w.y(baq) > 1 && dVar.uB().ux() > 0) {
                            this.dlW.As();
                            this.dlW.setText(this.ftp.getString(d.k.pb_load_more_without_point));
                            this.dlW.Ao();
                            break;
                        }
                    } else {
                        this.fAA.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fCU = false;
                    break;
                case 5:
                    this.fAA.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (beq = ai.bep().beq()) != null) {
                        this.fAA.onRestoreInstanceState(beq);
                        break;
                    } else {
                        this.fAA.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.fAq != null && this.fAq.bhw() != null) {
                            if (this.ftp.isUseStyleImmersiveSticky()) {
                                this.fAA.setSelectionFromTop((this.fBh.bcL() + this.fAA.getHeaderViewsCount()) - 1, this.fAq.bhw().getHeight() - com.baidu.adp.lib.util.l.o(this.ftp.getPageContext().getPageActivity()));
                            } else {
                                this.fAA.setSelectionFromTop((this.fBh.bcL() + this.fAA.getHeaderViewsCount()) - 1, this.fAq.bhw().getHeight());
                            }
                        } else {
                            this.fAA.setSelection(this.fBh.bcL() + this.fAA.getHeaderViewsCount());
                        }
                    } else {
                        this.fAA.setSelection(i2 > 0 ? ((this.fAA.getData() == null && dVar.baq() == null) ? 0 : (this.fAA.getData().size() - dVar.baq().size()) + this.fAA.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dlW.As();
                    this.dlW.setText(this.ftp.getString(d.k.pb_load_more_without_point));
                    this.dlW.Ao();
                    break;
            }
            if (this.fCh == fCi && isHost()) {
                bfB();
            }
            if (this.fCs) {
                beB();
                this.fCs = false;
                if (i3 == 0) {
                    ki(true);
                }
            }
            if (this.fAs != null) {
                this.fAs.ak(dVar.bao());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.foS == 1 || dVar.foT == 1) {
                if (this.fCz == null) {
                    this.fCz = new PbTopTipView(this.ftp);
                }
                if (dVar.foT == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.ftp.getStType())) {
                    this.fCz.setText(this.ftp.getString(d.k.pb_read_strategy_add_experience));
                    this.fCz.show(this.cRQ, this.mSkinType);
                } else if (dVar.foS == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.ftp.getStType())) {
                    this.fCz.setText(this.ftp.getString(d.k.pb_read_news_add_experience));
                    this.fCz.show(this.cRQ, this.mSkinType);
                }
            }
        }
    }

    private void bfj() {
        if (this.fAq != null && this.fAq.bhw() != null) {
            this.fAA.removeHeaderView(this.aHw);
            if (this.mType != 1) {
                this.fAA.removeHeaderView(this.fAq.bhy());
                this.fAA.addHeaderView(this.fAq.bhy(), 0);
                return;
            }
            return;
        }
        if (this.fAq != null) {
            this.fAA.removeHeaderView(this.fAq.bhy());
        }
        this.fAA.removeHeaderView(this.aHw);
        this.fAA.addHeaderView(this.aHw, 0);
    }

    public void kq(boolean z) {
        this.fBC = z;
    }

    public void As() {
        if (this.dlW != null) {
            this.dlW.Ao();
            this.dlW.As();
        }
        adT();
    }

    public void showListView() {
        this.fAA.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fBQ != null && this.fBQ.vm() != null && this.fAw != null) {
            this.fCv = !this.fCu;
            this.fAw.kE(this.fCv);
            if (this.ftp.bbJ() != null) {
                this.ftp.bbJ().kD(this.fCv);
            }
            bfk();
            if (this.fCv) {
                this.fAw.fFu.setVisibility(0);
                if (this.fBD) {
                    this.fAw.fFv.setVisibility(8);
                    this.fAS.setVisibility(8);
                    this.fAV.setVisibility(0);
                    this.fAV.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.ao.B(dVar.baJ())));
                } else if (!PbNormalLikeButtonSwitchStatic.KK() || (this.fBQ.vm().hadConcerned() && this.fBQ.vm().getGodUserData() != null && this.fBQ.vm().getGodUserData().getIsFromNetWork())) {
                    this.fAw.fFv.setVisibility(8);
                }
                if (this.fCa != null) {
                    this.fCa.setVisibility(8);
                }
                this.fAw.a(this.fBQ.vm(), this.fCV);
                if (this.fCG == null) {
                    this.fCG = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.as.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > as.this.fCx) {
                                as.this.bfA();
                            }
                        }
                    };
                }
                this.fAA.setListViewDragListener(this.fCG);
                return;
            }
            if (this.fAw.fFu != null) {
                this.fAw.fFu.setVisibility(8);
            }
            if (this.fCa != null) {
                this.fCa.setVisibility(0);
            }
            if (this.fBD) {
                this.fAS.setVisibility(8);
                this.fAV.setVisibility(0);
                this.fAV.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.ao.B(dVar.baJ())));
            } else if (!PbNormalLikeButtonSwitchStatic.KK() || (this.fBQ.vm().hadConcerned() && this.fBQ.vm().getGodUserData() != null && this.fBQ.vm().getGodUserData().getIsFromNetWork())) {
                this.fAS.setVisibility(8);
                this.fAV.setVisibility(8);
            } else {
                this.fAV.setVisibility(8);
            }
            this.fCG = null;
            this.fAA.setListViewDragListener(null);
        }
    }

    private void bfk() {
        String threadId = this.fwM != null ? this.fwM.getThreadId() : "";
        int bfl = bfl();
        if (this.fCv) {
            if (this.fAU == null) {
                this.fAU = new aq(this.ftp.getPageContext(), this.fAw.fFv, 3);
                this.fAU.h(this.ftp.getUniqueId());
            }
            if (this.fBQ != null && this.fBQ.vm() != null) {
                this.fBQ.vm().setIsLike(this.fBQ.vm().hadConcerned());
                this.fAU.a(this.fBQ.vm());
            }
            this.fAU.dh(threadId);
            this.fAU.qH(bfl);
            this.fAU.fAl = this.fCu;
        }
        if (this.fAT == null) {
            this.fAT = new aq(this.ftp.getPageContext(), this.fAS, 1);
            this.fAT.h(this.ftp.getUniqueId());
            this.fAT.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.as.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aV(boolean z) {
                    if (as.this.ftp != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(as.this.ftp, d.k.attention_success);
                            return;
                        }
                        ar.v(as.this.ftp.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fBQ != null && this.fBQ.vm() != null) {
            this.fBQ.vm().setIsLike(this.fBQ.vm().hadConcerned());
            this.fAT.a(this.fBQ.vm());
            this.fAT.dh(threadId);
        }
        this.fAT.fAl = this.fCu;
        this.fAT.qH(bfl);
    }

    private int bfl() {
        if (this.fwM == null || this.fwM.bao() == null) {
            return 0;
        }
        if (this.fwM.bao().wu()) {
            return (com.baidu.tbadk.core.util.w.z(this.fwM.baI()) && (this.fwM.ban() == null || StringUtils.isNull(this.fwM.ban().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bfm() {
        boolean z;
        if (this.fBG != null && this.fBG.getVisibility() == 0) {
            if (this.fBd != null) {
                this.fBd.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fBd != null) {
                this.fBd.setVisibility(8);
            }
            z = false;
        }
        if ((this.fBf == null || this.fBf.getVisibility() == 8) && z && this.ftG) {
            this.fBe.setVisibility(0);
        } else {
            this.fBe.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bao() == null) {
            return false;
        }
        if (dVar.bao().vj() == 1 || dVar.bao().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bao().vl() == null || dVar.bao().vl().wO() == 0) || dVar.bao().vh() == 1 || dVar.bao().vi() == 1 || dVar.bao().vP() || dVar.bao().wb() || dVar.bao().vW() || dVar.bao().vy() != null || !com.baidu.tbadk.core.util.ao.isEmpty(dVar.bao().getCategory()) || dVar.bao().vp() || dVar.bao().vo();
    }

    private SpannableStringBuilder ak(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.ftp.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fAC != null) {
                if (dVar.bao() != null && dVar.bao().vB() == 0 && !dVar.bao().vX() && !this.fCK) {
                    this.fAC.setVisibility(0);
                    if (dVar.bao() != null) {
                        bd bao = dVar.bao();
                        bao.e(true, q(dVar));
                        bao.setResource(3);
                        bao.dl("2");
                    }
                    SpannableStringBuilder vK = dVar.bao().vK();
                    this.fAD.setOnTouchListener(new com.baidu.tieba.view.k(vK));
                    if (this.fCH) {
                        this.fAD.setText(dVar.bao().getTitle());
                    } else {
                        this.fAD.setText(vK);
                    }
                    this.fAD.setVisibility(0);
                } else if (dVar.bao().vB() == 1) {
                    if (dVar.bao() != null) {
                        this.fAC.setVisibility(8);
                        this.fAA.removeHeaderView(this.fAC);
                        if (dVar.bao() != null && !dVar.bao().vX()) {
                            this.fAG.setPadding(this.fAG.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.tbds36), this.fAG.getPaddingRight(), this.fAG.getPaddingBottom());
                        }
                    }
                } else {
                    this.fAC.setVisibility(8);
                    this.fAA.removeHeaderView(this.fAC);
                    if (dVar.bao() != null && dVar.bao().vX()) {
                        this.fAG.setPadding(this.fAG.getPaddingLeft(), 0, this.fAG.getPaddingRight(), this.fAG.getPaddingBottom());
                    } else {
                        this.fAG.setPadding(this.fAG.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds48), this.fAG.getPaddingRight(), this.fAG.getPaddingBottom());
                    }
                }
            }
            this.ftG = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bfm();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.u uVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.vm().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.baA()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.vm() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.vm().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_name_show, b.vm().getName_show());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.baA()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<az> baI = dVar.baI();
                if (com.baidu.tbadk.core.util.w.y(baI) > 0) {
                    sb = new StringBuilder();
                    for (az azVar : baI) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ahC) != null && uVar.afG && !uVar.isDeleted && (uVar.type == 1 || uVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.ftp.getString(d.k.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.ftp.getString(d.k.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.aSj;
    }

    public void rt(String str) {
        if (this.dlW != null) {
            this.dlW.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fAA;
    }

    public int bfn() {
        return d.g.richText;
    }

    public TextView bbE() {
        return this.fAF.bbE();
    }

    public void e(BdListView.e eVar) {
        this.fAA.setOnSrollToBottomListener(eVar);
    }

    public void a(f.b bVar) {
        this.awh = bVar;
        if (this.fBl != null) {
            this.fBl.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.am amVar, a.b bVar) {
        if (amVar != null) {
            int uv = amVar.uv();
            int us = amVar.us();
            if (this.fBi != null) {
                this.fBi.xa();
            } else {
                this.fBi = new com.baidu.tbadk.core.dialog.a(this.ftp.getPageContext().getPageActivity());
                this.fBj = LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.dialog_direct_pager, (ViewGroup) null);
                this.fBi.w(this.fBj);
                this.fBi.a(d.k.dialog_ok, bVar);
                this.fBi.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        as.this.bfp();
                        aVar.dismiss();
                    }
                });
                this.fBi.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.as.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (as.this.fCp == null) {
                            as.this.fCp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    as.this.ftp.HidenSoftKeyPad((InputMethodManager) as.this.ftp.getSystemService("input_method"), as.this.cRQ);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.im().postDelayed(as.this.fCp, 150L);
                    }
                });
                this.fBi.b(this.ftp.getPageContext()).xa();
            }
            this.fBk = (EditText) this.fBj.findViewById(d.g.input_page_number);
            this.fBk.setText("");
            TextView textView = (TextView) this.fBj.findViewById(d.g.current_page_number);
            if (uv <= 0) {
                uv = 1;
            }
            if (us <= 0) {
                us = 1;
            }
            textView.setText(MessageFormat.format(this.ftp.getApplicationContext().getResources().getString(d.k.current_page), Integer.valueOf(uv), Integer.valueOf(us)));
            this.ftp.ShowSoftKeyPadDelay(this.fBk, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fAA.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.ftp.showToast(str);
    }

    public boolean kr(boolean z) {
        if (this.Qh == null || !this.Qh.Hj()) {
            return false;
        }
        this.Qh.FB();
        return true;
    }

    public void bfo() {
        if (this.fCX != null) {
            while (this.fCX.size() > 0) {
                TbImageView remove = this.fCX.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bfo();
        this.fBh.qu(1);
        if (this.fAq != null) {
            this.fAq.onPause();
        }
    }

    public void onResume() {
        this.fBh.qu(2);
        if (this.fAq != null) {
            this.fAq.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fCr != null) {
            this.fCr.destroy();
        }
        if (this.fCI != null) {
            this.fCI.onDestory();
        }
        if (this.fCz != null) {
            this.fCz.hide();
        }
        if (this.fAt != null) {
            this.fAt.akT();
        }
        if (this.fAs != null) {
            this.fAs.onDestroy();
        }
        this.ftp.hideProgressBar();
        if (this.cRO != null && this.dfy != null) {
            this.cRO.b(this.dfy);
        }
        bfp();
        As();
        if (this.fCp != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fCp);
        }
        if (this.fAG != null && this.fAR != null) {
            this.fAG.removeView(this.fAM);
            this.fAR = null;
        }
        if (this.fBV != null) {
            this.fBV.clearStatus();
        }
        this.fCQ = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fBh.qu(3);
        if (this.djC != null) {
            this.djC.setBackgroundDrawable(null);
        }
        if (this.fAq != null) {
            this.fAq.destroy();
        }
        if (this.fBh != null) {
            this.fBh.onDestroy();
        }
        this.fAA.setOnLayoutListener(null);
        if (this.fCE != null) {
            this.fCE.avk();
        }
        if (this.fCg != null) {
            this.fCg.onDestroy();
        }
        bfK();
    }

    public boolean qK(int i) {
        if (this.fAq != null) {
            return this.fAq.ku(i);
        }
        return false;
    }

    public void bfp() {
        this.fAw.sL();
        if (this.fAt != null) {
            this.fAt.akT();
        }
        com.baidu.adp.lib.util.l.b(this.ftp.getPageContext().getPageActivity(), this.fBk);
        beD();
        if (this.fBA != null) {
            this.fBA.dismiss();
        }
        bfr();
        if (this.fAs != null) {
            this.fAs.bhp();
        }
        if (this.fBi != null) {
            this.fBi.dismiss();
        }
        if (this.djo != null) {
            this.djo.dismiss();
        }
    }

    public void bfq() {
        this.fAw.sL();
        if (this.fAt != null) {
            this.fAt.akT();
        }
        if (this.fBA != null) {
            this.fBA.dismiss();
        }
        bfr();
        if (this.fAs != null) {
            this.fAs.bhp();
        }
        if (this.fBi != null) {
            this.fBi.dismiss();
        }
        if (this.djo != null) {
            this.djo.dismiss();
        }
    }

    public void cW(List<String> list) {
        this.fCD = list;
        if (this.fCE != null) {
            this.fCE.setData(list);
        }
    }

    public void jx(boolean z) {
        this.fBh.jx(z);
    }

    public void ks(boolean z) {
        this.fBF = z;
    }

    public void bfr() {
        if (this.fBr != null) {
            this.fBr.dismiss();
        }
        if (this.fBs != null) {
            com.baidu.adp.lib.g.g.b(this.fBs, this.ftp.getPageContext());
        }
        if (this.fBt != null) {
            com.baidu.adp.lib.g.g.b(this.fBt, this.ftp.getPageContext());
        }
        if (this.fBp != null) {
            com.baidu.adp.lib.g.g.b(this.fBp, this.ftp.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fwM, this.ftG);
            d(this.fwM, this.ftG, this.mType);
            this.ftp.getLayoutMode().setNightMode(i == 1);
            this.ftp.getLayoutMode().onModeChanged(this.cRQ);
            this.ftp.getLayoutMode().onModeChanged(this.fAB);
            com.baidu.tbadk.core.util.al.i(this.fAE, d.C0141d.cp_bg_line_d);
            if (this.fAs != null) {
                this.fAs.onChangeSkinType(i);
            }
            if (this.fAD != null) {
                com.baidu.tbadk.core.util.al.h(this.fAD, d.C0141d.cp_cont_b);
                this.fAD.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_link_tip_c));
            }
            if (this.dlW != null) {
                this.dlW.dy(i);
                if (this.aSj != null) {
                    this.ftp.getLayoutMode().onModeChanged(this.aSj);
                    com.baidu.tbadk.core.util.al.i(this.aSj, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fBi != null) {
                this.fBi.c(this.ftp.getPageContext());
            }
            kq(this.fBC);
            this.fBh.notifyDataSetChanged();
            if (this.fBl != null) {
                this.fBl.dy(i);
            }
            if (this.Qh != null) {
                this.Qh.onChangeSkinType(i);
            }
            if (this.fAQ != null) {
                this.fAQ.dC(i);
            }
            if (this.fBm != null) {
                this.fBm.dy(i);
            }
            if (!com.baidu.tbadk.core.util.w.z(this.cAM)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cAM) {
                    customBlueCheckRadioButton.Ac();
                }
            }
            km(i == 1);
            beR();
            UtilHelper.setStatusBarBackground(this.djC, i);
            UtilHelper.setStatusBarBackground(this.fCa, i);
            if (this.fAS != null) {
                this.fAS.onChangeSkinType(i);
            }
            if (this.fAX != null) {
                com.baidu.tbadk.core.util.al.h(this.fAX, d.C0141d.cp_cont_d);
            }
            if (this.fAW != null) {
                com.baidu.tbadk.core.util.al.h(this.fAW, d.C0141d.cp_cont_d);
            }
            if (this.fAY != null) {
                com.baidu.tbadk.core.util.al.i(this.fAY, d.C0141d.cp_cont_e);
            }
            if (this.axM != null) {
                com.baidu.tbadk.core.util.al.h(this.axM, d.C0141d.cp_cont_d);
            }
            if (this.fAZ != null) {
                com.baidu.tbadk.core.util.al.i(this.fAZ, d.C0141d.cp_cont_e);
            }
            if (this.fAJ != null) {
                com.baidu.tbadk.core.util.al.h(this.fAJ, d.C0141d.cp_link_tip_a);
            }
            if (this.fAV != null) {
                com.baidu.tbadk.core.util.al.h(this.fAV, d.C0141d.cp_cont_d);
            }
            if (this.fBa != null) {
                com.baidu.tbadk.n.a.a(this.ftp.getPageContext(), this.fBa);
            }
            if (this.fBy != null) {
                com.baidu.tbadk.n.a.a(this.ftp.getPageContext(), this.fBy);
            }
            if (this.fCq != null) {
                this.fCq.onChangeSkinType(i);
            }
            if (this.fAw != null) {
                if (this.fAq != null) {
                    this.fAq.qQ(i);
                } else {
                    this.fAw.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fBI != null) {
                com.baidu.tbadk.core.util.al.h(this.fBI, d.C0141d.cp_cont_e);
            }
            if (this.fAK != null) {
                com.baidu.tbadk.core.util.al.c(this.fAK, BitmapHelper.getGradeResourceIdInEnterForum(this.fCy));
            }
            if (this.fCF != null) {
                this.fCF.onChangeSkinType(i);
            }
            if (this.fCg != null) {
                this.fCg.onChangeSkinType();
            }
            if (this.fCC != null) {
                com.baidu.tbadk.core.util.al.h(this.fCC, d.C0141d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.beD = hVar;
        this.fBh.setOnImageClickListener(this.beD);
        this.fCF.setOnImageClickListener(this.beD);
    }

    public void h(NoNetworkView.a aVar) {
        this.dfy = aVar;
        if (this.cRO != null) {
            this.cRO.a(this.dfy);
        }
    }

    public void kt(boolean z) {
        this.fBh.setIsFromCDN(z);
    }

    public Button bfs() {
        return this.fBG;
    }

    public void bft() {
        if (this.fAv != 2) {
            this.fAA.setNextPage(this.dlW);
            this.fAv = 2;
        }
    }

    public void bfu() {
        if (com.baidu.tbadk.k.m.Ks().Kt()) {
            int lastVisiblePosition = this.fAA.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fAA.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.h perfLog = tbImageView.getPerfLog();
                                perfLog.fk(1001);
                                perfLog.aSN = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.k.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.fk(1001);
                        perfLog2.aSN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bfv() {
        return this.Qh != null && this.Qh.getVisibility() == 0;
    }

    public boolean bfw() {
        return this.Qh != null && this.Qh.Hj();
    }

    public void bfx() {
        if (this.Qh != null) {
            this.Qh.FB();
        }
    }

    public void ku(boolean z) {
        if (this.fBH != null) {
            ks(this.ftp.bbF().HM());
            if (this.fBF) {
                kj(z);
            } else {
                kk(z);
            }
        }
    }

    public void bfy() {
        if (this.fBH != null) {
            this.fBH.setVisibility(8);
            this.fBM = false;
            if (this.fCg != null) {
                this.fCg.setVisibility(8);
                ko(false);
            }
            bfK();
        }
    }

    public void showLoadingDialog() {
        if (this.cIg == null) {
            this.cIg = new com.baidu.tbadk.core.view.a(this.ftp.getPageContext());
        }
        this.cIg.aM(true);
    }

    public void adT() {
        if (this.cIg != null) {
            this.cIg.aM(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fAA.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fAA.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fAq != null) {
            this.fAq.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eSF = getScrollY();
            this.fCf.fDm = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fCf));
            a(this.fCf.fDm, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fAq != null) {
            this.fAq.b(absListView, i);
        }
        int headerViewsCount = (i - this.fAA.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fBh.qt(headerViewsCount) == com.baidu.tieba.pb.data.j.fpi) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fAA.getHeaderViewsCount();
        if (this.fAE != null && this.fAw != null) {
            this.fAw.g(this.fAE.getBottom(), this.fAE.getMeasuredHeight(), z2);
        }
        this.fBh.bcP().j(z, this.fBY != null ? this.fBY.getMeasuredHeight() : 0);
        this.fCf.fkd = i;
        this.fCf.headerCount = this.fAA.getHeaderViewsCount();
        this.fCf.fDm = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fCf));
        a(this.fCf.fDm, false);
    }

    public void bfz() {
        if (this.ftp.isLogin() && this.fwM != null && this.fCv && !this.fCu && !this.fBD && this.fBQ != null && this.fBQ.vm() != null && !this.fBQ.vm().getIsLike() && !this.fBQ.vm().hadConcerned()) {
            if (this.fCr == null) {
                this.fCr = new am(this.ftp);
            }
            this.fCr.a(this.fAw.fFu, this.fwM.baM(), this.fBQ.vm().getUserId(), this.fwM.getThreadId());
        }
    }

    public void bfA() {
        if (this.fCv && !this.fCu && this.fBQ != null && this.fBQ.vm() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").r("obj_locate", this.ftp.bcu() ? 2 : 1).r("obj_type", this.fCu ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.ftp.getPageContext().getPageActivity(), this.fBQ.vm().getUserId(), this.fBQ.vm().getUserName(), this.ftp.bbt().bdg(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fCu && this.fBZ != null && this.fAw.bge() != null) {
            int bcM = this.fBh.bcM();
            if (bcM > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (bcM > this.fAA.getFirstVisiblePosition() - this.fAA.getHeaderViewsCount()) {
                    this.fBZ.setVisibility(8);
                    return;
                }
                this.fBZ.setVisibility(0);
                this.fAw.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fzE == null) {
                if (this.fAA.getFirstVisiblePosition() == 0) {
                    this.fBZ.setVisibility(8);
                    this.fAw.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fCe) {
                        this.fCd = top;
                        this.fCe = false;
                    }
                    this.fCd = top < this.fCd ? top : this.fCd;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.fBg.getY() < 0.0f) {
                        measuredHeight = fCc - akVar.fzE.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fAw.bge().getMeasuredHeight() - akVar.fzE.getMeasuredHeight();
                        this.fAw.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fCd) {
                        this.fBZ.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fBZ.setVisibility(0);
                    } else {
                        this.fBZ.setVisibility(8);
                        this.fAw.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fCe = true;
                    }
                }
            }
        }
    }

    public void bfB() {
        if (!this.fCY) {
            TiebaStatic.log("c10490");
            this.fCY = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ftp.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fCj, Integer.valueOf(fCl));
            aVar.cb(d.k.grade_thread_tips);
            View inflate = LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.k.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.k.grade_thread_tips);
            aVar.w(inflate);
            aVar.C(sparseArray);
            aVar.a(d.k.grade_button_tips, this.ftp);
            aVar.b(d.k.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.ftp.getPageContext()).xa();
        }
    }

    public void ru(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ftp.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.w(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fCj, Integer.valueOf(fCm));
        aVar.C(sparseArray);
        aVar.a(d.k.view, this.ftp);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.ftp.getPageContext()).xa();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.vm() != null) {
            MetaData vm = b.vm();
            vm.setGiftNum(vm.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bfC() {
        return this.fBV;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bao() != null && dVar.bao().wb() && this.fBV == null) {
            this.fBV = (PbInterviewStatusView) this.fBU.inflate();
            this.fBV.setOnClickListener(this.djp);
            this.fBV.setCallback(this.ftp.bcp());
            this.fBV.setData(this.ftp, dVar);
        }
    }

    public LinearLayout bfD() {
        return this.fBg;
    }

    public View bfE() {
        return this.djC;
    }

    public boolean bfF() {
        return this.fCK;
    }

    public void jC(boolean z) {
        this.fAF.jC(z);
    }

    public void rv(String str) {
        if (this.fAx != null) {
            this.fAx.setTitle(str);
        }
    }

    private int kv(boolean z) {
        if (this.fBV == null || this.fBV.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bfG() {
        if (this.fBV != null && this.fBV.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBV.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fBV.setLayoutParams(layoutParams);
        }
    }

    public boolean bbL() {
        return false;
    }

    public void rw(String str) {
        this.fBI.performClick();
        if (!StringUtils.isNull(str) && this.ftp.bbF() != null && this.ftp.bbF().HF() != null && this.ftp.bbF().HF().getInputView() != null) {
            EditText inputView = this.ftp.bbF().HF().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bfp();
            if (configuration.orientation == 2) {
                bfy();
                beD();
            } else {
                beG();
            }
            if (this.fCq != null) {
                this.fCq.bcT();
            }
            this.ftp.atH();
            this.fBg.setVisibility(8);
            this.fAw.kH(false);
            this.ftp.jI(false);
            if (this.fAq != null) {
                if (configuration.orientation == 1) {
                    bfD().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fAA.setIsLandscape(true);
                    this.fAA.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fAA.setIsLandscape(false);
                    if (this.eSF > 0) {
                        this.fAA.smoothScrollBy(this.eSF, 0);
                    }
                }
                this.fAq.onConfigurationChanged(configuration);
            }
        }
    }

    public void kw(boolean z) {
        this.fAu = z;
    }

    public boolean bfH() {
        return this.fAq != null && this.fAq.bfH();
    }

    public void bfI() {
        if (this.fAq != null) {
            this.fAq.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fAs != null) {
            this.fAs.y(j, i);
        }
        if (this.fAq != null) {
            this.fAq.y(j, i);
        }
    }

    public void jN(boolean z) {
        this.fBh.jN(z);
    }

    public void bfJ() {
        if (this.fBW == null) {
            LayoutInflater.from(this.ftp.getActivity()).inflate(d.i.add_experienced_text, (ViewGroup) this.cRQ, true);
            this.fBW = (ViewGroup) this.cRQ.findViewById(d.g.add_experienced_layout);
            this.fBX = (TextView) this.cRQ.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.fBX, d.C0141d.cp_cont_i);
            String string = this.ftp.getResources().getString(d.k.experienced_add_success);
            String string2 = this.ftp.getResources().getString(d.k.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_cont_h)));
            this.fBX.setText(spannableString);
        }
        this.fBW.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.as.28
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.as.28.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        as.this.fBW.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                as.this.fBX.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fBX.startAnimation(scaleAnimation);
    }

    public void bi(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fBH.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.ftp);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fCC = new TextView(this.ftp);
            this.fCC.setText(d.k.connection_tips);
            this.fCC.setGravity(17);
            this.fCC.setPadding(com.baidu.adp.lib.util.l.e(this.ftp, d.e.ds24), 0, com.baidu.adp.lib.util.l.e(this.ftp, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.ftp, d.e.ds60);
            if (this.fCC.getParent() == null) {
                frameLayout.addView(this.fCC, layoutParams);
            }
            this.fCB = new PopupWindow(this.ftp);
            this.fCB.setContentView(frameLayout);
            this.fCB.setHeight(-2);
            this.fCB.setWidth(-2);
            this.fCB.setFocusable(true);
            this.fCB.setOutsideTouchable(false);
            this.fCB.setBackgroundDrawable(new ColorDrawable(this.ftp.getResources().getColor(d.C0141d.transparent)));
            this.fAA.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        as.this.fCB.showAsDropDown(as.this.fBH, view.getLeft(), -as.this.fBH.getHeight());
                    } else {
                        as.this.fCB.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bfV() != null && !StringUtils.isNull(aVar.bfV().pkg_id) && !StringUtils.isNull(aVar.bfV().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fBJ != null && this.fBJ.getVisibility() == 0) {
            if (this.fCA == null) {
                View inflate = LayoutInflater.from(this.ftp.getPageContext().getPageActivity()).inflate(d.i.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.k.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.djp);
                this.fCA = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fBJ.getLocationInWindow(iArr);
            this.fCA.showAtLocation(this.fBJ, 0, iArr[0] - com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fBJ.getHeight()) - com.baidu.adp.lib.util.l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bfK() {
        com.baidu.adp.lib.g.g.a(this.fCA);
    }

    public void kx(boolean z) {
        this.fCH = z;
    }

    public boolean bfL() {
        return this.fCH;
    }

    public void bj(View view) {
        this.fBy = view;
    }
}
