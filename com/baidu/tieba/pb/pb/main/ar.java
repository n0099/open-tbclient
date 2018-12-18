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
    private EditorTools Ta;
    private j.b aIE;
    private TextView aKh;
    private TextView aiY;
    private NavigationBarCoverTip alo;
    private View bfh;
    private com.baidu.tieba.pb.a.c brN;
    private List<CustomBlueCheckRadioButton> cXg;
    private View.OnClickListener dJU;
    private View dKj;
    private PbListView dNE;
    private View dbn;
    private NoNetworkView dop;
    private RelativeLayout dor;
    private com.baidu.tieba.NEGFeedBack.e ehm;
    private PbActivity fUU;
    PbActivity.d fUa;
    private View.OnClickListener fVs;
    private UserIconBox fWe;
    private UserIconBox fWf;
    private PbFakeFloorModel fXn;
    private com.baidu.tieba.pb.data.d fYu;
    public int gbM;
    private com.baidu.tieba.pb.video.i gbN;
    private long gbO;
    private com.baidu.tieba.pb.video.h gbP;
    private com.baidu.tieba.c.d gbQ;
    public final com.baidu.tieba.pb.pb.main.view.b gbT;
    public com.baidu.tieba.pb.pb.main.view.a gbU;
    private ViewStub gbV;
    private ViewStub gbW;
    private PbLandscapeListView gbX;
    private View gbY;
    private View gcA;
    private View gcB;
    private ObservedChangeLinearLayout gcD;
    private f gcE;
    private View gcK;
    private LinearLayout gcb;
    private e gcc;
    private ColumnLayout gcd;
    private ThreadSkinView gce;
    private TextView gcf;
    private TextView gcg;
    private ImageView gch;
    private HeadPendantView gci;
    private FrameLayout gcj;
    private HeadImageView gck;
    private View gcl;
    private FloatingLayout gcm;
    private PbFirstFloorUserLikeButton gcp;
    private ap gcq;
    private ap gcr;
    private TextView gcs;
    private TextView gct;
    private TextView gcu;
    private View gcv;
    private View gcw;
    private LinearLayout gcx;
    private TextView gcy;
    private TextView gcz;
    private PbEmotionBar gdD;
    private int gdL;
    private Runnable gdM;
    private s gdN;
    private an gdO;
    private int gdU;
    private PbTopTipView gdW;
    private PopupWindow gdX;
    private PopupWindow gdY;
    private TextView gdZ;
    private View gde;
    private TextView gdf;
    private ImageView gdg;
    private ImageView gdh;
    private TextView gdi;
    private boolean gdk;
    private int gdl;
    private int gdm;
    private PostData gdn;
    private View gdp;
    private TextView gdq;
    private ViewStub gdr;
    private PbInterviewStatusView gds;
    private ViewGroup gdt;
    private TextView gdu;
    private FrameLayout gdv;
    private View gdw;
    private View gdx;
    private al gdy;
    private com.baidu.tbadk.core.dialog.a gea;
    private List<String> geb;
    private com.baidu.tieba.pb.pb.main.emotion.c gec;
    private com.baidu.tieba.pb.pb.godreply.a ged;
    private PbLandscapeListView.b gee;
    private ac geg;
    private boolean gei;
    private com.baidu.tbadk.core.view.userLike.c gej;
    private com.baidu.tbadk.core.view.userLike.c gek;
    private Runnable geq;
    private PbActivity.b ges;
    private int gex;
    private boolean isLandscape;
    private int mType;
    private static final int gdz = UtilHelper.getLightStatusBarHeight();
    public static int gdF = 3;
    public static int gdG = 0;
    public static int gdH = 3;
    public static int gdI = 4;
    public static int gdJ = 5;
    public static int gdK = 6;
    private static a.InterfaceC0314a geh = new a.InterfaceC0314a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0314a
        public void onRefresh() {
        }
    };
    private boolean gbR = false;
    private int gbS = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout gbZ = null;
    private TextView gca = null;
    public FrsPraiseView gcn = null;
    private ClickableHeaderImageView gco = null;
    private View gcC = null;
    private com.baidu.tbadk.core.dialog.a gcF = null;
    private com.baidu.tbadk.core.dialog.b dJT = null;
    private View gcG = null;
    private EditText gcH = null;
    private com.baidu.tieba.pb.view.d gcI = null;
    private com.baidu.tieba.pb.view.a gcJ = null;
    private com.baidu.tbadk.core.dialog.a gcL = null;
    private b.InterfaceC0158b eSU = null;
    private TbRichTextView.h brM = null;
    private NoNetworkView.a dFP = null;
    private Dialog gcM = null;
    private View gcN = null;
    private com.baidu.tbadk.core.dialog.a gcO = null;
    private Dialog gcP = null;
    private Dialog gcQ = null;
    private View gcR = null;
    private LinearLayout gcS = null;
    private CompoundButton.OnCheckedChangeListener cXh = null;
    private TextView gcT = null;
    private TextView gcU = null;
    private View gcV = null;
    private String gcW = null;
    private com.baidu.tbadk.core.dialog.b gcX = null;
    private com.baidu.tbadk.core.dialog.b gcY = null;
    private boolean gcZ = false;
    private boolean gda = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView gdb = null;
    private boolean gdc = false;
    private Button gdd = null;
    private boolean gdj = true;
    private com.baidu.tbadk.core.view.d deE = null;
    private boolean fVl = false;
    private int mSkinType = 3;
    private boolean gdo = false;
    private int gdA = 0;
    private boolean gdB = true;
    private a gdC = new a();
    private int gdE = 0;
    private boolean gdP = false;
    private int gdQ = 0;
    private boolean gdR = false;
    private boolean gdS = false;
    private boolean gdT = false;
    private int gdV = 0;
    private boolean gef = false;
    private String gel = null;
    private CustomMessageListener gem = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.gel = null;
            }
        }
    };
    private CustomMessageListener bQv = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.gcE != null) {
                ar.this.gcE.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gen = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.gca != null) {
                ar.this.gca.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler gep = new Handler();
    private CustomMessageListener ger = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.gdj = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean get = true;
    View.OnClickListener geu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.gdR) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (ar.this.gbT != null && ar.this.gbT.ghb != null && view == ar.this.gbT.ghb.getHeadView()) {
                if (ar.this.gbT.ggZ == null || ar.this.gbT.ggZ.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").x("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!ar.this.gdR && ar.this.fYu != null && ar.this.fYu.bgj() != null && ar.this.fYu.bgj().zG() != null && ar.this.fYu.bgj().zG().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").x("obj_locate", 1));
            }
            ar.this.fUU.fSY.eig.onClick(view);
        }
    };
    private boolean gev = false;
    String userId = null;
    private final List<TbImageView> gew = new ArrayList();
    private boolean gey = false;

    /* loaded from: classes6.dex */
    public static class a {
        public int fLr;
        public al geM;
        public int headerCount;
    }

    public void lg(boolean z) {
        this.gdP = z;
        if (this.gbX != null) {
            this.gdQ = this.gbX.getHeaderViewsCount();
        }
    }

    public void bkv() {
        if (this.gbX != null) {
            int headerViewsCount = this.gbX.getHeaderViewsCount() - this.gdQ;
            final int firstVisiblePosition = (this.gbX.getFirstVisiblePosition() == 0 || this.gbX.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.gbX.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.gbX.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.gdC.geM = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.gdC));
            final al alVar = this.gdC.geM;
            final int h = h(alVar);
            final int y = ((int) this.gcD.getY()) + this.gcD.getMeasuredHeight();
            final boolean z = this.gdw.getVisibility() == 0;
            boolean z2 = this.gcD.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.gcE.biJ() + this.gbX.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.gbm.getMeasuredHeight() : 0;
                if (z2) {
                    this.gbX.setSelectionFromTop(this.gcE.biJ() + this.gbX.getHeaderViewsCount(), gdz - measuredHeight);
                } else {
                    this.gbX.setSelectionFromTop(this.gcE.biJ() + this.gbX.getHeaderViewsCount(), this.gbT.bmf().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.gbX.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.gdR) {
                this.gbX.setSelectionFromTop(this.gcE.biJ() + this.gbX.getHeaderViewsCount(), this.gbN.bnt().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.gbX.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bja() {
                        if (h >= 0 && h <= ar.this.dor.getMeasuredHeight()) {
                            int h2 = ar.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.dbn.getLayoutParams();
                            if (i == 0 || i > ar.this.dor.getMeasuredHeight() || h2 >= ar.this.dor.getMeasuredHeight()) {
                                layoutParams.height = ar.this.gdL;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.dor.getMeasuredHeight()) {
                                layoutParams.height = ar.this.gdL;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.gbX.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.dbn.setLayoutParams(layoutParams);
                        }
                        ar.this.gbX.setOnLayoutListener(null);
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

    public NoNetworkView bkw() {
        return this.dop;
    }

    public void bkx() {
        if (this.Ta != null) {
            this.Ta.hide();
            if (this.gec != null) {
                this.gec.ZA();
            }
        }
    }

    public PbFakeFloorModel bky() {
        return this.fXn;
    }

    public s bkz() {
        return this.gdN;
    }

    public void bkA() {
        reset();
        bkx();
        this.gdN.biQ();
        ls(false);
    }

    private void reset() {
        if (this.fUU != null && this.fUU.bhz() != null && this.Ta != null) {
            com.baidu.tbadk.editortools.pb.a.Mt().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bhz = this.fUU.bhz();
            bhz.MM();
            bhz.Mh();
            if (bhz.getWriteImagesInfo() != null) {
                bhz.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bhz.fQ(SendView.ALL);
            bhz.fR(SendView.ALL);
            com.baidu.tbadk.editortools.g fH = this.Ta.fH(23);
            com.baidu.tbadk.editortools.g fH2 = this.Ta.fH(2);
            com.baidu.tbadk.editortools.g fH3 = this.Ta.fH(5);
            if (fH2 != null) {
                fH2.pN();
            }
            if (fH3 != null) {
                fH3.pN();
            }
            if (fH != null) {
                fH.hide();
            }
            this.Ta.invalidate();
        }
    }

    public boolean bkB() {
        return this.gdj;
    }

    public void lh(boolean z) {
        if (this.gde != null && this.gdf != null) {
            this.gdf.setText(e.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.gde.startAnimation(alphaAnimation);
            }
            this.gde.setVisibility(0);
            this.gdj = true;
            if (this.gdD != null && !this.ged.isActive()) {
                this.gdD.setVisibility(0);
                lm(true);
            }
        }
    }

    public void li(boolean z) {
        if (this.gde != null && this.gdf != null) {
            this.gdf.setText(e.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.gde.startAnimation(alphaAnimation);
            }
            this.gde.setVisibility(0);
            this.gdj = true;
            if (this.gdD != null && !this.ged.isActive()) {
                this.gdD.setVisibility(0);
                lm(true);
            }
        }
    }

    public PostData bkC() {
        int i = 0;
        if (this.gbX == null) {
            return null;
        }
        int bkD = bkD() - this.gbX.getHeaderViewsCount();
        if (bkD < 0) {
            bkD = 0;
        }
        if (this.gcE.sh(bkD) != null && this.gcE.sh(bkD) != PostData.hlm) {
            i = bkD + 1;
        }
        return this.gcE.getItem(i) instanceof PostData ? (PostData) this.gcE.getItem(i) : null;
    }

    public int bkD() {
        int i;
        View childAt;
        if (this.gbX == null) {
            return 0;
        }
        int firstVisiblePosition = this.gbX.getFirstVisiblePosition();
        int lastVisiblePosition = this.gbX.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.gbX.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.gbX.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bkE() {
        return this.gbX.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fYu != null && this.fYu.bgl() != null && !this.fYu.bgl().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fYu.bgl().size() && (postData = this.fYu.bgl().get(i)) != null && postData.zG() != null && !StringUtils.isNull(postData.zG().getUserId()); i++) {
                if (this.fYu.bgl().get(i).zG().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.ged != null && this.ged.isActive()) {
                        ls(false);
                    }
                    if (this.gdD != null) {
                        this.gdD.lA(true);
                    }
                    this.gel = postData.zG().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fUU = null;
        this.dor = null;
        this.dKj = null;
        this.gbO = 0L;
        this.gbX = null;
        this.gbY = null;
        this.gcb = null;
        this.gcd = null;
        this.gcf = null;
        this.gcg = null;
        this.gcj = null;
        this.gck = null;
        this.gcl = null;
        this.gcp = null;
        this.gcs = null;
        this.gct = null;
        this.gcu = null;
        this.gcv = null;
        this.gcA = null;
        this.gcB = null;
        this.gcE = null;
        this.dNE = null;
        this.bfh = null;
        this.dJU = null;
        this.fVs = null;
        this.gde = null;
        this.gdf = null;
        this.gdg = null;
        this.gdh = null;
        this.gdi = null;
        this.gdp = null;
        this.gdq = null;
        this.gdr = null;
        this.gdU = 0;
        this.gbO = System.currentTimeMillis();
        this.fUU = pbActivity;
        this.dJU = onClickListener;
        this.brN = cVar;
        this.gdU = com.baidu.adp.lib.util.l.aO(this.fUU) / 2;
        this.dor = (RelativeLayout) LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.new_pb_activity, (ViewGroup) null);
        this.fUU.addContentView(this.dor, new FrameLayout.LayoutParams(-1, -1));
        this.alo = (NavigationBarCoverTip) this.fUU.findViewById(e.g.pb_multi_forum_del_tip_view);
        this.dKj = this.fUU.findViewById(e.g.statebar_view);
        this.gcD = (ObservedChangeLinearLayout) this.fUU.findViewById(e.g.title_wrapper);
        this.dop = (NoNetworkView) this.fUU.findViewById(e.g.view_no_network);
        this.gbX = (PbLandscapeListView) this.fUU.findViewById(e.g.new_pb_list);
        this.gdv = (FrameLayout) this.fUU.findViewById(e.g.root_float_header);
        this.aiY = new TextView(this.fUU.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds88));
        this.gbX.addHeaderView(this.aiY, 0);
        this.gdL = this.fUU.getResources().getDimensionPixelSize(e.C0210e.tbds134);
        this.dbn = new View(this.fUU.getPageContext().getPageActivity());
        this.dbn.setLayoutParams(new AbsListView.LayoutParams(-1, this.gdL));
        this.dbn.setVisibility(4);
        this.gbX.addFooterView(this.dbn);
        this.gbX.setOnTouchListener(this.fUU.biM);
        this.gbT = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fUU.bid()) {
            this.gbV = (ViewStub) this.fUU.findViewById(e.g.manga_view_stub);
            this.gbV.setVisibility(0);
            this.gbU = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.gbU.show();
            this.gbT.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds120);
        }
        this.aiY.setLayoutParams(layoutParams);
        this.gbT.bmf().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0279a() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0279a
            public void bgX() {
                if (ar.this.gbX != null) {
                    if (ar.this.gbN != null) {
                        ar.this.gbN.bnu();
                    }
                    ar.this.gbX.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0279a
            public void bgY() {
                ar.this.fUU.aAY();
            }
        }));
        this.gde = this.fUU.findViewById(e.g.pb_editor_tool_comment);
        this.gdl = com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds90);
        this.gdm = com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds242);
        this.gdf = (TextView) this.fUU.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_reply_text);
        this.gdh = (ImageView) this.fUU.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_more_img);
        this.gdg = (ImageView) this.fUU.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_emotion_img);
        this.gdi = (TextView) this.fUU.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_praise_icon);
        this.gdi.setVisibility(8);
        this.gdf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bkF();
            }
        });
        this.gdg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.blH();
                if (ar.this.fUU.checkUpIsLogin()) {
                    if (ar.this.Ta != null) {
                        ar.this.bkP();
                        ar.this.Ta.aa((View) ar.this.Ta.fH(5));
                    }
                    if (ar.this.Ta != null) {
                        ar.this.gdj = false;
                        if (ar.this.Ta.fK(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fUU, (View) ar.this.Ta.fK(2).aYi, false, ar.geh);
                        }
                    }
                    ar.this.blu();
                }
            }
        });
        this.gdh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.blH();
                if (ar.this.fUU.checkUpIsLogin()) {
                    if (ar.this.Ta != null) {
                        ar.this.bkP();
                        ar.this.Ta.aa((View) ar.this.Ta.fH(2));
                    }
                    if (ar.this.Ta != null) {
                        ar.this.gdj = false;
                        if (ar.this.Ta.fK(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fUU, (View) ar.this.Ta.fK(2).aYi, false, ar.geh);
                        }
                    }
                    ar.this.blu();
                }
            }
        });
        this.gdi.setOnClickListener(this.dJU);
        this.gdi.setOnTouchListener(this.fUU);
        this.gbY = LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_item, (ViewGroup) null);
        this.gcb = (LinearLayout) LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_user_item, (ViewGroup) null);
        this.gcc = new e(this.fUU, this.gcb);
        this.gcc.init();
        this.gcc.a(this.gcc.bhy(), this.dJU);
        this.gcd = (ColumnLayout) this.gcb.findViewById(e.g.pb_head_owner_root);
        this.gce = (ThreadSkinView) this.gcb.findViewById(e.g.pb_thread_skin);
        this.gcd.setOnLongClickListener(this.onLongClickListener);
        this.gcd.setOnTouchListener(this.brN);
        this.gcd.setVisibility(8);
        this.gbY.setOnTouchListener(this.brN);
        this.gdp = this.gbY.findViewById(e.g.pb_head_activity_join_number_container);
        this.gdp.setVisibility(8);
        this.gdq = (TextView) this.gbY.findViewById(e.g.pb_head_activity_join_number);
        this.gcf = (TextView) this.gcd.findViewById(e.g.pb_head_owner_info_user_name);
        this.gcg = (TextView) this.gcd.findViewById(e.g.floor_owner);
        this.gch = (ImageView) this.gcd.findViewById(e.g.icon_forum_level);
        this.gcj = (FrameLayout) this.gcd.findViewById(e.g.pb_head_headImage_container);
        this.gck = (HeadImageView) this.gcd.findViewById(e.g.pb_head_owner_photo);
        this.gci = (HeadPendantView) this.gcd.findViewById(e.g.pb_pendant_head_owner_photo);
        this.gci.setHasPendantStyle();
        if (this.gci.getHeadView() != null) {
            this.gci.getHeadView().setIsRound(true);
            this.gci.getHeadView().setDrawBorder(false);
        }
        this.fWe = (UserIconBox) this.gcd.findViewById(e.g.show_icon_vip);
        this.fWf = (UserIconBox) this.gcd.findViewById(e.g.show_icon_yinji);
        this.gcm = (FloatingLayout) this.gcb.findViewById(e.g.pb_head_owner_info_root);
        this.gcp = (PbFirstFloorUserLikeButton) this.gcd.findViewById(e.g.pb_like_button);
        this.gcs = (TextView) this.gcd.findViewById(e.g.pb_views);
        this.aKh = (TextView) this.gcd.findViewById(e.g.view_forum_name);
        this.gcw = this.gcd.findViewById(e.g.line_right_forum_name);
        this.gct = (TextView) this.gcd.findViewById(e.g.pb_item_first_floor_reply_time);
        this.gcu = (TextView) this.gcd.findViewById(e.g.pb_item_first_floor_location_address);
        this.gcv = this.gcd.findViewById(e.g.line_between_time_and_locate);
        this.gej = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.gek = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.gcA = this.gbY.findViewById(e.g.new_pb_header_item_line_above_livepost);
        this.gcB = this.gbY.findViewById(e.g.new_pb_header_item_line_below_livepost);
        this.gbY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.37
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.gdr = (ViewStub) this.dor.findViewById(e.g.interview_status_stub);
        this.gcE = new f(this.fUU, this.gbX);
        this.gcE.w(this.dJU);
        this.gcE.setTbGestureDetector(this.brN);
        this.gcE.setOnImageClickListener(this.brM);
        this.fVs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.38
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
                            ar.this.fUU.b(sparseArray);
                            return;
                        }
                        ar.this.bC(view);
                    } else if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 0);
                        sparseArray.put(e.g.tag_check_mute_from, 1);
                        ar.this.fUU.b(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.gcE.I(this.fVs);
        bkK();
        this.gbX.addHeaderView(this.gbZ);
        this.gbX.addHeaderView(this.gcb);
        this.gbX.addHeaderView(this.gbY);
        this.dNE = new PbListView(this.fUU.getPageContext().getPageActivity());
        this.bfh = this.dNE.getView().findViewById(e.g.pb_more_view);
        if (this.bfh != null) {
            this.bfh.setOnClickListener(this.dJU);
            com.baidu.tbadk.core.util.al.i(this.bfh, e.f.pb_foot_more_trans_selector);
        }
        this.dNE.EY();
        this.dNE.ev(e.f.pb_foot_more_trans_selector);
        this.dNE.ex(e.f.pb_foot_more_trans_selector);
        this.gcK = this.fUU.findViewById(e.g.viewstub_progress);
        this.fUU.registerListener(this.ger);
        this.gcl = com.baidu.tbadk.ala.b.vZ().j(this.fUU.getActivity(), 2);
        if (this.gcl != null) {
            this.gcl.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fUU.getResources().getDimensionPixelSize(e.C0210e.ds10);
            if (this.gcl.getParent() == null) {
                this.gcm.addView(this.gcl, aVar);
            }
        }
        this.fXn = new PbFakeFloorModel(this.fUU.getPageContext());
        this.gdN = new s(this.fUU.getPageContext(), this.fXn, this.dor);
        this.gdN.a(this.fUU.fTW);
        this.fXn.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.fXn.m(postData);
                ar.this.gcE.notifyDataSetChanged();
                ar.this.gdN.biQ();
                ar.this.Ta.Kw();
                ar.this.ls(false);
            }
        });
        if (this.fUU.bhn() != null && !StringUtils.isNull(this.fUU.bhn().bjH())) {
            this.fUU.showToast(this.fUU.bhn().bjH());
        }
        this.gdw = this.fUU.findViewById(e.g.pb_expand_blank_view);
        this.gdx = this.fUU.findViewById(e.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gdx.getLayoutParams();
        if (this.fUU.bhn() != null && this.fUU.bhn().bjg()) {
            this.gdw.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.gdx.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = gdz;
            this.gdx.setLayoutParams(layoutParams2);
        }
        this.gdy = new al(this.fUU.getPageContext(), this.fUU.findViewById(e.g.pb_reply_expand_view));
        this.gdy.gbm.setVisibility(8);
        this.gdy.L(this.dJU);
        this.fUU.registerListener(this.bQv);
        this.fUU.registerListener(this.gem);
        this.fUU.registerListener(this.gen);
        bkG();
        lm(false);
    }

    public void bkF() {
        blH();
        if (!this.fUU.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).aA(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.fUU.bhL()) {
            com.baidu.tbadk.editortools.pb.d bhz = this.fUU.bhz();
            if (bhz != null && (bhz.MJ() || bhz.MK())) {
                this.fUU.bhz().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Ta != null) {
                bkP();
            }
            if (this.Ta != null) {
                this.gdj = false;
                if (this.Ta.fK(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.fUU, (View) this.Ta.fK(2).aYi, false, geh);
                }
            }
            blu();
        }
    }

    private void bkG() {
        this.ged = new com.baidu.tieba.pb.pb.godreply.a(this.fUU, this, (ViewStub) this.dor.findViewById(e.g.more_god_reply_popup));
        this.ged.s(this.dJU);
        this.ged.I(this.fVs);
        this.ged.setOnImageClickListener(this.brM);
        this.ged.s(this.dJU);
        this.ged.setTbGestureDetector(this.brN);
    }

    public com.baidu.tieba.pb.pb.godreply.a bkH() {
        return this.ged;
    }

    public View bkI() {
        return this.gdw;
    }

    public void bkJ() {
        if (this.gbX != null) {
            this.gbX.removeHeaderView(this.gbZ);
            this.gbX.removeHeaderView(this.gcb);
            this.gbX.removeHeaderView(this.gbY);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.gdD == null) {
            this.gdD = new PbEmotionBar(this.fUU.getPageContext().getPageActivity());
            lm(true);
            this.gdD.a(this.dor, aVar, this.gde.getVisibility() == 0);
            this.gdD.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (ar.this.fUU.bhL()) {
                        if (!StringUtils.isNull(ar.this.gel)) {
                            emotionImageData.setAuthorNameShow(ar.this.gel);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fUU.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fUU.getPageContext().getPageActivity(), 25016, str, list, ar.this.gel, list2)));
                }
            });
            this.gdD.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    ar.this.blH();
                    if (ar.this.gde != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.gde.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.gdm - ar.this.gdl) * f) + ar.this.gdl);
                        ar.this.gdf.setAlpha(1.0f - f);
                        ar.this.gdh.setAlpha(1.0f - f);
                        ar.this.gdg.setAlpha(1.0f - f);
                        ar.this.gde.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bkK() {
        if (this.gbZ == null) {
            int h = com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.tbds44);
            this.gbZ = new LinearLayout(this.fUU.getPageContext().getPageActivity());
            this.gbZ.setOrientation(1);
            this.gbZ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gbZ.setPadding(h, com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.tbds30), h, com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.tbds40));
            this.gbZ.setGravity(17);
            this.gca = new TextView(this.fUU.getPageContext().getPageActivity());
            this.gca.setGravity(3);
            this.gca.setMaxLines(2);
            this.gca.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            this.gca.setPadding(0, 0, 0, 0);
            this.gca.setLineSpacing(com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.gca, e.d.cp_cont_b);
            this.gca.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.gca.setVisibility(8);
            if (this.gca.getParent() == null) {
                this.gbZ.addView(this.gca);
            }
            this.gbZ.setOnTouchListener(this.brN);
            this.gbZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkL() {
        if (this.fUU.bid()) {
            this.gbW = (ViewStub) this.fUU.findViewById(e.g.manga_mention_controller_view_stub);
            this.gbW.setVisibility(0);
            if (this.gcx == null) {
                this.gcx = (LinearLayout) this.fUU.findViewById(e.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fUU.getPageContext(), this.gcx);
            }
            if (this.gcy == null) {
                this.gcy = (TextView) this.gcx.findViewById(e.g.manga_prev_btn);
            }
            if (this.gcz == null) {
                this.gcz = (TextView) this.gcx.findViewById(e.g.manga_next_btn);
            }
            this.gcy.setOnClickListener(this.dJU);
            this.gcz.setOnClickListener(this.dJU);
        }
    }

    private void bkM() {
        if (this.fUU.bid()) {
            if (this.fUU.big() == -1) {
                com.baidu.tbadk.core.util.al.c(this.gcy, e.d.cp_cont_e, 1);
            }
            if (this.fUU.bih() == -1) {
                com.baidu.tbadk.core.util.al.c(this.gcz, e.d.cp_cont_e, 1);
            }
        }
    }

    public void bkN() {
        if (this.gcx == null) {
            bkL();
        }
        this.gbW.setVisibility(8);
        if (this.gep != null && this.geq != null) {
            this.gep.removeCallbacks(this.geq);
        }
    }

    public void bkO() {
        if (this.gep != null) {
            if (this.geq != null) {
                this.gep.removeCallbacks(this.geq);
            }
            this.geq = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.gcx == null) {
                        ar.this.bkL();
                    }
                    ar.this.gbW.setVisibility(0);
                }
            };
            this.gep.postDelayed(this.geq, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void lj(boolean z) {
        this.gbT.lj(z);
        if (z && this.gdo) {
            this.dNE.setText(this.fUU.getResources().getString(e.j.click_load_more));
            this.gbX.setNextPage(this.dNE);
            this.gbS = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
        this.Ta.setId(e.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Ta.getParent() == null) {
            this.dor.addView(this.Ta, layoutParams);
        }
        this.Ta.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bkx();
        this.fUU.bhz().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.Ta != null && ar.this.Ta.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.gec == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.Ta.getId());
                            ar.this.gec = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fUU.getPageContext(), ar.this.dor, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.I(ar.this.geb)) {
                                ar.this.gec.setData(ar.this.geb);
                            }
                            ar.this.gec.b(ar.this.Ta);
                        }
                        ar.this.gec.th(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fUU.fTc != null && ar.this.fUU.fTc.blM() != null) {
                    if (!ar.this.fUU.fTc.blM().bMX()) {
                        ar.this.fUU.fTc.lx(false);
                    }
                    ar.this.fUU.fTc.blM().or(false);
                }
            }
        });
    }

    public void bkP() {
        if (this.fUU != null && this.Ta != null) {
            this.Ta.pN();
            if (this.fUU.bhz() != null) {
                this.fUU.bhz().MA();
            }
            blu();
        }
    }

    public void W(String str, boolean z) {
        this.gdk = z;
        lk(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void lk(boolean z) {
        if (this.gdi != null) {
            if (this.gdk) {
                com.baidu.tbadk.core.util.al.i(this.gdi, e.f.pb_praise_already_click_selector);
                this.gdi.setContentDescription(this.fUU.getResources().getString(e.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.gdi, e.f.pb_praise_normal_click_selector);
            this.gdi.setContentDescription(this.fUU.getResources().getString(e.j.zan));
        }
    }

    public TextView bkQ() {
        return this.gdi;
    }

    public void ll(boolean z) {
        if (this.gbX != null && this.aiY != null && this.dKj != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dKj.setVisibility(0);
                } else {
                    this.dKj.setVisibility(8);
                    this.gbX.removeHeaderView(this.aiY);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aiY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = gdz;
                    this.aiY.setLayoutParams(layoutParams);
                }
                blf();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aiY.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + lu(true);
                this.aiY.setLayoutParams(layoutParams2);
            }
            blf();
            blC();
        }
    }

    public f bkR() {
        return this.gcE;
    }

    public void a(PbActivity.d dVar) {
        this.fUa = dVar;
    }

    public void bC(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.gcN == null) {
            this.gcN = LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fUU.getLayoutMode().onModeChanged(this.gcN);
        if (this.gcM == null) {
            this.gcM = new Dialog(this.fUU.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.gcM.setCanceledOnTouchOutside(true);
            this.gcM.setCancelable(true);
            this.gcM.setContentView(this.gcN);
            WindowManager.LayoutParams attributes = this.gcM.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.aO(this.fUU.getPageContext().getPageActivity()) * 0.9d);
            this.gcM.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.gcM.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.gcM.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.gcM.findViewById(e.g.disable_reply_btn);
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
                    if (ar.this.gcM != null && (ar.this.gcM instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.gcM, ar.this.fUU.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(e.g.tag_del_post_id), ((Integer) sparseArray5.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(e.g.tag_forbid_user_name)) && "".equals(sparseArray.get(e.g.tag_forbid_user_name_show))) || blB()) {
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
                    if (ar.this.gcM != null && (ar.this.gcM instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.gcM, ar.this.fUU.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.ges != null) {
                        ar.this.ges.m(new Object[]{sparseArray6.get(e.g.tag_manage_user_identity), sparseArray6.get(e.g.tag_forbid_user_name), sparseArray6.get(e.g.tag_forbid_user_post_id), sparseArray6.get(e.g.tag_forbid_user_name_show), sparseArray6.get(e.g.tag_forbid_user_portrait)});
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
                    if (ar.this.gcM != null && (ar.this.gcM instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.gcM, ar.this.fUU.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fUU.a(z, (String) sparseArray7.get(e.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.gcM, this.fUU.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.ges = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fUU != null && aVar != null) {
            if (this.ehm == null) {
                this.ehm = new com.baidu.tieba.NEGFeedBack.e(this.fUU.getPageContext(), this.gbY);
            }
            AntiData azX = this.fUU.azX();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (azX != null && azX.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = azX.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.ehm.setDefaultReasonArray(new String[]{this.fUU.getString(e.j.delete_thread_reason_1), this.fUU.getString(e.j.delete_thread_reason_2), this.fUU.getString(e.j.delete_thread_reason_3), this.fUU.getString(e.j.delete_thread_reason_4), this.fUU.getString(e.j.delete_thread_reason_5)});
            this.ehm.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ehm.jh(str);
            this.ehm.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    ar.this.fUU.a(aVar, jSONArray);
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
        sparseArray.put(gdG, Integer.valueOf(gdH));
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
        this.gcO = new com.baidu.tbadk.core.dialog.a(this.fUU.getActivity());
        if (StringUtils.isNull(str2)) {
            this.gcO.db(i3);
        } else {
            this.gcO.bk(false);
            this.gcO.eB(str2);
        }
        this.gcO.H(sparseArray);
        this.gcO.a(e.j.dialog_ok, this.fUU);
        this.gcO.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.gcO.bf(true);
        this.gcO.b(this.fUU.getPageContext());
        if (z) {
            this.gcO.BF();
        } else {
            a(this.gcO, i);
        }
    }

    public void ap(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.gcR == null) {
            this.gcR = LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.commit_good, (ViewGroup) null);
        }
        this.fUU.getLayoutMode().onModeChanged(this.gcR);
        if (this.gcQ == null) {
            this.gcQ = new Dialog(this.fUU.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.gcQ.setCanceledOnTouchOutside(true);
            this.gcQ.setCancelable(true);
            this.gdb = (ScrollView) this.gcR.findViewById(e.g.good_scroll);
            this.gcQ.setContentView(this.gcR);
            WindowManager.LayoutParams attributes = this.gcQ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds540);
            this.gcQ.getWindow().setAttributes(attributes);
            this.cXh = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.gcW = (String) compoundButton.getTag();
                        if (ar.this.cXg != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ar.this.cXg) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ar.this.gcW != null && !str.equals(ar.this.gcW)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.gcS = (LinearLayout) this.gcR.findViewById(e.g.good_class_group);
            this.gcU = (TextView) this.gcR.findViewById(e.g.dialog_button_cancel);
            this.gcU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.gcQ instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.gcQ, ar.this.fUU.getPageContext());
                    }
                }
            });
            this.gcT = (TextView) this.gcR.findViewById(e.g.dialog_button_ok);
            this.gcT.setOnClickListener(this.dJU);
        }
        this.gcS.removeAllViews();
        this.cXg = new ArrayList();
        CustomBlueCheckRadioButton cp = cp("0", this.fUU.getPageContext().getString(e.j.thread_good_class));
        this.cXg.add(cp);
        cp.setChecked(true);
        this.gcS.addView(cp);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.yv()) && aaVar.yw() > 0) {
                    CustomBlueCheckRadioButton cp2 = cp(String.valueOf(aaVar.yw()), aaVar.yv());
                    this.cXg.add(cp2);
                    View view = new View(this.fUU.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, e.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.gcS.addView(view);
                    this.gcS.addView(cp2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.gdb.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fUU.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fUU.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fUU.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.gdb.setLayoutParams(layoutParams2);
            this.gdb.removeAllViews();
            if (this.gcS != null && this.gcS.getParent() == null) {
                this.gdb.addView(this.gcS);
            }
        }
        com.baidu.adp.lib.g.g.a(this.gcQ, this.fUU.getPageContext());
    }

    private CustomBlueCheckRadioButton cp(String str, String str2) {
        Activity pageActivity = this.fUU.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, e.C0210e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cXh);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bkS() {
        this.fUU.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fUU.hideProgressBar();
        if (z && z2) {
            this.fUU.showToast(this.fUU.getPageContext().getString(e.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.neterror);
            }
            this.fUU.showToast(str);
        }
    }

    public void aSv() {
        this.gcK.setVisibility(0);
    }

    public void aSu() {
        this.gcK.setVisibility(8);
    }

    public View bkT() {
        if (this.gcR != null) {
            return this.gcR.findViewById(e.g.dialog_button_ok);
        }
        return null;
    }

    public String bkU() {
        return this.gcW;
    }

    public View getView() {
        return this.dor;
    }

    public void bkV() {
        com.baidu.adp.lib.util.l.b(this.fUU.getPageContext().getPageActivity(), this.fUU.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fUU.hideProgressBar();
        if (z) {
            bll();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            blm();
        } else {
            bll();
        }
    }

    public void bkW() {
        this.dNE.EY();
        this.dNE.Fc();
    }

    public void bkX() {
        this.fUU.hideProgressBar();
        Fd();
        this.gbX.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bli();
    }

    public void bkY() {
        this.gbX.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        bli();
    }

    private void lm(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gdf.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fUU.getResources().getDimensionPixelSize(e.C0210e.ds130) : this.fUU.getResources().getDimensionPixelSize(e.C0210e.ds34);
        this.gdf.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.gcE.setOnLongClickListener(onLongClickListener);
        if (this.ged != null) {
            this.ged.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z, boolean z2) {
        if (this.gcX != null) {
            this.gcX.dismiss();
            this.gcX = null;
        }
        this.gcX = new com.baidu.tbadk.core.dialog.b(this.fUU.getPageContext().getPageActivity());
        this.gcX.de(e.j.operation);
        if (z2) {
            this.gcX.a(new String[]{this.fUU.getPageContext().getString(e.j.copy), this.fUU.getPageContext().getString(e.j.report_text)}, interfaceC0158b);
        } else if (!z) {
            this.gcX.a(new String[]{this.fUU.getPageContext().getString(e.j.copy), this.fUU.getPageContext().getString(e.j.mark)}, interfaceC0158b);
        } else {
            this.gcX.a(new String[]{this.fUU.getPageContext().getString(e.j.copy), this.fUU.getPageContext().getString(e.j.remove_mark)}, interfaceC0158b);
        }
        this.gcX.d(this.fUU.getPageContext());
        this.gcX.BI();
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z) {
        if (this.gcY != null) {
            this.gcY.dismiss();
            this.gcY = null;
        }
        this.gcY = new com.baidu.tbadk.core.dialog.b(this.fUU.getPageContext().getPageActivity());
        if (z) {
            this.gcY.a(new String[]{this.fUU.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0158b);
        } else {
            this.gcY.a(new String[]{this.fUU.getPageContext().getString(e.j.save_to_emotion), this.fUU.getPageContext().getString(e.j.save_to_local)}, interfaceC0158b);
        }
        this.gcY.d(this.fUU.getPageContext());
        this.gcY.BI();
    }

    public int bkZ() {
        return sy(this.gbX.getFirstVisiblePosition());
    }

    private int sy(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.gbX.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.gbX.getAdapter() == null || !(this.gbX.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.gbX.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bla() {
        int lastVisiblePosition = this.gbX.getLastVisiblePosition();
        if (this.gbN != null) {
            if (lastVisiblePosition == this.gbX.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return sy(lastVisiblePosition);
    }

    public void sz(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.gbX != null) {
            if (this.gbT == null || this.gbT.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.gbT.mNavigationBar.getFixedNavHeight();
                if (!(this.fUU.bhR() != -1)) {
                    if (this.gdx != null && (layoutParams = (LinearLayout.LayoutParams) this.gdx.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.gdx.setLayoutParams(layoutParams);
                    }
                    i--;
                    blG();
                }
                i2 = fixedNavHeight;
            }
            this.gbX.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.gbX.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.gcH.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.gcE.a(dVar, false);
        this.gcE.notifyDataSetChanged();
        bli();
        if (this.ged != null) {
            this.ged.bhj();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.gcn == null) {
            this.fUU.getLayoutMode().onModeChanged(((ViewStub) this.gbY.findViewById(e.g.praise_layout)).inflate());
            this.gcn = (FrsPraiseView) this.gbY.findViewById(e.g.pb_head_praise_view);
            this.gcn.setIsFromPb(true);
            this.gcC = this.gbY.findViewById(e.g.new_pb_header_item_line_above_praise);
            this.gcn.eC(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gcn != null) {
            boolean bli = bli();
            this.gcn.setVisibility(8);
            if (dVar != null && dVar.yS() != null && dVar.yS().yQ() == 0 && this.fVl) {
                if (bli) {
                    this.gcB.setVisibility(0);
                    return;
                } else {
                    this.gcB.setVisibility(8);
                    return;
                }
            }
            this.gcB.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bgt() != null) {
            return dVar.bgt();
        }
        if (!com.baidu.tbadk.core.util.v.I(dVar.bgl())) {
            Iterator<PostData> it = dVar.bgl().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bDr() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bgq();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.zG() != null && postData.zG().getUserTbVipInfoData() != null && postData.zG().getUserTbVipInfoData().getvipIntro() != null) {
            postData.zG().getGodUserData().setIntro(postData.zG().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bgj() == null || dVar.bgj().zG() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zG = dVar.bgj().zG();
        String userId = zG.getUserId();
        HashMap<String, MetaData> userMap = dVar.bgj().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zG;
        }
        postData.vv(1);
        postData.setId(dVar.bgj().zX());
        postData.setTitle(dVar.bgj().getTitle());
        postData.setTime(dVar.bgj().getCreateTime());
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
        com.baidu.tbadk.data.f bDu;
        String portrait;
        if (dVar != null && dVar.bgj() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.gcd.setVisibility(8);
            if (dVar.bgj() != null && dVar.bgj().Au() && dVar.bgj().zY() != null) {
                this.gdR = true;
                this.gbT.lJ(this.gdR);
                this.gbT.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1")) {
                    LinearLayout linearLayout = (LinearLayout) this.fUU.findViewById(e.g.pb_comment_container);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.bottomMargin = gdz;
                    linearLayout.setLayoutParams(layoutParams);
                }
                if (this.gbN == null) {
                    this.gbN = new com.baidu.tieba.pb.video.i(this.fUU, this.gbT, dVar.bgj().zY(), this.gbO);
                    this.gbN.a(dVar.bgj().zY(), dVar.bgj(), dVar.getForumId());
                    this.gbN.startPlay();
                } else if (this.gbR) {
                    this.gbN.a(dVar.bgj().zY(), dVar.bgj(), dVar.getForumId());
                    this.gbN.startPlay();
                } else {
                    this.gbN.ts(dVar.getForumId());
                }
                if (dVar.bgk() != null && dVar.bgk().size() >= 1) {
                    bb bbVar = dVar.bgk().get(0);
                    this.gbN.as(bbVar);
                    this.gbN.tt(bbVar.getTitle());
                }
                this.gbN.b(b, dVar.bgj(), dVar.bgH());
                this.gbR = false;
                this.gbX.removeHeaderView(this.gbN.bnw());
                this.gbX.addHeaderView(this.gbN.bnw(), 0);
                if (this.gbN.bnt() != null && this.gbN.bnt().getParent() == null) {
                    this.gdv.addView(this.gbN.bnt());
                }
                if (this.gbP == null) {
                    this.gbP = new com.baidu.tieba.pb.video.h(this.fUU);
                }
                this.gbP.a(dVar.bgj().AJ(), dVar.bgj(), dVar.bgE());
                this.gbX.removeHeaderView(this.gbP.bnk());
                this.gbX.addHeaderView(this.gbP.bnk(), 1);
                if (dVar.bgj().AJ() != null) {
                    this.gbX.removeHeaderView(this.gbP.bnl());
                    this.gbX.removeHeaderView(this.gcb);
                    this.gbX.addHeaderView(this.gbP.bnl(), 2);
                } else {
                    if (this.gbP.bnl() != null) {
                        this.gbX.removeHeaderView(this.gbP.bnl());
                    }
                    this.gbX.removeHeaderView(this.gcb);
                    this.gcb.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fUU, e.C0210e.tbds26));
                    this.gbX.addHeaderView(this.gcb, 2);
                }
                if (this.gbN != null) {
                    this.gbT.lD(false);
                    this.gbT.lF(TbadkCoreApplication.isLogin());
                    this.gbN.sF(TbadkCoreApplication.getInst().getSkinType());
                }
                blf();
            } else {
                this.gdR = false;
                this.gbT.lJ(this.gdR);
                if (this.gbN != null) {
                    this.gbX.removeHeaderView(this.gbN.bnw());
                }
                if (this.gbP != null) {
                    this.gbP.b(this.gbX);
                }
                if (b == null || (b != null && (b.bDt() == null || com.baidu.tbadk.core.util.v.I(b.bDt().RZ())))) {
                    this.gcb.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fUU, e.C0210e.tbds52));
                } else {
                    this.gcb.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fUU.bhD() != null) {
                this.fUU.bhD().lB(this.gdR);
            }
            if (this.gbN != null) {
                this.gbN.N(this.geu);
                blG();
            }
            if (b != null) {
                this.gdn = b;
                this.gcd.setVisibility(0);
                if (this.fUU.bhd()) {
                    if (dVar.bgi() != null) {
                        this.mForumName = dVar.bgi().getForumName();
                        this.mForumId = dVar.bgi().getForumId();
                    }
                    if (this.mForumName == null && this.fUU.bhn() != null && this.fUU.bhn().bhe() != null) {
                        this.mForumName = this.fUU.bhn().bhe();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.gcd.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.gcd.setTag(sparseArray);
                }
                sparseArray.put(e.g.tag_clip_board, b);
                sparseArray.put(e.g.tag_is_subpb, false);
                if (!this.gei) {
                    this.gbZ.setVisibility(0);
                }
                if (!dVar.bgj().Au() && this.gca.getText() != null && this.gca.getText().length() > 0) {
                    this.gca.setVisibility(0);
                } else {
                    this.gca.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> zS = dVar.bgj().zS();
                if (zS != null && zS.size() > 0 && !this.gei) {
                    this.gdq.setText(String.valueOf(zS.get(0).ya()));
                    this.gdp.setVisibility(0);
                } else {
                    this.gdp.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.gdp, e.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.gdq, e.d.cp_link_tip_d, 1);
                if (b.zG() != null) {
                    String string = b.zG().getName_show() == null ? StringUtils.string(b.zG().getUserName()) : StringUtils.string(b.zG().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.zG().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bz(b.zG().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bz(string) > 12) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.zG().getIconInfo();
                            tShowInfoNew = b.zG().getTShowInfoNew();
                            if (this.fWf != null) {
                                this.fWf.setTag(e.g.tag_user_id, b.zG().getUserId());
                                this.fWf.setOnClickListener(this.fUU.fSY.ggm);
                                this.fWf.a(iconInfo, 4, this.fUU.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fUU.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fUU.getResources().getDimensionPixelSize(e.C0210e.tbds12));
                            }
                            if (this.fWe != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fWe.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fWe.setOnClickListener(this.fUU.fSY.ggn);
                                this.fWe.a(tShowInfoNew, 3, this.fUU.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fUU.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fUU.getResources().getDimensionPixelSize(e.C0210e.ds12), true);
                            }
                            this.gcf.setText(aE(b.zG().getSealPrefix(), d));
                            this.gcf.setTag(e.g.tag_user_id, b.zG().getUserId());
                            this.gcf.setTag(e.g.tag_user_name, b.zG().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew) || b.zG().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.gcf, e.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.gcf, e.d.cp_cont_f, 1);
                            }
                            this.gcg.setVisibility(8);
                            if (dVar.bgj().zG() != null && dVar.bgj().zG().getAlaUserData() != null && this.gcl != null) {
                                if (dVar.bgj().zG().getAlaUserData().anchor_live != 0) {
                                    this.gcl.setVisibility(8);
                                } else {
                                    this.gcl.setVisibility(0);
                                    if (this.gbQ == null) {
                                        this.gbQ = new com.baidu.tieba.c.d(this.fUU.getPageContext(), this.gcl);
                                        this.gbQ.kW(1);
                                    }
                                    this.gbQ.bo(this.fUU.getResources().getString(e.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.alI = dVar.bgj().zG().getAlaUserData();
                                    aVar.type = 2;
                                    this.gcl.setTag(aVar);
                                }
                            }
                            this.gck.setUserId(b.zG().getUserId());
                            this.gck.setUserName(b.zG().getUserName());
                            this.gck.setTid(b.getId());
                            this.gck.setFid(this.fYu == null ? this.fYu.getForumId() : "");
                            this.gck.setImageDrawable(null);
                            this.gck.setRadius(com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds40));
                            this.gck.setTag(b.zG().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                                this.gct.setText(com.baidu.tbadk.core.util.ao.N(b.getTime()));
                            } else {
                                this.gct.setText(com.baidu.tbadk.core.util.ao.L(b.getTime()));
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds16);
                            if (!this.fUU.bhd() && !StringUtils.isNull(this.mForumName)) {
                                this.aKh.setText(this.fUU.getString(e.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.aKh.setVisibility(0);
                                this.gcw.setVisibility(0);
                                this.gct.setPadding(h, 0, h, 0);
                            } else {
                                this.aKh.setVisibility(8);
                                this.gcw.setVisibility(8);
                                this.gct.setPadding(0, 0, h, 0);
                            }
                            bDu = b.bDu();
                            if (bDu == null && !TextUtils.isEmpty(bDu.getName()) && !TextUtils.isEmpty(bDu.getName().trim())) {
                                final String name = bDu.getName();
                                final String lat = bDu.getLat();
                                final String lng = bDu.getLng();
                                this.gcu.setVisibility(0);
                                this.gcv.setVisibility(0);
                                this.gcu.setText(bDu.getName());
                                this.gcu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                ar.this.fUU.showToast(e.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ad(ar.this.fUU.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, ar.this.fUU.getPageContext().getString(e.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.gcu.setVisibility(8);
                                this.gcv.setVisibility(8);
                            }
                            portrait = b.zG().getPortrait();
                            if (b.zG().getPendantData() == null && !StringUtils.isNull(b.zG().getPendantData().ys())) {
                                this.gci.b(b.zG());
                                this.gck.setVisibility(8);
                                this.gci.setVisibility(0);
                                if (this.gco != null) {
                                    this.gco.setVisibility(8);
                                }
                                this.gcf.setOnClickListener(this.geu);
                                this.gci.getHeadView().startLoad(portrait, 28, false);
                                this.gci.getHeadView().setUserId(b.zG().getUserId());
                                this.gci.getHeadView().setUserName(b.zG().getUserName());
                                this.gci.getHeadView().setTid(b.getId());
                                this.gci.getHeadView().setFid(this.fYu != null ? this.fYu.getForumId() : "");
                                this.gci.getHeadView().setOnClickListener(this.geu);
                                this.gci.gl(b.zG().getPendantData().ys());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.gck, b.zG());
                                this.gck.setVisibility(0);
                                this.gcd.setOnClickListener(this.geu);
                                this.gcf.setOnClickListener(this.geu);
                                this.gck.setOnClickListener(this.geu);
                                this.gci.setVisibility(8);
                                this.gck.startLoad(portrait, 28, false);
                            }
                            String name_show = b.zG().getName_show();
                            String userName = b.zG().getUserName();
                            if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                                this.gcf.setText(com.baidu.tieba.pb.c.aE(this.fUU.getPageContext().getPageActivity(), this.gcf.getText().toString()));
                                this.gcf.setGravity(16);
                                this.gcf.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bfS());
                                com.baidu.tbadk.core.util.al.c(this.gcf, e.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.zG().getIconInfo();
                        tShowInfoNew = b.zG().getTShowInfoNew();
                        if (this.fWf != null) {
                        }
                        if (this.fWe != null) {
                        }
                        this.gcf.setText(aE(b.zG().getSealPrefix(), d));
                        this.gcf.setTag(e.g.tag_user_id, b.zG().getUserId());
                        this.gcf.setTag(e.g.tag_user_name, b.zG().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.gcf, e.d.cp_cont_h, 1);
                        this.gcg.setVisibility(8);
                        if (dVar.bgj().zG() != null) {
                            if (dVar.bgj().zG().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.gck.setUserId(b.zG().getUserId());
                        this.gck.setUserName(b.zG().getUserName());
                        this.gck.setTid(b.getId());
                        this.gck.setFid(this.fYu == null ? this.fYu.getForumId() : "");
                        this.gck.setImageDrawable(null);
                        this.gck.setRadius(com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds40));
                        this.gck.setTag(b.zG().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds16);
                        if (!this.fUU.bhd()) {
                        }
                        this.aKh.setVisibility(8);
                        this.gcw.setVisibility(8);
                        this.gct.setPadding(0, 0, h, 0);
                        bDu = b.bDu();
                        if (bDu == null) {
                        }
                        this.gcu.setVisibility(8);
                        this.gcv.setVisibility(8);
                        portrait = b.zG().getPortrait();
                        if (b.zG().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.gck, b.zG());
                        this.gck.setVisibility(0);
                        this.gcd.setOnClickListener(this.geu);
                        this.gcf.setOnClickListener(this.geu);
                        this.gck.setOnClickListener(this.geu);
                        this.gci.setVisibility(8);
                        this.gck.startLoad(portrait, 28, false);
                        String name_show2 = b.zG().getName_show();
                        String userName2 = b.zG().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                            this.gcf.setText(com.baidu.tieba.pb.c.aE(this.fUU.getPageContext().getPageActivity(), this.gcf.getText().toString()));
                            this.gcf.setGravity(16);
                            this.gcf.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bfS());
                            com.baidu.tbadk.core.util.al.c(this.gcf, e.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.zG().getIconInfo();
                            tShowInfoNew = b.zG().getTShowInfoNew();
                            if (this.fWf != null) {
                            }
                            if (this.fWe != null) {
                            }
                            this.gcf.setText(aE(b.zG().getSealPrefix(), d));
                            this.gcf.setTag(e.g.tag_user_id, b.zG().getUserId());
                            this.gcf.setTag(e.g.tag_user_name, b.zG().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.gcf, e.d.cp_cont_h, 1);
                            this.gcg.setVisibility(8);
                            if (dVar.bgj().zG() != null) {
                            }
                            this.gck.setUserId(b.zG().getUserId());
                            this.gck.setUserName(b.zG().getUserName());
                            this.gck.setTid(b.getId());
                            this.gck.setFid(this.fYu == null ? this.fYu.getForumId() : "");
                            this.gck.setImageDrawable(null);
                            this.gck.setRadius(com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds40));
                            this.gck.setTag(b.zG().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds16);
                            if (!this.fUU.bhd()) {
                            }
                            this.aKh.setVisibility(8);
                            this.gcw.setVisibility(8);
                            this.gct.setPadding(0, 0, h, 0);
                            bDu = b.bDu();
                            if (bDu == null) {
                            }
                            this.gcu.setVisibility(8);
                            this.gcv.setVisibility(8);
                            portrait = b.zG().getPortrait();
                            if (b.zG().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.gck, b.zG());
                            this.gck.setVisibility(0);
                            this.gcd.setOnClickListener(this.geu);
                            this.gcf.setOnClickListener(this.geu);
                            this.gck.setOnClickListener(this.geu);
                            this.gci.setVisibility(8);
                            this.gck.startLoad(portrait, 28, false);
                            String name_show22 = b.zG().getName_show();
                            String userName22 = b.zG().getUserName();
                            if (com.baidu.tbadk.p.an.jJ()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.zG().getIconInfo();
                        tShowInfoNew = b.zG().getTShowInfoNew();
                        if (this.fWf != null) {
                        }
                        if (this.fWe != null) {
                        }
                        this.gcf.setText(aE(b.zG().getSealPrefix(), d));
                        this.gcf.setTag(e.g.tag_user_id, b.zG().getUserId());
                        this.gcf.setTag(e.g.tag_user_name, b.zG().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.gcf, e.d.cp_cont_h, 1);
                        this.gcg.setVisibility(8);
                        if (dVar.bgj().zG() != null) {
                        }
                        this.gck.setUserId(b.zG().getUserId());
                        this.gck.setUserName(b.zG().getUserName());
                        this.gck.setTid(b.getId());
                        this.gck.setFid(this.fYu == null ? this.fYu.getForumId() : "");
                        this.gck.setImageDrawable(null);
                        this.gck.setRadius(com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds40));
                        this.gck.setTag(b.zG().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fUU.getActivity(), e.C0210e.ds16);
                        if (!this.fUU.bhd()) {
                        }
                        this.aKh.setVisibility(8);
                        this.gcw.setVisibility(8);
                        this.gct.setPadding(0, 0, h, 0);
                        bDu = b.bDu();
                        if (bDu == null) {
                        }
                        this.gcu.setVisibility(8);
                        this.gcv.setVisibility(8);
                        portrait = b.zG().getPortrait();
                        if (b.zG().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.gck, b.zG());
                        this.gck.setVisibility(0);
                        this.gcd.setOnClickListener(this.geu);
                        this.gcf.setOnClickListener(this.geu);
                        this.gck.setOnClickListener(this.geu);
                        this.gci.setVisibility(8);
                        this.gck.startLoad(portrait, 28, false);
                        String name_show222 = b.zG().getName_show();
                        String userName222 = b.zG().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.gcc.ak(dVar.bgj());
                }
                if (this.gdy != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fQE);
                    if (dVar != null && dVar.bgj() != null) {
                        hVar.fQG = dVar.bgj().zx();
                    }
                    hVar.isNew = !this.fVl;
                    hVar.sortType = dVar.fQv;
                    if (dVar.fQu != null && dVar.fQu.size() > dVar.fQv) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.fQu.size()) {
                                break;
                            } else if (dVar.fQu.get(i4).sort_type.intValue() != dVar.fQv) {
                                i3 = i4 + 1;
                            } else {
                                hVar.fQI = dVar.fQu.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.fQJ = this.fUU.bip();
                    this.gdy.a(hVar);
                }
            }
        }
    }

    public void ln(boolean z) {
        if (z) {
            blb();
        } else {
            blc();
        }
        this.gdC.geM = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.gdC));
        a(this.gdC.geM, false);
    }

    public void blb() {
        if (this.gbT != null && !this.gdT) {
            this.gbT.lK(!StringUtils.isNull(this.fUU.bhO()));
            this.gdT = true;
        }
    }

    public void blc() {
        if (this.gbT != null) {
            this.gbT.bmm();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Ac() != null) {
            this.gce.setData(this.fUU.getPageContext(), dVar.bgl().get(0).Ac(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.bgh().getId(), dVar.bgh().getName(), dVar.bgj().getId(), this.fUU.bim() ? "FRS" : null));
            this.gcd.setPadding(this.gcd.getPaddingLeft(), (int) this.fUU.getResources().getDimension(e.C0210e.ds20), this.gcd.getPaddingRight(), this.gcd.getPaddingBottom());
            return;
        }
        this.gce.setData(null, null, null);
    }

    public void bld() {
        if (this.gbN != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").x("obj_type", 1));
            this.gbN.bnu();
            this.gbX.smoothScrollToPosition(0);
        }
    }

    public boolean ble() {
        return this.gev;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.zG() == null || bbVar.zG().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.zG().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.gbT.bmk();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.gbT.qU(cVar.forumName);
            }
            String string = this.fUU.getResources().getString(e.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.fUU.getResources().getString(e.j.self);
                    break;
                case 300:
                    str = this.fUU.getResources().getString(e.j.bawu);
                    break;
                case 400:
                    str = this.fUU.getResources().getString(e.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fPM;
            this.fUU.showNetRefreshView(this.dor, format, null, this.fUU.getResources().getString(e.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.ll()) {
                        ay.Ef().c(ar.this.fUU.getPageContext(), new String[]{str2});
                        ar.this.fUU.finish();
                        return;
                    }
                    ar.this.fUU.showToast(e.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bkm;
        Parcelable bkm2;
        String str;
        if (dVar != null) {
            this.fYu = dVar;
            this.mType = i;
            if (dVar.bgj() != null) {
                this.gdE = dVar.bgj().zp();
                if (dVar.bgj().getAnchorLevel() != 0) {
                    this.gev = true;
                }
                this.gda = am(dVar.bgj());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.gdo = false;
            this.fVl = z;
            bkX();
            b(dVar, z, i);
            p(dVar);
            if (this.geg == null) {
                this.geg = new ac(this.fUU.getPageContext(), this.alo);
            }
            this.geg.sZ(dVar.bgo());
            if (this.fUU.bid()) {
                if (this.gcI == null) {
                    this.gcI = new com.baidu.tieba.pb.view.d(this.fUU.getPageContext());
                    this.gcI.oD();
                    this.gcI.a(this.aIE);
                }
                this.gbX.setPullRefresh(this.gcI);
                blf();
                if (this.gcI != null) {
                    this.gcI.ey(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.yS().yQ() == 0 && z) {
                this.gbX.setPullRefresh(null);
            } else {
                if (this.gcI == null) {
                    this.gcI = new com.baidu.tieba.pb.view.d(this.fUU.getPageContext());
                    this.gcI.oD();
                    this.gcI.a(this.aIE);
                }
                this.gbX.setPullRefresh(this.gcI);
                blf();
                if (this.gcI != null) {
                    this.gcI.ey(TbadkCoreApplication.getInst().getSkinType());
                }
                akP();
            }
            bli();
            this.gcE.kA(this.fVl);
            this.gcE.kB(false);
            this.gcE.kM(i == 5);
            this.gcE.kN(i == 6);
            this.gcE.kO(z2 && this.get);
            this.gcE.a(dVar, false);
            this.gcE.notifyDataSetChanged();
            if (this.fUU.bhd()) {
                this.gdV = 0;
                PostData b = b(dVar, z);
                if (b != null && b.zG() != null) {
                    this.gdV = b.zG().getLevel_id();
                }
                if (this.gdV > 0) {
                    this.gch.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.gch, BitmapHelper.getGradeResourceIdInEnterForum(this.gdV));
                } else {
                    this.gch.setVisibility(8);
                }
            } else {
                this.gch.setVisibility(8);
            }
            if (dVar.bgj() != null) {
                if (dVar.bgj().zt() != null) {
                    if (dVar.bgj().zt().getNum() < 1) {
                        str = this.fUU.getResources().getString(e.j.zan);
                    } else {
                        str = dVar.bgj().zt().getNum() + "";
                    }
                    if (this.gbM != -1) {
                        dVar.bgj().zt().setIsLike(this.gbM);
                    }
                    W(str, dVar.bgj().zt().getIsLike() == 1);
                }
                if (dVar.bgj().avt != null && dVar.bgj().avt.isDeleted) {
                    this.gbT.lE(true);
                } else {
                    this.gbT.lE(false);
                }
            }
            if (this.fUU.isLogin()) {
                this.gbX.setNextPage(this.dNE);
                this.gbS = 2;
                akP();
            } else {
                this.gdo = true;
                if (dVar.yS().yP() == 1) {
                    if (this.gcJ == null) {
                        this.gcJ = new com.baidu.tieba.pb.view.a(this.fUU.getPageContext());
                    }
                    this.gbX.setNextPage(this.gcJ);
                } else {
                    this.gbX.setNextPage(this.dNE);
                }
                this.gbS = 3;
            }
            ArrayList<PostData> bgl = dVar.bgl();
            if (dVar.yS().yP() == 0 || bgl == null || bgl.size() < dVar.yS().yO()) {
                if (com.baidu.tbadk.core.util.v.H(bgl) == 0 || (com.baidu.tbadk.core.util.v.H(bgl) == 1 && bgl.get(0) != null && bgl.get(0).bDr() == 1)) {
                    this.dNE.setText(this.fUU.getResources().getString(e.j.list_no_more_new));
                    if (this.fUU.bhD() != null && !this.fUU.bhD().bma()) {
                        this.fUU.bhD().showFloatingView();
                    }
                } else if (dVar.yS().yP() == 0) {
                    this.dNE.setText(this.fUU.getResources().getString(e.j.list_has_no_more));
                } else {
                    this.dNE.setText(this.fUU.getResources().getString(e.j.load_more));
                }
                if (this.fUU.bid() && this.gbX != null && this.gbX.getData() != null && this.gbX.getData().size() == 1 && (this.gbX.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dNE.setText("");
                }
                blp();
            } else if (z2) {
                if (this.get) {
                    Fd();
                    if (dVar.yS().yP() != 0) {
                        this.dNE.setText(this.fUU.getResources().getString(e.j.pb_load_more));
                    }
                } else {
                    this.dNE.EY();
                    this.dNE.showLoading();
                }
            } else {
                this.dNE.EY();
                this.dNE.showLoading();
            }
            switch (i) {
                case 2:
                    this.gbX.setSelection(i2 > 1 ? (((this.gbX.getData() == null && dVar.bgl() == null) ? 0 : (this.gbX.getData().size() - dVar.bgl().size()) + this.gbX.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bkm2 = aj.bkl().bkm()) != null) {
                        this.gbX.onRestoreInstanceState(bkm2);
                        if (com.baidu.tbadk.core.util.v.H(bgl) > 1 && dVar.yS().yP() > 0) {
                            this.dNE.Fd();
                            this.dNE.setText(this.fUU.getString(e.j.pb_load_more_without_point));
                            this.dNE.EZ();
                            break;
                        }
                    } else {
                        this.gbX.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.get = false;
                    break;
                case 5:
                    this.gbX.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bkm = aj.bkl().bkm()) != null) {
                        this.gbX.onRestoreInstanceState(bkm);
                        break;
                    } else {
                        this.gbX.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.gbN != null && this.gbN.bnt() != null) {
                            if (this.fUU.isUseStyleImmersiveSticky()) {
                                this.gbX.setSelectionFromTop((this.gcE.biI() + this.gbX.getHeaderViewsCount()) - 1, this.gbN.bnt().getHeight() - com.baidu.adp.lib.util.l.r(this.fUU.getPageContext().getPageActivity()));
                            } else {
                                this.gbX.setSelectionFromTop((this.gcE.biI() + this.gbX.getHeaderViewsCount()) - 1, this.gbN.bnt().getHeight());
                            }
                        } else {
                            this.gbX.setSelection(this.gcE.biI() + this.gbX.getHeaderViewsCount());
                        }
                    } else {
                        this.gbX.setSelection(i2 > 0 ? ((this.gbX.getData() == null && dVar.bgl() == null) ? 0 : (this.gbX.getData().size() - dVar.bgl().size()) + this.gbX.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dNE.Fd();
                    this.dNE.setText(this.fUU.getString(e.j.pb_load_more_without_point));
                    this.dNE.EZ();
                    break;
            }
            if (this.gdE == gdF && isHost()) {
                blx();
            }
            if (this.gdP) {
                bkv();
                this.gdP = false;
                if (i3 == 0) {
                    lg(true);
                }
            }
            if (this.gbP != null) {
                this.gbP.ar(dVar.bgj());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fQs == 1 || dVar.fQt == 1) {
                if (this.gdW == null) {
                    this.gdW = new PbTopTipView(this.fUU);
                }
                if (dVar.fQt == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fUU.getStType())) {
                    this.gdW.setText(this.fUU.getString(e.j.pb_read_strategy_add_experience));
                    this.gdW.show(this.dor, this.mSkinType);
                } else if (dVar.fQs == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fUU.getStType())) {
                    this.gdW.setText(this.fUU.getString(e.j.pb_read_news_add_experience));
                    this.gdW.show(this.dor, this.mSkinType);
                }
            }
        }
    }

    private void blf() {
        if (this.gbN != null && this.gbN.bnt() != null) {
            this.gbX.removeHeaderView(this.aiY);
            if (this.mType != 1) {
                this.gbX.removeHeaderView(this.gbN.bnw());
                this.gbX.addHeaderView(this.gbN.bnw(), 0);
                return;
            }
            return;
        }
        if (this.gbN != null) {
            this.gbX.removeHeaderView(this.gbN.bnw());
        }
        this.gbX.removeHeaderView(this.aiY);
        this.gbX.addHeaderView(this.aiY, 0);
    }

    public void lo(boolean z) {
        this.gcZ = z;
    }

    public void Fd() {
        if (this.dNE != null) {
            this.dNE.EZ();
            this.dNE.Fd();
        }
        akP();
    }

    public void amN() {
        this.gbX.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.gdn != null && this.gdn.zG() != null && this.gbT != null) {
            this.gdS = !this.gdR;
            this.gbT.lD(this.gdS);
            if (this.fUU.bhD() != null) {
                this.fUU.bhD().lC(this.gdS);
            }
            blg();
            if (this.gdS) {
                this.gbT.ggZ.setVisibility(0);
                if (this.gda) {
                    this.gbT.gha.setVisibility(8);
                    this.gcp.setVisibility(8);
                    this.gcs.setVisibility(0);
                    this.gcs.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.S(dVar.bgG())));
                } else if (!PbNormalLikeButtonSwitchStatic.PC() || (this.gdn.zG().hadConcerned() && this.gdn.zG().getGodUserData() != null && this.gdn.zG().getGodUserData().getIsFromNetWork())) {
                    this.gbT.gha.setVisibility(8);
                }
                if (this.gdx != null) {
                    this.gdx.setVisibility(8);
                }
                this.gbT.a(this.gdn.zG(), this.geu);
                if (this.gee == null) {
                    this.gee = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.gdU) {
                                ar.this.blw();
                            }
                            ar.this.bkY();
                        }
                    };
                }
                this.gbX.setListViewDragListener(this.gee);
                return;
            }
            if (this.gbT.ggZ != null) {
                this.gbT.ggZ.setVisibility(8);
            }
            if (this.gdx != null) {
                this.gdx.setVisibility(0);
            }
            if (this.gda) {
                this.gcp.setVisibility(8);
                this.gcs.setVisibility(0);
                this.gcs.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.S(dVar.bgG())));
            } else if (!PbNormalLikeButtonSwitchStatic.PC() || (this.gdn.zG().hadConcerned() && this.gdn.zG().getGodUserData() != null && this.gdn.zG().getGodUserData().getIsFromNetWork())) {
                this.gcp.setVisibility(8);
                this.gcs.setVisibility(8);
            } else {
                this.gcs.setVisibility(8);
            }
            this.gee = null;
            this.gbX.setListViewDragListener(null);
        }
    }

    private void blg() {
        String threadId = this.fYu != null ? this.fYu.getThreadId() : "";
        int blh = blh();
        if (this.gdS) {
            if (this.gcr == null) {
                this.gcr = new ap(this.fUU.getPageContext(), this.gbT.gha, 3);
                this.gcr.h(this.fUU.getUniqueId());
            }
            if (this.gdn != null && this.gdn.zG() != null) {
                this.gdn.zG().setIsLike(this.gdn.zG().hadConcerned());
                this.gcr.a(this.gdn.zG());
            }
            this.gcr.setTid(threadId);
            this.gcr.sx(blh);
            this.gcr.gbI = this.gdR;
        }
        if (this.gcq == null) {
            this.gcq = new ap(this.fUU.getPageContext(), this.gcp, 1);
            this.gcq.h(this.fUU.getUniqueId());
            this.gcq.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bL(boolean z) {
                    if (ar.this.fUU != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fUU, e.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fUU.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.gdn != null && this.gdn.zG() != null) {
            this.gdn.zG().setIsLike(this.gdn.zG().hadConcerned());
            this.gcq.a(this.gdn.zG());
            this.gcq.setTid(threadId);
        }
        this.gcq.gbI = this.gdR;
        this.gcq.sx(blh);
    }

    public int blh() {
        if (this.fYu == null || this.fYu.bgj() == null) {
            return 0;
        }
        if (this.fYu.bgj().AR()) {
            return (com.baidu.tbadk.core.util.v.I(this.fYu.bgF()) && (this.fYu.bgi() == null || StringUtils.isNull(this.fYu.bgi().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bli() {
        boolean z;
        if (this.gdd != null && this.gdd.getVisibility() == 0) {
            if (this.gcA != null) {
                this.gcA.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.gcA != null) {
                this.gcA.setVisibility(8);
            }
            z = false;
        }
        if ((this.gcC == null || this.gcC.getVisibility() == 8) && z && this.fVl) {
            this.gcB.setVisibility(0);
        } else {
            this.gcB.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bgj() == null) {
            return false;
        }
        if (dVar.bgj().zD() == 1 || dVar.bgj().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bgj().zF() == null || dVar.bgj().zF().Bt() == 0) || dVar.bgj().zB() == 1 || dVar.bgj().zC() == 1 || dVar.bgj().Al() || dVar.bgj().Ay() || dVar.bgj().At() || dVar.bgj().zT() != null || !com.baidu.tbadk.core.util.ao.isEmpty(dVar.bgj().getCategory()) || dVar.bgj().zJ() || dVar.bgj().zI();
    }

    private SpannableStringBuilder aE(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fUU.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.gbZ != null) {
                if (dVar.bgj() != null && dVar.bgj().zW() == 0 && !dVar.bgj().Au() && !this.gei) {
                    this.gbZ.setVisibility(0);
                    if (dVar.bgj() != null) {
                        bb bgj = dVar.bgj();
                        bgj.g(true, q(dVar));
                        bgj.setResource(3);
                        bgj.el("2");
                    }
                    SpannableStringBuilder Ag = dVar.bgj().Ag();
                    this.gca.setOnTouchListener(new com.baidu.tieba.view.k(Ag));
                    this.gca.setText(Ag);
                    this.gca.setVisibility(0);
                } else if (dVar.bgj().zW() == 1) {
                    if (dVar.bgj() != null) {
                        this.gbZ.setVisibility(8);
                        this.gbX.removeHeaderView(this.gbZ);
                        if (dVar.bgj() != null && !dVar.bgj().Au()) {
                            this.gcd.setPadding(this.gcd.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.tbds36), this.gcd.getPaddingRight(), this.gcd.getPaddingBottom());
                        }
                    }
                } else {
                    this.gbZ.setVisibility(8);
                    this.gbX.removeHeaderView(this.gbZ);
                    if (dVar.bgj() != null && dVar.bgj().Au()) {
                        this.gcd.setPadding(this.gcd.getPaddingLeft(), 0, this.gcd.getPaddingRight(), this.gcd.getPaddingBottom());
                    } else {
                        this.gcd.setPadding(this.gcd.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds48), this.gcd.getPaddingRight(), this.gcd.getPaddingBottom());
                    }
                }
            }
            this.fVl = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bli();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.zG().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bgv()));
                sparseArray.put(e.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.zG() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, b.zG().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, b.zG().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, b.zG().getPortrait());
                    sparseArray.put(e.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(e.g.tag_del_post_id, b.getId());
                sparseArray.put(e.g.tag_del_post_type, 0);
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bgv()));
                sparseArray.put(e.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.ay> bgF = dVar.bgF();
                if (com.baidu.tbadk.core.util.v.H(bgF) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.ay ayVar : bgF) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ata) != null && tVar.ara && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(this.fUU.getString(e.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(e.g.tag_del_multi_forum, String.format(this.fUU.getString(e.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bfh;
    }

    public void ta(String str) {
        if (this.dNE != null) {
            this.dNE.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.gbX;
    }

    public int blj() {
        return e.g.richText;
    }

    public TextView bhy() {
        return this.gcc.bhy();
    }

    public void e(BdListView.e eVar) {
        this.gbX.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.aIE = bVar;
        if (this.gcI != null) {
            this.gcI.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int yN = alVar.yN();
            int yK = alVar.yK();
            if (this.gcF != null) {
                this.gcF.BF();
            } else {
                this.gcF = new com.baidu.tbadk.core.dialog.a(this.fUU.getPageContext().getPageActivity());
                this.gcG = LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.dialog_direct_pager, (ViewGroup) null);
                this.gcF.G(this.gcG);
                this.gcF.a(e.j.dialog_ok, bVar);
                this.gcF.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.bll();
                        aVar.dismiss();
                    }
                });
                this.gcF.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.gdM == null) {
                            ar.this.gdM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fUU.HidenSoftKeyPad((InputMethodManager) ar.this.fUU.getSystemService("input_method"), ar.this.dor);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jG().postDelayed(ar.this.gdM, 150L);
                    }
                });
                this.gcF.b(this.fUU.getPageContext()).BF();
            }
            this.gcH = (EditText) this.gcG.findViewById(e.g.input_page_number);
            this.gcH.setText("");
            TextView textView = (TextView) this.gcG.findViewById(e.g.current_page_number);
            if (yN <= 0) {
                yN = 1;
            }
            if (yK <= 0) {
                yK = 1;
            }
            textView.setText(MessageFormat.format(this.fUU.getApplicationContext().getResources().getString(e.j.current_page), Integer.valueOf(yN), Integer.valueOf(yK)));
            this.fUU.ShowSoftKeyPadDelay(this.gcH, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gbX.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fUU.showToast(str);
    }

    public boolean lp(boolean z) {
        if (this.Ta == null || !this.Ta.Ma()) {
            return false;
        }
        this.Ta.Kw();
        return true;
    }

    public void blk() {
        if (this.gew != null) {
            while (this.gew.size() > 0) {
                TbImageView remove = this.gew.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        blk();
        this.gcE.si(1);
        if (this.gbN != null) {
            this.gbN.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.gcE.si(2);
        if (this.gbN != null) {
            this.gbN.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.gdO != null) {
            this.gdO.destroy();
        }
        if (this.geg != null) {
            this.geg.onDestory();
        }
        if (this.gdW != null) {
            this.gdW.hide();
        }
        if (this.gbQ != null) {
            this.gbQ.arm();
        }
        if (this.gbP != null) {
            this.gbP.onDestroy();
        }
        this.fUU.hideProgressBar();
        if (this.dop != null && this.dFP != null) {
            this.dop.b(this.dFP);
        }
        bll();
        Fd();
        if (this.gdM != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gdM);
        }
        if (this.gcd != null && this.gco != null) {
            this.gcd.removeView(this.gcj);
            this.gco = null;
        }
        if (this.gds != null) {
            this.gds.clearStatus();
        }
        this.gep = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.gcE.si(3);
        if (this.dKj != null) {
            this.dKj.setBackgroundDrawable(null);
        }
        if (this.gbN != null) {
            this.gbN.destroy();
        }
        if (this.gcE != null) {
            this.gcE.onDestroy();
        }
        this.gbX.setOnLayoutListener(null);
        if (this.gec != null) {
            this.gec.aDd();
        }
        if (this.gdD != null) {
            this.gdD.onDestroy();
        }
        blH();
    }

    public boolean sA(int i) {
        if (this.gbN != null) {
            return this.gbN.mu(i);
        }
        return false;
    }

    public void bll() {
        this.gbT.dismissPopMenu();
        if (this.gbQ != null) {
            this.gbQ.arm();
        }
        com.baidu.adp.lib.util.l.b(this.fUU.getPageContext().getPageActivity(), this.gcH);
        bkx();
        if (this.gcX != null) {
            this.gcX.dismiss();
        }
        bln();
        if (this.gbP != null) {
            this.gbP.bnm();
        }
        if (this.gcF != null) {
            this.gcF.dismiss();
        }
        if (this.dJT != null) {
            this.dJT.dismiss();
        }
    }

    public void blm() {
        this.gbT.dismissPopMenu();
        if (this.gbQ != null) {
            this.gbQ.arm();
        }
        if (this.gcX != null) {
            this.gcX.dismiss();
        }
        bln();
        if (this.gbP != null) {
            this.gbP.bnm();
        }
        if (this.gcF != null) {
            this.gcF.dismiss();
        }
        if (this.dJT != null) {
            this.dJT.dismiss();
        }
    }

    public void dn(List<String> list) {
        this.geb = list;
        if (this.gec != null) {
            this.gec.setData(list);
        }
    }

    public void kz(boolean z) {
        this.gcE.kz(z);
    }

    public void lq(boolean z) {
        this.gdc = z;
    }

    public void bln() {
        if (this.gcO != null) {
            this.gcO.dismiss();
        }
        if (this.gcP != null) {
            com.baidu.adp.lib.g.g.b(this.gcP, this.fUU.getPageContext());
        }
        if (this.gcQ != null) {
            com.baidu.adp.lib.g.g.b(this.gcQ, this.fUU.getPageContext());
        }
        if (this.gcM != null) {
            com.baidu.adp.lib.g.g.b(this.gcM, this.fUU.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fYu, this.fVl);
            d(this.fYu, this.fVl, this.mType);
            this.fUU.getLayoutMode().setNightMode(i == 1);
            this.fUU.getLayoutMode().onModeChanged(this.dor);
            this.fUU.getLayoutMode().onModeChanged(this.gbY);
            if (this.gbP != null) {
                this.gbP.onChangeSkinType(i);
            }
            if (this.gca != null) {
                com.baidu.tbadk.core.util.al.h(this.gca, e.d.cp_cont_b);
                this.gca.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            }
            if (this.dNE != null) {
                this.dNE.ey(i);
                if (this.bfh != null) {
                    this.fUU.getLayoutMode().onModeChanged(this.bfh);
                    com.baidu.tbadk.core.util.al.i(this.bfh, e.f.pb_foot_more_trans_selector);
                }
            }
            if (this.gcF != null) {
                this.gcF.c(this.fUU.getPageContext());
            }
            lo(this.gcZ);
            this.gcE.notifyDataSetChanged();
            if (this.gcI != null) {
                this.gcI.ey(i);
            }
            if (this.Ta != null) {
                this.Ta.onChangeSkinType(i);
            }
            if (this.gcn != null) {
                this.gcn.eC(i);
            }
            if (this.gcJ != null) {
                this.gcJ.ey(i);
            }
            if (!com.baidu.tbadk.core.util.v.I(this.cXg)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cXg) {
                    customBlueCheckRadioButton.EI();
                }
            }
            lk(i == 1);
            bkM();
            UtilHelper.setStatusBarBackground(this.dKj, i);
            UtilHelper.setStatusBarBackground(this.gdx, i);
            if (this.gcp != null) {
                this.gcp.onChangeSkinType(i);
            }
            if (this.gcu != null) {
                com.baidu.tbadk.core.util.al.h(this.gcu, e.d.cp_cont_d);
            }
            if (this.gct != null) {
                com.baidu.tbadk.core.util.al.h(this.gct, e.d.cp_cont_d);
            }
            if (this.gcv != null) {
                com.baidu.tbadk.core.util.al.i(this.gcv, e.d.cp_cont_e);
            }
            if (this.aKh != null) {
                com.baidu.tbadk.core.util.al.h(this.aKh, e.d.cp_cont_d);
            }
            if (this.gcw != null) {
                com.baidu.tbadk.core.util.al.i(this.gcw, e.d.cp_cont_e);
            }
            if (this.gcg != null) {
                com.baidu.tbadk.core.util.al.h(this.gcg, e.d.cp_link_tip_a);
            }
            if (this.gcs != null) {
                com.baidu.tbadk.core.util.al.h(this.gcs, e.d.cp_cont_d);
            }
            if (this.gcx != null) {
                com.baidu.tbadk.o.a.a(this.fUU.getPageContext(), this.gcx);
            }
            if (this.gcV != null) {
                com.baidu.tbadk.o.a.a(this.fUU.getPageContext(), this.gcV);
            }
            if (this.gdN != null) {
                this.gdN.onChangeSkinType(i);
            }
            if (this.gbT != null) {
                if (this.gbN != null) {
                    this.gbN.sF(i);
                } else {
                    this.gbT.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.gdf != null) {
                com.baidu.tbadk.core.util.al.h(this.gdf, e.d.cp_cont_e);
            }
            if (this.gch != null) {
                com.baidu.tbadk.core.util.al.c(this.gch, BitmapHelper.getGradeResourceIdInEnterForum(this.gdV));
            }
            if (this.ged != null) {
                this.ged.onChangeSkinType(i);
            }
            if (this.gdD != null) {
                this.gdD.onChangeSkinType();
            }
            if (this.gdZ != null) {
                com.baidu.tbadk.core.util.al.h(this.gdZ, e.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brM = hVar;
        this.gcE.setOnImageClickListener(this.brM);
        this.ged.setOnImageClickListener(this.brM);
    }

    public void h(NoNetworkView.a aVar) {
        this.dFP = aVar;
        if (this.dop != null) {
            this.dop.a(this.dFP);
        }
    }

    public void lr(boolean z) {
        this.gcE.setIsFromCDN(z);
    }

    public Button blo() {
        return this.gdd;
    }

    public void blp() {
        if (this.gbS != 2) {
            this.gbX.setNextPage(this.dNE);
            this.gbS = 2;
        }
    }

    public void blq() {
        if (com.baidu.tbadk.l.m.Pk().Pl()) {
            int lastVisiblePosition = this.gbX.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gbX.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(e.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.gi(1001);
                                perfLog.bfM = true;
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
                        perfLog2.gi(1001);
                        perfLog2.bfM = true;
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

    public boolean blr() {
        return this.Ta != null && this.Ta.getVisibility() == 0;
    }

    public boolean bls() {
        return this.Ta != null && this.Ta.Ma();
    }

    public void blt() {
        if (this.Ta != null) {
            this.Ta.Kw();
        }
    }

    public void ls(boolean z) {
        if (this.gde != null) {
            lq(this.fUU.bhz().MD());
            if (this.gdc) {
                lh(z);
            } else {
                li(z);
            }
        }
    }

    public void blu() {
        if (this.gde != null) {
            this.gde.setVisibility(8);
            this.gdj = false;
            if (this.gdD != null) {
                this.gdD.setVisibility(8);
                lm(false);
            }
            blH();
        }
    }

    public void showLoadingDialog() {
        if (this.deE == null) {
            this.deE = new com.baidu.tbadk.core.view.d(this.fUU.getPageContext());
        }
        this.deE.bA(true);
    }

    public void akP() {
        if (this.deE != null) {
            this.deE.bA(false);
        }
    }

    private int getScrollY() {
        View childAt = this.gbX.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.gbX.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.gbN != null) {
            this.gbN.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.gex = getScrollY();
            this.gdC.geM = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.gdC));
            a(this.gdC.geM, true);
        }
    }

    public void lt(boolean z) {
        this.gbN.lt(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gbN != null) {
            this.gbN.b(absListView, i);
        }
        int headerViewsCount = (i - this.gbX.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (headerViewsCount <= i2 && this.gcE.sh(headerViewsCount) != com.baidu.tieba.pb.data.i.fQK) {
            headerViewsCount++;
        }
        boolean z = i < this.gbX.getHeaderViewsCount();
        if (this.gcb != null && this.gbT != null) {
            this.gbT.h(this.gcb.getBottom(), this.gcb.getMeasuredHeight(), z);
        }
        this.gdC.fLr = i;
        this.gdC.headerCount = this.gbX.getHeaderViewsCount();
        this.gdC.geM = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.gdC));
        a(this.gdC.geM, false);
    }

    public void blv() {
        if (this.fUU.isLogin() && this.fYu != null && this.gdS && !this.gdR && !this.gda && this.gdn != null && this.gdn.zG() != null && !this.gdn.zG().getIsLike() && !this.gdn.zG().hadConcerned()) {
            if (this.gdO == null) {
                this.gdO = new an(this.fUU);
            }
            this.gdO.a(this.gbT.ggZ, this.fYu.bgJ(), this.gdn.zG().getUserId(), this.fYu.getThreadId());
        }
    }

    public void blw() {
        if (this.gdS && !this.gdR && this.gdn != null && this.gdn.zG() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").x("obj_locate", this.fUU.bhd() ? 2 : 1).x("obj_type", this.gdR ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fUU.getPageContext().getPageActivity(), this.gdn.zG().getUserId(), this.gdn.zG().getUserName(), this.fUU.bhn().bhe(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.gdR && this.gdw != null && this.gbT.bmf() != null) {
            int biJ = this.gcE.biJ();
            if (biJ > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (biJ > this.gbX.getFirstVisiblePosition() - this.gbX.getHeaderViewsCount()) {
                    this.gdw.setVisibility(8);
                    return;
                }
                this.gdw.setVisibility(0);
                blG();
                this.gbT.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.gbm == null) {
                if (this.gbX.getFirstVisiblePosition() == 0) {
                    this.gdw.setVisibility(8);
                    this.gbT.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.gdB) {
                        this.gdA = top;
                        this.gdB = false;
                    }
                    this.gdA = top < this.gdA ? top : this.gdA;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.gcD.getY() < 0.0f) {
                        measuredHeight = gdz - alVar.gbm.getMeasuredHeight();
                    } else {
                        measuredHeight = this.gbT.bmf().getMeasuredHeight() - alVar.gbm.getMeasuredHeight();
                        this.gbT.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.gdA) {
                        this.gdw.setVisibility(0);
                        blG();
                    } else if (top < measuredHeight) {
                        this.gdw.setVisibility(0);
                        blG();
                    } else {
                        this.gdw.setVisibility(8);
                        this.gbT.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.gdB = true;
                    }
                }
            }
        }
    }

    public void blx() {
        if (!this.gey) {
            TiebaStatic.log("c10490");
            this.gey = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fUU.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(gdG, Integer.valueOf(gdI));
            aVar.da(e.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.function_description_view)).setText(e.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(e.g.title_view)).setText(e.j.grade_thread_tips);
            aVar.G(inflate);
            aVar.H(sparseArray);
            aVar.a(e.j.grade_button_tips, this.fUU);
            aVar.b(e.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fUU.getPageContext()).BF();
        }
    }

    public void tb(String str) {
        if (str.contains(BaseRequestAction.SPLITE)) {
            str = str.replace(BaseRequestAction.SPLITE, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fUU.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(e.g.function_description_view)).setVisibility(8);
        aVar.G(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(gdG, Integer.valueOf(gdJ));
        aVar.H(sparseArray);
        aVar.a(e.j.view, this.fUU);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fUU.getPageContext()).BF();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.zG() != null) {
            MetaData zG = b.zG();
            zG.setGiftNum(zG.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bly() {
        return this.gds;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bgj() != null && dVar.bgj().Ay() && this.gds == null) {
            this.gds = (PbInterviewStatusView) this.gdr.inflate();
            this.gds.setOnClickListener(this.dJU);
            this.gds.setCallback(this.fUU.bil());
            this.gds.setData(this.fUU, dVar);
        }
    }

    public LinearLayout blz() {
        return this.gcD;
    }

    public View blA() {
        return this.dKj;
    }

    public boolean blB() {
        return this.gei;
    }

    public void kE(boolean z) {
        this.gcc.kE(z);
    }

    public void tc(String str) {
        if (this.gbU != null) {
            this.gbU.setTitle(str);
        }
    }

    private int lu(boolean z) {
        if (this.gds == null || this.gds.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds72);
    }

    private void blC() {
        if (this.gds != null && this.gds.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gds.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.gds.setLayoutParams(layoutParams);
        }
    }

    public boolean bhF() {
        return false;
    }

    public void td(String str) {
        this.gdf.performClick();
        if (!StringUtils.isNull(str) && this.fUU.bhz() != null && this.fUU.bhz().Mw() != null && this.fUU.bhz().Mw().getInputView() != null) {
            EditText inputView = this.fUU.bhz().Mw().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bll();
            if (configuration.orientation == 2) {
                blu();
                bkx();
            } else {
                bkA();
            }
            if (this.gdN != null) {
                this.gdN.biQ();
            }
            this.fUU.aAY();
            this.gcD.setVisibility(8);
            this.gbT.lG(false);
            this.fUU.kK(false);
            if (this.gbN != null) {
                if (configuration.orientation == 1) {
                    blz().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.gbX.setIsLandscape(true);
                    this.gbX.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.gbX.setIsLandscape(false);
                    if (this.gex > 0) {
                        this.gbX.smoothScrollBy(this.gex, 0);
                    }
                }
                this.gbN.onConfigurationChanged(configuration);
                this.gdv.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void lv(boolean z) {
        this.gbR = z;
    }

    public boolean blD() {
        return this.gbN != null && this.gbN.blD();
    }

    public void blE() {
        if (this.gbN != null) {
            this.gbN.onPause();
        }
    }

    public void n(long j, int i) {
        if (this.gbP != null) {
            this.gbP.n(j, i);
        }
        if (this.gbN != null) {
            this.gbN.n(j, i);
        }
    }

    public void kP(boolean z) {
        this.gcE.kP(z);
    }

    public void blF() {
        if (this.gdt == null) {
            LayoutInflater.from(this.fUU.getActivity()).inflate(e.h.add_experienced_text, (ViewGroup) this.dor, true);
            this.gdt = (ViewGroup) this.dor.findViewById(e.g.add_experienced_layout);
            this.gdu = (TextView) this.dor.findViewById(e.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.gdu, e.d.cp_cont_i);
            String string = this.fUU.getResources().getString(e.j.experienced_add_success);
            String string2 = this.fUU.getResources().getString(e.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_h)));
            this.gdu.setText(spannableString);
        }
        this.gdt.setVisibility(0);
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
                        ar.this.gdt.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.gdu.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.gdu.startAnimation(scaleAnimation);
    }

    public void bD(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.gde.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fUU);
            frameLayout.setBackgroundResource(e.f.pic_sign_tip);
            this.gdZ = new TextView(this.fUU);
            this.gdZ.setText(e.j.connection_tips);
            this.gdZ.setGravity(17);
            this.gdZ.setPadding(com.baidu.adp.lib.util.l.h(this.fUU, e.C0210e.ds24), 0, com.baidu.adp.lib.util.l.h(this.fUU, e.C0210e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fUU, e.C0210e.ds60);
            if (this.gdZ.getParent() == null) {
                frameLayout.addView(this.gdZ, layoutParams);
            }
            this.gdY = new PopupWindow(this.fUU);
            this.gdY.setContentView(frameLayout);
            this.gdY.setHeight(-2);
            this.gdY.setWidth(-2);
            this.gdY.setFocusable(true);
            this.gdY.setOutsideTouchable(false);
            this.gdY.setBackgroundDrawable(new ColorDrawable(this.fUU.getResources().getColor(e.d.transparent)));
            this.gbX.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.gdY.showAsDropDown(ar.this.gde, view.getLeft(), -ar.this.gde.getHeight());
                    } else {
                        ar.this.gdY.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void blG() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.gea == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.gea = new com.baidu.tbadk.core.dialog.a(this.fUU);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.fUU);
            this.gea.dd(1);
            this.gea.G(pbLongPressTipView);
            this.gea.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.31
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gea.bg(false);
            this.gea.b(this.fUU.getPageContext()).BF();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.32
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.gea != null && ar.this.gea.isShowing()) {
                        ar.this.gea.dismiss();
                    }
                }
            }, 5000L);
            if (this.gbN != null) {
                this.gbN.bnv();
            }
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.blW() != null && !StringUtils.isNull(aVar.blW().pkg_id) && !StringUtils.isNull(aVar.blW().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.gdg != null && this.gdg.getVisibility() == 0) {
            if (this.gdX == null) {
                View inflate = LayoutInflater.from(this.fUU.getPageContext().getPageActivity()).inflate(e.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(e.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(e.g.single_bar_tips);
                textView.setText(e.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dJU);
                this.gdX = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.gdg.getLocationInWindow(iArr);
            this.gdX.showAtLocation(this.gdg, 0, iArr[0] - com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds54), (iArr[1] - this.gdg.getHeight()) - com.baidu.adp.lib.util.l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void blH() {
        com.baidu.adp.lib.g.g.a(this.gdX);
    }

    public void lw(boolean z) {
        this.gef = z;
    }

    public boolean blI() {
        return this.gef;
    }

    public void bE(View view) {
        this.gcV = view;
    }
}
