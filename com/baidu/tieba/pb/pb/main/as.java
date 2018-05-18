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
    private static final int fqK = UtilHelper.getLightStatusBarHeight();
    public static int fqQ = 3;
    public static int fqR = 0;
    public static int fqS = 3;
    public static int fqT = 4;
    public static int fqU = 5;
    public static int fqV = 6;
    private EditorTools JO;
    private View aJI;
    private com.baidu.tieba.pb.a.c aWy;
    private e.b anZ;
    private TextView apF;
    private TextView azb;
    private NoNetworkView cIH;
    private RelativeLayout cIJ;
    private View.OnClickListener cZX;
    private List<CustomBlueCheckRadioButton> csj;
    private View dak;
    private PbListView dcH;
    private NavigationBarCoverTip dsc;
    private int eHm;
    PbActivity.d fgV;
    private PbActivity fhQ;
    private View.OnClickListener fip;
    private UserIconBox fjj;
    private UserIconBox fjk;
    private PbFakeFloorModel fkm;
    private com.baidu.tieba.pb.data.d flr;
    public int foW;
    private com.baidu.tieba.pb.video.i foX;
    private long foY;
    private com.baidu.tieba.pb.video.h foZ;
    private PbFirstFloorUserLikeButton fpA;
    private aq fpB;
    private aq fpC;
    private TextView fpD;
    private TextView fpE;
    private TextView fpF;
    private View fpG;
    private View fpH;
    private LinearLayout fpI;
    private TextView fpJ;
    private TextView fpK;
    private View fpL;
    private View fpM;
    private ObservedChangeLinearLayout fpO;
    private f fpP;
    private View fpV;
    private com.baidu.tieba.d.c fpa;
    public final com.baidu.tieba.pb.pb.main.view.b fpd;
    public com.baidu.tieba.pb.pb.main.view.a fpe;
    private ViewStub fpf;
    private ViewStub fpg;
    private PbLandscapeListView fph;
    private View fpi;
    private LinearLayout fpl;
    private e fpm;
    private ColumnLayout fpn;
    private ThreadSkinView fpo;
    private TextView fpp;
    private TextView fpq;
    private ImageView fpr;
    private HeadPendantView fpt;
    private FrameLayout fpu;
    private HeadImageView fpv;
    private View fpw;
    private FloatingLayout fpx;
    private View fqA;
    private TextView fqB;
    private ViewStub fqC;
    private PbInterviewStatusView fqD;
    private ViewGroup fqE;
    private TextView fqF;
    private FrameLayout fqG;
    private View fqH;
    private View fqI;
    private ak fqJ;
    private PbEmotionBar fqO;
    private int fqW;
    private Runnable fqX;
    private r fqY;
    private am fqZ;
    private View fqp;
    private TextView fqq;
    private ImageView fqr;
    private ImageView fqs;
    private TextView fqt;
    private boolean fqv;
    private int fqw;
    private int fqx;
    private PostData fqy;
    private Runnable frA;
    private PbActivity.b frC;
    private int frf;
    private PbTopTipView frh;
    private PopupWindow fri;
    private PopupWindow frj;
    private TextView frk;
    private List<String> frl;
    private com.baidu.tieba.pb.pb.main.emotion.c frm;
    private com.baidu.tieba.pb.pb.godreply.a frn;
    private PbLandscapeListView.b fro;
    private ab frq;
    private boolean frt;
    private com.baidu.tbadk.core.view.userLike.c fru;
    private com.baidu.tbadk.core.view.userLike.c frv;
    private boolean isLandscape;
    private View mFooterView;
    private int mType;
    private boolean fpb = false;
    private int fpc = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fpj = null;
    private TextView fpk = null;
    public FrsPraiseView fpy = null;
    private ClickableHeaderImageView fpz = null;
    private View fpN = null;
    private com.baidu.tbadk.core.dialog.a fpQ = null;
    private com.baidu.tbadk.core.dialog.b cZW = null;
    private View fpR = null;
    private EditText fpS = null;
    private com.baidu.tieba.pb.view.e fpT = null;
    private com.baidu.tieba.pb.view.a fpU = null;
    private com.baidu.tbadk.core.dialog.a fpW = null;
    private b.InterfaceC0086b ecN = null;
    private TbRichTextView.h aWx = null;
    private NoNetworkView.a cWl = null;
    private Dialog fpX = null;
    private View fpY = null;
    private com.baidu.tbadk.core.dialog.a fpZ = null;
    private Dialog fqa = null;
    private Dialog fqb = null;
    private View fqc = null;
    private LinearLayout fqd = null;
    private CompoundButton.OnCheckedChangeListener csk = null;
    private TextView fqe = null;
    private TextView fqf = null;
    private View fqg = null;
    private String fqh = null;
    private com.baidu.tbadk.core.dialog.b fqi = null;
    private com.baidu.tbadk.core.dialog.b fqj = null;
    private boolean fqk = false;
    private boolean fql = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fqm = null;
    private boolean fqn = false;
    private Button fqo = null;
    private boolean fqu = true;
    private com.baidu.tbadk.core.view.a czv = null;
    private boolean fii = false;
    private int mSkinType = 3;
    private boolean fqz = false;
    private int fqL = 0;
    private boolean fqM = true;
    private a fqN = new a();
    private int fqP = 0;
    private boolean fra = false;
    private int frb = 0;
    private boolean frc = false;
    private boolean frd = false;
    private boolean fre = false;
    private int frg = 0;
    private boolean frp = false;
    private a.InterfaceC0215a frr = new a.InterfaceC0215a() { // from class: com.baidu.tieba.pb.pb.main.as.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0215a
        public void onRefresh() {
        }
    };
    private String frw = null;
    private CustomMessageListener frx = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.as.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                as.this.frw = null;
            }
        }
    };
    private CustomMessageListener bns = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.as.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && as.this.fpP != null) {
                as.this.fpP.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fry = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.as.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (as.this.fpk != null) {
                as.this.fpk.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler frz = new Handler();
    private CustomMessageListener frB = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.as.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                as.this.fqu = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean frD = true;
    View.OnClickListener frE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (as.this.frc) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11923").r(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (as.this.fpd != null && as.this.fpd.fuf != null && view2 == as.this.fpd.fuf.getHeadView()) {
                if (as.this.fpd.fud == null || as.this.fpd.fud.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12506").r("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!as.this.frc && as.this.flr != null && as.this.flr.aVs() != null && as.this.flr.aVs().rP() != null && as.this.flr.aVs().rP().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12151").r("obj_locate", 1));
            }
            as.this.fhQ.ffT.fto.onClick(view2);
        }
    };
    private boolean frF = false;
    String userId = null;
    private final List<TbImageView> frG = new ArrayList();
    private boolean frH = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int eYI;
        public ak frV;
        public int headerCount;
    }

    public void kc(boolean z) {
        this.fra = z;
        if (this.fph != null) {
            this.frb = this.fph.getHeaderViewsCount();
        }
    }

    public void aZD() {
        if (this.fph != null) {
            int headerViewsCount = this.fph.getHeaderViewsCount() - this.frb;
            final int firstVisiblePosition = (this.fph.getFirstVisiblePosition() == 0 || this.fph.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fph.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fph.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fqN.frV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fqN));
            final ak akVar = this.fqN.frV;
            final int h = h(akVar);
            final int y = ((int) this.fpO.getY()) + this.fpO.getMeasuredHeight();
            final boolean z = this.fqH.getVisibility() == 0;
            boolean z2 = this.fpO.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.fpP.aXO() + this.fph.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fok.getMeasuredHeight() : 0;
                if (z2) {
                    this.fph.setSelectionFromTop(this.fpP.aXO() + this.fph.getHeaderViewsCount(), fqK - measuredHeight);
                } else {
                    this.fph.setSelectionFromTop(this.fpP.aXO() + this.fph.getHeaderViewsCount(), this.fpd.bbf().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fph.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.frc) {
                this.fph.setSelectionFromTop(this.fpP.aXO() + this.fph.getHeaderViewsCount(), this.foX.bcw().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fph.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.as.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aYf() {
                        if (h >= 0 && h <= as.this.cIJ.getMeasuredHeight()) {
                            int h2 = as.this.h(akVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = as.this.mFooterView.getLayoutParams();
                            if (i == 0 || i > as.this.cIJ.getMeasuredHeight() || h2 >= as.this.cIJ.getMeasuredHeight()) {
                                layoutParams.height = as.this.fqW;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > as.this.cIJ.getMeasuredHeight()) {
                                layoutParams.height = as.this.fqW;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                as.this.fph.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            as.this.mFooterView.setLayoutParams(layoutParams);
                        }
                        as.this.fph.setOnLayoutListener(null);
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
        return this.cIH;
    }

    public void aZF() {
        if (this.JO != null) {
            this.JO.hide();
            if (this.frm != null) {
                this.frm.OI();
            }
        }
    }

    public PbFakeFloorModel aZG() {
        return this.fkm;
    }

    public r aZH() {
        return this.fqY;
    }

    public void aZI() {
        reset();
        aZF();
        this.fqY.aXV();
        ko(false);
    }

    private void reset() {
        if (this.fhQ != null && this.fhQ.aWJ() != null && this.JO != null) {
            com.baidu.tbadk.editortools.pb.a.DZ().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aWJ = this.fhQ.aWJ();
            aWJ.Er();
            aWJ.DN();
            if (aWJ.getWriteImagesInfo() != null) {
                aWJ.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aWJ.eO(SendView.ALL);
            aWJ.eP(SendView.ALL);
            com.baidu.tbadk.editortools.g eF = this.JO.eF(23);
            com.baidu.tbadk.editortools.g eF2 = this.JO.eF(2);
            com.baidu.tbadk.editortools.g eF3 = this.JO.eF(5);
            if (eF2 != null) {
                eF2.lM();
            }
            if (eF3 != null) {
                eF3.lM();
            }
            if (eF != null) {
                eF.hide();
            }
            this.JO.invalidate();
        }
    }

    public boolean aZJ() {
        return this.fqu;
    }

    public void kd(boolean z) {
        if (this.fqp != null && this.fqq != null) {
            this.fqq.setText(d.k.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fqp.startAnimation(alphaAnimation);
            }
            this.fqp.setVisibility(0);
            this.fqu = true;
            if (this.fqO != null && !this.frn.isActive()) {
                this.fqO.setVisibility(0);
                ki(true);
            }
        }
    }

    public void ke(boolean z) {
        if (this.fqp != null && this.fqq != null) {
            this.fqq.setText(d.k.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fqp.startAnimation(alphaAnimation);
            }
            this.fqp.setVisibility(0);
            this.fqu = true;
            if (this.fqO != null && !this.frn.isActive()) {
                this.fqO.setVisibility(0);
                ki(true);
            }
        }
    }

    public PostData aZK() {
        int i = 0;
        if (this.fph == null) {
            return null;
        }
        int aZL = aZL() - this.fph.getHeaderViewsCount();
        if (aZL < 0) {
            aZL = 0;
        }
        if (this.fpP.qh(aZL) != null && this.fpP.qh(aZL) != PostData.gxv) {
            i = aZL + 1;
        }
        return this.fpP.getItem(i) instanceof PostData ? (PostData) this.fpP.getItem(i) : null;
    }

    public int aZL() {
        int i;
        View childAt;
        if (this.fph == null) {
            return 0;
        }
        int firstVisiblePosition = this.fph.getFirstVisiblePosition();
        int lastVisiblePosition = this.fph.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fph.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fph.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        return this.fph.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.flr != null && this.flr.aVu() != null && !this.flr.aVu().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.flr.aVu().size() && (postData = this.flr.aVu().get(i)) != null && postData.rP() != null && !StringUtils.isNull(postData.rP().getUserId()); i++) {
                if (this.flr.aVu().get(i).rP().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.frn != null && this.frn.isActive()) {
                        ko(false);
                    }
                    if (this.fqO != null) {
                        this.fqO.kv(true);
                    }
                    this.frw = postData.rP().getName_show();
                    return;
                }
            }
        }
    }

    public as(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fhQ = null;
        this.cIJ = null;
        this.dak = null;
        this.foY = 0L;
        this.fph = null;
        this.fpi = null;
        this.fpl = null;
        this.fpn = null;
        this.fpp = null;
        this.fpq = null;
        this.fpu = null;
        this.fpv = null;
        this.fpw = null;
        this.fpA = null;
        this.fpD = null;
        this.fpE = null;
        this.fpF = null;
        this.fpG = null;
        this.fpL = null;
        this.fpM = null;
        this.fpP = null;
        this.dcH = null;
        this.aJI = null;
        this.cZX = null;
        this.fip = null;
        this.fqp = null;
        this.fqq = null;
        this.fqr = null;
        this.fqs = null;
        this.fqt = null;
        this.fqA = null;
        this.fqB = null;
        this.fqC = null;
        this.frf = 0;
        this.foY = System.currentTimeMillis();
        this.fhQ = pbActivity;
        this.cZX = onClickListener;
        this.aWy = cVar;
        this.frf = com.baidu.adp.lib.util.l.af(this.fhQ) / 2;
        this.cIJ = (RelativeLayout) LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.new_pb_activity, (ViewGroup) null);
        this.fhQ.addContentView(this.cIJ, new FrameLayout.LayoutParams(-1, -1));
        this.dsc = (NavigationBarCoverTip) this.fhQ.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dak = this.fhQ.findViewById(d.g.statebar_view);
        this.fpO = (ObservedChangeLinearLayout) this.fhQ.findViewById(d.g.title_wrapper);
        this.cIH = (NoNetworkView) this.fhQ.findViewById(d.g.view_no_network);
        this.fph = (PbLandscapeListView) this.fhQ.findViewById(d.g.new_pb_list);
        this.fqG = (FrameLayout) this.fhQ.findViewById(d.g.root_float_header);
        this.azb = new TextView(this.fhQ.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds88));
        this.fph.addHeaderView(this.azb, 0);
        this.fqW = this.fhQ.getResources().getDimensionPixelSize(d.e.tbds134);
        this.mFooterView = new View(this.fhQ.getPageContext().getPageActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, this.fqW));
        this.mFooterView.setVisibility(4);
        this.fph.addFooterView(this.mFooterView);
        this.fph.setOnTouchListener(this.fhQ.aNL);
        this.fpd = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fhQ.aXl()) {
            this.fpf = (ViewStub) this.fhQ.findViewById(d.g.manga_view_stub);
            this.fpf.setVisibility(0);
            this.fpe = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fpe.show();
            this.fpd.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds120);
        }
        this.azb.setLayoutParams(layoutParams);
        this.fpd.bbf().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0187a() { // from class: com.baidu.tieba.pb.pb.main.as.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0187a
            public void aWl() {
                if (as.this.fph != null) {
                    if (as.this.foX != null) {
                        as.this.foX.bcx();
                    }
                    as.this.fph.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0187a
            public void aWm() {
                as.this.fhQ.apC();
            }
        }));
        this.fqp = this.fhQ.findViewById(d.g.pb_editor_tool_comment);
        this.fqw = com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds90);
        this.fqx = com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds242);
        this.fqq = (TextView) this.fhQ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fqs = (ImageView) this.fhQ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fqr = (ImageView) this.fhQ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fqt = (TextView) this.fhQ.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fqt.setVisibility(8);
        this.fqq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (!as.this.fhQ.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, as.this.mForumId));
                } else if (as.this.fhQ.aWT()) {
                    com.baidu.tbadk.editortools.pb.d aWJ = as.this.fhQ.aWJ();
                    if (aWJ == null || (!aWJ.Eo() && !aWJ.Ep())) {
                        if (as.this.JO != null) {
                            as.this.aZW();
                        }
                        if (as.this.JO != null) {
                            as.this.fqu = false;
                            if (as.this.JO.eI(2) != null) {
                                com.baidu.tieba.tbadkCore.b.a.a(as.this.fhQ, (View) as.this.JO.eI(2).aCN, false, as.this.frr);
                            }
                        }
                        as.this.baA();
                        return;
                    }
                    as.this.fhQ.aWJ().a(false, (PostWriteCallBackData) null);
                }
            }
        });
        this.fqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (as.this.fhQ.checkUpIsLogin()) {
                    if (as.this.JO != null) {
                        as.this.aZW();
                        as.this.JO.M((View) as.this.JO.eF(5));
                    }
                    if (as.this.JO != null) {
                        as.this.fqu = false;
                        if (as.this.JO.eI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fhQ, (View) as.this.JO.eI(2).aCN, false, as.this.frr);
                        }
                    }
                    as.this.baA();
                }
            }
        });
        this.fqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                as.this.baM();
                if (as.this.fhQ.checkUpIsLogin()) {
                    if (as.this.JO != null) {
                        as.this.aZW();
                        as.this.JO.M((View) as.this.JO.eF(2));
                    }
                    if (as.this.JO != null) {
                        as.this.fqu = false;
                        if (as.this.JO.eI(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fhQ, (View) as.this.JO.eI(2).aCN, false, as.this.frr);
                        }
                    }
                    as.this.baA();
                }
            }
        });
        this.fqt.setOnClickListener(this.cZX);
        this.fqt.setOnTouchListener(this.fhQ);
        this.fpi = LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_item, (ViewGroup) null);
        this.fpl = (LinearLayout) LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.ak.i(this.fpl, d.C0126d.cp_bg_line_d);
        this.fpm = new e(this.fhQ, this.fpl);
        this.fpm.init();
        this.fpm.a(this.fpm.aWI(), this.cZX);
        this.fpn = (ColumnLayout) this.fpl.findViewById(d.g.pb_head_owner_root);
        this.fpo = (ThreadSkinView) this.fpl.findViewById(d.g.pb_thread_skin);
        this.fpn.setOnLongClickListener(this.onLongClickListener);
        this.fpn.setOnTouchListener(this.aWy);
        this.fpn.setVisibility(8);
        this.fpi.setOnTouchListener(this.aWy);
        this.fqA = this.fpi.findViewById(d.g.pb_head_activity_join_number_container);
        this.fqA.setVisibility(8);
        this.fqB = (TextView) this.fpi.findViewById(d.g.pb_head_activity_join_number);
        this.fpp = (TextView) this.fpn.findViewById(d.g.pb_head_owner_info_user_name);
        this.fpq = (TextView) this.fpn.findViewById(d.g.floor_owner);
        this.fpr = (ImageView) this.fpn.findViewById(d.g.icon_forum_level);
        this.fpu = (FrameLayout) this.fpn.findViewById(d.g.pb_head_headImage_container);
        this.fpv = (HeadImageView) this.fpn.findViewById(d.g.pb_head_owner_photo);
        this.fpt = (HeadPendantView) this.fpn.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fpt.setHasPendantStyle();
        if (this.fpt.getHeadView() != null) {
            this.fpt.getHeadView().setIsRound(true);
            this.fpt.getHeadView().setDrawBorder(false);
        }
        this.fjj = (UserIconBox) this.fpn.findViewById(d.g.show_icon_vip);
        this.fjk = (UserIconBox) this.fpn.findViewById(d.g.show_icon_yinji);
        this.fpx = (FloatingLayout) this.fpl.findViewById(d.g.pb_head_owner_info_root);
        this.fpA = (PbFirstFloorUserLikeButton) this.fpn.findViewById(d.g.pb_like_button);
        this.fpD = (TextView) this.fpn.findViewById(d.g.pb_views);
        this.apF = (TextView) this.fpn.findViewById(d.g.view_forum_name);
        this.fpH = this.fpn.findViewById(d.g.line_right_forum_name);
        this.fpE = (TextView) this.fpn.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fpF = (TextView) this.fpn.findViewById(d.g.pb_item_first_floor_location_address);
        this.fpG = this.fpn.findViewById(d.g.line_between_time_and_locate);
        this.fru = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.frv = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fpL = this.fpi.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fpM = this.fpi.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fpi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return false;
            }
        });
        this.fqC = (ViewStub) this.cIJ.findViewById(d.g.interview_status_stub);
        this.fpP = new f(this.fhQ, this.fph);
        this.fpP.t(this.cZX);
        this.fpP.setTbGestureDetector(this.aWy);
        this.fpP.setOnImageClickListener(this.aWx);
        this.fip = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.b(as.this.fhQ.getBaseContext(), as.this.fhQ.aWx().aYj(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                as.this.fhQ.b(sparseArray);
                                return;
                            }
                            as.this.be(view2);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        as.this.fhQ.b(sparseArray);
                    } else if (booleanValue3) {
                        as.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fpP.F(this.fip);
        aZR();
        this.fph.addHeaderView(this.fpj);
        this.fph.addHeaderView(this.fpl);
        this.fph.addHeaderView(this.fpi);
        this.dcH = new PbListView(this.fhQ.getPageContext().getPageActivity());
        this.aJI = this.dcH.getView().findViewById(d.g.pb_more_view);
        if (this.aJI != null) {
            this.aJI.setOnClickListener(this.cZX);
            com.baidu.tbadk.core.util.ak.i(this.aJI, d.f.pb_foot_more_trans_selector);
        }
        this.dcH.wM();
        this.dcH.setBackground(d.f.pb_foot_more_trans_selector);
        this.dcH.dv(d.f.pb_foot_more_trans_selector);
        this.fpV = this.fhQ.findViewById(d.g.viewstub_progress);
        this.fhQ.registerListener(this.frB);
        this.fpw = com.baidu.tbadk.ala.b.or().f(this.fhQ.getActivity(), 2);
        if (this.fpw != null) {
            this.fpw.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fhQ.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fpw.getParent() == null) {
                this.fpx.addView(this.fpw, aVar);
            }
        }
        this.fkm = new PbFakeFloorModel(this.fhQ.getPageContext());
        this.fqY = new r(this.fhQ.getPageContext(), this.fkm, this.cIJ);
        this.fqY.a(this.fhQ.fgR);
        this.fkm.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.as.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                as.this.fkm.l(postData);
                as.this.fpP.notifyDataSetChanged();
                as.this.fqY.aXV();
                as.this.JO.BY();
                as.this.ko(false);
            }
        });
        if (this.fhQ.aWx() != null && !StringUtils.isNull(this.fhQ.aWx().aYO())) {
            this.fhQ.showToast(this.fhQ.aWx().aYO());
        }
        this.fqH = this.fhQ.findViewById(d.g.pb_expand_blank_view);
        this.fqI = this.fhQ.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fqI.getLayoutParams();
        if (this.fhQ.aWx() != null && this.fhQ.aWx().aYm()) {
            this.fqH.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fqI.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fqK;
            this.fqI.setLayoutParams(layoutParams2);
        }
        this.fqJ = new ak(this.fhQ.getPageContext(), this.fhQ.findViewById(d.g.pb_reply_expand_view));
        this.fqJ.fok.setVisibility(8);
        this.fqJ.H(this.cZX);
        this.fhQ.registerListener(this.bns);
        this.fhQ.registerListener(this.frx);
        this.fhQ.registerListener(this.fry);
        aZN();
        ki(false);
    }

    private void aZN() {
        this.frn = new com.baidu.tieba.pb.pb.godreply.a(this.fhQ, this, (ViewStub) this.cIJ.findViewById(d.g.more_god_reply_popup));
        this.frn.n(this.cZX);
        this.frn.F(this.fip);
        this.frn.setOnImageClickListener(this.aWx);
        this.frn.n(this.cZX);
        this.frn.setTbGestureDetector(this.aWy);
    }

    public com.baidu.tieba.pb.pb.godreply.a aZO() {
        return this.frn;
    }

    public View aZP() {
        return this.fqH;
    }

    public void aZQ() {
        if (this.fph != null) {
            this.fph.removeHeaderView(this.fpj);
            this.fph.removeHeaderView(this.fpl);
            this.fph.removeHeaderView(this.fpi);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fqO == null) {
            this.fqO = new PbEmotionBar(this.fhQ.getPageContext().getPageActivity());
            ki(true);
            this.fqO.a(this.cIJ, aVar, this.fqp.getVisibility() == 0);
            this.fqO.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.as.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (as.this.fhQ.aWT()) {
                        if (!StringUtils.isNull(as.this.frw)) {
                            emotionImageData.setAuthorNameShow(as.this.frw);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    as.this.fhQ.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(as.this.fhQ.getPageContext().getPageActivity(), 25016, str, list, as.this.frw, list2)));
                }
            });
            this.fqO.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.as.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    as.this.baM();
                    if (as.this.fqp != null) {
                        ViewGroup.LayoutParams layoutParams = as.this.fqp.getLayoutParams();
                        layoutParams.height = (int) (((as.this.fqx - as.this.fqw) * f) + as.this.fqw);
                        as.this.fqq.setAlpha(1.0f - f);
                        as.this.fqs.setAlpha(1.0f - f);
                        as.this.fqr.setAlpha(1.0f - f);
                        as.this.fqp.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aZR() {
        if (this.fpj == null) {
            int e = com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.tbds44);
            this.fpj = new LinearLayout(this.fhQ.getPageContext().getPageActivity());
            this.fpj.setOrientation(1);
            this.fpj.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fpj.setPadding(e, com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.tbds30), e, com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.tbds40));
            this.fpj.setGravity(17);
            this.fpk = new TextView(this.fhQ.getPageContext().getPageActivity());
            this.fpk.setGravity(3);
            this.fpk.setMaxLines(2);
            this.fpk.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            this.fpk.setPadding(0, 0, 0, 0);
            this.fpk.setLineSpacing(com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.ak.h(this.fpk, d.C0126d.cp_cont_b);
            this.fpk.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fpk.setVisibility(8);
            if (this.fpk.getParent() == null) {
                this.fpj.addView(this.fpk);
            }
            this.fpj.setOnTouchListener(this.aWy);
            this.fpj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZS() {
        if (this.fhQ.aXl()) {
            this.fpg = (ViewStub) this.fhQ.findViewById(d.g.manga_mention_controller_view_stub);
            this.fpg.setVisibility(0);
            if (this.fpI == null) {
                this.fpI = (LinearLayout) this.fhQ.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fhQ.getPageContext(), this.fpI);
            }
            if (this.fpJ == null) {
                this.fpJ = (TextView) this.fpI.findViewById(d.g.manga_prev_btn);
            }
            if (this.fpK == null) {
                this.fpK = (TextView) this.fpI.findViewById(d.g.manga_next_btn);
            }
            this.fpJ.setOnClickListener(this.cZX);
            this.fpK.setOnClickListener(this.cZX);
        }
    }

    private void aZT() {
        if (this.fhQ.aXl()) {
            if (this.fhQ.aXo() == -1) {
                com.baidu.tbadk.core.util.ak.c(this.fpJ, d.C0126d.cp_cont_e, 1);
            }
            if (this.fhQ.aXp() == -1) {
                com.baidu.tbadk.core.util.ak.c(this.fpK, d.C0126d.cp_cont_e, 1);
            }
        }
    }

    public void aZU() {
        if (this.fpI == null) {
            aZS();
        }
        this.fpg.setVisibility(8);
        if (this.frz != null && this.frA != null) {
            this.frz.removeCallbacks(this.frA);
        }
    }

    public void aZV() {
        if (this.frz != null) {
            if (this.frA != null) {
                this.frz.removeCallbacks(this.frA);
            }
            this.frA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.this.fpI == null) {
                        as.this.aZS();
                    }
                    as.this.fpg.setVisibility(0);
                }
            };
            this.frz.postDelayed(this.frA, 2000L);
        }
    }

    public void kf(boolean z) {
        this.fpd.kf(z);
        if (z && this.fqz) {
            this.dcH.setText(this.fhQ.getResources().getString(d.k.click_load_more));
            this.fph.setNextPage(this.dcH);
            this.fpc = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.JO = editorTools;
        this.JO.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.JO.getParent() == null) {
            this.cIJ.addView(this.JO, layoutParams);
        }
        this.JO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aZF();
        this.fhQ.aWJ().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.as.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (as.this.JO != null && as.this.JO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (as.this.frm == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, as.this.JO.getId());
                            as.this.frm = new com.baidu.tieba.pb.pb.main.emotion.c(as.this.fhQ.getPageContext(), as.this.cIJ, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.w(as.this.frl)) {
                                as.this.frm.setData(as.this.frl);
                            }
                            as.this.frm.b(as.this.JO);
                        }
                        as.this.frm.qM(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (as.this.fhQ.ffX != null && as.this.fhQ.ffX.baQ() != null) {
                    if (!as.this.fhQ.ffX.baQ().bAV()) {
                        as.this.fhQ.ffX.ks(false);
                    }
                    as.this.fhQ.ffX.baQ().nk(false);
                }
            }
        });
    }

    public void aZW() {
        if (this.fhQ != null && this.JO != null) {
            this.JO.lM();
            baA();
        }
    }

    public void M(String str, boolean z) {
        this.fqv = z;
        kg(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kg(boolean z) {
        if (this.fqt != null) {
            if (this.fqv) {
                com.baidu.tbadk.core.util.ak.i(this.fqt, d.f.pb_praise_already_click_selector);
                this.fqt.setContentDescription(this.fhQ.getResources().getString(d.k.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.ak.i(this.fqt, d.f.pb_praise_normal_click_selector);
            this.fqt.setContentDescription(this.fhQ.getResources().getString(d.k.zan));
        }
    }

    public TextView aZX() {
        return this.fqt;
    }

    public void kh(boolean z) {
        if (this.fph != null && this.azb != null && this.dak != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dak.setVisibility(0);
                } else {
                    this.dak.setVisibility(8);
                    this.fph.removeHeaderView(this.azb);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.azb.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fqK;
                    this.azb.setLayoutParams(layoutParams);
                }
                bal();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.azb.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kp(true);
                this.azb.setLayoutParams(layoutParams2);
            }
            bal();
            baI();
        }
    }

    public f aZY() {
        return this.fpP;
    }

    public void a(PbActivity.d dVar) {
        this.fgV = dVar;
    }

    public void be(View view2) {
        SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fpY == null) {
            this.fpY = LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
        }
        this.fhQ.getLayoutMode().u(this.fpY);
        if (this.fpX == null) {
            this.fpX = new Dialog(this.fhQ.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fpX.setCanceledOnTouchOutside(true);
            this.fpX.setCancelable(true);
            this.fpX.setContentView(this.fpY);
            WindowManager.LayoutParams attributes = this.fpX.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.af(this.fhQ.getPageContext().getPageActivity()) * 0.9d);
            this.fpX.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fpX.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fpX.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fpX.findViewById(d.g.disable_reply_btn);
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
                    if (as.this.fpX != null && (as.this.fpX instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fpX, as.this.fhQ.getPageContext());
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
                    if (as.this.fpX != null && (as.this.fpX instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fpX, as.this.fhQ.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view2.getTag();
                    if (sparseArray6 != null && as.this.frC != null) {
                        as.this.frC.f(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
                    if (as.this.fpX != null && (as.this.fpX instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fpX, as.this.fhQ.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view2.getTag();
                    if (sparseArray7 != null) {
                        as.this.fhQ.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fpX, this.fhQ.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.frC = bVar;
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
        sparseArray.put(fqR, Integer.valueOf(fqS));
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
        this.fpZ = new com.baidu.tbadk.core.dialog.a(this.fhQ.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fpZ.ca(i3);
        } else {
            this.fpZ.aw(false);
            this.fpZ.dc(str2);
        }
        this.fpZ.z(sparseArray);
        this.fpZ.a(d.k.dialog_ok, this.fhQ);
        this.fpZ.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fpZ.ar(true);
        this.fpZ.b(this.fhQ.getPageContext());
        this.fpZ.tC();
    }

    public void ao(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.fqc == null) {
            this.fqc = LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.commit_good, (ViewGroup) null);
        }
        this.fhQ.getLayoutMode().u(this.fqc);
        if (this.fqb == null) {
            this.fqb = new Dialog(this.fhQ.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fqb.setCanceledOnTouchOutside(true);
            this.fqb.setCancelable(true);
            this.fqm = (ScrollView) this.fqc.findViewById(d.g.good_scroll);
            this.fqb.setContentView(this.fqc);
            WindowManager.LayoutParams attributes = this.fqb.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds540);
            this.fqb.getWindow().setAttributes(attributes);
            this.csk = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.as.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        as.this.fqh = (String) compoundButton.getTag();
                        if (as.this.csj != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : as.this.csj) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && as.this.fqh != null && !str.equals(as.this.fqh)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fqd = (LinearLayout) this.fqc.findViewById(d.g.good_class_group);
            this.fqf = (TextView) this.fqc.findViewById(d.g.dialog_button_cancel);
            this.fqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (as.this.fqb instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(as.this.fqb, as.this.fhQ.getPageContext());
                    }
                }
            });
            this.fqe = (TextView) this.fqc.findViewById(d.g.dialog_button_ok);
            this.fqe.setOnClickListener(this.cZX);
        }
        this.fqd.removeAllViews();
        this.csj = new ArrayList();
        CustomBlueCheckRadioButton bI = bI("0", this.fhQ.getPageContext().getString(d.k.thread_good_class));
        this.csj.add(bI);
        bI.setChecked(true);
        this.fqd.addView(bI);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i2);
                if (abVar != null && !TextUtils.isEmpty(abVar.qJ()) && abVar.qK() > 0) {
                    CustomBlueCheckRadioButton bI2 = bI(String.valueOf(abVar.qK()), abVar.qJ());
                    this.csj.add(bI2);
                    View view2 = new View(this.fhQ.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.ak.j(view2, d.C0126d.cp_bg_line_a);
                    view2.setLayoutParams(layoutParams);
                    this.fqd.addView(view2);
                    this.fqd.addView(bI2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fqm.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fhQ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fhQ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fhQ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fqm.setLayoutParams(layoutParams2);
            this.fqm.removeAllViews();
            if (this.fqd != null && this.fqd.getParent() == null) {
                this.fqm.addView(this.fqd);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fqb, this.fhQ.getPageContext());
    }

    private CustomBlueCheckRadioButton bI(String str, String str2) {
        Activity pageActivity = this.fhQ.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(pageActivity, d.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.csk);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void aZZ() {
        this.fhQ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fhQ.hideProgressBar();
        if (z && z2) {
            this.fhQ.showToast(this.fhQ.getPageContext().getString(d.k.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.an.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.k.neterror);
            }
            this.fhQ.showToast(str);
        }
    }

    public void aFd() {
        this.fpV.setVisibility(0);
    }

    public void aFc() {
        this.fpV.setVisibility(8);
    }

    public View baa() {
        if (this.fqc != null) {
            return this.fqc.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bab() {
        return this.fqh;
    }

    public View getView() {
        return this.cIJ;
    }

    public void bac() {
        com.baidu.adp.lib.util.l.b(this.fhQ.getPageContext().getPageActivity(), this.fhQ.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fhQ.hideProgressBar();
        if (z) {
            bar();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bas();
        } else {
            bar();
        }
    }

    public void bad() {
        this.dcH.wM();
        this.dcH.wQ();
    }

    public void bae() {
        this.fhQ.hideProgressBar();
        wR();
        this.fph.completePullRefreshPostDelayed(2000L);
        bao();
    }

    public void baf() {
        this.fph.completePullRefreshPostDelayed(2000L);
        bao();
    }

    private void ki(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fqq.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fhQ.getResources().getDimensionPixelSize(d.e.ds130) : this.fhQ.getResources().getDimensionPixelSize(d.e.ds34);
        this.fqq.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fpP.setOnLongClickListener(onLongClickListener);
        if (this.frn != null) {
            this.frn.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0086b interfaceC0086b, boolean z, boolean z2) {
        if (this.fqi != null) {
            this.fqi.dismiss();
            this.fqi = null;
        }
        this.fqi = new com.baidu.tbadk.core.dialog.b(this.fhQ.getPageContext().getPageActivity());
        this.fqi.cd(d.k.operation);
        if (z2) {
            this.fqi.a(new String[]{this.fhQ.getPageContext().getString(d.k.copy)}, interfaceC0086b);
        } else if (!z) {
            this.fqi.a(new String[]{this.fhQ.getPageContext().getString(d.k.copy), this.fhQ.getPageContext().getString(d.k.mark)}, interfaceC0086b);
        } else {
            this.fqi.a(new String[]{this.fhQ.getPageContext().getString(d.k.copy), this.fhQ.getPageContext().getString(d.k.remove_mark)}, interfaceC0086b);
        }
        this.fqi.d(this.fhQ.getPageContext());
        this.fqi.tF();
    }

    public void a(b.InterfaceC0086b interfaceC0086b, boolean z) {
        if (this.fqj != null) {
            this.fqj.dismiss();
            this.fqj = null;
        }
        this.fqj = new com.baidu.tbadk.core.dialog.b(this.fhQ.getPageContext().getPageActivity());
        this.fqj.cd(d.k.operation);
        if (z) {
            this.fqj.a(new String[]{this.fhQ.getPageContext().getString(d.k.save_to_emotion)}, interfaceC0086b);
        } else {
            this.fqj.a(new String[]{this.fhQ.getPageContext().getString(d.k.save_to_emotion), this.fhQ.getPageContext().getString(d.k.save_to_local)}, interfaceC0086b);
        }
        this.fqj.d(this.fhQ.getPageContext());
        this.fqj.tF();
    }

    public int bag() {
        return qw(this.fph.getFirstVisiblePosition());
    }

    private int qw(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fph.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fph.getAdapter() == null || !(this.fph.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fph.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bah() {
        int lastVisiblePosition = this.fph.getLastVisiblePosition();
        if (this.foX != null) {
            if (lastVisiblePosition == this.fph.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return qw(lastVisiblePosition);
    }

    public void qx(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fph != null) {
            if (this.fpd == null || this.fpd.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fpd.mNavigationBar.getFixedNavHeight();
                if (this.fhQ.aWZ() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fqI != null && (layoutParams = (LinearLayout.LayoutParams) this.fqI.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fqI.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fph.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fph.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fpS.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fpP.a(dVar, false);
        this.fpP.notifyDataSetChanged();
        bao();
        if (this.frn != null) {
            this.frn.aWt();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fpy == null) {
            this.fhQ.getLayoutMode().u(((ViewStub) this.fpi.findViewById(d.g.praise_layout)).inflate());
            this.fpy = (FrsPraiseView) this.fpi.findViewById(d.g.pb_head_praise_view);
            this.fpy.setIsFromPb(true);
            this.fpN = this.fpi.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fpy.dA(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fpy != null) {
            boolean bao = bao();
            this.fpy.setVisibility(8);
            if (dVar != null && dVar.rf() != null && dVar.rf().rc() == 0 && this.fii) {
                if (bao) {
                    this.fpM.setVisibility(0);
                    return;
                } else {
                    this.fpM.setVisibility(8);
                    return;
                }
            }
            this.fpM.setVisibility(8);
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
                if (postData != null && postData.brX() == 1) {
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
        if (postData != null && postData.rP() != null && postData.rP().getUserTbVipInfoData() != null && postData.rP().getUserTbVipInfoData().getvipIntro() != null) {
            postData.rP().getGodUserData().setIntro(postData.rP().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.aVs() == null || dVar.aVs().rP() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rP = dVar.aVs().rP();
        String userId = rP.getUserId();
        HashMap<String, MetaData> userMap = dVar.aVs().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rP;
        }
        postData.tn(1);
        postData.setId(dVar.aVs().sf());
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
        com.baidu.tbadk.data.f bsa;
        String portrait;
        if (dVar != null && dVar.aVs() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fpn.setVisibility(8);
            if (dVar.aVs() != null && dVar.aVs().sA() && dVar.aVs().sg() != null) {
                this.frc = true;
                this.fpd.kE(this.frc);
                this.fpd.mNavigationBar.hideBottomLine();
                if (this.foX == null) {
                    this.foX = new com.baidu.tieba.pb.video.i(this.fhQ, this.fpd, dVar.aVs().sg(), this.foY);
                    this.foX.a(dVar.aVs().sg(), dVar.aVs(), dVar.getForumId());
                    this.foX.startPlay();
                } else if (this.fpb) {
                    this.foX.a(dVar.aVs().sg(), dVar.aVs(), dVar.getForumId());
                    this.foX.startPlay();
                } else {
                    this.foX.qW(dVar.getForumId());
                }
                if (dVar.aVt() != null && dVar.aVt().size() >= 1) {
                    bd bdVar = dVar.aVt().get(0);
                    this.foX.aj(bdVar);
                    this.foX.qX(bdVar.getTitle());
                }
                this.foX.b(b, dVar.aVs(), dVar.aVO());
                this.fpb = false;
                this.fph.removeHeaderView(this.foX.bcy());
                this.fph.addHeaderView(this.foX.bcy(), 0);
                if (this.foX.bcw() != null && this.foX.bcw().getParent() == null) {
                    this.fqG.addView(this.foX.bcw());
                }
                if (this.foZ == null) {
                    this.foZ = new com.baidu.tieba.pb.video.h(this.fhQ);
                }
                this.foZ.a(dVar.aVs().sP(), dVar.aVs(), dVar.aVL());
                this.fph.removeHeaderView(this.foZ.bcn());
                this.fph.addHeaderView(this.foZ.bcn(), 1);
                if (dVar.aVs().sP() != null) {
                    this.fph.removeHeaderView(this.foZ.bco());
                    this.fph.removeHeaderView(this.fpl);
                    this.fph.addHeaderView(this.foZ.bco(), 2);
                } else {
                    if (this.foZ.bco() != null) {
                        this.fph.removeHeaderView(this.foZ.bco());
                    }
                    this.fph.removeHeaderView(this.fpl);
                    this.fpl.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.fhQ, d.e.tbds56));
                    this.fph.addHeaderView(this.fpl, 2);
                }
                if (this.foX != null) {
                    this.fpd.ky(false);
                    this.fpd.kA(TbadkCoreApplication.isLogin());
                    this.foX.qE(TbadkCoreApplication.getInst().getSkinType());
                }
                bal();
            } else {
                this.frc = false;
                this.fpd.kE(this.frc);
                if (this.foX != null) {
                    this.fph.removeHeaderView(this.foX.bcy());
                }
                if (this.foZ != null) {
                    this.foZ.b(this.fph);
                }
                if (b == null || (b != null && (b.brZ() == null || com.baidu.tbadk.core.util.v.w(b.brZ().JH())))) {
                    this.fpl.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.e(this.fhQ, d.e.tbds80));
                } else {
                    this.fpl.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fhQ.aWN() != null) {
                this.fhQ.aWN().kw(this.frc);
            }
            if (this.foX != null) {
                this.foX.J(this.frE);
            }
            if (b != null) {
                this.fqy = b;
                this.fpn.setVisibility(0);
                if (this.fhQ.aXy()) {
                    if (dVar.aVr() != null) {
                        this.mForumName = dVar.aVr().getForumName();
                        this.mForumId = dVar.aVr().getForumId();
                    }
                    if (this.mForumName == null && this.fhQ.aWx() != null && this.fhQ.aWx().aYi() != null) {
                        this.mForumName = this.fhQ.aWx().aYi();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fpn.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fpn.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.frt) {
                    this.fpj.setVisibility(0);
                }
                if (!dVar.aVs().sA() && this.fpk.getText() != null && this.fpk.getText().length() > 0) {
                    this.fpk.setVisibility(0);
                } else {
                    this.fpk.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> sa = dVar.aVs().sa();
                if (sa != null && sa.size() > 0 && !this.frt) {
                    this.fqB.setText(String.valueOf(sa.get(0).qp()));
                    this.fqA.setVisibility(0);
                } else {
                    this.fqA.setVisibility(8);
                }
                com.baidu.tbadk.core.util.ak.i(this.fqA, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.ak.c(this.fqB, d.C0126d.cp_link_tip_d, 1);
                if (b.rP() != null) {
                    String string = b.rP().getName_show() == null ? StringUtils.string(b.rP().getUserName()) : StringUtils.string(b.rP().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.rP().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.aU(b.rP().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aU(string) > 12) {
                            e = com.baidu.tbadk.core.util.an.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.rP().getIconInfo();
                            tShowInfoNew = b.rP().getTShowInfoNew();
                            if (this.fjk != null) {
                                this.fjk.setTag(d.g.tag_user_id, b.rP().getUserId());
                                this.fjk.setOnClickListener(this.fhQ.ffT.ftp);
                                this.fjk.a(iconInfo, 4, this.fhQ.getResources().getDimensionPixelSize(d.e.tbds36), this.fhQ.getResources().getDimensionPixelSize(d.e.tbds36), this.fhQ.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fjj != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fjj.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fjj.setOnClickListener(this.fhQ.ffT.ftq);
                                this.fjj.a(tShowInfoNew, 3, this.fhQ.getResources().getDimensionPixelSize(d.e.tbds36), this.fhQ.getResources().getDimensionPixelSize(d.e.tbds36), this.fhQ.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fpp.setText(ag(b.rP().getSealPrefix(), e));
                            this.fpp.setTag(d.g.tag_user_id, b.rP().getUserId());
                            this.fpp.setTag(d.g.tag_user_name, b.rP().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew) || b.rP().isBigV()) {
                                com.baidu.tbadk.core.util.ak.c(this.fpp, d.C0126d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.ak.c(this.fpp, d.C0126d.cp_cont_f, 1);
                            }
                            this.fpq.setVisibility(8);
                            if (dVar.aVs().rP() != null && dVar.aVs().rP().getAlaUserData() != null && this.fpw != null) {
                                if (dVar.aVs().rP().getAlaUserData().anchor_live != 0) {
                                    this.fpw.setVisibility(8);
                                } else {
                                    this.fpw.setVisibility(0);
                                    if (this.fpa == null) {
                                        this.fpa = new com.baidu.tieba.d.c(this.fhQ.getPageContext(), this.fpw);
                                        this.fpa.je(1);
                                    }
                                    this.fpa.aJ(this.fhQ.getResources().getString(d.k.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Sa = dVar.aVs().rP().getAlaUserData();
                                    aVar.type = 2;
                                    this.fpw.setTag(aVar);
                                }
                            }
                            this.fpv.setUserId(b.rP().getUserId());
                            this.fpv.setUserName(b.rP().getUserName());
                            this.fpv.setImageDrawable(null);
                            this.fpv.setRadius(com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds40));
                            this.fpv.setTag(b.rP().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fpE.setText(com.baidu.tbadk.core.util.an.t(b.getTime()));
                            } else {
                                this.fpE.setText(com.baidu.tbadk.core.util.an.s(b.getTime()));
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds16);
                            if (!this.fhQ.aXy() && !StringUtils.isNull(this.mForumName)) {
                                this.apF.setText(this.fhQ.getString(d.k.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.apF.setVisibility(0);
                                this.fpH.setVisibility(0);
                                this.fpE.setPadding(e2, 0, e2, 0);
                            } else {
                                this.apF.setVisibility(8);
                                this.fpH.setVisibility(8);
                                this.fpE.setPadding(0, 0, e2, 0);
                            }
                            bsa = b.bsa();
                            if (bsa == null && !TextUtils.isEmpty(bsa.getName()) && !TextUtils.isEmpty(bsa.getName().trim())) {
                                final String name = bsa.getName();
                                final String lat = bsa.getLat();
                                final String lng = bsa.getLng();
                                this.fpF.setVisibility(0);
                                this.fpG.setVisibility(0);
                                this.fpF.setText(bsa.getName());
                                this.fpF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.gP()) {
                                                as.this.fhQ.showToast(d.k.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.M(as.this.fhQ.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, as.this.fhQ.getPageContext().getString(d.k.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fpF.setVisibility(8);
                                this.fpG.setVisibility(8);
                            }
                            portrait = b.rP().getPortrait();
                            if (b.rP().getPendantData() == null && !StringUtils.isNull(b.rP().getPendantData().qF())) {
                                UtilHelper.showHeadImageViewBigV(this.fpt.getHeadView(), b.rP());
                                this.fpv.setVisibility(8);
                                this.fpt.setVisibility(0);
                                if (this.fpz != null) {
                                    this.fpz.setVisibility(8);
                                }
                                this.fpp.setOnClickListener(this.frE);
                                this.fpt.getHeadView().startLoad(portrait, 28, false);
                                this.fpt.getHeadView().setUserId(b.rP().getUserId());
                                this.fpt.getHeadView().setUserName(b.rP().getUserName());
                                this.fpt.getHeadView().setOnClickListener(this.frE);
                                this.fpt.eK(b.rP().getPendantData().qF());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fpv, b.rP());
                                this.fpv.setVisibility(0);
                                this.fpn.setOnClickListener(this.frE);
                                this.fpp.setOnClickListener(this.frE);
                                this.fpv.setOnClickListener(this.frE);
                                this.fpt.setVisibility(8);
                                this.fpv.startLoad(portrait, 28, false);
                            }
                            String name_show = b.rP().getName_show();
                            String userName = b.rP().getUserName();
                            if (com.baidu.tbadk.o.af.fz() && name_show != null && !name_show.equals(userName)) {
                                this.fpp.setText(com.baidu.tieba.pb.c.ah(this.fhQ.getPageContext().getPageActivity(), this.fpp.getText().toString()));
                                this.fpp.setGravity(16);
                                this.fpp.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                                com.baidu.tbadk.core.util.ak.c(this.fpp, d.C0126d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.rP().getIconInfo();
                        tShowInfoNew = b.rP().getTShowInfoNew();
                        if (this.fjk != null) {
                        }
                        if (this.fjj != null) {
                        }
                        this.fpp.setText(ag(b.rP().getSealPrefix(), e));
                        this.fpp.setTag(d.g.tag_user_id, b.rP().getUserId());
                        this.fpp.setTag(d.g.tag_user_name, b.rP().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ak.c(this.fpp, d.C0126d.cp_cont_h, 1);
                        this.fpq.setVisibility(8);
                        if (dVar.aVs().rP() != null) {
                            if (dVar.aVs().rP().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fpv.setUserId(b.rP().getUserId());
                        this.fpv.setUserName(b.rP().getUserName());
                        this.fpv.setImageDrawable(null);
                        this.fpv.setRadius(com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds40));
                        this.fpv.setTag(b.rP().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds16);
                        if (!this.fhQ.aXy()) {
                        }
                        this.apF.setVisibility(8);
                        this.fpH.setVisibility(8);
                        this.fpE.setPadding(0, 0, e2, 0);
                        bsa = b.bsa();
                        if (bsa == null) {
                        }
                        this.fpF.setVisibility(8);
                        this.fpG.setVisibility(8);
                        portrait = b.rP().getPortrait();
                        if (b.rP().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fpv, b.rP());
                        this.fpv.setVisibility(0);
                        this.fpn.setOnClickListener(this.frE);
                        this.fpp.setOnClickListener(this.frE);
                        this.fpv.setOnClickListener(this.frE);
                        this.fpt.setVisibility(8);
                        this.fpv.startLoad(portrait, 28, false);
                        String name_show2 = b.rP().getName_show();
                        String userName2 = b.rP().getUserName();
                        if (com.baidu.tbadk.o.af.fz()) {
                            this.fpp.setText(com.baidu.tieba.pb.c.ah(this.fhQ.getPageContext().getPageActivity(), this.fpp.getText().toString()));
                            this.fpp.setGravity(16);
                            this.fpp.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                            com.baidu.tbadk.core.util.ak.c(this.fpp, d.C0126d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aU(string) > 14) {
                            e = com.baidu.tbadk.core.util.an.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.rP().getIconInfo();
                            tShowInfoNew = b.rP().getTShowInfoNew();
                            if (this.fjk != null) {
                            }
                            if (this.fjj != null) {
                            }
                            this.fpp.setText(ag(b.rP().getSealPrefix(), e));
                            this.fpp.setTag(d.g.tag_user_id, b.rP().getUserId());
                            this.fpp.setTag(d.g.tag_user_name, b.rP().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.ak.c(this.fpp, d.C0126d.cp_cont_h, 1);
                            this.fpq.setVisibility(8);
                            if (dVar.aVs().rP() != null) {
                            }
                            this.fpv.setUserId(b.rP().getUserId());
                            this.fpv.setUserName(b.rP().getUserName());
                            this.fpv.setImageDrawable(null);
                            this.fpv.setRadius(com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds40));
                            this.fpv.setTag(b.rP().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            e2 = com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds16);
                            if (!this.fhQ.aXy()) {
                            }
                            this.apF.setVisibility(8);
                            this.fpH.setVisibility(8);
                            this.fpE.setPadding(0, 0, e2, 0);
                            bsa = b.bsa();
                            if (bsa == null) {
                            }
                            this.fpF.setVisibility(8);
                            this.fpG.setVisibility(8);
                            portrait = b.rP().getPortrait();
                            if (b.rP().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fpv, b.rP());
                            this.fpv.setVisibility(0);
                            this.fpn.setOnClickListener(this.frE);
                            this.fpp.setOnClickListener(this.frE);
                            this.fpv.setOnClickListener(this.frE);
                            this.fpt.setVisibility(8);
                            this.fpv.startLoad(portrait, 28, false);
                            String name_show22 = b.rP().getName_show();
                            String userName22 = b.rP().getUserName();
                            if (com.baidu.tbadk.o.af.fz()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.rP().getIconInfo();
                        tShowInfoNew = b.rP().getTShowInfoNew();
                        if (this.fjk != null) {
                        }
                        if (this.fjj != null) {
                        }
                        this.fpp.setText(ag(b.rP().getSealPrefix(), e));
                        this.fpp.setTag(d.g.tag_user_id, b.rP().getUserId());
                        this.fpp.setTag(d.g.tag_user_name, b.rP().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.ak.c(this.fpp, d.C0126d.cp_cont_h, 1);
                        this.fpq.setVisibility(8);
                        if (dVar.aVs().rP() != null) {
                        }
                        this.fpv.setUserId(b.rP().getUserId());
                        this.fpv.setUserName(b.rP().getUserName());
                        this.fpv.setImageDrawable(null);
                        this.fpv.setRadius(com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds40));
                        this.fpv.setTag(b.rP().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        e2 = com.baidu.adp.lib.util.l.e(this.fhQ.getActivity(), d.e.ds16);
                        if (!this.fhQ.aXy()) {
                        }
                        this.apF.setVisibility(8);
                        this.fpH.setVisibility(8);
                        this.fpE.setPadding(0, 0, e2, 0);
                        bsa = b.bsa();
                        if (bsa == null) {
                        }
                        this.fpF.setVisibility(8);
                        this.fpG.setVisibility(8);
                        portrait = b.rP().getPortrait();
                        if (b.rP().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fpv, b.rP());
                        this.fpv.setVisibility(0);
                        this.fpn.setOnClickListener(this.frE);
                        this.fpp.setOnClickListener(this.frE);
                        this.fpv.setOnClickListener(this.frE);
                        this.fpt.setVisibility(8);
                        this.fpv.startLoad(portrait, 28, false);
                        String name_show222 = b.rP().getName_show();
                        String userName222 = b.rP().getUserName();
                        if (com.baidu.tbadk.o.af.fz()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fpm.ab(dVar.aVs());
                }
                if (this.fqJ != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fdF);
                    if (dVar != null && dVar.aVs() != null) {
                        hVar.fdH = dVar.aVs().rH();
                    }
                    hVar.isNew = !this.fii;
                    hVar.fdJ = this.fhQ.aXx();
                    this.fqJ.a(hVar);
                }
            }
        }
    }

    public void kj(boolean z) {
        if (z) {
            bai();
        } else {
            akW();
        }
        this.fqN.frV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fqN));
        a(this.fqN.frV, false);
    }

    public void bai() {
        if (this.fpd != null && !this.fre) {
            this.fpd.kF(!StringUtils.isNull(this.fhQ.aWW()));
            this.fre = true;
        }
    }

    public void akW() {
        if (this.fpd != null) {
            this.fpd.bbm();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.sj() != null) {
            this.fpo.setData(this.fhQ.getPageContext(), dVar.aVu().get(0).sj(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.aVq().getId(), dVar.aVq().getName(), dVar.aVs().getId(), this.fhQ.aXu() ? "FRS" : null));
            this.fpn.setPadding(this.fpn.getPaddingLeft(), (int) this.fhQ.getResources().getDimension(d.e.ds20), this.fpn.getPaddingRight(), this.fpn.getPaddingBottom());
            return;
        }
        this.fpo.setData(null, null, null);
    }

    public void baj() {
        if (this.foX != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11997").r("obj_type", 1));
            this.foX.bcx();
            this.fph.smoothScrollToPosition(0);
        }
    }

    public boolean bak() {
        return this.frF;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean ad(bd bdVar) {
        if (bdVar == null || bdVar.rP() == null || bdVar.rP().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rP().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fpd.bbk();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fpd.ot(cVar.forumName);
            }
            String string = this.fhQ.getResources().getString(d.k.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(cVar.source, 0)) {
                case 100:
                    str = this.fhQ.getResources().getString(d.k.self);
                    break;
                case 300:
                    str = this.fhQ.getResources().getString(d.k.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fhQ.getResources().getString(d.k.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fcR;
            this.fhQ.showNetRefreshView(this.cIJ, format, null, this.fhQ.getResources().getString(d.k.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (com.baidu.adp.lib.util.l.hg()) {
                        com.baidu.tbadk.core.util.ax.wf().c(as.this.fhQ.getPageContext(), new String[]{str2});
                        as.this.fhQ.finish();
                        return;
                    }
                    as.this.fhQ.showToast(d.k.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aZs;
        Parcelable aZs2;
        String str;
        if (dVar != null) {
            this.flr = dVar;
            this.mType = i;
            if (dVar.aVs() != null) {
                this.fqP = dVar.aVs().rB();
                if (dVar.aVs().getAnchorLevel() != 0) {
                    this.frF = true;
                }
                this.fql = ad(dVar.aVs());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fqz = false;
            this.fii = z;
            bae();
            b(dVar, z, i);
            p(dVar);
            if (this.frq == null) {
                this.frq = new ab(this.fhQ.getPageContext(), this.dsc);
            }
            this.frq.qE(dVar.aVx());
            if (this.fhQ.aXl()) {
                if (this.fpT == null) {
                    this.fpT = new com.baidu.tieba.pb.view.e(this.fhQ.getPageContext());
                    this.fpT.kz();
                    this.fpT.a(this.anZ);
                }
                this.fph.setPullRefresh(this.fpT);
                bal();
                if (this.fpT != null) {
                    this.fpT.dw(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.rf().rc() == 0 && z) {
                this.fph.setPullRefresh(null);
            } else {
                if (this.fpT == null) {
                    this.fpT = new com.baidu.tieba.pb.view.e(this.fhQ.getPageContext());
                    this.fpT.kz();
                    this.fpT.a(this.anZ);
                }
                this.fph.setPullRefresh(this.fpT);
                bal();
                if (this.fpT != null) {
                    this.fpT.dw(TbadkCoreApplication.getInst().getSkinType());
                }
                aav();
            }
            bao();
            this.fpP.js(this.fii);
            this.fpP.jt(false);
            this.fpP.jE(i == 5);
            this.fpP.jF(i == 6);
            this.fpP.jG(z2 && this.frD);
            this.fpP.a(dVar, false);
            this.fpP.notifyDataSetChanged();
            if (this.fhQ.aXy()) {
                this.frg = 0;
                PostData b = b(dVar, z);
                if (b != null && b.rP() != null) {
                    this.frg = b.rP().getLevel_id();
                }
                if (this.frg > 0) {
                    this.fpr.setVisibility(0);
                    com.baidu.tbadk.core.util.ak.c(this.fpr, BitmapHelper.getGradeResourceIdInEnterForum(this.frg));
                } else {
                    this.fpr.setVisibility(8);
                }
            } else {
                this.fpr.setVisibility(8);
            }
            if (dVar.aVs() != null) {
                if (dVar.aVs().rE() != null) {
                    if (dVar.aVs().rE().getNum() < 1) {
                        str = this.fhQ.getResources().getString(d.k.zan);
                    } else {
                        str = dVar.aVs().rE().getNum() + "";
                    }
                    if (this.foW != -1) {
                        dVar.aVs().rE().setIsLike(this.foW);
                    }
                    M(str, dVar.aVs().rE().getIsLike() == 1);
                }
                if (dVar.aVs().abM != null && dVar.aVs().abM.isDeleted) {
                    this.fpd.kz(true);
                } else {
                    this.fpd.kz(false);
                }
            }
            if (this.fhQ.isLogin()) {
                this.fph.setNextPage(this.dcH);
                this.fpc = 2;
                aav();
            } else {
                this.fqz = true;
                if (dVar.rf().rb() == 1) {
                    if (this.fpU == null) {
                        this.fpU = new com.baidu.tieba.pb.view.a(this.fhQ.getPageContext());
                    }
                    this.fph.setNextPage(this.fpU);
                } else {
                    this.fph.setNextPage(this.dcH);
                }
                this.fpc = 3;
            }
            ArrayList<PostData> aVu = dVar.aVu();
            if (dVar.rf().rb() == 0 || aVu == null || aVu.size() < dVar.rf().ra()) {
                if (com.baidu.tbadk.core.util.v.v(aVu) == 0 || (com.baidu.tbadk.core.util.v.v(aVu) == 1 && aVu.get(0) != null && aVu.get(0).brX() == 1)) {
                    this.dcH.setText(this.fhQ.getResources().getString(d.k.list_no_more_new));
                    if (this.fhQ.aWN() != null && !this.fhQ.aWN().bba()) {
                        this.fhQ.aWN().showFloatingView();
                    }
                } else {
                    this.dcH.setText(this.fhQ.getResources().getString(d.k.list_has_no_more));
                }
                if (this.fhQ.aXl() && this.fph != null && this.fph.getData() != null && this.fph.getData().size() == 1 && (this.fph.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dcH.setText("");
                }
                bav();
            } else if (z2) {
                if (this.frD) {
                    wR();
                    if (dVar.rf().rb() != 0) {
                        this.dcH.setText(this.fhQ.getResources().getString(d.k.pb_load_more));
                    }
                } else {
                    this.dcH.wM();
                    this.dcH.showLoading();
                }
            } else {
                this.dcH.wM();
                this.dcH.showLoading();
            }
            switch (i) {
                case 2:
                    this.fph.setSelection(i2 > 1 ? (((this.fph.getData() == null && dVar.aVu() == null) ? 0 : (this.fph.getData().size() - dVar.aVu().size()) + this.fph.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aZs2 = ai.aZr().aZs()) != null) {
                        this.fph.onRestoreInstanceState(aZs2);
                        if (com.baidu.tbadk.core.util.v.v(aVu) > 1 && dVar.rf().rb() > 0) {
                            this.dcH.wR();
                            this.dcH.setText(this.fhQ.getString(d.k.pb_load_more_without_point));
                            this.dcH.wN();
                            break;
                        }
                    } else {
                        this.fph.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.frD = false;
                    break;
                case 5:
                    this.fph.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aZs = ai.aZr().aZs()) != null) {
                        this.fph.onRestoreInstanceState(aZs);
                        break;
                    } else {
                        this.fph.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.foX != null && this.foX.bcw() != null) {
                            if (this.fhQ.isUseStyleImmersiveSticky()) {
                                this.fph.setSelectionFromTop((this.fpP.aXN() + this.fph.getHeaderViewsCount()) - 1, this.foX.bcw().getHeight() - com.baidu.adp.lib.util.l.p(this.fhQ.getPageContext().getPageActivity()));
                            } else {
                                this.fph.setSelectionFromTop((this.fpP.aXN() + this.fph.getHeaderViewsCount()) - 1, this.foX.bcw().getHeight());
                            }
                        } else {
                            this.fph.setSelection(this.fpP.aXN() + this.fph.getHeaderViewsCount());
                        }
                    } else {
                        this.fph.setSelection(i2 > 0 ? ((this.fph.getData() == null && dVar.aVu() == null) ? 0 : (this.fph.getData().size() - dVar.aVu().size()) + this.fph.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dcH.wR();
                    this.dcH.setText(this.fhQ.getString(d.k.pb_load_more_without_point));
                    this.dcH.wN();
                    break;
            }
            if (this.fqP == fqQ && isHost()) {
                baD();
            }
            if (this.fra) {
                aZD();
                this.fra = false;
                if (i3 == 0) {
                    kc(true);
                }
            }
            if (this.foZ != null) {
                this.foZ.ai(dVar.aVs());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fdw == 1 || dVar.fdx == 1) {
                if (this.frh == null) {
                    this.frh = new PbTopTipView(this.fhQ);
                }
                if (dVar.fdx == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fhQ.getStType())) {
                    this.frh.setText(this.fhQ.getString(d.k.pb_read_strategy_add_experience));
                    this.frh.show(this.cIJ, this.mSkinType);
                } else if (dVar.fdw == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fhQ.getStType())) {
                    this.frh.setText(this.fhQ.getString(d.k.pb_read_news_add_experience));
                    this.frh.show(this.cIJ, this.mSkinType);
                }
            }
        }
    }

    private void bal() {
        if (this.foX != null && this.foX.bcw() != null) {
            this.fph.removeHeaderView(this.azb);
            if (this.mType != 1) {
                this.fph.removeHeaderView(this.foX.bcy());
                this.fph.addHeaderView(this.foX.bcy(), 0);
                return;
            }
            return;
        }
        if (this.foX != null) {
            this.fph.removeHeaderView(this.foX.bcy());
        }
        this.fph.removeHeaderView(this.azb);
        this.fph.addHeaderView(this.azb, 0);
    }

    public void kk(boolean z) {
        this.fqk = z;
    }

    public void wR() {
        if (this.dcH != null) {
            this.dcH.wN();
            this.dcH.wR();
        }
        aav();
    }

    public void showListView() {
        this.fph.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fqy != null && this.fqy.rP() != null && this.fpd != null) {
            this.frd = !this.frc;
            this.fpd.ky(this.frd);
            if (this.fhQ.aWN() != null) {
                this.fhQ.aWN().kx(this.frd);
            }
            bam();
            if (this.frd) {
                this.fpd.fud.setVisibility(0);
                if (this.fql) {
                    this.fpd.fue.setVisibility(8);
                    this.fpA.setVisibility(8);
                    this.fpD.setVisibility(0);
                    this.fpD.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.an.y(dVar.aVN())));
                } else if (!PbNormalLikeButtonSwitchStatic.Hq() || (this.fqy.rP().hadConcerned() && this.fqy.rP().getGodUserData() != null && this.fqy.rP().getGodUserData().getIsFromNetWork())) {
                    this.fpd.fue.setVisibility(8);
                }
                if (this.fqI != null) {
                    this.fqI.setVisibility(8);
                }
                this.fpd.a(this.fqy.rP(), this.frE);
                if (this.fro == null) {
                    this.fro = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.as.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > as.this.frf) {
                                as.this.baC();
                            }
                        }
                    };
                }
                this.fph.setListViewDragListener(this.fro);
                return;
            }
            if (this.fpd.fud != null) {
                this.fpd.fud.setVisibility(8);
            }
            if (this.fqI != null) {
                this.fqI.setVisibility(0);
            }
            if (this.fql) {
                this.fpA.setVisibility(8);
                this.fpD.setVisibility(0);
                this.fpD.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.person_view_num), com.baidu.tbadk.core.util.an.y(dVar.aVN())));
            } else if (!PbNormalLikeButtonSwitchStatic.Hq() || (this.fqy.rP().hadConcerned() && this.fqy.rP().getGodUserData() != null && this.fqy.rP().getGodUserData().getIsFromNetWork())) {
                this.fpA.setVisibility(8);
                this.fpD.setVisibility(8);
            } else {
                this.fpD.setVisibility(8);
            }
            this.fro = null;
            this.fph.setListViewDragListener(null);
        }
    }

    private void bam() {
        String threadId = this.flr != null ? this.flr.getThreadId() : "";
        int ban = ban();
        if (this.frd) {
            if (this.fpC == null) {
                this.fpC = new aq(this.fhQ.getPageContext(), this.fpd.fue, 3);
                this.fpC.h(this.fhQ.getUniqueId());
            }
            if (this.fqy != null && this.fqy.rP() != null) {
                this.fqy.rP().setIsLike(this.fqy.rP().hadConcerned());
                this.fpC.a(this.fqy.rP());
            }
            this.fpC.cJ(threadId);
            this.fpC.qv(ban);
            this.fpC.foS = this.frc;
        }
        if (this.fpB == null) {
            this.fpB = new aq(this.fhQ.getPageContext(), this.fpA, 1);
            this.fpB.h(this.fhQ.getUniqueId());
            this.fpB.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.as.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aR(boolean z) {
                    if (as.this.fhQ != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(as.this.fhQ, d.k.attention_success);
                            return;
                        }
                        ar.v(as.this.fhQ.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fqy != null && this.fqy.rP() != null) {
            this.fqy.rP().setIsLike(this.fqy.rP().hadConcerned());
            this.fpB.a(this.fqy.rP());
            this.fpB.cJ(threadId);
        }
        this.fpB.foS = this.frc;
        this.fpB.qv(ban);
    }

    private int ban() {
        if (this.flr == null || this.flr.aVs() == null) {
            return 0;
        }
        if (this.flr.aVs().sX()) {
            return (com.baidu.tbadk.core.util.v.w(this.flr.aVM()) && (this.flr.aVr() == null || StringUtils.isNull(this.flr.aVr().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bao() {
        boolean z;
        if (this.fqo != null && this.fqo.getVisibility() == 0) {
            if (this.fpL != null) {
                this.fpL.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fpL != null) {
                this.fpL.setVisibility(8);
            }
            z = false;
        }
        if ((this.fpN == null || this.fpN.getVisibility() == 8) && z && this.fii) {
            this.fpM.setVisibility(0);
        } else {
            this.fpM.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.aVs() == null) {
            return false;
        }
        if (dVar.aVs().rM() == 1 || dVar.aVs().getThreadType() == 33) {
            return true;
        }
        return !(dVar.aVs().rO() == null || dVar.aVs().rO().tq() == 0) || dVar.aVs().rK() == 1 || dVar.aVs().rL() == 1 || dVar.aVs().ss() || dVar.aVs().sE() || dVar.aVs().sz() || dVar.aVs().sb() != null || !com.baidu.tbadk.core.util.an.isEmpty(dVar.aVs().getCategory()) || dVar.aVs().rS() || dVar.aVs().rR();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fhQ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fpj != null) {
                if (dVar.aVs() != null && dVar.aVs().se() == 0 && !dVar.aVs().sA() && !this.frt) {
                    this.fpj.setVisibility(0);
                    if (dVar.aVs() != null) {
                        dVar.aVs().e(true, q(dVar));
                    }
                    SpannableStringBuilder sn = dVar.aVs().sn();
                    this.fpk.setOnTouchListener(new com.baidu.tieba.view.j(sn));
                    if (this.frp) {
                        this.fpk.setText(dVar.aVs().getTitle());
                    } else {
                        this.fpk.setText(sn);
                    }
                    this.fpk.setVisibility(0);
                } else if (dVar.aVs().se() == 1) {
                    if (dVar.aVs() != null) {
                        this.fpj.setVisibility(8);
                        this.fph.removeHeaderView(this.fpj);
                        if (dVar.aVs() != null && !dVar.aVs().sA()) {
                            this.fpn.setPadding(this.fpn.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.tbds36), this.fpn.getPaddingRight(), this.fpn.getPaddingBottom());
                        }
                    }
                } else {
                    this.fpj.setVisibility(8);
                    this.fph.removeHeaderView(this.fpj);
                    if (dVar.aVs() != null && dVar.aVs().sA()) {
                        this.fpn.setPadding(this.fpn.getPaddingLeft(), 0, this.fpn.getPaddingRight(), this.fpn.getPaddingBottom());
                    } else {
                        this.fpn.setPadding(this.fpn.getPaddingLeft(), com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds48), this.fpn.getPaddingRight(), this.fpn.getPaddingBottom());
                    }
                }
            }
            this.fii = z;
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
            String userId = b.rP().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(dVar.aVE()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.rP() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.rP().getUserName());
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
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (uVar = azVar.ZA) != null && uVar.XF && !uVar.isDeleted && (uVar.type == 1 || uVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.j(azVar.getForumName(), 12)).append(this.fhQ.getString(d.k.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fhQ.getString(d.k.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.aJI;
    }

    public void qF(String str) {
        if (this.dcH != null) {
            this.dcH.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fph;
    }

    public int bap() {
        return d.g.richText;
    }

    public TextView aWI() {
        return this.fpm.aWI();
    }

    public void e(BdListView.e eVar) {
        this.fph.setOnSrollToBottomListener(eVar);
    }

    public void a(e.b bVar) {
        this.anZ = bVar;
        if (this.fpT != null) {
            this.fpT.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.am amVar, a.b bVar) {
        if (amVar != null) {
            int qZ = amVar.qZ();
            int qW = amVar.qW();
            if (this.fpQ != null) {
                this.fpQ.tC();
            } else {
                this.fpQ = new com.baidu.tbadk.core.dialog.a(this.fhQ.getPageContext().getPageActivity());
                this.fpR = LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.dialog_direct_pager, (ViewGroup) null);
                this.fpQ.w(this.fpR);
                this.fpQ.a(d.k.dialog_ok, bVar);
                this.fpQ.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        as.this.bar();
                        aVar.dismiss();
                    }
                });
                this.fpQ.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.as.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (as.this.fqX == null) {
                            as.this.fqX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    as.this.fhQ.HidenSoftKeyPad((InputMethodManager) as.this.fhQ.getSystemService("input_method"), as.this.cIJ);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fw().postDelayed(as.this.fqX, 150L);
                    }
                });
                this.fpQ.b(this.fhQ.getPageContext()).tC();
            }
            this.fpS = (EditText) this.fpR.findViewById(d.g.input_page_number);
            this.fpS.setText("");
            TextView textView = (TextView) this.fpR.findViewById(d.g.current_page_number);
            if (qZ <= 0) {
                qZ = 1;
            }
            if (qW <= 0) {
                qW = 1;
            }
            textView.setText(MessageFormat.format(this.fhQ.getApplicationContext().getResources().getString(d.k.current_page), Integer.valueOf(qZ), Integer.valueOf(qW)));
            this.fhQ.ShowSoftKeyPadDelay(this.fpS, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fph.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fhQ.showToast(str);
    }

    public boolean kl(boolean z) {
        if (this.JO == null || !this.JO.DG()) {
            return false;
        }
        this.JO.BY();
        return true;
    }

    public void baq() {
        if (this.frG != null) {
            while (this.frG.size() > 0) {
                TbImageView remove = this.frG.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        baq();
        this.fpP.qi(1);
        if (this.foX != null) {
            this.foX.onPause();
        }
    }

    public void onResume() {
        this.fpP.qi(2);
        if (this.foX != null) {
            this.foX.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fqZ != null) {
            this.fqZ.destroy();
        }
        if (this.frq != null) {
            this.frq.onDestory();
        }
        if (this.frh != null) {
            this.frh.hide();
        }
        if (this.fpa != null) {
            this.fpa.ahf();
        }
        if (this.foZ != null) {
            this.foZ.onDestroy();
        }
        this.fhQ.hideProgressBar();
        if (this.cIH != null && this.cWl != null) {
            this.cIH.b(this.cWl);
        }
        bar();
        wR();
        if (this.fqX != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fqX);
        }
        if (this.fpn != null && this.fpz != null) {
            this.fpn.removeView(this.fpu);
            this.fpz = null;
        }
        if (this.fqD != null) {
            this.fqD.clearStatus();
        }
        this.frz = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fpP.qi(3);
        if (this.dak != null) {
            this.dak.setBackgroundDrawable(null);
        }
        if (this.foX != null) {
            this.foX.destroy();
        }
        if (this.fpP != null) {
            this.fpP.onDestroy();
        }
        this.fph.setOnLayoutListener(null);
        if (this.frm != null) {
            this.frm.arf();
        }
        if (this.fqO != null) {
            this.fqO.onDestroy();
        }
        baM();
    }

    public boolean qy(int i) {
        if (this.foX != null) {
            return this.foX.kp(i);
        }
        return false;
    }

    public void bar() {
        this.fpd.pq();
        if (this.fpa != null) {
            this.fpa.ahf();
        }
        com.baidu.adp.lib.util.l.b(this.fhQ.getPageContext().getPageActivity(), this.fpS);
        aZF();
        if (this.fqi != null) {
            this.fqi.dismiss();
        }
        bat();
        if (this.foZ != null) {
            this.foZ.bcp();
        }
        if (this.fpQ != null) {
            this.fpQ.dismiss();
        }
        if (this.cZW != null) {
            this.cZW.dismiss();
        }
    }

    public void bas() {
        this.fpd.pq();
        if (this.fpa != null) {
            this.fpa.ahf();
        }
        if (this.fqi != null) {
            this.fqi.dismiss();
        }
        bat();
        if (this.foZ != null) {
            this.foZ.bcp();
        }
        if (this.fpQ != null) {
            this.fpQ.dismiss();
        }
        if (this.cZW != null) {
            this.cZW.dismiss();
        }
    }

    public void cR(List<String> list) {
        this.frl = list;
        if (this.frm != null) {
            this.frm.setData(list);
        }
    }

    public void jr(boolean z) {
        this.fpP.jr(z);
    }

    public void km(boolean z) {
        this.fqn = z;
    }

    public void bat() {
        if (this.fpZ != null) {
            this.fpZ.dismiss();
        }
        if (this.fqa != null) {
            com.baidu.adp.lib.g.g.b(this.fqa, this.fhQ.getPageContext());
        }
        if (this.fqb != null) {
            com.baidu.adp.lib.g.g.b(this.fqb, this.fhQ.getPageContext());
        }
        if (this.fpX != null) {
            com.baidu.adp.lib.g.g.b(this.fpX, this.fhQ.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.flr, this.fii);
            d(this.flr, this.fii, this.mType);
            this.fhQ.getLayoutMode().setNightMode(i == 1);
            this.fhQ.getLayoutMode().u(this.cIJ);
            this.fhQ.getLayoutMode().u(this.fpi);
            com.baidu.tbadk.core.util.ak.i(this.fpl, d.C0126d.cp_bg_line_d);
            if (this.foZ != null) {
                this.foZ.onChangeSkinType(i);
            }
            if (this.fpk != null) {
                com.baidu.tbadk.core.util.ak.h(this.fpk, d.C0126d.cp_cont_b);
                this.fpk.setLinkTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_link_tip_c));
            }
            if (this.dcH != null) {
                this.dcH.dw(i);
                if (this.aJI != null) {
                    this.fhQ.getLayoutMode().u(this.aJI);
                    com.baidu.tbadk.core.util.ak.i(this.aJI, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fpQ != null) {
                this.fpQ.c(this.fhQ.getPageContext());
            }
            kk(this.fqk);
            this.fpP.notifyDataSetChanged();
            if (this.fpT != null) {
                this.fpT.dw(i);
            }
            if (this.JO != null) {
                this.JO.onChangeSkinType(i);
            }
            if (this.fpy != null) {
                this.fpy.dA(i);
            }
            if (this.fpU != null) {
                this.fpU.dw(i);
            }
            if (!com.baidu.tbadk.core.util.v.w(this.csj)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.csj) {
                    customBlueCheckRadioButton.wB();
                }
            }
            kg(i == 1);
            aZT();
            UtilHelper.setStatusBarBackground(this.dak, i);
            UtilHelper.setStatusBarBackground(this.fqI, i);
            if (this.fpA != null) {
                this.fpA.onChangeSkinType(i);
            }
            if (this.fpF != null) {
                com.baidu.tbadk.core.util.ak.h(this.fpF, d.C0126d.cp_cont_d);
            }
            if (this.fpE != null) {
                com.baidu.tbadk.core.util.ak.h(this.fpE, d.C0126d.cp_cont_d);
            }
            if (this.fpG != null) {
                com.baidu.tbadk.core.util.ak.i(this.fpG, d.C0126d.cp_cont_e);
            }
            if (this.apF != null) {
                com.baidu.tbadk.core.util.ak.h(this.apF, d.C0126d.cp_cont_d);
            }
            if (this.fpH != null) {
                com.baidu.tbadk.core.util.ak.i(this.fpH, d.C0126d.cp_cont_e);
            }
            if (this.fpq != null) {
                com.baidu.tbadk.core.util.ak.h(this.fpq, d.C0126d.cp_link_tip_a);
            }
            if (this.fpD != null) {
                com.baidu.tbadk.core.util.ak.h(this.fpD, d.C0126d.cp_cont_d);
            }
            if (this.fpI != null) {
                com.baidu.tbadk.n.a.a(this.fhQ.getPageContext(), this.fpI);
            }
            if (this.fqg != null) {
                com.baidu.tbadk.n.a.a(this.fhQ.getPageContext(), this.fqg);
            }
            if (this.fqY != null) {
                this.fqY.onChangeSkinType(i);
            }
            if (this.fpd != null) {
                if (this.foX != null) {
                    this.foX.qE(i);
                } else {
                    this.fpd.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fqq != null) {
                com.baidu.tbadk.core.util.ak.h(this.fqq, d.C0126d.cp_cont_e);
            }
            if (this.fpr != null) {
                com.baidu.tbadk.core.util.ak.c(this.fpr, BitmapHelper.getGradeResourceIdInEnterForum(this.frg));
            }
            if (this.frn != null) {
                this.frn.onChangeSkinType(i);
            }
            if (this.fqO != null) {
                this.fqO.onChangeSkinType();
            }
            if (this.frk != null) {
                com.baidu.tbadk.core.util.ak.h(this.frk, d.C0126d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWx = hVar;
        this.fpP.setOnImageClickListener(this.aWx);
        this.frn.setOnImageClickListener(this.aWx);
    }

    public void h(NoNetworkView.a aVar) {
        this.cWl = aVar;
        if (this.cIH != null) {
            this.cIH.a(this.cWl);
        }
    }

    public void kn(boolean z) {
        this.fpP.setIsFromCDN(z);
    }

    public Button bau() {
        return this.fqo;
    }

    public void bav() {
        if (this.fpc != 2) {
            this.fph.setNextPage(this.dcH);
            this.fpc = 2;
        }
    }

    public void baw() {
        if (com.baidu.tbadk.k.p.GY().GZ()) {
            int lastVisiblePosition = this.fph.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fph.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog = tbImageView.getPerfLog();
                                perfLog.fj(1001);
                                perfLog.aKN = true;
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
                        perfLog2.aKN = true;
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
        return this.JO != null && this.JO.getVisibility() == 0;
    }

    public boolean bay() {
        return this.JO != null && this.JO.DG();
    }

    public void baz() {
        if (this.JO != null) {
            this.JO.BY();
        }
    }

    public void ko(boolean z) {
        if (this.fqp != null) {
            km(this.fhQ.aWJ().Ei());
            if (this.fqn) {
                kd(z);
            } else {
                ke(z);
            }
        }
    }

    public void baA() {
        if (this.fqp != null) {
            this.fqp.setVisibility(8);
            this.fqu = false;
            if (this.fqO != null) {
                this.fqO.setVisibility(8);
                ki(false);
            }
            baM();
        }
    }

    public void showLoadingDialog() {
        if (this.czv == null) {
            this.czv = new com.baidu.tbadk.core.view.a(this.fhQ.getPageContext());
        }
        this.czv.aI(true);
    }

    public void aav() {
        if (this.czv != null) {
            this.czv.aI(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fph.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fph.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.foX != null) {
            this.foX.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eHm = getScrollY();
            this.fqN.frV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fqN));
            a(this.fqN.frV, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.foX != null) {
            this.foX.b(absListView, i);
        }
        int headerViewsCount = (i - this.fph.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fpP.qh(headerViewsCount) == com.baidu.tieba.pb.data.j.fdM) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fph.getHeaderViewsCount();
        if (this.fpl != null && this.fpd != null) {
            this.fpd.g(this.fpl.getBottom(), this.fpl.getMeasuredHeight(), z2);
        }
        this.fpP.aXR().j(z, this.fqG != null ? this.fqG.getMeasuredHeight() : 0);
        this.fqN.eYI = i;
        this.fqN.headerCount = this.fph.getHeaderViewsCount();
        this.fqN.frV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fqN));
        a(this.fqN.frV, false);
    }

    public void baB() {
        if (this.fhQ.isLogin() && this.flr != null && this.frd && !this.frc && !this.fql && this.fqy != null && this.fqy.rP() != null && !this.fqy.rP().getIsLike() && !this.fqy.rP().hadConcerned()) {
            if (this.fqZ == null) {
                this.fqZ = new am(this.fhQ);
            }
            this.fqZ.a(this.fpd.fud, this.flr.aVQ(), this.fqy.rP().getUserId(), this.flr.getThreadId());
        }
    }

    public void baC() {
        if (this.frd && !this.frc && this.fqy != null && this.fqy.rP() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12601").r("obj_locate", this.fhQ.aXy() ? 2 : 1).r("obj_type", this.frc ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fhQ.getPageContext().getPageActivity(), this.fqy.rP().getUserId(), this.fqy.rP().getUserName(), this.fhQ.aWx().aYi(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.frc && this.fqH != null && this.fpd.bbf() != null) {
            int aXO = this.fpP.aXO();
            if (aXO > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (aXO > this.fph.getFirstVisiblePosition() - this.fph.getHeaderViewsCount()) {
                    this.fqH.setVisibility(8);
                    return;
                }
                this.fqH.setVisibility(0);
                this.fpd.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fok == null) {
                if (this.fph.getFirstVisiblePosition() == 0) {
                    this.fqH.setVisibility(8);
                    this.fpd.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fqM) {
                        this.fqL = top;
                        this.fqM = false;
                    }
                    this.fqL = top < this.fqL ? top : this.fqL;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.fpO.getY() < 0.0f) {
                        measuredHeight = fqK - akVar.fok.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fpd.bbf().getMeasuredHeight() - akVar.fok.getMeasuredHeight();
                        this.fpd.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fqL) {
                        this.fqH.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fqH.setVisibility(0);
                    } else {
                        this.fqH.setVisibility(8);
                        this.fpd.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fqM = true;
                    }
                }
            }
        }
    }

    public void baD() {
        if (!this.frH) {
            TiebaStatic.log("c10490");
            this.frH = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fhQ.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fqR, Integer.valueOf(fqT));
            aVar.bZ(d.k.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.k.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.k.grade_thread_tips);
            aVar.w(inflate);
            aVar.z(sparseArray);
            aVar.a(d.k.grade_button_tips, this.fhQ);
            aVar.b(d.k.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fhQ.getPageContext()).tC();
        }
    }

    public void qG(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fhQ.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.w(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fqR, Integer.valueOf(fqU));
        aVar.z(sparseArray);
        aVar.a(d.k.view, this.fhQ);
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fhQ.getPageContext()).tC();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.rP() != null) {
            MetaData rP = b.rP();
            rP.setGiftNum(rP.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView baE() {
        return this.fqD;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aVs() != null && dVar.aVs().sE() && this.fqD == null) {
            this.fqD = (PbInterviewStatusView) this.fqC.inflate();
            this.fqD.setOnClickListener(this.cZX);
            this.fqD.setCallback(this.fhQ.aXt());
            this.fqD.setData(this.fhQ, dVar);
        }
    }

    public LinearLayout baF() {
        return this.fpO;
    }

    public View baG() {
        return this.dak;
    }

    public boolean baH() {
        return this.frt;
    }

    public void jw(boolean z) {
        this.fpm.jw(z);
    }

    public void qH(String str) {
        if (this.fpe != null) {
            this.fpe.setTitle(str);
        }
    }

    private int kp(boolean z) {
        if (this.fqD == null || this.fqD.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void baI() {
        if (this.fqD != null && this.fqD.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fqD.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fqD.setLayoutParams(layoutParams);
        }
    }

    public boolean aWP() {
        return false;
    }

    public void qI(String str) {
        this.fqq.performClick();
        if (!StringUtils.isNull(str) && this.fhQ.aWJ() != null && this.fhQ.aWJ().Ec() != null && this.fhQ.aWJ().Ec().getInputView() != null) {
            EditText inputView = this.fhQ.aWJ().Ec().getInputView();
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
            if (this.fqY != null) {
                this.fqY.aXV();
            }
            this.fhQ.apC();
            this.fpO.setVisibility(8);
            this.fpd.kB(false);
            this.fhQ.jC(false);
            if (this.foX != null) {
                if (configuration.orientation == 1) {
                    baF().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fph.setIsLandscape(true);
                    this.fph.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fph.setIsLandscape(false);
                    if (this.eHm > 0) {
                        this.fph.smoothScrollBy(this.eHm, 0);
                    }
                }
                this.foX.onConfigurationChanged(configuration);
            }
        }
    }

    public void kq(boolean z) {
        this.fpb = z;
    }

    public boolean baJ() {
        return this.foX != null && this.foX.baJ();
    }

    public void baK() {
        if (this.foX != null) {
            this.foX.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.foZ != null) {
            this.foZ.y(j, i);
        }
        if (this.foX != null) {
            this.foX.y(j, i);
        }
    }

    public void jH(boolean z) {
        this.fpP.jH(z);
    }

    public void baL() {
        if (this.fqE == null) {
            LayoutInflater.from(this.fhQ.getActivity()).inflate(d.i.add_experienced_text, (ViewGroup) this.cIJ, true);
            this.fqE = (ViewGroup) this.cIJ.findViewById(d.g.add_experienced_layout);
            this.fqF = (TextView) this.cIJ.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.ak.h(this.fqF, d.C0126d.cp_cont_i);
            String string = this.fhQ.getResources().getString(d.k.experienced_add_success);
            String string2 = this.fhQ.getResources().getString(d.k.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_h)));
            this.fqF.setText(spannableString);
        }
        this.fqE.setVisibility(0);
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
                        as.this.fqE.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                as.this.fqF.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fqF.startAnimation(scaleAnimation);
    }

    public void bf(final View view2) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fqp.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view2.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fhQ);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.frk = new TextView(this.fhQ);
            this.frk.setText(d.k.connection_tips);
            this.frk.setGravity(17);
            this.frk.setPadding(com.baidu.adp.lib.util.l.e(this.fhQ, d.e.ds24), 0, com.baidu.adp.lib.util.l.e(this.fhQ, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.e(this.fhQ, d.e.ds60);
            if (this.frk.getParent() == null) {
                frameLayout.addView(this.frk, layoutParams);
            }
            this.frj = new PopupWindow(this.fhQ);
            this.frj.setContentView(frameLayout);
            this.frj.setHeight(-2);
            this.frj.setWidth(-2);
            this.frj.setFocusable(true);
            this.frj.setOutsideTouchable(false);
            this.frj.setBackgroundDrawable(new ColorDrawable(this.fhQ.getResources().getColor(d.C0126d.transparent)));
            this.fph.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        as.this.frj.showAsDropDown(as.this.fqp, view2.getLeft(), -as.this.fqp.getHeight());
                    } else {
                        as.this.frj.showAsDropDown(view2);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.baW() != null && !StringUtils.isNull(aVar.baW().pkg_id) && !StringUtils.isNull(aVar.baW().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fqr != null && this.fqr.getVisibility() == 0) {
            if (this.fri == null) {
                View inflate = LayoutInflater.from(this.fhQ.getPageContext().getPageActivity()).inflate(d.i.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.k.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.cZX);
                this.fri = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fqr.getLocationInWindow(iArr);
            this.fri.showAtLocation(this.fqr, 0, iArr[0] - com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fqr.getHeight()) - com.baidu.adp.lib.util.l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void baM() {
        com.baidu.adp.lib.g.g.a(this.fri);
    }

    public void kr(boolean z) {
        this.frp = z;
    }

    public boolean baN() {
        return this.frp;
    }

    public void bg(View view2) {
        this.fqg = view2;
    }
}
