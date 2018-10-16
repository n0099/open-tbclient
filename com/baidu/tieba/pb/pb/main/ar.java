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
    private NavigationBarCoverTip dWt;
    private com.baidu.tieba.NEGFeedBack.e dZp;
    private NoNetworkView dgC;
    private RelativeLayout dgE;
    PbActivity.d fLK;
    private PbActivity fME;
    private UserIconBox fNO;
    private UserIconBox fNP;
    private View.OnClickListener fNc;
    private PbFakeFloorModel fOX;
    private com.baidu.tieba.pb.data.d fQe;
    private com.baidu.tieba.c.d fTA;
    public final com.baidu.tieba.pb.pb.main.view.b fTD;
    public com.baidu.tieba.pb.pb.main.view.a fTE;
    private ViewStub fTF;
    private ViewStub fTG;
    private PbLandscapeListView fTH;
    private View fTI;
    private LinearLayout fTL;
    private e fTM;
    private ColumnLayout fTN;
    private ThreadSkinView fTO;
    private TextView fTP;
    private TextView fTQ;
    private ImageView fTR;
    private HeadPendantView fTS;
    private FrameLayout fTT;
    private HeadImageView fTU;
    private View fTV;
    private FloatingLayout fTW;
    private PbFirstFloorUserLikeButton fTZ;
    public int fTw;
    private com.baidu.tieba.pb.video.i fTx;
    private long fTy;
    private com.baidu.tieba.pb.video.h fTz;
    private View fUO;
    private TextView fUP;
    private ImageView fUQ;
    private ImageView fUR;
    private TextView fUS;
    private boolean fUU;
    private int fUV;
    private int fUW;
    private PostData fUX;
    private View fUZ;
    private ap fUa;
    private ap fUb;
    private TextView fUc;
    private TextView fUd;
    private TextView fUe;
    private View fUf;
    private View fUg;
    private LinearLayout fUh;
    private TextView fUi;
    private TextView fUj;
    private View fUk;
    private View fUl;
    private ObservedChangeLinearLayout fUn;
    private f fUo;
    private View fUu;
    private int fVE;
    private PbTopTipView fVG;
    private PopupWindow fVH;
    private PopupWindow fVI;
    private TextView fVJ;
    private com.baidu.tbadk.core.dialog.a fVK;
    private List<String> fVL;
    private com.baidu.tieba.pb.pb.main.emotion.c fVM;
    private com.baidu.tieba.pb.pb.godreply.a fVN;
    private PbLandscapeListView.b fVO;
    private ac fVQ;
    private boolean fVS;
    private com.baidu.tbadk.core.view.userLike.c fVT;
    private com.baidu.tbadk.core.view.userLike.c fVU;
    private Runnable fVZ;
    private TextView fVa;
    private ViewStub fVb;
    private PbInterviewStatusView fVc;
    private ViewGroup fVd;
    private TextView fVe;
    private FrameLayout fVf;
    private View fVg;
    private View fVh;
    private al fVi;
    private PbEmotionBar fVn;
    private int fVv;
    private Runnable fVw;
    private s fVx;
    private an fVy;
    private PbActivity.b fWb;
    private int fWg;
    private boolean isLandscape;
    private int mType;
    private static final int fVj = UtilHelper.getLightStatusBarHeight();
    public static int fVp = 3;
    public static int fVq = 0;
    public static int fVr = 3;
    public static int fVs = 4;
    public static int fVt = 5;
    public static int fVu = 6;
    private static a.InterfaceC0275a fVR = new a.InterfaceC0275a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0275a
        public void onRefresh() {
        }
    };
    private boolean fTB = false;
    private int fTC = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fTJ = null;
    private TextView fTK = null;
    public FrsPraiseView fTX = null;
    private ClickableHeaderImageView fTY = null;
    private View fUm = null;
    private com.baidu.tbadk.core.dialog.a fUp = null;
    private com.baidu.tbadk.core.dialog.b dCd = null;
    private View fUq = null;
    private EditText fUr = null;
    private com.baidu.tieba.pb.view.d fUs = null;
    private com.baidu.tieba.pb.view.a fUt = null;
    private com.baidu.tbadk.core.dialog.a fUv = null;
    private b.InterfaceC0124b eKM = null;
    private TbRichTextView.h bnD = null;
    private NoNetworkView.a dxY = null;
    private Dialog fUw = null;
    private View fUx = null;
    private com.baidu.tbadk.core.dialog.a fUy = null;
    private Dialog fUz = null;
    private Dialog fUA = null;
    private View fUB = null;
    private LinearLayout fUC = null;
    private CompoundButton.OnCheckedChangeListener cPu = null;
    private TextView fUD = null;
    private TextView fUE = null;
    private View fUF = null;
    private String fUG = null;
    private com.baidu.tbadk.core.dialog.b fUH = null;
    private com.baidu.tbadk.core.dialog.b fUI = null;
    private boolean fUJ = false;
    private boolean fUK = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fUL = null;
    private boolean fUM = false;
    private Button fUN = null;
    private boolean fUT = true;
    private com.baidu.tbadk.core.view.d cWM = null;
    private boolean fMV = false;
    private int mSkinType = 3;
    private boolean fUY = false;
    private int fVk = 0;
    private boolean fVl = true;
    private a fVm = new a();
    private int fVo = 0;
    private boolean fVz = false;
    private int fVA = 0;
    private boolean fVB = false;
    private boolean fVC = false;
    private boolean fVD = false;
    private int fVF = 0;
    private boolean fVP = false;
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
    private CustomMessageListener bLU = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fUo != null) {
                ar.this.fUo.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fVX = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fTK != null) {
                ar.this.fTK.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fVY = new Handler();
    private CustomMessageListener fWa = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fUT = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fWc = true;
    View.OnClickListener fWd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fVB) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (ar.this.fTD != null && ar.this.fTD.fYK != null && view == ar.this.fTD.fYK.getHeadView()) {
                if (ar.this.fTD.fYI == null || ar.this.fTD.fYI.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").x("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!ar.this.fVB && ar.this.fQe != null && ar.this.fQe.beV() != null && ar.this.fQe.beV().yv() != null && ar.this.fQe.beV().yv().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").x("obj_locate", 1));
            }
            ar.this.fME.fKI.eaj.onClick(view);
        }
    };
    private boolean fWe = false;
    String userId = null;
    private final List<TbImageView> fWf = new ArrayList();
    private boolean fWh = false;

    /* loaded from: classes6.dex */
    public static class a {
        public int fDd;
        public al fWv;
        public int headerCount;
    }

    public void kS(boolean z) {
        this.fVz = z;
        if (this.fTH != null) {
            this.fVA = this.fTH.getHeaderViewsCount();
        }
    }

    public void bjh() {
        if (this.fTH != null) {
            int headerViewsCount = this.fTH.getHeaderViewsCount() - this.fVA;
            final int firstVisiblePosition = (this.fTH.getFirstVisiblePosition() == 0 || this.fTH.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fTH.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fTH.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fVm.fWv = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVm));
            final al alVar = this.fVm.fWv;
            final int h = h(alVar);
            final int y = ((int) this.fUn.getY()) + this.fUn.getMeasuredHeight();
            final boolean z = this.fVg.getVisibility() == 0;
            boolean z2 = this.fUn.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fUo.bhv() + this.fTH.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fSW.getMeasuredHeight() : 0;
                if (z2) {
                    this.fTH.setSelectionFromTop(this.fUo.bhv() + this.fTH.getHeaderViewsCount(), fVj - measuredHeight);
                } else {
                    this.fTH.setSelectionFromTop(this.fUo.bhv() + this.fTH.getHeaderViewsCount(), this.fTD.bkQ().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fTH.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fVB) {
                this.fTH.setSelectionFromTop(this.fUo.bhv() + this.fTH.getHeaderViewsCount(), this.fTx.bmf().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fTH.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
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
                                layoutParams.height = ar.this.fVv;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.dgE.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fVv;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fTH.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.cTy.setLayoutParams(layoutParams);
                        }
                        ar.this.fTH.setOnLayoutListener(null);
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
            if (this.fVM != null) {
                this.fVM.Yj();
            }
        }
    }

    public PbFakeFloorModel bjk() {
        return this.fOX;
    }

    public s bjl() {
        return this.fVx;
    }

    public void bjm() {
        reset();
        bjj();
        this.fVx.bhC();
        le(false);
    }

    private void reset() {
        if (this.fME != null && this.fME.bgm() != null && this.SY != null) {
            com.baidu.tbadk.editortools.pb.a.Ld().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bgm = this.fME.bgm();
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
        return this.fUT;
    }

    public void kT(boolean z) {
        if (this.fUO != null && this.fUP != null) {
            this.fUP.setText(e.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fUO.startAnimation(alphaAnimation);
            }
            this.fUO.setVisibility(0);
            this.fUT = true;
            if (this.fVn != null && !this.fVN.isActive()) {
                this.fVn.setVisibility(0);
                kY(true);
            }
        }
    }

    public void kU(boolean z) {
        if (this.fUO != null && this.fUP != null) {
            this.fUP.setText(e.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fUO.startAnimation(alphaAnimation);
            }
            this.fUO.setVisibility(0);
            this.fUT = true;
            if (this.fVn != null && !this.fVN.isActive()) {
                this.fVn.setVisibility(0);
                kY(true);
            }
        }
    }

    public PostData bjo() {
        int i = 0;
        if (this.fTH == null) {
            return null;
        }
        int bjp = bjp() - this.fTH.getHeaderViewsCount();
        if (bjp < 0) {
            bjp = 0;
        }
        if (this.fUo.ru(bjp) != null && this.fUo.ru(bjp) != PostData.hcU) {
            i = bjp + 1;
        }
        return this.fUo.getItem(i) instanceof PostData ? (PostData) this.fUo.getItem(i) : null;
    }

    public int bjp() {
        int i;
        View childAt;
        if (this.fTH == null) {
            return 0;
        }
        int firstVisiblePosition = this.fTH.getFirstVisiblePosition();
        int lastVisiblePosition = this.fTH.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fTH.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fTH.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        return this.fTH.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fQe != null && this.fQe.beX() != null && !this.fQe.beX().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fQe.beX().size() && (postData = this.fQe.beX().get(i)) != null && postData.yv() != null && !StringUtils.isNull(postData.yv().getUserId()); i++) {
                if (this.fQe.beX().get(i).yv().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fVN != null && this.fVN.isActive()) {
                        le(false);
                    }
                    if (this.fVn != null) {
                        this.fVn.lm(true);
                    }
                    this.fVV = postData.yv().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fME = null;
        this.dgE = null;
        this.dCt = null;
        this.fTy = 0L;
        this.fTH = null;
        this.fTI = null;
        this.fTL = null;
        this.fTN = null;
        this.fTP = null;
        this.fTQ = null;
        this.fTT = null;
        this.fTU = null;
        this.fTV = null;
        this.fTZ = null;
        this.fUc = null;
        this.fUd = null;
        this.fUe = null;
        this.fUf = null;
        this.fUk = null;
        this.fUl = null;
        this.fUo = null;
        this.dFQ = null;
        this.baU = null;
        this.dCe = null;
        this.fNc = null;
        this.fUO = null;
        this.fUP = null;
        this.fUQ = null;
        this.fUR = null;
        this.fUS = null;
        this.fUZ = null;
        this.fVa = null;
        this.fVb = null;
        this.fVE = 0;
        this.fTy = System.currentTimeMillis();
        this.fME = pbActivity;
        this.dCe = onClickListener;
        this.bnE = cVar;
        this.fVE = com.baidu.adp.lib.util.l.aO(this.fME) / 2;
        this.dgE = (RelativeLayout) LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.new_pb_activity, (ViewGroup) null);
        this.fME.addContentView(this.dgE, new FrameLayout.LayoutParams(-1, -1));
        this.dWt = (NavigationBarCoverTip) this.fME.findViewById(e.g.pb_multi_forum_del_tip_view);
        this.dCt = this.fME.findViewById(e.g.statebar_view);
        this.fUn = (ObservedChangeLinearLayout) this.fME.findViewById(e.g.title_wrapper);
        this.dgC = (NoNetworkView) this.fME.findViewById(e.g.view_no_network);
        this.fTH = (PbLandscapeListView) this.fME.findViewById(e.g.new_pb_list);
        this.fVf = (FrameLayout) this.fME.findViewById(e.g.root_float_header);
        this.aQj = new TextView(this.fME.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds88));
        this.fTH.addHeaderView(this.aQj, 0);
        this.fVv = this.fME.getResources().getDimensionPixelSize(e.C0175e.tbds134);
        this.cTy = new View(this.fME.getPageContext().getPageActivity());
        this.cTy.setLayoutParams(new AbsListView.LayoutParams(-1, this.fVv));
        this.cTy.setVisibility(4);
        this.fTH.addFooterView(this.cTy);
        this.fTH.setOnTouchListener(this.fME.bez);
        this.fTD = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fME.bgQ()) {
            this.fTF = (ViewStub) this.fME.findViewById(e.g.manga_view_stub);
            this.fTF.setVisibility(0);
            this.fTE = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fTE.show();
            this.fTD.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds120);
        }
        this.aQj.setLayoutParams(layoutParams);
        this.fTD.bkQ().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0241a() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0241a
            public void bfK() {
                if (ar.this.fTH != null) {
                    if (ar.this.fTx != null) {
                        ar.this.fTx.bmg();
                    }
                    ar.this.fTH.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0241a
            public void bfL() {
                ar.this.fME.azQ();
            }
        }));
        this.fUO = this.fME.findViewById(e.g.pb_editor_tool_comment);
        this.fUV = com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds90);
        this.fUW = com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds242);
        this.fUP = (TextView) this.fME.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_reply_text);
        this.fUR = (ImageView) this.fME.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_more_img);
        this.fUQ = (ImageView) this.fME.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_emotion_img);
        this.fUS = (TextView) this.fME.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_praise_icon);
        this.fUS.setVisibility(8);
        this.fUP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bjr();
            }
        });
        this.fUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bks();
                if (ar.this.fME.checkUpIsLogin()) {
                    if (ar.this.SY != null) {
                        ar.this.bjB();
                        ar.this.SY.aa((View) ar.this.SY.ff(5));
                    }
                    if (ar.this.SY != null) {
                        ar.this.fUT = false;
                        if (ar.this.SY.fi(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fME, (View) ar.this.SY.fi(2).aTV, false, ar.fVR);
                        }
                    }
                    ar.this.bkf();
                }
            }
        });
        this.fUR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bks();
                if (ar.this.fME.checkUpIsLogin()) {
                    if (ar.this.SY != null) {
                        ar.this.bjB();
                        ar.this.SY.aa((View) ar.this.SY.ff(2));
                    }
                    if (ar.this.SY != null) {
                        ar.this.fUT = false;
                        if (ar.this.SY.fi(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fME, (View) ar.this.SY.fi(2).aTV, false, ar.fVR);
                        }
                    }
                    ar.this.bkf();
                }
            }
        });
        this.fUS.setOnClickListener(this.dCe);
        this.fUS.setOnTouchListener(this.fME);
        this.fTI = LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_item, (ViewGroup) null);
        this.fTL = (LinearLayout) LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_user_item, (ViewGroup) null);
        this.fTM = new e(this.fME, this.fTL);
        this.fTM.init();
        this.fTM.a(this.fTM.bgl(), this.dCe);
        this.fTN = (ColumnLayout) this.fTL.findViewById(e.g.pb_head_owner_root);
        this.fTO = (ThreadSkinView) this.fTL.findViewById(e.g.pb_thread_skin);
        this.fTN.setOnLongClickListener(this.onLongClickListener);
        this.fTN.setOnTouchListener(this.bnE);
        this.fTN.setVisibility(8);
        this.fTI.setOnTouchListener(this.bnE);
        this.fUZ = this.fTI.findViewById(e.g.pb_head_activity_join_number_container);
        this.fUZ.setVisibility(8);
        this.fVa = (TextView) this.fTI.findViewById(e.g.pb_head_activity_join_number);
        this.fTP = (TextView) this.fTN.findViewById(e.g.pb_head_owner_info_user_name);
        this.fTQ = (TextView) this.fTN.findViewById(e.g.floor_owner);
        this.fTR = (ImageView) this.fTN.findViewById(e.g.icon_forum_level);
        this.fTT = (FrameLayout) this.fTN.findViewById(e.g.pb_head_headImage_container);
        this.fTU = (HeadImageView) this.fTN.findViewById(e.g.pb_head_owner_photo);
        this.fTS = (HeadPendantView) this.fTN.findViewById(e.g.pb_pendant_head_owner_photo);
        this.fTS.setHasPendantStyle();
        if (this.fTS.getHeadView() != null) {
            this.fTS.getHeadView().setIsRound(true);
            this.fTS.getHeadView().setDrawBorder(false);
        }
        this.fNO = (UserIconBox) this.fTN.findViewById(e.g.show_icon_vip);
        this.fNP = (UserIconBox) this.fTN.findViewById(e.g.show_icon_yinji);
        this.fTW = (FloatingLayout) this.fTL.findViewById(e.g.pb_head_owner_info_root);
        this.fTZ = (PbFirstFloorUserLikeButton) this.fTN.findViewById(e.g.pb_like_button);
        this.fUc = (TextView) this.fTN.findViewById(e.g.pb_views);
        this.aFR = (TextView) this.fTN.findViewById(e.g.view_forum_name);
        this.fUg = this.fTN.findViewById(e.g.line_right_forum_name);
        this.fUd = (TextView) this.fTN.findViewById(e.g.pb_item_first_floor_reply_time);
        this.fUe = (TextView) this.fTN.findViewById(e.g.pb_item_first_floor_location_address);
        this.fUf = this.fTN.findViewById(e.g.line_between_time_and_locate);
        this.fVT = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fVU = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fUk = this.fTI.findViewById(e.g.new_pb_header_item_line_above_livepost);
        this.fUl = this.fTI.findViewById(e.g.new_pb_header_item_line_below_livepost);
        this.fTI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.37
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fVb = (ViewStub) this.dgE.findViewById(e.g.interview_status_stub);
        this.fUo = new f(this.fME, this.fTH);
        this.fUo.u(this.dCe);
        this.fUo.setTbGestureDetector(this.bnE);
        this.fUo.setOnImageClickListener(this.bnD);
        this.fNc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.38
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
                            ar.this.fME.b(sparseArray);
                            return;
                        }
                        ar.this.bA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 0);
                        sparseArray.put(e.g.tag_check_mute_from, 1);
                        ar.this.fME.b(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fUo.G(this.fNc);
        bjw();
        this.fTH.addHeaderView(this.fTJ);
        this.fTH.addHeaderView(this.fTL);
        this.fTH.addHeaderView(this.fTI);
        this.dFQ = new PbListView(this.fME.getPageContext().getPageActivity());
        this.baU = this.dFQ.getView().findViewById(e.g.pb_more_view);
        if (this.baU != null) {
            this.baU.setOnClickListener(this.dCe);
            com.baidu.tbadk.core.util.al.i(this.baU, e.f.pb_foot_more_trans_selector);
        }
        this.dFQ.DK();
        this.dFQ.dT(e.f.pb_foot_more_trans_selector);
        this.dFQ.dV(e.f.pb_foot_more_trans_selector);
        this.fUu = this.fME.findViewById(e.g.viewstub_progress);
        this.fME.registerListener(this.fWa);
        this.fTV = com.baidu.tbadk.ala.b.uL().j(this.fME.getActivity(), 2);
        if (this.fTV != null) {
            this.fTV.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fME.getResources().getDimensionPixelSize(e.C0175e.ds10);
            if (this.fTV.getParent() == null) {
                this.fTW.addView(this.fTV, aVar);
            }
        }
        this.fOX = new PbFakeFloorModel(this.fME.getPageContext());
        this.fVx = new s(this.fME.getPageContext(), this.fOX, this.dgE);
        this.fVx.a(this.fME.fLG);
        this.fOX.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.fOX.m(postData);
                ar.this.fUo.notifyDataSetChanged();
                ar.this.fVx.bhC();
                ar.this.SY.Jg();
                ar.this.le(false);
            }
        });
        if (this.fME.bga() != null && !StringUtils.isNull(this.fME.bga().bit())) {
            this.fME.showToast(this.fME.bga().bit());
        }
        this.fVg = this.fME.findViewById(e.g.pb_expand_blank_view);
        this.fVh = this.fME.findViewById(e.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fVh.getLayoutParams();
        if (this.fME.bga() != null && this.fME.bga().bhS()) {
            this.fVg.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fVh.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fVj;
            this.fVh.setLayoutParams(layoutParams2);
        }
        this.fVi = new al(this.fME.getPageContext(), this.fME.findViewById(e.g.pb_reply_expand_view));
        this.fVi.fSW.setVisibility(8);
        this.fVi.J(this.dCe);
        this.fME.registerListener(this.bLU);
        this.fME.registerListener(this.fVW);
        this.fME.registerListener(this.fVX);
        bjs();
        kY(false);
    }

    public void bjr() {
        bks();
        if (!this.fME.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.fME.bgy()) {
            com.baidu.tbadk.editortools.pb.d bgm = this.fME.bgm();
            if (bgm != null && (bgm.Lt() || bgm.Lu())) {
                this.fME.bgm().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.SY != null) {
                bjB();
            }
            if (this.SY != null) {
                this.fUT = false;
                if (this.SY.fi(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.fME, (View) this.SY.fi(2).aTV, false, fVR);
                }
            }
            bkf();
        }
    }

    private void bjs() {
        this.fVN = new com.baidu.tieba.pb.pb.godreply.a(this.fME, this, (ViewStub) this.dgE.findViewById(e.g.more_god_reply_popup));
        this.fVN.q(this.dCe);
        this.fVN.G(this.fNc);
        this.fVN.setOnImageClickListener(this.bnD);
        this.fVN.q(this.dCe);
        this.fVN.setTbGestureDetector(this.bnE);
    }

    public com.baidu.tieba.pb.pb.godreply.a bjt() {
        return this.fVN;
    }

    public View bju() {
        return this.fVg;
    }

    public void bjv() {
        if (this.fTH != null) {
            this.fTH.removeHeaderView(this.fTJ);
            this.fTH.removeHeaderView(this.fTL);
            this.fTH.removeHeaderView(this.fTI);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fVn == null) {
            this.fVn = new PbEmotionBar(this.fME.getPageContext().getPageActivity());
            kY(true);
            this.fVn.a(this.dgE, aVar, this.fUO.getVisibility() == 0);
            this.fVn.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (ar.this.fME.bgy()) {
                        if (!StringUtils.isNull(ar.this.fVV)) {
                            emotionImageData.setAuthorNameShow(ar.this.fVV);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fME.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fME.getPageContext().getPageActivity(), 25016, str, list, ar.this.fVV, list2)));
                }
            });
            this.fVn.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    ar.this.bks();
                    if (ar.this.fUO != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fUO.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fUW - ar.this.fUV) * f) + ar.this.fUV);
                        ar.this.fUP.setAlpha(1.0f - f);
                        ar.this.fUR.setAlpha(1.0f - f);
                        ar.this.fUQ.setAlpha(1.0f - f);
                        ar.this.fUO.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bjw() {
        if (this.fTJ == null) {
            int h = com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.tbds44);
            this.fTJ = new LinearLayout(this.fME.getPageContext().getPageActivity());
            this.fTJ.setOrientation(1);
            this.fTJ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fTJ.setPadding(h, com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.tbds30), h, com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.tbds40));
            this.fTJ.setGravity(17);
            this.fTK = new TextView(this.fME.getPageContext().getPageActivity());
            this.fTK.setGravity(3);
            this.fTK.setMaxLines(2);
            this.fTK.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            this.fTK.setPadding(0, 0, 0, 0);
            this.fTK.setLineSpacing(com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.fTK, e.d.cp_cont_b);
            this.fTK.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fTK.setVisibility(8);
            if (this.fTK.getParent() == null) {
                this.fTJ.addView(this.fTK);
            }
            this.fTJ.setOnTouchListener(this.bnE);
            this.fTJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjx() {
        if (this.fME.bgQ()) {
            this.fTG = (ViewStub) this.fME.findViewById(e.g.manga_mention_controller_view_stub);
            this.fTG.setVisibility(0);
            if (this.fUh == null) {
                this.fUh = (LinearLayout) this.fME.findViewById(e.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fME.getPageContext(), this.fUh);
            }
            if (this.fUi == null) {
                this.fUi = (TextView) this.fUh.findViewById(e.g.manga_prev_btn);
            }
            if (this.fUj == null) {
                this.fUj = (TextView) this.fUh.findViewById(e.g.manga_next_btn);
            }
            this.fUi.setOnClickListener(this.dCe);
            this.fUj.setOnClickListener(this.dCe);
        }
    }

    private void bjy() {
        if (this.fME.bgQ()) {
            if (this.fME.bgT() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fUi, e.d.cp_cont_e, 1);
            }
            if (this.fME.bgU() == -1) {
                com.baidu.tbadk.core.util.al.c(this.fUj, e.d.cp_cont_e, 1);
            }
        }
    }

    public void bjz() {
        if (this.fUh == null) {
            bjx();
        }
        this.fTG.setVisibility(8);
        if (this.fVY != null && this.fVZ != null) {
            this.fVY.removeCallbacks(this.fVZ);
        }
    }

    public void bjA() {
        if (this.fVY != null) {
            if (this.fVZ != null) {
                this.fVY.removeCallbacks(this.fVZ);
            }
            this.fVZ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fUh == null) {
                        ar.this.bjx();
                    }
                    ar.this.fTG.setVisibility(0);
                }
            };
            this.fVY.postDelayed(this.fVZ, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void kV(boolean z) {
        this.fTD.kV(z);
        if (z && this.fUY) {
            this.dFQ.setText(this.fME.getResources().getString(e.j.click_load_more));
            this.fTH.setNextPage(this.dFQ);
            this.fTC = 2;
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
        this.fME.bgm().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.SY != null && ar.this.SY.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fVM == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.SY.getId());
                            ar.this.fVM = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fME.getPageContext(), ar.this.dgE, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.J(ar.this.fVL)) {
                                ar.this.fVM.setData(ar.this.fVL);
                            }
                            ar.this.fVM.b(ar.this.SY);
                        }
                        ar.this.fVM.sE(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fME.fKM != null && ar.this.fME.fKM.bkx() != null) {
                    if (!ar.this.fME.fKM.bkx().bLt()) {
                        ar.this.fME.fKM.lj(false);
                    }
                    ar.this.fME.fKM.bkx().ob(false);
                }
            }
        });
    }

    public void bjB() {
        if (this.fME != null && this.SY != null) {
            this.SY.pQ();
            if (this.fME.bgm() != null) {
                this.fME.bgm().Lk();
            }
            bkf();
        }
    }

    public void U(String str, boolean z) {
        this.fUU = z;
        kW(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kW(boolean z) {
        if (this.fUS != null) {
            if (this.fUU) {
                com.baidu.tbadk.core.util.al.i(this.fUS, e.f.pb_praise_already_click_selector);
                this.fUS.setContentDescription(this.fME.getResources().getString(e.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.fUS, e.f.pb_praise_normal_click_selector);
            this.fUS.setContentDescription(this.fME.getResources().getString(e.j.zan));
        }
    }

    public TextView bjC() {
        return this.fUS;
    }

    public void kX(boolean z) {
        if (this.fTH != null && this.aQj != null && this.dCt != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dCt.setVisibility(0);
                } else {
                    this.dCt.setVisibility(8);
                    this.fTH.removeHeaderView(this.aQj);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aQj.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fVj;
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
        return this.fUo;
    }

    public void a(PbActivity.d dVar) {
        this.fLK = dVar;
    }

    public void bA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fUx == null) {
            this.fUx = LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fME.getLayoutMode().onModeChanged(this.fUx);
        if (this.fUw == null) {
            this.fUw = new Dialog(this.fME.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fUw.setCanceledOnTouchOutside(true);
            this.fUw.setCancelable(true);
            this.fUw.setContentView(this.fUx);
            WindowManager.LayoutParams attributes = this.fUw.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.aO(this.fME.getPageContext().getPageActivity()) * 0.9d);
            this.fUw.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUw.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.fUw.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUw.findViewById(e.g.disable_reply_btn);
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
                    if (ar.this.fUw != null && (ar.this.fUw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUw, ar.this.fME.getPageContext());
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
                    if (ar.this.fUw != null && (ar.this.fUw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUw, ar.this.fME.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fWb != null) {
                        ar.this.fWb.m(new Object[]{sparseArray6.get(e.g.tag_manage_user_identity), sparseArray6.get(e.g.tag_forbid_user_name), sparseArray6.get(e.g.tag_forbid_user_post_id), sparseArray6.get(e.g.tag_forbid_user_name_show), sparseArray6.get(e.g.tag_forbid_user_portrait)});
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
                    if (ar.this.fUw != null && (ar.this.fUw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUw, ar.this.fME.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fME.a(z, (String) sparseArray7.get(e.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fUw, this.fME.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fWb = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fME != null && aVar != null) {
            if (this.dZp == null) {
                this.dZp = new com.baidu.tieba.NEGFeedBack.e(this.fME.getPageContext(), this.fTI);
            }
            AntiData ayP = this.fME.ayP();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ayP != null && ayP.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayP.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.dZp.setDefaultReasonArray(new String[]{this.fME.getString(e.j.delete_thread_reason_1), this.fME.getString(e.j.delete_thread_reason_2), this.fME.getString(e.j.delete_thread_reason_3), this.fME.getString(e.j.delete_thread_reason_4), this.fME.getString(e.j.delete_thread_reason_5)});
            this.dZp.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.dZp.iN(str);
            this.dZp.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void k(JSONArray jSONArray) {
                    ar.this.fME.a(aVar, jSONArray);
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
        sparseArray.put(fVq, Integer.valueOf(fVr));
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
        this.fUy = new com.baidu.tbadk.core.dialog.a(this.fME.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fUy.cz(i3);
        } else {
            this.fUy.aT(false);
            this.fUy.ej(str2);
        }
        this.fUy.H(sparseArray);
        this.fUy.a(e.j.dialog_ok, this.fME);
        this.fUy.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUy.aO(true);
        this.fUy.b(this.fME.getPageContext());
        if (z) {
            this.fUy.Au();
        } else {
            a(this.fUy, i);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fUB == null) {
            this.fUB = LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.commit_good, (ViewGroup) null);
        }
        this.fME.getLayoutMode().onModeChanged(this.fUB);
        if (this.fUA == null) {
            this.fUA = new Dialog(this.fME.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fUA.setCanceledOnTouchOutside(true);
            this.fUA.setCancelable(true);
            this.fUL = (ScrollView) this.fUB.findViewById(e.g.good_scroll);
            this.fUA.setContentView(this.fUB);
            WindowManager.LayoutParams attributes = this.fUA.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds540);
            this.fUA.getWindow().setAttributes(attributes);
            this.cPu = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fUG = (String) compoundButton.getTag();
                        if (ar.this.cPt != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ar.this.cPt) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ar.this.fUG != null && !str.equals(ar.this.fUG)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fUC = (LinearLayout) this.fUB.findViewById(e.g.good_class_group);
            this.fUE = (TextView) this.fUB.findViewById(e.g.dialog_button_cancel);
            this.fUE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fUA instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fUA, ar.this.fME.getPageContext());
                    }
                }
            });
            this.fUD = (TextView) this.fUB.findViewById(e.g.dialog_button_ok);
            this.fUD.setOnClickListener(this.dCe);
        }
        this.fUC.removeAllViews();
        this.cPt = new ArrayList();
        CustomBlueCheckRadioButton ck = ck("0", this.fME.getPageContext().getString(e.j.thread_good_class));
        this.cPt.add(ck);
        ck.setChecked(true);
        this.fUC.addView(ck);
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
                    View view = new View(this.fME.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, e.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fUC.addView(view);
                    this.fUC.addView(ck2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fUL.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fME.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fME.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fME.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fUL.setLayoutParams(layoutParams2);
            this.fUL.removeAllViews();
            if (this.fUC != null && this.fUC.getParent() == null) {
                this.fUL.addView(this.fUC);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fUA, this.fME.getPageContext());
    }

    private CustomBlueCheckRadioButton ck(String str, String str2) {
        Activity pageActivity = this.fME.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, e.C0175e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cPu);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bjE() {
        this.fME.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fME.hideProgressBar();
        if (z && z2) {
            this.fME.showToast(this.fME.getPageContext().getString(e.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.neterror);
            }
            this.fME.showToast(str);
        }
    }

    public void aRh() {
        this.fUu.setVisibility(0);
    }

    public void aRg() {
        this.fUu.setVisibility(8);
    }

    public View bjF() {
        if (this.fUB != null) {
            return this.fUB.findViewById(e.g.dialog_button_ok);
        }
        return null;
    }

    public String bjG() {
        return this.fUG;
    }

    public View getView() {
        return this.dgE;
    }

    public void bjH() {
        com.baidu.adp.lib.util.l.a(this.fME.getPageContext().getPageActivity(), this.fME.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fME.hideProgressBar();
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
        this.fME.hideProgressBar();
        DP();
        this.fTH.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bjT();
    }

    public void bjK() {
        this.fTH.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bjT();
    }

    private void kY(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fUP.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fME.getResources().getDimensionPixelSize(e.C0175e.ds130) : this.fME.getResources().getDimensionPixelSize(e.C0175e.ds34);
        this.fUP.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fUo.setOnLongClickListener(onLongClickListener);
        if (this.fVN != null) {
            this.fVN.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0124b interfaceC0124b, boolean z, boolean z2) {
        if (this.fUH != null) {
            this.fUH.dismiss();
            this.fUH = null;
        }
        this.fUH = new com.baidu.tbadk.core.dialog.b(this.fME.getPageContext().getPageActivity());
        this.fUH.cC(e.j.operation);
        if (z2) {
            this.fUH.a(new String[]{this.fME.getPageContext().getString(e.j.copy), this.fME.getPageContext().getString(e.j.report_text)}, interfaceC0124b);
        } else if (!z) {
            this.fUH.a(new String[]{this.fME.getPageContext().getString(e.j.copy), this.fME.getPageContext().getString(e.j.mark)}, interfaceC0124b);
        } else {
            this.fUH.a(new String[]{this.fME.getPageContext().getString(e.j.copy), this.fME.getPageContext().getString(e.j.remove_mark)}, interfaceC0124b);
        }
        this.fUH.d(this.fME.getPageContext());
        this.fUH.Ax();
    }

    public void a(b.InterfaceC0124b interfaceC0124b, boolean z) {
        if (this.fUI != null) {
            this.fUI.dismiss();
            this.fUI = null;
        }
        this.fUI = new com.baidu.tbadk.core.dialog.b(this.fME.getPageContext().getPageActivity());
        if (z) {
            this.fUI.a(new String[]{this.fME.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0124b);
        } else {
            this.fUI.a(new String[]{this.fME.getPageContext().getString(e.j.save_to_emotion), this.fME.getPageContext().getString(e.j.save_to_local)}, interfaceC0124b);
        }
        this.fUI.d(this.fME.getPageContext());
        this.fUI.Ax();
    }

    public int bjL() {
        return rL(this.fTH.getFirstVisiblePosition());
    }

    private int rL(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fTH.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fTH.getAdapter() == null || !(this.fTH.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fTH.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bjM() {
        int lastVisiblePosition = this.fTH.getLastVisiblePosition();
        if (this.fTx != null) {
            if (lastVisiblePosition == this.fTH.getCount() - 1) {
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
        if (this.fTH != null) {
            if (this.fTD == null || this.fTD.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fTD.mNavigationBar.getFixedNavHeight();
                if (!(this.fME.bgE() != -1)) {
                    if (this.fVh != null && (layoutParams = (LinearLayout.LayoutParams) this.fVh.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fVh.setLayoutParams(layoutParams);
                    }
                    i--;
                    bkr();
                }
                i2 = fixedNavHeight;
            }
            this.fTH.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fTH.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fUr.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fUo.a(dVar, false);
        this.fUo.notifyDataSetChanged();
        bjT();
        if (this.fVN != null) {
            this.fVN.bfW();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fTX == null) {
            this.fME.getLayoutMode().onModeChanged(((ViewStub) this.fTI.findViewById(e.g.praise_layout)).inflate());
            this.fTX = (FrsPraiseView) this.fTI.findViewById(e.g.pb_head_praise_view);
            this.fTX.setIsFromPb(true);
            this.fUm = this.fTI.findViewById(e.g.new_pb_header_item_line_above_praise);
            this.fTX.ea(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fTX != null) {
            boolean bjT = bjT();
            this.fTX.setVisibility(8);
            if (dVar != null && dVar.xH() != null && dVar.xH().xE() == 0 && this.fMV) {
                if (bjT) {
                    this.fUl.setVisibility(0);
                    return;
                } else {
                    this.fUl.setVisibility(8);
                    return;
                }
            }
            this.fUl.setVisibility(8);
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
            this.fTN.setVisibility(8);
            if (dVar.beV() != null && dVar.beV().zj() && dVar.beV().yN() != null) {
                this.fVB = true;
                this.fTD.lv(this.fVB);
                this.fTD.mNavigationBar.hideBottomLine();
                if (this.fTx == null) {
                    this.fTx = new com.baidu.tieba.pb.video.i(this.fME, this.fTD, dVar.beV().yN(), this.fTy);
                    this.fTx.a(dVar.beV().yN(), dVar.beV(), dVar.getForumId());
                    this.fTx.startPlay();
                } else if (this.fTB) {
                    this.fTx.a(dVar.beV().yN(), dVar.beV(), dVar.getForumId());
                    this.fTx.startPlay();
                } else {
                    this.fTx.sP(dVar.getForumId());
                }
                if (dVar.beW() != null && dVar.beW().size() >= 1) {
                    bb bbVar = dVar.beW().get(0);
                    this.fTx.as(bbVar);
                    this.fTx.sQ(bbVar.getTitle());
                }
                this.fTx.b(b, dVar.beV(), dVar.bft());
                this.fTB = false;
                this.fTH.removeHeaderView(this.fTx.bmi());
                this.fTH.addHeaderView(this.fTx.bmi(), 0);
                if (this.fTx.bmf() != null && this.fTx.bmf().getParent() == null) {
                    this.fVf.addView(this.fTx.bmf());
                }
                if (this.fTz == null) {
                    this.fTz = new com.baidu.tieba.pb.video.h(this.fME);
                }
                this.fTz.a(dVar.beV().zy(), dVar.beV(), dVar.bfq());
                this.fTH.removeHeaderView(this.fTz.blW());
                this.fTH.addHeaderView(this.fTz.blW(), 1);
                if (dVar.beV().zy() != null) {
                    this.fTH.removeHeaderView(this.fTz.blX());
                    this.fTH.removeHeaderView(this.fTL);
                    this.fTH.addHeaderView(this.fTz.blX(), 2);
                } else {
                    if (this.fTz.blX() != null) {
                        this.fTH.removeHeaderView(this.fTz.blX());
                    }
                    this.fTH.removeHeaderView(this.fTL);
                    this.fTL.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fME, e.C0175e.tbds26));
                    this.fTH.addHeaderView(this.fTL, 2);
                }
                if (this.fTx != null) {
                    this.fTD.lp(false);
                    this.fTD.lr(TbadkCoreApplication.isLogin());
                    this.fTx.rS(TbadkCoreApplication.getInst().getSkinType());
                }
                bjQ();
            } else {
                this.fVB = false;
                this.fTD.lv(this.fVB);
                if (this.fTx != null) {
                    this.fTH.removeHeaderView(this.fTx.bmi());
                }
                if (this.fTz != null) {
                    this.fTz.b(this.fTH);
                }
                if (b == null || (b != null && (b.bCd() == null || com.baidu.tbadk.core.util.v.J(b.bCd().QK())))) {
                    this.fTL.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fME, e.C0175e.tbds52));
                } else {
                    this.fTL.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fME.bgq() != null) {
                this.fME.bgq().ln(this.fVB);
            }
            if (this.fTx != null) {
                this.fTx.L(this.fWd);
                bkr();
            }
            if (b != null) {
                this.fUX = b;
                this.fTN.setVisibility(0);
                if (this.fME.bfQ()) {
                    if (dVar.beU() != null) {
                        this.mForumName = dVar.beU().getForumName();
                        this.mForumId = dVar.beU().getForumId();
                    }
                    if (this.mForumName == null && this.fME.bga() != null && this.fME.bga().bfR() != null) {
                        this.mForumName = this.fME.bga().bfR();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fTN.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fTN.setTag(sparseArray);
                }
                sparseArray.put(e.g.tag_clip_board, b);
                sparseArray.put(e.g.tag_is_subpb, false);
                if (!this.fVS) {
                    this.fTJ.setVisibility(0);
                }
                if (!dVar.beV().zj() && this.fTK.getText() != null && this.fTK.getText().length() > 0) {
                    this.fTK.setVisibility(0);
                } else {
                    this.fTK.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> yH = dVar.beV().yH();
                if (yH != null && yH.size() > 0 && !this.fVS) {
                    this.fVa.setText(String.valueOf(yH.get(0).wO()));
                    this.fUZ.setVisibility(0);
                } else {
                    this.fUZ.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.fUZ, e.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.fVa, e.d.cp_link_tip_d, 1);
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
                            if (this.fNP != null) {
                                this.fNP.setTag(e.g.tag_user_id, b.yv().getUserId());
                                this.fNP.setOnClickListener(this.fME.fKI.fXV);
                                this.fNP.a(iconInfo, 4, this.fME.getResources().getDimensionPixelSize(e.C0175e.tbds36), this.fME.getResources().getDimensionPixelSize(e.C0175e.tbds36), this.fME.getResources().getDimensionPixelSize(e.C0175e.tbds12));
                            }
                            if (this.fNO != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fNO.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fNO.setOnClickListener(this.fME.fKI.fXW);
                                this.fNO.a(tShowInfoNew, 3, this.fME.getResources().getDimensionPixelSize(e.C0175e.tbds36), this.fME.getResources().getDimensionPixelSize(e.C0175e.tbds36), this.fME.getResources().getDimensionPixelSize(e.C0175e.ds12), true);
                            }
                            this.fTP.setText(aB(b.yv().getSealPrefix(), d));
                            this.fTP.setTag(e.g.tag_user_id, b.yv().getUserId());
                            this.fTP.setTag(e.g.tag_user_name, b.yv().getName_show());
                            if (com.baidu.tbadk.core.util.v.J(tShowInfoNew) || b.yv().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.fTP, e.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.fTP, e.d.cp_cont_f, 1);
                            }
                            this.fTQ.setVisibility(8);
                            if (dVar.beV().yv() != null && dVar.beV().yv().getAlaUserData() != null && this.fTV != null) {
                                if (dVar.beV().yv().getAlaUserData().anchor_live != 0) {
                                    this.fTV.setVisibility(8);
                                } else {
                                    this.fTV.setVisibility(0);
                                    if (this.fTA == null) {
                                        this.fTA = new com.baidu.tieba.c.d(this.fME.getPageContext(), this.fTV);
                                        this.fTA.kn(1);
                                    }
                                    this.fTA.bj(this.fME.getResources().getString(e.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aht = dVar.beV().yv().getAlaUserData();
                                    aVar.type = 2;
                                    this.fTV.setTag(aVar);
                                }
                            }
                            this.fTU.setUserId(b.yv().getUserId());
                            this.fTU.setUserName(b.yv().getUserName());
                            this.fTU.setTid(b.getId());
                            this.fTU.setFid(this.fQe == null ? this.fQe.getForumId() : "");
                            this.fTU.setImageDrawable(null);
                            this.fTU.setRadius(com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds40));
                            this.fTU.setTag(b.yv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                                this.fUd.setText(com.baidu.tbadk.core.util.ao.E(b.getTime()));
                            } else {
                                this.fUd.setText(com.baidu.tbadk.core.util.ao.C(b.getTime()));
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds16);
                            if (!this.fME.bfQ() && !StringUtils.isNull(this.mForumName)) {
                                this.aFR.setText(this.fME.getString(e.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.aFR.setVisibility(0);
                                this.fUg.setVisibility(0);
                                this.fUd.setPadding(h, 0, h, 0);
                            } else {
                                this.aFR.setVisibility(8);
                                this.fUg.setVisibility(8);
                                this.fUd.setPadding(0, 0, h, 0);
                            }
                            bCe = b.bCe();
                            if (bCe == null && !TextUtils.isEmpty(bCe.getName()) && !TextUtils.isEmpty(bCe.getName().trim())) {
                                final String name = bCe.getName();
                                final String lat = bCe.getLat();
                                final String lng = bCe.getLng();
                                this.fUe.setVisibility(0);
                                this.fUf.setVisibility(0);
                                this.fUe.setText(bCe.getName());
                                this.fUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kX()) {
                                                ar.this.fME.showToast(e.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ae(ar.this.fME.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, ar.this.fME.getPageContext().getString(e.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fUe.setVisibility(8);
                                this.fUf.setVisibility(8);
                            }
                            portrait = b.yv().getPortrait();
                            if (b.yv().getPendantData() == null && !StringUtils.isNull(b.yv().getPendantData().xf())) {
                                UtilHelper.showHeadImageViewBigV(this.fTS.getHeadView(), b.yv());
                                this.fTU.setVisibility(8);
                                this.fTS.setVisibility(0);
                                if (this.fTY != null) {
                                    this.fTY.setVisibility(8);
                                }
                                this.fTP.setOnClickListener(this.fWd);
                                this.fTS.getHeadView().startLoad(portrait, 28, false);
                                this.fTS.getHeadView().setUserId(b.yv().getUserId());
                                this.fTS.getHeadView().setUserName(b.yv().getUserName());
                                this.fTS.getHeadView().setTid(b.getId());
                                this.fTS.getHeadView().setFid(this.fQe != null ? this.fQe.getForumId() : "");
                                this.fTS.getHeadView().setOnClickListener(this.fWd);
                                this.fTS.fT(b.yv().getPendantData().xf());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fTU, b.yv());
                                this.fTU.setVisibility(0);
                                this.fTN.setOnClickListener(this.fWd);
                                this.fTP.setOnClickListener(this.fWd);
                                this.fTU.setOnClickListener(this.fWd);
                                this.fTS.setVisibility(8);
                                this.fTU.startLoad(portrait, 28, false);
                            }
                            String name_show = b.yv().getName_show();
                            String userName = b.yv().getUserName();
                            if (com.baidu.tbadk.p.am.jL() && name_show != null && !name_show.equals(userName)) {
                                this.fTP.setText(com.baidu.tieba.pb.c.aD(this.fME.getPageContext().getPageActivity(), this.fTP.getText().toString()));
                                this.fTP.setGravity(16);
                                this.fTP.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.beD());
                                com.baidu.tbadk.core.util.al.c(this.fTP, e.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.yv().getIconInfo();
                        tShowInfoNew = b.yv().getTShowInfoNew();
                        if (this.fNP != null) {
                        }
                        if (this.fNO != null) {
                        }
                        this.fTP.setText(aB(b.yv().getSealPrefix(), d));
                        this.fTP.setTag(e.g.tag_user_id, b.yv().getUserId());
                        this.fTP.setTag(e.g.tag_user_name, b.yv().getName_show());
                        if (com.baidu.tbadk.core.util.v.J(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fTP, e.d.cp_cont_h, 1);
                        this.fTQ.setVisibility(8);
                        if (dVar.beV().yv() != null) {
                            if (dVar.beV().yv().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fTU.setUserId(b.yv().getUserId());
                        this.fTU.setUserName(b.yv().getUserName());
                        this.fTU.setTid(b.getId());
                        this.fTU.setFid(this.fQe == null ? this.fQe.getForumId() : "");
                        this.fTU.setImageDrawable(null);
                        this.fTU.setRadius(com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds40));
                        this.fTU.setTag(b.yv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds16);
                        if (!this.fME.bfQ()) {
                        }
                        this.aFR.setVisibility(8);
                        this.fUg.setVisibility(8);
                        this.fUd.setPadding(0, 0, h, 0);
                        bCe = b.bCe();
                        if (bCe == null) {
                        }
                        this.fUe.setVisibility(8);
                        this.fUf.setVisibility(8);
                        portrait = b.yv().getPortrait();
                        if (b.yv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fTU, b.yv());
                        this.fTU.setVisibility(0);
                        this.fTN.setOnClickListener(this.fWd);
                        this.fTP.setOnClickListener(this.fWd);
                        this.fTU.setOnClickListener(this.fWd);
                        this.fTS.setVisibility(8);
                        this.fTU.startLoad(portrait, 28, false);
                        String name_show2 = b.yv().getName_show();
                        String userName2 = b.yv().getUserName();
                        if (com.baidu.tbadk.p.am.jL()) {
                            this.fTP.setText(com.baidu.tieba.pb.c.aD(this.fME.getPageContext().getPageActivity(), this.fTP.getText().toString()));
                            this.fTP.setGravity(16);
                            this.fTP.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.beD());
                            com.baidu.tbadk.core.util.al.c(this.fTP, e.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.yv().getIconInfo();
                            tShowInfoNew = b.yv().getTShowInfoNew();
                            if (this.fNP != null) {
                            }
                            if (this.fNO != null) {
                            }
                            this.fTP.setText(aB(b.yv().getSealPrefix(), d));
                            this.fTP.setTag(e.g.tag_user_id, b.yv().getUserId());
                            this.fTP.setTag(e.g.tag_user_name, b.yv().getName_show());
                            if (com.baidu.tbadk.core.util.v.J(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.fTP, e.d.cp_cont_h, 1);
                            this.fTQ.setVisibility(8);
                            if (dVar.beV().yv() != null) {
                            }
                            this.fTU.setUserId(b.yv().getUserId());
                            this.fTU.setUserName(b.yv().getUserName());
                            this.fTU.setTid(b.getId());
                            this.fTU.setFid(this.fQe == null ? this.fQe.getForumId() : "");
                            this.fTU.setImageDrawable(null);
                            this.fTU.setRadius(com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds40));
                            this.fTU.setTag(b.yv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds16);
                            if (!this.fME.bfQ()) {
                            }
                            this.aFR.setVisibility(8);
                            this.fUg.setVisibility(8);
                            this.fUd.setPadding(0, 0, h, 0);
                            bCe = b.bCe();
                            if (bCe == null) {
                            }
                            this.fUe.setVisibility(8);
                            this.fUf.setVisibility(8);
                            portrait = b.yv().getPortrait();
                            if (b.yv().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fTU, b.yv());
                            this.fTU.setVisibility(0);
                            this.fTN.setOnClickListener(this.fWd);
                            this.fTP.setOnClickListener(this.fWd);
                            this.fTU.setOnClickListener(this.fWd);
                            this.fTS.setVisibility(8);
                            this.fTU.startLoad(portrait, 28, false);
                            String name_show22 = b.yv().getName_show();
                            String userName22 = b.yv().getUserName();
                            if (com.baidu.tbadk.p.am.jL()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.yv().getIconInfo();
                        tShowInfoNew = b.yv().getTShowInfoNew();
                        if (this.fNP != null) {
                        }
                        if (this.fNO != null) {
                        }
                        this.fTP.setText(aB(b.yv().getSealPrefix(), d));
                        this.fTP.setTag(e.g.tag_user_id, b.yv().getUserId());
                        this.fTP.setTag(e.g.tag_user_name, b.yv().getName_show());
                        if (com.baidu.tbadk.core.util.v.J(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.fTP, e.d.cp_cont_h, 1);
                        this.fTQ.setVisibility(8);
                        if (dVar.beV().yv() != null) {
                        }
                        this.fTU.setUserId(b.yv().getUserId());
                        this.fTU.setUserName(b.yv().getUserName());
                        this.fTU.setTid(b.getId());
                        this.fTU.setFid(this.fQe == null ? this.fQe.getForumId() : "");
                        this.fTU.setImageDrawable(null);
                        this.fTU.setRadius(com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds40));
                        this.fTU.setTag(b.yv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fME.getActivity(), e.C0175e.ds16);
                        if (!this.fME.bfQ()) {
                        }
                        this.aFR.setVisibility(8);
                        this.fUg.setVisibility(8);
                        this.fUd.setPadding(0, 0, h, 0);
                        bCe = b.bCe();
                        if (bCe == null) {
                        }
                        this.fUe.setVisibility(8);
                        this.fUf.setVisibility(8);
                        portrait = b.yv().getPortrait();
                        if (b.yv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fTU, b.yv());
                        this.fTU.setVisibility(0);
                        this.fTN.setOnClickListener(this.fWd);
                        this.fTP.setOnClickListener(this.fWd);
                        this.fTU.setOnClickListener(this.fWd);
                        this.fTS.setVisibility(8);
                        this.fTU.startLoad(portrait, 28, false);
                        String name_show222 = b.yv().getName_show();
                        String userName222 = b.yv().getUserName();
                        if (com.baidu.tbadk.p.am.jL()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fTM.ak(dVar.beV());
                }
                if (this.fVi != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fIp);
                    if (dVar != null && dVar.beV() != null) {
                        hVar.fIr = dVar.beV().ym();
                    }
                    hVar.isNew = !this.fMV;
                    hVar.sortType = dVar.fIg;
                    if (dVar.fIf != null && dVar.fIf.size() > dVar.fIg) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.fIf.size()) {
                                break;
                            } else if (dVar.fIf.get(i4).sort_type.intValue() != dVar.fIg) {
                                i3 = i4 + 1;
                            } else {
                                hVar.fIt = dVar.fIf.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.fIu = this.fME.bhc();
                    this.fVi.a(hVar);
                }
            }
        }
    }

    public void kZ(boolean z) {
        if (z) {
            bjN();
        } else {
            aui();
        }
        this.fVm.fWv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVm));
        a(this.fVm.fWv, false);
    }

    public void bjN() {
        if (this.fTD != null && !this.fVD) {
            this.fTD.lw(!StringUtils.isNull(this.fME.bgB()));
            this.fVD = true;
        }
    }

    public void aui() {
        if (this.fTD != null) {
            this.fTD.bkX();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.yR() != null) {
            this.fTO.setData(this.fME.getPageContext(), dVar.beX().get(0).yR(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.beT().getId(), dVar.beT().getName(), dVar.beV().getId(), this.fME.bgZ() ? "FRS" : null));
            this.fTN.setPadding(this.fTN.getPaddingLeft(), (int) this.fME.getResources().getDimension(e.C0175e.ds20), this.fTN.getPaddingRight(), this.fTN.getPaddingBottom());
            return;
        }
        this.fTO.setData(null, null, null);
    }

    public void bjO() {
        if (this.fTx != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").x("obj_type", 1));
            this.fTx.bmg();
            this.fTH.smoothScrollToPosition(0);
        }
    }

    public boolean bjP() {
        return this.fWe;
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
            this.fTD.bkV();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fTD.qr(cVar.forumName);
            }
            String string = this.fME.getResources().getString(e.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.fME.getResources().getString(e.j.self);
                    break;
                case 300:
                    str = this.fME.getResources().getString(e.j.bawu);
                    break;
                case 400:
                    str = this.fME.getResources().getString(e.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fHx;
            this.fME.showNetRefreshView(this.dgE, format, null, this.fME.getResources().getString(e.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.lo()) {
                        ay.CU().c(ar.this.fME.getPageContext(), new String[]{str2});
                        ar.this.fME.finish();
                        return;
                    }
                    ar.this.fME.showToast(e.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable biY;
        Parcelable biY2;
        String str;
        if (dVar != null) {
            this.fQe = dVar;
            this.mType = i;
            if (dVar.beV() != null) {
                this.fVo = dVar.beV().ye();
                if (dVar.beV().getAnchorLevel() != 0) {
                    this.fWe = true;
                }
                this.fUK = am(dVar.beV());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fUY = false;
            this.fMV = z;
            bjJ();
            b(dVar, z, i);
            p(dVar);
            if (this.fVQ == null) {
                this.fVQ = new ac(this.fME.getPageContext(), this.dWt);
            }
            this.fVQ.sw(dVar.bfa());
            if (this.fME.bgQ()) {
                if (this.fUs == null) {
                    this.fUs = new com.baidu.tieba.pb.view.d(this.fME.getPageContext());
                    this.fUs.oG();
                    this.fUs.a(this.aEo);
                }
                this.fTH.setPullRefresh(this.fUs);
                bjQ();
                if (this.fUs != null) {
                    this.fUs.dW(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.xH().xE() == 0 && z) {
                this.fTH.setPullRefresh(null);
            } else {
                if (this.fUs == null) {
                    this.fUs = new com.baidu.tieba.pb.view.d(this.fME.getPageContext());
                    this.fUs.oG();
                    this.fUs.a(this.aEo);
                }
                this.fTH.setPullRefresh(this.fUs);
                bjQ();
                if (this.fUs != null) {
                    this.fUs.dW(TbadkCoreApplication.getInst().getSkinType());
                }
                akj();
            }
            bjT();
            this.fUo.km(this.fMV);
            this.fUo.kn(false);
            this.fUo.ky(i == 5);
            this.fUo.kz(i == 6);
            this.fUo.kA(z2 && this.fWc);
            this.fUo.a(dVar, false);
            this.fUo.notifyDataSetChanged();
            if (this.fME.bfQ()) {
                this.fVF = 0;
                PostData b = b(dVar, z);
                if (b != null && b.yv() != null) {
                    this.fVF = b.yv().getLevel_id();
                }
                if (this.fVF > 0) {
                    this.fTR.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.fTR, BitmapHelper.getGradeResourceIdInEnterForum(this.fVF));
                } else {
                    this.fTR.setVisibility(8);
                }
            } else {
                this.fTR.setVisibility(8);
            }
            if (dVar.beV() != null) {
                if (dVar.beV().yi() != null) {
                    if (dVar.beV().yi().getNum() < 1) {
                        str = this.fME.getResources().getString(e.j.zan);
                    } else {
                        str = dVar.beV().yi().getNum() + "";
                    }
                    if (this.fTw != -1) {
                        dVar.beV().yi().setIsLike(this.fTw);
                    }
                    U(str, dVar.beV().yi().getIsLike() == 1);
                }
                if (dVar.beV().arg != null && dVar.beV().arg.isDeleted) {
                    this.fTD.lq(true);
                } else {
                    this.fTD.lq(false);
                }
            }
            if (this.fME.isLogin()) {
                this.fTH.setNextPage(this.dFQ);
                this.fTC = 2;
                akj();
            } else {
                this.fUY = true;
                if (dVar.xH().xD() == 1) {
                    if (this.fUt == null) {
                        this.fUt = new com.baidu.tieba.pb.view.a(this.fME.getPageContext());
                    }
                    this.fTH.setNextPage(this.fUt);
                } else {
                    this.fTH.setNextPage(this.dFQ);
                }
                this.fTC = 3;
            }
            ArrayList<PostData> beX = dVar.beX();
            if (dVar.xH().xD() == 0 || beX == null || beX.size() < dVar.xH().xC()) {
                if (com.baidu.tbadk.core.util.v.I(beX) == 0 || (com.baidu.tbadk.core.util.v.I(beX) == 1 && beX.get(0) != null && beX.get(0).bCb() == 1)) {
                    this.dFQ.setText(this.fME.getResources().getString(e.j.list_no_more_new));
                    if (this.fME.bgq() != null && !this.fME.bgq().bkL()) {
                        this.fME.bgq().showFloatingView();
                    }
                } else if (dVar.xH().xD() == 0) {
                    this.dFQ.setText(this.fME.getResources().getString(e.j.list_has_no_more));
                } else {
                    this.dFQ.setText(this.fME.getResources().getString(e.j.load_more));
                }
                if (this.fME.bgQ() && this.fTH != null && this.fTH.getData() != null && this.fTH.getData().size() == 1 && (this.fTH.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dFQ.setText("");
                }
                bka();
            } else if (z2) {
                if (this.fWc) {
                    DP();
                    if (dVar.xH().xD() != 0) {
                        this.dFQ.setText(this.fME.getResources().getString(e.j.pb_load_more));
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
                    this.fTH.setSelection(i2 > 1 ? (((this.fTH.getData() == null && dVar.beX() == null) ? 0 : (this.fTH.getData().size() - dVar.beX().size()) + this.fTH.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (biY2 = aj.biX().biY()) != null) {
                        this.fTH.onRestoreInstanceState(biY2);
                        if (com.baidu.tbadk.core.util.v.I(beX) > 1 && dVar.xH().xD() > 0) {
                            this.dFQ.DP();
                            this.dFQ.setText(this.fME.getString(e.j.pb_load_more_without_point));
                            this.dFQ.DL();
                            break;
                        }
                    } else {
                        this.fTH.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fWc = false;
                    break;
                case 5:
                    this.fTH.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (biY = aj.biX().biY()) != null) {
                        this.fTH.onRestoreInstanceState(biY);
                        break;
                    } else {
                        this.fTH.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.fTx != null && this.fTx.bmf() != null) {
                            if (this.fME.isUseStyleImmersiveSticky()) {
                                this.fTH.setSelectionFromTop((this.fUo.bhu() + this.fTH.getHeaderViewsCount()) - 1, this.fTx.bmf().getHeight() - com.baidu.adp.lib.util.l.r(this.fME.getPageContext().getPageActivity()));
                            } else {
                                this.fTH.setSelectionFromTop((this.fUo.bhu() + this.fTH.getHeaderViewsCount()) - 1, this.fTx.bmf().getHeight());
                            }
                        } else {
                            this.fTH.setSelection(this.fUo.bhu() + this.fTH.getHeaderViewsCount());
                        }
                    } else {
                        this.fTH.setSelection(i2 > 0 ? ((this.fTH.getData() == null && dVar.beX() == null) ? 0 : (this.fTH.getData().size() - dVar.beX().size()) + this.fTH.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dFQ.DP();
                    this.dFQ.setText(this.fME.getString(e.j.pb_load_more_without_point));
                    this.dFQ.DL();
                    break;
            }
            if (this.fVo == fVp && isHost()) {
                bki();
            }
            if (this.fVz) {
                bjh();
                this.fVz = false;
                if (i3 == 0) {
                    kS(true);
                }
            }
            if (this.fTz != null) {
                this.fTz.ar(dVar.beV());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fId == 1 || dVar.fIe == 1) {
                if (this.fVG == null) {
                    this.fVG = new PbTopTipView(this.fME);
                }
                if (dVar.fIe == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fME.getStType())) {
                    this.fVG.setText(this.fME.getString(e.j.pb_read_strategy_add_experience));
                    this.fVG.show(this.dgE, this.mSkinType);
                } else if (dVar.fId == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fME.getStType())) {
                    this.fVG.setText(this.fME.getString(e.j.pb_read_news_add_experience));
                    this.fVG.show(this.dgE, this.mSkinType);
                }
            }
        }
    }

    private void bjQ() {
        if (this.fTx != null && this.fTx.bmf() != null) {
            this.fTH.removeHeaderView(this.aQj);
            if (this.mType != 1) {
                this.fTH.removeHeaderView(this.fTx.bmi());
                this.fTH.addHeaderView(this.fTx.bmi(), 0);
                return;
            }
            return;
        }
        if (this.fTx != null) {
            this.fTH.removeHeaderView(this.fTx.bmi());
        }
        this.fTH.removeHeaderView(this.aQj);
        this.fTH.addHeaderView(this.aQj, 0);
    }

    public void la(boolean z) {
        this.fUJ = z;
    }

    public void DP() {
        if (this.dFQ != null) {
            this.dFQ.DL();
            this.dFQ.DP();
        }
        akj();
    }

    public void amg() {
        this.fTH.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fUX != null && this.fUX.yv() != null && this.fTD != null) {
            this.fVC = !this.fVB;
            this.fTD.lp(this.fVC);
            if (this.fME.bgq() != null) {
                this.fME.bgq().lo(this.fVC);
            }
            bjR();
            if (this.fVC) {
                this.fTD.fYI.setVisibility(0);
                if (this.fUK) {
                    this.fTD.fYJ.setVisibility(8);
                    this.fTZ.setVisibility(8);
                    this.fUc.setVisibility(0);
                    this.fUc.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.J(dVar.bfs())));
                } else if (!PbNormalLikeButtonSwitchStatic.Op() || (this.fUX.yv().hadConcerned() && this.fUX.yv().getGodUserData() != null && this.fUX.yv().getGodUserData().getIsFromNetWork())) {
                    this.fTD.fYJ.setVisibility(8);
                }
                if (this.fVh != null) {
                    this.fVh.setVisibility(8);
                }
                this.fTD.a(this.fUX.yv(), this.fWd);
                if (this.fVO == null) {
                    this.fVO = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fVE) {
                                ar.this.bkh();
                            }
                            ar.this.bjK();
                        }
                    };
                }
                this.fTH.setListViewDragListener(this.fVO);
                return;
            }
            if (this.fTD.fYI != null) {
                this.fTD.fYI.setVisibility(8);
            }
            if (this.fVh != null) {
                this.fVh.setVisibility(0);
            }
            if (this.fUK) {
                this.fTZ.setVisibility(8);
                this.fUc.setVisibility(0);
                this.fUc.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.J(dVar.bfs())));
            } else if (!PbNormalLikeButtonSwitchStatic.Op() || (this.fUX.yv().hadConcerned() && this.fUX.yv().getGodUserData() != null && this.fUX.yv().getGodUserData().getIsFromNetWork())) {
                this.fTZ.setVisibility(8);
                this.fUc.setVisibility(8);
            } else {
                this.fUc.setVisibility(8);
            }
            this.fVO = null;
            this.fTH.setListViewDragListener(null);
        }
    }

    private void bjR() {
        String threadId = this.fQe != null ? this.fQe.getThreadId() : "";
        int bjS = bjS();
        if (this.fVC) {
            if (this.fUb == null) {
                this.fUb = new ap(this.fME.getPageContext(), this.fTD.fYJ, 3);
                this.fUb.h(this.fME.getUniqueId());
            }
            if (this.fUX != null && this.fUX.yv() != null) {
                this.fUX.yv().setIsLike(this.fUX.yv().hadConcerned());
                this.fUb.a(this.fUX.yv());
            }
            this.fUb.setTid(threadId);
            this.fUb.rK(bjS);
            this.fUb.fTs = this.fVB;
        }
        if (this.fUa == null) {
            this.fUa = new ap(this.fME.getPageContext(), this.fTZ, 1);
            this.fUa.h(this.fME.getUniqueId());
            this.fUa.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bt(boolean z) {
                    if (ar.this.fME != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fME, e.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fME.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fUX != null && this.fUX.yv() != null) {
            this.fUX.yv().setIsLike(this.fUX.yv().hadConcerned());
            this.fUa.a(this.fUX.yv());
            this.fUa.setTid(threadId);
        }
        this.fUa.fTs = this.fVB;
        this.fUa.rK(bjS);
    }

    public int bjS() {
        if (this.fQe == null || this.fQe.beV() == null) {
            return 0;
        }
        if (this.fQe.beV().zG()) {
            return (com.baidu.tbadk.core.util.v.J(this.fQe.bfr()) && (this.fQe.beU() == null || StringUtils.isNull(this.fQe.beU().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bjT() {
        boolean z;
        if (this.fUN != null && this.fUN.getVisibility() == 0) {
            if (this.fUk != null) {
                this.fUk.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fUk != null) {
                this.fUk.setVisibility(8);
            }
            z = false;
        }
        if ((this.fUm == null || this.fUm.getVisibility() == 8) && z && this.fMV) {
            this.fUl.setVisibility(0);
        } else {
            this.fUl.setVisibility(8);
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
            return com.baidu.tieba.card.o.a((Context) this.fME.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fTJ != null) {
                if (dVar.beV() != null && dVar.beV().yL() == 0 && !dVar.beV().zj() && !this.fVS) {
                    this.fTJ.setVisibility(0);
                    if (dVar.beV() != null) {
                        bb beV = dVar.beV();
                        beV.g(true, q(dVar));
                        beV.setResource(3);
                        beV.dT("2");
                    }
                    SpannableStringBuilder yV = dVar.beV().yV();
                    this.fTK.setOnTouchListener(new com.baidu.tieba.view.k(yV));
                    this.fTK.setText(yV);
                    this.fTK.setVisibility(0);
                } else if (dVar.beV().yL() == 1) {
                    if (dVar.beV() != null) {
                        this.fTJ.setVisibility(8);
                        this.fTH.removeHeaderView(this.fTJ);
                        if (dVar.beV() != null && !dVar.beV().zj()) {
                            this.fTN.setPadding(this.fTN.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.tbds36), this.fTN.getPaddingRight(), this.fTN.getPaddingBottom());
                        }
                    }
                } else {
                    this.fTJ.setVisibility(8);
                    this.fTH.removeHeaderView(this.fTJ);
                    if (dVar.beV() != null && dVar.beV().zj()) {
                        this.fTN.setPadding(this.fTN.getPaddingLeft(), 0, this.fTN.getPaddingRight(), this.fTN.getPaddingBottom());
                    } else {
                        this.fTN.setPadding(this.fTN.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds48), this.fTN.getPaddingRight(), this.fTN.getPaddingBottom());
                    }
                }
            }
            this.fMV = z;
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
                            sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(this.fME.getString(e.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(e.g.tag_del_multi_forum, String.format(this.fME.getString(e.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
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
        return this.fTH;
    }

    public int bjU() {
        return e.g.richText;
    }

    public TextView bgl() {
        return this.fTM.bgl();
    }

    public void e(BdListView.e eVar) {
        this.fTH.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.aEo = bVar;
        if (this.fUs != null) {
            this.fUs.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int xB = alVar.xB();
            int xy = alVar.xy();
            if (this.fUp != null) {
                this.fUp.Au();
            } else {
                this.fUp = new com.baidu.tbadk.core.dialog.a(this.fME.getPageContext().getPageActivity());
                this.fUq = LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.dialog_direct_pager, (ViewGroup) null);
                this.fUp.G(this.fUq);
                this.fUp.a(e.j.dialog_ok, bVar);
                this.fUp.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bjW();
                        aVar.dismiss();
                    }
                });
                this.fUp.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fVw == null) {
                            ar.this.fVw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fME.HidenSoftKeyPad((InputMethodManager) ar.this.fME.getSystemService("input_method"), ar.this.dgE);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jI().postDelayed(ar.this.fVw, 150L);
                    }
                });
                this.fUp.b(this.fME.getPageContext()).Au();
            }
            this.fUr = (EditText) this.fUq.findViewById(e.g.input_page_number);
            this.fUr.setText("");
            TextView textView = (TextView) this.fUq.findViewById(e.g.current_page_number);
            if (xB <= 0) {
                xB = 1;
            }
            if (xy <= 0) {
                xy = 1;
            }
            textView.setText(MessageFormat.format(this.fME.getApplicationContext().getResources().getString(e.j.current_page), Integer.valueOf(xB), Integer.valueOf(xy)));
            this.fME.ShowSoftKeyPadDelay(this.fUr, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fTH.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fME.showToast(str);
    }

    public boolean lb(boolean z) {
        if (this.SY == null || !this.SY.KK()) {
            return false;
        }
        this.SY.Jg();
        return true;
    }

    public void bjV() {
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
        bjV();
        this.fUo.rv(1);
        if (this.fTx != null) {
            this.fTx.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.fUo.rv(2);
        if (this.fTx != null) {
            this.fTx.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fVy != null) {
            this.fVy.destroy();
        }
        if (this.fVQ != null) {
            this.fVQ.onDestory();
        }
        if (this.fVG != null) {
            this.fVG.hide();
        }
        if (this.fTA != null) {
            this.fTA.apY();
        }
        if (this.fTz != null) {
            this.fTz.onDestroy();
        }
        this.fME.hideProgressBar();
        if (this.dgC != null && this.dxY != null) {
            this.dgC.b(this.dxY);
        }
        bjW();
        DP();
        if (this.fVw != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fVw);
        }
        if (this.fTN != null && this.fTY != null) {
            this.fTN.removeView(this.fTT);
            this.fTY = null;
        }
        if (this.fVc != null) {
            this.fVc.clearStatus();
        }
        this.fVY = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fUo.rv(3);
        if (this.dCt != null) {
            this.dCt.setBackgroundDrawable(null);
        }
        if (this.fTx != null) {
            this.fTx.destroy();
        }
        if (this.fUo != null) {
            this.fUo.onDestroy();
        }
        this.fTH.setOnLayoutListener(null);
        if (this.fVM != null) {
            this.fVM.aBV();
        }
        if (this.fVn != null) {
            this.fVn.onDestroy();
        }
        bks();
    }

    public boolean rN(int i) {
        if (this.fTx != null) {
            return this.fTx.lM(i);
        }
        return false;
    }

    public void bjW() {
        this.fTD.vO();
        if (this.fTA != null) {
            this.fTA.apY();
        }
        com.baidu.adp.lib.util.l.a(this.fME.getPageContext().getPageActivity(), this.fUr);
        bjj();
        if (this.fUH != null) {
            this.fUH.dismiss();
        }
        bjY();
        if (this.fTz != null) {
            this.fTz.blY();
        }
        if (this.fUp != null) {
            this.fUp.dismiss();
        }
        if (this.dCd != null) {
            this.dCd.dismiss();
        }
    }

    public void bjX() {
        this.fTD.vO();
        if (this.fTA != null) {
            this.fTA.apY();
        }
        if (this.fUH != null) {
            this.fUH.dismiss();
        }
        bjY();
        if (this.fTz != null) {
            this.fTz.blY();
        }
        if (this.fUp != null) {
            this.fUp.dismiss();
        }
        if (this.dCd != null) {
            this.dCd.dismiss();
        }
    }

    public void dl(List<String> list) {
        this.fVL = list;
        if (this.fVM != null) {
            this.fVM.setData(list);
        }
    }

    public void kl(boolean z) {
        this.fUo.kl(z);
    }

    public void lc(boolean z) {
        this.fUM = z;
    }

    public void bjY() {
        if (this.fUy != null) {
            this.fUy.dismiss();
        }
        if (this.fUz != null) {
            com.baidu.adp.lib.g.g.b(this.fUz, this.fME.getPageContext());
        }
        if (this.fUA != null) {
            com.baidu.adp.lib.g.g.b(this.fUA, this.fME.getPageContext());
        }
        if (this.fUw != null) {
            com.baidu.adp.lib.g.g.b(this.fUw, this.fME.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fQe, this.fMV);
            d(this.fQe, this.fMV, this.mType);
            this.fME.getLayoutMode().setNightMode(i == 1);
            this.fME.getLayoutMode().onModeChanged(this.dgE);
            this.fME.getLayoutMode().onModeChanged(this.fTI);
            if (this.fTz != null) {
                this.fTz.onChangeSkinType(i);
            }
            if (this.fTK != null) {
                com.baidu.tbadk.core.util.al.h(this.fTK, e.d.cp_cont_b);
                this.fTK.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            }
            if (this.dFQ != null) {
                this.dFQ.dW(i);
                if (this.baU != null) {
                    this.fME.getLayoutMode().onModeChanged(this.baU);
                    com.baidu.tbadk.core.util.al.i(this.baU, e.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fUp != null) {
                this.fUp.c(this.fME.getPageContext());
            }
            la(this.fUJ);
            this.fUo.notifyDataSetChanged();
            if (this.fUs != null) {
                this.fUs.dW(i);
            }
            if (this.SY != null) {
                this.SY.onChangeSkinType(i);
            }
            if (this.fTX != null) {
                this.fTX.ea(i);
            }
            if (this.fUt != null) {
                this.fUt.dW(i);
            }
            if (!com.baidu.tbadk.core.util.v.J(this.cPt)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cPt) {
                    customBlueCheckRadioButton.Dx();
                }
            }
            kW(i == 1);
            bjy();
            UtilHelper.setStatusBarBackground(this.dCt, i);
            UtilHelper.setStatusBarBackground(this.fVh, i);
            if (this.fTZ != null) {
                this.fTZ.onChangeSkinType(i);
            }
            if (this.fUe != null) {
                com.baidu.tbadk.core.util.al.h(this.fUe, e.d.cp_cont_d);
            }
            if (this.fUd != null) {
                com.baidu.tbadk.core.util.al.h(this.fUd, e.d.cp_cont_d);
            }
            if (this.fUf != null) {
                com.baidu.tbadk.core.util.al.i(this.fUf, e.d.cp_cont_e);
            }
            if (this.aFR != null) {
                com.baidu.tbadk.core.util.al.h(this.aFR, e.d.cp_cont_d);
            }
            if (this.fUg != null) {
                com.baidu.tbadk.core.util.al.i(this.fUg, e.d.cp_cont_e);
            }
            if (this.fTQ != null) {
                com.baidu.tbadk.core.util.al.h(this.fTQ, e.d.cp_link_tip_a);
            }
            if (this.fUc != null) {
                com.baidu.tbadk.core.util.al.h(this.fUc, e.d.cp_cont_d);
            }
            if (this.fUh != null) {
                com.baidu.tbadk.o.a.a(this.fME.getPageContext(), this.fUh);
            }
            if (this.fUF != null) {
                com.baidu.tbadk.o.a.a(this.fME.getPageContext(), this.fUF);
            }
            if (this.fVx != null) {
                this.fVx.onChangeSkinType(i);
            }
            if (this.fTD != null) {
                if (this.fTx != null) {
                    this.fTx.rS(i);
                } else {
                    this.fTD.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fUP != null) {
                com.baidu.tbadk.core.util.al.h(this.fUP, e.d.cp_cont_e);
            }
            if (this.fTR != null) {
                com.baidu.tbadk.core.util.al.c(this.fTR, BitmapHelper.getGradeResourceIdInEnterForum(this.fVF));
            }
            if (this.fVN != null) {
                this.fVN.onChangeSkinType(i);
            }
            if (this.fVn != null) {
                this.fVn.onChangeSkinType();
            }
            if (this.fVJ != null) {
                com.baidu.tbadk.core.util.al.h(this.fVJ, e.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bnD = hVar;
        this.fUo.setOnImageClickListener(this.bnD);
        this.fVN.setOnImageClickListener(this.bnD);
    }

    public void h(NoNetworkView.a aVar) {
        this.dxY = aVar;
        if (this.dgC != null) {
            this.dgC.a(this.dxY);
        }
    }

    public void ld(boolean z) {
        this.fUo.setIsFromCDN(z);
    }

    public Button bjZ() {
        return this.fUN;
    }

    public void bka() {
        if (this.fTC != 2) {
            this.fTH.setNextPage(this.dFQ);
            this.fTC = 2;
        }
    }

    public void bkb() {
        if (com.baidu.tbadk.l.m.NX().NY()) {
            int lastVisiblePosition = this.fTH.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fTH.getChildAt(i);
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
        if (this.fUO != null) {
            lc(this.fME.bgm().Ln());
            if (this.fUM) {
                kT(z);
            } else {
                kU(z);
            }
        }
    }

    public void bkf() {
        if (this.fUO != null) {
            this.fUO.setVisibility(8);
            this.fUT = false;
            if (this.fVn != null) {
                this.fVn.setVisibility(8);
                kY(false);
            }
            bks();
        }
    }

    public void showLoadingDialog() {
        if (this.cWM == null) {
            this.cWM = new com.baidu.tbadk.core.view.d(this.fME.getPageContext());
        }
        this.cWM.bj(true);
    }

    public void akj() {
        if (this.cWM != null) {
            this.cWM.bj(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fTH.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fTH.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fTx != null) {
            this.fTx.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.fWg = getScrollY();
            this.fVm.fWv = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVm));
            a(this.fVm.fWv, true);
        }
    }

    public void lf(boolean z) {
        this.fTx.lf(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fTx != null) {
            this.fTx.b(absListView, i);
        }
        int headerViewsCount = (i - this.fTH.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (headerViewsCount <= i2 && this.fUo.ru(headerViewsCount) != com.baidu.tieba.pb.data.i.fIv) {
            headerViewsCount++;
        }
        boolean z = i < this.fTH.getHeaderViewsCount();
        if (this.fTL != null && this.fTD != null) {
            this.fTD.g(this.fTL.getBottom(), this.fTL.getMeasuredHeight(), z);
        }
        this.fVm.fDd = i;
        this.fVm.headerCount = this.fTH.getHeaderViewsCount();
        this.fVm.fWv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fVm));
        a(this.fVm.fWv, false);
    }

    public void bkg() {
        if (this.fME.isLogin() && this.fQe != null && this.fVC && !this.fVB && !this.fUK && this.fUX != null && this.fUX.yv() != null && !this.fUX.yv().getIsLike() && !this.fUX.yv().hadConcerned()) {
            if (this.fVy == null) {
                this.fVy = new an(this.fME);
            }
            this.fVy.a(this.fTD.fYI, this.fQe.bfv(), this.fUX.yv().getUserId(), this.fQe.getThreadId());
        }
    }

    public void bkh() {
        if (this.fVC && !this.fVB && this.fUX != null && this.fUX.yv() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").x("obj_locate", this.fME.bfQ() ? 2 : 1).x("obj_type", this.fVB ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fME.getPageContext().getPageActivity(), this.fUX.yv().getUserId(), this.fUX.yv().getUserName(), this.fME.bga().bfR(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fVB && this.fVg != null && this.fTD.bkQ() != null) {
            int bhv = this.fUo.bhv();
            if (bhv > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bhv > this.fTH.getFirstVisiblePosition() - this.fTH.getHeaderViewsCount()) {
                    this.fVg.setVisibility(8);
                    return;
                }
                this.fVg.setVisibility(0);
                bkr();
                this.fTD.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fSW == null) {
                if (this.fTH.getFirstVisiblePosition() == 0) {
                    this.fVg.setVisibility(8);
                    this.fTD.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fVl) {
                        this.fVk = top;
                        this.fVl = false;
                    }
                    this.fVk = top < this.fVk ? top : this.fVk;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fUn.getY() < 0.0f) {
                        measuredHeight = fVj - alVar.fSW.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fTD.bkQ().getMeasuredHeight() - alVar.fSW.getMeasuredHeight();
                        this.fTD.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fVk) {
                        this.fVg.setVisibility(0);
                        bkr();
                    } else if (top < measuredHeight) {
                        this.fVg.setVisibility(0);
                        bkr();
                    } else {
                        this.fVg.setVisibility(8);
                        this.fTD.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fVl = true;
                    }
                }
            }
        }
    }

    public void bki() {
        if (!this.fWh) {
            TiebaStatic.log("c10490");
            this.fWh = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fME.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fVq, Integer.valueOf(fVs));
            aVar.cy(e.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.function_description_view)).setText(e.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(e.g.title_view)).setText(e.j.grade_thread_tips);
            aVar.G(inflate);
            aVar.H(sparseArray);
            aVar.a(e.j.grade_button_tips, this.fME);
            aVar.b(e.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fME.getPageContext()).Au();
        }
    }

    public void sy(String str) {
        if (str.contains(BaseRequestAction.SPLITE)) {
            str = str.replace(BaseRequestAction.SPLITE, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fME.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(e.g.function_description_view)).setVisibility(8);
        aVar.G(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fVq, Integer.valueOf(fVt));
        aVar.H(sparseArray);
        aVar.a(e.j.view, this.fME);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fME.getPageContext()).Au();
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
        return this.fVc;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.beV() != null && dVar.beV().zn() && this.fVc == null) {
            this.fVc = (PbInterviewStatusView) this.fVb.inflate();
            this.fVc.setOnClickListener(this.dCe);
            this.fVc.setCallback(this.fME.bgY());
            this.fVc.setData(this.fME, dVar);
        }
    }

    public LinearLayout bkk() {
        return this.fUn;
    }

    public View bkl() {
        return this.dCt;
    }

    public boolean bkm() {
        return this.fVS;
    }

    public void kq(boolean z) {
        this.fTM.kq(z);
    }

    public void sz(String str) {
        if (this.fTE != null) {
            this.fTE.setTitle(str);
        }
    }

    private int lg(boolean z) {
        if (this.fVc == null || this.fVc.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds72);
    }

    private void bkn() {
        if (this.fVc != null && this.fVc.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fVc.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fVc.setLayoutParams(layoutParams);
        }
    }

    public boolean bgs() {
        return false;
    }

    public void sA(String str) {
        this.fUP.performClick();
        if (!StringUtils.isNull(str) && this.fME.bgm() != null && this.fME.bgm().Lg() != null && this.fME.bgm().Lg().getInputView() != null) {
            EditText inputView = this.fME.bgm().Lg().getInputView();
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
            if (this.fVx != null) {
                this.fVx.bhC();
            }
            this.fME.azQ();
            this.fUn.setVisibility(8);
            this.fTD.ls(false);
            this.fME.kw(false);
            if (this.fTx != null) {
                if (configuration.orientation == 1) {
                    bkk().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fTH.setIsLandscape(true);
                    this.fTH.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fTH.setIsLandscape(false);
                    if (this.fWg > 0) {
                        this.fTH.smoothScrollBy(this.fWg, 0);
                    }
                }
                this.fTx.onConfigurationChanged(configuration);
                this.fVf.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void lh(boolean z) {
        this.fTB = z;
    }

    public boolean bko() {
        return this.fTx != null && this.fTx.bko();
    }

    public void bkp() {
        if (this.fTx != null) {
            this.fTx.onPause();
        }
    }

    public void n(long j, int i) {
        if (this.fTz != null) {
            this.fTz.n(j, i);
        }
        if (this.fTx != null) {
            this.fTx.n(j, i);
        }
    }

    public void kB(boolean z) {
        this.fUo.kB(z);
    }

    public void bkq() {
        if (this.fVd == null) {
            LayoutInflater.from(this.fME.getActivity()).inflate(e.h.add_experienced_text, (ViewGroup) this.dgE, true);
            this.fVd = (ViewGroup) this.dgE.findViewById(e.g.add_experienced_layout);
            this.fVe = (TextView) this.dgE.findViewById(e.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.fVe, e.d.cp_cont_i);
            String string = this.fME.getResources().getString(e.j.experienced_add_success);
            String string2 = this.fME.getResources().getString(e.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_h)));
            this.fVe.setText(spannableString);
        }
        this.fVd.setVisibility(0);
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
                        ar.this.fVd.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fVe.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fVe.startAnimation(scaleAnimation);
    }

    public void bB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fUO.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fME);
            frameLayout.setBackgroundResource(e.f.pic_sign_tip);
            this.fVJ = new TextView(this.fME);
            this.fVJ.setText(e.j.connection_tips);
            this.fVJ.setGravity(17);
            this.fVJ.setPadding(com.baidu.adp.lib.util.l.h(this.fME, e.C0175e.ds24), 0, com.baidu.adp.lib.util.l.h(this.fME, e.C0175e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fME, e.C0175e.ds60);
            if (this.fVJ.getParent() == null) {
                frameLayout.addView(this.fVJ, layoutParams);
            }
            this.fVI = new PopupWindow(this.fME);
            this.fVI.setContentView(frameLayout);
            this.fVI.setHeight(-2);
            this.fVI.setWidth(-2);
            this.fVI.setFocusable(true);
            this.fVI.setOutsideTouchable(false);
            this.fVI.setBackgroundDrawable(new ColorDrawable(this.fME.getResources().getColor(e.d.transparent)));
            this.fTH.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fVI.showAsDropDown(ar.this.fUO, view.getLeft(), -ar.this.fUO.getHeight());
                    } else {
                        ar.this.fVI.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bkr() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.fVK == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.fVK = new com.baidu.tbadk.core.dialog.a(this.fME);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.fME);
            this.fVK.cB(1);
            this.fVK.G(pbLongPressTipView);
            this.fVK.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.31
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fVK.aP(false);
            this.fVK.b(this.fME.getPageContext()).Au();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.32
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fVK != null && ar.this.fVK.isShowing()) {
                        ar.this.fVK.dismiss();
                    }
                }
            }, 5000L);
            if (this.fTx != null) {
                this.fTx.bmh();
            }
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bkH() != null && !StringUtils.isNull(aVar.bkH().pkg_id) && !StringUtils.isNull(aVar.bkH().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fUQ != null && this.fUQ.getVisibility() == 0) {
            if (this.fVH == null) {
                View inflate = LayoutInflater.from(this.fME.getPageContext().getPageActivity()).inflate(e.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(e.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(e.g.single_bar_tips);
                textView.setText(e.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dCe);
                this.fVH = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fUQ.getLocationInWindow(iArr);
            this.fVH.showAtLocation(this.fUQ, 0, iArr[0] - com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds54), (iArr[1] - this.fUQ.getHeight()) - com.baidu.adp.lib.util.l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bks() {
        com.baidu.adp.lib.g.g.a(this.fVH);
    }

    public void li(boolean z) {
        this.fVP = z;
    }

    public boolean bkt() {
        return this.fVP;
    }

    public void bC(View view) {
        this.fUF = view;
    }
}
