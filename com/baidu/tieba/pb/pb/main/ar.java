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
import android.widget.ListAdapter;
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
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
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
import com.baidu.tbadk.core.view.h;
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
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class ar {
    private com.baidu.tbadk.editortools.i IR;
    private View aJf;
    private com.baidu.tieba.pb.a.c aVH;
    private h.b amR;
    private TextView axY;
    private View.OnClickListener cIJ;
    private View cIW;
    private PbListView cMd;
    private List<com.baidu.tieba.pb.pb.main.view.a> ccX;
    private View chh;
    private NoNetworkView ctf;
    private RelativeLayout cth;
    private TextView cvb;
    private View.OnClickListener eQU;
    PbActivity.d eUu;
    private PbActivity eVp;
    private UserIconBox eWt;
    private UserIconBox eWu;
    private PbFakeFloorModel eXh;
    private com.baidu.tieba.pb.data.f eYk;
    private int etZ;
    public int fbC;
    private com.baidu.tieba.pb.video.i fbD;
    private long fbE;
    private com.baidu.tieba.pb.video.h fbF;
    private com.baidu.tieba.d.b fbG;
    public final com.baidu.tieba.pb.pb.main.view.c fbJ;
    public com.baidu.tieba.pb.pb.main.view.b fbK;
    private ViewStub fbL;
    private ViewStub fbM;
    private PbLandscapeListView fbN;
    private View fbO;
    private LinearLayout fbR;
    private f fbS;
    private ColumnLayout fbT;
    private ThreadSkinView fbU;
    private TextView fbV;
    private TextView fbW;
    private ImageView fbX;
    private HeadPendantView fbY;
    private FrameLayout fbZ;
    private View fcC;
    private View fcW;
    private TextView fcX;
    private ImageView fcY;
    private ImageView fcZ;
    private HeadImageView fca;
    private View fcb;
    private FloatingLayout fcc;
    private PbFirstFloorUserLikeButton fch;
    private ap fci;
    private ap fcj;
    private TextView fck;
    private TextView fcl;
    private TextView fcm;
    private View fcn;
    private View fco;
    private LinearLayout fcp;
    private TextView fcq;
    private TextView fcr;
    private View fcs;
    private View fct;
    private ObservedChangeLinearLayout fcv;
    private h fcw;
    private int fdD;
    private Runnable fdE;
    private s fdF;
    private am fdG;
    private int fdM;
    private PopupWindow fdO;
    private PopupWindow fdP;
    private TextView fdQ;
    private List<String> fdR;
    private com.baidu.tieba.pb.pb.main.emotion.c fdS;
    private com.baidu.tieba.pb.pb.godreply.a fdT;
    private PbLandscapeListView.b fdU;
    private boolean fdX;
    private e fdY;
    private com.baidu.tbadk.core.view.userLike.c fdZ;
    private TextView fda;
    private boolean fdc;
    private int fdd;
    private int fde;
    private PostData fdf;
    private View fdh;
    private TextView fdi;
    private ViewStub fdj;
    private PbInterviewStatusView fdk;
    private ViewGroup fdl;
    private TextView fdm;
    private FrameLayout fdn;
    private View fdo;
    private View fdp;
    private ak fdq;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fdv;
    private com.baidu.tbadk.core.view.userLike.c fea;
    private Runnable fef;
    private PbActivity.b feh;
    private boolean isLandscape;
    private int mType;
    private static final int fdr = UtilHelper.getLightStatusBarHeight();
    public static int fdx = 3;
    public static int fdy = 0;
    public static int fdz = 3;
    public static int fdA = 4;
    public static int fdB = 5;
    public static int fdC = 6;
    private boolean fbH = false;
    private int fbI = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fbP = null;
    private TextView fbQ = null;
    private TextView fcd = null;
    private TextView fce = null;
    public FrsPraiseView fcf = null;
    private ClickableHeaderImageView fcg = null;
    private View fcu = null;
    private com.baidu.tbadk.core.dialog.a fcx = null;
    private com.baidu.tbadk.core.dialog.b cII = null;
    private View fcy = null;
    private EditText fcz = null;
    private com.baidu.tieba.pb.view.i fcA = null;
    private com.baidu.tieba.pb.view.b fcB = null;
    private com.baidu.tbadk.core.dialog.a fcD = null;
    private b.InterfaceC0061b dOx = null;
    private TbRichTextView.g aVG = null;
    private NoNetworkView.a cFw = null;
    private Dialog fcE = null;
    private View fcF = null;
    private com.baidu.tbadk.core.dialog.a fcG = null;
    private Dialog fcH = null;
    private Dialog fcI = null;
    private View fcJ = null;
    private LinearLayout fcK = null;
    private CompoundButton.OnCheckedChangeListener ccY = null;
    private TextView fcL = null;
    private TextView fcM = null;
    private View fcN = null;
    private String fcO = null;
    private com.baidu.tbadk.core.dialog.b fcP = null;
    private com.baidu.tbadk.core.dialog.b fcQ = null;
    private boolean fcR = false;
    private boolean fcS = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fcT = null;
    private boolean fcU = false;
    private Button fcV = null;
    private boolean fdb = true;
    private com.baidu.tbadk.core.view.b ckj = null;
    private boolean eQQ = false;
    private int mSkinType = 3;
    private boolean fdg = false;
    private int fds = 0;
    private boolean fdt = true;
    private a fdu = new a();
    private int fdw = 0;
    private boolean fdH = false;
    private int fdI = 0;
    private boolean fdJ = false;
    private boolean fdK = false;
    private boolean fdL = false;
    private int fdN = 0;
    private boolean fdV = false;
    private a.InterfaceC0141a fdW = new a.InterfaceC0141a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0141a
        public void kW() {
        }
    };
    private String feb = null;
    private CustomMessageListener fec = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.feb = null;
            }
        }
    };
    private CustomMessageListener cXg = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fcw != null) {
                ar.this.fcw.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fed = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fbQ != null) {
                ar.this.fbQ.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fee = new Handler();
    private CustomMessageListener feg = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fdb = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fei = true;
    View.OnClickListener fej = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fdJ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
            }
            if (view == ar.this.fbJ.fgJ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").r("obj_locate", 2));
            }
            if (ar.this.eVp.eTu.ffS != null) {
                if (!ar.this.fdJ && ar.this.eYk != null && ar.this.eYk.aRp() != null && ar.this.eYk.aRp().rv() != null && ar.this.eYk.aRp().rv().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                }
                ar.this.eVp.eTu.ffS.onClick(view);
            }
        }
    };
    private boolean fek = false;
    String userId = null;
    private final List<TbImageView> fel = new ArrayList();
    private boolean fem = false;

    public void jK(boolean z) {
        this.fdH = z;
        if (this.fbN != null) {
            this.fdI = this.fbN.getHeaderViewsCount();
        }
    }

    public void aVH() {
        if (this.fbN != null) {
            int headerViewsCount = this.fbN.getHeaderViewsCount() - this.fdI;
            final int firstVisiblePosition = (this.fbN.getFirstVisiblePosition() == 0 || this.fbN.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fbN.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fbN.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fdu.feB = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fdu));
            final ak akVar = this.fdu.feB;
            final int f = f(akVar);
            final int y = ((int) this.fcv.getY()) + this.fcv.getMeasuredHeight();
            final boolean z = this.fdo.getVisibility() == 0;
            boolean z2 = this.fcv.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.fcw.aTT() + this.fbN.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fba.getMeasuredHeight() : 0;
                if (z2) {
                    this.fbN.setSelectionFromTop(this.fcw.aTT() + this.fbN.getHeaderViewsCount(), fdr - measuredHeight);
                } else {
                    this.fbN.setSelectionFromTop(this.fcw.aTT() + this.fbN.getHeaderViewsCount(), this.fbJ.aXi().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fbN.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fdJ) {
                this.fbN.setSelectionFromTop(this.fcw.aTT() + this.fbN.getHeaderViewsCount(), this.fbD.aYz().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fbN.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aUi() {
                        if (f >= 0 && f <= ar.this.cth.getMeasuredHeight()) {
                            int f2 = ar.this.f(akVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.chh.getLayoutParams();
                            if (i == 0 || i > ar.this.cth.getMeasuredHeight() || f2 >= ar.this.cth.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fdD;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.cth.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fdD;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fbN.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.chh.setLayoutParams(layoutParams);
                        }
                        ar.this.fbN.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(ak akVar) {
        if (akVar == null || akVar.getView() == null) {
            return 0;
        }
        if (akVar.getView().getTop() != 0 || akVar.getView().isShown()) {
            return akVar.getView().getBottom();
        }
        return 0;
    }

    public e aVI() {
        return this.fdY;
    }

    public NoNetworkView aVJ() {
        return this.ctf;
    }

    public void aVK() {
        if (this.IR != null) {
            this.IR.hide();
            if (this.fdS != null) {
                this.fdS.Od();
            }
        }
    }

    public PbFakeFloorModel aVL() {
        return this.eXh;
    }

    public s aVM() {
        return this.fdF;
    }

    public void aVN() {
        reset();
        aVK();
        this.fdF.aUa();
        jW(false);
    }

    private void reset() {
        if (this.eVp != null && this.eVp.aSL() != null && this.IR != null) {
            com.baidu.tbadk.editortools.pb.a.Dz().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aSL = this.eVp.aSL();
            aSL.DS();
            aSL.Do();
            if (aSL.getWriteImagesInfo() != null) {
                aSL.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aSL.eV(SendView.ALL);
            aSL.eW(SendView.ALL);
            com.baidu.tbadk.editortools.l eN = this.IR.eN(23);
            com.baidu.tbadk.editortools.l eN2 = this.IR.eN(2);
            com.baidu.tbadk.editortools.l eN3 = this.IR.eN(5);
            if (eN2 != null) {
                eN2.lE();
            }
            if (eN3 != null) {
                eN3.lE();
            }
            if (eN != null) {
                eN.hide();
            }
            this.IR.invalidate();
        }
    }

    public boolean aVO() {
        return this.fdb;
    }

    public void jL(boolean z) {
        if (this.fcW != null && this.fcX != null) {
            this.fcX.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fcW.startAnimation(alphaAnimation);
            }
            this.fcW.setVisibility(0);
            this.fdb = true;
            if (this.fdv != null && !this.fdT.isActive()) {
                this.fdv.setVisibility(0);
                jQ(true);
            }
        }
    }

    public void jM(boolean z) {
        if (this.fcW != null && this.fcX != null) {
            this.fcX.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fcW.startAnimation(alphaAnimation);
            }
            this.fcW.setVisibility(0);
            this.fdb = true;
            if (this.fdv != null && !this.fdT.isActive()) {
                this.fdv.setVisibility(0);
                jQ(true);
            }
        }
    }

    public PostData aVP() {
        int i = 0;
        if (this.fbN == null) {
            return null;
        }
        int aVQ = aVQ() - this.fbN.getHeaderViewsCount();
        if (aVQ < 0) {
            aVQ = 0;
        }
        if (this.fcw.pV(aVQ) != null && this.fcw.pV(aVQ) != PostData.gBN) {
            i = aVQ + 1;
        }
        return this.fcw.getItem(i) instanceof PostData ? (PostData) this.fcw.getItem(i) : null;
    }

    public int aVQ() {
        int i;
        View childAt;
        if (this.fbN == null) {
            return 0;
        }
        int firstVisiblePosition = this.fbN.getFirstVisiblePosition();
        int lastVisiblePosition = this.fbN.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fbN.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fbN.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int aVR() {
        return this.fbN.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.eYk != null && this.eYk.aRr() != null && !this.eYk.aRr().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.eYk.aRr().size() && (postData = this.eYk.aRr().get(i)) != null && postData.rv() != null && !StringUtils.isNull(postData.rv().getUserId()); i++) {
                if (this.eYk.aRr().get(i).rv().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fdT != null && this.fdT.isActive()) {
                        jW(false);
                    }
                    if (this.fdv != null) {
                        this.fdv.kd(true);
                    }
                    this.feb = postData.rv().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eVp = null;
        this.cth = null;
        this.cIW = null;
        this.fbE = 0L;
        this.fbN = null;
        this.fbO = null;
        this.fbR = null;
        this.fbT = null;
        this.fbV = null;
        this.fbW = null;
        this.fbZ = null;
        this.fca = null;
        this.fcb = null;
        this.fch = null;
        this.fck = null;
        this.fcl = null;
        this.fcm = null;
        this.fcn = null;
        this.fcs = null;
        this.fct = null;
        this.fcw = null;
        this.cMd = null;
        this.aJf = null;
        this.cIJ = null;
        this.eQU = null;
        this.fcW = null;
        this.fcX = null;
        this.fcY = null;
        this.fcZ = null;
        this.fda = null;
        this.fdh = null;
        this.fdi = null;
        this.fdj = null;
        this.fdM = 0;
        this.fbE = System.currentTimeMillis();
        this.eVp = pbActivity;
        this.cIJ = onClickListener;
        this.aVH = cVar;
        this.fdM = com.baidu.adp.lib.util.l.ac(this.eVp) / 2;
        this.cth = (RelativeLayout) LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.eVp.addContentView(this.cth, new FrameLayout.LayoutParams(-1, -1));
        this.cIW = this.eVp.findViewById(d.g.statebar_view);
        this.fcv = (ObservedChangeLinearLayout) this.eVp.findViewById(d.g.title_wrapper);
        this.ctf = (NoNetworkView) this.eVp.findViewById(d.g.view_no_network);
        this.fbN = (PbLandscapeListView) this.eVp.findViewById(d.g.new_pb_list);
        this.fdn = (FrameLayout) this.eVp.findViewById(d.g.root_float_header);
        this.axY = new TextView(this.eVp.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds88));
        this.fbN.addHeaderView(this.axY, 0);
        this.fdD = this.eVp.getResources().getDimensionPixelSize(d.e.ds100);
        this.chh = new View(this.eVp.getPageContext().getPageActivity());
        this.chh.setLayoutParams(new AbsListView.LayoutParams(-1, this.fdD));
        this.chh.setVisibility(4);
        this.fbN.addFooterView(this.chh);
        this.fbN.setOnTouchListener(this.eVp.aNm);
        this.fbJ = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.eVp.aTo()) {
            this.fbL = (ViewStub) this.eVp.findViewById(d.g.manga_view_stub);
            this.fbL.setVisibility(0);
            this.fbK = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.fbK.show();
            this.fbJ.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds120);
        }
        this.axY.setLayoutParams(layoutParams);
        this.fbJ.aXi().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0126a() { // from class: com.baidu.tieba.pb.pb.main.ar.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0126a
            public void amp() {
                if (ar.this.fbN != null) {
                    if (ar.this.fbD != null) {
                        ar.this.fbD.aYA();
                    }
                    ar.this.fbN.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0126a
            public void amo() {
                ar.this.eVp.alC();
            }
        }));
        this.fcW = this.eVp.findViewById(d.g.pb_editor_tool_comment);
        this.fdd = com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds90);
        this.fde = com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds242);
        this.fcX = (TextView) this.eVp.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fcZ = (ImageView) this.eVp.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fcY = (ImageView) this.eVp.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fda = (TextView) this.eVp.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fda.setVisibility(8);
        this.fcX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWS();
                if (!ar.this.eVp.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, ar.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d aSL = ar.this.eVp.aSL();
                if (aSL == null || (!aSL.DP() && !aSL.DQ())) {
                    if (ar.this.IR != null) {
                        ar.this.aWb();
                    }
                    if (ar.this.IR != null) {
                        ar.this.fdb = false;
                        if (ar.this.IR.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eVp, (View) ar.this.IR.eP(2).aBT, false, ar.this.fdW);
                        }
                    }
                    ar.this.aWD();
                    return;
                }
                ar.this.eVp.aSL().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fcY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWS();
                if (ar.this.eVp.checkUpIsLogin()) {
                    if (ar.this.IR != null) {
                        ar.this.aWb();
                        ar.this.IR.M((View) ar.this.IR.eN(5));
                    }
                    if (ar.this.IR != null) {
                        ar.this.fdb = false;
                        if (ar.this.IR.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eVp, (View) ar.this.IR.eP(2).aBT, false, ar.this.fdW);
                        }
                    }
                    ar.this.aWD();
                }
            }
        });
        this.fcZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWS();
                if (ar.this.eVp.checkUpIsLogin()) {
                    if (ar.this.IR != null) {
                        ar.this.aWb();
                        ar.this.IR.M((View) ar.this.IR.eN(2));
                    }
                    if (ar.this.IR != null) {
                        ar.this.fdb = false;
                        if (ar.this.IR.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eVp, (View) ar.this.IR.eP(2).aBT, false, ar.this.fdW);
                        }
                    }
                    ar.this.aWD();
                }
            }
        });
        this.fda.setOnClickListener(this.cIJ);
        this.fda.setOnTouchListener(this.eVp);
        this.fbO = LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fbR = (LinearLayout) LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.fbS = new f(this.eVp, this.fbR);
        this.fbS.init();
        this.fbS.a(this.fbS.aSK(), this.cIJ);
        this.fbT = (ColumnLayout) this.fbR.findViewById(d.g.pb_head_owner_root);
        this.fbU = (ThreadSkinView) this.fbR.findViewById(d.g.pb_thread_skin);
        this.fbT.setOnLongClickListener(this.onLongClickListener);
        this.fbT.setOnTouchListener(this.aVH);
        this.fbT.setVisibility(8);
        this.fbO.setOnTouchListener(this.aVH);
        this.fdh = this.fbO.findViewById(d.g.pb_head_activity_join_number_container);
        this.fdh.setVisibility(8);
        this.fdi = (TextView) this.fbO.findViewById(d.g.pb_head_activity_join_number);
        this.fbV = (TextView) this.fbT.findViewById(d.g.pb_head_owner_info_user_name);
        this.fbW = (TextView) this.fbT.findViewById(d.g.floor_owner);
        this.fbX = (ImageView) this.fbT.findViewById(d.g.icon_forum_level);
        this.fbZ = (FrameLayout) this.fbT.findViewById(d.g.pb_head_headImage_container);
        this.fca = (HeadImageView) this.fbT.findViewById(d.g.pb_head_owner_photo);
        this.fbY = (HeadPendantView) this.fbT.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fbY.wi();
        if (this.fbY.getHeadView() != null) {
            this.fbY.getHeadView().setIsRound(true);
            this.fbY.getHeadView().setDrawBorder(false);
        }
        this.eWt = (UserIconBox) this.fbT.findViewById(d.g.show_icon_vip);
        this.eWu = (UserIconBox) this.fbT.findViewById(d.g.show_icon_yinji);
        this.fcc = (FloatingLayout) this.fbR.findViewById(d.g.pb_head_owner_info_root);
        this.fch = (PbFirstFloorUserLikeButton) this.fbT.findViewById(d.g.pb_like_button);
        this.fck = (TextView) this.fbT.findViewById(d.g.pb_views);
        this.cvb = (TextView) this.fbT.findViewById(d.g.view_forum_name);
        this.fco = this.fbT.findViewById(d.g.line_right_forum_name);
        this.fcl = (TextView) this.fbT.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fcm = (TextView) this.fbT.findViewById(d.g.pb_item_first_floor_location_address);
        this.fcn = this.fbT.findViewById(d.g.line_between_time_and_locate);
        this.fdZ = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fea = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fcs = this.fbO.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fct = this.fbO.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fbO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fdj = (ViewStub) this.cth.findViewById(d.g.interview_status_stub);
        this.fcw = new h(this.eVp, this.fbN);
        this.fcw.q(this.cIJ);
        this.fcw.setTbGestureDetector(this.aVH);
        this.fcw.setOnImageClickListener(this.aVG);
        this.eQU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.abp() || !com.baidu.tieba.c.a.a(ar.this.eVp.getBaseContext(), ar.this.eVp.aSw().aUm(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                ar.this.eVp.c(sparseArray);
                                return;
                            }
                            ar.this.bm(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        ar.this.eVp.c(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fcw.D(this.eQU);
        aVW();
        this.fbN.addHeaderView(this.fbP);
        this.fbN.addHeaderView(this.fbR);
        this.fbN.addHeaderView(this.fbO);
        this.cMd = new PbListView(this.eVp.getPageContext().getPageActivity());
        this.aJf = this.cMd.getView().findViewById(d.g.pb_more_view);
        if (this.aJf != null) {
            this.aJf.setOnClickListener(this.cIJ);
            com.baidu.tbadk.core.util.aj.j(this.aJf, d.f.pb_foot_more_trans_selector);
        }
        this.cMd.wr();
        this.cMd.dw(d.f.pb_foot_more_trans_selector);
        this.cMd.dy(d.f.pb_foot_more_trans_selector);
        this.fcC = this.eVp.findViewById(d.g.viewstub_progress);
        this.eVp.registerListener(this.feg);
        this.fcb = com.baidu.tbadk.ala.b.nv().g(this.eVp.getActivity(), 2);
        if (this.fcb != null) {
            this.fcb.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.eVp.getResources().getDimensionPixelSize(d.e.ds10);
            this.fcc.addView(this.fcb, aVar);
        }
        this.eXh = new PbFakeFloorModel(this.eVp.getPageContext());
        this.fdF = new s(this.eVp.getPageContext(), this.eXh, this.cth);
        this.fdF.a(this.eVp.eUq);
        this.eXh.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.eXh.m(postData);
                ar.this.fcw.notifyDataSetChanged();
                ar.this.fdF.aUa();
                ar.this.IR.Bn();
                ar.this.jW(false);
            }
        });
        if (this.eVp.aSw() != null && !StringUtils.isNull(this.eVp.aSw().aUS())) {
            this.eVp.showToast(this.eVp.aSw().aUS());
        }
        this.fdo = this.eVp.findViewById(d.g.pb_expand_blank_view);
        this.fdp = this.eVp.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fdp.getLayoutParams();
        if (this.eVp.aSw() != null && this.eVp.aSw().aUp()) {
            this.fdo.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fdp.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fdr;
            this.fdp.setLayoutParams(layoutParams2);
        }
        this.fdq = new ak(this.eVp.getPageContext(), this.eVp.findViewById(d.g.pb_reply_expand_view));
        this.fdq.fba.setVisibility(8);
        this.fdq.F(this.cIJ);
        this.eVp.registerListener(this.cXg);
        this.eVp.registerListener(this.fec);
        this.eVp.registerListener(this.fed);
        aVS();
        jQ(false);
    }

    private void aVS() {
        this.fdT = new com.baidu.tieba.pb.pb.godreply.a(this.eVp, this, (ViewStub) this.cth.findViewById(d.g.more_god_reply_popup));
        this.fdT.setCommonClickListener(this.cIJ);
        this.fdT.D(this.eQU);
        this.fdT.setOnImageClickListener(this.aVG);
        this.fdT.setCommonClickListener(this.cIJ);
        this.fdT.setTbGestureDetector(this.aVH);
    }

    public com.baidu.tieba.pb.pb.godreply.a aVT() {
        return this.fdT;
    }

    public View aVU() {
        return this.fdo;
    }

    public void aVV() {
        if (this.fbN != null) {
            this.fbN.removeHeaderView(this.fbP);
            this.fbN.removeHeaderView(this.fbR);
            this.fbN.removeHeaderView(this.fbO);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fdv == null) {
            this.fdv = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.eVp.getPageContext().getPageActivity());
            jQ(true);
            this.fdv.a(this.cth, aVar, this.fcW.getVisibility() == 0);
            this.fdv.setOnEmotionClickListener(new a.InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0131a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(ar.this.feb)) {
                        emotionImageData.setAuthorNameShow(ar.this.feb);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0131a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.eVp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(ar.this.eVp.getPageContext().getPageActivity(), 25016, str, list, ar.this.feb, list2)));
                }
            });
            this.fdv.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    ar.this.aWS();
                    if (ar.this.fcW != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fcW.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fde - ar.this.fdd) * f) + ar.this.fdd);
                        ar.this.fcX.setAlpha(1.0f - f);
                        ar.this.fcZ.setAlpha(1.0f - f);
                        ar.this.fcY.setAlpha(1.0f - f);
                        ar.this.fcW.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aVW() {
        if (this.fbP == null) {
            int f = com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.tbds44);
            this.fbP = new LinearLayout(this.eVp.getPageContext().getPageActivity());
            this.fbP.setOrientation(1);
            this.fbP.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fbP.setPadding(f, com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.tbds30), f, com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.tbds40));
            this.fbP.setGravity(17);
            this.fbQ = new TextView(this.eVp.getPageContext().getPageActivity());
            this.fbQ.setGravity(3);
            this.fbQ.setMaxLines(2);
            this.fbQ.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_link_tip_c));
            this.fbQ.setPadding(0, 0, 0, 0);
            this.fbQ.setLineSpacing(com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.fbQ, d.C0096d.cp_cont_b);
            this.fbQ.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fbQ.setVisibility(8);
            this.fbP.addView(this.fbQ);
            this.fbP.setOnTouchListener(this.aVH);
            this.fbP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVX() {
        if (this.eVp.aTo()) {
            this.fbM = (ViewStub) this.eVp.findViewById(d.g.manga_mention_controller_view_stub);
            this.fbM.setVisibility(0);
            if (this.fcp == null) {
                this.fcp = (LinearLayout) this.eVp.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.eVp.getPageContext(), this.fcp);
            }
            if (this.fcq == null) {
                this.fcq = (TextView) this.fcp.findViewById(d.g.manga_prev_btn);
            }
            if (this.fcr == null) {
                this.fcr = (TextView) this.fcp.findViewById(d.g.manga_next_btn);
            }
            this.fcq.setOnClickListener(this.cIJ);
            this.fcr.setOnClickListener(this.cIJ);
        }
    }

    private void aVY() {
        if (this.eVp.aTo()) {
            if (this.eVp.aTr() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.fcq, d.C0096d.cp_cont_e, 1);
            }
            if (this.eVp.aTs() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.fcr, d.C0096d.cp_cont_e, 1);
            }
        }
    }

    public void aVZ() {
        if (this.fcp == null) {
            aVX();
        }
        this.fbM.setVisibility(8);
        if (this.fee != null && this.fef != null) {
            this.fee.removeCallbacks(this.fef);
        }
    }

    public void aWa() {
        if (this.fee != null) {
            if (this.fef != null) {
                this.fee.removeCallbacks(this.fef);
            }
            this.fef = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fcp == null) {
                        ar.this.aVX();
                    }
                    ar.this.fbM.setVisibility(0);
                }
            };
            this.fee.postDelayed(this.fef, 2000L);
        }
    }

    public void jN(boolean z) {
        this.fbJ.jN(z);
        if (z && this.fdg) {
            this.cMd.setText(this.eVp.getResources().getString(d.j.click_load_more));
            this.fbN.setNextPage(this.cMd);
            this.fbI = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.IR = iVar;
        this.IR.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.cth.addView(this.IR, layoutParams);
        this.IR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aVK();
        this.eVp.aSL().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.IR != null && ar.this.IR.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fdS == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.IR.getId());
                            ar.this.fdS = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.eVp.getPageContext(), ar.this.cth, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.w(ar.this.fdR)) {
                                ar.this.fdS.setData(ar.this.fdR);
                            }
                            ar.this.fdS.b(ar.this.IR);
                        }
                        ar.this.fdS.qa(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.eVp.eTy != null && ar.this.eVp.eTy.aWV() != null) {
                    if (!ar.this.eVp.eTy.aWV().bFG()) {
                        ar.this.eVp.eTy.ka(false);
                    }
                    ar.this.eVp.eTy.aWV().nU(false);
                }
            }
        });
    }

    public void aWb() {
        if (this.eVp != null && this.IR != null) {
            this.IR.lE();
            aWD();
        }
    }

    public void R(String str, boolean z) {
        this.fdc = z;
        jO(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void jO(boolean z) {
        if (this.fda != null) {
            if (this.fdc) {
                com.baidu.tbadk.core.util.aj.j(this.fda, d.f.pb_praise_already_click_selector);
                this.fda.setContentDescription(this.eVp.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.fda, d.f.pb_praise_normal_click_selector);
            this.fda.setContentDescription(this.eVp.getResources().getString(d.j.zan));
        }
    }

    public TextView aWc() {
        return this.fda;
    }

    public void jP(boolean z) {
        if (this.fbN != null && this.axY != null && this.cIW != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cIW.setVisibility(0);
                } else {
                    this.cIW.setVisibility(8);
                    this.fbN.removeHeaderView(this.axY);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.axY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fdr;
                    this.axY.setLayoutParams(layoutParams);
                }
                aWr();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.axY.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jY(true);
                this.axY.setLayoutParams(layoutParams2);
            }
            aWr();
            aWN();
        }
    }

    public h aWd() {
        return this.fcw;
    }

    public void a(PbActivity.d dVar) {
        this.eUu = dVar;
    }

    public void bm(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fcF == null) {
            this.fcF = LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.eVp.getLayoutMode().t(this.fcF);
        if (this.fcE == null) {
            this.fcE = new Dialog(this.eVp.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fcE.setCanceledOnTouchOutside(true);
            this.fcE.setCancelable(true);
            this.fcE.setContentView(this.fcF);
            WindowManager.LayoutParams attributes = this.fcE.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ac(this.eVp.getPageContext().getPageActivity()) * 0.9d);
            this.fcE.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fcE.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fcE.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fcE.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fcE != null && (ar.this.fcE instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fcE, ar.this.eVp.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || aWK()) {
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fcE != null && (ar.this.fcE instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fcE, ar.this.eVp.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.feh != null) {
                        ar.this.feh.f(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fcE != null && (ar.this.fcE instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fcE, ar.this.eVp.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.eVp.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fcE, this.eVp.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.feh = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(fdy, Integer.valueOf(fdz));
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
        this.fcG = new com.baidu.tbadk.core.dialog.a(this.eVp.getActivity());
        this.fcG.cd(i3);
        this.fcG.z(sparseArray);
        this.fcG.a(d.j.dialog_ok, this.eVp);
        this.fcG.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fcG.ao(true);
        this.fcG.b(this.eVp.getPageContext());
        this.fcG.th();
    }

    public void al(ArrayList<com.baidu.tbadk.core.data.z> arrayList) {
        if (this.fcJ == null) {
            this.fcJ = LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.eVp.getLayoutMode().t(this.fcJ);
        if (this.fcI == null) {
            this.fcI = new Dialog(this.eVp.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fcI.setCanceledOnTouchOutside(true);
            this.fcI.setCancelable(true);
            this.fcT = (ScrollView) this.fcJ.findViewById(d.g.good_scroll);
            this.fcI.setContentView(this.fcJ);
            WindowManager.LayoutParams attributes = this.fcI.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds540);
            this.fcI.getWindow().setAttributes(attributes);
            this.ccY = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fcO = (String) compoundButton.getTag();
                        if (ar.this.ccX != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : ar.this.ccX) {
                                String str = (String) aVar.getTag();
                                if (str != null && ar.this.fcO != null && !str.equals(ar.this.fcO)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fcK = (LinearLayout) this.fcJ.findViewById(d.g.good_class_group);
            this.fcM = (TextView) this.fcJ.findViewById(d.g.dialog_button_cancel);
            this.fcM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fcI instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fcI, ar.this.eVp.getPageContext());
                    }
                }
            });
            this.fcL = (TextView) this.fcJ.findViewById(d.g.dialog_button_ok);
            this.fcL.setOnClickListener(this.cIJ);
        }
        this.fcK.removeAllViews();
        this.ccX = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bJ = bJ("0", this.eVp.getPageContext().getString(d.j.def_good_class));
        this.ccX.add(bJ);
        bJ.setChecked(true);
        this.fcK.addView(bJ);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.z zVar = arrayList.get(i2);
                if (zVar != null && !TextUtils.isEmpty(zVar.pV()) && zVar.pW() > 0) {
                    com.baidu.tieba.pb.pb.main.view.a bJ2 = bJ(String.valueOf(zVar.pW()), zVar.pV());
                    this.ccX.add(bJ2);
                    View view = new View(this.eVp.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.aj.k(view, d.C0096d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fcK.addView(view);
                    this.fcK.addView(bJ2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fcT.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eVp.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eVp.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eVp.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fcT.setLayoutParams(layoutParams2);
            this.fcT.removeAllViews();
            this.fcT.addView(this.fcK);
        }
        com.baidu.adp.lib.g.g.a(this.fcI, this.eVp.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bJ(String str, String str2) {
        Activity pageActivity = this.eVp.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.ccY);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aWe() {
        this.eVp.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eVp.hideProgressBar();
        if (z && z2) {
            this.eVp.showToast(this.eVp.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.eVp.showToast(str);
        }
    }

    public void aBv() {
        this.fcC.setVisibility(0);
    }

    public void aBu() {
        this.fcC.setVisibility(8);
    }

    public View aWf() {
        if (this.fcJ != null) {
            return this.fcJ.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String aWg() {
        return this.fcO;
    }

    public View getView() {
        return this.cth;
    }

    public void aWh() {
        com.baidu.adp.lib.util.l.a(this.eVp.getPageContext().getPageActivity(), this.eVp.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.eVp.hideProgressBar();
        if (z) {
            aWw();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            aWx();
        } else {
            aWw();
        }
    }

    public void aWi() {
        this.cMd.wr();
        this.cMd.wv();
    }

    public void aWj() {
        this.eVp.hideProgressBar();
        ww();
        this.fbN.completePullRefreshPostDelayed(2000L);
        aWt();
    }

    public void aWk() {
        this.fbN.completePullRefreshPostDelayed(2000L);
        aWt();
    }

    private void jQ(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fcX.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eVp.getResources().getDimensionPixelSize(d.e.ds130) : this.eVp.getResources().getDimensionPixelSize(d.e.ds34);
        this.fcX.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fcw.setOnLongClickListener(onLongClickListener);
        if (this.fdT != null) {
            this.fdT.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0061b interfaceC0061b, boolean z, boolean z2) {
        if (this.fcP != null) {
            this.fcP.dismiss();
            this.fcP = null;
        }
        this.fcP = new com.baidu.tbadk.core.dialog.b(this.eVp.getPageContext().getPageActivity());
        this.fcP.cg(d.j.operation);
        if (z2) {
            this.fcP.a(new String[]{this.eVp.getPageContext().getString(d.j.copy)}, interfaceC0061b);
        } else if (!z) {
            this.fcP.a(new String[]{this.eVp.getPageContext().getString(d.j.copy), this.eVp.getPageContext().getString(d.j.mark)}, interfaceC0061b);
        } else {
            this.fcP.a(new String[]{this.eVp.getPageContext().getString(d.j.copy), this.eVp.getPageContext().getString(d.j.remove_mark)}, interfaceC0061b);
        }
        this.fcP.d(this.eVp.getPageContext());
        this.fcP.tl();
    }

    public void a(b.InterfaceC0061b interfaceC0061b, boolean z) {
        if (this.fcQ != null) {
            this.fcQ.dismiss();
            this.fcQ = null;
        }
        this.fcQ = new com.baidu.tbadk.core.dialog.b(this.eVp.getPageContext().getPageActivity());
        this.fcQ.cg(d.j.operation);
        if (z) {
            this.fcQ.a(new String[]{this.eVp.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0061b);
        } else {
            this.fcQ.a(new String[]{this.eVp.getPageContext().getString(d.j.save_to_emotion), this.eVp.getPageContext().getString(d.j.save_to_local)}, interfaceC0061b);
        }
        this.fcQ.d(this.eVp.getPageContext());
        this.fcQ.tl();
    }

    public int aWl() {
        return ql(this.fbN.getFirstVisiblePosition());
    }

    private int ql(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.fbN.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fbN.getAdapter() == null || !(this.fbN.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.fbN.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aWm() {
        int lastVisiblePosition = this.fbN.getLastVisiblePosition();
        if (this.fbD != null) {
            if (lastVisiblePosition == this.fbN.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return ql(lastVisiblePosition);
    }

    public void qm(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fbN != null) {
            if (this.fbJ == null || this.fbJ.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fbJ.mNavigationBar.getFixedNavHeight();
                if (this.eVp.aTa() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fdp != null && (layoutParams = (LinearLayout.LayoutParams) this.fdp.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fdp.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fbN.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fbN.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fcz.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        this.fcw.a(fVar, false);
        this.fcw.notifyDataSetChanged();
        aWt();
        if (this.fdT != null) {
            this.fdT.aSs();
        }
    }

    public void q(com.baidu.tieba.pb.data.f fVar) {
        if (this.fcf == null) {
            this.eVp.getLayoutMode().t(((ViewStub) this.fbO.findViewById(d.g.praise_layout)).inflate());
            this.fcf = (FrsPraiseView) this.fbO.findViewById(d.g.pb_head_praise_view);
            this.fcf.setIsFromPb(true);
            this.fcu = this.fbO.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fcf.dE(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fcf != null) {
            boolean aWt = aWt();
            this.fcf.setVisibility(8);
            if (fVar != null && fVar.qy() != null && fVar.qy().qv() == 0 && this.eQQ) {
                if (aWt) {
                    this.fct.setVisibility(0);
                    return;
                } else {
                    this.fct.setVisibility(8);
                    return;
                }
            }
            this.fct.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aRy() != null) {
            return fVar.aRy();
        }
        if (!com.baidu.tbadk.core.util.v.w(fVar.aRr())) {
            Iterator<PostData> it = fVar.aRr().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bwU() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aRw();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.rv() != null && postData.rv().getUserTbVipInfoData() != null && postData.rv().getUserTbVipInfoData().getvipIntro() != null) {
            postData.rv().getGodUserData().setIntro(postData.rv().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aRp() == null || fVar.aRp().rv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rv = fVar.aRp().rv();
        String userId = rv.getUserId();
        HashMap<String, MetaData> userMap = fVar.aRp().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rv;
        }
        postData.uw(1);
        postData.setId(fVar.aRp().rM());
        postData.setTitle(fVar.aRp().getTitle());
        postData.setTime(fVar.aRp().getCreateTime());
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
        int f;
        com.baidu.tbadk.data.i bwY;
        String portrait;
        if (fVar != null && fVar.aRp() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aWL();
            this.fbT.setVisibility(8);
            if (fVar.aRp() != null && fVar.aRp().si() && fVar.aRp().rN() != null) {
                this.fdJ = true;
                this.fbJ.kk(this.fdJ);
                this.fbJ.mNavigationBar.hideBottomLine();
                if (this.fbD == null) {
                    this.fbD = new com.baidu.tieba.pb.video.i(this.eVp, this.fbJ, fVar.aRp().rN(), this.fbE);
                    this.fbD.a(fVar.aRp().rN(), fVar.aRp(), fVar.getForumId());
                    this.fbD.startPlay();
                } else if (this.fbH) {
                    this.fbD.a(fVar.aRp().rN(), fVar.aRp(), fVar.getForumId());
                    this.fbD.startPlay();
                } else {
                    this.fbD.qm(fVar.getForumId());
                }
                if (fVar.aRq() != null && fVar.aRq().size() >= 1) {
                    bd bdVar = fVar.aRq().get(0);
                    this.fbD.af(bdVar);
                    this.fbD.qn(bdVar.getTitle());
                }
                this.fbD.b(b, fVar.aRp(), fVar.aRL());
                this.fbH = false;
                this.fbN.removeHeaderView(this.fbD.aYB());
                this.fbN.addHeaderView(this.fbD.aYB(), 0);
                if (this.fbD.aYz() != null && this.fbD.aYz().getParent() == null) {
                    this.fdn.addView(this.fbD.aYz());
                }
                if (this.fbF == null) {
                    this.fbF = new com.baidu.tieba.pb.video.h(this.eVp);
                }
                this.fbF.a(fVar.aRp().sA(), fVar.aRp(), fVar.aRI());
                this.fbN.removeHeaderView(this.fbF.aYq());
                this.fbN.addHeaderView(this.fbF.aYq(), 1);
                if (fVar.aRp().sA() != null) {
                    this.fbN.removeHeaderView(this.fbF.aYr());
                    this.fbN.removeHeaderView(this.fbR);
                    this.fbN.addHeaderView(this.fbF.aYr(), 2);
                } else {
                    if (this.fbF.aYr() != null) {
                        this.fbN.removeHeaderView(this.fbF.aYr());
                    }
                    this.fbN.removeHeaderView(this.fbR);
                    this.fbR.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.eVp, d.e.tbds56));
                    this.fbN.addHeaderView(this.fbR, 2);
                }
                if (this.fbD != null) {
                    this.fbJ.kg(false);
                    this.fbJ.kh(TbadkCoreApplication.isLogin());
                    this.fbD.qt(TbadkCoreApplication.getInst().getSkinType());
                }
                aWr();
            } else {
                this.fdJ = false;
                this.fbJ.kk(this.fdJ);
                if (this.fbD != null) {
                    this.fbN.removeHeaderView(this.fbD.aYB());
                }
                if (this.fbF != null) {
                    this.fbF.f(this.fbN);
                }
                if (b == null || (b != null && (b.bwX() == null || com.baidu.tbadk.core.util.v.w(b.bwX().Jr())))) {
                    this.fbR.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.eVp, d.e.tbds80));
                } else {
                    this.fbR.setPadding(0, 0, 0, 0);
                }
            }
            if (this.eVp.aSP() != null) {
                this.eVp.aSP().ke(this.fdJ);
            }
            if (this.fbD != null) {
                this.fbD.H(this.fej);
            }
            if (b != null) {
                this.fdf = b;
                this.fbT.setVisibility(0);
                if (this.eVp.aTC()) {
                    if (fVar.aRo() != null) {
                        this.mForumName = fVar.aRo().getForumName();
                        this.mForumId = fVar.aRo().getForumId();
                    }
                    if (this.mForumName == null && this.eVp.aSw() != null && this.eVp.aSw().aUl() != null) {
                        this.mForumName = this.eVp.aSw().aUl();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fbT.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fbT.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fdX) {
                    this.fbP.setVisibility(0);
                }
                if (!fVar.aRp().si() && this.fbQ.getText() != null && this.fbQ.getText().length() > 0) {
                    this.fbQ.setVisibility(0);
                } else {
                    this.fbQ.setVisibility(8);
                }
                q(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rH = fVar.aRp().rH();
                if (rH != null && rH.size() > 0 && !this.fdX) {
                    this.fdi.setText(String.valueOf(rH.get(0).pr()));
                    this.fdh.setVisibility(0);
                } else {
                    this.fdh.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.fdh, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.fdi, d.C0096d.cp_link_tip_d, 1);
                if (b.rv() != null) {
                    String string = b.rv().getName_show() == null ? StringUtils.string(b.rv().getUserName()) : StringUtils.string(b.rv().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.rv().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.aP(b.rv().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aP(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.rv().getIconInfo();
                            tShowInfoNew = b.rv().getTShowInfoNew();
                            if (this.eWu != null) {
                                this.eWu.setTag(d.g.tag_user_id, b.rv().getUserId());
                                this.eWu.setOnClickListener(this.eVp.eTu.cST);
                                this.eWu.a(iconInfo, 4, this.eVp.getResources().getDimensionPixelSize(d.e.tbds36), this.eVp.getResources().getDimensionPixelSize(d.e.tbds36), this.eVp.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.eWt != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eWt.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eWt.setOnClickListener(this.eVp.eTu.ffT);
                                this.eWt.a(tShowInfoNew, 3, this.eVp.getResources().getDimensionPixelSize(d.e.tbds36), this.eVp.getResources().getDimensionPixelSize(d.e.tbds36), this.eVp.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fbV.setText(ag(b.rv().getSealPrefix(), e));
                            this.fbV.setTag(d.g.tag_user_id, b.rv().getUserId());
                            this.fbV.setTag(d.g.tag_user_name, b.rv().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew) || b.rv().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.fbV, d.C0096d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.fbV, d.C0096d.cp_cont_f, 1);
                            }
                            this.fbW.setVisibility(8);
                            if (fVar.aRp().rv() != null && fVar.aRp().rv().getAlaUserData() != null && this.fcb != null) {
                                if (fVar.aRp().rv().getAlaUserData().anchor_live != 0) {
                                    this.fcb.setVisibility(8);
                                } else {
                                    this.fcb.setVisibility(0);
                                    if (this.fbG == null) {
                                        this.fbG = new com.baidu.tieba.d.b(this.eVp.getPageContext(), this.fcb);
                                        this.fbG.iW(1);
                                    }
                                    this.fbG.aL(this.eVp.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Rb = fVar.aRp().rv().getAlaUserData();
                                    aVar.type = 2;
                                    this.fcb.setTag(aVar);
                                }
                            }
                            this.fca.setUserId(b.rv().getUserId());
                            this.fca.setUserName(b.rv().getUserName());
                            this.fca.setImageDrawable(null);
                            this.fca.setRadius(com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds40));
                            this.fca.setTag(b.rv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fcl.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            } else {
                                this.fcl.setText(com.baidu.tbadk.core.util.am.r(b.getTime()));
                            }
                            f = com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds16);
                            if (!this.eVp.aTC() && !StringUtils.isNull(this.mForumName)) {
                                this.cvb.setText(this.eVp.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.cvb.setVisibility(0);
                                this.fco.setVisibility(0);
                                this.fcl.setPadding(f, 0, f, 0);
                            } else {
                                this.cvb.setVisibility(8);
                                this.fco.setVisibility(8);
                                this.fcl.setPadding(0, 0, f, 0);
                            }
                            bwY = b.bwY();
                            if (bwY == null && !TextUtils.isEmpty(bwY.getName()) && !TextUtils.isEmpty(bwY.getName().trim())) {
                                final String name = bwY.getName();
                                final String lat = bwY.getLat();
                                final String lng = bwY.getLng();
                                this.fcm.setVisibility(0);
                                this.fcn.setVisibility(0);
                                this.fcm.setText(bwY.getName());
                                this.fcm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.hh()) {
                                                ar.this.eVp.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.O(ar.this.eVp.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, ar.this.eVp.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fcm.setVisibility(8);
                                this.fcn.setVisibility(8);
                            }
                            portrait = b.rv().getPortrait();
                            if (b.rv().getPendantData() == null && !StringUtils.isNull(b.rv().getPendantData().pR())) {
                                UtilHelper.showHeadImageViewBigV(this.fbY.getHeadView(), b.rv());
                                this.fca.setVisibility(8);
                                this.fbY.setVisibility(0);
                                if (this.fcg != null) {
                                    this.fcg.setVisibility(8);
                                }
                                this.fbV.setOnClickListener(this.fej);
                                this.fbY.getHeadView().startLoad(portrait, 28, false);
                                this.fbY.getHeadView().setUserId(b.rv().getUserId());
                                this.fbY.getHeadView().setUserName(b.rv().getUserName());
                                this.fbY.getHeadView().setOnClickListener(this.fej);
                                this.fbY.es(b.rv().getPendantData().pR());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fca, b.rv());
                                this.fca.setVisibility(0);
                                this.fbT.setOnClickListener(this.fej);
                                this.fbV.setOnClickListener(this.fej);
                                this.fca.setOnClickListener(this.fej);
                                this.fbY.setVisibility(8);
                                this.fca.startLoad(portrait, 28, false);
                            }
                            String name_show = b.rv().getName_show();
                            String userName = b.rv().getUserName();
                            if (com.baidu.tbadk.o.ac.fS() && name_show != null && !name_show.equals(userName)) {
                                this.fbV.setText(com.baidu.tieba.pb.c.aj(this.eVp.getPageContext().getPageActivity(), this.fbV.getText().toString()));
                                this.fbV.setGravity(16);
                                this.fbV.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQR());
                                com.baidu.tbadk.core.util.aj.c(this.fbV, d.C0096d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.rv().getIconInfo();
                        tShowInfoNew = b.rv().getTShowInfoNew();
                        if (this.eWu != null) {
                        }
                        if (this.eWt != null) {
                        }
                        this.fbV.setText(ag(b.rv().getSealPrefix(), e));
                        this.fbV.setTag(d.g.tag_user_id, b.rv().getUserId());
                        this.fbV.setTag(d.g.tag_user_name, b.rv().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.fbV, d.C0096d.cp_cont_h, 1);
                        this.fbW.setVisibility(8);
                        if (fVar.aRp().rv() != null) {
                            if (fVar.aRp().rv().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fca.setUserId(b.rv().getUserId());
                        this.fca.setUserName(b.rv().getUserName());
                        this.fca.setImageDrawable(null);
                        this.fca.setRadius(com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds40));
                        this.fca.setTag(b.rv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds16);
                        if (!this.eVp.aTC()) {
                        }
                        this.cvb.setVisibility(8);
                        this.fco.setVisibility(8);
                        this.fcl.setPadding(0, 0, f, 0);
                        bwY = b.bwY();
                        if (bwY == null) {
                        }
                        this.fcm.setVisibility(8);
                        this.fcn.setVisibility(8);
                        portrait = b.rv().getPortrait();
                        if (b.rv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fca, b.rv());
                        this.fca.setVisibility(0);
                        this.fbT.setOnClickListener(this.fej);
                        this.fbV.setOnClickListener(this.fej);
                        this.fca.setOnClickListener(this.fej);
                        this.fbY.setVisibility(8);
                        this.fca.startLoad(portrait, 28, false);
                        String name_show2 = b.rv().getName_show();
                        String userName2 = b.rv().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                            this.fbV.setText(com.baidu.tieba.pb.c.aj(this.eVp.getPageContext().getPageActivity(), this.fbV.getText().toString()));
                            this.fbV.setGravity(16);
                            this.fbV.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQR());
                            com.baidu.tbadk.core.util.aj.c(this.fbV, d.C0096d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.rv().getIconInfo();
                            tShowInfoNew = b.rv().getTShowInfoNew();
                            if (this.eWu != null) {
                            }
                            if (this.eWt != null) {
                            }
                            this.fbV.setText(ag(b.rv().getSealPrefix(), e));
                            this.fbV.setTag(d.g.tag_user_id, b.rv().getUserId());
                            this.fbV.setTag(d.g.tag_user_name, b.rv().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.fbV, d.C0096d.cp_cont_h, 1);
                            this.fbW.setVisibility(8);
                            if (fVar.aRp().rv() != null) {
                            }
                            this.fca.setUserId(b.rv().getUserId());
                            this.fca.setUserName(b.rv().getUserName());
                            this.fca.setImageDrawable(null);
                            this.fca.setRadius(com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds40));
                            this.fca.setTag(b.rv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            f = com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds16);
                            if (!this.eVp.aTC()) {
                            }
                            this.cvb.setVisibility(8);
                            this.fco.setVisibility(8);
                            this.fcl.setPadding(0, 0, f, 0);
                            bwY = b.bwY();
                            if (bwY == null) {
                            }
                            this.fcm.setVisibility(8);
                            this.fcn.setVisibility(8);
                            portrait = b.rv().getPortrait();
                            if (b.rv().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fca, b.rv());
                            this.fca.setVisibility(0);
                            this.fbT.setOnClickListener(this.fej);
                            this.fbV.setOnClickListener(this.fej);
                            this.fca.setOnClickListener(this.fej);
                            this.fbY.setVisibility(8);
                            this.fca.startLoad(portrait, 28, false);
                            String name_show22 = b.rv().getName_show();
                            String userName22 = b.rv().getUserName();
                            if (com.baidu.tbadk.o.ac.fS()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.rv().getIconInfo();
                        tShowInfoNew = b.rv().getTShowInfoNew();
                        if (this.eWu != null) {
                        }
                        if (this.eWt != null) {
                        }
                        this.fbV.setText(ag(b.rv().getSealPrefix(), e));
                        this.fbV.setTag(d.g.tag_user_id, b.rv().getUserId());
                        this.fbV.setTag(d.g.tag_user_name, b.rv().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.fbV, d.C0096d.cp_cont_h, 1);
                        this.fbW.setVisibility(8);
                        if (fVar.aRp().rv() != null) {
                        }
                        this.fca.setUserId(b.rv().getUserId());
                        this.fca.setUserName(b.rv().getUserName());
                        this.fca.setImageDrawable(null);
                        this.fca.setRadius(com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds40));
                        this.fca.setTag(b.rv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.eVp.getActivity(), d.e.ds16);
                        if (!this.eVp.aTC()) {
                        }
                        this.cvb.setVisibility(8);
                        this.fco.setVisibility(8);
                        this.fcl.setPadding(0, 0, f, 0);
                        bwY = b.bwY();
                        if (bwY == null) {
                        }
                        this.fcm.setVisibility(8);
                        this.fcn.setVisibility(8);
                        portrait = b.rv().getPortrait();
                        if (b.rv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fca, b.rv());
                        this.fca.setVisibility(0);
                        this.fbT.setOnClickListener(this.fej);
                        this.fbV.setOnClickListener(this.fej);
                        this.fca.setOnClickListener(this.fej);
                        this.fbY.setVisibility(8);
                        this.fca.startLoad(portrait, 28, false);
                        String name_show222 = b.rv().getName_show();
                        String userName222 = b.rv().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.fbS.Y(fVar.aRp());
                }
                if (this.fdq != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.ePV);
                    if (fVar != null && fVar.aRp() != null) {
                        jVar.ePX = fVar.aRp().rn();
                    }
                    jVar.aFP = !this.eQQ;
                    jVar.ePZ = this.eVp.aTB();
                    this.fdq.a(jVar);
                }
            }
        }
    }

    public void jR(boolean z) {
        if (z) {
            aWn();
        } else {
            aWo();
        }
        this.fdu.feB = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fdu));
        a(this.fdu.feB, false);
    }

    public void aWn() {
        if (this.fbJ != null && !this.fdL) {
            this.fbJ.kl(!StringUtils.isNull(this.eVp.aSX()));
            this.fdL = true;
        }
    }

    public void aWo() {
        if (this.fbJ != null) {
            this.fbJ.aXo();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rR() != null) {
            this.fbU.a(this.eVp.getPageContext(), fVar.aRr().get(0).rR(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aRn().getId(), fVar.aRn().getName(), fVar.aRp().getId(), this.eVp.aTy() ? "FRS" : null));
            this.fbT.setPadding(this.fbT.getPaddingLeft(), (int) this.eVp.getResources().getDimension(d.e.ds20), this.fbT.getPaddingRight(), this.fbT.getPaddingBottom());
            return;
        }
        this.fbU.a(null, null, null);
    }

    public void aWp() {
        if (this.fbD != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.fbD.aYA();
            this.fbN.smoothScrollToPosition(0);
        }
    }

    public boolean aWq() {
        return this.fek;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean P(bd bdVar) {
        if (bdVar == null || bdVar.rv() == null || bdVar.rv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rv().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.fbJ.aXm();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.fbJ.nG(eVar.forumName);
            }
            String string = this.eVp.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eVp.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.eVp.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.eVp.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.ePk;
            this.eVp.showNetRefreshView(this.cth, format, null, this.eVp.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.core.util.av.vI().c(ar.this.eVp.getPageContext(), new String[]{str2});
                        ar.this.eVp.finish();
                        return;
                    }
                    ar.this.eVp.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aVw;
        Parcelable aVw2;
        String str;
        if (fVar != null) {
            this.eYk = fVar;
            this.mType = i;
            if (fVar.aRp() != null) {
                this.fdw = fVar.aRp().rg();
                if (fVar.aRp().getAnchorLevel() != 0) {
                    this.fek = true;
                }
                this.fcS = P(fVar.aRp());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            t(fVar);
            this.fdg = false;
            this.eQQ = z;
            aWj();
            b(fVar, z, i);
            PostData b = b(fVar, z);
            this.fcw.jp(this.fbR.getPaddingBottom() > 0 || (b != null && b.getType() == PostData.gBN));
            r(fVar);
            if (this.eVp.aTo()) {
                if (this.fcA == null) {
                    this.fcA = new com.baidu.tieba.pb.view.i(this.eVp.getPageContext());
                    this.fcA.kX();
                    this.fcA.a(this.amR);
                }
                this.fbN.setPullRefresh(this.fcA);
                aWr();
                if (this.fcA != null) {
                    this.fcA.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qy().qv() == 0 && z) {
                this.fbN.setPullRefresh(null);
            } else {
                if (this.fcA == null) {
                    this.fcA = new com.baidu.tieba.pb.view.i(this.eVp.getPageContext());
                    this.fcA.kX();
                    this.fcA.a(this.amR);
                }
                this.fbN.setPullRefresh(this.fcA);
                aWr();
                if (this.fcA != null) {
                    this.fcA.dz(TbadkCoreApplication.getInst().getSkinType());
                }
                XC();
            }
            aWt();
            this.fcw.iZ(this.eQQ);
            this.fcw.ja(false);
            this.fcw.jl(i == 5);
            this.fcw.jm(i == 6);
            this.fcw.jn(z2 && this.fei);
            this.fcw.a(fVar, false);
            this.fcw.notifyDataSetChanged();
            if (this.eVp.aTC()) {
                this.fdN = 0;
                PostData b2 = b(fVar, z);
                if (b2 != null && b2.rv() != null) {
                    this.fdN = b2.rv().getLevel_id();
                }
                if (this.fdN > 0) {
                    this.fbX.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.fbX, BitmapHelper.getGradeResourceIdInEnterForum(this.fdN));
                } else {
                    this.fbX.setVisibility(8);
                }
            } else {
                this.fbX.setVisibility(8);
            }
            if (fVar.aRp() != null && fVar.aRp().rk() != null) {
                if (fVar.aRp().rk().getNum() < 1) {
                    str = this.eVp.getResources().getString(d.j.zan);
                } else {
                    str = fVar.aRp().rk().getNum() + "";
                }
                if (this.fbC != -1) {
                    fVar.aRp().rk().setIsLike(this.fbC);
                }
                R(str, fVar.aRp().rk().getIsLike() == 1);
            }
            if (this.eVp.isLogin()) {
                this.fbN.setNextPage(this.cMd);
                this.fbI = 2;
                XC();
            } else {
                this.fdg = true;
                if (fVar.qy().qu() == 1) {
                    if (this.fcB == null) {
                        this.fcB = new com.baidu.tieba.pb.view.b(this.eVp.getPageContext());
                    }
                    this.fbN.setNextPage(this.fcB);
                } else {
                    this.fbN.setNextPage(this.cMd);
                }
                this.fbI = 3;
            }
            ArrayList<PostData> aRr = fVar.aRr();
            if (fVar.qy().qu() == 0 || aRr == null || aRr.size() < fVar.qy().qt()) {
                if (com.baidu.tbadk.core.util.v.v(aRr) == 0 || (com.baidu.tbadk.core.util.v.v(aRr) == 1 && aRr.get(0) != null && aRr.get(0).bwU() == 1)) {
                    this.cMd.setText(this.eVp.getResources().getString(d.j.list_no_more_new));
                    if (this.eVp.aSP() != null && !this.eVp.aSP().aXf()) {
                        this.eVp.aSP().showFloatingView();
                    }
                } else {
                    this.cMd.setText(this.eVp.getResources().getString(d.j.list_has_no_more));
                }
                if (this.eVp.aTo() && this.fbN != null && this.fbN.getData() != null && this.fbN.getData().size() == 1 && (this.fbN.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.cMd.setText("");
                }
                aWA();
            } else if (z2) {
                if (this.fei) {
                    ww();
                    if (fVar.qy().qu() != 0) {
                        this.cMd.setText(this.eVp.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.cMd.wr();
                    this.cMd.showLoading();
                }
            } else {
                this.cMd.wr();
                this.cMd.showLoading();
            }
            switch (i) {
                case 2:
                    this.fbN.setSelection(i2 > 1 ? (((this.fbN.getData() == null && fVar.aRr() == null) ? 0 : (this.fbN.getData().size() - fVar.aRr().size()) + this.fbN.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aVw2 = ai.aVv().aVw()) != null) {
                        this.fbN.onRestoreInstanceState(aVw2);
                        if (com.baidu.tbadk.core.util.v.v(aRr) > 1 && fVar.qy().qu() > 0) {
                            this.cMd.ww();
                            this.cMd.setText(this.eVp.getString(d.j.pb_load_more_without_point));
                            this.cMd.ws();
                            break;
                        }
                    } else {
                        this.fbN.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fei = false;
                    break;
                case 5:
                    this.fbN.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aVw = ai.aVv().aVw()) != null) {
                        this.fbN.onRestoreInstanceState(aVw);
                        break;
                    } else {
                        this.fbN.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fbD != null && this.fbD.aYz() != null) {
                            if (this.eVp.isUseStyleImmersiveSticky()) {
                                this.fbN.setSelectionFromTop((this.fcw.aTS() + this.fbN.getHeaderViewsCount()) - 1, this.fbD.aYz().getHeight() - com.baidu.adp.lib.util.l.n(this.eVp.getPageContext().getPageActivity()));
                            } else {
                                this.fbN.setSelectionFromTop((this.fcw.aTS() + this.fbN.getHeaderViewsCount()) - 1, this.fbD.aYz().getHeight());
                            }
                        } else {
                            this.fbN.setSelection(this.fcw.aTS() + this.fbN.getHeaderViewsCount());
                        }
                    } else {
                        this.fbN.setSelection(i2 > 0 ? ((this.fbN.getData() == null && fVar.aRr() == null) ? 0 : (this.fbN.getData().size() - fVar.aRr().size()) + this.fbN.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.cMd.ww();
                    this.cMd.setText(this.eVp.getString(d.j.pb_load_more_without_point));
                    this.cMd.ws();
                    break;
            }
            if (this.fdw == fdx && isHost()) {
                aWG();
            }
            if (this.fdH) {
                aVH();
                this.fdH = false;
                if (i3 == 0) {
                    jK(true);
                }
            }
            if (this.fbF != null) {
                this.fbF.ae(fVar.aRp());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aWr() {
        if (this.fbD != null && this.fbD.aYz() != null) {
            this.fbN.removeHeaderView(this.axY);
            if (this.mType != 1) {
                this.fbN.removeHeaderView(this.fbD.aYB());
                this.fbN.addHeaderView(this.fbD.aYB(), 0);
                return;
            }
            return;
        }
        if (this.fbD != null) {
            this.fbN.removeHeaderView(this.fbD.aYB());
        }
        this.fbN.removeHeaderView(this.axY);
        this.fbN.addHeaderView(this.axY, 0);
    }

    public void jS(boolean z) {
        this.fcR = z;
    }

    public void ww() {
        if (this.cMd != null) {
            this.cMd.ws();
            this.cMd.ww();
        }
        XC();
    }

    public void PB() {
        this.fbN.setVisibility(0);
    }

    public void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.fdf != null && this.fdf.rv() != null && this.fbJ != null) {
            this.fdK = !this.fdJ;
            this.fbJ.kg(this.fdK);
            if (this.eVp.aSP() != null) {
                this.eVp.aSP().kf(this.fdK);
            }
            aWs();
            if (this.fdK) {
                this.fbJ.fgH.setVisibility(0);
                if (this.fcS) {
                    this.fbJ.fgI.setVisibility(8);
                    this.fch.setVisibility(8);
                    this.fck.setVisibility(0);
                    this.fck.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aRK())));
                } else if (!PbNormalLikeButtonSwitchStatic.GV() || (this.fdf.rv().hadConcerned() && this.fdf.rv().getGodUserData() != null && this.fdf.rv().getGodUserData().getIsFromNetWork())) {
                    this.fbJ.fgI.setVisibility(8);
                }
                if (this.fdp != null) {
                    this.fdp.setVisibility(8);
                }
                this.fbJ.a(this.fdf.rv(), this.fej);
                if (this.fdU == null) {
                    this.fdU = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fdM) {
                                ar.this.aWF();
                            }
                        }
                    };
                }
                this.fbN.setListViewDragListener(this.fdU);
                return;
            }
            if (this.fbJ.fgH != null) {
                this.fbJ.fgH.setVisibility(8);
            }
            if (this.fdp != null) {
                this.fdp.setVisibility(0);
            }
            if (this.fcS) {
                this.fch.setVisibility(8);
                this.fck.setVisibility(0);
                this.fck.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aRK())));
            } else if (!PbNormalLikeButtonSwitchStatic.GV() || (this.fdf.rv().hadConcerned() && this.fdf.rv().getGodUserData() != null && this.fdf.rv().getGodUserData().getIsFromNetWork())) {
                this.fch.setVisibility(8);
                this.fck.setVisibility(8);
            } else {
                this.fck.setVisibility(8);
            }
            this.fdU = null;
            this.fbN.setListViewDragListener(null);
        }
    }

    private void aWs() {
        String threadId = this.eYk != null ? this.eYk.getThreadId() : "";
        if (this.fdK) {
            if (this.fcj == null) {
                this.fcj = new ap(this.eVp.getPageContext(), this.fbJ.fgI, 3);
                this.fcj.h(this.eVp.getUniqueId());
            }
            if (this.fdf != null && this.fdf.rv() != null) {
                this.fdf.rv().setIsLike(this.fdf.rv().hadConcerned());
                this.fcj.a(this.fdf.rv());
            }
            this.fcj.cD(threadId);
            this.fcj.fbz = this.fdJ;
        }
        if (this.fci == null) {
            this.fci = new ap(this.eVp.getPageContext(), this.fch, 1);
            this.fci.h(this.eVp.getUniqueId());
            this.fci.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aO(boolean z) {
                    if (ar.this.eVp != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.eVp, d.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.eVp.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fdf != null && this.fdf.rv() != null) {
            this.fdf.rv().setIsLike(this.fdf.rv().hadConcerned());
            this.fci.a(this.fdf.rv());
            this.fci.cD(threadId);
        }
        this.fci.fbz = this.fdJ;
    }

    private boolean aWt() {
        boolean z;
        if (this.fcV != null && this.fcV.getVisibility() == 0) {
            if (this.fcs != null) {
                this.fcs.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fcs != null) {
                this.fcs.setVisibility(8);
            }
            z = false;
        }
        if ((this.fcu == null || this.fcu.getVisibility() == 8) && z && this.eQQ) {
            this.fct.setVisibility(0);
        } else {
            this.fct.setVisibility(8);
        }
        return z;
    }

    private boolean s(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aRp() == null) {
            return false;
        }
        if (fVar.aRp().rs() == 1 || fVar.aRp().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aRp().ru() == null || fVar.aRp().ru().sV() == 0) || fVar.aRp().rq() == 1 || fVar.aRp().rr() == 1 || fVar.aRp().sa() || fVar.aRp().so() || fVar.aRp().sh() || fVar.aRp().rI() != null || fVar.aRp().sp() || fVar.aRp().sp() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aRp().getCategory()) || fVar.aRp().rz() || fVar.aRp().ry();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return com.baidu.tieba.card.k.a((Context) this.eVp.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.fbP != null) {
                if (fVar.aRp() != null && fVar.aRp().rL() == 0 && !fVar.aRp().si() && !this.fdX) {
                    this.fbP.setVisibility(0);
                    if (fVar.aRp() != null) {
                        fVar.aRp().e(true, s(fVar));
                    }
                    SpannableStringBuilder rV = fVar.aRp().rV();
                    this.fbQ.setOnTouchListener(new com.baidu.tieba.view.l(rV));
                    if (this.fdV) {
                        this.fbQ.setText(fVar.aRp().getTitle());
                    } else {
                        this.fbQ.setText(rV);
                    }
                    this.fbQ.setVisibility(0);
                } else if (fVar.aRp().rL() == 1) {
                    if (fVar.aRp() != null) {
                        fVar.aRp().e(true, s(fVar));
                        SpannableStringBuilder rV2 = fVar.aRp().rV();
                        if (rV2 == null || rV2.length() == 0) {
                            this.fbP.setVisibility(8);
                            this.fbN.removeHeaderView(this.fbP);
                            if (fVar.aRp() != null && !fVar.aRp().si()) {
                                this.fbT.setPadding(this.fbT.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds48), this.fbT.getPaddingRight(), this.fbT.getPaddingBottom());
                            }
                        } else {
                            this.fbP.setVisibility(0);
                            this.fbQ.setOnTouchListener(new com.baidu.tieba.view.l(rV2));
                            this.fbQ.setText(rV2);
                            this.fbQ.setVisibility(0);
                        }
                    }
                } else {
                    this.fbP.setVisibility(8);
                    this.fbN.removeHeaderView(this.fbP);
                    if (fVar.aRp() != null && fVar.aRp().si()) {
                        this.fbT.setPadding(this.fbT.getPaddingLeft(), 0, this.fbT.getPaddingRight(), this.fbT.getPaddingBottom());
                    } else {
                        this.fbT.setPadding(this.fbT.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds48), this.fbT.getPaddingRight(), this.fbT.getPaddingBottom());
                    }
                }
            }
            this.eQQ = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aWt();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        if (fVar == null || (b = b(fVar, z)) == null) {
            return null;
        }
        String userId = b.rv().getUserId();
        boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 0) {
            sparseArray.put(d.g.tag_del_post_id, b.getId());
            sparseArray.put(d.g.tag_del_post_type, 0);
            sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aRA()));
            sparseArray.put(d.g.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.rv() != null) {
                sparseArray.put(d.g.tag_forbid_user_name, b.rv().getUserName());
                sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.g.tag_del_post_id, b.getId());
            sparseArray.put(d.g.tag_del_post_type, 0);
            sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aRA()));
            sparseArray.put(d.g.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aJf;
    }

    public void pT(String str) {
        if (this.cMd != null) {
            this.cMd.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fbN;
    }

    public int aWu() {
        return d.g.richText;
    }

    public TextView aSK() {
        return this.fbS.aSK();
    }

    public void d(BdListView.e eVar) {
        this.fbN.setOnSrollToBottomListener(eVar);
    }

    public void a(h.b bVar) {
        this.amR = bVar;
        if (this.fcA != null) {
            this.fcA.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int qs = alVar.qs();
            int qp = alVar.qp();
            if (this.fcx != null) {
                this.fcx.th();
            } else {
                this.fcx = new com.baidu.tbadk.core.dialog.a(this.eVp.getPageContext().getPageActivity());
                this.fcy = LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fcx.v(this.fcy);
                this.fcx.a(d.j.dialog_ok, bVar);
                this.fcx.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.aWw();
                        aVar.dismiss();
                    }
                });
                this.fcx.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fdE == null) {
                            ar.this.fdE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.eVp.HidenSoftKeyPad((InputMethodManager) ar.this.eVp.getSystemService("input_method"), ar.this.cth);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(ar.this.fdE, 150L);
                    }
                });
                this.fcx.b(this.eVp.getPageContext()).th();
            }
            this.fcz = (EditText) this.fcy.findViewById(d.g.input_page_number);
            this.fcz.setText("");
            TextView textView = (TextView) this.fcy.findViewById(d.g.current_page_number);
            if (qs <= 0) {
                qs = 1;
            }
            if (qp <= 0) {
                qp = 1;
            }
            textView.setText(MessageFormat.format(this.eVp.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(qs), Integer.valueOf(qp)));
            this.eVp.ShowSoftKeyPadDelay(this.fcz, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fbN.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eVp.showToast(str);
    }

    public boolean jT(boolean z) {
        if (this.IR == null || !this.IR.Dh()) {
            return false;
        }
        this.IR.Bn();
        return true;
    }

    public void aWv() {
        if (this.fel != null) {
            while (this.fel.size() > 0) {
                TbImageView remove = this.fel.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aWv();
        this.fcw.pW(1);
        if (this.fbD != null) {
            this.fbD.onPause();
        }
    }

    public void onResume() {
        this.fcw.pW(2);
        if (this.fbD != null) {
            this.fbD.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fdG != null) {
            this.fdG.destroy();
        }
        if (this.fbG != null) {
            this.fbG.adI();
        }
        if (this.fbF != null) {
            this.fbF.onDestroy();
        }
        this.eVp.hideProgressBar();
        if (this.ctf != null && this.cFw != null) {
            this.ctf.b(this.cFw);
        }
        aWw();
        ww();
        if (this.fdE != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fdE);
        }
        if (this.fbT != null && this.fcg != null) {
            this.fbT.removeView(this.fbZ);
            this.fcg = null;
        }
        if (this.fdk != null) {
            this.fdk.clearStatus();
        }
        this.fee = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fcw.pW(3);
        if (this.cIW != null) {
            this.cIW.setBackgroundDrawable(null);
        }
        if (this.fbD != null) {
            this.fbD.destroy();
        }
        if (this.fcw != null) {
            this.fcw.onDestory();
        }
        this.fbN.setOnLayoutListener(null);
        if (this.fdS != null) {
            this.fdS.anc();
        }
        if (this.fdv != null) {
            this.fdv.onDestroy();
        }
        aWS();
    }

    public boolean qn(int i) {
        if (this.fbD != null) {
            return this.fbD.ka(i);
        }
        return false;
    }

    public void aWw() {
        this.fbJ.or();
        if (this.fbG != null) {
            this.fbG.adI();
        }
        com.baidu.adp.lib.util.l.a(this.eVp.getPageContext().getPageActivity(), this.fcz);
        aVK();
        if (this.fcP != null) {
            this.fcP.dismiss();
        }
        aWy();
        if (this.fbF != null) {
            this.fbF.aYs();
        }
        if (this.fcx != null) {
            this.fcx.dismiss();
        }
        if (this.cII != null) {
            this.cII.dismiss();
        }
    }

    public void aWx() {
        this.fbJ.or();
        if (this.fbG != null) {
            this.fbG.adI();
        }
        if (this.fcP != null) {
            this.fcP.dismiss();
        }
        aWy();
        if (this.fbF != null) {
            this.fbF.aYs();
        }
        if (this.fcx != null) {
            this.fcx.dismiss();
        }
        if (this.cII != null) {
            this.cII.dismiss();
        }
    }

    public void cL(List<String> list) {
        this.fdR = list;
        if (this.fdS != null) {
            this.fdS.setData(list);
        }
    }

    public void iY(boolean z) {
        this.fcw.iY(z);
    }

    public void jU(boolean z) {
        this.fcU = z;
    }

    public void aWy() {
        if (this.fcG != null) {
            this.fcG.dismiss();
        }
        if (this.fcH != null) {
            com.baidu.adp.lib.g.g.b(this.fcH, this.eVp.getPageContext());
        }
        if (this.fcI != null) {
            com.baidu.adp.lib.g.g.b(this.fcI, this.eVp.getPageContext());
        }
        if (this.fcE != null) {
            com.baidu.adp.lib.g.g.b(this.fcE, this.eVp.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eYk, this.eQQ);
            d(this.eYk, this.eQQ, this.mType);
            this.eVp.getLayoutMode().ag(i == 1);
            this.eVp.getLayoutMode().t(this.cth);
            this.eVp.getLayoutMode().t(this.fbQ);
            this.eVp.getLayoutMode().t(this.fbR);
            this.eVp.getLayoutMode().t(this.fbO);
            if (this.fce != null) {
                com.baidu.tbadk.core.util.aj.c(this.fce, d.C0096d.cp_cont_d, 1);
            }
            if (this.fcd != null) {
                com.baidu.tbadk.core.util.aj.c(this.fcd, d.C0096d.cp_cont_d, 1);
            }
            if (this.fbF != null) {
                this.fbF.onChangeSkinType(i);
            }
            this.eVp.getLayoutMode().t(this.fbO);
            com.baidu.tbadk.core.util.aj.i(this.fbQ, d.C0096d.cp_cont_b);
            this.fbQ.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_link_tip_c));
            this.eVp.getLayoutMode().t(this.aJf);
            if (this.fcx != null) {
                this.fcx.c(this.eVp.getPageContext());
            }
            jS(this.fcR);
            this.fcw.notifyDataSetChanged();
            if (this.fcA != null) {
                this.fcA.dz(i);
            }
            if (this.cMd != null) {
                this.cMd.dz(i);
                com.baidu.tbadk.core.util.aj.j(this.aJf, d.f.pb_foot_more_trans_selector);
                this.cMd.dw(d.f.pb_foot_more_trans_selector);
            }
            if (this.IR != null) {
                this.IR.onChangeSkinType(i);
            }
            if (this.fcf != null) {
                this.fcf.dE(i);
            }
            if (this.fcB != null) {
                this.fcB.dz(i);
            }
            if (this.ccX != null && this.ccX.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.ccX) {
                    aVar.we();
                }
            }
            jO(i == 1);
            aVY();
            UtilHelper.setStatusBarBackground(this.cIW, i);
            UtilHelper.setStatusBarBackground(this.fdp, i);
            if (this.fch != null) {
                this.fch.onChangeSkinType(i);
            }
            if (this.fcm != null) {
                com.baidu.tbadk.core.util.aj.i(this.fcm, d.C0096d.cp_cont_d);
            }
            if (this.fcl != null) {
                com.baidu.tbadk.core.util.aj.i(this.fcl, d.C0096d.cp_cont_d);
            }
            if (this.fcn != null) {
                com.baidu.tbadk.core.util.aj.j(this.fcn, d.C0096d.cp_cont_e);
            }
            if (this.cvb != null) {
                com.baidu.tbadk.core.util.aj.i(this.cvb, d.C0096d.cp_cont_d);
            }
            if (this.fco != null) {
                com.baidu.tbadk.core.util.aj.j(this.fco, d.C0096d.cp_cont_e);
            }
            if (this.fbW != null) {
                com.baidu.tbadk.core.util.aj.i(this.fbW, d.C0096d.cp_link_tip_a);
            }
            if (this.fck != null) {
                com.baidu.tbadk.core.util.aj.i(this.fck, d.C0096d.cp_cont_d);
            }
            if (this.fcp != null) {
                com.baidu.tbadk.n.a.a(this.eVp.getPageContext(), this.fcp);
            }
            if (this.fcN != null) {
                com.baidu.tbadk.n.a.a(this.eVp.getPageContext(), this.fcN);
            }
            if (this.fdF != null) {
                this.fdF.onChangeSkinType(i);
            }
            if (this.fbJ != null) {
                if (this.fbD != null) {
                    this.fbD.qt(i);
                } else {
                    this.fbJ.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fcX != null) {
                com.baidu.tbadk.core.util.aj.i(this.fcX, d.C0096d.cp_cont_e);
            }
            if (this.fbX != null) {
                com.baidu.tbadk.core.util.aj.c(this.fbX, BitmapHelper.getGradeResourceIdInEnterForum(this.fdN));
            }
            this.fdT.onChangeSkinType(i);
            if (this.fdv != null) {
                this.fdv.onChangeSkinType();
            }
            if (this.fdQ != null) {
                com.baidu.tbadk.core.util.aj.i(this.fdQ, d.C0096d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVG = gVar;
        this.fcw.setOnImageClickListener(this.aVG);
        this.fdT.setOnImageClickListener(this.aVG);
    }

    public void h(NoNetworkView.a aVar) {
        this.cFw = aVar;
        if (this.ctf != null) {
            this.ctf.a(this.cFw);
        }
    }

    public void jV(boolean z) {
        this.fcw.setIsFromCDN(z);
    }

    public Button aWz() {
        return this.fcV;
    }

    public void aWA() {
        if (this.fbI != 2) {
            this.fbN.setNextPage(this.cMd);
            this.fbI = 2;
        }
    }

    public void aWB() {
        if (com.baidu.tbadk.k.r.GB().GC()) {
            int lastVisiblePosition = this.fbN.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fbN.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog = tbImageView.getPerfLog();
                                perfLog.fr(1001);
                                perfLog.aKn = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.k.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.fr(1001);
                        perfLog2.aKn = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean aWC() {
        return this.IR != null && this.IR.getVisibility() == 0;
    }

    public void jW(boolean z) {
        if (this.fcW != null) {
            jU(this.eVp.aSL().DI());
            if (this.fcU) {
                jL(z);
            } else {
                jM(z);
            }
        }
    }

    public void aWD() {
        if (this.fcW != null) {
            this.fcW.setVisibility(8);
            this.fdb = false;
            if (this.fdv != null) {
                this.fdv.setVisibility(8);
                jQ(false);
            }
            aWS();
        }
    }

    public void showLoadingDialog() {
        if (this.ckj == null) {
            this.ckj = new com.baidu.tbadk.core.view.b(this.eVp.getPageContext());
        }
        this.ckj.aE(true);
    }

    public void XC() {
        if (this.ckj != null) {
            this.ckj.aE(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fbN.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fbN.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fbD != null) {
            this.fbD.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.etZ = getScrollY();
            this.fdu.feB = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fdu));
            a(this.fdu.feB, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fbD != null) {
            this.fbD.b(absListView, i);
        }
        int headerViewsCount = (i - this.fbN.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fcw.pV(headerViewsCount) == com.baidu.tieba.pb.data.l.eQc) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fbN.getHeaderViewsCount();
        if (this.fbR != null && this.fbJ != null) {
            this.fbJ.f(this.fbR.getBottom(), this.fbR.getMeasuredHeight(), z2);
        }
        this.fcw.aTW().j(z, this.fdn != null ? this.fdn.getMeasuredHeight() : 0);
        this.fdu.eKV = i;
        this.fdu.feA = this.fbN.getHeaderViewsCount();
        this.fdu.feB = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fdu));
        a(this.fdu.feB, false);
    }

    public void aWE() {
        if (this.eVp.isLogin() && this.eYk != null && this.fdK && !this.fdJ && !this.fcS && this.fdf != null && this.fdf.rv() != null && !this.fdf.rv().getIsLike() && !this.fdf.rv().hadConcerned()) {
            if (this.fdG == null) {
                this.fdG = new am(this.eVp);
            }
            this.fdG.a(this.fbJ.fgH, this.eYk.aRN(), this.fdf.rv().getUserId(), this.eYk.getThreadId());
        }
    }

    public void aWF() {
        if (this.fdK && !this.fdJ && this.fdf != null && this.fdf.rv() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").r("obj_locate", this.eVp.aTC() ? 2 : 1).r("obj_type", this.fdJ ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eVp.getPageContext().getPageActivity(), this.fdf.rv().getUserId(), this.fdf.rv().getUserName(), this.eVp.aSw().aUl(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fdJ && this.fdo != null && this.fbJ.aXi() != null) {
            int aTT = this.fcw.aTT();
            if (aTT > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (aTT > this.fbN.getFirstVisiblePosition() - this.fbN.getHeaderViewsCount()) {
                    this.fdo.setVisibility(8);
                    return;
                }
                this.fdo.setVisibility(0);
                this.fbJ.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fba == null) {
                if (this.fbN.getFirstVisiblePosition() == 0) {
                    this.fdo.setVisibility(8);
                    this.fbJ.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fdt) {
                        this.fds = top;
                        this.fdt = false;
                    }
                    this.fds = top < this.fds ? top : this.fds;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.fcv.getY() < 0.0f) {
                        measuredHeight = fdr - akVar.fba.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fbJ.aXi().getMeasuredHeight() - akVar.fba.getMeasuredHeight();
                        this.fbJ.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fds) {
                        this.fdo.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fdo.setVisibility(0);
                    } else {
                        this.fdo.setVisibility(8);
                        this.fbJ.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fdt = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eKV;
        public int feA;
        public ak feB;

        public a() {
        }
    }

    public void aWG() {
        if (!this.fem) {
            TiebaStatic.log("c10490");
            this.fem = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVp.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fdy, Integer.valueOf(fdA));
            aVar.cc(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.j.grade_button_tips, this.eVp);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eVp.getPageContext()).th();
        }
    }

    public void pU(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVp.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fdy, Integer.valueOf(fdB));
        aVar.z(sparseArray);
        aVar.a(d.j.view, this.eVp);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eVp.getPageContext()).th();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.rv() != null) {
            MetaData rv = b.rv();
            rv.setGiftNum(rv.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
        r(fVar);
    }

    public PbInterviewStatusView aWH() {
        return this.fdk;
    }

    private void t(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRp() != null && fVar.aRp().so() && this.fdk == null) {
            this.fdk = (PbInterviewStatusView) this.fdj.inflate();
            this.fdk.setOnClickListener(this.cIJ);
            this.fdk.setCallback(this.eVp.aTx());
            this.fdk.c(this.eVp, fVar);
        }
    }

    public LinearLayout aWI() {
        return this.fcv;
    }

    public View aWJ() {
        return this.cIW;
    }

    public boolean aWK() {
        return this.fdX;
    }

    public void jd(boolean z) {
        this.fbS.jd(z);
    }

    private void aWL() {
        if (this.fdX) {
            if (this.fdY == null) {
                e.a aVar = e.eSK.get();
                if (aVar != null) {
                    this.fdY = aVar.a(this.eVp);
                    ListAdapter adapter = this.fbN.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.axY) {
                            this.fbN.addHeaderView(this.fdY.aSI(), 1);
                        } else {
                            this.fbN.addHeaderView(this.fdY.aSI(), 0);
                        }
                    }
                } else {
                    this.fbR.setVisibility(0);
                    return;
                }
            }
            this.fbR.setVisibility(8);
            this.fbN.removeHeaderView(this.fbR);
            return;
        }
        this.fbR.setVisibility(0);
    }

    public void jX(boolean z) {
        this.fdX = z;
    }

    public void aWM() {
        this.eVp.showNetRefreshView(getView(), "");
        View EU = this.eVp.getRefreshView().EU();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EU.getLayoutParams();
        layoutParams.addRule(3, aWI().getId());
        EU.setLayoutParams(layoutParams);
        this.eVp.hideLoadingView(getView());
        if (this.fdY != null) {
            this.fbN.removeHeaderView(this.fdY.aSI());
            this.fdY = null;
        }
    }

    public void pV(String str) {
        if (this.fbK != null) {
            this.fbK.setTitle(str);
        }
    }

    private int jY(boolean z) {
        if (this.fdk == null || this.fdk.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void aWN() {
        if (this.fdk != null && this.fdk.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fdk.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fdk.setLayoutParams(layoutParams);
        }
    }

    public boolean aSR() {
        return false;
    }

    public TextView aWO() {
        return this.fce;
    }

    public void pW(String str) {
        this.fcX.performClick();
        if (!StringUtils.isNull(str) && this.eVp.aSL() != null && this.eVp.aSL().DC() != null && this.eVp.aSL().DC().getInputView() != null) {
            EditText inputView = this.eVp.aSL().DC().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aWw();
            if (configuration.orientation == 2) {
                aWD();
                aVK();
            } else {
                aVN();
            }
            if (this.fdF != null) {
                this.fdF.aUa();
            }
            this.eVp.alC();
            this.fcv.setVisibility(8);
            this.fbJ.setTitleVisibility(false);
            this.eVp.jj(false);
            if (this.fbD != null) {
                if (configuration.orientation == 1) {
                    aWI().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fbN.setIsLandscape(true);
                    this.fbN.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fbN.setIsLandscape(false);
                    if (this.etZ > 0) {
                        this.fbN.smoothScrollBy(this.etZ, 0);
                    }
                }
                this.fbD.onConfigurationChanged(configuration);
            }
        }
    }

    public void jZ(boolean z) {
        this.fbH = z;
    }

    public boolean aWP() {
        return this.fbD != null && this.fbD.aWP();
    }

    public void aWQ() {
        if (this.fbD != null) {
            this.fbD.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fbF != null) {
            this.fbF.y(j, i);
        }
        if (this.fbD != null) {
            this.fbD.y(j, i);
        }
    }

    public void jo(boolean z) {
        this.fcw.jo(z);
    }

    public void aWR() {
        if (this.fdl == null) {
            LayoutInflater.from(this.eVp.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.cth, true);
            this.fdl = (ViewGroup) this.cth.findViewById(d.g.add_experienced_layout);
            this.fdm = (TextView) this.cth.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.fdm, d.C0096d.cp_cont_i);
            String string = this.eVp.getResources().getString(d.j.experienced_add_success);
            String string2 = this.eVp.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0096d.cp_cont_h)));
            this.fdm.setText(spannableString);
        }
        this.fdl.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.ar.28
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.ar.28.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        ar.this.fdl.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fdm.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fdm.startAnimation(scaleAnimation);
    }

    public void bn(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fcW.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.eVp);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fdQ = new TextView(this.eVp);
            this.fdQ.setText(d.j.connection_tips);
            this.fdQ.setGravity(17);
            this.fdQ.setPadding(com.baidu.adp.lib.util.l.f(this.eVp, d.e.ds24), 0, com.baidu.adp.lib.util.l.f(this.eVp, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eVp, d.e.ds60);
            frameLayout.addView(this.fdQ, layoutParams);
            this.fdP = new PopupWindow(this.eVp);
            this.fdP.setContentView(frameLayout);
            this.fdP.setHeight(-2);
            this.fdP.setWidth(-2);
            this.fdP.setFocusable(true);
            this.fdP.setOutsideTouchable(false);
            this.fdP.setBackgroundDrawable(new ColorDrawable(this.eVp.getResources().getColor(d.C0096d.transparent)));
            this.fbN.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fdP.showAsDropDown(ar.this.fcW, view.getLeft(), -ar.this.fcW.getHeight());
                    } else {
                        ar.this.fdP.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.aXb() != null && !StringUtils.isNull(aVar.aXb().pkg_id) && !StringUtils.isNull(aVar.aXb().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fcY != null && this.fcY.getVisibility() == 0) {
            if (this.fdO == null) {
                View inflate = LayoutInflater.from(this.eVp.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.cIJ);
                this.fdO = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fcY.getLocationInWindow(iArr);
            this.fdO.showAtLocation(this.fcY, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fcY.getHeight()) - com.baidu.adp.lib.util.l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void aWS() {
        com.baidu.adp.lib.g.g.a(this.fdO);
    }

    public void setIsInterviewLive(boolean z) {
        this.fdV = z;
    }

    public boolean getIsInterviewLive() {
        return this.fdV;
    }

    public void bo(View view) {
        this.fcN = view;
    }
}
