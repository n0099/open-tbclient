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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.az;
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
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
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
    private static final int fpD = UtilHelper.getLightStatusBarHeight();
    public static int fpJ = 3;
    public static int fpK = 0;
    public static int fpL = 3;
    public static int fpM = 4;
    public static int fpN = 5;
    public static int fpO = 6;
    private EditorTools JS;
    private View aJH;
    private com.baidu.tieba.pb.a.c aWx;
    private e.b anZ;
    private TextView apF;
    private TextView aza;
    private RelativeLayout cHA;
    private NoNetworkView cHy;
    private View.OnClickListener cYQ;
    private View cZd;
    private List<CustomBlueCheckRadioButton> cqZ;
    private PbListView dbz;
    private NavigationBarCoverTip dqU;
    private int eGe;
    PbActivity.d ffO;
    private PbActivity fgJ;
    private View.OnClickListener fhh;
    private UserIconBox fia;
    private UserIconBox fib;
    private PbFakeFloorModel fjf;
    private com.baidu.tieba.pb.data.d fkk;
    public int fnO;
    private com.baidu.tieba.pb.video.i fnP;
    private long fnQ;
    private com.baidu.tieba.pb.video.h fnR;
    private com.baidu.tieba.d.c fnS;
    public final com.baidu.tieba.pb.pb.main.view.b fnV;
    public com.baidu.tieba.pb.pb.main.view.a fnW;
    private ViewStub fnX;
    private ViewStub fnY;
    private PbLandscapeListView fnZ;
    private LinearLayout foA;
    private TextView foB;
    private TextView foC;
    private View foD;
    private View foE;
    private ObservedChangeLinearLayout foG;
    private f foH;
    private View foN;
    private View foa;
    private LinearLayout fod;
    private e foe;
    private ColumnLayout fof;
    private ThreadSkinView fog;
    private TextView foh;
    private TextView foi;
    private ImageView foj;
    private HeadPendantView fok;
    private FrameLayout fol;
    private HeadImageView fom;
    private View fon;
    private FloatingLayout foo;

    /* renamed from: for  reason: not valid java name */
    private PbFirstFloorUserLikeButton f0for;
    private aq fot;
    private aq fou;
    private TextView fov;
    private TextView fow;
    private TextView fox;
    private View foy;
    private View foz;
    private View fpA;
    private View fpB;
    private ak fpC;
    private PbEmotionBar fpH;
    private int fpP;
    private Runnable fpQ;
    private r fpR;
    private am fpS;
    private int fpY;
    private View fph;
    private TextView fpi;
    private ImageView fpj;
    private ImageView fpk;
    private TextView fpl;
    private boolean fpn;
    private int fpo;
    private int fpp;
    private PostData fpq;
    private View fpt;
    private TextView fpu;
    private ViewStub fpv;
    private PbInterviewStatusView fpw;
    private ViewGroup fpx;
    private TextView fpy;
    private FrameLayout fpz;
    private PbTopTipView fqa;
    private PopupWindow fqb;
    private PopupWindow fqc;
    private TextView fqd;
    private List<String> fqe;
    private com.baidu.tieba.pb.pb.main.emotion.c fqf;
    private com.baidu.tieba.pb.pb.godreply.a fqg;
    private PbLandscapeListView.b fqh;
    private ab fqj;
    private boolean fql;
    private com.baidu.tbadk.core.view.userLike.c fqm;
    private com.baidu.tbadk.core.view.userLike.c fqn;
    private Runnable fqs;
    private PbActivity.b fqu;
    private boolean isLandscape;
    private View mFooterView;
    private int mType;
    private boolean fnT = false;
    private int fnU = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fob = null;
    private TextView foc = null;
    public FrsPraiseView fop = null;
    private ClickableHeaderImageView foq = null;
    private View foF = null;
    private com.baidu.tbadk.core.dialog.a foI = null;
    private com.baidu.tbadk.core.dialog.b cYP = null;
    private View foJ = null;
    private EditText foK = null;
    private com.baidu.tieba.pb.view.e foL = null;
    private com.baidu.tieba.pb.view.a foM = null;
    private com.baidu.tbadk.core.dialog.a foO = null;
    private b.InterfaceC0086b ebG = null;
    private TbRichTextView.h aWw = null;
    private NoNetworkView.a cVe = null;
    private Dialog foP = null;
    private View foQ = null;
    private com.baidu.tbadk.core.dialog.a foR = null;
    private Dialog foS = null;
    private Dialog foT = null;
    private View foU = null;
    private LinearLayout foV = null;
    private CompoundButton.OnCheckedChangeListener cra = null;
    private TextView foW = null;
    private TextView foX = null;
    private View foY = null;
    private String foZ = null;
    private com.baidu.tbadk.core.dialog.b fpa = null;
    private com.baidu.tbadk.core.dialog.b fpb = null;
    private boolean fpc = false;
    private boolean fpd = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fpe = null;
    private boolean fpf = false;
    private Button fpg = null;
    private boolean fpm = true;
    private com.baidu.tbadk.core.view.a cym = null;
    private boolean fha = false;
    private int mSkinType = 3;
    private boolean fpr = false;
    private int fpE = 0;
    private boolean fpF = true;
    private a fpG = new a();
    private int fpI = 0;
    private boolean fpT = false;
    private int fpU = 0;
    private boolean fpV = false;
    private boolean fpW = false;
    private boolean fpX = false;
    private int fpZ = 0;
    private boolean fqi = false;
    private a.InterfaceC0215a fqk = new a.InterfaceC0215a() { // from class: com.baidu.tieba.pb.pb.main.as.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0215a
        public void onRefresh() {
        }
    };
    private String fqo = null;
    private CustomMessageListener fqp = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.as.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                as.this.fqo = null;
            }
        }
    };
    private CustomMessageListener bnd = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.as.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && as.this.foH != null) {
                as.this.foH.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fqq = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.as.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (as.this.foc != null) {
                as.this.foc.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fqr = new Handler();
    private CustomMessageListener fqt = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.as.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                as.this.fpm = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fqv = true;
    View.OnClickListener fqw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (as.this.fpV) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11923").r(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (view2 == as.this.fnV.fsY) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12506").r("obj_locate", 2));
            }
            if (as.this.fgJ.feM.fsh != null) {
                if (!as.this.fpV && as.this.fkk != null && as.this.fkk.aVs() != null && as.this.fkk.aVs().rQ() != null && as.this.fkk.aVs().rQ().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12151").r("obj_locate", 1));
                }
                as.this.fgJ.feM.fsh.onClick(view2);
            }
        }
    };
    private boolean fqx = false;
    String userId = null;
    private final List<TbImageView> fqy = new ArrayList();
    private boolean fqz = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int eXB;
        public ak fqN;
        public int headerCount;
    }

    public void kb(boolean z) {
        this.fpT = z;
        if (this.fnZ != null) {
            this.fpU = this.fnZ.getHeaderViewsCount();
        }
    }

    public void aZD() {
        if (this.fnZ != null) {
            int headerViewsCount = this.fnZ.getHeaderViewsCount() - this.fpU;
            final int firstVisiblePosition = (this.fnZ.getFirstVisiblePosition() == 0 || this.fnZ.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fnZ.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fnZ.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fpG.fqN = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fpG));
            final ak akVar = this.fpG.fqN;
            final int h = h(akVar);
            final int y = ((int) this.foG.getY()) + this.foG.getMeasuredHeight();
            final boolean z = this.fpA.getVisibility() == 0;
            boolean z2 = this.foG.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.foH.aXO() + this.fnZ.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fnd.getMeasuredHeight() : 0;
                if (z2) {
                    this.fnZ.setSelectionFromTop(this.foH.aXO() + this.fnZ.getHeaderViewsCount(), fpD - measuredHeight);
                } else {
                    this.fnZ.setSelectionFromTop(this.foH.aXO() + this.fnZ.getHeaderViewsCount(), this.fnV.bbf().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fnZ.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fpV) {
                this.fnZ.setSelectionFromTop(this.foH.aXO() + this.fnZ.getHeaderViewsCount(), this.fnP.bcw().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fnZ.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.as.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aYf() {
                        if (h >= 0 && h <= as.this.cHA.getMeasuredHeight()) {
                            int h2 = as.this.h(akVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = as.this.mFooterView.getLayoutParams();
                            if (i == 0 || i > as.this.cHA.getMeasuredHeight() || h2 >= as.this.cHA.getMeasuredHeight()) {
                                layoutParams.height = as.this.fpP;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > as.this.cHA.getMeasuredHeight()) {
                                layoutParams.height = as.this.fpP;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                as.this.fnZ.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            as.this.mFooterView.setLayoutParams(layoutParams);
                        }
                        as.this.fnZ.setOnLayoutListener(null);
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

    public NoNetworkView aZE() {
        return this.cHy;
    }

    public void aZF() {
        if (this.JS != null) {
            this.JS.hide();
            if (this.fqf != null) {
                this.fqf.OL();
            }
        }
    }

    public PbFakeFloorModel aZG() {
        return this.fjf;
    }

    public r aZH() {
        return this.fpR;
    }

    public void aZI() {
        reset();
        aZF();
        this.fpR.aXV();
        kn(false);
    }

    private void reset() {
        if (this.fgJ != null && this.fgJ.aWJ() != null && this.JS != null) {
            com.baidu.tbadk.editortools.pb.a.Eb().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aWJ = this.fgJ.aWJ();
            aWJ.Et();
            aWJ.DP();
            if (aWJ.getWriteImagesInfo() != null) {
                aWJ.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aWJ.eN(SendView.ALL);
            aWJ.eO(SendView.ALL);
            com.baidu.tbadk.editortools.g eE = this.JS.eE(23);
            com.baidu.tbadk.editortools.g eE2 = this.JS.eE(2);
            com.baidu.tbadk.editortools.g eE3 = this.JS.eE(5);
            if (eE2 != null) {
                eE2.lN();
            }
            if (eE3 != null) {
                eE3.lN();
            }
            if (eE != null) {
                eE.hide();
            }
            this.JS.invalidate();
        }
    }

    public boolean aZJ() {
        return this.fpm;
    }

    public void kc(boolean z) {
        if (this.fph != null && this.fpi != null) {
            this.fpi.setText(d.k.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fph.startAnimation(alphaAnimation);
            }
            this.fph.setVisibility(0);
            this.fpm = true;
            if (this.fpH != null && !this.fqg.isActive()) {
                this.fpH.setVisibility(0);
                kh(true);
            }
        }
    }

    public void kd(boolean z) {
        if (this.fph != null && this.fpi != null) {
            this.fpi.setText(d.k.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fph.startAnimation(alphaAnimation);
            }
            this.fph.setVisibility(0);
            this.fpm = true;
            if (this.fpH != null && !this.fqg.isActive()) {
                this.fpH.setVisibility(0);
                kh(true);
            }
        }
    }

    public PostData aZK() {
        int i = 0;
        if (this.fnZ == null) {
            return null;
        }
        int aZL = aZL() - this.fnZ.getHeaderViewsCount();
        if (aZL < 0) {
            aZL = 0;
        }
        if (this.foH.qi(aZL) != null && this.foH.qi(aZL) != PostData.gwr) {
            i = aZL + 1;
        }
        return this.foH.getItem(i) instanceof PostData ? (PostData) this.foH.getItem(i) : null;
    }

    public int aZL() {
        int i;
        View childAt;
        if (this.fnZ == null) {
            return 0;
        }
        int firstVisiblePosition = this.fnZ.getFirstVisiblePosition();
        int lastVisiblePosition = this.fnZ.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fnZ.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fnZ.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int aZM() {
        return this.fnZ.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fkk != null && this.fkk.aVu() != null && !this.fkk.aVu().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fkk.aVu().size() && (postData = this.fkk.aVu().get(i)) != null && postData.rQ() != null && !StringUtils.isNull(postData.rQ().getUserId()); i++) {
                if (this.fkk.aVu().get(i).rQ().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fqg != null && this.fqg.isActive()) {
                        kn(false);
                    }
                    if (this.fpH != null) {
                        this.fpH.ku(true);
                    }
                    this.fqo = postData.rQ().getName_show();
                    return;
                }
            }
        }
    }

    public as(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fgJ = null;
        this.cHA = null;
        this.cZd = null;
        this.fnQ = 0L;
        this.fnZ = null;
        this.foa = null;
        this.fod = null;
        this.fof = null;
        this.foh = null;
        this.foi = null;
        this.fol = null;
        this.fom = null;
        this.fon = null;
        this.f0for = null;
        this.fov = null;
        this.fow = null;
        this.fox = null;
        this.foy = null;
        this.foD = null;
        this.foE = null;
        this.foH = null;
        this.dbz = null;
        this.aJH = null;
        this.cYQ = null;
        this.fhh = null;
        this.fph = null;
        this.fpi = null;
        this.fpj = null;
        this.fpk = null;
        this.fpl = null;
        this.fpt = null;
        this.fpu = null;
        this.fpv = null;
        this.fpY = 0;
        this.fnQ = System.currentTimeMillis();
        this.fgJ = pbActivity;
        this.cYQ = onClickListener;
        this.aWx = cVar;
        this.fpY = com.baidu.adp.lib.util.l.af(this.fgJ) / 2;
        this.cHA = (RelativeLayout) LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.new_pb_activity, (ViewGroup) null);
        this.fgJ.addContentView(this.cHA, new FrameLayout.LayoutParams(-1, -1));
        this.dqU = (NavigationBarCoverTip) this.fgJ.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.cZd = this.fgJ.findViewById(d.g.statebar_view);
        this.foG = (ObservedChangeLinearLayout) this.fgJ.findViewById(d.g.title_wrapper);
        this.cHy = (NoNetworkView) this.fgJ.findViewById(d.g.view_no_network);
        this.fnZ = (PbLandscapeListView) this.fgJ.findViewById(d.g.new_pb_list);
        this.fpz = (FrameLayout) this.fgJ.findViewById(d.g.root_float_header);
        this.aza = new TextView(this.fgJ.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds88));
        this.fnZ.addHeaderView(this.aza, 0);
        this.fpP = this.fgJ.getResources().getDimensionPixelSize(d.e.tbds134);
        this.mFooterView = new View(this.fgJ.getPageContext().getPageActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fpP));
        this.mFooterView.setVisibility(4);
        this.fnZ.addFooterView(this.mFooterView);
        this.fnZ.setOnTouchListener(this.fgJ.aNK);
        this.fnV = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fgJ.aXl()) {
            this.fnX = (ViewStub) this.fgJ.findViewById(d.g.manga_view_stub);
            this.fnX.setVisibility(0);
            this.fnW = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fnW.show();
            this.fnV.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds120);
        }
        this.aza.setLayoutParams(layoutParams);
        this.fnV.bbf().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0187a() { // from class: com.baidu.tieba.pb.pb.main.as.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0187a
            public void aWl() {
                if (as.this.fnZ != null) {
                    if (as.this.fnP != null) {
                        as.this.fnP.bcx();
                    }
                    as.this.fnZ.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0187a
            public void aWm() {
                as.this.fgJ.apD();
            }
        }));
        this.fph = this.fgJ.findViewById(d.g.pb_editor_tool_comment);
        this.fpo = com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds90);
        this.fpp = com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds242);
        this.fpi = (TextView) this.fgJ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fpk = (ImageView) this.fgJ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fpj = (ImageView) this.fgJ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fpl = (TextView) this.fgJ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fpl.setVisibility(8);
        this.fpi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (!as.this.fgJ.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, as.this.mForumId));
                } else if (as.this.fgJ.aWT()) {
                    com.baidu.tbadk.editortools.pb.d aWJ = as.this.fgJ.aWJ();
                    if (aWJ == null || (!aWJ.Eq() && !aWJ.Er())) {
                        if (as.this.JS != null) {
                            as.this.aZW();
                        }
                        if (as.this.JS != null) {
                            as.this.fpm = false;
                            if (as.this.JS.eH(2) != null) {
                                com.baidu.tieba.tbadkCore.b.a.a(as.this.fgJ, (View) as.this.JS.eH(2).aCM, false, as.this.fqk);
                            }
                        }
                        as.this.baA();
                        return;
                    }
                    as.this.fgJ.aWJ().a(false, (PostWriteCallBackData) null);
                }
            }
        });
        this.fpj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (as.this.fgJ.checkUpIsLogin()) {
                    if (as.this.JS != null) {
                        as.this.aZW();
                        as.this.JS.M((View) as.this.JS.eE(5));
                    }
                    if (as.this.JS != null) {
                        as.this.fpm = false;
                        if (as.this.JS.eH(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fgJ, (View) as.this.JS.eH(2).aCM, false, as.this.fqk);
                        }
                    }
                    as.this.baA();
                }
            }
        });
        this.fpk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (as.this.fgJ.checkUpIsLogin()) {
                    if (as.this.JS != null) {
                        as.this.aZW();
                        as.this.JS.M((View) as.this.JS.eE(2));
                    }
                    if (as.this.JS != null) {
                        as.this.fpm = false;
                        if (as.this.JS.eH(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fgJ, (View) as.this.JS.eH(2).aCM, false, as.this.fqk);
                        }
                    }
                    as.this.baA();
                }
            }
        });
        this.fpl.setOnClickListener(this.cYQ);
        this.fpl.setOnTouchListener(this.fgJ);
        this.foa = LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_item, (ViewGroup) null);
        this.fod = (LinearLayout) LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.ak.i(this.fod, d.C0126d.cp_bg_line_d);
        this.foe = new e(this.fgJ, this.fod);
        this.foe.init();
        this.foe.a(this.foe.aWI(), this.cYQ);
        this.fof = (ColumnLayout) this.fod.findViewById(d.g.pb_head_owner_root);
        this.fog = (ThreadSkinView) this.fod.findViewById(d.g.pb_thread_skin);
        this.fof.setOnLongClickListener(this.onLongClickListener);
        this.fof.setOnTouchListener(this.aWx);
        this.fof.setVisibility(8);
        this.foa.setOnTouchListener(this.aWx);
        this.fpt = this.foa.findViewById(d.g.pb_head_activity_join_number_container);
        this.fpt.setVisibility(8);
        this.fpu = (TextView) this.foa.findViewById(d.g.pb_head_activity_join_number);
        this.foh = (TextView) this.fof.findViewById(d.g.pb_head_owner_info_user_name);
        this.foi = (TextView) this.fof.findViewById(d.g.floor_owner);
        this.foj = (ImageView) this.fof.findViewById(d.g.icon_forum_level);
        this.fol = (FrameLayout) this.fof.findViewById(d.g.pb_head_headImage_container);
        this.fom = (HeadImageView) this.fof.findViewById(d.g.pb_head_owner_photo);
        this.fok = (HeadPendantView) this.fof.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fok.setHasPendantStyle();
        if (this.fok.getHeadView() != null) {
            this.fok.getHeadView().setIsRound(true);
            this.fok.getHeadView().setDrawBorder(false);
        }
        this.fia = (UserIconBox) this.fof.findViewById(d.g.show_icon_vip);
        this.fib = (UserIconBox) this.fof.findViewById(d.g.show_icon_yinji);
        this.foo = (FloatingLayout) this.fod.findViewById(d.g.pb_head_owner_info_root);
        this.f0for = (PbFirstFloorUserLikeButton) this.fof.findViewById(d.g.pb_like_button);
        this.fov = (TextView) this.fof.findViewById(d.g.pb_views);
        this.apF = (TextView) this.fof.findViewById(d.g.view_forum_name);
        this.foz = this.fof.findViewById(d.g.line_right_forum_name);
        this.fow = (TextView) this.fof.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fox = (TextView) this.fof.findViewById(d.g.pb_item_first_floor_location_address);
        this.foy = this.fof.findViewById(d.g.line_between_time_and_locate);
        this.fqm = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fqn = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.foD = this.foa.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.foE = this.foa.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.foa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return false;
            }
        });
        this.fpv = (ViewStub) this.cHA.findViewById(d.g.interview_status_stub);
        this.foH = new f(this.fgJ, this.fnZ);
        this.foH.t(this.cYQ);
        this.foH.setTbGestureDetector(this.aWx);
        this.foH.setOnImageClickListener(this.aWw);
        this.fhh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.b(as.this.fgJ.getBaseContext(), as.this.fgJ.aWx().aYj(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                as.this.fgJ.b(sparseArray);
                                return;
                            }
                            as.this.be(view2);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        as.this.fgJ.b(sparseArray);
                    } else if (booleanValue3) {
                        as.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.foH.F(this.fhh);
        aZR();
        this.fnZ.addHeaderView(this.fob);
        this.fnZ.addHeaderView(this.fod);
        this.fnZ.addHeaderView(this.foa);
        this.dbz = new PbListView(this.fgJ.getPageContext().getPageActivity());
        this.aJH = this.dbz.getView().findViewById(d.g.pb_more_view);
        if (this.aJH != null) {
            this.aJH.setOnClickListener(this.cYQ);
            com.baidu.tbadk.core.util.ak.i(this.aJH, d.f.pb_foot_more_trans_selector);
        }
        this.dbz.wN();
        this.dbz.setBackground(d.f.pb_foot_more_trans_selector);
        this.dbz.du(d.f.pb_foot_more_trans_selector);
        this.foN = this.fgJ.findViewById(d.g.viewstub_progress);
        this.fgJ.registerListener(this.fqt);
        this.fon = com.baidu.tbadk.ala.b.os().f(this.fgJ.getActivity(), 2);
        if (this.fon != null) {
            this.fon.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fgJ.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fon.getParent() == null) {
                this.foo.addView(this.fon, aVar);
            }
        }
        this.fjf = new PbFakeFloorModel(this.fgJ.getPageContext());
        this.fpR = new r(this.fgJ.getPageContext(), this.fjf, this.cHA);
        this.fpR.a(this.fgJ.ffK);
        this.fjf.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.as.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                as.this.fjf.l(postData);
                as.this.foH.notifyDataSetChanged();
                as.this.fpR.aXV();
                as.this.JS.Ca();
                as.this.kn(false);
            }
        });
        if (this.fgJ.aWx() != null && !StringUtils.isNull(this.fgJ.aWx().aYO())) {
            this.fgJ.showToast(this.fgJ.aWx().aYO());
        }
        this.fpA = this.fgJ.findViewById(d.g.pb_expand_blank_view);
        this.fpB = this.fgJ.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fpB.getLayoutParams();
        if (this.fgJ.aWx() != null && this.fgJ.aWx().aYm()) {
            this.fpA.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fpB.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fpD;
            this.fpB.setLayoutParams(layoutParams2);
        }
        this.fpC = new ak(this.fgJ.getPageContext(), this.fgJ.findViewById(d.g.pb_reply_expand_view));
        this.fpC.fnd.setVisibility(8);
        this.fpC.H(this.cYQ);
        this.fgJ.registerListener(this.bnd);
        this.fgJ.registerListener(this.fqp);
        this.fgJ.registerListener(this.fqq);
        aZN();
        kh(false);
    }

    private void aZN() {
        this.fqg = new com.baidu.tieba.pb.pb.godreply.a(this.fgJ, this, (ViewStub) this.cHA.findViewById(d.g.more_god_reply_popup));
        this.fqg.n(this.cYQ);
        this.fqg.F(this.fhh);
        this.fqg.setOnImageClickListener(this.aWw);
        this.fqg.n(this.cYQ);
        this.fqg.setTbGestureDetector(this.aWx);
    }

    public com.baidu.tieba.pb.pb.godreply.a aZO() {
        return this.fqg;
    }

    public View aZP() {
        return this.fpA;
    }

    public void aZQ() {
        if (this.fnZ != null) {
            this.fnZ.removeHeaderView(this.fob);
            this.fnZ.removeHeaderView(this.fod);
            this.fnZ.removeHeaderView(this.foa);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fpH == null) {
            this.fpH = new PbEmotionBar(this.fgJ.getPageContext().getPageActivity());
            kh(true);
            this.fpH.a(this.cHA, aVar, this.fph.getVisibility() == 0);
            this.fpH.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.as.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (as.this.fgJ.aWT()) {
                        if (!StringUtils.isNull(as.this.fqo)) {
                            emotionImageData.setAuthorNameShow(as.this.fqo);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    as.this.fgJ.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(as.this.fgJ.getPageContext().getPageActivity(), 25016, str, list, as.this.fqo, list2)));
                }
            });
            this.fpH.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.as.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    as.this.baM();
                    if (as.this.fph != null) {
                        ViewGroup.LayoutParams layoutParams = as.this.fph.getLayoutParams();
                        layoutParams.height = (int) (((as.this.fpp - as.this.fpo) * f) + as.this.fpo);
                        as.this.fpi.setAlpha(1.0f - f);
                        as.this.fpk.setAlpha(1.0f - f);
                        as.this.fpj.setAlpha(1.0f - f);
                        as.this.fph.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aZR() {
        if (this.fob == null) {
            int e = com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.tbds44);
            this.fob = new LinearLayout(this.fgJ.getPageContext().getPageActivity());
            this.fob.setOrientation(1);
            this.fob.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fob.setPadding(e, com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.tbds30), e, com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.tbds40));
            this.fob.setGravity(17);
            this.foc = new TextView(this.fgJ.getPageContext().getPageActivity());
            this.foc.setGravity(3);
            this.foc.setMaxLines(2);
            this.foc.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            this.foc.setPadding(0, 0, 0, 0);
            this.foc.setLineSpacing(com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.ak.h(this.foc, d.C0126d.cp_cont_b);
            this.foc.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.foc.setVisibility(8);
            if (this.foc.getParent() == null) {
                this.fob.addView(this.foc);
            }
            this.fob.setOnTouchListener(this.aWx);
            this.fob.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZS() {
        if (this.fgJ.aXl()) {
            this.fnY = (ViewStub) this.fgJ.findViewById(d.g.manga_mention_controller_view_stub);
            this.fnY.setVisibility(0);
            if (this.foA == null) {
                this.foA = (LinearLayout) this.fgJ.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fgJ.getPageContext(), this.foA);
            }
            if (this.foB == null) {
                this.foB = (TextView) this.foA.findViewById(d.g.manga_prev_btn);
            }
            if (this.foC == null) {
                this.foC = (TextView) this.foA.findViewById(d.g.manga_next_btn);
            }
            this.foB.setOnClickListener(this.cYQ);
            this.foC.setOnClickListener(this.cYQ);
        }
    }

    private void aZT() {
        if (this.fgJ.aXl()) {
            if (this.fgJ.aXo() == -1) {
                com.baidu.tbadk.core.util.ak.c(this.foB, d.C0126d.cp_cont_e, 1);
            }
            if (this.fgJ.aXp() == -1) {
                com.baidu.tbadk.core.util.ak.c(this.foC, d.C0126d.cp_cont_e, 1);
            }
        }
    }

    public void aZU() {
        if (this.foA == null) {
            aZS();
        }
        this.fnY.setVisibility(8);
        if (this.fqr != null && this.fqs != null) {
            this.fqr.removeCallbacks(this.fqs);
        }
    }

    public void aZV() {
        if (this.fqr != null) {
            if (this.fqs != null) {
                this.fqr.removeCallbacks(this.fqs);
            }
            this.fqs = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.this.foA == null) {
                        as.this.aZS();
                    }
                    as.this.fnY.setVisibility(0);
                }
            };
            this.fqr.postDelayed(this.fqs, 2000L);
        }
    }

    public void ke(boolean z) {
        this.fnV.ke(z);
        if (z && this.fpr) {
            this.dbz.setText(this.fgJ.getResources().getString(d.k.click_load_more));
            this.fnZ.setNextPage(this.dbz);
            this.fnU = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
        this.JS.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.JS.getParent() == null) {
            this.cHA.addView(this.JS, layoutParams);
        }
        this.JS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aZF();
        this.fgJ.aWJ().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.as.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (as.this.JS != null && as.this.JS.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (as.this.fqf == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, as.this.JS.getId());
                            as.this.fqf = new com.baidu.tieba.pb.pb.main.emotion.c(as.this.fgJ.getPageContext(), as.this.cHA, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.w(as.this.fqe)) {
                                as.this.fqf.setData(as.this.fqe);
                            }
                            as.this.fqf.b(as.this.JS);
                        }
                        as.this.fqf.qJ(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (as.this.fgJ.feQ != null && as.this.fgJ.feQ.baQ() != null) {
                    if (!as.this.fgJ.feQ.baQ().bAX()) {
                        as.this.fgJ.feQ.kr(false);
                    }
                    as.this.fgJ.feQ.baQ().nj(false);
                }
            }
        });
    }

    public void aZW() {
        if (this.fgJ != null && this.JS != null) {
            this.JS.lN();
            baA();
        }
    }

    public void M(String str, boolean z) {
        this.fpn = z;
        kf(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kf(boolean z) {
        if (this.fpl != null) {
            if (this.fpn) {
                com.baidu.tbadk.core.util.ak.i(this.fpl, d.f.pb_praise_already_click_selector);
                this.fpl.setContentDescription(this.fgJ.getResources().getString(d.k.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ak.i(this.fpl, d.f.pb_praise_normal_click_selector);
            this.fpl.setContentDescription(this.fgJ.getResources().getString(d.k.zan));
        }
    }

    public TextView aZX() {
        return this.fpl;
    }

    public void kg(boolean z) {
        if (this.fnZ != null && this.aza != null && this.cZd != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cZd.setVisibility(0);
                } else {
                    this.cZd.setVisibility(8);
                    this.fnZ.removeHeaderView(this.aza);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aza.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fpD;
                    this.aza.setLayoutParams(layoutParams);
                }
                bal();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aza.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + ko(true);
                this.aza.setLayoutParams(layoutParams2);
            }
            bal();
            baI();
        }
    }

    public f aZY() {
        return this.foH;
    }

    public void a(PbActivity.d dVar) {
        this.ffO = dVar;
    }

    public void be(View view2) {
        SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.foQ == null) {
            this.foQ = LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
        }
        this.fgJ.getLayoutMode().u(this.foQ);
        if (this.foP == null) {
            this.foP = new Dialog(this.fgJ.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.foP.setCanceledOnTouchOutside(true);
            this.foP.setCancelable(true);
            this.foP.setContentView(this.foQ);
            WindowManager.LayoutParams attributes = this.foP.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.af(this.fgJ.getPageContext().getPageActivity()) * 0.9d);
            this.foP.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.foP.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.foP.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.foP.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (as.this.foP != null && (as.this.foP instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.foP, as.this.fgJ.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view2.getTag();
                    if (sparseArray5 != null) {
                        as.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || baH()) {
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
                public void onClick(View view2) {
                    if (as.this.foP != null && (as.this.foP instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.foP, as.this.fgJ.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view2.getTag();
                    if (sparseArray6 != null && as.this.fqu != null) {
                        as.this.fqu.f(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
            sparseArray6.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray6.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray6.put(d.g.tag_user_mute_msg, sparseArray.get(d.g.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (as.this.foP != null && (as.this.foP instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.foP, as.this.fgJ.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view2.getTag();
                    if (sparseArray7 != null) {
                        as.this.fgJ.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.foP, this.fgJ.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fqu = bVar;
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
        sparseArray.put(fpK, Integer.valueOf(fpL));
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
        this.foR = new com.baidu.tbadk.core.dialog.a(this.fgJ.getActivity());
        if (StringUtils.isNull(str2)) {
            this.foR.bZ(i3);
        } else {
            this.foR.aw(false);
            this.foR.dc(str2);
        }
        this.foR.z(sparseArray);
        this.foR.a(d.k.dialog_ok, this.fgJ);
        this.foR.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.foR.ar(true);
        this.foR.b(this.fgJ.getPageContext());
        this.foR.tD();
    }

    public void ao(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.foU == null) {
            this.foU = LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.commit_good, (ViewGroup) null);
        }
        this.fgJ.getLayoutMode().u(this.foU);
        if (this.foT == null) {
            this.foT = new Dialog(this.fgJ.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.foT.setCanceledOnTouchOutside(true);
            this.foT.setCancelable(true);
            this.fpe = (ScrollView) this.foU.findViewById(d.g.good_scroll);
            this.foT.setContentView(this.foU);
            WindowManager.LayoutParams attributes = this.foT.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds540);
            this.foT.getWindow().setAttributes(attributes);
            this.cra = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.as.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        as.this.foZ = (String) compoundButton.getTag();
                        if (as.this.cqZ != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : as.this.cqZ) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && as.this.foZ != null && !str.equals(as.this.foZ)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.foV = (LinearLayout) this.foU.findViewById(d.g.good_class_group);
            this.foX = (TextView) this.foU.findViewById(d.g.dialog_button_cancel);
            this.foX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (as.this.foT instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(as.this.foT, as.this.fgJ.getPageContext());
                    }
                }
            });
            this.foW = (TextView) this.foU.findViewById(d.g.dialog_button_ok);
            this.foW.setOnClickListener(this.cYQ);
        }
        this.foV.removeAllViews();
        this.cqZ = new ArrayList();
        CustomBlueCheckRadioButton bI = bI("0", this.fgJ.getPageContext().getString(d.k.thread_good_class));
        this.cqZ.add(bI);
        bI.setChecked(true);
        this.foV.addView(bI);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i2);
                if (abVar != null && !TextUtils.isEmpty(abVar.qK()) && abVar.qL() > 0) {
                    CustomBlueCheckRadioButton bI2 = bI(String.valueOf(abVar.qL()), abVar.qK());
                    this.cqZ.add(bI2);
                    View view2 = new View(this.fgJ.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.ak.j(view2, d.C0126d.cp_bg_line_a);
                    view2.setLayoutParams(layoutParams);
                    this.foV.addView(view2);
                    this.foV.addView(bI2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fpe.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fgJ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fgJ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fgJ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fpe.setLayoutParams(layoutParams2);
            this.fpe.removeAllViews();
            if (this.foV != null && this.foV.getParent() == null) {
                this.fpe.addView(this.foV);
            }
        }
        com.baidu.adp.lib.g.g.a(this.foT, this.fgJ.getPageContext());
    }

    private CustomBlueCheckRadioButton bI(String str, String str2) {
        Activity pageActivity = this.fgJ.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cra);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void aZZ() {
        this.fgJ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fgJ.hideProgressBar();
        if (z && z2) {
            this.fgJ.showToast(this.fgJ.getPageContext().getString(d.k.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.an.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.k.neterror);
            }
            this.fgJ.showToast(str);
        }
    }

    public void aFf() {
        this.foN.setVisibility(0);
    }

    public void aFe() {
        this.foN.setVisibility(8);
    }

    public View baa() {
        if (this.foU != null) {
            return this.foU.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bab() {
        return this.foZ;
    }

    public View getView() {
        return this.cHA;
    }

    public void bac() {
        com.baidu.adp.lib.util.l.b(this.fgJ.getPageContext().getPageActivity(), this.fgJ.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fgJ.hideProgressBar();
        if (z) {
            bar();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bas();
        } else {
            bar();
        }
    }

    public void bad() {
        this.dbz.wN();
        this.dbz.wR();
    }

    public void bae() {
        this.fgJ.hideProgressBar();
        wS();
        this.fnZ.completePullRefreshPostDelayed(2000L);
        bao();
    }

    public void baf() {
        this.fnZ.completePullRefreshPostDelayed(2000L);
        bao();
    }

    private void kh(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fpi.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fgJ.getResources().getDimensionPixelSize(d.e.ds130) : this.fgJ.getResources().getDimensionPixelSize(d.e.ds34);
        this.fpi.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.foH.setOnLongClickListener(onLongClickListener);
        if (this.fqg != null) {
            this.fqg.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0086b interfaceC0086b, boolean z, boolean z2) {
        if (this.fpa != null) {
            this.fpa.dismiss();
            this.fpa = null;
        }
        this.fpa = new com.baidu.tbadk.core.dialog.b(this.fgJ.getPageContext().getPageActivity());
        this.fpa.cc(d.k.operation);
        if (z2) {
            this.fpa.a(new String[]{this.fgJ.getPageContext().getString(d.k.copy)}, interfaceC0086b);
        } else if (!z) {
            this.fpa.a(new String[]{this.fgJ.getPageContext().getString(d.k.copy), this.fgJ.getPageContext().getString(d.k.mark)}, interfaceC0086b);
        } else {
            this.fpa.a(new String[]{this.fgJ.getPageContext().getString(d.k.copy), this.fgJ.getPageContext().getString(d.k.remove_mark)}, interfaceC0086b);
        }
        this.fpa.d(this.fgJ.getPageContext());
        this.fpa.tG();
    }

    public void a(b.InterfaceC0086b interfaceC0086b, boolean z) {
        if (this.fpb != null) {
            this.fpb.dismiss();
            this.fpb = null;
        }
        this.fpb = new com.baidu.tbadk.core.dialog.b(this.fgJ.getPageContext().getPageActivity());
        this.fpb.cc(d.k.operation);
        if (z) {
            this.fpb.a(new String[]{this.fgJ.getPageContext().getString(d.k.save_to_emotion)}, interfaceC0086b);
        } else {
            this.fpb.a(new String[]{this.fgJ.getPageContext().getString(d.k.save_to_emotion), this.fgJ.getPageContext().getString(d.k.save_to_local)}, interfaceC0086b);
        }
        this.fpb.d(this.fgJ.getPageContext());
        this.fpb.tG();
    }

    public int bag() {
        return qx(this.fnZ.getFirstVisiblePosition());
    }

    private int qx(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fnZ.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fnZ.getAdapter() == null || !(this.fnZ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fnZ.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bah() {
        int lastVisiblePosition = this.fnZ.getLastVisiblePosition();
        if (this.fnP != null) {
            if (lastVisiblePosition == this.fnZ.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return qx(lastVisiblePosition);
    }

    public void qy(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fnZ != null) {
            if (this.fnV == null || this.fnV.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fnV.mNavigationBar.getFixedNavHeight();
                if (this.fgJ.aWZ() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fpB != null && (layoutParams = (LinearLayout.LayoutParams) this.fpB.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fpB.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fnZ.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fnZ.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.foK.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.foH.a(dVar, false);
        this.foH.notifyDataSetChanged();
        bao();
        if (this.fqg != null) {
            this.fqg.aWt();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fop == null) {
            this.fgJ.getLayoutMode().u(((ViewStub) this.foa.findViewById(d.g.praise_layout)).inflate());
            this.fop = (FrsPraiseView) this.foa.findViewById(d.g.pb_head_praise_view);
            this.fop.setIsFromPb(true);
            this.foF = this.foa.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fop.dz(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fop != null) {
            boolean bao = bao();
            this.fop.setVisibility(8);
            if (dVar != null && dVar.rg() != null && dVar.rg().rd() == 0 && this.fha) {
                if (bao) {
                    this.foE.setVisibility(0);
                    return;
                } else {
                    this.foE.setVisibility(8);
                    return;
                }
            }
            this.foE.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.aVC() != null) {
            return dVar.aVC();
        }
        if (!com.baidu.tbadk.core.util.v.w(dVar.aVu())) {
            Iterator<PostData> it = dVar.aVu().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.brZ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.aVz();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.rQ() != null && postData.rQ().getUserTbVipInfoData() != null && postData.rQ().getUserTbVipInfoData().getvipIntro() != null) {
            postData.rQ().getGodUserData().setIntro(postData.rQ().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.aVs() == null || dVar.aVs().rQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rQ = dVar.aVs().rQ();
        String userId = rQ.getUserId();
        HashMap<String, MetaData> userMap = dVar.aVs().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rQ;
        }
        postData.to(1);
        postData.setId(dVar.aVs().sg());
        postData.setTitle(dVar.aVs().getTitle());
        postData.setTime(dVar.aVs().getCreateTime());
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
        com.baidu.tbadk.data.f bsc;
        String portrait;
        if (dVar != null && dVar.aVs() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fof.setVisibility(8);
            if (dVar.aVs() != null && dVar.aVs().sB() && dVar.aVs().sh() != null) {
                this.fpV = true;
                this.fnV.kD(this.fpV);
                this.fnV.mNavigationBar.hideBottomLine();
                if (this.fnP == null) {
                    this.fnP = new com.baidu.tieba.pb.video.i(this.fgJ, this.fnV, dVar.aVs().sh(), this.fnQ);
                    this.fnP.a(dVar.aVs().sh(), dVar.aVs(), dVar.getForumId());
                    this.fnP.startPlay();
                } else if (this.fnT) {
                    this.fnP.a(dVar.aVs().sh(), dVar.aVs(), dVar.getForumId());
                    this.fnP.startPlay();
                } else {
                    this.fnP.qT(dVar.getForumId());
                }
                if (dVar.aVt() != null && dVar.aVt().size() >= 1) {
                    bd bdVar = dVar.aVt().get(0);
                    this.fnP.aj(bdVar);
                    this.fnP.qU(bdVar.getTitle());
                }
                this.fnP.b(b, dVar.aVs(), dVar.aVO());
                this.fnT = false;
                this.fnZ.removeHeaderView(this.fnP.bcy());
                this.fnZ.addHeaderView(this.fnP.bcy(), 0);
                if (this.fnP.bcw() != null && this.fnP.bcw().getParent() == null) {
                    this.fpz.addView(this.fnP.bcw());
                }
                if (this.fnR == null) {
                    this.fnR = new com.baidu.tieba.pb.video.h(this.fgJ);
                }
                this.fnR.a(dVar.aVs().sQ(), dVar.aVs(), dVar.aVL());
                this.fnZ.removeHeaderView(this.fnR.bcn());
                this.fnZ.addHeaderView(this.fnR.bcn(), 1);
                if (dVar.aVs().sQ() != null) {
                    this.fnZ.removeHeaderView(this.fnR.bco());
                    this.fnZ.removeHeaderView(this.fod);
                    this.fnZ.addHeaderView(this.fnR.bco(), 2);
                } else {
                    if (this.fnR.bco() != null) {
                        this.fnZ.removeHeaderView(this.fnR.bco());
                    }
                    this.fnZ.removeHeaderView(this.fod);
                    this.fod.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.fgJ, d.e.tbds56));
                    this.fnZ.addHeaderView(this.fod, 2);
                }
                if (this.fnP != null) {
                    this.fnV.kx(false);
                    this.fnV.kz(TbadkCoreApplication.isLogin());
                    this.fnP.qF(TbadkCoreApplication.getInst().getSkinType());
                }
                bal();
            } else {
                this.fpV = false;
                this.fnV.kD(this.fpV);
                if (this.fnP != null) {
                    this.fnZ.removeHeaderView(this.fnP.bcy());
                }
                if (this.fnR != null) {
                    this.fnR.b(this.fnZ);
                }
                if (b == null || (b != null && (b.bsb() == null || com.baidu.tbadk.core.util.v.w(b.bsb().JJ())))) {
                    this.fod.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.fgJ, d.e.tbds80));
                } else {
                    this.fod.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fgJ.aWN() != null) {
                this.fgJ.aWN().kv(this.fpV);
            }
            if (this.fnP != null) {
                this.fnP.J(this.fqw);
            }
            if (b != null) {
                this.fpq = b;
                this.fof.setVisibility(0);
                if (this.fgJ.aXy()) {
                    if (dVar.aVr() != null) {
                        this.mForumName = dVar.aVr().getForumName();
                        this.mForumId = dVar.aVr().getForumId();
                    }
                    if (this.mForumName == null && this.fgJ.aWx() != null && this.fgJ.aWx().aYi() != null) {
                        this.mForumName = this.fgJ.aWx().aYi();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fof.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fof.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fql) {
                    this.fob.setVisibility(0);
                }
                if (!dVar.aVs().sB() && this.foc.getText() != null && this.foc.getText().length() > 0) {
                    this.foc.setVisibility(0);
                } else {
                    this.foc.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> sb = dVar.aVs().sb();
                if (sb != null && sb.size() > 0 && !this.fql) {
                    this.fpu.setText(String.valueOf(sb.get(0).qq()));
                    this.fpt.setVisibility(0);
                } else {
                    this.fpt.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ak.i(this.fpt, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.ak.c(this.fpu, d.C0126d.cp_link_tip_d, 1);
                if (b.rQ() != null) {
                    String string = b.rQ().getName_show() == null ? StringUtils.string(b.rQ().getUserName()) : StringUtils.string(b.rQ().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.rQ().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.aU(b.rQ().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aU(string) > 12) {
                            e = com.baidu.tbadk.core.util.an.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.rQ().getIconInfo();
                            tShowInfoNew = b.rQ().getTShowInfoNew();
                            if (this.fib != null) {
                                this.fib.setTag(d.g.tag_user_id, b.rQ().getUserId());
                                this.fib.setOnClickListener(this.fgJ.feM.fsi);
                                this.fib.a(iconInfo, 4, this.fgJ.getResources().getDimensionPixelSize(d.e.tbds36), this.fgJ.getResources().getDimensionPixelSize(d.e.tbds36), this.fgJ.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fia != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fia.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fia.setOnClickListener(this.fgJ.feM.fsj);
                                this.fia.a(tShowInfoNew, 3, this.fgJ.getResources().getDimensionPixelSize(d.e.tbds36), this.fgJ.getResources().getDimensionPixelSize(d.e.tbds36), this.fgJ.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.foh.setText(ag(b.rQ().getSealPrefix(), e));
                            this.foh.setTag(d.g.tag_user_id, b.rQ().getUserId());
                            this.foh.setTag(d.g.tag_user_name, b.rQ().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew) || b.rQ().isBigV()) {
                                com.baidu.tbadk.core.util.ak.c(this.foh, d.C0126d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.ak.c(this.foh, d.C0126d.cp_cont_f, 1);
                            }
                            this.foi.setVisibility(8);
                            if (dVar.aVs().rQ() != null && dVar.aVs().rQ().getAlaUserData() != null && this.fon != null) {
                                if (dVar.aVs().rQ().getAlaUserData().anchor_live != 0) {
                                    this.fon.setVisibility(8);
                                } else {
                                    this.fon.setVisibility(0);
                                    if (this.fnS == null) {
                                        this.fnS = new com.baidu.tieba.d.c(this.fgJ.getPageContext(), this.fon);
                                        this.fnS.jf(1);
                                    }
                                    this.fnS.aJ(this.fgJ.getResources().getString(d.k.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Se = dVar.aVs().rQ().getAlaUserData();
                                    aVar.type = 2;
                                    this.fon.setTag(aVar);
                                }
                            }
                            this.fom.setUserId(b.rQ().getUserId());
                            this.fom.setUserName(b.rQ().getUserName());
                            this.fom.setImageDrawable(null);
                            this.fom.setRadius(com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds40));
                            this.fom.setTag(b.rQ().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fow.setText(com.baidu.tbadk.core.util.an.t(b.getTime()));
                            } else {
                                this.fow.setText(com.baidu.tbadk.core.util.an.s(b.getTime()));
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds16);
                            if (!this.fgJ.aXy() && !StringUtils.isNull(this.mForumName)) {
                                this.apF.setText(this.fgJ.getString(d.k.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.apF.setVisibility(0);
                                this.foz.setVisibility(0);
                                this.fow.setPadding(e2, 0, e2, 0);
                            } else {
                                this.apF.setVisibility(8);
                                this.foz.setVisibility(8);
                                this.fow.setPadding(0, 0, e2, 0);
                            }
                            bsc = b.bsc();
                            if (bsc == null && !TextUtils.isEmpty(bsc.getName()) && !TextUtils.isEmpty(bsc.getName().trim())) {
                                final String name = bsc.getName();
                                final String lat = bsc.getLat();
                                final String lng = bsc.getLng();
                                this.fox.setVisibility(0);
                                this.foy.setVisibility(0);
                                this.fox.setText(bsc.getName());
                                this.fox.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.gP()) {
                                                as.this.fgJ.showToast(d.k.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.M(as.this.fgJ.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, as.this.fgJ.getPageContext().getString(d.k.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fox.setVisibility(8);
                                this.foy.setVisibility(8);
                            }
                            portrait = b.rQ().getPortrait();
                            if (b.rQ().getPendantData() == null && !StringUtils.isNull(b.rQ().getPendantData().qG())) {
                                UtilHelper.showHeadImageViewBigV(this.fok.getHeadView(), b.rQ());
                                this.fom.setVisibility(8);
                                this.fok.setVisibility(0);
                                if (this.foq != null) {
                                    this.foq.setVisibility(8);
                                }
                                this.foh.setOnClickListener(this.fqw);
                                this.fok.getHeadView().startLoad(portrait, 28, false);
                                this.fok.getHeadView().setUserId(b.rQ().getUserId());
                                this.fok.getHeadView().setUserName(b.rQ().getUserName());
                                this.fok.getHeadView().setOnClickListener(this.fqw);
                                this.fok.eK(b.rQ().getPendantData().qG());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fom, b.rQ());
                                this.fom.setVisibility(0);
                                this.fof.setOnClickListener(this.fqw);
                                this.foh.setOnClickListener(this.fqw);
                                this.fom.setOnClickListener(this.fqw);
                                this.fok.setVisibility(8);
                                this.fom.startLoad(portrait, 28, false);
                            }
                            String name_show = b.rQ().getName_show();
                            String userName = b.rQ().getUserName();
                            if (com.baidu.tbadk.o.af.fz() && name_show != null && !name_show.equals(userName)) {
                                this.foh.setText(com.baidu.tieba.pb.c.ah(this.fgJ.getPageContext().getPageActivity(), this.foh.getText().toString()));
                                this.foh.setGravity(16);
                                this.foh.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                                com.baidu.tbadk.core.util.ak.c(this.foh, d.C0126d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.rQ().getIconInfo();
                        tShowInfoNew = b.rQ().getTShowInfoNew();
                        if (this.fib != null) {
                        }
                        if (this.fia != null) {
                        }
                        this.foh.setText(ag(b.rQ().getSealPrefix(), e));
                        this.foh.setTag(d.g.tag_user_id, b.rQ().getUserId());
                        this.foh.setTag(d.g.tag_user_name, b.rQ().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ak.c(this.foh, d.C0126d.cp_cont_h, 1);
                        this.foi.setVisibility(8);
                        if (dVar.aVs().rQ() != null) {
                            if (dVar.aVs().rQ().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fom.setUserId(b.rQ().getUserId());
                        this.fom.setUserName(b.rQ().getUserName());
                        this.fom.setImageDrawable(null);
                        this.fom.setRadius(com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds40));
                        this.fom.setTag(b.rQ().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds16);
                        if (!this.fgJ.aXy()) {
                        }
                        this.apF.setVisibility(8);
                        this.foz.setVisibility(8);
                        this.fow.setPadding(0, 0, e2, 0);
                        bsc = b.bsc();
                        if (bsc == null) {
                        }
                        this.fox.setVisibility(8);
                        this.foy.setVisibility(8);
                        portrait = b.rQ().getPortrait();
                        if (b.rQ().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fom, b.rQ());
                        this.fom.setVisibility(0);
                        this.fof.setOnClickListener(this.fqw);
                        this.foh.setOnClickListener(this.fqw);
                        this.fom.setOnClickListener(this.fqw);
                        this.fok.setVisibility(8);
                        this.fom.startLoad(portrait, 28, false);
                        String name_show2 = b.rQ().getName_show();
                        String userName2 = b.rQ().getUserName();
                        if (com.baidu.tbadk.o.af.fz()) {
                            this.foh.setText(com.baidu.tieba.pb.c.ah(this.fgJ.getPageContext().getPageActivity(), this.foh.getText().toString()));
                            this.foh.setGravity(16);
                            this.foh.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                            com.baidu.tbadk.core.util.ak.c(this.foh, d.C0126d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aU(string) > 14) {
                            e = com.baidu.tbadk.core.util.an.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.rQ().getIconInfo();
                            tShowInfoNew = b.rQ().getTShowInfoNew();
                            if (this.fib != null) {
                            }
                            if (this.fia != null) {
                            }
                            this.foh.setText(ag(b.rQ().getSealPrefix(), e));
                            this.foh.setTag(d.g.tag_user_id, b.rQ().getUserId());
                            this.foh.setTag(d.g.tag_user_name, b.rQ().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.ak.c(this.foh, d.C0126d.cp_cont_h, 1);
                            this.foi.setVisibility(8);
                            if (dVar.aVs().rQ() != null) {
                            }
                            this.fom.setUserId(b.rQ().getUserId());
                            this.fom.setUserName(b.rQ().getUserName());
                            this.fom.setImageDrawable(null);
                            this.fom.setRadius(com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds40));
                            this.fom.setTag(b.rQ().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds16);
                            if (!this.fgJ.aXy()) {
                            }
                            this.apF.setVisibility(8);
                            this.foz.setVisibility(8);
                            this.fow.setPadding(0, 0, e2, 0);
                            bsc = b.bsc();
                            if (bsc == null) {
                            }
                            this.fox.setVisibility(8);
                            this.foy.setVisibility(8);
                            portrait = b.rQ().getPortrait();
                            if (b.rQ().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fom, b.rQ());
                            this.fom.setVisibility(0);
                            this.fof.setOnClickListener(this.fqw);
                            this.foh.setOnClickListener(this.fqw);
                            this.fom.setOnClickListener(this.fqw);
                            this.fok.setVisibility(8);
                            this.fom.startLoad(portrait, 28, false);
                            String name_show22 = b.rQ().getName_show();
                            String userName22 = b.rQ().getUserName();
                            if (com.baidu.tbadk.o.af.fz()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.rQ().getIconInfo();
                        tShowInfoNew = b.rQ().getTShowInfoNew();
                        if (this.fib != null) {
                        }
                        if (this.fia != null) {
                        }
                        this.foh.setText(ag(b.rQ().getSealPrefix(), e));
                        this.foh.setTag(d.g.tag_user_id, b.rQ().getUserId());
                        this.foh.setTag(d.g.tag_user_name, b.rQ().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ak.c(this.foh, d.C0126d.cp_cont_h, 1);
                        this.foi.setVisibility(8);
                        if (dVar.aVs().rQ() != null) {
                        }
                        this.fom.setUserId(b.rQ().getUserId());
                        this.fom.setUserName(b.rQ().getUserName());
                        this.fom.setImageDrawable(null);
                        this.fom.setRadius(com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds40));
                        this.fom.setTag(b.rQ().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.fgJ.getActivity(), d.e.ds16);
                        if (!this.fgJ.aXy()) {
                        }
                        this.apF.setVisibility(8);
                        this.foz.setVisibility(8);
                        this.fow.setPadding(0, 0, e2, 0);
                        bsc = b.bsc();
                        if (bsc == null) {
                        }
                        this.fox.setVisibility(8);
                        this.foy.setVisibility(8);
                        portrait = b.rQ().getPortrait();
                        if (b.rQ().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fom, b.rQ());
                        this.fom.setVisibility(0);
                        this.fof.setOnClickListener(this.fqw);
                        this.foh.setOnClickListener(this.fqw);
                        this.fom.setOnClickListener(this.fqw);
                        this.fok.setVisibility(8);
                        this.fom.startLoad(portrait, 28, false);
                        String name_show222 = b.rQ().getName_show();
                        String userName222 = b.rQ().getUserName();
                        if (com.baidu.tbadk.o.af.fz()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.foe.ab(dVar.aVs());
                }
                if (this.fpC != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fcy);
                    if (dVar != null && dVar.aVs() != null) {
                        hVar.fcA = dVar.aVs().rI();
                    }
                    hVar.isNew = !this.fha;
                    hVar.fcC = this.fgJ.aXx();
                    this.fpC.a(hVar);
                }
            }
        }
    }

    public void ki(boolean z) {
        if (z) {
            bai();
        } else {
            akW();
        }
        this.fpG.fqN = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fpG));
        a(this.fpG.fqN, false);
    }

    public void bai() {
        if (this.fnV != null && !this.fpX) {
            this.fnV.kE(!StringUtils.isNull(this.fgJ.aWW()));
            this.fpX = true;
        }
    }

    public void akW() {
        if (this.fnV != null) {
            this.fnV.bbm();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.sk() != null) {
            this.fog.setData(this.fgJ.getPageContext(), dVar.aVu().get(0).sk(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.aVq().getId(), dVar.aVq().getName(), dVar.aVs().getId(), this.fgJ.aXu() ? "FRS" : null));
            this.fof.setPadding(this.fof.getPaddingLeft(), (int) this.fgJ.getResources().getDimension(d.e.ds20), this.fof.getPaddingRight(), this.fof.getPaddingBottom());
            return;
        }
        this.fog.setData(null, null, null);
    }

    public void baj() {
        if (this.fnP != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11997").r("obj_type", 1));
            this.fnP.bcx();
            this.fnZ.smoothScrollToPosition(0);
        }
    }

    public boolean bak() {
        return this.fqx;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean ad(bd bdVar) {
        if (bdVar == null || bdVar.rQ() == null || bdVar.rQ().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rQ().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fnV.bbk();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fnV.oq(cVar.forumName);
            }
            String string = this.fgJ.getResources().getString(d.k.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(cVar.source, 0)) {
                case 100:
                    str = this.fgJ.getResources().getString(d.k.self);
                    break;
                case 300:
                    str = this.fgJ.getResources().getString(d.k.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fgJ.getResources().getString(d.k.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fbK;
            this.fgJ.showNetRefreshView(this.cHA, format, null, this.fgJ.getResources().getString(d.k.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.adp.lib.util.l.hg()) {
                        com.baidu.tbadk.core.util.ax.wg().c(as.this.fgJ.getPageContext(), new String[]{str2});
                        as.this.fgJ.finish();
                        return;
                    }
                    as.this.fgJ.showToast(d.k.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aZs;
        Parcelable aZs2;
        String str;
        if (dVar != null) {
            this.fkk = dVar;
            this.mType = i;
            if (dVar.aVs() != null) {
                this.fpI = dVar.aVs().rC();
                if (dVar.aVs().getAnchorLevel() != 0) {
                    this.fqx = true;
                }
                this.fpd = ad(dVar.aVs());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fpr = false;
            this.fha = z;
            bae();
            b(dVar, z, i);
            p(dVar);
            if (this.fqj == null) {
                this.fqj = new ab(this.fgJ.getPageContext(), this.dqU);
            }
            this.fqj.qB(dVar.aVx());
            if (this.fgJ.aXl()) {
                if (this.foL == null) {
                    this.foL = new com.baidu.tieba.pb.view.e(this.fgJ.getPageContext());
                    this.foL.kA();
                    this.foL.a(this.anZ);
                }
                this.fnZ.setPullRefresh(this.foL);
                bal();
                if (this.foL != null) {
                    this.foL.dv(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.rg().rd() == 0 && z) {
                this.fnZ.setPullRefresh(null);
            } else {
                if (this.foL == null) {
                    this.foL = new com.baidu.tieba.pb.view.e(this.fgJ.getPageContext());
                    this.foL.kA();
                    this.foL.a(this.anZ);
                }
                this.fnZ.setPullRefresh(this.foL);
                bal();
                if (this.foL != null) {
                    this.foL.dv(TbadkCoreApplication.getInst().getSkinType());
                }
                aas();
            }
            bao();
            this.foH.jr(this.fha);
            this.foH.js(false);
            this.foH.jD(i == 5);
            this.foH.jE(i == 6);
            this.foH.jF(z2 && this.fqv);
            this.foH.a(dVar, false);
            this.foH.notifyDataSetChanged();
            if (this.fgJ.aXy()) {
                this.fpZ = 0;
                PostData b = b(dVar, z);
                if (b != null && b.rQ() != null) {
                    this.fpZ = b.rQ().getLevel_id();
                }
                if (this.fpZ > 0) {
                    this.foj.setVisibility(0);
                    com.baidu.tbadk.core.util.ak.c(this.foj, BitmapHelper.getGradeResourceIdInEnterForum(this.fpZ));
                } else {
                    this.foj.setVisibility(8);
                }
            } else {
                this.foj.setVisibility(8);
            }
            if (dVar.aVs() != null) {
                if (dVar.aVs().rF() != null) {
                    if (dVar.aVs().rF().getNum() < 1) {
                        str = this.fgJ.getResources().getString(d.k.zan);
                    } else {
                        str = dVar.aVs().rF().getNum() + "";
                    }
                    if (this.fnO != -1) {
                        dVar.aVs().rF().setIsLike(this.fnO);
                    }
                    M(str, dVar.aVs().rF().getIsLike() == 1);
                }
                if (dVar.aVs().abL != null && dVar.aVs().abL.isDeleted) {
                    this.fnV.ky(true);
                } else {
                    this.fnV.ky(false);
                }
            }
            if (this.fgJ.isLogin()) {
                this.fnZ.setNextPage(this.dbz);
                this.fnU = 2;
                aas();
            } else {
                this.fpr = true;
                if (dVar.rg().rc() == 1) {
                    if (this.foM == null) {
                        this.foM = new com.baidu.tieba.pb.view.a(this.fgJ.getPageContext());
                    }
                    this.fnZ.setNextPage(this.foM);
                } else {
                    this.fnZ.setNextPage(this.dbz);
                }
                this.fnU = 3;
            }
            ArrayList<PostData> aVu = dVar.aVu();
            if (dVar.rg().rc() == 0 || aVu == null || aVu.size() < dVar.rg().rb()) {
                if (com.baidu.tbadk.core.util.v.v(aVu) == 0 || (com.baidu.tbadk.core.util.v.v(aVu) == 1 && aVu.get(0) != null && aVu.get(0).brZ() == 1)) {
                    this.dbz.setText(this.fgJ.getResources().getString(d.k.list_no_more_new));
                    if (this.fgJ.aWN() != null && !this.fgJ.aWN().bba()) {
                        this.fgJ.aWN().showFloatingView();
                    }
                } else {
                    this.dbz.setText(this.fgJ.getResources().getString(d.k.list_has_no_more));
                }
                if (this.fgJ.aXl() && this.fnZ != null && this.fnZ.getData() != null && this.fnZ.getData().size() == 1 && (this.fnZ.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dbz.setText("");
                }
                bav();
            } else if (z2) {
                if (this.fqv) {
                    wS();
                    if (dVar.rg().rc() != 0) {
                        this.dbz.setText(this.fgJ.getResources().getString(d.k.pb_load_more));
                    }
                } else {
                    this.dbz.wN();
                    this.dbz.showLoading();
                }
            } else {
                this.dbz.wN();
                this.dbz.showLoading();
            }
            switch (i) {
                case 2:
                    this.fnZ.setSelection(i2 > 1 ? (((this.fnZ.getData() == null && dVar.aVu() == null) ? 0 : (this.fnZ.getData().size() - dVar.aVu().size()) + this.fnZ.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aZs2 = ai.aZr().aZs()) != null) {
                        this.fnZ.onRestoreInstanceState(aZs2);
                        if (com.baidu.tbadk.core.util.v.v(aVu) > 1 && dVar.rg().rc() > 0) {
                            this.dbz.wS();
                            this.dbz.setText(this.fgJ.getString(d.k.pb_load_more_without_point));
                            this.dbz.wO();
                            break;
                        }
                    } else {
                        this.fnZ.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fqv = false;
                    break;
                case 5:
                    this.fnZ.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aZs = ai.aZr().aZs()) != null) {
                        this.fnZ.onRestoreInstanceState(aZs);
                        break;
                    } else {
                        this.fnZ.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fnP != null && this.fnP.bcw() != null) {
                            if (this.fgJ.isUseStyleImmersiveSticky()) {
                                this.fnZ.setSelectionFromTop((this.foH.aXN() + this.fnZ.getHeaderViewsCount()) - 1, this.fnP.bcw().getHeight() - com.baidu.adp.lib.util.l.p(this.fgJ.getPageContext().getPageActivity()));
                            } else {
                                this.fnZ.setSelectionFromTop((this.foH.aXN() + this.fnZ.getHeaderViewsCount()) - 1, this.fnP.bcw().getHeight());
                            }
                        } else {
                            this.fnZ.setSelection(this.foH.aXN() + this.fnZ.getHeaderViewsCount());
                        }
                    } else {
                        this.fnZ.setSelection(i2 > 0 ? ((this.fnZ.getData() == null && dVar.aVu() == null) ? 0 : (this.fnZ.getData().size() - dVar.aVu().size()) + this.fnZ.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dbz.wS();
                    this.dbz.setText(this.fgJ.getString(d.k.pb_load_more_without_point));
                    this.dbz.wO();
                    break;
            }
            if (this.fpI == fpJ && isHost()) {
                baD();
            }
            if (this.fpT) {
                aZD();
                this.fpT = false;
                if (i3 == 0) {
                    kb(true);
                }
            }
            if (this.fnR != null) {
                this.fnR.ai(dVar.aVs());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fcp == 1 || dVar.fcq == 1) {
                if (this.fqa == null) {
                    this.fqa = new PbTopTipView(this.fgJ);
                }
                if (dVar.fcq == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fgJ.getStType())) {
                    this.fqa.setText(this.fgJ.getString(d.k.pb_read_strategy_add_experience));
                    this.fqa.show(this.cHA, this.mSkinType);
                } else if (dVar.fcp == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fgJ.getStType())) {
                    this.fqa.setText(this.fgJ.getString(d.k.pb_read_news_add_experience));
                    this.fqa.show(this.cHA, this.mSkinType);
                }
            }
        }
    }

    private void bal() {
        if (this.fnP != null && this.fnP.bcw() != null) {
            this.fnZ.removeHeaderView(this.aza);
            if (this.mType != 1) {
                this.fnZ.removeHeaderView(this.fnP.bcy());
                this.fnZ.addHeaderView(this.fnP.bcy(), 0);
                return;
            }
            return;
        }
        if (this.fnP != null) {
            this.fnZ.removeHeaderView(this.fnP.bcy());
        }
        this.fnZ.removeHeaderView(this.aza);
        this.fnZ.addHeaderView(this.aza, 0);
    }

    public void kj(boolean z) {
        this.fpc = z;
    }

    public void wS() {
        if (this.dbz != null) {
            this.dbz.wO();
            this.dbz.wS();
        }
        aas();
    }

    public void showListView() {
        this.fnZ.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fpq != null && this.fpq.rQ() != null && this.fnV != null) {
            this.fpW = !this.fpV;
            this.fnV.kx(this.fpW);
            if (this.fgJ.aWN() != null) {
                this.fgJ.aWN().kw(this.fpW);
            }
            bam();
            if (this.fpW) {
                this.fnV.fsW.setVisibility(0);
                if (this.fpd) {
                    this.fnV.fsX.setVisibility(8);
                    this.f0for.setVisibility(8);
                    this.fov.setVisibility(0);
                    this.fov.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.an.y(dVar.aVN())));
                } else if (!PbNormalLikeButtonSwitchStatic.Hs() || (this.fpq.rQ().hadConcerned() && this.fpq.rQ().getGodUserData() != null && this.fpq.rQ().getGodUserData().getIsFromNetWork())) {
                    this.fnV.fsX.setVisibility(8);
                }
                if (this.fpB != null) {
                    this.fpB.setVisibility(8);
                }
                this.fnV.a(this.fpq.rQ(), this.fqw);
                if (this.fqh == null) {
                    this.fqh = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.as.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > as.this.fpY) {
                                as.this.baC();
                            }
                        }
                    };
                }
                this.fnZ.setListViewDragListener(this.fqh);
                return;
            }
            if (this.fnV.fsW != null) {
                this.fnV.fsW.setVisibility(8);
            }
            if (this.fpB != null) {
                this.fpB.setVisibility(0);
            }
            if (this.fpd) {
                this.f0for.setVisibility(8);
                this.fov.setVisibility(0);
                this.fov.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.an.y(dVar.aVN())));
            } else if (!PbNormalLikeButtonSwitchStatic.Hs() || (this.fpq.rQ().hadConcerned() && this.fpq.rQ().getGodUserData() != null && this.fpq.rQ().getGodUserData().getIsFromNetWork())) {
                this.f0for.setVisibility(8);
                this.fov.setVisibility(8);
            } else {
                this.fov.setVisibility(8);
            }
            this.fqh = null;
            this.fnZ.setListViewDragListener(null);
        }
    }

    private void bam() {
        String threadId = this.fkk != null ? this.fkk.getThreadId() : "";
        int ban = ban();
        if (this.fpW) {
            if (this.fou == null) {
                this.fou = new aq(this.fgJ.getPageContext(), this.fnV.fsX, 3);
                this.fou.h(this.fgJ.getUniqueId());
            }
            if (this.fpq != null && this.fpq.rQ() != null) {
                this.fpq.rQ().setIsLike(this.fpq.rQ().hadConcerned());
                this.fou.a(this.fpq.rQ());
            }
            this.fou.cJ(threadId);
            this.fou.qw(ban);
            this.fou.fnK = this.fpV;
        }
        if (this.fot == null) {
            this.fot = new aq(this.fgJ.getPageContext(), this.f0for, 1);
            this.fot.h(this.fgJ.getUniqueId());
            this.fot.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.as.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aR(boolean z) {
                    if (as.this.fgJ != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(as.this.fgJ, d.k.attention_success);
                            return;
                        }
                        ar.u(as.this.fgJ.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fpq != null && this.fpq.rQ() != null) {
            this.fpq.rQ().setIsLike(this.fpq.rQ().hadConcerned());
            this.fot.a(this.fpq.rQ());
            this.fot.cJ(threadId);
        }
        this.fot.fnK = this.fpV;
        this.fot.qw(ban);
    }

    private int ban() {
        if (this.fkk == null || this.fkk.aVs() == null) {
            return 0;
        }
        if (this.fkk.aVs().sY()) {
            return (com.baidu.tbadk.core.util.v.w(this.fkk.aVM()) && (this.fkk.aVr() == null || StringUtils.isNull(this.fkk.aVr().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bao() {
        boolean z;
        if (this.fpg != null && this.fpg.getVisibility() == 0) {
            if (this.foD != null) {
                this.foD.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.foD != null) {
                this.foD.setVisibility(8);
            }
            z = false;
        }
        if ((this.foF == null || this.foF.getVisibility() == 8) && z && this.fha) {
            this.foE.setVisibility(0);
        } else {
            this.foE.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.aVs() == null) {
            return false;
        }
        if (dVar.aVs().rN() == 1 || dVar.aVs().getThreadType() == 33) {
            return true;
        }
        return !(dVar.aVs().rP() == null || dVar.aVs().rP().tr() == 0) || dVar.aVs().rL() == 1 || dVar.aVs().rM() == 1 || dVar.aVs().st() || dVar.aVs().sF() || dVar.aVs().sA() || dVar.aVs().sc() != null || !com.baidu.tbadk.core.util.an.isEmpty(dVar.aVs().getCategory()) || dVar.aVs().rT() || dVar.aVs().rS();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fgJ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fob != null) {
                if (dVar.aVs() != null && dVar.aVs().sf() == 0 && !dVar.aVs().sB() && !this.fql) {
                    this.fob.setVisibility(0);
                    if (dVar.aVs() != null) {
                        dVar.aVs().e(true, q(dVar));
                    }
                    SpannableStringBuilder so = dVar.aVs().so();
                    this.foc.setOnTouchListener(new com.baidu.tieba.view.j(so));
                    if (this.fqi) {
                        this.foc.setText(dVar.aVs().getTitle());
                    } else {
                        this.foc.setText(so);
                    }
                    this.foc.setVisibility(0);
                } else if (dVar.aVs().sf() == 1) {
                    if (dVar.aVs() != null) {
                        this.fob.setVisibility(8);
                        this.fnZ.removeHeaderView(this.fob);
                        if (dVar.aVs() != null && !dVar.aVs().sB()) {
                            this.fof.setPadding(this.fof.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.tbds36), this.fof.getPaddingRight(), this.fof.getPaddingBottom());
                        }
                    }
                } else {
                    this.fob.setVisibility(8);
                    this.fnZ.removeHeaderView(this.fob);
                    if (dVar.aVs() != null && dVar.aVs().sB()) {
                        this.fof.setPadding(this.fof.getPaddingLeft(), 0, this.fof.getPaddingRight(), this.fof.getPaddingBottom());
                    } else {
                        this.fof.setPadding(this.fof.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds48), this.fof.getPaddingRight(), this.fof.getPaddingBottom());
                    }
                }
            }
            this.fha = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bao();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.u uVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.rQ().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.aVE()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.rQ() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.rQ().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.aVE()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<az> aVM = dVar.aVM();
                if (com.baidu.tbadk.core.util.v.v(aVM) > 0) {
                    sb = new StringBuilder();
                    for (az azVar : aVM) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ZA) != null && uVar.XE && !uVar.isDeleted && (uVar.type == 1 || uVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.fgJ.getString(d.k.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fgJ.getString(d.k.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.aJH;
    }

    public void qC(String str) {
        if (this.dbz != null) {
            this.dbz.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fnZ;
    }

    public int bap() {
        return d.g.richText;
    }

    public TextView aWI() {
        return this.foe.aWI();
    }

    public void e(BdListView.e eVar) {
        this.fnZ.setOnSrollToBottomListener(eVar);
    }

    public void a(e.b bVar) {
        this.anZ = bVar;
        if (this.foL != null) {
            this.foL.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.am amVar, a.b bVar) {
        if (amVar != null) {
            int ra = amVar.ra();
            int qX = amVar.qX();
            if (this.foI != null) {
                this.foI.tD();
            } else {
                this.foI = new com.baidu.tbadk.core.dialog.a(this.fgJ.getPageContext().getPageActivity());
                this.foJ = LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.dialog_direct_pager, (ViewGroup) null);
                this.foI.w(this.foJ);
                this.foI.a(d.k.dialog_ok, bVar);
                this.foI.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        as.this.bar();
                        aVar.dismiss();
                    }
                });
                this.foI.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.as.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (as.this.fpQ == null) {
                            as.this.fpQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    as.this.fgJ.HidenSoftKeyPad((InputMethodManager) as.this.fgJ.getSystemService("input_method"), as.this.cHA);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fw().postDelayed(as.this.fpQ, 150L);
                    }
                });
                this.foI.b(this.fgJ.getPageContext()).tD();
            }
            this.foK = (EditText) this.foJ.findViewById(d.g.input_page_number);
            this.foK.setText("");
            TextView textView = (TextView) this.foJ.findViewById(d.g.current_page_number);
            if (ra <= 0) {
                ra = 1;
            }
            if (qX <= 0) {
                qX = 1;
            }
            textView.setText(MessageFormat.format(this.fgJ.getApplicationContext().getResources().getString(d.k.current_page), Integer.valueOf(ra), Integer.valueOf(qX)));
            this.fgJ.ShowSoftKeyPadDelay(this.foK, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fnZ.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fgJ.showToast(str);
    }

    public boolean kk(boolean z) {
        if (this.JS == null || !this.JS.DI()) {
            return false;
        }
        this.JS.Ca();
        return true;
    }

    public void baq() {
        if (this.fqy != null) {
            while (this.fqy.size() > 0) {
                TbImageView remove = this.fqy.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        baq();
        this.foH.qj(1);
        if (this.fnP != null) {
            this.fnP.onPause();
        }
    }

    public void onResume() {
        this.foH.qj(2);
        if (this.fnP != null) {
            this.fnP.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fpS != null) {
            this.fpS.destroy();
        }
        if (this.fqj != null) {
            this.fqj.onDestory();
        }
        if (this.fqa != null) {
            this.fqa.hide();
        }
        if (this.fnS != null) {
            this.fnS.ahf();
        }
        if (this.fnR != null) {
            this.fnR.onDestroy();
        }
        this.fgJ.hideProgressBar();
        if (this.cHy != null && this.cVe != null) {
            this.cHy.b(this.cVe);
        }
        bar();
        wS();
        if (this.fpQ != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fpQ);
        }
        if (this.fof != null && this.foq != null) {
            this.fof.removeView(this.fol);
            this.foq = null;
        }
        if (this.fpw != null) {
            this.fpw.clearStatus();
        }
        this.fqr = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.foH.qj(3);
        if (this.cZd != null) {
            this.cZd.setBackgroundDrawable(null);
        }
        if (this.fnP != null) {
            this.fnP.destroy();
        }
        if (this.foH != null) {
            this.foH.onDestroy();
        }
        this.fnZ.setOnLayoutListener(null);
        if (this.fqf != null) {
            this.fqf.arg();
        }
        if (this.fpH != null) {
            this.fpH.onDestroy();
        }
        baM();
    }

    public boolean qz(int i) {
        if (this.fnP != null) {
            return this.fnP.kq(i);
        }
        return false;
    }

    public void bar() {
        this.fnV.pr();
        if (this.fnS != null) {
            this.fnS.ahf();
        }
        com.baidu.adp.lib.util.l.b(this.fgJ.getPageContext().getPageActivity(), this.foK);
        aZF();
        if (this.fpa != null) {
            this.fpa.dismiss();
        }
        bat();
        if (this.fnR != null) {
            this.fnR.bcp();
        }
        if (this.foI != null) {
            this.foI.dismiss();
        }
        if (this.cYP != null) {
            this.cYP.dismiss();
        }
    }

    public void bas() {
        this.fnV.pr();
        if (this.fnS != null) {
            this.fnS.ahf();
        }
        if (this.fpa != null) {
            this.fpa.dismiss();
        }
        bat();
        if (this.fnR != null) {
            this.fnR.bcp();
        }
        if (this.foI != null) {
            this.foI.dismiss();
        }
        if (this.cYP != null) {
            this.cYP.dismiss();
        }
    }

    public void cO(List<String> list) {
        this.fqe = list;
        if (this.fqf != null) {
            this.fqf.setData(list);
        }
    }

    public void jq(boolean z) {
        this.foH.jq(z);
    }

    public void kl(boolean z) {
        this.fpf = z;
    }

    public void bat() {
        if (this.foR != null) {
            this.foR.dismiss();
        }
        if (this.foS != null) {
            com.baidu.adp.lib.g.g.b(this.foS, this.fgJ.getPageContext());
        }
        if (this.foT != null) {
            com.baidu.adp.lib.g.g.b(this.foT, this.fgJ.getPageContext());
        }
        if (this.foP != null) {
            com.baidu.adp.lib.g.g.b(this.foP, this.fgJ.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fkk, this.fha);
            d(this.fkk, this.fha, this.mType);
            this.fgJ.getLayoutMode().setNightMode(i == 1);
            this.fgJ.getLayoutMode().u(this.cHA);
            this.fgJ.getLayoutMode().u(this.foa);
            com.baidu.tbadk.core.util.ak.i(this.fod, d.C0126d.cp_bg_line_d);
            if (this.fnR != null) {
                this.fnR.onChangeSkinType(i);
            }
            if (this.foc != null) {
                com.baidu.tbadk.core.util.ak.h(this.foc, d.C0126d.cp_cont_b);
                this.foc.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            }
            if (this.dbz != null) {
                this.dbz.dv(i);
                if (this.aJH != null) {
                    this.fgJ.getLayoutMode().u(this.aJH);
                    com.baidu.tbadk.core.util.ak.i(this.aJH, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.foI != null) {
                this.foI.c(this.fgJ.getPageContext());
            }
            kj(this.fpc);
            this.foH.notifyDataSetChanged();
            if (this.foL != null) {
                this.foL.dv(i);
            }
            if (this.JS != null) {
                this.JS.onChangeSkinType(i);
            }
            if (this.fop != null) {
                this.fop.dz(i);
            }
            if (this.foM != null) {
                this.foM.dv(i);
            }
            if (!com.baidu.tbadk.core.util.v.w(this.cqZ)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cqZ) {
                    customBlueCheckRadioButton.wC();
                }
            }
            kf(i == 1);
            aZT();
            UtilHelper.setStatusBarBackground(this.cZd, i);
            UtilHelper.setStatusBarBackground(this.fpB, i);
            if (this.f0for != null) {
                this.f0for.onChangeSkinType(i);
            }
            if (this.fox != null) {
                com.baidu.tbadk.core.util.ak.h(this.fox, d.C0126d.cp_cont_d);
            }
            if (this.fow != null) {
                com.baidu.tbadk.core.util.ak.h(this.fow, d.C0126d.cp_cont_d);
            }
            if (this.foy != null) {
                com.baidu.tbadk.core.util.ak.i(this.foy, d.C0126d.cp_cont_e);
            }
            if (this.apF != null) {
                com.baidu.tbadk.core.util.ak.h(this.apF, d.C0126d.cp_cont_d);
            }
            if (this.foz != null) {
                com.baidu.tbadk.core.util.ak.i(this.foz, d.C0126d.cp_cont_e);
            }
            if (this.foi != null) {
                com.baidu.tbadk.core.util.ak.h(this.foi, d.C0126d.cp_link_tip_a);
            }
            if (this.fov != null) {
                com.baidu.tbadk.core.util.ak.h(this.fov, d.C0126d.cp_cont_d);
            }
            if (this.foA != null) {
                com.baidu.tbadk.n.a.a(this.fgJ.getPageContext(), this.foA);
            }
            if (this.foY != null) {
                com.baidu.tbadk.n.a.a(this.fgJ.getPageContext(), this.foY);
            }
            if (this.fpR != null) {
                this.fpR.onChangeSkinType(i);
            }
            if (this.fnV != null) {
                if (this.fnP != null) {
                    this.fnP.qF(i);
                } else {
                    this.fnV.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fpi != null) {
                com.baidu.tbadk.core.util.ak.h(this.fpi, d.C0126d.cp_cont_e);
            }
            if (this.foj != null) {
                com.baidu.tbadk.core.util.ak.c(this.foj, BitmapHelper.getGradeResourceIdInEnterForum(this.fpZ));
            }
            if (this.fqg != null) {
                this.fqg.onChangeSkinType(i);
            }
            if (this.fpH != null) {
                this.fpH.onChangeSkinType();
            }
            if (this.fqd != null) {
                com.baidu.tbadk.core.util.ak.h(this.fqd, d.C0126d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWw = hVar;
        this.foH.setOnImageClickListener(this.aWw);
        this.fqg.setOnImageClickListener(this.aWw);
    }

    public void h(NoNetworkView.a aVar) {
        this.cVe = aVar;
        if (this.cHy != null) {
            this.cHy.a(this.cVe);
        }
    }

    public void km(boolean z) {
        this.foH.setIsFromCDN(z);
    }

    public Button bau() {
        return this.fpg;
    }

    public void bav() {
        if (this.fnU != 2) {
            this.fnZ.setNextPage(this.dbz);
            this.fnU = 2;
        }
    }

    public void baw() {
        if (com.baidu.tbadk.k.p.Ha().Hb()) {
            int lastVisiblePosition = this.fnZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fnZ.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog = tbImageView.getPerfLog();
                                perfLog.fi(1001);
                                perfLog.aKM = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.k.k perfLog2 = headImageView.getPerfLog();
                        perfLog2.fi(1001);
                        perfLog2.aKM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bax() {
        return this.JS != null && this.JS.getVisibility() == 0;
    }

    public boolean bay() {
        return this.JS != null && this.JS.DI();
    }

    public void baz() {
        if (this.JS != null) {
            this.JS.Ca();
        }
    }

    public void kn(boolean z) {
        if (this.fph != null) {
            kl(this.fgJ.aWJ().Ek());
            if (this.fpf) {
                kc(z);
            } else {
                kd(z);
            }
        }
    }

    public void baA() {
        if (this.fph != null) {
            this.fph.setVisibility(8);
            this.fpm = false;
            if (this.fpH != null) {
                this.fpH.setVisibility(8);
                kh(false);
            }
            baM();
        }
    }

    public void showLoadingDialog() {
        if (this.cym == null) {
            this.cym = new com.baidu.tbadk.core.view.a(this.fgJ.getPageContext());
        }
        this.cym.aI(true);
    }

    public void aas() {
        if (this.cym != null) {
            this.cym.aI(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fnZ.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fnZ.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fnP != null) {
            this.fnP.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eGe = getScrollY();
            this.fpG.fqN = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fpG));
            a(this.fpG.fqN, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fnP != null) {
            this.fnP.b(absListView, i);
        }
        int headerViewsCount = (i - this.fnZ.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.foH.qi(headerViewsCount) == com.baidu.tieba.pb.data.j.fcF) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fnZ.getHeaderViewsCount();
        if (this.fod != null && this.fnV != null) {
            this.fnV.g(this.fod.getBottom(), this.fod.getMeasuredHeight(), z2);
        }
        this.foH.aXR().j(z, this.fpz != null ? this.fpz.getMeasuredHeight() : 0);
        this.fpG.eXB = i;
        this.fpG.headerCount = this.fnZ.getHeaderViewsCount();
        this.fpG.fqN = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fpG));
        a(this.fpG.fqN, false);
    }

    public void baB() {
        if (this.fgJ.isLogin() && this.fkk != null && this.fpW && !this.fpV && !this.fpd && this.fpq != null && this.fpq.rQ() != null && !this.fpq.rQ().getIsLike() && !this.fpq.rQ().hadConcerned()) {
            if (this.fpS == null) {
                this.fpS = new am(this.fgJ);
            }
            this.fpS.a(this.fnV.fsW, this.fkk.aVQ(), this.fpq.rQ().getUserId(), this.fkk.getThreadId());
        }
    }

    public void baC() {
        if (this.fpW && !this.fpV && this.fpq != null && this.fpq.rQ() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12601").r("obj_locate", this.fgJ.aXy() ? 2 : 1).r("obj_type", this.fpV ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fgJ.getPageContext().getPageActivity(), this.fpq.rQ().getUserId(), this.fpq.rQ().getUserName(), this.fgJ.aWx().aYi(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fpV && this.fpA != null && this.fnV.bbf() != null) {
            int aXO = this.foH.aXO();
            if (aXO > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (aXO > this.fnZ.getFirstVisiblePosition() - this.fnZ.getHeaderViewsCount()) {
                    this.fpA.setVisibility(8);
                    return;
                }
                this.fpA.setVisibility(0);
                this.fnV.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fnd == null) {
                if (this.fnZ.getFirstVisiblePosition() == 0) {
                    this.fpA.setVisibility(8);
                    this.fnV.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fpF) {
                        this.fpE = top;
                        this.fpF = false;
                    }
                    this.fpE = top < this.fpE ? top : this.fpE;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.foG.getY() < 0.0f) {
                        measuredHeight = fpD - akVar.fnd.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fnV.bbf().getMeasuredHeight() - akVar.fnd.getMeasuredHeight();
                        this.fnV.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fpE) {
                        this.fpA.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fpA.setVisibility(0);
                    } else {
                        this.fpA.setVisibility(8);
                        this.fnV.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fpF = true;
                    }
                }
            }
        }
    }

    public void baD() {
        if (!this.fqz) {
            TiebaStatic.log("c10490");
            this.fqz = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fgJ.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fpK, Integer.valueOf(fpM));
            aVar.bY(d.k.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.k.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.k.grade_thread_tips);
            aVar.w(inflate);
            aVar.z(sparseArray);
            aVar.a(d.k.grade_button_tips, this.fgJ);
            aVar.b(d.k.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fgJ.getPageContext()).tD();
        }
    }

    public void qD(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fgJ.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.w(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fpK, Integer.valueOf(fpN));
        aVar.z(sparseArray);
        aVar.a(d.k.view, this.fgJ);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fgJ.getPageContext()).tD();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.rQ() != null) {
            MetaData rQ = b.rQ();
            rQ.setGiftNum(rQ.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView baE() {
        return this.fpw;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aVs() != null && dVar.aVs().sF() && this.fpw == null) {
            this.fpw = (PbInterviewStatusView) this.fpv.inflate();
            this.fpw.setOnClickListener(this.cYQ);
            this.fpw.setCallback(this.fgJ.aXt());
            this.fpw.setData(this.fgJ, dVar);
        }
    }

    public LinearLayout baF() {
        return this.foG;
    }

    public View baG() {
        return this.cZd;
    }

    public boolean baH() {
        return this.fql;
    }

    public void jv(boolean z) {
        this.foe.jv(z);
    }

    public void qE(String str) {
        if (this.fnW != null) {
            this.fnW.setTitle(str);
        }
    }

    private int ko(boolean z) {
        if (this.fpw == null || this.fpw.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void baI() {
        if (this.fpw != null && this.fpw.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpw.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fpw.setLayoutParams(layoutParams);
        }
    }

    public boolean aWP() {
        return false;
    }

    public void qF(String str) {
        this.fpi.performClick();
        if (!StringUtils.isNull(str) && this.fgJ.aWJ() != null && this.fgJ.aWJ().Ee() != null && this.fgJ.aWJ().Ee().getInputView() != null) {
            EditText inputView = this.fgJ.aWJ().Ee().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bar();
            if (configuration.orientation == 2) {
                baA();
                aZF();
            } else {
                aZI();
            }
            if (this.fpR != null) {
                this.fpR.aXV();
            }
            this.fgJ.apD();
            this.foG.setVisibility(8);
            this.fnV.kA(false);
            this.fgJ.jB(false);
            if (this.fnP != null) {
                if (configuration.orientation == 1) {
                    baF().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fnZ.setIsLandscape(true);
                    this.fnZ.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fnZ.setIsLandscape(false);
                    if (this.eGe > 0) {
                        this.fnZ.smoothScrollBy(this.eGe, 0);
                    }
                }
                this.fnP.onConfigurationChanged(configuration);
            }
        }
    }

    public void kp(boolean z) {
        this.fnT = z;
    }

    public boolean baJ() {
        return this.fnP != null && this.fnP.baJ();
    }

    public void baK() {
        if (this.fnP != null) {
            this.fnP.onPause();
        }
    }

    public void z(long j, int i) {
        if (this.fnR != null) {
            this.fnR.z(j, i);
        }
        if (this.fnP != null) {
            this.fnP.z(j, i);
        }
    }

    public void jG(boolean z) {
        this.foH.jG(z);
    }

    public void baL() {
        if (this.fpx == null) {
            LayoutInflater.from(this.fgJ.getActivity()).inflate(d.i.add_experienced_text, (ViewGroup) this.cHA, true);
            this.fpx = (ViewGroup) this.cHA.findViewById(d.g.add_experienced_layout);
            this.fpy = (TextView) this.cHA.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.ak.h(this.fpy, d.C0126d.cp_cont_i);
            String string = this.fgJ.getResources().getString(d.k.experienced_add_success);
            String string2 = this.fgJ.getResources().getString(d.k.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_h)));
            this.fpy.setText(spannableString);
        }
        this.fpx.setVisibility(0);
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
                        as.this.fpx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                as.this.fpy.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fpy.startAnimation(scaleAnimation);
    }

    public void bf(final View view2) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fph.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view2.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fgJ);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fqd = new TextView(this.fgJ);
            this.fqd.setText(d.k.connection_tips);
            this.fqd.setGravity(17);
            this.fqd.setPadding(com.baidu.adp.lib.util.l.e(this.fgJ, d.e.ds24), 0, com.baidu.adp.lib.util.l.e(this.fgJ, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.fgJ, d.e.ds60);
            if (this.fqd.getParent() == null) {
                frameLayout.addView(this.fqd, layoutParams);
            }
            this.fqc = new PopupWindow(this.fgJ);
            this.fqc.setContentView(frameLayout);
            this.fqc.setHeight(-2);
            this.fqc.setWidth(-2);
            this.fqc.setFocusable(true);
            this.fqc.setOutsideTouchable(false);
            this.fqc.setBackgroundDrawable(new ColorDrawable(this.fgJ.getResources().getColor(d.C0126d.transparent)));
            this.fnZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        as.this.fqc.showAsDropDown(as.this.fph, view2.getLeft(), -as.this.fph.getHeight());
                    } else {
                        as.this.fqc.showAsDropDown(view2);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.baW() != null && !StringUtils.isNull(aVar.baW().pkg_id) && !StringUtils.isNull(aVar.baW().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fpj != null && this.fpj.getVisibility() == 0) {
            if (this.fqb == null) {
                View inflate = LayoutInflater.from(this.fgJ.getPageContext().getPageActivity()).inflate(d.i.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.k.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.cYQ);
                this.fqb = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fpj.getLocationInWindow(iArr);
            this.fqb.showAtLocation(this.fpj, 0, iArr[0] - com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fpj.getHeight()) - com.baidu.adp.lib.util.l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void baM() {
        com.baidu.adp.lib.g.g.a(this.fqb);
    }

    public void kq(boolean z) {
        this.fqi = z;
    }

    public boolean baN() {
        return this.fqi;
    }

    public void bg(View view2) {
        this.foY = view2;
    }
}
