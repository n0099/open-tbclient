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
    private com.baidu.tbadk.editortools.i axP;
    private com.baidu.tieba.pb.a.c bLT;
    private j.b bcR;
    private TextView bey;
    private TextView boL;
    private View bzv;
    private List<com.baidu.tieba.pb.pb.main.view.a> cZo;
    private View.OnClickListener dGd;
    private View dGq;
    private PbListView dIU;
    private NavigationBarCoverTip dWc;
    private View ddB;
    private NoNetworkView dpu;
    private RelativeLayout dpw;
    private View.OnClickListener fIS;
    PbActivity.d fMg;
    private PbActivity fNb;
    private UserIconBox fOi;
    private UserIconBox fOj;
    private PbFakeFloorModel fPe;
    private com.baidu.tieba.pb.data.d fQj;
    public int fTI;
    private com.baidu.tieba.pb.video.i fTJ;
    private long fTK;
    private com.baidu.tieba.pb.video.h fTL;
    private com.baidu.tieba.d.c fTM;
    public final com.baidu.tieba.pb.pb.main.view.c fTP;
    public com.baidu.tieba.pb.pb.main.view.b fTQ;
    private ViewStub fTR;
    private ViewStub fTS;
    private PbLandscapeListView fTT;
    private View fTU;
    private LinearLayout fTX;
    private e fTY;
    private ColumnLayout fTZ;
    private f fUA;
    private View fUG;
    private ThreadSkinView fUa;
    private TextView fUb;
    private TextView fUc;
    private ImageView fUd;
    private HeadPendantView fUe;
    private FrameLayout fUf;
    private HeadImageView fUg;
    private View fUh;
    private FloatingLayout fUi;
    private PbFirstFloorUserLikeButton fUl;
    private ap fUm;
    private ap fUn;
    private TextView fUo;
    private TextView fUp;
    private TextView fUq;
    private View fUr;
    private View fUs;
    private LinearLayout fUt;
    private TextView fUu;
    private TextView fUv;
    private View fUw;
    private View fUx;
    private ObservedChangeLinearLayout fUz;
    private int fVH;
    private Runnable fVI;
    private r fVJ;
    private am fVK;
    private int fVQ;
    private PbTopTipView fVS;
    private PopupWindow fVT;
    private PopupWindow fVU;
    private TextView fVV;
    private List<String> fVW;
    private com.baidu.tieba.pb.pb.main.emotion.c fVX;
    private com.baidu.tieba.pb.pb.godreply.a fVY;
    private PbLandscapeListView.b fVZ;
    private View fVa;
    private TextView fVb;
    private ImageView fVc;
    private ImageView fVd;
    private TextView fVe;
    private boolean fVg;
    private int fVh;
    private int fVi;
    private PostData fVj;
    private View fVl;
    private TextView fVm;
    private ViewStub fVn;
    private PbInterviewStatusView fVo;
    private ViewGroup fVp;
    private TextView fVq;
    private FrameLayout fVr;
    private View fVs;
    private View fVt;
    private ak fVu;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fVz;
    private ab fWb;
    private boolean fWd;
    private com.baidu.tbadk.core.view.userLike.c fWe;
    private com.baidu.tbadk.core.view.userLike.c fWf;
    private Runnable fWk;
    private PbActivity.b fWm;
    private int flA;
    private boolean isLandscape;
    private int mType;
    private static final int fVv = UtilHelper.getLightStatusBarHeight();
    public static int fVB = 3;
    public static int fVC = 0;
    public static int fVD = 3;
    public static int fVE = 4;
    public static int fVF = 5;
    public static int fVG = 6;
    private boolean fTN = false;
    private int fTO = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fTV = null;
    private TextView fTW = null;
    public FrsPraiseView fUj = null;
    private ClickableHeaderImageView fUk = null;
    private View fUy = null;
    private com.baidu.tbadk.core.dialog.a fUB = null;
    private com.baidu.tbadk.core.dialog.b dGc = null;
    private View fUC = null;
    private EditText fUD = null;
    private com.baidu.tieba.pb.view.h fUE = null;
    private com.baidu.tieba.pb.view.b fUF = null;
    private com.baidu.tbadk.core.dialog.a fUH = null;
    private b.InterfaceC0096b eGZ = null;
    private TbRichTextView.h bLS = null;
    private NoNetworkView.a dCE = null;
    private Dialog fUI = null;
    private View fUJ = null;
    private com.baidu.tbadk.core.dialog.a fUK = null;
    private Dialog fUL = null;
    private Dialog fUM = null;
    private View fUN = null;
    private LinearLayout fUO = null;
    private CompoundButton.OnCheckedChangeListener cZp = null;
    private TextView fUP = null;
    private TextView fUQ = null;
    private View fUR = null;
    private String fUS = null;
    private com.baidu.tbadk.core.dialog.b fUT = null;
    private com.baidu.tbadk.core.dialog.b fUU = null;
    private boolean fUV = false;
    private boolean fUW = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fUX = null;
    private boolean fUY = false;
    private Button fUZ = null;
    private boolean fVf = true;
    private com.baidu.tbadk.core.view.b dgK = null;
    private boolean fIO = false;
    private int mSkinType = 3;
    private boolean fVk = false;
    private int fVw = 0;
    private boolean fVx = true;
    private a fVy = new a();
    private int fVA = 0;
    private boolean fVL = false;
    private int fVM = 0;
    private boolean fVN = false;
    private boolean fVO = false;
    private boolean fVP = false;
    private int fVR = 0;
    private boolean fWa = false;
    private a.InterfaceC0233a fWc = new a.InterfaceC0233a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0233a
        public void onRefresh() {
        }
    };
    private String fWg = null;
    private CustomMessageListener fWh = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.fWg = null;
            }
        }
    };
    private CustomMessageListener cdn = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fUA != null) {
                ar.this.fUA.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fWi = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fTW != null) {
                ar.this.fTW.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fWj = new Handler();
    private CustomMessageListener fWl = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fVf = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fWn = true;
    View.OnClickListener fWo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fVN) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").s("obj_id", 2));
            }
            if (view == ar.this.fTP.fYQ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").s("obj_locate", 2));
            }
            if (ar.this.fNb.fLf.fXZ != null) {
                if (!ar.this.fVN && ar.this.fQj != null && ar.this.fQj.bau() != null && ar.this.fQj.bau().zn() != null && ar.this.fQj.bau().zn().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").s("obj_locate", 1));
                }
                ar.this.fNb.fLf.fXZ.onClick(view);
            }
        }
    };
    private boolean fWp = false;
    String userId = null;
    private final List<TbImageView> fWq = new ArrayList();
    private boolean fWr = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fCQ;
        public int fWF;
        public ak fWG;
    }

    public void kA(boolean z) {
        this.fVL = z;
        if (this.fTT != null) {
            this.fVM = this.fTT.getHeaderViewsCount();
        }
    }

    public void beG() {
        if (this.fTT != null) {
            int headerViewsCount = this.fTT.getHeaderViewsCount() - this.fVM;
            final int firstVisiblePosition = (this.fTT.getFirstVisiblePosition() == 0 || this.fTT.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fTT.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fTT.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fVy.fWG = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVy));
            final ak akVar = this.fVy.fWG;
            final int h = h(akVar);
            final int y = ((int) this.fUz.getY()) + this.fUz.getMeasuredHeight();
            final boolean z = this.fVs.getVisibility() == 0;
            boolean z2 = this.fUz.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.fUA.bcQ() + this.fTT.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fTc.getMeasuredHeight() : 0;
                if (z2) {
                    this.fTT.setSelectionFromTop(this.fUA.bcQ() + this.fTT.getHeaderViewsCount(), fVv - measuredHeight);
                } else {
                    this.fTT.setSelectionFromTop(this.fUA.bcQ() + this.fTT.getHeaderViewsCount(), this.fTP.bgh().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fTT.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fVN) {
                this.fTT.setSelectionFromTop(this.fUA.bcQ() + this.fTT.getHeaderViewsCount(), this.fTJ.bhw().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fTT.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bdi() {
                        if (h >= 0 && h <= ar.this.dpw.getMeasuredHeight()) {
                            int h2 = ar.this.h(akVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.ddB.getLayoutParams();
                            if (i == 0 || i > ar.this.dpw.getMeasuredHeight() || h2 >= ar.this.dpw.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVH;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.dpw.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVH;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fTT.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.ddB.setLayoutParams(layoutParams);
                        }
                        ar.this.fTT.setOnLayoutListener(null);
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

    public NoNetworkView beH() {
        return this.dpu;
    }

    public void beI() {
        if (this.axP != null) {
            this.axP.hide();
            if (this.fVX != null) {
                this.fVX.Wk();
            }
        }
    }

    public PbFakeFloorModel beJ() {
        return this.fPe;
    }

    public r beK() {
        return this.fVJ;
    }

    public void beL() {
        reset();
        beI();
        this.fVJ.bcX();
        kM(false);
    }

    private void reset() {
        if (this.fNb != null && this.fNb.bbM() != null && this.axP != null) {
            com.baidu.tbadk.editortools.pb.a.Ly().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bbM = this.fNb.bbM();
            bbM.LQ();
            bbM.Lm();
            if (bbM.getWriteImagesInfo() != null) {
                bbM.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bbM.hO(SendView.ALL);
            bbM.hP(SendView.ALL);
            com.baidu.tbadk.editortools.l hG = this.axP.hG(23);
            com.baidu.tbadk.editortools.l hG2 = this.axP.hG(2);
            com.baidu.tbadk.editortools.l hG3 = this.axP.hG(5);
            if (hG2 != null) {
                hG2.th();
            }
            if (hG3 != null) {
                hG3.th();
            }
            if (hG != null) {
                hG.hide();
            }
            this.axP.invalidate();
        }
    }

    public boolean beM() {
        return this.fVf;
    }

    public void kB(boolean z) {
        if (this.fVa != null && this.fVb != null) {
            this.fVb.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fVa.startAnimation(alphaAnimation);
            }
            this.fVa.setVisibility(0);
            this.fVf = true;
            if (this.fVz != null && !this.fVY.isActive()) {
                this.fVz.setVisibility(0);
                kG(true);
            }
        }
    }

    public void kC(boolean z) {
        if (this.fVa != null && this.fVb != null) {
            this.fVb.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fVa.startAnimation(alphaAnimation);
            }
            this.fVa.setVisibility(0);
            this.fVf = true;
            if (this.fVz != null && !this.fVY.isActive()) {
                this.fVz.setVisibility(0);
                kG(true);
            }
        }
    }

    public PostData beN() {
        int i = 0;
        if (this.fTT == null) {
            return null;
        }
        int beO = beO() - this.fTT.getHeaderViewsCount();
        if (beO < 0) {
            beO = 0;
        }
        if (this.fUA.sL(beO) != null && this.fUA.sL(beO) != PostData.haP) {
            i = beO + 1;
        }
        return this.fUA.getItem(i) instanceof PostData ? (PostData) this.fUA.getItem(i) : null;
    }

    public int beO() {
        int i;
        View childAt;
        if (this.fTT == null) {
            return 0;
        }
        int firstVisiblePosition = this.fTT.getFirstVisiblePosition();
        int lastVisiblePosition = this.fTT.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fTT.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fTT.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int beP() {
        return this.fTT.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fQj != null && this.fQj.baw() != null && !this.fQj.baw().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fQj.baw().size() && (postData = this.fQj.baw().get(i)) != null && postData.zn() != null && !StringUtils.isNull(postData.zn().getUserId()); i++) {
                if (this.fQj.baw().get(i).zn().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fVY != null && this.fVY.isActive()) {
                        kM(false);
                    }
                    if (this.fVz != null) {
                        this.fVz.kS(true);
                    }
                    this.fWg = postData.zn().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fNb = null;
        this.dpw = null;
        this.dGq = null;
        this.fTK = 0L;
        this.fTT = null;
        this.fTU = null;
        this.fTX = null;
        this.fTZ = null;
        this.fUb = null;
        this.fUc = null;
        this.fUf = null;
        this.fUg = null;
        this.fUh = null;
        this.fUl = null;
        this.fUo = null;
        this.fUp = null;
        this.fUq = null;
        this.fUr = null;
        this.fUw = null;
        this.fUx = null;
        this.fUA = null;
        this.dIU = null;
        this.bzv = null;
        this.dGd = null;
        this.fIS = null;
        this.fVa = null;
        this.fVb = null;
        this.fVc = null;
        this.fVd = null;
        this.fVe = null;
        this.fVl = null;
        this.fVm = null;
        this.fVn = null;
        this.fVQ = 0;
        this.fTK = System.currentTimeMillis();
        this.fNb = pbActivity;
        this.dGd = onClickListener;
        this.bLT = cVar;
        this.fVQ = com.baidu.adp.lib.util.l.ao(this.fNb) / 2;
        this.dpw = (RelativeLayout) LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.fNb.addContentView(this.dpw, new FrameLayout.LayoutParams(-1, -1));
        this.dWc = (NavigationBarCoverTip) this.fNb.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dGq = this.fNb.findViewById(d.g.statebar_view);
        this.fUz = (ObservedChangeLinearLayout) this.fNb.findViewById(d.g.title_wrapper);
        this.dpu = (NoNetworkView) this.fNb.findViewById(d.g.view_no_network);
        this.fTT = (PbLandscapeListView) this.fNb.findViewById(d.g.new_pb_list);
        this.fVr = (FrameLayout) this.fNb.findViewById(d.g.root_float_header);
        this.boL = new TextView(this.fNb.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds88));
        this.fTT.addHeaderView(this.boL, 0);
        this.fVH = this.fNb.getResources().getDimensionPixelSize(d.e.tbds134);
        this.ddB = new View(this.fNb.getPageContext().getPageActivity());
        this.ddB.setLayoutParams(new AbsListView.LayoutParams(-1, this.fVH));
        this.ddB.setVisibility(4);
        this.fTT.addFooterView(this.ddB);
        this.fTT.setOnTouchListener(this.fNb.bDx);
        this.fTP = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.fNb.bcn()) {
            this.fTR = (ViewStub) this.fNb.findViewById(d.g.manga_view_stub);
            this.fTR.setVisibility(0);
            this.fTQ = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.fTQ.show();
            this.fTP.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds120);
        }
        this.boL.setLayoutParams(layoutParams);
        this.fTP.bgh().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0204a() { // from class: com.baidu.tieba.pb.pb.main.ar.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0204a
            public void bbm() {
                if (ar.this.fTT != null) {
                    if (ar.this.fTJ != null) {
                        ar.this.fTJ.bhx();
                    }
                    ar.this.fTT.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0204a
            public void bbn() {
                ar.this.fNb.avj();
            }
        }));
        this.fVa = this.fNb.findViewById(d.g.pb_editor_tool_comment);
        this.fVh = com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds90);
        this.fVi = com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds242);
        this.fVb = (TextView) this.fNb.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fVd = (ImageView) this.fNb.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fVc = (ImageView) this.fNb.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fVe = (TextView) this.fNb.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fVe.setVisibility(8);
        this.fVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfQ();
                if (!ar.this.fNb.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, ar.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d bbM = ar.this.fNb.bbM();
                if (bbM == null || (!bbM.LN() && !bbM.LO())) {
                    if (ar.this.axP != null) {
                        ar.this.beZ();
                    }
                    if (ar.this.axP != null) {
                        ar.this.fVf = false;
                        if (ar.this.axP.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fNb, (View) ar.this.axP.hI(2).bsw, false, ar.this.fWc);
                        }
                    }
                    ar.this.bfE();
                    return;
                }
                ar.this.fNb.bbM().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfQ();
                if (ar.this.fNb.checkUpIsLogin()) {
                    if (ar.this.axP != null) {
                        ar.this.beZ();
                        ar.this.axP.bh((View) ar.this.axP.hG(5));
                    }
                    if (ar.this.axP != null) {
                        ar.this.fVf = false;
                        if (ar.this.axP.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fNb, (View) ar.this.axP.hI(2).bsw, false, ar.this.fWc);
                        }
                    }
                    ar.this.bfE();
                }
            }
        });
        this.fVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfQ();
                if (ar.this.fNb.checkUpIsLogin()) {
                    if (ar.this.axP != null) {
                        ar.this.beZ();
                        ar.this.axP.bh((View) ar.this.axP.hG(2));
                    }
                    if (ar.this.axP != null) {
                        ar.this.fVf = false;
                        if (ar.this.axP.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fNb, (View) ar.this.axP.hI(2).bsw, false, ar.this.fWc);
                        }
                    }
                    ar.this.bfE();
                }
            }
        });
        this.fVe.setOnClickListener(this.dGd);
        this.fVe.setOnTouchListener(this.fNb);
        this.fTU = LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fTX = (LinearLayout) LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.aj.s(this.fTX, d.C0140d.cp_bg_line_d);
        this.fTY = new e(this.fNb, this.fTX);
        this.fTY.init();
        this.fTY.a(this.fTY.bbL(), this.dGd);
        this.fTZ = (ColumnLayout) this.fTX.findViewById(d.g.pb_head_owner_root);
        this.fUa = (ThreadSkinView) this.fTX.findViewById(d.g.pb_thread_skin);
        this.fTZ.setOnLongClickListener(this.onLongClickListener);
        this.fTZ.setOnTouchListener(this.bLT);
        this.fTZ.setVisibility(8);
        this.fTU.setOnTouchListener(this.bLT);
        this.fVl = this.fTU.findViewById(d.g.pb_head_activity_join_number_container);
        this.fVl.setVisibility(8);
        this.fVm = (TextView) this.fTU.findViewById(d.g.pb_head_activity_join_number);
        this.fUb = (TextView) this.fTZ.findViewById(d.g.pb_head_owner_info_user_name);
        this.fUc = (TextView) this.fTZ.findViewById(d.g.floor_owner);
        this.fUd = (ImageView) this.fTZ.findViewById(d.g.icon_forum_level);
        this.fUf = (FrameLayout) this.fTZ.findViewById(d.g.pb_head_headImage_container);
        this.fUg = (HeadImageView) this.fTZ.findViewById(d.g.pb_head_owner_photo);
        this.fUe = (HeadPendantView) this.fTZ.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fUe.DT();
        if (this.fUe.getHeadView() != null) {
            this.fUe.getHeadView().setIsRound(true);
            this.fUe.getHeadView().setDrawBorder(false);
        }
        this.fOi = (UserIconBox) this.fTZ.findViewById(d.g.show_icon_vip);
        this.fOj = (UserIconBox) this.fTZ.findViewById(d.g.show_icon_yinji);
        this.fUi = (FloatingLayout) this.fTX.findViewById(d.g.pb_head_owner_info_root);
        this.fUl = (PbFirstFloorUserLikeButton) this.fTZ.findViewById(d.g.pb_like_button);
        this.fUo = (TextView) this.fTZ.findViewById(d.g.pb_views);
        this.bey = (TextView) this.fTZ.findViewById(d.g.view_forum_name);
        this.fUs = this.fTZ.findViewById(d.g.line_right_forum_name);
        this.fUp = (TextView) this.fTZ.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fUq = (TextView) this.fTZ.findViewById(d.g.pb_item_first_floor_location_address);
        this.fUr = this.fTZ.findViewById(d.g.line_between_time_and_locate);
        this.fWe = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fWf = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fUw = this.fTU.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fUx = this.fTU.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fTU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fVn = (ViewStub) this.dpw.findViewById(d.g.interview_status_stub);
        this.fUA = new f(this.fNb, this.fTT);
        this.fUA.r(this.dGd);
        this.fUA.setTbGestureDetector(this.bLT);
        this.fUA.setOnImageClickListener(this.bLS);
        this.fIS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.akM() || !com.baidu.tieba.c.a.b(ar.this.fNb.getBaseContext(), ar.this.fNb.bbA().bdm(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                ar.this.fNb.c(sparseArray);
                                return;
                            }
                            ar.this.cy(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        ar.this.fNb.c(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fUA.E(this.fIS);
        beU();
        this.fTT.addHeaderView(this.fTV);
        this.fTT.addHeaderView(this.fTX);
        this.fTT.addHeaderView(this.fTU);
        this.dIU = new PbListView(this.fNb.getPageContext().getPageActivity());
        this.bzv = this.dIU.getView().findViewById(d.g.pb_more_view);
        if (this.bzv != null) {
            this.bzv.setOnClickListener(this.dGd);
            com.baidu.tbadk.core.util.aj.s(this.bzv, d.f.pb_foot_more_trans_selector);
        }
        this.dIU.Ec();
        this.dIU.gu(d.f.pb_foot_more_trans_selector);
        this.dIU.gw(d.f.pb_foot_more_trans_selector);
        this.fUG = this.fNb.findViewById(d.g.viewstub_progress);
        this.fNb.registerListener(this.fWl);
        this.fUh = com.baidu.tbadk.ala.b.vL().u(this.fNb.getActivity(), 2);
        if (this.fUh != null) {
            this.fUh.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fNb.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fUh.getParent() == null) {
                this.fUi.addView(this.fUh, aVar);
            }
        }
        this.fPe = new PbFakeFloorModel(this.fNb.getPageContext());
        this.fVJ = new r(this.fNb.getPageContext(), this.fPe, this.dpw);
        this.fVJ.a(this.fNb.fMc);
        this.fPe.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.fPe.m(postData);
                ar.this.fUA.notifyDataSetChanged();
                ar.this.fVJ.bcX();
                ar.this.axP.Jm();
                ar.this.kM(false);
            }
        });
        if (this.fNb.bbA() != null && !StringUtils.isNull(this.fNb.bbA().bdR())) {
            this.fNb.showToast(this.fNb.bbA().bdR());
        }
        this.fVs = this.fNb.findViewById(d.g.pb_expand_blank_view);
        this.fVt = this.fNb.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fVt.getLayoutParams();
        if (this.fNb.bbA() != null && this.fNb.bbA().bdp()) {
            this.fVs.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fVt.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fVv;
            this.fVt.setLayoutParams(layoutParams2);
        }
        this.fVu = new ak(this.fNb.getPageContext(), this.fNb.findViewById(d.g.pb_reply_expand_view));
        this.fVu.fTc.setVisibility(8);
        this.fVu.G(this.dGd);
        this.fNb.registerListener(this.cdn);
        this.fNb.registerListener(this.fWh);
        this.fNb.registerListener(this.fWi);
        beQ();
        kG(false);
    }

    private void beQ() {
        this.fVY = new com.baidu.tieba.pb.pb.godreply.a(this.fNb, this, (ViewStub) this.dpw.findViewById(d.g.more_god_reply_popup));
        this.fVY.l(this.dGd);
        this.fVY.E(this.fIS);
        this.fVY.setOnImageClickListener(this.bLS);
        this.fVY.l(this.dGd);
        this.fVY.setTbGestureDetector(this.bLT);
    }

    public com.baidu.tieba.pb.pb.godreply.a beR() {
        return this.fVY;
    }

    public View beS() {
        return this.fVs;
    }

    public void beT() {
        if (this.fTT != null) {
            this.fTT.removeHeaderView(this.fTV);
            this.fTT.removeHeaderView(this.fTX);
            this.fTT.removeHeaderView(this.fTU);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fVz == null) {
            this.fVz = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.fNb.getPageContext().getPageActivity());
            kG(true);
            this.fVz.a(this.dpw, aVar, this.fVa.getVisibility() == 0);
            this.fVz.setOnEmotionClickListener(new a.InterfaceC0210a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0210a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(ar.this.fWg)) {
                        emotionImageData.setAuthorNameShow(ar.this.fWg);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0210a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fNb.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fNb.getPageContext().getPageActivity(), 25016, str, list, ar.this.fWg, list2)));
                }
            });
            this.fVz.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    ar.this.bfQ();
                    if (ar.this.fVa != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fVa.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fVi - ar.this.fVh) * f) + ar.this.fVh);
                        ar.this.fVb.setAlpha(1.0f - f);
                        ar.this.fVd.setAlpha(1.0f - f);
                        ar.this.fVc.setAlpha(1.0f - f);
                        ar.this.fVa.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void beU() {
        if (this.fTV == null) {
            int t = com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.tbds44);
            this.fTV = new LinearLayout(this.fNb.getPageContext().getPageActivity());
            this.fTV.setOrientation(1);
            this.fTV.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fTV.setPadding(t, com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.tbds30), t, com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.tbds40));
            this.fTV.setGravity(17);
            this.fTW = new TextView(this.fNb.getPageContext().getPageActivity());
            this.fTW.setGravity(3);
            this.fTW.setMaxLines(2);
            this.fTW.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_link_tip_c));
            this.fTW.setPadding(0, 0, 0, 0);
            this.fTW.setLineSpacing(com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.r(this.fTW, d.C0140d.cp_cont_b);
            this.fTW.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fTW.setVisibility(8);
            if (this.fTW.getParent() == null) {
                this.fTV.addView(this.fTW);
            }
            this.fTV.setOnTouchListener(this.bLT);
            this.fTV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beV() {
        if (this.fNb.bcn()) {
            this.fTS = (ViewStub) this.fNb.findViewById(d.g.manga_mention_controller_view_stub);
            this.fTS.setVisibility(0);
            if (this.fUt == null) {
                this.fUt = (LinearLayout) this.fNb.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fNb.getPageContext(), this.fUt);
            }
            if (this.fUu == null) {
                this.fUu = (TextView) this.fUt.findViewById(d.g.manga_prev_btn);
            }
            if (this.fUv == null) {
                this.fUv = (TextView) this.fUt.findViewById(d.g.manga_next_btn);
            }
            this.fUu.setOnClickListener(this.dGd);
            this.fUv.setOnClickListener(this.dGd);
        }
    }

    private void beW() {
        if (this.fNb.bcn()) {
            if (this.fNb.bcq() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fUu, d.C0140d.cp_cont_e, 1);
            }
            if (this.fNb.bcr() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fUv, d.C0140d.cp_cont_e, 1);
            }
        }
    }

    public void beX() {
        if (this.fUt == null) {
            beV();
        }
        this.fTS.setVisibility(8);
        if (this.fWj != null && this.fWk != null) {
            this.fWj.removeCallbacks(this.fWk);
        }
    }

    public void beY() {
        if (this.fWj != null) {
            if (this.fWk != null) {
                this.fWj.removeCallbacks(this.fWk);
            }
            this.fWk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fUt == null) {
                        ar.this.beV();
                    }
                    ar.this.fTS.setVisibility(0);
                }
            };
            this.fWj.postDelayed(this.fWk, 2000L);
        }
    }

    public void kD(boolean z) {
        this.fTP.kD(z);
        if (z && this.fVk) {
            this.dIU.setText(this.fNb.getResources().getString(d.j.click_load_more));
            this.fTT.setNextPage(this.dIU);
            this.fTO = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axP = iVar;
        this.axP.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.axP.getParent() == null) {
            this.dpw.addView(this.axP, layoutParams);
        }
        this.axP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        beI();
        this.fNb.bbM().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.axP != null && ar.this.axP.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fVX == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.axP.getId());
                            ar.this.fVX = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fNb.getPageContext(), ar.this.dpw, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.E(ar.this.fVW)) {
                                ar.this.fVX.setData(ar.this.fVW);
                            }
                            ar.this.fVX.b(ar.this.axP);
                        }
                        ar.this.fVX.qD(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fNb.fLj != null && ar.this.fNb.fLj.bfT() != null) {
                    if (!ar.this.fNb.fLj.bfT().bFF()) {
                        ar.this.fNb.fLj.kP(false);
                    }
                    ar.this.fNb.fLj.bfT().nB(false);
                }
            }
        });
    }

    public void beZ() {
        if (this.fNb != null && this.axP != null) {
            this.axP.th();
            bfE();
        }
    }

    public void R(String str, boolean z) {
        this.fVg = z;
        kE(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kE(boolean z) {
        if (this.fVe != null) {
            if (this.fVg) {
                com.baidu.tbadk.core.util.aj.s(this.fVe, d.f.pb_praise_already_click_selector);
                this.fVe.setContentDescription(this.fNb.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.s(this.fVe, d.f.pb_praise_normal_click_selector);
            this.fVe.setContentDescription(this.fNb.getResources().getString(d.j.zan));
        }
    }

    public TextView bfa() {
        return this.fVe;
    }

    public void kF(boolean z) {
        if (this.fTT != null && this.boL != null && this.dGq != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dGq.setVisibility(0);
                } else {
                    this.dGq.setVisibility(8);
                    this.fTT.removeHeaderView(this.boL);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.boL.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fVv;
                    this.boL.setLayoutParams(layoutParams);
                }
                bfp();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.boL.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kN(true);
                this.boL.setLayoutParams(layoutParams2);
            }
            bfp();
            bfM();
        }
    }

    public f bfb() {
        return this.fUA;
    }

    public void a(PbActivity.d dVar) {
        this.fMg = dVar;
    }

    public void cy(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fUJ == null) {
            this.fUJ = LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fNb.getLayoutMode().aM(this.fUJ);
        if (this.fUI == null) {
            this.fUI = new Dialog(this.fNb.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUI.setCanceledOnTouchOutside(true);
            this.fUI.setCancelable(true);
            this.fUI.setContentView(this.fUJ);
            WindowManager.LayoutParams attributes = this.fUI.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ao(this.fNb.getPageContext().getPageActivity()) * 0.9d);
            this.fUI.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUI.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fUI.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUI.findViewById(d.g.disable_reply_btn);
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
                    if (ar.this.fUI != null && (ar.this.fUI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUI, ar.this.fNb.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || bfL()) {
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
                    if (ar.this.fUI != null && (ar.this.fUI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUI, ar.this.fNb.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fWm != null) {
                        ar.this.fWm.ak(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
                    if (ar.this.fUI != null && (ar.this.fUI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUI, ar.this.fNb.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fNb.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fUI, this.fNb.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fWm = bVar;
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
        sparseArray.put(fVC, Integer.valueOf(fVD));
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
        this.fUK = new com.baidu.tbadk.core.dialog.a(this.fNb.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fUK.fb(i3);
        } else {
            this.fUK.be(false);
            this.fUK.dk(str2);
        }
        this.fUK.aE(sparseArray);
        this.fUK.a(d.j.dialog_ok, this.fNb);
        this.fUK.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUK.aZ(true);
        this.fUK.b(this.fNb.getPageContext());
        this.fUK.AU();
    }

    public void an(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fUN == null) {
            this.fUN = LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.fNb.getLayoutMode().aM(this.fUN);
        if (this.fUM == null) {
            this.fUM = new Dialog(this.fNb.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUM.setCanceledOnTouchOutside(true);
            this.fUM.setCancelable(true);
            this.fUX = (ScrollView) this.fUN.findViewById(d.g.good_scroll);
            this.fUM.setContentView(this.fUN);
            WindowManager.LayoutParams attributes = this.fUM.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds540);
            this.fUM.getWindow().setAttributes(attributes);
            this.cZp = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fUS = (String) compoundButton.getTag();
                        if (ar.this.cZo != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : ar.this.cZo) {
                                String str = (String) aVar.getTag();
                                if (str != null && ar.this.fUS != null && !str.equals(ar.this.fUS)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fUO = (LinearLayout) this.fUN.findViewById(d.g.good_class_group);
            this.fUQ = (TextView) this.fUN.findViewById(d.g.dialog_button_cancel);
            this.fUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fUM instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUM, ar.this.fNb.getPageContext());
                    }
                }
            });
            this.fUP = (TextView) this.fUN.findViewById(d.g.dialog_button_ok);
            this.fUP.setOnClickListener(this.dGd);
        }
        this.fUO.removeAllViews();
        this.cZo = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bI = bI("0", this.fNb.getPageContext().getString(d.j.def_good_class));
        this.cZo.add(bI);
        bI.setChecked(true);
        this.fUO.addView(bI);
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
                    this.cZo.add(bI2);
                    View view = new View(this.fNb.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.aj.t(view, d.C0140d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fUO.addView(view);
                    this.fUO.addView(bI2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fUX.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fNb.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fNb.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fNb.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fUX.setLayoutParams(layoutParams2);
            this.fUX.removeAllViews();
            if (this.fUO != null && this.fUO.getParent() == null) {
                this.fUX.addView(this.fUO);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fUM, this.fNb.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bI(String str, String str2) {
        Activity pageActivity = this.fNb.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.t(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cZp);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void bfc() {
        this.fNb.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fNb.hideProgressBar();
        if (z && z2) {
            this.fNb.showToast(this.fNb.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.fNb.showToast(str);
        }
    }

    public void aKi() {
        this.fUG.setVisibility(0);
    }

    public void aKh() {
        this.fUG.setVisibility(8);
    }

    public View bfd() {
        if (this.fUN != null) {
            return this.fUN.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bfe() {
        return this.fUS;
    }

    public View getView() {
        return this.dpw;
    }

    public void bff() {
        com.baidu.adp.lib.util.l.a(this.fNb.getPageContext().getPageActivity(), this.fNb.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fNb.hideProgressBar();
        if (z) {
            bfv();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bfw();
        } else {
            bfv();
        }
    }

    public void bfg() {
        this.dIU.Ec();
        this.dIU.Eg();
    }

    public void bfh() {
        this.fNb.hideProgressBar();
        Eh();
        this.fTT.completePullRefreshPostDelayed(2000L);
        bfs();
    }

    public void bfi() {
        this.fTT.completePullRefreshPostDelayed(2000L);
        bfs();
    }

    private void kG(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fVb.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fNb.getResources().getDimensionPixelSize(d.e.ds130) : this.fNb.getResources().getDimensionPixelSize(d.e.ds34);
        this.fVb.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fUA.setOnLongClickListener(onLongClickListener);
        if (this.fVY != null) {
            this.fVY.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0096b interfaceC0096b, boolean z, boolean z2) {
        if (this.fUT != null) {
            this.fUT.dismiss();
            this.fUT = null;
        }
        this.fUT = new com.baidu.tbadk.core.dialog.b(this.fNb.getPageContext().getPageActivity());
        this.fUT.fe(d.j.operation);
        if (z2) {
            this.fUT.a(new String[]{this.fNb.getPageContext().getString(d.j.copy)}, interfaceC0096b);
        } else if (!z) {
            this.fUT.a(new String[]{this.fNb.getPageContext().getString(d.j.copy), this.fNb.getPageContext().getString(d.j.mark)}, interfaceC0096b);
        } else {
            this.fUT.a(new String[]{this.fNb.getPageContext().getString(d.j.copy), this.fNb.getPageContext().getString(d.j.remove_mark)}, interfaceC0096b);
        }
        this.fUT.d(this.fNb.getPageContext());
        this.fUT.AX();
    }

    public void a(b.InterfaceC0096b interfaceC0096b, boolean z) {
        if (this.fUU != null) {
            this.fUU.dismiss();
            this.fUU = null;
        }
        this.fUU = new com.baidu.tbadk.core.dialog.b(this.fNb.getPageContext().getPageActivity());
        this.fUU.fe(d.j.operation);
        if (z) {
            this.fUU.a(new String[]{this.fNb.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0096b);
        } else {
            this.fUU.a(new String[]{this.fNb.getPageContext().getString(d.j.save_to_emotion), this.fNb.getPageContext().getString(d.j.save_to_local)}, interfaceC0096b);
        }
        this.fUU.d(this.fNb.getPageContext());
        this.fUU.AX();
    }

    public int bfj() {
        return tb(this.fTT.getFirstVisiblePosition());
    }

    private int tb(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fTT.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fTT.getAdapter() == null || !(this.fTT.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fTT.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bfk() {
        int lastVisiblePosition = this.fTT.getLastVisiblePosition();
        if (this.fTJ != null) {
            if (lastVisiblePosition == this.fTT.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return tb(lastVisiblePosition);
    }

    public void tc(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fTT != null) {
            if (this.fTP == null || this.fTP.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fTP.mNavigationBar.getFixedNavHeight();
                if (this.fNb.bcb() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fVt != null && (layoutParams = (LinearLayout.LayoutParams) this.fVt.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fVt.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fTT.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fTT.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fUD.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fUA.a(dVar, false);
        this.fUA.notifyDataSetChanged();
        bfs();
        if (this.fVY != null) {
            this.fVY.bbw();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fUj == null) {
            this.fNb.getLayoutMode().aM(((ViewStub) this.fTU.findViewById(d.g.praise_layout)).inflate());
            this.fUj = (FrsPraiseView) this.fTU.findViewById(d.g.pb_head_praise_view);
            this.fUj.setIsFromPb(true);
            this.fUy = this.fTU.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fUj.gB(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fUj != null) {
            boolean bfs = bfs();
            this.fUj.setVisibility(8);
            if (dVar != null && dVar.yA() != null && dVar.yA().yx() == 0 && this.fIO) {
                if (bfs) {
                    this.fUx.setVisibility(0);
                    return;
                } else {
                    this.fUx.setVisibility(8);
                    return;
                }
            }
            this.fUx.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.baE() != null) {
            return dVar.baE();
        }
        if (!com.baidu.tbadk.core.util.v.E(dVar.baw())) {
            Iterator<PostData> it = dVar.baw().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bwU() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.baB();
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
        if (dVar == null || dVar.bau() == null || dVar.bau().zn() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zn = dVar.bau().zn();
        String userId = zn.getUserId();
        HashMap<String, MetaData> userMap = dVar.bau().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zn;
        }
        postData.vL(1);
        postData.setId(dVar.bau().zE());
        postData.setTitle(dVar.bau().getTitle());
        postData.setTime(dVar.bau().getCreateTime());
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
        com.baidu.tbadk.data.f bwY;
        String portrait;
        if (dVar != null && dVar.bau() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fTZ.setVisibility(8);
            if (dVar.bau() != null && dVar.bau().Aa() && dVar.bau().zF() != null) {
                this.fVN = true;
                this.fTP.lb(this.fVN);
                this.fTP.mNavigationBar.hideBottomLine();
                if (this.fTJ == null) {
                    this.fTJ = new com.baidu.tieba.pb.video.i(this.fNb, this.fTP, dVar.bau().zF(), this.fTK);
                    this.fTJ.a(dVar.bau().zF(), dVar.bau(), dVar.getForumId());
                    this.fTJ.startPlay();
                } else if (this.fTN) {
                    this.fTJ.a(dVar.bau().zF(), dVar.bau(), dVar.getForumId());
                    this.fTJ.startPlay();
                } else {
                    this.fTJ.qN(dVar.getForumId());
                }
                if (dVar.bav() != null && dVar.bav().size() >= 1) {
                    bd bdVar = dVar.bav().get(0);
                    this.fTJ.ah(bdVar);
                    this.fTJ.qO(bdVar.getTitle());
                }
                this.fTJ.b(b, dVar.bau(), dVar.baQ());
                this.fTN = false;
                this.fTT.removeHeaderView(this.fTJ.bhy());
                this.fTT.addHeaderView(this.fTJ.bhy(), 0);
                if (this.fTJ.bhw() != null && this.fTJ.bhw().getParent() == null) {
                    this.fVr.addView(this.fTJ.bhw());
                }
                if (this.fTL == null) {
                    this.fTL = new com.baidu.tieba.pb.video.h(this.fNb);
                }
                this.fTL.a(dVar.bau().Ao(), dVar.bau(), dVar.baN());
                this.fTT.removeHeaderView(this.fTL.bhn());
                this.fTT.addHeaderView(this.fTL.bhn(), 1);
                if (dVar.bau().Ao() != null) {
                    this.fTT.removeHeaderView(this.fTL.bho());
                    this.fTT.removeHeaderView(this.fTX);
                    this.fTT.addHeaderView(this.fTL.bho(), 2);
                } else {
                    if (this.fTL.bho() != null) {
                        this.fTT.removeHeaderView(this.fTL.bho());
                    }
                    this.fTT.removeHeaderView(this.fTX);
                    this.fTX.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.t(this.fNb, d.e.tbds56));
                    this.fTT.addHeaderView(this.fTX, 2);
                }
                if (this.fTJ != null) {
                    this.fTP.kV(false);
                    this.fTP.kX(TbadkCoreApplication.isLogin());
                    this.fTJ.tj(TbadkCoreApplication.getInst().getSkinType());
                }
                bfp();
            } else {
                this.fVN = false;
                this.fTP.lb(this.fVN);
                if (this.fTJ != null) {
                    this.fTT.removeHeaderView(this.fTJ.bhy());
                }
                if (this.fTL != null) {
                    this.fTL.b(this.fTT);
                }
                if (b == null || (b != null && (b.bwX() == null || com.baidu.tbadk.core.util.v.E(b.bwX().Ri())))) {
                    this.fTX.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.t(this.fNb, d.e.tbds80));
                } else {
                    this.fTX.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fNb.bbQ() != null) {
                this.fNb.bbQ().kT(this.fVN);
            }
            if (this.fTJ != null) {
                this.fTJ.I(this.fWo);
            }
            if (b != null) {
                this.fVj = b;
                this.fTZ.setVisibility(0);
                if (this.fNb.bcA()) {
                    if (dVar.bat() != null) {
                        this.mForumName = dVar.bat().getForumName();
                        this.mForumId = dVar.bat().getForumId();
                    }
                    if (this.mForumName == null && this.fNb.bbA() != null && this.fNb.bbA().bdl() != null) {
                        this.mForumName = this.fNb.bbA().bdl();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fTZ.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fTZ.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fWd) {
                    this.fTV.setVisibility(0);
                }
                if (!dVar.bau().Aa() && this.fTW.getText() != null && this.fTW.getText().length() > 0) {
                    this.fTW.setVisibility(0);
                } else {
                    this.fTW.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> zz = dVar.bau().zz();
                if (zz != null && zz.size() > 0 && !this.fWd) {
                    this.fVm.setText(String.valueOf(zz.get(0).xH()));
                    this.fVl.setVisibility(0);
                } else {
                    this.fVl.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.s(this.fVl, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.e(this.fVm, d.C0140d.cp_link_tip_d, 1);
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
                            if (this.fOj != null) {
                                this.fOj.setTag(d.g.tag_user_id, b.zn().getUserId());
                                this.fOj.setOnClickListener(this.fNb.fLf.fYa);
                                this.fOj.a(iconInfo, 4, this.fNb.getResources().getDimensionPixelSize(d.e.tbds36), this.fNb.getResources().getDimensionPixelSize(d.e.tbds36), this.fNb.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fOi != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fOi.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fOi.setOnClickListener(this.fNb.fLf.fYb);
                                this.fOi.a(tShowInfoNew, 3, this.fNb.getResources().getDimensionPixelSize(d.e.tbds36), this.fNb.getResources().getDimensionPixelSize(d.e.tbds36), this.fNb.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fUb.setText(af(b.zn().getSealPrefix(), e));
                            this.fUb.setTag(d.g.tag_user_id, b.zn().getUserId());
                            this.fUb.setTag(d.g.tag_user_name, b.zn().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew) || b.zn().isBigV()) {
                                com.baidu.tbadk.core.util.aj.e(this.fUb, d.C0140d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.e(this.fUb, d.C0140d.cp_cont_f, 1);
                            }
                            this.fUc.setVisibility(8);
                            if (dVar.bau().zn() != null && dVar.bau().zn().getAlaUserData() != null && this.fUh != null) {
                                if (dVar.bau().zn().getAlaUserData().anchor_live != 0) {
                                    this.fUh.setVisibility(8);
                                } else {
                                    this.fUh.setVisibility(0);
                                    if (this.fTM == null) {
                                        this.fTM = new com.baidu.tieba.d.c(this.fNb.getPageContext(), this.fUh);
                                        this.fTM.lU(1);
                                    }
                                    this.fTM.aK(this.fNb.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aHe = dVar.bau().zn().getAlaUserData();
                                    aVar.type = 2;
                                    this.fUh.setTag(aVar);
                                }
                            }
                            this.fUg.setUserId(b.zn().getUserId());
                            this.fUg.setUserName(b.zn().getUserName());
                            this.fUg.setImageDrawable(null);
                            this.fUg.setRadius(com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds40));
                            this.fUg.setTag(b.zn().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fUp.setText(com.baidu.tbadk.core.util.am.A(b.getTime()));
                            } else {
                                this.fUp.setText(com.baidu.tbadk.core.util.am.z(b.getTime()));
                            }
                            t = com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds16);
                            if (!this.fNb.bcA() && !StringUtils.isNull(this.mForumName)) {
                                this.bey.setText(this.fNb.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.bey.setVisibility(0);
                                this.fUs.setVisibility(0);
                                this.fUp.setPadding(t, 0, t, 0);
                            } else {
                                this.bey.setVisibility(8);
                                this.fUs.setVisibility(8);
                                this.fUp.setPadding(0, 0, t, 0);
                            }
                            bwY = b.bwY();
                            if (bwY == null && !TextUtils.isEmpty(bwY.getName()) && !TextUtils.isEmpty(bwY.getName().trim())) {
                                final String name = bwY.getName();
                                final String lat = bwY.getLat();
                                final String lng = bwY.getLng();
                                this.fUq.setVisibility(0);
                                this.fUr.setVisibility(0);
                                this.fUq.setText(bwY.getName());
                                this.fUq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.oJ()) {
                                                ar.this.fNb.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.b.R(ar.this.fNb.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, ar.this.fNb.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fUq.setVisibility(8);
                                this.fUr.setVisibility(8);
                            }
                            portrait = b.zn().getPortrait();
                            if (b.zn().getPendantData() == null && !StringUtils.isNull(b.zn().getPendantData().ya())) {
                                UtilHelper.showHeadImageViewBigV(this.fUe.getHeadView(), b.zn());
                                this.fUg.setVisibility(8);
                                this.fUe.setVisibility(0);
                                if (this.fUk != null) {
                                    this.fUk.setVisibility(8);
                                }
                                this.fUb.setOnClickListener(this.fWo);
                                this.fUe.getHeadView().startLoad(portrait, 28, false);
                                this.fUe.getHeadView().setUserId(b.zn().getUserId());
                                this.fUe.getHeadView().setUserName(b.zn().getUserName());
                                this.fUe.getHeadView().setOnClickListener(this.fWo);
                                this.fUe.eS(b.zn().getPendantData().ya());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fUg, b.zn());
                                this.fUg.setVisibility(0);
                                this.fTZ.setOnClickListener(this.fWo);
                                this.fUb.setOnClickListener(this.fWo);
                                this.fUg.setOnClickListener(this.fWo);
                                this.fUe.setVisibility(8);
                                this.fUg.startLoad(portrait, 28, false);
                            }
                            String name_show = b.zn().getName_show();
                            String userName = b.zn().getUserName();
                            if (com.baidu.tbadk.o.af.nv() && name_show != null && !name_show.equals(userName)) {
                                this.fUb.setText(com.baidu.tieba.pb.c.am(this.fNb.getPageContext().getPageActivity(), this.fUb.getText().toString()));
                                this.fUb.setGravity(16);
                                this.fUb.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bab());
                                com.baidu.tbadk.core.util.aj.e(this.fUb, d.C0140d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.zn().getIconInfo();
                        tShowInfoNew = b.zn().getTShowInfoNew();
                        if (this.fOj != null) {
                        }
                        if (this.fOi != null) {
                        }
                        this.fUb.setText(af(b.zn().getSealPrefix(), e));
                        this.fUb.setTag(d.g.tag_user_id, b.zn().getUserId());
                        this.fUb.setTag(d.g.tag_user_name, b.zn().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fUb, d.C0140d.cp_cont_h, 1);
                        this.fUc.setVisibility(8);
                        if (dVar.bau().zn() != null) {
                            if (dVar.bau().zn().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fUg.setUserId(b.zn().getUserId());
                        this.fUg.setUserName(b.zn().getUserName());
                        this.fUg.setImageDrawable(null);
                        this.fUg.setRadius(com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds40));
                        this.fUg.setTag(b.zn().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        t = com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds16);
                        if (!this.fNb.bcA()) {
                        }
                        this.bey.setVisibility(8);
                        this.fUs.setVisibility(8);
                        this.fUp.setPadding(0, 0, t, 0);
                        bwY = b.bwY();
                        if (bwY == null) {
                        }
                        this.fUq.setVisibility(8);
                        this.fUr.setVisibility(8);
                        portrait = b.zn().getPortrait();
                        if (b.zn().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fUg, b.zn());
                        this.fUg.setVisibility(0);
                        this.fTZ.setOnClickListener(this.fWo);
                        this.fUb.setOnClickListener(this.fWo);
                        this.fUg.setOnClickListener(this.fWo);
                        this.fUe.setVisibility(8);
                        this.fUg.startLoad(portrait, 28, false);
                        String name_show2 = b.zn().getName_show();
                        String userName2 = b.zn().getUserName();
                        if (com.baidu.tbadk.o.af.nv()) {
                            this.fUb.setText(com.baidu.tieba.pb.c.am(this.fNb.getPageContext().getPageActivity(), this.fUb.getText().toString()));
                            this.fUb.setGravity(16);
                            this.fUb.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bab());
                            com.baidu.tbadk.core.util.aj.e(this.fUb, d.C0140d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aX(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.zn().getIconInfo();
                            tShowInfoNew = b.zn().getTShowInfoNew();
                            if (this.fOj != null) {
                            }
                            if (this.fOi != null) {
                            }
                            this.fUb.setText(af(b.zn().getSealPrefix(), e));
                            this.fUb.setTag(d.g.tag_user_id, b.zn().getUserId());
                            this.fUb.setTag(d.g.tag_user_name, b.zn().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.e(this.fUb, d.C0140d.cp_cont_h, 1);
                            this.fUc.setVisibility(8);
                            if (dVar.bau().zn() != null) {
                            }
                            this.fUg.setUserId(b.zn().getUserId());
                            this.fUg.setUserName(b.zn().getUserName());
                            this.fUg.setImageDrawable(null);
                            this.fUg.setRadius(com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds40));
                            this.fUg.setTag(b.zn().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            t = com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds16);
                            if (!this.fNb.bcA()) {
                            }
                            this.bey.setVisibility(8);
                            this.fUs.setVisibility(8);
                            this.fUp.setPadding(0, 0, t, 0);
                            bwY = b.bwY();
                            if (bwY == null) {
                            }
                            this.fUq.setVisibility(8);
                            this.fUr.setVisibility(8);
                            portrait = b.zn().getPortrait();
                            if (b.zn().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fUg, b.zn());
                            this.fUg.setVisibility(0);
                            this.fTZ.setOnClickListener(this.fWo);
                            this.fUb.setOnClickListener(this.fWo);
                            this.fUg.setOnClickListener(this.fWo);
                            this.fUe.setVisibility(8);
                            this.fUg.startLoad(portrait, 28, false);
                            String name_show22 = b.zn().getName_show();
                            String userName22 = b.zn().getUserName();
                            if (com.baidu.tbadk.o.af.nv()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.zn().getIconInfo();
                        tShowInfoNew = b.zn().getTShowInfoNew();
                        if (this.fOj != null) {
                        }
                        if (this.fOi != null) {
                        }
                        this.fUb.setText(af(b.zn().getSealPrefix(), e));
                        this.fUb.setTag(d.g.tag_user_id, b.zn().getUserId());
                        this.fUb.setTag(d.g.tag_user_name, b.zn().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fUb, d.C0140d.cp_cont_h, 1);
                        this.fUc.setVisibility(8);
                        if (dVar.bau().zn() != null) {
                        }
                        this.fUg.setUserId(b.zn().getUserId());
                        this.fUg.setUserName(b.zn().getUserName());
                        this.fUg.setImageDrawable(null);
                        this.fUg.setRadius(com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds40));
                        this.fUg.setTag(b.zn().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        t = com.baidu.adp.lib.util.l.t(this.fNb.getActivity(), d.e.ds16);
                        if (!this.fNb.bcA()) {
                        }
                        this.bey.setVisibility(8);
                        this.fUs.setVisibility(8);
                        this.fUp.setPadding(0, 0, t, 0);
                        bwY = b.bwY();
                        if (bwY == null) {
                        }
                        this.fUq.setVisibility(8);
                        this.fUr.setVisibility(8);
                        portrait = b.zn().getPortrait();
                        if (b.zn().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fUg, b.zn());
                        this.fUg.setVisibility(0);
                        this.fTZ.setOnClickListener(this.fWo);
                        this.fUb.setOnClickListener(this.fWo);
                        this.fUg.setOnClickListener(this.fWo);
                        this.fUe.setVisibility(8);
                        this.fUg.startLoad(portrait, 28, false);
                        String name_show222 = b.zn().getName_show();
                        String userName222 = b.zn().getUserName();
                        if (com.baidu.tbadk.o.af.nv()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fTY.Z(dVar.bau());
                }
                if (this.fVu != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHS);
                    if (dVar != null && dVar.bau() != null) {
                        hVar.fHU = dVar.bau().zf();
                    }
                    hVar.isNew = !this.fIO;
                    hVar.fHW = this.fNb.bcz();
                    this.fVu.a(hVar);
                }
            }
        }
    }

    public void kH(boolean z) {
        if (z) {
            bfl();
        } else {
            bfm();
        }
        this.fVy.fWG = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVy));
        a(this.fVy.fWG, false);
    }

    public void bfl() {
        if (this.fTP != null && !this.fVP) {
            this.fTP.lc(!StringUtils.isNull(this.fNb.bbY()));
            this.fVP = true;
        }
    }

    public void bfm() {
        if (this.fTP != null) {
            this.fTP.bgo();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.zJ() != null) {
            this.fUa.a(this.fNb.getPageContext(), dVar.baw().get(0).zJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.bas().getId(), dVar.bas().getName(), dVar.bau().getId(), this.fNb.bcw() ? "FRS" : null));
            this.fTZ.setPadding(this.fTZ.getPaddingLeft(), (int) this.fNb.getResources().getDimension(d.e.ds20), this.fTZ.getPaddingRight(), this.fTZ.getPaddingBottom());
            return;
        }
        this.fUa.a(null, null, null);
    }

    public void bfn() {
        if (this.fTJ != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").s("obj_type", 1));
            this.fTJ.bhx();
            this.fTT.smoothScrollToPosition(0);
        }
    }

    public boolean bfo() {
        return this.fWp;
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
            this.fTP.bgm();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fTP.ol(cVar.forumName);
            }
            String string = this.fNb.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.h(cVar.source, 0)) {
                case 100:
                    str = this.fNb.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.fNb.getResources().getString(d.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fNb.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fHd;
            this.fNb.showNetRefreshView(this.dpw, format, null, this.fNb.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.pa()) {
                        com.baidu.tbadk.core.util.aw.Du().c(ar.this.fNb.getPageContext(), new String[]{str2});
                        ar.this.fNb.finish();
                        return;
                    }
                    ar.this.fNb.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bev;
        Parcelable bev2;
        String str;
        if (dVar != null) {
            this.fQj = dVar;
            this.mType = i;
            if (dVar.bau() != null) {
                this.fVA = dVar.bau().yY();
                if (dVar.bau().getAnchorLevel() != 0) {
                    this.fWp = true;
                }
                this.fUW = ab(dVar.bau());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fVk = false;
            this.fIO = z;
            bfh();
            b(dVar, z, i);
            p(dVar);
            if (this.fWb == null) {
                this.fWb = new ab(this.fNb.getPageContext(), this.dWc);
            }
            this.fWb.qv(dVar.baz());
            if (this.fNb.bcn()) {
                if (this.fUE == null) {
                    this.fUE = new com.baidu.tieba.pb.view.h(this.fNb.getPageContext());
                    this.fUE.st();
                    this.fUE.a(this.bcR);
                }
                this.fTT.setPullRefresh(this.fUE);
                bfp();
                if (this.fUE != null) {
                    this.fUE.gx(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.yA().yx() == 0 && z) {
                this.fTT.setPullRefresh(null);
            } else {
                if (this.fUE == null) {
                    this.fUE = new com.baidu.tieba.pb.view.h(this.fNb.getPageContext());
                    this.fUE.st();
                    this.fUE.a(this.bcR);
                }
                this.fTT.setPullRefresh(this.fUE);
                bfp();
                if (this.fUE != null) {
                    this.fUE.gx(TbadkCoreApplication.getInst().getSkinType());
                }
                agg();
            }
            bfs();
            this.fUA.jQ(this.fIO);
            this.fUA.jR(false);
            this.fUA.kc(i == 5);
            this.fUA.kd(i == 6);
            this.fUA.ke(z2 && this.fWn);
            this.fUA.a(dVar, false);
            this.fUA.notifyDataSetChanged();
            if (this.fNb.bcA()) {
                this.fVR = 0;
                PostData b = b(dVar, z);
                if (b != null && b.zn() != null) {
                    this.fVR = b.zn().getLevel_id();
                }
                if (this.fVR > 0) {
                    this.fUd.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.fUd, BitmapHelper.getGradeResourceIdInEnterForum(this.fVR));
                } else {
                    this.fUd.setVisibility(8);
                }
            } else {
                this.fUd.setVisibility(8);
            }
            if (dVar.bau() != null) {
                if (dVar.bau().zc() != null) {
                    if (dVar.bau().zc().getNum() < 1) {
                        str = this.fNb.getResources().getString(d.j.zan);
                    } else {
                        str = dVar.bau().zc().getNum() + "";
                    }
                    if (this.fTI != -1) {
                        dVar.bau().zc().setIsLike(this.fTI);
                    }
                    R(str, dVar.bau().zc().getIsLike() == 1);
                }
                if (dVar.bau().aQw != null && dVar.bau().aQw.isDeleted) {
                    this.fTP.kW(true);
                } else {
                    this.fTP.kW(false);
                }
            }
            if (this.fNb.isLogin()) {
                this.fTT.setNextPage(this.dIU);
                this.fTO = 2;
                agg();
            } else {
                this.fVk = true;
                if (dVar.yA().yw() == 1) {
                    if (this.fUF == null) {
                        this.fUF = new com.baidu.tieba.pb.view.b(this.fNb.getPageContext());
                    }
                    this.fTT.setNextPage(this.fUF);
                } else {
                    this.fTT.setNextPage(this.dIU);
                }
                this.fTO = 3;
            }
            ArrayList<PostData> baw = dVar.baw();
            if (dVar.yA().yw() == 0 || baw == null || baw.size() < dVar.yA().yv()) {
                if (com.baidu.tbadk.core.util.v.D(baw) == 0 || (com.baidu.tbadk.core.util.v.D(baw) == 1 && baw.get(0) != null && baw.get(0).bwU() == 1)) {
                    this.dIU.setText(this.fNb.getResources().getString(d.j.list_no_more_new));
                    if (this.fNb.bbQ() != null && !this.fNb.bbQ().bgd()) {
                        this.fNb.bbQ().showFloatingView();
                    }
                } else {
                    this.dIU.setText(this.fNb.getResources().getString(d.j.list_has_no_more));
                }
                if (this.fNb.bcn() && this.fTT != null && this.fTT.getData() != null && this.fTT.getData().size() == 1 && (this.fTT.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dIU.setText("");
                }
                bfz();
            } else if (z2) {
                if (this.fWn) {
                    Eh();
                    if (dVar.yA().yw() != 0) {
                        this.dIU.setText(this.fNb.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.dIU.Ec();
                    this.dIU.showLoading();
                }
            } else {
                this.dIU.Ec();
                this.dIU.showLoading();
            }
            switch (i) {
                case 2:
                    this.fTT.setSelection(i2 > 1 ? (((this.fTT.getData() == null && dVar.baw() == null) ? 0 : (this.fTT.getData().size() - dVar.baw().size()) + this.fTT.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bev2 = ai.beu().bev()) != null) {
                        this.fTT.onRestoreInstanceState(bev2);
                        if (com.baidu.tbadk.core.util.v.D(baw) > 1 && dVar.yA().yw() > 0) {
                            this.dIU.Eh();
                            this.dIU.setText(this.fNb.getString(d.j.pb_load_more_without_point));
                            this.dIU.Ed();
                            break;
                        }
                    } else {
                        this.fTT.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fWn = false;
                    break;
                case 5:
                    this.fTT.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bev = ai.beu().bev()) != null) {
                        this.fTT.onRestoreInstanceState(bev);
                        break;
                    } else {
                        this.fTT.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fTJ != null && this.fTJ.bhw() != null) {
                            if (this.fNb.isUseStyleImmersiveSticky()) {
                                this.fTT.setSelectionFromTop((this.fUA.bcP() + this.fTT.getHeaderViewsCount()) - 1, this.fTJ.bhw().getHeight() - com.baidu.adp.lib.util.l.p(this.fNb.getPageContext().getPageActivity()));
                            } else {
                                this.fTT.setSelectionFromTop((this.fUA.bcP() + this.fTT.getHeaderViewsCount()) - 1, this.fTJ.bhw().getHeight());
                            }
                        } else {
                            this.fTT.setSelection(this.fUA.bcP() + this.fTT.getHeaderViewsCount());
                        }
                    } else {
                        this.fTT.setSelection(i2 > 0 ? ((this.fTT.getData() == null && dVar.baw() == null) ? 0 : (this.fTT.getData().size() - dVar.baw().size()) + this.fTT.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dIU.Eh();
                    this.dIU.setText(this.fNb.getString(d.j.pb_load_more_without_point));
                    this.dIU.Ed();
                    break;
            }
            if (this.fVA == fVB && isHost()) {
                bfH();
            }
            if (this.fVL) {
                beG();
                this.fVL = false;
                if (i3 == 0) {
                    kA(true);
                }
            }
            if (this.fTL != null) {
                this.fTL.ag(dVar.bau());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fHJ == 1 || dVar.fHK == 1) {
                if (this.fVS == null) {
                    this.fVS = new PbTopTipView(this.fNb);
                }
                if (dVar.fHK == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fNb.getStType())) {
                    this.fVS.setText(this.fNb.getString(d.j.pb_read_strategy_add_experience));
                    this.fVS.show(this.dpw, this.mSkinType);
                } else if (dVar.fHJ == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fNb.getStType())) {
                    this.fVS.setText(this.fNb.getString(d.j.pb_read_news_add_experience));
                    this.fVS.show(this.dpw, this.mSkinType);
                }
            }
        }
    }

    private void bfp() {
        if (this.fTJ != null && this.fTJ.bhw() != null) {
            this.fTT.removeHeaderView(this.boL);
            if (this.mType != 1) {
                this.fTT.removeHeaderView(this.fTJ.bhy());
                this.fTT.addHeaderView(this.fTJ.bhy(), 0);
                return;
            }
            return;
        }
        if (this.fTJ != null) {
            this.fTT.removeHeaderView(this.fTJ.bhy());
        }
        this.fTT.removeHeaderView(this.boL);
        this.fTT.addHeaderView(this.boL, 0);
    }

    public void kI(boolean z) {
        this.fUV = z;
    }

    public void Eh() {
        if (this.dIU != null) {
            this.dIU.Ed();
            this.dIU.Eh();
        }
        agg();
    }

    public void aik() {
        this.fTT.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fVj != null && this.fVj.zn() != null && this.fTP != null) {
            this.fVO = !this.fVN;
            this.fTP.kV(this.fVO);
            if (this.fNb.bbQ() != null) {
                this.fNb.bbQ().kU(this.fVO);
            }
            bfq();
            if (this.fVO) {
                this.fTP.fYO.setVisibility(0);
                if (this.fUW) {
                    this.fTP.fYP.setVisibility(8);
                    this.fUl.setVisibility(8);
                    this.fUo.setVisibility(0);
                    this.fUo.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(dVar.baP())));
                } else if (!PbNormalLikeButtonSwitchStatic.OP() || (this.fVj.zn().hadConcerned() && this.fVj.zn().getGodUserData() != null && this.fVj.zn().getGodUserData().getIsFromNetWork())) {
                    this.fTP.fYP.setVisibility(8);
                }
                if (this.fVt != null) {
                    this.fVt.setVisibility(8);
                }
                this.fTP.a(this.fVj.zn(), this.fWo);
                if (this.fVZ == null) {
                    this.fVZ = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fVQ) {
                                ar.this.bfG();
                            }
                        }
                    };
                }
                this.fTT.setListViewDragListener(this.fVZ);
                return;
            }
            if (this.fTP.fYO != null) {
                this.fTP.fYO.setVisibility(8);
            }
            if (this.fVt != null) {
                this.fVt.setVisibility(0);
            }
            if (this.fUW) {
                this.fUl.setVisibility(8);
                this.fUo.setVisibility(0);
                this.fUo.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(dVar.baP())));
            } else if (!PbNormalLikeButtonSwitchStatic.OP() || (this.fVj.zn().hadConcerned() && this.fVj.zn().getGodUserData() != null && this.fVj.zn().getGodUserData().getIsFromNetWork())) {
                this.fUl.setVisibility(8);
                this.fUo.setVisibility(8);
            } else {
                this.fUo.setVisibility(8);
            }
            this.fVZ = null;
            this.fTT.setListViewDragListener(null);
        }
    }

    private void bfq() {
        String threadId = this.fQj != null ? this.fQj.getThreadId() : "";
        int bfr = bfr();
        if (this.fVO) {
            if (this.fUn == null) {
                this.fUn = new ap(this.fNb.getPageContext(), this.fTP.fYP, 3);
                this.fUn.h(this.fNb.getUniqueId());
            }
            if (this.fVj != null && this.fVj.zn() != null) {
                this.fVj.zn().setIsLike(this.fVj.zn().hadConcerned());
                this.fUn.a(this.fVj.zn());
            }
            this.fUn.cV(threadId);
            this.fUn.ta(bfr);
            this.fUn.fTE = this.fVN;
        }
        if (this.fUm == null) {
            this.fUm = new ap(this.fNb.getPageContext(), this.fUl, 1);
            this.fUm.h(this.fNb.getUniqueId());
            this.fUm.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bA(boolean z) {
                    if (ar.this.fNb != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fNb, d.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fNb.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fVj != null && this.fVj.zn() != null) {
            this.fVj.zn().setIsLike(this.fVj.zn().hadConcerned());
            this.fUm.a(this.fVj.zn());
            this.fUm.cV(threadId);
        }
        this.fUm.fTE = this.fVN;
        this.fUm.ta(bfr);
    }

    private int bfr() {
        if (this.fQj == null || this.fQj.bau() == null) {
            return 0;
        }
        if (this.fQj.bau().Aw()) {
            return (com.baidu.tbadk.core.util.v.E(this.fQj.baO()) && (this.fQj.bat() == null || StringUtils.isNull(this.fQj.bat().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bfs() {
        boolean z;
        if (this.fUZ != null && this.fUZ.getVisibility() == 0) {
            if (this.fUw != null) {
                this.fUw.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fUw != null) {
                this.fUw.setVisibility(8);
            }
            z = false;
        }
        if ((this.fUy == null || this.fUy.getVisibility() == 8) && z && this.fIO) {
            this.fUx.setVisibility(0);
        } else {
            this.fUx.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bau() == null) {
            return false;
        }
        if (dVar.bau().zk() == 1 || dVar.bau().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bau().zm() == null || dVar.bau().zm().AI() == 0) || dVar.bau().zi() == 1 || dVar.bau().zj() == 1 || dVar.bau().zS() || dVar.bau().Ad() || dVar.bau().zZ() || dVar.bau().zA() != null || !com.baidu.tbadk.core.util.am.isEmpty(dVar.bau().getCategory()) || dVar.bau().zr() || dVar.bau().zq();
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str));
            return com.baidu.tieba.card.j.a((Context) this.fNb.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fTV != null) {
                if (dVar.bau() != null && dVar.bau().zD() == 0 && !dVar.bau().Aa() && !this.fWd) {
                    this.fTV.setVisibility(0);
                    if (dVar.bau() != null) {
                        dVar.bau().h(true, q(dVar));
                    }
                    SpannableStringBuilder zN = dVar.bau().zN();
                    this.fTW.setOnTouchListener(new com.baidu.tieba.view.m(zN));
                    if (this.fWa) {
                        this.fTW.setText(dVar.bau().getTitle());
                    } else {
                        this.fTW.setText(zN);
                    }
                    this.fTW.setVisibility(0);
                } else if (dVar.bau().zD() == 1) {
                    if (dVar.bau() != null) {
                        this.fTV.setVisibility(8);
                        this.fTT.removeHeaderView(this.fTV);
                        if (dVar.bau() != null && !dVar.bau().Aa()) {
                            this.fTZ.setPadding(this.fTZ.getPaddingLeft(), com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.tbds36), this.fTZ.getPaddingRight(), this.fTZ.getPaddingBottom());
                        }
                    }
                } else {
                    this.fTV.setVisibility(8);
                    this.fTT.removeHeaderView(this.fTV);
                    if (dVar.bau() != null && dVar.bau().Aa()) {
                        this.fTZ.setPadding(this.fTZ.getPaddingLeft(), 0, this.fTZ.getPaddingRight(), this.fTZ.getPaddingBottom());
                    } else {
                        this.fTZ.setPadding(this.fTZ.getPaddingLeft(), com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds48), this.fTZ.getPaddingRight(), this.fTZ.getPaddingBottom());
                    }
                }
            }
            this.fIO = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bfs();
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
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.baG()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.zn() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.zn().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.baG()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<ay> baO = dVar.baO();
                if (com.baidu.tbadk.core.util.v.D(baO) > 0) {
                    sb = new StringBuilder();
                    for (ay ayVar : baO) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aOl) != null && tVar.aMt && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fNb.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fNb.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bzv;
    }

    public void qw(String str) {
        if (this.dIU != null) {
            this.dIU.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fTT;
    }

    public int bft() {
        return d.g.richText;
    }

    public TextView bbL() {
        return this.fTY.bbL();
    }

    public void d(BdListView.e eVar) {
        this.fTT.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.bcR = bVar;
        if (this.fUE != null) {
            this.fUE.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int yu = alVar.yu();
            int yr = alVar.yr();
            if (this.fUB != null) {
                this.fUB.AU();
            } else {
                this.fUB = new com.baidu.tbadk.core.dialog.a(this.fNb.getPageContext().getPageActivity());
                this.fUC = LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fUB.aO(this.fUC);
                this.fUB.a(d.j.dialog_ok, bVar);
                this.fUB.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bfv();
                        aVar.dismiss();
                    }
                });
                this.fUB.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fVI == null) {
                            ar.this.fVI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fNb.HidenSoftKeyPad((InputMethodManager) ar.this.fNb.getSystemService("input_method"), ar.this.dpw);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.ns().postDelayed(ar.this.fVI, 150L);
                    }
                });
                this.fUB.b(this.fNb.getPageContext()).AU();
            }
            this.fUD = (EditText) this.fUC.findViewById(d.g.input_page_number);
            this.fUD.setText("");
            TextView textView = (TextView) this.fUC.findViewById(d.g.current_page_number);
            if (yu <= 0) {
                yu = 1;
            }
            if (yr <= 0) {
                yr = 1;
            }
            textView.setText(MessageFormat.format(this.fNb.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(yu), Integer.valueOf(yr)));
            this.fNb.ShowSoftKeyPadDelay(this.fUD, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fTT.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fNb.showToast(str);
    }

    public boolean kJ(boolean z) {
        if (this.axP == null || !this.axP.Lf()) {
            return false;
        }
        this.axP.Jm();
        return true;
    }

    public void bfu() {
        if (this.fWq != null) {
            while (this.fWq.size() > 0) {
                TbImageView remove = this.fWq.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bfu();
        this.fUA.sM(1);
        if (this.fTJ != null) {
            this.fTJ.onPause();
        }
    }

    public void onResume() {
        this.fUA.sM(2);
        if (this.fTJ != null) {
            this.fTJ.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fVK != null) {
            this.fVK.destroy();
        }
        if (this.fWb != null) {
            this.fWb.onDestory();
        }
        if (this.fVS != null) {
            this.fVS.hide();
        }
        if (this.fTM != null) {
            this.fTM.anh();
        }
        if (this.fTL != null) {
            this.fTL.onDestroy();
        }
        this.fNb.hideProgressBar();
        if (this.dpu != null && this.dCE != null) {
            this.dpu.b(this.dCE);
        }
        bfv();
        Eh();
        if (this.fVI != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fVI);
        }
        if (this.fTZ != null && this.fUk != null) {
            this.fTZ.removeView(this.fUf);
            this.fUk = null;
        }
        if (this.fVo != null) {
            this.fVo.clearStatus();
        }
        this.fWj = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fUA.sM(3);
        if (this.dGq != null) {
            this.dGq.setBackgroundDrawable(null);
        }
        if (this.fTJ != null) {
            this.fTJ.destroy();
        }
        if (this.fUA != null) {
            this.fUA.onDestroy();
        }
        this.fTT.setOnLayoutListener(null);
        if (this.fVX != null) {
            this.fVX.awP();
        }
        if (this.fVz != null) {
            this.fVz.onDestroy();
        }
        bfQ();
    }

    public boolean td(int i) {
        if (this.fTJ != null) {
            return this.fTJ.nc(i);
        }
        return false;
    }

    public void bfv() {
        this.fTP.wH();
        if (this.fTM != null) {
            this.fTM.anh();
        }
        com.baidu.adp.lib.util.l.a(this.fNb.getPageContext().getPageActivity(), this.fUD);
        beI();
        if (this.fUT != null) {
            this.fUT.dismiss();
        }
        bfx();
        if (this.fTL != null) {
            this.fTL.bhp();
        }
        if (this.fUB != null) {
            this.fUB.dismiss();
        }
        if (this.dGc != null) {
            this.dGc.dismiss();
        }
    }

    public void bfw() {
        this.fTP.wH();
        if (this.fTM != null) {
            this.fTM.anh();
        }
        if (this.fUT != null) {
            this.fUT.dismiss();
        }
        bfx();
        if (this.fTL != null) {
            this.fTL.bhp();
        }
        if (this.fUB != null) {
            this.fUB.dismiss();
        }
        if (this.dGc != null) {
            this.dGc.dismiss();
        }
    }

    public void cW(List<String> list) {
        this.fVW = list;
        if (this.fVX != null) {
            this.fVX.setData(list);
        }
    }

    public void jP(boolean z) {
        this.fUA.jP(z);
    }

    public void kK(boolean z) {
        this.fUY = z;
    }

    public void bfx() {
        if (this.fUK != null) {
            this.fUK.dismiss();
        }
        if (this.fUL != null) {
            com.baidu.adp.lib.g.g.b(this.fUL, this.fNb.getPageContext());
        }
        if (this.fUM != null) {
            com.baidu.adp.lib.g.g.b(this.fUM, this.fNb.getPageContext());
        }
        if (this.fUI != null) {
            com.baidu.adp.lib.g.g.b(this.fUI, this.fNb.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fQj, this.fIO);
            d(this.fQj, this.fIO, this.mType);
            this.fNb.getLayoutMode().aQ(i == 1);
            this.fNb.getLayoutMode().aM(this.dpw);
            this.fNb.getLayoutMode().aM(this.fTU);
            com.baidu.tbadk.core.util.aj.s(this.fTX, d.C0140d.cp_bg_line_d);
            if (this.fTL != null) {
                this.fTL.onChangeSkinType(i);
            }
            if (this.fTW != null) {
                com.baidu.tbadk.core.util.aj.r(this.fTW, d.C0140d.cp_cont_b);
                this.fTW.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_link_tip_c));
            }
            if (this.dIU != null) {
                this.dIU.gx(i);
                if (this.bzv != null) {
                    this.fNb.getLayoutMode().aM(this.bzv);
                    com.baidu.tbadk.core.util.aj.s(this.bzv, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fUB != null) {
                this.fUB.c(this.fNb.getPageContext());
            }
            kI(this.fUV);
            this.fUA.notifyDataSetChanged();
            if (this.fUE != null) {
                this.fUE.gx(i);
            }
            if (this.axP != null) {
                this.axP.onChangeSkinType(i);
            }
            if (this.fUj != null) {
                this.fUj.gB(i);
            }
            if (this.fUF != null) {
                this.fUF.gx(i);
            }
            if (!com.baidu.tbadk.core.util.v.E(this.cZo)) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.cZo) {
                    aVar.DQ();
                }
            }
            kE(i == 1);
            beW();
            UtilHelper.setStatusBarBackground(this.dGq, i);
            UtilHelper.setStatusBarBackground(this.fVt, i);
            if (this.fUl != null) {
                this.fUl.onChangeSkinType(i);
            }
            if (this.fUq != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUq, d.C0140d.cp_cont_d);
            }
            if (this.fUp != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUp, d.C0140d.cp_cont_d);
            }
            if (this.fUr != null) {
                com.baidu.tbadk.core.util.aj.s(this.fUr, d.C0140d.cp_cont_e);
            }
            if (this.bey != null) {
                com.baidu.tbadk.core.util.aj.r(this.bey, d.C0140d.cp_cont_d);
            }
            if (this.fUs != null) {
                com.baidu.tbadk.core.util.aj.s(this.fUs, d.C0140d.cp_cont_e);
            }
            if (this.fUc != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUc, d.C0140d.cp_link_tip_a);
            }
            if (this.fUo != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUo, d.C0140d.cp_cont_d);
            }
            if (this.fUt != null) {
                com.baidu.tbadk.n.a.a(this.fNb.getPageContext(), this.fUt);
            }
            if (this.fUR != null) {
                com.baidu.tbadk.n.a.a(this.fNb.getPageContext(), this.fUR);
            }
            if (this.fVJ != null) {
                this.fVJ.onChangeSkinType(i);
            }
            if (this.fTP != null) {
                if (this.fTJ != null) {
                    this.fTJ.tj(i);
                } else {
                    this.fTP.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fVb != null) {
                com.baidu.tbadk.core.util.aj.r(this.fVb, d.C0140d.cp_cont_e);
            }
            if (this.fUd != null) {
                com.baidu.tbadk.core.util.aj.c(this.fUd, BitmapHelper.getGradeResourceIdInEnterForum(this.fVR));
            }
            if (this.fVY != null) {
                this.fVY.onChangeSkinType(i);
            }
            if (this.fVz != null) {
                this.fVz.onChangeSkinType();
            }
            if (this.fVV != null) {
                com.baidu.tbadk.core.util.aj.r(this.fVV, d.C0140d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLS = hVar;
        this.fUA.setOnImageClickListener(this.bLS);
        this.fVY.setOnImageClickListener(this.bLS);
    }

    public void h(NoNetworkView.a aVar) {
        this.dCE = aVar;
        if (this.dpu != null) {
            this.dpu.a(this.dCE);
        }
    }

    public void kL(boolean z) {
        this.fUA.setIsFromCDN(z);
    }

    public Button bfy() {
        return this.fUZ;
    }

    public void bfz() {
        if (this.fTO != 2) {
            this.fTT.setNextPage(this.dIU);
            this.fTO = 2;
        }
    }

    public void bfA() {
        if (com.baidu.tbadk.k.p.Ow().Ox()) {
            int lastVisiblePosition = this.fTT.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fTT.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog = tbImageView.getPerfLog();
                                perfLog.ij(1001);
                                perfLog.bAA = true;
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
                        perfLog2.bAA = true;
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

    public boolean bfB() {
        return this.axP != null && this.axP.getVisibility() == 0;
    }

    public boolean bfC() {
        return this.axP != null && this.axP.Lf();
    }

    public void bfD() {
        if (this.axP != null) {
            this.axP.Jm();
        }
    }

    public void kM(boolean z) {
        if (this.fVa != null) {
            kK(this.fNb.bbM().LH());
            if (this.fUY) {
                kB(z);
            } else {
                kC(z);
            }
        }
    }

    public void bfE() {
        if (this.fVa != null) {
            this.fVa.setVisibility(8);
            this.fVf = false;
            if (this.fVz != null) {
                this.fVz.setVisibility(8);
                kG(false);
            }
            bfQ();
        }
    }

    public void showLoadingDialog() {
        if (this.dgK == null) {
            this.dgK = new com.baidu.tbadk.core.view.b(this.fNb.getPageContext());
        }
        this.dgK.bq(true);
    }

    public void agg() {
        if (this.dgK != null) {
            this.dgK.bq(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fTT.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fTT.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fTJ != null) {
            this.fTJ.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.flA = getScrollY();
            this.fVy.fWG = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVy));
            a(this.fVy.fWG, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fTJ != null) {
            this.fTJ.b(absListView, i);
        }
        int headerViewsCount = (i - this.fTT.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fUA.sL(headerViewsCount) == com.baidu.tieba.pb.data.j.fHZ) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fTT.getHeaderViewsCount();
        if (this.fTX != null && this.fTP != null) {
            this.fTP.j(this.fTX.getBottom(), this.fTX.getMeasuredHeight(), z2);
        }
        this.fUA.bcT().n(z, this.fVr != null ? this.fVr.getMeasuredHeight() : 0);
        this.fVy.fCQ = i;
        this.fVy.fWF = this.fTT.getHeaderViewsCount();
        this.fVy.fWG = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVy));
        a(this.fVy.fWG, false);
    }

    public void bfF() {
        if (this.fNb.isLogin() && this.fQj != null && this.fVO && !this.fVN && !this.fUW && this.fVj != null && this.fVj.zn() != null && !this.fVj.zn().getIsLike() && !this.fVj.zn().hadConcerned()) {
            if (this.fVK == null) {
                this.fVK = new am(this.fNb);
            }
            this.fVK.a(this.fTP.fYO, this.fQj.baS(), this.fVj.zn().getUserId(), this.fQj.getThreadId());
        }
    }

    public void bfG() {
        if (this.fVO && !this.fVN && this.fVj != null && this.fVj.zn() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").s("obj_locate", this.fNb.bcA() ? 2 : 1).s("obj_type", this.fVN ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fNb.getPageContext().getPageActivity(), this.fVj.zn().getUserId(), this.fVj.zn().getUserName(), this.fNb.bbA().bdl(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fVN && this.fVs != null && this.fTP.bgh() != null) {
            int bcQ = this.fUA.bcQ();
            if (bcQ > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (bcQ > this.fTT.getFirstVisiblePosition() - this.fTT.getHeaderViewsCount()) {
                    this.fVs.setVisibility(8);
                    return;
                }
                this.fVs.setVisibility(0);
                this.fTP.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fTc == null) {
                if (this.fTT.getFirstVisiblePosition() == 0) {
                    this.fVs.setVisibility(8);
                    this.fTP.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fVx) {
                        this.fVw = top;
                        this.fVx = false;
                    }
                    this.fVw = top < this.fVw ? top : this.fVw;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.fUz.getY() < 0.0f) {
                        measuredHeight = fVv - akVar.fTc.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fTP.bgh().getMeasuredHeight() - akVar.fTc.getMeasuredHeight();
                        this.fTP.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fVw) {
                        this.fVs.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fVs.setVisibility(0);
                    } else {
                        this.fVs.setVisibility(8);
                        this.fTP.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fVx = true;
                    }
                }
            }
        }
    }

    public void bfH() {
        if (!this.fWr) {
            TiebaStatic.log("c10490");
            this.fWr = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fNb.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fVC, Integer.valueOf(fVE));
            aVar.fa(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.aO(inflate);
            aVar.aE(sparseArray);
            aVar.a(d.j.grade_button_tips, this.fNb);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fNb.getPageContext()).AU();
        }
    }

    public void qx(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fNb.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fVC, Integer.valueOf(fVF));
        aVar.aE(sparseArray);
        aVar.a(d.j.view, this.fNb);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fNb.getPageContext()).AU();
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

    public PbInterviewStatusView bfI() {
        return this.fVo;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bau() != null && dVar.bau().Ad() && this.fVo == null) {
            this.fVo = (PbInterviewStatusView) this.fVn.inflate();
            this.fVo.setOnClickListener(this.dGd);
            this.fVo.setCallback(this.fNb.bcv());
            this.fVo.c(this.fNb, dVar);
        }
    }

    public LinearLayout bfJ() {
        return this.fUz;
    }

    public View bfK() {
        return this.dGq;
    }

    public boolean bfL() {
        return this.fWd;
    }

    public void jU(boolean z) {
        this.fTY.jU(z);
    }

    public void qy(String str) {
        if (this.fTQ != null) {
            this.fTQ.setTitle(str);
        }
    }

    private int kN(boolean z) {
        if (this.fVo == null || this.fVo.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bfM() {
        if (this.fVo != null && this.fVo.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fVo.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fVo.setLayoutParams(layoutParams);
        }
    }

    public boolean bbS() {
        return false;
    }

    public void qz(String str) {
        this.fVb.performClick();
        if (!StringUtils.isNull(str) && this.fNb.bbM() != null && this.fNb.bbM().LB() != null && this.fNb.bbM().LB().getInputView() != null) {
            EditText inputView = this.fNb.bbM().LB().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bfv();
            if (configuration.orientation == 2) {
                bfE();
                beI();
            } else {
                beL();
            }
            if (this.fVJ != null) {
                this.fVJ.bcX();
            }
            this.fNb.avj();
            this.fUz.setVisibility(8);
            this.fTP.kY(false);
            this.fNb.ka(false);
            if (this.fTJ != null) {
                if (configuration.orientation == 1) {
                    bfJ().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fTT.setIsLandscape(true);
                    this.fTT.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fTT.setIsLandscape(false);
                    if (this.flA > 0) {
                        this.fTT.smoothScrollBy(this.flA, 0);
                    }
                }
                this.fTJ.onConfigurationChanged(configuration);
            }
        }
    }

    public void kO(boolean z) {
        this.fTN = z;
    }

    public boolean bfN() {
        return this.fTJ != null && this.fTJ.bfN();
    }

    public void bfO() {
        if (this.fTJ != null) {
            this.fTJ.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fTL != null) {
            this.fTL.y(j, i);
        }
        if (this.fTJ != null) {
            this.fTJ.y(j, i);
        }
    }

    public void kf(boolean z) {
        this.fUA.kf(z);
    }

    public void bfP() {
        if (this.fVp == null) {
            LayoutInflater.from(this.fNb.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.dpw, true);
            this.fVp = (ViewGroup) this.dpw.findViewById(d.g.add_experienced_layout);
            this.fVq = (TextView) this.dpw.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.r(this.fVq, d.C0140d.cp_cont_i);
            String string = this.fNb.getResources().getString(d.j.experienced_add_success);
            String string2 = this.fNb.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_cont_h)));
            this.fVq.setText(spannableString);
        }
        this.fVp.setVisibility(0);
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
                        ar.this.fVp.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fVq.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fVq.startAnimation(scaleAnimation);
    }

    public void cz(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fVa.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fNb);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fVV = new TextView(this.fNb);
            this.fVV.setText(d.j.connection_tips);
            this.fVV.setGravity(17);
            this.fVV.setPadding(com.baidu.adp.lib.util.l.t(this.fNb, d.e.ds24), 0, com.baidu.adp.lib.util.l.t(this.fNb, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.t(this.fNb, d.e.ds60);
            if (this.fVV.getParent() == null) {
                frameLayout.addView(this.fVV, layoutParams);
            }
            this.fVU = new PopupWindow(this.fNb);
            this.fVU.setContentView(frameLayout);
            this.fVU.setHeight(-2);
            this.fVU.setWidth(-2);
            this.fVU.setFocusable(true);
            this.fVU.setOutsideTouchable(false);
            this.fVU.setBackgroundDrawable(new ColorDrawable(this.fNb.getResources().getColor(d.C0140d.transparent)));
            this.fTT.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fVU.showAsDropDown(ar.this.fVa, view.getLeft(), -ar.this.fVa.getHeight());
                    } else {
                        ar.this.fVU.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bfZ() != null && !StringUtils.isNull(aVar.bfZ().pkg_id) && !StringUtils.isNull(aVar.bfZ().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fVc != null && this.fVc.getVisibility() == 0) {
            if (this.fVT == null) {
                View inflate = LayoutInflater.from(this.fNb.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dGd);
                this.fVT = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fVc.getLocationInWindow(iArr);
            this.fVT.showAtLocation(this.fVc, 0, iArr[0] - com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fVc.getHeight()) - com.baidu.adp.lib.util.l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bfQ() {
        com.baidu.adp.lib.g.g.b(this.fVT);
    }

    public void setIsInterviewLive(boolean z) {
        this.fWa = z;
    }

    public boolean getIsInterviewLive() {
        return this.fWa;
    }

    public void cA(View view) {
        this.fUR = view;
    }
}
