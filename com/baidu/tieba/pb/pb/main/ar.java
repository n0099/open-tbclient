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
    private j.b aIF;
    private TextView aKj;
    private TextView aiY;
    private NavigationBarCoverTip alo;
    private View bfk;
    private com.baidu.tieba.pb.a.c brQ;
    private List<CustomBlueCheckRadioButton> cZW;
    private View.OnClickListener dMI;
    private View dMX;
    private PbListView dQs;
    private View def;
    private NoNetworkView drf;
    private RelativeLayout drh;
    private com.baidu.tieba.NEGFeedBack.e ekd;
    PbActivity.d fWS;
    private PbActivity fXM;
    private UserIconBox fYW;
    private UserIconBox fYX;
    private View.OnClickListener fYk;
    private PbFakeFloorModel gaf;
    private com.baidu.tieba.pb.data.d gbm;
    public int geF;
    private com.baidu.tieba.pb.video.i geG;
    private long geH;
    private com.baidu.tieba.pb.video.h geI;
    private com.baidu.tieba.c.d geJ;
    public final com.baidu.tieba.pb.pb.main.view.b geM;
    public com.baidu.tieba.pb.pb.main.view.a geN;
    private ViewStub geO;
    private ViewStub geP;
    private PbLandscapeListView geQ;
    private View geR;
    private LinearLayout geU;
    private e geV;
    private ColumnLayout geW;
    private ThreadSkinView geX;
    private TextView geY;
    private TextView geZ;
    private View gfD;
    private View gfX;
    private TextView gfY;
    private ImageView gfZ;
    private ImageView gfa;
    private HeadPendantView gfb;
    private FrameLayout gfc;
    private HeadImageView gfd;
    private View gfe;
    private FloatingLayout gff;
    private PbFirstFloorUserLikeButton gfi;
    private ap gfj;
    private ap gfk;
    private TextView gfl;
    private TextView gfm;
    private TextView gfn;
    private View gfo;
    private View gfp;
    private LinearLayout gfq;
    private TextView gfr;
    private TextView gfs;
    private View gft;
    private View gfu;
    private ObservedChangeLinearLayout gfw;
    private f gfx;
    private int ggE;
    private Runnable ggF;
    private s ggG;
    private an ggH;
    private int ggN;
    private PbTopTipView ggP;
    private PopupWindow ggQ;
    private PopupWindow ggR;
    private TextView ggS;
    private com.baidu.tbadk.core.dialog.a ggT;
    private List<String> ggU;
    private com.baidu.tieba.pb.pb.main.emotion.c ggV;
    private com.baidu.tieba.pb.pb.godreply.a ggW;
    private PbLandscapeListView.b ggX;
    private ac ggZ;
    private ImageView gga;
    private TextView ggb;
    private boolean ggd;
    private int gge;
    private int ggf;
    private PostData ggg;
    private View ggi;
    private TextView ggj;
    private ViewStub ggk;
    private PbInterviewStatusView ggl;
    private ViewGroup ggm;
    private TextView ggn;
    private FrameLayout ggo;
    private View ggp;
    private View ggq;
    private al ggr;
    private PbEmotionBar ggw;
    private boolean ghb;
    private com.baidu.tbadk.core.view.userLike.c ghc;
    private com.baidu.tbadk.core.view.userLike.c ghd;
    private Runnable ghi;
    private PbActivity.b ghk;
    private int ghp;
    private boolean isLandscape;
    private int mType;
    private static final int ggs = UtilHelper.getLightStatusBarHeight();
    public static int ggy = 3;
    public static int ggz = 0;
    public static int ggA = 3;
    public static int ggB = 4;
    public static int ggC = 5;
    public static int ggD = 6;
    private static a.InterfaceC0314a gha = new a.InterfaceC0314a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0314a
        public void onRefresh() {
        }
    };
    private boolean geK = false;
    private int geL = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout geS = null;
    private TextView geT = null;
    public FrsPraiseView gfg = null;
    private ClickableHeaderImageView gfh = null;
    private View gfv = null;
    private com.baidu.tbadk.core.dialog.a gfy = null;
    private com.baidu.tbadk.core.dialog.b dMH = null;
    private View gfz = null;
    private EditText gfA = null;
    private com.baidu.tieba.pb.view.d gfB = null;
    private com.baidu.tieba.pb.view.a gfC = null;
    private com.baidu.tbadk.core.dialog.a gfE = null;
    private b.InterfaceC0158b eVL = null;
    private TbRichTextView.h brP = null;
    private NoNetworkView.a dID = null;
    private Dialog gfF = null;
    private View gfG = null;
    private com.baidu.tbadk.core.dialog.a gfH = null;
    private Dialog gfI = null;
    private Dialog gfJ = null;
    private View gfK = null;
    private LinearLayout gfL = null;
    private CompoundButton.OnCheckedChangeListener cZX = null;
    private TextView gfM = null;
    private TextView gfN = null;
    private View gfO = null;
    private String gfP = null;
    private com.baidu.tbadk.core.dialog.b gfQ = null;
    private com.baidu.tbadk.core.dialog.b gfR = null;
    private boolean gfS = false;
    private boolean gfT = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView gfU = null;
    private boolean gfV = false;
    private Button gfW = null;
    private boolean ggc = true;
    private com.baidu.tbadk.core.view.d dhu = null;
    private boolean fYd = false;
    private int mSkinType = 3;
    private boolean ggh = false;
    private int ggt = 0;
    private boolean ggu = true;
    private a ggv = new a();
    private int ggx = 0;
    private boolean ggI = false;
    private int ggJ = 0;
    private boolean ggK = false;
    private boolean ggL = false;
    private boolean ggM = false;
    private int ggO = 0;
    private boolean ggY = false;
    private String ghe = null;
    private CustomMessageListener ghf = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.ghe = null;
            }
        }
    };
    private CustomMessageListener bQy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.gfx != null) {
                ar.this.gfx.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener ghg = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.geT != null) {
                ar.this.geT.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler ghh = new Handler();
    private CustomMessageListener ghj = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.ggc = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean ghl = true;
    View.OnClickListener ghm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.ggK) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (ar.this.geM != null && ar.this.geM.gjU != null && view == ar.this.geM.gjU.getHeadView()) {
                if (ar.this.geM.gjS == null || ar.this.geM.gjS.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12506").x("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!ar.this.ggK && ar.this.gbm != null && ar.this.gbm.bgV() != null && ar.this.gbm.bgV().zG() != null && ar.this.gbm.bgV().zG().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12151").x("obj_locate", 1));
            }
            ar.this.fXM.fVQ.ekW.onClick(view);
        }
    };
    private boolean ghn = false;
    String userId = null;
    private final List<TbImageView> gho = new ArrayList();
    private boolean ghq = false;

    /* loaded from: classes6.dex */
    public static class a {
        public int fOj;
        public al ghE;
        public int headerCount;
    }

    public void lj(boolean z) {
        this.ggI = z;
        if (this.geQ != null) {
            this.ggJ = this.geQ.getHeaderViewsCount();
        }
    }

    public void blh() {
        if (this.geQ != null) {
            int headerViewsCount = this.geQ.getHeaderViewsCount() - this.ggJ;
            final int firstVisiblePosition = (this.geQ.getFirstVisiblePosition() == 0 || this.geQ.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.geQ.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.geQ.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.ggv.ghE = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ggv));
            final al alVar = this.ggv.ghE;
            final int h = h(alVar);
            final int y = ((int) this.gfw.getY()) + this.gfw.getMeasuredHeight();
            final boolean z = this.ggp.getVisibility() == 0;
            boolean z2 = this.gfw.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.gfx.bjv() + this.geQ.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.gee.getMeasuredHeight() : 0;
                if (z2) {
                    this.geQ.setSelectionFromTop(this.gfx.bjv() + this.geQ.getHeaderViewsCount(), ggs - measuredHeight);
                } else {
                    this.geQ.setSelectionFromTop(this.gfx.bjv() + this.geQ.getHeaderViewsCount(), this.geM.bmR().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.geQ.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.ggK) {
                this.geQ.setSelectionFromTop(this.gfx.bjv() + this.geQ.getHeaderViewsCount(), this.geG.bof().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.geQ.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bjM() {
                        if (h >= 0 && h <= ar.this.drh.getMeasuredHeight()) {
                            int h2 = ar.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.def.getLayoutParams();
                            if (i == 0 || i > ar.this.drh.getMeasuredHeight() || h2 >= ar.this.drh.getMeasuredHeight()) {
                                layoutParams.height = ar.this.ggE;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.drh.getMeasuredHeight()) {
                                layoutParams.height = ar.this.ggE;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.geQ.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.def.setLayoutParams(layoutParams);
                        }
                        ar.this.geQ.setOnLayoutListener(null);
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

    public NoNetworkView bli() {
        return this.drf;
    }

    public void blj() {
        if (this.Ta != null) {
            this.Ta.hide();
            if (this.ggV != null) {
                this.ggV.ZC();
            }
        }
    }

    public PbFakeFloorModel blk() {
        return this.gaf;
    }

    public s bll() {
        return this.ggG;
    }

    public void blm() {
        reset();
        blj();
        this.ggG.bjC();
        lv(false);
    }

    private void reset() {
        if (this.fXM != null && this.fXM.bil() != null && this.Ta != null) {
            com.baidu.tbadk.editortools.pb.a.Mu().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bil = this.fXM.bil();
            bil.MN();
            bil.Mi();
            if (bil.getWriteImagesInfo() != null) {
                bil.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bil.fR(SendView.ALL);
            bil.fS(SendView.ALL);
            com.baidu.tbadk.editortools.g fI = this.Ta.fI(23);
            com.baidu.tbadk.editortools.g fI2 = this.Ta.fI(2);
            com.baidu.tbadk.editortools.g fI3 = this.Ta.fI(5);
            if (fI2 != null) {
                fI2.pN();
            }
            if (fI3 != null) {
                fI3.pN();
            }
            if (fI != null) {
                fI.hide();
            }
            this.Ta.invalidate();
        }
    }

    public boolean bln() {
        return this.ggc;
    }

    public void lk(boolean z) {
        if (this.gfX != null && this.gfY != null) {
            this.gfY.setText(e.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.gfX.startAnimation(alphaAnimation);
            }
            this.gfX.setVisibility(0);
            this.ggc = true;
            if (this.ggw != null && !this.ggW.isActive()) {
                this.ggw.setVisibility(0);
                lp(true);
            }
        }
    }

    public void ll(boolean z) {
        if (this.gfX != null && this.gfY != null) {
            this.gfY.setText(e.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.gfX.startAnimation(alphaAnimation);
            }
            this.gfX.setVisibility(0);
            this.ggc = true;
            if (this.ggw != null && !this.ggW.isActive()) {
                this.ggw.setVisibility(0);
                lp(true);
            }
        }
    }

    public PostData blo() {
        int i = 0;
        if (this.geQ == null) {
            return null;
        }
        int blp = blp() - this.geQ.getHeaderViewsCount();
        if (blp < 0) {
            blp = 0;
        }
        if (this.gfx.su(blp) != null && this.gfx.su(blp) != PostData.hox) {
            i = blp + 1;
        }
        return this.gfx.getItem(i) instanceof PostData ? (PostData) this.gfx.getItem(i) : null;
    }

    public int blp() {
        int i;
        View childAt;
        if (this.geQ == null) {
            return 0;
        }
        int firstVisiblePosition = this.geQ.getFirstVisiblePosition();
        int lastVisiblePosition = this.geQ.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.geQ.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.geQ.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int blq() {
        return this.geQ.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.gbm != null && this.gbm.bgX() != null && !this.gbm.bgX().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.gbm.bgX().size() && (postData = this.gbm.bgX().get(i)) != null && postData.zG() != null && !StringUtils.isNull(postData.zG().getUserId()); i++) {
                if (this.gbm.bgX().get(i).zG().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.ggW != null && this.ggW.isActive()) {
                        lv(false);
                    }
                    if (this.ggw != null) {
                        this.ggw.lD(true);
                    }
                    this.ghe = postData.zG().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fXM = null;
        this.drh = null;
        this.dMX = null;
        this.geH = 0L;
        this.geQ = null;
        this.geR = null;
        this.geU = null;
        this.geW = null;
        this.geY = null;
        this.geZ = null;
        this.gfc = null;
        this.gfd = null;
        this.gfe = null;
        this.gfi = null;
        this.gfl = null;
        this.gfm = null;
        this.gfn = null;
        this.gfo = null;
        this.gft = null;
        this.gfu = null;
        this.gfx = null;
        this.dQs = null;
        this.bfk = null;
        this.dMI = null;
        this.fYk = null;
        this.gfX = null;
        this.gfY = null;
        this.gfZ = null;
        this.gga = null;
        this.ggb = null;
        this.ggi = null;
        this.ggj = null;
        this.ggk = null;
        this.ggN = 0;
        this.geH = System.currentTimeMillis();
        this.fXM = pbActivity;
        this.dMI = onClickListener;
        this.brQ = cVar;
        this.ggN = com.baidu.adp.lib.util.l.aO(this.fXM) / 2;
        this.drh = (RelativeLayout) LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.new_pb_activity, (ViewGroup) null);
        this.fXM.addContentView(this.drh, new FrameLayout.LayoutParams(-1, -1));
        this.alo = (NavigationBarCoverTip) this.fXM.findViewById(e.g.pb_multi_forum_del_tip_view);
        this.dMX = this.fXM.findViewById(e.g.statebar_view);
        this.gfw = (ObservedChangeLinearLayout) this.fXM.findViewById(e.g.title_wrapper);
        this.drf = (NoNetworkView) this.fXM.findViewById(e.g.view_no_network);
        this.geQ = (PbLandscapeListView) this.fXM.findViewById(e.g.new_pb_list);
        this.ggo = (FrameLayout) this.fXM.findViewById(e.g.root_float_header);
        this.aiY = new TextView(this.fXM.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds88));
        this.geQ.addHeaderView(this.aiY, 0);
        this.ggE = this.fXM.getResources().getDimensionPixelSize(e.C0210e.tbds134);
        this.def = new View(this.fXM.getPageContext().getPageActivity());
        this.def.setLayoutParams(new AbsListView.LayoutParams(-1, this.ggE));
        this.def.setVisibility(4);
        this.geQ.addFooterView(this.def);
        this.geQ.setOnTouchListener(this.fXM.biP);
        this.geM = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fXM.biP()) {
            this.geO = (ViewStub) this.fXM.findViewById(e.g.manga_view_stub);
            this.geO.setVisibility(0);
            this.geN = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.geN.show();
            this.geM.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds120);
        }
        this.aiY.setLayoutParams(layoutParams);
        this.geM.bmR().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0279a() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0279a
            public void bhJ() {
                if (ar.this.geQ != null) {
                    if (ar.this.geG != null) {
                        ar.this.geG.bog();
                    }
                    ar.this.geQ.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0279a
            public void bhK() {
                ar.this.fXM.aBN();
            }
        }));
        this.gfX = this.fXM.findViewById(e.g.pb_editor_tool_comment);
        this.gge = com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds90);
        this.ggf = com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds242);
        this.gfY = (TextView) this.fXM.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_reply_text);
        this.gga = (ImageView) this.fXM.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_more_img);
        this.gfZ = (ImageView) this.fXM.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_emotion_img);
        this.ggb = (TextView) this.fXM.getPageContext().getPageActivity().findViewById(e.g.pb_editor_tool_comment_praise_icon);
        this.ggb.setVisibility(8);
        this.gfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.blr();
            }
        });
        this.gfZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bmt();
                if (ar.this.fXM.checkUpIsLogin()) {
                    if (ar.this.Ta != null) {
                        ar.this.blB();
                        ar.this.Ta.aa((View) ar.this.Ta.fI(5));
                    }
                    if (ar.this.Ta != null) {
                        ar.this.ggc = false;
                        if (ar.this.Ta.fL(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fXM, (View) ar.this.Ta.fL(2).aYl, false, ar.gha);
                        }
                    }
                    ar.this.bmg();
                }
            }
        });
        this.gga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.bmt();
                if (ar.this.fXM.checkUpIsLogin()) {
                    if (ar.this.Ta != null) {
                        ar.this.blB();
                        ar.this.Ta.aa((View) ar.this.Ta.fI(2));
                    }
                    if (ar.this.Ta != null) {
                        ar.this.ggc = false;
                        if (ar.this.Ta.fL(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.fXM, (View) ar.this.Ta.fL(2).aYl, false, ar.gha);
                        }
                    }
                    ar.this.bmg();
                }
            }
        });
        this.ggb.setOnClickListener(this.dMI);
        this.ggb.setOnTouchListener(this.fXM);
        this.geR = LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_item, (ViewGroup) null);
        this.geU = (LinearLayout) LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.new_pb_header_user_item, (ViewGroup) null);
        this.geV = new e(this.fXM, this.geU);
        this.geV.init();
        this.geV.a(this.geV.bik(), this.dMI);
        this.geW = (ColumnLayout) this.geU.findViewById(e.g.pb_head_owner_root);
        this.geX = (ThreadSkinView) this.geU.findViewById(e.g.pb_thread_skin);
        this.geW.setOnLongClickListener(this.onLongClickListener);
        this.geW.setOnTouchListener(this.brQ);
        this.geW.setVisibility(8);
        this.geR.setOnTouchListener(this.brQ);
        this.ggi = this.geR.findViewById(e.g.pb_head_activity_join_number_container);
        this.ggi.setVisibility(8);
        this.ggj = (TextView) this.geR.findViewById(e.g.pb_head_activity_join_number);
        this.geY = (TextView) this.geW.findViewById(e.g.pb_head_owner_info_user_name);
        this.geZ = (TextView) this.geW.findViewById(e.g.floor_owner);
        this.gfa = (ImageView) this.geW.findViewById(e.g.icon_forum_level);
        this.gfc = (FrameLayout) this.geW.findViewById(e.g.pb_head_headImage_container);
        this.gfd = (HeadImageView) this.geW.findViewById(e.g.pb_head_owner_photo);
        this.gfb = (HeadPendantView) this.geW.findViewById(e.g.pb_pendant_head_owner_photo);
        this.gfb.setHasPendantStyle();
        if (this.gfb.getHeadView() != null) {
            this.gfb.getHeadView().setIsRound(true);
            this.gfb.getHeadView().setDrawBorder(false);
        }
        this.fYW = (UserIconBox) this.geW.findViewById(e.g.show_icon_vip);
        this.fYX = (UserIconBox) this.geW.findViewById(e.g.show_icon_yinji);
        this.gff = (FloatingLayout) this.geU.findViewById(e.g.pb_head_owner_info_root);
        this.gfi = (PbFirstFloorUserLikeButton) this.geW.findViewById(e.g.pb_like_button);
        this.gfl = (TextView) this.geW.findViewById(e.g.pb_views);
        this.aKj = (TextView) this.geW.findViewById(e.g.view_forum_name);
        this.gfp = this.geW.findViewById(e.g.line_right_forum_name);
        this.gfm = (TextView) this.geW.findViewById(e.g.pb_item_first_floor_reply_time);
        this.gfn = (TextView) this.geW.findViewById(e.g.pb_item_first_floor_location_address);
        this.gfo = this.geW.findViewById(e.g.line_between_time_and_locate);
        this.ghc = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.ghd = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.gft = this.geR.findViewById(e.g.new_pb_header_item_line_above_livepost);
        this.gfu = this.geR.findViewById(e.g.new_pb_header_item_line_below_livepost);
        this.geR.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.37
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.ggk = (ViewStub) this.drh.findViewById(e.g.interview_status_stub);
        this.gfx = new f(this.fXM, this.geQ);
        this.gfx.w(this.dMI);
        this.gfx.setTbGestureDetector(this.brQ);
        this.gfx.setOnImageClickListener(this.brP);
        this.fYk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.38
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
                            ar.this.fXM.b(sparseArray);
                            return;
                        }
                        ar.this.bF(view);
                    } else if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 0);
                        sparseArray.put(e.g.tag_check_mute_from, 1);
                        ar.this.fXM.b(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.gfx.I(this.fYk);
        blw();
        this.geQ.addHeaderView(this.geS);
        this.geQ.addHeaderView(this.geU);
        this.geQ.addHeaderView(this.geR);
        this.dQs = new PbListView(this.fXM.getPageContext().getPageActivity());
        this.bfk = this.dQs.getView().findViewById(e.g.pb_more_view);
        if (this.bfk != null) {
            this.bfk.setOnClickListener(this.dMI);
            com.baidu.tbadk.core.util.al.i(this.bfk, e.f.pb_foot_more_trans_selector);
        }
        this.dQs.EY();
        this.dQs.ev(e.f.pb_foot_more_trans_selector);
        this.dQs.ex(e.f.pb_foot_more_trans_selector);
        this.gfD = this.fXM.findViewById(e.g.viewstub_progress);
        this.fXM.registerListener(this.ghj);
        this.gfe = com.baidu.tbadk.ala.b.vZ().j(this.fXM.getActivity(), 2);
        if (this.gfe != null) {
            this.gfe.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fXM.getResources().getDimensionPixelSize(e.C0210e.ds10);
            if (this.gfe.getParent() == null) {
                this.gff.addView(this.gfe, aVar);
            }
        }
        this.gaf = new PbFakeFloorModel(this.fXM.getPageContext());
        this.ggG = new s(this.fXM.getPageContext(), this.gaf, this.drh);
        this.ggG.a(this.fXM.fWO);
        this.gaf.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.gaf.m(postData);
                ar.this.gfx.notifyDataSetChanged();
                ar.this.ggG.bjC();
                ar.this.Ta.Kx();
                ar.this.lv(false);
            }
        });
        if (this.fXM.bhZ() != null && !StringUtils.isNull(this.fXM.bhZ().bkt())) {
            this.fXM.showToast(this.fXM.bhZ().bkt());
        }
        this.ggp = this.fXM.findViewById(e.g.pb_expand_blank_view);
        this.ggq = this.fXM.findViewById(e.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ggq.getLayoutParams();
        if (this.fXM.bhZ() != null && this.fXM.bhZ().bjS()) {
            this.ggp.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.ggq.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = ggs;
            this.ggq.setLayoutParams(layoutParams2);
        }
        this.ggr = new al(this.fXM.getPageContext(), this.fXM.findViewById(e.g.pb_reply_expand_view));
        this.ggr.gee.setVisibility(8);
        this.ggr.L(this.dMI);
        this.fXM.registerListener(this.bQy);
        this.fXM.registerListener(this.ghf);
        this.fXM.registerListener(this.ghg);
        bls();
        lp(false);
    }

    public void blr() {
        bmt();
        if (!this.fXM.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").x("obj_locate", 2).aA(ImageViewerConfig.FORUM_ID, this.mForumId));
        } else if (this.fXM.bix()) {
            com.baidu.tbadk.editortools.pb.d bil = this.fXM.bil();
            if (bil != null && (bil.MK() || bil.ML())) {
                this.fXM.bil().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Ta != null) {
                blB();
            }
            if (this.Ta != null) {
                this.ggc = false;
                if (this.Ta.fL(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.fXM, (View) this.Ta.fL(2).aYl, false, gha);
                }
            }
            bmg();
        }
    }

    private void bls() {
        this.ggW = new com.baidu.tieba.pb.pb.godreply.a(this.fXM, this, (ViewStub) this.drh.findViewById(e.g.more_god_reply_popup));
        this.ggW.s(this.dMI);
        this.ggW.I(this.fYk);
        this.ggW.setOnImageClickListener(this.brP);
        this.ggW.s(this.dMI);
        this.ggW.setTbGestureDetector(this.brQ);
    }

    public com.baidu.tieba.pb.pb.godreply.a blt() {
        return this.ggW;
    }

    public View blu() {
        return this.ggp;
    }

    public void blv() {
        if (this.geQ != null) {
            this.geQ.removeHeaderView(this.geS);
            this.geQ.removeHeaderView(this.geU);
            this.geQ.removeHeaderView(this.geR);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.ggw == null) {
            this.ggw = new PbEmotionBar(this.fXM.getPageContext().getPageActivity());
            lp(true);
            this.ggw.a(this.drh, aVar, this.gfX.getVisibility() == 0);
            this.ggw.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (ar.this.fXM.bix()) {
                        if (!StringUtils.isNull(ar.this.ghe)) {
                            emotionImageData.setAuthorNameShow(ar.this.ghe);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.fXM.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(ar.this.fXM.getPageContext().getPageActivity(), 25016, str, list, ar.this.ghe, list2)));
                }
            });
            this.ggw.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    ar.this.bmt();
                    if (ar.this.gfX != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.gfX.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.ggf - ar.this.gge) * f) + ar.this.gge);
                        ar.this.gfY.setAlpha(1.0f - f);
                        ar.this.gga.setAlpha(1.0f - f);
                        ar.this.gfZ.setAlpha(1.0f - f);
                        ar.this.gfX.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void blw() {
        if (this.geS == null) {
            int h = com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.tbds44);
            this.geS = new LinearLayout(this.fXM.getPageContext().getPageActivity());
            this.geS.setOrientation(1);
            this.geS.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.geS.setPadding(h, com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.tbds30), h, com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.tbds40));
            this.geS.setGravity(17);
            this.geT = new TextView(this.fXM.getPageContext().getPageActivity());
            this.geT.setGravity(3);
            this.geT.setMaxLines(2);
            this.geT.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            this.geT.setPadding(0, 0, 0, 0);
            this.geT.setLineSpacing(com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.al.h(this.geT, e.d.cp_cont_b);
            this.geT.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.geT.setVisibility(8);
            if (this.geT.getParent() == null) {
                this.geS.addView(this.geT);
            }
            this.geS.setOnTouchListener(this.brQ);
            this.geS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        if (this.fXM.biP()) {
            this.geP = (ViewStub) this.fXM.findViewById(e.g.manga_mention_controller_view_stub);
            this.geP.setVisibility(0);
            if (this.gfq == null) {
                this.gfq = (LinearLayout) this.fXM.findViewById(e.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fXM.getPageContext(), this.gfq);
            }
            if (this.gfr == null) {
                this.gfr = (TextView) this.gfq.findViewById(e.g.manga_prev_btn);
            }
            if (this.gfs == null) {
                this.gfs = (TextView) this.gfq.findViewById(e.g.manga_next_btn);
            }
            this.gfr.setOnClickListener(this.dMI);
            this.gfs.setOnClickListener(this.dMI);
        }
    }

    private void bly() {
        if (this.fXM.biP()) {
            if (this.fXM.biS() == -1) {
                com.baidu.tbadk.core.util.al.c(this.gfr, e.d.cp_cont_e, 1);
            }
            if (this.fXM.biT() == -1) {
                com.baidu.tbadk.core.util.al.c(this.gfs, e.d.cp_cont_e, 1);
            }
        }
    }

    public void blz() {
        if (this.gfq == null) {
            blx();
        }
        this.geP.setVisibility(8);
        if (this.ghh != null && this.ghi != null) {
            this.ghh.removeCallbacks(this.ghi);
        }
    }

    public void blA() {
        if (this.ghh != null) {
            if (this.ghi != null) {
                this.ghh.removeCallbacks(this.ghi);
            }
            this.ghi = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.gfq == null) {
                        ar.this.blx();
                    }
                    ar.this.geP.setVisibility(0);
                }
            };
            this.ghh.postDelayed(this.ghi, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void lm(boolean z) {
        this.geM.lm(z);
        if (z && this.ggh) {
            this.dQs.setText(this.fXM.getResources().getString(e.j.click_load_more));
            this.geQ.setNextPage(this.dQs);
            this.geL = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
        this.Ta.setId(e.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Ta.getParent() == null) {
            this.drh.addView(this.Ta, layoutParams);
        }
        this.Ta.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        blj();
        this.fXM.bil().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.Ta != null && ar.this.Ta.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.ggV == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.Ta.getId());
                            ar.this.ggV = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.fXM.getPageContext(), ar.this.drh, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.I(ar.this.ggU)) {
                                ar.this.ggV.setData(ar.this.ggU);
                            }
                            ar.this.ggV.b(ar.this.Ta);
                        }
                        ar.this.ggV.tk(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.fXM.fVU != null && ar.this.fXM.fVU.bmy() != null) {
                    if (!ar.this.fXM.fVU.bmy().bNO()) {
                        ar.this.fXM.fVU.lA(false);
                    }
                    ar.this.fXM.fVU.bmy().ou(false);
                }
            }
        });
    }

    public void blB() {
        if (this.fXM != null && this.Ta != null) {
            this.Ta.pN();
            if (this.fXM.bil() != null) {
                this.fXM.bil().MB();
            }
            bmg();
        }
    }

    public void W(String str, boolean z) {
        this.ggd = z;
        ln(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void ln(boolean z) {
        if (this.ggb != null) {
            if (this.ggd) {
                com.baidu.tbadk.core.util.al.i(this.ggb, e.f.pb_praise_already_click_selector);
                this.ggb.setContentDescription(this.fXM.getResources().getString(e.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.al.i(this.ggb, e.f.pb_praise_normal_click_selector);
            this.ggb.setContentDescription(this.fXM.getResources().getString(e.j.zan));
        }
    }

    public TextView blC() {
        return this.ggb;
    }

    public void lo(boolean z) {
        if (this.geQ != null && this.aiY != null && this.dMX != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dMX.setVisibility(0);
                } else {
                    this.dMX.setVisibility(8);
                    this.geQ.removeHeaderView(this.aiY);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aiY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = ggs;
                    this.aiY.setLayoutParams(layoutParams);
                }
                blR();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aiY.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + lx(true);
                this.aiY.setLayoutParams(layoutParams2);
            }
            blR();
            bmo();
        }
    }

    public f blD() {
        return this.gfx;
    }

    public void a(PbActivity.d dVar) {
        this.fWS = dVar;
    }

    public void bF(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.gfG == null) {
            this.gfG = LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fXM.getLayoutMode().onModeChanged(this.gfG);
        if (this.gfF == null) {
            this.gfF = new Dialog(this.fXM.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.gfF.setCanceledOnTouchOutside(true);
            this.gfF.setCancelable(true);
            this.gfF.setContentView(this.gfG);
            WindowManager.LayoutParams attributes = this.gfF.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.aO(this.fXM.getPageContext().getPageActivity()) * 0.9d);
            this.gfF.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.gfF.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.gfF.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.gfF.findViewById(e.g.disable_reply_btn);
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
                    if (ar.this.gfF != null && (ar.this.gfF instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.gfF, ar.this.fXM.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(e.g.tag_del_post_id), ((Integer) sparseArray5.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(e.g.tag_forbid_user_name)) && "".equals(sparseArray.get(e.g.tag_forbid_user_name_show))) || bmn()) {
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
                    if (ar.this.gfF != null && (ar.this.gfF instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.gfF, ar.this.fXM.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.ghk != null) {
                        ar.this.ghk.m(new Object[]{sparseArray6.get(e.g.tag_manage_user_identity), sparseArray6.get(e.g.tag_forbid_user_name), sparseArray6.get(e.g.tag_forbid_user_post_id), sparseArray6.get(e.g.tag_forbid_user_name_show), sparseArray6.get(e.g.tag_forbid_user_portrait)});
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
                    if (ar.this.gfF != null && (ar.this.gfF instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.gfF, ar.this.fXM.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.fXM.a(z, (String) sparseArray7.get(e.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.gfF, this.fXM.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.ghk = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fXM != null && aVar != null) {
            if (this.ekd == null) {
                this.ekd = new com.baidu.tieba.NEGFeedBack.e(this.fXM.getPageContext(), this.geR);
            }
            AntiData aAM = this.fXM.aAM();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (aAM != null && aAM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aAM.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.ekd.setDefaultReasonArray(new String[]{this.fXM.getString(e.j.delete_thread_reason_1), this.fXM.getString(e.j.delete_thread_reason_2), this.fXM.getString(e.j.delete_thread_reason_3), this.fXM.getString(e.j.delete_thread_reason_4), this.fXM.getString(e.j.delete_thread_reason_5)});
            this.ekd.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ekd.ji(str);
            this.ekd.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    ar.this.fXM.a(aVar, jSONArray);
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
        sparseArray.put(ggz, Integer.valueOf(ggA));
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
        this.gfH = new com.baidu.tbadk.core.dialog.a(this.fXM.getActivity());
        if (StringUtils.isNull(str2)) {
            this.gfH.db(i3);
        } else {
            this.gfH.bk(false);
            this.gfH.eB(str2);
        }
        this.gfH.H(sparseArray);
        this.gfH.a(e.j.dialog_ok, this.fXM);
        this.gfH.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.gfH.bf(true);
        this.gfH.b(this.fXM.getPageContext());
        if (z) {
            this.gfH.BF();
        } else {
            a(this.gfH, i);
        }
    }

    public void ap(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.gfK == null) {
            this.gfK = LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.commit_good, (ViewGroup) null);
        }
        this.fXM.getLayoutMode().onModeChanged(this.gfK);
        if (this.gfJ == null) {
            this.gfJ = new Dialog(this.fXM.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.gfJ.setCanceledOnTouchOutside(true);
            this.gfJ.setCancelable(true);
            this.gfU = (ScrollView) this.gfK.findViewById(e.g.good_scroll);
            this.gfJ.setContentView(this.gfK);
            WindowManager.LayoutParams attributes = this.gfJ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds540);
            this.gfJ.getWindow().setAttributes(attributes);
            this.cZX = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.gfP = (String) compoundButton.getTag();
                        if (ar.this.cZW != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ar.this.cZW) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ar.this.gfP != null && !str.equals(ar.this.gfP)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.gfL = (LinearLayout) this.gfK.findViewById(e.g.good_class_group);
            this.gfN = (TextView) this.gfK.findViewById(e.g.dialog_button_cancel);
            this.gfN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.gfJ instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.gfJ, ar.this.fXM.getPageContext());
                    }
                }
            });
            this.gfM = (TextView) this.gfK.findViewById(e.g.dialog_button_ok);
            this.gfM.setOnClickListener(this.dMI);
        }
        this.gfL.removeAllViews();
        this.cZW = new ArrayList();
        CustomBlueCheckRadioButton cp = cp("0", this.fXM.getPageContext().getString(e.j.thread_good_class));
        this.cZW.add(cp);
        cp.setChecked(true);
        this.gfL.addView(cp);
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
                    this.cZW.add(cp2);
                    View view = new View(this.fXM.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds1));
                    com.baidu.tbadk.core.util.al.j(view, e.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.gfL.addView(view);
                    this.gfL.addView(cp2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.gfU.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fXM.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fXM.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fXM.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.gfU.setLayoutParams(layoutParams2);
            this.gfU.removeAllViews();
            if (this.gfL != null && this.gfL.getParent() == null) {
                this.gfU.addView(this.gfL);
            }
        }
        com.baidu.adp.lib.g.g.a(this.gfJ, this.fXM.getPageContext());
    }

    private CustomBlueCheckRadioButton cp(String str, String str2) {
        Activity pageActivity = this.fXM.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(pageActivity, e.C0210e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cZX);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void blE() {
        this.fXM.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fXM.hideProgressBar();
        if (z && z2) {
            this.fXM.showToast(this.fXM.getPageContext().getString(e.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(e.j.neterror);
            }
            this.fXM.showToast(str);
        }
    }

    public void aTj() {
        this.gfD.setVisibility(0);
    }

    public void aTi() {
        this.gfD.setVisibility(8);
    }

    public View blF() {
        if (this.gfK != null) {
            return this.gfK.findViewById(e.g.dialog_button_ok);
        }
        return null;
    }

    public String blG() {
        return this.gfP;
    }

    public View getView() {
        return this.drh;
    }

    public void blH() {
        com.baidu.adp.lib.util.l.b(this.fXM.getPageContext().getPageActivity(), this.fXM.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fXM.hideProgressBar();
        if (z) {
            blX();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            blY();
        } else {
            blX();
        }
    }

    public void blI() {
        this.dQs.EY();
        this.dQs.Fc();
    }

    public void blJ() {
        this.fXM.hideProgressBar();
        Fd();
        this.geQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        blU();
    }

    public void blK() {
        this.geQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        blU();
    }

    private void lp(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gfY.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fXM.getResources().getDimensionPixelSize(e.C0210e.ds130) : this.fXM.getResources().getDimensionPixelSize(e.C0210e.ds34);
        this.gfY.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.gfx.setOnLongClickListener(onLongClickListener);
        if (this.ggW != null) {
            this.ggW.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z, boolean z2) {
        if (this.gfQ != null) {
            this.gfQ.dismiss();
            this.gfQ = null;
        }
        this.gfQ = new com.baidu.tbadk.core.dialog.b(this.fXM.getPageContext().getPageActivity());
        this.gfQ.de(e.j.operation);
        if (z2) {
            this.gfQ.a(new String[]{this.fXM.getPageContext().getString(e.j.copy), this.fXM.getPageContext().getString(e.j.report_text)}, interfaceC0158b);
        } else if (!z) {
            this.gfQ.a(new String[]{this.fXM.getPageContext().getString(e.j.copy), this.fXM.getPageContext().getString(e.j.mark)}, interfaceC0158b);
        } else {
            this.gfQ.a(new String[]{this.fXM.getPageContext().getString(e.j.copy), this.fXM.getPageContext().getString(e.j.remove_mark)}, interfaceC0158b);
        }
        this.gfQ.d(this.fXM.getPageContext());
        this.gfQ.BI();
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z) {
        if (this.gfR != null) {
            this.gfR.dismiss();
            this.gfR = null;
        }
        this.gfR = new com.baidu.tbadk.core.dialog.b(this.fXM.getPageContext().getPageActivity());
        if (z) {
            this.gfR.a(new String[]{this.fXM.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0158b);
        } else {
            this.gfR.a(new String[]{this.fXM.getPageContext().getString(e.j.save_to_emotion), this.fXM.getPageContext().getString(e.j.save_to_local)}, interfaceC0158b);
        }
        this.gfR.d(this.fXM.getPageContext());
        this.gfR.BI();
    }

    public int blL() {
        return sL(this.geQ.getFirstVisiblePosition());
    }

    private int sL(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.geQ.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.geQ.getAdapter() == null || !(this.geQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.geQ.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int blM() {
        int lastVisiblePosition = this.geQ.getLastVisiblePosition();
        if (this.geG != null) {
            if (lastVisiblePosition == this.geQ.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return sL(lastVisiblePosition);
    }

    public void sM(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.geQ != null) {
            if (this.geM == null || this.geM.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.geM.mNavigationBar.getFixedNavHeight();
                if (!(this.fXM.biD() != -1)) {
                    if (this.ggq != null && (layoutParams = (LinearLayout.LayoutParams) this.ggq.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.ggq.setLayoutParams(layoutParams);
                    }
                    i--;
                    bms();
                }
                i2 = fixedNavHeight;
            }
            this.geQ.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.geQ.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.gfA.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.gfx.a(dVar, false);
        this.gfx.notifyDataSetChanged();
        blU();
        if (this.ggW != null) {
            this.ggW.bhV();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.gfg == null) {
            this.fXM.getLayoutMode().onModeChanged(((ViewStub) this.geR.findViewById(e.g.praise_layout)).inflate());
            this.gfg = (FrsPraiseView) this.geR.findViewById(e.g.pb_head_praise_view);
            this.gfg.setIsFromPb(true);
            this.gfv = this.geR.findViewById(e.g.new_pb_header_item_line_above_praise);
            this.gfg.eD(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gfg != null) {
            boolean blU = blU();
            this.gfg.setVisibility(8);
            if (dVar != null && dVar.yS() != null && dVar.yS().yQ() == 0 && this.fYd) {
                if (blU) {
                    this.gfu.setVisibility(0);
                    return;
                } else {
                    this.gfu.setVisibility(8);
                    return;
                }
            }
            this.gfu.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.bhf() != null) {
            return dVar.bhf();
        }
        if (!com.baidu.tbadk.core.util.v.I(dVar.bgX())) {
            Iterator<PostData> it = dVar.bgX().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bEj() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.bhc();
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
        if (dVar == null || dVar.bgV() == null || dVar.bgV().zG() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zG = dVar.bgV().zG();
        String userId = zG.getUserId();
        HashMap<String, MetaData> userMap = dVar.bgV().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zG;
        }
        postData.vI(1);
        postData.setId(dVar.bgV().zX());
        postData.setTitle(dVar.bgV().getTitle());
        postData.setTime(dVar.bgV().getCreateTime());
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
        com.baidu.tbadk.data.f bEm;
        String portrait;
        if (dVar != null && dVar.bgV() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.geW.setVisibility(8);
            if (dVar.bgV() != null && dVar.bgV().Au() && dVar.bgV().zY() != null) {
                this.ggK = true;
                this.geM.lM(this.ggK);
                this.geM.mNavigationBar.hideBottomLine();
                String systemProperty = UtilHelper.getSystemProperty("ro.miui.notch");
                if (!StringUtils.isNULL(systemProperty) && systemProperty.equals("1")) {
                    LinearLayout linearLayout = (LinearLayout) this.fXM.findViewById(e.g.pb_comment_container);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.bottomMargin = ggs;
                    linearLayout.setLayoutParams(layoutParams);
                }
                if (this.geG == null) {
                    this.geG = new com.baidu.tieba.pb.video.i(this.fXM, this.geM, dVar.bgV().zY(), this.geH);
                    this.geG.a(dVar.bgV().zY(), dVar.bgV(), dVar.getForumId());
                    this.geG.startPlay();
                } else if (this.geK) {
                    this.geG.a(dVar.bgV().zY(), dVar.bgV(), dVar.getForumId());
                    this.geG.startPlay();
                } else {
                    this.geG.tv(dVar.getForumId());
                }
                if (dVar.bgW() != null && dVar.bgW().size() >= 1) {
                    bb bbVar = dVar.bgW().get(0);
                    this.geG.as(bbVar);
                    this.geG.tw(bbVar.getTitle());
                }
                this.geG.b(b, dVar.bgV(), dVar.bht());
                this.geK = false;
                this.geQ.removeHeaderView(this.geG.boi());
                this.geQ.addHeaderView(this.geG.boi(), 0);
                if (this.geG.bof() != null && this.geG.bof().getParent() == null) {
                    this.ggo.addView(this.geG.bof());
                }
                if (this.geI == null) {
                    this.geI = new com.baidu.tieba.pb.video.h(this.fXM);
                }
                this.geI.a(dVar.bgV().AJ(), dVar.bgV(), dVar.bhq());
                this.geQ.removeHeaderView(this.geI.bnW());
                this.geQ.addHeaderView(this.geI.bnW(), 1);
                if (dVar.bgV().AJ() != null) {
                    this.geQ.removeHeaderView(this.geI.bnX());
                    this.geQ.removeHeaderView(this.geU);
                    this.geQ.addHeaderView(this.geI.bnX(), 2);
                } else {
                    if (this.geI.bnX() != null) {
                        this.geQ.removeHeaderView(this.geI.bnX());
                    }
                    this.geQ.removeHeaderView(this.geU);
                    this.geU.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fXM, e.C0210e.tbds26));
                    this.geQ.addHeaderView(this.geU, 2);
                }
                if (this.geG != null) {
                    this.geM.lG(false);
                    this.geM.lI(TbadkCoreApplication.isLogin());
                    this.geG.sS(TbadkCoreApplication.getInst().getSkinType());
                }
                blR();
            } else {
                this.ggK = false;
                this.geM.lM(this.ggK);
                if (this.geG != null) {
                    this.geQ.removeHeaderView(this.geG.boi());
                }
                if (this.geI != null) {
                    this.geI.b(this.geQ);
                }
                if (b == null || (b != null && (b.bEl() == null || com.baidu.tbadk.core.util.v.I(b.bEl().Sb())))) {
                    this.geU.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(this.fXM, e.C0210e.tbds52));
                } else {
                    this.geU.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fXM.bip() != null) {
                this.fXM.bip().lE(this.ggK);
            }
            if (this.geG != null) {
                this.geG.N(this.ghm);
                bms();
            }
            if (b != null) {
                this.ggg = b;
                this.geW.setVisibility(0);
                if (this.fXM.bhP()) {
                    if (dVar.bgU() != null) {
                        this.mForumName = dVar.bgU().getForumName();
                        this.mForumId = dVar.bgU().getForumId();
                    }
                    if (this.mForumName == null && this.fXM.bhZ() != null && this.fXM.bhZ().bhQ() != null) {
                        this.mForumName = this.fXM.bhZ().bhQ();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.geW.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.geW.setTag(sparseArray);
                }
                sparseArray.put(e.g.tag_clip_board, b);
                sparseArray.put(e.g.tag_is_subpb, false);
                if (!this.ghb) {
                    this.geS.setVisibility(0);
                }
                if (!dVar.bgV().Au() && this.geT.getText() != null && this.geT.getText().length() > 0) {
                    this.geT.setVisibility(0);
                } else {
                    this.geT.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> zS = dVar.bgV().zS();
                if (zS != null && zS.size() > 0 && !this.ghb) {
                    this.ggj.setText(String.valueOf(zS.get(0).ya()));
                    this.ggi.setVisibility(0);
                } else {
                    this.ggi.setVisibility(8);
                }
                com.baidu.tbadk.core.util.al.i(this.ggi, e.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.al.c(this.ggj, e.d.cp_link_tip_d, 1);
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
                            if (this.fYX != null) {
                                this.fYX.setTag(e.g.tag_user_id, b.zG().getUserId());
                                this.fYX.setOnClickListener(this.fXM.fVQ.gjf);
                                this.fYX.a(iconInfo, 4, this.fXM.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fXM.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fXM.getResources().getDimensionPixelSize(e.C0210e.tbds12));
                            }
                            if (this.fYW != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fYW.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fYW.setOnClickListener(this.fXM.fVQ.gjg);
                                this.fYW.a(tShowInfoNew, 3, this.fXM.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fXM.getResources().getDimensionPixelSize(e.C0210e.tbds36), this.fXM.getResources().getDimensionPixelSize(e.C0210e.ds12), true);
                            }
                            this.geY.setText(aE(b.zG().getSealPrefix(), d));
                            this.geY.setTag(e.g.tag_user_id, b.zG().getUserId());
                            this.geY.setTag(e.g.tag_user_name, b.zG().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew) || b.zG().isBigV()) {
                                com.baidu.tbadk.core.util.al.c(this.geY, e.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.al.c(this.geY, e.d.cp_cont_f, 1);
                            }
                            this.geZ.setVisibility(8);
                            if (dVar.bgV().zG() != null && dVar.bgV().zG().getAlaUserData() != null && this.gfe != null) {
                                if (dVar.bgV().zG().getAlaUserData().anchor_live != 0) {
                                    this.gfe.setVisibility(8);
                                } else {
                                    this.gfe.setVisibility(0);
                                    if (this.geJ == null) {
                                        this.geJ = new com.baidu.tieba.c.d(this.fXM.getPageContext(), this.gfe);
                                        this.geJ.lj(1);
                                    }
                                    this.geJ.bo(this.fXM.getResources().getString(e.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.alI = dVar.bgV().zG().getAlaUserData();
                                    aVar.type = 2;
                                    this.gfe.setTag(aVar);
                                }
                            }
                            this.gfd.setUserId(b.zG().getUserId());
                            this.gfd.setUserName(b.zG().getUserName());
                            this.gfd.setTid(b.getId());
                            this.gfd.setFid(this.gbm == null ? this.gbm.getForumId() : "");
                            this.gfd.setImageDrawable(null);
                            this.gfd.setRadius(com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds40));
                            this.gfd.setTag(b.zG().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                                this.gfm.setText(com.baidu.tbadk.core.util.ao.O(b.getTime()));
                            } else {
                                this.gfm.setText(com.baidu.tbadk.core.util.ao.M(b.getTime()));
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds16);
                            if (!this.fXM.bhP() && !StringUtils.isNull(this.mForumName)) {
                                this.aKj.setText(this.fXM.getString(e.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.aKj.setVisibility(0);
                                this.gfp.setVisibility(0);
                                this.gfm.setPadding(h, 0, h, 0);
                            } else {
                                this.aKj.setVisibility(8);
                                this.gfp.setVisibility(8);
                                this.gfm.setPadding(0, 0, h, 0);
                            }
                            bEm = b.bEm();
                            if (bEm == null && !TextUtils.isEmpty(bEm.getName()) && !TextUtils.isEmpty(bEm.getName().trim())) {
                                final String name = bEm.getName();
                                final String lat = bEm.getLat();
                                final String lng = bEm.getLng();
                                this.gfn.setVisibility(0);
                                this.gfo.setVisibility(0);
                                this.gfn.setText(bEm.getName());
                                this.gfn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                ar.this.fXM.showToast(e.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.ad(ar.this.fXM.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, ar.this.fXM.getPageContext().getString(e.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.gfn.setVisibility(8);
                                this.gfo.setVisibility(8);
                            }
                            portrait = b.zG().getPortrait();
                            if (b.zG().getPendantData() == null && !StringUtils.isNull(b.zG().getPendantData().ys())) {
                                this.gfb.b(b.zG());
                                this.gfd.setVisibility(8);
                                this.gfb.setVisibility(0);
                                if (this.gfh != null) {
                                    this.gfh.setVisibility(8);
                                }
                                this.geY.setOnClickListener(this.ghm);
                                this.gfb.getHeadView().startLoad(portrait, 28, false);
                                this.gfb.getHeadView().setUserId(b.zG().getUserId());
                                this.gfb.getHeadView().setUserName(b.zG().getUserName());
                                this.gfb.getHeadView().setTid(b.getId());
                                this.gfb.getHeadView().setFid(this.gbm != null ? this.gbm.getForumId() : "");
                                this.gfb.getHeadView().setOnClickListener(this.ghm);
                                this.gfb.gm(b.zG().getPendantData().ys());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.gfd, b.zG());
                                this.gfd.setVisibility(0);
                                this.geW.setOnClickListener(this.ghm);
                                this.geY.setOnClickListener(this.ghm);
                                this.gfd.setOnClickListener(this.ghm);
                                this.gfb.setVisibility(8);
                                this.gfd.startLoad(portrait, 28, false);
                            }
                            String name_show = b.zG().getName_show();
                            String userName = b.zG().getUserName();
                            if (com.baidu.tbadk.p.an.jJ() && name_show != null && !name_show.equals(userName)) {
                                this.geY.setText(com.baidu.tieba.pb.c.aE(this.fXM.getPageContext().getPageActivity(), this.geY.getText().toString()));
                                this.geY.setGravity(16);
                                this.geY.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bgE());
                                com.baidu.tbadk.core.util.al.c(this.geY, e.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.zG().getIconInfo();
                        tShowInfoNew = b.zG().getTShowInfoNew();
                        if (this.fYX != null) {
                        }
                        if (this.fYW != null) {
                        }
                        this.geY.setText(aE(b.zG().getSealPrefix(), d));
                        this.geY.setTag(e.g.tag_user_id, b.zG().getUserId());
                        this.geY.setTag(e.g.tag_user_name, b.zG().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.geY, e.d.cp_cont_h, 1);
                        this.geZ.setVisibility(8);
                        if (dVar.bgV().zG() != null) {
                            if (dVar.bgV().zG().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.gfd.setUserId(b.zG().getUserId());
                        this.gfd.setUserName(b.zG().getUserName());
                        this.gfd.setTid(b.getId());
                        this.gfd.setFid(this.gbm == null ? this.gbm.getForumId() : "");
                        this.gfd.setImageDrawable(null);
                        this.gfd.setRadius(com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds40));
                        this.gfd.setTag(b.zG().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds16);
                        if (!this.fXM.bhP()) {
                        }
                        this.aKj.setVisibility(8);
                        this.gfp.setVisibility(8);
                        this.gfm.setPadding(0, 0, h, 0);
                        bEm = b.bEm();
                        if (bEm == null) {
                        }
                        this.gfn.setVisibility(8);
                        this.gfo.setVisibility(8);
                        portrait = b.zG().getPortrait();
                        if (b.zG().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.gfd, b.zG());
                        this.gfd.setVisibility(0);
                        this.geW.setOnClickListener(this.ghm);
                        this.geY.setOnClickListener(this.ghm);
                        this.gfd.setOnClickListener(this.ghm);
                        this.gfb.setVisibility(8);
                        this.gfd.startLoad(portrait, 28, false);
                        String name_show2 = b.zG().getName_show();
                        String userName2 = b.zG().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                            this.geY.setText(com.baidu.tieba.pb.c.aE(this.fXM.getPageContext().getPageActivity(), this.geY.getText().toString()));
                            this.geY.setGravity(16);
                            this.geY.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bgE());
                            com.baidu.tbadk.core.util.al.c(this.geY, e.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bz(string) > 14) {
                            d = com.baidu.tbadk.core.util.ao.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.zG().getIconInfo();
                            tShowInfoNew = b.zG().getTShowInfoNew();
                            if (this.fYX != null) {
                            }
                            if (this.fYW != null) {
                            }
                            this.geY.setText(aE(b.zG().getSealPrefix(), d));
                            this.geY.setTag(e.g.tag_user_id, b.zG().getUserId());
                            this.geY.setTag(e.g.tag_user_name, b.zG().getName_show());
                            if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.al.c(this.geY, e.d.cp_cont_h, 1);
                            this.geZ.setVisibility(8);
                            if (dVar.bgV().zG() != null) {
                            }
                            this.gfd.setUserId(b.zG().getUserId());
                            this.gfd.setUserName(b.zG().getUserName());
                            this.gfd.setTid(b.getId());
                            this.gfd.setFid(this.gbm == null ? this.gbm.getForumId() : "");
                            this.gfd.setImageDrawable(null);
                            this.gfd.setRadius(com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds40));
                            this.gfd.setTag(b.zG().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                            }
                            h = com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds16);
                            if (!this.fXM.bhP()) {
                            }
                            this.aKj.setVisibility(8);
                            this.gfp.setVisibility(8);
                            this.gfm.setPadding(0, 0, h, 0);
                            bEm = b.bEm();
                            if (bEm == null) {
                            }
                            this.gfn.setVisibility(8);
                            this.gfo.setVisibility(8);
                            portrait = b.zG().getPortrait();
                            if (b.zG().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.gfd, b.zG());
                            this.gfd.setVisibility(0);
                            this.geW.setOnClickListener(this.ghm);
                            this.geY.setOnClickListener(this.ghm);
                            this.gfd.setOnClickListener(this.ghm);
                            this.gfb.setVisibility(8);
                            this.gfd.startLoad(portrait, 28, false);
                            String name_show22 = b.zG().getName_show();
                            String userName22 = b.zG().getUserName();
                            if (com.baidu.tbadk.p.an.jJ()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.zG().getIconInfo();
                        tShowInfoNew = b.zG().getTShowInfoNew();
                        if (this.fYX != null) {
                        }
                        if (this.fYW != null) {
                        }
                        this.geY.setText(aE(b.zG().getSealPrefix(), d));
                        this.geY.setTag(e.g.tag_user_id, b.zG().getUserId());
                        this.geY.setTag(e.g.tag_user_name, b.zG().getName_show());
                        if (com.baidu.tbadk.core.util.v.I(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.al.c(this.geY, e.d.cp_cont_h, 1);
                        this.geZ.setVisibility(8);
                        if (dVar.bgV().zG() != null) {
                        }
                        this.gfd.setUserId(b.zG().getUserId());
                        this.gfd.setUserName(b.zG().getUserName());
                        this.gfd.setTid(b.getId());
                        this.gfd.setFid(this.gbm == null ? this.gbm.getForumId() : "");
                        this.gfd.setImageDrawable(null);
                        this.gfd.setRadius(com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds40));
                        this.gfd.setTag(b.zG().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), AiAppDateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), AiAppDateTimeUtil.YEAR_FORMAT))) {
                        }
                        h = com.baidu.adp.lib.util.l.h(this.fXM.getActivity(), e.C0210e.ds16);
                        if (!this.fXM.bhP()) {
                        }
                        this.aKj.setVisibility(8);
                        this.gfp.setVisibility(8);
                        this.gfm.setPadding(0, 0, h, 0);
                        bEm = b.bEm();
                        if (bEm == null) {
                        }
                        this.gfn.setVisibility(8);
                        this.gfo.setVisibility(8);
                        portrait = b.zG().getPortrait();
                        if (b.zG().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.gfd, b.zG());
                        this.gfd.setVisibility(0);
                        this.geW.setOnClickListener(this.ghm);
                        this.geY.setOnClickListener(this.ghm);
                        this.gfd.setOnClickListener(this.ghm);
                        this.gfb.setVisibility(8);
                        this.gfd.startLoad(portrait, 28, false);
                        String name_show222 = b.zG().getName_show();
                        String userName222 = b.zG().getUserName();
                        if (com.baidu.tbadk.p.an.jJ()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.geV.ak(dVar.bgV());
                }
                if (this.ggr != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fTw);
                    if (dVar != null && dVar.bgV() != null) {
                        hVar.fTy = dVar.bgV().zx();
                    }
                    hVar.isNew = !this.fYd;
                    hVar.sortType = dVar.fTn;
                    if (dVar.fTm != null && dVar.fTm.size() > dVar.fTn) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= dVar.fTm.size()) {
                                break;
                            } else if (dVar.fTm.get(i4).sort_type.intValue() != dVar.fTn) {
                                i3 = i4 + 1;
                            } else {
                                hVar.fTA = dVar.fTm.get(i4).sort_name;
                                break;
                            }
                        }
                    }
                    hVar.fTB = this.fXM.bjb();
                    this.ggr.a(hVar);
                }
            }
        }
    }

    public void lq(boolean z) {
        if (z) {
            blN();
        } else {
            blO();
        }
        this.ggv.ghE = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ggv));
        a(this.ggv.ghE, false);
    }

    public void blN() {
        if (this.geM != null && !this.ggM) {
            this.geM.lN(!StringUtils.isNull(this.fXM.biA()));
            this.ggM = true;
        }
    }

    public void blO() {
        if (this.geM != null) {
            this.geM.bmY();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.Ac() != null) {
            this.geX.setData(this.fXM.getPageContext(), dVar.bgX().get(0).Ac(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", dVar.bgT().getId(), dVar.bgT().getName(), dVar.bgV().getId(), this.fXM.biY() ? "FRS" : null));
            this.geW.setPadding(this.geW.getPaddingLeft(), (int) this.fXM.getResources().getDimension(e.C0210e.ds20), this.geW.getPaddingRight(), this.geW.getPaddingBottom());
            return;
        }
        this.geX.setData(null, null, null);
    }

    public void blP() {
        if (this.geG != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11997").x("obj_type", 1));
            this.geG.bog();
            this.geQ.smoothScrollToPosition(0);
        }
    }

    public boolean blQ() {
        return this.ghn;
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
            this.geM.bmW();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.geM.qX(cVar.forumName);
            }
            String string = this.fXM.getResources().getString(e.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.l(cVar.source, 0)) {
                case 100:
                    str = this.fXM.getResources().getString(e.j.self);
                    break;
                case 300:
                    str = this.fXM.getResources().getString(e.j.bawu);
                    break;
                case 400:
                    str = this.fXM.getResources().getString(e.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fSE;
            this.fXM.showNetRefreshView(this.drh, format, null, this.fXM.getResources().getString(e.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.ll()) {
                        ay.Ef().c(ar.this.fXM.getPageContext(), new String[]{str2});
                        ar.this.fXM.finish();
                        return;
                    }
                    ar.this.fXM.showToast(e.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bkY;
        Parcelable bkY2;
        String str;
        if (dVar != null) {
            this.gbm = dVar;
            this.mType = i;
            if (dVar.bgV() != null) {
                this.ggx = dVar.bgV().zp();
                if (dVar.bgV().getAnchorLevel() != 0) {
                    this.ghn = true;
                }
                this.gfT = am(dVar.bgV());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.ggh = false;
            this.fYd = z;
            blJ();
            b(dVar, z, i);
            p(dVar);
            if (this.ggZ == null) {
                this.ggZ = new ac(this.fXM.getPageContext(), this.alo);
            }
            this.ggZ.tc(dVar.bha());
            if (this.fXM.biP()) {
                if (this.gfB == null) {
                    this.gfB = new com.baidu.tieba.pb.view.d(this.fXM.getPageContext());
                    this.gfB.oD();
                    this.gfB.a(this.aIF);
                }
                this.geQ.setPullRefresh(this.gfB);
                blR();
                if (this.gfB != null) {
                    this.gfB.ey(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.yS().yQ() == 0 && z) {
                this.geQ.setPullRefresh(null);
            } else {
                if (this.gfB == null) {
                    this.gfB = new com.baidu.tieba.pb.view.d(this.fXM.getPageContext());
                    this.gfB.oD();
                    this.gfB.a(this.aIF);
                }
                this.geQ.setPullRefresh(this.gfB);
                blR();
                if (this.gfB != null) {
                    this.gfB.ey(TbadkCoreApplication.getInst().getSkinType());
                }
                aln();
            }
            blU();
            this.gfx.kD(this.fYd);
            this.gfx.kE(false);
            this.gfx.kP(i == 5);
            this.gfx.kQ(i == 6);
            this.gfx.kR(z2 && this.ghl);
            this.gfx.a(dVar, false);
            this.gfx.notifyDataSetChanged();
            if (this.fXM.bhP()) {
                this.ggO = 0;
                PostData b = b(dVar, z);
                if (b != null && b.zG() != null) {
                    this.ggO = b.zG().getLevel_id();
                }
                if (this.ggO > 0) {
                    this.gfa.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.gfa, BitmapHelper.getGradeResourceIdInEnterForum(this.ggO));
                } else {
                    this.gfa.setVisibility(8);
                }
            } else {
                this.gfa.setVisibility(8);
            }
            if (dVar.bgV() != null) {
                if (dVar.bgV().zt() != null) {
                    if (dVar.bgV().zt().getNum() < 1) {
                        str = this.fXM.getResources().getString(e.j.zan);
                    } else {
                        str = dVar.bgV().zt().getNum() + "";
                    }
                    if (this.geF != -1) {
                        dVar.bgV().zt().setIsLike(this.geF);
                    }
                    W(str, dVar.bgV().zt().getIsLike() == 1);
                }
                if (dVar.bgV().avt != null && dVar.bgV().avt.isDeleted) {
                    this.geM.lH(true);
                } else {
                    this.geM.lH(false);
                }
            }
            if (this.fXM.isLogin()) {
                this.geQ.setNextPage(this.dQs);
                this.geL = 2;
                aln();
            } else {
                this.ggh = true;
                if (dVar.yS().yP() == 1) {
                    if (this.gfC == null) {
                        this.gfC = new com.baidu.tieba.pb.view.a(this.fXM.getPageContext());
                    }
                    this.geQ.setNextPage(this.gfC);
                } else {
                    this.geQ.setNextPage(this.dQs);
                }
                this.geL = 3;
            }
            ArrayList<PostData> bgX = dVar.bgX();
            if (dVar.yS().yP() == 0 || bgX == null || bgX.size() < dVar.yS().yO()) {
                if (com.baidu.tbadk.core.util.v.H(bgX) == 0 || (com.baidu.tbadk.core.util.v.H(bgX) == 1 && bgX.get(0) != null && bgX.get(0).bEj() == 1)) {
                    this.dQs.setText(this.fXM.getResources().getString(e.j.list_no_more_new));
                    if (this.fXM.bip() != null && !this.fXM.bip().bmM()) {
                        this.fXM.bip().showFloatingView();
                    }
                } else if (dVar.yS().yP() == 0) {
                    this.dQs.setText(this.fXM.getResources().getString(e.j.list_has_no_more));
                } else {
                    this.dQs.setText(this.fXM.getResources().getString(e.j.load_more));
                }
                if (this.fXM.biP() && this.geQ != null && this.geQ.getData() != null && this.geQ.getData().size() == 1 && (this.geQ.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dQs.setText("");
                }
                bmb();
            } else if (z2) {
                if (this.ghl) {
                    Fd();
                    if (dVar.yS().yP() != 0) {
                        this.dQs.setText(this.fXM.getResources().getString(e.j.pb_load_more));
                    }
                } else {
                    this.dQs.EY();
                    this.dQs.showLoading();
                }
            } else {
                this.dQs.EY();
                this.dQs.showLoading();
            }
            switch (i) {
                case 2:
                    this.geQ.setSelection(i2 > 1 ? (((this.geQ.getData() == null && dVar.bgX() == null) ? 0 : (this.geQ.getData().size() - dVar.bgX().size()) + this.geQ.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bkY2 = aj.bkX().bkY()) != null) {
                        this.geQ.onRestoreInstanceState(bkY2);
                        if (com.baidu.tbadk.core.util.v.H(bgX) > 1 && dVar.yS().yP() > 0) {
                            this.dQs.Fd();
                            this.dQs.setText(this.fXM.getString(e.j.pb_load_more_without_point));
                            this.dQs.EZ();
                            break;
                        }
                    } else {
                        this.geQ.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.ghl = false;
                    break;
                case 5:
                    this.geQ.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bkY = aj.bkX().bkY()) != null) {
                        this.geQ.onRestoreInstanceState(bkY);
                        break;
                    } else {
                        this.geQ.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.geG != null && this.geG.bof() != null) {
                            if (this.fXM.isUseStyleImmersiveSticky()) {
                                this.geQ.setSelectionFromTop((this.gfx.bju() + this.geQ.getHeaderViewsCount()) - 1, this.geG.bof().getHeight() - com.baidu.adp.lib.util.l.r(this.fXM.getPageContext().getPageActivity()));
                            } else {
                                this.geQ.setSelectionFromTop((this.gfx.bju() + this.geQ.getHeaderViewsCount()) - 1, this.geG.bof().getHeight());
                            }
                        } else {
                            this.geQ.setSelection(this.gfx.bju() + this.geQ.getHeaderViewsCount());
                        }
                    } else {
                        this.geQ.setSelection(i2 > 0 ? ((this.geQ.getData() == null && dVar.bgX() == null) ? 0 : (this.geQ.getData().size() - dVar.bgX().size()) + this.geQ.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dQs.Fd();
                    this.dQs.setText(this.fXM.getString(e.j.pb_load_more_without_point));
                    this.dQs.EZ();
                    break;
            }
            if (this.ggx == ggy && isHost()) {
                bmj();
            }
            if (this.ggI) {
                blh();
                this.ggI = false;
                if (i3 == 0) {
                    lj(true);
                }
            }
            if (this.geI != null) {
                this.geI.ar(dVar.bgV());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fTk == 1 || dVar.fTl == 1) {
                if (this.ggP == null) {
                    this.ggP = new PbTopTipView(this.fXM);
                }
                if (dVar.fTl == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fXM.getStType())) {
                    this.ggP.setText(this.fXM.getString(e.j.pb_read_strategy_add_experience));
                    this.ggP.show(this.drh, this.mSkinType);
                } else if (dVar.fTk == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fXM.getStType())) {
                    this.ggP.setText(this.fXM.getString(e.j.pb_read_news_add_experience));
                    this.ggP.show(this.drh, this.mSkinType);
                }
            }
        }
    }

    private void blR() {
        if (this.geG != null && this.geG.bof() != null) {
            this.geQ.removeHeaderView(this.aiY);
            if (this.mType != 1) {
                this.geQ.removeHeaderView(this.geG.boi());
                this.geQ.addHeaderView(this.geG.boi(), 0);
                return;
            }
            return;
        }
        if (this.geG != null) {
            this.geQ.removeHeaderView(this.geG.boi());
        }
        this.geQ.removeHeaderView(this.aiY);
        this.geQ.addHeaderView(this.aiY, 0);
    }

    public void lr(boolean z) {
        this.gfS = z;
    }

    public void Fd() {
        if (this.dQs != null) {
            this.dQs.EZ();
            this.dQs.Fd();
        }
        aln();
    }

    public void anp() {
        this.geQ.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.ggg != null && this.ggg.zG() != null && this.geM != null) {
            this.ggL = !this.ggK;
            this.geM.lG(this.ggL);
            if (this.fXM.bip() != null) {
                this.fXM.bip().lF(this.ggL);
            }
            blS();
            if (this.ggL) {
                this.geM.gjS.setVisibility(0);
                if (this.gfT) {
                    this.geM.gjT.setVisibility(8);
                    this.gfi.setVisibility(8);
                    this.gfl.setVisibility(0);
                    this.gfl.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.T(dVar.bhs())));
                } else if (!PbNormalLikeButtonSwitchStatic.PE() || (this.ggg.zG().hadConcerned() && this.ggg.zG().getGodUserData() != null && this.ggg.zG().getGodUserData().getIsFromNetWork())) {
                    this.geM.gjT.setVisibility(8);
                }
                if (this.ggq != null) {
                    this.ggq.setVisibility(8);
                }
                this.geM.a(this.ggg.zG(), this.ghm);
                if (this.ggX == null) {
                    this.ggX = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.ggN) {
                                ar.this.bmi();
                            }
                            ar.this.blK();
                        }
                    };
                }
                this.geQ.setListViewDragListener(this.ggX);
                return;
            }
            if (this.geM.gjS != null) {
                this.geM.gjS.setVisibility(8);
            }
            if (this.ggq != null) {
                this.ggq.setVisibility(0);
            }
            if (this.gfT) {
                this.gfi.setVisibility(8);
                this.gfl.setVisibility(0);
                this.gfl.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.person_view_num), com.baidu.tbadk.core.util.ao.T(dVar.bhs())));
            } else if (!PbNormalLikeButtonSwitchStatic.PE() || (this.ggg.zG().hadConcerned() && this.ggg.zG().getGodUserData() != null && this.ggg.zG().getGodUserData().getIsFromNetWork())) {
                this.gfi.setVisibility(8);
                this.gfl.setVisibility(8);
            } else {
                this.gfl.setVisibility(8);
            }
            this.ggX = null;
            this.geQ.setListViewDragListener(null);
        }
    }

    private void blS() {
        String threadId = this.gbm != null ? this.gbm.getThreadId() : "";
        int blT = blT();
        if (this.ggL) {
            if (this.gfk == null) {
                this.gfk = new ap(this.fXM.getPageContext(), this.geM.gjT, 3);
                this.gfk.h(this.fXM.getUniqueId());
            }
            if (this.ggg != null && this.ggg.zG() != null) {
                this.ggg.zG().setIsLike(this.ggg.zG().hadConcerned());
                this.gfk.a(this.ggg.zG());
            }
            this.gfk.setTid(threadId);
            this.gfk.sK(blT);
            this.gfk.geB = this.ggK;
        }
        if (this.gfj == null) {
            this.gfj = new ap(this.fXM.getPageContext(), this.gfi, 1);
            this.gfj.h(this.fXM.getUniqueId());
            this.gfj.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bL(boolean z) {
                    if (ar.this.fXM != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.fXM, e.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.fXM.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.ggg != null && this.ggg.zG() != null) {
            this.ggg.zG().setIsLike(this.ggg.zG().hadConcerned());
            this.gfj.a(this.ggg.zG());
            this.gfj.setTid(threadId);
        }
        this.gfj.geB = this.ggK;
        this.gfj.sK(blT);
    }

    public int blT() {
        if (this.gbm == null || this.gbm.bgV() == null) {
            return 0;
        }
        if (this.gbm.bgV().AR()) {
            return (com.baidu.tbadk.core.util.v.I(this.gbm.bhr()) && (this.gbm.bgU() == null || StringUtils.isNull(this.gbm.bgU().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean blU() {
        boolean z;
        if (this.gfW != null && this.gfW.getVisibility() == 0) {
            if (this.gft != null) {
                this.gft.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.gft != null) {
                this.gft.setVisibility(8);
            }
            z = false;
        }
        if ((this.gfv == null || this.gfv.getVisibility() == 8) && z && this.fYd) {
            this.gfu.setVisibility(0);
        } else {
            this.gfu.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bgV() == null) {
            return false;
        }
        if (dVar.bgV().zD() == 1 || dVar.bgV().getThreadType() == 33) {
            return true;
        }
        return !(dVar.bgV().zF() == null || dVar.bgV().zF().Bt() == 0) || dVar.bgV().zB() == 1 || dVar.bgV().zC() == 1 || dVar.bgV().Al() || dVar.bgV().Ay() || dVar.bgV().At() || dVar.bgV().zT() != null || !com.baidu.tbadk.core.util.ao.isEmpty(dVar.bgV().getCategory()) || dVar.bgV().zJ() || dVar.bgV().zI();
    }

    private SpannableStringBuilder aE(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fXM.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.geS != null) {
                if (dVar.bgV() != null && dVar.bgV().zW() == 0 && !dVar.bgV().Au() && !this.ghb) {
                    this.geS.setVisibility(0);
                    if (dVar.bgV() != null) {
                        bb bgV = dVar.bgV();
                        bgV.g(true, q(dVar));
                        bgV.setResource(3);
                        bgV.el("2");
                    }
                    SpannableStringBuilder Ag = dVar.bgV().Ag();
                    this.geT.setOnTouchListener(new com.baidu.tieba.view.k(Ag));
                    this.geT.setText(Ag);
                    this.geT.setVisibility(0);
                } else if (dVar.bgV().zW() == 1) {
                    if (dVar.bgV() != null) {
                        this.geS.setVisibility(8);
                        this.geQ.removeHeaderView(this.geS);
                        if (dVar.bgV() != null && !dVar.bgV().Au()) {
                            this.geW.setPadding(this.geW.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.tbds36), this.geW.getPaddingRight(), this.geW.getPaddingBottom());
                        }
                    }
                } else {
                    this.geS.setVisibility(8);
                    this.geQ.removeHeaderView(this.geS);
                    if (dVar.bgV() != null && dVar.bgV().Au()) {
                        this.geW.setPadding(this.geW.getPaddingLeft(), 0, this.geW.getPaddingRight(), this.geW.getPaddingBottom());
                    } else {
                        this.geW.setPadding(this.geW.getPaddingLeft(), com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds48), this.geW.getPaddingRight(), this.geW.getPaddingBottom());
                    }
                }
            }
            this.fYd = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            blU();
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
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bhh()));
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
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(dVar.bhh()));
                sparseArray.put(e.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.ay> bhr = dVar.bhr();
                if (com.baidu.tbadk.core.util.v.H(bhr) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.ay ayVar : bhr) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ata) != null && tVar.ara && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.o(ayVar.getForumName(), 12)).append(this.fXM.getString(e.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(e.g.tag_del_multi_forum, String.format(this.fXM.getString(e.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bfk;
    }

    public void td(String str) {
        if (this.dQs != null) {
            this.dQs.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.geQ;
    }

    public int blV() {
        return e.g.richText;
    }

    public TextView bik() {
        return this.geV.bik();
    }

    public void e(BdListView.e eVar) {
        this.geQ.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.aIF = bVar;
        if (this.gfB != null) {
            this.gfB.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int yN = alVar.yN();
            int yK = alVar.yK();
            if (this.gfy != null) {
                this.gfy.BF();
            } else {
                this.gfy = new com.baidu.tbadk.core.dialog.a(this.fXM.getPageContext().getPageActivity());
                this.gfz = LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.dialog_direct_pager, (ViewGroup) null);
                this.gfy.G(this.gfz);
                this.gfy.a(e.j.dialog_ok, bVar);
                this.gfy.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.blX();
                        aVar.dismiss();
                    }
                });
                this.gfy.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.ggF == null) {
                            ar.this.ggF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.fXM.HidenSoftKeyPad((InputMethodManager) ar.this.fXM.getSystemService("input_method"), ar.this.drh);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.jG().postDelayed(ar.this.ggF, 150L);
                    }
                });
                this.gfy.b(this.fXM.getPageContext()).BF();
            }
            this.gfA = (EditText) this.gfz.findViewById(e.g.input_page_number);
            this.gfA.setText("");
            TextView textView = (TextView) this.gfz.findViewById(e.g.current_page_number);
            if (yN <= 0) {
                yN = 1;
            }
            if (yK <= 0) {
                yK = 1;
            }
            textView.setText(MessageFormat.format(this.fXM.getApplicationContext().getResources().getString(e.j.current_page), Integer.valueOf(yN), Integer.valueOf(yK)));
            this.fXM.ShowSoftKeyPadDelay(this.gfA, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.geQ.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fXM.showToast(str);
    }

    public boolean ls(boolean z) {
        if (this.Ta == null || !this.Ta.Mb()) {
            return false;
        }
        this.Ta.Kx();
        return true;
    }

    public void blW() {
        if (this.gho != null) {
            while (this.gho.size() > 0) {
                TbImageView remove = this.gho.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        blW();
        this.gfx.sv(1);
        if (this.geG != null) {
            this.geG.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.gfx.sv(2);
        if (this.geG != null) {
            this.geG.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.ggH != null) {
            this.ggH.destroy();
        }
        if (this.ggZ != null) {
            this.ggZ.onDestory();
        }
        if (this.ggP != null) {
            this.ggP.hide();
        }
        if (this.geJ != null) {
            this.geJ.asb();
        }
        if (this.geI != null) {
            this.geI.onDestroy();
        }
        this.fXM.hideProgressBar();
        if (this.drf != null && this.dID != null) {
            this.drf.b(this.dID);
        }
        blX();
        Fd();
        if (this.ggF != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ggF);
        }
        if (this.geW != null && this.gfh != null) {
            this.geW.removeView(this.gfc);
            this.gfh = null;
        }
        if (this.ggl != null) {
            this.ggl.clearStatus();
        }
        this.ghh = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.gfx.sv(3);
        if (this.dMX != null) {
            this.dMX.setBackgroundDrawable(null);
        }
        if (this.geG != null) {
            this.geG.destroy();
        }
        if (this.gfx != null) {
            this.gfx.onDestroy();
        }
        this.geQ.setOnLayoutListener(null);
        if (this.ggV != null) {
            this.ggV.aDS();
        }
        if (this.ggw != null) {
            this.ggw.onDestroy();
        }
        bmt();
    }

    public boolean sN(int i) {
        if (this.geG != null) {
            return this.geG.mH(i);
        }
        return false;
    }

    public void blX() {
        this.geM.dismissPopMenu();
        if (this.geJ != null) {
            this.geJ.asb();
        }
        com.baidu.adp.lib.util.l.b(this.fXM.getPageContext().getPageActivity(), this.gfA);
        blj();
        if (this.gfQ != null) {
            this.gfQ.dismiss();
        }
        blZ();
        if (this.geI != null) {
            this.geI.bnY();
        }
        if (this.gfy != null) {
            this.gfy.dismiss();
        }
        if (this.dMH != null) {
            this.dMH.dismiss();
        }
    }

    public void blY() {
        this.geM.dismissPopMenu();
        if (this.geJ != null) {
            this.geJ.asb();
        }
        if (this.gfQ != null) {
            this.gfQ.dismiss();
        }
        blZ();
        if (this.geI != null) {
            this.geI.bnY();
        }
        if (this.gfy != null) {
            this.gfy.dismiss();
        }
        if (this.dMH != null) {
            this.dMH.dismiss();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m20do(List<String> list) {
        this.ggU = list;
        if (this.ggV != null) {
            this.ggV.setData(list);
        }
    }

    public void kC(boolean z) {
        this.gfx.kC(z);
    }

    public void lt(boolean z) {
        this.gfV = z;
    }

    public void blZ() {
        if (this.gfH != null) {
            this.gfH.dismiss();
        }
        if (this.gfI != null) {
            com.baidu.adp.lib.g.g.b(this.gfI, this.fXM.getPageContext());
        }
        if (this.gfJ != null) {
            com.baidu.adp.lib.g.g.b(this.gfJ, this.fXM.getPageContext());
        }
        if (this.gfF != null) {
            com.baidu.adp.lib.g.g.b(this.gfF, this.fXM.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.gbm, this.fYd);
            d(this.gbm, this.fYd, this.mType);
            this.fXM.getLayoutMode().setNightMode(i == 1);
            this.fXM.getLayoutMode().onModeChanged(this.drh);
            this.fXM.getLayoutMode().onModeChanged(this.geR);
            if (this.geI != null) {
                this.geI.onChangeSkinType(i);
            }
            if (this.geT != null) {
                com.baidu.tbadk.core.util.al.h(this.geT, e.d.cp_cont_b);
                this.geT.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_link_tip_c));
            }
            if (this.dQs != null) {
                this.dQs.ey(i);
                if (this.bfk != null) {
                    this.fXM.getLayoutMode().onModeChanged(this.bfk);
                    com.baidu.tbadk.core.util.al.i(this.bfk, e.f.pb_foot_more_trans_selector);
                }
            }
            if (this.gfy != null) {
                this.gfy.c(this.fXM.getPageContext());
            }
            lr(this.gfS);
            this.gfx.notifyDataSetChanged();
            if (this.gfB != null) {
                this.gfB.ey(i);
            }
            if (this.Ta != null) {
                this.Ta.onChangeSkinType(i);
            }
            if (this.gfg != null) {
                this.gfg.eD(i);
            }
            if (this.gfC != null) {
                this.gfC.ey(i);
            }
            if (!com.baidu.tbadk.core.util.v.I(this.cZW)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cZW) {
                    customBlueCheckRadioButton.EI();
                }
            }
            ln(i == 1);
            bly();
            UtilHelper.setStatusBarBackground(this.dMX, i);
            UtilHelper.setStatusBarBackground(this.ggq, i);
            if (this.gfi != null) {
                this.gfi.onChangeSkinType(i);
            }
            if (this.gfn != null) {
                com.baidu.tbadk.core.util.al.h(this.gfn, e.d.cp_cont_d);
            }
            if (this.gfm != null) {
                com.baidu.tbadk.core.util.al.h(this.gfm, e.d.cp_cont_d);
            }
            if (this.gfo != null) {
                com.baidu.tbadk.core.util.al.i(this.gfo, e.d.cp_cont_e);
            }
            if (this.aKj != null) {
                com.baidu.tbadk.core.util.al.h(this.aKj, e.d.cp_cont_d);
            }
            if (this.gfp != null) {
                com.baidu.tbadk.core.util.al.i(this.gfp, e.d.cp_cont_e);
            }
            if (this.geZ != null) {
                com.baidu.tbadk.core.util.al.h(this.geZ, e.d.cp_link_tip_a);
            }
            if (this.gfl != null) {
                com.baidu.tbadk.core.util.al.h(this.gfl, e.d.cp_cont_d);
            }
            if (this.gfq != null) {
                com.baidu.tbadk.o.a.a(this.fXM.getPageContext(), this.gfq);
            }
            if (this.gfO != null) {
                com.baidu.tbadk.o.a.a(this.fXM.getPageContext(), this.gfO);
            }
            if (this.ggG != null) {
                this.ggG.onChangeSkinType(i);
            }
            if (this.geM != null) {
                if (this.geG != null) {
                    this.geG.sS(i);
                } else {
                    this.geM.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.gfY != null) {
                com.baidu.tbadk.core.util.al.h(this.gfY, e.d.cp_cont_e);
            }
            if (this.gfa != null) {
                com.baidu.tbadk.core.util.al.c(this.gfa, BitmapHelper.getGradeResourceIdInEnterForum(this.ggO));
            }
            if (this.ggW != null) {
                this.ggW.onChangeSkinType(i);
            }
            if (this.ggw != null) {
                this.ggw.onChangeSkinType();
            }
            if (this.ggS != null) {
                com.baidu.tbadk.core.util.al.h(this.ggS, e.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brP = hVar;
        this.gfx.setOnImageClickListener(this.brP);
        this.ggW.setOnImageClickListener(this.brP);
    }

    public void h(NoNetworkView.a aVar) {
        this.dID = aVar;
        if (this.drf != null) {
            this.drf.a(this.dID);
        }
    }

    public void lu(boolean z) {
        this.gfx.setIsFromCDN(z);
    }

    public Button bma() {
        return this.gfW;
    }

    public void bmb() {
        if (this.geL != 2) {
            this.geQ.setNextPage(this.dQs);
            this.geL = 2;
        }
    }

    public void bmc() {
        if (com.baidu.tbadk.l.m.Pl().Pm()) {
            int lastVisiblePosition = this.geQ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.geQ.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(e.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.gj(1001);
                                perfLog.bfP = true;
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
                        perfLog2.bfP = true;
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

    public boolean bmd() {
        return this.Ta != null && this.Ta.getVisibility() == 0;
    }

    public boolean bme() {
        return this.Ta != null && this.Ta.Mb();
    }

    public void bmf() {
        if (this.Ta != null) {
            this.Ta.Kx();
        }
    }

    public void lv(boolean z) {
        if (this.gfX != null) {
            lt(this.fXM.bil().ME());
            if (this.gfV) {
                lk(z);
            } else {
                ll(z);
            }
        }
    }

    public void bmg() {
        if (this.gfX != null) {
            this.gfX.setVisibility(8);
            this.ggc = false;
            if (this.ggw != null) {
                this.ggw.setVisibility(8);
                lp(false);
            }
            bmt();
        }
    }

    public void showLoadingDialog() {
        if (this.dhu == null) {
            this.dhu = new com.baidu.tbadk.core.view.d(this.fXM.getPageContext());
        }
        this.dhu.bA(true);
    }

    public void aln() {
        if (this.dhu != null) {
            this.dhu.bA(false);
        }
    }

    private int getScrollY() {
        View childAt = this.geQ.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.geQ.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.geG != null) {
            this.geG.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.ghp = getScrollY();
            this.ggv.ghE = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ggv));
            a(this.ggv.ghE, true);
        }
    }

    public void lw(boolean z) {
        this.geG.lw(z);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.geG != null) {
            this.geG.b(absListView, i);
        }
        int headerViewsCount = (i - this.geQ.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (headerViewsCount <= i2 && this.gfx.su(headerViewsCount) != com.baidu.tieba.pb.data.i.fTC) {
            headerViewsCount++;
        }
        boolean z = i < this.geQ.getHeaderViewsCount();
        if (this.geU != null && this.geM != null) {
            this.geM.h(this.geU.getBottom(), this.geU.getMeasuredHeight(), z);
        }
        this.ggv.fOj = i;
        this.ggv.headerCount = this.geQ.getHeaderViewsCount();
        this.ggv.ghE = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.ggv));
        a(this.ggv.ghE, false);
    }

    public void bmh() {
        if (this.fXM.isLogin() && this.gbm != null && this.ggL && !this.ggK && !this.gfT && this.ggg != null && this.ggg.zG() != null && !this.ggg.zG().getIsLike() && !this.ggg.zG().hadConcerned()) {
            if (this.ggH == null) {
                this.ggH = new an(this.fXM);
            }
            this.ggH.a(this.geM.gjS, this.gbm.bhv(), this.ggg.zG().getUserId(), this.gbm.getThreadId());
        }
    }

    public void bmi() {
        if (this.ggL && !this.ggK && this.ggg != null && this.ggg.zG() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12601").x("obj_locate", this.fXM.bhP() ? 2 : 1).x("obj_type", this.ggK ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fXM.getPageContext().getPageActivity(), this.ggg.zG().getUserId(), this.ggg.zG().getUserName(), this.fXM.bhZ().bhQ(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.ggK && this.ggp != null && this.geM.bmR() != null) {
            int bjv = this.gfx.bjv();
            if (bjv > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bjv > this.geQ.getFirstVisiblePosition() - this.geQ.getHeaderViewsCount()) {
                    this.ggp.setVisibility(8);
                    return;
                }
                this.ggp.setVisibility(0);
                bms();
                this.geM.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.gee == null) {
                if (this.geQ.getFirstVisiblePosition() == 0) {
                    this.ggp.setVisibility(8);
                    this.geM.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.ggu) {
                        this.ggt = top;
                        this.ggu = false;
                    }
                    this.ggt = top < this.ggt ? top : this.ggt;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.gfw.getY() < 0.0f) {
                        measuredHeight = ggs - alVar.gee.getMeasuredHeight();
                    } else {
                        measuredHeight = this.geM.bmR().getMeasuredHeight() - alVar.gee.getMeasuredHeight();
                        this.geM.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.ggt) {
                        this.ggp.setVisibility(0);
                        bms();
                    } else if (top < measuredHeight) {
                        this.ggp.setVisibility(0);
                        bms();
                    } else {
                        this.ggp.setVisibility(8);
                        this.geM.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.ggu = true;
                    }
                }
            }
        }
    }

    public void bmj() {
        if (!this.ghq) {
            TiebaStatic.log("c10490");
            this.ghq = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fXM.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(ggz, Integer.valueOf(ggB));
            aVar.da(e.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.function_description_view)).setText(e.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(e.g.title_view)).setText(e.j.grade_thread_tips);
            aVar.G(inflate);
            aVar.H(sparseArray);
            aVar.a(e.j.grade_button_tips, this.fXM);
            aVar.b(e.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fXM.getPageContext()).BF();
        }
    }

    public void te(String str) {
        if (str.contains(BaseRequestAction.SPLITE)) {
            str = str.replace(BaseRequestAction.SPLITE, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fXM.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(e.g.function_description_view)).setVisibility(8);
        aVar.G(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(ggz, Integer.valueOf(ggC));
        aVar.H(sparseArray);
        aVar.a(e.j.view, this.fXM);
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fXM.getPageContext()).BF();
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

    public PbInterviewStatusView bmk() {
        return this.ggl;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bgV() != null && dVar.bgV().Ay() && this.ggl == null) {
            this.ggl = (PbInterviewStatusView) this.ggk.inflate();
            this.ggl.setOnClickListener(this.dMI);
            this.ggl.setCallback(this.fXM.biX());
            this.ggl.setData(this.fXM, dVar);
        }
    }

    public LinearLayout bml() {
        return this.gfw;
    }

    public View bmm() {
        return this.dMX;
    }

    public boolean bmn() {
        return this.ghb;
    }

    public void kH(boolean z) {
        this.geV.kH(z);
    }

    public void tf(String str) {
        if (this.geN != null) {
            this.geN.setTitle(str);
        }
    }

    private int lx(boolean z) {
        if (this.ggl == null || this.ggl.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds72);
    }

    private void bmo() {
        if (this.ggl != null && this.ggl.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ggl.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.ggl.setLayoutParams(layoutParams);
        }
    }

    public boolean bir() {
        return false;
    }

    public void tg(String str) {
        this.gfY.performClick();
        if (!StringUtils.isNull(str) && this.fXM.bil() != null && this.fXM.bil().Mx() != null && this.fXM.bil().Mx().getInputView() != null) {
            EditText inputView = this.fXM.bil().Mx().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            blX();
            if (configuration.orientation == 2) {
                bmg();
                blj();
            } else {
                blm();
            }
            if (this.ggG != null) {
                this.ggG.bjC();
            }
            this.fXM.aBN();
            this.gfw.setVisibility(8);
            this.geM.lJ(false);
            this.fXM.kN(false);
            if (this.geG != null) {
                if (configuration.orientation == 1) {
                    bml().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.geQ.setIsLandscape(true);
                    this.geQ.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.geQ.setIsLandscape(false);
                    if (this.ghp > 0) {
                        this.geQ.smoothScrollBy(this.ghp, 0);
                    }
                }
                this.geG.onConfigurationChanged(configuration);
                this.ggo.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void ly(boolean z) {
        this.geK = z;
    }

    public boolean bmp() {
        return this.geG != null && this.geG.bmp();
    }

    public void bmq() {
        if (this.geG != null) {
            this.geG.onPause();
        }
    }

    public void n(long j, int i) {
        if (this.geI != null) {
            this.geI.n(j, i);
        }
        if (this.geG != null) {
            this.geG.n(j, i);
        }
    }

    public void kS(boolean z) {
        this.gfx.kS(z);
    }

    public void bmr() {
        if (this.ggm == null) {
            LayoutInflater.from(this.fXM.getActivity()).inflate(e.h.add_experienced_text, (ViewGroup) this.drh, true);
            this.ggm = (ViewGroup) this.drh.findViewById(e.g.add_experienced_layout);
            this.ggn = (TextView) this.drh.findViewById(e.g.add_experienced);
            com.baidu.tbadk.core.util.al.h(this.ggn, e.d.cp_cont_i);
            String string = this.fXM.getResources().getString(e.j.experienced_add_success);
            String string2 = this.fXM.getResources().getString(e.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_h)));
            this.ggn.setText(spannableString);
        }
        this.ggm.setVisibility(0);
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
                        ar.this.ggm.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.ggn.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.ggn.startAnimation(scaleAnimation);
    }

    public void bG(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.gfX.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fXM);
            frameLayout.setBackgroundResource(e.f.pic_sign_tip);
            this.ggS = new TextView(this.fXM);
            this.ggS.setText(e.j.connection_tips);
            this.ggS.setGravity(17);
            this.ggS.setPadding(com.baidu.adp.lib.util.l.h(this.fXM, e.C0210e.ds24), 0, com.baidu.adp.lib.util.l.h(this.fXM, e.C0210e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.h(this.fXM, e.C0210e.ds60);
            if (this.ggS.getParent() == null) {
                frameLayout.addView(this.ggS, layoutParams);
            }
            this.ggR = new PopupWindow(this.fXM);
            this.ggR.setContentView(frameLayout);
            this.ggR.setHeight(-2);
            this.ggR.setWidth(-2);
            this.ggR.setFocusable(true);
            this.ggR.setOutsideTouchable(false);
            this.ggR.setBackgroundDrawable(new ColorDrawable(this.fXM.getResources().getColor(e.d.transparent)));
            this.geQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.ggR.showAsDropDown(ar.this.gfX, view.getLeft(), -ar.this.gfX.getHeight());
                    } else {
                        ar.this.ggR.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void bms() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_tips", false) && this.ggT == null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_tips", true);
            this.ggT = new com.baidu.tbadk.core.dialog.a(this.fXM);
            PbLongPressTipView pbLongPressTipView = new PbLongPressTipView(this.fXM);
            this.ggT.dd(1);
            this.ggT.G(pbLongPressTipView);
            this.ggT.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.31
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ggT.bg(false);
            this.ggT.b(this.fXM.getPageContext()).BF();
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.32
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.ggT != null && ar.this.ggT.isShowing()) {
                        ar.this.ggT.dismiss();
                    }
                }
            }, 5000L);
            if (this.geG != null) {
                this.geG.boh();
            }
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.bmI() != null && !StringUtils.isNull(aVar.bmI().pkg_id) && !StringUtils.isNull(aVar.bmI().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.gfZ != null && this.gfZ.getVisibility() == 0) {
            if (this.ggQ == null) {
                View inflate = LayoutInflater.from(this.fXM.getPageContext().getPageActivity()).inflate(e.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(e.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(e.g.single_bar_tips);
                textView.setText(e.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dMI);
                this.ggQ = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.gfZ.getLocationInWindow(iArr);
            this.ggQ.showAtLocation(this.gfZ, 0, iArr[0] - com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds54), (iArr[1] - this.gfZ.getHeight()) - com.baidu.adp.lib.util.l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bmt() {
        com.baidu.adp.lib.g.g.a(this.ggQ);
    }

    public void lz(boolean z) {
        this.ggY = z;
    }

    public boolean bmu() {
        return this.ggY;
    }

    public void bH(View view) {
        this.gfO = view;
    }
}
