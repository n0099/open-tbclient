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
    private EditorTools Tj;
    private j.b aJh;
    private TextView aKL;
    private TextView ajh;
    private NavigationBarCoverTip alI;
    private View bfU;
    private com.baidu.tieba.pb.a.c bsE;
    private View dNG;
    private View.OnClickListener dNr;
    private PbListView dRb;
    private List<CustomBlueCheckRadioButton> daJ;
    private View deS;
    private NoNetworkView drO;
    private RelativeLayout drQ;
    private com.baidu.tieba.NEGFeedBack.e ekJ;
    PbActivity.d fXP;
    private PbActivity fYJ;
    private UserIconBox fZT;
    private UserIconBox fZU;
    private View.OnClickListener fZh;
    private PbFakeFloorModel gbc;
    private com.baidu.tieba.pb.data.d gcj;
    public int gfI;
    private com.baidu.tieba.pb.video.i gfJ;
    private long gfK;
    private com.baidu.tieba.pb.video.h gfL;
    private com.baidu.tieba.c.d gfM;
    public final com.baidu.tieba.pb.pb.main.view.b gfP;
    public com.baidu.tieba.pb.pb.main.view.a gfQ;
    private ViewStub gfR;
    private ViewStub gfS;
    private PbLandscapeListView gfT;
    private View gfU;
    private LinearLayout gfX;
    private e gfY;
    private ColumnLayout gfZ;
    private f ggA;
    private View ggG;
    private ThreadSkinView gga;
    private TextView ggb;
    private TextView ggc;
    private ImageView ggd;
    private HeadPendantView gge;
    private FrameLayout ggf;
    private HeadImageView ggg;
    private View ggh;
    private FloatingLayout ggi;
    private PbFirstFloorUserLikeButton ggl;
    private ap ggm;
    private ap ggn;
    private TextView ggo;
    private TextView ggp;
    private TextView ggq;
    private View ggr;
    private View ggs;
    private LinearLayout ggt;
    private TextView ggu;
    private TextView ggv;
    private View ggw;
    private View ggx;
    private ObservedChangeLinearLayout ggz;
    private int ghH;
    private Runnable ghI;
    private s ghJ;
    private an ghK;
    private int ghQ;
    private PbTopTipView ghS;
    private PopupWindow ghT;
    private PopupWindow ghU;
    private TextView ghV;
    private com.baidu.tbadk.core.dialog.a ghW;
    private List<String> ghX;
    private com.baidu.tieba.pb.pb.main.emotion.c ghY;
    private com.baidu.tieba.pb.pb.godreply.a ghZ;
    private View gha;
    private TextView ghb;
    private ImageView ghc;
    private ImageView ghd;
    private TextView ghe;
    private boolean ghg;
    private int ghh;
    private int ghi;
    private PostData ghj;
    private View ghl;
    private TextView ghm;
    private ViewStub ghn;
    private PbInterviewStatusView gho;
    private ViewGroup ghp;
    private TextView ghq;
    private FrameLayout ghr;
    private View ghs;
    private View ght;
    private al ghu;
    private PbEmotionBar ghz;
    private PbLandscapeListView.b gia;
    private ac gic;
    private boolean gif;
    private com.baidu.tbadk.core.view.userLike.c gig;
    private com.baidu.tbadk.core.view.userLike.c gih;
    private Runnable gim;
    private PbActivity.b gio;
    private int git;
    private boolean isLandscape;
    private int mType;
    private static final int ghv = UtilHelper.getLightStatusBarHeight();
    public static int ghB = 3;
    public static int ghC = 0;
    public static int ghD = 3;
    public static int ghE = 4;
    public static int ghF = 5;
    public static int ghG = 6;
    private static a.InterfaceC0314a gie = new a.InterfaceC0314a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0314a
        public void onRefresh() {
        }
    };
    private boolean gfN = false;
    private int gfO = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout gfV = null;
    private TextView gfW = null;
    public FrsPraiseView ggj = null;
    private ClickableHeaderImageView ggk = null;
    private View ggy = null;
    private com.baidu.tbadk.core.dialog.a ggB = null;
    private com.baidu.tbadk.core.dialog.b dNq = null;
    private View ggC = null;
    private EditText ggD = null;
    private com.baidu.tieba.pb.view.d ggE = null;
    private com.baidu.tieba.pb.view.a ggF = null;
    private com.baidu.tbadk.core.dialog.a ggH = null;
    private b.InterfaceC0158b eWy = null;
    private TbRichTextView.h bsD = null;
    private NoNetworkView.a dJm = null;
    private Dialog ggI = null;
    private View ggJ = null;
    private com.baidu.tbadk.core.dialog.a ggK = null;
    private Dialog ggL = null;
    private Dialog ggM = null;
    private View ggN = null;
    private LinearLayout ggO = null;
    private CompoundButton.OnCheckedChangeListener daK = null;
    private TextView ggP = null;
    private TextView ggQ = null;
    private View ggR = null;
    private String ggS = null;
    private com.baidu.tbadk.core.dialog.b ggT = null;
    private com.baidu.tbadk.core.dialog.b ggU = null;
    private boolean ggV = false;
    private boolean ggW = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView ggX = null;
    private boolean ggY = false;
    private Button ggZ = null;
    private boolean ghf = true;
    private com.baidu.tbadk.core.view.d dig = null;
    private boolean fZa = false;
    private int mSkinType = 3;
    private boolean ghk = false;
    private int ghw = 0;
    private boolean ghx = true;
    private a ghy = new a();
    private int ghA = 0;
    private boolean ghL = false;
    private int ghM = 0;
    private boolean ghN = false;
    private boolean ghO = false;
    private boolean ghP = false;
    private int ghR = 0;
    private boolean gib = false;
    private String gii = null;
    private CustomMessageListener gij = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.gii = null;
            }
        }
    };
    private CustomMessageListener bRj = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.ggA != null) {
                ar.this.ggA.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gik = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.gfW != null) {
                ar.this.gfW.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler gil = new Handler();
    private CustomMessageListener gin = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.ghf = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean gip = true;
    View.OnClickListener giq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.ghN) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").y(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (ar.this.gfP != null && ar.this.gfP.gkX != null && view == ar.this.gfP.gkX.getHeadView()) {
                if (ar.this.gfP.gkV == null || ar.this.gfP.gkV.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").y("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!ar.this.ghN && ar.this.gcj != null && ar.this.gcj.bhz() != null && ar.this.gcj.bhz().zT() != null && ar.this.gcj.bhz().zT().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").y("obj_locate", 1));
            }
            ar.this.fYJ.fWN.elC.onClick(view);
        }
    };
    private boolean gir = false;
    String userId = null;
    private final List<TbImageView> gis = new ArrayList();
    private boolean giu = false;

    /* loaded from: classes6.dex */
    public static class a {
        public int fPd;
        public al giI;
        public int headerCount;
    }

    public void lj(boolean z) {
        this.ghL = z;
        if (this.gfT != null) {
            this.ghM = this.gfT.getHeaderViewsCount();
        }
    }

    public void blP() {
        if (this.gfT != null) {
            int headerViewsCount = this.gfT.getHeaderViewsCount() - this.ghM;
            final int firstVisiblePosition = (this.gfT.getFirstVisiblePosition() == 0 || this.gfT.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.gfT.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.gfT.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.ghy.giI = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ghy));
            final al alVar = this.ghy.giI;
            final int h = h(alVar);
            final int y = ((int) this.ggz.getY()) + this.ggz.getMeasuredHeight();
            final boolean z = this.ghs.getVisibility() == 0;
            boolean z2 = this.ggz.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.ggA.bjZ() + this.gfT.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.gfi.getMeasuredHeight() : 0;
                if (z2) {
                    this.gfT.setSelectionFromTop(this.ggA.bjZ() + this.gfT.getHeaderViewsCount(), ghv - measuredHeight);
                } else {
                    this.gfT.setSelectionFromTop(this.ggA.bjZ() + this.gfT.getHeaderViewsCount(), this.gfP.bnz().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.gfT.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.ghN) {
                this.gfT.setSelectionFromTop(this.ggA.bjZ() + this.gfT.getHeaderViewsCount(), this.gfJ.boN().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.gfT.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bkq() {
                        if (h >= 0 && h <= ar.this.drQ.getMeasuredHeight()) {
                            int h2 = ar.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.deS.getLayoutParams();
                            if (i == 0 || i > ar.this.drQ.getMeasuredHeight() || h2 >= ar.this.drQ.getMeasuredHeight()) {
                                layoutParams.height = ar.this.ghH;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.drQ.getMeasuredHeight()) {
                                layoutParams.height = ar.this.ghH;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.gfT.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.deS.setLayoutParams(layoutParams);
                        }
                        ar.this.gfT.setOnLayoutListener(null);
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

    public NoNetworkView blQ() {
        return this.drO;
    }

    public void blR() {
        if (this.Tj != null) {
            this.Tj.hide();
            if (this.ghY != null) {
                this.ghY.ZZ();
            }
        }
    }

    public PbFakeFloorModel blS() {
        return this.gbc;
    }

    public s blT() {
        return this.ghJ;
    }

    public void blU() {
        reset();
        blR();
        this.ghJ.bkg();
        lv(false);
    }

    private void reset() {
        if (this.fYJ != null && this.fYJ.biP() != null && this.Tj != null) {
            com.baidu.tbadk.editortools.pb.a.ML().setStatus(0);
            com.baidu.tbadk.editortools.pb.d biP = this.fYJ.biP();
            biP.Ne();
            biP.Mz();
            if (biP.getWriteImagesInfo() != null) {
                biP.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            biP.fR(SendView.ALL);
            biP.fS(SendView.ALL);
            com.baidu.tbadk.editortools.g fI = this.Tj.fI(23);
            com.baidu.tbadk.editortools.g fI2 = this.Tj.fI(2);
            com.baidu.tbadk.editortools.g fI3 = this.Tj.fI(5);
            if (fI2 != null) {
                fI2.pR();
            }
            if (fI3 != null) {
                fI3.pR();
            }
            if (fI != null) {
                fI.hide();
            }
            this.Tj.invalidate();
        }
    }

    public boolean blV() {
        return this.ghf;
    }

    public void lk(boolean z) {
        if (this.gha != null && this.ghb != null) {
            this.ghb.setText(e.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.gha.startAnimation(alphaAnimation);
            }
            this.gha.setVisibility(0);
            this.ghf = true;
            if (this.ghz != null && !this.ghZ.isActive()) {
                this.ghz.setVisibility(0);
                lp(true);
            }
        }
    }

    public void ll(boolean z) {
        if (this.gha != null && this.ghb != null) {
            this.ghb.setText(e.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.gha.startAnimation(alphaAnimation);
            }
            this.gha.setVisibility(0);
            this.ghf = true;
            if (this.ghz != null && !this.ghZ.isActive()) {
                this.ghz.setVisibility(0);
                lp(true);
            }
        }
    }

    public PostData blW() {
        int i = 0;
        if (this.gfT == null) {
            return null;
        }
        int blX = blX() - this.gfT.getHeaderViewsCount();
        if (blX < 0) {
            blX = 0;
        }
        if (this.ggA.sy(blX) != null && this.ggA.sy(blX) != PostData.hpC) {
            i = blX + 1;
        }
        return this.ggA.getItem(i) instanceof PostData ? (PostData) this.ggA.getItem(i) : null;
    }

    public int blX() {
        int i;
        View childAt;
        if (this.gfT == null) {
            return 0;
        }
        int firstVisiblePosition = this.gfT.getFirstVisiblePosition();
        int lastVisiblePosition = this.gfT.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.gfT.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.gfT.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int blY() {
        return this.gfT.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.gcj != null && this.gcj.bhB() != null && !this.gcj.bhB().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.gcj.bhB().size() && (postData = this.gcj.bhB().get(i)) != null && postData.zT() != null && !StringUtils.isNull(postData.zT().getUserId()); i++) {
                if (this.gcj.bhB().get(i).zT().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.ghZ != null && this.ghZ.isActive()) {
                        lv(false);
                    }
                    if (this.ghz != null) {
                        this.ghz.lD(true);
                    }
                    this.gii = postData.zT().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fYJ = null;
        this.drQ = null;
        this.dNG = null;
        this.gfK = 0L;
        this.gfT = null;
        this.gfU = null;
        this.gfX = null;
        this.gfZ = null;
        this.ggb = null;
        this.ggc = null;
        this.ggf = null;
        this.ggg = null;
        this.ggh = null;
        this.ggl = null;
        this.ggo = null;
        this.ggp = null;
        this.ggq = null;
        this.ggr = null;
        this.ggw = null;
        this.ggx = null;
        this.ggA = null;
        this.dRb = null;
        this.bfU = null;
        this.dNr = null;
        this.fZh = null;
        this.gha = null;
        this.ghb = null;
        this.ghc = null;
        this.ghd = null;
        this.ghe = null;
        this.ghl = null;
        this.ghm = null;
        this.ghn = null;
        this.ghQ = 0;
        this.gfK = System.currentTimeMillis();
        this.fYJ = pbActivity;
        this.dNr = onClickListener;
        this.bsE = cVar;
        this.ghQ = com.baidu.adp.lib.util.l.aO(this.fYJ) / 2;
        this.drQ = (RelativeLayout) LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.new_pb_activity, (ViewGroup) null);
        this.fYJ.addContentView(this.drQ, new FrameLayout.LayoutParams(-1, -1));
        this.alI = (NavigationBarCoverTip) this.fYJ.findViewById(e.g.pb_multi_forum_del_tip_view);
        this.dNG = this.fYJ.findViewById(e.g.statebar_view);
        this.ggz = (ObservedChangeLinearLayout) this.fYJ.findViewById(e.g.title_wrapper);
        this.drO = (NoNetworkView) this.fYJ.findViewById(e.g.view_no_network);
        this.gfT = (PbLandscapeListView) this.fYJ.findViewById(e.g.new_pb_list);
        this.ghr = (FrameLayout) this.fYJ.findViewById(e.g.root_float_header);
        this.ajh = new TextView(this.fYJ.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds88));
        this.gfT.addHeaderView(this.ajh, 0);
        this.ghH = this.fYJ.getResources().getDimensionPixelSize(e.C0210e.tbds134);
        this.deS = new View(this.fYJ.getPageContext().getPageActivity());
        this.deS.setLayoutParams(new AbsListView.LayoutParams(-1, this.ghH));
        this.deS.setVisibility(4);
        this.gfT.addFooterView(this.deS);
        this.gfT.setOnTouchListener(this.fYJ.bjC);
        this.gfP = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fYJ.bjt()) {
            this.gfR = (ViewStub) this.fYJ.findViewById(e.g.manga_view_stub);
            this.gfR.setVisibility(0);
            this.gfQ = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.gfQ.show();
            this.gfP.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds120);
        }
        this.ajh.setLayoutParams(layoutParams);
        this.gfP.bnz().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0279a() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0279a
            public void bin() {
                if (ar.this.gfT != null) {
                    if (ar.this.gfJ != null) {
                        ar.this.gfJ.boO();
                    }
                    ar.this.gfT.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0279a
            public void bio() {
                ar.this.fYJ.aCk();
            }
        }));
        this.gha = this.fYJ.findViewById(e.g.pb_editor_tool_comment);
        this.ghh = com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds90);
        this.ghi = com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds242);
        this.ghb = (TextView) this.fYJ.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_reply_text);
        this.ghd = (ImageView) this.fYJ.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_more_img);
        this.ghc = (ImageView) this.fYJ.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_emotion_img);
        this.ghe = (TextView) this.fYJ.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_praise_icon);
        this.ghe.setVisibility(8);
        this.ghb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.blZ();
            }
        });
        this.ghc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bnb();
                if (ar.this.fYJ.checkUpIsLogin()) {
                    if (ar.this.Tj != null) {
                        ar.this.bmj();
                        ar.this.Tj.aa((View) ar.this.Tj.fI(5));
                    }
                    if (ar.this.Tj != null) {
                        ar.this.ghf = false;
                        if (ar.this.Tj.fL(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fYJ, (View) ar.this.Tj.fL(2).aYV, false, ar.gie);
                        }
                    }
                    ar.this.bmO();
                }
            }
        });
        this.ghd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bnb();
                if (ar.this.fYJ.checkUpIsLogin()) {
                    if (ar.this.Tj != null) {
                        ar.this.bmj();
                        ar.this.Tj.aa((View) ar.this.Tj.fI(2));
                    }
                    if (ar.this.Tj != null) {
                        ar.this.ghf = false;
                        if (ar.this.Tj.fL(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fYJ, (View) ar.this.Tj.fL(2).aYV, false, ar.gie);
                        }
                    }
                    ar.this.bmO();
                }
            }
        });
        this.ghe.setOnClickListener(this.dNr);
        this.ghe.setOnTouchListener(this.fYJ);
        this.gfU = LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_item, (ViewGroup) null);
        this.gfX = (LinearLayout) LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_user_item, (ViewGroup) null);
        this.gfY = new e(this.fYJ, this.gfX);
        this.gfY.init();
        this.gfY.a(this.gfY.biO(), this.dNr);
        this.gfZ = (ColumnLayout) this.gfX.findViewById(e.g.pb_head_owner_root);
        this.gga = (ThreadSkinView) this.gfX.findViewById(e.g.pb_thread_skin);
        this.gfZ.setOnLongClickListener(this.onLongClickListener);
        this.gfZ.setOnTouchListener(this.bsE);
        this.gfZ.setVisibility(8);
        this.gfU.setOnTouchListener(this.bsE);
        this.ghl = this.gfU.findViewById(e.g.pb_head_activity_join_number_container);
        this.ghl.setVisibility(8);
        this.ghm = (TextView) this.gfU.findViewById(e.g.pb_head_activity_join_number);
        this.ggb = (TextView) this.gfZ.findViewById(e.g.pb_head_owner_info_user_name);
        this.ggc = (TextView) this.gfZ.findViewById(e.g.floor_owner);
        this.ggd = (ImageView) this.gfZ.findViewById(e.g.icon_forum_level);
        this.ggf = (FrameLayout) this.gfZ.findViewById(e.g.pb_head_headImage_container);
        this.ggg = (HeadImageView) this.gfZ.findViewById(e.g.pb_head_owner_photo);
        this.gge = (HeadPendantView) this.gfZ.findViewById(e.g.pb_pendant_head_owner_photo);
        this.gge.setHasPendantStyle();
        if (this.gge.getHeadView() != null) {
            this.gge.getHeadView().setIsRound(true);
            this.gge.getHeadView().setDrawBorder(false);
        }
        this.fZT = (UserIconBox) this.gfZ.findViewById(e.g.show_icon_vip);
        this.fZU = (UserIconBox) this.gfZ.findViewById(e.g.show_icon_yinji);
        this.ggi = (FloatingLayout) this.gfX.findViewById(e.g.pb_head_owner_info_root);
        this.ggl = (PbFirstFloorUserLikeButton) this.gfZ.findViewById(e.g.pb_like_button);
        this.ggo = (TextView) this.gfZ.findViewById(e.g.pb_views);
        this.aKL = (TextView) this.gfZ.findViewById(e.g.view_forum_name);
        this.ggs = this.gfZ.findViewById(e.g.line_right_forum_name);
        this.ggp = (TextView) this.gfZ.findViewById(e.g.pb_item_first_floor_reply_time);
        this.ggq = (TextView) this.gfZ.findViewById(e.g.pb_item_first_floor_location_address);
        this.ggr = this.gfZ.findViewById(e.g.line_between_time_and_locate);
        this.gig = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.gih = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.ggw = this.gfU.findViewById(e.g.new_pb_header_item_line_above_livepost);
        this.ggx = this.gfU.findViewById(e.g.new_pb_header_item_line_below_livepost);
        this.gfU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.37
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.ghn = (ViewStub) this.drQ.findViewById(e.g.interview_status_stub);
        this.ggA = new f(this.fYJ, this.gfT);
        this.ggA.w(this.dNr);
        this.ggA.setTbGestureDetector(this.bsE);
        this.ggA.setOnImageClickListener(this.bsD);
        this.fZh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.38
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
                            ar.this.fYJ.b(sparseArray);
                            return;
                        }
                        ar.this.bF(view);
                    } else if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 0);
                        sparseArray.put(e.g.tag_check_mute_from, 1);
                        ar.this.fYJ.b(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.ggA.I(this.fZh);
        bme();
        this.gfT.addHeaderView(this.gfV);
        this.gfT.addHeaderView(this.gfX);
        this.gfT.addHeaderView(this.gfU);
        this.dRb = new PbListView(this.fYJ.getPageContext().getPageActivity());
        this.bfU = this.dRb.getView().findViewById(e.g.pb_more_view);
        if (this.bfU != null) {
            this.bfU.setOnClickListener(this.dNr);
            com.baidu.tbadk.core.util.al.i(this.bfU, e.f.pb_foot_more_trans_selector);
        }
        this.dRb.Fl();
        this.dRb.ev(e.f.pb_foot_more_trans_selector);
        this.dRb.ex(e.f.pb_foot_more_trans_selector);
        this.ggG = this.fYJ.findViewById(e.g.viewstub_progress);
        this.fYJ.registerListener(this.gin);
        this.ggh = com.baidu.tbadk.ala.b.wg().j(this.fYJ.getActivity(), 2);
        if (this.ggh != null) {
            this.ggh.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fYJ.getResources().getDimensionPixelSize(e.C0210e.ds10);
            if (this.ggh.getParent() == null) {
                this.ggi.addView(this.ggh, aVar);
            }
        }
        this.gbc = new PbFakeFloorModel(this.fYJ.getPageContext());
        this.ghJ = new s(this.fYJ.getPageContext(), this.gbc, this.drQ);
        this.ghJ.a(this.fYJ.fXL);
        this.gbc.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                ar.this.gbc.o(postData);
                ar.this.ggA.notifyDataSetChanged();
                ar.this.ghJ.bkg();
                ar.this.Tj.KM();
                ar.this.lv(false);
            }
        });
        if (this.fYJ.biD() != null && !StringUtils.isNull(this.fYJ.biD().blb())) {
            this.fYJ.showToast(this.fYJ.biD().blb());
        }
        this.ghs = this.fYJ.findViewById(e.g.pb_expand_blank_view);
        this.ght = this.fYJ.findViewById(e.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ght.getLayoutParams();
        if (this.fYJ.biD() != null && this.fYJ.biD().bkw()) {
            this.ghs.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.ght.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = ghv;
            this.ght.setLayoutParams(layoutParams2);
        }
        this.ghu = new al(this.fYJ.getPageContext(), this.fYJ.findViewById(e.g.pb_reply_expand_view));
        this.ghu.gfi.setVisibility(8);
        this.ghu.L(this.dNr);
        this.fYJ.registerListener(this.bRj);
        this.fYJ.registerListener(this.gij);
        this.fYJ.registerListener(this.gik);
        bma();
        lp(false);
    }

    public void blZ() {
        bnb();
        if (!this.fYJ.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").y("obj_locate", 2).aB(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.fYJ.bjb()) {
            com.baidu.tbadk.editortools.pb.d biP = this.fYJ.biP();
            if (biP != null && (biP.Nb() || biP.Nc())) {
                this.fYJ.biP().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Tj != null) {
                bmj();
            }
            if (this.Tj != null) {
                this.ghf = false;
                if (this.Tj.fL(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.fYJ, (View) this.Tj.fL(2).aYV, false, gie);
                }
            }
            bmO();
        }
    }

    private void bma() {
        this.ghZ = new com.baidu.tieba.pb.pb.godreply.a(this.fYJ, this, (ViewStub) this.drQ.findViewById(e.g.more_god_reply_popup));
        this.ghZ.s(this.dNr);
        this.ghZ.I(this.fZh);
        this.ghZ.setOnImageClickListener(this.bsD);
        this.ghZ.s(this.dNr);
        this.ghZ.setTbGestureDetector(this.bsE);
    }

    public com.baidu.tieba.pb.pb.godreply.a bmb() {
        return this.ghZ;
    }

    public View bmc() {
        return this.ghs;
    }

    public void bmd() {
        if (this.gfT != null) {
            this.gfT.removeHeaderView(this.gfV);
            this.gfT.removeHeaderView(this.gfX);
            this.gfT.removeHeaderView(this.gfU);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.ghz == null) {
            this.ghz = new PbEmotionBar(this.fYJ.getPageContext().getPageActivity());
            lp(true);
            this.ghz.a(this.drQ, aVar, this.gha.getVisibility() == 0);
            this.ghz.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (ar.this.fYJ.bjb()) {
                        if (!StringUtils.isNull(ar.this.gii)) {
                            emotionImageData.setAuthorNameShow(ar.this.gii);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fYJ.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fYJ.getPageContext().getPageActivity(), 25016, str, list, ar.this.gii, list2)));
                }
            });
            this.ghz.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    ar.this.bnb();
                    if (ar.this.gha != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.gha.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.ghi - ar.this.ghh) * f) + ar.this.ghh);
                        ar.this.ghb.setAlpha(1.0f - f);
                        ar.this.ghd.setAlpha(1.0f - f);
                        ar.this.ghc.setAlpha(1.0f - f);
                        ar.this.gha.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bme() {
        if (this.gfV == null) {
            int h = com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.tbds44);
            this.gfV = new LinearLayout(this.fYJ.getPageContext().getPageActivity());
            this.gfV.setOrientation(1);
            this.gfV.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gfV.setPadding(h, com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.tbds30), h, com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.tbds40));
            this.gfV.setGravity(17);
            this.gfW = new TextView(this.fYJ.getPageContext().getPageActivity());
            this.gfW.setGravity(3);
            this.gfW.setMaxLines(2);
            this.gfW.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            this.gfW.setPadding(0, 0, 0, 0);
            this.gfW.setLineSpacing(com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.gfW, e.d.cp_cont_b);
            this.gfW.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.gfW.setVisibility(8);
            if (this.gfW.getParent() == null) {
                this.gfV.addView(this.gfW);
            }
            this.gfV.setOnTouchListener(this.bsE);
            this.gfV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmf() {
        if (this.fYJ.bjt()) {
            this.gfS = (ViewStub) this.fYJ.findViewById(e.g.manga_mention_controller_view_stub);
            this.gfS.setVisibility(0);
            if (this.ggt == null) {
                this.ggt = (LinearLayout) this.fYJ.findViewById(e.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fYJ.getPageContext(), this.ggt);
            }
            if (this.ggu == null) {
                this.ggu = (TextView) this.ggt.findViewById(e.g.manga_prev_btn);
            }
            if (this.ggv == null) {
                this.ggv = (TextView) this.ggt.findViewById(e.g.manga_next_btn);
            }
            this.ggu.setOnClickListener(this.dNr);
            this.ggv.setOnClickListener(this.dNr);
        }
    }

    private void bmg() {
        if (this.fYJ.bjt()) {
            if (this.fYJ.bjw() == -1) {
                com.baidu.tbadk.core.util.al.c(this.ggu, e.d.cp_cont_e, 1);
            }
            if (this.fYJ.bjx() == -1) {
                com.baidu.tbadk.core.util.al.c(this.ggv, e.d.cp_cont_e, 1);
            }
        }
    }

    public void bmh() {
        if (this.ggt == null) {
            bmf();
        }
        this.gfS.setVisibility(8);
        if (this.gil != null && this.gim != null) {
            this.gil.removeCallbacks(this.gim);
        }
    }

    public void bmi() {
        if (this.gil != null) {
            if (this.gim != null) {
                this.gil.removeCallbacks(this.gim);
            }
            this.gim = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.ggt == null) {
                        ar.this.bmf();
                    }
                    ar.this.gfS.setVisibility(0);
                }
            };
            this.gil.postDelayed(this.gim, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void lm(boolean z) {
        this.gfP.lm(z);
        if (z && this.ghk) {
            this.dRb.setText(this.fYJ.getResources().getString(e.j.click_load_more));
            this.gfT.setNextPage(this.dRb);
            this.gfO = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
        this.Tj.setId(e.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Tj.getParent() == null) {
            this.drQ.addView(this.Tj, layoutParams);
        }
        this.Tj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        blR();
        this.fYJ.biP().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.Tj != null && ar.this.Tj.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.ghY == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.Tj.getId());
                            ar.this.ghY = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fYJ.getPageContext(), ar.this.drQ, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.I(ar.this.ghX)) {
                                ar.this.ghY.setData(ar.this.ghX);
                            }
                            ar.this.ghY.b(ar.this.Tj);
                        }
                        ar.this.ghY.tA(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fYJ.fWR != null && ar.this.fYJ.fWR.bng() != null) {
                    if (!ar.this.fYJ.fWR.bng().bOw()) {
                        ar.this.fYJ.fWR.lA(false);
                    }
                    ar.this.fYJ.fWR.bng().ov(false);
                }
            }
        });
    }

    public void bmj() {
        if (this.fYJ != null && this.Tj != null) {
            this.Tj.pR();
            if (this.fYJ.biP() != null) {
                this.fYJ.biP().MS();
            }
            bmO();
        }
    }

    public void V(String str, boolean z) {
        this.ghg = z;
        ln(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void ln(boolean z) {
        if (this.ghe != null) {
            if (this.ghg) {
                com.baidu.tbadk.core.util.al.i(this.ghe, e.f.pb_praise_already_click_selector);
                this.ghe.setContentDescription(this.fYJ.getResources().getString(e.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.ghe, e.f.pb_praise_normal_click_selector);
            this.ghe.setContentDescription(this.fYJ.getResources().getString(e.j.zan));
        }
    }

    public TextView bmk() {
        return this.ghe;
    }

    public void lo(boolean z) {
        if (this.gfT != null && this.ajh != null && this.dNG != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dNG.setVisibility(0);
                } else {
                    this.dNG.setVisibility(8);
                    this.gfT.removeHeaderView(this.ajh);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ajh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = ghv;
                    this.ajh.setLayoutParams(layoutParams);
                }
                bmz();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ajh.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + lx(true);
                this.ajh.setLayoutParams(layoutParams2);
            }
            bmz();
            bmW();
        }
    }

    public f bml() {
        return this.ggA;
    }

    public void a(PbActivity.d dVar) {
        this.fXP = dVar;
    }

    public void bF(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.ggJ == null) {
            this.ggJ = LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fYJ.getLayoutMode().onModeChanged(this.ggJ);
        if (this.ggI == null) {
            this.ggI = new Dialog(this.fYJ.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.ggI.setCanceledOnTouchOutside(true);
            this.ggI.setCancelable(true);
            this.ggI.setContentView(this.ggJ);
            WindowManager.LayoutParams attributes = this.ggI.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.aO(this.fYJ.getPageContext().getPageActivity()) * 0.9d);
            this.ggI.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ggI.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.ggI.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.ggI.findViewById(e.g.disable_reply_btn);
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
                    if (ar.this.ggI != null && (ar.this.ggI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.ggI, ar.this.fYJ.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(e.g.tag_del_post_id), ((Integer) sparseArray5.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(e.g.tag_forbid_user_name)) && "".equals(sparseArray.get(e.g.tag_forbid_user_name_show))) || bmV()) {
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
                    if (ar.this.ggI != null && (ar.this.ggI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.ggI, ar.this.fYJ.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.gio != null) {
                        ar.this.gio.m(new Object[]{sparseArray6.get(e.g.tag_manage_user_identity), sparseArray6.get(e.g.tag_forbid_user_name), sparseArray6.get(e.g.tag_forbid_user_post_id), sparseArray6.get(e.g.tag_forbid_user_name_show), sparseArray6.get(e.g.tag_forbid_user_portrait)});
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
                    if (ar.this.ggI != null && (ar.this.ggI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.ggI, ar.this.fYJ.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fYJ.a(z, (String) sparseArray7.get(e.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ggI, this.fYJ.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.gio = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fYJ != null && aVar != null) {
            if (this.ekJ == null) {
                this.ekJ = new com.baidu.tieba.NEGFeedBack.e(this.fYJ.getPageContext(), this.gfU);
            }
            AntiData aBj = this.fYJ.aBj();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (aBj != null && aBj.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aBj.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.ekJ.setDefaultReasonArray(new String[]{this.fYJ.getString(e.j.delete_thread_reason_1), this.fYJ.getString(e.j.delete_thread_reason_2), this.fYJ.getString(e.j.delete_thread_reason_3), this.fYJ.getString(e.j.delete_thread_reason_4), this.fYJ.getString(e.j.delete_thread_reason_5)});
            this.ekJ.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ekJ.jy(str);
            this.ekJ.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    ar.this.fYJ.a(aVar, jSONArray);
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
        sparseArray.put(ghC, Integer.valueOf(ghD));
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
        this.ggK = new com.baidu.tbadk.core.dialog.a(this.fYJ.getActivity());
        if (StringUtils.isNull(str2)) {
            this.ggK.db(i3);
        } else {
            this.ggK.bl(false);
            this.ggK.eK(str2);
        }
        this.ggK.H(sparseArray);
        this.ggK.a(e.j.dialog_ok, this.fYJ);
        this.ggK.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ggK.bg(true);
        this.ggK.b(this.fYJ.getPageContext());
        if (z) {
            this.ggK.BS();
        } else {
            a(this.ggK, i);
        }
    }

    public void ap(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.ggN == null) {
            this.ggN = LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.commit_good, (ViewGroup) null);
        }
        this.fYJ.getLayoutMode().onModeChanged(this.ggN);
        if (this.ggM == null) {
            this.ggM = new Dialog(this.fYJ.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.ggM.setCanceledOnTouchOutside(true);
            this.ggM.setCancelable(true);
            this.ggX = (ScrollView) this.ggN.findViewById(e.g.good_scroll);
            this.ggM.setContentView(this.ggN);
            WindowManager.LayoutParams attributes = this.ggM.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds540);
            this.ggM.getWindow().setAttributes(attributes);
            this.daK = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.ggS = (String) compoundButton.getTag();
                        if (ar.this.daJ != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ar.this.daJ) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ar.this.ggS != null && !str.equals(ar.this.ggS)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.ggO = (LinearLayout) this.ggN.findViewById(e.g.good_class_group);
            this.ggQ = (TextView) this.ggN.findViewById(e.g.dialog_button_cancel);
            this.ggQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.ggM instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.ggM, ar.this.fYJ.getPageContext());
                    }
                }
            });
            this.ggP = (TextView) this.ggN.findViewById(e.g.dialog_button_ok);
            this.ggP.setOnClickListener(this.dNr);
        }
        this.ggO.removeAllViews();
        this.daJ = new ArrayList();
        CustomBlueCheckRadioButton cq = cq("0", this.fYJ.getPageContext().getString(e.j.thread_good_class));
        this.daJ.add(cq);
        cq.setChecked(true);
        this.ggO.addView(cq);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.yI()) && aaVar.yJ() > 0) {
                    CustomBlueCheckRadioButton cq2 = cq(String.valueOf(aaVar.yJ()), aaVar.yI());
                    this.daJ.add(cq2);
                    View view = new View(this.fYJ.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, e.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.ggO.addView(view);
                    this.ggO.addView(cq2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ggX.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fYJ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fYJ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fYJ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ggX.setLayoutParams(layoutParams2);
            this.ggX.removeAllViews();
            if (this.ggO != null && this.ggO.getParent() == null) {
                this.ggX.addView(this.ggO);
            }
        }
        com.baidu.adp.lib.g.g.a(this.ggM, this.fYJ.getPageContext());
    }

    private CustomBlueCheckRadioButton cq(String str, String str2) {
        Activity pageActivity = this.fYJ.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, e.C0210e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.daK);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bmm() {
        this.fYJ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fYJ.hideProgressBar();
        if (z && z2) {
            this.fYJ.showToast(this.fYJ.getPageContext().getString(e.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.neterror);
            }
            this.fYJ.showToast(str);
        }
    }

    public void aTJ() {
        this.ggG.setVisibility(0);
    }

    public void aTI() {
        this.ggG.setVisibility(8);
    }

    public View bmn() {
        if (this.ggN != null) {
            return this.ggN.findViewById(e.g.dialog_button_ok);
        }
        return null;
    }

    public String bmo() {
        return this.ggS;
    }

    public View getView() {
        return this.drQ;
    }

    public void bmp() {
        com.baidu.adp.lib.util.l.b(this.fYJ.getPageContext().getPageActivity(), this.fYJ.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fYJ.hideProgressBar();
        if (z) {
            bmF();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bmG();
        } else {
            bmF();
        }
    }

    public void bmq() {
        this.dRb.Fl();
        this.dRb.Fp();
    }

    public void bmr() {
        this.fYJ.hideProgressBar();
        Fq();
        this.gfT.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bmC();
    }

    public void bms() {
        this.gfT.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bmC();
    }

    private void lp(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ghb.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fYJ.getResources().getDimensionPixelSize(e.C0210e.ds130) : this.fYJ.getResources().getDimensionPixelSize(e.C0210e.ds34);
        this.ghb.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.ggA.setOnLongClickListener(onLongClickListener);
        if (this.ghZ != null) {
            this.ghZ.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z, boolean z2) {
        if (this.ggT != null) {
            this.ggT.dismiss();
            this.ggT = null;
        }
        this.ggT = new com.baidu.tbadk.core.dialog.b(this.fYJ.getPageContext().getPageActivity());
        this.ggT.de(e.j.operation);
        if (z2) {
            this.ggT.a(new String[]{this.fYJ.getPageContext().getString(e.j.copy), this.fYJ.getPageContext().getString(e.j.report_text)}, interfaceC0158b);
        } else if (!z) {
            this.ggT.a(new String[]{this.fYJ.getPageContext().getString(e.j.copy), this.fYJ.getPageContext().getString(e.j.mark)}, interfaceC0158b);
        } else {
            this.ggT.a(new String[]{this.fYJ.getPageContext().getString(e.j.copy), this.fYJ.getPageContext().getString(e.j.remove_mark)}, interfaceC0158b);
        }
        this.ggT.d(this.fYJ.getPageContext());
        this.ggT.BV();
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z) {
        if (this.ggU != null) {
            this.ggU.dismiss();
            this.ggU = null;
        }
        this.ggU = new com.baidu.tbadk.core.dialog.b(this.fYJ.getPageContext().getPageActivity());
        if (z) {
            this.ggU.a(new String[]{this.fYJ.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0158b);
        } else {
            this.ggU.a(new String[]{this.fYJ.getPageContext().getString(e.j.save_to_emotion), this.fYJ.getPageContext().getString(e.j.save_to_local)}, interfaceC0158b);
        }
        this.ggU.d(this.fYJ.getPageContext());
        this.ggU.BV();
    }

    public int bmt() {
        return sP(this.gfT.getFirstVisiblePosition());
    }

    private int sP(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.gfT.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.gfT.getAdapter() == null || !(this.gfT.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.gfT.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bmu() {
        int lastVisiblePosition = this.gfT.getLastVisiblePosition();
        if (this.gfJ != null) {
            if (lastVisiblePosition == this.gfT.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return sP(lastVisiblePosition);
    }

    public void sQ(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.gfT != null) {
            if (this.gfP == null || this.gfP.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.gfP.mNavigationBar.getFixedNavHeight();
                if (!(this.fYJ.bjh() != -1)) {
                    if (this.ght != null && (layoutParams = (LinearLayout.LayoutParams) this.ght.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.ght.setLayoutParams(layoutParams);
                    }
                    i--;
                    bna();
                }
                i2 = fixedNavHeight;
            }
            this.gfT.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.gfT.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.ggD.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        this.ggA.a(dVar, false);
        this.ggA.notifyDataSetChanged();
        bmC();
        if (this.ghZ != null) {
            this.ghZ.biz();
        }
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (this.ggj == null) {
            this.fYJ.getLayoutMode().onModeChanged(((ViewStub) this.gfU.findViewById(e.g.praise_layout)).inflate());
            this.ggj = (FrsPraiseView) this.gfU.findViewById(e.g.pb_head_praise_view);
            this.ggj.setIsFromPb(true);
            this.ggy = this.gfU.findViewById(e.g.new_pb_header_item_line_above_praise);
            this.ggj.eD(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.ggj != null) {
            boolean bmC = bmC();
            this.ggj.setVisibility(8);
            if (dVar != null && dVar.zf() != null && dVar.zf().zd() == 0 && this.fZa) {
                if (bmC) {
                    this.ggx.setVisibility(0);
                    return;
                } else {
                    this.ggx.setVisibility(8);
                    return;
                }
            }
            this.ggx.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bhJ() != null) {
            return dVar.bhJ();
        }
        if (!com.baidu.tbadk.core.util.v.I(dVar.bhB())) {
            Iterator<PostData> it = dVar.bhB().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bES() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bhG();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.zT() != null && postData.zT().getUserTbVipInfoData() != null && postData.zT().getUserTbVipInfoData().getvipIntro() != null) {
            postData.zT().getGodUserData().setIntro(postData.zT().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bhz() == null || dVar.bhz().zT() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zT = dVar.bhz().zT();
        String userId = zT.getUserId();
        HashMap<String, MetaData> userMap = dVar.bhz().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zT;
        }
        postData.vL(1);
        postData.setId(dVar.bhz().Ak());
        postData.setTitle(dVar.bhz().getTitle());
        postData.setTime(dVar.bhz().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0607 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x07bb  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0814  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0347  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String d;
        ArrayList<IconData> tShowInfoNew;
        int h;
        com.baidu.tbadk.data.f bEV;
        String portrait;
        if (dVar != null && dVar.bhz() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.gfZ.setVisibility(8);
            if (dVar.bhz() != null && dVar.bhz().AH() && dVar.bhz().Al() != null) {
                this.ghN = true;
                this.gfP.lM(this.ghN);
                this.gfP.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1")) {
                    LinearLayout linearLayout = (LinearLayout) this.fYJ.findViewById(e.g.pb_comment_container);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.bottomMargin = ghv;
                    linearLayout.setLayoutParams(layoutParams);
                }
                if (this.gfJ == null) {
                    this.gfJ = new com.baidu.tieba.pb.video.i(this.fYJ, this.gfP, dVar.bhz().Al(), this.gfK);
                    this.gfJ.a(dVar.bhz().Al(), dVar.bhz(), dVar.getForumId());
                    this.gfJ.startPlay();
                } else if (this.gfN) {
                    this.gfJ.a(dVar.bhz().Al(), dVar.bhz(), dVar.getForumId());
                    this.gfJ.startPlay();
                } else {
                    this.gfJ.tL(dVar.getForumId());
                }
                if (dVar.bhA() != null && dVar.bhA().size() >= 1) {
                    bb bbVar = dVar.bhA().get(0);
                    this.gfJ.as(bbVar);
                    this.gfJ.tM(bbVar.getTitle());
                }
                this.gfJ.b(b, dVar.bhz(), dVar.bhX());
                this.gfN = false;
                this.gfT.removeHeaderView(this.gfJ.boQ());
                this.gfT.addHeaderView(this.gfJ.boQ(), 0);
                if (this.gfJ.boN() != null && this.gfJ.boN().getParent() == null) {
                    this.ghr.addView(this.gfJ.boN());
                }
                if (this.gfL == null) {
                    this.gfL = new com.baidu.tieba.pb.video.h(this.fYJ);
                }
                this.gfL.a(dVar.bhz().AW(), dVar.bhz(), dVar.bhU());
                this.gfT.removeHeaderView(this.gfL.boE());
                this.gfT.addHeaderView(this.gfL.boE(), 1);
                if (dVar.bhz().AW() != null) {
                    this.gfT.removeHeaderView(this.gfL.boF());
                    this.gfT.removeHeaderView(this.gfX);
                    this.gfT.addHeaderView(this.gfL.boF(), 2);
                } else {
                    if (this.gfL.boF() != null) {
                        this.gfT.removeHeaderView(this.gfL.boF());
                    }
                    this.gfT.removeHeaderView(this.gfX);
                    this.gfX.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fYJ, e.C0210e.tbds26));
                    this.gfT.addHeaderView(this.gfX, 2);
                }
                if (this.gfJ != null) {
                    this.gfP.lG(false);
                    this.gfP.lI(TbadkCoreApplication.isLogin());
                    this.gfJ.sW(TbadkCoreApplication.getInst().getSkinType());
                }
                bmz();
            } else {
                this.ghN = false;
                this.gfP.lM(this.ghN);
                if (this.gfJ != null) {
                    this.gfT.removeHeaderView(this.gfJ.boQ());
                }
                if (this.gfL != null) {
                    this.gfL.b(this.gfT);
                }
                if (b == null || (b != null && (b.bEU() == null || com.baidu.tbadk.core.util.v.I(b.bEU().Sx())))) {
                    this.gfX.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fYJ, e.C0210e.tbds52));
                } else {
                    this.gfX.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fYJ.biT() != null) {
                this.fYJ.biT().lE(this.ghN);
            }
            if (this.gfJ != null) {
                this.gfJ.N(this.giq);
                bna();
            }
            if (b != null) {
                this.ghj = b;
                this.gfZ.setVisibility(0);
                if (this.fYJ.bit()) {
                    if (dVar.bhy() != null) {
                        this.mForumName = dVar.bhy().getForumName();
                        this.mForumId = dVar.bhy().getForumId();
                    }
                    if (this.mForumName == null && this.fYJ.biD() != null && this.fYJ.biD().biu() != null) {
                        this.mForumName = this.fYJ.biD().biu();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.gfZ.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.gfZ.setTag(sparseArray);
                }
                sparseArray.put(e.g.tag_clip_board, b);
                sparseArray.put(e.g.tag_is_subpb, false);
                if (!this.gif) {
                    this.gfV.setVisibility(0);
                }
                if (!dVar.bhz().AH() && this.gfW.getText() != null && this.gfW.getText().length() > 0) {
                    this.gfW.setVisibility(0);
                } else {
                    this.gfW.setVisibility(8);
                }
                p(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> Af = dVar.bhz().Af();
                if (Af != null && Af.size() > 0 && !this.gif) {
                    this.ghm.setText(String.valueOf(Af.get(0).yn()));
                    this.ghl.setVisibility(0);
                } else {
                    this.ghl.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.ghl, e.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.ghm, e.d.cp_link_tip_d, 1);
                if (b.zT() != null) {
                    String string = b.zT().getName_show() == null ? StringUtils.string(b.zT().getUserName()) : StringUtils.string(b.zT().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.zT().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bz(b.zT().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bz(string) > 12) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.zT().getIconInfo();
                            tShowInfoNew = b.zT().getTShowInfoNew();
                            if (this.fZU != null) {
                                this.fZU.setTag(e.g.tag_user_id, b.zT().getUserId());
                                this.fZU.setOnClickListener(this.fYJ.fWN.gki);
                                this.fZU.a(iconInfo, 4, this.fYJ.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fYJ.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fYJ.getResources().getDimensionPixelSize(e.C0210e.tbds12));
                            }
                            if (this.fZT != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fZT.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fZT.setOnClickListener(this.fYJ.fWN.gkj);
                                this.fZT.a(tShowInfoNew, 3, this.fYJ.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fYJ.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fYJ.getResources().getDimensionPixelSize(e.C0210e.ds12), true);
                            }
                            this.ggb.setText(aF(b.zT().getSealPrefix(), d));
                            this.ggb.setTag(e.g.tag_user_id, b.zT().getUserId());
                            this.ggb.setTag(e.g.tag_user_name, b.zT().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew) || b.zT().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.ggb, e.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.ggb, e.d.cp_cont_f, 1);
                            }
                            this.ggc.setVisibility(8);
                            if (dVar.bhz().zT() != null && dVar.bhz().zT().getAlaUserData() != null && this.ggh != null) {
                                if (dVar.bhz().zT().getAlaUserData().anchor_live != 0) {
                                    this.ggh.setVisibility(8);
                                } else {
                                    this.ggh.setVisibility(0);
                                    if (this.gfM == null) {
                                        this.gfM = new com.baidu.tieba.c.d(this.fYJ.getPageContext(), this.ggh);
                                        this.gfM.lk(1);
                                    }
                                    this.gfM.bp(this.fYJ.getResources().getString(e.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.amc = dVar.bhz().zT().getAlaUserData();
                                    aVar.type = 2;
                                    this.ggh.setTag(aVar);
                                }
                            }
                            this.ggg.setUserId(b.zT().getUserId());
                            this.ggg.setUserName(b.zT().getUserName());
                            this.ggg.setTid(b.getId());
                            this.ggg.setFid(this.gcj == null ? this.gcj.getForumId() : "");
                            this.ggg.setImageDrawable(null);
                            this.ggg.setRadius(com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds40));
                            this.ggg.setTag(b.zT().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                                this.ggp.setText(com.baidu.tbadk.core.util.ao.O(b.getTime()));
                            } else {
                                this.ggp.setText(com.baidu.tbadk.core.util.ao.M(b.getTime()));
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds16);
                            if (!this.fYJ.bit() && !StringUtils.isNull(this.mForumName)) {
                                this.aKL.setText(this.fYJ.getString(e.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.aKL.setVisibility(0);
                                this.ggs.setVisibility(0);
                                this.ggp.setPadding(h, 0, h, 0);
                            } else {
                                this.aKL.setVisibility(8);
                                this.ggs.setVisibility(8);
                                this.ggp.setPadding(0, 0, h, 0);
                            }
                            bEV = b.bEV();
                            if (bEV == null && !TextUtils.isEmpty(bEV.getName()) && !TextUtils.isEmpty(bEV.getName().trim())) {
                                final String name = bEV.getName();
                                final String lat = bEV.getLat();
                                final String lng = bEV.getLng();
                                this.ggq.setVisibility(0);
                                this.ggr.setVisibility(0);
                                this.ggq.setText(bEV.getName());
                                this.ggq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                ar.this.fYJ.showToast(e.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ad(ar.this.fYJ.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, ar.this.fYJ.getPageContext().getString(e.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.ggq.setVisibility(8);
                                this.ggr.setVisibility(8);
                            }
                            portrait = b.zT().getPortrait();
                            if (b.zT().getPendantData() == null && !StringUtils.isNull(b.zT().getPendantData().yF())) {
                                this.gge.b(b.zT());
                                this.ggg.setVisibility(8);
                                this.gge.setVisibility(0);
                                if (this.ggk != null) {
                                    this.ggk.setVisibility(8);
                                }
                                this.ggb.setOnClickListener(this.giq);
                                this.gge.getHeadView().startLoad(portrait, 28, false);
                                this.gge.getHeadView().setUserId(b.zT().getUserId());
                                this.gge.getHeadView().setUserName(b.zT().getUserName());
                                this.gge.getHeadView().setTid(b.getId());
                                this.gge.getHeadView().setFid(this.gcj != null ? this.gcj.getForumId() : "");
                                this.gge.getHeadView().setOnClickListener(this.giq);
                                this.gge.gA(b.zT().getPendantData().yF());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.ggg, b.zT());
                                this.ggg.setVisibility(0);
                                this.gfZ.setOnClickListener(this.giq);
                                this.ggb.setOnClickListener(this.giq);
                                this.ggg.setOnClickListener(this.giq);
                                this.gge.setVisibility(8);
                                this.ggg.startLoad(portrait, 28, false);
                            }
                            String name_show = b.zT().getName_show();
                            String userName = b.zT().getUserName();
                            if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                                this.ggb.setText(com.baidu.tieba.pb.c.aC(this.fYJ.getPageContext().getPageActivity(), this.ggb.getText().toString()));
                                this.ggb.setGravity(16);
                                this.ggb.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bhi());
                                com.baidu.tbadk.core.util.al.c(this.ggb, e.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.zT().getIconInfo();
                        tShowInfoNew = b.zT().getTShowInfoNew();
                        if (this.fZU != null) {
                        }
                        if (this.fZT != null) {
                        }
                        this.ggb.setText(aF(b.zT().getSealPrefix(), d));
                        this.ggb.setTag(e.g.tag_user_id, b.zT().getUserId());
                        this.ggb.setTag(e.g.tag_user_name, b.zT().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.ggb, e.d.cp_cont_h, 1);
                        this.ggc.setVisibility(8);
                        if (dVar.bhz().zT() != null) {
                            if (dVar.bhz().zT().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.ggg.setUserId(b.zT().getUserId());
                        this.ggg.setUserName(b.zT().getUserName());
                        this.ggg.setTid(b.getId());
                        this.ggg.setFid(this.gcj == null ? this.gcj.getForumId() : "");
                        this.ggg.setImageDrawable(null);
                        this.ggg.setRadius(com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds40));
                        this.ggg.setTag(b.zT().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds16);
                        if (!this.fYJ.bit()) {
                        }
                        this.aKL.setVisibility(8);
                        this.ggs.setVisibility(8);
                        this.ggp.setPadding(0, 0, h, 0);
                        bEV = b.bEV();
                        if (bEV == null) {
                        }
                        this.ggq.setVisibility(8);
                        this.ggr.setVisibility(8);
                        portrait = b.zT().getPortrait();
                        if (b.zT().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.ggg, b.zT());
                        this.ggg.setVisibility(0);
                        this.gfZ.setOnClickListener(this.giq);
                        this.ggb.setOnClickListener(this.giq);
                        this.ggg.setOnClickListener(this.giq);
                        this.gge.setVisibility(8);
                        this.ggg.startLoad(portrait, 28, false);
                        String name_show2 = b.zT().getName_show();
                        String userName2 = b.zT().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                            this.ggb.setText(com.baidu.tieba.pb.c.aC(this.fYJ.getPageContext().getPageActivity(), this.ggb.getText().toString()));
                            this.ggb.setGravity(16);
                            this.ggb.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bhi());
                            com.baidu.tbadk.core.util.al.c(this.ggb, e.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.zT().getIconInfo();
                            tShowInfoNew = b.zT().getTShowInfoNew();
                            if (this.fZU != null) {
                            }
                            if (this.fZT != null) {
                            }
                            this.ggb.setText(aF(b.zT().getSealPrefix(), d));
                            this.ggb.setTag(e.g.tag_user_id, b.zT().getUserId());
                            this.ggb.setTag(e.g.tag_user_name, b.zT().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.ggb, e.d.cp_cont_h, 1);
                            this.ggc.setVisibility(8);
                            if (dVar.bhz().zT() != null) {
                            }
                            this.ggg.setUserId(b.zT().getUserId());
                            this.ggg.setUserName(b.zT().getUserName());
                            this.ggg.setTid(b.getId());
                            this.ggg.setFid(this.gcj == null ? this.gcj.getForumId() : "");
                            this.ggg.setImageDrawable(null);
                            this.ggg.setRadius(com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds40));
                            this.ggg.setTag(b.zT().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds16);
                            if (!this.fYJ.bit()) {
                            }
                            this.aKL.setVisibility(8);
                            this.ggs.setVisibility(8);
                            this.ggp.setPadding(0, 0, h, 0);
                            bEV = b.bEV();
                            if (bEV == null) {
                            }
                            this.ggq.setVisibility(8);
                            this.ggr.setVisibility(8);
                            portrait = b.zT().getPortrait();
                            if (b.zT().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.ggg, b.zT());
                            this.ggg.setVisibility(0);
                            this.gfZ.setOnClickListener(this.giq);
                            this.ggb.setOnClickListener(this.giq);
                            this.ggg.setOnClickListener(this.giq);
                            this.gge.setVisibility(8);
                            this.ggg.startLoad(portrait, 28, false);
                            String name_show22 = b.zT().getName_show();
                            String userName22 = b.zT().getUserName();
                            if (com.baidu.tbadk.p.an.jJ()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.zT().getIconInfo();
                        tShowInfoNew = b.zT().getTShowInfoNew();
                        if (this.fZU != null) {
                        }
                        if (this.fZT != null) {
                        }
                        this.ggb.setText(aF(b.zT().getSealPrefix(), d));
                        this.ggb.setTag(e.g.tag_user_id, b.zT().getUserId());
                        this.ggb.setTag(e.g.tag_user_name, b.zT().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.ggb, e.d.cp_cont_h, 1);
                        this.ggc.setVisibility(8);
                        if (dVar.bhz().zT() != null) {
                        }
                        this.ggg.setUserId(b.zT().getUserId());
                        this.ggg.setUserName(b.zT().getUserName());
                        this.ggg.setTid(b.getId());
                        this.ggg.setFid(this.gcj == null ? this.gcj.getForumId() : "");
                        this.ggg.setImageDrawable(null);
                        this.ggg.setRadius(com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds40));
                        this.ggg.setTag(b.zT().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fYJ.getActivity(), e.C0210e.ds16);
                        if (!this.fYJ.bit()) {
                        }
                        this.aKL.setVisibility(8);
                        this.ggs.setVisibility(8);
                        this.ggp.setPadding(0, 0, h, 0);
                        bEV = b.bEV();
                        if (bEV == null) {
                        }
                        this.ggq.setVisibility(8);
                        this.ggr.setVisibility(8);
                        portrait = b.zT().getPortrait();
                        if (b.zT().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.ggg, b.zT());
                        this.ggg.setVisibility(0);
                        this.gfZ.setOnClickListener(this.giq);
                        this.ggb.setOnClickListener(this.giq);
                        this.ggg.setOnClickListener(this.giq);
                        this.gge.setVisibility(8);
                        this.ggg.startLoad(portrait, 28, false);
                        String name_show222 = b.zT().getName_show();
                        String userName222 = b.zT().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.gfY.ak(dVar.bhz());
                }
                if (this.ghu != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fUt);
                    if (dVar != null && dVar.bhz() != null) {
                        hVar.fUv = dVar.bhz().zK();
                    }
                    hVar.isNew = !this.fZa;
                    hVar.sortType = dVar.fUk;
                    if (dVar.fUj != null && dVar.fUj.size() > dVar.fUk) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.fUj.size()) {
                                break;
                            } else if (dVar.fUj.get(i4).sort_type.intValue() != dVar.fUk) {
                                i3 = i4 + 1;
                            } else {
                                hVar.fUx = dVar.fUj.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.fUy = this.fYJ.bjF();
                    this.ghu.a(hVar);
                }
            }
        }
    }

    public void lq(boolean z) {
        if (z) {
            bmv();
        } else {
            bmw();
        }
        this.ghy.giI = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ghy));
        a(this.ghy.giI, false);
    }

    public void bmv() {
        if (this.gfP != null && !this.ghP) {
            this.gfP.lN(!StringUtils.isNull(this.fYJ.bje()));
            this.ghP = true;
        }
    }

    public void bmw() {
        if (this.gfP != null) {
            this.gfP.bnG();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Ap() != null) {
            this.gga.setData(this.fYJ.getPageContext(), dVar.bhB().get(0).Ap(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.bhx().getId(), dVar.bhx().getName(), dVar.bhz().getId(), this.fYJ.bjC() ? "FRS" : null));
            this.gfZ.setPadding(this.gfZ.getPaddingLeft(), (int) this.fYJ.getResources().getDimension(e.C0210e.ds20), this.gfZ.getPaddingRight(), this.gfZ.getPaddingBottom());
            return;
        }
        this.gga.setData(null, null, null);
    }

    public void bmx() {
        if (this.gfJ != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").y("obj_type", 1));
            this.gfJ.boO();
            this.gfT.smoothScrollToPosition(0);
        }
    }

    public boolean bmy() {
        return this.gir;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.zT() == null || bbVar.zT().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.zT().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.gfP.bnE();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.gfP.rn(cVar.forumName);
            }
            String string = this.fYJ.getResources().getString(e.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.fYJ.getResources().getString(e.j.self);
                    break;
                case 300:
                    str = this.fYJ.getResources().getString(e.j.bawu);
                    break;
                case 400:
                    str = this.fYJ.getResources().getString(e.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fTB;
            this.fYJ.showNetRefreshView(this.drQ, format, null, this.fYJ.getResources().getString(e.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.ll()) {
                        ay.Es().c(ar.this.fYJ.getPageContext(), new String[]{str2});
                        ar.this.fYJ.finish();
                        return;
                    }
                    ar.this.fYJ.showToast(e.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable blG;
        Parcelable blG2;
        String str;
        if (dVar != null) {
            this.gcj = dVar;
            this.mType = i;
            if (dVar.bhz() != null) {
                this.ghA = dVar.bhz().zC();
                if (dVar.bhz().getAnchorLevel() != 0) {
                    this.gir = true;
                }
                this.ggW = am(dVar.bhz());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            s(dVar);
            this.ghk = false;
            this.fZa = z;
            bmr();
            b(dVar, z, i);
            q(dVar);
            if (this.gic == null) {
                this.gic = new ac(this.fYJ.getPageContext(), this.alI);
            }
            this.gic.ts(dVar.bhE());
            if (this.fYJ.bjt()) {
                if (this.ggE == null) {
                    this.ggE = new com.baidu.tieba.pb.view.d(this.fYJ.getPageContext());
                    this.ggE.oH();
                    this.ggE.a(this.aJh);
                }
                this.gfT.setPullRefresh(this.ggE);
                bmz();
                if (this.ggE != null) {
                    this.ggE.ey(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.zf().zd() == 0 && z) {
                this.gfT.setPullRefresh(null);
            } else {
                if (this.ggE == null) {
                    this.ggE = new com.baidu.tieba.pb.view.d(this.fYJ.getPageContext());
                    this.ggE.oH();
                    this.ggE.a(this.aJh);
                }
                this.gfT.setPullRefresh(this.ggE);
                bmz();
                if (this.ggE != null) {
                    this.ggE.ey(TbadkCoreApplication.getInst().getSkinType());
                }
                alK();
            }
            bmC();
            this.ggA.kD(this.fZa);
            this.ggA.kE(false);
            this.ggA.kP(i == 5);
            this.ggA.kQ(i == 6);
            this.ggA.kR(z2 && this.gip);
            this.ggA.a(dVar, false);
            this.ggA.notifyDataSetChanged();
            if (this.fYJ.bit()) {
                this.ghR = 0;
                PostData b = b(dVar, z);
                if (b != null && b.zT() != null) {
                    this.ghR = b.zT().getLevel_id();
                }
                if (this.ghR > 0) {
                    this.ggd.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.ggd, BitmapHelper.getGradeResourceIdInEnterForum(this.ghR));
                } else {
                    this.ggd.setVisibility(8);
                }
            } else {
                this.ggd.setVisibility(8);
            }
            if (dVar.bhz() != null) {
                if (dVar.bhz().zG() != null) {
                    if (dVar.bhz().zG().getNum() < 1) {
                        str = this.fYJ.getResources().getString(e.j.zan);
                    } else {
                        str = dVar.bhz().zG().getNum() + "";
                    }
                    if (this.gfI != -1) {
                        dVar.bhz().zG().setIsLike(this.gfI);
                    }
                    V(str, dVar.bhz().zG().getIsLike() == 1);
                }
                if (dVar.bhz().avV != null && dVar.bhz().avV.isDeleted) {
                    this.gfP.lH(true);
                } else {
                    this.gfP.lH(false);
                }
            }
            if (this.fYJ.isLogin()) {
                this.gfT.setNextPage(this.dRb);
                this.gfO = 2;
                alK();
            } else {
                this.ghk = true;
                if (dVar.zf().zc() == 1) {
                    if (this.ggF == null) {
                        this.ggF = new com.baidu.tieba.pb.view.a(this.fYJ.getPageContext());
                    }
                    this.gfT.setNextPage(this.ggF);
                } else {
                    this.gfT.setNextPage(this.dRb);
                }
                this.gfO = 3;
            }
            ArrayList<PostData> bhB = dVar.bhB();
            if (dVar.zf().zc() == 0 || bhB == null || bhB.size() < dVar.zf().zb()) {
                if (com.baidu.tbadk.core.util.v.H(bhB) == 0 || (com.baidu.tbadk.core.util.v.H(bhB) == 1 && bhB.get(0) != null && bhB.get(0).bES() == 1)) {
                    this.dRb.setText(this.fYJ.getResources().getString(e.j.list_no_more_new));
                    if (this.fYJ.biT() != null && !this.fYJ.biT().bnu()) {
                        this.fYJ.biT().showFloatingView();
                    }
                } else if (dVar.zf().zc() == 0) {
                    this.dRb.setText(this.fYJ.getResources().getString(e.j.list_has_no_more));
                } else {
                    this.dRb.setText(this.fYJ.getResources().getString(e.j.load_more));
                }
                if (this.fYJ.bjt() && this.gfT != null && this.gfT.getData() != null && this.gfT.getData().size() == 1 && (this.gfT.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dRb.setText("");
                }
                bmJ();
            } else if (z2) {
                if (this.gip) {
                    Fq();
                    if (dVar.zf().zc() != 0) {
                        this.dRb.setText(this.fYJ.getResources().getString(e.j.pb_load_more));
                    }
                } else {
                    this.dRb.Fl();
                    this.dRb.showLoading();
                }
            } else {
                this.dRb.Fl();
                this.dRb.showLoading();
            }
            switch (i) {
                case 2:
                    this.gfT.setSelection(i2 > 1 ? (((this.gfT.getData() == null && dVar.bhB() == null) ? 0 : (this.gfT.getData().size() - dVar.bhB().size()) + this.gfT.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (blG2 = aj.blF().blG()) != null) {
                        this.gfT.onRestoreInstanceState(blG2);
                        if (com.baidu.tbadk.core.util.v.H(bhB) > 1 && dVar.zf().zc() > 0) {
                            this.dRb.Fq();
                            this.dRb.setText(this.fYJ.getString(e.j.pb_load_more_without_point));
                            this.dRb.Fm();
                            break;
                        }
                    } else {
                        this.gfT.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.gip = false;
                    break;
                case 5:
                    this.gfT.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (blG = aj.blF().blG()) != null) {
                        this.gfT.onRestoreInstanceState(blG);
                        break;
                    } else {
                        this.gfT.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.gfJ != null && this.gfJ.boN() != null) {
                            if (this.fYJ.isUseStyleImmersiveSticky()) {
                                this.gfT.setSelectionFromTop((this.ggA.bjY() + this.gfT.getHeaderViewsCount()) - 1, this.gfJ.boN().getHeight() - com.baidu.adp.lib.util.l.r(this.fYJ.getPageContext().getPageActivity()));
                            } else {
                                this.gfT.setSelectionFromTop((this.ggA.bjY() + this.gfT.getHeaderViewsCount()) - 1, this.gfJ.boN().getHeight());
                            }
                        } else {
                            this.gfT.setSelection(this.ggA.bjY() + this.gfT.getHeaderViewsCount());
                        }
                    } else {
                        this.gfT.setSelection(i2 > 0 ? ((this.gfT.getData() == null && dVar.bhB() == null) ? 0 : (this.gfT.getData().size() - dVar.bhB().size()) + this.gfT.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dRb.Fq();
                    this.dRb.setText(this.fYJ.getString(e.j.pb_load_more_without_point));
                    this.dRb.Fm();
                    break;
            }
            if (this.ghA == ghB && isHost()) {
                bmR();
            }
            if (this.ghL) {
                blP();
                this.ghL = false;
                if (i3 == 0) {
                    lj(true);
                }
            }
            if (this.gfL != null) {
                this.gfL.ar(dVar.bhz());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fUh == 1 || dVar.fUi == 1) {
                if (this.ghS == null) {
                    this.ghS = new PbTopTipView(this.fYJ);
                }
                if (dVar.fUi == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fYJ.getStType())) {
                    this.ghS.setText(this.fYJ.getString(e.j.pb_read_strategy_add_experience));
                    this.ghS.show(this.drQ, this.mSkinType);
                } else if (dVar.fUh == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fYJ.getStType())) {
                    this.ghS.setText(this.fYJ.getString(e.j.pb_read_news_add_experience));
                    this.ghS.show(this.drQ, this.mSkinType);
                }
            }
        }
    }

    private void bmz() {
        if (this.gfJ != null && this.gfJ.boN() != null) {
            this.gfT.removeHeaderView(this.ajh);
            if (this.mType != 1) {
                this.gfT.removeHeaderView(this.gfJ.boQ());
                this.gfT.addHeaderView(this.gfJ.boQ(), 0);
                return;
            }
            return;
        }
        if (this.gfJ != null) {
            this.gfT.removeHeaderView(this.gfJ.boQ());
        }
        this.gfT.removeHeaderView(this.ajh);
        this.gfT.addHeaderView(this.ajh, 0);
    }

    public void lr(boolean z) {
        this.ggV = z;
    }

    public void Fq() {
        if (this.dRb != null) {
            this.dRb.Fm();
            this.dRb.Fq();
        }
        alK();
    }

    public void anM() {
        this.gfT.setVisibility(0);
    }

    public void q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.ghj != null && this.ghj.zT() != null && this.gfP != null) {
            this.ghO = !this.ghN;
            this.gfP.lG(this.ghO);
            if (this.fYJ.biT() != null) {
                this.fYJ.biT().lF(this.ghO);
            }
            bmA();
            if (this.ghO) {
                this.gfP.gkV.setVisibility(0);
                if (this.ggW) {
                    this.gfP.gkW.setVisibility(8);
                    this.ggl.setVisibility(8);
                    this.ggo.setVisibility(0);
                    this.ggo.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.T(dVar.bhW())));
                } else if (!PbNormalLikeButtonSwitchStatic.PW() || (this.ghj.zT().hadConcerned() && this.ghj.zT().getGodUserData() != null && this.ghj.zT().getGodUserData().getIsFromNetWork())) {
                    this.gfP.gkW.setVisibility(8);
                }
                if (this.ght != null) {
                    this.ght.setVisibility(8);
                }
                this.gfP.a(this.ghj.zT(), this.giq);
                if (this.gia == null) {
                    this.gia = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.ghQ) {
                                ar.this.bmQ();
                            }
                            ar.this.bms();
                        }
                    };
                }
                this.gfT.setListViewDragListener(this.gia);
                return;
            }
            if (this.gfP.gkV != null) {
                this.gfP.gkV.setVisibility(8);
            }
            if (this.ght != null) {
                this.ght.setVisibility(0);
            }
            if (this.ggW) {
                this.ggl.setVisibility(8);
                this.ggo.setVisibility(0);
                this.ggo.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.T(dVar.bhW())));
            } else if (!PbNormalLikeButtonSwitchStatic.PW() || (this.ghj.zT().hadConcerned() && this.ghj.zT().getGodUserData() != null && this.ghj.zT().getGodUserData().getIsFromNetWork())) {
                this.ggl.setVisibility(8);
                this.ggo.setVisibility(8);
            } else {
                this.ggo.setVisibility(8);
            }
            this.gia = null;
            this.gfT.setListViewDragListener(null);
        }
    }

    private void bmA() {
        String threadId = this.gcj != null ? this.gcj.getThreadId() : "";
        int bmB = bmB();
        if (this.ghO) {
            if (this.ggn == null) {
                this.ggn = new ap(this.fYJ.getPageContext(), this.gfP.gkW, 3);
                this.ggn.h(this.fYJ.getUniqueId());
            }
            if (this.ghj != null && this.ghj.zT() != null) {
                this.ghj.zT().setIsLike(this.ghj.zT().hadConcerned());
                this.ggn.a(this.ghj.zT());
            }
            this.ggn.setTid(threadId);
            this.ggn.sO(bmB);
            this.ggn.gfE = this.ghN;
        }
        if (this.ggm == null) {
            this.ggm = new ap(this.fYJ.getPageContext(), this.ggl, 1);
            this.ggm.h(this.fYJ.getUniqueId());
            this.ggm.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bM(boolean z) {
                    if (ar.this.fYJ != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fYJ, e.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fYJ.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.ghj != null && this.ghj.zT() != null) {
            this.ghj.zT().setIsLike(this.ghj.zT().hadConcerned());
            this.ggm.a(this.ghj.zT());
            this.ggm.setTid(threadId);
        }
        this.ggm.gfE = this.ghN;
        this.ggm.sO(bmB);
    }

    public int bmB() {
        if (this.gcj == null || this.gcj.bhz() == null) {
            return 0;
        }
        if (this.gcj.bhz().Be()) {
            return (com.baidu.tbadk.core.util.v.I(this.gcj.bhV()) && (this.gcj.bhy() == null || StringUtils.isNull(this.gcj.bhy().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bmC() {
        boolean z;
        if (this.ggZ != null && this.ggZ.getVisibility() == 0) {
            if (this.ggw != null) {
                this.ggw.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.ggw != null) {
                this.ggw.setVisibility(8);
            }
            z = false;
        }
        if ((this.ggy == null || this.ggy.getVisibility() == 8) && z && this.fZa) {
            this.ggx.setVisibility(0);
        } else {
            this.ggx.setVisibility(8);
        }
        return z;
    }

    private boolean r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bhz() == null) {
            return false;
        }
        if (dVar.bhz().zQ() == 1 || dVar.bhz().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bhz().zS() == null || dVar.bhz().zS().BG() == 0) || dVar.bhz().zO() == 1 || dVar.bhz().zP() == 1 || dVar.bhz().Ay() || dVar.bhz().AL() || dVar.bhz().AG() || dVar.bhz().Ag() != null || !com.baidu.tbadk.core.util.ao.isEmpty(dVar.bhz().getCategory()) || dVar.bhz().zW() || dVar.bhz().zV();
    }

    private SpannableStringBuilder aF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fYJ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.gfV != null) {
                if (dVar.bhz() != null && dVar.bhz().Aj() == 0 && !dVar.bhz().AH() && !this.gif) {
                    this.gfV.setVisibility(0);
                    if (dVar.bhz() != null) {
                        bb bhz = dVar.bhz();
                        bhz.g(true, r(dVar));
                        bhz.setResource(3);
                        bhz.eu("2");
                    }
                    SpannableStringBuilder At = dVar.bhz().At();
                    this.gfW.setOnTouchListener(new com.baidu.tieba.view.k(At));
                    this.gfW.setText(At);
                    this.gfW.setVisibility(0);
                } else if (dVar.bhz().Aj() == 1) {
                    if (dVar.bhz() != null) {
                        this.gfV.setVisibility(8);
                        this.gfT.removeHeaderView(this.gfV);
                        if (dVar.bhz() != null && !dVar.bhz().AH()) {
                            this.gfZ.setPadding(this.gfZ.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.tbds36), this.gfZ.getPaddingRight(), this.gfZ.getPaddingBottom());
                        }
                    }
                } else {
                    this.gfV.setVisibility(8);
                    this.gfT.removeHeaderView(this.gfV);
                    if (dVar.bhz() != null && dVar.bhz().AH()) {
                        this.gfZ.setPadding(this.gfZ.getPaddingLeft(), 0, this.gfZ.getPaddingRight(), this.gfZ.getPaddingBottom());
                    } else {
                        this.gfZ.setPadding(this.gfZ.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds48), this.gfZ.getPaddingRight(), this.gfZ.getPaddingBottom());
                    }
                }
            }
            this.fZa = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bmC();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.zT().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bhL()));
                sparseArray.put(e.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.zT() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, b.zT().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, b.zT().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, b.zT().getPortrait());
                    sparseArray.put(e.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bhL()));
                sparseArray.put(e.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.ay> bhV = dVar.bhV();
                if (com.baidu.tbadk.core.util.v.H(bhV) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.ay ayVar : bhV) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.atC) != null && tVar.arC && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(this.fYJ.getString(e.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(e.g.tag_del_multi_forum, String.format(this.fYJ.getString(e.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bfU;
    }

    public void tt(String str) {
        if (this.dRb != null) {
            this.dRb.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.gfT;
    }

    public int bmD() {
        return e.g.richText;
    }

    public TextView biO() {
        return this.gfY.biO();
    }

    public void e(BdListView.e eVar) {
        this.gfT.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.aJh = bVar;
        if (this.ggE != null) {
            this.ggE.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int za = alVar.za();
            int yX = alVar.yX();
            if (this.ggB != null) {
                this.ggB.BS();
            } else {
                this.ggB = new com.baidu.tbadk.core.dialog.a(this.fYJ.getPageContext().getPageActivity());
                this.ggC = LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.dialog_direct_pager, (ViewGroup) null);
                this.ggB.G(this.ggC);
                this.ggB.a(e.j.dialog_ok, bVar);
                this.ggB.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bmF();
                        aVar.dismiss();
                    }
                });
                this.ggB.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.ghI == null) {
                            ar.this.ghI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fYJ.HidenSoftKeyPad((InputMethodManager) ar.this.fYJ.getSystemService("input_method"), ar.this.drQ);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jG().postDelayed(ar.this.ghI, 150L);
                    }
                });
                this.ggB.b(this.fYJ.getPageContext()).BS();
            }
            this.ggD = (EditText) this.ggC.findViewById(e.g.input_page_number);
            this.ggD.setText("");
            TextView textView = (TextView) this.ggC.findViewById(e.g.current_page_number);
            if (za <= 0) {
                za = 1;
            }
            if (yX <= 0) {
                yX = 1;
            }
            textView.setText(MessageFormat.format(this.fYJ.getApplicationContext().getResources().getString(e.j.current_page), Integer.valueOf(za), Integer.valueOf(yX)));
            this.fYJ.ShowSoftKeyPadDelay(this.ggD, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gfT.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fYJ.showToast(str);
    }

    public boolean ls(boolean z) {
        if (this.Tj == null || !this.Tj.Ms()) {
            return false;
        }
        this.Tj.KM();
        return true;
    }

    public void bmE() {
        if (this.gis != null) {
            while (this.gis.size() > 0) {
                TbImageView remove = this.gis.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bmE();
        this.ggA.sz(1);
        if (this.gfJ != null) {
            this.gfJ.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.ggA.sz(2);
        if (this.gfJ != null) {
            this.gfJ.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.ghK != null) {
            this.ghK.destroy();
        }
        if (this.gic != null) {
            this.gic.onDestory();
        }
        if (this.ghS != null) {
            this.ghS.hide();
        }
        if (this.gfM != null) {
            this.gfM.asz();
        }
        if (this.gfL != null) {
            this.gfL.onDestroy();
        }
        this.fYJ.hideProgressBar();
        if (this.drO != null && this.dJm != null) {
            this.drO.b(this.dJm);
        }
        bmF();
        Fq();
        if (this.ghI != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ghI);
        }
        if (this.gfZ != null && this.ggk != null) {
            this.gfZ.removeView(this.ggf);
            this.ggk = null;
        }
        if (this.gho != null) {
            this.gho.clearStatus();
        }
        this.gil = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.ggA.sz(3);
        if (this.dNG != null) {
            this.dNG.setBackgroundDrawable(null);
        }
        if (this.gfJ != null) {
            this.gfJ.destroy();
        }
        if (this.ggA != null) {
            this.ggA.onDestroy();
        }
        this.gfT.setOnLayoutListener(null);
        if (this.ghY != null) {
            this.ghY.aEp();
        }
        if (this.ghz != null) {
            this.ghz.onDestroy();
        }
        bnb();
    }

    public boolean sR(int i) {
        if (this.gfJ != null) {
            return this.gfJ.mI(i);
        }
        return false;
    }

    public void bmF() {
        this.gfP.dismissPopMenu();
        if (this.gfM != null) {
            this.gfM.asz();
        }
        com.baidu.adp.lib.util.l.b(this.fYJ.getPageContext().getPageActivity(), this.ggD);
        blR();
        if (this.ggT != null) {
            this.ggT.dismiss();
        }
        bmH();
        if (this.gfL != null) {
            this.gfL.boG();
        }
        if (this.ggB != null) {
            this.ggB.dismiss();
        }
        if (this.dNq != null) {
            this.dNq.dismiss();
        }
    }

    public void bmG() {
        this.gfP.dismissPopMenu();
        if (this.gfM != null) {
            this.gfM.asz();
        }
        if (this.ggT != null) {
            this.ggT.dismiss();
        }
        bmH();
        if (this.gfL != null) {
            this.gfL.boG();
        }
        if (this.ggB != null) {
            this.ggB.dismiss();
        }
        if (this.dNq != null) {
            this.dNq.dismiss();
        }
    }

    public void dp(List<String> list) {
        this.ghX = list;
        if (this.ghY != null) {
            this.ghY.setData(list);
        }
    }

    public void kC(boolean z) {
        this.ggA.kC(z);
    }

    public void lt(boolean z) {
        this.ggY = z;
    }

    public void bmH() {
        if (this.ggK != null) {
            this.ggK.dismiss();
        }
        if (this.ggL != null) {
            com.baidu.adp.lib.g.g.b(this.ggL, this.fYJ.getPageContext());
        }
        if (this.ggM != null) {
            com.baidu.adp.lib.g.g.b(this.ggM, this.fYJ.getPageContext());
        }
        if (this.ggI != null) {
            com.baidu.adp.lib.g.g.b(this.ggI, this.fYJ.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.gcj, this.fZa);
            d(this.gcj, this.fZa, this.mType);
            this.fYJ.getLayoutMode().setNightMode(i == 1);
            this.fYJ.getLayoutMode().onModeChanged(this.drQ);
            this.fYJ.getLayoutMode().onModeChanged(this.gfU);
            if (this.gfL != null) {
                this.gfL.onChangeSkinType(i);
            }
            if (this.gfW != null) {
                com.baidu.tbadk.core.util.al.h(this.gfW, e.d.cp_cont_b);
                this.gfW.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            }
            if (this.dRb != null) {
                this.dRb.ey(i);
                if (this.bfU != null) {
                    this.fYJ.getLayoutMode().onModeChanged(this.bfU);
                    com.baidu.tbadk.core.util.al.i(this.bfU, e.f.pb_foot_more_trans_selector);
                }
            }
            if (this.ggB != null) {
                this.ggB.c(this.fYJ.getPageContext());
            }
            lr(this.ggV);
            this.ggA.notifyDataSetChanged();
            if (this.ggE != null) {
                this.ggE.ey(i);
            }
            if (this.Tj != null) {
                this.Tj.onChangeSkinType(i);
            }
            if (this.ggj != null) {
                this.ggj.eD(i);
            }
            if (this.ggF != null) {
                this.ggF.ey(i);
            }
            if (!com.baidu.tbadk.core.util.v.I(this.daJ)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.daJ) {
                    customBlueCheckRadioButton.EV();
                }
            }
            ln(i == 1);
            bmg();
            UtilHelper.setStatusBarBackground(this.dNG, i);
            UtilHelper.setStatusBarBackground(this.ght, i);
            if (this.ggl != null) {
                this.ggl.onChangeSkinType(i);
            }
            if (this.ggq != null) {
                com.baidu.tbadk.core.util.al.h(this.ggq, e.d.cp_cont_d);
            }
            if (this.ggp != null) {
                com.baidu.tbadk.core.util.al.h(this.ggp, e.d.cp_cont_d);
            }
            if (this.ggr != null) {
                com.baidu.tbadk.core.util.al.i(this.ggr, e.d.cp_cont_e);
            }
            if (this.aKL != null) {
                com.baidu.tbadk.core.util.al.h(this.aKL, e.d.cp_cont_d);
            }
            if (this.ggs != null) {
                com.baidu.tbadk.core.util.al.i(this.ggs, e.d.cp_cont_e);
            }
            if (this.ggc != null) {
                com.baidu.tbadk.core.util.al.h(this.ggc, e.d.cp_link_tip_a);
            }
            if (this.ggo != null) {
                com.baidu.tbadk.core.util.al.h(this.ggo, e.d.cp_cont_d);
            }
            if (this.ggt != null) {
                com.baidu.tbadk.o.a.a(this.fYJ.getPageContext(), this.ggt);
            }
            if (this.ggR != null) {
                com.baidu.tbadk.o.a.a(this.fYJ.getPageContext(), this.ggR);
            }
            if (this.ghJ != null) {
                this.ghJ.onChangeSkinType(i);
            }
            if (this.gfP != null) {
                if (this.gfJ != null) {
                    this.gfJ.sW(i);
                } else {
                    this.gfP.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.ghb != null) {
                com.baidu.tbadk.core.util.al.h(this.ghb, e.d.cp_cont_e);
            }
            if (this.ggd != null) {
                com.baidu.tbadk.core.util.al.c(this.ggd, BitmapHelper.getGradeResourceIdInEnterForum(this.ghR));
            }
            if (this.ghZ != null) {
                this.ghZ.onChangeSkinType(i);
            }
            if (this.ghz != null) {
                this.ghz.onChangeSkinType();
            }
            if (this.ghV != null) {
                com.baidu.tbadk.core.util.al.h(this.ghV, e.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsD = hVar;
        this.ggA.setOnImageClickListener(this.bsD);
        this.ghZ.setOnImageClickListener(this.bsD);
    }

    public void h(NoNetworkView.a aVar) {
        this.dJm = aVar;
        if (this.drO != null) {
            this.drO.a(this.dJm);
        }
    }

    public void lu(boolean z) {
        this.ggA.setIsFromCDN(z);
    }

    public Button bmI() {
        return this.ggZ;
    }

    public void bmJ() {
        if (this.gfO != 2) {
            this.gfT.setNextPage(this.dRb);
            this.gfO = 2;
        }
    }

    public void bmK() {
        if (com.baidu.tbadk.l.m.PD().PE()) {
            int lastVisiblePosition = this.gfT.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gfT.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(e.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.gj(1001);
                                perfLog.bgA = true;
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
                        perfLog2.gj(1001);
                        perfLog2.bgA = true;
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

    public boolean bmL() {
        return this.Tj != null && this.Tj.getVisibility() == 0;
    }

    public boolean bmM() {
        return this.Tj != null && this.Tj.Ms();
    }

    public void bmN() {
        if (this.Tj != null) {
            this.Tj.KM();
        }
    }

    public void lv(boolean z) {
        if (this.gha != null) {
            lt(this.fYJ.biP().MV());
            if (this.ggY) {
                lk(z);
            } else {
                ll(z);
            }
        }
    }

    public void bmO() {
        if (this.gha != null) {
            this.gha.setVisibility(8);
            this.ghf = false;
            if (this.ghz != null) {
                this.ghz.setVisibility(8);
                lp(false);
            }
            bnb();
        }
    }

    public void showLoadingDialog() {
        if (this.dig == null) {
            this.dig = new com.baidu.tbadk.core.view.d(this.fYJ.getPageContext());
        }
        this.dig.bB(true);
    }

    public void alK() {
        if (this.dig != null) {
            this.dig.bB(false);
        }
    }

    private int getScrollY() {
        View childAt = this.gfT.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.gfT.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.gfJ != null) {
            this.gfJ.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.git = getScrollY();
            this.ghy.giI = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ghy));
            a(this.ghy.giI, true);
        }
    }

    public void lw(boolean z) {
        this.gfJ.lw(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gfJ != null) {
            this.gfJ.b(absListView, i);
        }
        int headerViewsCount = (i - this.gfT.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (headerViewsCount <= i2 && this.ggA.sy(headerViewsCount) != com.baidu.tieba.pb.data.i.fUz) {
            headerViewsCount++;
        }
        boolean z = i < this.gfT.getHeaderViewsCount();
        if (this.gfX != null && this.gfP != null) {
            this.gfP.h(this.gfX.getBottom(), this.gfX.getMeasuredHeight(), z);
        }
        this.ghy.fPd = i;
        this.ghy.headerCount = this.gfT.getHeaderViewsCount();
        this.ghy.giI = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ghy));
        a(this.ghy.giI, false);
    }

    public void bmP() {
        if (this.fYJ.isLogin() && this.gcj != null && this.ghO && !this.ghN && !this.ggW && this.ghj != null && this.ghj.zT() != null && !this.ghj.zT().getIsLike() && !this.ghj.zT().hadConcerned()) {
            if (this.ghK == null) {
                this.ghK = new an(this.fYJ);
            }
            this.ghK.a(this.gfP.gkV, this.gcj.bhZ(), this.ghj.zT().getUserId(), this.gcj.getThreadId());
        }
    }

    public void bmQ() {
        if (this.ghO && !this.ghN && this.ghj != null && this.ghj.zT() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").y("obj_locate", this.fYJ.bit() ? 2 : 1).y("obj_type", this.ghN ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fYJ.getPageContext().getPageActivity(), this.ghj.zT().getUserId(), this.ghj.zT().getUserName(), this.fYJ.biD().biu(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.ghN && this.ghs != null && this.gfP.bnz() != null) {
            int bjZ = this.ggA.bjZ();
            if (bjZ > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bjZ > this.gfT.getFirstVisiblePosition() - this.gfT.getHeaderViewsCount()) {
                    this.ghs.setVisibility(8);
                    return;
                }
                this.ghs.setVisibility(0);
                bna();
                this.gfP.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.gfi == null) {
                if (this.gfT.getFirstVisiblePosition() == 0) {
                    this.ghs.setVisibility(8);
                    this.gfP.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.ghx) {
                        this.ghw = top;
                        this.ghx = false;
                    }
                    this.ghw = top < this.ghw ? top : this.ghw;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.ggz.getY() < 0.0f) {
                        measuredHeight = ghv - alVar.gfi.getMeasuredHeight();
                    } else {
                        measuredHeight = this.gfP.bnz().getMeasuredHeight() - alVar.gfi.getMeasuredHeight();
                        this.gfP.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.ghw) {
                        this.ghs.setVisibility(0);
                        bna();
                    } else if (top < measuredHeight) {
                        this.ghs.setVisibility(0);
                        bna();
                    } else {
                        this.ghs.setVisibility(8);
                        this.gfP.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.ghx = true;
                    }
                }
            }
        }
    }

    public void bmR() {
        if (!this.giu) {
            TiebaStatic.log("c10490");
            this.giu = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fYJ.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(ghC, Integer.valueOf(ghE));
            aVar.da(e.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.function_description_view)).setText(e.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(e.g.title_view)).setText(e.j.grade_thread_tips);
            aVar.G(inflate);
            aVar.H(sparseArray);
            aVar.a(e.j.grade_button_tips, this.fYJ);
            aVar.b(e.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fYJ.getPageContext()).BS();
        }
    }

    public void tu(String str) {
        if (str.contains(BaseRequestAction.SPLITE)) {
            str = str.replace(BaseRequestAction.SPLITE, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fYJ.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(e.g.function_description_view)).setVisibility(8);
        aVar.G(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(ghC, Integer.valueOf(ghF));
        aVar.H(sparseArray);
        aVar.a(e.j.view, this.fYJ);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fYJ.getPageContext()).BS();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.zT() != null) {
            MetaData zT = b.zT();
            zT.setGiftNum(zT.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        q(dVar);
    }

    public PbInterviewStatusView bmS() {
        return this.gho;
    }

    private void s(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bhz() != null && dVar.bhz().AL() && this.gho == null) {
            this.gho = (PbInterviewStatusView) this.ghn.inflate();
            this.gho.setOnClickListener(this.dNr);
            this.gho.setCallback(this.fYJ.bjB());
            this.gho.setData(this.fYJ, dVar);
        }
    }

    public LinearLayout bmT() {
        return this.ggz;
    }

    public View bmU() {
        return this.dNG;
    }

    public boolean bmV() {
        return this.gif;
    }

    public void kH(boolean z) {
        this.gfY.kH(z);
    }

    public void tv(String str) {
        if (this.gfQ != null) {
            this.gfQ.setTitle(str);
        }
    }

    private int lx(boolean z) {
        if (this.gho == null || this.gho.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds72);
    }

    private void bmW() {
        if (this.gho != null && this.gho.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gho.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.gho.setLayoutParams(layoutParams);
        }
    }

    public boolean biV() {
        return false;
    }

    public void tw(String str) {
        this.ghb.performClick();
        if (!StringUtils.isNull(str) && this.fYJ.biP() != null && this.fYJ.biP().MO() != null && this.fYJ.biP().MO().getInputView() != null) {
            EditText inputView = this.fYJ.biP().MO().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bmF();
            if (configuration.orientation == 2) {
                bmO();
                blR();
            } else {
                blU();
            }
            if (this.ghJ != null) {
                this.ghJ.bkg();
            }
            this.fYJ.aCk();
            this.ggz.setVisibility(8);
            this.gfP.lJ(false);
            this.fYJ.kN(false);
            if (this.gfJ != null) {
                if (configuration.orientation == 1) {
                    bmT().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.gfT.setIsLandscape(true);
                    this.gfT.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.gfT.setIsLandscape(false);
                    if (this.git > 0) {
                        this.gfT.smoothScrollBy(this.git, 0);
                    }
                }
                this.gfJ.onConfigurationChanged(configuration);
                this.ghr.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void ly(boolean z) {
        this.gfN = z;
    }

    public boolean bmX() {
        return this.gfJ != null && this.gfJ.bmX();
    }

    public void bmY() {
        if (this.gfJ != null) {
            this.gfJ.onPause();
        }
    }

    public void n(long j, int i) {
        if (this.gfL != null) {
            this.gfL.n(j, i);
        }
        if (this.gfJ != null) {
            this.gfJ.n(j, i);
        }
    }

    public void kS(boolean z) {
        this.ggA.kS(z);
    }

    public void bmZ() {
        if (this.ghp == null) {
            LayoutInflater.from(this.fYJ.getActivity()).inflate(e.h.add_experienced_text, (ViewGroup) this.drQ, true);
            this.ghp = (ViewGroup) this.drQ.findViewById(e.g.add_experienced_layout);
            this.ghq = (TextView) this.drQ.findViewById(e.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.ghq, e.d.cp_cont_i);
            String string = this.fYJ.getResources().getString(e.j.experienced_add_success);
            String string2 = this.fYJ.getResources().getString(e.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_h)));
            this.ghq.setText(spannableString);
        }
        this.ghp.setVisibility(0);
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
                        ar.this.ghp.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.ghq.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.ghq.startAnimation(scaleAnimation);
    }

    public void bG(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.gha.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fYJ);
            frameLayout.setBackgroundResource(e.f.pic_sign_tip);
            this.ghV = new TextView(this.fYJ);
            this.ghV.setText(e.j.connection_tips);
            this.ghV.setGravity(17);
            this.ghV.setPadding(com.baidu.adp.lib.util.l.h(this.fYJ, e.C0210e.ds24), 0, com.baidu.adp.lib.util.l.h(this.fYJ, e.C0210e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fYJ, e.C0210e.ds60);
            if (this.ghV.getParent() == null) {
                frameLayout.addView(this.ghV, layoutParams);
            }
            this.ghU = new PopupWindow(this.fYJ);
            this.ghU.setContentView(frameLayout);
            this.ghU.setHeight(-2);
            this.ghU.setWidth(-2);
            this.ghU.setFocusable(true);
            this.ghU.setOutsideTouchable(false);
            this.ghU.setBackgroundDrawable(new ColorDrawable(this.fYJ.getResources().getColor(e.d.transparent)));
            this.gfT.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.ghU.showAsDropDown(ar.this.gha, view.getLeft(), -ar.this.gha.getHeight());
                    } else {
                        ar.this.ghU.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bna() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.ghW == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.ghW = new com.baidu.tbadk.core.dialog.a(this.fYJ);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.fYJ);
            this.ghW.dd(1);
            this.ghW.G(pbLongPressTipView);
            this.ghW.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.31
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ghW.bh(false);
            this.ghW.b(this.fYJ.getPageContext()).BS();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.32
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.ghW != null && ar.this.ghW.isShowing()) {
                        ar.this.ghW.dismiss();
                    }
                }
            }, 5000L);
            if (this.gfJ != null) {
                this.gfJ.boP();
            }
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bnq() != null && !StringUtils.isNull(aVar.bnq().pkg_id) && !StringUtils.isNull(aVar.bnq().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.ghc != null && this.ghc.getVisibility() == 0) {
            if (this.ghT == null) {
                View inflate = LayoutInflater.from(this.fYJ.getPageContext().getPageActivity()).inflate(e.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(e.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(e.g.single_bar_tips);
                textView.setText(e.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dNr);
                this.ghT = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.ghc.getLocationInWindow(iArr);
            this.ghT.showAtLocation(this.ghc, 0, iArr[0] - com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds54), (iArr[1] - this.ghc.getHeight()) - com.baidu.adp.lib.util.l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bnb() {
        com.baidu.adp.lib.g.g.a(this.ghT);
    }

    public void lz(boolean z) {
        this.gib = z;
    }

    public boolean bnc() {
        return this.gib;
    }

    public void bH(View view) {
        this.ggR = view;
    }
}
