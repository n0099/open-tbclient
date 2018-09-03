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
import com.baidu.tieba.f;
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
    private TextView aIr;
    private View aTf;
    private g.b awt;
    private TextView ayn;
    private com.baidu.tieba.pb.a.c bgf;
    private List<CustomBlueCheckRadioButton> cBh;
    private View cFo;
    private NoNetworkView cSv;
    private RelativeLayout cSx;
    private NavigationBarCoverTip dHm;
    private com.baidu.tieba.NEGFeedBack.e dKk;
    private View.OnClickListener dog;
    private View dov;
    private PbListView drz;
    private com.baidu.tieba.pb.data.d fAT;
    private com.baidu.tieba.c.d fEA;
    public final com.baidu.tieba.pb.pb.main.view.b fED;
    public com.baidu.tieba.pb.pb.main.view.a fEE;
    private ViewStub fEF;
    private ViewStub fEG;
    private PbLandscapeListView fEH;
    private View fEI;
    private LinearLayout fEL;
    private e fEM;
    private ColumnLayout fEN;
    private ThreadSkinView fEO;
    private TextView fEP;
    private TextView fEQ;
    private ImageView fER;
    private HeadPendantView fES;
    private FrameLayout fET;
    private HeadImageView fEU;
    private View fEV;
    private FloatingLayout fEW;
    private PbFirstFloorUserLikeButton fEZ;
    public int fEw;
    private com.baidu.tieba.pb.video.i fEx;
    private long fEy;
    private com.baidu.tieba.pb.video.h fEz;
    private View fFO;
    private TextView fFP;
    private ImageView fFQ;
    private ImageView fFR;
    private TextView fFS;
    private boolean fFU;
    private int fFV;
    private int fFW;
    private PostData fFX;
    private View fFZ;
    private ar fFa;
    private ar fFb;
    private TextView fFc;
    private TextView fFd;
    private TextView fFe;
    private View fFf;
    private View fFg;
    private LinearLayout fFh;
    private TextView fFi;
    private TextView fFj;
    private View fFk;
    private View fFl;
    private ObservedChangeLinearLayout fFn;
    private f fFo;
    private View fFu;
    private int fGE;
    private PbTopTipView fGG;
    private PopupWindow fGH;
    private PopupWindow fGI;
    private TextView fGJ;
    private List<String> fGK;
    private com.baidu.tieba.pb.pb.main.emotion.c fGL;
    private com.baidu.tieba.pb.pb.godreply.a fGM;
    private PbLandscapeListView.b fGN;
    private ac fGP;
    private boolean fGR;
    private com.baidu.tbadk.core.view.userLike.c fGS;
    private com.baidu.tbadk.core.view.userLike.c fGT;
    private Runnable fGY;
    private TextView fGa;
    private ViewStub fGb;
    private PbInterviewStatusView fGc;
    private ViewGroup fGd;
    private TextView fGe;
    private FrameLayout fGf;
    private View fGg;
    private View fGh;
    private al fGi;
    private PbEmotionBar fGn;
    private int fGv;
    private Runnable fGw;
    private s fGx;
    private an fGy;
    private PbActivity.b fHa;
    private int fHf;
    PbActivity.d fwr;
    private View.OnClickListener fxK;
    private PbActivity fxm;
    private UserIconBox fyB;
    private UserIconBox fyC;
    private PbFakeFloorModel fzN;
    private boolean isLandscape;
    private int mType;
    private static final int fGj = UtilHelper.getLightStatusBarHeight();
    public static int fGp = 3;
    public static int fGq = 0;
    public static int fGr = 3;
    public static int fGs = 4;
    public static int fGt = 5;
    public static int fGu = 6;
    private static a.InterfaceC0234a fGQ = new a.InterfaceC0234a() { // from class: com.baidu.tieba.pb.pb.main.at.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
        }
    };
    private boolean fEB = false;
    private int fEC = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fEJ = null;
    private TextView fEK = null;
    public FrsPraiseView fEX = null;
    private ClickableHeaderImageView fEY = null;
    private View fFm = null;
    private com.baidu.tbadk.core.dialog.a fFp = null;
    private com.baidu.tbadk.core.dialog.b dof = null;
    private View fFq = null;
    private EditText fFr = null;
    private com.baidu.tieba.pb.view.e fFs = null;
    private com.baidu.tieba.pb.view.a fFt = null;
    private com.baidu.tbadk.core.dialog.a fFv = null;
    private b.InterfaceC0101b evK = null;
    private TbRichTextView.h bge = null;
    private NoNetworkView.a dkd = null;
    private Dialog fFw = null;
    private View fFx = null;
    private com.baidu.tbadk.core.dialog.a fFy = null;
    private Dialog fFz = null;
    private Dialog fFA = null;
    private View fFB = null;
    private LinearLayout fFC = null;
    private CompoundButton.OnCheckedChangeListener cBi = null;
    private TextView fFD = null;
    private TextView fFE = null;
    private View fFF = null;
    private String fFG = null;
    private com.baidu.tbadk.core.dialog.b fFH = null;
    private com.baidu.tbadk.core.dialog.b fFI = null;
    private boolean fFJ = false;
    private boolean fFK = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fFL = null;
    private boolean fFM = false;
    private Button fFN = null;
    private boolean fFT = true;
    private com.baidu.tbadk.core.view.a cIE = null;
    private boolean fxD = false;
    private int mSkinType = 3;
    private boolean fFY = false;
    private int fGk = 0;
    private boolean fGl = true;
    private a fGm = new a();
    private int fGo = 0;
    private boolean fGz = false;
    private int fGA = 0;
    private boolean fGB = false;
    private boolean fGC = false;
    private boolean fGD = false;
    private int fGF = 0;
    private boolean fGO = false;
    private String fGU = null;
    private CustomMessageListener fGV = new CustomMessageListener(2921306) { // from class: com.baidu.tieba.pb.pb.main.at.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                at.this.fGU = null;
            }
        }
    };
    private CustomMessageListener bxA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.pb.pb.main.at.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && at.this.fFo != null) {
                at.this.fFo.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fGW = new CustomMessageListener(2004018) { // from class: com.baidu.tieba.pb.pb.main.at.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (at.this.fEK != null) {
                at.this.fEK.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fGX = new Handler();
    private CustomMessageListener fGZ = new CustomMessageListener(2004009) { // from class: com.baidu.tieba.pb.pb.main.at.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                at.this.fFT = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fHb = true;
    View.OnClickListener fHc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (at.this.fGB) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").r(VideoPlayActivityConfig.OBJ_ID, 2));
            }
            if (at.this.fED != null && at.this.fED.fJF != null && view == at.this.fED.fJF.getHeadView()) {
                if (at.this.fED.fJD == null || at.this.fED.fJD.getAlpha() >= 0.3d) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12506").r("obj_locate", 2));
                } else {
                    return;
                }
            }
            if (!at.this.fGB && at.this.fAT != null && at.this.fAT.aZi() != null && at.this.fAT.aZi().vj() != null && at.this.fAT.aZi().vj().isBigV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").r("obj_locate", 1));
            }
            at.this.fxm.fvp.fIO.onClick(view);
        }
    };
    private boolean fHd = false;
    String userId = null;
    private final List<TbImageView> fHe = new ArrayList();
    private boolean fHg = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fHu;
        public al fHv;
        public int fod;
    }

    public void ke(boolean z) {
        this.fGz = z;
        if (this.fEH != null) {
            this.fGA = this.fEH.getHeaderViewsCount();
        }
    }

    public void bdx() {
        if (this.fEH != null) {
            int headerViewsCount = this.fEH.getHeaderViewsCount() - this.fGA;
            final int firstVisiblePosition = (this.fEH.getFirstVisiblePosition() == 0 || this.fEH.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fEH.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fEH.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fGm.fHv = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGm));
            final al alVar = this.fGm.fHv;
            final int h = h(alVar);
            final int y = ((int) this.fFn.getY()) + this.fFn.getMeasuredHeight();
            final boolean z = this.fGg.getVisibility() == 0;
            boolean z2 = this.fFn.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fFo.bbI() + this.fEH.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fDL.getMeasuredHeight() : 0;
                if (z2) {
                    this.fEH.setSelectionFromTop(this.fFo.bbI() + this.fEH.getHeaderViewsCount(), fGj - measuredHeight);
                } else {
                    this.fEH.setSelectionFromTop(this.fFo.bbI() + this.fEH.getHeaderViewsCount(), this.fED.bfa().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fEH.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fGB) {
                this.fEH.setSelectionFromTop(this.fFo.bbI() + this.fEH.getHeaderViewsCount(), this.fEx.bgq().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fEH.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.at.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bbZ() {
                        if (h >= 0 && h <= at.this.cSx.getMeasuredHeight()) {
                            int h2 = at.this.h(alVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = at.this.cFo.getLayoutParams();
                            if (i == 0 || i > at.this.cSx.getMeasuredHeight() || h2 >= at.this.cSx.getMeasuredHeight()) {
                                layoutParams.height = at.this.fGv;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > at.this.cSx.getMeasuredHeight()) {
                                layoutParams.height = at.this.fGv;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                at.this.fEH.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            at.this.cFo.setLayoutParams(layoutParams);
                        }
                        at.this.fEH.setOnLayoutListener(null);
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

    public NoNetworkView bdy() {
        return this.cSv;
    }

    public void bdz() {
        if (this.Qg != null) {
            this.Qg.hide();
            if (this.fGL != null) {
                this.fGL.SP();
            }
        }
    }

    public PbFakeFloorModel bdA() {
        return this.fzN;
    }

    public s bdB() {
        return this.fGx;
    }

    public void bdC() {
        reset();
        bdz();
        this.fGx.bbP();
        kq(false);
    }

    private void reset() {
        if (this.fxm != null && this.fxm.baA() != null && this.Qg != null) {
            com.baidu.tbadk.editortools.pb.a.HP().setStatus(0);
            com.baidu.tbadk.editortools.pb.d baA = this.fxm.baA();
            baA.Ii();
            baA.HD();
            if (baA.getWriteImagesInfo() != null) {
                baA.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            baA.eT(SendView.ALL);
            baA.eU(SendView.ALL);
            com.baidu.tbadk.editortools.g eK = this.Qg.eK(23);
            com.baidu.tbadk.editortools.g eK2 = this.Qg.eK(2);
            com.baidu.tbadk.editortools.g eK3 = this.Qg.eK(5);
            if (eK2 != null) {
                eK2.oC();
            }
            if (eK3 != null) {
                eK3.oC();
            }
            if (eK != null) {
                eK.hide();
            }
            this.Qg.invalidate();
        }
    }

    public boolean bdD() {
        return this.fFT;
    }

    public void kf(boolean z) {
        if (this.fFO != null && this.fFP != null) {
            this.fFP.setText(f.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fFO.startAnimation(alphaAnimation);
            }
            this.fFO.setVisibility(0);
            this.fFT = true;
            if (this.fGn != null && !this.fGM.isActive()) {
                this.fGn.setVisibility(0);
                kk(true);
            }
        }
    }

    public void kg(boolean z) {
        if (this.fFO != null && this.fFP != null) {
            this.fFP.setText(f.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fFO.startAnimation(alphaAnimation);
            }
            this.fFO.setVisibility(0);
            this.fFT = true;
            if (this.fGn != null && !this.fGM.isActive()) {
                this.fGn.setVisibility(0);
                kk(true);
            }
        }
    }

    public PostData bdE() {
        int i = 0;
        if (this.fEH == null) {
            return null;
        }
        int bdF = bdF() - this.fEH.getHeaderViewsCount();
        if (bdF < 0) {
            bdF = 0;
        }
        if (this.fFo.qx(bdF) != null && this.fFo.qx(bdF) != PostData.gNV) {
            i = bdF + 1;
        }
        return this.fFo.getItem(i) instanceof PostData ? (PostData) this.fFo.getItem(i) : null;
    }

    public int bdF() {
        int i;
        View childAt;
        if (this.fEH == null) {
            return 0;
        }
        int firstVisiblePosition = this.fEH.getFirstVisiblePosition();
        int lastVisiblePosition = this.fEH.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fEH.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fEH.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bdG() {
        return this.fEH.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fAT != null && this.fAT.aZk() != null && !this.fAT.aZk().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fAT.aZk().size() && (postData = this.fAT.aZk().get(i)) != null && postData.vj() != null && !StringUtils.isNull(postData.vj().getUserId()); i++) {
                if (this.fAT.aZk().get(i).vj().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fGM != null && this.fGM.isActive()) {
                        kq(false);
                    }
                    if (this.fGn != null) {
                        this.fGn.kx(true);
                    }
                    this.fGU = postData.vj().getName_show();
                    return;
                }
            }
        }
    }

    public at(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fxm = null;
        this.cSx = null;
        this.dov = null;
        this.fEy = 0L;
        this.fEH = null;
        this.fEI = null;
        this.fEL = null;
        this.fEN = null;
        this.fEP = null;
        this.fEQ = null;
        this.fET = null;
        this.fEU = null;
        this.fEV = null;
        this.fEZ = null;
        this.fFc = null;
        this.fFd = null;
        this.fFe = null;
        this.fFf = null;
        this.fFk = null;
        this.fFl = null;
        this.fFo = null;
        this.drz = null;
        this.aTf = null;
        this.dog = null;
        this.fxK = null;
        this.fFO = null;
        this.fFP = null;
        this.fFQ = null;
        this.fFR = null;
        this.fFS = null;
        this.fFZ = null;
        this.fGa = null;
        this.fGb = null;
        this.fGE = 0;
        this.fEy = System.currentTimeMillis();
        this.fxm = pbActivity;
        this.dog = onClickListener;
        this.bgf = cVar;
        this.fGE = com.baidu.adp.lib.util.l.ah(this.fxm) / 2;
        this.cSx = (RelativeLayout) LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.new_pb_activity, (ViewGroup) null);
        this.fxm.addContentView(this.cSx, new FrameLayout.LayoutParams(-1, -1));
        this.dHm = (NavigationBarCoverTip) this.fxm.findViewById(f.g.pb_multi_forum_del_tip_view);
        this.dov = this.fxm.findViewById(f.g.statebar_view);
        this.fFn = (ObservedChangeLinearLayout) this.fxm.findViewById(f.g.title_wrapper);
        this.cSv = (NoNetworkView) this.fxm.findViewById(f.g.view_no_network);
        this.fEH = (PbLandscapeListView) this.fxm.findViewById(f.g.new_pb_list);
        this.fGf = (FrameLayout) this.fxm.findViewById(f.g.root_float_header);
        this.aIr = new TextView(this.fxm.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds88));
        this.fEH.addHeaderView(this.aIr, 0);
        this.fGv = this.fxm.getResources().getDimensionPixelSize(f.e.tbds134);
        this.cFo = new View(this.fxm.getPageContext().getPageActivity());
        this.cFo.setLayoutParams(new AbsListView.LayoutParams(-1, this.fGv));
        this.cFo.setVisibility(4);
        this.fEH.addFooterView(this.cFo);
        this.fEH.setOnTouchListener(this.fxm.aWF);
        this.fED = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
        if (this.fxm.bbc()) {
            this.fEF = (ViewStub) this.fxm.findViewById(f.g.manga_view_stub);
            this.fEF.setVisibility(0);
            this.fEE = new com.baidu.tieba.pb.pb.main.view.a(pbActivity);
            this.fEE.show();
            this.fED.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds120);
        }
        this.aIr.setLayoutParams(layoutParams);
        this.fED.bfa().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0204a() { // from class: com.baidu.tieba.pb.pb.main.at.31
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0204a
            public void bac() {
                if (at.this.fEH != null) {
                    if (at.this.fEx != null) {
                        at.this.fEx.bgr();
                    }
                    at.this.fEH.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0204a
            public void bad() {
                at.this.fxm.auB();
            }
        }));
        this.fFO = this.fxm.findViewById(f.g.pb_editor_tool_comment);
        this.fFV = com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds90);
        this.fFW = com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds242);
        this.fFP = (TextView) this.fxm.getPageContext().getPageActivity().findViewById(f.g.pb_editor_tool_comment_reply_text);
        this.fFR = (ImageView) this.fxm.getPageContext().getPageActivity().findViewById(f.g.pb_editor_tool_more_img);
        this.fFQ = (ImageView) this.fxm.getPageContext().getPageActivity().findViewById(f.g.pb_editor_tool_emotion_img);
        this.fFS = (TextView) this.fxm.getPageContext().getPageActivity().findViewById(f.g.pb_editor_tool_comment_praise_icon);
        this.fFS.setVisibility(8);
        this.fFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.beG();
                if (!at.this.fxm.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").r("obj_locate", 2).ae(ImageViewerConfig.FORUM_ID, at.this.mForumId));
                } else if (at.this.fxm.baK()) {
                    com.baidu.tbadk.editortools.pb.d baA = at.this.fxm.baA();
                    if (baA == null || (!baA.If() && !baA.Ig())) {
                        if (at.this.Qg != null) {
                            at.this.bdQ();
                        }
                        if (at.this.Qg != null) {
                            at.this.fFT = false;
                            if (at.this.Qg.eN(2) != null) {
                                com.baidu.tieba.tbadkCore.b.a.a(at.this.fxm, (View) at.this.Qg.eN(2).aMc, false, at.fGQ);
                            }
                        }
                        at.this.beu();
                        return;
                    }
                    at.this.fxm.baA().a(false, (PostWriteCallBackData) null);
                }
            }
        });
        this.fFQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.beG();
                if (at.this.fxm.checkUpIsLogin()) {
                    if (at.this.Qg != null) {
                        at.this.bdQ();
                        at.this.Qg.N((View) at.this.Qg.eK(5));
                    }
                    if (at.this.Qg != null) {
                        at.this.fFT = false;
                        if (at.this.Qg.eN(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(at.this.fxm, (View) at.this.Qg.eN(2).aMc, false, at.fGQ);
                        }
                    }
                    at.this.beu();
                }
            }
        });
        this.fFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                at.this.beG();
                if (at.this.fxm.checkUpIsLogin()) {
                    if (at.this.Qg != null) {
                        at.this.bdQ();
                        at.this.Qg.N((View) at.this.Qg.eK(2));
                    }
                    if (at.this.Qg != null) {
                        at.this.fFT = false;
                        if (at.this.Qg.eN(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(at.this.fxm, (View) at.this.Qg.eN(2).aMc, false, at.fGQ);
                        }
                    }
                    at.this.beu();
                }
            }
        });
        this.fFS.setOnClickListener(this.dog);
        this.fFS.setOnTouchListener(this.fxm);
        this.fEI = LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.new_pb_header_item, (ViewGroup) null);
        this.fEL = (LinearLayout) LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.new_pb_header_user_item, (ViewGroup) null);
        this.fEM = new e(this.fxm, this.fEL);
        this.fEM.init();
        this.fEM.a(this.fEM.baz(), this.dog);
        this.fEN = (ColumnLayout) this.fEL.findViewById(f.g.pb_head_owner_root);
        this.fEO = (ThreadSkinView) this.fEL.findViewById(f.g.pb_thread_skin);
        this.fEN.setOnLongClickListener(this.onLongClickListener);
        this.fEN.setOnTouchListener(this.bgf);
        this.fEN.setVisibility(8);
        this.fEI.setOnTouchListener(this.bgf);
        this.fFZ = this.fEI.findViewById(f.g.pb_head_activity_join_number_container);
        this.fFZ.setVisibility(8);
        this.fGa = (TextView) this.fEI.findViewById(f.g.pb_head_activity_join_number);
        this.fEP = (TextView) this.fEN.findViewById(f.g.pb_head_owner_info_user_name);
        this.fEQ = (TextView) this.fEN.findViewById(f.g.floor_owner);
        this.fER = (ImageView) this.fEN.findViewById(f.g.icon_forum_level);
        this.fET = (FrameLayout) this.fEN.findViewById(f.g.pb_head_headImage_container);
        this.fEU = (HeadImageView) this.fEN.findViewById(f.g.pb_head_owner_photo);
        this.fES = (HeadPendantView) this.fEN.findViewById(f.g.pb_pendant_head_owner_photo);
        this.fES.setHasPendantStyle();
        if (this.fES.getHeadView() != null) {
            this.fES.getHeadView().setIsRound(true);
            this.fES.getHeadView().setDrawBorder(false);
        }
        this.fyB = (UserIconBox) this.fEN.findViewById(f.g.show_icon_vip);
        this.fyC = (UserIconBox) this.fEN.findViewById(f.g.show_icon_yinji);
        this.fEW = (FloatingLayout) this.fEL.findViewById(f.g.pb_head_owner_info_root);
        this.fEZ = (PbFirstFloorUserLikeButton) this.fEN.findViewById(f.g.pb_like_button);
        this.fFc = (TextView) this.fEN.findViewById(f.g.pb_views);
        this.ayn = (TextView) this.fEN.findViewById(f.g.view_forum_name);
        this.fFg = this.fEN.findViewById(f.g.line_right_forum_name);
        this.fFd = (TextView) this.fEN.findViewById(f.g.pb_item_first_floor_reply_time);
        this.fFe = (TextView) this.fEN.findViewById(f.g.pb_item_first_floor_location_address);
        this.fFf = this.fEN.findViewById(f.g.line_between_time_and_locate);
        this.fGS = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fGT = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fFk = this.fEI.findViewById(f.g.new_pb_header_item_line_above_livepost);
        this.fFl = this.fEI.findViewById(f.g.new_pb_header_item_line_below_livepost);
        this.fEI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.35
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fGb = (ViewStub) this.cSx.findViewById(f.g.interview_status_stub);
        this.fFo = new f(this.fxm, this.fEH);
        this.fFo.u(this.dog);
        this.fFo.setTbGestureDetector(this.bgf);
        this.fFo.setOnImageClickListener(this.bge);
        this.fxK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(f.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(f.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(f.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(f.g.tag_from, 1);
                            at.this.fxm.b(sparseArray);
                            return;
                        }
                        at.this.bl(view);
                    } else if (booleanValue2) {
                        sparseArray.put(f.g.tag_from, 0);
                        sparseArray.put(f.g.tag_check_mute_from, 1);
                        at.this.fxm.b(sparseArray);
                    } else if (booleanValue3) {
                        at.this.a(((Integer) sparseArray.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray.get(f.g.tag_del_post_id), ((Integer) sparseArray.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(f.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fFo.G(this.fxK);
        bdL();
        this.fEH.addHeaderView(this.fEJ);
        this.fEH.addHeaderView(this.fEL);
        this.fEH.addHeaderView(this.fEI);
        this.drz = new PbListView(this.fxm.getPageContext().getPageActivity());
        this.aTf = this.drz.getView().findViewById(f.g.pb_more_view);
        if (this.aTf != null) {
            this.aTf.setOnClickListener(this.dog);
            com.baidu.tbadk.core.util.am.i(this.aTf, f.C0146f.pb_foot_more_trans_selector);
        }
        this.drz.Ar();
        this.drz.dy(f.C0146f.pb_foot_more_trans_selector);
        this.drz.dA(f.C0146f.pb_foot_more_trans_selector);
        this.fFu = this.fxm.findViewById(f.g.viewstub_progress);
        this.fxm.registerListener(this.fGZ);
        this.fEV = com.baidu.tbadk.ala.b.rv().g(this.fxm.getActivity(), 2);
        if (this.fEV != null) {
            this.fEV.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fxm.getResources().getDimensionPixelSize(f.e.ds10);
            if (this.fEV.getParent() == null) {
                this.fEW.addView(this.fEV, aVar);
            }
        }
        this.fzN = new PbFakeFloorModel(this.fxm.getPageContext());
        this.fGx = new s(this.fxm.getPageContext(), this.fzN, this.cSx);
        this.fGx.a(this.fxm.fwn);
        this.fzN.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.at.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void k(PostData postData) {
                at.this.fzN.l(postData);
                at.this.fFo.notifyDataSetChanged();
                at.this.fGx.bbP();
                at.this.Qg.FP();
                at.this.kq(false);
            }
        });
        if (this.fxm.bao() != null && !StringUtils.isNull(this.fxm.bao().bcI())) {
            this.fxm.showToast(this.fxm.bao().bcI());
        }
        this.fGg = this.fxm.findViewById(f.g.pb_expand_blank_view);
        this.fGh = this.fxm.findViewById(f.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fGh.getLayoutParams();
        if (this.fxm.bao() != null && this.fxm.bao().bcg()) {
            this.fGg.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fGh.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fGj;
            this.fGh.setLayoutParams(layoutParams2);
        }
        this.fGi = new al(this.fxm.getPageContext(), this.fxm.findViewById(f.g.pb_reply_expand_view));
        this.fGi.fDL.setVisibility(8);
        this.fGi.J(this.dog);
        this.fxm.registerListener(this.bxA);
        this.fxm.registerListener(this.fGV);
        this.fxm.registerListener(this.fGW);
        bdH();
        kk(false);
    }

    private void bdH() {
        this.fGM = new com.baidu.tieba.pb.pb.godreply.a(this.fxm, this, (ViewStub) this.cSx.findViewById(f.g.more_god_reply_popup));
        this.fGM.q(this.dog);
        this.fGM.G(this.fxK);
        this.fGM.setOnImageClickListener(this.bge);
        this.fGM.q(this.dog);
        this.fGM.setTbGestureDetector(this.bgf);
    }

    public com.baidu.tieba.pb.pb.godreply.a bdI() {
        return this.fGM;
    }

    public View bdJ() {
        return this.fGg;
    }

    public void bdK() {
        if (this.fEH != null) {
            this.fEH.removeHeaderView(this.fEJ);
            this.fEH.removeHeaderView(this.fEL);
            this.fEH.removeHeaderView(this.fEI);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fGn == null) {
            this.fGn = new PbEmotionBar(this.fxm.getPageContext().getPageActivity());
            kk(true);
            this.fGn.a(this.cSx, aVar, this.fFO.getVisibility() == 0);
            this.fGn.setOnEmotionClickListener(new PbEmotionBar.a() { // from class: com.baidu.tieba.pb.pb.main.at.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (at.this.fxm.baK()) {
                        if (!StringUtils.isNull(at.this.fGU)) {
                            emotionImageData.setAuthorNameShow(at.this.fGU);
                        }
                        if (aVar2 != null) {
                            aVar2.a(emotionImageData, z);
                        }
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.a
                public void a(String str, List<String> list, List<String> list2) {
                    at.this.fxm.sendMessage(new CustomMessage(2002001, new PbSearchEmotionActivityConfig(at.this.fxm.getPageContext().getPageActivity(), 25016, str, list, at.this.fGU, list2)));
                }
            });
            this.fGn.setOnMoveListener(new PbEmotionBar.b() { // from class: com.baidu.tieba.pb.pb.main.at.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar.b
                public void onMove(float f) {
                    at.this.beG();
                    if (at.this.fFO != null) {
                        ViewGroup.LayoutParams layoutParams = at.this.fFO.getLayoutParams();
                        layoutParams.height = (int) (((at.this.fFW - at.this.fFV) * f) + at.this.fFV);
                        at.this.fFP.setAlpha(1.0f - f);
                        at.this.fFR.setAlpha(1.0f - f);
                        at.this.fFQ.setAlpha(1.0f - f);
                        at.this.fFO.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bdL() {
        if (this.fEJ == null) {
            int f = com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.tbds44);
            this.fEJ = new LinearLayout(this.fxm.getPageContext().getPageActivity());
            this.fEJ.setOrientation(1);
            this.fEJ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fEJ.setPadding(f, com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.tbds30), f, com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.tbds40));
            this.fEJ.setGravity(17);
            this.fEK = new TextView(this.fxm.getPageContext().getPageActivity());
            this.fEK.setGravity(3);
            this.fEK.setMaxLines(2);
            this.fEK.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_link_tip_c));
            this.fEK.setPadding(0, 0, 0, 0);
            this.fEK.setLineSpacing(com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.am.h(this.fEK, f.d.cp_cont_b);
            this.fEK.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fEK.setVisibility(8);
            if (this.fEK.getParent() == null) {
                this.fEJ.addView(this.fEK);
            }
            this.fEJ.setOnTouchListener(this.bgf);
            this.fEJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdM() {
        if (this.fxm.bbc()) {
            this.fEG = (ViewStub) this.fxm.findViewById(f.g.manga_mention_controller_view_stub);
            this.fEG.setVisibility(0);
            if (this.fFh == null) {
                this.fFh = (LinearLayout) this.fxm.findViewById(f.g.manga_controller_layout);
                com.baidu.tbadk.o.a.a(this.fxm.getPageContext(), this.fFh);
            }
            if (this.fFi == null) {
                this.fFi = (TextView) this.fFh.findViewById(f.g.manga_prev_btn);
            }
            if (this.fFj == null) {
                this.fFj = (TextView) this.fFh.findViewById(f.g.manga_next_btn);
            }
            this.fFi.setOnClickListener(this.dog);
            this.fFj.setOnClickListener(this.dog);
        }
    }

    private void bdN() {
        if (this.fxm.bbc()) {
            if (this.fxm.bbf() == -1) {
                com.baidu.tbadk.core.util.am.c(this.fFi, f.d.cp_cont_e, 1);
            }
            if (this.fxm.bbg() == -1) {
                com.baidu.tbadk.core.util.am.c(this.fFj, f.d.cp_cont_e, 1);
            }
        }
    }

    public void bdO() {
        if (this.fFh == null) {
            bdM();
        }
        this.fEG.setVisibility(8);
        if (this.fGX != null && this.fGY != null) {
            this.fGX.removeCallbacks(this.fGY);
        }
    }

    public void bdP() {
        if (this.fGX != null) {
            if (this.fGY != null) {
                this.fGX.removeCallbacks(this.fGY);
            }
            this.fGY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.8
                @Override // java.lang.Runnable
                public void run() {
                    if (at.this.fFh == null) {
                        at.this.bdM();
                    }
                    at.this.fEG.setVisibility(0);
                }
            };
            this.fGX.postDelayed(this.fGY, 2000L);
        }
    }

    public void kh(boolean z) {
        this.fED.kh(z);
        if (z && this.fFY) {
            this.drz.setText(this.fxm.getResources().getString(f.j.click_load_more));
            this.fEH.setNextPage(this.drz);
            this.fEC = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
        this.Qg.setId(f.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Qg.getParent() == null) {
            this.cSx.addView(this.Qg, layoutParams);
        }
        this.Qg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bdz();
        this.fxm.baA().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.at.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (at.this.Qg != null && at.this.Qg.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (at.this.fGL == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, at.this.Qg.getId());
                            at.this.fGL = new com.baidu.tieba.pb.pb.main.emotion.c(at.this.fxm.getPageContext(), at.this.cSx, layoutParams2);
                            if (!com.baidu.tbadk.core.util.w.z(at.this.fGK)) {
                                at.this.fGL.setData(at.this.fGK);
                            }
                            at.this.fGL.b(at.this.Qg);
                        }
                        at.this.fGL.rw(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (at.this.fxm.fvt != null && at.this.fxm.fvt.beL() != null) {
                    if (!at.this.fxm.fvt.beL().bFq()) {
                        at.this.fxm.fvt.ku(false);
                    }
                    at.this.fxm.fvt.beL().no(false);
                }
            }
        });
    }

    public void bdQ() {
        if (this.fxm != null && this.Qg != null) {
            this.Qg.oC();
            if (this.fxm.baA() != null) {
                this.fxm.baA().HW();
            }
            beu();
        }
    }

    public void M(String str, boolean z) {
        this.fFU = z;
        ki(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void ki(boolean z) {
        if (this.fFS != null) {
            if (this.fFU) {
                com.baidu.tbadk.core.util.am.i(this.fFS, f.C0146f.pb_praise_already_click_selector);
                this.fFS.setContentDescription(this.fxm.getResources().getString(f.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.am.i(this.fFS, f.C0146f.pb_praise_normal_click_selector);
            this.fFS.setContentDescription(this.fxm.getResources().getString(f.j.zan));
        }
    }

    public TextView bdR() {
        return this.fFS;
    }

    public void kj(boolean z) {
        if (this.fEH != null && this.aIr != null && this.dov != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dov.setVisibility(0);
                } else {
                    this.dov.setVisibility(8);
                    this.fEH.removeHeaderView(this.aIr);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aIr.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fGj;
                    this.aIr.setLayoutParams(layoutParams);
                }
                bef();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aIr.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kr(true);
                this.aIr.setLayoutParams(layoutParams2);
            }
            bef();
            beC();
        }
    }

    public f bdS() {
        return this.fFo;
    }

    public void a(PbActivity.d dVar) {
        this.fwr = dVar;
    }

    public void bl(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fFx == null) {
            this.fFx = LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fxm.getLayoutMode().onModeChanged(this.fFx);
        if (this.fFw == null) {
            this.fFw = new Dialog(this.fxm.getPageContext().getPageActivity(), f.k.common_alert_dialog);
            this.fFw.setCanceledOnTouchOutside(true);
            this.fFw.setCancelable(true);
            this.fFw.setContentView(this.fFx);
            WindowManager.LayoutParams attributes = this.fFw.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ah(this.fxm.getPageContext().getPageActivity()) * 0.9d);
            this.fFw.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fFw.findViewById(f.g.del_post_btn);
        TextView textView2 = (TextView) this.fFw.findViewById(f.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fFw.findViewById(f.g.disable_reply_btn);
        int intValue = sparseArray.get(f.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(f.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(f.g.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(f.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(f.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(f.j.delete);
            } else {
                textView.setText(f.j.delete_post);
            }
            sparseArray2.put(f.g.tag_del_post_id, sparseArray.get(f.g.tag_del_post_id));
            sparseArray2.put(f.g.tag_del_post_type, sparseArray.get(f.g.tag_del_post_type));
            sparseArray2.put(f.g.tag_del_post_is_self, sparseArray.get(f.g.tag_del_post_is_self));
            sparseArray2.put(f.g.tag_manage_user_identity, sparseArray.get(f.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFw != null && (at.this.fFw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFw, at.this.fxm.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        at.this.a(((Integer) sparseArray5.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(f.g.tag_del_post_id), ((Integer) sparseArray5.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(f.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if (("".equals(sparseArray.get(f.g.tag_forbid_user_name)) && "".equals(sparseArray.get(f.g.tag_forbid_user_name_show))) || beB()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(f.g.tag_forbid_user_name, sparseArray.get(f.g.tag_forbid_user_name));
            sparseArray5.put(f.g.tag_forbid_user_name_show, sparseArray.get(f.g.tag_forbid_user_name_show));
            sparseArray5.put(f.g.tag_forbid_user_portrait, sparseArray.get(f.g.tag_forbid_user_portrait));
            sparseArray5.put(f.g.tag_manage_user_identity, sparseArray.get(f.g.tag_manage_user_identity));
            sparseArray5.put(f.g.tag_forbid_user_post_id, sparseArray.get(f.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFw != null && (at.this.fFw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFw, at.this.fxm.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && at.this.fHa != null) {
                        at.this.fHa.i(new Object[]{sparseArray6.get(f.g.tag_manage_user_identity), sparseArray6.get(f.g.tag_forbid_user_name), sparseArray6.get(f.g.tag_forbid_user_post_id), sparseArray6.get(f.g.tag_forbid_user_name_show), sparseArray6.get(f.g.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(f.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(f.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(f.j.un_mute);
            } else {
                textView3.setText(f.j.mute);
            }
            sparseArray6.put(f.g.tag_is_mem, sparseArray.get(f.g.tag_is_mem));
            sparseArray6.put(f.g.tag_user_mute_mute_userid, sparseArray.get(f.g.tag_user_mute_mute_userid));
            sparseArray6.put(f.g.tag_user_mute_mute_username, sparseArray.get(f.g.tag_user_mute_mute_username));
            sparseArray6.put(f.g.tag_user_mute_mute_nameshow, sparseArray.get(f.g.tag_user_mute_mute_nameshow));
            sparseArray6.put(f.g.tag_user_mute_post_id, sparseArray.get(f.g.tag_user_mute_post_id));
            sparseArray6.put(f.g.tag_user_mute_thread_id, sparseArray.get(f.g.tag_user_mute_thread_id));
            sparseArray6.put(f.g.tag_user_mute_msg, sparseArray.get(f.g.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFw != null && (at.this.fFw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(at.this.fFw, at.this.fxm.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        at.this.fxm.a(z, (String) sparseArray7.get(f.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fFw, this.fxm.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fHa = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.fxm != null && aVar != null) {
            if (this.dKk == null) {
                this.dKk = new com.baidu.tieba.NEGFeedBack.e(this.fxm.getPageContext(), this.fEI);
            }
            AntiData Cb = this.fxm.Cb();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (Cb != null && Cb.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Cb.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(sparseArray);
            this.dKk.setDefaultReasonArray(new String[]{this.fxm.getString(f.j.delete_thread_reason_1), this.fxm.getString(f.j.delete_thread_reason_2), this.fxm.getString(f.j.delete_thread_reason_3), this.fxm.getString(f.j.delete_thread_reason_4), this.fxm.getString(f.j.delete_thread_reason_5)});
            this.dKk.setData(ahVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.dKk.hZ(str);
            this.dKk.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.at.15
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray) {
                    at.this.fxm.a(aVar, jSONArray);
                }
            });
        }
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(f.g.tag_del_post_id, str);
        sparseArray.put(f.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(f.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(fGq, Integer.valueOf(fGr));
        int i3 = f.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = f.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = f.j.report_thread_confirm;
            } else {
                i3 = f.j.del_thread_confirm;
            }
        }
        this.fFy = new com.baidu.tbadk.core.dialog.a(this.fxm.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fFy.cf(i3);
        } else {
            this.fFy.aA(false);
            this.fFy.dB(str2);
        }
        this.fFy.C(sparseArray);
        this.fFy.a(f.j.dialog_ok, this.fxm);
        this.fFy.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fFy.av(true);
        this.fFy.b(this.fxm.getPageContext());
        if (z) {
            this.fFy.xe();
        } else {
            a(this.fFy, i);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fFB == null) {
            this.fFB = LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.commit_good, (ViewGroup) null);
        }
        this.fxm.getLayoutMode().onModeChanged(this.fFB);
        if (this.fFA == null) {
            this.fFA = new Dialog(this.fxm.getPageContext().getPageActivity(), f.k.common_alert_dialog);
            this.fFA.setCanceledOnTouchOutside(true);
            this.fFA.setCancelable(true);
            this.fFL = (ScrollView) this.fFB.findViewById(f.g.good_scroll);
            this.fFA.setContentView(this.fFB);
            WindowManager.LayoutParams attributes = this.fFA.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds540);
            this.fFA.getWindow().setAttributes(attributes);
            this.cBi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.at.17
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        at.this.fFG = (String) compoundButton.getTag();
                        if (at.this.cBh != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : at.this.cBh) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && at.this.fFG != null && !str.equals(at.this.fFG)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fFC = (LinearLayout) this.fFB.findViewById(f.g.good_class_group);
            this.fFE = (TextView) this.fFB.findViewById(f.g.dialog_button_cancel);
            this.fFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (at.this.fFA instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(at.this.fFA, at.this.fxm.getPageContext());
                    }
                }
            });
            this.fFD = (TextView) this.fFB.findViewById(f.g.dialog_button_ok);
            this.fFD.setOnClickListener(this.dog);
        }
        this.fFC.removeAllViews();
        this.cBh = new ArrayList();
        CustomBlueCheckRadioButton bQ = bQ("0", this.fxm.getPageContext().getString(f.j.thread_good_class));
        this.cBh.add(bQ);
        bQ.setChecked(true);
        this.fFC.addView(bQ);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.tX()) && aaVar.tY() > 0) {
                    CustomBlueCheckRadioButton bQ2 = bQ(String.valueOf(aaVar.tY()), aaVar.tX());
                    this.cBh.add(bQ2);
                    View view = new View(this.fxm.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds1));
                    com.baidu.tbadk.core.util.am.j(view, f.d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fFC.addView(view);
                    this.fFC.addView(bQ2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fFL.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxm.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxm.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fxm.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fFL.setLayoutParams(layoutParams2);
            this.fFL.removeAllViews();
            if (this.fFC != null && this.fFC.getParent() == null) {
                this.fFL.addView(this.fFC);
            }
        }
        com.baidu.adp.lib.g.g.a(this.fFA, this.fxm.getPageContext());
    }

    private CustomBlueCheckRadioButton bQ(String str, String str2) {
        Activity pageActivity = this.fxm.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, f.e.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.cBi);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void bdT() {
        this.fxm.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fxm.hideProgressBar();
        if (z && z2) {
            this.fxm.showToast(this.fxm.getPageContext().getString(f.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(f.j.neterror);
            }
            this.fxm.showToast(str);
        }
    }

    public void aLD() {
        this.fFu.setVisibility(0);
    }

    public void aLC() {
        this.fFu.setVisibility(8);
    }

    public View bdU() {
        if (this.fFB != null) {
            return this.fFB.findViewById(f.g.dialog_button_ok);
        }
        return null;
    }

    public String bdV() {
        return this.fFG;
    }

    public View getView() {
        return this.cSx;
    }

    public void bdW() {
        com.baidu.adp.lib.util.l.a(this.fxm.getPageContext().getPageActivity(), this.fxm.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fxm.hideProgressBar();
        if (z) {
            bel();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bem();
        } else {
            bel();
        }
    }

    public void bdX() {
        this.drz.Ar();
        this.drz.Av();
    }

    public void bdY() {
        this.fxm.hideProgressBar();
        Aw();
        this.fEH.completePullRefreshPostDelayed(2000L);
        bei();
    }

    public void bdZ() {
        this.fEH.completePullRefreshPostDelayed(2000L);
        bei();
    }

    private void kk(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fFP.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fxm.getResources().getDimensionPixelSize(f.e.ds130) : this.fxm.getResources().getDimensionPixelSize(f.e.ds34);
        this.fFP.setLayoutParams(marginLayoutParams);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fFo.setOnLongClickListener(onLongClickListener);
        if (this.fGM != null) {
            this.fGM.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0101b interfaceC0101b, boolean z, boolean z2) {
        if (this.fFH != null) {
            this.fFH.dismiss();
            this.fFH = null;
        }
        this.fFH = new com.baidu.tbadk.core.dialog.b(this.fxm.getPageContext().getPageActivity());
        this.fFH.ci(f.j.operation);
        if (z2) {
            this.fFH.a(new String[]{this.fxm.getPageContext().getString(f.j.copy)}, interfaceC0101b);
        } else if (!z) {
            this.fFH.a(new String[]{this.fxm.getPageContext().getString(f.j.copy), this.fxm.getPageContext().getString(f.j.mark)}, interfaceC0101b);
        } else {
            this.fFH.a(new String[]{this.fxm.getPageContext().getString(f.j.copy), this.fxm.getPageContext().getString(f.j.remove_mark)}, interfaceC0101b);
        }
        this.fFH.d(this.fxm.getPageContext());
        this.fFH.xh();
    }

    public void a(b.InterfaceC0101b interfaceC0101b, boolean z) {
        if (this.fFI != null) {
            this.fFI.dismiss();
            this.fFI = null;
        }
        this.fFI = new com.baidu.tbadk.core.dialog.b(this.fxm.getPageContext().getPageActivity());
        this.fFI.ci(f.j.operation);
        if (z) {
            this.fFI.a(new String[]{this.fxm.getPageContext().getString(f.j.save_to_emotion)}, interfaceC0101b);
        } else {
            this.fFI.a(new String[]{this.fxm.getPageContext().getString(f.j.save_to_emotion), this.fxm.getPageContext().getString(f.j.save_to_local)}, interfaceC0101b);
        }
        this.fFI.d(this.fxm.getPageContext());
        this.fFI.xh();
    }

    public int bea() {
        return qN(this.fEH.getFirstVisiblePosition());
    }

    private int qN(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fEH.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.b)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fEH.getAdapter() == null || !(this.fEH.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fEH.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int beb() {
        int lastVisiblePosition = this.fEH.getLastVisiblePosition();
        if (this.fEx != null) {
            if (lastVisiblePosition == this.fEH.getCount() - 1) {
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
        if (this.fEH != null) {
            if (this.fED == null || this.fED.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fED.mNavigationBar.getFixedNavHeight();
                if (this.fxm.baQ() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fGh != null && (layoutParams = (LinearLayout.LayoutParams) this.fGh.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fGh.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fEH.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fEH.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fFr.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void n(com.baidu.tieba.pb.data.d dVar) {
        this.fFo.a(dVar, false);
        this.fFo.notifyDataSetChanged();
        bei();
        if (this.fGM != null) {
            this.fGM.bak();
        }
    }

    public void o(com.baidu.tieba.pb.data.d dVar) {
        if (this.fEX == null) {
            this.fxm.getLayoutMode().onModeChanged(((ViewStub) this.fEI.findViewById(f.g.praise_layout)).inflate());
            this.fEX = (FrsPraiseView) this.fEI.findViewById(f.g.pb_head_praise_view);
            this.fEX.setIsFromPb(true);
            this.fFm = this.fEI.findViewById(f.g.new_pb_header_item_line_above_praise);
            this.fEX.dF(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fEX != null) {
            boolean bei = bei();
            this.fEX.setVisibility(8);
            if (dVar != null && dVar.uv() != null && dVar.uv().us() == 0 && this.fxD) {
                if (bei) {
                    this.fFl.setVisibility(0);
                    return;
                } else {
                    this.fFl.setVisibility(8);
                    return;
                }
            }
            this.fFl.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        if (dVar == null) {
            return null;
        }
        if (dVar.aZs() != null) {
            return dVar.aZs();
        }
        if (!com.baidu.tbadk.core.util.w.z(dVar.aZk())) {
            Iterator<PostData> it = dVar.aZk().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bwg() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = dVar.aZp();
        }
        if (postData == null) {
            postData = a(dVar);
        }
        if (postData != null && postData.vj() != null && postData.vj().getUserTbVipInfoData() != null && postData.vj().getUserTbVipInfoData().getvipIntro() != null) {
            postData.vj().getGodUserData().setIntro(postData.vj().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.aZi() == null || dVar.aZi().vj() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData vj = dVar.aZi().vj();
        String userId = vj.getUserId();
        HashMap<String, MetaData> userMap = dVar.aZi().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = vj;
        }
        postData.tJ(1);
        postData.setId(dVar.aZi().vA());
        postData.setTitle(dVar.aZi().getTitle());
        postData.setTime(dVar.aZi().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x07ae  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0317  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        String d;
        ArrayList<IconData> tShowInfoNew;
        int f;
        com.baidu.tbadk.data.f bwj;
        String portrait;
        if (dVar != null && dVar.aZi() != null) {
            PostData b = b(dVar, z);
            a(b, dVar);
            this.fEN.setVisibility(8);
            if (dVar.aZi() != null && dVar.aZi().vV() && dVar.aZi().vB() != null) {
                this.fGB = true;
                this.fED.kG(this.fGB);
                this.fED.mNavigationBar.hideBottomLine();
                if (this.fEx == null) {
                    this.fEx = new com.baidu.tieba.pb.video.i(this.fxm, this.fED, dVar.aZi().vB(), this.fEy);
                    this.fEx.a(dVar.aZi().vB(), dVar.aZi(), dVar.getForumId());
                    this.fEx.startPlay();
                } else if (this.fEB) {
                    this.fEx.a(dVar.aZi().vB(), dVar.aZi(), dVar.getForumId());
                    this.fEx.startPlay();
                } else {
                    this.fEx.rI(dVar.getForumId());
                }
                if (dVar.aZj() != null && dVar.aZj().size() >= 1) {
                    bb bbVar = dVar.aZj().get(0);
                    this.fEx.ar(bbVar);
                    this.fEx.rJ(bbVar.getTitle());
                }
                this.fEx.b(b, dVar.aZi(), dVar.aZG());
                this.fEB = false;
                this.fEH.removeHeaderView(this.fEx.bgs());
                this.fEH.addHeaderView(this.fEx.bgs(), 0);
                if (this.fEx.bgq() != null && this.fEx.bgq().getParent() == null) {
                    this.fGf.addView(this.fEx.bgq());
                }
                if (this.fEz == null) {
                    this.fEz = new com.baidu.tieba.pb.video.h(this.fxm);
                }
                this.fEz.a(dVar.aZi().wk(), dVar.aZi(), dVar.aZD());
                this.fEH.removeHeaderView(this.fEz.bgh());
                this.fEH.addHeaderView(this.fEz.bgh(), 1);
                if (dVar.aZi().wk() != null) {
                    this.fEH.removeHeaderView(this.fEz.bgi());
                    this.fEH.removeHeaderView(this.fEL);
                    this.fEH.addHeaderView(this.fEz.bgi(), 2);
                } else {
                    if (this.fEz.bgi() != null) {
                        this.fEH.removeHeaderView(this.fEz.bgi());
                    }
                    this.fEH.removeHeaderView(this.fEL);
                    this.fEL.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.fxm, f.e.tbds56));
                    this.fEH.addHeaderView(this.fEL, 2);
                }
                if (this.fEx != null) {
                    this.fED.kA(false);
                    this.fED.kC(TbadkCoreApplication.isLogin());
                    this.fEx.qV(TbadkCoreApplication.getInst().getSkinType());
                }
                bef();
            } else {
                this.fGB = false;
                this.fED.kG(this.fGB);
                if (this.fEx != null) {
                    this.fEH.removeHeaderView(this.fEx.bgs());
                }
                if (this.fEz != null) {
                    this.fEz.b(this.fEH);
                }
                if (b == null || (b != null && (b.bwi() == null || com.baidu.tbadk.core.util.w.z(b.bwi().Nw())))) {
                    this.fEL.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.fxm, f.e.tbds80));
                } else {
                    this.fEL.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fxm.baE() != null) {
                this.fxm.baE().ky(this.fGB);
            }
            if (this.fEx != null) {
                this.fEx.L(this.fHc);
            }
            if (b != null) {
                this.fFX = b;
                this.fEN.setVisibility(0);
                if (this.fxm.bbp()) {
                    if (dVar.aZh() != null) {
                        this.mForumName = dVar.aZh().getForumName();
                        this.mForumId = dVar.aZh().getForumId();
                    }
                    if (this.mForumName == null && this.fxm.bao() != null && this.fxm.bao().bcc() != null) {
                        this.mForumName = this.fxm.bao().bcc();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fEN.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fEN.setTag(sparseArray);
                }
                sparseArray.put(f.g.tag_clip_board, b);
                sparseArray.put(f.g.tag_is_subpb, false);
                if (!this.fGR) {
                    this.fEJ.setVisibility(0);
                }
                if (!dVar.aZi().vV() && this.fEK.getText() != null && this.fEK.getText().length() > 0) {
                    this.fEK.setVisibility(0);
                } else {
                    this.fEK.setVisibility(8);
                }
                o(dVar);
                ArrayList<com.baidu.tbadk.core.data.a> vv = dVar.aZi().vv();
                if (vv != null && vv.size() > 0 && !this.fGR) {
                    this.fGa.setText(String.valueOf(vv.get(0).tC()));
                    this.fFZ.setVisibility(0);
                } else {
                    this.fFZ.setVisibility(8);
                }
                com.baidu.tbadk.core.util.am.i(this.fFZ, f.C0146f.activity_join_num_bg);
                com.baidu.tbadk.core.util.am.c(this.fGa, f.d.cp_link_tip_d, 1);
                if (b.vj() != null) {
                    String string = b.vj().getName_show() == null ? StringUtils.string(b.vj().getUserName()) : StringUtils.string(b.vj().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.vj().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.bj(b.vj().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.bj(string) > 12) {
                            d = com.baidu.tbadk.core.util.ap.d(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.vj().getIconInfo();
                            tShowInfoNew = b.vj().getTShowInfoNew();
                            if (this.fyC != null) {
                                this.fyC.setTag(f.g.tag_user_id, b.vj().getUserId());
                                this.fyC.setOnClickListener(this.fxm.fvp.fIP);
                                this.fyC.a(iconInfo, 4, this.fxm.getResources().getDimensionPixelSize(f.e.tbds36), this.fxm.getResources().getDimensionPixelSize(f.e.tbds36), this.fxm.getResources().getDimensionPixelSize(f.e.tbds12));
                            }
                            if (this.fyB != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fyB.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fyB.setOnClickListener(this.fxm.fvp.fIQ);
                                this.fyB.a(tShowInfoNew, 3, this.fxm.getResources().getDimensionPixelSize(f.e.tbds36), this.fxm.getResources().getDimensionPixelSize(f.e.tbds36), this.fxm.getResources().getDimensionPixelSize(f.e.ds12), true);
                            }
                            this.fEP.setText(ah(b.vj().getSealPrefix(), d));
                            this.fEP.setTag(f.g.tag_user_id, b.vj().getUserId());
                            this.fEP.setTag(f.g.tag_user_name, b.vj().getName_show());
                            if (com.baidu.tbadk.core.util.w.z(tShowInfoNew) || b.vj().isBigV()) {
                                com.baidu.tbadk.core.util.am.c(this.fEP, f.d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.am.c(this.fEP, f.d.cp_cont_f, 1);
                            }
                            this.fEQ.setVisibility(8);
                            if (dVar.aZi().vj() != null && dVar.aZi().vj().getAlaUserData() != null && this.fEV != null) {
                                if (dVar.aZi().vj().getAlaUserData().anchor_live != 0) {
                                    this.fEV.setVisibility(8);
                                } else {
                                    this.fEV.setVisibility(0);
                                    if (this.fEA == null) {
                                        this.fEA = new com.baidu.tieba.c.d(this.fxm.getPageContext(), this.fEV);
                                        this.fEA.jq(1);
                                    }
                                    this.fEA.aO(this.fxm.getResources().getString(f.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.ZS = dVar.aZi().vj().getAlaUserData();
                                    aVar.type = 2;
                                    this.fEV.setTag(aVar);
                                }
                            }
                            this.fEU.setUserId(b.vj().getUserId());
                            this.fEU.setUserName(b.vj().getUserName());
                            this.fEU.setTid(b.getId());
                            this.fEU.setFid(this.fAT == null ? this.fAT.getForumId() : "");
                            this.fEU.setImageDrawable(null);
                            this.fEU.setRadius(com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds40));
                            this.fEU.setTag(b.vj().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fFd.setText(com.baidu.tbadk.core.util.ap.y(b.getTime()));
                            } else {
                                this.fFd.setText(com.baidu.tbadk.core.util.ap.w(b.getTime()));
                            }
                            f = com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds16);
                            if (!this.fxm.bbp() && !StringUtils.isNull(this.mForumName)) {
                                this.ayn.setText(this.fxm.getString(f.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.ayn.setVisibility(0);
                                this.fFg.setVisibility(0);
                                this.fFd.setPadding(f, 0, f, 0);
                            } else {
                                this.ayn.setVisibility(8);
                                this.fFg.setVisibility(8);
                                this.fFd.setPadding(0, 0, f, 0);
                            }
                            bwj = b.bwj();
                            if (bwj == null && !TextUtils.isEmpty(bwj.getName()) && !TextUtils.isEmpty(bwj.getName().trim())) {
                                final String name = bwj.getName();
                                final String lat = bwj.getLat();
                                final String lng = bwj.getLng();
                                this.fFe.setVisibility(0);
                                this.fFf.setVisibility(0);
                                this.fFe.setText(bwj.getName());
                                this.fFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.20
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.jE()) {
                                                at.this.fxm.showToast(f.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.Q(at.this.fxm.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + "," + lng, name, name, at.this.fxm.getPageContext().getString(f.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fFe.setVisibility(8);
                                this.fFf.setVisibility(8);
                            }
                            portrait = b.vj().getPortrait();
                            if (b.vj().getPendantData() == null && !StringUtils.isNull(b.vj().getPendantData().tT())) {
                                UtilHelper.showHeadImageViewBigV(this.fES.getHeadView(), b.vj());
                                this.fEU.setVisibility(8);
                                this.fES.setVisibility(0);
                                if (this.fEY != null) {
                                    this.fEY.setVisibility(8);
                                }
                                this.fEP.setOnClickListener(this.fHc);
                                this.fES.getHeadView().startLoad(portrait, 28, false);
                                this.fES.getHeadView().setUserId(b.vj().getUserId());
                                this.fES.getHeadView().setUserName(b.vj().getUserName());
                                this.fES.getHeadView().setTid(b.getId());
                                this.fES.getHeadView().setFid(this.fAT != null ? this.fAT.getForumId() : "");
                                this.fES.getHeadView().setOnClickListener(this.fHc);
                                this.fES.fl(b.vj().getPendantData().tT());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fEU, b.vj());
                                this.fEU.setVisibility(0);
                                this.fEN.setOnClickListener(this.fHc);
                                this.fEP.setOnClickListener(this.fHc);
                                this.fEU.setOnClickListener(this.fHc);
                                this.fES.setVisibility(8);
                                this.fEU.startLoad(portrait, 28, false);
                            }
                            String name_show = b.vj().getName_show();
                            String userName = b.vj().getUserName();
                            if (com.baidu.tbadk.p.aj.iq() && name_show != null && !name_show.equals(userName)) {
                                this.fEP.setText(com.baidu.tieba.pb.c.al(this.fxm.getPageContext().getPageActivity(), this.fEP.getText().toString()));
                                this.fEP.setGravity(16);
                                this.fEP.setTag(f.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYQ());
                                com.baidu.tbadk.core.util.am.c(this.fEP, f.d.cp_other_e, 1);
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo2 = b.vj().getIconInfo();
                        tShowInfoNew = b.vj().getTShowInfoNew();
                        if (this.fyC != null) {
                        }
                        if (this.fyB != null) {
                        }
                        this.fEP.setText(ah(b.vj().getSealPrefix(), d));
                        this.fEP.setTag(f.g.tag_user_id, b.vj().getUserId());
                        this.fEP.setTag(f.g.tag_user_name, b.vj().getName_show());
                        if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.c(this.fEP, f.d.cp_cont_h, 1);
                        this.fEQ.setVisibility(8);
                        if (dVar.aZi().vj() != null) {
                            if (dVar.aZi().vj().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fEU.setUserId(b.vj().getUserId());
                        this.fEU.setUserName(b.vj().getUserName());
                        this.fEU.setTid(b.getId());
                        this.fEU.setFid(this.fAT == null ? this.fAT.getForumId() : "");
                        this.fEU.setImageDrawable(null);
                        this.fEU.setRadius(com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds40));
                        this.fEU.setTag(b.vj().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds16);
                        if (!this.fxm.bbp()) {
                        }
                        this.ayn.setVisibility(8);
                        this.fFg.setVisibility(8);
                        this.fFd.setPadding(0, 0, f, 0);
                        bwj = b.bwj();
                        if (bwj == null) {
                        }
                        this.fFe.setVisibility(8);
                        this.fFf.setVisibility(8);
                        portrait = b.vj().getPortrait();
                        if (b.vj().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fEU, b.vj());
                        this.fEU.setVisibility(0);
                        this.fEN.setOnClickListener(this.fHc);
                        this.fEP.setOnClickListener(this.fHc);
                        this.fEU.setOnClickListener(this.fHc);
                        this.fES.setVisibility(8);
                        this.fEU.startLoad(portrait, 28, false);
                        String name_show2 = b.vj().getName_show();
                        String userName2 = b.vj().getUserName();
                        if (com.baidu.tbadk.p.aj.iq()) {
                            this.fEP.setText(com.baidu.tieba.pb.c.al(this.fxm.getPageContext().getPageActivity(), this.fEP.getText().toString()));
                            this.fEP.setGravity(16);
                            this.fEP.setTag(f.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYQ());
                            com.baidu.tbadk.core.util.am.c(this.fEP, f.d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.bj(string) > 14) {
                            d = com.baidu.tbadk.core.util.ap.d(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.vj().getIconInfo();
                            tShowInfoNew = b.vj().getTShowInfoNew();
                            if (this.fyC != null) {
                            }
                            if (this.fyB != null) {
                            }
                            this.fEP.setText(ah(b.vj().getSealPrefix(), d));
                            this.fEP.setTag(f.g.tag_user_id, b.vj().getUserId());
                            this.fEP.setTag(f.g.tag_user_name, b.vj().getName_show());
                            if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.am.c(this.fEP, f.d.cp_cont_h, 1);
                            this.fEQ.setVisibility(8);
                            if (dVar.aZi().vj() != null) {
                            }
                            this.fEU.setUserId(b.vj().getUserId());
                            this.fEU.setUserName(b.vj().getUserName());
                            this.fEU.setTid(b.getId());
                            this.fEU.setFid(this.fAT == null ? this.fAT.getForumId() : "");
                            this.fEU.setImageDrawable(null);
                            this.fEU.setRadius(com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds40));
                            this.fEU.setTag(b.vj().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            f = com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds16);
                            if (!this.fxm.bbp()) {
                            }
                            this.ayn.setVisibility(8);
                            this.fFg.setVisibility(8);
                            this.fFd.setPadding(0, 0, f, 0);
                            bwj = b.bwj();
                            if (bwj == null) {
                            }
                            this.fFe.setVisibility(8);
                            this.fFf.setVisibility(8);
                            portrait = b.vj().getPortrait();
                            if (b.vj().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fEU, b.vj());
                            this.fEU.setVisibility(0);
                            this.fEN.setOnClickListener(this.fHc);
                            this.fEP.setOnClickListener(this.fHc);
                            this.fEU.setOnClickListener(this.fHc);
                            this.fES.setVisibility(8);
                            this.fEU.startLoad(portrait, 28, false);
                            String name_show22 = b.vj().getName_show();
                            String userName22 = b.vj().getUserName();
                            if (com.baidu.tbadk.p.aj.iq()) {
                            }
                        }
                        d = string;
                        ArrayList<IconData> iconInfo222 = b.vj().getIconInfo();
                        tShowInfoNew = b.vj().getTShowInfoNew();
                        if (this.fyC != null) {
                        }
                        if (this.fyB != null) {
                        }
                        this.fEP.setText(ah(b.vj().getSealPrefix(), d));
                        this.fEP.setTag(f.g.tag_user_id, b.vj().getUserId());
                        this.fEP.setTag(f.g.tag_user_name, b.vj().getName_show());
                        if (com.baidu.tbadk.core.util.w.z(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.am.c(this.fEP, f.d.cp_cont_h, 1);
                        this.fEQ.setVisibility(8);
                        if (dVar.aZi().vj() != null) {
                        }
                        this.fEU.setUserId(b.vj().getUserId());
                        this.fEU.setUserName(b.vj().getUserName());
                        this.fEU.setTid(b.getId());
                        this.fEU.setFid(this.fAT == null ? this.fAT.getForumId() : "");
                        this.fEU.setImageDrawable(null);
                        this.fEU.setRadius(com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds40));
                        this.fEU.setTag(b.vj().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.fxm.getActivity(), f.e.ds16);
                        if (!this.fxm.bbp()) {
                        }
                        this.ayn.setVisibility(8);
                        this.fFg.setVisibility(8);
                        this.fFd.setPadding(0, 0, f, 0);
                        bwj = b.bwj();
                        if (bwj == null) {
                        }
                        this.fFe.setVisibility(8);
                        this.fFf.setVisibility(8);
                        portrait = b.vj().getPortrait();
                        if (b.vj().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fEU, b.vj());
                        this.fEU.setVisibility(0);
                        this.fEN.setOnClickListener(this.fHc);
                        this.fEP.setOnClickListener(this.fHc);
                        this.fEU.setOnClickListener(this.fHc);
                        this.fES.setVisibility(8);
                        this.fEU.startLoad(portrait, 28, false);
                        String name_show222 = b.vj().getName_show();
                        String userName222 = b.vj().getUserName();
                        if (com.baidu.tbadk.p.aj.iq()) {
                        }
                    }
                }
                if (dVar != null) {
                    this.fEM.aj(dVar.aZi());
                }
                if (this.fGi != null) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fta);
                    if (dVar != null && dVar.aZi() != null) {
                        hVar.ftc = dVar.aZi().va();
                    }
                    hVar.isNew = !this.fxD;
                    hVar.fte = this.fxm.bbo();
                    this.fGi.a(hVar);
                }
            }
        }
    }

    public void kl(boolean z) {
        if (z) {
            bec();
        } else {
            aoX();
        }
        this.fGm.fHv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGm));
        a(this.fGm.fHv, false);
    }

    public void bec() {
        if (this.fED != null && !this.fGD) {
            this.fED.kH(!StringUtils.isNull(this.fxm.baN()));
            this.fGD = true;
        }
    }

    public void aoX() {
        if (this.fED != null) {
            this.fED.bfh();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.d dVar) {
        if (postData != null && postData.vE() != null) {
            this.fEO.setData(this.fxm.getPageContext(), dVar.aZk().get(0).vE(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", dVar.aZg().getId(), dVar.aZg().getName(), dVar.aZi().getId(), this.fxm.bbl() ? "FRS" : null));
            this.fEN.setPadding(this.fEN.getPaddingLeft(), (int) this.fxm.getResources().getDimension(f.e.ds20), this.fEN.getPaddingRight(), this.fEN.getPaddingBottom());
            return;
        }
        this.fEO.setData(null, null, null);
    }

    public void bed() {
        if (this.fEx != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11997").r("obj_type", 1));
            this.fEx.bgr();
            this.fEH.smoothScrollToPosition(0);
        }
    }

    public boolean bee() {
        return this.fHd;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean al(bb bbVar) {
        if (bbVar == null || bbVar.vj() == null || bbVar.vj().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.vj().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.c cVar) {
        if (cVar != null) {
            this.fED.bff();
            if (!StringUtils.isNull(cVar.forumName)) {
                this.fED.pk(cVar.forumName);
            }
            String string = this.fxm.getResources().getString(f.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(cVar.source, 0)) {
                case 100:
                    str = this.fxm.getResources().getString(f.j.self);
                    break;
                case 300:
                    str = this.fxm.getResources().getString(f.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fxm.getResources().getString(f.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = cVar.fsl;
            this.fxm.showNetRefreshView(this.cSx, format, null, this.fxm.getResources().getString(f.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.at.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.jV()) {
                        az.zI().c(at.this.fxm.getPageContext(), new String[]{str2});
                        at.this.fxm.finish();
                        return;
                    }
                    at.this.fxm.showToast(f.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bdm;
        Parcelable bdm2;
        String str;
        if (dVar != null) {
            this.fAT = dVar;
            this.mType = i;
            if (dVar.aZi() != null) {
                this.fGo = dVar.aZi().uS();
                if (dVar.aZi().getAnchorLevel() != 0) {
                    this.fHd = true;
                }
                this.fFK = al(dVar.aZi());
            }
            if (dVar.getUserData() != null) {
                this.userId = dVar.getUserData().getUserId();
            }
            r(dVar);
            this.fFY = false;
            this.fxD = z;
            bdY();
            b(dVar, z, i);
            p(dVar);
            if (this.fGP == null) {
                this.fGP = new ac(this.fxm.getPageContext(), this.dHm);
            }
            this.fGP.ro(dVar.aZn());
            if (this.fxm.bbc()) {
                if (this.fFs == null) {
                    this.fFs = new com.baidu.tieba.pb.view.e(this.fxm.getPageContext());
                    this.fFs.np();
                    this.fFs.a(this.awt);
                }
                this.fEH.setPullRefresh(this.fFs);
                bef();
                if (this.fFs != null) {
                    this.fFs.dB(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (dVar.uv().us() == 0 && z) {
                this.fEH.setPullRefresh(null);
            } else {
                if (this.fFs == null) {
                    this.fFs = new com.baidu.tieba.pb.view.e(this.fxm.getPageContext());
                    this.fFs.np();
                    this.fFs.a(this.awt);
                }
                this.fEH.setPullRefresh(this.fFs);
                bef();
                if (this.fFs != null) {
                    this.fFs.dB(TbadkCoreApplication.getInst().getSkinType());
                }
                aeR();
            }
            bei();
            this.fFo.ju(this.fxD);
            this.fFo.jv(false);
            this.fFo.jG(i == 5);
            this.fFo.jH(i == 6);
            this.fFo.jI(z2 && this.fHb);
            this.fFo.a(dVar, false);
            this.fFo.notifyDataSetChanged();
            if (this.fxm.bbp()) {
                this.fGF = 0;
                PostData b = b(dVar, z);
                if (b != null && b.vj() != null) {
                    this.fGF = b.vj().getLevel_id();
                }
                if (this.fGF > 0) {
                    this.fER.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(this.fER, BitmapHelper.getGradeResourceIdInEnterForum(this.fGF));
                } else {
                    this.fER.setVisibility(8);
                }
            } else {
                this.fER.setVisibility(8);
            }
            if (dVar.aZi() != null) {
                if (dVar.aZi().uW() != null) {
                    if (dVar.aZi().uW().getNum() < 1) {
                        str = this.fxm.getResources().getString(f.j.zan);
                    } else {
                        str = dVar.aZi().uW().getNum() + "";
                    }
                    if (this.fEw != -1) {
                        dVar.aZi().uW().setIsLike(this.fEw);
                    }
                    M(str, dVar.aZi().uW().getIsLike() == 1);
                }
                if (dVar.aZi().ajH != null && dVar.aZi().ajH.isDeleted) {
                    this.fED.kB(true);
                } else {
                    this.fED.kB(false);
                }
            }
            if (this.fxm.isLogin()) {
                this.fEH.setNextPage(this.drz);
                this.fEC = 2;
                aeR();
            } else {
                this.fFY = true;
                if (dVar.uv().ur() == 1) {
                    if (this.fFt == null) {
                        this.fFt = new com.baidu.tieba.pb.view.a(this.fxm.getPageContext());
                    }
                    this.fEH.setNextPage(this.fFt);
                } else {
                    this.fEH.setNextPage(this.drz);
                }
                this.fEC = 3;
            }
            ArrayList<PostData> aZk = dVar.aZk();
            if (dVar.uv().ur() == 0 || aZk == null || aZk.size() < dVar.uv().uq()) {
                if (com.baidu.tbadk.core.util.w.y(aZk) == 0 || (com.baidu.tbadk.core.util.w.y(aZk) == 1 && aZk.get(0) != null && aZk.get(0).bwg() == 1)) {
                    this.drz.setText(this.fxm.getResources().getString(f.j.list_no_more_new));
                    if (this.fxm.baE() != null && !this.fxm.baE().beV()) {
                        this.fxm.baE().showFloatingView();
                    }
                } else if (dVar.uv().ur() == 0) {
                    this.drz.setText(this.fxm.getResources().getString(f.j.list_has_no_more));
                } else {
                    this.drz.setText(this.fxm.getResources().getString(f.j.load_more));
                }
                if (this.fxm.bbc() && this.fEH != null && this.fEH.getData() != null && this.fEH.getData().size() == 1 && (this.fEH.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.drz.setText("");
                }
                bep();
            } else if (z2) {
                if (this.fHb) {
                    Aw();
                    if (dVar.uv().ur() != 0) {
                        this.drz.setText(this.fxm.getResources().getString(f.j.pb_load_more));
                    }
                } else {
                    this.drz.Ar();
                    this.drz.showLoading();
                }
            } else {
                this.drz.Ar();
                this.drz.showLoading();
            }
            switch (i) {
                case 2:
                    this.fEH.setSelection(i2 > 1 ? (((this.fEH.getData() == null && dVar.aZk() == null) ? 0 : (this.fEH.getData().size() - dVar.aZk().size()) + this.fEH.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bdm2 = aj.bdl().bdm()) != null) {
                        this.fEH.onRestoreInstanceState(bdm2);
                        if (com.baidu.tbadk.core.util.w.y(aZk) > 1 && dVar.uv().ur() > 0) {
                            this.drz.Aw();
                            this.drz.setText(this.fxm.getString(f.j.pb_load_more_without_point));
                            this.drz.As();
                            break;
                        }
                    } else {
                        this.fEH.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fHb = false;
                    break;
                case 5:
                    this.fEH.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bdm = aj.bdl().bdm()) != null) {
                        this.fEH.onRestoreInstanceState(bdm);
                        break;
                    } else {
                        this.fEH.setSelection(0);
                        break;
                    }
                case 8:
                    if (i2 == 0) {
                        if (this.fEx != null && this.fEx.bgq() != null) {
                            if (this.fxm.isUseStyleImmersiveSticky()) {
                                this.fEH.setSelectionFromTop((this.fFo.bbH() + this.fEH.getHeaderViewsCount()) - 1, this.fEx.bgq().getHeight() - com.baidu.adp.lib.util.l.n(this.fxm.getPageContext().getPageActivity()));
                            } else {
                                this.fEH.setSelectionFromTop((this.fFo.bbH() + this.fEH.getHeaderViewsCount()) - 1, this.fEx.bgq().getHeight());
                            }
                        } else {
                            this.fEH.setSelection(this.fFo.bbH() + this.fEH.getHeaderViewsCount());
                        }
                    } else {
                        this.fEH.setSelection(i2 > 0 ? ((this.fEH.getData() == null && dVar.aZk() == null) ? 0 : (this.fEH.getData().size() - dVar.aZk().size()) + this.fEH.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.drz.Aw();
                    this.drz.setText(this.fxm.getString(f.j.pb_load_more_without_point));
                    this.drz.As();
                    break;
            }
            if (this.fGo == fGp && isHost()) {
                bex();
            }
            if (this.fGz) {
                bdx();
                this.fGz = false;
                if (i3 == 0) {
                    ke(true);
                }
            }
            if (this.fEz != null) {
                this.fEz.aq(dVar.aZi());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (dVar.fsR == 1 || dVar.fsS == 1) {
                if (this.fGG == null) {
                    this.fGG = new PbTopTipView(this.fxm);
                }
                if (dVar.fsS == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fxm.getStType())) {
                    this.fGG.setText(this.fxm.getString(f.j.pb_read_strategy_add_experience));
                    this.fGG.show(this.cSx, this.mSkinType);
                } else if (dVar.fsR == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fxm.getStType())) {
                    this.fGG.setText(this.fxm.getString(f.j.pb_read_news_add_experience));
                    this.fGG.show(this.cSx, this.mSkinType);
                }
            }
        }
    }

    private void bef() {
        if (this.fEx != null && this.fEx.bgq() != null) {
            this.fEH.removeHeaderView(this.aIr);
            if (this.mType != 1) {
                this.fEH.removeHeaderView(this.fEx.bgs());
                this.fEH.addHeaderView(this.fEx.bgs(), 0);
                return;
            }
            return;
        }
        if (this.fEx != null) {
            this.fEH.removeHeaderView(this.fEx.bgs());
        }
        this.fEH.removeHeaderView(this.aIr);
        this.fEH.addHeaderView(this.aIr, 0);
    }

    public void km(boolean z) {
        this.fFJ = z;
    }

    public void Aw() {
        if (this.drz != null) {
            this.drz.As();
            this.drz.Aw();
        }
        aeR();
    }

    public void agP() {
        this.fEH.setVisibility(0);
    }

    public void p(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && this.fFX != null && this.fFX.vj() != null && this.fED != null) {
            this.fGC = !this.fGB;
            this.fED.kA(this.fGC);
            if (this.fxm.baE() != null) {
                this.fxm.baE().kz(this.fGC);
            }
            beg();
            if (this.fGC) {
                this.fED.fJD.setVisibility(0);
                if (this.fFK) {
                    this.fED.fJE.setVisibility(8);
                    this.fEZ.setVisibility(8);
                    this.fFc.setVisibility(0);
                    this.fFc.setText(String.format(TbadkCoreApplication.getInst().getString(f.j.person_view_num), com.baidu.tbadk.core.util.ap.D(dVar.aZF())));
                } else if (!PbNormalLikeButtonSwitchStatic.Lb() || (this.fFX.vj().hadConcerned() && this.fFX.vj().getGodUserData() != null && this.fFX.vj().getGodUserData().getIsFromNetWork())) {
                    this.fED.fJE.setVisibility(8);
                }
                if (this.fGh != null) {
                    this.fGh.setVisibility(8);
                }
                this.fED.a(this.fFX.vj(), this.fHc);
                if (this.fGN == null) {
                    this.fGN = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.at.22
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > at.this.fGE) {
                                at.this.bew();
                            }
                        }
                    };
                }
                this.fEH.setListViewDragListener(this.fGN);
                return;
            }
            if (this.fED.fJD != null) {
                this.fED.fJD.setVisibility(8);
            }
            if (this.fGh != null) {
                this.fGh.setVisibility(0);
            }
            if (this.fFK) {
                this.fEZ.setVisibility(8);
                this.fFc.setVisibility(0);
                this.fFc.setText(String.format(TbadkCoreApplication.getInst().getString(f.j.person_view_num), com.baidu.tbadk.core.util.ap.D(dVar.aZF())));
            } else if (!PbNormalLikeButtonSwitchStatic.Lb() || (this.fFX.vj().hadConcerned() && this.fFX.vj().getGodUserData() != null && this.fFX.vj().getGodUserData().getIsFromNetWork())) {
                this.fEZ.setVisibility(8);
                this.fFc.setVisibility(8);
            } else {
                this.fFc.setVisibility(8);
            }
            this.fGN = null;
            this.fEH.setListViewDragListener(null);
        }
    }

    private void beg() {
        String threadId = this.fAT != null ? this.fAT.getThreadId() : "";
        int beh = beh();
        if (this.fGC) {
            if (this.fFb == null) {
                this.fFb = new ar(this.fxm.getPageContext(), this.fED.fJE, 3);
                this.fFb.h(this.fxm.getUniqueId());
            }
            if (this.fFX != null && this.fFX.vj() != null) {
                this.fFX.vj().setIsLike(this.fFX.vj().hadConcerned());
                this.fFb.a(this.fFX.vj());
            }
            this.fFb.setTid(threadId);
            this.fFb.qM(beh);
            this.fFb.fEs = this.fGB;
        }
        if (this.fFa == null) {
            this.fFa = new ar(this.fxm.getPageContext(), this.fEZ, 1);
            this.fFa.h(this.fxm.getUniqueId());
            this.fFa.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.at.24
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aX(boolean z) {
                    if (at.this.fxm != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(at.this.fxm, f.j.attention_success);
                            return;
                        }
                        as.v(at.this.fxm.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fFX != null && this.fFX.vj() != null) {
            this.fFX.vj().setIsLike(this.fFX.vj().hadConcerned());
            this.fFa.a(this.fFX.vj());
            this.fFa.setTid(threadId);
        }
        this.fFa.fEs = this.fGB;
        this.fFa.qM(beh);
    }

    public int beh() {
        if (this.fAT == null || this.fAT.aZi() == null) {
            return 0;
        }
        if (this.fAT.aZi().ws()) {
            return (com.baidu.tbadk.core.util.w.z(this.fAT.aZE()) && (this.fAT.aZh() == null || StringUtils.isNull(this.fAT.aZh().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private boolean bei() {
        boolean z;
        if (this.fFN != null && this.fFN.getVisibility() == 0) {
            if (this.fFk != null) {
                this.fFk.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fFk != null) {
                this.fFk.setVisibility(8);
            }
            z = false;
        }
        if ((this.fFm == null || this.fFm.getVisibility() == 8) && z && this.fxD) {
            this.fFl.setVisibility(0);
        } else {
            this.fFl.setVisibility(8);
        }
        return z;
    }

    private boolean q(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.aZi() == null) {
            return false;
        }
        if (dVar.aZi().vg() == 1 || dVar.aZi().getThreadType() == 33) {
            return true;
        }
        return !(dVar.aZi().vi() == null || dVar.aZi().vi().wS() == 0) || dVar.aZi().ve() == 1 || dVar.aZi().vf() == 1 || dVar.aZi().vN() || dVar.aZi().vZ() || dVar.aZi().vU() || dVar.aZi().vw() != null || !com.baidu.tbadk.core.util.ap.isEmpty(dVar.aZi().getCategory()) || dVar.aZi().vm() || dVar.aZi().vl();
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str));
            return com.baidu.tieba.card.o.a((Context) this.fxm.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            if (this.fEJ != null) {
                if (dVar.aZi() != null && dVar.aZi().vz() == 0 && !dVar.aZi().vV() && !this.fGR) {
                    this.fEJ.setVisibility(0);
                    if (dVar.aZi() != null) {
                        bb aZi = dVar.aZi();
                        aZi.e(true, q(dVar));
                        aZi.setResource(3);
                        aZi.dl("2");
                    }
                    SpannableStringBuilder vI = dVar.aZi().vI();
                    this.fEK.setOnTouchListener(new com.baidu.tieba.view.k(vI));
                    this.fEK.setText(vI);
                    this.fEK.setVisibility(0);
                } else if (dVar.aZi().vz() == 1) {
                    if (dVar.aZi() != null) {
                        this.fEJ.setVisibility(8);
                        this.fEH.removeHeaderView(this.fEJ);
                        if (dVar.aZi() != null && !dVar.aZi().vV()) {
                            this.fEN.setPadding(this.fEN.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.tbds36), this.fEN.getPaddingRight(), this.fEN.getPaddingBottom());
                        }
                    }
                } else {
                    this.fEJ.setVisibility(8);
                    this.fEH.removeHeaderView(this.fEJ);
                    if (dVar.aZi() != null && dVar.aZi().vV()) {
                        this.fEN.setPadding(this.fEN.getPaddingLeft(), 0, this.fEN.getPaddingRight(), this.fEN.getPaddingBottom());
                    } else {
                        this.fEN.setPadding(this.fEN.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds48), this.fEN.getPaddingRight(), this.fEN.getPaddingBottom());
                    }
                }
            }
            this.fxD = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (dVar != null) {
            c(dVar, z);
            bei();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (dVar != null && (b = b(dVar, z)) != null) {
            String userId = b.vj().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(f.g.tag_del_post_id, b.getId());
                sparseArray.put(f.g.tag_del_post_type, 0);
                sparseArray.put(f.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(dVar.aZu()));
                sparseArray.put(f.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.vj() != null) {
                    sparseArray.put(f.g.tag_forbid_user_name, b.vj().getUserName());
                    sparseArray.put(f.g.tag_forbid_user_name_show, b.vj().getName_show());
                    sparseArray.put(f.g.tag_forbid_user_portrait, b.vj().getPortrait());
                    sparseArray.put(f.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(f.g.tag_del_post_id, b.getId());
                sparseArray.put(f.g.tag_del_post_type, 0);
                sparseArray.put(f.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(dVar.aZu()));
                sparseArray.put(f.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<com.baidu.tbadk.core.data.ay> aZE = dVar.aZE();
                if (com.baidu.tbadk.core.util.w.y(aZE) > 0) {
                    sb = new StringBuilder();
                    for (com.baidu.tbadk.core.data.ay ayVar : aZE) {
                        if (ayVar != null && !StringUtils.isNull(ayVar.getForumName()) && (tVar = ayVar.ahr) != null && tVar.afp && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.j(ayVar.getForumName(), 12)).append(this.fxm.getString(f.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(f.g.tag_del_multi_forum, String.format(this.fxm.getString(f.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.aTf;
    }

    public void rp(String str) {
        if (this.drz != null) {
            this.drz.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fEH;
    }

    public int bej() {
        return f.g.richText;
    }

    public TextView baz() {
        return this.fEM.baz();
    }

    public void e(BdListView.e eVar) {
        this.fEH.setOnSrollToBottomListener(eVar);
    }

    public void a(g.b bVar) {
        this.awt = bVar;
        if (this.fFs != null) {
            this.fFs.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int up = alVar.up();
            int um = alVar.um();
            if (this.fFp != null) {
                this.fFp.xe();
            } else {
                this.fFp = new com.baidu.tbadk.core.dialog.a(this.fxm.getPageContext().getPageActivity());
                this.fFq = LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.dialog_direct_pager, (ViewGroup) null);
                this.fFp.w(this.fFq);
                this.fFp.a(f.j.dialog_ok, bVar);
                this.fFp.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.25
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        at.this.bel();
                        aVar.dismiss();
                    }
                });
                this.fFp.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.at.26
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (at.this.fGw == null) {
                            at.this.fGw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    at.this.fxm.HidenSoftKeyPad((InputMethodManager) at.this.fxm.getSystemService("input_method"), at.this.cSx);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.in().postDelayed(at.this.fGw, 150L);
                    }
                });
                this.fFp.b(this.fxm.getPageContext()).xe();
            }
            this.fFr = (EditText) this.fFq.findViewById(f.g.input_page_number);
            this.fFr.setText("");
            TextView textView = (TextView) this.fFq.findViewById(f.g.current_page_number);
            if (up <= 0) {
                up = 1;
            }
            if (um <= 0) {
                um = 1;
            }
            textView.setText(MessageFormat.format(this.fxm.getApplicationContext().getResources().getString(f.j.current_page), Integer.valueOf(up), Integer.valueOf(um)));
            this.fxm.ShowSoftKeyPadDelay(this.fFr, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fEH.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fxm.showToast(str);
    }

    public boolean kn(boolean z) {
        if (this.Qg == null || !this.Qg.Hw()) {
            return false;
        }
        this.Qg.FP();
        return true;
    }

    public void bek() {
        if (this.fHe != null) {
            while (this.fHe.size() > 0) {
                TbImageView remove = this.fHe.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bek();
        this.fFo.qy(1);
        if (this.fEx != null) {
            this.fEx.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        this.fFo.qy(2);
        if (this.fEx != null) {
            this.fEx.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fGy != null) {
            this.fGy.destroy();
        }
        if (this.fGP != null) {
            this.fGP.onDestory();
        }
        if (this.fGG != null) {
            this.fGG.hide();
        }
        if (this.fEA != null) {
            this.fEA.akO();
        }
        if (this.fEz != null) {
            this.fEz.onDestroy();
        }
        this.fxm.hideProgressBar();
        if (this.cSv != null && this.dkd != null) {
            this.cSv.b(this.dkd);
        }
        bel();
        Aw();
        if (this.fGw != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fGw);
        }
        if (this.fEN != null && this.fEY != null) {
            this.fEN.removeView(this.fET);
            this.fEY = null;
        }
        if (this.fGc != null) {
            this.fGc.clearStatus();
        }
        this.fGX = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fFo.qy(3);
        if (this.dov != null) {
            this.dov.setBackgroundDrawable(null);
        }
        if (this.fEx != null) {
            this.fEx.destroy();
        }
        if (this.fFo != null) {
            this.fFo.onDestroy();
        }
        this.fEH.setOnLayoutListener(null);
        if (this.fGL != null) {
            this.fGL.awr();
        }
        if (this.fGn != null) {
            this.fGn.onDestroy();
        }
        beG();
    }

    public boolean qP(int i) {
        if (this.fEx != null) {
            return this.fEx.kL(i);
        }
        return false;
    }

    public void bel() {
        this.fED.sy();
        if (this.fEA != null) {
            this.fEA.akO();
        }
        com.baidu.adp.lib.util.l.a(this.fxm.getPageContext().getPageActivity(), this.fFr);
        bdz();
        if (this.fFH != null) {
            this.fFH.dismiss();
        }
        ben();
        if (this.fEz != null) {
            this.fEz.bgj();
        }
        if (this.fFp != null) {
            this.fFp.dismiss();
        }
        if (this.dof != null) {
            this.dof.dismiss();
        }
    }

    public void bem() {
        this.fED.sy();
        if (this.fEA != null) {
            this.fEA.akO();
        }
        if (this.fFH != null) {
            this.fFH.dismiss();
        }
        ben();
        if (this.fEz != null) {
            this.fEz.bgj();
        }
        if (this.fFp != null) {
            this.fFp.dismiss();
        }
        if (this.dof != null) {
            this.dof.dismiss();
        }
    }

    public void cW(List<String> list) {
        this.fGK = list;
        if (this.fGL != null) {
            this.fGL.setData(list);
        }
    }

    public void jt(boolean z) {
        this.fFo.jt(z);
    }

    public void ko(boolean z) {
        this.fFM = z;
    }

    public void ben() {
        if (this.fFy != null) {
            this.fFy.dismiss();
        }
        if (this.fFz != null) {
            com.baidu.adp.lib.g.g.b(this.fFz, this.fxm.getPageContext());
        }
        if (this.fFA != null) {
            com.baidu.adp.lib.g.g.b(this.fFA, this.fxm.getPageContext());
        }
        if (this.fFw != null) {
            com.baidu.adp.lib.g.g.b(this.fFw, this.fxm.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fAT, this.fxD);
            d(this.fAT, this.fxD, this.mType);
            this.fxm.getLayoutMode().setNightMode(i == 1);
            this.fxm.getLayoutMode().onModeChanged(this.cSx);
            this.fxm.getLayoutMode().onModeChanged(this.fEI);
            if (this.fEz != null) {
                this.fEz.onChangeSkinType(i);
            }
            if (this.fEK != null) {
                com.baidu.tbadk.core.util.am.h(this.fEK, f.d.cp_cont_b);
                this.fEK.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_link_tip_c));
            }
            if (this.drz != null) {
                this.drz.dB(i);
                if (this.aTf != null) {
                    this.fxm.getLayoutMode().onModeChanged(this.aTf);
                    com.baidu.tbadk.core.util.am.i(this.aTf, f.C0146f.pb_foot_more_trans_selector);
                }
            }
            if (this.fFp != null) {
                this.fFp.c(this.fxm.getPageContext());
            }
            km(this.fFJ);
            this.fFo.notifyDataSetChanged();
            if (this.fFs != null) {
                this.fFs.dB(i);
            }
            if (this.Qg != null) {
                this.Qg.onChangeSkinType(i);
            }
            if (this.fEX != null) {
                this.fEX.dF(i);
            }
            if (this.fFt != null) {
                this.fFt.dB(i);
            }
            if (!com.baidu.tbadk.core.util.w.z(this.cBh)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.cBh) {
                    customBlueCheckRadioButton.Af();
                }
            }
            ki(i == 1);
            bdN();
            UtilHelper.setStatusBarBackground(this.dov, i);
            UtilHelper.setStatusBarBackground(this.fGh, i);
            if (this.fEZ != null) {
                this.fEZ.onChangeSkinType(i);
            }
            if (this.fFe != null) {
                com.baidu.tbadk.core.util.am.h(this.fFe, f.d.cp_cont_d);
            }
            if (this.fFd != null) {
                com.baidu.tbadk.core.util.am.h(this.fFd, f.d.cp_cont_d);
            }
            if (this.fFf != null) {
                com.baidu.tbadk.core.util.am.i(this.fFf, f.d.cp_cont_e);
            }
            if (this.ayn != null) {
                com.baidu.tbadk.core.util.am.h(this.ayn, f.d.cp_cont_d);
            }
            if (this.fFg != null) {
                com.baidu.tbadk.core.util.am.i(this.fFg, f.d.cp_cont_e);
            }
            if (this.fEQ != null) {
                com.baidu.tbadk.core.util.am.h(this.fEQ, f.d.cp_link_tip_a);
            }
            if (this.fFc != null) {
                com.baidu.tbadk.core.util.am.h(this.fFc, f.d.cp_cont_d);
            }
            if (this.fFh != null) {
                com.baidu.tbadk.o.a.a(this.fxm.getPageContext(), this.fFh);
            }
            if (this.fFF != null) {
                com.baidu.tbadk.o.a.a(this.fxm.getPageContext(), this.fFF);
            }
            if (this.fGx != null) {
                this.fGx.onChangeSkinType(i);
            }
            if (this.fED != null) {
                if (this.fEx != null) {
                    this.fEx.qV(i);
                } else {
                    this.fED.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fFP != null) {
                com.baidu.tbadk.core.util.am.h(this.fFP, f.d.cp_cont_e);
            }
            if (this.fER != null) {
                com.baidu.tbadk.core.util.am.c(this.fER, BitmapHelper.getGradeResourceIdInEnterForum(this.fGF));
            }
            if (this.fGM != null) {
                this.fGM.onChangeSkinType(i);
            }
            if (this.fGn != null) {
                this.fGn.onChangeSkinType();
            }
            if (this.fGJ != null) {
                com.baidu.tbadk.core.util.am.h(this.fGJ, f.d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bge = hVar;
        this.fFo.setOnImageClickListener(this.bge);
        this.fGM.setOnImageClickListener(this.bge);
    }

    public void h(NoNetworkView.a aVar) {
        this.dkd = aVar;
        if (this.cSv != null) {
            this.cSv.a(this.dkd);
        }
    }

    public void kp(boolean z) {
        this.fFo.setIsFromCDN(z);
    }

    public Button beo() {
        return this.fFN;
    }

    public void bep() {
        if (this.fEC != 2) {
            this.fEH.setNextPage(this.drz);
            this.fEC = 2;
        }
    }

    public void beq() {
        if (com.baidu.tbadk.l.m.KJ().KK()) {
            int lastVisiblePosition = this.fEH.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fEH.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(f.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog = tbImageView.getPerfLog();
                                perfLog.fl(1001);
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
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(f.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.l.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.fl(1001);
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

    public boolean ber() {
        return this.Qg != null && this.Qg.getVisibility() == 0;
    }

    public boolean bes() {
        return this.Qg != null && this.Qg.Hw();
    }

    public void bet() {
        if (this.Qg != null) {
            this.Qg.FP();
        }
    }

    public void kq(boolean z) {
        if (this.fFO != null) {
            ko(this.fxm.baA().HZ());
            if (this.fFM) {
                kf(z);
            } else {
                kg(z);
            }
        }
    }

    public void beu() {
        if (this.fFO != null) {
            this.fFO.setVisibility(8);
            this.fFT = false;
            if (this.fGn != null) {
                this.fGn.setVisibility(8);
                kk(false);
            }
            beG();
        }
    }

    public void showLoadingDialog() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.tbadk.core.view.a(this.fxm.getPageContext());
        }
        this.cIE.aN(true);
    }

    public void aeR() {
        if (this.cIE != null) {
            this.cIE.aN(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fEH.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fEH.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fEx != null) {
            this.fEx.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.fHf = getScrollY();
            this.fGm.fHv = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGm));
            a(this.fGm.fHv, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fEx != null) {
            this.fEx.b(absListView, i);
        }
        int headerViewsCount = (i - this.fEH.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fFo.qx(headerViewsCount) == com.baidu.tieba.pb.data.j.fth) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fEH.getHeaderViewsCount();
        if (this.fEL != null && this.fED != null) {
            this.fED.g(this.fEL.getBottom(), this.fEL.getMeasuredHeight(), z2);
        }
        this.fFo.bbL().i(z, this.fGf != null ? this.fGf.getMeasuredHeight() : 0);
        this.fGm.fod = i;
        this.fGm.fHu = this.fEH.getHeaderViewsCount();
        this.fGm.fHv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.fGm));
        a(this.fGm.fHv, false);
    }

    public void bev() {
        if (this.fxm.isLogin() && this.fAT != null && this.fGC && !this.fGB && !this.fFK && this.fFX != null && this.fFX.vj() != null && !this.fFX.vj().getIsLike() && !this.fFX.vj().hadConcerned()) {
            if (this.fGy == null) {
                this.fGy = new an(this.fxm);
            }
            this.fGy.a(this.fED.fJD, this.fAT.aZI(), this.fFX.vj().getUserId(), this.fAT.getThreadId());
        }
    }

    public void bew() {
        if (this.fGC && !this.fGB && this.fFX != null && this.fFX.vj() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").r("obj_locate", this.fxm.bbp() ? 2 : 1).r("obj_type", this.fGB ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.fxm.getPageContext().getPageActivity(), this.fFX.vj().getUserId(), this.fFX.vj().getUserName(), this.fxm.bao().bcc(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fGB && this.fGg != null && this.fED.bfa() != null) {
            int bbI = this.fFo.bbI();
            if (bbI > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bbI > this.fEH.getFirstVisiblePosition() - this.fEH.getHeaderViewsCount()) {
                    this.fGg.setVisibility(8);
                    return;
                }
                this.fGg.setVisibility(0);
                this.fED.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fDL == null) {
                if (this.fEH.getFirstVisiblePosition() == 0) {
                    this.fGg.setVisibility(8);
                    this.fED.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fGl) {
                        this.fGk = top;
                        this.fGl = false;
                    }
                    this.fGk = top < this.fGk ? top : this.fGk;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fFn.getY() < 0.0f) {
                        measuredHeight = fGj - alVar.fDL.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fED.bfa().getMeasuredHeight() - alVar.fDL.getMeasuredHeight();
                        this.fED.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fGk) {
                        this.fGg.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fGg.setVisibility(0);
                    } else {
                        this.fGg.setVisibility(8);
                        this.fED.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fGl = true;
                    }
                }
            }
        }
    }

    public void bex() {
        if (!this.fHg) {
            TiebaStatic.log("c10490");
            this.fHg = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fxm.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fGq, Integer.valueOf(fGs));
            aVar.ce(f.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(f.g.function_description_view)).setText(f.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(f.g.title_view)).setText(f.j.grade_thread_tips);
            aVar.w(inflate);
            aVar.C(sparseArray);
            aVar.a(f.j.grade_button_tips, this.fxm);
            aVar.b(f.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fxm.getPageContext()).xe();
        }
    }

    public void rq(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fxm.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(f.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(f.g.function_description_view)).setVisibility(8);
        aVar.w(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fGq, Integer.valueOf(fGt));
        aVar.C(sparseArray);
        aVar.a(f.j.view, this.fxm);
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.at.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fxm.getPageContext()).xe();
    }

    public void a(int i, com.baidu.tieba.pb.data.d dVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(dVar, z)) != null && b.vj() != null) {
            MetaData vj = b.vj();
            vj.setGiftNum(vj.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.d dVar, boolean z, int i) {
        b(dVar, z, i);
        p(dVar);
    }

    public PbInterviewStatusView bey() {
        return this.fGc;
    }

    private void r(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.aZi() != null && dVar.aZi().vZ() && this.fGc == null) {
            this.fGc = (PbInterviewStatusView) this.fGb.inflate();
            this.fGc.setOnClickListener(this.dog);
            this.fGc.setCallback(this.fxm.bbk());
            this.fGc.setData(this.fxm, dVar);
        }
    }

    public LinearLayout bez() {
        return this.fFn;
    }

    public View beA() {
        return this.dov;
    }

    public boolean beB() {
        return this.fGR;
    }

    public void jy(boolean z) {
        this.fEM.jy(z);
    }

    public void rr(String str) {
        if (this.fEE != null) {
            this.fEE.setTitle(str);
        }
    }

    private int kr(boolean z) {
        if (this.fGc == null || this.fGc.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds72);
    }

    private void beC() {
        if (this.fGc != null && this.fGc.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGc.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fGc.setLayoutParams(layoutParams);
        }
    }

    public boolean baG() {
        return false;
    }

    public void rs(String str) {
        this.fFP.performClick();
        if (!StringUtils.isNull(str) && this.fxm.baA() != null && this.fxm.baA().HS() != null && this.fxm.baA().HS().getInputView() != null) {
            EditText inputView = this.fxm.baA().HS().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bel();
            if (configuration.orientation == 2) {
                beu();
                bdz();
            } else {
                bdC();
            }
            if (this.fGx != null) {
                this.fGx.bbP();
            }
            this.fxm.auB();
            this.fFn.setVisibility(8);
            this.fED.kD(false);
            this.fxm.jE(false);
            if (this.fEx != null) {
                if (configuration.orientation == 1) {
                    bez().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fEH.setIsLandscape(true);
                    this.fEH.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fEH.setIsLandscape(false);
                    if (this.fHf > 0) {
                        this.fEH.smoothScrollBy(this.fHf, 0);
                    }
                }
                this.fEx.onConfigurationChanged(configuration);
                this.fGf.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void ks(boolean z) {
        this.fEB = z;
    }

    public boolean beD() {
        return this.fEx != null && this.fEx.beD();
    }

    public void beE() {
        if (this.fEx != null) {
            this.fEx.onPause();
        }
    }

    public void k(long j, int i) {
        if (this.fEz != null) {
            this.fEz.k(j, i);
        }
        if (this.fEx != null) {
            this.fEx.k(j, i);
        }
    }

    public void jJ(boolean z) {
        this.fFo.jJ(z);
    }

    public void beF() {
        if (this.fGd == null) {
            LayoutInflater.from(this.fxm.getActivity()).inflate(f.h.add_experienced_text, (ViewGroup) this.cSx, true);
            this.fGd = (ViewGroup) this.cSx.findViewById(f.g.add_experienced_layout);
            this.fGe = (TextView) this.cSx.findViewById(f.g.add_experienced);
            com.baidu.tbadk.core.util.am.h(this.fGe, f.d.cp_cont_i);
            String string = this.fxm.getResources().getString(f.j.experienced_add_success);
            String string2 = this.fxm.getResources().getString(f.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(f.d.cp_cont_h)));
            this.fGe.setText(spannableString);
        }
        this.fGd.setVisibility(0);
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
                        at.this.fGd.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                at.this.fGe.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fGe.startAnimation(scaleAnimation);
    }

    public void bm(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fFO.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fxm);
            frameLayout.setBackgroundResource(f.C0146f.pic_sign_tip);
            this.fGJ = new TextView(this.fxm);
            this.fGJ.setText(f.j.connection_tips);
            this.fGJ.setGravity(17);
            this.fGJ.setPadding(com.baidu.adp.lib.util.l.f(this.fxm, f.e.ds24), 0, com.baidu.adp.lib.util.l.f(this.fxm, f.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.fxm, f.e.ds60);
            if (this.fGJ.getParent() == null) {
                frameLayout.addView(this.fGJ, layoutParams);
            }
            this.fGI = new PopupWindow(this.fxm);
            this.fGI.setContentView(frameLayout);
            this.fGI.setHeight(-2);
            this.fGI.setWidth(-2);
            this.fGI.setFocusable(true);
            this.fGI.setOutsideTouchable(false);
            this.fGI.setBackgroundDrawable(new ColorDrawable(this.fxm.getResources().getColor(f.d.transparent)));
            this.fEH.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.at.30
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        at.this.fGI.showAsDropDown(at.this.fFO, view.getLeft(), -at.this.fFO.getHeight());
                    } else {
                        at.this.fGI.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.beR() != null && !StringUtils.isNull(aVar.beR().pkg_id) && !StringUtils.isNull(aVar.beR().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fFQ != null && this.fFQ.getVisibility() == 0) {
            if (this.fGH == null) {
                View inflate = LayoutInflater.from(this.fxm.getPageContext().getPageActivity()).inflate(f.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(f.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(f.g.single_bar_tips);
                textView.setText(f.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dog);
                this.fGH = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fFQ.getLocationInWindow(iArr);
            this.fGH.showAtLocation(this.fFQ, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds54), (iArr[1] - this.fFQ.getHeight()) - com.baidu.adp.lib.util.l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void beG() {
        com.baidu.adp.lib.g.g.a(this.fGH);
    }

    public void kt(boolean z) {
        this.fGO = z;
    }

    public boolean beH() {
        return this.fGO;
    }

    public void bn(View view) {
        this.fFF = view;
    }
}
