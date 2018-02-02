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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.e;
import com.baidu.tieba.pb.pb.main.emotion.b.a;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.xiaomi.mipush.sdk.Constants;
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
    private static final int fSi = UtilHelper.getLightStatusBarHeight();
    public static int fSo = 3;
    public static int fSp = 0;
    public static int fSq = 3;
    public static int fSr = 4;
    public static int fSs = 5;
    public static int fSt = 6;
    private com.baidu.tbadk.editortools.i axQ;
    private com.baidu.tieba.pb.a.c bJO;
    private j.b baZ;
    private TextView bcH;
    private TextView bmx;
    private View bxo;
    private List<com.baidu.tieba.pb.pb.main.view.a> cWB;
    private View.OnClickListener dDg;
    private View dDt;
    private PbListView dGi;
    private NavigationBarCoverTip dSJ;
    private View daO;
    private NoNetworkView dmD;
    private RelativeLayout dmF;
    private View.OnClickListener fFv;
    PbActivity.d fIW;
    private PbActivity fJR;
    private UserIconBox fKY;
    private UserIconBox fKZ;
    private PbFakeFloorModel fLV;
    private com.baidu.tieba.pb.data.f fNb;
    public final com.baidu.tieba.pb.pb.main.view.c fQC;
    public com.baidu.tieba.pb.pb.main.view.b fQD;
    private ViewStub fQE;
    private ViewStub fQF;
    private PbLandscapeListView fQG;
    private View fQH;
    private LinearLayout fQK;
    private f fQL;
    private ColumnLayout fQM;
    private ThreadSkinView fQN;
    private TextView fQO;
    private TextView fQP;
    private ImageView fQQ;
    private HeadPendantView fQR;
    private FrameLayout fQS;
    private HeadImageView fQT;
    private View fQU;
    private FloatingLayout fQV;
    private PbFirstFloorUserLikeButton fQY;
    private aq fQZ;
    public int fQv;
    private com.baidu.tieba.pb.video.i fQw;
    private long fQx;
    private com.baidu.tieba.pb.video.h fQy;
    private com.baidu.tieba.d.b fQz;
    private View fRN;
    private TextView fRO;
    private ImageView fRP;
    private ImageView fRQ;
    private TextView fRR;
    private boolean fRT;
    private int fRU;
    private int fRV;
    private PostData fRW;
    private View fRY;
    private TextView fRZ;
    private aq fRa;
    private TextView fRb;
    private TextView fRc;
    private TextView fRd;
    private View fRe;
    private View fRf;
    private LinearLayout fRg;
    private TextView fRh;
    private TextView fRi;
    private View fRj;
    private View fRk;
    private ObservedChangeLinearLayout fRm;
    private h fRn;
    private View fRt;
    private int fSD;
    private PbTopTipView fSF;
    private PopupWindow fSG;
    private PopupWindow fSH;
    private TextView fSI;
    private List<String> fSJ;
    private com.baidu.tieba.pb.pb.main.emotion.c fSK;
    private com.baidu.tieba.pb.pb.godreply.a fSL;
    private PbLandscapeListView.b fSM;
    private ac fSO;
    private boolean fSQ;
    private e fSR;
    private com.baidu.tbadk.core.view.userLike.c fSS;
    private com.baidu.tbadk.core.view.userLike.c fST;
    private Runnable fSY;
    private ViewStub fSa;
    private PbInterviewStatusView fSb;
    private ViewGroup fSc;
    private TextView fSd;
    private FrameLayout fSe;
    private View fSf;
    private View fSg;
    private al fSh;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fSm;
    private int fSu;
    private Runnable fSv;
    private s fSw;
    private an fSx;
    private PbActivity.b fTa;
    private int fhX;
    private boolean isLandscape;
    private int mType;
    private boolean fQA = false;
    private int fQB = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fQI = null;
    private TextView fQJ = null;
    public FrsPraiseView fQW = null;
    private ClickableHeaderImageView fQX = null;
    private View fRl = null;
    private com.baidu.tbadk.core.dialog.a fRo = null;
    private com.baidu.tbadk.core.dialog.b dDf = null;
    private View fRp = null;
    private EditText fRq = null;
    private com.baidu.tieba.pb.view.i fRr = null;
    private com.baidu.tieba.pb.view.b fRs = null;
    private com.baidu.tbadk.core.dialog.a fRu = null;
    private b.InterfaceC0073b eCD = null;
    private TbRichTextView.h bJN = null;
    private NoNetworkView.a dzL = null;
    private Dialog fRv = null;
    private View fRw = null;
    private com.baidu.tbadk.core.dialog.a fRx = null;
    private Dialog fRy = null;
    private Dialog fRz = null;
    private View fRA = null;
    private LinearLayout fRB = null;
    private CompoundButton.OnCheckedChangeListener cWC = null;
    private TextView fRC = null;
    private TextView fRD = null;
    private View fRE = null;
    private String fRF = null;
    private com.baidu.tbadk.core.dialog.b fRG = null;
    private com.baidu.tbadk.core.dialog.b fRH = null;
    private boolean fRI = false;
    private boolean fRJ = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fRK = null;
    private boolean fRL = false;
    private Button fRM = null;
    private boolean fRS = true;
    private com.baidu.tbadk.core.view.b ddR = null;
    private boolean fFr = false;
    private int mSkinType = 3;
    private boolean fRX = false;
    private int fSj = 0;
    private boolean fSk = true;
    private a fSl = new a();
    private int fSn = 0;
    private boolean fSy = false;
    private int fSz = 0;
    private boolean fSA = false;
    private boolean fSB = false;
    private boolean fSC = false;
    private int fSE = 0;
    private boolean fSN = false;
    private a.InterfaceC0153a fSP = new a.InterfaceC0153a() { // from class: com.baidu.tieba.pb.pb.main.as.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0153a
        public void onRefresh() {
        }
    };
    private String fSU = null;
    private CustomMessageListener fSV = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.as.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                as.this.fSU = null;
            }
        }
    };
    private CustomMessageListener dOv = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && as.this.fRn != null) {
                as.this.fRn.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fSW = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (as.this.fQJ != null) {
                as.this.fQJ.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fSX = new Handler();
    private CustomMessageListener fSZ = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.as.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                as.this.fRS = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fTb = true;
    View.OnClickListener fTc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (as.this.fSA) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").s("obj_id", 2));
            }
            if (view == as.this.fQC.fVF) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").s("obj_locate", 2));
            }
            if (as.this.fJR.fHV.fUN != null) {
                if (!as.this.fSA && as.this.fNb != null && as.this.fNb.aYL() != null && as.this.fNb.aYL().yT() != null && as.this.fNb.aYL().yT().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").s("obj_locate", 1));
                }
                as.this.fJR.fHV.fUN.onClick(view);
            }
        }
    };
    private boolean fTd = false;
    String userId = null;
    private final List<TbImageView> fTe = new ArrayList();
    private boolean fTf = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fTt;
        public al fTu;
        public int fzq;
    }

    public void kr(boolean z) {
        this.fSy = z;
        if (this.fQG != null) {
            this.fSz = this.fQG.getHeaderViewsCount();
        }
    }

    public void bde() {
        if (this.fQG != null) {
            int headerViewsCount = this.fQG.getHeaderViewsCount() - this.fSz;
            final int firstVisiblePosition = (this.fQG.getFirstVisiblePosition() == 0 || this.fQG.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fQG.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fQG.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fSl.fTu = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fSl));
            final al alVar = this.fSl.fTu;
            final int f = f(alVar);
            final int y = ((int) this.fRm.getY()) + this.fRm.getMeasuredHeight();
            final boolean z = this.fSf.getVisibility() == 0;
            boolean z2 = this.fRm.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fRn.bbo() + this.fQG.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fPS.getMeasuredHeight() : 0;
                if (z2) {
                    this.fQG.setSelectionFromTop(this.fRn.bbo() + this.fQG.getHeaderViewsCount(), fSi - measuredHeight);
                } else {
                    this.fQG.setSelectionFromTop(this.fRn.bbo() + this.fQG.getHeaderViewsCount(), this.fQC.beH().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fQG.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fSA) {
                this.fQG.setSelectionFromTop(this.fRn.bbo() + this.fQG.getHeaderViewsCount(), this.fQw.bfW().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fQG.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.as.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bbG() {
                        if (f >= 0 && f <= as.this.dmF.getMeasuredHeight()) {
                            int f2 = as.this.f(alVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = as.this.daO.getLayoutParams();
                            if (i == 0 || i > as.this.dmF.getMeasuredHeight() || f2 >= as.this.dmF.getMeasuredHeight()) {
                                layoutParams.height = as.this.fSu;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > as.this.dmF.getMeasuredHeight()) {
                                layoutParams.height = as.this.fSu;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                as.this.fQG.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            as.this.daO.setLayoutParams(layoutParams);
                        }
                        as.this.fQG.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(al alVar) {
        if (alVar == null || alVar.getView() == null) {
            return 0;
        }
        if (alVar.getView().getTop() != 0 || alVar.getView().isShown()) {
            return alVar.getView().getBottom();
        }
        return 0;
    }

    public e bdf() {
        return this.fSR;
    }

    public NoNetworkView bdg() {
        return this.dmD;
    }

    public void bdh() {
        if (this.axQ != null) {
            this.axQ.hide();
            if (this.fSK != null) {
                this.fSK.Vs();
            }
        }
    }

    public PbFakeFloorModel bdi() {
        return this.fLV;
    }

    public s bdj() {
        return this.fSw;
    }

    public void bdk() {
        reset();
        bdh();
        this.fSw.bbv();
        kD(false);
    }

    private void reset() {
        if (this.fJR != null && this.fJR.bah() != null && this.axQ != null) {
            com.baidu.tbadk.editortools.pb.a.KR().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bah = this.fJR.bah();
            bah.Lk();
            bah.KG();
            if (bah.getWriteImagesInfo() != null) {
                bah.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bah.hP(SendView.ALL);
            bah.hQ(SendView.ALL);
            com.baidu.tbadk.editortools.l hH = this.axQ.hH(23);
            com.baidu.tbadk.editortools.l hH2 = this.axQ.hH(2);
            com.baidu.tbadk.editortools.l hH3 = this.axQ.hH(5);
            if (hH2 != null) {
                hH2.ti();
            }
            if (hH3 != null) {
                hH3.ti();
            }
            if (hH != null) {
                hH.hide();
            }
            this.axQ.invalidate();
        }
    }

    public boolean bdl() {
        return this.fRS;
    }

    public void ks(boolean z) {
        if (this.fRN != null && this.fRO != null) {
            this.fRO.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fRN.startAnimation(alphaAnimation);
            }
            this.fRN.setVisibility(0);
            this.fRS = true;
            if (this.fSm != null && !this.fSL.isActive()) {
                this.fSm.setVisibility(0);
                kx(true);
            }
        }
    }

    public void kt(boolean z) {
        if (this.fRN != null && this.fRO != null) {
            this.fRO.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fRN.startAnimation(alphaAnimation);
            }
            this.fRN.setVisibility(0);
            this.fRS = true;
            if (this.fSm != null && !this.fSL.isActive()) {
                this.fSm.setVisibility(0);
                kx(true);
            }
        }
    }

    public PostData bdm() {
        int i = 0;
        if (this.fQG == null) {
            return null;
        }
        int bdn = bdn() - this.fQG.getHeaderViewsCount();
        if (bdn < 0) {
            bdn = 0;
        }
        if (this.fRn.sI(bdn) != null && this.fRn.sI(bdn) != PostData.gYz) {
            i = bdn + 1;
        }
        return this.fRn.getItem(i) instanceof PostData ? (PostData) this.fRn.getItem(i) : null;
    }

    public int bdn() {
        int i;
        View childAt;
        if (this.fQG == null) {
            return 0;
        }
        int firstVisiblePosition = this.fQG.getFirstVisiblePosition();
        int lastVisiblePosition = this.fQG.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fQG.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fQG.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bdo() {
        return this.fQG.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fNb != null && this.fNb.aYN() != null && !this.fNb.aYN().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fNb.aYN().size() && (postData = this.fNb.aYN().get(i)) != null && postData.yT() != null && !StringUtils.isNull(postData.yT().getUserId()); i++) {
                if (this.fNb.aYN().get(i).yT().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fSL != null && this.fSL.isActive()) {
                        kD(false);
                    }
                    if (this.fSm != null) {
                        this.fSm.kK(true);
                    }
                    this.fSU = postData.yT().getName_show();
                    return;
                }
            }
        }
    }

    public as(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fJR = null;
        this.dmF = null;
        this.dDt = null;
        this.fQx = 0L;
        this.fQG = null;
        this.fQH = null;
        this.fQK = null;
        this.fQM = null;
        this.fQO = null;
        this.fQP = null;
        this.fQS = null;
        this.fQT = null;
        this.fQU = null;
        this.fQY = null;
        this.fRb = null;
        this.fRc = null;
        this.fRd = null;
        this.fRe = null;
        this.fRj = null;
        this.fRk = null;
        this.fRn = null;
        this.dGi = null;
        this.bxo = null;
        this.dDg = null;
        this.fFv = null;
        this.fRN = null;
        this.fRO = null;
        this.fRP = null;
        this.fRQ = null;
        this.fRR = null;
        this.fRY = null;
        this.fRZ = null;
        this.fSa = null;
        this.fSD = 0;
        this.fQx = System.currentTimeMillis();
        this.fJR = pbActivity;
        this.dDg = onClickListener;
        this.bJO = cVar;
        this.fSD = com.baidu.adp.lib.util.l.ao(this.fJR) / 2;
        this.dmF = (RelativeLayout) LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.fJR.addContentView(this.dmF, new FrameLayout.LayoutParams(-1, -1));
        this.dSJ = (NavigationBarCoverTip) this.fJR.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dDt = this.fJR.findViewById(d.g.statebar_view);
        this.fRm = (ObservedChangeLinearLayout) this.fJR.findViewById(d.g.title_wrapper);
        this.dmD = (NoNetworkView) this.fJR.findViewById(d.g.view_no_network);
        this.fQG = (PbLandscapeListView) this.fJR.findViewById(d.g.new_pb_list);
        this.fSe = (FrameLayout) this.fJR.findViewById(d.g.root_float_header);
        this.bmx = new TextView(this.fJR.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds88));
        this.fQG.addHeaderView(this.bmx, 0);
        this.fSu = this.fJR.getResources().getDimensionPixelSize(d.e.tbds134);
        this.daO = new View(this.fJR.getPageContext().getPageActivity());
        this.daO.setLayoutParams(new AbsListView.LayoutParams(-1, this.fSu));
        this.daO.setVisibility(4);
        this.fQG.addFooterView(this.daO);
        this.fQG.setOnTouchListener(this.fJR.bBt);
        this.fQC = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.fJR.baK()) {
            this.fQE = (ViewStub) this.fJR.findViewById(d.g.manga_view_stub);
            this.fQE.setVisibility(0);
            this.fQD = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.fQD.show();
            this.fQC.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds120);
        }
        this.bmx.setLayoutParams(layoutParams);
        this.fQC.beH().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0137a() { // from class: com.baidu.tieba.pb.pb.main.as.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0137a
            public void avg() {
                if (as.this.fQG != null) {
                    if (as.this.fQw != null) {
                        as.this.fQw.bfX();
                    }
                    as.this.fQG.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0137a
            public void avf() {
                as.this.fJR.aut();
            }
        }));
        this.fRN = this.fJR.findViewById(d.g.pb_editor_tool_comment);
        this.fRU = com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds90);
        this.fRV = com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds242);
        this.fRO = (TextView) this.fJR.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fRQ = (ImageView) this.fJR.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fRP = (ImageView) this.fJR.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fRR = (TextView) this.fJR.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fRR.setVisibility(8);
        this.fRO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.beq();
                if (!as.this.fJR.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).aa(ImageViewerConfig.FORUM_ID, as.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d bah = as.this.fJR.bah();
                if (bah == null || (!bah.Lh() && !bah.Li())) {
                    if (as.this.axQ != null) {
                        as.this.bdy();
                    }
                    if (as.this.axQ != null) {
                        as.this.fRS = false;
                        if (as.this.axQ.hJ(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fJR, (View) as.this.axQ.hJ(2).bqj, false, as.this.fSP);
                        }
                    }
                    as.this.bec();
                    return;
                }
                as.this.fJR.bah().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.beq();
                if (as.this.fJR.checkUpIsLogin()) {
                    if (as.this.axQ != null) {
                        as.this.bdy();
                        as.this.axQ.bh((View) as.this.axQ.hH(5));
                    }
                    if (as.this.axQ != null) {
                        as.this.fRS = false;
                        if (as.this.axQ.hJ(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fJR, (View) as.this.axQ.hJ(2).bqj, false, as.this.fSP);
                        }
                    }
                    as.this.bec();
                }
            }
        });
        this.fRQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.beq();
                if (as.this.fJR.checkUpIsLogin()) {
                    if (as.this.axQ != null) {
                        as.this.bdy();
                        as.this.axQ.bh((View) as.this.axQ.hH(2));
                    }
                    if (as.this.axQ != null) {
                        as.this.fRS = false;
                        if (as.this.axQ.hJ(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fJR, (View) as.this.axQ.hJ(2).bqj, false, as.this.fSP);
                        }
                    }
                    as.this.bec();
                }
            }
        });
        this.fRR.setOnClickListener(this.dDg);
        this.fRR.setOnTouchListener(this.fJR);
        this.fQH = LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fQK = (LinearLayout) LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.aj.s(this.fQK, d.C0108d.cp_bg_line_d);
        this.fQL = new f(this.fJR, this.fQK);
        this.fQL.init();
        this.fQL.a(this.fQL.bag(), this.dDg);
        this.fQM = (ColumnLayout) this.fQK.findViewById(d.g.pb_head_owner_root);
        this.fQN = (ThreadSkinView) this.fQK.findViewById(d.g.pb_thread_skin);
        this.fQM.setOnLongClickListener(this.onLongClickListener);
        this.fQM.setOnTouchListener(this.bJO);
        this.fQM.setVisibility(8);
        this.fQH.setOnTouchListener(this.bJO);
        this.fRY = this.fQH.findViewById(d.g.pb_head_activity_join_number_container);
        this.fRY.setVisibility(8);
        this.fRZ = (TextView) this.fQH.findViewById(d.g.pb_head_activity_join_number);
        this.fQO = (TextView) this.fQM.findViewById(d.g.pb_head_owner_info_user_name);
        this.fQP = (TextView) this.fQM.findViewById(d.g.floor_owner);
        this.fQQ = (ImageView) this.fQM.findViewById(d.g.icon_forum_level);
        this.fQS = (FrameLayout) this.fQM.findViewById(d.g.pb_head_headImage_container);
        this.fQT = (HeadImageView) this.fQM.findViewById(d.g.pb_head_owner_photo);
        this.fQR = (HeadPendantView) this.fQM.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fQR.Dz();
        if (this.fQR.getHeadView() != null) {
            this.fQR.getHeadView().setIsRound(true);
            this.fQR.getHeadView().setDrawBorder(false);
        }
        this.fKY = (UserIconBox) this.fQM.findViewById(d.g.show_icon_vip);
        this.fKZ = (UserIconBox) this.fQM.findViewById(d.g.show_icon_yinji);
        this.fQV = (FloatingLayout) this.fQK.findViewById(d.g.pb_head_owner_info_root);
        this.fQY = (PbFirstFloorUserLikeButton) this.fQM.findViewById(d.g.pb_like_button);
        this.fRb = (TextView) this.fQM.findViewById(d.g.pb_views);
        this.bcH = (TextView) this.fQM.findViewById(d.g.view_forum_name);
        this.fRf = this.fQM.findViewById(d.g.line_right_forum_name);
        this.fRc = (TextView) this.fQM.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fRd = (TextView) this.fQM.findViewById(d.g.pb_item_first_floor_location_address);
        this.fRe = this.fQM.findViewById(d.g.line_between_time_and_locate);
        this.fSS = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fST = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fRj = this.fQH.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fRk = this.fQH.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fQH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fSa = (ViewStub) this.dmF.findViewById(d.g.interview_status_stub);
        this.fRn = new h(this.fJR, this.fQG);
        this.fRn.r(this.dDg);
        this.fRn.setTbGestureDetector(this.bJO);
        this.fRn.setOnImageClickListener(this.bJN);
        this.fFv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.akc() || !com.baidu.tieba.c.a.b(as.this.fJR.getBaseContext(), as.this.fJR.aZT().bbK(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                as.this.fJR.c(sparseArray);
                                return;
                            }
                            as.this.cz(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        as.this.fJR.c(sparseArray);
                    } else if (booleanValue3) {
                        as.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fRn.E(this.fFv);
        bdt();
        this.fQG.addHeaderView(this.fQI);
        this.fQG.addHeaderView(this.fQK);
        this.fQG.addHeaderView(this.fQH);
        this.dGi = new PbListView(this.fJR.getPageContext().getPageActivity());
        this.bxo = this.dGi.getView().findViewById(d.g.pb_more_view);
        if (this.bxo != null) {
            this.bxo.setOnClickListener(this.dDg);
            com.baidu.tbadk.core.util.aj.s(this.bxo, d.f.pb_foot_more_trans_selector);
        }
        this.dGi.DI();
        this.dGi.gs(d.f.pb_foot_more_trans_selector);
        this.dGi.gu(d.f.pb_foot_more_trans_selector);
        this.fRt = this.fJR.findViewById(d.g.viewstub_progress);
        this.fJR.registerListener(this.fSZ);
        this.fQU = com.baidu.tbadk.ala.b.uZ().t(this.fJR.getActivity(), 2);
        if (this.fQU != null) {
            this.fQU.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fJR.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fQU.getParent() == null) {
                this.fQV.addView(this.fQU, aVar);
            }
        }
        this.fLV = new PbFakeFloorModel(this.fJR.getPageContext());
        this.fSw = new s(this.fJR.getPageContext(), this.fLV, this.dmF);
        this.fSw.a(this.fJR.fIS);
        this.fLV.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.as.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                as.this.fLV.m(postData);
                as.this.fRn.notifyDataSetChanged();
                as.this.fSw.bbv();
                as.this.axQ.IG();
                as.this.kD(false);
            }
        });
        if (this.fJR.aZT() != null && !StringUtils.isNull(this.fJR.aZT().bcp())) {
            this.fJR.showToast(this.fJR.aZT().bcp());
        }
        this.fSf = this.fJR.findViewById(d.g.pb_expand_blank_view);
        this.fSg = this.fJR.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fSg.getLayoutParams();
        if (this.fJR.aZT() != null && this.fJR.aZT().bbN()) {
            this.fSf.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fSg.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fSi;
            this.fSg.setLayoutParams(layoutParams2);
        }
        this.fSh = new al(this.fJR.getPageContext(), this.fJR.findViewById(d.g.pb_reply_expand_view));
        this.fSh.fPS.setVisibility(8);
        this.fSh.G(this.dDg);
        this.fJR.registerListener(this.dOv);
        this.fJR.registerListener(this.fSV);
        this.fJR.registerListener(this.fSW);
        bdp();
        kx(false);
    }

    private void bdp() {
        this.fSL = new com.baidu.tieba.pb.pb.godreply.a(this.fJR, this, (ViewStub) this.dmF.findViewById(d.g.more_god_reply_popup));
        this.fSL.l(this.dDg);
        this.fSL.E(this.fFv);
        this.fSL.setOnImageClickListener(this.bJN);
        this.fSL.l(this.dDg);
        this.fSL.setTbGestureDetector(this.bJO);
    }

    public com.baidu.tieba.pb.pb.godreply.a bdq() {
        return this.fSL;
    }

    public View bdr() {
        return this.fSf;
    }

    public void bds() {
        if (this.fQG != null) {
            this.fQG.removeHeaderView(this.fQI);
            this.fQG.removeHeaderView(this.fQK);
            this.fQG.removeHeaderView(this.fQH);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fSm == null) {
            this.fSm = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.fJR.getPageContext().getPageActivity());
            kx(true);
            this.fSm.a(this.dmF, aVar, this.fRN.getVisibility() == 0);
            this.fSm.setOnEmotionClickListener(new a.InterfaceC0142a() { // from class: com.baidu.tieba.pb.pb.main.as.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0142a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(as.this.fSU)) {
                        emotionImageData.setAuthorNameShow(as.this.fSU);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0142a
                public void a(String str, List<String> list, List<String> list2) {
                    as.this.fJR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(as.this.fJR.getPageContext().getPageActivity(), 25016, str, list, as.this.fSU, list2)));
                }
            });
            this.fSm.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    as.this.beq();
                    if (as.this.fRN != null) {
                        ViewGroup.LayoutParams layoutParams = as.this.fRN.getLayoutParams();
                        layoutParams.height = (int) (((as.this.fRV - as.this.fRU) * f) + as.this.fRU);
                        as.this.fRO.setAlpha(1.0f - f);
                        as.this.fRQ.setAlpha(1.0f - f);
                        as.this.fRP.setAlpha(1.0f - f);
                        as.this.fRN.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bdt() {
        if (this.fQI == null) {
            int s = com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.tbds44);
            this.fQI = new LinearLayout(this.fJR.getPageContext().getPageActivity());
            this.fQI.setOrientation(1);
            this.fQI.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fQI.setPadding(s, com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.tbds30), s, com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.tbds40));
            this.fQI.setGravity(17);
            this.fQJ = new TextView(this.fJR.getPageContext().getPageActivity());
            this.fQJ.setGravity(3);
            this.fQJ.setMaxLines(2);
            this.fQJ.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_link_tip_c));
            this.fQJ.setPadding(0, 0, 0, 0);
            this.fQJ.setLineSpacing(com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.r(this.fQJ, d.C0108d.cp_cont_b);
            this.fQJ.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fQJ.setVisibility(8);
            if (this.fQJ.getParent() == null) {
                this.fQI.addView(this.fQJ);
            }
            this.fQI.setOnTouchListener(this.bJO);
            this.fQI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdu() {
        if (this.fJR.baK()) {
            this.fQF = (ViewStub) this.fJR.findViewById(d.g.manga_mention_controller_view_stub);
            this.fQF.setVisibility(0);
            if (this.fRg == null) {
                this.fRg = (LinearLayout) this.fJR.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fJR.getPageContext(), this.fRg);
            }
            if (this.fRh == null) {
                this.fRh = (TextView) this.fRg.findViewById(d.g.manga_prev_btn);
            }
            if (this.fRi == null) {
                this.fRi = (TextView) this.fRg.findViewById(d.g.manga_next_btn);
            }
            this.fRh.setOnClickListener(this.dDg);
            this.fRi.setOnClickListener(this.dDg);
        }
    }

    private void bdv() {
        if (this.fJR.baK()) {
            if (this.fJR.baN() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fRh, d.C0108d.cp_cont_e, 1);
            }
            if (this.fJR.baO() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fRi, d.C0108d.cp_cont_e, 1);
            }
        }
    }

    public void bdw() {
        if (this.fRg == null) {
            bdu();
        }
        this.fQF.setVisibility(8);
        if (this.fSX != null && this.fSY != null) {
            this.fSX.removeCallbacks(this.fSY);
        }
    }

    public void bdx() {
        if (this.fSX != null) {
            if (this.fSY != null) {
                this.fSX.removeCallbacks(this.fSY);
            }
            this.fSY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.this.fRg == null) {
                        as.this.bdu();
                    }
                    as.this.fQF.setVisibility(0);
                }
            };
            this.fSX.postDelayed(this.fSY, 2000L);
        }
    }

    public void ku(boolean z) {
        this.fQC.ku(z);
        if (z && this.fRX) {
            this.dGi.setText(this.fJR.getResources().getString(d.j.click_load_more));
            this.fQG.setNextPage(this.dGi);
            this.fQB = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axQ = iVar;
        this.axQ.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.axQ.getParent() == null) {
            this.dmF.addView(this.axQ, layoutParams);
        }
        this.axQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bdh();
        this.fJR.bah().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.as.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (as.this.axQ != null && as.this.axQ.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (as.this.fSK == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, as.this.axQ.getId());
                            as.this.fSK = new com.baidu.tieba.pb.pb.main.emotion.c(as.this.fJR.getPageContext(), as.this.dmF, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.E(as.this.fSJ)) {
                                as.this.fSK.setData(as.this.fSJ);
                            }
                            as.this.fSK.b(as.this.axQ);
                        }
                        as.this.fSK.qv(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (as.this.fJR.fHZ != null && as.this.fJR.fHZ.bet() != null) {
                    if (!as.this.fJR.fHZ.bet().bER()) {
                        as.this.fJR.fHZ.kH(false);
                    }
                    as.this.fJR.fHZ.bet().nu(false);
                }
            }
        });
    }

    public void bdy() {
        if (this.fJR != null && this.axQ != null) {
            this.axQ.ti();
            bec();
        }
    }

    public void S(String str, boolean z) {
        this.fRT = z;
        kv(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kv(boolean z) {
        if (this.fRR != null) {
            if (this.fRT) {
                com.baidu.tbadk.core.util.aj.s(this.fRR, d.f.pb_praise_already_click_selector);
                this.fRR.setContentDescription(this.fJR.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.s(this.fRR, d.f.pb_praise_normal_click_selector);
            this.fRR.setContentDescription(this.fJR.getResources().getString(d.j.zan));
        }
    }

    public TextView bdz() {
        return this.fRR;
    }

    public void kw(boolean z) {
        if (this.fQG != null && this.bmx != null && this.dDt != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dDt.setVisibility(0);
                } else {
                    this.dDt.setVisibility(8);
                    this.fQG.removeHeaderView(this.bmx);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.bmx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fSi;
                    this.bmx.setLayoutParams(layoutParams);
                }
                bdO();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.bmx.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kF(true);
                this.bmx.setLayoutParams(layoutParams2);
            }
            bdO();
            bem();
        }
    }

    public h bdA() {
        return this.fRn;
    }

    public void a(PbActivity.d dVar) {
        this.fIW = dVar;
    }

    public void cz(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fRw == null) {
            this.fRw = LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fJR.getLayoutMode().aM(this.fRw);
        if (this.fRv == null) {
            this.fRv = new Dialog(this.fJR.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fRv.setCanceledOnTouchOutside(true);
            this.fRv.setCancelable(true);
            this.fRv.setContentView(this.fRw);
            WindowManager.LayoutParams attributes = this.fRv.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ao(this.fJR.getPageContext().getPageActivity()) * 0.9d);
            this.fRv.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fRv.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fRv.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fRv.findViewById(d.g.disable_reply_btn);
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
                textView.setText(d.j.delete);
            } else {
                textView.setText(d.j.delete_post);
            }
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fRv != null && (as.this.fRv instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fRv, as.this.fJR.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        as.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || bej()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray5.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray5.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fRv != null && (as.this.fRv instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fRv, as.this.fJR.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && as.this.fTa != null) {
                        as.this.fTa.ak(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
                textView3.setText(d.j.un_mute);
            } else {
                textView3.setText(d.j.mute);
            }
            sparseArray6.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
            sparseArray6.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
            sparseArray6.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
            sparseArray6.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray6.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray6.put(d.g.tag_user_mute_msg, sparseArray.get(d.g.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fRv != null && (as.this.fRv instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fRv, as.this.fJR.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        as.this.fJR.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fRv, this.fJR.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fTa = bVar;
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
        sparseArray.put(fSp, Integer.valueOf(fSq));
        int i3 = d.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.j.report_thread_confirm;
            } else {
                i3 = d.j.del_thread_confirm;
            }
        }
        this.fRx = new com.baidu.tbadk.core.dialog.a(this.fJR.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fRx.fb(i3);
        } else {
            this.fRx.bb(false);
            this.fRx.cZ(str2);
        }
        this.fRx.aE(sparseArray);
        this.fRx.a(d.j.dialog_ok, this.fJR);
        this.fRx.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fRx.aW(true);
        this.fRx.b(this.fJR.getPageContext());
        this.fRx.AB();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fRA == null) {
            this.fRA = LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.fJR.getLayoutMode().aM(this.fRA);
        if (this.fRz == null) {
            this.fRz = new Dialog(this.fJR.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fRz.setCanceledOnTouchOutside(true);
            this.fRz.setCancelable(true);
            this.fRK = (ScrollView) this.fRA.findViewById(d.g.good_scroll);
            this.fRz.setContentView(this.fRA);
            WindowManager.LayoutParams attributes = this.fRz.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds540);
            this.fRz.getWindow().setAttributes(attributes);
            this.cWC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.as.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        as.this.fRF = (String) compoundButton.getTag();
                        if (as.this.cWB != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : as.this.cWB) {
                                String str = (String) aVar.getTag();
                                if (str != null && as.this.fRF != null && !str.equals(as.this.fRF)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fRB = (LinearLayout) this.fRA.findViewById(d.g.good_class_group);
            this.fRD = (TextView) this.fRA.findViewById(d.g.dialog_button_cancel);
            this.fRD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fRz instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(as.this.fRz, as.this.fJR.getPageContext());
                    }
                }
            });
            this.fRC = (TextView) this.fRA.findViewById(d.g.dialog_button_ok);
            this.fRC.setOnClickListener(this.dDg);
        }
        this.fRB.removeAllViews();
        this.cWB = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bH = bH("0", this.fJR.getPageContext().getString(d.j.def_good_class));
        this.cWB.add(bH);
        bH.setChecked(true);
        this.fRB.addView(bH);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xy()) && aaVar.xz() > 0) {
                    com.baidu.tieba.pb.pb.main.view.a bH2 = bH(String.valueOf(aaVar.xz()), aaVar.xy());
                    this.cWB.add(bH2);
                    View view = new View(this.fJR.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.aj.t(view, d.C0108d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fRB.addView(view);
                    this.fRB.addView(bH2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fRK.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fJR.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fJR.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fJR.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fRK.setLayoutParams(layoutParams2);
            this.fRK.removeAllViews();
            if (this.fRB == null) {
                this.fRK.addView(this.fRB);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fRz, this.fJR.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bH(String str, String str2) {
        Activity pageActivity = this.fJR.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.s(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cWC);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void bdB() {
        this.fJR.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fJR.hideProgressBar();
        if (z && z2) {
            this.fJR.showToast(this.fJR.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.fJR.showToast(str);
        }
    }

    public void aIH() {
        this.fRt.setVisibility(0);
    }

    public void aIG() {
        this.fRt.setVisibility(8);
    }

    public View bdC() {
        if (this.fRA != null) {
            return this.fRA.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bdD() {
        return this.fRF;
    }

    public View getView() {
        return this.dmF;
    }

    public void bdE() {
        com.baidu.adp.lib.util.l.a(this.fJR.getPageContext().getPageActivity(), this.fJR.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fJR.hideProgressBar();
        if (z) {
            bdT();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bdU();
        } else {
            bdT();
        }
    }

    public void bdF() {
        this.dGi.DI();
        this.dGi.DM();
    }

    public void bdG() {
        this.fJR.hideProgressBar();
        DN();
        this.fQG.completePullRefreshPostDelayed(2000L);
        bdQ();
    }

    public void bdH() {
        this.fQG.completePullRefreshPostDelayed(2000L);
        bdQ();
    }

    private void kx(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fRO.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fJR.getResources().getDimensionPixelSize(d.e.ds130) : this.fJR.getResources().getDimensionPixelSize(d.e.ds34);
        this.fRO.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fRn.setOnLongClickListener(onLongClickListener);
        if (this.fSL != null) {
            this.fSL.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0073b interfaceC0073b, boolean z, boolean z2) {
        if (this.fRG != null) {
            this.fRG.dismiss();
            this.fRG = null;
        }
        this.fRG = new com.baidu.tbadk.core.dialog.b(this.fJR.getPageContext().getPageActivity());
        this.fRG.fe(d.j.operation);
        if (z2) {
            this.fRG.a(new String[]{this.fJR.getPageContext().getString(d.j.copy)}, interfaceC0073b);
        } else if (!z) {
            this.fRG.a(new String[]{this.fJR.getPageContext().getString(d.j.copy), this.fJR.getPageContext().getString(d.j.mark)}, interfaceC0073b);
        } else {
            this.fRG.a(new String[]{this.fJR.getPageContext().getString(d.j.copy), this.fJR.getPageContext().getString(d.j.remove_mark)}, interfaceC0073b);
        }
        this.fRG.d(this.fJR.getPageContext());
        this.fRG.AE();
    }

    public void a(b.InterfaceC0073b interfaceC0073b, boolean z) {
        if (this.fRH != null) {
            this.fRH.dismiss();
            this.fRH = null;
        }
        this.fRH = new com.baidu.tbadk.core.dialog.b(this.fJR.getPageContext().getPageActivity());
        this.fRH.fe(d.j.operation);
        if (z) {
            this.fRH.a(new String[]{this.fJR.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0073b);
        } else {
            this.fRH.a(new String[]{this.fJR.getPageContext().getString(d.j.save_to_emotion), this.fJR.getPageContext().getString(d.j.save_to_local)}, interfaceC0073b);
        }
        this.fRH.d(this.fJR.getPageContext());
        this.fRH.AE();
    }

    public int bdI() {
        return sX(this.fQG.getFirstVisiblePosition());
    }

    private int sX(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fQG.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fQG.getAdapter() == null || !(this.fQG.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fQG.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bdJ() {
        int lastVisiblePosition = this.fQG.getLastVisiblePosition();
        if (this.fQw != null) {
            if (lastVisiblePosition == this.fQG.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return sX(lastVisiblePosition);
    }

    public void sY(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fQG != null) {
            if (this.fQC == null || this.fQC.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fQC.mNavigationBar.getFixedNavHeight();
                if (this.fJR.baw() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fSg != null && (layoutParams = (LinearLayout.LayoutParams) this.fSg.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fSg.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fQG.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fQG.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fRq.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        this.fRn.a(fVar, false);
        this.fRn.notifyDataSetChanged();
        bdQ();
        if (this.fSL != null) {
            this.fSL.aZP();
        }
    }

    public void o(com.baidu.tieba.pb.data.f fVar) {
        if (this.fQW == null) {
            this.fJR.getLayoutMode().aM(((ViewStub) this.fQH.findViewById(d.g.praise_layout)).inflate());
            this.fQW = (FrsPraiseView) this.fQH.findViewById(d.g.pb_head_praise_view);
            this.fQW.setIsFromPb(true);
            this.fRl = this.fQH.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fQW.gz(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fQW != null) {
            boolean bdQ = bdQ();
            this.fQW.setVisibility(8);
            if (fVar != null && fVar.xZ() != null && fVar.xZ().xW() == 0 && this.fFr) {
                if (bdQ) {
                    this.fRk.setVisibility(0);
                    return;
                } else {
                    this.fRk.setVisibility(8);
                    return;
                }
            }
            this.fRk.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aYV() != null) {
            return fVar.aYV();
        }
        if (!com.baidu.tbadk.core.util.v.E(fVar.aYN())) {
            Iterator<PostData> it = fVar.aYN().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bvJ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aYS();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.yT() != null && postData.yT().getUserTbVipInfoData() != null && postData.yT().getUserTbVipInfoData().getvipIntro() != null) {
            postData.yT().getGodUserData().setIntro(postData.yT().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aYL() == null || fVar.aYL().yT() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yT = fVar.aYL().yT();
        String userId = yT.getUserId();
        HashMap<String, MetaData> userMap = fVar.aYL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yT;
        }
        postData.vL(1);
        postData.setId(fVar.aYL().zk());
        postData.setTitle(fVar.aYL().getTitle());
        postData.setTime(fVar.aYL().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x031a  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        String e;
        ArrayList<IconData> tShowInfoNew;
        int s;
        com.baidu.tbadk.data.f bvN;
        String portrait;
        if (fVar != null && fVar.aYL() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            bek();
            this.fQM.setVisibility(8);
            if (fVar.aYL() != null && fVar.aYL().zG() && fVar.aYL().zl() != null) {
                this.fSA = true;
                this.fQC.kT(this.fSA);
                this.fQC.mNavigationBar.hideBottomLine();
                if (this.fQw == null) {
                    this.fQw = new com.baidu.tieba.pb.video.i(this.fJR, this.fQC, fVar.aYL().zl(), this.fQx);
                    this.fQw.a(fVar.aYL().zl(), fVar.aYL(), fVar.getForumId());
                    this.fQw.startPlay();
                } else if (this.fQA) {
                    this.fQw.a(fVar.aYL().zl(), fVar.aYL(), fVar.getForumId());
                    this.fQw.startPlay();
                } else {
                    this.fQw.qH(fVar.getForumId());
                }
                if (fVar.aYM() != null && fVar.aYM().size() >= 1) {
                    bd bdVar = fVar.aYM().get(0);
                    this.fQw.ae(bdVar);
                    this.fQw.qI(bdVar.getTitle());
                }
                this.fQw.b(b, fVar.aYL(), fVar.aZh());
                this.fQA = false;
                this.fQG.removeHeaderView(this.fQw.bfY());
                this.fQG.addHeaderView(this.fQw.bfY(), 0);
                if (this.fQw.bfW() != null && this.fQw.bfW().getParent() == null) {
                    this.fSe.addView(this.fQw.bfW());
                }
                if (this.fQy == null) {
                    this.fQy = new com.baidu.tieba.pb.video.h(this.fJR);
                }
                this.fQy.a(fVar.aYL().zV(), fVar.aYL(), fVar.aZe());
                this.fQG.removeHeaderView(this.fQy.bfN());
                this.fQG.addHeaderView(this.fQy.bfN(), 1);
                if (fVar.aYL().zV() != null) {
                    this.fQG.removeHeaderView(this.fQy.bfO());
                    this.fQG.removeHeaderView(this.fQK);
                    this.fQG.addHeaderView(this.fQy.bfO(), 2);
                } else {
                    if (this.fQy.bfO() != null) {
                        this.fQG.removeHeaderView(this.fQy.bfO());
                    }
                    this.fQG.removeHeaderView(this.fQK);
                    this.fQK.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(this.fJR, d.e.tbds56));
                    this.fQG.addHeaderView(this.fQK, 2);
                }
                if (this.fQw != null) {
                    this.fQC.kN(false);
                    this.fQC.kP(TbadkCoreApplication.isLogin());
                    this.fQw.tf(TbadkCoreApplication.getInst().getSkinType());
                }
                bdO();
            } else {
                this.fSA = false;
                this.fQC.kT(this.fSA);
                if (this.fQw != null) {
                    this.fQG.removeHeaderView(this.fQw.bfY());
                }
                if (this.fQy != null) {
                    this.fQy.b(this.fQG);
                }
                if (b == null || (b != null && (b.bvM() == null || com.baidu.tbadk.core.util.v.E(b.bvM().QD())))) {
                    this.fQK.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(this.fJR, d.e.tbds80));
                } else {
                    this.fQK.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fJR.bal() != null) {
                this.fJR.bal().kL(this.fSA);
            }
            if (this.fQw != null) {
                this.fQw.I(this.fTc);
            }
            if (b != null) {
                this.fRW = b;
                this.fQM.setVisibility(0);
                if (this.fJR.baY()) {
                    if (fVar.aYK() != null) {
                        this.mForumName = fVar.aYK().getForumName();
                        this.mForumId = fVar.aYK().getForumId();
                    }
                    if (this.mForumName == null && this.fJR.aZT() != null && this.fJR.aZT().bbJ() != null) {
                        this.mForumName = this.fJR.aZT().bbJ();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fQM.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fQM.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fSQ) {
                    this.fQI.setVisibility(0);
                }
                if (!fVar.aYL().zG() && this.fQJ.getText() != null && this.fQJ.getText().length() > 0) {
                    this.fQJ.setVisibility(0);
                } else {
                    this.fQJ.setVisibility(8);
                }
                o(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> zf = fVar.aYL().zf();
                if (zf != null && zf.size() > 0 && !this.fSQ) {
                    this.fRZ.setText(String.valueOf(zf.get(0).wU()));
                    this.fRY.setVisibility(0);
                } else {
                    this.fRY.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.s(this.fRY, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.e(this.fRZ, d.C0108d.cp_link_tip_d, 1);
                if (b.yT() != null) {
                    String string = b.yT().getName_show() == null ? StringUtils.string(b.yT().getUserName()) : StringUtils.string(b.yT().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.yT().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.aX(b.yT().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aX(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.yT().getIconInfo();
                            tShowInfoNew = b.yT().getTShowInfoNew();
                            if (this.fKZ != null) {
                                this.fKZ.setTag(d.g.tag_user_id, b.yT().getUserId());
                                this.fKZ.setOnClickListener(this.fJR.fHV.fUO);
                                this.fKZ.a(iconInfo, 4, this.fJR.getResources().getDimensionPixelSize(d.e.tbds36), this.fJR.getResources().getDimensionPixelSize(d.e.tbds36), this.fJR.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fKY != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fKY.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fKY.setOnClickListener(this.fJR.fHV.fUP);
                                this.fKY.a(tShowInfoNew, 3, this.fJR.getResources().getDimensionPixelSize(d.e.tbds36), this.fJR.getResources().getDimensionPixelSize(d.e.tbds36), this.fJR.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fQO.setText(ae(b.yT().getSealPrefix(), e));
                            this.fQO.setTag(d.g.tag_user_id, b.yT().getUserId());
                            this.fQO.setTag(d.g.tag_user_name, b.yT().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew) || b.yT().isBigV()) {
                                com.baidu.tbadk.core.util.aj.e(this.fQO, d.C0108d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.e(this.fQO, d.C0108d.cp_cont_f, 1);
                            }
                            this.fQP.setVisibility(8);
                            if (fVar.aYL().yT() != null && fVar.aYL().yT().getAlaUserData() != null && this.fQU != null) {
                                if (fVar.aYL().yT().getAlaUserData().anchor_live != 0) {
                                    this.fQU.setVisibility(8);
                                } else {
                                    this.fQU.setVisibility(0);
                                    if (this.fQz == null) {
                                        this.fQz = new com.baidu.tieba.d.b(this.fJR.getPageContext(), this.fQU);
                                        this.fQz.lX(1);
                                    }
                                    this.fQz.aJ(this.fJR.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aFL = fVar.aYL().yT().getAlaUserData();
                                    aVar.type = 2;
                                    this.fQU.setTag(aVar);
                                }
                            }
                            this.fQT.setUserId(b.yT().getUserId());
                            this.fQT.setUserName(b.yT().getUserName());
                            this.fQT.setImageDrawable(null);
                            this.fQT.setRadius(com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds40));
                            this.fQT.setTag(b.yT().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fRc.setText(com.baidu.tbadk.core.util.am.A(b.getTime()));
                            } else {
                                this.fRc.setText(com.baidu.tbadk.core.util.am.z(b.getTime()));
                            }
                            s = com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds16);
                            if (!this.fJR.baY() && !StringUtils.isNull(this.mForumName)) {
                                this.bcH.setText(this.fJR.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.bcH.setVisibility(0);
                                this.fRf.setVisibility(0);
                                this.fRc.setPadding(s, 0, s, 0);
                            } else {
                                this.bcH.setVisibility(8);
                                this.fRf.setVisibility(8);
                                this.fRc.setPadding(0, 0, s, 0);
                            }
                            bvN = b.bvN();
                            if (bvN == null && !TextUtils.isEmpty(bvN.getName()) && !TextUtils.isEmpty(bvN.getName().trim())) {
                                final String name = bvN.getName();
                                final String lat = bvN.getLat();
                                final String lng = bvN.getLng();
                                this.fRd.setVisibility(0);
                                this.fRe.setVisibility(0);
                                this.fRd.setText(bvN.getName());
                                this.fRd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.oJ()) {
                                                as.this.fJR.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.P(as.this.fJR.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, as.this.fJR.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fRd.setVisibility(8);
                                this.fRe.setVisibility(8);
                            }
                            portrait = b.yT().getPortrait();
                            if (b.yT().getPendantData() == null && !StringUtils.isNull(b.yT().getPendantData().xu())) {
                                UtilHelper.showHeadImageViewBigV(this.fQR.getHeadView(), b.yT());
                                this.fQT.setVisibility(8);
                                this.fQR.setVisibility(0);
                                if (this.fQX != null) {
                                    this.fQX.setVisibility(8);
                                }
                                this.fQO.setOnClickListener(this.fTc);
                                this.fQR.getHeadView().startLoad(portrait, 28, false);
                                this.fQR.getHeadView().setUserId(b.yT().getUserId());
                                this.fQR.getHeadView().setUserName(b.yT().getUserName());
                                this.fQR.getHeadView().setOnClickListener(this.fTc);
                                this.fQR.eH(b.yT().getPendantData().xu());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fQT, b.yT());
                                this.fQT.setVisibility(0);
                                this.fQM.setOnClickListener(this.fTc);
                                this.fQO.setOnClickListener(this.fTc);
                                this.fQT.setOnClickListener(this.fTc);
                                this.fQR.setVisibility(8);
                                this.fQT.startLoad(portrait, 28, false);
                            }
                            String name_show = b.yT().getName_show();
                            String userName = b.yT().getUserName();
                            if (com.baidu.tbadk.o.ac.nv() && name_show != null && !name_show.equals(userName)) {
                                this.fQO.setText(com.baidu.tieba.pb.c.ak(this.fJR.getPageContext().getPageActivity(), this.fQO.getText().toString()));
                                this.fQO.setGravity(16);
                                this.fQO.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYn());
                                com.baidu.tbadk.core.util.aj.e(this.fQO, d.C0108d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.yT().getIconInfo();
                        tShowInfoNew = b.yT().getTShowInfoNew();
                        if (this.fKZ != null) {
                        }
                        if (this.fKY != null) {
                        }
                        this.fQO.setText(ae(b.yT().getSealPrefix(), e));
                        this.fQO.setTag(d.g.tag_user_id, b.yT().getUserId());
                        this.fQO.setTag(d.g.tag_user_name, b.yT().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fQO, d.C0108d.cp_cont_h, 1);
                        this.fQP.setVisibility(8);
                        if (fVar.aYL().yT() != null) {
                            if (fVar.aYL().yT().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fQT.setUserId(b.yT().getUserId());
                        this.fQT.setUserName(b.yT().getUserName());
                        this.fQT.setImageDrawable(null);
                        this.fQT.setRadius(com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds40));
                        this.fQT.setTag(b.yT().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        s = com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds16);
                        if (!this.fJR.baY()) {
                        }
                        this.bcH.setVisibility(8);
                        this.fRf.setVisibility(8);
                        this.fRc.setPadding(0, 0, s, 0);
                        bvN = b.bvN();
                        if (bvN == null) {
                        }
                        this.fRd.setVisibility(8);
                        this.fRe.setVisibility(8);
                        portrait = b.yT().getPortrait();
                        if (b.yT().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fQT, b.yT());
                        this.fQT.setVisibility(0);
                        this.fQM.setOnClickListener(this.fTc);
                        this.fQO.setOnClickListener(this.fTc);
                        this.fQT.setOnClickListener(this.fTc);
                        this.fQR.setVisibility(8);
                        this.fQT.startLoad(portrait, 28, false);
                        String name_show2 = b.yT().getName_show();
                        String userName2 = b.yT().getUserName();
                        if (com.baidu.tbadk.o.ac.nv()) {
                            this.fQO.setText(com.baidu.tieba.pb.c.ak(this.fJR.getPageContext().getPageActivity(), this.fQO.getText().toString()));
                            this.fQO.setGravity(16);
                            this.fQO.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYn());
                            com.baidu.tbadk.core.util.aj.e(this.fQO, d.C0108d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aX(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.yT().getIconInfo();
                            tShowInfoNew = b.yT().getTShowInfoNew();
                            if (this.fKZ != null) {
                            }
                            if (this.fKY != null) {
                            }
                            this.fQO.setText(ae(b.yT().getSealPrefix(), e));
                            this.fQO.setTag(d.g.tag_user_id, b.yT().getUserId());
                            this.fQO.setTag(d.g.tag_user_name, b.yT().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.e(this.fQO, d.C0108d.cp_cont_h, 1);
                            this.fQP.setVisibility(8);
                            if (fVar.aYL().yT() != null) {
                            }
                            this.fQT.setUserId(b.yT().getUserId());
                            this.fQT.setUserName(b.yT().getUserName());
                            this.fQT.setImageDrawable(null);
                            this.fQT.setRadius(com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds40));
                            this.fQT.setTag(b.yT().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            s = com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds16);
                            if (!this.fJR.baY()) {
                            }
                            this.bcH.setVisibility(8);
                            this.fRf.setVisibility(8);
                            this.fRc.setPadding(0, 0, s, 0);
                            bvN = b.bvN();
                            if (bvN == null) {
                            }
                            this.fRd.setVisibility(8);
                            this.fRe.setVisibility(8);
                            portrait = b.yT().getPortrait();
                            if (b.yT().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fQT, b.yT());
                            this.fQT.setVisibility(0);
                            this.fQM.setOnClickListener(this.fTc);
                            this.fQO.setOnClickListener(this.fTc);
                            this.fQT.setOnClickListener(this.fTc);
                            this.fQR.setVisibility(8);
                            this.fQT.startLoad(portrait, 28, false);
                            String name_show22 = b.yT().getName_show();
                            String userName22 = b.yT().getUserName();
                            if (com.baidu.tbadk.o.ac.nv()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.yT().getIconInfo();
                        tShowInfoNew = b.yT().getTShowInfoNew();
                        if (this.fKZ != null) {
                        }
                        if (this.fKY != null) {
                        }
                        this.fQO.setText(ae(b.yT().getSealPrefix(), e));
                        this.fQO.setTag(d.g.tag_user_id, b.yT().getUserId());
                        this.fQO.setTag(d.g.tag_user_name, b.yT().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fQO, d.C0108d.cp_cont_h, 1);
                        this.fQP.setVisibility(8);
                        if (fVar.aYL().yT() != null) {
                        }
                        this.fQT.setUserId(b.yT().getUserId());
                        this.fQT.setUserName(b.yT().getUserName());
                        this.fQT.setImageDrawable(null);
                        this.fQT.setRadius(com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds40));
                        this.fQT.setTag(b.yT().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        s = com.baidu.adp.lib.util.l.s(this.fJR.getActivity(), d.e.ds16);
                        if (!this.fJR.baY()) {
                        }
                        this.bcH.setVisibility(8);
                        this.fRf.setVisibility(8);
                        this.fRc.setPadding(0, 0, s, 0);
                        bvN = b.bvN();
                        if (bvN == null) {
                        }
                        this.fRd.setVisibility(8);
                        this.fRe.setVisibility(8);
                        portrait = b.yT().getPortrait();
                        if (b.yT().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fQT, b.yT());
                        this.fQT.setVisibility(0);
                        this.fQM.setOnClickListener(this.fTc);
                        this.fQO.setOnClickListener(this.fTc);
                        this.fQT.setOnClickListener(this.fTc);
                        this.fQR.setVisibility(8);
                        this.fQT.startLoad(portrait, 28, false);
                        String name_show222 = b.yT().getName_show();
                        String userName222 = b.yT().getUserName();
                        if (com.baidu.tbadk.o.ac.nv()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.fQL.W(fVar.aYL());
                }
                if (this.fSh != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fEv);
                    if (fVar != null && fVar.aYL() != null) {
                        jVar.fEx = fVar.aYL().yL();
                    }
                    jVar.bud = !this.fFr;
                    jVar.fEz = this.fJR.baX();
                    this.fSh.a(jVar);
                }
            }
        }
    }

    public void ky(boolean z) {
        if (z) {
            bdK();
        } else {
            bdL();
        }
        this.fSl.fTu = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fSl));
        a(this.fSl.fTu, false);
    }

    public void bdK() {
        if (this.fQC != null && !this.fSC) {
            this.fQC.kU(!StringUtils.isNull(this.fJR.bat()));
            this.fSC = true;
        }
    }

    public void bdL() {
        if (this.fQC != null) {
            this.fQC.beO();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.zp() != null) {
            this.fQN.a(this.fJR.getPageContext(), fVar.aYN().get(0).zp(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aYJ().getId(), fVar.aYJ().getName(), fVar.aYL().getId(), this.fJR.baU() ? "FRS" : null));
            this.fQM.setPadding(this.fQM.getPaddingLeft(), (int) this.fJR.getResources().getDimension(d.e.ds20), this.fQM.getPaddingRight(), this.fQM.getPaddingBottom());
            return;
        }
        this.fQN.a(null, null, null);
    }

    public void bdM() {
        if (this.fQw != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").s("obj_type", 1));
            this.fQw.bfX();
            this.fQG.smoothScrollToPosition(0);
        }
    }

    public boolean bdN() {
        return this.fTd;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean Y(bd bdVar) {
        if (bdVar == null || bdVar.yT() == null || bdVar.yT().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.yT().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.fQC.beM();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.fQC.oa(eVar.forumName);
            }
            String string = this.fJR.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.h(eVar.source, 0)) {
                case 100:
                    str = this.fJR.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.fJR.getResources().getString(d.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fJR.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.fDG;
            this.fJR.showNetRefreshView(this.dmF, format, null, this.fJR.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.pa()) {
                        com.baidu.tbadk.core.util.av.Da().c(as.this.fJR.getPageContext(), new String[]{str2});
                        as.this.fJR.finish();
                        return;
                    }
                    as.this.fJR.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bcT;
        Parcelable bcT2;
        String str;
        if (fVar != null) {
            this.fNb = fVar;
            this.mType = i;
            if (fVar.aYL() != null) {
                this.fSn = fVar.aYL().yE();
                if (fVar.aYL().getAnchorLevel() != 0) {
                    this.fTd = true;
                }
                this.fRJ = Y(fVar.aYL());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            r(fVar);
            this.fRX = false;
            this.fFr = z;
            bdG();
            b(fVar, z, i);
            p(fVar);
            if (this.fSO == null) {
                this.fSO = new ac(this.fJR.getPageContext(), this.dSJ);
            }
            this.fSO.qn(fVar.aYQ());
            if (this.fJR.baK()) {
                if (this.fRr == null) {
                    this.fRr = new com.baidu.tieba.pb.view.i(this.fJR.getPageContext());
                    this.fRr.sv();
                    this.fRr.a(this.baZ);
                }
                this.fQG.setPullRefresh(this.fRr);
                bdO();
                if (this.fRr != null) {
                    this.fRr.gv(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.xZ().xW() == 0 && z) {
                this.fQG.setPullRefresh(null);
            } else {
                if (this.fRr == null) {
                    this.fRr = new com.baidu.tieba.pb.view.i(this.fJR.getPageContext());
                    this.fRr.sv();
                    this.fRr.a(this.baZ);
                }
                this.fQG.setPullRefresh(this.fRr);
                bdO();
                if (this.fRr != null) {
                    this.fRr.gv(TbadkCoreApplication.getInst().getSkinType());
                }
                afb();
            }
            bdQ();
            this.fRn.jH(this.fFr);
            this.fRn.jI(false);
            this.fRn.jT(i == 5);
            this.fRn.jU(i == 6);
            this.fRn.jV(z2 && this.fTb);
            this.fRn.a(fVar, false);
            this.fRn.notifyDataSetChanged();
            if (this.fJR.baY()) {
                this.fSE = 0;
                PostData b = b(fVar, z);
                if (b != null && b.yT() != null) {
                    this.fSE = b.yT().getLevel_id();
                }
                if (this.fSE > 0) {
                    this.fQQ.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.fQQ, BitmapHelper.getGradeResourceIdInEnterForum(this.fSE));
                } else {
                    this.fQQ.setVisibility(8);
                }
            } else {
                this.fQQ.setVisibility(8);
            }
            if (fVar.aYL() != null) {
                if (fVar.aYL().yI() != null) {
                    if (fVar.aYL().yI().getNum() < 1) {
                        str = this.fJR.getResources().getString(d.j.zan);
                    } else {
                        str = fVar.aYL().yI().getNum() + "";
                    }
                    if (this.fQv != -1) {
                        fVar.aYL().yI().setIsLike(this.fQv);
                    }
                    S(str, fVar.aYL().yI().getIsLike() == 1);
                }
                if (fVar.aYL().aPc != null && fVar.aYL().aPc.isDeleted) {
                    this.fQC.kO(true);
                } else {
                    this.fQC.kO(false);
                }
            }
            if (this.fJR.isLogin()) {
                this.fQG.setNextPage(this.dGi);
                this.fQB = 2;
                afb();
            } else {
                this.fRX = true;
                if (fVar.xZ().xV() == 1) {
                    if (this.fRs == null) {
                        this.fRs = new com.baidu.tieba.pb.view.b(this.fJR.getPageContext());
                    }
                    this.fQG.setNextPage(this.fRs);
                } else {
                    this.fQG.setNextPage(this.dGi);
                }
                this.fQB = 3;
            }
            ArrayList<PostData> aYN = fVar.aYN();
            if (fVar.xZ().xV() == 0 || aYN == null || aYN.size() < fVar.xZ().xU()) {
                if (com.baidu.tbadk.core.util.v.D(aYN) == 0 || (com.baidu.tbadk.core.util.v.D(aYN) == 1 && aYN.get(0) != null && aYN.get(0).bvJ() == 1)) {
                    this.dGi.setText(this.fJR.getResources().getString(d.j.list_no_more_new));
                    if (this.fJR.bal() != null && !this.fJR.bal().beD()) {
                        this.fJR.bal().showFloatingView();
                    }
                } else {
                    this.dGi.setText(this.fJR.getResources().getString(d.j.list_has_no_more));
                }
                if (this.fJR.baK() && this.fQG != null && this.fQG.getData() != null && this.fQG.getData().size() == 1 && (this.fQG.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.dGi.setText("");
                }
                bdX();
            } else if (z2) {
                if (this.fTb) {
                    DN();
                    if (fVar.xZ().xV() != 0) {
                        this.dGi.setText(this.fJR.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.dGi.DI();
                    this.dGi.showLoading();
                }
            } else {
                this.dGi.DI();
                this.dGi.showLoading();
            }
            switch (i) {
                case 2:
                    this.fQG.setSelection(i2 > 1 ? (((this.fQG.getData() == null && fVar.aYN() == null) ? 0 : (this.fQG.getData().size() - fVar.aYN().size()) + this.fQG.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bcT2 = aj.bcS().bcT()) != null) {
                        this.fQG.onRestoreInstanceState(bcT2);
                        if (com.baidu.tbadk.core.util.v.D(aYN) > 1 && fVar.xZ().xV() > 0) {
                            this.dGi.DN();
                            this.dGi.setText(this.fJR.getString(d.j.pb_load_more_without_point));
                            this.dGi.DJ();
                            break;
                        }
                    } else {
                        this.fQG.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fTb = false;
                    break;
                case 5:
                    this.fQG.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bcT = aj.bcS().bcT()) != null) {
                        this.fQG.onRestoreInstanceState(bcT);
                        break;
                    } else {
                        this.fQG.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fQw != null && this.fQw.bfW() != null) {
                            if (this.fJR.isUseStyleImmersiveSticky()) {
                                this.fQG.setSelectionFromTop((this.fRn.bbn() + this.fQG.getHeaderViewsCount()) - 1, this.fQw.bfW().getHeight() - com.baidu.adp.lib.util.l.n(this.fJR.getPageContext().getPageActivity()));
                            } else {
                                this.fQG.setSelectionFromTop((this.fRn.bbn() + this.fQG.getHeaderViewsCount()) - 1, this.fQw.bfW().getHeight());
                            }
                        } else {
                            this.fQG.setSelection(this.fRn.bbn() + this.fQG.getHeaderViewsCount());
                        }
                    } else {
                        this.fQG.setSelection(i2 > 0 ? ((this.fQG.getData() == null && fVar.aYN() == null) ? 0 : (this.fQG.getData().size() - fVar.aYN().size()) + this.fQG.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dGi.DN();
                    this.dGi.setText(this.fJR.getString(d.j.pb_load_more_without_point));
                    this.dGi.DJ();
                    break;
            }
            if (this.fSn == fSo && isHost()) {
                bef();
            }
            if (this.fSy) {
                bde();
                this.fSy = false;
                if (i3 == 0) {
                    kr(true);
                }
            }
            if (this.fQy != null) {
                this.fQy.ad(fVar.aYL());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.fEm == 1 || fVar.fEn == 1) {
                if (this.fSF == null) {
                    this.fSF = new PbTopTipView(this.fJR);
                }
                if (fVar.fEn == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fJR.getStType())) {
                    this.fSF.setText(this.fJR.getString(d.j.pb_read_strategy_add_experience));
                    this.fSF.show(this.dmF, this.mSkinType);
                } else if (fVar.fEm == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fJR.getStType())) {
                    this.fSF.setText(this.fJR.getString(d.j.pb_read_news_add_experience));
                    this.fSF.show(this.dmF, this.mSkinType);
                }
            }
        }
    }

    private void bdO() {
        if (this.fQw != null && this.fQw.bfW() != null) {
            this.fQG.removeHeaderView(this.bmx);
            if (this.mType != 1) {
                this.fQG.removeHeaderView(this.fQw.bfY());
                this.fQG.addHeaderView(this.fQw.bfY(), 0);
                return;
            }
            return;
        }
        if (this.fQw != null) {
            this.fQG.removeHeaderView(this.fQw.bfY());
        }
        this.fQG.removeHeaderView(this.bmx);
        this.fQG.addHeaderView(this.bmx, 0);
    }

    public void kz(boolean z) {
        this.fRI = z;
    }

    public void DN() {
        if (this.dGi != null) {
            this.dGi.DJ();
            this.dGi.DN();
        }
        afb();
    }

    public void WP() {
        this.fQG.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.fRW != null && this.fRW.yT() != null && this.fQC != null) {
            this.fSB = !this.fSA;
            this.fQC.kN(this.fSB);
            if (this.fJR.bal() != null) {
                this.fJR.bal().kM(this.fSB);
            }
            bdP();
            if (this.fSB) {
                this.fQC.fVD.setVisibility(0);
                if (this.fRJ) {
                    this.fQC.fVE.setVisibility(8);
                    this.fQY.setVisibility(8);
                    this.fRb.setVisibility(0);
                    this.fRb.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(fVar.aZg())));
                } else if (!PbNormalLikeButtonSwitchStatic.Ok() || (this.fRW.yT().hadConcerned() && this.fRW.yT().getGodUserData() != null && this.fRW.yT().getGodUserData().getIsFromNetWork())) {
                    this.fQC.fVE.setVisibility(8);
                }
                if (this.fSg != null) {
                    this.fSg.setVisibility(8);
                }
                this.fQC.a(this.fRW.yT(), this.fTc);
                if (this.fSM == null) {
                    this.fSM = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.as.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > as.this.fSD) {
                                as.this.bee();
                            }
                        }
                    };
                }
                this.fQG.setListViewDragListener(this.fSM);
                return;
            }
            if (this.fQC.fVD != null) {
                this.fQC.fVD.setVisibility(8);
            }
            if (this.fSg != null) {
                this.fSg.setVisibility(0);
            }
            if (this.fRJ) {
                this.fQY.setVisibility(8);
                this.fRb.setVisibility(0);
                this.fRb.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(fVar.aZg())));
            } else if (!PbNormalLikeButtonSwitchStatic.Ok() || (this.fRW.yT().hadConcerned() && this.fRW.yT().getGodUserData() != null && this.fRW.yT().getGodUserData().getIsFromNetWork())) {
                this.fQY.setVisibility(8);
                this.fRb.setVisibility(8);
            } else {
                this.fRb.setVisibility(8);
            }
            this.fSM = null;
            this.fQG.setListViewDragListener(null);
        }
    }

    private void bdP() {
        String threadId = this.fNb != null ? this.fNb.getThreadId() : "";
        if (this.fSB) {
            if (this.fRa == null) {
                this.fRa = new aq(this.fJR.getPageContext(), this.fQC.fVE, 3);
                this.fRa.h(this.fJR.getUniqueId());
            }
            if (this.fRW != null && this.fRW.yT() != null) {
                this.fRW.yT().setIsLike(this.fRW.yT().hadConcerned());
                this.fRa.a(this.fRW.yT());
            }
            this.fRa.cK(threadId);
            this.fRa.fQs = this.fSA;
        }
        if (this.fQZ == null) {
            this.fQZ = new aq(this.fJR.getPageContext(), this.fQY, 1);
            this.fQZ.h(this.fJR.getUniqueId());
            this.fQZ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.as.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bv(boolean z) {
                    if (as.this.fJR != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(as.this.fJR, d.j.attention_success);
                            return;
                        }
                        ar.u(as.this.fJR.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fRW != null && this.fRW.yT() != null) {
            this.fRW.yT().setIsLike(this.fRW.yT().hadConcerned());
            this.fQZ.a(this.fRW.yT());
            this.fQZ.cK(threadId);
        }
        this.fQZ.fQs = this.fSA;
    }

    private boolean bdQ() {
        boolean z;
        if (this.fRM != null && this.fRM.getVisibility() == 0) {
            if (this.fRj != null) {
                this.fRj.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fRj != null) {
                this.fRj.setVisibility(8);
            }
            z = false;
        }
        if ((this.fRl == null || this.fRl.getVisibility() == 8) && z && this.fFr) {
            this.fRk.setVisibility(0);
        } else {
            this.fRk.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aYL() == null) {
            return false;
        }
        if (fVar.aYL().yQ() == 1 || fVar.aYL().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aYL().yS() == null || fVar.aYL().yS().Ap() == 0) || fVar.aYL().yO() == 1 || fVar.aYL().yP() == 1 || fVar.aYL().zy() || fVar.aYL().zJ() || fVar.aYL().zF() || fVar.aYL().zg() != null || fVar.aYL().zK() || fVar.aYL().zK() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aYL().getCategory()) || fVar.aYL().yX() || fVar.aYL().yW();
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return com.baidu.tieba.card.k.a((Context) this.fJR.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.fQI != null) {
                if (fVar.aYL() != null && fVar.aYL().zj() == 0 && !fVar.aYL().zG() && !this.fSQ) {
                    this.fQI.setVisibility(0);
                    if (fVar.aYL() != null) {
                        fVar.aYL().h(true, q(fVar));
                    }
                    SpannableStringBuilder zt = fVar.aYL().zt();
                    this.fQJ.setOnTouchListener(new com.baidu.tieba.view.m(zt));
                    if (this.fSN) {
                        this.fQJ.setText(fVar.aYL().getTitle());
                    } else {
                        this.fQJ.setText(zt);
                    }
                    this.fQJ.setVisibility(0);
                } else if (fVar.aYL().zj() == 1) {
                    if (fVar.aYL() != null) {
                        this.fQI.setVisibility(8);
                        this.fQG.removeHeaderView(this.fQI);
                        if (fVar.aYL() != null && !fVar.aYL().zG()) {
                            this.fQM.setPadding(this.fQM.getPaddingLeft(), com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.tbds36), this.fQM.getPaddingRight(), this.fQM.getPaddingBottom());
                        }
                    }
                } else {
                    this.fQI.setVisibility(8);
                    this.fQG.removeHeaderView(this.fQI);
                    if (fVar.aYL() != null && fVar.aYL().zG()) {
                        this.fQM.setPadding(this.fQM.getPaddingLeft(), 0, this.fQM.getPaddingRight(), this.fQM.getPaddingBottom());
                    } else {
                        this.fQM.setPadding(this.fQM.getPaddingLeft(), com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds48), this.fQM.getPaddingRight(), this.fQM.getPaddingBottom());
                    }
                }
            }
            this.fFr = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            bdQ();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.yT().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aYX()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.yT() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.yT().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aYX()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<ay> aZf = fVar.aZf();
                if (com.baidu.tbadk.core.util.v.D(aZf) > 0) {
                    sb = new StringBuilder();
                    for (ay ayVar : aZf) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aMS) != null && tVar.aKZ && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fJR.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fJR.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bxo;
    }

    public void qo(String str) {
        if (this.dGi != null) {
            this.dGi.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fQG;
    }

    public int bdR() {
        return d.g.richText;
    }

    public TextView bag() {
        return this.fQL.bag();
    }

    public void d(BdListView.e eVar) {
        this.fQG.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.baZ = bVar;
        if (this.fRr != null) {
            this.fRr.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int xT = alVar.xT();
            int xQ = alVar.xQ();
            if (this.fRo != null) {
                this.fRo.AB();
            } else {
                this.fRo = new com.baidu.tbadk.core.dialog.a(this.fJR.getPageContext().getPageActivity());
                this.fRp = LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fRo.aO(this.fRp);
                this.fRo.a(d.j.dialog_ok, bVar);
                this.fRo.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        as.this.bdT();
                        aVar.dismiss();
                    }
                });
                this.fRo.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.as.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (as.this.fSv == null) {
                            as.this.fSv = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    as.this.fJR.HidenSoftKeyPad((InputMethodManager) as.this.fJR.getSystemService("input_method"), as.this.dmF);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.ns().postDelayed(as.this.fSv, 150L);
                    }
                });
                this.fRo.b(this.fJR.getPageContext()).AB();
            }
            this.fRq = (EditText) this.fRp.findViewById(d.g.input_page_number);
            this.fRq.setText("");
            TextView textView = (TextView) this.fRp.findViewById(d.g.current_page_number);
            if (xT <= 0) {
                xT = 1;
            }
            if (xQ <= 0) {
                xQ = 1;
            }
            textView.setText(MessageFormat.format(this.fJR.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(xT), Integer.valueOf(xQ)));
            this.fJR.ShowSoftKeyPadDelay(this.fRq, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fQG.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fJR.showToast(str);
    }

    public boolean kA(boolean z) {
        if (this.axQ == null || !this.axQ.Kz()) {
            return false;
        }
        this.axQ.IG();
        return true;
    }

    public void bdS() {
        if (this.fTe != null) {
            while (this.fTe.size() > 0) {
                TbImageView remove = this.fTe.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bdS();
        this.fRn.sJ(1);
        if (this.fQw != null) {
            this.fQw.onPause();
        }
    }

    public void onResume() {
        this.fRn.sJ(2);
        if (this.fQw != null) {
            this.fQw.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fSx != null) {
            this.fSx.destroy();
        }
        if (this.fSO != null) {
            this.fSO.onDestory();
        }
        if (this.fSF != null) {
            this.fSF.hide();
        }
        if (this.fQz != null) {
            this.fQz.amw();
        }
        if (this.fQy != null) {
            this.fQy.onDestroy();
        }
        this.fJR.hideProgressBar();
        if (this.dmD != null && this.dzL != null) {
            this.dmD.b(this.dzL);
        }
        bdT();
        DN();
        if (this.fSv != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fSv);
        }
        if (this.fQM != null && this.fQX != null) {
            this.fQM.removeView(this.fQS);
            this.fQX = null;
        }
        if (this.fSb != null) {
            this.fSb.clearStatus();
        }
        this.fSX = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fRn.sJ(3);
        if (this.dDt != null) {
            this.dDt.setBackgroundDrawable(null);
        }
        if (this.fQw != null) {
            this.fQw.destroy();
        }
        if (this.fRn != null) {
            this.fRn.onDestory();
        }
        this.fQG.setOnLayoutListener(null);
        if (this.fSK != null) {
            this.fSK.avS();
        }
        if (this.fSm != null) {
            this.fSm.onDestroy();
        }
        beq();
    }

    public boolean sZ(int i) {
        if (this.fQw != null) {
            return this.fQw.ne(i);
        }
        return false;
    }

    public void bdT() {
        this.fQC.vU();
        if (this.fQz != null) {
            this.fQz.amw();
        }
        com.baidu.adp.lib.util.l.a(this.fJR.getPageContext().getPageActivity(), this.fRq);
        bdh();
        if (this.fRG != null) {
            this.fRG.dismiss();
        }
        bdV();
        if (this.fQy != null) {
            this.fQy.bfP();
        }
        if (this.fRo != null) {
            this.fRo.dismiss();
        }
        if (this.dDf != null) {
            this.dDf.dismiss();
        }
    }

    public void bdU() {
        this.fQC.vU();
        if (this.fQz != null) {
            this.fQz.amw();
        }
        if (this.fRG != null) {
            this.fRG.dismiss();
        }
        bdV();
        if (this.fQy != null) {
            this.fQy.bfP();
        }
        if (this.fRo != null) {
            this.fRo.dismiss();
        }
        if (this.dDf != null) {
            this.dDf.dismiss();
        }
    }

    public void cQ(List<String> list) {
        this.fSJ = list;
        if (this.fSK != null) {
            this.fSK.setData(list);
        }
    }

    public void jG(boolean z) {
        this.fRn.jG(z);
    }

    public void kB(boolean z) {
        this.fRL = z;
    }

    public void bdV() {
        if (this.fRx != null) {
            this.fRx.dismiss();
        }
        if (this.fRy != null) {
            com.baidu.adp.lib.g.g.b(this.fRy, this.fJR.getPageContext());
        }
        if (this.fRz != null) {
            com.baidu.adp.lib.g.g.b(this.fRz, this.fJR.getPageContext());
        }
        if (this.fRv != null) {
            com.baidu.adp.lib.g.g.b(this.fRv, this.fJR.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fNb, this.fFr);
            d(this.fNb, this.fFr, this.mType);
            this.fJR.getLayoutMode().aN(i == 1);
            this.fJR.getLayoutMode().aM(this.dmF);
            this.fJR.getLayoutMode().aM(this.fQH);
            com.baidu.tbadk.core.util.aj.s(this.fQK, d.C0108d.cp_bg_line_d);
            if (this.fQy != null) {
                this.fQy.onChangeSkinType(i);
            }
            if (this.fQJ != null) {
                com.baidu.tbadk.core.util.aj.r(this.fQJ, d.C0108d.cp_cont_b);
                this.fQJ.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_link_tip_c));
            }
            if (this.dGi != null) {
                this.dGi.gv(i);
                if (this.bxo != null) {
                    this.fJR.getLayoutMode().aM(this.bxo);
                    com.baidu.tbadk.core.util.aj.s(this.bxo, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fRo != null) {
                this.fRo.c(this.fJR.getPageContext());
            }
            kz(this.fRI);
            this.fRn.notifyDataSetChanged();
            if (this.fRr != null) {
                this.fRr.gv(i);
            }
            if (this.axQ != null) {
                this.axQ.onChangeSkinType(i);
            }
            if (this.fQW != null) {
                this.fQW.gz(i);
            }
            if (this.fRs != null) {
                this.fRs.gv(i);
            }
            if (!com.baidu.tbadk.core.util.v.E(this.cWB)) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.cWB) {
                    aVar.Dw();
                }
            }
            kv(i == 1);
            bdv();
            UtilHelper.setStatusBarBackground(this.dDt, i);
            UtilHelper.setStatusBarBackground(this.fSg, i);
            if (this.fQY != null) {
                this.fQY.onChangeSkinType(i);
            }
            if (this.fRd != null) {
                com.baidu.tbadk.core.util.aj.r(this.fRd, d.C0108d.cp_cont_d);
            }
            if (this.fRc != null) {
                com.baidu.tbadk.core.util.aj.r(this.fRc, d.C0108d.cp_cont_d);
            }
            if (this.fRe != null) {
                com.baidu.tbadk.core.util.aj.s(this.fRe, d.C0108d.cp_cont_e);
            }
            if (this.bcH != null) {
                com.baidu.tbadk.core.util.aj.r(this.bcH, d.C0108d.cp_cont_d);
            }
            if (this.fRf != null) {
                com.baidu.tbadk.core.util.aj.s(this.fRf, d.C0108d.cp_cont_e);
            }
            if (this.fQP != null) {
                com.baidu.tbadk.core.util.aj.r(this.fQP, d.C0108d.cp_link_tip_a);
            }
            if (this.fRb != null) {
                com.baidu.tbadk.core.util.aj.r(this.fRb, d.C0108d.cp_cont_d);
            }
            if (this.fRg != null) {
                com.baidu.tbadk.n.a.a(this.fJR.getPageContext(), this.fRg);
            }
            if (this.fRE != null) {
                com.baidu.tbadk.n.a.a(this.fJR.getPageContext(), this.fRE);
            }
            if (this.fSw != null) {
                this.fSw.onChangeSkinType(i);
            }
            if (this.fQC != null) {
                if (this.fQw != null) {
                    this.fQw.tf(i);
                } else {
                    this.fQC.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fRO != null) {
                com.baidu.tbadk.core.util.aj.r(this.fRO, d.C0108d.cp_cont_e);
            }
            if (this.fQQ != null) {
                com.baidu.tbadk.core.util.aj.c(this.fQQ, BitmapHelper.getGradeResourceIdInEnterForum(this.fSE));
            }
            if (this.fSL != null) {
                this.fSL.onChangeSkinType(i);
            }
            if (this.fSm != null) {
                this.fSm.onChangeSkinType();
            }
            if (this.fSI != null) {
                com.baidu.tbadk.core.util.aj.r(this.fSI, d.C0108d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJN = hVar;
        this.fRn.setOnImageClickListener(this.bJN);
        this.fSL.setOnImageClickListener(this.bJN);
    }

    public void h(NoNetworkView.a aVar) {
        this.dzL = aVar;
        if (this.dmD != null) {
            this.dmD.a(this.dzL);
        }
    }

    public void kC(boolean z) {
        this.fRn.setIsFromCDN(z);
    }

    public Button bdW() {
        return this.fRM;
    }

    public void bdX() {
        if (this.fQB != 2) {
            this.fQG.setNextPage(this.dGi);
            this.fQB = 2;
        }
    }

    public void bdY() {
        if (com.baidu.tbadk.k.r.NQ().NR()) {
            int lastVisiblePosition = this.fQG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fQG.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog = tbImageView.getPerfLog();
                                perfLog.im(1001);
                                perfLog.byw = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.k.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.im(1001);
                        perfLog2.byw = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bdZ() {
        return this.axQ != null && this.axQ.getVisibility() == 0;
    }

    public boolean bea() {
        return this.axQ != null && this.axQ.Kz();
    }

    public void beb() {
        if (this.axQ != null) {
            this.axQ.IG();
        }
    }

    public void kD(boolean z) {
        if (this.fRN != null) {
            kB(this.fJR.bah().La());
            if (this.fRL) {
                ks(z);
            } else {
                kt(z);
            }
        }
    }

    public void bec() {
        if (this.fRN != null) {
            this.fRN.setVisibility(8);
            this.fRS = false;
            if (this.fSm != null) {
                this.fSm.setVisibility(8);
                kx(false);
            }
            beq();
        }
    }

    public void showLoadingDialog() {
        if (this.ddR == null) {
            this.ddR = new com.baidu.tbadk.core.view.b(this.fJR.getPageContext());
        }
        this.ddR.bn(true);
    }

    public void afb() {
        if (this.ddR != null) {
            this.ddR.bn(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fQG.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fQG.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fQw != null) {
            this.fQw.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.fhX = getScrollY();
            this.fSl.fTu = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fSl));
            a(this.fSl.fTu, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fQw != null) {
            this.fQw.b(absListView, i);
        }
        int headerViewsCount = (i - this.fQG.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fRn.sI(headerViewsCount) == com.baidu.tieba.pb.data.l.fEC) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fQG.getHeaderViewsCount();
        if (this.fQK != null && this.fQC != null) {
            this.fQC.i(this.fQK.getBottom(), this.fQK.getMeasuredHeight(), z2);
        }
        this.fRn.bbr().m(z, this.fSe != null ? this.fSe.getMeasuredHeight() : 0);
        this.fSl.fzq = i;
        this.fSl.fTt = this.fQG.getHeaderViewsCount();
        this.fSl.fTu = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fSl));
        a(this.fSl.fTu, false);
    }

    public void bed() {
        if (this.fJR.isLogin() && this.fNb != null && this.fSB && !this.fSA && !this.fRJ && this.fRW != null && this.fRW.yT() != null && !this.fRW.yT().getIsLike() && !this.fRW.yT().hadConcerned()) {
            if (this.fSx == null) {
                this.fSx = new an(this.fJR);
            }
            this.fSx.a(this.fQC.fVD, this.fNb.aZj(), this.fRW.yT().getUserId(), this.fNb.getThreadId());
        }
    }

    public void bee() {
        if (this.fSB && !this.fSA && this.fRW != null && this.fRW.yT() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").s("obj_locate", this.fJR.baY() ? 2 : 1).s("obj_type", this.fSA ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fJR.getPageContext().getPageActivity(), this.fRW.yT().getUserId(), this.fRW.yT().getUserName(), this.fJR.aZT().bbJ(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fSA && this.fSf != null && this.fQC.beH() != null) {
            int bbo = this.fRn.bbo();
            if (bbo > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bbo > this.fQG.getFirstVisiblePosition() - this.fQG.getHeaderViewsCount()) {
                    this.fSf.setVisibility(8);
                    return;
                }
                this.fSf.setVisibility(0);
                this.fQC.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fPS == null) {
                if (this.fQG.getFirstVisiblePosition() == 0) {
                    this.fSf.setVisibility(8);
                    this.fQC.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fSk) {
                        this.fSj = top;
                        this.fSk = false;
                    }
                    this.fSj = top < this.fSj ? top : this.fSj;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fRm.getY() < 0.0f) {
                        measuredHeight = fSi - alVar.fPS.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fQC.beH().getMeasuredHeight() - alVar.fPS.getMeasuredHeight();
                        this.fQC.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fSj) {
                        this.fSf.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fSf.setVisibility(0);
                    } else {
                        this.fSf.setVisibility(8);
                        this.fQC.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fSk = true;
                    }
                }
            }
        }
    }

    public void bef() {
        if (!this.fTf) {
            TiebaStatic.log("c10490");
            this.fTf = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fJR.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fSp, Integer.valueOf(fSr));
            aVar.fa(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.aO(inflate);
            aVar.aE(sparseArray);
            aVar.a(d.j.grade_button_tips, this.fJR);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fJR.getPageContext()).AB();
        }
    }

    public void qp(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fJR.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fSp, Integer.valueOf(fSs));
        aVar.aE(sparseArray);
        aVar.a(d.j.view, this.fJR);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fJR.getPageContext()).AB();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.yT() != null) {
            MetaData yT = b.yT();
            yT.setGiftNum(yT.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
        p(fVar);
    }

    public PbInterviewStatusView beg() {
        return this.fSb;
    }

    private void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aYL() != null && fVar.aYL().zJ() && this.fSb == null) {
            this.fSb = (PbInterviewStatusView) this.fSa.inflate();
            this.fSb.setOnClickListener(this.dDg);
            this.fSb.setCallback(this.fJR.baT());
            this.fSb.c(this.fJR, fVar);
        }
    }

    public LinearLayout beh() {
        return this.fRm;
    }

    public View bei() {
        return this.dDt;
    }

    public boolean bej() {
        return this.fSQ;
    }

    public void jL(boolean z) {
        this.fQL.jL(z);
    }

    private void bek() {
        if (this.fSQ) {
            if (this.fSR == null) {
                e.a aVar = e.fHl.get();
                if (aVar != null) {
                    this.fSR = aVar.a(this.fJR);
                    com.baidu.adp.widget.ListView.e adapter = this.fQG.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.bmx) {
                            this.fQG.addHeaderView(this.fSR.bae(), 1);
                        } else {
                            this.fQG.addHeaderView(this.fSR.bae(), 0);
                        }
                    }
                } else {
                    this.fQK.setVisibility(0);
                    return;
                }
            }
            this.fQK.setVisibility(8);
            this.fQG.removeHeaderView(this.fQK);
            return;
        }
        this.fQK.setVisibility(0);
    }

    public void kE(boolean z) {
        this.fSQ = z;
    }

    public void bel() {
        this.fJR.showNetRefreshView(getView(), "");
        View Mj = this.fJR.getRefreshView().Mj();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Mj.getLayoutParams();
        layoutParams.addRule(3, beh().getId());
        Mj.setLayoutParams(layoutParams);
        this.fJR.hideLoadingView(getView());
        if (this.fSR != null) {
            this.fQG.removeHeaderView(this.fSR.bae());
            this.fSR = null;
        }
    }

    public void qq(String str) {
        if (this.fQD != null) {
            this.fQD.setTitle(str);
        }
    }

    private int kF(boolean z) {
        if (this.fSb == null || this.fSb.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bem() {
        if (this.fSb != null && this.fSb.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fSb.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fSb.setLayoutParams(layoutParams);
        }
    }

    public boolean ban() {
        return false;
    }

    public void qr(String str) {
        this.fRO.performClick();
        if (!StringUtils.isNull(str) && this.fJR.bah() != null && this.fJR.bah().KU() != null && this.fJR.bah().KU().getInputView() != null) {
            EditText inputView = this.fJR.bah().KU().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bdT();
            if (configuration.orientation == 2) {
                bec();
                bdh();
            } else {
                bdk();
            }
            if (this.fSw != null) {
                this.fSw.bbv();
            }
            this.fJR.aut();
            this.fRm.setVisibility(8);
            this.fQC.kQ(false);
            this.fJR.jR(false);
            if (this.fQw != null) {
                if (configuration.orientation == 1) {
                    beh().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fQG.setIsLandscape(true);
                    this.fQG.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fQG.setIsLandscape(false);
                    if (this.fhX > 0) {
                        this.fQG.smoothScrollBy(this.fhX, 0);
                    }
                }
                this.fQw.onConfigurationChanged(configuration);
            }
        }
    }

    public void kG(boolean z) {
        this.fQA = z;
    }

    public boolean ben() {
        return this.fQw != null && this.fQw.ben();
    }

    public void beo() {
        if (this.fQw != null) {
            this.fQw.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fQy != null) {
            this.fQy.y(j, i);
        }
        if (this.fQw != null) {
            this.fQw.y(j, i);
        }
    }

    public void jW(boolean z) {
        this.fRn.jW(z);
    }

    public void bep() {
        if (this.fSc == null) {
            LayoutInflater.from(this.fJR.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.dmF, true);
            this.fSc = (ViewGroup) this.dmF.findViewById(d.g.add_experienced_layout);
            this.fSd = (TextView) this.dmF.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.r(this.fSd, d.C0108d.cp_cont_i);
            String string = this.fJR.getResources().getString(d.j.experienced_add_success);
            String string2 = this.fJR.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_h)));
            this.fSd.setText(spannableString);
        }
        this.fSc.setVisibility(0);
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
                        as.this.fSc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                as.this.fSd.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fSd.startAnimation(scaleAnimation);
    }

    public void cA(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fRN.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fJR);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fSI = new TextView(this.fJR);
            this.fSI.setText(d.j.connection_tips);
            this.fSI.setGravity(17);
            this.fSI.setPadding(com.baidu.adp.lib.util.l.s(this.fJR, d.e.ds24), 0, com.baidu.adp.lib.util.l.s(this.fJR, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.s(this.fJR, d.e.ds60);
            if (this.fSI.getParent() == null) {
                frameLayout.addView(this.fSI, layoutParams);
            }
            this.fSH = new PopupWindow(this.fJR);
            this.fSH.setContentView(frameLayout);
            this.fSH.setHeight(-2);
            this.fSH.setWidth(-2);
            this.fSH.setFocusable(true);
            this.fSH.setOutsideTouchable(false);
            this.fSH.setBackgroundDrawable(new ColorDrawable(this.fJR.getResources().getColor(d.C0108d.transparent)));
            this.fQG.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        as.this.fSH.showAsDropDown(as.this.fRN, view.getLeft(), -as.this.fRN.getHeight());
                    } else {
                        as.this.fSH.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bez() != null && !StringUtils.isNull(aVar.bez().pkg_id) && !StringUtils.isNull(aVar.bez().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fRP != null && this.fRP.getVisibility() == 0) {
            if (this.fSG == null) {
                View inflate = LayoutInflater.from(this.fJR.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dDg);
                this.fSG = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fRP.getLocationInWindow(iArr);
            this.fSG.showAtLocation(this.fRP, 0, iArr[0] - com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fRP.getHeight()) - com.baidu.adp.lib.util.l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void beq() {
        com.baidu.adp.lib.g.g.b(this.fSG);
    }

    public void setIsInterviewLive(boolean z) {
        this.fSN = z;
    }

    public boolean getIsInterviewLive() {
        return this.fSN;
    }

    public void cB(View view) {
        this.fRE = view;
    }
}
