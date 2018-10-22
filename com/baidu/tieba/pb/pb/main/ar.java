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
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
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
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class ar {
    private EditorTools SY;
    private j.b aEo;
    private TextView aFR;
    private TextView aQj;
    private View baU;
    private com.baidu.tieba.pb.a.c bnE;
    private List<CustomBlueCheckRadioButton> cPt;
    private View cTy;
    private View.OnClickListener dCe;
    private View dCt;
    private PbListView dFQ;
    private NavigationBarCoverTip dWu;
    private com.baidu.tieba.NEGFeedBack.e dZq;
    private NoNetworkView dgC;
    private RelativeLayout dgE;
    PbActivity.d fLL;
    private PbActivity fMF;
    private UserIconBox fNP;
    private UserIconBox fNQ;
    private View.OnClickListener fNd;
    private PbFakeFloorModel fOY;
    private com.baidu.tieba.pb.data.d fQf;
    private com.baidu.tieba.pb.video.h fTA;
    private com.baidu.tieba.c.d fTB;
    public final com.baidu.tieba.pb.pb.main.view.b fTE;
    public com.baidu.tieba.pb.pb.main.view.a fTF;
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
    private com.baidu.tbadk.core.dialog.a fVL;
    private List<String> fVM;
    private com.baidu.tieba.pb.pb.main.emotion.c fVN;
    private com.baidu.tieba.pb.pb.godreply.a fVO;
    private PbLandscapeListView.b fVP;
    private ac fVR;
    private boolean fVT;
    private com.baidu.tbadk.core.view.userLike.c fVU;
    private com.baidu.tbadk.core.view.userLike.c fVV;
    private View fVa;
    private TextView fVb;
    private ViewStub fVc;
    private PbInterviewStatusView fVd;
    private ViewGroup fVe;
    private TextView fVf;
    private FrameLayout fVg;
    private View fVh;
    private View fVi;
    private al fVj;
    private PbEmotionBar fVo;
    private int fVw;
    private Runnable fVx;
    private s fVy;
    private an fVz;
    private Runnable fWa;
    private PbActivity.b fWc;
    private int fWh;
    private boolean isLandscape;
    private int mType;
    private static final int fVk = UtilHelper.getLightStatusBarHeight();
    public static int fVq = 3;
    public static int fVr = 0;
    public static int fVs = 3;
    public static int fVt = 4;
    public static int fVu = 5;
    public static int fVv = 6;
    private static a.InterfaceC0275a fVS = new a.InterfaceC0275a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0275a
        public void onRefresh() {
        }
    };
    private boolean fTC = false;
    private int fTD = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fTK = null;
    private TextView fTL = null;
    public FrsPraiseView fTY = null;
    private ClickableHeaderImageView fTZ = null;
    private View fUn = null;
    private com.baidu.tbadk.core.dialog.a fUq = null;
    private com.baidu.tbadk.core.dialog.b dCd = null;
    private View fUr = null;
    private EditText fUs = null;
    private com.baidu.tieba.pb.view.d fUt = null;
    private com.baidu.tieba.pb.view.a fUu = null;
    private com.baidu.tbadk.core.dialog.a fUw = null;
    private b.InterfaceC0124b eKN = null;
    private TbRichTextView.h bnD = null;
    private NoNetworkView.a dxY = null;
    private Dialog fUx = null;
    private View fUy = null;
    private com.baidu.tbadk.core.dialog.a fUz = null;
    private Dialog fUA = null;
    private Dialog fUB = null;
    private View fUC = null;
    private LinearLayout fUD = null;
    private CompoundButton.OnCheckedChangeListener cPu = null;
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
    private com.baidu.tbadk.core.view.d cWM = null;
    private boolean fMW = false;
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
    private boolean fVQ = false;
    private String fVW = null;
    private CustomMessageListener fVX = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.fVW = null;
            }
        }
    };
    private CustomMessageListener bLU = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fUp != null) {
                ar.this.fUp.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fVY = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fTL != null) {
                ar.this.fTL.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fVZ = new Handler();
    private CustomMessageListener fWb = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fUU = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fWd = true;
    View.OnClickListener fWe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fVC) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (ar.this.fTE != null && ar.this.fTE.fYL != null && view == ar.this.fTE.fYL.getHeadView()) {
                if (ar.this.fTE.fYJ == null || ar.this.fTE.fYJ.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").x("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!ar.this.fVC && ar.this.fQf != null && ar.this.fQf.beV() != null && ar.this.fQf.beV().yv() != null && ar.this.fQf.beV().yv().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").x("obj_locate", 1));
            }
            ar.this.fMF.fKJ.eak.onClick(view);
        }
    };
    private boolean fWf = false;
    String userId = null;
    private final List<TbImageView> fWg = new ArrayList();
    private boolean fWi = false;

    /* loaded from: classes6.dex */
    public static class a {
        public int fDe;
        public al fWw;
        public int headerCount;
    }

    public void kS(boolean z) {
        this.fVA = z;
        if (this.fTI != null) {
            this.fVB = this.fTI.getHeaderViewsCount();
        }
    }

    public void bjh() {
        if (this.fTI != null) {
            int headerViewsCount = this.fTI.getHeaderViewsCount() - this.fVB;
            final int firstVisiblePosition = (this.fTI.getFirstVisiblePosition() == 0 || this.fTI.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fTI.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fTI.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fVn.fWw = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVn));
            final al alVar = this.fVn.fWw;
            final int h = h(alVar);
            final int y = ((int) this.fUo.getY()) + this.fUo.getMeasuredHeight();
            final boolean z = this.fVh.getVisibility() == 0;
            boolean z2 = this.fUo.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fUp.bhv() + this.fTI.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fSX.getMeasuredHeight() : 0;
                if (z2) {
                    this.fTI.setSelectionFromTop(this.fUp.bhv() + this.fTI.getHeaderViewsCount(), fVk - measuredHeight);
                } else {
                    this.fTI.setSelectionFromTop(this.fUp.bhv() + this.fTI.getHeaderViewsCount(), this.fTE.bkQ().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fTI.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fVC) {
                this.fTI.setSelectionFromTop(this.fUp.bhv() + this.fTI.getHeaderViewsCount(), this.fTy.bmf().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fTI.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bhM() {
                        if (h >= 0 && h <= ar.this.dgE.getMeasuredHeight()) {
                            int h2 = ar.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.cTy.getLayoutParams();
                            if (i == 0 || i > ar.this.dgE.getMeasuredHeight() || h2 >= ar.this.dgE.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVw;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.dgE.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVw;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fTI.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.cTy.setLayoutParams(layoutParams);
                        }
                        ar.this.fTI.setOnLayoutListener(null);
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

    public NoNetworkView bji() {
        return this.dgC;
    }

    public void bjj() {
        if (this.SY != null) {
            this.SY.hide();
            if (this.fVN != null) {
                this.fVN.Yk();
            }
        }
    }

    public PbFakeFloorModel bjk() {
        return this.fOY;
    }

    public s bjl() {
        return this.fVy;
    }

    public void bjm() {
        reset();
        bjj();
        this.fVy.bhC();
        le(false);
    }

    private void reset() {
        if (this.fMF != null && this.fMF.bgm() != null && this.SY != null) {
            com.baidu.tbadk.editortools.pb.a.Ld().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bgm = this.fMF.bgm();
            bgm.Lw();
            bgm.KR();
            if (bgm.getWriteImagesInfo() != null) {
                bgm.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bgm.fo(SendView.ALL);
            bgm.fp(SendView.ALL);
            com.baidu.tbadk.editortools.g ff = this.SY.ff(23);
            com.baidu.tbadk.editortools.g ff2 = this.SY.ff(2);
            com.baidu.tbadk.editortools.g ff3 = this.SY.ff(5);
            if (ff2 != null) {
                ff2.pQ();
            }
            if (ff3 != null) {
                ff3.pQ();
            }
            if (ff != null) {
                ff.hide();
            }
            this.SY.invalidate();
        }
    }

    public boolean bjn() {
        return this.fUU;
    }

    public void kT(boolean z) {
        if (this.fUP != null && this.fUQ != null) {
            this.fUQ.setText(e.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fUP.startAnimation(alphaAnimation);
            }
            this.fUP.setVisibility(0);
            this.fUU = true;
            if (this.fVo != null && !this.fVO.isActive()) {
                this.fVo.setVisibility(0);
                kY(true);
            }
        }
    }

    public void kU(boolean z) {
        if (this.fUP != null && this.fUQ != null) {
            this.fUQ.setText(e.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fUP.startAnimation(alphaAnimation);
            }
            this.fUP.setVisibility(0);
            this.fUU = true;
            if (this.fVo != null && !this.fVO.isActive()) {
                this.fVo.setVisibility(0);
                kY(true);
            }
        }
    }

    public PostData bjo() {
        int i = 0;
        if (this.fTI == null) {
            return null;
        }
        int bjp = bjp() - this.fTI.getHeaderViewsCount();
        if (bjp < 0) {
            bjp = 0;
        }
        if (this.fUp.ru(bjp) != null && this.fUp.ru(bjp) != PostData.hcV) {
            i = bjp + 1;
        }
        return this.fUp.getItem(i) instanceof PostData ? (PostData) this.fUp.getItem(i) : null;
    }

    public int bjp() {
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

    public int bjq() {
        return this.fTI.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fQf != null && this.fQf.beX() != null && !this.fQf.beX().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fQf.beX().size() && (postData = this.fQf.beX().get(i)) != null && postData.yv() != null && !StringUtils.isNull(postData.yv().getUserId()); i++) {
                if (this.fQf.beX().get(i).yv().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fVO != null && this.fVO.isActive()) {
                        le(false);
                    }
                    if (this.fVo != null) {
                        this.fVo.lm(true);
                    }
                    this.fVW = postData.yv().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fMF = null;
        this.dgE = null;
        this.dCt = null;
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
        this.dFQ = null;
        this.baU = null;
        this.dCe = null;
        this.fNd = null;
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
        this.fMF = pbActivity;
        this.dCe = onClickListener;
        this.bnE = cVar;
        this.fVF = com.baidu.adp.lib.util.l.aO(this.fMF) / 2;
        this.dgE = (RelativeLayout) LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.new_pb_activity, (ViewGroup) null);
        this.fMF.addContentView(this.dgE, new FrameLayout.LayoutParams(-1, -1));
        this.dWu = (NavigationBarCoverTip) this.fMF.findViewById(e.g.pb_multi_forum_del_tip_view);
        this.dCt = this.fMF.findViewById(e.g.statebar_view);
        this.fUo = (ObservedChangeLinearLayout) this.fMF.findViewById(e.g.title_wrapper);
        this.dgC = (NoNetworkView) this.fMF.findViewById(e.g.view_no_network);
        this.fTI = (PbLandscapeListView) this.fMF.findViewById(e.g.new_pb_list);
        this.fVg = (FrameLayout) this.fMF.findViewById(e.g.root_float_header);
        this.aQj = new TextView(this.fMF.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds88));
        this.fTI.addHeaderView(this.aQj, 0);
        this.fVw = this.fMF.getResources().getDimensionPixelSize(e.C0175e.tbds134);
        this.cTy = new View(this.fMF.getPageContext().getPageActivity());
        this.cTy.setLayoutParams(new AbsListView.LayoutParams(-1, this.fVw));
        this.cTy.setVisibility(4);
        this.fTI.addFooterView(this.cTy);
        this.fTI.setOnTouchListener(this.fMF.bez);
        this.fTE = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fMF.bgQ()) {
            this.fTG = (ViewStub) this.fMF.findViewById(e.g.manga_view_stub);
            this.fTG.setVisibility(0);
            this.fTF = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fTF.show();
            this.fTE.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds120);
        }
        this.aQj.setLayoutParams(layoutParams);
        this.fTE.bkQ().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0241a
            public void bfK() {
                if (ar.this.fTI != null) {
                    if (ar.this.fTy != null) {
                        ar.this.fTy.bmg();
                    }
                    ar.this.fTI.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0241a
            public void bfL() {
                ar.this.fMF.azR();
            }
        }));
        this.fUP = this.fMF.findViewById(e.g.pb_editor_tool_comment);
        this.fUW = com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds90);
        this.fUX = com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds242);
        this.fUQ = (TextView) this.fMF.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_reply_text);
        this.fUS = (ImageView) this.fMF.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_more_img);
        this.fUR = (ImageView) this.fMF.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_emotion_img);
        this.fUT = (TextView) this.fMF.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_praise_icon);
        this.fUT.setVisibility(8);
        this.fUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bjr();
            }
        });
        this.fUR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bks();
                if (ar.this.fMF.checkUpIsLogin()) {
                    if (ar.this.SY != null) {
                        ar.this.bjB();
                        ar.this.SY.aa((View) ar.this.SY.ff(5));
                    }
                    if (ar.this.SY != null) {
                        ar.this.fUU = false;
                        if (ar.this.SY.fi(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fMF, (View) ar.this.SY.fi(2).aTV, false, ar.fVS);
                        }
                    }
                    ar.this.bkf();
                }
            }
        });
        this.fUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bks();
                if (ar.this.fMF.checkUpIsLogin()) {
                    if (ar.this.SY != null) {
                        ar.this.bjB();
                        ar.this.SY.aa((View) ar.this.SY.ff(2));
                    }
                    if (ar.this.SY != null) {
                        ar.this.fUU = false;
                        if (ar.this.SY.fi(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fMF, (View) ar.this.SY.fi(2).aTV, false, ar.fVS);
                        }
                    }
                    ar.this.bkf();
                }
            }
        });
        this.fUT.setOnClickListener(this.dCe);
        this.fUT.setOnTouchListener(this.fMF);
        this.fTJ = LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_item, (ViewGroup) null);
        this.fTM = (LinearLayout) LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_user_item, (ViewGroup) null);
        this.fTN = new e(this.fMF, this.fTM);
        this.fTN.init();
        this.fTN.a(this.fTN.bgl(), this.dCe);
        this.fTO = (ColumnLayout) this.fTM.findViewById(e.g.pb_head_owner_root);
        this.fTP = (ThreadSkinView) this.fTM.findViewById(e.g.pb_thread_skin);
        this.fTO.setOnLongClickListener(this.onLongClickListener);
        this.fTO.setOnTouchListener(this.bnE);
        this.fTO.setVisibility(8);
        this.fTJ.setOnTouchListener(this.bnE);
        this.fVa = this.fTJ.findViewById(e.g.pb_head_activity_join_number_container);
        this.fVa.setVisibility(8);
        this.fVb = (TextView) this.fTJ.findViewById(e.g.pb_head_activity_join_number);
        this.fTQ = (TextView) this.fTO.findViewById(e.g.pb_head_owner_info_user_name);
        this.fTR = (TextView) this.fTO.findViewById(e.g.floor_owner);
        this.fTS = (ImageView) this.fTO.findViewById(e.g.icon_forum_level);
        this.fTU = (FrameLayout) this.fTO.findViewById(e.g.pb_head_headImage_container);
        this.fTV = (HeadImageView) this.fTO.findViewById(e.g.pb_head_owner_photo);
        this.fTT = (HeadPendantView) this.fTO.findViewById(e.g.pb_pendant_head_owner_photo);
        this.fTT.setHasPendantStyle();
        if (this.fTT.getHeadView() != null) {
            this.fTT.getHeadView().setIsRound(true);
            this.fTT.getHeadView().setDrawBorder(false);
        }
        this.fNP = (UserIconBox) this.fTO.findViewById(e.g.show_icon_vip);
        this.fNQ = (UserIconBox) this.fTO.findViewById(e.g.show_icon_yinji);
        this.fTX = (FloatingLayout) this.fTM.findViewById(e.g.pb_head_owner_info_root);
        this.fUa = (PbFirstFloorUserLikeButton) this.fTO.findViewById(e.g.pb_like_button);
        this.fUd = (TextView) this.fTO.findViewById(e.g.pb_views);
        this.aFR = (TextView) this.fTO.findViewById(e.g.view_forum_name);
        this.fUh = this.fTO.findViewById(e.g.line_right_forum_name);
        this.fUe = (TextView) this.fTO.findViewById(e.g.pb_item_first_floor_reply_time);
        this.fUf = (TextView) this.fTO.findViewById(e.g.pb_item_first_floor_location_address);
        this.fUg = this.fTO.findViewById(e.g.line_between_time_and_locate);
        this.fVU = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fVV = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fUl = this.fTJ.findViewById(e.g.new_pb_header_item_line_above_livepost);
        this.fUm = this.fTJ.findViewById(e.g.new_pb_header_item_line_below_livepost);
        this.fTJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.37
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fVc = (ViewStub) this.dgE.findViewById(e.g.interview_status_stub);
        this.fUp = new f(this.fMF, this.fTI);
        this.fUp.u(this.dCe);
        this.fUp.setTbGestureDetector(this.bnE);
        this.fUp.setOnImageClickListener(this.bnD);
        this.fNd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.38
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
                            ar.this.fMF.b(sparseArray);
                            return;
                        }
                        ar.this.bA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 0);
                        sparseArray.put(e.g.tag_check_mute_from, 1);
                        ar.this.fMF.b(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fUp.G(this.fNd);
        bjw();
        this.fTI.addHeaderView(this.fTK);
        this.fTI.addHeaderView(this.fTM);
        this.fTI.addHeaderView(this.fTJ);
        this.dFQ = new PbListView(this.fMF.getPageContext().getPageActivity());
        this.baU = this.dFQ.getView().findViewById(e.g.pb_more_view);
        if (this.baU != null) {
            this.baU.setOnClickListener(this.dCe);
            com.baidu.tbadk.core.util.al.i(this.baU, e.f.pb_foot_more_trans_selector);
        }
        this.dFQ.DK();
        this.dFQ.dT(e.f.pb_foot_more_trans_selector);
        this.dFQ.dV(e.f.pb_foot_more_trans_selector);
        this.fUv = this.fMF.findViewById(e.g.viewstub_progress);
        this.fMF.registerListener(this.fWb);
        this.fTW = com.baidu.tbadk.ala.b.uL().j(this.fMF.getActivity(), 2);
        if (this.fTW != null) {
            this.fTW.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fMF.getResources().getDimensionPixelSize(e.C0175e.ds10);
            if (this.fTW.getParent() == null) {
                this.fTX.addView(this.fTW, aVar);
            }
        }
        this.fOY = new PbFakeFloorModel(this.fMF.getPageContext());
        this.fVy = new s(this.fMF.getPageContext(), this.fOY, this.dgE);
        this.fVy.a(this.fMF.fLH);
        this.fOY.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.fOY.m(postData);
                ar.this.fUp.notifyDataSetChanged();
                ar.this.fVy.bhC();
                ar.this.SY.Jg();
                ar.this.le(false);
            }
        });
        if (this.fMF.bga() != null && !StringUtils.isNull(this.fMF.bga().bit())) {
            this.fMF.showToast(this.fMF.bga().bit());
        }
        this.fVh = this.fMF.findViewById(e.g.pb_expand_blank_view);
        this.fVi = this.fMF.findViewById(e.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fVi.getLayoutParams();
        if (this.fMF.bga() != null && this.fMF.bga().bhS()) {
            this.fVh.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fVi.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fVk;
            this.fVi.setLayoutParams(layoutParams2);
        }
        this.fVj = new al(this.fMF.getPageContext(), this.fMF.findViewById(e.g.pb_reply_expand_view));
        this.fVj.fSX.setVisibility(8);
        this.fVj.J(this.dCe);
        this.fMF.registerListener(this.bLU);
        this.fMF.registerListener(this.fVX);
        this.fMF.registerListener(this.fVY);
        bjs();
        kY(false);
    }

    public void bjr() {
        bks();
        if (!this.fMF.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.fMF.bgy()) {
            com.baidu.tbadk.editortools.pb.d bgm = this.fMF.bgm();
            if (bgm != null && (bgm.Lt() || bgm.Lu())) {
                this.fMF.bgm().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.SY != null) {
                bjB();
            }
            if (this.SY != null) {
                this.fUU = false;
                if (this.SY.fi(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.fMF, (View) this.SY.fi(2).aTV, false, fVS);
                }
            }
            bkf();
        }
    }

    private void bjs() {
        this.fVO = new com.baidu.tieba.pb.pb.godreply.a(this.fMF, this, (ViewStub) this.dgE.findViewById(e.g.more_god_reply_popup));
        this.fVO.q(this.dCe);
        this.fVO.G(this.fNd);
        this.fVO.setOnImageClickListener(this.bnD);
        this.fVO.q(this.dCe);
        this.fVO.setTbGestureDetector(this.bnE);
    }

    public com.baidu.tieba.pb.pb.godreply.a bjt() {
        return this.fVO;
    }

    public View bju() {
        return this.fVh;
    }

    public void bjv() {
        if (this.fTI != null) {
            this.fTI.removeHeaderView(this.fTK);
            this.fTI.removeHeaderView(this.fTM);
            this.fTI.removeHeaderView(this.fTJ);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fVo == null) {
            this.fVo = new PbEmotionBar(this.fMF.getPageContext().getPageActivity());
            kY(true);
            this.fVo.a(this.dgE, aVar, this.fUP.getVisibility() == 0);
            this.fVo.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (ar.this.fMF.bgy()) {
                        if (!StringUtils.isNull(ar.this.fVW)) {
                            emotionImageData.setAuthorNameShow(ar.this.fVW);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fMF.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fMF.getPageContext().getPageActivity(), 25016, str, list, ar.this.fVW, list2)));
                }
            });
            this.fVo.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    ar.this.bks();
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

    private void bjw() {
        if (this.fTK == null) {
            int h = com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.tbds44);
            this.fTK = new LinearLayout(this.fMF.getPageContext().getPageActivity());
            this.fTK.setOrientation(1);
            this.fTK.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fTK.setPadding(h, com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.tbds30), h, com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.tbds40));
            this.fTK.setGravity(17);
            this.fTL = new TextView(this.fMF.getPageContext().getPageActivity());
            this.fTL.setGravity(3);
            this.fTL.setMaxLines(2);
            this.fTL.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            this.fTL.setPadding(0, 0, 0, 0);
            this.fTL.setLineSpacing(com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.fTL, e.d.cp_cont_b);
            this.fTL.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fTL.setVisibility(8);
            if (this.fTL.getParent() == null) {
                this.fTK.addView(this.fTL);
            }
            this.fTK.setOnTouchListener(this.bnE);
            this.fTK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjx() {
        if (this.fMF.bgQ()) {
            this.fTH = (ViewStub) this.fMF.findViewById(e.g.manga_mention_controller_view_stub);
            this.fTH.setVisibility(0);
            if (this.fUi == null) {
                this.fUi = (LinearLayout) this.fMF.findViewById(e.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fMF.getPageContext(), this.fUi);
            }
            if (this.fUj == null) {
                this.fUj = (TextView) this.fUi.findViewById(e.g.manga_prev_btn);
            }
            if (this.fUk == null) {
                this.fUk = (TextView) this.fUi.findViewById(e.g.manga_next_btn);
            }
            this.fUj.setOnClickListener(this.dCe);
            this.fUk.setOnClickListener(this.dCe);
        }
    }

    private void bjy() {
        if (this.fMF.bgQ()) {
            if (this.fMF.bgT() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fUj, e.d.cp_cont_e, 1);
            }
            if (this.fMF.bgU() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fUk, e.d.cp_cont_e, 1);
            }
        }
    }

    public void bjz() {
        if (this.fUi == null) {
            bjx();
        }
        this.fTH.setVisibility(8);
        if (this.fVZ != null && this.fWa != null) {
            this.fVZ.removeCallbacks(this.fWa);
        }
    }

    public void bjA() {
        if (this.fVZ != null) {
            if (this.fWa != null) {
                this.fVZ.removeCallbacks(this.fWa);
            }
            this.fWa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fUi == null) {
                        ar.this.bjx();
                    }
                    ar.this.fTH.setVisibility(0);
                }
            };
            this.fVZ.postDelayed(this.fWa, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void kV(boolean z) {
        this.fTE.kV(z);
        if (z && this.fUZ) {
            this.dFQ.setText(this.fMF.getResources().getString(e.j.click_load_more));
            this.fTI.setNextPage(this.dFQ);
            this.fTD = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
        this.SY.setId(e.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.SY.getParent() == null) {
            this.dgE.addView(this.SY, layoutParams);
        }
        this.SY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bjj();
        this.fMF.bgm().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.SY != null && ar.this.SY.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fVN == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.SY.getId());
                            ar.this.fVN = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fMF.getPageContext(), ar.this.dgE, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.J(ar.this.fVM)) {
                                ar.this.fVN.setData(ar.this.fVM);
                            }
                            ar.this.fVN.b(ar.this.SY);
                        }
                        ar.this.fVN.sE(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fMF.fKN != null && ar.this.fMF.fKN.bkx() != null) {
                    if (!ar.this.fMF.fKN.bkx().bLt()) {
                        ar.this.fMF.fKN.lj(false);
                    }
                    ar.this.fMF.fKN.bkx().ob(false);
                }
            }
        });
    }

    public void bjB() {
        if (this.fMF != null && this.SY != null) {
            this.SY.pQ();
            if (this.fMF.bgm() != null) {
                this.fMF.bgm().Lk();
            }
            bkf();
        }
    }

    public void U(String str, boolean z) {
        this.fUV = z;
        kW(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kW(boolean z) {
        if (this.fUT != null) {
            if (this.fUV) {
                com.baidu.tbadk.core.util.al.i(this.fUT, e.f.pb_praise_already_click_selector);
                this.fUT.setContentDescription(this.fMF.getResources().getString(e.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.fUT, e.f.pb_praise_normal_click_selector);
            this.fUT.setContentDescription(this.fMF.getResources().getString(e.j.zan));
        }
    }

    public TextView bjC() {
        return this.fUT;
    }

    public void kX(boolean z) {
        if (this.fTI != null && this.aQj != null && this.dCt != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dCt.setVisibility(0);
                } else {
                    this.dCt.setVisibility(8);
                    this.fTI.removeHeaderView(this.aQj);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aQj.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fVk;
                    this.aQj.setLayoutParams(layoutParams);
                }
                bjQ();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aQj.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + lg(true);
                this.aQj.setLayoutParams(layoutParams2);
            }
            bjQ();
            bkn();
        }
    }

    public f bjD() {
        return this.fUp;
    }

    public void a(PbActivity.d dVar) {
        this.fLL = dVar;
    }

    public void bA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fUy == null) {
            this.fUy = LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fMF.getLayoutMode().onModeChanged(this.fUy);
        if (this.fUx == null) {
            this.fUx = new Dialog(this.fMF.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fUx.setCanceledOnTouchOutside(true);
            this.fUx.setCancelable(true);
            this.fUx.setContentView(this.fUy);
            WindowManager.LayoutParams attributes = this.fUx.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.aO(this.fMF.getPageContext().getPageActivity()) * 0.9d);
            this.fUx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUx.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.fUx.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUx.findViewById(e.g.disable_reply_btn);
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
                    if (ar.this.fUx != null && (ar.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUx, ar.this.fMF.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(e.g.tag_del_post_id), ((Integer) sparseArray5.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(e.g.tag_forbid_user_name)) && "".equals(sparseArray.get(e.g.tag_forbid_user_name_show))) || bkm()) {
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
                    if (ar.this.fUx != null && (ar.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUx, ar.this.fMF.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fWc != null) {
                        ar.this.fWc.m(new Object[]{sparseArray6.get(e.g.tag_manage_user_identity), sparseArray6.get(e.g.tag_forbid_user_name), sparseArray6.get(e.g.tag_forbid_user_post_id), sparseArray6.get(e.g.tag_forbid_user_name_show), sparseArray6.get(e.g.tag_forbid_user_portrait)});
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
                    if (ar.this.fUx != null && (ar.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUx, ar.this.fMF.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fMF.a(z, (String) sparseArray7.get(e.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fUx, this.fMF.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fWc = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fMF != null && aVar != null) {
            if (this.dZq == null) {
                this.dZq = new com.baidu.tieba.NEGFeedBack.e(this.fMF.getPageContext(), this.fTJ);
            }
            AntiData ayQ = this.fMF.ayQ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ayQ != null && ayQ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayQ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.dZq.setDefaultReasonArray(new String[]{this.fMF.getString(e.j.delete_thread_reason_1), this.fMF.getString(e.j.delete_thread_reason_2), this.fMF.getString(e.j.delete_thread_reason_3), this.fMF.getString(e.j.delete_thread_reason_4), this.fMF.getString(e.j.delete_thread_reason_5)});
            this.dZq.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.dZq.iN(str);
            this.dZq.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void k(JSONArray jSONArray) {
                    ar.this.fMF.a(aVar, jSONArray);
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
        sparseArray.put(fVr, Integer.valueOf(fVs));
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
        this.fUz = new com.baidu.tbadk.core.dialog.a(this.fMF.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fUz.cz(i3);
        } else {
            this.fUz.aT(false);
            this.fUz.ej(str2);
        }
        this.fUz.H(sparseArray);
        this.fUz.a(e.j.dialog_ok, this.fMF);
        this.fUz.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUz.aO(true);
        this.fUz.b(this.fMF.getPageContext());
        if (z) {
            this.fUz.Au();
        } else {
            a(this.fUz, i);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fUC == null) {
            this.fUC = LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.commit_good, (ViewGroup) null);
        }
        this.fMF.getLayoutMode().onModeChanged(this.fUC);
        if (this.fUB == null) {
            this.fUB = new Dialog(this.fMF.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fUB.setCanceledOnTouchOutside(true);
            this.fUB.setCancelable(true);
            this.fUM = (ScrollView) this.fUC.findViewById(e.g.good_scroll);
            this.fUB.setContentView(this.fUC);
            WindowManager.LayoutParams attributes = this.fUB.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds540);
            this.fUB.getWindow().setAttributes(attributes);
            this.cPu = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fUH = (String) compoundButton.getTag();
                        if (ar.this.cPt != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ar.this.cPt) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ar.this.fUH != null && !str.equals(ar.this.fUH)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fUD = (LinearLayout) this.fUC.findViewById(e.g.good_class_group);
            this.fUF = (TextView) this.fUC.findViewById(e.g.dialog_button_cancel);
            this.fUF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fUB instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUB, ar.this.fMF.getPageContext());
                    }
                }
            });
            this.fUE = (TextView) this.fUC.findViewById(e.g.dialog_button_ok);
            this.fUE.setOnClickListener(this.dCe);
        }
        this.fUD.removeAllViews();
        this.cPt = new ArrayList();
        CustomBlueCheckRadioButton ck = ck("0", this.fMF.getPageContext().getString(e.j.thread_good_class));
        this.cPt.add(ck);
        ck.setChecked(true);
        this.fUD.addView(ck);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xj()) && aaVar.xk() > 0) {
                    CustomBlueCheckRadioButton ck2 = ck(String.valueOf(aaVar.xk()), aaVar.xj());
                    this.cPt.add(ck2);
                    View view = new View(this.fMF.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, e.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fUD.addView(view);
                    this.fUD.addView(ck2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fUM.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fMF.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fMF.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fMF.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fUM.setLayoutParams(layoutParams2);
            this.fUM.removeAllViews();
            if (this.fUD != null && this.fUD.getParent() == null) {
                this.fUM.addView(this.fUD);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fUB, this.fMF.getPageContext());
    }

    private CustomBlueCheckRadioButton ck(String str, String str2) {
        Activity pageActivity = this.fMF.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, e.C0175e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cPu);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bjE() {
        this.fMF.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fMF.hideProgressBar();
        if (z && z2) {
            this.fMF.showToast(this.fMF.getPageContext().getString(e.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.neterror);
            }
            this.fMF.showToast(str);
        }
    }

    public void aRh() {
        this.fUv.setVisibility(0);
    }

    public void aRg() {
        this.fUv.setVisibility(8);
    }

    public View bjF() {
        if (this.fUC != null) {
            return this.fUC.findViewById(e.g.dialog_button_ok);
        }
        return null;
    }

    public String bjG() {
        return this.fUH;
    }

    public View getView() {
        return this.dgE;
    }

    public void bjH() {
        com.baidu.adp.lib.util.l.a(this.fMF.getPageContext().getPageActivity(), this.fMF.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fMF.hideProgressBar();
        if (z) {
            bjW();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bjX();
        } else {
            bjW();
        }
    }

    public void bjI() {
        this.dFQ.DK();
        this.dFQ.DO();
    }

    public void bjJ() {
        this.fMF.hideProgressBar();
        DP();
        this.fTI.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bjT();
    }

    public void bjK() {
        this.fTI.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bjT();
    }

    private void kY(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fUQ.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fMF.getResources().getDimensionPixelSize(e.C0175e.ds130) : this.fMF.getResources().getDimensionPixelSize(e.C0175e.ds34);
        this.fUQ.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fUp.setOnLongClickListener(onLongClickListener);
        if (this.fVO != null) {
            this.fVO.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0124b interfaceC0124b, boolean z, boolean z2) {
        if (this.fUI != null) {
            this.fUI.dismiss();
            this.fUI = null;
        }
        this.fUI = new com.baidu.tbadk.core.dialog.b(this.fMF.getPageContext().getPageActivity());
        this.fUI.cC(e.j.operation);
        if (z2) {
            this.fUI.a(new String[]{this.fMF.getPageContext().getString(e.j.copy), this.fMF.getPageContext().getString(e.j.report_text)}, interfaceC0124b);
        } else if (!z) {
            this.fUI.a(new String[]{this.fMF.getPageContext().getString(e.j.copy), this.fMF.getPageContext().getString(e.j.mark)}, interfaceC0124b);
        } else {
            this.fUI.a(new String[]{this.fMF.getPageContext().getString(e.j.copy), this.fMF.getPageContext().getString(e.j.remove_mark)}, interfaceC0124b);
        }
        this.fUI.d(this.fMF.getPageContext());
        this.fUI.Ax();
    }

    public void a(b.InterfaceC0124b interfaceC0124b, boolean z) {
        if (this.fUJ != null) {
            this.fUJ.dismiss();
            this.fUJ = null;
        }
        this.fUJ = new com.baidu.tbadk.core.dialog.b(this.fMF.getPageContext().getPageActivity());
        if (z) {
            this.fUJ.a(new String[]{this.fMF.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0124b);
        } else {
            this.fUJ.a(new String[]{this.fMF.getPageContext().getString(e.j.save_to_emotion), this.fMF.getPageContext().getString(e.j.save_to_local)}, interfaceC0124b);
        }
        this.fUJ.d(this.fMF.getPageContext());
        this.fUJ.Ax();
    }

    public int bjL() {
        return rL(this.fTI.getFirstVisiblePosition());
    }

    private int rL(int i) {
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

    public int bjM() {
        int lastVisiblePosition = this.fTI.getLastVisiblePosition();
        if (this.fTy != null) {
            if (lastVisiblePosition == this.fTI.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return rL(lastVisiblePosition);
    }

    public void rM(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fTI != null) {
            if (this.fTE == null || this.fTE.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fTE.mNavigationBar.getFixedNavHeight();
                if (!(this.fMF.bgE() != -1)) {
                    if (this.fVi != null && (layoutParams = (LinearLayout.LayoutParams) this.fVi.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fVi.setLayoutParams(layoutParams);
                    }
                    i--;
                    bkr();
                }
                i2 = fixedNavHeight;
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
        bjT();
        if (this.fVO != null) {
            this.fVO.bfW();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fTY == null) {
            this.fMF.getLayoutMode().onModeChanged(((ViewStub) this.fTJ.findViewById(e.g.praise_layout)).inflate());
            this.fTY = (FrsPraiseView) this.fTJ.findViewById(e.g.pb_head_praise_view);
            this.fTY.setIsFromPb(true);
            this.fUn = this.fTJ.findViewById(e.g.new_pb_header_item_line_above_praise);
            this.fTY.ea(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fTY != null) {
            boolean bjT = bjT();
            this.fTY.setVisibility(8);
            if (dVar != null && dVar.xH() != null && dVar.xH().xE() == 0 && this.fMW) {
                if (bjT) {
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
        if (dVar.bff() != null) {
            return dVar.bff();
        }
        if (!com.baidu.tbadk.core.util.v.J(dVar.beX())) {
            Iterator<PostData> it = dVar.beX().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bCb() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bfc();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.yv() != null && postData.yv().getUserTbVipInfoData() != null && postData.yv().getUserTbVipInfoData().getvipIntro() != null) {
            postData.yv().getGodUserData().setIntro(postData.yv().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.beV() == null || dVar.beV().yv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yv = dVar.beV().yv();
        String userId = yv.getUserId();
        HashMap<String, MetaData> userMap = dVar.beV().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yv;
        }
        postData.uG(1);
        postData.setId(dVar.beV().yM());
        postData.setTitle(dVar.beV().getTitle());
        postData.setTime(dVar.beV().getCreateTime());
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
        com.baidu.tbadk.data.f bCe;
        String portrait;
        if (dVar != null && dVar.beV() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fTO.setVisibility(8);
            if (dVar.beV() != null && dVar.beV().zj() && dVar.beV().yN() != null) {
                this.fVC = true;
                this.fTE.lv(this.fVC);
                this.fTE.mNavigationBar.hideBottomLine();
                if (this.fTy == null) {
                    this.fTy = new com.baidu.tieba.pb.video.i(this.fMF, this.fTE, dVar.beV().yN(), this.fTz);
                    this.fTy.a(dVar.beV().yN(), dVar.beV(), dVar.getForumId());
                    this.fTy.startPlay();
                } else if (this.fTC) {
                    this.fTy.a(dVar.beV().yN(), dVar.beV(), dVar.getForumId());
                    this.fTy.startPlay();
                } else {
                    this.fTy.sP(dVar.getForumId());
                }
                if (dVar.beW() != null && dVar.beW().size() >= 1) {
                    bb bbVar = dVar.beW().get(0);
                    this.fTy.as(bbVar);
                    this.fTy.sQ(bbVar.getTitle());
                }
                this.fTy.b(b, dVar.beV(), dVar.bft());
                this.fTC = false;
                this.fTI.removeHeaderView(this.fTy.bmi());
                this.fTI.addHeaderView(this.fTy.bmi(), 0);
                if (this.fTy.bmf() != null && this.fTy.bmf().getParent() == null) {
                    this.fVg.addView(this.fTy.bmf());
                }
                if (this.fTA == null) {
                    this.fTA = new com.baidu.tieba.pb.video.h(this.fMF);
                }
                this.fTA.a(dVar.beV().zy(), dVar.beV(), dVar.bfq());
                this.fTI.removeHeaderView(this.fTA.blW());
                this.fTI.addHeaderView(this.fTA.blW(), 1);
                if (dVar.beV().zy() != null) {
                    this.fTI.removeHeaderView(this.fTA.blX());
                    this.fTI.removeHeaderView(this.fTM);
                    this.fTI.addHeaderView(this.fTA.blX(), 2);
                } else {
                    if (this.fTA.blX() != null) {
                        this.fTI.removeHeaderView(this.fTA.blX());
                    }
                    this.fTI.removeHeaderView(this.fTM);
                    this.fTM.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fMF, e.C0175e.tbds26));
                    this.fTI.addHeaderView(this.fTM, 2);
                }
                if (this.fTy != null) {
                    this.fTE.lp(false);
                    this.fTE.lr(TbadkCoreApplication.isLogin());
                    this.fTy.rS(TbadkCoreApplication.getInst().getSkinType());
                }
                bjQ();
            } else {
                this.fVC = false;
                this.fTE.lv(this.fVC);
                if (this.fTy != null) {
                    this.fTI.removeHeaderView(this.fTy.bmi());
                }
                if (this.fTA != null) {
                    this.fTA.b(this.fTI);
                }
                if (b == null || (b != null && (b.bCd() == null || com.baidu.tbadk.core.util.v.J(b.bCd().QK())))) {
                    this.fTM.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fMF, e.C0175e.tbds52));
                } else {
                    this.fTM.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fMF.bgq() != null) {
                this.fMF.bgq().ln(this.fVC);
            }
            if (this.fTy != null) {
                this.fTy.L(this.fWe);
                bkr();
            }
            if (b != null) {
                this.fUY = b;
                this.fTO.setVisibility(0);
                if (this.fMF.bfQ()) {
                    if (dVar.beU() != null) {
                        this.mForumName = dVar.beU().getForumName();
                        this.mForumId = dVar.beU().getForumId();
                    }
                    if (this.mForumName == null && this.fMF.bga() != null && this.fMF.bga().bfR() != null) {
                        this.mForumName = this.fMF.bga().bfR();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fTO.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fTO.setTag(sparseArray);
                }
                sparseArray.put(e.g.tag_clip_board, b);
                sparseArray.put(e.g.tag_is_subpb, false);
                if (!this.fVT) {
                    this.fTK.setVisibility(0);
                }
                if (!dVar.beV().zj() && this.fTL.getText() != null && this.fTL.getText().length() > 0) {
                    this.fTL.setVisibility(0);
                } else {
                    this.fTL.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> yH = dVar.beV().yH();
                if (yH != null && yH.size() > 0 && !this.fVT) {
                    this.fVb.setText(String.valueOf(yH.get(0).wO()));
                    this.fVa.setVisibility(0);
                } else {
                    this.fVa.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.fVa, e.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.fVb, e.d.cp_link_tip_d, 1);
                if (b.yv() != null) {
                    String string = b.yv().getName_show() == null ? StringUtils.string(b.yv().getUserName()) : StringUtils.string(b.yv().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.yv().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bz(b.yv().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bz(string) > 12) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.yv().getIconInfo();
                            tShowInfoNew = b.yv().getTShowInfoNew();
                            if (this.fNQ != null) {
                                this.fNQ.setTag(e.g.tag_user_id, b.yv().getUserId());
                                this.fNQ.setOnClickListener(this.fMF.fKJ.fXW);
                                this.fNQ.a(iconInfo, 4, this.fMF.getResources().getDimensionPixelSize(e.C0175e.tbds36), this.fMF.getResources().getDimensionPixelSize(e.C0175e.tbds36), this.fMF.getResources().getDimensionPixelSize(e.C0175e.tbds12));
                            }
                            if (this.fNP != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fNP.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fNP.setOnClickListener(this.fMF.fKJ.fXX);
                                this.fNP.a(tShowInfoNew, 3, this.fMF.getResources().getDimensionPixelSize(e.C0175e.tbds36), this.fMF.getResources().getDimensionPixelSize(e.C0175e.tbds36), this.fMF.getResources().getDimensionPixelSize(e.C0175e.ds12), true);
                            }
                            this.fTQ.setText(aB(b.yv().getSealPrefix(), d));
                            this.fTQ.setTag(e.g.tag_user_id, b.yv().getUserId());
                            this.fTQ.setTag(e.g.tag_user_name, b.yv().getName_show());
                            if (com.baidu.tbadk.core.util.v.J(tShowInfoNew) || b.yv().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.fTQ, e.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.fTQ, e.d.cp_cont_f, 1);
                            }
                            this.fTR.setVisibility(8);
                            if (dVar.beV().yv() != null && dVar.beV().yv().getAlaUserData() != null && this.fTW != null) {
                                if (dVar.beV().yv().getAlaUserData().anchor_live != 0) {
                                    this.fTW.setVisibility(8);
                                } else {
                                    this.fTW.setVisibility(0);
                                    if (this.fTB == null) {
                                        this.fTB = new com.baidu.tieba.c.d(this.fMF.getPageContext(), this.fTW);
                                        this.fTB.kn(1);
                                    }
                                    this.fTB.bj(this.fMF.getResources().getString(e.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aht = dVar.beV().yv().getAlaUserData();
                                    aVar.type = 2;
                                    this.fTW.setTag(aVar);
                                }
                            }
                            this.fTV.setUserId(b.yv().getUserId());
                            this.fTV.setUserName(b.yv().getUserName());
                            this.fTV.setTid(b.getId());
                            this.fTV.setFid(this.fQf == null ? this.fQf.getForumId() : "");
                            this.fTV.setImageDrawable(null);
                            this.fTV.setRadius(com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds40));
                            this.fTV.setTag(b.yv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                                this.fUe.setText(com.baidu.tbadk.core.util.ao.E(b.getTime()));
                            } else {
                                this.fUe.setText(com.baidu.tbadk.core.util.ao.C(b.getTime()));
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds16);
                            if (!this.fMF.bfQ() && !StringUtils.isNull(this.mForumName)) {
                                this.aFR.setText(this.fMF.getString(e.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.aFR.setVisibility(0);
                                this.fUh.setVisibility(0);
                                this.fUe.setPadding(h, 0, h, 0);
                            } else {
                                this.aFR.setVisibility(8);
                                this.fUh.setVisibility(8);
                                this.fUe.setPadding(0, 0, h, 0);
                            }
                            bCe = b.bCe();
                            if (bCe == null && !TextUtils.isEmpty(bCe.getName()) && !TextUtils.isEmpty(bCe.getName().trim())) {
                                final String name = bCe.getName();
                                final String lat = bCe.getLat();
                                final String lng = bCe.getLng();
                                this.fUf.setVisibility(0);
                                this.fUg.setVisibility(0);
                                this.fUf.setText(bCe.getName());
                                this.fUf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kX()) {
                                                ar.this.fMF.showToast(e.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ae(ar.this.fMF.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, ar.this.fMF.getPageContext().getString(e.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fUf.setVisibility(8);
                                this.fUg.setVisibility(8);
                            }
                            portrait = b.yv().getPortrait();
                            if (b.yv().getPendantData() == null && !StringUtils.isNull(b.yv().getPendantData().xf())) {
                                UtilHelper.showHeadImageViewBigV(this.fTT.getHeadView(), b.yv());
                                this.fTV.setVisibility(8);
                                this.fTT.setVisibility(0);
                                if (this.fTZ != null) {
                                    this.fTZ.setVisibility(8);
                                }
                                this.fTQ.setOnClickListener(this.fWe);
                                this.fTT.getHeadView().startLoad(portrait, 28, false);
                                this.fTT.getHeadView().setUserId(b.yv().getUserId());
                                this.fTT.getHeadView().setUserName(b.yv().getUserName());
                                this.fTT.getHeadView().setTid(b.getId());
                                this.fTT.getHeadView().setFid(this.fQf != null ? this.fQf.getForumId() : "");
                                this.fTT.getHeadView().setOnClickListener(this.fWe);
                                this.fTT.fT(b.yv().getPendantData().xf());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fTV, b.yv());
                                this.fTV.setVisibility(0);
                                this.fTO.setOnClickListener(this.fWe);
                                this.fTQ.setOnClickListener(this.fWe);
                                this.fTV.setOnClickListener(this.fWe);
                                this.fTT.setVisibility(8);
                                this.fTV.startLoad(portrait, 28, false);
                            }
                            String name_show = b.yv().getName_show();
                            String userName = b.yv().getUserName();
                            if (com.baidu.tbadk.p.am.jL() && name_show != null && !name_show.equals(userName)) {
                                this.fTQ.setText(com.baidu.tieba.pb.c.aD(this.fMF.getPageContext().getPageActivity(), this.fTQ.getText().toString()));
                                this.fTQ.setGravity(16);
                                this.fTQ.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.beD());
                                com.baidu.tbadk.core.util.al.c(this.fTQ, e.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.yv().getIconInfo();
                        tShowInfoNew = b.yv().getTShowInfoNew();
                        if (this.fNQ != null) {
                        }
                        if (this.fNP != null) {
                        }
                        this.fTQ.setText(aB(b.yv().getSealPrefix(), d));
                        this.fTQ.setTag(e.g.tag_user_id, b.yv().getUserId());
                        this.fTQ.setTag(e.g.tag_user_name, b.yv().getName_show());
                        if (com.baidu.tbadk.core.util.v.J(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fTQ, e.d.cp_cont_h, 1);
                        this.fTR.setVisibility(8);
                        if (dVar.beV().yv() != null) {
                            if (dVar.beV().yv().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fTV.setUserId(b.yv().getUserId());
                        this.fTV.setUserName(b.yv().getUserName());
                        this.fTV.setTid(b.getId());
                        this.fTV.setFid(this.fQf == null ? this.fQf.getForumId() : "");
                        this.fTV.setImageDrawable(null);
                        this.fTV.setRadius(com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds40));
                        this.fTV.setTag(b.yv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds16);
                        if (!this.fMF.bfQ()) {
                        }
                        this.aFR.setVisibility(8);
                        this.fUh.setVisibility(8);
                        this.fUe.setPadding(0, 0, h, 0);
                        bCe = b.bCe();
                        if (bCe == null) {
                        }
                        this.fUf.setVisibility(8);
                        this.fUg.setVisibility(8);
                        portrait = b.yv().getPortrait();
                        if (b.yv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fTV, b.yv());
                        this.fTV.setVisibility(0);
                        this.fTO.setOnClickListener(this.fWe);
                        this.fTQ.setOnClickListener(this.fWe);
                        this.fTV.setOnClickListener(this.fWe);
                        this.fTT.setVisibility(8);
                        this.fTV.startLoad(portrait, 28, false);
                        String name_show2 = b.yv().getName_show();
                        String userName2 = b.yv().getUserName();
                        if (com.baidu.tbadk.p.am.jL()) {
                            this.fTQ.setText(com.baidu.tieba.pb.c.aD(this.fMF.getPageContext().getPageActivity(), this.fTQ.getText().toString()));
                            this.fTQ.setGravity(16);
                            this.fTQ.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.beD());
                            com.baidu.tbadk.core.util.al.c(this.fTQ, e.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.yv().getIconInfo();
                            tShowInfoNew = b.yv().getTShowInfoNew();
                            if (this.fNQ != null) {
                            }
                            if (this.fNP != null) {
                            }
                            this.fTQ.setText(aB(b.yv().getSealPrefix(), d));
                            this.fTQ.setTag(e.g.tag_user_id, b.yv().getUserId());
                            this.fTQ.setTag(e.g.tag_user_name, b.yv().getName_show());
                            if (com.baidu.tbadk.core.util.v.J(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.fTQ, e.d.cp_cont_h, 1);
                            this.fTR.setVisibility(8);
                            if (dVar.beV().yv() != null) {
                            }
                            this.fTV.setUserId(b.yv().getUserId());
                            this.fTV.setUserName(b.yv().getUserName());
                            this.fTV.setTid(b.getId());
                            this.fTV.setFid(this.fQf == null ? this.fQf.getForumId() : "");
                            this.fTV.setImageDrawable(null);
                            this.fTV.setRadius(com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds40));
                            this.fTV.setTag(b.yv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds16);
                            if (!this.fMF.bfQ()) {
                            }
                            this.aFR.setVisibility(8);
                            this.fUh.setVisibility(8);
                            this.fUe.setPadding(0, 0, h, 0);
                            bCe = b.bCe();
                            if (bCe == null) {
                            }
                            this.fUf.setVisibility(8);
                            this.fUg.setVisibility(8);
                            portrait = b.yv().getPortrait();
                            if (b.yv().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fTV, b.yv());
                            this.fTV.setVisibility(0);
                            this.fTO.setOnClickListener(this.fWe);
                            this.fTQ.setOnClickListener(this.fWe);
                            this.fTV.setOnClickListener(this.fWe);
                            this.fTT.setVisibility(8);
                            this.fTV.startLoad(portrait, 28, false);
                            String name_show22 = b.yv().getName_show();
                            String userName22 = b.yv().getUserName();
                            if (com.baidu.tbadk.p.am.jL()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.yv().getIconInfo();
                        tShowInfoNew = b.yv().getTShowInfoNew();
                        if (this.fNQ != null) {
                        }
                        if (this.fNP != null) {
                        }
                        this.fTQ.setText(aB(b.yv().getSealPrefix(), d));
                        this.fTQ.setTag(e.g.tag_user_id, b.yv().getUserId());
                        this.fTQ.setTag(e.g.tag_user_name, b.yv().getName_show());
                        if (com.baidu.tbadk.core.util.v.J(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fTQ, e.d.cp_cont_h, 1);
                        this.fTR.setVisibility(8);
                        if (dVar.beV().yv() != null) {
                        }
                        this.fTV.setUserId(b.yv().getUserId());
                        this.fTV.setUserName(b.yv().getUserName());
                        this.fTV.setTid(b.getId());
                        this.fTV.setFid(this.fQf == null ? this.fQf.getForumId() : "");
                        this.fTV.setImageDrawable(null);
                        this.fTV.setRadius(com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds40));
                        this.fTV.setTag(b.yv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fMF.getActivity(), e.C0175e.ds16);
                        if (!this.fMF.bfQ()) {
                        }
                        this.aFR.setVisibility(8);
                        this.fUh.setVisibility(8);
                        this.fUe.setPadding(0, 0, h, 0);
                        bCe = b.bCe();
                        if (bCe == null) {
                        }
                        this.fUf.setVisibility(8);
                        this.fUg.setVisibility(8);
                        portrait = b.yv().getPortrait();
                        if (b.yv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fTV, b.yv());
                        this.fTV.setVisibility(0);
                        this.fTO.setOnClickListener(this.fWe);
                        this.fTQ.setOnClickListener(this.fWe);
                        this.fTV.setOnClickListener(this.fWe);
                        this.fTT.setVisibility(8);
                        this.fTV.startLoad(portrait, 28, false);
                        String name_show222 = b.yv().getName_show();
                        String userName222 = b.yv().getUserName();
                        if (com.baidu.tbadk.p.am.jL()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fTN.ak(dVar.beV());
                }
                if (this.fVj != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fIq);
                    if (dVar != null && dVar.beV() != null) {
                        hVar.fIs = dVar.beV().ym();
                    }
                    hVar.isNew = !this.fMW;
                    hVar.sortType = dVar.fIh;
                    if (dVar.fIg != null && dVar.fIg.size() > dVar.fIh) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.fIg.size()) {
                                break;
                            } else if (dVar.fIg.get(i4).sort_type.intValue() != dVar.fIh) {
                                i3 = i4 + 1;
                            } else {
                                hVar.fIu = dVar.fIg.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.fIv = this.fMF.bhc();
                    this.fVj.a(hVar);
                }
            }
        }
    }

    public void kZ(boolean z) {
        if (z) {
            bjN();
        } else {
            auj();
        }
        this.fVn.fWw = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVn));
        a(this.fVn.fWw, false);
    }

    public void bjN() {
        if (this.fTE != null && !this.fVE) {
            this.fTE.lw(!StringUtils.isNull(this.fMF.bgB()));
            this.fVE = true;
        }
    }

    public void auj() {
        if (this.fTE != null) {
            this.fTE.bkX();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.yR() != null) {
            this.fTP.setData(this.fMF.getPageContext(), dVar.beX().get(0).yR(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.beT().getId(), dVar.beT().getName(), dVar.beV().getId(), this.fMF.bgZ() ? "FRS" : null));
            this.fTO.setPadding(this.fTO.getPaddingLeft(), (int) this.fMF.getResources().getDimension(e.C0175e.ds20), this.fTO.getPaddingRight(), this.fTO.getPaddingBottom());
            return;
        }
        this.fTP.setData(null, null, null);
    }

    public void bjO() {
        if (this.fTy != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").x("obj_type", 1));
            this.fTy.bmg();
            this.fTI.smoothScrollToPosition(0);
        }
    }

    public boolean bjP() {
        return this.fWf;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.yv() == null || bbVar.yv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.yv().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fTE.bkV();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fTE.qr(cVar.forumName);
            }
            String string = this.fMF.getResources().getString(e.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.fMF.getResources().getString(e.j.self);
                    break;
                case 300:
                    str = this.fMF.getResources().getString(e.j.bawu);
                    break;
                case 400:
                    str = this.fMF.getResources().getString(e.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fHy;
            this.fMF.showNetRefreshView(this.dgE, format, null, this.fMF.getResources().getString(e.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lo()) {
                        ay.CU().c(ar.this.fMF.getPageContext(), new String[]{str2});
                        ar.this.fMF.finish();
                        return;
                    }
                    ar.this.fMF.showToast(e.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable biY;
        Parcelable biY2;
        String str;
        if (dVar != null) {
            this.fQf = dVar;
            this.mType = i;
            if (dVar.beV() != null) {
                this.fVp = dVar.beV().ye();
                if (dVar.beV().getAnchorLevel() != 0) {
                    this.fWf = true;
                }
                this.fUL = am(dVar.beV());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fUZ = false;
            this.fMW = z;
            bjJ();
            b(dVar, z, i);
            p(dVar);
            if (this.fVR == null) {
                this.fVR = new ac(this.fMF.getPageContext(), this.dWu);
            }
            this.fVR.sw(dVar.bfa());
            if (this.fMF.bgQ()) {
                if (this.fUt == null) {
                    this.fUt = new com.baidu.tieba.pb.view.d(this.fMF.getPageContext());
                    this.fUt.oG();
                    this.fUt.a(this.aEo);
                }
                this.fTI.setPullRefresh(this.fUt);
                bjQ();
                if (this.fUt != null) {
                    this.fUt.dW(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.xH().xE() == 0 && z) {
                this.fTI.setPullRefresh(null);
            } else {
                if (this.fUt == null) {
                    this.fUt = new com.baidu.tieba.pb.view.d(this.fMF.getPageContext());
                    this.fUt.oG();
                    this.fUt.a(this.aEo);
                }
                this.fTI.setPullRefresh(this.fUt);
                bjQ();
                if (this.fUt != null) {
                    this.fUt.dW(TbadkCoreApplication.getInst().getSkinType());
                }
                akk();
            }
            bjT();
            this.fUp.km(this.fMW);
            this.fUp.kn(false);
            this.fUp.ky(i == 5);
            this.fUp.kz(i == 6);
            this.fUp.kA(z2 && this.fWd);
            this.fUp.a(dVar, false);
            this.fUp.notifyDataSetChanged();
            if (this.fMF.bfQ()) {
                this.fVG = 0;
                PostData b = b(dVar, z);
                if (b != null && b.yv() != null) {
                    this.fVG = b.yv().getLevel_id();
                }
                if (this.fVG > 0) {
                    this.fTS.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.fTS, BitmapHelper.getGradeResourceIdInEnterForum(this.fVG));
                } else {
                    this.fTS.setVisibility(8);
                }
            } else {
                this.fTS.setVisibility(8);
            }
            if (dVar.beV() != null) {
                if (dVar.beV().yi() != null) {
                    if (dVar.beV().yi().getNum() < 1) {
                        str = this.fMF.getResources().getString(e.j.zan);
                    } else {
                        str = dVar.beV().yi().getNum() + "";
                    }
                    if (this.fTx != -1) {
                        dVar.beV().yi().setIsLike(this.fTx);
                    }
                    U(str, dVar.beV().yi().getIsLike() == 1);
                }
                if (dVar.beV().arg != null && dVar.beV().arg.isDeleted) {
                    this.fTE.lq(true);
                } else {
                    this.fTE.lq(false);
                }
            }
            if (this.fMF.isLogin()) {
                this.fTI.setNextPage(this.dFQ);
                this.fTD = 2;
                akk();
            } else {
                this.fUZ = true;
                if (dVar.xH().xD() == 1) {
                    if (this.fUu == null) {
                        this.fUu = new com.baidu.tieba.pb.view.a(this.fMF.getPageContext());
                    }
                    this.fTI.setNextPage(this.fUu);
                } else {
                    this.fTI.setNextPage(this.dFQ);
                }
                this.fTD = 3;
            }
            ArrayList<PostData> beX = dVar.beX();
            if (dVar.xH().xD() == 0 || beX == null || beX.size() < dVar.xH().xC()) {
                if (com.baidu.tbadk.core.util.v.I(beX) == 0 || (com.baidu.tbadk.core.util.v.I(beX) == 1 && beX.get(0) != null && beX.get(0).bCb() == 1)) {
                    this.dFQ.setText(this.fMF.getResources().getString(e.j.list_no_more_new));
                    if (this.fMF.bgq() != null && !this.fMF.bgq().bkL()) {
                        this.fMF.bgq().showFloatingView();
                    }
                } else if (dVar.xH().xD() == 0) {
                    this.dFQ.setText(this.fMF.getResources().getString(e.j.list_has_no_more));
                } else {
                    this.dFQ.setText(this.fMF.getResources().getString(e.j.load_more));
                }
                if (this.fMF.bgQ() && this.fTI != null && this.fTI.getData() != null && this.fTI.getData().size() == 1 && (this.fTI.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dFQ.setText("");
                }
                bka();
            } else if (z2) {
                if (this.fWd) {
                    DP();
                    if (dVar.xH().xD() != 0) {
                        this.dFQ.setText(this.fMF.getResources().getString(e.j.pb_load_more));
                    }
                } else {
                    this.dFQ.DK();
                    this.dFQ.showLoading();
                }
            } else {
                this.dFQ.DK();
                this.dFQ.showLoading();
            }
            switch (i) {
                case 2:
                    this.fTI.setSelection(i2 > 1 ? (((this.fTI.getData() == null && dVar.beX() == null) ? 0 : (this.fTI.getData().size() - dVar.beX().size()) + this.fTI.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (biY2 = aj.biX().biY()) != null) {
                        this.fTI.onRestoreInstanceState(biY2);
                        if (com.baidu.tbadk.core.util.v.I(beX) > 1 && dVar.xH().xD() > 0) {
                            this.dFQ.DP();
                            this.dFQ.setText(this.fMF.getString(e.j.pb_load_more_without_point));
                            this.dFQ.DL();
                            break;
                        }
                    } else {
                        this.fTI.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fWd = false;
                    break;
                case 5:
                    this.fTI.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (biY = aj.biX().biY()) != null) {
                        this.fTI.onRestoreInstanceState(biY);
                        break;
                    } else {
                        this.fTI.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.fTy != null && this.fTy.bmf() != null) {
                            if (this.fMF.isUseStyleImmersiveSticky()) {
                                this.fTI.setSelectionFromTop((this.fUp.bhu() + this.fTI.getHeaderViewsCount()) - 1, this.fTy.bmf().getHeight() - com.baidu.adp.lib.util.l.r(this.fMF.getPageContext().getPageActivity()));
                            } else {
                                this.fTI.setSelectionFromTop((this.fUp.bhu() + this.fTI.getHeaderViewsCount()) - 1, this.fTy.bmf().getHeight());
                            }
                        } else {
                            this.fTI.setSelection(this.fUp.bhu() + this.fTI.getHeaderViewsCount());
                        }
                    } else {
                        this.fTI.setSelection(i2 > 0 ? ((this.fTI.getData() == null && dVar.beX() == null) ? 0 : (this.fTI.getData().size() - dVar.beX().size()) + this.fTI.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dFQ.DP();
                    this.dFQ.setText(this.fMF.getString(e.j.pb_load_more_without_point));
                    this.dFQ.DL();
                    break;
            }
            if (this.fVp == fVq && isHost()) {
                bki();
            }
            if (this.fVA) {
                bjh();
                this.fVA = false;
                if (i3 == 0) {
                    kS(true);
                }
            }
            if (this.fTA != null) {
                this.fTA.ar(dVar.beV());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fIe == 1 || dVar.fIf == 1) {
                if (this.fVH == null) {
                    this.fVH = new PbTopTipView(this.fMF);
                }
                if (dVar.fIf == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fMF.getStType())) {
                    this.fVH.setText(this.fMF.getString(e.j.pb_read_strategy_add_experience));
                    this.fVH.show(this.dgE, this.mSkinType);
                } else if (dVar.fIe == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fMF.getStType())) {
                    this.fVH.setText(this.fMF.getString(e.j.pb_read_news_add_experience));
                    this.fVH.show(this.dgE, this.mSkinType);
                }
            }
        }
    }

    private void bjQ() {
        if (this.fTy != null && this.fTy.bmf() != null) {
            this.fTI.removeHeaderView(this.aQj);
            if (this.mType != 1) {
                this.fTI.removeHeaderView(this.fTy.bmi());
                this.fTI.addHeaderView(this.fTy.bmi(), 0);
                return;
            }
            return;
        }
        if (this.fTy != null) {
            this.fTI.removeHeaderView(this.fTy.bmi());
        }
        this.fTI.removeHeaderView(this.aQj);
        this.fTI.addHeaderView(this.aQj, 0);
    }

    public void la(boolean z) {
        this.fUK = z;
    }

    public void DP() {
        if (this.dFQ != null) {
            this.dFQ.DL();
            this.dFQ.DP();
        }
        akk();
    }

    public void amh() {
        this.fTI.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fUY != null && this.fUY.yv() != null && this.fTE != null) {
            this.fVD = !this.fVC;
            this.fTE.lp(this.fVD);
            if (this.fMF.bgq() != null) {
                this.fMF.bgq().lo(this.fVD);
            }
            bjR();
            if (this.fVD) {
                this.fTE.fYJ.setVisibility(0);
                if (this.fUL) {
                    this.fTE.fYK.setVisibility(8);
                    this.fUa.setVisibility(8);
                    this.fUd.setVisibility(0);
                    this.fUd.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.J(dVar.bfs())));
                } else if (!PbNormalLikeButtonSwitchStatic.Op() || (this.fUY.yv().hadConcerned() && this.fUY.yv().getGodUserData() != null && this.fUY.yv().getGodUserData().getIsFromNetWork())) {
                    this.fTE.fYK.setVisibility(8);
                }
                if (this.fVi != null) {
                    this.fVi.setVisibility(8);
                }
                this.fTE.a(this.fUY.yv(), this.fWe);
                if (this.fVP == null) {
                    this.fVP = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fVF) {
                                ar.this.bkh();
                            }
                            ar.this.bjK();
                        }
                    };
                }
                this.fTI.setListViewDragListener(this.fVP);
                return;
            }
            if (this.fTE.fYJ != null) {
                this.fTE.fYJ.setVisibility(8);
            }
            if (this.fVi != null) {
                this.fVi.setVisibility(0);
            }
            if (this.fUL) {
                this.fUa.setVisibility(8);
                this.fUd.setVisibility(0);
                this.fUd.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.J(dVar.bfs())));
            } else if (!PbNormalLikeButtonSwitchStatic.Op() || (this.fUY.yv().hadConcerned() && this.fUY.yv().getGodUserData() != null && this.fUY.yv().getGodUserData().getIsFromNetWork())) {
                this.fUa.setVisibility(8);
                this.fUd.setVisibility(8);
            } else {
                this.fUd.setVisibility(8);
            }
            this.fVP = null;
            this.fTI.setListViewDragListener(null);
        }
    }

    private void bjR() {
        String threadId = this.fQf != null ? this.fQf.getThreadId() : "";
        int bjS = bjS();
        if (this.fVD) {
            if (this.fUc == null) {
                this.fUc = new ap(this.fMF.getPageContext(), this.fTE.fYK, 3);
                this.fUc.h(this.fMF.getUniqueId());
            }
            if (this.fUY != null && this.fUY.yv() != null) {
                this.fUY.yv().setIsLike(this.fUY.yv().hadConcerned());
                this.fUc.a(this.fUY.yv());
            }
            this.fUc.setTid(threadId);
            this.fUc.rK(bjS);
            this.fUc.fTt = this.fVC;
        }
        if (this.fUb == null) {
            this.fUb = new ap(this.fMF.getPageContext(), this.fUa, 1);
            this.fUb.h(this.fMF.getUniqueId());
            this.fUb.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bt(boolean z) {
                    if (ar.this.fMF != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fMF, e.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fMF.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fUY != null && this.fUY.yv() != null) {
            this.fUY.yv().setIsLike(this.fUY.yv().hadConcerned());
            this.fUb.a(this.fUY.yv());
            this.fUb.setTid(threadId);
        }
        this.fUb.fTt = this.fVC;
        this.fUb.rK(bjS);
    }

    public int bjS() {
        if (this.fQf == null || this.fQf.beV() == null) {
            return 0;
        }
        if (this.fQf.beV().zG()) {
            return (com.baidu.tbadk.core.util.v.J(this.fQf.bfr()) && (this.fQf.beU() == null || StringUtils.isNull(this.fQf.beU().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bjT() {
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
        if ((this.fUn == null || this.fUn.getVisibility() == 8) && z && this.fMW) {
            this.fUm.setVisibility(0);
        } else {
            this.fUm.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.beV() == null) {
            return false;
        }
        if (dVar.beV().ys() == 1 || dVar.beV().getThreadType() == 33) {
            return true;
        }
        return !(dVar.beV().yu() == null || dVar.beV().yu().Ai() == 0) || dVar.beV().yq() == 1 || dVar.beV().yr() == 1 || dVar.beV().za() || dVar.beV().zn() || dVar.beV().zi() || dVar.beV().yI() != null || !com.baidu.tbadk.core.util.ao.isEmpty(dVar.beV().getCategory()) || dVar.beV().yy() || dVar.beV().yx();
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fMF.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fTK != null) {
                if (dVar.beV() != null && dVar.beV().yL() == 0 && !dVar.beV().zj() && !this.fVT) {
                    this.fTK.setVisibility(0);
                    if (dVar.beV() != null) {
                        bb beV = dVar.beV();
                        beV.g(true, q(dVar));
                        beV.setResource(3);
                        beV.dT("2");
                    }
                    SpannableStringBuilder yV = dVar.beV().yV();
                    this.fTL.setOnTouchListener(new com.baidu.tieba.view.k(yV));
                    this.fTL.setText(yV);
                    this.fTL.setVisibility(0);
                } else if (dVar.beV().yL() == 1) {
                    if (dVar.beV() != null) {
                        this.fTK.setVisibility(8);
                        this.fTI.removeHeaderView(this.fTK);
                        if (dVar.beV() != null && !dVar.beV().zj()) {
                            this.fTO.setPadding(this.fTO.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.tbds36), this.fTO.getPaddingRight(), this.fTO.getPaddingBottom());
                        }
                    }
                } else {
                    this.fTK.setVisibility(8);
                    this.fTI.removeHeaderView(this.fTK);
                    if (dVar.beV() != null && dVar.beV().zj()) {
                        this.fTO.setPadding(this.fTO.getPaddingLeft(), 0, this.fTO.getPaddingRight(), this.fTO.getPaddingBottom());
                    } else {
                        this.fTO.setPadding(this.fTO.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds48), this.fTO.getPaddingRight(), this.fTO.getPaddingBottom());
                    }
                }
            }
            this.fMW = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bjT();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.yv().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bfh()));
                sparseArray.put(e.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.yv() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, b.yv().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, b.yv().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, b.yv().getPortrait());
                    sparseArray.put(e.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bfh()));
                sparseArray.put(e.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.ay> bfr = dVar.bfr();
                if (com.baidu.tbadk.core.util.v.I(bfr) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.ay ayVar : bfr) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aoM) != null && tVar.amM && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(this.fMF.getString(e.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(e.g.tag_del_multi_forum, String.format(this.fMF.getString(e.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.baU;
    }

    public void sx(String str) {
        if (this.dFQ != null) {
            this.dFQ.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fTI;
    }

    public int bjU() {
        return e.g.richText;
    }

    public TextView bgl() {
        return this.fTN.bgl();
    }

    public void e(BdListView.e eVar) {
        this.fTI.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.aEo = bVar;
        if (this.fUt != null) {
            this.fUt.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int xB = alVar.xB();
            int xy = alVar.xy();
            if (this.fUq != null) {
                this.fUq.Au();
            } else {
                this.fUq = new com.baidu.tbadk.core.dialog.a(this.fMF.getPageContext().getPageActivity());
                this.fUr = LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.dialog_direct_pager, (ViewGroup) null);
                this.fUq.G(this.fUr);
                this.fUq.a(e.j.dialog_ok, bVar);
                this.fUq.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bjW();
                        aVar.dismiss();
                    }
                });
                this.fUq.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fVx == null) {
                            ar.this.fVx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fMF.HidenSoftKeyPad((InputMethodManager) ar.this.fMF.getSystemService("input_method"), ar.this.dgE);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jI().postDelayed(ar.this.fVx, 150L);
                    }
                });
                this.fUq.b(this.fMF.getPageContext()).Au();
            }
            this.fUs = (EditText) this.fUr.findViewById(e.g.input_page_number);
            this.fUs.setText("");
            TextView textView = (TextView) this.fUr.findViewById(e.g.current_page_number);
            if (xB <= 0) {
                xB = 1;
            }
            if (xy <= 0) {
                xy = 1;
            }
            textView.setText(MessageFormat.format(this.fMF.getApplicationContext().getResources().getString(e.j.current_page), Integer.valueOf(xB), Integer.valueOf(xy)));
            this.fMF.ShowSoftKeyPadDelay(this.fUs, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fTI.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fMF.showToast(str);
    }

    public boolean lb(boolean z) {
        if (this.SY == null || !this.SY.KK()) {
            return false;
        }
        this.SY.Jg();
        return true;
    }

    public void bjV() {
        if (this.fWg != null) {
            while (this.fWg.size() > 0) {
                TbImageView remove = this.fWg.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bjV();
        this.fUp.rv(1);
        if (this.fTy != null) {
            this.fTy.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.fUp.rv(2);
        if (this.fTy != null) {
            this.fTy.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fVz != null) {
            this.fVz.destroy();
        }
        if (this.fVR != null) {
            this.fVR.onDestory();
        }
        if (this.fVH != null) {
            this.fVH.hide();
        }
        if (this.fTB != null) {
            this.fTB.apZ();
        }
        if (this.fTA != null) {
            this.fTA.onDestroy();
        }
        this.fMF.hideProgressBar();
        if (this.dgC != null && this.dxY != null) {
            this.dgC.b(this.dxY);
        }
        bjW();
        DP();
        if (this.fVx != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fVx);
        }
        if (this.fTO != null && this.fTZ != null) {
            this.fTO.removeView(this.fTU);
            this.fTZ = null;
        }
        if (this.fVd != null) {
            this.fVd.clearStatus();
        }
        this.fVZ = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fUp.rv(3);
        if (this.dCt != null) {
            this.dCt.setBackgroundDrawable(null);
        }
        if (this.fTy != null) {
            this.fTy.destroy();
        }
        if (this.fUp != null) {
            this.fUp.onDestroy();
        }
        this.fTI.setOnLayoutListener(null);
        if (this.fVN != null) {
            this.fVN.aBW();
        }
        if (this.fVo != null) {
            this.fVo.onDestroy();
        }
        bks();
    }

    public boolean rN(int i) {
        if (this.fTy != null) {
            return this.fTy.lM(i);
        }
        return false;
    }

    public void bjW() {
        this.fTE.vO();
        if (this.fTB != null) {
            this.fTB.apZ();
        }
        com.baidu.adp.lib.util.l.a(this.fMF.getPageContext().getPageActivity(), this.fUs);
        bjj();
        if (this.fUI != null) {
            this.fUI.dismiss();
        }
        bjY();
        if (this.fTA != null) {
            this.fTA.blY();
        }
        if (this.fUq != null) {
            this.fUq.dismiss();
        }
        if (this.dCd != null) {
            this.dCd.dismiss();
        }
    }

    public void bjX() {
        this.fTE.vO();
        if (this.fTB != null) {
            this.fTB.apZ();
        }
        if (this.fUI != null) {
            this.fUI.dismiss();
        }
        bjY();
        if (this.fTA != null) {
            this.fTA.blY();
        }
        if (this.fUq != null) {
            this.fUq.dismiss();
        }
        if (this.dCd != null) {
            this.dCd.dismiss();
        }
    }

    public void dl(List<String> list) {
        this.fVM = list;
        if (this.fVN != null) {
            this.fVN.setData(list);
        }
    }

    public void kl(boolean z) {
        this.fUp.kl(z);
    }

    public void lc(boolean z) {
        this.fUN = z;
    }

    public void bjY() {
        if (this.fUz != null) {
            this.fUz.dismiss();
        }
        if (this.fUA != null) {
            com.baidu.adp.lib.g.g.b(this.fUA, this.fMF.getPageContext());
        }
        if (this.fUB != null) {
            com.baidu.adp.lib.g.g.b(this.fUB, this.fMF.getPageContext());
        }
        if (this.fUx != null) {
            com.baidu.adp.lib.g.g.b(this.fUx, this.fMF.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fQf, this.fMW);
            d(this.fQf, this.fMW, this.mType);
            this.fMF.getLayoutMode().setNightMode(i == 1);
            this.fMF.getLayoutMode().onModeChanged(this.dgE);
            this.fMF.getLayoutMode().onModeChanged(this.fTJ);
            if (this.fTA != null) {
                this.fTA.onChangeSkinType(i);
            }
            if (this.fTL != null) {
                com.baidu.tbadk.core.util.al.h(this.fTL, e.d.cp_cont_b);
                this.fTL.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            }
            if (this.dFQ != null) {
                this.dFQ.dW(i);
                if (this.baU != null) {
                    this.fMF.getLayoutMode().onModeChanged(this.baU);
                    com.baidu.tbadk.core.util.al.i(this.baU, e.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fUq != null) {
                this.fUq.c(this.fMF.getPageContext());
            }
            la(this.fUK);
            this.fUp.notifyDataSetChanged();
            if (this.fUt != null) {
                this.fUt.dW(i);
            }
            if (this.SY != null) {
                this.SY.onChangeSkinType(i);
            }
            if (this.fTY != null) {
                this.fTY.ea(i);
            }
            if (this.fUu != null) {
                this.fUu.dW(i);
            }
            if (!com.baidu.tbadk.core.util.v.J(this.cPt)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cPt) {
                    customBlueCheckRadioButton.Dx();
                }
            }
            kW(i == 1);
            bjy();
            UtilHelper.setStatusBarBackground(this.dCt, i);
            UtilHelper.setStatusBarBackground(this.fVi, i);
            if (this.fUa != null) {
                this.fUa.onChangeSkinType(i);
            }
            if (this.fUf != null) {
                com.baidu.tbadk.core.util.al.h(this.fUf, e.d.cp_cont_d);
            }
            if (this.fUe != null) {
                com.baidu.tbadk.core.util.al.h(this.fUe, e.d.cp_cont_d);
            }
            if (this.fUg != null) {
                com.baidu.tbadk.core.util.al.i(this.fUg, e.d.cp_cont_e);
            }
            if (this.aFR != null) {
                com.baidu.tbadk.core.util.al.h(this.aFR, e.d.cp_cont_d);
            }
            if (this.fUh != null) {
                com.baidu.tbadk.core.util.al.i(this.fUh, e.d.cp_cont_e);
            }
            if (this.fTR != null) {
                com.baidu.tbadk.core.util.al.h(this.fTR, e.d.cp_link_tip_a);
            }
            if (this.fUd != null) {
                com.baidu.tbadk.core.util.al.h(this.fUd, e.d.cp_cont_d);
            }
            if (this.fUi != null) {
                com.baidu.tbadk.o.a.a(this.fMF.getPageContext(), this.fUi);
            }
            if (this.fUG != null) {
                com.baidu.tbadk.o.a.a(this.fMF.getPageContext(), this.fUG);
            }
            if (this.fVy != null) {
                this.fVy.onChangeSkinType(i);
            }
            if (this.fTE != null) {
                if (this.fTy != null) {
                    this.fTy.rS(i);
                } else {
                    this.fTE.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fUQ != null) {
                com.baidu.tbadk.core.util.al.h(this.fUQ, e.d.cp_cont_e);
            }
            if (this.fTS != null) {
                com.baidu.tbadk.core.util.al.c(this.fTS, BitmapHelper.getGradeResourceIdInEnterForum(this.fVG));
            }
            if (this.fVO != null) {
                this.fVO.onChangeSkinType(i);
            }
            if (this.fVo != null) {
                this.fVo.onChangeSkinType();
            }
            if (this.fVK != null) {
                com.baidu.tbadk.core.util.al.h(this.fVK, e.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bnD = hVar;
        this.fUp.setOnImageClickListener(this.bnD);
        this.fVO.setOnImageClickListener(this.bnD);
    }

    public void h(NoNetworkView.a aVar) {
        this.dxY = aVar;
        if (this.dgC != null) {
            this.dgC.a(this.dxY);
        }
    }

    public void ld(boolean z) {
        this.fUp.setIsFromCDN(z);
    }

    public Button bjZ() {
        return this.fUO;
    }

    public void bka() {
        if (this.fTD != 2) {
            this.fTI.setNextPage(this.dFQ);
            this.fTD = 2;
        }
    }

    public void bkb() {
        if (com.baidu.tbadk.l.m.NX().NY()) {
            int lastVisiblePosition = this.fTI.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fTI.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(e.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.fG(1001);
                                perfLog.bbz = true;
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
                        perfLog2.fG(1001);
                        perfLog2.bbz = true;
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

    public boolean bkc() {
        return this.SY != null && this.SY.getVisibility() == 0;
    }

    public boolean bkd() {
        return this.SY != null && this.SY.KK();
    }

    public void bke() {
        if (this.SY != null) {
            this.SY.Jg();
        }
    }

    public void le(boolean z) {
        if (this.fUP != null) {
            lc(this.fMF.bgm().Ln());
            if (this.fUN) {
                kT(z);
            } else {
                kU(z);
            }
        }
    }

    public void bkf() {
        if (this.fUP != null) {
            this.fUP.setVisibility(8);
            this.fUU = false;
            if (this.fVo != null) {
                this.fVo.setVisibility(8);
                kY(false);
            }
            bks();
        }
    }

    public void showLoadingDialog() {
        if (this.cWM == null) {
            this.cWM = new com.baidu.tbadk.core.view.d(this.fMF.getPageContext());
        }
        this.cWM.bj(true);
    }

    public void akk() {
        if (this.cWM != null) {
            this.cWM.bj(false);
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
            this.fWh = getScrollY();
            this.fVn.fWw = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVn));
            a(this.fVn.fWw, true);
        }
    }

    public void lf(boolean z) {
        this.fTy.lf(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fTy != null) {
            this.fTy.b(absListView, i);
        }
        int headerViewsCount = (i - this.fTI.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (headerViewsCount <= i2 && this.fUp.ru(headerViewsCount) != com.baidu.tieba.pb.data.i.fIw) {
            headerViewsCount++;
        }
        boolean z = i < this.fTI.getHeaderViewsCount();
        if (this.fTM != null && this.fTE != null) {
            this.fTE.g(this.fTM.getBottom(), this.fTM.getMeasuredHeight(), z);
        }
        this.fVn.fDe = i;
        this.fVn.headerCount = this.fTI.getHeaderViewsCount();
        this.fVn.fWw = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVn));
        a(this.fVn.fWw, false);
    }

    public void bkg() {
        if (this.fMF.isLogin() && this.fQf != null && this.fVD && !this.fVC && !this.fUL && this.fUY != null && this.fUY.yv() != null && !this.fUY.yv().getIsLike() && !this.fUY.yv().hadConcerned()) {
            if (this.fVz == null) {
                this.fVz = new an(this.fMF);
            }
            this.fVz.a(this.fTE.fYJ, this.fQf.bfv(), this.fUY.yv().getUserId(), this.fQf.getThreadId());
        }
    }

    public void bkh() {
        if (this.fVD && !this.fVC && this.fUY != null && this.fUY.yv() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").x("obj_locate", this.fMF.bfQ() ? 2 : 1).x("obj_type", this.fVC ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fMF.getPageContext().getPageActivity(), this.fUY.yv().getUserId(), this.fUY.yv().getUserName(), this.fMF.bga().bfR(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fVC && this.fVh != null && this.fTE.bkQ() != null) {
            int bhv = this.fUp.bhv();
            if (bhv > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bhv > this.fTI.getFirstVisiblePosition() - this.fTI.getHeaderViewsCount()) {
                    this.fVh.setVisibility(8);
                    return;
                }
                this.fVh.setVisibility(0);
                bkr();
                this.fTE.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fSX == null) {
                if (this.fTI.getFirstVisiblePosition() == 0) {
                    this.fVh.setVisibility(8);
                    this.fTE.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fVm) {
                        this.fVl = top;
                        this.fVm = false;
                    }
                    this.fVl = top < this.fVl ? top : this.fVl;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fUo.getY() < 0.0f) {
                        measuredHeight = fVk - alVar.fSX.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fTE.bkQ().getMeasuredHeight() - alVar.fSX.getMeasuredHeight();
                        this.fTE.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fVl) {
                        this.fVh.setVisibility(0);
                        bkr();
                    } else if (top < measuredHeight) {
                        this.fVh.setVisibility(0);
                        bkr();
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

    public void bki() {
        if (!this.fWi) {
            TiebaStatic.log("c10490");
            this.fWi = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMF.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fVr, Integer.valueOf(fVt));
            aVar.cy(e.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.function_description_view)).setText(e.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(e.g.title_view)).setText(e.j.grade_thread_tips);
            aVar.G(inflate);
            aVar.H(sparseArray);
            aVar.a(e.j.grade_button_tips, this.fMF);
            aVar.b(e.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fMF.getPageContext()).Au();
        }
    }

    public void sy(String str) {
        if (str.contains(BaseRequestAction.SPLITE)) {
            str = str.replace(BaseRequestAction.SPLITE, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMF.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(e.g.function_description_view)).setVisibility(8);
        aVar.G(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fVr, Integer.valueOf(fVu));
        aVar.H(sparseArray);
        aVar.a(e.j.view, this.fMF);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fMF.getPageContext()).Au();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.yv() != null) {
            MetaData yv = b.yv();
            yv.setGiftNum(yv.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bkj() {
        return this.fVd;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.beV() != null && dVar.beV().zn() && this.fVd == null) {
            this.fVd = (PbInterviewStatusView) this.fVc.inflate();
            this.fVd.setOnClickListener(this.dCe);
            this.fVd.setCallback(this.fMF.bgY());
            this.fVd.setData(this.fMF, dVar);
        }
    }

    public LinearLayout bkk() {
        return this.fUo;
    }

    public View bkl() {
        return this.dCt;
    }

    public boolean bkm() {
        return this.fVT;
    }

    public void kq(boolean z) {
        this.fTN.kq(z);
    }

    public void sz(String str) {
        if (this.fTF != null) {
            this.fTF.setTitle(str);
        }
    }

    private int lg(boolean z) {
        if (this.fVd == null || this.fVd.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds72);
    }

    private void bkn() {
        if (this.fVd != null && this.fVd.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fVd.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fVd.setLayoutParams(layoutParams);
        }
    }

    public boolean bgs() {
        return false;
    }

    public void sA(String str) {
        this.fUQ.performClick();
        if (!StringUtils.isNull(str) && this.fMF.bgm() != null && this.fMF.bgm().Lg() != null && this.fMF.bgm().Lg().getInputView() != null) {
            EditText inputView = this.fMF.bgm().Lg().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bjW();
            if (configuration.orientation == 2) {
                bkf();
                bjj();
            } else {
                bjm();
            }
            if (this.fVy != null) {
                this.fVy.bhC();
            }
            this.fMF.azR();
            this.fUo.setVisibility(8);
            this.fTE.ls(false);
            this.fMF.kw(false);
            if (this.fTy != null) {
                if (configuration.orientation == 1) {
                    bkk().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fTI.setIsLandscape(true);
                    this.fTI.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fTI.setIsLandscape(false);
                    if (this.fWh > 0) {
                        this.fTI.smoothScrollBy(this.fWh, 0);
                    }
                }
                this.fTy.onConfigurationChanged(configuration);
                this.fVg.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void lh(boolean z) {
        this.fTC = z;
    }

    public boolean bko() {
        return this.fTy != null && this.fTy.bko();
    }

    public void bkp() {
        if (this.fTy != null) {
            this.fTy.onPause();
        }
    }

    public void n(long j, int i) {
        if (this.fTA != null) {
            this.fTA.n(j, i);
        }
        if (this.fTy != null) {
            this.fTy.n(j, i);
        }
    }

    public void kB(boolean z) {
        this.fUp.kB(z);
    }

    public void bkq() {
        if (this.fVe == null) {
            LayoutInflater.from(this.fMF.getActivity()).inflate(e.h.add_experienced_text, (ViewGroup) this.dgE, true);
            this.fVe = (ViewGroup) this.dgE.findViewById(e.g.add_experienced_layout);
            this.fVf = (TextView) this.dgE.findViewById(e.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.fVf, e.d.cp_cont_i);
            String string = this.fMF.getResources().getString(e.j.experienced_add_success);
            String string2 = this.fMF.getResources().getString(e.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_h)));
            this.fVf.setText(spannableString);
        }
        this.fVe.setVisibility(0);
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

    public void bB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fUP.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fMF);
            frameLayout.setBackgroundResource(e.f.pic_sign_tip);
            this.fVK = new TextView(this.fMF);
            this.fVK.setText(e.j.connection_tips);
            this.fVK.setGravity(17);
            this.fVK.setPadding(com.baidu.adp.lib.util.l.h(this.fMF, e.C0175e.ds24), 0, com.baidu.adp.lib.util.l.h(this.fMF, e.C0175e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fMF, e.C0175e.ds60);
            if (this.fVK.getParent() == null) {
                frameLayout.addView(this.fVK, layoutParams);
            }
            this.fVJ = new PopupWindow(this.fMF);
            this.fVJ.setContentView(frameLayout);
            this.fVJ.setHeight(-2);
            this.fVJ.setWidth(-2);
            this.fVJ.setFocusable(true);
            this.fVJ.setOutsideTouchable(false);
            this.fVJ.setBackgroundDrawable(new ColorDrawable(this.fMF.getResources().getColor(e.d.transparent)));
            this.fTI.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.30
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

    public void bkr() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.fVL == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.fVL = new com.baidu.tbadk.core.dialog.a(this.fMF);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.fMF);
            this.fVL.cB(1);
            this.fVL.G(pbLongPressTipView);
            this.fVL.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.31
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fVL.aP(false);
            this.fVL.b(this.fMF.getPageContext()).Au();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.32
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fVL != null && ar.this.fVL.isShowing()) {
                        ar.this.fVL.dismiss();
                    }
                }
            }, 5000L);
            if (this.fTy != null) {
                this.fTy.bmh();
            }
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bkH() != null && !StringUtils.isNull(aVar.bkH().pkg_id) && !StringUtils.isNull(aVar.bkH().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fUR != null && this.fUR.getVisibility() == 0) {
            if (this.fVI == null) {
                View inflate = LayoutInflater.from(this.fMF.getPageContext().getPageActivity()).inflate(e.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(e.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(e.g.single_bar_tips);
                textView.setText(e.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dCe);
                this.fVI = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fUR.getLocationInWindow(iArr);
            this.fVI.showAtLocation(this.fUR, 0, iArr[0] - com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds54), (iArr[1] - this.fUR.getHeight()) - com.baidu.adp.lib.util.l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bks() {
        com.baidu.adp.lib.g.g.a(this.fVI);
    }

    public void li(boolean z) {
        this.fVQ = z;
    }

    public boolean bkt() {
        return this.fVQ;
    }

    public void bC(View view) {
        this.fUG = view;
    }
}
