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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.e;
import com.baidu.tieba.pb.pb.main.emotion.b.a;
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
    private static final int fRN = UtilHelper.getLightStatusBarHeight();
    public static int fRT = 3;
    public static int fRU = 0;
    public static int fRV = 3;
    public static int fRW = 4;
    public static int fRX = 5;
    public static int fRY = 6;
    private com.baidu.tbadk.editortools.i axN;
    private com.baidu.tieba.pb.a.c bJG;
    private j.b baR;
    private TextView bcz;
    private TextView bmp;
    private View bxf;
    private List<com.baidu.tieba.pb.pb.main.view.a> cWg;
    private View.OnClickListener dCL;
    private View dCY;
    private PbListView dFN;
    private NavigationBarCoverTip dSo;
    private View dar;
    private NoNetworkView dmi;
    private RelativeLayout dmk;
    private View.OnClickListener fFa;
    PbActivity.d fIB;
    private PbActivity fJw;
    private UserIconBox fKD;
    private UserIconBox fKE;
    private PbFakeFloorModel fLA;
    private com.baidu.tieba.pb.data.f fMG;
    private FloatingLayout fQA;
    private PbFirstFloorUserLikeButton fQD;
    private aq fQE;
    private aq fQF;
    private TextView fQG;
    private TextView fQH;
    private TextView fQI;
    private View fQJ;
    private View fQK;
    private LinearLayout fQL;
    private TextView fQM;
    private TextView fQN;
    private View fQO;
    private View fQP;
    private ObservedChangeLinearLayout fQR;
    private h fQS;
    private View fQY;
    public int fQa;
    private com.baidu.tieba.pb.video.i fQb;
    private long fQc;
    private com.baidu.tieba.pb.video.h fQd;
    private com.baidu.tieba.d.b fQe;
    public final com.baidu.tieba.pb.pb.main.view.c fQh;
    public com.baidu.tieba.pb.pb.main.view.b fQi;
    private ViewStub fQj;
    private ViewStub fQk;
    private PbLandscapeListView fQl;
    private View fQm;
    private LinearLayout fQp;
    private f fQq;
    private ColumnLayout fQr;
    private ThreadSkinView fQs;
    private TextView fQt;
    private TextView fQu;
    private ImageView fQv;
    private HeadPendantView fQw;
    private FrameLayout fQx;
    private HeadImageView fQy;
    private View fQz;
    private int fRA;
    private PostData fRB;
    private View fRD;
    private TextView fRE;
    private ViewStub fRF;
    private PbInterviewStatusView fRG;
    private ViewGroup fRH;
    private TextView fRI;
    private FrameLayout fRJ;
    private View fRK;
    private View fRL;
    private al fRM;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fRR;
    private int fRZ;
    private View fRs;
    private TextView fRt;
    private ImageView fRu;
    private ImageView fRv;
    private TextView fRw;
    private boolean fRy;
    private int fRz;
    private Runnable fSD;
    private PbActivity.b fSF;
    private Runnable fSa;
    private s fSb;
    private an fSc;
    private int fSi;
    private PbTopTipView fSk;
    private PopupWindow fSl;
    private PopupWindow fSm;
    private TextView fSn;
    private List<String> fSo;
    private com.baidu.tieba.pb.pb.main.emotion.c fSp;
    private com.baidu.tieba.pb.pb.godreply.a fSq;
    private PbLandscapeListView.b fSr;
    private ac fSt;
    private boolean fSv;
    private e fSw;
    private com.baidu.tbadk.core.view.userLike.c fSx;
    private com.baidu.tbadk.core.view.userLike.c fSy;
    private int fhC;
    private boolean isLandscape;
    private int mType;
    private boolean fQf = false;
    private int fQg = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fQn = null;
    private TextView fQo = null;
    public FrsPraiseView fQB = null;
    private ClickableHeaderImageView fQC = null;
    private View fQQ = null;
    private com.baidu.tbadk.core.dialog.a fQT = null;
    private com.baidu.tbadk.core.dialog.b dCK = null;
    private View fQU = null;
    private EditText fQV = null;
    private com.baidu.tieba.pb.view.i fQW = null;
    private com.baidu.tieba.pb.view.b fQX = null;
    private com.baidu.tbadk.core.dialog.a fQZ = null;
    private b.InterfaceC0073b eCi = null;
    private TbRichTextView.h bJF = null;
    private NoNetworkView.a dzq = null;
    private Dialog fRa = null;
    private View fRb = null;
    private com.baidu.tbadk.core.dialog.a fRc = null;
    private Dialog fRd = null;
    private Dialog fRe = null;
    private View fRf = null;
    private LinearLayout fRg = null;
    private CompoundButton.OnCheckedChangeListener cWh = null;
    private TextView fRh = null;
    private TextView fRi = null;
    private View fRj = null;
    private String fRk = null;
    private com.baidu.tbadk.core.dialog.b fRl = null;
    private com.baidu.tbadk.core.dialog.b fRm = null;
    private boolean fRn = false;
    private boolean fRo = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fRp = null;
    private boolean fRq = false;
    private Button fRr = null;
    private boolean fRx = true;
    private com.baidu.tbadk.core.view.b ddw = null;
    private boolean fEW = false;
    private int mSkinType = 3;
    private boolean fRC = false;
    private int fRO = 0;
    private boolean fRP = true;
    private a fRQ = new a();
    private int fRS = 0;
    private boolean fSd = false;
    private int fSe = 0;
    private boolean fSf = false;
    private boolean fSg = false;
    private boolean fSh = false;
    private int fSj = 0;
    private boolean fSs = false;
    private a.InterfaceC0152a fSu = new a.InterfaceC0152a() { // from class: com.baidu.tieba.pb.pb.main.as.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0152a
        public void onRefresh() {
        }
    };
    private String fSz = null;
    private CustomMessageListener fSA = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.as.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                as.this.fSz = null;
            }
        }
    };
    private CustomMessageListener dOa = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && as.this.fQS != null) {
                as.this.fQS.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fSB = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (as.this.fQo != null) {
                as.this.fQo.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fSC = new Handler();
    private CustomMessageListener fSE = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.as.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                as.this.fRx = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fSG = true;
    View.OnClickListener fSH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (as.this.fSf) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").s("obj_id", 2));
            }
            if (view == as.this.fQh.fVk) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").s("obj_locate", 2));
            }
            if (as.this.fJw.fHA.fUs != null) {
                if (!as.this.fSf && as.this.fMG != null && as.this.fMG.aYG() != null && as.this.fMG.aYG().yS() != null && as.this.fMG.aYG().yS().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").s("obj_locate", 1));
                }
                as.this.fJw.fHA.fUs.onClick(view);
            }
        }
    };
    private boolean fSI = false;
    String userId = null;
    private final List<TbImageView> fSJ = new ArrayList();
    private boolean fSK = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fSY;
        public al fSZ;
        public int fyV;
    }

    public void ko(boolean z) {
        this.fSd = z;
        if (this.fQl != null) {
            this.fSe = this.fQl.getHeaderViewsCount();
        }
    }

    public void bcZ() {
        if (this.fQl != null) {
            int headerViewsCount = this.fQl.getHeaderViewsCount() - this.fSe;
            final int firstVisiblePosition = (this.fQl.getFirstVisiblePosition() == 0 || this.fQl.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fQl.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fQl.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fRQ.fSZ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fRQ));
            final al alVar = this.fRQ.fSZ;
            final int f = f(alVar);
            final int y = ((int) this.fQR.getY()) + this.fQR.getMeasuredHeight();
            final boolean z = this.fRK.getVisibility() == 0;
            boolean z2 = this.fQR.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fQS.bbj() + this.fQl.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fPx.getMeasuredHeight() : 0;
                if (z2) {
                    this.fQl.setSelectionFromTop(this.fQS.bbj() + this.fQl.getHeaderViewsCount(), fRN - measuredHeight);
                } else {
                    this.fQl.setSelectionFromTop(this.fQS.bbj() + this.fQl.getHeaderViewsCount(), this.fQh.beC().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fQl.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fSf) {
                this.fQl.setSelectionFromTop(this.fQS.bbj() + this.fQl.getHeaderViewsCount(), this.fQb.bfR().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fQl.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.as.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bbB() {
                        if (f >= 0 && f <= as.this.dmk.getMeasuredHeight()) {
                            int f2 = as.this.f(alVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = as.this.dar.getLayoutParams();
                            if (i == 0 || i > as.this.dmk.getMeasuredHeight() || f2 >= as.this.dmk.getMeasuredHeight()) {
                                layoutParams.height = as.this.fRZ;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > as.this.dmk.getMeasuredHeight()) {
                                layoutParams.height = as.this.fRZ;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                as.this.fQl.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            as.this.dar.setLayoutParams(layoutParams);
                        }
                        as.this.fQl.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(al alVar) {
        if (alVar == null || alVar.getView() == null) {
            return 0;
        }
        if (alVar.getView().getTop() != 0 || alVar.getView().isShown()) {
            return alVar.getView().getBottom();
        }
        return 0;
    }

    public e bda() {
        return this.fSw;
    }

    public NoNetworkView bdb() {
        return this.dmi;
    }

    public void bdc() {
        if (this.axN != null) {
            this.axN.hide();
            if (this.fSp != null) {
                this.fSp.Vq();
            }
        }
    }

    public PbFakeFloorModel bdd() {
        return this.fLA;
    }

    public s bde() {
        return this.fSb;
    }

    public void bdf() {
        reset();
        bdc();
        this.fSb.bbq();
        kA(false);
    }

    private void reset() {
        if (this.fJw != null && this.fJw.bac() != null && this.axN != null) {
            com.baidu.tbadk.editortools.pb.a.KP().setStatus(0);
            com.baidu.tbadk.editortools.pb.d bac = this.fJw.bac();
            bac.Li();
            bac.KE();
            if (bac.getWriteImagesInfo() != null) {
                bac.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            bac.hP(SendView.ALL);
            bac.hQ(SendView.ALL);
            com.baidu.tbadk.editortools.l hH = this.axN.hH(23);
            com.baidu.tbadk.editortools.l hH2 = this.axN.hH(2);
            com.baidu.tbadk.editortools.l hH3 = this.axN.hH(5);
            if (hH2 != null) {
                hH2.th();
            }
            if (hH3 != null) {
                hH3.th();
            }
            if (hH != null) {
                hH.hide();
            }
            this.axN.invalidate();
        }
    }

    public boolean bdg() {
        return this.fRx;
    }

    public void kp(boolean z) {
        if (this.fRs != null && this.fRt != null) {
            this.fRt.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fRs.startAnimation(alphaAnimation);
            }
            this.fRs.setVisibility(0);
            this.fRx = true;
            if (this.fRR != null && !this.fSq.isActive()) {
                this.fRR.setVisibility(0);
                ku(true);
            }
        }
    }

    public void kq(boolean z) {
        if (this.fRs != null && this.fRt != null) {
            this.fRt.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fRs.startAnimation(alphaAnimation);
            }
            this.fRs.setVisibility(0);
            this.fRx = true;
            if (this.fRR != null && !this.fSq.isActive()) {
                this.fRR.setVisibility(0);
                ku(true);
            }
        }
    }

    public PostData bdh() {
        int i = 0;
        if (this.fQl == null) {
            return null;
        }
        int bdi = bdi() - this.fQl.getHeaderViewsCount();
        if (bdi < 0) {
            bdi = 0;
        }
        if (this.fQS.sI(bdi) != null && this.fQS.sI(bdi) != PostData.gYf) {
            i = bdi + 1;
        }
        return this.fQS.getItem(i) instanceof PostData ? (PostData) this.fQS.getItem(i) : null;
    }

    public int bdi() {
        int i;
        View childAt;
        if (this.fQl == null) {
            return 0;
        }
        int firstVisiblePosition = this.fQl.getFirstVisiblePosition();
        int lastVisiblePosition = this.fQl.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fQl.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fQl.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bdj() {
        return this.fQl.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fMG != null && this.fMG.aYI() != null && !this.fMG.aYI().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fMG.aYI().size() && (postData = this.fMG.aYI().get(i)) != null && postData.yS() != null && !StringUtils.isNull(postData.yS().getUserId()); i++) {
                if (this.fMG.aYI().get(i).yS().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fSq != null && this.fSq.isActive()) {
                        kA(false);
                    }
                    if (this.fRR != null) {
                        this.fRR.kH(true);
                    }
                    this.fSz = postData.yS().getName_show();
                    return;
                }
            }
        }
    }

    public as(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fJw = null;
        this.dmk = null;
        this.dCY = null;
        this.fQc = 0L;
        this.fQl = null;
        this.fQm = null;
        this.fQp = null;
        this.fQr = null;
        this.fQt = null;
        this.fQu = null;
        this.fQx = null;
        this.fQy = null;
        this.fQz = null;
        this.fQD = null;
        this.fQG = null;
        this.fQH = null;
        this.fQI = null;
        this.fQJ = null;
        this.fQO = null;
        this.fQP = null;
        this.fQS = null;
        this.dFN = null;
        this.bxf = null;
        this.dCL = null;
        this.fFa = null;
        this.fRs = null;
        this.fRt = null;
        this.fRu = null;
        this.fRv = null;
        this.fRw = null;
        this.fRD = null;
        this.fRE = null;
        this.fRF = null;
        this.fSi = 0;
        this.fQc = System.currentTimeMillis();
        this.fJw = pbActivity;
        this.dCL = onClickListener;
        this.bJG = cVar;
        this.fSi = com.baidu.adp.lib.util.l.ao(this.fJw) / 2;
        this.dmk = (RelativeLayout) LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.fJw.addContentView(this.dmk, new FrameLayout.LayoutParams(-1, -1));
        this.dSo = (NavigationBarCoverTip) this.fJw.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dCY = this.fJw.findViewById(d.g.statebar_view);
        this.fQR = (ObservedChangeLinearLayout) this.fJw.findViewById(d.g.title_wrapper);
        this.dmi = (NoNetworkView) this.fJw.findViewById(d.g.view_no_network);
        this.fQl = (PbLandscapeListView) this.fJw.findViewById(d.g.new_pb_list);
        this.fRJ = (FrameLayout) this.fJw.findViewById(d.g.root_float_header);
        this.bmp = new TextView(this.fJw.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds88));
        this.fQl.addHeaderView(this.bmp, 0);
        this.fRZ = this.fJw.getResources().getDimensionPixelSize(d.e.tbds134);
        this.dar = new View(this.fJw.getPageContext().getPageActivity());
        this.dar.setLayoutParams(new AbsListView.LayoutParams(-1, this.fRZ));
        this.dar.setVisibility(4);
        this.fQl.addFooterView(this.dar);
        this.fQl.setOnTouchListener(this.fJw.bBl);
        this.fQh = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.fJw.baF()) {
            this.fQj = (ViewStub) this.fJw.findViewById(d.g.manga_view_stub);
            this.fQj.setVisibility(0);
            this.fQi = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.fQi.show();
            this.fQh.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds120);
        }
        this.bmp.setLayoutParams(layoutParams);
        this.fQh.beC().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0136a() { // from class: com.baidu.tieba.pb.pb.main.as.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0136a
            public void avb() {
                if (as.this.fQl != null) {
                    if (as.this.fQb != null) {
                        as.this.fQb.bfS();
                    }
                    as.this.fQl.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0136a
            public void ava() {
                as.this.fJw.auo();
            }
        }));
        this.fRs = this.fJw.findViewById(d.g.pb_editor_tool_comment);
        this.fRz = com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds90);
        this.fRA = com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds242);
        this.fRt = (TextView) this.fJw.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fRv = (ImageView) this.fJw.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fRu = (ImageView) this.fJw.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fRw = (TextView) this.fJw.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fRw.setVisibility(8);
        this.fRt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.bel();
                if (!as.this.fJw.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, as.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d bac = as.this.fJw.bac();
                if (bac == null || (!bac.Lf() && !bac.Lg())) {
                    if (as.this.axN != null) {
                        as.this.bdt();
                    }
                    if (as.this.axN != null) {
                        as.this.fRx = false;
                        if (as.this.axN.hJ(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fJw, (View) as.this.axN.hJ(2).bqa, false, as.this.fSu);
                        }
                    }
                    as.this.bdX();
                    return;
                }
                as.this.fJw.bac().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fRu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.bel();
                if (as.this.fJw.checkUpIsLogin()) {
                    if (as.this.axN != null) {
                        as.this.bdt();
                        as.this.axN.bh((View) as.this.axN.hH(5));
                    }
                    if (as.this.axN != null) {
                        as.this.fRx = false;
                        if (as.this.axN.hJ(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fJw, (View) as.this.axN.hJ(2).bqa, false, as.this.fSu);
                        }
                    }
                    as.this.bdX();
                }
            }
        });
        this.fRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.bel();
                if (as.this.fJw.checkUpIsLogin()) {
                    if (as.this.axN != null) {
                        as.this.bdt();
                        as.this.axN.bh((View) as.this.axN.hH(2));
                    }
                    if (as.this.axN != null) {
                        as.this.fRx = false;
                        if (as.this.axN.hJ(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fJw, (View) as.this.axN.hJ(2).bqa, false, as.this.fSu);
                        }
                    }
                    as.this.bdX();
                }
            }
        });
        this.fRw.setOnClickListener(this.dCL);
        this.fRw.setOnTouchListener(this.fJw);
        this.fQm = LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fQp = (LinearLayout) LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.aj.s(this.fQp, d.C0107d.cp_bg_line_d);
        this.fQq = new f(this.fJw, this.fQp);
        this.fQq.init();
        this.fQq.a(this.fQq.bab(), this.dCL);
        this.fQr = (ColumnLayout) this.fQp.findViewById(d.g.pb_head_owner_root);
        this.fQs = (ThreadSkinView) this.fQp.findViewById(d.g.pb_thread_skin);
        this.fQr.setOnLongClickListener(this.onLongClickListener);
        this.fQr.setOnTouchListener(this.bJG);
        this.fQr.setVisibility(8);
        this.fQm.setOnTouchListener(this.bJG);
        this.fRD = this.fQm.findViewById(d.g.pb_head_activity_join_number_container);
        this.fRD.setVisibility(8);
        this.fRE = (TextView) this.fQm.findViewById(d.g.pb_head_activity_join_number);
        this.fQt = (TextView) this.fQr.findViewById(d.g.pb_head_owner_info_user_name);
        this.fQu = (TextView) this.fQr.findViewById(d.g.floor_owner);
        this.fQv = (ImageView) this.fQr.findViewById(d.g.icon_forum_level);
        this.fQx = (FrameLayout) this.fQr.findViewById(d.g.pb_head_headImage_container);
        this.fQy = (HeadImageView) this.fQr.findViewById(d.g.pb_head_owner_photo);
        this.fQw = (HeadPendantView) this.fQr.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fQw.Dx();
        if (this.fQw.getHeadView() != null) {
            this.fQw.getHeadView().setIsRound(true);
            this.fQw.getHeadView().setDrawBorder(false);
        }
        this.fKD = (UserIconBox) this.fQr.findViewById(d.g.show_icon_vip);
        this.fKE = (UserIconBox) this.fQr.findViewById(d.g.show_icon_yinji);
        this.fQA = (FloatingLayout) this.fQp.findViewById(d.g.pb_head_owner_info_root);
        this.fQD = (PbFirstFloorUserLikeButton) this.fQr.findViewById(d.g.pb_like_button);
        this.fQG = (TextView) this.fQr.findViewById(d.g.pb_views);
        this.bcz = (TextView) this.fQr.findViewById(d.g.view_forum_name);
        this.fQK = this.fQr.findViewById(d.g.line_right_forum_name);
        this.fQH = (TextView) this.fQr.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fQI = (TextView) this.fQr.findViewById(d.g.pb_item_first_floor_location_address);
        this.fQJ = this.fQr.findViewById(d.g.line_between_time_and_locate);
        this.fSx = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fSy = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fQO = this.fQm.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fQP = this.fQm.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fQm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fRF = (ViewStub) this.dmk.findViewById(d.g.interview_status_stub);
        this.fQS = new h(this.fJw, this.fQl);
        this.fQS.r(this.dCL);
        this.fQS.setTbGestureDetector(this.bJG);
        this.fQS.setOnImageClickListener(this.bJF);
        this.fFa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.ajX() || !com.baidu.tieba.c.a.b(as.this.fJw.getBaseContext(), as.this.fJw.aZO().bbF(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                as.this.fJw.c(sparseArray);
                                return;
                            }
                            as.this.cz(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        as.this.fJw.c(sparseArray);
                    } else if (booleanValue3) {
                        as.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fQS.E(this.fFa);
        bdo();
        this.fQl.addHeaderView(this.fQn);
        this.fQl.addHeaderView(this.fQp);
        this.fQl.addHeaderView(this.fQm);
        this.dFN = new PbListView(this.fJw.getPageContext().getPageActivity());
        this.bxf = this.dFN.getView().findViewById(d.g.pb_more_view);
        if (this.bxf != null) {
            this.bxf.setOnClickListener(this.dCL);
            com.baidu.tbadk.core.util.aj.s(this.bxf, d.f.pb_foot_more_trans_selector);
        }
        this.dFN.DG();
        this.dFN.gs(d.f.pb_foot_more_trans_selector);
        this.dFN.gu(d.f.pb_foot_more_trans_selector);
        this.fQY = this.fJw.findViewById(d.g.viewstub_progress);
        this.fJw.registerListener(this.fSE);
        this.fQz = com.baidu.tbadk.ala.b.uY().t(this.fJw.getActivity(), 2);
        if (this.fQz != null) {
            this.fQz.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fJw.getResources().getDimensionPixelSize(d.e.ds10);
            if (this.fQz.getParent() == null) {
                this.fQA.addView(this.fQz, aVar);
            }
        }
        this.fLA = new PbFakeFloorModel(this.fJw.getPageContext());
        this.fSb = new s(this.fJw.getPageContext(), this.fLA, this.dmk);
        this.fSb.a(this.fJw.fIx);
        this.fLA.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.as.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                as.this.fLA.m(postData);
                as.this.fQS.notifyDataSetChanged();
                as.this.fSb.bbq();
                as.this.axN.IE();
                as.this.kA(false);
            }
        });
        if (this.fJw.aZO() != null && !StringUtils.isNull(this.fJw.aZO().bck())) {
            this.fJw.showToast(this.fJw.aZO().bck());
        }
        this.fRK = this.fJw.findViewById(d.g.pb_expand_blank_view);
        this.fRL = this.fJw.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fRL.getLayoutParams();
        if (this.fJw.aZO() != null && this.fJw.aZO().bbI()) {
            this.fRK.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fRL.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fRN;
            this.fRL.setLayoutParams(layoutParams2);
        }
        this.fRM = new al(this.fJw.getPageContext(), this.fJw.findViewById(d.g.pb_reply_expand_view));
        this.fRM.fPx.setVisibility(8);
        this.fRM.G(this.dCL);
        this.fJw.registerListener(this.dOa);
        this.fJw.registerListener(this.fSA);
        this.fJw.registerListener(this.fSB);
        bdk();
        ku(false);
    }

    private void bdk() {
        this.fSq = new com.baidu.tieba.pb.pb.godreply.a(this.fJw, this, (ViewStub) this.dmk.findViewById(d.g.more_god_reply_popup));
        this.fSq.l(this.dCL);
        this.fSq.E(this.fFa);
        this.fSq.setOnImageClickListener(this.bJF);
        this.fSq.l(this.dCL);
        this.fSq.setTbGestureDetector(this.bJG);
    }

    public com.baidu.tieba.pb.pb.godreply.a bdl() {
        return this.fSq;
    }

    public View bdm() {
        return this.fRK;
    }

    public void bdn() {
        if (this.fQl != null) {
            this.fQl.removeHeaderView(this.fQn);
            this.fQl.removeHeaderView(this.fQp);
            this.fQl.removeHeaderView(this.fQm);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fRR == null) {
            this.fRR = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.fJw.getPageContext().getPageActivity());
            ku(true);
            this.fRR.a(this.dmk, aVar, this.fRs.getVisibility() == 0);
            this.fRR.setOnEmotionClickListener(new a.InterfaceC0141a() { // from class: com.baidu.tieba.pb.pb.main.as.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0141a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(as.this.fSz)) {
                        emotionImageData.setAuthorNameShow(as.this.fSz);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0141a
                public void a(String str, List<String> list, List<String> list2) {
                    as.this.fJw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(as.this.fJw.getPageContext().getPageActivity(), 25016, str, list, as.this.fSz, list2)));
                }
            });
            this.fRR.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    as.this.bel();
                    if (as.this.fRs != null) {
                        ViewGroup.LayoutParams layoutParams = as.this.fRs.getLayoutParams();
                        layoutParams.height = (int) (((as.this.fRA - as.this.fRz) * f) + as.this.fRz);
                        as.this.fRt.setAlpha(1.0f - f);
                        as.this.fRv.setAlpha(1.0f - f);
                        as.this.fRu.setAlpha(1.0f - f);
                        as.this.fRs.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bdo() {
        if (this.fQn == null) {
            int s = com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.tbds44);
            this.fQn = new LinearLayout(this.fJw.getPageContext().getPageActivity());
            this.fQn.setOrientation(1);
            this.fQn.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fQn.setPadding(s, com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.tbds30), s, com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.tbds40));
            this.fQn.setGravity(17);
            this.fQo = new TextView(this.fJw.getPageContext().getPageActivity());
            this.fQo.setGravity(3);
            this.fQo.setMaxLines(2);
            this.fQo.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_link_tip_c));
            this.fQo.setPadding(0, 0, 0, 0);
            this.fQo.setLineSpacing(com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.r(this.fQo, d.C0107d.cp_cont_b);
            this.fQo.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fQo.setVisibility(8);
            if (this.fQo.getParent() == null) {
                this.fQn.addView(this.fQo);
            }
            this.fQn.setOnTouchListener(this.bJG);
            this.fQn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdp() {
        if (this.fJw.baF()) {
            this.fQk = (ViewStub) this.fJw.findViewById(d.g.manga_mention_controller_view_stub);
            this.fQk.setVisibility(0);
            if (this.fQL == null) {
                this.fQL = (LinearLayout) this.fJw.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fJw.getPageContext(), this.fQL);
            }
            if (this.fQM == null) {
                this.fQM = (TextView) this.fQL.findViewById(d.g.manga_prev_btn);
            }
            if (this.fQN == null) {
                this.fQN = (TextView) this.fQL.findViewById(d.g.manga_next_btn);
            }
            this.fQM.setOnClickListener(this.dCL);
            this.fQN.setOnClickListener(this.dCL);
        }
    }

    private void bdq() {
        if (this.fJw.baF()) {
            if (this.fJw.baI() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fQM, d.C0107d.cp_cont_e, 1);
            }
            if (this.fJw.baJ() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fQN, d.C0107d.cp_cont_e, 1);
            }
        }
    }

    public void bdr() {
        if (this.fQL == null) {
            bdp();
        }
        this.fQk.setVisibility(8);
        if (this.fSC != null && this.fSD != null) {
            this.fSC.removeCallbacks(this.fSD);
        }
    }

    public void bds() {
        if (this.fSC != null) {
            if (this.fSD != null) {
                this.fSC.removeCallbacks(this.fSD);
            }
            this.fSD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.this.fQL == null) {
                        as.this.bdp();
                    }
                    as.this.fQk.setVisibility(0);
                }
            };
            this.fSC.postDelayed(this.fSD, 2000L);
        }
    }

    public void kr(boolean z) {
        this.fQh.kr(z);
        if (z && this.fRC) {
            this.dFN.setText(this.fJw.getResources().getString(d.j.click_load_more));
            this.fQl.setNextPage(this.dFN);
            this.fQg = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axN = iVar;
        this.axN.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.axN.getParent() == null) {
            this.dmk.addView(this.axN, layoutParams);
        }
        this.axN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bdc();
        this.fJw.bac().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.as.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (as.this.axN != null && as.this.axN.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (as.this.fSp == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, as.this.axN.getId());
                            as.this.fSp = new com.baidu.tieba.pb.pb.main.emotion.c(as.this.fJw.getPageContext(), as.this.dmk, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.E(as.this.fSo)) {
                                as.this.fSp.setData(as.this.fSo);
                            }
                            as.this.fSp.b(as.this.axN);
                        }
                        as.this.fSp.qn(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (as.this.fJw.fHE != null && as.this.fJw.fHE.beo() != null) {
                    if (!as.this.fJw.fHE.beo().bEP()) {
                        as.this.fJw.fHE.kE(false);
                    }
                    as.this.fJw.fHE.beo().nr(false);
                }
            }
        });
    }

    public void bdt() {
        if (this.fJw != null && this.axN != null) {
            this.axN.th();
            bdX();
        }
    }

    public void S(String str, boolean z) {
        this.fRy = z;
        ks(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void ks(boolean z) {
        if (this.fRw != null) {
            if (this.fRy) {
                com.baidu.tbadk.core.util.aj.s(this.fRw, d.f.pb_praise_already_click_selector);
                this.fRw.setContentDescription(this.fJw.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.s(this.fRw, d.f.pb_praise_normal_click_selector);
            this.fRw.setContentDescription(this.fJw.getResources().getString(d.j.zan));
        }
    }

    public TextView bdu() {
        return this.fRw;
    }

    public void kt(boolean z) {
        if (this.fQl != null && this.bmp != null && this.dCY != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dCY.setVisibility(0);
                } else {
                    this.dCY.setVisibility(8);
                    this.fQl.removeHeaderView(this.bmp);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.bmp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fRN;
                    this.bmp.setLayoutParams(layoutParams);
                }
                bdJ();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.bmp.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kC(true);
                this.bmp.setLayoutParams(layoutParams2);
            }
            bdJ();
            beh();
        }
    }

    public h bdv() {
        return this.fQS;
    }

    public void a(PbActivity.d dVar) {
        this.fIB = dVar;
    }

    public void cz(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fRb == null) {
            this.fRb = LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fJw.getLayoutMode().aM(this.fRb);
        if (this.fRa == null) {
            this.fRa = new Dialog(this.fJw.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fRa.setCanceledOnTouchOutside(true);
            this.fRa.setCancelable(true);
            this.fRa.setContentView(this.fRb);
            WindowManager.LayoutParams attributes = this.fRa.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ao(this.fJw.getPageContext().getPageActivity()) * 0.9d);
            this.fRa.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fRa.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fRa.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fRa.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fRa != null && (as.this.fRa instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fRa, as.this.fJw.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        as.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || bee()) {
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
                public void onClick(View view) {
                    if (as.this.fRa != null && (as.this.fRa instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fRa, as.this.fJw.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && as.this.fSF != null) {
                        as.this.fSF.ak(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
            sparseArray6.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray6.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray6.put(d.g.tag_user_mute_msg, sparseArray.get(d.g.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fRa != null && (as.this.fRa instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fRa, as.this.fJw.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        as.this.fJw.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fRa, this.fJw.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fSF = bVar;
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
        sparseArray.put(fRU, Integer.valueOf(fRV));
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
        this.fRc = new com.baidu.tbadk.core.dialog.a(this.fJw.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fRc.fb(i3);
        } else {
            this.fRc.ba(false);
            this.fRc.cZ(str2);
        }
        this.fRc.aE(sparseArray);
        this.fRc.a(d.j.dialog_ok, this.fJw);
        this.fRc.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fRc.aV(true);
        this.fRc.b(this.fJw.getPageContext());
        this.fRc.AA();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fRf == null) {
            this.fRf = LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.fJw.getLayoutMode().aM(this.fRf);
        if (this.fRe == null) {
            this.fRe = new Dialog(this.fJw.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fRe.setCanceledOnTouchOutside(true);
            this.fRe.setCancelable(true);
            this.fRp = (ScrollView) this.fRf.findViewById(d.g.good_scroll);
            this.fRe.setContentView(this.fRf);
            WindowManager.LayoutParams attributes = this.fRe.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds540);
            this.fRe.getWindow().setAttributes(attributes);
            this.cWh = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.as.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        as.this.fRk = (String) compoundButton.getTag();
                        if (as.this.cWg != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : as.this.cWg) {
                                String str = (String) aVar.getTag();
                                if (str != null && as.this.fRk != null && !str.equals(as.this.fRk)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fRg = (LinearLayout) this.fRf.findViewById(d.g.good_class_group);
            this.fRi = (TextView) this.fRf.findViewById(d.g.dialog_button_cancel);
            this.fRi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fRe instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(as.this.fRe, as.this.fJw.getPageContext());
                    }
                }
            });
            this.fRh = (TextView) this.fRf.findViewById(d.g.dialog_button_ok);
            this.fRh.setOnClickListener(this.dCL);
        }
        this.fRg.removeAllViews();
        this.cWg = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bI = bI("0", this.fJw.getPageContext().getString(d.j.def_good_class));
        this.cWg.add(bI);
        bI.setChecked(true);
        this.fRg.addView(bI);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xx()) && aaVar.xy() > 0) {
                    com.baidu.tieba.pb.pb.main.view.a bI2 = bI(String.valueOf(aaVar.xy()), aaVar.xx());
                    this.cWg.add(bI2);
                    View view = new View(this.fJw.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.aj.t(view, d.C0107d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fRg.addView(view);
                    this.fRg.addView(bI2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fRp.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fJw.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fJw.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fJw.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fRp.setLayoutParams(layoutParams2);
            this.fRp.removeAllViews();
            if (this.fRg == null) {
                this.fRp.addView(this.fRg);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fRe, this.fJw.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bI(String str, String str2) {
        Activity pageActivity = this.fJw.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.s(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cWh);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void bdw() {
        this.fJw.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fJw.hideProgressBar();
        if (z && z2) {
            this.fJw.showToast(this.fJw.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.fJw.showToast(str);
        }
    }

    public void aIC() {
        this.fQY.setVisibility(0);
    }

    public void aIB() {
        this.fQY.setVisibility(8);
    }

    public View bdx() {
        if (this.fRf != null) {
            return this.fRf.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bdy() {
        return this.fRk;
    }

    public View getView() {
        return this.dmk;
    }

    public void bdz() {
        com.baidu.adp.lib.util.l.a(this.fJw.getPageContext().getPageActivity(), this.fJw.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fJw.hideProgressBar();
        if (z) {
            bdO();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bdP();
        } else {
            bdO();
        }
    }

    public void bdA() {
        this.dFN.DG();
        this.dFN.DK();
    }

    public void bdB() {
        this.fJw.hideProgressBar();
        DL();
        this.fQl.completePullRefreshPostDelayed(2000L);
        bdL();
    }

    public void bdC() {
        this.fQl.completePullRefreshPostDelayed(2000L);
        bdL();
    }

    private void ku(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fRt.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fJw.getResources().getDimensionPixelSize(d.e.ds130) : this.fJw.getResources().getDimensionPixelSize(d.e.ds34);
        this.fRt.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fQS.setOnLongClickListener(onLongClickListener);
        if (this.fSq != null) {
            this.fSq.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0073b interfaceC0073b, boolean z, boolean z2) {
        if (this.fRl != null) {
            this.fRl.dismiss();
            this.fRl = null;
        }
        this.fRl = new com.baidu.tbadk.core.dialog.b(this.fJw.getPageContext().getPageActivity());
        this.fRl.fe(d.j.operation);
        if (z2) {
            this.fRl.a(new String[]{this.fJw.getPageContext().getString(d.j.copy)}, interfaceC0073b);
        } else if (!z) {
            this.fRl.a(new String[]{this.fJw.getPageContext().getString(d.j.copy), this.fJw.getPageContext().getString(d.j.mark)}, interfaceC0073b);
        } else {
            this.fRl.a(new String[]{this.fJw.getPageContext().getString(d.j.copy), this.fJw.getPageContext().getString(d.j.remove_mark)}, interfaceC0073b);
        }
        this.fRl.d(this.fJw.getPageContext());
        this.fRl.AD();
    }

    public void a(b.InterfaceC0073b interfaceC0073b, boolean z) {
        if (this.fRm != null) {
            this.fRm.dismiss();
            this.fRm = null;
        }
        this.fRm = new com.baidu.tbadk.core.dialog.b(this.fJw.getPageContext().getPageActivity());
        this.fRm.fe(d.j.operation);
        if (z) {
            this.fRm.a(new String[]{this.fJw.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0073b);
        } else {
            this.fRm.a(new String[]{this.fJw.getPageContext().getString(d.j.save_to_emotion), this.fJw.getPageContext().getString(d.j.save_to_local)}, interfaceC0073b);
        }
        this.fRm.d(this.fJw.getPageContext());
        this.fRm.AD();
    }

    public int bdD() {
        return sX(this.fQl.getFirstVisiblePosition());
    }

    private int sX(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fQl.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fQl.getAdapter() == null || !(this.fQl.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fQl.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bdE() {
        int lastVisiblePosition = this.fQl.getLastVisiblePosition();
        if (this.fQb != null) {
            if (lastVisiblePosition == this.fQl.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return sX(lastVisiblePosition);
    }

    public void sY(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fQl != null) {
            if (this.fQh == null || this.fQh.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fQh.mNavigationBar.getFixedNavHeight();
                if (this.fJw.bar() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fRL != null && (layoutParams = (LinearLayout.LayoutParams) this.fRL.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fRL.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fQl.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fQl.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fQV.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.f fVar) {
        this.fQS.a(fVar, false);
        this.fQS.notifyDataSetChanged();
        bdL();
        if (this.fSq != null) {
            this.fSq.aZK();
        }
    }

    public void o(com.baidu.tieba.pb.data.f fVar) {
        if (this.fQB == null) {
            this.fJw.getLayoutMode().aM(((ViewStub) this.fQm.findViewById(d.g.praise_layout)).inflate());
            this.fQB = (FrsPraiseView) this.fQm.findViewById(d.g.pb_head_praise_view);
            this.fQB.setIsFromPb(true);
            this.fQQ = this.fQm.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fQB.gz(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fQB != null) {
            boolean bdL = bdL();
            this.fQB.setVisibility(8);
            if (fVar != null && fVar.xY() != null && fVar.xY().xV() == 0 && this.fEW) {
                if (bdL) {
                    this.fQP.setVisibility(0);
                    return;
                } else {
                    this.fQP.setVisibility(8);
                    return;
                }
            }
            this.fQP.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aYQ() != null) {
            return fVar.aYQ();
        }
        if (!com.baidu.tbadk.core.util.v.E(fVar.aYI())) {
            Iterator<PostData> it = fVar.aYI().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bvH() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aYN();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.yS() != null && postData.yS().getUserTbVipInfoData() != null && postData.yS().getUserTbVipInfoData().getvipIntro() != null) {
            postData.yS().getGodUserData().setIntro(postData.yS().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aYG() == null || fVar.aYG().yS() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yS = fVar.aYG().yS();
        String userId = yS.getUserId();
        HashMap<String, MetaData> userMap = fVar.aYG().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yS;
        }
        postData.vL(1);
        postData.setId(fVar.aYG().zj());
        postData.setTitle(fVar.aYG().getTitle());
        postData.setTime(fVar.aYG().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x031a  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        String e;
        ArrayList<IconData> tShowInfoNew;
        int s;
        com.baidu.tbadk.data.f bvL;
        String portrait;
        if (fVar != null && fVar.aYG() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            bef();
            this.fQr.setVisibility(8);
            if (fVar.aYG() != null && fVar.aYG().zF() && fVar.aYG().zk() != null) {
                this.fSf = true;
                this.fQh.kQ(this.fSf);
                this.fQh.mNavigationBar.hideBottomLine();
                if (this.fQb == null) {
                    this.fQb = new com.baidu.tieba.pb.video.i(this.fJw, this.fQh, fVar.aYG().zk(), this.fQc);
                    this.fQb.a(fVar.aYG().zk(), fVar.aYG(), fVar.getForumId());
                    this.fQb.startPlay();
                } else if (this.fQf) {
                    this.fQb.a(fVar.aYG().zk(), fVar.aYG(), fVar.getForumId());
                    this.fQb.startPlay();
                } else {
                    this.fQb.qz(fVar.getForumId());
                }
                if (fVar.aYH() != null && fVar.aYH().size() >= 1) {
                    bd bdVar = fVar.aYH().get(0);
                    this.fQb.ae(bdVar);
                    this.fQb.qA(bdVar.getTitle());
                }
                this.fQb.b(b, fVar.aYG(), fVar.aZc());
                this.fQf = false;
                this.fQl.removeHeaderView(this.fQb.bfT());
                this.fQl.addHeaderView(this.fQb.bfT(), 0);
                if (this.fQb.bfR() != null && this.fQb.bfR().getParent() == null) {
                    this.fRJ.addView(this.fQb.bfR());
                }
                if (this.fQd == null) {
                    this.fQd = new com.baidu.tieba.pb.video.h(this.fJw);
                }
                this.fQd.a(fVar.aYG().zU(), fVar.aYG(), fVar.aYZ());
                this.fQl.removeHeaderView(this.fQd.bfI());
                this.fQl.addHeaderView(this.fQd.bfI(), 1);
                if (fVar.aYG().zU() != null) {
                    this.fQl.removeHeaderView(this.fQd.bfJ());
                    this.fQl.removeHeaderView(this.fQp);
                    this.fQl.addHeaderView(this.fQd.bfJ(), 2);
                } else {
                    if (this.fQd.bfJ() != null) {
                        this.fQl.removeHeaderView(this.fQd.bfJ());
                    }
                    this.fQl.removeHeaderView(this.fQp);
                    this.fQp.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(this.fJw, d.e.tbds56));
                    this.fQl.addHeaderView(this.fQp, 2);
                }
                if (this.fQb != null) {
                    this.fQh.kK(false);
                    this.fQh.kM(TbadkCoreApplication.isLogin());
                    this.fQb.tf(TbadkCoreApplication.getInst().getSkinType());
                }
                bdJ();
            } else {
                this.fSf = false;
                this.fQh.kQ(this.fSf);
                if (this.fQb != null) {
                    this.fQl.removeHeaderView(this.fQb.bfT());
                }
                if (this.fQd != null) {
                    this.fQd.b(this.fQl);
                }
                if (b == null || (b != null && (b.bvK() == null || com.baidu.tbadk.core.util.v.E(b.bvK().QB())))) {
                    this.fQp.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(this.fJw, d.e.tbds80));
                } else {
                    this.fQp.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fJw.bag() != null) {
                this.fJw.bag().kI(this.fSf);
            }
            if (this.fQb != null) {
                this.fQb.I(this.fSH);
            }
            if (b != null) {
                this.fRB = b;
                this.fQr.setVisibility(0);
                if (this.fJw.baT()) {
                    if (fVar.aYF() != null) {
                        this.mForumName = fVar.aYF().getForumName();
                        this.mForumId = fVar.aYF().getForumId();
                    }
                    if (this.mForumName == null && this.fJw.aZO() != null && this.fJw.aZO().bbE() != null) {
                        this.mForumName = this.fJw.aZO().bbE();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fQr.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fQr.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fSv) {
                    this.fQn.setVisibility(0);
                }
                if (!fVar.aYG().zF() && this.fQo.getText() != null && this.fQo.getText().length() > 0) {
                    this.fQo.setVisibility(0);
                } else {
                    this.fQo.setVisibility(8);
                }
                o(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> ze = fVar.aYG().ze();
                if (ze != null && ze.size() > 0 && !this.fSv) {
                    this.fRE.setText(String.valueOf(ze.get(0).wT()));
                    this.fRD.setVisibility(0);
                } else {
                    this.fRD.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.s(this.fRD, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.e(this.fRE, d.C0107d.cp_link_tip_d, 1);
                if (b.yS() != null) {
                    String string = b.yS().getName_show() == null ? StringUtils.string(b.yS().getUserName()) : StringUtils.string(b.yS().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.yS().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.aX(b.yS().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aX(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.yS().getIconInfo();
                            tShowInfoNew = b.yS().getTShowInfoNew();
                            if (this.fKE != null) {
                                this.fKE.setTag(d.g.tag_user_id, b.yS().getUserId());
                                this.fKE.setOnClickListener(this.fJw.fHA.fUt);
                                this.fKE.a(iconInfo, 4, this.fJw.getResources().getDimensionPixelSize(d.e.tbds36), this.fJw.getResources().getDimensionPixelSize(d.e.tbds36), this.fJw.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fKD != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fKD.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fKD.setOnClickListener(this.fJw.fHA.fUu);
                                this.fKD.a(tShowInfoNew, 3, this.fJw.getResources().getDimensionPixelSize(d.e.tbds36), this.fJw.getResources().getDimensionPixelSize(d.e.tbds36), this.fJw.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fQt.setText(af(b.yS().getSealPrefix(), e));
                            this.fQt.setTag(d.g.tag_user_id, b.yS().getUserId());
                            this.fQt.setTag(d.g.tag_user_name, b.yS().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew) || b.yS().isBigV()) {
                                com.baidu.tbadk.core.util.aj.e(this.fQt, d.C0107d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.e(this.fQt, d.C0107d.cp_cont_f, 1);
                            }
                            this.fQu.setVisibility(8);
                            if (fVar.aYG().yS() != null && fVar.aYG().yS().getAlaUserData() != null && this.fQz != null) {
                                if (fVar.aYG().yS().getAlaUserData().anchor_live != 0) {
                                    this.fQz.setVisibility(8);
                                } else {
                                    this.fQz.setVisibility(0);
                                    if (this.fQe == null) {
                                        this.fQe = new com.baidu.tieba.d.b(this.fJw.getPageContext(), this.fQz);
                                        this.fQe.lX(1);
                                    }
                                    this.fQe.aK(this.fJw.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aFI = fVar.aYG().yS().getAlaUserData();
                                    aVar.type = 2;
                                    this.fQz.setTag(aVar);
                                }
                            }
                            this.fQy.setUserId(b.yS().getUserId());
                            this.fQy.setUserName(b.yS().getUserName());
                            this.fQy.setImageDrawable(null);
                            this.fQy.setRadius(com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds40));
                            this.fQy.setTag(b.yS().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fQH.setText(com.baidu.tbadk.core.util.am.A(b.getTime()));
                            } else {
                                this.fQH.setText(com.baidu.tbadk.core.util.am.z(b.getTime()));
                            }
                            s = com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds16);
                            if (!this.fJw.baT() && !StringUtils.isNull(this.mForumName)) {
                                this.bcz.setText(this.fJw.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.bcz.setVisibility(0);
                                this.fQK.setVisibility(0);
                                this.fQH.setPadding(s, 0, s, 0);
                            } else {
                                this.bcz.setVisibility(8);
                                this.fQK.setVisibility(8);
                                this.fQH.setPadding(0, 0, s, 0);
                            }
                            bvL = b.bvL();
                            if (bvL == null && !TextUtils.isEmpty(bvL.getName()) && !TextUtils.isEmpty(bvL.getName().trim())) {
                                final String name = bvL.getName();
                                final String lat = bvL.getLat();
                                final String lng = bvL.getLng();
                                this.fQI.setVisibility(0);
                                this.fQJ.setVisibility(0);
                                this.fQI.setText(bvL.getName());
                                this.fQI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.oI()) {
                                                as.this.fJw.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.Q(as.this.fJw.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, as.this.fJw.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fQI.setVisibility(8);
                                this.fQJ.setVisibility(8);
                            }
                            portrait = b.yS().getPortrait();
                            if (b.yS().getPendantData() == null && !StringUtils.isNull(b.yS().getPendantData().xt())) {
                                UtilHelper.showHeadImageViewBigV(this.fQw.getHeadView(), b.yS());
                                this.fQy.setVisibility(8);
                                this.fQw.setVisibility(0);
                                if (this.fQC != null) {
                                    this.fQC.setVisibility(8);
                                }
                                this.fQt.setOnClickListener(this.fSH);
                                this.fQw.getHeadView().startLoad(portrait, 28, false);
                                this.fQw.getHeadView().setUserId(b.yS().getUserId());
                                this.fQw.getHeadView().setUserName(b.yS().getUserName());
                                this.fQw.getHeadView().setOnClickListener(this.fSH);
                                this.fQw.ez(b.yS().getPendantData().xt());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fQy, b.yS());
                                this.fQy.setVisibility(0);
                                this.fQr.setOnClickListener(this.fSH);
                                this.fQt.setOnClickListener(this.fSH);
                                this.fQy.setOnClickListener(this.fSH);
                                this.fQw.setVisibility(8);
                                this.fQy.startLoad(portrait, 28, false);
                            }
                            String name_show = b.yS().getName_show();
                            String userName = b.yS().getUserName();
                            if (com.baidu.tbadk.o.ac.nu() && name_show != null && !name_show.equals(userName)) {
                                this.fQt.setText(com.baidu.tieba.pb.c.al(this.fJw.getPageContext().getPageActivity(), this.fQt.getText().toString()));
                                this.fQt.setGravity(16);
                                this.fQt.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYi());
                                com.baidu.tbadk.core.util.aj.e(this.fQt, d.C0107d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.yS().getIconInfo();
                        tShowInfoNew = b.yS().getTShowInfoNew();
                        if (this.fKE != null) {
                        }
                        if (this.fKD != null) {
                        }
                        this.fQt.setText(af(b.yS().getSealPrefix(), e));
                        this.fQt.setTag(d.g.tag_user_id, b.yS().getUserId());
                        this.fQt.setTag(d.g.tag_user_name, b.yS().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fQt, d.C0107d.cp_cont_h, 1);
                        this.fQu.setVisibility(8);
                        if (fVar.aYG().yS() != null) {
                            if (fVar.aYG().yS().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fQy.setUserId(b.yS().getUserId());
                        this.fQy.setUserName(b.yS().getUserName());
                        this.fQy.setImageDrawable(null);
                        this.fQy.setRadius(com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds40));
                        this.fQy.setTag(b.yS().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        s = com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds16);
                        if (!this.fJw.baT()) {
                        }
                        this.bcz.setVisibility(8);
                        this.fQK.setVisibility(8);
                        this.fQH.setPadding(0, 0, s, 0);
                        bvL = b.bvL();
                        if (bvL == null) {
                        }
                        this.fQI.setVisibility(8);
                        this.fQJ.setVisibility(8);
                        portrait = b.yS().getPortrait();
                        if (b.yS().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fQy, b.yS());
                        this.fQy.setVisibility(0);
                        this.fQr.setOnClickListener(this.fSH);
                        this.fQt.setOnClickListener(this.fSH);
                        this.fQy.setOnClickListener(this.fSH);
                        this.fQw.setVisibility(8);
                        this.fQy.startLoad(portrait, 28, false);
                        String name_show2 = b.yS().getName_show();
                        String userName2 = b.yS().getUserName();
                        if (com.baidu.tbadk.o.ac.nu()) {
                            this.fQt.setText(com.baidu.tieba.pb.c.al(this.fJw.getPageContext().getPageActivity(), this.fQt.getText().toString()));
                            this.fQt.setGravity(16);
                            this.fQt.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYi());
                            com.baidu.tbadk.core.util.aj.e(this.fQt, d.C0107d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aX(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.yS().getIconInfo();
                            tShowInfoNew = b.yS().getTShowInfoNew();
                            if (this.fKE != null) {
                            }
                            if (this.fKD != null) {
                            }
                            this.fQt.setText(af(b.yS().getSealPrefix(), e));
                            this.fQt.setTag(d.g.tag_user_id, b.yS().getUserId());
                            this.fQt.setTag(d.g.tag_user_name, b.yS().getName_show());
                            if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.e(this.fQt, d.C0107d.cp_cont_h, 1);
                            this.fQu.setVisibility(8);
                            if (fVar.aYG().yS() != null) {
                            }
                            this.fQy.setUserId(b.yS().getUserId());
                            this.fQy.setUserName(b.yS().getUserName());
                            this.fQy.setImageDrawable(null);
                            this.fQy.setRadius(com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds40));
                            this.fQy.setTag(b.yS().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            s = com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds16);
                            if (!this.fJw.baT()) {
                            }
                            this.bcz.setVisibility(8);
                            this.fQK.setVisibility(8);
                            this.fQH.setPadding(0, 0, s, 0);
                            bvL = b.bvL();
                            if (bvL == null) {
                            }
                            this.fQI.setVisibility(8);
                            this.fQJ.setVisibility(8);
                            portrait = b.yS().getPortrait();
                            if (b.yS().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fQy, b.yS());
                            this.fQy.setVisibility(0);
                            this.fQr.setOnClickListener(this.fSH);
                            this.fQt.setOnClickListener(this.fSH);
                            this.fQy.setOnClickListener(this.fSH);
                            this.fQw.setVisibility(8);
                            this.fQy.startLoad(portrait, 28, false);
                            String name_show22 = b.yS().getName_show();
                            String userName22 = b.yS().getUserName();
                            if (com.baidu.tbadk.o.ac.nu()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.yS().getIconInfo();
                        tShowInfoNew = b.yS().getTShowInfoNew();
                        if (this.fKE != null) {
                        }
                        if (this.fKD != null) {
                        }
                        this.fQt.setText(af(b.yS().getSealPrefix(), e));
                        this.fQt.setTag(d.g.tag_user_id, b.yS().getUserId());
                        this.fQt.setTag(d.g.tag_user_name, b.yS().getName_show());
                        if (com.baidu.tbadk.core.util.v.E(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fQt, d.C0107d.cp_cont_h, 1);
                        this.fQu.setVisibility(8);
                        if (fVar.aYG().yS() != null) {
                        }
                        this.fQy.setUserId(b.yS().getUserId());
                        this.fQy.setUserName(b.yS().getUserName());
                        this.fQy.setImageDrawable(null);
                        this.fQy.setRadius(com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds40));
                        this.fQy.setTag(b.yS().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        s = com.baidu.adp.lib.util.l.s(this.fJw.getActivity(), d.e.ds16);
                        if (!this.fJw.baT()) {
                        }
                        this.bcz.setVisibility(8);
                        this.fQK.setVisibility(8);
                        this.fQH.setPadding(0, 0, s, 0);
                        bvL = b.bvL();
                        if (bvL == null) {
                        }
                        this.fQI.setVisibility(8);
                        this.fQJ.setVisibility(8);
                        portrait = b.yS().getPortrait();
                        if (b.yS().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fQy, b.yS());
                        this.fQy.setVisibility(0);
                        this.fQr.setOnClickListener(this.fSH);
                        this.fQt.setOnClickListener(this.fSH);
                        this.fQy.setOnClickListener(this.fSH);
                        this.fQw.setVisibility(8);
                        this.fQy.startLoad(portrait, 28, false);
                        String name_show222 = b.yS().getName_show();
                        String userName222 = b.yS().getUserName();
                        if (com.baidu.tbadk.o.ac.nu()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.fQq.W(fVar.aYG());
                }
                if (this.fRM != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fEa);
                    if (fVar != null && fVar.aYG() != null) {
                        jVar.fEc = fVar.aYG().yK();
                    }
                    jVar.btU = !this.fEW;
                    jVar.fEe = this.fJw.baS();
                    this.fRM.a(jVar);
                }
            }
        }
    }

    public void kv(boolean z) {
        if (z) {
            bdF();
        } else {
            bdG();
        }
        this.fRQ.fSZ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fRQ));
        a(this.fRQ.fSZ, false);
    }

    public void bdF() {
        if (this.fQh != null && !this.fSh) {
            this.fQh.kR(!StringUtils.isNull(this.fJw.bao()));
            this.fSh = true;
        }
    }

    public void bdG() {
        if (this.fQh != null) {
            this.fQh.beJ();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.zo() != null) {
            this.fQs.a(this.fJw.getPageContext(), fVar.aYI().get(0).zo(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aYE().getId(), fVar.aYE().getName(), fVar.aYG().getId(), this.fJw.baP() ? "FRS" : null));
            this.fQr.setPadding(this.fQr.getPaddingLeft(), (int) this.fJw.getResources().getDimension(d.e.ds20), this.fQr.getPaddingRight(), this.fQr.getPaddingBottom());
            return;
        }
        this.fQs.a(null, null, null);
    }

    public void bdH() {
        if (this.fQb != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").s("obj_type", 1));
            this.fQb.bfS();
            this.fQl.smoothScrollToPosition(0);
        }
    }

    public boolean bdI() {
        return this.fSI;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean Y(bd bdVar) {
        if (bdVar == null || bdVar.yS() == null || bdVar.yS().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.yS().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.fQh.beH();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.fQh.nS(eVar.forumName);
            }
            String string = this.fJw.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.h(eVar.source, 0)) {
                case 100:
                    str = this.fJw.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.fJw.getResources().getString(d.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fJw.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.fDl;
            this.fJw.showNetRefreshView(this.dmk, format, null, this.fJw.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.oZ()) {
                        com.baidu.tbadk.core.util.av.CZ().c(as.this.fJw.getPageContext(), new String[]{str2});
                        as.this.fJw.finish();
                        return;
                    }
                    as.this.fJw.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bcO;
        Parcelable bcO2;
        String str;
        if (fVar != null) {
            this.fMG = fVar;
            this.mType = i;
            if (fVar.aYG() != null) {
                this.fRS = fVar.aYG().yD();
                if (fVar.aYG().getAnchorLevel() != 0) {
                    this.fSI = true;
                }
                this.fRo = Y(fVar.aYG());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            r(fVar);
            this.fRC = false;
            this.fEW = z;
            bdB();
            b(fVar, z, i);
            p(fVar);
            if (this.fSt == null) {
                this.fSt = new ac(this.fJw.getPageContext(), this.dSo);
            }
            this.fSt.qf(fVar.aYL());
            if (this.fJw.baF()) {
                if (this.fQW == null) {
                    this.fQW = new com.baidu.tieba.pb.view.i(this.fJw.getPageContext());
                    this.fQW.su();
                    this.fQW.a(this.baR);
                }
                this.fQl.setPullRefresh(this.fQW);
                bdJ();
                if (this.fQW != null) {
                    this.fQW.gv(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.xY().xV() == 0 && z) {
                this.fQl.setPullRefresh(null);
            } else {
                if (this.fQW == null) {
                    this.fQW = new com.baidu.tieba.pb.view.i(this.fJw.getPageContext());
                    this.fQW.su();
                    this.fQW.a(this.baR);
                }
                this.fQl.setPullRefresh(this.fQW);
                bdJ();
                if (this.fQW != null) {
                    this.fQW.gv(TbadkCoreApplication.getInst().getSkinType());
                }
                aeY();
            }
            bdL();
            this.fQS.jE(this.fEW);
            this.fQS.jF(false);
            this.fQS.jQ(i == 5);
            this.fQS.jR(i == 6);
            this.fQS.jS(z2 && this.fSG);
            this.fQS.a(fVar, false);
            this.fQS.notifyDataSetChanged();
            if (this.fJw.baT()) {
                this.fSj = 0;
                PostData b = b(fVar, z);
                if (b != null && b.yS() != null) {
                    this.fSj = b.yS().getLevel_id();
                }
                if (this.fSj > 0) {
                    this.fQv.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.fQv, BitmapHelper.getGradeResourceIdInEnterForum(this.fSj));
                } else {
                    this.fQv.setVisibility(8);
                }
            } else {
                this.fQv.setVisibility(8);
            }
            if (fVar.aYG() != null) {
                if (fVar.aYG().yH() != null) {
                    if (fVar.aYG().yH().getNum() < 1) {
                        str = this.fJw.getResources().getString(d.j.zan);
                    } else {
                        str = fVar.aYG().yH().getNum() + "";
                    }
                    if (this.fQa != -1) {
                        fVar.aYG().yH().setIsLike(this.fQa);
                    }
                    S(str, fVar.aYG().yH().getIsLike() == 1);
                }
                if (fVar.aYG().aOZ != null && fVar.aYG().aOZ.isDeleted) {
                    this.fQh.kL(true);
                } else {
                    this.fQh.kL(false);
                }
            }
            if (this.fJw.isLogin()) {
                this.fQl.setNextPage(this.dFN);
                this.fQg = 2;
                aeY();
            } else {
                this.fRC = true;
                if (fVar.xY().xU() == 1) {
                    if (this.fQX == null) {
                        this.fQX = new com.baidu.tieba.pb.view.b(this.fJw.getPageContext());
                    }
                    this.fQl.setNextPage(this.fQX);
                } else {
                    this.fQl.setNextPage(this.dFN);
                }
                this.fQg = 3;
            }
            ArrayList<PostData> aYI = fVar.aYI();
            if (fVar.xY().xU() == 0 || aYI == null || aYI.size() < fVar.xY().xT()) {
                if (com.baidu.tbadk.core.util.v.D(aYI) == 0 || (com.baidu.tbadk.core.util.v.D(aYI) == 1 && aYI.get(0) != null && aYI.get(0).bvH() == 1)) {
                    this.dFN.setText(this.fJw.getResources().getString(d.j.list_no_more_new));
                    if (this.fJw.bag() != null && !this.fJw.bag().bey()) {
                        this.fJw.bag().showFloatingView();
                    }
                } else {
                    this.dFN.setText(this.fJw.getResources().getString(d.j.list_has_no_more));
                }
                if (this.fJw.baF() && this.fQl != null && this.fQl.getData() != null && this.fQl.getData().size() == 1 && (this.fQl.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.dFN.setText("");
                }
                bdS();
            } else if (z2) {
                if (this.fSG) {
                    DL();
                    if (fVar.xY().xU() != 0) {
                        this.dFN.setText(this.fJw.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.dFN.DG();
                    this.dFN.showLoading();
                }
            } else {
                this.dFN.DG();
                this.dFN.showLoading();
            }
            switch (i) {
                case 2:
                    this.fQl.setSelection(i2 > 1 ? (((this.fQl.getData() == null && fVar.aYI() == null) ? 0 : (this.fQl.getData().size() - fVar.aYI().size()) + this.fQl.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bcO2 = aj.bcN().bcO()) != null) {
                        this.fQl.onRestoreInstanceState(bcO2);
                        if (com.baidu.tbadk.core.util.v.D(aYI) > 1 && fVar.xY().xU() > 0) {
                            this.dFN.DL();
                            this.dFN.setText(this.fJw.getString(d.j.pb_load_more_without_point));
                            this.dFN.DH();
                            break;
                        }
                    } else {
                        this.fQl.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fSG = false;
                    break;
                case 5:
                    this.fQl.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bcO = aj.bcN().bcO()) != null) {
                        this.fQl.onRestoreInstanceState(bcO);
                        break;
                    } else {
                        this.fQl.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fQb != null && this.fQb.bfR() != null) {
                            if (this.fJw.isUseStyleImmersiveSticky()) {
                                this.fQl.setSelectionFromTop((this.fQS.bbi() + this.fQl.getHeaderViewsCount()) - 1, this.fQb.bfR().getHeight() - com.baidu.adp.lib.util.l.n(this.fJw.getPageContext().getPageActivity()));
                            } else {
                                this.fQl.setSelectionFromTop((this.fQS.bbi() + this.fQl.getHeaderViewsCount()) - 1, this.fQb.bfR().getHeight());
                            }
                        } else {
                            this.fQl.setSelection(this.fQS.bbi() + this.fQl.getHeaderViewsCount());
                        }
                    } else {
                        this.fQl.setSelection(i2 > 0 ? ((this.fQl.getData() == null && fVar.aYI() == null) ? 0 : (this.fQl.getData().size() - fVar.aYI().size()) + this.fQl.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dFN.DL();
                    this.dFN.setText(this.fJw.getString(d.j.pb_load_more_without_point));
                    this.dFN.DH();
                    break;
            }
            if (this.fRS == fRT && isHost()) {
                bea();
            }
            if (this.fSd) {
                bcZ();
                this.fSd = false;
                if (i3 == 0) {
                    ko(true);
                }
            }
            if (this.fQd != null) {
                this.fQd.ad(fVar.aYG());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.fDR == 1 || fVar.fDS == 1) {
                if (this.fSk == null) {
                    this.fSk = new PbTopTipView(this.fJw);
                }
                if (fVar.fDS == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fJw.getStType())) {
                    this.fSk.setText(this.fJw.getString(d.j.pb_read_strategy_add_experience));
                    this.fSk.show(this.dmk, this.mSkinType);
                } else if (fVar.fDR == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fJw.getStType())) {
                    this.fSk.setText(this.fJw.getString(d.j.pb_read_news_add_experience));
                    this.fSk.show(this.dmk, this.mSkinType);
                }
            }
        }
    }

    private void bdJ() {
        if (this.fQb != null && this.fQb.bfR() != null) {
            this.fQl.removeHeaderView(this.bmp);
            if (this.mType != 1) {
                this.fQl.removeHeaderView(this.fQb.bfT());
                this.fQl.addHeaderView(this.fQb.bfT(), 0);
                return;
            }
            return;
        }
        if (this.fQb != null) {
            this.fQl.removeHeaderView(this.fQb.bfT());
        }
        this.fQl.removeHeaderView(this.bmp);
        this.fQl.addHeaderView(this.bmp, 0);
    }

    public void kw(boolean z) {
        this.fRn = z;
    }

    public void DL() {
        if (this.dFN != null) {
            this.dFN.DH();
            this.dFN.DL();
        }
        aeY();
    }

    public void WN() {
        this.fQl.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.fRB != null && this.fRB.yS() != null && this.fQh != null) {
            this.fSg = !this.fSf;
            this.fQh.kK(this.fSg);
            if (this.fJw.bag() != null) {
                this.fJw.bag().kJ(this.fSg);
            }
            bdK();
            if (this.fSg) {
                this.fQh.fVi.setVisibility(0);
                if (this.fRo) {
                    this.fQh.fVj.setVisibility(8);
                    this.fQD.setVisibility(8);
                    this.fQG.setVisibility(0);
                    this.fQG.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(fVar.aZb())));
                } else if (!PbNormalLikeButtonSwitchStatic.Oi() || (this.fRB.yS().hadConcerned() && this.fRB.yS().getGodUserData() != null && this.fRB.yS().getGodUserData().getIsFromNetWork())) {
                    this.fQh.fVj.setVisibility(8);
                }
                if (this.fRL != null) {
                    this.fRL.setVisibility(8);
                }
                this.fQh.a(this.fRB.yS(), this.fSH);
                if (this.fSr == null) {
                    this.fSr = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.as.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > as.this.fSi) {
                                as.this.bdZ();
                            }
                        }
                    };
                }
                this.fQl.setListViewDragListener(this.fSr);
                return;
            }
            if (this.fQh.fVi != null) {
                this.fQh.fVi.setVisibility(8);
            }
            if (this.fRL != null) {
                this.fRL.setVisibility(0);
            }
            if (this.fRo) {
                this.fQD.setVisibility(8);
                this.fQG.setVisibility(0);
                this.fQG.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.F(fVar.aZb())));
            } else if (!PbNormalLikeButtonSwitchStatic.Oi() || (this.fRB.yS().hadConcerned() && this.fRB.yS().getGodUserData() != null && this.fRB.yS().getGodUserData().getIsFromNetWork())) {
                this.fQD.setVisibility(8);
                this.fQG.setVisibility(8);
            } else {
                this.fQG.setVisibility(8);
            }
            this.fSr = null;
            this.fQl.setListViewDragListener(null);
        }
    }

    private void bdK() {
        String threadId = this.fMG != null ? this.fMG.getThreadId() : "";
        if (this.fSg) {
            if (this.fQF == null) {
                this.fQF = new aq(this.fJw.getPageContext(), this.fQh.fVj, 3);
                this.fQF.h(this.fJw.getUniqueId());
            }
            if (this.fRB != null && this.fRB.yS() != null) {
                this.fRB.yS().setIsLike(this.fRB.yS().hadConcerned());
                this.fQF.a(this.fRB.yS());
            }
            this.fQF.cK(threadId);
            this.fQF.fPX = this.fSf;
        }
        if (this.fQE == null) {
            this.fQE = new aq(this.fJw.getPageContext(), this.fQD, 1);
            this.fQE.h(this.fJw.getUniqueId());
            this.fQE.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.as.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bu(boolean z) {
                    if (as.this.fJw != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(as.this.fJw, d.j.attention_success);
                            return;
                        }
                        ar.u(as.this.fJw.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fRB != null && this.fRB.yS() != null) {
            this.fRB.yS().setIsLike(this.fRB.yS().hadConcerned());
            this.fQE.a(this.fRB.yS());
            this.fQE.cK(threadId);
        }
        this.fQE.fPX = this.fSf;
    }

    private boolean bdL() {
        boolean z;
        if (this.fRr != null && this.fRr.getVisibility() == 0) {
            if (this.fQO != null) {
                this.fQO.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fQO != null) {
                this.fQO.setVisibility(8);
            }
            z = false;
        }
        if ((this.fQQ == null || this.fQQ.getVisibility() == 8) && z && this.fEW) {
            this.fQP.setVisibility(0);
        } else {
            this.fQP.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aYG() == null) {
            return false;
        }
        if (fVar.aYG().yP() == 1 || fVar.aYG().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aYG().yR() == null || fVar.aYG().yR().Ao() == 0) || fVar.aYG().yN() == 1 || fVar.aYG().yO() == 1 || fVar.aYG().zx() || fVar.aYG().zI() || fVar.aYG().zE() || fVar.aYG().zf() != null || fVar.aYG().zJ() || fVar.aYG().zJ() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aYG().getCategory()) || fVar.aYG().yW() || fVar.aYG().yV();
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return com.baidu.tieba.card.k.a((Context) this.fJw.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.fQn != null) {
                if (fVar.aYG() != null && fVar.aYG().zi() == 0 && !fVar.aYG().zF() && !this.fSv) {
                    this.fQn.setVisibility(0);
                    if (fVar.aYG() != null) {
                        fVar.aYG().h(true, q(fVar));
                    }
                    SpannableStringBuilder zs = fVar.aYG().zs();
                    this.fQo.setOnTouchListener(new com.baidu.tieba.view.m(zs));
                    if (this.fSs) {
                        this.fQo.setText(fVar.aYG().getTitle());
                    } else {
                        this.fQo.setText(zs);
                    }
                    this.fQo.setVisibility(0);
                } else if (fVar.aYG().zi() == 1) {
                    if (fVar.aYG() != null) {
                        this.fQn.setVisibility(8);
                        this.fQl.removeHeaderView(this.fQn);
                        if (fVar.aYG() != null && !fVar.aYG().zF()) {
                            this.fQr.setPadding(this.fQr.getPaddingLeft(), com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.tbds36), this.fQr.getPaddingRight(), this.fQr.getPaddingBottom());
                        }
                    }
                } else {
                    this.fQn.setVisibility(8);
                    this.fQl.removeHeaderView(this.fQn);
                    if (fVar.aYG() != null && fVar.aYG().zF()) {
                        this.fQr.setPadding(this.fQr.getPaddingLeft(), 0, this.fQr.getPaddingRight(), this.fQr.getPaddingBottom());
                    } else {
                        this.fQr.setPadding(this.fQr.getPaddingLeft(), com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds48), this.fQr.getPaddingRight(), this.fQr.getPaddingBottom());
                    }
                }
            }
            this.fEW = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            bdL();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.yS().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aYS()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.yS() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.yS().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aYS()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<ay> aZa = fVar.aZa();
                if (com.baidu.tbadk.core.util.v.D(aZa) > 0) {
                    sb = new StringBuilder();
                    for (ay ayVar : aZa) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.aMP) != null && tVar.aKW && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.k(ayVar.getForumName(), 12)).append(this.fJw.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fJw.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bxf;
    }

    public void qg(String str) {
        if (this.dFN != null) {
            this.dFN.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fQl;
    }

    public int bdM() {
        return d.g.richText;
    }

    public TextView bab() {
        return this.fQq.bab();
    }

    public void d(BdListView.e eVar) {
        this.fQl.setOnSrollToBottomListener(eVar);
    }

    public void a(j.b bVar) {
        this.baR = bVar;
        if (this.fQW != null) {
            this.fQW.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int xS = alVar.xS();
            int xP = alVar.xP();
            if (this.fQT != null) {
                this.fQT.AA();
            } else {
                this.fQT = new com.baidu.tbadk.core.dialog.a(this.fJw.getPageContext().getPageActivity());
                this.fQU = LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fQT.aO(this.fQU);
                this.fQT.a(d.j.dialog_ok, bVar);
                this.fQT.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        as.this.bdO();
                        aVar.dismiss();
                    }
                });
                this.fQT.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.as.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (as.this.fSa == null) {
                            as.this.fSa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    as.this.fJw.HidenSoftKeyPad((InputMethodManager) as.this.fJw.getSystemService("input_method"), as.this.dmk);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.nr().postDelayed(as.this.fSa, 150L);
                    }
                });
                this.fQT.b(this.fJw.getPageContext()).AA();
            }
            this.fQV = (EditText) this.fQU.findViewById(d.g.input_page_number);
            this.fQV.setText("");
            TextView textView = (TextView) this.fQU.findViewById(d.g.current_page_number);
            if (xS <= 0) {
                xS = 1;
            }
            if (xP <= 0) {
                xP = 1;
            }
            textView.setText(MessageFormat.format(this.fJw.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(xS), Integer.valueOf(xP)));
            this.fJw.ShowSoftKeyPadDelay(this.fQV, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fQl.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fJw.showToast(str);
    }

    public boolean kx(boolean z) {
        if (this.axN == null || !this.axN.Kx()) {
            return false;
        }
        this.axN.IE();
        return true;
    }

    public void bdN() {
        if (this.fSJ != null) {
            while (this.fSJ.size() > 0) {
                TbImageView remove = this.fSJ.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bdN();
        this.fQS.sJ(1);
        if (this.fQb != null) {
            this.fQb.onPause();
        }
    }

    public void onResume() {
        this.fQS.sJ(2);
        if (this.fQb != null) {
            this.fQb.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fSc != null) {
            this.fSc.destroy();
        }
        if (this.fSt != null) {
            this.fSt.onDestory();
        }
        if (this.fSk != null) {
            this.fSk.hide();
        }
        if (this.fQe != null) {
            this.fQe.amr();
        }
        if (this.fQd != null) {
            this.fQd.onDestroy();
        }
        this.fJw.hideProgressBar();
        if (this.dmi != null && this.dzq != null) {
            this.dmi.b(this.dzq);
        }
        bdO();
        DL();
        if (this.fSa != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.fSa);
        }
        if (this.fQr != null && this.fQC != null) {
            this.fQr.removeView(this.fQx);
            this.fQC = null;
        }
        if (this.fRG != null) {
            this.fRG.clearStatus();
        }
        this.fSC = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fQS.sJ(3);
        if (this.dCY != null) {
            this.dCY.setBackgroundDrawable(null);
        }
        if (this.fQb != null) {
            this.fQb.destroy();
        }
        if (this.fQS != null) {
            this.fQS.onDestory();
        }
        this.fQl.setOnLayoutListener(null);
        if (this.fSp != null) {
            this.fSp.avN();
        }
        if (this.fRR != null) {
            this.fRR.onDestroy();
        }
        bel();
    }

    public boolean sZ(int i) {
        if (this.fQb != null) {
            return this.fQb.ne(i);
        }
        return false;
    }

    public void bdO() {
        this.fQh.vT();
        if (this.fQe != null) {
            this.fQe.amr();
        }
        com.baidu.adp.lib.util.l.a(this.fJw.getPageContext().getPageActivity(), this.fQV);
        bdc();
        if (this.fRl != null) {
            this.fRl.dismiss();
        }
        bdQ();
        if (this.fQd != null) {
            this.fQd.bfK();
        }
        if (this.fQT != null) {
            this.fQT.dismiss();
        }
        if (this.dCK != null) {
            this.dCK.dismiss();
        }
    }

    public void bdP() {
        this.fQh.vT();
        if (this.fQe != null) {
            this.fQe.amr();
        }
        if (this.fRl != null) {
            this.fRl.dismiss();
        }
        bdQ();
        if (this.fQd != null) {
            this.fQd.bfK();
        }
        if (this.fQT != null) {
            this.fQT.dismiss();
        }
        if (this.dCK != null) {
            this.dCK.dismiss();
        }
    }

    public void cQ(List<String> list) {
        this.fSo = list;
        if (this.fSp != null) {
            this.fSp.setData(list);
        }
    }

    public void jD(boolean z) {
        this.fQS.jD(z);
    }

    public void ky(boolean z) {
        this.fRq = z;
    }

    public void bdQ() {
        if (this.fRc != null) {
            this.fRc.dismiss();
        }
        if (this.fRd != null) {
            com.baidu.adp.lib.g.g.b(this.fRd, this.fJw.getPageContext());
        }
        if (this.fRe != null) {
            com.baidu.adp.lib.g.g.b(this.fRe, this.fJw.getPageContext());
        }
        if (this.fRa != null) {
            com.baidu.adp.lib.g.g.b(this.fRa, this.fJw.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fMG, this.fEW);
            d(this.fMG, this.fEW, this.mType);
            this.fJw.getLayoutMode().aM(i == 1);
            this.fJw.getLayoutMode().aM(this.dmk);
            this.fJw.getLayoutMode().aM(this.fQm);
            com.baidu.tbadk.core.util.aj.s(this.fQp, d.C0107d.cp_bg_line_d);
            if (this.fQd != null) {
                this.fQd.onChangeSkinType(i);
            }
            if (this.fQo != null) {
                com.baidu.tbadk.core.util.aj.r(this.fQo, d.C0107d.cp_cont_b);
                this.fQo.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_link_tip_c));
            }
            if (this.dFN != null) {
                this.dFN.gv(i);
                if (this.bxf != null) {
                    this.fJw.getLayoutMode().aM(this.bxf);
                    com.baidu.tbadk.core.util.aj.s(this.bxf, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fQT != null) {
                this.fQT.c(this.fJw.getPageContext());
            }
            kw(this.fRn);
            this.fQS.notifyDataSetChanged();
            if (this.fQW != null) {
                this.fQW.gv(i);
            }
            if (this.axN != null) {
                this.axN.onChangeSkinType(i);
            }
            if (this.fQB != null) {
                this.fQB.gz(i);
            }
            if (this.fQX != null) {
                this.fQX.gv(i);
            }
            if (!com.baidu.tbadk.core.util.v.E(this.cWg)) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.cWg) {
                    aVar.Du();
                }
            }
            ks(i == 1);
            bdq();
            UtilHelper.setStatusBarBackground(this.dCY, i);
            UtilHelper.setStatusBarBackground(this.fRL, i);
            if (this.fQD != null) {
                this.fQD.onChangeSkinType(i);
            }
            if (this.fQI != null) {
                com.baidu.tbadk.core.util.aj.r(this.fQI, d.C0107d.cp_cont_d);
            }
            if (this.fQH != null) {
                com.baidu.tbadk.core.util.aj.r(this.fQH, d.C0107d.cp_cont_d);
            }
            if (this.fQJ != null) {
                com.baidu.tbadk.core.util.aj.s(this.fQJ, d.C0107d.cp_cont_e);
            }
            if (this.bcz != null) {
                com.baidu.tbadk.core.util.aj.r(this.bcz, d.C0107d.cp_cont_d);
            }
            if (this.fQK != null) {
                com.baidu.tbadk.core.util.aj.s(this.fQK, d.C0107d.cp_cont_e);
            }
            if (this.fQu != null) {
                com.baidu.tbadk.core.util.aj.r(this.fQu, d.C0107d.cp_link_tip_a);
            }
            if (this.fQG != null) {
                com.baidu.tbadk.core.util.aj.r(this.fQG, d.C0107d.cp_cont_d);
            }
            if (this.fQL != null) {
                com.baidu.tbadk.n.a.a(this.fJw.getPageContext(), this.fQL);
            }
            if (this.fRj != null) {
                com.baidu.tbadk.n.a.a(this.fJw.getPageContext(), this.fRj);
            }
            if (this.fSb != null) {
                this.fSb.onChangeSkinType(i);
            }
            if (this.fQh != null) {
                if (this.fQb != null) {
                    this.fQb.tf(i);
                } else {
                    this.fQh.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fRt != null) {
                com.baidu.tbadk.core.util.aj.r(this.fRt, d.C0107d.cp_cont_e);
            }
            if (this.fQv != null) {
                com.baidu.tbadk.core.util.aj.c(this.fQv, BitmapHelper.getGradeResourceIdInEnterForum(this.fSj));
            }
            if (this.fSq != null) {
                this.fSq.onChangeSkinType(i);
            }
            if (this.fRR != null) {
                this.fRR.onChangeSkinType();
            }
            if (this.fSn != null) {
                com.baidu.tbadk.core.util.aj.r(this.fSn, d.C0107d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJF = hVar;
        this.fQS.setOnImageClickListener(this.bJF);
        this.fSq.setOnImageClickListener(this.bJF);
    }

    public void h(NoNetworkView.a aVar) {
        this.dzq = aVar;
        if (this.dmi != null) {
            this.dmi.a(this.dzq);
        }
    }

    public void kz(boolean z) {
        this.fQS.setIsFromCDN(z);
    }

    public Button bdR() {
        return this.fRr;
    }

    public void bdS() {
        if (this.fQg != 2) {
            this.fQl.setNextPage(this.dFN);
            this.fQg = 2;
        }
    }

    public void bdT() {
        if (com.baidu.tbadk.k.r.NO().NP()) {
            int lastVisiblePosition = this.fQl.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fQl.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog = tbImageView.getPerfLog();
                                perfLog.im(1001);
                                perfLog.byn = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.k.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.im(1001);
                        perfLog2.byn = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bdU() {
        return this.axN != null && this.axN.getVisibility() == 0;
    }

    public boolean bdV() {
        return this.axN != null && this.axN.Kx();
    }

    public void bdW() {
        if (this.axN != null) {
            this.axN.IE();
        }
    }

    public void kA(boolean z) {
        if (this.fRs != null) {
            ky(this.fJw.bac().KY());
            if (this.fRq) {
                kp(z);
            } else {
                kq(z);
            }
        }
    }

    public void bdX() {
        if (this.fRs != null) {
            this.fRs.setVisibility(8);
            this.fRx = false;
            if (this.fRR != null) {
                this.fRR.setVisibility(8);
                ku(false);
            }
            bel();
        }
    }

    public void showLoadingDialog() {
        if (this.ddw == null) {
            this.ddw = new com.baidu.tbadk.core.view.b(this.fJw.getPageContext());
        }
        this.ddw.bm(true);
    }

    public void aeY() {
        if (this.ddw != null) {
            this.ddw.bm(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fQl.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fQl.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fQb != null) {
            this.fQb.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.fhC = getScrollY();
            this.fRQ.fSZ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fRQ));
            a(this.fRQ.fSZ, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fQb != null) {
            this.fQb.b(absListView, i);
        }
        int headerViewsCount = (i - this.fQl.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fQS.sI(headerViewsCount) == com.baidu.tieba.pb.data.l.fEh) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fQl.getHeaderViewsCount();
        if (this.fQp != null && this.fQh != null) {
            this.fQh.i(this.fQp.getBottom(), this.fQp.getMeasuredHeight(), z2);
        }
        this.fQS.bbm().m(z, this.fRJ != null ? this.fRJ.getMeasuredHeight() : 0);
        this.fRQ.fyV = i;
        this.fRQ.fSY = this.fQl.getHeaderViewsCount();
        this.fRQ.fSZ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fRQ));
        a(this.fRQ.fSZ, false);
    }

    public void bdY() {
        if (this.fJw.isLogin() && this.fMG != null && this.fSg && !this.fSf && !this.fRo && this.fRB != null && this.fRB.yS() != null && !this.fRB.yS().getIsLike() && !this.fRB.yS().hadConcerned()) {
            if (this.fSc == null) {
                this.fSc = new an(this.fJw);
            }
            this.fSc.a(this.fQh.fVi, this.fMG.aZe(), this.fRB.yS().getUserId(), this.fMG.getThreadId());
        }
    }

    public void bdZ() {
        if (this.fSg && !this.fSf && this.fRB != null && this.fRB.yS() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").s("obj_locate", this.fJw.baT() ? 2 : 1).s("obj_type", this.fSf ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fJw.getPageContext().getPageActivity(), this.fRB.yS().getUserId(), this.fRB.yS().getUserName(), this.fJw.aZO().bbE(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fSf && this.fRK != null && this.fQh.beC() != null) {
            int bbj = this.fQS.bbj();
            if (bbj > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bbj > this.fQl.getFirstVisiblePosition() - this.fQl.getHeaderViewsCount()) {
                    this.fRK.setVisibility(8);
                    return;
                }
                this.fRK.setVisibility(0);
                this.fQh.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fPx == null) {
                if (this.fQl.getFirstVisiblePosition() == 0) {
                    this.fRK.setVisibility(8);
                    this.fQh.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fRP) {
                        this.fRO = top;
                        this.fRP = false;
                    }
                    this.fRO = top < this.fRO ? top : this.fRO;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fQR.getY() < 0.0f) {
                        measuredHeight = fRN - alVar.fPx.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fQh.beC().getMeasuredHeight() - alVar.fPx.getMeasuredHeight();
                        this.fQh.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fRO) {
                        this.fRK.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fRK.setVisibility(0);
                    } else {
                        this.fRK.setVisibility(8);
                        this.fQh.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fRP = true;
                    }
                }
            }
        }
    }

    public void bea() {
        if (!this.fSK) {
            TiebaStatic.log("c10490");
            this.fSK = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fJw.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fRU, Integer.valueOf(fRW));
            aVar.fa(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.aO(inflate);
            aVar.aE(sparseArray);
            aVar.a(d.j.grade_button_tips, this.fJw);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fJw.getPageContext()).AA();
        }
    }

    public void qh(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fJw.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fRU, Integer.valueOf(fRX));
        aVar.aE(sparseArray);
        aVar.a(d.j.view, this.fJw);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fJw.getPageContext()).AA();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.yS() != null) {
            MetaData yS = b.yS();
            yS.setGiftNum(yS.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
        p(fVar);
    }

    public PbInterviewStatusView beb() {
        return this.fRG;
    }

    private void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aYG() != null && fVar.aYG().zI() && this.fRG == null) {
            this.fRG = (PbInterviewStatusView) this.fRF.inflate();
            this.fRG.setOnClickListener(this.dCL);
            this.fRG.setCallback(this.fJw.baO());
            this.fRG.c(this.fJw, fVar);
        }
    }

    public LinearLayout bec() {
        return this.fQR;
    }

    public View bed() {
        return this.dCY;
    }

    public boolean bee() {
        return this.fSv;
    }

    public void jI(boolean z) {
        this.fQq.jI(z);
    }

    private void bef() {
        if (this.fSv) {
            if (this.fSw == null) {
                e.a aVar = e.fGQ.get();
                if (aVar != null) {
                    this.fSw = aVar.a(this.fJw);
                    com.baidu.adp.widget.ListView.e adapter = this.fQl.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.bmp) {
                            this.fQl.addHeaderView(this.fSw.aZZ(), 1);
                        } else {
                            this.fQl.addHeaderView(this.fSw.aZZ(), 0);
                        }
                    }
                } else {
                    this.fQp.setVisibility(0);
                    return;
                }
            }
            this.fQp.setVisibility(8);
            this.fQl.removeHeaderView(this.fQp);
            return;
        }
        this.fQp.setVisibility(0);
    }

    public void kB(boolean z) {
        this.fSv = z;
    }

    public void beg() {
        this.fJw.showNetRefreshView(getView(), "");
        View Mh = this.fJw.getRefreshView().Mh();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Mh.getLayoutParams();
        layoutParams.addRule(3, bec().getId());
        Mh.setLayoutParams(layoutParams);
        this.fJw.hideLoadingView(getView());
        if (this.fSw != null) {
            this.fQl.removeHeaderView(this.fSw.aZZ());
            this.fSw = null;
        }
    }

    public void qi(String str) {
        if (this.fQi != null) {
            this.fQi.setTitle(str);
        }
    }

    private int kC(boolean z) {
        if (this.fRG == null || this.fRG.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void beh() {
        if (this.fRG != null && this.fRG.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRG.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fRG.setLayoutParams(layoutParams);
        }
    }

    public boolean bai() {
        return false;
    }

    public void qj(String str) {
        this.fRt.performClick();
        if (!StringUtils.isNull(str) && this.fJw.bac() != null && this.fJw.bac().KS() != null && this.fJw.bac().KS().getInputView() != null) {
            EditText inputView = this.fJw.bac().KS().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bdO();
            if (configuration.orientation == 2) {
                bdX();
                bdc();
            } else {
                bdf();
            }
            if (this.fSb != null) {
                this.fSb.bbq();
            }
            this.fJw.auo();
            this.fQR.setVisibility(8);
            this.fQh.kN(false);
            this.fJw.jO(false);
            if (this.fQb != null) {
                if (configuration.orientation == 1) {
                    bec().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fQl.setIsLandscape(true);
                    this.fQl.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fQl.setIsLandscape(false);
                    if (this.fhC > 0) {
                        this.fQl.smoothScrollBy(this.fhC, 0);
                    }
                }
                this.fQb.onConfigurationChanged(configuration);
            }
        }
    }

    public void kD(boolean z) {
        this.fQf = z;
    }

    public boolean bei() {
        return this.fQb != null && this.fQb.bei();
    }

    public void bej() {
        if (this.fQb != null) {
            this.fQb.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fQd != null) {
            this.fQd.y(j, i);
        }
        if (this.fQb != null) {
            this.fQb.y(j, i);
        }
    }

    public void jT(boolean z) {
        this.fQS.jT(z);
    }

    public void bek() {
        if (this.fRH == null) {
            LayoutInflater.from(this.fJw.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.dmk, true);
            this.fRH = (ViewGroup) this.dmk.findViewById(d.g.add_experienced_layout);
            this.fRI = (TextView) this.dmk.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.r(this.fRI, d.C0107d.cp_cont_i);
            String string = this.fJw.getResources().getString(d.j.experienced_add_success);
            String string2 = this.fJw.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_cont_h)));
            this.fRI.setText(spannableString);
        }
        this.fRH.setVisibility(0);
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
                        as.this.fRH.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                as.this.fRI.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fRI.startAnimation(scaleAnimation);
    }

    public void cA(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fRs.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fJw);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fSn = new TextView(this.fJw);
            this.fSn.setText(d.j.connection_tips);
            this.fSn.setGravity(17);
            this.fSn.setPadding(com.baidu.adp.lib.util.l.s(this.fJw, d.e.ds24), 0, com.baidu.adp.lib.util.l.s(this.fJw, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.s(this.fJw, d.e.ds60);
            if (this.fSn.getParent() == null) {
                frameLayout.addView(this.fSn, layoutParams);
            }
            this.fSm = new PopupWindow(this.fJw);
            this.fSm.setContentView(frameLayout);
            this.fSm.setHeight(-2);
            this.fSm.setWidth(-2);
            this.fSm.setFocusable(true);
            this.fSm.setOutsideTouchable(false);
            this.fSm.setBackgroundDrawable(new ColorDrawable(this.fJw.getResources().getColor(d.C0107d.transparent)));
            this.fQl.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        as.this.fSm.showAsDropDown(as.this.fRs, view.getLeft(), -as.this.fRs.getHeight());
                    } else {
                        as.this.fSm.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.beu() != null && !StringUtils.isNull(aVar.beu().pkg_id) && !StringUtils.isNull(aVar.beu().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fRu != null && this.fRu.getVisibility() == 0) {
            if (this.fSl == null) {
                View inflate = LayoutInflater.from(this.fJw.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dCL);
                this.fSl = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fRu.getLocationInWindow(iArr);
            this.fSl.showAtLocation(this.fRu, 0, iArr[0] - com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fRu.getHeight()) - com.baidu.adp.lib.util.l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void bel() {
        com.baidu.adp.lib.g.g.b(this.fSl);
    }

    public void setIsInterviewLive(boolean z) {
        this.fSs = z;
    }

    public boolean getIsInterviewLive() {
        return this.fSs;
    }

    public void cB(View view) {
        this.fRj = view;
    }
}
