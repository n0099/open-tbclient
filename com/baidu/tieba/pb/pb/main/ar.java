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
    private j.b aJi;
    private TextView aKM;
    private TextView ajh;
    private NavigationBarCoverTip alI;
    private View bfV;
    private com.baidu.tieba.pb.a.c bsF;
    private View dNH;
    private View.OnClickListener dNs;
    private PbListView dRc;
    private List<CustomBlueCheckRadioButton> daK;
    private View deT;
    private NoNetworkView drP;
    private RelativeLayout drR;
    private com.baidu.tieba.NEGFeedBack.e ekK;
    PbActivity.d fXQ;
    private PbActivity fYK;
    private UserIconBox fZU;
    private UserIconBox fZV;
    private View.OnClickListener fZi;
    private PbFakeFloorModel gbd;
    private com.baidu.tieba.pb.data.d gck;
    public int gfJ;
    private com.baidu.tieba.pb.video.i gfK;
    private long gfL;
    private com.baidu.tieba.pb.video.h gfM;
    private com.baidu.tieba.c.d gfN;
    public final com.baidu.tieba.pb.pb.main.view.b gfQ;
    public com.baidu.tieba.pb.pb.main.view.a gfR;
    private ViewStub gfS;
    private ViewStub gfT;
    private PbLandscapeListView gfU;
    private View gfV;
    private LinearLayout gfY;
    private e gfZ;
    private ObservedChangeLinearLayout ggA;
    private f ggB;
    private View ggH;
    private ColumnLayout gga;
    private ThreadSkinView ggb;
    private TextView ggc;
    private TextView ggd;
    private ImageView gge;
    private HeadPendantView ggf;
    private FrameLayout ggg;
    private HeadImageView ggh;
    private View ggi;
    private FloatingLayout ggj;
    private PbFirstFloorUserLikeButton ggm;
    private ap ggn;
    private ap ggo;
    private TextView ggp;
    private TextView ggq;
    private TextView ggr;
    private View ggs;
    private View ggt;
    private LinearLayout ggu;
    private TextView ggv;
    private TextView ggw;
    private View ggx;
    private View ggy;
    private PbEmotionBar ghA;
    private int ghI;
    private Runnable ghJ;
    private s ghK;
    private an ghL;
    private int ghR;
    private PbTopTipView ghT;
    private PopupWindow ghU;
    private PopupWindow ghV;
    private TextView ghW;
    private com.baidu.tbadk.core.dialog.a ghX;
    private List<String> ghY;
    private com.baidu.tieba.pb.pb.main.emotion.c ghZ;
    private View ghb;
    private TextView ghc;
    private ImageView ghd;
    private ImageView ghe;
    private TextView ghf;
    private boolean ghh;
    private int ghi;
    private int ghj;
    private PostData ghk;
    private View ghm;
    private TextView ghn;
    private ViewStub gho;
    private PbInterviewStatusView ghp;
    private ViewGroup ghq;
    private TextView ghr;
    private FrameLayout ghs;
    private View ght;
    private View ghu;
    private al ghv;
    private com.baidu.tieba.pb.pb.godreply.a gia;
    private PbLandscapeListView.b gib;
    private ac gie;
    private boolean gig;
    private com.baidu.tbadk.core.view.userLike.c gih;
    private com.baidu.tbadk.core.view.userLike.c gii;
    private Runnable gin;
    private PbActivity.b gip;
    private int giu;
    private boolean isLandscape;
    private int mType;
    private static final int ghw = UtilHelper.getLightStatusBarHeight();
    public static int ghC = 3;
    public static int ghD = 0;
    public static int ghE = 3;
    public static int ghF = 4;
    public static int ghG = 5;
    public static int ghH = 6;
    private static a.InterfaceC0314a gif = new a.InterfaceC0314a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0314a
        public void onRefresh() {
        }
    };
    private boolean gfO = false;
    private int gfP = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout gfW = null;
    private TextView gfX = null;
    public FrsPraiseView ggk = null;
    private ClickableHeaderImageView ggl = null;
    private View ggz = null;
    private com.baidu.tbadk.core.dialog.a ggC = null;
    private com.baidu.tbadk.core.dialog.b dNr = null;
    private View ggD = null;
    private EditText ggE = null;
    private com.baidu.tieba.pb.view.d ggF = null;
    private com.baidu.tieba.pb.view.a ggG = null;
    private com.baidu.tbadk.core.dialog.a ggI = null;
    private b.InterfaceC0158b eWz = null;
    private TbRichTextView.h bsE = null;
    private NoNetworkView.a dJn = null;
    private Dialog ggJ = null;
    private View ggK = null;
    private com.baidu.tbadk.core.dialog.a ggL = null;
    private Dialog ggM = null;
    private Dialog ggN = null;
    private View ggO = null;
    private LinearLayout ggP = null;
    private CompoundButton.OnCheckedChangeListener daL = null;
    private TextView ggQ = null;
    private TextView ggR = null;
    private View ggS = null;
    private String ggT = null;
    private com.baidu.tbadk.core.dialog.b ggU = null;
    private com.baidu.tbadk.core.dialog.b ggV = null;
    private boolean ggW = false;
    private boolean ggX = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView ggY = null;
    private boolean ggZ = false;
    private Button gha = null;
    private boolean ghg = true;
    private com.baidu.tbadk.core.view.d dih = null;
    private boolean fZb = false;
    private int mSkinType = 3;
    private boolean ghl = false;
    private int ghx = 0;
    private boolean ghy = true;
    private a ghz = new a();
    private int ghB = 0;
    private boolean ghM = false;
    private int ghN = 0;
    private boolean ghO = false;
    private boolean ghP = false;
    private boolean ghQ = false;
    private int ghS = 0;
    private boolean gic = false;
    private String gij = null;
    private CustomMessageListener gik = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.gij = null;
            }
        }
    };
    private CustomMessageListener bRk = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.ggB != null) {
                ar.this.ggB.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gil = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.gfX != null) {
                ar.this.gfX.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler gim = new Handler();
    private CustomMessageListener gio = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.ghg = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean giq = true;
    View.OnClickListener gir = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.ghO) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").y(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (ar.this.gfQ != null && ar.this.gfQ.gkY != null && view == ar.this.gfQ.gkY.getHeadView()) {
                if (ar.this.gfQ.gkW == null || ar.this.gfQ.gkW.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").y("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!ar.this.ghO && ar.this.gck != null && ar.this.gck.bhz() != null && ar.this.gck.bhz().zT() != null && ar.this.gck.bhz().zT().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").y("obj_locate", 1));
            }
            ar.this.fYK.fWO.elD.onClick(view);
        }
    };
    private boolean gis = false;
    String userId = null;
    private final List<TbImageView> git = new ArrayList();
    private boolean giv = false;

    /* loaded from: classes6.dex */
    public static class a {
        public int fPe;
        public al giJ;
        public int headerCount;
    }

    public void lj(boolean z) {
        this.ghM = z;
        if (this.gfU != null) {
            this.ghN = this.gfU.getHeaderViewsCount();
        }
    }

    public void blP() {
        if (this.gfU != null) {
            int headerViewsCount = this.gfU.getHeaderViewsCount() - this.ghN;
            final int firstVisiblePosition = (this.gfU.getFirstVisiblePosition() == 0 || this.gfU.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.gfU.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.gfU.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.ghz.giJ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ghz));
            final al alVar = this.ghz.giJ;
            final int h = h(alVar);
            final int y = ((int) this.ggA.getY()) + this.ggA.getMeasuredHeight();
            final boolean z = this.ght.getVisibility() == 0;
            boolean z2 = this.ggA.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.ggB.bjZ() + this.gfU.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.gfj.getMeasuredHeight() : 0;
                if (z2) {
                    this.gfU.setSelectionFromTop(this.ggB.bjZ() + this.gfU.getHeaderViewsCount(), ghw - measuredHeight);
                } else {
                    this.gfU.setSelectionFromTop(this.ggB.bjZ() + this.gfU.getHeaderViewsCount(), this.gfQ.bnz().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.gfU.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.ghO) {
                this.gfU.setSelectionFromTop(this.ggB.bjZ() + this.gfU.getHeaderViewsCount(), this.gfK.boN().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.gfU.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bkq() {
                        if (h >= 0 && h <= ar.this.drR.getMeasuredHeight()) {
                            int h2 = ar.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.deT.getLayoutParams();
                            if (i == 0 || i > ar.this.drR.getMeasuredHeight() || h2 >= ar.this.drR.getMeasuredHeight()) {
                                layoutParams.height = ar.this.ghI;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.drR.getMeasuredHeight()) {
                                layoutParams.height = ar.this.ghI;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.gfU.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.deT.setLayoutParams(layoutParams);
                        }
                        ar.this.gfU.setOnLayoutListener(null);
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
        return this.drP;
    }

    public void blR() {
        if (this.Tj != null) {
            this.Tj.hide();
            if (this.ghZ != null) {
                this.ghZ.ZZ();
            }
        }
    }

    public PbFakeFloorModel blS() {
        return this.gbd;
    }

    public s blT() {
        return this.ghK;
    }

    public void blU() {
        reset();
        blR();
        this.ghK.bkg();
        lv(false);
    }

    private void reset() {
        if (this.fYK != null && this.fYK.biP() != null && this.Tj != null) {
            com.baidu.tbadk.editortools.pb.a.ML().setStatus(0);
            com.baidu.tbadk.editortools.pb.d biP = this.fYK.biP();
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
        return this.ghg;
    }

    public void lk(boolean z) {
        if (this.ghb != null && this.ghc != null) {
            this.ghc.setText(e.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ghb.startAnimation(alphaAnimation);
            }
            this.ghb.setVisibility(0);
            this.ghg = true;
            if (this.ghA != null && !this.gia.isActive()) {
                this.ghA.setVisibility(0);
                lp(true);
            }
        }
    }

    public void ll(boolean z) {
        if (this.ghb != null && this.ghc != null) {
            this.ghc.setText(e.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ghb.startAnimation(alphaAnimation);
            }
            this.ghb.setVisibility(0);
            this.ghg = true;
            if (this.ghA != null && !this.gia.isActive()) {
                this.ghA.setVisibility(0);
                lp(true);
            }
        }
    }

    public PostData blW() {
        int i = 0;
        if (this.gfU == null) {
            return null;
        }
        int blX = blX() - this.gfU.getHeaderViewsCount();
        if (blX < 0) {
            blX = 0;
        }
        if (this.ggB.sy(blX) != null && this.ggB.sy(blX) != PostData.hpD) {
            i = blX + 1;
        }
        return this.ggB.getItem(i) instanceof PostData ? (PostData) this.ggB.getItem(i) : null;
    }

    public int blX() {
        int i;
        View childAt;
        if (this.gfU == null) {
            return 0;
        }
        int firstVisiblePosition = this.gfU.getFirstVisiblePosition();
        int lastVisiblePosition = this.gfU.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.gfU.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.gfU.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        return this.gfU.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.gck != null && this.gck.bhB() != null && !this.gck.bhB().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.gck.bhB().size() && (postData = this.gck.bhB().get(i)) != null && postData.zT() != null && !StringUtils.isNull(postData.zT().getUserId()); i++) {
                if (this.gck.bhB().get(i).zT().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.gia != null && this.gia.isActive()) {
                        lv(false);
                    }
                    if (this.ghA != null) {
                        this.ghA.lD(true);
                    }
                    this.gij = postData.zT().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fYK = null;
        this.drR = null;
        this.dNH = null;
        this.gfL = 0L;
        this.gfU = null;
        this.gfV = null;
        this.gfY = null;
        this.gga = null;
        this.ggc = null;
        this.ggd = null;
        this.ggg = null;
        this.ggh = null;
        this.ggi = null;
        this.ggm = null;
        this.ggp = null;
        this.ggq = null;
        this.ggr = null;
        this.ggs = null;
        this.ggx = null;
        this.ggy = null;
        this.ggB = null;
        this.dRc = null;
        this.bfV = null;
        this.dNs = null;
        this.fZi = null;
        this.ghb = null;
        this.ghc = null;
        this.ghd = null;
        this.ghe = null;
        this.ghf = null;
        this.ghm = null;
        this.ghn = null;
        this.gho = null;
        this.ghR = 0;
        this.gfL = System.currentTimeMillis();
        this.fYK = pbActivity;
        this.dNs = onClickListener;
        this.bsF = cVar;
        this.ghR = com.baidu.adp.lib.util.l.aO(this.fYK) / 2;
        this.drR = (RelativeLayout) LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.new_pb_activity, (ViewGroup) null);
        this.fYK.addContentView(this.drR, new FrameLayout.LayoutParams(-1, -1));
        this.alI = (NavigationBarCoverTip) this.fYK.findViewById(e.g.pb_multi_forum_del_tip_view);
        this.dNH = this.fYK.findViewById(e.g.statebar_view);
        this.ggA = (ObservedChangeLinearLayout) this.fYK.findViewById(e.g.title_wrapper);
        this.drP = (NoNetworkView) this.fYK.findViewById(e.g.view_no_network);
        this.gfU = (PbLandscapeListView) this.fYK.findViewById(e.g.new_pb_list);
        this.ghs = (FrameLayout) this.fYK.findViewById(e.g.root_float_header);
        this.ajh = new TextView(this.fYK.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds88));
        this.gfU.addHeaderView(this.ajh, 0);
        this.ghI = this.fYK.getResources().getDimensionPixelSize(e.C0210e.tbds134);
        this.deT = new View(this.fYK.getPageContext().getPageActivity());
        this.deT.setLayoutParams(new AbsListView.LayoutParams(-1, this.ghI));
        this.deT.setVisibility(4);
        this.gfU.addFooterView(this.deT);
        this.gfU.setOnTouchListener(this.fYK.bjD);
        this.gfQ = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fYK.bjt()) {
            this.gfS = (ViewStub) this.fYK.findViewById(e.g.manga_view_stub);
            this.gfS.setVisibility(0);
            this.gfR = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.gfR.show();
            this.gfQ.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds120);
        }
        this.ajh.setLayoutParams(layoutParams);
        this.gfQ.bnz().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0279a() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0279a
            public void bin() {
                if (ar.this.gfU != null) {
                    if (ar.this.gfK != null) {
                        ar.this.gfK.boO();
                    }
                    ar.this.gfU.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0279a
            public void bio() {
                ar.this.fYK.aCk();
            }
        }));
        this.ghb = this.fYK.findViewById(e.g.pb_editor_tool_comment);
        this.ghi = com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds90);
        this.ghj = com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds242);
        this.ghc = (TextView) this.fYK.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_reply_text);
        this.ghe = (ImageView) this.fYK.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_more_img);
        this.ghd = (ImageView) this.fYK.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_emotion_img);
        this.ghf = (TextView) this.fYK.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_praise_icon);
        this.ghf.setVisibility(8);
        this.ghc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.blZ();
            }
        });
        this.ghd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bnb();
                if (ar.this.fYK.checkUpIsLogin()) {
                    if (ar.this.Tj != null) {
                        ar.this.bmj();
                        ar.this.Tj.aa((View) ar.this.Tj.fI(5));
                    }
                    if (ar.this.Tj != null) {
                        ar.this.ghg = false;
                        if (ar.this.Tj.fL(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fYK, (View) ar.this.Tj.fL(2).aYW, false, ar.gif);
                        }
                    }
                    ar.this.bmO();
                }
            }
        });
        this.ghe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bnb();
                if (ar.this.fYK.checkUpIsLogin()) {
                    if (ar.this.Tj != null) {
                        ar.this.bmj();
                        ar.this.Tj.aa((View) ar.this.Tj.fI(2));
                    }
                    if (ar.this.Tj != null) {
                        ar.this.ghg = false;
                        if (ar.this.Tj.fL(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fYK, (View) ar.this.Tj.fL(2).aYW, false, ar.gif);
                        }
                    }
                    ar.this.bmO();
                }
            }
        });
        this.ghf.setOnClickListener(this.dNs);
        this.ghf.setOnTouchListener(this.fYK);
        this.gfV = LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_item, (ViewGroup) null);
        this.gfY = (LinearLayout) LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_user_item, (ViewGroup) null);
        this.gfZ = new e(this.fYK, this.gfY);
        this.gfZ.init();
        this.gfZ.a(this.gfZ.biO(), this.dNs);
        this.gga = (ColumnLayout) this.gfY.findViewById(e.g.pb_head_owner_root);
        this.ggb = (ThreadSkinView) this.gfY.findViewById(e.g.pb_thread_skin);
        this.gga.setOnLongClickListener(this.onLongClickListener);
        this.gga.setOnTouchListener(this.bsF);
        this.gga.setVisibility(8);
        this.gfV.setOnTouchListener(this.bsF);
        this.ghm = this.gfV.findViewById(e.g.pb_head_activity_join_number_container);
        this.ghm.setVisibility(8);
        this.ghn = (TextView) this.gfV.findViewById(e.g.pb_head_activity_join_number);
        this.ggc = (TextView) this.gga.findViewById(e.g.pb_head_owner_info_user_name);
        this.ggd = (TextView) this.gga.findViewById(e.g.floor_owner);
        this.gge = (ImageView) this.gga.findViewById(e.g.icon_forum_level);
        this.ggg = (FrameLayout) this.gga.findViewById(e.g.pb_head_headImage_container);
        this.ggh = (HeadImageView) this.gga.findViewById(e.g.pb_head_owner_photo);
        this.ggf = (HeadPendantView) this.gga.findViewById(e.g.pb_pendant_head_owner_photo);
        this.ggf.setHasPendantStyle();
        if (this.ggf.getHeadView() != null) {
            this.ggf.getHeadView().setIsRound(true);
            this.ggf.getHeadView().setDrawBorder(false);
        }
        this.fZU = (UserIconBox) this.gga.findViewById(e.g.show_icon_vip);
        this.fZV = (UserIconBox) this.gga.findViewById(e.g.show_icon_yinji);
        this.ggj = (FloatingLayout) this.gfY.findViewById(e.g.pb_head_owner_info_root);
        this.ggm = (PbFirstFloorUserLikeButton) this.gga.findViewById(e.g.pb_like_button);
        this.ggp = (TextView) this.gga.findViewById(e.g.pb_views);
        this.aKM = (TextView) this.gga.findViewById(e.g.view_forum_name);
        this.ggt = this.gga.findViewById(e.g.line_right_forum_name);
        this.ggq = (TextView) this.gga.findViewById(e.g.pb_item_first_floor_reply_time);
        this.ggr = (TextView) this.gga.findViewById(e.g.pb_item_first_floor_location_address);
        this.ggs = this.gga.findViewById(e.g.line_between_time_and_locate);
        this.gih = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.gii = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.ggx = this.gfV.findViewById(e.g.new_pb_header_item_line_above_livepost);
        this.ggy = this.gfV.findViewById(e.g.new_pb_header_item_line_below_livepost);
        this.gfV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.37
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.gho = (ViewStub) this.drR.findViewById(e.g.interview_status_stub);
        this.ggB = new f(this.fYK, this.gfU);
        this.ggB.w(this.dNs);
        this.ggB.setTbGestureDetector(this.bsF);
        this.ggB.setOnImageClickListener(this.bsE);
        this.fZi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.38
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
                            ar.this.fYK.b(sparseArray);
                            return;
                        }
                        ar.this.bF(view);
                    } else if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 0);
                        sparseArray.put(e.g.tag_check_mute_from, 1);
                        ar.this.fYK.b(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.ggB.I(this.fZi);
        bme();
        this.gfU.addHeaderView(this.gfW);
        this.gfU.addHeaderView(this.gfY);
        this.gfU.addHeaderView(this.gfV);
        this.dRc = new PbListView(this.fYK.getPageContext().getPageActivity());
        this.bfV = this.dRc.getView().findViewById(e.g.pb_more_view);
        if (this.bfV != null) {
            this.bfV.setOnClickListener(this.dNs);
            com.baidu.tbadk.core.util.al.i(this.bfV, e.f.pb_foot_more_trans_selector);
        }
        this.dRc.Fl();
        this.dRc.ev(e.f.pb_foot_more_trans_selector);
        this.dRc.ex(e.f.pb_foot_more_trans_selector);
        this.ggH = this.fYK.findViewById(e.g.viewstub_progress);
        this.fYK.registerListener(this.gio);
        this.ggi = com.baidu.tbadk.ala.b.wg().j(this.fYK.getActivity(), 2);
        if (this.ggi != null) {
            this.ggi.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fYK.getResources().getDimensionPixelSize(e.C0210e.ds10);
            if (this.ggi.getParent() == null) {
                this.ggj.addView(this.ggi, aVar);
            }
        }
        this.gbd = new PbFakeFloorModel(this.fYK.getPageContext());
        this.ghK = new s(this.fYK.getPageContext(), this.gbd, this.drR);
        this.ghK.a(this.fYK.fXM);
        this.gbd.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void n(PostData postData) {
                ar.this.gbd.o(postData);
                ar.this.ggB.notifyDataSetChanged();
                ar.this.ghK.bkg();
                ar.this.Tj.KM();
                ar.this.lv(false);
            }
        });
        if (this.fYK.biD() != null && !StringUtils.isNull(this.fYK.biD().blb())) {
            this.fYK.showToast(this.fYK.biD().blb());
        }
        this.ght = this.fYK.findViewById(e.g.pb_expand_blank_view);
        this.ghu = this.fYK.findViewById(e.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ghu.getLayoutParams();
        if (this.fYK.biD() != null && this.fYK.biD().bkw()) {
            this.ght.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.ghu.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = ghw;
            this.ghu.setLayoutParams(layoutParams2);
        }
        this.ghv = new al(this.fYK.getPageContext(), this.fYK.findViewById(e.g.pb_reply_expand_view));
        this.ghv.gfj.setVisibility(8);
        this.ghv.L(this.dNs);
        this.fYK.registerListener(this.bRk);
        this.fYK.registerListener(this.gik);
        this.fYK.registerListener(this.gil);
        bma();
        lp(false);
    }

    public void blZ() {
        bnb();
        if (!this.fYK.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").y("obj_locate", 2).aB(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.fYK.bjb()) {
            com.baidu.tbadk.editortools.pb.d biP = this.fYK.biP();
            if (biP != null && (biP.Nb() || biP.Nc())) {
                this.fYK.biP().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Tj != null) {
                bmj();
            }
            if (this.Tj != null) {
                this.ghg = false;
                if (this.Tj.fL(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.fYK, (View) this.Tj.fL(2).aYW, false, gif);
                }
            }
            bmO();
        }
    }

    private void bma() {
        this.gia = new com.baidu.tieba.pb.pb.godreply.a(this.fYK, this, (ViewStub) this.drR.findViewById(e.g.more_god_reply_popup));
        this.gia.s(this.dNs);
        this.gia.I(this.fZi);
        this.gia.setOnImageClickListener(this.bsE);
        this.gia.s(this.dNs);
        this.gia.setTbGestureDetector(this.bsF);
    }

    public com.baidu.tieba.pb.pb.godreply.a bmb() {
        return this.gia;
    }

    public View bmc() {
        return this.ght;
    }

    public void bmd() {
        if (this.gfU != null) {
            this.gfU.removeHeaderView(this.gfW);
            this.gfU.removeHeaderView(this.gfY);
            this.gfU.removeHeaderView(this.gfV);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.ghA == null) {
            this.ghA = new PbEmotionBar(this.fYK.getPageContext().getPageActivity());
            lp(true);
            this.ghA.a(this.drR, aVar, this.ghb.getVisibility() == 0);
            this.ghA.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (ar.this.fYK.bjb()) {
                        if (!StringUtils.isNull(ar.this.gij)) {
                            emotionImageData.setAuthorNameShow(ar.this.gij);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fYK.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fYK.getPageContext().getPageActivity(), 25016, str, list, ar.this.gij, list2)));
                }
            });
            this.ghA.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    ar.this.bnb();
                    if (ar.this.ghb != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.ghb.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.ghj - ar.this.ghi) * f) + ar.this.ghi);
                        ar.this.ghc.setAlpha(1.0f - f);
                        ar.this.ghe.setAlpha(1.0f - f);
                        ar.this.ghd.setAlpha(1.0f - f);
                        ar.this.ghb.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bme() {
        if (this.gfW == null) {
            int h = com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.tbds44);
            this.gfW = new LinearLayout(this.fYK.getPageContext().getPageActivity());
            this.gfW.setOrientation(1);
            this.gfW.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gfW.setPadding(h, com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.tbds30), h, com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.tbds40));
            this.gfW.setGravity(17);
            this.gfX = new TextView(this.fYK.getPageContext().getPageActivity());
            this.gfX.setGravity(3);
            this.gfX.setMaxLines(2);
            this.gfX.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            this.gfX.setPadding(0, 0, 0, 0);
            this.gfX.setLineSpacing(com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.gfX, e.d.cp_cont_b);
            this.gfX.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.gfX.setVisibility(8);
            if (this.gfX.getParent() == null) {
                this.gfW.addView(this.gfX);
            }
            this.gfW.setOnTouchListener(this.bsF);
            this.gfW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmf() {
        if (this.fYK.bjt()) {
            this.gfT = (ViewStub) this.fYK.findViewById(e.g.manga_mention_controller_view_stub);
            this.gfT.setVisibility(0);
            if (this.ggu == null) {
                this.ggu = (LinearLayout) this.fYK.findViewById(e.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fYK.getPageContext(), this.ggu);
            }
            if (this.ggv == null) {
                this.ggv = (TextView) this.ggu.findViewById(e.g.manga_prev_btn);
            }
            if (this.ggw == null) {
                this.ggw = (TextView) this.ggu.findViewById(e.g.manga_next_btn);
            }
            this.ggv.setOnClickListener(this.dNs);
            this.ggw.setOnClickListener(this.dNs);
        }
    }

    private void bmg() {
        if (this.fYK.bjt()) {
            if (this.fYK.bjw() == -1) {
                com.baidu.tbadk.core.util.al.c(this.ggv, e.d.cp_cont_e, 1);
            }
            if (this.fYK.bjx() == -1) {
                com.baidu.tbadk.core.util.al.c(this.ggw, e.d.cp_cont_e, 1);
            }
        }
    }

    public void bmh() {
        if (this.ggu == null) {
            bmf();
        }
        this.gfT.setVisibility(8);
        if (this.gim != null && this.gin != null) {
            this.gim.removeCallbacks(this.gin);
        }
    }

    public void bmi() {
        if (this.gim != null) {
            if (this.gin != null) {
                this.gim.removeCallbacks(this.gin);
            }
            this.gin = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.ggu == null) {
                        ar.this.bmf();
                    }
                    ar.this.gfT.setVisibility(0);
                }
            };
            this.gim.postDelayed(this.gin, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void lm(boolean z) {
        this.gfQ.lm(z);
        if (z && this.ghl) {
            this.dRc.setText(this.fYK.getResources().getString(e.j.click_load_more));
            this.gfU.setNextPage(this.dRc);
            this.gfP = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
        this.Tj.setId(e.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Tj.getParent() == null) {
            this.drR.addView(this.Tj, layoutParams);
        }
        this.Tj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        blR();
        this.fYK.biP().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.Tj != null && ar.this.Tj.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.ghZ == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.Tj.getId());
                            ar.this.ghZ = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fYK.getPageContext(), ar.this.drR, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.I(ar.this.ghY)) {
                                ar.this.ghZ.setData(ar.this.ghY);
                            }
                            ar.this.ghZ.b(ar.this.Tj);
                        }
                        ar.this.ghZ.tA(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fYK.fWS != null && ar.this.fYK.fWS.bng() != null) {
                    if (!ar.this.fYK.fWS.bng().bOw()) {
                        ar.this.fYK.fWS.lA(false);
                    }
                    ar.this.fYK.fWS.bng().ov(false);
                }
            }
        });
    }

    public void bmj() {
        if (this.fYK != null && this.Tj != null) {
            this.Tj.pR();
            if (this.fYK.biP() != null) {
                this.fYK.biP().MS();
            }
            bmO();
        }
    }

    public void V(String str, boolean z) {
        this.ghh = z;
        ln(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void ln(boolean z) {
        if (this.ghf != null) {
            if (this.ghh) {
                com.baidu.tbadk.core.util.al.i(this.ghf, e.f.pb_praise_already_click_selector);
                this.ghf.setContentDescription(this.fYK.getResources().getString(e.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.ghf, e.f.pb_praise_normal_click_selector);
            this.ghf.setContentDescription(this.fYK.getResources().getString(e.j.zan));
        }
    }

    public TextView bmk() {
        return this.ghf;
    }

    public void lo(boolean z) {
        if (this.gfU != null && this.ajh != null && this.dNH != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dNH.setVisibility(0);
                } else {
                    this.dNH.setVisibility(8);
                    this.gfU.removeHeaderView(this.ajh);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ajh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = ghw;
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
        return this.ggB;
    }

    public void a(PbActivity.d dVar) {
        this.fXQ = dVar;
    }

    public void bF(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.ggK == null) {
            this.ggK = LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fYK.getLayoutMode().onModeChanged(this.ggK);
        if (this.ggJ == null) {
            this.ggJ = new Dialog(this.fYK.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.ggJ.setCanceledOnTouchOutside(true);
            this.ggJ.setCancelable(true);
            this.ggJ.setContentView(this.ggK);
            WindowManager.LayoutParams attributes = this.ggJ.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.aO(this.fYK.getPageContext().getPageActivity()) * 0.9d);
            this.ggJ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ggJ.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.ggJ.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.ggJ.findViewById(e.g.disable_reply_btn);
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
                    if (ar.this.ggJ != null && (ar.this.ggJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.ggJ, ar.this.fYK.getPageContext());
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
                    if (ar.this.ggJ != null && (ar.this.ggJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.ggJ, ar.this.fYK.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.gip != null) {
                        ar.this.gip.m(new Object[]{sparseArray6.get(e.g.tag_manage_user_identity), sparseArray6.get(e.g.tag_forbid_user_name), sparseArray6.get(e.g.tag_forbid_user_post_id), sparseArray6.get(e.g.tag_forbid_user_name_show), sparseArray6.get(e.g.tag_forbid_user_portrait)});
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
                    if (ar.this.ggJ != null && (ar.this.ggJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.ggJ, ar.this.fYK.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fYK.a(z, (String) sparseArray7.get(e.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ggJ, this.fYK.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.gip = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fYK != null && aVar != null) {
            if (this.ekK == null) {
                this.ekK = new com.baidu.tieba.NEGFeedBack.e(this.fYK.getPageContext(), this.gfV);
            }
            AntiData aBj = this.fYK.aBj();
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
            this.ekK.setDefaultReasonArray(new String[]{this.fYK.getString(e.j.delete_thread_reason_1), this.fYK.getString(e.j.delete_thread_reason_2), this.fYK.getString(e.j.delete_thread_reason_3), this.fYK.getString(e.j.delete_thread_reason_4), this.fYK.getString(e.j.delete_thread_reason_5)});
            this.ekK.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ekK.jy(str);
            this.ekK.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    ar.this.fYK.a(aVar, jSONArray);
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
        sparseArray.put(ghD, Integer.valueOf(ghE));
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
        this.ggL = new com.baidu.tbadk.core.dialog.a(this.fYK.getActivity());
        if (StringUtils.isNull(str2)) {
            this.ggL.db(i3);
        } else {
            this.ggL.bl(false);
            this.ggL.eK(str2);
        }
        this.ggL.H(sparseArray);
        this.ggL.a(e.j.dialog_ok, this.fYK);
        this.ggL.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ggL.bg(true);
        this.ggL.b(this.fYK.getPageContext());
        if (z) {
            this.ggL.BS();
        } else {
            a(this.ggL, i);
        }
    }

    public void ap(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.ggO == null) {
            this.ggO = LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.commit_good, (ViewGroup) null);
        }
        this.fYK.getLayoutMode().onModeChanged(this.ggO);
        if (this.ggN == null) {
            this.ggN = new Dialog(this.fYK.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.ggN.setCanceledOnTouchOutside(true);
            this.ggN.setCancelable(true);
            this.ggY = (ScrollView) this.ggO.findViewById(e.g.good_scroll);
            this.ggN.setContentView(this.ggO);
            WindowManager.LayoutParams attributes = this.ggN.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds540);
            this.ggN.getWindow().setAttributes(attributes);
            this.daL = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.ggT = (String) compoundButton.getTag();
                        if (ar.this.daK != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ar.this.daK) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ar.this.ggT != null && !str.equals(ar.this.ggT)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.ggP = (LinearLayout) this.ggO.findViewById(e.g.good_class_group);
            this.ggR = (TextView) this.ggO.findViewById(e.g.dialog_button_cancel);
            this.ggR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.ggN instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.ggN, ar.this.fYK.getPageContext());
                    }
                }
            });
            this.ggQ = (TextView) this.ggO.findViewById(e.g.dialog_button_ok);
            this.ggQ.setOnClickListener(this.dNs);
        }
        this.ggP.removeAllViews();
        this.daK = new ArrayList();
        CustomBlueCheckRadioButton cq = cq("0", this.fYK.getPageContext().getString(e.j.thread_good_class));
        this.daK.add(cq);
        cq.setChecked(true);
        this.ggP.addView(cq);
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
                    this.daK.add(cq2);
                    View view = new View(this.fYK.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, e.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.ggP.addView(view);
                    this.ggP.addView(cq2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ggY.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fYK.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fYK.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fYK.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ggY.setLayoutParams(layoutParams2);
            this.ggY.removeAllViews();
            if (this.ggP != null && this.ggP.getParent() == null) {
                this.ggY.addView(this.ggP);
            }
        }
        com.baidu.adp.lib.g.g.a(this.ggN, this.fYK.getPageContext());
    }

    private CustomBlueCheckRadioButton cq(String str, String str2) {
        Activity pageActivity = this.fYK.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, e.C0210e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.daL);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bmm() {
        this.fYK.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fYK.hideProgressBar();
        if (z && z2) {
            this.fYK.showToast(this.fYK.getPageContext().getString(e.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.neterror);
            }
            this.fYK.showToast(str);
        }
    }

    public void aTJ() {
        this.ggH.setVisibility(0);
    }

    public void aTI() {
        this.ggH.setVisibility(8);
    }

    public View bmn() {
        if (this.ggO != null) {
            return this.ggO.findViewById(e.g.dialog_button_ok);
        }
        return null;
    }

    public String bmo() {
        return this.ggT;
    }

    public View getView() {
        return this.drR;
    }

    public void bmp() {
        com.baidu.adp.lib.util.l.b(this.fYK.getPageContext().getPageActivity(), this.fYK.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fYK.hideProgressBar();
        if (z) {
            bmF();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bmG();
        } else {
            bmF();
        }
    }

    public void bmq() {
        this.dRc.Fl();
        this.dRc.Fp();
    }

    public void bmr() {
        this.fYK.hideProgressBar();
        Fq();
        this.gfU.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bmC();
    }

    public void bms() {
        this.gfU.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bmC();
    }

    private void lp(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ghc.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fYK.getResources().getDimensionPixelSize(e.C0210e.ds130) : this.fYK.getResources().getDimensionPixelSize(e.C0210e.ds34);
        this.ghc.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.ggB.setOnLongClickListener(onLongClickListener);
        if (this.gia != null) {
            this.gia.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z, boolean z2) {
        if (this.ggU != null) {
            this.ggU.dismiss();
            this.ggU = null;
        }
        this.ggU = new com.baidu.tbadk.core.dialog.b(this.fYK.getPageContext().getPageActivity());
        this.ggU.de(e.j.operation);
        if (z2) {
            this.ggU.a(new String[]{this.fYK.getPageContext().getString(e.j.copy), this.fYK.getPageContext().getString(e.j.report_text)}, interfaceC0158b);
        } else if (!z) {
            this.ggU.a(new String[]{this.fYK.getPageContext().getString(e.j.copy), this.fYK.getPageContext().getString(e.j.mark)}, interfaceC0158b);
        } else {
            this.ggU.a(new String[]{this.fYK.getPageContext().getString(e.j.copy), this.fYK.getPageContext().getString(e.j.remove_mark)}, interfaceC0158b);
        }
        this.ggU.d(this.fYK.getPageContext());
        this.ggU.BV();
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z) {
        if (this.ggV != null) {
            this.ggV.dismiss();
            this.ggV = null;
        }
        this.ggV = new com.baidu.tbadk.core.dialog.b(this.fYK.getPageContext().getPageActivity());
        if (z) {
            this.ggV.a(new String[]{this.fYK.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0158b);
        } else {
            this.ggV.a(new String[]{this.fYK.getPageContext().getString(e.j.save_to_emotion), this.fYK.getPageContext().getString(e.j.save_to_local)}, interfaceC0158b);
        }
        this.ggV.d(this.fYK.getPageContext());
        this.ggV.BV();
    }

    public int bmt() {
        return sP(this.gfU.getFirstVisiblePosition());
    }

    private int sP(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.gfU.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.gfU.getAdapter() == null || !(this.gfU.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.gfU.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bmu() {
        int lastVisiblePosition = this.gfU.getLastVisiblePosition();
        if (this.gfK != null) {
            if (lastVisiblePosition == this.gfU.getCount() - 1) {
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
        if (this.gfU != null) {
            if (this.gfQ == null || this.gfQ.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.gfQ.mNavigationBar.getFixedNavHeight();
                if (!(this.fYK.bjh() != -1)) {
                    if (this.ghu != null && (layoutParams = (LinearLayout.LayoutParams) this.ghu.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.ghu.setLayoutParams(layoutParams);
                    }
                    i--;
                    bna();
                }
                i2 = fixedNavHeight;
            }
            this.gfU.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.gfU.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.ggE.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        this.ggB.a(dVar, false);
        this.ggB.notifyDataSetChanged();
        bmC();
        if (this.gia != null) {
            this.gia.biz();
        }
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (this.ggk == null) {
            this.fYK.getLayoutMode().onModeChanged(((ViewStub) this.gfV.findViewById(e.g.praise_layout)).inflate());
            this.ggk = (FrsPraiseView) this.gfV.findViewById(e.g.pb_head_praise_view);
            this.ggk.setIsFromPb(true);
            this.ggz = this.gfV.findViewById(e.g.new_pb_header_item_line_above_praise);
            this.ggk.eD(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.ggk != null) {
            boolean bmC = bmC();
            this.ggk.setVisibility(8);
            if (dVar != null && dVar.zf() != null && dVar.zf().zd() == 0 && this.fZb) {
                if (bmC) {
                    this.ggy.setVisibility(0);
                    return;
                } else {
                    this.ggy.setVisibility(8);
                    return;
                }
            }
            this.ggy.setVisibility(8);
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
            this.gga.setVisibility(8);
            if (dVar.bhz() != null && dVar.bhz().AH() && dVar.bhz().Al() != null) {
                this.ghO = true;
                this.gfQ.lM(this.ghO);
                this.gfQ.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1")) {
                    LinearLayout linearLayout = (LinearLayout) this.fYK.findViewById(e.g.pb_comment_container);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.bottomMargin = ghw;
                    linearLayout.setLayoutParams(layoutParams);
                }
                if (this.gfK == null) {
                    this.gfK = new com.baidu.tieba.pb.video.i(this.fYK, this.gfQ, dVar.bhz().Al(), this.gfL);
                    this.gfK.a(dVar.bhz().Al(), dVar.bhz(), dVar.getForumId());
                    this.gfK.startPlay();
                } else if (this.gfO) {
                    this.gfK.a(dVar.bhz().Al(), dVar.bhz(), dVar.getForumId());
                    this.gfK.startPlay();
                } else {
                    this.gfK.tL(dVar.getForumId());
                }
                if (dVar.bhA() != null && dVar.bhA().size() >= 1) {
                    bb bbVar = dVar.bhA().get(0);
                    this.gfK.as(bbVar);
                    this.gfK.tM(bbVar.getTitle());
                }
                this.gfK.b(b, dVar.bhz(), dVar.bhX());
                this.gfO = false;
                this.gfU.removeHeaderView(this.gfK.boQ());
                this.gfU.addHeaderView(this.gfK.boQ(), 0);
                if (this.gfK.boN() != null && this.gfK.boN().getParent() == null) {
                    this.ghs.addView(this.gfK.boN());
                }
                if (this.gfM == null) {
                    this.gfM = new com.baidu.tieba.pb.video.h(this.fYK);
                }
                this.gfM.a(dVar.bhz().AW(), dVar.bhz(), dVar.bhU());
                this.gfU.removeHeaderView(this.gfM.boE());
                this.gfU.addHeaderView(this.gfM.boE(), 1);
                if (dVar.bhz().AW() != null) {
                    this.gfU.removeHeaderView(this.gfM.boF());
                    this.gfU.removeHeaderView(this.gfY);
                    this.gfU.addHeaderView(this.gfM.boF(), 2);
                } else {
                    if (this.gfM.boF() != null) {
                        this.gfU.removeHeaderView(this.gfM.boF());
                    }
                    this.gfU.removeHeaderView(this.gfY);
                    this.gfY.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fYK, e.C0210e.tbds26));
                    this.gfU.addHeaderView(this.gfY, 2);
                }
                if (this.gfK != null) {
                    this.gfQ.lG(false);
                    this.gfQ.lI(TbadkCoreApplication.isLogin());
                    this.gfK.sW(TbadkCoreApplication.getInst().getSkinType());
                }
                bmz();
            } else {
                this.ghO = false;
                this.gfQ.lM(this.ghO);
                if (this.gfK != null) {
                    this.gfU.removeHeaderView(this.gfK.boQ());
                }
                if (this.gfM != null) {
                    this.gfM.b(this.gfU);
                }
                if (b == null || (b != null && (b.bEU() == null || com.baidu.tbadk.core.util.v.I(b.bEU().Sx())))) {
                    this.gfY.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fYK, e.C0210e.tbds52));
                } else {
                    this.gfY.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fYK.biT() != null) {
                this.fYK.biT().lE(this.ghO);
            }
            if (this.gfK != null) {
                this.gfK.N(this.gir);
                bna();
            }
            if (b != null) {
                this.ghk = b;
                this.gga.setVisibility(0);
                if (this.fYK.bit()) {
                    if (dVar.bhy() != null) {
                        this.mForumName = dVar.bhy().getForumName();
                        this.mForumId = dVar.bhy().getForumId();
                    }
                    if (this.mForumName == null && this.fYK.biD() != null && this.fYK.biD().biu() != null) {
                        this.mForumName = this.fYK.biD().biu();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.gga.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.gga.setTag(sparseArray);
                }
                sparseArray.put(e.g.tag_clip_board, b);
                sparseArray.put(e.g.tag_is_subpb, false);
                if (!this.gig) {
                    this.gfW.setVisibility(0);
                }
                if (!dVar.bhz().AH() && this.gfX.getText() != null && this.gfX.getText().length() > 0) {
                    this.gfX.setVisibility(0);
                } else {
                    this.gfX.setVisibility(8);
                }
                p(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> Af = dVar.bhz().Af();
                if (Af != null && Af.size() > 0 && !this.gig) {
                    this.ghn.setText(String.valueOf(Af.get(0).yn()));
                    this.ghm.setVisibility(0);
                } else {
                    this.ghm.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.ghm, e.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.ghn, e.d.cp_link_tip_d, 1);
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
                            if (this.fZV != null) {
                                this.fZV.setTag(e.g.tag_user_id, b.zT().getUserId());
                                this.fZV.setOnClickListener(this.fYK.fWO.gkj);
                                this.fZV.a(iconInfo, 4, this.fYK.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fYK.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fYK.getResources().getDimensionPixelSize(e.C0210e.tbds12));
                            }
                            if (this.fZU != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fZU.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fZU.setOnClickListener(this.fYK.fWO.gkk);
                                this.fZU.a(tShowInfoNew, 3, this.fYK.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fYK.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fYK.getResources().getDimensionPixelSize(e.C0210e.ds12), true);
                            }
                            this.ggc.setText(aF(b.zT().getSealPrefix(), d));
                            this.ggc.setTag(e.g.tag_user_id, b.zT().getUserId());
                            this.ggc.setTag(e.g.tag_user_name, b.zT().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew) || b.zT().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.ggc, e.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.ggc, e.d.cp_cont_f, 1);
                            }
                            this.ggd.setVisibility(8);
                            if (dVar.bhz().zT() != null && dVar.bhz().zT().getAlaUserData() != null && this.ggi != null) {
                                if (dVar.bhz().zT().getAlaUserData().anchor_live != 0) {
                                    this.ggi.setVisibility(8);
                                } else {
                                    this.ggi.setVisibility(0);
                                    if (this.gfN == null) {
                                        this.gfN = new com.baidu.tieba.c.d(this.fYK.getPageContext(), this.ggi);
                                        this.gfN.lk(1);
                                    }
                                    this.gfN.bp(this.fYK.getResources().getString(e.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.amc = dVar.bhz().zT().getAlaUserData();
                                    aVar.type = 2;
                                    this.ggi.setTag(aVar);
                                }
                            }
                            this.ggh.setUserId(b.zT().getUserId());
                            this.ggh.setUserName(b.zT().getUserName());
                            this.ggh.setTid(b.getId());
                            this.ggh.setFid(this.gck == null ? this.gck.getForumId() : "");
                            this.ggh.setImageDrawable(null);
                            this.ggh.setRadius(com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds40));
                            this.ggh.setTag(b.zT().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                                this.ggq.setText(com.baidu.tbadk.core.util.ao.O(b.getTime()));
                            } else {
                                this.ggq.setText(com.baidu.tbadk.core.util.ao.M(b.getTime()));
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds16);
                            if (!this.fYK.bit() && !StringUtils.isNull(this.mForumName)) {
                                this.aKM.setText(this.fYK.getString(e.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.aKM.setVisibility(0);
                                this.ggt.setVisibility(0);
                                this.ggq.setPadding(h, 0, h, 0);
                            } else {
                                this.aKM.setVisibility(8);
                                this.ggt.setVisibility(8);
                                this.ggq.setPadding(0, 0, h, 0);
                            }
                            bEV = b.bEV();
                            if (bEV == null && !TextUtils.isEmpty(bEV.getName()) && !TextUtils.isEmpty(bEV.getName().trim())) {
                                final String name = bEV.getName();
                                final String lat = bEV.getLat();
                                final String lng = bEV.getLng();
                                this.ggr.setVisibility(0);
                                this.ggs.setVisibility(0);
                                this.ggr.setText(bEV.getName());
                                this.ggr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                ar.this.fYK.showToast(e.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ad(ar.this.fYK.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, ar.this.fYK.getPageContext().getString(e.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.ggr.setVisibility(8);
                                this.ggs.setVisibility(8);
                            }
                            portrait = b.zT().getPortrait();
                            if (b.zT().getPendantData() == null && !StringUtils.isNull(b.zT().getPendantData().yF())) {
                                this.ggf.b(b.zT());
                                this.ggh.setVisibility(8);
                                this.ggf.setVisibility(0);
                                if (this.ggl != null) {
                                    this.ggl.setVisibility(8);
                                }
                                this.ggc.setOnClickListener(this.gir);
                                this.ggf.getHeadView().startLoad(portrait, 28, false);
                                this.ggf.getHeadView().setUserId(b.zT().getUserId());
                                this.ggf.getHeadView().setUserName(b.zT().getUserName());
                                this.ggf.getHeadView().setTid(b.getId());
                                this.ggf.getHeadView().setFid(this.gck != null ? this.gck.getForumId() : "");
                                this.ggf.getHeadView().setOnClickListener(this.gir);
                                this.ggf.gA(b.zT().getPendantData().yF());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.ggh, b.zT());
                                this.ggh.setVisibility(0);
                                this.gga.setOnClickListener(this.gir);
                                this.ggc.setOnClickListener(this.gir);
                                this.ggh.setOnClickListener(this.gir);
                                this.ggf.setVisibility(8);
                                this.ggh.startLoad(portrait, 28, false);
                            }
                            String name_show = b.zT().getName_show();
                            String userName = b.zT().getUserName();
                            if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                                this.ggc.setText(com.baidu.tieba.pb.c.aC(this.fYK.getPageContext().getPageActivity(), this.ggc.getText().toString()));
                                this.ggc.setGravity(16);
                                this.ggc.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bhi());
                                com.baidu.tbadk.core.util.al.c(this.ggc, e.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.zT().getIconInfo();
                        tShowInfoNew = b.zT().getTShowInfoNew();
                        if (this.fZV != null) {
                        }
                        if (this.fZU != null) {
                        }
                        this.ggc.setText(aF(b.zT().getSealPrefix(), d));
                        this.ggc.setTag(e.g.tag_user_id, b.zT().getUserId());
                        this.ggc.setTag(e.g.tag_user_name, b.zT().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.ggc, e.d.cp_cont_h, 1);
                        this.ggd.setVisibility(8);
                        if (dVar.bhz().zT() != null) {
                            if (dVar.bhz().zT().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.ggh.setUserId(b.zT().getUserId());
                        this.ggh.setUserName(b.zT().getUserName());
                        this.ggh.setTid(b.getId());
                        this.ggh.setFid(this.gck == null ? this.gck.getForumId() : "");
                        this.ggh.setImageDrawable(null);
                        this.ggh.setRadius(com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds40));
                        this.ggh.setTag(b.zT().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds16);
                        if (!this.fYK.bit()) {
                        }
                        this.aKM.setVisibility(8);
                        this.ggt.setVisibility(8);
                        this.ggq.setPadding(0, 0, h, 0);
                        bEV = b.bEV();
                        if (bEV == null) {
                        }
                        this.ggr.setVisibility(8);
                        this.ggs.setVisibility(8);
                        portrait = b.zT().getPortrait();
                        if (b.zT().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.ggh, b.zT());
                        this.ggh.setVisibility(0);
                        this.gga.setOnClickListener(this.gir);
                        this.ggc.setOnClickListener(this.gir);
                        this.ggh.setOnClickListener(this.gir);
                        this.ggf.setVisibility(8);
                        this.ggh.startLoad(portrait, 28, false);
                        String name_show2 = b.zT().getName_show();
                        String userName2 = b.zT().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                            this.ggc.setText(com.baidu.tieba.pb.c.aC(this.fYK.getPageContext().getPageActivity(), this.ggc.getText().toString()));
                            this.ggc.setGravity(16);
                            this.ggc.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bhi());
                            com.baidu.tbadk.core.util.al.c(this.ggc, e.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.zT().getIconInfo();
                            tShowInfoNew = b.zT().getTShowInfoNew();
                            if (this.fZV != null) {
                            }
                            if (this.fZU != null) {
                            }
                            this.ggc.setText(aF(b.zT().getSealPrefix(), d));
                            this.ggc.setTag(e.g.tag_user_id, b.zT().getUserId());
                            this.ggc.setTag(e.g.tag_user_name, b.zT().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.ggc, e.d.cp_cont_h, 1);
                            this.ggd.setVisibility(8);
                            if (dVar.bhz().zT() != null) {
                            }
                            this.ggh.setUserId(b.zT().getUserId());
                            this.ggh.setUserName(b.zT().getUserName());
                            this.ggh.setTid(b.getId());
                            this.ggh.setFid(this.gck == null ? this.gck.getForumId() : "");
                            this.ggh.setImageDrawable(null);
                            this.ggh.setRadius(com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds40));
                            this.ggh.setTag(b.zT().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds16);
                            if (!this.fYK.bit()) {
                            }
                            this.aKM.setVisibility(8);
                            this.ggt.setVisibility(8);
                            this.ggq.setPadding(0, 0, h, 0);
                            bEV = b.bEV();
                            if (bEV == null) {
                            }
                            this.ggr.setVisibility(8);
                            this.ggs.setVisibility(8);
                            portrait = b.zT().getPortrait();
                            if (b.zT().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.ggh, b.zT());
                            this.ggh.setVisibility(0);
                            this.gga.setOnClickListener(this.gir);
                            this.ggc.setOnClickListener(this.gir);
                            this.ggh.setOnClickListener(this.gir);
                            this.ggf.setVisibility(8);
                            this.ggh.startLoad(portrait, 28, false);
                            String name_show22 = b.zT().getName_show();
                            String userName22 = b.zT().getUserName();
                            if (com.baidu.tbadk.p.an.jJ()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.zT().getIconInfo();
                        tShowInfoNew = b.zT().getTShowInfoNew();
                        if (this.fZV != null) {
                        }
                        if (this.fZU != null) {
                        }
                        this.ggc.setText(aF(b.zT().getSealPrefix(), d));
                        this.ggc.setTag(e.g.tag_user_id, b.zT().getUserId());
                        this.ggc.setTag(e.g.tag_user_name, b.zT().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.ggc, e.d.cp_cont_h, 1);
                        this.ggd.setVisibility(8);
                        if (dVar.bhz().zT() != null) {
                        }
                        this.ggh.setUserId(b.zT().getUserId());
                        this.ggh.setUserName(b.zT().getUserName());
                        this.ggh.setTid(b.getId());
                        this.ggh.setFid(this.gck == null ? this.gck.getForumId() : "");
                        this.ggh.setImageDrawable(null);
                        this.ggh.setRadius(com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds40));
                        this.ggh.setTag(b.zT().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fYK.getActivity(), e.C0210e.ds16);
                        if (!this.fYK.bit()) {
                        }
                        this.aKM.setVisibility(8);
                        this.ggt.setVisibility(8);
                        this.ggq.setPadding(0, 0, h, 0);
                        bEV = b.bEV();
                        if (bEV == null) {
                        }
                        this.ggr.setVisibility(8);
                        this.ggs.setVisibility(8);
                        portrait = b.zT().getPortrait();
                        if (b.zT().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.ggh, b.zT());
                        this.ggh.setVisibility(0);
                        this.gga.setOnClickListener(this.gir);
                        this.ggc.setOnClickListener(this.gir);
                        this.ggh.setOnClickListener(this.gir);
                        this.ggf.setVisibility(8);
                        this.ggh.startLoad(portrait, 28, false);
                        String name_show222 = b.zT().getName_show();
                        String userName222 = b.zT().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.gfZ.ak(dVar.bhz());
                }
                if (this.ghv != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fUu);
                    if (dVar != null && dVar.bhz() != null) {
                        hVar.fUw = dVar.bhz().zK();
                    }
                    hVar.isNew = !this.fZb;
                    hVar.sortType = dVar.fUl;
                    if (dVar.fUk != null && dVar.fUk.size() > dVar.fUl) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.fUk.size()) {
                                break;
                            } else if (dVar.fUk.get(i4).sort_type.intValue() != dVar.fUl) {
                                i3 = i4 + 1;
                            } else {
                                hVar.fUy = dVar.fUk.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.fUz = this.fYK.bjF();
                    this.ghv.a(hVar);
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
        this.ghz.giJ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ghz));
        a(this.ghz.giJ, false);
    }

    public void bmv() {
        if (this.gfQ != null && !this.ghQ) {
            this.gfQ.lN(!StringUtils.isNull(this.fYK.bje()));
            this.ghQ = true;
        }
    }

    public void bmw() {
        if (this.gfQ != null) {
            this.gfQ.bnG();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Ap() != null) {
            this.ggb.setData(this.fYK.getPageContext(), dVar.bhB().get(0).Ap(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.bhx().getId(), dVar.bhx().getName(), dVar.bhz().getId(), this.fYK.bjC() ? "FRS" : null));
            this.gga.setPadding(this.gga.getPaddingLeft(), (int) this.fYK.getResources().getDimension(e.C0210e.ds20), this.gga.getPaddingRight(), this.gga.getPaddingBottom());
            return;
        }
        this.ggb.setData(null, null, null);
    }

    public void bmx() {
        if (this.gfK != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").y("obj_type", 1));
            this.gfK.boO();
            this.gfU.smoothScrollToPosition(0);
        }
    }

    public boolean bmy() {
        return this.gis;
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
            this.gfQ.bnE();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.gfQ.rn(cVar.forumName);
            }
            String string = this.fYK.getResources().getString(e.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.fYK.getResources().getString(e.j.self);
                    break;
                case 300:
                    str = this.fYK.getResources().getString(e.j.bawu);
                    break;
                case 400:
                    str = this.fYK.getResources().getString(e.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fTC;
            this.fYK.showNetRefreshView(this.drR, format, null, this.fYK.getResources().getString(e.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.ll()) {
                        ay.Es().c(ar.this.fYK.getPageContext(), new String[]{str2});
                        ar.this.fYK.finish();
                        return;
                    }
                    ar.this.fYK.showToast(e.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable blG;
        Parcelable blG2;
        String str;
        if (dVar != null) {
            this.gck = dVar;
            this.mType = i;
            if (dVar.bhz() != null) {
                this.ghB = dVar.bhz().zC();
                if (dVar.bhz().getAnchorLevel() != 0) {
                    this.gis = true;
                }
                this.ggX = am(dVar.bhz());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            s(dVar);
            this.ghl = false;
            this.fZb = z;
            bmr();
            b(dVar, z, i);
            q(dVar);
            if (this.gie == null) {
                this.gie = new ac(this.fYK.getPageContext(), this.alI);
            }
            this.gie.ts(dVar.bhE());
            if (this.fYK.bjt()) {
                if (this.ggF == null) {
                    this.ggF = new com.baidu.tieba.pb.view.d(this.fYK.getPageContext());
                    this.ggF.oH();
                    this.ggF.a(this.aJi);
                }
                this.gfU.setPullRefresh(this.ggF);
                bmz();
                if (this.ggF != null) {
                    this.ggF.ey(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.zf().zd() == 0 && z) {
                this.gfU.setPullRefresh(null);
            } else {
                if (this.ggF == null) {
                    this.ggF = new com.baidu.tieba.pb.view.d(this.fYK.getPageContext());
                    this.ggF.oH();
                    this.ggF.a(this.aJi);
                }
                this.gfU.setPullRefresh(this.ggF);
                bmz();
                if (this.ggF != null) {
                    this.ggF.ey(TbadkCoreApplication.getInst().getSkinType());
                }
                alK();
            }
            bmC();
            this.ggB.kD(this.fZb);
            this.ggB.kE(false);
            this.ggB.kP(i == 5);
            this.ggB.kQ(i == 6);
            this.ggB.kR(z2 && this.giq);
            this.ggB.a(dVar, false);
            this.ggB.notifyDataSetChanged();
            if (this.fYK.bit()) {
                this.ghS = 0;
                PostData b = b(dVar, z);
                if (b != null && b.zT() != null) {
                    this.ghS = b.zT().getLevel_id();
                }
                if (this.ghS > 0) {
                    this.gge.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.gge, BitmapHelper.getGradeResourceIdInEnterForum(this.ghS));
                } else {
                    this.gge.setVisibility(8);
                }
            } else {
                this.gge.setVisibility(8);
            }
            if (dVar.bhz() != null) {
                if (dVar.bhz().zG() != null) {
                    if (dVar.bhz().zG().getNum() < 1) {
                        str = this.fYK.getResources().getString(e.j.zan);
                    } else {
                        str = dVar.bhz().zG().getNum() + "";
                    }
                    if (this.gfJ != -1) {
                        dVar.bhz().zG().setIsLike(this.gfJ);
                    }
                    V(str, dVar.bhz().zG().getIsLike() == 1);
                }
                if (dVar.bhz().avW != null && dVar.bhz().avW.isDeleted) {
                    this.gfQ.lH(true);
                } else {
                    this.gfQ.lH(false);
                }
            }
            if (this.fYK.isLogin()) {
                this.gfU.setNextPage(this.dRc);
                this.gfP = 2;
                alK();
            } else {
                this.ghl = true;
                if (dVar.zf().zc() == 1) {
                    if (this.ggG == null) {
                        this.ggG = new com.baidu.tieba.pb.view.a(this.fYK.getPageContext());
                    }
                    this.gfU.setNextPage(this.ggG);
                } else {
                    this.gfU.setNextPage(this.dRc);
                }
                this.gfP = 3;
            }
            ArrayList<PostData> bhB = dVar.bhB();
            if (dVar.zf().zc() == 0 || bhB == null || bhB.size() < dVar.zf().zb()) {
                if (com.baidu.tbadk.core.util.v.H(bhB) == 0 || (com.baidu.tbadk.core.util.v.H(bhB) == 1 && bhB.get(0) != null && bhB.get(0).bES() == 1)) {
                    this.dRc.setText(this.fYK.getResources().getString(e.j.list_no_more_new));
                    if (this.fYK.biT() != null && !this.fYK.biT().bnu()) {
                        this.fYK.biT().showFloatingView();
                    }
                } else if (dVar.zf().zc() == 0) {
                    this.dRc.setText(this.fYK.getResources().getString(e.j.list_has_no_more));
                } else {
                    this.dRc.setText(this.fYK.getResources().getString(e.j.load_more));
                }
                if (this.fYK.bjt() && this.gfU != null && this.gfU.getData() != null && this.gfU.getData().size() == 1 && (this.gfU.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dRc.setText("");
                }
                bmJ();
            } else if (z2) {
                if (this.giq) {
                    Fq();
                    if (dVar.zf().zc() != 0) {
                        this.dRc.setText(this.fYK.getResources().getString(e.j.pb_load_more));
                    }
                } else {
                    this.dRc.Fl();
                    this.dRc.showLoading();
                }
            } else {
                this.dRc.Fl();
                this.dRc.showLoading();
            }
            switch (i) {
                case 2:
                    this.gfU.setSelection(i2 > 1 ? (((this.gfU.getData() == null && dVar.bhB() == null) ? 0 : (this.gfU.getData().size() - dVar.bhB().size()) + this.gfU.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (blG2 = aj.blF().blG()) != null) {
                        this.gfU.onRestoreInstanceState(blG2);
                        if (com.baidu.tbadk.core.util.v.H(bhB) > 1 && dVar.zf().zc() > 0) {
                            this.dRc.Fq();
                            this.dRc.setText(this.fYK.getString(e.j.pb_load_more_without_point));
                            this.dRc.Fm();
                            break;
                        }
                    } else {
                        this.gfU.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.giq = false;
                    break;
                case 5:
                    this.gfU.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (blG = aj.blF().blG()) != null) {
                        this.gfU.onRestoreInstanceState(blG);
                        break;
                    } else {
                        this.gfU.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.gfK != null && this.gfK.boN() != null) {
                            if (this.fYK.isUseStyleImmersiveSticky()) {
                                this.gfU.setSelectionFromTop((this.ggB.bjY() + this.gfU.getHeaderViewsCount()) - 1, this.gfK.boN().getHeight() - com.baidu.adp.lib.util.l.r(this.fYK.getPageContext().getPageActivity()));
                            } else {
                                this.gfU.setSelectionFromTop((this.ggB.bjY() + this.gfU.getHeaderViewsCount()) - 1, this.gfK.boN().getHeight());
                            }
                        } else {
                            this.gfU.setSelection(this.ggB.bjY() + this.gfU.getHeaderViewsCount());
                        }
                    } else {
                        this.gfU.setSelection(i2 > 0 ? ((this.gfU.getData() == null && dVar.bhB() == null) ? 0 : (this.gfU.getData().size() - dVar.bhB().size()) + this.gfU.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dRc.Fq();
                    this.dRc.setText(this.fYK.getString(e.j.pb_load_more_without_point));
                    this.dRc.Fm();
                    break;
            }
            if (this.ghB == ghC && isHost()) {
                bmR();
            }
            if (this.ghM) {
                blP();
                this.ghM = false;
                if (i3 == 0) {
                    lj(true);
                }
            }
            if (this.gfM != null) {
                this.gfM.ar(dVar.bhz());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fUi == 1 || dVar.fUj == 1) {
                if (this.ghT == null) {
                    this.ghT = new PbTopTipView(this.fYK);
                }
                if (dVar.fUj == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fYK.getStType())) {
                    this.ghT.setText(this.fYK.getString(e.j.pb_read_strategy_add_experience));
                    this.ghT.show(this.drR, this.mSkinType);
                } else if (dVar.fUi == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fYK.getStType())) {
                    this.ghT.setText(this.fYK.getString(e.j.pb_read_news_add_experience));
                    this.ghT.show(this.drR, this.mSkinType);
                }
            }
        }
    }

    private void bmz() {
        if (this.gfK != null && this.gfK.boN() != null) {
            this.gfU.removeHeaderView(this.ajh);
            if (this.mType != 1) {
                this.gfU.removeHeaderView(this.gfK.boQ());
                this.gfU.addHeaderView(this.gfK.boQ(), 0);
                return;
            }
            return;
        }
        if (this.gfK != null) {
            this.gfU.removeHeaderView(this.gfK.boQ());
        }
        this.gfU.removeHeaderView(this.ajh);
        this.gfU.addHeaderView(this.ajh, 0);
    }

    public void lr(boolean z) {
        this.ggW = z;
    }

    public void Fq() {
        if (this.dRc != null) {
            this.dRc.Fm();
            this.dRc.Fq();
        }
        alK();
    }

    public void anM() {
        this.gfU.setVisibility(0);
    }

    public void q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.ghk != null && this.ghk.zT() != null && this.gfQ != null) {
            this.ghP = !this.ghO;
            this.gfQ.lG(this.ghP);
            if (this.fYK.biT() != null) {
                this.fYK.biT().lF(this.ghP);
            }
            bmA();
            if (this.ghP) {
                this.gfQ.gkW.setVisibility(0);
                if (this.ggX) {
                    this.gfQ.gkX.setVisibility(8);
                    this.ggm.setVisibility(8);
                    this.ggp.setVisibility(0);
                    this.ggp.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.T(dVar.bhW())));
                } else if (!PbNormalLikeButtonSwitchStatic.PW() || (this.ghk.zT().hadConcerned() && this.ghk.zT().getGodUserData() != null && this.ghk.zT().getGodUserData().getIsFromNetWork())) {
                    this.gfQ.gkX.setVisibility(8);
                }
                if (this.ghu != null) {
                    this.ghu.setVisibility(8);
                }
                this.gfQ.a(this.ghk.zT(), this.gir);
                if (this.gib == null) {
                    this.gib = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.ghR) {
                                ar.this.bmQ();
                            }
                            ar.this.bms();
                        }
                    };
                }
                this.gfU.setListViewDragListener(this.gib);
                return;
            }
            if (this.gfQ.gkW != null) {
                this.gfQ.gkW.setVisibility(8);
            }
            if (this.ghu != null) {
                this.ghu.setVisibility(0);
            }
            if (this.ggX) {
                this.ggm.setVisibility(8);
                this.ggp.setVisibility(0);
                this.ggp.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.T(dVar.bhW())));
            } else if (!PbNormalLikeButtonSwitchStatic.PW() || (this.ghk.zT().hadConcerned() && this.ghk.zT().getGodUserData() != null && this.ghk.zT().getGodUserData().getIsFromNetWork())) {
                this.ggm.setVisibility(8);
                this.ggp.setVisibility(8);
            } else {
                this.ggp.setVisibility(8);
            }
            this.gib = null;
            this.gfU.setListViewDragListener(null);
        }
    }

    private void bmA() {
        String threadId = this.gck != null ? this.gck.getThreadId() : "";
        int bmB = bmB();
        if (this.ghP) {
            if (this.ggo == null) {
                this.ggo = new ap(this.fYK.getPageContext(), this.gfQ.gkX, 3);
                this.ggo.h(this.fYK.getUniqueId());
            }
            if (this.ghk != null && this.ghk.zT() != null) {
                this.ghk.zT().setIsLike(this.ghk.zT().hadConcerned());
                this.ggo.a(this.ghk.zT());
            }
            this.ggo.setTid(threadId);
            this.ggo.sO(bmB);
            this.ggo.gfF = this.ghO;
        }
        if (this.ggn == null) {
            this.ggn = new ap(this.fYK.getPageContext(), this.ggm, 1);
            this.ggn.h(this.fYK.getUniqueId());
            this.ggn.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bM(boolean z) {
                    if (ar.this.fYK != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fYK, e.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fYK.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.ghk != null && this.ghk.zT() != null) {
            this.ghk.zT().setIsLike(this.ghk.zT().hadConcerned());
            this.ggn.a(this.ghk.zT());
            this.ggn.setTid(threadId);
        }
        this.ggn.gfF = this.ghO;
        this.ggn.sO(bmB);
    }

    public int bmB() {
        if (this.gck == null || this.gck.bhz() == null) {
            return 0;
        }
        if (this.gck.bhz().Be()) {
            return (com.baidu.tbadk.core.util.v.I(this.gck.bhV()) && (this.gck.bhy() == null || StringUtils.isNull(this.gck.bhy().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bmC() {
        boolean z;
        if (this.gha != null && this.gha.getVisibility() == 0) {
            if (this.ggx != null) {
                this.ggx.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.ggx != null) {
                this.ggx.setVisibility(8);
            }
            z = false;
        }
        if ((this.ggz == null || this.ggz.getVisibility() == 8) && z && this.fZb) {
            this.ggy.setVisibility(0);
        } else {
            this.ggy.setVisibility(8);
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
            return com.baidu.tieba.card.o.a((Context) this.fYK.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.gfW != null) {
                if (dVar.bhz() != null && dVar.bhz().Aj() == 0 && !dVar.bhz().AH() && !this.gig) {
                    this.gfW.setVisibility(0);
                    if (dVar.bhz() != null) {
                        bb bhz = dVar.bhz();
                        bhz.g(true, r(dVar));
                        bhz.setResource(3);
                        bhz.eu("2");
                    }
                    SpannableStringBuilder At = dVar.bhz().At();
                    this.gfX.setOnTouchListener(new com.baidu.tieba.view.k(At));
                    this.gfX.setText(At);
                    this.gfX.setVisibility(0);
                } else if (dVar.bhz().Aj() == 1) {
                    if (dVar.bhz() != null) {
                        this.gfW.setVisibility(8);
                        this.gfU.removeHeaderView(this.gfW);
                        if (dVar.bhz() != null && !dVar.bhz().AH()) {
                            this.gga.setPadding(this.gga.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.tbds36), this.gga.getPaddingRight(), this.gga.getPaddingBottom());
                        }
                    }
                } else {
                    this.gfW.setVisibility(8);
                    this.gfU.removeHeaderView(this.gfW);
                    if (dVar.bhz() != null && dVar.bhz().AH()) {
                        this.gga.setPadding(this.gga.getPaddingLeft(), 0, this.gga.getPaddingRight(), this.gga.getPaddingBottom());
                    } else {
                        this.gga.setPadding(this.gga.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds48), this.gga.getPaddingRight(), this.gga.getPaddingBottom());
                    }
                }
            }
            this.fZb = z;
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
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.atD) != null && tVar.arD && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(this.fYK.getString(e.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(e.g.tag_del_multi_forum, String.format(this.fYK.getString(e.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bfV;
    }

    public void tt(String str) {
        if (this.dRc != null) {
            this.dRc.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.gfU;
    }

    public int bmD() {
        return e.g.richText;
    }

    public TextView biO() {
        return this.gfZ.biO();
    }

    public void e(BdListView.e eVar) {
        this.gfU.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.aJi = bVar;
        if (this.ggF != null) {
            this.ggF.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int za = alVar.za();
            int yX = alVar.yX();
            if (this.ggC != null) {
                this.ggC.BS();
            } else {
                this.ggC = new com.baidu.tbadk.core.dialog.a(this.fYK.getPageContext().getPageActivity());
                this.ggD = LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.dialog_direct_pager, (ViewGroup) null);
                this.ggC.G(this.ggD);
                this.ggC.a(e.j.dialog_ok, bVar);
                this.ggC.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bmF();
                        aVar.dismiss();
                    }
                });
                this.ggC.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.ghJ == null) {
                            ar.this.ghJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fYK.HidenSoftKeyPad((InputMethodManager) ar.this.fYK.getSystemService("input_method"), ar.this.drR);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jG().postDelayed(ar.this.ghJ, 150L);
                    }
                });
                this.ggC.b(this.fYK.getPageContext()).BS();
            }
            this.ggE = (EditText) this.ggD.findViewById(e.g.input_page_number);
            this.ggE.setText("");
            TextView textView = (TextView) this.ggD.findViewById(e.g.current_page_number);
            if (za <= 0) {
                za = 1;
            }
            if (yX <= 0) {
                yX = 1;
            }
            textView.setText(MessageFormat.format(this.fYK.getApplicationContext().getResources().getString(e.j.current_page), Integer.valueOf(za), Integer.valueOf(yX)));
            this.fYK.ShowSoftKeyPadDelay(this.ggE, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gfU.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fYK.showToast(str);
    }

    public boolean ls(boolean z) {
        if (this.Tj == null || !this.Tj.Ms()) {
            return false;
        }
        this.Tj.KM();
        return true;
    }

    public void bmE() {
        if (this.git != null) {
            while (this.git.size() > 0) {
                TbImageView remove = this.git.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bmE();
        this.ggB.sz(1);
        if (this.gfK != null) {
            this.gfK.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.ggB.sz(2);
        if (this.gfK != null) {
            this.gfK.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.ghL != null) {
            this.ghL.destroy();
        }
        if (this.gie != null) {
            this.gie.onDestory();
        }
        if (this.ghT != null) {
            this.ghT.hide();
        }
        if (this.gfN != null) {
            this.gfN.asz();
        }
        if (this.gfM != null) {
            this.gfM.onDestroy();
        }
        this.fYK.hideProgressBar();
        if (this.drP != null && this.dJn != null) {
            this.drP.b(this.dJn);
        }
        bmF();
        Fq();
        if (this.ghJ != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ghJ);
        }
        if (this.gga != null && this.ggl != null) {
            this.gga.removeView(this.ggg);
            this.ggl = null;
        }
        if (this.ghp != null) {
            this.ghp.clearStatus();
        }
        this.gim = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.ggB.sz(3);
        if (this.dNH != null) {
            this.dNH.setBackgroundDrawable(null);
        }
        if (this.gfK != null) {
            this.gfK.destroy();
        }
        if (this.ggB != null) {
            this.ggB.onDestroy();
        }
        this.gfU.setOnLayoutListener(null);
        if (this.ghZ != null) {
            this.ghZ.aEp();
        }
        if (this.ghA != null) {
            this.ghA.onDestroy();
        }
        bnb();
    }

    public boolean sR(int i) {
        if (this.gfK != null) {
            return this.gfK.mI(i);
        }
        return false;
    }

    public void bmF() {
        this.gfQ.dismissPopMenu();
        if (this.gfN != null) {
            this.gfN.asz();
        }
        com.baidu.adp.lib.util.l.b(this.fYK.getPageContext().getPageActivity(), this.ggE);
        blR();
        if (this.ggU != null) {
            this.ggU.dismiss();
        }
        bmH();
        if (this.gfM != null) {
            this.gfM.boG();
        }
        if (this.ggC != null) {
            this.ggC.dismiss();
        }
        if (this.dNr != null) {
            this.dNr.dismiss();
        }
    }

    public void bmG() {
        this.gfQ.dismissPopMenu();
        if (this.gfN != null) {
            this.gfN.asz();
        }
        if (this.ggU != null) {
            this.ggU.dismiss();
        }
        bmH();
        if (this.gfM != null) {
            this.gfM.boG();
        }
        if (this.ggC != null) {
            this.ggC.dismiss();
        }
        if (this.dNr != null) {
            this.dNr.dismiss();
        }
    }

    public void dp(List<String> list) {
        this.ghY = list;
        if (this.ghZ != null) {
            this.ghZ.setData(list);
        }
    }

    public void kC(boolean z) {
        this.ggB.kC(z);
    }

    public void lt(boolean z) {
        this.ggZ = z;
    }

    public void bmH() {
        if (this.ggL != null) {
            this.ggL.dismiss();
        }
        if (this.ggM != null) {
            com.baidu.adp.lib.g.g.b(this.ggM, this.fYK.getPageContext());
        }
        if (this.ggN != null) {
            com.baidu.adp.lib.g.g.b(this.ggN, this.fYK.getPageContext());
        }
        if (this.ggJ != null) {
            com.baidu.adp.lib.g.g.b(this.ggJ, this.fYK.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.gck, this.fZb);
            d(this.gck, this.fZb, this.mType);
            this.fYK.getLayoutMode().setNightMode(i == 1);
            this.fYK.getLayoutMode().onModeChanged(this.drR);
            this.fYK.getLayoutMode().onModeChanged(this.gfV);
            if (this.gfM != null) {
                this.gfM.onChangeSkinType(i);
            }
            if (this.gfX != null) {
                com.baidu.tbadk.core.util.al.h(this.gfX, e.d.cp_cont_b);
                this.gfX.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            }
            if (this.dRc != null) {
                this.dRc.ey(i);
                if (this.bfV != null) {
                    this.fYK.getLayoutMode().onModeChanged(this.bfV);
                    com.baidu.tbadk.core.util.al.i(this.bfV, e.f.pb_foot_more_trans_selector);
                }
            }
            if (this.ggC != null) {
                this.ggC.c(this.fYK.getPageContext());
            }
            lr(this.ggW);
            this.ggB.notifyDataSetChanged();
            if (this.ggF != null) {
                this.ggF.ey(i);
            }
            if (this.Tj != null) {
                this.Tj.onChangeSkinType(i);
            }
            if (this.ggk != null) {
                this.ggk.eD(i);
            }
            if (this.ggG != null) {
                this.ggG.ey(i);
            }
            if (!com.baidu.tbadk.core.util.v.I(this.daK)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.daK) {
                    customBlueCheckRadioButton.EV();
                }
            }
            ln(i == 1);
            bmg();
            UtilHelper.setStatusBarBackground(this.dNH, i);
            UtilHelper.setStatusBarBackground(this.ghu, i);
            if (this.ggm != null) {
                this.ggm.onChangeSkinType(i);
            }
            if (this.ggr != null) {
                com.baidu.tbadk.core.util.al.h(this.ggr, e.d.cp_cont_d);
            }
            if (this.ggq != null) {
                com.baidu.tbadk.core.util.al.h(this.ggq, e.d.cp_cont_d);
            }
            if (this.ggs != null) {
                com.baidu.tbadk.core.util.al.i(this.ggs, e.d.cp_cont_e);
            }
            if (this.aKM != null) {
                com.baidu.tbadk.core.util.al.h(this.aKM, e.d.cp_cont_d);
            }
            if (this.ggt != null) {
                com.baidu.tbadk.core.util.al.i(this.ggt, e.d.cp_cont_e);
            }
            if (this.ggd != null) {
                com.baidu.tbadk.core.util.al.h(this.ggd, e.d.cp_link_tip_a);
            }
            if (this.ggp != null) {
                com.baidu.tbadk.core.util.al.h(this.ggp, e.d.cp_cont_d);
            }
            if (this.ggu != null) {
                com.baidu.tbadk.o.a.a(this.fYK.getPageContext(), this.ggu);
            }
            if (this.ggS != null) {
                com.baidu.tbadk.o.a.a(this.fYK.getPageContext(), this.ggS);
            }
            if (this.ghK != null) {
                this.ghK.onChangeSkinType(i);
            }
            if (this.gfQ != null) {
                if (this.gfK != null) {
                    this.gfK.sW(i);
                } else {
                    this.gfQ.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.ghc != null) {
                com.baidu.tbadk.core.util.al.h(this.ghc, e.d.cp_cont_e);
            }
            if (this.gge != null) {
                com.baidu.tbadk.core.util.al.c(this.gge, BitmapHelper.getGradeResourceIdInEnterForum(this.ghS));
            }
            if (this.gia != null) {
                this.gia.onChangeSkinType(i);
            }
            if (this.ghA != null) {
                this.ghA.onChangeSkinType();
            }
            if (this.ghW != null) {
                com.baidu.tbadk.core.util.al.h(this.ghW, e.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsE = hVar;
        this.ggB.setOnImageClickListener(this.bsE);
        this.gia.setOnImageClickListener(this.bsE);
    }

    public void h(NoNetworkView.a aVar) {
        this.dJn = aVar;
        if (this.drP != null) {
            this.drP.a(this.dJn);
        }
    }

    public void lu(boolean z) {
        this.ggB.setIsFromCDN(z);
    }

    public Button bmI() {
        return this.gha;
    }

    public void bmJ() {
        if (this.gfP != 2) {
            this.gfU.setNextPage(this.dRc);
            this.gfP = 2;
        }
    }

    public void bmK() {
        if (com.baidu.tbadk.l.m.PD().PE()) {
            int lastVisiblePosition = this.gfU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gfU.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(e.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.gj(1001);
                                perfLog.bgB = true;
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
                        perfLog2.bgB = true;
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
        if (this.ghb != null) {
            lt(this.fYK.biP().MV());
            if (this.ggZ) {
                lk(z);
            } else {
                ll(z);
            }
        }
    }

    public void bmO() {
        if (this.ghb != null) {
            this.ghb.setVisibility(8);
            this.ghg = false;
            if (this.ghA != null) {
                this.ghA.setVisibility(8);
                lp(false);
            }
            bnb();
        }
    }

    public void showLoadingDialog() {
        if (this.dih == null) {
            this.dih = new com.baidu.tbadk.core.view.d(this.fYK.getPageContext());
        }
        this.dih.bB(true);
    }

    public void alK() {
        if (this.dih != null) {
            this.dih.bB(false);
        }
    }

    private int getScrollY() {
        View childAt = this.gfU.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.gfU.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.gfK != null) {
            this.gfK.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.giu = getScrollY();
            this.ghz.giJ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ghz));
            a(this.ghz.giJ, true);
        }
    }

    public void lw(boolean z) {
        this.gfK.lw(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gfK != null) {
            this.gfK.b(absListView, i);
        }
        int headerViewsCount = (i - this.gfU.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (headerViewsCount <= i2 && this.ggB.sy(headerViewsCount) != com.baidu.tieba.pb.data.i.fUA) {
            headerViewsCount++;
        }
        boolean z = i < this.gfU.getHeaderViewsCount();
        if (this.gfY != null && this.gfQ != null) {
            this.gfQ.h(this.gfY.getBottom(), this.gfY.getMeasuredHeight(), z);
        }
        this.ghz.fPe = i;
        this.ghz.headerCount = this.gfU.getHeaderViewsCount();
        this.ghz.giJ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ghz));
        a(this.ghz.giJ, false);
    }

    public void bmP() {
        if (this.fYK.isLogin() && this.gck != null && this.ghP && !this.ghO && !this.ggX && this.ghk != null && this.ghk.zT() != null && !this.ghk.zT().getIsLike() && !this.ghk.zT().hadConcerned()) {
            if (this.ghL == null) {
                this.ghL = new an(this.fYK);
            }
            this.ghL.a(this.gfQ.gkW, this.gck.bhZ(), this.ghk.zT().getUserId(), this.gck.getThreadId());
        }
    }

    public void bmQ() {
        if (this.ghP && !this.ghO && this.ghk != null && this.ghk.zT() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").y("obj_locate", this.fYK.bit() ? 2 : 1).y("obj_type", this.ghO ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fYK.getPageContext().getPageActivity(), this.ghk.zT().getUserId(), this.ghk.zT().getUserName(), this.fYK.biD().biu(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.ghO && this.ght != null && this.gfQ.bnz() != null) {
            int bjZ = this.ggB.bjZ();
            if (bjZ > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bjZ > this.gfU.getFirstVisiblePosition() - this.gfU.getHeaderViewsCount()) {
                    this.ght.setVisibility(8);
                    return;
                }
                this.ght.setVisibility(0);
                bna();
                this.gfQ.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.gfj == null) {
                if (this.gfU.getFirstVisiblePosition() == 0) {
                    this.ght.setVisibility(8);
                    this.gfQ.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.ghy) {
                        this.ghx = top;
                        this.ghy = false;
                    }
                    this.ghx = top < this.ghx ? top : this.ghx;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.ggA.getY() < 0.0f) {
                        measuredHeight = ghw - alVar.gfj.getMeasuredHeight();
                    } else {
                        measuredHeight = this.gfQ.bnz().getMeasuredHeight() - alVar.gfj.getMeasuredHeight();
                        this.gfQ.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.ghx) {
                        this.ght.setVisibility(0);
                        bna();
                    } else if (top < measuredHeight) {
                        this.ght.setVisibility(0);
                        bna();
                    } else {
                        this.ght.setVisibility(8);
                        this.gfQ.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.ghy = true;
                    }
                }
            }
        }
    }

    public void bmR() {
        if (!this.giv) {
            TiebaStatic.log("c10490");
            this.giv = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fYK.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(ghD, Integer.valueOf(ghF));
            aVar.da(e.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.function_description_view)).setText(e.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(e.g.title_view)).setText(e.j.grade_thread_tips);
            aVar.G(inflate);
            aVar.H(sparseArray);
            aVar.a(e.j.grade_button_tips, this.fYK);
            aVar.b(e.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fYK.getPageContext()).BS();
        }
    }

    public void tu(String str) {
        if (str.contains(BaseRequestAction.SPLITE)) {
            str = str.replace(BaseRequestAction.SPLITE, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fYK.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(e.g.function_description_view)).setVisibility(8);
        aVar.G(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(ghD, Integer.valueOf(ghG));
        aVar.H(sparseArray);
        aVar.a(e.j.view, this.fYK);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fYK.getPageContext()).BS();
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
        return this.ghp;
    }

    private void s(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bhz() != null && dVar.bhz().AL() && this.ghp == null) {
            this.ghp = (PbInterviewStatusView) this.gho.inflate();
            this.ghp.setOnClickListener(this.dNs);
            this.ghp.setCallback(this.fYK.bjB());
            this.ghp.setData(this.fYK, dVar);
        }
    }

    public LinearLayout bmT() {
        return this.ggA;
    }

    public View bmU() {
        return this.dNH;
    }

    public boolean bmV() {
        return this.gig;
    }

    public void kH(boolean z) {
        this.gfZ.kH(z);
    }

    public void tv(String str) {
        if (this.gfR != null) {
            this.gfR.setTitle(str);
        }
    }

    private int lx(boolean z) {
        if (this.ghp == null || this.ghp.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds72);
    }

    private void bmW() {
        if (this.ghp != null && this.ghp.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ghp.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.ghp.setLayoutParams(layoutParams);
        }
    }

    public boolean biV() {
        return false;
    }

    public void tw(String str) {
        this.ghc.performClick();
        if (!StringUtils.isNull(str) && this.fYK.biP() != null && this.fYK.biP().MO() != null && this.fYK.biP().MO().getInputView() != null) {
            EditText inputView = this.fYK.biP().MO().getInputView();
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
            if (this.ghK != null) {
                this.ghK.bkg();
            }
            this.fYK.aCk();
            this.ggA.setVisibility(8);
            this.gfQ.lJ(false);
            this.fYK.kN(false);
            if (this.gfK != null) {
                if (configuration.orientation == 1) {
                    bmT().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.gfU.setIsLandscape(true);
                    this.gfU.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.gfU.setIsLandscape(false);
                    if (this.giu > 0) {
                        this.gfU.smoothScrollBy(this.giu, 0);
                    }
                }
                this.gfK.onConfigurationChanged(configuration);
                this.ghs.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void ly(boolean z) {
        this.gfO = z;
    }

    public boolean bmX() {
        return this.gfK != null && this.gfK.bmX();
    }

    public void bmY() {
        if (this.gfK != null) {
            this.gfK.onPause();
        }
    }

    public void n(long j, int i) {
        if (this.gfM != null) {
            this.gfM.n(j, i);
        }
        if (this.gfK != null) {
            this.gfK.n(j, i);
        }
    }

    public void kS(boolean z) {
        this.ggB.kS(z);
    }

    public void bmZ() {
        if (this.ghq == null) {
            LayoutInflater.from(this.fYK.getActivity()).inflate(e.h.add_experienced_text, (ViewGroup) this.drR, true);
            this.ghq = (ViewGroup) this.drR.findViewById(e.g.add_experienced_layout);
            this.ghr = (TextView) this.drR.findViewById(e.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.ghr, e.d.cp_cont_i);
            String string = this.fYK.getResources().getString(e.j.experienced_add_success);
            String string2 = this.fYK.getResources().getString(e.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_h)));
            this.ghr.setText(spannableString);
        }
        this.ghq.setVisibility(0);
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
                        ar.this.ghq.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.ghr.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.ghr.startAnimation(scaleAnimation);
    }

    public void bG(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.ghb.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fYK);
            frameLayout.setBackgroundResource(e.f.pic_sign_tip);
            this.ghW = new TextView(this.fYK);
            this.ghW.setText(e.j.connection_tips);
            this.ghW.setGravity(17);
            this.ghW.setPadding(com.baidu.adp.lib.util.l.h(this.fYK, e.C0210e.ds24), 0, com.baidu.adp.lib.util.l.h(this.fYK, e.C0210e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fYK, e.C0210e.ds60);
            if (this.ghW.getParent() == null) {
                frameLayout.addView(this.ghW, layoutParams);
            }
            this.ghV = new PopupWindow(this.fYK);
            this.ghV.setContentView(frameLayout);
            this.ghV.setHeight(-2);
            this.ghV.setWidth(-2);
            this.ghV.setFocusable(true);
            this.ghV.setOutsideTouchable(false);
            this.ghV.setBackgroundDrawable(new ColorDrawable(this.fYK.getResources().getColor(e.d.transparent)));
            this.gfU.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.ghV.showAsDropDown(ar.this.ghb, view.getLeft(), -ar.this.ghb.getHeight());
                    } else {
                        ar.this.ghV.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bna() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.ghX == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.ghX = new com.baidu.tbadk.core.dialog.a(this.fYK);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.fYK);
            this.ghX.dd(1);
            this.ghX.G(pbLongPressTipView);
            this.ghX.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.31
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ghX.bh(false);
            this.ghX.b(this.fYK.getPageContext()).BS();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.32
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.ghX != null && ar.this.ghX.isShowing()) {
                        ar.this.ghX.dismiss();
                    }
                }
            }, 5000L);
            if (this.gfK != null) {
                this.gfK.boP();
            }
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bnq() != null && !StringUtils.isNull(aVar.bnq().pkg_id) && !StringUtils.isNull(aVar.bnq().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.ghd != null && this.ghd.getVisibility() == 0) {
            if (this.ghU == null) {
                View inflate = LayoutInflater.from(this.fYK.getPageContext().getPageActivity()).inflate(e.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(e.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(e.g.single_bar_tips);
                textView.setText(e.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dNs);
                this.ghU = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.ghd.getLocationInWindow(iArr);
            this.ghU.showAtLocation(this.ghd, 0, iArr[0] - com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds54), (iArr[1] - this.ghd.getHeight()) - com.baidu.adp.lib.util.l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bnb() {
        com.baidu.adp.lib.g.g.a(this.ghU);
    }

    public void lz(boolean z) {
        this.gic = z;
    }

    public boolean bnc() {
        return this.gic;
    }

    public void bH(View view) {
        this.ggS = view;
    }
}
