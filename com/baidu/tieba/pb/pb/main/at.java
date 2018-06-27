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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
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
    private EditorTools Qj;
    private TextView aIt;
    private View aTf;
    private g.b awQ;
    private TextView ayD;
    private com.baidu.tieba.pb.a.c bfS;
    private NoNetworkView cPM;
    private RelativeLayout cPO;
    private List<CustomBlueCheckRadioButton> cyG;
    private NavigationBarCoverTip dED;
    private com.baidu.tieba.NEGFeedBack.e dHz;
    private View dlF;
    private View.OnClickListener dlq;
    private PbListView doI;
    private int eWx;
    private com.baidu.tieba.pb.data.d fAN;
    private ViewStub fEA;
    private PbLandscapeListView fEB;
    private View fEC;
    private LinearLayout fEF;
    private e fEG;
    private ColumnLayout fEH;
    private ThreadSkinView fEI;
    private TextView fEJ;
    private TextView fEK;
    private ImageView fEL;
    private HeadPendantView fEM;
    private FrameLayout fEN;
    private HeadImageView fEO;
    private View fEP;
    private FloatingLayout fEQ;
    private PbFirstFloorUserLikeButton fET;
    private ar fEU;
    private ar fEV;
    private TextView fEW;
    private TextView fEX;
    private TextView fEY;
    private View fEZ;
    public int fEq;
    private com.baidu.tieba.pb.video.i fEr;
    private long fEs;
    private com.baidu.tieba.pb.video.h fEt;
    private com.baidu.tieba.c.d fEu;
    public final com.baidu.tieba.pb.pb.main.view.b fEx;
    public com.baidu.tieba.pb.pb.main.view.a fEy;
    private ViewStub fEz;
    private View fFI;
    private TextView fFJ;
    private ImageView fFK;
    private ImageView fFL;
    private TextView fFM;
    private boolean fFO;
    private int fFP;
    private int fFQ;
    private PostData fFR;
    private View fFT;
    private TextView fFU;
    private ViewStub fFV;
    private PbInterviewStatusView fFW;
    private ViewGroup fFX;
    private TextView fFY;
    private FrameLayout fFZ;
    private View fFa;
    private LinearLayout fFb;
    private TextView fFc;
    private TextView fFd;
    private View fFe;
    private View fFf;
    private ObservedChangeLinearLayout fFh;
    private f fFi;
    private View fFo;
    private PbTopTipView fGA;
    private PopupWindow fGB;
    private PopupWindow fGC;
    private TextView fGD;
    private List<String> fGE;
    private com.baidu.tieba.pb.pb.main.emotion.c fGF;
    private com.baidu.tieba.pb.pb.godreply.a fGG;
    private PbLandscapeListView.b fGH;
    private ac fGJ;
    private boolean fGL;
    private com.baidu.tbadk.core.view.userLike.c fGM;
    private com.baidu.tbadk.core.view.userLike.c fGN;
    private Runnable fGS;
    private PbActivity.b fGU;
    private View fGa;
    private View fGb;
    private al fGc;
    private PbEmotionBar fGh;
    private int fGp;
    private Runnable fGq;
    private s fGr;
    private an fGs;
    private int fGy;
    PbActivity.d fwm;
    private View.OnClickListener fxF;
    private PbActivity fxh;
    private UserIconBox fyw;
    private UserIconBox fyx;
    private PbFakeFloorModel fzI;
    private boolean isLandscape;
    private View mFooterView;
    private int mType;
    private static final int fGd = UtilHelper.getLightStatusBarHeight();
    public static int fGj = 3;
    public static int fGk = 0;
    public static int fGl = 3;
    public static int fGm = 4;
    public static int fGn = 5;
    public static int fGo = 6;
    private static a.InterfaceC0234a fGK = new a.InterfaceC0234a() { // from class: com.baidu.tieba.pb.pb.main.at.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
        }
    };
    private boolean fEv = false;
    private int fEw = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fED = null;
    private TextView fEE = null;
    public FrsPraiseView fER = null;
    private ClickableHeaderImageView fES = null;
    private View fFg = null;
    private com.baidu.tbadk.core.dialog.a fFj = null;
    private com.baidu.tbadk.core.dialog.b dlp = null;
    private View fFk = null;
    private EditText fFl = null;
    private com.baidu.tieba.pb.view.e fFm = null;
    private com.baidu.tieba.pb.view.a fFn = null;
    private com.baidu.tbadk.core.dialog.a fFp = null;
    private b.InterfaceC0104b erW = null;
    private TbRichTextView.h bfR = null;
    private NoNetworkView.a dhp = null;
    private Dialog fFq = null;
    private View fFr = null;
    private com.baidu.tbadk.core.dialog.a fFs = null;
    private Dialog fFt = null;
    private Dialog fFu = null;
    private View fFv = null;
    private LinearLayout fFw = null;
    private CompoundButton.OnCheckedChangeListener cyH = null;
    private TextView fFx = null;
    private TextView fFy = null;
    private View fFz = null;
    private String fFA = null;
    private com.baidu.tbadk.core.dialog.b fFB = null;
    private com.baidu.tbadk.core.dialog.b fFC = null;
    private boolean fFD = false;
    private boolean fFE = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fFF = null;
    private boolean fFG = false;
    private Button fFH = null;
    private boolean fFN = true;
    private com.baidu.tbadk.core.view.a cGa = null;
    private boolean fxy = false;
    private int mSkinType = 3;
    private boolean fFS = false;
    private int fGe = 0;
    private boolean fGf = true;
    private a fGg = new a();
    private int fGi = 0;
    private boolean fGt = false;
    private int fGu = 0;
    private boolean fGv = false;
    private boolean fGw = false;
    private boolean fGx = false;
    private int fGz = 0;
    private boolean fGI = false;
    private String fGO = null;
    private CustomMessageListener fGP = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.at.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                at.this.fGO = null;
            }
        }
    };
    private CustomMessageListener bwT = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.at.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && at.this.fFi != null) {
                at.this.fFi.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fGQ = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.at.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (at.this.fEE != null) {
                at.this.fEE.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fGR = new Handler();
    private CustomMessageListener fGT = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.at.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                at.this.fFN = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fGV = true;
    View.OnClickListener fGW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (at.this.fGv) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").r(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (at.this.fEx != null && at.this.fEx.fJx != null && view == at.this.fEx.fJx.getHeadView()) {
                if (at.this.fEx.fJv == null || at.this.fEx.fJv.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12506").r("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!at.this.fGv && at.this.fAN != null && at.this.fAN.baV() != null && at.this.fAN.baV().vw() != null && at.this.fAN.baV().vw().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").r("obj_locate", 1));
            }
            at.this.fxh.fvk.fIG.onClick(view);
        }
    };
    private boolean fGX = false;
    String userId = null;
    private final List<TbImageView> fGY = new ArrayList();
    private boolean fGZ = false;

    /* loaded from: classes2.dex */
    public static class a {
        public al fHn;
        public int fnZ;
        public int headerCount;
    }

    public void ks(boolean z) {
        this.fGt = z;
        if (this.fEB != null) {
            this.fGu = this.fEB.getHeaderViewsCount();
        }
    }

    public void bfj() {
        if (this.fEB != null) {
            int headerViewsCount = this.fEB.getHeaderViewsCount() - this.fGu;
            final int firstVisiblePosition = (this.fEB.getFirstVisiblePosition() == 0 || this.fEB.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fEB.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fEB.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fGg.fHn = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGg));
            final al alVar = this.fGg.fHn;
            final int h = h(alVar);
            final int y = ((int) this.fFh.getY()) + this.fFh.getMeasuredHeight();
            final boolean z = this.fGa.getVisibility() == 0;
            boolean z2 = this.fFh.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fFi.bdu() + this.fEB.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fDF.getMeasuredHeight() : 0;
                if (z2) {
                    this.fEB.setSelectionFromTop(this.fFi.bdu() + this.fEB.getHeaderViewsCount(), fGd - measuredHeight);
                } else {
                    this.fEB.setSelectionFromTop(this.fFi.bdu() + this.fEB.getHeaderViewsCount(), this.fEx.bgM().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fEB.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fGv) {
                this.fEB.setSelectionFromTop(this.fFi.bdu() + this.fEB.getHeaderViewsCount(), this.fEr.bic().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fEB.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.at.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bdL() {
                        if (h >= 0 && h <= at.this.cPO.getMeasuredHeight()) {
                            int h2 = at.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = at.this.mFooterView.getLayoutParams();
                            if (i == 0 || i > at.this.cPO.getMeasuredHeight() || h2 >= at.this.cPO.getMeasuredHeight()) {
                                layoutParams.height = at.this.fGp;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > at.this.cPO.getMeasuredHeight()) {
                                layoutParams.height = at.this.fGp;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                at.this.fEB.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            at.this.mFooterView.setLayoutParams(layoutParams);
                        }
                        at.this.fEB.setOnLayoutListener(null);
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

    public NoNetworkView bfk() {
        return this.cPM;
    }

    public void bfl() {
        if (this.Qj != null) {
            this.Qj.hide();
            if (this.fGF != null) {
                this.fGF.SC();
            }
        }
    }

    public PbFakeFloorModel bfm() {
        return this.fzI;
    }

    public s bfn() {
        return this.fGr;
    }

    public void bfo() {
        reset();
        bfl();
        this.fGr.bdB();
        kE(false);
    }

    private void reset() {
        if (this.fxh != null && this.fxh.bcm() != null && this.Qj != null) {
            com.baidu.tbadk.editortools.pb.a.HU().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bcm = this.fxh.bcm();
            bcm.In();
            bcm.HI();
            if (bcm.getWriteImagesInfo() != null) {
                bcm.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bcm.eT(SendView.ALL);
            bcm.eU(SendView.ALL);
            com.baidu.tbadk.editortools.g eK = this.Qj.eK(23);
            com.baidu.tbadk.editortools.g eK2 = this.Qj.eK(2);
            com.baidu.tbadk.editortools.g eK3 = this.Qj.eK(5);
            if (eK2 != null) {
                eK2.oD();
            }
            if (eK3 != null) {
                eK3.oD();
            }
            if (eK != null) {
                eK.hide();
            }
            this.Qj.invalidate();
        }
    }

    public boolean bfp() {
        return this.fFN;
    }

    public void kt(boolean z) {
        if (this.fFI != null && this.fFJ != null) {
            this.fFJ.setText(d.k.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fFI.startAnimation(alphaAnimation);
            }
            this.fFI.setVisibility(0);
            this.fFN = true;
            if (this.fGh != null && !this.fGG.isActive()) {
                this.fGh.setVisibility(0);
                ky(true);
            }
        }
    }

    public void ku(boolean z) {
        if (this.fFI != null && this.fFJ != null) {
            this.fFJ.setText(d.k.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fFI.startAnimation(alphaAnimation);
            }
            this.fFI.setVisibility(0);
            this.fFN = true;
            if (this.fGh != null && !this.fGG.isActive()) {
                this.fGh.setVisibility(0);
                ky(true);
            }
        }
    }

    public PostData bfq() {
        int i = 0;
        if (this.fEB == null) {
            return null;
        }
        int bfr = bfr() - this.fEB.getHeaderViewsCount();
        if (bfr < 0) {
            bfr = 0;
        }
        if (this.fFi.qA(bfr) != null && this.fFi.qA(bfr) != PostData.gMV) {
            i = bfr + 1;
        }
        return this.fFi.getItem(i) instanceof PostData ? (PostData) this.fFi.getItem(i) : null;
    }

    public int bfr() {
        int i;
        View childAt;
        if (this.fEB == null) {
            return 0;
        }
        int firstVisiblePosition = this.fEB.getFirstVisiblePosition();
        int lastVisiblePosition = this.fEB.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fEB.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fEB.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bfs() {
        return this.fEB.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fAN != null && this.fAN.baX() != null && !this.fAN.baX().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fAN.baX().size() && (postData = this.fAN.baX().get(i)) != null && postData.vw() != null && !StringUtils.isNull(postData.vw().getUserId()); i++) {
                if (this.fAN.baX().get(i).vw().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fGG != null && this.fGG.isActive()) {
                        kE(false);
                    }
                    if (this.fGh != null) {
                        this.fGh.kL(true);
                    }
                    this.fGO = postData.vw().getName_show();
                    return;
                }
            }
        }
    }

    public at(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fxh = null;
        this.cPO = null;
        this.dlF = null;
        this.fEs = 0L;
        this.fEB = null;
        this.fEC = null;
        this.fEF = null;
        this.fEH = null;
        this.fEJ = null;
        this.fEK = null;
        this.fEN = null;
        this.fEO = null;
        this.fEP = null;
        this.fET = null;
        this.fEW = null;
        this.fEX = null;
        this.fEY = null;
        this.fEZ = null;
        this.fFe = null;
        this.fFf = null;
        this.fFi = null;
        this.doI = null;
        this.aTf = null;
        this.dlq = null;
        this.fxF = null;
        this.fFI = null;
        this.fFJ = null;
        this.fFK = null;
        this.fFL = null;
        this.fFM = null;
        this.fFT = null;
        this.fFU = null;
        this.fFV = null;
        this.fGy = 0;
        this.fEs = System.currentTimeMillis();
        this.fxh = pbActivity;
        this.dlq = onClickListener;
        this.bfS = cVar;
        this.fGy = com.baidu.adp.lib.util.l.ah(this.fxh) / 2;
        this.cPO = (RelativeLayout) LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.new_pb_activity, (ViewGroup) null);
        this.fxh.addContentView(this.cPO, new FrameLayout.LayoutParams(-1, -1));
        this.dED = (NavigationBarCoverTip) this.fxh.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dlF = this.fxh.findViewById(d.g.statebar_view);
        this.fFh = (ObservedChangeLinearLayout) this.fxh.findViewById(d.g.title_wrapper);
        this.cPM = (NoNetworkView) this.fxh.findViewById(d.g.view_no_network);
        this.fEB = (PbLandscapeListView) this.fxh.findViewById(d.g.new_pb_list);
        this.fFZ = (FrameLayout) this.fxh.findViewById(d.g.root_float_header);
        this.aIt = new TextView(this.fxh.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds88));
        this.fEB.addHeaderView(this.aIt, 0);
        this.fGp = this.fxh.getResources().getDimensionPixelSize(d.e.tbds134);
        this.mFooterView = new View(this.fxh.getPageContext().getPageActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fGp));
        this.mFooterView.setVisibility(4);
        this.fEB.addFooterView(this.mFooterView);
        this.fEB.setOnTouchListener(this.fxh.aWD);
        this.fEx = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fxh.bcO()) {
            this.fEz = (ViewStub) this.fxh.findViewById(d.g.manga_view_stub);
            this.fEz.setVisibility(0);
            this.fEy = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fEy.show();
            this.fEx.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds120);
        }
        this.aIt.setLayoutParams(layoutParams);
        this.fEx.bgM().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0205a() { // from class: com.baidu.tieba.pb.pb.main.at.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0205a
            public void bbO() {
                if (at.this.fEB != null) {
                    if (at.this.fEr != null) {
                        at.this.fEr.bid();
                    }
                    at.this.fEB.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0205a
            public void bbP() {
                at.this.fxh.atY();
            }
        }));
        this.fFI = this.fxh.findViewById(d.g.pb_editor_tool_comment);
        this.fFP = com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds90);
        this.fFQ = com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds242);
        this.fFJ = (TextView) this.fxh.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fFL = (ImageView) this.fxh.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fFK = (ImageView) this.fxh.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fFM = (TextView) this.fxh.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fFM.setVisibility(8);
        this.fFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.bgs();
                if (!at.this.fxh.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).ah(ImageViewerConfig.FORUM_ID, at.this.mForumId));
                } else if (at.this.fxh.bcw()) {
                    com.baidu.tbadk.editortools.pb.d bcm = at.this.fxh.bcm();
                    if (bcm == null || (!bcm.Ik() && !bcm.Il())) {
                        if (at.this.Qj != null) {
                            at.this.bfC();
                        }
                        if (at.this.Qj != null) {
                            at.this.fFN = false;
                            if (at.this.Qj.eN(2) != null) {
                                com.baidu.tieba.tbadkCore.b.a.a(at.this.fxh, (View) at.this.Qj.eN(2).aMf, false, at.fGK);
                            }
                        }
                        at.this.bgg();
                        return;
                    }
                    at.this.fxh.bcm().a(false, (PostWriteCallBackData) null);
                }
            }
        });
        this.fFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.bgs();
                if (at.this.fxh.checkUpIsLogin()) {
                    if (at.this.Qj != null) {
                        at.this.bfC();
                        at.this.Qj.N((View) at.this.Qj.eK(5));
                    }
                    if (at.this.Qj != null) {
                        at.this.fFN = false;
                        if (at.this.Qj.eN(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(at.this.fxh, (View) at.this.Qj.eN(2).aMf, false, at.fGK);
                        }
                    }
                    at.this.bgg();
                }
            }
        });
        this.fFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.bgs();
                if (at.this.fxh.checkUpIsLogin()) {
                    if (at.this.Qj != null) {
                        at.this.bfC();
                        at.this.Qj.N((View) at.this.Qj.eK(2));
                    }
                    if (at.this.Qj != null) {
                        at.this.fFN = false;
                        if (at.this.Qj.eN(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(at.this.fxh, (View) at.this.Qj.eN(2).aMf, false, at.fGK);
                        }
                    }
                    at.this.bgg();
                }
            }
        });
        this.fFM.setOnClickListener(this.dlq);
        this.fFM.setOnTouchListener(this.fxh);
        this.fEC = LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_item, (ViewGroup) null);
        this.fEF = (LinearLayout) LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_user_item, (ViewGroup) null);
        this.fEG = new e(this.fxh, this.fEF);
        this.fEG.init();
        this.fEG.a(this.fEG.bcl(), this.dlq);
        this.fEH = (ColumnLayout) this.fEF.findViewById(d.g.pb_head_owner_root);
        this.fEI = (ThreadSkinView) this.fEF.findViewById(d.g.pb_thread_skin);
        this.fEH.setOnLongClickListener(this.onLongClickListener);
        this.fEH.setOnTouchListener(this.bfS);
        this.fEH.setVisibility(8);
        this.fEC.setOnTouchListener(this.bfS);
        this.fFT = this.fEC.findViewById(d.g.pb_head_activity_join_number_container);
        this.fFT.setVisibility(8);
        this.fFU = (TextView) this.fEC.findViewById(d.g.pb_head_activity_join_number);
        this.fEJ = (TextView) this.fEH.findViewById(d.g.pb_head_owner_info_user_name);
        this.fEK = (TextView) this.fEH.findViewById(d.g.floor_owner);
        this.fEL = (ImageView) this.fEH.findViewById(d.g.icon_forum_level);
        this.fEN = (FrameLayout) this.fEH.findViewById(d.g.pb_head_headImage_container);
        this.fEO = (HeadImageView) this.fEH.findViewById(d.g.pb_head_owner_photo);
        this.fEM = (HeadPendantView) this.fEH.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fEM.setHasPendantStyle();
        if (this.fEM.getHeadView() != null) {
            this.fEM.getHeadView().setIsRound(true);
            this.fEM.getHeadView().setDrawBorder(false);
        }
        this.fyw = (UserIconBox) this.fEH.findViewById(d.g.show_icon_vip);
        this.fyx = (UserIconBox) this.fEH.findViewById(d.g.show_icon_yinji);
        this.fEQ = (FloatingLayout) this.fEF.findViewById(d.g.pb_head_owner_info_root);
        this.fET = (PbFirstFloorUserLikeButton) this.fEH.findViewById(d.g.pb_like_button);
        this.fEW = (TextView) this.fEH.findViewById(d.g.pb_views);
        this.ayD = (TextView) this.fEH.findViewById(d.g.view_forum_name);
        this.fFa = this.fEH.findViewById(d.g.line_right_forum_name);
        this.fEX = (TextView) this.fEH.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fEY = (TextView) this.fEH.findViewById(d.g.pb_item_first_floor_location_address);
        this.fEZ = this.fEH.findViewById(d.g.line_between_time_and_locate);
        this.fGM = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fGN = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fFe = this.fEC.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fFf = this.fEC.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fEC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.35
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fFV = (ViewStub) this.cPO.findViewById(d.g.interview_status_stub);
        this.fFi = new f(this.fxh, this.fEB);
        this.fFi.w(this.dlq);
        this.fFi.setTbGestureDetector(this.bfS);
        this.fFi.setOnImageClickListener(this.bfR);
        this.fxF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.36
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
                            at.this.fxh.b(sparseArray);
                            return;
                        }
                        at.this.bi(view);
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        at.this.fxh.b(sparseArray);
                    } else if (booleanValue3) {
                        at.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fFi.I(this.fxF);
        bfx();
        this.fEB.addHeaderView(this.fED);
        this.fEB.addHeaderView(this.fEF);
        this.fEB.addHeaderView(this.fEC);
        this.doI = new PbListView(this.fxh.getPageContext().getPageActivity());
        this.aTf = this.doI.getView().findViewById(d.g.pb_more_view);
        if (this.aTf != null) {
            this.aTf.setOnClickListener(this.dlq);
            com.baidu.tbadk.core.util.am.i(this.aTf, d.f.pb_foot_more_trans_selector);
        }
        this.doI.AD();
        this.doI.setBackground(d.f.pb_foot_more_trans_selector);
        this.doI.dy(d.f.pb_foot_more_trans_selector);
        this.fFo = this.fxh.findViewById(d.g.viewstub_progress);
        this.fxh.registerListener(this.fGT);
        this.fEP = com.baidu.tbadk.ala.b.rM().f(this.fxh.getActivity(), 2);
        if (this.fEP != null) {
            this.fEP.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fxh.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fEP.getParent() == null) {
                this.fEQ.addView(this.fEP, aVar);
            }
        }
        this.fzI = new PbFakeFloorModel(this.fxh.getPageContext());
        this.fGr = new s(this.fxh.getPageContext(), this.fzI, this.cPO);
        this.fGr.a(this.fxh.fwi);
        this.fzI.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.at.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                at.this.fzI.l(postData);
                at.this.fFi.notifyDataSetChanged();
                at.this.fGr.bdB();
                at.this.Qj.FT();
                at.this.kE(false);
            }
        });
        if (this.fxh.bca() != null && !StringUtils.isNull(this.fxh.bca().beu())) {
            this.fxh.showToast(this.fxh.bca().beu());
        }
        this.fGa = this.fxh.findViewById(d.g.pb_expand_blank_view);
        this.fGb = this.fxh.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fGb.getLayoutParams();
        if (this.fxh.bca() != null && this.fxh.bca().bdS()) {
            this.fGa.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fGb.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fGd;
            this.fGb.setLayoutParams(layoutParams2);
        }
        this.fGc = new al(this.fxh.getPageContext(), this.fxh.findViewById(d.g.pb_reply_expand_view));
        this.fGc.fDF.setVisibility(8);
        this.fGc.L(this.dlq);
        this.fxh.registerListener(this.bwT);
        this.fxh.registerListener(this.fGP);
        this.fxh.registerListener(this.fGQ);
        bft();
        ky(false);
    }

    private void bft() {
        this.fGG = new com.baidu.tieba.pb.pb.godreply.a(this.fxh, this, (ViewStub) this.cPO.findViewById(d.g.more_god_reply_popup));
        this.fGG.q(this.dlq);
        this.fGG.I(this.fxF);
        this.fGG.setOnImageClickListener(this.bfR);
        this.fGG.q(this.dlq);
        this.fGG.setTbGestureDetector(this.bfS);
    }

    public com.baidu.tieba.pb.pb.godreply.a bfu() {
        return this.fGG;
    }

    public View bfv() {
        return this.fGa;
    }

    public void bfw() {
        if (this.fEB != null) {
            this.fEB.removeHeaderView(this.fED);
            this.fEB.removeHeaderView(this.fEF);
            this.fEB.removeHeaderView(this.fEC);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fGh == null) {
            this.fGh = new PbEmotionBar(this.fxh.getPageContext().getPageActivity());
            ky(true);
            this.fGh.a(this.cPO, aVar, this.fFI.getVisibility() == 0);
            this.fGh.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.at.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (at.this.fxh.bcw()) {
                        if (!StringUtils.isNull(at.this.fGO)) {
                            emotionImageData.setAuthorNameShow(at.this.fGO);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    at.this.fxh.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(at.this.fxh.getPageContext().getPageActivity(), 25016, str, list, at.this.fGO, list2)));
                }
            });
            this.fGh.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.at.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    at.this.bgs();
                    if (at.this.fFI != null) {
                        ViewGroup.LayoutParams layoutParams = at.this.fFI.getLayoutParams();
                        layoutParams.height = (int) (((at.this.fFQ - at.this.fFP) * f) + at.this.fFP);
                        at.this.fFJ.setAlpha(1.0f - f);
                        at.this.fFL.setAlpha(1.0f - f);
                        at.this.fFK.setAlpha(1.0f - f);
                        at.this.fFI.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bfx() {
        if (this.fED == null) {
            int e = com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.tbds44);
            this.fED = new LinearLayout(this.fxh.getPageContext().getPageActivity());
            this.fED.setOrientation(1);
            this.fED.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fED.setPadding(e, com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.tbds30), e, com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.tbds40));
            this.fED.setGravity(17);
            this.fEE = new TextView(this.fxh.getPageContext().getPageActivity());
            this.fEE.setGravity(3);
            this.fEE.setMaxLines(2);
            this.fEE.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_link_tip_c));
            this.fEE.setPadding(0, 0, 0, 0);
            this.fEE.setLineSpacing(com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.am.h(this.fEE, d.C0142d.cp_cont_b);
            this.fEE.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fEE.setVisibility(8);
            if (this.fEE.getParent() == null) {
                this.fED.addView(this.fEE);
            }
            this.fED.setOnTouchListener(this.bfS);
            this.fED.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfy() {
        if (this.fxh.bcO()) {
            this.fEA = (ViewStub) this.fxh.findViewById(d.g.manga_mention_controller_view_stub);
            this.fEA.setVisibility(0);
            if (this.fFb == null) {
                this.fFb = (LinearLayout) this.fxh.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fxh.getPageContext(), this.fFb);
            }
            if (this.fFc == null) {
                this.fFc = (TextView) this.fFb.findViewById(d.g.manga_prev_btn);
            }
            if (this.fFd == null) {
                this.fFd = (TextView) this.fFb.findViewById(d.g.manga_next_btn);
            }
            this.fFc.setOnClickListener(this.dlq);
            this.fFd.setOnClickListener(this.dlq);
        }
    }

    private void bfz() {
        if (this.fxh.bcO()) {
            if (this.fxh.bcR() == -1) {
                com.baidu.tbadk.core.util.am.c(this.fFc, d.C0142d.cp_cont_e, 1);
            }
            if (this.fxh.bcS() == -1) {
                com.baidu.tbadk.core.util.am.c(this.fFd, d.C0142d.cp_cont_e, 1);
            }
        }
    }

    public void bfA() {
        if (this.fFb == null) {
            bfy();
        }
        this.fEA.setVisibility(8);
        if (this.fGR != null && this.fGS != null) {
            this.fGR.removeCallbacks(this.fGS);
        }
    }

    public void bfB() {
        if (this.fGR != null) {
            if (this.fGS != null) {
                this.fGR.removeCallbacks(this.fGS);
            }
            this.fGS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.this.fFb == null) {
                        at.this.bfy();
                    }
                    at.this.fEA.setVisibility(0);
                }
            };
            this.fGR.postDelayed(this.fGS, 2000L);
        }
    }

    public void kv(boolean z) {
        this.fEx.kv(z);
        if (z && this.fFS) {
            this.doI.setText(this.fxh.getResources().getString(d.k.click_load_more));
            this.fEB.setNextPage(this.doI);
            this.fEw = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
        this.Qj.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Qj.getParent() == null) {
            this.cPO.addView(this.Qj, layoutParams);
        }
        this.Qj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bfl();
        this.fxh.bcm().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.at.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (at.this.Qj != null && at.this.Qj.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (at.this.fGF == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, at.this.Qj.getId());
                            at.this.fGF = new com.baidu.tieba.pb.pb.main.emotion.c(at.this.fxh.getPageContext(), at.this.cPO, layoutParams2);
                            if (!com.baidu.tbadk.core.util.w.A(at.this.fGE)) {
                                at.this.fGF.setData(at.this.fGE);
                            }
                            at.this.fGF.b(at.this.Qj);
                        }
                        at.this.fGF.rz(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (at.this.fxh.fvo != null && at.this.fxh.fvo.bgx() != null) {
                    if (!at.this.fxh.fvo.bgx().bGB()) {
                        at.this.fxh.fvo.kI(false);
                    }
                    at.this.fxh.fvo.bgx().nA(false);
                }
            }
        });
    }

    public void bfC() {
        if (this.fxh != null && this.Qj != null) {
            this.Qj.oD();
            if (this.fxh.bcm() != null) {
                this.fxh.bcm().Ib();
            }
            bgg();
        }
    }

    public void N(String str, boolean z) {
        this.fFO = z;
        kw(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kw(boolean z) {
        if (this.fFM != null) {
            if (this.fFO) {
                com.baidu.tbadk.core.util.am.i(this.fFM, d.f.pb_praise_already_click_selector);
                this.fFM.setContentDescription(this.fxh.getResources().getString(d.k.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.am.i(this.fFM, d.f.pb_praise_normal_click_selector);
            this.fFM.setContentDescription(this.fxh.getResources().getString(d.k.zan));
        }
    }

    public TextView bfD() {
        return this.fFM;
    }

    public void kx(boolean z) {
        if (this.fEB != null && this.aIt != null && this.dlF != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dlF.setVisibility(0);
                } else {
                    this.dlF.setVisibility(8);
                    this.fEB.removeHeaderView(this.aIt);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aIt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fGd;
                    this.aIt.setLayoutParams(layoutParams);
                }
                bfR();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aIt.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kF(true);
                this.aIt.setLayoutParams(layoutParams2);
            }
            bfR();
            bgo();
        }
    }

    public f bfE() {
        return this.fFi;
    }

    public void a(PbActivity.d dVar) {
        this.fwm = dVar;
    }

    public void bi(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fFr == null) {
            this.fFr = LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
        }
        this.fxh.getLayoutMode().onModeChanged(this.fFr);
        if (this.fFq == null) {
            this.fFq = new Dialog(this.fxh.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fFq.setCanceledOnTouchOutside(true);
            this.fFq.setCancelable(true);
            this.fFq.setContentView(this.fFr);
            WindowManager.LayoutParams attributes = this.fFq.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ah(this.fxh.getPageContext().getPageActivity()) * 0.9d);
            this.fFq.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fFq.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fFq.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fFq.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFq != null && (at.this.fFq instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFq, at.this.fxh.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        at.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(d.g.tag_forbid_user_name)) && "".equals(sparseArray.get(d.g.tag_forbid_user_name_show))) || bgn()) {
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
                    if (at.this.fFq != null && (at.this.fFq instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFq, at.this.fxh.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && at.this.fGU != null) {
                        at.this.fGU.i(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id), sparseArray6.get(d.g.tag_forbid_user_name_show), sparseArray6.get(d.g.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFq != null && (at.this.fFq instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFq, at.this.fxh.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        at.this.fxh.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fFq, this.fxh.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fGU = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fxh != null && aVar != null) {
            if (this.dHz == null) {
                this.dHz = new com.baidu.tieba.NEGFeedBack.e(this.fxh.getPageContext(), this.fEC);
            }
            AntiData Cm = this.fxh.Cm();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (Cm != null && Cm.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Cm.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
            aiVar.a(sparseArray);
            this.dHz.setDefaultReasonArray(new String[]{this.fxh.getString(d.k.delete_thread_reason_1), this.fxh.getString(d.k.delete_thread_reason_2), this.fxh.getString(d.k.delete_thread_reason_3), this.fxh.getString(d.k.delete_thread_reason_4), this.fxh.getString(d.k.delete_thread_reason_5)});
            this.dHz.setData(aiVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.dHz.ib(str);
            this.dHz.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.at.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray) {
                    at.this.fxh.a(aVar, jSONArray);
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
        sparseArray.put(fGk, Integer.valueOf(fGl));
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
        this.fFs = new com.baidu.tbadk.core.dialog.a(this.fxh.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fFs.cd(i3);
        } else {
            this.fFs.aB(false);
            this.fFs.dE(str2);
        }
        this.fFs.C(sparseArray);
        this.fFs.a(d.k.dialog_ok, this.fxh);
        this.fFs.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fFs.aw(true);
        this.fFs.b(this.fxh.getPageContext());
        if (z) {
            this.fFs.xn();
        } else {
            a(this.fFs, i);
        }
    }

    public void as(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.fFv == null) {
            this.fFv = LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.commit_good, (ViewGroup) null);
        }
        this.fxh.getLayoutMode().onModeChanged(this.fFv);
        if (this.fFu == null) {
            this.fFu = new Dialog(this.fxh.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fFu.setCanceledOnTouchOutside(true);
            this.fFu.setCancelable(true);
            this.fFF = (ScrollView) this.fFv.findViewById(d.g.good_scroll);
            this.fFu.setContentView(this.fFv);
            WindowManager.LayoutParams attributes = this.fFu.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds540);
            this.fFu.getWindow().setAttributes(attributes);
            this.cyH = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.at.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        at.this.fFA = (String) compoundButton.getTag();
                        if (at.this.cyG != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : at.this.cyG) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && at.this.fFA != null && !str.equals(at.this.fFA)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fFw = (LinearLayout) this.fFv.findViewById(d.g.good_class_group);
            this.fFy = (TextView) this.fFv.findViewById(d.g.dialog_button_cancel);
            this.fFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFu instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(at.this.fFu, at.this.fxh.getPageContext());
                    }
                }
            });
            this.fFx = (TextView) this.fFv.findViewById(d.g.dialog_button_ok);
            this.fFx.setOnClickListener(this.dlq);
        }
        this.fFw.removeAllViews();
        this.cyG = new ArrayList();
        CustomBlueCheckRadioButton bU = bU("0", this.fxh.getPageContext().getString(d.k.thread_good_class));
        this.cyG.add(bU);
        bU.setChecked(true);
        this.fFw.addView(bU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i2);
                if (abVar != null && !TextUtils.isEmpty(abVar.ul()) && abVar.um() > 0) {
                    CustomBlueCheckRadioButton bU2 = bU(String.valueOf(abVar.um()), abVar.ul());
                    this.cyG.add(bU2);
                    View view = new View(this.fxh.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.am.j(view, d.C0142d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fFw.addView(view);
                    this.fFw.addView(bU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fFF.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxh.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxh.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxh.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fFF.setLayoutParams(layoutParams2);
            this.fFF.removeAllViews();
            if (this.fFw != null && this.fFw.getParent() == null) {
                this.fFF.addView(this.fFw);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fFu, this.fxh.getPageContext());
    }

    private CustomBlueCheckRadioButton bU(String str, String str2) {
        Activity pageActivity = this.fxh.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cyH);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bfF() {
        this.fxh.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fxh.hideProgressBar();
        if (z && z2) {
            this.fxh.showToast(this.fxh.getPageContext().getString(d.k.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.k.neterror);
            }
            this.fxh.showToast(str);
        }
    }

    public void aKF() {
        this.fFo.setVisibility(0);
    }

    public void aKE() {
        this.fFo.setVisibility(8);
    }

    public View bfG() {
        if (this.fFv != null) {
            return this.fFv.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bfH() {
        return this.fFA;
    }

    public View getView() {
        return this.cPO;
    }

    public void bfI() {
        com.baidu.adp.lib.util.l.b(this.fxh.getPageContext().getPageActivity(), this.fxh.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fxh.hideProgressBar();
        if (z) {
            bfX();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bfY();
        } else {
            bfX();
        }
    }

    public void bfJ() {
        this.doI.AD();
        this.doI.AH();
    }

    public void bfK() {
        this.fxh.hideProgressBar();
        AI();
        this.fEB.completePullRefreshPostDelayed(2000L);
        bfU();
    }

    public void bfL() {
        this.fEB.completePullRefreshPostDelayed(2000L);
        bfU();
    }

    private void ky(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fFJ.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fxh.getResources().getDimensionPixelSize(d.e.ds130) : this.fxh.getResources().getDimensionPixelSize(d.e.ds34);
        this.fFJ.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fFi.setOnLongClickListener(onLongClickListener);
        if (this.fGG != null) {
            this.fGG.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0104b interfaceC0104b, boolean z, boolean z2) {
        if (this.fFB != null) {
            this.fFB.dismiss();
            this.fFB = null;
        }
        this.fFB = new com.baidu.tbadk.core.dialog.b(this.fxh.getPageContext().getPageActivity());
        this.fFB.cg(d.k.operation);
        if (z2) {
            this.fFB.a(new String[]{this.fxh.getPageContext().getString(d.k.copy)}, interfaceC0104b);
        } else if (!z) {
            this.fFB.a(new String[]{this.fxh.getPageContext().getString(d.k.copy), this.fxh.getPageContext().getString(d.k.mark)}, interfaceC0104b);
        } else {
            this.fFB.a(new String[]{this.fxh.getPageContext().getString(d.k.copy), this.fxh.getPageContext().getString(d.k.remove_mark)}, interfaceC0104b);
        }
        this.fFB.d(this.fxh.getPageContext());
        this.fFB.xq();
    }

    public void a(b.InterfaceC0104b interfaceC0104b, boolean z) {
        if (this.fFC != null) {
            this.fFC.dismiss();
            this.fFC = null;
        }
        this.fFC = new com.baidu.tbadk.core.dialog.b(this.fxh.getPageContext().getPageActivity());
        this.fFC.cg(d.k.operation);
        if (z) {
            this.fFC.a(new String[]{this.fxh.getPageContext().getString(d.k.save_to_emotion)}, interfaceC0104b);
        } else {
            this.fFC.a(new String[]{this.fxh.getPageContext().getString(d.k.save_to_emotion), this.fxh.getPageContext().getString(d.k.save_to_local)}, interfaceC0104b);
        }
        this.fFC.d(this.fxh.getPageContext());
        this.fFC.xq();
    }

    public int bfM() {
        return qQ(this.fEB.getFirstVisiblePosition());
    }

    private int qQ(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fEB.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fEB.getAdapter() == null || !(this.fEB.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fEB.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bfN() {
        int lastVisiblePosition = this.fEB.getLastVisiblePosition();
        if (this.fEr != null) {
            if (lastVisiblePosition == this.fEB.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return qQ(lastVisiblePosition);
    }

    public void qR(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fEB != null) {
            if (this.fEx == null || this.fEx.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fEx.mNavigationBar.getFixedNavHeight();
                if (this.fxh.bcC() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fGb != null && (layoutParams = (LinearLayout.LayoutParams) this.fGb.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fGb.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fEB.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fEB.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fFl.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fFi.a(dVar, false);
        this.fFi.notifyDataSetChanged();
        bfU();
        if (this.fGG != null) {
            this.fGG.bbW();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fER == null) {
            this.fxh.getLayoutMode().onModeChanged(((ViewStub) this.fEC.findViewById(d.g.praise_layout)).inflate());
            this.fER = (FrsPraiseView) this.fEC.findViewById(d.g.pb_head_praise_view);
            this.fER.setIsFromPb(true);
            this.fFg = this.fEC.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fER.dD(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fER != null) {
            boolean bfU = bfU();
            this.fER.setVisibility(8);
            if (dVar != null && dVar.uJ() != null && dVar.uJ().uG() == 0 && this.fxy) {
                if (bfU) {
                    this.fFf.setVisibility(0);
                    return;
                } else {
                    this.fFf.setVisibility(8);
                    return;
                }
            }
            this.fFf.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bbf() != null) {
            return dVar.bbf();
        }
        if (!com.baidu.tbadk.core.util.w.A(dVar.baX())) {
            Iterator<PostData> it = dVar.baX().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bxC() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bbc();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.vw() != null && postData.vw().getUserTbVipInfoData() != null && postData.vw().getUserTbVipInfoData().getvipIntro() != null) {
            postData.vw().getGodUserData().setIntro(postData.vw().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.baV() == null || dVar.baV().vw() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData vw = dVar.baV().vw();
        String userId = vw.getUserId();
        HashMap<String, MetaData> userMap = dVar.baV().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = vw;
        }
        postData.tL(1);
        postData.setId(dVar.baV().vM());
        postData.setTitle(dVar.baV().getTitle());
        postData.setTime(dVar.baV().getCreateTime());
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
        com.baidu.tbadk.data.f bxF;
        String portrait;
        if (dVar != null && dVar.baV() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fEH.setVisibility(8);
            if (dVar.baV() != null && dVar.baV().wh() && dVar.baV().vN() != null) {
                this.fGv = true;
                this.fEx.kU(this.fGv);
                this.fEx.mNavigationBar.hideBottomLine();
                if (this.fEr == null) {
                    this.fEr = new com.baidu.tieba.pb.video.i(this.fxh, this.fEx, dVar.baV().vN(), this.fEs);
                    this.fEr.a(dVar.baV().vN(), dVar.baV(), dVar.getForumId());
                    this.fEr.startPlay();
                } else if (this.fEv) {
                    this.fEr.a(dVar.baV().vN(), dVar.baV(), dVar.getForumId());
                    this.fEr.startPlay();
                } else {
                    this.fEr.rL(dVar.getForumId());
                }
                if (dVar.baW() != null && dVar.baW().size() >= 1) {
                    bc bcVar = dVar.baW().get(0);
                    this.fEr.aq(bcVar);
                    this.fEr.rM(bcVar.getTitle());
                }
                this.fEr.b(b, dVar.baV(), dVar.bbs());
                this.fEv = false;
                this.fEB.removeHeaderView(this.fEr.bie());
                this.fEB.addHeaderView(this.fEr.bie(), 0);
                if (this.fEr.bic() != null && this.fEr.bic().getParent() == null) {
                    this.fFZ.addView(this.fEr.bic());
                }
                if (this.fEt == null) {
                    this.fEt = new com.baidu.tieba.pb.video.h(this.fxh);
                }
                this.fEt.a(dVar.baV().ww(), dVar.baV(), dVar.bbp());
                this.fEB.removeHeaderView(this.fEt.bhT());
                this.fEB.addHeaderView(this.fEt.bhT(), 1);
                if (dVar.baV().ww() != null) {
                    this.fEB.removeHeaderView(this.fEt.bhU());
                    this.fEB.removeHeaderView(this.fEF);
                    this.fEB.addHeaderView(this.fEt.bhU(), 2);
                } else {
                    if (this.fEt.bhU() != null) {
                        this.fEB.removeHeaderView(this.fEt.bhU());
                    }
                    this.fEB.removeHeaderView(this.fEF);
                    this.fEF.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.fxh, d.e.tbds56));
                    this.fEB.addHeaderView(this.fEF, 2);
                }
                if (this.fEr != null) {
                    this.fEx.kO(false);
                    this.fEx.kQ(TbadkCoreApplication.isLogin());
                    this.fEr.qY(TbadkCoreApplication.getInst().getSkinType());
                }
                bfR();
            } else {
                this.fGv = false;
                this.fEx.kU(this.fGv);
                if (this.fEr != null) {
                    this.fEB.removeHeaderView(this.fEr.bie());
                }
                if (this.fEt != null) {
                    this.fEt.b(this.fEB);
                }
                if (b == null || (b != null && (b.bxE() == null || com.baidu.tbadk.core.util.w.A(b.bxE().Nz())))) {
                    this.fEF.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.fxh, d.e.tbds80));
                } else {
                    this.fEF.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fxh.bcq() != null) {
                this.fxh.bcq().kM(this.fGv);
            }
            if (this.fEr != null) {
                this.fEr.N(this.fGW);
            }
            if (b != null) {
                this.fFR = b;
                this.fEH.setVisibility(0);
                if (this.fxh.bdb()) {
                    if (dVar.baU() != null) {
                        this.mForumName = dVar.baU().getForumName();
                        this.mForumId = dVar.baU().getForumId();
                    }
                    if (this.mForumName == null && this.fxh.bca() != null && this.fxh.bca().bdO() != null) {
                        this.mForumName = this.fxh.bca().bdO();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fEH.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fEH.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fGL) {
                    this.fED.setVisibility(0);
                }
                if (!dVar.baV().wh() && this.fEE.getText() != null && this.fEE.getText().length() > 0) {
                    this.fEE.setVisibility(0);
                } else {
                    this.fEE.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> vH = dVar.baV().vH();
                if (vH != null && vH.size() > 0 && !this.fGL) {
                    this.fFU.setText(String.valueOf(vH.get(0).tR()));
                    this.fFT.setVisibility(0);
                } else {
                    this.fFT.setVisibility(8);
                }
                com.baidu.tbadk.core.util.am.i(this.fFT, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.am.c(this.fFU, d.C0142d.cp_link_tip_d, 1);
                if (b.vw() != null) {
                    String string = b.vw().getName_show() == null ? StringUtils.string(b.vw().getUserName()) : StringUtils.string(b.vw().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.vw().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bi(b.vw().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bi(string) > 12) {
                            e = com.baidu.tbadk.core.util.ap.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.vw().getIconInfo();
                            tShowInfoNew = b.vw().getTShowInfoNew();
                            if (this.fyx != null) {
                                this.fyx.setTag(d.g.tag_user_id, b.vw().getUserId());
                                this.fyx.setOnClickListener(this.fxh.fvk.fIH);
                                this.fyx.a(iconInfo, 4, this.fxh.getResources().getDimensionPixelSize(d.e.tbds36), this.fxh.getResources().getDimensionPixelSize(d.e.tbds36), this.fxh.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fyw != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fyw.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fyw.setOnClickListener(this.fxh.fvk.fII);
                                this.fyw.a(tShowInfoNew, 3, this.fxh.getResources().getDimensionPixelSize(d.e.tbds36), this.fxh.getResources().getDimensionPixelSize(d.e.tbds36), this.fxh.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fEJ.setText(ak(b.vw().getSealPrefix(), e));
                            this.fEJ.setTag(d.g.tag_user_id, b.vw().getUserId());
                            this.fEJ.setTag(d.g.tag_user_name, b.vw().getName_show());
                            if (com.baidu.tbadk.core.util.w.A(tShowInfoNew) || b.vw().isBigV()) {
                                com.baidu.tbadk.core.util.am.c(this.fEJ, d.C0142d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.am.c(this.fEJ, d.C0142d.cp_cont_f, 1);
                            }
                            this.fEK.setVisibility(8);
                            if (dVar.baV().vw() != null && dVar.baV().vw().getAlaUserData() != null && this.fEP != null) {
                                if (dVar.baV().vw().getAlaUserData().anchor_live != 0) {
                                    this.fEP.setVisibility(8);
                                } else {
                                    this.fEP.setVisibility(0);
                                    if (this.fEu == null) {
                                        this.fEu = new com.baidu.tieba.c.d(this.fxh.getPageContext(), this.fEP);
                                        this.fEu.jf(1);
                                    }
                                    this.fEu.aQ(this.fxh.getResources().getString(d.k.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aan = dVar.baV().vw().getAlaUserData();
                                    aVar.type = 2;
                                    this.fEP.setTag(aVar);
                                }
                            }
                            this.fEO.setUserId(b.vw().getUserId());
                            this.fEO.setUserName(b.vw().getUserName());
                            this.fEO.setImageDrawable(null);
                            this.fEO.setRadius(com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds40));
                            this.fEO.setTag(b.vw().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fEX.setText(com.baidu.tbadk.core.util.ap.x(b.getTime()));
                            } else {
                                this.fEX.setText(com.baidu.tbadk.core.util.ap.w(b.getTime()));
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds16);
                            if (!this.fxh.bdb() && !StringUtils.isNull(this.mForumName)) {
                                this.ayD.setText(this.fxh.getString(d.k.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.ayD.setVisibility(0);
                                this.fFa.setVisibility(0);
                                this.fEX.setPadding(e2, 0, e2, 0);
                            } else {
                                this.ayD.setVisibility(8);
                                this.fFa.setVisibility(8);
                                this.fEX.setPadding(0, 0, e2, 0);
                            }
                            bxF = b.bxF();
                            if (bxF == null && !TextUtils.isEmpty(bxF.getName()) && !TextUtils.isEmpty(bxF.getName().trim())) {
                                final String name = bxF.getName();
                                final String lat = bxF.getLat();
                                final String lng = bxF.getLng();
                                this.fEY.setVisibility(0);
                                this.fEZ.setVisibility(0);
                                this.fEY.setText(bxF.getName());
                                this.fEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.jD()) {
                                                at.this.fxh.showToast(d.k.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.O(at.this.fxh.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, at.this.fxh.getPageContext().getString(d.k.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fEY.setVisibility(8);
                                this.fEZ.setVisibility(8);
                            }
                            portrait = b.vw().getPortrait();
                            if (b.vw().getPendantData() == null && !StringUtils.isNull(b.vw().getPendantData().uh())) {
                                UtilHelper.showHeadImageViewBigV(this.fEM.getHeadView(), b.vw());
                                this.fEO.setVisibility(8);
                                this.fEM.setVisibility(0);
                                if (this.fES != null) {
                                    this.fES.setVisibility(8);
                                }
                                this.fEJ.setOnClickListener(this.fGW);
                                this.fEM.getHeadView().startLoad(portrait, 28, false);
                                this.fEM.getHeadView().setUserId(b.vw().getUserId());
                                this.fEM.getHeadView().setUserName(b.vw().getUserName());
                                this.fEM.getHeadView().setOnClickListener(this.fGW);
                                this.fEM.fn(b.vw().getPendantData().uh());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fEO, b.vw());
                                this.fEO.setVisibility(0);
                                this.fEH.setOnClickListener(this.fGW);
                                this.fEJ.setOnClickListener(this.fGW);
                                this.fEO.setOnClickListener(this.fGW);
                                this.fEM.setVisibility(8);
                                this.fEO.startLoad(portrait, 28, false);
                            }
                            String name_show = b.vw().getName_show();
                            String userName = b.vw().getUserName();
                            if (com.baidu.tbadk.o.ai.ip() && name_show != null && !name_show.equals(userName)) {
                                this.fEJ.setText(com.baidu.tieba.pb.c.aj(this.fxh.getPageContext().getPageActivity(), this.fEJ.getText().toString()));
                                this.fEJ.setGravity(16);
                                this.fEJ.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.baD());
                                com.baidu.tbadk.core.util.am.c(this.fEJ, d.C0142d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.vw().getIconInfo();
                        tShowInfoNew = b.vw().getTShowInfoNew();
                        if (this.fyx != null) {
                        }
                        if (this.fyw != null) {
                        }
                        this.fEJ.setText(ak(b.vw().getSealPrefix(), e));
                        this.fEJ.setTag(d.g.tag_user_id, b.vw().getUserId());
                        this.fEJ.setTag(d.g.tag_user_name, b.vw().getName_show());
                        if (com.baidu.tbadk.core.util.w.A(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.c(this.fEJ, d.C0142d.cp_cont_h, 1);
                        this.fEK.setVisibility(8);
                        if (dVar.baV().vw() != null) {
                            if (dVar.baV().vw().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fEO.setUserId(b.vw().getUserId());
                        this.fEO.setUserName(b.vw().getUserName());
                        this.fEO.setImageDrawable(null);
                        this.fEO.setRadius(com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds40));
                        this.fEO.setTag(b.vw().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds16);
                        if (!this.fxh.bdb()) {
                        }
                        this.ayD.setVisibility(8);
                        this.fFa.setVisibility(8);
                        this.fEX.setPadding(0, 0, e2, 0);
                        bxF = b.bxF();
                        if (bxF == null) {
                        }
                        this.fEY.setVisibility(8);
                        this.fEZ.setVisibility(8);
                        portrait = b.vw().getPortrait();
                        if (b.vw().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fEO, b.vw());
                        this.fEO.setVisibility(0);
                        this.fEH.setOnClickListener(this.fGW);
                        this.fEJ.setOnClickListener(this.fGW);
                        this.fEO.setOnClickListener(this.fGW);
                        this.fEM.setVisibility(8);
                        this.fEO.startLoad(portrait, 28, false);
                        String name_show2 = b.vw().getName_show();
                        String userName2 = b.vw().getUserName();
                        if (com.baidu.tbadk.o.ai.ip()) {
                            this.fEJ.setText(com.baidu.tieba.pb.c.aj(this.fxh.getPageContext().getPageActivity(), this.fEJ.getText().toString()));
                            this.fEJ.setGravity(16);
                            this.fEJ.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.baD());
                            com.baidu.tbadk.core.util.am.c(this.fEJ, d.C0142d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bi(string) > 14) {
                            e = com.baidu.tbadk.core.util.ap.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.vw().getIconInfo();
                            tShowInfoNew = b.vw().getTShowInfoNew();
                            if (this.fyx != null) {
                            }
                            if (this.fyw != null) {
                            }
                            this.fEJ.setText(ak(b.vw().getSealPrefix(), e));
                            this.fEJ.setTag(d.g.tag_user_id, b.vw().getUserId());
                            this.fEJ.setTag(d.g.tag_user_name, b.vw().getName_show());
                            if (com.baidu.tbadk.core.util.w.A(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.am.c(this.fEJ, d.C0142d.cp_cont_h, 1);
                            this.fEK.setVisibility(8);
                            if (dVar.baV().vw() != null) {
                            }
                            this.fEO.setUserId(b.vw().getUserId());
                            this.fEO.setUserName(b.vw().getUserName());
                            this.fEO.setImageDrawable(null);
                            this.fEO.setRadius(com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds40));
                            this.fEO.setTag(b.vw().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds16);
                            if (!this.fxh.bdb()) {
                            }
                            this.ayD.setVisibility(8);
                            this.fFa.setVisibility(8);
                            this.fEX.setPadding(0, 0, e2, 0);
                            bxF = b.bxF();
                            if (bxF == null) {
                            }
                            this.fEY.setVisibility(8);
                            this.fEZ.setVisibility(8);
                            portrait = b.vw().getPortrait();
                            if (b.vw().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fEO, b.vw());
                            this.fEO.setVisibility(0);
                            this.fEH.setOnClickListener(this.fGW);
                            this.fEJ.setOnClickListener(this.fGW);
                            this.fEO.setOnClickListener(this.fGW);
                            this.fEM.setVisibility(8);
                            this.fEO.startLoad(portrait, 28, false);
                            String name_show22 = b.vw().getName_show();
                            String userName22 = b.vw().getUserName();
                            if (com.baidu.tbadk.o.ai.ip()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.vw().getIconInfo();
                        tShowInfoNew = b.vw().getTShowInfoNew();
                        if (this.fyx != null) {
                        }
                        if (this.fyw != null) {
                        }
                        this.fEJ.setText(ak(b.vw().getSealPrefix(), e));
                        this.fEJ.setTag(d.g.tag_user_id, b.vw().getUserId());
                        this.fEJ.setTag(d.g.tag_user_name, b.vw().getName_show());
                        if (com.baidu.tbadk.core.util.w.A(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.c(this.fEJ, d.C0142d.cp_cont_h, 1);
                        this.fEK.setVisibility(8);
                        if (dVar.baV().vw() != null) {
                        }
                        this.fEO.setUserId(b.vw().getUserId());
                        this.fEO.setUserName(b.vw().getUserName());
                        this.fEO.setImageDrawable(null);
                        this.fEO.setRadius(com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds40));
                        this.fEO.setTag(b.vw().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.fxh.getActivity(), d.e.ds16);
                        if (!this.fxh.bdb()) {
                        }
                        this.ayD.setVisibility(8);
                        this.fFa.setVisibility(8);
                        this.fEX.setPadding(0, 0, e2, 0);
                        bxF = b.bxF();
                        if (bxF == null) {
                        }
                        this.fEY.setVisibility(8);
                        this.fEZ.setVisibility(8);
                        portrait = b.vw().getPortrait();
                        if (b.vw().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fEO, b.vw());
                        this.fEO.setVisibility(0);
                        this.fEH.setOnClickListener(this.fGW);
                        this.fEJ.setOnClickListener(this.fGW);
                        this.fEO.setOnClickListener(this.fGW);
                        this.fEM.setVisibility(8);
                        this.fEO.startLoad(portrait, 28, false);
                        String name_show222 = b.vw().getName_show();
                        String userName222 = b.vw().getUserName();
                        if (com.baidu.tbadk.o.ai.ip()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fEG.ai(dVar.baV());
                }
                if (this.fGc != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fsV);
                    if (dVar != null && dVar.baV() != null) {
                        hVar.fsX = dVar.baV().vn();
                    }
                    hVar.isNew = !this.fxy;
                    hVar.fsZ = this.fxh.bda();
                    this.fGc.a(hVar);
                }
            }
        }
    }

    public void kz(boolean z) {
        if (z) {
            bfO();
        } else {
            aox();
        }
        this.fGg.fHn = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGg));
        a(this.fGg.fHn, false);
    }

    public void bfO() {
        if (this.fEx != null && !this.fGx) {
            this.fEx.kV(!StringUtils.isNull(this.fxh.bcz()));
            this.fGx = true;
        }
    }

    public void aox() {
        if (this.fEx != null) {
            this.fEx.bgT();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.vQ() != null) {
            this.fEI.setData(this.fxh.getPageContext(), dVar.baX().get(0).vQ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.baT().getId(), dVar.baT().getName(), dVar.baV().getId(), this.fxh.bcX() ? "FRS" : null));
            this.fEH.setPadding(this.fEH.getPaddingLeft(), (int) this.fxh.getResources().getDimension(d.e.ds20), this.fEH.getPaddingRight(), this.fEH.getPaddingBottom());
            return;
        }
        this.fEI.setData(null, null, null);
    }

    public void bfP() {
        if (this.fEr != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11997").r("obj_type", 1));
            this.fEr.bid();
            this.fEB.smoothScrollToPosition(0);
        }
    }

    public boolean bfQ() {
        return this.fGX;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean ak(bc bcVar) {
        if (bcVar == null || bcVar.vw() == null || bcVar.vw().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bcVar.vw().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fEx.bgR();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fEx.pg(cVar.forumName);
            }
            String string = this.fxh.getResources().getString(d.k.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(cVar.source, 0)) {
                case 100:
                    str = this.fxh.getResources().getString(d.k.self);
                    break;
                case 300:
                    str = this.fxh.getResources().getString(d.k.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fxh.getResources().getString(d.k.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fsg;
            this.fxh.showNetRefreshView(this.cPO, format, null, this.fxh.getResources().getString(d.k.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.jU()) {
                        az.zV().c(at.this.fxh.getPageContext(), new String[]{str2});
                        at.this.fxh.finish();
                        return;
                    }
                    at.this.fxh.showToast(d.k.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable beY;
        Parcelable beY2;
        String str;
        if (dVar != null) {
            this.fAN = dVar;
            this.mType = i;
            if (dVar.baV() != null) {
                this.fGi = dVar.baV().vf();
                if (dVar.baV().getAnchorLevel() != 0) {
                    this.fGX = true;
                }
                this.fFE = ak(dVar.baV());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fFS = false;
            this.fxy = z;
            bfK();
            b(dVar, z, i);
            p(dVar);
            if (this.fGJ == null) {
                this.fGJ = new ac(this.fxh.getPageContext(), this.dED);
            }
            this.fGJ.rr(dVar.bba());
            if (this.fxh.bcO()) {
                if (this.fFm == null) {
                    this.fFm = new com.baidu.tieba.pb.view.e(this.fxh.getPageContext());
                    this.fFm.nn();
                    this.fFm.a(this.awQ);
                }
                this.fEB.setPullRefresh(this.fFm);
                bfR();
                if (this.fFm != null) {
                    this.fFm.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.uJ().uG() == 0 && z) {
                this.fEB.setPullRefresh(null);
            } else {
                if (this.fFm == null) {
                    this.fFm = new com.baidu.tieba.pb.view.e(this.fxh.getPageContext());
                    this.fFm.nn();
                    this.fFm.a(this.awQ);
                }
                this.fEB.setPullRefresh(this.fFm);
                bfR();
                if (this.fFm != null) {
                    this.fFm.dz(TbadkCoreApplication.getInst().getSkinType());
                }
                aeB();
            }
            bfU();
            this.fFi.jI(this.fxy);
            this.fFi.jJ(false);
            this.fFi.jU(i == 5);
            this.fFi.jV(i == 6);
            this.fFi.jW(z2 && this.fGV);
            this.fFi.a(dVar, false);
            this.fFi.notifyDataSetChanged();
            if (this.fxh.bdb()) {
                this.fGz = 0;
                PostData b = b(dVar, z);
                if (b != null && b.vw() != null) {
                    this.fGz = b.vw().getLevel_id();
                }
                if (this.fGz > 0) {
                    this.fEL.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(this.fEL, BitmapHelper.getGradeResourceIdInEnterForum(this.fGz));
                } else {
                    this.fEL.setVisibility(8);
                }
            } else {
                this.fEL.setVisibility(8);
            }
            if (dVar.baV() != null) {
                if (dVar.baV().vj() != null) {
                    if (dVar.baV().vj().getNum() < 1) {
                        str = this.fxh.getResources().getString(d.k.zan);
                    } else {
                        str = dVar.baV().vj().getNum() + "";
                    }
                    if (this.fEq != -1) {
                        dVar.baV().vj().setIsLike(this.fEq);
                    }
                    N(str, dVar.baV().vj().getIsLike() == 1);
                }
                if (dVar.baV().akk != null && dVar.baV().akk.isDeleted) {
                    this.fEx.kP(true);
                } else {
                    this.fEx.kP(false);
                }
            }
            if (this.fxh.isLogin()) {
                this.fEB.setNextPage(this.doI);
                this.fEw = 2;
                aeB();
            } else {
                this.fFS = true;
                if (dVar.uJ().uF() == 1) {
                    if (this.fFn == null) {
                        this.fFn = new com.baidu.tieba.pb.view.a(this.fxh.getPageContext());
                    }
                    this.fEB.setNextPage(this.fFn);
                } else {
                    this.fEB.setNextPage(this.doI);
                }
                this.fEw = 3;
            }
            ArrayList<PostData> baX = dVar.baX();
            if (dVar.uJ().uF() == 0 || baX == null || baX.size() < dVar.uJ().uE()) {
                if (com.baidu.tbadk.core.util.w.z(baX) == 0 || (com.baidu.tbadk.core.util.w.z(baX) == 1 && baX.get(0) != null && baX.get(0).bxC() == 1)) {
                    this.doI.setText(this.fxh.getResources().getString(d.k.list_no_more_new));
                    if (this.fxh.bcq() != null && !this.fxh.bcq().bgH()) {
                        this.fxh.bcq().showFloatingView();
                    }
                } else if (dVar.uJ().uF() == 0) {
                    this.doI.setText(this.fxh.getResources().getString(d.k.list_has_no_more));
                } else {
                    this.doI.setText(this.fxh.getResources().getString(d.k.load_more));
                }
                if (this.fxh.bcO() && this.fEB != null && this.fEB.getData() != null && this.fEB.getData().size() == 1 && (this.fEB.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.doI.setText("");
                }
                bgb();
            } else if (z2) {
                if (this.fGV) {
                    AI();
                    if (dVar.uJ().uF() != 0) {
                        this.doI.setText(this.fxh.getResources().getString(d.k.pb_load_more));
                    }
                } else {
                    this.doI.AD();
                    this.doI.showLoading();
                }
            } else {
                this.doI.AD();
                this.doI.showLoading();
            }
            switch (i) {
                case 2:
                    this.fEB.setSelection(i2 > 1 ? (((this.fEB.getData() == null && dVar.baX() == null) ? 0 : (this.fEB.getData().size() - dVar.baX().size()) + this.fEB.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (beY2 = aj.beX().beY()) != null) {
                        this.fEB.onRestoreInstanceState(beY2);
                        if (com.baidu.tbadk.core.util.w.z(baX) > 1 && dVar.uJ().uF() > 0) {
                            this.doI.AI();
                            this.doI.setText(this.fxh.getString(d.k.pb_load_more_without_point));
                            this.doI.AE();
                            break;
                        }
                    } else {
                        this.fEB.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fGV = false;
                    break;
                case 5:
                    this.fEB.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (beY = aj.beX().beY()) != null) {
                        this.fEB.onRestoreInstanceState(beY);
                        break;
                    } else {
                        this.fEB.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.fEr != null && this.fEr.bic() != null) {
                            if (this.fxh.isUseStyleImmersiveSticky()) {
                                this.fEB.setSelectionFromTop((this.fFi.bdt() + this.fEB.getHeaderViewsCount()) - 1, this.fEr.bic().getHeight() - com.baidu.adp.lib.util.l.o(this.fxh.getPageContext().getPageActivity()));
                            } else {
                                this.fEB.setSelectionFromTop((this.fFi.bdt() + this.fEB.getHeaderViewsCount()) - 1, this.fEr.bic().getHeight());
                            }
                        } else {
                            this.fEB.setSelection(this.fFi.bdt() + this.fEB.getHeaderViewsCount());
                        }
                    } else {
                        this.fEB.setSelection(i2 > 0 ? ((this.fEB.getData() == null && dVar.baX() == null) ? 0 : (this.fEB.getData().size() - dVar.baX().size()) + this.fEB.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.doI.AI();
                    this.doI.setText(this.fxh.getString(d.k.pb_load_more_without_point));
                    this.doI.AE();
                    break;
            }
            if (this.fGi == fGj && isHost()) {
                bgj();
            }
            if (this.fGt) {
                bfj();
                this.fGt = false;
                if (i3 == 0) {
                    ks(true);
                }
            }
            if (this.fEt != null) {
                this.fEt.ap(dVar.baV());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fsM == 1 || dVar.fsN == 1) {
                if (this.fGA == null) {
                    this.fGA = new PbTopTipView(this.fxh);
                }
                if (dVar.fsN == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fxh.getStType())) {
                    this.fGA.setText(this.fxh.getString(d.k.pb_read_strategy_add_experience));
                    this.fGA.show(this.cPO, this.mSkinType);
                } else if (dVar.fsM == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fxh.getStType())) {
                    this.fGA.setText(this.fxh.getString(d.k.pb_read_news_add_experience));
                    this.fGA.show(this.cPO, this.mSkinType);
                }
            }
        }
    }

    private void bfR() {
        if (this.fEr != null && this.fEr.bic() != null) {
            this.fEB.removeHeaderView(this.aIt);
            if (this.mType != 1) {
                this.fEB.removeHeaderView(this.fEr.bie());
                this.fEB.addHeaderView(this.fEr.bie(), 0);
                return;
            }
            return;
        }
        if (this.fEr != null) {
            this.fEB.removeHeaderView(this.fEr.bie());
        }
        this.fEB.removeHeaderView(this.aIt);
        this.fEB.addHeaderView(this.aIt, 0);
    }

    public void kA(boolean z) {
        this.fFD = z;
    }

    public void AI() {
        if (this.doI != null) {
            this.doI.AE();
            this.doI.AI();
        }
        aeB();
    }

    public void showListView() {
        this.fEB.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fFR != null && this.fFR.vw() != null && this.fEx != null) {
            this.fGw = !this.fGv;
            this.fEx.kO(this.fGw);
            if (this.fxh.bcq() != null) {
                this.fxh.bcq().kN(this.fGw);
            }
            bfS();
            if (this.fGw) {
                this.fEx.fJv.setVisibility(0);
                if (this.fFE) {
                    this.fEx.fJw.setVisibility(8);
                    this.fET.setVisibility(8);
                    this.fEW.setVisibility(0);
                    this.fEW.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.ap.C(dVar.bbr())));
                } else if (!PbNormalLikeButtonSwitchStatic.Lc() || (this.fFR.vw().hadConcerned() && this.fFR.vw().getGodUserData() != null && this.fFR.vw().getGodUserData().getIsFromNetWork())) {
                    this.fEx.fJw.setVisibility(8);
                }
                if (this.fGb != null) {
                    this.fGb.setVisibility(8);
                }
                this.fEx.a(this.fFR.vw(), this.fGW);
                if (this.fGH == null) {
                    this.fGH = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.at.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > at.this.fGy) {
                                at.this.bgi();
                            }
                        }
                    };
                }
                this.fEB.setListViewDragListener(this.fGH);
                return;
            }
            if (this.fEx.fJv != null) {
                this.fEx.fJv.setVisibility(8);
            }
            if (this.fGb != null) {
                this.fGb.setVisibility(0);
            }
            if (this.fFE) {
                this.fET.setVisibility(8);
                this.fEW.setVisibility(0);
                this.fEW.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.ap.C(dVar.bbr())));
            } else if (!PbNormalLikeButtonSwitchStatic.Lc() || (this.fFR.vw().hadConcerned() && this.fFR.vw().getGodUserData() != null && this.fFR.vw().getGodUserData().getIsFromNetWork())) {
                this.fET.setVisibility(8);
                this.fEW.setVisibility(8);
            } else {
                this.fEW.setVisibility(8);
            }
            this.fGH = null;
            this.fEB.setListViewDragListener(null);
        }
    }

    private void bfS() {
        String threadId = this.fAN != null ? this.fAN.getThreadId() : "";
        int bfT = bfT();
        if (this.fGw) {
            if (this.fEV == null) {
                this.fEV = new ar(this.fxh.getPageContext(), this.fEx.fJw, 3);
                this.fEV.h(this.fxh.getUniqueId());
            }
            if (this.fFR != null && this.fFR.vw() != null) {
                this.fFR.vw().setIsLike(this.fFR.vw().hadConcerned());
                this.fEV.a(this.fFR.vw());
            }
            this.fEV.dk(threadId);
            this.fEV.qP(bfT);
            this.fEV.fEm = this.fGv;
        }
        if (this.fEU == null) {
            this.fEU = new ar(this.fxh.getPageContext(), this.fET, 1);
            this.fEU.h(this.fxh.getUniqueId());
            this.fEU.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.at.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aY(boolean z) {
                    if (at.this.fxh != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(at.this.fxh, d.k.attention_success);
                            return;
                        }
                        as.v(at.this.fxh.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fFR != null && this.fFR.vw() != null) {
            this.fFR.vw().setIsLike(this.fFR.vw().hadConcerned());
            this.fEU.a(this.fFR.vw());
            this.fEU.dk(threadId);
        }
        this.fEU.fEm = this.fGv;
        this.fEU.qP(bfT);
    }

    private int bfT() {
        if (this.fAN == null || this.fAN.baV() == null) {
            return 0;
        }
        if (this.fAN.baV().wE()) {
            return (com.baidu.tbadk.core.util.w.A(this.fAN.bbq()) && (this.fAN.baU() == null || StringUtils.isNull(this.fAN.baU().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bfU() {
        boolean z;
        if (this.fFH != null && this.fFH.getVisibility() == 0) {
            if (this.fFe != null) {
                this.fFe.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fFe != null) {
                this.fFe.setVisibility(8);
            }
            z = false;
        }
        if ((this.fFg == null || this.fFg.getVisibility() == 8) && z && this.fxy) {
            this.fFf.setVisibility(0);
        } else {
            this.fFf.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.baV() == null) {
            return false;
        }
        if (dVar.baV().vt() == 1 || dVar.baV().getThreadType() == 33) {
            return true;
        }
        return !(dVar.baV().vv() == null || dVar.baV().vv().xb() == 0) || dVar.baV().vr() == 1 || dVar.baV().vs() == 1 || dVar.baV().vZ() || dVar.baV().wl() || dVar.baV().wg() || dVar.baV().vI() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.baV().getCategory()) || dVar.baV().vz() || dVar.baV().vy();
    }

    private SpannableStringBuilder ak(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fxh.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fED != null) {
                if (dVar.baV() != null && dVar.baV().vL() == 0 && !dVar.baV().wh() && !this.fGL) {
                    this.fED.setVisibility(0);
                    if (dVar.baV() != null) {
                        bc baV = dVar.baV();
                        baV.e(true, q(dVar));
                        baV.setResource(3);
                        baV.m13do("2");
                    }
                    SpannableStringBuilder vU = dVar.baV().vU();
                    this.fEE.setOnTouchListener(new com.baidu.tieba.view.k(vU));
                    if (this.fGI) {
                        this.fEE.setText(dVar.baV().getTitle());
                    } else {
                        this.fEE.setText(vU);
                    }
                    this.fEE.setVisibility(0);
                } else if (dVar.baV().vL() == 1) {
                    if (dVar.baV() != null) {
                        this.fED.setVisibility(8);
                        this.fEB.removeHeaderView(this.fED);
                        if (dVar.baV() != null && !dVar.baV().wh()) {
                            this.fEH.setPadding(this.fEH.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.tbds36), this.fEH.getPaddingRight(), this.fEH.getPaddingBottom());
                        }
                    }
                } else {
                    this.fED.setVisibility(8);
                    this.fEB.removeHeaderView(this.fED);
                    if (dVar.baV() != null && dVar.baV().wh()) {
                        this.fEH.setPadding(this.fEH.getPaddingLeft(), 0, this.fEH.getPaddingRight(), this.fEH.getPaddingBottom());
                    } else {
                        this.fEH.setPadding(this.fEH.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds48), this.fEH.getPaddingRight(), this.fEH.getPaddingBottom());
                    }
                }
            }
            this.fxy = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bfU();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.u uVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.vw().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.bbh()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.vw() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.vw().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_name_show, b.vw().getName_show());
                    sparseArray.put(d.g.tag_forbid_user_portrait, b.vw().getPortrait());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.bbh()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.az> bbq = dVar.bbq();
                if (com.baidu.tbadk.core.util.w.z(bbq) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.az azVar : bbq) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ahV) != null && uVar.afV && !uVar.isDeleted && (uVar.type == 1 || uVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.fxh.getString(d.k.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fxh.getString(d.k.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.aTf;
    }

    public void rs(String str) {
        if (this.doI != null) {
            this.doI.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fEB;
    }

    public int bfV() {
        return d.g.richText;
    }

    public TextView bcl() {
        return this.fEG.bcl();
    }

    public void e(BdListView.e eVar) {
        this.fEB.setOnSrollToBottomListener(eVar);
    }

    public void a(g.b bVar) {
        this.awQ = bVar;
        if (this.fFm != null) {
            this.fFm.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.am amVar, a.b bVar) {
        if (amVar != null) {
            int uD = amVar.uD();
            int uA = amVar.uA();
            if (this.fFj != null) {
                this.fFj.xn();
            } else {
                this.fFj = new com.baidu.tbadk.core.dialog.a(this.fxh.getPageContext().getPageActivity());
                this.fFk = LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.dialog_direct_pager, (ViewGroup) null);
                this.fFj.w(this.fFk);
                this.fFj.a(d.k.dialog_ok, bVar);
                this.fFj.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        at.this.bfX();
                        aVar.dismiss();
                    }
                });
                this.fFj.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.at.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (at.this.fGq == null) {
                            at.this.fGq = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    at.this.fxh.HidenSoftKeyPad((InputMethodManager) at.this.fxh.getSystemService("input_method"), at.this.cPO);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.im().postDelayed(at.this.fGq, 150L);
                    }
                });
                this.fFj.b(this.fxh.getPageContext()).xn();
            }
            this.fFl = (EditText) this.fFk.findViewById(d.g.input_page_number);
            this.fFl.setText("");
            TextView textView = (TextView) this.fFk.findViewById(d.g.current_page_number);
            if (uD <= 0) {
                uD = 1;
            }
            if (uA <= 0) {
                uA = 1;
            }
            textView.setText(MessageFormat.format(this.fxh.getApplicationContext().getResources().getString(d.k.current_page), Integer.valueOf(uD), Integer.valueOf(uA)));
            this.fxh.ShowSoftKeyPadDelay(this.fFl, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fEB.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fxh.showToast(str);
    }

    public boolean kB(boolean z) {
        if (this.Qj == null || !this.Qj.HB()) {
            return false;
        }
        this.Qj.FT();
        return true;
    }

    public void bfW() {
        if (this.fGY != null) {
            while (this.fGY.size() > 0) {
                TbImageView remove = this.fGY.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bfW();
        this.fFi.qB(1);
        if (this.fEr != null) {
            this.fEr.onPause();
        }
    }

    public void onResume() {
        this.fFi.qB(2);
        if (this.fEr != null) {
            this.fEr.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fGs != null) {
            this.fGs.destroy();
        }
        if (this.fGJ != null) {
            this.fGJ.onDestory();
        }
        if (this.fGA != null) {
            this.fGA.hide();
        }
        if (this.fEu != null) {
            this.fEu.akn();
        }
        if (this.fEt != null) {
            this.fEt.onDestroy();
        }
        this.fxh.hideProgressBar();
        if (this.cPM != null && this.dhp != null) {
            this.cPM.b(this.dhp);
        }
        bfX();
        AI();
        if (this.fGq != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fGq);
        }
        if (this.fEH != null && this.fES != null) {
            this.fEH.removeView(this.fEN);
            this.fES = null;
        }
        if (this.fFW != null) {
            this.fFW.clearStatus();
        }
        this.fGR = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fFi.qB(3);
        if (this.dlF != null) {
            this.dlF.setBackgroundDrawable(null);
        }
        if (this.fEr != null) {
            this.fEr.destroy();
        }
        if (this.fFi != null) {
            this.fFi.onDestroy();
        }
        this.fEB.setOnLayoutListener(null);
        if (this.fGF != null) {
            this.fGF.avN();
        }
        if (this.fGh != null) {
            this.fGh.onDestroy();
        }
        bgs();
    }

    public boolean qS(int i) {
        if (this.fEr != null) {
            return this.fEr.kB(i);
        }
        return false;
    }

    public void bfX() {
        this.fEx.sN();
        if (this.fEu != null) {
            this.fEu.akn();
        }
        com.baidu.adp.lib.util.l.b(this.fxh.getPageContext().getPageActivity(), this.fFl);
        bfl();
        if (this.fFB != null) {
            this.fFB.dismiss();
        }
        bfZ();
        if (this.fEt != null) {
            this.fEt.bhV();
        }
        if (this.fFj != null) {
            this.fFj.dismiss();
        }
        if (this.dlp != null) {
            this.dlp.dismiss();
        }
    }

    public void bfY() {
        this.fEx.sN();
        if (this.fEu != null) {
            this.fEu.akn();
        }
        if (this.fFB != null) {
            this.fFB.dismiss();
        }
        bfZ();
        if (this.fEt != null) {
            this.fEt.bhV();
        }
        if (this.fFj != null) {
            this.fFj.dismiss();
        }
        if (this.dlp != null) {
            this.dlp.dismiss();
        }
    }

    public void da(List<String> list) {
        this.fGE = list;
        if (this.fGF != null) {
            this.fGF.setData(list);
        }
    }

    public void jH(boolean z) {
        this.fFi.jH(z);
    }

    public void kC(boolean z) {
        this.fFG = z;
    }

    public void bfZ() {
        if (this.fFs != null) {
            this.fFs.dismiss();
        }
        if (this.fFt != null) {
            com.baidu.adp.lib.g.g.b(this.fFt, this.fxh.getPageContext());
        }
        if (this.fFu != null) {
            com.baidu.adp.lib.g.g.b(this.fFu, this.fxh.getPageContext());
        }
        if (this.fFq != null) {
            com.baidu.adp.lib.g.g.b(this.fFq, this.fxh.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fAN, this.fxy);
            d(this.fAN, this.fxy, this.mType);
            this.fxh.getLayoutMode().setNightMode(i == 1);
            this.fxh.getLayoutMode().onModeChanged(this.cPO);
            this.fxh.getLayoutMode().onModeChanged(this.fEC);
            if (this.fEt != null) {
                this.fEt.onChangeSkinType(i);
            }
            if (this.fEE != null) {
                com.baidu.tbadk.core.util.am.h(this.fEE, d.C0142d.cp_cont_b);
                this.fEE.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_link_tip_c));
            }
            if (this.doI != null) {
                this.doI.dz(i);
                if (this.aTf != null) {
                    this.fxh.getLayoutMode().onModeChanged(this.aTf);
                    com.baidu.tbadk.core.util.am.i(this.aTf, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fFj != null) {
                this.fFj.c(this.fxh.getPageContext());
            }
            kA(this.fFD);
            this.fFi.notifyDataSetChanged();
            if (this.fFm != null) {
                this.fFm.dz(i);
            }
            if (this.Qj != null) {
                this.Qj.onChangeSkinType(i);
            }
            if (this.fER != null) {
                this.fER.dD(i);
            }
            if (this.fFn != null) {
                this.fFn.dz(i);
            }
            if (!com.baidu.tbadk.core.util.w.A(this.cyG)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cyG) {
                    customBlueCheckRadioButton.Ar();
                }
            }
            kw(i == 1);
            bfz();
            UtilHelper.setStatusBarBackground(this.dlF, i);
            UtilHelper.setStatusBarBackground(this.fGb, i);
            if (this.fET != null) {
                this.fET.onChangeSkinType(i);
            }
            if (this.fEY != null) {
                com.baidu.tbadk.core.util.am.h(this.fEY, d.C0142d.cp_cont_d);
            }
            if (this.fEX != null) {
                com.baidu.tbadk.core.util.am.h(this.fEX, d.C0142d.cp_cont_d);
            }
            if (this.fEZ != null) {
                com.baidu.tbadk.core.util.am.i(this.fEZ, d.C0142d.cp_cont_e);
            }
            if (this.ayD != null) {
                com.baidu.tbadk.core.util.am.h(this.ayD, d.C0142d.cp_cont_d);
            }
            if (this.fFa != null) {
                com.baidu.tbadk.core.util.am.i(this.fFa, d.C0142d.cp_cont_e);
            }
            if (this.fEK != null) {
                com.baidu.tbadk.core.util.am.h(this.fEK, d.C0142d.cp_link_tip_a);
            }
            if (this.fEW != null) {
                com.baidu.tbadk.core.util.am.h(this.fEW, d.C0142d.cp_cont_d);
            }
            if (this.fFb != null) {
                com.baidu.tbadk.n.a.a(this.fxh.getPageContext(), this.fFb);
            }
            if (this.fFz != null) {
                com.baidu.tbadk.n.a.a(this.fxh.getPageContext(), this.fFz);
            }
            if (this.fGr != null) {
                this.fGr.onChangeSkinType(i);
            }
            if (this.fEx != null) {
                if (this.fEr != null) {
                    this.fEr.qY(i);
                } else {
                    this.fEx.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fFJ != null) {
                com.baidu.tbadk.core.util.am.h(this.fFJ, d.C0142d.cp_cont_e);
            }
            if (this.fEL != null) {
                com.baidu.tbadk.core.util.am.c(this.fEL, BitmapHelper.getGradeResourceIdInEnterForum(this.fGz));
            }
            if (this.fGG != null) {
                this.fGG.onChangeSkinType(i);
            }
            if (this.fGh != null) {
                this.fGh.onChangeSkinType();
            }
            if (this.fGD != null) {
                com.baidu.tbadk.core.util.am.h(this.fGD, d.C0142d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bfR = hVar;
        this.fFi.setOnImageClickListener(this.bfR);
        this.fGG.setOnImageClickListener(this.bfR);
    }

    public void h(NoNetworkView.a aVar) {
        this.dhp = aVar;
        if (this.cPM != null) {
            this.cPM.a(this.dhp);
        }
    }

    public void kD(boolean z) {
        this.fFi.setIsFromCDN(z);
    }

    public Button bga() {
        return this.fFH;
    }

    public void bgb() {
        if (this.fEw != 2) {
            this.fEB.setNextPage(this.doI);
            this.fEw = 2;
        }
    }

    public void bgc() {
        if (com.baidu.tbadk.k.m.KK().KL()) {
            int lastVisiblePosition = this.fEB.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fEB.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.h perfLog = tbImageView.getPerfLog();
                                perfLog.fl(1001);
                                perfLog.aTJ = true;
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
                        perfLog2.fl(1001);
                        perfLog2.aTJ = true;
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

    public boolean bgd() {
        return this.Qj != null && this.Qj.getVisibility() == 0;
    }

    public boolean bge() {
        return this.Qj != null && this.Qj.HB();
    }

    public void bgf() {
        if (this.Qj != null) {
            this.Qj.FT();
        }
    }

    public void kE(boolean z) {
        if (this.fFI != null) {
            kC(this.fxh.bcm().Ie());
            if (this.fFG) {
                kt(z);
            } else {
                ku(z);
            }
        }
    }

    public void bgg() {
        if (this.fFI != null) {
            this.fFI.setVisibility(8);
            this.fFN = false;
            if (this.fGh != null) {
                this.fGh.setVisibility(8);
                ky(false);
            }
            bgs();
        }
    }

    public void showLoadingDialog() {
        if (this.cGa == null) {
            this.cGa = new com.baidu.tbadk.core.view.a(this.fxh.getPageContext());
        }
        this.cGa.aO(true);
    }

    public void aeB() {
        if (this.cGa != null) {
            this.cGa.aO(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fEB.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fEB.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fEr != null) {
            this.fEr.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eWx = getScrollY();
            this.fGg.fHn = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGg));
            a(this.fGg.fHn, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fEr != null) {
            this.fEr.b(absListView, i);
        }
        int headerViewsCount = (i - this.fEB.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fFi.qA(headerViewsCount) == com.baidu.tieba.pb.data.j.ftc) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fEB.getHeaderViewsCount();
        if (this.fEF != null && this.fEx != null) {
            this.fEx.g(this.fEF.getBottom(), this.fEF.getMeasuredHeight(), z2);
        }
        this.fFi.bdx().j(z, this.fFZ != null ? this.fFZ.getMeasuredHeight() : 0);
        this.fGg.fnZ = i;
        this.fGg.headerCount = this.fEB.getHeaderViewsCount();
        this.fGg.fHn = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGg));
        a(this.fGg.fHn, false);
    }

    public void bgh() {
        if (this.fxh.isLogin() && this.fAN != null && this.fGw && !this.fGv && !this.fFE && this.fFR != null && this.fFR.vw() != null && !this.fFR.vw().getIsLike() && !this.fFR.vw().hadConcerned()) {
            if (this.fGs == null) {
                this.fGs = new an(this.fxh);
            }
            this.fGs.a(this.fEx.fJv, this.fAN.bbu(), this.fFR.vw().getUserId(), this.fAN.getThreadId());
        }
    }

    public void bgi() {
        if (this.fGw && !this.fGv && this.fFR != null && this.fFR.vw() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").r("obj_locate", this.fxh.bdb() ? 2 : 1).r("obj_type", this.fGv ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fxh.getPageContext().getPageActivity(), this.fFR.vw().getUserId(), this.fFR.vw().getUserName(), this.fxh.bca().bdO(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fGv && this.fGa != null && this.fEx.bgM() != null) {
            int bdu = this.fFi.bdu();
            if (bdu > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bdu > this.fEB.getFirstVisiblePosition() - this.fEB.getHeaderViewsCount()) {
                    this.fGa.setVisibility(8);
                    return;
                }
                this.fGa.setVisibility(0);
                this.fEx.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fDF == null) {
                if (this.fEB.getFirstVisiblePosition() == 0) {
                    this.fGa.setVisibility(8);
                    this.fEx.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fGf) {
                        this.fGe = top;
                        this.fGf = false;
                    }
                    this.fGe = top < this.fGe ? top : this.fGe;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fFh.getY() < 0.0f) {
                        measuredHeight = fGd - alVar.fDF.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fEx.bgM().getMeasuredHeight() - alVar.fDF.getMeasuredHeight();
                        this.fEx.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fGe) {
                        this.fGa.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fGa.setVisibility(0);
                    } else {
                        this.fGa.setVisibility(8);
                        this.fEx.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fGf = true;
                    }
                }
            }
        }
    }

    public void bgj() {
        if (!this.fGZ) {
            TiebaStatic.log("c10490");
            this.fGZ = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fxh.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fGk, Integer.valueOf(fGm));
            aVar.cc(d.k.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.k.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.k.grade_thread_tips);
            aVar.w(inflate);
            aVar.C(sparseArray);
            aVar.a(d.k.grade_button_tips, this.fxh);
            aVar.b(d.k.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fxh.getPageContext()).xn();
        }
    }

    public void rt(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fxh.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.w(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fGk, Integer.valueOf(fGn));
        aVar.C(sparseArray);
        aVar.a(d.k.view, this.fxh);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fxh.getPageContext()).xn();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.vw() != null) {
            MetaData vw = b.vw();
            vw.setGiftNum(vw.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bgk() {
        return this.fFW;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.baV() != null && dVar.baV().wl() && this.fFW == null) {
            this.fFW = (PbInterviewStatusView) this.fFV.inflate();
            this.fFW.setOnClickListener(this.dlq);
            this.fFW.setCallback(this.fxh.bcW());
            this.fFW.setData(this.fxh, dVar);
        }
    }

    public LinearLayout bgl() {
        return this.fFh;
    }

    public View bgm() {
        return this.dlF;
    }

    public boolean bgn() {
        return this.fGL;
    }

    public void jM(boolean z) {
        this.fEG.jM(z);
    }

    public void ru(String str) {
        if (this.fEy != null) {
            this.fEy.setTitle(str);
        }
    }

    private int kF(boolean z) {
        if (this.fFW == null || this.fFW.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bgo() {
        if (this.fFW != null && this.fFW.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fFW.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fFW.setLayoutParams(layoutParams);
        }
    }

    public boolean bcs() {
        return false;
    }

    public void rv(String str) {
        this.fFJ.performClick();
        if (!StringUtils.isNull(str) && this.fxh.bcm() != null && this.fxh.bcm().HX() != null && this.fxh.bcm().HX().getInputView() != null) {
            EditText inputView = this.fxh.bcm().HX().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bfX();
            if (configuration.orientation == 2) {
                bgg();
                bfl();
            } else {
                bfo();
            }
            if (this.fGr != null) {
                this.fGr.bdB();
            }
            this.fxh.atY();
            this.fFh.setVisibility(8);
            this.fEx.kR(false);
            this.fxh.jS(false);
            if (this.fEr != null) {
                if (configuration.orientation == 1) {
                    bgl().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fEB.setIsLandscape(true);
                    this.fEB.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fEB.setIsLandscape(false);
                    if (this.eWx > 0) {
                        this.fEB.smoothScrollBy(this.eWx, 0);
                    }
                }
                this.fEr.onConfigurationChanged(configuration);
            }
        }
    }

    public void kG(boolean z) {
        this.fEv = z;
    }

    public boolean bgp() {
        return this.fEr != null && this.fEr.bgp();
    }

    public void bgq() {
        if (this.fEr != null) {
            this.fEr.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fEt != null) {
            this.fEt.y(j, i);
        }
        if (this.fEr != null) {
            this.fEr.y(j, i);
        }
    }

    public void jX(boolean z) {
        this.fFi.jX(z);
    }

    public void bgr() {
        if (this.fFX == null) {
            LayoutInflater.from(this.fxh.getActivity()).inflate(d.i.add_experienced_text, (ViewGroup) this.cPO, true);
            this.fFX = (ViewGroup) this.cPO.findViewById(d.g.add_experienced_layout);
            this.fFY = (TextView) this.cPO.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.am.h(this.fFY, d.C0142d.cp_cont_i);
            String string = this.fxh.getResources().getString(d.k.experienced_add_success);
            String string2 = this.fxh.getResources().getString(d.k.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_cont_h)));
            this.fFY.setText(spannableString);
        }
        this.fFX.setVisibility(0);
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
                        at.this.fFX.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                at.this.fFY.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fFY.startAnimation(scaleAnimation);
    }

    public void bj(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fFI.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fxh);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fGD = new TextView(this.fxh);
            this.fGD.setText(d.k.connection_tips);
            this.fGD.setGravity(17);
            this.fGD.setPadding(com.baidu.adp.lib.util.l.e(this.fxh, d.e.ds24), 0, com.baidu.adp.lib.util.l.e(this.fxh, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.fxh, d.e.ds60);
            if (this.fGD.getParent() == null) {
                frameLayout.addView(this.fGD, layoutParams);
            }
            this.fGC = new PopupWindow(this.fxh);
            this.fGC.setContentView(frameLayout);
            this.fGC.setHeight(-2);
            this.fGC.setWidth(-2);
            this.fGC.setFocusable(true);
            this.fGC.setOutsideTouchable(false);
            this.fGC.setBackgroundDrawable(new ColorDrawable(this.fxh.getResources().getColor(d.C0142d.transparent)));
            this.fEB.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        at.this.fGC.showAsDropDown(at.this.fFI, view.getLeft(), -at.this.fFI.getHeight());
                    } else {
                        at.this.fGC.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bgD() != null && !StringUtils.isNull(aVar.bgD().pkg_id) && !StringUtils.isNull(aVar.bgD().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fFK != null && this.fFK.getVisibility() == 0) {
            if (this.fGB == null) {
                View inflate = LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(d.i.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.k.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dlq);
                this.fGB = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fFK.getLocationInWindow(iArr);
            this.fGB.showAtLocation(this.fFK, 0, iArr[0] - com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fFK.getHeight()) - com.baidu.adp.lib.util.l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bgs() {
        com.baidu.adp.lib.g.g.a(this.fGB);
    }

    public void kH(boolean z) {
        this.fGI = z;
    }

    public boolean bgt() {
        return this.fGI;
    }

    public void bk(View view) {
        this.fFz = view;
    }
}
