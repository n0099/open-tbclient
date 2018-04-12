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
    private static final int fpG = UtilHelper.getLightStatusBarHeight();
    public static int fpM = 3;
    public static int fpN = 0;
    public static int fpO = 3;
    public static int fpP = 4;
    public static int fpQ = 5;
    public static int fpR = 6;
    private EditorTools JS;
    private View aJH;
    private com.baidu.tieba.pb.a.c aWx;
    private e.b anZ;
    private TextView apF;
    private TextView aza;
    private NoNetworkView cHB;
    private RelativeLayout cHD;
    private View.OnClickListener cYT;
    private View cZg;
    private List<CustomBlueCheckRadioButton> crd;
    private PbListView dbC;
    private NavigationBarCoverTip dqX;
    private int eGh;
    PbActivity.d ffR;
    private PbActivity fgM;
    private View.OnClickListener fhk;
    private UserIconBox fie;
    private UserIconBox fif;
    private PbFakeFloorModel fji;
    private com.baidu.tieba.pb.data.d fkn;
    public int fnR;
    private com.baidu.tieba.pb.video.i fnS;
    private long fnT;
    private com.baidu.tieba.pb.video.h fnU;
    private com.baidu.tieba.d.c fnV;
    public final com.baidu.tieba.pb.pb.main.view.b fnY;
    public com.baidu.tieba.pb.pb.main.view.a fnZ;
    private TextView foA;
    private View foB;
    private View foC;
    private LinearLayout foD;
    private TextView foE;
    private TextView foF;
    private View foG;
    private View foH;
    private ObservedChangeLinearLayout foJ;
    private f foK;
    private View foQ;
    private ViewStub foa;
    private ViewStub fob;
    private PbLandscapeListView foc;
    private View fod;
    private LinearLayout fog;
    private e foh;
    private ColumnLayout foi;
    private ThreadSkinView foj;
    private TextView fok;
    private TextView fol;
    private ImageView fom;
    private HeadPendantView fon;
    private FrameLayout foo;
    private HeadImageView fop;
    private View foq;

    /* renamed from: for  reason: not valid java name */
    private FloatingLayout f0for;
    private PbFirstFloorUserLikeButton fov;
    private aq fow;
    private aq fox;
    private TextView foy;
    private TextView foz;
    private ViewGroup fpA;
    private TextView fpB;
    private FrameLayout fpC;
    private View fpD;
    private View fpE;
    private ak fpF;
    private PbEmotionBar fpK;
    private int fpS;
    private Runnable fpT;
    private r fpU;
    private am fpV;
    private View fpk;
    private TextView fpl;
    private ImageView fpm;
    private ImageView fpn;
    private TextView fpo;
    private boolean fpq;
    private int fpr;
    private int fpt;
    private PostData fpu;
    private View fpw;
    private TextView fpx;
    private ViewStub fpy;
    private PbInterviewStatusView fpz;
    private int fqb;
    private PbTopTipView fqd;
    private PopupWindow fqe;
    private PopupWindow fqf;
    private TextView fqg;
    private List<String> fqh;
    private com.baidu.tieba.pb.pb.main.emotion.c fqi;
    private com.baidu.tieba.pb.pb.godreply.a fqj;
    private PbLandscapeListView.b fqk;
    private ab fqm;
    private boolean fqo;
    private com.baidu.tbadk.core.view.userLike.c fqp;
    private com.baidu.tbadk.core.view.userLike.c fqq;
    private Runnable fqv;
    private PbActivity.b fqx;
    private boolean isLandscape;
    private View mFooterView;
    private int mType;
    private boolean fnW = false;
    private int fnX = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout foe = null;
    private TextView fof = null;
    public FrsPraiseView fot = null;
    private ClickableHeaderImageView fou = null;
    private View foI = null;
    private com.baidu.tbadk.core.dialog.a foL = null;
    private com.baidu.tbadk.core.dialog.b cYS = null;
    private View foM = null;
    private EditText foN = null;
    private com.baidu.tieba.pb.view.e foO = null;
    private com.baidu.tieba.pb.view.a foP = null;
    private com.baidu.tbadk.core.dialog.a foR = null;
    private b.InterfaceC0086b ebJ = null;
    private TbRichTextView.h aWw = null;
    private NoNetworkView.a cVh = null;
    private Dialog foS = null;
    private View foT = null;
    private com.baidu.tbadk.core.dialog.a foU = null;
    private Dialog foV = null;
    private Dialog foW = null;
    private View foX = null;
    private LinearLayout foY = null;
    private CompoundButton.OnCheckedChangeListener cre = null;
    private TextView foZ = null;
    private TextView fpa = null;
    private View fpb = null;
    private String fpc = null;
    private com.baidu.tbadk.core.dialog.b fpd = null;
    private com.baidu.tbadk.core.dialog.b fpe = null;
    private boolean fpf = false;
    private boolean fpg = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fph = null;
    private boolean fpi = false;
    private Button fpj = null;
    private boolean fpp = true;
    private com.baidu.tbadk.core.view.a cyp = null;
    private boolean fhd = false;
    private int mSkinType = 3;
    private boolean fpv = false;
    private int fpH = 0;
    private boolean fpI = true;
    private a fpJ = new a();
    private int fpL = 0;
    private boolean fpW = false;
    private int fpX = 0;
    private boolean fpY = false;
    private boolean fpZ = false;
    private boolean fqa = false;
    private int fqc = 0;
    private boolean fql = false;
    private a.InterfaceC0215a fqn = new a.InterfaceC0215a() { // from class: com.baidu.tieba.pb.pb.main.as.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0215a
        public void onRefresh() {
        }
    };
    private String fqr = null;
    private CustomMessageListener fqs = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.as.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                as.this.fqr = null;
            }
        }
    };
    private CustomMessageListener bnd = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.as.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && as.this.foK != null) {
                as.this.foK.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.as.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (as.this.fof != null) {
                as.this.fof.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fqu = new Handler();
    private CustomMessageListener fqw = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.as.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                as.this.fpp = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fqy = true;
    View.OnClickListener fqz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (as.this.fpY) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11923").r(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (view2 == as.this.fnY.ftb) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12506").r("obj_locate", 2));
            }
            if (as.this.fgM.feP.fsk != null) {
                if (!as.this.fpY && as.this.fkn != null && as.this.fkn.aVs() != null && as.this.fkn.aVs().rQ() != null && as.this.fkn.aVs().rQ().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12151").r("obj_locate", 1));
                }
                as.this.fgM.feP.fsk.onClick(view2);
            }
        }
    };
    private boolean fqA = false;
    String userId = null;
    private final List<TbImageView> fqB = new ArrayList();
    private boolean fqC = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int eXE;
        public ak fqQ;
        public int headerCount;
    }

    public void kb(boolean z) {
        this.fpW = z;
        if (this.foc != null) {
            this.fpX = this.foc.getHeaderViewsCount();
        }
    }

    public void aZD() {
        if (this.foc != null) {
            int headerViewsCount = this.foc.getHeaderViewsCount() - this.fpX;
            final int firstVisiblePosition = (this.foc.getFirstVisiblePosition() == 0 || this.foc.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.foc.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.foc.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fpJ.fqQ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fpJ));
            final ak akVar = this.fpJ.fqQ;
            final int h = h(akVar);
            final int y = ((int) this.foJ.getY()) + this.foJ.getMeasuredHeight();
            final boolean z = this.fpD.getVisibility() == 0;
            boolean z2 = this.foJ.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.foK.aXO() + this.foc.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fng.getMeasuredHeight() : 0;
                if (z2) {
                    this.foc.setSelectionFromTop(this.foK.aXO() + this.foc.getHeaderViewsCount(), fpG - measuredHeight);
                } else {
                    this.foc.setSelectionFromTop(this.foK.aXO() + this.foc.getHeaderViewsCount(), this.fnY.bbf().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.foc.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fpY) {
                this.foc.setSelectionFromTop(this.foK.aXO() + this.foc.getHeaderViewsCount(), this.fnS.bcw().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.foc.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.as.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aYf() {
                        if (h >= 0 && h <= as.this.cHD.getMeasuredHeight()) {
                            int h2 = as.this.h(akVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = as.this.mFooterView.getLayoutParams();
                            if (i == 0 || i > as.this.cHD.getMeasuredHeight() || h2 >= as.this.cHD.getMeasuredHeight()) {
                                layoutParams.height = as.this.fpS;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > as.this.cHD.getMeasuredHeight()) {
                                layoutParams.height = as.this.fpS;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                as.this.foc.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            as.this.mFooterView.setLayoutParams(layoutParams);
                        }
                        as.this.foc.setOnLayoutListener(null);
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
        return this.cHB;
    }

    public void aZF() {
        if (this.JS != null) {
            this.JS.hide();
            if (this.fqi != null) {
                this.fqi.OL();
            }
        }
    }

    public PbFakeFloorModel aZG() {
        return this.fji;
    }

    public r aZH() {
        return this.fpU;
    }

    public void aZI() {
        reset();
        aZF();
        this.fpU.aXV();
        kn(false);
    }

    private void reset() {
        if (this.fgM != null && this.fgM.aWJ() != null && this.JS != null) {
            com.baidu.tbadk.editortools.pb.a.Eb().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aWJ = this.fgM.aWJ();
            aWJ.Et();
            aWJ.DP();
            if (aWJ.getWriteImagesInfo() != null) {
                aWJ.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aWJ.eO(SendView.ALL);
            aWJ.eP(SendView.ALL);
            com.baidu.tbadk.editortools.g eF = this.JS.eF(23);
            com.baidu.tbadk.editortools.g eF2 = this.JS.eF(2);
            com.baidu.tbadk.editortools.g eF3 = this.JS.eF(5);
            if (eF2 != null) {
                eF2.lN();
            }
            if (eF3 != null) {
                eF3.lN();
            }
            if (eF != null) {
                eF.hide();
            }
            this.JS.invalidate();
        }
    }

    public boolean aZJ() {
        return this.fpp;
    }

    public void kc(boolean z) {
        if (this.fpk != null && this.fpl != null) {
            this.fpl.setText(d.k.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fpk.startAnimation(alphaAnimation);
            }
            this.fpk.setVisibility(0);
            this.fpp = true;
            if (this.fpK != null && !this.fqj.isActive()) {
                this.fpK.setVisibility(0);
                kh(true);
            }
        }
    }

    public void kd(boolean z) {
        if (this.fpk != null && this.fpl != null) {
            this.fpl.setText(d.k.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fpk.startAnimation(alphaAnimation);
            }
            this.fpk.setVisibility(0);
            this.fpp = true;
            if (this.fpK != null && !this.fqj.isActive()) {
                this.fpK.setVisibility(0);
                kh(true);
            }
        }
    }

    public PostData aZK() {
        int i = 0;
        if (this.foc == null) {
            return null;
        }
        int aZL = aZL() - this.foc.getHeaderViewsCount();
        if (aZL < 0) {
            aZL = 0;
        }
        if (this.foK.qj(aZL) != null && this.foK.qj(aZL) != PostData.gwu) {
            i = aZL + 1;
        }
        return this.foK.getItem(i) instanceof PostData ? (PostData) this.foK.getItem(i) : null;
    }

    public int aZL() {
        int i;
        View childAt;
        if (this.foc == null) {
            return 0;
        }
        int firstVisiblePosition = this.foc.getFirstVisiblePosition();
        int lastVisiblePosition = this.foc.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.foc.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.foc.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        return this.foc.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fkn != null && this.fkn.aVu() != null && !this.fkn.aVu().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fkn.aVu().size() && (postData = this.fkn.aVu().get(i)) != null && postData.rQ() != null && !StringUtils.isNull(postData.rQ().getUserId()); i++) {
                if (this.fkn.aVu().get(i).rQ().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fqj != null && this.fqj.isActive()) {
                        kn(false);
                    }
                    if (this.fpK != null) {
                        this.fpK.ku(true);
                    }
                    this.fqr = postData.rQ().getName_show();
                    return;
                }
            }
        }
    }

    public as(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fgM = null;
        this.cHD = null;
        this.cZg = null;
        this.fnT = 0L;
        this.foc = null;
        this.fod = null;
        this.fog = null;
        this.foi = null;
        this.fok = null;
        this.fol = null;
        this.foo = null;
        this.fop = null;
        this.foq = null;
        this.fov = null;
        this.foy = null;
        this.foz = null;
        this.foA = null;
        this.foB = null;
        this.foG = null;
        this.foH = null;
        this.foK = null;
        this.dbC = null;
        this.aJH = null;
        this.cYT = null;
        this.fhk = null;
        this.fpk = null;
        this.fpl = null;
        this.fpm = null;
        this.fpn = null;
        this.fpo = null;
        this.fpw = null;
        this.fpx = null;
        this.fpy = null;
        this.fqb = 0;
        this.fnT = System.currentTimeMillis();
        this.fgM = pbActivity;
        this.cYT = onClickListener;
        this.aWx = cVar;
        this.fqb = com.baidu.adp.lib.util.l.af(this.fgM) / 2;
        this.cHD = (RelativeLayout) LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.new_pb_activity, (ViewGroup) null);
        this.fgM.addContentView(this.cHD, new FrameLayout.LayoutParams(-1, -1));
        this.dqX = (NavigationBarCoverTip) this.fgM.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.cZg = this.fgM.findViewById(d.g.statebar_view);
        this.foJ = (ObservedChangeLinearLayout) this.fgM.findViewById(d.g.title_wrapper);
        this.cHB = (NoNetworkView) this.fgM.findViewById(d.g.view_no_network);
        this.foc = (PbLandscapeListView) this.fgM.findViewById(d.g.new_pb_list);
        this.fpC = (FrameLayout) this.fgM.findViewById(d.g.root_float_header);
        this.aza = new TextView(this.fgM.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds88));
        this.foc.addHeaderView(this.aza, 0);
        this.fpS = this.fgM.getResources().getDimensionPixelSize(d.e.tbds134);
        this.mFooterView = new View(this.fgM.getPageContext().getPageActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fpS));
        this.mFooterView.setVisibility(4);
        this.foc.addFooterView(this.mFooterView);
        this.foc.setOnTouchListener(this.fgM.aNK);
        this.fnY = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fgM.aXl()) {
            this.foa = (ViewStub) this.fgM.findViewById(d.g.manga_view_stub);
            this.foa.setVisibility(0);
            this.fnZ = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fnZ.show();
            this.fnY.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds120);
        }
        this.aza.setLayoutParams(layoutParams);
        this.fnY.bbf().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0187a() { // from class: com.baidu.tieba.pb.pb.main.as.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0187a
            public void aWl() {
                if (as.this.foc != null) {
                    if (as.this.fnS != null) {
                        as.this.fnS.bcx();
                    }
                    as.this.foc.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0187a
            public void aWm() {
                as.this.fgM.apD();
            }
        }));
        this.fpk = this.fgM.findViewById(d.g.pb_editor_tool_comment);
        this.fpr = com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds90);
        this.fpt = com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds242);
        this.fpl = (TextView) this.fgM.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fpn = (ImageView) this.fgM.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fpm = (ImageView) this.fgM.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fpo = (TextView) this.fgM.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fpo.setVisibility(8);
        this.fpl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (!as.this.fgM.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, as.this.mForumId));
                } else if (as.this.fgM.aWT()) {
                    com.baidu.tbadk.editortools.pb.d aWJ = as.this.fgM.aWJ();
                    if (aWJ == null || (!aWJ.Eq() && !aWJ.Er())) {
                        if (as.this.JS != null) {
                            as.this.aZW();
                        }
                        if (as.this.JS != null) {
                            as.this.fpp = false;
                            if (as.this.JS.eI(2) != null) {
                                com.baidu.tieba.tbadkCore.b.a.a(as.this.fgM, (View) as.this.JS.eI(2).aCM, false, as.this.fqn);
                            }
                        }
                        as.this.baA();
                        return;
                    }
                    as.this.fgM.aWJ().a(false, (PostWriteCallBackData) null);
                }
            }
        });
        this.fpm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (as.this.fgM.checkUpIsLogin()) {
                    if (as.this.JS != null) {
                        as.this.aZW();
                        as.this.JS.M((View) as.this.JS.eF(5));
                    }
                    if (as.this.JS != null) {
                        as.this.fpp = false;
                        if (as.this.JS.eI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fgM, (View) as.this.JS.eI(2).aCM, false, as.this.fqn);
                        }
                    }
                    as.this.baA();
                }
            }
        });
        this.fpn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (as.this.fgM.checkUpIsLogin()) {
                    if (as.this.JS != null) {
                        as.this.aZW();
                        as.this.JS.M((View) as.this.JS.eF(2));
                    }
                    if (as.this.JS != null) {
                        as.this.fpp = false;
                        if (as.this.JS.eI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fgM, (View) as.this.JS.eI(2).aCM, false, as.this.fqn);
                        }
                    }
                    as.this.baA();
                }
            }
        });
        this.fpo.setOnClickListener(this.cYT);
        this.fpo.setOnTouchListener(this.fgM);
        this.fod = LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_item, (ViewGroup) null);
        this.fog = (LinearLayout) LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.ak.i(this.fog, d.C0126d.cp_bg_line_d);
        this.foh = new e(this.fgM, this.fog);
        this.foh.init();
        this.foh.a(this.foh.aWI(), this.cYT);
        this.foi = (ColumnLayout) this.fog.findViewById(d.g.pb_head_owner_root);
        this.foj = (ThreadSkinView) this.fog.findViewById(d.g.pb_thread_skin);
        this.foi.setOnLongClickListener(this.onLongClickListener);
        this.foi.setOnTouchListener(this.aWx);
        this.foi.setVisibility(8);
        this.fod.setOnTouchListener(this.aWx);
        this.fpw = this.fod.findViewById(d.g.pb_head_activity_join_number_container);
        this.fpw.setVisibility(8);
        this.fpx = (TextView) this.fod.findViewById(d.g.pb_head_activity_join_number);
        this.fok = (TextView) this.foi.findViewById(d.g.pb_head_owner_info_user_name);
        this.fol = (TextView) this.foi.findViewById(d.g.floor_owner);
        this.fom = (ImageView) this.foi.findViewById(d.g.icon_forum_level);
        this.foo = (FrameLayout) this.foi.findViewById(d.g.pb_head_headImage_container);
        this.fop = (HeadImageView) this.foi.findViewById(d.g.pb_head_owner_photo);
        this.fon = (HeadPendantView) this.foi.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fon.setHasPendantStyle();
        if (this.fon.getHeadView() != null) {
            this.fon.getHeadView().setIsRound(true);
            this.fon.getHeadView().setDrawBorder(false);
        }
        this.fie = (UserIconBox) this.foi.findViewById(d.g.show_icon_vip);
        this.fif = (UserIconBox) this.foi.findViewById(d.g.show_icon_yinji);
        this.f0for = (FloatingLayout) this.fog.findViewById(d.g.pb_head_owner_info_root);
        this.fov = (PbFirstFloorUserLikeButton) this.foi.findViewById(d.g.pb_like_button);
        this.foy = (TextView) this.foi.findViewById(d.g.pb_views);
        this.apF = (TextView) this.foi.findViewById(d.g.view_forum_name);
        this.foC = this.foi.findViewById(d.g.line_right_forum_name);
        this.foz = (TextView) this.foi.findViewById(d.g.pb_item_first_floor_reply_time);
        this.foA = (TextView) this.foi.findViewById(d.g.pb_item_first_floor_location_address);
        this.foB = this.foi.findViewById(d.g.line_between_time_and_locate);
        this.fqp = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fqq = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.foG = this.fod.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.foH = this.fod.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fod.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return false;
            }
        });
        this.fpy = (ViewStub) this.cHD.findViewById(d.g.interview_status_stub);
        this.foK = new f(this.fgM, this.foc);
        this.foK.t(this.cYT);
        this.foK.setTbGestureDetector(this.aWx);
        this.foK.setOnImageClickListener(this.aWw);
        this.fhk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.b(as.this.fgM.getBaseContext(), as.this.fgM.aWx().aYj(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                as.this.fgM.b(sparseArray);
                                return;
                            }
                            as.this.be(view2);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        as.this.fgM.b(sparseArray);
                    } else if (booleanValue3) {
                        as.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.foK.F(this.fhk);
        aZR();
        this.foc.addHeaderView(this.foe);
        this.foc.addHeaderView(this.fog);
        this.foc.addHeaderView(this.fod);
        this.dbC = new PbListView(this.fgM.getPageContext().getPageActivity());
        this.aJH = this.dbC.getView().findViewById(d.g.pb_more_view);
        if (this.aJH != null) {
            this.aJH.setOnClickListener(this.cYT);
            com.baidu.tbadk.core.util.ak.i(this.aJH, d.f.pb_foot_more_trans_selector);
        }
        this.dbC.wN();
        this.dbC.setBackground(d.f.pb_foot_more_trans_selector);
        this.dbC.dv(d.f.pb_foot_more_trans_selector);
        this.foQ = this.fgM.findViewById(d.g.viewstub_progress);
        this.fgM.registerListener(this.fqw);
        this.foq = com.baidu.tbadk.ala.b.os().f(this.fgM.getActivity(), 2);
        if (this.foq != null) {
            this.foq.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fgM.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.foq.getParent() == null) {
                this.f0for.addView(this.foq, aVar);
            }
        }
        this.fji = new PbFakeFloorModel(this.fgM.getPageContext());
        this.fpU = new r(this.fgM.getPageContext(), this.fji, this.cHD);
        this.fpU.a(this.fgM.ffN);
        this.fji.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.as.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                as.this.fji.l(postData);
                as.this.foK.notifyDataSetChanged();
                as.this.fpU.aXV();
                as.this.JS.Ca();
                as.this.kn(false);
            }
        });
        if (this.fgM.aWx() != null && !StringUtils.isNull(this.fgM.aWx().aYO())) {
            this.fgM.showToast(this.fgM.aWx().aYO());
        }
        this.fpD = this.fgM.findViewById(d.g.pb_expand_blank_view);
        this.fpE = this.fgM.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fpE.getLayoutParams();
        if (this.fgM.aWx() != null && this.fgM.aWx().aYm()) {
            this.fpD.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fpE.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fpG;
            this.fpE.setLayoutParams(layoutParams2);
        }
        this.fpF = new ak(this.fgM.getPageContext(), this.fgM.findViewById(d.g.pb_reply_expand_view));
        this.fpF.fng.setVisibility(8);
        this.fpF.H(this.cYT);
        this.fgM.registerListener(this.bnd);
        this.fgM.registerListener(this.fqs);
        this.fgM.registerListener(this.fqt);
        aZN();
        kh(false);
    }

    private void aZN() {
        this.fqj = new com.baidu.tieba.pb.pb.godreply.a(this.fgM, this, (ViewStub) this.cHD.findViewById(d.g.more_god_reply_popup));
        this.fqj.n(this.cYT);
        this.fqj.F(this.fhk);
        this.fqj.setOnImageClickListener(this.aWw);
        this.fqj.n(this.cYT);
        this.fqj.setTbGestureDetector(this.aWx);
    }

    public com.baidu.tieba.pb.pb.godreply.a aZO() {
        return this.fqj;
    }

    public View aZP() {
        return this.fpD;
    }

    public void aZQ() {
        if (this.foc != null) {
            this.foc.removeHeaderView(this.foe);
            this.foc.removeHeaderView(this.fog);
            this.foc.removeHeaderView(this.fod);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fpK == null) {
            this.fpK = new PbEmotionBar(this.fgM.getPageContext().getPageActivity());
            kh(true);
            this.fpK.a(this.cHD, aVar, this.fpk.getVisibility() == 0);
            this.fpK.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.as.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (as.this.fgM.aWT()) {
                        if (!StringUtils.isNull(as.this.fqr)) {
                            emotionImageData.setAuthorNameShow(as.this.fqr);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    as.this.fgM.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(as.this.fgM.getPageContext().getPageActivity(), 25016, str, list, as.this.fqr, list2)));
                }
            });
            this.fpK.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.as.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    as.this.baM();
                    if (as.this.fpk != null) {
                        ViewGroup.LayoutParams layoutParams = as.this.fpk.getLayoutParams();
                        layoutParams.height = (int) (((as.this.fpt - as.this.fpr) * f) + as.this.fpr);
                        as.this.fpl.setAlpha(1.0f - f);
                        as.this.fpn.setAlpha(1.0f - f);
                        as.this.fpm.setAlpha(1.0f - f);
                        as.this.fpk.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aZR() {
        if (this.foe == null) {
            int e = com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.tbds44);
            this.foe = new LinearLayout(this.fgM.getPageContext().getPageActivity());
            this.foe.setOrientation(1);
            this.foe.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.foe.setPadding(e, com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.tbds30), e, com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.tbds40));
            this.foe.setGravity(17);
            this.fof = new TextView(this.fgM.getPageContext().getPageActivity());
            this.fof.setGravity(3);
            this.fof.setMaxLines(2);
            this.fof.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            this.fof.setPadding(0, 0, 0, 0);
            this.fof.setLineSpacing(com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.ak.h(this.fof, d.C0126d.cp_cont_b);
            this.fof.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fof.setVisibility(8);
            if (this.fof.getParent() == null) {
                this.foe.addView(this.fof);
            }
            this.foe.setOnTouchListener(this.aWx);
            this.foe.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZS() {
        if (this.fgM.aXl()) {
            this.fob = (ViewStub) this.fgM.findViewById(d.g.manga_mention_controller_view_stub);
            this.fob.setVisibility(0);
            if (this.foD == null) {
                this.foD = (LinearLayout) this.fgM.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fgM.getPageContext(), this.foD);
            }
            if (this.foE == null) {
                this.foE = (TextView) this.foD.findViewById(d.g.manga_prev_btn);
            }
            if (this.foF == null) {
                this.foF = (TextView) this.foD.findViewById(d.g.manga_next_btn);
            }
            this.foE.setOnClickListener(this.cYT);
            this.foF.setOnClickListener(this.cYT);
        }
    }

    private void aZT() {
        if (this.fgM.aXl()) {
            if (this.fgM.aXo() == -1) {
                com.baidu.tbadk.core.util.ak.c(this.foE, d.C0126d.cp_cont_e, 1);
            }
            if (this.fgM.aXp() == -1) {
                com.baidu.tbadk.core.util.ak.c(this.foF, d.C0126d.cp_cont_e, 1);
            }
        }
    }

    public void aZU() {
        if (this.foD == null) {
            aZS();
        }
        this.fob.setVisibility(8);
        if (this.fqu != null && this.fqv != null) {
            this.fqu.removeCallbacks(this.fqv);
        }
    }

    public void aZV() {
        if (this.fqu != null) {
            if (this.fqv != null) {
                this.fqu.removeCallbacks(this.fqv);
            }
            this.fqv = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.this.foD == null) {
                        as.this.aZS();
                    }
                    as.this.fob.setVisibility(0);
                }
            };
            this.fqu.postDelayed(this.fqv, 2000L);
        }
    }

    public void ke(boolean z) {
        this.fnY.ke(z);
        if (z && this.fpv) {
            this.dbC.setText(this.fgM.getResources().getString(d.k.click_load_more));
            this.foc.setNextPage(this.dbC);
            this.fnX = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
        this.JS.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.JS.getParent() == null) {
            this.cHD.addView(this.JS, layoutParams);
        }
        this.JS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aZF();
        this.fgM.aWJ().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.as.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (as.this.JS != null && as.this.JS.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (as.this.fqi == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, as.this.JS.getId());
                            as.this.fqi = new com.baidu.tieba.pb.pb.main.emotion.c(as.this.fgM.getPageContext(), as.this.cHD, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.w(as.this.fqh)) {
                                as.this.fqi.setData(as.this.fqh);
                            }
                            as.this.fqi.b(as.this.JS);
                        }
                        as.this.fqi.qJ(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (as.this.fgM.feT != null && as.this.fgM.feT.baQ() != null) {
                    if (!as.this.fgM.feT.baQ().bAX()) {
                        as.this.fgM.feT.kr(false);
                    }
                    as.this.fgM.feT.baQ().nj(false);
                }
            }
        });
    }

    public void aZW() {
        if (this.fgM != null && this.JS != null) {
            this.JS.lN();
            baA();
        }
    }

    public void M(String str, boolean z) {
        this.fpq = z;
        kf(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kf(boolean z) {
        if (this.fpo != null) {
            if (this.fpq) {
                com.baidu.tbadk.core.util.ak.i(this.fpo, d.f.pb_praise_already_click_selector);
                this.fpo.setContentDescription(this.fgM.getResources().getString(d.k.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ak.i(this.fpo, d.f.pb_praise_normal_click_selector);
            this.fpo.setContentDescription(this.fgM.getResources().getString(d.k.zan));
        }
    }

    public TextView aZX() {
        return this.fpo;
    }

    public void kg(boolean z) {
        if (this.foc != null && this.aza != null && this.cZg != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cZg.setVisibility(0);
                } else {
                    this.cZg.setVisibility(8);
                    this.foc.removeHeaderView(this.aza);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aza.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fpG;
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
        return this.foK;
    }

    public void a(PbActivity.d dVar) {
        this.ffR = dVar;
    }

    public void be(View view2) {
        SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.foT == null) {
            this.foT = LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
        }
        this.fgM.getLayoutMode().u(this.foT);
        if (this.foS == null) {
            this.foS = new Dialog(this.fgM.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.foS.setCanceledOnTouchOutside(true);
            this.foS.setCancelable(true);
            this.foS.setContentView(this.foT);
            WindowManager.LayoutParams attributes = this.foS.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.af(this.fgM.getPageContext().getPageActivity()) * 0.9d);
            this.foS.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.foS.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.foS.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.foS.findViewById(d.g.disable_reply_btn);
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
                    if (as.this.foS != null && (as.this.foS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.foS, as.this.fgM.getPageContext());
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
                    if (as.this.foS != null && (as.this.foS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.foS, as.this.fgM.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view2.getTag();
                    if (sparseArray6 != null && as.this.fqx != null) {
                        as.this.fqx.f(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
                    if (as.this.foS != null && (as.this.foS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.foS, as.this.fgM.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view2.getTag();
                    if (sparseArray7 != null) {
                        as.this.fgM.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.foS, this.fgM.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fqx = bVar;
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
        sparseArray.put(fpN, Integer.valueOf(fpO));
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
        this.foU = new com.baidu.tbadk.core.dialog.a(this.fgM.getActivity());
        if (StringUtils.isNull(str2)) {
            this.foU.ca(i3);
        } else {
            this.foU.aw(false);
            this.foU.dc(str2);
        }
        this.foU.z(sparseArray);
        this.foU.a(d.k.dialog_ok, this.fgM);
        this.foU.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.foU.ar(true);
        this.foU.b(this.fgM.getPageContext());
        this.foU.tD();
    }

    public void ao(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.foX == null) {
            this.foX = LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.commit_good, (ViewGroup) null);
        }
        this.fgM.getLayoutMode().u(this.foX);
        if (this.foW == null) {
            this.foW = new Dialog(this.fgM.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.foW.setCanceledOnTouchOutside(true);
            this.foW.setCancelable(true);
            this.fph = (ScrollView) this.foX.findViewById(d.g.good_scroll);
            this.foW.setContentView(this.foX);
            WindowManager.LayoutParams attributes = this.foW.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds540);
            this.foW.getWindow().setAttributes(attributes);
            this.cre = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.as.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        as.this.fpc = (String) compoundButton.getTag();
                        if (as.this.crd != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : as.this.crd) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && as.this.fpc != null && !str.equals(as.this.fpc)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.foY = (LinearLayout) this.foX.findViewById(d.g.good_class_group);
            this.fpa = (TextView) this.foX.findViewById(d.g.dialog_button_cancel);
            this.fpa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (as.this.foW instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(as.this.foW, as.this.fgM.getPageContext());
                    }
                }
            });
            this.foZ = (TextView) this.foX.findViewById(d.g.dialog_button_ok);
            this.foZ.setOnClickListener(this.cYT);
        }
        this.foY.removeAllViews();
        this.crd = new ArrayList();
        CustomBlueCheckRadioButton bI = bI("0", this.fgM.getPageContext().getString(d.k.thread_good_class));
        this.crd.add(bI);
        bI.setChecked(true);
        this.foY.addView(bI);
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
                    this.crd.add(bI2);
                    View view2 = new View(this.fgM.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.ak.j(view2, d.C0126d.cp_bg_line_a);
                    view2.setLayoutParams(layoutParams);
                    this.foY.addView(view2);
                    this.foY.addView(bI2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fph.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fgM.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fgM.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fgM.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fph.setLayoutParams(layoutParams2);
            this.fph.removeAllViews();
            if (this.foY != null && this.foY.getParent() == null) {
                this.fph.addView(this.foY);
            }
        }
        com.baidu.adp.lib.g.g.a(this.foW, this.fgM.getPageContext());
    }

    private CustomBlueCheckRadioButton bI(String str, String str2) {
        Activity pageActivity = this.fgM.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cre);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void aZZ() {
        this.fgM.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fgM.hideProgressBar();
        if (z && z2) {
            this.fgM.showToast(this.fgM.getPageContext().getString(d.k.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.an.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.k.neterror);
            }
            this.fgM.showToast(str);
        }
    }

    public void aFf() {
        this.foQ.setVisibility(0);
    }

    public void aFe() {
        this.foQ.setVisibility(8);
    }

    public View baa() {
        if (this.foX != null) {
            return this.foX.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bab() {
        return this.fpc;
    }

    public View getView() {
        return this.cHD;
    }

    public void bac() {
        com.baidu.adp.lib.util.l.b(this.fgM.getPageContext().getPageActivity(), this.fgM.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fgM.hideProgressBar();
        if (z) {
            bar();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bas();
        } else {
            bar();
        }
    }

    public void bad() {
        this.dbC.wN();
        this.dbC.wR();
    }

    public void bae() {
        this.fgM.hideProgressBar();
        wS();
        this.foc.completePullRefreshPostDelayed(2000L);
        bao();
    }

    public void baf() {
        this.foc.completePullRefreshPostDelayed(2000L);
        bao();
    }

    private void kh(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fpl.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fgM.getResources().getDimensionPixelSize(d.e.ds130) : this.fgM.getResources().getDimensionPixelSize(d.e.ds34);
        this.fpl.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.foK.setOnLongClickListener(onLongClickListener);
        if (this.fqj != null) {
            this.fqj.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0086b interfaceC0086b, boolean z, boolean z2) {
        if (this.fpd != null) {
            this.fpd.dismiss();
            this.fpd = null;
        }
        this.fpd = new com.baidu.tbadk.core.dialog.b(this.fgM.getPageContext().getPageActivity());
        this.fpd.cd(d.k.operation);
        if (z2) {
            this.fpd.a(new String[]{this.fgM.getPageContext().getString(d.k.copy)}, interfaceC0086b);
        } else if (!z) {
            this.fpd.a(new String[]{this.fgM.getPageContext().getString(d.k.copy), this.fgM.getPageContext().getString(d.k.mark)}, interfaceC0086b);
        } else {
            this.fpd.a(new String[]{this.fgM.getPageContext().getString(d.k.copy), this.fgM.getPageContext().getString(d.k.remove_mark)}, interfaceC0086b);
        }
        this.fpd.d(this.fgM.getPageContext());
        this.fpd.tG();
    }

    public void a(b.InterfaceC0086b interfaceC0086b, boolean z) {
        if (this.fpe != null) {
            this.fpe.dismiss();
            this.fpe = null;
        }
        this.fpe = new com.baidu.tbadk.core.dialog.b(this.fgM.getPageContext().getPageActivity());
        this.fpe.cd(d.k.operation);
        if (z) {
            this.fpe.a(new String[]{this.fgM.getPageContext().getString(d.k.save_to_emotion)}, interfaceC0086b);
        } else {
            this.fpe.a(new String[]{this.fgM.getPageContext().getString(d.k.save_to_emotion), this.fgM.getPageContext().getString(d.k.save_to_local)}, interfaceC0086b);
        }
        this.fpe.d(this.fgM.getPageContext());
        this.fpe.tG();
    }

    public int bag() {
        return qy(this.foc.getFirstVisiblePosition());
    }

    private int qy(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.foc.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.foc.getAdapter() == null || !(this.foc.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.foc.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bah() {
        int lastVisiblePosition = this.foc.getLastVisiblePosition();
        if (this.fnS != null) {
            if (lastVisiblePosition == this.foc.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return qy(lastVisiblePosition);
    }

    public void qz(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.foc != null) {
            if (this.fnY == null || this.fnY.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fnY.mNavigationBar.getFixedNavHeight();
                if (this.fgM.aWZ() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fpE != null && (layoutParams = (LinearLayout.LayoutParams) this.fpE.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fpE.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.foc.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.foc.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.foN.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.foK.a(dVar, false);
        this.foK.notifyDataSetChanged();
        bao();
        if (this.fqj != null) {
            this.fqj.aWt();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fot == null) {
            this.fgM.getLayoutMode().u(((ViewStub) this.fod.findViewById(d.g.praise_layout)).inflate());
            this.fot = (FrsPraiseView) this.fod.findViewById(d.g.pb_head_praise_view);
            this.fot.setIsFromPb(true);
            this.foI = this.fod.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fot.dA(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fot != null) {
            boolean bao = bao();
            this.fot.setVisibility(8);
            if (dVar != null && dVar.rg() != null && dVar.rg().rd() == 0 && this.fhd) {
                if (bao) {
                    this.foH.setVisibility(0);
                    return;
                } else {
                    this.foH.setVisibility(8);
                    return;
                }
            }
            this.foH.setVisibility(8);
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
        postData.tp(1);
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
            this.foi.setVisibility(8);
            if (dVar.aVs() != null && dVar.aVs().sB() && dVar.aVs().sh() != null) {
                this.fpY = true;
                this.fnY.kD(this.fpY);
                this.fnY.mNavigationBar.hideBottomLine();
                if (this.fnS == null) {
                    this.fnS = new com.baidu.tieba.pb.video.i(this.fgM, this.fnY, dVar.aVs().sh(), this.fnT);
                    this.fnS.a(dVar.aVs().sh(), dVar.aVs(), dVar.getForumId());
                    this.fnS.startPlay();
                } else if (this.fnW) {
                    this.fnS.a(dVar.aVs().sh(), dVar.aVs(), dVar.getForumId());
                    this.fnS.startPlay();
                } else {
                    this.fnS.qT(dVar.getForumId());
                }
                if (dVar.aVt() != null && dVar.aVt().size() >= 1) {
                    bd bdVar = dVar.aVt().get(0);
                    this.fnS.aj(bdVar);
                    this.fnS.qU(bdVar.getTitle());
                }
                this.fnS.b(b, dVar.aVs(), dVar.aVO());
                this.fnW = false;
                this.foc.removeHeaderView(this.fnS.bcy());
                this.foc.addHeaderView(this.fnS.bcy(), 0);
                if (this.fnS.bcw() != null && this.fnS.bcw().getParent() == null) {
                    this.fpC.addView(this.fnS.bcw());
                }
                if (this.fnU == null) {
                    this.fnU = new com.baidu.tieba.pb.video.h(this.fgM);
                }
                this.fnU.a(dVar.aVs().sQ(), dVar.aVs(), dVar.aVL());
                this.foc.removeHeaderView(this.fnU.bcn());
                this.foc.addHeaderView(this.fnU.bcn(), 1);
                if (dVar.aVs().sQ() != null) {
                    this.foc.removeHeaderView(this.fnU.bco());
                    this.foc.removeHeaderView(this.fog);
                    this.foc.addHeaderView(this.fnU.bco(), 2);
                } else {
                    if (this.fnU.bco() != null) {
                        this.foc.removeHeaderView(this.fnU.bco());
                    }
                    this.foc.removeHeaderView(this.fog);
                    this.fog.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.fgM, d.e.tbds56));
                    this.foc.addHeaderView(this.fog, 2);
                }
                if (this.fnS != null) {
                    this.fnY.kx(false);
                    this.fnY.kz(TbadkCoreApplication.isLogin());
                    this.fnS.qG(TbadkCoreApplication.getInst().getSkinType());
                }
                bal();
            } else {
                this.fpY = false;
                this.fnY.kD(this.fpY);
                if (this.fnS != null) {
                    this.foc.removeHeaderView(this.fnS.bcy());
                }
                if (this.fnU != null) {
                    this.fnU.b(this.foc);
                }
                if (b == null || (b != null && (b.bsb() == null || com.baidu.tbadk.core.util.v.w(b.bsb().JJ())))) {
                    this.fog.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.fgM, d.e.tbds80));
                } else {
                    this.fog.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fgM.aWN() != null) {
                this.fgM.aWN().kv(this.fpY);
            }
            if (this.fnS != null) {
                this.fnS.J(this.fqz);
            }
            if (b != null) {
                this.fpu = b;
                this.foi.setVisibility(0);
                if (this.fgM.aXy()) {
                    if (dVar.aVr() != null) {
                        this.mForumName = dVar.aVr().getForumName();
                        this.mForumId = dVar.aVr().getForumId();
                    }
                    if (this.mForumName == null && this.fgM.aWx() != null && this.fgM.aWx().aYi() != null) {
                        this.mForumName = this.fgM.aWx().aYi();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.foi.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.foi.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fqo) {
                    this.foe.setVisibility(0);
                }
                if (!dVar.aVs().sB() && this.fof.getText() != null && this.fof.getText().length() > 0) {
                    this.fof.setVisibility(0);
                } else {
                    this.fof.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> sb = dVar.aVs().sb();
                if (sb != null && sb.size() > 0 && !this.fqo) {
                    this.fpx.setText(String.valueOf(sb.get(0).qq()));
                    this.fpw.setVisibility(0);
                } else {
                    this.fpw.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ak.i(this.fpw, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.ak.c(this.fpx, d.C0126d.cp_link_tip_d, 1);
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
                            if (this.fif != null) {
                                this.fif.setTag(d.g.tag_user_id, b.rQ().getUserId());
                                this.fif.setOnClickListener(this.fgM.feP.fsl);
                                this.fif.a(iconInfo, 4, this.fgM.getResources().getDimensionPixelSize(d.e.tbds36), this.fgM.getResources().getDimensionPixelSize(d.e.tbds36), this.fgM.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fie != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fie.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fie.setOnClickListener(this.fgM.feP.fsm);
                                this.fie.a(tShowInfoNew, 3, this.fgM.getResources().getDimensionPixelSize(d.e.tbds36), this.fgM.getResources().getDimensionPixelSize(d.e.tbds36), this.fgM.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fok.setText(ag(b.rQ().getSealPrefix(), e));
                            this.fok.setTag(d.g.tag_user_id, b.rQ().getUserId());
                            this.fok.setTag(d.g.tag_user_name, b.rQ().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew) || b.rQ().isBigV()) {
                                com.baidu.tbadk.core.util.ak.c(this.fok, d.C0126d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.ak.c(this.fok, d.C0126d.cp_cont_f, 1);
                            }
                            this.fol.setVisibility(8);
                            if (dVar.aVs().rQ() != null && dVar.aVs().rQ().getAlaUserData() != null && this.foq != null) {
                                if (dVar.aVs().rQ().getAlaUserData().anchor_live != 0) {
                                    this.foq.setVisibility(8);
                                } else {
                                    this.foq.setVisibility(0);
                                    if (this.fnV == null) {
                                        this.fnV = new com.baidu.tieba.d.c(this.fgM.getPageContext(), this.foq);
                                        this.fnV.jg(1);
                                    }
                                    this.fnV.aJ(this.fgM.getResources().getString(d.k.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Se = dVar.aVs().rQ().getAlaUserData();
                                    aVar.type = 2;
                                    this.foq.setTag(aVar);
                                }
                            }
                            this.fop.setUserId(b.rQ().getUserId());
                            this.fop.setUserName(b.rQ().getUserName());
                            this.fop.setImageDrawable(null);
                            this.fop.setRadius(com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds40));
                            this.fop.setTag(b.rQ().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.foz.setText(com.baidu.tbadk.core.util.an.t(b.getTime()));
                            } else {
                                this.foz.setText(com.baidu.tbadk.core.util.an.s(b.getTime()));
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds16);
                            if (!this.fgM.aXy() && !StringUtils.isNull(this.mForumName)) {
                                this.apF.setText(this.fgM.getString(d.k.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.apF.setVisibility(0);
                                this.foC.setVisibility(0);
                                this.foz.setPadding(e2, 0, e2, 0);
                            } else {
                                this.apF.setVisibility(8);
                                this.foC.setVisibility(8);
                                this.foz.setPadding(0, 0, e2, 0);
                            }
                            bsc = b.bsc();
                            if (bsc == null && !TextUtils.isEmpty(bsc.getName()) && !TextUtils.isEmpty(bsc.getName().trim())) {
                                final String name = bsc.getName();
                                final String lat = bsc.getLat();
                                final String lng = bsc.getLng();
                                this.foA.setVisibility(0);
                                this.foB.setVisibility(0);
                                this.foA.setText(bsc.getName());
                                this.foA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.gP()) {
                                                as.this.fgM.showToast(d.k.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.M(as.this.fgM.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, as.this.fgM.getPageContext().getString(d.k.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.foA.setVisibility(8);
                                this.foB.setVisibility(8);
                            }
                            portrait = b.rQ().getPortrait();
                            if (b.rQ().getPendantData() == null && !StringUtils.isNull(b.rQ().getPendantData().qG())) {
                                UtilHelper.showHeadImageViewBigV(this.fon.getHeadView(), b.rQ());
                                this.fop.setVisibility(8);
                                this.fon.setVisibility(0);
                                if (this.fou != null) {
                                    this.fou.setVisibility(8);
                                }
                                this.fok.setOnClickListener(this.fqz);
                                this.fon.getHeadView().startLoad(portrait, 28, false);
                                this.fon.getHeadView().setUserId(b.rQ().getUserId());
                                this.fon.getHeadView().setUserName(b.rQ().getUserName());
                                this.fon.getHeadView().setOnClickListener(this.fqz);
                                this.fon.eK(b.rQ().getPendantData().qG());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fop, b.rQ());
                                this.fop.setVisibility(0);
                                this.foi.setOnClickListener(this.fqz);
                                this.fok.setOnClickListener(this.fqz);
                                this.fop.setOnClickListener(this.fqz);
                                this.fon.setVisibility(8);
                                this.fop.startLoad(portrait, 28, false);
                            }
                            String name_show = b.rQ().getName_show();
                            String userName = b.rQ().getUserName();
                            if (com.baidu.tbadk.o.af.fz() && name_show != null && !name_show.equals(userName)) {
                                this.fok.setText(com.baidu.tieba.pb.c.ah(this.fgM.getPageContext().getPageActivity(), this.fok.getText().toString()));
                                this.fok.setGravity(16);
                                this.fok.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                                com.baidu.tbadk.core.util.ak.c(this.fok, d.C0126d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.rQ().getIconInfo();
                        tShowInfoNew = b.rQ().getTShowInfoNew();
                        if (this.fif != null) {
                        }
                        if (this.fie != null) {
                        }
                        this.fok.setText(ag(b.rQ().getSealPrefix(), e));
                        this.fok.setTag(d.g.tag_user_id, b.rQ().getUserId());
                        this.fok.setTag(d.g.tag_user_name, b.rQ().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ak.c(this.fok, d.C0126d.cp_cont_h, 1);
                        this.fol.setVisibility(8);
                        if (dVar.aVs().rQ() != null) {
                            if (dVar.aVs().rQ().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fop.setUserId(b.rQ().getUserId());
                        this.fop.setUserName(b.rQ().getUserName());
                        this.fop.setImageDrawable(null);
                        this.fop.setRadius(com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds40));
                        this.fop.setTag(b.rQ().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds16);
                        if (!this.fgM.aXy()) {
                        }
                        this.apF.setVisibility(8);
                        this.foC.setVisibility(8);
                        this.foz.setPadding(0, 0, e2, 0);
                        bsc = b.bsc();
                        if (bsc == null) {
                        }
                        this.foA.setVisibility(8);
                        this.foB.setVisibility(8);
                        portrait = b.rQ().getPortrait();
                        if (b.rQ().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fop, b.rQ());
                        this.fop.setVisibility(0);
                        this.foi.setOnClickListener(this.fqz);
                        this.fok.setOnClickListener(this.fqz);
                        this.fop.setOnClickListener(this.fqz);
                        this.fon.setVisibility(8);
                        this.fop.startLoad(portrait, 28, false);
                        String name_show2 = b.rQ().getName_show();
                        String userName2 = b.rQ().getUserName();
                        if (com.baidu.tbadk.o.af.fz()) {
                            this.fok.setText(com.baidu.tieba.pb.c.ah(this.fgM.getPageContext().getPageActivity(), this.fok.getText().toString()));
                            this.fok.setGravity(16);
                            this.fok.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                            com.baidu.tbadk.core.util.ak.c(this.fok, d.C0126d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aU(string) > 14) {
                            e = com.baidu.tbadk.core.util.an.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.rQ().getIconInfo();
                            tShowInfoNew = b.rQ().getTShowInfoNew();
                            if (this.fif != null) {
                            }
                            if (this.fie != null) {
                            }
                            this.fok.setText(ag(b.rQ().getSealPrefix(), e));
                            this.fok.setTag(d.g.tag_user_id, b.rQ().getUserId());
                            this.fok.setTag(d.g.tag_user_name, b.rQ().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.ak.c(this.fok, d.C0126d.cp_cont_h, 1);
                            this.fol.setVisibility(8);
                            if (dVar.aVs().rQ() != null) {
                            }
                            this.fop.setUserId(b.rQ().getUserId());
                            this.fop.setUserName(b.rQ().getUserName());
                            this.fop.setImageDrawable(null);
                            this.fop.setRadius(com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds40));
                            this.fop.setTag(b.rQ().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds16);
                            if (!this.fgM.aXy()) {
                            }
                            this.apF.setVisibility(8);
                            this.foC.setVisibility(8);
                            this.foz.setPadding(0, 0, e2, 0);
                            bsc = b.bsc();
                            if (bsc == null) {
                            }
                            this.foA.setVisibility(8);
                            this.foB.setVisibility(8);
                            portrait = b.rQ().getPortrait();
                            if (b.rQ().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fop, b.rQ());
                            this.fop.setVisibility(0);
                            this.foi.setOnClickListener(this.fqz);
                            this.fok.setOnClickListener(this.fqz);
                            this.fop.setOnClickListener(this.fqz);
                            this.fon.setVisibility(8);
                            this.fop.startLoad(portrait, 28, false);
                            String name_show22 = b.rQ().getName_show();
                            String userName22 = b.rQ().getUserName();
                            if (com.baidu.tbadk.o.af.fz()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.rQ().getIconInfo();
                        tShowInfoNew = b.rQ().getTShowInfoNew();
                        if (this.fif != null) {
                        }
                        if (this.fie != null) {
                        }
                        this.fok.setText(ag(b.rQ().getSealPrefix(), e));
                        this.fok.setTag(d.g.tag_user_id, b.rQ().getUserId());
                        this.fok.setTag(d.g.tag_user_name, b.rQ().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ak.c(this.fok, d.C0126d.cp_cont_h, 1);
                        this.fol.setVisibility(8);
                        if (dVar.aVs().rQ() != null) {
                        }
                        this.fop.setUserId(b.rQ().getUserId());
                        this.fop.setUserName(b.rQ().getUserName());
                        this.fop.setImageDrawable(null);
                        this.fop.setRadius(com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds40));
                        this.fop.setTag(b.rQ().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.fgM.getActivity(), d.e.ds16);
                        if (!this.fgM.aXy()) {
                        }
                        this.apF.setVisibility(8);
                        this.foC.setVisibility(8);
                        this.foz.setPadding(0, 0, e2, 0);
                        bsc = b.bsc();
                        if (bsc == null) {
                        }
                        this.foA.setVisibility(8);
                        this.foB.setVisibility(8);
                        portrait = b.rQ().getPortrait();
                        if (b.rQ().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fop, b.rQ());
                        this.fop.setVisibility(0);
                        this.foi.setOnClickListener(this.fqz);
                        this.fok.setOnClickListener(this.fqz);
                        this.fop.setOnClickListener(this.fqz);
                        this.fon.setVisibility(8);
                        this.fop.startLoad(portrait, 28, false);
                        String name_show222 = b.rQ().getName_show();
                        String userName222 = b.rQ().getUserName();
                        if (com.baidu.tbadk.o.af.fz()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.foh.ab(dVar.aVs());
                }
                if (this.fpF != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fcB);
                    if (dVar != null && dVar.aVs() != null) {
                        hVar.fcD = dVar.aVs().rI();
                    }
                    hVar.isNew = !this.fhd;
                    hVar.fcF = this.fgM.aXx();
                    this.fpF.a(hVar);
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
        this.fpJ.fqQ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fpJ));
        a(this.fpJ.fqQ, false);
    }

    public void bai() {
        if (this.fnY != null && !this.fqa) {
            this.fnY.kE(!StringUtils.isNull(this.fgM.aWW()));
            this.fqa = true;
        }
    }

    public void akW() {
        if (this.fnY != null) {
            this.fnY.bbm();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.sk() != null) {
            this.foj.setData(this.fgM.getPageContext(), dVar.aVu().get(0).sk(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.aVq().getId(), dVar.aVq().getName(), dVar.aVs().getId(), this.fgM.aXu() ? "FRS" : null));
            this.foi.setPadding(this.foi.getPaddingLeft(), (int) this.fgM.getResources().getDimension(d.e.ds20), this.foi.getPaddingRight(), this.foi.getPaddingBottom());
            return;
        }
        this.foj.setData(null, null, null);
    }

    public void baj() {
        if (this.fnS != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11997").r("obj_type", 1));
            this.fnS.bcx();
            this.foc.smoothScrollToPosition(0);
        }
    }

    public boolean bak() {
        return this.fqA;
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
            this.fnY.bbk();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fnY.oq(cVar.forumName);
            }
            String string = this.fgM.getResources().getString(d.k.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(cVar.source, 0)) {
                case 100:
                    str = this.fgM.getResources().getString(d.k.self);
                    break;
                case 300:
                    str = this.fgM.getResources().getString(d.k.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fgM.getResources().getString(d.k.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fbN;
            this.fgM.showNetRefreshView(this.cHD, format, null, this.fgM.getResources().getString(d.k.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.adp.lib.util.l.hg()) {
                        com.baidu.tbadk.core.util.ax.wg().c(as.this.fgM.getPageContext(), new String[]{str2});
                        as.this.fgM.finish();
                        return;
                    }
                    as.this.fgM.showToast(d.k.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aZs;
        Parcelable aZs2;
        String str;
        if (dVar != null) {
            this.fkn = dVar;
            this.mType = i;
            if (dVar.aVs() != null) {
                this.fpL = dVar.aVs().rC();
                if (dVar.aVs().getAnchorLevel() != 0) {
                    this.fqA = true;
                }
                this.fpg = ad(dVar.aVs());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fpv = false;
            this.fhd = z;
            bae();
            b(dVar, z, i);
            p(dVar);
            if (this.fqm == null) {
                this.fqm = new ab(this.fgM.getPageContext(), this.dqX);
            }
            this.fqm.qB(dVar.aVx());
            if (this.fgM.aXl()) {
                if (this.foO == null) {
                    this.foO = new com.baidu.tieba.pb.view.e(this.fgM.getPageContext());
                    this.foO.kA();
                    this.foO.a(this.anZ);
                }
                this.foc.setPullRefresh(this.foO);
                bal();
                if (this.foO != null) {
                    this.foO.dw(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.rg().rd() == 0 && z) {
                this.foc.setPullRefresh(null);
            } else {
                if (this.foO == null) {
                    this.foO = new com.baidu.tieba.pb.view.e(this.fgM.getPageContext());
                    this.foO.kA();
                    this.foO.a(this.anZ);
                }
                this.foc.setPullRefresh(this.foO);
                bal();
                if (this.foO != null) {
                    this.foO.dw(TbadkCoreApplication.getInst().getSkinType());
                }
                aas();
            }
            bao();
            this.foK.jr(this.fhd);
            this.foK.js(false);
            this.foK.jD(i == 5);
            this.foK.jE(i == 6);
            this.foK.jF(z2 && this.fqy);
            this.foK.a(dVar, false);
            this.foK.notifyDataSetChanged();
            if (this.fgM.aXy()) {
                this.fqc = 0;
                PostData b = b(dVar, z);
                if (b != null && b.rQ() != null) {
                    this.fqc = b.rQ().getLevel_id();
                }
                if (this.fqc > 0) {
                    this.fom.setVisibility(0);
                    com.baidu.tbadk.core.util.ak.c(this.fom, BitmapHelper.getGradeResourceIdInEnterForum(this.fqc));
                } else {
                    this.fom.setVisibility(8);
                }
            } else {
                this.fom.setVisibility(8);
            }
            if (dVar.aVs() != null) {
                if (dVar.aVs().rF() != null) {
                    if (dVar.aVs().rF().getNum() < 1) {
                        str = this.fgM.getResources().getString(d.k.zan);
                    } else {
                        str = dVar.aVs().rF().getNum() + "";
                    }
                    if (this.fnR != -1) {
                        dVar.aVs().rF().setIsLike(this.fnR);
                    }
                    M(str, dVar.aVs().rF().getIsLike() == 1);
                }
                if (dVar.aVs().abL != null && dVar.aVs().abL.isDeleted) {
                    this.fnY.ky(true);
                } else {
                    this.fnY.ky(false);
                }
            }
            if (this.fgM.isLogin()) {
                this.foc.setNextPage(this.dbC);
                this.fnX = 2;
                aas();
            } else {
                this.fpv = true;
                if (dVar.rg().rc() == 1) {
                    if (this.foP == null) {
                        this.foP = new com.baidu.tieba.pb.view.a(this.fgM.getPageContext());
                    }
                    this.foc.setNextPage(this.foP);
                } else {
                    this.foc.setNextPage(this.dbC);
                }
                this.fnX = 3;
            }
            ArrayList<PostData> aVu = dVar.aVu();
            if (dVar.rg().rc() == 0 || aVu == null || aVu.size() < dVar.rg().rb()) {
                if (com.baidu.tbadk.core.util.v.v(aVu) == 0 || (com.baidu.tbadk.core.util.v.v(aVu) == 1 && aVu.get(0) != null && aVu.get(0).brZ() == 1)) {
                    this.dbC.setText(this.fgM.getResources().getString(d.k.list_no_more_new));
                    if (this.fgM.aWN() != null && !this.fgM.aWN().bba()) {
                        this.fgM.aWN().showFloatingView();
                    }
                } else {
                    this.dbC.setText(this.fgM.getResources().getString(d.k.list_has_no_more));
                }
                if (this.fgM.aXl() && this.foc != null && this.foc.getData() != null && this.foc.getData().size() == 1 && (this.foc.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dbC.setText("");
                }
                bav();
            } else if (z2) {
                if (this.fqy) {
                    wS();
                    if (dVar.rg().rc() != 0) {
                        this.dbC.setText(this.fgM.getResources().getString(d.k.pb_load_more));
                    }
                } else {
                    this.dbC.wN();
                    this.dbC.showLoading();
                }
            } else {
                this.dbC.wN();
                this.dbC.showLoading();
            }
            switch (i) {
                case 2:
                    this.foc.setSelection(i2 > 1 ? (((this.foc.getData() == null && dVar.aVu() == null) ? 0 : (this.foc.getData().size() - dVar.aVu().size()) + this.foc.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aZs2 = ai.aZr().aZs()) != null) {
                        this.foc.onRestoreInstanceState(aZs2);
                        if (com.baidu.tbadk.core.util.v.v(aVu) > 1 && dVar.rg().rc() > 0) {
                            this.dbC.wS();
                            this.dbC.setText(this.fgM.getString(d.k.pb_load_more_without_point));
                            this.dbC.wO();
                            break;
                        }
                    } else {
                        this.foc.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fqy = false;
                    break;
                case 5:
                    this.foc.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aZs = ai.aZr().aZs()) != null) {
                        this.foc.onRestoreInstanceState(aZs);
                        break;
                    } else {
                        this.foc.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fnS != null && this.fnS.bcw() != null) {
                            if (this.fgM.isUseStyleImmersiveSticky()) {
                                this.foc.setSelectionFromTop((this.foK.aXN() + this.foc.getHeaderViewsCount()) - 1, this.fnS.bcw().getHeight() - com.baidu.adp.lib.util.l.p(this.fgM.getPageContext().getPageActivity()));
                            } else {
                                this.foc.setSelectionFromTop((this.foK.aXN() + this.foc.getHeaderViewsCount()) - 1, this.fnS.bcw().getHeight());
                            }
                        } else {
                            this.foc.setSelection(this.foK.aXN() + this.foc.getHeaderViewsCount());
                        }
                    } else {
                        this.foc.setSelection(i2 > 0 ? ((this.foc.getData() == null && dVar.aVu() == null) ? 0 : (this.foc.getData().size() - dVar.aVu().size()) + this.foc.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dbC.wS();
                    this.dbC.setText(this.fgM.getString(d.k.pb_load_more_without_point));
                    this.dbC.wO();
                    break;
            }
            if (this.fpL == fpM && isHost()) {
                baD();
            }
            if (this.fpW) {
                aZD();
                this.fpW = false;
                if (i3 == 0) {
                    kb(true);
                }
            }
            if (this.fnU != null) {
                this.fnU.ai(dVar.aVs());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fcs == 1 || dVar.fct == 1) {
                if (this.fqd == null) {
                    this.fqd = new PbTopTipView(this.fgM);
                }
                if (dVar.fct == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fgM.getStType())) {
                    this.fqd.setText(this.fgM.getString(d.k.pb_read_strategy_add_experience));
                    this.fqd.show(this.cHD, this.mSkinType);
                } else if (dVar.fcs == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fgM.getStType())) {
                    this.fqd.setText(this.fgM.getString(d.k.pb_read_news_add_experience));
                    this.fqd.show(this.cHD, this.mSkinType);
                }
            }
        }
    }

    private void bal() {
        if (this.fnS != null && this.fnS.bcw() != null) {
            this.foc.removeHeaderView(this.aza);
            if (this.mType != 1) {
                this.foc.removeHeaderView(this.fnS.bcy());
                this.foc.addHeaderView(this.fnS.bcy(), 0);
                return;
            }
            return;
        }
        if (this.fnS != null) {
            this.foc.removeHeaderView(this.fnS.bcy());
        }
        this.foc.removeHeaderView(this.aza);
        this.foc.addHeaderView(this.aza, 0);
    }

    public void kj(boolean z) {
        this.fpf = z;
    }

    public void wS() {
        if (this.dbC != null) {
            this.dbC.wO();
            this.dbC.wS();
        }
        aas();
    }

    public void showListView() {
        this.foc.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fpu != null && this.fpu.rQ() != null && this.fnY != null) {
            this.fpZ = !this.fpY;
            this.fnY.kx(this.fpZ);
            if (this.fgM.aWN() != null) {
                this.fgM.aWN().kw(this.fpZ);
            }
            bam();
            if (this.fpZ) {
                this.fnY.fsZ.setVisibility(0);
                if (this.fpg) {
                    this.fnY.fta.setVisibility(8);
                    this.fov.setVisibility(8);
                    this.foy.setVisibility(0);
                    this.foy.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.an.y(dVar.aVN())));
                } else if (!PbNormalLikeButtonSwitchStatic.Hs() || (this.fpu.rQ().hadConcerned() && this.fpu.rQ().getGodUserData() != null && this.fpu.rQ().getGodUserData().getIsFromNetWork())) {
                    this.fnY.fta.setVisibility(8);
                }
                if (this.fpE != null) {
                    this.fpE.setVisibility(8);
                }
                this.fnY.a(this.fpu.rQ(), this.fqz);
                if (this.fqk == null) {
                    this.fqk = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.as.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > as.this.fqb) {
                                as.this.baC();
                            }
                        }
                    };
                }
                this.foc.setListViewDragListener(this.fqk);
                return;
            }
            if (this.fnY.fsZ != null) {
                this.fnY.fsZ.setVisibility(8);
            }
            if (this.fpE != null) {
                this.fpE.setVisibility(0);
            }
            if (this.fpg) {
                this.fov.setVisibility(8);
                this.foy.setVisibility(0);
                this.foy.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.an.y(dVar.aVN())));
            } else if (!PbNormalLikeButtonSwitchStatic.Hs() || (this.fpu.rQ().hadConcerned() && this.fpu.rQ().getGodUserData() != null && this.fpu.rQ().getGodUserData().getIsFromNetWork())) {
                this.fov.setVisibility(8);
                this.foy.setVisibility(8);
            } else {
                this.foy.setVisibility(8);
            }
            this.fqk = null;
            this.foc.setListViewDragListener(null);
        }
    }

    private void bam() {
        String threadId = this.fkn != null ? this.fkn.getThreadId() : "";
        int ban = ban();
        if (this.fpZ) {
            if (this.fox == null) {
                this.fox = new aq(this.fgM.getPageContext(), this.fnY.fta, 3);
                this.fox.h(this.fgM.getUniqueId());
            }
            if (this.fpu != null && this.fpu.rQ() != null) {
                this.fpu.rQ().setIsLike(this.fpu.rQ().hadConcerned());
                this.fox.a(this.fpu.rQ());
            }
            this.fox.cJ(threadId);
            this.fox.qx(ban);
            this.fox.fnN = this.fpY;
        }
        if (this.fow == null) {
            this.fow = new aq(this.fgM.getPageContext(), this.fov, 1);
            this.fow.h(this.fgM.getUniqueId());
            this.fow.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.as.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aR(boolean z) {
                    if (as.this.fgM != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(as.this.fgM, d.k.attention_success);
                            return;
                        }
                        ar.u(as.this.fgM.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fpu != null && this.fpu.rQ() != null) {
            this.fpu.rQ().setIsLike(this.fpu.rQ().hadConcerned());
            this.fow.a(this.fpu.rQ());
            this.fow.cJ(threadId);
        }
        this.fow.fnN = this.fpY;
        this.fow.qx(ban);
    }

    private int ban() {
        if (this.fkn == null || this.fkn.aVs() == null) {
            return 0;
        }
        if (this.fkn.aVs().sY()) {
            return (com.baidu.tbadk.core.util.v.w(this.fkn.aVM()) && (this.fkn.aVr() == null || StringUtils.isNull(this.fkn.aVr().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bao() {
        boolean z;
        if (this.fpj != null && this.fpj.getVisibility() == 0) {
            if (this.foG != null) {
                this.foG.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.foG != null) {
                this.foG.setVisibility(8);
            }
            z = false;
        }
        if ((this.foI == null || this.foI.getVisibility() == 8) && z && this.fhd) {
            this.foH.setVisibility(0);
        } else {
            this.foH.setVisibility(8);
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
            return com.baidu.tieba.card.o.a((Context) this.fgM.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.foe != null) {
                if (dVar.aVs() != null && dVar.aVs().sf() == 0 && !dVar.aVs().sB() && !this.fqo) {
                    this.foe.setVisibility(0);
                    if (dVar.aVs() != null) {
                        dVar.aVs().e(true, q(dVar));
                    }
                    SpannableStringBuilder so = dVar.aVs().so();
                    this.fof.setOnTouchListener(new com.baidu.tieba.view.j(so));
                    if (this.fql) {
                        this.fof.setText(dVar.aVs().getTitle());
                    } else {
                        this.fof.setText(so);
                    }
                    this.fof.setVisibility(0);
                } else if (dVar.aVs().sf() == 1) {
                    if (dVar.aVs() != null) {
                        this.foe.setVisibility(8);
                        this.foc.removeHeaderView(this.foe);
                        if (dVar.aVs() != null && !dVar.aVs().sB()) {
                            this.foi.setPadding(this.foi.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.tbds36), this.foi.getPaddingRight(), this.foi.getPaddingBottom());
                        }
                    }
                } else {
                    this.foe.setVisibility(8);
                    this.foc.removeHeaderView(this.foe);
                    if (dVar.aVs() != null && dVar.aVs().sB()) {
                        this.foi.setPadding(this.foi.getPaddingLeft(), 0, this.foi.getPaddingRight(), this.foi.getPaddingBottom());
                    } else {
                        this.foi.setPadding(this.foi.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds48), this.foi.getPaddingRight(), this.foi.getPaddingBottom());
                    }
                }
            }
            this.fhd = z;
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
                            sb.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.fgM.getString(d.k.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fgM.getString(d.k.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
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
        if (this.dbC != null) {
            this.dbC.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.foc;
    }

    public int bap() {
        return d.g.richText;
    }

    public TextView aWI() {
        return this.foh.aWI();
    }

    public void e(BdListView.e eVar) {
        this.foc.setOnSrollToBottomListener(eVar);
    }

    public void a(e.b bVar) {
        this.anZ = bVar;
        if (this.foO != null) {
            this.foO.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.am amVar, a.b bVar) {
        if (amVar != null) {
            int ra = amVar.ra();
            int qX = amVar.qX();
            if (this.foL != null) {
                this.foL.tD();
            } else {
                this.foL = new com.baidu.tbadk.core.dialog.a(this.fgM.getPageContext().getPageActivity());
                this.foM = LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.dialog_direct_pager, (ViewGroup) null);
                this.foL.w(this.foM);
                this.foL.a(d.k.dialog_ok, bVar);
                this.foL.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        as.this.bar();
                        aVar.dismiss();
                    }
                });
                this.foL.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.as.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (as.this.fpT == null) {
                            as.this.fpT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    as.this.fgM.HidenSoftKeyPad((InputMethodManager) as.this.fgM.getSystemService("input_method"), as.this.cHD);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fw().postDelayed(as.this.fpT, 150L);
                    }
                });
                this.foL.b(this.fgM.getPageContext()).tD();
            }
            this.foN = (EditText) this.foM.findViewById(d.g.input_page_number);
            this.foN.setText("");
            TextView textView = (TextView) this.foM.findViewById(d.g.current_page_number);
            if (ra <= 0) {
                ra = 1;
            }
            if (qX <= 0) {
                qX = 1;
            }
            textView.setText(MessageFormat.format(this.fgM.getApplicationContext().getResources().getString(d.k.current_page), Integer.valueOf(ra), Integer.valueOf(qX)));
            this.fgM.ShowSoftKeyPadDelay(this.foN, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.foc.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fgM.showToast(str);
    }

    public boolean kk(boolean z) {
        if (this.JS == null || !this.JS.DI()) {
            return false;
        }
        this.JS.Ca();
        return true;
    }

    public void baq() {
        if (this.fqB != null) {
            while (this.fqB.size() > 0) {
                TbImageView remove = this.fqB.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        baq();
        this.foK.qk(1);
        if (this.fnS != null) {
            this.fnS.onPause();
        }
    }

    public void onResume() {
        this.foK.qk(2);
        if (this.fnS != null) {
            this.fnS.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fpV != null) {
            this.fpV.destroy();
        }
        if (this.fqm != null) {
            this.fqm.onDestory();
        }
        if (this.fqd != null) {
            this.fqd.hide();
        }
        if (this.fnV != null) {
            this.fnV.ahf();
        }
        if (this.fnU != null) {
            this.fnU.onDestroy();
        }
        this.fgM.hideProgressBar();
        if (this.cHB != null && this.cVh != null) {
            this.cHB.b(this.cVh);
        }
        bar();
        wS();
        if (this.fpT != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fpT);
        }
        if (this.foi != null && this.fou != null) {
            this.foi.removeView(this.foo);
            this.fou = null;
        }
        if (this.fpz != null) {
            this.fpz.clearStatus();
        }
        this.fqu = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.foK.qk(3);
        if (this.cZg != null) {
            this.cZg.setBackgroundDrawable(null);
        }
        if (this.fnS != null) {
            this.fnS.destroy();
        }
        if (this.foK != null) {
            this.foK.onDestroy();
        }
        this.foc.setOnLayoutListener(null);
        if (this.fqi != null) {
            this.fqi.arg();
        }
        if (this.fpK != null) {
            this.fpK.onDestroy();
        }
        baM();
    }

    public boolean qA(int i) {
        if (this.fnS != null) {
            return this.fnS.kr(i);
        }
        return false;
    }

    public void bar() {
        this.fnY.pr();
        if (this.fnV != null) {
            this.fnV.ahf();
        }
        com.baidu.adp.lib.util.l.b(this.fgM.getPageContext().getPageActivity(), this.foN);
        aZF();
        if (this.fpd != null) {
            this.fpd.dismiss();
        }
        bat();
        if (this.fnU != null) {
            this.fnU.bcp();
        }
        if (this.foL != null) {
            this.foL.dismiss();
        }
        if (this.cYS != null) {
            this.cYS.dismiss();
        }
    }

    public void bas() {
        this.fnY.pr();
        if (this.fnV != null) {
            this.fnV.ahf();
        }
        if (this.fpd != null) {
            this.fpd.dismiss();
        }
        bat();
        if (this.fnU != null) {
            this.fnU.bcp();
        }
        if (this.foL != null) {
            this.foL.dismiss();
        }
        if (this.cYS != null) {
            this.cYS.dismiss();
        }
    }

    public void cO(List<String> list) {
        this.fqh = list;
        if (this.fqi != null) {
            this.fqi.setData(list);
        }
    }

    public void jq(boolean z) {
        this.foK.jq(z);
    }

    public void kl(boolean z) {
        this.fpi = z;
    }

    public void bat() {
        if (this.foU != null) {
            this.foU.dismiss();
        }
        if (this.foV != null) {
            com.baidu.adp.lib.g.g.b(this.foV, this.fgM.getPageContext());
        }
        if (this.foW != null) {
            com.baidu.adp.lib.g.g.b(this.foW, this.fgM.getPageContext());
        }
        if (this.foS != null) {
            com.baidu.adp.lib.g.g.b(this.foS, this.fgM.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fkn, this.fhd);
            d(this.fkn, this.fhd, this.mType);
            this.fgM.getLayoutMode().setNightMode(i == 1);
            this.fgM.getLayoutMode().u(this.cHD);
            this.fgM.getLayoutMode().u(this.fod);
            com.baidu.tbadk.core.util.ak.i(this.fog, d.C0126d.cp_bg_line_d);
            if (this.fnU != null) {
                this.fnU.onChangeSkinType(i);
            }
            if (this.fof != null) {
                com.baidu.tbadk.core.util.ak.h(this.fof, d.C0126d.cp_cont_b);
                this.fof.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            }
            if (this.dbC != null) {
                this.dbC.dw(i);
                if (this.aJH != null) {
                    this.fgM.getLayoutMode().u(this.aJH);
                    com.baidu.tbadk.core.util.ak.i(this.aJH, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.foL != null) {
                this.foL.c(this.fgM.getPageContext());
            }
            kj(this.fpf);
            this.foK.notifyDataSetChanged();
            if (this.foO != null) {
                this.foO.dw(i);
            }
            if (this.JS != null) {
                this.JS.onChangeSkinType(i);
            }
            if (this.fot != null) {
                this.fot.dA(i);
            }
            if (this.foP != null) {
                this.foP.dw(i);
            }
            if (!com.baidu.tbadk.core.util.v.w(this.crd)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.crd) {
                    customBlueCheckRadioButton.wC();
                }
            }
            kf(i == 1);
            aZT();
            UtilHelper.setStatusBarBackground(this.cZg, i);
            UtilHelper.setStatusBarBackground(this.fpE, i);
            if (this.fov != null) {
                this.fov.onChangeSkinType(i);
            }
            if (this.foA != null) {
                com.baidu.tbadk.core.util.ak.h(this.foA, d.C0126d.cp_cont_d);
            }
            if (this.foz != null) {
                com.baidu.tbadk.core.util.ak.h(this.foz, d.C0126d.cp_cont_d);
            }
            if (this.foB != null) {
                com.baidu.tbadk.core.util.ak.i(this.foB, d.C0126d.cp_cont_e);
            }
            if (this.apF != null) {
                com.baidu.tbadk.core.util.ak.h(this.apF, d.C0126d.cp_cont_d);
            }
            if (this.foC != null) {
                com.baidu.tbadk.core.util.ak.i(this.foC, d.C0126d.cp_cont_e);
            }
            if (this.fol != null) {
                com.baidu.tbadk.core.util.ak.h(this.fol, d.C0126d.cp_link_tip_a);
            }
            if (this.foy != null) {
                com.baidu.tbadk.core.util.ak.h(this.foy, d.C0126d.cp_cont_d);
            }
            if (this.foD != null) {
                com.baidu.tbadk.n.a.a(this.fgM.getPageContext(), this.foD);
            }
            if (this.fpb != null) {
                com.baidu.tbadk.n.a.a(this.fgM.getPageContext(), this.fpb);
            }
            if (this.fpU != null) {
                this.fpU.onChangeSkinType(i);
            }
            if (this.fnY != null) {
                if (this.fnS != null) {
                    this.fnS.qG(i);
                } else {
                    this.fnY.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fpl != null) {
                com.baidu.tbadk.core.util.ak.h(this.fpl, d.C0126d.cp_cont_e);
            }
            if (this.fom != null) {
                com.baidu.tbadk.core.util.ak.c(this.fom, BitmapHelper.getGradeResourceIdInEnterForum(this.fqc));
            }
            if (this.fqj != null) {
                this.fqj.onChangeSkinType(i);
            }
            if (this.fpK != null) {
                this.fpK.onChangeSkinType();
            }
            if (this.fqg != null) {
                com.baidu.tbadk.core.util.ak.h(this.fqg, d.C0126d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWw = hVar;
        this.foK.setOnImageClickListener(this.aWw);
        this.fqj.setOnImageClickListener(this.aWw);
    }

    public void h(NoNetworkView.a aVar) {
        this.cVh = aVar;
        if (this.cHB != null) {
            this.cHB.a(this.cVh);
        }
    }

    public void km(boolean z) {
        this.foK.setIsFromCDN(z);
    }

    public Button bau() {
        return this.fpj;
    }

    public void bav() {
        if (this.fnX != 2) {
            this.foc.setNextPage(this.dbC);
            this.fnX = 2;
        }
    }

    public void baw() {
        if (com.baidu.tbadk.k.p.Ha().Hb()) {
            int lastVisiblePosition = this.foc.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.foc.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog = tbImageView.getPerfLog();
                                perfLog.fj(1001);
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
                        perfLog2.fj(1001);
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
        if (this.fpk != null) {
            kl(this.fgM.aWJ().Ek());
            if (this.fpi) {
                kc(z);
            } else {
                kd(z);
            }
        }
    }

    public void baA() {
        if (this.fpk != null) {
            this.fpk.setVisibility(8);
            this.fpp = false;
            if (this.fpK != null) {
                this.fpK.setVisibility(8);
                kh(false);
            }
            baM();
        }
    }

    public void showLoadingDialog() {
        if (this.cyp == null) {
            this.cyp = new com.baidu.tbadk.core.view.a(this.fgM.getPageContext());
        }
        this.cyp.aI(true);
    }

    public void aas() {
        if (this.cyp != null) {
            this.cyp.aI(false);
        }
    }

    private int getScrollY() {
        View childAt = this.foc.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.foc.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fnS != null) {
            this.fnS.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eGh = getScrollY();
            this.fpJ.fqQ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fpJ));
            a(this.fpJ.fqQ, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fnS != null) {
            this.fnS.b(absListView, i);
        }
        int headerViewsCount = (i - this.foc.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.foK.qj(headerViewsCount) == com.baidu.tieba.pb.data.j.fcI) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.foc.getHeaderViewsCount();
        if (this.fog != null && this.fnY != null) {
            this.fnY.g(this.fog.getBottom(), this.fog.getMeasuredHeight(), z2);
        }
        this.foK.aXR().j(z, this.fpC != null ? this.fpC.getMeasuredHeight() : 0);
        this.fpJ.eXE = i;
        this.fpJ.headerCount = this.foc.getHeaderViewsCount();
        this.fpJ.fqQ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fpJ));
        a(this.fpJ.fqQ, false);
    }

    public void baB() {
        if (this.fgM.isLogin() && this.fkn != null && this.fpZ && !this.fpY && !this.fpg && this.fpu != null && this.fpu.rQ() != null && !this.fpu.rQ().getIsLike() && !this.fpu.rQ().hadConcerned()) {
            if (this.fpV == null) {
                this.fpV = new am(this.fgM);
            }
            this.fpV.a(this.fnY.fsZ, this.fkn.aVQ(), this.fpu.rQ().getUserId(), this.fkn.getThreadId());
        }
    }

    public void baC() {
        if (this.fpZ && !this.fpY && this.fpu != null && this.fpu.rQ() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12601").r("obj_locate", this.fgM.aXy() ? 2 : 1).r("obj_type", this.fpY ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fgM.getPageContext().getPageActivity(), this.fpu.rQ().getUserId(), this.fpu.rQ().getUserName(), this.fgM.aWx().aYi(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fpY && this.fpD != null && this.fnY.bbf() != null) {
            int aXO = this.foK.aXO();
            if (aXO > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (aXO > this.foc.getFirstVisiblePosition() - this.foc.getHeaderViewsCount()) {
                    this.fpD.setVisibility(8);
                    return;
                }
                this.fpD.setVisibility(0);
                this.fnY.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fng == null) {
                if (this.foc.getFirstVisiblePosition() == 0) {
                    this.fpD.setVisibility(8);
                    this.fnY.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fpI) {
                        this.fpH = top;
                        this.fpI = false;
                    }
                    this.fpH = top < this.fpH ? top : this.fpH;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.foJ.getY() < 0.0f) {
                        measuredHeight = fpG - akVar.fng.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fnY.bbf().getMeasuredHeight() - akVar.fng.getMeasuredHeight();
                        this.fnY.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fpH) {
                        this.fpD.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fpD.setVisibility(0);
                    } else {
                        this.fpD.setVisibility(8);
                        this.fnY.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fpI = true;
                    }
                }
            }
        }
    }

    public void baD() {
        if (!this.fqC) {
            TiebaStatic.log("c10490");
            this.fqC = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fgM.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fpN, Integer.valueOf(fpP));
            aVar.bZ(d.k.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.k.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.k.grade_thread_tips);
            aVar.w(inflate);
            aVar.z(sparseArray);
            aVar.a(d.k.grade_button_tips, this.fgM);
            aVar.b(d.k.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fgM.getPageContext()).tD();
        }
    }

    public void qD(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fgM.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.w(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fpN, Integer.valueOf(fpQ));
        aVar.z(sparseArray);
        aVar.a(d.k.view, this.fgM);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fgM.getPageContext()).tD();
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
        return this.fpz;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aVs() != null && dVar.aVs().sF() && this.fpz == null) {
            this.fpz = (PbInterviewStatusView) this.fpy.inflate();
            this.fpz.setOnClickListener(this.cYT);
            this.fpz.setCallback(this.fgM.aXt());
            this.fpz.setData(this.fgM, dVar);
        }
    }

    public LinearLayout baF() {
        return this.foJ;
    }

    public View baG() {
        return this.cZg;
    }

    public boolean baH() {
        return this.fqo;
    }

    public void jv(boolean z) {
        this.foh.jv(z);
    }

    public void qE(String str) {
        if (this.fnZ != null) {
            this.fnZ.setTitle(str);
        }
    }

    private int ko(boolean z) {
        if (this.fpz == null || this.fpz.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void baI() {
        if (this.fpz != null && this.fpz.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpz.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fpz.setLayoutParams(layoutParams);
        }
    }

    public boolean aWP() {
        return false;
    }

    public void qF(String str) {
        this.fpl.performClick();
        if (!StringUtils.isNull(str) && this.fgM.aWJ() != null && this.fgM.aWJ().Ee() != null && this.fgM.aWJ().Ee().getInputView() != null) {
            EditText inputView = this.fgM.aWJ().Ee().getInputView();
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
            if (this.fpU != null) {
                this.fpU.aXV();
            }
            this.fgM.apD();
            this.foJ.setVisibility(8);
            this.fnY.kA(false);
            this.fgM.jB(false);
            if (this.fnS != null) {
                if (configuration.orientation == 1) {
                    baF().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.foc.setIsLandscape(true);
                    this.foc.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.foc.setIsLandscape(false);
                    if (this.eGh > 0) {
                        this.foc.smoothScrollBy(this.eGh, 0);
                    }
                }
                this.fnS.onConfigurationChanged(configuration);
            }
        }
    }

    public void kp(boolean z) {
        this.fnW = z;
    }

    public boolean baJ() {
        return this.fnS != null && this.fnS.baJ();
    }

    public void baK() {
        if (this.fnS != null) {
            this.fnS.onPause();
        }
    }

    public void z(long j, int i) {
        if (this.fnU != null) {
            this.fnU.z(j, i);
        }
        if (this.fnS != null) {
            this.fnS.z(j, i);
        }
    }

    public void jG(boolean z) {
        this.foK.jG(z);
    }

    public void baL() {
        if (this.fpA == null) {
            LayoutInflater.from(this.fgM.getActivity()).inflate(d.i.add_experienced_text, (ViewGroup) this.cHD, true);
            this.fpA = (ViewGroup) this.cHD.findViewById(d.g.add_experienced_layout);
            this.fpB = (TextView) this.cHD.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.ak.h(this.fpB, d.C0126d.cp_cont_i);
            String string = this.fgM.getResources().getString(d.k.experienced_add_success);
            String string2 = this.fgM.getResources().getString(d.k.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_h)));
            this.fpB.setText(spannableString);
        }
        this.fpA.setVisibility(0);
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
                        as.this.fpA.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                as.this.fpB.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fpB.startAnimation(scaleAnimation);
    }

    public void bf(final View view2) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fpk.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view2.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fgM);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fqg = new TextView(this.fgM);
            this.fqg.setText(d.k.connection_tips);
            this.fqg.setGravity(17);
            this.fqg.setPadding(com.baidu.adp.lib.util.l.e(this.fgM, d.e.ds24), 0, com.baidu.adp.lib.util.l.e(this.fgM, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.fgM, d.e.ds60);
            if (this.fqg.getParent() == null) {
                frameLayout.addView(this.fqg, layoutParams);
            }
            this.fqf = new PopupWindow(this.fgM);
            this.fqf.setContentView(frameLayout);
            this.fqf.setHeight(-2);
            this.fqf.setWidth(-2);
            this.fqf.setFocusable(true);
            this.fqf.setOutsideTouchable(false);
            this.fqf.setBackgroundDrawable(new ColorDrawable(this.fgM.getResources().getColor(d.C0126d.transparent)));
            this.foc.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        as.this.fqf.showAsDropDown(as.this.fpk, view2.getLeft(), -as.this.fpk.getHeight());
                    } else {
                        as.this.fqf.showAsDropDown(view2);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.baW() != null && !StringUtils.isNull(aVar.baW().pkg_id) && !StringUtils.isNull(aVar.baW().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fpm != null && this.fpm.getVisibility() == 0) {
            if (this.fqe == null) {
                View inflate = LayoutInflater.from(this.fgM.getPageContext().getPageActivity()).inflate(d.i.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.k.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.cYT);
                this.fqe = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fpm.getLocationInWindow(iArr);
            this.fqe.showAtLocation(this.fpm, 0, iArr[0] - com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fpm.getHeight()) - com.baidu.adp.lib.util.l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void baM() {
        com.baidu.adp.lib.g.g.a(this.fqe);
    }

    public void kq(boolean z) {
        this.fql = z;
    }

    public boolean baN() {
        return this.fql;
    }

    public void bg(View view2) {
        this.fpb = view2;
    }
}
