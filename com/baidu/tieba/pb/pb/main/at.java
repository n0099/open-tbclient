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
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
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
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class at {
    private EditorTools Qg;
    private TextView aIt;
    private View aTf;
    private g.b aww;
    private TextView ayq;
    private com.baidu.tieba.pb.a.c bge;
    private List<CustomBlueCheckRadioButton> cBk;
    private View cFr;
    private RelativeLayout cSA;
    private NoNetworkView cSy;
    private NavigationBarCoverTip dHq;
    private com.baidu.tieba.NEGFeedBack.e dKo;
    private View.OnClickListener doi;
    private View dox;
    private PbListView drC;
    private com.baidu.tieba.pb.data.d fBa;
    public int fED;
    private com.baidu.tieba.pb.video.i fEE;
    private long fEF;
    private com.baidu.tieba.pb.video.h fEG;
    private com.baidu.tieba.c.d fEH;
    public final com.baidu.tieba.pb.pb.main.view.b fEK;
    public com.baidu.tieba.pb.pb.main.view.a fEL;
    private ViewStub fEM;
    private ViewStub fEN;
    private PbLandscapeListView fEO;
    private View fEP;
    private LinearLayout fES;
    private e fET;
    private ColumnLayout fEU;
    private ThreadSkinView fEV;
    private TextView fEW;
    private TextView fEX;
    private ImageView fEY;
    private HeadPendantView fEZ;
    private View fFB;
    private View fFV;
    private TextView fFW;
    private ImageView fFX;
    private ImageView fFY;
    private TextView fFZ;
    private FrameLayout fFa;
    private HeadImageView fFb;
    private View fFc;
    private FloatingLayout fFd;
    private PbFirstFloorUserLikeButton fFg;
    private ar fFh;
    private ar fFi;
    private TextView fFj;
    private TextView fFk;
    private TextView fFl;
    private View fFm;
    private View fFn;
    private LinearLayout fFo;
    private TextView fFp;
    private TextView fFq;
    private View fFr;
    private View fFs;
    private ObservedChangeLinearLayout fFu;
    private f fFv;
    private int fGC;
    private Runnable fGD;
    private s fGE;
    private an fGF;
    private int fGL;
    private PbTopTipView fGN;
    private PopupWindow fGO;
    private PopupWindow fGP;
    private TextView fGQ;
    private List<String> fGR;
    private com.baidu.tieba.pb.pb.main.emotion.c fGS;
    private com.baidu.tieba.pb.pb.godreply.a fGT;
    private PbLandscapeListView.b fGU;
    private ac fGW;
    private boolean fGY;
    private com.baidu.tbadk.core.view.userLike.c fGZ;
    private boolean fGb;
    private int fGc;
    private int fGd;
    private PostData fGe;
    private View fGg;
    private TextView fGh;
    private ViewStub fGi;
    private PbInterviewStatusView fGj;
    private ViewGroup fGk;
    private TextView fGl;
    private FrameLayout fGm;
    private View fGn;
    private View fGo;
    private al fGp;
    private PbEmotionBar fGu;
    private com.baidu.tbadk.core.view.userLike.c fHa;
    private Runnable fHf;
    private PbActivity.b fHh;
    private int fHm;
    PbActivity.d fwy;
    private View.OnClickListener fxR;
    private PbActivity fxt;
    private UserIconBox fyI;
    private UserIconBox fyJ;
    private PbFakeFloorModel fzU;
    private boolean isLandscape;
    private int mType;
    private static final int fGq = UtilHelper.getLightStatusBarHeight();
    public static int fGw = 3;
    public static int fGx = 0;
    public static int fGy = 3;
    public static int fGz = 4;
    public static int fGA = 5;
    public static int fGB = 6;
    private static a.InterfaceC0234a fGX = new a.InterfaceC0234a() { // from class: com.baidu.tieba.pb.pb.main.at.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
        }
    };
    private boolean fEI = false;
    private int fEJ = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fEQ = null;
    private TextView fER = null;
    public FrsPraiseView fFe = null;
    private ClickableHeaderImageView fFf = null;
    private View fFt = null;
    private com.baidu.tbadk.core.dialog.a fFw = null;
    private com.baidu.tbadk.core.dialog.b doh = null;
    private View fFx = null;
    private EditText fFy = null;
    private com.baidu.tieba.pb.view.e fFz = null;
    private com.baidu.tieba.pb.view.a fFA = null;
    private com.baidu.tbadk.core.dialog.a fFC = null;
    private b.InterfaceC0101b evO = null;
    private TbRichTextView.h bgd = null;
    private NoNetworkView.a dkf = null;
    private Dialog fFD = null;
    private View fFE = null;
    private com.baidu.tbadk.core.dialog.a fFF = null;
    private Dialog fFG = null;
    private Dialog fFH = null;
    private View fFI = null;
    private LinearLayout fFJ = null;
    private CompoundButton.OnCheckedChangeListener cBl = null;
    private TextView fFK = null;
    private TextView fFL = null;
    private View fFM = null;
    private String fFN = null;
    private com.baidu.tbadk.core.dialog.b fFO = null;
    private com.baidu.tbadk.core.dialog.b fFP = null;
    private boolean fFQ = false;
    private boolean fFR = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fFS = null;
    private boolean fFT = false;
    private Button fFU = null;
    private boolean fGa = true;
    private com.baidu.tbadk.core.view.a cIH = null;
    private boolean fxK = false;
    private int mSkinType = 3;
    private boolean fGf = false;
    private int fGr = 0;
    private boolean fGs = true;
    private a fGt = new a();
    private int fGv = 0;
    private boolean fGG = false;
    private int fGH = 0;
    private boolean fGI = false;
    private boolean fGJ = false;
    private boolean fGK = false;
    private int fGM = 0;
    private boolean fGV = false;
    private String fHb = null;
    private CustomMessageListener fHc = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.at.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                at.this.fHb = null;
            }
        }
    };
    private CustomMessageListener bxy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.at.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && at.this.fFv != null) {
                at.this.fFv.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fHd = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.at.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (at.this.fER != null) {
                at.this.fER.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fHe = new Handler();
    private CustomMessageListener fHg = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.at.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                at.this.fGa = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fHi = true;
    View.OnClickListener fHj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (at.this.fGI) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").r(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (at.this.fEK != null && at.this.fEK.fJM != null && view == at.this.fEK.fJM.getHeadView()) {
                if (at.this.fEK.fJK == null || at.this.fEK.fJK.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12506").r("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!at.this.fGI && at.this.fBa != null && at.this.fBa.aZn() != null && at.this.fBa.aZn().vk() != null && at.this.fBa.aZn().vk().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").r("obj_locate", 1));
            }
            at.this.fxt.fvw.fIV.onClick(view);
        }
    };
    private boolean fHk = false;
    String userId = null;
    private final List<TbImageView> fHl = new ArrayList();
    private boolean fHn = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fHB;
        public al fHC;
        public int fok;
    }

    public void ke(boolean z) {
        this.fGG = z;
        if (this.fEO != null) {
            this.fGH = this.fEO.getHeaderViewsCount();
        }
    }

    public void bdC() {
        if (this.fEO != null) {
            int headerViewsCount = this.fEO.getHeaderViewsCount() - this.fGH;
            final int firstVisiblePosition = (this.fEO.getFirstVisiblePosition() == 0 || this.fEO.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fEO.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fEO.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fGt.fHC = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGt));
            final al alVar = this.fGt.fHC;
            final int h = h(alVar);
            final int y = ((int) this.fFu.getY()) + this.fFu.getMeasuredHeight();
            final boolean z = this.fGn.getVisibility() == 0;
            boolean z2 = this.fFu.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fFv.bbN() + this.fEO.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fDS.getMeasuredHeight() : 0;
                if (z2) {
                    this.fEO.setSelectionFromTop(this.fFv.bbN() + this.fEO.getHeaderViewsCount(), fGq - measuredHeight);
                } else {
                    this.fEO.setSelectionFromTop(this.fFv.bbN() + this.fEO.getHeaderViewsCount(), this.fEK.bff().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fEO.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fGI) {
                this.fEO.setSelectionFromTop(this.fFv.bbN() + this.fEO.getHeaderViewsCount(), this.fEE.bgv().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fEO.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.at.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bce() {
                        if (h >= 0 && h <= at.this.cSA.getMeasuredHeight()) {
                            int h2 = at.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = at.this.cFr.getLayoutParams();
                            if (i == 0 || i > at.this.cSA.getMeasuredHeight() || h2 >= at.this.cSA.getMeasuredHeight()) {
                                layoutParams.height = at.this.fGC;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > at.this.cSA.getMeasuredHeight()) {
                                layoutParams.height = at.this.fGC;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                at.this.fEO.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            at.this.cFr.setLayoutParams(layoutParams);
                        }
                        at.this.fEO.setOnLayoutListener(null);
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

    public NoNetworkView bdD() {
        return this.cSy;
    }

    public void bdE() {
        if (this.Qg != null) {
            this.Qg.hide();
            if (this.fGS != null) {
                this.fGS.SL();
            }
        }
    }

    public PbFakeFloorModel bdF() {
        return this.fzU;
    }

    public s bdG() {
        return this.fGE;
    }

    public void bdH() {
        reset();
        bdE();
        this.fGE.bbU();
        kq(false);
    }

    private void reset() {
        if (this.fxt != null && this.fxt.baF() != null && this.Qg != null) {
            com.baidu.tbadk.editortools.pb.a.HP().setStatus(0);
            com.baidu.tbadk.editortools.pb.d baF = this.fxt.baF();
            baF.Ii();
            baF.HD();
            if (baF.getWriteImagesInfo() != null) {
                baF.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            baF.eU(SendView.ALL);
            baF.eV(SendView.ALL);
            com.baidu.tbadk.editortools.g eL = this.Qg.eL(23);
            com.baidu.tbadk.editortools.g eL2 = this.Qg.eL(2);
            com.baidu.tbadk.editortools.g eL3 = this.Qg.eL(5);
            if (eL2 != null) {
                eL2.oF();
            }
            if (eL3 != null) {
                eL3.oF();
            }
            if (eL != null) {
                eL.hide();
            }
            this.Qg.invalidate();
        }
    }

    public boolean bdI() {
        return this.fGa;
    }

    public void kf(boolean z) {
        if (this.fFV != null && this.fFW != null) {
            this.fFW.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fFV.startAnimation(alphaAnimation);
            }
            this.fFV.setVisibility(0);
            this.fGa = true;
            if (this.fGu != null && !this.fGT.isActive()) {
                this.fGu.setVisibility(0);
                kk(true);
            }
        }
    }

    public void kg(boolean z) {
        if (this.fFV != null && this.fFW != null) {
            this.fFW.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fFV.startAnimation(alphaAnimation);
            }
            this.fFV.setVisibility(0);
            this.fGa = true;
            if (this.fGu != null && !this.fGT.isActive()) {
                this.fGu.setVisibility(0);
                kk(true);
            }
        }
    }

    public PostData bdJ() {
        int i = 0;
        if (this.fEO == null) {
            return null;
        }
        int bdK = bdK() - this.fEO.getHeaderViewsCount();
        if (bdK < 0) {
            bdK = 0;
        }
        if (this.fFv.qx(bdK) != null && this.fFv.qx(bdK) != PostData.gNT) {
            i = bdK + 1;
        }
        return this.fFv.getItem(i) instanceof PostData ? (PostData) this.fFv.getItem(i) : null;
    }

    public int bdK() {
        int i;
        View childAt;
        if (this.fEO == null) {
            return 0;
        }
        int firstVisiblePosition = this.fEO.getFirstVisiblePosition();
        int lastVisiblePosition = this.fEO.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fEO.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fEO.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bdL() {
        return this.fEO.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fBa != null && this.fBa.aZp() != null && !this.fBa.aZp().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fBa.aZp().size() && (postData = this.fBa.aZp().get(i)) != null && postData.vk() != null && !StringUtils.isNull(postData.vk().getUserId()); i++) {
                if (this.fBa.aZp().get(i).vk().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fGT != null && this.fGT.isActive()) {
                        kq(false);
                    }
                    if (this.fGu != null) {
                        this.fGu.kx(true);
                    }
                    this.fHb = postData.vk().getName_show();
                    return;
                }
            }
        }
    }

    public at(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fxt = null;
        this.cSA = null;
        this.dox = null;
        this.fEF = 0L;
        this.fEO = null;
        this.fEP = null;
        this.fES = null;
        this.fEU = null;
        this.fEW = null;
        this.fEX = null;
        this.fFa = null;
        this.fFb = null;
        this.fFc = null;
        this.fFg = null;
        this.fFj = null;
        this.fFk = null;
        this.fFl = null;
        this.fFm = null;
        this.fFr = null;
        this.fFs = null;
        this.fFv = null;
        this.drC = null;
        this.aTf = null;
        this.doi = null;
        this.fxR = null;
        this.fFV = null;
        this.fFW = null;
        this.fFX = null;
        this.fFY = null;
        this.fFZ = null;
        this.fGg = null;
        this.fGh = null;
        this.fGi = null;
        this.fGL = 0;
        this.fEF = System.currentTimeMillis();
        this.fxt = pbActivity;
        this.doi = onClickListener;
        this.bge = cVar;
        this.fGL = com.baidu.adp.lib.util.l.ah(this.fxt) / 2;
        this.cSA = (RelativeLayout) LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.fxt.addContentView(this.cSA, new FrameLayout.LayoutParams(-1, -1));
        this.dHq = (NavigationBarCoverTip) this.fxt.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dox = this.fxt.findViewById(d.g.statebar_view);
        this.fFu = (ObservedChangeLinearLayout) this.fxt.findViewById(d.g.title_wrapper);
        this.cSy = (NoNetworkView) this.fxt.findViewById(d.g.view_no_network);
        this.fEO = (PbLandscapeListView) this.fxt.findViewById(d.g.new_pb_list);
        this.fGm = (FrameLayout) this.fxt.findViewById(d.g.root_float_header);
        this.aIt = new TextView(this.fxt.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds88));
        this.fEO.addHeaderView(this.aIt, 0);
        this.fGC = this.fxt.getResources().getDimensionPixelSize(d.e.tbds134);
        this.cFr = new View(this.fxt.getPageContext().getPageActivity());
        this.cFr.setLayoutParams(new AbsListView.LayoutParams(-1, this.fGC));
        this.cFr.setVisibility(4);
        this.fEO.addFooterView(this.cFr);
        this.fEO.setOnTouchListener(this.fxt.aWF);
        this.fEK = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fxt.bbh()) {
            this.fEM = (ViewStub) this.fxt.findViewById(d.g.manga_view_stub);
            this.fEM.setVisibility(0);
            this.fEL = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fEL.show();
            this.fEK.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds120);
        }
        this.aIt.setLayoutParams(layoutParams);
        this.fEK.bff().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0204a() { // from class: com.baidu.tieba.pb.pb.main.at.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0204a
            public void bah() {
                if (at.this.fEO != null) {
                    if (at.this.fEE != null) {
                        at.this.fEE.bgw();
                    }
                    at.this.fEO.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0204a
            public void bai() {
                at.this.fxt.auC();
            }
        }));
        this.fFV = this.fxt.findViewById(d.g.pb_editor_tool_comment);
        this.fGc = com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds90);
        this.fGd = com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds242);
        this.fFW = (TextView) this.fxt.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fFY = (ImageView) this.fxt.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fFX = (ImageView) this.fxt.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fFZ = (TextView) this.fxt.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fFZ.setVisibility(8);
        this.fFW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.beL();
                if (!at.this.fxt.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).af(ImageViewerConfig.FORUM_ID, at.this.mForumId));
                } else if (at.this.fxt.baP()) {
                    com.baidu.tbadk.editortools.pb.d baF = at.this.fxt.baF();
                    if (baF == null || (!baF.If() && !baF.Ig())) {
                        if (at.this.Qg != null) {
                            at.this.bdV();
                        }
                        if (at.this.Qg != null) {
                            at.this.fGa = false;
                            if (at.this.Qg.eO(2) != null) {
                                com.baidu.tieba.tbadkCore.b.a.a(at.this.fxt, (View) at.this.Qg.eO(2).aMf, false, at.fGX);
                            }
                        }
                        at.this.bez();
                        return;
                    }
                    at.this.fxt.baF().a(false, (PostWriteCallBackData) null);
                }
            }
        });
        this.fFX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.beL();
                if (at.this.fxt.checkUpIsLogin()) {
                    if (at.this.Qg != null) {
                        at.this.bdV();
                        at.this.Qg.N((View) at.this.Qg.eL(5));
                    }
                    if (at.this.Qg != null) {
                        at.this.fGa = false;
                        if (at.this.Qg.eO(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(at.this.fxt, (View) at.this.Qg.eO(2).aMf, false, at.fGX);
                        }
                    }
                    at.this.bez();
                }
            }
        });
        this.fFY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.beL();
                if (at.this.fxt.checkUpIsLogin()) {
                    if (at.this.Qg != null) {
                        at.this.bdV();
                        at.this.Qg.N((View) at.this.Qg.eL(2));
                    }
                    if (at.this.Qg != null) {
                        at.this.fGa = false;
                        if (at.this.Qg.eO(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(at.this.fxt, (View) at.this.Qg.eO(2).aMf, false, at.fGX);
                        }
                    }
                    at.this.bez();
                }
            }
        });
        this.fFZ.setOnClickListener(this.doi);
        this.fFZ.setOnTouchListener(this.fxt);
        this.fEP = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fES = (LinearLayout) LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.fET = new e(this.fxt, this.fES);
        this.fET.init();
        this.fET.a(this.fET.baE(), this.doi);
        this.fEU = (ColumnLayout) this.fES.findViewById(d.g.pb_head_owner_root);
        this.fEV = (ThreadSkinView) this.fES.findViewById(d.g.pb_thread_skin);
        this.fEU.setOnLongClickListener(this.onLongClickListener);
        this.fEU.setOnTouchListener(this.bge);
        this.fEU.setVisibility(8);
        this.fEP.setOnTouchListener(this.bge);
        this.fGg = this.fEP.findViewById(d.g.pb_head_activity_join_number_container);
        this.fGg.setVisibility(8);
        this.fGh = (TextView) this.fEP.findViewById(d.g.pb_head_activity_join_number);
        this.fEW = (TextView) this.fEU.findViewById(d.g.pb_head_owner_info_user_name);
        this.fEX = (TextView) this.fEU.findViewById(d.g.floor_owner);
        this.fEY = (ImageView) this.fEU.findViewById(d.g.icon_forum_level);
        this.fFa = (FrameLayout) this.fEU.findViewById(d.g.pb_head_headImage_container);
        this.fFb = (HeadImageView) this.fEU.findViewById(d.g.pb_head_owner_photo);
        this.fEZ = (HeadPendantView) this.fEU.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fEZ.setHasPendantStyle();
        if (this.fEZ.getHeadView() != null) {
            this.fEZ.getHeadView().setIsRound(true);
            this.fEZ.getHeadView().setDrawBorder(false);
        }
        this.fyI = (UserIconBox) this.fEU.findViewById(d.g.show_icon_vip);
        this.fyJ = (UserIconBox) this.fEU.findViewById(d.g.show_icon_yinji);
        this.fFd = (FloatingLayout) this.fES.findViewById(d.g.pb_head_owner_info_root);
        this.fFg = (PbFirstFloorUserLikeButton) this.fEU.findViewById(d.g.pb_like_button);
        this.fFj = (TextView) this.fEU.findViewById(d.g.pb_views);
        this.ayq = (TextView) this.fEU.findViewById(d.g.view_forum_name);
        this.fFn = this.fEU.findViewById(d.g.line_right_forum_name);
        this.fFk = (TextView) this.fEU.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fFl = (TextView) this.fEU.findViewById(d.g.pb_item_first_floor_location_address);
        this.fFm = this.fEU.findViewById(d.g.line_between_time_and_locate);
        this.fGZ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fHa = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fFr = this.fEP.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fFs = this.fEP.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fEP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.35
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fGi = (ViewStub) this.cSA.findViewById(d.g.interview_status_stub);
        this.fFv = new f(this.fxt, this.fEO);
        this.fFv.u(this.doi);
        this.fFv.setTbGestureDetector(this.bge);
        this.fFv.setOnImageClickListener(this.bgd);
        this.fxR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.36
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
                            at.this.fxt.b(sparseArray);
                            return;
                        }
                        at.this.bl(view);
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        at.this.fxt.b(sparseArray);
                    } else if (booleanValue3) {
                        at.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fFv.G(this.fxR);
        bdQ();
        this.fEO.addHeaderView(this.fEQ);
        this.fEO.addHeaderView(this.fES);
        this.fEO.addHeaderView(this.fEP);
        this.drC = new PbListView(this.fxt.getPageContext().getPageActivity());
        this.aTf = this.drC.getView().findViewById(d.g.pb_more_view);
        if (this.aTf != null) {
            this.aTf.setOnClickListener(this.doi);
            com.baidu.tbadk.core.util.am.i(this.aTf, d.f.pb_foot_more_trans_selector);
        }
        this.drC.At();
        this.drC.dz(d.f.pb_foot_more_trans_selector);
        this.drC.dB(d.f.pb_foot_more_trans_selector);
        this.fFB = this.fxt.findViewById(d.g.viewstub_progress);
        this.fxt.registerListener(this.fHg);
        this.fFc = com.baidu.tbadk.ala.b.rx().g(this.fxt.getActivity(), 2);
        if (this.fFc != null) {
            this.fFc.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fxt.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fFc.getParent() == null) {
                this.fFd.addView(this.fFc, aVar);
            }
        }
        this.fzU = new PbFakeFloorModel(this.fxt.getPageContext());
        this.fGE = new s(this.fxt.getPageContext(), this.fzU, this.cSA);
        this.fGE.a(this.fxt.fwu);
        this.fzU.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.at.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                at.this.fzU.l(postData);
                at.this.fFv.notifyDataSetChanged();
                at.this.fGE.bbU();
                at.this.Qg.FP();
                at.this.kq(false);
            }
        });
        if (this.fxt.bat() != null && !StringUtils.isNull(this.fxt.bat().bcN())) {
            this.fxt.showToast(this.fxt.bat().bcN());
        }
        this.fGn = this.fxt.findViewById(d.g.pb_expand_blank_view);
        this.fGo = this.fxt.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fGo.getLayoutParams();
        if (this.fxt.bat() != null && this.fxt.bat().bcl()) {
            this.fGn.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fGo.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fGq;
            this.fGo.setLayoutParams(layoutParams2);
        }
        this.fGp = new al(this.fxt.getPageContext(), this.fxt.findViewById(d.g.pb_reply_expand_view));
        this.fGp.fDS.setVisibility(8);
        this.fGp.J(this.doi);
        this.fxt.registerListener(this.bxy);
        this.fxt.registerListener(this.fHc);
        this.fxt.registerListener(this.fHd);
        bdM();
        kk(false);
    }

    private void bdM() {
        this.fGT = new com.baidu.tieba.pb.pb.godreply.a(this.fxt, this, (ViewStub) this.cSA.findViewById(d.g.more_god_reply_popup));
        this.fGT.q(this.doi);
        this.fGT.G(this.fxR);
        this.fGT.setOnImageClickListener(this.bgd);
        this.fGT.q(this.doi);
        this.fGT.setTbGestureDetector(this.bge);
    }

    public com.baidu.tieba.pb.pb.godreply.a bdN() {
        return this.fGT;
    }

    public View bdO() {
        return this.fGn;
    }

    public void bdP() {
        if (this.fEO != null) {
            this.fEO.removeHeaderView(this.fEQ);
            this.fEO.removeHeaderView(this.fES);
            this.fEO.removeHeaderView(this.fEP);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fGu == null) {
            this.fGu = new PbEmotionBar(this.fxt.getPageContext().getPageActivity());
            kk(true);
            this.fGu.a(this.cSA, aVar, this.fFV.getVisibility() == 0);
            this.fGu.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.at.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (at.this.fxt.baP()) {
                        if (!StringUtils.isNull(at.this.fHb)) {
                            emotionImageData.setAuthorNameShow(at.this.fHb);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    at.this.fxt.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(at.this.fxt.getPageContext().getPageActivity(), 25016, str, list, at.this.fHb, list2)));
                }
            });
            this.fGu.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.at.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    at.this.beL();
                    if (at.this.fFV != null) {
                        ViewGroup.LayoutParams layoutParams = at.this.fFV.getLayoutParams();
                        layoutParams.height = (int) (((at.this.fGd - at.this.fGc) * f) + at.this.fGc);
                        at.this.fFW.setAlpha(1.0f - f);
                        at.this.fFY.setAlpha(1.0f - f);
                        at.this.fFX.setAlpha(1.0f - f);
                        at.this.fFV.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bdQ() {
        if (this.fEQ == null) {
            int f = com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.tbds44);
            this.fEQ = new LinearLayout(this.fxt.getPageContext().getPageActivity());
            this.fEQ.setOrientation(1);
            this.fEQ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fEQ.setPadding(f, com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.tbds30), f, com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.tbds40));
            this.fEQ.setGravity(17);
            this.fER = new TextView(this.fxt.getPageContext().getPageActivity());
            this.fER.setGravity(3);
            this.fER.setMaxLines(2);
            this.fER.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_link_tip_c));
            this.fER.setPadding(0, 0, 0, 0);
            this.fER.setLineSpacing(com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.am.h(this.fER, d.C0140d.cp_cont_b);
            this.fER.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fER.setVisibility(8);
            if (this.fER.getParent() == null) {
                this.fEQ.addView(this.fER);
            }
            this.fEQ.setOnTouchListener(this.bge);
            this.fEQ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdR() {
        if (this.fxt.bbh()) {
            this.fEN = (ViewStub) this.fxt.findViewById(d.g.manga_mention_controller_view_stub);
            this.fEN.setVisibility(0);
            if (this.fFo == null) {
                this.fFo = (LinearLayout) this.fxt.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fxt.getPageContext(), this.fFo);
            }
            if (this.fFp == null) {
                this.fFp = (TextView) this.fFo.findViewById(d.g.manga_prev_btn);
            }
            if (this.fFq == null) {
                this.fFq = (TextView) this.fFo.findViewById(d.g.manga_next_btn);
            }
            this.fFp.setOnClickListener(this.doi);
            this.fFq.setOnClickListener(this.doi);
        }
    }

    private void bdS() {
        if (this.fxt.bbh()) {
            if (this.fxt.bbk() == -1) {
                com.baidu.tbadk.core.util.am.c(this.fFp, d.C0140d.cp_cont_e, 1);
            }
            if (this.fxt.bbl() == -1) {
                com.baidu.tbadk.core.util.am.c(this.fFq, d.C0140d.cp_cont_e, 1);
            }
        }
    }

    public void bdT() {
        if (this.fFo == null) {
            bdR();
        }
        this.fEN.setVisibility(8);
        if (this.fHe != null && this.fHf != null) {
            this.fHe.removeCallbacks(this.fHf);
        }
    }

    public void bdU() {
        if (this.fHe != null) {
            if (this.fHf != null) {
                this.fHe.removeCallbacks(this.fHf);
            }
            this.fHf = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.this.fFo == null) {
                        at.this.bdR();
                    }
                    at.this.fEN.setVisibility(0);
                }
            };
            this.fHe.postDelayed(this.fHf, 2000L);
        }
    }

    public void kh(boolean z) {
        this.fEK.kh(z);
        if (z && this.fGf) {
            this.drC.setText(this.fxt.getResources().getString(d.j.click_load_more));
            this.fEO.setNextPage(this.drC);
            this.fEJ = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
        this.Qg.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Qg.getParent() == null) {
            this.cSA.addView(this.Qg, layoutParams);
        }
        this.Qg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bdE();
        this.fxt.baF().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.at.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (at.this.Qg != null && at.this.Qg.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (at.this.fGS == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, at.this.Qg.getId());
                            at.this.fGS = new com.baidu.tieba.pb.pb.main.emotion.c(at.this.fxt.getPageContext(), at.this.cSA, layoutParams2);
                            if (!com.baidu.tbadk.core.util.w.z(at.this.fGR)) {
                                at.this.fGS.setData(at.this.fGR);
                            }
                            at.this.fGS.b(at.this.Qg);
                        }
                        at.this.fGS.rt(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (at.this.fxt.fvA != null && at.this.fxt.fvA.beQ() != null) {
                    if (!at.this.fxt.fvA.beQ().bFm()) {
                        at.this.fxt.fvA.ku(false);
                    }
                    at.this.fxt.fvA.beQ().no(false);
                }
            }
        });
    }

    public void bdV() {
        if (this.fxt != null && this.Qg != null) {
            this.Qg.oF();
            if (this.fxt.baF() != null) {
                this.fxt.baF().HW();
            }
            bez();
        }
    }

    public void M(String str, boolean z) {
        this.fGb = z;
        ki(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void ki(boolean z) {
        if (this.fFZ != null) {
            if (this.fGb) {
                com.baidu.tbadk.core.util.am.i(this.fFZ, d.f.pb_praise_already_click_selector);
                this.fFZ.setContentDescription(this.fxt.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.am.i(this.fFZ, d.f.pb_praise_normal_click_selector);
            this.fFZ.setContentDescription(this.fxt.getResources().getString(d.j.zan));
        }
    }

    public TextView bdW() {
        return this.fFZ;
    }

    public void kj(boolean z) {
        if (this.fEO != null && this.aIt != null && this.dox != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dox.setVisibility(0);
                } else {
                    this.dox.setVisibility(8);
                    this.fEO.removeHeaderView(this.aIt);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aIt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fGq;
                    this.aIt.setLayoutParams(layoutParams);
                }
                bek();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aIt.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kr(true);
                this.aIt.setLayoutParams(layoutParams2);
            }
            bek();
            beH();
        }
    }

    public f bdX() {
        return this.fFv;
    }

    public void a(PbActivity.d dVar) {
        this.fwy = dVar;
    }

    public void bl(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fFE == null) {
            this.fFE = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fxt.getLayoutMode().onModeChanged(this.fFE);
        if (this.fFD == null) {
            this.fFD = new Dialog(this.fxt.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fFD.setCanceledOnTouchOutside(true);
            this.fFD.setCancelable(true);
            this.fFD.setContentView(this.fFE);
            WindowManager.LayoutParams attributes = this.fFD.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ah(this.fxt.getPageContext().getPageActivity()) * 0.9d);
            this.fFD.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fFD.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fFD.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fFD.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFD != null && (at.this.fFD instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFD, at.this.fxt.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        at.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(d.g.tag_forbid_user_name)) && "".equals(sparseArray.get(d.g.tag_forbid_user_name_show))) || beG()) {
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
            sparseArray5.put(d.g.tag_forbid_user_portrait, sparseArray.get(d.g.tag_forbid_user_portrait));
            sparseArray5.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray5.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFD != null && (at.this.fFD instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFD, at.this.fxt.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && at.this.fHh != null) {
                        at.this.fHh.i(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id), sparseArray6.get(d.g.tag_forbid_user_name_show), sparseArray6.get(d.g.tag_forbid_user_portrait)});
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
            sparseArray6.put(d.g.tag_user_mute_mute_nameshow, sparseArray.get(d.g.tag_user_mute_mute_nameshow));
            sparseArray6.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray6.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray6.put(d.g.tag_user_mute_msg, sparseArray.get(d.g.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFD != null && (at.this.fFD instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFD, at.this.fxt.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        at.this.fxt.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fFD, this.fxt.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fHh = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fxt != null && aVar != null) {
            if (this.dKo == null) {
                this.dKo = new com.baidu.tieba.NEGFeedBack.e(this.fxt.getPageContext(), this.fEP);
            }
            AntiData Ce = this.fxt.Ce();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (Ce != null && Ce.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Ce.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.dKo.setDefaultReasonArray(new String[]{this.fxt.getString(d.j.delete_thread_reason_1), this.fxt.getString(d.j.delete_thread_reason_2), this.fxt.getString(d.j.delete_thread_reason_3), this.fxt.getString(d.j.delete_thread_reason_4), this.fxt.getString(d.j.delete_thread_reason_5)});
            this.dKo.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.dKo.hY(str);
            this.dKo.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.at.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray) {
                    at.this.fxt.a(aVar, jSONArray);
                }
            });
        }
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(fGx, Integer.valueOf(fGy));
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
        this.fFF = new com.baidu.tbadk.core.dialog.a(this.fxt.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fFF.cf(i3);
        } else {
            this.fFF.az(false);
            this.fFF.dB(str2);
        }
        this.fFF.C(sparseArray);
        this.fFF.a(d.j.dialog_ok, this.fxt);
        this.fFF.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fFF.au(true);
        this.fFF.b(this.fxt.getPageContext());
        if (z) {
            this.fFF.xf();
        } else {
            a(this.fFF, i);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fFI == null) {
            this.fFI = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.fxt.getLayoutMode().onModeChanged(this.fFI);
        if (this.fFH == null) {
            this.fFH = new Dialog(this.fxt.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fFH.setCanceledOnTouchOutside(true);
            this.fFH.setCancelable(true);
            this.fFS = (ScrollView) this.fFI.findViewById(d.g.good_scroll);
            this.fFH.setContentView(this.fFI);
            WindowManager.LayoutParams attributes = this.fFH.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds540);
            this.fFH.getWindow().setAttributes(attributes);
            this.cBl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.at.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        at.this.fFN = (String) compoundButton.getTag();
                        if (at.this.cBk != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : at.this.cBk) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && at.this.fFN != null && !str.equals(at.this.fFN)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fFJ = (LinearLayout) this.fFI.findViewById(d.g.good_class_group);
            this.fFL = (TextView) this.fFI.findViewById(d.g.dialog_button_cancel);
            this.fFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFH instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(at.this.fFH, at.this.fxt.getPageContext());
                    }
                }
            });
            this.fFK = (TextView) this.fFI.findViewById(d.g.dialog_button_ok);
            this.fFK.setOnClickListener(this.doi);
        }
        this.fFJ.removeAllViews();
        this.cBk = new ArrayList();
        CustomBlueCheckRadioButton bQ = bQ("0", this.fxt.getPageContext().getString(d.j.thread_good_class));
        this.cBk.add(bQ);
        bQ.setChecked(true);
        this.fFJ.addView(bQ);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.tY()) && aaVar.tZ() > 0) {
                    CustomBlueCheckRadioButton bQ2 = bQ(String.valueOf(aaVar.tZ()), aaVar.tY());
                    this.cBk.add(bQ2);
                    View view = new View(this.fxt.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.am.j(view, d.C0140d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fFJ.addView(view);
                    this.fFJ.addView(bQ2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fFS.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxt.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxt.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxt.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fFS.setLayoutParams(layoutParams2);
            this.fFS.removeAllViews();
            if (this.fFJ != null && this.fFJ.getParent() == null) {
                this.fFS.addView(this.fFJ);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fFH, this.fxt.getPageContext());
    }

    private CustomBlueCheckRadioButton bQ(String str, String str2) {
        Activity pageActivity = this.fxt.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cBl);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bdY() {
        this.fxt.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fxt.hideProgressBar();
        if (z && z2) {
            this.fxt.showToast(this.fxt.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.fxt.showToast(str);
        }
    }

    public void aLG() {
        this.fFB.setVisibility(0);
    }

    public void aLF() {
        this.fFB.setVisibility(8);
    }

    public View bdZ() {
        if (this.fFI != null) {
            return this.fFI.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bea() {
        return this.fFN;
    }

    public View getView() {
        return this.cSA;
    }

    public void beb() {
        com.baidu.adp.lib.util.l.a(this.fxt.getPageContext().getPageActivity(), this.fxt.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fxt.hideProgressBar();
        if (z) {
            beq();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            ber();
        } else {
            beq();
        }
    }

    public void bec() {
        this.drC.At();
        this.drC.Ax();
    }

    public void bed() {
        this.fxt.hideProgressBar();
        Ay();
        this.fEO.completePullRefreshPostDelayed(2000L);
        ben();
    }

    public void bee() {
        this.fEO.completePullRefreshPostDelayed(2000L);
        ben();
    }

    private void kk(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fFW.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fxt.getResources().getDimensionPixelSize(d.e.ds130) : this.fxt.getResources().getDimensionPixelSize(d.e.ds34);
        this.fFW.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fFv.setOnLongClickListener(onLongClickListener);
        if (this.fGT != null) {
            this.fGT.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0101b interfaceC0101b, boolean z, boolean z2) {
        if (this.fFO != null) {
            this.fFO.dismiss();
            this.fFO = null;
        }
        this.fFO = new com.baidu.tbadk.core.dialog.b(this.fxt.getPageContext().getPageActivity());
        this.fFO.ci(d.j.operation);
        if (z2) {
            this.fFO.a(new String[]{this.fxt.getPageContext().getString(d.j.copy)}, interfaceC0101b);
        } else if (!z) {
            this.fFO.a(new String[]{this.fxt.getPageContext().getString(d.j.copy), this.fxt.getPageContext().getString(d.j.mark)}, interfaceC0101b);
        } else {
            this.fFO.a(new String[]{this.fxt.getPageContext().getString(d.j.copy), this.fxt.getPageContext().getString(d.j.remove_mark)}, interfaceC0101b);
        }
        this.fFO.d(this.fxt.getPageContext());
        this.fFO.xi();
    }

    public void a(b.InterfaceC0101b interfaceC0101b, boolean z) {
        if (this.fFP != null) {
            this.fFP.dismiss();
            this.fFP = null;
        }
        this.fFP = new com.baidu.tbadk.core.dialog.b(this.fxt.getPageContext().getPageActivity());
        this.fFP.ci(d.j.operation);
        if (z) {
            this.fFP.a(new String[]{this.fxt.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0101b);
        } else {
            this.fFP.a(new String[]{this.fxt.getPageContext().getString(d.j.save_to_emotion), this.fxt.getPageContext().getString(d.j.save_to_local)}, interfaceC0101b);
        }
        this.fFP.d(this.fxt.getPageContext());
        this.fFP.xi();
    }

    public int bef() {
        return qN(this.fEO.getFirstVisiblePosition());
    }

    private int qN(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fEO.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fEO.getAdapter() == null || !(this.fEO.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fEO.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int beg() {
        int lastVisiblePosition = this.fEO.getLastVisiblePosition();
        if (this.fEE != null) {
            if (lastVisiblePosition == this.fEO.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return qN(lastVisiblePosition);
    }

    public void qO(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fEO != null) {
            if (this.fEK == null || this.fEK.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fEK.mNavigationBar.getFixedNavHeight();
                if (this.fxt.baV() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fGo != null && (layoutParams = (LinearLayout.LayoutParams) this.fGo.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fGo.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fEO.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fEO.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fFy.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fFv.a(dVar, false);
        this.fFv.notifyDataSetChanged();
        ben();
        if (this.fGT != null) {
            this.fGT.bap();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fFe == null) {
            this.fxt.getLayoutMode().onModeChanged(((ViewStub) this.fEP.findViewById(d.g.praise_layout)).inflate());
            this.fFe = (FrsPraiseView) this.fEP.findViewById(d.g.pb_head_praise_view);
            this.fFe.setIsFromPb(true);
            this.fFt = this.fEP.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fFe.dG(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fFe != null) {
            boolean ben = ben();
            this.fFe.setVisibility(8);
            if (dVar != null && dVar.uw() != null && dVar.uw().ut() == 0 && this.fxK) {
                if (ben) {
                    this.fFs.setVisibility(0);
                    return;
                } else {
                    this.fFs.setVisibility(8);
                    return;
                }
            }
            this.fFs.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.aZx() != null) {
            return dVar.aZx();
        }
        if (!com.baidu.tbadk.core.util.w.z(dVar.aZp())) {
            Iterator<PostData> it = dVar.aZp().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bwf() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.aZu();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.vk() != null && postData.vk().getUserTbVipInfoData() != null && postData.vk().getUserTbVipInfoData().getvipIntro() != null) {
            postData.vk().getGodUserData().setIntro(postData.vk().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.aZn() == null || dVar.aZn().vk() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData vk = dVar.aZn().vk();
        String userId = vk.getUserId();
        HashMap<String, MetaData> userMap = dVar.aZn().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = vk;
        }
        postData.tJ(1);
        postData.setId(dVar.aZn().vB());
        postData.setTitle(dVar.aZn().getTitle());
        postData.setTime(dVar.aZn().getCreateTime());
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
        int f;
        com.baidu.tbadk.data.f bwi;
        String portrait;
        if (dVar != null && dVar.aZn() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fEU.setVisibility(8);
            if (dVar.aZn() != null && dVar.aZn().vW() && dVar.aZn().vC() != null) {
                this.fGI = true;
                this.fEK.kG(this.fGI);
                this.fEK.mNavigationBar.hideBottomLine();
                if (this.fEE == null) {
                    this.fEE = new com.baidu.tieba.pb.video.i(this.fxt, this.fEK, dVar.aZn().vC(), this.fEF);
                    this.fEE.a(dVar.aZn().vC(), dVar.aZn(), dVar.getForumId());
                    this.fEE.startPlay();
                } else if (this.fEI) {
                    this.fEE.a(dVar.aZn().vC(), dVar.aZn(), dVar.getForumId());
                    this.fEE.startPlay();
                } else {
                    this.fEE.rF(dVar.getForumId());
                }
                if (dVar.aZo() != null && dVar.aZo().size() >= 1) {
                    bb bbVar = dVar.aZo().get(0);
                    this.fEE.ar(bbVar);
                    this.fEE.rG(bbVar.getTitle());
                }
                this.fEE.b(b, dVar.aZn(), dVar.aZL());
                this.fEI = false;
                this.fEO.removeHeaderView(this.fEE.bgx());
                this.fEO.addHeaderView(this.fEE.bgx(), 0);
                if (this.fEE.bgv() != null && this.fEE.bgv().getParent() == null) {
                    this.fGm.addView(this.fEE.bgv());
                }
                if (this.fEG == null) {
                    this.fEG = new com.baidu.tieba.pb.video.h(this.fxt);
                }
                this.fEG.a(dVar.aZn().wl(), dVar.aZn(), dVar.aZI());
                this.fEO.removeHeaderView(this.fEG.bgm());
                this.fEO.addHeaderView(this.fEG.bgm(), 1);
                if (dVar.aZn().wl() != null) {
                    this.fEO.removeHeaderView(this.fEG.bgn());
                    this.fEO.removeHeaderView(this.fES);
                    this.fEO.addHeaderView(this.fEG.bgn(), 2);
                } else {
                    if (this.fEG.bgn() != null) {
                        this.fEO.removeHeaderView(this.fEG.bgn());
                    }
                    this.fEO.removeHeaderView(this.fES);
                    this.fES.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.fxt, d.e.tbds56));
                    this.fEO.addHeaderView(this.fES, 2);
                }
                if (this.fEE != null) {
                    this.fEK.kA(false);
                    this.fEK.kC(TbadkCoreApplication.isLogin());
                    this.fEE.qV(TbadkCoreApplication.getInst().getSkinType());
                }
                bek();
            } else {
                this.fGI = false;
                this.fEK.kG(this.fGI);
                if (this.fEE != null) {
                    this.fEO.removeHeaderView(this.fEE.bgx());
                }
                if (this.fEG != null) {
                    this.fEG.b(this.fEO);
                }
                if (b == null || (b != null && (b.bwh() == null || com.baidu.tbadk.core.util.w.z(b.bwh().Nx())))) {
                    this.fES.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.fxt, d.e.tbds80));
                } else {
                    this.fES.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fxt.baJ() != null) {
                this.fxt.baJ().ky(this.fGI);
            }
            if (this.fEE != null) {
                this.fEE.L(this.fHj);
            }
            if (b != null) {
                this.fGe = b;
                this.fEU.setVisibility(0);
                if (this.fxt.bbu()) {
                    if (dVar.aZm() != null) {
                        this.mForumName = dVar.aZm().getForumName();
                        this.mForumId = dVar.aZm().getForumId();
                    }
                    if (this.mForumName == null && this.fxt.bat() != null && this.fxt.bat().bch() != null) {
                        this.mForumName = this.fxt.bat().bch();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fEU.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fEU.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fGY) {
                    this.fEQ.setVisibility(0);
                }
                if (!dVar.aZn().vW() && this.fER.getText() != null && this.fER.getText().length() > 0) {
                    this.fER.setVisibility(0);
                } else {
                    this.fER.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> vw = dVar.aZn().vw();
                if (vw != null && vw.size() > 0 && !this.fGY) {
                    this.fGh.setText(String.valueOf(vw.get(0).tD()));
                    this.fGg.setVisibility(0);
                } else {
                    this.fGg.setVisibility(8);
                }
                com.baidu.tbadk.core.util.am.i(this.fGg, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.am.c(this.fGh, d.C0140d.cp_link_tip_d, 1);
                if (b.vk() != null) {
                    String string = b.vk().getName_show() == null ? StringUtils.string(b.vk().getUserName()) : StringUtils.string(b.vk().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.vk().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bj(b.vk().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bj(string) > 12) {
                            e = com.baidu.tbadk.core.util.ap.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.vk().getIconInfo();
                            tShowInfoNew = b.vk().getTShowInfoNew();
                            if (this.fyJ != null) {
                                this.fyJ.setTag(d.g.tag_user_id, b.vk().getUserId());
                                this.fyJ.setOnClickListener(this.fxt.fvw.fIW);
                                this.fyJ.a(iconInfo, 4, this.fxt.getResources().getDimensionPixelSize(d.e.tbds36), this.fxt.getResources().getDimensionPixelSize(d.e.tbds36), this.fxt.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fyI != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fyI.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fyI.setOnClickListener(this.fxt.fvw.fIX);
                                this.fyI.a(tShowInfoNew, 3, this.fxt.getResources().getDimensionPixelSize(d.e.tbds36), this.fxt.getResources().getDimensionPixelSize(d.e.tbds36), this.fxt.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fEW.setText(ai(b.vk().getSealPrefix(), e));
                            this.fEW.setTag(d.g.tag_user_id, b.vk().getUserId());
                            this.fEW.setTag(d.g.tag_user_name, b.vk().getName_show());
                            if (com.baidu.tbadk.core.util.w.z(tShowInfoNew) || b.vk().isBigV()) {
                                com.baidu.tbadk.core.util.am.c(this.fEW, d.C0140d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.am.c(this.fEW, d.C0140d.cp_cont_f, 1);
                            }
                            this.fEX.setVisibility(8);
                            if (dVar.aZn().vk() != null && dVar.aZn().vk().getAlaUserData() != null && this.fFc != null) {
                                if (dVar.aZn().vk().getAlaUserData().anchor_live != 0) {
                                    this.fFc.setVisibility(8);
                                } else {
                                    this.fFc.setVisibility(0);
                                    if (this.fEH == null) {
                                        this.fEH = new com.baidu.tieba.c.d(this.fxt.getPageContext(), this.fFc);
                                        this.fEH.jr(1);
                                    }
                                    this.fEH.aO(this.fxt.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.ZR = dVar.aZn().vk().getAlaUserData();
                                    aVar.type = 2;
                                    this.fFc.setTag(aVar);
                                }
                            }
                            this.fFb.setUserId(b.vk().getUserId());
                            this.fFb.setUserName(b.vk().getUserName());
                            this.fFb.setImageDrawable(null);
                            this.fFb.setRadius(com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds40));
                            this.fFb.setTag(b.vk().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fFk.setText(com.baidu.tbadk.core.util.ap.y(b.getTime()));
                            } else {
                                this.fFk.setText(com.baidu.tbadk.core.util.ap.w(b.getTime()));
                            }
                            f = com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds16);
                            if (!this.fxt.bbu() && !StringUtils.isNull(this.mForumName)) {
                                this.ayq.setText(this.fxt.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.ayq.setVisibility(0);
                                this.fFn.setVisibility(0);
                                this.fFk.setPadding(f, 0, f, 0);
                            } else {
                                this.ayq.setVisibility(8);
                                this.fFn.setVisibility(8);
                                this.fFk.setPadding(0, 0, f, 0);
                            }
                            bwi = b.bwi();
                            if (bwi == null && !TextUtils.isEmpty(bwi.getName()) && !TextUtils.isEmpty(bwi.getName().trim())) {
                                final String name = bwi.getName();
                                final String lat = bwi.getLat();
                                final String lng = bwi.getLng();
                                this.fFl.setVisibility(0);
                                this.fFm.setVisibility(0);
                                this.fFl.setText(bwi.getName());
                                this.fFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.jE()) {
                                                at.this.fxt.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.Q(at.this.fxt.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, at.this.fxt.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fFl.setVisibility(8);
                                this.fFm.setVisibility(8);
                            }
                            portrait = b.vk().getPortrait();
                            if (b.vk().getPendantData() == null && !StringUtils.isNull(b.vk().getPendantData().tU())) {
                                UtilHelper.showHeadImageViewBigV(this.fEZ.getHeadView(), b.vk());
                                this.fFb.setVisibility(8);
                                this.fEZ.setVisibility(0);
                                if (this.fFf != null) {
                                    this.fFf.setVisibility(8);
                                }
                                this.fEW.setOnClickListener(this.fHj);
                                this.fEZ.getHeadView().startLoad(portrait, 28, false);
                                this.fEZ.getHeadView().setUserId(b.vk().getUserId());
                                this.fEZ.getHeadView().setUserName(b.vk().getUserName());
                                this.fEZ.getHeadView().setOnClickListener(this.fHj);
                                this.fEZ.fl(b.vk().getPendantData().tU());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fFb, b.vk());
                                this.fFb.setVisibility(0);
                                this.fEU.setOnClickListener(this.fHj);
                                this.fEW.setOnClickListener(this.fHj);
                                this.fFb.setOnClickListener(this.fHj);
                                this.fEZ.setVisibility(8);
                                this.fFb.startLoad(portrait, 28, false);
                            }
                            String name_show = b.vk().getName_show();
                            String userName = b.vk().getUserName();
                            if (com.baidu.tbadk.p.aj.iq() && name_show != null && !name_show.equals(userName)) {
                                this.fEW.setText(com.baidu.tieba.pb.c.al(this.fxt.getPageContext().getPageActivity(), this.fEW.getText().toString()));
                                this.fEW.setGravity(16);
                                this.fEW.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYV());
                                com.baidu.tbadk.core.util.am.c(this.fEW, d.C0140d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.vk().getIconInfo();
                        tShowInfoNew = b.vk().getTShowInfoNew();
                        if (this.fyJ != null) {
                        }
                        if (this.fyI != null) {
                        }
                        this.fEW.setText(ai(b.vk().getSealPrefix(), e));
                        this.fEW.setTag(d.g.tag_user_id, b.vk().getUserId());
                        this.fEW.setTag(d.g.tag_user_name, b.vk().getName_show());
                        if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.c(this.fEW, d.C0140d.cp_cont_h, 1);
                        this.fEX.setVisibility(8);
                        if (dVar.aZn().vk() != null) {
                            if (dVar.aZn().vk().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fFb.setUserId(b.vk().getUserId());
                        this.fFb.setUserName(b.vk().getUserName());
                        this.fFb.setImageDrawable(null);
                        this.fFb.setRadius(com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds40));
                        this.fFb.setTag(b.vk().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds16);
                        if (!this.fxt.bbu()) {
                        }
                        this.ayq.setVisibility(8);
                        this.fFn.setVisibility(8);
                        this.fFk.setPadding(0, 0, f, 0);
                        bwi = b.bwi();
                        if (bwi == null) {
                        }
                        this.fFl.setVisibility(8);
                        this.fFm.setVisibility(8);
                        portrait = b.vk().getPortrait();
                        if (b.vk().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fFb, b.vk());
                        this.fFb.setVisibility(0);
                        this.fEU.setOnClickListener(this.fHj);
                        this.fEW.setOnClickListener(this.fHj);
                        this.fFb.setOnClickListener(this.fHj);
                        this.fEZ.setVisibility(8);
                        this.fFb.startLoad(portrait, 28, false);
                        String name_show2 = b.vk().getName_show();
                        String userName2 = b.vk().getUserName();
                        if (com.baidu.tbadk.p.aj.iq()) {
                            this.fEW.setText(com.baidu.tieba.pb.c.al(this.fxt.getPageContext().getPageActivity(), this.fEW.getText().toString()));
                            this.fEW.setGravity(16);
                            this.fEW.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYV());
                            com.baidu.tbadk.core.util.am.c(this.fEW, d.C0140d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bj(string) > 14) {
                            e = com.baidu.tbadk.core.util.ap.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.vk().getIconInfo();
                            tShowInfoNew = b.vk().getTShowInfoNew();
                            if (this.fyJ != null) {
                            }
                            if (this.fyI != null) {
                            }
                            this.fEW.setText(ai(b.vk().getSealPrefix(), e));
                            this.fEW.setTag(d.g.tag_user_id, b.vk().getUserId());
                            this.fEW.setTag(d.g.tag_user_name, b.vk().getName_show());
                            if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.am.c(this.fEW, d.C0140d.cp_cont_h, 1);
                            this.fEX.setVisibility(8);
                            if (dVar.aZn().vk() != null) {
                            }
                            this.fFb.setUserId(b.vk().getUserId());
                            this.fFb.setUserName(b.vk().getUserName());
                            this.fFb.setImageDrawable(null);
                            this.fFb.setRadius(com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds40));
                            this.fFb.setTag(b.vk().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            f = com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds16);
                            if (!this.fxt.bbu()) {
                            }
                            this.ayq.setVisibility(8);
                            this.fFn.setVisibility(8);
                            this.fFk.setPadding(0, 0, f, 0);
                            bwi = b.bwi();
                            if (bwi == null) {
                            }
                            this.fFl.setVisibility(8);
                            this.fFm.setVisibility(8);
                            portrait = b.vk().getPortrait();
                            if (b.vk().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fFb, b.vk());
                            this.fFb.setVisibility(0);
                            this.fEU.setOnClickListener(this.fHj);
                            this.fEW.setOnClickListener(this.fHj);
                            this.fFb.setOnClickListener(this.fHj);
                            this.fEZ.setVisibility(8);
                            this.fFb.startLoad(portrait, 28, false);
                            String name_show22 = b.vk().getName_show();
                            String userName22 = b.vk().getUserName();
                            if (com.baidu.tbadk.p.aj.iq()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.vk().getIconInfo();
                        tShowInfoNew = b.vk().getTShowInfoNew();
                        if (this.fyJ != null) {
                        }
                        if (this.fyI != null) {
                        }
                        this.fEW.setText(ai(b.vk().getSealPrefix(), e));
                        this.fEW.setTag(d.g.tag_user_id, b.vk().getUserId());
                        this.fEW.setTag(d.g.tag_user_name, b.vk().getName_show());
                        if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.c(this.fEW, d.C0140d.cp_cont_h, 1);
                        this.fEX.setVisibility(8);
                        if (dVar.aZn().vk() != null) {
                        }
                        this.fFb.setUserId(b.vk().getUserId());
                        this.fFb.setUserName(b.vk().getUserName());
                        this.fFb.setImageDrawable(null);
                        this.fFb.setRadius(com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds40));
                        this.fFb.setTag(b.vk().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.fxt.getActivity(), d.e.ds16);
                        if (!this.fxt.bbu()) {
                        }
                        this.ayq.setVisibility(8);
                        this.fFn.setVisibility(8);
                        this.fFk.setPadding(0, 0, f, 0);
                        bwi = b.bwi();
                        if (bwi == null) {
                        }
                        this.fFl.setVisibility(8);
                        this.fFm.setVisibility(8);
                        portrait = b.vk().getPortrait();
                        if (b.vk().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fFb, b.vk());
                        this.fFb.setVisibility(0);
                        this.fEU.setOnClickListener(this.fHj);
                        this.fEW.setOnClickListener(this.fHj);
                        this.fFb.setOnClickListener(this.fHj);
                        this.fEZ.setVisibility(8);
                        this.fFb.startLoad(portrait, 28, false);
                        String name_show222 = b.vk().getName_show();
                        String userName222 = b.vk().getUserName();
                        if (com.baidu.tbadk.p.aj.iq()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fET.aj(dVar.aZn());
                }
                if (this.fGp != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fth);
                    if (dVar != null && dVar.aZn() != null) {
                        hVar.ftj = dVar.aZn().vb();
                    }
                    hVar.isNew = !this.fxK;
                    hVar.ftl = this.fxt.bbt();
                    this.fGp.a(hVar);
                }
            }
        }
    }

    public void kl(boolean z) {
        if (z) {
            beh();
        } else {
            aoX();
        }
        this.fGt.fHC = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGt));
        a(this.fGt.fHC, false);
    }

    public void beh() {
        if (this.fEK != null && !this.fGK) {
            this.fEK.kH(!StringUtils.isNull(this.fxt.baS()));
            this.fGK = true;
        }
    }

    public void aoX() {
        if (this.fEK != null) {
            this.fEK.bfm();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.vF() != null) {
            this.fEV.setData(this.fxt.getPageContext(), dVar.aZp().get(0).vF(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.aZl().getId(), dVar.aZl().getName(), dVar.aZn().getId(), this.fxt.bbq() ? "FRS" : null));
            this.fEU.setPadding(this.fEU.getPaddingLeft(), (int) this.fxt.getResources().getDimension(d.e.ds20), this.fEU.getPaddingRight(), this.fEU.getPaddingBottom());
            return;
        }
        this.fEV.setData(null, null, null);
    }

    public void bei() {
        if (this.fEE != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11997").r("obj_type", 1));
            this.fEE.bgw();
            this.fEO.smoothScrollToPosition(0);
        }
    }

    public boolean bej() {
        return this.fHk;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean al(bb bbVar) {
        if (bbVar == null || bbVar.vk() == null || bbVar.vk().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.vk().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fEK.bfk();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fEK.pi(cVar.forumName);
            }
            String string = this.fxt.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(cVar.source, 0)) {
                case 100:
                    str = this.fxt.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.fxt.getResources().getString(d.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fxt.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fss;
            this.fxt.showNetRefreshView(this.cSA, format, null, this.fxt.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.jV()) {
                        com.baidu.tbadk.core.util.ay.zK().c(at.this.fxt.getPageContext(), new String[]{str2});
                        at.this.fxt.finish();
                        return;
                    }
                    at.this.fxt.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bdr;
        Parcelable bdr2;
        String str;
        if (dVar != null) {
            this.fBa = dVar;
            this.mType = i;
            if (dVar.aZn() != null) {
                this.fGv = dVar.aZn().uT();
                if (dVar.aZn().getAnchorLevel() != 0) {
                    this.fHk = true;
                }
                this.fFR = al(dVar.aZn());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fGf = false;
            this.fxK = z;
            bed();
            b(dVar, z, i);
            p(dVar);
            if (this.fGW == null) {
                this.fGW = new ac(this.fxt.getPageContext(), this.dHq);
            }
            this.fGW.rl(dVar.aZs());
            if (this.fxt.bbh()) {
                if (this.fFz == null) {
                    this.fFz = new com.baidu.tieba.pb.view.e(this.fxt.getPageContext());
                    this.fFz.np();
                    this.fFz.a(this.aww);
                }
                this.fEO.setPullRefresh(this.fFz);
                bek();
                if (this.fFz != null) {
                    this.fFz.dC(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.uw().ut() == 0 && z) {
                this.fEO.setPullRefresh(null);
            } else {
                if (this.fFz == null) {
                    this.fFz = new com.baidu.tieba.pb.view.e(this.fxt.getPageContext());
                    this.fFz.np();
                    this.fFz.a(this.aww);
                }
                this.fEO.setPullRefresh(this.fFz);
                bek();
                if (this.fFz != null) {
                    this.fFz.dC(TbadkCoreApplication.getInst().getSkinType());
                }
                aeP();
            }
            ben();
            this.fFv.ju(this.fxK);
            this.fFv.jv(false);
            this.fFv.jG(i == 5);
            this.fFv.jH(i == 6);
            this.fFv.jI(z2 && this.fHi);
            this.fFv.a(dVar, false);
            this.fFv.notifyDataSetChanged();
            if (this.fxt.bbu()) {
                this.fGM = 0;
                PostData b = b(dVar, z);
                if (b != null && b.vk() != null) {
                    this.fGM = b.vk().getLevel_id();
                }
                if (this.fGM > 0) {
                    this.fEY.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(this.fEY, BitmapHelper.getGradeResourceIdInEnterForum(this.fGM));
                } else {
                    this.fEY.setVisibility(8);
                }
            } else {
                this.fEY.setVisibility(8);
            }
            if (dVar.aZn() != null) {
                if (dVar.aZn().uX() != null) {
                    if (dVar.aZn().uX().getNum() < 1) {
                        str = this.fxt.getResources().getString(d.j.zan);
                    } else {
                        str = dVar.aZn().uX().getNum() + "";
                    }
                    if (this.fED != -1) {
                        dVar.aZn().uX().setIsLike(this.fED);
                    }
                    M(str, dVar.aZn().uX().getIsLike() == 1);
                }
                if (dVar.aZn().ajH != null && dVar.aZn().ajH.isDeleted) {
                    this.fEK.kB(true);
                } else {
                    this.fEK.kB(false);
                }
            }
            if (this.fxt.isLogin()) {
                this.fEO.setNextPage(this.drC);
                this.fEJ = 2;
                aeP();
            } else {
                this.fGf = true;
                if (dVar.uw().us() == 1) {
                    if (this.fFA == null) {
                        this.fFA = new com.baidu.tieba.pb.view.a(this.fxt.getPageContext());
                    }
                    this.fEO.setNextPage(this.fFA);
                } else {
                    this.fEO.setNextPage(this.drC);
                }
                this.fEJ = 3;
            }
            ArrayList<PostData> aZp = dVar.aZp();
            if (dVar.uw().us() == 0 || aZp == null || aZp.size() < dVar.uw().ur()) {
                if (com.baidu.tbadk.core.util.w.y(aZp) == 0 || (com.baidu.tbadk.core.util.w.y(aZp) == 1 && aZp.get(0) != null && aZp.get(0).bwf() == 1)) {
                    this.drC.setText(this.fxt.getResources().getString(d.j.list_no_more_new));
                    if (this.fxt.baJ() != null && !this.fxt.baJ().bfa()) {
                        this.fxt.baJ().showFloatingView();
                    }
                } else if (dVar.uw().us() == 0) {
                    this.drC.setText(this.fxt.getResources().getString(d.j.list_has_no_more));
                } else {
                    this.drC.setText(this.fxt.getResources().getString(d.j.load_more));
                }
                if (this.fxt.bbh() && this.fEO != null && this.fEO.getData() != null && this.fEO.getData().size() == 1 && (this.fEO.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.drC.setText("");
                }
                beu();
            } else if (z2) {
                if (this.fHi) {
                    Ay();
                    if (dVar.uw().us() != 0) {
                        this.drC.setText(this.fxt.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.drC.At();
                    this.drC.showLoading();
                }
            } else {
                this.drC.At();
                this.drC.showLoading();
            }
            switch (i) {
                case 2:
                    this.fEO.setSelection(i2 > 1 ? (((this.fEO.getData() == null && dVar.aZp() == null) ? 0 : (this.fEO.getData().size() - dVar.aZp().size()) + this.fEO.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bdr2 = aj.bdq().bdr()) != null) {
                        this.fEO.onRestoreInstanceState(bdr2);
                        if (com.baidu.tbadk.core.util.w.y(aZp) > 1 && dVar.uw().us() > 0) {
                            this.drC.Ay();
                            this.drC.setText(this.fxt.getString(d.j.pb_load_more_without_point));
                            this.drC.Au();
                            break;
                        }
                    } else {
                        this.fEO.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fHi = false;
                    break;
                case 5:
                    this.fEO.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bdr = aj.bdq().bdr()) != null) {
                        this.fEO.onRestoreInstanceState(bdr);
                        break;
                    } else {
                        this.fEO.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.fEE != null && this.fEE.bgv() != null) {
                            if (this.fxt.isUseStyleImmersiveSticky()) {
                                this.fEO.setSelectionFromTop((this.fFv.bbM() + this.fEO.getHeaderViewsCount()) - 1, this.fEE.bgv().getHeight() - com.baidu.adp.lib.util.l.o(this.fxt.getPageContext().getPageActivity()));
                            } else {
                                this.fEO.setSelectionFromTop((this.fFv.bbM() + this.fEO.getHeaderViewsCount()) - 1, this.fEE.bgv().getHeight());
                            }
                        } else {
                            this.fEO.setSelection(this.fFv.bbM() + this.fEO.getHeaderViewsCount());
                        }
                    } else {
                        this.fEO.setSelection(i2 > 0 ? ((this.fEO.getData() == null && dVar.aZp() == null) ? 0 : (this.fEO.getData().size() - dVar.aZp().size()) + this.fEO.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.drC.Ay();
                    this.drC.setText(this.fxt.getString(d.j.pb_load_more_without_point));
                    this.drC.Au();
                    break;
            }
            if (this.fGv == fGw && isHost()) {
                beC();
            }
            if (this.fGG) {
                bdC();
                this.fGG = false;
                if (i3 == 0) {
                    ke(true);
                }
            }
            if (this.fEG != null) {
                this.fEG.aq(dVar.aZn());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fsY == 1 || dVar.fsZ == 1) {
                if (this.fGN == null) {
                    this.fGN = new PbTopTipView(this.fxt);
                }
                if (dVar.fsZ == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fxt.getStType())) {
                    this.fGN.setText(this.fxt.getString(d.j.pb_read_strategy_add_experience));
                    this.fGN.show(this.cSA, this.mSkinType);
                } else if (dVar.fsY == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fxt.getStType())) {
                    this.fGN.setText(this.fxt.getString(d.j.pb_read_news_add_experience));
                    this.fGN.show(this.cSA, this.mSkinType);
                }
            }
        }
    }

    private void bek() {
        if (this.fEE != null && this.fEE.bgv() != null) {
            this.fEO.removeHeaderView(this.aIt);
            if (this.mType != 1) {
                this.fEO.removeHeaderView(this.fEE.bgx());
                this.fEO.addHeaderView(this.fEE.bgx(), 0);
                return;
            }
            return;
        }
        if (this.fEE != null) {
            this.fEO.removeHeaderView(this.fEE.bgx());
        }
        this.fEO.removeHeaderView(this.aIt);
        this.fEO.addHeaderView(this.aIt, 0);
    }

    public void km(boolean z) {
        this.fFQ = z;
    }

    public void Ay() {
        if (this.drC != null) {
            this.drC.Au();
            this.drC.Ay();
        }
        aeP();
    }

    public void agN() {
        this.fEO.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fGe != null && this.fGe.vk() != null && this.fEK != null) {
            this.fGJ = !this.fGI;
            this.fEK.kA(this.fGJ);
            if (this.fxt.baJ() != null) {
                this.fxt.baJ().kz(this.fGJ);
            }
            bel();
            if (this.fGJ) {
                this.fEK.fJK.setVisibility(0);
                if (this.fFR) {
                    this.fEK.fJL.setVisibility(8);
                    this.fFg.setVisibility(8);
                    this.fFj.setVisibility(0);
                    this.fFj.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.D(dVar.aZK())));
                } else if (!PbNormalLikeButtonSwitchStatic.KX() || (this.fGe.vk().hadConcerned() && this.fGe.vk().getGodUserData() != null && this.fGe.vk().getGodUserData().getIsFromNetWork())) {
                    this.fEK.fJL.setVisibility(8);
                }
                if (this.fGo != null) {
                    this.fGo.setVisibility(8);
                }
                this.fEK.a(this.fGe.vk(), this.fHj);
                if (this.fGU == null) {
                    this.fGU = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.at.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > at.this.fGL) {
                                at.this.beB();
                            }
                        }
                    };
                }
                this.fEO.setListViewDragListener(this.fGU);
                return;
            }
            if (this.fEK.fJK != null) {
                this.fEK.fJK.setVisibility(8);
            }
            if (this.fGo != null) {
                this.fGo.setVisibility(0);
            }
            if (this.fFR) {
                this.fFg.setVisibility(8);
                this.fFj.setVisibility(0);
                this.fFj.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.ap.D(dVar.aZK())));
            } else if (!PbNormalLikeButtonSwitchStatic.KX() || (this.fGe.vk().hadConcerned() && this.fGe.vk().getGodUserData() != null && this.fGe.vk().getGodUserData().getIsFromNetWork())) {
                this.fFg.setVisibility(8);
                this.fFj.setVisibility(8);
            } else {
                this.fFj.setVisibility(8);
            }
            this.fGU = null;
            this.fEO.setListViewDragListener(null);
        }
    }

    private void bel() {
        String threadId = this.fBa != null ? this.fBa.getThreadId() : "";
        int bem = bem();
        if (this.fGJ) {
            if (this.fFi == null) {
                this.fFi = new ar(this.fxt.getPageContext(), this.fEK.fJL, 3);
                this.fFi.h(this.fxt.getUniqueId());
            }
            if (this.fGe != null && this.fGe.vk() != null) {
                this.fGe.vk().setIsLike(this.fGe.vk().hadConcerned());
                this.fFi.a(this.fGe.vk());
            }
            this.fFi.dh(threadId);
            this.fFi.qM(bem);
            this.fFi.fEz = this.fGI;
        }
        if (this.fFh == null) {
            this.fFh = new ar(this.fxt.getPageContext(), this.fFg, 1);
            this.fFh.h(this.fxt.getUniqueId());
            this.fFh.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.at.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aW(boolean z) {
                    if (at.this.fxt != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(at.this.fxt, d.j.attention_success);
                            return;
                        }
                        as.v(at.this.fxt.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fGe != null && this.fGe.vk() != null) {
            this.fGe.vk().setIsLike(this.fGe.vk().hadConcerned());
            this.fFh.a(this.fGe.vk());
            this.fFh.dh(threadId);
        }
        this.fFh.fEz = this.fGI;
        this.fFh.qM(bem);
    }

    public int bem() {
        if (this.fBa == null || this.fBa.aZn() == null) {
            return 0;
        }
        if (this.fBa.aZn().wt()) {
            return (com.baidu.tbadk.core.util.w.z(this.fBa.aZJ()) && (this.fBa.aZm() == null || StringUtils.isNull(this.fBa.aZm().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean ben() {
        boolean z;
        if (this.fFU != null && this.fFU.getVisibility() == 0) {
            if (this.fFr != null) {
                this.fFr.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fFr != null) {
                this.fFr.setVisibility(8);
            }
            z = false;
        }
        if ((this.fFt == null || this.fFt.getVisibility() == 8) && z && this.fxK) {
            this.fFs.setVisibility(0);
        } else {
            this.fFs.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.aZn() == null) {
            return false;
        }
        if (dVar.aZn().vh() == 1 || dVar.aZn().getThreadType() == 33) {
            return true;
        }
        return !(dVar.aZn().vj() == null || dVar.aZn().vj().wT() == 0) || dVar.aZn().vf() == 1 || dVar.aZn().vg() == 1 || dVar.aZn().vO() || dVar.aZn().wa() || dVar.aZn().vV() || dVar.aZn().vx() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.aZn().getCategory()) || dVar.aZn().vn() || dVar.aZn().vm();
    }

    private SpannableStringBuilder ai(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fxt.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fEQ != null) {
                if (dVar.aZn() != null && dVar.aZn().vA() == 0 && !dVar.aZn().vW() && !this.fGY) {
                    this.fEQ.setVisibility(0);
                    if (dVar.aZn() != null) {
                        bb aZn = dVar.aZn();
                        aZn.e(true, q(dVar));
                        aZn.setResource(3);
                        aZn.dl("2");
                    }
                    SpannableStringBuilder vJ = dVar.aZn().vJ();
                    this.fER.setOnTouchListener(new com.baidu.tieba.view.k(vJ));
                    this.fER.setText(vJ);
                    this.fER.setVisibility(0);
                } else if (dVar.aZn().vA() == 1) {
                    if (dVar.aZn() != null) {
                        this.fEQ.setVisibility(8);
                        this.fEO.removeHeaderView(this.fEQ);
                        if (dVar.aZn() != null && !dVar.aZn().vW()) {
                            this.fEU.setPadding(this.fEU.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.tbds36), this.fEU.getPaddingRight(), this.fEU.getPaddingBottom());
                        }
                    }
                } else {
                    this.fEQ.setVisibility(8);
                    this.fEO.removeHeaderView(this.fEQ);
                    if (dVar.aZn() != null && dVar.aZn().vW()) {
                        this.fEU.setPadding(this.fEU.getPaddingLeft(), 0, this.fEU.getPaddingRight(), this.fEU.getPaddingBottom());
                    } else {
                        this.fEU.setPadding(this.fEU.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds48), this.fEU.getPaddingRight(), this.fEU.getPaddingBottom());
                    }
                }
            }
            this.fxK = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            ben();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.vk().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.aZz()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.vk() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.vk().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_name_show, b.vk().getName_show());
                    sparseArray.put(d.g.tag_forbid_user_portrait, b.vk().getPortrait());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.aZz()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.ay> aZJ = dVar.aZJ();
                if (com.baidu.tbadk.core.util.w.y(aZJ) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.ay ayVar : aZJ) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ahr) != null && tVar.afp && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.j(ayVar.getForumName(), 12)).append(this.fxt.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fxt.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.aTf;
    }

    public void rm(String str) {
        if (this.drC != null) {
            this.drC.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fEO;
    }

    public int beo() {
        return d.g.richText;
    }

    public TextView baE() {
        return this.fET.baE();
    }

    public void e(BdListView.e eVar) {
        this.fEO.setOnSrollToBottomListener(eVar);
    }

    public void a(g.b bVar) {
        this.aww = bVar;
        if (this.fFz != null) {
            this.fFz.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int uq = alVar.uq();
            int un = alVar.un();
            if (this.fFw != null) {
                this.fFw.xf();
            } else {
                this.fFw = new com.baidu.tbadk.core.dialog.a(this.fxt.getPageContext().getPageActivity());
                this.fFx = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fFw.w(this.fFx);
                this.fFw.a(d.j.dialog_ok, bVar);
                this.fFw.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        at.this.beq();
                        aVar.dismiss();
                    }
                });
                this.fFw.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.at.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (at.this.fGD == null) {
                            at.this.fGD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    at.this.fxt.HidenSoftKeyPad((InputMethodManager) at.this.fxt.getSystemService("input_method"), at.this.cSA);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.in().postDelayed(at.this.fGD, 150L);
                    }
                });
                this.fFw.b(this.fxt.getPageContext()).xf();
            }
            this.fFy = (EditText) this.fFx.findViewById(d.g.input_page_number);
            this.fFy.setText("");
            TextView textView = (TextView) this.fFx.findViewById(d.g.current_page_number);
            if (uq <= 0) {
                uq = 1;
            }
            if (un <= 0) {
                un = 1;
            }
            textView.setText(MessageFormat.format(this.fxt.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(uq), Integer.valueOf(un)));
            this.fxt.ShowSoftKeyPadDelay(this.fFy, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fEO.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fxt.showToast(str);
    }

    public boolean kn(boolean z) {
        if (this.Qg == null || !this.Qg.Hw()) {
            return false;
        }
        this.Qg.FP();
        return true;
    }

    public void bep() {
        if (this.fHl != null) {
            while (this.fHl.size() > 0) {
                TbImageView remove = this.fHl.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bep();
        this.fFv.qy(1);
        if (this.fEE != null) {
            this.fEE.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.fFv.qy(2);
        if (this.fEE != null) {
            this.fEE.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fGF != null) {
            this.fGF.destroy();
        }
        if (this.fGW != null) {
            this.fGW.onDestory();
        }
        if (this.fGN != null) {
            this.fGN.hide();
        }
        if (this.fEH != null) {
            this.fEH.akM();
        }
        if (this.fEG != null) {
            this.fEG.onDestroy();
        }
        this.fxt.hideProgressBar();
        if (this.cSy != null && this.dkf != null) {
            this.cSy.b(this.dkf);
        }
        beq();
        Ay();
        if (this.fGD != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fGD);
        }
        if (this.fEU != null && this.fFf != null) {
            this.fEU.removeView(this.fFa);
            this.fFf = null;
        }
        if (this.fGj != null) {
            this.fGj.clearStatus();
        }
        this.fHe = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fFv.qy(3);
        if (this.dox != null) {
            this.dox.setBackgroundDrawable(null);
        }
        if (this.fEE != null) {
            this.fEE.destroy();
        }
        if (this.fFv != null) {
            this.fFv.onDestroy();
        }
        this.fEO.setOnLayoutListener(null);
        if (this.fGS != null) {
            this.fGS.aws();
        }
        if (this.fGu != null) {
            this.fGu.onDestroy();
        }
        beL();
    }

    public boolean qP(int i) {
        if (this.fEE != null) {
            return this.fEE.kM(i);
        }
        return false;
    }

    public void beq() {
        this.fEK.sz();
        if (this.fEH != null) {
            this.fEH.akM();
        }
        com.baidu.adp.lib.util.l.a(this.fxt.getPageContext().getPageActivity(), this.fFy);
        bdE();
        if (this.fFO != null) {
            this.fFO.dismiss();
        }
        bes();
        if (this.fEG != null) {
            this.fEG.bgo();
        }
        if (this.fFw != null) {
            this.fFw.dismiss();
        }
        if (this.doh != null) {
            this.doh.dismiss();
        }
    }

    public void ber() {
        this.fEK.sz();
        if (this.fEH != null) {
            this.fEH.akM();
        }
        if (this.fFO != null) {
            this.fFO.dismiss();
        }
        bes();
        if (this.fEG != null) {
            this.fEG.bgo();
        }
        if (this.fFw != null) {
            this.fFw.dismiss();
        }
        if (this.doh != null) {
            this.doh.dismiss();
        }
    }

    public void cW(List<String> list) {
        this.fGR = list;
        if (this.fGS != null) {
            this.fGS.setData(list);
        }
    }

    public void jt(boolean z) {
        this.fFv.jt(z);
    }

    public void ko(boolean z) {
        this.fFT = z;
    }

    public void bes() {
        if (this.fFF != null) {
            this.fFF.dismiss();
        }
        if (this.fFG != null) {
            com.baidu.adp.lib.g.g.b(this.fFG, this.fxt.getPageContext());
        }
        if (this.fFH != null) {
            com.baidu.adp.lib.g.g.b(this.fFH, this.fxt.getPageContext());
        }
        if (this.fFD != null) {
            com.baidu.adp.lib.g.g.b(this.fFD, this.fxt.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fBa, this.fxK);
            d(this.fBa, this.fxK, this.mType);
            this.fxt.getLayoutMode().setNightMode(i == 1);
            this.fxt.getLayoutMode().onModeChanged(this.cSA);
            this.fxt.getLayoutMode().onModeChanged(this.fEP);
            if (this.fEG != null) {
                this.fEG.onChangeSkinType(i);
            }
            if (this.fER != null) {
                com.baidu.tbadk.core.util.am.h(this.fER, d.C0140d.cp_cont_b);
                this.fER.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_link_tip_c));
            }
            if (this.drC != null) {
                this.drC.dC(i);
                if (this.aTf != null) {
                    this.fxt.getLayoutMode().onModeChanged(this.aTf);
                    com.baidu.tbadk.core.util.am.i(this.aTf, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fFw != null) {
                this.fFw.c(this.fxt.getPageContext());
            }
            km(this.fFQ);
            this.fFv.notifyDataSetChanged();
            if (this.fFz != null) {
                this.fFz.dC(i);
            }
            if (this.Qg != null) {
                this.Qg.onChangeSkinType(i);
            }
            if (this.fFe != null) {
                this.fFe.dG(i);
            }
            if (this.fFA != null) {
                this.fFA.dC(i);
            }
            if (!com.baidu.tbadk.core.util.w.z(this.cBk)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cBk) {
                    customBlueCheckRadioButton.Ah();
                }
            }
            ki(i == 1);
            bdS();
            UtilHelper.setStatusBarBackground(this.dox, i);
            UtilHelper.setStatusBarBackground(this.fGo, i);
            if (this.fFg != null) {
                this.fFg.onChangeSkinType(i);
            }
            if (this.fFl != null) {
                com.baidu.tbadk.core.util.am.h(this.fFl, d.C0140d.cp_cont_d);
            }
            if (this.fFk != null) {
                com.baidu.tbadk.core.util.am.h(this.fFk, d.C0140d.cp_cont_d);
            }
            if (this.fFm != null) {
                com.baidu.tbadk.core.util.am.i(this.fFm, d.C0140d.cp_cont_e);
            }
            if (this.ayq != null) {
                com.baidu.tbadk.core.util.am.h(this.ayq, d.C0140d.cp_cont_d);
            }
            if (this.fFn != null) {
                com.baidu.tbadk.core.util.am.i(this.fFn, d.C0140d.cp_cont_e);
            }
            if (this.fEX != null) {
                com.baidu.tbadk.core.util.am.h(this.fEX, d.C0140d.cp_link_tip_a);
            }
            if (this.fFj != null) {
                com.baidu.tbadk.core.util.am.h(this.fFj, d.C0140d.cp_cont_d);
            }
            if (this.fFo != null) {
                com.baidu.tbadk.o.a.a(this.fxt.getPageContext(), this.fFo);
            }
            if (this.fFM != null) {
                com.baidu.tbadk.o.a.a(this.fxt.getPageContext(), this.fFM);
            }
            if (this.fGE != null) {
                this.fGE.onChangeSkinType(i);
            }
            if (this.fEK != null) {
                if (this.fEE != null) {
                    this.fEE.qV(i);
                } else {
                    this.fEK.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fFW != null) {
                com.baidu.tbadk.core.util.am.h(this.fFW, d.C0140d.cp_cont_e);
            }
            if (this.fEY != null) {
                com.baidu.tbadk.core.util.am.c(this.fEY, BitmapHelper.getGradeResourceIdInEnterForum(this.fGM));
            }
            if (this.fGT != null) {
                this.fGT.onChangeSkinType(i);
            }
            if (this.fGu != null) {
                this.fGu.onChangeSkinType();
            }
            if (this.fGQ != null) {
                com.baidu.tbadk.core.util.am.h(this.fGQ, d.C0140d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bgd = hVar;
        this.fFv.setOnImageClickListener(this.bgd);
        this.fGT.setOnImageClickListener(this.bgd);
    }

    public void h(NoNetworkView.a aVar) {
        this.dkf = aVar;
        if (this.cSy != null) {
            this.cSy.a(this.dkf);
        }
    }

    public void kp(boolean z) {
        this.fFv.setIsFromCDN(z);
    }

    public Button bet() {
        return this.fFU;
    }

    public void beu() {
        if (this.fEJ != 2) {
            this.fEO.setNextPage(this.drC);
            this.fEJ = 2;
        }
    }

    public void bev() {
        if (com.baidu.tbadk.l.m.KF().KG()) {
            int lastVisiblePosition = this.fEO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fEO.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.fm(1001);
                                perfLog.aTK = true;
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
                        com.baidu.tbadk.l.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.fm(1001);
                        perfLog2.aTK = true;
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

    public boolean bew() {
        return this.Qg != null && this.Qg.getVisibility() == 0;
    }

    public boolean bex() {
        return this.Qg != null && this.Qg.Hw();
    }

    public void bey() {
        if (this.Qg != null) {
            this.Qg.FP();
        }
    }

    public void kq(boolean z) {
        if (this.fFV != null) {
            ko(this.fxt.baF().HZ());
            if (this.fFT) {
                kf(z);
            } else {
                kg(z);
            }
        }
    }

    public void bez() {
        if (this.fFV != null) {
            this.fFV.setVisibility(8);
            this.fGa = false;
            if (this.fGu != null) {
                this.fGu.setVisibility(8);
                kk(false);
            }
            beL();
        }
    }

    public void showLoadingDialog() {
        if (this.cIH == null) {
            this.cIH = new com.baidu.tbadk.core.view.a(this.fxt.getPageContext());
        }
        this.cIH.aM(true);
    }

    public void aeP() {
        if (this.cIH != null) {
            this.cIH.aM(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fEO.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fEO.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fEE != null) {
            this.fEE.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.fHm = getScrollY();
            this.fGt.fHC = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGt));
            a(this.fGt.fHC, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fEE != null) {
            this.fEE.b(absListView, i);
        }
        int headerViewsCount = (i - this.fEO.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fFv.qx(headerViewsCount) == com.baidu.tieba.pb.data.j.fto) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fEO.getHeaderViewsCount();
        if (this.fES != null && this.fEK != null) {
            this.fEK.g(this.fES.getBottom(), this.fES.getMeasuredHeight(), z2);
        }
        this.fFv.bbQ().i(z, this.fGm != null ? this.fGm.getMeasuredHeight() : 0);
        this.fGt.fok = i;
        this.fGt.fHB = this.fEO.getHeaderViewsCount();
        this.fGt.fHC = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGt));
        a(this.fGt.fHC, false);
    }

    public void beA() {
        if (this.fxt.isLogin() && this.fBa != null && this.fGJ && !this.fGI && !this.fFR && this.fGe != null && this.fGe.vk() != null && !this.fGe.vk().getIsLike() && !this.fGe.vk().hadConcerned()) {
            if (this.fGF == null) {
                this.fGF = new an(this.fxt);
            }
            this.fGF.a(this.fEK.fJK, this.fBa.aZN(), this.fGe.vk().getUserId(), this.fBa.getThreadId());
        }
    }

    public void beB() {
        if (this.fGJ && !this.fGI && this.fGe != null && this.fGe.vk() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").r("obj_locate", this.fxt.bbu() ? 2 : 1).r("obj_type", this.fGI ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fxt.getPageContext().getPageActivity(), this.fGe.vk().getUserId(), this.fGe.vk().getUserName(), this.fxt.bat().bch(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fGI && this.fGn != null && this.fEK.bff() != null) {
            int bbN = this.fFv.bbN();
            if (bbN > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bbN > this.fEO.getFirstVisiblePosition() - this.fEO.getHeaderViewsCount()) {
                    this.fGn.setVisibility(8);
                    return;
                }
                this.fGn.setVisibility(0);
                this.fEK.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fDS == null) {
                if (this.fEO.getFirstVisiblePosition() == 0) {
                    this.fGn.setVisibility(8);
                    this.fEK.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fGs) {
                        this.fGr = top;
                        this.fGs = false;
                    }
                    this.fGr = top < this.fGr ? top : this.fGr;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fFu.getY() < 0.0f) {
                        measuredHeight = fGq - alVar.fDS.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fEK.bff().getMeasuredHeight() - alVar.fDS.getMeasuredHeight();
                        this.fEK.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fGr) {
                        this.fGn.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fGn.setVisibility(0);
                    } else {
                        this.fGn.setVisibility(8);
                        this.fEK.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fGs = true;
                    }
                }
            }
        }
    }

    public void beC() {
        if (!this.fHn) {
            TiebaStatic.log("c10490");
            this.fHn = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fxt.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fGx, Integer.valueOf(fGz));
            aVar.ce(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.w(inflate);
            aVar.C(sparseArray);
            aVar.a(d.j.grade_button_tips, this.fxt);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fxt.getPageContext()).xf();
        }
    }

    public void rn(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fxt.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.w(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fGx, Integer.valueOf(fGA));
        aVar.C(sparseArray);
        aVar.a(d.j.view, this.fxt);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fxt.getPageContext()).xf();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.vk() != null) {
            MetaData vk = b.vk();
            vk.setGiftNum(vk.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView beD() {
        return this.fGj;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aZn() != null && dVar.aZn().wa() && this.fGj == null) {
            this.fGj = (PbInterviewStatusView) this.fGi.inflate();
            this.fGj.setOnClickListener(this.doi);
            this.fGj.setCallback(this.fxt.bbp());
            this.fGj.setData(this.fxt, dVar);
        }
    }

    public LinearLayout beE() {
        return this.fFu;
    }

    public View beF() {
        return this.dox;
    }

    public boolean beG() {
        return this.fGY;
    }

    public void jy(boolean z) {
        this.fET.jy(z);
    }

    public void ro(String str) {
        if (this.fEL != null) {
            this.fEL.setTitle(str);
        }
    }

    private int kr(boolean z) {
        if (this.fGj == null || this.fGj.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void beH() {
        if (this.fGj != null && this.fGj.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGj.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fGj.setLayoutParams(layoutParams);
        }
    }

    public boolean baL() {
        return false;
    }

    public void rp(String str) {
        this.fFW.performClick();
        if (!StringUtils.isNull(str) && this.fxt.baF() != null && this.fxt.baF().HS() != null && this.fxt.baF().HS().getInputView() != null) {
            EditText inputView = this.fxt.baF().HS().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            beq();
            if (configuration.orientation == 2) {
                bez();
                bdE();
            } else {
                bdH();
            }
            if (this.fGE != null) {
                this.fGE.bbU();
            }
            this.fxt.auC();
            this.fFu.setVisibility(8);
            this.fEK.kD(false);
            this.fxt.jE(false);
            if (this.fEE != null) {
                if (configuration.orientation == 1) {
                    beE().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fEO.setIsLandscape(true);
                    this.fEO.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fEO.setIsLandscape(false);
                    if (this.fHm > 0) {
                        this.fEO.smoothScrollBy(this.fHm, 0);
                    }
                }
                this.fEE.onConfigurationChanged(configuration);
                this.fGm.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void ks(boolean z) {
        this.fEI = z;
    }

    public boolean beI() {
        return this.fEE != null && this.fEE.beI();
    }

    public void beJ() {
        if (this.fEE != null) {
            this.fEE.onPause();
        }
    }

    public void k(long j, int i) {
        if (this.fEG != null) {
            this.fEG.k(j, i);
        }
        if (this.fEE != null) {
            this.fEE.k(j, i);
        }
    }

    public void jJ(boolean z) {
        this.fFv.jJ(z);
    }

    public void beK() {
        if (this.fGk == null) {
            LayoutInflater.from(this.fxt.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.cSA, true);
            this.fGk = (ViewGroup) this.cSA.findViewById(d.g.add_experienced_layout);
            this.fGl = (TextView) this.cSA.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.am.h(this.fGl, d.C0140d.cp_cont_i);
            String string = this.fxt.getResources().getString(d.j.experienced_add_success);
            String string2 = this.fxt.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_cont_h)));
            this.fGl.setText(spannableString);
        }
        this.fGk.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.at.29
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.at.29.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        at.this.fGk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                at.this.fGl.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fGl.startAnimation(scaleAnimation);
    }

    public void bm(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fFV.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fxt);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fGQ = new TextView(this.fxt);
            this.fGQ.setText(d.j.connection_tips);
            this.fGQ.setGravity(17);
            this.fGQ.setPadding(com.baidu.adp.lib.util.l.f(this.fxt, d.e.ds24), 0, com.baidu.adp.lib.util.l.f(this.fxt, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.fxt, d.e.ds60);
            if (this.fGQ.getParent() == null) {
                frameLayout.addView(this.fGQ, layoutParams);
            }
            this.fGP = new PopupWindow(this.fxt);
            this.fGP.setContentView(frameLayout);
            this.fGP.setHeight(-2);
            this.fGP.setWidth(-2);
            this.fGP.setFocusable(true);
            this.fGP.setOutsideTouchable(false);
            this.fGP.setBackgroundDrawable(new ColorDrawable(this.fxt.getResources().getColor(d.C0140d.transparent)));
            this.fEO.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        at.this.fGP.showAsDropDown(at.this.fFV, view.getLeft(), -at.this.fFV.getHeight());
                    } else {
                        at.this.fGP.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.beW() != null && !StringUtils.isNull(aVar.beW().pkg_id) && !StringUtils.isNull(aVar.beW().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fFX != null && this.fFX.getVisibility() == 0) {
            if (this.fGO == null) {
                View inflate = LayoutInflater.from(this.fxt.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.doi);
                this.fGO = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fFX.getLocationInWindow(iArr);
            this.fGO.showAtLocation(this.fFX, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fFX.getHeight()) - com.baidu.adp.lib.util.l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void beL() {
        com.baidu.adp.lib.g.g.a(this.fGO);
    }

    public void kt(boolean z) {
        this.fGV = z;
    }

    public boolean beM() {
        return this.fGV;
    }

    public void bn(View view) {
        this.fFM = view;
    }
}
