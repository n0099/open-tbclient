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
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
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
public class ar {
    private static final int fVk = UtilHelper.getLightStatusBarHeight();
    public static int fVq = 3;
    public static int fVr = 0;
    public static int fVs = 3;
    public static int fVt = 4;
    public static int fVu = 5;
    public static int fVv = 6;
    private com.baidu.tbadk.editortools.i axG;
    private com.baidu.tieba.pb.a.c bLG;
    private j.b bcF;
    private TextView bel;
    private TextView boy;
    private View bzi;
    private List<com.baidu.tieba.pb.pb.main.view.a> cZc;
    private View.OnClickListener dFR;
    private View dGe;
    private PbListView dII;
    private NavigationBarCoverTip dVQ;
    private View ddo;
    private NoNetworkView dpi;
    private RelativeLayout dpk;
    private View.OnClickListener fIH;
    PbActivity.d fLV;
    private PbActivity fMQ;
    private UserIconBox fNX;
    private UserIconBox fNY;
    private PbFakeFloorModel fOT;
    private com.baidu.tieba.pb.data.d fPY;
    private com.baidu.tieba.pb.video.h fTA;
    private com.baidu.tieba.d.c fTB;
    public final com.baidu.tieba.pb.pb.main.view.c fTE;
    public com.baidu.tieba.pb.pb.main.view.b fTF;
    private ViewStub fTG;
    private ViewStub fTH;
    private PbLandscapeListView fTI;
    private View fTJ;
    private LinearLayout fTM;
    private e fTN;
    private ColumnLayout fTO;
    private ThreadSkinView fTP;
    private TextView fTQ;
    private TextView fTR;
    private ImageView fTS;
    private HeadPendantView fTT;
    private FrameLayout fTU;
    private HeadImageView fTV;
    private View fTW;
    private FloatingLayout fTX;
    public int fTx;
    private com.baidu.tieba.pb.video.i fTy;
    private long fTz;
    private View fUP;
    private TextView fUQ;
    private ImageView fUR;
    private ImageView fUS;
    private TextView fUT;
    private boolean fUV;
    private int fUW;
    private int fUX;
    private PostData fUY;
    private PbFirstFloorUserLikeButton fUa;
    private ap fUb;
    private ap fUc;
    private TextView fUd;
    private TextView fUe;
    private TextView fUf;
    private View fUg;
    private View fUh;
    private LinearLayout fUi;
    private TextView fUj;
    private TextView fUk;
    private View fUl;
    private View fUm;
    private ObservedChangeLinearLayout fUo;
    private f fUp;
    private View fUv;
    private int fVF;
    private PbTopTipView fVH;
    private PopupWindow fVI;
    private PopupWindow fVJ;
    private TextView fVK;
    private List<String> fVL;
    private com.baidu.tieba.pb.pb.main.emotion.c fVM;
    private com.baidu.tieba.pb.pb.godreply.a fVN;
    private PbLandscapeListView.b fVO;
    private ab fVQ;
    private boolean fVS;
    private com.baidu.tbadk.core.view.userLike.c fVT;
    private com.baidu.tbadk.core.view.userLike.c fVU;
    private Runnable fVZ;
    private View fVa;
    private TextView fVb;
    private ViewStub fVc;
    private PbInterviewStatusView fVd;
    private ViewGroup fVe;
    private TextView fVf;
    private FrameLayout fVg;
    private View fVh;
    private View fVi;
    private ak fVj;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fVo;
    private int fVw;
    private Runnable fVx;
    private r fVy;
    private am fVz;
    private PbActivity.b fWb;
    private int flo;
    private boolean isLandscape;
    private int mType;
    private boolean fTC = false;
    private int fTD = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fTK = null;
    private TextView fTL = null;
    public FrsPraiseView fTY = null;
    private ClickableHeaderImageView fTZ = null;
    private View fUn = null;
    private com.baidu.tbadk.core.dialog.a fUq = null;
    private com.baidu.tbadk.core.dialog.b dFQ = null;
    private View fUr = null;
    private EditText fUs = null;
    private com.baidu.tieba.pb.view.h fUt = null;
    private com.baidu.tieba.pb.view.b fUu = null;
    private com.baidu.tbadk.core.dialog.a fUw = null;
    private b.InterfaceC0097b eGN = null;
    private TbRichTextView.h bLF = null;
    private NoNetworkView.a dCs = null;
    private Dialog fUx = null;
    private View fUy = null;
    private com.baidu.tbadk.core.dialog.a fUz = null;
    private Dialog fUA = null;
    private Dialog fUB = null;
    private View fUC = null;
    private LinearLayout fUD = null;
    private CompoundButton.OnCheckedChangeListener cZd = null;
    private TextView fUE = null;
    private TextView fUF = null;
    private View fUG = null;
    private String fUH = null;
    private com.baidu.tbadk.core.dialog.b fUI = null;
    private com.baidu.tbadk.core.dialog.b fUJ = null;
    private boolean fUK = false;
    private boolean fUL = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fUM = null;
    private boolean fUN = false;
    private Button fUO = null;
    private boolean fUU = true;
    private com.baidu.tbadk.core.view.b dgy = null;
    private boolean fID = false;
    private int mSkinType = 3;
    private boolean fUZ = false;
    private int fVl = 0;
    private boolean fVm = true;
    private a fVn = new a();
    private int fVp = 0;
    private boolean fVA = false;
    private int fVB = 0;
    private boolean fVC = false;
    private boolean fVD = false;
    private boolean fVE = false;
    private int fVG = 0;
    private boolean fVP = false;
    private a.InterfaceC0234a fVR = new a.InterfaceC0234a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
        }
    };
    private String fVV = null;
    private CustomMessageListener fVW = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.fVV = null;
            }
        }
    };
    private CustomMessageListener cdb = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fUp != null) {
                ar.this.fUp.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fVX = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fTL != null) {
                ar.this.fTL.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fVY = new Handler();
    private CustomMessageListener fWa = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fUU = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fWc = true;
    View.OnClickListener fWd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fVC) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").s("obj_id", 2));
            }
            if (view == ar.this.fTE.fYF) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").s("obj_locate", 2));
            }
            if (ar.this.fMQ.fKU.fXO != null) {
                if (!ar.this.fVC && ar.this.fPY != null && ar.this.fPY.bat() != null && ar.this.fPY.bat().zn() != null && ar.this.fPY.bat().zn().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").s("obj_locate", 1));
                }
                ar.this.fMQ.fKU.fXO.onClick(view);
            }
        }
    };
    private boolean fWe = false;
    String userId = null;
    private final List<TbImageView> fWf = new ArrayList();
    private boolean fWg = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fCE;
        public int fWu;
        public ak fWv;
    }

    public void kA(boolean z) {
        this.fVA = z;
        if (this.fTI != null) {
            this.fVB = this.fTI.getHeaderViewsCount();
        }
    }

    public void beF() {
        if (this.fTI != null) {
            int headerViewsCount = this.fTI.getHeaderViewsCount() - this.fVB;
            final int firstVisiblePosition = (this.fTI.getFirstVisiblePosition() == 0 || this.fTI.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fTI.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fTI.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fVn.fWv = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVn));
            final ak akVar = this.fVn.fWv;
            final int h = h(akVar);
            final int y = ((int) this.fUo.getY()) + this.fUo.getMeasuredHeight();
            final boolean z = this.fVh.getVisibility() == 0;
            boolean z2 = this.fUo.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.fUp.bcP() + this.fTI.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fSR.getMeasuredHeight() : 0;
                if (z2) {
                    this.fTI.setSelectionFromTop(this.fUp.bcP() + this.fTI.getHeaderViewsCount(), fVk - measuredHeight);
                } else {
                    this.fTI.setSelectionFromTop(this.fUp.bcP() + this.fTI.getHeaderViewsCount(), this.fTE.bgg().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fTI.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fVC) {
                this.fTI.setSelectionFromTop(this.fUp.bcP() + this.fTI.getHeaderViewsCount(), this.fTy.bhv().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fTI.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bdh() {
                        if (h >= 0 && h <= ar.this.dpk.getMeasuredHeight()) {
                            int h2 = ar.this.h(akVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.ddo.getLayoutParams();
                            if (i == 0 || i > ar.this.dpk.getMeasuredHeight() || h2 >= ar.this.dpk.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVw;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.dpk.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVw;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fTI.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.ddo.setLayoutParams(layoutParams);
                        }
                        ar.this.fTI.setOnLayoutListener(null);
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

    public NoNetworkView beG() {
        return this.dpi;
    }

    public void beH() {
        if (this.axG != null) {
            this.axG.hide();
            if (this.fVM != null) {
                this.fVM.Wj();
            }
        }
    }

    public PbFakeFloorModel beI() {
        return this.fOT;
    }

    public r beJ() {
        return this.fVy;
    }

    public void beK() {
        reset();
        beH();
        this.fVy.bcW();
        kM(false);
    }

    private void reset() {
        if (this.fMQ != null && this.fMQ.bbL() != null && this.axG != null) {
            com.baidu.tbadk.editortools.pb.a.Lx().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bbL = this.fMQ.bbL();
            bbL.LP();
            bbL.Ll();
            if (bbL.getWriteImagesInfo() != null) {
                bbL.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bbL.hO(SendView.ALL);
            bbL.hP(SendView.ALL);
            com.baidu.tbadk.editortools.l hG = this.axG.hG(23);
            com.baidu.tbadk.editortools.l hG2 = this.axG.hG(2);
            com.baidu.tbadk.editortools.l hG3 = this.axG.hG(5);
            if (hG2 != null) {
                hG2.th();
            }
            if (hG3 != null) {
                hG3.th();
            }
            if (hG != null) {
                hG.hide();
            }
            this.axG.invalidate();
        }
    }

    public boolean beL() {
        return this.fUU;
    }

    public void kB(boolean z) {
        if (this.fUP != null && this.fUQ != null) {
            this.fUQ.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fUP.startAnimation(alphaAnimation);
            }
            this.fUP.setVisibility(0);
            this.fUU = true;
            if (this.fVo != null && !this.fVN.isActive()) {
                this.fVo.setVisibility(0);
                kG(true);
            }
        }
    }

    public void kC(boolean z) {
        if (this.fUP != null && this.fUQ != null) {
            this.fUQ.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fUP.startAnimation(alphaAnimation);
            }
            this.fUP.setVisibility(0);
            this.fUU = true;
            if (this.fVo != null && !this.fVN.isActive()) {
                this.fVo.setVisibility(0);
                kG(true);
            }
        }
    }

    public PostData beM() {
        int i = 0;
        if (this.fTI == null) {
            return null;
        }
        int beN = beN() - this.fTI.getHeaderViewsCount();
        if (beN < 0) {
            beN = 0;
        }
        if (this.fUp.sM(beN) != null && this.fUp.sM(beN) != PostData.haA) {
            i = beN + 1;
        }
        return this.fUp.getItem(i) instanceof PostData ? (PostData) this.fUp.getItem(i) : null;
    }

    public int beN() {
        int i;
        View childAt;
        if (this.fTI == null) {
            return 0;
        }
        int firstVisiblePosition = this.fTI.getFirstVisiblePosition();
        int lastVisiblePosition = this.fTI.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fTI.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fTI.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int beO() {
        return this.fTI.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fPY != null && this.fPY.bav() != null && !this.fPY.bav().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fPY.bav().size() && (postData = this.fPY.bav().get(i)) != null && postData.zn() != null && !StringUtils.isNull(postData.zn().getUserId()); i++) {
                if (this.fPY.bav().get(i).zn().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fVN != null && this.fVN.isActive()) {
                        kM(false);
                    }
                    if (this.fVo != null) {
                        this.fVo.kS(true);
                    }
                    this.fVV = postData.zn().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fMQ = null;
        this.dpk = null;
        this.dGe = null;
        this.fTz = 0L;
        this.fTI = null;
        this.fTJ = null;
        this.fTM = null;
        this.fTO = null;
        this.fTQ = null;
        this.fTR = null;
        this.fTU = null;
        this.fTV = null;
        this.fTW = null;
        this.fUa = null;
        this.fUd = null;
        this.fUe = null;
        this.fUf = null;
        this.fUg = null;
        this.fUl = null;
        this.fUm = null;
        this.fUp = null;
        this.dII = null;
        this.bzi = null;
        this.dFR = null;
        this.fIH = null;
        this.fUP = null;
        this.fUQ = null;
        this.fUR = null;
        this.fUS = null;
        this.fUT = null;
        this.fVa = null;
        this.fVb = null;
        this.fVc = null;
        this.fVF = 0;
        this.fTz = System.currentTimeMillis();
        this.fMQ = pbActivity;
        this.dFR = onClickListener;
        this.bLG = cVar;
        this.fVF = com.baidu.adp.lib.util.l.ao(this.fMQ) / 2;
        this.dpk = (RelativeLayout) LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.fMQ.addContentView(this.dpk, new FrameLayout.LayoutParams(-1, -1));
        this.dVQ = (NavigationBarCoverTip) this.fMQ.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dGe = this.fMQ.findViewById(d.g.statebar_view);
        this.fUo = (ObservedChangeLinearLayout) this.fMQ.findViewById(d.g.title_wrapper);
        this.dpi = (NoNetworkView) this.fMQ.findViewById(d.g.view_no_network);
        this.fTI = (PbLandscapeListView) this.fMQ.findViewById(d.g.new_pb_list);
        this.fVg = (FrameLayout) this.fMQ.findViewById(d.g.root_float_header);
        this.boy = new TextView(this.fMQ.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds88));
        this.fTI.addHeaderView(this.boy, 0);
        this.fVw = this.fMQ.getResources().getDimensionPixelSize(d.e.tbds134);
        this.ddo = new View(this.fMQ.getPageContext().getPageActivity());
        this.ddo.setLayoutParams(new AbsListView.LayoutParams(-1, this.fVw));
        this.ddo.setVisibility(4);
        this.fTI.addFooterView(this.ddo);
        this.fTI.setOnTouchListener(this.fMQ.bDk);
        this.fTE = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.fMQ.bcm()) {
            this.fTG = (ViewStub) this.fMQ.findViewById(d.g.manga_view_stub);
            this.fTG.setVisibility(0);
            this.fTF = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.fTF.show();
            this.fTE.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds120);
        }
        this.boy.setLayoutParams(layoutParams);
        this.fTE.bgg().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0205a() { // from class: com.baidu.tieba.pb.pb.main.ar.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0205a
            public void bbl() {
                if (ar.this.fTI != null) {
                    if (ar.this.fTy != null) {
                        ar.this.fTy.bhw();
                    }
                    ar.this.fTI.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0205a
            public void bbm() {
                ar.this.fMQ.avi();
            }
        }));
        this.fUP = this.fMQ.findViewById(d.g.pb_editor_tool_comment);
        this.fUW = com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds90);
        this.fUX = com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds242);
        this.fUQ = (TextView) this.fMQ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fUS = (ImageView) this.fMQ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fUR = (ImageView) this.fMQ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fUT = (TextView) this.fMQ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fUT.setVisibility(8);
        this.fUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfP();
                if (!ar.this.fMQ.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, ar.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d bbL = ar.this.fMQ.bbL();
                if (bbL == null || (!bbL.LM() && !bbL.LN())) {
                    if (ar.this.axG != null) {
                        ar.this.beY();
                    }
                    if (ar.this.axG != null) {
                        ar.this.fUU = false;
                        if (ar.this.axG.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fMQ, (View) ar.this.axG.hI(2).bsj, false, ar.this.fVR);
                        }
                    }
                    ar.this.bfD();
                    return;
                }
                ar.this.fMQ.bbL().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fUR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfP();
                if (ar.this.fMQ.checkUpIsLogin()) {
                    if (ar.this.axG != null) {
                        ar.this.beY();
                        ar.this.axG.bh((View) ar.this.axG.hG(5));
                    }
                    if (ar.this.axG != null) {
                        ar.this.fUU = false;
                        if (ar.this.axG.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fMQ, (View) ar.this.axG.hI(2).bsj, false, ar.this.fVR);
                        }
                    }
                    ar.this.bfD();
                }
            }
        });
        this.fUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfP();
                if (ar.this.fMQ.checkUpIsLogin()) {
                    if (ar.this.axG != null) {
                        ar.this.beY();
                        ar.this.axG.bh((View) ar.this.axG.hG(2));
                    }
                    if (ar.this.axG != null) {
                        ar.this.fUU = false;
                        if (ar.this.axG.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fMQ, (View) ar.this.axG.hI(2).bsj, false, ar.this.fVR);
                        }
                    }
                    ar.this.bfD();
                }
            }
        });
        this.fUT.setOnClickListener(this.dFR);
        this.fUT.setOnTouchListener(this.fMQ);
        this.fTJ = LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fTM = (LinearLayout) LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.aj.s(this.fTM, d.C0141d.cp_bg_line_d);
        this.fTN = new e(this.fMQ, this.fTM);
        this.fTN.init();
        this.fTN.a(this.fTN.bbK(), this.dFR);
        this.fTO = (ColumnLayout) this.fTM.findViewById(d.g.pb_head_owner_root);
        this.fTP = (ThreadSkinView) this.fTM.findViewById(d.g.pb_thread_skin);
        this.fTO.setOnLongClickListener(this.onLongClickListener);
        this.fTO.setOnTouchListener(this.bLG);
        this.fTO.setVisibility(8);
        this.fTJ.setOnTouchListener(this.bLG);
        this.fVa = this.fTJ.findViewById(d.g.pb_head_activity_join_number_container);
        this.fVa.setVisibility(8);
        this.fVb = (TextView) this.fTJ.findViewById(d.g.pb_head_activity_join_number);
        this.fTQ = (TextView) this.fTO.findViewById(d.g.pb_head_owner_info_user_name);
        this.fTR = (TextView) this.fTO.findViewById(d.g.floor_owner);
        this.fTS = (ImageView) this.fTO.findViewById(d.g.icon_forum_level);
        this.fTU = (FrameLayout) this.fTO.findViewById(d.g.pb_head_headImage_container);
        this.fTV = (HeadImageView) this.fTO.findViewById(d.g.pb_head_owner_photo);
        this.fTT = (HeadPendantView) this.fTO.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fTT.DS();
        if (this.fTT.getHeadView() != null) {
            this.fTT.getHeadView().setIsRound(true);
            this.fTT.getHeadView().setDrawBorder(false);
        }
        this.fNX = (UserIconBox) this.fTO.findViewById(d.g.show_icon_vip);
        this.fNY = (UserIconBox) this.fTO.findViewById(d.g.show_icon_yinji);
        this.fTX = (FloatingLayout) this.fTM.findViewById(d.g.pb_head_owner_info_root);
        this.fUa = (PbFirstFloorUserLikeButton) this.fTO.findViewById(d.g.pb_like_button);
        this.fUd = (TextView) this.fTO.findViewById(d.g.pb_views);
        this.bel = (TextView) this.fTO.findViewById(d.g.view_forum_name);
        this.fUh = this.fTO.findViewById(d.g.line_right_forum_name);
        this.fUe = (TextView) this.fTO.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fUf = (TextView) this.fTO.findViewById(d.g.pb_item_first_floor_location_address);
        this.fUg = this.fTO.findViewById(d.g.line_between_time_and_locate);
        this.fVT = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fVU = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fUl = this.fTJ.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fUm = this.fTJ.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fTJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fVc = (ViewStub) this.dpk.findViewById(d.g.interview_status_stub);
        this.fUp = new f(this.fMQ, this.fTI);
        this.fUp.r(this.dFR);
        this.fUp.setTbGestureDetector(this.bLG);
        this.fUp.setOnImageClickListener(this.bLF);
        this.fIH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.akL() || !com.baidu.tieba.c.a.b(ar.this.fMQ.getBaseContext(), ar.this.fMQ.bbz().bdl(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                ar.this.fMQ.c(sparseArray);
                                return;
                            }
                            ar.this.cy(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        ar.this.fMQ.c(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fUp.E(this.fIH);
        beT();
        this.fTI.addHeaderView(this.fTK);
        this.fTI.addHeaderView(this.fTM);
        this.fTI.addHeaderView(this.fTJ);
        this.dII = new PbListView(this.fMQ.getPageContext().getPageActivity());
        this.bzi = this.dII.getView().findViewById(d.g.pb_more_view);
        if (this.bzi != null) {
            this.bzi.setOnClickListener(this.dFR);
            com.baidu.tbadk.core.util.aj.s(this.bzi, d.f.pb_foot_more_trans_selector);
        }
        this.dII.Eb();
        this.dII.gu(d.f.pb_foot_more_trans_selector);
        this.dII.gw(d.f.pb_foot_more_trans_selector);
        this.fUv = this.fMQ.findViewById(d.g.viewstub_progress);
        this.fMQ.registerListener(this.fWa);
        this.fTW = com.baidu.tbadk.ala.b.vL().u(this.fMQ.getActivity(), 2);
        if (this.fTW != null) {
            this.fTW.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fMQ.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fTW.getParent() == null) {
                this.fTX.addView(this.fTW, aVar);
            }
        }
        this.fOT = new PbFakeFloorModel(this.fMQ.getPageContext());
        this.fVy = new r(this.fMQ.getPageContext(), this.fOT, this.dpk);
        this.fVy.a(this.fMQ.fLR);
        this.fOT.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.fOT.m(postData);
                ar.this.fUp.notifyDataSetChanged();
                ar.this.fVy.bcW();
                ar.this.axG.Jl();
                ar.this.kM(false);
            }
        });
        if (this.fMQ.bbz() != null && !StringUtils.isNull(this.fMQ.bbz().bdQ())) {
            this.fMQ.showToast(this.fMQ.bbz().bdQ());
        }
        this.fVh = this.fMQ.findViewById(d.g.pb_expand_blank_view);
        this.fVi = this.fMQ.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fVi.getLayoutParams();
        if (this.fMQ.bbz() != null && this.fMQ.bbz().bdo()) {
            this.fVh.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fVi.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fVk;
            this.fVi.setLayoutParams(layoutParams2);
        }
        this.fVj = new ak(this.fMQ.getPageContext(), this.fMQ.findViewById(d.g.pb_reply_expand_view));
        this.fVj.fSR.setVisibility(8);
        this.fVj.G(this.dFR);
        this.fMQ.registerListener(this.cdb);
        this.fMQ.registerListener(this.fVW);
        this.fMQ.registerListener(this.fVX);
        beP();
        kG(false);
    }

    private void beP() {
        this.fVN = new com.baidu.tieba.pb.pb.godreply.a(this.fMQ, this, (ViewStub) this.dpk.findViewById(d.g.more_god_reply_popup));
        this.fVN.l(this.dFR);
        this.fVN.E(this.fIH);
        this.fVN.setOnImageClickListener(this.bLF);
        this.fVN.l(this.dFR);
        this.fVN.setTbGestureDetector(this.bLG);
    }

    public com.baidu.tieba.pb.pb.godreply.a beQ() {
        return this.fVN;
    }

    public View beR() {
        return this.fVh;
    }

    public void beS() {
        if (this.fTI != null) {
            this.fTI.removeHeaderView(this.fTK);
            this.fTI.removeHeaderView(this.fTM);
            this.fTI.removeHeaderView(this.fTJ);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fVo == null) {
            this.fVo = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.fMQ.getPageContext().getPageActivity());
            kG(true);
            this.fVo.a(this.dpk, aVar, this.fUP.getVisibility() == 0);
            this.fVo.setOnEmotionClickListener(new a.InterfaceC0211a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0211a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(ar.this.fVV)) {
                        emotionImageData.setAuthorNameShow(ar.this.fVV);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0211a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fMQ.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fMQ.getPageContext().getPageActivity(), 25016, str, list, ar.this.fVV, list2)));
                }
            });
            this.fVo.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    ar.this.bfP();
                    if (ar.this.fUP != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fUP.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fUX - ar.this.fUW) * f) + ar.this.fUW);
                        ar.this.fUQ.setAlpha(1.0f - f);
                        ar.this.fUS.setAlpha(1.0f - f);
                        ar.this.fUR.setAlpha(1.0f - f);
                        ar.this.fUP.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void beT() {
        if (this.fTK == null) {
            int t = com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.tbds44);
            this.fTK = new LinearLayout(this.fMQ.getPageContext().getPageActivity());
            this.fTK.setOrientation(1);
            this.fTK.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fTK.setPadding(t, com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.tbds30), t, com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.tbds40));
            this.fTK.setGravity(17);
            this.fTL = new TextView(this.fMQ.getPageContext().getPageActivity());
            this.fTL.setGravity(3);
            this.fTL.setMaxLines(2);
            this.fTL.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_link_tip_c));
            this.fTL.setPadding(0, 0, 0, 0);
            this.fTL.setLineSpacing(com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.r(this.fTL, d.C0141d.cp_cont_b);
            this.fTL.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fTL.setVisibility(8);
            if (this.fTL.getParent() == null) {
                this.fTK.addView(this.fTL);
            }
            this.fTK.setOnTouchListener(this.bLG);
            this.fTK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beU() {
        if (this.fMQ.bcm()) {
            this.fTH = (ViewStub) this.fMQ.findViewById(d.g.manga_mention_controller_view_stub);
            this.fTH.setVisibility(0);
            if (this.fUi == null) {
                this.fUi = (LinearLayout) this.fMQ.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fMQ.getPageContext(), this.fUi);
            }
            if (this.fUj == null) {
                this.fUj = (TextView) this.fUi.findViewById(d.g.manga_prev_btn);
            }
            if (this.fUk == null) {
                this.fUk = (TextView) this.fUi.findViewById(d.g.manga_next_btn);
            }
            this.fUj.setOnClickListener(this.dFR);
            this.fUk.setOnClickListener(this.dFR);
        }
    }

    private void beV() {
        if (this.fMQ.bcm()) {
            if (this.fMQ.bcp() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fUj, d.C0141d.cp_cont_e, 1);
            }
            if (this.fMQ.bcq() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fUk, d.C0141d.cp_cont_e, 1);
            }
        }
    }

    public void beW() {
        if (this.fUi == null) {
            beU();
        }
        this.fTH.setVisibility(8);
        if (this.fVY != null && this.fVZ != null) {
            this.fVY.removeCallbacks(this.fVZ);
        }
    }

    public void beX() {
        if (this.fVY != null) {
            if (this.fVZ != null) {
                this.fVY.removeCallbacks(this.fVZ);
            }
            this.fVZ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fUi == null) {
                        ar.this.beU();
                    }
                    ar.this.fTH.setVisibility(0);
                }
            };
            this.fVY.postDelayed(this.fVZ, 2000L);
        }
    }

    public void kD(boolean z) {
        this.fTE.kD(z);
        if (z && this.fUZ) {
            this.dII.setText(this.fMQ.getResources().getString(d.j.click_load_more));
            this.fTI.setNextPage(this.dII);
            this.fTD = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axG = iVar;
        this.axG.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.axG.getParent() == null) {
            this.dpk.addView(this.axG, layoutParams);
        }
        this.axG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        beH();
        this.fMQ.bbL().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.axG != null && ar.this.axG.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fVM == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.axG.getId());
                            ar.this.fVM = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fMQ.getPageContext(), ar.this.dpk, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.E(ar.this.fVL)) {
                                ar.this.fVM.setData(ar.this.fVL);
                            }
                            ar.this.fVM.b(ar.this.axG);
                        }
                        ar.this.fVM.qD(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fMQ.fKY != null && ar.this.fMQ.fKY.bfS() != null) {
                    if (!ar.this.fMQ.fKY.bfS().bFE()) {
                        ar.this.fMQ.fKY.kP(false);
                    }
                    ar.this.fMQ.fKY.bfS().nB(false);
                }
            }
        });
    }

    public void beY() {
        if (this.fMQ != null && this.axG != null) {
            this.axG.th();
            bfD();
        }
    }

    public void Q(String str, boolean z) {
        this.fUV = z;
        kE(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kE(boolean z) {
        if (this.fUT != null) {
            if (this.fUV) {
                com.baidu.tbadk.core.util.aj.s(this.fUT, d.f.pb_praise_already_click_selector);
                this.fUT.setContentDescription(this.fMQ.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.s(this.fUT, d.f.pb_praise_normal_click_selector);
            this.fUT.setContentDescription(this.fMQ.getResources().getString(d.j.zan));
        }
    }

    public TextView beZ() {
        return this.fUT;
    }

    public void kF(boolean z) {
        if (this.fTI != null && this.boy != null && this.dGe != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dGe.setVisibility(0);
                } else {
                    this.dGe.setVisibility(8);
                    this.fTI.removeHeaderView(this.boy);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.boy.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fVk;
                    this.boy.setLayoutParams(layoutParams);
                }
                bfo();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.boy.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kN(true);
                this.boy.setLayoutParams(layoutParams2);
            }
            bfo();
            bfL();
        }
    }

    public f bfa() {
        return this.fUp;
    }

    public void a(PbActivity.d dVar) {
        this.fLV = dVar;
    }

    public void cy(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fUy == null) {
            this.fUy = LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fMQ.getLayoutMode().aM(this.fUy);
        if (this.fUx == null) {
            this.fUx = new Dialog(this.fMQ.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUx.setCanceledOnTouchOutside(true);
            this.fUx.setCancelable(true);
            this.fUx.setContentView(this.fUy);
            WindowManager.LayoutParams attributes = this.fUx.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ao(this.fMQ.getPageContext().getPageActivity()) * 0.9d);
            this.fUx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUx.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fUx.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUx.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fUx != null && (ar.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUx, ar.this.fMQ.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || bfK()) {
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fUx != null && (ar.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUx, ar.this.fMQ.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fWb != null) {
                        ar.this.fWb.ak(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fUx != null && (ar.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUx, ar.this.fMQ.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fMQ.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fUx, this.fMQ.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fWb = bVar;
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
        sparseArray.put(fVr, Integer.valueOf(fVs));
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
        this.fUz = new com.baidu.tbadk.core.dialog.a(this.fMQ.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fUz.fb(i3);
        } else {
            this.fUz.be(false);
            this.fUz.dk(str2);
        }
        this.fUz.aE(sparseArray);
        this.fUz.a(d.j.dialog_ok, this.fMQ);
        this.fUz.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUz.aZ(true);
        this.fUz.b(this.fMQ.getPageContext());
        this.fUz.AU();
    }

    public void an(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fUC == null) {
            this.fUC = LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.fMQ.getLayoutMode().aM(this.fUC);
        if (this.fUB == null) {
            this.fUB = new Dialog(this.fMQ.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUB.setCanceledOnTouchOutside(true);
            this.fUB.setCancelable(true);
            this.fUM = (ScrollView) this.fUC.findViewById(d.g.good_scroll);
            this.fUB.setContentView(this.fUC);
            WindowManager.LayoutParams attributes = this.fUB.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds540);
            this.fUB.getWindow().setAttributes(attributes);
            this.cZd = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fUH = (String) compoundButton.getTag();
                        if (ar.this.cZc != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : ar.this.cZc) {
                                String str = (String) aVar.getTag();
                                if (str != null && ar.this.fUH != null && !str.equals(ar.this.fUH)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fUD = (LinearLayout) this.fUC.findViewById(d.g.good_class_group);
            this.fUF = (TextView) this.fUC.findViewById(d.g.dialog_button_cancel);
            this.fUF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fUB instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUB, ar.this.fMQ.getPageContext());
                    }
                }
            });
            this.fUE = (TextView) this.fUC.findViewById(d.g.dialog_button_ok);
            this.fUE.setOnClickListener(this.dFR);
        }
        this.fUD.removeAllViews();
        this.cZc = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bI = bI("0", this.fMQ.getPageContext().getString(d.j.def_good_class));
        this.cZc.add(bI);
        bI.setChecked(true);
        this.fUD.addView(bI);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.ye()) && aaVar.yf() > 0) {
                    com.baidu.tieba.pb.pb.main.view.a bI2 = bI(String.valueOf(aaVar.yf()), aaVar.ye());
                    this.cZc.add(bI2);
                    View view = new View(this.fMQ.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.aj.t(view, d.C0141d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fUD.addView(view);
                    this.fUD.addView(bI2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fUM.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fMQ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fMQ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fMQ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fUM.setLayoutParams(layoutParams2);
            this.fUM.removeAllViews();
            if (this.fUD != null && this.fUD.getParent() == null) {
                this.fUM.addView(this.fUD);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fUB, this.fMQ.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bI(String str, String str2) {
        Activity pageActivity = this.fMQ.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.t(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cZd);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void bfb() {
        this.fMQ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fMQ.hideProgressBar();
        if (z && z2) {
            this.fMQ.showToast(this.fMQ.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.fMQ.showToast(str);
        }
    }

    public void aKh() {
        this.fUv.setVisibility(0);
    }

    public void aKg() {
        this.fUv.setVisibility(8);
    }

    public View bfc() {
        if (this.fUC != null) {
            return this.fUC.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bfd() {
        return this.fUH;
    }

    public View getView() {
        return this.dpk;
    }

    public void bfe() {
        com.baidu.adp.lib.util.l.a(this.fMQ.getPageContext().getPageActivity(), this.fMQ.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fMQ.hideProgressBar();
        if (z) {
            bfu();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bfv();
        } else {
            bfu();
        }
    }

    public void bff() {
        this.dII.Eb();
        this.dII.Ef();
    }

    public void bfg() {
        this.fMQ.hideProgressBar();
        Eg();
        this.fTI.completePullRefreshPostDelayed(2000L);
        bfr();
    }

    public void bfh() {
        this.fTI.completePullRefreshPostDelayed(2000L);
        bfr();
    }

    private void kG(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fUQ.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fMQ.getResources().getDimensionPixelSize(d.e.ds130) : this.fMQ.getResources().getDimensionPixelSize(d.e.ds34);
        this.fUQ.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fUp.setOnLongClickListener(onLongClickListener);
        if (this.fVN != null) {
            this.fVN.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0097b interfaceC0097b, boolean z, boolean z2) {
        if (this.fUI != null) {
            this.fUI.dismiss();
            this.fUI = null;
        }
        this.fUI = new com.baidu.tbadk.core.dialog.b(this.fMQ.getPageContext().getPageActivity());
        this.fUI.fe(d.j.operation);
        if (z2) {
            this.fUI.a(new String[]{this.fMQ.getPageContext().getString(d.j.copy)}, interfaceC0097b);
        } else if (!z) {
            this.fUI.a(new String[]{this.fMQ.getPageContext().getString(d.j.copy), this.fMQ.getPageContext().getString(d.j.mark)}, interfaceC0097b);
        } else {
            this.fUI.a(new String[]{this.fMQ.getPageContext().getString(d.j.copy), this.fMQ.getPageContext().getString(d.j.remove_mark)}, interfaceC0097b);
        }
        this.fUI.d(this.fMQ.getPageContext());
        this.fUI.AX();
    }

    public void a(b.InterfaceC0097b interfaceC0097b, boolean z) {
        if (this.fUJ != null) {
            this.fUJ.dismiss();
            this.fUJ = null;
        }
        this.fUJ = new com.baidu.tbadk.core.dialog.b(this.fMQ.getPageContext().getPageActivity());
        this.fUJ.fe(d.j.operation);
        if (z) {
            this.fUJ.a(new String[]{this.fMQ.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0097b);
        } else {
            this.fUJ.a(new String[]{this.fMQ.getPageContext().getString(d.j.save_to_emotion), this.fMQ.getPageContext().getString(d.j.save_to_local)}, interfaceC0097b);
        }
        this.fUJ.d(this.fMQ.getPageContext());
        this.fUJ.AX();
    }

    public int bfi() {
        return tc(this.fTI.getFirstVisiblePosition());
    }

    private int tc(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fTI.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fTI.getAdapter() == null || !(this.fTI.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fTI.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bfj() {
        int lastVisiblePosition = this.fTI.getLastVisiblePosition();
        if (this.fTy != null) {
            if (lastVisiblePosition == this.fTI.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return tc(lastVisiblePosition);
    }

    public void td(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fTI != null) {
            if (this.fTE == null || this.fTE.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fTE.mNavigationBar.getFixedNavHeight();
                if (this.fMQ.bca() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fVi != null && (layoutParams = (LinearLayout.LayoutParams) this.fVi.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fVi.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fTI.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fTI.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fUs.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fUp.a(dVar, false);
        this.fUp.notifyDataSetChanged();
        bfr();
        if (this.fVN != null) {
            this.fVN.bbv();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fTY == null) {
            this.fMQ.getLayoutMode().aM(((ViewStub) this.fTJ.findViewById(d.g.praise_layout)).inflate());
            this.fTY = (FrsPraiseView) this.fTJ.findViewById(d.g.pb_head_praise_view);
            this.fTY.setIsFromPb(true);
            this.fUn = this.fTJ.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fTY.gB(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fTY != null) {
            boolean bfr = bfr();
            this.fTY.setVisibility(8);
            if (dVar != null && dVar.yA() != null && dVar.yA().yx() == 0 && this.fID) {
                if (bfr) {
                    this.fUm.setVisibility(0);
                    return;
                } else {
                    this.fUm.setVisibility(8);
                    return;
                }
            }
            this.fUm.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.baD() != null) {
            return dVar.baD();
        }
        if (!com.baidu.tbadk.core.util.v.E(dVar.bav())) {
            Iterator<PostData> it = dVar.bav().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bwT() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.baA();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.zn() != null && postData.zn().getUserTbVipInfoData() != null && postData.zn().getUserTbVipInfoData().getvipIntro() != null) {
            postData.zn().getGodUserData().setIntro(postData.zn().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bat() == null || dVar.bat().zn() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zn = dVar.bat().zn();
        String userId = zn.getUserId();
        HashMap<String, MetaData> userMap = dVar.bat().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zn;
        }
        postData.vM(1);
        postData.setId(dVar.bat().zE());
        postData.setTitle(dVar.bat().getTitle());
        postData.setTime(dVar.bat().getCreateTime());
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
        int t;
        com.baidu.tbadk.data.f bwX;
        String portrait;
        if (dVar != null && dVar.bat() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fTO.setVisibility(8);
            if (dVar.bat() != null && dVar.bat().Aa() && dVar.bat().zF() != null) {
                this.fVC = true;
                this.fTE.lb(this.fVC);
                this.fTE.mNavigationBar.hideBottomLine();
                if (this.fTy == null) {
                    this.fTy = new com.baidu.tieba.pb.video.i(this.fMQ, this.fTE, dVar.bat().zF(), this.fTz);
                    this.fTy.a(dVar.bat().zF(), dVar.bat(), dVar.getForumId());
                    this.fTy.startPlay();
                } else if (this.fTC) {
                    this.fTy.a(dVar.bat().zF(), dVar.bat(), dVar.getForumId());
                    this.fTy.startPlay();
                } else {
                    this.fTy.qN(dVar.getForumId());
                }
                if (dVar.bau() != null && dVar.bau().size() >= 1) {
                    bd bdVar = dVar.bau().get(0);
                    this.fTy.ah(bdVar);
                    this.fTy.qO(bdVar.getTitle());
                }
                this.fTy.b(b, dVar.bat(), dVar.baP());
                this.fTC = false;
                this.fTI.removeHeaderView(this.fTy.bhx());
                this.fTI.addHeaderView(this.fTy.bhx(), 0);
                if (this.fTy.bhv() != null && this.fTy.bhv().getParent() == null) {
                    this.fVg.addView(this.fTy.bhv());
                }
                if (this.fTA == null) {
                    this.fTA = new com.baidu.tieba.pb.video.h(this.fMQ);
                }
                this.fTA.a(dVar.bat().Ao(), dVar.bat(), dVar.baM());
                this.fTI.removeHeaderView(this.fTA.bhm());
                this.fTI.addHeaderView(this.fTA.bhm(), 1);
                if (dVar.bat().Ao() != null) {
                    this.fTI.removeHeaderView(this.fTA.bhn());
                    this.fTI.removeHeaderView(this.fTM);
                    this.fTI.addHeaderView(this.fTA.bhn(), 2);
                } else {
                    if (this.fTA.bhn() != null) {
                        this.fTI.removeHeaderView(this.fTA.bhn());
                    }
                    this.fTI.removeHeaderView(this.fTM);
                    this.fTM.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.t(this.fMQ, d.e.tbds56));
                    this.fTI.addHeaderView(this.fTM, 2);
                }
                if (this.fTy != null) {
                    this.fTE.kV(false);
                    this.fTE.kX(TbadkCoreApplication.isLogin());
                    this.fTy.tk(TbadkCoreApplication.getInst().getSkinType());
                }
                bfo();
            } else {
                this.fVC = false;
                this.fTE.lb(this.fVC);
                if (this.fTy != null) {
                    this.fTI.removeHeaderView(this.fTy.bhx());
                }
                if (this.fTA != null) {
                    this.fTA.b(this.fTI);
                }
                if (b == null || (b != null && (b.bwW() == null || com.baidu.tbadk.core.util.v.E(b.bwW().Rh())))) {
                    this.fTM.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.t(this.fMQ, d.e.tbds80));
                } else {
                    this.fTM.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fMQ.bbP() != null) {
                this.fMQ.bbP().kT(this.fVC);
            }
            if (this.fTy != null) {
                this.fTy.I(this.fWd);
            }
            if (b != null) {
                this.fUY = b;
                this.fTO.setVisibility(0);
                if (this.fMQ.bcz()) {
                    if (dVar.bas() != null) {
                        this.mForumName = dVar.bas().getForumName();
                        this.mForumId = dVar.bas().getForumId();
                    }
                    if (this.mForumName == null && this.fMQ.bbz() != null && this.fMQ.bbz().bdk() != null) {
                        this.mForumName = this.fMQ.bbz().bdk();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fTO.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fTO.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fVS) {
                    this.fTK.setVisibility(0);
                }
                if (!dVar.bat().Aa() && this.fTL.getText() != null && this.fTL.getText().length() > 0) {
                    this.fTL.setVisibility(0);
                } else {
                    this.fTL.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> zz = dVar.bat().zz();
                if (zz != null && zz.size() > 0 && !this.fVS) {
                    this.fVb.setText(String.valueOf(zz.get(0).xH()));
                    this.fVa.setVisibility(0);
                } else {
                    this.fVa.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.s(this.fVa, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.e(this.fVb, d.C0141d.cp_link_tip_d, 1);
                if (b.zn() != null) {
                    String string = b.zn().getName_show() == null ? StringUtils.string(b.zn().getUserName()) : StringUtils.string(b.zn().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.zn().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.aX(b.zn().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aX(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.zn().getIconInfo();
                            tShowInfoNew = b.zn().getTShowInfoNew();
                            if (this.fNY != null) {
                                this.fNY.setTag(d.g.tag_user_id, b.zn().getUserId());
                                this.fNY.setOnClickListener(this.fMQ.fKU.fXP);
                                this.fNY.a(iconInfo, 4, this.fMQ.getResources().getDimensionPixelSize(d.e.tbds36), this.fMQ.getResources().getDimensionPixelSize(d.e.tbds36), this.fMQ.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fNX != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fNX.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fNX.setOnClickListener(this.fMQ.fKU.fXQ);
                                this.fNX.a(tShowInfoNew, 3, this.fMQ.getResources().getDimensionPixelSize(d.e.tbds36), this.fMQ.getResources().getDimensionPixelSize(d.e.tbds36), this.fMQ.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fTQ.setText(af(b.zn().getSealPrefix(), e));
                            this.fTQ.setTag(d.g.tag_user_id, b.zn().getUserId());
                            this.fTQ.setTag(d.g.tag_user_name, b.zn().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew) || b.zn().isBigV()) {
                                com.baidu.tbadk.core.util.aj.e(this.fTQ, d.C0141d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.e(this.fTQ, d.C0141d.cp_cont_f, 1);
                            }
                            this.fTR.setVisibility(8);
                            if (dVar.bat().zn() != null && dVar.bat().zn().getAlaUserData() != null && this.fTW != null) {
                                if (dVar.bat().zn().getAlaUserData().anchor_live != 0) {
                                    this.fTW.setVisibility(8);
                                } else {
                                    this.fTW.setVisibility(0);
                                    if (this.fTB == null) {
                                        this.fTB = new com.baidu.tieba.d.c(this.fMQ.getPageContext(), this.fTW);
                                        this.fTB.lU(1);
                                    }
                                    this.fTB.aK(this.fMQ.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aGT = dVar.bat().zn().getAlaUserData();
                                    aVar.type = 2;
                                    this.fTW.setTag(aVar);
                                }
                            }
                            this.fTV.setUserId(b.zn().getUserId());
                            this.fTV.setUserName(b.zn().getUserName());
                            this.fTV.setImageDrawable(null);
                            this.fTV.setRadius(com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds40));
                            this.fTV.setTag(b.zn().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fUe.setText(com.baidu.tbadk.core.util.am.A(b.getTime()));
                            } else {
                                this.fUe.setText(com.baidu.tbadk.core.util.am.z(b.getTime()));
                            }
                            t = com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds16);
                            if (!this.fMQ.bcz() && !StringUtils.isNull(this.mForumName)) {
                                this.bel.setText(this.fMQ.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.bel.setVisibility(0);
                                this.fUh.setVisibility(0);
                                this.fUe.setPadding(t, 0, t, 0);
                            } else {
                                this.bel.setVisibility(8);
                                this.fUh.setVisibility(8);
                                this.fUe.setPadding(0, 0, t, 0);
                            }
                            bwX = b.bwX();
                            if (bwX == null && !TextUtils.isEmpty(bwX.getName()) && !TextUtils.isEmpty(bwX.getName().trim())) {
                                final String name = bwX.getName();
                                final String lat = bwX.getLat();
                                final String lng = bwX.getLng();
                                this.fUf.setVisibility(0);
                                this.fUg.setVisibility(0);
                                this.fUf.setText(bwX.getName());
                                this.fUf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.oJ()) {
                                                ar.this.fMQ.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.b.R(ar.this.fMQ.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, ar.this.fMQ.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fUf.setVisibility(8);
                                this.fUg.setVisibility(8);
                            }
                            portrait = b.zn().getPortrait();
                            if (b.zn().getPendantData() == null && !StringUtils.isNull(b.zn().getPendantData().ya())) {
                                UtilHelper.showHeadImageViewBigV(this.fTT.getHeadView(), b.zn());
                                this.fTV.setVisibility(8);
                                this.fTT.setVisibility(0);
                                if (this.fTZ != null) {
                                    this.fTZ.setVisibility(8);
                                }
                                this.fTQ.setOnClickListener(this.fWd);
                                this.fTT.getHeadView().startLoad(portrait, 28, false);
                                this.fTT.getHeadView().setUserId(b.zn().getUserId());
                                this.fTT.getHeadView().setUserName(b.zn().getUserName());
                                this.fTT.getHeadView().setOnClickListener(this.fWd);
                                this.fTT.eS(b.zn().getPendantData().ya());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fTV, b.zn());
                                this.fTV.setVisibility(0);
                                this.fTO.setOnClickListener(this.fWd);
                                this.fTQ.setOnClickListener(this.fWd);
                                this.fTV.setOnClickListener(this.fWd);
                                this.fTT.setVisibility(8);
                                this.fTV.startLoad(portrait, 28, false);
                            }
                            String name_show = b.zn().getName_show();
                            String userName = b.zn().getUserName();
                            if (com.baidu.tbadk.o.af.nv() && name_show != null && !name_show.equals(userName)) {
                                this.fTQ.setText(com.baidu.tieba.pb.c.am(this.fMQ.getPageContext().getPageActivity(), this.fTQ.getText().toString()));
                                this.fTQ.setGravity(16);
                                this.fTQ.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.baa());
                                com.baidu.tbadk.core.util.aj.e(this.fTQ, d.C0141d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.zn().getIconInfo();
                        tShowInfoNew = b.zn().getTShowInfoNew();
                        if (this.fNY != null) {
                        }
                        if (this.fNX != null) {
                        }
                        this.fTQ.setText(af(b.zn().getSealPrefix(), e));
                        this.fTQ.setTag(d.g.tag_user_id, b.zn().getUserId());
                        this.fTQ.setTag(d.g.tag_user_name, b.zn().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fTQ, d.C0141d.cp_cont_h, 1);
                        this.fTR.setVisibility(8);
                        if (dVar.bat().zn() != null) {
                            if (dVar.bat().zn().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fTV.setUserId(b.zn().getUserId());
                        this.fTV.setUserName(b.zn().getUserName());
                        this.fTV.setImageDrawable(null);
                        this.fTV.setRadius(com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds40));
                        this.fTV.setTag(b.zn().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        t = com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds16);
                        if (!this.fMQ.bcz()) {
                        }
                        this.bel.setVisibility(8);
                        this.fUh.setVisibility(8);
                        this.fUe.setPadding(0, 0, t, 0);
                        bwX = b.bwX();
                        if (bwX == null) {
                        }
                        this.fUf.setVisibility(8);
                        this.fUg.setVisibility(8);
                        portrait = b.zn().getPortrait();
                        if (b.zn().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fTV, b.zn());
                        this.fTV.setVisibility(0);
                        this.fTO.setOnClickListener(this.fWd);
                        this.fTQ.setOnClickListener(this.fWd);
                        this.fTV.setOnClickListener(this.fWd);
                        this.fTT.setVisibility(8);
                        this.fTV.startLoad(portrait, 28, false);
                        String name_show2 = b.zn().getName_show();
                        String userName2 = b.zn().getUserName();
                        if (com.baidu.tbadk.o.af.nv()) {
                            this.fTQ.setText(com.baidu.tieba.pb.c.am(this.fMQ.getPageContext().getPageActivity(), this.fTQ.getText().toString()));
                            this.fTQ.setGravity(16);
                            this.fTQ.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.baa());
                            com.baidu.tbadk.core.util.aj.e(this.fTQ, d.C0141d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aX(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.zn().getIconInfo();
                            tShowInfoNew = b.zn().getTShowInfoNew();
                            if (this.fNY != null) {
                            }
                            if (this.fNX != null) {
                            }
                            this.fTQ.setText(af(b.zn().getSealPrefix(), e));
                            this.fTQ.setTag(d.g.tag_user_id, b.zn().getUserId());
                            this.fTQ.setTag(d.g.tag_user_name, b.zn().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.e(this.fTQ, d.C0141d.cp_cont_h, 1);
                            this.fTR.setVisibility(8);
                            if (dVar.bat().zn() != null) {
                            }
                            this.fTV.setUserId(b.zn().getUserId());
                            this.fTV.setUserName(b.zn().getUserName());
                            this.fTV.setImageDrawable(null);
                            this.fTV.setRadius(com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds40));
                            this.fTV.setTag(b.zn().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            t = com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds16);
                            if (!this.fMQ.bcz()) {
                            }
                            this.bel.setVisibility(8);
                            this.fUh.setVisibility(8);
                            this.fUe.setPadding(0, 0, t, 0);
                            bwX = b.bwX();
                            if (bwX == null) {
                            }
                            this.fUf.setVisibility(8);
                            this.fUg.setVisibility(8);
                            portrait = b.zn().getPortrait();
                            if (b.zn().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fTV, b.zn());
                            this.fTV.setVisibility(0);
                            this.fTO.setOnClickListener(this.fWd);
                            this.fTQ.setOnClickListener(this.fWd);
                            this.fTV.setOnClickListener(this.fWd);
                            this.fTT.setVisibility(8);
                            this.fTV.startLoad(portrait, 28, false);
                            String name_show22 = b.zn().getName_show();
                            String userName22 = b.zn().getUserName();
                            if (com.baidu.tbadk.o.af.nv()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.zn().getIconInfo();
                        tShowInfoNew = b.zn().getTShowInfoNew();
                        if (this.fNY != null) {
                        }
                        if (this.fNX != null) {
                        }
                        this.fTQ.setText(af(b.zn().getSealPrefix(), e));
                        this.fTQ.setTag(d.g.tag_user_id, b.zn().getUserId());
                        this.fTQ.setTag(d.g.tag_user_name, b.zn().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fTQ, d.C0141d.cp_cont_h, 1);
                        this.fTR.setVisibility(8);
                        if (dVar.bat().zn() != null) {
                        }
                        this.fTV.setUserId(b.zn().getUserId());
                        this.fTV.setUserName(b.zn().getUserName());
                        this.fTV.setImageDrawable(null);
                        this.fTV.setRadius(com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds40));
                        this.fTV.setTag(b.zn().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        t = com.baidu.adp.lib.util.l.t(this.fMQ.getActivity(), d.e.ds16);
                        if (!this.fMQ.bcz()) {
                        }
                        this.bel.setVisibility(8);
                        this.fUh.setVisibility(8);
                        this.fUe.setPadding(0, 0, t, 0);
                        bwX = b.bwX();
                        if (bwX == null) {
                        }
                        this.fUf.setVisibility(8);
                        this.fUg.setVisibility(8);
                        portrait = b.zn().getPortrait();
                        if (b.zn().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fTV, b.zn());
                        this.fTV.setVisibility(0);
                        this.fTO.setOnClickListener(this.fWd);
                        this.fTQ.setOnClickListener(this.fWd);
                        this.fTV.setOnClickListener(this.fWd);
                        this.fTT.setVisibility(8);
                        this.fTV.startLoad(portrait, 28, false);
                        String name_show222 = b.zn().getName_show();
                        String userName222 = b.zn().getUserName();
                        if (com.baidu.tbadk.o.af.nv()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fTN.Z(dVar.bat());
                }
                if (this.fVj != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHH);
                    if (dVar != null && dVar.bat() != null) {
                        hVar.fHJ = dVar.bat().zf();
                    }
                    hVar.isNew = !this.fID;
                    hVar.fHL = this.fMQ.bcy();
                    this.fVj.a(hVar);
                }
            }
        }
    }

    public void kH(boolean z) {
        if (z) {
            bfk();
        } else {
            bfl();
        }
        this.fVn.fWv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVn));
        a(this.fVn.fWv, false);
    }

    public void bfk() {
        if (this.fTE != null && !this.fVE) {
            this.fTE.lc(!StringUtils.isNull(this.fMQ.bbX()));
            this.fVE = true;
        }
    }

    public void bfl() {
        if (this.fTE != null) {
            this.fTE.bgn();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.zJ() != null) {
            this.fTP.a(this.fMQ.getPageContext(), dVar.bav().get(0).zJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.bar().getId(), dVar.bar().getName(), dVar.bat().getId(), this.fMQ.bcv() ? "FRS" : null));
            this.fTO.setPadding(this.fTO.getPaddingLeft(), (int) this.fMQ.getResources().getDimension(d.e.ds20), this.fTO.getPaddingRight(), this.fTO.getPaddingBottom());
            return;
        }
        this.fTP.a(null, null, null);
    }

    public void bfm() {
        if (this.fTy != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").s("obj_type", 1));
            this.fTy.bhw();
            this.fTI.smoothScrollToPosition(0);
        }
    }

    public boolean bfn() {
        return this.fWe;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean ab(bd bdVar) {
        if (bdVar == null || bdVar.zn() == null || bdVar.zn().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.zn().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fTE.bgl();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fTE.ol(cVar.forumName);
            }
            String string = this.fMQ.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.h(cVar.source, 0)) {
                case 100:
                    str = this.fMQ.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.fMQ.getResources().getString(d.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fMQ.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fGS;
            this.fMQ.showNetRefreshView(this.dpk, format, null, this.fMQ.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.pa()) {
                        com.baidu.tbadk.core.util.aw.Dt().c(ar.this.fMQ.getPageContext(), new String[]{str2});
                        ar.this.fMQ.finish();
                        return;
                    }
                    ar.this.fMQ.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable beu;
        Parcelable beu2;
        String str;
        if (dVar != null) {
            this.fPY = dVar;
            this.mType = i;
            if (dVar.bat() != null) {
                this.fVp = dVar.bat().yY();
                if (dVar.bat().getAnchorLevel() != 0) {
                    this.fWe = true;
                }
                this.fUL = ab(dVar.bat());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fUZ = false;
            this.fID = z;
            bfg();
            b(dVar, z, i);
            p(dVar);
            if (this.fVQ == null) {
                this.fVQ = new ab(this.fMQ.getPageContext(), this.dVQ);
            }
            this.fVQ.qv(dVar.bay());
            if (this.fMQ.bcm()) {
                if (this.fUt == null) {
                    this.fUt = new com.baidu.tieba.pb.view.h(this.fMQ.getPageContext());
                    this.fUt.st();
                    this.fUt.a(this.bcF);
                }
                this.fTI.setPullRefresh(this.fUt);
                bfo();
                if (this.fUt != null) {
                    this.fUt.gx(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.yA().yx() == 0 && z) {
                this.fTI.setPullRefresh(null);
            } else {
                if (this.fUt == null) {
                    this.fUt = new com.baidu.tieba.pb.view.h(this.fMQ.getPageContext());
                    this.fUt.st();
                    this.fUt.a(this.bcF);
                }
                this.fTI.setPullRefresh(this.fUt);
                bfo();
                if (this.fUt != null) {
                    this.fUt.gx(TbadkCoreApplication.getInst().getSkinType());
                }
                agf();
            }
            bfr();
            this.fUp.jQ(this.fID);
            this.fUp.jR(false);
            this.fUp.kc(i == 5);
            this.fUp.kd(i == 6);
            this.fUp.ke(z2 && this.fWc);
            this.fUp.a(dVar, false);
            this.fUp.notifyDataSetChanged();
            if (this.fMQ.bcz()) {
                this.fVG = 0;
                PostData b = b(dVar, z);
                if (b != null && b.zn() != null) {
                    this.fVG = b.zn().getLevel_id();
                }
                if (this.fVG > 0) {
                    this.fTS.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.fTS, BitmapHelper.getGradeResourceIdInEnterForum(this.fVG));
                } else {
                    this.fTS.setVisibility(8);
                }
            } else {
                this.fTS.setVisibility(8);
            }
            if (dVar.bat() != null) {
                if (dVar.bat().zc() != null) {
                    if (dVar.bat().zc().getNum() < 1) {
                        str = this.fMQ.getResources().getString(d.j.zan);
                    } else {
                        str = dVar.bat().zc().getNum() + "";
                    }
                    if (this.fTx != -1) {
                        dVar.bat().zc().setIsLike(this.fTx);
                    }
                    Q(str, dVar.bat().zc().getIsLike() == 1);
                }
                if (dVar.bat().aQl != null && dVar.bat().aQl.isDeleted) {
                    this.fTE.kW(true);
                } else {
                    this.fTE.kW(false);
                }
            }
            if (this.fMQ.isLogin()) {
                this.fTI.setNextPage(this.dII);
                this.fTD = 2;
                agf();
            } else {
                this.fUZ = true;
                if (dVar.yA().yw() == 1) {
                    if (this.fUu == null) {
                        this.fUu = new com.baidu.tieba.pb.view.b(this.fMQ.getPageContext());
                    }
                    this.fTI.setNextPage(this.fUu);
                } else {
                    this.fTI.setNextPage(this.dII);
                }
                this.fTD = 3;
            }
            ArrayList<PostData> bav = dVar.bav();
            if (dVar.yA().yw() == 0 || bav == null || bav.size() < dVar.yA().yv()) {
                if (com.baidu.tbadk.core.util.v.D(bav) == 0 || (com.baidu.tbadk.core.util.v.D(bav) == 1 && bav.get(0) != null && bav.get(0).bwT() == 1)) {
                    this.dII.setText(this.fMQ.getResources().getString(d.j.list_no_more_new));
                    if (this.fMQ.bbP() != null && !this.fMQ.bbP().bgc()) {
                        this.fMQ.bbP().showFloatingView();
                    }
                } else {
                    this.dII.setText(this.fMQ.getResources().getString(d.j.list_has_no_more));
                }
                if (this.fMQ.bcm() && this.fTI != null && this.fTI.getData() != null && this.fTI.getData().size() == 1 && (this.fTI.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dII.setText("");
                }
                bfy();
            } else if (z2) {
                if (this.fWc) {
                    Eg();
                    if (dVar.yA().yw() != 0) {
                        this.dII.setText(this.fMQ.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.dII.Eb();
                    this.dII.showLoading();
                }
            } else {
                this.dII.Eb();
                this.dII.showLoading();
            }
            switch (i) {
                case 2:
                    this.fTI.setSelection(i2 > 1 ? (((this.fTI.getData() == null && dVar.bav() == null) ? 0 : (this.fTI.getData().size() - dVar.bav().size()) + this.fTI.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (beu2 = ai.bet().beu()) != null) {
                        this.fTI.onRestoreInstanceState(beu2);
                        if (com.baidu.tbadk.core.util.v.D(bav) > 1 && dVar.yA().yw() > 0) {
                            this.dII.Eg();
                            this.dII.setText(this.fMQ.getString(d.j.pb_load_more_without_point));
                            this.dII.Ec();
                            break;
                        }
                    } else {
                        this.fTI.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fWc = false;
                    break;
                case 5:
                    this.fTI.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (beu = ai.bet().beu()) != null) {
                        this.fTI.onRestoreInstanceState(beu);
                        break;
                    } else {
                        this.fTI.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fTy != null && this.fTy.bhv() != null) {
                            if (this.fMQ.isUseStyleImmersiveSticky()) {
                                this.fTI.setSelectionFromTop((this.fUp.bcO() + this.fTI.getHeaderViewsCount()) - 1, this.fTy.bhv().getHeight() - com.baidu.adp.lib.util.l.p(this.fMQ.getPageContext().getPageActivity()));
                            } else {
                                this.fTI.setSelectionFromTop((this.fUp.bcO() + this.fTI.getHeaderViewsCount()) - 1, this.fTy.bhv().getHeight());
                            }
                        } else {
                            this.fTI.setSelection(this.fUp.bcO() + this.fTI.getHeaderViewsCount());
                        }
                    } else {
                        this.fTI.setSelection(i2 > 0 ? ((this.fTI.getData() == null && dVar.bav() == null) ? 0 : (this.fTI.getData().size() - dVar.bav().size()) + this.fTI.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dII.Eg();
                    this.dII.setText(this.fMQ.getString(d.j.pb_load_more_without_point));
                    this.dII.Ec();
                    break;
            }
            if (this.fVp == fVq && isHost()) {
                bfG();
            }
            if (this.fVA) {
                beF();
                this.fVA = false;
                if (i3 == 0) {
                    kA(true);
                }
            }
            if (this.fTA != null) {
                this.fTA.ag(dVar.bat());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fHy == 1 || dVar.fHz == 1) {
                if (this.fVH == null) {
                    this.fVH = new PbTopTipView(this.fMQ);
                }
                if (dVar.fHz == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fMQ.getStType())) {
                    this.fVH.setText(this.fMQ.getString(d.j.pb_read_strategy_add_experience));
                    this.fVH.show(this.dpk, this.mSkinType);
                } else if (dVar.fHy == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fMQ.getStType())) {
                    this.fVH.setText(this.fMQ.getString(d.j.pb_read_news_add_experience));
                    this.fVH.show(this.dpk, this.mSkinType);
                }
            }
        }
    }

    private void bfo() {
        if (this.fTy != null && this.fTy.bhv() != null) {
            this.fTI.removeHeaderView(this.boy);
            if (this.mType != 1) {
                this.fTI.removeHeaderView(this.fTy.bhx());
                this.fTI.addHeaderView(this.fTy.bhx(), 0);
                return;
            }
            return;
        }
        if (this.fTy != null) {
            this.fTI.removeHeaderView(this.fTy.bhx());
        }
        this.fTI.removeHeaderView(this.boy);
        this.fTI.addHeaderView(this.boy, 0);
    }

    public void kI(boolean z) {
        this.fUK = z;
    }

    public void Eg() {
        if (this.dII != null) {
            this.dII.Ec();
            this.dII.Eg();
        }
        agf();
    }

    public void aij() {
        this.fTI.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fUY != null && this.fUY.zn() != null && this.fTE != null) {
            this.fVD = !this.fVC;
            this.fTE.kV(this.fVD);
            if (this.fMQ.bbP() != null) {
                this.fMQ.bbP().kU(this.fVD);
            }
            bfp();
            if (this.fVD) {
                this.fTE.fYD.setVisibility(0);
                if (this.fUL) {
                    this.fTE.fYE.setVisibility(8);
                    this.fUa.setVisibility(8);
                    this.fUd.setVisibility(0);
                    this.fUd.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(dVar.baO())));
                } else if (!PbNormalLikeButtonSwitchStatic.OO() || (this.fUY.zn().hadConcerned() && this.fUY.zn().getGodUserData() != null && this.fUY.zn().getGodUserData().getIsFromNetWork())) {
                    this.fTE.fYE.setVisibility(8);
                }
                if (this.fVi != null) {
                    this.fVi.setVisibility(8);
                }
                this.fTE.a(this.fUY.zn(), this.fWd);
                if (this.fVO == null) {
                    this.fVO = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fVF) {
                                ar.this.bfF();
                            }
                        }
                    };
                }
                this.fTI.setListViewDragListener(this.fVO);
                return;
            }
            if (this.fTE.fYD != null) {
                this.fTE.fYD.setVisibility(8);
            }
            if (this.fVi != null) {
                this.fVi.setVisibility(0);
            }
            if (this.fUL) {
                this.fUa.setVisibility(8);
                this.fUd.setVisibility(0);
                this.fUd.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(dVar.baO())));
            } else if (!PbNormalLikeButtonSwitchStatic.OO() || (this.fUY.zn().hadConcerned() && this.fUY.zn().getGodUserData() != null && this.fUY.zn().getGodUserData().getIsFromNetWork())) {
                this.fUa.setVisibility(8);
                this.fUd.setVisibility(8);
            } else {
                this.fUd.setVisibility(8);
            }
            this.fVO = null;
            this.fTI.setListViewDragListener(null);
        }
    }

    private void bfp() {
        String threadId = this.fPY != null ? this.fPY.getThreadId() : "";
        int bfq = bfq();
        if (this.fVD) {
            if (this.fUc == null) {
                this.fUc = new ap(this.fMQ.getPageContext(), this.fTE.fYE, 3);
                this.fUc.h(this.fMQ.getUniqueId());
            }
            if (this.fUY != null && this.fUY.zn() != null) {
                this.fUY.zn().setIsLike(this.fUY.zn().hadConcerned());
                this.fUc.a(this.fUY.zn());
            }
            this.fUc.cV(threadId);
            this.fUc.tb(bfq);
            this.fUc.fTt = this.fVC;
        }
        if (this.fUb == null) {
            this.fUb = new ap(this.fMQ.getPageContext(), this.fUa, 1);
            this.fUb.h(this.fMQ.getUniqueId());
            this.fUb.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bA(boolean z) {
                    if (ar.this.fMQ != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fMQ, d.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fMQ.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fUY != null && this.fUY.zn() != null) {
            this.fUY.zn().setIsLike(this.fUY.zn().hadConcerned());
            this.fUb.a(this.fUY.zn());
            this.fUb.cV(threadId);
        }
        this.fUb.fTt = this.fVC;
        this.fUb.tb(bfq);
    }

    private int bfq() {
        if (this.fPY == null || this.fPY.bat() == null) {
            return 0;
        }
        if (this.fPY.bat().Aw()) {
            return (com.baidu.tbadk.core.util.v.E(this.fPY.baN()) && (this.fPY.bas() == null || StringUtils.isNull(this.fPY.bas().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bfr() {
        boolean z;
        if (this.fUO != null && this.fUO.getVisibility() == 0) {
            if (this.fUl != null) {
                this.fUl.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fUl != null) {
                this.fUl.setVisibility(8);
            }
            z = false;
        }
        if ((this.fUn == null || this.fUn.getVisibility() == 8) && z && this.fID) {
            this.fUm.setVisibility(0);
        } else {
            this.fUm.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bat() == null) {
            return false;
        }
        if (dVar.bat().zk() == 1 || dVar.bat().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bat().zm() == null || dVar.bat().zm().AI() == 0) || dVar.bat().zi() == 1 || dVar.bat().zj() == 1 || dVar.bat().zS() || dVar.bat().Ad() || dVar.bat().zZ() || dVar.bat().zA() != null || !com.baidu.tbadk.core.util.am.isEmpty(dVar.bat().getCategory()) || dVar.bat().zr() || dVar.bat().zq();
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str));
            return com.baidu.tieba.card.j.a((Context) this.fMQ.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fTK != null) {
                if (dVar.bat() != null && dVar.bat().zD() == 0 && !dVar.bat().Aa() && !this.fVS) {
                    this.fTK.setVisibility(0);
                    if (dVar.bat() != null) {
                        dVar.bat().h(true, q(dVar));
                    }
                    SpannableStringBuilder zN = dVar.bat().zN();
                    this.fTL.setOnTouchListener(new com.baidu.tieba.view.m(zN));
                    if (this.fVP) {
                        this.fTL.setText(dVar.bat().getTitle());
                    } else {
                        this.fTL.setText(zN);
                    }
                    this.fTL.setVisibility(0);
                } else if (dVar.bat().zD() == 1) {
                    if (dVar.bat() != null) {
                        this.fTK.setVisibility(8);
                        this.fTI.removeHeaderView(this.fTK);
                        if (dVar.bat() != null && !dVar.bat().Aa()) {
                            this.fTO.setPadding(this.fTO.getPaddingLeft(), com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.tbds36), this.fTO.getPaddingRight(), this.fTO.getPaddingBottom());
                        }
                    }
                } else {
                    this.fTK.setVisibility(8);
                    this.fTI.removeHeaderView(this.fTK);
                    if (dVar.bat() != null && dVar.bat().Aa()) {
                        this.fTO.setPadding(this.fTO.getPaddingLeft(), 0, this.fTO.getPaddingRight(), this.fTO.getPaddingBottom());
                    } else {
                        this.fTO.setPadding(this.fTO.getPaddingLeft(), com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds48), this.fTO.getPaddingRight(), this.fTO.getPaddingBottom());
                    }
                }
            }
            this.fID = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bfr();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.zn().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.baF()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.zn() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.zn().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.baF()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<ay> baN = dVar.baN();
                if (com.baidu.tbadk.core.util.v.D(baN) > 0) {
                    sb = new StringBuilder();
                    for (ay ayVar : baN) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aOa) != null && tVar.aMi && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fMQ.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fMQ.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bzi;
    }

    public void qw(String str) {
        if (this.dII != null) {
            this.dII.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fTI;
    }

    public int bfs() {
        return d.g.richText;
    }

    public TextView bbK() {
        return this.fTN.bbK();
    }

    public void d(BdListView.e eVar) {
        this.fTI.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.bcF = bVar;
        if (this.fUt != null) {
            this.fUt.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int yu = alVar.yu();
            int yr = alVar.yr();
            if (this.fUq != null) {
                this.fUq.AU();
            } else {
                this.fUq = new com.baidu.tbadk.core.dialog.a(this.fMQ.getPageContext().getPageActivity());
                this.fUr = LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fUq.aO(this.fUr);
                this.fUq.a(d.j.dialog_ok, bVar);
                this.fUq.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bfu();
                        aVar.dismiss();
                    }
                });
                this.fUq.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fVx == null) {
                            ar.this.fVx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fMQ.HidenSoftKeyPad((InputMethodManager) ar.this.fMQ.getSystemService("input_method"), ar.this.dpk);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.ns().postDelayed(ar.this.fVx, 150L);
                    }
                });
                this.fUq.b(this.fMQ.getPageContext()).AU();
            }
            this.fUs = (EditText) this.fUr.findViewById(d.g.input_page_number);
            this.fUs.setText("");
            TextView textView = (TextView) this.fUr.findViewById(d.g.current_page_number);
            if (yu <= 0) {
                yu = 1;
            }
            if (yr <= 0) {
                yr = 1;
            }
            textView.setText(MessageFormat.format(this.fMQ.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(yu), Integer.valueOf(yr)));
            this.fMQ.ShowSoftKeyPadDelay(this.fUs, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fTI.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fMQ.showToast(str);
    }

    public boolean kJ(boolean z) {
        if (this.axG == null || !this.axG.Le()) {
            return false;
        }
        this.axG.Jl();
        return true;
    }

    public void bft() {
        if (this.fWf != null) {
            while (this.fWf.size() > 0) {
                TbImageView remove = this.fWf.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bft();
        this.fUp.sN(1);
        if (this.fTy != null) {
            this.fTy.onPause();
        }
    }

    public void onResume() {
        this.fUp.sN(2);
        if (this.fTy != null) {
            this.fTy.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fVz != null) {
            this.fVz.destroy();
        }
        if (this.fVQ != null) {
            this.fVQ.onDestory();
        }
        if (this.fVH != null) {
            this.fVH.hide();
        }
        if (this.fTB != null) {
            this.fTB.ang();
        }
        if (this.fTA != null) {
            this.fTA.onDestroy();
        }
        this.fMQ.hideProgressBar();
        if (this.dpi != null && this.dCs != null) {
            this.dpi.b(this.dCs);
        }
        bfu();
        Eg();
        if (this.fVx != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fVx);
        }
        if (this.fTO != null && this.fTZ != null) {
            this.fTO.removeView(this.fTU);
            this.fTZ = null;
        }
        if (this.fVd != null) {
            this.fVd.clearStatus();
        }
        this.fVY = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fUp.sN(3);
        if (this.dGe != null) {
            this.dGe.setBackgroundDrawable(null);
        }
        if (this.fTy != null) {
            this.fTy.destroy();
        }
        if (this.fUp != null) {
            this.fUp.onDestroy();
        }
        this.fTI.setOnLayoutListener(null);
        if (this.fVM != null) {
            this.fVM.awO();
        }
        if (this.fVo != null) {
            this.fVo.onDestroy();
        }
        bfP();
    }

    public boolean te(int i) {
        if (this.fTy != null) {
            return this.fTy.nc(i);
        }
        return false;
    }

    public void bfu() {
        this.fTE.wH();
        if (this.fTB != null) {
            this.fTB.ang();
        }
        com.baidu.adp.lib.util.l.a(this.fMQ.getPageContext().getPageActivity(), this.fUs);
        beH();
        if (this.fUI != null) {
            this.fUI.dismiss();
        }
        bfw();
        if (this.fTA != null) {
            this.fTA.bho();
        }
        if (this.fUq != null) {
            this.fUq.dismiss();
        }
        if (this.dFQ != null) {
            this.dFQ.dismiss();
        }
    }

    public void bfv() {
        this.fTE.wH();
        if (this.fTB != null) {
            this.fTB.ang();
        }
        if (this.fUI != null) {
            this.fUI.dismiss();
        }
        bfw();
        if (this.fTA != null) {
            this.fTA.bho();
        }
        if (this.fUq != null) {
            this.fUq.dismiss();
        }
        if (this.dFQ != null) {
            this.dFQ.dismiss();
        }
    }

    public void cW(List<String> list) {
        this.fVL = list;
        if (this.fVM != null) {
            this.fVM.setData(list);
        }
    }

    public void jP(boolean z) {
        this.fUp.jP(z);
    }

    public void kK(boolean z) {
        this.fUN = z;
    }

    public void bfw() {
        if (this.fUz != null) {
            this.fUz.dismiss();
        }
        if (this.fUA != null) {
            com.baidu.adp.lib.g.g.b(this.fUA, this.fMQ.getPageContext());
        }
        if (this.fUB != null) {
            com.baidu.adp.lib.g.g.b(this.fUB, this.fMQ.getPageContext());
        }
        if (this.fUx != null) {
            com.baidu.adp.lib.g.g.b(this.fUx, this.fMQ.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fPY, this.fID);
            d(this.fPY, this.fID, this.mType);
            this.fMQ.getLayoutMode().aQ(i == 1);
            this.fMQ.getLayoutMode().aM(this.dpk);
            this.fMQ.getLayoutMode().aM(this.fTJ);
            com.baidu.tbadk.core.util.aj.s(this.fTM, d.C0141d.cp_bg_line_d);
            if (this.fTA != null) {
                this.fTA.onChangeSkinType(i);
            }
            if (this.fTL != null) {
                com.baidu.tbadk.core.util.aj.r(this.fTL, d.C0141d.cp_cont_b);
                this.fTL.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_link_tip_c));
            }
            if (this.dII != null) {
                this.dII.gx(i);
                if (this.bzi != null) {
                    this.fMQ.getLayoutMode().aM(this.bzi);
                    com.baidu.tbadk.core.util.aj.s(this.bzi, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fUq != null) {
                this.fUq.c(this.fMQ.getPageContext());
            }
            kI(this.fUK);
            this.fUp.notifyDataSetChanged();
            if (this.fUt != null) {
                this.fUt.gx(i);
            }
            if (this.axG != null) {
                this.axG.onChangeSkinType(i);
            }
            if (this.fTY != null) {
                this.fTY.gB(i);
            }
            if (this.fUu != null) {
                this.fUu.gx(i);
            }
            if (!com.baidu.tbadk.core.util.v.E(this.cZc)) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.cZc) {
                    aVar.DP();
                }
            }
            kE(i == 1);
            beV();
            UtilHelper.setStatusBarBackground(this.dGe, i);
            UtilHelper.setStatusBarBackground(this.fVi, i);
            if (this.fUa != null) {
                this.fUa.onChangeSkinType(i);
            }
            if (this.fUf != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUf, d.C0141d.cp_cont_d);
            }
            if (this.fUe != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUe, d.C0141d.cp_cont_d);
            }
            if (this.fUg != null) {
                com.baidu.tbadk.core.util.aj.s(this.fUg, d.C0141d.cp_cont_e);
            }
            if (this.bel != null) {
                com.baidu.tbadk.core.util.aj.r(this.bel, d.C0141d.cp_cont_d);
            }
            if (this.fUh != null) {
                com.baidu.tbadk.core.util.aj.s(this.fUh, d.C0141d.cp_cont_e);
            }
            if (this.fTR != null) {
                com.baidu.tbadk.core.util.aj.r(this.fTR, d.C0141d.cp_link_tip_a);
            }
            if (this.fUd != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUd, d.C0141d.cp_cont_d);
            }
            if (this.fUi != null) {
                com.baidu.tbadk.n.a.a(this.fMQ.getPageContext(), this.fUi);
            }
            if (this.fUG != null) {
                com.baidu.tbadk.n.a.a(this.fMQ.getPageContext(), this.fUG);
            }
            if (this.fVy != null) {
                this.fVy.onChangeSkinType(i);
            }
            if (this.fTE != null) {
                if (this.fTy != null) {
                    this.fTy.tk(i);
                } else {
                    this.fTE.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fUQ != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUQ, d.C0141d.cp_cont_e);
            }
            if (this.fTS != null) {
                com.baidu.tbadk.core.util.aj.c(this.fTS, BitmapHelper.getGradeResourceIdInEnterForum(this.fVG));
            }
            if (this.fVN != null) {
                this.fVN.onChangeSkinType(i);
            }
            if (this.fVo != null) {
                this.fVo.onChangeSkinType();
            }
            if (this.fVK != null) {
                com.baidu.tbadk.core.util.aj.r(this.fVK, d.C0141d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLF = hVar;
        this.fUp.setOnImageClickListener(this.bLF);
        this.fVN.setOnImageClickListener(this.bLF);
    }

    public void h(NoNetworkView.a aVar) {
        this.dCs = aVar;
        if (this.dpi != null) {
            this.dpi.a(this.dCs);
        }
    }

    public void kL(boolean z) {
        this.fUp.setIsFromCDN(z);
    }

    public Button bfx() {
        return this.fUO;
    }

    public void bfy() {
        if (this.fTD != 2) {
            this.fTI.setNextPage(this.dII);
            this.fTD = 2;
        }
    }

    public void bfz() {
        if (com.baidu.tbadk.k.p.Ov().Ow()) {
            int lastVisiblePosition = this.fTI.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fTI.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog = tbImageView.getPerfLog();
                                perfLog.ij(1001);
                                perfLog.bAn = true;
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
                        com.baidu.tbadk.k.k perfLog2 = headImageView.getPerfLog();
                        perfLog2.ij(1001);
                        perfLog2.bAn = true;
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

    public boolean bfA() {
        return this.axG != null && this.axG.getVisibility() == 0;
    }

    public boolean bfB() {
        return this.axG != null && this.axG.Le();
    }

    public void bfC() {
        if (this.axG != null) {
            this.axG.Jl();
        }
    }

    public void kM(boolean z) {
        if (this.fUP != null) {
            kK(this.fMQ.bbL().LG());
            if (this.fUN) {
                kB(z);
            } else {
                kC(z);
            }
        }
    }

    public void bfD() {
        if (this.fUP != null) {
            this.fUP.setVisibility(8);
            this.fUU = false;
            if (this.fVo != null) {
                this.fVo.setVisibility(8);
                kG(false);
            }
            bfP();
        }
    }

    public void showLoadingDialog() {
        if (this.dgy == null) {
            this.dgy = new com.baidu.tbadk.core.view.b(this.fMQ.getPageContext());
        }
        this.dgy.bq(true);
    }

    public void agf() {
        if (this.dgy != null) {
            this.dgy.bq(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fTI.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fTI.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fTy != null) {
            this.fTy.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.flo = getScrollY();
            this.fVn.fWv = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVn));
            a(this.fVn.fWv, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fTy != null) {
            this.fTy.b(absListView, i);
        }
        int headerViewsCount = (i - this.fTI.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fUp.sM(headerViewsCount) == com.baidu.tieba.pb.data.j.fHO) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fTI.getHeaderViewsCount();
        if (this.fTM != null && this.fTE != null) {
            this.fTE.j(this.fTM.getBottom(), this.fTM.getMeasuredHeight(), z2);
        }
        this.fUp.bcS().n(z, this.fVg != null ? this.fVg.getMeasuredHeight() : 0);
        this.fVn.fCE = i;
        this.fVn.fWu = this.fTI.getHeaderViewsCount();
        this.fVn.fWv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVn));
        a(this.fVn.fWv, false);
    }

    public void bfE() {
        if (this.fMQ.isLogin() && this.fPY != null && this.fVD && !this.fVC && !this.fUL && this.fUY != null && this.fUY.zn() != null && !this.fUY.zn().getIsLike() && !this.fUY.zn().hadConcerned()) {
            if (this.fVz == null) {
                this.fVz = new am(this.fMQ);
            }
            this.fVz.a(this.fTE.fYD, this.fPY.baR(), this.fUY.zn().getUserId(), this.fPY.getThreadId());
        }
    }

    public void bfF() {
        if (this.fVD && !this.fVC && this.fUY != null && this.fUY.zn() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").s("obj_locate", this.fMQ.bcz() ? 2 : 1).s("obj_type", this.fVC ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fMQ.getPageContext().getPageActivity(), this.fUY.zn().getUserId(), this.fUY.zn().getUserName(), this.fMQ.bbz().bdk(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fVC && this.fVh != null && this.fTE.bgg() != null) {
            int bcP = this.fUp.bcP();
            if (bcP > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (bcP > this.fTI.getFirstVisiblePosition() - this.fTI.getHeaderViewsCount()) {
                    this.fVh.setVisibility(8);
                    return;
                }
                this.fVh.setVisibility(0);
                this.fTE.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fSR == null) {
                if (this.fTI.getFirstVisiblePosition() == 0) {
                    this.fVh.setVisibility(8);
                    this.fTE.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fVm) {
                        this.fVl = top;
                        this.fVm = false;
                    }
                    this.fVl = top < this.fVl ? top : this.fVl;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.fUo.getY() < 0.0f) {
                        measuredHeight = fVk - akVar.fSR.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fTE.bgg().getMeasuredHeight() - akVar.fSR.getMeasuredHeight();
                        this.fTE.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fVl) {
                        this.fVh.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fVh.setVisibility(0);
                    } else {
                        this.fVh.setVisibility(8);
                        this.fTE.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fVm = true;
                    }
                }
            }
        }
    }

    public void bfG() {
        if (!this.fWg) {
            TiebaStatic.log("c10490");
            this.fWg = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMQ.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fVr, Integer.valueOf(fVt));
            aVar.fa(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.aO(inflate);
            aVar.aE(sparseArray);
            aVar.a(d.j.grade_button_tips, this.fMQ);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fMQ.getPageContext()).AU();
        }
    }

    public void qx(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMQ.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fVr, Integer.valueOf(fVu));
        aVar.aE(sparseArray);
        aVar.a(d.j.view, this.fMQ);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fMQ.getPageContext()).AU();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.zn() != null) {
            MetaData zn = b.zn();
            zn.setGiftNum(zn.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bfH() {
        return this.fVd;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bat() != null && dVar.bat().Ad() && this.fVd == null) {
            this.fVd = (PbInterviewStatusView) this.fVc.inflate();
            this.fVd.setOnClickListener(this.dFR);
            this.fVd.setCallback(this.fMQ.bcu());
            this.fVd.c(this.fMQ, dVar);
        }
    }

    public LinearLayout bfI() {
        return this.fUo;
    }

    public View bfJ() {
        return this.dGe;
    }

    public boolean bfK() {
        return this.fVS;
    }

    public void jU(boolean z) {
        this.fTN.jU(z);
    }

    public void qy(String str) {
        if (this.fTF != null) {
            this.fTF.setTitle(str);
        }
    }

    private int kN(boolean z) {
        if (this.fVd == null || this.fVd.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bfL() {
        if (this.fVd != null && this.fVd.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fVd.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fVd.setLayoutParams(layoutParams);
        }
    }

    public boolean bbR() {
        return false;
    }

    public void qz(String str) {
        this.fUQ.performClick();
        if (!StringUtils.isNull(str) && this.fMQ.bbL() != null && this.fMQ.bbL().LA() != null && this.fMQ.bbL().LA().getInputView() != null) {
            EditText inputView = this.fMQ.bbL().LA().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bfu();
            if (configuration.orientation == 2) {
                bfD();
                beH();
            } else {
                beK();
            }
            if (this.fVy != null) {
                this.fVy.bcW();
            }
            this.fMQ.avi();
            this.fUo.setVisibility(8);
            this.fTE.kY(false);
            this.fMQ.ka(false);
            if (this.fTy != null) {
                if (configuration.orientation == 1) {
                    bfI().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fTI.setIsLandscape(true);
                    this.fTI.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fTI.setIsLandscape(false);
                    if (this.flo > 0) {
                        this.fTI.smoothScrollBy(this.flo, 0);
                    }
                }
                this.fTy.onConfigurationChanged(configuration);
            }
        }
    }

    public void kO(boolean z) {
        this.fTC = z;
    }

    public boolean bfM() {
        return this.fTy != null && this.fTy.bfM();
    }

    public void bfN() {
        if (this.fTy != null) {
            this.fTy.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fTA != null) {
            this.fTA.y(j, i);
        }
        if (this.fTy != null) {
            this.fTy.y(j, i);
        }
    }

    public void kf(boolean z) {
        this.fUp.kf(z);
    }

    public void bfO() {
        if (this.fVe == null) {
            LayoutInflater.from(this.fMQ.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.dpk, true);
            this.fVe = (ViewGroup) this.dpk.findViewById(d.g.add_experienced_layout);
            this.fVf = (TextView) this.dpk.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.r(this.fVf, d.C0141d.cp_cont_i);
            String string = this.fMQ.getResources().getString(d.j.experienced_add_success);
            String string2 = this.fMQ.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_h)));
            this.fVf.setText(spannableString);
        }
        this.fVe.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.ar.28.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        ar.this.fVe.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fVf.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fVf.startAnimation(scaleAnimation);
    }

    public void cz(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fUP.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fMQ);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fVK = new TextView(this.fMQ);
            this.fVK.setText(d.j.connection_tips);
            this.fVK.setGravity(17);
            this.fVK.setPadding(com.baidu.adp.lib.util.l.t(this.fMQ, d.e.ds24), 0, com.baidu.adp.lib.util.l.t(this.fMQ, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.t(this.fMQ, d.e.ds60);
            if (this.fVK.getParent() == null) {
                frameLayout.addView(this.fVK, layoutParams);
            }
            this.fVJ = new PopupWindow(this.fMQ);
            this.fVJ.setContentView(frameLayout);
            this.fVJ.setHeight(-2);
            this.fVJ.setWidth(-2);
            this.fVJ.setFocusable(true);
            this.fVJ.setOutsideTouchable(false);
            this.fVJ.setBackgroundDrawable(new ColorDrawable(this.fMQ.getResources().getColor(d.C0141d.transparent)));
            this.fTI.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fVJ.showAsDropDown(ar.this.fUP, view.getLeft(), -ar.this.fUP.getHeight());
                    } else {
                        ar.this.fVJ.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bfY() != null && !StringUtils.isNull(aVar.bfY().pkg_id) && !StringUtils.isNull(aVar.bfY().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fUR != null && this.fUR.getVisibility() == 0) {
            if (this.fVI == null) {
                View inflate = LayoutInflater.from(this.fMQ.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dFR);
                this.fVI = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fUR.getLocationInWindow(iArr);
            this.fVI.showAtLocation(this.fUR, 0, iArr[0] - com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fUR.getHeight()) - com.baidu.adp.lib.util.l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bfP() {
        com.baidu.adp.lib.g.g.b(this.fVI);
    }

    public void setIsInterviewLive(boolean z) {
        this.fVP = z;
    }

    public boolean getIsInterviewLive() {
        return this.fVP;
    }

    public void cA(View view) {
        this.fUG = view;
    }
}
