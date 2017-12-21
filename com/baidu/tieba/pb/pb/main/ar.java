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
    private com.baidu.tbadk.editortools.i IS;
    private View aJi;
    private com.baidu.tieba.pb.a.c aVK;
    private h.b amU;
    private TextView ayb;
    private View.OnClickListener cIN;
    private View cJa;
    private PbListView cMh;
    private List<com.baidu.tieba.pb.pb.main.view.a> cdb;
    private View chl;
    private NoNetworkView ctj;
    private RelativeLayout ctl;
    private TextView cvf;
    private View.OnClickListener eQZ;
    PbActivity.d eUz;
    private PbActivity eVu;
    private UserIconBox eWy;
    private UserIconBox eWz;
    private PbFakeFloorModel eXm;
    private com.baidu.tieba.pb.data.f eYp;
    private int eud;
    public int fbH;
    private com.baidu.tieba.pb.video.i fbI;
    private long fbJ;
    private com.baidu.tieba.pb.video.h fbK;
    private com.baidu.tieba.d.b fbL;
    public final com.baidu.tieba.pb.pb.main.view.c fbO;
    public com.baidu.tieba.pb.pb.main.view.b fbP;
    private ViewStub fbQ;
    private ViewStub fbR;
    private PbLandscapeListView fbS;
    private View fbT;
    private LinearLayout fbW;
    private f fbX;
    private ColumnLayout fbY;
    private ThreadSkinView fbZ;
    private ObservedChangeLinearLayout fcA;
    private h fcB;
    private View fcH;
    private TextView fca;
    private TextView fcb;
    private ImageView fcc;
    private HeadPendantView fcd;
    private FrameLayout fce;
    private HeadImageView fcf;
    private View fcg;
    private FloatingLayout fch;
    private PbFirstFloorUserLikeButton fcm;
    private ap fcn;
    private ap fco;
    private TextView fcp;
    private TextView fcq;
    private TextView fcr;
    private View fcs;
    private View fct;
    private LinearLayout fcu;
    private TextView fcv;
    private TextView fcw;
    private View fcx;
    private View fcy;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fdA;
    private int fdI;
    private Runnable fdJ;
    private s fdK;
    private am fdL;
    private int fdR;
    private PopupWindow fdT;
    private PopupWindow fdU;
    private TextView fdV;
    private List<String> fdW;
    private com.baidu.tieba.pb.pb.main.emotion.c fdX;
    private com.baidu.tieba.pb.pb.godreply.a fdY;
    private PbLandscapeListView.b fdZ;
    private View fdb;
    private TextView fdc;
    private ImageView fdd;
    private ImageView fde;
    private TextView fdf;
    private boolean fdh;
    private int fdi;
    private int fdj;
    private PostData fdk;
    private View fdm;
    private TextView fdn;
    private ViewStub fdo;
    private PbInterviewStatusView fdp;
    private ViewGroup fdq;
    private TextView fdr;
    private FrameLayout fds;
    private View fdt;
    private View fdu;
    private ak fdv;
    private boolean fec;
    private e fed;
    private com.baidu.tbadk.core.view.userLike.c fee;
    private com.baidu.tbadk.core.view.userLike.c fef;
    private Runnable fek;
    private PbActivity.b fem;
    private boolean isLandscape;
    private int mType;
    private static final int fdw = UtilHelper.getLightStatusBarHeight();
    public static int fdC = 3;
    public static int fdD = 0;
    public static int fdE = 3;
    public static int fdF = 4;
    public static int fdG = 5;
    public static int fdH = 6;
    private boolean fbM = false;
    private int fbN = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fbU = null;
    private TextView fbV = null;
    private TextView fci = null;
    private TextView fcj = null;
    public FrsPraiseView fck = null;
    private ClickableHeaderImageView fcl = null;
    private View fcz = null;
    private com.baidu.tbadk.core.dialog.a fcC = null;
    private com.baidu.tbadk.core.dialog.b cIM = null;
    private View fcD = null;
    private EditText fcE = null;
    private com.baidu.tieba.pb.view.i fcF = null;
    private com.baidu.tieba.pb.view.b fcG = null;
    private com.baidu.tbadk.core.dialog.a fcI = null;
    private b.InterfaceC0060b dOB = null;
    private TbRichTextView.g aVJ = null;
    private NoNetworkView.a cFA = null;
    private Dialog fcJ = null;
    private View fcK = null;
    private com.baidu.tbadk.core.dialog.a fcL = null;
    private Dialog fcM = null;
    private Dialog fcN = null;
    private View fcO = null;
    private LinearLayout fcP = null;
    private CompoundButton.OnCheckedChangeListener cdc = null;
    private TextView fcQ = null;
    private TextView fcR = null;
    private View fcS = null;
    private String fcT = null;
    private com.baidu.tbadk.core.dialog.b fcU = null;
    private com.baidu.tbadk.core.dialog.b fcV = null;
    private boolean fcW = false;
    private boolean fcX = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fcY = null;
    private boolean fcZ = false;
    private Button fda = null;
    private boolean fdg = true;
    private com.baidu.tbadk.core.view.b ckn = null;
    private boolean eQV = false;
    private int mSkinType = 3;
    private boolean fdl = false;
    private int fdx = 0;
    private boolean fdy = true;
    private a fdz = new a();
    private int fdB = 0;
    private boolean fdM = false;
    private int fdN = 0;
    private boolean fdO = false;
    private boolean fdP = false;
    private boolean fdQ = false;
    private int fdS = 0;
    private boolean fea = false;
    private a.InterfaceC0140a feb = new a.InterfaceC0140a() { // from class: com.baidu.tieba.pb.pb.main.ar.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0140a
        public void kW() {
        }
    };
    private String feg = null;
    private CustomMessageListener feh = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ar.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ar.this.feg = null;
            }
        }
    };
    private CustomMessageListener cXk = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ar.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ar.this.fcB != null) {
                ar.this.fcB.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fei = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.ar.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ar.this.fbV != null) {
                ar.this.fbV.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fej = new Handler();
    private CustomMessageListener fel = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ar.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ar.this.fdg = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fen = true;
    View.OnClickListener feo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ar.this.fdO) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").r("obj_id", 2));
            }
            if (view == ar.this.fbO.fgO) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").r("obj_locate", 2));
            }
            if (ar.this.eVu.eTz.ffX != null) {
                if (!ar.this.fdO && ar.this.eYp != null && ar.this.eYp.aRq() != null && ar.this.eYp.aRq().rv() != null && ar.this.eYp.aRq().rv().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").r("obj_locate", 1));
                }
                ar.this.eVu.eTz.ffX.onClick(view);
            }
        }
    };
    private boolean fep = false;
    String userId = null;
    private final List<TbImageView> feq = new ArrayList();
    private boolean fer = false;

    public void jK(boolean z) {
        this.fdM = z;
        if (this.fbS != null) {
            this.fdN = this.fbS.getHeaderViewsCount();
        }
    }

    public void aVI() {
        if (this.fbS != null) {
            int headerViewsCount = this.fbS.getHeaderViewsCount() - this.fdN;
            final int firstVisiblePosition = (this.fbS.getFirstVisiblePosition() == 0 || this.fbS.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fbS.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fbS.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fdz.feG = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fdz));
            final ak akVar = this.fdz.feG;
            final int f = f(akVar);
            final int y = ((int) this.fcA.getY()) + this.fcA.getMeasuredHeight();
            final boolean z = this.fdt.getVisibility() == 0;
            boolean z2 = this.fcA.getY() < 0.0f;
            if ((z && akVar != null) || firstVisiblePosition >= this.fcB.aTU() + this.fbS.getHeaderViewsCount()) {
                int measuredHeight = akVar != null ? akVar.fbf.getMeasuredHeight() : 0;
                if (z2) {
                    this.fbS.setSelectionFromTop(this.fcB.aTU() + this.fbS.getHeaderViewsCount(), fdw - measuredHeight);
                } else {
                    this.fbS.setSelectionFromTop(this.fcB.aTU() + this.fbS.getHeaderViewsCount(), this.fbO.aXj().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fbS.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fdO) {
                this.fbS.setSelectionFromTop(this.fcB.aTU() + this.fbS.getHeaderViewsCount(), this.fbI.aYA().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fbS.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ar.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void aUj() {
                        if (f >= 0 && f <= ar.this.ctl.getMeasuredHeight()) {
                            int f2 = ar.this.f(akVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = ar.this.chl.getLayoutParams();
                            if (i == 0 || i > ar.this.ctl.getMeasuredHeight() || f2 >= ar.this.ctl.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fdI;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ar.this.ctl.getMeasuredHeight()) {
                                layoutParams.height = ar.this.fdI;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                ar.this.fbS.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            ar.this.chl.setLayoutParams(layoutParams);
                        }
                        ar.this.fbS.setOnLayoutListener(null);
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

    public e aVJ() {
        return this.fed;
    }

    public NoNetworkView aVK() {
        return this.ctj;
    }

    public void aVL() {
        if (this.IS != null) {
            this.IS.hide();
            if (this.fdX != null) {
                this.fdX.Od();
            }
        }
    }

    public PbFakeFloorModel aVM() {
        return this.eXm;
    }

    public s aVN() {
        return this.fdK;
    }

    public void aVO() {
        reset();
        aVL();
        this.fdK.aUb();
        jW(false);
    }

    private void reset() {
        if (this.eVu != null && this.eVu.aSM() != null && this.IS != null) {
            com.baidu.tbadk.editortools.pb.a.Dz().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aSM = this.eVu.aSM();
            aSM.DS();
            aSM.Do();
            if (aSM.getWriteImagesInfo() != null) {
                aSM.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aSM.eV(SendView.ALL);
            aSM.eW(SendView.ALL);
            com.baidu.tbadk.editortools.l eN = this.IS.eN(23);
            com.baidu.tbadk.editortools.l eN2 = this.IS.eN(2);
            com.baidu.tbadk.editortools.l eN3 = this.IS.eN(5);
            if (eN2 != null) {
                eN2.lE();
            }
            if (eN3 != null) {
                eN3.lE();
            }
            if (eN != null) {
                eN.hide();
            }
            this.IS.invalidate();
        }
    }

    public boolean aVP() {
        return this.fdg;
    }

    public void jL(boolean z) {
        if (this.fdb != null && this.fdc != null) {
            this.fdc.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fdb.startAnimation(alphaAnimation);
            }
            this.fdb.setVisibility(0);
            this.fdg = true;
            if (this.fdA != null && !this.fdY.isActive()) {
                this.fdA.setVisibility(0);
                jQ(true);
            }
        }
    }

    public void jM(boolean z) {
        if (this.fdb != null && this.fdc != null) {
            this.fdc.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fdb.startAnimation(alphaAnimation);
            }
            this.fdb.setVisibility(0);
            this.fdg = true;
            if (this.fdA != null && !this.fdY.isActive()) {
                this.fdA.setVisibility(0);
                jQ(true);
            }
        }
    }

    public PostData aVQ() {
        int i = 0;
        if (this.fbS == null) {
            return null;
        }
        int aVR = aVR() - this.fbS.getHeaderViewsCount();
        if (aVR < 0) {
            aVR = 0;
        }
        if (this.fcB.pV(aVR) != null && this.fcB.pV(aVR) != PostData.gBS) {
            i = aVR + 1;
        }
        return this.fcB.getItem(i) instanceof PostData ? (PostData) this.fcB.getItem(i) : null;
    }

    public int aVR() {
        int i;
        View childAt;
        if (this.fbS == null) {
            return 0;
        }
        int firstVisiblePosition = this.fbS.getFirstVisiblePosition();
        int lastVisiblePosition = this.fbS.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fbS.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fbS.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int aVS() {
        return this.fbS.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.eYp != null && this.eYp.aRs() != null && !this.eYp.aRs().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.eYp.aRs().size() && (postData = this.eYp.aRs().get(i)) != null && postData.rv() != null && !StringUtils.isNull(postData.rv().getUserId()); i++) {
                if (this.eYp.aRs().get(i).rv().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fdY != null && this.fdY.isActive()) {
                        jW(false);
                    }
                    if (this.fdA != null) {
                        this.fdA.kd(true);
                    }
                    this.feg = postData.rv().getName_show();
                    return;
                }
            }
        }
    }

    public ar(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.eVu = null;
        this.ctl = null;
        this.cJa = null;
        this.fbJ = 0L;
        this.fbS = null;
        this.fbT = null;
        this.fbW = null;
        this.fbY = null;
        this.fca = null;
        this.fcb = null;
        this.fce = null;
        this.fcf = null;
        this.fcg = null;
        this.fcm = null;
        this.fcp = null;
        this.fcq = null;
        this.fcr = null;
        this.fcs = null;
        this.fcx = null;
        this.fcy = null;
        this.fcB = null;
        this.cMh = null;
        this.aJi = null;
        this.cIN = null;
        this.eQZ = null;
        this.fdb = null;
        this.fdc = null;
        this.fdd = null;
        this.fde = null;
        this.fdf = null;
        this.fdm = null;
        this.fdn = null;
        this.fdo = null;
        this.fdR = 0;
        this.fbJ = System.currentTimeMillis();
        this.eVu = pbActivity;
        this.cIN = onClickListener;
        this.aVK = cVar;
        this.fdR = com.baidu.adp.lib.util.l.ac(this.eVu) / 2;
        this.ctl = (RelativeLayout) LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.eVu.addContentView(this.ctl, new FrameLayout.LayoutParams(-1, -1));
        this.cJa = this.eVu.findViewById(d.g.statebar_view);
        this.fcA = (ObservedChangeLinearLayout) this.eVu.findViewById(d.g.title_wrapper);
        this.ctj = (NoNetworkView) this.eVu.findViewById(d.g.view_no_network);
        this.fbS = (PbLandscapeListView) this.eVu.findViewById(d.g.new_pb_list);
        this.fds = (FrameLayout) this.eVu.findViewById(d.g.root_float_header);
        this.ayb = new TextView(this.eVu.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds88));
        this.fbS.addHeaderView(this.ayb, 0);
        this.fdI = this.eVu.getResources().getDimensionPixelSize(d.e.ds100);
        this.chl = new View(this.eVu.getPageContext().getPageActivity());
        this.chl.setLayoutParams(new AbsListView.LayoutParams(-1, this.fdI));
        this.chl.setVisibility(4);
        this.fbS.addFooterView(this.chl);
        this.fbS.setOnTouchListener(this.eVu.aNp);
        this.fbO = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.eVu.aTp()) {
            this.fbQ = (ViewStub) this.eVu.findViewById(d.g.manga_view_stub);
            this.fbQ.setVisibility(0);
            this.fbP = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.fbP.show();
            this.fbO.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds120);
        }
        this.ayb.setLayoutParams(layoutParams);
        this.fbO.aXj().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0125a() { // from class: com.baidu.tieba.pb.pb.main.ar.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0125a
            public void amq() {
                if (ar.this.fbS != null) {
                    if (ar.this.fbI != null) {
                        ar.this.fbI.aYB();
                    }
                    ar.this.fbS.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0125a
            public void amp() {
                ar.this.eVu.alC();
            }
        }));
        this.fdb = this.eVu.findViewById(d.g.pb_editor_tool_comment);
        this.fdi = com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds90);
        this.fdj = com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds242);
        this.fdc = (TextView) this.eVu.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fde = (ImageView) this.eVu.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fdd = (ImageView) this.eVu.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fdf = (TextView) this.eVu.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fdf.setVisibility(8);
        this.fdc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWT();
                if (!ar.this.eVu.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").r("obj_locate", 2).ac(ImageViewerConfig.FORUM_ID, ar.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d aSM = ar.this.eVu.aSM();
                if (aSM == null || (!aSM.DP() && !aSM.DQ())) {
                    if (ar.this.IS != null) {
                        ar.this.aWc();
                    }
                    if (ar.this.IS != null) {
                        ar.this.fdg = false;
                        if (ar.this.IS.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eVu, (View) ar.this.IS.eP(2).aBW, false, ar.this.feb);
                        }
                    }
                    ar.this.aWE();
                    return;
                }
                ar.this.eVu.aSM().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fdd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWT();
                if (ar.this.eVu.checkUpIsLogin()) {
                    if (ar.this.IS != null) {
                        ar.this.aWc();
                        ar.this.IS.M((View) ar.this.IS.eN(5));
                    }
                    if (ar.this.IS != null) {
                        ar.this.fdg = false;
                        if (ar.this.IS.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eVu, (View) ar.this.IS.eP(2).aBW, false, ar.this.feb);
                        }
                    }
                    ar.this.aWE();
                }
            }
        });
        this.fde.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ar.this.aWT();
                if (ar.this.eVu.checkUpIsLogin()) {
                    if (ar.this.IS != null) {
                        ar.this.aWc();
                        ar.this.IS.M((View) ar.this.IS.eN(2));
                    }
                    if (ar.this.IS != null) {
                        ar.this.fdg = false;
                        if (ar.this.IS.eP(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(ar.this.eVu, (View) ar.this.IS.eP(2).aBW, false, ar.this.feb);
                        }
                    }
                    ar.this.aWE();
                }
            }
        });
        this.fdf.setOnClickListener(this.cIN);
        this.fdf.setOnTouchListener(this.eVu);
        this.fbT = LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fbW = (LinearLayout) LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        this.fbX = new f(this.eVu, this.fbW);
        this.fbX.init();
        this.fbX.a(this.fbX.aSL(), this.cIN);
        this.fbY = (ColumnLayout) this.fbW.findViewById(d.g.pb_head_owner_root);
        this.fbZ = (ThreadSkinView) this.fbW.findViewById(d.g.pb_thread_skin);
        this.fbY.setOnLongClickListener(this.onLongClickListener);
        this.fbY.setOnTouchListener(this.aVK);
        this.fbY.setVisibility(8);
        this.fbT.setOnTouchListener(this.aVK);
        this.fdm = this.fbT.findViewById(d.g.pb_head_activity_join_number_container);
        this.fdm.setVisibility(8);
        this.fdn = (TextView) this.fbT.findViewById(d.g.pb_head_activity_join_number);
        this.fca = (TextView) this.fbY.findViewById(d.g.pb_head_owner_info_user_name);
        this.fcb = (TextView) this.fbY.findViewById(d.g.floor_owner);
        this.fcc = (ImageView) this.fbY.findViewById(d.g.icon_forum_level);
        this.fce = (FrameLayout) this.fbY.findViewById(d.g.pb_head_headImage_container);
        this.fcf = (HeadImageView) this.fbY.findViewById(d.g.pb_head_owner_photo);
        this.fcd = (HeadPendantView) this.fbY.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fcd.wi();
        if (this.fcd.getHeadView() != null) {
            this.fcd.getHeadView().setIsRound(true);
            this.fcd.getHeadView().setDrawBorder(false);
        }
        this.eWy = (UserIconBox) this.fbY.findViewById(d.g.show_icon_vip);
        this.eWz = (UserIconBox) this.fbY.findViewById(d.g.show_icon_yinji);
        this.fch = (FloatingLayout) this.fbW.findViewById(d.g.pb_head_owner_info_root);
        this.fcm = (PbFirstFloorUserLikeButton) this.fbY.findViewById(d.g.pb_like_button);
        this.fcp = (TextView) this.fbY.findViewById(d.g.pb_views);
        this.cvf = (TextView) this.fbY.findViewById(d.g.view_forum_name);
        this.fct = this.fbY.findViewById(d.g.line_right_forum_name);
        this.fcq = (TextView) this.fbY.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fcr = (TextView) this.fbY.findViewById(d.g.pb_item_first_floor_location_address);
        this.fcs = this.fbY.findViewById(d.g.line_between_time_and_locate);
        this.fee = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fef = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fcx = this.fbT.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fcy = this.fbT.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fbT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fdo = (ViewStub) this.ctl.findViewById(d.g.interview_status_stub);
        this.fcB = new h(this.eVu, this.fbS);
        this.fcB.q(this.cIN);
        this.fcB.setTbGestureDetector(this.aVK);
        this.fcB.setOnImageClickListener(this.aVJ);
        this.eQZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.abp() || !com.baidu.tieba.c.a.a(ar.this.eVu.getBaseContext(), ar.this.eVu.aSx().aUn(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                ar.this.eVu.c(sparseArray);
                                return;
                            }
                            ar.this.bm(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        ar.this.eVu.c(sparseArray);
                    } else if (booleanValue3) {
                        ar.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fcB.D(this.eQZ);
        aVX();
        this.fbS.addHeaderView(this.fbU);
        this.fbS.addHeaderView(this.fbW);
        this.fbS.addHeaderView(this.fbT);
        this.cMh = new PbListView(this.eVu.getPageContext().getPageActivity());
        this.aJi = this.cMh.getView().findViewById(d.g.pb_more_view);
        if (this.aJi != null) {
            this.aJi.setOnClickListener(this.cIN);
            com.baidu.tbadk.core.util.aj.j(this.aJi, d.f.pb_foot_more_trans_selector);
        }
        this.cMh.wr();
        this.cMh.dw(d.f.pb_foot_more_trans_selector);
        this.cMh.dy(d.f.pb_foot_more_trans_selector);
        this.fcH = this.eVu.findViewById(d.g.viewstub_progress);
        this.eVu.registerListener(this.fel);
        this.fcg = com.baidu.tbadk.ala.b.nv().g(this.eVu.getActivity(), 2);
        if (this.fcg != null) {
            this.fcg.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.eVu.getResources().getDimensionPixelSize(d.e.ds10);
            this.fch.addView(this.fcg, aVar);
        }
        this.eXm = new PbFakeFloorModel(this.eVu.getPageContext());
        this.fdK = new s(this.eVu.getPageContext(), this.eXm, this.ctl);
        this.fdK.a(this.eVu.eUv);
        this.eXm.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ar.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                ar.this.eXm.m(postData);
                ar.this.fcB.notifyDataSetChanged();
                ar.this.fdK.aUb();
                ar.this.IS.Bn();
                ar.this.jW(false);
            }
        });
        if (this.eVu.aSx() != null && !StringUtils.isNull(this.eVu.aSx().aUT())) {
            this.eVu.showToast(this.eVu.aSx().aUT());
        }
        this.fdt = this.eVu.findViewById(d.g.pb_expand_blank_view);
        this.fdu = this.eVu.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fdu.getLayoutParams();
        if (this.eVu.aSx() != null && this.eVu.aSx().aUq()) {
            this.fdt.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fdu.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fdw;
            this.fdu.setLayoutParams(layoutParams2);
        }
        this.fdv = new ak(this.eVu.getPageContext(), this.eVu.findViewById(d.g.pb_reply_expand_view));
        this.fdv.fbf.setVisibility(8);
        this.fdv.F(this.cIN);
        this.eVu.registerListener(this.cXk);
        this.eVu.registerListener(this.feh);
        this.eVu.registerListener(this.fei);
        aVT();
        jQ(false);
    }

    private void aVT() {
        this.fdY = new com.baidu.tieba.pb.pb.godreply.a(this.eVu, this, (ViewStub) this.ctl.findViewById(d.g.more_god_reply_popup));
        this.fdY.setCommonClickListener(this.cIN);
        this.fdY.D(this.eQZ);
        this.fdY.setOnImageClickListener(this.aVJ);
        this.fdY.setCommonClickListener(this.cIN);
        this.fdY.setTbGestureDetector(this.aVK);
    }

    public com.baidu.tieba.pb.pb.godreply.a aVU() {
        return this.fdY;
    }

    public View aVV() {
        return this.fdt;
    }

    public void aVW() {
        if (this.fbS != null) {
            this.fbS.removeHeaderView(this.fbU);
            this.fbS.removeHeaderView(this.fbW);
            this.fbS.removeHeaderView(this.fbT);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fdA == null) {
            this.fdA = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.eVu.getPageContext().getPageActivity());
            jQ(true);
            this.fdA.a(this.ctl, aVar, this.fdb.getVisibility() == 0);
            this.fdA.setOnEmotionClickListener(new a.InterfaceC0130a() { // from class: com.baidu.tieba.pb.pb.main.ar.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0130a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(ar.this.feg)) {
                        emotionImageData.setAuthorNameShow(ar.this.feg);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0130a
                public void a(String str, List<String> list, List<String> list2) {
                    ar.this.eVu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(ar.this.eVu.getPageContext().getPageActivity(), 25016, str, list, ar.this.feg, list2)));
                }
            });
            this.fdA.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    ar.this.aWT();
                    if (ar.this.fdb != null) {
                        ViewGroup.LayoutParams layoutParams = ar.this.fdb.getLayoutParams();
                        layoutParams.height = (int) (((ar.this.fdj - ar.this.fdi) * f) + ar.this.fdi);
                        ar.this.fdc.setAlpha(1.0f - f);
                        ar.this.fde.setAlpha(1.0f - f);
                        ar.this.fdd.setAlpha(1.0f - f);
                        ar.this.fdb.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void aVX() {
        if (this.fbU == null) {
            int f = com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.tbds44);
            this.fbU = new LinearLayout(this.eVu.getPageContext().getPageActivity());
            this.fbU.setOrientation(1);
            this.fbU.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fbU.setPadding(f, com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.tbds30), f, com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.tbds40));
            this.fbU.setGravity(17);
            this.fbV = new TextView(this.eVu.getPageContext().getPageActivity());
            this.fbV.setGravity(3);
            this.fbV.setMaxLines(2);
            this.fbV.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_link_tip_c));
            this.fbV.setPadding(0, 0, 0, 0);
            this.fbV.setLineSpacing(com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.i(this.fbV, d.C0095d.cp_cont_b);
            this.fbV.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fbV.setVisibility(8);
            this.fbU.addView(this.fbV);
            this.fbU.setOnTouchListener(this.aVK);
            this.fbU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVY() {
        if (this.eVu.aTp()) {
            this.fbR = (ViewStub) this.eVu.findViewById(d.g.manga_mention_controller_view_stub);
            this.fbR.setVisibility(0);
            if (this.fcu == null) {
                this.fcu = (LinearLayout) this.eVu.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.eVu.getPageContext(), this.fcu);
            }
            if (this.fcv == null) {
                this.fcv = (TextView) this.fcu.findViewById(d.g.manga_prev_btn);
            }
            if (this.fcw == null) {
                this.fcw = (TextView) this.fcu.findViewById(d.g.manga_next_btn);
            }
            this.fcv.setOnClickListener(this.cIN);
            this.fcw.setOnClickListener(this.cIN);
        }
    }

    private void aVZ() {
        if (this.eVu.aTp()) {
            if (this.eVu.aTs() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.fcv, d.C0095d.cp_cont_e, 1);
            }
            if (this.eVu.aTt() == -1) {
                com.baidu.tbadk.core.util.aj.c(this.fcw, d.C0095d.cp_cont_e, 1);
            }
        }
    }

    public void aWa() {
        if (this.fcu == null) {
            aVY();
        }
        this.fbR.setVisibility(8);
        if (this.fej != null && this.fek != null) {
            this.fej.removeCallbacks(this.fek);
        }
    }

    public void aWb() {
        if (this.fej != null) {
            if (this.fek != null) {
                this.fej.removeCallbacks(this.fek);
            }
            this.fek = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ar.this.fcu == null) {
                        ar.this.aVY();
                    }
                    ar.this.fbR.setVisibility(0);
                }
            };
            this.fej.postDelayed(this.fek, 2000L);
        }
    }

    public void jN(boolean z) {
        this.fbO.jN(z);
        if (z && this.fdl) {
            this.cMh.setText(this.eVu.getResources().getString(d.j.click_load_more));
            this.fbS.setNextPage(this.cMh);
            this.fbN = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.IS = iVar;
        this.IS.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ctl.addView(this.IS, layoutParams);
        this.IS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aVL();
        this.eVu.aSM().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ar.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ar.this.IS != null && ar.this.IS.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ar.this.fdX == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ar.this.IS.getId());
                            ar.this.fdX = new com.baidu.tieba.pb.pb.main.emotion.c(ar.this.eVu.getPageContext(), ar.this.ctl, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.w(ar.this.fdW)) {
                                ar.this.fdX.setData(ar.this.fdW);
                            }
                            ar.this.fdX.b(ar.this.IS);
                        }
                        ar.this.fdX.qa(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ar.this.eVu.eTD != null && ar.this.eVu.eTD.aWW() != null) {
                    if (!ar.this.eVu.eTD.aWW().bFH()) {
                        ar.this.eVu.eTD.ka(false);
                    }
                    ar.this.eVu.eTD.aWW().nU(false);
                }
            }
        });
    }

    public void aWc() {
        if (this.eVu != null && this.IS != null) {
            this.IS.lE();
            aWE();
        }
    }

    public void R(String str, boolean z) {
        this.fdh = z;
        jO(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void jO(boolean z) {
        if (this.fdf != null) {
            if (this.fdh) {
                com.baidu.tbadk.core.util.aj.j(this.fdf, d.f.pb_praise_already_click_selector);
                this.fdf.setContentDescription(this.eVu.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.j(this.fdf, d.f.pb_praise_normal_click_selector);
            this.fdf.setContentDescription(this.eVu.getResources().getString(d.j.zan));
        }
    }

    public TextView aWd() {
        return this.fdf;
    }

    public void jP(boolean z) {
        if (this.fbS != null && this.ayb != null && this.cJa != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cJa.setVisibility(0);
                } else {
                    this.cJa.setVisibility(8);
                    this.fbS.removeHeaderView(this.ayb);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ayb.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fdw;
                    this.ayb.setLayoutParams(layoutParams);
                }
                aWs();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ayb.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + jY(true);
                this.ayb.setLayoutParams(layoutParams2);
            }
            aWs();
            aWO();
        }
    }

    public h aWe() {
        return this.fcB;
    }

    public void a(PbActivity.d dVar) {
        this.eUz = dVar;
    }

    public void bm(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fcK == null) {
            this.fcK = LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.eVu.getLayoutMode().t(this.fcK);
        if (this.fcJ == null) {
            this.fcJ = new Dialog(this.eVu.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fcJ.setCanceledOnTouchOutside(true);
            this.fcJ.setCancelable(true);
            this.fcJ.setContentView(this.fcK);
            WindowManager.LayoutParams attributes = this.fcJ.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ac(this.eVu.getPageContext().getPageActivity()) * 0.9d);
            this.fcJ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fcJ.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fcJ.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fcJ.findViewById(d.g.disable_reply_btn);
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
                    if (ar.this.fcJ != null && (ar.this.fcJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fcJ, ar.this.eVu.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        ar.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || aWL()) {
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
                    if (ar.this.fcJ != null && (ar.this.fcJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fcJ, ar.this.eVu.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && ar.this.fem != null) {
                        ar.this.fem.f(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
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
                    if (ar.this.fcJ != null && (ar.this.fcJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(ar.this.fcJ, ar.this.eVu.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        ar.this.eVu.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fcJ, this.eVu.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fem = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(fdD, Integer.valueOf(fdE));
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
        this.fcL = new com.baidu.tbadk.core.dialog.a(this.eVu.getActivity());
        this.fcL.cd(i3);
        this.fcL.z(sparseArray);
        this.fcL.a(d.j.dialog_ok, this.eVu);
        this.fcL.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fcL.ao(true);
        this.fcL.b(this.eVu.getPageContext());
        this.fcL.th();
    }

    public void al(ArrayList<com.baidu.tbadk.core.data.z> arrayList) {
        if (this.fcO == null) {
            this.fcO = LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.eVu.getLayoutMode().t(this.fcO);
        if (this.fcN == null) {
            this.fcN = new Dialog(this.eVu.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fcN.setCanceledOnTouchOutside(true);
            this.fcN.setCancelable(true);
            this.fcY = (ScrollView) this.fcO.findViewById(d.g.good_scroll);
            this.fcN.setContentView(this.fcO);
            WindowManager.LayoutParams attributes = this.fcN.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds540);
            this.fcN.getWindow().setAttributes(attributes);
            this.cdc = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ar.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ar.this.fcT = (String) compoundButton.getTag();
                        if (ar.this.cdb != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : ar.this.cdb) {
                                String str = (String) aVar.getTag();
                                if (str != null && ar.this.fcT != null && !str.equals(ar.this.fcT)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fcP = (LinearLayout) this.fcO.findViewById(d.g.good_class_group);
            this.fcR = (TextView) this.fcO.findViewById(d.g.dialog_button_cancel);
            this.fcR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ar.this.fcN instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(ar.this.fcN, ar.this.eVu.getPageContext());
                    }
                }
            });
            this.fcQ = (TextView) this.fcO.findViewById(d.g.dialog_button_ok);
            this.fcQ.setOnClickListener(this.cIN);
        }
        this.fcP.removeAllViews();
        this.cdb = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bJ = bJ("0", this.eVu.getPageContext().getString(d.j.def_good_class));
        this.cdb.add(bJ);
        bJ.setChecked(true);
        this.fcP.addView(bJ);
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
                    this.cdb.add(bJ2);
                    View view = new View(this.eVu.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.aj.k(view, d.C0095d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fcP.addView(view);
                    this.fcP.addView(bJ2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fcY.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eVu.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eVu.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.eVu.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fcY.setLayoutParams(layoutParams2);
            this.fcY.removeAllViews();
            this.fcY.addView(this.fcP);
        }
        com.baidu.adp.lib.g.g.a(this.fcN, this.eVu.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bJ(String str, String str2) {
        Activity pageActivity = this.eVu.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cdc);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aWf() {
        this.eVu.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eVu.hideProgressBar();
        if (z && z2) {
            this.eVu.showToast(this.eVu.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.eVu.showToast(str);
        }
    }

    public void aBw() {
        this.fcH.setVisibility(0);
    }

    public void aBv() {
        this.fcH.setVisibility(8);
    }

    public View aWg() {
        if (this.fcO != null) {
            return this.fcO.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String aWh() {
        return this.fcT;
    }

    public View getView() {
        return this.ctl;
    }

    public void aWi() {
        com.baidu.adp.lib.util.l.a(this.eVu.getPageContext().getPageActivity(), this.eVu.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.eVu.hideProgressBar();
        if (z) {
            aWx();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            aWy();
        } else {
            aWx();
        }
    }

    public void aWj() {
        this.cMh.wr();
        this.cMh.wv();
    }

    public void aWk() {
        this.eVu.hideProgressBar();
        ww();
        this.fbS.completePullRefreshPostDelayed(2000L);
        aWu();
    }

    public void aWl() {
        this.fbS.completePullRefreshPostDelayed(2000L);
        aWu();
    }

    private void jQ(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fdc.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eVu.getResources().getDimensionPixelSize(d.e.ds130) : this.eVu.getResources().getDimensionPixelSize(d.e.ds34);
        this.fdc.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fcB.setOnLongClickListener(onLongClickListener);
        if (this.fdY != null) {
            this.fdY.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0060b interfaceC0060b, boolean z, boolean z2) {
        if (this.fcU != null) {
            this.fcU.dismiss();
            this.fcU = null;
        }
        this.fcU = new com.baidu.tbadk.core.dialog.b(this.eVu.getPageContext().getPageActivity());
        this.fcU.cg(d.j.operation);
        if (z2) {
            this.fcU.a(new String[]{this.eVu.getPageContext().getString(d.j.copy)}, interfaceC0060b);
        } else if (!z) {
            this.fcU.a(new String[]{this.eVu.getPageContext().getString(d.j.copy), this.eVu.getPageContext().getString(d.j.mark)}, interfaceC0060b);
        } else {
            this.fcU.a(new String[]{this.eVu.getPageContext().getString(d.j.copy), this.eVu.getPageContext().getString(d.j.remove_mark)}, interfaceC0060b);
        }
        this.fcU.d(this.eVu.getPageContext());
        this.fcU.tl();
    }

    public void a(b.InterfaceC0060b interfaceC0060b, boolean z) {
        if (this.fcV != null) {
            this.fcV.dismiss();
            this.fcV = null;
        }
        this.fcV = new com.baidu.tbadk.core.dialog.b(this.eVu.getPageContext().getPageActivity());
        this.fcV.cg(d.j.operation);
        if (z) {
            this.fcV.a(new String[]{this.eVu.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0060b);
        } else {
            this.fcV.a(new String[]{this.eVu.getPageContext().getString(d.j.save_to_emotion), this.eVu.getPageContext().getString(d.j.save_to_local)}, interfaceC0060b);
        }
        this.fcV.d(this.eVu.getPageContext());
        this.fcV.tl();
    }

    public int aWm() {
        return ql(this.fbS.getFirstVisiblePosition());
    }

    private int ql(int i) {
        com.baidu.adp.widget.ListView.d dVar = (com.baidu.adp.widget.ListView.d) this.fbS.getAdapter();
        if (dVar != null) {
            if (i < dVar.getCount() && i >= 0 && (dVar.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (dVar.getHeaderViewsCount() + dVar.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fbS.getAdapter() == null || !(this.fbS.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) ? 0 : ((com.baidu.adp.widget.ListView.d) this.fbS.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aWn() {
        int lastVisiblePosition = this.fbS.getLastVisiblePosition();
        if (this.fbI != null) {
            if (lastVisiblePosition == this.fbS.getCount() - 1) {
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
        if (this.fbS != null) {
            if (this.fbO == null || this.fbO.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fbO.mNavigationBar.getFixedNavHeight();
                if (this.eVu.aTb() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fdu != null && (layoutParams = (LinearLayout.LayoutParams) this.fdu.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fdu.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fbS.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fbS.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fcE.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        this.fcB.a(fVar, false);
        this.fcB.notifyDataSetChanged();
        aWu();
        if (this.fdY != null) {
            this.fdY.aSt();
        }
    }

    public void q(com.baidu.tieba.pb.data.f fVar) {
        if (this.fck == null) {
            this.eVu.getLayoutMode().t(((ViewStub) this.fbT.findViewById(d.g.praise_layout)).inflate());
            this.fck = (FrsPraiseView) this.fbT.findViewById(d.g.pb_head_praise_view);
            this.fck.setIsFromPb(true);
            this.fcz = this.fbT.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fck.dE(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fck != null) {
            boolean aWu = aWu();
            this.fck.setVisibility(8);
            if (fVar != null && fVar.qy() != null && fVar.qy().qv() == 0 && this.eQV) {
                if (aWu) {
                    this.fcy.setVisibility(0);
                    return;
                } else {
                    this.fcy.setVisibility(8);
                    return;
                }
            }
            this.fcy.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aRz() != null) {
            return fVar.aRz();
        }
        if (!com.baidu.tbadk.core.util.v.w(fVar.aRs())) {
            Iterator<PostData> it = fVar.aRs().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bwV() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aRx();
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
        if (fVar == null || fVar.aRq() == null || fVar.aRq().rv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rv = fVar.aRq().rv();
        String userId = rv.getUserId();
        HashMap<String, MetaData> userMap = fVar.aRq().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rv;
        }
        postData.uw(1);
        postData.setId(fVar.aRq().rM());
        postData.setTitle(fVar.aRq().getTitle());
        postData.setTime(fVar.aRq().getCreateTime());
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
        com.baidu.tbadk.data.i bwZ;
        String portrait;
        if (fVar != null && fVar.aRq() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            aWM();
            this.fbY.setVisibility(8);
            if (fVar.aRq() != null && fVar.aRq().si() && fVar.aRq().rN() != null) {
                this.fdO = true;
                this.fbO.kk(this.fdO);
                this.fbO.mNavigationBar.hideBottomLine();
                if (this.fbI == null) {
                    this.fbI = new com.baidu.tieba.pb.video.i(this.eVu, this.fbO, fVar.aRq().rN(), this.fbJ);
                    this.fbI.a(fVar.aRq().rN(), fVar.aRq(), fVar.getForumId());
                    this.fbI.startPlay();
                } else if (this.fbM) {
                    this.fbI.a(fVar.aRq().rN(), fVar.aRq(), fVar.getForumId());
                    this.fbI.startPlay();
                } else {
                    this.fbI.qm(fVar.getForumId());
                }
                if (fVar.aRr() != null && fVar.aRr().size() >= 1) {
                    bd bdVar = fVar.aRr().get(0);
                    this.fbI.af(bdVar);
                    this.fbI.qn(bdVar.getTitle());
                }
                this.fbI.b(b, fVar.aRq(), fVar.aRM());
                this.fbM = false;
                this.fbS.removeHeaderView(this.fbI.aYC());
                this.fbS.addHeaderView(this.fbI.aYC(), 0);
                if (this.fbI.aYA() != null && this.fbI.aYA().getParent() == null) {
                    this.fds.addView(this.fbI.aYA());
                }
                if (this.fbK == null) {
                    this.fbK = new com.baidu.tieba.pb.video.h(this.eVu);
                }
                this.fbK.a(fVar.aRq().sA(), fVar.aRq(), fVar.aRJ());
                this.fbS.removeHeaderView(this.fbK.aYr());
                this.fbS.addHeaderView(this.fbK.aYr(), 1);
                if (fVar.aRq().sA() != null) {
                    this.fbS.removeHeaderView(this.fbK.aYs());
                    this.fbS.removeHeaderView(this.fbW);
                    this.fbS.addHeaderView(this.fbK.aYs(), 2);
                } else {
                    if (this.fbK.aYs() != null) {
                        this.fbS.removeHeaderView(this.fbK.aYs());
                    }
                    this.fbS.removeHeaderView(this.fbW);
                    this.fbW.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.eVu, d.e.tbds56));
                    this.fbS.addHeaderView(this.fbW, 2);
                }
                if (this.fbI != null) {
                    this.fbO.kg(false);
                    this.fbO.kh(TbadkCoreApplication.isLogin());
                    this.fbI.qt(TbadkCoreApplication.getInst().getSkinType());
                }
                aWs();
            } else {
                this.fdO = false;
                this.fbO.kk(this.fdO);
                if (this.fbI != null) {
                    this.fbS.removeHeaderView(this.fbI.aYC());
                }
                if (this.fbK != null) {
                    this.fbK.f(this.fbS);
                }
                if (b == null || (b != null && (b.bwY() == null || com.baidu.tbadk.core.util.v.w(b.bwY().Jr())))) {
                    this.fbW.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(this.eVu, d.e.tbds80));
                } else {
                    this.fbW.setPadding(0, 0, 0, 0);
                }
            }
            if (this.eVu.aSQ() != null) {
                this.eVu.aSQ().ke(this.fdO);
            }
            if (this.fbI != null) {
                this.fbI.H(this.feo);
            }
            if (b != null) {
                this.fdk = b;
                this.fbY.setVisibility(0);
                if (this.eVu.aTD()) {
                    if (fVar.aRp() != null) {
                        this.mForumName = fVar.aRp().getForumName();
                        this.mForumId = fVar.aRp().getForumId();
                    }
                    if (this.mForumName == null && this.eVu.aSx() != null && this.eVu.aSx().aUm() != null) {
                        this.mForumName = this.eVu.aSx().aUm();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fbY.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fbY.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fec) {
                    this.fbU.setVisibility(0);
                }
                if (!fVar.aRq().si() && this.fbV.getText() != null && this.fbV.getText().length() > 0) {
                    this.fbV.setVisibility(0);
                } else {
                    this.fbV.setVisibility(8);
                }
                q(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> rH = fVar.aRq().rH();
                if (rH != null && rH.size() > 0 && !this.fec) {
                    this.fdn.setText(String.valueOf(rH.get(0).pr()));
                    this.fdm.setVisibility(0);
                } else {
                    this.fdm.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.j(this.fdm, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.c(this.fdn, d.C0095d.cp_link_tip_d, 1);
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
                            if (this.eWz != null) {
                                this.eWz.setTag(d.g.tag_user_id, b.rv().getUserId());
                                this.eWz.setOnClickListener(this.eVu.eTz.cSX);
                                this.eWz.a(iconInfo, 4, this.eVu.getResources().getDimensionPixelSize(d.e.tbds36), this.eVu.getResources().getDimensionPixelSize(d.e.tbds36), this.eVu.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.eWy != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.eWy.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.eWy.setOnClickListener(this.eVu.eTz.ffY);
                                this.eWy.a(tShowInfoNew, 3, this.eVu.getResources().getDimensionPixelSize(d.e.tbds36), this.eVu.getResources().getDimensionPixelSize(d.e.tbds36), this.eVu.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fca.setText(ag(b.rv().getSealPrefix(), e));
                            this.fca.setTag(d.g.tag_user_id, b.rv().getUserId());
                            this.fca.setTag(d.g.tag_user_name, b.rv().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew) || b.rv().isBigV()) {
                                com.baidu.tbadk.core.util.aj.c(this.fca, d.C0095d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.c(this.fca, d.C0095d.cp_cont_f, 1);
                            }
                            this.fcb.setVisibility(8);
                            if (fVar.aRq().rv() != null && fVar.aRq().rv().getAlaUserData() != null && this.fcg != null) {
                                if (fVar.aRq().rv().getAlaUserData().anchor_live != 0) {
                                    this.fcg.setVisibility(8);
                                } else {
                                    this.fcg.setVisibility(0);
                                    if (this.fbL == null) {
                                        this.fbL = new com.baidu.tieba.d.b(this.eVu.getPageContext(), this.fcg);
                                        this.fbL.iW(1);
                                    }
                                    this.fbL.aL(this.eVu.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.Rc = fVar.aRq().rv().getAlaUserData();
                                    aVar.type = 2;
                                    this.fcg.setTag(aVar);
                                }
                            }
                            this.fcf.setUserId(b.rv().getUserId());
                            this.fcf.setUserName(b.rv().getUserName());
                            this.fcf.setImageDrawable(null);
                            this.fcf.setRadius(com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds40));
                            this.fcf.setTag(b.rv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fcq.setText(com.baidu.tbadk.core.util.am.s(b.getTime()));
                            } else {
                                this.fcq.setText(com.baidu.tbadk.core.util.am.r(b.getTime()));
                            }
                            f = com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds16);
                            if (!this.eVu.aTD() && !StringUtils.isNull(this.mForumName)) {
                                this.cvf.setText(this.eVu.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.cvf.setVisibility(0);
                                this.fct.setVisibility(0);
                                this.fcq.setPadding(f, 0, f, 0);
                            } else {
                                this.cvf.setVisibility(8);
                                this.fct.setVisibility(8);
                                this.fcq.setPadding(0, 0, f, 0);
                            }
                            bwZ = b.bwZ();
                            if (bwZ == null && !TextUtils.isEmpty(bwZ.getName()) && !TextUtils.isEmpty(bwZ.getName().trim())) {
                                final String name = bwZ.getName();
                                final String lat = bwZ.getLat();
                                final String lng = bwZ.getLng();
                                this.fcr.setVisibility(0);
                                this.fcs.setVisibility(0);
                                this.fcr.setText(bwZ.getName());
                                this.fcr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.hh()) {
                                                ar.this.eVu.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.O(ar.this.eVu.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, ar.this.eVu.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fcr.setVisibility(8);
                                this.fcs.setVisibility(8);
                            }
                            portrait = b.rv().getPortrait();
                            if (b.rv().getPendantData() == null && !StringUtils.isNull(b.rv().getPendantData().pR())) {
                                UtilHelper.showHeadImageViewBigV(this.fcd.getHeadView(), b.rv());
                                this.fcf.setVisibility(8);
                                this.fcd.setVisibility(0);
                                if (this.fcl != null) {
                                    this.fcl.setVisibility(8);
                                }
                                this.fca.setOnClickListener(this.feo);
                                this.fcd.getHeadView().startLoad(portrait, 28, false);
                                this.fcd.getHeadView().setUserId(b.rv().getUserId());
                                this.fcd.getHeadView().setUserName(b.rv().getUserName());
                                this.fcd.getHeadView().setOnClickListener(this.feo);
                                this.fcd.es(b.rv().getPendantData().pR());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fcf, b.rv());
                                this.fcf.setVisibility(0);
                                this.fbY.setOnClickListener(this.feo);
                                this.fca.setOnClickListener(this.feo);
                                this.fcf.setOnClickListener(this.feo);
                                this.fcd.setVisibility(8);
                                this.fcf.startLoad(portrait, 28, false);
                            }
                            String name_show = b.rv().getName_show();
                            String userName = b.rv().getUserName();
                            if (com.baidu.tbadk.o.ac.fS() && name_show != null && !name_show.equals(userName)) {
                                this.fca.setText(com.baidu.tieba.pb.c.aj(this.eVu.getPageContext().getPageActivity(), this.fca.getText().toString()));
                                this.fca.setGravity(16);
                                this.fca.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQS());
                                com.baidu.tbadk.core.util.aj.c(this.fca, d.C0095d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.rv().getIconInfo();
                        tShowInfoNew = b.rv().getTShowInfoNew();
                        if (this.eWz != null) {
                        }
                        if (this.eWy != null) {
                        }
                        this.fca.setText(ag(b.rv().getSealPrefix(), e));
                        this.fca.setTag(d.g.tag_user_id, b.rv().getUserId());
                        this.fca.setTag(d.g.tag_user_name, b.rv().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.fca, d.C0095d.cp_cont_h, 1);
                        this.fcb.setVisibility(8);
                        if (fVar.aRq().rv() != null) {
                            if (fVar.aRq().rv().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fcf.setUserId(b.rv().getUserId());
                        this.fcf.setUserName(b.rv().getUserName());
                        this.fcf.setImageDrawable(null);
                        this.fcf.setRadius(com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds40));
                        this.fcf.setTag(b.rv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds16);
                        if (!this.eVu.aTD()) {
                        }
                        this.cvf.setVisibility(8);
                        this.fct.setVisibility(8);
                        this.fcq.setPadding(0, 0, f, 0);
                        bwZ = b.bwZ();
                        if (bwZ == null) {
                        }
                        this.fcr.setVisibility(8);
                        this.fcs.setVisibility(8);
                        portrait = b.rv().getPortrait();
                        if (b.rv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fcf, b.rv());
                        this.fcf.setVisibility(0);
                        this.fbY.setOnClickListener(this.feo);
                        this.fca.setOnClickListener(this.feo);
                        this.fcf.setOnClickListener(this.feo);
                        this.fcd.setVisibility(8);
                        this.fcf.startLoad(portrait, 28, false);
                        String name_show2 = b.rv().getName_show();
                        String userName2 = b.rv().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                            this.fca.setText(com.baidu.tieba.pb.c.aj(this.eVu.getPageContext().getPageActivity(), this.fca.getText().toString()));
                            this.fca.setGravity(16);
                            this.fca.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQS());
                            com.baidu.tbadk.core.util.aj.c(this.fca, d.C0095d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aP(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.rv().getIconInfo();
                            tShowInfoNew = b.rv().getTShowInfoNew();
                            if (this.eWz != null) {
                            }
                            if (this.eWy != null) {
                            }
                            this.fca.setText(ag(b.rv().getSealPrefix(), e));
                            this.fca.setTag(d.g.tag_user_id, b.rv().getUserId());
                            this.fca.setTag(d.g.tag_user_name, b.rv().getName_show());
                            if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.c(this.fca, d.C0095d.cp_cont_h, 1);
                            this.fcb.setVisibility(8);
                            if (fVar.aRq().rv() != null) {
                            }
                            this.fcf.setUserId(b.rv().getUserId());
                            this.fcf.setUserName(b.rv().getUserName());
                            this.fcf.setImageDrawable(null);
                            this.fcf.setRadius(com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds40));
                            this.fcf.setTag(b.rv().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            f = com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds16);
                            if (!this.eVu.aTD()) {
                            }
                            this.cvf.setVisibility(8);
                            this.fct.setVisibility(8);
                            this.fcq.setPadding(0, 0, f, 0);
                            bwZ = b.bwZ();
                            if (bwZ == null) {
                            }
                            this.fcr.setVisibility(8);
                            this.fcs.setVisibility(8);
                            portrait = b.rv().getPortrait();
                            if (b.rv().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fcf, b.rv());
                            this.fcf.setVisibility(0);
                            this.fbY.setOnClickListener(this.feo);
                            this.fca.setOnClickListener(this.feo);
                            this.fcf.setOnClickListener(this.feo);
                            this.fcd.setVisibility(8);
                            this.fcf.startLoad(portrait, 28, false);
                            String name_show22 = b.rv().getName_show();
                            String userName22 = b.rv().getUserName();
                            if (com.baidu.tbadk.o.ac.fS()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.rv().getIconInfo();
                        tShowInfoNew = b.rv().getTShowInfoNew();
                        if (this.eWz != null) {
                        }
                        if (this.eWy != null) {
                        }
                        this.fca.setText(ag(b.rv().getSealPrefix(), e));
                        this.fca.setTag(d.g.tag_user_id, b.rv().getUserId());
                        this.fca.setTag(d.g.tag_user_name, b.rv().getName_show());
                        if (com.baidu.tbadk.core.util.v.w(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.c(this.fca, d.C0095d.cp_cont_h, 1);
                        this.fcb.setVisibility(8);
                        if (fVar.aRq().rv() != null) {
                        }
                        this.fcf.setUserId(b.rv().getUserId());
                        this.fcf.setUserName(b.rv().getUserName());
                        this.fcf.setImageDrawable(null);
                        this.fcf.setRadius(com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds40));
                        this.fcf.setTag(b.rv().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        f = com.baidu.adp.lib.util.l.f(this.eVu.getActivity(), d.e.ds16);
                        if (!this.eVu.aTD()) {
                        }
                        this.cvf.setVisibility(8);
                        this.fct.setVisibility(8);
                        this.fcq.setPadding(0, 0, f, 0);
                        bwZ = b.bwZ();
                        if (bwZ == null) {
                        }
                        this.fcr.setVisibility(8);
                        this.fcs.setVisibility(8);
                        portrait = b.rv().getPortrait();
                        if (b.rv().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fcf, b.rv());
                        this.fcf.setVisibility(0);
                        this.fbY.setOnClickListener(this.feo);
                        this.fca.setOnClickListener(this.feo);
                        this.fcf.setOnClickListener(this.feo);
                        this.fcd.setVisibility(8);
                        this.fcf.startLoad(portrait, 28, false);
                        String name_show222 = b.rv().getName_show();
                        String userName222 = b.rv().getUserName();
                        if (com.baidu.tbadk.o.ac.fS()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.fbX.Y(fVar.aRq());
                }
                if (this.fdv != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eQa);
                    if (fVar != null && fVar.aRq() != null) {
                        jVar.eQc = fVar.aRq().rn();
                    }
                    jVar.aFS = !this.eQV;
                    jVar.eQe = this.eVu.aTC();
                    this.fdv.a(jVar);
                }
            }
        }
    }

    public void jR(boolean z) {
        if (z) {
            aWo();
        } else {
            aWp();
        }
        this.fdz.feG = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fdz));
        a(this.fdz.feG, false);
    }

    public void aWo() {
        if (this.fbO != null && !this.fdQ) {
            this.fbO.kl(!StringUtils.isNull(this.eVu.aSY()));
            this.fdQ = true;
        }
    }

    public void aWp() {
        if (this.fbO != null) {
            this.fbO.aXp();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.rR() != null) {
            this.fbZ.a(this.eVu.getPageContext(), fVar.aRs().get(0).rR(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aRo().getId(), fVar.aRo().getName(), fVar.aRq().getId(), this.eVu.aTz() ? "FRS" : null));
            this.fbY.setPadding(this.fbY.getPaddingLeft(), (int) this.eVu.getResources().getDimension(d.e.ds20), this.fbY.getPaddingRight(), this.fbY.getPaddingBottom());
            return;
        }
        this.fbZ.a(null, null, null);
    }

    public void aWq() {
        if (this.fbI != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").r("obj_type", 1));
            this.fbI.aYB();
            this.fbS.smoothScrollToPosition(0);
        }
    }

    public boolean aWr() {
        return this.fep;
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
            this.fbO.aXn();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.fbO.nG(eVar.forumName);
            }
            String string = this.eVu.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.g(eVar.source, 0)) {
                case 100:
                    str = this.eVu.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.eVu.getResources().getString(d.j.bawu);
                    break;
                case 400:
                    str = this.eVu.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.ePp;
            this.eVu.showNetRefreshView(this.ctl, format, null, this.eVu.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        com.baidu.tbadk.core.util.av.vI().c(ar.this.eVu.getPageContext(), new String[]{str2});
                        ar.this.eVu.finish();
                        return;
                    }
                    ar.this.eVu.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aVx;
        Parcelable aVx2;
        String str;
        if (fVar != null) {
            this.eYp = fVar;
            this.mType = i;
            if (fVar.aRq() != null) {
                this.fdB = fVar.aRq().rg();
                if (fVar.aRq().getAnchorLevel() != 0) {
                    this.fep = true;
                }
                this.fcX = P(fVar.aRq());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            t(fVar);
            this.fdl = false;
            this.eQV = z;
            aWk();
            b(fVar, z, i);
            PostData b = b(fVar, z);
            this.fcB.jp(this.fbW.getPaddingBottom() > 0 || (b != null && b.getType() == PostData.gBS));
            r(fVar);
            if (this.eVu.aTp()) {
                if (this.fcF == null) {
                    this.fcF = new com.baidu.tieba.pb.view.i(this.eVu.getPageContext());
                    this.fcF.kX();
                    this.fcF.a(this.amU);
                }
                this.fbS.setPullRefresh(this.fcF);
                aWs();
                if (this.fcF != null) {
                    this.fcF.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.qy().qv() == 0 && z) {
                this.fbS.setPullRefresh(null);
            } else {
                if (this.fcF == null) {
                    this.fcF = new com.baidu.tieba.pb.view.i(this.eVu.getPageContext());
                    this.fcF.kX();
                    this.fcF.a(this.amU);
                }
                this.fbS.setPullRefresh(this.fcF);
                aWs();
                if (this.fcF != null) {
                    this.fcF.dz(TbadkCoreApplication.getInst().getSkinType());
                }
                XC();
            }
            aWu();
            this.fcB.iZ(this.eQV);
            this.fcB.ja(false);
            this.fcB.jl(i == 5);
            this.fcB.jm(i == 6);
            this.fcB.jn(z2 && this.fen);
            this.fcB.a(fVar, false);
            this.fcB.notifyDataSetChanged();
            if (this.eVu.aTD()) {
                this.fdS = 0;
                PostData b2 = b(fVar, z);
                if (b2 != null && b2.rv() != null) {
                    this.fdS = b2.rv().getLevel_id();
                }
                if (this.fdS > 0) {
                    this.fcc.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.fcc, BitmapHelper.getGradeResourceIdInEnterForum(this.fdS));
                } else {
                    this.fcc.setVisibility(8);
                }
            } else {
                this.fcc.setVisibility(8);
            }
            if (fVar.aRq() != null && fVar.aRq().rk() != null) {
                if (fVar.aRq().rk().getNum() < 1) {
                    str = this.eVu.getResources().getString(d.j.zan);
                } else {
                    str = fVar.aRq().rk().getNum() + "";
                }
                if (this.fbH != -1) {
                    fVar.aRq().rk().setIsLike(this.fbH);
                }
                R(str, fVar.aRq().rk().getIsLike() == 1);
            }
            if (this.eVu.isLogin()) {
                this.fbS.setNextPage(this.cMh);
                this.fbN = 2;
                XC();
            } else {
                this.fdl = true;
                if (fVar.qy().qu() == 1) {
                    if (this.fcG == null) {
                        this.fcG = new com.baidu.tieba.pb.view.b(this.eVu.getPageContext());
                    }
                    this.fbS.setNextPage(this.fcG);
                } else {
                    this.fbS.setNextPage(this.cMh);
                }
                this.fbN = 3;
            }
            ArrayList<PostData> aRs = fVar.aRs();
            if (fVar.qy().qu() == 0 || aRs == null || aRs.size() < fVar.qy().qt()) {
                if (com.baidu.tbadk.core.util.v.v(aRs) == 0 || (com.baidu.tbadk.core.util.v.v(aRs) == 1 && aRs.get(0) != null && aRs.get(0).bwV() == 1)) {
                    this.cMh.setText(this.eVu.getResources().getString(d.j.list_no_more_new));
                    if (this.eVu.aSQ() != null && !this.eVu.aSQ().aXg()) {
                        this.eVu.aSQ().showFloatingView();
                    }
                } else {
                    this.cMh.setText(this.eVu.getResources().getString(d.j.list_has_no_more));
                }
                if (this.eVu.aTp() && this.fbS != null && this.fbS.getData() != null && this.fbS.getData().size() == 1 && (this.fbS.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.cMh.setText("");
                }
                aWB();
            } else if (z2) {
                if (this.fen) {
                    ww();
                    if (fVar.qy().qu() != 0) {
                        this.cMh.setText(this.eVu.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.cMh.wr();
                    this.cMh.showLoading();
                }
            } else {
                this.cMh.wr();
                this.cMh.showLoading();
            }
            switch (i) {
                case 2:
                    this.fbS.setSelection(i2 > 1 ? (((this.fbS.getData() == null && fVar.aRs() == null) ? 0 : (this.fbS.getData().size() - fVar.aRs().size()) + this.fbS.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (aVx2 = ai.aVw().aVx()) != null) {
                        this.fbS.onRestoreInstanceState(aVx2);
                        if (com.baidu.tbadk.core.util.v.v(aRs) > 1 && fVar.qy().qu() > 0) {
                            this.cMh.ww();
                            this.cMh.setText(this.eVu.getString(d.j.pb_load_more_without_point));
                            this.cMh.ws();
                            break;
                        }
                    } else {
                        this.fbS.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fen = false;
                    break;
                case 5:
                    this.fbS.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aVx = ai.aVw().aVx()) != null) {
                        this.fbS.onRestoreInstanceState(aVx);
                        break;
                    } else {
                        this.fbS.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fbI != null && this.fbI.aYA() != null) {
                            if (this.eVu.isUseStyleImmersiveSticky()) {
                                this.fbS.setSelectionFromTop((this.fcB.aTT() + this.fbS.getHeaderViewsCount()) - 1, this.fbI.aYA().getHeight() - com.baidu.adp.lib.util.l.n(this.eVu.getPageContext().getPageActivity()));
                            } else {
                                this.fbS.setSelectionFromTop((this.fcB.aTT() + this.fbS.getHeaderViewsCount()) - 1, this.fbI.aYA().getHeight());
                            }
                        } else {
                            this.fbS.setSelection(this.fcB.aTT() + this.fbS.getHeaderViewsCount());
                        }
                    } else {
                        this.fbS.setSelection(i2 > 0 ? ((this.fbS.getData() == null && fVar.aRs() == null) ? 0 : (this.fbS.getData().size() - fVar.aRs().size()) + this.fbS.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.cMh.ww();
                    this.cMh.setText(this.eVu.getString(d.j.pb_load_more_without_point));
                    this.cMh.ws();
                    break;
            }
            if (this.fdB == fdC && isHost()) {
                aWH();
            }
            if (this.fdM) {
                aVI();
                this.fdM = false;
                if (i3 == 0) {
                    jK(true);
                }
            }
            if (this.fbK != null) {
                this.fbK.ae(fVar.aRq());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    private void aWs() {
        if (this.fbI != null && this.fbI.aYA() != null) {
            this.fbS.removeHeaderView(this.ayb);
            if (this.mType != 1) {
                this.fbS.removeHeaderView(this.fbI.aYC());
                this.fbS.addHeaderView(this.fbI.aYC(), 0);
                return;
            }
            return;
        }
        if (this.fbI != null) {
            this.fbS.removeHeaderView(this.fbI.aYC());
        }
        this.fbS.removeHeaderView(this.ayb);
        this.fbS.addHeaderView(this.ayb, 0);
    }

    public void jS(boolean z) {
        this.fcW = z;
    }

    public void ww() {
        if (this.cMh != null) {
            this.cMh.ws();
            this.cMh.ww();
        }
        XC();
    }

    public void PB() {
        this.fbS.setVisibility(0);
    }

    public void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.fdk != null && this.fdk.rv() != null && this.fbO != null) {
            this.fdP = !this.fdO;
            this.fbO.kg(this.fdP);
            if (this.eVu.aSQ() != null) {
                this.eVu.aSQ().kf(this.fdP);
            }
            aWt();
            if (this.fdP) {
                this.fbO.fgM.setVisibility(0);
                if (this.fcX) {
                    this.fbO.fgN.setVisibility(8);
                    this.fcm.setVisibility(8);
                    this.fcp.setVisibility(0);
                    this.fcp.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aRL())));
                } else if (!PbNormalLikeButtonSwitchStatic.GV() || (this.fdk.rv().hadConcerned() && this.fdk.rv().getGodUserData() != null && this.fdk.rv().getGodUserData().getIsFromNetWork())) {
                    this.fbO.fgN.setVisibility(8);
                }
                if (this.fdu != null) {
                    this.fdu.setVisibility(8);
                }
                this.fbO.a(this.fdk.rv(), this.feo);
                if (this.fdZ == null) {
                    this.fdZ = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ar.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > ar.this.fdR) {
                                ar.this.aWG();
                            }
                        }
                    };
                }
                this.fbS.setListViewDragListener(this.fdZ);
                return;
            }
            if (this.fbO.fgM != null) {
                this.fbO.fgM.setVisibility(8);
            }
            if (this.fdu != null) {
                this.fdu.setVisibility(0);
            }
            if (this.fcX) {
                this.fcm.setVisibility(8);
                this.fcp.setVisibility(0);
                this.fcp.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.w(fVar.aRL())));
            } else if (!PbNormalLikeButtonSwitchStatic.GV() || (this.fdk.rv().hadConcerned() && this.fdk.rv().getGodUserData() != null && this.fdk.rv().getGodUserData().getIsFromNetWork())) {
                this.fcm.setVisibility(8);
                this.fcp.setVisibility(8);
            } else {
                this.fcp.setVisibility(8);
            }
            this.fdZ = null;
            this.fbS.setListViewDragListener(null);
        }
    }

    private void aWt() {
        String threadId = this.eYp != null ? this.eYp.getThreadId() : "";
        if (this.fdP) {
            if (this.fco == null) {
                this.fco = new ap(this.eVu.getPageContext(), this.fbO.fgN, 3);
                this.fco.h(this.eVu.getUniqueId());
            }
            if (this.fdk != null && this.fdk.rv() != null) {
                this.fdk.rv().setIsLike(this.fdk.rv().hadConcerned());
                this.fco.a(this.fdk.rv());
            }
            this.fco.cD(threadId);
            this.fco.fbE = this.fdO;
        }
        if (this.fcn == null) {
            this.fcn = new ap(this.eVu.getPageContext(), this.fcm, 1);
            this.fcn.h(this.eVu.getUniqueId());
            this.fcn.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.ar.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void aO(boolean z) {
                    if (ar.this.eVu != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(ar.this.eVu, d.j.attention_success);
                            return;
                        }
                        aq.v(ar.this.eVu.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fdk != null && this.fdk.rv() != null) {
            this.fdk.rv().setIsLike(this.fdk.rv().hadConcerned());
            this.fcn.a(this.fdk.rv());
            this.fcn.cD(threadId);
        }
        this.fcn.fbE = this.fdO;
    }

    private boolean aWu() {
        boolean z;
        if (this.fda != null && this.fda.getVisibility() == 0) {
            if (this.fcx != null) {
                this.fcx.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fcx != null) {
                this.fcx.setVisibility(8);
            }
            z = false;
        }
        if ((this.fcz == null || this.fcz.getVisibility() == 8) && z && this.eQV) {
            this.fcy.setVisibility(0);
        } else {
            this.fcy.setVisibility(8);
        }
        return z;
    }

    private boolean s(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aRq() == null) {
            return false;
        }
        if (fVar.aRq().rs() == 1 || fVar.aRq().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aRq().ru() == null || fVar.aRq().ru().sV() == 0) || fVar.aRq().rq() == 1 || fVar.aRq().rr() == 1 || fVar.aRq().sa() || fVar.aRq().so() || fVar.aRq().sh() || fVar.aRq().rI() != null || fVar.aRq().sp() || fVar.aRq().sp() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aRq().getCategory()) || fVar.aRq().rz() || fVar.aRq().ry();
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return com.baidu.tieba.card.k.a((Context) this.eVu.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.fbU != null) {
                if (fVar.aRq() != null && fVar.aRq().rL() == 0 && !fVar.aRq().si() && !this.fec) {
                    this.fbU.setVisibility(0);
                    if (fVar.aRq() != null) {
                        fVar.aRq().e(true, s(fVar));
                    }
                    SpannableStringBuilder rV = fVar.aRq().rV();
                    this.fbV.setOnTouchListener(new com.baidu.tieba.view.l(rV));
                    if (this.fea) {
                        this.fbV.setText(fVar.aRq().getTitle());
                    } else {
                        this.fbV.setText(rV);
                    }
                    this.fbV.setVisibility(0);
                } else if (fVar.aRq().rL() == 1) {
                    if (fVar.aRq() != null) {
                        fVar.aRq().e(true, s(fVar));
                        SpannableStringBuilder rV2 = fVar.aRq().rV();
                        if (rV2 == null || rV2.length() == 0) {
                            this.fbU.setVisibility(8);
                            this.fbS.removeHeaderView(this.fbU);
                            if (fVar.aRq() != null && !fVar.aRq().si()) {
                                this.fbY.setPadding(this.fbY.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds48), this.fbY.getPaddingRight(), this.fbY.getPaddingBottom());
                            }
                        } else {
                            this.fbU.setVisibility(0);
                            this.fbV.setOnTouchListener(new com.baidu.tieba.view.l(rV2));
                            this.fbV.setText(rV2);
                            this.fbV.setVisibility(0);
                        }
                    }
                } else {
                    this.fbU.setVisibility(8);
                    this.fbS.removeHeaderView(this.fbU);
                    if (fVar.aRq() != null && fVar.aRq().si()) {
                        this.fbY.setPadding(this.fbY.getPaddingLeft(), 0, this.fbY.getPaddingRight(), this.fbY.getPaddingBottom());
                    } else {
                        this.fbY.setPadding(this.fbY.getPaddingLeft(), com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds48), this.fbY.getPaddingRight(), this.fbY.getPaddingBottom());
                    }
                }
            }
            this.eQV = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            aWu();
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
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aRB()));
            sparseArray.put(d.g.tag_should_manage_visible, false);
        } else if (i == 1) {
            if (b.rv() != null) {
                sparseArray.put(d.g.tag_forbid_user_name, b.rv().getUserName());
                sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
            }
            sparseArray.put(d.g.tag_del_post_id, b.getId());
            sparseArray.put(d.g.tag_del_post_type, 0);
            sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aRB()));
            sparseArray.put(d.g.tag_should_manage_visible, true);
        }
        return sparseArray;
    }

    public View getNextView() {
        return this.aJi;
    }

    public void pT(String str) {
        if (this.cMh != null) {
            this.cMh.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fbS;
    }

    public int aWv() {
        return d.g.richText;
    }

    public TextView aSL() {
        return this.fbX.aSL();
    }

    public void d(BdListView.e eVar) {
        this.fbS.setOnSrollToBottomListener(eVar);
    }

    public void a(h.b bVar) {
        this.amU = bVar;
        if (this.fcF != null) {
            this.fcF.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar, a.b bVar) {
        if (alVar != null) {
            int qs = alVar.qs();
            int qp = alVar.qp();
            if (this.fcC != null) {
                this.fcC.th();
            } else {
                this.fcC = new com.baidu.tbadk.core.dialog.a(this.eVu.getPageContext().getPageActivity());
                this.fcD = LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fcC.v(this.fcD);
                this.fcC.a(d.j.dialog_ok, bVar);
                this.fcC.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ar.this.aWx();
                        aVar.dismiss();
                    }
                });
                this.fcC.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ar.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ar.this.fdJ == null) {
                            ar.this.fdJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ar.this.eVu.HidenSoftKeyPad((InputMethodManager) ar.this.eVu.getSystemService("input_method"), ar.this.ctl);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(ar.this.fdJ, 150L);
                    }
                });
                this.fcC.b(this.eVu.getPageContext()).th();
            }
            this.fcE = (EditText) this.fcD.findViewById(d.g.input_page_number);
            this.fcE.setText("");
            TextView textView = (TextView) this.fcD.findViewById(d.g.current_page_number);
            if (qs <= 0) {
                qs = 1;
            }
            if (qp <= 0) {
                qp = 1;
            }
            textView.setText(MessageFormat.format(this.eVu.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(qs), Integer.valueOf(qp)));
            this.eVu.ShowSoftKeyPadDelay(this.fcE, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fbS.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eVu.showToast(str);
    }

    public boolean jT(boolean z) {
        if (this.IS == null || !this.IS.Dh()) {
            return false;
        }
        this.IS.Bn();
        return true;
    }

    public void aWw() {
        if (this.feq != null) {
            while (this.feq.size() > 0) {
                TbImageView remove = this.feq.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aWw();
        this.fcB.pW(1);
        if (this.fbI != null) {
            this.fbI.onPause();
        }
    }

    public void onResume() {
        this.fcB.pW(2);
        if (this.fbI != null) {
            this.fbI.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fdL != null) {
            this.fdL.destroy();
        }
        if (this.fbL != null) {
            this.fbL.adI();
        }
        if (this.fbK != null) {
            this.fbK.onDestroy();
        }
        this.eVu.hideProgressBar();
        if (this.ctj != null && this.cFA != null) {
            this.ctj.b(this.cFA);
        }
        aWx();
        ww();
        if (this.fdJ != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fdJ);
        }
        if (this.fbY != null && this.fcl != null) {
            this.fbY.removeView(this.fce);
            this.fcl = null;
        }
        if (this.fdp != null) {
            this.fdp.clearStatus();
        }
        this.fej = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fcB.pW(3);
        if (this.cJa != null) {
            this.cJa.setBackgroundDrawable(null);
        }
        if (this.fbI != null) {
            this.fbI.destroy();
        }
        if (this.fcB != null) {
            this.fcB.onDestory();
        }
        this.fbS.setOnLayoutListener(null);
        if (this.fdX != null) {
            this.fdX.and();
        }
        if (this.fdA != null) {
            this.fdA.onDestroy();
        }
        aWT();
    }

    public boolean qn(int i) {
        if (this.fbI != null) {
            return this.fbI.ka(i);
        }
        return false;
    }

    public void aWx() {
        this.fbO.or();
        if (this.fbL != null) {
            this.fbL.adI();
        }
        com.baidu.adp.lib.util.l.a(this.eVu.getPageContext().getPageActivity(), this.fcE);
        aVL();
        if (this.fcU != null) {
            this.fcU.dismiss();
        }
        aWz();
        if (this.fbK != null) {
            this.fbK.aYt();
        }
        if (this.fcC != null) {
            this.fcC.dismiss();
        }
        if (this.cIM != null) {
            this.cIM.dismiss();
        }
    }

    public void aWy() {
        this.fbO.or();
        if (this.fbL != null) {
            this.fbL.adI();
        }
        if (this.fcU != null) {
            this.fcU.dismiss();
        }
        aWz();
        if (this.fbK != null) {
            this.fbK.aYt();
        }
        if (this.fcC != null) {
            this.fcC.dismiss();
        }
        if (this.cIM != null) {
            this.cIM.dismiss();
        }
    }

    public void cL(List<String> list) {
        this.fdW = list;
        if (this.fdX != null) {
            this.fdX.setData(list);
        }
    }

    public void iY(boolean z) {
        this.fcB.iY(z);
    }

    public void jU(boolean z) {
        this.fcZ = z;
    }

    public void aWz() {
        if (this.fcL != null) {
            this.fcL.dismiss();
        }
        if (this.fcM != null) {
            com.baidu.adp.lib.g.g.b(this.fcM, this.eVu.getPageContext());
        }
        if (this.fcN != null) {
            com.baidu.adp.lib.g.g.b(this.fcN, this.eVu.getPageContext());
        }
        if (this.fcJ != null) {
            com.baidu.adp.lib.g.g.b(this.fcJ, this.eVu.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.eYp, this.eQV);
            d(this.eYp, this.eQV, this.mType);
            this.eVu.getLayoutMode().ag(i == 1);
            this.eVu.getLayoutMode().t(this.ctl);
            this.eVu.getLayoutMode().t(this.fbV);
            this.eVu.getLayoutMode().t(this.fbW);
            this.eVu.getLayoutMode().t(this.fbT);
            if (this.fcj != null) {
                com.baidu.tbadk.core.util.aj.c(this.fcj, d.C0095d.cp_cont_d, 1);
            }
            if (this.fci != null) {
                com.baidu.tbadk.core.util.aj.c(this.fci, d.C0095d.cp_cont_d, 1);
            }
            if (this.fbK != null) {
                this.fbK.onChangeSkinType(i);
            }
            this.eVu.getLayoutMode().t(this.fbT);
            com.baidu.tbadk.core.util.aj.i(this.fbV, d.C0095d.cp_cont_b);
            this.fbV.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_link_tip_c));
            this.eVu.getLayoutMode().t(this.aJi);
            if (this.fcC != null) {
                this.fcC.c(this.eVu.getPageContext());
            }
            jS(this.fcW);
            this.fcB.notifyDataSetChanged();
            if (this.fcF != null) {
                this.fcF.dz(i);
            }
            if (this.cMh != null) {
                this.cMh.dz(i);
                com.baidu.tbadk.core.util.aj.j(this.aJi, d.f.pb_foot_more_trans_selector);
                this.cMh.dw(d.f.pb_foot_more_trans_selector);
            }
            if (this.IS != null) {
                this.IS.onChangeSkinType(i);
            }
            if (this.fck != null) {
                this.fck.dE(i);
            }
            if (this.fcG != null) {
                this.fcG.dz(i);
            }
            if (this.cdb != null && this.cdb.size() > 0) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.cdb) {
                    aVar.we();
                }
            }
            jO(i == 1);
            aVZ();
            UtilHelper.setStatusBarBackground(this.cJa, i);
            UtilHelper.setStatusBarBackground(this.fdu, i);
            if (this.fcm != null) {
                this.fcm.onChangeSkinType(i);
            }
            if (this.fcr != null) {
                com.baidu.tbadk.core.util.aj.i(this.fcr, d.C0095d.cp_cont_d);
            }
            if (this.fcq != null) {
                com.baidu.tbadk.core.util.aj.i(this.fcq, d.C0095d.cp_cont_d);
            }
            if (this.fcs != null) {
                com.baidu.tbadk.core.util.aj.j(this.fcs, d.C0095d.cp_cont_e);
            }
            if (this.cvf != null) {
                com.baidu.tbadk.core.util.aj.i(this.cvf, d.C0095d.cp_cont_d);
            }
            if (this.fct != null) {
                com.baidu.tbadk.core.util.aj.j(this.fct, d.C0095d.cp_cont_e);
            }
            if (this.fcb != null) {
                com.baidu.tbadk.core.util.aj.i(this.fcb, d.C0095d.cp_link_tip_a);
            }
            if (this.fcp != null) {
                com.baidu.tbadk.core.util.aj.i(this.fcp, d.C0095d.cp_cont_d);
            }
            if (this.fcu != null) {
                com.baidu.tbadk.n.a.a(this.eVu.getPageContext(), this.fcu);
            }
            if (this.fcS != null) {
                com.baidu.tbadk.n.a.a(this.eVu.getPageContext(), this.fcS);
            }
            if (this.fdK != null) {
                this.fdK.onChangeSkinType(i);
            }
            if (this.fbO != null) {
                if (this.fbI != null) {
                    this.fbI.qt(i);
                } else {
                    this.fbO.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fdc != null) {
                com.baidu.tbadk.core.util.aj.i(this.fdc, d.C0095d.cp_cont_e);
            }
            if (this.fcc != null) {
                com.baidu.tbadk.core.util.aj.c(this.fcc, BitmapHelper.getGradeResourceIdInEnterForum(this.fdS));
            }
            this.fdY.onChangeSkinType(i);
            if (this.fdA != null) {
                this.fdA.onChangeSkinType();
            }
            if (this.fdV != null) {
                com.baidu.tbadk.core.util.aj.i(this.fdV, d.C0095d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVJ = gVar;
        this.fcB.setOnImageClickListener(this.aVJ);
        this.fdY.setOnImageClickListener(this.aVJ);
    }

    public void h(NoNetworkView.a aVar) {
        this.cFA = aVar;
        if (this.ctj != null) {
            this.ctj.a(this.cFA);
        }
    }

    public void jV(boolean z) {
        this.fcB.setIsFromCDN(z);
    }

    public Button aWA() {
        return this.fda;
    }

    public void aWB() {
        if (this.fbN != 2) {
            this.fbS.setNextPage(this.cMh);
            this.fbN = 2;
        }
    }

    public void aWC() {
        if (com.baidu.tbadk.k.r.GB().GC()) {
            int lastVisiblePosition = this.fbS.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fbS.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog = tbImageView.getPerfLog();
                                perfLog.fr(1001);
                                perfLog.aKq = true;
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
                        perfLog2.aKq = true;
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

    public boolean aWD() {
        return this.IS != null && this.IS.getVisibility() == 0;
    }

    public void jW(boolean z) {
        if (this.fdb != null) {
            jU(this.eVu.aSM().DI());
            if (this.fcZ) {
                jL(z);
            } else {
                jM(z);
            }
        }
    }

    public void aWE() {
        if (this.fdb != null) {
            this.fdb.setVisibility(8);
            this.fdg = false;
            if (this.fdA != null) {
                this.fdA.setVisibility(8);
                jQ(false);
            }
            aWT();
        }
    }

    public void showLoadingDialog() {
        if (this.ckn == null) {
            this.ckn = new com.baidu.tbadk.core.view.b(this.eVu.getPageContext());
        }
        this.ckn.aE(true);
    }

    public void XC() {
        if (this.ckn != null) {
            this.ckn.aE(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fbS.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fbS.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fbI != null) {
            this.fbI.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.eud = getScrollY();
            this.fdz.feG = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fdz));
            a(this.fdz.feG, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fbI != null) {
            this.fbI.b(absListView, i);
        }
        int headerViewsCount = (i - this.fbS.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fcB.pV(headerViewsCount) == com.baidu.tieba.pb.data.l.eQh) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fbS.getHeaderViewsCount();
        if (this.fbW != null && this.fbO != null) {
            this.fbO.f(this.fbW.getBottom(), this.fbW.getMeasuredHeight(), z2);
        }
        this.fcB.aTX().j(z, this.fds != null ? this.fds.getMeasuredHeight() : 0);
        this.fdz.eKZ = i;
        this.fdz.feF = this.fbS.getHeaderViewsCount();
        this.fdz.feG = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fdz));
        a(this.fdz.feG, false);
    }

    public void aWF() {
        if (this.eVu.isLogin() && this.eYp != null && this.fdP && !this.fdO && !this.fcX && this.fdk != null && this.fdk.rv() != null && !this.fdk.rv().getIsLike() && !this.fdk.rv().hadConcerned()) {
            if (this.fdL == null) {
                this.fdL = new am(this.eVu);
            }
            this.fdL.a(this.fbO.fgM, this.eYp.aRO(), this.fdk.rv().getUserId(), this.eYp.getThreadId());
        }
    }

    public void aWG() {
        if (this.fdP && !this.fdO && this.fdk != null && this.fdk.rv() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").r("obj_locate", this.eVu.aTD() ? 2 : 1).r("obj_type", this.fdO ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eVu.getPageContext().getPageActivity(), this.fdk.rv().getUserId(), this.fdk.rv().getUserName(), this.eVu.aSx().aUm(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(ak akVar, boolean z) {
        int measuredHeight;
        if (!this.fdO && this.fdt != null && this.fbO.aXj() != null) {
            int aTU = this.fcB.aTU();
            if (aTU > 0 && (akVar == null || akVar.getView().getParent() == null)) {
                if (aTU > this.fbS.getFirstVisiblePosition() - this.fbS.getHeaderViewsCount()) {
                    this.fdt.setVisibility(8);
                    return;
                }
                this.fdt.setVisibility(0);
                this.fbO.mNavigationBar.hideBottomLine();
            } else if (akVar == null || akVar.getView() == null || akVar.fbf == null) {
                if (this.fbS.getFirstVisiblePosition() == 0) {
                    this.fdt.setVisibility(8);
                    this.fbO.mNavigationBar.showBottomLine();
                }
            } else {
                int top = akVar.getView().getTop();
                if (akVar.getView().getParent() != null) {
                    if (this.fdy) {
                        this.fdx = top;
                        this.fdy = false;
                    }
                    this.fdx = top < this.fdx ? top : this.fdx;
                }
                if (top != 0 || akVar.getView().isShown()) {
                    if (this.fcA.getY() < 0.0f) {
                        measuredHeight = fdw - akVar.fbf.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fbO.aXj().getMeasuredHeight() - akVar.fbf.getMeasuredHeight();
                        this.fbO.mNavigationBar.hideBottomLine();
                    }
                    if (akVar.getView().getParent() == null && top <= this.fdx) {
                        this.fdt.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fdt.setVisibility(0);
                    } else {
                        this.fdt.setVisibility(8);
                        this.fbO.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fdy = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public int eKZ;
        public int feF;
        public ak feG;

        public a() {
        }
    }

    public void aWH() {
        if (!this.fer) {
            TiebaStatic.log("c10490");
            this.fer = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVu.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fdD, Integer.valueOf(fdF));
            aVar.cc(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.v(inflate);
            aVar.z(sparseArray);
            aVar.a(d.j.grade_button_tips, this.eVu);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eVu.getPageContext()).th();
        }
    }

    public void pU(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVu.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.v(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fdD, Integer.valueOf(fdG));
        aVar.z(sparseArray);
        aVar.a(d.j.view, this.eVu);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ar.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.eVu.getPageContext()).th();
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

    public PbInterviewStatusView aWI() {
        return this.fdp;
    }

    private void t(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aRq() != null && fVar.aRq().so() && this.fdp == null) {
            this.fdp = (PbInterviewStatusView) this.fdo.inflate();
            this.fdp.setOnClickListener(this.cIN);
            this.fdp.setCallback(this.eVu.aTy());
            this.fdp.c(this.eVu, fVar);
        }
    }

    public LinearLayout aWJ() {
        return this.fcA;
    }

    public View aWK() {
        return this.cJa;
    }

    public boolean aWL() {
        return this.fec;
    }

    public void jd(boolean z) {
        this.fbX.jd(z);
    }

    private void aWM() {
        if (this.fec) {
            if (this.fed == null) {
                e.a aVar = e.eSP.get();
                if (aVar != null) {
                    this.fed = aVar.a(this.eVu);
                    ListAdapter adapter = this.fbS.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.ayb) {
                            this.fbS.addHeaderView(this.fed.aSJ(), 1);
                        } else {
                            this.fbS.addHeaderView(this.fed.aSJ(), 0);
                        }
                    }
                } else {
                    this.fbW.setVisibility(0);
                    return;
                }
            }
            this.fbW.setVisibility(8);
            this.fbS.removeHeaderView(this.fbW);
            return;
        }
        this.fbW.setVisibility(0);
    }

    public void jX(boolean z) {
        this.fec = z;
    }

    public void aWN() {
        this.eVu.showNetRefreshView(getView(), "");
        View EU = this.eVu.getRefreshView().EU();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EU.getLayoutParams();
        layoutParams.addRule(3, aWJ().getId());
        EU.setLayoutParams(layoutParams);
        this.eVu.hideLoadingView(getView());
        if (this.fed != null) {
            this.fbS.removeHeaderView(this.fed.aSJ());
            this.fed = null;
        }
    }

    public void pV(String str) {
        if (this.fbP != null) {
            this.fbP.setTitle(str);
        }
    }

    private int jY(boolean z) {
        if (this.fdp == null || this.fdp.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void aWO() {
        if (this.fdp != null && this.fdp.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fdp.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fdp.setLayoutParams(layoutParams);
        }
    }

    public boolean aSS() {
        return false;
    }

    public TextView aWP() {
        return this.fcj;
    }

    public void pW(String str) {
        this.fdc.performClick();
        if (!StringUtils.isNull(str) && this.eVu.aSM() != null && this.eVu.aSM().DC() != null && this.eVu.aSM().DC().getInputView() != null) {
            EditText inputView = this.eVu.aSM().DC().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            aWx();
            if (configuration.orientation == 2) {
                aWE();
                aVL();
            } else {
                aVO();
            }
            if (this.fdK != null) {
                this.fdK.aUb();
            }
            this.eVu.alC();
            this.fcA.setVisibility(8);
            this.fbO.setTitleVisibility(false);
            this.eVu.jj(false);
            if (this.fbI != null) {
                if (configuration.orientation == 1) {
                    aWJ().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fbS.setIsLandscape(true);
                    this.fbS.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fbS.setIsLandscape(false);
                    if (this.eud > 0) {
                        this.fbS.smoothScrollBy(this.eud, 0);
                    }
                }
                this.fbI.onConfigurationChanged(configuration);
            }
        }
    }

    public void jZ(boolean z) {
        this.fbM = z;
    }

    public boolean aWQ() {
        return this.fbI != null && this.fbI.aWQ();
    }

    public void aWR() {
        if (this.fbI != null) {
            this.fbI.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fbK != null) {
            this.fbK.y(j, i);
        }
        if (this.fbI != null) {
            this.fbI.y(j, i);
        }
    }

    public void jo(boolean z) {
        this.fcB.jo(z);
    }

    public void aWS() {
        if (this.fdq == null) {
            LayoutInflater.from(this.eVu.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.ctl, true);
            this.fdq = (ViewGroup) this.ctl.findViewById(d.g.add_experienced_layout);
            this.fdr = (TextView) this.ctl.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.i(this.fdr, d.C0095d.cp_cont_i);
            String string = this.eVu.getResources().getString(d.j.experienced_add_success);
            String string2 = this.eVu.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0095d.cp_cont_h)));
            this.fdr.setText(spannableString);
        }
        this.fdq.setVisibility(0);
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
                        ar.this.fdq.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                ar.this.fdr.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fdr.startAnimation(scaleAnimation);
    }

    public void bn(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fdb.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.eVu);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fdV = new TextView(this.eVu);
            this.fdV.setText(d.j.connection_tips);
            this.fdV.setGravity(17);
            this.fdV.setPadding(com.baidu.adp.lib.util.l.f(this.eVu, d.e.ds24), 0, com.baidu.adp.lib.util.l.f(this.eVu, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.f(this.eVu, d.e.ds60);
            frameLayout.addView(this.fdV, layoutParams);
            this.fdU = new PopupWindow(this.eVu);
            this.fdU.setContentView(frameLayout);
            this.fdU.setHeight(-2);
            this.fdU.setWidth(-2);
            this.fdU.setFocusable(true);
            this.fdU.setOutsideTouchable(false);
            this.fdU.setBackgroundDrawable(new ColorDrawable(this.eVu.getResources().getColor(d.C0095d.transparent)));
            this.fbS.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ar.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ar.this.fdU.showAsDropDown(ar.this.fdb, view.getLeft(), -ar.this.fdb.getHeight());
                    } else {
                        ar.this.fdU.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.aXc() != null && !StringUtils.isNull(aVar.aXc().pkg_id) && !StringUtils.isNull(aVar.aXc().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fdd != null && this.fdd.getVisibility() == 0) {
            if (this.fdT == null) {
                View inflate = LayoutInflater.from(this.eVu.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.cIN);
                this.fdT = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fdd.getLocationInWindow(iArr);
            this.fdT.showAtLocation(this.fdd, 0, iArr[0] - com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fdd.getHeight()) - com.baidu.adp.lib.util.l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void aWT() {
        com.baidu.adp.lib.g.g.a(this.fdT);
    }

    public void setIsInterviewLive(boolean z) {
        this.fea = z;
    }

    public boolean getIsInterviewLive() {
        return this.fea;
    }

    public void bo(View view) {
        this.fcS = view;
    }
}
