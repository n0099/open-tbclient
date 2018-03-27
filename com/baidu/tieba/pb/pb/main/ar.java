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
    private static final int fVA = UtilHelper.getLightStatusBarHeight();
    public static int fVG = 3;
    public static int fVH = 0;
    public static int fVI = 3;
    public static int fVJ = 4;
    public static int fVK = 5;
    public static int fVL = 6;
    private com.baidu.tbadk.editortools.i axH;
    private com.baidu.tieba.pb.a.c bLJ;
    private j.b bcH;
    private TextView beo;
    private TextView boB;
    private View bzl;
    private List<com.baidu.tieba.pb.pb.main.view.a> cZf;
    private View.OnClickListener dFV;
    private View dGj;
    private PbListView dIN;
    private NavigationBarCoverTip dVW;
    private View ddr;
    private NoNetworkView dpl;
    private RelativeLayout dpn;
    private View.OnClickListener fIX;
    PbActivity.d fMl;
    private PbActivity fNg;
    private UserIconBox fOn;
    private UserIconBox fOo;
    private PbFakeFloorModel fPj;
    private com.baidu.tieba.pb.data.d fQo;
    public int fTN;
    private com.baidu.tieba.pb.video.i fTO;
    private long fTP;
    private com.baidu.tieba.pb.video.h fTQ;
    private com.baidu.tieba.d.c fTR;
    public final com.baidu.tieba.pb.pb.main.view.c fTU;
    public com.baidu.tieba.pb.pb.main.view.b fTV;
    private ViewStub fTW;
    private ViewStub fTX;
    private PbLandscapeListView fTY;
    private View fTZ;
    private TextView fUA;
    private View fUB;
    private View fUC;
    private ObservedChangeLinearLayout fUE;
    private f fUF;
    private View fUL;
    private LinearLayout fUc;
    private e fUd;
    private ColumnLayout fUe;
    private ThreadSkinView fUf;
    private TextView fUg;
    private TextView fUh;
    private ImageView fUi;
    private HeadPendantView fUj;
    private FrameLayout fUk;
    private HeadImageView fUl;
    private View fUm;
    private FloatingLayout fUn;
    private PbFirstFloorUserLikeButton fUq;
    private ap fUr;
    private ap fUs;
    private TextView fUt;
    private TextView fUu;
    private TextView fUv;
    private View fUw;
    private View fUx;
    private LinearLayout fUy;
    private TextView fUz;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fVE;
    private int fVM;
    private Runnable fVN;
    private r fVO;
    private am fVP;
    private int fVV;
    private PbTopTipView fVX;
    private PopupWindow fVY;
    private PopupWindow fVZ;
    private View fVf;
    private TextView fVg;
    private ImageView fVh;
    private ImageView fVi;
    private TextView fVj;
    private boolean fVl;
    private int fVm;
    private int fVn;
    private PostData fVo;
    private View fVq;
    private TextView fVr;
    private ViewStub fVs;
    private PbInterviewStatusView fVt;
    private ViewGroup fVu;
    private TextView fVv;
    private FrameLayout fVw;
    private View fVx;
    private View fVy;
    private ak fVz;
    private TextView fWa;
    private List<String> fWb;
    private com.baidu.tieba.pb.pb.main.emotion.c fWc;
    private com.baidu.tieba.pb.pb.godreply.a fWd;
    private PbLandscapeListView.b fWe;
    private ab fWg;
    private boolean fWi;
    private com.baidu.tbadk.core.view.userLike.c fWj;
    private com.baidu.tbadk.core.view.userLike.c fWk;
    private Runnable fWp;
    private PbActivity.b fWr;
    private int flE;
    private boolean isLandscape;
    private int mType;
    private boolean fTS = false;
    private int fTT = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fUa = null;
    private TextView fUb = null;
    public FrsPraiseView fUo = null;
    private ClickableHeaderImageView fUp = null;
    private View fUD = null;
    private com.baidu.tbadk.core.dialog.a fUG = null;
    private com.baidu.tbadk.core.dialog.b dFU = null;
    private View fUH = null;
    private EditText fUI = null;
    private com.baidu.tieba.pb.view.h fUJ = null;
    private com.baidu.tieba.pb.view.b fUK = null;
    private com.baidu.tbadk.core.dialog.a fUM = null;
    private b.InterfaceC0097b eHd = null;
    private TbRichTextView.h bLI = null;
    private NoNetworkView.a dCv = null;
    private Dialog fUN = null;
    private View fUO = null;
    private com.baidu.tbadk.core.dialog.a fUP = null;
    private Dialog fUQ = null;
    private Dialog fUR = null;
    private View fUS = null;
    private LinearLayout fUT = null;
    private CompoundButton.OnCheckedChangeListener cZg = null;
    private TextView fUU = null;
    private TextView fUV = null;
    private View fUW = null;
    private String fUX = null;
    private com.baidu.tbadk.core.dialog.b fUY = null;
    private com.baidu.tbadk.core.dialog.b fUZ = null;
    private boolean fVa = false;
    private boolean fVb = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fVc = null;
    private boolean fVd = false;
    private Button fVe = null;
    private boolean fVk = true;
    private com.baidu.tbadk.core.view.b dgB = null;
    private boolean fIT = false;
    private int mSkinType = 3;
    private boolean fVp = false;
    private int fVB = 0;
    private boolean fVC = true;
    private a fVD = new a();
    private int fVF = 0;
    private boolean fVQ = false;
    private int fVR = 0;
    private boolean fVS = false;
    private boolean fVT = false;
    private boolean fVU = false;
    private int fVW = 0;
    private boolean fWf = false;
    private a.InterfaceC0234a fWh = new a.InterfaceC0234a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
        }
    };
    private String fWl = null;
    private CustomMessageListener fWm = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.fWl = null;
            }
        }
    };
    private CustomMessageListener cde = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fUF != null) {
                ar.this.fUF.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fWn = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fUb != null) {
                ar.this.fUb.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fWo = new Handler();
    private CustomMessageListener fWq = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fVk = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fWs = true;
    View.OnClickListener fWt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fVS) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").s("obj_id", 2));
            }
            if (view == ar.this.fTU.fYV) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").s("obj_locate", 2));
            }
            if (ar.this.fNg.fLk.fYe != null) {
                if (!ar.this.fVS && ar.this.fQo != null && ar.this.fQo.bau() != null && ar.this.fQo.bau().zn() != null && ar.this.fQo.bau().zn().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").s("obj_locate", 1));
                }
                ar.this.fNg.fLk.fYe.onClick(view);
            }
        }
    };
    private boolean fWu = false;
    String userId = null;
    private final List<TbImageView> fWv = new ArrayList();
    private boolean fWw = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fCU;
        public int fWK;
        public ak fWL;
    }

    public void kF(boolean z) {
        this.fVQ = z;
        if (this.fTY != null) {
            this.fVR = this.fTY.getHeaderViewsCount();
        }
    }

    public void beG() {
        if (this.fTY != null) {
            int headerViewsCount = this.fTY.getHeaderViewsCount() - this.fVR;
            final int firstVisiblePosition = (this.fTY.getFirstVisiblePosition() == 0 || this.fTY.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fTY.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fTY.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fVD.fWL = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVD));
            final ak akVar = this.fVD.fWL;
            final int h = h(akVar);
            final int y = ((int) this.fUE.getY()) + this.fUE.getMeasuredHeight();
            final boolean z = this.fVx.getVisibility() == 0;
            boolean z2 = this.fUE.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.fUF.bcQ() + this.fTY.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fTh.getMeasuredHeight() : 0;
                if (z2) {
                    this.fTY.setSelectionFromTop(this.fUF.bcQ() + this.fTY.getHeaderViewsCount(), fVA - measuredHeight);
                } else {
                    this.fTY.setSelectionFromTop(this.fUF.bcQ() + this.fTY.getHeaderViewsCount(), this.fTU.bgh().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fTY.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fVS) {
                this.fTY.setSelectionFromTop(this.fUF.bcQ() + this.fTY.getHeaderViewsCount(), this.fTO.bhw().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fTY.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bdi() {
                        if (h >= 0 && h <= ar.this.dpn.getMeasuredHeight()) {
                            int h2 = ar.this.h(akVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.ddr.getLayoutParams();
                            if (i == 0 || i > ar.this.dpn.getMeasuredHeight() || h2 >= ar.this.dpn.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVM;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.dpn.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVM;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fTY.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.ddr.setLayoutParams(layoutParams);
                        }
                        ar.this.fTY.setOnLayoutListener(null);
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
        return this.dpl;
    }

    public void beI() {
        if (this.axH != null) {
            this.axH.hide();
            if (this.fWc != null) {
                this.fWc.Wk();
            }
        }
    }

    public PbFakeFloorModel beJ() {
        return this.fPj;
    }

    public r beK() {
        return this.fVO;
    }

    public void beL() {
        reset();
        beI();
        this.fVO.bcX();
        kR(false);
    }

    private void reset() {
        if (this.fNg != null && this.fNg.bbM() != null && this.axH != null) {
            com.baidu.tbadk.editortools.pb.a.Ly().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bbM = this.fNg.bbM();
            bbM.LQ();
            bbM.Lm();
            if (bbM.getWriteImagesInfo() != null) {
                bbM.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bbM.hO(SendView.ALL);
            bbM.hP(SendView.ALL);
            com.baidu.tbadk.editortools.l hG = this.axH.hG(23);
            com.baidu.tbadk.editortools.l hG2 = this.axH.hG(2);
            com.baidu.tbadk.editortools.l hG3 = this.axH.hG(5);
            if (hG2 != null) {
                hG2.th();
            }
            if (hG3 != null) {
                hG3.th();
            }
            if (hG != null) {
                hG.hide();
            }
            this.axH.invalidate();
        }
    }

    public boolean beM() {
        return this.fVk;
    }

    public void kG(boolean z) {
        if (this.fVf != null && this.fVg != null) {
            this.fVg.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fVf.startAnimation(alphaAnimation);
            }
            this.fVf.setVisibility(0);
            this.fVk = true;
            if (this.fVE != null && !this.fWd.isActive()) {
                this.fVE.setVisibility(0);
                kL(true);
            }
        }
    }

    public void kH(boolean z) {
        if (this.fVf != null && this.fVg != null) {
            this.fVg.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fVf.startAnimation(alphaAnimation);
            }
            this.fVf.setVisibility(0);
            this.fVk = true;
            if (this.fVE != null && !this.fWd.isActive()) {
                this.fVE.setVisibility(0);
                kL(true);
            }
        }
    }

    public PostData beN() {
        int i = 0;
        if (this.fTY == null) {
            return null;
        }
        int beO = beO() - this.fTY.getHeaderViewsCount();
        if (beO < 0) {
            beO = 0;
        }
        if (this.fUF.sM(beO) != null && this.fUF.sM(beO) != PostData.haY) {
            i = beO + 1;
        }
        return this.fUF.getItem(i) instanceof PostData ? (PostData) this.fUF.getItem(i) : null;
    }

    public int beO() {
        int i;
        View childAt;
        if (this.fTY == null) {
            return 0;
        }
        int firstVisiblePosition = this.fTY.getFirstVisiblePosition();
        int lastVisiblePosition = this.fTY.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fTY.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fTY.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        return this.fTY.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fQo != null && this.fQo.baw() != null && !this.fQo.baw().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fQo.baw().size() && (postData = this.fQo.baw().get(i)) != null && postData.zn() != null && !StringUtils.isNull(postData.zn().getUserId()); i++) {
                if (this.fQo.baw().get(i).zn().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fWd != null && this.fWd.isActive()) {
                        kR(false);
                    }
                    if (this.fVE != null) {
                        this.fVE.kX(true);
                    }
                    this.fWl = postData.zn().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fNg = null;
        this.dpn = null;
        this.dGj = null;
        this.fTP = 0L;
        this.fTY = null;
        this.fTZ = null;
        this.fUc = null;
        this.fUe = null;
        this.fUg = null;
        this.fUh = null;
        this.fUk = null;
        this.fUl = null;
        this.fUm = null;
        this.fUq = null;
        this.fUt = null;
        this.fUu = null;
        this.fUv = null;
        this.fUw = null;
        this.fUB = null;
        this.fUC = null;
        this.fUF = null;
        this.dIN = null;
        this.bzl = null;
        this.dFV = null;
        this.fIX = null;
        this.fVf = null;
        this.fVg = null;
        this.fVh = null;
        this.fVi = null;
        this.fVj = null;
        this.fVq = null;
        this.fVr = null;
        this.fVs = null;
        this.fVV = 0;
        this.fTP = System.currentTimeMillis();
        this.fNg = pbActivity;
        this.dFV = onClickListener;
        this.bLJ = cVar;
        this.fVV = com.baidu.adp.lib.util.l.ao(this.fNg) / 2;
        this.dpn = (RelativeLayout) LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.fNg.addContentView(this.dpn, new FrameLayout.LayoutParams(-1, -1));
        this.dVW = (NavigationBarCoverTip) this.fNg.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dGj = this.fNg.findViewById(d.g.statebar_view);
        this.fUE = (ObservedChangeLinearLayout) this.fNg.findViewById(d.g.title_wrapper);
        this.dpl = (NoNetworkView) this.fNg.findViewById(d.g.view_no_network);
        this.fTY = (PbLandscapeListView) this.fNg.findViewById(d.g.new_pb_list);
        this.fVw = (FrameLayout) this.fNg.findViewById(d.g.root_float_header);
        this.boB = new TextView(this.fNg.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds88));
        this.fTY.addHeaderView(this.boB, 0);
        this.fVM = this.fNg.getResources().getDimensionPixelSize(d.e.tbds134);
        this.ddr = new View(this.fNg.getPageContext().getPageActivity());
        this.ddr.setLayoutParams(new AbsListView.LayoutParams(-1, this.fVM));
        this.ddr.setVisibility(4);
        this.fTY.addFooterView(this.ddr);
        this.fTY.setOnTouchListener(this.fNg.bDn);
        this.fTU = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.fNg.bcn()) {
            this.fTW = (ViewStub) this.fNg.findViewById(d.g.manga_view_stub);
            this.fTW.setVisibility(0);
            this.fTV = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.fTV.show();
            this.fTU.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds120);
        }
        this.boB.setLayoutParams(layoutParams);
        this.fTU.bgh().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0205a() { // from class: com.baidu.tieba.pb.pb.main.ar.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0205a
            public void bbm() {
                if (ar.this.fTY != null) {
                    if (ar.this.fTO != null) {
                        ar.this.fTO.bhx();
                    }
                    ar.this.fTY.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0205a
            public void bbn() {
                ar.this.fNg.avj();
            }
        }));
        this.fVf = this.fNg.findViewById(d.g.pb_editor_tool_comment);
        this.fVm = com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds90);
        this.fVn = com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds242);
        this.fVg = (TextView) this.fNg.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fVi = (ImageView) this.fNg.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fVh = (ImageView) this.fNg.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fVj = (TextView) this.fNg.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fVj.setVisibility(8);
        this.fVg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfQ();
                if (!ar.this.fNg.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, ar.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d bbM = ar.this.fNg.bbM();
                if (bbM == null || (!bbM.LN() && !bbM.LO())) {
                    if (ar.this.axH != null) {
                        ar.this.beZ();
                    }
                    if (ar.this.axH != null) {
                        ar.this.fVk = false;
                        if (ar.this.axH.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fNg, (View) ar.this.axH.hI(2).bsm, false, ar.this.fWh);
                        }
                    }
                    ar.this.bfE();
                    return;
                }
                ar.this.fNg.bbM().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fVh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfQ();
                if (ar.this.fNg.checkUpIsLogin()) {
                    if (ar.this.axH != null) {
                        ar.this.beZ();
                        ar.this.axH.bh((View) ar.this.axH.hG(5));
                    }
                    if (ar.this.axH != null) {
                        ar.this.fVk = false;
                        if (ar.this.axH.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fNg, (View) ar.this.axH.hI(2).bsm, false, ar.this.fWh);
                        }
                    }
                    ar.this.bfE();
                }
            }
        });
        this.fVi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bfQ();
                if (ar.this.fNg.checkUpIsLogin()) {
                    if (ar.this.axH != null) {
                        ar.this.beZ();
                        ar.this.axH.bh((View) ar.this.axH.hG(2));
                    }
                    if (ar.this.axH != null) {
                        ar.this.fVk = false;
                        if (ar.this.axH.hI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fNg, (View) ar.this.axH.hI(2).bsm, false, ar.this.fWh);
                        }
                    }
                    ar.this.bfE();
                }
            }
        });
        this.fVj.setOnClickListener(this.dFV);
        this.fVj.setOnTouchListener(this.fNg);
        this.fTZ = LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fUc = (LinearLayout) LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.aj.s(this.fUc, d.C0141d.cp_bg_line_d);
        this.fUd = new e(this.fNg, this.fUc);
        this.fUd.init();
        this.fUd.a(this.fUd.bbL(), this.dFV);
        this.fUe = (ColumnLayout) this.fUc.findViewById(d.g.pb_head_owner_root);
        this.fUf = (ThreadSkinView) this.fUc.findViewById(d.g.pb_thread_skin);
        this.fUe.setOnLongClickListener(this.onLongClickListener);
        this.fUe.setOnTouchListener(this.bLJ);
        this.fUe.setVisibility(8);
        this.fTZ.setOnTouchListener(this.bLJ);
        this.fVq = this.fTZ.findViewById(d.g.pb_head_activity_join_number_container);
        this.fVq.setVisibility(8);
        this.fVr = (TextView) this.fTZ.findViewById(d.g.pb_head_activity_join_number);
        this.fUg = (TextView) this.fUe.findViewById(d.g.pb_head_owner_info_user_name);
        this.fUh = (TextView) this.fUe.findViewById(d.g.floor_owner);
        this.fUi = (ImageView) this.fUe.findViewById(d.g.icon_forum_level);
        this.fUk = (FrameLayout) this.fUe.findViewById(d.g.pb_head_headImage_container);
        this.fUl = (HeadImageView) this.fUe.findViewById(d.g.pb_head_owner_photo);
        this.fUj = (HeadPendantView) this.fUe.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fUj.DT();
        if (this.fUj.getHeadView() != null) {
            this.fUj.getHeadView().setIsRound(true);
            this.fUj.getHeadView().setDrawBorder(false);
        }
        this.fOn = (UserIconBox) this.fUe.findViewById(d.g.show_icon_vip);
        this.fOo = (UserIconBox) this.fUe.findViewById(d.g.show_icon_yinji);
        this.fUn = (FloatingLayout) this.fUc.findViewById(d.g.pb_head_owner_info_root);
        this.fUq = (PbFirstFloorUserLikeButton) this.fUe.findViewById(d.g.pb_like_button);
        this.fUt = (TextView) this.fUe.findViewById(d.g.pb_views);
        this.beo = (TextView) this.fUe.findViewById(d.g.view_forum_name);
        this.fUx = this.fUe.findViewById(d.g.line_right_forum_name);
        this.fUu = (TextView) this.fUe.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fUv = (TextView) this.fUe.findViewById(d.g.pb_item_first_floor_location_address);
        this.fUw = this.fUe.findViewById(d.g.line_between_time_and_locate);
        this.fWj = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fWk = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fUB = this.fTZ.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fUC = this.fTZ.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fTZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fVs = (ViewStub) this.dpn.findViewById(d.g.interview_status_stub);
        this.fUF = new f(this.fNg, this.fTY);
        this.fUF.r(this.dFV);
        this.fUF.setTbGestureDetector(this.bLJ);
        this.fUF.setOnImageClickListener(this.bLI);
        this.fIX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.akM() || !com.baidu.tieba.c.a.b(ar.this.fNg.getBaseContext(), ar.this.fNg.bbA().bdm(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                ar.this.fNg.c(sparseArray);
                                return;
                            }
                            ar.this.cy(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        ar.this.fNg.c(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fUF.E(this.fIX);
        beU();
        this.fTY.addHeaderView(this.fUa);
        this.fTY.addHeaderView(this.fUc);
        this.fTY.addHeaderView(this.fTZ);
        this.dIN = new PbListView(this.fNg.getPageContext().getPageActivity());
        this.bzl = this.dIN.getView().findViewById(d.g.pb_more_view);
        if (this.bzl != null) {
            this.bzl.setOnClickListener(this.dFV);
            com.baidu.tbadk.core.util.aj.s(this.bzl, d.f.pb_foot_more_trans_selector);
        }
        this.dIN.Ec();
        this.dIN.gu(d.f.pb_foot_more_trans_selector);
        this.dIN.gw(d.f.pb_foot_more_trans_selector);
        this.fUL = this.fNg.findViewById(d.g.viewstub_progress);
        this.fNg.registerListener(this.fWq);
        this.fUm = com.baidu.tbadk.ala.b.vL().u(this.fNg.getActivity(), 2);
        if (this.fUm != null) {
            this.fUm.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fNg.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fUm.getParent() == null) {
                this.fUn.addView(this.fUm, aVar);
            }
        }
        this.fPj = new PbFakeFloorModel(this.fNg.getPageContext());
        this.fVO = new r(this.fNg.getPageContext(), this.fPj, this.dpn);
        this.fVO.a(this.fNg.fMh);
        this.fPj.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.fPj.m(postData);
                ar.this.fUF.notifyDataSetChanged();
                ar.this.fVO.bcX();
                ar.this.axH.Jm();
                ar.this.kR(false);
            }
        });
        if (this.fNg.bbA() != null && !StringUtils.isNull(this.fNg.bbA().bdR())) {
            this.fNg.showToast(this.fNg.bbA().bdR());
        }
        this.fVx = this.fNg.findViewById(d.g.pb_expand_blank_view);
        this.fVy = this.fNg.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fVy.getLayoutParams();
        if (this.fNg.bbA() != null && this.fNg.bbA().bdp()) {
            this.fVx.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fVy.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fVA;
            this.fVy.setLayoutParams(layoutParams2);
        }
        this.fVz = new ak(this.fNg.getPageContext(), this.fNg.findViewById(d.g.pb_reply_expand_view));
        this.fVz.fTh.setVisibility(8);
        this.fVz.G(this.dFV);
        this.fNg.registerListener(this.cde);
        this.fNg.registerListener(this.fWm);
        this.fNg.registerListener(this.fWn);
        beQ();
        kL(false);
    }

    private void beQ() {
        this.fWd = new com.baidu.tieba.pb.pb.godreply.a(this.fNg, this, (ViewStub) this.dpn.findViewById(d.g.more_god_reply_popup));
        this.fWd.l(this.dFV);
        this.fWd.E(this.fIX);
        this.fWd.setOnImageClickListener(this.bLI);
        this.fWd.l(this.dFV);
        this.fWd.setTbGestureDetector(this.bLJ);
    }

    public com.baidu.tieba.pb.pb.godreply.a beR() {
        return this.fWd;
    }

    public View beS() {
        return this.fVx;
    }

    public void beT() {
        if (this.fTY != null) {
            this.fTY.removeHeaderView(this.fUa);
            this.fTY.removeHeaderView(this.fUc);
            this.fTY.removeHeaderView(this.fTZ);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fVE == null) {
            this.fVE = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.fNg.getPageContext().getPageActivity());
            kL(true);
            this.fVE.a(this.dpn, aVar, this.fVf.getVisibility() == 0);
            this.fVE.setOnEmotionClickListener(new a.InterfaceC0211a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0211a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(ar.this.fWl)) {
                        emotionImageData.setAuthorNameShow(ar.this.fWl);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0211a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fNg.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fNg.getPageContext().getPageActivity(), 25016, str, list, ar.this.fWl, list2)));
                }
            });
            this.fVE.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    ar.this.bfQ();
                    if (ar.this.fVf != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fVf.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fVn - ar.this.fVm) * f) + ar.this.fVm);
                        ar.this.fVg.setAlpha(1.0f - f);
                        ar.this.fVi.setAlpha(1.0f - f);
                        ar.this.fVh.setAlpha(1.0f - f);
                        ar.this.fVf.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void beU() {
        if (this.fUa == null) {
            int t = com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.tbds44);
            this.fUa = new LinearLayout(this.fNg.getPageContext().getPageActivity());
            this.fUa.setOrientation(1);
            this.fUa.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fUa.setPadding(t, com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.tbds30), t, com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.tbds40));
            this.fUa.setGravity(17);
            this.fUb = new TextView(this.fNg.getPageContext().getPageActivity());
            this.fUb.setGravity(3);
            this.fUb.setMaxLines(2);
            this.fUb.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_link_tip_c));
            this.fUb.setPadding(0, 0, 0, 0);
            this.fUb.setLineSpacing(com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.r(this.fUb, d.C0141d.cp_cont_b);
            this.fUb.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fUb.setVisibility(8);
            if (this.fUb.getParent() == null) {
                this.fUa.addView(this.fUb);
            }
            this.fUa.setOnTouchListener(this.bLJ);
            this.fUa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beV() {
        if (this.fNg.bcn()) {
            this.fTX = (ViewStub) this.fNg.findViewById(d.g.manga_mention_controller_view_stub);
            this.fTX.setVisibility(0);
            if (this.fUy == null) {
                this.fUy = (LinearLayout) this.fNg.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fNg.getPageContext(), this.fUy);
            }
            if (this.fUz == null) {
                this.fUz = (TextView) this.fUy.findViewById(d.g.manga_prev_btn);
            }
            if (this.fUA == null) {
                this.fUA = (TextView) this.fUy.findViewById(d.g.manga_next_btn);
            }
            this.fUz.setOnClickListener(this.dFV);
            this.fUA.setOnClickListener(this.dFV);
        }
    }

    private void beW() {
        if (this.fNg.bcn()) {
            if (this.fNg.bcq() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fUz, d.C0141d.cp_cont_e, 1);
            }
            if (this.fNg.bcr() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fUA, d.C0141d.cp_cont_e, 1);
            }
        }
    }

    public void beX() {
        if (this.fUy == null) {
            beV();
        }
        this.fTX.setVisibility(8);
        if (this.fWo != null && this.fWp != null) {
            this.fWo.removeCallbacks(this.fWp);
        }
    }

    public void beY() {
        if (this.fWo != null) {
            if (this.fWp != null) {
                this.fWo.removeCallbacks(this.fWp);
            }
            this.fWp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fUy == null) {
                        ar.this.beV();
                    }
                    ar.this.fTX.setVisibility(0);
                }
            };
            this.fWo.postDelayed(this.fWp, 2000L);
        }
    }

    public void kI(boolean z) {
        this.fTU.kI(z);
        if (z && this.fVp) {
            this.dIN.setText(this.fNg.getResources().getString(d.j.click_load_more));
            this.fTY.setNextPage(this.dIN);
            this.fTT = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axH = iVar;
        this.axH.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.axH.getParent() == null) {
            this.dpn.addView(this.axH, layoutParams);
        }
        this.axH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        beI();
        this.fNg.bbM().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.axH != null && ar.this.axH.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fWc == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.axH.getId());
                            ar.this.fWc = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fNg.getPageContext(), ar.this.dpn, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.E(ar.this.fWb)) {
                                ar.this.fWc.setData(ar.this.fWb);
                            }
                            ar.this.fWc.b(ar.this.axH);
                        }
                        ar.this.fWc.qD(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fNg.fLo != null && ar.this.fNg.fLo.bfT() != null) {
                    if (!ar.this.fNg.fLo.bfT().bFJ()) {
                        ar.this.fNg.fLo.kU(false);
                    }
                    ar.this.fNg.fLo.bfT().nG(false);
                }
            }
        });
    }

    public void beZ() {
        if (this.fNg != null && this.axH != null) {
            this.axH.th();
            bfE();
        }
    }

    public void Q(String str, boolean z) {
        this.fVl = z;
        kJ(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kJ(boolean z) {
        if (this.fVj != null) {
            if (this.fVl) {
                com.baidu.tbadk.core.util.aj.s(this.fVj, d.f.pb_praise_already_click_selector);
                this.fVj.setContentDescription(this.fNg.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.s(this.fVj, d.f.pb_praise_normal_click_selector);
            this.fVj.setContentDescription(this.fNg.getResources().getString(d.j.zan));
        }
    }

    public TextView bfa() {
        return this.fVj;
    }

    public void kK(boolean z) {
        if (this.fTY != null && this.boB != null && this.dGj != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dGj.setVisibility(0);
                } else {
                    this.dGj.setVisibility(8);
                    this.fTY.removeHeaderView(this.boB);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.boB.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fVA;
                    this.boB.setLayoutParams(layoutParams);
                }
                bfp();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.boB.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kS(true);
                this.boB.setLayoutParams(layoutParams2);
            }
            bfp();
            bfM();
        }
    }

    public f bfb() {
        return this.fUF;
    }

    public void a(PbActivity.d dVar) {
        this.fMl = dVar;
    }

    public void cy(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fUO == null) {
            this.fUO = LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fNg.getLayoutMode().aM(this.fUO);
        if (this.fUN == null) {
            this.fUN = new Dialog(this.fNg.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUN.setCanceledOnTouchOutside(true);
            this.fUN.setCancelable(true);
            this.fUN.setContentView(this.fUO);
            WindowManager.LayoutParams attributes = this.fUN.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ao(this.fNg.getPageContext().getPageActivity()) * 0.9d);
            this.fUN.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUN.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fUN.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUN.findViewById(d.g.disable_reply_btn);
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
                    if (ar.this.fUN != null && (ar.this.fUN instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUN, ar.this.fNg.getPageContext());
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
                    if (ar.this.fUN != null && (ar.this.fUN instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUN, ar.this.fNg.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fWr != null) {
                        ar.this.fWr.ak(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
                    if (ar.this.fUN != null && (ar.this.fUN instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUN, ar.this.fNg.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fNg.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fUN, this.fNg.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fWr = bVar;
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
        sparseArray.put(fVH, Integer.valueOf(fVI));
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
        this.fUP = new com.baidu.tbadk.core.dialog.a(this.fNg.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fUP.fb(i3);
        } else {
            this.fUP.be(false);
            this.fUP.dk(str2);
        }
        this.fUP.aE(sparseArray);
        this.fUP.a(d.j.dialog_ok, this.fNg);
        this.fUP.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUP.aZ(true);
        this.fUP.b(this.fNg.getPageContext());
        this.fUP.AV();
    }

    public void an(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fUS == null) {
            this.fUS = LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.fNg.getLayoutMode().aM(this.fUS);
        if (this.fUR == null) {
            this.fUR = new Dialog(this.fNg.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUR.setCanceledOnTouchOutside(true);
            this.fUR.setCancelable(true);
            this.fVc = (ScrollView) this.fUS.findViewById(d.g.good_scroll);
            this.fUR.setContentView(this.fUS);
            WindowManager.LayoutParams attributes = this.fUR.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds540);
            this.fUR.getWindow().setAttributes(attributes);
            this.cZg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fUX = (String) compoundButton.getTag();
                        if (ar.this.cZf != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : ar.this.cZf) {
                                String str = (String) aVar.getTag();
                                if (str != null && ar.this.fUX != null && !str.equals(ar.this.fUX)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fUT = (LinearLayout) this.fUS.findViewById(d.g.good_class_group);
            this.fUV = (TextView) this.fUS.findViewById(d.g.dialog_button_cancel);
            this.fUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fUR instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUR, ar.this.fNg.getPageContext());
                    }
                }
            });
            this.fUU = (TextView) this.fUS.findViewById(d.g.dialog_button_ok);
            this.fUU.setOnClickListener(this.dFV);
        }
        this.fUT.removeAllViews();
        this.cZf = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bI = bI("0", this.fNg.getPageContext().getString(d.j.def_good_class));
        this.cZf.add(bI);
        bI.setChecked(true);
        this.fUT.addView(bI);
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
                    this.cZf.add(bI2);
                    View view = new View(this.fNg.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.aj.t(view, d.C0141d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fUT.addView(view);
                    this.fUT.addView(bI2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fVc.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fNg.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fNg.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fNg.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fVc.setLayoutParams(layoutParams2);
            this.fVc.removeAllViews();
            if (this.fUT != null && this.fUT.getParent() == null) {
                this.fVc.addView(this.fUT);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fUR, this.fNg.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bI(String str, String str2) {
        Activity pageActivity = this.fNg.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.t(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cZg);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void bfc() {
        this.fNg.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fNg.hideProgressBar();
        if (z && z2) {
            this.fNg.showToast(this.fNg.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.fNg.showToast(str);
        }
    }

    public void aKi() {
        this.fUL.setVisibility(0);
    }

    public void aKh() {
        this.fUL.setVisibility(8);
    }

    public View bfd() {
        if (this.fUS != null) {
            return this.fUS.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bfe() {
        return this.fUX;
    }

    public View getView() {
        return this.dpn;
    }

    public void bff() {
        com.baidu.adp.lib.util.l.a(this.fNg.getPageContext().getPageActivity(), this.fNg.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fNg.hideProgressBar();
        if (z) {
            bfv();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bfw();
        } else {
            bfv();
        }
    }

    public void bfg() {
        this.dIN.Ec();
        this.dIN.Eg();
    }

    public void bfh() {
        this.fNg.hideProgressBar();
        Eh();
        this.fTY.completePullRefreshPostDelayed(2000L);
        bfs();
    }

    public void bfi() {
        this.fTY.completePullRefreshPostDelayed(2000L);
        bfs();
    }

    private void kL(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fVg.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fNg.getResources().getDimensionPixelSize(d.e.ds130) : this.fNg.getResources().getDimensionPixelSize(d.e.ds34);
        this.fVg.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fUF.setOnLongClickListener(onLongClickListener);
        if (this.fWd != null) {
            this.fWd.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0097b interfaceC0097b, boolean z, boolean z2) {
        if (this.fUY != null) {
            this.fUY.dismiss();
            this.fUY = null;
        }
        this.fUY = new com.baidu.tbadk.core.dialog.b(this.fNg.getPageContext().getPageActivity());
        this.fUY.fe(d.j.operation);
        if (z2) {
            this.fUY.a(new String[]{this.fNg.getPageContext().getString(d.j.copy)}, interfaceC0097b);
        } else if (!z) {
            this.fUY.a(new String[]{this.fNg.getPageContext().getString(d.j.copy), this.fNg.getPageContext().getString(d.j.mark)}, interfaceC0097b);
        } else {
            this.fUY.a(new String[]{this.fNg.getPageContext().getString(d.j.copy), this.fNg.getPageContext().getString(d.j.remove_mark)}, interfaceC0097b);
        }
        this.fUY.d(this.fNg.getPageContext());
        this.fUY.AY();
    }

    public void a(b.InterfaceC0097b interfaceC0097b, boolean z) {
        if (this.fUZ != null) {
            this.fUZ.dismiss();
            this.fUZ = null;
        }
        this.fUZ = new com.baidu.tbadk.core.dialog.b(this.fNg.getPageContext().getPageActivity());
        this.fUZ.fe(d.j.operation);
        if (z) {
            this.fUZ.a(new String[]{this.fNg.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0097b);
        } else {
            this.fUZ.a(new String[]{this.fNg.getPageContext().getString(d.j.save_to_emotion), this.fNg.getPageContext().getString(d.j.save_to_local)}, interfaceC0097b);
        }
        this.fUZ.d(this.fNg.getPageContext());
        this.fUZ.AY();
    }

    public int bfj() {
        return tc(this.fTY.getFirstVisiblePosition());
    }

    private int tc(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fTY.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fTY.getAdapter() == null || !(this.fTY.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fTY.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bfk() {
        int lastVisiblePosition = this.fTY.getLastVisiblePosition();
        if (this.fTO != null) {
            if (lastVisiblePosition == this.fTY.getCount() - 1) {
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
        if (this.fTY != null) {
            if (this.fTU == null || this.fTU.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fTU.mNavigationBar.getFixedNavHeight();
                if (this.fNg.bcb() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fVy != null && (layoutParams = (LinearLayout.LayoutParams) this.fVy.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fVy.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fTY.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fTY.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fUI.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fUF.a(dVar, false);
        this.fUF.notifyDataSetChanged();
        bfs();
        if (this.fWd != null) {
            this.fWd.bbw();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fUo == null) {
            this.fNg.getLayoutMode().aM(((ViewStub) this.fTZ.findViewById(d.g.praise_layout)).inflate());
            this.fUo = (FrsPraiseView) this.fTZ.findViewById(d.g.pb_head_praise_view);
            this.fUo.setIsFromPb(true);
            this.fUD = this.fTZ.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fUo.gB(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fUo != null) {
            boolean bfs = bfs();
            this.fUo.setVisibility(8);
            if (dVar != null && dVar.yA() != null && dVar.yA().yx() == 0 && this.fIT) {
                if (bfs) {
                    this.fUC.setVisibility(0);
                    return;
                } else {
                    this.fUC.setVisibility(8);
                    return;
                }
            }
            this.fUC.setVisibility(8);
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
                if (postData != null && postData.bwY() == 1) {
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
        postData.vM(1);
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
        com.baidu.tbadk.data.f bxc;
        String portrait;
        if (dVar != null && dVar.bau() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fUe.setVisibility(8);
            if (dVar.bau() != null && dVar.bau().Aa() && dVar.bau().zF() != null) {
                this.fVS = true;
                this.fTU.lg(this.fVS);
                this.fTU.mNavigationBar.hideBottomLine();
                if (this.fTO == null) {
                    this.fTO = new com.baidu.tieba.pb.video.i(this.fNg, this.fTU, dVar.bau().zF(), this.fTP);
                    this.fTO.a(dVar.bau().zF(), dVar.bau(), dVar.getForumId());
                    this.fTO.startPlay();
                } else if (this.fTS) {
                    this.fTO.a(dVar.bau().zF(), dVar.bau(), dVar.getForumId());
                    this.fTO.startPlay();
                } else {
                    this.fTO.qN(dVar.getForumId());
                }
                if (dVar.bav() != null && dVar.bav().size() >= 1) {
                    bd bdVar = dVar.bav().get(0);
                    this.fTO.ah(bdVar);
                    this.fTO.qO(bdVar.getTitle());
                }
                this.fTO.b(b, dVar.bau(), dVar.baQ());
                this.fTS = false;
                this.fTY.removeHeaderView(this.fTO.bhy());
                this.fTY.addHeaderView(this.fTO.bhy(), 0);
                if (this.fTO.bhw() != null && this.fTO.bhw().getParent() == null) {
                    this.fVw.addView(this.fTO.bhw());
                }
                if (this.fTQ == null) {
                    this.fTQ = new com.baidu.tieba.pb.video.h(this.fNg);
                }
                this.fTQ.a(dVar.bau().Ao(), dVar.bau(), dVar.baN());
                this.fTY.removeHeaderView(this.fTQ.bhn());
                this.fTY.addHeaderView(this.fTQ.bhn(), 1);
                if (dVar.bau().Ao() != null) {
                    this.fTY.removeHeaderView(this.fTQ.bho());
                    this.fTY.removeHeaderView(this.fUc);
                    this.fTY.addHeaderView(this.fTQ.bho(), 2);
                } else {
                    if (this.fTQ.bho() != null) {
                        this.fTY.removeHeaderView(this.fTQ.bho());
                    }
                    this.fTY.removeHeaderView(this.fUc);
                    this.fUc.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.t(this.fNg, d.e.tbds56));
                    this.fTY.addHeaderView(this.fUc, 2);
                }
                if (this.fTO != null) {
                    this.fTU.la(false);
                    this.fTU.lc(TbadkCoreApplication.isLogin());
                    this.fTO.tk(TbadkCoreApplication.getInst().getSkinType());
                }
                bfp();
            } else {
                this.fVS = false;
                this.fTU.lg(this.fVS);
                if (this.fTO != null) {
                    this.fTY.removeHeaderView(this.fTO.bhy());
                }
                if (this.fTQ != null) {
                    this.fTQ.b(this.fTY);
                }
                if (b == null || (b != null && (b.bxb() == null || com.baidu.tbadk.core.util.v.E(b.bxb().Ri())))) {
                    this.fUc.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.t(this.fNg, d.e.tbds80));
                } else {
                    this.fUc.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fNg.bbQ() != null) {
                this.fNg.bbQ().kY(this.fVS);
            }
            if (this.fTO != null) {
                this.fTO.I(this.fWt);
            }
            if (b != null) {
                this.fVo = b;
                this.fUe.setVisibility(0);
                if (this.fNg.bcA()) {
                    if (dVar.bat() != null) {
                        this.mForumName = dVar.bat().getForumName();
                        this.mForumId = dVar.bat().getForumId();
                    }
                    if (this.mForumName == null && this.fNg.bbA() != null && this.fNg.bbA().bdl() != null) {
                        this.mForumName = this.fNg.bbA().bdl();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fUe.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fUe.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fWi) {
                    this.fUa.setVisibility(0);
                }
                if (!dVar.bau().Aa() && this.fUb.getText() != null && this.fUb.getText().length() > 0) {
                    this.fUb.setVisibility(0);
                } else {
                    this.fUb.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> zz = dVar.bau().zz();
                if (zz != null && zz.size() > 0 && !this.fWi) {
                    this.fVr.setText(String.valueOf(zz.get(0).xH()));
                    this.fVq.setVisibility(0);
                } else {
                    this.fVq.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.s(this.fVq, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.e(this.fVr, d.C0141d.cp_link_tip_d, 1);
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
                            if (this.fOo != null) {
                                this.fOo.setTag(d.g.tag_user_id, b.zn().getUserId());
                                this.fOo.setOnClickListener(this.fNg.fLk.fYf);
                                this.fOo.a(iconInfo, 4, this.fNg.getResources().getDimensionPixelSize(d.e.tbds36), this.fNg.getResources().getDimensionPixelSize(d.e.tbds36), this.fNg.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fOn != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fOn.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fOn.setOnClickListener(this.fNg.fLk.fYg);
                                this.fOn.a(tShowInfoNew, 3, this.fNg.getResources().getDimensionPixelSize(d.e.tbds36), this.fNg.getResources().getDimensionPixelSize(d.e.tbds36), this.fNg.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fUg.setText(af(b.zn().getSealPrefix(), e));
                            this.fUg.setTag(d.g.tag_user_id, b.zn().getUserId());
                            this.fUg.setTag(d.g.tag_user_name, b.zn().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew) || b.zn().isBigV()) {
                                com.baidu.tbadk.core.util.aj.e(this.fUg, d.C0141d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.e(this.fUg, d.C0141d.cp_cont_f, 1);
                            }
                            this.fUh.setVisibility(8);
                            if (dVar.bau().zn() != null && dVar.bau().zn().getAlaUserData() != null && this.fUm != null) {
                                if (dVar.bau().zn().getAlaUserData().anchor_live != 0) {
                                    this.fUm.setVisibility(8);
                                } else {
                                    this.fUm.setVisibility(0);
                                    if (this.fTR == null) {
                                        this.fTR = new com.baidu.tieba.d.c(this.fNg.getPageContext(), this.fUm);
                                        this.fTR.lU(1);
                                    }
                                    this.fTR.aK(this.fNg.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aGU = dVar.bau().zn().getAlaUserData();
                                    aVar.type = 2;
                                    this.fUm.setTag(aVar);
                                }
                            }
                            this.fUl.setUserId(b.zn().getUserId());
                            this.fUl.setUserName(b.zn().getUserName());
                            this.fUl.setImageDrawable(null);
                            this.fUl.setRadius(com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds40));
                            this.fUl.setTag(b.zn().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fUu.setText(com.baidu.tbadk.core.util.am.A(b.getTime()));
                            } else {
                                this.fUu.setText(com.baidu.tbadk.core.util.am.z(b.getTime()));
                            }
                            t = com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds16);
                            if (!this.fNg.bcA() && !StringUtils.isNull(this.mForumName)) {
                                this.beo.setText(this.fNg.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.beo.setVisibility(0);
                                this.fUx.setVisibility(0);
                                this.fUu.setPadding(t, 0, t, 0);
                            } else {
                                this.beo.setVisibility(8);
                                this.fUx.setVisibility(8);
                                this.fUu.setPadding(0, 0, t, 0);
                            }
                            bxc = b.bxc();
                            if (bxc == null && !TextUtils.isEmpty(bxc.getName()) && !TextUtils.isEmpty(bxc.getName().trim())) {
                                final String name = bxc.getName();
                                final String lat = bxc.getLat();
                                final String lng = bxc.getLng();
                                this.fUv.setVisibility(0);
                                this.fUw.setVisibility(0);
                                this.fUv.setText(bxc.getName());
                                this.fUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.oJ()) {
                                                ar.this.fNg.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.b.R(ar.this.fNg.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, ar.this.fNg.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fUv.setVisibility(8);
                                this.fUw.setVisibility(8);
                            }
                            portrait = b.zn().getPortrait();
                            if (b.zn().getPendantData() == null && !StringUtils.isNull(b.zn().getPendantData().ya())) {
                                UtilHelper.showHeadImageViewBigV(this.fUj.getHeadView(), b.zn());
                                this.fUl.setVisibility(8);
                                this.fUj.setVisibility(0);
                                if (this.fUp != null) {
                                    this.fUp.setVisibility(8);
                                }
                                this.fUg.setOnClickListener(this.fWt);
                                this.fUj.getHeadView().startLoad(portrait, 28, false);
                                this.fUj.getHeadView().setUserId(b.zn().getUserId());
                                this.fUj.getHeadView().setUserName(b.zn().getUserName());
                                this.fUj.getHeadView().setOnClickListener(this.fWt);
                                this.fUj.eS(b.zn().getPendantData().ya());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fUl, b.zn());
                                this.fUl.setVisibility(0);
                                this.fUe.setOnClickListener(this.fWt);
                                this.fUg.setOnClickListener(this.fWt);
                                this.fUl.setOnClickListener(this.fWt);
                                this.fUj.setVisibility(8);
                                this.fUl.startLoad(portrait, 28, false);
                            }
                            String name_show = b.zn().getName_show();
                            String userName = b.zn().getUserName();
                            if (com.baidu.tbadk.o.af.nv() && name_show != null && !name_show.equals(userName)) {
                                this.fUg.setText(com.baidu.tieba.pb.c.am(this.fNg.getPageContext().getPageActivity(), this.fUg.getText().toString()));
                                this.fUg.setGravity(16);
                                this.fUg.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bab());
                                com.baidu.tbadk.core.util.aj.e(this.fUg, d.C0141d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.zn().getIconInfo();
                        tShowInfoNew = b.zn().getTShowInfoNew();
                        if (this.fOo != null) {
                        }
                        if (this.fOn != null) {
                        }
                        this.fUg.setText(af(b.zn().getSealPrefix(), e));
                        this.fUg.setTag(d.g.tag_user_id, b.zn().getUserId());
                        this.fUg.setTag(d.g.tag_user_name, b.zn().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fUg, d.C0141d.cp_cont_h, 1);
                        this.fUh.setVisibility(8);
                        if (dVar.bau().zn() != null) {
                            if (dVar.bau().zn().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fUl.setUserId(b.zn().getUserId());
                        this.fUl.setUserName(b.zn().getUserName());
                        this.fUl.setImageDrawable(null);
                        this.fUl.setRadius(com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds40));
                        this.fUl.setTag(b.zn().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        t = com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds16);
                        if (!this.fNg.bcA()) {
                        }
                        this.beo.setVisibility(8);
                        this.fUx.setVisibility(8);
                        this.fUu.setPadding(0, 0, t, 0);
                        bxc = b.bxc();
                        if (bxc == null) {
                        }
                        this.fUv.setVisibility(8);
                        this.fUw.setVisibility(8);
                        portrait = b.zn().getPortrait();
                        if (b.zn().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fUl, b.zn());
                        this.fUl.setVisibility(0);
                        this.fUe.setOnClickListener(this.fWt);
                        this.fUg.setOnClickListener(this.fWt);
                        this.fUl.setOnClickListener(this.fWt);
                        this.fUj.setVisibility(8);
                        this.fUl.startLoad(portrait, 28, false);
                        String name_show2 = b.zn().getName_show();
                        String userName2 = b.zn().getUserName();
                        if (com.baidu.tbadk.o.af.nv()) {
                            this.fUg.setText(com.baidu.tieba.pb.c.am(this.fNg.getPageContext().getPageActivity(), this.fUg.getText().toString()));
                            this.fUg.setGravity(16);
                            this.fUg.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bab());
                            com.baidu.tbadk.core.util.aj.e(this.fUg, d.C0141d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aX(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.zn().getIconInfo();
                            tShowInfoNew = b.zn().getTShowInfoNew();
                            if (this.fOo != null) {
                            }
                            if (this.fOn != null) {
                            }
                            this.fUg.setText(af(b.zn().getSealPrefix(), e));
                            this.fUg.setTag(d.g.tag_user_id, b.zn().getUserId());
                            this.fUg.setTag(d.g.tag_user_name, b.zn().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.e(this.fUg, d.C0141d.cp_cont_h, 1);
                            this.fUh.setVisibility(8);
                            if (dVar.bau().zn() != null) {
                            }
                            this.fUl.setUserId(b.zn().getUserId());
                            this.fUl.setUserName(b.zn().getUserName());
                            this.fUl.setImageDrawable(null);
                            this.fUl.setRadius(com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds40));
                            this.fUl.setTag(b.zn().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            t = com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds16);
                            if (!this.fNg.bcA()) {
                            }
                            this.beo.setVisibility(8);
                            this.fUx.setVisibility(8);
                            this.fUu.setPadding(0, 0, t, 0);
                            bxc = b.bxc();
                            if (bxc == null) {
                            }
                            this.fUv.setVisibility(8);
                            this.fUw.setVisibility(8);
                            portrait = b.zn().getPortrait();
                            if (b.zn().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fUl, b.zn());
                            this.fUl.setVisibility(0);
                            this.fUe.setOnClickListener(this.fWt);
                            this.fUg.setOnClickListener(this.fWt);
                            this.fUl.setOnClickListener(this.fWt);
                            this.fUj.setVisibility(8);
                            this.fUl.startLoad(portrait, 28, false);
                            String name_show22 = b.zn().getName_show();
                            String userName22 = b.zn().getUserName();
                            if (com.baidu.tbadk.o.af.nv()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.zn().getIconInfo();
                        tShowInfoNew = b.zn().getTShowInfoNew();
                        if (this.fOo != null) {
                        }
                        if (this.fOn != null) {
                        }
                        this.fUg.setText(af(b.zn().getSealPrefix(), e));
                        this.fUg.setTag(d.g.tag_user_id, b.zn().getUserId());
                        this.fUg.setTag(d.g.tag_user_name, b.zn().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fUg, d.C0141d.cp_cont_h, 1);
                        this.fUh.setVisibility(8);
                        if (dVar.bau().zn() != null) {
                        }
                        this.fUl.setUserId(b.zn().getUserId());
                        this.fUl.setUserName(b.zn().getUserName());
                        this.fUl.setImageDrawable(null);
                        this.fUl.setRadius(com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds40));
                        this.fUl.setTag(b.zn().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        t = com.baidu.adp.lib.util.l.t(this.fNg.getActivity(), d.e.ds16);
                        if (!this.fNg.bcA()) {
                        }
                        this.beo.setVisibility(8);
                        this.fUx.setVisibility(8);
                        this.fUu.setPadding(0, 0, t, 0);
                        bxc = b.bxc();
                        if (bxc == null) {
                        }
                        this.fUv.setVisibility(8);
                        this.fUw.setVisibility(8);
                        portrait = b.zn().getPortrait();
                        if (b.zn().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fUl, b.zn());
                        this.fUl.setVisibility(0);
                        this.fUe.setOnClickListener(this.fWt);
                        this.fUg.setOnClickListener(this.fWt);
                        this.fUl.setOnClickListener(this.fWt);
                        this.fUj.setVisibility(8);
                        this.fUl.startLoad(portrait, 28, false);
                        String name_show222 = b.zn().getName_show();
                        String userName222 = b.zn().getUserName();
                        if (com.baidu.tbadk.o.af.nv()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fUd.Z(dVar.bau());
                }
                if (this.fVz != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHX);
                    if (dVar != null && dVar.bau() != null) {
                        hVar.fHZ = dVar.bau().zf();
                    }
                    hVar.isNew = !this.fIT;
                    hVar.fIb = this.fNg.bcz();
                    this.fVz.a(hVar);
                }
            }
        }
    }

    public void kM(boolean z) {
        if (z) {
            bfl();
        } else {
            bfm();
        }
        this.fVD.fWL = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVD));
        a(this.fVD.fWL, false);
    }

    public void bfl() {
        if (this.fTU != null && !this.fVU) {
            this.fTU.lh(!StringUtils.isNull(this.fNg.bbY()));
            this.fVU = true;
        }
    }

    public void bfm() {
        if (this.fTU != null) {
            this.fTU.bgo();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.zJ() != null) {
            this.fUf.a(this.fNg.getPageContext(), dVar.baw().get(0).zJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.bas().getId(), dVar.bas().getName(), dVar.bau().getId(), this.fNg.bcw() ? "FRS" : null));
            this.fUe.setPadding(this.fUe.getPaddingLeft(), (int) this.fNg.getResources().getDimension(d.e.ds20), this.fUe.getPaddingRight(), this.fUe.getPaddingBottom());
            return;
        }
        this.fUf.a(null, null, null);
    }

    public void bfn() {
        if (this.fTO != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").s("obj_type", 1));
            this.fTO.bhx();
            this.fTY.smoothScrollToPosition(0);
        }
    }

    public boolean bfo() {
        return this.fWu;
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
            this.fTU.bgm();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fTU.ol(cVar.forumName);
            }
            String string = this.fNg.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.h(cVar.source, 0)) {
                case 100:
                    str = this.fNg.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.fNg.getResources().getString(d.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fNg.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fHi;
            this.fNg.showNetRefreshView(this.dpn, format, null, this.fNg.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.pa()) {
                        com.baidu.tbadk.core.util.aw.Du().c(ar.this.fNg.getPageContext(), new String[]{str2});
                        ar.this.fNg.finish();
                        return;
                    }
                    ar.this.fNg.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bev;
        Parcelable bev2;
        String str;
        if (dVar != null) {
            this.fQo = dVar;
            this.mType = i;
            if (dVar.bau() != null) {
                this.fVF = dVar.bau().yY();
                if (dVar.bau().getAnchorLevel() != 0) {
                    this.fWu = true;
                }
                this.fVb = ab(dVar.bau());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fVp = false;
            this.fIT = z;
            bfh();
            b(dVar, z, i);
            p(dVar);
            if (this.fWg == null) {
                this.fWg = new ab(this.fNg.getPageContext(), this.dVW);
            }
            this.fWg.qv(dVar.baz());
            if (this.fNg.bcn()) {
                if (this.fUJ == null) {
                    this.fUJ = new com.baidu.tieba.pb.view.h(this.fNg.getPageContext());
                    this.fUJ.st();
                    this.fUJ.a(this.bcH);
                }
                this.fTY.setPullRefresh(this.fUJ);
                bfp();
                if (this.fUJ != null) {
                    this.fUJ.gx(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.yA().yx() == 0 && z) {
                this.fTY.setPullRefresh(null);
            } else {
                if (this.fUJ == null) {
                    this.fUJ = new com.baidu.tieba.pb.view.h(this.fNg.getPageContext());
                    this.fUJ.st();
                    this.fUJ.a(this.bcH);
                }
                this.fTY.setPullRefresh(this.fUJ);
                bfp();
                if (this.fUJ != null) {
                    this.fUJ.gx(TbadkCoreApplication.getInst().getSkinType());
                }
                agg();
            }
            bfs();
            this.fUF.jV(this.fIT);
            this.fUF.jW(false);
            this.fUF.kh(i == 5);
            this.fUF.ki(i == 6);
            this.fUF.kj(z2 && this.fWs);
            this.fUF.a(dVar, false);
            this.fUF.notifyDataSetChanged();
            if (this.fNg.bcA()) {
                this.fVW = 0;
                PostData b = b(dVar, z);
                if (b != null && b.zn() != null) {
                    this.fVW = b.zn().getLevel_id();
                }
                if (this.fVW > 0) {
                    this.fUi.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.fUi, BitmapHelper.getGradeResourceIdInEnterForum(this.fVW));
                } else {
                    this.fUi.setVisibility(8);
                }
            } else {
                this.fUi.setVisibility(8);
            }
            if (dVar.bau() != null) {
                if (dVar.bau().zc() != null) {
                    if (dVar.bau().zc().getNum() < 1) {
                        str = this.fNg.getResources().getString(d.j.zan);
                    } else {
                        str = dVar.bau().zc().getNum() + "";
                    }
                    if (this.fTN != -1) {
                        dVar.bau().zc().setIsLike(this.fTN);
                    }
                    Q(str, dVar.bau().zc().getIsLike() == 1);
                }
                if (dVar.bau().aQm != null && dVar.bau().aQm.isDeleted) {
                    this.fTU.lb(true);
                } else {
                    this.fTU.lb(false);
                }
            }
            if (this.fNg.isLogin()) {
                this.fTY.setNextPage(this.dIN);
                this.fTT = 2;
                agg();
            } else {
                this.fVp = true;
                if (dVar.yA().yw() == 1) {
                    if (this.fUK == null) {
                        this.fUK = new com.baidu.tieba.pb.view.b(this.fNg.getPageContext());
                    }
                    this.fTY.setNextPage(this.fUK);
                } else {
                    this.fTY.setNextPage(this.dIN);
                }
                this.fTT = 3;
            }
            ArrayList<PostData> baw = dVar.baw();
            if (dVar.yA().yw() == 0 || baw == null || baw.size() < dVar.yA().yv()) {
                if (com.baidu.tbadk.core.util.v.D(baw) == 0 || (com.baidu.tbadk.core.util.v.D(baw) == 1 && baw.get(0) != null && baw.get(0).bwY() == 1)) {
                    this.dIN.setText(this.fNg.getResources().getString(d.j.list_no_more_new));
                    if (this.fNg.bbQ() != null && !this.fNg.bbQ().bgd()) {
                        this.fNg.bbQ().showFloatingView();
                    }
                } else {
                    this.dIN.setText(this.fNg.getResources().getString(d.j.list_has_no_more));
                }
                if (this.fNg.bcn() && this.fTY != null && this.fTY.getData() != null && this.fTY.getData().size() == 1 && (this.fTY.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dIN.setText("");
                }
                bfz();
            } else if (z2) {
                if (this.fWs) {
                    Eh();
                    if (dVar.yA().yw() != 0) {
                        this.dIN.setText(this.fNg.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.dIN.Ec();
                    this.dIN.showLoading();
                }
            } else {
                this.dIN.Ec();
                this.dIN.showLoading();
            }
            switch (i) {
                case 2:
                    this.fTY.setSelection(i2 > 1 ? (((this.fTY.getData() == null && dVar.baw() == null) ? 0 : (this.fTY.getData().size() - dVar.baw().size()) + this.fTY.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bev2 = ai.beu().bev()) != null) {
                        this.fTY.onRestoreInstanceState(bev2);
                        if (com.baidu.tbadk.core.util.v.D(baw) > 1 && dVar.yA().yw() > 0) {
                            this.dIN.Eh();
                            this.dIN.setText(this.fNg.getString(d.j.pb_load_more_without_point));
                            this.dIN.Ed();
                            break;
                        }
                    } else {
                        this.fTY.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fWs = false;
                    break;
                case 5:
                    this.fTY.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bev = ai.beu().bev()) != null) {
                        this.fTY.onRestoreInstanceState(bev);
                        break;
                    } else {
                        this.fTY.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fTO != null && this.fTO.bhw() != null) {
                            if (this.fNg.isUseStyleImmersiveSticky()) {
                                this.fTY.setSelectionFromTop((this.fUF.bcP() + this.fTY.getHeaderViewsCount()) - 1, this.fTO.bhw().getHeight() - com.baidu.adp.lib.util.l.p(this.fNg.getPageContext().getPageActivity()));
                            } else {
                                this.fTY.setSelectionFromTop((this.fUF.bcP() + this.fTY.getHeaderViewsCount()) - 1, this.fTO.bhw().getHeight());
                            }
                        } else {
                            this.fTY.setSelection(this.fUF.bcP() + this.fTY.getHeaderViewsCount());
                        }
                    } else {
                        this.fTY.setSelection(i2 > 0 ? ((this.fTY.getData() == null && dVar.baw() == null) ? 0 : (this.fTY.getData().size() - dVar.baw().size()) + this.fTY.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dIN.Eh();
                    this.dIN.setText(this.fNg.getString(d.j.pb_load_more_without_point));
                    this.dIN.Ed();
                    break;
            }
            if (this.fVF == fVG && isHost()) {
                bfH();
            }
            if (this.fVQ) {
                beG();
                this.fVQ = false;
                if (i3 == 0) {
                    kF(true);
                }
            }
            if (this.fTQ != null) {
                this.fTQ.ag(dVar.bau());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fHO == 1 || dVar.fHP == 1) {
                if (this.fVX == null) {
                    this.fVX = new PbTopTipView(this.fNg);
                }
                if (dVar.fHP == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fNg.getStType())) {
                    this.fVX.setText(this.fNg.getString(d.j.pb_read_strategy_add_experience));
                    this.fVX.show(this.dpn, this.mSkinType);
                } else if (dVar.fHO == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fNg.getStType())) {
                    this.fVX.setText(this.fNg.getString(d.j.pb_read_news_add_experience));
                    this.fVX.show(this.dpn, this.mSkinType);
                }
            }
        }
    }

    private void bfp() {
        if (this.fTO != null && this.fTO.bhw() != null) {
            this.fTY.removeHeaderView(this.boB);
            if (this.mType != 1) {
                this.fTY.removeHeaderView(this.fTO.bhy());
                this.fTY.addHeaderView(this.fTO.bhy(), 0);
                return;
            }
            return;
        }
        if (this.fTO != null) {
            this.fTY.removeHeaderView(this.fTO.bhy());
        }
        this.fTY.removeHeaderView(this.boB);
        this.fTY.addHeaderView(this.boB, 0);
    }

    public void kN(boolean z) {
        this.fVa = z;
    }

    public void Eh() {
        if (this.dIN != null) {
            this.dIN.Ed();
            this.dIN.Eh();
        }
        agg();
    }

    public void aik() {
        this.fTY.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fVo != null && this.fVo.zn() != null && this.fTU != null) {
            this.fVT = !this.fVS;
            this.fTU.la(this.fVT);
            if (this.fNg.bbQ() != null) {
                this.fNg.bbQ().kZ(this.fVT);
            }
            bfq();
            if (this.fVT) {
                this.fTU.fYT.setVisibility(0);
                if (this.fVb) {
                    this.fTU.fYU.setVisibility(8);
                    this.fUq.setVisibility(8);
                    this.fUt.setVisibility(0);
                    this.fUt.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(dVar.baP())));
                } else if (!PbNormalLikeButtonSwitchStatic.OP() || (this.fVo.zn().hadConcerned() && this.fVo.zn().getGodUserData() != null && this.fVo.zn().getGodUserData().getIsFromNetWork())) {
                    this.fTU.fYU.setVisibility(8);
                }
                if (this.fVy != null) {
                    this.fVy.setVisibility(8);
                }
                this.fTU.a(this.fVo.zn(), this.fWt);
                if (this.fWe == null) {
                    this.fWe = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fVV) {
                                ar.this.bfG();
                            }
                        }
                    };
                }
                this.fTY.setListViewDragListener(this.fWe);
                return;
            }
            if (this.fTU.fYT != null) {
                this.fTU.fYT.setVisibility(8);
            }
            if (this.fVy != null) {
                this.fVy.setVisibility(0);
            }
            if (this.fVb) {
                this.fUq.setVisibility(8);
                this.fUt.setVisibility(0);
                this.fUt.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(dVar.baP())));
            } else if (!PbNormalLikeButtonSwitchStatic.OP() || (this.fVo.zn().hadConcerned() && this.fVo.zn().getGodUserData() != null && this.fVo.zn().getGodUserData().getIsFromNetWork())) {
                this.fUq.setVisibility(8);
                this.fUt.setVisibility(8);
            } else {
                this.fUt.setVisibility(8);
            }
            this.fWe = null;
            this.fTY.setListViewDragListener(null);
        }
    }

    private void bfq() {
        String threadId = this.fQo != null ? this.fQo.getThreadId() : "";
        int bfr = bfr();
        if (this.fVT) {
            if (this.fUs == null) {
                this.fUs = new ap(this.fNg.getPageContext(), this.fTU.fYU, 3);
                this.fUs.h(this.fNg.getUniqueId());
            }
            if (this.fVo != null && this.fVo.zn() != null) {
                this.fVo.zn().setIsLike(this.fVo.zn().hadConcerned());
                this.fUs.a(this.fVo.zn());
            }
            this.fUs.cV(threadId);
            this.fUs.tb(bfr);
            this.fUs.fTJ = this.fVS;
        }
        if (this.fUr == null) {
            this.fUr = new ap(this.fNg.getPageContext(), this.fUq, 1);
            this.fUr.h(this.fNg.getUniqueId());
            this.fUr.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bA(boolean z) {
                    if (ar.this.fNg != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fNg, d.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fNg.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fVo != null && this.fVo.zn() != null) {
            this.fVo.zn().setIsLike(this.fVo.zn().hadConcerned());
            this.fUr.a(this.fVo.zn());
            this.fUr.cV(threadId);
        }
        this.fUr.fTJ = this.fVS;
        this.fUr.tb(bfr);
    }

    private int bfr() {
        if (this.fQo == null || this.fQo.bau() == null) {
            return 0;
        }
        if (this.fQo.bau().Aw()) {
            return (com.baidu.tbadk.core.util.v.E(this.fQo.baO()) && (this.fQo.bat() == null || StringUtils.isNull(this.fQo.bat().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bfs() {
        boolean z;
        if (this.fVe != null && this.fVe.getVisibility() == 0) {
            if (this.fUB != null) {
                this.fUB.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fUB != null) {
                this.fUB.setVisibility(8);
            }
            z = false;
        }
        if ((this.fUD == null || this.fUD.getVisibility() == 8) && z && this.fIT) {
            this.fUC.setVisibility(0);
        } else {
            this.fUC.setVisibility(8);
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
        return !(dVar.bau().zm() == null || dVar.bau().zm().AJ() == 0) || dVar.bau().zi() == 1 || dVar.bau().zj() == 1 || dVar.bau().zS() || dVar.bau().Ad() || dVar.bau().zZ() || dVar.bau().zA() != null || !com.baidu.tbadk.core.util.am.isEmpty(dVar.bau().getCategory()) || dVar.bau().zr() || dVar.bau().zq();
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str));
            return com.baidu.tieba.card.j.a((Context) this.fNg.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fUa != null) {
                if (dVar.bau() != null && dVar.bau().zD() == 0 && !dVar.bau().Aa() && !this.fWi) {
                    this.fUa.setVisibility(0);
                    if (dVar.bau() != null) {
                        dVar.bau().h(true, q(dVar));
                    }
                    SpannableStringBuilder zN = dVar.bau().zN();
                    this.fUb.setOnTouchListener(new com.baidu.tieba.view.m(zN));
                    if (this.fWf) {
                        this.fUb.setText(dVar.bau().getTitle());
                    } else {
                        this.fUb.setText(zN);
                    }
                    this.fUb.setVisibility(0);
                } else if (dVar.bau().zD() == 1) {
                    if (dVar.bau() != null) {
                        this.fUa.setVisibility(8);
                        this.fTY.removeHeaderView(this.fUa);
                        if (dVar.bau() != null && !dVar.bau().Aa()) {
                            this.fUe.setPadding(this.fUe.getPaddingLeft(), com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.tbds36), this.fUe.getPaddingRight(), this.fUe.getPaddingBottom());
                        }
                    }
                } else {
                    this.fUa.setVisibility(8);
                    this.fTY.removeHeaderView(this.fUa);
                    if (dVar.bau() != null && dVar.bau().Aa()) {
                        this.fUe.setPadding(this.fUe.getPaddingLeft(), 0, this.fUe.getPaddingRight(), this.fUe.getPaddingBottom());
                    } else {
                        this.fUe.setPadding(this.fUe.getPaddingLeft(), com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds48), this.fUe.getPaddingRight(), this.fUe.getPaddingBottom());
                    }
                }
            }
            this.fIT = z;
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
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aOb) != null && tVar.aMj && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fNg.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fNg.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bzl;
    }

    public void qw(String str) {
        if (this.dIN != null) {
            this.dIN.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fTY;
    }

    public int bft() {
        return d.g.richText;
    }

    public TextView bbL() {
        return this.fUd.bbL();
    }

    public void d(BdListView.e eVar) {
        this.fTY.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.bcH = bVar;
        if (this.fUJ != null) {
            this.fUJ.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int yu = alVar.yu();
            int yr = alVar.yr();
            if (this.fUG != null) {
                this.fUG.AV();
            } else {
                this.fUG = new com.baidu.tbadk.core.dialog.a(this.fNg.getPageContext().getPageActivity());
                this.fUH = LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fUG.aO(this.fUH);
                this.fUG.a(d.j.dialog_ok, bVar);
                this.fUG.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bfv();
                        aVar.dismiss();
                    }
                });
                this.fUG.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fVN == null) {
                            ar.this.fVN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fNg.HidenSoftKeyPad((InputMethodManager) ar.this.fNg.getSystemService("input_method"), ar.this.dpn);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.ns().postDelayed(ar.this.fVN, 150L);
                    }
                });
                this.fUG.b(this.fNg.getPageContext()).AV();
            }
            this.fUI = (EditText) this.fUH.findViewById(d.g.input_page_number);
            this.fUI.setText("");
            TextView textView = (TextView) this.fUH.findViewById(d.g.current_page_number);
            if (yu <= 0) {
                yu = 1;
            }
            if (yr <= 0) {
                yr = 1;
            }
            textView.setText(MessageFormat.format(this.fNg.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(yu), Integer.valueOf(yr)));
            this.fNg.ShowSoftKeyPadDelay(this.fUI, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fTY.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fNg.showToast(str);
    }

    public boolean kO(boolean z) {
        if (this.axH == null || !this.axH.Lf()) {
            return false;
        }
        this.axH.Jm();
        return true;
    }

    public void bfu() {
        if (this.fWv != null) {
            while (this.fWv.size() > 0) {
                TbImageView remove = this.fWv.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bfu();
        this.fUF.sN(1);
        if (this.fTO != null) {
            this.fTO.onPause();
        }
    }

    public void onResume() {
        this.fUF.sN(2);
        if (this.fTO != null) {
            this.fTO.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fVP != null) {
            this.fVP.destroy();
        }
        if (this.fWg != null) {
            this.fWg.onDestory();
        }
        if (this.fVX != null) {
            this.fVX.hide();
        }
        if (this.fTR != null) {
            this.fTR.anh();
        }
        if (this.fTQ != null) {
            this.fTQ.onDestroy();
        }
        this.fNg.hideProgressBar();
        if (this.dpl != null && this.dCv != null) {
            this.dpl.b(this.dCv);
        }
        bfv();
        Eh();
        if (this.fVN != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fVN);
        }
        if (this.fUe != null && this.fUp != null) {
            this.fUe.removeView(this.fUk);
            this.fUp = null;
        }
        if (this.fVt != null) {
            this.fVt.clearStatus();
        }
        this.fWo = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fUF.sN(3);
        if (this.dGj != null) {
            this.dGj.setBackgroundDrawable(null);
        }
        if (this.fTO != null) {
            this.fTO.destroy();
        }
        if (this.fUF != null) {
            this.fUF.onDestroy();
        }
        this.fTY.setOnLayoutListener(null);
        if (this.fWc != null) {
            this.fWc.awQ();
        }
        if (this.fVE != null) {
            this.fVE.onDestroy();
        }
        bfQ();
    }

    public boolean te(int i) {
        if (this.fTO != null) {
            return this.fTO.nc(i);
        }
        return false;
    }

    public void bfv() {
        this.fTU.wH();
        if (this.fTR != null) {
            this.fTR.anh();
        }
        com.baidu.adp.lib.util.l.a(this.fNg.getPageContext().getPageActivity(), this.fUI);
        beI();
        if (this.fUY != null) {
            this.fUY.dismiss();
        }
        bfx();
        if (this.fTQ != null) {
            this.fTQ.bhp();
        }
        if (this.fUG != null) {
            this.fUG.dismiss();
        }
        if (this.dFU != null) {
            this.dFU.dismiss();
        }
    }

    public void bfw() {
        this.fTU.wH();
        if (this.fTR != null) {
            this.fTR.anh();
        }
        if (this.fUY != null) {
            this.fUY.dismiss();
        }
        bfx();
        if (this.fTQ != null) {
            this.fTQ.bhp();
        }
        if (this.fUG != null) {
            this.fUG.dismiss();
        }
        if (this.dFU != null) {
            this.dFU.dismiss();
        }
    }

    public void cW(List<String> list) {
        this.fWb = list;
        if (this.fWc != null) {
            this.fWc.setData(list);
        }
    }

    public void jU(boolean z) {
        this.fUF.jU(z);
    }

    public void kP(boolean z) {
        this.fVd = z;
    }

    public void bfx() {
        if (this.fUP != null) {
            this.fUP.dismiss();
        }
        if (this.fUQ != null) {
            com.baidu.adp.lib.g.g.b(this.fUQ, this.fNg.getPageContext());
        }
        if (this.fUR != null) {
            com.baidu.adp.lib.g.g.b(this.fUR, this.fNg.getPageContext());
        }
        if (this.fUN != null) {
            com.baidu.adp.lib.g.g.b(this.fUN, this.fNg.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fQo, this.fIT);
            d(this.fQo, this.fIT, this.mType);
            this.fNg.getLayoutMode().aQ(i == 1);
            this.fNg.getLayoutMode().aM(this.dpn);
            this.fNg.getLayoutMode().aM(this.fTZ);
            com.baidu.tbadk.core.util.aj.s(this.fUc, d.C0141d.cp_bg_line_d);
            if (this.fTQ != null) {
                this.fTQ.onChangeSkinType(i);
            }
            if (this.fUb != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUb, d.C0141d.cp_cont_b);
                this.fUb.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_link_tip_c));
            }
            if (this.dIN != null) {
                this.dIN.gx(i);
                if (this.bzl != null) {
                    this.fNg.getLayoutMode().aM(this.bzl);
                    com.baidu.tbadk.core.util.aj.s(this.bzl, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fUG != null) {
                this.fUG.c(this.fNg.getPageContext());
            }
            kN(this.fVa);
            this.fUF.notifyDataSetChanged();
            if (this.fUJ != null) {
                this.fUJ.gx(i);
            }
            if (this.axH != null) {
                this.axH.onChangeSkinType(i);
            }
            if (this.fUo != null) {
                this.fUo.gB(i);
            }
            if (this.fUK != null) {
                this.fUK.gx(i);
            }
            if (!com.baidu.tbadk.core.util.v.E(this.cZf)) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.cZf) {
                    aVar.DQ();
                }
            }
            kJ(i == 1);
            beW();
            UtilHelper.setStatusBarBackground(this.dGj, i);
            UtilHelper.setStatusBarBackground(this.fVy, i);
            if (this.fUq != null) {
                this.fUq.onChangeSkinType(i);
            }
            if (this.fUv != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUv, d.C0141d.cp_cont_d);
            }
            if (this.fUu != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUu, d.C0141d.cp_cont_d);
            }
            if (this.fUw != null) {
                com.baidu.tbadk.core.util.aj.s(this.fUw, d.C0141d.cp_cont_e);
            }
            if (this.beo != null) {
                com.baidu.tbadk.core.util.aj.r(this.beo, d.C0141d.cp_cont_d);
            }
            if (this.fUx != null) {
                com.baidu.tbadk.core.util.aj.s(this.fUx, d.C0141d.cp_cont_e);
            }
            if (this.fUh != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUh, d.C0141d.cp_link_tip_a);
            }
            if (this.fUt != null) {
                com.baidu.tbadk.core.util.aj.r(this.fUt, d.C0141d.cp_cont_d);
            }
            if (this.fUy != null) {
                com.baidu.tbadk.n.a.a(this.fNg.getPageContext(), this.fUy);
            }
            if (this.fUW != null) {
                com.baidu.tbadk.n.a.a(this.fNg.getPageContext(), this.fUW);
            }
            if (this.fVO != null) {
                this.fVO.onChangeSkinType(i);
            }
            if (this.fTU != null) {
                if (this.fTO != null) {
                    this.fTO.tk(i);
                } else {
                    this.fTU.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fVg != null) {
                com.baidu.tbadk.core.util.aj.r(this.fVg, d.C0141d.cp_cont_e);
            }
            if (this.fUi != null) {
                com.baidu.tbadk.core.util.aj.c(this.fUi, BitmapHelper.getGradeResourceIdInEnterForum(this.fVW));
            }
            if (this.fWd != null) {
                this.fWd.onChangeSkinType(i);
            }
            if (this.fVE != null) {
                this.fVE.onChangeSkinType();
            }
            if (this.fWa != null) {
                com.baidu.tbadk.core.util.aj.r(this.fWa, d.C0141d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLI = hVar;
        this.fUF.setOnImageClickListener(this.bLI);
        this.fWd.setOnImageClickListener(this.bLI);
    }

    public void h(NoNetworkView.a aVar) {
        this.dCv = aVar;
        if (this.dpl != null) {
            this.dpl.a(this.dCv);
        }
    }

    public void kQ(boolean z) {
        this.fUF.setIsFromCDN(z);
    }

    public Button bfy() {
        return this.fVe;
    }

    public void bfz() {
        if (this.fTT != 2) {
            this.fTY.setNextPage(this.dIN);
            this.fTT = 2;
        }
    }

    public void bfA() {
        if (com.baidu.tbadk.k.p.Ow().Ox()) {
            int lastVisiblePosition = this.fTY.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fTY.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog = tbImageView.getPerfLog();
                                perfLog.ij(1001);
                                perfLog.bAq = true;
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
                        perfLog2.bAq = true;
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
        return this.axH != null && this.axH.getVisibility() == 0;
    }

    public boolean bfC() {
        return this.axH != null && this.axH.Lf();
    }

    public void bfD() {
        if (this.axH != null) {
            this.axH.Jm();
        }
    }

    public void kR(boolean z) {
        if (this.fVf != null) {
            kP(this.fNg.bbM().LH());
            if (this.fVd) {
                kG(z);
            } else {
                kH(z);
            }
        }
    }

    public void bfE() {
        if (this.fVf != null) {
            this.fVf.setVisibility(8);
            this.fVk = false;
            if (this.fVE != null) {
                this.fVE.setVisibility(8);
                kL(false);
            }
            bfQ();
        }
    }

    public void showLoadingDialog() {
        if (this.dgB == null) {
            this.dgB = new com.baidu.tbadk.core.view.b(this.fNg.getPageContext());
        }
        this.dgB.bq(true);
    }

    public void agg() {
        if (this.dgB != null) {
            this.dgB.bq(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fTY.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fTY.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fTO != null) {
            this.fTO.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.flE = getScrollY();
            this.fVD.fWL = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVD));
            a(this.fVD.fWL, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fTO != null) {
            this.fTO.b(absListView, i);
        }
        int headerViewsCount = (i - this.fTY.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fUF.sM(headerViewsCount) == com.baidu.tieba.pb.data.j.fIe) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fTY.getHeaderViewsCount();
        if (this.fUc != null && this.fTU != null) {
            this.fTU.j(this.fUc.getBottom(), this.fUc.getMeasuredHeight(), z2);
        }
        this.fUF.bcT().n(z, this.fVw != null ? this.fVw.getMeasuredHeight() : 0);
        this.fVD.fCU = i;
        this.fVD.fWK = this.fTY.getHeaderViewsCount();
        this.fVD.fWL = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVD));
        a(this.fVD.fWL, false);
    }

    public void bfF() {
        if (this.fNg.isLogin() && this.fQo != null && this.fVT && !this.fVS && !this.fVb && this.fVo != null && this.fVo.zn() != null && !this.fVo.zn().getIsLike() && !this.fVo.zn().hadConcerned()) {
            if (this.fVP == null) {
                this.fVP = new am(this.fNg);
            }
            this.fVP.a(this.fTU.fYT, this.fQo.baS(), this.fVo.zn().getUserId(), this.fQo.getThreadId());
        }
    }

    public void bfG() {
        if (this.fVT && !this.fVS && this.fVo != null && this.fVo.zn() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").s("obj_locate", this.fNg.bcA() ? 2 : 1).s("obj_type", this.fVS ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fNg.getPageContext().getPageActivity(), this.fVo.zn().getUserId(), this.fVo.zn().getUserName(), this.fNg.bbA().bdl(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fVS && this.fVx != null && this.fTU.bgh() != null) {
            int bcQ = this.fUF.bcQ();
            if (bcQ > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (bcQ > this.fTY.getFirstVisiblePosition() - this.fTY.getHeaderViewsCount()) {
                    this.fVx.setVisibility(8);
                    return;
                }
                this.fVx.setVisibility(0);
                this.fTU.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fTh == null) {
                if (this.fTY.getFirstVisiblePosition() == 0) {
                    this.fVx.setVisibility(8);
                    this.fTU.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fVC) {
                        this.fVB = top;
                        this.fVC = false;
                    }
                    this.fVB = top < this.fVB ? top : this.fVB;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.fUE.getY() < 0.0f) {
                        measuredHeight = fVA - akVar.fTh.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fTU.bgh().getMeasuredHeight() - akVar.fTh.getMeasuredHeight();
                        this.fTU.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fVB) {
                        this.fVx.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fVx.setVisibility(0);
                    } else {
                        this.fVx.setVisibility(8);
                        this.fTU.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fVC = true;
                    }
                }
            }
        }
    }

    public void bfH() {
        if (!this.fWw) {
            TiebaStatic.log("c10490");
            this.fWw = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fNg.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fVH, Integer.valueOf(fVJ));
            aVar.fa(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.aO(inflate);
            aVar.aE(sparseArray);
            aVar.a(d.j.grade_button_tips, this.fNg);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fNg.getPageContext()).AV();
        }
    }

    public void qx(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fNg.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fVH, Integer.valueOf(fVK));
        aVar.aE(sparseArray);
        aVar.a(d.j.view, this.fNg);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fNg.getPageContext()).AV();
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
        return this.fVt;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bau() != null && dVar.bau().Ad() && this.fVt == null) {
            this.fVt = (PbInterviewStatusView) this.fVs.inflate();
            this.fVt.setOnClickListener(this.dFV);
            this.fVt.setCallback(this.fNg.bcv());
            this.fVt.c(this.fNg, dVar);
        }
    }

    public LinearLayout bfJ() {
        return this.fUE;
    }

    public View bfK() {
        return this.dGj;
    }

    public boolean bfL() {
        return this.fWi;
    }

    public void jZ(boolean z) {
        this.fUd.jZ(z);
    }

    public void qy(String str) {
        if (this.fTV != null) {
            this.fTV.setTitle(str);
        }
    }

    private int kS(boolean z) {
        if (this.fVt == null || this.fVt.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bfM() {
        if (this.fVt != null && this.fVt.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fVt.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fVt.setLayoutParams(layoutParams);
        }
    }

    public boolean bbS() {
        return false;
    }

    public void qz(String str) {
        this.fVg.performClick();
        if (!StringUtils.isNull(str) && this.fNg.bbM() != null && this.fNg.bbM().LB() != null && this.fNg.bbM().LB().getInputView() != null) {
            EditText inputView = this.fNg.bbM().LB().getInputView();
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
            if (this.fVO != null) {
                this.fVO.bcX();
            }
            this.fNg.avj();
            this.fUE.setVisibility(8);
            this.fTU.ld(false);
            this.fNg.kf(false);
            if (this.fTO != null) {
                if (configuration.orientation == 1) {
                    bfJ().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fTY.setIsLandscape(true);
                    this.fTY.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fTY.setIsLandscape(false);
                    if (this.flE > 0) {
                        this.fTY.smoothScrollBy(this.flE, 0);
                    }
                }
                this.fTO.onConfigurationChanged(configuration);
            }
        }
    }

    public void kT(boolean z) {
        this.fTS = z;
    }

    public boolean bfN() {
        return this.fTO != null && this.fTO.bfN();
    }

    public void bfO() {
        if (this.fTO != null) {
            this.fTO.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fTQ != null) {
            this.fTQ.y(j, i);
        }
        if (this.fTO != null) {
            this.fTO.y(j, i);
        }
    }

    public void kk(boolean z) {
        this.fUF.kk(z);
    }

    public void bfP() {
        if (this.fVu == null) {
            LayoutInflater.from(this.fNg.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.dpn, true);
            this.fVu = (ViewGroup) this.dpn.findViewById(d.g.add_experienced_layout);
            this.fVv = (TextView) this.dpn.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.r(this.fVv, d.C0141d.cp_cont_i);
            String string = this.fNg.getResources().getString(d.j.experienced_add_success);
            String string2 = this.fNg.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_h)));
            this.fVv.setText(spannableString);
        }
        this.fVu.setVisibility(0);
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
                        ar.this.fVu.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fVv.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fVv.startAnimation(scaleAnimation);
    }

    public void cz(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fVf.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fNg);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fWa = new TextView(this.fNg);
            this.fWa.setText(d.j.connection_tips);
            this.fWa.setGravity(17);
            this.fWa.setPadding(com.baidu.adp.lib.util.l.t(this.fNg, d.e.ds24), 0, com.baidu.adp.lib.util.l.t(this.fNg, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.t(this.fNg, d.e.ds60);
            if (this.fWa.getParent() == null) {
                frameLayout.addView(this.fWa, layoutParams);
            }
            this.fVZ = new PopupWindow(this.fNg);
            this.fVZ.setContentView(frameLayout);
            this.fVZ.setHeight(-2);
            this.fVZ.setWidth(-2);
            this.fVZ.setFocusable(true);
            this.fVZ.setOutsideTouchable(false);
            this.fVZ.setBackgroundDrawable(new ColorDrawable(this.fNg.getResources().getColor(d.C0141d.transparent)));
            this.fTY.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fVZ.showAsDropDown(ar.this.fVf, view.getLeft(), -ar.this.fVf.getHeight());
                    } else {
                        ar.this.fVZ.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bfZ() != null && !StringUtils.isNull(aVar.bfZ().pkg_id) && !StringUtils.isNull(aVar.bfZ().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fVh != null && this.fVh.getVisibility() == 0) {
            if (this.fVY == null) {
                View inflate = LayoutInflater.from(this.fNg.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dFV);
                this.fVY = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fVh.getLocationInWindow(iArr);
            this.fVY.showAtLocation(this.fVh, 0, iArr[0] - com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fVh.getHeight()) - com.baidu.adp.lib.util.l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bfQ() {
        com.baidu.adp.lib.g.g.b(this.fVY);
    }

    public void setIsInterviewLive(boolean z) {
        this.fWf = z;
    }

    public boolean getIsInterviewLive() {
        return this.fWf;
    }

    public void cA(View view) {
        this.fUW = view;
    }
}
